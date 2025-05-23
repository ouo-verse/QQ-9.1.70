package b20;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.view.topnav.WSTopNavigationBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lb20/a;", "", "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "a", "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "topNavigationBar", "Landroid/view/View;", "b", "Landroid/view/View;", "()Landroid/view/View;", "setCenterContentView", "(Landroid/view/View;)V", "centerContentView", "", "id", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;I)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WSTopNavigationBar topNavigationBar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View centerContentView;

    public a(WSTopNavigationBar topNavigationBar, int i3) {
        Intrinsics.checkNotNullParameter(topNavigationBar, "topNavigationBar");
        this.topNavigationBar = topNavigationBar;
        ViewGroup.LayoutParams layoutParams = topNavigationBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
        topNavigationBar.setLayoutParams(layoutParams2);
        this.centerContentView = topNavigationBar.c(i3);
    }

    /* renamed from: a, reason: from getter */
    public final View getCenterContentView() {
        return this.centerContentView;
    }
}
