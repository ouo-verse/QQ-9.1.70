package com.tencent.guild.aio.msglist.graytips.local.msgnitify;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.guild.aio.msglist.graytips.local.msgnitify.GuildMsgSwitchSettingsGrayTipsComponent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.rmonitor.custom.ICustomDataEditor;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0002*+B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0013\u00a2\u0006\u0004\b'\u0010(J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u001c\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fJ&\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0017\u0010\u001c\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgSwitchSettingsGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "", "payloads", "", "k1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "m1", "l1", "bindData", "Lkotlin/Function0;", "function", ICustomDataEditor.NUMBER_PARAM_1, "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgSwitchSettingsGrayTipsComponent$a;", "i", "Lkotlin/Lazy;", "j1", "()Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgSwitchSettingsGrayTipsComponent$a;", "mBinding", "<init>", "(Landroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgSwitchSettingsGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/local/msgnitify/GuildMsgSwitchSettingsGrayTipsComponent$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "b", "()Landroid/view/ViewGroup;", "d", "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "c", "(Landroid/widget/TextView;)V", "closeMsgNotifyTv", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public TextView closeMsgNotifyTv;

        @NotNull
        public final TextView a() {
            TextView textView = this.closeMsgNotifyTv;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("closeMsgNotifyTv");
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
            this.closeMsgNotifyTv = textView;
        }

        public final void d(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.root = viewGroup;
        }
    }

    public GuildMsgSwitchSettingsGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.msglist.graytips.local.msgnitify.GuildMsgSwitchSettingsGrayTipsComponent$mBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMsgSwitchSettingsGrayTipsComponent.a invoke() {
                GuildMsgSwitchSettingsGrayTipsComponent.a aVar = new GuildMsgSwitchSettingsGrayTipsComponent.a();
                b bVar = new b(GuildMsgSwitchSettingsGrayTipsComponent.this.getRoot().getContext());
                ViewGroup b16 = bVar.b();
                Intrinsics.checkNotNullExpressionValue(b16, "view.root");
                aVar.d(b16);
                TextView textView = bVar.f111363d;
                Intrinsics.checkNotNullExpressionValue(textView, "view.mCloseMsgNotifyTv");
                aVar.c(textView);
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

    private final void l1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_graytext_type", 9);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(j1().a(), "em_aio_graytext", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1(int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        this.currentMsgItem = (GuildMsgItem) msgItem;
        l1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (k1(payloads)) {
            n1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.graytips.local.msgnitify.GuildMsgSwitchSettingsGrayTipsComponent$bind$1
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
                    GuildMsgSwitchSettingsGrayTipsComponent.this.m1(position, msgItem, payloads);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return j1().b();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    public final void n1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
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
