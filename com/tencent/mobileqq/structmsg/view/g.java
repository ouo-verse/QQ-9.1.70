package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        View f290642a;

        /* renamed from: b, reason: collision with root package name */
        View f290643b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 11;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "Layout11";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        String str;
        char c16;
        View view2;
        g gVar = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        String str2 = "";
        float f16 = 1.0f;
        float f17 = 16.0f;
        if (view != null && (view instanceof RelativeLayout) && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            Iterator<AbsStructMsgElement> it = gVar.U0.iterator();
            while (it.hasNext()) {
                AbsStructMsgElement next = it.next();
                next.O0 = gVar.O0;
                String str3 = next.f290322e;
                if ("title".equals(str3)) {
                    StructMsgItemTitle structMsgItemTitle = (StructMsgItemTitle) next;
                    structMsgItemTitle.F(TipsElementData.DEFAULT_COLOR);
                    float fontLevel = FontSettingManager.getFontLevel() / 16.0f;
                    if (fontLevel > f16) {
                        structMsgItemTitle.K("" + ((int) (36 / fontLevel)));
                    } else {
                        structMsgItemTitle.K(String.valueOf(36));
                    }
                    structMsgItemTitle.c(context, aVar.f290643b, bundle);
                } else if ("pavideo".equals(str3)) {
                    next.c(context, aVar.f290642a, bundle);
                }
                f16 = 1.0f;
            }
            if (aVar != null && (view2 = aVar.f290643b) != null) {
                ((TextView) view2).setMaxLines(2);
            }
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        int f18 = ((int) ((BaseChatItemLayout.J - BaseAIOUtils.f(46.0f, resources)) / 1.8d)) + BaseAIOUtils.f(30.0f, resources);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, f18));
        int f19 = BaseAIOUtils.f(15.0f, resources);
        relativeLayout.setPadding(f19, f19, f19, f19);
        a aVar2 = new a();
        Iterator<AbsStructMsgElement> it5 = gVar.U0.iterator();
        View view3 = null;
        View view4 = null;
        while (it5.hasNext()) {
            AbsStructMsgElement next2 = it5.next();
            next2.O0 = gVar.O0;
            String str4 = next2.f290322e;
            if ("title".equals(str4)) {
                StructMsgItemTitle structMsgItemTitle2 = (StructMsgItemTitle) next2;
                structMsgItemTitle2.F(TipsElementData.DEFAULT_COLOR);
                float fontLevel2 = FontSettingManager.getFontLevel() / f17;
                if (fontLevel2 > 1.0f) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    str = str2;
                    c16 = '$';
                    sb5.append((int) (36 / fontLevel2));
                    structMsgItemTitle2.K(sb5.toString());
                } else {
                    str = str2;
                    c16 = '$';
                    structMsgItemTitle2.K(String.valueOf(36));
                }
                View c17 = structMsgItemTitle2.c(context, null, bundle);
                c17.setId(1001);
                view4 = c17;
            } else {
                str = str2;
                c16 = '$';
                if ("pavideo".equals(str4)) {
                    view3 = next2.c(context, null, bundle);
                    view3.setId(1003);
                }
            }
            gVar = this;
            str2 = str;
            f17 = 16.0f;
        }
        if (view3 != null) {
            relativeLayout.addView(view3, new RelativeLayout.LayoutParams(-1, -1));
        }
        View view5 = new View(context);
        view5.setBackgroundResource(R.drawable.f161244t9);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (f18 * 0.32d));
        layoutParams.addRule(12, -1);
        relativeLayout.addView(view5, layoutParams);
        View view6 = view4;
        if (view6 != null) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12, -1);
            layoutParams2.bottomMargin = BaseAIOUtils.f(11.5f, resources);
            layoutParams2.leftMargin = BaseAIOUtils.f(20.0f, resources);
            layoutParams2.rightMargin = BaseAIOUtils.f(20.0f, resources);
            relativeLayout.addView(view6, layoutParams2);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(52.5f, resources), BaseAIOUtils.f(52.5f, resources));
        layoutParams3.addRule(15, -1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.d7v);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        layoutParams3.addRule(14, -1);
        relativeLayout.addView(imageView, layoutParams3);
        if (view3 != null) {
            aVar2.f290642a = view3;
        }
        if (view6 != null) {
            aVar2.f290643b = view6;
            ((TextView) view6).setMaxLines(1);
        }
        relativeLayout.setTag(aVar2);
        return relativeLayout;
    }
}
