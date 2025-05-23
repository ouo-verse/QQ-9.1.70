package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ApkgDebugConstants {
    static IPatchRedirector $redirector_;
    public static Map<String, ApkgConfig> sAppConfigs;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sAppConfigs = new HashMap();
            addTestConfig("debug_785853827_1_2103531609", "\u6d4b\u8bd5\u5c0f\u7a0b\u5e8f1");
        }
    }

    public ApkgDebugConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addTestConfig(String str, String str2) {
        ApkgConfig apkgConfig = new ApkgConfig();
        apkgConfig.mini_appid = str;
        apkgConfig.app_name = str2;
        apkgConfig.mini_version = -1;
        apkgConfig.icon_url = "https://i.gtimg.cn/channel/imglib/201805/upload_d6e388265a3806c16280b38b9dc3cb51.png";
        apkgConfig.apkg_url = "https://i.gtimg.cn/channel/imglib/201805/upload_d6e388265a3806c16280b38b9dc3cb51.png";
        sAppConfigs.put(str, apkgConfig);
    }

    public static MiniAppConfig getMiniAppConfig(String str, QQAppInterface qQAppInterface) {
        ApkgConfig apkgConfig;
        if (!TextUtils.isEmpty(str) && qQAppInterface != null && (apkgConfig = sAppConfigs.get(str)) != null) {
            return new MiniAppConfig(apkgConfig, ((ApkgConfigManager) qQAppInterface.getManager(QQManagerFactory.APKG_CONFIG_MANAGER)).getBaseLibInfo());
        }
        return null;
    }

    public static void handleMiniAppDebugView(LinearLayout linearLayout) {
        if (linearLayout != null && linearLayout.getContext() != null && sAppConfigs.size() > 0) {
            for (Map.Entry<String, ApkgConfig> entry : sAppConfigs.entrySet()) {
                FormSimpleItem formSimpleItem = new FormSimpleItem(linearLayout.getContext());
                formSimpleItem.setLeftText(HardCodeUtil.qqStr(R.string.jer) + entry.getValue().app_name);
                formSimpleItem.setOnClickListener(new View.OnClickListener(linearLayout, entry) { // from class: com.tencent.mobileqq.microapp.apkg.ApkgDebugConstants.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Map.Entry val$entry;
                    final /* synthetic */ LinearLayout val$parentView;

                    {
                        this.val$parentView = linearLayout;
                        this.val$entry = entry;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) linearLayout, (Object) entry);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                        } else {
                            MiniAppLauncher.launchMiniApp(this.val$parentView.getContext(), ((ApkgConfig) this.val$entry.getValue()).mini_appid, 1201);
                        }
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                linearLayout.addView(formSimpleItem);
            }
        }
    }
}
