package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RRset implements Serializable {
    private short position;
    private final ArrayList<Record> rrs;
    private long ttl;

    public RRset() {
        this.rrs = new ArrayList<>(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <X extends Record> void adjustTtl(long j3, List<X> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Record cloneRecord = ((Record) list.get(i3)).cloneRecord();
            cloneRecord.setTTL(j3);
            list.set(i3, cloneRecord);
        }
    }

    private void appendRrList(Iterator<? extends Record> it, StringBuilder sb5) {
        while (it.hasNext()) {
            Record next = it.next();
            sb5.append("[");
            sb5.append(next.rdataToString());
            sb5.append("]");
            if (it.hasNext()) {
                sb5.append(" ");
            }
        }
    }

    private void checkSameRRset(Record record, List<? extends Record> list) {
        if (list.isEmpty() || record.sameRRset(list.get(0))) {
        } else {
            throw new IllegalArgumentException("record does not match rrset");
        }
    }

    public void addRR(Record record) {
        addRR(record, this.rrs);
    }

    public void clear() {
        this.rrs.clear();
    }

    public Record first() {
        if (!this.rrs.isEmpty()) {
            return this.rrs.get(0);
        }
        throw new IllegalStateException("rrset is empty");
    }

    public int getDClass() {
        return first().getDClass();
    }

    public Name getName() {
        return first().getName();
    }

    public long getTTL() {
        return first().getTTL();
    }

    public int getType() {
        return first().getRRsetType();
    }

    public List<Record> rrs(boolean z16) {
        if (z16 && this.rrs.size() > 1) {
            ArrayList arrayList = new ArrayList(this.rrs.size());
            if (this.position == Short.MAX_VALUE) {
                this.position = (short) 0;
            }
            short s16 = this.position;
            this.position = (short) (s16 + 1);
            int size = s16 % this.rrs.size();
            ArrayList<Record> arrayList2 = this.rrs;
            arrayList.addAll(arrayList2.subList(size, arrayList2.size()));
            arrayList.addAll(this.rrs.subList(0, size));
            return arrayList;
        }
        return Collections.unmodifiableList(this.rrs);
    }

    public int size() {
        return this.rrs.size();
    }

    public String toString() {
        if (this.rrs.isEmpty()) {
            return "{empty}";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{ ");
        sb5.append(getName());
        sb5.append(" ");
        sb5.append(getTTL());
        sb5.append(" ");
        sb5.append(DClass.string(getDClass()));
        sb5.append(" ");
        sb5.append(Type.string(getType()));
        sb5.append(" ");
        appendRrList(this.rrs.iterator(), sb5);
        sb5.append(" }");
        return sb5.toString();
    }

    private <X extends Record> void addRR(X x16, List<X> list) {
        if (this.rrs.isEmpty()) {
            list.add(x16);
            this.ttl = x16.getTTL();
            return;
        }
        checkSameRRset(x16, this.rrs);
        if (x16.getTTL() > this.ttl) {
            x16 = (X) x16.cloneRecord();
            x16.setTTL(this.ttl);
        } else if (x16.getTTL() < this.ttl) {
            this.ttl = x16.getTTL();
            adjustTtl(x16.getTTL(), this.rrs);
        }
        if (list.contains(x16)) {
            return;
        }
        list.add(x16);
    }

    public RRset(Record record) {
        this();
        addRR(record);
    }

    public RRset(Record... recordArr) {
        this();
        Objects.requireNonNull(recordArr);
        for (Record record : recordArr) {
            addRR(record);
        }
    }

    public RRset(RRset rRset) {
        this.rrs = new ArrayList<>(rRset.rrs);
        this.position = rRset.position;
        this.ttl = rRset.ttl;
    }

    public List<Record> rrs() {
        return rrs(true);
    }
}
