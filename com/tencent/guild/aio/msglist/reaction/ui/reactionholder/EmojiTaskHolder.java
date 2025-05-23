package com.tencent.guild.aio.msglist.reaction.ui.reactionholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.msglist.reaction.details.GuildEmojiDetailsDialog;
import com.tencent.guild.aio.msglist.reaction.ui.EmojiUpdateTextView;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.aio.util.ex.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import gq0.EmojiTaskItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0010H\u0016R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\n \u0014*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/EmojiTaskHolder;", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/BaseReactionHolder;", "Lgq0/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "v", "emojiItem", "u", "", "isAttachToHostMsgItem", "w", "Lgq0/d;", "", "", "payloads", "o", "Landroid/view/View;", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/ImageView;", "emojiImage", "Lcom/tencent/guild/aio/msglist/reaction/ui/EmojiUpdateTextView;", "I", "Lcom/tencent/guild/aio/msglist/reaction/ui/EmojiUpdateTextView;", "emojiCntView", "itemView", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;)V", "J", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class EmojiTaskHolder extends BaseReactionHolder {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private final ImageView emojiImage;

    /* renamed from: I, reason: from kotlin metadata */
    private final EmojiUpdateTextView emojiCntView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/EmojiTaskHolder$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "MIN_WIDTH", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.reaction.ui.reactionholder.EmojiTaskHolder$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setId(R.id.vxb);
            imageView.setFocusable(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(x.a(20.0f), x.a(20.0f));
            layoutParams.leftMargin = x.a(5.0f);
            layoutParams.rightMargin = x.a(6.0f);
            layoutParams.gravity = 16;
            imageView.setLayoutParams(layoutParams);
            EmojiUpdateTextView emojiUpdateTextView = new EmojiUpdateTextView(context);
            emojiUpdateTextView.setId(R.id.vx9);
            emojiUpdateTextView.setClickable(false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = x.a(9.0f);
            layoutParams2.gravity = 16;
            emojiUpdateTextView.setLayoutParams(layoutParams2);
            ColorStateList colorStateList = context.getColorStateList(R.color.qui_common_text_secondary);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateLis\u2026ui_common_text_secondary)");
            ColorStateList colorStateList2 = context.getColorStateList(R.color.qui_button_bg_primary_default);
            Intrinsics.checkNotNullExpressionValue(colorStateList2, "context.getColorStateLis\u2026utton_bg_primary_default)");
            emojiUpdateTextView.l(colorStateList, colorStateList2);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setMinimumWidth(x.a(42.0f));
            linearLayout.addView(imageView);
            linearLayout.addView(emojiUpdateTextView);
            return linearLayout;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiTaskHolder(@NotNull View itemView, @NotNull d adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.emojiImage = (ImageView) itemView.findViewById(R.id.vxb);
        this.emojiCntView = (EmojiUpdateTextView) itemView.findViewById(R.id.vx9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(EmojiTaskItem emojiItem) {
        boolean z16;
        EmojiUpdateTextView emojiUpdateTextView = this.emojiCntView;
        if (emojiItem.getEmojiLikeCnt() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        emojiUpdateTextView.setVisibility(0);
        if (((View) g.a(valueOf, emojiUpdateTextView)) == null) {
            emojiUpdateTextView.setVisibility(8);
        }
        this.emojiCntView.setChecked(emojiItem.getEmojiIsClicked());
        this.emojiCntView.setTextWithAnim(ReactionUtilsKt.j(emojiItem.getEmojiLikeCnt()), emojiItem.getEmojiIsClicked());
        ImageView imageView = this.emojiImage;
        imageView.startAnimation(AnimationUtils.loadAnimation(imageView.getContext(), R.anim.f154618oq));
        w(MsgExtKt.S(emojiItem.g()));
    }

    private final void v(EmojiTaskItem item) {
        boolean z16;
        EmojiUpdateTextView emojiUpdateTextView = this.emojiCntView;
        if (item.getEmojiLikeCnt() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        emojiUpdateTextView.setVisibility(0);
        if (((View) g.a(valueOf, emojiUpdateTextView)) == null) {
            emojiUpdateTextView.setVisibility(8);
        }
        this.emojiCntView.setText(ReactionUtilsKt.j(item.getEmojiLikeCnt()));
        this.emojiCntView.setChecked(item.getEmojiIsClicked());
        this.emojiImage.setImageDrawable(ReactionUtilsKt.d(item.getEmojiLocalId(), item.getEmojiType()));
        w(MsgExtKt.S(item.g()));
    }

    private final void w(boolean isAttachToHostMsgItem) {
        Drawable mutate;
        View view = this.itemView;
        if (!this.emojiCntView.getIsChecked()) {
            Resources resources = this.itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "itemView.resources");
            mutate = ReactionUtilsKt.e(resources, isAttachToHostMsgItem);
        } else {
            Drawable drawable = ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.guild_aio_emoji_bg_blue);
            Intrinsics.checkNotNull(drawable);
            mutate = drawable.mutate();
        }
        view.setBackground(mutate);
    }

    @Override // com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder
    protected void o(@NotNull gq0.d item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        EmojiTaskItem emojiTaskItem = (EmojiTaskItem) item;
        if (payloads.contains(BaseReactionHolder.PayloadType.ITEM_BG_REFRESH_PAYLOAD)) {
            w(MsgExtKt.S(emojiTaskItem.g()));
        } else {
            v(emojiTaskItem);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(v3.getContext(), R.string.f1511016s, 0).show();
        } else {
            gq0.d q16 = q();
            Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type com.tencent.guild.aio.msglist.reaction.data.EmojiTaskItem");
            final EmojiTaskItem emojiTaskItem = (EmojiTaskItem) q16;
            getAdapter().x(emojiTaskItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.reaction.ui.reactionholder.EmojiTaskHolder$onClick$1
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
                    EmojiTaskHolder.this.u(emojiTaskItem);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder, android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        gq0.d q16 = q();
        Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type com.tencent.guild.aio.msglist.reaction.data.EmojiTaskItem");
        EmojiTaskItem emojiTaskItem = (EmojiTaskItem) q16;
        boolean z16 = true;
        if (emojiTaskItem.getEmojiLikeCnt() != 0) {
            MsgRecord msg2 = q().getMsg();
            int i3 = 0;
            if (msg2 == null) {
                z16 = false;
            } else {
                ArrayList arrayList = new ArrayList();
                ArrayList<MsgEmojiLikes> arrayList2 = msg2.emojiLikesList;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "msg.emojiLikesList");
                int i16 = 0;
                for (Object obj : arrayList2) {
                    int i17 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    MsgEmojiLikes msgEmojiLikes = (MsgEmojiLikes) obj;
                    Intrinsics.checkNotNullExpressionValue(msgEmojiLikes, "msgEmojiLikes");
                    if (emojiTaskItem.m(msgEmojiLikes)) {
                        i16 = i3;
                    }
                    GuildEmojiDetailsData.b bVar = new GuildEmojiDetailsData.b();
                    bVar.f216402c = (int) msgEmojiLikes.likesCnt;
                    bVar.f216400a = ReactionUtilsKt.i(msgEmojiLikes);
                    bVar.f216401b = (int) msgEmojiLikes.emojiType;
                    arrayList.add(bVar);
                    i3 = i17;
                }
                GuildEmojiDetailsDialog.Companion companion = GuildEmojiDetailsDialog.INSTANCE;
                Context context = v3.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                companion.a((FragmentActivity) context, new GuildEmojiDetailsData(msg2.guildId, msg2.channelId, msg2.msgSeq, i16, arrayList), msg2);
            }
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }
}
