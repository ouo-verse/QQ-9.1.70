package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import c04.c;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.video.VideoView;
import com.tencent.widget.immersive.ImmersiveUtils;
import e04.d;
import e04.e;
import e04.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements c, e, e04.c, d, e04.b, f {
    public ImageButton C;
    public ImageButton D;
    public ImageButton E;
    public ImageButton F;
    public View G;
    public RelativeLayout H;
    public BrowserBaseView I;
    public int J;
    public int K;
    public int L;
    public int M;
    protected long N;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.mobileqq.richmediabrowser.presenter.a f282074d;

    /* renamed from: e, reason: collision with root package name */
    public ShareActionSheet f282075e;

    /* renamed from: h, reason: collision with root package name */
    public Context f282077h;

    /* renamed from: i, reason: collision with root package name */
    public ImageButton f282078i;

    /* renamed from: m, reason: collision with root package name */
    public ImageButton f282079m;

    /* renamed from: f, reason: collision with root package name */
    private int f282076f = 0;
    protected final MqqHandler P = ThreadManager.getUIHandler();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmediabrowser.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class ViewTreeObserverOnGlobalLayoutListenerC8521a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f282080d;

        ViewTreeObserverOnGlobalLayoutListenerC8521a(RecyclerView recyclerView) {
            this.f282080d = recyclerView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.f282080d.getWidth();
            int height = this.f282080d.getHeight();
            a aVar = a.this;
            if (width != aVar.J || height != aVar.K) {
                CopyOnWriteArrayList<WeakReference<a>> h16 = aVar.f282074d.f281859e.h();
                Iterator<WeakReference<a>> it = h16.iterator();
                while (it.hasNext()) {
                    WeakReference<a> next = it.next();
                    a aVar2 = next.get();
                    if (aVar2 == null) {
                        h16.remove(next);
                    } else if (aVar2.J == width && aVar2.K == height) {
                        QLog.d("AIOBrowserBaseView", 1, aVar2 + "screen size not changed, screenWidthPx:" + width + ", screenHeightPx:" + height);
                    } else {
                        aVar2.x(width, height);
                    }
                }
            }
            this.f282080d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BrowserBasePresenter browserBasePresenter;
            if (ImmersiveUtils.isSupporImmersive() == 1 && (browserBasePresenter = a.this.f282074d.f281861h) != null) {
                browserBasePresenter.updateSystemUIVisablity();
            }
        }
    }

    public a(Context context, com.tencent.mobileqq.richmediabrowser.presenter.a aVar) {
        this.f282077h = context;
        this.f282074d = aVar;
        aVar.f281859e.h().add(new WeakReference<>(this));
        this.L = x.h(this.f282077h, ScreenUtils.getScreenWidth(r2));
        this.M = x.h(this.f282077h, ScreenUtils.getScreenHeight(r2));
    }

    private void i() {
        RecyclerView recyclerView = this.f282074d.f281861h.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC8521a(recyclerView));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int p(RichMediaBrowserInfo richMediaBrowserInfo) {
        RichMediaBaseData richMediaBaseData;
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null) {
            switch (richMediaBaseData.getType()) {
                case 100:
                    AIOPictureData aIOPictureData = (AIOPictureData) richMediaBrowserInfo.baseData;
                    if (aIOPictureData.istroop == 1 && aIOPictureData.isFromFile) {
                        return 2;
                    }
                    return 1;
                case 101:
                    int i3 = ((AIOVideoData) richMediaBrowserInfo.baseData).f281846h;
                    if (i3 == 0) {
                        return 4;
                    }
                    if (i3 == 1) {
                        return 3;
                    }
                    break;
                case 102:
                    return 2;
                case 103:
                    return 5;
            }
        }
        return 0;
    }

    private int q() {
        int c16 = h.a().c();
        int i3 = 1;
        if (c16 != 1) {
            if (c16 != 2) {
                if (c16 != 3) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
            } else {
                i3 = 5;
            }
        }
        if (h.a().q()) {
            return 6;
        }
        return i3;
    }

    public static int r(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 1004 && i3 != 1008 && i3 != 1009 && i3 != 1010 && i3 != 1011 && i3 != 1020 && i3 != 1021 && i3 != 1022 && i3 != 1023 && i3 != 1024 && i3 != 1025 && i3 != 1036 && i3 != 10002 && i3 != 10003 && i3 != 10004) {
            return 4;
        }
        return 3;
    }

    public void A(int i3) {
        int i16;
        RichMediaBaseData richMediaBaseData;
        if (this.f282075e == null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = this.f282077h;
            this.f282075e = ShareActionSheetFactory.create(param);
        }
        int i17 = 0;
        this.f282075e.setRowVisibility(0, 0, 0);
        this.f282075e.setOnDismissListener(new b());
        BrowserBasePresenter browserBasePresenter = this.f282074d.f281861h;
        if (browserBasePresenter == null) {
            return;
        }
        RichMediaBrowserInfo selectedItem = browserBasePresenter.getSelectedItem();
        int p16 = p(selectedItem);
        if (selectedItem != null && (richMediaBaseData = selectedItem.baseData) != null) {
            i16 = ((AIOBrowserBaseData) richMediaBaseData).istroop;
        } else {
            i16 = 0;
        }
        int r16 = r(i16);
        int q16 = q();
        if (i3 == 2) {
            i17 = 1;
        } else if (i3 == 1) {
            i17 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", p16, 0, String.valueOf(r16), String.valueOf(q16), String.valueOf(i17), "");
        this.f282074d.f281859e.F();
    }

    public void B(boolean z16) {
        int i3;
        ImageButton imageButton = this.f282078i;
        if (imageButton != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageButton.setVisibility(i3);
        }
    }

    public void C(boolean z16) {
        BrowserBasePresenter browserBasePresenter = this.f282074d.f281861h;
        if (browserBasePresenter != null) {
            browserBasePresenter.showContentView(z16);
        }
        if (z16) {
            I();
        }
    }

    public void D(boolean z16) {
        int i3;
        String qqStr;
        RelativeLayout relativeLayout = this.H;
        if (relativeLayout != null) {
            int visibility = relativeLayout.getVisibility();
            RelativeLayout relativeLayout2 = this.H;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout2.setVisibility(i3);
            if (AppSetting.f99565y && ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("talkback_fix_enable_2") && visibility != this.H.getVisibility()) {
                if (z16) {
                    qqStr = HardCodeUtil.qqStr(R.string.f221976c_);
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f221966c9);
                }
                com.tencent.mobileqq.util.c.a(this.H, qqStr);
            }
        }
    }

    public void E(boolean z16) {
        this.E.setVisibility(8);
    }

    public void F(boolean z16) {
        int i3;
        ImageButton imageButton = this.C;
        if (imageButton != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageButton.setVisibility(i3);
        }
    }

    public void G(boolean z16) {
        int i3;
        ImageButton imageButton = this.f282079m;
        if (imageButton != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageButton.setVisibility(i3);
        }
    }

    public void H(boolean z16) {
        int i3;
        ImageButton imageButton = this.D;
        if (imageButton != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageButton.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(com.tencent.mobileqq.richmediabrowser.presenter.a aVar, int i3) {
        if (i3 == 5) {
            BrowserBasePresenter browserBasePresenter = aVar.f281861h;
            browserBasePresenter.onLoadFinish(browserBasePresenter.getSelectedIndex(), true);
            aVar.p().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(VideoView videoView, int i3) {
        if (i3 == 5) {
            videoView.showPlayPanel(true);
            videoView.bufferPanel.setVisibility(8);
            videoView.mErrLayout.setVisibility(8);
            videoView.mCenterPlayBtn.setVisibility(0);
            videoView.playButton.setImageResource(R.drawable.f9n);
            videoView.totalTime.setText(com.tencent.richmediabrowser.utils.a.b(this.N));
            videoView.progressTime.setText(com.tencent.richmediabrowser.utils.a.b(0L));
            videoView.playBar.setProgress(0);
        }
    }

    public View a(View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // c04.c
    public void g(f04.c cVar) {
        if (cVar instanceof BrowserBaseView) {
            BrowserBaseView browserBaseView = (BrowserBaseView) cVar;
            this.I = browserBaseView;
            browserBaseView.setDecoratorViewEvent(this);
            this.I.setBrowserItemClickListener(this);
            this.I.setBrowserItemScrollEventListener(this);
            this.I.setBrowserItemAnimationListener(this);
        }
    }

    public Rect getAnimationEndDstRect() {
        return null;
    }

    public void h(Intent intent) {
        BrowserBasePresenter browserBasePresenter = this.f282074d.f281861h;
        if (browserBasePresenter != null && browserBasePresenter.getRecyclerView() != null) {
            this.J = this.f282074d.f281861h.getRecyclerView().getWidth();
            this.K = this.f282074d.f281861h.getRecyclerView().getHeight();
        } else {
            this.J = ScreenUtils.getScreenWidth(this.f282077h);
            this.K = ScreenUtils.getScreenHeight(this.f282077h);
        }
    }

    public void j(Configuration configuration) {
        AppRuntime peekAppRuntime;
        com.tencent.mobileqq.richmediabrowser.presenter.a aVar = this.f282074d;
        if (aVar != null && aVar.f281861h != null) {
            int q16 = aVar.f281859e.q();
            int i3 = configuration.orientation;
            if (q16 != i3) {
                this.f282074d.f281859e.a0(i3);
                i();
                QLog.d("AIOBrowserBaseView", 1, "checkConfigurationChanged\uff0corientation is :" + configuration.orientation);
                return;
            }
            if ((this.L != configuration.screenWidthDp || this.M != configuration.screenHeightDp) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("historicalFunctionalityBug_8_9_25")) {
                this.L = configuration.screenWidthDp;
                this.M = configuration.screenHeightDp;
                i();
                QLog.d("AIOBrowserBaseView", 1, "checkConfigurationChanged\uff0cmScreenWidthPx:" + this.L + ",mScreenHeightPx:" + this.M);
                return;
            }
            return;
        }
        QLog.d("AIOBrowserBaseView", 1, "onConfigurationChanged: aioBrowserBasePresenter or decoratorPresenter is null, return");
    }

    public void k() {
        ShareActionSheet shareActionSheet = this.f282075e;
        if (shareActionSheet != null) {
            shareActionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        ReportController.o(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
        A(2);
        this.f282074d.f281859e.E();
    }

    public void m(boolean z16) {
        this.f282074d.p().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        RichMediaBaseData richMediaBaseData;
        if (this.f282074d.f281861h == null) {
            return;
        }
        h.a().c();
        RichMediaBrowserInfo selectedItem = this.f282074d.f281861h.getSelectedItem();
        if (selectedItem != null) {
            richMediaBaseData = selectedItem.baseData;
        } else {
            richMediaBaseData = null;
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).gotoChatHistoryActivity(this.f282077h, h.a().g(), h.a().f(), richMediaBaseData);
        Context context = this.f282077h;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.getIntent().putExtra(RichMediaBrowserConstants.EXTRA_IS_STARTING_CHAT_FILE_HISTORY, true);
            activity.overridePendingTransition(R.anim.f155050vb, R.anim.f155049va);
        }
        this.f282074d.f281859e.M();
    }

    @Override // e04.b
    public boolean needEnterRectAnimation() {
        if (((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isSoftInputPanel(h.a().e())) {
            return false;
        }
        return true;
    }

    @Override // e04.b
    public boolean needExitRectAnimation() {
        if ((h.a().e() == -3321 || ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).isSoftInputPanel(h.a().e())) && !h.a().v()) {
            return false;
        }
        int i3 = Integer.MIN_VALUE;
        if (h.a().k() == Integer.MIN_VALUE) {
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) this.f282077h.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.endsWith(MimeHelper.MIME_TYPE_MOBILEQQ)) {
                i3 = next.pid;
                break;
            }
        }
        if (i3 != h.a().k()) {
            return false;
        }
        return true;
    }

    public void o() {
        ImmersionHelper p16 = this.f282074d.p();
        if (QLog.isColorLevel()) {
            QLog.d("AIOBrowserBaseView", 2, "doQuitImmersion, basePresenter.isActionSheetVisibleBeforeImm = " + p16.f281783e + " , basePresenter.isActionSheetVisibleBeforeImm , basePresenter.isDanmakuVisibleBeforeImm = " + p16.f281784f);
        }
        if (p16.f281783e) {
            B(true);
        }
        if (p16.f281784f) {
            this.f282074d.Q(true);
        }
        this.f282074d.p().b();
        this.f282074d.J();
        this.f282074d.K();
        C(true);
        D(true);
    }

    @Override // e04.c
    public void onClickEvent() {
        this.f282074d.back();
    }

    public void onEnterAnimationEnd() {
        B(true);
        if (h.a().c() == 4) {
            B(false);
        }
    }

    public void onEnterAnimationStart() {
        B(false);
    }

    public void onExitAnimationStart() {
        B(false);
        C(false);
    }

    public void onItemSelected(int i3) {
        boolean z16;
        if (!h.a().o()) {
            if (this.f282074d.L()) {
                AIOBrowserScene aIOBrowserScene = this.f282074d.f281859e.f281849d;
                if (aIOBrowserScene != null) {
                    aIOBrowserScene.notifyImageModelDataChanged();
                }
            } else {
                BrowserBasePresenter browserBasePresenter = this.f282074d.f281861h;
                if (browserBasePresenter != null) {
                    int count = browserBasePresenter.getCount();
                    if (!h.a().v() ? i3 < 25 : !(count - i3 <= 0 || i3 <= count - 25)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (count != 1 && z16 && this.f282076f != count && !h.a().p()) {
                        BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 4, "onItemSelected loadMedias: mLastLoadCount=" + this.f282076f);
                        this.f282076f = this.f282074d.f281861h.getCount();
                        AIOBrowserPresenter aIOBrowserPresenter = this.f282074d.f281859e;
                        if (aIOBrowserPresenter != null && (aIOBrowserPresenter.getParamsBuilder().c() instanceof com.tencent.mobileqq.richmediabrowser.f)) {
                            ((com.tencent.mobileqq.richmediabrowser.f) this.f282074d.f281859e.getParamsBuilder().c()).D(0);
                        }
                    }
                }
            }
        }
        this.f282074d.p().f281782d = false;
        this.f282074d.p().b();
        this.f282074d.J();
        this.f282074d.K();
        this.f282074d.p().f();
        this.f282074d.p().j();
        BrowserBaseView browserBaseView = this.I;
        if (browserBaseView != null && !browserBaseView.isInExitAnim) {
            B(true);
        }
    }

    @Override // e04.c
    public void onLongClickEvent() {
        ReportController.o(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
        if (h.a().c() == 4) {
            return;
        }
        try {
            A(1);
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 2, "onItemLongClick, showActionSheet");
        } catch (Throwable th5) {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOBrowserBaseView", 1, "onItemLongClick showActionSheet exception: " + th5.getMessage());
        }
    }

    public void onScrollEnd() {
        com.tencent.mobileqq.richmediabrowser.presenter.a aVar = this.f282074d;
        BrowserBasePresenter browserBasePresenter = aVar.f281861h;
        if (browserBasePresenter != null && aVar.z(browserBasePresenter.getCurrentPosition())) {
            this.f282074d.N();
        }
        D(true);
    }

    public void onScrollStart() {
        com.tencent.mobileqq.richmediabrowser.presenter.a aVar = this.f282074d;
        BrowserBasePresenter browserBasePresenter = aVar.f281861h;
        if (browserBasePresenter != null && aVar.z(browserBasePresenter.getCurrentPosition())) {
            this.f282074d.I(false);
        }
        D(false);
    }

    public boolean s() {
        ImageButton imageButton = this.f282078i;
        if (imageButton == null || imageButton.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void t() {
        ShareActionSheet shareActionSheet = this.f282075e;
        if (shareActionSheet != null) {
            shareActionSheet.setItemClickListenerV2(null);
            this.f282075e.dismiss();
        }
        com.tencent.mobileqq.richmediabrowser.presenter.a aVar = this.f282074d;
        if (aVar != null) {
            aVar.p().f();
        }
        BrowserBaseView browserBaseView = this.I;
        if (browserBaseView != null) {
            browserBaseView.onDestroy();
        }
    }

    public void v() {
        o();
        w();
    }

    public void w() {
        this.f282074d.p().f();
        this.f282074d.p().f281782d = false;
        this.f282074d.p().j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(int i3, int i16) {
        this.J = i3;
        this.K = i16;
    }

    public boolean y(RichMediaBrowserInfo richMediaBrowserInfo) {
        return this.f282074d.P(richMediaBrowserInfo);
    }

    public boolean z() {
        if (!h.a().q() && ao.c(h.a().f()) != 1044 && ao.c(h.a().f()) != 1032 && h.a().c() != 3 && h.a().c() != 4 && h.a().c() != 6 && h.a().t()) {
            return true;
        }
        return false;
    }

    public void I() {
    }

    @Override // e04.b
    public void onExitAnimationEnd() {
    }

    public void onScrollHalfScreenWidth() {
    }

    public void updateUI() {
    }

    public void b(int i3) {
    }

    @Override // e04.f
    public void onDoubleTap(int i3) {
    }

    @Override // e04.f
    public void onScale(int i3) {
    }

    @Override // e04.f
    public void onScaleBegin(int i3) {
    }

    @Override // e04.f
    public void onScaleEnd(int i3) {
    }

    public void u(long j3) {
    }

    public void c(int i3, View view) {
    }
}
