package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.ona.protocol.jce.AdCustomActionButtonInfo;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdLinkInfo;
import com.tencent.qqlive.ona.protocol.jce.AdTimeLineBannerInfo;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdVideoAdDetailView extends QAdBaseVideoAdDetailView {
    public QAdVideoAdDetailView(Context context) {
        super(context);
    }

    private boolean v() {
        AdInsideVideoItem adInsideVideoItem = this.G;
        if (adInsideVideoItem != null && adInsideVideoItem.bannerType == 4) {
            return true;
        }
        return false;
    }

    private void w() {
        AdLinkInfo adLinkInfo;
        AdCustomActionButtonInfo adCustomActionButtonInfo;
        if (v() && (adLinkInfo = this.G.linkInfo) != null && (adCustomActionButtonInfo = adLinkInfo.actionButtonInfo) != null && !TextUtils.isEmpty(adCustomActionButtonInfo.title)) {
            String str = this.G.linkInfo.actionButtonInfo.title;
            this.E = str;
            this.F = str;
            return;
        }
        super.u();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView
    protected int d() {
        AdLinkInfo adLinkInfo;
        AdTimeLineBannerInfo adTimeLineBannerInfo;
        int i3 = QAdBaseVideoAdDetailView.K;
        AdInsideVideoItem adInsideVideoItem = this.G;
        if (adInsideVideoItem != null && (adLinkInfo = adInsideVideoItem.linkInfo) != null && (adTimeLineBannerInfo = adLinkInfo.timeLineBannerInfo) != null) {
            try {
                return Color.parseColor(adTimeLineBannerInfo.bannerColor);
            } catch (Exception unused) {
                n.b("QAdVideoAdDetailView", "");
                return i3;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView
    public void e(Context context) {
        View.inflate(context, R.layout.fsr, this);
        this.f303720d = (TextView) findViewById(R.id.f112996pf);
        this.f303721e = (ViewGroup) findViewById(R.id.u2h);
        super.e(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView
    public void h() {
        super.h();
        n(d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView
    public void k() {
        super.k();
        n(QAdBaseVideoAdDetailView.L);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView
    public void o() {
        super.o();
        if (v()) {
            this.f303720d.removeCallbacks(this.J);
            setDetailBgLightColor();
            this.f303720d.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseVideoAdDetailView
    public void u() {
        if (v()) {
            w();
        } else {
            super.u();
        }
    }

    public QAdVideoAdDetailView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
