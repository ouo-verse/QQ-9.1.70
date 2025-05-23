package com.tencent.mobileqq.guild.aisearch.parts;

import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0014J4\u0010\u0014\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0014R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/TitleItemDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "", "Landroid/widget/ImageView;", "imageView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "items", "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "payloads", "l", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "aiSearchConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class TitleItemDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends Object>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiSearchConfig;

    public TitleItemDelegate() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildAISearchConfBean>() { // from class: com.tencent.mobileqq.guild.aisearch.parts.TitleItemDelegate$aiSearchConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildAISearchConfBean invoke() {
                return GuildAISearchConfBean.INSTANCE.a();
            }
        });
        this.aiSearchConfig = lazy;
    }

    private final GuildAISearchConfBean j() {
        return (GuildAISearchConfBean) this.aiSearchConfig.getValue();
    }

    private final void m(ImageView imageView) {
        com.tencent.mobileqq.guild.picload.e.a().e(Option.obtain().setTargetView(imageView).setNeedFilterUrl(false).setUrl(j().getIconUrl()).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(imageView.getContext().getDrawable(R.drawable.guild_discover_ai_search_icon)).setRequestWidth(imageView.getWidth()).setRequestHeight(imageView.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = View.inflate(parent.getContext(), R.layout.f168023ee0, null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new e(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends Object> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return items.get(position) instanceof AISearchRecommendRepository.RecommendItem.TitleText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends Object> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        AISearchRecommendRepository.RecommendItem.TitleText titleText;
        int roundToInt;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof e) {
            Object obj = items.get(position);
            if (obj instanceof AISearchRecommendRepository.RecommendItem.TitleText) {
                titleText = (AISearchRecommendRepository.RecommendItem.TitleText) obj;
            } else {
                titleText = null;
            }
            if (titleText == null) {
                return;
            }
            e eVar = (e) holder;
            TextView titleText2 = eVar.getTitleText();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(titleText.getTitle());
            roundToInt = MathKt__MathJVMKt.roundToInt(cw.b(28));
            spannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(roundToInt, 0), 0, spannableStringBuilder.length(), 33);
            titleText2.setText(spannableStringBuilder);
            eVar.getSubTitleText().setText(titleText.getSubTitle());
            m(eVar.getIcon());
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
