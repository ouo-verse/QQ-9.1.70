package com.tencent.mobileqq.guild.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/b;", "", "", "guildNumber", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f235455a = new b();

    b() {
    }

    @JvmStatic
    public static final void a(@NotNull String guildNumber) {
        Intrinsics.checkNotNullParameter(guildNumber, "guildNumber");
        try {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ == null) {
                return;
            }
            Object systemService = mobileQQ.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(null, "#\u817e\u8baf\u9891\u9053\uff1a" + guildNumber));
            QQToast.makeText(mobileQQ, 2, R.string.f156421k6, 0).show();
        } catch (Exception e16) {
            QLog.e("ClipboardUtils", 1, "copyGuildNumber fail.", e16);
        }
    }
}
