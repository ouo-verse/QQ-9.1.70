package com.tencent.thumbplayer.core.codec.common;

import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPMediaCodecInstanceCountMgr {
    private static final HashMap<String, Integer> sCurDecoderCnt = new HashMap<>();
    private static TPMediaCodecInstanceCountMgr sMgr;

    TPMediaCodecInstanceCountMgr() {
    }

    public static synchronized TPMediaCodecInstanceCountMgr sharedInstance() {
        TPMediaCodecInstanceCountMgr tPMediaCodecInstanceCountMgr;
        synchronized (TPMediaCodecInstanceCountMgr.class) {
            if (sMgr == null) {
                sMgr = new TPMediaCodecInstanceCountMgr();
            }
            tPMediaCodecInstanceCountMgr = sMgr;
        }
        return tPMediaCodecInstanceCountMgr;
    }

    public synchronized void deregisterOneDecoder(String str) {
        HashMap<String, Integer> hashMap = sCurDecoderCnt;
        Integer num = hashMap.get(str);
        if (num != null && num.intValue() != 0) {
            hashMap.put(str, Integer.valueOf(num.intValue() - 1));
        }
    }

    public synchronized int getCurrentDecoderCnt(String str) {
        int intValue;
        Integer num = sCurDecoderCnt.get(str);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        return intValue;
    }

    public synchronized void registerOneDecoder(String str) {
        int intValue;
        HashMap<String, Integer> hashMap = sCurDecoderCnt;
        Integer num = hashMap.get(str);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        hashMap.put(str, Integer.valueOf(intValue + 1));
    }
}
