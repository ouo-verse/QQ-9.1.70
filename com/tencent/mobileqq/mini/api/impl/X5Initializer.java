package com.tencent.mobileqq.mini.api.impl;

import android.content.Context;
import com.tencent.smtt.sdk.WebAccelerator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes33.dex */
public class X5Initializer extends eu3.b {
    private void superInitX5(Context context, int i3) {
        super.initX5(context, i3);
    }

    @Override // eu3.b, eu3.j
    public void initX5(final Context context, final int i3) {
        com.tencent.mobileqq.webview.swift.utils.p.a(new Function0() { // from class: com.tencent.mobileqq.mini.api.impl.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lambda$initX5$0;
                lambda$initX5$0 = X5Initializer.this.lambda$initX5$0(i3, context);
                return lambda$initX5$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initX5$0(int i3, Context context) {
        if (i3 == 1) {
            WebAccelerator.initTbsEnvironment(context, 1);
            return null;
        }
        superInitX5(context, i3);
        return null;
    }
}
