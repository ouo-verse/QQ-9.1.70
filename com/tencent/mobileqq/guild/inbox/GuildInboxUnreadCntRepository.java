package com.tencent.mobileqq.guild.inbox;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.inbox.GuildInboxUnreadCntRepository;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.nt.misc.api.IAppBadgeApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.msg.data.FeedsBoxEvent;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import uh2.c;
import wp1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000f\u001a\u00020\u0002R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/GuildInboxUnreadCntRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", h.F, ReportConstant.COSTREPORT_PREFIX, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService$a;", DomainData.DOMAIN_NAME, "", "account", "onAccountChanged", "i", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lwp1/g;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mListeners", "f", "Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService$a;", "mFeedSummaryUpdateListener", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "mGuildInboxRedService", "Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService;", "Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService;", "mFeedBoxSummaryService", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "mLastLoggedRecords", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "mNoticeRedUpdateListener", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInboxUnreadCntRepository implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static final IGuildInboxRedService.a mNoticeRedUpdateListener;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildInboxUnreadCntRepository f226100d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<g> mListeners;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IFeedBoxSummaryService.a mFeedSummaryUpdateListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static IGuildInboxRedService mGuildInboxRedService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static IFeedBoxSummaryService mFeedBoxSummaryService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Object, long[]> mLastLoggedRecords;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/inbox/GuildInboxUnreadCntRepository$a", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$b;", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadCntService$b;", "newTotalCount", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends IGuildInboxRedService.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.b, com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void a(@NotNull IGuildUnreadCntService.b newTotalCount) {
            Intrinsics.checkNotNullParameter(newTotalCount, "newTotalCount");
            GuildInboxUnreadCntRepository.f226100d.q();
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildInboxUnreadCntRepository", 2, "mNoticeRedUpdateListener");
            }
        }
    }

    static {
        GuildInboxUnreadCntRepository guildInboxUnreadCntRepository = new GuildInboxUnreadCntRepository();
        f226100d = guildInboxUnreadCntRepository;
        mListeners = new CopyOnWriteArrayList<>();
        mFeedSummaryUpdateListener = guildInboxUnreadCntRepository.n();
        mLastLoggedRecords = new ConcurrentHashMap<>();
        mNoticeRedUpdateListener = new a();
        guildInboxUnreadCntRepository.p();
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            AccountChangedNotifier.f214789d.a(guildInboxUnreadCntRepository);
            guildInboxUnreadCntRepository.h();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.GuildInboxUnreadCntRepository$special$$inlined$ensureUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    AccountChangedNotifier accountChangedNotifier = AccountChangedNotifier.f214789d;
                    GuildInboxUnreadCntRepository guildInboxUnreadCntRepository2 = GuildInboxUnreadCntRepository.f226100d;
                    accountChangedNotifier.a(guildInboxUnreadCntRepository2);
                    guildInboxUnreadCntRepository2.h();
                }
            });
        }
    }

    GuildInboxUnreadCntRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        IGuildInboxRedService iGuildInboxRedService = mGuildInboxRedService;
        IFeedBoxSummaryService iFeedBoxSummaryService = null;
        if (iGuildInboxRedService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildInboxRedService");
            iGuildInboxRedService = null;
        }
        iGuildInboxRedService.addNoticeRedUpdateListener(mNoticeRedUpdateListener);
        IFeedBoxSummaryService iFeedBoxSummaryService2 = mFeedBoxSummaryService;
        if (iFeedBoxSummaryService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBoxSummaryService");
        } else {
            iFeedBoxSummaryService = iFeedBoxSummaryService2;
        }
        iFeedBoxSummaryService.registerSummaryUpdateListener(mFeedSummaryUpdateListener);
    }

    private final void j() {
        Unit unit;
        c gProGuildMsgService = ((IGProSession) ch.R0(IGProSession.class)).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setGProAllDirectMsgRead(new IGuildOperateCallback() { // from class: wp1.f
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    GuildInboxUnreadCntRepository.k(i3, str);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("clearInboxAllC2CMsgUnreadDot: service is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.GuildInboxUnreadCntRepository", 1, (String) it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        Logger.f235387a.d().i("Guild.C2C.GuildInboxUnreadCntRepository", 1, "clearInboxAllC2CMsgUnreadDot: result = " + i3 + ", errMsg = " + str);
    }

    private final void l() {
        ((IFeedBoxSummaryService) ch.R0(IFeedBoxSummaryService.class)).markRead();
    }

    private final void m() {
        ((IGuildInboxRedService) ch.R0(IGuildInboxRedService.class)).clearAllNoticeRedPoint();
    }

    private final IFeedBoxSummaryService.a n() {
        return new IFeedBoxSummaryService.a() { // from class: wp1.d
            @Override // com.tencent.qqguild.directmessage.service.IFeedBoxSummaryService.a
            public final void a(FeedsBoxEvent feedsBoxEvent) {
                GuildInboxUnreadCntRepository.o(feedsBoxEvent);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FeedsBoxEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildInboxUnreadCntRepository", 2, "onSummaryUpdated");
        }
        f226100d.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        mFeedBoxSummaryService = (IFeedBoxSummaryService) MiscKt.c(IFeedBoxSummaryService.class, "Guild.C2C.GuildInboxUnreadCntRepository", "");
        mGuildInboxRedService = (IGuildInboxRedService) MiscKt.c(IGuildInboxRedService.class, "Guild.C2C.GuildInboxUnreadCntRepository", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        Iterator<T> it = mListeners.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: wp1.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildInboxUnreadCntRepository.r();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r() {
        ((IAppBadgeApi) QRoute.api(IAppBadgeApi.class)).refreshAppBadge(ch.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        IGuildInboxRedService iGuildInboxRedService = mGuildInboxRedService;
        IFeedBoxSummaryService iFeedBoxSummaryService = null;
        if (iGuildInboxRedService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildInboxRedService");
            iGuildInboxRedService = null;
        }
        iGuildInboxRedService.removeNoticeRedUpdateListener(mNoticeRedUpdateListener);
        IFeedBoxSummaryService iFeedBoxSummaryService2 = mFeedBoxSummaryService;
        if (iFeedBoxSummaryService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBoxSummaryService");
        } else {
            iFeedBoxSummaryService = iFeedBoxSummaryService2;
        }
        iFeedBoxSummaryService.unregisterSummaryUpdateListener(mFeedSummaryUpdateListener);
    }

    public final void i() {
        j();
        m();
        l();
        Logger.f235387a.d().d("Guild.C2C.GuildInboxUnreadCntRepository", 1, "clearAllInboxUnreadDot");
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger.f235387a.d().d("Guild.C2C.GuildInboxUnreadCntRepository", 1, "onAccountChanged(" + account + ")");
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            GuildInboxUnreadCntRepository guildInboxUnreadCntRepository = f226100d;
            guildInboxUnreadCntRepository.s();
            guildInboxUnreadCntRepository.p();
            guildInboxUnreadCntRepository.h();
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.GuildInboxUnreadCntRepository$onAccountChanged$$inlined$ensureUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                GuildInboxUnreadCntRepository guildInboxUnreadCntRepository2 = GuildInboxUnreadCntRepository.f226100d;
                guildInboxUnreadCntRepository2.s();
                guildInboxUnreadCntRepository2.p();
                guildInboxUnreadCntRepository2.h();
            }
        });
    }
}
