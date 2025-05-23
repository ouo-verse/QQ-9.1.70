package com.tencent.guild.api.video;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.p004if.u;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.element_ext_buf_for_ui$ElementExtBufForUI;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u000256J+\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0003H&J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H&J8\u0010'\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH&J0\u0010+\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H'J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H'J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H&J\u001a\u00102\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u00101\u001a\u000200H&J\u0012\u00103\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0012\u00104\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&\u00a8\u00067"}, d2 = {"Lcom/tencent/guild/api/video/IGuildVideoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "callback", "initSDK", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "getVideoViewHeight", "getVideoViewWidth", "needCreate", "", "getVideoPath", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "videoMsgElem", "getThumbPath", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "findCompressTask", "removeCompressTask", "Lcom/tencent/guild/api/video/IGuildVideoApi$b;", "listener", "setCompressListener", WadlProxyConsts.PARAM_FILENAME, MimeTypeParser.ATTR_EXTENSION, "getShortVideoThumbPicPath", "msgElement", "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "app", CustomImageProps.QUALITY, u.NAME, "thumbPath", "Lcom/tencent/guild/api/video/IGuildVideoApi$c;", "cb", "encodeVideo", "removeEncodeTask", "Landroid/content/Intent;", "intent", "initEncodeQualityParam", "Ltencent/im/msg/element_ext_buf_for_ui$ElementExtBufForUI;", "extBufForUI", "initVideoElement", "copyVideoToNTDIR", "copyThumbPicToNTDIR", "b", "c", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildVideoApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ String a(IGuildVideoApi iGuildVideoApi, com.tencent.aio.data.msglist.a aVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iGuildVideoApi.getThumbPath(aVar, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbPath");
        }

        public static /* synthetic */ String b(IGuildVideoApi iGuildVideoApi, MsgElement msgElement, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iGuildVideoApi.getThumbPath(msgElement, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbPath");
        }

        public static /* synthetic */ String c(IGuildVideoApi iGuildVideoApi, MsgRecord msgRecord, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iGuildVideoApi.getThumbPath(msgRecord, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbPath");
        }

        public static /* synthetic */ String d(IGuildVideoApi iGuildVideoApi, com.tencent.aio.data.msglist.a aVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iGuildVideoApi.getVideoPath(aVar, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideoPath");
        }

        public static /* synthetic */ String e(IGuildVideoApi iGuildVideoApi, MsgRecord msgRecord, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iGuildVideoApi.getVideoPath(msgRecord, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideoPath");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/api/video/IGuildVideoApi$b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "isNeedCompress", "", "a", "", "percent", "c", "", "finishCode", "b", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface b {
        void a(@Nullable MsgRecord msgRecord, boolean isNeedCompress);

        void b(@Nullable MsgRecord msgRecord, int finishCode);

        void c(@Nullable MsgRecord msgRecord, float percent);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/api/video/IGuildVideoApi$c;", "", "", "errorCode", "", "onError", "", "videoPath", "onSuccess", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface c {
        void onError(int errorCode);

        void onSuccess(@Nullable String videoPath);
    }

    void compressVideo(@NotNull MsgRecord msgRecord, @NotNull MsgElement msgElement, @NotNull Context context, @NotNull AppRuntime app, boolean quality, @NotNull b listener);

    void copyThumbPicToNTDIR(@Nullable MsgElement videoMsgElem);

    void copyVideoToNTDIR(@Nullable MsgElement videoMsgElem);

    @MainThread
    void encodeVideo(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull MsgElement msgElement, @NotNull String thumbPath, @NotNull c cb5);

    boolean findCompressTask(long taskId);

    @NotNull
    String getShortVideoThumbPicPath(@NotNull String fileName, @NotNull String extension);

    @NotNull
    String getThumbPath(@NotNull com.tencent.aio.data.msglist.a msgItem, boolean needCreate);

    @NotNull
    String getThumbPath(@NotNull MsgElement videoMsgElem, boolean needCreate);

    @NotNull
    String getThumbPath(@NotNull MsgRecord msgRecord, boolean needCreate);

    @NotNull
    String getVideoPath(@NotNull com.tencent.aio.data.msglist.a msgItem, boolean needCreate);

    @NotNull
    String getVideoPath(@NotNull MsgElement videoMsgElem, boolean needCreate);

    @NotNull
    String getVideoPath(@NotNull MsgRecord msgRecord, boolean needCreate);

    int getVideoViewHeight(@NotNull com.tencent.aio.data.msglist.a msgItem);

    int getVideoViewWidth(@NotNull com.tencent.aio.data.msglist.a msgItem);

    void initEncodeQualityParam(@NotNull Intent intent);

    void initSDK(@NotNull Function1<? super Boolean, Unit> callback);

    void initVideoElement(@Nullable MsgElement videoMsgElem, @NotNull element_ext_buf_for_ui$ElementExtBufForUI extBufForUI);

    void removeCompressTask(long taskId);

    @MainThread
    void removeEncodeTask(@NotNull MsgRecord msgRecord);

    void setCompressListener(long taskId, @NotNull b listener);
}
