package com.tencent.open.manager;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.open.manager.OpenAgentHandler;
import com.tencent.open.model.AppInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    a(z16, (OpenAgentHandler.a) obj);
                    return;
                }
                return;
            } else if (z16) {
                b(z16, (List) obj);
                return;
            } else {
                b(z16, null);
                return;
            }
        }
        if (z16) {
            c(z16, (List) obj, null);
        } else {
            c(z16, null, (String) obj);
        }
    }

    protected void a(boolean z16, OpenAgentHandler.a aVar) {
    }

    protected void b(boolean z16, List<AppInfo> list) {
    }

    protected void c(boolean z16, List<AppInfo> list, String str) {
    }
}
