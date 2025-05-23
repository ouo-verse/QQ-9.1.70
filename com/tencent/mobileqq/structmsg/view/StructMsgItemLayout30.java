package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StructMsgItemLayout30 extends k {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class TailTextView extends TextView {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f290462d;

        public TailTextView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        public void setIsLongClick(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.f290462d = z16;
            }
        }

        @Override // android.view.View
        public void setPressed(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                if (this.f290462d && !z16) {
                    return;
                }
                super.setPressed(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout f290463d;

        a(LinearLayout linearLayout) {
            this.f290463d = linearLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StructMsgItemLayout30.this, (Object) linearLayout);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f290463d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                StructMsgItemLayout30.this.H(this.f290463d);
            }
        }
    }

    public StructMsgItemLayout30() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(LinearLayout linearLayout) {
        TextView textView;
        Layout layout;
        int childCount = linearLayout.getChildCount();
        int i3 = 4;
        for (int i16 = 1; i16 < childCount; i16++) {
            View childAt = linearLayout.getChildAt(i16);
            if ((childAt instanceof TextView) && (layout = (textView = (TextView) childAt).getLayout()) != null) {
                int lineCount = layout.getLineCount();
                if (i3 > 0) {
                    textView.setVisibility(0);
                    if (i3 < lineCount) {
                        textView.setMaxLines(i3);
                        textView.requestLayout();
                    }
                } else {
                    textView.setVisibility(8);
                }
                i3 -= lineCount;
            }
        }
    }

    private TextView I(Context context, List<AbsStructMsgElement> list) {
        int i3;
        TailTextView tailTextView = new TailTextView(context);
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (list != null && i3 > 2) {
            AbsStructMsgElement absStructMsgElement = list.get(i3 - 1);
            if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.b) {
                tailTextView.setText(((com.tencent.mobileqq.structmsg.b) absStructMsgElement).t());
                tailTextView.setGravity(16);
                tailTextView.setSingleLine(true);
            }
        }
        return tailTextView;
    }

    private void J(LinearLayout linearLayout) {
        if (linearLayout.getWidth() > 0) {
            H(linearLayout);
        } else {
            linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(linearLayout));
        }
    }

    @Override // com.tencent.mobileqq.structmsg.view.k
    protected int E(Resources resources, int i3, AbsStructMsgElement absStructMsgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, resources, Integer.valueOf(i3), absStructMsgElement)).intValue();
        }
        if (i3 == 1) {
            i16 = 7;
        }
        return BaseAIOUtils.f(i16, resources);
    }

    @Override // com.tencent.mobileqq.structmsg.view.k
    protected ArrayList<AbsStructMsgElement> F(ArrayList<AbsStructMsgElement> arrayList) {
        StructMsgItemTitle structMsgItemTitle;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        }
        ArrayList<AbsStructMsgElement> arrayList2 = new ArrayList<>();
        ArrayList<AbsStructMsgElement> arrayList3 = new ArrayList();
        int size = arrayList.size();
        boolean z17 = false;
        for (int i3 = 0; i3 < size; i3++) {
            AbsStructMsgElement absStructMsgElement = arrayList.get(i3);
            if (i3 == 0 && (absStructMsgElement instanceof StructMsgItemTitle)) {
                StructMsgItemTitle structMsgItemTitle2 = (StructMsgItemTitle) absStructMsgElement;
                AbsStructMsg absStructMsg = this.P0;
                if (absStructMsg != null && absStructMsg.hasTSum() && structMsgItemTitle2.t().trim().endsWith(HardCodeUtil.qqStr(R.string.twk))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (absStructMsgElement instanceof d) {
                break;
            }
            if ((absStructMsgElement instanceof StructMsgItemTitle) || (absStructMsgElement instanceof ap)) {
                arrayList3.add(absStructMsgElement);
            }
        }
        if (!z17) {
            structMsgItemTitle = new StructMsgItemTitle(HardCodeUtil.qqStr(R.string.tw7));
        } else {
            structMsgItemTitle = (StructMsgItemTitle) arrayList3.get(0);
            arrayList3.remove(0);
        }
        structMsgItemTitle.L(WadlProxyConsts.OPER_TYPE_MONITOR);
        structMsgItemTitle.H("12");
        structMsgItemTitle.I("2");
        structMsgItemTitle.P0 = this.P0;
        arrayList2.add(structMsgItemTitle);
        for (AbsStructMsgElement absStructMsgElement2 : arrayList3) {
            if (absStructMsgElement2 instanceof com.tencent.mobileqq.structmsg.b) {
                com.tencent.mobileqq.structmsg.b bVar = (com.tencent.mobileqq.structmsg.b) absStructMsgElement2;
                bVar.L("26");
                bVar.G("#777777");
                bVar.H("12");
                bVar.I("2");
                absStructMsgElement2.P0 = this.P0;
                arrayList2.add(absStructMsgElement2);
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.structmsg.view.k, com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Layout30";
    }

    @Override // com.tencent.mobileqq.structmsg.view.k, com.tencent.mobileqq.structmsg.a
    public View y(Context context, View view, Bundle bundle) {
        int i3;
        LinearLayout linearLayout;
        TextView textView;
        LinearLayout linearLayout2;
        Context context2 = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ay5);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ay6);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.f159577ay4);
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            linearLayout2 = (LinearLayout) linearLayout.getChildAt(0);
            textView = (TextView) linearLayout.getChildAt(1);
        } else {
            LinearLayout linearLayout3 = new LinearLayout(context2);
            linearLayout3.setOrientation(1);
            LinearLayout linearLayout4 = new LinearLayout(context2);
            linearLayout4.setOrientation(1);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            linearLayout4.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize3);
            linearLayout4.setLayoutParams(layoutParams);
            TextView I = I(context2, this.U0);
            I.setId(R.id.f89284zc);
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.drawable.o36;
            } else {
                i3 = R.drawable.f162490lo0;
            }
            I.setBackgroundResource(i3);
            I.setPadding(dimensionPixelSize, 0, 0, 0);
            I.setTextSize(1, 13.0f);
            I.setGravity(16);
            I.setTextColor(resources.getColor(R.color.f157083je, context.getTheme()));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(30.0f, resources));
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            I.setLayoutParams(layoutParams2);
            linearLayout3.addView(linearLayout4);
            linearLayout3.addView(I);
            linearLayout = linearLayout3;
            textView = I;
            linearLayout2 = linearLayout4;
        }
        ArrayList<AbsStructMsgElement> F = F(this.U0);
        if (linearLayout2.getChildCount() == F.size()) {
            int size = F.size();
            int i16 = 0;
            while (i16 < size) {
                AbsStructMsgElement absStructMsgElement = F.get(i16);
                absStructMsgElement.O0 = this.O0;
                if (absStructMsgElement instanceof StructMsgItemTitle) {
                    ((StructMsgItemTitle) absStructMsgElement).N(z(), this.S0);
                }
                View c16 = absStructMsgElement.c(context2, linearLayout2.getChildAt(i16), bundle);
                if (c16 == null) {
                    return linearLayout2;
                }
                BaseAIOUtils.f(10.0f, resources);
                int i17 = size;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                if (i16 > 0) {
                    layoutParams3.topMargin = E(resources, i16, absStructMsgElement);
                }
                String str = absStructMsgElement.f290322e;
                if ("title".equals(str)) {
                    c16.setId(-1);
                } else if ("summary".equals(str)) {
                    c16.setId(-1);
                }
                if (u()) {
                    absStructMsgElement.b(c16);
                }
                i16++;
                size = i17;
            }
        } else {
            linearLayout2.removeAllViews();
            int size2 = F.size();
            int i18 = 0;
            while (i18 < size2) {
                AbsStructMsgElement absStructMsgElement2 = F.get(i18);
                absStructMsgElement2.O0 = this.O0;
                if (absStructMsgElement2 instanceof StructMsgItemTitle) {
                    ((StructMsgItemTitle) absStructMsgElement2).N(z(), this.S0);
                }
                View c17 = absStructMsgElement2.c(context2, null, bundle);
                if (c17 == null) {
                    return linearLayout2;
                }
                BaseAIOUtils.f(10.0f, resources);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                if (i18 > 0) {
                    layoutParams4.topMargin = E(resources, i18, absStructMsgElement2);
                }
                String str2 = absStructMsgElement2.f290322e;
                if ("title".equals(str2)) {
                    c17.setId(-1);
                } else if ("summary".equals(str2)) {
                    c17.setId(-1);
                }
                if (u()) {
                    absStructMsgElement2.b(c17);
                }
                linearLayout2.addView(c17, layoutParams4);
                i18++;
                context2 = context;
            }
        }
        J(linearLayout2);
        int size3 = this.U0.size();
        if (size3 > 0) {
            AbsStructMsgElement absStructMsgElement3 = this.U0.get(size3 - 1);
            if (absStructMsgElement3 instanceof com.tencent.mobileqq.structmsg.b) {
                textView.setText(((com.tencent.mobileqq.structmsg.b) absStructMsgElement3).X0);
            }
        }
        return linearLayout;
    }
}
