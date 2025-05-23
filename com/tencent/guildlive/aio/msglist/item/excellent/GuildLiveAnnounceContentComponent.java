package com.tencent.guildlive.aio.msglist.item.excellent;

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
import com.tencent.aio.base.mvvm.b;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.aio.util.ex.d;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
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
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J&\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e0\u001dH\u0016R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001b\u00108\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b7\u0010#\u00a8\u0006="}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/excellent/GuildLiveAnnounceContentComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Landroid/view/View;", "N1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "K1", "R1", "Landroid/content/Context;", "context", "Lgr0/a;", "M1", "L1", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "e1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Lkotlin/Lazy;", "Q1", "()I", "tvTextColor", UserInfo.SEX_FEMALE, "P1", "()Lgr0/a;", "textViewProxy", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "tv", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "iv", "I", "O1", "contentView", "<init>", "(Landroid/view/View;)V", "J", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAnnounceContentComponent extends AbsGuildLiveComponent {
    private static final int K = ViewUtils.dip2px(5.0f);
    private static final int L = ViewUtils.dip2px(8.0f);
    private static final int M = ViewUtils.dip2px(6.0f);
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

    public GuildLiveAnnounceContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.guildlive.aio.msglist.item.excellent.GuildLiveAnnounceContentComponent$tvTextColor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ContextCompat.getColor(GuildLiveAnnounceContentComponent.this.getRoot().getContext(), R.color.blb));
            }
        });
        this.tvTextColor = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<gr0.a>() { // from class: com.tencent.guildlive.aio.msglist.item.excellent.GuildLiveAnnounceContentComponent$textViewProxy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final gr0.a invoke() {
                gr0.a M1;
                GuildLiveAnnounceContentComponent guildLiveAnnounceContentComponent = GuildLiveAnnounceContentComponent.this;
                Context context = guildLiveAnnounceContentComponent.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                M1 = guildLiveAnnounceContentComponent.M1(context);
                return M1;
            }
        });
        this.textViewProxy = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guildlive.aio.msglist.item.excellent.GuildLiveAnnounceContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View N1;
                N1 = GuildLiveAnnounceContentComponent.this.N1();
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
            d16 = textBubbleContentParser.d(msgRecord, textView, arrayList, (r27 & 8) != 0 ? null : guildHighlightStyle, (r27 & 16) != 0 ? null : f1(), (r27 & 32) != 0 ? 18 : 14, false, (r27 & 128) != 0 ? false : false, (r27 & 256) != 0 ? null : new Function1<String, Boolean>() { // from class: com.tencent.guildlive.aio.msglist.item.excellent.GuildLiveAnnounceContentComponent$bindData$style$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull String it5) {
                    TextView textView3;
                    boolean x16;
                    Intrinsics.checkNotNullParameter(it5, "it");
                    GuildLiveAnnounceContentComponent guildLiveAnnounceContentComponent = GuildLiveAnnounceContentComponent.this;
                    MsgRecord msgRecord2 = msgRecord;
                    textView3 = guildLiveAnnounceContentComponent.tv;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tv");
                        textView3 = null;
                    }
                    x16 = guildLiveAnnounceContentComponent.x1(it5, msgRecord2, textView3);
                    return Boolean.valueOf(x16);
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
            textView2.setTextColor(Q1());
            return;
        }
        R1();
    }

    private final void L1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_graytext_type", 5);
        yr0.a.p(this.root, "em_aio_graytext", hashMap);
        yr0.a.n("imp", O1(), hashMap);
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
        d16.setTextColor(Q1());
        d16.setLinkTextColor(Q1());
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
        TextView d16 = P1().d();
        this.tv = d16;
        if (d16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv");
            d16 = null;
        }
        linearLayout.addView(d16);
        return linearLayout;
    }

    private final View O1() {
        return (View) this.contentView.getValue();
    }

    private final gr0.a P1() {
        return (gr0.a) this.textViewProxy.getValue();
    }

    private final int Q1() {
        return ((Number) this.tvTextColor.getValue()).intValue();
    }

    private final void R1() {
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

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
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
        return O1();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public b<ol3.b, MviUIState> createVM() {
        return new GuildLiveAnnounceContentComponentVM();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof LiveAnnounceGetRealMsgSuccess) {
            K1(((LiveAnnounceGetRealMsgSuccess) state).getMsgItem());
        } else if (state instanceof LiveAnnounceRealMsgRemoved) {
            R1();
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
