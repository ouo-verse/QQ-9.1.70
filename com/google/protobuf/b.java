package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.au;
import com.google.protobuf.b;
import com.google.protobuf.b.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements au {
    protected int memoizedHashCode = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements au.a {
        /* JADX INFO: Access modifiers changed from: protected */
        @Deprecated
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t16 : iterable) {
                if (t16 == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t16);
            }
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException newUninitializedMessageException(au auVar) {
            return new UninitializedMessageException(auVar);
        }

        @Override // 
        /* renamed from: clone */
        public abstract BuilderType mo50clone();

        protected abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0253a(inputStream, k.C(read, inputStream)), tVar);
            return true;
        }

        @Override // com.google.protobuf.au.a
        public abstract BuilderType mergeFrom(k kVar, t tVar) throws IOException;

        protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            ad.a(iterable);
            if (iterable instanceof ah) {
                List<?> underlyingElements = ((ah) iterable).getUnderlyingElements();
                ah ahVar = (ah) list;
                int size = list.size();
                for (Object obj : underlyingElements) {
                    if (obj == null) {
                        String str = "Element at index " + (ahVar.size() - size) + " is null.";
                        for (int size2 = ahVar.size() - 1; size2 >= size; size2--) {
                            ahVar.remove(size2);
                        }
                        throw new NullPointerException(str);
                    }
                    if (obj instanceof ByteString) {
                        ahVar.f((ByteString) obj);
                    } else {
                        ahVar.add((String) obj);
                    }
                }
                return;
            }
            if (iterable instanceof bh) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.google.protobuf.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0253a extends FilterInputStream {

            /* renamed from: d, reason: collision with root package name */
            private int f35711d;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0253a(InputStream inputStream, int i3) {
                super(inputStream);
                this.f35711d = i3;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f35711d);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f35711d <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f35711d--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j3) throws IOException {
                long skip = super.skip(Math.min(j3, this.f35711d));
                if (skip >= 0) {
                    this.f35711d = (int) (this.f35711d - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i3, int i16) throws IOException {
                int i17 = this.f35711d;
                if (i17 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i3, Math.min(i16, i17));
                if (read >= 0) {
                    this.f35711d -= read;
                }
                return read;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, t.b());
        }

        @Override // 
        public BuilderType mergeFrom(k kVar) throws IOException {
            return mergeFrom(kVar, t.b());
        }

        @Override // com.google.protobuf.ar.a
        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                k newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput);
                newCodedInput.a(0);
                return this;
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (IOException e17) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e17);
            }
        }

        @Override // com.google.protobuf.ar.a
        public BuilderType mergeFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            try {
                k newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput, tVar);
                newCodedInput.a(0);
                return this;
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (IOException e17) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e17);
            }
        }

        @Override // com.google.protobuf.au.a
        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return mo58mergeFrom(bArr, 0, bArr.length);
        }

        @Override // 
        /* renamed from: mergeFrom */
        public BuilderType mo58mergeFrom(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferException {
            try {
                k l3 = k.l(bArr, i3, i16);
                mergeFrom(l3);
                l3.a(0);
                return this;
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (IOException e17) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e17);
            }
        }

        @Override // 
        public BuilderType mergeFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return mo59mergeFrom(bArr, 0, bArr.length, tVar);
        }

        @Override // 
        /* renamed from: mergeFrom */
        public BuilderType mo59mergeFrom(byte[] bArr, int i3, int i16, t tVar) throws InvalidProtocolBufferException {
            try {
                k l3 = k.l(bArr, i3, i16);
                mergeFrom(l3, tVar);
                l3.a(0);
                return this;
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (IOException e17) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e17);
            }
        }

        @Override // 
        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            k g16 = k.g(inputStream);
            mergeFrom(g16);
            g16.a(0);
            return this;
        }

        @Override // 
        public BuilderType mergeFrom(InputStream inputStream, t tVar) throws IOException {
            k g16 = k.g(inputStream);
            mergeFrom(g16, tVar);
            g16.a(0);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.au.a
        public BuilderType mergeFrom(au auVar) {
            if (getDefaultInstanceForType().getClass().isInstance(auVar)) {
                return (BuilderType) internalMergeFrom((b) auVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        a.addAll((Iterable) iterable, (List) collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (byteString.isValidUtf8()) {
        } else {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSerializedSize(bq bqVar) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize == -1) {
            int h16 = bqVar.h(this);
            setMemoizedSerializedSize(h16);
            return h16;
        }
        return memoizedSerializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    void setMemoizedSerializedSize(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.au
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream i06 = CodedOutputStream.i0(bArr);
            writeTo(i06);
            i06.d();
            return bArr;
        } catch (IOException e16) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e16);
        }
    }

    @Override // com.google.protobuf.au
    public ByteString toByteString() {
        try {
            ByteString.g newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.b());
            return newCodedBuilder.a();
        } catch (IOException e16) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e16);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream h06 = CodedOutputStream.h0(outputStream, CodedOutputStream.K(CodedOutputStream.M(serializedSize) + serializedSize));
        h06.P0(serializedSize);
        writeTo(h06);
        h06.e0();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream h06 = CodedOutputStream.h0(outputStream, CodedOutputStream.K(getSerializedSize()));
        writeTo(h06);
        h06.e0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        a.addAll((Iterable) iterable, (List) list);
    }
}
