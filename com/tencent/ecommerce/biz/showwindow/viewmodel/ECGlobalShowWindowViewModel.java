package com.tencent.ecommerce.biz.showwindow.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Context;", "context", "", "saasType", "saasProductId", "goodsType", "Lorg/json/JSONObject;", "productInfo", "", "N1", "Lcom/tencent/ecommerce/biz/productcenter/repo/a;", "i", "Lkotlin/Lazy;", "M1", "()Lcom/tencent/ecommerce/biz/productcenter/repo/a;", "repo", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGlobalShowWindowViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy repo;

    public ECGlobalShowWindowViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.biz.productcenter.repo.a>() { // from class: com.tencent.ecommerce.biz.showwindow.viewmodel.ECGlobalShowWindowViewModel$repo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.ecommerce.biz.productcenter.repo.a invoke() {
                return com.tencent.ecommerce.biz.productcenter.repo.a.f103921a;
            }
        });
        this.repo = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.productcenter.repo.a M1() {
        return (com.tencent.ecommerce.biz.productcenter.repo.a) this.repo.getValue();
    }

    public final void N1(Context context, String saasType, String saasProductId, String goodsType, JSONObject productInfo) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECGlobalShowWindowViewModel$requestAddProductWindow$1(this, saasType, saasProductId, goodsType, context, productInfo, null), 3, null);
    }

    public static /* synthetic */ void O1(ECGlobalShowWindowViewModel eCGlobalShowWindowViewModel, Context context, String str, String str2, String str3, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            jSONObject = new JSONObject();
        }
        eCGlobalShowWindowViewModel.N1(context, str, str2, str3, jSONObject);
    }
}
