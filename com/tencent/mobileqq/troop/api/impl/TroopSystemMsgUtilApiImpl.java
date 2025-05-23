package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSystemMsgUtilApiImpl implements ITroopSystemMsgUtilApi {
    static IPatchRedirector $redirector_;

    public TroopSystemMsgUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public String getTroopAnswerFromSP(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) str);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
        String str2 = "troop_answer_" + str;
        if (!sharedPreferences.contains(str2)) {
            return null;
        }
        return sharedPreferences.getString(str2, null);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public long getTroopFlagExtFromSP(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str)).longValue();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
        String str2 = "troop_flagEx_" + str;
        if (!sharedPreferences.contains(str2)) {
            return 0L;
        }
        return sharedPreferences.getLong(str2, 0L);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public String getTroopNameFromSP(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
        String str2 = "troop_name_" + str;
        if (!sharedPreferences.contains(str2)) {
            return null;
        }
        return sharedPreferences.getString(str2, null);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public String getTroopQuestionFromSP(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) str);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
        String str2 = "troop_question_" + str;
        if (!sharedPreferences.contains(str2)) {
            return null;
        }
        return sharedPreferences.getString(str2, null);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public void saveTroopAnswerToSP(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, str, str2);
            return;
        }
        context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit().putString("troop_answer_" + str, str2).commit();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public void saveTroopFlagExToSP(Context context, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, Long.valueOf(j3));
            return;
        }
        if (context == null) {
            context = BaseApplication.getContext();
        }
        context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit().putLong("troop_flagEx_" + str, j3).commit();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public void saveTroopNameToSP(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, str, str2);
            return;
        }
        context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit().putString("troop_name_" + str, str2).commit();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public void saveTroopOptionToSP(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, str, Integer.valueOf(i3));
            return;
        }
        context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit().putInt("troop_option_" + str, i3).commit();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
    public void saveTroopQuestionToSP(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, str2);
            return;
        }
        context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit().putString("troop_question_" + str, str2).commit();
    }
}
