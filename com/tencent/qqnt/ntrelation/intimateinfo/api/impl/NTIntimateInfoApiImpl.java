package com.tencent.qqnt.ntrelation.intimateinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.Intimate;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi;
import com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkCacheEntityManager;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import com.tencent.qqnt.ntrelation.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J:\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J:\u0010\r\u001a\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0002j\b\u0012\u0004\u0012\u00020\u0007`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016J*\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH\u0016J \u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/NTIntimateInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IQQIntimateInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "getIntimateSimpleInfoWithUid", "ntIntimateSimpleInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "", "accurateUpdateIntimateInfo", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteIntimateInfo", "Lhx3/b;", "", "iQueryGeneralDataCallback", "getBindIntimateRelationshipFriendCount", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NTIntimateInfoApiImpl implements IQQIntimateInfoApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NTIntimateInfoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/NTIntimateInfoApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.intimateinfo.api.impl.NTIntimateInfoApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTIntimateInfoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateIntimateInfo$lambda$3(ArrayList ntIntimateSimpleInfo, hx3.c cVar, int i3, String str) {
        Intrinsics.checkNotNullParameter(ntIntimateSimpleInfo, "$ntIntimateSimpleInfo");
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
        eVar.e(ntIntimateSimpleInfo);
        if (cVar != null) {
            cVar.onUpdateResult(eVar);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void accurateUpdateIntimateInfo(@NotNull final ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> ntIntimateSimpleInfo, @Nullable String trace, @Nullable final hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iUpdateGeneralDataCallback) {
        String str;
        byte[] bArr;
        y f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, ntIntimateSimpleInfo, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntIntimateSimpleInfo, "ntIntimateSimpleInfo");
        d dVar = d.f360234a;
        if (trace == null) {
            str = "";
        } else {
            str = trace;
        }
        ProfileUpdateMsg$UpdateMsg d16 = dVar.d(str, ntIntimateSimpleInfo);
        if (d16 != null) {
            bArr = d16.toByteArray();
        } else {
            bArr = null;
        }
        if (bArr != null && (f16 = f.f()) != null) {
            if (trace == null) {
                trace = "";
            }
            f16.updateProfileData(trace, bArr, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.intimateinfo.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    NTIntimateInfoApiImpl.accurateUpdateIntimateInfo$lambda$3(ntIntimateSimpleInfo, iUpdateGeneralDataCallback, i3, str2);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void deleteIntimateInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, trace, iDeleteGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            com.tencent.qqnt.ntrelation.util.f.f360260a.b(uid, trace, iDeleteGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    public void getBindIntimateRelationshipFriendCount(@Nullable String trace, @NotNull hx3.b<Integer> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi
    @NotNull
    public ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> getIntimateSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        HashMap<String, Intimate> hashMap;
        String str;
        Intimate intimate;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            FriendListInfoCache a16 = FriendListInfoCache.INSTANCE.a();
            String b16 = com.tencent.qqnt.contacts.cache.a.f355804a.b();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            Object k3 = a16.k(b16, uid, trace);
            if (k3 != null && (k3 instanceof com.tencent.qqnt.ntrelation.intimateinfo.bean.a)) {
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
                str2 = "";
            } else {
                str2 = trace;
            }
            hashMap = f16.getIntimate(str2, arrayList2);
        } else {
            hashMap = null;
        }
        Iterator<String> it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            String uid2 = it5.next();
            d dVar = d.f360234a;
            if (trace == null) {
                str = "";
            } else {
                str = trace;
            }
            Intrinsics.checkNotNullExpressionValue(uid2, "uid");
            if (hashMap != null) {
                intimate = hashMap.get(uid2);
            } else {
                intimate = null;
            }
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a c16 = dVar.c(str, uid2, intimate);
            if (c16 != null) {
                arrayList.add(c16);
            } else {
                com.tencent.qqnt.ntrelation.intimateinfo.bean.a g16 = MutualMarkCacheEntityManager.f360092a.g(uid2);
                if (g16 != null) {
                    arrayList.add(g16);
                }
            }
        }
        return arrayList;
    }
}
