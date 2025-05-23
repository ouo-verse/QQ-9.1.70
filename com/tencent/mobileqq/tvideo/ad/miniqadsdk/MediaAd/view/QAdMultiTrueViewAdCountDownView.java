package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoPoster;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdMultiTrueViewAdCountDownView extends QAdBaseCountDownView {
    public QAdMultiTrueViewAdCountDownView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void e(Context context) {
        LayoutInflater.from(context).inflate(r(), this);
        this.f303718i = (TextView) findViewById(R.id.f109016eo);
        this.f303714d = (TextView) findViewById(R.id.ygb);
        this.f303715e = findViewById(R.id.f111186kj);
        this.f303716f = (TextView) findViewById(R.id.f111386l3);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void k(AdInsideVideoPoster adInsideVideoPoster, int i3, boolean z16, boolean z17) {
        if (adInsideVideoPoster == null) {
            return;
        }
        if (TextUtils.isEmpty(adInsideVideoPoster.skipAdtitle)) {
            this.f303715e.setVisibility(8);
            this.f303716f.setText("");
        } else {
            this.f303715e.setVisibility(0);
            this.f303716f.setText(Html.fromHtml(adInsideVideoPoster.skipAdtitle));
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void l(int i3, int i16) {
        String str;
        InsideVideoSkipAdInfo insideVideoSkipAdInfo = this.G;
        if (insideVideoSkipAdInfo == null) {
            return;
        }
        if (!insideVideoSkipAdInfo.enableSkip) {
            j(insideVideoSkipAdInfo.skipAdDuration - i3);
            return;
        }
        int i17 = insideVideoSkipAdInfo.skipAdDuration;
        if (i3 < i17) {
            int i18 = i17 - i3;
            if (TextUtils.isEmpty(insideVideoSkipAdInfo.skipAdTitle)) {
                str = "__second____second__\u79d2\u540e\u53ef\u8df3\u8fc7\u5e7f\u544a";
            } else {
                str = this.G.skipAdTitle;
            }
            this.f303718i.setText(Html.fromHtml(str.replace("__second__", String.valueOf(i18))));
            return;
        }
        this.f303718i.setText(Html.fromHtml(insideVideoSkipAdInfo.skipAdSubtitle));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void m(InsideVideoSkipAdInfo insideVideoSkipAdInfo) {
        super.m(insideVideoSkipAdInfo);
        if (this.G == null) {
            return;
        }
        this.f303718i.setText("");
        if (!this.G.enableSkip) {
            this.f303714d.setVisibility(0);
            this.f303718i.setVisibility(8);
        } else {
            this.f303714d.setVisibility(8);
            this.f303718i.setVisibility(0);
        }
    }

    protected int r() {
        return R.layout.fss;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void setMultiTrueViewLeftTipListener(View.OnClickListener onClickListener) {
        TextView textView = this.f303718i;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void setWarnerOnClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f303716f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public QAdMultiTrueViewAdCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void setSkipTipOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    protected void n(boolean z16, int i3) {
    }
}
