package com.tencent.mobileqq.activity.lastclean;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/lastclean/LastCleanMMKVHelper;", "", "", "uin", "", "c", "key", "a", "", "f", "Ljava/util/Date;", "b", "g", "", "e", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class LastCleanMMKVHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LastCleanMMKVHelper f183341a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mmkvEntity;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51690);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f183341a = new LastCleanMMKVHelper();
        lazy = LazyKt__LazyJVMKt.lazy(LastCleanMMKVHelper$mmkvEntity$2.INSTANCE);
        mmkvEntity = lazy;
    }

    LastCleanMMKVHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(String key) {
        return "Storage_Scan_Last_Clean_" + key;
    }

    private final long c(String uin) {
        if (TextUtils.isEmpty(uin)) {
            QLog.d("LastCleanMMKVHelper", 1, "getLastRestartWindowTime uin empty");
            return 0L;
        }
        MMKVOptionEntity d16 = d();
        Intrinsics.checkNotNull(uin);
        long decodeLong = d16.decodeLong(a(uin + "_restart"), 0L);
        QLog.d("LastCleanMMKVHelper", 1, "getLastRestartWindowTime : " + decodeLong);
        return decodeLong;
    }

    private final MMKVOptionEntity d() {
        return (MMKVOptionEntity) mmkvEntity.getValue();
    }

    @Nullable
    public final Date b(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Date) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin);
        }
        if (TextUtils.isEmpty(uin)) {
            QLog.d("LastCleanMMKVHelper", 1, "getLastCleanTime uin empty");
            return null;
        }
        MMKVOptionEntity d16 = d();
        Intrinsics.checkNotNull(uin);
        String decodeString = d16.decodeString(a(uin), "");
        QLog.d("LastCleanMMKVHelper", 1, "getLastCleanTime dataString: " + decodeString);
        if (TextUtils.isEmpty(decodeString)) {
            return null;
        }
        try {
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).parse(decodeString);
        } catch (ParseException e16) {
            QLog.e("LastCleanMMKVHelper", 1, e16, "getLastCleanTime dateString: " + decodeString);
            return null;
        }
    }

    public final boolean e(@Nullable String uin) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uin)).booleanValue();
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(uin)) {
            return false;
        }
        com.tencent.mobileqq.app.message.cleanup.config.a aVar = (com.tencent.mobileqq.app.message.cleanup.config.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("clean_up_thorough");
        if (aVar != null) {
            i3 = aVar.b();
        } else {
            i3 = -1;
        }
        if (i3 < 0) {
            QLog.d("LastCleanMMKVHelper", 1, "needShowRestartDialog restartInterval not set");
            return false;
        }
        long abs = Math.abs(System.currentTimeMillis() - c(uin));
        if (abs >= i3 * 3600000) {
            z16 = true;
        }
        QLog.d("LastCleanMMKVHelper", 1, "needShowRestartDialog diffTime: " + abs + ", needShow: " + z16);
        return z16;
    }

    public final void f(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
            return;
        }
        if (TextUtils.isEmpty(uin)) {
            QLog.d("LastCleanMMKVHelper", 1, "updateCleanTime uin empty");
            return;
        }
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINESE).format(new Date());
        QLog.d("LastCleanMMKVHelper", 1, "updateCleanTime dateString: " + format);
        MMKVOptionEntity d16 = d();
        Intrinsics.checkNotNull(uin);
        d16.encodeString(a(uin), format).commitSync();
    }

    public final void g(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin);
            return;
        }
        if (TextUtils.isEmpty(uin)) {
            QLog.d("LastCleanMMKVHelper", 1, "updateRestartWindowTime uin empty");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d("LastCleanMMKVHelper", 1, "updateRestartWindowTime : " + currentTimeMillis);
        MMKVOptionEntity d16 = d();
        Intrinsics.checkNotNull(uin);
        d16.encodeLong(a(uin + "_restart"), currentTimeMillis).commitSync();
    }
}
