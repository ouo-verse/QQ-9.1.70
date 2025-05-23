package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoSendingManager;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.aio.utils.ap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.component.BaseVideoView;
import com.tencent.mobileqq.qqnt.videoplay.player.PlayState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.ConfigurationChangedEvent;
import com.tencent.qqnt.compress.api.IVideoCompressApi;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneClickReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0002\u00a0\u0001\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u00a7\u0001\u00a8\u0001\u00a9\u0001B\u0084\u0001\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010u\u001a\u00020r\u0012`\u0010}\u001a\\\u0012\u0013\u0012\u00110r\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110!\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110y\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(z\u0012\u0004\u0012\u00020\u00050v\u0012\u0007\u0010\u0081\u0001\u001a\u00020~\u00a2\u0006\u0006\b\u00a5\u0001\u0010\u00a6\u0001J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000fJ\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0014`\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u0005J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020!H\u0002J,\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u001e\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u001e\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!2\u0006\u0010.\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!H\u0002J\u0010\u00101\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!H\u0002J \u00103\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!2\u0006\u0010.\u001a\u00020-2\u0006\u00102\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0005H\u0002J\b\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\u001a\u00109\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020!2\b\b\u0002\u00108\u001a\u00020\u0007H\u0002J\u0012\u0010<\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010>\u001a\u00020=H\u0002J\u001a\u0010C\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020!H\u0002J\u001a\u0010G\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010:2\u0006\u0010F\u001a\u00020\u0019H\u0002J*\u0010J\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0002J\"\u0010K\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020!H\u0002J\b\u0010M\u001a\u00020\u0007H\u0002J*\u0010R\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020:2\b\u0010P\u001a\u0004\u0018\u00010:2\u0006\u0010Q\u001a\u00020\u001bH\u0002J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010T\u001a\u00020SH\u0002J\b\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010>\u001a\u00020=H\u0002J\b\u0010X\u001a\u00020\u0005H\u0002J\b\u0010Y\u001a\u00020\u0005H\u0002J\b\u0010Z\u001a\u00020\u0005H\u0002J\b\u0010[\u001a\u00020\u0005H\u0002J\b\u0010\\\u001a\u00020\u0005H\u0002J\b\u0010]\u001a\u00020\u0005H\u0002J\b\u0010^\u001a\u00020\u0005H\u0002J\b\u0010_\u001a\u00020\u0005H\u0002J\b\u0010`\u001a\u00020\u0005H\u0002J\b\u0010a\u001a\u00020\u0005H\u0002J\u0018\u0010d\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u001b2\u0006\u0010c\u001a\u00020:H\u0002J\b\u0010e\u001a\u00020\u0007H\u0002J\b\u0010f\u001a\u00020\u0005H\u0002J\u0012\u0010i\u001a\u00020\u00052\b\u0010h\u001a\u0004\u0018\u00010gH\u0002J$\u0010l\u001a\u00020S2\b\u0010j\u001a\u0004\u0018\u00010:2\b\u0010k\u001a\u0004\u0018\u00010:2\u0006\u0010F\u001a\u00020\u0019H\u0002J\u0010\u0010m\u001a\u00020\u00052\u0006\u0010c\u001a\u00020:H\u0002J\u0010\u0010n\u001a\u00020\u00052\u0006\u0010c\u001a\u00020:H\u0002J\b\u0010o\u001a\u00020\u0005H\u0002R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tRn\u0010}\u001a\\\u0012\u0013\u0012\u00110r\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110!\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110y\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\bw\u0012\b\bx\u0012\u0004\b\b(z\u0012\u0004\u0012\u00020\u00050v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u0081\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0088\u0001\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008a\u0001\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0006\u0010\u0089\u0001R\u0017\u0010>\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b7\u0010\u008b\u0001R\u0017\u0010\u008e\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b/\u0010\u008d\u0001R\u0019\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bY\u0010\u0090\u0001R\u0019\u0010\u0094\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\bl\u0010\u0093\u0001R\u001b\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b0\u0010\u0096\u0001R\u001b\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b1\u0010\u0096\u0001R\u0017\u0010\u0099\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00101R\u0018\u0010\u009b\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009a\u0001\u0010_R\u001b\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bR\u0010\u009d\u0001R\u0017\u0010\u009f\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010_R\u0017\u0010\u00a2\u0001\u001a\u00030\u00a0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bi\u0010\u00a1\u0001R\u0017\u0010\u00a4\u0001\u001a\u00020A8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u00a3\u0001\u00a8\u0006\u00aa\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", BdhLogUtil.LogTag.Tag_Conn, "", "pause", "I0", "isMute", "w0", "Lcom/tencent/mobileqq/aio/msglist/payload/a$aw;", "payload", "M", "Lcom/tencent/mobileqq/aio/msglist/payload/a$ay;", "O", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ExifInterface.LATITUDE_SOUTH, "", "fileSize", "", "durationInSeconds", "G0", "q0", "p0", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "U", "Lkotlin/Function0;", WidgetCacheConstellationData.WORK, "updateUI", "t0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "block", "B", "msgId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/RelativeLayout;", "contentView", "E", "H", "I", "sendingVideo", "z0", "b0", "D0", "o0", "D", "checkThumb", "x0", "", "thumbPath", "V", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "videoView", "s0", "r0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "P", "l0", "newVideoPath", "videoDuration", "m0", "forceDownload", "manualDownload", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "J", "F0", "B0", "result", "errMsg", "url", "videoCodecFormat", "L", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "newParam", "k0", "T", "u0", "c0", UserInfo.SEX_FEMALE, "g0", "i0", "j0", "d0", "a0", "Z", "e0", "h0", "code", "msg", "f0", "C0", "H0", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "N", "fileID", "videoPath", "G", "X", "Y", "n0", "d", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "playPos", "f", "Lkotlin/jvm/functions/Function4;", "listener", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/a;", tl.h.F, "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/a;", "muteChangedListener", "Landroidx/lifecycle/LifecycleCoroutineScope;", "i", "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "currentMsgItem", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "videoParam", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "Lcom/tencent/mobileqq/aio/utils/StopWatch;", "Lcom/tencent/mobileqq/aio/utils/StopWatch;", "stopWatch", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/n;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/n;", "statusView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "videoSizeView", "videoDurationView", "videoPlayErrorCode", "K", "videoPlayPrepared", "Lcom/tencent/qqnt/aio/video/a;", "Lcom/tencent/qqnt/aio/video/a;", "videoPlayReport", "isVideoViewLive", "com/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer$f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer$f;", "sendStateListener", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "<init>", "(Landroid/widget/RelativeLayout;Landroid/content/Context;Lkotlin/jvm/functions/Function4;Lcom/tencent/mobileqq/qqnt/videoplay/api/param/a;)V", "a", "b", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOVideoViewer implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static boolean Q;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqnt.videoplay.api.param.c videoParam;

    /* renamed from: D, reason: from kotlin metadata */
    private BaseVideoView videoView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final StopWatch stopWatch;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final Drawable backgroundDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    private n statusView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView videoSizeView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView videoDurationView;

    /* renamed from: J, reason: from kotlin metadata */
    private int videoPlayErrorCode;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean videoPlayPrepared;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.video.a videoPlayReport;

    /* renamed from: M, reason: from kotlin metadata */
    private volatile boolean isVideoViewLive;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final f sendStateListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function4<Context, ShortVideoMsgItem, View, Long, Unit> listener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqnt.videoplay.api.param.a muteChangedListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleCoroutineScope lifecycleScope;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ShortVideoMsgItem currentMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer$a;", "", "", "b", "a", "", "DELAY_START_PLAY_AFTER_SCROLL", "J", "", "TAG", "Ljava/lang/String;", "", "TOAST_OFFSET_Y", "I", "VIDEO_SIZE_LIMIT", "", "VIDEO_SIZE_VIEW_MARGIN", UserInfo.SEX_FEMALE, "VIEW_CORNER_RADIUS", "", "sPauseVideo", "Z", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AIOVideoViewer.Q = false;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        public final void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOVideoViewer.Q = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer$b;", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/e;", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "videoParam", "", "b", "", "a", "", "Ljava/lang/String;", "url", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mobileqq.qqnt.videoplay.api.param.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ShortVideoMsgItem msgItem;

        public b(@NotNull String url, @NotNull ShortVideoMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) url, (Object) msgItem);
            } else {
                this.url = url;
                this.msgItem = msgItem;
            }
        }

        private final boolean b(com.tencent.mobileqq.qqnt.videoplay.api.param.c videoParam) {
            boolean z16;
            if (videoParam.d() != null) {
                String[] d16 = videoParam.d();
                Intrinsics.checkNotNull(d16);
                if (d16.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    String str = this.url;
                    String[] d17 = videoParam.d();
                    Intrinsics.checkNotNull(d17);
                    return Intrinsics.areEqual(str, d17[0]);
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.e
        public void a(@NotNull com.tencent.mobileqq.qqnt.videoplay.api.param.c videoParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) videoParam);
                return;
            }
            Intrinsics.checkNotNullParameter(videoParam, "videoParam");
            if (!b(videoParam)) {
                QLog.i("AIOVideoViewer", 1, "[onDownloadComplete] ignore, msgId=" + this.msgItem.getMsgId());
                return;
            }
            QLog.i("AIOVideoViewer", 1, "[onDownloadComplete], msgId=" + this.msgItem.getMsgId());
            this.msgItem.q2();
            this.msgItem.z2().b().a(true);
            this.msgItem.Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer$c;", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/f;", "", "createPlayer", "b", ICustomDataEditor.STRING_PARAM_1, "onVideoPrepared", "onFirstFrameRendered", "onBufferStart", "onBufferEnd", "", "code", "", "msg", "a", "c", "onPlayStop", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "weak", "host", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mobileqq.qqnt.videoplay.api.param.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<AIOVideoViewer> weak;

        public c(@NotNull AIOVideoViewer host) {
            Intrinsics.checkNotNullParameter(host, "host");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) host);
            } else {
                this.weak = new WeakReference<>(host);
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void a(int code, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, code, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.f0(code, msg2);
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.g0();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.h0();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void createPlayer() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.F();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void onBufferEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.Z();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void onBufferStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.a0();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void onFirstFrameRendered() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.d0();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void onPlayStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.e0();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void onVideoPrepared() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.j0();
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.f
        public void s1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            AIOVideoViewer aIOVideoViewer = this.weak.get();
            if (aIOVideoViewer != null) {
                aIOVideoViewer.i0();
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192197a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63961);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[VideoViewModel.values().length];
            try {
                iArr[VideoViewModel.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoViewModel.Shot.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f192197a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer$e", "Lcom/tencent/qqnt/aio/predownload/video/strategy/a;", "", "isSwitchOpen", "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e implements com.tencent.qqnt.aio.predownload.video.strategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortVideoMsgItem f192199b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MsgElement f192200c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f192201d;

        e(ShortVideoMsgItem shortVideoMsgItem, MsgElement msgElement, boolean z16) {
            this.f192199b = shortVideoMsgItem;
            this.f192200c = msgElement;
            this.f192201d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AIOVideoViewer.this, shortVideoMsgItem, msgElement, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.qqnt.aio.predownload.video.strategy.a
        public void onResult(boolean isSwitchOpen) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isSwitchOpen);
            } else if (!isSwitchOpen) {
                AIOVideoViewer.this.F0(this.f192199b);
            } else {
                AIOVideoViewer.this.J(this.f192199b, this.f192200c, this.f192201d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer$f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/aa;", "", "msgId", "", "tag", "", tl.h.F, "", "g", "", "progress", "b", "f", "d", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorCode;", "errorCode", "e", "videoPath", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f implements aa {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOVideoViewer.this);
            }
        }

        private final boolean h(long msgId, String tag) {
            ShortVideoMsgItem shortVideoMsgItem = AIOVideoViewer.this.currentMsgItem;
            ShortVideoMsgItem shortVideoMsgItem2 = null;
            if (shortVideoMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem = null;
            }
            if (shortVideoMsgItem.getMsgId() != msgId) {
                ShortVideoMsgItem shortVideoMsgItem3 = AIOVideoViewer.this.currentMsgItem;
                if (shortVideoMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    shortVideoMsgItem2 = shortVideoMsgItem3;
                }
                QLog.i("AIOVideoViewer", 1, "[" + tag + "] ignore, msgId=" + msgId + "!=" + shortVideoMsgItem2.getMsgId());
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.aa
        public void a(long msgId, @NotNull String videoPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Long.valueOf(msgId), videoPath);
                return;
            }
            Intrinsics.checkNotNullParameter(videoPath, "videoPath");
            if (!h(msgId, "onSuccess")) {
                return;
            }
            QLog.i("AIOVideoViewer", 1, "[onSuccess] msgId=" + msgId + " videoPath=" + videoPath);
            n nVar = AIOVideoViewer.this.statusView;
            ShortVideoMsgItem shortVideoMsgItem = null;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                nVar = null;
            }
            nVar.u();
            AIOVideoViewer aIOVideoViewer = AIOVideoViewer.this;
            ShortVideoMsgItem shortVideoMsgItem2 = aIOVideoViewer.currentMsgItem;
            if (shortVideoMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                shortVideoMsgItem = shortVideoMsgItem2;
            }
            aIOVideoViewer.m0(videoPath, shortVideoMsgItem.F2());
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.aa
        public void b(long msgId, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(msgId), Integer.valueOf(progress));
                return;
            }
            if (h(msgId, "onCompress")) {
                n nVar = AIOVideoViewer.this.statusView;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusView");
                    nVar = null;
                }
                nVar.m(progress);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.aa
        public void c(long msgId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, msgId);
                return;
            }
            if (!h(msgId, "onSendingMsg")) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoViewer", 2, "[onSendingMsg] msgId=" + msgId);
            }
            n nVar = AIOVideoViewer.this.statusView;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                nVar = null;
            }
            nVar.s();
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.aa
        public void d(long msgId, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(msgId), Integer.valueOf(progress));
                return;
            }
            if (!h(msgId, "onUploading")) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOVideoViewer", 2, "[onUploading] msgId=" + msgId + " progress=" + progress);
            }
            n nVar = AIOVideoViewer.this.statusView;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                nVar = null;
            }
            nVar.v(progress);
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.aa
        public void e(long msgId, @NotNull VideoErrorCode errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Long.valueOf(msgId), errorCode);
                return;
            }
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (!h(msgId, "onFailed")) {
                return;
            }
            QLog.i("AIOVideoViewer", 1, "[onFailed] msgId=" + msgId + " errorCode=" + errorCode);
            n nVar = AIOVideoViewer.this.statusView;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                nVar = null;
            }
            nVar.o();
            if (errorCode == VideoErrorCode.VideoTooLarge) {
                QQToast.makeText(AIOVideoViewer.this.context, AIOVideoViewer.this.context.getResources().getString(R.string.hku), 0).show(com.tencent.mobileqq.aio.utils.p.c(44));
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.aa
        public void f(long msgId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, msgId);
                return;
            }
            if (!h(msgId, "onFinishCompressing")) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AIOVideoViewer", 2, "[onFinishCompressing] msgId=" + msgId);
            }
            n nVar = AIOVideoViewer.this.statusView;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                nVar = null;
            }
            nVar.p();
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.aa
        public void g(long msgId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, msgId);
                return;
            }
            if (h(msgId, "onStartCompressing")) {
                n nVar = AIOVideoViewer.this.statusView;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusView");
                    nVar = null;
                }
                nVar.t();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64007);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOVideoViewer(@NotNull RelativeLayout contentView, @NotNull Context context, @NotNull Function4<? super Context, ? super ShortVideoMsgItem, ? super View, ? super Long, Unit> listener, @NotNull com.tencent.mobileqq.qqnt.videoplay.api.param.a muteChangedListener) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(muteChangedListener, "muteChangedListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contentView, context, listener, muteChangedListener);
            return;
        }
        this.contentView = contentView;
        this.context = context;
        this.listener = listener;
        this.muteChangedListener = muteChangedListener;
        Object context2 = contentView.getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        this.lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) context2);
        this.videoParam = G(null, null, 0L);
        this.stopWatch = new StopWatch("AIOBind.AIOVideoViewer", QLog.isDevelopLevel());
        this.backgroundDrawable = ContextCompat.getDrawable(context, R.drawable.j9p);
        this.sendStateListener = new f();
    }

    private final void A(long msgId, Function0<Unit> block) {
        BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, Dispatchers.getMain(), null, new AIOVideoViewer$asyncRunInMain$1(msgId, this, block, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(AIOVideoViewer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(MsgRecord msgRecord, Function0<Unit> block) {
        A(msgRecord.msgId, block);
    }

    private final boolean B0() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean C0() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        PlayState s16 = baseVideoView.s();
        if (s16 != null && s16.isInPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        String e16 = this.videoParam.e();
        if (e16 != null) {
            if (e16.length() > 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (true == z26) {
                z17 = true;
                if (!z17) {
                    return true;
                }
                String[] d16 = this.videoParam.d();
                if (d16 != null) {
                    if (d16.length == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (true == (!z19)) {
                        z18 = true;
                        if (!z18) {
                            return true;
                        }
                        return false;
                    }
                }
                z18 = false;
                if (!z18) {
                }
            }
        }
        z17 = false;
        if (!z17) {
        }
    }

    private final boolean D() {
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        n nVar = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        boolean N2 = shortVideoMsgItem.N2();
        if (N2) {
            Drawable drawable = this.context.getDrawable(R.drawable.j9t);
            if (drawable != null) {
                BaseVideoView baseVideoView = this.videoView;
                if (baseVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    baseVideoView = null;
                }
                baseVideoView.setCoverImage(drawable);
            }
            n nVar2 = this.statusView;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
            } else {
                nVar = nVar2;
            }
            nVar.C();
        }
        return N2;
    }

    private final void D0() {
        final ActionSheet create = ActionSheet.create(this.context);
        create.addButton(R.string.f170283l9);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.r
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                AIOVideoViewer.E0(AIOVideoViewer.this, create, view, i3);
            }
        });
        create.show();
    }

    private final void E(ShortVideoMsgItem msgItem, RelativeLayout contentView) {
        z0(msgItem, contentView, false);
        this.stopWatch.e("setup video view");
        H0();
        int i3 = d.f192197a[msgItem.K2().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                I(msgItem);
                return;
            }
            return;
        }
        H(msgItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(AIOVideoViewer this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.o0();
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("create_player");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(ShortVideoMsgItem msgItem) {
        n nVar = this.statusView;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            nVar = null;
        }
        nVar.D();
        VideoElement E2 = msgItem.E2();
        G0(E2.fileSize, E2.fileTime);
    }

    private final com.tencent.mobileqq.qqnt.videoplay.api.param.c G(String fileID, String videoPath, long videoDuration) {
        com.tencent.mobileqq.qqnt.videoplay.api.param.c cVar = new com.tencent.mobileqq.qqnt.videoplay.api.param.c();
        cVar.g().e(fileID);
        cVar.m(101);
        cVar.n(by3.a.a(cVar.c()));
        cVar.l(true);
        cVar.a().h(true);
        cVar.a().i(true);
        cVar.a().g(true);
        cVar.a().l(true);
        cVar.p(videoPath);
        cVar.g().f(videoDuration);
        cVar.s(new c(this));
        return cVar;
    }

    private final void G0(long fileSize, int durationInSeconds) {
        S();
        if (fileSize == 0) {
            TextView textView = this.videoSizeView;
            if (textView != null) {
                textView.setVisibility(4);
            }
        } else {
            TextView textView2 = this.videoSizeView;
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setText(com.tencent.qqnt.aio.element.file.util.b.a(fileSize));
            }
        }
        if (durationInSeconds == 0) {
            TextView textView3 = this.videoDurationView;
            if (textView3 != null) {
                textView3.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView4 = this.videoDurationView;
        if (textView4 != null) {
            textView4.setVisibility(0);
            textView4.setText(AIOUtil.f194084a.I(durationInSeconds));
        }
    }

    private final void H(ShortVideoMsgItem msgItem) {
        MsgElement a16 = com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.a(msgItem);
        P(msgItem, a16);
        this.stopWatch.e("handle thumb");
        Q(msgItem, a16, false, false);
        this.stopWatch.e("handle video");
    }

    private final void H0() {
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        n nVar = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        if (shortVideoMsgItem.R2()) {
            return;
        }
        ShortVideoMsgItem shortVideoMsgItem2 = this.currentMsgItem;
        if (shortVideoMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem2 = null;
        }
        int R = shortVideoMsgItem2.R();
        if (R != 0) {
            if (R != 1) {
                if (R == 2 || R == 3) {
                    n nVar2 = this.statusView;
                    if (nVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("statusView");
                    } else {
                        nVar = nVar2;
                    }
                    nVar.h();
                    return;
                }
                return;
            }
            n nVar3 = this.statusView;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
            } else {
                nVar = nVar3;
            }
            nVar.r();
            return;
        }
        n nVar4 = this.statusView;
        if (nVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            nVar = nVar4;
        }
        nVar.q();
    }

    private final void I(ShortVideoMsgItem msgItem) {
        BaseVideoView baseVideoView = this.videoView;
        BaseVideoView baseVideoView2 = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        baseVideoView.setForbidStateCallBack(true);
        BaseVideoView baseVideoView3 = this.videoView;
        if (baseVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView3 = null;
        }
        baseVideoView3.A(false);
        n nVar = this.statusView;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            nVar = null;
        }
        nVar.D();
        R();
        String S2 = msgItem.S2();
        Bitmap decodeFile = BitmapFactory.decodeFile(S2);
        QLog.i("AIOVideoViewer", 1, "dealShotModel existThumbPath: " + S2);
        BaseVideoView baseVideoView4 = this.videoView;
        if (baseVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            baseVideoView2 = baseVideoView4;
        }
        baseVideoView2.setCoverImage(new BitmapDrawable(this.context.getResources(), decodeFile));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(final ShortVideoMsgItem msgItem, MsgElement msgElement, boolean manualDownload) {
        Long l3;
        int hashCode = hashCode();
        long msgId = msgItem.getMsgId();
        Long l16 = null;
        if (msgElement != null) {
            l3 = Long.valueOf(msgElement.elementId);
        } else {
            l3 = null;
        }
        X("[downloadVideo] this=" + hashCode + " msgId=" + msgId + " elementId=" + l3);
        n nVar = this.statusView;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            nVar = null;
        }
        nVar.k();
        if (!B0()) {
            msgItem.u2(manualDownload);
            return;
        }
        if (!TextUtils.isEmpty(msgItem.x2())) {
            int hashCode2 = hashCode();
            long msgId2 = msgItem.getMsgId();
            if (msgElement != null) {
                l16 = Long.valueOf(msgElement.elementId);
            }
            Y("[downloadVideo] play by cached url, this=" + hashCode2 + ", msgId=" + msgId2 + ", elementId=" + l16 + ", url=" + msgItem.x2() + ", videoCodecFormat=" + msgItem.w2());
            L(0, "", msgItem.x2(), msgItem.w2());
            return;
        }
        msgItem.V2(manualDownload, 1, new Function4<Integer, String, String, Integer, Unit>(msgItem) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$downloadVideo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ShortVideoMsgItem $msgItem;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
                this.$msgItem = msgItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOVideoViewer.this, (Object) msgItem);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2, Integer num2) {
                invoke(num.intValue(), str, str2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @Nullable String str, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, str, Integer.valueOf(i16));
                } else {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    AIOVideoViewer.this.B(this.$msgItem.getMsgRecord(), new Function0<Unit>(i3, errMsg, str, i16) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$downloadVideo$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String $errMsg;
                        final /* synthetic */ int $result;
                        final /* synthetic */ int $resultVideoCodecFormat;
                        final /* synthetic */ String $url;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$result = i3;
                            this.$errMsg = errMsg;
                            this.$url = str;
                            this.$resultVideoCodecFormat = i16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AIOVideoViewer.this, Integer.valueOf(i3), errMsg, str, Integer.valueOf(i16));
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
                                AIOVideoViewer.this.L(this.$result, this.$errMsg, this.$url, this.$resultVideoCodecFormat);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(AIOVideoViewer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseVideoView baseVideoView = this$0.videoView;
        BaseVideoView baseVideoView2 = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        PlayState s16 = baseVideoView.s();
        boolean z16 = false;
        if (s16 != null && s16.isPaused()) {
            z16 = true;
        }
        if (z16) {
            BaseVideoView baseVideoView3 = this$0.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView2 = baseVideoView3;
            }
            baseVideoView2.u();
            return;
        }
        if (!Q && this$0.isVideoViewLive) {
            BaseVideoView baseVideoView4 = this$0.videoView;
            if (baseVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView2 = baseVideoView4;
            }
            baseVideoView2.y();
        }
    }

    private final MsgElement K() {
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        return shortVideoMsgItem.y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int result, String errMsg, String url, int videoCodecFormat) {
        ShortVideoMsgItem shortVideoMsgItem;
        long j3;
        if (result == 0 && url != null) {
            ShortVideoMsgItem shortVideoMsgItem2 = this.currentMsgItem;
            if (shortVideoMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem2 = null;
            }
            long videoItemLimitTimeMills = ((IVideoCompressApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVideoCompressApi.class)).getVideoItemLimitTimeMills();
            int hashCode = hashCode();
            ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
            if (shortVideoMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem3 = null;
            }
            long msgId = shortVideoMsgItem3.getMsgId();
            ShortVideoMsgItem shortVideoMsgItem4 = this.currentMsgItem;
            if (shortVideoMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem4 = null;
            }
            String J2 = shortVideoMsgItem4.J2();
            ShortVideoMsgItem shortVideoMsgItem5 = this.currentMsgItem;
            if (shortVideoMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem5 = null;
            }
            String I2 = shortVideoMsgItem5.I2();
            ShortVideoMsgItem shortVideoMsgItem6 = this.currentMsgItem;
            if (shortVideoMsgItem6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem6 = null;
            }
            u a16 = shortVideoMsgItem6.z2().a();
            ShortVideoMsgItem shortVideoMsgItem7 = this.currentMsgItem;
            if (shortVideoMsgItem7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                j3 = videoItemLimitTimeMills;
                shortVideoMsgItem7 = null;
            } else {
                j3 = videoItemLimitTimeMills;
            }
            long F2 = shortVideoMsgItem7.F2();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[handleGetPlayUrl] play by url, view=");
            sb5.append(hashCode);
            sb5.append(" msgId=");
            sb5.append(msgId);
            sb5.append(" url=");
            sb5.append(url);
            sb5.append(" videoId=");
            sb5.append(J2);
            sb5.append(" path=");
            sb5.append(I2);
            sb5.append(", response videoCodecFormat=");
            sb5.append(videoCodecFormat);
            sb5.append(", after handle formatInfo=");
            sb5.append(a16);
            sb5.append(", videoFileTimeMills=");
            sb5.append(F2);
            sb5.append(", videoItemLimitTimeMills=");
            long j16 = j3;
            sb5.append(j16);
            X(sb5.toString());
            o oVar = o.f192253a;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            oVar.c(peekAppRuntime, shortVideoMsgItem2, videoCodecFormat);
            ShortVideoMsgItem shortVideoMsgItem8 = this.currentMsgItem;
            if (shortVideoMsgItem8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem8 = null;
            }
            com.tencent.mobileqq.qqnt.videoplay.api.param.c G = G(shortVideoMsgItem8.J2(), null, shortVideoMsgItem2.F2());
            G.l(false);
            G.q(shortVideoMsgItem2.I2());
            G.o(new String[]{url});
            G.r(new b(url, shortVideoMsgItem2));
            if (shortVideoMsgItem2.F2() > j16) {
                G.g().f(shortVideoMsgItem2.F2());
                G.a().k(j16);
            }
            k0(G);
            return;
        }
        int hashCode2 = hashCode();
        ShortVideoMsgItem shortVideoMsgItem9 = this.currentMsgItem;
        if (shortVideoMsgItem9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem9 = null;
        }
        X("[handleGetPlayUrl] failed to get url, view=" + hashCode2 + " msgId=" + shortVideoMsgItem9.getMsgId() + " err=" + result + "," + errMsg);
        ShortVideoMsgItem shortVideoMsgItem10 = this.currentMsgItem;
        if (shortVideoMsgItem10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        } else {
            shortVideoMsgItem = shortVideoMsgItem10;
        }
        F0(shortVideoMsgItem);
    }

    private final void N(final FileTransNotifyInfo fileInfo) {
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        final ShortVideoMsgItem shortVideoMsgItem2 = null;
        n nVar = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        if (shortVideoMsgItem.R2()) {
            Y("[handleRichMediaUI] isSelfLocalSendMsg");
            return;
        }
        if (fileInfo != null) {
            X("[handleRichMediaUI] view=" + hashCode() + " msgId=" + fileInfo.msgId + " fileInfo=" + fileInfo);
            int i3 = fileInfo.trasferStatus;
            if (i3 != 4) {
                if (i3 == 5) {
                    Y("[handleRichMediaUI] fail, view=" + hashCode() + ", msgId=" + fileInfo.msgId + ", elementId=" + fileInfo.msgElementId + ", downloadType=" + fileInfo.fileDownType + ", fileInfo=" + fileInfo);
                    if (fileInfo.fileDownType != 2) {
                        n nVar2 = this.statusView;
                        if (nVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("statusView");
                        } else {
                            nVar = nVar2;
                        }
                        nVar.z();
                        return;
                    }
                    return;
                }
                return;
            }
            Y("[handleRichMediaUI] success, view=" + hashCode() + " msgId=" + fileInfo.msgId + ", elementId=" + fileInfo.msgElementId + ", downloadType=" + fileInfo.fileDownType + ", path=" + fileInfo.filePath);
            ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
            if (shortVideoMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                shortVideoMsgItem2 = shortVideoMsgItem3;
            }
            t0(shortVideoMsgItem2, new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$handleRichMediaUI$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShortVideoMsgItem.this);
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
                    } else {
                        ShortVideoMsgItem.this.p2();
                        ShortVideoMsgItem.this.q2();
                    }
                }
            }, new Function0<Unit>(this, shortVideoMsgItem2) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer$handleRichMediaUI$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ShortVideoMsgItem $msgItem;
                final /* synthetic */ AIOVideoViewer this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    this.$msgItem = shortVideoMsgItem2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, FileTransNotifyInfo.this, this, shortVideoMsgItem2);
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
                    n nVar3 = null;
                    if (FileTransNotifyInfo.this.fileDownType != 2) {
                        n nVar4 = this.this$0.statusView;
                        if (nVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("statusView");
                        } else {
                            nVar3 = nVar4;
                        }
                        nVar3.u();
                        this.this$0.l0(this.$msgItem);
                        return;
                    }
                    AIOVideoViewer.y0(this.this$0, this.$msgItem, false, 2, null);
                }
            });
        }
    }

    private final void P(ShortVideoMsgItem msgItem, MsgElement msgElement) {
        Long l3;
        if (y0(this, msgItem, false, 2, null)) {
            X("[handleThumb] thumb exists, load it from local");
            return;
        }
        long msgId = msgItem.getMsgId();
        if (msgElement != null) {
            l3 = Long.valueOf(msgElement.elementId);
        } else {
            l3 = null;
        }
        Y("[handleThumb] start downloading thumb, msgId=" + msgId + ", elementId=" + l3);
        ShortVideoMsgItem.s2(msgItem, false, 1, null);
    }

    private final void Q(ShortVideoMsgItem msgItem, MsgElement msgElement, boolean forceDownload, boolean manualDownload) {
        boolean z16;
        Long l3;
        if (l0(msgItem) || D()) {
            return;
        }
        if (msgItem.I2().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Long l16 = null;
        if (z16) {
            long msgId = msgItem.getMsgId();
            if (msgElement != null) {
                l3 = Long.valueOf(msgElement.elementId);
            } else {
                l3 = null;
            }
            QLog.w("AIOVideoViewer", 1, "[handleVideo] video path is empty, msgId=" + msgId + ", elementId=" + l3);
            n nVar = this.statusView;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                nVar = null;
            }
            n.B(nVar, VideoErrorStatus.Failed, null, 2, null);
            return;
        }
        if (msgItem.U2() != null) {
            int hashCode = hashCode();
            long msgId2 = msgItem.getMsgId();
            if (msgElement != null) {
                l16 = Long.valueOf(msgElement.elementId);
            }
            Y("[downloadVideo] video file exists, just return. this=" + hashCode + " msgId=" + msgId2 + ", elementId=" + l16);
            return;
        }
        if (forceDownload) {
            J(msgItem, msgElement, manualDownload);
        } else if (com.tencent.mobileqq.aio.msglist.holder.component.video.d.INSTANCE.a()) {
            J(msgItem, msgElement, manualDownload);
        } else {
            com.tencent.qqnt.aio.predownload.video.strategy.g.f351871a.c(msgItem, true, new e(msgItem, msgElement, manualDownload));
        }
    }

    private final void R() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        baseVideoView.x(false);
    }

    private final void S() {
        BaseVideoView baseVideoView = null;
        if (this.videoSizeView == null) {
            TextView textView = new TextView(this.context);
            textView.setId(R.id.sji);
            textView.setTextSize(2, 12.0f);
            textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_allwhite_primary));
            this.videoSizeView = textView;
            RelativeLayout relativeLayout = this.contentView;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = com.tencent.mobileqq.aio.utils.p.b(7.0f);
            layoutParams.rightMargin = com.tencent.mobileqq.aio.utils.p.b(7.0f);
            layoutParams.bottomMargin = com.tencent.mobileqq.aio.utils.p.b(7.0f);
            BaseVideoView baseVideoView2 = this.videoView;
            if (baseVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView2 = null;
            }
            layoutParams.addRule(5, baseVideoView2.getId());
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView3 = null;
            }
            layoutParams.addRule(8, baseVideoView3.getId());
            Unit unit = Unit.INSTANCE;
            relativeLayout.addView(textView, layoutParams);
        }
        if (this.videoDurationView == null) {
            TextView textView2 = new TextView(this.context);
            textView2.setId(R.id.sjh);
            textView2.setTextSize(2, 12.0f);
            textView2.setTextColor(textView2.getContext().getColor(R.color.qui_common_text_allwhite_primary));
            this.videoDurationView = textView2;
            RelativeLayout relativeLayout2 = this.contentView;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = com.tencent.mobileqq.aio.utils.p.b(7.0f);
            layoutParams2.rightMargin = com.tencent.mobileqq.aio.utils.p.b(7.0f);
            layoutParams2.bottomMargin = com.tencent.mobileqq.aio.utils.p.b(7.0f);
            BaseVideoView baseVideoView4 = this.videoView;
            if (baseVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView4 = null;
            }
            layoutParams2.addRule(7, baseVideoView4.getId());
            BaseVideoView baseVideoView5 = this.videoView;
            if (baseVideoView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView = baseVideoView5;
            }
            layoutParams2.addRule(8, baseVideoView.getId());
            Unit unit2 = Unit.INSTANCE;
            relativeLayout2.addView(textView2, layoutParams2);
        }
    }

    private final boolean T() {
        return com.tencent.mobileqq.aio.msglist.holder.component.video.d.INSTANCE.b();
    }

    private final boolean U(ShortVideoMsgItem msgItem) {
        if (!msgItem.K0() || !msgItem.R2()) {
            return false;
        }
        if (msgItem.P2()) {
            Y("[isSendingVideo] send complete, view=" + hashCode() + " msgId=" + msgItem.getMsgId());
            return false;
        }
        msgItem.L2();
        QLog.i("AIOVideoViewer", 1, "[isSendingVideo] is sending, set listener, view=" + hashCode() + " msgId=" + msgItem.getMsgId() + " msgStatus=" + msgItem.getMsgRecord().sendStatus);
        z0(msgItem, this.contentView, true);
        return AIOVideoSendingManager.INSTANCE.e().N(msgItem, false, this.sendStateListener);
    }

    private final void V(String thumbPath) {
        if (thumbPath == null) {
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        BaseVideoView baseVideoView2 = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        ImageView p16 = baseVideoView.p();
        if (p16 != null) {
            p16.setTag(R.id.f24840_8, Long.valueOf(K().elementId));
        }
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Option obtain = Option.obtain();
        obtain.setUrl(thumbPath);
        BaseVideoView baseVideoView3 = this.videoView;
        if (baseVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            baseVideoView2 = baseVideoView3;
        }
        obtain.setTargetView(baseVideoView2.p());
        obtain.setLoadingDrawable(new ColorDrawable());
        obtain.setFailedDrawable(this.backgroundDrawable);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026undDrawable\n            }");
        iPicAIOApi.loadPic(obtain, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.t
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                AIOVideoViewer.W(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(String msg2) {
        if (QLog.isColorLevel()) {
            QLog.i("AIOVideoViewer", 1, msg2);
        }
    }

    private final void Y(String msg2) {
        QLog.i("AIOVideoViewer", 1, msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("buffering_end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("buffering_start");
        }
    }

    private final void b0() {
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        ShortVideoMsgItem shortVideoMsgItem2 = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        if (shortVideoMsgItem.P2()) {
            return;
        }
        ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
        if (shortVideoMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            shortVideoMsgItem2 = shortVideoMsgItem3;
        }
        long msgId = shortVideoMsgItem2.getMsgId();
        AIOVideoSendingManager.Companion companion = AIOVideoSendingManager.INSTANCE;
        if (companion.e().E(msgId)) {
            companion.e().o(msgId);
        } else {
            D0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.mobileqq.qqnt.videoplay.api.component.BaseVideoView] */
    private final void c0() {
        com.tencent.mobileqq.aio.msglist.holder.component.video.c cVar = com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a;
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        ShortVideoMsgItem shortVideoMsgItem2 = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        MsgElement a16 = cVar.a(shortVideoMsgItem);
        ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
        if (shortVideoMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem3 = null;
        }
        if (shortVideoMsgItem3.R2()) {
            ShortVideoMsgItem shortVideoMsgItem4 = this.currentMsgItem;
            if (shortVideoMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem4 = null;
            }
            if (!shortVideoMsgItem4.P2()) {
                ShortVideoMsgItem shortVideoMsgItem5 = this.currentMsgItem;
                if (shortVideoMsgItem5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    shortVideoMsgItem5 = null;
                }
                long msgId = shortVideoMsgItem5.getMsgId();
                ShortVideoMsgItem shortVideoMsgItem6 = this.currentMsgItem;
                if (shortVideoMsgItem6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    shortVideoMsgItem6 = null;
                }
                QLog.i("AIOVideoViewer", 1, "[onClickVideoView], is sending or send fail, do nothing msgId=" + msgId + ", status=" + shortVideoMsgItem6.R());
                ShortVideoMsgItem shortVideoMsgItem7 = this.currentMsgItem;
                if (shortVideoMsgItem7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    shortVideoMsgItem2 = shortVideoMsgItem7;
                }
                if (shortVideoMsgItem2.Q2()) {
                    return;
                }
                Context context = this.context;
                QQToast.makeText(context, context.getResources().getString(R.string.vrn), 0).show(com.tencent.mobileqq.aio.utils.p.c(44));
                return;
            }
        }
        ShortVideoMsgItem shortVideoMsgItem8 = this.currentMsgItem;
        if (shortVideoMsgItem8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem8 = null;
        }
        long msgId2 = shortVideoMsgItem8.getMsgId();
        ShortVideoMsgItem shortVideoMsgItem9 = this.currentMsgItem;
        if (shortVideoMsgItem9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem9 = null;
        }
        QLog.i("AIOVideoViewer", 1, "[onClickVideoView], handle video msgId=" + msgId2 + " status=" + shortVideoMsgItem9.R());
        ShortVideoMsgItem shortVideoMsgItem10 = this.currentMsgItem;
        if (shortVideoMsgItem10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem10 = null;
        }
        Q(shortVideoMsgItem10, a16, AppNetConnInfo.isWifiConn(), true);
        Function4<Context, ShortVideoMsgItem, View, Long, Unit> function4 = this.listener;
        Context context2 = this.context;
        ShortVideoMsgItem shortVideoMsgItem11 = this.currentMsgItem;
        if (shortVideoMsgItem11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem11 = null;
        }
        ?? r26 = this.videoView;
        if (r26 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            shortVideoMsgItem2 = r26;
        }
        function4.invoke(context2, shortVideoMsgItem11, shortVideoMsgItem2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("first_frame_rendered");
        }
        com.tencent.qqnt.aio.video.a aVar2 = this.videoPlayReport;
        if (aVar2 != null) {
            ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
            ShortVideoMsgItem shortVideoMsgItem2 = null;
            if (shortVideoMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem = null;
            }
            ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
            if (shortVideoMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem3 = null;
            }
            String str = shortVideoMsgItem3.E2().filePath;
            Intrinsics.checkNotNullExpressionValue(str, "currentMsgItem.videoElement.filePath");
            ShortVideoMsgItem shortVideoMsgItem4 = this.currentMsgItem;
            if (shortVideoMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                shortVideoMsgItem2 = shortVideoMsgItem4;
            }
            aVar2.j(shortVideoMsgItem, str, shortVideoMsgItem2.E2().sourceVideoCodecFormat.toString(), "0", "0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.k();
        }
        com.tencent.qqnt.aio.video.a aVar2 = this.videoPlayReport;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.videoPlayReport = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(int code, String msg2) {
        BaseVideoView baseVideoView = this.videoView;
        n nVar = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        Object tag = baseVideoView.getTag();
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        if (!Intrinsics.areEqual(tag, Long.valueOf(shortVideoMsgItem.getMsgId()))) {
            return;
        }
        this.videoPlayErrorCode = code;
        ShortVideoMsgItem shortVideoMsgItem2 = this.currentMsgItem;
        if (shortVideoMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem2 = null;
        }
        QLog.i("AIOVideoViewer", 1, "[onPlayError] msgId=" + shortVideoMsgItem2.getMsgId() + " code=" + code + " msg=" + msg2);
        if (code == 14011001) {
            n nVar2 = this.statusView;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
            } else {
                nVar = nVar2;
            }
            nVar.A(VideoErrorStatus.Expired, msg2);
        } else {
            n nVar3 = this.statusView;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
            } else {
                nVar = nVar3;
            }
            nVar.D();
        }
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i("error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        BaseVideoView baseVideoView = this.videoView;
        ShortVideoMsgItem shortVideoMsgItem = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        Object tag = baseVideoView.getTag();
        ShortVideoMsgItem shortVideoMsgItem2 = this.currentMsgItem;
        if (shortVideoMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            shortVideoMsgItem = shortVideoMsgItem2;
        }
        if (!Intrinsics.areEqual(tag, Long.valueOf(shortVideoMsgItem.getMsgId()))) {
            return;
        }
        this.videoPlayPrepared = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        BaseVideoView baseVideoView = this.videoView;
        ShortVideoMsgItem shortVideoMsgItem = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        Object tag = baseVideoView.getTag();
        ShortVideoMsgItem shortVideoMsgItem2 = this.currentMsgItem;
        if (shortVideoMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            shortVideoMsgItem = shortVideoMsgItem2;
        }
        if (!Intrinsics.areEqual(tag, Long.valueOf(shortVideoMsgItem.getMsgId()))) {
            return;
        }
        if (!this.videoParam.b() && this.videoPlayPrepared) {
            n0();
        }
        this.videoPlayPrepared = false;
        this.videoPlayErrorCode = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        BaseVideoView baseVideoView = this.videoView;
        n nVar = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        baseVideoView.setVideoViewVisibility(0);
        n nVar2 = this.statusView;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            nVar = nVar2;
        }
        nVar.i();
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
        if (aVar != null) {
            aVar.i(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
        }
    }

    private final void k0(com.tencent.mobileqq.qqnt.videoplay.api.param.c newParam) {
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        BaseVideoView baseVideoView = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        Y("playVideo msgId=" + shortVideoMsgItem.getMsgId() + ", isVideoViewLive: " + this.isVideoViewLive);
        n nVar = this.statusView;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            nVar = null;
        }
        nVar.i();
        q0();
        this.videoParam = newParam;
        BaseVideoView baseVideoView2 = this.videoView;
        if (baseVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView2 = null;
        }
        baseVideoView2.setVideoParam(this.videoParam);
        if (!T()) {
            Y("playVideo, but is not enter aio, do not play");
            return;
        }
        if (this.isVideoViewLive) {
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView = baseVideoView3;
            }
            baseVideoView.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l0(ShortVideoMsgItem msgItem) {
        return m0(msgItem.U2(), msgItem.F2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m0(String newVideoPath, long videoDuration) {
        BaseVideoView baseVideoView;
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        BaseVideoView baseVideoView2 = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        long msgId = shortVideoMsgItem.getMsgId();
        boolean z16 = false;
        if (newVideoPath == null) {
            int hashCode = hashCode();
            ShortVideoMsgItem shortVideoMsgItem2 = this.currentMsgItem;
            if (shortVideoMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem2 = null;
            }
            X("[playVideo] video path is empty, this=" + hashCode + " msgId=" + msgId + " sourceVideoCodecFormat=" + shortVideoMsgItem2.E2().sourceVideoCodecFormat);
            this.videoParam = G(null, "", videoDuration);
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView3 = null;
            }
            baseVideoView3.setVideoParam(this.videoParam);
            BaseVideoView baseVideoView4 = this.videoView;
            if (baseVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView2 = baseVideoView4;
            }
            baseVideoView2.A(false);
            return false;
        }
        if (newVideoPath.length() > 0) {
            z16 = true;
        }
        if (z16 && Intrinsics.areEqual(newVideoPath, this.videoParam.e())) {
            int hashCode2 = hashCode();
            ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
            if (shortVideoMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem3 = null;
            }
            X("[playVideo] resume playing, this=" + hashCode2 + ", path=" + newVideoPath + " msgId=" + msgId + " videoCodecFormat=" + shortVideoMsgItem3.E2().sourceVideoCodecFormat);
            BaseVideoView baseVideoView5 = this.videoView;
            if (baseVideoView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView2 = baseVideoView5;
            }
            s0(baseVideoView2);
            return true;
        }
        int hashCode3 = hashCode();
        String e16 = this.videoParam.e();
        ShortVideoMsgItem shortVideoMsgItem4 = this.currentMsgItem;
        if (shortVideoMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem4 = null;
        }
        X("[playVideo] switch video, this=" + hashCode3 + " msgId=" + msgId + " path=" + e16 + "->" + newVideoPath + " videoCodecFormat=" + shortVideoMsgItem4.E2().sourceVideoCodecFormat);
        ShortVideoMsgItem shortVideoMsgItem5 = this.currentMsgItem;
        if (shortVideoMsgItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem5 = null;
        }
        this.videoParam = G(shortVideoMsgItem5.J2(), newVideoPath, videoDuration);
        BaseVideoView baseVideoView6 = this.videoView;
        if (baseVideoView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView6 = null;
        }
        baseVideoView6.setVideoParam(this.videoParam);
        BaseVideoView baseVideoView7 = this.videoView;
        if (baseVideoView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        } else {
            baseVideoView = baseVideoView7;
        }
        r0(baseVideoView);
        return true;
    }

    private final void n0() {
        String str;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("nt_platform", "Android");
        hashMap.put("nt_app", "MobileQQ");
        String reportVersionName = com.tencent.qqnt.util.b.f362976b.getReportVersionName();
        Intrinsics.checkNotNullExpressionValue(reportVersionName, "AppSettingUtil.reportVersionName");
        hashMap.put("nt_app_version", reportVersionName);
        hashMap.put("nt_module", "nt_rich");
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        if (shortVideoMsgItem.p0() == 2) {
            str = "GroupVideo";
        } else {
            ShortVideoMsgItem shortVideoMsgItem2 = this.currentMsgItem;
            if (shortVideoMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem2 = null;
            }
            if (shortVideoMsgItem2.p0() == 1) {
                str = "C2CVideo";
            } else {
                str = "Unkonw";
            }
        }
        hashMap.put("nt_rich_biz_type", str);
        hashMap.put("nt_rich_transfer_type", "PlayOnline");
        hashMap.put("nt_rich_down_thumb_type", "Ori");
        ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
        if (shortVideoMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem3 = null;
        }
        if (shortVideoMsgItem3.E2().busiType == 0) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("nt_rich_is_long_video", str2);
        hashMap.put("nt_rich_err_code", String.valueOf(this.videoPlayErrorCode));
        int a16 = ap.f194113a.a();
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 != 3) {
                    if (a16 != 4) {
                        if (a16 != 6) {
                            str3 = "Unreach";
                        } else {
                            str3 = "5G";
                        }
                    } else {
                        str3 = "4G";
                    }
                } else {
                    str3 = "3G";
                }
            } else {
                str3 = "2G";
            }
        } else {
            str3 = "WiFi";
        }
        hashMap.put("nt_rich_net_status", str3);
        hashMap.put("nt_rich_scene", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
        BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, Dispatchers.getIO(), null, new AIOVideoViewer$reportVideoPlayEnd$1(hashMap, null), 2, null);
    }

    private final void o0() {
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        ShortVideoMsgItem shortVideoMsgItem2 = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        if (shortVideoMsgItem.R2()) {
            AIOVideoSendingManager e16 = AIOVideoSendingManager.INSTANCE.e();
            ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
            if (shortVideoMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                shortVideoMsgItem2 = shortVideoMsgItem3;
            }
            e16.N(shortVideoMsgItem2, true, this.sendStateListener);
            return;
        }
        k kVar = k.f192240a;
        ShortVideoMsgItem shortVideoMsgItem4 = this.currentMsgItem;
        if (shortVideoMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem4 = null;
        }
        MsgRecord msgRecord = shortVideoMsgItem4.getMsgRecord();
        ShortVideoMsgItem shortVideoMsgItem5 = this.currentMsgItem;
        if (shortVideoMsgItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            shortVideoMsgItem2 = shortVideoMsgItem5;
        }
        kVar.j(msgRecord, shortVideoMsgItem2.v());
    }

    private final void p0() {
        R();
        n nVar = this.statusView;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            nVar = null;
        }
        nVar.w();
        q0();
    }

    private final void q0() {
        TextView textView = this.videoSizeView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        TextView textView2 = this.videoDurationView;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
    }

    private final void r0(BaseVideoView videoView) {
        boolean z16 = Q;
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        X("restartPlaying sPauseVideo: " + z16 + " msgId=" + shortVideoMsgItem.getMsgId() + ", isVideoViewLive: " + this.isVideoViewLive);
        if (!Q) {
            videoView.A(false);
            if (this.isVideoViewLive) {
                videoView.y();
            }
        }
    }

    private final void s0(BaseVideoView videoView) {
        boolean z16;
        boolean z17 = true;
        videoView.x(true);
        PlayState s16 = videoView.s();
        if (s16 != null && s16.isInPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
            if (shortVideoMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem = null;
            }
            Y("resumePlayingVideo isInPlaying: msgId=" + shortVideoMsgItem.getMsgId());
            return;
        }
        PlayState s17 = videoView.s();
        if (s17 == null || !s17.isPaused()) {
            z17 = false;
        }
        if (z17) {
            videoView.u();
        } else {
            r0(videoView);
        }
    }

    private final void t0(AIOMsgItem msgItem, Function0<Unit> work, Function0<Unit> updateUI) {
        BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, Dispatchers.getIO(), null, new AIOVideoViewer$runAsyncTask$1(work, msgItem, this, updateUI, null), 2, null);
    }

    private final void u0(BaseVideoView videoView) {
        videoView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOVideoViewer.v0(AIOVideoViewer.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(AIOVideoViewer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean x0(ShortVideoMsgItem msgItem, boolean checkThumb) {
        BaseVideoView baseVideoView = this.videoView;
        BaseVideoView baseVideoView2 = null;
        if (baseVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView = null;
        }
        if (baseVideoView.s() != PlayState.STATE_PLAYING) {
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView3 = null;
            }
            if (baseVideoView3.s() != PlayState.STATE_PAUSE) {
                BaseVideoView baseVideoView4 = this.videoView;
                if (baseVideoView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                } else {
                    baseVideoView2 = baseVideoView4;
                }
                baseVideoView2.setCoverImage(new ColorDrawable(0));
                String S2 = msgItem.S2();
                if (S2 == null && !checkThumb) {
                    QLog.i("AIOVideoViewer", 1, "[setVideoCover] thumb not exists, msgId=" + msgItem.getMsgId());
                    return false;
                }
                V(S2);
                return true;
            }
        }
        long msgId = msgItem.getMsgId();
        BaseVideoView baseVideoView5 = this.videoView;
        if (baseVideoView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView5 = null;
        }
        QLog.i("AIOVideoViewer", 1, "[setVideoCover] video is playing or pause, msgId=" + msgId + ", playState=" + baseVideoView5.s() + ", isSelf=" + msgItem.isSelf() + ", msgSendStatus=" + msgItem.R());
        if (msgItem.isSelf() && msgItem.Q2()) {
            BaseVideoView baseVideoView6 = this.videoView;
            if (baseVideoView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView2 = baseVideoView6;
            }
            baseVideoView2.setCoverImage(new ColorDrawable(0));
            V(msgItem.S2());
        }
        return !TextUtils.isEmpty(msgItem.S2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean y0(AIOVideoViewer aIOVideoViewer, ShortVideoMsgItem shortVideoMsgItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return aIOVideoViewer.x0(shortVideoMsgItem, z16);
    }

    private final void z0(ShortVideoMsgItem msgItem, RelativeLayout contentView, boolean sendingVideo) {
        BaseVideoView baseVideoView = null;
        if (this.videoView == null) {
            String U2 = msgItem.U2();
            if (U2 == null) {
                U2 = "";
            }
            this.videoParam.p(U2);
            this.videoParam.g().f(msgItem.F2());
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            BaseVideoView baseVideoView2 = new BaseVideoView(context, this.videoParam, this.lifecycleScope, true, true, true, 10.0f);
            this.videoView = baseVideoView2;
            baseVideoView2.setId(R.id.kso);
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView3 = null;
            }
            baseVideoView3.setMuteClickCallback(this.muteChangedListener);
            BaseVideoView baseVideoView4 = this.videoView;
            if (baseVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView4 = null;
            }
            u0(baseVideoView4);
            contentView.removeAllViews();
            BaseVideoView baseVideoView5 = this.videoView;
            if (baseVideoView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView5 = null;
            }
            contentView.addView(baseVideoView5);
            this.statusView = new n(contentView);
            X("[setupVideoView] view=" + hashCode() + ", msgId=" + msgItem.getMsgId() + ", path=" + U2);
        }
        n nVar = this.statusView;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            nVar = null;
        }
        if (sendingVideo) {
            nVar.f(msgItem.i2());
        }
        if (msgItem.isSelf()) {
            nVar.l();
        }
        nVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOVideoViewer.A0(AIOVideoViewer.this, view);
            }
        });
        Pair<Integer, Integer> k3 = com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.k(msgItem.getMsgRecord());
        int intValue = k3.component1().intValue();
        int intValue2 = k3.component2().intValue();
        BaseVideoView baseVideoView6 = this.videoView;
        if (baseVideoView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView6 = null;
        }
        baseVideoView6.setTag(Long.valueOf(msgItem.getMsgId()));
        BaseVideoView baseVideoView7 = this.videoView;
        if (baseVideoView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView7 = null;
        }
        baseVideoView7.setLayoutParams(new RelativeLayout.LayoutParams(intValue, intValue2));
        BaseVideoView baseVideoView8 = this.videoView;
        if (baseVideoView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            baseVideoView8 = null;
        }
        baseVideoView8.setLayoutDirection(0);
        BaseVideoView baseVideoView9 = this.videoView;
        if (baseVideoView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            baseVideoView = baseVideoView9;
        }
        baseVideoView.setVideoViewVisibility(8);
    }

    public final void C(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        this.stopWatch.i();
        if (this.currentMsgItem == null) {
            X("[bind] first bind, this=" + hashCode() + ", msgId=" + msgItem.getMsgId());
        } else {
            int hashCode = hashCode();
            ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
            if (shortVideoMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem = null;
            }
            X("[bind] reuse, this=" + hashCode + ", msgId=" + shortVideoMsgItem.getMsgId() + "->" + msgItem.getMsgId() + "}");
            p0();
            com.tencent.qqnt.aio.video.a aVar = this.videoPlayReport;
            if (aVar != null) {
                aVar.b();
            }
            this.videoPlayReport = null;
        }
        this.stopWatch.e("reset ui");
        this.isVideoViewLive = true;
        SimpleEventBus.getInstance().registerReceiver(this);
        ShortVideoMsgItem shortVideoMsgItem2 = (ShortVideoMsgItem) msgItem;
        this.currentMsgItem = shortVideoMsgItem2;
        this.videoPlayReport = new com.tencent.qqnt.aio.video.a();
        if (U(shortVideoMsgItem2)) {
            x0(shortVideoMsgItem2, true);
            m0(null, 0L);
        } else {
            E(shortVideoMsgItem2, this.contentView);
        }
        this.stopWatch.b("bind");
    }

    public final void I0(boolean pause) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, pause);
            return;
        }
        BaseVideoView baseVideoView = null;
        if (pause) {
            BaseVideoView baseVideoView2 = this.videoView;
            if (baseVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView = baseVideoView2;
            }
            baseVideoView.t();
            return;
        }
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        long msgId = shortVideoMsgItem.getMsgId();
        BaseVideoView baseVideoView3 = this.videoView;
        if (baseVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            baseVideoView = baseVideoView3;
        }
        X("updateVideoPlayState msgId=" + msgId + " playState=" + baseVideoView.s() + ", isVideoViewLive=" + this.isVideoViewLive);
        if (C0()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.p
                @Override // java.lang.Runnable
                public final void run() {
                    AIOVideoViewer.J0(AIOVideoViewer.this);
                }
            }, 300L);
        }
    }

    public final void M(@NotNull a.aw payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) payload);
        } else {
            Intrinsics.checkNotNullParameter(payload, "payload");
            N(payload.a());
        }
    }

    public final void O(@NotNull a.ay payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) payload);
            return;
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
        ShortVideoMsgItem shortVideoMsgItem2 = null;
        if (shortVideoMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem = null;
        }
        long msgId = shortVideoMsgItem.getMsgId();
        ShortVideoMsgItem shortVideoMsgItem3 = this.currentMsgItem;
        if (shortVideoMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            shortVideoMsgItem3 = null;
        }
        QLog.i("AIOVideoViewer", 1, "[updateMsgSendStatus] msgId=" + msgId + " status=" + shortVideoMsgItem3.R() + "->" + payload.a());
        ShortVideoMsgItem shortVideoMsgItem4 = this.currentMsgItem;
        if (shortVideoMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            shortVideoMsgItem2 = shortVideoMsgItem4;
        }
        shortVideoMsgItem2.b3(payload.a());
        H0();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ConfigurationChangedEvent.class);
        return arrayList;
    }

    public final void onDestroy() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        n nVar = null;
        if (this.videoView != null) {
            ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
            if (shortVideoMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem = null;
            }
            X("[onDestroy] msgId=" + shortVideoMsgItem.getMsgId());
            this.isVideoViewLive = false;
            BaseVideoView baseVideoView = this.videoView;
            if (baseVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView = null;
            }
            baseVideoView.setMuteClickCallback(null);
            BaseVideoView baseVideoView2 = this.videoView;
            if (baseVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView2 = null;
            }
            baseVideoView2.setOnClickListener(null);
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView3 = null;
            }
            baseVideoView3.A(false);
            BaseVideoView baseVideoView4 = this.videoView;
            if (baseVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView4 = null;
            }
            baseVideoView4.n();
            BaseVideoView baseVideoView5 = this.videoView;
            if (baseVideoView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView5 = null;
            }
            ViewParent parent = baseVideoView5.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                BaseVideoView baseVideoView6 = this.videoView;
                if (baseVideoView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    baseVideoView6 = null;
                }
                viewGroup.removeView(baseVideoView6);
            }
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        n nVar2 = this.statusView;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            nVar = nVar2;
        }
        nVar.n();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        if ((event instanceof ConfigurationChangedEvent) && this.isVideoViewLive) {
            ShortVideoMsgItem shortVideoMsgItem = this.currentMsgItem;
            BaseVideoView baseVideoView = null;
            if (shortVideoMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                shortVideoMsgItem = null;
            }
            Y("[onReceiveEvent] msgId=" + shortVideoMsgItem.getMsgId() + " pausePlay()");
            BaseVideoView baseVideoView2 = this.videoView;
            if (baseVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView2 = null;
            }
            baseVideoView2.t();
            BaseVideoView baseVideoView3 = this.videoView;
            if (baseVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                baseVideoView = baseVideoView3;
            }
            baseVideoView.p().setVisibility(0);
        }
    }

    public final void w0(boolean isMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isMute);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            if (baseVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                baseVideoView = null;
            }
            baseVideoView.setMute(isMute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(LoadState loadState, Option option) {
    }
}
