package com.tencent.mobileqq.opr;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.opr.model.TaskErrorCode;
import com.tencent.mobileqq.opr.model.TaskExtendResult;
import com.tencent.mobileqq.opr.model.a;
import com.tencent.mobileqq.opr.utils.SoLoader;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.qne.QneSDK;
import com.tencent.qne.delegate.b;
import com.tencent.qne.delegate.c;
import com.tencent.qne.delegate.d;
import io.github.landerlyoung.jenny.NativeClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeClass
@Keep
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0015\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082 J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0082 J\u00fb\u0003\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0093\u0001\u0010\u001f\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u0011j\u0002`\u001e2\u0093\u0001\u0010 \u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u0011j\u0002`\u001e2\u0093\u0001\u0010!\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u0011j\u0002`\u001e2\u0006\u0010\"\u001a\u00020\u0002H\u0082 J7\u0010-\u001a\u00020,2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\tJ\u0006\u00102\u001a\u000201J\u00f2\u0003\u00105\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0093\u0001\u00103\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u0011j\u0002`\u001e2\u0093\u0001\u0010 \u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u0011j\u0002`\u001e2\u0093\u0001\u00104\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u0011j\u0002`\u001e2\b\b\u0002\u0010\"\u001a\u00020\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00106\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/opr/QQOpr;", "", "", DownloadInfo.spKey_Config, "", "nInit", "nativeHandle", "", "nRelease", "", "nIsDeviceSupported", "nPreloadModel", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "albumId", "lloc", "url", "Lkotlin/Function6;", "Lcom/tencent/mobileqq/opr/model/TaskErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/mobileqq/opr/model/TaskExtendResult;", "taskExtendResult", "", "data", "", "width", "height", "repairTaskId", "Lcom/tencent/mobileqq/opr/OprCallback;", "backgroundCallback", "beforeUploadResultCallback", "totalCallback", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "nStartEnhancementTask", "Landroid/content/Context;", "context", "Lcom/tencent/qne/delegate/d;", "shiply", "Lcom/tencent/qne/delegate/b;", "logger", "Lcom/tencent/qne/delegate/c;", "reporter", "Lcom/tencent/qne/util/d;", ColorRingJsPlugin.Method_SetUp, "(Landroid/content/Context;Lcom/tencent/qne/delegate/d;Lcom/tencent/qne/delegate/b;Lcom/tencent/qne/delegate/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "isDeviceSupported", "Lcom/tencent/mobileqq/opr/model/a;", "preloadModel", "backgroundOprCallback", "totalOprCallback", "startEnhancementTask", "Ljava/lang/Long;", "<init>", "()V", "Companion", "a", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class QQOpr {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String OPR = "OPR";

    @NotNull
    private static final String TAG = "[opr]QQOpr";

    @Nullable
    private Long nativeHandle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/opr/QQOpr$a;", "", "", QQOpr.OPR, "Ljava/lang/String;", "TAG", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.mobileqq.opr.QQOpr$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7954);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQOpr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final native long nInit(String config);

    static /* synthetic */ long nInit$default(QQOpr qQOpr, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return qQOpr.nInit(str);
    }

    private final native boolean nIsDeviceSupported(long nativeHandle);

    private final native boolean nPreloadModel(long nativeHandle);

    private final native void nRelease(long nativeHandle);

    private final native void nStartEnhancementTask(long nativeHandle, Bitmap bitmap, String albumId, String lloc, String url, Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> backgroundCallback, Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> beforeUploadResultCallback, Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> totalCallback, String taskId);

    public static /* synthetic */ Object setup$default(QQOpr qQOpr, Context context, d dVar, b bVar, c cVar, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            cVar = null;
        }
        return qQOpr.setup(context, dVar, bVar, cVar, continuation);
    }

    public static /* synthetic */ void startEnhancementTask$default(QQOpr qQOpr, Bitmap bitmap, String str, String str2, String str3, Function6 function6, Function6 function62, Function6 function63, String str4, int i3, Object obj) {
        String str5;
        if ((i3 & 128) != 0) {
            str5 = "";
        } else {
            str5 = str4;
        }
        qQOpr.startEnhancementTask(bitmap, str, str2, str3, function6, function62, function63, str5);
    }

    public final boolean isDeviceSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Long l3 = this.nativeHandle;
        if (l3 == null) {
            return false;
        }
        return nIsDeviceSupported(l3.longValue());
    }

    @NotNull
    public final a preloadModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Long l3 = this.nativeHandle;
        if (l3 == null) {
            return new a(false, 0L, 3, null);
        }
        long longValue = l3.longValue();
        long currentTimeMillis = System.currentTimeMillis();
        boolean nPreloadModel = nPreloadModel(longValue);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        OprLogger.i(TAG, "preloadModel " + nPreloadModel + ", cost:" + currentTimeMillis2 + " ms");
        return new a(nPreloadModel, currentTimeMillis2);
    }

    public final void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Long l3 = this.nativeHandle;
        if (l3 == null) {
            return;
        }
        nRelease(l3.longValue());
        this.nativeHandle = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object setup(@NotNull Context context, @NotNull d dVar, @NotNull b bVar, @Nullable c cVar, @NotNull Continuation<? super com.tencent.qne.util.d> continuation) {
        QQOpr$setup$1 qQOpr$setup$1;
        Object coroutine_suspended;
        int i3;
        QQOpr qQOpr;
        Context context2;
        d dVar2;
        com.tencent.qne.util.d dVar3;
        Context context3;
        QQOpr qQOpr2;
        com.tencent.qne.util.d dVar4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, context, dVar, bVar, cVar, continuation);
        }
        if (continuation instanceof QQOpr$setup$1) {
            qQOpr$setup$1 = (QQOpr$setup$1) continuation;
            int i16 = qQOpr$setup$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qQOpr$setup$1.label = i16 - Integer.MIN_VALUE;
                QQOpr$setup$1 qQOpr$setup$12 = qQOpr$setup$1;
                Object obj = qQOpr$setup$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQOpr$setup$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            context3 = (Context) qQOpr$setup$12.L$1;
                            qQOpr2 = (QQOpr) qQOpr$setup$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            dVar4 = (com.tencent.qne.util.d) obj;
                            if (dVar4.b()) {
                                OprLogger.e(TAG, Intrinsics.stringPlus("setup fail, opr setup fail, oprStatus:", dVar4));
                                return dVar4;
                            }
                            qQOpr2.nativeHandle = Boxing.boxLong(nInit$default(qQOpr2, null, 1, null));
                            PlatformBridge.INSTANCE.init(context3);
                            return dVar4;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dVar2 = (d) qQOpr$setup$12.L$2;
                    context2 = (Context) qQOpr$setup$12.L$1;
                    qQOpr = (QQOpr) qQOpr$setup$12.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    OprLogger.INSTANCE.init$opr_debug(bVar);
                    QneSDK qneSDK = QneSDK.f344322a;
                    qQOpr$setup$12.L$0 = this;
                    qQOpr$setup$12.L$1 = context;
                    qQOpr$setup$12.L$2 = dVar;
                    qQOpr$setup$12.label = 1;
                    obj = qneSDK.c(context, dVar, bVar, cVar, qQOpr$setup$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQOpr = this;
                    context2 = context;
                    dVar2 = dVar;
                }
                dVar3 = (com.tencent.qne.util.d) obj;
                if (dVar3.b()) {
                    OprLogger.e(TAG, Intrinsics.stringPlus("setup fail, qne setup fail, qneStatus:", dVar3));
                    return dVar3;
                }
                SoLoader soLoader = new SoLoader(dVar2, context2.getFilesDir() + "/OPR/so");
                qQOpr$setup$12.L$0 = qQOpr;
                qQOpr$setup$12.L$1 = context2;
                qQOpr$setup$12.L$2 = null;
                qQOpr$setup$12.label = 2;
                obj = soLoader.e(qQOpr$setup$12);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                context3 = context2;
                qQOpr2 = qQOpr;
                dVar4 = (com.tencent.qne.util.d) obj;
                if (dVar4.b()) {
                }
            }
        }
        qQOpr$setup$1 = new QQOpr$setup$1(this, continuation);
        QQOpr$setup$1 qQOpr$setup$122 = qQOpr$setup$1;
        Object obj2 = qQOpr$setup$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQOpr$setup$122.label;
        if (i3 == 0) {
        }
        dVar3 = (com.tencent.qne.util.d) obj2;
        if (dVar3.b()) {
        }
    }

    public final void startEnhancementTask(@NotNull Bitmap bitmap, @NotNull String albumId, @NotNull String lloc, @NotNull String url, @NotNull Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> backgroundOprCallback, @NotNull Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> beforeUploadResultCallback, @NotNull Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> totalOprCallback, @NotNull String taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bitmap, albumId, lloc, url, backgroundOprCallback, beforeUploadResultCallback, totalOprCallback, taskId);
            return;
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(backgroundOprCallback, "backgroundOprCallback");
        Intrinsics.checkNotNullParameter(beforeUploadResultCallback, "beforeUploadResultCallback");
        Intrinsics.checkNotNullParameter(totalOprCallback, "totalOprCallback");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Long l3 = this.nativeHandle;
        if (l3 == null) {
            return;
        }
        nStartEnhancementTask(l3.longValue(), bitmap, albumId, lloc, url, backgroundOprCallback, beforeUploadResultCallback, totalOprCallback, taskId);
    }
}
