package l6;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends k6.c<k6.d> {
    @Override // k6.c
    public k6.d a() {
        return new b();
    }

    @Override // k6.c
    public boolean b(i6.a aVar) {
        String p16 = aVar.p();
        String e16 = aVar.e();
        com.tencent.xaction.log.b.a("BigCardGameDecoratorBuilder", 1, "isTarget modelId=" + p16 + ", adType=" + e16);
        if (TextUtils.equals(p16, "daka")) {
            return "1".equals(e16) || "2".equals(e16);
        }
        return false;
    }
}
