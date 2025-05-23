package com.tencent.mobileqq.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.fragment.BaseLoginFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.aj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$MaskPhoneData;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0004\u001a\u001e\"%B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u001e\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\"\u0010\u0017\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/util/aj;", "", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/k;", "callback", "", "forceReq", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "l", tl.h.F, "o", "Lcom/tencent/mobileqq/util/aj$c;", "", "waitingTime", "p", "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "fragment", "Landroid/os/Bundle;", "params", ReportConstant.COSTREPORT_PREFIX, "t", "maxWaitingTime", DomainData.DOMAIN_NAME, "a", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "mMaskPhoneData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRequesting", "Lcom/tencent/mobileqq/util/aj$b;", "c", "Lcom/tencent/mobileqq/util/aj$b;", "requestingMaskCallback", "d", "J", "startRequestTime", "<init>", "()V", "e", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class aj {

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final aj f306554f = d.f306563a.a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GetLocalPhone$MaskPhoneData mMaskPhoneData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRequesting;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b requestingMaskCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long startRequestTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/util/aj$b;", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/k;", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "maskPhoneData", "", "d", "callback", "", "c", "b", "", "code", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "a", "Lcom/tencent/mobileqq/util/aj;", "Lcom/tencent/mobileqq/util/aj;", "getMaskPhoneHelper", "()Lcom/tencent/mobileqq/util/aj;", "maskPhoneHelper", "", "Ljava/util/List;", "callbackList", "", "J", "startTime", "", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "(Lcom/tencent/mobileqq/util/aj;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.mobileqq.gateway.localphone.ecdh.k {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final aj maskPhoneHelper;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.mobileqq.gateway.localphone.ecdh.k> callbackList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long startTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object lock;

        public b(@NotNull aj maskPhoneHelper) {
            Intrinsics.checkNotNullParameter(maskPhoneHelper, "maskPhoneHelper");
            this.maskPhoneHelper = maskPhoneHelper;
            this.callbackList = new ArrayList();
            this.startTime = System.currentTimeMillis();
            this.lock = new Object();
        }

        private final boolean d(GetLocalPhone$MaskPhoneData maskPhoneData) {
            if (maskPhoneData == null) {
                QLog.e("GatewayMaskPhoneHelper", 1, "mashPhoneData is null");
                return false;
            }
            if (TextUtils.isEmpty(maskPhoneData.str_mask_phone.get())) {
                QLog.e("GatewayMaskPhoneHelper", 1, "maskPhoneData str_mask_phone is empty");
                return false;
            }
            if (!TextUtils.isEmpty(maskPhoneData.str_terms_wording.get())) {
                return true;
            }
            QLog.e("GatewayMaskPhoneHelper", 1, "maskPhoneData str_terms_wording is empty");
            return false;
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.k
        public void a(int code, @NotNull Exception e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            QLog.e("GatewayMaskPhoneHelper", 1, "getMaskPhoneNum error: " + code + ",cost(" + (System.currentTimeMillis() - this.startTime) + "), exception : ", e16);
            synchronized (this.lock) {
                Iterator<com.tencent.mobileqq.gateway.localphone.ecdh.k> it = this.callbackList.iterator();
                while (it.hasNext()) {
                    it.next().a(code, e16);
                }
                this.callbackList.clear();
                Unit unit = Unit.INSTANCE;
            }
            this.maskPhoneHelper.isRequesting.compareAndSet(true, false);
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.k
        public void b(@NotNull GetLocalPhone$MaskPhoneData maskPhoneData) {
            Intrinsics.checkNotNullParameter(maskPhoneData, "maskPhoneData");
            if (d(maskPhoneData)) {
                QLog.i("GatewayMaskPhoneHelper", 1, "getMaskPhoneSuccess: " + maskPhoneData.str_mask_phone.get() + ", cost(" + (System.currentTimeMillis() - this.startTime) + ")");
                this.maskPhoneHelper.mMaskPhoneData = maskPhoneData;
                synchronized (this.lock) {
                    Iterator<com.tencent.mobileqq.gateway.localphone.ecdh.k> it = this.callbackList.iterator();
                    while (it.hasNext()) {
                        it.next().b(maskPhoneData);
                    }
                    this.callbackList.clear();
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                QLog.e("GatewayMaskPhoneHelper", 1, "getMaskPhoneSuccess but maskPhoneData not valid");
            }
            this.maskPhoneHelper.isRequesting.compareAndSet(true, false);
        }

        public final void c(@NotNull com.tencent.mobileqq.gateway.localphone.ecdh.k callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            synchronized (this.lock) {
                this.callbackList.add(callback);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/util/aj$c;", "", "", UIJsPlugin.EVENT_SHOW_LOADING, "a", UIJsPlugin.EVENT_HIDE_LOADING, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface c {
        void a();

        void hideLoading();

        void showLoading();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/util/aj$d;", "", "Lcom/tencent/mobileqq/util/aj;", "b", "Lcom/tencent/mobileqq/util/aj;", "a", "()Lcom/tencent/mobileqq/util/aj;", "holder", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f306563a = new d();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final aj holder = new aj(null);

        d() {
        }

        @NotNull
        public final aj a() {
            return holder;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/util/aj$e", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements ne1.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.gateway.localphone.ecdh.k f306566b;

        e(com.tencent.mobileqq.gateway.localphone.ecdh.k kVar) {
            this.f306566b = kVar;
        }

        @Override // ne1.a
        public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("GatewayMaskPhoneHelper", 2, "getMaskPhoneNum onSuccess $");
            aj.this.mMaskPhoneData = data.msg_mask_phone_data.get();
            if (aj.this.mMaskPhoneData != null) {
                com.tencent.mobileqq.gateway.localphone.ecdh.k kVar = this.f306566b;
                aj ajVar = aj.this;
                if (kVar != null) {
                    GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = ajVar.mMaskPhoneData;
                    Intrinsics.checkNotNull(getLocalPhone$MaskPhoneData);
                    kVar.b(getLocalPhone$MaskPhoneData);
                }
            }
        }

        @Override // ne1.a
        public void onFail(int errorCode, @Nullable String errorMsg) {
            QLog.e("GatewayMaskPhoneHelper", 1, "getMaskPhoneNum onFail errorCode: " + errorCode + " errorMsg: " + errorMsg);
            com.tencent.mobileqq.gateway.localphone.ecdh.k kVar = this.f306566b;
            if (kVar != null) {
                kVar.a(errorCode, new Exception(errorMsg));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/util/aj$f", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/k;", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "maskPhoneData", "", "b", "", "code", "Ljava/lang/Exception;", "e", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements com.tencent.mobileqq.gateway.localphone.ecdh.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f306567a;

        f(Runnable runnable) {
            this.f306567a = runnable;
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.k
        public void a(int code, @NotNull Exception e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            ThreadManagerV2.getUIHandlerV2().post(this.f306567a);
        }

        @Override // com.tencent.mobileqq.gateway.localphone.ecdh.k
        public void b(@NotNull GetLocalPhone$MaskPhoneData maskPhoneData) {
            Intrinsics.checkNotNullParameter(maskPhoneData, "maskPhoneData");
            ThreadManagerV2.getUIHandlerV2().post(this.f306567a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/util/aj$g", "Lcom/tencent/mobileqq/util/aj$c;", "", UIJsPlugin.EVENT_SHOW_LOADING, "a", UIJsPlugin.EVENT_HIDE_LOADING, "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class g implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<BaseLoginFragment> f306568a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f306569b;

        g(WeakReference<BaseLoginFragment> weakReference, Bundle bundle) {
            this.f306568a = weakReference;
            this.f306569b = bundle;
        }

        @Override // com.tencent.mobileqq.util.aj.c
        public void a() {
            BaseLoginFragment baseLoginFragment = this.f306568a.get();
            if (baseLoginFragment != null) {
                BaseLoginFragment.Ih(baseLoginFragment, 3, this.f306569b, false, 4, null);
            }
        }

        @Override // com.tencent.mobileqq.util.aj.c
        public void hideLoading() {
            BaseLoginFragment baseLoginFragment = this.f306568a.get();
            if (baseLoginFragment != null) {
                baseLoginFragment.hideLoading();
            }
        }

        @Override // com.tencent.mobileqq.util.aj.c
        public void showLoading() {
            BaseLoginFragment baseLoginFragment = this.f306568a.get();
            if (baseLoginFragment != null) {
                baseLoginFragment.Oh(R.string.f211365km);
            }
        }
    }

    public /* synthetic */ aj(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void i(final com.tencent.mobileqq.gateway.localphone.ecdh.k callback, boolean forceReq) {
        GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = this.mMaskPhoneData;
        if (getLocalPhone$MaskPhoneData != null && !forceReq) {
            if (callback != null) {
                Intrinsics.checkNotNull(getLocalPhone$MaskPhoneData);
                callback.b(getLocalPhone$MaskPhoneData);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.ai
            @Override // java.lang.Runnable
            public final void run() {
                aj.k(aj.this, callback);
            }
        }, 128, null, false);
    }

    static /* synthetic */ void j(aj ajVar, com.tencent.mobileqq.gateway.localphone.ecdh.k kVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            kVar = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        ajVar.i(kVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(aj this$0, com.tencent.mobileqq.gateway.localphone.ecdh.k kVar) {
        b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isRequesting.compareAndSet(false, true)) {
            QLog.i("GatewayMaskPhoneHelper", 1, "doRequestMaskPhoneData start");
            b bVar2 = new b(this$0);
            if (kVar != null) {
                bVar2.c(kVar);
            }
            this$0.requestingMaskCallback = bVar2;
            this$0.m(bVar2);
            this$0.startRequestTime = System.currentTimeMillis();
            return;
        }
        if (kVar != null && (bVar = this$0.requestingMaskCallback) != null) {
            bVar.c(kVar);
        }
    }

    private final void m(com.tencent.mobileqq.gateway.localphone.ecdh.k callback) {
        QLog.i("GatewayMaskPhoneHelper", 1, "start getMaskPhoneNum");
        com.tencent.mobileqq.gateway.localphone.ecdh.g.n(1, 14, new e(callback), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(c callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.e("GatewayMaskPhoneHelper", 1, "requestMaskPhoneAndDoJob doAction");
        callback.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AtomicBoolean isJobDone, c callback) {
        Intrinsics.checkNotNullParameter(isJobDone, "$isJobDone");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (isJobDone.compareAndSet(false, true)) {
            QLog.i("GatewayMaskPhoneHelper", 1, "requestMaskPhoneAndDoJob finish job");
            callback.hideLoading();
            callback.a();
        }
    }

    public final boolean g() {
        if (this.mMaskPhoneData != null) {
            return true;
        }
        return false;
    }

    public final void h() {
        this.mMaskPhoneData = null;
        this.isRequesting.set(false);
        this.startRequestTime = 0L;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final GetLocalPhone$MaskPhoneData getMMaskPhoneData() {
        return this.mMaskPhoneData;
    }

    public final long n(long maxWaitingTime) {
        if (maxWaitingTime <= 0) {
            return 0L;
        }
        if (this.startRequestTime <= 0) {
            return maxWaitingTime;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.startRequestTime;
        if (currentTimeMillis <= 0 || currentTimeMillis >= maxWaitingTime) {
            return 0L;
        }
        return maxWaitingTime - currentTimeMillis;
    }

    public final void o() {
        j(this, null, true, 1, null);
    }

    public final void p(@NotNull final c callback, long waitingTime) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("GatewayMaskPhoneHelper", 1, "requestMaskPhoneAndDoJob waitingTime: " + waitingTime);
        if (!g() && waitingTime > 0) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.util.ah
                @Override // java.lang.Runnable
                public final void run() {
                    aj.r(atomicBoolean, callback);
                }
            };
            callback.showLoading();
            j(this, new f(runnable), false, 2, null);
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, waitingTime);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.ag
            @Override // java.lang.Runnable
            public final void run() {
                aj.q(aj.c.this);
            }
        });
    }

    public final void s(@Nullable BaseLoginFragment fragment, @Nullable Bundle params) {
        t(fragment, params, 8000L);
    }

    public final void t(@Nullable BaseLoginFragment fragment, @Nullable Bundle params, long waitingTime) {
        if (fragment == null) {
            QLog.e("GatewayMaskPhoneHelper", 1, "jumpGatewayLogin fragment is null");
        } else if (fragment.Fh()) {
            BaseLoginFragment.Ih(fragment, 4, params, false, 4, null);
        } else {
            p(new g(new WeakReference(fragment), params), waitingTime);
        }
    }

    aj() {
        this.isRequesting = new AtomicBoolean(false);
    }
}
