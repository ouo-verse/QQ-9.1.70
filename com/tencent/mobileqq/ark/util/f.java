package com.tencent.mobileqq.ark.util;

import com.tencent.ark.mmkv.IMMKV;
import com.tencent.ark.mmkv.MMKVUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f implements IMMKV {

    /* renamed from: a, reason: collision with root package name */
    private MMKVOptionEntity f199654a;

    public f(MMKVOptionEntity mMKVOptionEntity) {
        this.f199654a = mMKVOptionEntity;
    }

    private void a() {
        Set<String> appConfigKeySet = MMKVUtils.getAppConfigKeySet(this);
        if (appConfigKeySet == null) {
            return;
        }
        Iterator<String> it = appConfigKeySet.iterator();
        while (it.hasNext()) {
            this.f199654a.removeKey(it.next());
        }
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void clear() {
        if (this.f199654a == null) {
            return;
        }
        a();
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public boolean getBoolean(String str, boolean z16) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return z16;
        }
        return mMKVOptionEntity.decodeBool(str, z16);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public byte[] getByte(String str, byte[] bArr) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return bArr;
        }
        return mMKVOptionEntity.decodeBytes(str, bArr);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public double getDouble(String str, double d16) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return d16;
        }
        return mMKVOptionEntity.decodeDouble(str, d16);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public float getFloat(String str, float f16) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return f16;
        }
        return mMKVOptionEntity.decodeFloat(str, f16);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public int getInt(String str, int i3) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return i3;
        }
        return mMKVOptionEntity.decodeInt(str, i3);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public long getLong(String str, long j3) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return j3;
        }
        return mMKVOptionEntity.decodeLong(str, j3);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public Set<String> getSet(String str, Set<String> set) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return set;
        }
        return mMKVOptionEntity.decodeStringSet(str, set);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public String getString(String str, String str2) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return str2;
        }
        return mMKVOptionEntity.decodeString(str, str2);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putBoolean(String str, boolean z16) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeBool(str, z16);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putByte(String str, byte[] bArr) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeBytes(str, bArr);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putDouble(String str, double d16) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeDouble(str, d16);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putFloat(String str, float f16) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeFloat(str, f16);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putInt(String str, int i3) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeInt(str, i3);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putLong(String str, long j3) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeLong(str, j3);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putSet(String str, Set<String> set) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeStringSet(str, set);
    }

    @Override // com.tencent.ark.mmkv.IMMKV
    public void putString(String str, String str2) {
        MMKVOptionEntity mMKVOptionEntity = this.f199654a;
        if (mMKVOptionEntity == null) {
            return;
        }
        mMKVOptionEntity.encodeString(str, str2);
    }
}
