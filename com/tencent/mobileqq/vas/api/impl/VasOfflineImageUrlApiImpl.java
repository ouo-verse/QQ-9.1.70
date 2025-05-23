package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.vas.api.IVasOfflineImageUrlApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasOfflineImageUrlApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasOfflineImageUrlApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "", "type", "", "interceptRequest", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasOfflineImageUrlApiImpl implements IVasOfflineImageUrlApi {

    @NotNull
    private static final String TAG = "VasOfflineImageUrlApiImpl";

    @NotNull
    private static final String prefix = "https://zb.vip.qq.com/";

    @Override // com.tencent.mobileqq.vas.api.IVasOfflineImageUrlApi
    @Nullable
    public Object interceptRequest(@NotNull Activity activity, @NotNull String url, long type) {
        boolean startsWith$default;
        String replace$default;
        List split$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, prefix, false, 2, null);
            if (startsWith$default) {
                replace$default = StringsKt__StringsJVMKt.replace$default(url, prefix, "", false, 4, (Object) null);
                split$default = StringsKt__StringsKt.split$default((CharSequence) replace$default, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
                File file = new File(URLDecoder.decode((String) split$default.get(0), "utf-8"));
                if (!file.exists()) {
                    QLog.e(TAG, 1, "file not exists : " + file);
                    return null;
                }
                return new WebResourceResponse("image/png", "utf-8", new BufferedInputStream(new FileInputStream(file), 16384));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error", e16);
        }
        return null;
    }
}
