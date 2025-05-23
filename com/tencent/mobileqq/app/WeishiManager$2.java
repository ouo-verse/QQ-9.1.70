package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
class WeishiManager$2 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Map C;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f195224d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f195225e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ QQMessageFacade f195226f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f195227h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f195228i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ String f195229m;
    final /* synthetic */ dv this$0;

    @Override // java.lang.Runnable
    public void run() {
        QQAppInterface qQAppInterface;
        QQAppInterface qQAppInterface2;
        QQAppInterface qQAppInterface3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        MessageRecord h16 = this.this$0.h(this.f195224d, this.f195225e);
        if (h16 != null) {
            QQMessageFacade qQMessageFacade = this.f195226f;
            qQAppInterface3 = this.this$0.f195512d;
            qQMessageFacade.c(h16, qQAppInterface3.getCurrentUin());
        }
        ((IWSManager) QRoute.api(IWSManager.class)).setWeishiLastFeedId(this.f195227h);
        QLog.i("WSAioLog", 2, "saveLastFeedInfo feedId:" + this.f195227h + ", title:" + this.f195224d);
        try {
            qQAppInterface = this.this$0.f195512d;
            long parseLong = Long.parseLong(qQAppInterface.getCurrentAccountUin());
            qQAppInterface2 = this.this$0.f195512d;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultPreference(qQAppInterface2.getApplication(), parseLong).edit();
            edit.putString("key_weishi_newest_feed_id", this.f195227h);
            edit.putString("key_weishi_newest_feed_desc", this.f195224d);
            edit.putInt("key_weishi_newest_feed_type", this.f195228i);
            edit.putLong("key_weishi_newest_feed_time", this.f195225e);
            edit.putString("key_weishi_newest_feed_from", this.f195229m);
            edit.apply();
            if (this.C.get(1) == null) {
                QLog.i("weishi-report", 2, "save map passback error, no key 1!");
                FileUtils.deleteFile(this.this$0.f());
            } else {
                QLog.i("weishi-report", 2, "save map saveSuccess : " + FileUtils.writeFile((byte[]) this.C.get(1), this.this$0.f(), false));
            }
        } catch (Exception e16) {
            QLog.d("WeishiManager", 2, e16.getMessage(), e16);
        }
    }
}
