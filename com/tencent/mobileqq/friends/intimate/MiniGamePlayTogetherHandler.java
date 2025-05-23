package com.tencent.mobileqq.friends.intimate;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class MiniGamePlayTogetherHandler {
    static IPatchRedirector $redirector_;

    public static boolean a(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        COMM.StCommonExt stCommonExt;
        if (iNTERFACE$StApiAppInfo != null && (stCommonExt = iNTERFACE$StApiAppInfo.extInfo) != null && stCommonExt.mapInfo != null) {
            for (int i3 = 0; i3 < iNTERFACE$StApiAppInfo.extInfo.mapInfo.size(); i3++) {
                COMM.Entry entry = iNTERFACE$StApiAppInfo.extInfo.mapInfo.get(i3);
                if (entry != null && "battle_attr".equals(entry.key.get())) {
                    return "1".equals(entry.value.get());
                }
            }
        }
        return false;
    }

    public static void b(Context context, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo, String str, int i3, boolean z16) {
        String str2;
        if (context != null && iNTERFACE$StApiAppInfo != null && !TextUtils.isEmpty(iNTERFACE$StApiAppInfo.appId.get())) {
            SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(iNTERFACE$StApiAppInfo));
            if (z16) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).createUpdatableMsg(iNTERFACE$StApiAppInfo.appId.get(), "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, -1, str, 0, null, new MiniAppCmdInterface(context, str) { // from class: com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Context f211771a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f211772b;

                    {
                        this.f211771a = context;
                        this.f211772b = str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
                        }
                    }

                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z17, JSONObject jSONObject) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z17), jSONObject);
                            return;
                        }
                        Activity activity = (Activity) this.f211771a;
                        if (jSONObject != null) {
                            int optInt = jSONObject.optInt("retCode");
                            String optString = jSONObject.optString("errMsg");
                            if (optInt == 0) {
                                activity.startActivity(BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), new int[]{2}).putExtra("uin", this.f211772b).putExtra("uintype", 0));
                                return;
                            } else {
                                activity.runOnUiThread(new Runnable(activity, optString) { // from class: com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler.1.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Activity f211773d;

                                    /* renamed from: e, reason: collision with root package name */
                                    final /* synthetic */ String f211774e;

                                    {
                                        this.f211773d = activity;
                                        this.f211774e = optString;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass1.this, activity, optString);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            QQToast.makeText(this.f211773d, this.f211774e, 0).show();
                                        }
                                    }
                                });
                                QLog.e("MiniGamePlayTogetherHandler", 1, "createUpdatableMsg fail, retCode=", Integer.valueOf(optInt), ", errMsg=", optString, ",ret=", jSONObject.toString());
                                return;
                            }
                        }
                        activity.runOnUiThread(new Runnable(activity) { // from class: com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler.1.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Activity f211775d;

                            {
                                this.f211775d = activity;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) activity);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    Activity activity2 = this.f211775d;
                                    QQToast.makeText(activity2, activity2.getResources().getString(R.string.f161251x8), 0).show();
                                }
                            }
                        });
                        QLog.e("MiniGamePlayTogetherHandler", 1, "createUpdatableMsg fail, isSuc=", Boolean.valueOf(z17), ", ret=", jSONObject);
                    }
                });
                if (i3 == 2064) {
                    str2 = "c2close";
                } else {
                    str2 = "page_view";
                }
                simpleMiniAppConfig.launchParam.scene = i3;
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, str2, "click", null, null);
                return;
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(context, iNTERFACE$StApiAppInfo.appId.get(), null, null, null, null, i3, null);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameProfile(simpleMiniAppConfig, 2064, true);
            return;
        }
        QLog.e("MiniGamePlayTogetherHandler", 1, "onPlayClick param error context:", context, ", appInfo=", iNTERFACE$StApiAppInfo);
        if (context != null) {
            Activity activity = (Activity) context;
            activity.runOnUiThread(new Runnable(activity) { // from class: com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f211776d;

                {
                    this.f211776d = activity;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        Activity activity2 = this.f211776d;
                        QQToast.makeText(activity2, activity2.getResources().getString(R.string.f161241x7), 0).show();
                    }
                }
            });
        }
    }
}
