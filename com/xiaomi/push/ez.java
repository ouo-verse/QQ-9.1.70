package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ez implements fd {

    /* renamed from: a, reason: collision with root package name */
    private String f388791a;

    /* renamed from: b, reason: collision with root package name */
    private String f388792b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f388793c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f388794d;

    /* renamed from: e, reason: collision with root package name */
    private String f388795e;

    /* renamed from: f, reason: collision with root package name */
    private List<ez> f388796f;

    public ez(String str, String str2, String[] strArr, String[] strArr2) {
        this.f388796f = null;
        this.f388791a = str;
        this.f388792b = str2;
        this.f388793c = strArr;
        this.f388794d = strArr2;
    }

    public static ez c(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i3 = 0;
        for (String str : keySet) {
            strArr[i3] = str;
            strArr2[i3] = bundle2.getString(str);
            i3++;
        }
        if (bundle.containsKey(Node.CHILDREN_ATTR)) {
            Parcelable[] parcelableArray = bundle.getParcelableArray(Node.CHILDREN_ATTR);
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(c((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new ez(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] h(List<ez> list) {
        return i((ez[]) list.toArray(new ez[list.size()]));
    }

    public static Parcelable[] i(ez[] ezVarArr) {
        if (ezVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[ezVarArr.length];
        for (int i3 = 0; i3 < ezVarArr.length; i3++) {
            parcelableArr[i3] = ezVarArr[i3].b();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f388791a);
        bundle.putString("ext_ns", this.f388792b);
        bundle.putString("ext_text", this.f388795e);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f388793c;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f388793c;
                if (i3 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i3], this.f388794d[i3]);
                i3++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<ez> list = this.f388796f;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray(Node.CHILDREN_ATTR, h(this.f388796f));
        }
        return bundle;
    }

    public Parcelable b() {
        return a();
    }

    @Override // com.xiaomi.push.fd
    public String d() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<");
        sb5.append(this.f388791a);
        if (!TextUtils.isEmpty(this.f388792b)) {
            sb5.append(" ");
            sb5.append("xmlns=");
            sb5.append("\"");
            sb5.append(this.f388792b);
            sb5.append("\"");
        }
        String[] strArr = this.f388793c;
        if (strArr != null && strArr.length > 0) {
            for (int i3 = 0; i3 < this.f388793c.length; i3++) {
                if (!TextUtils.isEmpty(this.f388794d[i3])) {
                    sb5.append(" ");
                    sb5.append(this.f388793c[i3]);
                    sb5.append("=\"");
                    sb5.append(fm.b(this.f388794d[i3]));
                    sb5.append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f388795e)) {
            sb5.append(">");
            sb5.append(this.f388795e);
            sb5.append("</");
            sb5.append(this.f388791a);
            sb5.append(">");
        } else {
            List<ez> list = this.f388796f;
            if (list != null && list.size() > 0) {
                sb5.append(">");
                Iterator<ez> it = this.f388796f.iterator();
                while (it.hasNext()) {
                    sb5.append(it.next().d());
                }
                sb5.append("</");
                sb5.append(this.f388791a);
                sb5.append(">");
            } else {
                sb5.append("/>");
            }
        }
        return sb5.toString();
    }

    public String e() {
        return this.f388791a;
    }

    public String f(String str) {
        if (str != null) {
            if (this.f388793c != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.f388793c;
                    if (i3 < strArr.length) {
                        if (str.equals(strArr[i3])) {
                            return this.f388794d[i3];
                        }
                        i3++;
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f388795e = fm.b(str);
        } else {
            this.f388795e = str;
        }
    }

    public String j() {
        return this.f388792b;
    }

    public String k() {
        if (!TextUtils.isEmpty(this.f388795e)) {
            return fm.e(this.f388795e);
        }
        return this.f388795e;
    }

    public String toString() {
        return d();
    }

    public ez(String str, String str2, String[] strArr, String[] strArr2, String str3, List<ez> list) {
        this.f388791a = str;
        this.f388792b = str2;
        this.f388793c = strArr;
        this.f388794d = strArr2;
        this.f388795e = str3;
        this.f388796f = list;
    }
}
