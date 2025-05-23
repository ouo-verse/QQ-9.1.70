package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.upload.SampleUpload;
import com.tencent.bugly.common.reporter.upload.UploadProxy;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.bugly.common.utils.HprofFileIUtil;
import com.tencent.intervideo.nowproxy.customized_interface.CustomKey;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bh {

    /* renamed from: k, reason: collision with root package name */
    static final /* synthetic */ boolean f98261k = true;

    /* renamed from: l, reason: collision with root package name */
    private static bh f98262l;

    /* renamed from: a, reason: collision with root package name */
    Context f98263a;

    /* renamed from: c, reason: collision with root package name */
    ai f98265c;

    /* renamed from: b, reason: collision with root package name */
    Boolean f98264b = Boolean.FALSE;

    /* renamed from: d, reason: collision with root package name */
    JSONObject f98266d = null;

    /* renamed from: e, reason: collision with root package name */
    URL f98267e = null;

    /* renamed from: f, reason: collision with root package name */
    UserMeta f98268f = null;

    /* renamed from: g, reason: collision with root package name */
    UploadProxy f98269g = null;

    /* renamed from: h, reason: collision with root package name */
    String f98270h = "";

    /* renamed from: i, reason: collision with root package name */
    String f98271i = "";

    /* renamed from: j, reason: collision with root package name */
    String f98272j = BuildConfigWrapper.getDomain();

    bh() {
    }

    public static bh a() {
        if (f98262l == null) {
            synchronized (bh.class) {
                f98262l = new bh();
            }
        }
        return f98262l;
    }

    private void b(Context context, String str) {
        File file = new File(context.getFilesDir(), "custom_file_record.txt");
        try {
            String readOutputFromFile = FileUtil.readOutputFromFile(file.getCanonicalPath());
            FileUtil.writeFile(file.getAbsolutePath(), "", false);
            if (!this.f98264b.booleanValue()) {
                av.a("uploadLastCustomFiles failed, please call init first", new Object[0]);
                return;
            }
            String[] split = readOutputFromFile.split("######");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split("\n");
                    if (split2 != null && split2.length >= 2) {
                        List asList = Arrays.asList(split2);
                        List subList = asList.subList(2, asList.size());
                        try {
                            String str3 = this.f98271i + File.separator + ((String) asList.get(0)) + "%" + ((String) asList.get(1)) + ".zip";
                            if (FileUtil.zipFiles((List<String>) subList, str3, false)) {
                                File file2 = new File(str3);
                                if (file2.length() > 10485760) {
                                    av.a("attachment's size is too larger, more than 10MB, just delete it", new Object[0]);
                                    file2.delete();
                                }
                            }
                        } catch (Throwable th5) {
                            av.b(th5);
                        }
                    }
                }
            }
            File file3 = new File(this.f98271i);
            if (!file3.exists() || file3.listFiles() == null || file3.listFiles().length <= 0) {
                return;
            }
            for (File file4 : file3.listFiles()) {
                String name = file4.getName();
                if (name.contains(str) && a(file4, name.substring(0, name.indexOf("%")), CustomKey.CUSTOM_LOG, str)) {
                    av.a("Successfully upload custom zip file, identify is: ".concat(String.valueOf(str)), new Object[0]);
                }
            }
        } catch (Throwable th6) {
            av.b(th6);
        }
    }

    private void d(Context context, String str) {
        File[] listFiles;
        String str2;
        try {
            String absolutePath = context.getFilesDir().getAbsolutePath();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(absolutePath);
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append("bugly_asan");
            File file = new File(sb5.toString());
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                File file2 = new File(absolutePath + str3 + "bugly_asan_zip");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                for (File file3 : listFiles) {
                    if (file3.isFile()) {
                        String name = file3.getName();
                        int indexOf = name.indexOf("asan_info_") + 10;
                        int lastIndexOf = name.lastIndexOf(".");
                        if (indexOf >= 0 && lastIndexOf >= 0 && lastIndexOf > indexOf) {
                            str2 = name.substring(indexOf, lastIndexOf);
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            File file4 = new File(file2, str2);
                            if (!file4.exists()) {
                                file4.mkdirs();
                            }
                            boolean zipFiles = FileUtil.zipFiles((List<String>) Collections.singletonList(file3.getAbsoluteFile().toString()), file4.getAbsoluteFile() + File.separator + "asan_info.zip", false);
                            if (zipFiles) {
                                FileUtil.deleteFile(file3);
                            }
                            av.a("fetch and zip asan file " + name + ", result: " + zipFiles, new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            av.e("failed to fetch and zip asan file.", th5);
        }
        String str4 = context.getFilesDir().getAbsolutePath() + File.separator + "bugly_asan_zip";
        File[] listFiles2 = new File(str4).listFiles();
        if (listFiles2 != null && listFiles2.length != 0) {
            try {
                for (File file5 : listFiles2) {
                    String name2 = file5.getName();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str4);
                    String str5 = File.separator;
                    sb6.append(str5);
                    sb6.append(name2);
                    sb6.append(str5);
                    sb6.append("asan_info.zip");
                    File file6 = new File(sb6.toString());
                    if (name2.equals(str) && a(file6, "crash", "common_file", name2)) {
                        av.a("Successfully upload asan info file, identify is: ".concat(name2), new Object[0]);
                        FileUtil.deleteFile(file5);
                    }
                }
            } catch (Throwable th6) {
                av.b(th6);
            }
        }
    }

    private void e(Context context, String str) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(HprofFileIUtil.getOOMHprofPath());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(str);
            sb5.append(".hprof");
            String sb6 = sb5.toString();
            String str3 = HprofFileIUtil.getOOMHprofZipPath() + str2 + str + str2 + "oom_hprof.zip";
            File file = new File(sb6);
            if (file.exists()) {
                File file2 = new File(str3);
                if (file2.exists()) {
                    file2.delete();
                }
                UploadProxy uploadProxy = new UploadProxy(context, ai.c().f());
                JSONObject makeParam = ReportDataBuilder.makeParam(this.f98263a, "crash", "common_file", this.f98268f);
                try {
                    if (!f98261k && makeParam == null) {
                        throw new AssertionError();
                    }
                    String a16 = a("crash", "common_file");
                    JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
                    makeAttributes.put("token", a16);
                    makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
                    makeParam.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, str);
                    ReportData reportData = new ReportData(ai.c().g(), 1, "CrashUploadEvent", makeParam);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(sb6);
                    FileUtil.zipFiles((List<String>) arrayList, str3, false);
                    reportData.addFile(str3, true, true);
                    uploadProxy.reportFile(reportData, this.f98270h + this.f98269g.getMD5Params(reportData), null);
                    file.delete();
                } catch (JSONException e16) {
                    throw new RuntimeException(e16);
                }
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("CustomFileUploadManager", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final URL c() {
        StringBuilder sb5 = new StringBuilder(512);
        sb5.append(this.f98272j);
        sb5.append("/v1/");
        sb5.append(ai.a(this.f98263a).f());
        sb5.append("/quota/check");
        try {
            return new URL(sb5.toString());
        } catch (Throwable th5) {
            av.b(th5);
            return null;
        }
    }

    private boolean a(File file, String str, String str2, String str3) {
        JSONObject makeAttributes;
        JSONObject makeParam;
        if (!this.f98264b.booleanValue()) {
            av.a("CustomFileManager.upload failed, please call init first", new Object[0]);
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            av.c("upload custom file failed, identify is empty.", new Object[0]);
            return false;
        }
        String a16 = a(str, str2);
        if (a16 == null) {
            return false;
        }
        try {
            makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
            makeAttributes.put("token", a16);
            makeParam = ReportDataBuilder.makeParam(this.f98263a, str, str2, this.f98268f);
        } catch (Throwable th5) {
            av.b(th5);
        }
        if (makeParam == null) {
            av.d("failed to build upload params, return.", new Object[0]);
            return false;
        }
        if (!ai.f97987ae) {
            makeAttributes.put("crash_identify", str3);
        } else {
            makeParam.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, str3);
        }
        makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
        ReportData reportData = new ReportData(this.f98268f.uin, 1, str2, makeParam);
        reportData.addFile(file.getCanonicalPath(), true, false);
        this.f98269g.reportFile(reportData, this.f98270h + this.f98269g.getMD5Params(reportData), null);
        return true;
    }

    private void c(Context context, String str) {
        String str2 = context.getFilesDir().getAbsolutePath() + "/bugly_upload_file";
        String str3 = context.getFilesDir().getAbsolutePath() + "/bugly_upload_zip";
        File file = new File(str3);
        b(str2, str3);
        try {
            if (file.listFiles() == null || file.listFiles().length <= 0) {
                return;
            }
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                int indexOf = name.indexOf("%");
                if (indexOf > 0) {
                    String substring = name.substring(0, indexOf);
                    String substring2 = name.substring(indexOf + 1, name.length() - 4);
                    if (substring2.equals(str) && a(file2, substring, "state_file", substring2)) {
                        av.a("Successfully upload process and thread record zip file, identify is: ".concat(String.valueOf(str)), new Object[0]);
                        FileUtil.deleteFile(file2);
                    }
                } else {
                    FileUtil.deleteFile(file2);
                    return;
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    private String a(String str, String str2) {
        JSONObject jSONObject;
        try {
            if (this.f98267e != null && (jSONObject = this.f98266d) != null) {
                if (str != null && str2 != null) {
                    jSONObject.put(ReportDataBuilder.KEY_BASE_TYPE, str);
                    this.f98266d.put("sub_type", str2);
                }
                SampleUpload sampleUpload = new SampleUpload(this.f98267e, this.f98266d);
                sampleUpload.request();
                JSONObject responseJson = sampleUpload.getResponseJson();
                if (responseJson != null && responseJson.has("code") && responseJson.getInt("code") == 0 && responseJson.has("token")) {
                    return responseJson.getString("token");
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, ai.a(this.f98263a).f());
            jSONObject.put("app_version", ai.a(this.f98263a).f98032t);
            jSONObject.put("sdk_version", ai.a(this.f98263a).f98020h);
            return jSONObject;
        } catch (Throwable th5) {
            av.b(th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length > 10 ? listFiles.length - 10 : 0;
        long currentTimeMillis = System.currentTimeMillis();
        aw.a(listFiles);
        for (File file2 : listFiles) {
            if (length > 0) {
                FileUtil.deleteFile(file2);
                length--;
            } else if (currentTimeMillis - file2.lastModified() > 604800000) {
                FileUtil.deleteFile(file2);
            }
        }
    }

    private static void b(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists() || file.listFiles() == null || file.listFiles().length <= 0) {
                return;
            }
            if (!file2.exists()) {
                file.mkdirs();
            }
            for (File file3 : file.listFiles()) {
                String str3 = str2 + File.separator + file3.getName() + ".zip";
                if (FileUtil.zipFiles(file3.getCanonicalPath(), str3, false)) {
                    FileUtil.deleteFile(file3);
                    File file4 = new File(str3);
                    if (file4.length() > 10485760) {
                        file4.delete();
                    }
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            a(file);
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    public static String a(Context context, String str, String str2) {
        return context.getFilesDir().getAbsolutePath() + "/bugly_upload_file" + File.separator + str + "%" + str2;
    }

    public final void a(Context context, String str) {
        c(context, str);
        b(context, str);
        e(context, str);
        d(context, str);
    }
}
