package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import lo2.SearchSuggestItem;
import lo2.ad;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/business/net/view/NetSearchTemplateSearchSuggestView;", "Lcom/tencent/mobileqq/search/business/net/view/c;", "Llo2/ad;", "model", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/search/base/fragment/BaseSearchFragment;", "FTSEntitySearchFragment", "Lcom/tencent/mobileqq/search/business/net/view/a;", "Llo2/ao;", "t", "", "input", "matchContent", "Landroid/text/Spannable;", ReportConstant.COSTREPORT_PREFIX, "", "r", "Landroidx/recyclerview/widget/RecyclerView;", "M", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "title", "Landroid/content/Context;", "P", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchTemplateSearchSuggestView extends c {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView title;

    /* renamed from: P, reason: from kotlin metadata */
    private Context context;

    public NetSearchTemplateSearchSuggestView(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.context = context;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fut, (ViewGroup) null);
        this.f433999d = inflate;
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.eap);
        this.title = (TextView) this.f433999d.findViewById(R.id.title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Spannable s(String input, String matchContent) {
        int indexOf$default;
        SpannableString spannableString = new SpannableString(input);
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString, matchContent, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.qui_common_brand_standard)), indexOf$default, matchContent.length() + indexOf$default, 18);
        }
        return spannableString;
    }

    private final a<SearchSuggestItem> t(ad model, Class<? extends BaseSearchFragment<?>> FTSEntitySearchFragment) {
        return new a<>(R.layout.fus, new NetSearchTemplateSearchSuggestView$searchSuggestItemAdapter$1(this, model, FTSEntitySearchFragment));
    }

    public final void r(@NotNull ad model, @NotNull Class<? extends BaseSearchFragment<?>> FTSEntitySearchFragment) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(FTSEntitySearchFragment, "FTSEntitySearchFragment");
        TextView textView = this.title;
        if (textView != null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            textView.setText(context.getResources().getString(R.string.f213005p2));
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            a<SearchSuggestItem> t16 = t(model, FTSEntitySearchFragment);
            t16.i0(model.W());
            recyclerView.setAdapter(t16);
        }
    }
}
