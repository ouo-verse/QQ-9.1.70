package org.jf.dexlib2.dexbacked.util;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBackedMethod;
import org.jf.dexlib2.dexbacked.DexBackedMethodImplementation;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.debug.EndLocal;
import org.jf.dexlib2.iface.debug.LocalInfo;
import org.jf.dexlib2.immutable.debug.ImmutableEndLocal;
import org.jf.dexlib2.immutable.debug.ImmutableEpilogueBegin;
import org.jf.dexlib2.immutable.debug.ImmutableLineNumber;
import org.jf.dexlib2.immutable.debug.ImmutablePrologueEnd;
import org.jf.dexlib2.immutable.debug.ImmutableRestartLocal;
import org.jf.dexlib2.immutable.debug.ImmutableSetSourceFile;
import org.jf.dexlib2.immutable.debug.ImmutableStartLocal;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DebugInfo implements Iterable<DebugItem> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DebugInfoImpl extends DebugInfo {
        private static final LocalInfo EMPTY_LOCAL_INFO = new LocalInfo() { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.1
            @Override // org.jf.dexlib2.iface.debug.LocalInfo
            @Nullable
            public String getName() {
                return null;
            }

            @Override // org.jf.dexlib2.iface.debug.LocalInfo
            @Nullable
            public String getSignature() {
                return null;
            }

            @Override // org.jf.dexlib2.iface.debug.LocalInfo
            @Nullable
            public String getType() {
                return null;
            }
        };
        private final int debugInfoOffset;

        @Nonnull
        public final DexBackedDexFile dexFile;

        @Nonnull
        private final DexBackedMethodImplementation methodImpl;

        public DebugInfoImpl(@Nonnull DexBackedDexFile dexBackedDexFile, int i3, @Nonnull DexBackedMethodImplementation dexBackedMethodImplementation) {
            this.dexFile = dexBackedDexFile;
            this.debugInfoOffset = i3;
            this.methodImpl = dexBackedMethodImplementation;
        }

        @Override // org.jf.dexlib2.dexbacked.util.DebugInfo
        public int getSize() {
            Iterator<DebugItem> it = iterator();
            while (it.hasNext()) {
                it.next();
            }
            return ((VariableSizeLookaheadIterator) it).getReaderOffset() - this.debugInfoOffset;
        }

        @Override // java.lang.Iterable
        @Nonnull
        public Iterator<DebugItem> iterator() {
            LocalInfo localInfo;
            String type;
            DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(this.debugInfoOffset);
            int readBigUleb128 = readerAt.readBigUleb128();
            int registerCount = this.methodImpl.getRegisterCount();
            LocalInfo[] localInfoArr = new LocalInfo[registerCount];
            Arrays.fill(localInfoArr, EMPTY_LOCAL_INFO);
            DexBackedMethod dexBackedMethod = this.methodImpl.method;
            ParameterIterator parameterIterator = new ParameterIterator(dexBackedMethod.getParameterTypes(), dexBackedMethod.getParameterAnnotations(), getParameterNames((DexReader) readerAt));
            int i3 = 0;
            if (!AccessFlags.STATIC.isSet(this.methodImpl.method.getAccessFlags())) {
                localInfoArr[0] = new LocalInfo() { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.2
                    @Override // org.jf.dexlib2.iface.debug.LocalInfo
                    public String getName() {
                        return "this";
                    }

                    @Override // org.jf.dexlib2.iface.debug.LocalInfo
                    public String getSignature() {
                        return null;
                    }

                    @Override // org.jf.dexlib2.iface.debug.LocalInfo
                    public String getType() {
                        return DebugInfoImpl.this.methodImpl.method.getDefiningClass();
                    }
                };
                i3 = 1;
            }
            while (parameterIterator.hasNext()) {
                localInfoArr[i3] = parameterIterator.next();
                i3++;
            }
            if (i3 < registerCount) {
                int i16 = registerCount - 1;
                while (true) {
                    i3--;
                    if (i3 <= -1 || ((type = (localInfo = localInfoArr[i3]).getType()) != null && ((type.equals("J") || type.equals("D")) && i16 - 1 == i3))) {
                        break;
                    }
                    localInfoArr[i16] = localInfo;
                    localInfoArr[i3] = EMPTY_LOCAL_INFO;
                    i16--;
                }
            }
            return new VariableSizeLookaheadIterator<DebugItem>(this.dexFile.getDataBuffer(), readerAt.getOffset(), readBigUleb128, localInfoArr) { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.3
                private int codeAddress = 0;
                private int lineNumber;
                final /* synthetic */ int val$lineNumberStart;
                final /* synthetic */ LocalInfo[] val$locals;

                {
                    this.val$lineNumberStart = readBigUleb128;
                    this.val$locals = localInfoArr;
                    this.lineNumber = readBigUleb128;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x009d  */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeLookaheadIterator
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public DebugItem readNextItem(@Nonnull DexReader dexReader) {
                    LocalInfo localInfo2;
                    LocalInfo localInfo3;
                    while (true) {
                        int readUbyte = dexReader.readUbyte();
                        boolean z16 = true;
                        switch (readUbyte) {
                            case 0:
                                return endOfData();
                            case 1:
                                this.codeAddress += dexReader.readSmallUleb128();
                                break;
                            case 2:
                                this.lineNumber += dexReader.readSleb128();
                                break;
                            case 3:
                                int readSmallUleb128 = dexReader.readSmallUleb128();
                                ImmutableStartLocal immutableStartLocal = new ImmutableStartLocal(this.codeAddress, readSmallUleb128, DebugInfoImpl.this.dexFile.getStringSection().getOptional(dexReader.readSmallUleb128() - 1), DebugInfoImpl.this.dexFile.getTypeSection().getOptional(dexReader.readSmallUleb128() - 1), null);
                                if (readSmallUleb128 >= 0) {
                                    LocalInfo[] localInfoArr2 = this.val$locals;
                                    if (readSmallUleb128 < localInfoArr2.length) {
                                        localInfoArr2[readSmallUleb128] = immutableStartLocal;
                                    }
                                }
                                return immutableStartLocal;
                            case 4:
                                int readSmallUleb1282 = dexReader.readSmallUleb128();
                                ImmutableStartLocal immutableStartLocal2 = new ImmutableStartLocal(this.codeAddress, readSmallUleb1282, DebugInfoImpl.this.dexFile.getStringSection().getOptional(dexReader.readSmallUleb128() - 1), DebugInfoImpl.this.dexFile.getTypeSection().getOptional(dexReader.readSmallUleb128() - 1), DebugInfoImpl.this.dexFile.getStringSection().getOptional(dexReader.readSmallUleb128() - 1));
                                if (readSmallUleb1282 >= 0) {
                                    LocalInfo[] localInfoArr3 = this.val$locals;
                                    if (readSmallUleb1282 < localInfoArr3.length) {
                                        localInfoArr3[readSmallUleb1282] = immutableStartLocal2;
                                    }
                                }
                                return immutableStartLocal2;
                            case 5:
                                int readSmallUleb1283 = dexReader.readSmallUleb128();
                                boolean z17 = false;
                                if (readSmallUleb1283 >= 0) {
                                    LocalInfo[] localInfoArr4 = this.val$locals;
                                    if (readSmallUleb1283 < localInfoArr4.length) {
                                        localInfo2 = localInfoArr4[readSmallUleb1283];
                                        if (localInfo2 instanceof EndLocal) {
                                            z17 = z16;
                                        } else {
                                            localInfo2 = DebugInfoImpl.EMPTY_LOCAL_INFO;
                                        }
                                        ImmutableEndLocal immutableEndLocal = new ImmutableEndLocal(this.codeAddress, readSmallUleb1283, localInfo2.getName(), localInfo2.getType(), localInfo2.getSignature());
                                        if (z17) {
                                            this.val$locals[readSmallUleb1283] = immutableEndLocal;
                                        }
                                        return immutableEndLocal;
                                    }
                                }
                                localInfo2 = DebugInfoImpl.EMPTY_LOCAL_INFO;
                                z16 = false;
                                if (localInfo2 instanceof EndLocal) {
                                }
                                ImmutableEndLocal immutableEndLocal2 = new ImmutableEndLocal(this.codeAddress, readSmallUleb1283, localInfo2.getName(), localInfo2.getType(), localInfo2.getSignature());
                                if (z17) {
                                }
                                return immutableEndLocal2;
                            case 6:
                                int readSmallUleb1284 = dexReader.readSmallUleb128();
                                if (readSmallUleb1284 >= 0) {
                                    LocalInfo[] localInfoArr5 = this.val$locals;
                                    if (readSmallUleb1284 < localInfoArr5.length) {
                                        localInfo3 = localInfoArr5[readSmallUleb1284];
                                        ImmutableRestartLocal immutableRestartLocal = new ImmutableRestartLocal(this.codeAddress, readSmallUleb1284, localInfo3.getName(), localInfo3.getType(), localInfo3.getSignature());
                                        if (readSmallUleb1284 >= 0) {
                                            LocalInfo[] localInfoArr6 = this.val$locals;
                                            if (readSmallUleb1284 < localInfoArr6.length) {
                                                localInfoArr6[readSmallUleb1284] = immutableRestartLocal;
                                            }
                                        }
                                        return immutableRestartLocal;
                                    }
                                }
                                localInfo3 = DebugInfoImpl.EMPTY_LOCAL_INFO;
                                ImmutableRestartLocal immutableRestartLocal2 = new ImmutableRestartLocal(this.codeAddress, readSmallUleb1284, localInfo3.getName(), localInfo3.getType(), localInfo3.getSignature());
                                if (readSmallUleb1284 >= 0) {
                                }
                                return immutableRestartLocal2;
                            case 7:
                                return new ImmutablePrologueEnd(this.codeAddress);
                            case 8:
                                return new ImmutableEpilogueBegin(this.codeAddress);
                            case 9:
                                return new ImmutableSetSourceFile(this.codeAddress, DebugInfoImpl.this.dexFile.getStringSection().getOptional(dexReader.readSmallUleb128() - 1));
                            default:
                                this.codeAddress += (readUbyte - 10) / 15;
                                this.lineNumber += (r0 % 15) - 4;
                                return new ImmutableLineNumber(this.codeAddress, this.lineNumber);
                        }
                    }
                }
            };
        }

        @Override // org.jf.dexlib2.dexbacked.util.DebugInfo
        @Nonnull
        public VariableSizeIterator<String> getParameterNames(@Nullable DexReader dexReader) {
            if (dexReader == null) {
                dexReader = this.dexFile.getDataBuffer().readerAt(this.debugInfoOffset);
                dexReader.skipUleb128();
            }
            return new VariableSizeIterator<String>(dexReader, dexReader.readSmallUleb128()) { // from class: org.jf.dexlib2.dexbacked.util.DebugInfo.DebugInfoImpl.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeIterator
                public String readNextItem(@Nonnull DexReader dexReader2, int i3) {
                    return DebugInfoImpl.this.dexFile.getStringSection().getOptional(dexReader2.readSmallUleb128() - 1);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class EmptyDebugInfo extends DebugInfo {
        public static final EmptyDebugInfo INSTANCE = new EmptyDebugInfo();

        EmptyDebugInfo() {
        }

        @Override // org.jf.dexlib2.dexbacked.util.DebugInfo
        @Nonnull
        public Iterator<String> getParameterNames(@Nullable DexReader dexReader) {
            return ImmutableSet.of().iterator();
        }

        @Override // org.jf.dexlib2.dexbacked.util.DebugInfo
        public int getSize() {
            return 0;
        }

        @Override // java.lang.Iterable
        @Nonnull
        public Iterator<DebugItem> iterator() {
            return ImmutableSet.of().iterator();
        }
    }

    public static DebugInfo newOrEmpty(@Nonnull DexBackedDexFile dexBackedDexFile, int i3, @Nonnull DexBackedMethodImplementation dexBackedMethodImplementation) {
        if (i3 == 0) {
            return EmptyDebugInfo.INSTANCE;
        }
        return new DebugInfoImpl(dexBackedDexFile, i3, dexBackedMethodImplementation);
    }

    @Nonnull
    public abstract Iterator<String> getParameterNames(@Nullable DexReader dexReader);

    public abstract int getSize();
}
