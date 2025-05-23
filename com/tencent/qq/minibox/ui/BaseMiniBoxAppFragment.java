package com.tencent.qq.minibox.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.minibox.business.api.AsyncCallback;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qq.minibox.ui.BaseMiniBoxAppFragment;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseMiniBoxAppFragment extends QPublicBaseFragment implements nl0.d {
    protected IQQGameDLService C;
    private List<String> D = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Function3<Boolean, Integer, String, Unit> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Boolean bool, Integer num, String str) {
            if (bool.booleanValue()) {
                if (QLog.isColorLevel()) {
                    QLog.d("BaseVirtualAppFragment", 4, " MiniBoxSDK installApp succ");
                }
                if (BaseMiniBoxAppFragment.this.uh()) {
                    BaseMiniBoxAppFragment.this.Th();
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseVirtualAppFragment", 4, " MiniBoxSDK installApp fail err=" + num);
            }
            if (BaseMiniBoxAppFragment.this.uh()) {
                BaseMiniBoxAppFragment.this.Sh(num.intValue(), str);
            }
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Unit invoke(final Boolean bool, final Integer num, final String str) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.e
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMiniBoxAppFragment.a.this.c(bool, num, str);
                }
            });
            return null;
        }
    }

    private void Ah(ArrayList<WadlResult> arrayList) {
        if (arrayList.isEmpty()) {
            Rh(1, null);
            return;
        }
        Iterator<WadlResult> it = arrayList.iterator();
        while (it.hasNext()) {
            WadlResult next = it.next();
            if (Fh(next.wadlParams.packageName) && next.taskStatus == 6) {
                Rh(6, next);
                return;
            }
        }
        Rh(1, null);
    }

    private void Bh(WadlResult wadlResult) {
        int i3 = wadlResult.taskStatus;
        if (i3 == 9) {
            Vh();
            return;
        }
        if (i3 == 14) {
            Uh();
            return;
        }
        if (i3 == 6) {
            Qh(wadlResult);
            return;
        }
        if (i3 == 4) {
            Oh(wadlResult);
            return;
        }
        if (i3 == 5) {
            Mh(wadlResult);
            return;
        }
        if (i3 == 7) {
            Lh(wadlResult.errCode);
        } else if (i3 == 2) {
            Ph(wadlResult);
        } else if (i3 == 12) {
            Kh(wadlResult);
        }
    }

    private void Ch() {
        IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        this.C = iQQGameDLService;
        iQQGameDLService.registerDownloadCallBack(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(ArrayList arrayList) {
        if (uh()) {
            Ah(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(WadlResult wadlResult) {
        if (uh()) {
            Bh(wadlResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(MiniBoxAppInfo miniBoxAppInfo, VirtualAppInfo virtualAppInfo, String str) {
        if (miniBoxAppInfo != null) {
            try {
                int s16 = virtualAppInfo.s();
                String md5 = virtualAppInfo.getMd5();
                if (miniBoxAppInfo.getVersionCode() > s16) {
                    QLog.w("BaseVirtualAppFragment", 1, "queryVirtualAppStatus local install version higher, ignore network info");
                    Rh(3, null);
                } else if (miniBoxAppInfo.getVersionCode() == s16 && md5.equals(str)) {
                    QLog.d("BaseVirtualAppFragment", 2, "queryVirtualAppStatus valid info:" + miniBoxAppInfo);
                    Rh(3, null);
                } else {
                    Xh();
                }
                return;
            } catch (NumberFormatException e16) {
                QLog.e("BaseVirtualAppFragment", 1, "queryVirtualAppStatus throw e:", e16);
                return;
            }
        }
        Xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(final VirtualAppInfo virtualAppInfo, final MiniBoxAppInfo miniBoxAppInfo) {
        final String str;
        QLog.d("BaseVirtualAppFragment", 4, "queryVirtualAppStatus miniBoxAppInfo=" + miniBoxAppInfo);
        if (miniBoxAppInfo != null) {
            String apkPath = MiniBoxSDK.getApkPath(BaseApplication.getContext(), virtualAppInfo.getPackageName());
            if (!TextUtils.isEmpty(apkPath)) {
                str = m51.c.f416181a.a(new File(apkPath));
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMiniBoxAppFragment.this.Ih(miniBoxAppInfo, virtualAppInfo, str);
                    }
                });
            }
        }
        str = null;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseMiniBoxAppFragment.this.Ih(miniBoxAppInfo, virtualAppInfo, str);
            }
        });
    }

    private void Oh(WadlResult wadlResult) {
        zh(wadlResult);
    }

    private String ci(long j3) {
        long j16 = j3 / 3600;
        String str = "";
        if (j16 > 0) {
            str = "" + j16 + "\u5c0f\u65f6";
        }
        long j17 = j3 % 3600;
        long j18 = j17 % 60;
        long j19 = j17 / 60;
        if (j19 > 0) {
            return str + j19 + "\u5206\u949f";
        }
        if (j18 > 0) {
            return str + j18 + "\u79d2";
        }
        return "0\u79d2";
    }

    private WadlParams yh(VirtualAppInfo virtualAppInfo) {
        WadlParams wadlParams = new WadlParams(virtualAppInfo.getAppId(), virtualAppInfo.getPackageName());
        if (!Eh()) {
            wadlParams.setFlagDisable(1);
        }
        wadlParams.setFlags(16384);
        wadlParams.packageName = virtualAppInfo.getPackageName();
        wadlParams.appName = virtualAppInfo.getAppName();
        wadlParams.iconUrl = virtualAppInfo.getAppIcon();
        wadlParams.apkUrl = virtualAppInfo.getDownloadUrl();
        wadlParams.versionCode = virtualAppInfo.s();
        wadlParams.via = "MiniBox";
        wadlParams.scene = virtualAppInfo.getScene();
        wadlParams.launchVia = virtualAppInfo.getVia();
        wadlParams.reportData = virtualAppInfo.getReportData();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("coverUrl", virtualAppInfo.getCoverUrl());
            jSONObject2.put("label", virtualAppInfo.getLabel());
            jSONObject2.put("videoHeight", virtualAppInfo.getVideoHeight());
            jSONObject2.put("videoWidth", virtualAppInfo.getVideoWidth());
            jSONObject2.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, virtualAppInfo.getVideoUrl());
            jSONObject2.put("desc", virtualAppInfo.getDesc());
            jSONObject.put("coverData", jSONObject2);
            wadlParams.extraData = jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("BaseVirtualAppFragment", 1, e16.getMessage(), e16);
        }
        return wadlParams;
    }

    private void zh(WadlResult wadlResult) {
        String str;
        int i3 = wadlResult.progress;
        int systemNetwork = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
        long j3 = wadlResult.speed;
        float f16 = (((float) j3) / 1024.0f) / 1024.0f;
        long j16 = ((float) (wadlResult.fileSize - wadlResult.downloadFileSize)) / ((float) j3);
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                if (systemNetwork != 3) {
                    str = "4G";
                    if (systemNetwork != 4 && systemNetwork == 6) {
                        str = "5G";
                    }
                } else {
                    str = "3G";
                }
            } else {
                str = "2G";
            }
        } else {
            str = Global.TRACKING_WIFI;
        }
        String str2 = str + "\u73af\u5883";
        Nh(i3, str2, new DecimalFormat("0.0").format(f16) + "MB", ci(j16));
    }

    public void Dh(String str) {
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).installVirtualApp(str, new a());
    }

    protected boolean Eh() {
        return false;
    }

    public boolean Fh(String str) {
        if (this.D.size() == 0 || this.D.indexOf(str) != -1) {
            return true;
        }
        return false;
    }

    public void Nh(int i3, String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseVirtualAppFragment", 4, "download running progress:" + i3);
        }
    }

    public void Ph(WadlResult wadlResult) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseVirtualAppFragment", 4, "download start" + wadlResult.wadlParams.apkUrl);
        }
    }

    public void Qh(WadlResult wadlResult) {
        QLog.d("BaseVirtualAppFragment", 4, "onDownloadSucc " + wadlResult);
    }

    public void Wh(String str) {
        this.C.doPauseAction(xh(), str);
    }

    public void Xh() {
        this.C.doQueryAllTask(xh());
    }

    public void Yh(final VirtualAppInfo virtualAppInfo) {
        MiniBoxSDK.getInstalledAppInfo(virtualAppInfo.getPackageName(), new AsyncCallback() { // from class: com.tencent.qq.minibox.ui.c
            @Override // com.tencent.minibox.business.api.AsyncCallback
            public final void onResult(Object obj) {
                BaseMiniBoxAppFragment.this.Jh(virtualAppInfo, (MiniBoxAppInfo) obj);
            }
        });
    }

    public void Zh(String str) {
        this.C.doResumeAction(xh(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(String str) {
        if (uh()) {
            QQToast.makeText(getQBaseActivity(), str, 1).show();
        }
    }

    public void bi(VirtualAppInfo virtualAppInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseVirtualAppFragment", 4, "startDownload url=" + virtualAppInfo.getDownloadUrl());
        }
        this.C.doDownloadAction(xh(), yh(virtualAppInfo));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).init(requireContext());
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).preload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        wh();
    }

    @Override // nl0.d
    public void onQueryCallback(final ArrayList<WadlResult> arrayList) {
        QLog.d("BaseVirtualAppFragment", 2, "onQueryCallback:" + arrayList.size());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseMiniBoxAppFragment.this.Gh(arrayList);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Ch();
    }

    @Override // nl0.d
    public void onWadlStatusChanged(final WadlResult wadlResult) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseVirtualAppFragment", 4, "onWadlStatusChanged wadlResult:" + wadlResult);
        }
        if (!Fh(wadlResult.wadlParams.packageName)) {
            QLog.d("BaseVirtualAppFragment", 1, "[onWadlStatusChanged] is not monitoe pckName");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qq.minibox.ui.b
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMiniBoxAppFragment.this.Hh(wadlResult);
                }
            });
        }
    }

    public void th(String... strArr) {
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    this.D.add(str);
                }
            }
        }
    }

    public boolean uh() {
        boolean z16;
        if (getQBaseActivity() != null && !getQBaseActivity().isFinishing() && isAdded()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        QLog.e("BaseVirtualAppFragment", 1, ">>>Activity is not Exit", new Throwable());
        return false;
    }

    public void vh(String str) {
        this.C.deleteDownload(xh(), str);
    }

    public void wh() {
        IQQGameDLService iQQGameDLService = this.C;
        if (iQQGameDLService != null) {
            iQQGameDLService.unRegisterDownloadCallBack(this);
        }
    }

    public int xh() {
        return 3;
    }

    public void Th() {
    }

    public void Uh() {
    }

    public void Vh() {
    }

    protected void Kh(WadlResult wadlResult) {
    }

    public void Lh(int i3) {
    }

    public void Mh(WadlResult wadlResult) {
    }

    public void Rh(int i3, WadlResult wadlResult) {
    }

    public void Sh(int i3, String str) {
    }
}
