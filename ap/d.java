package ap;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected final ConcurrentHashMap<String, String> f26637a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected final ConcurrentHashMap<String, Object> f26638b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected final ConcurrentHashMap<String, Object> f26639c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    protected final ConcurrentHashMap<String, Object> f26640d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    protected String f26641e = "UTF-8";

    public d(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                g(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpEntity a() {
        try {
            return new UrlEncodedFormEntity(d(), this.f26641e);
        } catch (UnsupportedEncodingException e16) {
            Log.e("RequestParams", "createFormEntity failed", e16);
            return null;
        }
    }

    private List<BasicNameValuePair> e(String str, Object obj) {
        Object obj2;
        String format;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    if (str == null) {
                        format = (String) obj3;
                    } else {
                        format = String.format("%s[%s]", str, obj3);
                    }
                    linkedList.addAll(e(format, obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                linkedList.addAll(e(String.format("%s[%d]", str, Integer.valueOf(i3)), list.get(i3)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                linkedList.addAll(e(String.format("%s[%d]", str, Integer.valueOf(i16)), objArr[i16]));
            }
        } else if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedList.addAll(e(str, it.next()));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    public HttpEntity b(e eVar) throws IOException {
        return a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return URLEncodedUtils.format(d(), this.f26641e);
    }

    protected List<BasicNameValuePair> d() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.f26637a.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(e(null, this.f26640d));
        return linkedList;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f26637a.entrySet()) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(entry.getValue());
        }
        for (Map.Entry<String, Object> entry2 : this.f26638b.entrySet()) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(entry2.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append("STREAM");
        }
        for (Map.Entry<String, Object> entry3 : this.f26639c.entrySet()) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(entry3.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append("FILE");
        }
        for (BasicNameValuePair basicNameValuePair : e(null, this.f26640d)) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(basicNameValuePair.getName());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(basicNameValuePair.getValue());
        }
        return sb5.toString();
    }

    public void f(String str, int i3) {
        if (str != null) {
            this.f26637a.put(str, String.valueOf(i3));
        }
    }

    public void g(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f26637a.put(str, str2);
    }
}
