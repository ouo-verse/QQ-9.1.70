package gq3;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.armap.e;
import com.tencent.mobileqq.armap.f;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.agent.util.t;
import com.tencent.qconn.protofile.OpenSdkRecCommon$PromoteViewItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lgq3/d;", "Lgq3/b;", "Landroid/view/View;", "viewGroup", "Lcom/tencent/qconn/protofile/OpenSdkRecCommon$PromoteViewItem;", "data", "", "d", "", "type", "", "b", "Landroid/view/ViewGroup;", "root", "a", "<init>", "()V", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d extends b {
    private final void d(final View viewGroup, OpenSdkRecCommon$PromoteViewItem data) {
        ((TextView) viewGroup.findViewById(R.id.dr7)).setText(data.name.get());
        ((TextView) viewGroup.findViewById(R.id.xt8)).setText(data.describe.get());
        String str = data.f342463id.get();
        if (TextUtils.isEmpty(str)) {
            t.e("PublicAccountRecProcessor", "id is empty");
            return;
        }
        final f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(viewGroup.getContext(), 1);
        nonMainAppHeadLoader.init();
        Bitmap b16 = nonMainAppHeadLoader.b(str, true);
        Intrinsics.checkNotNullExpressionValue(b16, "headerLoader.getFaceBitmap(id, true)");
        ((RFWRoundImageView) viewGroup.findViewById(R.id.f164385vs)).setImageBitmap(b16);
        nonMainAppHeadLoader.a(new e() { // from class: gq3.c
            @Override // com.tencent.mobileqq.armap.e
            public final void h(String str2, String str3, Bitmap bitmap) {
                d.e(viewGroup, nonMainAppHeadLoader, str2, str3, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View viewGroup, f fVar, String str, String str2, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(viewGroup, "$viewGroup");
        ((RFWRoundImageView) viewGroup.findViewById(R.id.f164385vs)).setImageBitmap(bitmap);
        fVar.destroy();
    }

    @Override // gq3.b
    @NotNull
    public View a(@NotNull ViewGroup root, @NotNull OpenSdkRecCommon$PromoteViewItem data) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(data, "data");
        View viewGroup = LayoutInflater.from(root.getContext()).inflate(R.layout.fqq, root, false);
        Intrinsics.checkNotNullExpressionValue(viewGroup, "viewGroup");
        d(viewGroup, data);
        return viewGroup;
    }

    @Override // gq3.b
    public boolean b(int type) {
        if (type == 1) {
            return true;
        }
        return false;
    }
}
