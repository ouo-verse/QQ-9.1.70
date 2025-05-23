package com.tencent.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QQUIAppSetting;
import java.lang.reflect.Method;

/* loaded from: classes27.dex */
public class BasePopupMenuDialog extends PopupWindow {
    static IPatchRedirector $redirector_;

    public BasePopupMenuDialog(View view, int i3, int i16, boolean z16) {
        super(view, i3, i16, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
    }

    public static final View createLineView(Context context) {
        TextView textView = new TextView(context);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1);
        ((ViewGroup.LayoutParams) layoutParams).height = 1;
        textView.setBackgroundColor(Color.parseColor("#DEDFE0"));
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public static int getScaledPixelSize(Context context, int i3) {
        return context.getResources().getDimensionPixelSize(i3);
    }

    public static void setModeTouch(PopupWindow popupWindow) {
        if (!QQUIAppSetting.enableTalkBack()) {
            return;
        }
        for (Method method : PopupWindow.class.getMethods()) {
            if (method.getName().equals("setTouchModal")) {
                try {
                    method.invoke(popupWindow, Boolean.FALSE);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    public static void setWindowType(PopupWindow popupWindow, int i3) {
        for (Method method : PopupWindow.class.getMethods()) {
            if (method.getName().equals("setWindowLayoutType")) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(i3));
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }
}
