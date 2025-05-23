package com.tencent.mobileqq.widget.selectorview;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B1\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/widget/selectorview/i;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "firstIndex", "secondIndex", "thirdIndex", "", "o", "", "g", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", tl.h.F, "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "getTimeAdapter", "()Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "timeAdapter", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$f;", "i", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$f;", "getListener", "()Lcom/tencent/mobileqq/widget/selectorview/QPickerView$f;", "listener", "Lmqq/util/WeakReference;", "Landroid/content/Context;", "context", "<init>", "(Lmqq/util/WeakReference;Ljava/lang/String;Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;Lcom/tencent/mobileqq/widget/selectorview/QPickerView$f;)V", "j", "a", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i extends h {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QPickerView.e timeAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QPickerView.f listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull WeakReference<Context> context, @NotNull String title, @NotNull QPickerView.e timeAdapter, @Nullable QPickerView.f fVar) {
        super(context.get());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(timeAdapter, "timeAdapter");
        this.title = title;
        this.timeAdapter = timeAdapter;
        this.listener = fVar;
        k(title);
        this.f317413c.j(timeAdapter);
        this.f317413c.setPickListener(fVar);
    }

    public final void o(int firstIndex, int secondIndex, int thirdIndex) {
        this.f317413c.setSelection(0, firstIndex);
        this.f317413c.setSelection(1, secondIndex);
        this.f317413c.setSelection(2, thirdIndex);
    }
}
