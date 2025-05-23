package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.api.IWinkZShowViewForOnlineStatusProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/t;", "Lcom/tencent/mobileqq/onlinestatus/view/aj$b;", "Landroid/view/View;", "getView", "", "a", "hide", "Landroid/widget/FrameLayout;", TtmlNode.TAG_LAYOUT, "b", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "Z", "centerIcon", "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$a;", "c", "Lcom/tencent/aelight/camera/api/IWinkZShowViewForOnlineStatusProvider$a;", "loadView", "<init>", "(Landroid/content/Context;Z)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class t implements aj.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean centerIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IWinkZShowViewForOnlineStatusProvider.a loadView;

    /* JADX WARN: Multi-variable type inference failed */
    public t(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.centerIcon = z16;
        float max = Math.max(1.0f, FontSettingManager.getFontScale());
        String string = context.getString(R.string.f172552qr);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026tatus_zshow_loading_text)");
        IWinkZShowViewForOnlineStatusProvider.a loadingView = ((IWinkZShowViewForOnlineStatusProvider) QRoute.api(IWinkZShowViewForOnlineStatusProvider.class)).getLoadingView(context, new IWinkZShowViewForOnlineStatusProvider.LoadViewConfig(string, 0, 0, false, ViewUtils.dpToPx(124.0f / max), 0, 46, null));
        Intrinsics.checkNotNull(loadingView, "null cannot be cast to non-null type android.view.View");
        ((View) loadingView).setPadding(0, 0, 0, 0);
        this.loadView = loadingView;
    }

    public void a() {
        this.loadView.show();
    }

    public final void b(@NotNull FrameLayout layout) {
        int i3;
        Intrinsics.checkNotNullParameter(layout, "layout");
        View view = getView();
        if (layout.getChildCount() > 0 && Intrinsics.areEqual(layout.getChildAt(0), view)) {
            return;
        }
        try {
            if ((view.getParent() instanceof ViewGroup) && !Intrinsics.areEqual(view.getParent(), layout)) {
                ViewParent parent = view.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(view);
            }
            if (layout.getChildAt(0) instanceof aj.b) {
                layout.removeViewAt(0);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.centerIcon) {
                i3 = 17;
            } else {
                i3 = 80;
            }
            layoutParams.gravity = i3;
            Unit unit = Unit.INSTANCE;
            layout.addView(view, 0, layoutParams);
            a();
        } catch (Throwable th5) {
            QLog.d("OnlineStatusLikeWithAvatarBinding", 1, "showOnContainer, add err: ", th5);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj.b
    @NotNull
    public View getView() {
        Object obj = this.loadView;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        return (View) obj;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.aj.b
    public void hide() {
        if (getView().getVisibility() == 0) {
            this.loadView.hide();
        }
    }

    public /* synthetic */ t(Context context, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? true : z16);
    }
}
