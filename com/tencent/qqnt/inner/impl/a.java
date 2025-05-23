package com.tencent.qqnt.inner.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J>\u0010\f\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bJ>\u0010\r\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bJ>\u0010\u000e\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bJ>\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\tJ\u0012\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R \u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00058F\u00a2\u0006\u0006\u001a\u0004\b)\u00105R\u001d\u00109\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t078F\u00a2\u0006\u0006\u001a\u0004\b,\u00108R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050:8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010;R\u001d\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020(078F\u00a2\u0006\u0006\u001a\u0004\b2\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/inner/impl/a;", "", "", "l", "j", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "newList", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "beforeUpdate", "afterUpdate", "k", DomainData.DOMAIN_NAME, "a", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtInfo;", "groupExtList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "groupDetail", "i", "troopInfo", tl.h.F, "", "from", "o", "", "Z", "c", "()Z", "setCacheInited", "(Z)V", "cacheInited", "b", "setCacheAllInited", "cacheAllInited", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "cacheMap", "e", "troopCodeMap", "Lcom/tencent/mobileqq/livedata/f;", "f", "Lcom/tencent/mobileqq/livedata/f;", "cacheListLiveData", "g", "Ljava/lang/Boolean;", "enableRemoveTroopDispatch", "()Ljava/util/List;", "readOnlyCacheList", "", "()Ljava/util/Map;", "readOnlyCacheMap", "Lfx3/a;", "()Lfx3/a;", "readOnlyLiveData", "readOnlyTroopCodeMap", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean cacheInited;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean cacheAllInited;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<TroopInfo> cache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, TroopInfo> cacheMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Long> troopCodeMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.livedata.f<List<TroopInfo>> cacheListLiveData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean enableRemoveTroopDispatch;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.cache = new CopyOnWriteArrayList<>();
        this.cacheMap = new ConcurrentHashMap<>();
        this.troopCodeMap = new ConcurrentHashMap<>();
        this.cacheListLiveData = new com.tencent.mobileqq.livedata.f<>();
    }

    private final void l() {
        this.cacheListLiveData.m(this.cache);
    }

    public final void a(@NotNull List<GroupSimpleInfo> newList, @NotNull Function1<? super TroopInfo, Unit> beforeUpdate, @NotNull Function1<? super TroopInfo, Unit> afterUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, newList, beforeUpdate, afterUpdate);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(beforeUpdate, "beforeUpdate");
        Intrinsics.checkNotNullParameter(afterUpdate, "afterUpdate");
        if (this.enableRemoveTroopDispatch == null) {
            this.enableRemoveTroopDispatch = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106023", true));
        }
        for (GroupSimpleInfo groupSimpleInfo : newList) {
            TroopInfo troopInfo = this.cacheMap.get(Long.valueOf(groupSimpleInfo.groupCode));
            Boolean bool = this.enableRemoveTroopDispatch;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual(bool, bool2)) {
                beforeUpdate.invoke(troopInfo);
            }
            com.tencent.qqnt.inner.g.f357168a.g(groupSimpleInfo, troopInfo);
            if (Intrinsics.areEqual(this.enableRemoveTroopDispatch, bool2) && troopInfo != null) {
                afterUpdate.invoke(troopInfo);
            }
        }
        l();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.cacheAllInited;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.cacheInited;
    }

    @NotNull
    public final List<TroopInfo> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.cache;
    }

    @NotNull
    public final Map<Long, TroopInfo> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.cacheMap;
    }

    @NotNull
    public final fx3.a<List<TroopInfo>> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (fx3.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.cacheListLiveData;
    }

    @NotNull
    public final Map<String, Long> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.troopCodeMap;
    }

    public final void h(@NotNull TroopInfo troopInfo) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) troopInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        String str = troopInfo.troopuin;
        Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (this.cacheMap.get(Long.valueOf(longValue)) != troopInfo) {
                this.cache.add(troopInfo);
                this.cacheMap.put(Long.valueOf(longValue), troopInfo);
            }
            l();
        }
    }

    public final void i(@NotNull GroupDetailInfo groupDetail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) groupDetail);
            return;
        }
        Intrinsics.checkNotNullParameter(groupDetail, "groupDetail");
        TroopInfo troopInfo = this.cacheMap.get(Long.valueOf(groupDetail.groupCode));
        TroopInfo a16 = com.tencent.qqnt.inner.g.f357168a.a(groupDetail, troopInfo);
        if (troopInfo != a16) {
            this.cache.add(a16);
            this.cacheMap.put(Long.valueOf(groupDetail.groupCode), a16);
        }
        this.troopCodeMap.put(String.valueOf(groupDetail.groupUin), Long.valueOf(groupDetail.groupCode));
        com.tencent.qqnt.troop.inner.c.f362727a.e(a16.troopuin, a16.troopNameFromNT);
        l();
        if (QLog.isDebugVersion()) {
            QLog.d(TroopInfoInnerServiceImpl.TAG, 4, "[onGroupDetailInfoChange] newTroopInfo:" + a16);
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.cacheInited = true;
            this.cacheAllInited = true;
        }
    }

    public final void k(@NotNull List<GroupSimpleInfo> newList, @NotNull Function1<? super TroopInfo, Unit> beforeUpdate, @NotNull Function1<? super TroopInfo, Unit> afterUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, newList, beforeUpdate, afterUpdate);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(beforeUpdate, "beforeUpdate");
        Intrinsics.checkNotNullParameter(afterUpdate, "afterUpdate");
        this.cacheInited = true;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (QLog.isDebugVersion()) {
            QLog.d(TroopInfoInnerServiceImpl.TAG, 4, "[resetAllSimpleData] newListSize:" + newList.size());
        }
        for (GroupSimpleInfo groupSimpleInfo : newList) {
            TroopInfo troopInfo = this.cacheMap.get(Long.valueOf(groupSimpleInfo.groupCode));
            beforeUpdate.invoke(troopInfo);
            TroopInfo d16 = com.tencent.qqnt.inner.g.f357168a.d(groupSimpleInfo, troopInfo);
            arrayList.add(d16);
            linkedHashMap.put(Long.valueOf(groupSimpleInfo.groupCode), d16);
            this.troopCodeMap.put(String.valueOf(groupSimpleInfo.groupUin), Long.valueOf(groupSimpleInfo.groupCode));
            if (troopInfo != d16) {
                this.cache.add(d16);
                this.cacheMap.put(Long.valueOf(groupSimpleInfo.groupCode), d16);
            }
            afterUpdate.invoke(d16);
            com.tencent.qqnt.troop.inner.c.f362727a.e(d16.troopuin, d16.troopNameFromNT);
        }
        this.cacheAllInited = true;
        l();
    }

    public final void m(@NotNull List<GroupExtInfo> groupExtList, @NotNull Function1<? super TroopInfo, Unit> beforeUpdate, @NotNull Function1<? super TroopInfo, Unit> afterUpdate) {
        GroupExt groupExt;
        BusinessHandler businessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, groupExtList, beforeUpdate, afterUpdate);
            return;
        }
        Intrinsics.checkNotNullParameter(groupExtList, "groupExtList");
        Intrinsics.checkNotNullParameter(beforeUpdate, "beforeUpdate");
        Intrinsics.checkNotNullParameter(afterUpdate, "afterUpdate");
        for (GroupExtInfo groupExtInfo : groupExtList) {
            TroopInfo troopInfo = this.cacheMap.get(Long.valueOf(groupExtInfo.groupCode));
            if (troopInfo != null) {
                groupExt = troopInfo.groupExt;
            } else {
                groupExt = null;
            }
            if (troopInfo != null && groupExtInfo.resultCode == 0) {
                beforeUpdate.invoke(troopInfo);
                troopInfo.groupExt = groupExtInfo.extInfo;
                troopInfo.hadInitExt = true;
                afterUpdate.invoke(troopInfo);
                AppInterface a16 = com.tencent.qqnt.f.f356721a.a();
                if (a16 != null && (businessHandler = a16.getBusinessHandler(TroopInfoHandler.class.getName())) != null) {
                    businessHandler.notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_GET_TROOP_INFO_EXT_COMPLETE, true, new Object[]{troopInfo.getTroopUin(), groupExt});
                }
            } else {
                QLog.e(TroopInfoInnerServiceImpl.TAG, 1, "updatePartialExtData: cacheTroopInfo not exist, groupCode=" + groupExtInfo.groupCode);
            }
        }
        l();
    }

    public final void n(@NotNull List<GroupSimpleInfo> newList, @NotNull Function1<? super TroopInfo, Unit> beforeUpdate, @NotNull Function1<? super TroopInfo, Unit> afterUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, newList, beforeUpdate, afterUpdate);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(beforeUpdate, "beforeUpdate");
        Intrinsics.checkNotNullParameter(afterUpdate, "afterUpdate");
        for (GroupSimpleInfo groupSimpleInfo : newList) {
            TroopInfo troopInfo = this.cacheMap.get(Long.valueOf(groupSimpleInfo.groupCode));
            if (troopInfo != null) {
                troopInfo.isExitByJce = false;
            }
            beforeUpdate.invoke(troopInfo);
            TroopInfo d16 = com.tencent.qqnt.inner.g.f357168a.d(groupSimpleInfo, troopInfo);
            if (troopInfo != d16) {
                this.cache.add(d16);
                this.cacheMap.put(Long.valueOf(groupSimpleInfo.groupCode), d16);
            }
            this.troopCodeMap.put(String.valueOf(groupSimpleInfo.groupUin), Long.valueOf(groupSimpleInfo.groupCode));
            afterUpdate.invoke(d16);
            com.tencent.qqnt.troop.inner.c.f362727a.e(d16.troopuin, d16.troopNameFromNT);
        }
        l();
    }

    public final void o(@Nullable String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) from);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TroopInfoInnerServiceImpl.TAG, 4, "[updateTroopExtInfo] from:" + from + ", cacheSize:" + this.cacheMap.size());
        }
        Iterator<Map.Entry<Long, TroopInfo>> it = this.cacheMap.entrySet().iterator();
        while (it.hasNext()) {
            TroopExtDBInfoRepo.INSTANCE.configTroopExtInfo$qqtroop_impl_release(it.next().getValue());
        }
        l();
    }
}
