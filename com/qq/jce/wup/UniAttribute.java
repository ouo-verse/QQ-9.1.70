package com.qq.jce.wup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class UniAttribute extends OldUniAttribute {
    protected HashMap<String, byte[]> _newData = null;
    private HashMap<String, Object> cachedData = new HashMap<>();
    JceInputStream _is = new JceInputStream();

    private Object decodeData(byte[] bArr, Object obj) {
        this._is.wrap(bArr);
        this._is.setServerEncoding(this.encodeName);
        return this._is.read((JceInputStream) obj, 0, true);
    }

    private void saveDataCache(String str, Object obj) {
        this.cachedData.put(str, obj);
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public void clearCacheData() {
        this.cachedData.clear();
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public boolean containsKey(String str) {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            return hashMap.containsKey(str);
        }
        return this._data.containsKey(str);
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public void decode(byte[] bArr) {
        try {
            super.decode(bArr);
        } catch (Exception unused) {
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this._newData = this._is.readMap(hashMap, 0, false);
        }
    }

    public void decodeVersion2(byte[] bArr) {
        super.decode(bArr);
    }

    public void decodeVersion3(byte[] bArr) {
        this._is.wrap(bArr);
        this._is.setServerEncoding(this.encodeName);
        HashMap hashMap = new HashMap(1);
        hashMap.put("", new byte[0]);
        this._newData = this._is.readMap(hashMap, 0, false);
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public byte[] encode() {
        if (this._newData != null) {
            JceOutputStream jceOutputStream = new JceOutputStream(0);
            jceOutputStream.setServerEncoding(this.encodeName);
            jceOutputStream.write((Map) this._newData, 0);
            return JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        }
        return super.encode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T get(String str, T t16, Object obj) {
        return !this._newData.containsKey(str) ? obj : (T) getByClass(str, t16);
    }

    public <T> T getByClass(String str, T t16) throws ObjectCreateException {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.cachedData.containsKey(str)) {
                return (T) this.cachedData.get(str);
            }
            try {
                T t17 = (T) decodeData(this._newData.get(str), t16);
                if (t17 != null) {
                    saveDataCache(str, t17);
                }
                return t17;
            } catch (Exception e16) {
                throw new ObjectCreateException(e16);
            }
        }
        if (!this._data.containsKey(str)) {
            return null;
        }
        if (this.cachedData.containsKey(str)) {
            return (T) this.cachedData.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this._data.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            T t18 = (T) this._is.read((JceInputStream) t16, 0, true);
            saveDataCache(str, t18);
            return t18;
        } catch (Exception e17) {
            throw new ObjectCreateException(e17);
        }
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public /* bridge */ /* synthetic */ String getEncodeName() {
        return super.getEncodeName();
    }

    public <T> T getJceStruct(String str, T t16) throws ObjectCreateException {
        if (!this._newData.containsKey(str)) {
            return null;
        }
        if (this.cachedData.containsKey(str)) {
            return (T) this.cachedData.get(str);
        }
        try {
            T t17 = (T) decodeData(this._newData.get(str), t16);
            if (t17 != null) {
                saveDataCache(str, t17);
            }
            return t17;
        } catch (Exception e16) {
            throw new ObjectCreateException(e16);
        }
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public Set<String> getKeySet() {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            return Collections.unmodifiableSet(hashMap.keySet());
        }
        return Collections.unmodifiableSet(this._data.keySet());
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public boolean isEmpty() {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            return hashMap.isEmpty();
        }
        return this._data.isEmpty();
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public <T> void put(String str, T t16) {
        if (this._newData != null) {
            if (str != null) {
                if (t16 != null) {
                    if (!(t16 instanceof Set)) {
                        JceOutputStream jceOutputStream = new JceOutputStream();
                        jceOutputStream.setServerEncoding(this.encodeName);
                        jceOutputStream.write(t16, 0);
                        this._newData.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
                        return;
                    }
                    throw new IllegalArgumentException("can not support Set");
                }
                throw new IllegalArgumentException("put value can not is null");
            }
            throw new IllegalArgumentException("put key can not is null");
        }
        super.put(str, t16);
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public <T> T remove(String str) throws ObjectCreateException {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            this._newData.remove(str);
            return null;
        }
        return (T) super.remove(str);
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public /* bridge */ /* synthetic */ void setEncodeName(String str) {
        super.setEncodeName(str);
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public int size() {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            return hashMap.size();
        }
        return this._data.size();
    }

    public void useVersion3() {
        this._newData = new HashMap<>();
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public <T> T get(String str) throws ObjectCreateException {
        if (this._newData == null) {
            return (T) super.get(str);
        }
        throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
    }

    public <T> T remove(String str, T t16) throws ObjectCreateException {
        if (!this._newData.containsKey(str)) {
            return null;
        }
        if (t16 != null) {
            return (T) decodeData(this._newData.remove(str), t16);
        }
        this._newData.remove(str);
        return null;
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public <T> T get(String str, Object obj) {
        if (this._newData == null) {
            return (T) super.get(str, obj);
        }
        throw new RuntimeException("data is encoded by new version, please use get(String name, T proxy, Object defaultValue)");
    }

    @Override // com.qq.jce.wup.OldUniAttribute
    public <T> T getJceStruct(String str) throws ObjectCreateException {
        if (this._newData == null) {
            return (T) super.getJceStruct(str);
        }
        throw new RuntimeException("data is encoded by new version, please use getJceStruct(String name,T proxy)");
    }

    public <T> T getByClass(String str, T t16, T t17) throws ObjectCreateException {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return t17;
            }
            if (this.cachedData.containsKey(str)) {
                return (T) this.cachedData.get(str);
            }
            try {
                T t18 = (T) decodeData(this._newData.get(str), t16);
                if (t18 != null) {
                    saveDataCache(str, t18);
                }
                return t18;
            } catch (Exception e16) {
                throw new ObjectCreateException(e16);
            }
        }
        if (!this._data.containsKey(str)) {
            return t17;
        }
        if (this.cachedData.containsKey(str)) {
            return (T) this.cachedData.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this._data.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            T t19 = (T) this._is.read((JceInputStream) t16, 0, true);
            saveDataCache(str, t19);
            return t19;
        } catch (Exception e17) {
            throw new ObjectCreateException(e17);
        }
    }
}
