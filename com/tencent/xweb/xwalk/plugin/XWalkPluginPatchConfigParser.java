package com.tencent.xweb.xwalk.plugin;

import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.rdelivery.reshub.FileSuffix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes27.dex */
public class XWalkPluginPatchConfigParser {

    /* loaded from: classes27.dex */
    public static class PluginPatchConfig {
        public String originalFileName;
        public String patchFileName;
        public int patchType = 1;
        public int type;

        public boolean isTypeAdd() {
            if (this.type == 1) {
                return true;
            }
            return false;
        }

        public boolean isTypeModify() {
            if (this.type == 2) {
                return true;
            }
            return false;
        }

        public boolean isTypeRemove() {
            if (this.type == 3) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "PluginPatchConfig type:" + this.type + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName;
        }
    }

    public static List<PluginPatchConfig> getPluginPatchConfigList(File file) {
        BufferedReader bufferedReader;
        String substring;
        int i3;
        ArrayList arrayList = new ArrayList();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!readLine.isEmpty()) {
                            if (readLine.startsWith("ADD:")) {
                                substring = readLine.substring(4);
                                i3 = 1;
                            } else if (readLine.startsWith("MOD:")) {
                                substring = readLine.substring(4);
                                i3 = 2;
                            } else if (readLine.startsWith("DEL:")) {
                                substring = readLine.substring(4);
                                i3 = 3;
                            } else {
                                x0.c("XWalkPluginPatchConfigP", "getPluginPatchConfigList unknown flag:" + readLine);
                                return null;
                            }
                            for (String str : substring.split(",")) {
                                if (str != null && !str.isEmpty()) {
                                    PluginPatchConfig pluginPatchConfig = new PluginPatchConfig();
                                    pluginPatchConfig.originalFileName = str;
                                    pluginPatchConfig.type = i3;
                                    if (i3 == 2) {
                                        pluginPatchConfig.patchFileName = pluginPatchConfig.originalFileName + FileSuffix.PATCH_FILE;
                                    }
                                    x0.d("XWalkPluginPatchConfigP", "getPluginPatchConfigList config:" + pluginPatchConfig.toString());
                                    arrayList.add(pluginPatchConfig);
                                }
                            }
                        }
                    } else {
                        return arrayList;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        x0.a("XWalkPluginPatchConfigP", "getPluginPatchConfigList error", th);
                        return null;
                    } finally {
                        w.a(bufferedReader);
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
    }
}
