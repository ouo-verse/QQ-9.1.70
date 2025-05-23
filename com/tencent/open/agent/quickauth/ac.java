package com.tencent.open.agent.quickauth;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ,\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/open/agent/quickauth/ac;", "", "", "action", "Landroid/os/Bundle;", "bundle", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/open/agent/quickauth/i;", "view", "Lcom/tencent/open/agent/quickauth/j;", "a", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f340394a = new ac();

    ac() {
    }

    @JvmStatic
    @Nullable
    public static final j a(@Nullable String action, @NotNull Bundle bundle, @NotNull Activity activity, @NotNull i view) {
        String str;
        boolean z16;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!Intrinsics.areEqual("action_ptlogin_login", action) && !Intrinsics.areEqual("action_quick_login", action)) {
            QLog.i("QuickAuthHandlerFactory", 1, "checkIntentValidity() invalid action = " + action);
            return null;
        }
        if (Intrinsics.areEqual("action_ptlogin_login", action)) {
            if (bundle.containsKey("qrcode") && bundle.containsKey("schemacallback")) {
                return new u(activity, view, bundle);
            }
            if (bundle.containsKey("p")) {
                String string = bundle.getString("p");
                if (com.tencent.open.agent.util.p.a()) {
                    str = "/";
                } else {
                    str = "";
                }
                if (string != null && string.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    for (String str2 : WebQuickAuthHandler.INSTANCE.b()) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, str2 + str, false, 2, null);
                        if (startsWith$default) {
                            return new WebQuickAuthHandler(activity, view, bundle);
                        }
                    }
                }
                QLog.i("QuickAuthHandlerFactory", 1, "checkIntentValidity() invalid path! " + string);
            }
            return null;
        }
        byte[] byteArray = bundle.getByteArray("publickey");
        String string2 = bundle.getString("packagename");
        if (QLog.isColorLevel()) {
            QLog.d("QuickAuthHandlerFactory", 2, "mSrcPackageName: " + string2);
        }
        if (byteArray != null && !TextUtils.isEmpty(string2) && bundle.containsKey("dstSsoVer") && bundle.containsKey("subDstAppid") && bundle.containsKey("dstAppid") && bundle.containsKey("dstAppVer")) {
            return new f(activity, view, bundle);
        }
        QLog.i("QuickAuthHandlerFactory", 1, "checkIntentValidity() invalid parameters! " + bundle);
        return null;
    }
}
