package com.tencent.guild.aio.msglist.graytips.common;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.guild.aio.msglist.graytips.common.GuildCommonGrayTipsComponent;
import com.tencent.guild.aio.msglist.graytips.common.GuildCommonGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.common.b;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0015H\u0016R\u0017\u0010\u001d\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "text", "", "j1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "state", "handleUIState", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsComponent$a;", h.F, "Lkotlin/Lazy;", "i1", "()Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsComponent$a;", "mBinding", "<init>", "(Landroid/view/View;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildCommonGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsComponent$a;", "", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "c", "(Landroid/widget/TextView;)V", "grayTipsText", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "d", "(Landroid/view/ViewGroup;)V", "root", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsText;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        @NotNull
        public final TextView a() {
            TextView textView = this.grayTipsText;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsText");
            return null;
        }

        @NotNull
        public final ViewGroup b() {
            ViewGroup viewGroup = this.root;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        public final void c(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.grayTipsText = textView;
        }

        public final void d(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.root = viewGroup;
        }
    }

    public GuildCommonGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.msglist.graytips.common.GuildCommonGrayTipsComponent$mBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildCommonGrayTipsComponent.a invoke() {
                GuildCommonGrayTipsComponent.a aVar = new GuildCommonGrayTipsComponent.a();
                c cVar = new c(GuildCommonGrayTipsComponent.this.getRoot().getContext());
                TextView textView = cVar.f111336b;
                Intrinsics.checkNotNullExpressionValue(textView, "view.grayTipsText");
                aVar.c(textView);
                ViewGroup b16 = cVar.b();
                Intrinsics.checkNotNullExpressionValue(b16, "view.root");
                aVar.d(b16);
                return aVar;
            }
        });
        this.mBinding = lazy;
    }

    private final a i1() {
        return (a) this.mBinding.getValue();
    }

    private final void j1(CharSequence text) {
        i1().a().setText(text);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        i1().a().setMovementMethod(LinkMovementMethod.getInstance());
        sendIntent(new b.a(msgItem, i1().a(), null, 4, null));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return i1().b();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new d();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildCommonGrayTipsUIState.SetGrayTipsText) {
            GuildCommonGrayTipsUIState.SetGrayTipsText setGrayTipsText = (GuildCommonGrayTipsUIState.SetGrayTipsText) state;
            if (!setGrayTipsText.getIsRebuild()) {
                boolean z16 = true;
                if (yp0.a.c(setGrayTipsText.getText(), i1().a()) <= 1) {
                    z16 = false;
                }
                if (z16) {
                    sendIntent(new b.C1196b(i1().a()));
                }
            }
            j1(setGrayTipsText.getText());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
