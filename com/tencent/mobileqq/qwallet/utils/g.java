package com.tencent.mobileqq.qwallet.utils;

import android.os.Parcelable;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000fH\u0007J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H\u0007J;\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0007J\u001a\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001dH\u0007J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/g;", "", "", "key", "", "value", "", DomainData.DOMAIN_NAME, RemoteHandleConst.PARAM_DEFAULT_VALUE, "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "j", "", "o", "", "l", "b", "c", "Landroid/os/Parcelable;", "p", "T", "Ljava/lang/Class;", "clazz", tl.h.F, "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "", "r", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", ReportConstant.COSTREPORT_PREFIX, "a", "g", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f279262a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntity entity;

    static {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QWALLET);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QWALLET)");
        entity = from;
    }

    g() {
    }

    @JvmStatic
    public static final boolean a(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.containsKey(key);
    }

    @JvmStatic
    public static final boolean b(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeBool(key, false);
    }

    @JvmStatic
    public static final boolean c(@NotNull String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeBool(key, defaultValue);
    }

    @JvmStatic
    @NotNull
    public static final byte[] d(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] decodeBytes = entity.decodeBytes(key, new byte[0]);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "entity.decodeBytes(key, ByteArray(0))");
        return decodeBytes;
    }

    @JvmStatic
    public static final int e(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeInt(key, defaultValue);
    }

    public static /* synthetic */ int f(String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return e(str, i3);
    }

    @JvmStatic
    @Nullable
    public static final <T extends Parcelable> T h(@NotNull String key, @NotNull Class<T> clazz, @Nullable T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) entity.decodeParcelable(key, clazz, defaultValue);
    }

    @JvmStatic
    @NotNull
    public static final String i(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String decodeString = entity.decodeString(key, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(key, \"\")");
        return decodeString;
    }

    @JvmStatic
    @NotNull
    public static final String j(@NotNull String key, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String decodeString = entity.decodeString(key, defaultValue);
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(key, defaultValue)");
        return decodeString;
    }

    @JvmStatic
    @Nullable
    public static final Set<String> k(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeStringSet(key, null);
    }

    @JvmStatic
    public static final void l(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        entity.encodeBool(key, value);
    }

    @JvmStatic
    public static final void m(@NotNull String key, @NotNull byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        entity.encodeBytes(key, value);
    }

    @JvmStatic
    public static final void n(@NotNull String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        entity.encodeInt(key, value);
    }

    @JvmStatic
    public static final void o(@NotNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        entity.encodeLong(key, value);
    }

    @JvmStatic
    public static final void p(@NotNull String key, @NotNull Parcelable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        entity.encodeParcelable(key, value);
    }

    @JvmStatic
    public static final void q(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        entity.encodeString(key, value);
    }

    @JvmStatic
    public static final void r(@NotNull String key, @NotNull Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        entity.encodeStringSet(key, value);
    }

    @JvmStatic
    public static final void s(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        entity.removeKey(key);
    }

    public final long g(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return entity.decodeLong(key, 0L);
    }
}
