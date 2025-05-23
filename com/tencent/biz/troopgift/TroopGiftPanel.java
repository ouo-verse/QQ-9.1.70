package com.tencent.biz.troopgift;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes5.dex */
public class TroopGiftPanel extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public static int f96912e = 1 + 1;

    /* renamed from: d, reason: collision with root package name */
    protected int f96913d;

    public TroopGiftPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96913d = 1;
    }

    public boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        int i3 = this.f96913d;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        return i3;
                    }
                    return 508;
                }
                return 504;
            }
            return 2;
        }
        return -1;
    }

    public int c() {
        return 0;
    }

    public boolean d() {
        return true;
    }
}
