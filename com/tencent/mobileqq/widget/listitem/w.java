package com.tencent.mobileqq.widget.listitem;

import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005J*\u0010\u000f\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ%\u0010\u0012\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H$\u00a2\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u001bH\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/w;", "Landroid/view/View;", "V", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/ac;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "I", "viewHolder", "", "position", "", "", "payloads", "", "G", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "E", "(Lcom/tencent/mobileqq/widget/listitem/ac;Lcom/tencent/mobileqq/widget/listitem/Group$c;)V", "H", "(Landroid/view/ViewGroup;)Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "(Landroid/view/View;ILjava/util/List;)V", "D", "(Landroid/view/View;Lcom/tencent/mobileqq/widget/listitem/Group$c;)V", "", BdhLogUtil.LogTag.Tag_Conn, "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class w<V extends View> extends a<ac<V>> {
    @NotNull
    public String C() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(@NotNull V view, @NotNull Group.c outMargin) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
    }

    @Override // com.tencent.mobileqq.widget.listitem.a
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final void c(@NotNull ac<V> viewHolder, @NotNull Group.c outMargin) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        super.c(viewHolder, outMargin);
        D(viewHolder.getView(), outMargin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(@NotNull V view, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    @Override // com.tencent.mobileqq.widget.listitem.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final void m(@NotNull ac<V> viewHolder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        F(viewHolder.getView(), position, payloads);
    }

    @NotNull
    protected abstract V H(@NotNull ViewGroup parent);

    @Override // com.tencent.mobileqq.widget.listitem.a
    @NotNull
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final ac<V> n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new ac<>(H(parent));
    }
}
