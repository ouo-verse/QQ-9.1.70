package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.HorizontalGuildData;
import com.tencent.mobileqq.guild.discoveryv2.content.view.DiscoveryV2RootView;
import com.tencent.mobileqq.guild.discoveryv2.content.view.GradientImageView;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/u;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/RecommendGuildSection;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/HorizontalGuildData;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", "Z", "data", "", "position", "", "", "payload", "u0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "label", "isAllSimpleLabel", "isSecondly", "K", "Landroid/widget/TextView;", "Y", "Landroid/widget/TextView;", "mIntro", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u extends RecommendGuildSection<HorizontalGuildData> {

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView mIntro;

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection
    public void K(@NotNull IGProGuildLabel label, boolean isAllSimpleLabel, boolean isSecondly) {
        Intrinsics.checkNotNullParameter(label, "label");
        Context context = getRootView().getContext();
        if (isSecondly) {
            LinearLayout M = M();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            M.addView(ci1.b.c(context));
        }
        LinearLayout M2 = M();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        byte[] labelName = label.getLabelName();
        Intrinsics.checkNotNullExpressionValue(labelName, "label.labelName");
        String str = new String(labelName, Charsets.UTF_8);
        String colorToken = label.getColorToken();
        Intrinsics.checkNotNullExpressionValue(colorToken, "label.colorToken");
        M2.addView(ci1.b.b(context, str, colorToken));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection
    public boolean Z() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection, com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        r0(containerView);
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        View view = this.mRootView;
        view.setLayoutParams(view.getLayoutParams());
        ((DiscoveryV2RootView) containerView.findViewById(R.id.w66)).setRadius(com.tencent.guild.aio.util.c.b(12));
        View findViewById = containerView.findViewById(R.id.w5z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026recommend_contact_avatar)");
        o0((ImageView) findViewById);
        View findViewById2 = containerView.findViewById(R.id.f165473w63);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u20262_recommend_contact_nick)");
        s0((TextView) findViewById2);
        R().setTextColor(RecommendGuildSection.INSTANCE.a());
        View findViewById3 = containerView.findViewById(R.id.f165472w62);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u20262_recommend_contact_join)");
        q0((QUIButton) findViewById3);
        View findViewById4 = containerView.findViewById(R.id.w6t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026recommend_tags_container)");
        n0((LinearLayout) findViewById4);
        View findViewById5 = containerView.findViewById(R.id.w6k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026v2_recommend_guild_intro)");
        this.mIntro = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f165470w60);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026_v2_recommend_contact_bg)");
        p0((GradientImageView) findViewById6);
        View findViewById7 = containerView.findViewById(R.id.w5y);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026mmend_base_guild_content)");
        m0(findViewById7);
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewExtKt.b(rootView, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.RecommendGuildSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull HorizontalGuildData data, int position, @Nullable List<Object> payload) {
        boolean isBlank;
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        super.onBindData(data, position, payload);
        TextView textView = this.mIntro;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntro");
            textView = null;
        }
        textView.setText(data.getGuildIntro());
        String guildIntro = data.getGuildIntro();
        Intrinsics.checkNotNullExpressionValue(guildIntro, "data.guildIntro");
        isBlank = StringsKt__StringsJVMKt.isBlank(guildIntro);
        if (!isBlank) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }
}
