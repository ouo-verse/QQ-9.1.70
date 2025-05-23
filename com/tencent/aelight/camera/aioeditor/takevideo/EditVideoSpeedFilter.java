package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import as.a;
import as.b;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditVideoSpeedFilter extends u implements e, PickerContainer.d {
    public static final String I = HardCodeUtil.qqStr(R.string.m1u);
    public static final String J = HardCodeUtil.qqStr(R.string.m2j);
    public static final String K = HardCodeUtil.qqStr(R.string.lz9);
    public static final String L = HardCodeUtil.qqStr(R.string.ly_);
    public static final String M = HardCodeUtil.qqStr(R.string.m2f);
    public static final String N = HardCodeUtil.qqStr(R.string.f171941m33);
    private SparseIntArray C;
    private ViewStub D;
    public PickerContainer E;
    private boolean F;
    private boolean G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    boolean f67842d;

    /* renamed from: e, reason: collision with root package name */
    public long f67843e;

    /* renamed from: f, reason: collision with root package name */
    public int f67844f;

    /* renamed from: h, reason: collision with root package name */
    protected UnHandleTouchEventViewPager f67845h;

    /* renamed from: i, reason: collision with root package name */
    protected b f67846i;

    /* renamed from: m, reason: collision with root package name */
    protected SparseArray<as.a> f67847m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b extends PagerAdapter {

        /* renamed from: f, reason: collision with root package name */
        private final Context f67851f;

        /* renamed from: d, reason: collision with root package name */
        private final Map<Class<? extends a.AbstractC0067a>, Queue<a.AbstractC0067a>> f67849d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final SparseArray<a.AbstractC0067a> f67850e = new SparseArray<>();

        /* renamed from: h, reason: collision with root package name */
        public final List<as.a> f67852h = new ArrayList();

        public b(Context context) {
            this.f67851f = context;
        }

        public int d() {
            return this.f67852h.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            a.AbstractC0067a abstractC0067a = (a.AbstractC0067a) obj;
            viewGroup.removeView(abstractC0067a.f26825a);
            abstractC0067a.f26825a.setOnTouchListener(null);
            abstractC0067a.c();
            Queue<a.AbstractC0067a> queue = this.f67849d.get(abstractC0067a.getClass());
            if (queue == null) {
                queue = new LinkedList<>();
                this.f67849d.put(abstractC0067a.getClass(), queue);
            }
            queue.offer(abstractC0067a);
            this.f67850e.remove(i3);
        }

        public int e(int i3) {
            int size = this.f67852h.size();
            if (size != 0) {
                return i3 % size;
            }
            return 0;
        }

        public a.AbstractC0067a f(int i3) {
            return this.f67850e.get(i3);
        }

        public as.a g(int i3) {
            int e16 = e(i3);
            if (e16 < 0 || e16 >= this.f67852h.size()) {
                return null;
            }
            return this.f67852h.get(e16);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f67852h.size() * 100;
        }

        public void h(int i3, String str) {
            for (as.a aVar : this.f67852h) {
                if (i3 == aVar.f26823c) {
                    aVar.f26824d = str;
                }
            }
            for (int i16 = 0; i16 < this.f67850e.size(); i16++) {
                a.AbstractC0067a valueAt = this.f67850e.valueAt(i16);
                if (valueAt != null && valueAt.f26826b.f26823c == i3 && (valueAt instanceof b.a)) {
                    b.a aVar2 = (b.a) valueAt;
                    aVar2.f26831f.setText(str);
                    if (TextUtils.isEmpty(str)) {
                        EditVideoSpeedFilter.w0(aVar2);
                    }
                }
            }
        }

        public void i(List<as.a> list) {
            this.f67852h.clear();
            this.f67852h.addAll(list);
            this.f67850e.clear();
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i3) {
            as.a g16 = g(i3);
            if (g16 == null) {
                hd0.c.t("EditVideoSpeedFilter", "instantiateItem find data is null !");
                return null;
            }
            Queue<a.AbstractC0067a> queue = this.f67849d.get(g16.b());
            a.AbstractC0067a poll = queue != null ? queue.poll() : null;
            if (poll == null) {
                poll = g16.a(this.f67851f, viewGroup);
            }
            viewGroup.addView(poll.f26825a);
            poll.a(g16, i3);
            this.f67850e.put(i3, poll);
            return poll;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return (obj instanceof a.AbstractC0067a) && ((a.AbstractC0067a) obj).f26825a == view;
        }
    }

    public EditVideoSpeedFilter(EditVideoPartManager editVideoPartManager, boolean z16) {
        super(editVideoPartManager);
        this.f67842d = false;
        this.f67847m = new SparseArray<>();
        this.C = new SparseIntArray();
        this.H = 1;
        this.G = z16;
        if (z16) {
            this.G = n0();
        }
        hd0.c.a("EditVideoSpeedFilter", "EditVideoSpeedFilter : enable: " + this.G);
    }

    private int A0(int i3) {
        hd0.c.a("EditVideoSpeedFilter", "transSpecialPlayMode : nSpeedIndex = " + i3);
        if (SlideShowPhotoListManager.n().m() == 22) {
            LpReportInfo_pf00064.allReport(680, 2, 13);
        }
        if (i3 == 0) {
            if (SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 10, 3);
            }
            return 2;
        }
        if (i3 == 1) {
            if (SlideShowPhotoListManager.n().m() != 22) {
                return 8;
            }
            LpReportInfo_pf00064.allReport(680, 10, 2);
            return 8;
        }
        if (i3 == 2) {
            if (SlideShowPhotoListManager.n().m() != 22) {
                return 0;
            }
            LpReportInfo_pf00064.allReport(680, 10, 1);
            return 0;
        }
        if (i3 == 3) {
            if (SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 10, 4);
            }
            return 3;
        }
        if (i3 != 4) {
            if (i3 == 5 && SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 10, 6);
            }
            return 1;
        }
        if (SlideShowPhotoListManager.n().m() != 22) {
            return 9;
        }
        LpReportInfo_pf00064.allReport(680, 10, 5);
        return 9;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean n0() {
        boolean z16;
        String str = Build.MANUFACTURER;
        boolean z17 = (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equalsIgnoreCase(str) && "MX4 Pro".equalsIgnoreCase(DeviceInfoMonitor.getModel())) ? false : true;
        if (!z17) {
            hd0.c.t("EditVideoSpeedFilter", "Meizu MX4 Pro, in blacklist");
        }
        com.tencent.biz.qqstory.model.h hVar = (com.tencent.biz.qqstory.model.h) com.tencent.biz.qqstory.model.i.c(10);
        if (hVar == null) {
            hd0.c.t("EditVideoSpeedFilter", "storyConfigManager == null !!!");
            return z17;
        }
        if (z17) {
            Boolean bool = Boolean.TRUE;
            if (((Boolean) hVar.j("boolean_enable_fast_play_mode", bool)).booleanValue() && ((Boolean) hVar.j("boolean_enable_revert_play_mode", bool)).booleanValue() && ((Boolean) hVar.j("boolean_enable_slow_play_mode", bool)).booleanValue()) {
                z16 = true;
                if (!z16) {
                    hd0.c.v("EditVideoSpeedFilter", "black model, manufacturer=%s, model=%s", str, DeviceInfoMonitor.getModel());
                }
                return z16;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return z16;
    }

    public static int s0(as.a aVar) {
        hd0.c.a("EditVideoSpeedFilter", "getSpecialSaveMode : mVideoPlayMode = " + aVar.f26821a);
        int i3 = aVar.f26821a;
        if (i3 == 1) {
            return 5;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        if (i3 != 8) {
            return i3 != 9 ? 0 : 4;
        }
        return 3;
    }

    private void t0() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                if (!EditVideoSpeedFilter.this.G || EditVideoSpeedFilter.this.mParent.d0() == null || (activity = EditVideoSpeedFilter.this.mParent.d0().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                EditVideoSpeedFilter editVideoSpeedFilter = EditVideoSpeedFilter.this;
                editVideoSpeedFilter.D = (ViewStub) editVideoSpeedFilter.findViewSure(R.id.ryc);
                EditVideoSpeedFilter editVideoSpeedFilter2 = EditVideoSpeedFilter.this;
                if (editVideoSpeedFilter2.E == null) {
                    ViewParent parent = editVideoSpeedFilter2.D.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        EditVideoSpeedFilter editVideoSpeedFilter3 = EditVideoSpeedFilter.this;
                        editVideoSpeedFilter3.E = (PickerContainer) editVideoSpeedFilter3.D.inflate();
                    } else {
                        EditVideoSpeedFilter editVideoSpeedFilter4 = EditVideoSpeedFilter.this;
                        editVideoSpeedFilter4.E = (PickerContainer) editVideoSpeedFilter4.findViewSure(R.id.idp);
                    }
                    EditVideoSpeedFilter editVideoSpeedFilter5 = EditVideoSpeedFilter.this;
                    editVideoSpeedFilter5.E.q(editVideoSpeedFilter5.mParent.C, editVideoSpeedFilter5);
                    EditVideoSpeedFilter.this.E.s(2, false);
                }
            }
        }, 500L);
    }

    private void u0(int i3, String str) {
        hd0.c.a("EditVideoSpeedFilter", "onPlayModeChanged:" + i3 + "  " + str);
        List<as.a> list = this.f67846i.f67852h;
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            if (i16 >= list.size()) {
                break;
            }
            as.a aVar = list.get(i16);
            if (!TextUtils.isEmpty(aVar.f26822b) && aVar.f26821a == i3) {
                this.f67845h.setCurrentItem(i16, false);
                z16 = true;
                break;
            }
            i16++;
        }
        if (z16) {
            return;
        }
        QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.m0m) + str, 1000).show();
    }

    private int v0(int i3) {
        hd0.c.a("EditVideoSpeedFilter", "transSpecialPlayMode : nPlayMode = " + i3);
        if (i3 == 1) {
            return 5;
        }
        if (i3 == 2) {
            return 0;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 != 8) {
            return i3 != 9 ? 2 : 4;
        }
        return 1;
    }

    protected static void w0(a.AbstractC0067a abstractC0067a) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setStartOffset(1000L);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        abstractC0067a.f26825a.startAnimation(alphaAnimation);
    }

    private void z0(boolean z16) {
        PickerContainer pickerContainer;
        if (this.H == 2 || (pickerContainer = this.E) == null) {
            return;
        }
        if (z16) {
            if (pickerContainer.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
        } else {
            if (pickerContainer.getVisibility() == 4 || this.E.getVisibility() == 8) {
                return;
            }
            this.E.setVisibility(4);
        }
    }

    public void B0() {
        hd0.c.b("EditVideoSpeedFilter", "updateFilterMode : %s", this.mParent.C.f204059i);
        ArrayList arrayList = new ArrayList();
        EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
        if ((editSource instanceof EditTakeVideoSource) || (editSource instanceof EditLocalVideoSource)) {
            com.tencent.biz.qqstory.model.h hVar = (com.tencent.biz.qqstory.model.h) com.tencent.biz.qqstory.model.i.c(10);
            arrayList.add(new as.b(I, -1, 0, 0));
            Boolean bool = Boolean.TRUE;
            if (!((Boolean) hVar.j("boolean_enable_fast_play_mode", bool)).booleanValue()) {
                hd0.c.v("EditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", Build.MANUFACTURER, DeviceInfoMonitor.getModel());
            } else {
                arrayList.add(new as.b(J, 1, 0, 2));
                arrayList.add(new as.b(M, 9, 0, 8));
            }
            String str = Build.MANUFACTURER;
            if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equalsIgnoreCase(str) || !"MX4 Pro".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                if (!((Boolean) hVar.j("boolean_enable_slow_play_mode", bool)).booleanValue()) {
                    hd0.c.v("EditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", str, DeviceInfoMonitor.getModel());
                } else {
                    EditVideoParams editVideoParams = this.mParent.C;
                    if (editVideoParams.f204055d == 11 && !editVideoParams.j()) {
                        hd0.c.t("EditVideoSpeedFilter", "it's tribe slow black model, disable slow!");
                    } else {
                        EditVideoParams editVideoParams2 = this.mParent.C;
                        if (editVideoParams2.f204055d == 12 && !editVideoParams2.j()) {
                            hd0.c.t("EditVideoSpeedFilter", "it's readinjoy slow black model, disable slow!");
                        } else {
                            arrayList.add(new as.b(K, 2, 0, 3));
                            arrayList.add(new as.b(N, 10, 0, 9));
                            this.f67842d = true;
                        }
                    }
                }
            }
            if (!(this.mParent.C.f204059i instanceof EditLocalVideoSource)) {
                if (!((Boolean) hVar.j("boolean_enable_revert_play_mode", bool)).booleanValue()) {
                    hd0.c.v("EditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", str, DeviceInfoMonitor.getModel());
                } else {
                    EditVideoParams editVideoParams3 = this.mParent.C;
                    if (editVideoParams3.f204055d == 11 && !editVideoParams3.g()) {
                        hd0.c.t("EditVideoSpeedFilter", "it's tribe revert black model, disable revert!");
                    } else {
                        EditVideoParams editVideoParams4 = this.mParent.C;
                        if (editVideoParams4.f204055d == 12 && !editVideoParams4.g()) {
                            hd0.c.t("EditVideoSpeedFilter", "it's tribe readinjoy black model, disable revert!");
                        } else {
                            as.b bVar = new as.b(L, 3, 0, 1);
                            bVar.f26824d = this.mParent.C.f() ? HardCodeUtil.qqStr(R.string.m2a) : null;
                            arrayList.add(bVar);
                        }
                    }
                }
            }
        }
        this.f67846i.i(arrayList);
        this.f67845h.setCurrentItem(arrayList.size() * 50, false);
        this.f67843e = System.currentTimeMillis();
        this.f67844f = arrayList.isEmpty() ? 0 : ((as.a) arrayList.get(0)).f26821a;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.e
    public boolean F(int i3) {
        as.a aVar = this.f67847m.get(i3);
        return aVar != null && aVar.c();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.d
    public void M(int i3, String str) {
        hd0.c.a("EditVideoSpeedFilter", "onPickSpeedStart:" + i3 + "  " + str);
        this.F = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.e
    public boolean Y(int i3, Canvas canvas, int i16, int i17) {
        FrameLayout frameLayout;
        Object instantiateItem;
        int i18 = this.C.get(i3);
        a.AbstractC0067a f16 = this.f67846i.f(i18);
        int width = this.f67845h.getWidth();
        int height = this.f67845h.getHeight();
        if (f16 != null) {
            frameLayout = null;
            if (f16.d()) {
                frameLayout = f16.f26825a;
                instantiateItem = null;
            } else {
                instantiateItem = null;
            }
        } else {
            frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(this.f67845h.getLayoutParams()));
            instantiateItem = this.f67846i.instantiateItem((ViewGroup) frameLayout, i18);
            frameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.f67845h.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f67845h.getMeasuredHeight(), 1073741824));
            frameLayout.layout(0, 0, this.f67845h.getWidth(), this.f67845h.getHeight());
        }
        if (frameLayout == null) {
            return false;
        }
        canvas.save();
        canvas.scale(i16 / width, i17 / height);
        frameLayout.draw(canvas);
        canvas.restore();
        if (instantiateItem == null) {
            return true;
        }
        this.f67846i.destroyItem((ViewGroup) frameLayout, i18, instantiateItem);
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        String str;
        int i16;
        int i17;
        String str2;
        super.editVideoPrePublish(i3, bVar);
        as.a aVar = this.f67847m.get(i3);
        if (this.mParent.C.q()) {
            bVar.f400387d.localCreateCity = this.mParent.C.m("extra_local_address_city_name");
        }
        bVar.c(o0());
        bVar.f400387d.saveMode = r0(i3);
        if (aVar != null) {
            str = aVar.f26822b;
            i16 = aVar.f26823c;
            i17 = aVar.f26821a;
            if (i16 != -1) {
                this.mParent.f0().setFilterId(aVar.f26822b);
                this.mParent.f0().setFilterType(2);
            }
        } else {
            str = "";
            i16 = -1;
            i17 = 0;
        }
        String str3 = "2";
        if (i16 != -1) {
            EditVideoPartManager editVideoPartManager = this.mParent;
            int b06 = editVideoPartManager.b0();
            String[] strArr = new String[3];
            strArr[0] = String.valueOf(i16);
            strArr[1] = str;
            if (this.mParent.l0()) {
                str2 = "2";
            } else {
                str2 = "1";
            }
            strArr[2] = str2;
            editVideoPartManager.X0("pub_filter_menu", b06, 0, strArr);
        }
        if (i16 != -1) {
            id0.b.j("0X80076E9", String.valueOf(id0.b.f407535d), String.valueOf(i17), str, String.valueOf(i16));
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f67843e;
        int i18 = this.f67844f;
        hd0.c.c("EditVideoSpeedFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(currentTimeMillis), Integer.valueOf(i18));
        String[] strArr2 = new String[3];
        strArr2[0] = String.valueOf(currentTimeMillis);
        strArr2[1] = String.valueOf(i18);
        if (!this.mParent.l0()) {
            str3 = "1";
        }
        strArr2[2] = str3;
        id0.a.k("video_edit", "pub_filter_interval_time", 0, 0, strArr2);
        ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setEditSpeedChanged(i17 != 0);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (this.G) {
            if (i3 != 0 && i3 != 1 && i3 != 4) {
                if (i3 == 5 || i3 == 6) {
                    z0(false);
                    y0(0);
                    return;
                }
                if (i3 != 11) {
                    if (i3 != 12) {
                        z0(true);
                        y0(4);
                        return;
                    }
                    int v06 = v0(this.f67844f);
                    PickerContainer pickerContainer = this.E;
                    if (pickerContainer != null) {
                        pickerContainer.s(v06, false);
                    }
                    z0(true);
                    y0(0);
                    return;
                }
            }
            z0(true);
            y0(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        if (this.G) {
            int i3 = message.what;
            if (i3 == 12) {
                int i16 = message.arg1;
                this.H = i16;
                PickerContainer pickerContainer = this.E;
                if (pickerContainer != null) {
                    pickerContainer.u(i16 == 1 || i16 == 3, this.mAnimationEndTime);
                }
                return true;
            }
            if (i3 == 21) {
                z0(false);
            } else if (i3 == 22) {
                z0(true);
            }
        }
        return super.handleEditVideoMessage(message);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.d
    public void k(int i3, String str) {
        hd0.c.a("EditVideoSpeedFilter", "onSpeedPickEnd:" + i3 + "  " + str);
        u0(A0(i3), str);
        this.F = false;
    }

    public View o0() {
        a.AbstractC0067a f16 = this.f67846i.f(this.f67845h.getCurrentItem());
        if (f16 == null || !f16.d()) {
            return null;
        }
        return f16.f26825a;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.f67846i = new b(getContext());
        UnHandleTouchEventViewPager unHandleTouchEventViewPager = (UnHandleTouchEventViewPager) findViewSure(R.id.rra);
        this.f67845h = unHandleTouchEventViewPager;
        ViewCompat.setImportantForAccessibility(unHandleTouchEventViewPager, 2);
        this.f67845h.setAdapter(this.f67846i);
        this.f67845h.setOnPageChangeListener(new a());
        B0();
        publishEditExport(e.class, this);
        t0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        this.D = null;
        PickerContainer pickerContainer = this.E;
        if (pickerContainer != null) {
            pickerContainer.y();
            this.E = null;
        }
    }

    public int p0() {
        as.a g16 = this.f67846i.g(this.f67845h.getCurrentItem());
        if (g16 != null) {
            return g16.f26823c;
        }
        return -1;
    }

    public int q0() {
        return r0(this.mParent.N());
    }

    public int r0(int i3) {
        as.a aVar = this.f67847m.get(i3);
        if (aVar == null) {
            return 0;
        }
        return s0(aVar);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.d
    public void x(int i3, String str) {
        hd0.c.a("EditVideoSpeedFilter", "onPickSpeed:" + i3 + "  " + str + " moving:" + this.F);
        if (this.F) {
            return;
        }
        u0(A0(i3), str);
        u.a R = this.mParent.R(o.class);
        if (R instanceof o) {
            ((o) R).t();
        }
        this.mParent.s(Message.obtain(null, 9, 12, i3));
    }

    public void x0(int i3, String str) {
        this.f67846i.h(i3, str);
        this.f67846i.notifyDataSetChanged();
    }

    private void y0(int i3) {
        if ((i3 == 0 || i3 == 4 || i3 == 8) && this.f67845h.getVisibility() != i3) {
            this.f67845h.setVisibility(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            int d16 = i3 % EditVideoSpeedFilter.this.f67846i.d();
            as.a g16 = EditVideoSpeedFilter.this.f67846i.g(d16);
            int i17 = g16 != null ? g16.f26821a : 0;
            b bVar = EditVideoSpeedFilter.this.f67846i;
            as.a g17 = bVar.g((d16 + 1) % bVar.d());
            int i18 = g17 != null ? g17.f26821a : 0;
            x xVar = (x) EditVideoSpeedFilter.this.getEditExport(x.class);
            if (xVar != null) {
                xVar.d0(i17, i18, f16);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            a.AbstractC0067a f16;
            as.a g16 = EditVideoSpeedFilter.this.f67846i.g(i3);
            int i16 = g16 != null ? g16.f26821a : 0;
            EditVideoSpeedFilter editVideoSpeedFilter = EditVideoSpeedFilter.this;
            editVideoSpeedFilter.f67847m.put(editVideoSpeedFilter.mParent.N(), g16);
            if ((i16 == 2 || i16 == 1 || i16 == 3 || i16 == 0) && (f16 = EditVideoSpeedFilter.this.f67846i.f(i3)) != null && TextUtils.isEmpty(f16.f26826b.f26824d)) {
                EditVideoSpeedFilter.w0(f16);
            }
            a.AbstractC0067a f17 = EditVideoSpeedFilter.this.f67846i.f(i3 - 1);
            a.AbstractC0067a f18 = EditVideoSpeedFilter.this.f67846i.f(i3 + 1);
            if (f17 != null) {
                f17.f26825a.clearAnimation();
            }
            if (f18 != null) {
                f18.f26825a.clearAnimation();
            }
            EditVideoSpeedFilter.this.f67843e = System.currentTimeMillis();
            EditVideoSpeedFilter editVideoSpeedFilter2 = EditVideoSpeedFilter.this;
            editVideoSpeedFilter2.f67844f = i16;
            editVideoSpeedFilter2.C.put(EditVideoSpeedFilter.this.mParent.N(), i3);
            x xVar = (x) EditVideoSpeedFilter.this.getEditExport(x.class);
            if (xVar != null) {
                xVar.setPlayMode(i16);
                if (xVar instanceof HWEditLocalVideoPlayer) {
                    ((HWEditLocalVideoPlayer) xVar).B0(i16);
                }
                if (xVar instanceof HWEditImportVideoPlayer) {
                    ((HWEditImportVideoPlayer) xVar).w0(i16);
                }
            }
            if (i16 != 0) {
                EditVideoSpeedFilter.this.mParent.Y0("608", "9", "0", true);
                id0.b.i("0X80076DE");
            }
            hd0.c.c("EditVideoSpeedFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(EditVideoSpeedFilter.this.f67843e), Integer.valueOf(EditVideoSpeedFilter.this.f67844f));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }
    }
}
