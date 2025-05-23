package com.tencent.qqnt.ntrelation.vasinfo.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.VasInfo;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.friendsinfo.api.impl.NTFriendsInfoApiImpl;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import com.tencent.qqnt.ntrelation.util.m;
import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi;
import com.tencent.qqnt.ntrelation.vasinfo.api.impl.NTVasInfoApiImpl;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import hx3.a;
import hx3.b;
import hx3.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J*\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010H\u0016J2\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010H\u0016J:\u0010\u0015\u001a\u00020\r2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H\u0016J*\u0010\u0018\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/api/impl/NTVasInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/vasinfo/api/IQQVasInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "getVasSimpleInfoWithUid", "uid", "Lhx3/b;", "Lkx3/a;", "iQueryGeneralDataCallback", "", "getVasInfoWithUid", "ntVasDetailInfo", "Lhx3/c;", "updateCallback", "updateVasDetailInfo", "originDetailInfo", "changedDetailInfo", "accurateUpdateVasDetailInfo", "Lhx3/a;", "deleteCallback", "deleteVasDetailInfo", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NTVasInfoApiImpl implements IQQVasInfoApi {

    @NotNull
    public static final String TAG = "NTVasInfoApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateVasDetailInfo$lambda$10(ArrayList changedDetailInfo, HashMap hashMap, c cVar, String str, int i3, String str2) {
        y f16;
        Intrinsics.checkNotNullParameter(changedDetailInfo, "$changedDetailInfo");
        e eVar = new e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        if (str2 == null) {
            str2 = "";
        }
        eVar.f(str2);
        eVar.e(changedDetailInfo);
        if (hashMap != null && (f16 = f.f()) != null) {
            if (str == null) {
                str = "";
            }
            f16.updateStockLocalData(str, hashMap, new IOperateCallback() { // from class: jx3.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str3) {
                    NTVasInfoApiImpl.accurateUpdateVasDetailInfo$lambda$10$lambda$9$lambda$8(i16, str3);
                }
            });
        }
        if (cVar != null) {
            cVar.onUpdateResult(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getVasInfoWithUid$lambda$1(b iQueryGeneralDataCallback, String str, String uid, int i3, String errMsg, Source source, HashMap hashMap) {
        HashMap<String, StockLocalData> hashMap2;
        String str2;
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        Intrinsics.checkNotNullParameter(uid, "$uid");
        e eVar = new e();
        if (i3 != 0) {
            QLog.i(NTFriendsInfoApiImpl.TAG, 1, "getFriendsDetailInfoWithUid errMsg: " + errMsg);
            eVar.d(-1);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            eVar.f(errMsg);
            iQueryGeneralDataCallback.onQueryResult(eVar);
            return;
        }
        y f16 = f.f();
        StockLocalData stockLocalData = null;
        if (f16 != null) {
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            hashMap2 = f16.getStockLocalData(str2, new ArrayList<>(Collections.singletonList(uid)));
        } else {
            hashMap2 = null;
        }
        m mVar = m.f360286a;
        if (str == null) {
            str = "";
        }
        UserDetailInfo userDetailInfo = (UserDetailInfo) hashMap.get(uid);
        if (hashMap2 != null) {
            stockLocalData = hashMap2.get(uid);
        }
        eVar.e(new ArrayList(Collections.singletonList(mVar.a(str, uid, userDetailInfo, stockLocalData))));
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateVasDetailInfo$lambda$3(ArrayList ntVasDetailInfoList, String str, HashMap updateLocalDataList, c cVar, int i3, String str2) {
        Intrinsics.checkNotNullParameter(ntVasDetailInfoList, "$ntVasDetailInfoList");
        Intrinsics.checkNotNullParameter(updateLocalDataList, "$updateLocalDataList");
        e eVar = new e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        if (str2 == null) {
            str2 = "";
        }
        eVar.f(str2);
        eVar.e(ntVasDetailInfoList);
        y f16 = f.f();
        if (f16 != null) {
            if (str == null) {
                str = "";
            }
            f16.updateStockLocalData(str, updateLocalDataList, new IOperateCallback() { // from class: jx3.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str3) {
                    NTVasInfoApiImpl.updateVasDetailInfo$lambda$3$lambda$2(i16, str3);
                }
            });
        }
        if (cVar != null) {
            cVar.onUpdateResult(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateVasDetailInfo$lambda$6(ArrayList changedDetailInfoList, HashMap hashMap, c cVar, String str, int i3, String str2) {
        y f16;
        Intrinsics.checkNotNullParameter(changedDetailInfoList, "$changedDetailInfoList");
        e eVar = new e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        if (str2 == null) {
            str2 = "";
        }
        eVar.f(str2);
        eVar.e(changedDetailInfoList);
        if (hashMap != null && (f16 = f.f()) != null) {
            if (str == null) {
                str = "";
            }
            f16.updateStockLocalData(str, hashMap, new IOperateCallback() { // from class: jx3.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str3) {
                    NTVasInfoApiImpl.updateVasDetailInfo$lambda$6$lambda$5$lambda$4(i16, str3);
                }
            });
        }
        if (cVar != null) {
            cVar.onUpdateResult(eVar);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void accurateUpdateVasDetailInfo(@NotNull final ArrayList<NTVasSimpleInfo> changedDetailInfo, @Nullable final String trace, @Nullable final c<NTVasSimpleInfo> updateCallback) {
        String str;
        HashMap<String, StockLocalData> hashMap;
        y f16;
        String str2;
        Intrinsics.checkNotNullParameter(changedDetailInfo, "changedDetailInfo");
        m mVar = m.f360286a;
        String str3 = "";
        if (trace == null) {
            str = "";
        } else {
            str = trace;
        }
        ProfileUpdateMsg$UpdateMsg c16 = mVar.c(str, changedDetailInfo);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<T> it = changedDetailInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(((NTVasSimpleInfo) it.next()).getUid());
        }
        y f17 = f.f();
        byte[] bArr = null;
        if (f17 != null) {
            if (trace == null) {
                str2 = "";
            } else {
                str2 = trace;
            }
            hashMap = f17.getStockLocalData(str2, arrayList);
        } else {
            hashMap = null;
        }
        final HashMap<String, StockLocalData> f18 = m.f360286a.f(changedDetailInfo, hashMap);
        if (c16 != null) {
            bArr = c16.toByteArray();
        }
        if (bArr != null && (f16 = f.f()) != null) {
            if (trace != null) {
                str3 = trace;
            }
            f16.updateProfileData(str3, bArr, new IOperateCallback() { // from class: jx3.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str4) {
                    NTVasInfoApiImpl.accurateUpdateVasDetailInfo$lambda$10(changedDetailInfo, f18, updateCallback, trace, i3, str4);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void deleteVasDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable a<kx3.a> deleteCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.ntrelation.util.f.f360260a.b(uid, trace, deleteCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void getVasInfoWithUid(@NotNull final String uid, @Nullable final String trace, @NotNull final b<kx3.a> iQueryGeneralDataCallback) {
        String str;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        y f16 = f.f();
        if (f16 != null) {
            if (trace == null) {
                str = "";
            } else {
                str = trace;
            }
            f16.fetchUserDetailInfo(str, new ArrayList<>(Collections.singletonList(uid)), Source.KDB, new ArrayList<>(Collections.singletonList(ProfileBizType.KALL)), new IDetailInfoCallback() { // from class: jx3.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback
                public final void onResult(int i3, String str2, Source source, HashMap hashMap) {
                    NTVasInfoApiImpl.getVasInfoWithUid$lambda$1(hx3.b.this, trace, uid, i3, str2, source, hashMap);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    @Nullable
    public ArrayList<NTVasSimpleInfo> getVasSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        HashMap<String, VasInfo> hashMap;
        HashMap<String, StockLocalData> hashMap2;
        String str;
        VasInfo vasInfo;
        StockLocalData stockLocalData;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            FriendListInfoCache a16 = FriendListInfoCache.INSTANCE.a();
            String f16 = com.tencent.qqnt.contacts.cache.a.f355804a.f();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            Object k3 = a16.k(f16, uid, trace);
            if (k3 != null && (k3 instanceof NTVasSimpleInfo)) {
                arrayList.add(k3);
            } else {
                arrayList2.add(uid);
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        y f17 = f.f();
        if (f17 != null) {
            if (trace == null) {
                str3 = "";
            } else {
                str3 = trace;
            }
            hashMap = f17.getVasInfo(str3, arrayList2);
        } else {
            hashMap = null;
        }
        y f18 = f.f();
        if (f18 != null) {
            if (trace == null) {
                str2 = "";
            } else {
                str2 = trace;
            }
            hashMap2 = f18.getStockLocalData(str2, arrayList2);
        } else {
            hashMap2 = null;
        }
        Iterator<String> it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            String uid2 = it5.next();
            try {
                m mVar = m.f360286a;
                if (trace == null) {
                    str = "";
                } else {
                    str = trace;
                }
                Intrinsics.checkNotNullExpressionValue(uid2, "uid");
                if (hashMap != null) {
                    vasInfo = hashMap.get(uid2);
                } else {
                    vasInfo = null;
                }
                if (hashMap2 != null) {
                    stockLocalData = hashMap2.get(uid2);
                } else {
                    stockLocalData = null;
                }
                NTVasSimpleInfo b16 = mVar.b(str, uid2, vasInfo, stockLocalData);
                if (b16 != null) {
                    arrayList.add(b16);
                }
            } catch (Error e16) {
                QLog.e(TAG, 1, "getVasSimpleInfoWithUid error happened", e16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void updateVasDetailInfo(@NotNull kx3.a ntVasDetailInfo, @Nullable final String trace, @Nullable final c<kx3.a> updateCallback) {
        y f16;
        Intrinsics.checkNotNullParameter(ntVasDetailInfo, "ntVasDetailInfo");
        final ArrayList<kx3.a> arrayList = new ArrayList<>();
        arrayList.add(ntVasDetailInfo);
        m mVar = m.f360286a;
        ProfileUpdateMsg$UpdateMsg g16 = mVar.g(trace == null ? "" : trace, arrayList);
        final HashMap<String, StockLocalData> h16 = mVar.h(arrayList);
        byte[] byteArray = g16 != null ? g16.toByteArray() : null;
        if (byteArray == null || (f16 = f.f()) == null) {
            return;
        }
        f16.updateProfileData(trace != null ? trace : "", byteArray, new IOperateCallback() { // from class: jx3.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                NTVasInfoApiImpl.updateVasDetailInfo$lambda$3(arrayList, trace, h16, updateCallback, i3, str);
            }
        });
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void updateVasDetailInfo(@NotNull kx3.a originDetailInfo, @NotNull kx3.a changedDetailInfo, @Nullable final String trace, @Nullable final c<kx3.a> updateCallback) {
        HashMap<String, StockLocalData> hashMap;
        y f16;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(originDetailInfo, "originDetailInfo");
        Intrinsics.checkNotNullParameter(changedDetailInfo, "changedDetailInfo");
        ArrayList<kx3.a> arrayList = new ArrayList<>();
        final ArrayList<kx3.a> arrayList2 = new ArrayList<>();
        arrayList.add(originDetailInfo);
        arrayList2.add(changedDetailInfo);
        m mVar = m.f360286a;
        ProfileUpdateMsg$UpdateMsg d16 = mVar.d(trace == null ? "" : trace, arrayList, arrayList2);
        y f17 = f.f();
        if (f17 != null) {
            String str = trace == null ? "" : trace;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(changedDetailInfo.getUid());
            hashMap = f17.getStockLocalData(str, new ArrayList<>(arrayListOf));
        } else {
            hashMap = null;
        }
        final HashMap<String, StockLocalData> e16 = mVar.e(arrayList, arrayList2, hashMap);
        byte[] byteArray = d16 != null ? d16.toByteArray() : null;
        if (byteArray == null || (f16 = f.f()) == null) {
            return;
        }
        f16.updateProfileData(trace != null ? trace : "", byteArray, new IOperateCallback() { // from class: jx3.g
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                NTVasInfoApiImpl.updateVasDetailInfo$lambda$6(arrayList2, e16, updateCallback, trace, i3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateVasDetailInfo$lambda$10$lambda$9$lambda$8(int i3, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateVasDetailInfo$lambda$3$lambda$2(int i3, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateVasDetailInfo$lambda$6$lambda$5$lambda$4(int i3, String str) {
    }
}
