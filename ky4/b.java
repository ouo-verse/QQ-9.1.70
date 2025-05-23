package ky4;

import android.content.Context;
import com.tencent.mobileqq.pb.MessageMicro;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import ox0.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements ox0.b {
    private <T extends MessageMicro> void N3(AppRuntime appRuntime, NewIntent newIntent, Class<T> cls, c<T> cVar) {
        a.c(appRuntime, newIntent, cls, cVar);
    }

    @Override // ox0.b
    public <T extends MessageMicro> void E0(NewIntent newIntent, Class<T> cls, c<T> cVar) {
        N3(bu0.a.a(), newIntent, cls, cVar);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
