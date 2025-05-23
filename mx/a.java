package mx;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 == 1001) {
            a(z16, (BmqqUserSimpleInfo) obj);
        }
    }

    protected void a(boolean z16, BmqqUserSimpleInfo bmqqUserSimpleInfo) {
    }
}
