package com.tencent.ecommerce.biz.util;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/util/p;", "", "", "picUrl", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f104878a = new p();

    p() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String picUrl) {
        boolean contains$default;
        int lastIndexOf$default;
        String replace$default;
        boolean contains$default2;
        boolean z16 = true;
        if (picUrl.length() == 0) {
            return "";
        }
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNightManager().isNightMode()) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) picUrl, (CharSequence) QCircleSkinHelper.SKIN, false, 2, (Object) null);
        }
        z16 = false;
        if (!z16) {
            return picUrl;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) picUrl, (CharSequence) QCircleSkinHelper.SKIN_DEFAULT_MODE_TAG, false, 2, (Object) null);
        if (!contains$default) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) picUrl, '.', 0, false, 6, (Object) null);
            if (lastIndexOf$default == -1) {
                return picUrl;
            }
            StringBuilder sb5 = new StringBuilder();
            if (picUrl != null) {
                String substring = picUrl.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                sb5.append("_dark");
                String substring2 = picUrl.substring(lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                sb5.append(substring2);
                return sb5.toString();
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(picUrl, QCircleSkinHelper.SKIN_DEFAULT_MODE_TAG, QCircleSkinHelper.SKIN_DARK_MODE_TAG, false, 4, (Object) null);
        return replace$default;
    }
}
