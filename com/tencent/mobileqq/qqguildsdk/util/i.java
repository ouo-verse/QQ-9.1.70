package com.tencent.mobileqq.qqguildsdk.util;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\bH\u0007R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/util/i;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "", "uin", "c", "tinyId", "", "d", "a", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "MMKV_MEM_CACHE", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f268554a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static MMKVOptionEntity entity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, String> MMKV_MEM_CACHE;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        entity = from;
        MMKV_MEM_CACHE = new ConcurrentHashMap<>();
    }

    i() {
    }

    @JvmStatic
    public static final void a() {
        MMKV_MEM_CACHE.clear();
    }

    @JvmStatic
    @NotNull
    public static final MMKVOptionEntity b() {
        return entity;
    }

    @JvmStatic
    @NotNull
    public static final String c(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String str = MMKV_MEM_CACHE.get(uin);
        if (!j.h(str)) {
            Intrinsics.checkNotNull(str);
            return str;
        }
        String decodeString = b().decodeString("MMKV_KEY_GUILD_SELF_TINYID" + uin, "0");
        Intrinsics.checkNotNull(decodeString);
        return decodeString;
    }

    @JvmStatic
    public static final void d(@NotNull String uin, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (!j.h(uin) && !j.h(tinyId)) {
            if (Intrinsics.areEqual(tinyId, c(uin))) {
                MMKV_MEM_CACHE.put(uin, tinyId);
                return;
            }
            MMKV_MEM_CACHE.put(uin, tinyId);
            b().encodeString("MMKV_KEY_GUILD_SELF_TINYID" + uin, tinyId);
            return;
        }
        QLog.e("GProMMKVUtils", 1, "setSelfTinyId error, uin=" + uin + ", tinyId=" + tinyId);
    }
}
