package com.tencent.guild.aio.input.at.trooptag.model;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import cp0.HashTagGroupData;
import cp0.HashTagGroupType;
import cp0.HashTagTroopData;
import cp0.HashTagTroopInActiveData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ9\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u000b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004H\u0002J8\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u000fj\b\u0012\u0004\u0012\u00020\u0013`\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J.\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u000fj\b\u0012\u0004\u0012\u00020\u0013`\u00112\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/model/TroopListRepository;", "", "Lcom/tencent/common/app/AppInterface;", "qqAppInterface", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lkotlin/ParameterName;", "name", "dataList", "", "innerCallback", "f", "Lcp0/g;", NotifyMsgApiImpl.KEY_GROUP_TYPE, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/adapter/contact/d;", "Lkotlin/collections/ArrayList;", "troopList", "Lcp0/a;", h.F, "troopInfo", "", "i", "allTroopInfoList", "j", "Lcom/tencent/guild/aio/input/at/trooptag/model/b;", "fetchCallback", "d", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class TroopListRepository {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final TroopListRepository this$0, final AppInterface qqAppInterface, final b fetchCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qqAppInterface, "$qqAppInterface");
        Intrinsics.checkNotNullParameter(fetchCallback, "$fetchCallback");
        this$0.f(qqAppInterface, new Function1<List<? extends TroopInfo>, Unit>() { // from class: com.tencent.guild.aio.input.at.trooptag.model.TroopListRepository$fetchTroopList$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends TroopInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull final List<? extends TroopInfo> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                final b bVar = b.this;
                final TroopListRepository troopListRepository = this$0;
                final AppInterface appInterface = qqAppInterface;
                PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.guild.aio.input.at.trooptag.model.TroopListRepository$fetchTroopList$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList<cp0.a> j3;
                        b bVar2 = b.this;
                        j3 = troopListRepository.j(appInterface, it);
                        bVar2.a(j3);
                    }
                });
            }
        });
    }

    private final void f(AppInterface qqAppInterface, final Function1<? super List<? extends TroopInfo>, Unit> innerCallback) {
        int collectionSizeOrDefault;
        Unit unit;
        final List<TroopInfo> sortedJoinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedTroopInfoFromCache();
        if (sortedJoinedTroopInfoFromCache.isEmpty()) {
            innerCallback.invoke(new ArrayList());
            return;
        }
        List<TroopInfo> list = sortedJoinedTroopInfoFromCache;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Contact(2, ((TroopInfo) it.next()).troopuin, ""));
        }
        aa recentContactService = ((IKernelService) qqAppInterface.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService != null) {
            recentContactService.d(arrayList, new IGetContactsCallback() { // from class: com.tencent.guild.aio.input.at.trooptag.model.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList2, ArrayList arrayList3) {
                    TroopListRepository.g(sortedJoinedTroopInfoFromCache, innerCallback, i3, str, arrayList2, arrayList3);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            innerCallback.invoke(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(List allTroopInfoList, Function1 innerCallback, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(allTroopInfoList, "$allTroopInfoList");
        Intrinsics.checkNotNullParameter(innerCallback, "$innerCallback");
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RecentContactInfo recentContactInfo = (RecentContactInfo) it.next();
            String peerUid = recentContactInfo.getPeerUid();
            Intrinsics.checkNotNullExpressionValue(peerUid, "contactInfo.getPeerUid()");
            hashMap.put(peerUid, Long.valueOf(recentContactInfo.msgTime));
        }
        Iterator it5 = allTroopInfoList.iterator();
        while (it5.hasNext()) {
            TroopInfo troopInfo = (TroopInfo) it5.next();
            Long l3 = (Long) hashMap.get(troopInfo.getTroopUin());
            if (l3 != null) {
                troopInfo.lastMsgTime = l3.longValue();
            }
        }
        innerCallback.invoke(allTroopInfoList);
    }

    private final ArrayList<cp0.a> h(HashTagGroupType groupType, ArrayList<com.tencent.mobileqq.troop.adapter.contact.d> troopList) {
        TroopInfo troopInfo;
        if (troopList.isEmpty()) {
            return new ArrayList<>();
        }
        Collections.sort(troopList, new com.tencent.mobileqq.troop.adapter.contact.b());
        ArrayList arrayList = new ArrayList();
        HashTagTroopInActiveData hashTagTroopInActiveData = new HashTagTroopInActiveData(groupType, new ArrayList());
        int size = troopList.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mobileqq.troop.adapter.contact.d dVar = troopList.get(i3);
            Intrinsics.checkNotNullExpressionValue(dVar, "troopList.get(index)");
            Object obj = dVar.f293809b;
            if (obj instanceof TroopInfo) {
                troopInfo = (TroopInfo) obj;
            } else {
                troopInfo = null;
            }
            if (troopInfo != null) {
                String i16 = i(troopInfo);
                String str = troopInfo.troopuin;
                Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
                HashTagTroopData hashTagTroopData = new HashTagTroopData(groupType, i16, str);
                if (i3 < 10) {
                    arrayList.add(hashTagTroopData);
                } else {
                    hashTagTroopInActiveData.d().add(hashTagTroopData);
                }
            }
        }
        if (!hashTagTroopInActiveData.d().isEmpty()) {
            arrayList.add(hashTagTroopInActiveData);
        }
        HashTagGroupData hashTagGroupData = new HashTagGroupData(groupType, groupType.getGroupName(), arrayList, false, null, 24, null);
        ArrayList<cp0.a> arrayList2 = new ArrayList<>();
        arrayList2.add(hashTagGroupData);
        arrayList2.addAll(arrayList);
        return arrayList2;
    }

    private final String i(TroopInfo troopInfo) {
        String remark = troopInfo.troopRemark;
        if (!TextUtils.isEmpty(remark)) {
            Intrinsics.checkNotNullExpressionValue(remark, "remark");
            return remark;
        }
        String troopDisplayName = troopInfo.getTroopDisplayName();
        if (!TextUtils.isEmpty(troopDisplayName)) {
            Intrinsics.checkNotNullExpressionValue(troopDisplayName, "{\n            displayName\n        }");
            return troopDisplayName;
        }
        String str = troopInfo.troopuin;
        Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<cp0.a> j(AppInterface qqAppInterface, List<? extends TroopInfo> allTroopInfoList) {
        ArrayList<com.tencent.mobileqq.troop.adapter.contact.d> arrayList = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.troop.adapter.contact.d> arrayList2 = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.troop.adapter.contact.d> arrayList3 = new ArrayList<>();
        for (TroopInfo troopInfo : allTroopInfoList) {
            if (!troopInfo.isQidianPrivateTroop()) {
                com.tencent.mobileqq.troop.adapter.contact.d dVar = new com.tencent.mobileqq.troop.adapter.contact.d(1, troopInfo);
                if (troopInfo.isOwner()) {
                    arrayList.add(dVar);
                } else if (troopInfo.isAdmin()) {
                    arrayList2.add(dVar);
                } else {
                    arrayList3.add(dVar);
                }
            }
        }
        ArrayList<cp0.a> arrayList4 = new ArrayList<>();
        arrayList4.addAll(h(new HashTagGroupType("\u6211\u521b\u5efa\u7684"), arrayList));
        arrayList4.addAll(h(new HashTagGroupType("\u6211\u7ba1\u7406\u7684"), arrayList2));
        arrayList4.addAll(h(new HashTagGroupType("\u6211\u52a0\u5165\u7684"), arrayList3));
        return arrayList4;
    }

    public final void d(@NotNull final AppInterface qqAppInterface, @NotNull final b fetchCallback) {
        Intrinsics.checkNotNullParameter(qqAppInterface, "qqAppInterface");
        Intrinsics.checkNotNullParameter(fetchCallback, "fetchCallback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.input.at.trooptag.model.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopListRepository.e(TroopListRepository.this, qqAppInterface, fetchCallback);
            }
        }, 16, null, false);
    }
}
