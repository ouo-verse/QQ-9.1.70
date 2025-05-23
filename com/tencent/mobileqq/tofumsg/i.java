package com.tencent.mobileqq.tofumsg;

import android.text.TextUtils;
import com.tencent.mobileqq.BeancurdHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.oidb.tofuCommon.TofuCommon$TofuCubeInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tofumsg.pushtofu.proto.RevealLocal$NotifyReveal;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/i;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "", "a", "", "cmd", "", "pbBuffer", "", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i implements com.tencent.qqnt.kernel.frequencycontrol.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tofumsg.i$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61912);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(NewBeancurdMsg beancurdMsg, AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(beancurdMsg, "$beancurdMsg");
        QLog.i("Reveal8978.PushTofuDispatcher", 1, "start to resolve push tofu from nt sdk: " + beancurdMsg);
        Manager manager = appRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.beancurd.IBeancurdUpdater");
        ((com.tencent.mobileqq.beancurd.a) manager).d(beancurdMsg, "push");
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    @NotNull
    public int[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{221014};
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void b(int cmd, @NotNull byte[] pbBuffer) {
        String jsonString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, cmd, (Object) pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        if (cmd != 221014) {
            return;
        }
        if (!((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isRevealEnable()) {
            QLog.d("Reveal8978.PushTofuDispatcher", 1, "onDispatchCall isRevealEnable=false, return");
            return;
        }
        QLog.d("Reveal8978.PushTofuDispatcher", 1, "onDispatchCall for push tofu");
        try {
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d("Reveal8978.PushTofuDispatcher", 1, "app is null, return");
                return;
            }
            RevealLocal$NotifyReveal mergeFrom = new RevealLocal$NotifyReveal().mergeFrom(pbBuffer);
            String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(mergeFrom.uid.get());
            if (TextUtils.isEmpty(uinFromUid)) {
                QLog.d("Reveal8978.PushTofuDispatcher", 1, "convert uid -> uin failed, return");
                return;
            }
            TofuCommon$TofuCubeInfo mergeFrom2 = new TofuCommon$TofuCubeInfo().mergeFrom(mergeFrom.toufu.get().toByteArray());
            final NewBeancurdMsg newBeancurdMsg = new NewBeancurdMsg();
            newBeancurdMsg.busiid = mergeFrom2.uint64_busi_id.get();
            newBeancurdMsg.frienduin = uinFromUid;
            newBeancurdMsg.busiUuid = mergeFrom2.string_busi_uuid.get();
            newBeancurdMsg.extensionInfoStr = BeancurdHandler.P2(mergeFrom2);
            if (mergeFrom.need_del.get()) {
                jsonString = new NewBeancurdMsg.ExtraTofuInfo(true, 2).toJsonString();
            } else {
                jsonString = new NewBeancurdMsg.ExtraTofuInfo(false, 2).toJsonString();
            }
            newBeancurdMsg.pushInfoString = jsonString;
            QLog.i("Reveal8978.PushTofuDispatcher", 1, "receive push tofu from nt sdk: " + newBeancurdMsg);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.tofumsg.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.e(NewBeancurdMsg.this, peekAppRuntime);
                }
            }, 32, null, false);
        } catch (Exception e16) {
            QLog.d("Reveal8978.PushTofuDispatcher", 1, "parse pbBuffer exception:" + e16);
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(requestId), Integer.valueOf(cmd), pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        QLog.d("Reveal8978.PushTofuDispatcher", 1, "onDispatchRequest requestId: " + requestId + " cmd: " + cmd);
    }
}
