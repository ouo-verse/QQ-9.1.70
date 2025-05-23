package com.tencent.mobileqq.transfile.http2.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.Headers;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class JavaNetHeaders {
    static IPatchRedirector $redirector_;
    private static final Comparator<String> FIELD_NAME_COMPARATOR;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            FIELD_NAME_COMPARATOR = new Comparator<String>() { // from class: com.tencent.mobileqq.transfile.http2.internal.JavaNetHeaders.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.util.Comparator
                public int compare(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
                    }
                    if (str == str2) {
                        return 0;
                    }
                    if (str == null) {
                        return -1;
                    }
                    if (str2 == null) {
                        return 1;
                    }
                    return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
                }
            };
        }
    }

    JavaNetHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Map<String, List<String>> toMultimap(Headers headers, String str) {
        TreeMap treeMap = new TreeMap(FIELD_NAME_COMPARATOR);
        int size = headers.size();
        for (int i3 = 0; i3 < size; i3++) {
            String name = headers.name(i3);
            String value = headers.value(i3);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(name);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(value);
            treeMap.put(name, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }
}
