package com.tencent.mobileqq.config.business.qfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFileManagerReporter;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;
import qb1.c;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QfileFileAssistantTipsConfigBean implements rb1.a<String>, qb1.c {

    /* renamed from: d, reason: collision with root package name */
    public String f202730d = "{}";

    /* renamed from: e, reason: collision with root package name */
    private boolean f202731e = false;

    /* renamed from: f, reason: collision with root package name */
    private String f202732f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f202733h = "";

    /* renamed from: i, reason: collision with root package name */
    private int f202734i = 5;

    /* renamed from: m, reason: collision with root package name */
    private int f202735m = 30;
    private int C = 10;
    private String D = "";
    private String E = "";
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private long I = 0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements c.a {
        a() {
        }

        @Override // qb1.c.a
        public void jump(Context context) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openQQBrowserWithoutAD(context, QfileFileAssistantTipsConfigBean.this.E);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements c.a {
        b() {
        }

        @Override // qb1.c.a
        public void jump(Context context) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).doJumpAction(context, QfileFileAssistantTipsConfigBean.this.E);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements c.a {
        c() {
        }

        @Override // qb1.c.a
        public void jump(Context context) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction(QfileFileAssistantTipsConfigBean.this.E);
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements c.a {
        d() {
        }

        @Override // qb1.c.a
        public void jump(Context context) {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openLocalFileBrowserActivity(context, QfileFileAssistantTipsConfigBean.this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 == null) {
            QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
            return;
        }
        SharedPreferences sharedPreferences = A0.getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + A0.getCurrentUin(), 0);
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("qfile_file_assistant_tips", "{}"));
            this.G += this.f202734i;
            this.F = 9999;
            jSONObject.put("local_day_times", 9999);
            jSONObject.put("local_max_times", this.G);
            String jSONObject2 = jSONObject.toString();
            if (QLog.isDebugVersion()) {
                QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, jSONObject2);
            }
            sharedPreferences.edit().putString("qfile_file_assistant_tips", jSONObject2).apply();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 == null) {
            QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
            return;
        }
        ((IFileManagerReporter) QRoute.api(IFileManagerReporter.class)).addData("0X800AD02");
        SharedPreferences sharedPreferences = A0.getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + A0.getCurrentUin(), 0);
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("qfile_file_assistant_tips", "{}"));
            int i3 = this.H + 1;
            this.H = i3;
            jSONObject.put("local_click_times", i3);
            String jSONObject2 = jSONObject.toString();
            if (QLog.isDebugVersion()) {
                QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, jSONObject2);
            }
            sharedPreferences.edit().putString("qfile_file_assistant_tips", jSONObject2).apply();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 == null) {
            QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
            return;
        }
        ((IFileManagerReporter) QRoute.api(IFileManagerReporter.class)).addData("0X800AD01");
        SharedPreferences sharedPreferences = A0.getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + A0.getCurrentUin(), 0);
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString("qfile_file_assistant_tips", "{}"));
            this.F++;
            this.G++;
            jSONObject.put("local_day_last_time", com.tencent.mobileqq.service.message.e.K0());
            jSONObject.put("local_day_times", this.F);
            jSONObject.put("local_max_times", this.G);
            String jSONObject2 = jSONObject.toString();
            if (QLog.isDebugVersion()) {
                QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, jSONObject2);
            }
            sharedPreferences.edit().putString("qfile_file_assistant_tips", jSONObject2).apply();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // qb1.c
    public c.a a() {
        if (this.D.equalsIgnoreCase("url")) {
            return new a();
        }
        if (this.D.equalsIgnoreCase(SchemaUtils.SCHEMA_MQQAPI)) {
            return new b();
        }
        if (this.D.equalsIgnoreCase(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM)) {
            return new c();
        }
        if (this.D.equalsIgnoreCase("custom")) {
            return new d();
        }
        return null;
    }

    @Override // qb1.c
    public void b() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.7
            @Override // java.lang.Runnable
            public void run() {
                QfileFileAssistantTipsConfigBean.this.j();
            }
        });
    }

    @Override // qb1.c
    public void c() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.5
            @Override // java.lang.Runnable
            public void run() {
                QfileFileAssistantTipsConfigBean.this.k();
            }
        });
    }

    @Override // qb1.c
    public void d() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.6
            @Override // java.lang.Runnable
            public void run() {
                QfileFileAssistantTipsConfigBean.this.i();
            }
        });
    }

    @Override // qb1.c
    public String getJumpText() {
        return this.f202733h;
    }

    @Override // qb1.c
    public String getTextContent() {
        return this.f202732f;
    }

    @Override // qb1.c
    public boolean isSwitchOn() {
        if (this.H >= this.C) {
            QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.H + " >= mMaxClickTimes:" + this.C);
            this.f202731e = false;
        }
        if (this.F >= this.f202734i) {
            QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.F + " >= mOneDayMaxTimes:" + this.f202734i);
            this.f202731e = false;
        }
        if (this.G >= this.f202735m) {
            QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.G + " >= mMaxTimes:" + this.f202735m);
            this.f202731e = false;
        }
        return this.f202731e;
    }

    @Override // rb1.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        String str2;
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "receiveAllConfigs|type: 606configContent is empty");
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, str);
        }
        this.f202730d = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("local_day_times")) {
                this.F = jSONObject.getInt("local_day_times");
            }
            if (!jSONObject.has("local_day_last_time")) {
                str2 = "url";
            } else {
                this.I = jSONObject.getLong("local_day_last_time");
                str2 = "url";
                if (!QQFileManagerUtilImpl.Z1(this.I * 1000, com.tencent.mobileqq.service.message.e.K0() * 1000, TimeZone.getDefault())) {
                    QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "is not one day, set mLocalDayTims:0");
                    this.F = 0;
                }
            }
            if (jSONObject.has("local_max_times")) {
                this.G = jSONObject.getInt("local_max_times");
            }
            int optInt = jSONObject.optInt("max_count");
            this.f202735m = optInt;
            if (this.G >= optInt) {
                QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.G + " >= mMaxTimes:" + this.f202735m);
                this.f202731e = false;
                return;
            }
            if (jSONObject.has("local_click_times")) {
                this.H = jSONObject.getInt("local_click_times");
            }
            if (this.H >= this.C) {
                this.f202731e = false;
                QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.H + " >= mMaxClickTimes:" + this.C);
                return;
            }
            if (jSONObject.getInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f202731e = z16;
            this.f202732f = jSONObject.getString("txt_content");
            this.f202733h = jSONObject.getString("jump_txt");
            int i3 = jSONObject.getInt("one_day_max");
            this.f202734i = i3;
            if (this.F >= i3) {
                this.f202731e = false;
                QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.F + " >= mOneDayMaxTimes:" + this.f202734i);
                return;
            }
            this.C = jSONObject.getInt("click_max");
            String string = jSONObject.getString("jump_type");
            this.D = string;
            if (string.equalsIgnoreCase(str2)) {
                this.E = new JSONObject(jSONObject.getString(str2)).getString(str2);
                return;
            }
            if (this.D.equalsIgnoreCase(SchemaUtils.SCHEMA_MQQAPI)) {
                this.E = new JSONObject(jSONObject.getString(SchemaUtils.SCHEMA_MQQAPI)).getString(str2);
            } else if (this.D.equalsIgnoreCase("custom")) {
                this.E = new JSONObject(jSONObject.getString("custom")).toString();
            } else if (this.D.equalsIgnoreCase(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM)) {
                this.E = new JSONObject(jSONObject.getString(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM)).getString(str2);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
