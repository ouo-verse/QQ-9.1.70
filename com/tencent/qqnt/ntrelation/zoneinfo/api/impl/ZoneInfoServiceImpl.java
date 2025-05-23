package com.tencent.qqnt.ntrelation.zoneinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IQQZoneInfoApi;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J>\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J8\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J*\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0016J:\u0010\u001a\u001a\u00020\u00062\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0016J*\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0016J:\u0010\u001c\u001a\u00020\u00062\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018H\u0016J*\u0010 \u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0016R\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/api/impl/ZoneInfoServiceImpl;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/api/IZoneInfoService;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "ntZoneSimpleInfo", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "ntZoneDetailInfo", "", "simpleInfo2DetailInfo", "Lcom/tencent/qqnt/ntrelation/zoneinfo/api/IQQZoneInfoApi;", "getAbsServiceImpl", "getReverseServiceImpl", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "getZoneSimpleInfoWithUid", "uid", "", "isObserver", "Lhx3/b;", "iQueryGeneralDataCallback", "getZoneDetailInfoWithUid", "uidList", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateZoneDetailInfo", "ntZoneDetailInfoList", "updateZoneSimpleInfo", "ntZoneSimpleInfoList", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteZoneDetailInfo", "absApiImpl", "Lcom/tencent/qqnt/ntrelation/zoneinfo/api/IQQZoneInfoApi;", "isNew", "Z", "()Z", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ZoneInfoServiceImpl implements IZoneInfoService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ZoneInfoServiceImpl";

    @NotNull
    private IQQZoneInfoApi absApiImpl;
    private final boolean isNew;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/api/impl/ZoneInfoServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.zoneinfo.api.impl.ZoneInfoServiceImpl$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/zoneinfo/api/impl/ZoneInfoServiceImpl$b", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap<String, com.tencent.qqnt.ntrelation.zoneinfo.bean.c> f360302a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZoneInfoServiceImpl f360303b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f360304c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> f360305d;

        b(HashMap<String, com.tencent.qqnt.ntrelation.zoneinfo.bean.c> hashMap, ZoneInfoServiceImpl zoneInfoServiceImpl, String str, hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> cVar) {
            this.f360302a = hashMap;
            this.f360303b = zoneInfoServiceImpl;
            this.f360304c = str;
            this.f360305d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, hashMap, zoneInfoServiceImpl, str, cVar);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable e<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> responseData) {
            boolean z16;
            ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            boolean z17 = true;
            if (responseData != null && responseData.a() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return;
            }
            if (responseData != null) {
                arrayList = responseData.b();
            } else {
                arrayList = null;
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                z17 = false;
            }
            if (z17) {
                return;
            }
            Iterator<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfoList = it.next();
                Intrinsics.checkNotNullExpressionValue(ntZoneDetailInfoList, "ntZoneDetailInfoList");
                com.tencent.qqnt.ntrelation.zoneinfo.bean.a aVar = ntZoneDetailInfoList;
                com.tencent.qqnt.ntrelation.zoneinfo.bean.c cVar = this.f360302a.get(aVar.getUid());
                if (cVar != null) {
                    this.f360303b.simpleInfo2DetailInfo(cVar, aVar);
                }
            }
            this.f360303b.getAbsServiceImpl().updateZoneDetailInfo(arrayList, this.f360304c, this.f360305d);
            this.f360303b.getReverseServiceImpl().updateZoneDetailInfo(arrayList, this.f360304c, (hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a>) null);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37830);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ZoneInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.absApiImpl = new NTZoneInfoApiImpl();
            this.isNew = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQQZoneInfoApi getAbsServiceImpl() {
        IQQZoneInfoApi iQQZoneInfoApi;
        IQQZoneInfoApi iQQZoneInfoApi2 = this.absApiImpl;
        if (iQQZoneInfoApi2 != null) {
            boolean z16 = this.isNew;
            if (z16 && (iQQZoneInfoApi2 instanceof NTZoneInfoApiImpl)) {
                return iQQZoneInfoApi2;
            }
            if (!z16 && !(iQQZoneInfoApi2 instanceof NTZoneInfoApiImpl)) {
                return iQQZoneInfoApi2;
            }
        }
        if (this.isNew) {
            iQQZoneInfoApi = new NTZoneInfoApiImpl();
        } else {
            iQQZoneInfoApi = (IQQZoneInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQZoneInfoApi.class);
        }
        this.absApiImpl = iQQZoneInfoApi;
        QLog.i(TAG, 1, "getZoneSimpleInfo abServiceImpl is " + iQQZoneInfoApi.getClass().getName());
        return this.absApiImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQQZoneInfoApi getReverseServiceImpl() {
        if (!this.isNew) {
            return new NTZoneInfoApiImpl();
        }
        return (IQQZoneInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQZoneInfoApi.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void simpleInfo2DetailInfo(com.tencent.qqnt.ntrelation.zoneinfo.bean.c ntZoneSimpleInfo, com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo) {
        ntZoneDetailInfo.r(ntZoneSimpleInfo.j());
        ntZoneDetailInfo.k(ntZoneSimpleInfo.b());
        ntZoneDetailInfo.q(ntZoneSimpleInfo.f());
        ntZoneDetailInfo.l(ntZoneSimpleInfo.c());
        ntZoneDetailInfo.p(ntZoneSimpleInfo.e());
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void deleteZoneDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        getAbsServiceImpl().deleteZoneDetailInfo(uid, trace, iDeleteGeneralDataCallback);
        getReverseServiceImpl().deleteZoneDetailInfo(uid, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void getZoneDetailInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getZoneDetailInfoWithUid(uid, false, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> getZoneSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return getAbsServiceImpl().getZoneSimpleInfoWithUid(uids, trace);
    }

    public final boolean isNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isNew;
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void updateZoneDetailInfo(@NotNull com.tencent.qqnt.ntrelation.zoneinfo.bean.a ntZoneDetailInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, ntZoneDetailInfo, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneDetailInfo, "ntZoneDetailInfo");
        ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> arrayList = new ArrayList<>();
        arrayList.add(ntZoneDetailInfo);
        updateZoneDetailInfo(arrayList, trace, iUpdateGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void updateZoneSimpleInfo(@NotNull com.tencent.qqnt.ntrelation.zoneinfo.bean.c ntZoneSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, ntZoneSimpleInfo, trace, iUpdateGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(ntZoneSimpleInfo, "ntZoneSimpleInfo");
            updateZoneSimpleInfo(new ArrayList<>(), trace, iUpdateGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void getZoneDetailInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.zoneinfo.manager.a.f360320a.a(uid, trace, iQueryGeneralDataCallback);
        }
        getAbsServiceImpl().getZoneDetailWithUid(uid, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    @Nullable
    public com.tencent.qqnt.ntrelation.zoneinfo.bean.c getZoneSimpleInfoWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.ntrelation.zoneinfo.bean.c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> zoneSimpleInfoWithUid = getZoneSimpleInfoWithUid(arrayList, trace);
        if (zoneSimpleInfoWithUid == null || zoneSimpleInfoWithUid.size() == 0) {
            return null;
        }
        return zoneSimpleInfoWithUid.get(0);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void updateZoneSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> ntZoneSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, ntZoneSimpleInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneSimpleInfoList, "ntZoneSimpleInfoList");
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> it = ntZoneSimpleInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.zoneinfo.bean.c next = it.next();
            if (next != null) {
                arrayList.add(next.getUid());
                hashMap.put(next.getUid(), next);
            }
        }
        getZoneDetailInfoWithUid(arrayList, TAG, new b(hashMap, this, trace, iUpdateGeneralDataCallback));
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void getZoneDetailInfoWithUid(@NotNull ArrayList<String> uidList, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uidList, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().getZoneDetailWithUid(uidList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void updateZoneDetailInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> ntZoneDetailInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, ntZoneDetailInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntZoneDetailInfoList, "ntZoneDetailInfoList");
        getAbsServiceImpl().updateZoneDetailInfo(ntZoneDetailInfoList, trace, iUpdateGeneralDataCallback);
        getReverseServiceImpl().updateZoneDetailInfo(ntZoneDetailInfoList, trace, (hx3.c<com.tencent.qqnt.ntrelation.zoneinfo.bean.a>) null);
    }

    @Override // com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService
    public void getZoneSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.zoneinfo.manager.a.f360320a.b(uid, trace, iQueryGeneralDataCallback);
        }
        com.tencent.qqnt.ntrelation.zoneinfo.bean.c zoneSimpleInfoWithUid = getZoneSimpleInfoWithUid(uid, trace);
        ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> arrayList = new ArrayList<>();
        if (zoneSimpleInfoWithUid != null) {
            arrayList.add(zoneSimpleInfoWithUid);
        }
        e<com.tencent.qqnt.ntrelation.zoneinfo.bean.c> eVar = new e<>();
        eVar.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }
}
