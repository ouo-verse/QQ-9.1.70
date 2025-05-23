package com.tencent.mobileqq.guild.message.directmessage.model.repositories;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.WorkerThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.RepositoryCallbackConfig;
import com.tencent.mobileqq.guild.base.repository.ResultDispatcher;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNodeKt;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNodeList;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.utils.DiagnosisUtils;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.DirectSessionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001=\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b{\u0010tJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J0\u0010\u0018\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\u00032\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u0007J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\u0003H\u0007J\u0012\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0007J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0007J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0007J\u001c\u0010)\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0'0&H\u0007J4\u0010.\u001a\u00020\u00052\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,2\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0'0&H\u0007J\b\u0010/\u001a\u00020\u0005H\u0002J\u001e\u00103\u001a\u00020\u00122\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0'2\u0006\u00102\u001a\u000201H\u0003J\u0016\u00104\u001a\u00020\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030'H\u0003J\b\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020\u0005H\u0002J\b\u00107\u001a\u00020\u0005H\u0002J\b\u00108\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u000209H\u0002J\b\u0010<\u001a\u00020;H\u0002J\u000f\u0010>\u001a\u00020=H\u0002\u00a2\u0006\u0004\b>\u0010?J\f\u0010@\u001a\u00020\u001d*\u00020\u001dH\u0002R\u0014\u0010C\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\"0J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010U\u001a\u0004\bV\u0010WR\u001b\u0010\\\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010U\u001a\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010U\u001a\u0004\b_\u0010`R\u001b\u0010e\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010U\u001a\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010gR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010jR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010jR\u0014\u0010p\u001a\u00020m8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bn\u0010oR \u0010u\u001a\b\u0012\u0004\u0012\u00020\u001d0'8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bs\u0010t\u001a\u0004\bq\u0010rR \u0010x\u001a\b\u0012\u0004\u0012\u00020\u001d0'8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\bw\u0010t\u001a\u0004\bv\u0010rR\u0014\u0010z\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010y\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/DirectMessageNodeRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "", "account", "", "onAccountChanged", "channelId", "", "notifyType", "O", "guildId", "tinyId", "", "", "H", "Lcom/tencent/mobileqq/qqguildsdk/data/k;", SessionDbHelper.SESSION_ID, "", "isInBlack", "P", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "ext", "a0", "Landroid/view/View;", "view", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "v", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/a;", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/l;", "listener", "p", "W", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "guildIds", HippyTKDListViewAdapter.X, "U", "nodes", "Lcom/tencent/mobileqq/guild/message/directmessage/utils/DiagnosisUtils$UpdateSource;", "source", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "X", "Y", "r", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "t", "Lcom/tencent/mobileqq/guild/summary/d;", "u", "com/tencent/mobileqq/guild/message/directmessage/model/repositories/DirectMessageNodeRepository$createDirectSessionListener$1", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/DirectMessageNodeRepository$createDirectSessionListener$1;", "B", "f", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gproServiceObserver", tl.h.F, "Lcom/tencent/mobileqq/guild/summary/d;", "guildSummaryObserver", "i", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/DirectMessageNodeRepository$createDirectSessionListener$1;", "directSessionListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Lkotlin/Lazy;", "J", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "I", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "gproGlobalService", "Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryApi;", "G", "K", "()Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryApi;", "guildSummaryApi", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", "L", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", "igProSession", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/DirectMessageNodeList;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/DirectMessageNodeList;", "directMessageNodes", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "notifySequence", "notifyPendingSequence", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "M", "()Ljava/util/List;", "getMessageNodes$annotations", "()V", "messageNodes", "N", "getMessageNodesForUi$annotations", "messageNodesForUi", "()Ljava/lang/String;", "activeTinyId", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DirectMessageNodeRepository implements com.tencent.mobileqq.guild.base.repository.a, com.tencent.mobileqq.guild.base.repository.b {

    /* renamed from: C, reason: from kotlin metadata */
    private static AppInterface appInterface;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private static final RuntimeServiceHolder serviceHolder;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private static final Lazy gproService;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static final Lazy gproGlobalService;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static final Lazy guildSummaryApi;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private static final Lazy igProSession;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private static DirectMessageNodeList directMessageNodes;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private static final AtomicLong notifySequence;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private static final AtomicLong notifyPendingSequence;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final DirectMessageNodeRepository f230483e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GPServiceObserver gproServiceObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.summary.d guildSummaryObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DirectMessageNodeRepository$createDirectSessionListener$1 directSessionListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<l> listeners;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.guild.base.repository.d f230488d = new com.tencent.mobileqq.guild.base.repository.d("DirectMessageNodeRepository");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/message/directmessage/model/repositories/DirectMessageNodeRepository$a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements IGuildOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f230499a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f230500b;

        a(String str, String str2) {
            this.f230499a = str;
            this.f230500b = str2;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
        public void onResult(int result, @Nullable String errMsg) {
            String str = "deleteDirectSessionMsgRecords(" + this.f230499a + ", " + this.f230500b + ") result: " + result + ", errMsg: " + errMsg;
            if (result != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.C2C.DirectMessageNodeRepository", 1, (String) it.next(), null);
                }
                QQToastUtil.showQQToast(1, errMsg);
                return;
            }
            QQToastUtil.showQQToast(2, "\u5df2\u5220\u9664");
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.C2C.DirectMessageNodeRepository", 2, str);
            }
        }
    }

    static {
        DirectMessageNodeRepository directMessageNodeRepository = new DirectMessageNodeRepository();
        f230483e = directMessageNodeRepository;
        gproServiceObserver = directMessageNodeRepository.t();
        guildSummaryObserver = directMessageNodeRepository.u();
        directSessionListener = directMessageNodeRepository.s();
        listeners = new CopyOnWriteArrayList<>();
        RuntimeServiceHolder runtimeServiceHolder = new RuntimeServiceHolder();
        serviceHolder = runtimeServiceHolder;
        gproService = runtimeServiceHolder.a("", IGPSService.class);
        gproGlobalService = runtimeServiceHolder.a("", IGProGlobalService.class);
        guildSummaryApi = runtimeServiceHolder.a("", IGuildSummaryApi.class);
        igProSession = runtimeServiceHolder.a("", IGProSession.class);
        directMessageNodes = new DirectMessageNodeList();
        notifySequence = new AtomicLong(0L);
        notifyPendingSequence = new AtomicLong(0L);
        AccountChangedNotifier.f214789d.a(directMessageNodeRepository);
        directMessageNodeRepository.Y();
    }

    DirectMessageNodeRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ResultDispatcher this_withCallback, int i3, String str) {
        Intrinsics.checkNotNullParameter(this_withCallback, "$this_withCallback");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "fetchList from sessionService: -> " + i3 + ", " + str);
        }
        this_withCallback.c(M());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DirectMessageNode B(DirectMessageNode directMessageNode) {
        GuildSummaryData summary = f230483e.K().getSummary(directMessageNode.getGuildId(), directMessageNode.getChannelId(), true);
        directMessageNode.u(summary.getLastMessage());
        directMessageNode.w(summary.getUnreadInfo());
        directMessageNode.s(summary.getDraftInfo());
        return directMessageNode;
    }

    @JvmStatic
    @Nullable
    public static final DirectMessageNode C(@NotNull String channelId) {
        Object obj;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Iterator<T> it = M().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DirectMessageNode) obj).getChannelId(), channelId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (DirectMessageNode) obj;
    }

    @JvmStatic
    @Nullable
    public static final DirectMessageNode D(@NotNull String guildId) {
        Object obj;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Iterator<T> it = M().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DirectMessageNode) obj).getGuildId(), guildId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (DirectMessageNode) obj;
    }

    @JvmStatic
    @Nullable
    public static final DirectMessageNode E(@NotNull String tinyId) {
        Object obj;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Iterator<T> it = M().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DirectMessageNode) obj).getSource().getTinyId(), tinyId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (DirectMessageNode) obj;
    }

    @JvmStatic
    @Nullable
    public static final String F(@NotNull String guildId) {
        Object obj;
        MessageSource source;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Iterator<T> it = M().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DirectMessageNode) obj).getGuildId(), guildId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DirectMessageNode directMessageNode = (DirectMessageNode) obj;
        if (directMessageNode == null || (source = directMessageNode.getSource()) == null) {
            return null;
        }
        return source.getGuildId();
    }

    private final String G() {
        String selfTinyId = J().getSelfTinyId();
        if (selfTinyId == null) {
            return "";
        }
        return selfTinyId;
    }

    private final IGProGlobalService I() {
        return (IGProGlobalService) gproGlobalService.getValue();
    }

    private final IGPSService J() {
        return (IGPSService) gproService.getValue();
    }

    private final IGuildSummaryApi K() {
        return (IGuildSummaryApi) guildSummaryApi.getValue();
    }

    private final IGProSession L() {
        return (IGProSession) igProSession.getValue();
    }

    @NotNull
    public static final List<DirectMessageNode> M() {
        return directMessageNodes.f();
    }

    @NotNull
    public static final List<DirectMessageNode> N() {
        int collectionSizeOrDefault;
        List<DirectMessageNode> f16 = directMessageNodes.f();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(f16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = f16.iterator();
        while (it.hasNext()) {
            arrayList.add(f230483e.B((DirectMessageNode) it.next()));
        }
        return arrayList;
    }

    @JvmStatic
    public static final void P(@NotNull final com.tencent.mobileqq.qqguildsdk.data.k session, final boolean isInBlack) {
        Intrinsics.checkNotNullParameter(session, "session");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$handleSessionCreated$$inlined$executeOnWorkThread$1
            @Override // java.lang.Runnable
            public final void run() {
                DirectMessageNode B;
                List listOf;
                DirectMessageNodeRepository directMessageNodeRepository = DirectMessageNodeRepository.f230483e;
                B = directMessageNodeRepository.B(DirectMessageNode.INSTANCE.c(com.tencent.mobileqq.qqguildsdk.data.k.this));
                B.t(isInBlack);
                B.x(true);
                listOf = CollectionsKt__CollectionsJVMKt.listOf(B);
                directMessageNodeRepository.q(listOf, DiagnosisUtils.UpdateSource.CreateSession);
            }
        });
    }

    private final void Q(View view, Activity activity, String guildId, String tinyId) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, "pg_sgrp_mvp_private_list");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        long incrementAndGet = notifySequence.incrementAndGet();
        if (notifyPendingSequence.compareAndSet(0L, incrementAndGet)) {
            S();
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "notifyListeners() runnable already pending, runningSeq=" + notifyPendingSequence.get() + " newSeq=" + incrementAndGet);
        }
    }

    private static final void S() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.c
            @Override // java.lang.Runnable
            public final void run() {
                DirectMessageNodeRepository.T();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T() {
        long j3 = notifyPendingSequence.get();
        List<DirectMessageNode> M = M();
        ArrayList arrayList = new ArrayList();
        for (Object obj : M) {
            if (!((DirectMessageNode) obj).getIsInBlack()) {
                arrayList.add(obj);
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "notifyListeners() on uiThread, with seq=" + j3);
        }
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((l) it.next()).r0(arrayList);
        }
        AtomicLong atomicLong = notifyPendingSequence;
        atomicLong.set(0L);
        AtomicLong atomicLong2 = notifySequence;
        if (atomicLong2.get() != j3) {
            if (atomicLong.compareAndSet(0L, atomicLong2.get())) {
                S();
                return;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "notifyListeners() submit by outside, runningSeq=" + notifyPendingSequence.get() + " newSeq=" + notifySequence.get());
            }
        }
    }

    private final void U() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "refreshMessageList()");
        }
        z(new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.f
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                DirectMessageNodeRepository.V(aVar, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ri1.a err, List list) {
        Intrinsics.checkNotNullParameter(err, "err");
        if (err.d()) {
            f230483e.R();
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "refreshMessageList() failed: " + err;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.C2C.DirectMessageNodeRepository", 1, (String) it.next(), null);
        }
    }

    @JvmStatic
    public static final void W(@NotNull l listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    private final void X() {
        r();
        Y();
        R();
    }

    private final void Y() {
        notifySequence.set(0L);
        notifyPendingSequence.set(0L);
        serviceHolder.e();
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        appInterface = l3;
        I().addObserver(gproServiceObserver);
        K().registerSummaryUpdateCallback(guildSummaryObserver);
        uh2.a gProDirectSessionService = L().getGProDirectSessionService();
        if (gProDirectSessionService != null) {
            gProDirectSessionService.addKernelDirectSessionListener(directSessionListener);
        }
        uh2.a gProDirectSessionService2 = L().getGProDirectSessionService();
        if (gProDirectSessionService2 != null) {
            gProDirectSessionService2.getDirectSessionList(new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    DirectMessageNodeRepository.Z(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(int i3, String str) {
        Logger.f235387a.d().i("Guild.C2C.DirectMessageNodeRepository", 1, "getDirectSessionList: " + i3 + ", " + str);
    }

    @JvmStatic
    public static final void a0(@Nullable Activity activity, @NotNull final String guildId, @Nullable final Map<String, String> ext) {
        String str;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        final String str2 = "em_sgrp_private_delete_pop";
        if (ext == null || (str = ext.get("extra_target_tiny_id")) == null) {
            str = "";
        }
        final String str3 = str;
        if (activity != null) {
            ActionSheet actionSheet = null;
            Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
            if (createDialog instanceof ActionSheet) {
                actionSheet = (ActionSheet) createDialog;
            }
            final ActionSheet actionSheet2 = actionSheet;
            if (actionSheet2 != null) {
                actionSheet2.setMainTitle(R.string.f143050l1);
                actionSheet2.addButton(R.string.f143030kz, 3);
                actionSheet2.addCancelButton(R.string.f140850f3);
                actionSheet2.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.d
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view, int i3) {
                        DirectMessageNodeRepository.b0(ActionSheet.this, str2, guildId, str3, ext, view, i3);
                    }
                });
                actionSheet2.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DirectMessageNodeRepository.c0(str2, guildId, str3, actionSheet2, view);
                    }
                });
                actionSheet2.show();
                ViewGroup rootView = actionSheet2.getRootView();
                if (rootView != null) {
                    Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                    f230483e.Q(rootView, activity, guildId, str3);
                }
                LinearLayout mContentContainer = actionSheet2.mContentContainer;
                if (mContentContainer != null) {
                    Intrinsics.checkNotNullExpressionValue(mContentContainer, "mContentContainer");
                    ChannelSettingUtils.g(mContentContainer, "em_sgrp_private_delete_pop", f230483e.H(guildId, str3));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(ActionSheet this_apply, String elementId, String guildId, String tinyId, Map map, View clickedView, int i3) {
        Map plus;
        String str;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        if (i3 == 0) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToast(1, R.string.f1511016s);
                this_apply.dismiss();
                return;
            }
            Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
            plus = MapsKt__MapsKt.plus(f230483e.H(guildId, tinyId), TuplesKt.to("sgrp_btn_type", "1"));
            ChannelSettingUtils.i(clickedView, elementId, plus);
            if (map == null || (str = (String) map.get("extra_channel_id")) == null) {
                str = "";
            }
            v(guildId, str);
        }
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(String elementId, String guildId, String tinyId, ActionSheet this_apply, View clickedView) {
        Map plus;
        EventCollector.getInstance().onViewClickedBefore(clickedView);
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
        plus = MapsKt__MapsKt.plus(f230483e.H(guildId, tinyId), TuplesKt.to("sgrp_btn_type", "2"));
        ChannelSettingUtils.i(clickedView, elementId, plus);
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(clickedView);
    }

    @JvmStatic
    public static final void p(@NotNull l listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.addIfAbsent(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final boolean q(List<DirectMessageNode> nodes, DiagnosisUtils.UpdateSource source) {
        boolean b16 = directMessageNodes.b(nodes, source);
        if (b16) {
            R();
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "updateNodes: " + nodes.size() + ", source: " + source + ", changed: " + b16);
        }
        return b16;
    }

    private final void r() {
        directMessageNodes = new DirectMessageNodeList();
        I().deleteObserver(gproServiceObserver);
        K().unregisterSummaryUpdateCallback(guildSummaryObserver);
        uh2.a gProDirectSessionService = L().getGProDirectSessionService();
        if (gProDirectSessionService != null) {
            gProDirectSessionService.removeKernelDirectSessionListener(directSessionListener);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createDirectSessionListener$1] */
    private final DirectMessageNodeRepository$createDirectSessionListener$1 s() {
        return new IKernelDirectSessionListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createDirectSessionListener$1
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
            public /* synthetic */ void onCreateDirectSession(DirectSessionInfo directSessionInfo, int i3) {
                com.tencent.qqnt.kernelgpro.nativeinterface.a.a(this, directSessionInfo, i3);
            }

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
            public void onDirectSessionListChanged(@Nullable ArrayList<String> sortedGuildIdList, @Nullable final ArrayList<DirectSessionInfo> changedList, @Nullable final ArrayList<String> deletedGuildIdList, boolean isAll) {
                if (sortedGuildIdList != null && changedList != null && deletedGuildIdList != null) {
                    Logger.f235387a.d().i("Guild.C2C.DirectMessageNodeRepository", 1, "onDirectSessionListChanged(sortedGuildIdList=" + sortedGuildIdList.size() + ", changedList=" + changedList.size() + ", deletedGuildIdList=" + deletedGuildIdList.size() + ", isAll=" + isAll + ")");
                    if (isAll) {
                        DirectMessageNodeRepository directMessageNodeRepository = DirectMessageNodeRepository.f230483e;
                        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createDirectSessionListener$1$onDirectSessionListChanged$$inlined$executeOnWorkThread$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                List list;
                                Logger.f235387a.d().d("Guild.C2C.DirectMessageNodeRepository", 1, "onDirectSessionListChanged, load DirectSessionInfo... is all");
                                list = SequencesKt___SequencesKt.toList(DirectMessageNodeKt.a(changedList));
                                DirectMessageNodeRepository.f230483e.q(list, DiagnosisUtils.UpdateSource.NtsdkNotifyAllNodes);
                            }
                        });
                    } else if (!changedList.isEmpty()) {
                        DirectMessageNodeRepository directMessageNodeRepository2 = DirectMessageNodeRepository.f230483e;
                        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createDirectSessionListener$1$onDirectSessionListChanged$$inlined$executeOnWorkThread$2
                            @Override // java.lang.Runnable
                            public final void run() {
                                Sequence map;
                                List list;
                                Logger.f235387a.d().d("Guild.C2C.DirectMessageNodeRepository", 1, "onDirectSessionListChanged, partial nodes");
                                map = SequencesKt___SequencesKt.map(DirectMessageNodeKt.a(changedList), new Function1<DirectMessageNode, DirectMessageNode>() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createDirectSessionListener$1$onDirectSessionListChanged$3$directNodes$1
                                    @Override // kotlin.jvm.functions.Function1
                                    @NotNull
                                    public final DirectMessageNode invoke(@NotNull DirectMessageNode it) {
                                        DirectMessageNode B;
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        B = DirectMessageNodeRepository.f230483e.B(it);
                                        return B;
                                    }
                                });
                                list = SequencesKt___SequencesKt.toList(map);
                                DirectMessageNodeRepository.f230483e.q(list, DiagnosisUtils.UpdateSource.NtsdkNotifyPartialNodes);
                            }
                        });
                    }
                    if (!deletedGuildIdList.isEmpty()) {
                        DirectMessageNodeRepository directMessageNodeRepository3 = DirectMessageNodeRepository.f230483e;
                        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createDirectSessionListener$1$onDirectSessionListChanged$$inlined$executeOnWorkThread$3
                            @Override // java.lang.Runnable
                            public final void run() {
                                Logger.f235387a.d().i("Guild.C2C.DirectMessageNodeRepository", 1, "onDirectSessionListChanged, deleted " + deletedGuildIdList + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                DirectMessageNodeRepository.f230483e.w(deletedGuildIdList);
                            }
                        });
                    }
                }
            }

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
            public /* synthetic */ void onDirectSwitchStatus(int i3) {
                com.tencent.qqnt.kernelgpro.nativeinterface.a.c(this, i3);
            }

            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener
            public /* synthetic */ void onSetDirectSessionBlackStatus(DirectSessionInfo directSessionInfo, int i3) {
                com.tencent.qqnt.kernelgpro.nativeinterface.a.d(this, directSessionInfo, i3);
            }
        };
    }

    private final GPServiceObserver t() {
        return new GPServiceObserver() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createGproServiceObserver$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            public void onDirectMsgBlackChanged(@NotNull final String tinyId, final boolean isBlack) {
                Intrinsics.checkNotNullParameter(tinyId, "tinyId");
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "onDirectMsgBlackChanged(" + tinyId + "), isBlack=" + isBlack + "!");
                }
                DirectMessageNodeRepository directMessageNodeRepository = DirectMessageNodeRepository.f230483e;
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createGproServiceObserver$1$onDirectMsgBlackChanged$$inlined$executeOnWorkThread$1
                    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
                    
                        r1 = r2.c((r32 & 1) != 0 ? r2.guildId : null, (r32 & 2) != 0 ? r2.channelId : null, (r32 & 4) != 0 ? r2.notifyType : 0, (r32 & 8) != 0 ? r2.source : null, (r32 & 16) != 0 ? r2.eventTime : 0, (r32 & 32) != 0 ? r2.isInBlack : r2, (r32 & 64) != 0 ? r2.isVisible : false, (r32 & 128) != 0 ? r2.draftIdentify : 0, (r32 & 256) != 0 ? r2.memberType : 0, (r32 & 512) != 0 ? r2.lastMessage : null, (r32 & 1024) != 0 ? r2.unreadInfo : null, (r32 & 2048) != 0 ? r2.draftInfo : null, (r32 & 4096) != 0 ? r2._messageTime : 0);
                     */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        DirectMessageNode c16;
                        List listOf;
                        DirectMessageNode E = DirectMessageNodeRepository.E(tinyId);
                        if (E != null && c16 != null) {
                            DirectMessageNodeRepository directMessageNodeRepository2 = DirectMessageNodeRepository.f230483e;
                            listOf = CollectionsKt__CollectionsJVMKt.listOf(c16);
                            directMessageNodeRepository2.q(listOf, DiagnosisUtils.UpdateSource.BlackListChanged);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            protected void onPushDirectMsgNotifyUpdate(@NotNull String guildId, @NotNull String channelId, int notifyStatus) {
                Intrinsics.checkNotNullParameter(guildId, "guildId");
                Intrinsics.checkNotNullParameter(channelId, "channelId");
                Logger.f235387a.d().i("Guild.C2C.DirectMessageNodeRepository", 1, "onPushDirectMsgNotifyUpdate(" + guildId + "), notifyStatus=" + notifyStatus + "!");
                DirectMessageNodeRepository.f230483e.O(channelId, notifyStatus);
            }
        };
    }

    private final com.tencent.mobileqq.guild.summary.d u() {
        return new com.tencent.mobileqq.guild.summary.d() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createGuildSummaryObserver$1
            @Override // com.tencent.mobileqq.guild.summary.d
            public void a(@NotNull final List<GuildSummaryData> summaries) {
                Intrinsics.checkNotNullParameter(summaries, "summaries");
                DirectMessageNodeRepository directMessageNodeRepository = DirectMessageNodeRepository.f230483e;
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$createGuildSummaryObserver$1$onSummaryUpdate$$inlined$executeOnWorkThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DirectMessageNodeList directMessageNodeList;
                        DirectMessageNodeList directMessageNodeList2;
                        DirectMessageNode c16;
                        ArrayList arrayList = new ArrayList();
                        for (GuildSummaryData guildSummaryData : summaries) {
                            directMessageNodeList2 = DirectMessageNodeRepository.directMessageNodes;
                            DirectMessageNode e16 = directMessageNodeList2.e(guildSummaryData.getChannelId());
                            if (e16 != null) {
                                c16 = e16.c((r32 & 1) != 0 ? e16.guildId : null, (r32 & 2) != 0 ? e16.channelId : null, (r32 & 4) != 0 ? e16.notifyType : 0, (r32 & 8) != 0 ? e16.source : null, (r32 & 16) != 0 ? e16.eventTime : 0L, (r32 & 32) != 0 ? e16.isInBlack : false, (r32 & 64) != 0 ? e16.isVisible : false, (r32 & 128) != 0 ? e16.draftIdentify : 0, (r32 & 256) != 0 ? e16.memberType : 0, (r32 & 512) != 0 ? e16.lastMessage : guildSummaryData.getLastMessage(), (r32 & 1024) != 0 ? e16.unreadInfo : guildSummaryData.getUnreadInfo(), (r32 & 2048) != 0 ? e16.draftInfo : guildSummaryData.getDraftInfo(), (r32 & 4096) != 0 ? e16._messageTime : 0L);
                                arrayList.add(c16);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            directMessageNodeList = DirectMessageNodeRepository.directMessageNodes;
                            if (directMessageNodeList.b(arrayList, DiagnosisUtils.UpdateSource.SummaryUpdated)) {
                                DirectMessageNodeRepository.f230483e.R();
                            }
                        }
                    }
                });
            }
        };
    }

    @JvmStatic
    public static final void v(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        uh2.a gProDirectSessionService = f230483e.L().getGProDirectSessionService();
        if (gProDirectSessionService != null) {
            gProDirectSessionService.deleteDirectMsgRecordsAndDirectSession(guildId, channelId, new a(guildId, channelId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final boolean w(List<String> guildIds) {
        List<DirectMessageNode> g16 = directMessageNodes.g(guildIds);
        boolean z16 = !g16.isEmpty();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "deleteNodeByGuildId: guildIds = " + guildIds + ", deleted: " + z16);
        }
        if (z16) {
            for (DirectMessageNode directMessageNode : g16) {
                f230483e.K().removeSummary(directMessageNode.getGuildId(), directMessageNode.getChannelId());
            }
            R();
        }
        return z16;
    }

    @JvmStatic
    public static final void x(@NotNull ArrayList<Long> guildIds, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<DirectMessageNode>> callback) {
        Intrinsics.checkNotNullParameter(guildIds, "guildIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DirectMessageNodeRepository directMessageNodeRepository = f230483e;
        final ResultDispatcher resultDispatcher = new ResultDispatcher("fetchDirectList tinyId=" + directMessageNodeRepository.G(), callback, directMessageNodeRepository.getRepositoryCallbackConfig().getInlineDispatcher());
        uh2.a gProDirectSessionService = directMessageNodeRepository.L().getGProDirectSessionService();
        if (gProDirectSessionService != null) {
            gProDirectSessionService.fetchDirectSessionList(guildIds, new IFetchListCallback() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IFetchListCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    DirectMessageNodeRepository.y(ResultDispatcher.this, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ResultDispatcher this_withCallback, int i3, String str, ArrayList fetchList) {
        List list;
        Intrinsics.checkNotNullParameter(this_withCallback, "$this_withCallback");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "fetchDirectList from sessionService: -> " + i3 + ", " + str);
        }
        Intrinsics.checkNotNullExpressionValue(fetchList, "fetchList");
        list = SequencesKt___SequencesKt.toList(DirectMessageNodeKt.a(fetchList));
        this_withCallback.c(list);
    }

    @JvmStatic
    public static final void z(@NotNull com.tencent.mobileqq.guild.base.repository.h<List<DirectMessageNode>> callback) {
        boolean z16;
        List emptyList;
        Intrinsics.checkNotNullParameter(callback, "callback");
        DirectMessageNodeRepository directMessageNodeRepository = f230483e;
        final ResultDispatcher resultDispatcher = new ResultDispatcher("fetchList tinyId=" + directMessageNodeRepository.G(), callback, directMessageNodeRepository.getRepositoryCallbackConfig().getInlineDispatcher());
        if (directMessageNodeRepository.G().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            resultDispatcher.c(emptyList);
        } else {
            uh2.a gProDirectSessionService = directMessageNodeRepository.L().getGProDirectSessionService();
            if (gProDirectSessionService != null) {
                gProDirectSessionService.getDirectSessionList(new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.g
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                    public final void onResult(int i3, String str) {
                        DirectMessageNodeRepository.A(ResultDispatcher.this, i3, str);
                    }
                });
            }
        }
    }

    @NotNull
    public final Map<String, Object> H(@NotNull String guildId, @NotNull String tinyId) {
        Map<String, Object> mapOf;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_touin", tinyId), TuplesKt.to("sgrp_channel_id", guildId));
        return mapOf;
    }

    public final void O(@NotNull final String channelId, final int notifyType) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository$handleNotifyTypeChanged$$inlined$executeOnWorkThread$1
            /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
            
                r1 = r2.c((r32 & 1) != 0 ? r2.guildId : null, (r32 & 2) != 0 ? r2.channelId : null, (r32 & 4) != 0 ? r2.notifyType : r2, (r32 & 8) != 0 ? r2.source : null, (r32 & 16) != 0 ? r2.eventTime : 0, (r32 & 32) != 0 ? r2.isInBlack : false, (r32 & 64) != 0 ? r2.isVisible : false, (r32 & 128) != 0 ? r2.draftIdentify : 0, (r32 & 256) != 0 ? r2.memberType : 0, (r32 & 512) != 0 ? r2.lastMessage : null, (r32 & 1024) != 0 ? r2.unreadInfo : null, (r32 & 2048) != 0 ? r2.draftInfo : null, (r32 & 4096) != 0 ? r2._messageTime : 0);
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                DirectMessageNode c16;
                List listOf;
                DirectMessageNode C = DirectMessageNodeRepository.C(channelId);
                if (C != null && c16 != null) {
                    DirectMessageNodeRepository directMessageNodeRepository = DirectMessageNodeRepository.f230483e;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(c16);
                    directMessageNodeRepository.q(listOf, DiagnosisUtils.UpdateSource.NotifyTypeChanged);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.f230488d.getRepositoryCallbackConfig();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.DirectMessageNodeRepository", 2, "onAccountChanged(" + account + ")");
        }
        X();
        U();
    }
}
