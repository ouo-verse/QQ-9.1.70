package j61;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lj61/c;", "Lcom/tencent/mobileqq/mvvm/c;", "Lj61/b;", "Landroidx/lifecycle/MutableLiveData;", "Lj61/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "onIntimateInfoUpdate", "repository", "<init>", "(Lj61/b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends com.tencent.mobileqq.mvvm.c<b> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<IntimateBaseModel> onIntimateInfoUpdate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static ViewModelProvider.Factory C = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"j61/c$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new c(new b());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lj61/c$b;", "", "Landroidx/lifecycle/ViewModelProvider$Factory;", "sFacadeViewModel", "Landroidx/lifecycle/ViewModelProvider$Factory;", "a", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setSFacadeViewModel", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: j61.c$b, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ViewModelProvider.Factory a() {
            return c.C;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull b repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.onIntimateInfoUpdate = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<IntimateBaseModel> M1() {
        return this.onIntimateInfoUpdate;
    }
}
