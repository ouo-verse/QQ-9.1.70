package com.tencent.thumbplayer.core.hdr.capability;

import com.tencent.thumbplayer.core.hdr.capability.device.TPDeviceDescription;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.ArrayList;

/* loaded from: classes26.dex */
public class TPHdrVividCustomRenderBlackWhiteList {
    private static final ArrayList<TPDeviceDescription> sHdrVividSoftDynamicMetadataRenderWhiteList = new ArrayList<>();

    static {
        addHDRVividWhiteList("GLA-LX1", "Huawei Nova 10 Pro", "");
        addHDRVividWhiteList("GLA-LX3", "Huawei Nova 10 Pro", "");
        addHDRVividWhiteList("NCO-LX1", "Huawei Nova 10", "");
        addHDRVividWhiteList("NCO-LX3", "Huawei Nova 10", "");
        addHDRVividWhiteList("FFG-LX1", "Huawei P Smart", "");
        addHDRVividWhiteList("FFG-LX3", "Huawei P Smart", "");
        addHDRVividWhiteList("PGB-AL00", "Huawei Unreleased Model", "");
        addHDRVividWhiteList("PGB-LX1", "Huawei Unreleased Model", "");
        addHDRVividWhiteList("PGB-LX3", "Huawei Unreleased Model", "");
        addHDRVividWhiteList("MGZ-BD00", "Huawei Nova 10", "");
        addHDRVividWhiteList("ALH-BD00", "Huawei Nova 10", "");
        addHDRVividWhiteList("ABR-AL00", "Huawei P50", "");
        addHDRVividWhiteList("NAM-AL00", "Huawei Nova 9", "");
        addHDRVividWhiteList("ABR-AL60", "Huawei P50E", "");
        addHDRVividWhiteList("BAL-AL00", "Huawei P50 Pocket", "");
        addHDRVividWhiteList("FFG-AL00", "Huawei Enjoy 10s", "");
        addHDRVividWhiteList("LSA-AN00", "Honor 60", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("ELZ-AN00", "Honor Magic3", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("PEEM00", "OPPO Find X3 Pro", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("PEUM00", "OPPO Find N", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("PHM110", "Oppo Reno9", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("PGW110", "Oppo Reno9 Pro+", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("PFFM10", "OPPO Find X5", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("PFFM20", "OPPO Find X5 Pro", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2241A", "Vivo X90", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2183A", "Vivo X80", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2145A", "Vivo X70 Pro+", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2170A", "Vivo X Note", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2178A", "Vivo X Fold", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2049A", "Vivo iQOO 7", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2231A", "Vivo iQOO Neo7", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2243A", "Vivo iQOO 11 5G", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2254A", "Vivo iQOO 11 Pro", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("V2242A", "Vivo X90 Pro", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("22011211C", "Xiaomi Redmi K50 Pro", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("21121210C", "Xiaomi Redmi K50 Gaming", "2023-3-6\u6dfb\u52a0\uff0c\u9002\u914d\u901a\u8fc7");
        addHDRVividWhiteList("m2381", "Meizu Unreleased Model", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("m2391", "Meizu Unreleased Model", "2023-3-6\u6dfb\u52a0");
        addHDRVividWhiteList("MEIZU 20 Inf", "Meizu 20 Inf", "2023-5-31\u6dfb\u52a0");
        addHDRVividWhiteList("MEIZU 21 Pro", "MEIZU 21 Pro", "2023-12-27\u6dfb\u52a0");
    }

    private static void addHDRVividWhiteList(String str, String str2, String str3) {
        sHdrVividSoftDynamicMetadataRenderWhiteList.add(new TPDeviceDescription(str, str2, str3));
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

    public static String[] getHdrVividSoftDynamicMetadataRenderWhiteList() {
        return getDeviceModelList(sHdrVividSoftDynamicMetadataRenderWhiteList);
    }

    public static boolean isDeviceInHdrVividSoftDynamicMetadataRenderWhiteList() {
        return TPSystemInfo.isCurrentDeviceInList(getHdrVividSoftDynamicMetadataRenderWhiteList());
    }
}
