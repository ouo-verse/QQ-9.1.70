package com.tencent.guild.aio.msglist.graytips.special.emojireply;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.graytips.special.emojireply.GuildEmojiReplyGrayTipsComponent;
import com.tencent.guild.aio.msglist.graytips.special.emojireply.GuildEmojiReplyGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.special.emojireply.b;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EmojiReplyElement;
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
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0002;<B\u000f\u0012\u0006\u0010)\u001a\u00020\u0014\u00a2\u0006\u0004\b8\u00109J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0017J&\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c0\"H\u0016R\u0017\u0010)\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "", "payloads", "", "m1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", ICustomDataEditor.NUMBER_PARAM_1, "", "nickName", "tailText", "p1", "", "serverId", "emojiType", "Landroid/graphics/drawable/Drawable;", "l1", "Landroid/view/View;", "d1", "bindData", "Lkotlin/Function0;", "function", "o1", "position", "b1", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "e1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "i", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/EmojiReplyElement;", "currentElement", "Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsComponent$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "k1", "()Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsComponent$a;", "binding", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildEmojiReplyGrayTipsComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EmojiReplyElement currentElement;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsComponent$a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "d", "()Landroid/view/ViewGroup;", h.F, "(Landroid/view/ViewGroup;)V", "root", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "g", "(Landroid/widget/TextView;)V", "grayTipsTextTail", "f", "grayTipsNickName", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "e", "(Landroid/widget/ImageView;)V", "grayTipsIcon", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public ViewGroup root;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsTextTail;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public TextView grayTipsNickName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public ImageView grayTipsIcon;

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
        public final TextView c() {
            TextView textView = this.grayTipsTextTail;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("grayTipsTextTail");
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

        public final void g(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.grayTipsTextTail = textView;
        }

        public final void h(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.root = viewGroup;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/aio/msglist/graytips/special/emojireply/GuildEmojiReplyGrayTipsComponent$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            GuildEmojiReplyGrayTipsComponent guildEmojiReplyGrayTipsComponent = GuildEmojiReplyGrayTipsComponent.this;
            EmojiReplyElement emojiReplyElement = guildEmojiReplyGrayTipsComponent.currentElement;
            if (emojiReplyElement == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentElement");
                emojiReplyElement = null;
            }
            guildEmojiReplyGrayTipsComponent.sendIntent(new b.a(emojiReplyElement));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ds5.linkColor);
            ds5.setUnderlineText(false);
        }
    }

    public GuildEmojiReplyGrayTipsComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.guild.aio.msglist.graytips.special.emojireply.GuildEmojiReplyGrayTipsComponent$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildEmojiReplyGrayTipsComponent.a invoke() {
                GuildEmojiReplyGrayTipsComponent.a aVar = new GuildEmojiReplyGrayTipsComponent.a();
                a aVar2 = new a(GuildEmojiReplyGrayTipsComponent.this.getRoot().getContext());
                ViewGroup b16 = aVar2.b();
                Intrinsics.checkNotNullExpressionValue(b16, "view.root");
                aVar.h(b16);
                TextView textView = aVar2.f111393e;
                Intrinsics.checkNotNullExpressionValue(textView, "view.grayTipsTextTail");
                aVar.g(textView);
                TextView textView2 = aVar2.f111392d;
                Intrinsics.checkNotNullExpressionValue(textView2, "view.grayTipsNickName");
                aVar.f(textView2);
                ImageView imageView = aVar2.f111391c;
                Intrinsics.checkNotNullExpressionValue(imageView, "view.grayTipsIcon");
                aVar.e(imageView);
                return aVar;
            }
        });
        this.binding = lazy;
    }

    private final a k1() {
        return (a) this.binding.getValue();
    }

    private final Drawable l1(int serverId, int emojiType) {
        int b16 = ReactionUtilsKt.b(serverId, emojiType);
        if (b16 < 0) {
            return null;
        }
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        return IGuildEmojiApi.a.b((IGuildEmojiApi) api, b16, emojiType, false, 4, null);
    }

    private final boolean m1(List<Object> payloads) {
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
    public final void n1(com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(8);
        if (firstTypeElement != null) {
            this.currentMsgItem = guildMsgItem;
            GrayTipElement grayTipElement = firstTypeElement.grayTipElement;
            if (grayTipElement != null) {
                Intrinsics.checkNotNullExpressionValue(grayTipElement, "grayTipElement");
                EmojiReplyElement emojiReplyElement = grayTipElement.emojiReplyElement;
                if (emojiReplyElement != null) {
                    Intrinsics.checkNotNullExpressionValue(emojiReplyElement, "emojiReplyElement");
                    this.currentElement = emojiReplyElement;
                    sendIntent(new b.C1197b(emojiReplyElement));
                }
            }
        }
    }

    private final void p1(CharSequence nickName, CharSequence tailText) {
        Drawable drawable;
        EmojiReplyElement emojiReplyElement = this.currentElement;
        if (emojiReplyElement == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentElement");
            emojiReplyElement = null;
        }
        int i3 = emojiReplyElement.emojiId;
        EmojiReplyElement emojiReplyElement2 = this.currentElement;
        if (emojiReplyElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentElement");
            emojiReplyElement2 = null;
        }
        Drawable l16 = l1(i3, emojiReplyElement2.emojiType);
        if (l16 != null && (drawable = l16.mutate()) != null) {
            drawable.setBounds(0, 0, com.tencent.guild.aio.util.c.b(17), com.tencent.guild.aio.util.c.b(17));
        } else {
            drawable = null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tailText);
        spannableStringBuilder.setSpan(new c(), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(BaseApplication.context.getResources(), R.color.qui_common_text_link, null)), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
        if (drawable != null) {
            spannableStringBuilder.append((CharSequence) ":  ");
            spannableStringBuilder.setSpan(new VerticalCenterImageSpan(drawable, 1), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        k1().c().setMovementMethod(LinkMovementMethod.getInstance());
        k1().c().setText(spannableStringBuilder);
        k1().b().setText(nickName);
        k1().a().setImageDrawable(GuildUIUtils.f235378a.A(getMContext(), R.drawable.guild_msg_reaction_icon, R.color.qui_common_icon_secondary));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (m1(payloads)) {
            o1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.graytips.special.emojireply.GuildEmojiReplyGrayTipsComponent$bind$1
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
                    GuildEmojiReplyGrayTipsComponent.this.n1(msgItem);
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
        EmojiReplyElement emojiReplyElement = null;
        byte b16 = 0;
        byte b17 = 0;
        if (this.currentMsgItem != null && this.currentElement != null) {
            EmojiReplyElement emojiReplyElement2 = this.currentElement;
            if (emojiReplyElement2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentElement");
                emojiReplyElement2 = null;
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
            EmojiReplyElement emojiReplyElement3 = this.currentElement;
            if (emojiReplyElement3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentElement");
            } else {
                emojiReplyElement = emojiReplyElement3;
            }
            return new com.tencent.guild.aio.msglist.graytips.special.emojireply.c(emojiReplyElement2, !TextUtils.equals(str, String.valueOf(emojiReplyElement.tinyId)));
        }
        return new com.tencent.guild.aio.msglist.graytips.special.emojireply.c(b17 == true ? 1 : 0, false, 3, b16 == true ? 1 : 0);
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildEmojiReplyGrayTipsUIState.SetEmojiReplyText) {
            GuildEmojiReplyGrayTipsUIState.SetEmojiReplyText setEmojiReplyText = (GuildEmojiReplyGrayTipsUIState.SetEmojiReplyText) state;
            p1(setEmojiReplyText.getNickName(), setEmojiReplyText.getTailText());
        }
    }

    public final void o1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
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

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
