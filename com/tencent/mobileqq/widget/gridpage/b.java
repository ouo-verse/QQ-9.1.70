package com.tencent.mobileqq.widget.gridpage;

import android.view.ViewGroup;
import com.tencent.mobileqq.widget.gridpage.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u001f\u0010\u000e\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/widget/gridpage/b;", "Lcom/tencent/mobileqq/widget/gridpage/c;", "T", "", "", "b", "e", "a", "", "d", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "g", "(Landroid/view/ViewGroup;I)Lcom/tencent/mobileqq/widget/gridpage/c;", "holder", "position", "", "f", "(Lcom/tencent/mobileqq/widget/gridpage/c;I)V", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class b<T extends c> {
    public abstract int a();

    public abstract int b();

    public abstract float c();

    public abstract float d();

    public abstract int e();

    public abstract void f(@NotNull T holder, int position);

    @NotNull
    public abstract T g(@NotNull ViewGroup parent, int viewType);
}
