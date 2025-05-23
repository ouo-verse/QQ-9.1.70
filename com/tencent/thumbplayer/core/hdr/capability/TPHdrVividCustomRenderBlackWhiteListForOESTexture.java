package com.tencent.thumbplayer.core.hdr.capability;

import com.tencent.thumbplayer.core.hdr.capability.device.TPDeviceDescription;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPHdrVividCustomRenderBlackWhiteListForOESTexture {
    private static final HashMap<Integer, ArrayList<TPDeviceDescription>> sHdrMappingTypeModelWhiteListMap = new HashMap<>();

    private static void addWhiteList(int i3, String str, String str2, String str3) {
        HashMap<Integer, ArrayList<TPDeviceDescription>> hashMap = sHdrMappingTypeModelWhiteListMap;
        ArrayList<TPDeviceDescription> arrayList = hashMap.get(Integer.valueOf(i3));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            hashMap.put(Integer.valueOf(i3), arrayList);
        }
        arrayList.add(new TPDeviceDescription(str, str2, str3));
    }

    private static String[] getDeviceModelList(ArrayList<TPDeviceDescription> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            String[] strArr = new String[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                strArr[i3] = arrayList.get(i3).getDeviceModel();
            }
            return strArr;
        }
        return null;
    }

    public static boolean isCurrentDeviceInHdrMappingTypeWhiteList(int i3) {
        ArrayList<TPDeviceDescription> arrayList = sHdrMappingTypeModelWhiteListMap.get(Integer.valueOf(i3));
        if (arrayList != null) {
            return TPSystemInfo.isCurrentDeviceInList(getDeviceModelList(arrayList));
        }
        return false;
    }
}
