package com.tencent.mobileqq.tianshu.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IScreenAnimationRedTouchHelper;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScreenAnimationDialog extends ReportDialog {
    static IPatchRedirector $redirector_ = null;
    private static final String CACHE_FILE_PREFIX = "Cache_";
    private static final String MMKV_KEY_IS_SHOW_ANIMATION_PREFIX = "is_show_animation_";
    private static final String TAG = "ScreenAnimationDialog";
    private static volatile ScreenAnimationDialog showingDialog;
    private ApngDrawable apngDrawable;
    private int apngHeight;
    private int apngWidth;
    private BusinessInfoCheckUpdate.AppInfo appInfo;
    private ImageView imageView;
    private boolean isLebaResume;
    private String lebaListItemResId;
    private final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    private ApngDrawable.OnPlayRepeatListener playRepeatListener;
    private RedTouch redTouch;
    private int redTouchPositionY;
    private Handler uiHandler;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f293136d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenAnimationDialog.this);
            } else {
                this.f293136d = new Rect();
            }
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (ScreenAnimationDialog.this.redTouch == null) {
                return;
            }
            boolean z17 = true;
            if (ScreenAnimationDialog.this.redTouch != null && ScreenAnimationDialog.this.redTouch.getGlobalVisibleRect(this.f293136d)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || this.f293136d.height() <= 0 || this.f293136d.width() <= 0) {
                z17 = false;
            }
            QLog.d(ScreenAnimationDialog.TAG, 4, "onScrollChanged: visible: " + z17);
            if (!z17) {
                ScreenAnimationDialog.this.dismiss();
            } else if (ScreenAnimationDialog.this.isShowing()) {
                ScreenAnimationDialog.this.resetImagePosition();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenAnimationDialog.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ScreenAnimationDialog.this.resetImagePosition();
                ScreenAnimationDialog.this.redTouch.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34413);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            showingDialog = null;
        }
    }

    public ScreenAnimationDialog(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.isLebaResume = false;
        this.apngWidth = 0;
        this.apngHeight = 0;
        this.onScrollChangedListener = new a();
        this.playRepeatListener = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenAnimationDialog.this);
                }
            }

            @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
            public void onPlayRepeat(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                ScreenAnimationDialog.this.apngDrawable.removeOnPlayRepeatListener(this);
                ScreenAnimationDialog.this.uiHandler.removeCallbacksAndMessages(null);
                ScreenAnimationDialog.this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog.6.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            ScreenAnimationDialog.this.dismiss();
                        }
                    }
                });
            }
        };
        initWindow();
    }

    private boolean decodeApngFile(File file) {
        int i3;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (!ApngDrawable.isApngFile(file)) {
                        QLog.e(TAG, 1, "onApngDownloaded the image file isn't apng");
                        return false;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                    int i16 = options.outWidth;
                    if (i16 > 0 && (i3 = options.outHeight) > 0) {
                        this.apngWidth = i16;
                        this.apngHeight = i3;
                        ApngDrawable apngDrawable = new ApngDrawable(file, BaseApplication.getContext().getResources());
                        this.apngDrawable = apngDrawable;
                        apngDrawable.setOnPlayRepeatListener(this.playRepeatListener);
                        this.apngDrawable.getImage().apngLoop = 1;
                        return true;
                    }
                    QLog.e(TAG, 1, "onApngDownloaded the image file isn't apng");
                    return false;
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "decodeApngFile e:", th5);
                return false;
            }
        }
        QLog.e(TAG, 1, "onApngDownloaded apng file don't exist");
        return false;
    }

    private void downloadApng(String str, File file) {
        QLog.i(TAG, 1, "downloadApng start");
        ThreadManagerV2.excute(new Runnable(str, file) { // from class: com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f293132d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ File f293133e;

            {
                this.f293132d = str;
                this.f293133e = file;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ScreenAnimationDialog.this, str, file);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                File file2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i(ScreenAnimationDialog.TAG, 1, "downloadApng real start");
                boolean downloadFile = ((IScreenAnimationRedTouchHelper) QRoute.api(IScreenAnimationRedTouchHelper.class)).downloadFile(this.f293132d, this.f293133e);
                QLog.i(ScreenAnimationDialog.TAG, 1, "downloadApng end");
                ScreenAnimationDialog screenAnimationDialog = ScreenAnimationDialog.this;
                if (downloadFile) {
                    file2 = this.f293133e;
                } else {
                    file2 = null;
                }
                screenAnimationDialog.onApngDownloaded(file2);
            }
        }, 128, null, true);
    }

    private String generateImageCacheDir() {
        File cacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        return new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE).getAbsolutePath();
    }

    private static String getAnimApngUrl(BusinessInfoCheckUpdate.AppInfo appInfo) {
        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : appInfo.red_display_info.red_type_info.get()) {
            if (redTypeInfo.red_type.get() == 30) {
                return redTypeInfo.red_content.get();
            }
        }
        return null;
    }

    private static String getCurrentUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return "";
    }

    private String getLocalFilePath(String str) {
        return generateImageCacheDir() + File.separator + CACHE_FILE_PREFIX + Utils.Crc64String(str);
    }

    public static ScreenAnimationDialog getShowingDialog() {
        return showingDialog;
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            QLog.d(TAG, 1, "dialog window is null, return");
            return;
        }
        window.setLayout(-1, -1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 48;
        window.setAttributes(attributes);
        window.setFlags(16, 16);
        window.setFlags(8, 8);
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    public static boolean isScreenAnimationShowed(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String parseAdId = parseAdId(appInfo);
        if (TextUtils.isEmpty(parseAdId)) {
            return true;
        }
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU).decodeBool(MMKV_KEY_IS_SHOW_ANIMATION_PREFIX + getCurrentUin() + parseAdId, false);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "isScreenAnimationShowed isShow:" + decodeBool);
        }
        return decodeBool;
    }

    public static boolean isValidScreenAnimationRedTouch(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (redTouch != null && appInfo != null && appInfo.type.get() == 30 && appInfo.iNewFlag.get() != 0 && appInfo.exposure_max.get() >= 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onApngDownloaded(File file) {
        if (!decodeApngFile(file)) {
            onShowDialogFailed();
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            realShowDialog();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenAnimationDialog.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ScreenAnimationDialog.this.realShowDialog();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    private void onShowDialogFailed() {
        showingDialog = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setRedTouchImageVisibility(this.redTouch, 4);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenAnimationDialog.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ScreenAnimationDialog.setRedTouchImageVisibility(ScreenAnimationDialog.this.redTouch, 4);
                    }
                }
            });
        }
    }

    private static String parseAdId(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str = appInfo.buffer.get();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optString("ad_id");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parson ad_id e:", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realShowDialog() {
        QLog.i(TAG, 1, "realShowDialog isLebaResume:" + this.isLebaResume);
        if (this.isLebaResume) {
            try {
                show();
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "realShowDialog e:", th5);
            }
        }
        onShowDialogFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetImagePosition() {
        int[] iArr = new int[2];
        this.redTouch.getTarget().getLocationInWindow(iArr);
        int i3 = this.redTouchPositionY;
        int i16 = iArr[1];
        if (i3 == i16) {
            return;
        }
        this.redTouchPositionY = i16;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.imageView.getLayoutParams();
        layoutParams.topMargin = this.redTouchPositionY;
        this.imageView.setLayoutParams(layoutParams);
    }

    public static void setRedTouchImageVisibility(RedTouch redTouch, int i3) {
        View redTouchContainer = redTouch.getRedTouchContainer();
        if (redTouchContainer == null) {
            return;
        }
        View findViewById = redTouchContainer.findViewById(20);
        if (!(findViewById instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) findViewById;
        if (frameLayout.getChildCount() > 0) {
            frameLayout.getChildAt(0).setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        RedTouch redTouch = this.redTouch;
        if (redTouch != null) {
            redTouch.getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        }
        if (!isShowing()) {
            return;
        }
        try {
            setRedTouchImageVisibility(this.redTouch, 0);
            showingDialog = null;
            super.dismiss();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "dismiss e:" + th5);
        }
    }

    public boolean isRedPathEqualed(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInfo)).booleanValue();
        }
        if (appInfo != null && appInfo.path.get() != null) {
            return appInfo.path.get().equals(this.appInfo.path.get());
        }
        return false;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.uiHandler = new Handler(Looper.getMainLooper());
        int[] iArr = new int[2];
        this.redTouch.getTarget().getLocationInWindow(iArr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.mobileqq.util.Utils.n(this.apngWidth / 2, getContext().getResources()), com.tencent.mobileqq.util.Utils.n(this.apngHeight / 2, getContext().getResources()));
        layoutParams.topMargin = iArr[1];
        layoutParams.gravity = 5;
        ImageView imageView = new ImageView(getContext());
        this.imageView = imageView;
        imageView.setImageDrawable(this.apngDrawable);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(this.imageView, layoutParams);
        setContentView(frameLayout);
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU).encodeBool(MMKV_KEY_IS_SHOW_ANIMATION_PREFIX + getCurrentUin() + parseAdId(this.appInfo), true);
        this.redTouch.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        QLog.i(TAG, 1, "onCreate");
    }

    public void onLebaPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.isLebaResume = false;
            dismiss();
        }
    }

    public void onLebaResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.isLebaResume = true;
        }
    }

    public void showScreenAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i(TAG, 2, "showScreenAnimation start");
        showingDialog = this;
        String animApngUrl = getAnimApngUrl(this.appInfo);
        if (TextUtils.isEmpty(animApngUrl)) {
            QLog.e(TAG, 2, "showScreenAnimation url is empty");
            onShowDialogFailed();
            return;
        }
        File file = new File(getLocalFilePath(animApngUrl));
        if (file.exists()) {
            onApngDownloaded(file);
        } else {
            downloadApng(animApngUrl, file);
        }
    }

    public void updateRedTouch(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) redTouch, (Object) appInfo);
            return;
        }
        RedTouch redTouch2 = this.redTouch;
        if (redTouch2 != null) {
            setRedTouchImageVisibility(redTouch2, 0);
            RedTouch redTouch3 = this.redTouch;
            if (redTouch3 != redTouch) {
                redTouch3.getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
            }
        }
        this.redTouch = redTouch;
        this.appInfo = appInfo;
        setRedTouchImageVisibility(redTouch, 4);
        if (isShowing()) {
            resetImagePosition();
        }
        ViewTreeObserver viewTreeObserver = this.redTouch.getViewTreeObserver();
        viewTreeObserver.removeOnScrollChangedListener(this.onScrollChangedListener);
        viewTreeObserver.addOnScrollChangedListener(this.onScrollChangedListener);
    }

    public ScreenAnimationDialog(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
            return;
        }
        this.isLebaResume = false;
        this.apngWidth = 0;
        this.apngHeight = 0;
        this.onScrollChangedListener = new a();
        this.playRepeatListener = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenAnimationDialog.this);
                }
            }

            @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
            public void onPlayRepeat(int i36) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i36);
                    return;
                }
                ScreenAnimationDialog.this.apngDrawable.removeOnPlayRepeatListener(this);
                ScreenAnimationDialog.this.uiHandler.removeCallbacksAndMessages(null);
                ScreenAnimationDialog.this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.tianshu.ui.ScreenAnimationDialog.6.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            ScreenAnimationDialog.this.dismiss();
                        }
                    }
                });
            }
        };
        initWindow();
    }
}
