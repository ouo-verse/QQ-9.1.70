package ha2;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u001bB\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b/\u00100J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016JK\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0018*\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\b\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJG\u0010\u001d\u001a\u00028\u0000\"\b\b\u0000\u0010\u0018*\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001cJ(\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010 \u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010!\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\"\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010#\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010$\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J.\u0010%\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010&\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010'\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010(\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010)\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010,\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010+\u00a8\u00061"}, d2 = {"Lha2/a;", "Lcom/tencent/mobileqq/nearbypro/base/c;", "", "key", "suffix", "", "ignoreUin", "b", "", "defValue", "decodeInt", "", "decodeLong", "", "decodeFloat", "", "decodeDouble", "decodeBool", "decodeString", "", "decodeStringSet", "", "decodeBytes", "Landroid/os/Parcelable;", "T", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;Ljava/lang/String;Z)Landroid/os/Parcelable;", "decodeParcelable", "value", "encodeInt", "encodeLong", "encodeFloat", "encodeDouble", "encodeBool", "encodeString", "encodeStringSet", "encodeBytes", "encodeParcelable", "containsKey", "removeKey", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MMKVOptionEntity entity;

    public a(@Nullable Context context) {
        MMKVOptionEntity mMKVOptionEntity;
        if (context != null) {
            mMKVOptionEntity = QMMKV.from(context, QMMKVFile.FILE_NEARBYPRO);
        } else {
            mMKVOptionEntity = null;
        }
        this.entity = mMKVOptionEntity;
    }

    private final String b(String key, String suffix, boolean ignoreUin) {
        String currentAccountUin;
        if (ignoreUin) {
            currentAccountUin = "";
        } else {
            currentAccountUin = j.b().getCurrentAccountUin();
        }
        return key + "_" + currentAccountUin + "_" + suffix;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @Nullable
    public <T extends Parcelable> T a(@NotNull String key, @NotNull Class<T> clazz, @Nullable T defValue, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return (T) mMKVOptionEntity.decodeParcelable(b(key, suffix, ignoreUin), clazz, defValue);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    public boolean containsKey(@NotNull String key, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.containsKey(b(key, suffix, ignoreUin));
        }
        return false;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    public boolean decodeBool(@NotNull String key, boolean defValue, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeBool(b(key, suffix, ignoreUin), defValue);
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public byte[] decodeBytes(@NotNull String key, @NotNull byte[] defValue, @NotNull String suffix, boolean ignoreUin) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            bArr = mMKVOptionEntity.decodeBytes(b(key, suffix, ignoreUin), defValue);
        } else {
            bArr = null;
        }
        if (bArr != null) {
            return bArr;
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    public double decodeDouble(@NotNull String key, double defValue, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeDouble(b(key, suffix, ignoreUin), defValue);
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    public float decodeFloat(@NotNull String key, float defValue, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeFloat(b(key, suffix, ignoreUin), defValue);
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    public int decodeInt(@NotNull String key, int defValue, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeInt(b(key, suffix, ignoreUin), defValue);
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    public long decodeLong(@NotNull String key, long defValue, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            return mMKVOptionEntity.decodeLong(b(key, suffix, ignoreUin), defValue);
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public <T extends Parcelable> T decodeParcelable(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defValue, @NotNull String suffix, boolean ignoreUin) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            parcelable = mMKVOptionEntity.decodeParcelable(b(key, suffix, ignoreUin), clazz, defValue);
        } else {
            parcelable = null;
        }
        if (parcelable != null) {
            return (T) parcelable;
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public String decodeString(@NotNull String key, @NotNull String defValue, @NotNull String suffix, boolean ignoreUin) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            str = mMKVOptionEntity.decodeString(b(key, suffix, ignoreUin), defValue);
        } else {
            str = null;
        }
        if (str != null) {
            return str;
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public Set<String> decodeStringSet(@NotNull String key, @NotNull Set<String> defValue, @NotNull String suffix, boolean ignoreUin) {
        Set<String> set;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            set = mMKVOptionEntity.decodeStringSet(b(key, suffix, ignoreUin), defValue);
        } else {
            set = null;
        }
        if (set != null) {
            return set;
        }
        return defValue;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeBool(@NotNull String key, boolean value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeBool(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeBytes(@NotNull String key, @NotNull byte[] value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeBytes(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeDouble(@NotNull String key, double value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeDouble(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeFloat(@NotNull String key, float value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeFloat(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeInt(@NotNull String key, int value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeInt(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeLong(@NotNull String key, long value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeLong(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeParcelable(@NotNull String key, @NotNull Parcelable value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeParcelable(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeString(@NotNull String key, @NotNull String value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeString(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c encodeStringSet(@NotNull String key, @NotNull Set<String> value, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.encodeStringSet(b(key, suffix, ignoreUin), value);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.nearbypro.base.c
    @NotNull
    public c removeKey(@NotNull String key, @NotNull String suffix, boolean ignoreUin) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        MMKVOptionEntity mMKVOptionEntity = this.entity;
        if (mMKVOptionEntity != null) {
            mMKVOptionEntity.removeKey(b(key, suffix, ignoreUin));
        }
        return this;
    }
}
