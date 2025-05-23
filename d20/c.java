package d20;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.q;
import com.tencent.biz.pubaccount.weishi.z;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends a {
    private void e(Context context, Map<String, String> map) {
        z.l(context, new q(this.f392673c, 0, false).g(map.get("feed_id")));
    }

    @Override // d20.a
    protected boolean b(Context context, Map<String, String> map, Object obj) {
        e(context, map);
        return true;
    }
}
