package com.tencent.mobileqq.qmmkv.v2;

import android.content.SharedPreferences;
import android.os.Parcelable;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H&J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0007H&J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\fH&J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000fH&J=\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\b\u0010\n\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H&J$\u0010\r\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0016H&J$\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H&J$\u0010\u0018\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0016H&J*\u0010\u001b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u0016H&J\"\u0010\u001c\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J\"\u0010\u001e\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0016H&J\"\u0010 \u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0016H&J\"\u0010\"\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u0016H&J\u001c\u0010#\u001a\u00020!2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010$\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010%\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0017\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&H&\u00a2\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020\u001dH&J\b\u0010*\u001a\u00020\u001dH&J\b\u0010+\u001a\u00020\u001dH&J\u0012\u0010,\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001f\u0010.\u001a\u00020\u00022\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&H&\u00a2\u0006\u0004\b.\u0010/J\b\u00101\u001a\u000200H&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/e;", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences$Editor;", "", "mmapID", "mmapKey", "key", "", "value", "putDouble", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getDouble", "", "putBytes", "getBytes", "Landroid/os/Parcelable;", "putParcelable", "T", "Ljava/lang/Class;", "tClass", "getParcelable", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "", "expireDurationInSecond", "putString", "", "values", "putStringSet", "putInt", "", "putLong", "", "putFloat", "", "putBoolean", "putStringR", "getValueSize", "getValueActualSize", "", "allKeys", "()[Ljava/lang/String;", "count", "totalSize", "actualSize", "removeValueForKey", "keys", "removeValuesForKeys", "([Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;", "", "trim", "library_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public interface e extends SharedPreferences, SharedPreferences.Editor {
    long actualSize();

    @Nullable
    String[] allKeys();

    long count();

    @Nullable
    byte[] getBytes(@Nullable String key, @Nullable byte[] defaultValue);

    double getDouble(@Nullable String key, double defaultValue);

    @Nullable
    <T extends Parcelable> T getParcelable(@Nullable String key, @NotNull Class<T> tClass, @Nullable T defaultValue);

    int getValueActualSize(@Nullable String key);

    int getValueSize(@Nullable String key);

    @Nullable
    String mmapID();

    @Nullable
    String mmapKey();

    @NotNull
    SharedPreferences.Editor putBoolean(@Nullable String key, boolean value, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor putBytes(@Nullable String key, @Nullable byte[] value);

    @NotNull
    SharedPreferences.Editor putBytes(@Nullable String key, @Nullable byte[] value, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor putDouble(@Nullable String key, double value);

    @NotNull
    SharedPreferences.Editor putDouble(@Nullable String key, double value, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor putFloat(@Nullable String key, float value, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor putInt(@Nullable String key, int value, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor putLong(@Nullable String key, long value, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor putParcelable(@Nullable String key, @Nullable Parcelable value);

    @NotNull
    SharedPreferences.Editor putParcelable(@Nullable String key, @Nullable Parcelable value, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor putString(@Nullable String key, @Nullable String value, int expireDurationInSecond);

    boolean putStringR(@Nullable String key, @Nullable String value);

    @NotNull
    SharedPreferences.Editor putStringSet(@Nullable String key, @Nullable Set<String> values, int expireDurationInSecond);

    @NotNull
    SharedPreferences.Editor removeValueForKey(@Nullable String key);

    @NotNull
    SharedPreferences.Editor removeValuesForKeys(@Nullable String[] keys);

    long totalSize();

    void trim();
}
