package i72;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.aio.utils.l;
import j72.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0016H\u0016\u00a8\u0006 "}, d2 = {"Li72/c;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "", "emojiId", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Li72/j;", "holder", "", "r", "Landroid/content/res/ColorStateList;", "normalColor", "pressColor", "Landroid/graphics/drawable/StateListDrawable;", "p", "Landroid/graphics/drawable/Drawable;", "t", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "f", "e", tl.h.F, "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b {
    private final void r(final j holder) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: i72.a
            @Override // java.lang.Runnable
            public final void run() {
                c.s(j.this, this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(j holder, c this$0) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (holder.getAttachedToWindow()) {
            Map<String, String> q16 = this$0.q(holder.getEmojiId());
            IAssistedChatApi iAssistedChatApi = (IAssistedChatApi) QRoute.api(IAssistedChatApi.class);
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            iAssistedChatApi.reportImpEvent("em_kl_emoji_icon", view, q16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(LinearLayout this_apply, Map reportParam, c this$0, QQStrangerQuickEmojiModel quickEmojiModel, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(reportParam, "$reportParam");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(quickEmojiModel, "$quickEmojiModel");
        if (FastClickUtils.isFastDoubleClick("QQStrangerPinnedQuickEmojiAdapter")) {
            return;
        }
        ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).reportClickEvent("em_kl_emoji_icon", this_apply, reportParam);
        this$0.k(new a.OnClickItemIntent(quickEmojiModel));
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int b() {
        return 2;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int c() {
        return 8;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void e(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.e(holder);
        if (holder instanceof j) {
            j jVar = (j) holder;
            jVar.p(true);
            r(jVar);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void f(RecyclerView.ViewHolder holder, com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(model, "model");
        if (holder instanceof j) {
            Object a16 = model.a();
            final QQStrangerQuickEmojiModel qQStrangerQuickEmojiModel = a16 instanceof QQStrangerQuickEmojiModel ? (QQStrangerQuickEmojiModel) a16 : null;
            if (qQStrangerQuickEmojiModel == null) {
                return;
            }
            j jVar = (j) holder;
            jVar.q(qQStrangerQuickEmojiModel.getEmojiId());
            c51.c binding = jVar.getBinding();
            binding.f30345b.setImageDrawable(t(qQStrangerQuickEmojiModel.getEmojiId()));
            binding.f30347d.setText(qQStrangerQuickEmojiModel.getDesc());
            final LinearLayout root = binding.getRoot();
            final Map<String, String> q16 = q(qQStrangerQuickEmojiModel.getEmojiId());
            root.setBackground(p(ContextCompat.getColorStateList(holder.itemView.getContext(), R.color.qui_common_fill_light_secondary), ContextCompat.getColorStateList(holder.itemView.getContext(), R.color.qui_common_overlay_standard_primary)));
            root.setOnClickListener(new View.OnClickListener() { // from class: i72.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.u(root, q16, this, qQStrangerQuickEmojiModel, view);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public RecyclerView.ViewHolder g(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c51.c g16 = c51.c.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026      false\n            )");
        return new j(g16);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void h(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof j) {
            ((j) holder).p(false);
        }
    }

    private final Map<String, String> q(int emojiId) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("kl_type_id", "0"), TuplesKt.to("kl_emoji_id", String.valueOf(emojiId)));
        return mapOf;
    }

    private final StateListDrawable p(ColorStateList normalColor, ColorStateList pressColor) {
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

    private final Drawable t(int emojiId) {
        if (emojiId >= 0) {
            return QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.convertToLocal(emojiId));
        }
        return null;
    }
}
