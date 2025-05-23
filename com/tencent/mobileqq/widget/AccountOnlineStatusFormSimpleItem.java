package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AccountOnlineStatusFormSimpleItem extends FormSimpleItem {
    public AccountOnlineStatusFormSimpleItem(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.FormSimpleItem
    public void i() {
        super.i();
        this.M.setCompoundDrawablePadding(BaseAIOUtils.f(12.0f, getResources()));
    }

    public AccountOnlineStatusFormSimpleItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
