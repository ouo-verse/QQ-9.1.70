package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ca {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f35789b = Logger.getLogger(ca.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Descriptors.b> f35790a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ca f35791a = new ca(Collections.emptyMap());
    }

    ca(Map<String, Descriptors.b> map) {
        this.f35790a = map;
    }

    public static ca c() {
        return a.f35791a;
    }

    private static String d(String str) throws InvalidProtocolBufferException {
        String[] split = str.split("/");
        if (split.length != 1) {
            return split[split.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: " + str);
    }

    public Descriptors.b a(String str) {
        return this.f35790a.get(str);
    }

    public final Descriptors.b b(String str) throws InvalidProtocolBufferException {
        return a(d(str));
    }
}
