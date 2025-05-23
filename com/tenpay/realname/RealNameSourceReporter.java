package com.tenpay.realname;

import com.tencent.mobileqq.qwallet.c;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ.\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/realname/RealNameSourceReporter;", "", "()V", "KEY_CURRENT_SHOW_BIND_BANK_SOURCE", "", "KEY_CURRENT_SHOW_ID_VERIFY_SOURCE", "TAG", "reportBindBankGet", "", "reportBindBankShow", RealNameSource.EXTRA_KEY_SOURCE, "Lcom/tenpay/realname/RealNameSource;", "reportIdVerifyClick", "reportIdVerifyGet", "isMinor", "", "reportIdVerifyShow", "reportTo644", "actionName", "r2", "r3", "r5", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class RealNameSourceReporter {

    @NotNull
    public static final RealNameSourceReporter INSTANCE = new RealNameSourceReporter();

    @NotNull
    private static final String KEY_CURRENT_SHOW_BIND_BANK_SOURCE = "current_show_bind_bank_source";

    @NotNull
    private static final String KEY_CURRENT_SHOW_ID_VERIFY_SOURCE = "current_show_id_verify_source";

    @NotNull
    private static final String TAG = "RealNameSourceReporter";

    RealNameSourceReporter() {
    }

    @JvmStatic
    private static final void reportTo644(String actionName, String r26, String r36, String r56) {
        QLog.i(TAG, 1, "actionName = " + actionName + " r2 = " + r26 + " r3 = " + r36 + " r5 = " + r56 + " ");
        c.e(actionName, r26, r36, "Android", r56);
    }

    static /* synthetic */ void reportTo644$default(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        if ((i3 & 8) != 0) {
            str4 = "";
        }
        reportTo644(str, str2, str3, str4);
    }

    public final void reportBindBankGet() {
        String str;
        String sourceId;
        String str2 = "0";
        RealNameSource realNameSource = (RealNameSource) g.h(KEY_CURRENT_SHOW_BIND_BANK_SOURCE, RealNameSource.class, new RealNameSource("0"));
        g.s(KEY_CURRENT_SHOW_BIND_BANK_SOURCE);
        if (realNameSource != null && (sourceId = realNameSource.getSourceId()) != null) {
            str2 = sourceId;
        }
        if (realNameSource == null || (str = realNameSource.getSourceName()) == null) {
            str = "\u5176\u4ed6";
        }
        reportTo644("qqwallet.realnameapply_bk.get", "1", str2, str);
    }

    public final void reportBindBankShow(@Nullable RealNameSource realNameSource) {
        String str;
        String str2;
        if (realNameSource == null || (str = realNameSource.getSourceId()) == null) {
            str = "0";
        }
        if (realNameSource == null || (str2 = realNameSource.getSourceName()) == null) {
            str2 = "\u5176\u4ed6";
        }
        reportTo644("qqwallet.realnameapply_bk.show", "", str, str2);
        if (realNameSource != null) {
            g.p(KEY_CURRENT_SHOW_BIND_BANK_SOURCE, realNameSource);
        }
    }

    public final void reportIdVerifyClick(@Nullable RealNameSource realNameSource) {
        String str;
        String str2;
        if (realNameSource == null || (str = realNameSource.getSourceId()) == null) {
            str = "0";
        }
        if (realNameSource == null || (str2 = realNameSource.getSourceName()) == null) {
            str2 = "\u5176\u4ed6";
        }
        reportTo644("qqwallet.realnameapply_guide_submit.click", "", str, str2);
        if (realNameSource != null) {
            g.p(KEY_CURRENT_SHOW_ID_VERIFY_SOURCE, realNameSource);
        }
    }

    public final void reportIdVerifyGet(boolean isMinor) {
        String str;
        String str2;
        String sourceId;
        String str3 = "0";
        RealNameSource realNameSource = (RealNameSource) g.h(KEY_CURRENT_SHOW_ID_VERIFY_SOURCE, RealNameSource.class, new RealNameSource("0"));
        g.s(KEY_CURRENT_SHOW_ID_VERIFY_SOURCE);
        if (isMinor) {
            str = "2";
        } else {
            str = "1";
        }
        if (realNameSource != null && (sourceId = realNameSource.getSourceId()) != null) {
            str3 = sourceId;
        }
        if (realNameSource == null || (str2 = realNameSource.getSourceName()) == null) {
            str2 = "\u5176\u4ed6";
        }
        reportTo644("qqwallet.realnameapply_zj.get", str, str3, str2);
    }

    public final void reportIdVerifyShow(@Nullable RealNameSource realNameSource) {
        String str;
        String str2;
        if (realNameSource == null || (str = realNameSource.getSourceId()) == null) {
            str = "0";
        }
        if (realNameSource == null || (str2 = realNameSource.getSourceName()) == null) {
            str2 = "\u5176\u4ed6";
        }
        reportTo644("qqwallet.realnameapply_zj.show", "", str, str2);
        if (realNameSource != null) {
            g.p(KEY_CURRENT_SHOW_ID_VERIFY_SOURCE, realNameSource);
        }
    }
}
