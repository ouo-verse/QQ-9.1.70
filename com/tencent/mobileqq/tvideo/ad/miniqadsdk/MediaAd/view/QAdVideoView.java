package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdCountDownView;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import pw2.n;
import pw2.s;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdVideoView extends QAdBaseVideoView {

    /* renamed from: j0, reason: collision with root package name */
    private static final String f303707j0 = "QAdVideoView";

    /* renamed from: i0, reason: collision with root package name */
    private TextView f303708i0;

    public QAdVideoView(@NonNull Context context) {
        super(context);
    }

    private void l0(InsideVideoSkipAdInfo insideVideoSkipAdInfo, AdInsideVideoItem adInsideVideoItem) {
        View findViewById = findViewById(R.id.f74873xf);
        this.f303686d = findViewById;
        if (!(findViewById instanceof LinearLayout)) {
            return;
        }
        QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
        if (qAdBaseCountDownView != null && qAdBaseCountDownView.getParent() != null) {
            ((LinearLayout) this.f303686d).removeView(this.f303688e);
        }
        String str = f303707j0;
        n.e(str, "initAdCountDownViewInner: QAdCountDownView");
        if (insideVideoSkipAdInfo != null && insideVideoSkipAdInfo.enableMultiTrueViewAd) {
            n.e(str, "initAdCountDownViewInner: QAdMultiTrueViewAdCountDownView");
            this.f303688e = new QAdMultiTrueViewAdCountDownView(this.f303696m);
        } else {
            n.e(str, "initAdCountDownViewInner: QAdCountDownView");
            this.f303688e = new QAdCountDownView(this.f303696m);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = s.a(8.5f);
        ((LinearLayout) this.f303686d).addView(this.f303688e, 0, layoutParams);
    }

    private void m0() {
        this.f303693h = (FrameLayout) findViewById(R.id.bhd);
        this.f303690f = findViewById(R.id.ta9);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView
    public void A(InsideVideoSkipAdInfo insideVideoSkipAdInfo, AdInsideVideoItem adInsideVideoItem) {
        super.A(insideVideoSkipAdInfo, adInsideVideoItem);
        l0(this.F, adInsideVideoItem);
        QAdBaseCountDownView qAdBaseCountDownView = this.f303688e;
        if (qAdBaseCountDownView != null) {
            qAdBaseCountDownView.m(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView
    public void D(Context context) {
        setId(R.id.f29840mq);
        this.f303696m = context;
        View.inflate(context, R.layout.fsp, this);
        m0();
        super.D(context);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView
    public void f0(long j3, long j16) {
        QAdBaseCountDownView qAdBaseCountDownView;
        if (this.F != null && (qAdBaseCountDownView = this.f303688e) != null) {
            int i3 = (int) (j3 / 1000);
            qAdBaseCountDownView.l(i3, (int) (j16 / 1000));
            InsideVideoSkipAdInfo insideVideoSkipAdInfo = this.F;
            if (!insideVideoSkipAdInfo.enableSkip) {
                return;
            }
            if (i3 < insideVideoSkipAdInfo.skipAdDuration) {
                this.Q = false;
            } else {
                this.Q = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        View view = this.f303686d;
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (y.k(this.f303696m)) {
            marginLayoutParams.topMargin = s.a(31.0f);
        } else {
            marginLayoutParams.topMargin = s.a(8.0f);
        }
        this.f303686d.setLayoutParams(marginLayoutParams);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView
    protected TextView r() {
        if (this.f303708i0 == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.scf);
            if (viewStub == null) {
                return null;
            }
            this.f303708i0 = (TextView) viewStub.inflate().findViewById(R.id.sce);
        }
        return this.f303708i0;
    }

    public QAdVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
