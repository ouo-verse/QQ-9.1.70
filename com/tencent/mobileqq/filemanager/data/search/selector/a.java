package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a extends z {
    protected int G;
    protected String H;
    protected Bundle I;

    public a(String str, int i3) {
        this.H = str;
        this.G = i3;
    }

    public abstract boolean G();

    public List<y> H(QQAppInterface qQAppInterface, Context context) {
        return new ArrayList(0);
    }

    public abstract String I();

    public abstract String J();

    public abstract int K();

    public int L() {
        return 0;
    }

    protected abstract void M(View view);

    protected abstract void N(View view);

    protected abstract void O(View view);

    public void P(Bundle bundle) {
        this.I = bundle;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeywords() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        int L = L();
        if (L == 1) {
            if (view.getId() == R.id.c_5) {
                N(view);
                return;
            } else {
                O(view);
                return;
            }
        }
        if (L > 1) {
            M(view);
        }
    }
}
