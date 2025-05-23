package com.tencent.qqmini.miniapp.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileChooserHelper {
    private static final String CAMCORDER = "camcorder";
    private static final String CAMERA = "camera";
    private static final String MICROPHONE = "microphone";
    private static final String PHOTO_PREFIX = "IMG_";
    private static final String PHOTO_SUFFIX = ".jpg";
    private static final String TAG = "FileChooserHelper";
    private static final String TYPE_ANYTHING = "*/*";
    private static final String TYPE_AUDIO = "audio/";
    private static final String TYPE_IMAGE = "image/";
    private static final String TYPE_VIDEO = "video/";
    private static final String VIDEO_PREFIX = "VID_";
    private static final String VIDEO_SUFFIX = ".mp4";
    private Uri mFileGenerationUri;
    private ValueCallback<Uri[]> mFilePathCallBackForLollipop;
    private ValueCallback<Uri> mFilePathCallback;
    private int mRequestCode;

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallbackWhenChooseFileFailed() {
        ValueCallback<Uri> valueCallback = this.mFilePathCallback;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Uri.EMPTY);
            this.mRequestCode = Integer.MIN_VALUE;
            this.mFilePathCallback = null;
            this.mFileGenerationUri = null;
        }
        ValueCallback<Uri[]> valueCallback2 = this.mFilePathCallBackForLollipop;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.mFilePathCallBackForLollipop = null;
            this.mFileGenerationUri = null;
            this.mRequestCode = Integer.MIN_VALUE;
        }
    }

    private void doCaptureCorrect(final Activity activity, final String str, String str2) {
        final ActionSheet create = ActionSheet.create(activity);
        create.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.qqmini.miniapp.util.FileChooserHelper.1
            @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnDismissListener
            public void onDismiss() {
                FileChooserHelper.this.doCallbackWhenChooseFileFailed();
            }
        });
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.qqmini.miniapp.util.FileChooserHelper.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                FileChooserHelper.this.doCallbackWhenChooseFileFailed();
            }
        });
        if (str2.equals("camera")) {
            create.addButton(activity.getString(R.string.mini_sdk_take_a_picture), 0);
            create.addButton(activity.getString(R.string.mini_sdk_file_browser_title), 0);
            create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqmini.miniapp.util.FileChooserHelper.3
                @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener
                public void onClick(View view, int i3) {
                    if (i3 == 0) {
                        FileChooserHelper.this.openCamera(activity);
                    } else if (i3 == 1) {
                        FileChooserHelper.this.openFileChooser(activity, str);
                    }
                    create.dismiss();
                }
            });
        } else if (str2.equals("camcorder")) {
            create.addButton(activity.getString(R.string.mini_sdk_send_video_by_camera), 0);
            create.addButton(activity.getString(R.string.mini_sdk_file_browser_title), 0);
            create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqmini.miniapp.util.FileChooserHelper.4
                @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener
                public void onClick(View view, int i3) {
                    if (i3 == 0) {
                        FileChooserHelper.this.openCamcorder(activity);
                    } else if (i3 == 1) {
                        FileChooserHelper.this.openFileChooser(activity, str);
                    }
                    create.dismiss();
                }
            });
        } else if (str2.equals(MICROPHONE)) {
            create.addButton(activity.getString(R.string.mini_sdk_record_sound), 0);
            create.addButton(activity.getString(R.string.mini_sdk_file_browser_title), 0);
            create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqmini.miniapp.util.FileChooserHelper.5
                @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener
                public void onClick(View view, int i3) {
                    if (i3 == 0) {
                        FileChooserHelper.this.openMicrophone(activity);
                    } else if (i3 == 1) {
                        FileChooserHelper.this.openFileChooser(activity, str);
                    }
                    create.dismiss();
                }
            });
        }
        create.show();
    }

    private String getCapture(String str, String str2) {
        if (str.contains("image/")) {
            return "camera";
        }
        if (str.contains("video/")) {
            return "camcorder";
        }
        if (str.contains("audio/")) {
            return MICROPHONE;
        }
        return str2;
    }

    private Uri[] getSelectFileUris(Intent intent) {
        Uri[] uriArr;
        if (intent == null) {
            return new Uri[0];
        }
        if (intent.getClipData() != null) {
            ClipData clipData = intent.getClipData();
            uriArr = new Uri[clipData.getItemCount()];
            int itemCount = clipData.getItemCount();
            for (int i3 = 0; i3 < itemCount; i3++) {
                uriArr[i3] = clipData.getItemAt(i3).getUri();
            }
        } else {
            uriArr = new Uri[]{intent.getData()};
        }
        QMLog.d(TAG, "getSelectFileUris fileUris:" + Arrays.toString(uriArr));
        return uriArr;
    }

    private boolean isCaptureCorrect(String str) {
        if (!"camera".equals(str) && !"camcorder".equals(str) && !MICROPHONE.equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamcorder(Activity activity) {
        String str = activity.getExternalFilesDir("") + "/photo/";
        FileUtils.checkDirAndCreate(str);
        this.mFileGenerationUri = Uri.fromFile(new File(str, VIDEO_PREFIX + System.currentTimeMillis() + ".mp4"));
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", this.mFileGenerationUri);
        intent.putExtra("android.intent.extra.videoQuality", 1);
        startActivityForResultInSafe(activity, intent, R.string.mini_sdk_camera_can_not_start);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera(Activity activity) {
        String str = activity.getExternalFilesDir("") + "/photo/";
        FileUtils.checkDirAndCreate(str);
        File file = new File(str, PHOTO_PREFIX + System.currentTimeMillis() + ".jpg");
        Intent intent = new Intent();
        this.mFileGenerationUri = FileProviderUtils.setSystemCapture(activity, file, intent);
        startActivityForResultInSafe(activity, intent, R.string.mini_sdk_camera_can_not_start);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFileChooser(Activity activity, String str) {
        openFileChooser(activity, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMicrophone(Activity activity) {
        startActivityForResultInSafe(activity, new Intent("android.provider.MediaStore.RECORD_SOUND"), R.string.mini_sdk_cant_open_sound_recorder);
    }

    private void startActivityForResultInSafe(Activity activity, Intent intent, int i3) {
        if (activity != null && intent != null && i3 > 0) {
            List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(activity.getPackageManager(), intent, 0);
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                try {
                    activity.startActivityForResult(intent, this.mRequestCode);
                    return;
                } catch (Exception e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.w(TAG, "Caution: activity for intent was queried but can't started because " + e16.getMessage());
                    }
                }
            }
            doCallbackWhenChooseFileFailed();
            MiniToast.makeText(activity, 1, i3, 0).show();
        }
    }

    public boolean doOnActivityResult(int i3, int i16, Intent intent) {
        Uri[] uriArr;
        Uri uri;
        if (this.mRequestCode == i3) {
            if (this.mFilePathCallback != null) {
                QMLog.w(TAG, "do mFilePathCallback!");
                if (-1 == i16) {
                    uri = this.mFileGenerationUri;
                    if (uri == null) {
                        if (intent != null) {
                            uri = intent.getData();
                        } else {
                            uri = Uri.EMPTY;
                        }
                    }
                } else {
                    uri = null;
                }
                this.mFilePathCallback.onReceiveValue(uri);
            } else if (this.mFilePathCallBackForLollipop != null) {
                QMLog.w(TAG, "do mFilePathCallBackForLollipop!");
                if (-1 == i16 && this.mFileGenerationUri == null) {
                    uriArr = getSelectFileUris(intent);
                } else {
                    uriArr = null;
                }
                this.mFilePathCallBackForLollipop.onReceiveValue(uriArr);
            } else {
                QMLog.w(TAG, "Caution: mFilePathCallback should not be null!");
            }
            this.mRequestCode = Integer.MIN_VALUE;
            this.mFilePathCallback = null;
            this.mFileGenerationUri = null;
            this.mFilePathCallBackForLollipop = null;
            return true;
        }
        return false;
    }

    @TargetApi(21)
    public boolean onShowFileChooser(Activity activity, int i3, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String str;
        if (activity == null || valueCallback == null) {
            return false;
        }
        this.mFilePathCallBackForLollipop = valueCallback;
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        String str2 = "";
        if (acceptTypes == null) {
            str = "";
        } else {
            str = acceptTypes[0];
        }
        if (fileChooserParams.isCaptureEnabled()) {
            str2 = "*";
        }
        showFileChooser(activity, i3, null, str, str2);
        return true;
    }

    public void showFileChooser(Activity activity, int i3, ValueCallback<Uri> valueCallback, String str, String str2) {
        String str3;
        if (activity != null) {
            if (valueCallback != null || this.mFilePathCallBackForLollipop != null) {
                if (this.mFilePathCallback != null) {
                    QMLog.w(TAG, "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
                }
                this.mRequestCode = i3;
                this.mFilePathCallback = valueCallback;
                this.mFileGenerationUri = null;
                String str4 = "";
                if (str == null) {
                    str3 = "";
                } else {
                    str3 = str.toLowerCase();
                }
                if (str2 != null) {
                    str4 = str2.toLowerCase();
                }
                if (TextUtils.isEmpty(str4)) {
                    openFileChooser(activity, str3, true);
                    return;
                }
                boolean isCaptureCorrect = isCaptureCorrect(str4);
                if (!isCaptureCorrect) {
                    str4 = getCapture(str3, str4);
                    isCaptureCorrect = true;
                }
                if (isCaptureCorrect) {
                    doCaptureCorrect(activity, str3, str4);
                } else {
                    openFileChooser(activity, str3, true);
                }
            }
        }
    }

    private void openFileChooser(Activity activity, String str, boolean z16) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (TextUtils.isEmpty(str)) {
            str = "*/*";
        }
        intent.setType(str);
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z16);
        startActivityForResultInSafe(activity, intent, R.string.mini_sdk_cant_open_file_chooser);
    }
}
