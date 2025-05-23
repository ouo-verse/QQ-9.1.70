package com.tencent.ecommerce.biz.detail.viewmodel.saas;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/saas/b;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroid/os/Bundle;", "a", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "arguments", "<init>", "(Landroid/os/Bundle;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Bundle arguments;

    public b(Bundle bundle) {
        this.arguments = bundle;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String string;
        Bundle bundle = this.arguments;
        String str9 = "";
        if (bundle == null || (str = bundle.getString("product_type", "")) == null) {
            str = "";
        }
        Bundle bundle2 = this.arguments;
        if (bundle2 == null || (str2 = bundle2.getString("saas_product_id", "")) == null) {
            str2 = "";
        }
        Bundle bundle3 = this.arguments;
        if (bundle3 == null || (str3 = bundle3.getString(PictureConst.KEY_CATEGORY_ID, "")) == null) {
            str3 = "";
        }
        Bundle bundle4 = this.arguments;
        if (bundle4 == null || (str4 = bundle4.getString("media_id", "")) == null) {
            str4 = "";
        }
        Bundle bundle5 = this.arguments;
        if (bundle5 == null || (str5 = bundle5.getString("category_name", "")) == null) {
            str5 = "";
        }
        Bundle bundle6 = this.arguments;
        if (bundle6 == null || (str6 = bundle6.getString("goods_type", "")) == null) {
            str6 = "";
        }
        Bundle bundle7 = this.arguments;
        if (bundle7 == null || (str7 = bundle7.getString("source_from", "")) == null) {
            str7 = "";
        }
        Bundle bundle8 = this.arguments;
        if (bundle8 == null || (str8 = bundle8.getString("banner_id", "")) == null) {
            str8 = "";
        }
        Bundle bundle9 = this.arguments;
        if (bundle9 != null && (string = bundle9.getString("banner_name", "")) != null) {
            str9 = string;
        }
        return modelClass.getConstructor(String.class, String.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, String.class, String.class).newInstance(str, str2, str3, str5, str4, str6, Boolean.FALSE, str7, str8, str9);
    }
}
