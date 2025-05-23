package ly4;

import android.content.Context;
import com.tencent.mobileqq.pb.MessageMicro;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import pl4.c;
import pl4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements c {
    private <T extends MessageMicro> void N3(AppRuntime appRuntime, NewIntent newIntent, Class<T> cls, d<T> dVar) {
        a.c(appRuntime, newIntent, cls, dVar);
    }

    @Override // pl4.c
    public <T extends MessageMicro> void F1(NewIntent newIntent, Class<T> cls, d<T> dVar) {
        N3(vf4.a.a(), newIntent, cls, dVar);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
