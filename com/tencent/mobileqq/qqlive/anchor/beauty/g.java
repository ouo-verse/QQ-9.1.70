package com.tencent.mobileqq.qqlive.anchor.beauty;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0002\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/beauty/g;", "", "", "p", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "j", "key", "", "defValue", tl.h.F, "value", "", "v", "", "c", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "id", "a", "b", "r", "t", ReportConstant.COSTREPORT_PREFIX, "g", "e", DomainData.DOMAIN_NAME, "l", "d", "f", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "i", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f270406a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            f270406a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MMKVOptionEntity j() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(mqq.app.MobileQQ.sM\u2026Q, QMMKVFile.FILE_QQLIVE)");
        return from;
    }

    private final String p() {
        return String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G());
    }

    @NotNull
    public final String a(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_KEY_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String b(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_KEY_SELECTED_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final boolean c(@NotNull String key, boolean defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, key, Boolean.valueOf(defValue))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return j().decodeBool(key, defValue);
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_CURRENT_FILTER_PATH_%s", Arrays.copyOf(new Object[]{p()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String e(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_FILTER_ITEM_CUR_SELECTED_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_CURRENT_FILTER_VALUE_%s", Arrays.copyOf(new Object[]{p()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String g(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_FILTER_ITEM_CUR_VALUE_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final int h(@NotNull String key, int defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, defValue)).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return j().decodeInt(key, defValue);
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_EFFECT_HAS_CHANGED_%s", Arrays.copyOf(new Object[]{p()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_CURRENT_CUSTOM_COSMETIC_PATH_%s", Arrays.copyOf(new Object[]{p()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String l(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_MAKEUP_ITEM_CUR_SELECTED_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_CURRENT_CUSTOM_COSMETIC_VALUE_%s", Arrays.copyOf(new Object[]{p()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String n(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_MAKEUP_ITEM_CUR_VALUE_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_CURRENT_PROP_PATH_%s", Arrays.copyOf(new Object[]{p()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @Nullable
    public final String q(@NotNull String key, @Nullable String defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key, (Object) defValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        return j().decodeString(key, defValue);
    }

    @NotNull
    public final String r(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_SUB_CONFIG_KEY_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String s(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_SUB_KEY_SELECTED_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String t(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, id5);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("LIGHT_BEAUTY_SUB_CONFIG_VALUE_%s_%d", Arrays.copyOf(new Object[]{p(), Integer.valueOf(id5)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final void u(@NotNull String key, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, key, Boolean.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            j().encodeBool(key, value);
        }
    }

    public final void v(@NotNull String key, int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) key, value);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            j().encodeInt(key, value);
        }
    }

    public final void w(@NotNull String key, @Nullable String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) value);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            j().encodeString(key, value);
        }
    }
}
