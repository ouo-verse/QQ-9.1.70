package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import androidx.annotation.RequiresApi;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes23.dex */
public class Compression {
    private static final int MAX_POINTER = 16383;
    private static final int TABLE_SIZE = 17;
    private final Entry[] table = new Entry[17];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Entry {
        Name name;
        Entry next;
        int pos;

        Entry() {
        }
    }

    public void add(int i3, Name name) {
        if (i3 > MAX_POINTER) {
            return;
        }
        int hashCode = (name.hashCode() & Integer.MAX_VALUE) % 17;
        Entry entry = new Entry();
        entry.name = name;
        entry.pos = i3;
        Entry[] entryArr = this.table;
        entry.next = entryArr[hashCode];
        entryArr[hashCode] = entry;
    }

    public int get(Name name) {
        int i3 = -1;
        for (Entry entry = this.table[(name.hashCode() & Integer.MAX_VALUE) % 17]; entry != null; entry = entry.next) {
            if (entry.name.equals(name)) {
                i3 = entry.pos;
            }
        }
        return i3;
    }
}
