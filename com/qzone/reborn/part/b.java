package com.qzone.reborn.part;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.event.Event;
import com.qzone.reborn.base.k;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;
import n6.e;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends k implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private n6.e f58489d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f58490e;

    /* renamed from: f, reason: collision with root package name */
    private long f58491f = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static final class a implements e.d {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f58492a;

        public a(b bVar) {
            this.f58492a = new WeakReference<>(bVar);
        }

        @Override // n6.e.d
        public boolean a(int i3, int i16, String str) {
            WeakReference<b> weakReference = this.f58492a;
            b bVar = weakReference == null ? null : weakReference.get();
            if (bVar == null) {
                return false;
            }
            return bVar.G9(i3, i16, str);
        }
    }

    private void E9(n6.e eVar, boolean z16, QZoneCountInfo qZoneCountInfo, String str) {
        if (!z16) {
            QLog.d("QConciseUnreadPart", 1, "[builderDLMsg] no enabled top banner, end flow.");
            return;
        }
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47117a = 2;
        aVar.f47118b = 1;
        aVar.f47121e = (arrayList == null || arrayList.size() <= 0) ? 0L : arrayList.get(0).uin;
        aVar.f47119c = str;
        if (arrayList != null) {
            ArrayList<Pair<QZoneCountUserInfo, String>> arrayList2 = new ArrayList<>();
            Iterator<QZoneCountUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                QZoneCountUserInfo next = it.next();
                arrayList2.add(new Pair<>(next, String.valueOf(next.uin)));
            }
            aVar.f47122f = arrayList2;
        }
        QLog.d("QConciseUnreadPart", 1, "[builderDLMsg] bannerType: ", Integer.valueOf(aVar.f47117a), " | secondaryBannerType: ", Integer.valueOf(aVar.f47118b), " | bannerText: ", aVar.f47119c);
        eVar.b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G9(int i3, int i16, String str) {
        QLog.d("QConciseUnreadPart", 1, "[handleBannerIntercept]  | banner type: " + i3 + " | banner sub type: " + i16 + " | msg: " + str);
        if (i3 == 2) {
            if (P9()) {
                QLog.i("QConciseUnreadPart", 1, "[handleBannerIntercept] isViewOverlayIntercept, end flow.");
                return true;
            }
            if (i16 == 2 && O9(str)) {
                QLog.i("QConciseUnreadPart", 1, "[handleBannerIntercept] current tips intercept handler, end flow.");
                return true;
            }
            this.f58491f = System.currentTimeMillis();
        }
        QLog.i("QConciseUnreadPart", 1, "[handleBannerIntercept] no intercept msg banner");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9() {
        if (!P9() && TianshuRedTouch.INSTANCE.j()) {
            dh.d dVar = dh.d.f393812a;
            dh.c x16 = dVar.x();
            dh.c u16 = dVar.u();
            if (dVar.m(x16)) {
                com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
                aVar.f47117a = 2;
                aVar.f47118b = 1;
                aVar.f47122f = dVar.w();
                this.f58489d.b(aVar);
                return;
            }
            if (dVar.l(u16)) {
                com.qzone.feed.business.model.a aVar2 = new com.qzone.feed.business.model.a();
                aVar2.f47117a = 2;
                aVar2.f47118b = 2;
                aVar2.f47122f = dVar.t();
                this.f58489d.b(aVar2);
            }
        }
    }

    private boolean K9(Event event) {
        if (!TextUtils.equals("UnRead", event.source.getName())) {
            return false;
        }
        Object obj = event.params;
        if (!(obj instanceof Object[])) {
            QLog.d("QConciseUnreadPart", 1, "[handleUnreadEventSource] current event params not is object array type.");
            return false;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr != null && objArr.length >= 0) {
            Object obj2 = objArr[0];
            if (!(obj2 instanceof Bundle)) {
                QLog.d("QConciseUnreadPart", 1, "[handleUnreadEventSource] obj not bundle type.");
                return false;
            }
            try {
                return J9((Bundle) obj2);
            } catch (Throwable th5) {
                QZLog.i("QConciseUnreadPart", 1, "handleUnreadCount unreasonable error,", th5);
                return false;
            }
        }
        QLog.d("QConciseUnreadPart", 1, "[handleUnreadEventSource] datas should not be null or length < 0.");
        return false;
    }

    private boolean L9(boolean z16, n6.e eVar, QZoneCountInfo qZoneCountInfo) {
        String str = qZoneCountInfo.pushMesssage;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z17 = qZoneCountInfo.existDL;
        String str2 = qZoneCountInfo.schema;
        if (!TextUtils.isEmpty(str2) && str2.startsWith("mqzone://arouse/redpocketdetail")) {
            F9(eVar, z16, qZoneCountInfo, str);
            return true;
        }
        if (z17) {
            return false;
        }
        E9(eVar, z16, qZoneCountInfo, str);
        return true;
    }

    private void M9(n6.e eVar) {
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(26);
        if (singleUnReadItem == null) {
            return;
        }
        if (singleUnReadItem.uCount != 0) {
            QLog.d("QConciseUnreadPart", 1, "[hideSpecialCareFeedBanner] specialCountInfo.uCount != 0.");
        } else {
            eVar.hide(10);
        }
    }

    private void N9() {
        this.f58489d.v(ImmersiveUtils.dpToPx(86.5f));
        this.f58489d.q(new a(this));
    }

    private boolean O9(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f58491f;
        boolean z16 = currentTimeMillis < 180000;
        boolean z17 = !TextUtils.isEmpty(str);
        QLog.d("QConciseUnreadPart", 1, "[isNeedInterceptTipsBanner] interval: ", Long.valueOf(currentTimeMillis), " | isWaitInterval: ", Boolean.valueOf(z16), " | isNotContentEmpty: ", Boolean.valueOf(z17));
        return z16 && z17;
    }

    private boolean P9() {
        View findViewById = getPartRootView().findViewById(R.id.hlv);
        if (findViewById != null) {
            Rect rect = new Rect(0, 0, com.tencent.biz.richframework.compat.ImmersiveUtils.getScreenWidth(), com.tencent.biz.richframework.compat.ImmersiveUtils.getScreenHeight());
            findViewById.getGlobalVisibleRect(rect);
            QLog.d("QConciseUnreadPart", 1, "[isViewOverlayInterceptBubbleBanner]  bubbleLayout | visibleHeight = " + (rect.bottom - rect.top) + " | bubbleLayout.height = " + findViewById.getHeight());
            if (rect.bottom - rect.top == findViewById.getHeight()) {
                return true;
            }
        }
        View findViewById2 = getPartRootView().findViewById(R.id.ynt);
        if (findViewById2 != null) {
            Rect rect2 = new Rect(0, 0, com.tencent.biz.richframework.compat.ImmersiveUtils.getScreenWidth(), com.tencent.biz.richframework.compat.ImmersiveUtils.getScreenHeight());
            findViewById2.getGlobalVisibleRect(rect2);
            QLog.d("QConciseUnreadPart", 1, "[isViewOverlayInterceptBubbleBanner]  conciseHeaderView | visibleHeight = " + (rect2.bottom - rect2.top) + " | conciseHeaderView.height = " + findViewById2.getHeight());
            if (rect2.bottom - rect2.top > 0) {
                return true;
            }
        }
        Object messageFromPart = getPartManager().getMessageFromPart("z_plan_head_view_visible", null);
        if (!(messageFromPart instanceof Boolean) || !((Boolean) messageFromPart).booleanValue()) {
            return false;
        }
        QLog.d("QConciseUnreadPart", 1, "[isViewOverlayInterceptBubbleBanner] ZPlanHeadView visible , so no show message banner");
        return true;
    }

    private boolean S9() {
        QZoneCountInfo singleUnReadItem;
        if (this.f58489d == null || (singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(1)) == null || singleUnReadItem.uCount <= 0) {
            return false;
        }
        M9(this.f58489d);
        this.f58489d.hide(2);
        return L9(this.f58490e, this.f58489d, singleUnReadItem);
    }

    public void Q9(boolean z16) {
        this.f58490e = z16;
    }

    public void R9(n6.e eVar) {
        this.f58489d = eVar;
        N9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TianshuRedDataChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QConciseUnreadPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TianshuRedDataChangeEvent) {
            runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.part.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.I9();
                }
            });
        }
    }

    private boolean J9(Bundle bundle) {
        if (bundle == null) {
            QLog.d("QConciseUnreadPart", 1, "[handleUnreadCount] bundle should not be null.");
            return false;
        }
        if (P9()) {
            return false;
        }
        String string = bundle.getString("com.tencent.qq.syncQZoneUnreadAction");
        QLog.d("QConciseUnreadPart", 1, "[handleUnreadCount] action = " + string);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return S9();
    }

    private void F9(n6.e eVar, boolean z16, QZoneCountInfo qZoneCountInfo, String str) {
        if (!z16) {
            QLog.d("QConciseUnreadPart", 1, "[builderRedPocketDetail] no enabled top banner, end flow.");
            return;
        }
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47117a = 2;
        aVar.f47118b = 5;
        aVar.f47121e = (arrayList == null || arrayList.size() <= 0) ? 0L : arrayList.get(0).uin;
        aVar.f47119c = str;
        aVar.f47128l = qZoneCountInfo.schema;
        eVar.b(aVar);
    }

    public boolean H9(Event event) {
        if (event == null) {
            QLog.d("QConciseUnreadPart", 1, "[handleEventUIThread] event should not be null.");
            return false;
        }
        if (TianshuRedTouch.INSTANCE.j()) {
            return false;
        }
        return K9(event);
    }
}
