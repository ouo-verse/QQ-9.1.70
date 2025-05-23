package com.tencent.mobileqq.guild.homev2.viewmodels;

import android.graphics.Rect;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel;
import com.tencent.mobileqq.guild.homev2.misc.NetworkAvailableFlowKt;
import com.tencent.mobileqq.guild.homev2.misc.a;
import com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel;
import com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleLivingViewModel;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef1.b;
import ef1.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002efB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\bc\u0010\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\tH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00078V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u00102R\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010?\u001a\u00020:8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010E\u001a\u00020@8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR&\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0G0F8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR&\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0G0F8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bN\u0010J\u001a\u0004\bO\u0010LR&\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0G0F8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bR\u0010J\u001a\u0004\bS\u0010LR!\u0010X\u001a\b\u0012\u0004\u0012\u00020Q0\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010&\u001a\u0004\bV\u0010WR!\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010&\u001a\u0004\bZ\u0010WR\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0006\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/homev2/misc/a;", "Lmp1/b;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "c2", "", "oldGuildId", "", "Z2", "source", "d2", "finishRefresh", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "S1", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "f2", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "jumpGuildParam", "<set-?>", "D", "Lkotlin/properties/ReadWriteProperty;", "getGuildId", "()Ljava/lang/String;", "e2", "(Ljava/lang/String;)V", "guildId", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel;", "E", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel;", "R1", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildInfoViewModel;", "guildInfoViewModel", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "b2", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildTabsViewModel;", "tabsViewModel", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildNavigatorViewModel;", "G", "Z1", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildNavigatorViewModel;", "navigatorViewModel", "Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleCoverViewModel;", "H", "O1", "()Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleCoverViewModel;", "coverViewModel", "Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleLivingViewModel;", "I", "Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleLivingViewModel;", "X1", "()Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleLivingViewModel;", "livingViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "J", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "()Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "guildHomePermissionViewModel", "Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "K", "Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "K1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/e;", "guildSubTabPageViewModel", "Landroidx/lifecycle/MutableLiveData;", "Lef1/a;", "", "L", "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "liveStartRefresh", "M", "T1", "liveFinishRefresh", "", "N", "W1", "liveSwitchTab", "P", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lkotlinx/coroutines/flow/StateFlow;", "reconnectEvent", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P1", "flowGuildHomeUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/graphics/Rect;", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/MutableStateFlow;", "Q1", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "flowSystemInsets", "<init>", ExifInterface.LATITUDE_SOUTH, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeViewModel extends b implements a, mp1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private JumpGuildParam jumpGuildParam;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty guildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildInfoViewModel guildInfoViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabsViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy navigatorViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy coverViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GuildHomeV2TitleLivingViewModel livingViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GuildHomePermissionViewModel guildHomePermissionViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.viewmodels.e guildSubTabPageViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Boolean>> liveStartRefresh;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Boolean>> liveFinishRefresh;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<Long>> liveSwitchTab;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy reconnectEvent;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy flowGuildHomeUiState;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Rect> flowSystemInsets;
    static final /* synthetic */ KProperty<Object>[] T = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuildHomeViewModel.class, "guildId", "getGuildId()Ljava/lang/String;", 0))};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2", f = "GuildHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2$2", f = "GuildHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2$2, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C78052 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ GuildHomeViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C78052(GuildHomeViewModel guildHomeViewModel, Continuation<? super C78052> continuation) {
                super(2, continuation);
                this.this$0 = guildHomeViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C78052(this.this$0, continuation);
            }

            @Nullable
            public final Object invoke(long j3, @Nullable Continuation<? super Unit> continuation) {
                return ((C78052) create(Long.valueOf(j3), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.d2("networkReconnect");
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Long l3, Continuation<? super Unit> continuation) {
                return invoke(l3.longValue(), continuation);
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final StateFlow<Long> a26 = GuildHomeViewModel.this.a2();
                FlowKt.launchIn(FlowKt.onEach(new Flow<Long>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2$invokeSuspend$$inlined$filter$1

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                    /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    /* loaded from: classes13.dex */
                    public static final class AnonymousClass2 implements FlowCollector<Long> {

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ FlowCollector f226038d;

                        /* compiled from: P */
                        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                        @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2$invokeSuspend$$inlined$filter$1$2", f = "GuildHomeViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                        /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        /* loaded from: classes13.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.f226038d = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public Object emit(Long l3, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            Object coroutine_suspended;
                            int i3;
                            boolean z16;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i16 = anonymousClass1.label;
                                if ((i16 & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                    Object obj = anonymousClass1.result;
                                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    i3 = anonymousClass1.label;
                                    if (i3 == 0) {
                                        if (i3 == 1) {
                                            ResultKt.throwOnFailure(obj);
                                        } else {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                    } else {
                                        ResultKt.throwOnFailure(obj);
                                        FlowCollector flowCollector = this.f226038d;
                                        if (l3.longValue() > 0) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        if (z16) {
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(l3, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            anonymousClass1 = new AnonymousClass1(continuation);
                            Object obj2 = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Long> flowCollector, @NotNull Continuation continuation) {
                        Object coroutine_suspended;
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (collect == coroutine_suspended) {
                            return collect;
                        }
                        return Unit.INSTANCE;
                    }
                }, new C78052(GuildHomeViewModel.this, null)), ViewModelKt.getViewModelScope(GuildHomeViewModel.this));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020%\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010 \u001a\u0004\b\u0010\u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "k", "(Z)V", "isLoading", "b", "c", "g", "isBanedGuild", "e", "l", "isNormalGuild", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isVisitorVisibleGuild", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", h.F, "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "guildInfo", "I", "()I", "i", "(I)V", "guildInfoSourceType", "", "J", "getLastReconnectTime", "()J", "j", "(J)V", "lastReconnectTime", "<init>", "(ZZZZLcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;IJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GuildHomeUiState {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isLoading;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isBanedGuild;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isNormalGuild;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isVisitorVisibleGuild;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private IGProGuildInfo guildInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int guildInfoSourceType;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private long lastReconnectTime;

        public GuildHomeUiState() {
            this(false, false, false, false, null, 0, 0L, 127, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final IGProGuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        /* renamed from: b, reason: from getter */
        public final int getGuildInfoSourceType() {
            return this.guildInfoSourceType;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsBanedGuild() {
            return this.isBanedGuild;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsNormalGuild() {
            return this.isNormalGuild;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildHomeUiState)) {
                return false;
            }
            GuildHomeUiState guildHomeUiState = (GuildHomeUiState) other;
            if (this.isLoading == guildHomeUiState.isLoading && this.isBanedGuild == guildHomeUiState.isBanedGuild && this.isNormalGuild == guildHomeUiState.isNormalGuild && this.isVisitorVisibleGuild == guildHomeUiState.isVisitorVisibleGuild && Intrinsics.areEqual(this.guildInfo, guildHomeUiState.guildInfo) && this.guildInfoSourceType == guildHomeUiState.guildInfoSourceType && this.lastReconnectTime == guildHomeUiState.lastReconnectTime) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsVisitorVisibleGuild() {
            return this.isVisitorVisibleGuild;
        }

        public final void g(boolean z16) {
            this.isBanedGuild = z16;
        }

        public final void h(@Nullable IGProGuildInfo iGProGuildInfo) {
            this.guildInfo = iGProGuildInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isLoading;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            ?? r26 = this.isBanedGuild;
            int i17 = r26;
            if (r26 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            ?? r27 = this.isNormalGuild;
            int i19 = r27;
            if (r27 != 0) {
                i19 = 1;
            }
            int i26 = (i18 + i19) * 31;
            boolean z17 = this.isVisitorVisibleGuild;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int i27 = (i26 + i3) * 31;
            IGProGuildInfo iGProGuildInfo = this.guildInfo;
            if (iGProGuildInfo == null) {
                hashCode = 0;
            } else {
                hashCode = iGProGuildInfo.hashCode();
            }
            return ((((i27 + hashCode) * 31) + this.guildInfoSourceType) * 31) + androidx.fragment.app.a.a(this.lastReconnectTime);
        }

        public final void i(int i3) {
            this.guildInfoSourceType = i3;
        }

        public final void j(long j3) {
            this.lastReconnectTime = j3;
        }

        public final void k(boolean z16) {
            this.isLoading = z16;
        }

        public final void l(boolean z16) {
            this.isNormalGuild = z16;
        }

        public final void m(boolean z16) {
            this.isVisitorVisibleGuild = z16;
        }

        @NotNull
        public String toString() {
            return "GuildHomeUiState(isLoading=" + this.isLoading + ", isBanedGuild=" + this.isBanedGuild + ", isNormalGuild=" + this.isNormalGuild + ", isVisitorVisibleGuild=" + this.isVisitorVisibleGuild + ", guildInfo=" + this.guildInfo + ", guildInfoSourceType=" + this.guildInfoSourceType + ", lastReconnectTime=" + this.lastReconnectTime + ")";
        }

        public GuildHomeUiState(boolean z16, boolean z17, boolean z18, boolean z19, @Nullable IGProGuildInfo iGProGuildInfo, int i3, long j3) {
            this.isLoading = z16;
            this.isBanedGuild = z17;
            this.isNormalGuild = z18;
            this.isVisitorVisibleGuild = z19;
            this.guildInfo = iGProGuildInfo;
            this.guildInfoSourceType = i3;
            this.lastReconnectTime = j3;
        }

        public /* synthetic */ GuildHomeUiState(boolean z16, boolean z17, boolean z18, boolean z19, IGProGuildInfo iGProGuildInfo, int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? true : z16, (i16 & 2) != 0 ? false : z17, (i16 & 4) != 0 ? false : z18, (i16 & 8) != 0 ? false : z19, (i16 & 16) != 0 ? null : iGProGuildInfo, (i16 & 32) == 0 ? i3 : 0, (i16 & 64) != 0 ? 0L : j3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f226051a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f226052b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f226051a = viewModelStoreOwner;
            this.f226052b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f226052b.getJumpGuildParam().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            TimedValue timedValue = new TimedValue(new GuildInfoViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f226053a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f226054b;

        public d(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f226053a = viewModelStoreOwner;
            this.f226054b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f226054b.getJumpGuildParam().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            TimedValue timedValue = new TimedValue(new GuildHomeV2TitleLivingViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f226055a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f226056b;

        public e(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f226055a = viewModelStoreOwner;
            this.f226056b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f226056b.getJumpGuildParam().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            TimedValue timedValue = new TimedValue(new GuildHomePermissionViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f226057a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeViewModel f226058b;

        public f(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
            this.f226057a = viewModelStoreOwner;
            this.f226058b = guildHomeViewModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f226058b.getJumpGuildParam().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.home.viewmodels.e(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public GuildHomeViewModel(@NotNull JumpGuildParam jumpGuildParam) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        this.jumpGuildParam = jumpGuildParam;
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        this.guildId = com.tencent.mobileqq.guild.homev2.misc.b.a(this, str);
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this, this)).get(GuildInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildInfoViewModel = (GuildInfoViewModel) viewModel;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GuildTabsViewModel>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$special$$inlined$lazyViewModel$default$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f226039a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildHomeViewModel f226040b;

                public a(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
                    this.f226039a = viewModelStoreOwner;
                    this.f226040b = guildHomeViewModel;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                    String str = this.f226040b.getJumpGuildParam().guildId;
                    Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
                    TimedValue timedValue = new TimedValue(new GuildTabsViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.guild.homev2.viewmodels.GuildTabsViewModel, androidx.lifecycle.ViewModel] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildTabsViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewModelStoreOwner.this;
                c.Companion companion2 = c.INSTANCE;
                return new ViewModelProvider(viewModelStoreOwner, new a(viewModelStoreOwner, this)).get(GuildTabsViewModel.class);
            }
        });
        this.tabsViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GuildNavigatorViewModel>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$special$$inlined$lazyViewModel$default$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f226041a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildHomeViewModel f226042b;

                public a(ViewModelStoreOwner viewModelStoreOwner, GuildHomeViewModel guildHomeViewModel) {
                    this.f226041a = viewModelStoreOwner;
                    this.f226042b = guildHomeViewModel;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                    String str = this.f226042b.getJumpGuildParam().guildId;
                    Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
                    TimedValue timedValue = new TimedValue(new GuildNavigatorViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.guild.homev2.viewmodels.GuildNavigatorViewModel] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildNavigatorViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewModelStoreOwner.this;
                c.Companion companion2 = c.INSTANCE;
                return new ViewModelProvider(viewModelStoreOwner, new a(viewModelStoreOwner, this)).get(GuildNavigatorViewModel.class);
            }
        });
        this.navigatorViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GuildHomeV2TitleCoverViewModel>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$special$$inlined$lazyViewModel$default$3

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f226043a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f226043a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new GuildHomeV2TitleCoverViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel, androidx.lifecycle.ViewModel] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeV2TitleCoverViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewModelStoreOwner.this;
                c.Companion companion2 = c.INSTANCE;
                return new ViewModelProvider(viewModelStoreOwner, new a(viewModelStoreOwner)).get(GuildHomeV2TitleCoverViewModel.class);
            }
        });
        this.coverViewModel = lazy3;
        ViewModel viewModel2 = new ViewModelProvider(this, new d(this, this)).get(GuildHomeV2TitleLivingViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.livingViewModel = (GuildHomeV2TitleLivingViewModel) viewModel2;
        ViewModel viewModel3 = new ViewModelProvider(this, new e(this, this)).get(GuildHomePermissionViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildHomePermissionViewModel = (GuildHomePermissionViewModel) viewModel3;
        ViewModel viewModel4 = new ViewModelProvider(this, new f(this, this)).get(com.tencent.mobileqq.guild.home.viewmodels.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildSubTabPageViewModel = (com.tencent.mobileqq.guild.home.viewmodels.e) viewModel4;
        this.liveStartRefresh = new MutableLiveData<>();
        this.liveFinishRefresh = new MutableLiveData<>();
        this.liveSwitchTab = new MutableLiveData<>();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<StateFlow<? extends Long>>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$reconnectEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final StateFlow<? extends Long> invoke() {
                return FlowKt.stateIn(NetworkAvailableFlowKt.b(), ViewModelKt.getViewModelScope(GuildHomeViewModel.this), SharingStarted.INSTANCE.getLazily(), 0L);
            }
        });
        this.reconnectEvent = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<StateFlow<? extends GuildHomeUiState>>() { // from class: com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel$flowGuildHomeUiState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final StateFlow<? extends GuildHomeViewModel.GuildHomeUiState> invoke() {
                StateFlow<? extends GuildHomeViewModel.GuildHomeUiState> c26;
                c26 = GuildHomeViewModel.this.c2();
                return c26;
            }
        });
        this.flowGuildHomeUiState = lazy5;
        this.flowSystemInsets = StateFlowKt.MutableStateFlow(new Rect(0, ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ), 0, 0));
        Logger.f235387a.d().d("GuildHomeViewModel", 1, "jumpGuildParam: " + getJumpGuildParam());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateFlow<GuildHomeUiState> c2() {
        return FlowKt.stateIn(FlowKt.combine(this.guildInfoViewModel.O1(), b2().S1(), a2(), new GuildHomeViewModel$newGuildHomeUiStateFlow$suspendLambda$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), new GuildHomeUiState(false, false, false, false, null, 0, 0L, 127, null));
    }

    @Override // mp1.b
    @NotNull
    /* renamed from: K1, reason: from getter */
    public com.tencent.mobileqq.guild.home.viewmodels.e getGuildSubTabPageViewModel() {
        return this.guildSubTabPageViewModel;
    }

    @NotNull
    public final GuildHomeV2TitleCoverViewModel O1() {
        return (GuildHomeV2TitleCoverViewModel) this.coverViewModel.getValue();
    }

    @NotNull
    public final StateFlow<GuildHomeUiState> P1() {
        return (StateFlow) this.flowGuildHomeUiState.getValue();
    }

    @NotNull
    public final MutableStateFlow<Rect> Q1() {
        return this.flowSystemInsets;
    }

    @NotNull
    /* renamed from: R1, reason: from getter */
    public final GuildInfoViewModel getGuildInfoViewModel() {
        return this.guildInfoViewModel;
    }

    @NotNull
    /* renamed from: S1, reason: from getter */
    public final JumpGuildParam getJumpGuildParam() {
        return this.jumpGuildParam;
    }

    @NotNull
    public MutableLiveData<ef1.a<Boolean>> T1() {
        return this.liveFinishRefresh;
    }

    @Override // mp1.b
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public MutableLiveData<ef1.a<Boolean>> T() {
        return this.liveStartRefresh;
    }

    @NotNull
    public MutableLiveData<ef1.a<Long>> W1() {
        return this.liveSwitchTab;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final GuildHomeV2TitleLivingViewModel getLivingViewModel() {
        return this.livingViewModel;
    }

    @NotNull
    public final GuildNavigatorViewModel Z1() {
        return (GuildNavigatorViewModel) this.navigatorViewModel.getValue();
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.a
    public void Z2(@NotNull String oldGuildId) {
        Intrinsics.checkNotNullParameter(oldGuildId, "oldGuildId");
        if (!Intrinsics.areEqual(oldGuildId, getGuildId())) {
            d2("guildId changed " + oldGuildId + " -> " + getGuildId());
            return;
        }
        Logger.f235387a.d().i("GuildHomeViewModel", 1, "onGuildIdChanged() guildId not changed (guildId=" + getGuildId() + ")");
    }

    @Override // mp1.b
    @NotNull
    /* renamed from: a1, reason: from getter */
    public GuildHomePermissionViewModel getGuildHomePermissionViewModel() {
        return this.guildHomePermissionViewModel;
    }

    @NotNull
    public final StateFlow<Long> a2() {
        return (StateFlow) this.reconnectEvent.getValue();
    }

    @NotNull
    public final GuildTabsViewModel b2() {
        return (GuildTabsViewModel) this.tabsViewModel.getValue();
    }

    public final void d2(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeViewModel", 2, "refresh: " + source);
        }
        this.jumpGuildParam.guildId = getGuildId();
        this.guildInfoViewModel.R1(getGuildId());
        b2().X1(getGuildId());
        Z1().X1(getGuildId());
        this.livingViewModel.T1(getGuildId());
        getGuildHomePermissionViewModel().g2(getGuildId());
        getGuildSubTabPageViewModel().T1(getGuildId());
    }

    public void e2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId.setValue(this, T[0], str);
    }

    public final void f2(@NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "<set-?>");
        this.jumpGuildParam = jumpGuildParam;
    }

    @Override // mp1.b
    public void finishRefresh() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeViewModel", 2, "finishRefresh");
        }
        T1().setValue(new ef1.a<>(Boolean.TRUE));
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.d
    @NotNull
    public String getGuildId() {
        return (String) this.guildId.getValue(this, T[0]);
    }
}
