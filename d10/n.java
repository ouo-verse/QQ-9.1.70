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
public class n extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private TextView C;
    private stVideoTag D;

    public n(Context context) {
        super(context);
    }

    private GradientDrawable u(stVideoTag stvideotag) {
        String str;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ba.f81730e);
        gradientDrawable.setStroke(ba.f81727b, Color.parseColor("#4CFFFFFF"));
        if (v(stvideotag.bgColor, "#")) {
            str = stvideotag.bgColor;
        } else {
            str = "#" + stvideotag.bgColor;
        }
        if (!ba.w(str)) {
            str = "#1A000000";
        }
        gradientDrawable.setColor(Color.parseColor(str));
        return gradientDrawable;
    }

    private boolean v(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.startsWith(str2);
    }

    private void w() {
        String str;
        stVideoTag stvideotag = this.D;
        if (stvideotag != null && !TextUtils.isEmpty(stvideotag.text)) {
            if (v(stvideotag.textColor, "#")) {
                str = stvideotag.textColor;
            } else {
                str = "#" + stvideotag.textColor;
            }
            this.C.setText(stvideotag.text);
            TextView textView = this.C;
            if (!ba.w(str)) {
                str = "#000000";
            }
            textView.setTextColor(Color.parseColor(str));
            this.C.setBackgroundDrawable(u(stvideotag));
            this.C.setVisibility(0);
            return;
        }
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        this.D = c().bottomTag;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        w();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fxc;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (TextView) p(R.id.f164640tb3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
