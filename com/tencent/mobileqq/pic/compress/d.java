package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static int f258687m;

    /* renamed from: j, reason: collision with root package name */
    protected String f258688j;

    /* renamed from: k, reason: collision with root package name */
    CompressInfo f258689k;

    /* renamed from: l, reason: collision with root package name */
    protected int f258690l;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18310);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f258687m = 960;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) compressInfo);
            return;
        }
        this.f258688j = getClass().getSimpleName();
        if (compressInfo != null && !TextUtils.isEmpty(compressInfo.D)) {
            this.f258689k = compressInfo;
            int e16 = e(compressInfo);
            this.f258690l = e16;
            if (e16 != -1) {
                return;
            } else {
                throw new IllegalArgumentException("create PicQuality is Fail");
            }
        }
        throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.pic.compress.a
    public final boolean a() {
        if (this.f258690l == 2) {
            return c();
        }
        return d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.pic.compress.a
    public final boolean b() {
        boolean g16;
        boolean z16 = false;
        if (!FileUtils.fileExistsAndNotEmpty(this.f258689k.D)) {
            com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " startThumbnail()", " src file does not exist");
            return false;
        }
        CompressInfo compressInfo = this.f258689k;
        if (compressInfo.H == null) {
            compressInfo.H = g.v(compressInfo.D);
            if (TextUtils.isEmpty(this.f258689k.H)) {
                com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " startThumbnail()", " destPath is empty");
                return false;
            }
        }
        if (FileUtils.fileExistsAndNotEmpty(this.f258689k.H) && !this.f258689k.R) {
            com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " startThumbnail()", " destPath exist. return true");
            return true;
        }
        try {
            CompressInfo compressInfo2 = this.f258689k;
            if (compressInfo2.K == 2) {
                g16 = g.g(compressInfo2.D, compressInfo2.H, compressInfo2.C, compressInfo2.f258514d, 3, compressInfo2.U);
            } else {
                g16 = g.g(compressInfo2.D, compressInfo2.H, compressInfo2.C, compressInfo2.f258514d, 0, compressInfo2.U);
            }
            z16 = g16;
        } catch (Exception e16) {
            e16.printStackTrace();
            com.tencent.mobileqq.pic.f.d(this.f258688j, "startThumbnail()", e16.getMessage());
        }
        if (!z16) {
            this.f258689k.H = "";
            com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " startThumbnail()", " compressAIOThumbnail is failed");
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        CompressInfo compressInfo = this.f258689k;
        if (compressInfo.L == 2) {
            if (g.r(compressInfo.D) <= ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit()) {
                CompressInfo compressInfo2 = this.f258689k;
                compressInfo2.H = compressInfo2.D;
                compressInfo2.P = this.f258688j + this.f258689k.f258514d + HardCodeUtil.qqStr(R.string.p75);
                com.tencent.mobileqq.pic.f.b(this.f258688j, this.f258689k.f258514d + " commonCompress()", HardCodeUtil.qqStr(R.string.f172294p74));
                CompressInfo compressInfo3 = this.f258689k;
                if (compressInfo3.K != 2) {
                    compressInfo3.Q = true;
                }
            } else {
                com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " commonCompress()", HardCodeUtil.qqStr(R.string.p79));
            }
        } else {
            int g16 = g();
            long j3 = g16;
            if (g.r(this.f258689k.D) > j3) {
                com.tencent.mobileqq.pic.f.b(this.f258688j, this.f258689k.f258514d + " commonCompress()", " src file size > max, file size:" + g.r(this.f258689k.D) + " max:" + g16);
                CompressInfo compressInfo4 = this.f258689k;
                compressInfo4.H = g.t(compressInfo4.D, compressInfo4.L);
                if (TextUtils.isEmpty(this.f258689k.H)) {
                    com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " commonCompress()", " destPath is empty");
                    return false;
                }
                if (FileUtils.fileExistsAndNotEmpty(this.f258689k.H)) {
                    com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " commonCompress()", " destPath exist. return true");
                    return true;
                }
                CompressInfo compressInfo5 = this.f258689k;
                compressInfo5.N = 0;
                int h16 = h(compressInfo5.D, compressInfo5.H, true);
                if (h16 != 0) {
                    CompressInfo compressInfo6 = this.f258689k;
                    compressInfo6.N += h16;
                    if (g.r(compressInfo6.H) > j3) {
                        CompressInfo compressInfo7 = this.f258689k;
                        if (compressInfo7.N >= 2) {
                            compressInfo7.b(false);
                            this.f258689k.P = this.f258688j + this.f258689k.f258514d + " commonCompress() \u9762\u79ef\u662f\u539f\u6765\u76841/16\uff0c\u4e0d\u80fd\u518d\u5c0f\u4e86fileSize:" + g.r(this.f258689k.H) + " max:" + g16;
                            String str = this.f258688j;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(this.f258689k.f258514d);
                            sb5.append(" commonCompress()");
                            com.tencent.mobileqq.pic.f.d(str, sb5.toString(), " \u9762\u79ef\u662f\u539f\u6765\u76841/16\uff0c\u4e0d\u80fd\u518d\u5c0f\u4e86fileSize:" + g.r(this.f258689k.H) + " max:" + g16);
                            FileUtils.deleteFile(this.f258689k.H);
                            this.f258689k.H = "";
                            return false;
                        }
                        String str2 = compressInfo7.H;
                        String str3 = str2 + "_second";
                        this.f258689k.H = "";
                        int h17 = h(str2, str3, false);
                        FileUtils.deleteFile(str2);
                        if (h17 != 0) {
                            CompressInfo compressInfo8 = this.f258689k;
                            compressInfo8.N += h17;
                            compressInfo8.H = str3;
                            if (g.r(str3) > j3) {
                                this.f258689k.b(false);
                                this.f258689k.P = this.f258688j + this.f258689k.f258514d + " commonCompress()" + HardCodeUtil.qqStr(R.string.p7_) + g.r(str3) + " max:" + g16;
                                String str4 = this.f258688j;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(this.f258689k.f258514d);
                                sb6.append(" commonCompress()");
                                com.tencent.mobileqq.pic.f.d(str4, sb6.toString(), HardCodeUtil.qqStr(R.string.p7a) + g.r(str3) + " max:" + g16);
                                FileUtils.deleteFile(this.f258689k.H);
                                this.f258689k.H = "";
                                return false;
                            }
                        } else {
                            CompressInfo compressInfo9 = this.f258689k;
                            compressInfo9.H = "";
                            compressInfo9.P = this.f258688j + this.f258689k.f258514d + " commonCompress()" + HardCodeUtil.qqStr(R.string.p78);
                            String str5 = this.f258688j;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(this.f258689k.f258514d);
                            sb7.append(" commonCompress()");
                            com.tencent.mobileqq.pic.f.d(str5, sb7.toString(), HardCodeUtil.qqStr(R.string.p76));
                            return false;
                        }
                    }
                } else {
                    CompressInfo compressInfo10 = this.f258689k;
                    compressInfo10.H = "";
                    compressInfo10.P = this.f258688j + this.f258689k.f258514d + " commonCompress() sampleCompress failed";
                    com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " commonCompress()", " sampleCompress failed");
                    return false;
                }
            } else {
                CompressInfo compressInfo11 = this.f258689k;
                compressInfo11.H = compressInfo11.D;
                compressInfo11.P = this.f258688j + this.f258689k.f258514d + HardCodeUtil.qqStr(R.string.p7b);
                com.tencent.mobileqq.pic.f.b(this.f258688j, this.f258689k.f258514d + " commonCompress()", HardCodeUtil.qqStr(R.string.p77));
                CompressInfo compressInfo12 = this.f258689k;
                if (compressInfo12.K != 2) {
                    compressInfo12.Q = true;
                }
            }
        }
        return true;
    }

    protected abstract boolean d();

    protected abstract int e(CompressInfo compressInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        CompressInfo compressInfo = this.f258689k;
        if (compressInfo.L == 2) {
            i3 = 100;
        } else {
            int i16 = compressInfo.M;
            if (i16 != 1) {
                if (i16 != 4) {
                    i3 = a.f258669b;
                } else {
                    i3 = a.f258670c;
                }
            } else {
                i3 = a.f258668a;
            }
        }
        com.tencent.mobileqq.pic.f.b(this.f258688j, "getCompressQuality", "compressQuality = " + i3);
        return i3;
    }

    final int g() {
        if (this.f258689k.M == 1) {
            return 20971520;
        }
        return 4194304;
    }

    public int h(String str, String str2, boolean z16) {
        Bitmap decodeFile;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, str, str2, Boolean.valueOf(z16))).intValue();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && FileUtils.fileExistsAndNotEmpty(str)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 2;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            try {
                decodeFile = SafeBitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError unused) {
                this.f258689k.b(true);
                com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " sampleCompress()", " decodeFile OutOfMemoryError, sampleCnt:1 oomKeepCompress:" + z16);
                if (z16) {
                    options.inSampleSize = 4;
                    try {
                        decodeFile = SafeBitmapFactory.decodeFile(str, options);
                    } catch (OutOfMemoryError e16) {
                        this.f258689k.b(false);
                        e16.printStackTrace();
                        com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " sampleCompress()", " oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:2");
                        return 0;
                    }
                }
                return 0;
            }
            if (decodeFile == null) {
                com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " sampleCompress()", " bm == null, maybe is broken");
                return 0;
            }
            i3 = 1;
            int f16 = f();
            CompressInfo compressInfo = this.f258689k;
            boolean i16 = g.i(str2, decodeFile, f16, compressInfo.f258514d, compressInfo);
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            if (!i16) {
                return 0;
            }
            return i3;
        }
        com.tencent.mobileqq.pic.f.d(this.f258688j, this.f258689k.f258514d + " sampleCompress()", " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + str + " outfilePath:" + str2);
        return 0;
    }
}
