package com.tencent.mobileqq.springhb.servlet;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.springhb.servlet.b;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import tencent.im.spring_hb.FestivalPack$BusinessJumpInfo;
import tencent.im.spring_hb.FestivalPack$GetWaitTimeReq;
import tencent.im.spring_hb.FestivalPack$GetWaitTimeRsp;
import tencent.im.spring_hb.FestivalPack$NewYearEvePackReq;
import tencent.im.spring_hb.FestivalPack$NewYearEvePackResp;
import tencent.im.spring_hb.FestivalPack$Pack;
import tencent.im.spring_hb.GetStarRedDot$AddUserLuckyBagScoreReq;
import tencent.im.spring_hb.GetStarRedDot$AddUserLuckyBagScoreRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J2\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007J*\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007J2\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/springhb/servlet/c;", "", "", "sceneType", "", "isShua", "Lkotlin/Function2;", "Landroid/os/Bundle;", "", "receiver", "c", "", "addressCode", "e", "promotionId", "maxCombo", "d", "Ltencent/im/spring_hb/FestivalPack$Pack;", "pack", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f289615a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.springhb.servlet.a f289616d;

        public a(com.tencent.mobileqq.springhb.servlet.a aVar) {
            this.f289616d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (bundle == null) {
                z17 = true;
            }
            QLog.i("SpringHb_SpringEvePackServlet", 1, "type " + i3 + ", isSuccess " + z16 + ", bundle null, " + z17);
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) FestivalPack$NewYearEvePackResp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    com.tencent.mobileqq.springhb.servlet.a aVar = this.f289616d;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    aVar.onSuccess(rsp);
                    return;
                } catch (Throwable th5) {
                    com.tencent.mobileqq.springhb.servlet.a aVar2 = this.f289616d;
                    if (bundle == null || (str = bundle.getString("rsp_msg")) == null) {
                        str = "merge from error " + th5.getMessage();
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "bundle?.getString(EXTRA_\u2026 from error ${e.message}\"");
                    aVar2.onFail(str);
                    return;
                }
            }
            com.tencent.mobileqq.springhb.servlet.a aVar3 = this.f289616d;
            if (bundle == null || (str2 = bundle.getString("rsp_msg")) == null) {
                str2 = "empty bundle";
            }
            aVar3.onFail(str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/springhb/servlet/c$b", "Lcom/tencent/mobileqq/springhb/servlet/a;", "Ltencent/im/spring_hb/FestivalPack$NewYearEvePackResp;", "rsp", "", "a", "", "errMsg", "onFail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.springhb.servlet.a<FestivalPack$NewYearEvePackResp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, Bundle, Unit> f289617a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Integer, ? super Bundle, Unit> function2) {
            this.f289617a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.springhb.servlet.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull FestivalPack$NewYearEvePackResp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.d("SpringHb_SpringServletHelper", 1, "requestGift, onSuccess: " + GdtJsonPbUtil.pbToJson(rsp));
            c cVar = c.f289615a;
            FestivalPack$Pack festivalPack$Pack = rsp.pack.get();
            Intrinsics.checkNotNullExpressionValue(festivalPack$Pack, "rsp.pack.get()");
            PackInfo b16 = cVar.b(festivalPack$Pack);
            try {
                com.tencent.mobileqq.qwallet.preload.a.h().getResPath(b16.businessCover, (IPreloadService.c) null);
                com.tencent.mobileqq.qwallet.preload.a.h().getResPath(b16.businessVideoCover, (IPreloadService.c) null);
            } catch (Throwable th5) {
                QLog.e("SpringHb_SpringServletHelper", 1, "onSuccess: preload fail ", th5);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_pack_info", b16);
            this.f289617a.invoke(0, bundle);
        }

        @Override // com.tencent.mobileqq.springhb.servlet.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("SpringHb_SpringServletHelper", 1, "requestGift, onFail: " + errMsg);
            Bundle bundle = new Bundle();
            bundle.putString("extra_err_msg", errMsg);
            this.f289617a.invoke(-1, bundle);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.servlet.c$c, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8609c implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.springhb.servlet.a f289618d;

        public C8609c(com.tencent.mobileqq.springhb.servlet.a aVar) {
            this.f289618d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (bundle == null) {
                z17 = true;
            }
            QLog.i("SpringHb_SpringEvePackServlet", 1, "type " + i3 + ", isSuccess " + z16 + ", bundle null, " + z17);
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) GetStarRedDot$AddUserLuckyBagScoreRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    com.tencent.mobileqq.springhb.servlet.a aVar = this.f289618d;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    aVar.onSuccess(rsp);
                    return;
                } catch (Throwable th5) {
                    com.tencent.mobileqq.springhb.servlet.a aVar2 = this.f289618d;
                    if (bundle == null || (str = bundle.getString("rsp_msg")) == null) {
                        str = "merge from error " + th5.getMessage();
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "bundle?.getString(EXTRA_\u2026 from error ${e.message}\"");
                    aVar2.onFail(str);
                    return;
                }
            }
            com.tencent.mobileqq.springhb.servlet.a aVar3 = this.f289618d;
            if (bundle == null || (str2 = bundle.getString("rsp_msg")) == null) {
                str2 = "empty bundle";
            }
            aVar3.onFail(str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/springhb/servlet/c$d", "Lcom/tencent/mobileqq/springhb/servlet/a;", "Ltencent/im/spring_hb/GetStarRedDot$AddUserLuckyBagScoreRsp;", "rsp", "", "a", "", "errMsg", "onFail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements com.tencent.mobileqq.springhb.servlet.a<GetStarRedDot$AddUserLuckyBagScoreRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, Bundle, Unit> f289619a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super Integer, ? super Bundle, Unit> function2) {
            this.f289619a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.springhb.servlet.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull GetStarRedDot$AddUserLuckyBagScoreRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.d("SpringHb_SpringServletHelper", 1, "requestSysFinish, onSuccess=", GdtJsonPbUtil.pbToJson(rsp));
            this.f289619a.invoke(0, new Bundle());
        }

        @Override // com.tencent.mobileqq.springhb.servlet.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("SpringHb_SpringServletHelper", 1, "requestSysFinish, onFail: " + errMsg);
            Bundle bundle = new Bundle();
            bundle.putString("extra_err_msg", errMsg);
            this.f289619a.invoke(-1, bundle);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.springhb.servlet.a f289620d;

        public e(com.tencent.mobileqq.springhb.servlet.a aVar) {
            this.f289620d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (bundle == null) {
                z17 = true;
            }
            QLog.i("SpringHb_SpringEvePackServlet", 1, "type " + i3 + ", isSuccess " + z16 + ", bundle null, " + z17);
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) FestivalPack$GetWaitTimeRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    com.tencent.mobileqq.springhb.servlet.a aVar = this.f289620d;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    aVar.onSuccess(rsp);
                    return;
                } catch (Throwable th5) {
                    com.tencent.mobileqq.springhb.servlet.a aVar2 = this.f289620d;
                    if (bundle == null || (str = bundle.getString("rsp_msg")) == null) {
                        str = "merge from error " + th5.getMessage();
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "bundle?.getString(EXTRA_\u2026 from error ${e.message}\"");
                    aVar2.onFail(str);
                    return;
                }
            }
            com.tencent.mobileqq.springhb.servlet.a aVar3 = this.f289620d;
            if (bundle == null || (str2 = bundle.getString("rsp_msg")) == null) {
                str2 = "empty bundle";
            }
            aVar3.onFail(str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/springhb/servlet/c$f", "Lcom/tencent/mobileqq/springhb/servlet/a;", "Ltencent/im/spring_hb/FestivalPack$GetWaitTimeRsp;", "rsp", "", "a", "", "errMsg", "onFail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f implements com.tencent.mobileqq.springhb.servlet.a<FestivalPack$GetWaitTimeRsp> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, Bundle, Unit> f289621a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function2<? super Integer, ? super Bundle, Unit> function2) {
            this.f289621a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.springhb.servlet.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull FestivalPack$GetWaitTimeRsp rsp) {
            long[] longArray;
            long[] longArray2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.d("SpringHb_SpringServletHelper", 1, "requestWaitTime, onSuccess: ");
            if (rsp.wait_time.get() == null) {
                onFail("rsp invalid");
                return;
            }
            Bundle bundle = new Bundle();
            List<Long> list = rsp.wait_time.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.wait_time.get()");
            longArray = CollectionsKt___CollectionsKt.toLongArray(list);
            bundle.putLongArray("extra_wait_time_list", longArray);
            List<Long> list2 = rsp.redpacket_wait_time.get();
            Intrinsics.checkNotNullExpressionValue(list2, "rsp.redpacket_wait_time.get()");
            longArray2 = CollectionsKt___CollectionsKt.toLongArray(list2);
            bundle.putLongArray("extra_spring_hb_wait_time_list", longArray2);
            this.f289621a.invoke(0, bundle);
        }

        @Override // com.tencent.mobileqq.springhb.servlet.a
        public void onFail(@NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("SpringHb_SpringServletHelper", 1, "requestWaitTime, onFail: " + errMsg);
            Bundle bundle = new Bundle();
            bundle.putString("extra_err_msg", errMsg);
            this.f289621a.invoke(-1, bundle);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61381);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f289615a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PackInfo b(FestivalPack$Pack pack) {
        PackInfo packInfo = new PackInfo();
        packInfo.f289475id = pack.pack_id.get();
        packInfo.state = pack.state.get();
        packInfo.type = pack.type.get();
        packInfo.ctime = pack.ctime.get();
        packInfo.money = pack.money.get();
        packInfo.bizId = pack.business_id.get();
        packInfo.signature = pack.signature.get();
        packInfo.url = pack.url.get();
        packInfo.mtime = pack.mtime.get();
        packInfo.order = pack.order.get();
        packInfo.uin = pack.uin.get();
        packInfo.sendUin = pack.send_uin.get();
        packInfo.wishing = pack.wishing.get();
        packInfo.promotionId = pack.promotion_id.get();
        packInfo.reqId = pack.req_id.get();
        packInfo.businessName = pack.business_name.get();
        packInfo.businessLogo = pack.business_logo.get();
        packInfo.businessCover = pack.business_cover.get();
        packInfo.businessVideoCover = pack.business_video_cover.get();
        packInfo.businessVideo = pack.business_video.get();
        packInfo.businessNamePic = pack.business_name_pic.get();
        packInfo.couponName = pack.coupon_name.get();
        packInfo.canLight = pack.can_light.get();
        packInfo.prizeId = pack.prize_id.get();
        packInfo.subtitle = pack.sub_title.get();
        packInfo.luckyScore = pack.lucky_score.get();
        packInfo.luckyScoreWording = pack.lucky_score_wording.get();
        packInfo.isH5 = pack.h5_flag.get();
        packInfo.content = pack.content.get();
        packInfo.welfareType = pack.welfare_type.get();
        packInfo.merchantJumpUrl = pack.business_jump_url.get();
        packInfo.merchantJumpHint = pack.business_jump_hint.get();
        int i3 = 0;
        for (FestivalPack$BusinessJumpInfo festivalPack$BusinessJumpInfo : pack.jump_info.get()) {
            int i16 = i3 + 1;
            if (i3 == 0) {
                packInfo.balanceEntrance = festivalPack$BusinessJumpInfo.hint.get();
                packInfo.balanceEntranceUrl = festivalPack$BusinessJumpInfo.url.get();
                packInfo.balanceEntranceType = festivalPack$BusinessJumpInfo.type.get();
                packInfo.balanceEntranceString = festivalPack$BusinessJumpInfo.report.get();
            }
            if (i3 == 1) {
                packInfo.balanceMiddleEntrance = festivalPack$BusinessJumpInfo.hint.get();
                packInfo.balanceMiddleEntranceUrl = festivalPack$BusinessJumpInfo.url.get();
                packInfo.balanceMiddleEntranceType = festivalPack$BusinessJumpInfo.type.get();
                packInfo.balanceMiddleEntranceString = festivalPack$BusinessJumpInfo.report.get();
            }
            if (i3 == 2) {
                packInfo.balanceLastEntrance = festivalPack$BusinessJumpInfo.hint.get();
                packInfo.balanceLastEntranceUrl = festivalPack$BusinessJumpInfo.url.get();
                packInfo.balanceLastEntranceType = festivalPack$BusinessJumpInfo.type.get();
                packInfo.balanceLastEntranceString = festivalPack$BusinessJumpInfo.report.get();
            }
            i3 = i16;
        }
        return packInfo;
    }

    @JvmStatic
    public static final void c(int sceneType, boolean isShua, @NotNull Function2<? super Integer, ? super Bundle, Unit> receiver) {
        String str;
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        QLog.d("SpringHb_SpringServletHelper", 1, "requestGift, sceneType=" + sceneType + ", isShua=" + isShua);
        FestivalPack$NewYearEvePackReq festivalPack$NewYearEvePackReq = new FestivalPack$NewYearEvePackReq();
        festivalPack$NewYearEvePackReq.scene.set(sceneType);
        festivalPack$NewYearEvePackReq.platform.set(1L);
        b bVar = new b(receiver);
        if (isShua) {
            str = "trpc.gamecenter.ym_spring_lottery_svr.YmSpringLotterySvr.SsoNewYearEvePack";
        } else {
            str = "trpc.springfestival.redpacket.LuckyBag.SsoDrawPrize";
        }
        b.Companion companion = com.tencent.mobileqq.springhb.servlet.b.INSTANCE;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime() ?: return");
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), com.tencent.mobileqq.springhb.servlet.b.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, str);
            newIntent.putExtra("req_bytes", fh.b(festivalPack$NewYearEvePackReq.toByteArray()));
            newIntent.putExtra("extra_timeout", 5000L);
            newIntent.setObserver(new a(bVar));
            peekAppRuntime.startServlet(newIntent);
        }
    }

    @JvmStatic
    public static final void d(int promotionId, int maxCombo, @NotNull Function2<? super Integer, ? super Bundle, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        QLog.d("SpringHb_SpringServletHelper", 1, "requestSysFinish");
        GetStarRedDot$AddUserLuckyBagScoreReq getStarRedDot$AddUserLuckyBagScoreReq = new GetStarRedDot$AddUserLuckyBagScoreReq();
        getStarRedDot$AddUserLuckyBagScoreReq.count.set(maxCombo);
        getStarRedDot$AddUserLuckyBagScoreReq.ID.set("1_1");
        getStarRedDot$AddUserLuckyBagScoreReq.promotion_id.set(promotionId);
        getStarRedDot$AddUserLuckyBagScoreReq.scene.set(1);
        d dVar = new d(receiver);
        b.Companion companion = com.tencent.mobileqq.springhb.servlet.b.INSTANCE;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime() ?: return");
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), com.tencent.mobileqq.springhb.servlet.b.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "trpc.springfestival.redpacket.LuckyBag.SsoAddUserLuckyBagScore");
            newIntent.putExtra("req_bytes", fh.b(getStarRedDot$AddUserLuckyBagScoreReq.toByteArray()));
            newIntent.putExtra("extra_timeout", 30000L);
            newIntent.setObserver(new C8609c(dVar));
            peekAppRuntime.startServlet(newIntent);
        }
    }

    @JvmStatic
    public static final void e(long addressCode, @NotNull Function2<? super Integer, ? super Bundle, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        QLog.d("SpringHb_SpringServletHelper", 1, "requestWaitTime, addressCode=" + addressCode);
        FestivalPack$GetWaitTimeReq festivalPack$GetWaitTimeReq = new FestivalPack$GetWaitTimeReq();
        festivalPack$GetWaitTimeReq.addr_code.set(addressCode);
        f fVar = new f(receiver);
        b.Companion companion = com.tencent.mobileqq.springhb.servlet.b.INSTANCE;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime() ?: return");
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), com.tencent.mobileqq.springhb.servlet.b.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "trpc.gamecenter.ym_spring_lottery_svr.YmSpringLotterySvr.SsoGetWaitTime");
            newIntent.putExtra("req_bytes", fh.b(festivalPack$GetWaitTimeReq.toByteArray()));
            newIntent.putExtra("extra_timeout", 5000L);
            newIntent.setObserver(new e(fVar));
            peekAppRuntime.startServlet(newIntent);
        }
    }
}
