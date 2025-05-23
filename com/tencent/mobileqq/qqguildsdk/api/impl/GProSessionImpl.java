package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInitSessionConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDependsAdapter;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelFeedServiceNew;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProSessionListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileTransferService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import com.tencent.qqnt.kernelgpro.nativeinterface.IQQGProWrapperSession;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J,\u0010\u0014\u001a\u00020\u00062\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\"H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000204008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000206008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00103R\u001a\u00109\u001a\b\u0012\u0004\u0012\u000208008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00103\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProSessionImpl;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDependsAdapter;", "getIDependsAdapter", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProSessionListener;", "getSessionListener", "", "onStart", "destroy", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isDestroy", "isInit", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sessionMap", "initBusinessModule", "start", "stop", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildService;", "getGuildService", "Luh2/c;", "getGProGuildMsgService", "Lcom/tencent/qqnt/kernel/api/o;", "getFeedService", "Luh2/a;", "getGProDirectSessionService", "Luh2/h;", "getGuildFileTransferService", "notifyGProSdkStart", "Ljava/util/concurrent/CountDownLatch;", "getGProSdkStartCountDownLatch", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IQQGProWrapperSession;", "gproWrapperSession", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IQQGProWrapperSession;", "gproStartCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStartFinish", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Z", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "serviceContent", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "Lcom/tencent/mobileqq/qqguildsdk/util/d;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGuildMsgService;", "gproGuildMsgService", "Lcom/tencent/mobileqq/qqguildsdk/util/d;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/FeedServiceNew;", "feedChannelServiceNew", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProDirectSessionService;", "gProDirectSessionService", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GuildFileTransferService;", "guildFileTransferService", "<init>", "()V", "Companion", "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GProSessionImpl implements IGProSession {

    @NotNull
    public static final String TAG = "GProSessionImpl";

    @Nullable
    private volatile IQQGProWrapperSession gproWrapperSession;
    private volatile boolean isDestroy;
    private volatile ServiceContent serviceContent;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String currentUin = "";

    @NotNull
    private final CountDownLatch gproStartCountDownLatch = new CountDownLatch(1);

    @NotNull
    private final AtomicBoolean isStartFinish = new AtomicBoolean(false);

    @NotNull
    private final com.tencent.mobileqq.qqguildsdk.util.d<GProGuildMsgService> gproGuildMsgService = com.tencent.mobileqq.qqguildsdk.util.e.a(new Function0<GProGuildMsgService>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProSessionImpl$gproGuildMsgService$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final GProGuildMsgService invoke() {
            IQQGProWrapperSession iQQGProWrapperSession;
            IKernelGProGuildMsgService gProGuildMsgService;
            ServiceContent serviceContent;
            IQQGProWrapperSession iQQGProWrapperSession2;
            TraceUtils traceUtils = TraceUtils.f235403a;
            GProSessionImpl gProSessionImpl = GProSessionImpl.this;
            if (!TraceUtils.m()) {
                traceUtils.l();
                iQQGProWrapperSession2 = gProSessionImpl.gproWrapperSession;
                Intrinsics.checkNotNull(iQQGProWrapperSession2);
                gProGuildMsgService = iQQGProWrapperSession2.getGProGuildMsgService();
            } else {
                try {
                    com.tencent.mobileqq.guild.util.cy.c("getGroupService");
                    iQQGProWrapperSession = gProSessionImpl.gproWrapperSession;
                    Intrinsics.checkNotNull(iQQGProWrapperSession);
                    gProGuildMsgService = iQQGProWrapperSession.getGProGuildMsgService();
                } finally {
                    com.tencent.mobileqq.guild.util.cy.d();
                }
            }
            serviceContent = GProSessionImpl.this.serviceContent;
            if (serviceContent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                serviceContent = null;
            }
            return new GProGuildMsgService(gProGuildMsgService, serviceContent);
        }
    });

    @NotNull
    private final com.tencent.mobileqq.qqguildsdk.util.d<FeedServiceNew> feedChannelServiceNew = com.tencent.mobileqq.qqguildsdk.util.e.a(new Function0<FeedServiceNew>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProSessionImpl$feedChannelServiceNew$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FeedServiceNew invoke() {
            IQQGProWrapperSession iQQGProWrapperSession;
            IKernelFeedServiceNew feedChannelServiceNew;
            ServiceContent serviceContent;
            IQQGProWrapperSession iQQGProWrapperSession2;
            TraceUtils traceUtils = TraceUtils.f235403a;
            GProSessionImpl gProSessionImpl = GProSessionImpl.this;
            if (!TraceUtils.m()) {
                traceUtils.l();
                iQQGProWrapperSession2 = gProSessionImpl.gproWrapperSession;
                Intrinsics.checkNotNull(iQQGProWrapperSession2);
                feedChannelServiceNew = iQQGProWrapperSession2.getFeedChannelServiceNew();
            } else {
                try {
                    com.tencent.mobileqq.guild.util.cy.c("getGroupService");
                    iQQGProWrapperSession = gProSessionImpl.gproWrapperSession;
                    Intrinsics.checkNotNull(iQQGProWrapperSession);
                    feedChannelServiceNew = iQQGProWrapperSession.getFeedChannelServiceNew();
                } finally {
                    com.tencent.mobileqq.guild.util.cy.d();
                }
            }
            serviceContent = GProSessionImpl.this.serviceContent;
            if (serviceContent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                serviceContent = null;
            }
            return new FeedServiceNew(feedChannelServiceNew, serviceContent);
        }
    });

    @NotNull
    private final com.tencent.mobileqq.qqguildsdk.util.d<GProDirectSessionService> gProDirectSessionService = com.tencent.mobileqq.qqguildsdk.util.e.a(new Function0<GProDirectSessionService>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProSessionImpl$gProDirectSessionService$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final GProDirectSessionService invoke() {
            IQQGProWrapperSession iQQGProWrapperSession;
            IKernelDirectSessionService directSessionService;
            ServiceContent serviceContent;
            IQQGProWrapperSession iQQGProWrapperSession2;
            TraceUtils traceUtils = TraceUtils.f235403a;
            GProSessionImpl gProSessionImpl = GProSessionImpl.this;
            if (!TraceUtils.m()) {
                traceUtils.l();
                iQQGProWrapperSession2 = gProSessionImpl.gproWrapperSession;
                Intrinsics.checkNotNull(iQQGProWrapperSession2);
                directSessionService = iQQGProWrapperSession2.getDirectSessionService();
            } else {
                try {
                    com.tencent.mobileqq.guild.util.cy.c("getGProDirectSessionService");
                    iQQGProWrapperSession = gProSessionImpl.gproWrapperSession;
                    Intrinsics.checkNotNull(iQQGProWrapperSession);
                    directSessionService = iQQGProWrapperSession.getDirectSessionService();
                } finally {
                    com.tencent.mobileqq.guild.util.cy.d();
                }
            }
            serviceContent = GProSessionImpl.this.serviceContent;
            if (serviceContent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                serviceContent = null;
            }
            return new GProDirectSessionService(directSessionService, serviceContent);
        }
    });

    @NotNull
    private final com.tencent.mobileqq.qqguildsdk.util.d<GuildFileTransferService> guildFileTransferService = com.tencent.mobileqq.qqguildsdk.util.e.a(new Function0<GuildFileTransferService>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProSessionImpl$guildFileTransferService$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final GuildFileTransferService invoke() {
            IQQGProWrapperSession iQQGProWrapperSession;
            IKernelGuildFileTransferService guildFileTransferService;
            ServiceContent serviceContent;
            IQQGProWrapperSession iQQGProWrapperSession2;
            TraceUtils traceUtils = TraceUtils.f235403a;
            GProSessionImpl gProSessionImpl = GProSessionImpl.this;
            if (!TraceUtils.m()) {
                traceUtils.l();
                iQQGProWrapperSession2 = gProSessionImpl.gproWrapperSession;
                Intrinsics.checkNotNull(iQQGProWrapperSession2);
                guildFileTransferService = iQQGProWrapperSession2.getGuildFileTransferService();
            } else {
                try {
                    com.tencent.mobileqq.guild.util.cy.c("guildFileTransferService");
                    iQQGProWrapperSession = gProSessionImpl.gproWrapperSession;
                    Intrinsics.checkNotNull(iQQGProWrapperSession);
                    guildFileTransferService = iQQGProWrapperSession.getGuildFileTransferService();
                } finally {
                    com.tencent.mobileqq.guild.util.cy.d();
                }
            }
            serviceContent = GProSessionImpl.this.serviceContent;
            if (serviceContent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                serviceContent = null;
            }
            return new GuildFileTransferService(guildFileTransferService, serviceContent);
        }
    });

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u0002H\u0002R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProSessionImpl$a;", "", "", "c", PanoramaConfig.KEY_CURRENT_UIN, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setCurrentUin", "(Ljava/lang/String;)V", "TAG", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.GProSessionImpl$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(String str) {
            if (str == null) {
                return "";
            }
            return str;
        }

        @NotNull
        public final String b() {
            return GProSessionImpl.currentUin;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/qqguildsdk/api/impl/GProSessionImpl$b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDependsAdapter;", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IGProDependsAdapter {
        b() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqguildsdk/api/impl/GProSessionImpl$c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProSessionListener;", "", "result", "", "sessionId", "", "onGProSessionCreate", "", "tinyId", "onGetSelfTinyId", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements IKernelGProSessionListener {
        c() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProSessionListener
        public void onGProSessionCreate(int result, @Nullable String sessionId) {
            com.tencent.qqnt.kernelgpro.nativeinterface.g.a(this, result, sessionId);
            QLog.i(GProSessionImpl.TAG, 1, "onGProSessionCreate");
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProSessionListener
        public void onGetSelfTinyId(long tinyId) {
            com.tencent.qqnt.kernelgpro.nativeinterface.g.b(this, tinyId);
            QLog.i(GProSessionImpl.TAG, 1, "onGetSelfTinyId");
        }
    }

    private final void destroy() {
        uh2.c gProGuildMsgService = getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.destroy();
        }
        this.isStartFinish.set(false);
        this.isDestroy = true;
        ServiceContent serviceContent = this.serviceContent;
        ServiceContent serviceContent2 = null;
        if (serviceContent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            serviceContent = null;
        }
        serviceContent.l(null);
        this.gproWrapperSession = null;
        this.gproGuildMsgService.clear();
        this.feedChannelServiceNew.clear();
        this.gProDirectSessionService.clear();
        this.guildFileTransferService.clear();
        ServiceContent serviceContent3 = this.serviceContent;
        if (serviceContent3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
        } else {
            serviceContent2 = serviceContent3;
        }
        serviceContent2.k();
    }

    private final IGProDependsAdapter getIDependsAdapter() {
        return new b();
    }

    private final IKernelGProSessionListener getSessionListener() {
        return new c();
    }

    private final void onStart() {
        QLog.i(TAG, 1, "onStart start session start\uff01");
        notifyGProSdkStart();
        ((IGuildDelayInitializeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGuildDelayInitializeService.class, "")).checkSessionInitComplete();
        ((IGuildMsgService) QRoute.api(IGuildMsgService.class)).init(getGProGuildMsgService());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    @Nullable
    public com.tencent.qqnt.kernel.api.o getFeedService() {
        if (this.gproWrapperSession != null && this.isStartFinish.get()) {
            return (com.tencent.qqnt.kernel.api.o) this.feedChannelServiceNew.getValue();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    @Nullable
    public uh2.a getGProDirectSessionService() {
        if (this.gproWrapperSession != null && this.isStartFinish.get()) {
            return (uh2.a) this.gProDirectSessionService.getValue();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    @Nullable
    public uh2.c getGProGuildMsgService() {
        if (this.gproWrapperSession != null && this.isStartFinish.get()) {
            return (uh2.c) this.gproGuildMsgService.getValue();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    @NotNull
    /* renamed from: getGProSdkStartCountDownLatch, reason: from getter */
    public CountDownLatch getGproStartCountDownLatch() {
        return this.gproStartCountDownLatch;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    @Nullable
    public uh2.h getGuildFileTransferService() {
        if (this.gproWrapperSession != null && this.isStartFinish.get()) {
            return (uh2.h) this.guildFileTransferService.getValue();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    @Nullable
    public IKernelGuildService getGuildService() {
        if (this.gproWrapperSession != null && this.isStartFinish.get()) {
            IQQGProWrapperSession iQQGProWrapperSession = this.gproWrapperSession;
            Intrinsics.checkNotNull(iQQGProWrapperSession);
            return iQQGProWrapperSession.getGuildService();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    public void initBusinessModule(@NotNull HashMap<String, String> sessionMap) {
        IQQGProWrapperSession iQQGProWrapperSession;
        String valueOf;
        Intrinsics.checkNotNullParameter(sessionMap, "sessionMap");
        boolean z16 = true;
        QLog.i(TAG, 1, "initBusinessModule session=" + hashCode());
        String str = sessionMap.get(StartupSessionConstant.KGPROMODULENAME);
        ServiceContent serviceContent = null;
        if (str != null) {
            iQQGProWrapperSession = com.tencent.qqnt.kernelgpro.nativeinterface.l.h(str);
        } else {
            iQQGProWrapperSession = null;
        }
        this.gproWrapperSession = iQQGProWrapperSession;
        ServiceContent serviceContent2 = this.serviceContent;
        if (serviceContent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
        } else {
            serviceContent = serviceContent2;
        }
        serviceContent.l(sessionMap.get(StartupSessionConstant.KGPROMODULENAME));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUid = peekAppRuntime.getCurrentUid();
        long longAccountUin = peekAppRuntime.getLongAccountUin();
        String currentUin2 = peekAppRuntime.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin2, "runtime.currentUin");
        currentUin = currentUin2;
        if (currentUid != null && currentUid.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            valueOf = INSTANCE.c(currentUid);
        } else {
            valueOf = String.valueOf(longAccountUin);
        }
        String str2 = valueOf;
        String str3 = "gpro_v1-6_" + str2 + DBBackupServiceImpl.DB_FILE_SUFFIX;
        String str4 = AppSetting.f99554n;
        if (str4 == null) {
            str4 = "1.1";
        }
        String str5 = str4;
        IQQGProWrapperSession iQQGProWrapperSession2 = this.gproWrapperSession;
        Intrinsics.checkNotNull(iQQGProWrapperSession2);
        iQQGProWrapperSession2.init(new GProInitSessionConfig(longAccountUin, str2, str3, str5, "", "", ""), getIDependsAdapter(), getSessionListener());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    /* renamed from: isDestroy, reason: from getter */
    public boolean getIsDestroy() {
        return this.isDestroy;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    public boolean isInit() {
        return this.isStartFinish.get();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    public void notifyGProSdkStart() {
        this.gproStartCountDownLatch.countDown();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        QLog.i(TAG, 1, "onCreate session=" + hashCode());
        this.serviceContent = new ServiceContent(appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "onDestroy session=" + hashCode());
        destroy();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    public void start() {
        QLog.i(TAG, 1, "start session=" + hashCode());
        this.isStartFinish.set(true);
        onStart();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProSession
    public void stop() {
        QLog.i(TAG, 1, "stop session=" + hashCode());
    }
}
