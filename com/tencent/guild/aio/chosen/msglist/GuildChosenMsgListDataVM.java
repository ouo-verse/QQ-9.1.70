package com.tencent.guild.aio.chosen.msglist;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.msgservice.h;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.chosen.data.GuildChosenMsgListDataManager;
import com.tencent.guild.aio.chosen.msglist.GuildChosenMsgIntent;
import com.tencent.guild.aio.chosen.msglist.a;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.factory.business.holder.msglist.j;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.aio.util.x;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.msg.service.l;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.api.i;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002sw\u0018\u0000 l2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0002\u0081\u0001B\b\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0016\u0010\u0011\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u001e\u0010$\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\"\u0010(\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020\bH\u0002J\u0018\u00100\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u000e2\u0006\u0010/\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000fH\u0002J \u00104\u001a\u00020\f2\u0006\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u00105\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H\u0002J\u0016\u00107\u001a\u00020\f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000eH\u0002J&\u00109\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J$\u0010=\u001a\u00020\u001a2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001f0:2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001f0:H\u0002J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u000e\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020?J\u000e\u0010C\u001a\u00020B2\u0006\u0010@\u001a\u00020?J\u0010\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020DH\u0016J\b\u0010G\u001a\u00020\fH\u0007J\u0010\u0010H\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u0002H\u0016J\u0010\u0010J\u001a\u00020\f2\u0006\u0010@\u001a\u00020IH\u0016J\b\u0010K\u001a\u00020\fH\u0016J\u001e\u0010N\u001a\u00020\f2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010O\u001a\u00020\fH\u0016J\u001c\u0010S\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010P2\b\u0010R\u001a\u0004\u0018\u00010QH\u0016R\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000f0X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010\\R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001f0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010ZR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001f0b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR \u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010gR\u001b\u0010n\u001a\u00020i8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010v\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010yR(\u0010}\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020s0{0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010|R(\u0010~\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020w0{0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010|\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Ljava/util/Observer;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "O", "", HippyTKDListViewAdapter.SCROLL_STATE, "firstPosition", "lastPosition", "", "W", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "d0", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "e0", "g0", "X", "m0", "oldMsgItem", "newMsgItem", "", "Z", "Lcom/tencent/guild/aio/chosen/data/GuildChosenMsgListDataManager$c;", "notifyData", "Y", "", "focusIndex", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "rsp", ExifInterface.LATITUDE_SOUTH, "", "source", FileReaderHelper.OPEN_FILE_FROM_FORCE, "n0", "l0", "msgItem", "U", "height", "T", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", BdhLogUtil.LogTag.Tag_Req, "c0", "channelId", "guildId", "h0", "b0", "msgSeqList", "k0", "msgItemList", "P", "", "curVisibleMsgSeqSet", "newVisibleMsgSeqSet", "N", "a0", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "onResume", "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", "w", "msg", com.tencent.luggage.wxa.c8.c.G, "p0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/Observable;", "", "data", "update", "Ljava/lang/Object;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/CopyOnWriteArrayList;", "D", "Ljava/util/concurrent/CopyOnWriteArrayList;", "displayList", "Lcom/tencent/aio/data/msglist/a;", "firstAIOMsg", UserInfo.SEX_FEMALE, "lastAIOMsg", "G", "visibleIds", "Ljava/util/concurrent/CopyOnWriteArraySet;", "H", "Ljava/util/concurrent/CopyOnWriteArraySet;", "visibleMsgSeqSet", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "backFillMsgMap", "Lcom/tencent/guild/aio/chosen/data/GuildChosenMsgListDataManager;", "J", "Lkotlin/Lazy;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/guild/aio/chosen/data/GuildChosenMsgListDataManager;", "chosenMsgDataManager", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "K", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "com/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM$c", "L", "Lcom/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM$c;", "mAction", "com/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM$d", "M", "Lcom/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM$d;", "mActionR", "Lkotlin/Pair;", "Ljava/util/List;", "messageList", "messageRList", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChosenMsgListDataVM extends MsgListVMWrapper<at.b, MsgListUiState> implements Observer, LifecycleObserver {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a firstAIOMsg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a lastAIOMsg;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy chosenMsgDataManager;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final c mAction;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final d mActionR;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, c>> messageList;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, d>> messageRList;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Object lock = new Object();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> displayList = new CopyOnWriteArrayList<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<Long> visibleIds = new CopyOnWriteArrayList<>();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<Long> visibleMsgSeqSet = new CopyOnWriteArraySet<>();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, Long> backFillMsgMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110107a;

        static {
            int[] iArr = new int[GuildChosenMsgListDataManager.RefreshType.values().length];
            try {
                iArr[GuildChosenMsgListDataManager.RefreshType.REFRESH_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildChosenMsgListDataManager.RefreshType.REFRESH_JUMP_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f110107a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildChosenMsgListDataVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM$d", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.mvi.base.route.b {
        d() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildChosenMsgListDataVM.this.I(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J<\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/guild/aio/chosen/msglist/GuildChosenMsgListDataVM$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "topMsgList", "oldMsgList", "", "b", "", "guildId", "channelId", "fromTinyId", "onChannelTopMsgUpdated", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void b(ArrayList<IGProTopMsg> topMsgList, ArrayList<IGProTopMsg> oldMsgList) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            GuildMultiMsgManager a16 = GuildMultiMsgManager.INSTANCE.a();
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildChosenMsgListDataVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) GuildChosenMsgListDataVM.this.getMContext()));
            if (a16.i(dVar)) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(topMsgList, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = topMsgList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((IGProTopMsg) it.next()).getTopMsgSeq()));
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : oldMsgList) {
                    if (!arrayList.contains(Long.valueOf(((IGProTopMsg) obj).getTopMsgSeq()))) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    arrayList3.add(Long.valueOf(((IGProTopMsg) it5.next()).getTopMsgSeq()));
                }
                a16.l(dVar, arrayList3);
                ((com.tencent.aio.api.runtime.a) GuildChosenMsgListDataVM.this.getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectCountChangeEvent());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelTopMsgUpdated(@NotNull String guildId, @NotNull String channelId, @NotNull String fromTinyId, @NotNull ArrayList<IGProTopMsg> topMsgList, @NotNull ArrayList<IGProTopMsg> oldMsgList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(fromTinyId, "fromTinyId");
            Intrinsics.checkNotNullParameter(topMsgList, "topMsgList");
            Intrinsics.checkNotNullParameter(oldMsgList, "oldMsgList");
            if (TextUtils.equals(guildId, ((com.tencent.aio.api.runtime.a) GuildChosenMsgListDataVM.this.getMContext()).g().r().c().f()) && TextUtils.equals(channelId, ((com.tencent.aio.api.runtime.a) GuildChosenMsgListDataVM.this.getMContext()).g().r().c().j())) {
                b(topMsgList, oldMsgList);
                GuildChosenMsgListDataVM.this.Q().k(GuildChosenMsgListDataManager.RefreshType.REFRESH_NONE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    public GuildChosenMsgListDataVM() {
        Lazy lazy;
        List<Pair<String, c>> listOf;
        List<Pair<String, d>> listOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildChosenMsgListDataManager>() { // from class: com.tencent.guild.aio.chosen.msglist.GuildChosenMsgListDataVM$chosenMsgDataManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildChosenMsgListDataManager invoke() {
                Contact contact = new Contact();
                GuildChosenMsgListDataVM guildChosenMsgListDataVM = GuildChosenMsgListDataVM.this;
                contact.chatType = ((com.tencent.aio.api.runtime.a) guildChosenMsgListDataVM.getMContext()).g().r().c().e();
                contact.guildId = ((com.tencent.aio.api.runtime.a) guildChosenMsgListDataVM.getMContext()).g().r().c().f();
                contact.peerUid = ((com.tencent.aio.api.runtime.a) guildChosenMsgListDataVM.getMContext()).g().r().c().j();
                GuildChosenMsgListDataManager guildChosenMsgListDataManager = new GuildChosenMsgListDataManager(contact);
                guildChosenMsgListDataManager.k(GuildChosenMsgListDataManager.RefreshType.REFRESH_JUMP_BOTTOM);
                return guildChosenMsgListDataManager;
            }
        });
        this.chosenMsgDataManager = lazy;
        this.mGPServiceObserver = new e();
        c cVar = new c();
        this.mAction = cVar;
        d dVar = new d();
        this.mActionR = dVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), cVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), cVar), new Pair(Reflection.getOrCreateKotlinClass(GuildChosenMsgInputHeightChange.class).getQualifiedName(), cVar)});
        this.messageList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIORichMediaMsgListEvent.class).getQualifiedName(), dVar));
        this.messageRList = listOf2;
    }

    private final boolean N(Set<Long> curVisibleMsgSeqSet, Set<Long> newVisibleMsgSeqSet) {
        if (curVisibleMsgSeqSet.size() == newVisibleMsgSeqSet.size() && curVisibleMsgSeqSet.containsAll(newVisibleMsgSeqSet)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MsgListRepo O() {
        GuildMsgListRepo guildMsgListRepo = new GuildMsgListRepo((com.tencent.aio.api.runtime.a) getMContext(), vmScope());
        guildMsgListRepo.Y(new com.tencent.guild.aio.chosen.msglist.b(guildMsgListRepo));
        return guildMsgListRepo;
    }

    private final void P(int firstPosition, int lastPosition, List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        GuildMsgItem guildMsgItem;
        QLog.d("GuildChosenMsgListDataVM", 1, "exposureVisibleMsgSeqList firstPosition = " + firstPosition + " lastPosition = " + lastPosition + " msgItemListSize = " + msgItemList.size());
        if (msgItemList.isEmpty()) {
            QLog.i("GuildChosenMsgListDataVM", 1, "[exposureVisibleMsgSeqList] msgItemList is empty!");
            return;
        }
        int i3 = firstPosition - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = lastPosition + 1;
        if (i16 > msgItemList.size()) {
            i16 = msgItemList.size();
        }
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        for (int i17 = i3; i17 < i16; i17++) {
            com.tencent.aio.data.msglist.a aVar = msgItemList.get(i17);
            if (aVar instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) aVar;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem != null) {
                if (guildMsgItem.getMsgSeq() > 0) {
                    copyOnWriteArraySet.add(Long.valueOf(guildMsgItem.getMsgSeq()));
                }
                Long l3 = this.backFillMsgMap.get(Long.valueOf(aVar.getMsgId()));
                if (l3 != null && l3.longValue() > 0) {
                    if (l3.longValue() == aVar.getMsgSeq()) {
                        this.backFillMsgMap.remove(Long.valueOf(aVar.getMsgId()));
                    } else {
                        copyOnWriteArraySet.add(l3);
                    }
                }
                ReplyElement a16 = com.tencent.guild.api.data.msglist.a.a(guildMsgItem);
                if (a16 != null) {
                    Long l16 = a16.replayMsgSeq;
                    Intrinsics.checkNotNullExpressionValue(l16, "replyElement.replayMsgSeq");
                    if (l16.longValue() > 0) {
                        copyOnWriteArraySet.add(a16.replayMsgSeq);
                    }
                    Long l17 = a16.replayMsgRootSeq;
                    Intrinsics.checkNotNullExpressionValue(l17, "replyElement.replayMsgRootSeq");
                    if (l17.longValue() > 0) {
                        copyOnWriteArraySet.add(a16.replayMsgRootSeq);
                    }
                }
            }
        }
        if (copyOnWriteArraySet.isEmpty()) {
            QLog.d("GuildChosenMsgListDataVM", 1, "newVisibleMsgSeqSet empty!");
            return;
        }
        if (!N(this.visibleMsgSeqSet, copyOnWriteArraySet)) {
            QLog.d("GuildChosenMsgListDataVM", 1, "checkVisibleMsgSeqSetChanged false!");
            return;
        }
        this.visibleMsgSeqSet.clear();
        this.visibleMsgSeqSet.addAll(copyOnWriteArraySet);
        String str = "";
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setCurOnScreenMsg(l.f112634a.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), hashCode(), new ArrayList<>(this.visibleMsgSeqSet));
        }
        Iterator<T> it = this.visibleMsgSeqSet.iterator();
        while (it.hasNext()) {
            str = ((Object) str) + " msgSeq = " + ((Long) it.next());
        }
        QLog.d("GuildChosenMsgListDataVM", 1, "exposureMsg exposureVisibleMsgSeqList firstPosition = " + firstPosition + " lastPosition = " + lastPosition + " beginIndex = " + i3 + " endIndex = " + i16 + " visibleMsgSeqSetString = " + ((Object) str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildChosenMsgListDataManager Q() {
        return (GuildChosenMsgListDataManager) this.chosenMsgDataManager.getValue();
    }

    private final List<MsgRecord> R(MsgRecord msgRecord) {
        GuildMsgItem guildMsgItem;
        CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = this.displayList;
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            com.tencent.aio.data.msglist.a fit = (com.tencent.aio.data.msglist.a) obj;
            j jVar = j.f110625a;
            Intrinsics.checkNotNullExpressionValue(fit, "fit");
            if (jVar.c(fit, true)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (com.tencent.aio.data.msglist.a aVar : arrayList) {
            MsgRecord msgRecord2 = null;
            if (aVar instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) aVar;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem != null) {
                msgRecord2 = guildMsgItem.getMsgRecord();
            }
            if (msgRecord2 != null) {
                arrayList2.add(msgRecord2);
            }
        }
        return arrayList2;
    }

    private final void S(long focusIndex, h<GuildMsgItem> rsp) {
        boolean z16;
        synchronized (this.lock) {
            if (rsp.d()) {
                this.displayList.clear();
                CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = this.displayList;
                List<GuildMsgItem> a16 = rsp.a();
                ArrayList arrayList = new ArrayList();
                for (Object obj : a16) {
                    GuildMsgItem guildMsgItem = (GuildMsgItem) obj;
                    if (guildMsgItem.getMsgRecord().msgType != 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        Logger.f235387a.d().i("GuildChosenMsgListDataVM", 1, "handleFirstPage, filter msg class = " + guildMsgItem.getClass() + ", seq = " + guildMsgItem.getMsgSeq());
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
                copyOnWriteArrayList.addAll(arrayList);
                this.visibleIds.clear();
                Iterator<com.tencent.aio.data.msglist.a> it = this.displayList.iterator();
                while (it.hasNext()) {
                    this.visibleIds.add(Long.valueOf(it.next().getMsgId()));
                }
                o0(this, focusIndex, "handleFirstPage", false, 4, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void T(int height) {
        updateUI(new GuildMsgListViewState.GuildInputBarHeightChangeDataState(height));
    }

    private final void U(com.tencent.aio.data.msglist.a msgItem) {
        QLog.i("GuildChosenMsgListDataVM", 4, "handleMsgBubbleClick type=" + msgItem.getViewType());
        if (a0(msgItem)) {
            Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            b0(((GuildMsgItem) msgItem).getMsgRecord());
        } else {
            c0(msgItem);
        }
    }

    private final void W(int scrollState, int firstPosition, int lastPosition) {
        if (scrollState == 0) {
            P(firstPosition, lastPosition, new CopyOnWriteArrayList(this.displayList));
        }
    }

    private final void X(FileTransNotifyInfo fileInfo) {
        if (fileInfo.fileDownType == 2 && (!this.displayList.isEmpty()) && this.displayList.size() > 0) {
            Iterator<com.tencent.aio.data.msglist.a> it = this.displayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i16 = i3 + 1;
                com.tencent.aio.data.msglist.a iMsgItem = it.next();
                if (iMsgItem.getMsgId() == fileInfo.msgId) {
                    Intrinsics.checkNotNullExpressionValue(iMsgItem, "iMsgItem");
                    p0(iMsgItem, i3, fileInfo);
                    return;
                }
                i3 = i16;
            }
        }
    }

    private final void Y(GuildChosenMsgListDataManager.c notifyData) {
        int i3;
        long j3;
        GuildChosenMsgListDataManager.RefreshType c16 = notifyData.c();
        if (c16 == null) {
            i3 = -1;
        } else {
            i3 = b.f110107a[c16.ordinal()];
        }
        if (i3 != 1) {
            if (i3 == 2) {
                j3 = -1;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            j3 = -3;
        }
        boolean a16 = notifyData.a();
        String str = "result:" + notifyData.a();
        l lVar = l.f112634a;
        List<MsgRecord> b16 = notifyData.b();
        Intrinsics.checkNotNullExpressionValue(b16, "notifyData.msgRecordList");
        S(j3, new h<>(a16, 0, str, lVar.g(b16)));
    }

    private final boolean Z(com.tencent.aio.data.msglist.a oldMsgItem, com.tencent.aio.data.msglist.a newMsgItem) {
        if (newMsgItem.getMsgId() == oldMsgItem.getMsgId() && newMsgItem.getMsgSeq() != oldMsgItem.getMsgSeq()) {
            return true;
        }
        return false;
    }

    private final boolean a0(com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        return ((GuildMsgItem) msgItem).isMixMsg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b0(MsgRecord msgRecord) {
        FragmentActivity activity;
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 != null && (activity = c16.getActivity()) != null) {
            Contact contact = new Contact();
            contact.peerUid = msgRecord.peerUid;
            contact.guildId = msgRecord.guildId;
            in0.c.c(activity, contact, msgRecord.msgSeq, null, (com.tencent.aio.api.runtime.a) getMContext(), 0, 32, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c0(com.tencent.aio.data.msglist.a msgItem) {
        String f16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().f();
        String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
        if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
            h0(j3, f16, msgItem);
            return;
        }
        int channelPageSourceType = ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).getChannelPageSourceType();
        if (channelPageSourceType != 0) {
            if (channelPageSourceType != 3) {
                Intent guildChatPieIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity(), new LaunchGuildChatPieParam().l(f16).b(j3).k(BundleKt.bundleOf(TuplesKt.to("navigate_msg_seq", Long.valueOf(msgItem.getMsgSeq())))).r(true).o(1).f(true).a());
                Intrinsics.checkNotNullExpressionValue(guildChatPieIntent, "api(ILaunchGuildChatPieA\u2026equireActivity(), params)");
                ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity().startActivity(guildChatPieIntent);
                return;
            } else {
                i a16 = new i().b(j3).f(f16).e(BundleKt.bundleOf(TuplesKt.to("navigate_msg_seq", Long.valueOf(msgItem.getMsgSeq())))).d(com.tencent.guild.aio.factory.a.class.getName()).a();
                if (AppSetting.t(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity())) {
                    ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatFragment(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity(), a16);
                    return;
                } else {
                    ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchSplashGuildChatActivity(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity(), a16);
                    return;
                }
            }
        }
        h0(j3, f16, msgItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void d0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : msgList) {
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (TextUtils.equals(((GuildMsgItem) aVar).getMsgRecord().peerUid, j3)) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            synchronized (this.lock) {
                m0(arrayList);
                o0(this, -3L, "onMsgInfoListStatusUpdate", false, 4, null);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildChosenMsgListDataVM", 1, "onRichMediaDownloadComplete fileInfo: " + fileInfo);
        X(fileInfo);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgSendEvent.RichMediaDownloadCompleteEvent(fileInfo));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildChosenMsgListDataVM", 1, "onRichMediaDownloadProgressUpdate fileInfo: " + fileInfo);
        X(fileInfo);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgSendEvent.RichMediaDownloadProgressEvent(fileInfo));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h0(String channelId, String guildId, com.tencent.aio.data.msglist.a msgItem) {
        i a16 = new i().b(channelId).f(guildId).e(BundleKt.bundleOf(TuplesKt.to("navigate_msg_seq", Long.valueOf(msgItem.getMsgSeq())))).d(com.tencent.guild.aio.factory.a.class.getName()).a();
        if (((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).shouldLaunchInSplitViewMode(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity())) {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity(), a16);
        } else {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatActivity(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity(), a16);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity().overridePendingTransition(0, R.anim.f154480ae);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object i0(GuildChosenMsgListDataVM guildChosenMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildChosenMsgListDataVM.e0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object j0(GuildChosenMsgListDataVM guildChosenMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildChosenMsgListDataVM.g0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k0(List<Long> msgSeqList) {
        List<Long> list = msgSeqList;
        if (!list.isEmpty()) {
            this.visibleMsgSeqSet.addAll(list);
            String str = "";
            uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
            if (gProGuildMsgService != null) {
                gProGuildMsgService.setCurOnScreenMsg(l.f112634a.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), hashCode(), new ArrayList<>(this.visibleMsgSeqSet));
            }
            Iterator<T> it = this.visibleMsgSeqSet.iterator();
            while (it.hasNext()) {
                str = ((Object) str) + " msgSeq = " + ((Long) it.next());
            }
            QLog.d("GuildChosenMsgListDataVM", 1, "article exposureMsg tryToExposureBackFillMsg visibleMsgSeqSetString = " + ((Object) str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0 > ((com.tencent.aio.data.msglist.a) r2).getMsgSeq()) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l0() {
        Object first;
        Object last;
        Object last2;
        Object first2;
        if (this.displayList.isEmpty()) {
            return;
        }
        com.tencent.aio.data.msglist.a aVar = this.firstAIOMsg;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            long msgSeq = aVar.getMsgSeq();
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.displayList);
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.displayList);
        this.firstAIOMsg = (com.tencent.aio.data.msglist.a) first;
        com.tencent.aio.data.msglist.a aVar2 = this.lastAIOMsg;
        if (aVar2 != null) {
            Intrinsics.checkNotNull(aVar2);
            long msgSeq2 = aVar2.getMsgSeq();
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.displayList);
            if (msgSeq2 >= ((com.tencent.aio.data.msglist.a) last2).getMsgSeq()) {
                return;
            }
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.displayList);
        this.lastAIOMsg = (com.tencent.aio.data.msglist.a) last;
    }

    private final void m0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        if (this.displayList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            int size = this.displayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (aVar.getMsgId() == this.displayList.get(i3).getMsgId() && aVar.getViewType() != 50) {
                    if (aVar.getMsgId() == this.displayList.get(i3).getMsgId()) {
                        com.tencent.aio.data.msglist.a aVar2 = this.displayList.get(i3);
                        Intrinsics.checkNotNullExpressionValue(aVar2, "displayList[i]");
                        if (Z(aVar2, aVar)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("GuildChosenMsgListDataVM", 1, "isBackFillMsg msgId = " + aVar.getMsgId() + " msgSeq = " + aVar.getMsgSeq());
                            }
                            this.backFillMsgMap.put(Long.valueOf(aVar.getMsgId()), Long.valueOf(aVar.getMsgSeq()));
                            arrayList.add(Long.valueOf(aVar.getMsgSeq()));
                        }
                    }
                    this.displayList.set(i3, aVar);
                }
            }
        }
        k0(arrayList);
        CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = this.displayList;
        if (copyOnWriteArrayList.size() > 1) {
            if (Build.VERSION.SDK_INT > 25) {
                if (copyOnWriteArrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(copyOnWriteArrayList, new f());
                }
            } else {
                ArrayList arrayList2 = new ArrayList(copyOnWriteArrayList);
                if (arrayList2.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new g());
                }
                copyOnWriteArrayList.clear();
                copyOnWriteArrayList.addAll(arrayList2);
            }
        }
    }

    private final void n0(long focusIndex, String source, boolean force) {
        l0();
        Bundle bundle = null;
        if (focusIndex == -1) {
            QLog.i("GuildChosenMsgListDataVM", 1, "[notifyMsgChange][withLocation], FOCUS_BOTTOM, source: " + source);
            bundle = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a, false, false, 2, null);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("GuildChosenMsgListDataVM", 4, "[notifyMsgChange], no change, source: " + source);
        }
        updateUI(new GuildMsgListDataState(this.displayList, force, null, 3, bundle));
    }

    static /* synthetic */ void o0(GuildChosenMsgListDataVM guildChosenMsgListDataVM, long j3, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        guildChosenMsgListDataVM.n0(j3, str, z16);
    }

    public final void E(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            n0(-3L, "GuildMultiSelectModeChangeEvent", true);
        } else if (intent instanceof GuildMsgListIntent.GuildMsgItemContentViewClickEvent) {
            U(((GuildMsgListIntent.GuildMsgItemContentViewClickEvent) intent).getMsgItem());
        } else if (intent instanceof GuildChosenMsgInputHeightChange) {
            T(((GuildChosenMsgInputHeightChange) intent).getHeight());
        }
    }

    @NotNull
    public final k I(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildMsgListIntent.GetAIORichMediaMsgListEvent) {
            return new i.c(R(((GuildMsgListIntent.GetAIORichMediaMsgListEvent) intent).getMsgRecord()));
        }
        return pn0.b.f426490a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull at.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof MsgListIntent.a) {
            p((MsgListIntent.a) intent);
            return;
        }
        if (intent instanceof a.g) {
            a.g gVar = (a.g) intent;
            W(gVar.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String(), gVar.getFirstPosition(), gVar.getLastPosition());
        } else if (intent instanceof a.d) {
            w();
        } else if (intent instanceof a.C1178a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildChosenMsgIntent.ChosenMsgSizeChange(((a.C1178a) intent).getSize()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        Q().g();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGPServiceObserver);
        }
        Q().i(this);
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.messageRList.iterator();
        while (it5.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) ((Pair) it5.next()).getFirst());
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("GuildChosenMsgListDataVM", 1, "[onResume]");
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void p(@NotNull MsgListIntent.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.e() == 0) {
            P(intent.a(), intent.c(), new CopyOnWriteArrayList(this.displayList));
        }
    }

    public final void p0(@NotNull com.tencent.aio.data.msglist.a msg2, int pos, @NotNull FileTransNotifyInfo fileInfo) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        MsgRecord msgRecord = ((GuildMsgItem) msg2).getMsgRecord();
        int i3 = msgRecord.msgType;
        int i16 = 0;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 7) {
                    int size = msgRecord.elements.size();
                    while (i16 < size) {
                        if (msgRecord.elements.get(i16).elementId == fileInfo.msgElementId) {
                            if (msgRecord.elements.get(i16).videoElement != null) {
                                msgRecord.elements.get(i16).videoElement.transferStatus = Integer.valueOf(fileInfo.trasferStatus);
                                VideoElement videoElement = msgRecord.elements.get(i16).videoElement;
                                x xVar = x.f112474a;
                                MsgElement msgElement = msgRecord.elements.get(i16);
                                Intrinsics.checkNotNullExpressionValue(msgElement, "msgRecord.elements[i]");
                                videoElement.progress = Integer.valueOf(xVar.b(msgElement, 5, fileInfo.fileProgress));
                                updateUI(new GuildMsgListViewState.GuildMsgItemChangedState(pos));
                                return;
                            }
                            return;
                        }
                        i16++;
                    }
                    return;
                }
                return;
            }
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            if (arrayList != null && arrayList.size() > 0) {
                int size2 = msgRecord.elements.size();
                while (i16 < size2) {
                    if (msgRecord.elements.get(i16).elementId == fileInfo.msgElementId) {
                        if (msgRecord.elements.get(i16).fileElement != null) {
                            msgRecord.elements.get(i16).fileElement.transferStatus = Integer.valueOf(fileInfo.trasferStatus);
                            FileElement fileElement = msgRecord.elements.get(i16).fileElement;
                            x xVar2 = x.f112474a;
                            MsgElement msgElement2 = msgRecord.elements.get(i16);
                            Intrinsics.checkNotNullExpressionValue(msgElement2, "msgRecord.elements[i]");
                            fileElement.progress = Integer.valueOf(xVar2.b(msgElement2, 3, fileInfo.fileProgress));
                            updateUI(new GuildMsgListViewState.GuildMsgItemChangedState(pos));
                            return;
                        }
                        return;
                    }
                    i16++;
                }
                return;
            }
            return;
        }
        ArrayList<MsgElement> arrayList2 = msgRecord.elements;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size3 = msgRecord.elements.size();
            while (i16 < size3) {
                if (msgRecord.elements.get(i16).elementId == fileInfo.msgElementId) {
                    if (msgRecord.elements.get(i16).picElement != null) {
                        msgRecord.elements.get(i16).picElement.transferStatus = Integer.valueOf(fileInfo.trasferStatus);
                        PicElement picElement = msgRecord.elements.get(i16).picElement;
                        x xVar3 = x.f112474a;
                        MsgElement msgElement3 = msgRecord.elements.get(i16);
                        Intrinsics.checkNotNullExpressionValue(msgElement3, "msgRecord.elements[i]");
                        picElement.progress = Integer.valueOf(xVar3.b(msgElement3, 2, fileInfo.fileProgress));
                        updateUI(new GuildMsgListViewState.GuildMsgItemChangedState(pos));
                        return;
                    }
                    return;
                }
                i16++;
            }
        }
    }

    @Override // java.util.Observer
    public void update(@Nullable Observable o16, @Nullable Object data) {
        if (data instanceof GuildChosenMsgListDataManager.c) {
            Y((GuildChosenMsgListDataManager.c) data);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void w() {
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.x(), new GuildChosenMsgListDataVM$registerMsgNotification$1(this, null)), Dispatchers.getIO()), vmScope());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.B(), new GuildChosenMsgListDataVM$registerMsgNotification$2(this)), Dispatchers.getIO()), vmScope());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.C(), new GuildChosenMsgListDataVM$registerMsgNotification$3(this)), Dispatchers.getIO()), vmScope());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        z(O());
        super.onCreate(context);
        if (y.a() == null) {
            QLog.e("GuildChosenMsgListDataVM", 1, "[onCreate] fail, session is null");
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#event#chosen_service_init_error");
            return;
        }
        com.tencent.guild.aio.util.ex.a.m((com.tencent.aio.api.runtime.a) getMContext(), FromScene.CHOSEN.ordinal());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.mGPServiceObserver);
        }
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            context.e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.messageRList.iterator();
        while (it5.hasNext()) {
            Pair pair2 = (Pair) it5.next();
            context.e().j((String) pair2.getFirst(), (com.tencent.mvi.base.route.b) pair2.getSecond());
        }
        Q().f(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
    }
}
