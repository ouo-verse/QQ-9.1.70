package co1;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lco1/k;", "Landroid/view/View$OnClickListener;", "Landroidx/viewbinding/ViewBinding;", "servedViewBinding", "", "c", "Landroid/view/View;", "servedRootView", "b", "who", "a", NodeProps.ON_CLICK, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class k implements View.OnClickListener {
    public void a(@NotNull View who) {
        Intrinsics.checkNotNullParameter(who, "who");
    }

    public abstract void b(@NotNull View servedRootView);

    public void c(@NotNull ViewBinding servedViewBinding) {
        Intrinsics.checkNotNullParameter(servedViewBinding, "servedViewBinding");
        View root = servedViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "servedViewBinding.root");
        b(root);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View who) {
        EventCollector.getInstance().onViewClickedBefore(who);
        Intrinsics.checkNotNullParameter(who, "who");
        EventCollector.getInstance().onViewClicked(who);
    }
}
