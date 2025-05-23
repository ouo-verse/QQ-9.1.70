package com.tencent.ecommerce.base.fragment;

import android.view.View;
import com.tencent.ecommerce.base.fragment.api.IECContentDescProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/base/fragment/a;", "Lcom/tencent/ecommerce/base/fragment/api/IECContentDescProvider;", "", "desc", "", "setContentDescription", "getContentDescription", "d", "Ljava/lang/String;", "contentDesc", "Lkotlin/Function0;", "Landroid/view/View;", "e", "Lkotlin/jvm/functions/Function0;", "viewFetcher", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a implements IECContentDescProvider {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String contentDesc = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<View> viewFetcher;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends View> function0) {
        this.viewFetcher = function0;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECContentDescProvider
    /* renamed from: getContentDescription, reason: from getter */
    public String getContentDesc() {
        return this.contentDesc;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECContentDescProvider
    public void setContentDescription(String desc) {
        this.contentDesc = desc;
        View invoke = this.viewFetcher.invoke();
        if (invoke != null) {
            invoke.setContentDescription(desc);
        }
    }
}
