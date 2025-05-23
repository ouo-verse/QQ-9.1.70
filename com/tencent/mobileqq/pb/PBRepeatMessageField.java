package com.tencent.mobileqq.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes16.dex */
public final class PBRepeatMessageField<T extends MessageMicro<T>> extends PBField<List<T>> {
    private final Class<T> helper;
    private List<T> value = Collections.emptyList();

    public PBRepeatMessageField(Class<T> cls) {
        this.helper = cls;
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
        PBRepeatMessageField pBRepeatMessageField = (PBRepeatMessageField) pBField;
        if (pBRepeatMessageField.isEmpty()) {
            this.value = Collections.emptyList();
            return;
        }
        List<T> list = get();
        Class<?> cls = pBRepeatMessageField.get(0).getClass();
        int size = pBRepeatMessageField.value.size() - list.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    list.add((MessageMicro) cls.newInstance());
                } catch (IllegalAccessException | InstantiationException e16) {
                    e16.printStackTrace();
                }
            }
        } else if (size < 0) {
            list.subList(-size, list.size()).clear();
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            ((MessageMicro) list.get(i16)).copyFrom(pBRepeatMessageField.value.get(i16));
        }
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
        try {
            T newInstance = this.helper.newInstance();
            codedInputStreamMicro.readMessage(newInstance);
            add(newInstance);
        } catch (IllegalAccessException | InstantiationException e16) {
            e16.printStackTrace();
        }
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
        int i16 = 0;
        for (T t16 : list) {
            i16 += t16.computeSizeDirectly(i3, t16);
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
        for (T t16 : list) {
            t16.writeToDirectly(codedOutputStreamMicro, i3, t16);
        }
    }
}
