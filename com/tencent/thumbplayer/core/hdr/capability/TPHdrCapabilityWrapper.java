package com.tencent.thumbplayer.core.hdr.capability;

import com.tencent.thumbplayer.core.utils.TPMethodCalledByNative;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHdrCapabilityWrapper {
    private static final int[] sEmptryIntArray = new int[0];
    private static HashMap<Integer, HashMap<Integer, ITPHdrCapability>> sRenderTypeToHdrCapabilityMap;

    private static int[] convertSetToArray(Set<Integer> set) {
        if (set != null && set.size() != 0) {
            int[] iArr = new int[set.size()];
            Iterator<Integer> it = set.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = it.next().intValue();
                i3++;
            }
            return iArr;
        }
        return sEmptryIntArray;
    }

    private static int[] convertToArray(ArrayList<Integer> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = arrayList.get(i3).intValue();
            }
            return iArr;
        }
        return sEmptryIntArray;
    }

    @TPMethodCalledByNative
    public static synchronized int[] getHdrCapabilityList(int i3) {
        synchronized (TPHdrCapabilityWrapper.class) {
            initHdrCapabilityMap();
            HashMap<Integer, ITPHdrCapability> hashMap = sRenderTypeToHdrCapabilityMap.get(Integer.valueOf(i3));
            if (hashMap == null) {
                return sEmptryIntArray;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Integer, ITPHdrCapability> entry : hashMap.entrySet()) {
                if (entry.getValue().isSupported()) {
                    arrayList.add(entry.getKey());
                }
            }
            return convertToArray(arrayList);
        }
    }

    @TPMethodCalledByNative
    public static synchronized int[] getHdrSupportedMappingTypes(int i3, int i16) {
        synchronized (TPHdrCapabilityWrapper.class) {
            initHdrCapabilityMap();
            HashMap<Integer, ITPHdrCapability> hashMap = sRenderTypeToHdrCapabilityMap.get(Integer.valueOf(i3));
            if (hashMap == null) {
                return sEmptryIntArray;
            }
            ITPHdrCapability iTPHdrCapability = hashMap.get(Integer.valueOf(i16));
            if (iTPHdrCapability != null && iTPHdrCapability.getSupportedMappingTypes().size() != 0) {
                return convertSetToArray(iTPHdrCapability.getSupportedMappingTypes());
            }
            return sEmptryIntArray;
        }
    }

    private static synchronized void initHdrCapabilityMap() {
        synchronized (TPHdrCapabilityWrapper.class) {
            if (sRenderTypeToHdrCapabilityMap == null) {
                sRenderTypeToHdrCapabilityMap = new HashMap<>();
                HashMap<Integer, ITPHdrCapability> hashMap = new HashMap<>();
                hashMap.put(0, new TPHdr10SystemRenderCapability());
                hashMap.put(1, new TPHdr10PlusSystemRenderCapability());
                hashMap.put(2, new TPHdrDolbyVisionSystemRenderCapability());
                hashMap.put(4, new TPHdrVividSystemRenderCapability());
                sRenderTypeToHdrCapabilityMap.put(108, hashMap);
                HashMap<Integer, ITPHdrCapability> hashMap2 = new HashMap<>();
                if (TPHDRCapabilityConfig.getHdrVividSoftOESTextureRenderEnable()) {
                    hashMap2.put(4, new TPHdrVividCustomRenderCapabilityForOESTexture());
                } else {
                    hashMap2.put(4, new TPHdrVividCustomRenderCapability());
                }
                sRenderTypeToHdrCapabilityMap.put(101, hashMap2);
            }
        }
    }
}
