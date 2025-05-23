package com.tencent.mobileqq.kandian.biz.share;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private k f239500a;

    /* renamed from: b, reason: collision with root package name */
    private AppInterface f239501b;

    /* renamed from: c, reason: collision with root package name */
    private String f239502c;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends k {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void m(boolean z16, Long l3, String str) {
            if (TextUtils.isEmpty(str) || !str.equals(e.this.f239502c)) {
                return;
            }
            Context baseContext = BaseApplicationImpl.getApplication().getBaseContext();
            if (z16) {
                QQToast.makeText(BaseApplicationImpl.getApplication(), 2, R.string.hei, 0).show(baseContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            } else {
                QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.he7, 0).show(baseContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
    }

    public e(AppInterface appInterface) {
        this.f239501b = appInterface;
        a aVar = new a();
        this.f239500a = aVar;
        AppInterface appInterface2 = this.f239501b;
        if (appInterface2 != null) {
            appInterface2.addObserver(aVar);
        }
    }
}
