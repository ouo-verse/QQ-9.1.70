package d20;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected String f392671a;

    /* renamed from: b, reason: collision with root package name */
    protected String f392672b;

    /* renamed from: c, reason: collision with root package name */
    protected String f392673c;

    /* renamed from: d, reason: collision with root package name */
    protected String f392674d;

    private void c(Map<String, String> map) {
        this.f392671a = map.get("ext_data");
        this.f392672b = map.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        this.f392673c = map.get("scene");
        this.f392674d = map.get("scenes_channel_from");
    }

    public boolean a(Context context, Map<String, String> map, Object obj) {
        c(map);
        boolean b16 = b(context, map, obj);
        d(b16);
        return b16;
    }

    protected abstract boolean b(Context context, Map<String, String> map, Object obj);

    private void d(boolean z16) {
        if (!z16 || TextUtils.isEmpty(this.f392673c)) {
            return;
        }
        bb.W(this.f392673c);
    }
}
