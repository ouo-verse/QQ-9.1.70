package b44;

import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import com.tencent.robot.draw.vb.container.C2CDrawListContainerVB;
import com.tencent.robot.slash.dialog.content.tip.SlashTipContentUIState;
import h64.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002\u00a8\u0006\u0007"}, d2 = {"Lb44/b;", "Lk64/b;", "", "d", "e", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends k64.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0000\u0003\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"b44/b$a", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lk64/a;", "b44/b$a$a", "c", "()Lb44/b$a$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends IStrategyFetcher<k64.a<?>> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J(\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"b44/b$a$a", "Lk64/a;", "Lw64/e;", "Lu54/c;", "context", "", "Lv64/b;", "Lb74/a;", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: b44.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C0096a implements k64.a<e<c>> {
            C0096a() {
            }

            @Override // k64.a
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public List<v64.b<List<b74.a>>> a(@NotNull e<c> context) {
                List<v64.b<List<b74.a>>> listOf;
                Intrinsics.checkNotNullParameter(context, "context");
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new v64.b[]{new x54.a(context), new d64.a(context), new c64.a(context)});
                return listOf;
            }
        }

        a() {
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C0096a a() {
            return new C0096a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0000\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"b44/b$b", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lcom/tencent/robot/slash/dialog/content/middle/a;", "b44/b$b$a", "c", "()Lb44/b$b$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: b44.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C0097b extends IStrategyFetcher<com.tencent.robot.slash.dialog.content.middle.a> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"b44/b$b$a", "Lcom/tencent/robot/slash/dialog/content/middle/a;", "Lcom/tencent/robot/draw/vb/container/C2CDrawListContainerVB;", "c", "Lh64/d;", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: b44.b$b$a */
        /* loaded from: classes25.dex */
        public static final class a implements com.tencent.robot.slash.dialog.content.middle.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f27874a;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\u000b\u001a\u00020\n2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"b44/b$b$a$a", "Lnl3/a;", "Lh64/a;", "Lcom/tencent/robot/slash/dialog/content/tip/SlashTipContentUIState;", "Lw64/e;", "Lu54/c;", "Ln54/a;", "c", "Lcom/tencent/mvi/mvvm/BaseVM;", "mUIModel", "", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: b44.b$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes25.dex */
            public static final class C0098a implements nl3.a<h64.a, SlashTipContentUIState, e<c>> {
                C0098a() {
                }

                @Override // nl3.a
                public void b(@Nullable BaseVM<h64.a, SlashTipContentUIState, e<c>> mUIModel) {
                    if (mUIModel != null) {
                        mUIModel.create();
                    }
                }

                @Override // nl3.a
                @NotNull
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public n54.a a() {
                    return new n54.a();
                }
            }

            a(b bVar) {
                this.f27874a = bVar;
            }

            @Override // com.tencent.robot.slash.dialog.content.middle.a
            @NotNull
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public C2CDrawListContainerVB a() {
                return new C2CDrawListContainerVB(k64.c.a(this.f27874a));
            }

            @Override // com.tencent.robot.slash.dialog.content.middle.a
            @NotNull
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public d b() {
                d dVar = new d();
                dVar.setMVmIVMProvider(new C0098a());
                return dVar;
            }
        }

        C0097b() {
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(b.this);
        }
    }

    public b() {
        d();
        e();
    }

    private final void d() {
        c(k64.a.class, new a());
    }

    private final void e() {
        c(com.tencent.robot.slash.dialog.content.middle.a.class, new C0097b());
    }
}
