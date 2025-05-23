package n43;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vashealth.pb.QQSportsUserServer$SsoUserStepReq;
import com.tencent.mobileqq.vashealth.pb.QQSportsUserServer$SsoUserStepRsp;
import com.tencent.mobileqq.vashealth.pb.QQSportsUserServer$UserStep;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\"\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u0010\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u0018\u0010\u0015\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000f0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Ln43/a;", "", "", "", "uins", "Lcom/tencent/mobileqq/vashealth/pb/QQSportsUserServer$SsoUserStepReq;", "a", "Ln43/d;", "callback", "Lcom/tencent/mobileqq/vashealth/pb/QQSportsUserServer$SsoUserStepRsp;", "rsp", "", "result", "", "c", "Ljava/lang/ref/WeakReference;", "d", "Landroid/content/Intent;", "intent", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "fromServiceMsg", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "mUserStepCallbackMap", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f418307a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, WeakReference<d>> mUserStepCallbackMap = new ConcurrentHashMap<>();

    a() {
    }

    private final QQSportsUserServer$SsoUserStepReq a(List<Long> uins) {
        QQSportsUserServer$SsoUserStepReq qQSportsUserServer$SsoUserStepReq = new QQSportsUserServer$SsoUserStepReq();
        qQSportsUserServer$SsoUserStepReq.uins.set(uins);
        return qQSportsUserServer$SsoUserStepReq;
    }

    private final void c(d callback, QQSportsUserServer$SsoUserStepRsp rsp, boolean result) {
        if (callback == null) {
            return;
        }
        for (QQSportsUserServer$UserStep userStep : rsp.user_steps.get()) {
            Intrinsics.checkNotNullExpressionValue(userStep, "userStep");
            callback.a(result, userStep);
            c.f418310a.g(userStep.uin.get(), userStep.step.get());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(@Nullable Intent intent, @NotNull FromServiceMsg fromServiceMsg) {
        d dVar;
        int resultCode;
        Intrinsics.checkNotNullParameter(fromServiceMsg, "fromServiceMsg");
        byte[] bArr = null;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("requestKey");
            if (!TextUtils.isEmpty(stringExtra)) {
                ConcurrentHashMap<String, WeakReference<d>> concurrentHashMap = mUserStepCallbackMap;
                WeakReference<d> weakReference = concurrentHashMap.get(stringExtra);
                if (weakReference != null) {
                    dVar = weakReference.get();
                } else {
                    dVar = null;
                }
                TypeIntrinsics.asMutableMap(concurrentHashMap).remove(stringExtra);
                if (fromServiceMsg.isSuccess()) {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr2 = new byte[length];
                    PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    bArr = bArr2;
                }
                QQSportsUserServer$SsoUserStepRsp qQSportsUserServer$SsoUserStepRsp = new QQSportsUserServer$SsoUserStepRsp();
                resultCode = fromServiceMsg.getResultCode();
                if (resultCode != 1000) {
                    try {
                        qQSportsUserServer$SsoUserStepRsp.mergeFrom(bArr);
                        List<QQSportsUserServer$UserStep> list = qQSportsUserServer$SsoUserStepRsp.user_steps.get();
                        Intrinsics.checkNotNullExpressionValue(list, "rspBody.user_steps.get()");
                        boolean z16 = !list.isEmpty();
                        if (dVar != null && z16) {
                            c(dVar, qQSportsUserServer$SsoUserStepRsp, true);
                        } else {
                            QLog.e("QQSportsUserStepRequest", 1, "onGetUserStepRsp, callback: " + dVar + " isValid: " + z16);
                            c(dVar, qQSportsUserServer$SsoUserStepRsp, false);
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e("QQSportsUserStepRequest", 1, "onReceive exception " + e16);
                        c(dVar, qQSportsUserServer$SsoUserStepRsp, false);
                        return;
                    }
                }
                QLog.e("QQSportsUserStepRequest", 1, "onReceive result fail with result " + resultCode);
                c(dVar, qQSportsUserServer$SsoUserStepRsp, false);
                return;
            }
        }
        dVar = null;
        if (fromServiceMsg.isSuccess()) {
        }
        QQSportsUserServer$SsoUserStepRsp qQSportsUserServer$SsoUserStepRsp2 = new QQSportsUserServer$SsoUserStepRsp();
        resultCode = fromServiceMsg.getResultCode();
        if (resultCode != 1000) {
        }
    }

    public final void d(@NotNull List<Long> uins, @NotNull WeakReference<d> callback) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uins.isEmpty()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("QQSportsUserStepRequest", 1, "requestUserStep, get null appRuntime, requestUserStep cancel");
            return;
        }
        QQSportsUserServer$SsoUserStepReq a16 = a(uins);
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), b.class);
        newIntent.putExtra("data", fh.b(a16.toByteArray()));
        newIntent.putExtra("cmd", "trpc.qq_sports.user_server.CommInfo.SsoUserStep");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        mUserStepCallbackMap.put(uuid, callback);
        newIntent.putExtra("requestKey", uuid);
        peekAppRuntime.startServlet(newIntent);
    }
}
