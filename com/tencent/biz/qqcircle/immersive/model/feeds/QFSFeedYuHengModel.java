package com.tencent.biz.qqcircle.immersive.model.feeds;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudMeta$StYuHengMaterialInfo;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleMaterial$MaterialDetail;
import qqcircle.QQCircleMaterial$MaterialDetailInfos;
import tianshu.QQCircleTianShu$AdPlacementInfo;
import tianshu.QQCircleTianShu$MapEntry;
import tianshu.QQCircleTianShu$RspEntry;
import w50.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedYuHengModel {
    public static a a(List<FeedCloudMeta$StYuHengMaterialInfo> list) {
        a aVar = new a();
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StYuHengMaterialInfo feedCloudMeta$StYuHengMaterialInfo : list) {
                if (feedCloudMeta$StYuHengMaterialInfo != null && feedCloudMeta$StYuHengMaterialInfo.channelType.get() == 20) {
                    aVar.s(true);
                    aVar.t(feedCloudMeta$StYuHengMaterialInfo.taskID.get());
                    QQCircleMaterial$MaterialDetailInfos qQCircleMaterial$MaterialDetailInfos = new QQCircleMaterial$MaterialDetailInfos();
                    try {
                        qQCircleMaterial$MaterialDetailInfos.mergeFrom(feedCloudMeta$StYuHengMaterialInfo.detailBytes.get().toByteArray());
                        d(qQCircleMaterial$MaterialDetailInfos.detail.get(), aVar);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.e("QFSFeedYuHengModel", 1, "parseFeedJumpPublisherInfo exception:", e16);
                    }
                }
            }
            QLog.d("QFSFeedYuHengModel", 1, "parseFeedJumpPublisherInfo, result: " + aVar);
            if (aVar.i()) {
                c(aVar);
            }
        }
        return aVar;
    }

    public static a b(List<QQCircleTianShu$RspEntry> list) {
        QQCircleTianShu$AdPlacementInfo qQCircleTianShu$AdPlacementInfo;
        a aVar = new a();
        if (list != null && !list.isEmpty()) {
            Iterator<QQCircleTianShu$RspEntry> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    QQCircleTianShu$RspEntry next = it.next();
                    if (next != null && next.key.get() == 1038) {
                        qQCircleTianShu$AdPlacementInfo = next.value;
                        break;
                    }
                } else {
                    qQCircleTianShu$AdPlacementInfo = null;
                    break;
                }
            }
            if (qQCircleTianShu$AdPlacementInfo != null && !qQCircleTianShu$AdPlacementInfo.lst.isEmpty()) {
                aVar.s(true);
                e(qQCircleTianShu$AdPlacementInfo.lst.get(0).argList.get(), aVar);
                if (aVar.i()) {
                    c(aVar);
                }
                QLog.d("QFSFeedYuHengModel", 1, "parseFeedTianshuInfo, result: " + aVar);
            }
        }
        return aVar;
    }

    private static void c(final a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.c())) {
            if (aVar.g()) {
                QLog.d("QFSFeedYuHengModel", 1, "[parseIcon] icon url: " + aVar.c());
                return;
            }
            if (aVar.j()) {
                QLog.d("QFSFeedYuHengModel", 1, "[parseIcon] icon url: " + aVar.c());
                return;
            }
            Option obtain = Option.obtain();
            obtain.setUrl(aVar.c()).setPredecode(true).setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(aVar.c())).build());
            QLog.d("QFSFeedYuHengModel", 1, "[parseIcon] current load icon url: " + aVar.c());
            QCircleFeedPicLoader.g().loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.immersive.model.feeds.QFSFeedYuHengModel.1
                @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
                public void onStateChange(LoadState loadState, Option option) {
                    Bitmap resultBitMap;
                    if (loadState == LoadState.STATE_SUCCESS && (resultBitMap = option.getResultBitMap()) != null) {
                        resultBitMap.setDensity(320);
                        final NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(resultBitMap, new byte[]{1, 2, 2, 9, 32, 0, 0, 0, 40, 0, 0, 0, 90, 0, 0, 0, 90, 0, 0, 0, 8, 0, 0, 0, 8, 0, 0, 0, 48, 0, 0, 0, -56, 0, 0, 0, -55, 0, 0, 0, 32, 0, 0, 0, 33, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 85, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, -1, -1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, new Rect(), "");
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.model.feeds.QFSFeedYuHengModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.o(ninePatchDrawable);
                            }
                        });
                    }
                }
            });
        }
    }

    private static void d(List<QQCircleMaterial$MaterialDetail> list, a aVar) {
        if (list != null && !list.isEmpty()) {
            for (QQCircleMaterial$MaterialDetail qQCircleMaterial$MaterialDetail : list) {
                int i3 = qQCircleMaterial$MaterialDetail.MaterialKeyInt.get();
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 12) {
                                aVar.m(TextUtils.equals(qQCircleMaterial$MaterialDetail.MaterialValue.get(), "1"));
                            }
                        } else {
                            aVar.r(qQCircleMaterial$MaterialDetail.MaterialValue.get());
                        }
                    } else {
                        aVar.n(qQCircleMaterial$MaterialDetail.MaterialValue.get());
                    }
                } else {
                    aVar.u(qQCircleMaterial$MaterialDetail.MaterialValue.get());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x000e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(List<QQCircleTianShu$MapEntry> list, a aVar) {
        if (list != null && !list.isEmpty()) {
            for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list) {
                String str = qQCircleTianShu$MapEntry.key.get();
                str.hashCode();
                char c16 = '\uffff';
                switch (str.hashCode()) {
                    case -907987551:
                        if (str.equals(QZoneDTLoginReporter.SCHEMA)) {
                            c16 = 0;
                        }
                        switch (c16) {
                            case 0:
                                aVar.r(qQCircleTianShu$MapEntry.value.get());
                                break;
                            case 1:
                                aVar.u(qQCircleTianShu$MapEntry.value.get());
                                aVar.l(qQCircleTianShu$MapEntry.value.get());
                                break;
                            case 2:
                                aVar.n(qQCircleTianShu$MapEntry.value.get());
                                break;
                            case 3:
                                aVar.k(qQCircleTianShu$MapEntry.value.get());
                                break;
                            case 4:
                                aVar.t(qQCircleTianShu$MapEntry.value.get());
                                aVar.q(TextUtils.equals(qQCircleTianShu$MapEntry.value.get(), "3"));
                                aVar.m(TextUtils.equals(qQCircleTianShu$MapEntry.value.get(), "1"));
                                aVar.p(TextUtils.equals(qQCircleTianShu$MapEntry.value.get(), "4"));
                                break;
                        }
                        break;
                    case -299291068:
                        if (str.equals("before_click_text")) {
                            c16 = 1;
                        }
                        switch (c16) {
                        }
                        break;
                    case 3226745:
                        if (str.equals("icon")) {
                            c16 = 2;
                        }
                        switch (c16) {
                        }
                        break;
                    case 932035527:
                        if (str.equals("after_click_text")) {
                            c16 = 3;
                        }
                        switch (c16) {
                        }
                        break;
                    case 2039367660:
                        if (str.equals("task_status")) {
                            c16 = 4;
                        }
                        switch (c16) {
                        }
                        break;
                    default:
                        switch (c16) {
                        }
                        break;
                }
            }
        }
    }
}
