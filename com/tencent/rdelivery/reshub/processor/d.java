package com.tencent.rdelivery.reshub.processor;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.io.File;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/d;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Ljz3/e;", DownloadInfo.spKey_Config, "", "unZippedFilePath", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "unZipDir", "l", "", "k", "", "getPriority", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "i", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class d extends a {
    private final boolean k(jz3.e config) {
        jz3.d.e("CompOrigFileUnzip", "checkUnzipped  " + ("ResId: " + config.f411260a + "\n unzippedCompOrigLocal: " + config.K + "\n OriginFilePath: " + config.H + "\nencryptLocal: " + config.I + " ,isEncrypted: " + config.f411273n));
        return !TextUtils.isEmpty(config.K);
    }

    private final String l(String unZipDir) {
        boolean startsWith$default;
        String[] list = new File(unZipDir).list();
        String str = "";
        if (list != null) {
            if (list.length == 1) {
                String str2 = list[0];
                Intrinsics.checkExpressionValueIsNotNull(str2, "files[0]");
                str = str2;
            } else if (list.length > 1) {
                for (String it : list) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, ".", false, 2, null);
                    if (!startsWith$default) {
                        Intrinsics.checkExpressionValueIsNotNull(it, "files.first { !it.startsWith(\".\") }");
                        str = it;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        }
        return unZipDir + File.separator + str;
    }

    private final void m(jz3.e config, String unZippedFilePath) {
        if (config.f411273n == 1) {
            config.I = unZippedFilePath;
        } else {
            config.H = unZippedFilePath;
        }
        config.K = unZippedFilePath;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 550;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:82|83|84|85|86|(6:(8:88|89|90|91|92|(1:94)(1:98)|95|96)|91|92|(0)(0)|95|96)|104|89|90) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d2, code lost:
    
        r7 = r19;
        r1 = r20;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0238 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b7 A[Catch: all -> 0x01cd, TryCatch #7 {all -> 0x01cd, blocks: (B:92:0x0195, B:94:0x01b7, B:95:0x01bc, B:98:0x01ba), top: B:91:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ba A[Catch: all -> 0x01cd, TryCatch #7 {all -> 0x01cd, blocks: (B:92:0x0195, B:94:0x01b7, B:95:0x01bc, B:98:0x01ba), top: B:91:0x0195 }] */
    @Override // com.tencent.rdelivery.reshub.processor.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        String compressedOriginFilePath;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        Object m476constructorimpl;
        boolean z18;
        boolean z19;
        String str3;
        Throwable m479exceptionOrNullimpl;
        int i3;
        StringBuilder sb5;
        String str4;
        String str5;
        String str6;
        boolean z26;
        String str7;
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            j(chain, req, 211);
            return;
        }
        if (req.getBigResPatchChecked()) {
            jz3.d.e("CompOrigFileUnzip", "proceed return for bigResPatchChecked");
            chain.c(req);
            return;
        }
        if (!resConfig.k()) {
            jz3.d.e("CompOrigFileUnzip", "proceed return for not compOrigFile");
            chain.c(req);
            return;
        }
        com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        if (resConfig.g()) {
            jz3.d.e("CompOrigFileUnzip", "proceed return for local file exist");
            cVar.c();
            chain.c(req);
            return;
        }
        String str8 = resConfig.J;
        if (TextUtils.isEmpty(str8)) {
            jz3.d.c("CompOrigFileUnzip", "proceed return for empty compressedOriginFilePath");
            cVar.c();
            chain.c(req);
            return;
        }
        if (k(resConfig)) {
            cVar.c();
            chain.c(req);
            return;
        }
        String str9 = str8;
        a.h(this, 15, req, null, 0L, 0L, 24, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            sb5 = new StringBuilder();
            compressedOriginFilePath = str9;
        } catch (Throwable th5) {
            th = th5;
            compressedOriginFilePath = str9;
        }
        try {
            File parentFile = new File(compressedOriginFilePath).getParentFile();
            Intrinsics.checkExpressionValueIsNotNull(parentFile, "File(compressedOriginFilePath).parentFile");
            sb5.append(parentFile.getAbsolutePath());
            sb5.append(File.separator);
            sb5.append("compUnzip");
            str2 = sb5.toString();
            try {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("proceed debug,unZipDir: ");
                sb6.append(str2);
                sb6.append(',');
                sb6.append(" parentFilePath: ");
                File parentFile2 = new File(compressedOriginFilePath).getParentFile();
                Intrinsics.checkExpressionValueIsNotNull(parentFile2, "File(compressedOriginFilePath).parentFile");
                sb6.append(parentFile2.getAbsolutePath());
                jz3.d.e("CompOrigFileUnzip", sb6.toString());
                String l3 = l(str2);
                try {
                    int i16 = resConfig.f411273n;
                    if (i16 == 1) {
                        try {
                            str4 = resConfig.f411275p;
                        } catch (Throwable th6) {
                            th = th6;
                            str = l3;
                            z16 = false;
                            z17 = false;
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                            z18 = z17;
                            z19 = z16;
                            str3 = str;
                            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl != null) {
                            }
                            jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
                            if (!z19) {
                            }
                            jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
                            com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
                            if (z19) {
                            }
                            aVar.e(i3);
                            String str10 = str2;
                            a.h(this, 16, req, aVar, 0L, 0L, 24, null);
                            try {
                                jz3.c.f(new File(str10), true);
                                Result.m476constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th7) {
                                Result.Companion companion3 = Result.INSTANCE;
                                Result.m476constructorimpl(ResultKt.createFailure(th7));
                            }
                            cVar.c();
                            chain.c(req);
                        }
                    } else {
                        str4 = resConfig.f411264e;
                    }
                    if (i16 == 1) {
                        str5 = resConfig.f411276q;
                    } else {
                        str5 = resConfig.f411265f;
                    }
                    String str11 = str5;
                    z17 = jz3.c.b(l3, str11, str4);
                    try {
                        if (z17) {
                            try {
                                jz3.d.e("CompOrigFileUnzip", "proceed skip real unzip for already exist,unZipDir: " + str2 + ", unZippedFilePath: " + l3);
                                str = l3;
                                z16 = true;
                            } catch (Throwable th8) {
                                th = th8;
                                str = l3;
                                z16 = false;
                                Result.Companion companion22 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                                z18 = z17;
                                z19 = z16;
                                str3 = str;
                                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                                if (m479exceptionOrNullimpl != null) {
                                }
                                jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
                                if (!z19) {
                                }
                                jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
                                com.tencent.rdelivery.reshub.report.a aVar2 = new com.tencent.rdelivery.reshub.report.a();
                                if (z19) {
                                }
                                aVar2.e(i3);
                                String str102 = str2;
                                a.h(this, 16, req, aVar2, 0L, 0L, 24, null);
                                jz3.c.f(new File(str102), true);
                                Result.m476constructorimpl(Unit.INSTANCE);
                                cVar.c();
                                chain.c(req);
                            }
                        } else {
                            try {
                                Intrinsics.checkExpressionValueIsNotNull(compressedOriginFilePath, "compressedOriginFilePath");
                                str6 = str11;
                                str9 = l3;
                            } catch (Exception e16) {
                                e = e16;
                                str6 = str11;
                                str9 = l3;
                            } catch (Throwable th9) {
                                th = th9;
                                str9 = l3;
                                str = str9;
                                z16 = false;
                                Result.Companion companion222 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                                z18 = z17;
                                z19 = z16;
                                str3 = str;
                                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                                if (m479exceptionOrNullimpl != null) {
                                }
                                jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
                                if (!z19) {
                                }
                                jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
                                com.tencent.rdelivery.reshub.report.a aVar22 = new com.tencent.rdelivery.reshub.report.a();
                                if (z19) {
                                }
                                aVar22.e(i3);
                                String str1022 = str2;
                                a.h(this, 16, req, aVar22, 0L, 0L, 24, null);
                                jz3.c.f(new File(str1022), true);
                                Result.m476constructorimpl(Unit.INSTANCE);
                                cVar.c();
                                chain.c(req);
                            }
                            try {
                            } catch (Exception e17) {
                                e = e17;
                                jz3.d.d("CompOrigFileUnzip", "Unzip Exception: " + e.getMessage(), e);
                                z26 = false;
                                str = l(str2);
                                jz3.d.e("CompOrigFileUnzip", "proceed unZipDir: " + str2 + ", unZippedFilePath: " + str);
                                if (resConfig.f411273n == 1) {
                                }
                                z17 = jz3.c.b(str, str6, str7);
                                z16 = z26;
                                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                                z18 = z17;
                                z19 = z16;
                                str3 = str;
                                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                                if (m479exceptionOrNullimpl != null) {
                                }
                                jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
                                if (!z19) {
                                }
                                jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
                                com.tencent.rdelivery.reshub.report.a aVar222 = new com.tencent.rdelivery.reshub.report.a();
                                if (z19) {
                                }
                                aVar222.e(i3);
                                String str10222 = str2;
                                a.h(this, 16, req, aVar222, 0L, 0L, 24, null);
                                jz3.c.f(new File(str10222), true);
                                Result.m476constructorimpl(Unit.INSTANCE);
                                cVar.c();
                                chain.c(req);
                            }
                            try {
                                if (com.tencent.rdelivery.reshub.core.g.b(compressedOriginFilePath, str2, false, null, 12, null) == 0) {
                                    z26 = true;
                                    str = l(str2);
                                    jz3.d.e("CompOrigFileUnzip", "proceed unZipDir: " + str2 + ", unZippedFilePath: " + str);
                                    if (resConfig.f411273n == 1) {
                                        str7 = resConfig.f411275p;
                                    } else {
                                        str7 = resConfig.f411264e;
                                    }
                                    z17 = jz3.c.b(str, str6, str7);
                                    z16 = z26;
                                }
                                jz3.d.e("CompOrigFileUnzip", "proceed unZipDir: " + str2 + ", unZippedFilePath: " + str);
                                if (resConfig.f411273n == 1) {
                                }
                                z17 = jz3.c.b(str, str6, str7);
                                z16 = z26;
                            } catch (Throwable th10) {
                                th = th10;
                                z16 = z26;
                                Result.Companion companion2222 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                                z18 = z17;
                                z19 = z16;
                                str3 = str;
                                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                                if (m479exceptionOrNullimpl != null) {
                                }
                                jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
                                if (!z19) {
                                }
                                jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
                                com.tencent.rdelivery.reshub.report.a aVar2222 = new com.tencent.rdelivery.reshub.report.a();
                                if (z19) {
                                }
                                aVar2222.e(i3);
                                String str102222 = str2;
                                a.h(this, 16, req, aVar2222, 0L, 0L, 24, null);
                                jz3.c.f(new File(str102222), true);
                                Result.m476constructorimpl(Unit.INSTANCE);
                                cVar.c();
                                chain.c(req);
                            }
                            z26 = false;
                            str = l(str2);
                        }
                        try {
                            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th11) {
                            th = th11;
                            Result.Companion companion22222 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
                            z18 = z17;
                            z19 = z16;
                            str3 = str;
                            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl != null) {
                            }
                            jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
                            if (!z19) {
                            }
                            jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
                            com.tencent.rdelivery.reshub.report.a aVar22222 = new com.tencent.rdelivery.reshub.report.a();
                            if (z19) {
                            }
                            aVar22222.e(i3);
                            String str1022222 = str2;
                            a.h(this, 16, req, aVar22222, 0L, 0L, 24, null);
                            jz3.c.f(new File(str1022222), true);
                            Result.m476constructorimpl(Unit.INSTANCE);
                            cVar.c();
                            chain.c(req);
                        }
                    } catch (Throwable th12) {
                        th = th12;
                    }
                } catch (Throwable th13) {
                    th = th13;
                    str = l3;
                }
            } catch (Throwable th14) {
                th = th14;
                str = "";
            }
        } catch (Throwable th15) {
            th = th15;
            str = "";
            str2 = str;
            z16 = false;
            z17 = false;
            Result.Companion companion222222 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th));
            z18 = z17;
            z19 = z16;
            str3 = str;
            m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
            }
            jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
            if (!z19) {
            }
            jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
            com.tencent.rdelivery.reshub.report.a aVar222222 = new com.tencent.rdelivery.reshub.report.a();
            if (z19) {
            }
            aVar222222.e(i3);
            String str10222222 = str2;
            a.h(this, 16, req, aVar222222, 0L, 0L, 24, null);
            jz3.c.f(new File(str10222222), true);
            Result.m476constructorimpl(Unit.INSTANCE);
            cVar.c();
            chain.c(req);
        }
        z18 = z17;
        z19 = z16;
        str3 = str;
        m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            jz3.d.e("CompOrigFileUnzip", "proceed exception, ext = " + m479exceptionOrNullimpl);
        }
        jz3.d.e("CompOrigFileUnzip", "proceed success: " + z19 + ",fileValid: " + z18);
        if (!z19 && z18) {
            String str12 = compressedOriginFilePath;
            a.h(this, 16, req, null, 0L, 0L, 24, null);
            try {
                jz3.c.f(new File(str12), true);
                Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th16) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th16));
            }
            m(resConfig, str3);
            cVar.c();
            chain.c(req);
            return;
        }
        jz3.d.c("CompOrigFileUnzip", "Unzip Res File Fail. (Unzip: " + z19 + " MD5Check: " + z18 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + str2 + "\nunZippedFilePath: " + str3 + '\n');
        com.tencent.rdelivery.reshub.report.a aVar2222222 = new com.tencent.rdelivery.reshub.report.a();
        if (z19) {
            i3 = 3101;
        } else {
            i3 = 3102;
        }
        aVar2222222.e(i3);
        String str102222222 = str2;
        a.h(this, 16, req, aVar2222222, 0L, 0L, 24, null);
        jz3.c.f(new File(str102222222), true);
        Result.m476constructorimpl(Unit.INSTANCE);
        cVar.c();
        chain.c(req);
    }
}
