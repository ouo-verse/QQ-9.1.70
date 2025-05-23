package com.tencent.open.agent.util;

import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ,\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00050\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/open/agent/util/s;", "", "", "baseUrl", "", "Landroid/util/Pair;", "additionalParams", "b", "", "oriPublicKey", "a", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f340620a = new s();

    s() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable byte[] oriPublicKey) {
        byte[] plus;
        if (oriPublicKey != null) {
            plus = ArraysKt___ArraysJvmKt.plus(new byte[]{48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0}, oriPublicKey);
            String encodeToString = Base64.encodeToString(plus, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(X509PubKe\u2026ublicKey, Base64.NO_WRAP)");
            return encodeToString;
        }
        QLog.e("QuickLoginUtils", 1, "base64PublicKey oriPublicKey is null");
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
    
        r8 = r7.getQueryParameterNames().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        if (r8.hasNext() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        r3 = r8.next();
        r5 = r7.getQueryParameter(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
    
        if (r5 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        if (r5.length() != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0098, code lost:
    
        if (r6 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
    
        r0.appendQueryParameter(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a7, code lost:
    
        return r0.build().toString();
     */
    @JvmStatic
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String b(@NotNull String baseUrl, @NotNull List<? extends Pair<String, String>> additionalParams) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(additionalParams, "additionalParams");
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_quick_login_url_rebuild_switch", true)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(baseUrl);
            if (!Intrinsics.areEqual(parse.getScheme(), "http") && !Intrinsics.areEqual(parse.getScheme(), "https")) {
                return null;
            }
            Uri.Builder clearQuery = parse.buildUpon().clearQuery();
            Iterator<? extends Pair<String, String>> it = additionalParams.iterator();
            while (true) {
                boolean z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                Pair<String, String> next = it.next();
                CharSequence charSequence = (CharSequence) next.second;
                if (charSequence == null || charSequence.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    return null;
                }
                clearQuery.appendQueryParameter((String) next.first, (String) next.second);
            }
        } catch (Exception e16) {
            QLog.i("QuickLoginUtils", 1, "buildCallbackUrl catch exp", e16);
            return null;
        }
    }
}
