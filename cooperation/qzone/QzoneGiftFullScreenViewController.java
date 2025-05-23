package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView;
import com.tencent.mobileqq.magicface.view.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneGiftFullScreenViewController implements View.OnClickListener, IQzoneGiftFullScreenViewController {
    public static boolean IS_SUPPORT_MAGICFACE = false;
    public static final String TAG = "QzoneGiftFullScreenViewController";
    static long lastPlayMaigcfaceTime;
    protected ActionGlobalData actionGlobalData;
    protected String epId;
    protected boolean isUseHardDecode;
    private final WeakReference<Activity> mActivity;
    protected WindowManager mWindowManager;
    public QzoneGiftFullScreenActionManager magicfaceActionManager;
    protected MagicfaceContainerView magicfaceReceiveContent;
    protected b magicfaceReceivePlay;
    protected Button magicfaceReceiveStop;
    protected ImageView magicfaceTip;
    protected View topbar;
    protected View topbarBgView;
    private List<MagicData> magicDatas = new ArrayList();
    private boolean isJumpRemove = ar.b("anzaihuang", "2024-04-07", "vas_anr_glview_switch").isEnable(true);
    protected Handler uiHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class MagicData {
        public String emotionId;
        public boolean isPassivePraise;
        public String maigcPath;
        public IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener playListener;

        public MagicData() {
        }
    }

    static {
        String o16 = ah.o();
        if (o16 != null) {
            String lowerCase = o16.toLowerCase();
            if (!lowerCase.contains("marvell") && !lowerCase.contains("armv5") && !lowerCase.contains("armv6")) {
                IS_SUPPORT_MAGICFACE = true;
            } else {
                IS_SUPPORT_MAGICFACE = false;
            }
        }
        lastPlayMaigcfaceTime = 0L;
    }

    public QzoneGiftFullScreenViewController(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
        checkHardDecodeCondition();
    }

    private void checkHardDecodeCondition() {
        if (!ah.r0()) {
            this.isUseHardDecode = false;
        } else if (Math.min(ah.x(), ah.w()) >= 720) {
            this.isUseHardDecode = true;
        } else {
            this.isUseHardDecode = false;
        }
    }

    private void initMagicfaceView() {
        View inflate;
        if (this.magicfaceReceiveContent == null) {
            if (this.isUseHardDecode) {
                inflate = View.inflate(BaseApplication.getContext(), R.layout.bce, null);
            } else {
                inflate = View.inflate(BaseApplication.getContext(), R.layout.bcg, null);
            }
            View inflate2 = View.inflate(BaseApplication.getContext(), R.layout.bci, null);
            this.topbar = inflate2;
            this.topbarBgView = inflate2.findViewById(R.id.el5);
            this.magicfaceReceivePlay = (b) inflate.findViewById(R.id.eky);
            this.magicfaceReceiveContent = (MagicfaceContainerView) inflate.findViewById(R.id.f166172el0);
            Button button = (Button) this.topbar.findViewById(R.id.ekz);
            this.magicfaceReceiveStop = button;
            button.setVisibility(8);
            this.magicfaceTip = (ImageView) this.topbar.findViewById(R.id.f166175el3);
            this.magicfaceReceiveStop.setOnClickListener(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initTopbar(int i3) {
        BaseApplicationImpl application;
        boolean z16;
        if (this.topbar == null || (application = BaseApplicationImpl.getApplication()) == null) {
            return;
        }
        if (!Settings.canDrawOverlays(application)) {
            application.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
        } else {
            if (application.checkSelfPermission("android.settings.action.MANAGE_WRITE_SETTINGS") == 0) {
                z16 = true;
                if (z16) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.type = 2002;
                layoutParams.flags = 131112;
                layoutParams.gravity = 51;
                layoutParams.x = 0;
                layoutParams.y = i3;
                layoutParams.width = -1;
                layoutParams.height = -2;
                layoutParams.format = 1;
                this.mWindowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
                if (this.topbar.getParent() != null) {
                    try {
                        this.mWindowManager.removeView(this.topbar);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "initTopbar: ", e16);
                    }
                }
                try {
                    this.mWindowManager.addView(this.topbar, layoutParams);
                    return;
                } catch (Exception e17) {
                    QLog.e(TAG, 1, "initTopbar: ", e17);
                    return;
                }
            }
            application.startActivity(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS"));
        }
        z16 = false;
        if (z16) {
        }
    }

    public static boolean isSupportMagicface() {
        if (!VasToggle.BUG_108571707_2.isEnable(true)) {
            return false;
        }
        if (((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.magicface_support.name()) && IS_SUPPORT_MAGICFACE && DecoderUtil.IS_LOAD_SUCESS) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "is_support_magic:TRUE");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "is_support_magic:FALSE");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void magicfaceClose() {
        if (this.magicfaceActionManager == null || this.mActivity == null) {
            return;
        }
        this.magicfaceReceiveContent.setVisibility(8);
        this.magicfaceReceiveContent.setMagicfaceGestureListener(null);
        ((View) this.magicfaceReceivePlay).setVisibility(8);
        this.magicfaceReceivePlay.setSurfaceCreatelistener(null);
        try {
            if (this.mActivity.get() != null && (!this.isJumpRemove || Build.VERSION.SDK_INT > 28)) {
                ((ViewGroup) this.mActivity.get().getWindow().getDecorView()).removeView(this.magicfaceReceiveContent);
            }
            View view = this.topbar;
            if (view != null) {
                view.setVisibility(8);
                WindowManager windowManager = this.mWindowManager;
                if (windowManager != null) {
                    windowManager.removeView(this.topbar);
                }
            }
        } catch (Exception unused) {
        }
        if (this.magicfaceActionManager.isStart()) {
            final QzoneGiftFullScreenActionManager qzoneGiftFullScreenActionManager = this.magicfaceActionManager;
            qzoneGiftFullScreenActionManager.close(new QzoneGiftFullScreenActionManager.MagicfaceCloseListener() { // from class: cooperation.qzone.QzoneGiftFullScreenViewController.1
                @Override // cooperation.qzone.QzoneGiftFullScreenActionManager.MagicfaceCloseListener
                public void magicfaceClose() {
                    qzoneGiftFullScreenActionManager.release();
                }
            });
        } else {
            this.magicfaceActionManager.release();
        }
    }

    @Override // cooperation.qzone.IQzoneGiftFullScreenViewController
    public boolean onBackEvent() {
        if (this.magicfaceActionManager == null || this.magicfaceReceiveContent.getVisibility() == 8) {
            return false;
        }
        magicfaceClose();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ekz) {
            magicfaceClose();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public View playMaigcface(String str, String str2, IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener giftFullScreenPlayListener) {
        return playMaigcface(str, str2, false, giftFullScreenPlayListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cooperation.qzone.IQzoneGiftFullScreenViewController
    public View playMaigcface(String str, String str2, boolean z16, final IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener giftFullScreenPlayListener) {
        final long currentTimeMillis;
        Object obj;
        if (VasToggle.BUG_108571707_3.isEnable(true)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - lastPlayMaigcfaceTime < 1000) {
                QLog.d(TAG, 2, "magicFace timeout");
                return null;
            }
            lastPlayMaigcfaceTime = uptimeMillis;
        }
        try {
            currentTimeMillis = System.currentTimeMillis();
            obj = this.magicfaceReceivePlay;
        } catch (SecurityException e16) {
            e16.printStackTrace();
        }
        if (obj != null && ((View) obj).getVisibility() == 0) {
            MagicData magicData = new MagicData();
            magicData.emotionId = str;
            magicData.isPassivePraise = z16;
            magicData.maigcPath = str2;
            magicData.playListener = giftFullScreenPlayListener;
            this.magicDatas.add(magicData);
            return null;
        }
        QzoneGiftFullScreenActionManager qzoneGiftFullScreenActionManager = this.magicfaceActionManager;
        if ((qzoneGiftFullScreenActionManager != null && qzoneGiftFullScreenActionManager.isStart()) || this.mActivity == null) {
            return null;
        }
        ActionGlobalData hasAction = QzoneGiftFullScreenActionManager.hasAction(str, str2);
        this.actionGlobalData = hasAction;
        if (hasAction == null) {
            return null;
        }
        this.epId = str;
        initMagicfaceView();
        this.magicfaceActionManager = new QzoneGiftFullScreenActionManager(this);
        if (this.mActivity.get() == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) this.mActivity.get().getWindow().getDecorView();
        viewGroup.removeView(this.magicfaceReceiveContent);
        Rect rect = new Rect();
        viewGroup.getWindowVisibleDisplayFrame(rect);
        int i3 = rect.top;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.topbarBgView.setBackgroundColor(0);
        layoutParams.topMargin = i3;
        this.magicfaceReceiveContent.updateViewLayout((View) this.magicfaceReceivePlay, layoutParams);
        if (!z16) {
            initTopbar(0);
        }
        viewGroup.addView(this.magicfaceReceiveContent);
        if (z16) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.magicfaceReceiveContent.getLayoutParams();
            layoutParams2.topMargin = ViewUtils.dip2px(75.0f);
            layoutParams2.bottomMargin = ViewUtils.dip2px(75.0f);
            layoutParams2.leftMargin = ViewUtils.dip2px(15.0f);
            layoutParams2.rightMargin = ViewUtils.dip2px(15.0f);
            b bVar = this.magicfaceReceivePlay;
            if (bVar != null) {
                bVar.setIsFullScreen(false);
                ((View) this.magicfaceReceivePlay).setClickable(false);
                ((View) this.magicfaceReceivePlay).setFocusable(false);
            }
            this.magicfaceReceiveContent.setTouchEffect(true);
            this.magicfaceReceiveContent.setClickable(false);
            this.magicfaceReceiveContent.setFocusable(false);
        }
        this.uiHandler.post(new Runnable() { // from class: cooperation.qzone.QzoneGiftFullScreenViewController.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (QzoneGiftFullScreenViewController.this.mActivity.get() == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) QzoneGiftFullScreenViewController.this.magicfaceReceiveStop.getLayoutParams();
                layoutParams3.rightMargin = (int) al.a((Context) QzoneGiftFullScreenViewController.this.mActivity.get(), 10.0f);
                QzoneGiftFullScreenViewController.this.magicfaceReceiveStop.setLayoutParams(layoutParams3);
            }
        });
        this.magicfaceReceiveContent.setVisibility(8);
        this.magicfaceReceiveContent.setVisibility(0);
        Object obj2 = this.magicfaceReceivePlay;
        if (obj2 != null) {
            ((View) obj2).setVisibility(8);
            this.magicfaceReceivePlay.setIsFullScreen(this.actionGlobalData.f243351d);
        }
        this.topbar.setVisibility(0);
        b bVar2 = this.magicfaceReceivePlay;
        this.magicfaceTip.setVisibility(8);
        ((View) bVar2).setVisibility(0);
        ((SurfaceView) bVar2).setZOrderOnTop(true);
        ((SurfaceView) bVar2).getHolder().setFormat(-2);
        com.tencent.mobileqq.magicface.service.b bVar3 = new com.tencent.mobileqq.magicface.service.b();
        bVar3.k(bVar2);
        this.magicfaceActionManager.setMagicfacePlayManager(bVar3);
        this.magicfaceActionManager.setMagicfaceActionListener(new QzoneGiftFullScreenActionManager.MagicfaceActionListener() { // from class: cooperation.qzone.QzoneGiftFullScreenViewController.3
            @Override // cooperation.qzone.QzoneGiftFullScreenActionManager.MagicfaceActionListener
            public void magicfaceActionEnd(ActionGlobalData actionGlobalData) {
                QzoneGiftFullScreenViewController.this.uiHandler.post(new Runnable() { // from class: cooperation.qzone.QzoneGiftFullScreenViewController.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        URLDrawable.resume();
                        ((View) QzoneGiftFullScreenViewController.this.magicfaceReceivePlay).setBackgroundColor(0);
                        QzoneGiftFullScreenViewController.this.magicfaceClose();
                        IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener giftFullScreenPlayListener2 = giftFullScreenPlayListener;
                        if (giftFullScreenPlayListener2 != null) {
                            giftFullScreenPlayListener2.giftFullScreenPlayEnd();
                        }
                        if (QzoneGiftFullScreenViewController.this.magicDatas.size() > 0) {
                            MagicData magicData2 = (MagicData) QzoneGiftFullScreenViewController.this.magicDatas.get(0);
                            QzoneGiftFullScreenViewController.this.playMaigcface(magicData2.emotionId, magicData2.maigcPath, magicData2.isPassivePraise, magicData2.playListener);
                            QzoneGiftFullScreenViewController.this.magicDatas.remove(magicData2);
                        }
                    }
                });
            }

            @Override // cooperation.qzone.QzoneGiftFullScreenActionManager.MagicfaceActionListener
            public void magicfaceActionStart(final ActionGlobalData actionGlobalData) {
                System.currentTimeMillis();
                QzoneGiftFullScreenViewController.this.magicfaceActionManager.openSound(QzoneGiftFullScreenViewController.this.magicfaceActionManager.getPreferencesReceiveSound());
                QzoneGiftFullScreenViewController.this.uiHandler.post(new Runnable() { // from class: cooperation.qzone.QzoneGiftFullScreenViewController.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        URLDrawable.pause();
                        ((View) QzoneGiftFullScreenViewController.this.magicfaceReceivePlay).setBackgroundColor(actionGlobalData.f243354g);
                    }
                });
            }
        });
        this.magicfaceActionManager.doAction(str, str2);
        return this.magicfaceReceiveContent;
    }
}
