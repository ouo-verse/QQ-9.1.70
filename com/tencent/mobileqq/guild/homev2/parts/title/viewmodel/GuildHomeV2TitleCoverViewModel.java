package com.tencent.mobileqq.guild.homev2.parts.title.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0002H\u0014R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0019\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120 8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleCoverViewModel;", "Lef1/b;", "", "Z1", "Lcom/tencent/mobileqq/guild/theme/d;", "R1", "b2", "", "hasCover", "X1", "", "offset", ICustomDataEditor.STRING_ARRAY_PARAM_2, "onCleared", "Lko4/a;", BdhLogUtil.LogTag.Tag_Conn, "Lko4/a;", "_themeColorChange", "", "D", "_titleAlpha", "E", "Lkotlin/Lazy;", "T1", "()Lcom/tencent/mobileqq/guild/theme/d;", "mThemeChangeCallback", UserInfo.SEX_FEMALE, "Z", "mHasCover", "G", "I", "mLoadingOffset", "Landroidx/lifecycle/LiveData;", "U1", "()Landroidx/lifecycle/LiveData;", "themeColorChange", "W1", "titleAlpha", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2TitleCoverViewModel extends ef1.b {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Float> I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<Boolean> _themeColorChange = new ko4.a<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ko4.a<Float> _titleAlpha = new ko4.a<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mThemeChangeCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mHasCover;

    /* renamed from: G, reason: from kotlin metadata */
    private int mLoadingOffset;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel$1", f = "GuildHomeV2TitleCoverViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildHomeV2TitleCoverViewModel.this.Z1();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/GuildHomeV2TitleCoverViewModel$a;", "", "", "OFFSET_DISTANCE$delegate", "Lkotlin/Lazy;", "b", "()F", "OFFSET_DISTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b() {
            return ((Number) GuildHomeV2TitleCoverViewModel.I.getValue()).floatValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Float> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel$Companion$OFFSET_DISTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(bi.b(60));
            }
        });
        I = lazy;
    }

    public GuildHomeV2TitleCoverViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.theme.d>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.GuildHomeV2TitleCoverViewModel$mThemeChangeCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.theme.d invoke() {
                com.tencent.mobileqq.guild.theme.d R1;
                R1 = GuildHomeV2TitleCoverViewModel.this.R1();
                return R1;
            }
        });
        this.mThemeChangeCallback = lazy;
        GuildThemeManager.g(T1());
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "GuildHomeV2TitleCoverViewModel init", null, null, Boolean.TRUE, new AnonymousClass1(null), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.theme.d R1() {
        return new com.tencent.mobileqq.guild.theme.d() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.a
            @Override // com.tencent.mobileqq.guild.theme.d
            public final void onThemeChanged() {
                GuildHomeV2TitleCoverViewModel.S1(GuildHomeV2TitleCoverViewModel.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(GuildHomeV2TitleCoverViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z1();
    }

    private final com.tencent.mobileqq.guild.theme.d T1() {
        return (com.tencent.mobileqq.guild.theme.d) this.mThemeChangeCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1() {
        this._themeColorChange.setValue(Boolean.TRUE);
    }

    private final void b2() {
        float coerceAtMost;
        float coerceAtLeast;
        boolean z16 = this.mHasCover;
        Float valueOf = Float.valueOf(1.0f);
        if (!z16) {
            this._titleAlpha.setValue(valueOf);
            return;
        }
        int i3 = this.mLoadingOffset;
        if (i3 <= 0) {
            this._titleAlpha.setValue(valueOf);
            return;
        }
        float f16 = i3;
        Companion companion = INSTANCE;
        if (f16 >= companion.b()) {
            this._titleAlpha.setValue(Float.valueOf(0.0f));
            return;
        }
        ko4.a<Float> aVar = this._titleAlpha;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(1.0f - (this.mLoadingOffset / companion.b()), 1.0f);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0.0f);
        aVar.setValue(Float.valueOf(coerceAtLeast));
    }

    @NotNull
    public final LiveData<Boolean> U1() {
        return this._themeColorChange;
    }

    @NotNull
    public final LiveData<Float> W1() {
        return this._titleAlpha;
    }

    public final void X1(boolean hasCover) {
        this.mHasCover = hasCover;
    }

    public final void a2(int offset) {
        this.mLoadingOffset = offset;
        b2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GuildThemeManager.j(T1());
    }
}
