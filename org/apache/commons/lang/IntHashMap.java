package org.apache.commons.lang;

/* compiled from: P */
/* loaded from: classes29.dex */
class IntHashMap {
    private transient int count;
    private final float loadFactor;
    private transient Entry[] table;
    private int threshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Entry {
        final int hash;
        final int key;
        Entry next;
        Object value;

        protected Entry(int i3, int i16, Object obj, Entry entry) {
            this.hash = i3;
            this.key = i16;
            this.value = obj;
            this.next = entry;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public synchronized void clear() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                entryArr[length] = null;
            } else {
                this.count = 0;
            }
        }
    }

    public boolean contains(Object obj) {
        obj.getClass();
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            int i3 = length - 1;
            if (length > 0) {
                for (Entry entry = entryArr[i3]; entry != null; entry = entry.next) {
                    if (entry.value.equals(obj)) {
                        return true;
                    }
                }
                length = i3;
            } else {
                return false;
            }
        }
    }

    public boolean containsKey(int i3) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i3) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i3) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public Object get(int i3) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i3) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i3) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (this.count == 0) {
            return true;
        }
        return false;
    }

    public Object put(int i3, Object obj) {
        Entry[] entryArr = this.table;
        int i16 = Integer.MAX_VALUE & i3;
        int length = i16 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
            if (entry.hash == i3) {
                Object obj2 = entry.value;
                entry.value = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            entryArr = this.table;
            length = i16 % entryArr.length;
        }
        entryArr[length] = new Entry(i3, i3, obj, entryArr[length]);
        this.count++;
        return null;
    }

    protected void rehash() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        int i3 = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i3];
        this.threshold = (int) (i3 * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i16 = length - 1;
            if (length > 0) {
                Entry entry = entryArr[i16];
                while (entry != null) {
                    Entry entry2 = entry.next;
                    int i17 = (entry.hash & Integer.MAX_VALUE) % i3;
                    entry.next = entryArr2[i17];
                    entryArr2[i17] = entry;
                    entry = entry2;
                }
                length = i16;
            } else {
                return;
            }
        }
    }

    public Object remove(int i3) {
        Entry[] entryArr = this.table;
        int length = (Integer.MAX_VALUE & i3) % entryArr.length;
        Entry entry = null;
        for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.next) {
            if (entry2.hash == i3) {
                if (entry != null) {
                    entry.next = entry2.next;
                } else {
                    entryArr[length] = entry2.next;
                }
                this.count--;
                Object obj = entry2.value;
                entry2.value = null;
                return obj;
            }
            entry = entry2;
        }
        return null;
    }

    public int size() {
        return this.count;
    }

    public IntHashMap(int i3) {
        this(i3, 0.75f);
    }

    public IntHashMap(int i3, float f16) {
        if (i3 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Illegal Capacity: ");
            stringBuffer.append(i3);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        if (f16 > 0.0f) {
            i3 = i3 == 0 ? 1 : i3;
            this.loadFactor = f16;
            this.table = new Entry[i3];
            this.threshold = (int) (i3 * f16);
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Illegal Load: ");
        stringBuffer2.append(f16);
        throw new IllegalArgumentException(stringBuffer2.toString());
    }
}
