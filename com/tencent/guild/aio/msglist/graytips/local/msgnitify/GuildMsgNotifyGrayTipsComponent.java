package com.tencent.guild.aio.msglist.graytips.local.msgnitify;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.guild.aio.msglist.graytips.local.msgnitify.GuildMsgNotifyGrayTipsComponent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eJ&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u001b\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgNotifyGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "", "payloads", "", "k1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "l1", "bindData", "Lkotlin/Function0;", "function", "m1", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgNotifyGrayTipsComponent$a;", "i", "Lkotlin/Lazy;", "j1", "()Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgNotifyGrayTipsComponent$a;", "mBinding", "<init>", "(Landroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgNotifyGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\n\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgNotifyGrayTipsComponent$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "c", "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getCloseMsgNotifyTv", "()Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "closeMsgNotifyTv", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public TextView closeMsgNotifyTv;

        @NotNull
        public final ViewGroup a() {
            ViewGroup viewGroup = this.root;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        public final void b(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.closeMsgNotifyTv = textView;
        }

        public final void c(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.root = viewGroup;
        }
    }

    public GuildMsgNotifyGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.msglist.graytips.local.msgnitify.GuildMsgNotifyGrayTipsComponent$mBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMsgNotifyGrayTipsComponent.a invoke() {
                GuildMsgNotifyGrayTipsComponent.a aVar = new GuildMsgNotifyGrayTipsComponent.a();
                a aVar2 = new a(GuildMsgNotifyGrayTipsComponent.this.getRoot().getContext());
                ViewGroup b16 = aVar2.b();
                Intrinsics.checkNotNullExpressionValue(b16, "view.root");
                aVar.c(b16);
                TextView textView = aVar2.f111359d;
                Intrinsics.checkNotNullExpressionValue(textView, "view.closeMsgNotifyTv");
                aVar.b(textView);
                return aVar;
            }
        });
        this.mBinding = lazy;
    }

    private final a j1() {
        return (a) this.mBinding.getValue();
    }

    private final boolean k1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        this.currentMsgItem = (GuildMsgItem) msgItem;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (k1(payloads)) {
            m1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.graytips.local.msgnitify.GuildMsgNotifyGrayTipsComponent$bind$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildMsgNotifyGrayTipsComponent.this.l1(position, msgItem, payloads);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return j1().a();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    public final void m1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem == null) {
            function.invoke();
            return;
        }
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        if (guildMsgItem.isSameItem(bindData)) {
            GuildMsgItem guildMsgItem3 = this.currentMsgItem;
            if (guildMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem2 = guildMsgItem3;
            }
            if (guildMsgItem2.isSameContent(bindData)) {
                QLog.d("GuildMsgNotifyGrayTipsComponent", 4, "\u76f8\u540c\u547d\u4e2d ");
                return;
            }
        }
        function.invoke();
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
