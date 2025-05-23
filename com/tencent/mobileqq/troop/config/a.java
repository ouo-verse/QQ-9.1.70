package com.tencent.mobileqq.troop.config;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/config/a;", "", "", "key", "c", "", "accountScoped", "a", RemoteHandleConst.PARAM_DEFAULT_VALUE, "d", "", "i", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "", "o", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "w", "y", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", h.F, "()Ljava/lang/String;", PanoramaConfig.KEY_CURRENT_UIN, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final a f294689a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity entity;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28328);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        f294689a = new a();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP)");
        entity = from;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ boolean b(a aVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return aVar.a(str, z16);
    }

    private final String c(String key) {
        String h16 = h();
        if (h16 != null) {
            return key + "_" + h16;
        }
        return null;
    }

    public static /* synthetic */ boolean e(a aVar, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return aVar.d(str, z16, z17);
    }

    public static /* synthetic */ byte[] g(a aVar, String str, byte[] bArr, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return aVar.f(str, bArr, z16);
    }

    private final String h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return null;
    }

    public static /* synthetic */ int j(a aVar, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        return aVar.i(str, i3, z16);
    }

    public static /* synthetic */ long l(a aVar, String str, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return aVar.k(str, j3, z16);
    }

    public static /* synthetic */ String n(a aVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return aVar.m(str, str2, z16);
    }

    public static /* synthetic */ void p(a aVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        aVar.o(str, z16);
    }

    public static /* synthetic */ void r(a aVar, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        aVar.q(str, z16, z17);
    }

    public static /* synthetic */ void t(a aVar, String str, byte[] bArr, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        aVar.s(str, bArr, z16);
    }

    public static /* synthetic */ void v(a aVar, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        aVar.u(str, i3, z16);
    }

    public static /* synthetic */ void x(a aVar, String str, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        aVar.w(str, j3, z16);
    }

    public static /* synthetic */ void z(a aVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        aVar.y(str, str2, z16);
    }

    public final boolean a(@NotNull String key, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, key, Boolean.valueOf(accountScoped))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (accountScoped) {
            key = c(key);
        }
        if (key == null) {
            return false;
        }
        return entity.containsKey(key);
    }

    public final boolean d(@NotNull String key, boolean r65, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, key, Boolean.valueOf(r65), Boolean.valueOf(accountScoped))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            return entity.decodeBool(key, r65);
        }
        return r65;
    }

    @NotNull
    public final byte[] f(@NotNull String key, @NotNull byte[] r65, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, this, key, r65, Boolean.valueOf(accountScoped));
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r65, "defaultValue");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            byte[] decodeBytes = entity.decodeBytes(key, r65);
            Intrinsics.checkNotNullExpressionValue(decodeBytes, "{\n            entity.dec\u2026, defaultValue)\n        }");
            return decodeBytes;
        }
        return r65;
    }

    public final int i(@NotNull String key, int r65, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, key, Integer.valueOf(r65), Boolean.valueOf(accountScoped))).intValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            return entity.decodeInt(key, r65);
        }
        return r65;
    }

    public final long k(@NotNull String key, long r65, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, this, key, Long.valueOf(r65), Boolean.valueOf(accountScoped))).longValue();
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            return entity.decodeLong(key, r65);
        }
        return r65;
    }

    @NotNull
    public final String m(@NotNull String key, @NotNull String defaultValue, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, key, defaultValue, Boolean.valueOf(z16));
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (z16) {
            key = c(key);
        }
        if (key != null) {
            String decodeString = entity.decodeString(key, defaultValue);
            Intrinsics.checkNotNullExpressionValue(decodeString, "{\n            entity.dec\u2026, defaultValue)\n        }");
            return decodeString;
        }
        return defaultValue;
    }

    public final void o(@NotNull String key, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, key, Boolean.valueOf(accountScoped));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            MMKVOptionEntity mMKVOptionEntity = entity;
            mMKVOptionEntity.removeKey(key);
            mMKVOptionEntity.commitAsync();
        }
    }

    public final void q(@NotNull String key, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, key, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (z17) {
            key = c(key);
        }
        if (key != null) {
            MMKVOptionEntity mMKVOptionEntity = entity;
            mMKVOptionEntity.encodeBool(key, z16);
            mMKVOptionEntity.commitAsync();
        }
    }

    public final void s(@NotNull String key, @NotNull byte[] value, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, key, value, Boolean.valueOf(z16));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (z16) {
            key = c(key);
        }
        if (key != null) {
            MMKVOptionEntity mMKVOptionEntity = entity;
            mMKVOptionEntity.encodeBytes(key, value);
            mMKVOptionEntity.commitAsync();
        }
    }

    public final void u(@NotNull String key, int value, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, key, Integer.valueOf(value), Boolean.valueOf(accountScoped));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            MMKVOptionEntity mMKVOptionEntity = entity;
            mMKVOptionEntity.encodeInt(key, value);
            mMKVOptionEntity.commitAsync();
        }
    }

    public final void w(@NotNull String key, long value, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, key, Long.valueOf(value), Boolean.valueOf(accountScoped));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            MMKVOptionEntity mMKVOptionEntity = entity;
            mMKVOptionEntity.encodeLong(key, value);
            mMKVOptionEntity.commitAsync();
        }
    }

    public final void y(@NotNull String key, @NotNull String value, boolean accountScoped) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, key, value, Boolean.valueOf(accountScoped));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (accountScoped) {
            key = c(key);
        }
        if (key != null) {
            MMKVOptionEntity mMKVOptionEntity = entity;
            mMKVOptionEntity.encodeString(key, value);
            mMKVOptionEntity.commitAsync();
        }
    }
}
