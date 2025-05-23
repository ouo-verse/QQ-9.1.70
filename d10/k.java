package d10;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class k extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    public TextView C;
    private stVideoTag D;

    public k(Context context) {
        super(context);
    }

    private void u() {
        String str;
        String str2;
        stVideoTag stvideotag = this.D;
        if (stvideotag != null && !TextUtils.isEmpty(stvideotag.text)) {
            this.C.setText(stvideotag.text);
            if (!TextUtils.isEmpty(stvideotag.textColor) && stvideotag.textColor.startsWith("#")) {
                str = stvideotag.textColor;
            } else {
                str = "#" + stvideotag.textColor;
            }
            TextView textView = this.C;
            if (!ba.w(str)) {
                str = "#FFFFFF";
            }
            textView.setTextColor(Color.parseColor(str));
            if (!TextUtils.isEmpty(stvideotag.bgColor) && stvideotag.bgColor.startsWith("#")) {
                str2 = stvideotag.bgColor;
            } else {
                str2 = "#" + stvideotag.bgColor;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(ba.f81730e);
            gradientDrawable.setStroke(ba.f81727b, Color.parseColor("#4CFFFFFF"));
            if (!ba.w(str2)) {
                str2 = "#80000000";
            }
            gradientDrawable.setColor(Color.parseColor(str2));
            this.C.setBackgroundDrawable(gradientDrawable);
            this.C.setVisibility(0);
            return;
        }
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        this.D = c().videoTag;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        u();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fxl;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (TextView) p(R.id.f165871xx3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
