package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bw extends g implements IObserver.main {
    private void E9() {
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM);
        ho.h.e(getActivity(), 1, "toolBar");
    }

    private void F9() {
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("shuoshuoPlus");
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        ho.i.w().c(getActivity(), qZonePublishMoodInitBean);
    }

    private void G9(Event event) {
        int i3 = event.what;
        if (i3 == 25 || i3 == 37) {
            if (C9() != null) {
                C9().P1();
            }
            broadcastMessage("SCROLL_TO_TOP", null);
        }
    }

    private void H9(Event event) {
        int i3 = event.what;
        if (i3 != 2 && i3 != 15) {
            if (i3 == 18) {
                z5.a.f().q(LoginData.getInstance().getUin(), getMainHandler());
                if (C9() != null) {
                    C9().P1();
                    return;
                }
                return;
            }
            if (i3 != 21 && i3 != 4) {
                if (i3 == 5) {
                    z5.a.f().q(LoginData.getInstance().getUin(), getMainHandler());
                    return;
                } else if (i3 != 23 && i3 != 24) {
                    return;
                }
            }
        }
        RFWLog.d(getTAG(), RFWLog.USR, "do feed refresh event : " + event.what);
        if (C9() != null) {
            C9().P1();
        }
    }

    private void I9(Event event) {
        if (event.what == 1) {
            Object obj = event.params;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length <= 0) {
                    return;
                }
                Object obj2 = objArr[0];
                if (obj2 instanceof Map) {
                    final Map map = (Map) obj2;
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.part.bv
                        @Override // java.lang.Runnable
                        public final void run() {
                            bw.this.J9(map);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(Map map) {
        com.qzone.business.plusunion.business.a.h().i(getMainHandler(), map);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFriendFeedxEventHandlePart";
    }

    public void onEventUIThread(Event event) {
        if ("Feed".equals(event.source.getName())) {
            G9(event);
            return;
        }
        if ("Personalize".equals(event.source.getName())) {
            H9(event);
            return;
        }
        if ("Qboss".equals(event.source.getName())) {
            I9(event);
            return;
        }
        if ("Forbiden".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 == 1) {
                F9();
            } else {
                if (i3 != 2) {
                    return;
                }
                E9();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        EventCenter.getInstance().addUIObserver(this, "Lbs", 4, 2, 5, 6);
        EventCenter.getInstance().addUIObserver(this, "Personalize", 2, 4, 5, 7, 8, 9, 14, 15, 16, 17, 18, 21, 23, 24);
        EventCenter.getInstance().addUIObserver(this, "Qboss", 1);
        EventCenter.getInstance().addUIObserver(this, "Feed", 25, 37);
        EventCenter.getInstance().addUIObserver(this, "HeadMenu", 1);
        EventCenter.getInstance().addUIObserver(this, "CustomBanner", 1);
        EventCenter.getInstance().addUIObserver(this, "TianShu", 1);
        EventCenter.getInstance().addUIObserver(this, "Forbiden", 1);
        EventCenter.getInstance().addUIObserver(this, "Forbiden", 2);
        EventCenter.getInstance().addUIObserver(this, "LocalPhotoScan", 1, 2);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }
}
