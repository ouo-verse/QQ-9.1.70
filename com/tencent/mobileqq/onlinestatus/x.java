package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0007R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/x;", "", "", "b", "", "uin", "", "f", "time", "", "d", "a", "friendUin", "c", "onlineStatusUpdateTime", "e", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f256888a = new x();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity entity;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        entity = from;
    }

    x() {
    }

    @JvmStatic
    public static final void a(@NotNull String uin, long time) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!TextUtils.isEmpty(uin) && d(time)) {
            entity.removeKey(f256888a.c(uin));
        }
    }

    private final long b() {
        return System.currentTimeMillis() / 1000;
    }

    private final String c(String friendUin) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = "";
        }
        return "Consume_Status_" + str + "_" + friendUin;
    }

    @JvmStatic
    public static final boolean d(long time) {
        if (f256888a.b() - time > 86400) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean e(@NotNull String uin, long onlineStatusUpdateTime) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!OnlineStatusToggleUtils.n() || TextUtils.isEmpty(uin) || onlineStatusUpdateTime == 0 || d(onlineStatusUpdateTime)) {
            return false;
        }
        long decodeLong = entity.decodeLong(f256888a.c(uin), 0L);
        if (onlineStatusUpdateTime > decodeLong) {
            return true;
        }
        d(decodeLong);
        return false;
    }

    @JvmStatic
    public static final void f(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (TextUtils.isEmpty(uin)) {
            return;
        }
        MMKVOptionEntity mMKVOptionEntity = entity;
        x xVar = f256888a;
        mMKVOptionEntity.encodeLong(xVar.c(uin), xVar.b());
    }
}
