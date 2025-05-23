package n82;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.stranger.liteaction.QQStrangerLIAMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.QQStrangerLIAClickHandlerProvider;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.aio.utils.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Ln82/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "", "", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/res/ColorStateList;", "normalColor", "pressColor", "Landroid/graphics/drawable/StateListDrawable;", "o", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "E", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "adapter", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "msg", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "itemBg", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;)V", "I", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b adapter;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView icon;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView msg;

    /* renamed from: H, reason: from kotlin metadata */
    private final LinearLayout itemBg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View itemView, com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b adapter) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        View findViewById = itemView.findViewById(R.id.oiu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.bottom_section_bar_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.oiw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.bottom_section_bar_msg)");
        this.msg = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.oiv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026ttom_section_bar_item_bg)");
        this.itemBg = (LinearLayout) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QQStrangerLIAItem actionItem, d this$0, View view) {
        Intrinsics.checkNotNullParameter(actionItem, "$actionItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.a a16 = QQStrangerLIAClickHandlerProvider.f245123a.a(actionItem.getType());
        if (a16 != null) {
            a16.a(actionItem, e.e(actionItem));
        }
        this$0.adapter.j(QQStrangerLIAMsgIntent.RefreshQQStrangerBottomLIAMsgIntent.f69914d);
        IAssistedChatApi iAssistedChatApi = (IAssistedChatApi) QRoute.api(IAssistedChatApi.class);
        View itemView = this$0.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        iAssistedChatApi.reportClickEvent("em_kl_emoji_icon", itemView, this$0.p(actionItem));
    }

    private final void q() {
        this.itemBg.setBackground(o(ContextCompat.getColorStateList(this.itemView.getContext(), R.color.qui_common_fill_light_secondary), ContextCompat.getColorStateList(this.itemView.getContext(), R.color.qui_common_overlay_standard_primary)));
    }

    public final void m(com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.a() instanceof QQStrangerLIAItem) {
            Object a16 = model.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem");
            final QQStrangerLIAItem qQStrangerLIAItem = (QQStrangerLIAItem) a16;
            Drawable c16 = e.c(qQStrangerLIAItem.getResource());
            this.icon.setImageDrawable(c16);
            ImageView imageView = this.icon;
            Boolean valueOf = Boolean.valueOf(c16 != null);
            imageView.setVisibility(0);
            if (((View) au.a(valueOf, imageView)) == null) {
                imageView.setVisibility(8);
            }
            this.msg.setText(qQStrangerLIAItem.getResource().getLabel());
            TextView textView = this.msg;
            Boolean valueOf2 = Boolean.valueOf(qQStrangerLIAItem.getResource().getLabel().length() > 0);
            textView.setVisibility(0);
            if (((View) au.a(valueOf2, textView)) == null) {
                textView.setVisibility(8);
            }
            q();
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: n82.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.n(QQStrangerLIAItem.this, this, view);
                }
            });
            IAssistedChatApi iAssistedChatApi = (IAssistedChatApi) QRoute.api(IAssistedChatApi.class);
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            iAssistedChatApi.reportImpEvent("em_kl_emoji_icon", itemView, p(qQStrangerLIAItem));
        }
    }

    private final Map<String, String> p(QQStrangerLIAItem qQStrangerLIAItem) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("kl_type_id", String.valueOf(qQStrangerLIAItem.getType())), TuplesKt.to("kl_emoji_id", String.valueOf(qQStrangerLIAItem.getResource().getEmojiId())));
        return mapOf;
    }

    private final StateListDrawable o(ColorStateList normalColor, ColorStateList pressColor) {
        float b16 = l.b(8);
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        gradientDrawable.setColor(pressColor);
        gradientDrawable.setCornerRadius(b16);
        gradientDrawable2.setColor(pressColor);
        gradientDrawable2.setCornerRadius(b16);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(normalColor);
        gradientDrawable3.setCornerRadius(b16);
        stateListDrawable.addState(new int[0], gradientDrawable3);
        return stateListDrawable;
    }
}
