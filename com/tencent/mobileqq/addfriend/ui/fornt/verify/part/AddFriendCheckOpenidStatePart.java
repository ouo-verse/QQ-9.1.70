package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class AddFriendCheckOpenidStatePart extends v implements e.a {
    static IPatchRedirector $redirector_;
    protected QQCustomDialog Q;

    public AddFriendCheckOpenidStatePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.Q = null;
        }
    }

    private void ba() {
        if (this.intent.getIntExtra("k_uin_type", 1) == 3) {
            String stringExtra = this.intent.getStringExtra("is_from_game");
            String stringExtra2 = this.intent.getStringExtra("extra");
            try {
                boolean enableCheckPermission = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).enableCheckPermission();
                if (("true".equals(stringExtra) || enableCheckPermission) && !TextUtils.isEmpty(stringExtra2)) {
                    com.tencent.mobileqq.addfriend.utils.a.a(MobileQQ.sMobileQQ.peekAppRuntime(), getActivity().getApplicationContext(), stringExtra2, this, 1003, null);
                    if (QLog.isColorLevel()) {
                        QLog.d("AddFriendCheckOpenidStatePart", 2, "AddFriend enableCheckPermission = " + enableCheckPermission);
                    }
                }
            } catch (Exception e16) {
                if ("true".equals(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    com.tencent.mobileqq.addfriend.utils.a.a(MobileQQ.sMobileQQ.peekAppRuntime(), getActivity().getApplicationContext(), stringExtra2, this, 1003, null);
                }
                QLog.d("AddFriendCheckOpenidStatePart", 1, "AddFriend loadConfig exception = " + e16);
            }
        }
    }

    private void ca() {
        if (W9()) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendCheckOpenidStatePart.1
            static IPatchRedirector $redirector_;

            /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendCheckOpenidStatePart$1$a */
            /* loaded from: classes10.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else if (i3 == 1) {
                        AddFriendCheckOpenidStatePart.this.Q.cancel();
                        AddFriendCheckOpenidStatePart.this.getActivity().finish();
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendCheckOpenidStatePart.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AddFriendCheckOpenidStatePart addFriendCheckOpenidStatePart = AddFriendCheckOpenidStatePart.this;
                QQCustomDialog qQCustomDialog = addFriendCheckOpenidStatePart.Q;
                if (qQCustomDialog != null) {
                    if (!qQCustomDialog.isShowing()) {
                        AddFriendCheckOpenidStatePart.this.Q.show();
                        return;
                    }
                    return;
                }
                addFriendCheckOpenidStatePart.Q = DialogUtil.createCustomDialog(addFriendCheckOpenidStatePart.getActivity(), 230);
                AddFriendCheckOpenidStatePart.this.Q.setMessage(R.string.f170882m9);
                AddFriendCheckOpenidStatePart.this.Q.setPositiveButton(R.string.f171151ok, new a());
                if (!AddFriendCheckOpenidStatePart.this.Q.isShowing()) {
                    AddFriendCheckOpenidStatePart.this.Q.show();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
        } else {
            super.onPartCreate(activity, bundle);
            ba();
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.e.a
    public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        String str;
        JSONArray jSONArray4;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, jSONObject, Integer.valueOf(i3), bundle);
            return;
        }
        if (i3 == 1003 && jSONObject != null) {
            try {
                int intValue = ((Integer) jSONObject.get("retcode")).intValue();
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("result");
                if (intValue == 0 && jSONObject2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendCheckOpenidStatePart", 2, "checkApiState onResult. retCode = " + intValue + "\n");
                    }
                    JSONObject jSONObject3 = (JSONObject) jSONObject2.get(Constants.Configs.BASICS);
                    String str3 = "msg";
                    String str4 = DTConstants.TAG.API;
                    if (jSONObject3 != null && (jSONArray4 = (JSONArray) jSONObject3.get("datas")) != null) {
                        int i16 = 0;
                        while (i16 < jSONArray4.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray4.get(i16);
                            String str5 = (String) jSONObject4.get("name");
                            int intValue2 = ((Integer) jSONObject4.get("state")).intValue();
                            String str6 = (String) jSONObject4.get(DTConstants.TAG.API);
                            String str7 = (String) jSONObject4.get(str3);
                            JSONArray jSONArray5 = jSONArray4;
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                str2 = str3;
                                sb5.append("checkApiState onResult, basics name = ");
                                sb5.append(str5);
                                sb5.append(" state = ");
                                sb5.append(intValue2);
                                sb5.append(" api = ");
                                sb5.append(str6);
                                sb5.append(" msg = ");
                                sb5.append(str7);
                                sb5.append("\n");
                                QLog.i("AddFriendCheckOpenidStatePart", 2, sb5.toString());
                            } else {
                                str2 = str3;
                            }
                            i16++;
                            jSONArray4 = jSONArray5;
                            str3 = str2;
                        }
                    }
                    String str8 = str3;
                    JSONObject jSONObject5 = (JSONObject) jSONObject2.get("friendlink");
                    if (jSONObject5 != null && (jSONArray3 = (JSONArray) jSONObject5.get("datas")) != null) {
                        int i17 = 0;
                        while (i17 < jSONArray3.length()) {
                            JSONObject jSONObject6 = (JSONObject) jSONArray3.get(i17);
                            String str9 = (String) jSONObject6.get("name");
                            int intValue3 = ((Integer) jSONObject6.get("state")).intValue();
                            String str10 = (String) jSONObject6.get(str4);
                            JSONArray jSONArray6 = jSONArray3;
                            String str11 = str8;
                            String str12 = (String) jSONObject6.get(str11);
                            str8 = str11;
                            if (LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND.equals(str10) && intValue3 != 1) {
                                ca();
                            }
                            if (QLog.isColorLevel()) {
                                StringBuilder sb6 = new StringBuilder();
                                str = str4;
                                sb6.append("checkApiState onResult, friendlink name = ");
                                sb6.append(str9);
                                sb6.append(" state = ");
                                sb6.append(intValue3);
                                sb6.append(" api = ");
                                sb6.append(str10);
                                sb6.append(" msg= ");
                                sb6.append(str12);
                                sb6.append("\n");
                                QLog.i("AddFriendCheckOpenidStatePart", 2, sb6.toString());
                            } else {
                                str = str4;
                            }
                            i17++;
                            jSONArray3 = jSONArray6;
                            str4 = str;
                        }
                    }
                    String str13 = str4;
                    int intValue4 = ((Integer) jSONObject2.get("appid")).intValue();
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendCheckOpenidStatePart", 2, "checkApiState onResult, appid =" + intValue4 + "\n");
                    }
                    JSONObject jSONObject7 = (JSONObject) jSONObject2.get(PreDownloadConstants.DEPARTMENT_QQPAY);
                    if (jSONObject7 != null && (jSONArray = (JSONArray) jSONObject7.get("datas")) != null) {
                        int i18 = 0;
                        while (i18 < jSONArray.length()) {
                            JSONObject jSONObject8 = (JSONObject) jSONArray.get(i18);
                            String str14 = (String) jSONObject8.get("name");
                            int intValue5 = ((Integer) jSONObject8.get("state")).intValue();
                            String str15 = str13;
                            String str16 = (String) jSONObject8.get(str15);
                            String str17 = str8;
                            String str18 = (String) jSONObject8.get(str17);
                            if (QLog.isColorLevel()) {
                                StringBuilder sb7 = new StringBuilder();
                                jSONArray2 = jSONArray;
                                sb7.append("checkApiState onResult, qqpay name = ");
                                sb7.append(str14);
                                sb7.append(" state = ");
                                sb7.append(intValue5);
                                sb7.append(" api = ");
                                sb7.append(str16);
                                sb7.append(" msg= ");
                                sb7.append(str18);
                                sb7.append("\n");
                                QLog.i("AddFriendCheckOpenidStatePart", 2, sb7.toString());
                            } else {
                                jSONArray2 = jSONArray;
                            }
                            i18++;
                            jSONArray = jSONArray2;
                            str13 = str15;
                            str8 = str17;
                        }
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddFriendCheckOpenidStatePart", 2, "checkApiState onResult " + e16.toString());
                }
            }
        }
    }
}
