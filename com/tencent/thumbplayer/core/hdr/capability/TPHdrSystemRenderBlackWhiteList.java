package com.tencent.thumbplayer.core.hdr.capability;

import com.tencent.thumbplayer.core.hdr.capability.device.TPDeviceDescription;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPHdrSystemRenderBlackWhiteList {
    private static final HashMap<Integer, ArrayList<TPDeviceDescription>> sHdrModelBlackListMap = new HashMap<>();
    private static final HashMap<Integer, ArrayList<TPDeviceDescription>> sHdrModelWhiteListMap = new HashMap<>();
    private static final HashMap<Integer, String[]> sHdrManufacturerlBlackListMap = new HashMap<>();
    private static final HashMap<Integer, String[]> sHdrManufacturerWhiteListMap = new HashMap<>();

    static {
        addBlackList(0, "SM-G9730", "Samsung Galaxy S10", "");
        addBlackList(0, "SM-G9750", "Samsung Galaxy S10+", "");
        addBlackList(0, "SM-G9650", "Samsung Galaxy S9+", "");
        addBlackList(0, "SM-N9600", "Samsung Galaxy Note9", "");
        addBlackList(0, "SM-G8870", "Samsung Galaxy A8s", "2023-12-13\uff0c\u6d4b\u8bd5\u540c\u5b66\u53cd\u9988\u81fb\u5f69\u7070\u8499");
        addBlackList(0, "BLA-AL00", "Huawei Mate 10 Pro", "");
        addBlackList(0, "LYA-AL00", "Huawei Mate 20 Pro", "");
        addBlackList(0, "ALP-L29", "Huawei Mate 10", "");
        addBlackList(0, "EVR-AL00", "Huawei Mate 20 X", "");
        addBlackList(0, "NOH-AN01", "Huawei Mate 40 Pro 5G", "\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "NOH-AN00", "Huawei Mate 40 Pro", "");
        addBlackList(0, "GLA-AL00", "Huawei Nova 10 Pro", "");
        addBlackList(0, "NCO-AL00", "Huawei Nova 10", "");
        addBlackList(0, "NOP-AN00", "Huawei Mate 40 Pro+", "");
        addBlackList(0, "JAD-AL50", "Huawei P50 Pro", "\u7528\u6237\u53cd\u9988\u753b\u9762\u7070\u6697");
        addBlackList(0, "RTE-AL00", "Huawei Nova 9 Pro", "");
        addBlackList(0, "ALT-AL10", "HUAWEI Mate X5 \u6216 HUAWEI Mate X5 \u5178\u85cf\u7248", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "ALT-L49", "HUAWEI Mate X5", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "BRA-AL00", "HUAWEI Mate 60", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "BRA-AL20", "HUAWEI Mate 60", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "ALN-AL00", "HUAWEI Mate 60 Pro", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "ALN-AL20", "HUAWEI Mate 60 Pro", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "ALN-AL80", "HUAWEI Mate 60 Pro", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "ALN-L29", "HUAWEI Mate 60 Pro", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "ALN-AL10", "HUAWEI Mate 60 Pro+\u6216HUAWEI Mate 60 Pro RS", "2024-04-08\u6dfb\u52a0\uff0cHDR10\u663e\u793a\u6709\u660e\u663e\u8272\u5e26\u95ee\u9898\uff0c\u7b49\u5f85\u8bbe\u5907\u5347\u7ea7\u89e3\u51b3");
        addBlackList(0, "ANP-AN00", "Honor 80 Pro", "");
        addBlackList(0, "SDY-AN00", "Honor 70 Pro", "");
        addBlackList(0, "ANN-AN00", "Honor 80", "");
        addBlackList(0, "VNE-AN00", "Honor Play 30", "");
        addBlackList(0, "RMO-AN00", "Honor X40 5G ", "");
        addBlackList(0, "ALI-AN00", "Honor X50", "");
        addBlackList(0, "LGE-AN10", "Honor Magic4 Pro", "");
        addBlackList(0, "ANY-AN00", "Honor X30 5G", "");
        addBlackList(0, "TNY-AL00", "Honor Magic 2", "");
        addBlackList(0, "BKL-AL20", "Honor View 10", "");
        addBlackList(0, "RNA-AN00", "Honor 50 Pro", "");
        addBlackList(0, "LGE-AN00", "Honor Magic4", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u989c\u8272\u53d8\u6de1");
        addBlackList(0, "ANB-AN00", "Honor 80 Pro Flat", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "AGM3-W09HN", "Honor Pad X8", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "TEL-AN10", "Honor X10", "2023-12-13\u6dfb\u52a0\uff0c\u8bc4\u6d4b\u989c\u8272\u7f3a\u5c11\u9971\u548c\u5ea6\uff0c\u6cdb\u767d");
        addBlackList(0, "BMH-AN10", "Honor 30", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u989c\u8272\u8272\u5f69\u7070\u6697");
        addBlackList(0, "ROD-W09", "Honor Pad V8 Pro", "2024-5-11\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u7070\u767d\u611f\u5f88\u5f3a");
        addBlackList(0, "NTH-AN00", "Honor 50", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "FNE-AN00", "Honor 70", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "vivo NEX A", "Vivo NEX A", "");
        addBlackList(0, "V2171A", "IQOO 9", "");
        addBlackList(0, "V2271A", "Vivo Y78+", "");
        addBlackList(0, "V2054A", "Vivo Y31s", "");
        addBlackList(0, "V2046A", "Vivo X60", "");
        addBlackList(0, "V2111A", "Vivo Y53s", "");
        addBlackList(0, "V2162A", "Vivo S12", "");
        addBlackList(0, "V2055A", "IQOO Neo5", "");
        addBlackList(0, "V1986A", "Vivo V19", "");
        addBlackList(0, "V2196A", "IQOO Neo6", "");
        addBlackList(0, "PA2373", "Vivo Pad2", "\u7528\u6237\u53cd\u9988\u753b\u9762\u53d1\u7070");
        addBlackList(0, "iPA2375", "Vivo iQOO Pad", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "V2314A", "iQOO Z8", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "V2283A", "Vivo S17t", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "V2134A", "Vivo X70 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "V2217A", "Vivo iQOO 10", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "V2218A", "Vivo iQOO 10 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "V2132A", "Vivo X70t", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "V1962A", "vivo S6", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "V2057A", "Vivo Y52s", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "V2302A", "Vivo iQOO Neo8 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "V2203A", "Vivo S15", "2024-2-1\u6dfb\u52a0\uff0c\u5fae\u535a\u7528\u6237\u53cd\u9988\u76f8\u5bf9SDR\u76ae\u80a4\u7070\u767d");
        addBlackList(0, "IPA2451", "IQOO Pad Air", "2024-2-1\u6dfb\u52a0\uff0cHDR\u4eae\u5ea6\u4e0d\u8db3\uff0c\u753b\u9762\u504f\u6697");
        addBlackList(0, "PA2473", "Vivo Unreleased Model", "2024-2-1\u6dfb\u52a0\uff0cHDR\u4eae\u5ea6\u4e0d\u8db3\uff0c\u76f8\u5bf9SDR\u76ae\u80a4\u7070\u767d");
        addBlackList(0, "V2049A", "Vivo iQOO 7", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u4eae\u5ea6\u4e0d\u591f");
        addBlackList(0, "V2121A", "vivo S10", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u53d8\u5f97\u7070\u6697\uff0c\u8fd8\u6ca1\u67091080P\u9c9c\u8273");
        addBlackList(0, "iPA2475", "IQOO pad2 Pro", "2024-4-19\u6dfb\u52a0\uff0c\u989c\u8272\u9971\u548c\u5ea6\u4e0d\u591f\uff0c\u4e0d\u591f\u9c9c\u8273\u3002\u548cvivo\u90a3\u8fb9\u6c9f\u901a\uff0c\u4ed6\u4eec\u4e5f\u5efa\u8bae\u63a8\u9001SDR\uff0c\u548c\u4ed6\u4eec\u540c\u7cfb\u5217\u673a\u578b\u4fdd\u6301\u4e00\u81f4");
        addBlackList(0, "V2141A", "vivo iQOO 8 Pro", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "PA2455", "Unreleased Model", "\u672a\u53d1\u5e03ipad\u673a\u578b\uff0c2024-4-28\u6dfb\u52a0\uff0c\u8bc4\u6d4b\u753b\u9762\u504f\u6697");
        addBlackList(0, "iPA2453", "Unreleased Model", "\u672a\u53d1\u5e03ipad\u673a\u578b\uff0c2024-4-28\u6dfb\u52a0\uff0c\u548cPA2455\u89c4\u683c\u4e00\u6837,\u4e5f\u63a8\u9001SDR");
        addBlackList(0, "PCDM10", "OPPO Reno Z", "");
        addBlackList(0, "PCDT10", "OPPO Reno Z", "");
        addBlackList(0, "CPH1979", "Oppo Reno Z", "");
        addBlackList(0, "PHK110", "OnePlus Ace 2", "");
        addBlackList(0, "PGBM10", "Oppo Reno8", "");
        addBlackList(0, "PFUM10", "Oppo A96", "");
        addBlackList(0, "PFJM10", "Oppo Reno7", "");
        addBlackList(0, "PFEM10", "OPPO Find X5 Pro", "\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "PERM10", "OPPO k9s", "");
        addBlackList(0, "PGEM10", "OPPO Find X6 Pro", "\u7528\u6237\u53cd\u9988\u753b\u9762\u8fc7\u6697");
        addBlackList(0, "PHW110", "OPPO Reno 10", "");
        addBlackList(0, "PFDM00", "OPPO Reno 7 Pro", "");
        addBlackList(0, "PHB110", "OnePlus 11", "");
        addBlackList(0, "PDYM20", "Oppo A72", "");
        addBlackList(0, "PDKT00", "Oppo A92s 5G", "\u7528\u6237\u53cd\u9988\u4eba\u8138\u504f\u9ed1");
        addBlackList(0, "RMX3562", "Realme GT Neo3", "");
        addBlackList(0, "PEDM00", "Oppo Find X3", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "PEQM00", "Oppo Reno 6", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "PGAM10", "Oppo Reno8 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "PCLM10", "Oppo Reno Ace", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "PERM00", "Oppo K7x", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u5c4f\u5e55\u6cdb\u9ec4");
        addBlackList(0, "PJA110", "OnePlus Ace 2 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u89c6\u9891\u504f\u7070\uff0c\u7f3a\u4e4f\u8272\u5f69");
        addBlackList(0, "PGP110", "OnePlus Ace Pro 10T", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u89c6\u9891\u504f\u7070\uff0c\u7f3a\u4e4f\u8272\u5f69");
        addBlackList(0, "RMX3700", "Realme GT Neo5 SE", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "LE2120", "Oneplus 9 Pro", "2024-2-29\u6dfb\u52a0\uff0cdjangoliu\u7684\u6d4b\u8bd5\u624b\u673a\uff0c\u753b\u9762\u504f\u6697");
        addBlackList(0, "PDEM10", "Oppo Find X2", "2024-3-22\u6dfb\u52a0\uff0ceriktang\u7684\u6d4b\u8bd5\u624b\u673a\uff0c\u753b\u9762\u504f\u6697");
        addBlackList(0, "PJH110", "Oppo Reno11", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u53d1\u6697\u53d1\u9ed1");
        addBlackList(0, "PEAM00", "Oppo Reno4 SE", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u8272\u89c9\u5f88\u9ec4\u8d85\u7ea7\u6696\u8272\u8c03");
        addBlackList(0, "PFFM10", "Oppo Find X5", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u5f88\u9ec4");
        addBlackList(0, "PGKM10", "OnePlus Ace", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u5f88\u9ec4");
        addBlackList(0, "OPD2101", "Oppo Pad", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u53d1\u767d");
        addBlackList(0, "PJV110", "Oppo Reno12", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u53d1\u9ec4\u3001\u504f\u6697");
        addBlackList(0, "PGX110", "Oppo Reno9 Pro", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u53d1\u9ec4");
        addBlackList(0, "PENM00", "Oppo Reno6 Pro+ 5G", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u53d1\u9ec4");
        addBlackList(0, "PGJM10", "Oppo K10 5G", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "Redmi K20 Pro", "Xiaomi Redmi K20 Pro", "");
        addBlackList(0, "MI 8", "Xiaomi MI 8", "");
        addBlackList(0, "M2102K1C", "Xiaomi Mi 11 Ultra", "");
        addBlackList(0, "M2007J1SC", "Xiaomi Mi 10 Ultra", "");
        addBlackList(0, "M2102K1AC", "Xiaomi Mi 11 Pro", "");
        addBlackList(0, "M2011K2C", "Xiaomi Mi 11", "");
        addBlackList(0, "Redmi K30", "Redmi K30", "");
        addBlackList(0, "Redmi K30 Pro Zoom Edition", "Redmi K30 Pro Zoom Edition", "\u7528\u6237\u53cd\u9988\u504f\u6697");
        addBlackList(0, "2312CRAD3C", "Redmi Note 13 Pro", "");
        addBlackList(0, "23077RABDC", "Redmi 12", "");
        addBlackList(0, "22041211AC", "Redmi K50", "");
        addBlackList(0, "21091116UC", "Redmi Note 11", "");
        addBlackList(0, "M2007J22C", "Xiaomi Redmi Note 9", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "2201122C", "Xiaomi 12 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u9ed1\u767d\u8272");
        addBlackList(0, "23043RP34C", "Xiaomi Pad 6", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u7070\u8272");
        addBlackList(0, "M2007J17C", "Xiaomi Redmi Note 9 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "22081212C", "Redmi K50 Ultra", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u5168\u5c4f\u5207\u6362\u65f6\uff0c\u753b\u9762\u5f02\u5e38");
        addBlackList(0, "22041216C", "Xiaomi Redmi Note 11T Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u989c\u8272\u504f\u8272");
        addBlackList(0, "M2012K11AC", "Xiaomi Redmi K40", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "M2102J2SC", "Xiaomi Mi 10S", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "SHARK KTUS-A0", "Black Shark 5 pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "21091116C", "Xiaomi Redmi Note 11 Pro", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u53d1\u9ed1");
        addBlackList(0, "M2104K10AC", "Xiaomi Redmi Note 10 Pro", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u9ec4");
        addBlackList(0, "22127RK46C", "Xiaomi Redmi K60 Pro", "2024-7-15\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u753b\u9762\u504f\u6697");
        addBlackList(0, "16th", "Meizu 16th", "");
        addBlackList(0, "MEIZU 18s", "Meizu 18s", "");
        addBlackList(0, "NX713J", "NubNubia Z50S Pro", "");
        addBlackList(0, "SHARK PRS-A0", "Xiaomi Black Shark 4", "");
        addBlackList(0, "NX769J", "Nubia Red Magic 9", "2023-11-07\u6dfb\u52a0, \u4e2d\u5174\u8981\u6c42\u8fd9\u4e9b\u8bbe\u5907\u4e0d\u8981\u63a8\u9001HDR");
        addBlackList(0, "NX721J", "Nubia Z60 Ultra", "2023-11-07\u6dfb\u52a0, \u4e2d\u5174\u8981\u6c42\u8fd9\u4e9b\u8bbe\u5907\u4e0d\u8981\u63a8\u9001HDR");
        addBlackList(0, "NX702J", "Nubia Z40s Pro", "2023-11-07\u6dfb\u52a0, \u4e2d\u5174\u8981\u6c42\u8fd9\u4e9b\u8bbe\u5907\u4e0d\u8981\u63a8\u9001HDR");
        addBlackList(0, "NX724J", "Nubia Flip", "2023-12-27\u6dfb\u52a0, \u4e2d\u5174\u8981\u6c42\u8fd9\u4e9b\u8bbe\u5907\u4e0d\u8981\u63a8\u9001HDR");
        addBlackList(0, "MEIZU 20 Pro", "Meizu 20 Pro", "2024-4-19\u6dfb\u52a0, \u7528\u6237\u53cd\u9988hdr\u6a21\u5f0f\u753b\u9762\u6210\u7070\u8272");
        addBlackList(0, "MEIZU 21 Note", "MEIZU 21 Note", "2024-4-28\u6dfb\u52a0, \u8bc4\u6d4b\u753b\u9762\u504f\u6697");
        addBlackList(0, "MEIZU 21", "Meizu 21", "2024-07-15\u6dfb\u52a0\uff0c \u7528\u6237\u53cd\u9988\u504f\u6697");
        addBlackList(0, "NX659J", "Nubia Red Magic 5G", "2023-11-07\u6dfb\u52a0, \u4e2d\u5174\u8981\u6c42\u8fd9\u4e9b\u8bbe\u5907\u4e0d\u8981\u63a8\u9001HDR");
        addBlackList(0, "NX669J-P", "Nubia Red Magic 6 Pro", "2023-12-13\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u989c\u8272\u53d1\u9ec4");
        addBlackList(0, "NP02J", "Unreleased Model", "2024-05-24\u6dfb\u52a0, \u4e2d\u5174\u8981\u6c42\u8fd9\u4e9b\u8bbe\u5907\u4e0d\u8981\u63a8\u9001HDR");
        addBlackList(0, "NX725J", "Nubia Z60S Pro", "2024-05-24\u6dfb\u52a0, \u4e2d\u5174\u8981\u6c42\u8fd9\u4e9b\u8bbe\u5907\u4e0d\u8981\u63a8\u9001HDR");
        addBlackList(0, "Lenovo TB-J607F", "Lenovo Pad Plus ", "2023-11-07\u6dfb\u52a0, \u989c\u8272\u504f\u7ea2");
        addBlackList(0, "Lenovo TB-J706F", "\u8054\u60f3\u5c0f\u65b0Pad Pro", "2024-3-22\u6dfb\u52a0\uff0c\u6d4b\u8bd5\u540c\u5b66\u53cd\u9988\u504f\u6697");
        addBlackList(0, "Lenovo TB-9707F", "Lenovo Legion Y700", "2024-4-19\u6dfb\u52a0\uff0c\u7528\u6237\u53cd\u9988\u5c4f\u5e55\u53d8\u9ec4");
        addBlackList(0, "TB375FC", "Unreleased Model", "2024-6-11\u6dfb\u52a0\uff0c\u8054\u60f3\u53cd\u9988\u8fd9\u4e9b\u8bbe\u5907\u4e0a\u504f\u6697");
        addBlackList(0, "TB374FU", "Unreleased Model", "2024-6-11\u6dfb\u52a0\uff0c\u8054\u60f3\u53cd\u9988\u8fd9\u4e9b\u8bbe\u5907\u4e0a\u504f\u6697");
        addBlackList(0, "TB373ZC", "Unreleased Model", "2024-6-11\u6dfb\u52a0\uff0c\u8054\u60f3\u53cd\u9988\u8fd9\u4e9b\u8bbe\u5907\u4e0a\u504f\u6697");
        addBlackList(0, "TB373FU", "Unreleased Model", "2024-6-11\u6dfb\u52a0\uff0c\u8054\u60f3\u53cd\u9988\u8fd9\u4e9b\u8bbe\u5907\u4e0a\u504f\u6697");
        addWhiteList(4, "PHY110", "Oppo Find X7 Ultra", "2023-12-27\u6dfb\u52a0, \u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "PJD110", "OnePlus 12", "2023-12-27\u6dfb\u52a0, \u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "PHY120", "OPPO Find X7 Ultra \u536b\u661f\u901a\u4fe1\u7248", "2024-2-29\u6dfb\u52a0, \u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "BVL-AN00", "Honor Unreleased Model", "2023-12-27\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "BVL-AN16", "Honor Unreleased Model", "2023-12-27\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "BVL-AN20", "Honor Unreleased Model", "2023-12-27\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "LRA-AN00", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-04-28\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "ELI-AN00", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-04-28\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "ELP-AN00", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-04-28\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "FLC-AN00", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-05-24\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "FCP-AN10", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-05-24\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "FCP-N49", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-05-24\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "ROD2-W09", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-06-11\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "ROD2-W69", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-06-11\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "FCP-AN20", "Unreleased Model", "\u672a\u53d1\u5e03\u673a\u578b\uff0c2024-07-15\u6dfb\u52a0\uff0c\u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
        addWhiteList(4, "24031PN0DC", "Xiaomi 14 Ultra", "2024-2-29\u6dfb\u52a0, \u5df2\u901a\u8fc7\u8054\u76df\u8ba4\u8bc1");
    }

    private static void addBlackList(int i3, String str, String str2, String str3) {
        HashMap<Integer, ArrayList<TPDeviceDescription>> hashMap = sHdrModelBlackListMap;
        ArrayList<TPDeviceDescription> arrayList = hashMap.get(Integer.valueOf(i3));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            hashMap.put(Integer.valueOf(i3), arrayList);
        }
        arrayList.add(new TPDeviceDescription(str, str2, str3));
    }

    private static void addWhiteList(int i3, String str, String str2, String str3) {
        HashMap<Integer, ArrayList<TPDeviceDescription>> hashMap = sHdrModelWhiteListMap;
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

    public static boolean isCurrentDeviceInHdrBlackList(int i3) {
        HashMap<Integer, ArrayList<TPDeviceDescription>> hashMap = sHdrModelBlackListMap;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return TPSystemInfo.isCurrentDeviceInList(getDeviceModelList(hashMap.get(Integer.valueOf(i3))));
        }
        return false;
    }

    public static boolean isCurrentDeviceInHdrWhiteList(int i3) {
        HashMap<Integer, ArrayList<TPDeviceDescription>> hashMap = sHdrModelWhiteListMap;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return TPSystemInfo.isCurrentDeviceInList(getDeviceModelList(hashMap.get(Integer.valueOf(i3))));
        }
        return false;
    }

    public static boolean isCurrentDeviceOrManufacturerInHdrWhiteList(int i3) {
        boolean z16;
        if (!isCurrentDeviceInHdrWhiteList(i3) && !isManufacturerInHdrWhiteList(i3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (i3 != 4) {
            return z16;
        }
        if (!z16 && !TPHdrVividBlackWhiteListForHuaWei.isDeviceInHdrVividMediaCodecWhiteList()) {
            return false;
        }
        return true;
    }

    public static boolean isManufacturerInHdrBlackList(int i3) {
        HashMap<Integer, String[]> hashMap = sHdrManufacturerlBlackListMap;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return TPSystemInfo.isCurrentManufacturerInList(hashMap.get(Integer.valueOf(i3)));
        }
        return false;
    }

    public static boolean isManufacturerInHdrWhiteList(int i3) {
        HashMap<Integer, String[]> hashMap = sHdrManufacturerWhiteListMap;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return TPSystemInfo.isCurrentManufacturerInList(hashMap.get(Integer.valueOf(i3)));
        }
        return false;
    }
}
