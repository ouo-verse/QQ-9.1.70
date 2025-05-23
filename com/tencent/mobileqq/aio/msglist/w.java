package com.tencent.mobileqq.aio.msglist;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/w;", "", "", "specificHeight", "x0", "componentKey", "q0", "Landroidx/recyclerview/widget/RecyclerView;", "K0", "", "getCurrentFocus", "Landroid/view/View$AccessibilityDelegate;", "U0", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface w {
    @NotNull
    RecyclerView K0();

    @NotNull
    View.AccessibilityDelegate U0();

    long getCurrentFocus();

    int q0(int specificHeight, int componentKey);

    int x0(int specificHeight);
}
