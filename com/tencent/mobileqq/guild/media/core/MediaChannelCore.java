package com.tencent.mobileqq.guild.media.core;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper;
import com.tencent.mobileqq.guild.media.core.logic.InviteOpenMicConfigHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper;
import com.tencent.mobileqq.guild.media.core.logic.ScreenShareStatusHelper;
import com.tencent.mobileqq.guild.media.core.logic.ab;
import com.tencent.mobileqq.guild.media.core.logic.ac;
import com.tencent.mobileqq.guild.media.core.logic.ad;
import com.tencent.mobileqq.guild.media.core.logic.ae;
import com.tencent.mobileqq.guild.media.core.logic.bh;
import com.tencent.mobileqq.guild.media.core.logic.bi;
import com.tencent.mobileqq.guild.media.core.logic.bz;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.media.core.notify.MediaChannelEventBus;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ea\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 \u00a4\u00012\u00020\u0001:\u0002\u00a5\u0001B\t\u00a2\u0006\u0006\b\u00a2\u0001\u0010\u00a3\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00108\u001a\u000207H\u0016J\b\u0010:\u001a\u000209H\u0016J\u0010\u0010=\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020;H\u0016J\b\u0010?\u001a\u00020;H\u0016J\b\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020;H\u0016J\n\u0010D\u001a\u0004\u0018\u00010CH\u0016J\n\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010G\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0016J\b\u0010I\u001a\u00020HH\u0016J\b\u0010K\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020LH\u0016J\b\u0010O\u001a\u00020NH\u0016J\b\u0010Q\u001a\u00020PH\u0016J\b\u0010S\u001a\u00020RH\u0016J\b\u0010U\u001a\u00020TH\u0016J\b\u0010V\u001a\u00020TH\u0016J\b\u0010W\u001a\u00020TH\u0016J\b\u0010X\u001a\u00020TH\u0016J\b\u0010Y\u001a\u00020TH\u0016J\u001a\u0010^\u001a\u00020T2\u0006\u0010[\u001a\u00020Z2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016J\u0012\u0010`\u001a\u00020T2\b\u0010]\u001a\u0004\u0018\u00010_H\u0016J\u001c\u0010c\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010;2\b\u0010b\u001a\u0004\u0018\u00010;H\u0016J.\u0010e\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010;2\b\u0010b\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020;2\b\u0010d\u001a\u0004\u0018\u00010;H\u0016J\b\u0010f\u001a\u00020TH\u0016J\b\u0010g\u001a\u000209H\u0016J\u0010\u0010j\u001a\u00020T2\u0006\u0010i\u001a\u00020hH\u0016J\b\u0010l\u001a\u00020kH\u0016J\b\u0010n\u001a\u00020mH\u0016J\b\u0010o\u001a\u00020TH\u0016J\u0018\u0010r\u001a\u00020T2\u0006\u0010<\u001a\u00020;2\u0006\u0010q\u001a\u00020pH\u0016J\u0018\u0010t\u001a\u00020T2\u0006\u0010s\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0016J\u0010\u0010w\u001a\u00020T2\u0006\u0010v\u001a\u00020uH\u0016J\b\u0010y\u001a\u00020xH\u0016J\b\u0010{\u001a\u00020zH\u0016J\u0010\u0010}\u001a\u00020T2\u0006\u0010|\u001a\u00020@H\u0016J\n\u0010\u007f\u001a\u0004\u0018\u00010~H\u0016J\u0014\u0010\u0081\u0001\u001a\u00020T2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010~H\u0016J\t\u0010\u0082\u0001\u001a\u000209H\u0016J\t\u0010\u0083\u0001\u001a\u000209H\u0016J\u0014\u0010\u0085\u0001\u001a\u00020T2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010~H\u0016J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010~H\u0016J\n\u0010\u0088\u0001\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0016R\u001d\u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bj\u0010\u008c\u0001R \u0010\u0091\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008c\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0016\u0010\u0093\u0001\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b!\u0010\u0092\u0001R!\u0010\u0098\u0001\u001a\u00030\u0094\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u008c\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0017\u0010\u009c\u0001\u001a\u00020H8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u009b\u0001R \u0010\u00a1\u0001\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001*\u0006\b\u009f\u0001\u0010\u00a0\u0001\u00a8\u0006\u00a6\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/MediaChannelCore;", "Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/n;", "o0", "Lcom/tencent/mobileqq/guild/media/core/l;", "v0", "Lus1/b;", "H0", "Lcom/tencent/mobileqq/guild/media/core/logic/b;", "t0", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom;", "y0", "Lcom/tencent/mobileqq/guild/media/core/logic/p;", "z0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper;", "T", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/core/logic/r;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper;", "N", "Lcom/tencent/mobileqq/guild/media/core/logic/bz;", "Y", "Lcom/tencent/mobileqq/guild/media/core/logic/ac;", "M", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelThirdAppHelper;", "d0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper;", "P", "Lcom/tencent/mobileqq/guild/media/core/logic/ab;", "M0", "Lcom/tencent/mobileqq/guild/media/core/logic/InviteOpenMicConfigHelper;", "f", "Lcom/tencent/mobileqq/guild/media/core/logic/bh;", "u0", "Lcom/tencent/mobileqq/guild/media/core/logic/ad;", "B0", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/core/logic/AudioNotifyHelper;", "l0", "Lcom/tencent/mobileqq/guild/media/core/logic/gift/a;", "b0", "Lcom/tencent/mobileqq/guild/media/core/logic/s;", "W", "Lcom/tencent/mobileqq/guild/media/core/logic/a;", "m0", "Lcom/tencent/mobileqq/guild/media/core/logic/ScreenShareStatusHelper;", "X", "Lcom/tencent/mobileqq/guild/media/core/logic/bi;", "p0", "Lcom/tencent/mobileqq/guild/media/core/logic/n;", "K0", "Lcom/tencent/mobileqq/guild/media/core/logic/g;", "x0", "Lcom/tencent/mobileqq/guild/media/core/logic/o;", "J", "", "isInChannel", "", "channelId", "i0", "getGuildID", "E", "", "L", "getChannelType", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "K", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getQQAppInterface", "Landroid/content/Context;", "getAppContext", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "getSelfUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "D0", "Lcom/tencent/mobileqq/guild/media/core/data/l;", "A0", "Lcom/tencent/mobileqq/guild/media/core/data/a;", "w0", "", "E0", "p", "h0", "u", "I", "Lcom/tencent/mobileqq/guild/media/core/q;", "startParams", "Lcom/tencent/mobileqq/guild/media/core/b;", "callback", "c", "Lcom/tencent/mobileqq/guild/media/core/h;", UserInfo.SEX_FEMALE, "showTips", "reasonForLog", "D", "fragmentKey", BdhLogUtil.LogTag.Tag_Req, "n0", ReportConstant.COSTREPORT_PREFIX, "", "themeType", "d", "Lcom/tencent/mobileqq/guild/media/core/notify/p;", "r0", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "q0", "Lcom/tencent/mobileqq/guild/media/core/RefreshType;", "refreshType", "G", "guildId", "C0", "Lcom/tencent/mobileqq/guild/media/core/logic/j;", "enterChannelParamsForTRTCRoom", "s0", "Lcom/tencent/mobileqq/guild/media/core/logic/ae;", "f0", "Lcom/tencent/mobileqq/guild/media/core/logic/q;", "I0", "seq", "O", "Landroid/os/Bundle;", "a0", "loadBeanBundle", "j0", "U", "J0", "extra", "e0", "c0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper;", "H", "Lcom/tencent/mobileqq/guild/media/core/logic/gift/b;", "F0", "Lkotlin/Lazy;", "Lkotlin/Lazy;", "_dataModelLazy", "e", "k", "()Lcom/tencent/mobileqq/guild/media/core/l;", "_dataHub", "Lcom/tencent/mobileqq/guild/media/core/notify/p;", "eventBus", "Lcom/tencent/mobileqq/guild/media/core/MediaChannelLogicHub;", tl.h.F, "g", "()Lcom/tencent/mobileqq/guild/media/core/MediaChannelLogicHub;", "logicHub", "i", "Landroid/os/Bundle;", "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "qqAppInterface", "l", "()Lcom/tencent/mobileqq/guild/media/core/n;", "get_dataModel$delegate", "(Lcom/tencent/mobileqq/guild/media/core/MediaChannelCore;)Ljava/lang/Object;", "_dataModel", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelCore implements f {

    @Nullable
    private static MediaChannelCore C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<n> _dataModelLazy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy _dataHub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.notify.p eventBus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy logicHub;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bundle loadBeanBundle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\nR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/MediaChannelCore$a;", "", "", "b", "()Z", "isExistInstance", "Lcom/tencent/mobileqq/guild/media/core/MediaChannelCore;", "a", "()Lcom/tencent/mobileqq/guild/media/core/MediaChannelCore;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "INVALID_USER_LONG_ID", "J", "", "TAG", "Ljava/lang/String;", "sInstance", "Lcom/tencent/mobileqq/guild/media/core/MediaChannelCore;", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.MediaChannelCore$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized MediaChannelCore a() {
            MediaChannelCore mediaChannelCore;
            if (MediaChannelCore.C == null) {
                MediaChannelCore.C = new MediaChannelCore();
            }
            mediaChannelCore = MediaChannelCore.C;
            Intrinsics.checkNotNull(mediaChannelCore);
            return mediaChannelCore;
        }

        public final synchronized boolean b() {
            boolean z16;
            if (MediaChannelCore.C != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            return z16;
        }

        Companion() {
        }
    }

    public MediaChannelCore() {
        Lazy<n> lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<n>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelCore$_dataModelLazy$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final n invoke() {
                if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String stackTraceString = QLog.getStackTraceString(new IllegalStateException("Called on a non-ui thread!"));
                    Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(Ille\u2026ed on a non-ui thread!\"))");
                    if (stackTraceString instanceof String) {
                        bVar.a().add(stackTraceString);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("QGMC.Core.MediaChannelCore", 1, (String) it.next(), null);
                    }
                }
                return new n();
            }
        });
        this._dataModelLazy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelCore$_dataHub$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                n l3;
                l3 = MediaChannelCore.this.l();
                return new l(l3);
            }
        });
        this._dataHub = lazy2;
        this.eventBus = new MediaChannelEventBus();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MediaChannelLogicHub>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelCore$logicHub$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaChannelLogicHub invoke() {
                return new MediaChannelLogicHub(MediaChannelCore.this);
            }
        });
        this.logicHub = lazy3;
    }

    private final MediaChannelLogicHub g() {
        return (MediaChannelLogicHub) this.logicHub.getValue();
    }

    private final BaseQQAppInterface h() {
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNull(l3, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        return (BaseQQAppInterface) l3;
    }

    private final l k() {
        return (l) this._dataHub.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n l() {
        return this._dataModelLazy.getValue();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.data.l A0() {
        return l().getTRTCUserInfoList();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public ad B0() {
        return (ad) g().b(ad.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public MediaChannelPermissionHelper C() {
        return (MediaChannelPermissionHelper) g().b(MediaChannelPermissionHelper.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    public void C0(@NotNull String guildId, @NotNull String channelId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        boolean z17 = true;
        if (guildId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (channelId.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                CorountineFunKt.e(getCoroutineScope(), "updateMuteToMeList", null, null, Boolean.TRUE, new MediaChannelCore$updateMuteToMeList$1(guildId, channelId, this, null), 6, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void D(@Nullable String showTips, @Nullable String reasonForLog) {
        String stackTraceToString;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(new Exception());
            d16.d("QGMC.Core.MediaChannelCore", 2, "exitChannelTrace: " + stackTraceToString);
        }
        Q().D(showTips, reasonForLog);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.data.r D0() {
        return l().getUserInfoList();
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public String E() {
        return l().getStartParams().getChannelId();
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        g().E0();
        l().E0();
        k().E0();
        this.eventBus.E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void F(@Nullable h callback) {
        Q().F(callback);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.gift.b F0() {
        return (com.tencent.mobileqq.guild.media.core.logic.gift.b) g().b(com.tencent.mobileqq.guild.media.core.logic.gift.b.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void G(@NotNull String channelId, @NotNull RefreshType refreshType) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        if (K(channelId) && refreshType == RefreshType.BY_AUDIO_ROBOT) {
            l0().l(getSelfUserInfo(), D0());
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public MediaChannelFreeGiftTaskHelper H() {
        return (MediaChannelFreeGiftTaskHelper) g().b(MediaChannelFreeGiftTaskHelper.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public us1.b H0() {
        return (us1.b) g().b(us1.b.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void I() {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelCore", 1, "onQQAccountExit.");
        D(null, "onQQAccountExit.");
        g().getQqAccountStateHelper().b();
        C = null;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.q I0() {
        return (com.tencent.mobileqq.guild.media.core.logic.q) g().b(com.tencent.mobileqq.guild.media.core.logic.q.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.o J() {
        return (com.tencent.mobileqq.guild.media.core.logic.o) g().b(com.tencent.mobileqq.guild.media.core.logic.o.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public boolean J0() {
        if (l().getStartParams().getFromPreView() == 100) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public boolean K(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (this._dataModelLazy.isInitialized() && isInChannel() && Intrinsics.areEqual(E(), channelId)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.n K0() {
        return (com.tencent.mobileqq.guild.media.core.logic.n) g().b(com.tencent.mobileqq.guild.media.core.logic.n.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public long L() {
        if (!StringUtil.isEmpty(ch.f())) {
            String f16 = ch.f();
            Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
            return Long.parseLong(f16);
        }
        if (!StringUtil.isEmpty(l().getSelfUserInfo().f228093a)) {
            String str = l().getSelfUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "_dataModel.selfUserInfo.id");
            return Long.parseLong(str);
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public ac M() {
        d f16 = g().f(MediaBusinessType.MEDIA_AUDIO_QUEUE);
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.logic.MediaChannelAudioQueueHelper");
        return (ac) f16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public ab M0() {
        return (ab) g().b(ab.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public MediaChannelMicSequenceHelper N() {
        d f16 = g().f(MediaBusinessType.MEDIA_MIC_QUEUE);
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper");
        return (MediaChannelMicSequenceHelper) f16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void O(long seq) {
        l().d0(seq);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public MediaChannelMultiRoomHelper P() {
        return (MediaChannelMultiRoomHelper) g().b(MediaChannelMultiRoomHelper.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.r Q() {
        return (com.tencent.mobileqq.guild.media.core.logic.r) g().b(com.tencent.mobileqq.guild.media.core.logic.r.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void R(@Nullable String showTips, @Nullable String reasonForLog, @NotNull String channelId, @Nullable String fragmentKey) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (Intrinsics.areEqual(E(), channelId) && Intrinsics.areEqual(fragmentKey, k().s())) {
            Q().D(showTips, reasonForLog);
        } else {
            QLog.d("QGMC.Core.MediaChannelCore", 1, "exitChannel but dont match!");
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public MediaChannelPermissionHelper S() {
        return (MediaChannelPermissionHelper) g().b(MediaChannelPermissionHelper.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public MediaChannelRaiseHandHelper T() {
        d f16 = g().f(MediaBusinessType.MEDIA_RAISE_HAND);
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper");
        return (MediaChannelRaiseHandHelper) f16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public boolean U() {
        return y0().getIsInited();
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.s W() {
        return (com.tencent.mobileqq.guild.media.core.logic.s) g().b(com.tencent.mobileqq.guild.media.core.logic.s.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public ScreenShareStatusHelper X() {
        return (ScreenShareStatusHelper) g().b(ScreenShareStatusHelper.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public bz Y() {
        return (bz) g().b(bz.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @Nullable
    /* renamed from: a0, reason: from getter */
    public Bundle getLoadBeanBundle() {
        return this.loadBeanBundle;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.gift.a b0() {
        return (com.tencent.mobileqq.guild.media.core.logic.gift.a) g().b(com.tencent.mobileqq.guild.media.core.logic.gift.a.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void c(@NotNull q startParams, @Nullable b callback) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        Q().c(startParams, callback);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @Nullable
    public Bundle c0() {
        return k().getEnterChannelExtraData();
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void d(int themeType) {
        Q().d(themeType);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public MediaChannelThirdAppHelper d0() {
        d f16 = g().f(MediaBusinessType.MEDIA_THIRD_APP);
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.logic.MediaChannelThirdAppHelper");
        return (MediaChannelThirdAppHelper) f16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void e0(@Nullable Bundle extra) {
        k().H0(extra);
    }

    @NotNull
    public InviteOpenMicConfigHelper f() {
        return (InviteOpenMicConfigHelper) g().b(InviteOpenMicConfigHelper.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public ae f0() {
        return (ae) g().b(ae.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public Context getAppContext() {
        Context applicationContext = h().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "qqAppInterface.applicationContext");
        return applicationContext;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @Nullable
    public IGProChannelInfo getChannelInfo() {
        IGProChannelInfo C2 = ch.C(h(), getGuildID(), E());
        if (C2 == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getChannelInfo is null, guildId:" + getGuildID() + ", channelId:" + E();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelCore", 1, (String) it.next(), null);
            }
        }
        return C2;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public String getChannelType() {
        return String.valueOf(l().getStartParams().getChannelType());
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public CoroutineScope getCoroutineScope() {
        com.tencent.mobileqq.qcoroutine.framework.impl.a aVar = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a;
        com.tencent.mobileqq.qqcoroutine_api.a aVar2 = com.tencent.mobileqq.qqcoroutine_api.a.f262384e;
        CoroutineScope f16 = aVar.f(aVar2);
        if (f16 == null) {
            aVar.d(aVar2);
            CoroutineScope f17 = aVar.f(aVar2);
            if (f17 != null) {
                return f17;
            }
            throw new IllegalStateException("create MEDIA_CHANNEL_CORE scope error!");
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public String getGuildID() {
        return l().getStartParams().getGuildId();
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @Nullable
    public IGProGuildInfo getGuildInfo() {
        IGProGuildInfo L = ch.L(getGuildID());
        if (L == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getGuildInfo is null, guildId:" + getGuildID() + ", channelId:" + E();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelCore", 1, (String) it.next(), null);
            }
        }
        return L;
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public BaseQQAppInterface getQQAppInterface() {
        return h();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.data.f getSelfUserInfo() {
        return l().getSelfUserInfo();
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
        g().h0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public boolean i0(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (this._dataModelLazy.isInitialized() && l().l().getValue() == EnterChannelState.ENTER_SUC && Intrinsics.areEqual(E(), channelId)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public boolean isInChannel() {
        if (this._dataModelLazy.isInitialized() && m.h(k())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public void j0(@Nullable Bundle loadBeanBundle) {
        this.loadBeanBundle = loadBeanBundle;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    @NotNull
    public AudioNotifyHelper l0() {
        return (AudioNotifyHelper) g().b(AudioNotifyHelper.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.a m0() {
        return (com.tencent.mobileqq.guild.media.core.logic.a) g().b(com.tencent.mobileqq.guild.media.core.logic.a.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    public void n0() {
        I0().n0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public n o0() {
        return l();
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
        g().p();
        l().E0();
        k().E0();
        this.eventBus.E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public bi p0() {
        return (bi) g().b(bi.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    public void q0() {
        CoroutineContext coroutineContext;
        com.tencent.mobileqq.qcoroutine.framework.impl.a aVar = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a;
        com.tencent.mobileqq.qqcoroutine_api.a aVar2 = com.tencent.mobileqq.qqcoroutine_api.a.f262384e;
        CoroutineScope f16 = aVar.f(aVar2);
        if (f16 != null && (coroutineContext = f16.getCoroutineContext()) != null) {
            JobKt.cancelChildren$default(coroutineContext, (CancellationException) null, 1, (Object) null);
        }
        aVar.b(aVar2);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    /* renamed from: r0, reason: from getter */
    public com.tencent.mobileqq.guild.media.core.notify.p getEventBus() {
        return this.eventBus;
    }

    @Override // com.tencent.mobileqq.guild.media.core.e
    public boolean s() {
        return x0().getMIsCalling();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    public void s0(@NotNull com.tencent.mobileqq.guild.media.core.logic.j enterChannelParamsForTRTCRoom) {
        Intrinsics.checkNotNullParameter(enterChannelParamsForTRTCRoom, "enterChannelParamsForTRTCRoom");
        l().i0(enterChannelParamsForTRTCRoom);
        QLog.d("QGMC.Core.MediaChannelCore", 1, "updateRoomConfigInfo " + enterChannelParamsForTRTCRoom);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.b t0() {
        return (com.tencent.mobileqq.guild.media.core.logic.b) g().b(com.tencent.mobileqq.guild.media.core.logic.b.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        g().u();
        l().u();
        k().u();
        this.eventBus.u();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public bh u0() {
        return (bh) g().b(bh.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public l v0() {
        return k();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.data.a w0() {
        return l().getScreenShareAnchorInfo();
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.g x0() {
        return (com.tencent.mobileqq.guild.media.core.logic.g) g().b(com.tencent.mobileqq.guild.media.core.logic.g.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public ITRTCAudioRoom y0() {
        return (ITRTCAudioRoom) g().b(ITRTCAudioRoom.class);
    }

    @Override // com.tencent.mobileqq.guild.media.core.f
    @NotNull
    public com.tencent.mobileqq.guild.media.core.logic.p z0() {
        return (com.tencent.mobileqq.guild.media.core.logic.p) g().b(com.tencent.mobileqq.guild.media.core.logic.p.class);
    }
}
