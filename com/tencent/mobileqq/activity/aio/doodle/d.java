package com.tencent.mobileqq.activity.aio.doodle;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.doodle.m;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import msg.aio_doodle.DoodleMsgProto$DoodleData;
import msg.aio_doodle.DoodleMsgProto$DoodleHeader;
import msg.aio_doodle.DoodleMsgProto$LineData;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    public static long a(byte[] bArr, int i3) {
        long j3 = 0;
        for (int i16 = 0; i16 < 8; i16++) {
            j3 = (j3 << 8) | (bArr[i16 + i3] & 255);
        }
        return j3;
    }

    public static int b(byte[] bArr, int i3) {
        return ((bArr[i3] << 24) & (-16777216)) | (bArr[i3 + 3] & 255) | ((bArr[i3 + 2] << 8) & 65280) | ((bArr[i3 + 1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT);
    }

    private static void c(b bVar, DoodleMsgProto$DoodleHeader doodleMsgProto$DoodleHeader) {
        if (bVar != null && doodleMsgProto$DoodleHeader != null) {
            Resources resources = BaseApplication.getContext().getResources();
            if (doodleMsgProto$DoodleHeader.float_draw_area_width.has() && doodleMsgProto$DoodleHeader.float_draw_area_height.has()) {
                bVar.b().j((int) Utils.o(doodleMsgProto$DoodleHeader.float_draw_area_width.get(), resources), (int) Utils.o(doodleMsgProto$DoodleHeader.float_draw_area_height.get(), resources));
            }
            if (doodleMsgProto$DoodleHeader.float_line_width_max.has()) {
                bVar.b().l(Utils.o(doodleMsgProto$DoodleHeader.float_line_width_max.get(), resources));
            }
            if (doodleMsgProto$DoodleHeader.float_line_width_min.has()) {
                bVar.b().n(Utils.o(doodleMsgProto$DoodleHeader.float_line_width_min.get(), resources));
            }
            if (doodleMsgProto$DoodleHeader.float_comp_factor_max.has()) {
                bVar.b().k(doodleMsgProto$DoodleHeader.float_comp_factor_max.get());
            }
            if (doodleMsgProto$DoodleHeader.float_comp_factor_min.has()) {
                bVar.b().m(doodleMsgProto$DoodleHeader.float_comp_factor_min.get());
            }
            if (doodleMsgProto$DoodleHeader.uint32_time.has()) {
                bVar.d(doodleMsgProto$DoodleHeader.uint32_time.get());
            }
        }
    }

    private static void d(m mVar, DoodleMsgProto$DoodleData doodleMsgProto$DoodleData, boolean z16) {
        List<DoodleMsgProto$LineData> list;
        if (mVar != null && doodleMsgProto$DoodleData != null) {
            if (z16) {
                if (doodleMsgProto$DoodleData.uint32_rgba.has()) {
                    mVar.k(doodleMsgProto$DoodleData.uint32_rgba.get());
                }
                if (doodleMsgProto$DoodleData.uint32template_id.has()) {
                    mVar.l(doodleMsgProto$DoodleData.uint32template_id.get());
                    if (mVar.i() > 0) {
                        mVar.k(-1);
                    }
                }
            }
            Resources resources = BaseApplication.getContext().getResources();
            if (doodleMsgProto$DoodleData.rpt_line_Data.has() && (list = doodleMsgProto$DoodleData.rpt_line_Data.get()) != null) {
                for (DoodleMsgProto$LineData doodleMsgProto$LineData : list) {
                    if (doodleMsgProto$LineData.float_X.has() && doodleMsgProto$LineData.float_Y.has() && doodleMsgProto$LineData.uint64_tickcount.has()) {
                        mVar.a(Utils.o(doodleMsgProto$LineData.float_X.get(), resources), Utils.o(doodleMsgProto$LineData.float_Y.get(), resources), -1.0f, doodleMsgProto$LineData.uint64_tickcount.get());
                    }
                }
            }
        }
    }

    private static int e(DoodleMsgProto$DoodleData doodleMsgProto$DoodleData) {
        if (doodleMsgProto$DoodleData == null || !doodleMsgProto$DoodleData.uint_line_id.has()) {
            return -1;
        }
        return doodleMsgProto$DoodleData.uint_line_id.get();
    }

    public static byte[] f(int i3) {
        return new byte[]{(byte) (((-16777216) & i3) >> 24), (byte) ((16711680 & i3) >> 16), (byte) ((65280 & i3) >> 8), (byte) (i3 & 255)};
    }

    public static byte[] g(long j3) {
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) ((j3 >> (64 - (r3 * 8))) & 255);
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0186, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0188, code lost:
    
        com.tencent.qphone.base.util.QLog.d("DoodleMsgTranslator", 2, "parseFile error: line len:" + r12);
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b h(String str) {
        Throwable th5;
        b bVar;
        Exception exc;
        StringBuilder sb5;
        BufferedInputStream bufferedInputStream;
        int i3;
        byte[] bArr;
        int read;
        BufferedInputStream bufferedInputStream2 = null;
        m mVar = null;
        BufferedInputStream bufferedInputStream3 = null;
        BufferedInputStream bufferedInputStream4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleMsgTranslator", 2, "parseFile error: file not exist:" + str);
                }
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                i3 = 4;
            } catch (Exception e16) {
                e = e16;
                bVar = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                bVar = null;
            }
            try {
                try {
                    bArr = new byte[4];
                    read = bufferedInputStream.read(bArr);
                } catch (Exception e18) {
                    e = e18;
                    bVar = null;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    bVar = null;
                }
                if (read < 4) {
                    if (QLog.isColorLevel()) {
                        QLog.d("DoodleMsgTranslator", 2, "parseFile error: header read size:" + read);
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleMsgTranslator", 2, "restore exception when close:" + e26);
                        }
                    }
                    return null;
                }
                int b16 = b(bArr, 0);
                if (b16 > 0 && b16 < 20000) {
                    byte[] bArr2 = new byte[b16];
                    int read2 = bufferedInputStream.read(bArr2, 0, b16);
                    if (read2 < b16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleMsgTranslator", 2, "parseFile error: data not finished" + read2 + "-" + b16);
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e27) {
                            e27.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("DoodleMsgTranslator", 2, "restore exception when close:" + e27);
                            }
                        }
                        return null;
                    }
                    DoodleMsgProto$DoodleHeader doodleMsgProto$DoodleHeader = new DoodleMsgProto$DoodleHeader();
                    try {
                        doodleMsgProto$DoodleHeader.mergeFrom(bArr2);
                    } catch (InvalidProtocolBufferMicroException unused) {
                    }
                    bVar = new b();
                    try {
                        c(bVar, doodleMsgProto$DoodleHeader);
                        int i16 = -1;
                        while (true) {
                            boolean z16 = true;
                            if (bufferedInputStream.read(bArr) == i3) {
                                int b17 = b(bArr, 0);
                                if (b17 <= 0 || b17 >= 20000) {
                                    break;
                                }
                                byte[] bArr3 = new byte[b17];
                                if (bufferedInputStream.read(bArr3, 0, b17) != b17) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("DoodleMsgTranslator", 2, "parseFile error: line data error:" + b17);
                                    }
                                } else {
                                    DoodleMsgProto$DoodleData doodleMsgProto$DoodleData = new DoodleMsgProto$DoodleData();
                                    try {
                                        doodleMsgProto$DoodleData.mergeFrom(bArr3);
                                    } catch (InvalidProtocolBufferMicroException unused2) {
                                    }
                                    int e28 = e(doodleMsgProto$DoodleData);
                                    QLog.d("DoodleMsgTranslator", 2, "parseFile: line id:" + e28);
                                    if (e28 == -1) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("DoodleMsgTranslator", 2, "parseFile error: line id:" + e28);
                                        }
                                    } else {
                                        if (e28 == i16) {
                                            z16 = false;
                                        } else {
                                            if (mVar != null) {
                                                bVar.a(mVar, true, false);
                                            }
                                            m mVar2 = new m();
                                            mVar2.f178563d = e28;
                                            mVar = mVar2;
                                            i16 = e28;
                                        }
                                        d(mVar, doodleMsgProto$DoodleData, z16);
                                        i3 = 4;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        if (mVar != null) {
                            bVar.a(mVar, true, false);
                        }
                        bufferedInputStream.close();
                        QLog.d("DoodleMsgTranslator", 2, "restore parse data ok");
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e29) {
                            exc = e29;
                            exc.printStackTrace();
                            if (QLog.isColorLevel()) {
                                sb5 = new StringBuilder();
                                sb5.append("restore exception when close:");
                                sb5.append(exc);
                                QLog.d("DoodleMsgTranslator", 2, sb5.toString());
                            }
                        }
                    } catch (Exception e36) {
                        e = e36;
                        bufferedInputStream3 = bufferedInputStream;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleMsgTranslator", 2, "restore exception:" + e);
                        }
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (Exception e37) {
                                exc = e37;
                                exc.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    sb5 = new StringBuilder();
                                    sb5.append("restore exception when close:");
                                    sb5.append(exc);
                                    QLog.d("DoodleMsgTranslator", 2, sb5.toString());
                                }
                            }
                        }
                        if (bVar != null) {
                        }
                        return bVar;
                    } catch (OutOfMemoryError e38) {
                        e = e38;
                        bufferedInputStream4 = bufferedInputStream;
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleMsgTranslator", 2, "restore OOM, delete file:" + e.toString());
                        }
                        if (bufferedInputStream4 != null) {
                            try {
                                bufferedInputStream4.close();
                            } catch (Exception e39) {
                                exc = e39;
                                exc.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    sb5 = new StringBuilder();
                                    sb5.append("restore exception when close:");
                                    sb5.append(exc);
                                    QLog.d("DoodleMsgTranslator", 2, sb5.toString());
                                }
                            }
                        }
                        if (bVar != null) {
                        }
                        return bVar;
                    }
                    if (bVar != null) {
                        float g16 = bVar.b().g();
                        float e46 = bVar.b().e();
                        if (g16 > e46) {
                            bVar.b().k(g16);
                            bVar.b().m(e46);
                        }
                        i(bVar);
                    }
                    return bVar;
                }
                QLog.d("DoodleMsgTranslator", 2, "parseFile error: header len:" + b16);
                try {
                    bufferedInputStream.close();
                } catch (Exception e47) {
                    e47.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("DoodleMsgTranslator", 2, "restore exception when close:" + e47);
                    }
                }
                return null;
            } catch (Throwable th6) {
                th5 = th6;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                        throw th5;
                    } catch (Exception e48) {
                        e48.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleMsgTranslator", 2, "restore exception when close:" + e48);
                            throw th5;
                        }
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (Throwable th7) {
            th5 = th7;
        }
    }

    private static void i(b bVar) {
        if (bVar == null) {
            return;
        }
        Iterator<m> it = bVar.c().iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next.g() >= 500) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleMsgTranslator", 2, "reduce point before:" + next.g());
                }
                Iterator<m.a> it5 = next.h().iterator();
                m.a aVar = null;
                while (it5.hasNext()) {
                    m.a next2 = it5.next();
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (aVar == null) {
                        aVar = next2;
                    } else if (Math.abs(next2.d() - aVar.d()) < 10.0f && Math.abs(next2.e() - aVar.e()) < 10.0f) {
                        it5.remove();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleMsgTranslator", 2, "reduce point end:" + next.g());
                }
            }
        }
    }
}
