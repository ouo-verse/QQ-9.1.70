package com.tencent.mobileqq.filemanager.fileview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsReaderView;
import cooperation.qzone.report.retention.RetentionReport;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class LocalTbsViewManager {

    /* renamed from: h, reason: collision with root package name */
    private static LocalTbsViewManager f208077h;

    /* renamed from: a, reason: collision with root package name */
    private TbsReaderView f208078a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f208079b = -1;

    /* renamed from: c, reason: collision with root package name */
    private TbsReaderView f208080c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f208081d = false;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, String> f208082e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f208083f = false;

    /* renamed from: g, reason: collision with root package name */
    private e f208084g;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements TbsReaderView.ReaderCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f208088a;

        a(e eVar) {
            this.f208088a = eVar;
        }

        @Override // com.tencent.tbs.reader.TbsReaderView.ReaderCallback
        public void onCallBackAction(Integer num, Object obj, Object obj2) {
            if (QLog.isColorLevel()) {
                QLog.i("LocalTbsViewManager<FileAssistant>", 1, "recv actionType[" + num + "]");
            }
            if (num.intValue() == 5012) {
                int intValue = ((Integer) obj).intValue();
                if (QLog.isColorLevel()) {
                    QLog.i("LocalTbsViewManager<FileAssistant>", 1, "err Code[" + intValue + "]");
                }
                if (intValue == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("zivonchen", 2, "canOpenFile return ok 1-------");
                    }
                    e eVar = this.f208088a;
                    if (eVar != null) {
                        eVar.c(true);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("zivonchen", 2, "canOpenFile return ok 2-------");
                }
                e eVar2 = this.f208088a;
                if (eVar2 != null) {
                    eVar2.c(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends TBSOneCallback<File> {
        b() {
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCompleted(File file) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download complete.");
            LocalTbsViewManager.this.r();
            ReportController.o(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 1, 0, "", "", "", "");
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onError(int i3, String str) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download error. code[" + i3 + "] msg[" + str + "]");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(i3);
            ReportController.o(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 2, 0, sb5.toString(), "", "", "");
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onProgressChanged(int i3, int i16) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs progress: oldProgress[" + i3 + "] newProgress[" + i16 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements ITbsReaderCallback {
        c() {
        }

        @Override // com.tencent.tbs.reader.ITbsReaderCallback
        public void onCallBackAction(Integer num, Object obj, Object obj2) {
            boolean z16 = true;
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "initTbsReaderEntry: eventType[" + num + "] code[" + obj.toString() + "]");
            Integer num2 = (Integer) obj;
            e eVar = LocalTbsViewManager.this.f208084g;
            LocalTbsViewManager.this.f208084g = null;
            if (eVar != null) {
                if (num2.intValue() != 0) {
                    z16 = false;
                }
                eVar.c(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f208092d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f208093e;

        d(int i3, Activity activity) {
            this.f208092d = i3;
            this.f208093e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f208092d == 5018) {
                Display defaultDisplay = this.f208093e.getWindowManager().getDefaultDisplay();
                if (defaultDisplay.getWidth() > defaultDisplay.getHeight()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    this.f208093e.setRequestedOrientation(0);
                } else {
                    this.f208093e.setRequestedOrientation(1);
                }
            } else {
                LocalTbsViewManager.this.f208078a.doCommand(Integer.valueOf(this.f208092d), null, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        void a(String str, Drawable drawable, Drawable drawable2, View.OnClickListener onClickListener);

        void b(boolean z16);

        void c(boolean z16);

        void d(View view);

        View e();

        void f();

        void g(boolean z16);

        boolean h();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements TbsReaderView.ReaderCallback {

        /* renamed from: a, reason: collision with root package name */
        private final e f208095a;

        /* renamed from: b, reason: collision with root package name */
        private final Activity f208096b;

        /* renamed from: c, reason: collision with root package name */
        private final String f208097c;

        public f(e eVar, Activity activity, String str) {
            this.f208095a = eVar;
            this.f208096b = activity;
            this.f208097c = str;
        }

        public void a(Object obj, String str, int i3) {
            if (obj != null && (obj instanceof Bundle)) {
                ((Bundle) obj).putInt(str, i3);
            }
        }

        public void b(Object obj, String str, boolean z16) {
            if (obj != null && (obj instanceof Bundle)) {
                ((Bundle) obj).putBoolean(str, z16);
            }
        }

        @Override // com.tencent.tbs.reader.TbsReaderView.ReaderCallback
        public void onCallBackAction(Integer num, Object obj, Object obj2) {
            int intValue = num.intValue();
            if (intValue != 12) {
                boolean z16 = true;
                if (intValue != 19) {
                    if (intValue != 5000) {
                        if (intValue != 5012) {
                            if (intValue != 5045) {
                                if (intValue != 5024) {
                                    if (intValue == 5025) {
                                        LocalTbsViewManager.this.x(false, false);
                                    }
                                } else {
                                    e eVar = this.f208095a;
                                    if (eVar != null) {
                                        a(obj2, "is_bar_show", !eVar.h() ? 1 : 0);
                                    }
                                }
                            } else {
                                a(obj2, "TitleHeight", (int) this.f208096b.getResources().getDimension(R.dimen.title_bar_height));
                            }
                        } else {
                            LocalTbsViewManager.this.p(obj, this.f208097c);
                        }
                    } else {
                        b(obj2, "is_bar_animating", false);
                    }
                } else if (obj != null && (obj instanceof Integer)) {
                    LocalTbsViewManager localTbsViewManager = LocalTbsViewManager.this;
                    if (((Integer) obj).intValue() != 0) {
                        z16 = false;
                    }
                    localTbsViewManager.x(false, z16);
                }
            } else {
                LocalTbsViewManager.this.o(obj, this.f208096b, this.f208095a);
            }
            LocalTbsViewManager.this.n(num.intValue(), this.f208095a);
            if (num.intValue() == 6001) {
                LocalTbsViewManager.this.m(this.f208096b, obj, obj2, this.f208097c, this.f208095a);
            }
        }
    }

    private void j(Context context, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("big_brother_source_key", "biz_src_jc_file");
        Bundle bundle3 = new Bundle();
        bundle3.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, context.getString(R.string.cm9));
        bundle3.putString("big_brother_source_key", "biz_src_jc_file");
        bundle3.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_jc_file");
        bundle3.putBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA, bundle2);
        IUniformDownloadMgr iUniformDownloadMgr = (IUniformDownloadMgr) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IUniformDownloadMgr.class, "all");
        if (iUniformDownloadMgr.getApp() == null) {
            Intent intent = new Intent(IUniformDownloadMgr.UNIDOWNLOAD_BORDCAST);
            intent.putExtra("param", bundle3);
            intent.putExtra("url", str);
            context.sendBroadcast(intent);
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "app is null try sendBroadcast!");
            return;
        }
        iUniformDownloadMgr.startDownloadNoSzie(str, bundle3);
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "downloadQQBrowser:" + str);
    }

    public static LocalTbsViewManager k() {
        if (f208077h == null) {
            f208077h = new LocalTbsViewManager();
        }
        return f208077h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        final c cVar = new c();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.4
            @Override // java.lang.Runnable
            public void run() {
                ReaderEngine.getInstance().initReaderEntryAsync(BaseApplication.getContext(), cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z16, boolean z17) {
        int i3;
        if (z16) {
            ReportController.o(null, "dc00898", "", "", "0X800B00B", "0X800B00B", 0, 0, "", "", "", "");
            return;
        }
        if (z17) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800B00C", "0X800B00C", i3, 0, "", "", "", "");
    }

    public void f(Object obj, e eVar) {
        View e16 = eVar.e();
        if ((obj instanceof ViewGroup) && (e16 instanceof View)) {
            ((ViewGroup) obj).addView(e16);
        }
    }

    public boolean g(Activity activity, String str, e eVar, boolean z16) {
        if (!q(true)) {
            QQToast.makeText(activity, R.string.f187693uo, 0).show();
            this.f208084g = eVar;
            return false;
        }
        if (this.f208080c != null) {
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "canOpenFile return 2-------");
            }
            this.f208080c.onStop();
            this.f208080c = null;
        }
        if (TextUtils.isEmpty(str)) {
            if (eVar != null) {
                eVar.c(false);
            }
            return false;
        }
        TbsReaderView tbsReaderView = new TbsReaderView(activity, new a(eVar));
        String j3 = q.j(str);
        if (j3.startsWith(".")) {
            j3 = j3.replaceFirst(".", "");
        }
        if (!tbsReaderView.preOpen(j3, !z16)) {
            tbsReaderView.onStop();
            if (eVar != null) {
                eVar.c(false);
            }
            if (QLog.isColorLevel()) {
                QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file false!");
            }
            return false;
        }
        if (z16 && eVar != null) {
            eVar.c(true);
        }
        if (QLog.isColorLevel()) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file true! wait callback!");
        }
        this.f208080c = tbsReaderView;
        return true;
    }

    public void h(int i3, e eVar) {
        if (i3 != 5001) {
            if (i3 == 5002) {
                eVar.g(false);
                return;
            }
            return;
        }
        eVar.g(true);
    }

    public void i(Context context, Bundle bundle, String str) {
        if (bundle == null) {
            QLog.e("LocalTbsViewManager<FileAssistant>", 1, "downloadQQBrowser params null!");
            return;
        }
        this.f208082e.put("stat_download_start", bundle.getString("stat_download_start", ""));
        this.f208082e.put("stat_download_downloading", bundle.getString("stat_download_downloading", ""));
        this.f208082e.put("stat_download_success", bundle.getString("stat_download_success", ""));
        this.f208082e.put("stat_download_failed", bundle.getString("stat_download_failed", ""));
        this.f208082e.put("stat_download_installed_success", bundle.getString("stat_download_installed_success", ""));
        this.f208082e.put("stat_open_qb_success", bundle.getString("stat_open_qb_success", ""));
        String string = bundle.getString("download_url", "");
        if (((IUniformDownloadMgr) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IUniformDownloadMgr.class, "")).isExistedDownloadOfUrl(string)) {
            QLog.w("LocalTbsViewManager<FileAssistant>", 1, "downloadQQBrowser isExistedDownloadOfUrl show toast!");
            QQToast.makeText(context, 0, R.string.f187703up, 0).show();
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(IUniformDownloadMgr.OPEN_WITH_QQBROWSER, str);
        bundle2.putBoolean("tbs_new_report", true);
        j(context, string, bundle2);
        w("stat_download_start");
    }

    public Bundle l(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("filePath", str);
        String defaultRecvPath = lc1.b.a().getDefaultRecvPath();
        File file = new File(defaultRecvPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (QLog.isColorLevel()) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "getTbsFileReaderOpenParams: barSwitch[" + this.f208081d + "]");
        }
        bundle.putString("tempPath", defaultRecvPath);
        bundle.putBoolean(TbsReaderView.FILE_READER_HIDE_TOOLBAR, !this.f208081d);
        bundle.putInt(TbsReaderView.FILE_READER_DOWNLOAD_TYPE, 1);
        bundle.putString("reader_tokenid", "Y29tLnRlbmNlbnQubW9iaWxlcXE=");
        bundle.putString("reader_pkgname", "com.tencent.mobileqq");
        bundle.putBoolean("file_reader_click_action_disable", true);
        bundle.putInt("style", 2);
        bundle.putInt(TbsReaderView.FILE_READER_BG_CONTENT_COLOR, -1);
        bundle.putBoolean("file_reader_add_view_to_toolbar", this.f208083f);
        bundle.putString("big_brother_source_key", "biz_src_jc_file");
        bundle.putBoolean("file_is_night_theme", QQTheme.isNowThemeIsNight());
        return bundle;
    }

    public void m(Context context, Object obj, Object obj2, String str, e eVar) {
        if (obj != null && (obj instanceof Bundle)) {
            Bundle bundle = (Bundle) obj;
            int i3 = bundle.getInt("typeId", -1);
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "handleTbsReaderEvent: actionType[" + i3 + "]");
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 7) {
                                    f(obj2, eVar);
                                    return;
                                }
                                return;
                            }
                            v(context, bundle);
                            return;
                        }
                        ReportController.o(null, "dc00898", "", "", "0X800AF75", "0X800AF75", 0, 0, "", "", "", "");
                        i(context, bundle, str);
                        return;
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800AF74", "0X800AF74", 0, 0, "", "", "", "");
                    return;
                }
                ReportController.o(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 1, 0, "", "", "", "");
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800AF71", "0X800AF71", 0, 0, "", "", "", "");
        }
    }

    public void n(final int i3, final e eVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h(i3, eVar);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.6
                @Override // java.lang.Runnable
                public void run() {
                    LocalTbsViewManager.this.h(i3, eVar);
                }
            });
        }
    }

    public void o(Object obj, Activity activity, e eVar) {
        if (obj == null) {
            return;
        }
        int i3 = ((Bundle) obj).getInt(RetentionReport.FUNCTIONID);
        eVar.a(TbsReaderView.getResString(activity, i3), TbsReaderView.getResDrawable(activity, i3 + 1), TbsReaderView.getResDrawable(activity, i3 + 2), new d(i3, activity));
    }

    public void p(Object obj, String str) {
        boolean z16;
        if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
            return;
        }
        if (this.f208078a.openFile(l(str)) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        x(true, z16);
    }

    public boolean q(boolean z16) {
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine init. isForeground[" + z16 + "]");
        b bVar = new b();
        if (ReaderEngine.getInstance().isEngineLoaded()) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine has loaded in memory.");
            r();
            return true;
        }
        boolean fileEnginePreLoad = ReaderEngine.getInstance().fileEnginePreLoad(BaseApplication.getContext(), bVar, z16);
        if (fileEnginePreLoad) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine had downloaded.");
            r();
        } else {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "tbs reader engine not download.");
            ReportController.o(null, "dc00898", "", "", "0X800B009", "0X800B009", 0, 0, "", "", "", "");
        }
        return fileEnginePreLoad;
    }

    public boolean s() {
        if (ReaderEngine.getInstance().getVersionCode() >= 5060010) {
            return true;
        }
        return false;
    }

    public void t(Activity activity) {
        int hashCode = activity.hashCode();
        this.f208084g = null;
        if (QLog.isDevelopLevel()) {
            QLog.d("LocalTbsViewManager<FileAssistant>", 4, "LocalTbsViewManager destroy hashCode[" + this.f208079b + "],activity[" + hashCode + "]");
        }
        if (this.f208079b != hashCode) {
            return;
        }
        TbsReaderView tbsReaderView = this.f208080c;
        if (tbsReaderView != null) {
            tbsReaderView.onStop();
            this.f208080c = null;
        }
        TbsReaderView tbsReaderView2 = this.f208078a;
        if (tbsReaderView2 != null) {
            tbsReaderView2.onStop();
            this.f208078a = null;
        }
    }

    public TbsReaderView u(Activity activity, String str, e eVar) {
        if (this.f208078a != null && activity.hashCode() == this.f208079b) {
            FilePreviewDataReporter.f209177a.d(str);
            return this.f208078a;
        }
        if (!q.f(str)) {
            return null;
        }
        TbsReaderView tbsReaderView = this.f208080c;
        if (tbsReaderView != null) {
            tbsReaderView.onStop();
            this.f208080c = null;
        }
        TbsReaderView tbsReaderView2 = this.f208078a;
        if (tbsReaderView2 != null) {
            tbsReaderView2.onStop();
            this.f208078a = null;
        }
        QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: new TbsReaderView");
        this.f208078a = new TbsReaderView(activity, new f(eVar, activity, str));
        QLog.w("LocalTbsViewManager<FileAssistant>", 4, "initVarView: TbsReaderView openFile");
        this.f208078a.setBackgroundColor(-1);
        String j3 = q.j(str);
        if (j3.startsWith(".")) {
            j3 = j3.replaceFirst(".", "");
        }
        boolean z16 = false;
        if (this.f208078a.preOpen(j3, false)) {
            int openFile = this.f208078a.openFile(l(str));
            if (openFile == 0) {
                z16 = true;
            }
            x(true, z16);
            if (openFile == 0) {
                FilePreviewDataReporter.f209177a.d(str);
            }
            this.f208079b = activity.hashCode();
            return this.f208078a;
        }
        this.f208078a.onStop();
        this.f208078a = null;
        return null;
    }

    public void v(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
        Intent intent = (Intent) bundle.getParcelable("file_open_intent");
        if (intent != null) {
            intent.putExtra("big_brother_source_key", "biz_src_jc_file");
            context.startActivity(intent);
        }
    }

    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.f208082e.get(str);
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "reportQQBrowserDownloadEvent: reportType[" + str + "]");
        if (this.f208078a != null && !TextUtils.isEmpty(str2)) {
            this.f208078a.userStatistics(str2);
        }
        if (str.equals("stat_download_success")) {
            ReportController.o(null, "dc00898", "", "", "0X800AF76", "0X800AF76", 0, 0, "", "", "", "");
        } else if (str.equals("stat_open_qb_success")) {
            ReportController.o(null, "dc00898", "", "", "0X800AF73", "0X800AF73", 0, 0, "", "", "", "");
        }
    }

    public void y(boolean z16) {
        this.f208083f = z16;
    }

    public void z(boolean z16) {
        this.f208081d = z16;
    }
}
