package com.tencent.gdtad.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes6.dex */
public class r implements AdToastAdapter {
    @Override // com.tencent.ad.tangram.toast.AdToastAdapter
    public void show(@Nullable Context context, int i3, CharSequence charSequence, int i16) {
        if (context == null) {
            return;
        }
        int i17 = 1;
        if (i3 != 1) {
            i17 = 2;
            if (i3 != 2) {
                i17 = 0;
            }
        }
        QQToast.makeText(context, i17, charSequence, i16).show();
    }
}
