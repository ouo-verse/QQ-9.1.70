package com.tencent.mobileqq.app;

import UserGrowth.stSimpleMetaFeed;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dv implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195512d;

    public dv(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195512d = qQAppInterface;
        }
    }

    private void b(MessageRecord messageRecord, String str, long j3) {
        messageRecord.issend = 1;
        messageRecord.isread = true;
        String str2 = AppConstants.WEISHI_UIN;
        messageRecord.frienduin = str2;
        messageRecord.senderuin = str2;
        messageRecord.istroop = 1008;
        messageRecord.f203106msg = str;
        messageRecord.time = j3;
        messageRecord.createMessageUniseq();
    }

    public static void g(stSimpleMetaFeed stsimplemetafeed) {
        Map<Integer, byte[]> map;
        QQAppInterface qQAppInterface;
        dv dvVar;
        byte[] readFile;
        if (stsimplemetafeed != null && (map = stsimplemetafeed.map_pass_back) != null && map.size() == 0 && (qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null && (dvVar = (dv) qQAppInterface.getManager(QQManagerFactory.WEISHI_MANAGER)) != null && (readFile = FileUtils.readFile(dvVar.f())) != null) {
            QLog.i("weishi-report", 2, "load map passback length:" + readFile.length);
            stsimplemetafeed.map_pass_back.put(1, readFile);
            stsimplemetafeed.map_ext.put("recmd_feed_key", new Gson().toJson(stsimplemetafeed.map_pass_back));
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        try {
            try {
                return PreferenceManager.getDefaultPreference(this.f195512d.getApplication(), Long.parseLong(this.f195512d.getCurrentAccountUin())).getString("key_weishi_newest_feed_desc", "");
            } catch (Exception e16) {
                QLog.d("WeishiManager", 2, e16.getMessage(), e16);
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        try {
            try {
                return PreferenceManager.getDefaultPreference(this.f195512d.getApplication(), Long.parseLong(this.f195512d.getCurrentAccountUin())).getString("key_weishi_newest_feed_id", "");
            } catch (Exception e16) {
                QLog.d("WeishiManager", 2, e16.getMessage(), e16);
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        try {
            try {
                return PreferenceManager.getDefaultPreference(this.f195512d.getApplication(), Long.parseLong(this.f195512d.getCurrentAccountUin())).getInt("key_weishi_newest_feed_type", 0);
            } catch (Exception e16) {
                QLog.d("WeishiManager", 2, e16.getMessage(), e16);
                return 0;
            }
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_mappassback";
    }

    public MessageRecord h(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3));
        }
        if (this.f195512d == null) {
            return null;
        }
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1000);
        d16.selfuin = this.f195512d.getCurrentAccountUin();
        b(d16, str, j3);
        return d16;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f195512d = null;
        }
    }
}
