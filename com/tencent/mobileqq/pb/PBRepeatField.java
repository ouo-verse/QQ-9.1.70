package com.tencent.mobileqq.pb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes16.dex */
public final class PBRepeatField<T> extends PBField<List<T>> {
    private final PBField<T> helper;
    private List<T> value = Collections.emptyList();

    public PBRepeatField(PBField<T> pBField) {
        this.helper = pBField;
    }

    public void add(T t16) {
        get().add(t16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<T> collection) {
        get().addAll(collection);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        this.value = Collections.emptyList();
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i3) {
        return computeSizeDirectly(i3, (List) this.value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void copyFrom(PBField<List<T>> pBField) {
        PBRepeatField pBRepeatField = (PBRepeatField) pBField;
        if (pBRepeatField.isEmpty()) {
            this.value = Collections.emptyList();
            return;
        }
        List<T> list = get();
        list.clear();
        list.addAll(pBRepeatField.value);
    }

    public T get(int i3) {
        return this.value.get(i3);
    }

    public boolean has() {
        return !isEmpty();
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        add(this.helper.readFromDirectly(codedInputStreamMicro));
    }

    public void remove(int i3) {
        get().remove(i3);
    }

    public void set(int i3, T t16) {
        this.value.set(i3, t16);
    }

    public int size() {
        return this.value.size();
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i3) throws IOException {
        writeToDirectly(codedOutputStreamMicro, i3, (List) this.value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSizeDirectly(int i3, List<T> list) {
        Iterator<T> it = list.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            i16 += this.helper.computeSizeDirectly(i3, it.next());
        }
        return i16;
    }

    public List<T> get() {
        if (this.value == Collections.emptyList()) {
            this.value = new ArrayList();
        }
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public List<T> readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        throw new RuntimeException("PBRepeatField not support readFromDirectly method.");
    }

    public void set(List<T> list) {
        this.value = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i3, List<T> list) throws IOException {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.helper.writeToDirectly(codedOutputStreamMicro, i3, it.next());
        }
    }
}
