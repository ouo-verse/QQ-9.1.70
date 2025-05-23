package oicq.wlogin_sdk.request;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WloginAllSigInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public int mainSigMap;
    public WloginSimpleInfo _useInfo = new WloginSimpleInfo();
    public TreeMap<Long, WloginSigInfo> _tk_map = new TreeMap<>();
    public long _uin = 0;

    public WloginAllSigInfo get_clone() {
        try {
            WloginAllSigInfo wloginAllSigInfo = (WloginAllSigInfo) clone();
            TreeMap<Long, WloginSigInfo> treeMap = this._tk_map;
            if (treeMap != null) {
                Iterator<Long> it = treeMap.keySet().iterator();
                while (it.hasNext()) {
                    WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(it.next().longValue()));
                    if (wloginSigInfo != null) {
                        wloginSigInfo.cacheTickets = null;
                        wloginSigInfo.cacheUpdateStamp = 0L;
                    }
                }
            }
            return wloginAllSigInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public void putNewST(long j3, byte[] bArr, byte[] bArr2) {
        WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(j3));
        if (wloginSigInfo != null) {
            this._tk_map.put(Long.valueOf(j3), wloginSigInfo.setNetST(bArr, bArr2));
        }
    }

    public int put_da2(long j3, byte[] bArr) {
        WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(j3));
        if (wloginSigInfo != null) {
            this._tk_map.put(Long.valueOf(j3), wloginSigInfo.setDA2(bArr));
            return 0;
        }
        return 0;
    }

    public int put_randseed(long j3, byte[] bArr) {
        WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(j3));
        if (wloginSigInfo != null) {
            this._tk_map.put(Long.valueOf(j3), wloginSigInfo.setRandSeed(bArr));
            return 0;
        }
        return 0;
    }

    public int put_siginfo(long j3, long j16, long j17, long j18, long j19, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13, long[] jArr, int i3) {
        WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(j3));
        if (wloginSigInfo != null) {
            wloginSigInfo.mainSigMap = this.mainSigMap;
            this._tk_map.put(Long.valueOf(j3), wloginSigInfo.Set(j16, j17, j18, j19, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, jArr, i3));
            return 0;
        }
        this._tk_map.put(Long.valueOf(j3), new WloginSigInfo(j16, j17, j18, j19, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, jArr, i3, this.mainSigMap));
        return 0;
    }

    public int put_simpleinfo(WloginSimpleInfo wloginSimpleInfo) {
        WloginSimpleInfo wloginSimpleInfo2 = this._useInfo;
        if (wloginSimpleInfo2 == null) {
            this._useInfo = wloginSimpleInfo;
            return 0;
        }
        wloginSimpleInfo2.set_info(wloginSimpleInfo);
        return 0;
    }

    public void resetSigA1Version(long j3) {
        WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(j3));
        if (wloginSigInfo != null) {
            util.LOGI("A1 version resetSigA1Version", "");
            wloginSigInfo._A1_version = 0L;
        }
    }

    public int put_siginfo(long j3, long j16, long j17, byte[] bArr, byte[] bArr2) {
        this._tk_map.put(Long.valueOf(j3), new WloginSigInfo(j16, j17, bArr, bArr2));
        return 0;
    }

    public int put_siginfo(long j3, byte[][] bArr, long j16) {
        WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(j3));
        if (wloginSigInfo == null) {
            return 0;
        }
        this._tk_map.put(Long.valueOf(j3), wloginSigInfo.Set(bArr, j16));
        return 0;
    }

    public int put_siginfo(long j3, byte[][] bArr, long j16, long j17) {
        WloginSigInfo wloginSigInfo = this._tk_map.get(Long.valueOf(j3));
        if (wloginSigInfo == null) {
            return 0;
        }
        this._tk_map.put(Long.valueOf(j3), wloginSigInfo.Set(bArr, j16, j17));
        return 0;
    }
}
