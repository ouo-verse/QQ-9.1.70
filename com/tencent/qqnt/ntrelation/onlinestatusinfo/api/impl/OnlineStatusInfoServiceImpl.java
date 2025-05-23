package com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J>\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0016J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J0\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J8\u0010\u0019\u001a\u00020\u00062\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J*\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J*\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J:\u0010\u001e\u001a\u00020\u00062\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J*\u0010\"\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010 H\u0016R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0017\u0010%\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/OnlineStatusInfoServiceImpl;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/IOnlineStatusInfoService;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "ntOnlineStatusDetailInfo", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "ntOnlineStatusSimpleInfo", "", "simpleInfo2DetailInfo", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/IQQOnlineStatusInfoApi;", "getAbsServiceImpl", "getReverseServiceImpl", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "getOnlineStatusSimpleInfoWithUid", "uid", "", "isObserver", "Lhx3/b;", "iQueryGeneralDataCallback", "callback", "addOnlineStatusSimpleInfoCallback", "removeOnlineStatusSimpleInfoCallback", "getOnlineStatusInfoWithUid", "getControlGroupOnlineStatusInfoWithUid", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateOnlineStatusDetailInfo", "updateOnlineStatusSimpleInfo", "ntOnlineStatusSimpleInfoList", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteOnlineStatusDetailInfo", "absApiImpl", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/IQQOnlineStatusInfoApi;", "isNew", "Z", "()Z", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OnlineStatusInfoServiceImpl implements IOnlineStatusInfoService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "OnlineStatusInfoServiceImpl";

    @NotNull
    private IQQOnlineStatusInfoApi absApiImpl;
    private final boolean isNew;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/OnlineStatusInfoServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl.OnlineStatusInfoServiceImpl$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/OnlineStatusInfoServiceImpl$b", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> f360110a;

        b(hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> cVar) {
            this.f360110a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> cVar = this.f360110a;
            if (cVar != null) {
                cVar.onUpdateResult(responseData);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/OnlineStatusInfoServiceImpl$c", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap<String, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> f360111a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnlineStatusInfoServiceImpl f360112b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> f360113c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/OnlineStatusInfoServiceImpl$c$a", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes22.dex */
        public static final class a implements hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> f360114a;

            a(hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> cVar) {
                this.f360114a = cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
                }
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> responseData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                    return;
                }
                hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> cVar = this.f360114a;
                if (cVar != null) {
                    cVar.onUpdateResult(responseData);
                }
            }
        }

        c(HashMap<String, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> hashMap, OnlineStatusInfoServiceImpl onlineStatusInfoServiceImpl, hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> cVar) {
            this.f360111a = hashMap;
            this.f360112b = onlineStatusInfoServiceImpl;
            this.f360113c = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, hashMap, onlineStatusInfoServiceImpl, cVar);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> responseData) {
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            boolean z16 = false;
            if (responseData != null && responseData.a() == 0) {
                z16 = true;
            }
            if (z16 && (b16 = responseData.b()) != null && b16.size() != 0) {
                Iterator<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> it = b16.iterator();
                while (it.hasNext()) {
                    com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a ntOnlineStatusDetailInfo = it.next();
                    com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = this.f360111a.get(ntOnlineStatusDetailInfo.getUid());
                    if (cVar != null) {
                        OnlineStatusInfoServiceImpl onlineStatusInfoServiceImpl = this.f360112b;
                        Intrinsics.checkNotNullExpressionValue(ntOnlineStatusDetailInfo, "ntOnlineStatusDetailInfo");
                        onlineStatusInfoServiceImpl.simpleInfo2DetailInfo(ntOnlineStatusDetailInfo, cVar);
                    }
                }
                this.f360112b.getAbsServiceImpl().updateOnlineStatusInfo(b16, OnlineStatusInfoServiceImpl.TAG, new a(this.f360113c));
                this.f360112b.getReverseServiceImpl().updateOnlineStatusInfo(b16, OnlineStatusInfoServiceImpl.TAG, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37361);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public OnlineStatusInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.absApiImpl = new NTOnlineStatusInfoApiImpl();
            this.isNew = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isOnlineStatusNTDataService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQQOnlineStatusInfoApi getAbsServiceImpl() {
        IQQOnlineStatusInfoApi iQQOnlineStatusInfoApi;
        IQQOnlineStatusInfoApi iQQOnlineStatusInfoApi2 = this.absApiImpl;
        if (iQQOnlineStatusInfoApi2 != null) {
            boolean z16 = this.isNew;
            if (z16 && (iQQOnlineStatusInfoApi2 instanceof NTOnlineStatusInfoApiImpl)) {
                return iQQOnlineStatusInfoApi2;
            }
            if (!z16 && !(iQQOnlineStatusInfoApi2 instanceof NTOnlineStatusInfoApiImpl)) {
                return iQQOnlineStatusInfoApi2;
            }
        }
        if (this.isNew) {
            iQQOnlineStatusInfoApi = new NTOnlineStatusInfoApiImpl();
        } else {
            iQQOnlineStatusInfoApi = (IQQOnlineStatusInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQOnlineStatusInfoApi.class);
        }
        this.absApiImpl = iQQOnlineStatusInfoApi;
        return iQQOnlineStatusInfoApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IQQOnlineStatusInfoApi getReverseServiceImpl() {
        if (!this.isNew) {
            return new NTOnlineStatusInfoApiImpl();
        }
        return (IQQOnlineStatusInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQOnlineStatusInfoApi.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void simpleInfo2DetailInfo(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a ntOnlineStatusDetailInfo, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c ntOnlineStatusSimpleInfo) {
        int i3;
        int i16;
        long j3;
        byte b16;
        int i17;
        int i18;
        String str;
        String str2;
        String str3;
        long j16;
        int i19;
        int i26;
        int i27;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        long j17;
        String str9;
        String str10;
        int i28;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        int i29;
        long j18;
        String str22;
        String str23;
        String str24;
        String str25;
        long j19;
        long j26;
        String str26;
        int i36 = 0;
        if (ntOnlineStatusSimpleInfo != null) {
            i3 = ntOnlineStatusSimpleInfo.y();
        } else {
            i3 = 0;
        }
        ntOnlineStatusDetailInfo.K0(i3);
        if (ntOnlineStatusSimpleInfo != null) {
            i16 = ntOnlineStatusSimpleInfo.C();
        } else {
            i16 = 0;
        }
        ntOnlineStatusDetailInfo.O0(i16);
        long j27 = 0;
        if (ntOnlineStatusSimpleInfo != null) {
            j3 = ntOnlineStatusSimpleInfo.e0();
        } else {
            j3 = 0;
        }
        ntOnlineStatusDetailInfo.a1(j3);
        if (ntOnlineStatusSimpleInfo != null) {
            b16 = ntOnlineStatusSimpleInfo.u();
        } else {
            b16 = 0;
        }
        ntOnlineStatusDetailInfo.G0(b16);
        if (ntOnlineStatusSimpleInfo != null) {
            i17 = ntOnlineStatusSimpleInfo.z();
        } else {
            i17 = 0;
        }
        ntOnlineStatusDetailInfo.L0(i17);
        if (ntOnlineStatusSimpleInfo != null) {
            i18 = ntOnlineStatusSimpleInfo.E();
        } else {
            i18 = 0;
        }
        ntOnlineStatusDetailInfo.P0(i18);
        String str27 = null;
        if (ntOnlineStatusSimpleInfo != null) {
            str = ntOnlineStatusSimpleInfo.V();
        } else {
            str = null;
        }
        ntOnlineStatusDetailInfo.U0(str);
        if (ntOnlineStatusSimpleInfo != null) {
            str2 = ntOnlineStatusSimpleInfo.Z();
        } else {
            str2 = null;
        }
        ntOnlineStatusDetailInfo.V0(str2);
        if (ntOnlineStatusSimpleInfo != null) {
            str3 = ntOnlineStatusSimpleInfo.G();
        } else {
            str3 = null;
        }
        ntOnlineStatusDetailInfo.R0(str3);
        if (ntOnlineStatusSimpleInfo != null) {
            j16 = ntOnlineStatusSimpleInfo.N();
        } else {
            j16 = 0;
        }
        ntOnlineStatusDetailInfo.T0(j16);
        if (ntOnlineStatusSimpleInfo != null) {
            i19 = ntOnlineStatusSimpleInfo.b0();
        } else {
            i19 = 0;
        }
        ntOnlineStatusDetailInfo.X0(i19);
        if (ntOnlineStatusSimpleInfo != null) {
            i26 = ntOnlineStatusSimpleInfo.a0();
        } else {
            i26 = 0;
        }
        ntOnlineStatusDetailInfo.W0(i26);
        if (ntOnlineStatusSimpleInfo != null) {
            i27 = ntOnlineStatusSimpleInfo.M();
        } else {
            i27 = 0;
        }
        ntOnlineStatusDetailInfo.S0(i27);
        if (ntOnlineStatusSimpleInfo != null) {
            str4 = ntOnlineStatusSimpleInfo.d0();
        } else {
            str4 = null;
        }
        ntOnlineStatusDetailInfo.Z0(str4);
        if (ntOnlineStatusSimpleInfo != null) {
            str5 = ntOnlineStatusSimpleInfo.o0();
        } else {
            str5 = null;
        }
        ntOnlineStatusDetailInfo.l1(str5);
        if (ntOnlineStatusSimpleInfo != null) {
            str6 = ntOnlineStatusSimpleInfo.p0();
        } else {
            str6 = null;
        }
        ntOnlineStatusDetailInfo.m1(str6);
        if (ntOnlineStatusSimpleInfo != null) {
            str7 = ntOnlineStatusSimpleInfo.n0();
        } else {
            str7 = null;
        }
        ntOnlineStatusDetailInfo.k1(str7);
        if (ntOnlineStatusSimpleInfo != null) {
            str8 = ntOnlineStatusSimpleInfo.c();
        } else {
            str8 = null;
        }
        ntOnlineStatusDetailInfo.s0(str8);
        if (ntOnlineStatusSimpleInfo != null) {
            j17 = ntOnlineStatusSimpleInfo.q0();
        } else {
            j17 = 0;
        }
        ntOnlineStatusDetailInfo.n1(j17);
        if (ntOnlineStatusSimpleInfo != null) {
            str9 = ntOnlineStatusSimpleInfo.f();
        } else {
            str9 = null;
        }
        ntOnlineStatusDetailInfo.u0(str9);
        if (ntOnlineStatusSimpleInfo != null) {
            str10 = ntOnlineStatusSimpleInfo.j0();
        } else {
            str10 = null;
        }
        ntOnlineStatusDetailInfo.g1(str10);
        if (ntOnlineStatusSimpleInfo != null) {
            i28 = ntOnlineStatusSimpleInfo.k0();
        } else {
            i28 = 0;
        }
        ntOnlineStatusDetailInfo.h1(i28);
        if (ntOnlineStatusSimpleInfo != null) {
            str11 = ntOnlineStatusSimpleInfo.e();
        } else {
            str11 = null;
        }
        ntOnlineStatusDetailInfo.t0(str11);
        if (ntOnlineStatusSimpleInfo != null) {
            str12 = ntOnlineStatusSimpleInfo.l0();
        } else {
            str12 = null;
        }
        ntOnlineStatusDetailInfo.i1(str12);
        if (ntOnlineStatusSimpleInfo != null) {
            str13 = ntOnlineStatusSimpleInfo.m0();
        } else {
            str13 = null;
        }
        ntOnlineStatusDetailInfo.j1(str13);
        if (ntOnlineStatusSimpleInfo != null) {
            str14 = ntOnlineStatusSimpleInfo.p();
        } else {
            str14 = null;
        }
        ntOnlineStatusDetailInfo.B0(str14);
        if (ntOnlineStatusSimpleInfo != null) {
            str15 = ntOnlineStatusSimpleInfo.q();
        } else {
            str15 = null;
        }
        ntOnlineStatusDetailInfo.C0(str15);
        if (ntOnlineStatusSimpleInfo != null) {
            str16 = ntOnlineStatusSimpleInfo.j();
        } else {
            str16 = null;
        }
        ntOnlineStatusDetailInfo.v0(str16);
        if (ntOnlineStatusSimpleInfo != null) {
            str17 = ntOnlineStatusSimpleInfo.l();
        } else {
            str17 = null;
        }
        ntOnlineStatusDetailInfo.x0(str17);
        if (ntOnlineStatusSimpleInfo != null) {
            str18 = ntOnlineStatusSimpleInfo.m();
        } else {
            str18 = null;
        }
        ntOnlineStatusDetailInfo.y0(str18);
        if (ntOnlineStatusSimpleInfo != null) {
            str19 = ntOnlineStatusSimpleInfo.k();
        } else {
            str19 = null;
        }
        ntOnlineStatusDetailInfo.w0(str19);
        if (ntOnlineStatusSimpleInfo != null) {
            str20 = ntOnlineStatusSimpleInfo.n();
        } else {
            str20 = null;
        }
        ntOnlineStatusDetailInfo.z0(str20);
        if (ntOnlineStatusSimpleInfo != null) {
            str21 = ntOnlineStatusSimpleInfo.o();
        } else {
            str21 = null;
        }
        ntOnlineStatusDetailInfo.A0(str21);
        if (ntOnlineStatusSimpleInfo != null) {
            i29 = ntOnlineStatusSimpleInfo.x();
        } else {
            i29 = 0;
        }
        ntOnlineStatusDetailInfo.J0(i29);
        if (ntOnlineStatusSimpleInfo != null) {
            j18 = ntOnlineStatusSimpleInfo.w();
        } else {
            j18 = 0;
        }
        ntOnlineStatusDetailInfo.I0(j18);
        if (ntOnlineStatusSimpleInfo != null) {
            str22 = ntOnlineStatusSimpleInfo.v();
        } else {
            str22 = null;
        }
        ntOnlineStatusDetailInfo.H0(str22);
        if (ntOnlineStatusSimpleInfo != null) {
            str23 = ntOnlineStatusSimpleInfo.g0();
        } else {
            str23 = null;
        }
        ntOnlineStatusDetailInfo.d1(str23);
        if (ntOnlineStatusSimpleInfo != null) {
            str24 = ntOnlineStatusSimpleInfo.h0();
        } else {
            str24 = null;
        }
        ntOnlineStatusDetailInfo.e1(str24);
        if (ntOnlineStatusSimpleInfo != null) {
            str25 = ntOnlineStatusSimpleInfo.i0();
        } else {
            str25 = null;
        }
        ntOnlineStatusDetailInfo.f1(str25);
        if (ntOnlineStatusSimpleInfo != null) {
            j19 = ntOnlineStatusSimpleInfo.r();
        } else {
            j19 = 0;
        }
        ntOnlineStatusDetailInfo.D0(j19);
        if (ntOnlineStatusSimpleInfo != null) {
            j26 = ntOnlineStatusSimpleInfo.B();
        } else {
            j26 = 0;
        }
        ntOnlineStatusDetailInfo.N0(j26);
        if (ntOnlineStatusSimpleInfo != null) {
            j27 = ntOnlineStatusSimpleInfo.A();
        }
        ntOnlineStatusDetailInfo.M0(j27);
        if (ntOnlineStatusSimpleInfo != null) {
            str26 = ntOnlineStatusSimpleInfo.c0();
        } else {
            str26 = null;
        }
        ntOnlineStatusDetailInfo.Y0(str26);
        if (ntOnlineStatusSimpleInfo != null) {
            str27 = ntOnlineStatusSimpleInfo.s();
        }
        ntOnlineStatusDetailInfo.E0(str27);
        if (ntOnlineStatusSimpleInfo != null) {
            i36 = ntOnlineStatusSimpleInfo.t();
        }
        ntOnlineStatusDetailInfo.F0(i36);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void addOnlineStatusSimpleInfoCallback(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uid, trace, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.manager.a.f360174a.b(uid, trace, callback);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void deleteOnlineStatusDetailInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        getAbsServiceImpl().deleteOnlineStatusInfo(uid, trace, iDeleteGeneralDataCallback);
        getReverseServiceImpl().deleteOnlineStatusInfo(uid, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void getControlGroupOnlineStatusInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        getReverseServiceImpl().getOnlineStatusInfoWithUid(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void getOnlineStatusInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        getAbsServiceImpl().getOnlineStatusInfoWithUid(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> getOnlineStatusSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return getAbsServiceImpl().getOnlineStatusSimpleInfoWithUid(uids, trace);
    }

    public final boolean isNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isNew;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void removeOnlineStatusSimpleInfoCallback(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, uid, trace, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.manager.a.f360174a.d(uid, trace, callback);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void updateOnlineStatusDetailInfo(@NotNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a ntOnlineStatusDetailInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, ntOnlineStatusDetailInfo, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOnlineStatusDetailInfo, "ntOnlineStatusDetailInfo");
        ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> arrayList = new ArrayList<>();
        arrayList.add(ntOnlineStatusDetailInfo);
        getAbsServiceImpl().updateOnlineStatusInfo(arrayList, TAG, new b(iUpdateGeneralDataCallback));
        getReverseServiceImpl().updateOnlineStatusInfo(arrayList, TAG, null);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void updateOnlineStatusSimpleInfo(@NotNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c ntOnlineStatusSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, ntOnlineStatusSimpleInfo, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOnlineStatusSimpleInfo, "ntOnlineStatusSimpleInfo");
        ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> arrayList = new ArrayList<>();
        arrayList.add(ntOnlineStatusSimpleInfo);
        updateOnlineStatusSimpleInfo(arrayList, trace, iUpdateGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    @Nullable
    public com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c getOnlineStatusSimpleInfoWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> onlineStatusSimpleInfoWithUid = getOnlineStatusSimpleInfoWithUid(arrayList, trace);
        if (onlineStatusSimpleInfoWithUid == null || onlineStatusSimpleInfoWithUid.size() == 0) {
            return null;
        }
        return onlineStatusSimpleInfoWithUid.get(0);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void getOnlineStatusInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.manager.a.f360174a.a(uid, trace, iQueryGeneralDataCallback);
        }
        getOnlineStatusInfoWithUid(uid, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void updateOnlineStatusSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> ntOnlineStatusSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, ntOnlineStatusSimpleInfoList, trace, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOnlineStatusSimpleInfoList, "ntOnlineStatusSimpleInfoList");
        HashMap hashMap = new HashMap();
        Iterator<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> it = ntOnlineStatusSimpleInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c next = it.next();
            if (next != null) {
                hashMap.put(next.getUid(), next);
            }
        }
        getOnlineStatusInfoWithUid(new ArrayList<>(hashMap.keySet()), trace, new c(hashMap, this, iUpdateGeneralDataCallback));
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void getOnlineStatusInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, uids, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().getOnlineStatusInfoWithUid(uids, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService
    public void getOnlineStatusSimpleInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.onlinestatusinfo.manager.a.f360174a.b(uid, trace, iQueryGeneralDataCallback);
        }
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = getOnlineStatusSimpleInfoWithUid(uid, trace);
        ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> arrayList = new ArrayList<>();
        if (onlineStatusSimpleInfoWithUid != null) {
            arrayList.add(onlineStatusSimpleInfoWithUid);
        }
        e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> eVar = new e<>();
        eVar.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }
}
