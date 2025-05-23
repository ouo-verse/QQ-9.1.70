package com.tencent.qqnt.ntrelation.intimateinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IQQIntimateInfoApi;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J>\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u000b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0016J*\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0016J:\u0010\u0015\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0016J*\u0010\u0018\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016J \u0010\u001a\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fH\u0016R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0017\u0010 \u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b \u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/IntimateInfoServiceImpl;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IIntimateInfoService;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IQQIntimateInfoApi;", "getAbsServiceImpl", "getReverseServiceImpl", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "getIntimateSimpleInfoWithUid", "uid", "", "isObserver", "Lhx3/b;", "iQueryGeneralDataCallback", "", "ntIntimateSimpleInfo", "Lhx3/c;", "iUpdateGeneralDataCallback", "accurateUpdateIntimateSimpleInfo", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteIntimateInfo", "", "getBindIntimateRelationshipFriendCount", "absApiImpl", "Lcom/tencent/qqnt/ntrelation/intimateinfo/api/IQQIntimateInfoApi;", "isNew", "Z", "()Z", "isNTLogOpen", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class IntimateInfoServiceImpl implements IIntimateInfoService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "IntimateInfoServiceImpl";

    @NotNull
    private IQQIntimateInfoApi absApiImpl;
    private final boolean isNTLogOpen;
    private final boolean isNew;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/api/impl/IntimateInfoServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.intimateinfo.api.impl.IntimateInfoServiceImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public IntimateInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.absApiImpl = new NTIntimateInfoApiImpl();
        this.isNew = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService();
        this.isNTLogOpen = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();
    }

    private final IQQIntimateInfoApi getAbsServiceImpl() {
        IQQIntimateInfoApi iQQIntimateInfoApi;
        String str;
        IQQIntimateInfoApi iQQIntimateInfoApi2 = this.absApiImpl;
        if (iQQIntimateInfoApi2 != null) {
            boolean z16 = this.isNew;
            if (z16 && (iQQIntimateInfoApi2 instanceof NTIntimateInfoApiImpl)) {
                return iQQIntimateInfoApi2;
            }
            if (!z16 && !(iQQIntimateInfoApi2 instanceof NTIntimateInfoApiImpl)) {
                return iQQIntimateInfoApi2;
            }
        }
        if (this.isNew) {
            iQQIntimateInfoApi = new NTIntimateInfoApiImpl();
        } else {
            iQQIntimateInfoApi = (IQQIntimateInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQIntimateInfoApi.class);
        }
        this.absApiImpl = iQQIntimateInfoApi;
        if (iQQIntimateInfoApi != null) {
            str = iQQIntimateInfoApi.getClass().getName();
        } else {
            str = null;
        }
        QLog.d(TAG, 1, "getFriendsSimpleInfo abServiceImpl is " + str);
        return this.absApiImpl;
    }

    private final IQQIntimateInfoApi getReverseServiceImpl() {
        if (!this.isNew) {
            return new NTIntimateInfoApiImpl();
        }
        return (IQQIntimateInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQIntimateInfoApi.class);
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService
    public void accurateUpdateIntimateSimpleInfo(@NotNull com.tencent.qqnt.ntrelation.intimateinfo.bean.a ntIntimateSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, ntIntimateSimpleInfo, trace, iUpdateGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(ntIntimateSimpleInfo, "ntIntimateSimpleInfo");
            accurateUpdateIntimateSimpleInfo(new ArrayList<>(Collections.singletonList(ntIntimateSimpleInfo)), trace, iUpdateGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService
    public void deleteIntimateInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        getAbsServiceImpl().deleteIntimateInfo(uid, trace, iDeleteGeneralDataCallback);
        getReverseServiceImpl().deleteIntimateInfo(uid, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService
    public void getBindIntimateRelationshipFriendCount(@Nullable String trace, @NotNull hx3.b<Integer> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            getAbsServiceImpl().getBindIntimateRelationshipFriendCount(trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> getIntimateSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        if (uids.size() > Integer.MAX_VALUE) {
            return new ArrayList<>();
        }
        return getAbsServiceImpl().getIntimateSimpleInfoWithUid(uids, trace);
    }

    public final boolean isNTLogOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isNTLogOpen;
    }

    public final boolean isNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isNew;
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService
    public void accurateUpdateIntimateSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> ntIntimateSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, ntIntimateSimpleInfo, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntIntimateSimpleInfo, "ntIntimateSimpleInfo");
        getAbsServiceImpl().accurateUpdateIntimateInfo(ntIntimateSimpleInfo, trace, iUpdateGeneralDataCallback);
        getReverseServiceImpl().accurateUpdateIntimateInfo(ntIntimateSimpleInfo, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService
    @Nullable
    public com.tencent.qqnt.ntrelation.intimateinfo.bean.a getIntimateSimpleInfoWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.ntrelation.intimateinfo.bean.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> intimateSimpleInfoWithUid = getIntimateSimpleInfoWithUid(arrayList, trace);
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = (intimateSimpleInfoWithUid == null || intimateSimpleInfoWithUid.size() == 0) ? null : intimateSimpleInfoWithUid.get(0);
        if (this.isNTLogOpen && aVar != null) {
            QLog.i(TAG, 1, "getIntimateSimpleInfoWithUid[" + trace + "][" + uid + "] = IconFlagData: " + aVar.c());
            try {
                JSONArray jSONArray = new JSONArray(aVar.m());
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    QLog.e(TAG, 1, jSONArray.getJSONObject(i3).toString());
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        return aVar;
    }

    @Override // com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService
    public void getIntimateSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.intimateinfo.manager.a.f360090a.a(uid, trace, iQueryGeneralDataCallback);
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = getIntimateSimpleInfoWithUid(uid, trace);
        ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> arrayList = new ArrayList<>();
        if (intimateSimpleInfoWithUid != null) {
            arrayList.add(intimateSimpleInfoWithUid);
        }
        e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar = new e<>();
        eVar.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }
}
