package com.tencent.guild.aio.msglist.holder.config;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.guild.aio.msglist.holder.component.GuildMsgItemComponentProvider;
import com.tencent.guild.aio.msglist.holder.component.k;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import eq0.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J \u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002J\u0014\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ)\u0010\u0012\u001a\u00020\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\fJ&\u0010\u0018\u001a\u00020\u00052\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\fJ \u0010\u001b\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00190\bJ2\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0003J\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0019R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R1\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010&R.\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R(\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00190\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R*\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "", "Lkotlin/Function2;", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "", "factoryProviderGetter", "e", "Lkotlin/Function0;", "Leq0/g;", "templateGetter", "g", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "root", "componentProviderGetter", "f", "Lcom/tencent/guild/aio/msglist/holder/config/a;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "bubbleMsgItemVBGetter", "c", "Lcom/tencent/aio/api/list/b;", "bubbleMsgItemVMGetter", "d", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "", "viewType", "factoryProvider", "b", "a", "Lkotlin/jvm/functions/Function0;", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "cellFactoryComponentProviderGetter", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildItemViewHolderDelegate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends g> templateGetter = new Function0<eq0.c>() { // from class: com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate$templateGetter$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final eq0.c invoke() {
            return new eq0.c();
        }
    };

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, ? extends d> componentProviderGetter = new Function1<View, GuildMsgItemComponentProvider>() { // from class: com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate$componentProviderGetter$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final GuildMsgItemComponentProvider invoke(@NotNull View root) {
            Intrinsics.checkNotNullParameter(root, "root");
            return new GuildMsgItemComponentProvider(root, null, null, null, null, null, null, null, null, null, null, 2046, null);
        }
    };

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super BubbleMsgItemVBArgs, ? extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>> bubbleMsgItemVBGetter = new Function1<BubbleMsgItemVBArgs, com.tencent.guild.aio.msglist.holder.a>() { // from class: com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate$bubbleMsgItemVBGetter$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final com.tencent.guild.aio.msglist.holder.a invoke(@NotNull BubbleMsgItemVBArgs it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new com.tencent.guild.aio.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>> bubbleMsgItemVMGetter = new Function0<com.tencent.guild.aio.msglist.holder.b>() { // from class: com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate$bubbleMsgItemVMGetter$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final com.tencent.guild.aio.msglist.holder.b invoke() {
            return new com.tencent.guild.aio.msglist.holder.b();
        }
    };

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super c, ? super d, Unit> cellFactoryComponentProviderGetter;

    @NotNull
    public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> a() {
        return this.bubbleMsgItemVMGetter.invoke();
    }

    @NotNull
    public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b(@NotNull ViewGroup parent, boolean isSelf, int viewType, @NotNull c factoryProvider) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        g invoke = this.templateGetter.invoke();
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        View d16 = invoke.d(context, parent, isSelf);
        d invoke2 = this.componentProviderGetter.invoke(d16);
        SparseArray<com.tencent.guild.aio.msglist.holder.component.a> sparseArray = invoke2.get();
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            com.tencent.guild.aio.msglist.holder.component.a valueAt = sparseArray.valueAt(i3);
            if (valueAt != null) {
                k.b(valueAt, keyAt, invoke);
            }
        }
        SparseArray<com.tencent.guild.aio.msglist.holder.component.a> sparseArray2 = invoke2.get();
        int size2 = sparseArray2.size();
        for (int i16 = 0; i16 < size2; i16++) {
            int keyAt2 = sparseArray2.keyAt(i16);
            com.tencent.guild.aio.msglist.holder.component.a valueAt2 = sparseArray2.valueAt(i16);
            if (valueAt2 != null) {
                k.a(valueAt2, keyAt2, invoke);
            }
        }
        Function2<? super c, ? super d, Unit> function2 = this.cellFactoryComponentProviderGetter;
        if (function2 != null) {
            function2.invoke(factoryProvider, invoke2);
        }
        return this.bubbleMsgItemVBGetter.invoke(new BubbleMsgItemVBArgs(d16, invoke2, factoryProvider, viewType));
    }

    public final void c(@NotNull Function1<? super BubbleMsgItemVBArgs, ? extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>> bubbleMsgItemVBGetter) {
        Intrinsics.checkNotNullParameter(bubbleMsgItemVBGetter, "bubbleMsgItemVBGetter");
        this.bubbleMsgItemVBGetter = bubbleMsgItemVBGetter;
    }

    public final void d(@NotNull Function0<? extends com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>> bubbleMsgItemVMGetter) {
        Intrinsics.checkNotNullParameter(bubbleMsgItemVMGetter, "bubbleMsgItemVMGetter");
        this.bubbleMsgItemVMGetter = bubbleMsgItemVMGetter;
    }

    public final void e(@NotNull Function2<? super c, ? super d, Unit> factoryProviderGetter) {
        Intrinsics.checkNotNullParameter(factoryProviderGetter, "factoryProviderGetter");
        this.cellFactoryComponentProviderGetter = factoryProviderGetter;
    }

    public final void f(@NotNull Function1<? super View, ? extends d> componentProviderGetter) {
        Intrinsics.checkNotNullParameter(componentProviderGetter, "componentProviderGetter");
        this.componentProviderGetter = componentProviderGetter;
    }

    public final void g(@NotNull Function0<? extends g> templateGetter) {
        Intrinsics.checkNotNullParameter(templateGetter, "templateGetter");
        this.templateGetter = templateGetter;
    }
}
