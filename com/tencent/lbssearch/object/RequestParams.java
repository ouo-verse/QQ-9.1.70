package com.tencent.lbssearch.object;

import android.content.ContentValues;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class RequestParams implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected static final String LOG_TAG = "RequestParams";
    private static final long serialVersionUID = 1;
    protected boolean autoCloseInputStreams;
    protected boolean isRepeatable;
    private boolean mIsDebuggable;
    protected final ConcurrentHashMap<String, String> urlParams;
    protected final ConcurrentHashMap<String, Object> urlParamsWithObjects;
    protected boolean useJsonStreamer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public final class a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RequestParams.this);
            }
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    public RequestParams() {
        this((Map<String, String>) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void add(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str != null && str2 != null) {
            Object obj = this.urlParamsWithObjects.get(str);
            if (obj == null) {
                obj = new HashSet();
                put(str, obj);
            }
            if (obj instanceof List) {
                ((List) obj).add(str2);
            } else if (obj instanceof Set) {
                ((Set) obj).add(str2);
            }
        }
    }

    public String getParamString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return Uri.encode(toString(), "=&");
    }

    protected List<ContentValues> getParamsList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        arrayList.addAll(this.urlParams.keySet());
        arrayList.addAll(this.urlParamsWithObjects.keySet());
        Collections.sort(arrayList, new a());
        for (String str : arrayList) {
            String str2 = this.urlParams.get(str);
            if (str2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(str, str2);
                linkedList.add(contentValues);
            } else {
                Object obj = this.urlParamsWithObjects.get(str);
                if (obj != null) {
                    linkedList.addAll(getParamsList(str, obj));
                }
            }
        }
        return linkedList;
    }

    public boolean isDebuggable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mIsDebuggable;
    }

    public void put(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else {
            if (str == null || str2 == null) {
                return;
            }
            this.urlParams.put(str, str2);
        }
    }

    public void remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.urlParams.remove(str);
            this.urlParamsWithObjects.remove(str);
        }
    }

    public void setDebuggable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mIsDebuggable = z16;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        for (ContentValues contentValues : getParamsList()) {
            if (sb5.length() > 0) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                sb5.append(entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.getValue().toString());
            }
        }
        return sb5.toString();
    }

    public RequestParams(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        this.urlParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void put(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, obj);
        } else {
            if (str == null || obj == null) {
                return;
            }
            this.urlParamsWithObjects.put(str, obj);
        }
    }

    public void put(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        } else if (str != null) {
            this.urlParams.put(str, String.valueOf(i3));
        }
    }

    public void put(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3));
        } else if (str != null) {
            this.urlParams.put(str, String.valueOf(j3));
        }
    }

    public RequestParams(String str, String str2) {
        this(new HashMap<String, String>(str, str2) { // from class: com.tencent.lbssearch.object.RequestParams.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f118539a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f118540b;

            {
                this.f118539a = str;
                this.f118540b = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
                } else {
                    put(str, str2);
                }
            }
        });
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
    }

    public RequestParams(Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) objArr);
            return;
        }
        this.urlParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i3 = 0; i3 < length; i3 += 2) {
            put(String.valueOf(objArr[i3]), String.valueOf(objArr[i3 + 1]));
        }
    }

    private List<ContentValues> getParamsList(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    linkedList.addAll(getParamsList(str == null ? (String) obj3 : String.format("%s[%s]", str, obj3), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                linkedList.addAll(getParamsList(String.format("%s[%d]", str, Integer.valueOf(i3)), list.get(i3)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                linkedList.addAll(getParamsList(String.format("%s[%d]", str, Integer.valueOf(i16)), objArr[i16]));
            }
        } else if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                linkedList.addAll(getParamsList(str, it.next()));
            }
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, obj.toString());
            linkedList.add(contentValues);
        }
        return linkedList;
    }
}
