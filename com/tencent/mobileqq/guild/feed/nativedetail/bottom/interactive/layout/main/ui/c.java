package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.InputStyleConfig;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/c;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "", "show", "", "f", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "init", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "bottomInteractData", "b", "Lwk1/h;", "d", "Lwk1/h;", "inputContext", "Landroid/view/View;", "e", "Landroid/view/View;", "divideLine", "<init>", "(Lwk1/h;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.h inputContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View divideLine;

    public c(@NotNull wk1.h inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
    }

    private final void f(boolean show) {
        int i3;
        View view = this.divideLine;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("divideLine");
            view = null;
        }
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void a() {
        d.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void b(@NotNull qj1.b bottomInteractData) {
        Intrinsics.checkNotNullParameter(bottomInteractData, "bottomInteractData");
        f(bottomInteractData.A());
    }

    @Override // wk1.j
    public void c(@NotNull String str, @Nullable Object obj) {
        d.a.a(this, str, obj);
    }

    @Override // wk1.j
    @Nullable
    public Object d(@NotNull String str, @Nullable Object obj) {
        return d.a.b(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void e(@NotNull SpeakPermissionType speakPermissionType) {
        d.a.e(this, speakPermissionType);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void init(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.w8t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026d_feed_detail_input_line)");
        this.divideLine = findViewById;
        InputStyleConfig d16 = this.inputContext.d();
        if (d16 != null) {
            View view = this.divideLine;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
                view = null;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (int) wn0.a.f445842a.c(d16.getDividingLineHeight());
            View view3 = this.divideLine;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
                view3 = null;
            }
            view3.setLayoutParams(layoutParams);
            View view4 = this.divideLine;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("divideLine");
            } else {
                view2 = view4;
            }
            view2.setBackgroundResource(d16.getDividingLineDrawableRes());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void u1(boolean z16) {
        d.a.f(this, z16);
    }
}
