package com.tencent.mobileqq.guild.quicksearch.searchbox;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/g;", "Lcom/tencent/mobileqq/widget/search/BaseSearchBarLayoutExt;", "", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "extDataList", "", "isInDelete", "", "a", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "", "style", "themeId", "colorType", "onInitLeftView", "onUpdateTheme", "Landroid/widget/TextView;", "v", "actionId", "Landroid/view/KeyEvent;", "event", "onEditorAction", "getLayoutWidthInPx", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchExtLayout;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchExtLayout;", "extLayout", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bar", "<init>", "(Lcom/tencent/mobileqq/widget/search/QUISearchBar;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g extends BaseSearchBarLayoutExt {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SearchExtLayout extLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull QUISearchBar bar) {
        super(bar);
        Intrinsics.checkNotNullParameter(bar, "bar");
    }

    public final void a(@Nullable List<? extends SearchBarExtData> extDataList, boolean isInDelete) {
        SearchExtLayout searchExtLayout = this.extLayout;
        if (searchExtLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extLayout");
            searchExtLayout = null;
        }
        searchExtLayout.C(extDataList, isInDelete);
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public int getLayoutWidthInPx(int style) {
        SearchExtLayout searchExtLayout = this.extLayout;
        if (searchExtLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extLayout");
            searchExtLayout = null;
        }
        return searchExtLayout.getWidth();
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public boolean onEditorAction(@NotNull TextView v3, int actionId, @Nullable KeyEvent event) {
        Intrinsics.checkNotNullParameter(v3, "v");
        return false;
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onInitLeftView(@NotNull FrameLayout container, int style, int themeId, int colorType) {
        Intrinsics.checkNotNullParameter(container, "container");
        Context context = this.mBar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBar.context");
        this.extLayout = new SearchExtLayout(context, null, 0, 6, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 16);
        SearchExtLayout searchExtLayout = this.extLayout;
        if (searchExtLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extLayout");
            searchExtLayout = null;
        }
        container.addView(searchExtLayout, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onUpdateTheme(int themeId, int colorType) {
        SearchExtLayout searchExtLayout = this.extLayout;
        if (searchExtLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extLayout");
            searchExtLayout = null;
        }
        searchExtLayout.D();
    }
}
