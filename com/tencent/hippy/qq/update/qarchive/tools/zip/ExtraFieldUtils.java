package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ExtraFieldUtils {
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class UnparseableExtraField {
        public static final int READ_KEY = 2;
        public static final int SKIP_KEY = 1;
        public static final int THROW_KEY = 0;
        private final int key;
        public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
        public static final UnparseableExtraField SKIP = new UnparseableExtraField(1);
        public static final UnparseableExtraField READ = new UnparseableExtraField(2);

        UnparseableExtraField(int i3) {
            this.key = i3;
        }

        public int getKey() {
            return this.key;
        }
    }

    static {
        register(AsiExtraField.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class<?> cls = implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        boolean z16;
        if (zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData)) {
            z16 = true;
        } else {
            z16 = false;
        }
        int length = zipExtraFieldArr.length;
        if (z16) {
            length--;
        }
        int i3 = length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            i3 += zipExtraField.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[i3];
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            System.arraycopy(zipExtraFieldArr[i17].getHeaderId().getBytes(), 0, bArr, i16, 2);
            System.arraycopy(zipExtraFieldArr[i17].getCentralDirectoryLength().getBytes(), 0, bArr, i16 + 2, 2);
            byte[] centralDirectoryData = zipExtraFieldArr[i17].getCentralDirectoryData();
            System.arraycopy(centralDirectoryData, 0, bArr, i16 + 4, centralDirectoryData.length);
            i16 += centralDirectoryData.length + 4;
        }
        if (z16) {
            byte[] centralDirectoryData2 = zipExtraFieldArr[zipExtraFieldArr.length - 1].getCentralDirectoryData();
            System.arraycopy(centralDirectoryData2, 0, bArr, i16, centralDirectoryData2.length);
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        boolean z16;
        if (zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData)) {
            z16 = true;
        } else {
            z16 = false;
        }
        int length = zipExtraFieldArr.length;
        if (z16) {
            length--;
        }
        int i3 = length * 4;
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            i3 += zipExtraField.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[i3];
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            System.arraycopy(zipExtraFieldArr[i17].getHeaderId().getBytes(), 0, bArr, i16, 2);
            System.arraycopy(zipExtraFieldArr[i17].getLocalFileDataLength().getBytes(), 0, bArr, i16 + 2, 2);
            byte[] localFileDataData = zipExtraFieldArr[i17].getLocalFileDataData();
            System.arraycopy(localFileDataData, 0, bArr, i16 + 4, localFileDataData.length);
            i16 += localFileDataData.length + 4;
        }
        if (z16) {
            byte[] localFileDataData2 = zipExtraFieldArr[zipExtraFieldArr.length - 1].getLocalFileDataData();
            System.arraycopy(localFileDataData2, 0, bArr, i16, localFileDataData2.length);
        }
        return bArr;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        return parse(bArr, true, UnparseableExtraField.THROW);
    }

    public static void register(Class<?> cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (InstantiationException unused3) {
            throw new RuntimeException(cls + " is not a concrete class");
        }
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z16) throws ZipException {
        return parse(bArr, z16, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z16, UnparseableExtraField unparseableExtraField) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            if (i3 > bArr.length - 4) {
                break;
            }
            ZipShort zipShort = new ZipShort(bArr, i3);
            int value = new ZipShort(bArr, i3 + 2).getValue();
            int i16 = i3 + 4;
            if (i16 + value > bArr.length) {
                int key = unparseableExtraField.getKey();
                if (key == 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("bad extra field starting at ");
                    sb5.append(i3);
                    sb5.append(".  Block length of ");
                    sb5.append(value);
                    sb5.append(" bytes exceeds remaining data of ");
                    sb5.append((bArr.length - i3) - 4);
                    sb5.append(" bytes.");
                    throw new ZipException(sb5.toString());
                }
                if (key != 1) {
                    if (key == 2) {
                        UnparseableExtraFieldData unparseableExtraFieldData = new UnparseableExtraFieldData();
                        if (z16) {
                            unparseableExtraFieldData.parseFromLocalFileData(bArr, i3, bArr.length - i3);
                        } else {
                            unparseableExtraFieldData.parseFromCentralDirectoryData(bArr, i3, bArr.length - i3);
                        }
                        arrayList.add(unparseableExtraFieldData);
                    } else {
                        throw new ZipException("unknown UnparseableExtraField key: " + unparseableExtraField.getKey());
                    }
                }
            } else {
                try {
                    ZipExtraField createExtraField = createExtraField(zipShort);
                    if (!z16 && (createExtraField instanceof CentralDirectoryParsingZipExtraField)) {
                        ((CentralDirectoryParsingZipExtraField) createExtraField).parseFromCentralDirectoryData(bArr, i16, value);
                        arrayList.add(createExtraField);
                        i3 += value + 4;
                    }
                    createExtraField.parseFromLocalFileData(bArr, i16, value);
                    arrayList.add(createExtraField);
                    i3 += value + 4;
                } catch (IllegalAccessException e16) {
                    throw new ZipException(e16.getMessage());
                } catch (InstantiationException e17) {
                    throw new ZipException(e17.getMessage());
                }
            }
        }
        return (ZipExtraField[]) arrayList.toArray(new ZipExtraField[arrayList.size()]);
    }
}
