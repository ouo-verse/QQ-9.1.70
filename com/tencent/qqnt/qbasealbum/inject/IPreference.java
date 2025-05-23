package com.tencent.qqnt.qbasealbum.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/IPreference;", "", "", "key", "", "defValue", "", "mode", "getBoolean", "value", "", "putBoolean", "PreferenceMode", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface IPreference {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/IPreference$PreferenceMode;", "", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes25.dex */
    public @interface PreferenceMode {
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static boolean a(@NotNull IPreference iPreference, @NotNull String key, boolean z16, int i3) {
            Intrinsics.checkNotNullParameter(key, "key");
            return false;
        }

        public static void b(@NotNull IPreference iPreference, @NotNull String key, boolean z16, int i3) {
            Intrinsics.checkNotNullParameter(key, "key");
        }
    }

    boolean getBoolean(@NotNull String key, boolean defValue, int mode);

    void putBoolean(@NotNull String key, boolean value, int mode);
}
