package com.tencent.ecommerce.biz.util;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/util/h;", "", "Landroid/view/View;", "view", "", MiniGamePAHippyBaseFragment.KEY_THEME, "", "a", "Landroid/widget/TextView;", "", "colorDay", "colorNight", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f104868a = new h();

    h() {
    }

    public final void a(View view, boolean isNightMode) {
        cg0.a.b("NightModeSetter", "set nav bg color");
        if (isNightMode) {
            view.setBackgroundColor(view.getResources().getColor(R.color.f156552dz));
            cg0.a.b("NightModeSetter", "set isNightMode bg color");
        } else {
            view.setBackgroundColor(view.getResources().getColor(R.color.f7163i));
            cg0.a.b("NightModeSetter", "set daily bg color");
        }
    }

    public final void b(TextView view, int colorDay, int colorNight, boolean isNightMode) {
        if (isNightMode) {
            view.setTextColor(colorNight);
            cg0.a.b("NightModeSetter", "set NightTime textView color");
        } else {
            view.setTextColor(colorDay);
            cg0.a.b("NightModeSetter", "set dayTime textView color");
        }
    }
}
