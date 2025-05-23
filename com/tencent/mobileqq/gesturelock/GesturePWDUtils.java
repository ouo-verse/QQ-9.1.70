package com.tencent.mobileqq.gesturelock;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class GesturePWDUtils extends BaseGesturePWDUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f213636a = 0;

    public GesturePWDUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String patternToString(List<LockPatternView.a> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i3 = 0; i3 < size; i3++) {
            LockPatternView.a aVar = list.get(i3);
            bArr[i3] = (byte) ((aVar.c() * 3) + aVar.b());
        }
        return Arrays.toString(bArr);
    }

    public static void setAppForground(Context context, boolean z16) {
        DBFixManager dBFixManager;
        BaseGesturePWDUtil.setAppForground(context, z16);
        if (z16) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime instanceof QQAppInterface) && (dBFixManager = (DBFixManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.DB_FIX_MANAGER)) != null) {
                dBFixManager.c(context);
            }
        }
    }

    public static void setGesturePWDState(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.util", 2, "setGesturePWDState.uin=" + str + ",state=" + i3);
        }
        SharedPreferences.Editor edit = BaseGesturePWDUtil.getSharedPreferences(context).edit();
        edit.putInt("gesturepassword_gesture_state" + str, i3);
        if (edit.commit() && i3 == 2) {
            QBaseActivity.isUnLockSuccess = true;
        }
    }
}
