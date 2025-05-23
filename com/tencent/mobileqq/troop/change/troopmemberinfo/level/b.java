package com.tencent.mobileqq.troop.change.troopmemberinfo.level;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/change/troopmemberinfo/level/b;", "Lcom/tencent/mobileqq/troop/change/troopmemberinfo/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "", "b", "a", "c", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/troop/change/troopmemberinfo/level/a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mTroopMemberInfoLevelMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mInfoChangedSet", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements com.tencent.mobileqq.troop.change.troopmemberinfo.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, a> mTroopMemberInfoLevelMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> mInfoChangedSet;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mTroopMemberInfoLevelMap = new HashMap<>();
            this.mInfoChangedSet = new HashSet<>();
        }
    }

    @Override // com.tencent.mobileqq.troop.change.troopmemberinfo.a
    public void a(@Nullable TroopMemberInfo troopMemberInfo) {
        a aVar;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopMemberInfo);
            return;
        }
        if (troopMemberInfo != null && (aVar = this.mTroopMemberInfoLevelMap.get(troopMemberInfo.memberuin)) != null) {
            Integer c16 = aVar.c();
            int i3 = troopMemberInfo.titleId;
            if (c16 != null && c16.intValue() == i3) {
                Integer a16 = aVar.a();
                int i16 = troopMemberInfo.realLevel;
                if (a16 != null && a16.intValue() == i16) {
                    Integer e16 = aVar.e();
                    TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = troopMemberInfo.specialTitleInfo;
                    if (troopMemberSpecialTitleInfo != null) {
                        num = Integer.valueOf(troopMemberSpecialTitleInfo.getExpireTimeSec());
                    } else {
                        num = null;
                    }
                    if (Intrinsics.areEqual(e16, num) && Intrinsics.areEqual(aVar.d(), troopMemberInfo.getSpecialTitleStr()) && aVar.b() == troopMemberInfo.role) {
                        return;
                    }
                }
            }
            this.mInfoChangedSet.add(troopMemberInfo.troopuin);
        }
    }

    @Override // com.tencent.mobileqq.troop.change.troopmemberinfo.a
    public void b(@Nullable TroopMemberInfo troopMemberInfo) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
            return;
        }
        if (troopMemberInfo != null) {
            HashMap<String, a> hashMap = this.mTroopMemberInfoLevelMap;
            String str = troopMemberInfo.memberuin;
            Intrinsics.checkNotNullExpressionValue(str, "it.memberuin");
            Integer valueOf = Integer.valueOf(troopMemberInfo.titleId);
            Integer valueOf2 = Integer.valueOf(troopMemberInfo.realLevel);
            TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = troopMemberInfo.specialTitleInfo;
            if (troopMemberSpecialTitleInfo != null) {
                num = Integer.valueOf(troopMemberSpecialTitleInfo.getExpireTimeSec());
            } else {
                num = null;
            }
            hashMap.put(str, new a(valueOf, valueOf2, num, troopMemberInfo.getSpecialTitleStr(), troopMemberInfo.role));
        }
    }

    @Override // com.tencent.mobileqq.troop.change.troopmemberinfo.a
    public void c() {
        AppInterface appInterface;
        BaseBusinessHandler baseBusinessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        TroopInfoHandler troopInfoHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            baseBusinessHandler = appInterface.getBusinessHandler(TroopInfoHandler.class.getName());
        } else {
            baseBusinessHandler = null;
        }
        if (baseBusinessHandler instanceof TroopInfoHandler) {
            troopInfoHandler = (TroopInfoHandler) baseBusinessHandler;
        }
        if (troopInfoHandler != null) {
            Iterator<T> it = this.mInfoChangedSet.iterator();
            while (it.hasNext()) {
                troopInfoHandler.notifyUI(e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, (String) it.next());
            }
        }
        this.mTroopMemberInfoLevelMap.clear();
        this.mInfoChangedSet.clear();
    }
}
