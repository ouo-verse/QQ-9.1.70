package com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.impl.NTFriendsInfoApiImpl;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import com.tencent.qqnt.ntrelation.util.f;
import com.tencent.qqnt.ntrelation.util.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J8\u0010\r\u001a\u00020\f2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J:\u0010\u0011\u001a\u00020\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0002j\b\u0012\u0004\u0012\u00020\n`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0016J*\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/NTOnlineStatusInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/IQQOnlineStatusInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "getOnlineStatusSimpleInfoWithUid", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "iQueryGeneralDataCallback", "", "getOnlineStatusInfoWithUid", "ntOnlineStatusDetailInfoList", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateOnlineStatusInfo", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteOnlineStatusInfo", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NTOnlineStatusInfoApiImpl implements IQQOnlineStatusInfoApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NTOnlineStatusInfoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/NTOnlineStatusInfoApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl.NTOnlineStatusInfoApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37253);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTOnlineStatusInfoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getOnlineStatusInfoWithUid$lambda$2(hx3.b iQueryGeneralDataCallback, String str, int i3, String errMsg, Source source, HashMap detail) {
        String str2;
        ArrayList b16;
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
            j jVar = j.f360277a;
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a a16 = jVar.a(str2, uid, userDetailInfo);
            if (a16 != null && (b16 = eVar.b()) != null) {
                b16.add(a16);
            }
        }
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void deleteOnlineStatusInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uid, trace, iDeleteGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            f.f360260a.b(uid, trace, iDeleteGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void getOnlineStatusInfoWithUid(@NotNull ArrayList<String> uids, @Nullable final String trace, @NotNull final hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uids, trace, iQueryGeneralDataCallback);
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
            f16.fetchUserDetailInfo(str, uids, Source.KDB, new ArrayList<>(Collections.singletonList(ProfileBizType.KALL)), new IDetailInfoCallback() { // from class: com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback
                public final void onResult(int i3, String str2, Source source, HashMap hashMap) {
                    NTOnlineStatusInfoApiImpl.getOnlineStatusInfoWithUid$lambda$2(hx3.b.this, trace, i3, str2, source, hashMap);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    @Nullable
    public ArrayList<c> getOnlineStatusSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<c> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            FriendListInfoCache a16 = FriendListInfoCache.INSTANCE.a();
            String c16 = com.tencent.qqnt.contacts.cache.a.f355804a.c();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            Object k3 = a16.k(c16, uid, trace);
            if (k3 != null && (k3 instanceof c)) {
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
            HashMap<String, StatusInfo> statusInfo = f16.getStatusInfo(str, arrayList2);
            if (statusInfo != null) {
                Iterator<String> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    String uid2 = it5.next();
                    j jVar = j.f360277a;
                    if (trace == null) {
                        str2 = "";
                    } else {
                        str2 = trace;
                    }
                    Intrinsics.checkNotNullExpressionValue(uid2, "uid");
                    c b16 = jVar.b(str2, uid2, statusInfo.get(uid2));
                    if (b16 != null) {
                        arrayList.add(b16);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void updateOnlineStatusInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> ntOnlineStatusDetailInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, ntOnlineStatusDetailInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOnlineStatusDetailInfoList, "ntOnlineStatusDetailInfoList");
        e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> eVar = new e<>();
        eVar.d(0);
        eVar.e(ntOnlineStatusDetailInfoList);
        if (iUpdateGeneralDataCallback != null) {
            iUpdateGeneralDataCallback.onUpdateResult(eVar);
        }
    }
}
