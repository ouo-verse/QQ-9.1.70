package l04;

import android.app.Application;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f413612a;

    /* renamed from: b, reason: collision with root package name */
    private int f413613b;

    /* renamed from: c, reason: collision with root package name */
    private int f413614c;

    /* renamed from: d, reason: collision with root package name */
    private String f413615d;

    public c() {
        b();
        c();
    }

    private JSONArray a(List<n04.b> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (n04.b bVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", bVar.f417944l);
                jSONObject.put("activity_name", bVar.f417933a);
                jSONObject.put("bitmap_width", bVar.f417939g);
                jSONObject.put("bitmap_height", bVar.f417940h);
                jSONObject.put("view_width", bVar.f417937e);
                jSONObject.put("view_height", bVar.f417938f);
                jSONObject.put("view_chain", bVar.f417935c);
                jSONObject.put("view_name", bVar.f417934b);
                jSONObject.put("view_tag", bVar.f417936d);
                jSONObject.put("show_type", bVar.f417941i);
                jSONObject.put("allocated_byte_size", bVar.f417942j);
                jSONArray.mo162put(jSONObject);
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_BigBitmap_Reporter", th5);
        }
        return jSONArray;
    }

    private void b() {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (AndroidVersion.isOverJellyBeanMr1()) {
                DisplayManager displayManager = (DisplayManager) BaseInfo.app.getSystemService("display");
                if (displayManager != null) {
                    displayManager.getDisplay(0).getRealMetrics(displayMetrics);
                }
            } else {
                WindowManager windowManager = (WindowManager) BaseInfo.app.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                }
            }
            this.f413613b = displayMetrics.widthPixels;
            this.f413614c = displayMetrics.heightPixels;
            this.f413612a = displayMetrics.densityDpi;
        } catch (Throwable unused) {
            this.f413613b = -1;
            this.f413614c = -1;
            this.f413612a = -1;
        }
    }

    private void c() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(FileUtil.j());
        String str = File.separator;
        sb5.append(str);
        sb5.append("dumpfile");
        sb5.append(str);
        sb5.append(BuglyMonitorName.MEMORY_BIG_BITMAP);
        sb5.append(str);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f413615d = new File(file, "BitmapOverDecode.json").getAbsolutePath();
    }

    private String e(List<n04.b> list) {
        String canonicalPath;
        try {
            synchronized (this) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bitmap_over_decode", a(list));
                File file = new File(this.f413615d);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(jSONObject.toString().getBytes());
                fileOutputStream.close();
                File file2 = new File(file.getParent(), System.currentTimeMillis() + "_big_bitmap.zip");
                ArrayList arrayList = new ArrayList();
                arrayList.add(file.getPath());
                FileUtil.l(arrayList, file2.getAbsolutePath(), false);
                canonicalPath = file2.getCanonicalPath();
            }
            return canonicalPath;
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_BigBitmap_Reporter", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReportData d(List<n04.b> list) {
        boolean z16;
        ReportStrategy.UploadStrategy uploadStrategy;
        try {
            if (!list.isEmpty()) {
                JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
                makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
                makeAttributes.put("stage", com.tencent.rmonitor.common.lifecycle.a.f());
                makeAttributes.put(ReportDataBuilder.KEY_64_BIT_FLAG, BaseInfo.is64Bit);
                makeAttributes.put("width_pixels", this.f413613b);
                makeAttributes.put("height_pixels", this.f413614c);
                makeAttributes.put("density_dpi", this.f413612a);
                makeAttributes.put("threshold", a.a());
                JSONObject jSONObject = new JSONObject();
                if (list.size() <= 100) {
                    jSONObject.put("bitmap_over_decode", a(list));
                    z16 = true;
                } else {
                    makeAttributes.put("fileObj", e(list));
                    jSONObject.put("json_file_path", "BitmapOverDecode.json");
                    z16 = false;
                }
                Application application = BaseInfo.app;
                UserMeta userMeta = BaseInfo.userMeta;
                JSONObject makeParam = ReportDataBuilder.makeParam(application, "memory", BuglyMonitorName.MEMORY_BIG_BITMAP, userMeta);
                makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
                makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
                ReportData reportData = new ReportData(userMeta.uin, 1, "BigBitmap", makeParam);
                ReportStrategy reportStrategy = reportData.getReportStrategy();
                if (z16) {
                    uploadStrategy = ReportStrategy.UploadStrategy.UPLOAD_WIFI;
                } else {
                    uploadStrategy = ReportStrategy.UploadStrategy.UPLOAD_NEXT_LAUNCH;
                }
                reportStrategy.setUploadStrategy(uploadStrategy);
                s04.b.j().a(false, reportData);
                s04.b.j().f(reportData);
                reportData.setShouldRecordLinkData(true);
                ReporterMachine.f365411g.reportNow(reportData, null);
                return reportData;
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_BigBitmap_Reporter", th5);
        }
        return null;
    }
}
