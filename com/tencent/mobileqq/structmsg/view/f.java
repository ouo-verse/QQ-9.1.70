package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f290640a;

        /* renamed from: b, reason: collision with root package name */
        public View f290641b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void E(Context context, View view, a aVar) {
        int f16;
        if (view != null && (view instanceof RelativeLayout)) {
            Resources resources = context.getResources();
            if (aVar.f290640a != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                aVar.f290640a.setId(R.id.a0h);
                layoutParams.addRule(9, -1);
                ((RelativeLayout) view).addView(aVar.f290640a);
            }
            if (aVar.f290641b != null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(9);
                if (FontSettingManager.getFontLevel() > 16.0f) {
                    f16 = BaseAIOUtils.f(5.0f, resources);
                } else {
                    f16 = BaseAIOUtils.f(10.0f, resources);
                }
                layoutParams2.setMargins(BaseAIOUtils.f(20.0f, resources), 0, BaseAIOUtils.f(20.0f, resources), f16);
                layoutParams2.addRule(12);
                ((RelativeLayout) view).addView(aVar.f290641b, layoutParams2);
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 10;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "Layout10";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        if (view != null && (view instanceof RelativeLayout) && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
            Iterator<AbsStructMsgElement> it = this.U0.iterator();
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                next.O0 = this.O0;
                String str = next.f290322e;
                if ("title".equals(str)) {
                    StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                    String x16 = structMsgItemTitle.x();
                    int o16 = structMsgItemTitle.o();
                    if (!TextUtils.isEmpty(x16)) {
                        try {
                            o16 = Integer.parseInt(x16);
                        } catch (Exception unused) {
                        }
                    }
                    float fontLevel = FontSettingManager.getFontLevel() / 16.0f;
                    if (o16 * fontLevel > 36.0f) {
                        structMsgItemTitle.K("" + ((int) (36.0f / fontLevel)));
                    } else {
                        structMsgItemTitle.K(x16);
                    }
                    aVar.f290641b = next.c(context, aVar.f290641b, bundle);
                } else if ("paaudio".equals(str)) {
                    aVar.f290640a = next.c(context, aVar.f290640a, bundle);
                }
            }
        } else {
            Resources resources = context.getResources();
            aVar = new a();
            RelativeLayout relativeLayout = new RelativeLayout(context);
            int f16 = BaseAIOUtils.f(15.0f, resources);
            relativeLayout.setPadding(f16, f16, f16, f16);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ((int) (((BaseChatItemLayout.J - BaseAIOUtils.f(46.0f, resources)) * 26.0f) / 63.0f)) + BaseAIOUtils.f(30.0f, resources)));
            Iterator<AbsStructMsgElement> it5 = this.U0.iterator();
            while (it5.hasNext()) {
                AbsStructMsgElement next2 = it5.next();
                next2.O0 = this.O0;
                String str2 = next2.f290322e;
                if ("title".equals(str2)) {
                    StructMsgItemTitle structMsgItemTitle2 = (StructMsgItemTitle) next2;
                    String x17 = structMsgItemTitle2.x();
                    int o17 = structMsgItemTitle2.o();
                    if (!TextUtils.isEmpty(x17)) {
                        try {
                            o17 = Integer.parseInt(x17);
                        } catch (Exception unused2) {
                        }
                    }
                    float fontLevel2 = FontSettingManager.getFontLevel() / 16.0f;
                    if (o17 * fontLevel2 > 36.0f) {
                        structMsgItemTitle2.K("" + ((int) (36.0f / fontLevel2)));
                    } else {
                        structMsgItemTitle2.K(x17);
                    }
                    aVar.f290641b = next2.c(context, aVar.f290641b, bundle);
                } else if ("paaudio".equals(str2)) {
                    aVar.f290640a = next2.c(context, aVar.f290640a, bundle);
                }
            }
            E(context, relativeLayout, aVar);
            view = relativeLayout;
        }
        View view2 = aVar.f290641b;
        if (view2 != null) {
            ((TextView) view2).setMaxLines(1);
        }
        view.setTag(aVar);
        return view;
    }
}
