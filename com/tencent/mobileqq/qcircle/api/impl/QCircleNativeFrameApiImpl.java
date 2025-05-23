package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.immersive.QFSFolderFragment;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketPreviewBean;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.biz.qqcircle.preload.task.QFSLayerPolymerizeDetailPreloadTask;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleNativeFrameApiImpl implements IQCircleNativeFrameApi {
    private static final String TAG = "QCircleNativeFrameApiIm";

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public Fragment createFolderFragment() {
        return new QFSFolderFragment();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public void enterNativePage(Bundle bundle) {
        if (bundle != null) {
            QLog.d(TAG, 1, "enterNativePage");
            ASEnterBean aSEnterBean = (ASEnterBean) bundle.getSerializable("data");
            if (aSEnterBean == null) {
                QLog.e(TAG, 1, "enterNativePage bean is null");
            } else {
                QCircleSchemeLauncher.e(RFWApplication.getApplication(), new QCircleSchemeBean().setSchemeAction(aSEnterBean.getSchemeAction()).setAttrs(aSEnterBean.getAttrs()).setByteAttrs(aSEnterBean.getByteAttrs()).setSourceIds(aSEnterBean.getSourceIds()));
            }
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public Intent getNativeFolderIntent(String str, HashMap<String, String> hashMap, HashMap<String, byte[]> hashMap2) {
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE.equals(str)) {
            return com.tencent.biz.qqcircle.launcher.c.e(null, QCircleApplication.APP, new com.tencent.biz.qqcircle.launcher.parser.b().O(new QCircleSchemeBean().setSchemeAction(str).setAttrs(hashMap).setByteAttrs(hashMap2), hashMap));
        }
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_POLYMERIZE_DETAIL.equals(str)) {
            com.tencent.biz.qqcircle.launcher.parser.f fVar = new com.tencent.biz.qqcircle.launcher.parser.f();
            QCirclePolymerizeDetailBean s16 = fVar.s(new QCircleSchemeBean().setSchemeAction(str).setAttrs(hashMap).setByteAttrs(hashMap2));
            if (uq3.c.V()) {
                PreLoader.remove("2019");
                PreLoader.preLoad("2019", new QFSLayerPolymerizeDetailPreloadTask(s16));
            }
            return fVar.o(QCircleApplication.APP, s16);
        }
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL.equals(str)) {
            QCircleContentDetailSchemeParser qCircleContentDetailSchemeParser = new QCircleContentDetailSchemeParser();
            return qCircleContentDetailSchemeParser.q(QCircleApplication.APP, qCircleContentDetailSchemeParser.K(new QCircleSchemeBean().setSchemeAction(str).setAttrs(hashMap).setByteAttrs(hashMap2)));
        }
        return new Intent();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public boolean isInQCircle() {
        return QCirclePluginUtil.isInQCircleNew();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public boolean isNewLayerMode() {
        return uq3.c.g6();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public void launchMakeRedPacketPage(Activity activity, Bundle bundle, int i3) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        HashMap<String, String> hashMap = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.getString(str));
            }
        }
        qCircleInitBean.setSchemeAttrs(hashMap);
        com.tencent.biz.qqcircle.launcher.c.S(activity, qCircleInitBean, i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public void launchPersonalDetailPage(Context context, long j3) {
        if (context == null) {
            QLog.e(TAG, 1, "launchPersonalDetailPage, context is null ");
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(String.valueOf(j3));
        qCircleInitBean.setClientFromType(7);
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public void launchRedPacketPreviewPage(Activity activity, Bundle bundle) {
        if (bundle == null) {
            QLog.w(TAG, 1, "launchRedPacketPreviewPage, bundle is null ");
            return;
        }
        String string = bundle.getString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_LOCAL_VIDEO_PATH);
        String string2 = bundle.getString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_LOCAL_COVER_PATH);
        String string3 = bundle.getString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_FEED_ID);
        String string4 = bundle.getString(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_FEED_POSTER_ID);
        long j3 = bundle.getLong(QCircleScheme.AttrRedPacket.RED_PACKET_PREVIEW_FEED_CREATE_TIME);
        QFSRedPacketPreviewBean qFSRedPacketPreviewBean = new QFSRedPacketPreviewBean(string, string2);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.f398449id.set(string3);
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(string4);
        feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
        feedCloudMeta$StFeed.createTime.set(j3);
        qFSRedPacketPreviewBean.setFeed(feedCloudMeta$StFeed);
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        qFSRedPacketPreviewBean.setSchemeAttrs(hashMap);
        com.tencent.biz.qqcircle.launcher.c.v0(activity, qFSRedPacketPreviewBean);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public void preloadFolderView(Context context) {
        if (context == null) {
            return;
        }
        if (!QCirclePluginUtil.isTabMode()) {
            QLog.e("QCirclePreloadProcess", 1, "preInflateFolderFragments pass,is not tab mode");
            return;
        }
        if (!l30.a.a().b()) {
            QLog.e("QCirclePreloadProcess", 1, "preInflateFolderFragments pass,don't support async inflate");
            return;
        }
        RFWLayoutPreLoader layoutLoader = RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
        layoutLoader.preloadView(context, R.layout.gc6, 1);
        layoutLoader.preloadView(context, R.layout.gho, 1);
        layoutLoader.preloadView(context, R.layout.g_z, 2);
        layoutLoader.preloadView(context, R.layout.gjb, 1);
        layoutLoader.preloadView(context, R.layout.gjc, 3);
        layoutLoader.preloadView(context, R.layout.gln, 1);
        int d16 = l30.a.a().d();
        if (d16 <= 0) {
            layoutLoader.preloadView(RFWApplication.getApplication(), R.layout.gen, 1);
        }
        QLog.d("QCirclePreloadProcess", 1, "preInflateFolderFragments done, preInflateItemViewCount:" + d16 + "| context:" + context.hashCode());
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public void preloadTabInfo() {
        QCircleFolderBean qCircleFolderBean = new QCircleFolderBean();
        PreLoader.remove("2002");
        PreLoader.preLoad("2002", new com.tencent.biz.qqcircle.preload.task.c(com.tencent.biz.qqcircle.c.e().d(), qCircleFolderBean));
        QLog.d(TAG, 1, "preloadTabInfo");
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi
    public void putArgusToHostActivity(Intent intent, String str, HashMap<String, String> hashMap, HashMap<String, byte[]> hashMap2) {
        if (QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE.equals(str) && intent != null) {
            com.tencent.biz.qqcircle.launcher.c.e(intent, QCircleApplication.APP, new com.tencent.biz.qqcircle.launcher.parser.b().O(new QCircleSchemeBean().setSchemeAction(str).setAttrs(hashMap).setByteAttrs(hashMap2), hashMap));
        }
    }
}
