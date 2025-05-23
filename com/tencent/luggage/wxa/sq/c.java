package com.tencent.luggage.wxa.sq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.xwalk.plugin.XWalkFullScreenVideoPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static String a(String str) {
        return "window.addEventListener('DOMContentLoaded', function() {" + str + "});this.xwebReturn = function (){return \"1\";};this.xwebReturn()";
    }

    public static String a() {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        IOException e16;
        BufferedReader bufferedReader;
        XWalkPlugin plugin = XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
        String str = null;
        str = null;
        r3 = null;
        BufferedReader bufferedReader2 = null;
        int i3 = -1;
        if (plugin == null || plugin.getAvailableVersion() == -1) {
            fileInputStream = null;
        } else {
            int availableVersion = plugin.getAvailableVersion();
            File file = new File(plugin.getDownloadFullPath(plugin.getAvailableVersion(), false));
            if (file.isFile() && file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException e17) {
                    x0.a("XWebFullscreenVideoUtil", "initJs, open jsFile error", e17);
                }
                i3 = availableVersion;
            } else {
                plugin.setAvailableVersion(-1, true);
            }
            fileInputStream = null;
            i3 = availableVersion;
        }
        if (fileInputStream != null) {
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (IOException e18) {
                    e16 = e18;
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    w.a(inputStreamReader);
                    w.a(bufferedReader2);
                    w.a(fileInputStream);
                    throw th;
                }
            } catch (IOException e19) {
                e16 = e19;
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                inputStreamReader = null;
            }
            try {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    }
                    str = stringBuffer.toString();
                    w.a(inputStreamReader);
                    w.a(bufferedReader);
                    w.a(fileInputStream);
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader2 = bufferedReader;
                    w.a(inputStreamReader);
                    w.a(bufferedReader2);
                    w.a(fileInputStream);
                    throw th;
                }
            } catch (IOException e26) {
                e16 = e26;
                x0.a("XWebFullscreenVideoUtil", "initJs, open jsFile error", e16);
                w.a(inputStreamReader);
                w.a(bufferedReader);
                w.a(fileInputStream);
                if (str == null) {
                }
                x0.d("XWebFullscreenVideoUtil", "initJs, use video js default");
                String a16 = p0.a(XWalkEnvironment.getApplicationContext(), XWalkFullScreenVideoPlugin.FULLSCREEN_VIDEO_JS_FILENAME);
                n0.w();
                return a16;
            }
        }
        if (str == null && !str.isEmpty()) {
            x0.d("XWebFullscreenVideoUtil", "initJs, use video js version:" + i3);
            n0.x();
            return str;
        }
        x0.d("XWebFullscreenVideoUtil", "initJs, use video js default");
        String a162 = p0.a(XWalkEnvironment.getApplicationContext(), XWalkFullScreenVideoPlugin.FULLSCREEN_VIDEO_JS_FILENAME);
        n0.w();
        return a162;
    }
}
