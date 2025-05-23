package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class s {
    static IPatchRedirector $redirector_;

    public static void a(Context context, String str, String str2) {
        String str3 = str + str2;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str + "statistic", 0);
        int i3 = sharedPreferences.getInt(str3, 0);
        if (QLog.isColorLevel()) {
            QLog.d("StatisticAssist", 2, str3 + MsgSummary.STR_COLON + i3);
        }
        sharedPreferences.edit().putInt(str3, i3 + 1).commit();
    }

    public static int b(Context context, String str, String str2) {
        return context.getSharedPreferences(str + "statistic", 0).getInt(str + str2, 0);
    }

    public static List<MessageReportData> c(QQAppInterface qQAppInterface) {
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        List query = createEntityManager.query(MessageReportData.class, false, null, null, null, null, null, null);
        createEntityManager.close();
        return query;
    }

    public static void d(QQAppInterface qQAppInterface, Context context, String str) {
        context.getSharedPreferences(str + "statistic", 0).edit().clear().commit();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager.drop(MessageReportData.class);
        createEntityManager.close();
    }
}
