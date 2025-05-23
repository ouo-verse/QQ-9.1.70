package com.tencent.mobileqq.search.searchdetail.content.view;

import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/a;", "Lcom/tencent/mobileqq/search/view/AutoHintLayout$b;", "", "position", "", "hintText", "reportData", "", "onHintChange", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "d", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "getSearchBar", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "e", "Lcom/tencent/mobileqq/search/view/AutoHintLayout$b;", "getHintChangeListener", "()Lcom/tencent/mobileqq/search/view/AutoHintLayout$b;", "hintChangeListener", "<init>", "(Lcom/tencent/mobileqq/widget/search/QUISearchBar;Lcom/tencent/mobileqq/search/view/AutoHintLayout$b;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a implements AutoHintLayout.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUISearchBar searchBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AutoHintLayout.b hintChangeListener;

    public a(@NotNull QUISearchBar searchBar, @Nullable AutoHintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(searchBar, "searchBar");
        this.searchBar = searchBar;
        this.hintChangeListener = bVar;
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int position, @Nullable String hintText, @Nullable String reportData) {
        QuickPinyinEditText inputWidget = this.searchBar.getInputWidget();
        inputWidget.getLayoutParams().width = (int) (inputWidget.getPaint().measureText(hintText) + ViewUtils.dpToPx(16.0f));
        inputWidget.requestLayout();
        AutoHintLayout.b bVar = this.hintChangeListener;
        if (bVar != null) {
            bVar.onHintChange(position, hintText, reportData);
        }
    }
}
