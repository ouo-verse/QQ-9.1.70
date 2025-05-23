package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/bc;", "", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/tbstool/fileview/a;", "onViewVisible", "", "a", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class bc {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bc f209377a = new bc();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/filemanager/util/bc$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f209378d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.tbstool.fileview.a f209379e;

        a(View view, com.tencent.mobileqq.tbstool.fileview.a aVar) {
            this.f209378d = view;
            this.f209379e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f209378d.getVisibility() == 0) {
                this.f209378d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.f209379e.invoke();
            }
        }
    }

    bc() {
    }

    public final void a(@NotNull View view, @NotNull com.tencent.mobileqq.tbstool.fileview.a onViewVisible) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onViewVisible, "onViewVisible");
        if (view.getVisibility() == 0) {
            onViewVisible.invoke();
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, onViewVisible));
        }
    }
}
