package com.tencent.image;

import android.media.ExifInterface;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JpegExifReader {
    static IPatchRedirector $redirector_ = null;
    private static final String BIG_ENDIAN_BYTE_ORDER = "MM";
    private static final byte[] BYTES_PER_FORMAT;
    private static final int DIRECTORY_LENGTH = 12;
    private static final byte E0 = -32;
    private static final byte E1 = -31;
    private static final byte E15 = -17;
    private static final String EXIF = "EXIF";
    private static final int EXPOSURE_TIME_TAG = 33434;
    private static final byte FF = -1;
    private static final String LITTLE_ENDIAN_BYTE_ORDER = "II";
    private static final int ORIENTATION_TAG = 274;
    private static final String REPORT_ACTION = "actReadJpegOrientation";
    private static final byte SEGMENTS_END = -38;
    private static final int SUB_IFD_OFFSET_TAG = 34665;
    private static final String TAG = "JpegExifReader";
    private static final int TIFF_HEADER_OFFSET = 6;
    public static JpegExifReaderInterface jpegExifReaderInterface;
    private static boolean sIsEnable;
    private static boolean sIsReadDpc;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface JpegExifReaderInterface {
        void doReport(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3);

        boolean readEnableFromDPC();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9400);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        BYTES_PER_FORMAT = new byte[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        sIsEnable = true;
        sIsReadDpc = false;
    }

    public JpegExifReader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static short getInt16(boolean z16, byte[] bArr) {
        int i3;
        byte b16;
        if (z16) {
            i3 = bArr[0] & 65280;
            b16 = bArr[1];
        } else {
            i3 = bArr[1] & 65280;
            b16 = bArr[0];
        }
        return (short) (i3 | (b16 & 255));
    }

    private static int getInt32(boolean z16, byte[] bArr) {
        int i3;
        byte b16;
        if (z16) {
            i3 = ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[2] << 8) & 65280);
            b16 = bArr[3];
        } else {
            i3 = ((bArr[3] << 24) & (-16777216)) | (16711680 & (bArr[2] << RegisterType.UNINIT_REF)) | (65280 & (bArr[1] << 8));
            b16 = bArr[0];
        }
        return i3 | (b16 & 255);
    }

    public static int getRotationDegree(String str) {
        int readOrientation = readOrientation(str);
        if (readOrientation != 3) {
            if (readOrientation != 6) {
                if (readOrientation != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }

    private static int getUnsignedInt16(boolean z16, byte[] bArr) {
        int i3;
        byte b16;
        if (z16) {
            i3 = (bArr[0] << 8) & 65280;
            b16 = bArr[1];
        } else {
            i3 = (bArr[1] << 8) & 65280;
            b16 = bArr[0];
        }
        return i3 | (b16 & 255);
    }

    private static long getUnsignedInt32(boolean z16, byte[] bArr) throws Exception {
        long j3;
        byte b16;
        if (z16) {
            j3 = ((bArr[0] << 24) & 4278190080L) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280);
            b16 = bArr[3];
        } else {
            j3 = ((bArr[3] << 24) & 4278190080L) | (16711680 & (bArr[2] << 16)) | (65280 & (bArr[1] << 8));
            b16 = bArr[0];
        }
        return j3 | (b16 & 255);
    }

    private static long getValue(int i3, boolean z16, byte[] bArr) throws Exception {
        int unsignedInt16;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 6) {
                    if (i3 != 8) {
                        if (i3 != 9) {
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.e(TAG, 2, "get value format code: " + i3);
                            }
                            return 0L;
                        }
                        unsignedInt16 = getInt32(z16, bArr);
                    } else {
                        unsignedInt16 = getInt16(z16, bArr);
                    }
                } else {
                    unsignedInt16 = bArr[0];
                }
            } else {
                return getUnsignedInt32(z16, bArr);
            }
        } else {
            unsignedInt16 = getUnsignedInt16(z16, bArr);
        }
        return unsignedInt16;
    }

    public static void initJpegExifReader(JpegExifReaderInterface jpegExifReaderInterface2) {
        jpegExifReaderInterface = jpegExifReaderInterface2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:5|6|7|8|9|10|(3:237|238|(3:240|241|(8:243|(7:14|15|16|17|(3:18|19|(2:230|231)(2:21|(2:228|229)(2:23|(1:1)(2:27|(1:29)(2:30|31)))))|32|33)(1:236)|34|35|36|37|(1:39)|40)))|12|(0)(0)|34|35|36|37|(0)|40) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x012f, code lost:
    
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0134, code lost:
    
        if (r9.read(r0, 0, 2) == 2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0136, code lost:
    
        r0 = "read tag count, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x013a, code lost:
    
        r4 = r4 + (r10 + 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x013c, code lost:
    
        r10 = getUnsignedInt16(r8, r0);
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0141, code lost:
    
        if (r15 >= r10) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0147, code lost:
    
        if (r9.read(r0, r5 ? 1 : 0, r14) == r14) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x014d, code lost:
    
        r4 = r4 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0153, code lost:
    
        r18 = "skip dir, Jpeg data ended unexpectedly.";
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x015d, code lost:
    
        if (getUnsignedInt16(r8, r0) != com.tencent.image.JpegExifReader.SUB_IFD_OFFSET_TAG) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0288, code lost:
    
        if (skip(r9, 10) == 10) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x028b, code lost:
    
        r4 = r4 + 10;
        r15 = r15 + 1;
        r6 = r19;
        r5 = false;
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02cc, code lost:
    
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02dd, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0164, code lost:
    
        if (r9.read(r0, r5 ? 1 : 0, 2) == 2) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0166, code lost:
    
        r0 = "read subIFD offset, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0169, code lost:
    
        r18 = r0;
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x016e, code lost:
    
        r4 = r4 + 2;
        r10 = getUnsignedInt16(r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0179, code lost:
    
        if (r9.read(r12, r5 ? 1 : 0, 4) == 4) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x017b, code lost:
    
        r0 = "read format code, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x017f, code lost:
    
        r4 = r4 + 4;
        getInt32(r8, r12);
        r11 = com.tencent.image.JpegExifReader.BYTES_PER_FORMAT[r10];
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x018d, code lost:
    
        if (r9.read(r12, r5 ? 1 : 0, 4) == 4) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x018f, code lost:
    
        r0 = "read subIFD offset value, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0193, code lost:
    
        r4 = r4 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x019d, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x019f, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.d(com.tencent.image.JpegExifReader.TAG, 2, "read subIFD offset format: " + r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01b9, code lost:
    
        r10 = (getValue(r10, r8, r12) + r13) - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x01c7, code lost:
    
        if (skip(r9, r10) == r10) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01c9, code lost:
    
        r0 = "skip to subIFD, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01d2, code lost:
    
        if (r9.read(r0, r5 ? 1 : 0, 2) == 2) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x01d4, code lost:
    
        r0 = "read subIFD tag count, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01d8, code lost:
    
        r13 = r4 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x01da, code lost:
    
        r4 = getUnsignedInt16(r8, r0);
        r10 = r5 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01df, code lost:
    
        if (r10 >= r4) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x01e6, code lost:
    
        if (r9.read(r0, r5 ? 1 : 0, 2) == 2) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x01ef, code lost:
    
        r13 = r13 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x01f8, code lost:
    
        if (getUnsignedInt16(r8, r0) != com.tencent.image.JpegExifReader.EXPOSURE_TIME_TAG) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x01ff, code lost:
    
        if (r9.read(r0, r5 ? 1 : 0, 2) == 2) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0205, code lost:
    
        r13 = r13 + 2;
        r11 = getUnsignedInt16(r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0210, code lost:
    
        if (r9.read(r12, r5 ? 1 : 0, 4) == 4) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0216, code lost:
    
        r13 = r13 + 4;
        getInt32(r8, r12);
        r14 = com.tencent.image.JpegExifReader.BYTES_PER_FORMAT[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0224, code lost:
    
        if (r9.read(r12, r5 ? 1 : 0, 4) == 4) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x022a, code lost:
    
        r13 = r13 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0234, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0236, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.d(com.tencent.image.JpegExifReader.TAG, 2, "read exposure time format: " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0252, code lost:
    
        if (r11 != 12) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0254, code lost:
    
        r18 = "";
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0265, code lost:
    
        r10 = r10 + 1;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0226, code lost:
    
        r0 = "read exposure time value, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x01eb, code lost:
    
        r18 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0212, code lost:
    
        r0 = "read exposure component count, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0201, code lost:
    
        r0 = "read exposure format code, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x025f, code lost:
    
        if (skip(r9, 10) == 10) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0263, code lost:
    
        r13 = r13 + 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x01e8, code lost:
    
        r0 = "read subIFD tag type, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0272, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0274, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.d(com.tencent.image.JpegExifReader.TAG, 2, "subIFD, end.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x027f, code lost:
    
        r18 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x02df, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0149, code lost:
    
        r0 = "read tag type, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0296, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x02a0, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x02a2, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.d(com.tencent.image.JpegExifReader.TAG, 2, "exif, end.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02ad, code lost:
    
        r18 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x00f6, code lost:
    
        if (com.tencent.image.JpegExifReader.LITTLE_ENDIAN_BYTE_ORDER.equalsIgnoreCase(r8) == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x00f8, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x02b0, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02ca, code lost:
    
        r18 = "byte order identifier: " + r8 + ", Malformed byte order.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x02ce, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02d3, code lost:
    
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02d0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02d1, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02d6, code lost:
    
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02db, code lost:
    
        r18 = "cannot find app1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x02f5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x02ff, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() != false) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0301, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.e(com.tencent.image.JpegExifReader.TAG, 2, "", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        if (r14 != (-1)) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        if (r15 == (-31)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a8, code lost:
    
        if (r9.read(r12, 0, 4) == 4) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00aa, code lost:
    
        r0 = "read segment header, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ae, code lost:
    
        r13 = r13 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bc, code lost:
    
        if (com.tencent.image.JpegExifReader.EXIF.equalsIgnoreCase(new java.lang.String(r12)) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00be, code lost:
    
        r0 = "app1 is not exif";
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ca, code lost:
    
        if (r9.skip(2) == 2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:
    
        r0 = "skip TIFF_HEADER_OFFSET failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d0, code lost:
    
        r13 = r13 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d7, code lost:
    
        if (r9.read(r0, 0, 2) == 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d9, code lost:
    
        r0 = "read order identifier, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00dd, code lost:
    
        r4 = r13 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00df, code lost:
    
        r8 = new java.lang.String(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00eb, code lost:
    
        if (com.tencent.image.JpegExifReader.BIG_ENDIAN_BYTE_ORDER.equalsIgnoreCase(r8) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ed, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ff, code lost:
    
        if (skip(r9, 2) == 2) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0101, code lost:
    
        r0 = "skip 0x002a failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0104, code lost:
    
        r18 = r0;
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0112, code lost:
    
        if (r9.read(r12, 0, 4) == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0114, code lost:
    
        r0 = "read directory offset, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0118, code lost:
    
        r4 = r4 + 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x011e, code lost:
    
        r10 = getInt32(r8, r12) - 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0120, code lost:
    
        if (r10 <= 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0122, code lost:
    
        r14 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0129, code lost:
    
        if (skip(r9, r14) == r14) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x012b, code lost:
    
        r0 = "skip first directory offset failed.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0109, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x010a, code lost:
    
        r13 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x031f A[Catch: all -> 0x0391, TRY_LEAVE, TryCatch #9 {all -> 0x0391, blocks: (B:93:0x0315, B:95:0x031f), top: B:92:0x0315 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0329 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCrashJpeg(String str) {
        long j3;
        int i3;
        BufferedInputStream bufferedInputStream;
        byte[] bArr;
        byte b16;
        byte b17;
        String str2;
        String str3;
        String str4 = "";
        boolean z16 = false;
        z16 = false;
        z16 = false;
        z16 = false;
        z16 = false;
        z16 = false;
        if (Build.VERSION.SDK_INT >= 24) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int i16 = 2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 1024);
        } catch (Throwable th5) {
            th = th5;
            j3 = uptimeMillis;
        }
        try {
            bArr = new byte[2];
            b16 = 255;
        } catch (Throwable th6) {
            th = th6;
            j3 = uptimeMillis;
            bufferedInputStream2 = bufferedInputStream;
            i3 = 0;
            try {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                }
                if (bufferedInputStream2 != null) {
                }
                z16 = false;
                long uptimeMillis2 = SystemClock.uptimeMillis() - j3;
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                }
                return z16;
            } finally {
            }
        }
        if (bufferedInputStream.read(bArr, 0, 2) == 2) {
            try {
            } catch (Throwable th7) {
                th = th7;
                i3 = 0;
                j3 = uptimeMillis;
                bufferedInputStream2 = bufferedInputStream;
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                }
                if (bufferedInputStream2 != null) {
                }
                z16 = false;
                long uptimeMillis22 = SystemClock.uptimeMillis() - j3;
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                }
                return z16;
            }
            if ((bArr[0] & 255) == 255) {
                if ((bArr[1] & 255) == 216) {
                    b17 = true;
                    if (b17 == false) {
                        try {
                            byte[] bArr2 = new byte[4];
                            i3 = 2;
                            while (true) {
                                try {
                                    byte read = (byte) (bufferedInputStream.read() & b16);
                                    i3++;
                                    byte read2 = (byte) (bufferedInputStream.read() & b16);
                                    if (read2 == -38) {
                                        str3 = "segment end, break.";
                                        break;
                                    }
                                    i3++;
                                    if (bufferedInputStream.read(bArr, 0, i16) != i16) {
                                        str3 = "read segment-size, Jpeg data ended unexpectedly.";
                                        break;
                                    }
                                    i3 += 2;
                                    int i17 = ((bArr[1] & b16) | ((bArr[0] << 8) & 65280)) - 2;
                                    if (read != -1 || read2 != -32) {
                                        break;
                                    }
                                    long j16 = i17;
                                    if (skip(bufferedInputStream, j16) == j16) {
                                        i3 += i17;
                                        i16 = 2;
                                        b16 = 255;
                                    } else {
                                        str3 = "skip app0, Jpeg data ended unexpectedly.";
                                        break;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                            str2 = str3;
                            j3 = uptimeMillis;
                        } catch (Throwable th9) {
                            th = th9;
                            j3 = uptimeMillis;
                            bufferedInputStream2 = bufferedInputStream;
                            i3 = 2;
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.e(TAG, 2, "", th);
                            }
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e16) {
                                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                                        URLDrawable.depImp.mLog.e(TAG, 2, "", e16);
                                    }
                                }
                            }
                            z16 = false;
                            long uptimeMillis222 = SystemClock.uptimeMillis() - j3;
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                            }
                            return z16;
                        }
                    } else {
                        j3 = uptimeMillis;
                        str2 = "";
                        z16 = false;
                        i3 = 2;
                    }
                    bufferedInputStream.close();
                    str4 = str2;
                    long uptimeMillis2222 = SystemClock.uptimeMillis() - j3;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d(TAG, 2, "isCrashJpeg:" + z16 + "; read " + i3 + " bytes; cost: " + uptimeMillis2222 + "; filename: " + str + "; errorMsg: " + str4);
                    }
                    return z16;
                }
            }
        }
        b17 = false;
        if (b17 == false) {
        }
        bufferedInputStream.close();
        str4 = str2;
        long uptimeMillis22222 = SystemClock.uptimeMillis() - j3;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
        }
        return z16;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:8|(3:9|10|(3:11|12|13))|(3:216|217|(3:219|220|(9:222|(6:33|34|35|(4:36|37|38|(2:208|209)(3:40|41|(2:205|206)(5:43|44|45|(2:91|(1:1)(1:(1:1)(3:97|98|(3:100|101|58)(2:102|103))))(4:49|50|51|(2:57|58)(2:53|54))|56)))|55|56)(1:17)|18|19|20|(1:22)|23|(1:25)|26)))|15|(0)(0)|18|19|20|(0)|23|(0)|26) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x012c, code lost:
    
        r0 = "cannot find app1 ,current no app1, thisSegmentMarker:" + ((int) r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0140, code lost:
    
        if (r15 != (-1)) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0142, code lost:
    
        if (r10 == (-31)) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x014b, code lost:
    
        if (r11.read(r6, 0, 4) == 4) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x014d, code lost:
    
        r0 = "read segment header, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x015e, code lost:
    
        if (com.tencent.image.JpegExifReader.EXIF.equalsIgnoreCase(new java.lang.String(r6)) != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0160, code lost:
    
        r0 = "app1 is not exif";
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x016d, code lost:
    
        if (r11.skip(2) == 2) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x016f, code lost:
    
        r0 = "skip TIFF_HEADER_OFFSET failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0174, code lost:
    
        r13 = r13 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x017b, code lost:
    
        if (r11.read(r0, 0, 2) == 2) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x017d, code lost:
    
        r0 = "read order identifier, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0182, code lost:
    
        r13 = r13 + 2;
        r5 = new java.lang.String(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0190, code lost:
    
        if (com.tencent.image.JpegExifReader.BIG_ENDIAN_BYTE_ORDER.equalsIgnoreCase(r5) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0192, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01a4, code lost:
    
        if (skip(r11, 2) == 2) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01a6, code lost:
    
        r0 = "skip 0x002a failed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01b0, code lost:
    
        if (r11.read(r6, 0, 4) == 4) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01b2, code lost:
    
        r0 = "read directory offset, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01b7, code lost:
    
        r13 = r13 + 6;
        r3 = getInt32(r5, r6) - 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01c0, code lost:
    
        if (r3 <= 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01c2, code lost:
    
        r9 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01c9, code lost:
    
        if (skip(r11, r9) == r9) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01cb, code lost:
    
        r0 = "skip first directory offset failed.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01d0, code lost:
    
        r4 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01d5, code lost:
    
        if (r11.read(r0, 0, 2) == 2) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01d7, code lost:
    
        r0 = "read tag count, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01dc, code lost:
    
        r13 = r13 + (r3 + 2);
        r3 = getUnsignedInt16(r5, r0);
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01e3, code lost:
    
        if (r9 >= r3) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01e9, code lost:
    
        if (r11.read(r0, 0, r4) == r4) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01f0, code lost:
    
        r13 = r13 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01f8, code lost:
    
        if (getUnsignedInt16(r5, r0) != 274) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02b5, code lost:
    
        r10 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02be, code lost:
    
        if (skip(r11, 10) == 10) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02c4, code lost:
    
        r13 = r13 + 10;
        r9 = r9 + 1;
        r5 = r10;
        r4 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02c0, code lost:
    
        r0 = "skip dir, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01ff, code lost:
    
        if (r11.read(r0, 0, 2) == 2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0201, code lost:
    
        r0 = "read orientation, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0206, code lost:
    
        r13 = r13 + 2;
        r0 = getUnsignedInt16(r5, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0211, code lost:
    
        if (r11.read(r6, 0, 4) == 4) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0213, code lost:
    
        r0 = "read format code, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0218, code lost:
    
        r13 = r13 + 4;
        r3 = getInt32(r5, r6) * com.tencent.image.JpegExifReader.BYTES_PER_FORMAT[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0224, code lost:
    
        if (r3 <= 4) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0226, code lost:
    
        r14 = "Malformed orientation data, format: " + r0 + ", byte count: " + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02cc, code lost:
    
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02d5, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02d7, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.d(com.tencent.image.JpegExifReader.TAG, 2, "exif, end.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02e2, code lost:
    
        r13 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02e4, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0335, code lost:
    
        r6 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0248, code lost:
    
        if (r11.read(r6, 0, 4) == 4) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x024a, code lost:
    
        r0 = "read orientation value, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x024f, code lost:
    
        r13 = r13 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0252, code lost:
    
        if (r0 == 3) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0254, code lost:
    
        if (r0 == 4) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0257, code lost:
    
        if (r0 == 6) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x025b, code lost:
    
        if (r0 == 8) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x025f, code lost:
    
        if (r0 == 9) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0261, code lost:
    
        r14 = "Orientation format code: " + r0;
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0294, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() == false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0296, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.d(com.tencent.image.JpegExifReader.TAG, 4, "read orientation value: " + (r5 == true ? 1 : 0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x02b2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x009b, code lost:
    
        r6 = r11;
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0275, code lost:
    
        r5 = getInt32(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x027a, code lost:
    
        r5 = getInt16(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x027f, code lost:
    
        r5 = r6[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0282, code lost:
    
        r5 = (int) getUnsignedInt32(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0288, code lost:
    
        r5 = getUnsignedInt16(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x01eb, code lost:
    
        r0 = "read first dir offset, Jpeg data ended unexpectedly.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x019b, code lost:
    
        if (com.tencent.image.JpegExifReader.LITTLE_ENDIAN_BYTE_ORDER.equalsIgnoreCase(r5) == false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x019d, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02e6, code lost:
    
        r0 = "byte order identifier: " + r5 + ", Malformed byte order.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x02ff, code lost:
    
        r0 = "cannot find app1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0093, code lost:
    
        r14 = r0;
        r17 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x031c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0326, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() != false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0328, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.e(com.tencent.image.JpegExifReader.TAG, 2, "", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0346, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.e(com.tencent.image.JpegExifReader.TAG, 2, "", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0350, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0354, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x035e, code lost:
    
        if (com.tencent.image.URLDrawable.depImp.mLog.isColorLevel() != false) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0360, code lost:
    
        com.tencent.image.URLDrawable.depImp.mLog.e(com.tencent.image.JpegExifReader.TAG, 2, "", r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0346 A[Catch: all -> 0x03cf, TRY_LEAVE, TryCatch #6 {all -> 0x03cf, blocks: (B:64:0x033c, B:66:0x0346), top: B:63:0x033c }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0350 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int readOrientation(String str) {
        long j3;
        String str2;
        int i3;
        JpegExifReaderInterface jpegExifReaderInterface2;
        BufferedInputStream bufferedInputStream;
        byte[] bArr;
        int i16;
        byte b16;
        String str3;
        String str4;
        JpegExifReaderInterface jpegExifReaderInterface3;
        long uptimeMillis = SystemClock.uptimeMillis();
        int i17 = 1;
        i17 = 1;
        if (!sIsReadDpc && (jpegExifReaderInterface3 = jpegExifReaderInterface) != null) {
            sIsEnable = jpegExifReaderInterface3.readEnableFromDPC();
            sIsReadDpc = true;
        }
        ExifInterface exifInterface = null;
        BufferedInputStream bufferedInputStream2 = null;
        exifInterface = null;
        int i18 = 0;
        int i19 = 2;
        if (!sIsEnable) {
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "new ExifInterface", e16);
                }
            }
            if (exifInterface == null) {
                return 0;
            }
            return exifInterface.getAttributeInt("Orientation", 1);
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 512);
            try {
                bArr = new byte[2];
                i16 = 255;
            } catch (Throwable th5) {
                th = th5;
                j3 = uptimeMillis;
                str2 = "";
            }
        } catch (Throwable th6) {
            th = th6;
            j3 = uptimeMillis;
            str2 = "";
        }
        if (bufferedInputStream.read(bArr, 0, 2) == 2) {
            try {
            } catch (Throwable th7) {
                th = th7;
                str2 = "";
                j3 = uptimeMillis;
                bufferedInputStream2 = bufferedInputStream;
                try {
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                    }
                    if (bufferedInputStream2 != null) {
                    }
                    i3 = i18;
                    long uptimeMillis2 = SystemClock.uptimeMillis() - j3;
                    jpegExifReaderInterface2 = jpegExifReaderInterface;
                    if (jpegExifReaderInterface2 != null) {
                    }
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                    }
                    return i17;
                } finally {
                }
            }
            if ((bArr[0] & 255) == 255) {
                if ((bArr[1] & 255) == 216) {
                    b16 = true;
                    if (b16 == false) {
                        try {
                            byte[] bArr2 = new byte[4];
                            str2 = "";
                            i3 = 2;
                            while (true) {
                                try {
                                    byte read = (byte) (bufferedInputStream.read() & i16);
                                    i3++;
                                    byte read2 = (byte) (bufferedInputStream.read() & i16);
                                    if (read2 == -38) {
                                        str3 = "segment end, break.";
                                        break;
                                    }
                                    i3++;
                                    if (bufferedInputStream.read(bArr, 0, i19) != i19) {
                                        str3 = "read segment-size, Jpeg data ended unexpectedly.";
                                        break;
                                    }
                                    i3 += 2;
                                    int i26 = ((bArr[i17 == true ? 1 : 0] & 255) | ((bArr[0] << 8) & 65280)) - 2;
                                    if (read == -1 && read2 == -32) {
                                        j3 = uptimeMillis;
                                        long j16 = i26;
                                        try {
                                            if (skip(bufferedInputStream, j16) == j16) {
                                                i3 += i26;
                                                uptimeMillis = j3;
                                                i17 = 1;
                                                i19 = 2;
                                                i16 = 255;
                                            } else {
                                                str4 = "skip app0, Jpeg data ended unexpectedly.";
                                                break;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            bufferedInputStream2 = bufferedInputStream;
                                            i18 = i3;
                                            i17 = 1;
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            }
                                            if (bufferedInputStream2 != null) {
                                            }
                                            i3 = i18;
                                            long uptimeMillis22 = SystemClock.uptimeMillis() - j3;
                                            jpegExifReaderInterface2 = jpegExifReaderInterface;
                                            if (jpegExifReaderInterface2 != null) {
                                            }
                                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                            }
                                            return i17;
                                        }
                                    } else {
                                        j3 = uptimeMillis;
                                        if (read == -1 && read2 != -31) {
                                            if (read2 > -31 && read2 < -17) {
                                                long j17 = i26;
                                                if (skip(bufferedInputStream, j17) == j17) {
                                                    str2 = str2 + " skip " + ((int) read2) + ", no app1";
                                                    i3 += i26;
                                                    uptimeMillis = j3;
                                                    i17 = 1;
                                                    i19 = 2;
                                                    i16 = 255;
                                                } else {
                                                    str4 = " skip " + ((int) read2) + ", Jpeg data ended unexpectedly.";
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    i17 = 1;
                                } catch (Throwable th9) {
                                    th = th9;
                                    j3 = uptimeMillis;
                                }
                            }
                            str2 = str4;
                            i17 = 1;
                        } catch (Throwable th10) {
                            th = th10;
                            j3 = uptimeMillis;
                            str2 = "";
                            bufferedInputStream2 = bufferedInputStream;
                            i17 = 1;
                            i18 = 2;
                        }
                    } else {
                        j3 = uptimeMillis;
                        str2 = "";
                        i17 = 1;
                        i3 = 2;
                    }
                    bufferedInputStream.close();
                    long uptimeMillis222 = SystemClock.uptimeMillis() - j3;
                    jpegExifReaderInterface2 = jpegExifReaderInterface;
                    if (jpegExifReaderInterface2 != null) {
                        jpegExifReaderInterface2.doReport(null, REPORT_ACTION, true, uptimeMillis222, i3, null, null);
                    }
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d(TAG, 4, "orientation:" + i17 + "; read " + i3 + " bytes; cost: " + uptimeMillis222 + "; filename: " + str + "; errorMsg:" + str2);
                    }
                    return i17;
                }
            }
        }
        b16 = false;
        if (b16 == false) {
        }
        bufferedInputStream.close();
        long uptimeMillis2222 = SystemClock.uptimeMillis() - j3;
        jpegExifReaderInterface2 = jpegExifReaderInterface;
        if (jpegExifReaderInterface2 != null) {
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
        }
        return i17;
    }

    private static long skip(InputStream inputStream, long j3) throws IOException {
        long j16 = j3;
        while (j16 > 0) {
            long skip = inputStream.skip(j16);
            if (skip > 0) {
                j16 -= skip;
            } else if (skip == 0) {
                if (inputStream.read() == -1) {
                    break;
                }
                j16--;
            } else {
                throw new IOException("skip() return a negative value.");
            }
        }
        return j3 - j16;
    }
}
