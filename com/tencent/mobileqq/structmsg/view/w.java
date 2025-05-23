package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w extends com.tencent.mobileqq.structmsg.a {
    static IPatchRedirector $redirector_;

    public w() {
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
        return 3;
    }

    @Override // com.tencent.mobileqq.structmsg.a
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "Layout3";
    }

    @Override // com.tencent.mobileqq.structmsg.a
    @TargetApi(16)
    public View y(Context context, View view, Bundle bundle) {
        LinearLayout linearLayout;
        boolean z16;
        String str;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, view, bundle);
        }
        Resources resources = context.getResources();
        Iterator<AbsStructMsgElement> it = this.U0.iterator();
        int i26 = 0;
        while (it.hasNext()) {
            if (it.next() instanceof StructMsgItemButton) {
                i26++;
            }
        }
        bundle.putInt("Layout3ButtonCount", i26);
        String str2 = "Layout3ButtonIndex";
        if (view != null && (view instanceof LinearLayout)) {
            linearLayout = (LinearLayout) view;
            int size = this.U0.size();
            z16 = false;
            for (int i27 = 0; i27 < size; i27++) {
                AbsStructMsgElement absStructMsgElement = this.U0.get(i27);
                absStructMsgElement.O0 = this.O0;
                String str3 = absStructMsgElement.f290322e;
                if (!"picture".equals(str3) && !"video".equals(str3)) {
                    if ("button".equals(str3)) {
                        bundle.putInt("Layout3ButtonIndex", i27);
                        absStructMsgElement.O0 = this.O0;
                        View c16 = absStructMsgElement.c(context, linearLayout.getChildAt(i27 * 2), bundle);
                        if (!z16) {
                            z16 = true;
                        }
                        if (u()) {
                            absStructMsgElement.b(c16);
                        }
                    }
                } else {
                    absStructMsgElement.O0 = this.O0;
                    View c17 = absStructMsgElement.c(context, linearLayout.getChildAt(i27), bundle);
                    if (c17 instanceof PAHighLightImageView) {
                    }
                }
            }
        } else {
            linearLayout = new LinearLayout(context);
            ArrayList arrayList = new ArrayList();
            int size2 = this.U0.size();
            int i28 = 0;
            int i29 = 0;
            z16 = false;
            while (i28 < size2) {
                AbsStructMsgElement absStructMsgElement2 = this.U0.get(i28);
                absStructMsgElement2.O0 = this.O0;
                String str4 = absStructMsgElement2.f290322e;
                if (!"picture".equals(str4) && !"video".equals(str4)) {
                    if ("button".equals(str4)) {
                        bundle.putInt(str2, i28);
                        absStructMsgElement2.O0 = this.O0;
                        View c18 = absStructMsgElement2.c(context, null, bundle);
                        if (i28 == 0) {
                            str = str2;
                            i16 = R.id.j4l;
                        } else {
                            str = str2;
                            if (i28 == 1) {
                                i16 = R.id.j4m;
                            } else if (i28 == 2) {
                                i16 = R.id.j4n;
                            } else {
                                i16 = 0;
                            }
                        }
                        c18.setId(i16);
                        arrayList.add(c18);
                        i29++;
                        if (!z16) {
                            z16 = true;
                        }
                        if (u()) {
                            absStructMsgElement2.b(c18);
                        }
                    } else {
                        str = str2;
                    }
                } else {
                    str = str2;
                    if (i29 >= 3) {
                        break;
                    }
                    absStructMsgElement2.O0 = this.O0;
                    View c19 = absStructMsgElement2.c(context, null, bundle);
                    if (i28 == 0) {
                        i3 = R.id.j4l;
                    } else if (i28 == 1) {
                        i3 = R.id.j4m;
                    } else if (i28 == 2) {
                        i3 = R.id.j4n;
                    } else {
                        i3 = 0;
                    }
                    c19.setId(i3);
                    arrayList.add(c19);
                    i29++;
                }
                i28++;
                str2 = str;
            }
            if (arrayList.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 3 item failed,item is:" + this.U0);
                    return null;
                }
                return null;
            }
            int f16 = BaseAIOUtils.f(10.0f, resources);
            int size3 = arrayList.size();
            int i36 = (int) ((((BaseChatItemLayout.N - f16) - f16) - 2) / 3.0f);
            for (int i37 = 0; i37 < size3; i37++) {
                View view2 = (View) arrayList.get(i37);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.weight = 1.0f;
                layoutParams.width = 0;
                layoutParams.height = i36;
                if (view2 instanceof TextView) {
                    i36 = BaseAIOUtils.f(45.0f, resources);
                    layoutParams.height = i36;
                    linearLayout.addView(view2, layoutParams);
                    if (i37 != size3 - 1) {
                        ImageView imageView = new ImageView(context);
                        imageView.setLayoutParams(new ViewGroup.LayoutParams(1, i36 - 2));
                        if (u()) {
                            imageView.setBackgroundColor(MiniChatConstants.COLOR_SELECTED_NIGHT);
                        } else {
                            imageView.setBackgroundColor(-2170912);
                        }
                        linearLayout.addView(imageView);
                    }
                } else {
                    if (i37 > 0) {
                        layoutParams.leftMargin = 1;
                    }
                    linearLayout.addView(view2, layoutParams);
                }
            }
        }
        int i38 = 0;
        B(linearLayout);
        D(linearLayout);
        if (!z16) {
            i19 = BaseAIOUtils.f(10.0f, resources);
            if (h(1)) {
                i18 = i19;
            } else {
                i18 = BaseAIOUtils.f(5.0f, resources);
            }
            if (h(2)) {
                i17 = i19;
                i38 = i17;
            } else {
                i17 = BaseAIOUtils.f(5.0f, resources);
                i38 = i19;
            }
        } else {
            i17 = 0;
            i18 = 0;
            i19 = 0;
        }
        linearLayout.setPadding(i19, i18, i38, i17);
        return linearLayout;
    }
}
