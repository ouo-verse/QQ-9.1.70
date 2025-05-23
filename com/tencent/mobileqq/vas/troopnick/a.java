package com.tencent.mobileqq.vas.troopnick;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureSwitchProcessor;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.QColorNickTextView;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vas.troopnick.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8929a implements TroopNickResDrawable.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f311060a;

        C8929a(TextView textView) {
            this.f311060a = textView;
        }

        @Override // com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable.b
        public void a(Rect rect) {
            TextView textView = this.f311060a;
            if (textView != null) {
                textView.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            }
        }
    }

    private static void a(TextView textView) {
        textView.setTypeface(Typeface.DEFAULT);
        textView.setBackgroundDrawable(null);
        textView.setPadding(0, 0, 0, 0);
    }

    public static void b(TextView textView, Context context, int i3, boolean z16) {
        c(textView, context, i3, z16, true);
    }

    public static void c(TextView textView, Context context, int i3, boolean z16, boolean z17) {
        boolean z18;
        TroopNickResDrawable troopNickResDrawable;
        if (textView == null) {
            return;
        }
        if (QVipFeatureSwitchProcessor.getConfig() != null && !QVipFeatureSwitchProcessor.getConfig().isTroopNickEnable()) {
            a(textView);
            return;
        }
        if (i3 > 0 && context != null) {
            Drawable background = textView.getBackground();
            if ((background instanceof TroopNickResDrawable) && ((TroopNickResDrawable) background).e() == i3) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (VasNormalToggle.VAS_TROOP_NICK_NAME_CONTEXT_SWITCH.isEnable(true)) {
                    troopNickResDrawable = new TroopNickResDrawable(MobileQQ.sMobileQQ.peekAppRuntime(), i3);
                } else {
                    troopNickResDrawable = new TroopNickResDrawable(context, i3);
                }
                TroopNickAdapter troopNickAdapter = new TroopNickAdapter(troopNickResDrawable);
                if (z16) {
                    troopNickAdapter.h(true);
                }
                troopNickResDrawable.setAdapter(troopNickAdapter);
                textView.setBackgroundDrawable(troopNickResDrawable);
                troopNickResDrawable.g(new C8929a(textView));
            }
            d(textView);
            return;
        }
        if (z17) {
            a(textView);
        }
    }

    private static void d(TextView textView) {
        if (textView instanceof ColorNickTextView) {
            ((ColorNickTextView) textView).f();
            return;
        }
        if (textView instanceof ColorClearableEditText) {
            ((ColorClearableEditText) textView).l();
            return;
        }
        if (textView instanceof QColorNickTextView) {
            ((QColorNickTextView) textView).updateDrawablePadding();
            Drawable background = textView.getBackground();
            if (background instanceof TroopNickResDrawable) {
                QColorNickTextView qColorNickTextView = (QColorNickTextView) textView;
                qColorNickTextView.splitParagraph();
                ((TroopNickResDrawable) background).f(qColorNickTextView.getContentSize());
            }
        }
    }
}
