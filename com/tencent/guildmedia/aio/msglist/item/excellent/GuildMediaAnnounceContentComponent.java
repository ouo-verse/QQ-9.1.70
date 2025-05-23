package com.tencent.guildmedia.aio.msglist.item.excellent;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bq0.GuildHighlightParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.aio.util.ex.d;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J&\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u00107\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b6\u0010\"\u00a8\u0006<"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/excellent/GuildMediaAnnounceContentComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "Landroid/view/View;", "N1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "K1", "S1", "Landroid/content/Context;", "context", "Lgr0/a;", "M1", "L1", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/guildmedia/aio/msglist/item/excellent/GuildMediaAnnounceContentComponentVM;", "O1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Lkotlin/Lazy;", "R1", "()I", "tvTextColor", UserInfo.SEX_FEMALE, "Q1", "()Lgr0/a;", "textViewProxy", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "tv", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "iv", "I", "P1", "contentView", "<init>", "(Landroid/view/View;)V", "J", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAnnounceContentComponent extends com.tencent.guildmedia.aio.msglist.holder.component.a {
    private static final int K = ViewUtils.dip2px(5.0f);
    private static final int L = ViewUtils.dip2px(8.0f);
    private static final int M = ViewUtils.dip2px(7.0f);
    private static final int N = ViewUtils.dip2px(20.0f);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvTextColor;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy textViewProxy;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tv;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView iv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public GuildMediaAnnounceContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.guildmedia.aio.msglist.item.excellent.GuildMediaAnnounceContentComponent$tvTextColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.getColor(GuildMediaAnnounceContentComponent.this.getRoot().getContext(), R.color.blb));
            }
        });
        this.tvTextColor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<gr0.a>() { // from class: com.tencent.guildmedia.aio.msglist.item.excellent.GuildMediaAnnounceContentComponent$textViewProxy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final gr0.a invoke() {
                gr0.a M1;
                GuildMediaAnnounceContentComponent guildMediaAnnounceContentComponent = GuildMediaAnnounceContentComponent.this;
                Context context = guildMediaAnnounceContentComponent.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                M1 = guildMediaAnnounceContentComponent.M1(context);
                return M1;
            }
        });
        this.textViewProxy = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guildmedia.aio.msglist.item.excellent.GuildMediaAnnounceContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View N1;
                N1 = GuildMediaAnnounceContentComponent.this.N1();
                return N1;
            }
        });
        this.contentView = lazy3;
    }

    private final void K1(final MsgRecord msgRecord) {
        SpannableStringBuilder d16;
        List filterNotNull;
        if (!d.b(msgRecord) && !d.a(msgRecord)) {
            ArrayList arrayList = new ArrayList();
            ArrayList<MsgElement> elements = msgRecord.elements;
            if (elements != null) {
                Intrinsics.checkNotNullExpressionValue(elements, "elements");
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
                if (filterNotNull != null) {
                    Iterator it = filterNotNull.iterator();
                    while (it.hasNext()) {
                        arrayList.add((MsgElement) it.next());
                    }
                }
            }
            TextBubbleContentParser textBubbleContentParser = TextBubbleContentParser.f111932a;
            TextView textView = this.tv;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tv");
                textView = null;
            }
            GuildHighlightParams.GuildHighlightStyle guildHighlightStyle = new GuildHighlightParams.GuildHighlightStyle(0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 255, null);
            guildHighlightStyle.g(R.color.bpk);
            guildHighlightStyle.i(R.color.blb);
            guildHighlightStyle.k(R.color.bpk);
            guildHighlightStyle.m(R.color.blb);
            guildHighlightStyle.l(R.color.bpm);
            guildHighlightStyle.j(14.0f);
            guildHighlightStyle.h(14.0f);
            Unit unit = Unit.INSTANCE;
            d16 = textBubbleContentParser.d(msgRecord, textView, arrayList, (r27 & 8) != 0 ? null : guildHighlightStyle, (r27 & 16) != 0 ? null : f1(), (r27 & 32) != 0 ? 18 : 14, false, (r27 & 128) != 0 ? false : false, (r27 & 256) != 0 ? null : new Function1<String, Boolean>() { // from class: com.tencent.guildmedia.aio.msglist.item.excellent.GuildMediaAnnounceContentComponent$bindData$style$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull String it5) {
                    TextView textView3;
                    Intrinsics.checkNotNullParameter(it5, "it");
                    GuildMediaAnnounceContentComponent guildMediaAnnounceContentComponent = GuildMediaAnnounceContentComponent.this;
                    MsgRecord msgRecord2 = msgRecord;
                    textView3 = guildMediaAnnounceContentComponent.tv;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tv");
                        textView3 = null;
                    }
                    return Boolean.valueOf(guildMediaAnnounceContentComponent.x1(it5, msgRecord2, textView3));
                }
            }, (r27 & 512) != 0 ? false : true, (r27 & 1024) != 0 ? false : false);
            d16.insert(0, (CharSequence) "\u516c\u544a: ");
            TextView textView3 = this.tv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tv");
                textView3 = null;
            }
            textView3.setText(d16);
            TextView textView4 = this.tv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tv");
            } else {
                textView2 = textView4;
            }
            textView2.setTextColor(R1());
            return;
        }
        S1();
    }

    private final void L1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_graytext_type", 5);
        vs0.a.n(this.root, "em_aio_graytext", hashMap);
        vs0.a.l("imp", P1(), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gr0.a M1(Context context) {
        int i3;
        gr0.a createGuildLiveETTextView = ((IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class)).createGuildLiveETTextView(context);
        TextView d16 = createGuildLiveETTextView.d();
        d16.setMovementMethod(LinkMovementMethod.getInstance());
        ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).fixTextViewANRForAnd10(d16);
        d16.setSpannableFactory(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoSpanFactory());
        d16.setIncludeFontPadding(false);
        d16.setLongClickable(false);
        d16.setFocusable(false);
        d16.setLineSpacing(ViewUtils.dip2px(7.0f), 1.0f);
        d16.setTextColor(R1());
        d16.setLinkTextColor(R1());
        d16.setTextSize(14.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        d16.setLayoutParams(layoutParams);
        if (AppSetting.f99565y) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        d16.setAutoLinkMask(i3);
        d16.setPadding(K, 0, 0, 0);
        return createGuildLiveETTextView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View N1() {
        LinearLayout linearLayout = new LinearLayout(this.root.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        int i3 = K;
        int i16 = M;
        linearLayout.setPadding(i3, i16, L, i16);
        linearLayout.setOrientation(0);
        ImageView imageView = new ImageView(this.root.getContext());
        int i17 = N;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(i17, i17));
        imageView.setImageResource(R.drawable.guild_aio_channel_announce_msg_icon);
        this.iv = imageView;
        linearLayout.addView(imageView);
        TextView d16 = Q1().d();
        this.tv = d16;
        if (d16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv");
            d16 = null;
        }
        linearLayout.addView(d16);
        return linearLayout;
    }

    private final View P1() {
        return (View) this.contentView.getValue();
    }

    private final gr0.a Q1() {
        return (gr0.a) this.textViewProxy.getValue();
    }

    private final int R1() {
        return ((Number) this.tvTextColor.getValue()).intValue();
    }

    private final void S1() {
        TextView textView = this.tv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv");
            textView = null;
        }
        textView.setText("\u516c\u544a\u5df2\u79fb\u9664");
        TextView textView3 = this.tv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv");
            textView3 = null;
        }
        TextView textView4 = this.tv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv");
        } else {
            textView2 = textView4;
        }
        textView3.setTextColor(textView2.getResources().getColor(R.color.bpx));
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public GuildMediaAnnounceContentComponentVM createVM() {
        return new GuildMediaAnnounceContentComponentVM();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        EssenceElement essenceElement;
        GrayTipElement grayTipElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (msgItem instanceof GuildMsgItem) {
            MsgElement firstTypeElement = ((GuildMsgItem) msgItem).getFirstTypeElement(8);
            if (firstTypeElement != null && (grayTipElement = firstTypeElement.grayTipElement) != null) {
                essenceElement = grayTipElement.essenceElement;
            } else {
                essenceElement = null;
            }
            if (essenceElement == null) {
                return;
            } else {
                sendIntent(new LiveAnnounceContentGetRealMsg(essenceElement.msgSeq));
            }
        }
        L1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return P1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof LiveAnnounceGetRealMsgSuccess) {
            K1(((LiveAnnounceGetRealMsgSuccess) state).getMsgItem());
        } else if (state instanceof LiveAnnounceRealMsgRemoved) {
            S1();
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
