package com.tencent.guild.aio.msglist.video;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.tool.a;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.aio.util.x;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqnt.videoplay.api.view.NTAIOBubbleVideoView;
import com.tencent.mobileqq.qqnt.videoplay.player.PlayState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IRichMediaService;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.element_ext_buf_for_ui$ElementExtBufForUI;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0082\u00012\u00020\u0001:\u0001IB\u00c8\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010R\u001a\u00020M\u0012`\u0010^\u001a\\\u0012\u0013\u0012\u00110M\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(R\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110V\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(W\u0012\u0013\u0012\u00110X\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020\u00040S\u0012K\u0010e\u001aG\u0012\u0013\u0012\u00110M\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(R\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\u00040_\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u0004H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\"\u00101\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u000bH\u0002J*\u00103\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\u0012\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105H\u0002J\u0012\u00108\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*H\u0002J\b\u00109\u001a\u00020\u0004H\u0002J\b\u0010;\u001a\u00020:H\u0002J\u0006\u0010<\u001a\u00020\u001aJ\u000e\u0010=\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010>\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020\u0004J\u0016\u0010C\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bJ\u0006\u0010D\u001a\u00020\u0004J\u0016\u0010G\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u0001J\u0006\u0010H\u001a\u00020\u0004R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010R\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QRq\u0010^\u001a\\\u0012\u0013\u0012\u00110M\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(R\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110V\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(W\u0012\u0013\u0012\u00110X\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020\u00040S8\u0006\u00a2\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\\\u0010e\u001aG\u0012\u0013\u0012\u00110M\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(R\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\bT\u0012\b\bU\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\u00040_8\u0006\u00a2\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010W\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010u\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010}\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010cR\u0014\u0010\u007f\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010J\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer;", "", "", "sendStatus", "", "i0", "Ltencent/im/msg/element_ext_buf_for_ui$ElementExtBufForUI;", "extBufForUI", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "P", "", CustomImageProps.QUALITY, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "percent", "y", "w", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/guild/api/video/IGuildVideoApi;", "m0", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "K", "J", "Landroid/view/ViewGroup;", "contentView", "videoPath", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setDefaultDrawable", "a0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c0", "h0", "showPlayIcon", "W", "V", "show", "e0", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "d0", "f0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "isGuest", "E", "fromClick", UserInfo.SEX_FEMALE, "X", "Lcom/tencent/guild/api/data/msglist/b$f;", "statusPayload", "O", "N", "v", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", BdhLogUtil.LogTag.Tag_Conn, "D", "u", "L", "M", "j0", "pause", "mute", "k0", "T", "msg", "payload", "g0", "U", "a", "Landroid/view/ViewGroup;", "G", "()Landroid/view/ViewGroup;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "H", "()Landroid/content/Context;", "context", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "videoView", "", "playPos", "c", "Lkotlin/jvm/functions/Function4;", "getListener", "()Lkotlin/jvm/functions/Function4;", "listener", "Lkotlin/Function3;", "sendType", "d", "Lkotlin/jvm/functions/Function3;", "I", "()Lkotlin/jvm/functions/Function3;", "msgSendListener", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "f", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "videoParam", "Lcom/tencent/mobileqq/qqnt/videoplay/api/view/NTAIOBubbleVideoView;", "g", "Lcom/tencent/mobileqq/qqnt/videoplay/api/view/NTAIOBubbleVideoView;", tl.h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/guild/api/video/IGuildVideoApi$b;", "j", "Lcom/tencent/guild/api/video/IGuildVideoApi$b;", "compressListener", "k", "Ltencent/im/msg/element_ext_buf_for_ui$ElementExtBufForUI;", "l", "msgSendStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "binding", "<init>", "(Landroid/view/ViewGroup;Landroid/content/Context;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;)V", DomainData.DOMAIN_NAME, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildVideoViewer {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: o, reason: collision with root package name */
    private static boolean f111961o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup contentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function4<Context, MsgRecord, View, Long, Unit> listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<Context, MsgRecord, Integer, Unit> msgSendListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqnt.videoplay.api.param.c videoParam;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NTAIOBubbleVideoView videoView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgElement element;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGuildVideoApi.b compressListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private element_ext_buf_for_ui$ElementExtBufForUI extBufForUI;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int msgSendStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/msglist/video/GuildVideoViewer$a;", "", "", "b", "a", "", "COMPRESS_CANCEL", "I", "COMPRESS_SUCCESS", "", "DELAY_START_PLAY_AFTER_SCROLL", "J", "", "EXPIRE_TEXT_MARGIN_DP", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "USER_SEND_RAW", "VIDEO_SIZE_LIMIT", "", "sPause", "Z", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.video.GuildVideoViewer$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            GuildVideoViewer.f111961o = false;
        }

        public final void b() {
            GuildVideoViewer.f111961o = true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/guild/aio/msglist/video/GuildVideoViewer$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f111975d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildVideoViewer f111976e;

        b(GuildMsgItem guildMsgItem, GuildVideoViewer guildVideoViewer) {
            this.f111975d = guildMsgItem;
            this.f111976e = guildVideoViewer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            QLog.i("GuildVideoViewer", 1, "onViewAttachedToWindow, msgId: " + this.f111975d.getMsgId());
            this.f111976e.k0(false, false);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/msglist/video/GuildVideoViewer$c", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/g;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.mobileqq.qqnt.videoplay.api.param.g {
        c() {
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.g
        public boolean a() {
            QLog.i("GuildVideoViewer", 1, "needStartPlayWhenSDKInited: " + (!GuildVideoViewer.f111961o));
            return !GuildVideoViewer.f111961o;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildVideoViewer(@NotNull ViewGroup contentView, @NotNull Context context, @NotNull Function4<? super Context, ? super MsgRecord, ? super View, ? super Long, Unit> listener, @NotNull Function3<? super Context, ? super MsgRecord, ? super Integer, Unit> msgSendListener) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(msgSendListener, "msgSendListener");
        this.contentView = contentView;
        this.context = context;
        this.listener = listener;
        this.msgSendListener = msgSendListener;
        Object context2 = contentView.getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        this.lifecycleOwner = (LifecycleOwner) context2;
        this.videoParam = C();
        this.extBufForUI = new element_ext_buf_for_ui$ElementExtBufForUI();
        this.msgSendStatus = -1;
        this.binding = D();
    }

    private final void A(GuildMsgItem msgItem, ViewGroup contentView, String videoPath) {
        boolean z16;
        NTAIOBubbleVideoView nTAIOBubbleVideoView;
        boolean z17;
        Long l3;
        if (QLog.isColorLevel()) {
            QLog.d("GuildVideoViewer", 2, "createContentView, " + hashCode() + ", msgSeq: " + msgItem.getMsgSeq());
        }
        this.videoParam.p(videoPath);
        MsgElement msgElement = this.element;
        if (msgElement != null) {
            VideoElement videoElement = msgElement.videoElement;
            if (videoElement != null && videoElement.fileTime == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                com.tencent.mobileqq.qqnt.videoplay.api.param.d g16 = this.videoParam.g();
                if (msgElement.videoElement != null) {
                    l3 = Long.valueOf(r15.fileTime);
                } else {
                    l3 = null;
                }
                Intrinsics.checkNotNull(l3);
                g16.f(l3.longValue());
                com.tencent.mobileqq.qqnt.videoplay.api.param.d g17 = this.videoParam.g();
                g17.f(g17.c() * 1000);
            } else {
                this.videoParam.g().f(0L);
            }
        }
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        NTAIOBubbleVideoView nTAIOBubbleVideoView2 = new NTAIOBubbleVideoView(context);
        BaseApplication context2 = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        nTAIOBubbleVideoView2.f(context2, this.videoParam, false, LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), null);
        if (msgItem.getRadii().length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !msgItem.isMixMsg()) {
            nTAIOBubbleVideoView2.setRadii(msgItem.getRadii());
        } else {
            nTAIOBubbleVideoView2.setRadius(6.0f);
        }
        nTAIOBubbleVideoView2.setDrawSharpCorner(false, msgItem.isSelf());
        Pair<Integer, Integer> e16 = a.f111981a.e(msgItem);
        int intValue = e16.component1().intValue();
        int intValue2 = e16.component2().intValue();
        contentView.removeAllViews();
        contentView.addView(nTAIOBubbleVideoView2, intValue, intValue2);
        nTAIOBubbleVideoView2.setContentDescription(nTAIOBubbleVideoView2.getContext().getString(R.string.f1385909z));
        nTAIOBubbleVideoView2.addOnAttachStateChangeListener(new b(msgItem, this));
        this.videoView = nTAIOBubbleVideoView2;
        X();
        View view = this.binding;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        view.setLayoutParams(layoutParams);
        contentView.addView(view);
        TextView textView = new TextView(contentView.getContext());
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        a.Companion companion = com.tencent.aio.base.tool.a.INSTANCE;
        Context context3 = contentView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "contentView.context");
        layoutParams2.leftMargin = companion.b(context3, 7);
        Context context4 = contentView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "contentView.context");
        layoutParams2.topMargin = companion.b(context4, 7);
        layoutParams2.addRule(9);
        layoutParams2.addRule(10);
        contentView.addView(textView, layoutParams2);
        b0(this, msgItem, false, 2, null);
        if (!f0(msgItem) && !f111961o && (nTAIOBubbleVideoView = this.videoView) != null) {
            nTAIOBubbleVideoView.k();
        }
        j0();
    }

    private final void B(GuildMsgItem msgItem, ViewGroup contentView, String videoPath) {
        QLog.d("GuildVideoViewer", 2, "createOrUpdateContentView, " + hashCode() + ", msgSeq: " + msgItem.getMsgSeq() + ", videoPath: " + videoPath);
        if (this.videoView != null) {
            h0(msgItem, contentView);
        } else {
            A(msgItem, contentView, videoPath);
        }
    }

    private final com.tencent.mobileqq.qqnt.videoplay.api.param.c C() {
        com.tencent.mobileqq.qqnt.videoplay.api.param.c cVar = new com.tencent.mobileqq.qqnt.videoplay.api.param.c();
        cVar.l(true);
        cVar.a().h(true);
        cVar.a().i(true);
        cVar.a().g(true);
        cVar.a().l(true);
        cVar.t(new c());
        cVar.m(155);
        return cVar;
    }

    private final void E(GuildMsgItem msgItem, MsgElement msgElement, boolean isGuest) {
        boolean z16;
        Long l3;
        String J = J(msgItem);
        if (J.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !new File(J).exists()) {
            if (QLog.isColorLevel()) {
                long msgId = msgItem.getMsgId();
                if (msgElement != null) {
                    l3 = Long.valueOf(msgElement.elementId);
                } else {
                    l3 = null;
                }
                QLog.d("GuildVideoViewer", 2, "triggerDownloadFile, thumb msgId = " + msgId + ", elementId = " + l3);
            }
            if (isGuest) {
                ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadRichMediaInVisit(UIUtil.f112434a.g(msgItem, 2, 0, msgElement, 0));
            } else {
                RichMediaElementGetReq a16 = a.f111981a.a(msgItem, 2, 0);
                if (a16 != null) {
                    ((IMsgService) QRoute.api(IMsgService.class)).getRichMediaElement(a16);
                }
            }
        }
    }

    private final void F(GuildMsgItem msgItem, MsgElement msgElement, boolean isGuest, boolean fromClick) {
        Long l3;
        boolean isWifiConnected = NetworkUtil.isWifiConnected(this.context);
        boolean z16 = false;
        if (!fromClick && !isWifiConnected) {
            String K = K(msgItem);
            if (K.length() > 0) {
                z16 = true;
            }
            if (z16 && !new File(K).exists()) {
                c0();
                return;
            }
            return;
        }
        Q();
        up0.a.f439407a.g(msgItem.getMsgId());
        String K2 = K(msgItem);
        if (K2.length() > 0) {
            z16 = true;
        }
        if (z16 && !new File(K2).exists()) {
            int i3 = !fromClick ? 1 : 0;
            if (QLog.isColorLevel()) {
                long msgId = msgItem.getMsgId();
                if (msgElement != null) {
                    l3 = Long.valueOf(msgElement.elementId);
                } else {
                    l3 = null;
                }
                QLog.d("GuildVideoViewer", 2, "triggerDownloadFile, video\uff0c msgId = " + msgId + ", elementId = " + l3 + ", triggerType: " + i3);
            }
            if (isGuest) {
                ((IRichMediaService) QRoute.api(IRichMediaService.class)).downloadRichMediaInVisit(UIUtil.f112434a.g(msgItem, 1, 0, msgElement, i3));
            } else {
                RichMediaElementGetReq a16 = a.f111981a.a(msgItem, 1, i3);
                if (a16 != null) {
                    ((IMsgService) QRoute.api(IMsgService.class)).getRichMediaElement(a16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J(GuildMsgItem msgItem) {
        HashMap<Integer, String> hashMap;
        String str = null;
        String a16 = IGuildVideoApi.a.a(m0(), msgItem, false, 2, null);
        if (TextUtils.isEmpty(a16)) {
            VideoElement c16 = a.f111981a.c(msgItem);
            if (c16 != null && (hashMap = c16.thumbPath) != null) {
                str = hashMap.get(0);
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return a16;
    }

    private final String K(GuildMsgItem msgItem) {
        String str = null;
        String d16 = IGuildVideoApi.a.d(m0(), msgItem, false, 2, null);
        if (TextUtils.isEmpty(d16)) {
            VideoElement c16 = a.f111981a.c(msgItem);
            if (c16 != null) {
                str = c16.filePath;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(FileTransNotifyInfo fileInfo) {
        int i3;
        int i16;
        boolean z16;
        if (fileInfo != null) {
            int i17 = fileInfo.trasferStatus;
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 4) {
                        if (i17 == 5) {
                            if (QLog.isColorLevel()) {
                                i16 = 2;
                                QLog.d("GuildVideoViewer", 2, "download fail, errCode: " + fileInfo.fileErrCode + ", msgId = " + fileInfo.msgId + ", elementId = " + fileInfo.msgElementId + ", downloadType = " + fileInfo.fileDownType + ", viewId = " + hashCode());
                            } else {
                                i16 = 2;
                            }
                            if (fileInfo.fileDownType != i16) {
                                if (fileInfo.fileErrCode == 2006043) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                up0.a.f439407a.a(fileInfo.msgId);
                                W(z16);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        i3 = 2;
                        QLog.d("GuildVideoViewer", 2, "download success, msgId = " + fileInfo.msgId + ", elementId = " + fileInfo.msgElementId + ", downloadType = " + fileInfo.fileDownType + ", viewId = " + hashCode());
                    } else {
                        i3 = 2;
                    }
                    if (fileInfo.fileDownType == i3) {
                        GuildMsgItem guildMsgItem = this.currentMsgItem;
                        if (guildMsgItem == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                            guildMsgItem = null;
                        }
                        b0(this, guildMsgItem, false, i3, null);
                        return;
                    }
                    V();
                    return;
                }
                if (fileInfo.fileDownType != 2) {
                    d0(fileInfo);
                    if (QLog.isColorLevel()) {
                        QLog.d("GuildVideoViewer", 2, "download showProgress, msgId = " + fileInfo.msgId + ", elementId = " + fileInfo.msgElementId + ", downloadType = " + fileInfo.fileDownType + " progress = " + fileInfo.fileProgress + ", viewId = " + hashCode());
                        return;
                    }
                    return;
                }
                return;
            }
            if (fileInfo.fileDownType != 2) {
                d0(fileInfo);
                if (QLog.isColorLevel()) {
                    QLog.d("GuildVideoViewer", 2, "upload showProgress, msgId = " + fileInfo.msgId + ", elementId = " + fileInfo.msgElementId + ", downloadType = " + fileInfo.fileDownType + " progress = " + fileInfo.fileProgress + ", viewId = " + hashCode());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(b.GuildMsgItemStatusPayload statusPayload) {
        if (statusPayload != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildVideoViewer", 2, "handleSendStatusState, status = " + statusPayload.getSendStatus());
            }
            i0(statusPayload.getSendStatus());
            if (this.msgSendStatus == 2) {
                R();
            }
        }
    }

    private final void P(element_ext_buf_for_ui$ElementExtBufForUI extBufForUI, final MsgRecord msgRecord) {
        Integer num;
        VideoElement videoElement;
        MsgElement msgElement = this.element;
        GuildMsgItem guildMsgItem = null;
        if (msgElement != null && (videoElement = msgElement.videoElement) != null) {
            num = Integer.valueOf(videoElement.subBusiType);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 4601) {
            GuildMsgItem guildMsgItem2 = this.currentMsgItem;
            if (guildMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem2 = null;
            }
            ViewGroup viewGroup = this.contentView;
            GuildMsgItem guildMsgItem3 = this.currentMsgItem;
            if (guildMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem3 = null;
            }
            B(guildMsgItem2, viewGroup, K(guildMsgItem3));
            IGuildVideoApi m06 = m0();
            GuildMsgItem guildMsgItem4 = this.currentMsgItem;
            if (guildMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem4 = null;
            }
            if (!m06.findCompressTask(guildMsgItem4.getMsgId())) {
                z(msgRecord, extBufForUI.quality.get());
                return;
            }
            IGuildVideoApi m07 = m0();
            GuildMsgItem guildMsgItem5 = this.currentMsgItem;
            if (guildMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem = guildMsgItem5;
            }
            long msgId = guildMsgItem.getMsgId();
            IGuildVideoApi.b bVar = this.compressListener;
            Intrinsics.checkNotNull(bVar);
            m07.setCompressListener(msgId, bVar);
            return;
        }
        if (num != null && num.intValue() == 4602) {
            GuildMsgItem guildMsgItem6 = this.currentMsgItem;
            if (guildMsgItem6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem6 = null;
            }
            B(guildMsgItem6, this.contentView, "");
            IGuildVideoApi m08 = m0();
            Context context = this.context;
            MsgElement msgElement2 = this.element;
            Intrinsics.checkNotNull(msgElement2);
            GuildMsgItem guildMsgItem7 = this.currentMsgItem;
            if (guildMsgItem7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem = guildMsgItem7;
            }
            m08.encodeVideo(context, msgRecord, msgElement2, J(guildMsgItem), new IGuildVideoApi.c() { // from class: com.tencent.guild.aio.msglist.video.GuildVideoViewer$handleVideoMsgBeforeRealSend$1
                @Override // com.tencent.guild.api.video.IGuildVideoApi.c
                public void onError(int errorCode) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str = "encode error " + errorCode;
                    if (str instanceof String) {
                        bVar2.a().add(str);
                    }
                    Iterator<T> it = bVar2.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GuildVideoViewer", 1, (String) it.next(), null);
                    }
                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                    if (f16 != null) {
                        CorountineFunKt.e(f16, "GuildVideoViewer_encodeVideo_onError", null, null, null, new GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onError$2(GuildVideoViewer.this, msgRecord, null), 14, null);
                    }
                }

                @Override // com.tencent.guild.api.video.IGuildVideoApi.c
                public void onSuccess(@Nullable String videoPath) {
                    CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                    if (f16 != null) {
                        CorountineFunKt.e(f16, "GuildVideoViewer_encodeVideo_onSuccess", null, null, null, new GuildVideoViewer$handleVideoMsgBeforeRealSend$1$onSuccess$1(GuildVideoViewer.this, videoPath, msgRecord, null), 14, null);
                    }
                }
            });
        }
    }

    private final void Q() {
        if (this.element != null) {
            ((ImageView) this.binding.findViewById(R.id.ksk)).setVisibility(8);
        }
    }

    private final void R() {
        ((FrameLayout) this.binding.findViewById(R.id.fk6)).setVisibility(8);
    }

    private final void S() {
        if (this.compressListener != null) {
            return;
        }
        this.compressListener = new IGuildVideoApi.b() { // from class: com.tencent.guild.aio.msglist.video.GuildVideoViewer$initCompressListener$1
            @Override // com.tencent.guild.api.video.IGuildVideoApi.b
            public void a(@Nullable MsgRecord msgRecord, boolean isNeedCompress) {
                Logger logger = Logger.f235387a;
                GuildVideoViewer guildVideoViewer = GuildVideoViewer.this;
                GuildMsgItem guildMsgItem = null;
                if (QLog.isColorLevel()) {
                    Logger.a d16 = logger.d();
                    Intrinsics.checkNotNull(msgRecord);
                    long j3 = msgRecord.msgId;
                    GuildMsgItem guildMsgItem2 = guildVideoViewer.currentMsgItem;
                    if (guildMsgItem2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        guildMsgItem2 = null;
                    }
                    d16.d("GuildVideoViewer", 2, "onUpdate, msgRecord msgId = " + j3 + ", isNeedCompress = " + isNeedCompress + ", currentMsgItem: " + guildMsgItem2.getMsgId());
                }
                boolean z16 = false;
                if (msgRecord != null) {
                    long j16 = msgRecord.msgId;
                    GuildMsgItem guildMsgItem3 = GuildVideoViewer.this.currentMsgItem;
                    if (guildMsgItem3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    } else {
                        guildMsgItem = guildMsgItem3;
                    }
                    if (j16 == guildMsgItem.getMsgId()) {
                        z16 = true;
                    }
                }
                if (z16 && isNeedCompress) {
                    GuildVideoViewer.this.x();
                }
            }

            @Override // com.tencent.guild.api.video.IGuildVideoApi.b
            public void b(@Nullable MsgRecord msgRecord, int finishCode) {
                IGuildVideoApi m06;
                MsgElement msgElement;
                IGuildVideoApi m07;
                MsgElement msgElement2;
                IGuildVideoApi m08;
                MsgElement msgElement3;
                LifecycleOwner lifecycleOwner;
                Logger logger = Logger.f235387a;
                GuildVideoViewer guildVideoViewer = GuildVideoViewer.this;
                GuildMsgItem guildMsgItem = null;
                if (QLog.isColorLevel()) {
                    Logger.a d16 = logger.d();
                    Intrinsics.checkNotNull(msgRecord);
                    long j3 = msgRecord.msgId;
                    GuildMsgItem guildMsgItem2 = guildVideoViewer.currentMsgItem;
                    if (guildMsgItem2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        guildMsgItem2 = null;
                    }
                    d16.d("GuildVideoViewer", 2, "onFinish, msgRecord msgId = " + j3 + ", finishCode = " + finishCode + ", currentMsgItem: " + guildMsgItem2.getMsgId());
                }
                boolean z16 = false;
                if (msgRecord != null) {
                    long j16 = msgRecord.msgId;
                    GuildMsgItem guildMsgItem3 = GuildVideoViewer.this.currentMsgItem;
                    if (guildMsgItem3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        guildMsgItem3 = null;
                    }
                    if (j16 == guildMsgItem3.getMsgId()) {
                        z16 = true;
                    }
                }
                if (z16) {
                    GuildVideoViewer.this.w();
                    if (finishCode == 3) {
                        return;
                    }
                    if (finishCode == 1) {
                        msgElement2 = GuildVideoViewer.this.element;
                        Intrinsics.checkNotNull(msgElement2);
                        if (new File(msgElement2.videoElement.filePath).length() > ShortVideoConstants.VIDEO_SIZE_LIMIT) {
                            lifecycleOwner = GuildVideoViewer.this.lifecycleOwner;
                            CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), "GuildVideoViewer_onFinish", Boolean.TRUE, null, null, new GuildVideoViewer$initCompressListener$1$onFinish$2(GuildVideoViewer.this, null), 12, null);
                        } else {
                            m08 = GuildVideoViewer.this.m0();
                            msgElement3 = GuildVideoViewer.this.element;
                            m08.copyVideoToNTDIR(msgElement3);
                        }
                    }
                    m06 = GuildVideoViewer.this.m0();
                    msgElement = GuildVideoViewer.this.element;
                    m06.copyThumbPicToNTDIR(msgElement);
                    GuildVideoViewer.this.v();
                    m07 = GuildVideoViewer.this.m0();
                    GuildMsgItem guildMsgItem4 = GuildVideoViewer.this.currentMsgItem;
                    if (guildMsgItem4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    } else {
                        guildMsgItem = guildMsgItem4;
                    }
                    m07.removeCompressTask(guildMsgItem.getMsgId());
                }
            }

            @Override // com.tencent.guild.api.video.IGuildVideoApi.b
            public void c(@Nullable MsgRecord msgRecord, float percent) {
                int i3;
                boolean z16 = false;
                if (msgRecord != null) {
                    long j3 = msgRecord.msgId;
                    GuildMsgItem guildMsgItem = GuildVideoViewer.this.currentMsgItem;
                    if (guildMsgItem == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        guildMsgItem = null;
                    }
                    if (j3 == guildMsgItem.getMsgId()) {
                        z16 = true;
                    }
                }
                if (z16 && (i3 = (int) (100 * percent)) < 100) {
                    GuildVideoViewer.this.y(i3);
                }
            }
        };
    }

    private final void V() {
        boolean z16;
        Q();
        R();
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        String K = K(guildMsgItem);
        boolean exists = new File(K).exists();
        if (K.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && exists && !f111961o) {
            NTAIOBubbleVideoView nTAIOBubbleVideoView = this.videoView;
            if (nTAIOBubbleVideoView != null) {
                nTAIOBubbleVideoView.k();
                return;
            }
            return;
        }
        int hashCode = hashCode();
        GuildMsgItem guildMsgItem3 = this.currentMsgItem;
        if (guildMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            guildMsgItem2 = guildMsgItem3;
        }
        QLog.d("GuildVideoViewer", 1, "[richMediaDownloadComplete], " + hashCode + ", msgSeq: " + guildMsgItem2.getMsgSeq() + ", videoPath: " + K + ", videoExists: " + exists);
    }

    private final void W(boolean showPlayIcon) {
        if (!showPlayIcon) {
            NTAIOBubbleVideoView nTAIOBubbleVideoView = this.videoView;
            if (nTAIOBubbleVideoView != null) {
                Intrinsics.checkNotNull(nTAIOBubbleVideoView);
                String string = nTAIOBubbleVideoView.getResources().getString(R.string.f158181ox);
                Intrinsics.checkNotNullExpressionValue(string, "videoView!!.resources.ge\u2026ild_video_download_error)");
                nTAIOBubbleVideoView.i(true, string);
                return;
            }
            return;
        }
        c0();
    }

    private final void X() {
        NTAIOBubbleVideoView nTAIOBubbleVideoView = this.videoView;
        if (nTAIOBubbleVideoView != null) {
            nTAIOBubbleVideoView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.video.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildVideoViewer.Y(GuildVideoViewer.this, view);
                }
            });
        }
        ImageView imageView = (ImageView) this.binding.findViewById(R.id.ksk);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.video.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildVideoViewer.Z(GuildVideoViewer.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(GuildVideoViewer this$0, View it) {
        long j3;
        Long d16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        GuildMsgItem guildMsgItem = this$0.currentMsgItem;
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        String str = guildMsgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "currentMsgItem.msgRecord.channelId");
        GuildMsgItem guildMsgItem3 = this$0.currentMsgItem;
        if (guildMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem3 = null;
        }
        String str2 = guildMsgItem3.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "currentMsgItem.msgRecord.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        a aVar = a.f111981a;
        GuildMsgItem guildMsgItem4 = this$0.currentMsgItem;
        if (guildMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem4 = null;
        }
        MsgElement b16 = aVar.b(guildMsgItem4);
        GuildMsgItem guildMsgItem5 = this$0.currentMsgItem;
        if (guildMsgItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem5 = null;
        }
        this$0.F(guildMsgItem5, b16, isSelfGuest, true);
        NTAIOBubbleVideoView nTAIOBubbleVideoView = this$0.videoView;
        if (nTAIOBubbleVideoView != null && (d16 = nTAIOBubbleVideoView.d()) != null) {
            j3 = d16.longValue();
        } else {
            j3 = 0;
        }
        Function4<Context, MsgRecord, View, Long, Unit> function4 = this$0.listener;
        Context context = this$0.context;
        GuildMsgItem guildMsgItem6 = this$0.currentMsgItem;
        if (guildMsgItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            guildMsgItem2 = guildMsgItem6;
        }
        MsgRecord msgRecord = guildMsgItem2.getMsgRecord();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        function4.invoke(context, msgRecord, it, Long.valueOf(j3));
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GuildVideoViewer this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        GuildMsgItem guildMsgItem = this$0.currentMsgItem;
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        String str = guildMsgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "currentMsgItem.msgRecord.channelId");
        GuildMsgItem guildMsgItem3 = this$0.currentMsgItem;
        if (guildMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem3 = null;
        }
        String str2 = guildMsgItem3.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "currentMsgItem.msgRecord.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        a aVar = a.f111981a;
        GuildMsgItem guildMsgItem4 = this$0.currentMsgItem;
        if (guildMsgItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem4 = null;
        }
        MsgElement b16 = aVar.b(guildMsgItem4);
        GuildMsgItem guildMsgItem5 = this$0.currentMsgItem;
        if (guildMsgItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            guildMsgItem2 = guildMsgItem5;
        }
        this$0.F(guildMsgItem2, b16, isSelfGuest, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void a0(GuildMsgItem msgItem, boolean setDefaultDrawable) {
        NTAIOBubbleVideoView nTAIOBubbleVideoView;
        ColorDrawable colorDrawable = new ColorDrawable(-10065297);
        if (setDefaultDrawable && (nTAIOBubbleVideoView = this.videoView) != null) {
            nTAIOBubbleVideoView.setCoverImage(colorDrawable);
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "GuildVideoViewer_setVideoCover", null, null, null, new GuildVideoViewer$setVideoCover$1(this, msgItem, colorDrawable, null), 14, null);
        }
    }

    static /* synthetic */ void b0(GuildVideoViewer guildVideoViewer, GuildMsgItem guildMsgItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        guildVideoViewer.a0(guildMsgItem, z16);
    }

    private final void c0() {
        if (this.element != null) {
            ((ImageView) this.binding.findViewById(R.id.ksk)).setVisibility(0);
        }
    }

    private final void d0(FileTransNotifyInfo fileInfo) {
        MsgElement msgElement = this.element;
        if (msgElement != null) {
            Q();
            int c16 = x.f112474a.c(msgElement, 5, fileInfo);
            TextView textView = (TextView) this.binding.findViewById(R.id.f110116hn);
            textView.setTextSize(10.0f);
            textView.setText(c16 + "%");
            ((ProgressBar) this.binding.findViewById(R.id.fk5)).setProgress(c16);
            ((FrameLayout) this.binding.findViewById(R.id.fk6)).setVisibility(0);
        }
    }

    private final void e0(boolean show) {
        NTAIOBubbleVideoView nTAIOBubbleVideoView = this.videoView;
        if (nTAIOBubbleVideoView != null) {
            nTAIOBubbleVideoView.j(show);
        }
    }

    private final boolean f0(GuildMsgItem msgItem) {
        Long l3;
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = msgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        MsgElement b16 = a.f111981a.b(msgItem);
        E(msgItem, b16, isSelfGuest);
        if (up0.a.f439407a.f(msgItem.getMsgId())) {
            c0();
            long msgId = msgItem.getMsgId();
            if (b16 != null) {
                l3 = Long.valueOf(b16.elementId);
            } else {
                l3 = null;
            }
            QLog.i("GuildVideoViewer", 1, "[triggerDownloadFile] autoPlayRefused. msgId = " + msgId + ", elementId = " + l3);
        } else {
            F(msgItem, b16, isSelfGuest, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(GuildMsgItem msgItem, ViewGroup contentView) {
        NTAIOBubbleVideoView nTAIOBubbleVideoView;
        String K = K(msgItem);
        boolean z16 = false;
        if (!Intrinsics.areEqual(K, this.videoParam.e())) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildVideoViewer", 2, "[updateContentView] indeed, " + hashCode() + ", msgSeq: " + msgItem.getMsgSeq() + ", currentPath: " + K + ", oldPath: " + this.videoParam.e());
            }
            Long l3 = null;
            b0(this, msgItem, false, 2, null);
            Pair<Integer, Integer> e16 = a.f111981a.e(msgItem);
            int intValue = e16.component1().intValue();
            int intValue2 = e16.component2().intValue();
            NTAIOBubbleVideoView nTAIOBubbleVideoView2 = this.videoView;
            if (nTAIOBubbleVideoView2 != null) {
                nTAIOBubbleVideoView2.setLayoutParams(new RelativeLayout.LayoutParams(intValue, intValue2));
            }
            com.tencent.mobileqq.qqnt.videoplay.api.param.c C = C();
            this.videoParam = C;
            C.p(K);
            MsgElement msgElement = this.element;
            if (msgElement != null) {
                VideoElement videoElement = msgElement.videoElement;
                if (videoElement != null && videoElement.fileTime == 0) {
                    z16 = true;
                }
                if (!z16) {
                    com.tencent.mobileqq.qqnt.videoplay.api.param.d g16 = this.videoParam.g();
                    if (msgElement.videoElement != null) {
                        l3 = Long.valueOf(r10.fileTime);
                    }
                    Intrinsics.checkNotNull(l3);
                    g16.f(l3.longValue());
                    com.tencent.mobileqq.qqnt.videoplay.api.param.d g17 = this.videoParam.g();
                    g17.f(g17.c() * 1000);
                } else {
                    this.videoParam.g().f(0L);
                }
            }
            NTAIOBubbleVideoView nTAIOBubbleVideoView3 = this.videoView;
            if (nTAIOBubbleVideoView3 != null) {
                nTAIOBubbleVideoView3.setVideoParam(this.videoParam);
            }
            if (!f0(msgItem) && !f111961o && (nTAIOBubbleVideoView = this.videoView) != null) {
                nTAIOBubbleVideoView.k();
            }
            j0();
            return;
        }
        a0(msgItem, false);
    }

    private final void i0(int sendStatus) {
        this.msgSendStatus = sendStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(GuildVideoViewer this$0) {
        NTAIOBubbleVideoView nTAIOBubbleVideoView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!f111961o && (nTAIOBubbleVideoView = this$0.videoView) != null) {
            nTAIOBubbleVideoView.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGuildVideoApi m0() {
        QRouteApi api = QRoute.api(IGuildVideoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
        return (IGuildVideoApi) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), "GuildVideoViewer_checkStatusAndSendMsg", Boolean.TRUE, null, null, new GuildVideoViewer$checkStatusAndSendMsg$1(this, null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), "GuildVideoViewer_compressShowOnFinish", Boolean.TRUE, null, null, new GuildVideoViewer$compressShowOnFinish$1(this, null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), "GuildVideoViewer_compressShowOnLaunch", Boolean.TRUE, null, null, new GuildVideoViewer$compressShowOnLaunch$1(this, null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int percent) {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), "GuildVideoViewer_compressShowOnUpdate", Boolean.TRUE, null, null, new GuildVideoViewer$compressShowOnUpdate$1(this, percent, null), 12, null);
    }

    private final void z(MsgRecord msgRecord, boolean quality) {
        if (this.compressListener == null) {
            S();
        }
        IGuildVideoApi m06 = m0();
        MsgElement msgElement = this.element;
        Intrinsics.checkNotNull(msgElement);
        Context context = this.context;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IGuildVideoApi.b bVar = this.compressListener;
        Intrinsics.checkNotNull(bVar);
        m06.compressVideo(msgRecord, msgElement, context, peekAppRuntime, quality, bVar);
    }

    @NotNull
    public final ViewGroup D() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TextView textView = new TextView(frameLayout.getContext());
        textView.setId(R.id.kaw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.guild_aio_view_pic_default);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.buj));
        textView.setTextSize(12.0f);
        textView.setVisibility(8);
        frameLayout.addView(textView);
        FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
        frameLayout2.setId(R.id.fk6);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout2.setBackgroundResource(R.drawable.guild_aio_view_msg_media_progress_bg);
        frameLayout2.setVisibility(8);
        ProgressBar progressBar = new ProgressBar(frameLayout2.getContext(), null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setId(R.id.fk5);
        UIUtil uIUtil = UIUtil.f112434a;
        progressBar.setLayoutParams(new FrameLayout.LayoutParams((int) uIUtil.o(36.0f), (int) uIUtil.o(36.0f)));
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(ContextCompat.getDrawable(progressBar.getContext(), R.drawable.guild_aio_view_msg_media_progress));
        frameLayout2.addView(progressBar);
        TextView textView2 = new TextView(frameLayout2.getContext());
        textView2.setId(R.id.f110116hn);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView2.setLayoutParams(layoutParams2);
        textView2.setIncludeFontPadding(false);
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.f158017al3));
        textView2.setTextSize(10.0f);
        frameLayout2.addView(textView2);
        frameLayout.addView(frameLayout2);
        ImageView imageView = new ImageView(frameLayout.getContext());
        imageView.setId(R.id.ksk);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        imageView.setLayoutParams(layoutParams3);
        imageView.setVisibility(8);
        imageView.setImageResource(R.drawable.guild_aio_video_play_btn);
        frameLayout.addView(imageView);
        return frameLayout;
    }

    @NotNull
    /* renamed from: G, reason: from getter */
    public final ViewGroup getContentView() {
        return this.contentView;
    }

    @NotNull
    /* renamed from: H, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Function3<Context, MsgRecord, Integer, Unit> I() {
        return this.msgSendListener;
    }

    public final void L() {
        MsgElement msgElement;
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        if (guildMsgItem.isLocalSend() && (msgElement = this.element) != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                Logger.a d16 = logger.d();
                GuildMsgItem guildMsgItem3 = this.currentMsgItem;
                if (guildMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem3 = null;
                }
                d16.d("GuildVideoViewer", 2, "handleCancelSend msgId = " + guildMsgItem3.getMsgId() + " ");
            }
            IGuildVideoApi m06 = m0();
            GuildMsgItem guildMsgItem4 = this.currentMsgItem;
            if (guildMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem4 = null;
            }
            m06.removeCompressTask(guildMsgItem4.getMsgId());
            IGuildVideoApi m07 = m0();
            GuildMsgItem guildMsgItem5 = this.currentMsgItem;
            if (guildMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem5 = null;
            }
            m07.removeEncodeTask(guildMsgItem5.getMsgRecord());
            if (!TextUtils.isEmpty(msgElement.videoElement.videoMd5)) {
                Function3<Context, MsgRecord, Integer, Unit> function3 = this.msgSendListener;
                Context context = this.context;
                GuildMsgItem guildMsgItem6 = this.currentMsgItem;
                if (guildMsgItem6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    guildMsgItem2 = guildMsgItem6;
                }
                function3.invoke(context, guildMsgItem2.getMsgRecord(), 1);
            }
            w();
        }
    }

    public final void M() {
        MsgElement msgElement;
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        if (guildMsgItem.isLocalSend() && (msgElement = this.element) != null) {
            if (TextUtils.isEmpty(msgElement.videoElement.videoMd5)) {
                this.extBufForUI.mergeFrom(msgElement.extBufForUI);
                m0().initVideoElement(msgElement, this.extBufForUI);
                element_ext_buf_for_ui$ElementExtBufForUI element_ext_buf_for_ui_elementextbufforui = this.extBufForUI;
                GuildMsgItem guildMsgItem3 = this.currentMsgItem;
                if (guildMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                } else {
                    guildMsgItem2 = guildMsgItem3;
                }
                P(element_ext_buf_for_ui_elementextbufforui, guildMsgItem2.getMsgRecord());
                return;
            }
            Function3<Context, MsgRecord, Integer, Unit> function3 = this.msgSendListener;
            Context context = this.context;
            GuildMsgItem guildMsgItem4 = this.currentMsgItem;
            if (guildMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem2 = guildMsgItem4;
            }
            function3.invoke(context, guildMsgItem2.getMsgRecord(), 2);
        }
    }

    public final void T() {
        NTAIOBubbleVideoView nTAIOBubbleVideoView = this.videoView;
        if (nTAIOBubbleVideoView != null) {
            nTAIOBubbleVideoView.setMute(true);
        }
    }

    public final void U() {
        NTAIOBubbleVideoView nTAIOBubbleVideoView = this.videoView;
        if (nTAIOBubbleVideoView != null) {
            nTAIOBubbleVideoView.l(false);
        }
    }

    public final void g0(@NotNull String msg2, @NotNull Object payload) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(payload, "payload");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this.lifecycleOwner), "GuildVideoViewer_updateBindState", Boolean.TRUE, null, null, new GuildVideoViewer$updateBindState$1(msg2, this, payload, null), 12, null);
    }

    public final void j0() {
        boolean z16;
        VideoElement videoElement;
        Integer num;
        ((TextView) this.binding.findViewById(R.id.kaw)).setVisibility(8);
        MsgElement msgElement = this.element;
        if (msgElement != null && (videoElement = msgElement.videoElement) != null && (num = videoElement.invalidState) != null && num.intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            TextView textView = (TextView) this.binding.findViewById(R.id.kaw);
            textView.setBackgroundResource(R.drawable.guild_aio_view_pic_default);
            textView.setVisibility(0);
            textView.setText(textView.getContext().getString(R.string.ygk));
            a aVar = a.f111981a;
            GuildMsgItem guildMsgItem = this.currentMsgItem;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            Pair<Integer, Integer> e16 = aVar.e(guildMsgItem);
            int intValue = e16.component1().intValue();
            int intValue2 = e16.component2().intValue();
            int dpToPx = intValue2 - ViewUtils.dpToPx(50.0f);
            if (dpToPx > 0) {
                intValue2 = dpToPx;
            }
            textView.setHeight(intValue2);
            int dpToPx2 = intValue - ViewUtils.dpToPx(50.0f);
            if (dpToPx2 > 0) {
                intValue = dpToPx2;
            }
            textView.setWidth(intValue);
            Q();
        }
    }

    public final void k0(boolean pause, boolean mute) {
        boolean z16;
        boolean z17;
        PlayState e16;
        PlayState e17;
        if (pause) {
            NTAIOBubbleVideoView nTAIOBubbleVideoView = this.videoView;
            if (nTAIOBubbleVideoView != null) {
                nTAIOBubbleVideoView.g();
            }
        } else {
            GuildMsgItem guildMsgItem = this.currentMsgItem;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            String K = K(guildMsgItem);
            boolean z18 = true;
            if (K.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && new File(K).exists()) {
                NTAIOBubbleVideoView nTAIOBubbleVideoView2 = this.videoView;
                if (nTAIOBubbleVideoView2 != null && (e17 = nTAIOBubbleVideoView2.e()) != null && e17.isInPlaying()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    NTAIOBubbleVideoView nTAIOBubbleVideoView3 = this.videoView;
                    if (nTAIOBubbleVideoView3 == null || (e16 = nTAIOBubbleVideoView3.e()) == null || !e16.isPaused()) {
                        z18 = false;
                    }
                    if (z18) {
                        NTAIOBubbleVideoView nTAIOBubbleVideoView4 = this.videoView;
                        if (nTAIOBubbleVideoView4 != null) {
                            nTAIOBubbleVideoView4.h();
                        }
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.guild.aio.msglist.video.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildVideoViewer.l0(GuildVideoViewer.this);
                            }
                        }, 300L);
                    }
                }
            }
        }
        if (mute) {
            T();
        }
    }

    public final void u(@NotNull GuildMsgItem msgItem) {
        GuildMsgItem guildMsgItem;
        GuildMsgItem guildMsgItem2;
        GuildMsgItem guildMsgItem3;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (this.currentMsgItem != null) {
            if (QLog.isColorLevel()) {
                long j3 = msgItem.getMsgRecord().msgId;
                long msgSeq = msgItem.getMsgSeq();
                GuildMsgItem guildMsgItem4 = this.currentMsgItem;
                if (guildMsgItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem4 = null;
                }
                QLog.i("GuildVideoViewer", 2, "[bind] newMsgId = " + j3 + ", newMsgSeq: " + msgSeq + ", oldMsgSeq: " + guildMsgItem4.getMsgRecord().msgSeq + ", viewId = " + hashCode());
            }
            GuildMsgItem guildMsgItem5 = this.currentMsgItem;
            if (guildMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem5 = null;
            }
            if (guildMsgItem5.getMsgId() != msgItem.getMsgId()) {
                R();
                e0(false);
            }
        } else if (QLog.isColorLevel()) {
            QLog.i("GuildVideoViewer", 2, "[bind] newMsgId = " + msgItem.getMsgRecord().msgId + ", newMsgSeq: " + msgItem.getMsgSeq() + ", viewId = " + hashCode());
        }
        this.currentMsgItem = msgItem;
        i0(msgItem.getMsgRecord().sendStatus);
        MsgElement b16 = a.f111981a.b(msgItem);
        this.element = b16;
        if (b16 != null) {
            if (msgItem.isLocalSend() && this.msgSendStatus != 2) {
                S();
                if (TextUtils.isEmpty(b16.videoElement.videoMd5)) {
                    this.extBufForUI.mergeFrom(b16.extBufForUI);
                    m0().initVideoElement(b16, this.extBufForUI);
                    if (this.msgSendStatus == 1) {
                        P(this.extBufForUI, msgItem.getMsgRecord());
                        return;
                    }
                    GuildMsgItem guildMsgItem6 = this.currentMsgItem;
                    if (guildMsgItem6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        guildMsgItem6 = null;
                    }
                    ViewGroup viewGroup = this.contentView;
                    GuildMsgItem guildMsgItem7 = this.currentMsgItem;
                    if (guildMsgItem7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                        guildMsgItem3 = null;
                    } else {
                        guildMsgItem3 = guildMsgItem7;
                    }
                    B(guildMsgItem6, viewGroup, K(guildMsgItem3));
                    return;
                }
                GuildMsgItem guildMsgItem8 = this.currentMsgItem;
                if (guildMsgItem8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem8 = null;
                }
                ViewGroup viewGroup2 = this.contentView;
                GuildMsgItem guildMsgItem9 = this.currentMsgItem;
                if (guildMsgItem9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem2 = null;
                } else {
                    guildMsgItem2 = guildMsgItem9;
                }
                B(guildMsgItem8, viewGroup2, K(guildMsgItem2));
                return;
            }
            GuildMsgItem guildMsgItem10 = this.currentMsgItem;
            if (guildMsgItem10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem10 = null;
            }
            ViewGroup viewGroup3 = this.contentView;
            GuildMsgItem guildMsgItem11 = this.currentMsgItem;
            if (guildMsgItem11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            } else {
                guildMsgItem = guildMsgItem11;
            }
            B(guildMsgItem10, viewGroup3, K(guildMsgItem));
        }
    }
}
