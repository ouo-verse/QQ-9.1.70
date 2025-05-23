package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/d;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/widget/listitem/QUILinkListItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "L", "view", "", "position", "", "", "payloads", "", "K", "", "k", "Ljava/lang/String;", "J", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "<init>", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d extends w<QUILinkListItem> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text;

    public d(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    @NotNull
    /* renamed from: J, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull QUILinkListItem view, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        view.setThemeId(getThemeId());
        view.setConfig(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public QUILinkListItem H(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        QUILinkListItem qUILinkListItem = new QUILinkListItem(context, null);
        qUILinkListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return qUILinkListItem;
    }
}
