package com.tencent.guildmedia.aio.excellentdetail.msglist;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import bq0.GuildHighlightParams;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u00a2\u0006\u0004\b(\u0010)J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nH\u0002J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0017\u0010\u001e\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/guildmedia/aio/excellentdetail/msglist/GuildMediaAnnounceBubbleContentComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "Lcom/tencent/aio/data/msglist/a;", "bindData", "Lkotlin/Function0;", "", "function", "O1", "msgItem", "N1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "P1", "", "position", "", "", "payloads", "b1", "Lcom/tencent/guild/aio/component/combinestyle/GuildMediaItemBaseVM;", "L1", "Landroid/widget/LinearLayout;", "K1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Landroid/widget/LinearLayout;", "contentView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "M1", "()Landroid/widget/TextView;", "tv", "<init>", "(Landroid/view/View;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAnnounceBubbleContentComponent extends com.tencent.guildmedia.aio.msglist.holder.component.a {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout contentView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy tv;

    public GuildMediaAnnounceBubbleContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        LinearLayout linearLayout = new LinearLayout(root.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.contentView = linearLayout;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guildmedia.aio.excellentdetail.msglist.GuildMediaAnnounceBubbleContentComponent$tv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
                Context context = GuildMediaAnnounceBubbleContentComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                return bubbleTextViewUtil.c(context);
            }
        });
        this.tv = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView M1() {
        return (TextView) this.tv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1(com.tencent.aio.data.msglist.a msgItem) {
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            B1(guildMsgItem);
            P1(guildMsgItem);
        }
    }

    private final void O1(com.tencent.aio.data.msglist.a bindData, Function0<Unit> function) {
        if (getCurrentMsgItem() == null) {
            function.invoke();
            return;
        }
        GuildMsgItem currentMsgItem = getCurrentMsgItem();
        Intrinsics.checkNotNull(currentMsgItem);
        if (currentMsgItem.isSameItem(bindData)) {
            GuildMsgItem currentMsgItem2 = getCurrentMsgItem();
            Intrinsics.checkNotNull(currentMsgItem2);
            if (currentMsgItem2.isSameContent(bindData)) {
                return;
            }
        }
        function.invoke();
    }

    private final void P1(final GuildMsgItem msgItem) {
        SpannableStringBuilder d16;
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        ArrayList arrayList2 = new ArrayList();
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement element = it.next();
            IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
            Intrinsics.checkNotNullExpressionValue(element, "element");
            if (iGuildMsgElementApi.isTextElem(element)) {
                arrayList2.add(element);
            }
        }
        if (arrayList2.size() <= 0) {
            return;
        }
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        TextBubbleContentParser textBubbleContentParser = TextBubbleContentParser.f111932a;
        MsgRecord msgRecord = msgItem.getMsgRecord();
        TextView M1 = M1();
        GuildHighlightParams.GuildHighlightStyle guildHighlightStyle = new GuildHighlightParams.GuildHighlightStyle(0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 255, null);
        guildHighlightStyle.g(R.color.bpk);
        guildHighlightStyle.i(R.color.bpl);
        guildHighlightStyle.k(R.color.bpk);
        guildHighlightStyle.m(R.color.bpl);
        guildHighlightStyle.l(R.color.bpm);
        guildHighlightStyle.j(17.0f);
        guildHighlightStyle.h(17.0f);
        d16 = textBubbleContentParser.d(msgRecord, M1, arrayList2, (r27 & 8) != 0 ? null : guildHighlightStyle, (r27 & 16) != 0 ? null : aioContextWrapper.getContext(), (r27 & 32) != 0 ? 18 : 0, false, (r27 & 128) != 0 ? false : false, (r27 & 256) != 0 ? null : new Function1<String, Boolean>() { // from class: com.tencent.guildmedia.aio.excellentdetail.msglist.GuildMediaAnnounceBubbleContentComponent$updateTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull String it5) {
                TextView M12;
                Intrinsics.checkNotNullParameter(it5, "it");
                GuildMediaAnnounceBubbleContentComponent guildMediaAnnounceBubbleContentComponent = GuildMediaAnnounceBubbleContentComponent.this;
                MsgRecord msgRecord2 = msgItem.getMsgRecord();
                M12 = GuildMediaAnnounceBubbleContentComponent.this.M1();
                return Boolean.valueOf(guildMediaAnnounceBubbleContentComponent.x1(it5, msgRecord2, M12));
            }
        }, (r27 & 512) != 0 ? false : false, (r27 & 1024) != 0 ? false : true);
        M1().setText(d16);
        this.contentView.addView(M1());
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: K1, reason: from getter and merged with bridge method [inline-methods] */
    public LinearLayout d1() {
        return this.contentView;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public GuildMediaItemBaseVM createVM() {
        return new GuildMediaItemBaseVM();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        O1(msgItem, new Function0<Unit>() { // from class: com.tencent.guildmedia.aio.excellentdetail.msglist.GuildMediaAnnounceBubbleContentComponent$bind$1
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
                LinearLayout linearLayout;
                LinearLayout linearLayout2;
                linearLayout = GuildMediaAnnounceBubbleContentComponent.this.contentView;
                if (linearLayout.getChildCount() > 0) {
                    linearLayout2 = GuildMediaAnnounceBubbleContentComponent.this.contentView;
                    linearLayout2.removeAllViews();
                }
                GuildMediaAnnounceBubbleContentComponent.this.N1(msgItem);
            }
        });
        View findViewById = this.root.findViewById(R.id.f164907u83);
        if (msgItem.isSelf()) {
            findViewById.setBackgroundResource(R.drawable.guild_live_channel_announce_self_aio_item_bg);
        } else {
            findViewById.setBackgroundResource(R.drawable.guild_live_channel_announce_aio_item_bg);
        }
        M1().setTextColor(M1().getResources().getColor(R.color.f157146bq2));
        M1().setLinkTextColor(M1().getResources().getColor(R.color.bm5));
    }

    @NotNull
    public final View getRoot() {
        return this.root;
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
