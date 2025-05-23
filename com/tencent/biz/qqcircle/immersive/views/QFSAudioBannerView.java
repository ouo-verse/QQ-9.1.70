package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAudioBannerView extends QFSAudioView {

    /* renamed from: f, reason: collision with root package name */
    private QFSImageBanner f90303f;

    public QFSAudioBannerView(@NonNull Context context) {
        super(context);
    }

    public void setBanner(QFSImageBanner qFSImageBanner) {
        this.f90303f = qFSImageBanner;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void setPlayRate(float f16) {
        super.setPlayRate(f16);
        QFSImageBanner qFSImageBanner = this.f90303f;
        if (qFSImageBanner != null) {
            qFSImageBanner.setPlayRate(f16);
        }
    }
}
