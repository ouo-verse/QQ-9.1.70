package com.tencent.ditto.reflect;

import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.utils.DittoLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoFieldValue extends DittoValue {
    String fieldName;
    private List<AbsValueProcessor> processors;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public abstract class AbsValueProcessor {
        AbsValueProcessor() {
        }

        public abstract Object getObjectValue(Object obj);

        public abstract void setValue(Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class FieldValueProcessor extends AbsValueProcessor {
        private String innerFieldName;

        public FieldValueProcessor(String str) {
            super();
            this.innerFieldName = str;
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public Object getObjectValue(Object obj) {
            if ("GLOBAL".equals(this.innerFieldName)) {
                return DittoValue.GLOBAL.getInstance();
            }
            try {
                try {
                    Field declaredField = obj.getClass().getDeclaredField(this.innerFieldName);
                    declaredField.setAccessible(true);
                    return declaredField.get(obj);
                } catch (NullPointerException e16) {
                    throw e16;
                } catch (Exception e17) {
                    DittoLog.e(DittoLog.defaultTag, "mvc err, getting:" + DittoFieldValue.this.fieldName, e17);
                    return null;
                }
            } catch (NoSuchFieldException unused) {
                Method declaredMethod = obj.getClass().getDeclaredMethod(this.innerFieldName, new Class[0]);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, new Object[0]);
            }
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public void setValue(Object obj, Object obj2) {
            if ("GLOBAL".equals(this.innerFieldName)) {
                DittoLog.e(DittoLog.defaultTag, "trying to set value of a constant tpl:" + DittoFieldValue.this.fieldName, new RuntimeException());
                return;
            }
            try {
                Field declaredField = obj.getClass().getDeclaredField(this.innerFieldName);
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
            } catch (NullPointerException e16) {
                throw e16;
            } catch (Exception e17) {
                DittoLog.e(DittoLog.defaultTag, "mvc err, getting:" + DittoFieldValue.this.fieldName, e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ListValueProcessor extends AbsValueProcessor {
        private Integer idx;

        public ListValueProcessor(Integer num) {
            super();
            this.idx = num;
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public Object getObjectValue(Object obj) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (this.idx.intValue() < list.size() && this.idx.intValue() >= 0) {
                    return list.get(this.idx.intValue());
                }
                return null;
            }
            return null;
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public void setValue(Object obj, Object obj2) {
            if (obj instanceof List) {
                List list = (List) obj;
                if (this.idx.intValue() < list.size() && this.idx.intValue() >= 0) {
                    list.set(this.idx.intValue(), obj2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class MapValueProcessor extends AbsValueProcessor {
        private String key;

        public MapValueProcessor(String str) {
            super();
            this.key = str;
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public Object getObjectValue(Object obj) {
            if (obj instanceof Map) {
                return ((Map) obj).get(this.key);
            }
            return null;
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public void setValue(Object obj, Object obj2) {
            if (obj instanceof Map) {
                ((Map) obj).put(this.key, obj2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class StringValueProcessor extends AbsValueProcessor {
        private String value;

        public StringValueProcessor(String str) {
            super();
            this.value = str;
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public Object getObjectValue(Object obj) {
            return this.value;
        }

        @Override // com.tencent.ditto.reflect.DittoFieldValue.AbsValueProcessor
        public void setValue(Object obj, Object obj2) {
            DittoLog.e(DittoLog.defaultTag, "trying to set value of a constant tpl:" + DittoFieldValue.this.fieldName, new RuntimeException());
        }
    }

    private List<String> getFieldTokens(String str) {
        ArrayList arrayList = new ArrayList(3);
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        for (char c16 : str.toCharArray()) {
            if (c16 == '\'') {
                z16 = !z16;
                sb5.append(c16);
            } else if (c16 == ' ' && !z16) {
                if (sb5.length() != 0) {
                    arrayList.add(sb5.toString());
                    sb5 = new StringBuilder();
                }
            } else if (c16 != '[' && c16 != ']' && c16 != '.') {
                sb5.append(c16);
            } else {
                if (sb5.length() != 0) {
                    arrayList.add(sb5.toString());
                    sb5 = new StringBuilder();
                }
                arrayList.add(Character.valueOf(c16).toString());
            }
        }
        if (sb5.length() != 0) {
            arrayList.add(sb5.toString());
        }
        return arrayList;
    }

    private void loadProcessors() {
        if (this.processors == null) {
            List<String> fieldTokens = getFieldTokens(this.fieldName);
            this.processors = new ArrayList();
            while (true) {
                boolean z16 = false;
                for (String str : fieldTokens) {
                    if ("[".equals(str)) {
                        z16 = true;
                    } else if (z16) {
                        try {
                            this.processors.add(new ListValueProcessor(Integer.valueOf(Integer.parseInt(str))));
                        } catch (Throwable unused) {
                            this.processors.add(new MapValueProcessor(str));
                        }
                    } else if (!"]".equals(str) && !".".equals(str)) {
                        this.processors.add(new FieldValueProcessor(str));
                    }
                }
                return;
            }
        }
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public Object getValue(Object obj) {
        loadProcessors();
        Iterator<AbsValueProcessor> it = this.processors.iterator();
        while (it.hasNext()) {
            try {
                obj = it.next().getObjectValue(obj);
            } catch (NullPointerException unused) {
                DittoLog.e(DittoLog.defaultTag, "current template is accessing field of null value, tpl:" + this.fieldName, new RuntimeException());
            }
        }
        return obj;
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, boolean z16) {
        setValue(obj, Boolean.valueOf(z16));
    }

    @Override // com.tencent.ditto.reflect.DittoValue
    public void setValue(Object obj, String str) {
        setValue(obj, (Object) str);
    }

    private void setValue(Object obj, Object obj2) {
        loadProcessors();
        List<AbsValueProcessor> list = this.processors;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<AbsValueProcessor> it = this.processors.iterator();
        Object obj3 = obj;
        while (it.hasNext()) {
            try {
                obj3 = obj;
                obj = it.next().getObjectValue(obj);
            } catch (NullPointerException unused) {
                DittoLog.e(DittoLog.defaultTag, "current template is accessing field of null value, tpl:" + this.fieldName, new RuntimeException());
            }
        }
        obj = obj3;
        AbsValueProcessor absValueProcessor = this.processors.get(r0.size() - 1);
        if (absValueProcessor == null || obj == null) {
            return;
        }
        absValueProcessor.setValue(obj, obj2);
    }
}
