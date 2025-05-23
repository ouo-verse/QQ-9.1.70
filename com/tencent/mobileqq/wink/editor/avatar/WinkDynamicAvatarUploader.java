package com.tencent.mobileqq.wink.editor.avatar;

import android.annotation.SuppressLint;
import android.os.Message;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.requests.QFSSetQQProfilePictureFeedRequest;
import com.tencent.mobileqq.qqcamera.api.ICameraUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarUploader;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudDatacard$SetQQProfilePictureFeedReq;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001\u0002\u0018\u0000 52\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J;\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0007R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001dR\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001dR\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarUploader;", "", "com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarUploader$b", "r", "()Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarUploader$b;", "Lcom/tencent/mobileqq/transfile/FileMsg;", "file", "", "t", "msg", ReportConstant.COSTREPORT_PREFIX, "", "filePath", "", "isSyncQZone", "useApngAvatar", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "feedId", "feedOwner", "", "feedTime", "y", "staticFramePath", "apngPath", HippyTKDListViewAdapter.X, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "u", "a", "Ljava/lang/String;", "b", "c", "Z", "isUploadingStatic", "d", "isUploadingApng", "Lkotlinx/coroutines/CancellableContinuation;", "e", "Lkotlinx/coroutines/CancellableContinuation;", "cancelableContinuation", "f", "g", tl.h.F, "J", "i", "dynamicPfpFileId", "j", "staticPfpFileId", "k", "Lcom/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarUploader$b;", "updateAvatarHandler", "<init>", "()V", "l", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkDynamicAvatarUploader {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isUploadingStatic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isUploadingApng;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CancellableContinuation<? super Boolean> cancelableContinuation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long feedTime;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String staticFramePath = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String apngPath = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String feedId = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String feedOwner = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dynamicPfpFileId = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String staticPfpFileId = "";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b updateAvatarHandler = r();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/avatar/WinkDynamicAvatarUploader$b", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes21.dex */
    public static final class b extends TransProcessorHandler {
        b() {
            try {
                addFilter(((ICameraUtils) QRoute.api(ICameraUtils.class)).getNearbyPeoplePhotoUploadProcessorClass());
            } catch (Exception e16) {
                w53.b.d("WinkDynamicAvatarUploader", "add filter failed", e16);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            FileMsg fileMsg;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            Object obj = msg2.obj;
            if (obj instanceof FileMsg) {
                fileMsg = (FileMsg) obj;
            } else {
                fileMsg = null;
            }
            if (fileMsg != null && fileMsg.commandId == 90) {
                switch (msg2.what) {
                    case 1003:
                        WinkDynamicAvatarUploader.this.t(fileMsg);
                        return;
                    case 1004:
                    case 1005:
                        WinkDynamicAvatarUploader.this.s(fileMsg);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private final String q(boolean useApngAvatar) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        int i16 = 0;
        if (useApngAvatar) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        try {
            jSONObject.put("isFromXSJ", i3);
            if (useApngAvatar) {
                i16 = 1;
            }
            jSONObject.put("NoPush", i16);
        } catch (JSONException e16) {
            QLog.e("WinkDynamicAvatarUploader", 1, "buildUploadAvatarExtJsonInfo ", e16);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b r() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(FileMsg msg2) {
        this.isUploadingStatic = false;
        this.isUploadingApng = false;
        ((ITransFileController) com.tencent.mobileqq.wink.b.a().getRuntimeService(ITransFileController.class, "all")).removeHandle(this.updateAvatarHandler);
        CancellableContinuation<? super Boolean> cancellableContinuation = this.cancelableContinuation;
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_UPLOAD_FAILED))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(FileMsg file) {
        boolean z16 = this.isUploadingStatic;
        if (z16 && !this.isUploadingApng) {
            this.isUploadingStatic = false;
            this.isUploadingApng = true;
            String str = file.msgImageData;
            Intrinsics.checkNotNullExpressionValue(str, "file.msgImageData");
            this.staticPfpFileId = str;
            w(this, this.apngPath, false, true, 2, null);
            return;
        }
        if (this.isUploadingApng && !z16) {
            ar arVar = ar.f326685a;
            long f16 = arVar.f(QQWinkConstants.XSJ_SET_DYNAMIC_AVATAR_COUNT, 0L) + 1;
            w53.b.c("WinkDynamicAvatarUploader", "update count = " + f16);
            arVar.p(QQWinkConstants.XSJ_SET_DYNAMIC_AVATAR_COUNT, f16);
            ((ITransFileController) com.tencent.mobileqq.wink.b.a().getRuntimeService(ITransFileController.class, "all")).removeHandle(this.updateAvatarHandler);
            String str2 = file.msgImageData;
            Intrinsics.checkNotNullExpressionValue(str2, "file.msgImageData");
            this.dynamicPfpFileId = str2;
            y(this.feedId, this.feedOwner, this.feedTime);
            CancellableContinuation<? super Boolean> cancellableContinuation = this.cancelableContinuation;
            if (cancellableContinuation != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            return;
        }
        ((ITransFileController) com.tencent.mobileqq.wink.b.a().getRuntimeService(ITransFileController.class, "all")).removeHandle(this.updateAvatarHandler);
        CancellableContinuation<? super Boolean> cancellableContinuation2 = this.cancelableContinuation;
        if (cancellableContinuation2 != null) {
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }
    }

    private final void v(String filePath, boolean isSyncQZone, boolean useApngAvatar) {
        byte b16;
        TransferRequest transferRequest = new TransferRequest();
        boolean z16 = true;
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = filePath;
        transferRequest.mFileType = 22;
        transferRequest.mUniseq = System.currentTimeMillis();
        pu.a aVar = new pu.a();
        aVar.c(isSyncQZone ? (byte) 1 : (byte) 0);
        if (useApngAvatar) {
            b16 = 5;
        } else {
            b16 = 0;
        }
        aVar.c(b16);
        aVar.c((byte) 0);
        aVar.c((byte) 0);
        aVar.c((byte) 0);
        aVar.c((byte) 0);
        String q16 = q(useApngAvatar);
        Charset charset = Charsets.UTF_8;
        byte[] bytes = q16.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        if (bytes != null) {
            int length = bytes.length;
            if (1 > length || length >= 501) {
                z16 = false;
            }
            if (z16) {
                int length2 = bytes.length;
                QLog.i("WinkDynamicAvatarUploader", 2, "requestUploadAvatar extInfoJson[" + length2 + "] json: " + q16);
                aVar.c((byte) ((length2 >> 8) & 255));
                aVar.c((byte) (length2 & 255));
                byte[] bytes2 = q16.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                for (byte b17 : bytes2) {
                    aVar.c(b17);
                }
            }
        }
        transferRequest.mExtentionInfo = aVar.a();
        IRuntimeService runtimeService = com.tencent.mobileqq.wink.b.a().getRuntimeService(ITransFileController.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026ava, ProcessConstant.ALL)");
        ((ITransFileController) runtimeService).transferAsync(transferRequest);
    }

    static /* synthetic */ void w(WinkDynamicAvatarUploader winkDynamicAvatarUploader, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        winkDynamicAvatarUploader.v(str, z16, z17);
    }

    private final void y(String feedId, String feedOwner, long feedTime) {
        FeedCloudDatacard$SetQQProfilePictureFeedReq feedCloudDatacard$SetQQProfilePictureFeedReq = new FeedCloudDatacard$SetQQProfilePictureFeedReq();
        feedCloudDatacard$SetQQProfilePictureFeedReq.feed_id.set(feedId);
        feedCloudDatacard$SetQQProfilePictureFeedReq.feed_owner.set(feedOwner);
        feedCloudDatacard$SetQQProfilePictureFeedReq.feed_time.set(feedTime);
        feedCloudDatacard$SetQQProfilePictureFeedReq.dynamic_pfp_file_id.set(this.dynamicPfpFileId);
        feedCloudDatacard$SetQQProfilePictureFeedReq.static_pfp_file_id.set(this.staticPfpFileId);
        QLog.d("WinkDynamicAvatarUploader", 2, "uploadToQCircleBackEnd feed_id = " + feedId + ",feedOwner = " + feedOwner + ",feedTime = " + feedTime + ",dynamic_pfp_file_id= " + this.dynamicPfpFileId + ", static_pfp_file_id = " + this.staticPfpFileId);
        VSNetworkHelper.getInstance().sendRequest(new QFSSetQQProfilePictureFeedRequest(feedCloudDatacard$SetQQProfilePictureFeedReq), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.editor.avatar.l
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                WinkDynamicAvatarUploader.z(baseRequest, z16, j3, str, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        QLog.d("WinkDynamicAvatarUploader", 2, "uploadToQCircleBackEnd isSuccess = " + z16 + ",retCode = " + j3 + ",errMsg= " + str + ", t = " + obj);
    }

    public final void u() {
        ((ITransFileController) com.tencent.mobileqq.wink.b.a().getRuntimeService(ITransFileController.class, "all")).removeHandle(this.updateAvatarHandler);
    }

    @Nullable
    public final Object x(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j3, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (!this.isUploadingStatic && !this.isUploadingApng) {
            this.feedId = str3;
            this.feedOwner = str4;
            this.feedTime = j3;
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarUploader$uploadDynamicAvatar$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    WinkDynamicAvatarUploader.b r16;
                    ((ITransFileController) com.tencent.mobileqq.wink.b.a().getRuntimeService(ITransFileController.class, "all")).removeHandle(WinkDynamicAvatarUploader.this.updateAvatarHandler);
                    WinkDynamicAvatarUploader winkDynamicAvatarUploader = WinkDynamicAvatarUploader.this;
                    r16 = winkDynamicAvatarUploader.r();
                    winkDynamicAvatarUploader.updateAvatarHandler = r16;
                    WinkDynamicAvatarUploader.this.isUploadingStatic = false;
                    WinkDynamicAvatarUploader.this.isUploadingApng = false;
                }
            });
            ((ITransFileController) com.tencent.mobileqq.wink.b.a().getRuntimeService(ITransFileController.class, "all")).addHandle(this.updateAvatarHandler);
            this.staticFramePath = str;
            this.apngPath = str2;
            this.cancelableContinuation = cancellableContinuationImpl;
            this.isUploadingStatic = true;
            this.isUploadingApng = false;
            w(this, str, false, false, 2, null);
        } else {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("already running"))));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
