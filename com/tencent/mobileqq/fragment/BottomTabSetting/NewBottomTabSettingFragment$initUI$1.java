package com.tencent.mobileqq.fragment.BottomTabSetting;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public /* synthetic */ class NewBottomTabSettingFragment$initUI$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NewBottomTabSettingFragment$initUI$1(Object obj) {
        super(1, obj, NewBottomTabSettingFragment.class, "selectedReport", "selectedReport(Ljava/lang/String;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((NewBottomTabSettingFragment) this.receiver).ni(p06);
    }
}
