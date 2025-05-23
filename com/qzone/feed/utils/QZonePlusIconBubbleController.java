package com.qzone.feed.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.util.l;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.bubble.RFWTipsManager;
import com.tencent.richframework.bubble.bean.RFWTipsBaseConfig;
import com.tencent.richframework.bubble.controller.RFWTipsBaseController;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.pb.TianShuAccess;
import ho.i;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QZonePlusIconBubbleController {

    /* renamed from: a, reason: collision with root package name */
    private static TianShuAccess.AdItem f47455a;

    /* loaded from: classes39.dex */
    static class FeedPublishMoodBubbleRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final View f47459d;

        /* renamed from: e, reason: collision with root package name */
        private final Activity f47460e;

        /* renamed from: f, reason: collision with root package name */
        private final int f47461f;

        /* renamed from: h, reason: collision with root package name */
        private final QZoneBubbleInfo f47462h;

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.f47460e;
            if (activity != null && !activity.isFinishing() && !this.f47460e.isDestroyed()) {
                View view = this.f47459d;
                if (view != null && view.getVisibility() == 0) {
                    QZonePlusIconBubbleController.f(this.f47460e, this.f47459d, this.f47461f, this.f47462h);
                    return;
                }
                QLog.d("QZonePlusIconBubbleController", 1, "showFeedPublishMoodBubbleRunnable fail, mAnchorView: " + this.f47459d);
                return;
            }
            QLog.d("QZonePlusIconBubbleController", 1, "showFeedPublishMoodBubbleRunnable fail, mActivity: " + this.f47460e);
        }
    }

    public static TianShuAccess.AdItem d() {
        return f47455a;
    }

    public static void e(View view, final QZoneBubbleInfo qZoneBubbleInfo, int i3) {
        e5.b a16 = e5.b.a(view, qZoneBubbleInfo.getWords(), i3);
        QzoneGuideBubbleHelper.g().f();
        QzoneGuideBubbleHelper.d dVar = new QzoneGuideBubbleHelper.d();
        dVar.a(qZoneBubbleInfo.getDifferIcon());
        a16.f(dVar);
        RFWTipsBaseConfig rFWTipsBaseConfig = new RFWTipsBaseConfig();
        rFWTipsBaseConfig.setDuration(5000L);
        final e5.a aVar = new e5.a(view, rFWTipsBaseConfig, a16);
        if (!TextUtils.isEmpty(qZoneBubbleInfo.getDifferIcon())) {
            aVar.addTipsStatusCallBack(new RFWTipsBaseController.TipsStatusCallBack() { // from class: com.qzone.feed.utils.QZonePlusIconBubbleController.1

                /* renamed from: a, reason: collision with root package name */
                private boolean f47456a = false;

                private void a(View view2) {
                    eo.c cVar = eo.c.f396879a;
                    cVar.b();
                    HashMap hashMap = new HashMap();
                    hashMap.put("dt_pgid", "pg_bas_social_updates");
                    hashMap.put("advertising_id", QZoneBubbleInfo.this.getId());
                    hashMap.put("content_list", QZoneBubbleInfo.this.getWords());
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, cVar.c());
                    fo.b bVar = new fo.b();
                    bVar.l(hashMap);
                    bVar.g(ClickPolicy.REPORT_NONE);
                    fo.c.b("dt_clck", view2, "em_qz_plus_sign_bubble", bVar);
                }

                private void b() {
                    if (this.f47456a) {
                        return;
                    }
                    this.f47456a = true;
                    HashMap hashMap = new HashMap();
                    hashMap.put("dt_pgid", "pg_bas_social_updates");
                    hashMap.put("advertising_id", QZoneBubbleInfo.this.getId());
                    hashMap.put("content_list", QZoneBubbleInfo.this.getWords());
                    fo.b bVar = new fo.b();
                    bVar.l(hashMap);
                    fo.c.b("dt_imp", aVar.getPopupWindow().getContentView(), "em_qz_plus_sign_bubble", bVar);
                }

                private void c(View view2) {
                    Context context = view2.getContext();
                    if (context == null) {
                        return;
                    }
                    QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
                    qZonePublishMoodInitBean.t0(0);
                    Boolean bool = Boolean.FALSE;
                    qZonePublishMoodInitBean.R0(bool);
                    qZonePublishMoodInitBean.v0(bool);
                    qZonePublishMoodInitBean.C0("1");
                    qZonePublishMoodInitBean.O0(21);
                    qZonePublishMoodInitBean.G0(Boolean.TRUE);
                    if (!TextUtils.isEmpty(QZoneBubbleInfo.this.getPublishTag()) && !TextUtils.isEmpty(QZoneBubbleInfo.this.getPublishTagUin())) {
                        qZonePublishMoodInitBean.J0(l.f59550a.e(PublishEventTag.assembleFakeTag(QZoneBubbleInfo.this.getPublishTag(), QZoneBubbleInfo.this.getPublishTagUin())));
                    }
                    i.w().c(context, qZonePublishMoodInitBean);
                }

                @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
                public void click(View view2) {
                    a(view2);
                    com.qzone.business.tianshu.c.j().p(QZoneBubbleInfo.this);
                    if (QZoneBubbleInfo.this.getAdPostId() == 1126) {
                        c(view2);
                    } else {
                        if (QZoneBubbleInfo.this.getAdPostId() != 1046 || TextUtils.isEmpty(QZoneBubbleInfo.this.getJumpUrl())) {
                            return;
                        }
                        i.q(view2.getContext(), QZoneBubbleInfo.this.getJumpUrl());
                    }
                }

                @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
                public void dismiss() {
                    RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.feed.utils.QZonePlusIconBubbleController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZonePlusIconBubbleController.f47455a = null;
                            QLog.i("QZonePlusIconBubbleController", 1, "showBubbleInNewStyle dismiss , sBubbleAdItem = null");
                        }
                    }, s.G);
                }

                @Override // com.tencent.richframework.bubble.controller.RFWTipsBaseController.TipsStatusCallBack
                public void show() {
                    b();
                    QZonePlusIconBubbleController.f47455a = QZoneBubbleInfo.this.getOriginAdItem();
                    QLog.i("QZonePlusIconBubbleController", 1, "showBubbleInNewStyle show , sBubbleAdItem.iAdId " + QZonePlusIconBubbleController.f47455a.iAdId.get());
                }
            });
        }
        RFWTipsManager.getInstance().addTips(aVar);
        aVar.startShowTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Activity activity, View view, int i3, QZoneBubbleInfo qZoneBubbleInfo) {
        QLog.d("QZonePlusIconBubbleController", 1, "showFeedPublishMoodBubble");
        if (view != null && activity != null && qZoneBubbleInfo != null) {
            e(view, qZoneBubbleInfo, i3);
            com.qzone.business.tianshu.c.j().n(qZoneBubbleInfo);
            com.qzone.business.tianshu.c.j().o();
            com.qzone.business.tianshu.c.j().q(qZoneBubbleInfo);
            return;
        }
        QLog.d("QZonePlusIconBubbleController", 1, "showFeedPublishMoodBubble fail, anchorView: " + view + ", bubbleInfo: " + qZoneBubbleInfo);
    }
}
