package com.tencent.ecommerce.richtext.utils;

import android.support.annotation.NonNull;
import com.tencent.ecommerce.richtext.utils.FunctionParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d<V> extends FunctionParser<String, List<V>> {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements FunctionParser.c<String, List<V>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f105495a;

        a(c cVar) {
            this.f105495a = cVar;
        }

        @Override // com.tencent.ecommerce.richtext.utils.FunctionParser.c
        public Map<String, List<V>> a(String str, List<String> list) {
            HashMap hashMap = new HashMap();
            LinkedList linkedList = new LinkedList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                linkedList.add(this.f105495a.a(it.next()));
            }
            hashMap.put(str, linkedList);
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements FunctionParser.c<String, List<V>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1112d f105496a;

        b(InterfaceC1112d interfaceC1112d) {
            this.f105496a = interfaceC1112d;
        }

        @Override // com.tencent.ecommerce.richtext.utils.FunctionParser.c
        public Map<String, List<V>> a(String str, List<String> list) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, this.f105496a.a(list));
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c<V> {
        V a(String str);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.ecommerce.richtext.utils.d$d, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1112d<V> {
        List<V> a(List<String> list);
    }

    public d(@NonNull String str, @NonNull c<V> cVar) {
        super(str, new a(cVar));
    }

    public List<V> e(String str) {
        LinkedHashMap<String, V> d16 = d();
        if (d16.containsKey(str)) {
            return (List) d16.get(str);
        }
        return null;
    }

    public d(@NonNull String str, @NonNull InterfaceC1112d<V> interfaceC1112d) {
        super(str, new b(interfaceC1112d));
    }
}
