package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/* loaded from: classes12.dex */
public class EmotionPreviewAdapter extends BaseAdapter implements com.tencent.mobileqq.activity.photo.c {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "EmotionPreviewAdapter";
    private List<EmotionPreviewInfo> dataList;
    private int imageHeight;
    private SparseArray<URLDrawable> mActiveDrawable;
    private Context mContext;
    private Drawable mDefaultPhotoDrawable;

    public EmotionPreviewAdapter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mActiveDrawable = new SparseArray<>();
        this.mContext = context;
        this.mDefaultPhotoDrawable = context.getResources().getDrawable(R.drawable.asd);
        this.imageHeight = BaseAIOUtils.f(207.0f, this.mContext.getResources());
    }

    private URL getFileUrl(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static Bitmap zoomImg(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / width, i16 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public int getBitmapWidth(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).intValue();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return Math.min(Math.max(options.outWidth, options.outHeight), this.imageHeight);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        List<EmotionPreviewInfo> list = this.dataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        URLDrawable uRLDrawable;
        int status;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
        } else if (view != null) {
            view2 = view;
        } else {
            URLImageView uRLImageView = new URLImageView(this.mContext);
            EmotionPreviewInfo item = getItem(i3);
            if (item != null && !TextUtils.isEmpty(item.path)) {
                URLDrawable uRLDrawable2 = this.mActiveDrawable.get(i3);
                if (uRLDrawable2 != null) {
                    uRLImageView.setImageDrawable(uRLDrawable2);
                } else {
                    File file = new File(item.path);
                    if (file.exists()) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        int i16 = this.imageHeight;
                        obtain.mRequestWidth = i16;
                        obtain.mRequestHeight = i16;
                        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                        obtain.mFailedDrawable = this.mDefaultPhotoDrawable;
                        obtain.mPlayGifImage = true;
                        URL fileUrl = getFileUrl(file);
                        if (fileUrl != null) {
                            uRLDrawable = URLDrawable.getDrawable(fileUrl, obtain);
                            if (uRLDrawable != null && (status = uRLDrawable.getStatus()) != 1 && status != 2 && status != 3) {
                                uRLDrawable.setTag(1);
                                uRLDrawable.startDownload();
                            }
                        } else {
                            uRLDrawable = null;
                        }
                        if (uRLDrawable != null) {
                            uRLImageView.setImageDrawable(uRLDrawable);
                            this.mActiveDrawable.put(i3, uRLDrawable);
                        } else {
                            uRLImageView.setImageDrawable(this.mDefaultPhotoDrawable);
                        }
                    } else {
                        uRLImageView.setImageDrawable(this.mDefaultPhotoDrawable);
                    }
                }
                uRLImageView.setContentDescription("\u7167\u7247" + i3);
                view2 = uRLImageView;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getView Path is empty. position " + i3 + ", size " + getCount());
                }
                uRLImageView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                view2 = uRLImageView;
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public View onCreateView(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, viewGroup);
        }
        URLDrawable uRLDrawable = this.mActiveDrawable.get(i3);
        if (uRLDrawable != null) {
            if (uRLDrawable.getStatus() == 3) {
                uRLDrawable.restartDownload();
            }
        } else {
            EmotionPreviewInfo item = getItem(i3);
            if (item != null && !TextUtils.isEmpty(item.path)) {
                File file = new File(item.path);
                if (file.exists()) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    int i16 = this.imageHeight;
                    obtain.mRequestWidth = i16;
                    obtain.mRequestHeight = i16;
                    obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    obtain.mPlayGifImage = true;
                    URL fileUrl = getFileUrl(file);
                    if (fileUrl != null) {
                        URLDrawable drawable = URLDrawable.getDrawable(fileUrl, obtain);
                        drawable.setTag(1);
                        drawable.startDownload();
                        this.mActiveDrawable.put(i3, drawable);
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "onCreateView Path is empty. position " + i3 + ", size " + getCount());
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onDestroyView(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), view, viewGroup);
            return;
        }
        URLDrawable uRLDrawable = this.mActiveDrawable.get(i3);
        if (uRLDrawable != null) {
            if (uRLDrawable.getStatus() == 0) {
                uRLDrawable.cancelDownload(true);
            }
            this.mActiveDrawable.remove(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), view, regionDrawableData);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onSlot(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onViewDetached(int i3, View view, ViewGroup viewGroup, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.c
    public void onscaleBegin(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), view, viewGroup);
        }
    }

    public void refreshData(List<EmotionPreviewInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.dataList = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public EmotionPreviewInfo getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EmotionPreviewInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        List<EmotionPreviewInfo> list = this.dataList;
        if (list == null || i3 >= list.size()) {
            return null;
        }
        return this.dataList.get(i3);
    }
}
