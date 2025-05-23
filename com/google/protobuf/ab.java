package com.google.protobuf;

/* compiled from: P */
/* loaded from: classes2.dex */
class ab implements at {

    /* renamed from: a, reason: collision with root package name */
    private static final ab f35636a = new ab();

    ab() {
    }

    public static ab c() {
        return f35636a;
    }

    @Override // com.google.protobuf.at
    public boolean a(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // com.google.protobuf.at
    public as b(Class<?> cls) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            try {
                return (as) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
            } catch (Exception e16) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e16);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }
}
