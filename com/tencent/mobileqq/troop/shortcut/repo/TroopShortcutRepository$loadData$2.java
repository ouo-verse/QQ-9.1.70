package com.tencent.mobileqq.troop.shortcut.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.e;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.GetCapsuleAppRsp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "res", "Lcom/tencent/qqnt/kernel/nativeinterface/GetCapsuleAppRsp;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopShortcutRepository$loadData$2 extends Lambda implements Function1<GetCapsuleAppRsp, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<ArrayList<TroopShortcutInfo>, Unit> $callback;
    final /* synthetic */ TroopShortcutRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TroopShortcutRepository$loadData$2(TroopShortcutRepository troopShortcutRepository, Function1<? super ArrayList<TroopShortcutInfo>, Unit> function1) {
        super(1);
        this.this$0 = troopShortcutRepository;
        this.$callback = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopShortcutRepository, (Object) function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GetCapsuleAppRsp getCapsuleAppRsp, TroopShortcutRepository this$0, Function1 callback, ArrayList transformedResult) {
        boolean z16;
        TroopShortcutSettingCache troopShortcutSettingCache;
        TroopShortcutSettingCache troopShortcutSettingCache2;
        TroopShortcutSettingCache troopShortcutSettingCache3;
        TroopShortcutSettingCache troopShortcutSettingCache4;
        boolean z17;
        TroopShortcutSettingCache troopShortcutSettingCache5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(transformedResult, "$transformedResult");
        boolean z18 = false;
        if (getCapsuleAppRsp.versionFlag == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        troopShortcutSettingCache = this$0.settingCache;
        troopShortcutSettingCache.j(this$0.f(), z16);
        if (z16) {
            troopShortcutSettingCache4 = this$0.settingCache;
            long f16 = this$0.f();
            if (getCapsuleAppRsp.disabled != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            troopShortcutSettingCache4.h(f16, z17);
            troopShortcutSettingCache5 = this$0.settingCache;
            long f17 = this$0.f();
            if (getCapsuleAppRsp.groupDisabled != 0) {
                z18 = true;
            }
            troopShortcutSettingCache5.i(f17, z18);
        } else {
            troopShortcutSettingCache2 = this$0.settingCache;
            troopShortcutSettingCache2.h(this$0.f(), getCapsuleAppRsp.disableCapsule);
            troopShortcutSettingCache3 = this$0.settingCache;
            troopShortcutSettingCache3.i(this$0.f(), getCapsuleAppRsp.disableCapsuleSwitch);
        }
        callback.invoke(transformedResult);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GetCapsuleAppRsp getCapsuleAppRsp) {
        invoke2(getCapsuleAppRsp);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final GetCapsuleAppRsp getCapsuleAppRsp) {
        int collectionSizeOrDefault;
        TroopShortcutInfo q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) getCapsuleAppRsp);
            return;
        }
        if (getCapsuleAppRsp == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList(getCapsuleAppRsp.appList.size());
        TroopShortcutRepository troopShortcutRepository = this.this$0;
        ArrayList<AppDetail> arrayList2 = getCapsuleAppRsp.appList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "res.appList");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (AppDetail it : arrayList2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            q16 = troopShortcutRepository.q(it);
            arrayList3.add(q16);
        }
        arrayList.addAll(arrayList3);
        int size = getCapsuleAppRsp.appList.size();
        boolean z16 = getCapsuleAppRsp.disableCapsule;
        boolean z17 = getCapsuleAppRsp.disableCapsuleSwitch;
        boolean z18 = getCapsuleAppRsp.disabled == 1;
        boolean z19 = getCapsuleAppRsp.groupDisabled == 1;
        QLog.i("TroopShortcut.TroopShortcutRepository", 1, "load data result,size:" + size + ",disableCapsule:" + z16 + ",disableSwitch:" + z17 + ",disabled:" + z18 + ",groupDisabled:" + z19 + ",versionFlag:" + getCapsuleAppRsp.versionFlag);
        final TroopShortcutRepository troopShortcutRepository2 = this.this$0;
        final Function1<ArrayList<TroopShortcutInfo>, Unit> function1 = this.$callback;
        e.i(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcut.repo.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopShortcutRepository$loadData$2.b(GetCapsuleAppRsp.this, troopShortcutRepository2, function1, arrayList);
            }
        });
    }
}
