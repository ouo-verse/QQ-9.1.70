package com.tencent.qmethod.monitor.base.util;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/e;", "", "Ljava/security/MessageDigest;", PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, "", "a", "", "content", "b", "", "size", "c", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f343535a = new e();

    e() {
    }

    private final String a(MessageDigest digest) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : digest.digest()) {
            sb5.append(Integer.toHexString((b16 >> 4) & 15));
            sb5.append(Integer.toHexString(b16 & RegisterType.DOUBLE_HI));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "builder.toString()");
        return sb6;
    }

    @NotNull
    public final String b(@NotNull byte[] content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        try {
            MessageDigest digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            digest.update(content);
            Intrinsics.checkExpressionValueIsNotNull(digest, "digest");
            return a(digest);
        } catch (Throwable th5) {
            o.d("MD5Utils", "getMD5", th5);
            return "";
        }
    }

    @NotNull
    public final String c(int size) {
        double random;
        int i3;
        if (size <= 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(16);
        for (int i16 = 0; i16 < size; i16++) {
            char c16 = (char) 0;
            int random2 = (int) (Math.random() * 2);
            if (random2 != 0) {
                if (random2 == 1) {
                    random = Math.random() * 6;
                    i3 = 97;
                } else {
                    sb5.append(c16);
                }
            } else {
                random = Math.random() * 10;
                i3 = 48;
            }
            c16 = (char) (random + i3);
            sb5.append(c16);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "str.toString()");
        return sb6;
    }
}
