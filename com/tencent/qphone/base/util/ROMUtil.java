package com.tencent.qphone.base.util;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ROMUtil {
    public static final String KEY_BUILD_DESCRIPTION = "ro.build.description";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_EUI = "ro.letv.release.version";
    private static final String KEY_VERSION_GIONEE_0 = "ro.gn.gnromvernumber";
    private static final String KEY_VERSION_GIONEE_1 = "ro.gn.sv.version";
    private static final String KEY_VERSION_H2OS = "ro.rom.version";
    private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_NUBIA = "ro.build.rom.internal.id";
    private static final String KEY_VERSION_OPPO_0 = "ro.build.version.opporom";
    private static final String KEY_VERSION_OPPO_1 = "ro.rom.different.version";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String KEY_VERSION_ZTE_0 = "ro.build.MiFavor_version";
    private static final String ROM_360 = "360";
    private static final String ROM_ASUS = "ASUS";
    private static final String ROM_BLACK_BERRY = "BLACKBERRY";
    private static final String ROM_COOLPAD = "COOLPAD";
    private static final String ROM_EMUI = "EMUI";
    private static final String ROM_ESSENTIAL_PRODUCTS = "ESSENTIAL PRODUCTS";
    private static final String ROM_EUI = "EUI";
    private static final String ROM_FLYME = "FLYME";
    private static final String ROM_GIONEE = "AMIJO OS";
    private static final String ROM_GOOGLE = "GOOGLE";
    private static final String ROM_H2OS = "H2OS/O2OS";
    private static final String ROM_HTC = "HTC";
    private static final String ROM_LENOVO = "LENOVO";
    private static final String ROM_LG = "LGE";
    private static final String ROM_LINEAGE = "LINEAGE";
    private static final String ROM_MEITU = "MEITU";
    private static final String ROM_MIUI = "MIUI";
    private static final String ROM_MOTOROLA = "MOTOROLA";
    private static final String ROM_NOKAI = "HMD";
    private static final String ROM_NUBIA = "NUBIAUI";
    private static final String ROM_OPPO = "ColorOS";
    private static final String ROM_SAMSUNG = "SAMSUNG";
    private static final String ROM_SMARTISAN = "SMARTISAN";
    private static final String ROM_SONY = "SONY";
    private static final String ROM_SUGAR = "SUGAR";
    private static final String ROM_VIVO = "FuntouchOS";
    private static final String ROM_ZTE = "MiFavorUI";
    private static final String ROM_ZTE_1 = "ZTE";
    private static final String ROM_ZUK = "ZUK";
    private static final String SEPARATOR = ";";
    private static final String TAG = "ROMUtil";
    private static String[] deviceInfo;
    private static String romDescription;
    private static String romDetailInfo;
    private static String romName;
    private static String romVersion;

    public static String getProperty(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, "");
        } catch (Exception e16) {
            e16.printStackTrace();
            if (!QLog.isColorLevel()) {
                return "";
            }
            QLog.d(TAG, 2, "getProperty fail, key=" + str + " , error message:" + e16.getMessage());
            return "";
        }
    }

    public static String getRomDescription() {
        if (romDescription == null) {
            String[] romNameAndVersion = getRomNameAndVersion();
            deviceInfo = romNameAndVersion;
            romDescription = romNameAndVersion[2];
        }
        return romDescription;
    }

    public static String getRomDetailInfo() {
        if (romDetailInfo == null) {
            String[] romNameAndVersion = getRomNameAndVersion();
            deviceInfo = romNameAndVersion;
            romDetailInfo = romNameAndVersion[3];
        }
        return romDetailInfo;
    }

    public static String getRomName() {
        if (romName == null) {
            String[] romNameAndVersion = getRomNameAndVersion();
            deviceInfo = romNameAndVersion;
            romName = romNameAndVersion[0];
        }
        return romName;
    }

    public static String[] getRomNameAndVersion() {
        String str;
        String str2;
        String str3;
        String[] strArr = deviceInfo;
        if (strArr != null) {
            return strArr;
        }
        String property = getProperty(KEY_BUILD_DESCRIPTION);
        String property2 = getProperty(KEY_VERSION_MIUI);
        if (!TextUtils.isEmpty(property2)) {
            str = ROM_MIUI;
        } else {
            property2 = getProperty(KEY_VERSION_EMUI);
            if (!TextUtils.isEmpty(property2)) {
                str = ROM_EMUI;
            } else {
                property2 = getProperty(KEY_VERSION_OPPO_1);
                if (TextUtils.isEmpty(property2)) {
                    property2 = getProperty(KEY_VERSION_OPPO_0);
                    if (TextUtils.isEmpty(property2)) {
                        property2 = getProperty(KEY_VERSION_VIVO);
                        if (!TextUtils.isEmpty(property2)) {
                            str = ROM_VIVO;
                        } else {
                            property2 = getProperty(KEY_VERSION_SMARTISAN);
                            if (!TextUtils.isEmpty(property2)) {
                                str = ROM_SMARTISAN;
                            } else {
                                property2 = getProperty(KEY_VERSION_LENOVO);
                                if (!TextUtils.isEmpty(property2)) {
                                    str = ROM_LENOVO;
                                } else {
                                    String property3 = getProperty(KEY_VERSION_GIONEE_0);
                                    if (TextUtils.isEmpty(property3)) {
                                        property2 = getProperty(KEY_VERSION_GIONEE_0);
                                        if (TextUtils.isEmpty(property2)) {
                                            property2 = getProperty(KEY_VERSION_H2OS);
                                            if (!TextUtils.isEmpty(property2)) {
                                                str = ROM_H2OS;
                                            } else {
                                                property2 = getProperty(KEY_VERSION_EUI);
                                                if (!TextUtils.isEmpty(property2)) {
                                                    str = ROM_EUI;
                                                } else {
                                                    property2 = getProperty(KEY_VERSION_ZTE_0);
                                                    if (!TextUtils.isEmpty(property2)) {
                                                        str = ROM_ZTE;
                                                    } else {
                                                        property2 = getProperty(KEY_VERSION_NUBIA);
                                                        if (!TextUtils.isEmpty(property2)) {
                                                            str = ROM_NUBIA;
                                                        } else {
                                                            property2 = Build.DISPLAY;
                                                            String upperCase = property2.toUpperCase();
                                                            String str4 = ROM_FLYME;
                                                            if (!upperCase.contains(ROM_FLYME)) {
                                                                String upperCase2 = property.toUpperCase();
                                                                str4 = ROM_LINEAGE;
                                                                if (!upperCase2.contains(ROM_LINEAGE)) {
                                                                    String str5 = Build.MANUFACTURER;
                                                                    str4 = str5.toUpperCase();
                                                                    if (str4.contains(ROM_360)) {
                                                                        str = ROM_360;
                                                                    } else if (str4.compareTo(ROM_ZTE_1) != 0 && str4.compareTo(ROM_BLACK_BERRY) != 0 && str4.compareTo(ROM_COOLPAD) != 0) {
                                                                        if (str4.compareTo(ROM_MOTOROLA) != 0 && str4.compareTo(ROM_LENOVO) != 0 && str4.compareTo(ROM_LG) != 0 && str4.compareTo(ROM_ASUS) != 0 && str4.compareTo(ROM_SUGAR) != 0 && str4.compareTo(ROM_ESSENTIAL_PRODUCTS) != 0 && str4.compareTo(ROM_GOOGLE) != 0 && str4.compareTo("ZUK") != 0 && str4.compareTo(ROM_SAMSUNG) != 0) {
                                                                            if (str4.compareTo(ROM_HTC) != 0 && str4.compareTo(ROM_SONY) != 0 && str4.compareTo(ROM_MEITU) != 0) {
                                                                                if (!str4.contains(ROM_NOKAI)) {
                                                                                    if (QLog.isColorLevel()) {
                                                                                        QLog.d(TAG, 2, "Build.MANUFACTURER\uff1a" + str5 + "Build.DISPLAY\uff1a" + property2 + "DESCRIPTION\uff1a" + property);
                                                                                    }
                                                                                    str = "[u]" + str5;
                                                                                    property2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + property2 + ";" + property;
                                                                                }
                                                                            } else {
                                                                                property2 = property2 + "/" + property;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                property2 = property;
                                                            }
                                                            str = str4;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        property2 = property3;
                                    }
                                    str = ROM_GIONEE;
                                }
                            }
                        }
                    }
                }
                str = ROM_OPPO;
            }
        }
        try {
            str2 = property2.replaceAll(property, "");
            try {
                StringBuilder sb5 = new StringBuilder();
                String str6 = Build.DISPLAY;
                sb5.append(str6);
                sb5.append(";");
                String replaceAll = str2.replaceAll(sb5.toString(), "").replaceAll(str6, "");
                if (TextUtils.isEmpty(replaceAll)) {
                    str2 = property;
                } else {
                    str2 = replaceAll + ";" + str6 + ";" + property;
                }
                str3 = str2.replaceAll("\\|", "\\\\");
            } catch (Exception e16) {
                e = e16;
                QLog.e(TAG, 1, "parse tempDetailROMInfo fail,", e);
                str3 = str2;
                deviceInfo = r5;
                String[] strArr2 = {str, property2, property, str3};
                return strArr2;
            }
        } catch (Exception e17) {
            e = e17;
            str2 = property2;
        }
        deviceInfo = strArr2;
        String[] strArr22 = {str, property2, property, str3};
        return strArr22;
    }

    public static String getRomVersion() {
        if (romVersion == null) {
            String[] romNameAndVersion = getRomNameAndVersion();
            deviceInfo = romNameAndVersion;
            romVersion = romNameAndVersion[1];
        }
        return romVersion;
    }

    public static String getRomVersion(int i3) {
        if (i3 <= 0) {
            return "";
        }
        if (romVersion == null) {
            String[] romNameAndVersion = getRomNameAndVersion();
            deviceInfo = romNameAndVersion;
            romVersion = romNameAndVersion[1];
        }
        return romVersion.length() > i3 ? romVersion.substring(0, i3) : romVersion;
    }
}
