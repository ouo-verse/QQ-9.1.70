package com.tencent.qqnt.ntrelation.otherinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.OtherFlag;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.impl.NTFriendsInfoApiImpl;
import com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import com.tencent.qqnt.ntrelation.util.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J.\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J*\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0016J(\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J0\u0010\u0014\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/impl/NTOtherInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/otherinfo/api/IQQOtherInfoApi;", "Ljava/util/ArrayList;", "", "uids", "trace", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "iQueryGeneralDataCallback", "", "getOtherInfoWithUid", "uid", "Lhx3/a;", "deleteCallback", "deleteNTOtherDetailInfo", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "getOtherSimpleInfoWithUid", "ntOtherDetailInfoList", "Lhx3/c;", "updateCallback", "accurateUpdateNTOtherDetailInfo", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NTOtherInfoApiImpl implements IQQOtherInfoApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NTIntimateInfoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/impl/NTOtherInfoApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.otherinfo.api.impl.NTOtherInfoApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTOtherInfoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateNTOtherDetailInfo$lambda$3(final ArrayList ntOtherDetailInfoList, final String str, final hx3.c cVar, int i3, String str2) {
        Intrinsics.checkNotNullParameter(ntOtherDetailInfoList, "$ntOtherDetailInfoList");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        eVar.f(str2);
        eVar.e(ntOtherDetailInfoList);
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            if (str != null) {
                str3 = str;
            }
            f16.updateStockLocalData(str3, com.tencent.qqnt.ntrelation.util.c.f360229a.k(ntOtherDetailInfoList), new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.otherinfo.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str4) {
                    NTOtherInfoApiImpl.accurateUpdateNTOtherDetailInfo$lambda$3$lambda$2(ntOtherDetailInfoList, str, cVar, eVar, i16, str4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateNTOtherDetailInfo$lambda$3$lambda$2(ArrayList ntOtherDetailInfoList, String str, hx3.c cVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, int i3, String str2) {
        Intrinsics.checkNotNullParameter(ntOtherDetailInfoList, "$ntOtherDetailInfoList");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        if (i3 == 0) {
            k.f360278a.a(ntOtherDetailInfoList, str);
        }
        if (cVar != null) {
            cVar.onUpdateResult(responseData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOtherInfoWithUid$lambda$1(hx3.b iQueryGeneralDataCallback, String str, ArrayList uids, int i3, String errMsg, Source source, HashMap hashMap) {
        HashMap<String, StockLocalData> hashMap2;
        StockLocalData stockLocalData;
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        Intrinsics.checkNotNullParameter(uids, "$uids");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        if (i3 != 0) {
            QLog.i(NTFriendsInfoApiImpl.TAG, 1, "getFriendsDetailInfoWithUid errMsg: " + errMsg);
            eVar.d(-1);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            eVar.f(errMsg);
            iQueryGeneralDataCallback.onQueryResult(eVar);
            return;
        }
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            if (str == null) {
                str = "";
            }
            hashMap2 = f16.getStockLocalData(str, uids);
        } else {
            hashMap2 = null;
        }
        Iterator it = uids.iterator();
        while (it.hasNext()) {
            String uid = (String) it.next();
            com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            UserDetailInfo userDetailInfo = (UserDetailInfo) hashMap.get(uid);
            if (hashMap2 == null) {
                stockLocalData = null;
            } else {
                stockLocalData = hashMap2.get(uid);
            }
            com.tencent.qqnt.ntrelation.otherinfo.bean.a g16 = cVar.g(uid, userDetailInfo, stockLocalData);
            ArrayList b16 = eVar.b();
            if (b16 != null) {
                b16.add(g16);
            }
        }
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    public void accurateUpdateNTOtherDetailInfo(@NotNull final ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> ntOtherDetailInfoList, @Nullable final String trace, @Nullable final hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.a> updateCallback) {
        byte[] bArr;
        y f16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, ntOtherDetailInfoList, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOtherDetailInfoList, "ntOtherDetailInfoList");
        ProfileUpdateMsg$UpdateMsg d16 = com.tencent.qqnt.ntrelation.util.c.f360229a.d(ntOtherDetailInfoList);
        if (d16 != null) {
            bArr = d16.toByteArray();
        } else {
            bArr = null;
        }
        if (bArr != null && (f16 = com.tencent.qqnt.msg.f.f()) != null) {
            if (trace == null) {
                str = "";
            } else {
                str = trace;
            }
            f16.updateProfileData(str, bArr, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.otherinfo.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    NTOtherInfoApiImpl.accurateUpdateNTOtherDetailInfo$lambda$3(ntOtherDetailInfoList, trace, updateCallback, i3, str2);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    public void deleteNTOtherDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.otherinfo.bean.a> deleteCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uid, trace, deleteCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            com.tencent.qqnt.ntrelation.util.f.f360260a.b(uid, trace, deleteCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    public void getOtherInfoWithUid(@NotNull final ArrayList<String> uids, @Nullable final String trace, @NotNull final hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> iQueryGeneralDataCallback) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uids, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            if (trace == null) {
                str = "";
            } else {
                str = trace;
            }
            f16.fetchUserDetailInfo(str, uids, Source.KDB, new ArrayList<>(Collections.singletonList(ProfileBizType.KALL)), new IDetailInfoCallback() { // from class: com.tencent.qqnt.ntrelation.otherinfo.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback
                public final void onResult(int i3, String str2, Source source, HashMap hashMap) {
                    NTOtherInfoApiImpl.getOtherInfoWithUid$lambda$1(hx3.b.this, trace, uids, i3, str2, source, hashMap);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> getOtherSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        HashMap<String, OtherFlag> hashMap;
        HashMap<String, RelationFlag> hashMap2;
        OtherFlag otherFlag;
        RelationFlag relationFlag;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            FriendListInfoCache a16 = FriendListInfoCache.INSTANCE.a();
            String d16 = com.tencent.qqnt.contacts.cache.a.f355804a.d();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            Object k3 = a16.k(d16, uid, trace);
            if (k3 != null && (k3 instanceof com.tencent.qqnt.ntrelation.otherinfo.bean.c)) {
                arrayList.add(k3);
            } else {
                arrayList2.add(uid);
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            if (trace == null) {
                str = "";
            } else {
                str = trace;
            }
            hashMap = f16.getOtherFlag(str, arrayList2);
        } else {
            hashMap = null;
        }
        y f17 = com.tencent.qqnt.msg.f.f();
        if (f17 != null) {
            if (trace == null) {
                trace = "";
            }
            hashMap2 = f17.getRelationFlag(trace, arrayList2);
        } else {
            hashMap2 = null;
        }
        Iterator<String> it5 = uids.iterator();
        while (it5.hasNext()) {
            String uid2 = it5.next();
            com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
            Intrinsics.checkNotNullExpressionValue(uid2, "uid");
            if (hashMap != null) {
                otherFlag = hashMap.get(uid2);
            } else {
                otherFlag = null;
            }
            if (hashMap2 != null) {
                relationFlag = hashMap2.get(uid2);
            } else {
                relationFlag = null;
            }
            arrayList.add(cVar.h(uid2, otherFlag, relationFlag));
        }
        return arrayList;
    }
}
