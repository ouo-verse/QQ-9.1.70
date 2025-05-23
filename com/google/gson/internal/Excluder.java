package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = -1.0d;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    private boolean isAnonymousOrLocal(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        return false;
    }

    private boolean isInnerClass(Class<?> cls) {
        if (cls.isMemberClass() && !isStatic(cls)) {
            return true;
        }
        return false;
    }

    private boolean isStatic(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean isValidSince(Since since) {
        if (since != null && since.value() > this.version) {
            return false;
        }
        return true;
    }

    private boolean isValidUntil(Until until) {
        if (until != null && until.value() <= this.version) {
            return false;
        }
        return true;
    }

    private boolean isValidVersion(Since since, Until until) {
        if (isValidSince(since) && isValidUntil(until)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean excludeClass = excludeClass(rawType, true);
        final boolean excludeClass2 = excludeClass(rawType, false);
        if (!excludeClass && !excludeClass2) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
            private TypeAdapter<T> delegate;

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter == null) {
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
                return typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T read2(JsonReader jsonReader) throws IOException {
                if (excludeClass2) {
                    jsonReader.skipValue();
                    return null;
                }
                return delegate().read2(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t16) throws IOException {
                if (excludeClass) {
                    jsonWriter.nullValue();
                } else {
                    delegate().write(jsonWriter, t16);
                }
            }
        };
    }

    public Excluder disableInnerClassSerialization() {
        Excluder m45clone = m45clone();
        m45clone.serializeInnerClasses = false;
        return m45clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z16) {
        List<ExclusionStrategy> list;
        if (this.version != -1.0d && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls)) {
            return true;
        }
        if (z16) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean excludeField(Field field, boolean z16) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != -1.0d && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z16 ? !expose.deserialize() : !expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        if (z16) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            Iterator<ExclusionStrategy> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder m45clone = m45clone();
        m45clone.requireExpose = true;
        return m45clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z16, boolean z17) {
        Excluder m45clone = m45clone();
        if (z16) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            m45clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z17) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            m45clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return m45clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder m45clone = m45clone();
        m45clone.modifiers = 0;
        for (int i3 : iArr) {
            m45clone.modifiers = i3 | m45clone.modifiers;
        }
        return m45clone;
    }

    public Excluder withVersion(double d16) {
        Excluder m45clone = m45clone();
        m45clone.version = d16;
        return m45clone;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m45clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e16) {
            throw new AssertionError(e16);
        }
    }
}
