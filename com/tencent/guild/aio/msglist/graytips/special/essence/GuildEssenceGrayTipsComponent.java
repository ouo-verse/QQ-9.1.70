package com.tencent.guild.aio.msglist.graytips.special.essence;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.graytips.special.essence.GuildEssenceGrayTipsComponent;
import com.tencent.guild.aio.msglist.graytips.special.essence.GuildEssenceGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.special.essence.c;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u0001:\u000267B\u000f\u0012\u0006\u0010$\u001a\u00020\u000e\u00a2\u0006\u0004\b3\u00104J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00170\u001dH\u0016R\u0017\u0010$\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/essence/GuildEssenceGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "", "payloads", "", "l1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "m1", "", "text", "o1", "Landroid/view/View;", "d1", "bindData", "Lkotlin/Function0;", "function", ICustomDataEditor.NUMBER_PARAM_1, "", "position", "b1", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "e1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "i", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EssenceElement;", "currentElement", "Lcom/tencent/guild/aio/msglist/graytips/special/essence/GuildEssenceGrayTipsComponent$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "k1", "()Lcom/tencent/guild/aio/msglist/graytips/special/essence/GuildEssenceGrayTipsComponent$a;", "binding", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildEssenceGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EssenceElement currentElement;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/essence/GuildEssenceGrayTipsComponent$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "d", "()Landroid/view/ViewGroup;", h.F, "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "e", "(Landroid/widget/ImageView;)V", "grayTipsIcon", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "()Landroid/widget/LinearLayout;", "g", "(Landroid/widget/LinearLayout;)V", "grayTipsTextTotal", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "f", "(Landroid/widget/TextView;)V", "grayTipsNickName", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public ImageView grayTipsIcon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public LinearLayout grayTipsTextTotal;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsNickName;

        @NotNull
        public final ImageView a() {
            ImageView imageView = this.grayTipsIcon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsIcon");
            return null;
        }

        @NotNull
        public final TextView b() {
            TextView textView = this.grayTipsNickName;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsNickName");
            return null;
        }

        @NotNull
        public final LinearLayout c() {
            LinearLayout linearLayout = this.grayTipsTextTotal;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsTextTotal");
            return null;
        }

        @NotNull
        public final ViewGroup d() {
            ViewGroup viewGroup = this.root;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        public final void e(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.grayTipsIcon = imageView;
        }

        public final void f(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.grayTipsNickName = textView;
        }

        public final void g(@NotNull LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.grayTipsTextTotal = linearLayout;
        }

        public final void h(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.root = viewGroup;
        }
    }

    public GuildEssenceGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.msglist.graytips.special.essence.GuildEssenceGrayTipsComponent$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildEssenceGrayTipsComponent.a invoke() {
                GuildEssenceGrayTipsComponent.a aVar = new GuildEssenceGrayTipsComponent.a();
                a aVar2 = new a(GuildEssenceGrayTipsComponent.this.getRoot().getContext());
                ViewGroup b16 = aVar2.b();
                Intrinsics.checkNotNullExpressionValue(b16, "view.root");
                aVar.h(b16);
                ImageView imageView = aVar2.f111411b;
                Intrinsics.checkNotNullExpressionValue(imageView, "view.grayTipsIcon");
                aVar.e(imageView);
                LinearLayout linearLayout = aVar2.f111412c;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "view.grayTipsTextTotal");
                aVar.g(linearLayout);
                TextView textView = aVar2.f111413d;
                Intrinsics.checkNotNullExpressionValue(textView, "view.grayTipsNickName");
                aVar.f(textView);
                return aVar;
            }
        });
        this.binding = lazy;
    }

    private final a k1() {
        return (a) this.binding.getValue();
    }

    private final boolean l1(List<Object> payloads) {
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
    public final void m1(com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(8);
        if (firstTypeElement != null) {
            this.currentMsgItem = guildMsgItem;
            GrayTipElement grayTipElement = firstTypeElement.grayTipElement;
            if (grayTipElement != null) {
                Intrinsics.checkNotNullExpressionValue(grayTipElement, "grayTipElement");
                EssenceElement essenceElement = grayTipElement.essenceElement;
                if (essenceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(essenceElement, "essenceElement");
                    this.currentElement = essenceElement;
                    sendIntent(new c.b(guildMsgItem, essenceElement));
                }
            }
        }
    }

    private final void o1(CharSequence text) {
        k1().a().setImageDrawable(GuildUIUtils.f235378a.A(getMContext(), R.drawable.guild_aio_essence_icon, R.color.qui_common_icon_secondary));
        k1().c().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.graytips.special.essence.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEssenceGrayTipsComponent.p1(GuildEssenceGrayTipsComponent.this, view);
            }
        });
        k1().b().setText(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(GuildEssenceGrayTipsComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EssenceElement essenceElement = this$0.currentElement;
        if (essenceElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentElement");
            essenceElement = null;
        }
        this$0.sendIntent(new c.a(essenceElement));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (l1(payloads)) {
            n1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.graytips.special.essence.GuildEssenceGrayTipsComponent$bind$1
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
                    GuildEssenceGrayTipsComponent.this.m1(msgItem);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return k1().d();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        if (this.currentMsgItem != null && this.currentElement != null) {
            GuildMsgItem guildMsgItem = this.currentMsgItem;
            EssenceElement essenceElement = null;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            EssenceElement essenceElement2 = this.currentElement;
            if (essenceElement2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentElement");
                essenceElement2 = null;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                str = iGPSService.getSelfTinyId();
            } else {
                str = null;
            }
            EssenceElement essenceElement3 = this.currentElement;
            if (essenceElement3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentElement");
            } else {
                essenceElement = essenceElement3;
            }
            return new d(guildMsgItem, essenceElement2, !TextUtils.equals(str, String.valueOf(essenceElement.tinyId)));
        }
        return new d(null, null, false, 7, null);
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildEssenceGrayTipsUIState.SetEssenceText) {
            o1(((GuildEssenceGrayTipsUIState.SetEssenceText) state).getText());
        }
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
                QLog.d("GuildEssenceGrayTipsComponent", 4, "\u76f8\u540c\u547d\u4e2d ");
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
