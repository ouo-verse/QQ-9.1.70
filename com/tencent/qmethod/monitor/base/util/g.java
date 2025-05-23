package com.tencent.qmethod.monitor.base.util;

import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/g;", "", "", "bytes", "", "a", "source", "b", "", "[C", "digits", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f343538b = new g();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    g() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable byte[] bytes) {
        boolean z16;
        if (bytes != null) {
            if (bytes.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                char[] cArr = new char[bytes.length * 2];
                int length = bytes.length;
                for (int i3 = 0; i3 < length; i3++) {
                    byte b16 = bytes[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = digits;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                }
                return new String(cArr);
            }
            return "";
        }
        return "";
    }

    @JvmStatic
    @NotNull
    public static final String b(@Nullable String source) {
        if (source == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            byte[] bytes = source.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e16) {
            o.d("StringUtil", "getMD5", e16);
            return "";
        }
    }
}
