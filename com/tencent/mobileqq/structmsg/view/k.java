package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    protected int E(Resources resources, int i3, AbsStructMsgElement absStructMsgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, resources, Integer.valueOf(i3), absStructMsgElement)).intValue();
        }
        return BaseAIOUtils.f(5.0f, resources);
    }

    protected ArrayList<AbsStructMsgElement> F(ArrayList<AbsStructMsgElement> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    protected int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "Layout1";
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x029d A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.structmsg.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View y(Context context, View view, Bundle bundle) {
        int i3;
        LinearLayout linearLayout;
        int i16;
        Resources resources;
        int i17;
        int i18;
        String str;
        int i19;
        int i26;
        int i27;
        String str2;
        int i28;
        int i29;
        int i36;
        Context context2 = context;
        Bundle bundle2 = bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        Resources resources2 = context.getResources();
        int dimensionPixelSize = resources2.getDimensionPixelSize(R.dimen.axy);
        int dimensionPixelSize2 = resources2.getDimensionPixelSize(R.dimen.axz);
        int f16 = BaseAIOUtils.f(5.0f, resources2);
        AbsStructMsg absStructMsg = this.P0;
        if (absStructMsg != null && absStructMsg.mMsgServiceID == 35) {
            i3 = 6;
        } else {
            i3 = 10;
        }
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
        } else {
            linearLayout = new LinearLayout(context2);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (h(1)) {
                i16 = v(context2, i3) + f16;
            } else {
                i16 = f16;
            }
            if (h(2)) {
                f16 += v(context2, i3);
            }
            linearLayout.setPadding(dimensionPixelSize, i16, dimensionPixelSize2, f16);
            linearLayout.setLayoutParams(layoutParams);
            f16 = i16;
        }
        if (!TextUtils.isEmpty(this.f290329i)) {
            linearLayout.setBackgroundResource(R.drawable.common_strip_setting_bg);
        }
        D(linearLayout);
        ArrayList<AbsStructMsgElement> F = F(this.U0);
        String str3 = "image";
        int i37 = dimensionPixelSize;
        if (linearLayout.getChildCount() == F.size()) {
            int size = F.size();
            int i38 = 0;
            while (i38 < size) {
                AbsStructMsgElement absStructMsgElement = F.get(i38);
                ArrayList<AbsStructMsgElement> arrayList = F;
                absStructMsgElement.O0 = this.O0;
                if (absStructMsgElement instanceof StructMsgItemTitle) {
                    i26 = dimensionPixelSize2;
                    i27 = f16;
                    ((StructMsgItemTitle) absStructMsgElement).N(z(), this.S0);
                } else {
                    i26 = dimensionPixelSize2;
                    i27 = f16;
                }
                View c16 = absStructMsgElement.c(context2, linearLayout.getChildAt(i38), bundle2);
                if (c16 == null) {
                    return linearLayout;
                }
                int f17 = BaseAIOUtils.f(10.0f, resources2);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                if (i38 > 0) {
                    layoutParams2.topMargin = E(resources2, i38, absStructMsgElement);
                }
                String str4 = absStructMsgElement.f290322e;
                if ("picture".equals(str4)) {
                    c16.setId(-1);
                    layoutParams2.height = (BaseChatItemLayout.N - f17) - f17;
                } else if ("video".equals(str4)) {
                    layoutParams2.height = (BaseChatItemLayout.N - f17) - f17;
                } else if ("title".equals(str4)) {
                    c16.setId(-1);
                } else if ("summary".equals(str4)) {
                    c16.setId(-1);
                } else {
                    if ("hr".equals(str4)) {
                        layoutParams2.height = 1;
                        if (size == 1) {
                            linearLayout.setPadding(0, 0, 0, 0);
                        } else if (i38 == size - 1) {
                            int i39 = i37;
                            int i46 = i26;
                            i36 = i27;
                            linearLayout.setPadding(i39, i36, i46, 0);
                            str2 = str3;
                            i28 = i39;
                            i29 = i46;
                        } else {
                            i36 = i27;
                            str2 = str3;
                            i28 = i37;
                            i29 = i26;
                        }
                    } else {
                        str2 = str3;
                        i28 = i37;
                        i29 = i26;
                        i36 = i27;
                        if (str2.equals(str4)) {
                            layoutParams2.gravity = 1;
                            linearLayout.setPadding(0, 0, 0, 0);
                        }
                    }
                    if (!u()) {
                        absStructMsgElement.b(c16);
                    }
                    i38++;
                    context2 = context;
                    f16 = i36;
                    str3 = str2;
                    F = arrayList;
                    i37 = i28;
                    dimensionPixelSize2 = i29;
                    bundle2 = bundle;
                }
                str2 = str3;
                i28 = i37;
                i29 = i26;
                i36 = i27;
                if (!u()) {
                }
                i38++;
                context2 = context;
                f16 = i36;
                str3 = str2;
                F = arrayList;
                i37 = i28;
                dimensionPixelSize2 = i29;
                bundle2 = bundle;
            }
        } else {
            int i47 = dimensionPixelSize2;
            int i48 = f16;
            ArrayList<AbsStructMsgElement> arrayList2 = F;
            int i49 = i37;
            String str5 = str3;
            linearLayout.removeAllViews();
            int size2 = arrayList2.size();
            int i56 = 0;
            while (i56 < size2) {
                ArrayList<AbsStructMsgElement> arrayList3 = arrayList2;
                AbsStructMsgElement absStructMsgElement2 = arrayList3.get(i56);
                absStructMsgElement2.O0 = this.O0;
                if (absStructMsgElement2 instanceof StructMsgItemTitle) {
                    arrayList2 = arrayList3;
                    ((StructMsgItemTitle) absStructMsgElement2).N(z(), this.S0);
                } else {
                    arrayList2 = arrayList3;
                }
                View c17 = absStructMsgElement2.c(context, null, bundle);
                if (c17 == null) {
                    return linearLayout;
                }
                int f18 = BaseAIOUtils.f(10.0f, resources2);
                String str6 = str5;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                if (i56 > 0) {
                    layoutParams3.topMargin = E(resources2, i56, absStructMsgElement2);
                }
                String str7 = absStructMsgElement2.f290322e;
                if ("picture".equals(str7)) {
                    c17.setId(-1);
                    layoutParams3.height = (BaseChatItemLayout.N - f18) - f18;
                } else if ("video".equals(str7)) {
                    layoutParams3.height = (BaseChatItemLayout.N - f18) - f18;
                } else if ("title".equals(str7)) {
                    c17.setId(-1);
                } else if ("summary".equals(str7)) {
                    c17.setId(-1);
                } else {
                    if ("hr".equals(str7)) {
                        layoutParams3.height = 1;
                        if (size2 == 1) {
                            linearLayout.setPadding(0, 0, 0, 0);
                            resources = resources2;
                            i18 = i47;
                            str = str6;
                            i19 = size2;
                            i17 = i49;
                        } else {
                            resources = resources2;
                            if (i56 == size2 - 1) {
                                i17 = i49;
                                int i57 = i47;
                                linearLayout.setPadding(i17, i48, i57, 0);
                                i18 = i57;
                                str = str6;
                                i19 = size2;
                            } else {
                                i17 = i49;
                                str = str6;
                                i19 = size2;
                                i18 = i47;
                            }
                        }
                    } else {
                        resources = resources2;
                        i17 = i49;
                        i18 = i47;
                        str = str6;
                        i19 = size2;
                        if (str.equals(str7)) {
                            layoutParams3.gravity = 1;
                            linearLayout.setPadding(0, 0, 0, 0);
                        }
                    }
                    if (!u()) {
                        absStructMsgElement2.b(c17);
                    }
                    linearLayout.addView(c17, layoutParams3);
                    i56++;
                    size2 = i19;
                    i49 = i17;
                    i47 = i18;
                    str5 = str;
                    resources2 = resources;
                }
                resources = resources2;
                i17 = i49;
                i18 = i47;
                str = str6;
                i19 = size2;
                if (!u()) {
                }
                linearLayout.addView(c17, layoutParams3);
                i56++;
                size2 = i19;
                i49 = i17;
                i47 = i18;
                str5 = str;
                resources2 = resources;
            }
        }
        return linearLayout;
    }

    public k(Collection<AbsStructMsgElement> collection) {
        super(collection);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) collection);
    }
}
