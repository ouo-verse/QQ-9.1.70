package com.tencent.mobileqq.tvideo.history;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.player.events.RFWTVKPlayerStatusEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.thread.RFWThreadManager;
import gy2.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tvideo.CoverBaseInfo;
import tvideo.TVideoHistory$VideoHistoryRecord;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import zt2.e;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoWatchHistoryUpdateHelper implements SimpleEventReceiver, LifecycleObserver {
    private int C;
    private int D;
    private boolean E;
    private final Observer F;
    private final Observer G;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, TVideoHistory$VideoHistoryRecord> f304455d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.history.b f304456e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.history.a f304457f;

    /* renamed from: h, reason: collision with root package name */
    private VideoBaseInfo f304458h;

    /* renamed from: i, reason: collision with root package name */
    private CoverBaseInfo f304459i;

    /* renamed from: m, reason: collision with root package name */
    private long f304460m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Observer<Long> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            QLog.d("TVideoWatchHistoryUpdateHelper", 1, "dataVersionObserver : " + l3);
            TVideoWatchHistoryUpdateHelper.this.f304460m = l3.longValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements Observer<Long> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            QLog.d("TVideoWatchHistoryUpdateHelper", 1, "updateObserver : " + l3);
            TVideoWatchHistoryUpdateHelper.this.f304460m = l3.longValue();
        }
    }

    public TVideoWatchHistoryUpdateHelper() {
        a aVar = new a();
        this.F = aVar;
        b bVar = new b();
        this.G = bVar;
        com.tencent.mobileqq.tvideo.history.b bVar2 = new com.tencent.mobileqq.tvideo.history.b();
        this.f304456e = bVar2;
        bVar2.f304466m.observeForever(aVar);
        this.f304456e.L1();
        com.tencent.mobileqq.tvideo.history.a aVar2 = new com.tencent.mobileqq.tvideo.history.a();
        this.f304457f = aVar2;
        aVar2.f304464m.observeForever(bVar);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private boolean f(CoverBaseInfo coverBaseInfo) {
        CoverBaseInfo coverBaseInfo2 = this.f304459i;
        if (coverBaseInfo2 != null && coverBaseInfo != null && !TextUtils.isEmpty(coverBaseInfo2.cid) && TextUtils.equals(this.f304459i.cid, coverBaseInfo.cid)) {
            return true;
        }
        return false;
    }

    private void g() {
        TVideoHistory$VideoHistoryRecord tVideoHistory$VideoHistoryRecord;
        if (this.f304458h == null) {
            return;
        }
        if (!e.f453199a.k()) {
            QLog.d("TVideoWatchHistoryUpdateHelper", 1, "updateEndRecord not login");
            return;
        }
        CoverBaseInfo coverBaseInfo = this.f304459i;
        if (coverBaseInfo != null && !TextUtils.isEmpty(coverBaseInfo.cid)) {
            tVideoHistory$VideoHistoryRecord = this.f304455d.get(this.f304459i.cid);
        } else {
            tVideoHistory$VideoHistoryRecord = this.f304455d.get(this.f304458h.vid);
        }
        if (tVideoHistory$VideoHistoryRecord == null) {
            return;
        }
        int i3 = this.D;
        if (i3 + 5000 > this.C) {
            QLog.d("TVideoWatchHistoryUpdateHelper", 1, "updateEndRecord VIDEO_TIME_COMPLETE_FLAG");
            tVideoHistory$VideoHistoryRecord.video_time.set(-2);
        } else {
            tVideoHistory$VideoHistoryRecord.video_time.set(i3 / 1000);
        }
        QLog.d("TVideoWatchHistoryUpdateHelper", 1, "updateEndRecord  vid = " + this.f304458h.vid + " time :" + (this.D / 1000) + " mTotalDuration = " + (this.C / 1000) + " mDataVersion = " + this.f304460m + " mHistoryMap.size() = " + this.f304455d.size());
        if (this.f304455d.size() >= 5 || this.E) {
            ArrayList arrayList = new ArrayList(this.f304455d.values());
            this.f304455d.clear();
            this.f304457f.L1(this.f304460m, arrayList);
        }
    }

    private void h() {
        if (!e.f453199a.k()) {
            QLog.d("TVideoWatchHistoryUpdateHelper", 1, "updateStartRecord not login");
            return;
        }
        Video t16 = c.t();
        if (t16 != null && t16.video_base_info != null) {
            if (!f(t16.cover_base_info)) {
                g();
            }
            this.f304458h = t16.video_base_info;
            this.f304459i = t16.cover_base_info;
            TVideoHistory$VideoHistoryRecord tVideoHistory$VideoHistoryRecord = new TVideoHistory$VideoHistoryRecord();
            tVideoHistory$VideoHistoryRecord.view_date.set(System.currentTimeMillis() / 1000);
            tVideoHistory$VideoHistoryRecord.vid.set(this.f304458h.vid);
            tVideoHistory$VideoHistoryRecord.from_context.set(this.f304458h.material_aspect_vid);
            CoverBaseInfo coverBaseInfo = this.f304459i;
            if (coverBaseInfo != null && !TextUtils.isEmpty(coverBaseInfo.cid)) {
                tVideoHistory$VideoHistoryRecord.cid.set(this.f304459i.cid);
                tVideoHistory$VideoHistoryRecord.record_id.set("cid_" + this.f304459i.cid);
                this.f304455d.put(this.f304459i.cid, tVideoHistory$VideoHistoryRecord);
                return;
            }
            this.f304455d.put(this.f304458h.vid, tVideoHistory$VideoHistoryRecord);
        }
    }

    public void d() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.tvideo.history.b bVar = this.f304456e;
        if (bVar != null) {
            bVar.f304466m.removeObserver(this.F);
        }
        com.tencent.mobileqq.tvideo.history.a aVar = this.f304457f;
        if (aVar != null) {
            aVar.f304464m.removeObserver(this.G);
        }
    }

    public void e(RFWTVKPlayerStatusEvent rFWTVKPlayerStatusEvent) {
        QLog.d("TVideoWatchHistoryUpdateHelper", 1, "handlePlayerStatusEvent:" + rFWTVKPlayerStatusEvent.getPlayerStatus());
        int playerStatus = rFWTVKPlayerStatusEvent.getPlayerStatus();
        if (playerStatus == 4) {
            h();
        } else if (playerStatus == 5 || playerStatus == 6 || playerStatus == 9) {
            g();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(RFWTVKPlayerStatusEvent.class);
        arrayList.add(QFSVideoFeedPlayEvent.class);
        return arrayList;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        QLog.d("TVideoWatchHistoryUpdateHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        QLog.d("TVideoWatchHistoryUpdateHelper", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.E = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.history.TVideoWatchHistoryUpdateHelper.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleBaseEvent simpleBaseEvent2 = simpleBaseEvent;
                if (simpleBaseEvent2 instanceof RFWTVKPlayerStatusEvent) {
                    TVideoWatchHistoryUpdateHelper.this.e((RFWTVKPlayerStatusEvent) simpleBaseEvent2);
                } else if (simpleBaseEvent2 instanceof QFSVideoFeedPlayEvent) {
                    TVideoWatchHistoryUpdateHelper.this.C = ((QFSVideoFeedPlayEvent) simpleBaseEvent2).duration;
                    TVideoWatchHistoryUpdateHelper.this.D = ((QFSVideoFeedPlayEvent) simpleBaseEvent).progress;
                }
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        QLog.d("TVideoWatchHistoryUpdateHelper", 1, "onResume");
        this.E = false;
        com.tencent.mobileqq.tvideo.history.b bVar = this.f304456e;
        if (bVar != null) {
            bVar.L1();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        QLog.d("TVideoWatchHistoryUpdateHelper", 1, DKHippyEvent.EVENT_STOP);
    }
}
