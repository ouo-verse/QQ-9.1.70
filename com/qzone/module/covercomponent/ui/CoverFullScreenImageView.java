package com.qzone.module.covercomponent.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.qzone.module.covercomponent.manage.CoverCacheManager;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.module.covercomponent.utils.QzoneCoverFullScreenImageProcessor;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverFullScreenImageView extends AsyncImageView {

    /* renamed from: d, reason: collision with root package name */
    private CoverCacheData f48657d;

    public CoverFullScreenImageView(Context context) {
        super(context);
        init();
    }

    private void f() {
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(this.f48657d.type)) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
            setAsyncImageProcessor(new QzoneCoverFullScreenImageProcessor(null));
            setAsyncImage(CoverCacheManager.getRightCoverUrl(this.f48657d));
            CoverLog.i("CoverFullScreenImageView updateImage", CoverLog.USR, "updateImage url:" + CoverCacheManager.getRightCoverUrl(this.f48657d));
            return;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER.equals(this.f48657d.type)) {
            String imageUrl = getImageUrl();
            String str = this.f48657d.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FULL_SCREEN_URL);
            if (TextUtils.isEmpty(imageUrl) || !imageUrl.equals(str)) {
                setScaleType(ImageView.ScaleType.CENTER_CROP);
                setAsyncImageProcessor(new QzoneCoverFullScreenImageProcessor(this.f48657d.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FULL_SCREEN_ALIGN)));
                setAsyncImage(str);
            }
        }
    }

    private void init() {
        setAsyncImageListener(new AsyncImageable.AsyncImageListener() { // from class: com.qzone.module.covercomponent.ui.CoverFullScreenImageView.1
            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageFailed(AsyncImageable asyncImageable) {
                CoverEnv.showToast("\u80cc\u666f\u8d44\u6e90\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                CoverLog.i("CoverFullScreenImageView", CoverLog.USR, "full Cover onImageFailed failed, url:" + CoverFullScreenImageView.this.getFailedImageUrl());
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                CoverFullScreenImageView.this.setBackgroundColor(0);
                CoverLog.i("CoverFullScreenImageView", CoverLog.USR, "full Cover onImageLoaded, url:" + CoverFullScreenImageView.this.getFailedImageUrl());
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageStarted(AsyncImageable asyncImageable) {
                CoverFullScreenImageView coverFullScreenImageView = CoverFullScreenImageView.this;
                coverFullScreenImageView.setBackgroundColor(coverFullScreenImageView.getResources().getColor(CoverHelper.getResId(6)));
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            }
        });
        setDecodeConfig(Bitmap.Config.RGB_565);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void onStart() {
        f();
    }

    public void setCurrentCacheData(CoverCacheData coverCacheData) {
        this.f48657d = coverCacheData;
        f();
    }

    public CoverFullScreenImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public CoverFullScreenImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }

    public void onDestory() {
    }
}
