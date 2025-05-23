package fi4;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.timi.game.utils.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements ei4.a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, URLDrawable.URLDrawableOptions> f399443a = new HashMap();

    @Override // ei4.a
    public URLDrawable m(String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (str.isEmpty()) {
            return null;
        }
        this.f399443a.put(str, uRLDrawableOptions);
        return URLDrawable.getDrawable(str, uRLDrawableOptions);
    }

    @Override // mm4.a
    public void o2() {
        for (Map.Entry<String, URLDrawable.URLDrawableOptions> entry : this.f399443a.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                URLDrawable.removeMemoryCacheByUrl(entry.getKey(), entry.getValue());
                l.i("DrawableServiceImpl", "\u79fb\u9664\u4e00\u6761\u56fe\u7247\u7f13\u5b58\uff1a" + entry.getKey());
            }
        }
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
