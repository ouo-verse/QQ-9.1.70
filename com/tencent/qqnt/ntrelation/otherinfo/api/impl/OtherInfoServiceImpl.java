package com.tencent.qqnt.ntrelation.otherinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IQQOtherInfoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0016J>\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J8\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J*\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0016J:\u0010\u001a\u001a\u00020\u00062\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0013j\b\u0012\u0004\u0012\u00020\u0004`\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0016J:\u0010\u001c\u001a\u00020\u00062\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018H\u0016J*\u0010\u001f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001dH\u0016R\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010\"\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/impl/OtherInfoServiceImpl;", "Lcom/tencent/qqnt/ntrelation/otherinfo/api/IOtherInfoService;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "ntOtherDetailInfo", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "ntOtherSimpleInfo", "", "simpleInfo2DetailInfo", "Lcom/tencent/qqnt/ntrelation/otherinfo/api/IQQOtherInfoApi;", "getAbsServiceImpl", "getReverseServiceImpl", "", "uid", "trace", "getOtherSimpleInfoWithUid", "", "isObserver", "Lhx3/b;", "iQueryGeneralDataCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "getOtherInfoWithUid", "getControlGroupOtherInfoWithUid", "Lhx3/c;", "updateCallback", "accurateUpdateNTOtherSimpleInfo", "ntOtherSimpleInfoList", "accurateUpdateNTOtherDetailInfo", "Lhx3/a;", "deleteCallback", "deleteNTOtherDetailInfo", "absApiImpl", "Lcom/tencent/qqnt/ntrelation/otherinfo/api/IQQOtherInfoApi;", "isNew", "Z", "()Z", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OtherInfoServiceImpl implements IOtherInfoService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "OtherInfoServiceImpl";

    @NotNull
    private IQQOtherInfoApi absApiImpl;
    private final boolean isNew;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/api/impl/OtherInfoServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.otherinfo.api.impl.OtherInfoServiceImpl$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/otherinfo/api/impl/OtherInfoServiceImpl$b", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> f360177a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> f360178b;

        b(hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> cVar, ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList) {
            this.f360177a = cVar;
            this.f360178b = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) arrayList);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            if (responseData == null) {
                hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> cVar = this.f360177a;
                if (cVar != null) {
                    cVar.onUpdateResult(null);
                    return;
                }
                return;
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
            eVar.f(responseData.c());
            eVar.d(responseData.a());
            eVar.e(this.f360178b);
            hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> cVar2 = this.f360177a;
            if (cVar2 != null) {
                cVar2.onUpdateResult(eVar);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37506);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public OtherInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.absApiImpl = new NTOtherInfoApiImpl();
            this.isNew = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService();
        }
    }

    private final IQQOtherInfoApi getAbsServiceImpl() {
        IQQOtherInfoApi iQQOtherInfoApi;
        String str;
        IQQOtherInfoApi iQQOtherInfoApi2 = this.absApiImpl;
        if (iQQOtherInfoApi2 != null) {
            boolean z16 = this.isNew;
            if (z16 && (iQQOtherInfoApi2 instanceof NTOtherInfoApiImpl)) {
                return iQQOtherInfoApi2;
            }
            if (!z16 && !(iQQOtherInfoApi2 instanceof NTOtherInfoApiImpl)) {
                return iQQOtherInfoApi2;
            }
        }
        if (this.isNew) {
            iQQOtherInfoApi = new NTOtherInfoApiImpl();
        } else {
            iQQOtherInfoApi = (IQQOtherInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQOtherInfoApi.class);
        }
        this.absApiImpl = iQQOtherInfoApi;
        if (iQQOtherInfoApi != null) {
            str = iQQOtherInfoApi.getClass().getName();
        } else {
            str = null;
        }
        QLog.d(TAG, 1, "getOtherInfo abServiceImpl is " + str);
        return this.absApiImpl;
    }

    private final IQQOtherInfoApi getReverseServiceImpl() {
        if (!this.isNew) {
            return new NTOtherInfoApiImpl();
        }
        return (IQQOtherInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQOtherInfoApi.class);
    }

    private final void simpleInfo2DetailInfo(com.tencent.qqnt.ntrelation.otherinfo.bean.a ntOtherDetailInfo, com.tencent.qqnt.ntrelation.otherinfo.bean.c ntOtherSimpleInfo) {
        ntOtherDetailInfo.t(ntOtherSimpleInfo.getUid());
        ntOtherDetailInfo.u(ntOtherSimpleInfo.j());
        ntOtherDetailInfo.n(ntOtherSimpleInfo.k());
        ntOtherDetailInfo.r(ntOtherSimpleInfo.l());
        ntOtherDetailInfo.o(ntOtherSimpleInfo.b());
        ntOtherDetailInfo.q(ntOtherSimpleInfo.e());
        ntOtherDetailInfo.s(ntOtherSimpleInfo.f());
        ntOtherDetailInfo.p(ntOtherSimpleInfo.c());
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void accurateUpdateNTOtherDetailInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> ntOtherSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.a> updateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, ntOtherSimpleInfoList, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOtherSimpleInfoList, "ntOtherSimpleInfoList");
        getAbsServiceImpl().accurateUpdateNTOtherDetailInfo(ntOtherSimpleInfoList, trace, updateCallback);
        getReverseServiceImpl().accurateUpdateNTOtherDetailInfo(ntOtherSimpleInfoList, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void accurateUpdateNTOtherSimpleInfo(@NotNull com.tencent.qqnt.ntrelation.otherinfo.bean.c ntOtherSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> updateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, ntOtherSimpleInfo, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOtherSimpleInfo, "ntOtherSimpleInfo");
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList = new ArrayList<>();
        arrayList.add(ntOtherSimpleInfo);
        accurateUpdateNTOtherSimpleInfo(arrayList, trace, updateCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void deleteNTOtherDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.otherinfo.bean.a> deleteCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, uid, trace, deleteCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        getAbsServiceImpl().deleteNTOtherDetailInfo(uid, trace, deleteCallback);
        getReverseServiceImpl().deleteNTOtherDetailInfo(uid, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void getControlGroupOtherInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        getReverseServiceImpl().getOtherInfoWithUid(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void getOtherInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getOtherInfoWithUid(uid, false, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    @Nullable
    public com.tencent.qqnt.ntrelation.otherinfo.bean.c getOtherSimpleInfoWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.ntrelation.otherinfo.bean.c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> otherSimpleInfoWithUid = getOtherSimpleInfoWithUid(arrayList, trace);
        if (otherSimpleInfoWithUid == null || otherSimpleInfoWithUid.size() == 0) {
            return null;
        }
        return otherSimpleInfoWithUid.get(0);
    }

    public final boolean isNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isNew;
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void getOtherInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.otherinfo.manager.a.f360224a.a(uid, trace, iQueryGeneralDataCallback);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        getOtherInfoWithUid(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void accurateUpdateNTOtherSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> ntOtherSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> updateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, ntOtherSimpleInfoList, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOtherSimpleInfoList, "ntOtherSimpleInfoList");
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar : ntOtherSimpleInfoList) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(null, null, 3, null);
            aVar.m();
            simpleInfo2DetailInfo(aVar, cVar);
            arrayList.add(aVar);
        }
        accurateUpdateNTOtherDetailInfo(arrayList, trace, new b(updateCallback, ntOtherSimpleInfoList));
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void getOtherInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uids, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().getOtherInfoWithUid(uids, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    public void getOtherSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.otherinfo.manager.a.f360224a.b(uid, trace, iQueryGeneralDataCallback);
        }
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = getOtherSimpleInfoWithUid(uid, trace);
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList = new ArrayList<>();
        if (otherSimpleInfoWithUid != null) {
            arrayList.add(otherSimpleInfoWithUid);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> getOtherSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return getAbsServiceImpl().getOtherSimpleInfoWithUid(uids, trace);
    }
}
