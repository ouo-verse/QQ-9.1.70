package m6;

import android.text.TextUtils;
import k6.c;
import k6.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends c<d> {
    @Override // k6.c
    public d a() {
        return new a();
    }

    @Override // k6.c
    public boolean b(i6.a aVar) {
        String e16 = aVar.e();
        String p16 = aVar.p();
        com.tencent.xaction.log.b.a("BigCardMallDecoratorBuilder", 1, "isTarget modelId=" + p16 + ", adType=" + e16);
        if (TextUtils.equals(p16, "daka")) {
            return "3".equals(e16);
        }
        return false;
    }
}
