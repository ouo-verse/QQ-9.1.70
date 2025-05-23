package com.tencent.state.square.mmkv;

import android.os.Parcelable;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&JI\u0010\u0014\u001a\u0002H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00182\u0006\u0010\t\u001a\u0002H\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&\u00a2\u0006\u0002\u0010\u0019J,\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J8\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010 \u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010!\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010\"\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010#\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010$\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J,\u0010%\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J2\u0010&\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J$\u0010'\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/mmkv/IMMKV;", "", "containsKey", "", "key", "", "postFix", "ignoreFillUin", "decodeBool", RemoteHandleConst.PARAM_DEFAULT_VALUE, "decodeBytes", "", "decodeDouble", "", "decodeFloat", "", "decodeInt", "", "decodeLong", "", "decodeParcelable", "T", "Landroid/os/Parcelable;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;Ljava/lang/String;Z)Landroid/os/Parcelable;", "decodeString", "decodeStringSet", "", "encodeBool", "value", "encodeBytes", "encodeDouble", "encodeFloat", "encodeInt", "encodeLong", "encodeParcelable", "encodeString", "encodeStringSet", "removeKey", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IMMKV {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean containsKey$default(IMMKV immkv, String str, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = "";
                }
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                return immkv.containsKey(str, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: containsKey");
        }

        public static /* synthetic */ boolean decodeBool$default(IMMKV immkv, String str, boolean z16, String str2, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z17 = false;
                }
                return immkv.decodeBool(str, z16, str2, z17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeBool");
        }

        public static /* synthetic */ byte[] decodeBytes$default(IMMKV immkv, String str, byte[] bArr, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.decodeBytes(str, bArr, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeBytes");
        }

        public static /* synthetic */ double decodeDouble$default(IMMKV immkv, String str, double d16, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.decodeDouble(str, d16, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeDouble");
        }

        public static /* synthetic */ float decodeFloat$default(IMMKV immkv, String str, float f16, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.decodeFloat(str, f16, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeFloat");
        }

        public static /* synthetic */ int decodeInt$default(IMMKV immkv, String str, int i3, String str2, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    str2 = "";
                }
                if ((i16 & 8) != 0) {
                    z16 = false;
                }
                return immkv.decodeInt(str, i3, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeInt");
        }

        public static /* synthetic */ long decodeLong$default(IMMKV immkv, String str, long j3, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.decodeLong(str, j3, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeLong");
        }

        public static /* synthetic */ Parcelable decodeParcelable$default(IMMKV immkv, String str, Class cls, Parcelable parcelable, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    str2 = "";
                }
                String str3 = str2;
                if ((i3 & 16) != 0) {
                    z16 = false;
                }
                return immkv.decodeParcelable(str, cls, parcelable, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeParcelable");
        }

        public static /* synthetic */ String decodeString$default(IMMKV immkv, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str3 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.decodeString(str, str2, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeString");
        }

        public static /* synthetic */ Set decodeStringSet$default(IMMKV immkv, String str, Set set, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.decodeStringSet(str, set, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeStringSet");
        }

        public static /* synthetic */ IMMKV encodeBool$default(IMMKV immkv, String str, boolean z16, String str2, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z17 = false;
                }
                return immkv.encodeBool(str, z16, str2, z17);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeBool");
        }

        public static /* synthetic */ IMMKV encodeBytes$default(IMMKV immkv, String str, byte[] bArr, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeBytes(str, bArr, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeBytes");
        }

        public static /* synthetic */ IMMKV encodeDouble$default(IMMKV immkv, String str, double d16, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeDouble(str, d16, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeDouble");
        }

        public static /* synthetic */ IMMKV encodeFloat$default(IMMKV immkv, String str, float f16, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeFloat(str, f16, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeFloat");
        }

        public static /* synthetic */ IMMKV encodeInt$default(IMMKV immkv, String str, int i3, String str2, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    str2 = "";
                }
                if ((i16 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeInt(str, i3, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeInt");
        }

        public static /* synthetic */ IMMKV encodeLong$default(IMMKV immkv, String str, long j3, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                String str3 = str2;
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeLong(str, j3, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeLong");
        }

        public static /* synthetic */ IMMKV encodeParcelable$default(IMMKV immkv, String str, Parcelable parcelable, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeParcelable(str, parcelable, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeParcelable");
        }

        public static /* synthetic */ IMMKV encodeString$default(IMMKV immkv, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str3 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeString(str, str2, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeString");
        }

        public static /* synthetic */ IMMKV encodeStringSet$default(IMMKV immkv, String str, Set set, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                return immkv.encodeStringSet(str, set, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeStringSet");
        }

        public static /* synthetic */ IMMKV removeKey$default(IMMKV immkv, String str, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = "";
                }
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                return immkv.removeKey(str, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeKey");
        }
    }

    boolean containsKey(@NotNull String key, @NotNull String postFix, boolean ignoreFillUin);

    boolean decodeBool(@NotNull String key, boolean defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    byte[] decodeBytes(@NotNull String key, @NotNull byte[] defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    double decodeDouble(@NotNull String key, double defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    float decodeFloat(@NotNull String key, float defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    int decodeInt(@NotNull String key, int defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    long decodeLong(@NotNull String key, long defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    <T extends Parcelable> T decodeParcelable(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    String decodeString(@NotNull String key, @NotNull String defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    Set<String> decodeStringSet(@NotNull String key, @NotNull Set<String> defaultValue, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeBool(@NotNull String key, boolean value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeBytes(@NotNull String key, @NotNull byte[] value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeDouble(@NotNull String key, double value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeFloat(@NotNull String key, float value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeInt(@NotNull String key, int value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeLong(@NotNull String key, long value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeParcelable(@NotNull String key, @NotNull Parcelable value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeString(@NotNull String key, @NotNull String value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV encodeStringSet(@NotNull String key, @NotNull Set<String> value, @NotNull String postFix, boolean ignoreFillUin);

    @NotNull
    IMMKV removeKey(@NotNull String key, @NotNull String postFix, boolean ignoreFillUin);
}
