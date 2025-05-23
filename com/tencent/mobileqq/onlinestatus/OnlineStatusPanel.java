package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes16.dex */
public class OnlineStatusPanel extends RelativeLayout {
    private AsyncGetDataListRunnable.a C;
    private AsyncGetDataListRunnable.a D;

    /* renamed from: d, reason: collision with root package name */
    QQViewPager f255349d;

    /* renamed from: e, reason: collision with root package name */
    aw f255350e;

    /* renamed from: f, reason: collision with root package name */
    EmoticonPagerRadioGroup f255351f;

    /* renamed from: h, reason: collision with root package name */
    private a f255352h;

    /* renamed from: i, reason: collision with root package name */
    private ba f255353i;

    /* renamed from: m, reason: collision with root package name */
    private au f255354m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class AsyncGetDataListRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<OnlineStatusPanel> f255355d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<a> f255356e;

        /* loaded from: classes16.dex */
        public interface a {
            void onResult(ArrayList<au> arrayList, ArrayList<au> arrayList2);
        }

        public AsyncGetDataListRunnable(OnlineStatusPanel onlineStatusPanel, a aVar) {
            this.f255355d = new WeakReference<>(onlineStatusPanel);
            this.f255356e = new WeakReference<>(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ArrayList arrayList, ArrayList arrayList2) {
            a aVar = this.f255356e.get();
            if (aVar == null) {
                return;
            }
            aVar.onResult(arrayList, arrayList2);
        }

        @Override // java.lang.Runnable
        public void run() {
            OnlineStatusPanel onlineStatusPanel = this.f255355d.get();
            if (onlineStatusPanel == null) {
                return;
            }
            ArrayList<au> arrayList = new ArrayList<>(0);
            final ArrayList<au> arrayList2 = new ArrayList<>(0);
            a aVar = onlineStatusPanel.f255352h;
            if (aVar != null) {
                if (aVar.getDataList() != null) {
                    arrayList = aVar.getDataList();
                }
                if (aVar.Qg() != null) {
                    arrayList2 = aVar.Qg();
                }
            } else {
                arrayList = af.C().K();
                aw awVar = onlineStatusPanel.f255350e;
                if (awVar != null) {
                    arrayList2 = awVar.f255553i;
                }
            }
            final ArrayList<au> n3 = af.C().n(arrayList);
            QLog.d("OnlineStatusPanel", 1, "dataList:" + com.tencent.mobileqq.utils.bl.d(n3) + ", selectedList:" + com.tencent.mobileqq.utils.bl.d(arrayList2));
            onlineStatusPanel.n();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.az
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineStatusPanel.AsyncGetDataListRunnable.this.b(n3, arrayList2);
                }
            });
        }
    }

    /* loaded from: classes16.dex */
    public interface a {
        ArrayList<au> Qg();

        ArrayList<au> getDataList();
    }

    public OnlineStatusPanel(Context context) {
        super(context);
        this.C = null;
        this.D = null;
    }

    private int d(ba baVar, int i3) {
        int i16;
        int i17;
        int dpToPx = ViewUtils.dpToPx(baVar.f255566e);
        int dpToPx2 = ViewUtils.dpToPx(baVar.f255567f);
        if (OnlineStatusToggleUtils.d() && baVar.f255562a == 1) {
            i16 = baVar.f255569h;
        } else {
            i16 = baVar.f255568g;
        }
        if (OnlineStatusToggleUtils.d() && baVar.f255562a == 1) {
            i17 = ViewUtils.dpToPx(baVar.f255574m) + ViewUtils.dpToPx(10.0f);
        } else {
            i17 = 0;
        }
        return (i3 * baVar.f255564c) + (ViewUtils.dpToPx(i16) * (baVar.f255564c - 1)) + dpToPx + dpToPx2 + i17;
    }

    private int e(ba baVar) {
        int dip2px = baVar.f255571j - (ViewUtils.dip2px(baVar.f255570i) * 2);
        int dpToPx = ViewUtils.dpToPx(baVar.f255568g);
        int i3 = baVar.f255565d;
        return (dip2px - (dpToPx * (i3 - 1))) / i3;
    }

    private void h() {
        if (this.f255350e.getF373114d() > 1) {
            try {
                this.f255351f.synButton(this.f255350e.getF373114d());
            } catch (Exception e16) {
                QLog.e("OnlineStatusPanel", 1, "e=" + e16);
            }
            this.f255351f.setVisibility(0);
            return;
        }
        this.f255351f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ArrayList arrayList, ArrayList arrayList2) {
        this.f255350e.i(arrayList);
        this.f255350e.f255553i = arrayList2;
        h();
        this.f255350e.notifyDataSetChanged();
        au auVar = this.f255354m;
        if (auVar == null) {
            setCurrentItem();
        } else {
            this.f255350e.l(auVar);
        }
        QQViewPager qQViewPager = this.f255349d;
        boolean z16 = true;
        if (this.f255350e.getF373114d() <= 1) {
            z16 = false;
        }
        qQViewPager.disableGesture(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(boolean z16, ArrayList arrayList, ArrayList arrayList2) {
        if (z16 && arrayList != null && arrayList.equals(this.f255350e.d())) {
            if (com.tencent.mobileqq.utils.bl.b(this.f255350e.f255553i) && com.tencent.mobileqq.utils.bl.c(arrayList2)) {
                this.f255350e.f255553i = arrayList2;
            }
            this.f255350e.n();
            setCurrentItem();
            return;
        }
        this.f255350e.i(arrayList);
        this.f255350e.f255553i = arrayList2;
        h();
        this.f255350e.notifyDataSetChanged();
        setCurrentItem();
        QQViewPager qQViewPager = this.f255349d;
        boolean z17 = true;
        if (this.f255350e.getF373114d() <= 1) {
            z17 = false;
        }
        qQViewPager.disableGesture(z17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        QLog.d("OnlineStatusPanel", 1, "getOnlineStatusItemAndAppear");
        this.C = new AsyncGetDataListRunnable.a() { // from class: com.tencent.mobileqq.onlinestatus.ax
            @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.AsyncGetDataListRunnable.a
            public final void onResult(ArrayList arrayList, ArrayList arrayList2) {
                OnlineStatusPanel.this.i(arrayList, arrayList2);
            }
        };
        ThreadManager.getFileThreadHandler().post(new AsyncGetDataListRunnable(this, this.C));
    }

    public void g(ba baVar) {
        this.f255349d = (QQViewPager) findViewById(R.id.bw9);
        aw awVar = new aw(BaseApplication.getContext(), baVar, this.f255349d);
        this.f255350e = awVar;
        this.f255349d.addOnPageChangeListener(awVar);
        this.f255349d.setAdapter(this.f255350e);
        EmoticonPagerRadioGroup emoticonPagerRadioGroup = (EmoticonPagerRadioGroup) findViewById(R.id.d_j);
        this.f255351f = emoticonPagerRadioGroup;
        emoticonPagerRadioGroup.setViewPager(this.f255349d);
        this.f255351f.setContentDescriptionFormatter(getResources().getString(R.string.f172242px));
        this.f255353i = baVar;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f255351f.getLayoutParams();
        layoutParams.bottomMargin = ViewUtils.dpToPx(baVar.f255574m);
        if (OnlineStatusToggleUtils.d() && baVar.f255562a == 1) {
            layoutParams.topMargin = ViewUtils.dpToPx(10.0f);
        }
        this.f255351f.setLayoutParams(layoutParams);
        m();
        f();
    }

    public void k() {
        this.f255352h = null;
        this.C = null;
        this.D = null;
    }

    public void l() {
        this.f255349d.removeOnPageChangeListener(this.f255350e);
        aw awVar = this.f255350e;
        aw awVar2 = new aw(BaseApplication.getContext(), this.f255353i, this.f255349d);
        this.f255350e = awVar2;
        awVar2.k(awVar.f());
        this.f255349d.addOnPageChangeListener(this.f255350e);
        this.f255349d.setAdapter(this.f255350e);
        m();
        f();
    }

    public void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f255349d.getLayoutParams();
        int e16 = e(this.f255353i);
        layoutParams.height = d(this.f255353i, e16);
        this.f255349d.setLayoutParams(layoutParams);
        this.f255350e.j(e16);
        this.f255350e.p(e16);
    }

    protected void n() {
        int i3 = this.f255353i.f255562a;
        if (i3 != 1 && i3 != 2) {
            this.f255350e.f255554m = null;
            QLog.i("OnlineStatusPanel", 1, "updateGuideId from=" + this.f255353i.f255562a);
            return;
        }
        this.f255350e.f255554m = new com.tencent.mobileqq.onlinestatus.guide.d().e(MobileQQ.getMobileQQ().waitAppRuntime(null));
        QLog.i("OnlineStatusPanel", 1, "updateGuideId id=" + this.f255350e.f255554m + "from=" + this.f255353i.f255562a);
    }

    public void o() {
        h();
        this.f255350e.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(final boolean z16) {
        QLog.d("OnlineStatusPanel", 1, "updateSingleModeOnlineStatusItem check:" + z16);
        this.D = new AsyncGetDataListRunnable.a() { // from class: com.tencent.mobileqq.onlinestatus.ay
            @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.AsyncGetDataListRunnable.a
            public final void onResult(ArrayList arrayList, ArrayList arrayList2) {
                OnlineStatusPanel.this.j(z16, arrayList, arrayList2);
            }
        };
        ThreadManager.getFileThreadHandler().post(new AsyncGetDataListRunnable(this, this.D));
    }

    public void setCurrentItem() {
        int i3;
        aw awVar = this.f255350e;
        int h16 = awVar.h(awVar.f255554m);
        if (h16 < 0) {
            i3 = this.f255350e.g();
        } else {
            i3 = h16;
        }
        QLog.i("OnlineStatusPanel", 1, "setCurrentItem curIndex=" + i3 + ",guildItemPage=" + h16);
        if (i3 == this.f255349d.getCurrentItem()) {
            this.f255350e.onPageSelected(i3);
        }
        this.f255349d.setCurrentItem(i3, false);
    }

    public void setFriendItem(au auVar) {
        this.f255354m = auVar;
    }

    public void setListener(a aVar) {
        this.f255352h = aVar;
    }

    public OnlineStatusPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = null;
        this.D = null;
    }

    public OnlineStatusPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = null;
        this.D = null;
    }
}
