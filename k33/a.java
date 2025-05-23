package k33;

import android.os.Bundle;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.zootopia.helper.SmallHomeHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJD\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J0\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000e"}, d2 = {"Lk33/a;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ueExtras", IProfileProtocolConst.PARAM_TARGET_UIN, "", "a", "Landroid/os/Bundle;", "bundle", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f411513a = new a();

    a() {
    }

    public final Map<String, Object> a(HashMap<String, Object> ueExtras, String targetUin) {
        HashMap hashMap = new HashMap();
        if (ueExtras != null) {
            hashMap.putAll(ueExtras);
        }
        if (!hashMap.containsKey("SceneType")) {
            hashMap.putAll(SmallHomeHelper.f328312a.a("3", targetUin));
        }
        return hashMap;
    }

    public final HashMap<String, Object> b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        Set<String> keySet = bundle.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                Object obj = bundle.get(str);
                if (obj == null) {
                    obj = "";
                }
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }
}
