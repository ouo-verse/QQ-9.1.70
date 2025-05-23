package com.tencent.mobileqq.richmediabrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.c;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.g;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes18.dex */
public class AIOBrowserPresenter extends MainBrowserPresenter implements g, c.b, Handler.Callback, com.tencent.mobileqq.comment.danmaku.c, com.tencent.mobileqq.comment.danmaku.b {
    private com.tencent.mobileqq.comment.f D;
    private com.tencent.mobileqq.comment.danmaku.a E;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    public AIOBrowserScene f281849d;

    /* renamed from: e, reason: collision with root package name */
    public tm2.a f281850e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f281851f;

    /* renamed from: m, reason: collision with root package name */
    private String f281854m;

    /* renamed from: h, reason: collision with root package name */
    private int f281852h = 30000;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f281853i = false;
    private AtomicBoolean C = new AtomicBoolean(false);
    private CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.richmediabrowser.view.a>> F = new CopyOnWriteArrayList<>();

    public AIOBrowserPresenter(int i3) {
        this.G = i3;
    }

    public static void D(String str) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    private void Z(com.tencent.mobileqq.comment.f fVar) {
        this.D = fVar;
    }

    private boolean g() {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo selectedItem = this.f281850e.getSelectedItem();
        if (selectedItem == null || (richMediaBaseData = selectedItem.baseData) == null) {
            return false;
        }
        if (!(richMediaBaseData instanceof AIOFilePictureData) && !(richMediaBaseData instanceof AIOPictureData)) {
            return false;
        }
        return true;
    }

    private int i(String str) {
        if (!"0X8009EFC".equals(str) && !"0X800A418".equals(str) && !"0X800A419".equals(str) && !"0X800A41A".equals(str) && !"0X800A41B".equals(str) && !"0X800A41C".equals(str) && !"0X800A41D".equals(str) && !"0X800A41E".equals(str)) {
            "0X8009EFD".equals(str);
            return -1;
        }
        return 4;
    }

    private int k(String str) {
        if (!"0X8009EFC".equals(str) && !"0X800A418".equals(str) && !"0X800A419".equals(str) && !"0X800A41A".equals(str) && !"0X800A41B".equals(str) && !"0X800A41C".equals(str) && !"0X800A41D".equals(str) && !"0X800A41E".equals(str)) {
            if ("0X8009EFD".equals(str)) {
                return 4;
            }
            if ("0X800A882".equals(str)) {
                return 2;
            }
            return -1;
        }
        return 5;
    }

    private int l() {
        int f16 = h.a().f();
        if (f16 == 0) {
            return 1;
        }
        if (f16 != 1) {
            if (f16 != 1000 && f16 != 1008 && f16 != 2016 && f16 != 1010 && f16 != 1011) {
                switch (f16) {
                    case 1020:
                    case 1021:
                    case 1022:
                    case 1023:
                    case 1024:
                        break;
                    default:
                        return 4;
                }
            }
            return 3;
        }
        return 2;
    }

    private int n(String str) {
        int c16 = h.a().c();
        if (c16 == 1) {
            return 1;
        }
        if (c16 != 2) {
            if (c16 != 3) {
                if (c16 == 5) {
                    if (!"0X8009EFC".equals(str) && !"0X800A418".equals(str) && !"0X800A419".equals(str) && !"0X800A41A".equals(str) && !"0X800A41B".equals(str) && !"0X800A41C".equals(str) && !"0X800A41D".equals(str) && !"0X800A41E".equals(str)) {
                        if ("0X8009EFD".equals(str)) {
                            return 5;
                        }
                    } else {
                        return 6;
                    }
                }
                return -1;
            }
            return i(str);
        }
        return k(str);
    }

    private int o() {
        RichMediaBaseData richMediaBaseData;
        int i3;
        RichMediaBrowserInfo selectedItem = this.f281850e.getSelectedItem();
        if (selectedItem == null || (richMediaBaseData = selectedItem.baseData) == null) {
            return -1;
        }
        if (richMediaBaseData instanceof AIOFilePictureData) {
            return 2;
        }
        if (richMediaBaseData instanceof AIOPictureData) {
            if (!((AIOPictureData) richMediaBaseData).isFromFile) {
                return 1;
            }
        } else {
            if (richMediaBaseData instanceof AIOVideoData) {
                int i16 = ((AIOVideoData) richMediaBaseData).f281846h;
                if (i16 == 0) {
                    i3 = 4;
                } else {
                    if (i16 != 1) {
                        return -1;
                    }
                    i3 = 3;
                }
                return i3;
            }
            if (!(richMediaBaseData instanceof AIOFileVideoData)) {
                return -1;
            }
        }
        return 5;
    }

    private int p(String str) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo selectedItem = this.f281850e.getSelectedItem();
        if (selectedItem == null || (richMediaBaseData = selectedItem.baseData) == null) {
            return -1;
        }
        if (richMediaBaseData instanceof AIOVideoData) {
            int i3 = ((AIOVideoData) richMediaBaseData).f281846h;
            if (i3 == 0) {
                if (!"0X800A99B".equals(str) && !"0X800A9B5".equals(str)) {
                    if (!"0X8009AA6".equals(str)) {
                        return -1;
                    }
                } else {
                    return 2;
                }
            } else {
                if (i3 != 1) {
                    return -1;
                }
                if (!"0X800A99B".equals(str) && !"0X800A9B5".equals(str) && !"0X8009AA6".equals(str)) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(richMediaBaseData instanceof AIOFileVideoData)) {
            return -1;
        }
        if (!"0X800A99B".equals(str) && !"0X800A9B5".equals(str)) {
            return -1;
        }
        return 3;
    }

    private int s(boolean z16) {
        if (z16) {
            if (com.tencent.mobileqq.richmediabrowser.utils.h.a()) {
                return 2;
            }
        } else if (com.tencent.mobileqq.richmediabrowser.utils.h.c()) {
            return 2;
        }
        return 1;
    }

    private void t() {
        com.tencent.mobileqq.comment.c.registerModule();
        com.tencent.mobileqq.comment.c.c().b(this);
        Z(com.tencent.mobileqq.comment.c.c());
        com.tencent.mobileqq.comment.danmaku.a aVar = this.E;
        if (aVar != null) {
            aVar.t(this);
            com.tencent.mobileqq.comment.danmaku.a aVar2 = this.E;
            AIOBrowserScene aIOBrowserScene = this.f281849d;
            aVar2.m(((MainBrowserScene) aIOBrowserScene).mContext, aIOBrowserScene.f281943e);
            this.E.u();
        }
    }

    public void A(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17, Bundle bundle) {
        tm2.a aVar = this.f281850e;
        if (aVar != null) {
            c04.b decoratorPresenter = getDecoratorPresenter(aVar.j(j3, i3));
            if (decoratorPresenter instanceof a) {
                ((a) decoratorPresenter).E(j3, i3, i16, str, strArr, str2, messageRecord, i17, bundle);
            }
        }
    }

    public void B(boolean z16) {
        com.tencent.mobileqq.comment.danmaku.a aVar = this.E;
        if (aVar != null && aVar.n() && this.f281849d != null) {
            this.E.o();
            this.f281849d.u(z16);
        }
    }

    public void C() {
        if (this.C.compareAndSet(false, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    QQSysFaceUtil.preLoadEmoDrawable();
                }
            }, 128, null, true);
        }
    }

    public void E() {
        String str;
        int o16 = o();
        if (g()) {
            str = "0X800C48D";
        } else {
            str = "0X800C491";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, o16, 0, "" + l(), "3", "", "");
    }

    public void F() {
        String str;
        int o16 = o();
        boolean g16 = g();
        if (g16) {
            str = "0X800C48E";
        } else {
            str = "0X800C492";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, o16, 0, "" + l(), String.valueOf(s(g16)), "", "");
    }

    public void G() {
        ReportController.o(null, "dc00898", "", "", "0X800A41B", "0X800A41B", o(), 0, "" + l(), "" + n("0X800A41B"), "", "");
    }

    public void H() {
        ReportController.o(null, "dc00898", "", "", "0X800A882", "0X800A882", o(), 0, "" + n("0X800A882"), "", "", "");
    }

    public void I() {
        ReportController.o(null, "dc00898", "", "", "0X800A418", "0X800A418", o(), 0, "" + l(), "" + n("0X800A418"), "", "");
    }

    public void J() {
        ReportController.o(null, "dc00898", "", "", "0X800A41A", "0X800A41A", o(), 0, "" + l(), "" + n("0X800A41A"), "", "");
    }

    public void K() {
        ReportController.o(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", o(), 0, "" + l(), "" + n("0X8009EFC"), "", "");
    }

    public void L() {
        ReportController.o(null, "dc00898", "", "", "0X800A7C0", "0X800A7C0", o(), 0, "" + l(), "" + n("0X8009EFC"), "", "");
        R(2);
    }

    public void M() {
        String str;
        ReportController.o(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", o(), 0, "" + l(), "" + n("0X8009EFD"), "", "");
        int o16 = o();
        if (g()) {
            str = "0X800C48D";
        } else {
            str = "0X800C491";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, o16, 0, "" + l(), "2", "", "");
    }

    public void N() {
        ReportController.o(null, "dc00898", "", "", "0X800A419", "0X800A419", o(), 0, "" + l(), "" + n("0X800A419"), "", "");
    }

    public void O() {
        String str;
        int o16 = o();
        boolean g16 = g();
        if (g16) {
            str = "0X800C48C";
        } else {
            str = "0X800C490";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, o16, 0, "" + l(), String.valueOf(s(g16)), "", "");
    }

    public void P(int i3) {
        ReportController.o(null, "dc00898", "", "", "0X800C48F", "0X800C48F", o(), 0, "" + l(), String.valueOf(i3), "", "");
    }

    public void Q() {
        String str;
        int o16 = o();
        if (g()) {
            str = "0X800C48D";
        } else {
            str = "0X800C491";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, o16, 0, "" + l(), "1", "", "");
    }

    public void R(int i3) {
        ReportController.o(null, "dc00898", "", "", "0X800C493", "0X800C493", o(), 0, "" + l(), String.valueOf(i3), "", "");
    }

    public void S() {
        ReportController.o(null, "dc00898", "", "", "0X800A41C", "0X800A41C", o(), 0, "" + l(), "" + n("0X800A41C"), "", "");
    }

    public void T() {
        ReportController.o(null, "dc00898", "", "", "0X800C491", "0X800C491", o(), 0, "" + l(), "4", "", "");
    }

    public void U(long j3, long j16, String str) {
        ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).reportVideoPlayEvent(l(), str, 2, p("0X8009AA6"), j3, j16);
    }

    public void V() {
        ReportController.o(null, "dc00898", "", "", "0X800A41D", "0X800A41D", o(), 0, "" + l(), "" + n("0X800A41D"), "", "");
    }

    public void W() {
        com.tencent.mobileqq.comment.danmaku.a aVar = this.E;
        if (aVar != null && !aVar.n() && this.f281849d != null) {
            this.E.p();
            this.f281849d.u(true);
        }
    }

    public void X(tm2.a aVar) {
        super.setBrowserModel(aVar);
        this.f281850e = aVar;
    }

    public void Y(AIOBrowserScene aIOBrowserScene) {
        super.setBrowserScene(aIOBrowserScene);
        this.f281849d = aIOBrowserScene;
    }

    @Override // com.tencent.mobileqq.comment.danmaku.b
    public void a() {
        this.f281853i = true;
    }

    public void a0(int i3) {
        this.G = i3;
    }

    @Override // com.tencent.mobileqq.comment.danmaku.b
    public void b() {
        if (this.f281853i) {
            c04.b currentDecoratorPresenter = getCurrentDecoratorPresenter();
            if ((currentDecoratorPresenter instanceof a) && this.E != null) {
                BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmakuDrawFinish");
                ((a) currentDecoratorPresenter).F();
                this.E.r(null);
            }
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, f04.b
    public void buildComplete() {
        if (com.tencent.mobileqq.richmediabrowser.d.i()) {
            com.tencent.mobileqq.danmaku.a.a();
            this.E = new com.tencent.mobileqq.comment.danmaku.a();
            this.f281851f = new Handler(Looper.getMainLooper(), this);
            this.f281854m = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            t();
        }
        super.buildComplete();
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, f04.b
    public void buildParams(Intent intent) {
        Bundle extras;
        AIOBrowserBaseData aIOBrowserBaseData;
        if (intent != null && (extras = intent.getExtras()) != null && (aIOBrowserBaseData = (AIOBrowserBaseData) extras.getParcelable(RichMediaBrowserConstants.INTERNAL_EXTRA_CURRENT_IMAGE)) != null) {
            RichMediaBrowserInfo richMediaBrowserInfo = new RichMediaBrowserInfo();
            richMediaBrowserInfo.baseData = aIOBrowserBaseData;
            if (this.f281850e.n(richMediaBrowserInfo)) {
                this.f281850e.a(richMediaBrowserInfo, extras.getBoolean(ShortVideoConstants.IS_AUTO_PLAY, true));
                boolean z16 = extras.getBoolean(ShortVideoConstants.MUTE_PLAY);
                this.f281850e.f436601e.e(z16);
                if (z16) {
                    this.f281850e.c(richMediaBrowserInfo);
                }
                long j3 = extras.getLong(ShortVideoConstants.CLICK_VIDEO_BUBBLE_TIME);
                if (j3 > 0) {
                    this.f281850e.b(richMediaBrowserInfo, j3);
                }
            }
            this.f281850e.l(richMediaBrowserInfo);
            if (h.a().v()) {
                this.f281850e.q(true);
            }
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).addMsgRevokerListener(this);
    }

    @Override // com.tencent.mobileqq.comment.c.b
    public void d(long j3, String str, DanmuItemBean danmuItemBean) {
        if (NetworkUtil.isNetworkAvailable() && danmuItemBean != null && u(j3) && this.E != null) {
            C();
            this.E.h(danmuItemBean);
        }
    }

    @Override // com.tencent.mobileqq.comment.danmaku.c
    public long e() {
        c04.b currentDecoratorPresenter = getCurrentDecoratorPresenter();
        if (currentDecoratorPresenter instanceof a) {
            return ((a) currentDecoratorPresenter).s();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.comment.c.b
    public void f(long j3, String str, int i3, List<DanmuItemBean> list) {
        if (i3 > 0) {
            this.f281852h = i3 * 1000;
        }
        if (!this.f281853i && (list == null || list.isEmpty())) {
            c04.b currentDecoratorPresenter = getCurrentDecoratorPresenter();
            if ((currentDecoratorPresenter instanceof a) && this.E != null) {
                BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onDanmuListChange onDanmakuDrawFinish");
                ((a) currentDecoratorPresenter).F();
                this.E.r(null);
            }
        }
        if (list != null && list.size() > 0 && u(j3)) {
            c04.b currentDecoratorPresenter2 = getCurrentDecoratorPresenter();
            if ((currentDecoratorPresenter2 instanceof a) && this.E != null && this.f281850e != null) {
                C();
                RichMediaBrowserInfo selectedItem = this.f281850e.getSelectedItem();
                if (selectedItem != null && selectedItem.baseData != null) {
                    List<com.tencent.common.danmaku.data.a> arrayList = new ArrayList<>();
                    switch (selectedItem.baseData.getType()) {
                        case 100:
                        case 102:
                            arrayList = com.tencent.mobileqq.richmediabrowser.d.a(j3, list, m(), ((a) currentDecoratorPresenter2).f281862i);
                            break;
                        case 101:
                        case 103:
                            a aVar = (a) currentDecoratorPresenter2;
                            arrayList = com.tencent.mobileqq.richmediabrowser.d.b(j3, list, m(), aVar.f281862i, aVar.s());
                            break;
                    }
                    this.E.g(arrayList);
                }
            }
        }
    }

    public CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.richmediabrowser.view.a>> h() {
        return this.F;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return true;
    }

    public com.tencent.mobileqq.comment.danmaku.a m() {
        return this.E;
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, e04.a
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        AIOBrowserScene aIOBrowserScene = this.f281849d;
        if (aIOBrowserScene != null) {
            aIOBrowserScene.n(i3, i16, intent);
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, e04.a
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c04.b decoratorPresenter = getDecoratorPresenter(getCurrentType());
        if (decoratorPresenter instanceof a) {
            ((a) decoratorPresenter).onConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, e04.a
    public void onDestroy() {
        Handler handler = this.f281851f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).removeMsgRevokerListener(this);
        com.tencent.mobileqq.comment.c.c().e(this);
        com.tencent.mobileqq.comment.danmaku.a aVar = this.E;
        if (aVar != null) {
            aVar.k();
            this.E = null;
        }
        com.tencent.mobileqq.comment.f fVar = this.D;
        if (fVar != null) {
            fVar.a();
            this.D = null;
        }
        for (c04.b bVar : this.decoratorPresenterMap.values()) {
            if (bVar instanceof a) {
                a aVar2 = (a) bVar;
                aVar2.onDestroy();
                com.tencent.mobileqq.richmediabrowser.view.a aVar3 = aVar2.f281860f;
                if (aVar3 != null) {
                    aVar3.t();
                }
            }
        }
        this.decoratorPresenterMap.clear();
        AIOBrowserScene aIOBrowserScene = this.f281849d;
        if (aIOBrowserScene != null) {
            aIOBrowserScene.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter
    public void onDoubleTap() {
        super.onDoubleTap();
        I();
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter
    public void onItemSelect(int i3) {
        super.onItemSelect(i3);
        if (this.f281849d != null && v(i3)) {
            c04.b currentDecoratorPresenter = getCurrentDecoratorPresenter();
            if ((currentDecoratorPresenter instanceof a) && this.E != null) {
                ((a) currentDecoratorPresenter).G();
                this.E.r(this);
                this.f281853i = false;
            }
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, e04.a
    public void onPause() {
        super.onPause();
        if (v(getCurrentPosition())) {
            B(true);
        }
        c04.b decoratorPresenter = getDecoratorPresenter(getCurrentType());
        if (decoratorPresenter instanceof a) {
            ((a) decoratorPresenter).onPause();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, e04.a
    public void onResume() {
        super.onResume();
        if (v(getCurrentPosition())) {
            W();
        }
        c04.b decoratorPresenter = getDecoratorPresenter(getCurrentType());
        if (decoratorPresenter instanceof a) {
            ((a) decoratorPresenter).onResume();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter
    public void onScale() {
        super.onScale();
        AIOBrowserScene aIOBrowserScene = this.f281849d;
        if (aIOBrowserScene != null) {
            aIOBrowserScene.u(false);
        }
        if (m() != null) {
            m().o();
            m().i();
        }
        N();
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter
    public void onScaleBegin() {
        super.onScaleBegin();
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, e04.a
    public void onStart() {
        super.onStart();
        c04.b decoratorPresenter = getDecoratorPresenter(getCurrentType());
        if (decoratorPresenter instanceof a) {
            ((a) decoratorPresenter).onStart();
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, e04.a
    public void onStop() {
        super.onStop();
        c04.b decoratorPresenter = getDecoratorPresenter(getCurrentType());
        if (decoratorPresenter instanceof a) {
            ((a) decoratorPresenter).onStop();
        }
    }

    public int q() {
        return this.G;
    }

    public int r(long j3) {
        List<RichMediaBrowserInfo> e16 = this.f281850e.e();
        if (e16 != null) {
            int size = e16.size();
            for (int i3 = 0; i3 < size; i3++) {
                RichMediaBaseData richMediaBaseData = e16.get(i3).baseData;
                if ((richMediaBaseData instanceof AIOBrowserBaseData) && ((AIOBrowserBaseData) richMediaBaseData).msgId == j3) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public boolean u(long j3) {
        RichMediaBrowserInfo item;
        tm2.a aVar = this.f281850e;
        if (aVar == null || (item = aVar.getItem(getCurrentPosition())) == null) {
            return false;
        }
        RichMediaBaseData richMediaBaseData = item.baseData;
        if (!(richMediaBaseData instanceof AIOBrowserBaseData) || j3 != ((AIOBrowserBaseData) richMediaBaseData).shmsgseq) {
            return false;
        }
        return true;
    }

    public boolean v(int i3) {
        if (com.tencent.mobileqq.richmediabrowser.d.h(this.f281850e.getSelectedItem()) && w(i3)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.g
    public void v5(final long j3) {
        boolean z16;
        int r16;
        if (this.f281849d != null) {
            RichMediaBrowserInfo selectedItem = this.f281850e.getSelectedItem();
            if (selectedItem != null && selectedItem.baseData != null) {
                if (h.a().q() && h.a().l() == j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                final boolean z17 = z16;
                if (!z17 && (getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.e)) {
                    ((com.tencent.mobileqq.richmediabrowser.e) getParamsBuilder().c()).B(j3);
                }
                if (!z17) {
                    c04.b decoratorPresenter = getDecoratorPresenter(selectedItem.baseData.getType());
                    if ((decoratorPresenter instanceof a) && (r16 = r(j3)) >= 0) {
                        ((a) decoratorPresenter).H(r16);
                    }
                }
                Context context = ((MainBrowserScene) this.f281849d).mContext;
                if (context instanceof Activity) {
                    RichMediaBaseData richMediaBaseData = selectedItem.baseData;
                    if (richMediaBaseData instanceof AIOBrowserBaseData) {
                        final AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) richMediaBaseData;
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter.2
                            @Override // java.lang.Runnable
                            public void run() {
                                long j16 = j3;
                                if (j16 != aIOBrowserBaseData.msgId && !z17) {
                                    if (AIOBrowserPresenter.this.f281850e.p(j16) == null) {
                                        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg seq:" + j3 + ", selectItem seq:" + aIOBrowserBaseData.msgId);
                                        return;
                                    }
                                    int r17 = AIOBrowserPresenter.this.r(aIOBrowserBaseData.msgId);
                                    if (r17 >= 0 && r17 < AIOBrowserPresenter.this.f281850e.getCount()) {
                                        AIOBrowserPresenter.this.f281850e.setSelectedIndex(r17);
                                        AIOBrowserPresenter.this.f281849d.notifyImageModelDataChanged();
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mobileqq.richmediabrowser.view.a i3 = AIOBrowserPresenter.this.f281849d.i();
                                if (i3 instanceof com.tencent.mobileqq.richmediabrowser.view.a) {
                                    i3.u(j3);
                                }
                                IBrowserDepend iBrowserDepend = (IBrowserDepend) QRoute.api(IBrowserDepend.class);
                                AIOBrowserScene aIOBrowserScene = AIOBrowserPresenter.this.f281849d;
                                iBrowserDepend.buildMessageRevokeUI((Activity) ((MainBrowserScene) aIOBrowserScene).mContext, aIOBrowserScene.mRoot);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "onRevokeMsg exp!");
        }
    }

    public boolean w(int i3) {
        RichMediaBrowserInfo item;
        RichMediaBaseData richMediaBaseData;
        tm2.a aVar = this.f281850e;
        if (aVar == null || (item = aVar.getItem(i3)) == null || (richMediaBaseData = item.baseData) == null) {
            return false;
        }
        if (richMediaBaseData.getType() != 100 && item.baseData.getType() != 101 && item.baseData.getType() != 102 && item.baseData.getType() != 103) {
            return false;
        }
        return true;
    }

    public void x(AIOBrowserBaseData[] aIOBrowserBaseDataArr, int i3) {
        int i16;
        if (aIOBrowserBaseDataArr != null) {
            i16 = aIOBrowserBaseDataArr.length;
        } else {
            i16 = 0;
        }
        BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "notifyImageListChanged list size " + i16 + ", selected " + i3);
        MainBrowserScene mainBrowserScene = this.browserScene;
        if (mainBrowserScene != null) {
            mainBrowserScene.notifyImageModelDataChanged();
        }
    }

    public void y(long j3, int i3, int i16, int i17, long j16, boolean z16) {
        tm2.a aVar;
        int i18;
        if ((i16 == 2 || i16 == 24 || i16 == 4 || i16 == 2 || i16 == 4 || i16 == 1 || i16 == 256 || i16 == 269484035) && (aVar = this.f281850e) != null) {
            if (i16 != 2 && i16 != 4) {
                i18 = aVar.j(j3, i3);
            } else {
                i18 = aVar.i(j3);
            }
            c04.b decoratorPresenter = getDecoratorPresenter(i18);
            if (decoratorPresenter instanceof a) {
                ((a) decoratorPresenter).C(j3, i3, i16, i17, j16, z16);
            }
        }
    }

    public void z(long j3, int i3, int i16, int i17, String str, boolean z16) {
        tm2.a aVar;
        int i18;
        if ((i16 == 2 || i16 == 24 || i16 == 4 || i16 == 2 || i16 == 4 || i16 == 256 || i16 == 1 || i16 == 0 || i16 == 269484034) && (aVar = this.f281850e) != null) {
            if (i16 != 2 && i16 != 4 && i16 != 269484034) {
                i18 = aVar.j(j3, i3);
            } else {
                i18 = aVar.i(j3);
            }
            c04.b decoratorPresenter = getDecoratorPresenter(i18);
            if (decoratorPresenter instanceof a) {
                ((a) decoratorPresenter).D(j3, i3, i16, i17, str, z16);
            }
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.MainBrowserPresenter, f04.b
    public void buildPresenter() {
    }
}
