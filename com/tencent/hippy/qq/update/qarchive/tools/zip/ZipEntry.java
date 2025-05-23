package com.tencent.hippy.qq.update.qarchive.tools.zip;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ExtraFieldUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.zip.ZipException;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ZipEntry extends java.util.zip.ZipEntry implements Cloneable {
    private static final byte[] EMPTY = new byte[0];
    public static final int PLATFORM_FAT = 0;
    public static final int PLATFORM_UNIX = 3;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_SHIFT = 16;
    private long externalAttributes;
    private LinkedHashMap<ZipShort, ZipExtraField> extraFields;
    private GeneralPurposeBit gpb;
    private int internalAttributes;
    private int method;
    private String name;
    private int platform;
    private byte[] rawName;
    private long size;
    private UnparseableExtraFieldData unparseableExtra;

    public ZipEntry(String str) {
        super(str);
        this.method = -1;
        this.size = -1L;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        setName(str);
    }

    private void mergeExtraFields(ZipExtraField[] zipExtraFieldArr, boolean z16) throws ZipException {
        ZipExtraField extraField;
        if (this.extraFields == null) {
            setExtraFields(zipExtraFieldArr);
            return;
        }
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipExtraField instanceof UnparseableExtraFieldData) {
                extraField = this.unparseableExtra;
            } else {
                extraField = getExtraField(zipExtraField.getHeaderId());
            }
            if (extraField == null) {
                addExtraField(zipExtraField);
            } else if (!z16 && (extraField instanceof CentralDirectoryParsingZipExtraField)) {
                byte[] centralDirectoryData = zipExtraField.getCentralDirectoryData();
                ((CentralDirectoryParsingZipExtraField) extraField).parseFromCentralDirectoryData(centralDirectoryData, 0, centralDirectoryData.length);
            } else {
                byte[] localFileDataData = zipExtraField.getLocalFileDataData();
                extraField.parseFromLocalFileData(localFileDataData, 0, localFileDataData.length);
            }
        }
        setExtra();
    }

    static String safeGetName(java.util.zip.ZipEntry zipEntry) {
        String name = zipEntry.getName();
        if (name.contains("../")) {
            return null;
        }
        return name;
    }

    public void addAsFirstExtraField(ZipExtraField zipExtraField) {
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else {
            LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap = this.extraFields;
            LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap2 = new LinkedHashMap<>();
            this.extraFields = linkedHashMap2;
            linkedHashMap2.put(zipExtraField.getHeaderId(), zipExtraField);
            if (linkedHashMap != null) {
                linkedHashMap.remove(zipExtraField.getHeaderId());
                this.extraFields.putAll(linkedHashMap);
            }
        }
        setExtra();
    }

    public void addExtraField(ZipExtraField zipExtraField) {
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else {
            if (this.extraFields == null) {
                this.extraFields = new LinkedHashMap<>();
            }
            this.extraFields.put(zipExtraField.getHeaderId(), zipExtraField);
        }
        setExtra();
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        ZipEntry zipEntry = (ZipEntry) super.clone();
        zipEntry.setInternalAttributes(getInternalAttributes());
        zipEntry.setExternalAttributes(getExternalAttributes());
        zipEntry.setExtraFields(getExtraFields(true));
        return zipEntry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZipEntry zipEntry = (ZipEntry) obj;
        String name = getName();
        String safeGetName = safeGetName(zipEntry);
        if (name == null) {
            if (safeGetName != null) {
                return false;
            }
        } else if (!name.equals(safeGetName)) {
            return false;
        }
        String comment = getComment();
        String comment2 = zipEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        if (getTime() == zipEntry.getTime() && comment.equals(comment2) && getInternalAttributes() == zipEntry.getInternalAttributes() && getPlatform() == zipEntry.getPlatform() && getExternalAttributes() == zipEntry.getExternalAttributes() && getMethod() == zipEntry.getMethod() && getSize() == zipEntry.getSize() && getCrc() == zipEntry.getCrc() && getCompressedSize() == zipEntry.getCompressedSize() && Arrays.equals(getCentralDirectoryExtra(), zipEntry.getCentralDirectoryExtra()) && Arrays.equals(getLocalFileDataExtra(), zipEntry.getLocalFileDataExtra()) && this.gpb.equals(zipEntry.gpb)) {
            return true;
        }
        return false;
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getExtraFields(true));
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public ZipExtraField getExtraField(ZipShort zipShort) {
        LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap = this.extraFields;
        if (linkedHashMap != null) {
            return linkedHashMap.get(zipShort);
        }
        return null;
    }

    public ZipExtraField[] getExtraFields() {
        return getExtraFields(false);
    }

    public GeneralPurposeBit getGeneralPurposeBit() {
        return this.gpb;
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    public Date getLastModifiedDate() {
        return new Date(getTime());
    }

    public byte[] getLocalFileDataExtra() {
        byte[] extra = getExtra();
        if (extra == null) {
            return EMPTY;
        }
        return extra;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.method;
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String str = this.name;
        if (str == null) {
            String name = super.getName();
            if (name.contains("../")) {
                return null;
            }
            return name;
        }
        return str;
    }

    public int getPlatform() {
        return this.platform;
    }

    public byte[] getRawName() {
        byte[] bArr = this.rawName;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return null;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.size;
    }

    public int getUnixMode() {
        if (this.platform != 3) {
            return 0;
        }
        return (int) ((getExternalAttributes() >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    public UnparseableExtraFieldData getUnparseableExtraFieldData() {
        return this.unparseableExtra;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return getName().endsWith("/");
    }

    public void removeExtraField(ZipShort zipShort) {
        LinkedHashMap<ZipShort, ZipExtraField> linkedHashMap = this.extraFields;
        if (linkedHashMap != null) {
            if (linkedHashMap.remove(zipShort) != null) {
                setExtra();
                return;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public void removeUnparseableExtraFieldData() {
        if (this.unparseableExtra != null) {
            this.unparseableExtra = null;
            setExtra();
            return;
        }
        throw new NoSuchElementException();
    }

    public void setCentralDirectoryExtra(byte[] bArr) {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, false, ExtraFieldUtils.UnparseableExtraField.READ), false);
        } catch (ZipException e16) {
            throw new RuntimeException(e16.getMessage(), e16);
        }
    }

    public void setComprSize(long j3) {
        setCompressedSize(j3);
    }

    public void setExternalAttributes(long j3) {
        this.externalAttributes = j3;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, true, ExtraFieldUtils.UnparseableExtraField.READ), true);
        } catch (ZipException e16) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e16.getMessage(), e16);
        }
    }

    public void setExtraFields(ZipExtraField[] zipExtraFieldArr) {
        this.extraFields = new LinkedHashMap<>();
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipExtraField instanceof UnparseableExtraFieldData) {
                this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
            } else {
                this.extraFields.put(zipExtraField.getHeaderId(), zipExtraField);
            }
        }
        setExtra();
    }

    public void setGeneralPurposeBit(GeneralPurposeBit generalPurposeBit) {
        this.gpb = generalPurposeBit;
    }

    public void setInternalAttributes(int i3) {
        this.internalAttributes = i3;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int i3) {
        if (i3 >= 0) {
            this.method = i3;
            return;
        }
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + i3);
    }

    public void setName(String str) {
        if (str != null && getPlatform() == 0 && str.indexOf("/") == -1) {
            str = str.replace('\\', '/');
        }
        this.name = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPlatform(int i3) {
        this.platform = i3;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long j3) {
        if (j3 >= 0) {
            this.size = j3;
            return;
        }
        throw new IllegalArgumentException("invalid entry size");
    }

    public void setUnixMode(int i3) {
        int i16;
        int i17 = i3 << 16;
        int i18 = 0;
        if ((i3 & 128) == 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int i19 = i16 | i17;
        if (isDirectory()) {
            i18 = 16;
        }
        setExternalAttributes(i19 | i18);
        this.platform = 3;
    }

    public ZipExtraField[] getExtraFields(boolean z16) {
        UnparseableExtraFieldData unparseableExtraFieldData;
        UnparseableExtraFieldData unparseableExtraFieldData2;
        if (this.extraFields == null) {
            return (!z16 || (unparseableExtraFieldData2 = this.unparseableExtra) == null) ? new ZipExtraField[0] : new ZipExtraField[]{unparseableExtraFieldData2};
        }
        ArrayList arrayList = new ArrayList(this.extraFields.values());
        if (z16 && (unparseableExtraFieldData = this.unparseableExtra) != null) {
            arrayList.add(unparseableExtraFieldData);
        }
        return (ZipExtraField[]) arrayList.toArray(new ZipExtraField[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setName(String str, byte[] bArr) {
        setName(str);
        this.rawName = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getExtraFields(true)));
    }

    public ZipEntry(java.util.zip.ZipEntry zipEntry) throws ZipException {
        super(zipEntry);
        this.method = -1;
        this.size = -1L;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0L;
        this.extraFields = null;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        setName(safeGetName(zipEntry));
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            setExtraFields(ExtraFieldUtils.parse(extra, true, ExtraFieldUtils.UnparseableExtraField.READ));
        } else {
            setExtra();
        }
        setMethod(zipEntry.getMethod());
        this.size = zipEntry.getSize();
    }

    public ZipEntry(ZipEntry zipEntry) throws ZipException {
        this((java.util.zip.ZipEntry) zipEntry);
        setInternalAttributes(zipEntry.getInternalAttributes());
        setExternalAttributes(zipEntry.getExternalAttributes());
        setExtraFields(zipEntry.getExtraFields(true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ZipEntry() {
        this("");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ZipEntry(File file, String str) {
        this(str);
        if (file.isDirectory() && !str.endsWith("/")) {
            str = str + "/";
        }
        if (file.isFile()) {
            setSize(file.length());
        }
        setTime(file.lastModified());
    }
}
