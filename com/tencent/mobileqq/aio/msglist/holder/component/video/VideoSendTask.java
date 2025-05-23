package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.video.VideoSendTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0002\u0015\u001bB\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010D\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\bE\u0010FJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0004R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00109\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010%R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010<R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010=R\"\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b>\u0010@\"\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask;", "", "", "l", "", "r", "", "progress", DomainData.DOMAIN_NAME, "p", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorCode;", "errorCode", "o", "", "videoPath", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", tl.h.F, "()Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask$b;", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask$b;", "completeListener", "", "c", "J", "g", "()J", "msgId", "d", "I", "i", "()I", "w", "(I)V", "msgSendStatus", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/aa;", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/aa;", "f", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/video/aa;", "v", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/video/aa;)V", "listener", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendStatus;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendStatus;", "j", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendStatus;", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendStatus;)V", "status", "compressProgress", "uploadProgress", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorCode;", "Ljava/lang/String;", "k", "Z", "()Z", "y", "(Z)V", "videoFileOverSize", "resend", "<init>", "(Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;ZLcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask$b;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class VideoSendTask {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShortVideoMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b completeListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int msgSendStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aa listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VideoSendStatus status;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int compressProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int uploadProgress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VideoErrorCode errorCode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoPath;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean videoFileOverSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.VideoSendTask$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendTask$b;", "", "", "msgId", "", "success", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface b {
        void a(long msgId, boolean success);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64035);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VideoSendTask(@NotNull ShortVideoMsgItem msgItem, boolean z16, @NotNull b completeListener) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(completeListener, "completeListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgItem, Boolean.valueOf(z16), completeListener);
            return;
        }
        this.msgItem = msgItem;
        this.completeListener = completeListener;
        this.msgId = msgItem.getMsgId();
        this.msgSendStatus = (z16 && msgItem.getMsgRecord().sendStatus == 0) ? 1 : msgItem.getMsgRecord().sendStatus;
        this.status = VideoSendStatus.Init;
        this.errorCode = VideoErrorCode.Success;
    }

    @Nullable
    public final aa f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (aa) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.listener;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @NotNull
    public final ShortVideoMsgItem h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ShortVideoMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgItem;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.msgSendStatus;
    }

    @NotNull
    public final VideoSendStatus j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (VideoSendStatus) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.status;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.videoFileOverSize;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        VideoSendStatus videoSendStatus = this.status;
        if (videoSendStatus != VideoSendStatus.Failed && videoSendStatus != VideoSendStatus.Success) {
            return false;
        }
        return true;
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            k.f192240a.l(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.VideoSendTask$notifyStatus$1
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes11.dex */
                public /* synthetic */ class a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f192215a;

                    static {
                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64031);
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
                            iArr[VideoSendStatus.StartCompressing.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[VideoSendStatus.Compressing.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[VideoSendStatus.FinishCompressing.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[VideoSendStatus.Uploading.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[VideoSendStatus.SendingMsg.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[VideoSendStatus.Failed.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        try {
                            iArr[VideoSendStatus.Success.ordinal()] = 8;
                        } catch (NoSuchFieldError unused8) {
                        }
                        f192215a = iArr;
                    }
                }

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
                    int i3;
                    int i16;
                    VideoSendTask.b bVar;
                    VideoErrorCode videoErrorCode;
                    VideoSendTask.b bVar2;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    switch (a.f192215a[VideoSendTask.this.j().ordinal()]) {
                        case 1:
                            aa f16 = VideoSendTask.this.f();
                            if (f16 != null) {
                                f16.g(VideoSendTask.this.g());
                                return;
                            }
                            return;
                        case 2:
                            aa f17 = VideoSendTask.this.f();
                            if (f17 != null) {
                                f17.g(VideoSendTask.this.g());
                                return;
                            }
                            return;
                        case 3:
                            aa f18 = VideoSendTask.this.f();
                            if (f18 != null) {
                                long g16 = VideoSendTask.this.g();
                                i3 = VideoSendTask.this.compressProgress;
                                f18.b(g16, i3);
                                return;
                            }
                            return;
                        case 4:
                            aa f19 = VideoSendTask.this.f();
                            if (f19 != null) {
                                f19.f(VideoSendTask.this.g());
                                return;
                            }
                            return;
                        case 5:
                            aa f26 = VideoSendTask.this.f();
                            if (f26 != null) {
                                long g17 = VideoSendTask.this.g();
                                i16 = VideoSendTask.this.uploadProgress;
                                f26.d(g17, i16);
                                return;
                            }
                            return;
                        case 6:
                            aa f27 = VideoSendTask.this.f();
                            if (f27 != null) {
                                f27.c(VideoSendTask.this.g());
                                return;
                            }
                            return;
                        case 7:
                            aa f28 = VideoSendTask.this.f();
                            if (f28 != null) {
                                long g18 = VideoSendTask.this.g();
                                videoErrorCode = VideoSendTask.this.errorCode;
                                f28.e(g18, videoErrorCode);
                            }
                            bVar = VideoSendTask.this.completeListener;
                            bVar.a(VideoSendTask.this.g(), false);
                            return;
                        case 8:
                            aa f29 = VideoSendTask.this.f();
                            if (f29 != null) {
                                long g19 = VideoSendTask.this.g();
                                str = VideoSendTask.this.videoPath;
                                if (str == null) {
                                    str = "";
                                }
                                f29.a(g19, str);
                            }
                            bVar2 = VideoSendTask.this.completeListener;
                            bVar2.a(VideoSendTask.this.g(), true);
                            return;
                        default:
                            throw new RuntimeException("invalid status '" + VideoSendTask.this.j() + "'");
                    }
                }
            });
        }
    }

    public final void n(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, progress);
            return;
        }
        VideoSendStatus videoSendStatus = this.status;
        VideoSendStatus videoSendStatus2 = VideoSendStatus.Compressing;
        if (videoSendStatus.compareTo(videoSendStatus2) > 0) {
            QLog.w("VideoSendTask", 1, "[onCompress] invalid status, msgId=" + this.msgId + " status=" + this.status);
            return;
        }
        if (this.status == videoSendStatus2 && this.compressProgress == progress) {
            return;
        }
        this.compressProgress = progress;
        this.status = videoSendStatus2;
        m();
    }

    public final void o(@NotNull VideoErrorCode errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) errorCode);
            return;
        }
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (l()) {
            QLog.w("VideoSendTask", 1, "[onFailed] invalid status, msgId=" + this.msgId + " status=" + this.status);
            return;
        }
        this.errorCode = errorCode;
        this.status = VideoSendStatus.Failed;
        m();
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        VideoSendStatus videoSendStatus = this.status;
        VideoSendStatus videoSendStatus2 = VideoSendStatus.FinishCompressing;
        if (videoSendStatus.compareTo(videoSendStatus2) > 0) {
            QLog.w("VideoSendTask", 1, "[onFinishCompressing] invalid status, msgId=" + this.msgId + " status=" + this.status);
            return;
        }
        this.compressProgress = 100;
        this.status = videoSendStatus2;
        m();
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        VideoSendStatus videoSendStatus = this.status;
        VideoSendStatus videoSendStatus2 = VideoSendStatus.SendingMsg;
        if (videoSendStatus.compareTo(videoSendStatus2) > 0) {
            QLog.w("VideoSendTask", 1, "[onSendMsg] invalid status, msgId=" + this.msgId + " status=" + this.status);
            return;
        }
        this.uploadProgress = 100;
        this.status = videoSendStatus2;
        m();
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        VideoSendStatus videoSendStatus = this.status;
        if (videoSendStatus != VideoSendStatus.Init) {
            QLog.w("VideoSendTask", 1, "[onStartCompressing] invalid status, msgId=" + this.msgId + " status=" + videoSendStatus);
            return;
        }
        this.status = VideoSendStatus.StartCompressing;
        m();
    }

    public final void s(@NotNull String videoPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) videoPath);
            return;
        }
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        if (l()) {
            QLog.w("VideoSendTask", 1, "[onSuccess] invalid status, msgId=" + this.msgId + " status=" + this.status);
            return;
        }
        this.videoPath = videoPath;
        this.errorCode = VideoErrorCode.Success;
        this.status = VideoSendStatus.Success;
        m();
    }

    public final void t(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, progress);
            return;
        }
        VideoSendStatus videoSendStatus = this.status;
        VideoSendStatus videoSendStatus2 = VideoSendStatus.Uploading;
        if (videoSendStatus.compareTo(videoSendStatus2) > 0) {
            QLog.w("VideoSendTask", 1, "[onUpload] invalid status, msgId=" + this.msgId + " status=" + this.status);
            return;
        }
        this.uploadProgress = progress;
        this.status = videoSendStatus2;
        m();
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QLog.i("VideoSendTask", 1, "[sendMsg] msgId=" + this.msgId + " status=" + this.status);
        k.f192240a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.VideoSendTask$sendMsg$1
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
                    k.f192240a.p(VideoSendTask.this.h().getMsgRecord(), VideoSendTask.this.h().v());
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        this.status = VideoSendStatus.Uploading;
        m();
    }

    public final void v(@Nullable aa aaVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aaVar);
        } else {
            this.listener = aaVar;
        }
    }

    public final void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.msgSendStatus = i3;
        }
    }

    public final void x(@NotNull VideoSendStatus videoSendStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) videoSendStatus);
        } else {
            Intrinsics.checkNotNullParameter(videoSendStatus, "<set-?>");
            this.status = videoSendStatus;
        }
    }

    public final void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.videoFileOverSize = z16;
        }
    }
}
