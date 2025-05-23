package ef1;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lef1/c;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018JQ\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\u0004*\u00020\u0001\"\b\b\u0002\u0010\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u0002\u00a2\u0006\u0004\b\f\u0010\rJ?\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\u0004*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00028\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lef1/c$a;", "", "Landroidx/lifecycle/ViewModel;", "T", "ARG1", "ARG2", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Ljava/lang/Class;", "clazz", "arg1", "arg2", "b", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "a", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Class;Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "Lkotlin/Function0;", "block", "c", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ef1.c$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"ef1/c$a$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: ef1.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C10235a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f396219a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f396220b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f396221c;

            public C10235a(Class cls, Object obj, Object obj2) {
                this.f396219a = cls;
                this.f396220b = obj;
                this.f396221c = obj2;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                Object newInstance = this.f396219a.getConstructor(this.f396220b.getClass(), this.f396221c.getClass()).newInstance(this.f396220b, this.f396221c);
                Intrinsics.checkNotNullExpressionValue(newInstance, "clazz.getConstructor(arg\u2026).newInstance(arg1, arg2)");
                ViewModel viewModel = (ViewModel) newInstance;
                Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of com.tencent.mobileqq.guild.base.mvvm.SingleViewModelProvider.Companion.factory.<no name provided>.create$lambda$0");
                TimedValue timedValue = new TimedValue(viewModel, TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"ef1/c$a$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: ef1.c$a$b */
        /* loaded from: classes12.dex */
        public static final class b implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f396222a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f396223b;

            public b(Class cls, Object obj) {
                this.f396222a = cls;
                this.f396223b = obj;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                Object newInstance = this.f396222a.getConstructor(this.f396223b.getClass()).newInstance(this.f396223b);
                Intrinsics.checkNotNullExpressionValue(newInstance, "clazz.getConstructor(arg\u2026s.java).newInstance(arg1)");
                ViewModel viewModel = (ViewModel) newInstance;
                Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of com.tencent.mobileqq.guild.base.mvvm.SingleViewModelProvider.Companion.factory.<no name provided>.create$lambda$0");
                TimedValue timedValue = new TimedValue(viewModel, TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"ef1/c$a$c", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: ef1.c$a$c, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C10236c implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function0 f396224a;

            public C10236c(Function0 function0) {
                this.f396224a = function0;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                ViewModel viewModel = (ViewModel) this.f396224a.invoke();
                Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of com.tencent.mobileqq.guild.base.mvvm.SingleViewModelProvider.Companion.factory.<no name provided>.create$lambda$0");
                TimedValue timedValue = new TimedValue(viewModel, TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T extends ViewModel, ARG1> T a(@NotNull ViewModelStoreOwner owner, @NotNull Class<T> clazz, @NotNull ARG1 arg1) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(arg1, "arg1");
            T t16 = (T) new ViewModelProvider(owner, new b(clazz, arg1)).get(clazz);
            Intrinsics.checkNotNullExpressionValue(t16, "ViewModelProvider(owner,\u2026wInstance(arg1) })[clazz]");
            return t16;
        }

        @NotNull
        public final <T extends ViewModel, ARG1, ARG2> T b(@NotNull ViewModelStoreOwner owner, @NotNull Class<T> clazz, @NotNull ARG1 arg1, @NotNull ARG2 arg2) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(arg1, "arg1");
            Intrinsics.checkNotNullParameter(arg2, "arg2");
            T t16 = (T) new ViewModelProvider(owner, new C10235a(clazz, arg1, arg2)).get(clazz);
            Intrinsics.checkNotNullExpressionValue(t16, "ViewModelProvider(owner,\u2026nce(arg1, arg2) })[clazz]");
            return t16;
        }

        @JvmStatic
        @NotNull
        public final <T extends ViewModel> T c(@NotNull ViewModelStoreOwner owner, @NotNull Class<T> clazz, @NotNull Function0<? extends T> block) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(block, "block");
            T t16 = (T) new ViewModelProvider(owner, new C10236c(block)).get(clazz);
            Intrinsics.checkNotNullExpressionValue(t16, "ViewModelProvider(owner,\u2026ctory { block() })[clazz]");
            return t16;
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final <T extends ViewModel> T a(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull Class<T> cls, @NotNull Function0<? extends T> function0) {
        return (T) INSTANCE.c(viewModelStoreOwner, cls, function0);
    }
}
