package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.tvideo.protocol.pb.SegmentRewardItem;
import java.util.Locale;
import pw2.n;
import pw2.s;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdRewardCountDownView extends BaseMidCountView {
    private volatile View C;
    private TextView D;
    private TextView E;
    private SegmentRewardItem F;
    private View.OnClickListener G;

    public QAdRewardCountDownView(Context context, SegmentRewardItem segmentRewardItem, View.OnClickListener onClickListener) {
        super(context);
        this.F = segmentRewardItem;
        this.G = onClickListener;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.BaseMidCountView
    void d() {
        View inflate = View.inflate(getContext(), R.layout.fsu, this);
        this.f303679h = (TextView) inflate.findViewById(R.id.f73813uk);
        this.D = (TextView) inflate.findViewById(R.id.f73823ul);
        this.E = (TextView) inflate.findViewById(R.id.f111186kj);
        this.C = inflate.findViewById(R.id.f73793ui);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = s.a(8.0f);
        layoutParams.rightMargin = s.a(8.0f);
        this.C.setLayoutParams(layoutParams);
        k();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.BaseMidCountView
    String f(int i3) {
        n.a("QAdMidCountDownView", "second = " + i3);
        return String.format(Locale.US, "%02d", Integer.valueOf(i3));
    }

    public void k() {
        View.OnClickListener onClickListener;
        SegmentRewardItem segmentRewardItem = this.F;
        if (segmentRewardItem != null && !TextUtils.isEmpty(segmentRewardItem.countdown_title)) {
            this.D.setText(this.F.countdown_title);
        } else {
            this.D.setVisibility(8);
            this.E.setVisibility(8);
        }
        TextView textView = this.D;
        if (textView != null && (onClickListener = this.G) != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        View view = this.C;
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (y.k(this.f303676d)) {
            marginLayoutParams.topMargin = s.a(31.0f);
        } else {
            marginLayoutParams.topMargin = s.a(8.0f);
        }
        view.setLayoutParams(marginLayoutParams);
    }
}
