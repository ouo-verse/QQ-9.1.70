package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class u extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {
    private TextView C;
    private stSimpleMetaFeed D;
    private au E;

    public u(Context context, au auVar) {
        super(context);
        this.E = auVar;
    }

    private boolean u(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.startsWith(str2);
    }

    private boolean v(stVideoTag stvideotag) {
        WSVerticalPageFragment wSVerticalPageFragment;
        au auVar = this.E;
        return auVar != null && (wSVerticalPageFragment = auVar.f82128e) != null && stvideotag.tagId == 6 && TextUtils.equals(wSVerticalPageFragment.getFrom(), "recommend_tab") && d() == 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 == null || c16.e() == null) {
            return;
        }
        this.D = c16.e();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        stVideoTag stvideotag;
        String str;
        String str2;
        stSimpleMetaFeed stsimplemetafeed = this.D;
        if (stsimplemetafeed != null && (stvideotag = stsimplemetafeed.videoTag) != null && !TextUtils.isEmpty(stvideotag.text) && !v(stvideotag)) {
            l(0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(ba.f81730e);
            if (u(stvideotag.bgColor, "#")) {
                str = stvideotag.bgColor;
            } else {
                str = "#" + stvideotag.bgColor;
            }
            if (!ba.w(str)) {
                str = "#80000000";
            }
            gradientDrawable.setColor(Color.parseColor(str));
            this.C.setText(stvideotag.text);
            if (u(stvideotag.textColor, "#")) {
                str2 = stvideotag.textColor;
            } else {
                str2 = "#" + stvideotag.textColor;
            }
            TextView textView = this.C;
            if (!ba.w(str2)) {
                str2 = "#FFFFFF";
            }
            textView.setTextColor(Color.parseColor(str2));
            this.C.setBackgroundDrawable(gradientDrawable);
            return;
        }
        l(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwv;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (TextView) p(R.id.f11696706);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
