package com.tencent.guildlive.aio.msglist.item.text;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import bq0.GuildHighlightParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
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
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010(\u001a\u00020\u0010\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J&\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nJ\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\nH\u0014J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\nH\u0014J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\nH\u0014J\b\u0010#\u001a\u00020\u0016H\u0014R\u0017\u0010(\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R*\u0010.\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010)j\n\u0012\u0004\u0012\u00020*\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00108\u001a\u00020\u000e8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/text/GuildLiveTextContentComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "R1", "Landroid/widget/TextView;", "textView", "Landroid/text/SpannableStringBuilder;", "result", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "J1", "Landroid/content/Context;", "context", "Lgr0/a;", "L1", "Landroid/view/View;", "d1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "", "position", "", "", "payloads", "b1", "Q1", "", "w1", "currentMsgItem", "A1", "z1", "O1", "P1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "tempList", "Landroid/view/ViewGroup;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "M1", "()Landroid/view/ViewGroup;", "contentView", "G", "N1", "()Lgr0/a;", "contentViewCtrl", "<init>", "(Landroid/view/View;)V", "H", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildLiveTextContentComponent extends AbsGuildLiveComponent {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<MsgElement> tempList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentViewCtrl;

    public GuildLiveTextContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.guildlive.aio.msglist.item.text.GuildLiveTextContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                FrameLayout frameLayout = new FrameLayout(GuildLiveTextContentComponent.this.getRoot().getContext());
                GuildLiveTextContentComponent guildLiveTextContentComponent = GuildLiveTextContentComponent.this;
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                frameLayout.addView(guildLiveTextContentComponent.N1().d());
                return frameLayout;
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<gr0.a>() { // from class: com.tencent.guildlive.aio.msglist.item.text.GuildLiveTextContentComponent$contentViewCtrl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final gr0.a invoke() {
                gr0.a L1;
                GuildLiveTextContentComponent guildLiveTextContentComponent = GuildLiveTextContentComponent.this;
                Context context = guildLiveTextContentComponent.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                L1 = guildLiveTextContentComponent.L1(context);
                return L1;
            }
        });
        this.contentViewCtrl = lazy2;
    }

    private final void J1(TextView textView, SpannableStringBuilder result, final GuildMsgItem msgItem) {
        String str;
        com.tencent.guildlive.aio.msglist.b bVar = new com.tencent.guildlive.aio.msglist.b(textView);
        String d16 = bVar.d(msgItem);
        if (yr0.a.k(msgItem)) {
            str = bVar.b(msgItem);
        } else {
            str = "";
        }
        bVar.g(result, 0, d16, str);
        bVar.h(result, d16, O1(msgItem));
        if (!TextUtils.isEmpty(str)) {
            bVar.j(result, d16.length(), d16.length() + str.length(), O1(msgItem));
        }
        bVar.i(result, d16 + str, P1());
        N1().setNickName(d16);
        N1().setNickClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.item.text.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveTextContentComponent.K1(GuildLiveTextContentComponent.this, msgItem, view);
            }
        });
        textView.setText(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(GuildLiveTextContentComponent this$0, GuildMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.s1(this$0.root)) {
            Context mContext = this$0.getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            yr0.a.l((Activity) mContext, msgItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gr0.a L1(Context context) {
        gr0.a createGuildLiveETTextView = ((IGuildTextViewFactoryApi) QRoute.api(IGuildTextViewFactoryApi.class)).createGuildLiveETTextView(context);
        TextView d16 = createGuildLiveETTextView.d();
        d16.setMovementMethod(LinkMovementMethod.getInstance());
        ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).fixTextViewANRForAnd10(d16);
        d16.setSpannableFactory(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoSpanFactory());
        int i3 = 0;
        d16.setIncludeFontPadding(false);
        d16.setLongClickable(false);
        d16.setFocusable(false);
        d16.setLineSpacing(ViewUtils.dip2px(7.0f), 1.0f);
        d16.setTextSize(0, ViewUtils.dip2px(14.0f));
        d16.setTextColor(context.getResources().getColor(R.color.f157146bq2));
        d16.setLinkTextColor(context.getResources().getColor(R.color.bm5));
        d16.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (AppSetting.f99565y) {
            i3 = 3;
        }
        d16.setAutoLinkMask(i3);
        return createGuildLiveETTextView;
    }

    private final ViewGroup M1() {
        return (ViewGroup) this.contentView.getValue();
    }

    private final void R1(final com.tencent.aio.data.msglist.a msgItem) {
        SpannableStringBuilder d16;
        if (msgItem instanceof GuildMsgItem) {
            s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
            sendIntent(new s.GetAioContext(aioContextWrapper));
            final TextView d17 = N1().d();
            TextBubbleContentParser textBubbleContentParser = TextBubbleContentParser.f111932a;
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            MsgRecord msgRecord = guildMsgItem.getMsgRecord();
            ArrayList<MsgElement> arrayList = this.tempList;
            Intrinsics.checkNotNull(arrayList);
            GuildHighlightParams.GuildHighlightStyle guildHighlightStyle = new GuildHighlightParams.GuildHighlightStyle(0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 255, null);
            guildHighlightStyle.g(R.color.bpk);
            guildHighlightStyle.i(R.color.bpl);
            guildHighlightStyle.k(R.color.bpk);
            guildHighlightStyle.m(R.color.bpl);
            guildHighlightStyle.l(R.color.bpm);
            guildHighlightStyle.j(14.0f);
            guildHighlightStyle.h(14.0f);
            Unit unit = Unit.INSTANCE;
            d16 = textBubbleContentParser.d(msgRecord, d17, arrayList, (r27 & 8) != 0 ? null : guildHighlightStyle, (r27 & 16) != 0 ? null : aioContextWrapper.getContext(), (r27 & 32) != 0 ? 18 : 14, false, (r27 & 128) != 0 ? false : false, (r27 & 256) != 0 ? null : new Function1<String, Boolean>() { // from class: com.tencent.guildlive.aio.msglist.item.text.GuildLiveTextContentComponent$updateContentText$style$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull String it) {
                    boolean x16;
                    Intrinsics.checkNotNullParameter(it, "it");
                    x16 = GuildLiveTextContentComponent.this.x1(it, ((GuildMsgItem) msgItem).getMsgRecord(), d17);
                    return Boolean.valueOf(x16);
                }
            }, (r27 & 512) != 0 ? false : true, (r27 & 1024) != 0 ? false : false);
            d17.setText(d16);
            Q1(guildMsgItem);
            J1(d17, d16, guildMsgItem);
            return;
        }
        N1().setNickClickListener(null);
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent
    protected void A1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        R1(currentMsgItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final gr0.a N1() {
        return (gr0.a) this.contentViewCtrl.getValue();
    }

    protected int O1(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        int h16 = h.f112401a.h(msgItem, 4278190080L);
        if (h16 != -1 && h16 != -16777216) {
            return h16;
        }
        return P1();
    }

    protected int P1() {
        return getMContext().getResources().getColor(R.color.bpx);
    }

    public final void Q1(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        rs0.b.f432141a.setValue(msgItem);
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        List filterNotNull;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            ArrayList<MsgElement> arrayList = new ArrayList<>();
            ArrayList<MsgElement> elements = ((GuildMsgItem) msgItem).getMsgRecord().elements;
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
            this.tempList = arrayList;
            if (arrayList.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            R1(msgItem);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return M1();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new b();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent
    protected boolean w1() {
        return true;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent
    protected void z1(@NotNull GuildMsgItem currentMsgItem) {
        Intrinsics.checkNotNullParameter(currentMsgItem, "currentMsgItem");
        R1(currentMsgItem);
    }
}
