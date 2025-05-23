package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.msglist.holder.component.video.VideoSendTask;
import com.tencent.mobileqq.aio.msglist.holder.component.video.u;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.shortvideo.api.IVideoCompress;
import com.tencent.qqnt.shortvideo.api.IVideoEncode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 C2\u00020\u0001:\u00036DEB\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u001e2\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020 H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0002H\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001cH\u0002J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J$\u0010.\u001a\u00020\u00022\u001a\u0010-\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010+j\n\u0012\u0004\u0012\u00020 \u0018\u0001`,H\u0002J\b\u0010/\u001a\u00020\tH\u0002J \u00102\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000100J\u000e\u00103\u001a\u00020\t2\u0006\u0010!\u001a\u00020 J\u000e\u00104\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0018\u00106\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u00105\u001a\u00020\tH\u0016R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00108R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\f0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020>0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010<\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask$b;", "", "r", "", "directory", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "sendStatus", "", "D", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask;", "task", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendStatus;", "B", "L", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "userData", "tag", "y", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "resend", "Lkotlin/Pair;", "v", "", "msgId", "K", "w", "H", "I", "msg", "G", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "J", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "msgIdList", UserInfo.SEX_FEMALE, "u", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/aa;", "listener", "N", "E", "o", "success", "a", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "sendingTaskMap", "Ljava/lang/Runnable;", "c", "delayRemovingJobs", "<init>", "()V", "d", "LongViewCompressListener", "ShortVideoEncodeListener", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOVideoSendingManager implements VideoSendTask.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<AIOVideoSendingManager> f192174e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, VideoSendTask> sendingTaskMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, Runnable> delayRemovingJobs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$1", f = "AIOVideoSendingManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOVideoSendingManager.this, (Object) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
            }
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    AIOVideoSendingManager.this.H();
                    AIOVideoSendingManager.this.I();
                    AIOVideoSendingManager.this.J();
                    AIOVideoSendingManager.this.r();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager$LongViewCompressListener;", "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;", "Lcy3/a;", QCircleScheme.AttrDetail.VIDEO_INFO, "", "e", "", "userData", "", "isNeedCompress", "c", "", "percent", "d", "a", "", "finishCode", "b", "", "Ljava/lang/String;", "getOriginVideoPath", "()Ljava/lang/String;", "originVideoPath", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager;Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class LongViewCompressListener implements IVideoCompress.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String originVideoPath;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOVideoSendingManager f192179b;

        public LongViewCompressListener(@NotNull AIOVideoSendingManager aIOVideoSendingManager, String originVideoPath) {
            Intrinsics.checkNotNullParameter(originVideoPath, "originVideoPath");
            this.f192179b = aIOVideoSendingManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOVideoSendingManager, (Object) originVideoPath);
            } else {
                this.originVideoPath = originVideoPath;
            }
        }

        private final void e(cy3.a videoInfo) {
            String path;
            if (videoInfo != null && (path = videoInfo.getPath()) != null) {
                AIOVideoSendingManager aIOVideoSendingManager = this.f192179b;
                if (!Intrinsics.areEqual(path, this.originVideoPath)) {
                    BuildersKt__Builders_commonKt.launch$default(aIOVideoSendingManager.scope, Dispatchers.getIO(), null, new AIOVideoSendingManager$LongViewCompressListener$deleteCompressedFile$1$1(path, null), 2, null);
                }
            }
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        public boolean a(@Nullable Object userData, @Nullable cy3.a videoInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                VideoSendTask y16 = this.f192179b.y(userData, "afterCompressing");
                if (y16 == null) {
                    return false;
                }
                ShortVideoMsgItem h16 = y16.h();
                if (videoInfo == null) {
                    QLog.i("AIOVideoSendingManager", 1, "[afterCompressing] video info is null");
                    return false;
                }
                long h17 = com.tencent.qqnt.aio.utils.m.h(videoInfo.getPath());
                if (h17 > ShortVideoConstants.VIDEO_SIZE_LIMIT) {
                    QLog.i("AIOVideoSendingManager", 1, "file too large, msgId=" + y16.g() + " fileSize=" + h17);
                    y16.y(true);
                    return false;
                }
                h16.E2().originVideoMd5 = com.tencent.qqnt.util.file.b.f362981a.b(this.originVideoPath);
                MsgElement b16 = c.f192224a.b(h16.getMsgRecord());
                if (b16 != null) {
                    k kVar = k.f192240a;
                    String path = videoInfo.getPath();
                    Intrinsics.checkNotNull(path);
                    if (!kVar.g(b16, path, !Intrinsics.areEqual(videoInfo.getPath(), this.originVideoPath))) {
                        return false;
                    }
                    kVar.f(b16);
                    h16.p2();
                    h16.q2();
                }
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, userData, (Object) videoInfo)).booleanValue();
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        @MainThread
        public void b(@Nullable Object userData, int finishCode, @Nullable cy3.a videoInfo) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                VideoSendTask y16 = this.f192179b.y(userData, "onFinish");
                if (y16 == null) {
                    return;
                }
                ShortVideoMsgItem h16 = y16.h();
                QLog.i("AIOVideoSendingManager", 1, "[onFinish] msgRecord msgId=" + h16.getMsgId() + ", finishCode=" + finishCode);
                AIOVideoSendingManager.INSTANCE.c().removeCompressTask(h16.getMsgId());
                e(videoInfo);
                if (finishCode == 1) {
                    Integer num = null;
                    if (videoInfo != null) {
                        str = videoInfo.getPath();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        VideoElement E2 = h16.E2();
                        u.Companion companion = u.INSTANCE;
                        if (videoInfo != null) {
                            num = Integer.valueOf(videoInfo.getVideoCodecFormatType());
                        }
                        E2.sourceVideoCodecFormat = companion.b(num);
                        y16.p();
                        y16.u();
                        return;
                    }
                }
                QLog.w("AIOVideoSendingManager", 1, "[onFinish] compress failed, msgId=" + h16.getMsgId() + ", finishCode=" + finishCode);
                if (finishCode == 3) {
                    y16.o(VideoErrorCode.CancelCompress);
                    return;
                } else if (y16.k()) {
                    y16.o(VideoErrorCode.VideoTooLarge);
                    return;
                } else {
                    y16.o(VideoErrorCode.FailCompress);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 6, this, userData, Integer.valueOf(finishCode), videoInfo);
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        public void c(@Nullable final Object userData, final boolean isNeedCompress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, userData, Boolean.valueOf(isNeedCompress));
                return;
            }
            k kVar = k.f192240a;
            final AIOVideoSendingManager aIOVideoSendingManager = this.f192179b;
            kVar.l(new Function0<Unit>(userData, isNeedCompress) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$LongViewCompressListener$onLaunch$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isNeedCompress;
                final /* synthetic */ Object $userData;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$userData = userData;
                    this.$isNeedCompress = isNeedCompress;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOVideoSendingManager.this, userData, Boolean.valueOf(isNeedCompress));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    VideoSendTask y16 = AIOVideoSendingManager.this.y(this.$userData, "onLaunch");
                    if (y16 == null) {
                        return;
                    }
                    QLog.i("AIOVideoSendingManager", 1, "onLaunch, msgId=" + y16.g() + " isNeedCompress=" + this.$isNeedCompress);
                    y16.r();
                }
            });
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        public void d(@Nullable final Object userData, final float percent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, userData, Float.valueOf(percent));
                return;
            }
            k kVar = k.f192240a;
            final AIOVideoSendingManager aIOVideoSendingManager = this.f192179b;
            kVar.l(new Function0<Unit>(userData, percent) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$LongViewCompressListener$onUpdate$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ float $percent;
                final /* synthetic */ Object $userData;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$userData = userData;
                    this.$percent = percent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AIOVideoSendingManager.this, userData, Float.valueOf(percent));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    VideoSendTask y16 = AIOVideoSendingManager.this.y(this.$userData, "onUpdate");
                    if (y16 == null) {
                        return;
                    }
                    y16.n((int) (100 * this.$percent));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager$ShortVideoEncodeListener;", "Lcom/tencent/qqnt/shortvideo/api/IVideoEncode$a;", "", "errorCode", "", "onError", "", "videoPath", "videoCodecFormatType", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask;", "b", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask;", "task", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager;Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class ShortVideoEncodeListener implements IVideoEncode.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final VideoSendTask task;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOVideoSendingManager f192181b;

        public ShortVideoEncodeListener(@NotNull AIOVideoSendingManager aIOVideoSendingManager, VideoSendTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.f192181b = aIOVideoSendingManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOVideoSendingManager, (Object) task);
            } else {
                this.task = task;
            }
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode.a
        public void a(@Nullable String videoPath, int videoCodecFormatType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoPath, videoCodecFormatType);
                return;
            }
            QLog.i("AIOVideoSendingManager", 1, "[handleSendShortVideo] encode success, msgId=" + this.task.g() + " path=" + videoPath + " videoCodecFormatType=" + videoCodecFormatType);
            BuildersKt__Builders_commonKt.launch$default(this.f192181b.scope, Dispatchers.getIO(), null, new AIOVideoSendingManager$ShortVideoEncodeListener$onSuccess$1(this.task.h(), videoCodecFormatType, videoPath, this, null), 2, null);
        }

        @NotNull
        public final VideoSendTask b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (VideoSendTask) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.task;
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode.a
        public void onError(int errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode);
                return;
            }
            QLog.w("AIOVideoSendingManager", 1, "[handleSendShortVideo] encode error, msgId=" + this.task.g() + " code=" + errorCode);
            BuildersKt__Builders_commonKt.launch$default(this.f192181b.scope, Dispatchers.getIO(), null, new AIOVideoSendingManager$ShortVideoEncodeListener$onError$1(this.task.h(), this, null), 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R!\u0010\r\u001a\u00020\u00068FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager$a;", "", "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress;", "c", "Lcom/tencent/qqnt/shortvideo/api/IVideoEncode;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager;", "instance$delegate", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IVideoCompress c() {
            QRouteApi api = QRoute.api(IVideoCompress.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVideoCompress::class.java)");
            return (IVideoCompress) api;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IVideoEncode d() {
            return (IVideoEncode) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVideoEncode.class);
        }

        @NotNull
        public final AIOVideoSendingManager e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOVideoSendingManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (AIOVideoSendingManager) AIOVideoSendingManager.f192174e.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192182a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63925);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[VideoSendStatus.values().length];
            try {
                iArr[VideoSendStatus.Init.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoSendStatus.FinishCompressing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoSendStatus.Failed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoSendStatus.Success.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f192182a = iArr;
        }
    }

    static {
        Lazy<AIOVideoSendingManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOVideoSendingManager$Companion$instance$2.INSTANCE);
        f192174e = lazy;
    }

    public /* synthetic */ AIOVideoSendingManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
    }

    private final void A(VideoSendTask task) {
        ShortVideoMsgItem h16 = task.h();
        if (QLog.isColorLevel()) {
            QLog.i("AIOVideoSendingManager", 2, "[handleSendShortVideo] msgId=" + h16.getMsgId());
        }
        task.r();
        task.n(100);
        MsgRecord msgRecord = h16.getMsgRecord();
        IVideoEncode d16 = INSTANCE.d();
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        d16.encodeVideo(context, msgRecord.msgId, h16.D2(), h16.C2(), h16.I2(), new ShortVideoEncodeListener(this, task));
    }

    private final VideoSendStatus B(VideoSendTask task) {
        if (C(task.i())) {
            com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[needSendVideo] send complete, view=" + hashCode() + ", msgId=" + task.g());
            return VideoSendStatus.Success;
        }
        if (!D(task.i())) {
            com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[needSendVideo] msg is not in sending status, msgId=" + task.g() + " sendStatus=" + task.i());
            return VideoSendStatus.Failed;
        }
        if (task.h().M2()) {
            com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[needSendVideo] message is sending, do nothing, msgId=" + task.g() + ", msgSendStatus=" + task.i());
            return VideoSendStatus.FinishCompressing;
        }
        if (!task.h().L2()) {
            com.tencent.qqnt.aio.utils.q.e("AIOVideoSendingManager", "[needSendVideo] video send info is not valid, msgId=" + task.g());
            return VideoSendStatus.Failed;
        }
        com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[needSendVideo] need compress and send video, statusInMsg=" + task.i());
        return VideoSendStatus.Init;
    }

    private final boolean C(int sendStatus) {
        if (sendStatus != 2 && sendStatus != 3) {
            return false;
        }
        return true;
    }

    private final boolean D(int sendStatus) {
        if (sendStatus == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(ArrayList<Long> msgIdList) {
        if (msgIdList == null || u()) {
            return;
        }
        Iterator<Long> it = msgIdList.iterator();
        while (it.hasNext()) {
            Long msgId = it.next();
            Intrinsics.checkNotNullExpressionValue(msgId, "msgId");
            if (E(msgId.longValue())) {
                QLog.i("AIOVideoSendingManager", 1, "[onMsgDelete] cancelSending:" + msgId);
                o(msgId.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(ShortVideoMsgItem msg2) {
        VideoSendTask x16 = x(msg2, "handleMsgStatusChanged");
        if (x16 == null) {
            return;
        }
        QLog.i("AIOVideoSendingManager", 1, "[onMsgStatusChanged] msgId=" + msg2.getMsgId() + " status=" + x16.i() + "->" + msg2.getMsgRecord().sendStatus);
        x16.w(msg2.getMsgRecord().sendStatus);
        if (msg2.getMsgRecord().sendStatus == 0) {
            x16.o(VideoErrorCode.FailSendMsg);
            return;
        }
        if (msg2.getMsgRecord().sendStatus != 2 && msg2.getMsgRecord().sendStatus != 3) {
            if (msg2.getMsgRecord().sendStatus == 1) {
                QLog.i("AIOVideoSendingManager", 1, "msg is sending, msgId=" + msg2.getMsgId() + ", taskStatus=" + x16.j());
                return;
            }
            return;
        }
        QLog.i("AIOVideoSendingManager", 1, "msg is success, msgId=" + msg2.getMsgId() + ", taskStatus=" + x16.j());
        String U2 = msg2.U2();
        if (U2 == null) {
            U2 = "";
        }
        x16.s(U2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.v(), new AIOVideoSendingManager$registerMsgSendNotification$1(this, null)), Dispatchers.getIO()), this.scope);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerOnMsgDeleteNotificationFlow(), new AIOVideoSendingManager$registerMsgSendNotification$2(this, null)), Dispatchers.getIO()), this.scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.r(), new AIOVideoSendingManager$registerMsgStatusNotification$1(this, null)), Dispatchers.getMain()), this.scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        k.f192240a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$registerRichMediaTransferNotification$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoSendingManager$registerRichMediaTransferNotification$1$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaProgerssUpdate", "onRichMediaUploadComplete", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements IKernelMsgListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AIOVideoSendingManager f192183d;

                a(AIOVideoSendingManager aIOVideoSendingManager) {
                    this.f192183d = aIOVideoSendingManager;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOVideoSendingManager);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
                    ax.a(this, msgRecord);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
                    ax.b(this, hashMap);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
                    ax.c(this, customWithdrawConfig);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
                    ax.d(this, contact, arrayList, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
                    ax.e(this, emojiNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
                    ax.f(this, emojiResourceInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
                    ax.g(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
                    ax.h(this, i3, str, i16, recvdOrder, msgRecord);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
                    ax.i(this, groupItem);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
                    ax.j(this, groupFileListResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
                    ax.k(this, groupItem);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
                    ax.l(this, groupFileListResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
                    ax.m(this, downloadRelateEmojiResultInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
                    ax.n(this, hitRelatedEmojiWordsResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
                    ax.o(this, relatedWordEmojiInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
                    ax.p(this, importOldDbMsgNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
                    ax.q(this, inputStatusInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
                    ax.r(this, kickedInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onLineDev(ArrayList arrayList) {
                    ax.s(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onLogLevelChanged(long j3) {
                    ax.t(this, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
                    ax.u(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
                    ax.v(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
                    ax.w(this, contact, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
                    ax.x(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
                    ax.y(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
                    ax.z(this, i3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
                    ax.A(this, i3, str, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
                    ax.B(this, msgRecord);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
                    ax.C(this, msgSetting);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
                    ax.D(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
                    ax.E(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtMsgSyncContactUnread() {
                    ax.F(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtMsgSyncEnd() {
                    ax.G(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtMsgSyncStart() {
                    ax.H(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
                    ax.I(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
                    ax.J(this, j3, contact, i3, i16, str, bArr);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
                    ax.K(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
                    ax.L(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRedTouchChanged() {
                    ax.M(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
                    ax.N(this, fileTransNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public void onRichMediaProgerssUpdate(@NotNull FileTransNotifyInfo notifyInfo) {
                    VideoSendTask w3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) notifyInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
                    w3 = this.f192183d.w(notifyInfo.msgId, "onRichMediaProgressUpdate");
                    if (w3 == null) {
                        return;
                    }
                    w3.t((int) ((100 * notifyInfo.fileProgress) / notifyInfo.totalSize));
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public void onRichMediaUploadComplete(@NotNull FileTransNotifyInfo notifyInfo) {
                    VideoSendTask w3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) notifyInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
                    w3 = this.f192183d.w(notifyInfo.msgId, "onRichMediaUploadComplete");
                    if (w3 == null) {
                        return;
                    }
                    if (notifyInfo.trasferStatus == 4) {
                        w3.q();
                        return;
                    }
                    QLog.i("AIOVideoSendingManager", 1, "[registerRichMediaTransferNotification] msgId=" + w3.g() + " msgStatus=" + w3.i() + " transferStatus=" + notifyInfo.trasferStatus + ")");
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
                    ax.Q(this, searchGroupFileResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
                    ax.R(this, j3, contact, i3, str);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
                    ax.S(this, i3, j3, j16, z16, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
                    ax.T(this, tempChatInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
                    ax.U(this, z16);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
                    ax.V(this, z16);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
                    ax.W(this, queryUserSecQualityRsp);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
                    ax.X(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
                    ax.Y(this, i3, j3, str);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
                    ax.Z(this, i3, j3, str);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOVideoSendingManager.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.addMsgListener(new a(AIOVideoSendingManager.this));
                }
            }
        });
    }

    private final VideoSendTask K(long msgId) {
        VideoSendTask remove;
        QLog.i("AIOVideoSendingManager", 1, "[removeTask] msgId=" + msgId);
        synchronized (this.sendingTaskMap) {
            remove = this.sendingTaskMap.remove(Long.valueOf(msgId));
        }
        return remove;
    }

    private final boolean L(VideoSendTask task) {
        task.x(B(task));
        task.m();
        int i3 = b.f192182a[task.j().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[runTask] invalid status, remove task, msgId=" + task.g() + " status=" + task.j());
                    K(task.g());
                    return false;
                }
                com.tencent.qqnt.aio.utils.q.a("AIOVideoSendingManager", "[runTask] do nothing, msgId=" + task.g() + " status=" + task.j());
                return false;
            }
            com.tencent.qqnt.aio.utils.q.a("AIOVideoSendingManager", "[runTask] send message, msgId=" + task.g() + " status=" + task.j());
            task.u();
            return true;
        }
        com.tencent.qqnt.aio.utils.q.a("AIOVideoSendingManager", "[runTask] compress video, msgId=" + task.g() + " status=" + task.j());
        M(task);
        return true;
    }

    private final void M(VideoSendTask task) {
        int i3 = task.h().E2().busiType;
        if (i3 != 0) {
            if (i3 != 1) {
                QLog.i("AIOVideoSendingManager", 1, "[processVideoBeforeSendMsg] unknown video type, type=" + i3);
                return;
            }
            A(task);
            return;
        }
        z(task);
    }

    private final void n(long msgId) {
        Runnable remove = this.delayRemovingJobs.remove(Long.valueOf(msgId));
        if (remove != null) {
            ThreadManagerV2.removeJob(remove, 16);
        }
    }

    private final void p(VideoSendTask task) {
        ShortVideoMsgItem h16 = task.h();
        INSTANCE.c().compressVideo(h16.getMsgRecord().msgId, h16.I2(), h16.z2().c().a(), Long.valueOf(h16.getMsgId()), new LongViewCompressListener(this, h16.I2()));
    }

    private final void q(String directory) {
        try {
            File file = new File(directory);
            file.mkdirs();
            if (!file.isDirectory()) {
                QLog.i("AIOVideoSendingManager", 1, "[createDirectory] not exist, path=" + directory);
            }
        } catch (Exception e16) {
            QLog.i("AIOVideoSendingManager", 1, "[createDirectory] path=" + directory + " exception=" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        String parent;
        File externalFilesDir = BaseApplication.context.getExternalFilesDir(null);
        if (externalFilesDir != null && (parent = externalFilesDir.getParent()) != null) {
            String str = parent + "/Tencent/MobileQQ/shortvideo/Temp";
            if (str != null) {
                q(str);
            }
        }
    }

    private final void s(final long msgId) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOVideoSendingManager", 2, "[delayRemoveTask] msgId=" + msgId);
        }
        n(msgId);
        ConcurrentHashMap<Long, Runnable> concurrentHashMap = this.delayRemovingJobs;
        Long valueOf = Long.valueOf(msgId);
        Runnable executeDelay = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.l
            @Override // java.lang.Runnable
            public final void run() {
                AIOVideoSendingManager.t(AIOVideoSendingManager.this, msgId);
            }
        }, 16, null, false, 10000L);
        Intrinsics.checkNotNullExpressionValue(executeDelay, "executeDelay({\n         \u2026MAL, null, false, 10_000)");
        concurrentHashMap.put(valueOf, executeDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AIOVideoSendingManager this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.delayRemovingJobs.remove(Long.valueOf(j3));
        this$0.K(j3);
    }

    private final boolean u() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("106195", false);
    }

    private final Pair<VideoSendTask, Boolean> v(ShortVideoMsgItem msgItem, boolean resend) {
        long msgId = msgItem.getMsgId();
        synchronized (this.sendingTaskMap) {
            VideoSendTask it = this.sendingTaskMap.get(Long.valueOf(msgId));
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                return new Pair<>(it, Boolean.FALSE);
            }
            VideoSendTask videoSendTask = new VideoSendTask(msgItem, resend, this);
            this.sendingTaskMap.put(Long.valueOf(msgId), videoSendTask);
            return new Pair<>(videoSendTask, Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoSendTask w(long msgId, String tag) {
        synchronized (this.sendingTaskMap) {
            VideoSendTask videoSendTask = this.sendingTaskMap.get(Long.valueOf(msgId));
            if (videoSendTask != null) {
                return videoSendTask;
            }
            QLog.w("AIOVideoSendingManager", 1, "[" + tag + "] key not exists, msgId=" + msgId);
            return null;
        }
    }

    private final VideoSendTask x(AIOMsgItem msgItem, String tag) {
        return w(msgItem.getMsgId(), tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoSendTask y(Object userData, String tag) {
        Intrinsics.checkNotNull(userData, "null cannot be cast to non-null type kotlin.Long");
        return w(((Long) userData).longValue(), tag);
    }

    private final void z(VideoSendTask task) {
        ShortVideoMsgItem h16 = task.h();
        if (!INSTANCE.c().findCompressTask(h16.getMsgId())) {
            if (h16.M2()) {
                com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[handleSendLongVideo] compress already done, view=" + hashCode() + ", msgId=" + h16.getMsgId());
                task.u();
                return;
            }
            com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[handleSendLongVideo] start compressing, view=" + hashCode() + ", msgId=" + h16.getMsgId());
            p(task);
            return;
        }
        com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[handleSendLongVideo] compress task found, view=" + hashCode() + ", msgId=" + h16.getMsgId());
    }

    public final boolean E(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, msgId)).booleanValue();
        }
        if (w(msgId, "isMsgSending") == null) {
            return false;
        }
        return !r4.l();
    }

    public final boolean N(@NotNull ShortVideoMsgItem msgItem, boolean resend, @Nullable aa listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, msgItem, Boolean.valueOf(resend), listener)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QLog.i("AIOVideoSendingManager", 1, "[startSendingVideo] msgId=" + msgItem.getMsgId() + " resend=" + resend);
        if (msgItem.K0() && msgItem.R2()) {
            Pair<VideoSendTask, Boolean> v3 = v(msgItem, resend);
            VideoSendTask component1 = v3.component1();
            boolean booleanValue = v3.component2().booleanValue();
            if (listener != null) {
                component1.v(listener);
            }
            n(component1.g());
            if (!booleanValue && !component1.l()) {
                QLog.i("AIOVideoSendingManager", 1, "[startSendingVideo] task exists, msgId=" + msgItem.getMsgId() + " resend=" + resend);
                if (component1.f() != null) {
                    component1.m();
                }
                return true;
            }
            if (resend) {
                component1.w(1);
            }
            if (!L(component1)) {
                com.tencent.qqnt.aio.utils.q.d("AIOVideoSendingManager", "[startSendingVideo] nothing to do, msgId=" + msgItem.getMsgId() + " taskStatus=" + component1.j() + " msgStatus=" + component1.i());
            }
            return true;
        }
        QLog.i("AIOVideoSendingManager", 1, "[startSendingVideo] send info not valid, should be forwarding msg, msgId=" + msgItem.getMsgId() + " resend=" + resend);
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.VideoSendTask.b
    public void a(long msgId, boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(msgId), Boolean.valueOf(success));
        } else {
            s(msgId);
        }
    }

    public final void o(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, msgId);
            return;
        }
        final VideoSendTask w3 = w(msgId, "cancelSending");
        if (w3 == null) {
            return;
        }
        if (w3.l()) {
            QLog.i("AIOVideoSendingManager", 1, "[cancelSending] already finished, msgId=" + w3.g());
            return;
        }
        QLog.i("AIOVideoSendingManager", 1, "[cancelSending] cancel, msgId=" + w3.g() + " taskStatus=" + w3.j() + " sendStatus=" + w3.i());
        Companion companion = INSTANCE;
        companion.c().removeCompressTask(msgId);
        companion.d().removeEncodeTask(msgId);
        w3.w(0);
        MsgRecord msgRecord = w3.h().getMsgRecord();
        if (msgRecord.sendStatus == 1) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOVideoSendingManager", 2, "[cancelSending] cancel sending msg, msgId=" + msgId);
            }
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            long j3 = msgRecord.msgId;
            String str = msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "mr.peerUid");
            iMsgService.cancelSendMsg(j3, str, msgRecord.chatType);
        }
        com.tencent.qqnt.aio.util.d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager$cancelSending$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoSendTask.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    VideoSendTask.this.o(VideoErrorCode.CancelUpload);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    AIOVideoSendingManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        CoroutineScope MainScope = CoroutineScopeKt.MainScope();
        this.scope = MainScope;
        this.sendingTaskMap = new ConcurrentHashMap<>();
        this.delayRemovingJobs = new ConcurrentHashMap<>();
        QLog.i("AIOVideoSendingManager", 1, "AIOVideoSendingManager.init");
        BuildersKt__Builders_commonKt.launch$default(MainScope, Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }
}
