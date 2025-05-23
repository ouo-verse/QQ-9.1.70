package cg2;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.richtext.ui.view.lottie.VLottieView;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IKLottieViewCreator;
import com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcg2/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel;", "Lorg/json/JSONObject;", "domJSON", "", NodeProps.MAX_WIDTH, "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel$SkinType;", "skinType", "", "init", "Landroid/content/Context;", "context", "Landroid/view/View;", "getNVView", "updateNVViewSkin", "Lnh0/a;", "a", "Lnh0/a;", "nvViewModel", "", "environmentEnsureByUser", "<init>", "(Z)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements INVViewModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final nh0.a nvViewModel;

    public a(boolean z16) {
        this.nvViewModel = new nh0.a(z16);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModel
    public View getNVView(Context context) {
        return this.nvViewModel.b(context);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModel
    public void init(JSONObject domJSON, float maxWidth, INVViewModel.SkinType skinType) {
        Intrinsics.checkNotNullParameter(domJSON, "domJSON");
        Intrinsics.checkNotNullParameter(skinType, "skinType");
        VLottieView.a.b(((IKLottieViewCreator) QRoute.api(IKLottieViewCreator.class)).createKLottieViewCreator());
        this.nvViewModel.c(domJSON, maxWidth, skinType.ordinal());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModel
    public void updateNVViewSkin(INVViewModel.SkinType skinType) {
        Intrinsics.checkNotNullParameter(skinType, "skinType");
        this.nvViewModel.g(skinType.ordinal());
    }
}
