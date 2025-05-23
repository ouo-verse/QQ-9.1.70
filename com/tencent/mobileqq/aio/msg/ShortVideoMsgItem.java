package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.video.VideoViewModel;
import com.tencent.mobileqq.aio.msglist.holder.component.video.b;
import com.tencent.mobileqq.aio.msglist.holder.component.video.u;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.compress.api.IVideoCompressApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RMReqExParams;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoPlayUrlResult;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 m2\u00020\u0001:\u0001nB\u0019\b\u0002\u0012\u0006\u0010h\u001a\u00020\u001c\u0012\u0006\u0010i\u001a\u00020\b\u00a2\u0006\u0004\bj\u0010kB\u0011\b\u0016\u0012\u0006\u0010h\u001a\u00020\u001c\u00a2\u0006\u0004\bj\u0010lJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\rJ\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\u0002J\u0006\u0010$\u001a\u00020\u0002J\b\u0010%\u001a\u0004\u0018\u00010\u0002J\b\u0010&\u001a\u0004\u0018\u00010\u0002J\b\u0010'\u001a\u0004\u0018\u00010\u0002J\b\u0010(\u001a\u0004\u0018\u00010\u0002J\u0006\u0010)\u001a\u00020\u0002J\u0006\u0010*\u001a\u00020\u0002J\u0006\u0010+\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\b\u0010/\u001a\u00020\nH\u0016J\u0010\u00101\u001a\u00020\r2\b\b\u0002\u00100\u001a\u00020\bJ\u0010\u00102\u001a\u00020\r2\b\b\u0002\u00100\u001a\u00020\bJz\u0010<\u001a\u00020\r2\u0006\u00100\u001a\u00020\b2\u0006\u00103\u001a\u00020\n2b\u0010;\u001a^\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\r04J\u0012\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010>\u001a\u00020=H\u0016R\u001b\u0010E\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR$\u0010O\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010V\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010QR\u0016\u0010[\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0011\u0010_\u001a\u00020\\8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010^R\u0011\u0010c\u001a\u00020`8F\u00a2\u0006\u0006\u001a\u0004\ba\u0010bR\u0011\u0010g\u001a\u00020d8F\u00a2\u0006\u0006\u001a\u0004\be\u0010f\u00a8\u0006o"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "Lcom/tencent/mobileqq/aio/msg/RichMediaMsgItem;", "", "B2", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/b;", NowProxyConstants.AccountInfoKey.A2, "Lcom/tencent/qqnt/kernel/nativeinterface/VideoPlayUrlResult;", "urlResult", "", "T2", "", BdhLogUtil.LogTag.Tag_Req, "status", "", "b3", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoViewModel;", "model", ICustomDataEditor.STRING_ARRAY_PARAM_3, "K2", "Q2", "P2", "O2", "R2", "Y2", "Landroid/content/Context;", "context", "Y0", "f1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b0", "newMsgItem", "l", "N2", Constants.BASE_IN_PLUGIN_VERSION, "C2", "S2", "p2", "U2", "q2", "I2", "H2", Constants.MMCCID, "J2", "M2", "L2", "getViewType", "manualDownload", "r2", "u2", "downSourceType", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "url", "resultVideoCodecFormat", "cb", "V2", "Lcom/tencent/aio/data/msglist/a;", "target", "", "getChangePayload", "X0", "Lkotlin/Lazy;", "z2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/video/b;", "msgExtInfo", "Ljava/lang/String;", "existVideoPath", "Z0", "existThumbPath", ICustomDataEditor.STRING_ARRAY_PARAM_1, "x2", "()Ljava/lang/String;", "setCachedVideoPlayUrl", "(Ljava/lang/String;)V", "cachedVideoPlayUrl", "b1", "I", "w2", "()I", "setCacheVideoCodecFormat", "(I)V", "cacheVideoCodecFormat", "c1", "msgSendStatus", "d1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoViewModel;", "videoViewModel", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "y2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "E2", "()Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "videoElement", "", "F2", "()J", "videoFileTimeMillis", "msgRecord", "clone", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Z)V", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "e1", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ShortVideoMsgItem extends RichMediaMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgExtInfo;

    /* renamed from: Y0, reason: from kotlin metadata */
    @Nullable
    private String existVideoPath;

    /* renamed from: Z0, reason: from kotlin metadata */
    @Nullable
    private String existThumbPath;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String cachedVideoPlayUrl;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private int cacheVideoCodecFormat;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private int msgSendStatus;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VideoViewModel videoViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.ShortVideoMsgItem$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 45)) {
            redirector.redirect((short) 45);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    ShortVideoMsgItem(MsgRecord msgRecord, boolean z16) {
        super(msgRecord);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msgRecord, Boolean.valueOf(z16));
            return;
        }
        this.msgExtInfo = LazyKt.lazy(new Function0<com.tencent.mobileqq.aio.msglist.holder.component.video.b>() { // from class: com.tencent.mobileqq.aio.msg.ShortVideoMsgItem$msgExtInfo$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoMsgItem.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.aio.msglist.holder.component.video.b invoke() {
                com.tencent.mobileqq.aio.msglist.holder.component.video.b A2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.aio.msglist.holder.component.video.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                A2 = ShortVideoMsgItem.this.A2();
                return A2;
            }
        });
        this.msgSendStatus = msgRecord.sendStatus;
        this.videoViewModel = VideoViewModel.Normal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.msglist.holder.component.video.b A2() {
        byte[] bArr;
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("106123", false);
        QLog.i("ShortVideoMsgItem", 2, "[getMsgExtInfo] isSwitchOn:" + isSwitchOn);
        if (isSwitchOn) {
            MsgElement firstTypeElement = getFirstTypeElement(5);
            if (firstTypeElement == null) {
                QLog.w("ShortVideoMsgItem", 1, "init msgExtInfo. cannot find video element.");
            }
            b.Companion companion = com.tencent.mobileqq.aio.msglist.holder.component.video.b.INSTANCE;
            if (firstTypeElement != null) {
                bArr = firstTypeElement.extBufForUI;
            } else {
                bArr = null;
            }
            return companion.a(bArr);
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.video.b.INSTANCE.a(y2().extBufForUI);
    }

    private final String B2() {
        if (isSelf()) {
            return z2().c().e();
        }
        return "";
    }

    private final boolean T2(VideoPlayUrlResult urlResult) {
        Intrinsics.checkNotNullExpressionValue(urlResult.domainUrl, "urlResult.domainUrl");
        return !r2.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(final ShortVideoMsgItem this$0, boolean z16, int i3, final Function4 cb5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        u.Companion companion = com.tencent.mobileqq.aio.msglist.holder.component.video.u.INSTANCE;
        IVideoCompressApi iVideoCompressApi = (IVideoCompressApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVideoCompressApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        VideoCodecFormatType b16 = companion.b(Integer.valueOf(iVideoCompressApi.getVideoDownloadRequestCodecFormat(peekAppRuntime, this$0.E2().busiType, this$0.E2().thumbWidth, this$0.E2().thumbHeight, this$0.E2().thumbWidth, this$0.E2().thumbHeight, this$0.z2().a())));
        QLog.d("ShortVideoMsgItem", 1, "[requestVideoPlayUrl] targetVideoCodecFormat:" + b16, ", formatInfo=" + this$0.z2().a() + ", md5=" + this$0.E2().videoMd5 + ", fileUuid=" + this$0.E2().fileUuid);
        RMReqExParams rMReqExParams = new RMReqExParams(i3, !z16 ? 1 : 0);
        com.tencent.qqnt.kernel.api.ab g16 = com.tencent.qqnt.msg.f.g();
        if (g16 != null) {
            g16.getVideoPlayUrlV2(new Contact(this$0.p0(), this$0.r0(), ""), this$0.q0(), this$0.y2().elementId, b16, rMReqExParams, new IVideoPlayUrlCallback() { // from class: com.tencent.mobileqq.aio.msg.aa
                @Override // com.tencent.qqnt.kernel.nativeinterface.IVideoPlayUrlCallback
                public final void onResult(int i16, String str, VideoPlayUrlResult videoPlayUrlResult) {
                    ShortVideoMsgItem.X2(ShortVideoMsgItem.this, cb5, i16, str, videoPlayUrlResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X2(ShortVideoMsgItem this$0, Function4 cb5, int i3, String errMsg, VideoPlayUrlResult urlResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(urlResult, "urlResult");
            if (this$0.T2(urlResult)) {
                String str = urlResult.domainUrl.get(0).url;
                QLog.i("ShortVideoMsgItem", 1, "[getVideoPlayUrl] success, err=" + i3 + ", " + errMsg + ", videoDownloadResponseCodecFormat=" + urlResult.videoCodecFormat + ", url=" + str);
                this$0.cachedVideoPlayUrl = str;
                u.Companion companion = com.tencent.mobileqq.aio.msglist.holder.component.video.u.INSTANCE;
                this$0.cacheVideoCodecFormat = companion.a(urlResult.videoCodecFormat);
                Integer valueOf = Integer.valueOf(i3);
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                cb5.invoke(valueOf, errMsg, this$0.cachedVideoPlayUrl, Integer.valueOf(companion.a(urlResult.videoCodecFormat)));
                return;
            }
        }
        QLog.i("ShortVideoMsgItem", 1, "[getVideoPlayUrl] failed, err=" + i3 + "," + errMsg);
        Integer valueOf2 = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        cb5.invoke(valueOf2, errMsg, null, Integer.valueOf(com.tencent.mobileqq.aio.msglist.holder.component.video.u.INSTANCE.a(urlResult.videoCodecFormat)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(ShortVideoMsgItem this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            QLog.w("ShortVideoMsgItem", 1, "[serializeExtInfo] fail, err=" + i3 + ", " + str + ", " + this$0.z2().a());
        }
    }

    public static /* synthetic */ void s2(ShortVideoMsgItem shortVideoMsgItem, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        shortVideoMsgItem.r2(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(ShortVideoMsgItem this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MsgElement firstTypeElement = this$0.getFirstTypeElement(5);
        if (firstTypeElement != null) {
            if (this$0.N2()) {
                QLog.i("ShortVideoMsgItem", 1, "resource is expired, msgId=" + this$0.getMsgId() + ", elemId=" + firstTypeElement.elementId);
            }
            RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
            richMediaElementGetReq.msgId = this$0.q0();
            richMediaElementGetReq.peerUid = this$0.r0();
            richMediaElementGetReq.chatType = this$0.p0();
            richMediaElementGetReq.elementId = firstTypeElement.elementId;
            richMediaElementGetReq.downloadType = 2;
            richMediaElementGetReq.thumbSize = 0;
            richMediaElementGetReq.downSourceType = 1;
            richMediaElementGetReq.triggerType = !z16 ? 1 : 0;
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.getRichMediaElement(richMediaElementGetReq);
            }
            QLog.i("ShortVideoMsgItem", 1, "[downloadThumb] start downloading, msgId=" + richMediaElementGetReq.msgId + ", elemId={" + firstTypeElement.elementId + "}");
            return;
        }
        QLog.w("ShortVideoMsgItem", 1, "[downloadThumb] no video element found, msgId=" + this$0.getMsgId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(ShortVideoMsgItem this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MsgElement firstTypeElement = this$0.getFirstTypeElement(5);
        if (firstTypeElement != null) {
            RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
            richMediaElementGetReq.msgId = this$0.q0();
            richMediaElementGetReq.peerUid = this$0.r0();
            richMediaElementGetReq.chatType = this$0.p0();
            richMediaElementGetReq.elementId = firstTypeElement.elementId;
            richMediaElementGetReq.downloadType = 1;
            richMediaElementGetReq.thumbSize = 0;
            richMediaElementGetReq.downSourceType = 1;
            richMediaElementGetReq.triggerType = !z16 ? 1 : 0;
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.getRichMediaElement(richMediaElementGetReq);
                return;
            }
            return;
        }
        QLog.w("ShortVideoMsgItem", 1, "[downloadVideo] no video element found, msgId=" + this$0.getMsgId());
    }

    @NotNull
    public final String C2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.c(getMsgRecord());
    }

    @NotNull
    public final String D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.d(getMsgRecord());
    }

    @NotNull
    public final VideoElement E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (VideoElement) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        VideoElement videoElement = y2().videoElement;
        Intrinsics.checkNotNullExpressionValue(videoElement, "msgElement.videoElement");
        return videoElement;
    }

    public final long F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return E2().fileTime * 1000;
    }

    @NotNull
    public final String G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.f(getMsgRecord());
    }

    @NotNull
    public final String H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.g(getMsgRecord());
    }

    @NotNull
    public final String I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.h(getMsgRecord());
    }

    @NotNull
    public final String J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.i(getMsgRecord()) + "_" + z2().a().b();
    }

    @NotNull
    public final VideoViewModel K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (VideoViewModel) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.videoViewModel;
    }

    public final boolean L2() {
        HashMap<Integer, String> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        if (!z2().c().h()) {
            QLog.w("ShortVideoMsgItem", 1, "[initVideoElementBySendInfo] invalid send info, msgId=" + getMsgId());
            return false;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.video.z c16 = z2().c();
        VideoElement E2 = E2();
        E2.filePath = c16.b();
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(0, c16.e()));
        E2.thumbPath = hashMapOf;
        E2.thumbHeight = c16.c();
        E2.thumbWidth = c16.g();
        E2.thumbMd5 = c16.d();
        E2.thumbSize = (int) c16.f();
        this.existThumbPath = c16.e();
        this.existVideoPath = c16.b();
        return true;
    }

    public final boolean M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        VideoElement E2 = E2();
        if (E2.fileSize != 0 && !TextUtils.isEmpty(E2.fileName) && !TextUtils.isEmpty(E2.videoMd5)) {
            return true;
        }
        return false;
    }

    public final boolean N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        Integer num = E2().invalidState;
        if (num == null || num.intValue() != 0) {
            return true;
        }
        return false;
    }

    public final boolean O2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (R() == 0) {
            return true;
        }
        return false;
    }

    public final boolean P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (R() != 2 && R() != 3) {
            return false;
        }
        return true;
    }

    public final boolean Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (R() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public int R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.msgSendStatus;
    }

    public final boolean R2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (isSelf()) {
            return z2().c().h();
        }
        return false;
    }

    @Nullable
    public final String S2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        String str = this.existThumbPath;
        if (str != null) {
            if (Intrinsics.areEqual(str, D2()) || Intrinsics.areEqual(this.existThumbPath, B2())) {
                return this.existThumbPath;
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final String U2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        String str = this.existVideoPath;
        if (str != null && Intrinsics.areEqual(str, I2())) {
            return this.existVideoPath;
        }
        return null;
    }

    public final void V2(final boolean manualDownload, final int downSourceType, @NotNull final Function4<? super Integer, ? super String, ? super String, ? super Integer, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Boolean.valueOf(manualDownload), Integer.valueOf(downSourceType), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!TextUtils.isEmpty(this.cachedVideoPlayUrl)) {
            cb5.invoke(0, "", this.cachedVideoPlayUrl, Integer.valueOf(this.cacheVideoCodecFormat));
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msg.y
                @Override // java.lang.Runnable
                public final void run() {
                    ShortVideoMsgItem.W2(ShortVideoMsgItem.this, manualDownload, downSourceType, cb5);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        z2();
        p2();
        q2();
    }

    public final void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        MsgElement y26 = y2();
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.updateElementExtBufForUI(new Contact(p0(), r0(), ""), q0(), y26.elementId, z2().d(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.z
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    ShortVideoMsgItem.Z2(ShortVideoMsgItem.this, i3, str);
                }
            });
        }
    }

    public final void a3(@NotNull VideoViewModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        QLog.i("ShortVideoMsgItem", 1, "[setVideoViewModel] model=" + model);
        this.videoViewModel = model;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 19, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new ShortVideoMsgItem(targetMsgRecord, true);
    }

    public final void b3(int status) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, status);
            return;
        }
        QLog.i("ShortVideoMsgItem", 1, "[updateMsgSendStatus] msgId=" + getMsgId() + " status=" + this.msgSendStatus + "->" + status);
        this.msgSendStatus = status;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ypd) + HardCodeUtil.qqStr(R.string.ypf);
        }
        if (com.tencent.mobileqq.aio.utils.d.s(this)) {
            return getMsgRecord().anonymousExtInfo.anonymousNick + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.ypf);
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.ypf);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return iPatchRedirector.redirect((short) 44, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof AIOMsgItem) {
            AIOMsgItem aIOMsgItem = (AIOMsgItem) target;
            if (!com.tencent.qqnt.aio.msg.d.q(this, aIOMsgItem)) {
                QLog.i("ShortVideoMsgItem", 1, "[getChangePayload] fileTransNotifyInfo=" + aIOMsgItem.getFileTransNotifyInfo());
                return null;
            }
        }
        return super.getChangePayload(target);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        if (getMsgRecord().msgType == 7) {
            if (isSelf()) {
                return 11;
            }
            return 10;
        }
        return super.getViewType();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ShortVideoMsgItem shortVideoMsgItem = (ShortVideoMsgItem) newMsgItem;
        shortVideoMsgItem.cachedVideoPlayUrl = this.cachedVideoPlayUrl;
        shortVideoMsgItem.existThumbPath = this.existThumbPath;
        shortVideoMsgItem.existVideoPath = this.existVideoPath;
    }

    @Nullable
    public final String p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        String S2 = S2();
        if (S2 != null) {
            return S2;
        }
        String D2 = D2();
        if (new File(D2).exists()) {
            this.existThumbPath = D2;
            return D2;
        }
        String B2 = B2();
        if (!TextUtils.isEmpty(B2) && new File(B2).exists()) {
            this.existThumbPath = B2;
            return null;
        }
        return null;
    }

    @Nullable
    public final String q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        String U2 = U2();
        if (U2 != null) {
            return U2;
        }
        String I2 = I2();
        File file = new File(I2);
        if (file.exists()) {
            this.existVideoPath = I2;
            return I2;
        }
        String parent = file.getParent();
        if (parent != null) {
            FileUtils.createDirectory(parent);
            return null;
        }
        return null;
    }

    public final void r2(final boolean manualDownload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, manualDownload);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msg.x
                @Override // java.lang.Runnable
                public final void run() {
                    ShortVideoMsgItem.t2(ShortVideoMsgItem.this, manualDownload);
                }
            }, 16, null, false);
        }
    }

    public final void u2(final boolean manualDownload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, manualDownload);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msg.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ShortVideoMsgItem.v2(ShortVideoMsgItem.this, manualDownload);
                }
            }, 16, null, false);
        }
    }

    public final int w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.cacheVideoCodecFormat;
    }

    @Nullable
    public final String x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.cachedVideoPlayUrl;
    }

    @NotNull
    public final MsgElement y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (MsgElement) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        MsgElement firstTypeElement = getFirstTypeElement(5);
        Intrinsics.checkNotNull(firstTypeElement);
        return firstTypeElement;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.msglist.holder.component.video.b z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.video.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (com.tencent.mobileqq.aio.msglist.holder.component.video.b) this.msgExtInfo.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortVideoMsgItem(@NotNull MsgRecord msgRecord) {
        this(msgRecord, false);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgRecord);
    }
}
