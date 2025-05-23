package com.tencent.mobileqq.msgbackup.msgprocess;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected Map<String, String> f251271b;

    /* renamed from: c, reason: collision with root package name */
    protected MsgBackupResEntity f251272c;

    public c(MsgBackupResEntity msgBackupResEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgBackupResEntity);
        } else {
            this.f251271b = h(msgBackupResEntity.extraDataStr);
            this.f251272c = msgBackupResEntity;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int e() {
        return AppConstants.SDCARD_PATH.length();
    }

    public static HashMap<String, String> h(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public abstract String c();

    public abstract com.tencent.mobileqq.msgbackup.controller.k d();

    public abstract String f();

    protected void g(String str, String str2) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int quickMove = FileUtils.quickMove(str, str2);
            File file = new File(str2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("restore,quickMove: ");
            sb5.append(str);
            sb5.append(" to ");
            sb5.append(str2);
            sb5.append(" status:");
            sb5.append(quickMove);
            sb5.append(" size:");
            if (file.exists()) {
                obj = Long.valueOf(file.length());
            } else {
                obj = "-1";
            }
            sb5.append(obj);
            QLog.d("MsgBackup", 1, sb5.toString());
            return;
        }
        b("importFile null error ");
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        MsgBackupResEntity msgBackupResEntity = this.f251272c;
        String c16 = c();
        String f16 = f();
        QLog.d("MsgBackup", 1, "resTempPath = " + f16 + " ,resRealPath = " + c16 + " ,import resEntity:" + msgBackupResEntity.toLogString());
        try {
            g(f16, c16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
