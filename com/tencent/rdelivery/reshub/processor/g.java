package com.tencent.rdelivery.reshub.processor;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.rdelivery.reshub.FileSuffix;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J&\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010\u0019\u001a\u00020\u0002*\u00020\u0004H\u0002J8\u0010!\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/g;", "Lcom/tencent/rdelivery/reshub/processor/a;", "", "filePath", "Ljz3/e;", "curConfig", "Lkotlin/Pair;", "", "k", "targetFilePath", "", "keepEncryptFile", "", DomainData.DOMAIN_NAME, "encryptFilePath", "secretKey", "", "l", "Ljava/io/FileInputStream;", "inputStream", "Ljava/io/FileOutputStream;", "outputStream", "Ljavax/crypto/Cipher;", "cipher", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "errorCode", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "exception", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getPriority", "i", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class g extends a {
    private final Pair<Integer, String> k(String filePath, jz3.e curConfig) {
        boolean z16;
        if (filePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            jz3.d.c("Decrypt", "No Downloaded Encrypt File Path. Res(" + curConfig.f411260a + ").");
            return new Pair<>(2005, "No Local Download Encrypted Res File.");
        }
        if (!jz3.f.a(curConfig)) {
            jz3.c.f(new File(filePath), true);
            jz3.d.c("Decrypt", "Bad Encrypt File (MD5 Check Fail), Deleted. Res(" + curConfig.f411260a + ") Path: " + filePath);
            return new Pair<>(2006, "Bad Encrypt File (MD5 Check Fail)");
        }
        return null;
    }

    private final void l(String encryptFilePath, String targetFilePath, String secretKey) {
        byte[] sliceArray;
        Charset charset = Charsets.UTF_8;
        if (secretKey != null) {
            byte[] bytes = secretKey.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            sliceArray = ArraysKt___ArraysKt.sliceArray(bytes, new IntRange(0, 15));
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
            cipher.init(2, secretKeySpec, new IvParameterSpec(sliceArray));
            FileInputStream fileInputStream = new FileInputStream(new File(encryptFilePath));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(targetFilePath));
                try {
                    Intrinsics.checkExpressionValueIsNotNull(cipher, "cipher");
                    m(fileInputStream, fileOutputStream, cipher);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void m(FileInputStream inputStream, FileOutputStream outputStream, Cipher cipher) {
        byte[] bArr = new byte[1024];
        Ref.IntRef intRef = new Ref.IntRef();
        while (true) {
            int read = inputStream.read(bArr);
            intRef.element = read;
            if (read == -1) {
                break;
            }
            byte[] update = cipher.update(bArr, 0, read);
            if (update != null) {
                outputStream.write(update);
            }
        }
        byte[] doFinal = cipher.doFinal();
        if (doFinal != null) {
            outputStream.write(doFinal);
        }
    }

    private final Throwable n(jz3.e curConfig, String filePath, String targetFilePath, boolean keepEncryptFile) {
        Object m476constructorimpl;
        String p16 = p(curConfig);
        try {
            Result.Companion companion = Result.INSTANCE;
            l(filePath, targetFilePath, p16);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            jz3.c.f(new File(targetFilePath), true);
            jz3.d.d("Decrypt", "Decrypt File Fail: " + m479exceptionOrNullimpl.getMessage() + " Path: " + filePath, m479exceptionOrNullimpl);
            return m479exceptionOrNullimpl;
        }
        if (!keepEncryptFile) {
            jz3.c.f(new File(filePath), true);
            return null;
        }
        return null;
    }

    static /* synthetic */ Throwable o(g gVar, jz3.e eVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return gVar.n(eVar, str, str2, z16);
    }

    private final String p(@NotNull jz3.e eVar) {
        String substring;
        CharSequence reversed;
        String substring2;
        String str = eVar.f411274o;
        if (str != null && str.length() == 32) {
            StringBuilder sb5 = new StringBuilder();
            String secretKey = eVar.f411274o;
            Intrinsics.checkExpressionValueIsNotNull(secretKey, "secretKey");
            substring = StringsKt__StringsKt.substring(secretKey, new IntRange(0, 15));
            if (substring != null) {
                reversed = StringsKt___StringsKt.reversed((CharSequence) substring);
                sb5.append(reversed.toString());
                String secretKey2 = eVar.f411274o;
                Intrinsics.checkExpressionValueIsNotNull(secretKey2, "secretKey");
                substring2 = StringsKt__StringsKt.substring(secretKey2, new IntRange(16, 31));
                sb5.append(substring2);
                return sb5.toString();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new IllegalArgumentException("Secret Key Invalid: " + eVar.f411274o);
    }

    private final void q(com.tencent.rdelivery.reshub.core.k req, l chain, int errorCode, String errorReason, Throwable exception) {
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(errorCode);
        aVar.g(errorReason);
        aVar.f(exception);
        a.h(this, 11, req, aVar, 0L, 0L, 24, null);
        e(false, 209, req, chain, aVar);
    }

    static /* synthetic */ void r(g gVar, com.tencent.rdelivery.reshub.core.k kVar, l lVar, int i3, String str, Throwable th5, int i16, Object obj) {
        String str2;
        Throwable th6;
        if ((i16 & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i16 & 16) != 0) {
            th6 = null;
        } else {
            th6 = th5;
        }
        gVar.q(kVar, lVar, i3, str2, th6);
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 700;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        String removeSuffix;
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            j(chain, req, 205);
            return;
        }
        if (req.getBigResPatchChecked()) {
            chain.c(req);
            return;
        }
        boolean z16 = true;
        if (resConfig.f411273n != 1) {
            jz3.d.a("Decrypt", "Not a Encrypt File, Ignore.");
            chain.c(req);
            return;
        }
        String str = resConfig.H;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            jz3.d.e("Decrypt", "Decrypted Origin File Exist, Skip Decrypt. Path: " + resConfig.H);
            chain.c(req);
            return;
        }
        a.h(this, 10, req, null, 0L, 0L, 24, null);
        String str2 = resConfig.I;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        Pair<Integer, String> k3 = k(str3, resConfig);
        if (k3 == null) {
            removeSuffix = StringsKt__StringsKt.removeSuffix(str3, (CharSequence) FileSuffix.ENCRYPT_FILE);
            if (resConfig.k()) {
                removeSuffix = removeSuffix + ".decrypt";
            }
            String str4 = removeSuffix;
            Throwable o16 = o(this, resConfig, str3, str4, false, 8, null);
            if (o16 != null) {
                cVar.c();
                r(this, req, chain, 2007, null, o16, 8, null);
                return;
            }
            cVar.c();
            resConfig.H = str4;
            jz3.d.e("Decrypt", "Decrypt File Success. Path: " + str3 + " OriginFilePath: " + str4);
            a.h(this, 11, req, null, 0L, 0L, 24, null);
            chain.c(req);
            return;
        }
        cVar.c();
        r(this, req, chain, k3.component1().intValue(), k3.component2(), null, 16, null);
    }
}
