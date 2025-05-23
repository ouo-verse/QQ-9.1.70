package h45;

import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class d {
    public static String a(List<Scope> list) {
        if (list != null && list.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<Scope> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().a());
                sb5.append(" ");
            }
            q.q.q.e.w.e.c("HnIDCloudServiceUtils", "scopesToStr scopes : " + sb5.toString().trim(), true);
            return sb5.toString().trim();
        }
        return "";
    }
}
