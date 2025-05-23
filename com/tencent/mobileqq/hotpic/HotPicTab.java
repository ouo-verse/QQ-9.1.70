package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes9.dex */
public class HotPicTab extends HorizontalListView {
    static IPatchRedirector $redirector_;
    private static int H;
    private static final int I;
    private static final int J;
    private static final int K;
    private static final float L;
    b C;
    private ArrayList<Integer> D;
    private Handler E;
    Paint F;
    int G;

    /* renamed from: d, reason: collision with root package name */
    private Context f236948d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f236949e;

    /* renamed from: f, reason: collision with root package name */
    private float f236950f;

    /* renamed from: h, reason: collision with root package name */
    private int f236951h;

    /* renamed from: i, reason: collision with root package name */
    private int f236952i;

    /* renamed from: m, reason: collision with root package name */
    private Set<Integer> f236953m;

    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HotPicTab.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                HotPicTab.this.f236950f = 0.0f;
                HotPicTab.this.f236950f = (float) (r10.f236950f + 0.1d);
                HotPicTab.this.invalidate();
                sendMessageDelayed(HotPicTab.this.E.obtainMessage(1), 10L);
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    HotPicTab.this.f236950f = 1.0f;
                    HotPicTab hotPicTab = HotPicTab.this;
                    hotPicTab.f236952i = ((HorizontalListView) hotPicTab).mCurrentlySelectedAdapterIndex;
                    HotPicTab.this.invalidate();
                    return;
                }
                return;
            }
            HotPicTab.this.f236950f = (float) (r10.f236950f + 0.1d);
            if (HotPicTab.this.f236950f < 1.0f) {
                HotPicTab.this.invalidate();
                sendMessageDelayed(HotPicTab.this.E.obtainMessage(1), 10L);
            } else {
                sendMessageDelayed(HotPicTab.this.E.obtainMessage(2), 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        List<HotPicTagInfo> f236955d;

        /* renamed from: e, reason: collision with root package name */
        ArrayList<Integer> f236956e;

        /* renamed from: f, reason: collision with root package name */
        boolean f236957f;

        /* loaded from: classes9.dex */
        class a implements View.OnHoverListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.view.View.OnHoverListener
            public boolean onHover(View view, MotionEvent motionEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
                }
                return true;
            }
        }

        public b(List<HotPicTagInfo> list, ArrayList<Integer> arrayList, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, HotPicTab.this, list, arrayList, Boolean.valueOf(z16));
                return;
            }
            this.f236955d = list;
            this.f236956e = (ArrayList) arrayList.clone();
            this.f236957f = z16;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f236955d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f236955d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            c cVar;
            View view2;
            View view3;
            View view4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view3 = view;
                view4 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (view == null) {
                    cVar = new c();
                    view2 = LayoutInflater.from(HotPicTab.this.f236948d).inflate(R.layout.f167606bq, (ViewGroup) null);
                    cVar.f236960a = (TextView) view2.findViewById(R.id.d8q);
                    view2.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                    view2 = view;
                }
                String str = ((HotPicTagInfo) getItem(i3)).tagName;
                TextView textView = cVar.f236960a;
                textView.setText(str);
                textView.setTextSize(2, HotPicTab.K);
                textView.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.qui_common_text_primary));
                textView.setPadding(0, 0, 0, 0);
                textView.setFocusable(true);
                textView.setGravity(17);
                view2.setLayoutParams(new RelativeLayout.LayoutParams(this.f236956e.get(i3).intValue(), -1));
                view2.setContentDescription(str);
                view2.setFocusable(true);
                view2.setOnHoverListener(new a());
                if (!HotPicTab.this.f236953m.contains(Integer.valueOf(i3))) {
                    ReportController.o(null, "dc00898", "", "", "0X8008077", "0X8008077", 0, 0, i3 + "", "", str, "");
                    HotPicTab.this.f236953m.add(Integer.valueOf(i3));
                }
                view3 = view2;
                view4 = view3;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view4;
        }
    }

    /* loaded from: classes9.dex */
    class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f236960a;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HotPicTab.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        Resources resources = BaseApplication.getContext().getResources();
        H = resources.getDisplayMetrics().widthPixels;
        I = (int) ((resources.getDisplayMetrics().density * 40.0f) + 0.5f);
        J = (int) ((resources.getDisplayMetrics().density * 4.0f) + 0.5f);
        K = 14;
        L = resources.getDisplayMetrics().density;
    }

    public HotPicTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f236951h = -1;
        this.f236952i = -1;
        this.f236953m = new HashSet();
        this.D = new ArrayList<>();
        this.E = new a();
        this.F = new Paint();
        this.G = -1;
        this.f236948d = context;
        this.f236949e = new Paint();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    @Override // com.tencent.widget.HorizontalListView, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        int i17 = H;
        int i18 = this.f236952i;
        int i19 = 0;
        if (i18 < this.mLeftViewAdapterIndex) {
            i17 = 0;
        } else if (i18 <= this.mRightViewAdapterIndex) {
            View child = getChild(i18);
            if (child != null && child.getTag() != null) {
                float left = child.getLeft() + ((c) child.getTag()).f236960a.getLeft();
                float f16 = L;
                i3 = (int) (child.getLeft() + r0.f236960a.getRight() + (f16 * 5.0f));
                i17 = (int) (left - (f16 * 5.0f));
            } else {
                i3 = i17;
                i17 = 0;
            }
            if (this.f236950f > 0.0f) {
                View selectedView = getSelectedView();
                if (selectedView != null && selectedView.getTag() != null) {
                    float left2 = selectedView.getLeft() + ((c) selectedView.getTag()).f236960a.getLeft();
                    float f17 = L;
                    i16 = (int) (selectedView.getLeft() + r4.getRight() + (f17 * 5.0f));
                    i19 = (int) (left2 - (f17 * 5.0f));
                } else {
                    i16 = 0;
                }
                float f18 = this.f236950f;
                i17 = (int) (i17 + ((i19 - i17) * f18));
                i3 = (int) (i3 + (f18 * (i16 - i3)));
            }
            canvas.drawRect(i17, getHeight() - J, i3, getHeight(), this.f236949e);
        }
        i3 = i17;
        if (this.f236950f > 0.0f) {
        }
        canvas.drawRect(i17, getHeight() - J, i3, getHeight(), this.f236949e);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (AppSetting.f99565y) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16))).booleanValue();
        }
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, 50, i28, z16);
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        setAdapter((ListAdapter) null);
        this.D.clear();
        setOnItemClickListener(null);
        this.C = null;
        this.f236953m.clear();
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mCurrentlySelectedAdapterIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView
    public void reset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (z16) {
            super.reset(z16);
            return;
        }
        initView(this.isFromRightToLeft);
        removeAllViewsInLayout();
        if (this.G != -1) {
            int i3 = 0;
            for (int i16 = 0; i16 < this.G && i16 < this.D.size(); i16++) {
                i3 += this.D.get(i16).intValue();
            }
            int intValue = i3 + ((this.D.get(this.G).intValue() * 1) / 2);
            int i17 = (H * 1) / 2;
            if (intValue > i17) {
                this.mCurrentX = intValue - i17;
            } else {
                this.mCurrentX = 0;
            }
            int i18 = this.G;
            this.mCurrentlySelectedAdapterIndex = i18;
            this.f236952i = i18;
            this.f236950f = 1.0f;
            this.mDataChanged = true;
        } else {
            this.mCurrentlySelectedAdapterIndex = 0;
            this.f236952i = 0;
        }
        requestLayout();
    }

    public HotPicTagInfo s() {
        HotPicTagInfo hotPicTagInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HotPicTagInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        b bVar = this.C;
        if (bVar != null) {
            List<HotPicTagInfo> list = bVar.f236955d;
            int size = list.size();
            int i3 = this.mCurrentlySelectedAdapterIndex;
            if (size > i3 && (hotPicTagInfo = list.get(i3)) != null) {
                return hotPicTagInfo;
            }
            return null;
        }
        return null;
    }

    public int scrollBy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        int i16 = this.mNextX;
        int i17 = i16 + i3;
        if (i17 < 0) {
            return -1;
        }
        if (i17 > this.mMaxX) {
            return 1;
        }
        this.mScroller.startScroll(i16, 0, i3, 0, 20);
        setCurrentScrollState(4098);
        requestLayout();
        return 0;
    }

    @Override // com.tencent.widget.HorizontalListView, android.widget.AdapterView
    public void setSelection(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (this.mCurrentlySelectedAdapterIndex == i3) {
            return;
        }
        super.setSelection(i3);
        int i17 = H;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && i3 < listAdapter.getCount() && i3 >= 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (i3 > lastVisiblePosition && lastVisiblePosition != -1) {
                int i18 = 0;
                for (int i19 = 0; i19 <= i3; i19++) {
                    i18 += this.D.get(i19).intValue();
                }
                i16 = (i18 - this.mNextX) - i17;
            } else if (i3 < firstVisiblePosition && firstVisiblePosition != -1) {
                int i26 = 0;
                for (int i27 = 0; i27 < i3; i27++) {
                    i26 += this.D.get(i27).intValue();
                }
                i16 = i26 - this.mNextX;
            } else if (i3 == firstVisiblePosition) {
                int[] iArr = new int[2];
                getChildAt(0).getLocationOnScreen(iArr);
                i16 = iArr[0];
            } else {
                if (i3 == lastVisiblePosition) {
                    int[] iArr2 = new int[2];
                    getChildAt(getChildCount() - 1).getLocationOnScreen(iArr2);
                    int intValue = this.D.get(i3).intValue() - (i17 - iArr2[0]);
                    if (intValue >= 0) {
                        i16 = intValue;
                    }
                } else if (HorizontalListView.DEBUG) {
                    QLog.isDevelopLevel();
                }
                i16 = 0;
            }
            if (i16 != 0) {
                scrollBy(i16);
            } else if (firstVisiblePosition == -1 && lastVisiblePosition == -1) {
                ViewCompat.postOnAnimation(this, new Runnable() { // from class: com.tencent.mobileqq.hotpic.HotPicTab.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HotPicTab.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            HotPicTab.this.requestLayout();
                        }
                    }
                });
            } else {
                requestLayout();
            }
            this.f236950f = 0.0f;
            this.E.removeCallbacksAndMessages(null);
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase("OPPO R7")) {
                this.E.sendEmptyMessage(2);
            } else {
                this.E.sendEmptyMessage(0);
            }
        }
    }

    public void t(List<HotPicTagInfo> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, i3);
            return;
        }
        setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.f236949e.setColor(BaseApplication.getContext().getResources().getColor(R.color.qui_common_brand_standard));
        ArrayList arrayList = new ArrayList(list);
        this.F.setTextSize((K * L) + 0.5f);
        Iterator it = arrayList.iterator();
        boolean z16 = false;
        int i16 = 0;
        while (it.hasNext()) {
            int measureText = (int) (((int) (this.F.measureText(((HotPicTagInfo) it.next()).tagName) + 0.5f)) + (L * 26.0f));
            this.D.add(Integer.valueOf(measureText));
            i16 += measureText;
        }
        if (i16 < H) {
            this.D.clear();
            float f16 = H / i16;
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                this.D.add(Integer.valueOf((int) (((int) (((int) (this.F.measureText(((HotPicTagInfo) it5.next()).tagName) + 0.5f)) + (L * 26.0f))) * f16)));
            }
            z16 = true;
        }
        b bVar = new b(arrayList, this.D, z16);
        this.C = bVar;
        this.G = i3;
        setAdapter((ListAdapter) bVar);
    }
}
