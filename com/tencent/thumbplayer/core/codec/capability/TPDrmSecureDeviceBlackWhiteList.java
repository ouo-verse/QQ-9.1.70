package com.tencent.thumbplayer.core.codec.capability;

import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes26.dex */
public class TPDrmSecureDeviceBlackWhiteList {
    private static HashMap<Integer, ArrayList<String>> sDrmSecureComponentModelBlackList = new HashMap<>();

    static {
        addDrmBlackList(0, "RVL-AL09");
        addDrmBlackList(0, "CLT-L29");
        addDrmBlackList(0, "ASUS_Z00AD");
        addDrmBlackList(0, TPSystemInfo.getDeviceName());
    }

    private static void addDrmBlackList(int i3, String str) {
        if (sDrmSecureComponentModelBlackList.containsKey(Integer.valueOf(i3))) {
            ArrayList<String> arrayList = sDrmSecureComponentModelBlackList.get(Integer.valueOf(i3));
            Objects.requireNonNull(arrayList);
            arrayList.add(str);
        } else {
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(str);
            sDrmSecureComponentModelBlackList.put(Integer.valueOf(i3), arrayList2);
        }
    }

    public static boolean isCurrentDeviceInDrmSecureComponentBlackList(int i3) {
        ArrayList<String> arrayList;
        if (!sDrmSecureComponentModelBlackList.containsKey(Integer.valueOf(i3)) || (arrayList = sDrmSecureComponentModelBlackList.get(Integer.valueOf(i3))) == null || !arrayList.contains(TPSystemInfo.getDeviceName())) {
            return false;
        }
        return true;
    }
}
