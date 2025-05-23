package com.tencent.mobileqq.nearbypro.base;

import android.os.Parcelable;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J8\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&JO\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJK\u0010\u001c\u001a\u00028\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u001c\u0010\u001bJ,\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010\"\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010#\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J2\u0010$\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010%\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J,\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J$\u0010'\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&J$\u0010(\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/c;", "", "", "key", "", "defValue", "suffix", "", "ignoreUin", "decodeInt", "", "decodeLong", "", "decodeFloat", "", "decodeDouble", "decodeBool", "decodeString", "", "decodeStringSet", "", "decodeBytes", "Landroid/os/Parcelable;", "T", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;Ljava/lang/String;Z)Landroid/os/Parcelable;", "decodeParcelable", "value", "encodeInt", "encodeLong", "encodeFloat", "encodeDouble", "encodeBool", "encodeString", "encodeStringSet", "encodeBytes", "encodeParcelable", "containsKey", "removeKey", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ boolean a(c cVar, String str, boolean z16, String str2, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z17 = false;
                }
                return cVar.decodeBool(str, z16, str2, z17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeBool");
        }

        public static /* synthetic */ byte[] b(c cVar, String str, byte[] bArr, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return cVar.decodeBytes(str, bArr, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeBytes");
        }

        public static /* synthetic */ float c(c cVar, String str, float f16, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return cVar.decodeFloat(str, f16, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeFloat");
        }

        public static /* synthetic */ int d(c cVar, String str, int i3, String str2, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    str2 = "";
                }
                if ((i16 & 8) != 0) {
                    z16 = false;
                }
                return cVar.decodeInt(str, i3, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeInt");
        }

        public static /* synthetic */ Parcelable e(c cVar, String str, Class cls, Parcelable parcelable, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    str2 = "";
                }
                String str3 = str2;
                if ((i3 & 16) != 0) {
                    z16 = false;
                }
                return cVar.decodeParcelable(str, cls, parcelable, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeParcelable");
        }

        public static /* synthetic */ Parcelable f(c cVar, String str, Class cls, Parcelable parcelable, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    str2 = "";
                }
                String str3 = str2;
                if ((i3 & 16) != 0) {
                    z16 = false;
                }
                return cVar.a(str, cls, parcelable, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeParcelableOrNull");
        }

        public static /* synthetic */ String g(c cVar, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str3 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return cVar.decodeString(str, str2, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeString");
        }

        public static /* synthetic */ c h(c cVar, String str, boolean z16, String str2, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z17 = false;
                }
                return cVar.encodeBool(str, z16, str2, z17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeBool");
        }

        public static /* synthetic */ c i(c cVar, String str, byte[] bArr, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return cVar.encodeBytes(str, bArr, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeBytes");
        }

        public static /* synthetic */ c j(c cVar, String str, float f16, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return cVar.encodeFloat(str, f16, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeFloat");
        }

        public static /* synthetic */ c k(c cVar, String str, int i3, String str2, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    str2 = "";
                }
                if ((i16 & 8) != 0) {
                    z16 = false;
                }
                return cVar.encodeInt(str, i3, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeInt");
        }

        public static /* synthetic */ c l(c cVar, String str, Parcelable parcelable, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return cVar.encodeParcelable(str, parcelable, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeParcelable");
        }

        public static /* synthetic */ c m(c cVar, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str3 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return cVar.encodeString(str, str2, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeString");
        }
    }

    @Nullable
    <T extends Parcelable> T a(@NotNull String key, @NotNull Class<T> clazz, @Nullable T defValue, @NotNull String suffix, boolean ignoreUin);

    boolean containsKey(@NotNull String key, @NotNull String suffix, boolean ignoreUin);

    boolean decodeBool(@NotNull String key, boolean defValue, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    byte[] decodeBytes(@NotNull String key, @NotNull byte[] defValue, @NotNull String suffix, boolean ignoreUin);

    double decodeDouble(@NotNull String key, double defValue, @NotNull String suffix, boolean ignoreUin);

    float decodeFloat(@NotNull String key, float defValue, @NotNull String suffix, boolean ignoreUin);

    int decodeInt(@NotNull String key, int defValue, @NotNull String suffix, boolean ignoreUin);

    long decodeLong(@NotNull String key, long defValue, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    <T extends Parcelable> T decodeParcelable(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defValue, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    String decodeString(@NotNull String key, @NotNull String defValue, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    Set<String> decodeStringSet(@NotNull String key, @NotNull Set<String> defValue, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeBool(@NotNull String key, boolean value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeBytes(@NotNull String key, @NotNull byte[] value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeDouble(@NotNull String key, double value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeFloat(@NotNull String key, float value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeInt(@NotNull String key, int value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeLong(@NotNull String key, long value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeParcelable(@NotNull String key, @NotNull Parcelable value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeString(@NotNull String key, @NotNull String value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c encodeStringSet(@NotNull String key, @NotNull Set<String> value, @NotNull String suffix, boolean ignoreUin);

    @NotNull
    c removeKey(@NotNull String key, @NotNull String suffix, boolean ignoreUin);
}
