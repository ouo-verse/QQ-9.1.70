package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;
    protected int X0;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.X0 = 0;
        }
    }

    private RelativeLayout E(Context context) {
        BubbleViewLayout bubbleViewLayout = new BubbleViewLayout(context);
        bubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        bubbleViewLayout.setId(R.id.alg);
        bubbleViewLayout.setRadius(10.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setPadding(0, 0, 0, BaseAIOUtils.f(10.0f, context.getResources()));
        linearLayout.setOrientation(1);
        linearLayout.setId(R.id.f164175lm);
        linearLayout.setBackgroundColor(-1);
        bubbleViewLayout.addView(linearLayout);
        return bubbleViewLayout;
    }

    public static final int F(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optInt(QQBrowserActivity.KEY_MSG_TYPE, 0);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 26: " + QLog.getStackTraceString(e16));
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 26;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "Layout26";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        int F = F(bundle.getString(WadlProxyConsts.EXTRA_DATA));
        RelativeLayout E = E(context);
        LinearLayout linearLayout = (LinearLayout) E.findViewById(R.id.f164175lm);
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        View view2 = null;
        TextView textView = null;
        while (it.hasNext()) {
            AbsStructMsgElement next = it.next();
            next.O0 = this.O0;
            String str = next.f290322e;
            if (("picture".equals(str) || "vote".equals(str) || "video".equals(str)) && view2 == null) {
                view2 = next.c(context, null, bundle);
                int f16 = BaseAIOUtils.f(200.0f, resources);
                if (next instanceof c) {
                    int i3 = ((c) next).V0;
                    if (i3 > 0) {
                        f16 = i3;
                    }
                    if ((F & 2) != 0) {
                        RelativeLayout relativeLayout = new RelativeLayout(context);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, f16);
                        layoutParams.addRule(14);
                        relativeLayout.addView(view2, layoutParams);
                        ImageView imageView = new ImageView(context);
                        imageView.setImageResource(R.drawable.d7v);
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(13);
                        relativeLayout.addView(imageView, layoutParams2);
                        view2 = relativeLayout;
                    }
                }
                linearLayout.addView(view2, new LinearLayout.LayoutParams(-1, f16));
            } else if ("summary".equals(str)) {
                textView = (TextView) next.c(context, null, bundle);
                linearLayout.addView(textView);
            }
        }
        if (view2 == null) {
            QLog.e("StructMsg", 1, "generate 26 item failure coverView == null\uff0cmElements.size=" + this.U0.size());
        }
        if (linearLayout == null) {
            QLog.e("StructMsg", 1, "generate 26 item failure containerView == null, mElements.size=" + this.U0.size());
        }
        boolean z16 = bundle.getBoolean("isSend", true);
        ((BubbleViewLayout) E.findViewById(R.id.alg)).f315477i = z16;
        if (z16) {
            if (textView != null) {
                textView.setPadding(BaseAIOUtils.f(12.0f, resources), 0, BaseAIOUtils.f(22.0f, resources), 0);
            }
        } else if (textView != null) {
            textView.setPadding(BaseAIOUtils.f(22.0f, resources), 0, BaseAIOUtils.f(12.0f, resources), 0);
        }
        if (AppSetting.f99565y && textView != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(textView.getText());
            if (linearLayout != null) {
                linearLayout.setContentDescription(sb5.toString());
            }
        }
        return E;
    }
}
