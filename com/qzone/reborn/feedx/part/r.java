package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.qzone.common.activities.base.QZoneFeedOperateLogic;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class r extends g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    private QZoneFeedOperateLogic f55313d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (r.this.f55313d != null) {
                r.this.f55313d.handleGetShareUrl(QZoneResult.unpack(message));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements Consumer<Boolean> {
        b() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            QZLog.d("QZoneFeedxCommonEventHandlePart", 1, "shareToWxMoment result: " + bool);
            if (bool.booleanValue()) {
                return;
            }
            QZLog.d("QZoneFeedxCommonEventHandlePart", 1, "shareToWxMoment result fail, ex", new Throwable());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements Consumer<Boolean> {
        c() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            QZLog.d("QZoneFeedxCommonEventHandlePart", 1, "shareToWxNew result: " + bool);
            if (bool.booleanValue()) {
                return;
            }
            QZLog.d("QZoneFeedxCommonEventHandlePart", 1, "shareToWxNew result fail, ex", new Throwable());
        }
    }

    private void E9(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length != 0) {
                Object obj2 = objArr[0];
                if (obj2 instanceof BusinessFeedData) {
                    BusinessFeedData businessFeedData = (BusinessFeedData) obj2;
                    if (!TextUtils.isEmpty(businessFeedData.getFeedCommInfo().clientkey) && oo.b.f423230a.e().remove(businessFeedData.getFeedCommInfo().clientkey)) {
                        QZoneFeedOperateLogic qZoneFeedOperateLogic = new QZoneFeedOperateLogic(new a(), getActivity(), "feed");
                        this.f55313d = qZoneFeedOperateLogic;
                        qZoneFeedOperateLogic.setFeedData(businessFeedData);
                        if (com.qzone.reborn.configx.g.f53821a.b().S1()) {
                            this.f55313d.shareToWxMoment(new b());
                        } else {
                            this.f55313d.shareToWxNew("", new c());
                        }
                    }
                }
            }
        }
    }

    private void F9(Event event) {
        int i3 = event.what;
        if (i3 == 2) {
            E9(event.params);
        } else if (i3 != 5 && i3 != 7) {
            if ((i3 == 16 || i3 == 22) && C9() != null) {
                C9().P1();
                return;
            }
            return;
        }
        broadcastMessage("SCROLL_TO_FIRST_FEED", null);
    }

    private void G9(Event event) {
        int i3 = event.what;
        if ((i3 == 19 || i3 == 20) && C9() != null) {
            C9().P1();
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Feed".equals(event.source.getName())) {
            F9(event);
        } else if ("Personalize".equals(event.source.getName())) {
            G9(event);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        EventCenter.getInstance().addUIObserver(this, "Feed", 2, 10, 7, 5, 24, 16, 22);
        EventCenter.getInstance().addUIObserver(this, "Favor", 1, 2);
        EventCenter.getInstance().addUIObserver(this, "Personalize", 19, 20);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }
}
