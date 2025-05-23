package com.tencent.guild.aio.msglist.graytips.special.revoke;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.input.at.hashtag.ui.k;
import com.tencent.guild.aio.msglist.graytips.special.revoke.GuildRevokeGrayTipsComponent;
import com.tencent.guild.aio.msglist.graytips.special.revoke.GuildRevokeGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.special.revoke.c;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guild.aio.util.l;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
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
import xp0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0002>?B\u000f\u0012\u0006\u0010,\u001a\u00020\u001c\u00a2\u0006\u0004\b;\u0010<J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0014\u0010\u0017\u001a\u00020\u000b*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u001c\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J\b\u0010\u001d\u001a\u00020\u001cH\u0016J&\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\"H\u0016J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001f0%H\u0016R\u0017\u0010,\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "", "payloads", "", ICustomDataEditor.NUMBER_PARAM_1, "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "o1", "", "nickBy", "nickOf", "textTail", "canEdit", "r1", "nickByLength", "l1", "Landroid/widget/TextView;", "weight", ICustomDataEditor.STRING_PARAM_1, "bindData", "Lkotlin/Function0;", "function", "q1", "Landroid/view/View;", "d1", "b1", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "e1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "i", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "currentElement", "Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsComponent$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "m1", "()Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsComponent$a;", "binding", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildRevokeGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RevokeElement currentElement;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018\"\u0004\b\u001e\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsComponent$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", "l", "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", h.F, "(Landroid/widget/ImageView;)V", "grayTipsIcon", "c", "g", "grayTipsCloseIcon", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "e", "()Landroid/widget/TextView;", "k", "(Landroid/widget/TextView;)V", "grayTipsTextTail", "i", "grayTipsNickNameBy", "j", "grayTipsNickNameOf", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public ImageView grayTipsIcon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public ImageView grayTipsCloseIcon;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsTextTail;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsNickNameBy;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsNickNameOf;

        @NotNull
        public final ImageView a() {
            ImageView imageView = this.grayTipsCloseIcon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsCloseIcon");
            return null;
        }

        @NotNull
        public final ImageView b() {
            ImageView imageView = this.grayTipsIcon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsIcon");
            return null;
        }

        @NotNull
        public final TextView c() {
            TextView textView = this.grayTipsNickNameBy;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsNickNameBy");
            return null;
        }

        @NotNull
        public final TextView d() {
            TextView textView = this.grayTipsNickNameOf;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsNickNameOf");
            return null;
        }

        @NotNull
        public final TextView e() {
            TextView textView = this.grayTipsTextTail;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsTextTail");
            return null;
        }

        @NotNull
        public final ViewGroup f() {
            ViewGroup viewGroup = this.root;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }

        public final void g(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.grayTipsCloseIcon = imageView;
        }

        public final void h(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.grayTipsIcon = imageView;
        }

        public final void i(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.grayTipsNickNameBy = textView;
        }

        public final void j(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.grayTipsNickNameOf = textView;
        }

        public final void k(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.grayTipsTextTail = textView;
        }

        public final void l(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.root = viewGroup;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsComponent$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildRevokeGrayTipsComponent guildRevokeGrayTipsComponent = GuildRevokeGrayTipsComponent.this;
            GuildMsgItem guildMsgItem = guildRevokeGrayTipsComponent.currentMsgItem;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            guildRevokeGrayTipsComponent.sendIntent(new b.a(guildMsgItem));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setUnderlineText(false);
        }
    }

    public GuildRevokeGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.msglist.graytips.special.revoke.GuildRevokeGrayTipsComponent$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildRevokeGrayTipsComponent.a invoke() {
                GuildRevokeGrayTipsComponent.a aVar = new GuildRevokeGrayTipsComponent.a();
                a aVar2 = new a();
                aVar2.a(GuildRevokeGrayTipsComponent.this.getRoot().getContext());
                ViewGroup b16 = aVar2.b();
                Intrinsics.checkNotNullExpressionValue(b16, "view.root");
                aVar.l(b16);
                ImageView imageView = aVar2.f111451c;
                Intrinsics.checkNotNullExpressionValue(imageView, "view.grayTipsIcon");
                aVar.h(imageView);
                ImageView imageView2 = aVar2.f111456h;
                Intrinsics.checkNotNullExpressionValue(imageView2, "view.grayTipsCloseIcon");
                aVar.g(imageView2);
                TextView textView = aVar2.f111455g;
                Intrinsics.checkNotNullExpressionValue(textView, "view.grayTipsTextTail");
                aVar.k(textView);
                TextView textView2 = aVar2.f111452d;
                Intrinsics.checkNotNullExpressionValue(textView2, "view.grayTipsNickNameBy");
                aVar.i(textView2);
                TextView textView3 = aVar2.f111454f;
                Intrinsics.checkNotNullExpressionValue(textView3, "view.grayTipsNickNameOf");
                aVar.j(textView3);
                return aVar;
            }
        });
        this.binding = lazy;
    }

    private final void l1(int nickByLength) {
        int i3;
        if (nickByLength > 3) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        s1(m1().c(), i3);
        s1(m1().d(), 1 - i3);
    }

    private final a m1() {
        return (a) this.binding.getValue();
    }

    private final boolean n1(List<Object> payloads) {
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
    public final void o1(int position, final com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        RecyclerView.LayoutParams layoutParams;
        View findViewById = this.root.findViewById(R.id.vsd);
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            if (layoutParams2 instanceof RecyclerView.LayoutParams) {
                layoutParams = (RecyclerView.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                ViewExtKt.f(findViewById, 0);
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = wr0.a.f446116a.b(20);
            }
        }
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(8);
        if (firstTypeElement != null) {
            this.currentMsgItem = guildMsgItem;
            GrayTipElement grayTipElement = firstTypeElement.grayTipElement;
            if (grayTipElement != null) {
                Intrinsics.checkNotNullExpressionValue(grayTipElement, "grayTipElement");
                RevokeElement revokeElement = grayTipElement.revokeElement;
                if (revokeElement != null) {
                    Intrinsics.checkNotNullExpressionValue(revokeElement, "revokeElement");
                    m1().b().setImageDrawable(GuildUIUtils.w(getMContext(), R.drawable.qui_recall, Integer.valueOf(R.color.qui_common_icon_secondary)));
                    IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
                    String str = guildMsgItem.getMsgRecord().channelId;
                    Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
                    String str2 = guildMsgItem.getMsgRecord().guildId;
                    Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
                    if (iGuildChannelApi.isSelfGuest(str, str2)) {
                        m1().a().setVisibility(8);
                    } else {
                        m1().a().setVisibility(0);
                        m1().a().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.graytips.special.revoke.b
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                GuildRevokeGrayTipsComponent.p1(GuildRevokeGrayTipsComponent.this, msgItem, view);
                            }
                        });
                    }
                    sendIntent(new c.a(guildMsgItem, revokeElement));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(GuildRevokeGrayTipsComponent this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.sendIntent(new b.C11559b(msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void r1(CharSequence nickBy, CharSequence nickOf, CharSequence textTail, boolean canEdit) {
        if (canEdit) {
            c cVar = new c();
            String obj = l.b(l.f112411a, R.string.f153271bn, null, 2, null).toString();
            SpannableString spannableString = new SpannableString(obj);
            spannableString.setSpan(cVar, obj.length() - 4, obj.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getMContext().getColor(R.color.qui_common_text_link)), obj.length() - 4, obj.length(), 33);
            textTail = spannableString;
        }
        m1().e().setText(textTail);
        m1().e().setMovementMethod(new k());
        if (!TextUtils.isEmpty(nickBy)) {
            m1().c().setText(nickBy);
            m1().c().setVisibility(0);
        } else {
            m1().c().setVisibility(8);
        }
        if (!TextUtils.isEmpty(nickOf)) {
            m1().d().setText(nickOf);
            m1().d().setVisibility(0);
        } else {
            m1().d().setVisibility(8);
        }
        l1(nickBy.length());
    }

    private final void s1(TextView textView, int i3) {
        LinearLayout.LayoutParams layoutParams;
        if (textView.getVisibility() == 8) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.weight = i3;
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(final int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull final List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (n1(payloads)) {
            q1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.graytips.special.revoke.GuildRevokeGrayTipsComponent$bind$1
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
                    GuildRevokeGrayTipsComponent.this.o1(position, msgItem, payloads);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return m1().f();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        if (this.currentMsgItem != null && this.currentElement != null) {
            RevokeElement revokeElement = this.currentElement;
            GuildMsgItem guildMsgItem = null;
            if (revokeElement == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentElement");
                revokeElement = null;
            }
            GuildMsgItem guildMsgItem2 = this.currentMsgItem;
            if (guildMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem2 = null;
            }
            GuildMsgItem guildMsgItem3 = this.currentMsgItem;
            if (guildMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem = guildMsgItem3;
            }
            return new f(revokeElement, guildMsgItem2, yp0.a.b(guildMsgItem.getMsgRecord()), true);
        }
        return new f(null, null, null, false, 15, null);
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildRevokeGrayTipsUIState.SetRevokeText) {
            GuildRevokeGrayTipsUIState.SetRevokeText setRevokeText = (GuildRevokeGrayTipsUIState.SetRevokeText) state;
            r1(setRevokeText.getNickBy(), setRevokeText.getNickOf(), setRevokeText.getTextTail(), setRevokeText.getCanEdit());
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

    public final void q1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
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
                QLog.d("GrayTipsContentComponent", 4, "\u76f8\u540c\u547d\u4e2d ");
                return;
            }
        }
        function.invoke();
    }
}
