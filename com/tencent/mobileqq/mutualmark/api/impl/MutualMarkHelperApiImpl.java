package com.tencent.mobileqq.mutualmark.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.fragment.MutualMarkDemoFragment;
import com.tencent.mobileqq.mutualmark.fragment.NTMutualDataFragment;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.utils.MutualMarkIpcClient;
import com.tencent.mobileqq.mutualmark.utils.c;
import com.tencent.mobileqq.mutualmark.utils.d;
import com.tencent.mobileqq.mutualmark.widget.util.f;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.util.QQToastUtil;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MutualMarkHelperApiImpl implements IMutualMarkHelperApi {
    private static final int HAVE_MARK = 1;
    private static final int HAVE_NOT_MARK = -1;
    private static long IPC_ID = -1;
    private static final String TAG = "MutualMarkHelperApiImpl";

    private Drawable getDefaultDrawable() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return new ColorDrawable(0);
        }
        Resources resources = qBaseActivity.getResources();
        if (resources == null) {
            return new ColorDrawable(0);
        }
        return resources.getDrawable(R.drawable.eyp, null);
    }

    private void setIconWithUrl(ImageView imageView, String str, boolean z16, String str2) {
        String upgradeIconUrlToVersion2 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(str);
        if (!TextUtils.isEmpty(upgradeIconUrlToVersion2)) {
            Drawable drawable = imageView.getDrawable();
            try {
                if (z16) {
                    imageView.setImageDrawable(f.c(upgradeIconUrlToVersion2, str2, drawable, getDefaultDrawable()));
                } else {
                    imageView.setImageDrawable(f.c(upgradeIconUrlToVersion2, str2, new ColorDrawable(0), getDefaultDrawable()));
                }
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "setIconWithUrl fail, e: " + e16.getMessage());
                imageView.setImageDrawable(null);
                return;
            }
        }
        imageView.setImageDrawable(null);
    }

    private boolean shouldForbidJumpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (!str.startsWith("mqqapi://im/chat")) {
            return false;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("uin");
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KEY_UIN", queryParameter);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "FriendQIPCModule", "ACTION_IS_FRIEND", bundle);
        if (callServer.isSuccess() ? callServer.data.getBoolean("KEY_IS_FRIEND", false) : false) {
            return false;
        }
        QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.wyb));
        return true;
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void addIntimateElegantPageShowTimes() {
        c.d().a();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public com.tencent.qqnt.graytips.action.f createSpecialCareActionInfo(String str) {
        if (str == null) {
            str = "";
        }
        return new k92.a(str);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public com.tencent.mobileqq.mutualmark.model.a getBeginnerTipsSetting() {
        return new a().a();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public String getButtonKeyValue(MutualMarkModel mutualMarkModel, MutualMarkModel.Button button) {
        if (mutualMarkModel == null || button == null) {
            return "0";
        }
        if (!mutualMarkModel.N) {
            if (mutualMarkModel.D == 44) {
                return "8";
            }
            return "1";
        }
        String str = button.f252163e;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 655339:
                if (str.equals("\u4f69\u6234")) {
                    c16 = 0;
                    break;
                }
                break;
            case 21403967:
                if (str.equals("\u53bb\u62bd\u5361")) {
                    c16 = 1;
                    break;
                }
                break;
            case 21628900:
                if (str.equals("\u53bb\u7ed1\u5b9a")) {
                    c16 = 2;
                    break;
                }
                break;
            case 666976221:
                if (str.equals("\u53d6\u6d88\u4f69\u6234")) {
                    c16 = 3;
                    break;
                }
                break;
            case 810377757:
                if (str.equals("\u66f4\u6362\u5b57\u7b26")) {
                    c16 = 4;
                    break;
                }
                break;
            case 822772709:
                if (str.equals("\u67e5\u770b\u8be6\u60c5")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "2";
            case 1:
                return "6";
            case 2:
                return "4";
            case 3:
                return "3";
            case 4:
                return "7";
            case 5:
                return "5";
            default:
                return "0";
        }
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public com.tencent.mobileqq.mutualmark.model.b getCardResource(int i3) {
        return new a().c(i3);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public String getCartoonResourcesPath(String str, String str2) {
        return com.tencent.mobileqq.mutualmark.utils.b.c().b(str, str2);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public boolean getDisableInteractiveSwitchLocal() {
        return c.d().c();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public HashMap<String, Object> getInteractTagAreaData() {
        return d.a().b();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public String getIntimateSpecialCareWording(String str) {
        return k92.f.c(str);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public com.tencent.mobileqq.mutualmark.model.c getLottieDownloadInfo() {
        return a.b();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public QIPCModule getMutualMarkIpcServer() {
        return com.tencent.mobileqq.mutualmark.utils.a.b();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public HashMap<String, Object> getPgSwipLeftData() {
        return d.a().c();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public HashMap<String, Object> getPgTagDetailData() {
        return d.a().d();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public HashMap<String, Object> getPgTagProfileData() {
        return d.a().e();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public Class<? extends com.tencent.qqnt.graytips.handler.b> getSpecialCareGrayTipActionHandler() {
        return k92.c.class;
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public int getUnsafeLocalCache(String str) {
        return c.d().e(str);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public boolean isCartoonResourceReady(String str, String str2) {
        return com.tencent.mobileqq.mutualmark.utils.b.c().d(str, str2);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public boolean isElegantVersion() {
        return true;
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public boolean isFirstTime() {
        return c.d().f() == 1;
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public boolean isIntimateType(long j3) {
        int i3 = (int) j3;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 26) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public boolean isNewIcon(boolean z16, String str, MutualMarkModel mutualMarkModel) {
        if (!mutualMarkModel.N) {
            if (z16) {
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setUnsafeLocalCache(str + mutualMarkModel.E, -1);
            }
            return false;
        }
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getUnsafeLocalCache(str + mutualMarkModel.E) != 1) {
            mutualMarkModel.f252157e = MutualMarkModel.f252153c0;
        }
        if (z16) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setUnsafeLocalCache(str + mutualMarkModel.E, 1);
        }
        return mutualMarkModel.f252157e == MutualMarkModel.f252153c0;
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public boolean isNewerGuideMode() {
        return c.d().g();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void jumpUrl(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (str.startsWith("http")) {
                if (str.contains("isTransBrowser=true")) {
                    Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
                    intent.putExtra("url", str);
                    intent.setData(Uri.parse(str));
                    intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
                    intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                    context.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", str);
                context.startActivity(intent2);
                return;
            }
            if (shouldForbidJumpUrl(str)) {
                QLog.i(TAG, 1, "forbid jump url");
                return;
            } else {
                context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(str)));
                return;
            }
        }
        QLog.e(TAG, 1, "invokeScheme fail, invalid params");
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void launchDataPage(Context context) {
        QPublicFragmentActivity.start(context, new Intent(), NTMutualDataFragment.class);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void launchDemoPage(Context context) {
        QPublicFragmentActivity.start(context, new Intent(), MutualMarkDemoFragment.class);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void registerIpcClient() {
        unregisterIpcClient();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        IPC_ID = serverTimeMillis;
        MutualMarkIpcClient.c(serverTimeMillis);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void reportItemEvent(String str, String str2, String str3, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        d.a().f(str, str2, str3, hashMap, hashMap2);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void reportPageEvent(String str, String str2, HashMap<String, Object> hashMap) {
        d.a().g(str, str2, hashMap);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void requestIntimateInfo(String str) {
        IntimateInfoHandler intimateInfoHandler;
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 1, Log.getStackTraceString(new Throwable()));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || TextUtils.isEmpty(str) || !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(str, TAG) || (intimateInfoHandler = (IntimateInfoHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)) == null) {
            return;
        }
        intimateInfoHandler.I2(str, FriendIntimateRelationshipConfProcessor.a().f202727w0);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void restoreInteractTagAreaData(HashMap<String, Object> hashMap) {
        d.a().h(hashMap);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void restorePgSwipLeftData(HashMap<String, Object> hashMap) {
        d.a().i(hashMap);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void restorePgTagDetailData(HashMap<String, Object> hashMap) {
        d.a().j(hashMap);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void restoreTagProfile(HashMap<String, Object> hashMap) {
        d.a().k(hashMap);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void setUnsafeLocalCache(String str, int i3) {
        c.d().h(str, i3);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void showHalfScreenView(Context context, String str, String str2, String str3, String str4) {
        QUSHalfScreenFloatingDialog qUSHalfScreenFloatingDialog = new QUSHalfScreenFloatingDialog(context, 3);
        qUSHalfScreenFloatingDialog.h(str, str2, str3, str4, QUSHalfScreenFloatingDialog.f251984m);
        qUSHalfScreenFloatingDialog.show();
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void unregisterIpcClient() {
        MutualMarkIpcClient.d(IPC_ID);
        IPC_ID = -1L;
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public String upgradeIconUrlToVersion2(String str) {
        return g.r(str);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void writeDisableInteractiveSwitchLocal(boolean z16) {
        c.d().i(z16);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void checkDownloadCartoonResource(AppRuntime appRuntime, String str, String str2) {
        if (appRuntime == null || !(appRuntime instanceof QQAppInterface)) {
            appRuntime = BaseApplicationImpl.getApplication().getRuntime();
        }
        if (appRuntime instanceof QQAppInterface) {
            com.tencent.mobileqq.mutualmark.utils.b.c().a((QQAppInterface) appRuntime, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public String getIconUrlFormat(MutualMarkModel mutualMarkModel) {
        String str;
        if (mutualMarkModel == null) {
            return "";
        }
        long j3 = mutualMarkModel.H;
        if (!((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isIntimateType(mutualMarkModel.D) && j3 == 0) {
            j3 = 1;
        }
        String replace = mutualMarkModel.U.replace("{level}", String.valueOf(j3)).replace("{sub_level}", String.valueOf(mutualMarkModel.I));
        if (mutualMarkModel.N) {
            str = "0";
        } else {
            str = "1";
        }
        return replace.replace("{style}", str).replace("{size}", "big");
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void reportImpl(MutualMarkModel mutualMarkModel, String str) {
        String str2;
        if (mutualMarkModel == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("interact_tag_open_source", str);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).restorePgTagDetailData(hashMap);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportPageEvent("dt_pgin", "pg_tag_detail", hashMap);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("interact_tag_id", Long.valueOf(mutualMarkModel.D));
        String str3 = "1";
        if (!mutualMarkModel.N) {
            hashMap2.put("interact_tag_status", "0");
        } else if (!mutualMarkModel.M) {
            hashMap2.put("interact_tag_status", "2");
        } else {
            hashMap2.put("interact_tag_status", "1");
        }
        if (mutualMarkModel.f252157e == MutualMarkModel.f252153c0) {
            hashMap2.put("interact_tag_is_new_effect", "1");
        } else {
            hashMap2.put("interact_tag_is_new_effect", "0");
        }
        hashMap2.put("interaction_page_state", "0");
        if (MobileQQ.sProcessId == 1) {
            str3 = "0";
        }
        hashMap2.put("is_auto_trigger", str3);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).restoreTagProfile(hashMap2);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_tag_detail", "em_interact_tag_profile", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), hashMap2);
        if (mutualMarkModel.Z == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MutualMarkModel.Button button : mutualMarkModel.Z) {
            if (!button.f252166i) {
                arrayList.add(button);
            }
        }
        HashMap<String, Object> pgTagProfileData = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagProfileData();
        String str4 = "NULL";
        if (arrayList.size() <= 0) {
            str2 = "NULL";
        } else {
            str2 = ((MutualMarkModel.Button) arrayList.get(0)).f252163e;
        }
        pgTagProfileData.put("interact_tag_profile_bottom_text_one", str2);
        if (arrayList.size() > 1) {
            str4 = ((MutualMarkModel.Button) arrayList.get(1)).f252163e;
        }
        pgTagProfileData.put("interact_tag_profile_bottom_text_second", str4);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_tag_detail", "em_interact_tag_profile_bottom", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), pgTagProfileData);
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void setDescProgressThresholdTextView(TextView textView, MutualMarkModel mutualMarkModel, int i3) {
        List<MutualMarkModel.Graded> list;
        if (textView == null || mutualMarkModel == null || (list = mutualMarkModel.Y) == null || i3 < 0 || i3 >= list.size()) {
            return;
        }
        textView.setText(mutualMarkModel.Y.get(i3).f252171h.replace("{threshold}", ((int) mutualMarkModel.L) + "/" + mutualMarkModel.Y.get(i3).f252170f));
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void setDescThresholdTextView(TextView textView, MutualMarkModel mutualMarkModel) {
        List<MutualMarkModel.Graded> list;
        boolean z16;
        if (textView == null || mutualMarkModel == null || (list = mutualMarkModel.Y) == null) {
            return;
        }
        Iterator<MutualMarkModel.Graded> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            MutualMarkModel.Graded next = it.next();
            if (next.f252168d == mutualMarkModel.H) {
                textView.setText(next.f252171h.replace("{threshold}", ((int) mutualMarkModel.L) + "/" + next.f252170f));
                z16 = true;
                break;
            }
        }
        if (z16) {
            return;
        }
        if (mutualMarkModel.Y.isEmpty()) {
            textView.setText("");
            return;
        }
        MutualMarkModel.Graded graded = mutualMarkModel.Y.get(0);
        textView.setText(graded.f252171h.replace("{threshold}", ((int) mutualMarkModel.L) + "/" + graded.f252170f));
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void setIconWithModel(ImageView imageView, MutualMarkModel mutualMarkModel, boolean z16, String str) {
        if (imageView == null || mutualMarkModel == null) {
            return;
        }
        setIconWithUrl(imageView, mutualMarkModel.f252159h, z16, str);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(mutualMarkModel.N ? 1.0f : 0.0f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    @Override // com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi
    public void setProgressIconWithModel(ImageView imageView, MutualMarkModel mutualMarkModel, int i3, String str) {
        if (imageView == null || mutualMarkModel == null) {
            return;
        }
        if (!((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isIntimateType(mutualMarkModel.D)) {
            i3++;
        }
        String str2 = "0";
        String replace = mutualMarkModel.U.replace("{level}", String.valueOf(i3)).replace("{sub_level}", "0");
        long j3 = i3;
        if (j3 > mutualMarkModel.H) {
            str2 = "1";
        }
        setIconWithUrl(imageView, replace.replace("{style}", str2).replace("{size}", "big"), false, str);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation((!mutualMarkModel.N || j3 > mutualMarkModel.H) ? 0.0f : 1.0f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}
