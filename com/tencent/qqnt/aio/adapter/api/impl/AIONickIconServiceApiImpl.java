package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.data.troop.TroopMemberNickIconInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITmMsgIconService;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.msg.nt_im_msg_general_flags_body$IconInfo;
import tencent.im.msg.nt_im_msg_general_flags_body$MsgIcon;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J(\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R&\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIONickIconServiceApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi;", "", "troopUin", "memberUin", "Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi$b;", "callback", "", "interGetTmInfoIconDataAsync", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "troopMemberIcon", "memberIcon", "combineIconData", "", "repeatNickIconBuffer", "getNickIconIdListFromCache", "convertStrToNickIconIdList", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService;", "getTmMsgIconService", "getTmInfoIconDataAsync", "getStaticIconDataList", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "getIdentityDataFromCacheOrFetchAsync", "", "isGlobalSwitchOpen", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "openTroopIdentityWearPage", "Landroidx/collection/LruCache;", "nickIconListCache", "Landroidx/collection/LruCache;", "troopMemberIconService", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIONickIconServiceApiImpl implements IAIONickIconServiceApi {
    private static final int MAX_CACHE_SIZE = 50;
    public static final String TAG = "AIONickIconServiceApiImpl";
    private final LruCache<byte[], List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b>> nickIconListCache = new LruCache<>(MAX_CACHE_SIZE);
    private ITmMsgIconService troopMemberIconService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIONickIconServiceApiImpl$b", "Lcom/tencent/qqnt/troopmemberlist/g;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.qqnt.troopmemberlist.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f348545b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f348546c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b>> f348547d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IAIONickIconServiceApi.b f348548e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> f348549f;

        b(String str, String str2, Ref.ObjectRef<List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b>> objectRef, IAIONickIconServiceApi.b bVar, ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> arrayList) {
            this.f348545b = str;
            this.f348546c = str2;
            this.f348547d = objectRef;
            this.f348548e = bVar;
            this.f348549f = arrayList;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, T] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List, T] */
        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(TroopMemberInfo troopMemberInfo) {
            TroopMemberInfoExt troopMemberInfoExt;
            TroopMemberInfoExt troopMemberInfoExt2;
            byte[] bArr = null;
            ?? nickIconIdListFromCache = AIONickIconServiceApiImpl.this.getNickIconIdListFromCache(this.f348545b, this.f348546c, (troopMemberInfo == null || (troopMemberInfoExt2 = troopMemberInfo.extInfo) == null) ? null : troopMemberInfoExt2.nickIconRepeatMsgBuffer);
            if (nickIconIdListFromCache != 0) {
                this.f348547d.element = nickIconIdListFromCache;
                this.f348548e.a(true, AIONickIconServiceApiImpl.this.combineIconData((List) nickIconIdListFromCache, this.f348549f));
                return;
            }
            Ref.ObjectRef<List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b>> objectRef = this.f348547d;
            AIONickIconServiceApiImpl aIONickIconServiceApiImpl = AIONickIconServiceApiImpl.this;
            String str = this.f348545b;
            String str2 = this.f348546c;
            if (troopMemberInfo != null && (troopMemberInfoExt = troopMemberInfo.extInfo) != null) {
                bArr = troopMemberInfoExt.nickIconRepeatMsgBuffer;
            }
            objectRef.element = aIONickIconServiceApiImpl.convertStrToNickIconIdList(str, str2, bArr);
            this.f348548e.a(false, AIONickIconServiceApiImpl.this.combineIconData(this.f348547d.element, this.f348549f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> combineIconData(List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> troopMemberIcon, List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> memberIcon) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getStaticIconDataList());
        arrayList.addAll(troopMemberIcon);
        arrayList.addAll(memberIcon);
        return arrayList;
    }

    private final ITmMsgIconService getTmMsgIconService() {
        if (this.troopMemberIconService == null) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            AppRuntime peekAppRuntime = mobileQQ != null ? mobileQQ.peekAppRuntime() : null;
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null) {
                this.troopMemberIconService = (ITmMsgIconService) appInterface.getRuntimeService(ITmMsgIconService.class, "");
            }
        }
        return this.troopMemberIconService;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
    private final void interGetTmInfoIconDataAsync(String troopUin, String memberUin, IAIONickIconServiceApi.b callback) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        ArrayList arrayList = new ArrayList();
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(troopUin, memberUin, false, null, TAG, new b(troopUin, memberUin, objectRef, callback, arrayList));
        ITmMsgIconService tmMsgIconService = getTmMsgIconService();
        if (tmMsgIconService != null) {
            tmMsgIconService.getMemberIconData(memberUin, new c(callback, this, objectRef, arrayList));
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c getIdentityDataFromCacheOrFetchAsync(String troopUin, String memberUin) {
        return ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).getIdentityDataFromCacheOrFetchAsync(troopUin, memberUin);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public void getTmInfoIconDataAsync(String troopUin, String memberUin, IAIONickIconServiceApi.b callback) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(troopUin.length() == 0)) {
            if (!(memberUin.length() == 0)) {
                interGetTmInfoIconDataAsync(troopUin, memberUin, callback);
                return;
            }
        }
        callback.a(false, new ArrayList());
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public boolean isGlobalSwitchOpen() {
        return ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).getGlobalSwitch();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public void openTroopIdentityWearPage(Context context, String troopUin, String memberUin, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).openTroopIdentityWearPage(context, troopUin, memberUin, bundle);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIONickIconServiceApiImpl$c", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService$a;", "Ltencent/im/msg/nt_im_msg_general_flags_body$MsgIcon;", "memberMsgIcon", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ITmMsgIconService.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IAIONickIconServiceApi.b f348550a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIONickIconServiceApiImpl f348551b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b>> f348552c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> f348553d;

        c(IAIONickIconServiceApi.b bVar, AIONickIconServiceApiImpl aIONickIconServiceApiImpl, Ref.ObjectRef<List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b>> objectRef, ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> arrayList) {
            this.f348550a = bVar;
            this.f348551b = aIONickIconServiceApiImpl;
            this.f348552c = objectRef;
            this.f348553d = arrayList;
        }

        @Override // com.tencent.mobileqq.troop.api.ITmMsgIconService.a
        public void a(nt_im_msg_general_flags_body$MsgIcon memberMsgIcon) {
            PBRepeatMessageField<nt_im_msg_general_flags_body$IconInfo> pBRepeatMessageField;
            List<nt_im_msg_general_flags_body$IconInfo> list;
            if (memberMsgIcon != null && (pBRepeatMessageField = memberMsgIcon.personal_icon_info) != null && (list = pBRepeatMessageField.get()) != null) {
                ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> arrayList = this.f348553d;
                for (nt_im_msg_general_flags_body$IconInfo nt_im_msg_general_flags_body_iconinfo : list) {
                    if (!nt_im_msg_general_flags_body_iconinfo.uint32_permission_switch.has() || nt_im_msg_general_flags_body_iconinfo.uint32_permission_switch.get() != 1) {
                        arrayList.add(new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(nt_im_msg_general_flags_body_iconinfo.uint32_biz_id.get(), nt_im_msg_general_flags_body_iconinfo.uint32_res_id.get(), nt_im_msg_general_flags_body_iconinfo.uint32_expired_time.get(), null, 8, null));
                    }
                }
            }
            this.f348550a.a(false, this.f348551b.combineIconData(this.f348552c.element, this.f348553d));
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONickIconServiceApi
    public List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> getStaticIconDataList() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(3, 0, Long.MAX_VALUE, null, 8, null), new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(2, 0, Long.MAX_VALUE, null, 8, null));
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> convertStrToNickIconIdList(String troopUin, String memberUin, byte[] repeatNickIconBuffer) {
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> emptyList;
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> list;
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> emptyList2;
        if (repeatNickIconBuffer == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        Object c16 = com.tencent.mobileqq.troop.troopapps.g.c(repeatNickIconBuffer);
        if (c16 != null && (c16 instanceof List)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : (Iterable) c16) {
                if ((obj instanceof TroopMemberNickIconInfo ? (TroopMemberNickIconInfo) obj : null) != null) {
                    TroopMemberNickIconInfo troopMemberNickIconInfo = (TroopMemberNickIconInfo) obj;
                    if (troopMemberNickIconInfo.getBizId() > 0) {
                        arrayList.add(new com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b(troopMemberNickIconInfo.getBizId(), troopMemberNickIconInfo.getResId(), troopMemberNickIconInfo.getExpireTime() != 0 ? troopMemberNickIconInfo.getExpireTime() : Long.MAX_VALUE, null, 8, null));
                    }
                }
            }
            LruCache<byte[], List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b>> lruCache = this.nickIconListCache;
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            lruCache.put(repeatNickIconBuffer, list);
            return arrayList;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 1, "[convertStrToNickIconIdList] troopUin = " + troopUin + " memberUin = " + memberUin + " repeatMemberIcon = " + c16);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> getNickIconIdListFromCache(String troopUin, String memberUin, byte[] repeatNickIconBuffer) {
        List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> emptyList;
        if (repeatNickIconBuffer == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 1, "[convertStrToNickIconIdList] troopUin = " + troopUin + " memberUin = " + memberUin + " repeatNickIconBuffer is null");
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return this.nickIconListCache.get(repeatNickIconBuffer);
    }
}
