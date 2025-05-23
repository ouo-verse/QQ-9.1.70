package com.tencent.open.agent.quickauth;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0004H&J.\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0013\u001a\u00020\u0004H&J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/open/agent/quickauth/i;", "", "", "msg", "", "showProgress", "L", "account", "F0", "u0", "", "ret", "", "encryptKey", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "r0", "Landroid/content/Intent;", "data", ICustomDataEditor.NUMBER_PARAM_1, "q0", "appName", "Landroid/graphics/Bitmap;", "appIcon", "p0", "url", "s0", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface i {
    void F0(@NotNull String account);

    void L();

    void n1(@Nullable Intent data);

    void p0(@NotNull String appName, @Nullable Bitmap appIcon);

    void q0();

    void r0(int ret, @Nullable byte[] encryptKey, @Nullable String account, @Nullable String errmsg);

    void s0(@NotNull String url);

    void showProgress(@Nullable String msg2);

    void u0();
}
