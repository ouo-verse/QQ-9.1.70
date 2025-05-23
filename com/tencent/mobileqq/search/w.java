package com.tencent.mobileqq.search;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0002R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/w;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "", "d", "", "c", "", "key", "e", "a", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w f285231a = new w();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static MMKVOptionEntity entity;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        entity = from;
    }

    w() {
    }

    private final String a() {
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        if (account == null) {
            return "null";
        }
        return account;
    }

    @JvmStatic
    @NotNull
    public static final MMKVOptionEntity b() {
        return entity;
    }

    @JvmStatic
    public static final boolean c() {
        return entity.decodeBool(e("MMKV_KEY_SHOW_LBS_PERMISSION_DIALOG"), false);
    }

    @JvmStatic
    public static final void d() {
        b().encodeBool(e("MMKV_KEY_SHOW_LBS_PERMISSION_DIALOG"), true);
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String a16 = f285231a.a();
        return key + "_" + AppSetting.f99551k + "_" + a16;
    }
}
