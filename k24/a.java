package k24;

import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.aio.robot.inputbar.RobotAIOInputContainerVB;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.aio.api.IAIOFactoryApi;
import com.tencent.qqnt.aio.api.IAIOFactoryExtApi;
import com.tencent.robot.aio.background.RobotBackgroundVB;
import com.tencent.robot.aio.bottomcontainer.RobotAIOBottomContainerVB;
import com.tencent.robot.aio.helper.RobotHelperProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lk24/a;", "Lcom/tencent/qqnt/aio/factory/d;", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/c;", "buildPanelArea", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends com.tencent.qqnt.aio.factory.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f411438e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lk24/a$a;", "", "", "", "ROBOT_INPUT_DELEGATE_LIST", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k24.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<Integer> a() {
            return a.f411438e;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0004H\u0016J\u001a\u0010\b\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u001a\u0010\t\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"k24/a$b", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/aio/robot/inputbar/RobotAIOInputContainerVB;", h.F, "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "buildTitleVB", "buildShortcutBarVB", "buildBottomBarVB", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements f {
        b() {
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            return new RobotAIOBottomContainerVB();
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            return null;
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            return new b34.a();
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<? extends e, ? extends TopTipViewState> buildTopTipVB() {
            return f.a.f(this);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return f.a.g(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public RobotAIOInputContainerVB buildInputVB() {
            return new RobotAIOInputContainerVB(new n24.a(), true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"k24/a$c", "Lcom/tencent/aio/api/factory/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.aio.api.factory.a {
        c() {
        }

        @Override // com.tencent.aio.api.factory.a
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            return new RobotBackgroundVB();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"k24/a$d", "Lcom/tencent/aio/api/factory/e;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements com.tencent.aio.api.factory.e {
        d() {
        }

        @Override // com.tencent.aio.api.factory.e
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.d, ? extends Reserve2UIState> a() {
            return new z24.a();
        }
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189165b), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189166c), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189170g), Integer.valueOf(com.tencent.mobileqq.aio.input.adorn.d.f189176m)});
        f411438e = listOf;
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public f buildBusinessLevel() {
        return ((IAIOFactoryExtApi) QRoute.api(IAIOFactoryExtApi.class)).buildBusinessLevelCompactInputHeight(new b());
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        return new c();
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.help.c
    @NotNull
    public com.tencent.aio.api.help.d buildHelperProvider() {
        return new RobotHelperProvider();
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        return new com.tencent.mobileqq.aio.robot.a();
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.c buildPanelArea() {
        return ((IAIOFactoryApi) QRoute.api(IAIOFactoryApi.class)).buildPanelAreaWithPanelFactory(new k24.c());
    }

    @Override // com.tencent.qqnt.aio.factory.d, com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        return new d();
    }
}
