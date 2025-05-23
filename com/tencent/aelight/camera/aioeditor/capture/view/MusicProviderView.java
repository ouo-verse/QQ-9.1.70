package com.tencent.aelight.camera.aioeditor.capture.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.adapter.e;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.data.h;
import com.tencent.aelight.camera.aioeditor.capture.data.i;
import com.tencent.aelight.camera.aioeditor.capture.data.j;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.g;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingItemView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.br;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import fr.f;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;

/* loaded from: classes32.dex */
public class MusicProviderView extends ProviderView implements QIMSlidingTabView.c, AdapterView.OnItemClickListener, BounceViewPager.b, Handler.Callback, d.c {

    /* renamed from: m0, reason: collision with root package name */
    public static boolean f67248m0 = false;
    BounceViewPager N;
    e P;
    List<i> Q;
    int R;
    WeakReferenceHandler S;
    public MusicItemInfo T;
    public MusicItemInfo U;
    public int V;
    public int W;

    /* renamed from: a0, reason: collision with root package name */
    public int f67249a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f67250b0;

    /* renamed from: c0, reason: collision with root package name */
    private g f67251c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f67252d0;

    /* renamed from: e0, reason: collision with root package name */
    long f67253e0;

    /* renamed from: f0, reason: collision with root package name */
    private MusicItemInfo f67254f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f67255g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f67256h0;

    /* renamed from: i0, reason: collision with root package name */
    public com.tencent.aelight.camera.aioeditor.capture.music.b f67257i0;

    /* renamed from: j0, reason: collision with root package name */
    qs.e f67258j0;

    /* renamed from: k0, reason: collision with root package name */
    com.tencent.aelight.camera.aioeditor.capture.music.e f67259k0;

    /* renamed from: l0, reason: collision with root package name */
    QIMMusicConfigManager.c f67260l0;

    /* loaded from: classes32.dex */
    class a extends com.tencent.aelight.camera.aioeditor.capture.music.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.b
        public void d() {
            MusicProviderView.this.P(false);
        }
    }

    /* loaded from: classes32.dex */
    class d implements QIMMusicConfigManager.c {
        d() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.c
        public void a(int i3, boolean z16, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "onStep:" + i3 + " done:" + z16);
            }
            if (i3 == 6 || i3 == 5 || i3 == 4) {
                MusicProviderView.this.S.sendEmptyMessage(3);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.c
        public void b(MusicItemInfo musicItemInfo) {
            Message obtainMessage = MusicProviderView.this.S.obtainMessage();
            obtainMessage.obj = musicItemInfo;
            obtainMessage.what = 4;
            MusicProviderView.this.S.sendMessage(obtainMessage);
        }
    }

    public MusicProviderView(Context context) {
        super(context);
        this.R = 0;
        this.S = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.V = 0;
        this.W = -1;
        this.f67249a0 = -1;
        this.f67250b0 = true;
        this.f67252d0 = false;
        this.f67254f0 = null;
        this.f67255g0 = true;
        this.f67256h0 = false;
        this.f67257i0 = new a();
        this.f67258j0 = new b();
        this.f67259k0 = new c();
        this.f67260l0 = new d();
    }

    private void F(MusicItemInfo musicItemInfo) {
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.R(107, musicItemInfo);
        }
    }

    public static int G(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3) {
            return 5;
        }
        if (i3 == 4 || i3 == 12 || i3 == 8) {
            return 3;
        }
        if (i3 == 11) {
            return 4;
        }
        return 2;
    }

    private List<i> H(List<i> list) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder(64);
        for (i iVar : list) {
            if (iVar.f66744i) {
                arrayList.add(iVar);
                sb5.append(iVar.f66742f);
                sb5.append(",");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "filterMusicList, ", sb5.toString());
        }
        return arrayList;
    }

    public static MusicItemInfo I(String str) {
        ArrayList<i> w3;
        if (!TextUtils.isEmpty(str) && (w3 = ((QIMMusicConfigManager) f.c(2)).w()) != null) {
            for (int i3 = 0; i3 < w3.size(); i3++) {
                i iVar = w3.get(i3);
                if (iVar != null && iVar.f66743h != null) {
                    for (int i16 = 0; i16 < iVar.f66743h.size(); i16++) {
                        MusicItemInfo musicItemInfo = iVar.f66743h.get(i16);
                        if (musicItemInfo != null && str.equals(musicItemInfo.getLocalPath())) {
                            return musicItemInfo;
                        }
                    }
                }
            }
        }
        return null;
    }

    private void J(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "initData");
        }
        List<i> w3 = ((QIMMusicConfigManager) f.c(2)).w();
        if (w3 != null) {
            w3 = H(w3);
        }
        MusicItemInfo musicItemInfo = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle(MusicProviderView.class.getSimpleName()) : null;
        if (bundle2 != null && w3 != null) {
            this.V = bundle2.getInt(AEEditorConstants.CAPTURE_MODE, 0);
            MusicItemInfo musicItemInfo2 = (MusicItemInfo) bundle2.getParcelable(AEEditorConstants.SELECT_MUSIC);
            String string = bundle2.getString(AEEditorConstants.SELECT_MUSIC_LOCAL_PATH);
            if (musicItemInfo2 != null && !TextUtils.isEmpty(string)) {
                musicItemInfo2.setPath(string);
            }
            this.U = null;
            if (musicItemInfo2 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("MusicProviderView", 2, "restore music" + musicItemInfo2.mMusicName);
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= w3.size()) {
                        break;
                    }
                    i iVar = w3.get(i3);
                    if (iVar.f66742f.equals(musicItemInfo2.mTagName)) {
                        for (int i16 = 0; i16 < iVar.f66743h.size(); i16++) {
                            if (musicItemInfo2.equals(iVar.f66743h.get(i16))) {
                                this.W = i3;
                                this.f67249a0 = i16;
                            }
                        }
                    } else {
                        i3++;
                    }
                }
            }
            musicItemInfo = musicItemInfo2;
        }
        if (musicItemInfo == null) {
            new MusicItemInfo().mType = 2;
        }
        this.f67250b0 = true;
    }

    private void Q() {
        if (this.P == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int f16 = this.P.f();
        for (int i3 = 0; i3 < f16; i3++) {
            GridView d16 = this.P.d(i3);
            if (d16 != null) {
                int childCount = d16.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    ((com.tencent.aelight.camera.aioeditor.capture.adapter.d) d16.getAdapter()).c(d16.getChildAt(i16));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "updateUI cost " + (SystemClock.uptimeMillis() - uptimeMillis));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void A() {
        g gVar;
        if (f.d().h(5)) {
            ((com.tencent.aelight.camera.aioeditor.capture.data.d) f.d().g(5)).G(this);
        }
        if (this.K != 0 || (gVar = this.f67251c0) == null) {
            return;
        }
        this.f67254f0 = gVar.j();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onStop  mSaveMusicInfo=");
            MusicItemInfo musicItemInfo = this.f67254f0;
            Object obj = musicItemInfo;
            if (musicItemInfo != null) {
                obj = musicItemInfo.mMusicName;
            }
            sb5.append(obj);
            QLog.d("MusicProviderView", 2, sb5.toString());
        }
        this.f67251c0.r(this.K);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void C(Bundle bundle) {
        super.C(bundle);
        J(bundle);
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) f.c(5)).k(this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void D(int i3, String str, String str2) {
        int i16;
        MusicItemInfo musicItemInfo;
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "selectCategoryAndItem category= " + i3 + " categoryName= " + str + ",itemId=" + str2);
        }
        final int i17 = 0;
        int i18 = 0;
        while (true) {
            i16 = -1;
            if (i18 >= this.Q.size()) {
                i18 = 0;
                break;
            } else if ((i3 != -1 && this.Q.get(i18).f66740d == i3) || (str != null && str.equals(this.Q.get(i18).f66742f))) {
                break;
            } else {
                i18++;
            }
        }
        r().onTabChecked(i18);
        i iVar = this.Q.get(this.N.getCurrentItem());
        try {
            i16 = Integer.valueOf(str2).intValue();
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "selectCategoryAndItem itemID= " + i16);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        int i19 = 0;
        while (true) {
            if (i19 >= iVar.f66743h.size()) {
                musicItemInfo = null;
                break;
            }
            musicItemInfo = iVar.f66743h.get(i19);
            if (musicItemInfo.mItemId == i16) {
                i17 = i19;
                break;
            }
            i19++;
        }
        if (musicItemInfo != null && QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, hashCode() + "selectCategoryAndItem itemInfo= " + musicItemInfo.mMusicName + ",index=" + i18 + ",pos=" + i17);
        }
        if (musicItemInfo != null) {
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView.5
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = MusicProviderView.this.N.getCurrentItem();
                    GridView e17 = MusicProviderView.this.P.e(currentItem);
                    if (e17 != null) {
                        e17.setSelection(i17);
                        MusicProviderView musicProviderView = MusicProviderView.this;
                        musicProviderView.W = currentItem;
                        musicProviderView.f67249a0 = i17;
                        if (QLog.isColorLevel()) {
                            QLog.d("MusicProviderView", 2, "selectCategoryAndItem setSelection= " + currentItem + " position=" + i17);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("MusicProviderView", 2, "gridView is null item= " + currentItem);
                    }
                }
            }, 500L);
            N(musicItemInfo);
            Q();
        }
    }

    public boolean K() {
        return this.f67255g0;
    }

    public boolean L() {
        g gVar = this.f67251c0;
        if (gVar == null) {
            return false;
        }
        return gVar.n();
    }

    public void M() {
        int i3 = this.W;
        if (i3 != -1) {
            this.N.setCurrentItem(i3);
            this.C.onTabChecked(this.W);
        }
    }

    public void P(boolean z16) {
        if (!s()) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "updateData MusicProviderView not init");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "updateData");
        }
        QIMMusicConfigManager qIMMusicConfigManager = (QIMMusicConfigManager) f.c(2);
        int currentItem = this.N.getCurrentItem();
        ArrayList<i> x16 = qIMMusicConfigManager.x(z16);
        this.Q = x16;
        this.Q = H(x16);
        ArrayList<QIMSlidingItemView.a> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            QIMSlidingItemView.a aVar = new QIMSlidingItemView.a();
            aVar.f67310a = this.Q.get(i3).f66742f;
            if (this.Q.get(i3).f66740d == 999) {
                aVar.f67311b = R.drawable.egm;
                aVar.f67312c = R.drawable.egn;
            } else {
                aVar.f67311b = 0;
                aVar.f67312c = 0;
            }
            arrayList.add(aVar);
        }
        this.C.initTabItemsWithIconString(arrayList);
        this.P.h(this.Q);
        this.P.notifyDataSetChanged();
        this.N.setAdapter(this.P);
        this.C.onTabChecked(currentItem);
        this.N.setCurrentItem(currentItem);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a2, code lost:
    
        return false;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                boolean z16 = true;
                if (getContext() instanceof AppActivity) {
                    z16 = true ^ ((AppActivity) getContext()).isResume();
                } else if (!(getContext() instanceof BaseActivity) || ((BaseActivity) getContext()).isResume()) {
                    z16 = false;
                }
                O(this.T, z16);
                Q();
                break;
            case 2:
                Q();
                break;
            case 3:
                P(false);
                break;
            case 4:
                Object obj = message.obj;
                if (obj != null) {
                    F((MusicItemInfo) obj);
                    break;
                }
                break;
            case 5:
                QQToast.makeText(this.f67276d, HardCodeUtil.qqStr(R.string.ocm), 0).show();
                Q();
                break;
            case 6:
                MusicItemInfo musicItemInfo = (MusicItemInfo) message.obj;
                if (!musicItemInfo.isFileExist()) {
                    if (musicItemInfo.isDownloading()) {
                        g gVar = this.f67251c0;
                        if (gVar != null) {
                            gVar.g(musicItemInfo);
                        }
                        MusicItemInfo musicItemInfo2 = this.T;
                        if (musicItemInfo2 != null && TextUtils.equals(musicItemInfo2.mMusicName, musicItemInfo.mMusicName)) {
                            QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.qqStr(R.string.ocn), 0).show();
                        }
                        Q();
                        break;
                    }
                } else {
                    com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).i();
                    break;
                }
                break;
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        if (this.N.getCurrentItem() >= this.Q.size()) {
            return;
        }
        i iVar = this.Q.get(this.N.getCurrentItem());
        if (i3 >= iVar.f66743h.size()) {
            return;
        }
        ((QIMMusicConfigManager) f.c(2)).M = iVar;
        MusicItemInfo musicItemInfo = iVar.f66743h.get(i3);
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "onItemClick,  type:" + musicItemInfo.mType + "  " + musicItemInfo);
        }
        if (musicItemInfo.mType == 4) {
            Activity activity = (Activity) getContext();
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            int G = G(this.L);
            intent.putExtra("url", String.format(AEEditorConstants.QIM_LOAD_QQ_MUSIC_URL, ah.z(), "", Integer.valueOf(G)));
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 1, "music busType:", Integer.valueOf(G));
            }
            if (SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 3, 3);
            }
            intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            activity.startActivityForResult(intent, 1001);
            activity.overridePendingTransition(R.anim.f154424l, 0);
            return;
        }
        if (musicItemInfo.isWsBanner()) {
            l.g(this.f67276d, musicItemInfo, 2);
            return;
        }
        int i16 = musicItemInfo.mType;
        if (i16 == 3) {
            if (SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 3, 2);
            }
        } else if (i16 == 1 && SlideShowPhotoListManager.n().m() == 22) {
            LpReportInfo_pf00064.allReport(680, 3, 4);
        }
        g gVar = this.f67251c0;
        MusicItemInfo m3 = gVar != null ? gVar.m() : null;
        if (musicItemInfo.mType == 5 && (musicItemInfo.equals(m3) || !musicItemInfo.isFileExist())) {
            F(musicItemInfo);
            return;
        }
        view.setSelected(true);
        this.T = musicItemInfo;
        N(musicItemInfo);
        Q();
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) f.c(5)).J(this.K, (Activity) this.f67276d);
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageSelected(int i3) {
        this.C.onTabChecked(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    protected int p() {
        return R.layout.ap8;
    }

    public void setChangeMusicEnabled(boolean z16) {
        this.f67255g0 = z16;
    }

    public void setIsGuideMode(boolean z16) {
        this.f67256h0 = z16;
    }

    public void setPreSelectTagIndex(int i3) {
        this.W = i3;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void t(int i3, int i16, Intent intent) {
        int i17;
        g gVar;
        super.t(i3, i16, intent);
        if (i3 == 1001) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "doOnActivityResult qqMusic resultCode = " + i16 + ", data = " + intent);
                return;
            }
            return;
        }
        if (i16 == 0 && (i17 = this.K) == 0 && (gVar = this.f67251c0) != null) {
            MusicItemInfo musicItemInfo = this.f67254f0;
            if (musicItemInfo == null) {
                gVar.z(i17);
                return;
            }
            if (musicItemInfo != null) {
                if (this.f67255g0 && !this.f67256h0) {
                    gVar.x(musicItemInfo, i17);
                } else {
                    gVar.u(musicItemInfo);
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void u() {
        super.u();
        g gVar = this.f67251c0;
        if (gVar != null) {
            gVar.z(this.K);
        }
        this.T = null;
        this.U = null;
        f67248m0 = false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void v(Bundle bundle) {
        int i3;
        super.v(bundle);
        this.C.setTabCheckListener(this);
        this.C.setIndicateColor(getContext().getResources().getColor(R.color.f157748yb));
        View view = this.D;
        if (view == null) {
            this.N = (BounceViewPager) LayoutInflater.from(getContext()).inflate(R.layout.ap8, (ViewGroup) this, false);
        } else {
            this.N = (BounceViewPager) view;
        }
        e eVar = new e(this.f67276d, this);
        this.P = eVar;
        eVar.h(new ArrayList());
        this.P.g(this);
        this.N.g(this);
        this.N.setAdapter(this.P);
        l(this.N);
        new br(this.f67276d).a(this.N);
        P(false);
        M();
        this.f67277e.registObserver(this.f67257i0);
        QIMMusicConfigManager qIMMusicConfigManager = (QIMMusicConfigManager) f.c(2);
        qIMMusicConfigManager.m(this.f67260l0);
        qIMMusicConfigManager.r();
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) f.c(5)).k(this);
        if (this.f67251c0 == null) {
            this.f67251c0 = (g) f.d().g(8);
        }
        this.f67251c0.f(this.f67259k0);
        g gVar = this.f67251c0;
        if (this.K == 0) {
            i3 = com.tencent.mobileqq.filter.f.f209752b;
        } else {
            i3 = com.tencent.mobileqq.filter.f.f209753c;
        }
        gVar.C(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void w() {
        g gVar;
        super.w();
        AppInterface appInterface = this.f67277e;
        if (appInterface != null) {
            appInterface.unRegistObserver(this.f67257i0);
        }
        BounceViewPager bounceViewPager = this.N;
        if (bounceViewPager != null) {
            bounceViewPager.h(this);
        }
        ((QIMMusicConfigManager) f.c(2)).G(this.f67260l0);
        if (this.K == 0 && (gVar = this.f67251c0) != null) {
            gVar.i();
        }
        g gVar2 = this.f67251c0;
        if (gVar2 != null) {
            gVar2.t(this.f67259k0);
            this.f67251c0 = null;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void x() {
        super.x();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void y() {
        super.y();
        if (QLog.isColorLevel()) {
            QLog.i("MusicProviderView", 2, "onProviderShow isAccountChange=" + this.f67252d0 + " isInit=" + s());
        }
        if (this.f67252d0 && s()) {
            P(false);
        } else {
            Q();
        }
        this.f67252d0 = false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void z() {
        g gVar;
        MusicItemInfo j3;
        int i3;
        super.z();
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "music tab onResume");
        }
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) f.c(5)).k(this);
        g gVar2 = this.f67251c0;
        if (gVar2 != null) {
            gVar2.f(this.f67259k0);
            g gVar3 = this.f67251c0;
            if (this.K == 0) {
                i3 = com.tencent.mobileqq.filter.f.f209752b;
            } else {
                i3 = com.tencent.mobileqq.filter.f.f209753c;
            }
            gVar3.C(i3);
        }
        if (this.K == 0 && (gVar = this.f67251c0) != null && this.f67255g0 && (j3 = gVar.j()) != null && j3.mRecognitionOffset == -1.0f && !this.f67256h0) {
            this.f67251c0.A();
        }
        if (this.P == null || this.N == null) {
            return;
        }
        P(true);
    }

    public void N(MusicItemInfo musicItemInfo) {
        O(musicItemInfo, false);
    }

    public void O(MusicItemInfo musicItemInfo, boolean z16) {
        if (musicItemInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "startMusic itemInfo=null");
                return;
            }
            return;
        }
        if (this.f67251c0 == null) {
            this.f67251c0 = (g) f.d().g(8);
        }
        if (this.f67251c0.h(musicItemInfo)) {
            int i3 = this.K;
            if (i3 == 0 && !z16) {
                this.f67251c0.x(musicItemInfo, i3);
            } else {
                this.f67251c0.u(musicItemInfo);
                ProviderView.a aVar = this.M;
                if (aVar != null) {
                    aVar.H(!z16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "startMusic checkMusicCanPlay mCaptureScene" + this.K);
                return;
            }
            return;
        }
        this.T = musicItemInfo;
        this.f67251c0.v(musicItemInfo, this.f67258j0);
        this.S.removeCallbacksAndMessages(musicItemInfo);
        this.S.sendMessageDelayed(Message.obtain(this.S, 6, musicItemInfo), 60000L);
        com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).g();
        if (QLog.isColorLevel()) {
            QLog.d("MusicProviderView", 2, "startMusic requestDownLoadMusicInfo" + this.K);
        }
    }

    /* loaded from: classes32.dex */
    class c implements com.tencent.aelight.camera.aioeditor.capture.music.e {
        c() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void a() {
            MusicProviderView.this.S.sendEmptyMessage(2);
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void g(MusicItemInfo musicItemInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "requestMusicSuccess mListener= " + MusicProviderView.this.M);
            }
            ProviderView.a aVar = MusicProviderView.this.M;
            if (aVar != null) {
                if (musicItemInfo.mType == 2) {
                    aVar.J(true);
                } else {
                    aVar.J(false);
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void b(int i3, MusicItemInfo musicItemInfo) {
            if (i3 == -1 || MusicProviderView.this.f67251c0 == null) {
                return;
            }
            MusicProviderView.this.f67251c0.F();
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void c(MusicItemInfo musicItemInfo) {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void d(int i3, MusicItemInfo musicItemInfo) {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void e(int i3, MusicItemInfo musicItemInfo) {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void f(int i3, MusicItemInfo musicItemInfo) {
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void j(h hVar, boolean z16, int i3, Bundle bundle) {
        g gVar;
        if (!z16 || (gVar = this.f67251c0) == null) {
            return;
        }
        gVar.F();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.c
    public void onTabChecked(int i3) {
        if (i3 < 0 || i3 > this.Q.size()) {
            return;
        }
        this.R = i3;
        this.N.setCurrentItem(i3);
    }

    /* loaded from: classes32.dex */
    class b extends qs.e {
        b() {
        }

        @Override // qs.e
        public void c(String str, boolean z16, int i3) {
            MusicItemInfo musicItemInfo;
            if (QLog.isColorLevel()) {
                QLog.d("MusicProviderView", 2, "onFinish, succ:", Boolean.valueOf(z16), ", failcode:", Integer.valueOf(i3));
            }
            MusicProviderView.this.S.sendEmptyMessage(2);
            if (z16 && (musicItemInfo = MusicProviderView.this.T) != null && musicItemInfo.getLocalPath().equals(str)) {
                MusicProviderView.this.S.sendEmptyMessage(1);
            }
            if (z16 || i3 != -104) {
                return;
            }
            MusicProviderView.this.S.sendEmptyMessage(5);
        }

        @Override // qs.e
        public void e(String str, int i3) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MusicProviderView musicProviderView = MusicProviderView.this;
            long j3 = musicProviderView.f67253e0;
            if (j3 == 0 || uptimeMillis - j3 > 16) {
                musicProviderView.S.sendEmptyMessage(2);
                MusicProviderView.this.f67253e0 = uptimeMillis;
            }
        }

        @Override // qs.e
        public void f(String str, boolean z16) {
            MusicProviderView.this.S.sendEmptyMessage(2);
        }

        @Override // qs.e
        public void b(String str) {
        }

        @Override // qs.e
        public void d(int i3) {
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void e(m.a aVar) {
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void f(h hVar) {
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrollStateChanged(int i3) {
    }

    @Override // com.tencent.mobileqq.widget.bounce.BounceViewPager.b
    public void onPageScrolled(int i3, float f16, int i16) {
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void d(j jVar, boolean z16, int i3, Bundle bundle) {
    }
}
