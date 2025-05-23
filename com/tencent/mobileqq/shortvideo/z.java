package com.tencent.mobileqq.shortvideo;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public class z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f288332a;

        /* renamed from: b, reason: collision with root package name */
        private String[] f288333b;

        a(String str) {
            this.f288332a = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            String str = this.f288332a;
            if (str != null && !"".equals(str)) {
                String[] split = this.f288332a.split("\\_");
                this.f288333b = split;
                if (split == null) {
                    return -1;
                }
                if (split.length < 2) {
                    return -2;
                }
                return 0;
            }
            return -3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(char c16) {
            String str = this.f288332a;
            if (str != null && !"".equals(str)) {
                String[] split = this.f288332a.split("\\" + c16);
                this.f288333b = split;
                if (split == null) {
                    return -1;
                }
                if (split.length < 2) {
                    return -2;
                }
                return 0;
            }
            return -3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String c() {
            return this.f288333b[0].trim();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String d() {
            return this.f288333b[0].trim();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String e() {
            return this.f288333b[1].trim();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String f() {
            return this.f288333b[1].trim();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        String b16;
        try {
            b16 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
            VideoEnvironment.LogDownLoad("ShortVideoSoManager:computeMd5[MD5.getFileMd5]md5=" + b16, null);
        } catch (UnsatisfiedLinkError e16) {
            VideoEnvironment.LogDownLoad("ShortVideoSoManager:computeMd5[MD5.getFileMd5] ", e16);
            b16 = b(str);
        }
        if (b16 == null || "".equals(b16)) {
            return b(str);
        }
        return b16;
    }

    static String b(String str) {
        try {
            return com.tencent.qqprotect.singleupdate.a.d(new File(str));
        } catch (Exception e16) {
            VideoEnvironment.LogDownLoad("ShortVideoSoManager:computeMd5[getFileMD5String]", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(String str) {
        return new a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(File file) {
        return FileUtils.readFileContent(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"WrongConstant"})
    public static String e() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String decodeString = from.decodeString("short_video_md5_version_so_name", "d000_1");
        if ("d000_1".equals(decodeString)) {
            SharedPreferences sharedPreferences = VideoEnvironment.getContext().getSharedPreferences("short_video_mgr_sp", 4);
            String string = sharedPreferences.getString("sv_md5_version_soname_key", "d000_1");
            if (!"d000_1".equals(string)) {
                from.encodeString("short_video_md5_version_so_name", string);
                sharedPreferences.edit().remove("short_video_md5_version_so_name").apply();
            }
            return string;
        }
        return decodeString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String f(String str, String str2) {
        return str + util.base64_pad_url + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"WrongConstant"})
    public static boolean g(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString("short_video_md5_version_so_name", str);
        VideoEnvironment.LogDownLoad("ShortVideoSoManager.storeSoNewVersion", null);
        return true;
    }
}
