package com.tencent.hippy.qq.update.qarchive.tools.zip;

import com.tencent.hippy.qq.update.qarchive.tools.zip.UnsupportedZipFeatureException;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = ZipLong.getBytes(8448);

    public static long adjustToLong(int i3) {
        if (i3 < 0) {
            return i3 + 4294967296L;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canHandleEntryData(ZipEntry zipEntry) {
        if (supportsEncryptionOf(zipEntry) && supportsMethodOf(zipEntry)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkRequestedFeatures(ZipEntry zipEntry) throws UnsupportedZipFeatureException {
        if (supportsEncryptionOf(zipEntry)) {
            if (supportsMethodOf(zipEntry)) {
                return;
            } else {
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, zipEntry);
            }
        }
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, zipEntry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] copy(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return null;
    }

    public static long dosToJavaTime(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j3 >> 25) & 127)) + SubAccountUgActivity.SUBACCOUNTUGACTIVITY_FINISH);
        calendar.set(2, ((int) ((j3 >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j3 >> 16)) & 31);
        calendar.set(11, ((int) (j3 >> 11)) & 31);
        calendar.set(12, ((int) (j3 >> 5)) & 63);
        calendar.set(13, ((int) (j3 << 1)) & 62);
        return calendar.getTime().getTime();
    }

    public static Date fromDosTime(ZipLong zipLong) {
        return new Date(dosToJavaTime(zipLong.getValue()));
    }

    private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField abstractUnicodeExtraField, byte[] bArr) {
        if (abstractUnicodeExtraField != null) {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            if (crc32.getValue() == abstractUnicodeExtraField.getNameCRC32()) {
                try {
                    return ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(abstractUnicodeExtraField.getUnicodeName());
                } catch (IOException unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setNameAndCommentFromExtraFields(ZipEntry zipEntry, byte[] bArr, byte[] bArr2) {
        String unicodeStringIfOriginalMatches;
        UnicodePathExtraField unicodePathExtraField = (UnicodePathExtraField) zipEntry.getExtraField(UnicodePathExtraField.UPATH_ID);
        String name = zipEntry.getName();
        String unicodeStringIfOriginalMatches2 = getUnicodeStringIfOriginalMatches(unicodePathExtraField, bArr);
        if (unicodeStringIfOriginalMatches2 != null && !name.equals(unicodeStringIfOriginalMatches2)) {
            zipEntry.setName(unicodeStringIfOriginalMatches2);
        }
        if (bArr2 != null && bArr2.length > 0 && (unicodeStringIfOriginalMatches = getUnicodeStringIfOriginalMatches((UnicodeCommentExtraField) zipEntry.getExtraField(UnicodeCommentExtraField.UCOM_ID), bArr2)) != null) {
            zipEntry.setComment(unicodeStringIfOriginalMatches);
        }
    }

    private static boolean supportsEncryptionOf(ZipEntry zipEntry) {
        return !zipEntry.getGeneralPurposeBit().usesEncryption();
    }

    private static boolean supportsMethodOf(ZipEntry zipEntry) {
        if (zipEntry.getMethod() != 0 && zipEntry.getMethod() != 8) {
            return false;
        }
        return true;
    }

    public static ZipLong toDosTime(Date date) {
        return new ZipLong(toDosTime(date.getTime()));
    }

    public static byte[] toDosTime(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        if (calendar.get(1) < 1980) {
            return copy(DOS_TIME_MIN);
        }
        return ZipLong.getBytes((calendar.get(13) >> 1) | ((r5 - SubAccountUgActivity.SUBACCOUNTUGACTIVITY_FINISH) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5));
    }
}
