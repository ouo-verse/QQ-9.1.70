package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class am extends ActionSheet {
    protected am(Context context) {
        super(context);
    }

    public static am n0(Context context) {
        am amVar = new am(context);
        if (Build.VERSION.SDK_INT != 23) {
            amVar.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return amVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ActionSheet
    public int getActionSheetTitleLayoutId() {
        return R.layout.g7a;
    }
}
