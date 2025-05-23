package com.tencent.guild.api.video.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.util.x;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.p004if.u;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.element_ext_buf_for_ui$ElementExtBufForUI;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J+\u0010\u0014\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0016J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#H\u0016J8\u0010,\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0016J0\u00100\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u00104\u001a\u00020\u00122\u0006\u00103\u001a\u000202H\u0016J\u001a\u00107\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u00106\u001a\u000205H\u0016J\u0012\u00108\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u00109\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006>"}, d2 = {"Lcom/tencent/guild/api/video/impl/GuildVideoApiImpl;", "Lcom/tencent/guild/api/video/IGuildVideoApi;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "getVideoElement", "", "getVideoShortEdge", "getVideoLongEdge", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "getVideoMsgElem", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "callback", "initSDK", "getVideoViewHeight", "getVideoViewWidth", "needCreate", "", "getVideoPath", "videoMsgElem", "getThumbPath", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "findCompressTask", "removeCompressTask", WadlProxyConsts.PARAM_FILENAME, MimeTypeParser.ATTR_EXTENSION, "getShortVideoThumbPicPath", "Lcom/tencent/guild/api/video/IGuildVideoApi$b;", "listener", "setCompressListener", "msgElement", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "app", CustomImageProps.QUALITY, u.NAME, "thumbPath", "Lcom/tencent/guild/api/video/IGuildVideoApi$c;", "cb", "encodeVideo", "removeEncodeTask", "Landroid/content/Intent;", "intent", "initEncodeQualityParam", "Ltencent/im/msg/element_ext_buf_for_ui$ElementExtBufForUI;", "extBufForUI", "initVideoElement", "copyVideoToNTDIR", "copyThumbPicToNTDIR", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildVideoApiImpl implements IGuildVideoApi {
    private static final float AIO_BUBBLE_VIDEO_VIEW_RADIUS = 15.0f;

    @NotNull
    private static final String TAG = "GuildVideoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/api/video/impl/GuildVideoApiImpl$b", "Lcom/tencent/mobileqq/guild/temp/api/IGuildAIOMediaApi$b;", "", "videoPath", "", "onSuccess", "", "errorCode", "onError", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements IGuildAIOMediaApi.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGuildVideoApi.c f112661a;

        b(IGuildVideoApi.c cVar) {
            this.f112661a = cVar;
        }

        @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.b
        public void onError(int errorCode) {
            this.f112661a.onError(errorCode);
        }

        @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.b
        public void onSuccess(@NotNull String videoPath) {
            Intrinsics.checkNotNullParameter(videoPath, "videoPath");
            this.f112661a.onSuccess(videoPath);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/api/video/impl/GuildVideoApiImpl$c", "Lcom/tencent/mobileqq/guild/temp/api/IGuildAIOMediaApi$a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "isNeedCompress", "", "a", "", "percent", "c", "", "finishCode", "b", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements IGuildAIOMediaApi.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGuildVideoApi.b f112662a;

        c(IGuildVideoApi.b bVar) {
            this.f112662a = bVar;
        }

        @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.a
        public void a(@Nullable MsgRecord msgRecord, boolean isNeedCompress) {
            this.f112662a.a(msgRecord, isNeedCompress);
        }

        @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.a
        public void b(@Nullable MsgRecord msgRecord, int finishCode) {
            this.f112662a.b(msgRecord, finishCode);
        }

        @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.a
        public void c(@Nullable MsgRecord msgRecord, float percent) {
            this.f112662a.c(msgRecord, percent);
        }
    }

    private final VideoElement getVideoElement(com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        MsgElement firstTypeElement = ((GuildMsgItem) msgItem).getFirstTypeElement(5);
        if (firstTypeElement != null) {
            return firstTypeElement.videoElement;
        }
        return null;
    }

    private final int getVideoLongEdge(com.tencent.aio.data.msglist.a msgItem) {
        int coerceAtLeast;
        int coerceAtMost;
        VideoElement videoElement = getVideoElement(msgItem);
        if (videoElement != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(videoElement.thumbHeight, videoElement.thumbWidth);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, qr0.a.a(250));
            return coerceAtMost;
        }
        return qr0.a.a(250);
    }

    private final MsgElement getVideoMsgElem(MsgRecord msgRecord) {
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 5) {
                return next;
            }
        }
        return null;
    }

    private final int getVideoShortEdge(com.tencent.aio.data.msglist.a msgItem) {
        int a16;
        int coerceAtLeast;
        int coerceAtMost;
        VideoElement videoElement = getVideoElement(msgItem);
        float f16 = 1.7777778f;
        if (videoElement != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(videoElement.thumbHeight, videoElement.thumbWidth);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(videoElement.thumbHeight, videoElement.thumbWidth);
            if (coerceAtLeast != 0 && coerceAtMost != 0) {
                f16 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast / coerceAtMost, 1.7777778f);
            }
            a16 = getVideoLongEdge(msgItem);
        } else {
            a16 = qr0.a.a(250);
        }
        return (int) (a16 / f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSDK$lambda$0(Function1 callback, boolean z16) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i(TAG, 1, "video sdk init result: " + z16);
        callback.invoke(Boolean.valueOf(z16));
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void compressVideo(@NotNull MsgRecord msgRecord, @NotNull MsgElement msgElement, @NotNull Context context, @NotNull AppRuntime app, boolean quality, @NotNull final IGuildVideoApi.b listener) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).compressVideo(msgRecord, msgElement, context, app, quality, new IGuildAIOMediaApi.a() { // from class: com.tencent.guild.api.video.impl.GuildVideoApiImpl$compressVideo$1
            @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.a
            public void a(@Nullable MsgRecord msgRecord2, boolean isNeedCompress) {
                IGuildVideoApi.b.this.a(msgRecord2, isNeedCompress);
            }

            @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.a
            public void b(@Nullable MsgRecord msgRecord2, int finishCode) {
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "GuildVideoApiImpl_compressVideoOnFinish", null, null, null, new GuildVideoApiImpl$compressVideo$1$onFinish$1(IGuildVideoApi.b.this, msgRecord2, finishCode, null), 14, null);
                }
            }

            @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi.a
            public void c(@Nullable MsgRecord msgRecord2, float percent) {
                IGuildVideoApi.b.this.c(msgRecord2, percent);
            }
        });
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void copyThumbPicToNTDIR(@Nullable MsgElement videoMsgElem) {
        String str;
        HashMap<Integer, String> hashMapOf;
        if (videoMsgElem != null) {
            VideoElement videoElement = videoMsgElem.videoElement;
            videoElement.fileName = FileUtils.getFileName(videoElement.fileName);
            String thumbPath = getThumbPath(videoMsgElem, true);
            HashMap<Integer, String> hashMap = videoMsgElem.videoElement.thumbPath;
            if (hashMap != null) {
                str = hashMap.get(0);
            } else {
                QLog.e(TAG, 1, "it.videoElement.thumbPath is null! elemId: " + videoMsgElem.elementId);
                str = "";
            }
            if (!cq.n(thumbPath) && cq.n(str)) {
                cq.h(str, thumbPath);
            }
            VideoElement videoElement2 = videoMsgElem.videoElement;
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(0, thumbPath));
            videoElement2.thumbPath = hashMapOf;
        }
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void copyVideoToNTDIR(@Nullable MsgElement videoMsgElem) {
        if (videoMsgElem != null) {
            String str = videoMsgElem.videoElement.filePath;
            String r16 = cq.r(str);
            videoMsgElem.videoElement.fileName = FileUtils.getFileName(str);
            videoMsgElem.videoElement.videoMd5 = r16;
            String videoPath = getVideoPath(videoMsgElem, true);
            if (!cq.n(videoPath)) {
                cq.h(str, videoPath);
            }
            VideoElement videoElement = videoMsgElem.videoElement;
            videoElement.filePath = videoPath;
            videoElement.fileSize = cq.v(str);
            videoMsgElem.videoElement.fileName = FileUtils.getFileName(videoPath);
            VideoElement videoElement2 = videoMsgElem.videoElement;
            videoElement2.videoMd5 = cq.r(videoElement2.filePath);
            videoMsgElem.videoElement.fileTime = (int) (x.f112474a.a(videoPath) / 1000);
        }
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void encodeVideo(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull MsgElement msgElement, @NotNull String thumbPath, @NotNull IGuildVideoApi.c cb5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(thumbPath, "thumbPath");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        VideoElement videoElement = msgElement.videoElement;
        ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).encodeVideo(context, thumbPath, videoElement.thumbMd5, Long.valueOf(msgRecord.msgId), new File(videoElement.filePath).getParent(), new b(cb5));
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public boolean findCompressTask(long taskId) {
        Boolean findCompressTask = ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).findCompressTask(taskId);
        Intrinsics.checkNotNullExpressionValue(findCompressTask, "api(IGuildAIOMediaApi::c\u2026.findCompressTask(taskId)");
        return findCompressTask.booleanValue();
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    @NotNull
    public String getShortVideoThumbPicPath(@NotNull String fileName, @NotNull String extension) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(extension, "extension");
        String shortVideoThumbPicPath = ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).getShortVideoThumbPicPath(fileName, extension);
        Intrinsics.checkNotNullExpressionValue(shortVideoThumbPicPath, "api(IGuildAIOMediaApi::c\u2026Path(fileName, extension)");
        return shortVideoThumbPicPath;
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    @NotNull
    public String getThumbPath(@NotNull MsgElement videoMsgElem, boolean needCreate) {
        IKernelService iKernelService;
        w msgService;
        Intrinsics.checkNotNullParameter(videoMsgElem, "videoMsgElem");
        int i3 = videoMsgElem.elementType;
        VideoElement videoElement = videoMsgElem.videoElement;
        RichMediaFilePathInfo richMediaFilePathInfo = new RichMediaFilePathInfo(i3, 0, videoElement.videoMd5, videoElement.fileName, 2, 0, videoElement.importRichMediaContext, videoElement.fileUuid, needCreate);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String richMediaFilePathForGuild = (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null || (msgService = iKernelService.getMsgService()) == null) ? null : msgService.getRichMediaFilePathForGuild(richMediaFilePathInfo);
        return richMediaFilePathForGuild == null ? "" : richMediaFilePathForGuild;
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    @NotNull
    public String getVideoPath(@NotNull com.tencent.aio.data.msglist.a msgItem, boolean needCreate) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return IGuildVideoApi.a.e(this, ((GuildMsgItem) msgItem).getMsgRecord(), false, 2, null);
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public int getVideoViewHeight(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        VideoElement videoElement = getVideoElement(msgItem);
        if (videoElement != null) {
            if (videoElement.thumbHeight > videoElement.thumbWidth) {
                return getVideoLongEdge(msgItem);
            }
            return getVideoShortEdge(msgItem);
        }
        return qr0.a.a(250);
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public int getVideoViewWidth(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        VideoElement videoElement = getVideoElement(msgItem);
        if (videoElement != null) {
            if (videoElement.thumbHeight > videoElement.thumbWidth) {
                return getVideoShortEdge(msgItem);
            }
            return getVideoLongEdge(msgItem);
        }
        return (int) (qr0.a.a(250) / 1.7777778f);
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void initEncodeQualityParam(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).initEncodeQualityParam(intent);
        CodecParam.mRecordFrames = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
        CodecParam.mRecordTime = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void initSDK(@NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new SDKInitListener() { // from class: com.tencent.guild.api.video.impl.a
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    GuildVideoApiImpl.initSDK$lambda$0(Function1.this, z16);
                }
            });
        } else {
            QLog.i(TAG, 1, "video sdk has inited.");
            callback.invoke(Boolean.TRUE);
        }
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void initVideoElement(@Nullable MsgElement videoMsgElem, @NotNull element_ext_buf_for_ui$ElementExtBufForUI extBufForUI) {
        HashMap<Integer, String> hashMapOf;
        Intrinsics.checkNotNullParameter(extBufForUI, "extBufForUI");
        if (videoMsgElem != null) {
            videoMsgElem.videoElement.filePath = extBufForUI.sourcePath.get();
            VideoElement videoElement = videoMsgElem.videoElement;
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(0, extBufForUI.thumbPath.get()));
            videoElement.thumbPath = hashMapOf;
            videoMsgElem.videoElement.thumbHeight = extBufForUI.thumbHeight.get();
            videoMsgElem.videoElement.thumbWidth = extBufForUI.thumbWidth.get();
            videoMsgElem.videoElement.thumbMd5 = extBufForUI.thumbMd5.get();
            videoMsgElem.videoElement.thumbSize = (int) extBufForUI.thumbSize.get();
        }
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void removeCompressTask(long taskId) {
        ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).removeCompressTask(taskId);
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void removeEncodeTask(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).removeEncodeVideoTask(Long.valueOf(msgRecord.msgId));
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    public void setCompressListener(long taskId, @NotNull IGuildVideoApi.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).setCompressListener(taskId, new c(listener));
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    @NotNull
    public String getVideoPath(@NotNull MsgRecord msgRecord, boolean needCreate) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement videoMsgElem = getVideoMsgElem(msgRecord);
        return videoMsgElem != null ? getVideoPath(videoMsgElem, needCreate) : "";
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    @NotNull
    public String getVideoPath(@NotNull MsgElement videoMsgElem, boolean needCreate) {
        IKernelService iKernelService;
        w msgService;
        Intrinsics.checkNotNullParameter(videoMsgElem, "videoMsgElem");
        int i3 = videoMsgElem.elementType;
        VideoElement videoElement = videoMsgElem.videoElement;
        RichMediaFilePathInfo richMediaFilePathInfo = new RichMediaFilePathInfo(i3, 0, videoElement.videoMd5, videoElement.fileName, 1, 0, videoElement.importRichMediaContext, videoElement.fileUuid, needCreate);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String richMediaFilePathForGuild = (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null || (msgService = iKernelService.getMsgService()) == null) ? null : msgService.getRichMediaFilePathForGuild(richMediaFilePathInfo);
        return richMediaFilePathForGuild == null ? "" : richMediaFilePathForGuild;
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    @NotNull
    public String getThumbPath(@NotNull MsgRecord msgRecord, boolean needCreate) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement videoMsgElem = getVideoMsgElem(msgRecord);
        return videoMsgElem != null ? IGuildVideoApi.a.b(this, videoMsgElem, false, 2, null) : "";
    }

    @Override // com.tencent.guild.api.video.IGuildVideoApi
    @NotNull
    public String getThumbPath(@NotNull com.tencent.aio.data.msglist.a msgItem, boolean needCreate) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return IGuildVideoApi.a.c(this, ((GuildMsgItem) msgItem).getMsgRecord(), false, 2, null);
    }
}
