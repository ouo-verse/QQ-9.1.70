package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        try {
            if (i3 != 1) {
                if (i3 == 2) {
                    if (obj != null) {
                        b(z16, (ArrayList) obj);
                    } else {
                        b(false, new ArrayList<>(0));
                    }
                }
            } else if (obj != null) {
                a(z16, (ArrayList) obj);
            } else {
                a(false, new ArrayList(0));
            }
        } catch (Exception unused) {
        }
    }

    protected void a(boolean z16, List<d> list) {
    }

    protected void b(boolean z16, ArrayList<ReadInJoyArticle> arrayList) {
    }
}
