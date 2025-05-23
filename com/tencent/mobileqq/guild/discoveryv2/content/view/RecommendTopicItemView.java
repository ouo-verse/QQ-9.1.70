package com.tencent.mobileqq.guild.discoveryv2.content.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u000e\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/RecommendTopicItemView;", "Landroid/widget/LinearLayout;", "", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPTopicContent;", "content", "a", "c", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mTopic", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPTopicContent;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendTopicItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mTopic;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendTopicItemView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ely, this);
        View findViewById = findViewById(R.id.w6u);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_\u2026overy_v2_recommend_topic)");
        this.mTopic = (TextView) findViewById;
    }

    public final void a(@NotNull IGProMVPTopicContent content) {
        Intrinsics.checkNotNullParameter(content, "content");
        TextView textView = this.mTopic;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopic");
            textView = null;
        }
        textView.setText(content.getTopicName());
    }

    public final void c() {
        setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.guild_discovery_v2_topic_item_bg, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendTopicItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendTopicItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecommendTopicItemView(@NotNull Context context, @NotNull IGProMVPTopicContent content) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        a(content);
    }
}
