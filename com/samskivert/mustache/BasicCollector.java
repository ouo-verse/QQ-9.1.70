package com.samskivert.mustache;

import com.samskivert.mustache.Mustache;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BasicCollector implements Mustache.Collector {
    protected static final Mustache.VariableFetcher CUSTOM_FETCHER = new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.BasicCollector.2
        @Override // com.samskivert.mustache.Mustache.VariableFetcher
        public Object get(Object obj, String str) throws Exception {
            Object obj2 = ((Mustache.CustomContext) obj).get(str);
            if (obj2 == null) {
                return Template.NO_FETCHER_FOUND;
            }
            return obj2;
        }

        public String toString() {
            return "CUSTOM_FETCHER";
        }
    };
    protected static final Mustache.VariableFetcher MAP_FETCHER = new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.BasicCollector.3
        @Override // com.samskivert.mustache.Mustache.VariableFetcher
        public Object get(Object obj, String str) throws Exception {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            if ("entrySet".equals(str)) {
                return map.entrySet();
            }
            return Template.NO_FETCHER_FOUND;
        }

        public String toString() {
            return "MAP_FETCHER";
        }
    };
    protected static final Mustache.VariableFetcher LIST_FETCHER = new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.BasicCollector.4
        @Override // com.samskivert.mustache.Mustache.VariableFetcher
        public Object get(Object obj, String str) throws Exception {
            try {
                return ((List) obj).get(Integer.parseInt(str));
            } catch (IndexOutOfBoundsException unused) {
                return Template.NO_FETCHER_FOUND;
            } catch (NumberFormatException unused2) {
                return Template.NO_FETCHER_FOUND;
            }
        }

        public String toString() {
            return "LIST_FETCHER";
        }
    };
    protected static final Mustache.VariableFetcher ITER_FETCHER = new Mustache.VariableFetcher() { // from class: com.samskivert.mustache.BasicCollector.5
        @Override // com.samskivert.mustache.Mustache.VariableFetcher
        public Object get(Object obj, String str) throws Exception {
            try {
                Iterator it = (Iterator) obj;
                int parseInt = Integer.parseInt(str);
                for (int i3 = 0; i3 < parseInt; i3++) {
                    it.next();
                }
                return it.next();
            } catch (NumberFormatException unused) {
                return Template.NO_FETCHER_FOUND;
            } catch (NoSuchElementException unused2) {
                return Template.NO_FETCHER_FOUND;
            }
        }

        public String toString() {
            return "ITER_FETCHER";
        }
    };
    protected static final ArrayHelper OBJECT_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.6
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return ((Object[]) obj)[i3];
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((Object[]) obj).length;
        }
    };
    protected static final ArrayHelper BOOLEAN_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.7
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Boolean.valueOf(((boolean[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((boolean[]) obj).length;
        }
    };
    protected static final ArrayHelper BYTE_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.8
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Byte.valueOf(((byte[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((byte[]) obj).length;
        }
    };
    protected static final ArrayHelper CHAR_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.9
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Character.valueOf(((char[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((char[]) obj).length;
        }
    };
    protected static final ArrayHelper SHORT_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.10
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Short.valueOf(((short[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((short[]) obj).length;
        }
    };
    protected static final ArrayHelper INT_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.11
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Integer.valueOf(((int[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((int[]) obj).length;
        }
    };
    protected static final ArrayHelper LONG_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.12
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Long.valueOf(((long[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((long[]) obj).length;
        }
    };
    protected static final ArrayHelper FLOAT_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.13
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Float.valueOf(((float[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((float[]) obj).length;
        }
    };
    protected static final ArrayHelper DOUBLE_ARRAY_HELPER = new ArrayHelper() { // from class: com.samskivert.mustache.BasicCollector.14
        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        protected Object get(Object obj, int i3) {
            return Double.valueOf(((double[]) obj)[i3]);
        }

        @Override // com.samskivert.mustache.BasicCollector.ArrayHelper
        public int length(Object obj) {
            return ((double[]) obj).length;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class ArrayHelper implements Mustache.VariableFetcher {
        protected ArrayHelper() {
        }

        protected abstract Object get(Object obj, int i3);

        @Override // com.samskivert.mustache.Mustache.VariableFetcher
        public Object get(Object obj, String str) throws Exception {
            try {
                return get(obj, Integer.parseInt(str));
            } catch (ArrayIndexOutOfBoundsException unused) {
                return Template.NO_FETCHER_FOUND;
            } catch (NumberFormatException unused2) {
                return Template.NO_FETCHER_FOUND;
            }
        }

        public abstract int length(Object obj);
    }

    protected static ArrayHelper arrayHelper(Object obj) {
        if (obj instanceof Object[]) {
            return OBJECT_ARRAY_HELPER;
        }
        if (obj instanceof boolean[]) {
            return BOOLEAN_ARRAY_HELPER;
        }
        if (obj instanceof byte[]) {
            return BYTE_ARRAY_HELPER;
        }
        if (obj instanceof char[]) {
            return CHAR_ARRAY_HELPER;
        }
        if (obj instanceof short[]) {
            return SHORT_ARRAY_HELPER;
        }
        if (obj instanceof int[]) {
            return INT_ARRAY_HELPER;
        }
        if (obj instanceof long[]) {
            return LONG_ARRAY_HELPER;
        }
        if (obj instanceof float[]) {
            return FLOAT_ARRAY_HELPER;
        }
        if (obj instanceof double[]) {
            return DOUBLE_ARRAY_HELPER;
        }
        return null;
    }

    @Override // com.samskivert.mustache.Mustache.Collector
    public Mustache.VariableFetcher createFetcher(Object obj, String str) {
        if (obj instanceof Mustache.CustomContext) {
            return CUSTOM_FETCHER;
        }
        if (obj instanceof Map) {
            return MAP_FETCHER;
        }
        char charAt = str.charAt(0);
        if (charAt >= '0' && charAt <= '9') {
            if (obj instanceof List) {
                return LIST_FETCHER;
            }
            if (obj instanceof Iterator) {
                return ITER_FETCHER;
            }
            if (obj.getClass().isArray()) {
                return arrayHelper(obj);
            }
            return null;
        }
        return null;
    }

    @Override // com.samskivert.mustache.Mustache.Collector
    public abstract <K, V> Map<K, V> createFetcherCache();

    @Override // com.samskivert.mustache.Mustache.Collector
    public Iterator<?> toIterator(Object obj) {
        if (obj instanceof Iterable) {
            return ((Iterable) obj).iterator();
        }
        if (obj instanceof Iterator) {
            return (Iterator) obj;
        }
        if (obj.getClass().isArray()) {
            return new Iterator<Object>(arrayHelper(obj), obj) { // from class: com.samskivert.mustache.BasicCollector.1
                private int _count;
                private int _idx;
                final /* synthetic */ ArrayHelper val$helper;
                final /* synthetic */ Object val$value;

                {
                    this.val$helper = r2;
                    this.val$value = obj;
                    this._count = r2.length(obj);
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this._idx < this._count) {
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public Object next() {
                    ArrayHelper arrayHelper = this.val$helper;
                    Object obj2 = this.val$value;
                    int i3 = this._idx;
                    this._idx = i3 + 1;
                    return arrayHelper.get(obj2, i3);
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
        return null;
    }
}
