package p50;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f425344a = new Gson();

    public void a(String str) {
        k.a().p(str, "");
        QLog.d("QFSReportCache", 1, "[clearLocalCache] clear cache, key: " + str);
    }

    public <T> List<T> b(String str, Type type) {
        String h16 = k.a().h(str, "");
        if (TextUtils.isEmpty(h16)) {
            return Collections.emptyList();
        }
        return (List) this.f425344a.fromJson(h16, type);
    }

    public <T> void c(String str, Type type, List<T> list) {
        int size;
        if (TextUtils.isEmpty(str)) {
            QLog.d("QFSReportCache", 1, "[saveHistoryToLocal] save history key not is empty.");
            return;
        }
        String json = this.f425344a.toJson(list, type);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[saveHistoryToLocal] list size: ");
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        sb5.append(" | type: ");
        sb5.append(type);
        QLog.d("QFSReportCache", 1, sb5.toString());
        k.a().p(str, json);
    }
}
