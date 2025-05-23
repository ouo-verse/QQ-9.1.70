package com.tencent.mobileqq.wink.utils;

import android.os.Parcelable;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J=\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000eJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0011J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0015J\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001aJ\u0016\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u001aJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010!\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ar;", "", "", "key", "Landroid/os/Parcelable;", "value", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "T", "Ljava/lang/Class;", "clazz", RemoteHandleConst.PARAM_DEFAULT_VALUE, "g", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "", "o", "e", "", "p", "default", "f", "", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "i", "", DomainData.DOMAIN_NAME, "d", "", "b", "()[Ljava/lang/String;", "l", "j", ReportConstant.COSTREPORT_PREFIX, "k", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ar {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ar f326685a = new ar();

    ar() {
    }

    public static /* synthetic */ Parcelable h(ar arVar, String str, Class cls, Parcelable parcelable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            parcelable = null;
        }
        return arVar.g(str, cls, parcelable);
    }

    public final boolean a(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE).containsKey(key);
    }

    @NotNull
    public final String[] b() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        String[] allKeyArr = from.allKeyArr();
        Intrinsics.checkNotNullExpressionValue(allKeyArr, "mmkv.allKeyArr()");
        return allKeyArr;
    }

    public final boolean c(@NotNull String key, boolean r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return from.decodeBool(key, r46);
    }

    @NotNull
    public final byte[] d(@NotNull String key, @NotNull byte[] r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r46, "default");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        byte[] decodeBytes = from.decodeBytes(key, r46);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "mmkv.decodeBytes(key, default)");
        return decodeBytes;
    }

    public final int e(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return from.decodeInt(key, defaultValue);
    }

    public final long f(@NotNull String key, long r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return from.decodeLong(key, r46);
    }

    @JvmOverloads
    @Nullable
    public final <T extends Parcelable> T g(@NotNull String key, @NotNull Class<T> clazz, @Nullable T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return (T) from.decodeParcelable(key, clazz, defaultValue);
    }

    @NotNull
    public final String i(@NotNull String key, @NotNull String r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r46, "default");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        String decodeString = from.decodeString(key, r46);
        Intrinsics.checkNotNullExpressionValue(decodeString, "mmkv.decodeString(key, default)");
        return decodeString;
    }

    public final boolean j(@NotNull String key, boolean r46) {
        Intrinsics.checkNotNullParameter(key, "key");
        String k3 = k(key);
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return from.decodeBool(k3, r46);
    }

    @NotNull
    public final String k(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + key;
    }

    public final void l(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.removeKey(key);
    }

    public final void m(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeBool(key, value);
    }

    public final void n(@NotNull String key, @NotNull byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeBytes(key, value);
    }

    public final void o(@NotNull String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeInt(key, value);
    }

    public final void p(@NotNull String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeLong(key, value);
    }

    public final void q(@NotNull String key, @Nullable Parcelable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeParcelable(key, value);
    }

    public final void r(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeString(key, value);
    }

    public final void s(@NotNull String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        String k3 = k(key);
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeBool(k3, value);
    }
}
