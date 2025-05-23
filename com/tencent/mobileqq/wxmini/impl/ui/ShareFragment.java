package com.tencent.mobileqq.wxmini.impl.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniShareCallback;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.AssetExtension;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ShareFragment extends QPublicBaseFragment {
    private String C = "";
    private int D = 0;
    private int E = 0;
    private ResultReceiver F = null;

    private void Ah() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                ShareFragment.this.wh();
            }
        }, 16, null, false);
    }

    private void Bh(final boolean z16, final int i3) {
        ResultReceiver resultReceiver = this.F;
        if (resultReceiver != null) {
            resultReceiver.send(!z16 ? 1 : 0, null);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.ui.f
            @Override // java.lang.Runnable
            public final void run() {
                ShareFragment.this.xh(z16, i3);
            }
        }, 16, null, false);
    }

    private void Ch() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.C = arguments.getString("app_id", "");
        String string = arguments.getString("icon", "");
        String string2 = arguments.getString("title", "");
        String string3 = arguments.getString("path", "");
        String string4 = arguments.getString("desc", "");
        String string5 = arguments.getString(AssetExtension.SCENE_THUMBNAIL, "");
        this.F = (ResultReceiver) arguments.getParcelable("share_result");
        this.D = arguments.getInt("host_scene", 0);
        this.E = arguments.getInt("share_source", 0);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).shareAsArkMessage(getQBaseActivity(), new MiniArkShareModelBuilder().setAppId(this.C).setTitle(string2).setPicUrl(string5).setIconUrl(string).setJumpUrl(string3).setDescription(string4).setWebURL("").setVersionId("").setTemplateId("").setTemplateData("{}").setVersionType(3).setShareTemplateType(1).setShareBusinessType(2).setShareScene(1).setShareTarget(0).setMiniAppShareFrom(12).setShareRequestCode(666).createMiniArkShareModel(), new IMiniShareCallback() { // from class: com.tencent.mobileqq.wxmini.impl.ui.e
            @Override // com.tencent.mobileqq.mini.api.IMiniShareCallback
            public final void onShared(boolean z16) {
                ShareFragment.this.zh(z16);
            }
        });
    }

    private void quit() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (vh(qBaseActivity)) {
            qBaseActivity.finish();
            qBaseActivity.overridePendingTransition(0, 0);
        }
    }

    private void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    private String uh() {
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        if (bindingWeChatUserInfo == null) {
            return "";
        }
        return bindingWeChatUserInfo.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wh() {
        HashMap hashMap = new HashMap();
        hashMap.put("applet_appid", this.C);
        hashMap.put("host_scene", String.valueOf(this.D));
        hashMap.put("share_approach", String.valueOf(this.E));
        hashMap.put(StartupReportKey.WX_OPENID, uh());
        ((IMiniGameReport) QRoute.api(IMiniGameReport.class)).reportToBeacon("ev_applet_friend_selector_imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xh(boolean z16, int i3) {
        String str;
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("is_succeed", str);
        hashMap.put("applet_appid", this.C);
        hashMap.put("host_scene", String.valueOf(this.D));
        if (i3 > 0) {
            hashMap.put("share_scene", String.valueOf(i3));
        }
        hashMap.put("share_approach", String.valueOf(this.E));
        hashMap.put(StartupReportKey.WX_OPENID, uh());
        ((IMiniGameReport) QRoute.api(IMiniGameReport.class)).reportToBeacon("ev_applet_share_results", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(final boolean z16) {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                ShareFragment.this.yh(z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 666) {
            int th5 = th(intent);
            QLog.i("[wxa-q]WxMini.Share", 2, "onActivityResult requestCode\uff1a" + i3 + ", resultCode:" + i16 + ", shareScene:" + th5);
            if (i16 == 0) {
                QLog.d("[wxa-q]WxMini.Share", 4, "onActivityResult cancel");
                Bh(false, th5);
            } else if (i16 == -1) {
                QLog.d("[wxa-q]WxMini.Share", 4, "onActivityResult ok");
                Bh(true, th5);
            }
        }
        quit();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ch();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        this.F = null;
    }

    private static int th(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            int i3 = extras.getInt("uintype");
            if (i3 == 0) {
                return 1;
            }
            if (i3 == 1) {
                return 2;
            }
            if (i3 == 10027) {
                return 4;
            }
        }
        return -1;
    }

    private boolean vh(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(boolean z16) {
        if (!z16) {
            QLog.e("[wxa-q]WxMini.Share", 1, "share failed!");
            BaseApplication context = BaseApplication.getContext();
            QQToast.makeText(context, context.getString(R.string.x6m), 0).show();
            quit();
            return;
        }
        Ah();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.czq, viewGroup, false);
    }
}
