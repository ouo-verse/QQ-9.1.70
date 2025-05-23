package gq3;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qconn.protofile.OpenSdkRecCommon$PromoteViewItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lgq3/a;", "Lgq3/b;", "Landroid/view/View;", "viewGroup", "Lcom/tencent/qconn/protofile/OpenSdkRecCommon$PromoteViewItem;", "data", "", "c", "", "type", "", "b", "Landroid/view/ViewGroup;", "root", "a", "<init>", "()V", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends b {
    private final void c(View viewGroup, OpenSdkRecCommon$PromoteViewItem data) {
        ((TextView) viewGroup.findViewById(R.id.dr7)).setText(data.name.get());
        ((TextView) viewGroup.findViewById(R.id.xt8)).setText(data.describe.get());
        String str = data.icon_url.get();
        if (!TextUtils.isEmpty(str)) {
            ((RFWRoundImageView) viewGroup.findViewById(R.id.f164385vs)).setImageDrawable(URLDrawable.getDrawable(str));
        }
    }

    @Override // gq3.b
    @NotNull
    public View a(@NotNull ViewGroup root, @NotNull OpenSdkRecCommon$PromoteViewItem data) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(data, "data");
        View viewGroup = LayoutInflater.from(root.getContext()).inflate(R.layout.fqq, root, false);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "viewGroup");
        c(viewGroup, data);
        return viewGroup;
    }

    @Override // gq3.b
    public boolean b(int type) {
        return true;
    }
}
