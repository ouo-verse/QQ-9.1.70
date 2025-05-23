package com.qwallet.activity.patternlock;

import Wallet.GetSignV2Rsp;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$CheckCreIDForIdentifiedUserRsp;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.QUIProxy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PatternLockHelper {

    /* loaded from: classes3.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public static void a(final Context context, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            QUIProxy.createCustomDialog(context, 230, null, str, null, context.getString(R.string.f171151ok), new a(), null);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qwallet.activity.patternlock.PatternLockHelper.2

                /* renamed from: com.qwallet.activity.patternlock.PatternLockHelper$2$a */
                /* loaded from: classes3.dex */
                class a implements DialogInterface.OnClickListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.dismiss();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    QUIProxy.createCustomDialog(context2, 230, null, str, null, context2.getString(R.string.f171151ok), new a(), null);
                }
            });
        }
    }

    public static Bundle b(PayAccountPB$CheckCreIDForIdentifiedUserRsp payAccountPB$CheckCreIDForIdentifiedUserRsp) {
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nav_type", payAccountPB$CheckCreIDForIdentifiedUserRsp.nav_type.get());
            jSONObject.put("mch_id", payAccountPB$CheckCreIDForIdentifiedUserRsp.mch_id.get());
            jSONObject.put("userid_type", payAccountPB$CheckCreIDForIdentifiedUserRsp.userid_type.get());
            jSONObject.put("userid", payAccountPB$CheckCreIDForIdentifiedUserRsp.userid.get());
            jSONObject.put("time_stamp", payAccountPB$CheckCreIDForIdentifiedUserRsp.time_stamp.get());
            jSONObject.put("token_scene", payAccountPB$CheckCreIDForIdentifiedUserRsp.token_scene.get());
            jSONObject.put("token_type", payAccountPB$CheckCreIDForIdentifiedUserRsp.token_type.get());
            jSONObject.put("busi_info", payAccountPB$CheckCreIDForIdentifiedUserRsp.busi_info.get());
            jSONObject.put("sign", payAccountPB$CheckCreIDForIdentifiedUserRsp.sign.get());
            bundle.putString("extra_data", jSONObject.toString());
            return bundle;
        } catch (JSONException e16) {
            QLog.e("PatternLockHelper", 1, "", e16);
            return null;
        }
    }

    public static Bundle c(GetSignV2Rsp getSignV2Rsp) {
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nav_type", getSignV2Rsp.nav_type);
            jSONObject.put("mch_id", getSignV2Rsp.mch_id);
            jSONObject.put("userid_type", getSignV2Rsp.userid_type);
            jSONObject.put("userid", getSignV2Rsp.userid);
            jSONObject.put("time_stamp", getSignV2Rsp.time_stamp);
            jSONObject.put("token_scene", getSignV2Rsp.token_scene);
            jSONObject.put("token_type", getSignV2Rsp.token_type);
            jSONObject.put("busi_info", getSignV2Rsp.busi_info);
            jSONObject.put("sign", getSignV2Rsp.sign);
            bundle.putString("extra_data", jSONObject.toString());
            return bundle;
        } catch (JSONException e16) {
            QLog.e("PatternLockHelper", 1, "", e16);
            return null;
        }
    }

    public static void d(Context context, int i3, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167857jo);
        qQCustomDialog.getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setMessageTextColor(R.color.f156931fl);
        qQCustomDialog.setBackground(R.drawable.b6n);
        qQCustomDialog.setNegativeButton(str3, context.getColor(R.color.f156931fl), onClickListener2);
        qQCustomDialog.setPositiveButton(str4, context.getColor(R.color.f156931fl), onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.adjustMessageLayout(true);
        try {
            qQCustomDialog.show();
        } catch (Exception e16) {
            QLog.e("PatternLockHelper", 1, "", e16);
        }
    }
}
