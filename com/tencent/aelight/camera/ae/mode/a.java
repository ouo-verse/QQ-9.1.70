package com.tencent.aelight.camera.ae.mode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.a;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends com.tencent.aelight.camera.ae.part.b {
    private ImageView C;
    private boolean D;
    private boolean E;
    private RelativeLayout F;
    private AECaptureMode[] G;
    private AECaptureMode H;
    private boolean I;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f65602d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f65603e;

    /* renamed from: f, reason: collision with root package name */
    private AEPituCameraUnit f65604f;

    /* renamed from: h, reason: collision with root package name */
    private View f65605h;

    /* renamed from: i, reason: collision with root package name */
    private AECaptureModeSelectPager f65606i;

    /* renamed from: m, reason: collision with root package name */
    private PagerAdapter f65607m;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.mode.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0566a implements ViewPager.OnPageChangeListener {
        C0566a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            ms.a.a("AEVideoStoryCaptureModePart", "onPageScrollStateChanged");
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            ms.a.a("AEVideoStoryCaptureModePart", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            ms.a.a("AEVideoStoryCaptureModePart", "onPageSelected");
        }
    }

    public a(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.f65604f = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(AECaptureMode aECaptureMode) {
        if (this.H == aECaptureMode || this.f65602d.M1()) {
            return;
        }
        this.f65602d.f65622i.postValue(new AECaptureModeChangingEvent(this.H, aECaptureMode, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E() {
        AEPituCameraUnit aEPituCameraUnit = this.f65604f;
        if (aEPituCameraUnit != null && aEPituCameraUnit.z().getIntent() != null) {
            return this.f65604f.z().getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        }
        return js.a.f410904d.b();
    }

    private AEMaterialManager F() {
        return (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
    }

    private void G(boolean z16) {
        View view = this.f65605h;
        if (view == null) {
            return;
        }
        this.E = z16;
        if (z16) {
            if (view.getVisibility() != 0) {
                this.f65605h.setVisibility(0);
            }
        } else if (view.getVisibility() == 0) {
            this.f65605h.setVisibility(8);
        }
    }

    private void initViewModel() {
        com.tencent.aelight.camera.ae.mode.c cVar = (com.tencent.aelight.camera.ae.mode.c) n.a(this.f65604f).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.f65602d = cVar;
        cVar.f65622i.observe(this.f65604f, new b());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) n.a(this.f65604f).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f65603e = aVar;
        aVar.M1().observe(this.f65604f, new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        this.I = SimpleUIUtil.isNowElderMode();
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1a);
        if (viewStub != null) {
            viewStub.inflate();
            ms.a.f("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
        }
        View findViewById = this.mRootView.findViewById(R.id.rzx);
        this.f65605h = findViewById;
        this.C = (ImageView) findViewById.findViewById(R.id.rvl);
        this.f65606i = (AECaptureModeSelectPager) this.f65605h.findViewById(R.id.s4w);
        this.F = (RelativeLayout) this.mRootView.findViewById(R.id.ru7);
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        int i16 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        if (com.tencent.aelight.camera.aioeditor.shortvideo.util.c.a(i3, i16)) {
            i3 = (i16 * 9) / 16;
        }
        int a16 = (i3 - x.a(this.I ? 68 : 53)) / 2;
        this.f65606i.setPadding(a16, 0, a16, 0);
        this.f65606i.setDisableScroll(true);
        this.f65606i.setOnPageChangeListener(new C0566a());
        AECaptureMode[] value = ((com.tencent.aelight.camera.ae.mode.c) n.a(this.f65604f).get(com.tencent.aelight.camera.ae.mode.c.class)).f65623m.getValue();
        this.G = value;
        if (value != null) {
            G(value.length > 1);
        }
        d dVar = new d(this.mRootView.getContext());
        this.f65607m = dVar;
        this.f65606i.setAdapter(dVar);
        initViewModel();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        Activity activity = this.mActivity;
        if (activity != null && i3 == 101 && i16 == 201) {
            activity.finish();
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        AEPituCameraUnit aEPituCameraUnit;
        super.onActivityResume();
        if (AECaptureMode.NORMAL != this.H || (aEPituCameraUnit = this.f65604f) == null) {
            return;
        }
        aEPituCameraUnit.y1(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements Observer<AECaptureModeChangingEvent> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            int i3;
            if (aECaptureModeChangingEvent == null) {
                return;
            }
            AECaptureMode aECaptureMode = aECaptureModeChangingEvent.f65599b;
            a.this.H = aECaptureMode;
            if (aECaptureMode != AECaptureMode.NORMAL) {
                ((com.tencent.aelight.camera.ae.part.b) a.this).mPartManager.q(196616, new Object[0]);
            }
            if (a.this.G != null) {
                i3 = 0;
                while (i3 < a.this.G.length) {
                    if (aECaptureMode == a.this.G[i3]) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i3 = -1;
            if (i3 != -1) {
                a.this.f65606i.setCurrentItem(i3, true);
            }
            a.this.D = aECaptureMode == AECaptureMode.GIF && !i.b();
            a.this.f65607m.notifyDataSetChanged();
            a.this.C.setVisibility(0);
            a.this.C.setImageResource(a.this.D ? R.drawable.ivl : R.drawable.ivm);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null && a.this.E) {
                a.this.f65605h.setVisibility(bool.booleanValue() ? 0 : 4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f65611d;

        /* renamed from: e, reason: collision with root package name */
        private SparseArray<b> f65612e = new SparseArray<>();

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.ae.mode.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        class ViewOnClickListenerC0567a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AECaptureMode f65614d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f65615e;

            ViewOnClickListenerC0567a(AECaptureMode aECaptureMode, int i3) {
                this.f65614d = aECaptureMode;
                this.f65615e = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!gq.a.f(a.this.E()) || this.f65614d == AECaptureMode.NORMAL || com.tencent.aelight.camera.ae.d.j()) {
                    a.this.D(this.f65614d);
                    d.this.g(view);
                    AECaptureMode aECaptureMode = this.f65614d;
                    if (aECaptureMode == AECaptureMode.GIF) {
                        com.tencent.aelight.camera.ae.report.b.b().B0();
                    } else if (aECaptureMode == AECaptureMode.NORMAL) {
                        com.tencent.aelight.camera.ae.report.b.b().o1();
                    } else if (aECaptureMode == AECaptureMode.PLAY) {
                        com.tencent.aelight.camera.ae.report.b.b().r1();
                    }
                    ms.a.f("AEVideoStoryCaptureModePart", "\u3010AE_CAPTURE_MODE\u3011:" + this.f65615e);
                } else {
                    QQToast.makeText(((com.tencent.aelight.camera.ae.part.b) a.this).mActivity, 1, ((com.tencent.aelight.camera.ae.part.b) a.this).mActivity.getString(R.string.y8r), 1).show();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public final class b {

            /* renamed from: a, reason: collision with root package name */
            public View f65617a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f65618b;

            public b() {
            }
        }

        d(Context context) {
            this.f65611d = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean f(TextView textView, float f16, View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                textView.setAlpha(f16 * 0.5f);
            } else if (motionEvent.getActionMasked() == 1) {
                textView.setAlpha(f16);
                view.performClick();
            }
            return true;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            if (a.this.G == null) {
                return 0;
            }
            return a.this.G.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            b bVar = this.f65612e.get(i3);
            if (bVar == null) {
                View inflate = View.inflate(this.f65611d, R.layout.f167489dl3, null);
                b bVar2 = new b();
                bVar2.f65617a = inflate;
                bVar2.f65618b = (TextView) inflate.findViewById(R.id.rx_);
                this.f65612e.put(i3, bVar2);
                bVar = bVar2;
            }
            AECaptureMode aECaptureMode = a.this.G[i3];
            final TextView textView = bVar.f65618b;
            textView.setText(aECaptureMode.textId);
            textView.setContentDescription(textView.getText());
            bVar.f65617a.setContentDescription(textView.getText());
            if (a.this.D) {
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                textView.setTextColor(this.f65611d.getResources().getColor(R.color.black));
            } else {
                textView.setShadowLayer(4.0f, 0.0f, 2.0f, textView.getResources().getColor(R.color.f156809bx));
                textView.setTextColor(this.f65611d.getResources().getColor(R.color.f158017al3));
            }
            if (a.this.I) {
                textView.setTextSize(18.0f);
            }
            if (a.this.H == aECaptureMode) {
                textView.setAlpha(1.0f);
            } else {
                textView.setAlpha(0.6f);
            }
            final float f16 = a.this.H != aECaptureMode ? 0.6f : 1.0f;
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.aelight.camera.ae.mode.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean f17;
                    f17 = a.d.f(textView, f16, view, motionEvent);
                    return f17;
                }
            });
            textView.setOnClickListener(new ViewOnClickListenerC0567a(aECaptureMode, i3));
            viewGroup.addView(bVar.f65617a);
            return bVar.f65617a;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(View view) {
            TextView textView;
            if (view == null) {
                return;
            }
            for (int i3 = 0; i3 < this.f65612e.size(); i3++) {
                b bVar = this.f65612e.get(i3);
                if (bVar != null && (textView = bVar.f65618b) != null) {
                    textView.setSelected(view == textView);
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        switch (i3) {
            case 393218:
                if (objArr != null && objArr.length == 1 && (objArr[0] instanceof AEMaterialMetaData)) {
                    if (this.H != AECaptureMode.PLAY) {
                        return;
                    }
                    F().w0((AEMaterialMetaData) objArr[0], true);
                    AEPituCameraUnit aEPituCameraUnit = this.f65604f;
                    if (aEPituCameraUnit != null) {
                        aEPituCameraUnit.z().getIntent().putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "camera^" + ((AEMaterialMetaData) objArr[0]).f69050id);
                    }
                }
                D(AECaptureMode.NORMAL);
                return;
            case 393219:
                D(AECaptureMode.PLAY);
                return;
            default:
                return;
        }
    }
}
