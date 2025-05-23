package e60;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import androidx.annotation.FloatRange;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.utils.bb;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import e60.k;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends u implements k.b, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static final List<String> f395755d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<Integer, Integer> f395756e;

    static {
        ArrayList arrayList = new ArrayList();
        f395755d = arrayList;
        arrayList.add("HMA-AL00");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f395756e = concurrentHashMap;
        concurrentHashMap.put(4, 8);
        concurrentHashMap.put(3, 0);
        concurrentHashMap.put(1, 1);
        concurrentHashMap.put(2, 1);
    }

    private void F9() {
        if (getActivity() == null) {
            return;
        }
        getActivity().overridePendingTransition(0, 0);
    }

    public static int G9(int i3) {
        try {
            return f395756e.get(Integer.valueOf(i3)).intValue();
        } catch (Throwable th5) {
            QLog.e("QOC-QFSFullScreenOrientationPart", 1, "[getActivityOrientationForType] orientationType: " + i3, th5);
            return 1;
        }
    }

    private View H9() {
        Window window = getWindow();
        if (window == null) {
            return null;
        }
        return window.getDecorView();
    }

    private void I9(Configuration configuration) {
        QFSVideoView qFSVideoView;
        if (configuration != null && bz.l()) {
            int a16 = cx.a(configuration.screenWidthDp);
            int a17 = cx.a(configuration.screenHeightDp);
            QLog.d("QOC-QFSFullScreenOrientationPart", 1, "[handleOnConfigChangeInFold] screenWidth: " + a16 + ", screenHeight: " + a17);
            if (!TransitionHelper.isFolderScreenOpenMode(a16, a17)) {
                return;
            }
            WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
            if (weakReference == null) {
                qFSVideoView = null;
            } else {
                qFSVideoView = weakReference.get();
            }
            if (qFSVideoView != null) {
                feedCloudMeta$StFeed = qFSVideoView.getData();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(bj.g(feedCloudMeta$StFeed), true));
        }
    }

    private void J9(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() != 11) {
            return;
        }
        QLog.d("QOC-QFSFullScreenOrientationPart", 1, "[handlePanelStateEvent] event isShowing: " + qCirclePanelStateEvent.isShowing() + " type: " + qCirclePanelStateEvent.getPanelType() + " | feedId: " + qCirclePanelStateEvent.getFeedId());
        k.j().t(qCirclePanelStateEvent.isShowing());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9() {
        U9(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9(int i3) {
        W9(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M9(Pair pair) {
        String str;
        if (pair == null) {
            str = null;
        } else {
            str = (String) pair.first;
        }
        k.j().t(false);
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenCloseEvent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9() {
        F9();
        bi.p(new bi.a() { // from class: e60.c
            @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
            public final void a(Pair pair) {
                h.M9(pair);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(int i3, boolean z16) {
        U9(i3);
        if (z16) {
            X9(H9(), 1.0f);
        }
    }

    private int R9(Intent intent) {
        if (intent == null) {
            return 4;
        }
        return intent.getIntExtra("orientation_type_flag", 4);
    }

    private void S9() {
        k.j().s(this);
        Y9();
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: e60.a
            @Override // java.lang.Runnable
            public final void run() {
                h.this.N9();
            }
        });
    }

    private void T9() {
        try {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            k.j().s(this);
            k.j().q();
        } catch (Throwable th5) {
            QLog.e("QOC-QFSFullScreenOrientationPart", 1, "[releaseOrientationType] ex:", th5);
        }
    }

    private void U9(final int i3) {
        if (Build.VERSION.SDK_INT >= 29 && o.W0() && !f395755d.contains(DeviceInfoMonitor.getModel())) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: e60.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.O9(i3);
                }
            });
        } else {
            O9(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V9, reason: merged with bridge method [inline-methods] */
    public void O9(int i3) {
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e("QOC-QFSFullScreenOrientationPart", 1, "[requestSyncRequestOrientation] activity == null.");
            return;
        }
        QLog.d("QOC-QFSFullScreenOrientationPart", 1, "[requestSyncRequestOrientation] requestedOrientation: " + i3 + " | activity: " + activity);
        try {
            if (o.Z1()) {
                final Window window = activity.getWindow();
                if (window == null) {
                    return;
                } else {
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: e60.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            window.setWindowAnimations(0);
                        }
                    });
                }
            }
            activity.setRequestedOrientation(i3);
        } catch (Throwable th5) {
            QLog.e("QOC-QFSFullScreenOrientationPart", 1, "[requestSyncRequestOrientation] error: ", th5);
        }
    }

    private void W9(final int i3, final boolean z16) {
        if (z16) {
            X9(H9(), 0.0f);
        }
        RFWThreadManager.getUIHandler().postAtFrontOfQueue(new Runnable() { // from class: e60.f
            @Override // java.lang.Runnable
            public final void run() {
                h.this.Q9(i3, z16);
            }
        });
    }

    private void X9(View view, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT == 26) {
            QLog.d("QOC-QFSFullScreenOrientationPart", 1, "[setViewAlpha] current sdk int is 26, not set alpha");
        } else {
            view.setAlpha(f16);
        }
    }

    private void Y9() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 26) {
            QLog.d("QOC-QFSFullScreenOrientationPart", 1, "[translucentActivity] current sdk int is 26, not translucent activity");
        } else if ("HUAWEI|".contains(Build.BRAND) && i3 >= 31) {
            QLog.d("QOC-QFSFullScreenOrientationPart", 1, "[translucentActivity] forbidden device brand, not translucent activity.");
        } else {
            bb.b(getActivity());
        }
    }

    private Window getWindow() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    @Override // e60.k.b
    public boolean M8(int i3) {
        if (i3 != 4 && i3 != 3) {
            if (i3 != 1 && i3 != 2) {
                return false;
            }
            S9();
            return true;
        }
        W9(f395756e.get(Integer.valueOf(i3)).intValue(), false);
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePanelStateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSVideoView qFSVideoView;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            qFSVideoView = null;
        } else {
            qFSVideoView = weakReference.get();
        }
        RFWPlayerReuseUtils.prepareToReusePlayer(qFSVideoView);
        RFWThreadManager.getUIHandler().postAtFrontOfQueue(new Runnable() { // from class: e60.e
            @Override // java.lang.Runnable
            public final void run() {
                h.this.K9();
            }
        });
        T9();
        QLog.d("QOC-QFSFullScreenOrientationPart", 1, "[onBackEvent] current part back, hashCode: " + hashCode());
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        I9(configuration);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        Intent intent;
        super.onPartCreate(activity, bundle);
        Y9();
        if (activity == null) {
            intent = null;
        } else {
            intent = activity.getIntent();
        }
        final int R9 = R9(intent);
        if (Build.VERSION.SDK_INT >= 35) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: e60.d
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.L9(R9);
                }
            }, 10L);
        } else {
            W9(R9, true);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        T9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        k.j().s(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        k.j().p(this);
        bb.a(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            J9((QCirclePanelStateEvent) simpleBaseEvent);
        }
    }
}
