package com.tencent.qne;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.delegate.d;
import com.tencent.qne.model.Backend;
import com.tencent.qne.model.QneInterpreter;
import com.tencent.qne.util.Logger;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J;\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0082 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qne/QneInterpreterHelper;", "", "()V", "QNE_MODEL_PREFIX", "", "TAG", "downloadShiplyResource", "", "resourceId", "inferenceType", "", "callbackHandle", "", "onDownloadFinish", "errorCode", "errorMessage", "url", "localPath", "qne_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class QneInterpreterHelper {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final QneInterpreterHelper INSTANCE;

    @NotNull
    public static final String QNE_MODEL_PREFIX = "qne_model";

    @NotNull
    private static final String TAG = "[qne]QneInterpreterHelper";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14450);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new QneInterpreterHelper();
        }
    }

    QneInterpreterHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void downloadShiplyResource(@NotNull String resourceId, int inferenceType, long callbackHandle) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        d a16 = QneSDK.f344322a.a();
        if (a16 == null) {
            onDownloadFinish$default(INSTANCE, callbackHandle, 5, "Shiply Delegate Not Registered!", null, null, 24, null);
            return;
        }
        Backend d16 = QneInterpreter.f344344a.d(inferenceType);
        if (d16 == null) {
            Logger.e(TAG, "convert from inferenceType:" + inferenceType + " to backend failed for $" + resourceId);
            onDownloadFinish$default(INSTANCE, callbackHandle, 5, "Unsupported inferenceType", null, null, 24, null);
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new QneInterpreterHelper$downloadShiplyResource$1(d16, a16, callbackHandle, resourceId, d16.e(resourceId), d16.a(resourceId), null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void onDownloadFinish(long callbackHandle, int errorCode, String errorMessage, String url, String localPath);

    static /* synthetic */ void onDownloadFinish$default(QneInterpreterHelper qneInterpreterHelper, long j3, int i3, String str, String str2, String str3, int i16, Object obj) {
        String str4;
        String str5;
        if ((i16 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i16 & 16) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        qneInterpreterHelper.onDownloadFinish(j3, i3, str, str4, str5);
    }
}
