package com.tencent.qqnt.ntrelation.zoneinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.friendsinfo.api.impl.NTFriendsInfoApiImpl;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$Action;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$Buddy;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J8\u0010\u000e\u001a\u00020\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J*\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0016J*\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014H\u0016J:\u0010\u0018\u001a\u00020\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0016J:\u0010\u0013\u001a\u00020\r2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0002j\b\u0012\u0004\u0012\u00020\u000b`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/api/impl/NTZoneInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/api/IQQZoneInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "getZoneSimpleInfoWithUid", "uid", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "iQueryGeneralDataCallback", "", "getZoneDetailWithUid", "uidList", "ntZoneDetailInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateZoneDetailInfo", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteZoneDetailInfo", "ntZoneSimpleInfoList", "updateZoneSimpleInfo", "ntZoneDetailInfoList", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NTZoneInfoApiImpl implements IQQZoneInfoApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NTZoneInfoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/api/impl/NTZoneInfoApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.zoneinfo.api.impl.NTZoneInfoApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTZoneInfoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteZoneDetailInfo$lambda$2(hx3.a aVar, int i3, String str) {
        e eVar = new e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        if (str == null) {
            str = "";
        }
        eVar.f(str);
        if (aVar != null) {
            aVar.a(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getZoneDetailWithUid$lambda$1(hx3.b iQueryGeneralDataCallback, HashMap hashMap, int i3, String errMsg, Source source, HashMap detail) {
        StockLocalData stockLocalData;
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        e eVar = new e();
        if (i3 != 0) {
            QLog.i(NTFriendsInfoApiImpl.TAG, 1, "getFriendsDetailInfoWithUid errMsg: " + errMsg);
            eVar.d(-1);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            eVar.f(errMsg);
            iQueryGeneralDataCallback.onQueryResult(eVar);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(detail, "detail");
        for (Map.Entry entry : detail.entrySet()) {
            String uid = (String) entry.getKey();
            UserDetailInfo userDetailInfo = (UserDetailInfo) entry.getValue();
            com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            if (hashMap != null) {
                stockLocalData = (StockLocalData) hashMap.get(uid);
            } else {
                stockLocalData = null;
            }
            com.tencent.qqnt.ntrelation.zoneinfo.bean.a i16 = cVar.i(uid, userDetailInfo, stockLocalData);
            ArrayList b16 = eVar.b();
            if (b16 != null) {
                b16.add(i16);
            }
        }
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateZoneDetailInfo$lambda$4(ArrayList ntZoneDetailInfoList, hx3.c cVar, int i3, String str) {
        Intrinsics.checkNotNullParameter(ntZoneDetailInfoList, "$ntZoneDetailInfoList");
        e eVar = new e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        if (str == null) {
            str = "";
        }
        eVar.f(str);
        eVar.e(ntZoneDetailInfoList);
        if (cVar != null) {
            cVar.onUpdateResult(eVar);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void deleteZoneDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable final hx3.a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ProfileUpdateMsg$Buddy profileUpdateMsg$Buddy = new ProfileUpdateMsg$Buddy();
        profileUpdateMsg$Buddy.uid.set(uid);
        ProfileUpdateMsg$Action profileUpdateMsg$Action = new ProfileUpdateMsg$Action();
        profileUpdateMsg$Action.del_buddy.set(profileUpdateMsg$Buddy);
        ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
        ArrayList arrayList = new ArrayList();
        arrayList.add(profileUpdateMsg$Action);
        profileUpdateMsg$UpdateMsg.action.set(arrayList);
        y f16 = f.f();
        if (f16 != null) {
            if (trace == null) {
                trace = "";
            }
            byte[] byteArray = profileUpdateMsg$UpdateMsg.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "updateMsg.toByteArray()");
            f16.updateProfileData(trace, byteArray, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.zoneinfo.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTZoneInfoApiImpl.deleteZoneDetailInfo$lambda$2(hx3.a.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void getZoneDetailWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getZoneDetailWithUid(new ArrayList<>(Collections.singletonList(uid)), trace, iQueryGeneralDataCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> getZoneSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        HashMap<String, StockLocalData> hashMap;
        StockLocalData stockLocalData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            FriendListInfoCache a16 = FriendListInfoCache.INSTANCE.a();
            String g16 = com.tencent.qqnt.contacts.cache.a.f355804a.g();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            Object k3 = a16.k(g16, uid, trace);
            if (k3 != null && (k3 instanceof com.tencent.qqnt.ntrelation.zoneinfo.bean.c)) {
                arrayList.add(k3);
            } else {
                arrayList2.add(uid);
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        y f16 = f.f();
        if (f16 != null) {
            if (trace == null) {
                trace = "";
            }
            hashMap = f16.getStockLocalData(trace, arrayList2);
        } else {
            hashMap = null;
        }
        Iterator<String> it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            String uid2 = it5.next();
            com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
            Intrinsics.checkNotNullExpressionValue(uid2, "uid");
            if (hashMap != null) {
                stockLocalData = hashMap.get(uid2);
            } else {
                stockLocalData = null;
            }
            arrayList.add(cVar.j(uid2, stockLocalData));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneDetailInfo(@NotNull com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, ntZoneDetailInfo, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneDetailInfo, "ntZoneDetailInfo");
        ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> arrayList = new ArrayList<>();
        arrayList.add(ntZoneDetailInfo);
        updateZoneDetailInfo(arrayList, trace, iUpdateGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> ntZoneSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, ntZoneSimpleInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneSimpleInfoList, "ntZoneSimpleInfoList");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void getZoneDetailWithUid(@NotNull ArrayList<String> uidList, @Nullable String trace, @NotNull final hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        final HashMap<String, StockLocalData> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uidList, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        y f16 = f.f();
        if (f16 != null) {
            hashMap = f16.getStockLocalData(trace == null ? "" : trace, uidList);
        } else {
            hashMap = null;
        }
        y f17 = f.f();
        if (f17 != null) {
            f17.fetchUserDetailInfo(trace == null ? "" : trace, uidList, Source.KDB, new ArrayList<>(Collections.singletonList(ProfileBizType.KALL)), new IDetailInfoCallback() { // from class: com.tencent.qqnt.ntrelation.zoneinfo.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback
                public final void onResult(int i3, String str, Source source, HashMap hashMap2) {
                    NTZoneInfoApiImpl.getZoneDetailWithUid$lambda$1(hx3.b.this, hashMap, i3, str, source, hashMap2);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi
    public void updateZoneDetailInfo(@NotNull final ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> ntZoneDetailInfoList, @Nullable String trace, @Nullable final hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, ntZoneDetailInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneDetailInfoList, "ntZoneDetailInfoList");
        HashMap<String, StockLocalData> hashMap = new HashMap<>();
        Iterator<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> it = ntZoneDetailInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.zoneinfo.bean.a next = it.next();
            StockLocalData stockLocalData = new StockLocalData();
            stockLocalData.feedContent = next.b();
            stockLocalData.feedHasPhoto = Boolean.valueOf(next.c());
            hashMap.put(next.getUid(), stockLocalData);
        }
        y f16 = f.f();
        if (f16 != null) {
            f16.updateStockLocalData(trace == null ? "" : trace, hashMap, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.zoneinfo.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTZoneInfoApiImpl.updateZoneDetailInfo$lambda$3(i3, str);
                }
            });
        }
        byte[] pb5 = new ProfileUpdateMsg$UpdateMsg().toByteArray();
        y f17 = f.f();
        if (f17 != null) {
            if (trace == null) {
                trace = "";
            }
            Intrinsics.checkNotNullExpressionValue(pb5, "pb");
            f17.updateProfileData(trace, pb5, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.zoneinfo.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTZoneInfoApiImpl.updateZoneDetailInfo$lambda$4(ntZoneDetailInfoList, iUpdateGeneralDataCallback, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateZoneDetailInfo$lambda$3(int i3, String str) {
    }
}
