package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/c;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroid/os/Bundle;", "a", "Landroid/os/Bundle;", "arguments", "Landroidx/fragment/app/FragmentManager;", "b", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroid/os/Bundle;Landroidx/fragment/app/FragmentManager;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Bundle arguments;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FragmentManager fragmentManager;

    public c(Bundle bundle, FragmentManager fragmentManager) {
        this.arguments = bundle;
        this.fragmentManager = fragmentManager;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        String str;
        String str2;
        String string;
        Bundle bundle = this.arguments;
        String str3 = "";
        if (bundle == null || (str = bundle.getString("biz_type", "")) == null) {
            str = "";
        }
        Bundle bundle2 = this.arguments;
        if (bundle2 == null || (str2 = bundle2.getString("is_select")) == null) {
            str2 = "0";
        }
        boolean areEqual = Intrinsics.areEqual(str2, "1");
        Bundle bundle3 = this.arguments;
        if (bundle3 != null && (string = bundle3.getString("qz_gdt")) != null) {
            str3 = string;
        }
        return modelClass.getConstructor(String.class, Boolean.TYPE, FragmentManager.class, String.class).newInstance(str, Boolean.valueOf(areEqual), this.fragmentManager, str3);
    }
}
