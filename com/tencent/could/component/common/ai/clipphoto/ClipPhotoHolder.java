package com.tencent.could.component.common.ai.clipphoto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.could.component.common.ai.utils.ImageCompressUtils;
import com.tencent.could.component.common.ai.utils.ThreadPoolUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.File;

/* loaded from: classes5.dex */
public class ClipPhotoHolder {
    static IPatchRedirector $redirector_ = null;
    private static final int COMPASS_IMAGE_MAX_SIZE = 1024;
    private static final int REQUEST_CODE_CLIP_PHOTO = 3000;
    private static final int REQUEST_CODE_SELECT_PHOTO = 2000;
    private static final String TAG = "ClipPhotoHolder";
    private File cacheCropFile;
    private int compassImageSize;
    private int compressLevel;
    private boolean isNeedClip;
    private boolean isReturnOnlyUri;
    private ClipPhotoEventListener listener;
    private Point minPhotoSize;
    private Uri uriTempFile;

    public ClipPhotoHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isReturnOnlyUri = false;
        this.compassImageSize = 1024;
        this.compressLevel = 1;
        this.minPhotoSize = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] compressFromBitMapCheckDegree(Activity activity) {
        int i3;
        String path = ImageCompressUtils.getPath(activity, this.uriTempFile);
        if (!TextUtils.isEmpty(path)) {
            i3 = ImageCompressUtils.getBitmapDegree(path);
        } else {
            i3 = 0;
        }
        Point point = this.minPhotoSize;
        if (point != null && (i3 == 90 || i3 == 270)) {
            Point point2 = this.minPhotoSize;
            point = new Point(point2.y, point2.x);
        }
        Bitmap rotateBitmapByDegree = ImageCompressUtils.rotateBitmapByDegree(ImageCompressUtils.createBitMapByUri(activity, this.uriTempFile, this.compressLevel, point), i3);
        byte[] compressBitmap = ImageCompressUtils.compressBitmap(rotateBitmapByDegree, this.compassImageSize, this.compressLevel);
        if (rotateBitmapByDegree != null) {
            rotateBitmapByDegree.recycle();
        }
        return compressBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] compressFromBitMapDoNotNeedCheckDegree(Activity activity) {
        Bitmap createBitMapByUri = ImageCompressUtils.createBitMapByUri(activity, this.uriTempFile, this.compressLevel, this.minPhotoSize);
        byte[] compressBitmap = ImageCompressUtils.compressBitmap(createBitMapByUri, this.compassImageSize, this.compressLevel);
        if (createBitMapByUri != null) {
            createBitMapByUri.recycle();
        }
        return compressBitmap;
    }

    private void dealWithAfterClipPhoto(Activity activity, boolean z16) {
        ClipPhotoEventListener clipPhotoEventListener = this.listener;
        if (clipPhotoEventListener != null) {
            clipPhotoEventListener.doStartCompressImage();
        }
        ThreadPoolUtil.getInstance().addWork(new Runnable(z16, activity) { // from class: com.tencent.could.component.common.ai.clipphoto.ClipPhotoHolder.1
            static IPatchRedirector $redirector_;
            public final /* synthetic */ Activity val$activity;
            public final /* synthetic */ boolean val$isDataFromSysClip;

            {
                this.val$isDataFromSysClip = z16;
                this.val$activity = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ClipPhotoHolder.this, Boolean.valueOf(z16), activity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] compressFromBitMapDoNotNeedCheckDegree;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (ClipPhotoHolder.this.uriTempFile == null) {
                        ClipPhotoHolder.this.sendClipDismissPhotoError("get image data is null\uff01");
                        return;
                    }
                    try {
                        compressFromBitMapDoNotNeedCheckDegree = this.val$isDataFromSysClip ? ClipPhotoHolder.this.compressFromBitMapDoNotNeedCheckDegree(this.val$activity) : ClipPhotoHolder.this.compressFromBitMapCheckDegree(this.val$activity);
                    } catch (Exception e16) {
                        Log.e(ClipPhotoHolder.TAG, "e: " + e16.getLocalizedMessage());
                        ClipPhotoHolder.this.sendClipDismissPhotoError("clip error!");
                    }
                    if (compressFromBitMapDoNotNeedCheckDegree == null) {
                        ClipPhotoHolder.this.sendClipDismissPhotoError("clip error! bitmapBytes is null");
                    } else {
                        ClipPhotoHolder.this.sendSelectImageStr(Base64.encodeToString(compressFromBitMapDoNotNeedCheckDegree, 2));
                    }
                } finally {
                    FileUtils.deleteFile(ClipPhotoHolder.this.cacheCropFile);
                }
            }
        });
    }

    private void dealWithSelectPhotos(Activity activity, Intent intent) {
        ClipPhotoEventListener clipPhotoEventListener;
        if (intent == null) {
            Log.e(TAG, "user cancel select photo!");
            sendClipDismissPhotoError("user cancel select photo!");
            return;
        }
        if (!this.isNeedClip) {
            if (this.isReturnOnlyUri && (clipPhotoEventListener = this.listener) != null) {
                clipPhotoEventListener.getSelectPhotoUri(intent.getData());
                return;
            } else {
                sendOnlySelectPhoto(activity, intent);
                return;
            }
        }
        File createImageFile = FileUtils.createImageFile(activity, true);
        this.cacheCropFile = createImageFile;
        if (createImageFile != null) {
            Intent intent2 = new Intent("com.android.camera.action.CROP");
            intent2.addFlags(1);
            intent2.addFlags(2);
            intent2.putExtra(QQWinkConstants.TAB_CROP, "true");
            intent2.putExtra("scale ", true);
            intent2.putExtra("return-data", false);
            intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            intent2.setDataAndType(intent.getData(), "image/*");
            if (Build.VERSION.SDK_INT >= 30) {
                Uri uri = FileUtils.uri;
                this.uriTempFile = uri;
                intent2.putExtra("output", uri);
            } else {
                Uri fromFile = Uri.fromFile(this.cacheCropFile);
                this.uriTempFile = fromFile;
                intent2.putExtra("output", fromFile);
            }
            try {
                activity.startActivityForResult(intent2, 3000);
            } catch (Exception e16) {
                Log.e(TAG, "start clip error: " + e16.getLocalizedMessage());
                sendOnlySelectPhoto(activity, intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendClipDismissPhotoError(String str) {
        ClipPhotoEventListener clipPhotoEventListener = this.listener;
        if (clipPhotoEventListener != null) {
            clipPhotoEventListener.sendClipPhotoError(str);
        }
    }

    private void sendOnlySelectPhoto(Activity activity, Intent intent) {
        this.uriTempFile = intent.getData();
        dealWithAfterClipPhoto(activity, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSelectImageStr(String str) {
        ClipPhotoEventListener clipPhotoEventListener = this.listener;
        if (clipPhotoEventListener != null) {
            clipPhotoEventListener.sendBitmapWithBase64(str);
        }
    }

    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (activity == null) {
            Log.e(TAG, "onActivityResult: activity is null");
            return;
        }
        if (i3 == 2000) {
            if (i16 == -1) {
                dealWithSelectPhotos(activity, intent);
            } else {
                Log.e(TAG, "select photo error code: " + i3);
                sendClipDismissPhotoError("select photo error code: " + i16);
            }
        }
        if (i3 == 3000) {
            if (i16 == -1) {
                dealWithAfterClipPhoto(activity, true);
                return;
            }
            Log.e(TAG, "clip error code: " + i16);
            sendClipDismissPhotoError("clip error code: " + i16);
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.listener != null) {
            this.listener = null;
        }
    }

    public void setClipPhotoEventListener(ClipPhotoEventListener clipPhotoEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) clipPhotoEventListener);
        } else {
            this.listener = clipPhotoEventListener;
        }
    }

    public void setCompressImageSize(Point point) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) point);
        } else {
            this.minPhotoSize = point;
        }
    }

    public void setCompressLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.compressLevel = i3;
        }
    }

    public void setReturnOnlyUri(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isReturnOnlyUri = z16;
        }
    }

    public void startSelectAlbum(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            startSelectAlbum(activity, z16, 1024);
        } else {
            iPatchRedirector.redirect((short) 7, this, activity, Boolean.valueOf(z16));
        }
    }

    public void startSelectAlbum(Activity activity, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (activity == null) {
            Log.e(TAG, "start activity is null!");
            sendClipDismissPhotoError("activity is null");
            return;
        }
        this.compassImageSize = i3;
        this.isNeedClip = z16;
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 30) {
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
        } else {
            intent.setAction("android.intent.action.PICK");
        }
        intent.setType("image/*");
        activity.startActivityForResult(intent, 2000);
    }
}
