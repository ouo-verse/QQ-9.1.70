package com.tencent.open.agent;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.util.t;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType$AuthItem;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CardContainer extends BaseCardContainer {
    private ImageView H;
    private ImageView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    protected AuthorityAccountView P;
    private RelativeLayout Q;
    private TextView R;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CardContainer.this.P.getLayoutParams();
            layoutParams.topMargin = intValue;
            CardContainer.this.P.setLayoutParams(layoutParams);
            CardContainer.this.requestLayout();
        }
    }

    public CardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.open.agent.BaseCardContainer
    protected void e() {
        t.e("CardContainer", "displayCoverContainer");
        if (!this.f339599i) {
            this.f339599i = true;
            this.D.setVisibility(0);
            Context context = this.f339595d;
            if (context instanceof QBaseActivity) {
                ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity) context).getWindow());
            }
            Context context2 = this.f339595d;
            if (context2 instanceof AuthorityActivity) {
                ((AuthorityActivity) context2).L2();
            } else if (context2 instanceof QuickLoginAuthorityActivity) {
                ((QuickLoginAuthorityActivity) context2).Q2();
            }
            int i3 = (int) (this.f339596e / 1.3076923f);
            i(this.E, i3, i3 - this.C.getHeight(), new a());
        }
    }

    public void l() {
        this.P.w();
    }

    public void m() {
        AuthorityAccountView authorityAccountView = this.P;
        if (authorityAccountView != null) {
            authorityAccountView.c();
        }
    }

    public boolean n(SdkAuthorize$GetAuthApiListResponse sdkAuthorize$GetAuthApiListResponse, String str) {
        int i3;
        boolean z16;
        String str2;
        this.f339597f.clear();
        List<appType$AuthItem> list = sdkAuthorize$GetAuthApiListResponse.authorized_form_list.get();
        StringBuilder sb5 = new StringBuilder(list.size() * 128);
        Iterator<appType$AuthItem> it = list.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            appType$AuthItem next = it.next();
            if (next.is_new.get() != 0) {
                hp3.e eVar = new hp3.e();
                eVar.f405823e = next.api_list.get();
                eVar.f405819a = next.default_flag.get();
                eVar.f405824f = next.f342466id.get();
                if (next.is_new.get() == 0) {
                    z17 = false;
                }
                eVar.f405822d = z17;
                eVar.f405820b = next.title.get();
                sb5.append(eVar.toString());
                sb5.append("\n");
                this.f339597f.add(eVar);
            }
        }
        t.b("CardContainer", sb5.toString());
        if (this.f339597f.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            URLImageView uRLImageView = this.E;
            r(1, str);
            this.N.setVisibility(0);
            t.b("CardContainer", "--> has been authority.");
            j(uRLImageView, h(str));
        } else {
            r(0, str);
            t.b("CardContainer", "--> has not been authority.");
            String str3 = "";
            for (i3 = 0; i3 < this.f339597f.size(); i3++) {
                hp3.e eVar2 = this.f339597f.get(i3);
                if (getTag() != null) {
                    str2 = str3 + "\u00b7 \u83b7\u5f97\u4f60\u4e0eQQ\u901a\u8baf\u5f55\u7ed1\u5b9a\u7684\u7535\u8bdd\u53f7\u7801";
                } else {
                    str2 = str3 + "\u00b7 " + eVar2.f405820b;
                }
                str3 = str2 + "\n";
            }
            this.R.setText(str3);
        }
        return z16;
    }

    public List<hp3.e> o() {
        return this.f339597f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseCardContainer, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.H = (ImageView) super.findViewById(R.id.f164065j0);
        this.J = (TextView) super.findViewById(R.id.f164068j4);
        this.L = (TextView) super.findViewById(R.id.f164070j6);
        this.I = (ImageView) super.findViewById(R.id.f164066j1);
        this.K = (TextView) super.findViewById(R.id.f164069j5);
        this.M = (TextView) super.findViewById(R.id.f164071j7);
        TextView textView = (TextView) super.findViewById(R.id.j3);
        this.N = textView;
        textView.setVisibility(8);
        this.R = (TextView) super.findViewById(R.id.fdu);
        this.P = (AuthorityAccountView) super.findViewById(R.id.f163903bt);
        this.Q = (RelativeLayout) super.findViewById(R.id.a0x);
        FixedBounceScrollView fixedBounceScrollView = (FixedBounceScrollView) super.findViewById(R.id.a18);
        fixedBounceScrollView.setMaxHeight(x.c(this.f339595d, 102.0f));
        fixedBounceScrollView.setNeedDisallowIntercept(true);
    }

    public void p(String str, Bitmap bitmap) {
        t.f("CardContainer", "showAppInfo appName = " + str);
        setVisibility(0);
        if (!TextUtils.isEmpty(str) && getTag() != null) {
            ((TextView) findViewById(R.id.f164067j2)).setText(HardCodeUtil.qqStr(R.string.k__) + str + HardCodeUtil.qqStr(R.string.k_9));
        }
        AuthorityAccountView authorityAccountView = this.P;
        if (authorityAccountView != null) {
            authorityAccountView.setAppInfo(str, bitmap);
        }
    }

    public void q(String str, String str2, Bitmap bitmap) {
        AuthorityAccountView authorityAccountView;
        boolean z16;
        if (!TextUtils.isEmpty(str2)) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i3 < str2.length()) {
                    if (String.valueOf(str2.charAt(i3)).getBytes().length > 1) {
                        i16 += 2;
                    } else {
                        i16++;
                    }
                    if (i16 > 10) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            String substring = str2.substring(0, i3);
            if (z16) {
                substring = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            t.f("CardContainer", "-->showUserInfo() set nickname ellipsis=" + substring + ",nick=" + str2);
            this.J.setText(substring);
            this.K.setText(substring);
        }
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(super.getContext().getString(R.string.f170180i6), str);
            this.L.setText(format);
            this.M.setText(format);
            if (this.N.getVisibility() == 0) {
                this.N.setVisibility(8);
            }
        }
        if (bitmap != null) {
            this.H.setImageBitmap(bitmap);
            this.I.setImageBitmap(bitmap);
        }
        if (!TextUtils.isEmpty(str) && (authorityAccountView = this.P) != null) {
            authorityAccountView.t(str);
        }
    }

    public void r(int i3, String str) {
        t.b("CardContainer", "switchToMode -->mode: " + i3 + ", mMode=" + this.f339600m);
        k(str);
        if (i3 == this.f339600m) {
            return;
        }
        if (i3 == 0) {
            this.Q.setVisibility(0);
        } else if (i3 == 1) {
            this.Q.setVisibility(8);
        }
        this.f339600m = i3;
    }

    public void setAppType(String str) {
        AuthorityAccountView authorityAccountView = this.P;
        if (authorityAccountView != null) {
            authorityAccountView.setAppType(str);
        }
    }

    public void setChangeAccountListener(AuthorityAccountView.c cVar) {
        AuthorityAccountView authorityAccountView = this.P;
        if (authorityAccountView != null) {
            authorityAccountView.setChangeAccountListener(cVar);
        }
    }

    public void setDeleteLastAccountListener(AuthorityAccountView.d dVar) {
        AuthorityAccountView authorityAccountView = this.P;
        if (authorityAccountView != null) {
            authorityAccountView.setDeleteLastAccountListener(dVar);
        }
    }
}
