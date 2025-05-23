package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/essencemsg/b;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "", "a", "", "cmd", "", "pbBuffer", "", "b", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements com.tencent.qqnt.kernel.frequencycontrol.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/essencemsg/b$a;", "", "", "HEAD_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.essencemsg.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62014);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    @NotNull
    public int[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{221008, 221010};
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void b(int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, cmd, (Object) pbBuffer);
            return;
        }
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        if (pbBuffer.length > 7) {
            int length = pbBuffer.length - 7;
            byte[] bArr = new byte[length];
            PkgTools.copyData(bArr, 0, pbBuffer, 7, length);
            try {
                TroopTips0x857$NotifyMsgBody mergeFrom = new TroopTips0x857$NotifyMsgBody().mergeFrom(bArr);
                if (mergeFrom != null) {
                    int i3 = mergeFrom.opt_enum_type.get();
                    long j3 = mergeFrom.opt_uint64_group_code.get();
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopEssenceDispatcherCallback", 2, "[onDispatchCall] promptType: " + i3 + ", troopUin: " + LogUtil.getSafePrintUin(String.valueOf(j3)));
                    }
                    if (i3 != 27) {
                        if (i3 == 31 && mergeFrom.opt_group_digest_msg_summary.has()) {
                            Manager manager = peekAppRuntime.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
                            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager");
                            ((TroopEssenceMsgManager) manager).D(j3, mergeFrom.opt_group_digest_msg_summary.get());
                            return;
                        }
                        return;
                    }
                    if (mergeFrom.opt_qq_group_digest_msg.has()) {
                        Manager manager2 = peekAppRuntime.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
                        Intrinsics.checkNotNull(manager2, "null cannot be cast to non-null type com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager");
                        ((TroopEssenceMsgManager) manager2).G(mergeFrom.opt_qq_group_digest_msg.get());
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("TroopEssenceDispatcherCallback", 1, "[onDispatchCall] merge exception: " + e16.getMessage() + ", pbBufferSize: " + pbBuffer.length);
                return;
            }
        }
        QLog.e("TroopEssenceDispatcherCallback", 1, "[onDispatchCall] pbBuffer size too small, pbBufferSize: " + pbBuffer.length);
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(requestId), Integer.valueOf(cmd), pbBuffer);
        } else {
            Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        }
    }
}
