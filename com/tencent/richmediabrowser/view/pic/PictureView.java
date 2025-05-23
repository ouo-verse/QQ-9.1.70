package com.tencent.richmediabrowser.view.pic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.richmediabrowser.constant.Constants;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.pic.PictureData;
import com.tencent.richmediabrowser.model.pic.PictureModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.utils.a;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.IBrowserViewHolder;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import e04.c;
import java.io.File;
import java.net.URL;

/* loaded from: classes25.dex */
public class PictureView extends BrowserBaseView implements c {
    private static final String TAG = "AIOPictureView";
    public RelativeLayout controlViewContainer;
    public BrowserScaleView imageView;
    private Context mContext;
    private PicturePresenter picturePresenter;

    /* loaded from: classes25.dex */
    public class GalleryPictureViewHolder extends IBrowserViewHolder {
        public BrowserScaleView urlImageView;

        public GalleryPictureViewHolder() {
        }
    }

    public PictureView(Context context, PicturePresenter picturePresenter) {
        super(context, picturePresenter);
        this.mContext = context;
        this.picturePresenter = picturePresenter;
    }

    private void dealCacheImage(RichMediaBrowserInfo richMediaBrowserInfo, URLDrawable uRLDrawable) {
        int i3;
        this.imageView.setImageDrawable(uRLDrawable);
        String url = uRLDrawable.getURL().toString();
        try {
            i3 = JpegExifReader.readOrientation(uRLDrawable.getURL().getFile());
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "read exif error" + e16.getMessage());
            i3 = 0;
        }
        this.imageView.initDrawable(uRLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, a.a(i3));
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "getView(): cache url is " + url);
    }

    private boolean dealDefaultImage() {
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "dealDefaultImage()");
        this.imageView.setImageDrawable(Constants.TRANSPARENT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dealErrorImage() {
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "dealErrorImage()");
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.mzb);
        this.imageView.setImageDrawable(drawable);
        this.imageView.initDrawable(drawable, this.mScreenWidthPx, this.mScreenHeightPx, 0);
        PicturePresenter picturePresenter = this.picturePresenter;
        picturePresenter.onLoadFinish(picturePresenter.getSelectedIndex(), false);
        return true;
    }

    private URLDrawable dealLocalImage(final RichMediaBrowserInfo richMediaBrowserInfo, PictureData pictureData, int i3) {
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "dealLocalImage");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.mScreenWidthPx;
        obtain.mRequestHeight = this.mScreenHeightPx;
        obtain.mLoadingDrawable = Constants.TRANSPARENT;
        obtain.mPlayGifImage = true;
        obtain.mUseExifOrientation = false;
        obtain.mDecodeFileStrategy = 2;
        File file = new File(pictureData.filePath);
        final URLDrawable uRLDrawable = null;
        try {
            uRLDrawable = URLDrawable.getDrawable(file.toURI().toURL().toString(), obtain);
            uRLDrawable.setTag(1);
            uRLDrawable.downloadImediatly();
        } catch (Throwable th5) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "dealLocalImage URLDrawable.getDrawable failed, exception = " + th5.getMessage());
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
            updateOriginalData(richMediaBrowserInfo, pictureData.filePath, uRLDrawable, i3);
        } else {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "dealLocalImage error");
            try {
                uRLDrawable = URLDrawable.getDrawable(file.toURI().toURL().toString(), obtain);
                uRLDrawable.setTag(1);
            } catch (Throwable th6) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "dealLocalImage getDrawable failed, exception = " + th6.getMessage());
            }
            PicturePresenter picturePresenter = this.picturePresenter;
            picturePresenter.onLoadStart(picturePresenter.getSelectedIndex(), pictureData.progress);
            final String absolutePath = file.getAbsolutePath();
            this.imageView.setGalleryImageListener(new IGalleryImageListener() { // from class: com.tencent.richmediabrowser.view.pic.PictureView.1
                @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
                public void onLoadSuccessed(int i16, boolean z16) {
                    BrowserLogHelper.getInstance().getGalleryLog().d(PictureView.TAG, 4, "dealLocalImage onLoadSuccessed, isSuccess = " + z16);
                    PictureView.this.picturePresenter.onLoadFinish(i16, true);
                    if (z16) {
                        PictureView.this.updateOriginalData(richMediaBrowserInfo, absolutePath, uRLDrawable, i16);
                    } else {
                        PictureView.this.dealErrorImage();
                    }
                }

                @Override // com.tencent.richmediabrowser.listener.IGalleryImageListener
                public void onLoadDrawable(int i16, URLDrawable uRLDrawable2) {
                }
            });
        }
        return uRLDrawable;
    }

    private void downLoadImage(String str, String str2) {
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "downLoadImage url = " + str2);
        MainBrowserPresenter mainBrowserPresenter = this.picturePresenter.mainBrowserPresenter;
        if (mainBrowserPresenter != null && mainBrowserPresenter.getParamsBuilder().c() != null) {
            this.picturePresenter.mainBrowserPresenter.getParamsBuilder().c().a(str2);
        }
        this.picturePresenter.updateItemStatus(str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOriginalData(RichMediaBrowserInfo richMediaBrowserInfo, String str, URLDrawable uRLDrawable, int i3) {
        int i16;
        try {
            i16 = JpegExifReader.readOrientation(str);
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "read exif error" + e16.getMessage());
            i16 = 0;
        }
        uRLDrawable.setTag(1);
        this.picturePresenter.mActiveDrawable.put(Integer.valueOf(i3), uRLDrawable);
        this.imageView.setImageDrawable(uRLDrawable);
        this.imageView.initDrawable(uRLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, a.a(i16));
        this.picturePresenter.onLoadFinish(i3, true);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void bindView(int i3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo item = this.picturePresenter.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null) {
            if (richMediaBaseData.getType() == 1) {
                PictureData pictureData = (PictureData) item.baseData;
                PictureModel pictureModel = new PictureModel(this.picturePresenter);
                this.imageView.setPosition(i3);
                this.imageView.setImageInfo(item);
                this.imageView.setIgnoreLayout(false);
                this.imageView.setContentDescription(this.mContext.getString(R.string.f174732wn));
                URLDrawable uRLDrawable = this.picturePresenter.mActiveDrawable.get(Integer.valueOf(i3));
                if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
                    dealCacheImage(item, uRLDrawable);
                } else if (pictureModel.isPictureExisit(pictureData)) {
                    dealLocalImage(item, pictureData, i3);
                } else {
                    dealDefaultImage();
                    downLoadImage(pictureData.f365136id, pictureData.url);
                }
                this.imageView.setMainBrowserPresenter(this.picturePresenter.mainBrowserPresenter);
                GalleryPictureViewHolder galleryPictureViewHolder = new GalleryPictureViewHolder();
                galleryPictureViewHolder.urlImageView = this.imageView;
                this.mBrowserItemView.setTag(galleryPictureViewHolder);
            }
            super.bindView(i3);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView, f04.c
    public void buildComplete() {
        super.buildComplete();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView, f04.c
    public void buildParams(Intent intent) {
        super.buildParams(intent);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView, f04.c
    public void buildView() {
        super.buildView();
    }

    public void clearTheOuchCache() {
        this.picturePresenter.mActiveDrawable.clear();
    }

    public void dealImageScale(int i3, Drawable drawable, URLDrawable uRLDrawable, BrowserScaleView browserScaleView) {
        if (drawable instanceof URLDrawable) {
            URLDrawable uRLDrawable2 = (URLDrawable) drawable;
            if (uRLDrawable2.isFakeSize() && uRLDrawable == null) {
                URL url = uRLDrawable2.getURL();
                if ("file".equals(url.getProtocol()) && url.getRef() == null) {
                    String url2 = url.toString();
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mUseExifOrientation = false;
                    obtain.mUseMemoryCache = false;
                    URLDrawable drawable2 = URLDrawable.getDrawable(url2, obtain);
                    drawable2.setTag(2);
                    BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "create rawDrawable, position:" + i3);
                    if (drawable2.getStatus() == 1) {
                        browserScaleView.setIgnoreLayout(true);
                        browserScaleView.setImageDrawable(drawable2);
                        browserScaleView.setIgnoreLayout(false);
                    }
                }
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public View getView(View view, ViewGroup viewGroup) {
        if ((view instanceof RelativeLayout) && (view.getTag() instanceof GalleryPictureViewHolder)) {
            this.mBrowserItemView = (RelativeLayout) view;
            this.imageView = ((GalleryPictureViewHolder) view.getTag()).urlImageView;
        } else {
            this.mBrowserItemView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.fr8, viewGroup, false);
            initContentView();
        }
        super.getView(view, viewGroup);
        return this.mBrowserItemView;
    }

    public void initContentView() {
        RelativeLayout relativeLayout = this.mBrowserItemView;
        if (relativeLayout != null) {
            this.controlViewContainer = (RelativeLayout) relativeLayout.findViewById(R.id.u8y);
            BrowserScaleView browserScaleView = (BrowserScaleView) this.mBrowserItemView.findViewById(R.id.image);
            this.imageView = browserScaleView;
            browserScaleView.setOnItemEventListener(this);
            this.imageView.setOnLongClickListener(this);
            MainBrowserPresenter mainBrowserPresenter = this.picturePresenter.mainBrowserPresenter;
            if (mainBrowserPresenter != null) {
                this.imageView.setDoubleTapEnable(mainBrowserPresenter.getParamsBuilder().f27656f);
                this.imageView.setScaleEnable(this.picturePresenter.mainBrowserPresenter.getParamsBuilder().f27657g);
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        clearTheOuchCache();
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroy() {
        super.onDestroy();
        BrowserScaleView browserScaleView = this.imageView;
        if (browserScaleView != null) {
            browserScaleView.setOnItemEventListener(null);
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onDestroyView(int i3, View view) {
        MainBrowserPresenter mainBrowserPresenter;
        URLDrawable uRLDrawable = this.picturePresenter.mActiveDrawable.get(Integer.valueOf(i3));
        if (uRLDrawable != null) {
            if (uRLDrawable.getStatus() == 0) {
                uRLDrawable.cancelDownload(true);
            }
            this.picturePresenter.mActiveDrawable.remove(Integer.valueOf(i3));
        }
        PictureData currentPictureData = this.picturePresenter.getCurrentPictureData();
        if (currentPictureData != null && currentPictureData.status == 1 && !TextUtils.isEmpty(currentPictureData.url) && (mainBrowserPresenter = this.picturePresenter.mainBrowserPresenter) != null && mainBrowserPresenter.getParamsBuilder().c() != null) {
            this.picturePresenter.mainBrowserPresenter.getParamsBuilder().c().j(currentPictureData.url);
        }
        super.onDestroyView(i3, view);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onItemSelected(int i3) {
        bindView(i3);
        updateUI();
        super.onItemSelected(i3);
    }

    public void onScaleBegin() {
        RelativeLayout relativeLayout = this.mBrowserItemView;
        if (relativeLayout != null && (relativeLayout.getTag() instanceof GalleryPictureViewHolder)) {
            BrowserScaleView browserScaleView = ((GalleryPictureViewHolder) this.mBrowserItemView.getTag()).urlImageView;
            Drawable drawable = browserScaleView.getDrawable();
            URLDrawable uRLDrawable = browserScaleView.mDecoding;
            if ((drawable instanceof URLDrawable) && ((URLDrawable) drawable).isFakeSize() && uRLDrawable == null) {
                dealImageScale(this.picturePresenter.getCurrentPosition(), drawable, uRLDrawable, browserScaleView);
            }
        }
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        Drawable drawable = this.imageView.getDrawable();
        if (!URLDrawable.class.isInstance(drawable)) {
            return;
        }
        ((URLDrawable) drawable).updateRegionBitmap(regionDrawableData);
    }

    @Override // com.tencent.richmediabrowser.view.BrowserBaseView
    public void updateUI() {
        PictureData currentPictureData = this.picturePresenter.getCurrentPictureData();
        if (currentPictureData != null) {
            int i3 = currentPictureData.status;
            if (i3 != 0) {
                if (i3 != 1) {
                    BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "updateUI status is error, status = " + currentPictureData.status);
                } else {
                    PicturePresenter picturePresenter = this.picturePresenter;
                    picturePresenter.onLoadStart(picturePresenter.getSelectedIndex(), currentPictureData.progress);
                }
            } else {
                PicturePresenter picturePresenter2 = this.picturePresenter;
                picturePresenter2.onLoadFinish(picturePresenter2.getSelectedIndex(), true);
            }
        }
        super.updateUI();
    }

    public void updateView(int i3) {
        RichMediaBaseData richMediaBaseData;
        RelativeLayout relativeLayout;
        RichMediaBrowserInfo item = this.picturePresenter.getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null && richMediaBaseData.getType() == 1 && (relativeLayout = this.mBrowserItemView) != null && (relativeLayout.getTag() instanceof GalleryPictureViewHolder)) {
            PictureData pictureData = (PictureData) item.baseData;
            PictureModel pictureModel = new PictureModel(this.picturePresenter);
            if (!pictureData.isDownloadSuccess) {
                dealErrorImage();
                return;
            }
            if (pictureModel.isPictureExisit(pictureData)) {
                bindView(i3);
                return;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "updateView() errorCode = " + pictureData.errorCode + ", filePath = " + pictureData.filePath);
        }
    }

    @Override // e04.c
    public void onLongClickEvent() {
    }
}
