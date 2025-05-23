package com.tencent.mobileqq.dt.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.Foreground;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Long, Boolean> f203828a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203829d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f203830e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f203831f;

        a(String str, Activity activity, int i3) {
            this.f203829d = str;
            this.f203830e = activity;
            this.f203831f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, activity, Integer.valueOf(i3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (!TextUtils.isEmpty(this.f203829d)) {
                b.b(this.f203830e, this.f203829d, this.f203831f);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.dt.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class DialogInterfaceOnClickListenerC7490b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203832d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f203833e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f203834f;

        DialogInterfaceOnClickListenerC7490b(String str, Activity activity, int i3) {
            this.f203832d = str;
            this.f203833e = activity;
            this.f203834f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, activity, Integer.valueOf(i3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (!TextUtils.isEmpty(this.f203832d)) {
                b.b(this.f203833e, this.f203832d, this.f203834f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f203835d;

        c(long j3) {
            this.f203835d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                QLog.i("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent dismiss dialog");
                b.f203828a.remove(Long.valueOf(this.f203835d));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26592);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203828a = new HashMap<>();
        }
    }

    public static void b(Context context, String str, int i3) {
        if (i3 == 2) {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public static void c(String str, byte[] bArr) {
        if ("socialError".equals(str)) {
            if (!Foreground.isCurrentProcessForeground()) {
                QLog.i("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent but not foreground");
                return;
            }
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null && !topActivity.isFinishing() && !topActivity.isDestroyed()) {
                long hashCode = topActivity.hashCode();
                Boolean bool = Boolean.TRUE;
                HashMap<Long, Boolean> hashMap = f203828a;
                if (bool.equals(hashMap.get(Long.valueOf(hashCode)))) {
                    QLog.i("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent socialDialogShowed");
                    return;
                }
                String str2 = new String(bArr);
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String optString = jSONObject.optString("wording");
                    String optString2 = jSONObject.optString("title");
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray == null) {
                        QLog.e("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent but buttons is null" + str2);
                        return;
                    }
                    if (optJSONArray.length() != 2) {
                        QLog.e("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent but buttons size is " + optJSONArray.length());
                        return;
                    }
                    if (optJSONArray.length() == 2) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                        String optString3 = optJSONObject.optString("wording");
                        String optString4 = optJSONObject.optString("url");
                        int optInt = optJSONObject.optInt("jumpType");
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(1);
                        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(topActivity, 230, optString2, optString, optString3, optJSONObject2.optString("wording"), new a(optJSONObject2.optString("url"), topActivity, optJSONObject2.optInt("jumpType")), new DialogInterfaceOnClickListenerC7490b(optString4, topActivity, optInt));
                        QLog.i("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent show dialog");
                        createCustomDialog.setOnDismissListener(new c(hashCode));
                        createCustomDialog.show();
                        if (createCustomDialog.isShowing()) {
                            hashMap.put(Long.valueOf(hashCode), bool);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (JSONException unused) {
                    QLog.e("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent but jsonParseError " + str2);
                    return;
                }
            }
            QLog.e("DTAPIImpl.FekitToApp", 1, "onSecDispatchToAppEvent but topActivity is null");
        }
    }
}
