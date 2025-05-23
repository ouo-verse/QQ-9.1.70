package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.au;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ar extends au, ax {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a extends au.a, ax {
        a addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        ar build();

        ar buildPartial();

        a clearField(Descriptors.FieldDescriptor fieldDescriptor);

        @Override // com.google.protobuf.ax
        Descriptors.b getDescriptorForType();

        a mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        a mergeFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException;

        a mergeFrom(ar arVar);

        a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor);

        a setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        a setUnknownFields(cc ccVar);
    }

    a newBuilderForType();

    a toBuilder();
}
