package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.impl.j;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J6\u0010\u0018\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0014R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/j;", "Lcom/tencent/mobileqq/soload/api/impl/d;", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "", "J", "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;", "loadItem", "Lcom/tencent/mobileqq/soload/biz/entity/SoDetailInfo;", "mSoDetailInfo", "I", "", "v", "t", "Lcom/tencent/mobileqq/soload/entity/a;", "soCrashInfo", "y", "rfileFolder", "configSoFilePath", "filePath", "", "succCRC", "", "from", "o", "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;", "getLoadParam", "()Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;", "setLoadParam", "(Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;)V", "loadParam", "r", "Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;", "getLoadItem", "()Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;", "setLoadItem", "(Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;)V", "<init>", "(Lcom/tencent/mobileqq/soload/biz/entity/LoadParam;Lcom/tencent/mobileqq/soload/biz/entity/LoadParam$LoadItem;)V", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadParam loadParam;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadParam.LoadItem loadItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/soload/api/impl/j$a", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements com.tencent.rdelivery.reshub.api.h {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f288600b;

        a(long j3) {
            this.f288600b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, j.this, Long.valueOf(j3));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(j this$0, com.tencent.rdelivery.reshub.api.n error, long j3, com.tencent.rdelivery.reshub.api.g gVar, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(error, "$error");
            if (QLog.isColorLevel()) {
                QLog.i("SoLoadWidget.ShiplyGetSoTaskAsync", 2, "fetchAndHandleConfig onComplete, redId=" + this$0.f288549b.name + " errorCode=" + error.b() + " cost=" + (System.currentTimeMillis() - j3) + " errorMessage=" + error.message() + " thread=" + Thread.currentThread().getId() + " result=" + gVar);
            }
            if (z16 && gVar != null) {
                this$0.J(gVar);
            } else {
                this$0.B(error.b());
            }
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(final boolean isSuccess, @Nullable final com.tencent.rdelivery.reshub.api.g result, @NotNull final com.tencent.rdelivery.reshub.api.n error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), result, error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            final j jVar = j.this;
            final long j3 = this.f288600b;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.soload.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.a.c(j.this, error, j3, result, isSuccess);
                }
            }, 64, null, false);
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                h.a.a(this, f16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/soload/api/impl/j$b", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.rdelivery.reshub.api.h {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f288602b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.soload.entity.a f288603c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LoadParam.LoadItem f288604d;

        b(String str, com.tencent.mobileqq.soload.entity.a aVar, LoadParam.LoadItem loadItem) {
            this.f288602b = str;
            this.f288603c = aVar;
            this.f288604d = loadItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, j.this, str, aVar, loadItem);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(j this$0, com.tencent.rdelivery.reshub.api.n error, boolean z16, com.tencent.rdelivery.reshub.api.g gVar, String str, com.tencent.mobileqq.soload.entity.a soCrashInfo, LoadParam.LoadItem loadItem) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(error, "$error");
            Intrinsics.checkNotNullParameter(soCrashInfo, "$soCrashInfo");
            Intrinsics.checkNotNullParameter(loadItem, "$loadItem");
            if (QLog.isColorLevel()) {
                QLog.i("SoLoadWidget.ShiplyGetSoTaskAsync", 2, "handleConfigWhenHasCrash onComplete, thread=" + Thread.currentThread().getId() + " redId=" + this$0.f288549b + ".name errorCode=" + error.b() + " errorMessage=" + error.message());
            }
            if (z16 && gVar != null) {
                SoDetailInfo b16 = m.f288614a.b(gVar);
                this$0.f288555h = b16;
                if (TextUtils.equals(b16.ver, str) && soCrashInfo.g()) {
                    this$0.f288556i = "runcrash";
                    this$0.B(8);
                    return;
                } else {
                    com.tencent.mobileqq.soload.util.f.d(loadItem.name);
                    SoDetailInfo mSoDetailInfo = this$0.f288555h;
                    Intrinsics.checkNotNullExpressionValue(mSoDetailInfo, "mSoDetailInfo");
                    this$0.I(loadItem, gVar, mSoDetailInfo);
                    return;
                }
            }
            this$0.B(error.b());
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(final boolean isSuccess, @Nullable final com.tencent.rdelivery.reshub.api.g result, @NotNull final com.tencent.rdelivery.reshub.api.n error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), result, error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            final j jVar = j.this;
            final String str = this.f288602b;
            final com.tencent.mobileqq.soload.entity.a aVar = this.f288603c;
            final LoadParam.LoadItem loadItem = this.f288604d;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.soload.api.impl.k
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.c(j.this, error, isSuccess, result, str, aVar, loadItem);
                }
            }, 64, null, false);
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                h.a.a(this, f16);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull LoadParam loadParam, @NotNull LoadParam.LoadItem loadItem) {
        super(loadParam, loadItem);
        Intrinsics.checkNotNullParameter(loadParam, "loadParam");
        Intrinsics.checkNotNullParameter(loadItem, "loadItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) loadParam, (Object) loadItem);
        } else {
            this.loadParam = loadParam;
            this.loadItem = loadItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(LoadParam.LoadItem loadItem, com.tencent.rdelivery.reshub.api.g result, SoDetailInfo mSoDetailInfo) {
        boolean z16;
        SoLocalInfo o16 = com.tencent.mobileqq.soload.util.f.o(loadItem, mSoDetailInfo);
        o16.mSoPath = result.e();
        boolean f16 = com.tencent.mobileqq.soload.api.impl.a.f(o16, mSoDetailInfo);
        if ((this.f288549b.lops.flag & 4) != 0 && this.f288548a.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "[handleRelatedFile]  ,rfolderOk=" + f16 + ",isWeak:" + z17 + ",loadItemName:" + loadItem.name + ",filePath:" + o16.mSoPath);
        }
        w(f16, z17, o16, result.e(), null, o16.mSoCRC, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(com.tencent.rdelivery.reshub.api.g result) {
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "handleSuccess result = " + result);
        }
        SoDetailInfo b16 = m.f288614a.b(result);
        this.f288555h = b16;
        com.tencent.mobileqq.soload.entity.a i3 = com.tencent.mobileqq.soload.util.f.i(this.f288549b.name, b16.ver);
        if (i3 != null && i3.d()) {
            if (QLog.isColorLevel()) {
                QLog.i(v(), 2, "[handleSuccess] InLoadCrashProtectMode, crashInfo=" + i3);
            }
            this.f288556i = "loadcrash";
            B(8);
            return;
        }
        if (i3 != null && i3.h()) {
            y(this.loadItem, i3);
        } else {
            LoadParam.LoadItem loadItem = this.loadItem;
            SoDetailInfo mSoDetailInfo = this.f288555h;
            Intrinsics.checkNotNullExpressionValue(mSoDetailInfo, "mSoDetailInfo");
            I(loadItem, result, mSoDetailInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "handleSuccess mSoPathToLoad = " + this.f288553f + ", mSoDetailInfo = " + this.f288555h);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.d
    protected void o(@Nullable String rfileFolder, @Nullable String configSoFilePath, @Nullable String filePath, long succCRC, int from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, rfileFolder, configSoFilePath, filePath, Long.valueOf(succCRC), Integer.valueOf(from));
            return;
        }
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(MobileQQ.sMobileQQ, configSoFilePath);
        this.f288554g = rfileFolder;
        this.f288553f = configSoFilePath;
        B(0);
    }

    @Override // com.tencent.mobileqq.soload.api.impl.d
    protected void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "fetchAndHandleConfig loadLatest so = " + this.f288549b.name);
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.rdelivery.reshub.api.i resHubInstance = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();
        String str = this.f288549b.name;
        Intrinsics.checkNotNullExpressionValue(str, "mLoadItem.name");
        resHubInstance.p(str, new a(currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.soload.api.impl.d
    @NotNull
    protected String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "SoLoadWidget.ShiplyGetSoTaskAsync";
    }

    @Override // com.tencent.mobileqq.soload.api.impl.d
    protected void y(@NotNull LoadParam.LoadItem loadItem, @NotNull com.tencent.mobileqq.soload.entity.a soCrashInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) loadItem, (Object) soCrashInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(loadItem, "loadItem");
        Intrinsics.checkNotNullParameter(soCrashInfo, "soCrashInfo");
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "[handleConfigWhenHasCrash] isNeedReqForCrash, crashInfo=" + soCrashInfo);
        }
        String str = this.f288555h.ver;
        com.tencent.rdelivery.reshub.api.i resHubInstance = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();
        String str2 = this.f288549b.name;
        Intrinsics.checkNotNullExpressionValue(str2, "mLoadItem.name");
        resHubInstance.j(str2, new b(str, soCrashInfo, loadItem), true);
    }
}
