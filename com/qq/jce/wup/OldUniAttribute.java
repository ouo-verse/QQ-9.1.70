package com.qq.jce.wup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.mini.cache.Entry;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class OldUniAttribute {
    protected HashMap<String, HashMap<String, byte[]>> _data = new HashMap<>();
    protected HashMap<String, Object> cachedClassName = new HashMap<>();
    private HashMap<String, Object> cachedData = new HashMap<>();
    protected String encodeName = "GBK";
    JceInputStream _is = new JceInputStream();

    private void checkObjectType(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    checkObjectType(arrayList, Array.get(obj, 0));
                    return;
                } else {
                    arrayList.add(Entry.DATA_TYPE_Array);
                    arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    return;
                }
            }
            throw new IllegalArgumentException("only byte[] is supported");
        }
        if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    checkObjectType(arrayList, list.get(0));
                    return;
                } else {
                    arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    return;
                }
            }
            if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    checkObjectType(arrayList, obj2);
                    return;
                }
                arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                arrayList.add(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                return;
            }
            arrayList.add(obj.getClass().getName());
            return;
        }
        throw new IllegalArgumentException("can not support Array, please use List");
    }

    private Object getCacheProxy(String str) {
        if (this.cachedClassName.containsKey(str)) {
            return this.cachedClassName.get(str);
        }
        Object createClassByUni = BasicClassTypeUtil.createClassByUni(str);
        this.cachedClassName.put(str, createClassByUni);
        return createClassByUni;
    }

    private void saveDataCache(String str, Object obj) {
        this.cachedData.put(str, obj);
    }

    public void clearCacheData() {
        this.cachedData.clear();
    }

    public boolean containsKey(String str) {
        return this._data.containsKey(str);
    }

    public void decode(byte[] bArr) {
        this._is.wrap(bArr);
        this._is.setServerEncoding(this.encodeName);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this._data = this._is.readMap(hashMap, 0, false);
    }

    public byte[] encode() {
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.encodeName);
        jceOutputStream.write((Map) this._data, 0);
        return JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T get(String str) throws ObjectCreateException {
        String str2 = null;
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
            str2 = next.getKey();
            bArr = next.getValue();
        }
        try {
            Object cacheProxy = getCacheProxy(str2);
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            T t16 = (T) this._is.read((JceInputStream) cacheProxy, 0, true);
            saveDataCache(str, t16);
            return t16;
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new ObjectCreateException(e16);
        }
    }

    public String getEncodeName() {
        return this.encodeName;
    }

    public <T> T getJceStruct(String str) throws ObjectCreateException {
        String str2 = null;
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
            str2 = next.getKey();
            bArr = next.getValue();
        }
        try {
            Object cacheProxy = getCacheProxy(str2);
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            T t16 = (T) this._is.directRead((JceStruct) cacheProxy, 0, true);
            saveDataCache(str, t16);
            return t16;
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new ObjectCreateException(e16);
        }
    }

    public Set<String> getKeySet() {
        return Collections.unmodifiableSet(this._data.keySet());
    }

    public boolean isEmpty() {
        return this._data.isEmpty();
    }

    public <T> void put(String str, T t16) {
        if (str != null) {
            if (t16 != null) {
                if (!(t16 instanceof Set)) {
                    JceOutputStream jceOutputStream = new JceOutputStream();
                    jceOutputStream.setServerEncoding(this.encodeName);
                    jceOutputStream.write(t16, 0);
                    byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
                    HashMap<String, byte[]> hashMap = new HashMap<>(1);
                    ArrayList<String> arrayList = new ArrayList<>(1);
                    checkObjectType(arrayList, t16);
                    hashMap.put(BasicClassTypeUtil.transTypeList(arrayList), jceBufArray);
                    this.cachedData.remove(str);
                    this._data.put(str, hashMap);
                    return;
                }
                throw new IllegalArgumentException("can not support Set");
            }
            throw new IllegalArgumentException("put value can not is null");
        }
        throw new IllegalArgumentException("put key can not is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T remove(String str) throws ObjectCreateException {
        String str2;
        byte[] bArr;
        if (!this._data.containsKey(str)) {
            return null;
        }
        byte[] bArr2 = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this._data.remove(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            str2 = next.getKey();
            bArr = next.getValue();
        } else {
            str2 = "";
            bArr = bArr2;
        }
        try {
            Object createClassByUni = BasicClassTypeUtil.createClassByUni(str2);
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            return (T) this._is.read((JceInputStream) createClassByUni, 0, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            throw new ObjectCreateException(e16);
        }
    }

    public void setEncodeName(String str) {
        this.encodeName = str;
    }

    public int size() {
        return this._data.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T get(String str, Object obj) {
        String str2;
        byte[] bArr;
        if (!this._data.containsKey(str)) {
            return obj;
        }
        if (this.cachedData.containsKey(str)) {
            return (T) this.cachedData.get(str);
        }
        byte[] bArr2 = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this._data.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            str2 = next.getKey();
            bArr = next.getValue();
        } else {
            str2 = "";
            bArr = bArr2;
        }
        try {
            Object cacheProxy = getCacheProxy(str2);
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            T t16 = (T) this._is.read((JceInputStream) cacheProxy, 0, true);
            saveDataCache(str, t16);
            return t16;
        } catch (Exception e16) {
            e16.printStackTrace();
            saveDataCache(str, obj);
            return obj;
        }
    }
}
