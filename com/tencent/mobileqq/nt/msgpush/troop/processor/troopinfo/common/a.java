package com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/common/a;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "", "a", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/common/implementer/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mImplementer", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.a> mImplementer;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.a> arrayList = new ArrayList<>();
        arrayList.add(new b());
        this.mImplementer = arrayList;
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        AppRuntime peekAppRuntime;
        ITroopInfoService iTroopInfoService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        com.tencent.mobileqq.nt.msgpush.troop.processor.a b16 = convertResultData.b();
        if (b16 != null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (iTroopInfoService = (ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")) != null) {
            TroopInfo troopInfo = iTroopInfoService.getTroopInfo(b16.e());
            for (com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.a aVar : this.mImplementer) {
                Intrinsics.checkNotNullExpressionValue(troopInfo, "troopInfo");
                aVar.b(troopInfo, b16);
            }
            Iterator<T> it = this.mImplementer.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.a) it.next()).a();
            }
        }
    }
}
