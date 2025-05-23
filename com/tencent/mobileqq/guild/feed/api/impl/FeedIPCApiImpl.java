package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.PostPermissionCheckFuns;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b!\u0010\"JH\u0010\u000b\u001aB\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\nH\u0002JH\u0010\f\u001aB\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\nH\u0002JH\u0010\r\u001aB\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\nH\u0002JH\u0010\u000e\u001aB\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\nH\u0002JH\u0010\u000f\u001aB\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\nH\u0002JH\u0010\u0010\u001aB\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\nH\u0002J9\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bRf\u0010 \u001aT\u0012\u0004\u0012\u00020\u0011\u0012J\u0012H\u0012D\u0012B\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\n0\u001d0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedIPCApiImpl;", "", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "Lkotlin/ParameterName;", "name", "ipcContext", "", "args", "Leipc/EIPCResult;", "Lcom/tencent/mobileqq/guild/feed/api/impl/IPCHandler;", "l", "k", "i", tl.h.F, "o", DomainData.DOMAIN_NAME, "", "method", "Leipc/EIPCResultCallback;", "callback", "", "g", "(Ljava/lang/String;Leipc/EIPCResultCallback;[Ljava/lang/Object;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "j", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "", "Lkotlin/reflect/KFunction0;", "a", "Ljava/util/Map;", "handlerConstructorMap", "<init>", "()V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedIPCApiImpl {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f217997b = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, KFunction<Function2<AbsIpcMethod.a, Object[], EIPCResult>>> handlerConstructorMap;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedIPCApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public FeedIPCApiImpl() {
        Map<String, KFunction<Function2<AbsIpcMethod.a, Object[], EIPCResult>>> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("get_guild_guide_bar_info", new FeedIPCApiImpl$handlerConstructorMap$1(this)), TuplesKt.to("guild_task_queue_mgr_init", new FeedIPCApiImpl$handlerConstructorMap$2(this)), TuplesKt.to("check_guild_home_exists", new FeedIPCApiImpl$handlerConstructorMap$3(this)), TuplesKt.to("async_check_channel_post_permission", new FeedIPCApiImpl$handlerConstructorMap$4(this)), TuplesKt.to("sync_report_stage_init", new FeedIPCApiImpl$handlerConstructorMap$5(this)), TuplesKt.to("sync_bind_report_task", new FeedIPCApiImpl$handlerConstructorMap$6(this)));
        this.handlerConstructorMap = mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<AbsIpcMethod.a, Object[], EIPCResult> h() {
        return new Function2() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedIPCApiImpl$asyncCheckPostPermissionMethodConstructor$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedIPCApiImpl$asyncCheckPostPermissionMethodConstructor$1$1", f = "FeedIPCApiImpl.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.FeedIPCApiImpl$asyncCheckPostPermissionMethodConstructor$1$1, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $channelId;
                final /* synthetic */ String $guildId;
                final /* synthetic */ AbsIpcMethod.a $ipcCtx;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, String str2, AbsIpcMethod.a aVar, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$guildId = str;
                    this.$channelId = str2;
                    this.$ipcCtx = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.$guildId, this.$channelId, this.$ipcCtx, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        PostPermissionCheckFuns postPermissionCheckFuns = PostPermissionCheckFuns.f222320a;
                        String str = this.$guildId;
                        String str2 = this.$channelId;
                        this.label = 1;
                        obj = postPermissionCheckFuns.c(str, str2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    PostPermissionCheckFuns.a aVar = (PostPermissionCheckFuns.a) obj;
                    if (aVar == null) {
                        this.$ipcCtx.b(Bundle.EMPTY);
                        return Unit.INSTANCE;
                    }
                    this.$ipcCtx.b(BundleKt.bundleOf(TuplesKt.to("can_post_in_channel", Boxing.boxBoolean(aVar.a())), TuplesKt.to("is_hidden_channel_selected", Boxing.boxBoolean(Intrinsics.areEqual(aVar.b(), this.$channelId))), TuplesKt.to("is_required_to_select_not_hidden_channel", Boxing.boxBoolean(aVar.c())), TuplesKt.to("hidden_channel_id", aVar.b()), TuplesKt.to("there_is_any_speakable_not_hidden_channel", Boxing.boxBoolean(aVar.d())), TuplesKt.to("hidden_channel_id", Boxing.boxBoolean(aVar.f()))));
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Void invoke(@NotNull AbsIpcMethod.a ipcCtx, @NotNull Object[] args) {
                Object firstOrNull;
                Object orNull;
                Intrinsics.checkNotNullParameter(ipcCtx, "ipcCtx");
                Intrinsics.checkNotNullParameter(args, "args");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
                String str = firstOrNull instanceof String ? (String) firstOrNull : null;
                if (str != null) {
                    orNull = ArraysKt___ArraysKt.getOrNull(args, 1);
                    String str2 = orNull instanceof String ? (String) orNull : null;
                    if (str2 != null) {
                        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, ae.a().c(), null, new AnonymousClass1(str, str2, ipcCtx, null), 2, null);
                        return null;
                    }
                    ipcCtx.a(-102, Bundle.EMPTY);
                    return null;
                }
                ipcCtx.a(-102, Bundle.EMPTY);
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<AbsIpcMethod.a, Object[], EIPCResult> i() {
        return new Function2<AbsIpcMethod.a, Object[], EIPCResult>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedIPCApiImpl$checkGuildHomeExistMethodConstructor$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final EIPCResult invoke(@NotNull AbsIpcMethod.a aVar, @NotNull Object[] args) {
                Object firstOrNull;
                Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(args, "args");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
                String str = firstOrNull instanceof String ? (String) firstOrNull : null;
                if (str == null) {
                    return null;
                }
                return EIPCResult.createSuccessResult(BundleKt.bundleOf(TuplesKt.to("check_guild_home_exists", Boolean.valueOf(GuildOpenRecordManager.f227480a.e(str)))));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<AbsIpcMethod.a, Object[], EIPCResult> k() {
        return FeedIPCApiImpl$fetchGuildGuideBarInfoHandlerConstructor$1.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<AbsIpcMethod.a, Object[], EIPCResult> l() {
        return FeedIPCApiImpl$initGuildTaskQueueManager$1.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<AbsIpcMethod.a, Object[], EIPCResult> n() {
        return new Function2() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedIPCApiImpl$syncReBindReportTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Void invoke(@NotNull AbsIpcMethod.a aVar, @NotNull Object[] args) {
                Object firstOrNull;
                String str;
                String str2;
                Object orNull;
                Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(args, "args");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
                    str = firstOrNull instanceof String ? (String) firstOrNull : null;
                    str2 = "";
                    if (str == null) {
                        str = "";
                    }
                    orNull = ArraysKt___ArraysKt.getOrNull(args, 1);
                    String str3 = orNull instanceof String ? (String) orNull : null;
                    if (str3 != null) {
                        str2 = str3;
                    }
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (!(str.length() == 0)) {
                    if (!(str2.length() == 0)) {
                        GuildTaskQueueManager m3 = GuildTaskQueueManager.m();
                        IPerformanceReportTask j3 = m3.j(str);
                        if (j3 == null) {
                            QLog.w("FeedIPCApiImpl", 1, "[syncReBindReportTask]: didn't find report task of " + str);
                        } else {
                            m3.i(str2, j3);
                        }
                        Result.m476constructorimpl(Unit.INSTANCE);
                        return null;
                    }
                }
                QLog.e("FeedIPCApiImpl", 1, "[syncReBindReportTask]: " + str + ", " + str2);
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<AbsIpcMethod.a, Object[], EIPCResult> o() {
        return new Function2() { // from class: com.tencent.mobileqq.guild.feed.api.impl.FeedIPCApiImpl$syncReportStageInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Void invoke(@NotNull AbsIpcMethod.a aVar, @NotNull Object[] args) {
                Object firstOrNull;
                IPerformanceReportTask e16;
                Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(args, "args");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
                    Intent intent = firstOrNull instanceof Intent ? (Intent) firstOrNull : null;
                    if (intent != null) {
                        km1.a.f412694a.c(intent);
                        String stringExtra = intent.getStringExtra("launch_main_task_id");
                        if (stringExtra != null) {
                            if (!(stringExtra.length() > 0)) {
                                stringExtra = null;
                            }
                            if (stringExtra != null && (e16 = qw1.b.e(intent)) != null) {
                                GuildTaskQueueManager.m().i(stringExtra, e16);
                            }
                        }
                    }
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                return null;
            }
        };
    }

    public void g(@NotNull String method, @Nullable EIPCResultCallback callback, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(method);
        spreadBuilder.addSpread(args);
        com.tencent.mobileqq.guild.util.y.b(com.tencent.mobileqq.guild.ipc.methods.d.class, callback, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
    }

    @Nullable
    public EIPCResult j(@Nullable Object ipcContext, @NotNull String method, @NotNull Object[] args) {
        Function2 function2;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        KFunction<Function2<AbsIpcMethod.a, Object[], EIPCResult>> kFunction = this.handlerConstructorMap.get(method);
        if (kFunction != null && (function2 = (Function2) ((Function0) kFunction).invoke()) != null) {
            Intrinsics.checkNotNull(ipcContext, "null cannot be cast to non-null type com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod.IpcContext");
            return (EIPCResult) function2.invoke((AbsIpcMethod.a) ipcContext, args);
        }
        return null;
    }

    @Nullable
    public EIPCResult m(@NotNull String method, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(method);
        spreadBuilder.addSpread(args);
        return com.tencent.mobileqq.guild.util.y.g(com.tencent.mobileqq.guild.ipc.methods.d.class, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
    }
}
