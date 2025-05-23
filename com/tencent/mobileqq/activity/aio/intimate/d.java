package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final View f178918a;

        /* renamed from: b, reason: collision with root package name */
        private final String f178919b;

        /* renamed from: c, reason: collision with root package name */
        private final int f178920c;

        /* renamed from: d, reason: collision with root package name */
        private final int f178921d;

        public a(View view, String str, int i3, int i16) {
            this.f178918a = view;
            this.f178919b = str;
            this.f178920c = i3;
            this.f178921d = i16;
        }

        public boolean e() {
            View view = this.f178918a;
            if (view != null && view.getVisibility() == 0) {
                if (TextUtils.isEmpty(this.f178919b)) {
                    QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] bubbleText invalid");
                    return false;
                }
                int i3 = this.f178920c;
                if (i3 != 49 && i3 != 50 && i3 != 51 && i3 != 52) {
                    QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] bubblePosition invalid");
                    return false;
                }
                if (this.f178921d > 0) {
                    return true;
                }
                QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] lifeTimeSecond invalid");
                return false;
            }
            QLog.e("IntimateBubbleUtil", 1, "[BubbleSetUp.isValid] pointerView invalid");
            return false;
        }
    }

    public static View a(Context context, a aVar) {
        int color;
        if (context != null && aVar != null && aVar.e()) {
            try {
                CalloutPopupWindow.Builder textColor = CalloutPopupWindow.builder(context).setText(aVar.f178919b).setTextSize(14.0f).setTextColor(-1);
                textColor.setPosition(aVar.f178920c);
                textColor.setLifetime(aVar.f178921d);
                if (QQTheme.isNowThemeIsNight()) {
                    color = context.getResources().getColor(R.color.c4t);
                } else {
                    color = context.getResources().getColor(R.color.c4v);
                }
                CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(textColor).setBackgroundColor(color).setBackgroundRadius(4).build().build();
                if (build != null) {
                    build.setAlignMode(82);
                    build.showAsPointer(aVar.f178918a);
                    QLog.d("IntimateBubbleUtil", 1, "[showIntimateBubbleTips] show");
                    return build.getContentView();
                }
            } catch (Exception e16) {
                QLog.e("IntimateBubbleUtil", 1, "[showIntimateBubbleTips] exception:", e16);
            }
            return null;
        }
        QLog.e("IntimateBubbleUtil", 1, "[showIntimateBubbleTips] context unavailable or bubbleSetup unavailable");
        return null;
    }
}
