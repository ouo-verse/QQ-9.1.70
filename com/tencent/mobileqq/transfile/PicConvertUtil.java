package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.mobileqq.config.business.AvifDownloadConfProcessor;
import com.tencent.mobileqq.data.Avif2JpgResult;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;

/* loaded from: classes19.dex */
public class PicConvertUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "avif_PicConvertUtil";
    public static boolean sEnableLogMore;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sEnableLogMore = false;
        }
    }

    public PicConvertUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean LogAndCompressAvifRgbToHdJpg(AvifDecoder avifDecoder, String str, String str2, ThumbWidthHeightDP thumbWidthHeightDP, int i3, Avif2JpgResult avif2JpgResult) {
        Avif2JpgResult.GenerateThumb generateThumb;
        long currentTimeMillis = System.currentTimeMillis();
        boolean compressAvifRgbToHdJpg = compressAvifRgbToHdJpg(avifDecoder, str, str2, thumbWidthHeightDP, i3);
        QLog.i(TAG, 1, "compressAvifRgbToHdJpg retHd: " + compressAvifRgbToHdJpg + "\uff0c cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (compressAvifRgbToHdJpg) {
            generateThumb = Avif2JpgResult.GenerateThumb.SUCCESS;
        } else {
            generateThumb = Avif2JpgResult.GenerateThumb.FAIL;
        }
        avif2JpgResult.setGenerateThumb(generateThumb);
        return compressAvifRgbToHdJpg;
    }

    private static boolean compressAvifRgbToHdJpg(AvifDecoder avifDecoder, String str, String str2, ThumbWidthHeightDP thumbWidthHeightDP, int i3) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        Bitmap d16 = avifDecoder.g().d(false);
        CompressInfo compressInfo = new CompressInfo(str, 0);
        compressInfo.R = true;
        compressInfo.H = str2;
        compressInfo.U = thumbWidthHeightDP;
        return g.l(d16, compressInfo.D, str2, false, compressInfo.f258514d, i3, thumbWidthHeightDP);
    }

    private static boolean compressAvifRgbToJpg(int i3, AvifDecoder avifDecoder, String str) {
        return g.m(str, "compressAvifToJpeg", null, new g.b(avifDecoder.g().d(false), i3) { // from class: com.tencent.mobileqq.transfile.PicConvertUtil.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bitmap val$bm;
            final /* synthetic */ int val$quality;

            {
                this.val$bm = r4;
                this.val$quality = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, i3);
                }
            }

            @Override // com.tencent.mobileqq.pic.compress.g.b
            public void compress(OutputStream outputStream) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                } else {
                    this.val$bm.compress(Bitmap.CompressFormat.JPEG, this.val$quality, outputStream);
                }
            }
        });
    }

    private static boolean compressAvifYuvToHdJpg(int i3, AvifDecoder avifDecoder, String str, ThumbWidthHeightDP thumbWidthHeightDP, int i16) {
        AvifImage g16 = avifDecoder.g();
        int h16 = g16.h();
        int g17 = g16.g();
        g.c u16 = g.u(thumbWidthHeightDP, i16, Math.max(h16, g17));
        float f16 = u16.f258695c / u16.f258693a;
        float f17 = h16;
        float f18 = g17;
        if (f17 <= f18 * f16 && f18 <= f17 * f16) {
            float max = Math.max(h16, g17);
            int i17 = u16.f258695c;
            if (max > i17) {
                float f19 = i17 / max;
                h16 = (int) (f17 * f19);
                g17 = (int) (f18 * f19);
                if (h16 != 0 && g17 != 0) {
                    QLog.i(TAG, 1, "compressAvifYuvToHdJpg scaleImage wh :" + h16 + HippyTKDListViewAdapter.X + g17);
                    if (!avifDecoder.q(h16, g17)) {
                        QLog.i(TAG, 1, "compressAvifYuvToHdJpg scaleImage failed");
                        return false;
                    }
                    g16 = avifDecoder.g();
                } else {
                    QLog.i(TAG, 1, "compressAvifYuvToHdJpg scaleImage failed, wh is 0");
                    return false;
                }
            }
            return g.m(str, "compressAvifYuvToHdJpg", null, new g.b(new YuvImage(g16.a(), 17, h16, g17, null), i3) { // from class: com.tencent.mobileqq.transfile.PicConvertUtil.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$quality;
                final /* synthetic */ YuvImage val$yuvImage;

                {
                    this.val$yuvImage = r4;
                    this.val$quality = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, i3);
                    }
                }

                @Override // com.tencent.mobileqq.pic.compress.g.b
                public void compress(OutputStream outputStream) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                    } else {
                        this.val$yuvImage.compressToJpeg(new Rect(0, 0, this.val$yuvImage.getWidth(), this.val$yuvImage.getHeight()), this.val$quality, outputStream);
                    }
                }
            });
        }
        QLog.i(TAG, 1, "compressAvifYuvToHdJpg ratio is big: " + f16);
        return false;
    }

    private static boolean compressAvifYuvToJpg(int i3, AvifDecoder avifDecoder, String str) {
        AvifImage g16 = avifDecoder.g();
        return g.m(str, "compressAvifToJpeg", null, new g.b(new YuvImage(g16.a(), 17, g16.h(), g16.g(), null), i3) { // from class: com.tencent.mobileqq.transfile.PicConvertUtil.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$quality;
            final /* synthetic */ YuvImage val$yuvImage;

            {
                this.val$yuvImage = r4;
                this.val$quality = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4, i3);
                }
            }

            @Override // com.tencent.mobileqq.pic.compress.g.b
            public void compress(OutputStream outputStream) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                } else {
                    this.val$yuvImage.compressToJpeg(new Rect(0, 0, this.val$yuvImage.getWidth(), this.val$yuvImage.getHeight()), this.val$quality, outputStream);
                }
            }
        });
    }

    public static Avif2JpgResult convertAvif2Jpg(int i3, String str, String str2, @Nullable String str3, @Nullable ThumbWidthHeightDP thumbWidthHeightDP, int i16) {
        return convertAvif2Jpg(i3, str, str2, str3, thumbWidthHeightDP, i16, false);
    }

    public static Avif2JpgResult debugConvertAvif2Jpg(String str, String str2, @Nullable String str3, @Nullable ThumbWidthHeightDP thumbWidthHeightDP, int i3, boolean z16) {
        return convertAvif2Jpg(AvifDownloadConfProcessor.a().c(), str, str2, str3, thumbWidthHeightDP, i3, z16);
    }

    private static boolean isAvifDecodeSwithOpen(String str) {
        return false;
    }

    private static boolean logAndCompressAvifRgbToJpg(int i3, AvifDecoder avifDecoder, String str, Avif2JpgResult avif2JpgResult) {
        Avif2JpgResult.ConvertToJpg convertToJpg;
        long currentTimeMillis = System.currentTimeMillis();
        boolean compressAvifRgbToJpg = compressAvifRgbToJpg(i3, avifDecoder, str);
        QLog.i(TAG, 1, "compressAvifRgbToJpg ret: " + compressAvifRgbToJpg + "\uff0c cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (compressAvifRgbToJpg) {
            convertToJpg = Avif2JpgResult.ConvertToJpg.SUCCESS_BY_RGB;
        } else {
            convertToJpg = Avif2JpgResult.ConvertToJpg.FAIL;
        }
        avif2JpgResult.setConvertToJpg(convertToJpg);
        return compressAvifRgbToJpg;
    }

    private static boolean logAndCompressAvifYuvToHdJpg(int i3, AvifDecoder avifDecoder, String str, ThumbWidthHeightDP thumbWidthHeightDP, int i16, Avif2JpgResult avif2JpgResult) {
        Avif2JpgResult.GenerateThumb generateThumb;
        long currentTimeMillis = System.currentTimeMillis();
        boolean compressAvifYuvToHdJpg = compressAvifYuvToHdJpg(i3, avifDecoder, str, thumbWidthHeightDP, i16);
        QLog.i(TAG, 1, "compressAvifYuvToHdJpg retHd: " + compressAvifYuvToHdJpg + "\uff0c cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (compressAvifYuvToHdJpg) {
            generateThumb = Avif2JpgResult.GenerateThumb.SUCCESS;
        } else {
            generateThumb = Avif2JpgResult.GenerateThumb.FAIL;
        }
        avif2JpgResult.setGenerateThumb(generateThumb);
        return compressAvifYuvToHdJpg;
    }

    private static boolean logAndCompressAvifYuvToJpg(int i3, AvifDecoder avifDecoder, String str, Avif2JpgResult avif2JpgResult) {
        Avif2JpgResult.ConvertToJpg convertToJpg;
        long currentTimeMillis = System.currentTimeMillis();
        boolean compressAvifYuvToJpg = compressAvifYuvToJpg(i3, avifDecoder, str);
        QLog.i(TAG, 1, "compressAvifYuvToJpg ret: " + compressAvifYuvToJpg + "\uff0c cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (compressAvifYuvToJpg) {
            convertToJpg = Avif2JpgResult.ConvertToJpg.SUCCESS_BY_YUV;
        } else {
            convertToJpg = Avif2JpgResult.ConvertToJpg.FAIL;
        }
        avif2JpgResult.setConvertToJpg(convertToJpg);
        return compressAvifYuvToJpg;
    }

    private static void logMore(String str, @androidx.annotation.Nullable String str2, long j3, byte[] bArr, int i3, int i16, boolean z16) {
        Bitmap decodeFile;
        if (isAvifDecodeSwithOpen("debug_avif_watermask_switch") || sEnableLogMore) {
            StringBuilder sb5 = new StringBuilder("\u683c\u5f0f\uff1aavif");
            sb5.append("\n\u5c3a\u5bf8\uff1a");
            sb5.append(i3);
            sb5.append(HippyTKDListViewAdapter.X);
            sb5.append(i16);
            sb5.append("\navif\u5927\u5c0f\uff1a");
            sb5.append(bArr.length / 1000);
            sb5.append("kb");
            sb5.append("\n\u751f\u6210jpg\u5927\u56fe\u5927\u5c0f\uff1a");
            sb5.append(new File(str).length() / 1000);
            sb5.append("kb");
            if (z16) {
                sb5.append("\n\u751f\u6210\u9ad8\u6e05\u7f29\u7565\u56fe\u5927\u5c0f\uff1a");
                sb5.append(new File(str2).length() / 1000);
                sb5.append("kb");
            }
            sb5.append("\n\u603b\u8017\u65f6\uff1a");
            sb5.append(System.currentTimeMillis() - j3);
            sb5.append("ms");
            String sb6 = sb5.toString();
            QLog.i(TAG, 1, "compressAvifToJpg waterInfo: " + sb6);
            if (z16 && (decodeFile = BitmapFactory.decodeFile(str2)) != null) {
                sb6 = sb6 + "\n\u9ad8\u6e05\u7f29\u7565\u56fe\u5c3a\u5bf8\uff1a" + decodeFile.getWidth() + HippyTKDListViewAdapter.X + decodeFile.getHeight();
                Bitmap copy = decodeFile.copy(decodeFile.getConfig(), true);
                g.p(copy, sb6, 10.0f);
                g.m(str2, "drawWaterMask", null, new g.b(copy) { // from class: com.tencent.mobileqq.transfile.PicConvertUtil.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Bitmap val$finalBm;

                    {
                        this.val$finalBm = copy;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) copy);
                        }
                    }

                    @Override // com.tencent.mobileqq.pic.compress.g.b
                    public void compress(OutputStream outputStream) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                        } else {
                            this.val$finalBm.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                        }
                    }
                });
            }
            Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
            if (decodeFile2 != null) {
                Bitmap copy2 = decodeFile2.copy(decodeFile2.getConfig(), true);
                g.p(copy2, sb6, 32.0f);
                g.m(str, "drawWaterMask", null, new g.b(copy2) { // from class: com.tencent.mobileqq.transfile.PicConvertUtil.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Bitmap val$finalBm;

                    {
                        this.val$finalBm = copy2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) copy2);
                        }
                    }

                    @Override // com.tencent.mobileqq.pic.compress.g.b
                    public void compress(OutputStream outputStream) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                        } else {
                            this.val$finalBm.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                        }
                    }
                });
            }
        }
    }

    private static boolean preCheckValid(String str, String str2, Avif2JpgResult avif2JpgResult) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!new File(str).exists()) {
                avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.SRC_FILE_NOT_EXIST);
                return false;
            }
            if (!com.tencent.mobileqq.avifcodec.b.b().c()) {
                com.tencent.mobileqq.avifcodec.b.b().f(new x91.a() { // from class: com.tencent.mobileqq.transfile.PicConvertUtil.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // x91.a
                    public void onAvifLibraryLoadResult(boolean z16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, z16);
                            return;
                        }
                        QLog.d(PicConvertUtil.TAG, 1, "load avif library:" + z16);
                    }
                });
                avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.AVIF_SO_NOT_LOADED);
                return false;
            }
            if (!com.tencent.mobileqq.avifcodec.util.b.b(str)) {
                avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.SRC_FILE_NOT_AVIF);
                return false;
            }
            return true;
        }
        avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.PATH_INVALID);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de A[Catch: all -> 0x0123, TryCatch #0 {all -> 0x0123, blocks: (B:38:0x00c3, B:40:0x00de, B:43:0x00e5, B:44:0x00f5, B:52:0x0109, B:17:0x0117), top: B:14:0x0045 }] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Avif2JpgResult convertAvif2Jpg(int i3, String str, String str2, @Nullable String str3, @Nullable ThumbWidthHeightDP thumbWidthHeightDP, int i16, boolean z16) {
        int i17;
        int i18;
        AvifDecoder avifDecoder;
        boolean z17;
        boolean z18;
        Avif2JpgResult avif2JpgResult = new Avif2JpgResult();
        ?? r102 = 1;
        boolean z19 = !TextUtils.isEmpty(str3);
        if (!isAvifDecodeSwithOpen("debug_avif_decode_crash")) {
            if (isAvifDecodeSwithOpen("debug_avif_decode_failed")) {
                return avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.FAIL_WITH_DEBUG_EXCEPTION);
            }
            if (!preCheckValid(str, str2, avif2JpgResult)) {
                return avif2JpgResult;
            }
            System.currentTimeMillis();
            AvifDecoder avifDecoder2 = null;
            try {
                byte[] readFile = FileUtils.readFile(str);
                long currentTimeMillis = System.currentTimeMillis();
                AvifDecoder c16 = AvifDecoder.c(readFile);
                try {
                    if (c16 != null) {
                        try {
                            if (c16.n() == 0) {
                                QLog.i(TAG, 1, "compressAvifToJpg decode to yuv cost :" + (System.currentTimeMillis() - currentTimeMillis));
                                AvifImage g16 = c16.g();
                                int h16 = g16.h();
                                int g17 = g16.g();
                                if (h16 > 0 && g17 > 0) {
                                    QLog.i(TAG, 1, "compressAvifToJpg srcImage wh :" + h16 + HippyTKDListViewAdapter.X + g17);
                                    boolean g18 = AvifDownloadConfProcessor.a().g();
                                    if (!z16 && g16.i() == 3 && g18) {
                                        boolean logAndCompressAvifYuvToJpg = logAndCompressAvifYuvToJpg(i3, c16, str2, avif2JpgResult);
                                        if (logAndCompressAvifYuvToJpg && z19) {
                                            i17 = g17;
                                            i18 = h16;
                                            avifDecoder = c16;
                                            z18 = logAndCompressAvifYuvToHdJpg(i3, c16, str3, thumbWidthHeightDP, i16, avif2JpgResult);
                                            z17 = logAndCompressAvifYuvToJpg;
                                            if (!z17) {
                                                logAndCompressAvifRgbToJpg(i3, avifDecoder, str2, avif2JpgResult);
                                            }
                                            if (!z18 && z19) {
                                                z18 = LogAndCompressAvifRgbToHdJpg(avifDecoder, str, str3, thumbWidthHeightDP, i16, avif2JpgResult);
                                            }
                                            logMore(str2, str3, currentTimeMillis, readFile, i18, i17, z18);
                                            avifDecoder.b();
                                            return avif2JpgResult;
                                        }
                                        i17 = g17;
                                        i18 = h16;
                                        avifDecoder = c16;
                                        z17 = logAndCompressAvifYuvToJpg;
                                    } else {
                                        i17 = g17;
                                        i18 = h16;
                                        avifDecoder = c16;
                                        z17 = false;
                                    }
                                    z18 = false;
                                    if (!z17) {
                                    }
                                    if (!z18) {
                                        z18 = LogAndCompressAvifRgbToHdJpg(avifDecoder, str, str3, thumbWidthHeightDP, i16, avif2JpgResult);
                                    }
                                    logMore(str2, str3, currentTimeMillis, readFile, i18, i17, z18);
                                    avifDecoder.b();
                                    return avif2JpgResult;
                                }
                                Avif2JpgResult convertToJpg = avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.YUV_SIZE_INVALID);
                                c16.b();
                                return convertToJpg;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            r102 = c16;
                            avifDecoder2 = r102;
                            try {
                                QLog.e(TAG, 1, "compressAvifToJpg error ", th);
                                if (th instanceof OutOfMemoryError) {
                                    return avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.FAIL_WITH_OOM);
                                }
                                Avif2JpgResult convertToJpg2 = avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.FAIL_WITH_EXCEPTION);
                                if (avifDecoder2 != null) {
                                    avifDecoder2.b();
                                }
                                return convertToJpg2;
                            } finally {
                                if (avifDecoder2 != null) {
                                    avifDecoder2.b();
                                }
                            }
                        }
                    }
                    Avif2JpgResult convertToJpg3 = avif2JpgResult.setConvertToJpg(Avif2JpgResult.ConvertToJpg.YUV_FAIL);
                    if (c16 != null) {
                        c16.b();
                    }
                    return convertToJpg3;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } else {
            throw new Error("debug_avif_decode_crash open");
        }
    }
}
