package com.tencent.biz.qqcircle.launcher;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qqcircle.activity.QCircleFragmentActivity;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFolderFragment;
import com.tencent.biz.qqcircle.immersive.QFSPersonalPanelShellFragment;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumDetailFragment;
import com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumListFragment;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageBasicDataRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageCommDataRequest;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSRecentlyWatchedRecorder;
import com.tencent.biz.qqcircle.preload.task.e;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.mini.config.AppSetting;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleLauncherUtil {
    public static void b(Context context, Intent intent) {
        if (!intent.hasExtra("key_bundle_common_init_bean")) {
            return;
        }
        try {
            if (String.valueOf(1005).equals(((QCircleLayerBean) intent.getExtras().get("key_bundle_common_init_bean")).getSchemeAttrs().get("sourcetype"))) {
                ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        } catch (Exception e16) {
            QLog.e("QCircleLauncherUtil", 1, "[changeStartActivityAnimFromProfileCard]:", e16);
        }
    }

    public static void c() {
        ((IQCirclePublicAccountMessageService) QCircleServiceImpl.getAppInterface().getRuntimeService(IQCirclePublicAccountMessageService.class, "")).setQCircleMessageRead();
    }

    public static String d() {
        return QFSLayerPageFolderFragment.class.getName();
    }

    public static String e() {
        return QFSPersonalAlbumDetailFragment.class.getName();
    }

    public static String f() {
        return QFSPersonalAlbumListFragment.class.getName();
    }

    public static String g() {
        return QFSPersonalDetailsFragment.class.getName();
    }

    public static String h() {
        return QFSPersonalPanelShellFragment.class.getName();
    }

    public static String i(Map<String, String> map, String str) {
        if (map == null || map.isEmpty() || !map.containsKey(str)) {
            return null;
        }
        return map.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, QFSGetMainPageCommDataRequest.b bVar) {
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().h(false).b("2011" + str, bVar.a()).execute();
    }

    public static void k(QCircleInitBean qCircleInitBean) {
        String str = qCircleInitBean.getUser().f398463id.get();
        if (!uq3.c.g6()) {
            if (TextUtils.isEmpty(str)) {
                str = QCircleCommonUtil.getCurrentAccount();
                qCircleInitBean.getUser().f398463id.set(str);
            }
            PreLoader.remove("2001" + str);
            PreLoader.preLoad("2001" + str, new e(str, qCircleInitBean));
            return;
        }
        l(str, qCircleInitBean.getClientFromType());
    }

    private static void l(final String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QFSGetMainPageBasicDataRequest.NEED_TC_RED_DOT, "1");
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().h(false).b("2001" + str, new QFSGetMainPageBasicDataRequest.b(str).f(i3).g(hashMap).a()).execute();
        final QFSGetMainPageCommDataRequest.b bVar = new QFSGetMainPageCommDataRequest.b(str);
        bVar.d();
        if (QCircleCommonUtil.isOwner(str)) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("QCircleLauncherUtil", 4, "preloadPersonalDetails, query draft start ");
                    int i16 = 0;
                    try {
                        List<String> allDraftMissionIdsSync = ((IWinkDraft) QRoute.api(IWinkDraft.class)).getAllDraftMissionIdsSync();
                        if (allDraftMissionIdsSync != null) {
                            i16 = allDraftMissionIdsSync.size();
                        }
                    } catch (Exception e16) {
                        QLog.e("QCircleLauncherUtil", 1, "preloadPersonalDetails, getAllDraftMissionIdsSync error ", e16);
                    }
                    QFSGetMainPageCommDataRequest.b.this.i(i16);
                    QLog.d("QCircleLauncherUtil", 4, "preloadPersonalDetails, query draft end: " + i16);
                    QCircleLauncherUtil.j(str, QFSGetMainPageCommDataRequest.b.this);
                }
            });
        } else {
            j(str, bVar);
        }
    }

    public static void m(QCircleInitBean qCircleInitBean) {
        String str = qCircleInitBean.getUser().f398463id.get();
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().h(false).b(AppSetting.SUPVERSION + str, new QFSGetFeedListRequest.b(str).h(0).k(57).m(QFSRecentlyWatchedRecorder.i().k()).d().a()).execute();
    }

    public static void n(Intent intent, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            intent.putExtra("key_attrs", hashMap);
            String str = hashMap.get("key_scheme");
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("key_scheme", str);
            }
            if (hashMap.containsKey("image")) {
                String[] split = hashMap.get("image").split(";");
                ArrayList arrayList = new ArrayList();
                for (String str2 : split) {
                    arrayList.add(str2);
                }
                intent.putExtra(QCircleHostQzoneHelper.QZONE_SHARE_IMAGES(), arrayList);
            }
            if (hashMap.containsKey("content")) {
                intent.putExtra(QCircleHostQzoneHelper.QZONE_SHARE_SUMMERY(), hashMap.get("content"));
            }
            if (hashMap.containsKey("frompage")) {
                try {
                    intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, Integer.parseInt(hashMap.get("frompage")));
                } catch (Exception e16) {
                    QLog.e("QCircleLauncherUtil", 1, "parse frompage error", e16);
                }
            }
        }
    }

    public static void o(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            p(context, intent, null);
        } catch (Throwable th5) {
            QLog.e("QCircleLauncherUtil", 1, "[startActivityWithExtra] ex: ", th5);
        }
    }

    public static void p(Context context, Intent intent, Bundle bundle) {
        if (context == null) {
            QLog.e("QCircleLauncherUtil", 1, "context is null,cannot start activity");
            return;
        }
        intent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
        if (uq3.c.E5()) {
            if (((IQQBaseService) QRoute.api(IQQBaseService.class)).isNoActivityInForegroundExceptJumpActivity()) {
                QLog.d("QCircleLauncherUtil", 1, "startActivityWithExtra: Splash activity not yet exists; starting one");
                context.startActivities(new Intent[]{((IQQBaseService) QRoute.api(IQQBaseService.class)).getQQSplashIntent(RFWApplication.getApplication()), intent}, bundle);
                return;
            } else {
                QLog.d("QCircleLauncherUtil", 1, "startActivityWithExtra: Splash activity already exists");
                context.startActivity(intent, bundle);
                return;
            }
        }
        QLog.d("QCircleLauncherUtil", 1, "startActivityWithExtra: Splash activity check disabled by WNS");
        context.startActivity(intent, bundle);
    }

    public static void q(Context context, @NonNull Intent intent, boolean z16) {
        Class<?> cls;
        if (z16) {
            cls = QCircleFragmentActivity.class;
        } else {
            cls = QCircleTransFragmentActivity.class;
        }
        intent.setClass(context, cls);
        o(context, intent);
        if (!(context instanceof Activity)) {
            QLog.e("QCircleLauncherUtil", 1, "context is not activity,can not overridePendingTransition");
        } else if (z16) {
            b(context, intent);
        } else {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }
}
