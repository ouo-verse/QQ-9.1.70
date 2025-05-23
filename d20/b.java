package d20;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends a {
    private void e(Context context, Map<String, String> map) {
        WSDramaPageFragment.Vh(new com.tencent.biz.pubaccount.weishi.drama.e(this.f392673c, context).i(map.get("drama_id")));
    }

    @Override // d20.a
    protected boolean b(Context context, Map<String, String> map, Object obj) {
        e(context, map);
        return true;
    }
}
