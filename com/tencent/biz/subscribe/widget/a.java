package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.h;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends h {
    public a(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.addcontact.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        attributes.y -= getContext().getResources().getDimensionPixelOffset(R.dimen.b1u);
        window.setAttributes(attributes);
    }
}
