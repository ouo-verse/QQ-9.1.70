package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/j;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "sku", "", "b", "Ljava/lang/String;", "activityId", "c", "adClickId", "d", "groupId", "", "e", "Ljava/lang/Boolean;", "isBuyAll", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class j implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SimpleSku sku;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String activityId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String adClickId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String groupId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Boolean isBuyAll;

    public j(SimpleSku simpleSku, String str, String str2, String str3, Boolean bool) {
        this.sku = simpleSku;
        this.activityId = str;
        this.adClickId = str2;
        this.groupId = str3;
        this.isBuyAll = bool;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return new ECOrderSubmitViewModel(this.sku, this.activityId, this.adClickId, this.groupId, this.isBuyAll);
    }
}
