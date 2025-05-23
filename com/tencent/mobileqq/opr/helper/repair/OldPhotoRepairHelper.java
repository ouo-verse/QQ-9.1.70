package com.tencent.mobileqq.opr.helper.repair;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.opr.QQOpr;
import com.tencent.mobileqq.opr.helper.repair.model.ImageInfo;
import com.tencent.mobileqq.opr.helper.repair.model.OprStatus;
import com.tencent.mobileqq.opr.helper.sr.model.e;
import com.tencent.mobileqq.opr.model.TaskErrorCode;
import com.tencent.mobileqq.opr.model.TaskExtendResult;
import com.tencent.mobileqq.opr.model.TaskReportParams;
import com.tencent.mobileqq.opr.model.a;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qne.delegate.b;
import com.tencent.qne.delegate.c;
import com.tencent.qne.delegate.d;
import com.tencent.qne.util.Md5UtilKt;
import com.tencent.zplan.common.utils.FileCache;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001&B1\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\ba\u0010bJ\u00cf\u0001\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0099\u0001\b\u0002\u0010\u0015\u001a\u0092\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006j\u0004\u0018\u0001`\u00142\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u001e\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u00cb\u0001\u0010!\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\u0099\u0001\b\u0002\u0010\u0015\u001a\u0092\u0001\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006j\u0004\u0018\u0001`\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001a\u00020\u0013R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107RR\u0010B\u001a/\b\u0001\u0012\u0013\u0012\u001105\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130;\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ERR\u0010J\u001a/\b\u0001\u0012\u0013\u0012\u00110C\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130;\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u0012\n\u0004\bG\u0010=\u001a\u0004\bH\u0010?\"\u0004\bI\u0010AR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0017\u0010T\u001a\u00020O8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001c\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010_\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper;", "", "", "key", "Lcom/tencent/mobileqq/opr/helper/repair/model/ImageInfo;", "imageInfo", "Lkotlin/Function6;", "Lcom/tencent/mobileqq/opr/model/TaskErrorCode;", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/mobileqq/opr/model/TaskExtendResult;", "taskExtendResult", "", "data", "", "width", "height", "repairTaskId", "", "Lcom/tencent/mobileqq/opr/helper/repair/BeforeUploadResultCallback;", "beforeUploadResultCallback", "Lkotlin/Function0;", "Landroid/graphics/Bitmap;", "getBitmap", "Lcom/tencent/mobileqq/opr/helper/repair/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;Lcom/tencent/mobileqq/opr/helper/repair/model/ImageInfo;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/util/Size;", "r", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, MimeHelper.IMAGE_SUBTYPE_BITMAP, "t", "(Ljava/lang/String;Lcom/tencent/mobileqq/opr/helper/repair/model/ImageInfo;Landroid/graphics/Bitmap;Lkotlin/jvm/functions/Function6;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "contextRef", "Lcom/tencent/qne/delegate/d;", "b", "Lcom/tencent/qne/delegate/d;", "shiply", "Lcom/tencent/qne/delegate/b;", "c", "Lcom/tencent/qne/delegate/b;", "logger", "Lcom/tencent/qne/delegate/c;", "d", "Lcom/tencent/qne/delegate/c;", "reporter", "Lcom/tencent/qne/util/d;", "e", "Lcom/tencent/qne/util/d;", "initStatus", "Lkotlin/Function2;", "status", "Lkotlin/coroutines/Continuation;", "f", "Lkotlin/jvm/functions/Function2;", "o", "()Lkotlin/jvm/functions/Function2;", "setInitStatusListener", "(Lkotlin/jvm/functions/Function2;)V", "initStatusListener", "Lcom/tencent/mobileqq/opr/model/a;", "g", "Lcom/tencent/mobileqq/opr/model/a;", "modelStatus", h.F, "p", "setModelStatusListener", "modelStatusListener", "Lkotlinx/coroutines/CompletableJob;", "i", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CoroutineScope;", "j", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/tencent/mobileqq/opr/QQOpr;", "k", "Lkotlinx/coroutines/CompletableDeferred;", "oprDeferred", "Lkotlinx/coroutines/Job;", "l", "Lkotlinx/coroutines/Job;", "initJob", "Lcom/tencent/zplan/common/utils/FileCache;", "Lcom/tencent/zplan/common/utils/FileCache;", "fileCache", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/tencent/qne/delegate/d;Lcom/tencent/qne/delegate/b;Lcom/tencent/qne/delegate/c;)V", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class OldPhotoRepairHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private static String f257001o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private static FileCache f257002p;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> contextRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d shiply;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b logger;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c reporter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qne.util.d initStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super com.tencent.qne.util.d, ? super Continuation<? super Unit>, ? extends Object> initStatusListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a modelStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super a, ? super Continuation<? super Unit>, ? extends Object> modelStatusListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompletableJob supervisorJob;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CompletableDeferred<QQOpr> oprDeferred;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job initJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FileCache fileCache;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/repair/OldPhotoRepairHelper$a;", "", "Lcom/tencent/mobileqq/opr/model/TaskErrorCode;", "Lcom/tencent/mobileqq/opr/helper/repair/model/OprStatus;", "e", "", "d", "Landroid/content/Context;", "context", "Lcom/tencent/zplan/common/utils/FileCache;", "c", "TAG", "Ljava/lang/String;", "fileCache", "Lcom/tencent/zplan/common/utils/FileCache;", "fileCacheDir", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public /* synthetic */ class C8194a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f257016a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8437);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[TaskErrorCode.values().length];
                iArr[TaskErrorCode.Success.ordinal()] = 1;
                iArr[TaskErrorCode.InputInvalid.ordinal()] = 2;
                iArr[TaskErrorCode.CheckSafetyFail.ordinal()] = 3;
                iArr[TaskErrorCode.UnsupportImage.ordinal()] = 4;
                iArr[TaskErrorCode.UploadResultFail.ordinal()] = 5;
                f257016a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(String str) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("qq_opr_cache_%s", Arrays.copyOf(new Object[]{Md5UtilKt.b(str)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final OprStatus e(TaskErrorCode taskErrorCode) {
            int i3 = C8194a.f257016a[taskErrorCode.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return OprStatus.DoOprFail;
                            }
                            return OprStatus.UploadResultFail;
                        }
                        return OprStatus.UnsupportImage;
                    }
                    return OprStatus.CheckSafetyFail;
                }
                return OprStatus.GetInputBitmapFail;
            }
            return OprStatus.Success;
        }

        @NotNull
        public final synchronized FileCache c(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FileCache) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (OldPhotoRepairHelper.f257002p == null) {
                String str = context.getCacheDir() + "/OPR/OPRCache";
                OldPhotoRepairHelper.f257001o = str;
                OldPhotoRepairHelper.f257002p = new FileCache(str, 500L);
            }
            FileCache fileCache = OldPhotoRepairHelper.f257002p;
            Intrinsics.checkNotNull(fileCache);
            return fileCache;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9697);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public OldPhotoRepairHelper(@NotNull WeakReference<Context> contextRef, @NotNull d shiply, @NotNull b logger, @Nullable c cVar) {
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        Intrinsics.checkNotNullParameter(shiply, "shiply");
        Intrinsics.checkNotNullParameter(logger, "logger");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contextRef, shiply, logger, cVar);
            return;
        }
        this.contextRef = contextRef;
        this.shiply = shiply;
        this.logger = logger;
        this.reporter = cVar;
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.supervisorJob = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorJob$default));
        this.oprDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Companion companion = INSTANCE;
        Context context = contextRef.get();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "contextRef.get()!!");
        this.fileCache = companion.c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(String str, ImageInfo imageInfo, Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> function6, Function0<Bitmap> function0, Continuation<? super com.tencent.mobileqq.opr.helper.repair.model.a> continuation) {
        OldPhotoRepairHelper$realStartEnhancement$1 oldPhotoRepairHelper$realStartEnhancement$1;
        Object coroutine_suspended;
        int i3;
        long currentTimeMillis;
        ImageInfo imageInfo2;
        final Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> function62;
        final OldPhotoRepairHelper oldPhotoRepairHelper;
        final String str2;
        Bitmap bitmap;
        QQOpr qQOpr;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof OldPhotoRepairHelper$realStartEnhancement$1) {
            oldPhotoRepairHelper$realStartEnhancement$1 = (OldPhotoRepairHelper$realStartEnhancement$1) continuation;
            int i16 = oldPhotoRepairHelper$realStartEnhancement$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                oldPhotoRepairHelper$realStartEnhancement$1.label = i16 - Integer.MIN_VALUE;
                Object obj = oldPhotoRepairHelper$realStartEnhancement$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = oldPhotoRepairHelper$realStartEnhancement$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    currentTimeMillis = oldPhotoRepairHelper$realStartEnhancement$1.J$0;
                    bitmap = (Bitmap) oldPhotoRepairHelper$realStartEnhancement$1.L$4;
                    Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> function63 = (Function6) oldPhotoRepairHelper$realStartEnhancement$1.L$3;
                    imageInfo2 = (ImageInfo) oldPhotoRepairHelper$realStartEnhancement$1.L$2;
                    String str3 = (String) oldPhotoRepairHelper$realStartEnhancement$1.L$1;
                    OldPhotoRepairHelper oldPhotoRepairHelper2 = (OldPhotoRepairHelper) oldPhotoRepairHelper$realStartEnhancement$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str3;
                    oldPhotoRepairHelper = oldPhotoRepairHelper2;
                    function62 = function63;
                } else {
                    ResultKt.throwOnFailure(obj);
                    OprLogger.d("[opr]OldPhotoRepairHelper", Intrinsics.stringPlus("realStartEnhancement start, key:", str));
                    Bitmap invoke = function0.invoke();
                    if (invoke == null) {
                        return new com.tencent.mobileqq.opr.helper.repair.model.a(OprStatus.GetInputBitmapFail, null, null, null, 0, 30, null);
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    s();
                    CompletableDeferred<QQOpr> completableDeferred = this.oprDeferred;
                    oldPhotoRepairHelper$realStartEnhancement$1.L$0 = this;
                    oldPhotoRepairHelper$realStartEnhancement$1.L$1 = str;
                    imageInfo2 = imageInfo;
                    oldPhotoRepairHelper$realStartEnhancement$1.L$2 = imageInfo2;
                    function62 = function6;
                    oldPhotoRepairHelper$realStartEnhancement$1.L$3 = function62;
                    oldPhotoRepairHelper$realStartEnhancement$1.L$4 = invoke;
                    oldPhotoRepairHelper$realStartEnhancement$1.J$0 = currentTimeMillis;
                    oldPhotoRepairHelper$realStartEnhancement$1.label = 1;
                    Object await = completableDeferred.await(oldPhotoRepairHelper$realStartEnhancement$1);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    oldPhotoRepairHelper = this;
                    str2 = str;
                    bitmap = invoke;
                    obj = await;
                }
                qQOpr = (QQOpr) obj;
                final com.tencent.mobileqq.opr.helper.sr.model.b bVar = new com.tencent.mobileqq.opr.helper.sr.model.b(true, System.currentTimeMillis() - currentTimeMillis, new com.tencent.mobileqq.opr.helper.sr.model.c(oldPhotoRepairHelper.initStatus, oldPhotoRepairHelper.modelStatus));
                if (qQOpr != null) {
                    OprLogger.e("[opr]OldPhotoRepairHelper", "startEnhancement fail, opr instance null");
                    return new com.tencent.mobileqq.opr.helper.repair.model.a(OprStatus.GetOprInstanceFail, null, null, new e(null, bVar, null, null, null, 29, null), 0, 22, null);
                }
                oldPhotoRepairHelper$realStartEnhancement$1.L$0 = oldPhotoRepairHelper;
                oldPhotoRepairHelper$realStartEnhancement$1.L$1 = str2;
                oldPhotoRepairHelper$realStartEnhancement$1.L$2 = imageInfo2;
                oldPhotoRepairHelper$realStartEnhancement$1.L$3 = function62;
                oldPhotoRepairHelper$realStartEnhancement$1.L$4 = bitmap;
                oldPhotoRepairHelper$realStartEnhancement$1.L$5 = qQOpr;
                oldPhotoRepairHelper$realStartEnhancement$1.L$6 = bVar;
                oldPhotoRepairHelper$realStartEnhancement$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(oldPhotoRepairHelper$realStartEnhancement$1);
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                final long currentTimeMillis2 = System.currentTimeMillis();
                String albumId = imageInfo2.getAlbumId();
                String lloc = imageInfo2.getLloc();
                String url = imageInfo2.getUrl();
                String taskId = imageInfo2.getTaskId();
                if (taskId == null) {
                    taskId = "";
                }
                final Bitmap bitmap2 = bitmap;
                qQOpr.startEnhancementTask(bitmap2, albumId, lloc, url, new Function6<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, String, Unit>(currentTimeMillis2) { // from class: com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$realStartEnhancement$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long $timeStart;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(6);
                        this.$timeStart = currentTimeMillis2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, currentTimeMillis2);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function6
                    public /* bridge */ /* synthetic */ Unit invoke(TaskErrorCode taskErrorCode, TaskExtendResult taskExtendResult, byte[] bArr, Integer num, Integer num2, String str4) {
                        invoke(taskErrorCode, taskExtendResult, bArr, num.intValue(), num2.intValue(), str4);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull TaskErrorCode errorCode, @NotNull TaskExtendResult extend, @Nullable byte[] bArr, int i17, int i18, @Nullable String str4) {
                        OprStatus e16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, errorCode, extend, bArr, Integer.valueOf(i17), Integer.valueOf(i18), str4);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                        Intrinsics.checkNotNullParameter(extend, "extend");
                        if (!(errorCode == TaskErrorCode.Success)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("\u30101/2\u3011\u274cstartEnhancement bgRepair fail, errorCode=");
                            sb5.append(errorCode);
                            sb5.append(", errMsg=");
                            e16 = OldPhotoRepairHelper.INSTANCE.e(errorCode);
                            sb5.append((Object) e16.getErrorMessage());
                            OprLogger.i("[opr]OldPhotoRepairHelper", sb5.toString());
                            return;
                        }
                        OprLogger.i("[opr]OldPhotoRepairHelper", "\u30101/2\u3011\u2705startEnhancement bgRepair success, width=" + i17 + ", height=" + i18 + ", cost=" + (System.currentTimeMillis() - this.$timeStart));
                    }
                }, new Function6<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, String, Unit>(function62) { // from class: com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$realStartEnhancement$2$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function6<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, String, Unit> $beforeUploadResultCallback;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(6);
                        this.$beforeUploadResultCallback = function62;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) function62);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function6
                    public /* bridge */ /* synthetic */ Unit invoke(TaskErrorCode taskErrorCode, TaskExtendResult taskExtendResult, byte[] bArr, Integer num, Integer num2, String str4) {
                        invoke(taskErrorCode, taskExtendResult, bArr, num.intValue(), num2.intValue(), str4);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull TaskErrorCode errorCode, @NotNull TaskExtendResult extend, @Nullable byte[] bArr, int i17, int i18, @Nullable String str4) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, errorCode, extend, bArr, Integer.valueOf(i17), Integer.valueOf(i18), str4);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                        Intrinsics.checkNotNullParameter(extend, "extend");
                        Function6<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, String, Unit> function64 = this.$beforeUploadResultCallback;
                        if (function64 != null) {
                            function64.invoke(errorCode, extend, bArr, Integer.valueOf(i17), Integer.valueOf(i18), str4);
                        }
                        OprLogger.i("[opr]OldPhotoRepairHelper", "beforeUploadResultCallback");
                    }
                }, new Function6<TaskErrorCode, TaskExtendResult, byte[], Integer, Integer, String, Unit>(currentTimeMillis2, oldPhotoRepairHelper, str2, bVar, bitmap2, cancellableContinuationImpl) { // from class: com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$realStartEnhancement$2$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation<com.tencent.mobileqq.opr.helper.repair.model.a> $continuation;
                    final /* synthetic */ com.tencent.mobileqq.opr.helper.sr.model.b $getSrInstanceStatistic;
                    final /* synthetic */ Bitmap $inputBitmap;
                    final /* synthetic */ String $key;
                    final /* synthetic */ long $timeStart;
                    final /* synthetic */ OldPhotoRepairHelper this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(6);
                        this.$timeStart = currentTimeMillis2;
                        this.this$0 = oldPhotoRepairHelper;
                        this.$key = str2;
                        this.$getSrInstanceStatistic = bVar;
                        this.$inputBitmap = bitmap2;
                        this.$continuation = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, Long.valueOf(currentTimeMillis2), oldPhotoRepairHelper, str2, bVar, bitmap2, cancellableContinuationImpl);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function6
                    public /* bridge */ /* synthetic */ Unit invoke(TaskErrorCode taskErrorCode, TaskExtendResult taskExtendResult, byte[] bArr, Integer num, Integer num2, String str4) {
                        invoke(taskErrorCode, taskExtendResult, bArr, num.intValue(), num2.intValue(), str4);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull TaskErrorCode errorCode, @NotNull TaskExtendResult extend, @Nullable byte[] bArr, int i17, int i18, @Nullable String str4) {
                        OprStatus e16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, errorCode, extend, bArr, Integer.valueOf(i17), Integer.valueOf(i18), str4);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                        Intrinsics.checkNotNullParameter(extend, "extend");
                        long currentTimeMillis3 = System.currentTimeMillis() - this.$timeStart;
                        TaskErrorCode taskErrorCode = TaskErrorCode.Success;
                        Bitmap a16 = (errorCode != taskErrorCode || bArr == null) ? null : com.tencent.mobileqq.opr.utils.a.a(bArr, i17, i18);
                        Size r16 = a16 != null ? this.this$0.r(a16, this.$key) : null;
                        if (a16 != null) {
                            a16.recycle();
                        }
                        String n3 = this.this$0.n(this.$key);
                        if (n3 != null) {
                            OprLogger.i("[opr]OldPhotoRepairHelper", "\u30102/2\u3011\u2705startEnhancement totalRepair success, width=" + i17 + ", height=" + i18 + ", cost=" + currentTimeMillis3 + ", outputPath=" + ((Object) n3));
                            e16 = OprStatus.Success;
                        } else {
                            OprLogger.i("[opr]OldPhotoRepairHelper", "\u30102/2\u3011\u274cstartEnhancement totalRepair failed, width=" + i17 + ", height=" + i18 + ", cost=" + currentTimeMillis3);
                            if (errorCode != taskErrorCode) {
                                e16 = OldPhotoRepairHelper.INSTANCE.e(errorCode);
                            } else {
                                e16 = OprStatus.DoOprFail;
                            }
                        }
                        TaskReportParams taskReportParams = extend.getTaskReportParams();
                        int queueWaitingTimeMs = taskReportParams == null ? 0 : taskReportParams.getQueueWaitingTimeMs();
                        TaskReportParams taskReportParams2 = extend.getTaskReportParams();
                        com.tencent.mobileqq.opr.helper.repair.model.a aVar = new com.tencent.mobileqq.opr.helper.repair.model.a(e16, n3, str4, new e(Boolean.FALSE, this.$getSrInstanceStatistic, new com.tencent.mobileqq.opr.helper.sr.model.a(errorCode, queueWaitingTimeMs, taskReportParams2 != null ? taskReportParams2.getExecuteTimeMs() : 0), com.tencent.mobileqq.opr.utils.a.e(this.$inputBitmap), r16), extend.getPhotoSize());
                        OprLogger.i("[opr]OldPhotoRepairHelper", Intrinsics.stringPlus("startEnhancement end, result:", aVar));
                        this.$continuation.resumeWith(Result.m476constructorimpl(aVar));
                    }
                }, taskId);
                obj = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(oldPhotoRepairHelper$realStartEnhancement$1);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        oldPhotoRepairHelper$realStartEnhancement$1 = new OldPhotoRepairHelper$realStartEnhancement$1(this, continuation);
        Object obj2 = oldPhotoRepairHelper$realStartEnhancement$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = oldPhotoRepairHelper$realStartEnhancement$1.label;
        if (i3 == 0) {
        }
        qQOpr = (QQOpr) obj2;
        final com.tencent.mobileqq.opr.helper.sr.model.b bVar2 = new com.tencent.mobileqq.opr.helper.sr.model.b(true, System.currentTimeMillis() - currentTimeMillis, new com.tencent.mobileqq.opr.helper.sr.model.c(oldPhotoRepairHelper.initStatus, oldPhotoRepairHelper.modelStatus));
        if (qQOpr != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size r(Bitmap bitmap, String str) {
        String d16 = INSTANCE.d(str);
        String str2 = ((Object) f257001o) + '/' + d16 + "_temp.jpg";
        if (com.tencent.mobileqq.opr.utils.a.c(bitmap, str2, null, 2, null)) {
            this.fileCache.g(str2, d16);
            return com.tencent.mobileqq.opr.utils.a.e(bitmap);
        }
        OprLogger.e("[opr]OldPhotoRepairHelper", Intrinsics.stringPlus("save2Cache failed, key=", str));
        return null;
    }

    public static /* synthetic */ Object u(OldPhotoRepairHelper oldPhotoRepairHelper, String str, ImageInfo imageInfo, Bitmap bitmap, Function6 function6, Continuation continuation, int i3, Object obj) {
        Bitmap bitmap2;
        Function6 function62;
        if ((i3 & 4) != 0) {
            bitmap2 = null;
        } else {
            bitmap2 = bitmap;
        }
        if ((i3 & 8) != 0) {
            function62 = null;
        } else {
            function62 = function6;
        }
        return oldPhotoRepairHelper.t(str, imageInfo, bitmap2, function62, continuation);
    }

    public final synchronized void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Job job = this.initJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.initJob = null;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new OldPhotoRepairHelper$destroy$1(this, null), 3, null);
    }

    @Nullable
    public final String n(@NotNull String key) {
        boolean z16;
        File c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (c16 = this.fileCache.c(INSTANCE.d(key))) == null) {
            return null;
        }
        return c16.getAbsolutePath();
    }

    @Nullable
    public final Function2<com.tencent.qne.util.d, Continuation<? super Unit>, Object> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.initStatusListener;
    }

    @Nullable
    public final Function2<a, Continuation<? super Unit>, Object> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Function2) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.modelStatusListener;
    }

    public final synchronized void s() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.initJob != null) {
            return;
        }
        Context context = this.contextRef.get();
        if (context != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new OldPhotoRepairHelper$setup$1(context, this, null), 3, null);
            this.initJob = launch$default;
        }
    }

    @Nullable
    public final Object t(@NotNull String str, @NotNull final ImageInfo imageInfo, @Nullable final Bitmap bitmap, @Nullable Function6<? super TaskErrorCode, ? super TaskExtendResult, ? super byte[], ? super Integer, ? super Integer, ? super String, Unit> function6, @NotNull Continuation<? super com.tencent.mobileqq.opr.helper.repair.model.a> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, this, str, imageInfo, bitmap, function6, continuation);
        }
        String n3 = n(str);
        if (n3 != null) {
            return new com.tencent.mobileqq.opr.helper.repair.model.a(OprStatus.SuccessFromCache, n3, null, new e(Boxing.boxBoolean(true), null, null, null, null, 30, null), 0, 20, null);
        }
        return q(str, imageInfo, function6, new Function0<Bitmap>(bitmap, imageInfo) { // from class: com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper$startEnhancement$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bitmap $bitmap;
            final /* synthetic */ ImageInfo $imageInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$bitmap = bitmap;
                this.$imageInfo = imageInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) bitmap, (Object) imageInfo);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Bitmap invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Bitmap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                OprLogger.i("[opr]OldPhotoRepairHelper", "realStartEnhancement get bitmap, bitmap=" + this.$bitmap + ", imageInfo=" + this.$imageInfo);
                Bitmap bitmap2 = this.$bitmap;
                if (bitmap2 != null) {
                    return bitmap2;
                }
                if (com.tencent.qne.util.a.c(this.$imageInfo.getLocalPath())) {
                    String localPath = this.$imageInfo.getLocalPath();
                    Bitmap g16 = localPath == null ? null : com.tencent.mobileqq.opr.utils.a.g(localPath, null, 1, null);
                    OprLogger.e("[opr]OldPhotoRepairHelper", Intrinsics.stringPlus("realStartEnhancement load bitmap by localPath, bitmap=", this.$bitmap));
                    return g16;
                }
                OprLogger.e("[opr]OldPhotoRepairHelper", Intrinsics.stringPlus("realStartEnhancement failed file not exist, imageInfo=", this.$imageInfo));
                return null;
            }
        }, continuation);
    }
}
