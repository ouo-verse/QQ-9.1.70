package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "troopInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class TroopApiImpl$showExitTroopPinToTopMsg$next$1 extends Lambda implements Function1<TroopInfo, Unit> {
    public static final TroopApiImpl$showExitTroopPinToTopMsg$next$1 INSTANCE = new TroopApiImpl$showExitTroopPinToTopMsg$next$1();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        QQToast.makeText((Context) null, it, 0).show();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
        invoke2(troopInfo);
        return Unit.INSTANCE;
    }

    TroopApiImpl$showExitTroopPinToTopMsg$next$1() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TroopInfo troopInfo) {
        final String str;
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        if (troopInfo.isDisband()) {
            str = "\u5df2\u89e3\u6563\u7684\u7fa4\u804a\u4e0d\u652f\u6301\u7f6e\u9876";
        } else {
            str = (troopInfo.isExited() || !troopInfo.hadJoinTroop()) ? "\u5df2\u9000\u51fa\u7684\u7fa4\u804a\u4e0d\u652f\u6301\u7f6e\u9876" : null;
        }
        if (str != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.bg
                @Override // java.lang.Runnable
                public final void run() {
                    TroopApiImpl$showExitTroopPinToTopMsg$next$1.c(str);
                }
            });
        }
    }
}
