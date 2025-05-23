package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ax extends av {
    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    ar getDefaultInstanceForType();

    Descriptors.b getDescriptorForType();

    Object getField(Descriptors.FieldDescriptor fieldDescriptor);

    cc getUnknownFields();

    boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);
}
