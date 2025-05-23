package com.tencent.mobileqq.wink.view.selector;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.view.selector.WinkActionSheet;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f327138a;

    /* renamed from: b, reason: collision with root package name */
    protected WinkActionSheet f327139b;

    /* renamed from: c, reason: collision with root package name */
    protected WinkPickerView f327140c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f327141d;

    public a(Context context, boolean z16) {
        this.f327138a = context;
        this.f327141d = z16;
        WinkActionSheet X = WinkActionSheet.X(context, z16);
        this.f327139b = X;
        this.f327140c = (WinkPickerView) X.findViewById(R.id.f61852z9);
    }

    public void a(WinkActionSheet.f fVar) {
        this.f327139b.b0(fVar);
    }

    public void b() {
        try {
            Context context = this.f327138a;
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing() && !this.f327139b.isShowing()) {
                    this.f327139b.show();
                }
            } else {
                this.f327139b.show();
            }
        } catch (Exception e16) {
            QLog.e("BaseSelectorView", 1, "BaseSelectorView show error", e16);
        }
    }
}
