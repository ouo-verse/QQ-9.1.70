package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.activity.MiniSharePanelFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.api.IMiniShareApi;
import com.tencent.mobileqq.mini.api.IMiniShareCallback;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.va.ui.MiniGameVASettingFragment;
import com.tencent.mobileqq.minigame.va.util.InitColorNoteCallback;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAColorNote;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShortcutUtils;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniSharePanelFragment extends QPublicBaseFragment implements View.OnClickListener, ShareActionSheet.OnItemClickListener {
    public static final String TAG = "MiniSharePanelFragment";
    private MiniGameVAColorNote colorNote;
    private MiniAppConfig mAppConfig;
    private int mScreeWidth;
    private int mScreenHeight;
    private ShareActionSheet shareActionSheet;
    private MiniArkShareModel miniArkShareModel = null;
    private long mLastClickTime = 0;
    private View rootView = null;
    private boolean bLateFinish = false;
    private boolean isWxShare = false;
    private final IGuardInterface mForegroundChangeObserver = new IGuardInterface() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.6
        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            QLog.d(MiniSharePanelFragment.TAG, 1, "onApplicationForeground...isWxShare=" + MiniSharePanelFragment.this.isWxShare);
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null) {
                guardManager.unregisterCallback(this);
            }
            if (MiniSharePanelFragment.this.isWxShare) {
                MiniSharePanelFragment.this.dismiss();
                MiniSharePanelFragment.this.backToGame();
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void backToGame() {
        FragmentActivity activity = getActivity();
        QLog.i(TAG, 1, "backToGame activity=" + activity);
        if (activity == null) {
            return;
        }
        String str = "mqqapi://minibox/open_share_result?app_id=" + this.miniArkShareModel.getAppId() + "&pkg_name=" + this.miniArkShareModel.getPkgName() + "&app_version=&";
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(str));
        activity.startActivity(intent);
    }

    private void getAppInfo() {
        MiniAppCmdUtil.getInstance().getAppInfoById(null, this.miniArkShareModel.getAppId(), null, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                try {
                    QLog.d(MiniSharePanelFragment.TAG, 1, "getAppInfo isSuc=" + z16 + ",ret=" + jSONObject);
                    if (z16) {
                        long optLong = jSONObject.optLong("retCode");
                        String optString = jSONObject.optString("errMsg");
                        QLog.i(MiniSharePanelFragment.TAG, 1, "getAppInfo, retCode = " + optLong + ",errMsg = " + optString);
                        MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getAppInfo, appInfo = ");
                        sb5.append(miniAppInfo);
                        QLog.i(MiniSharePanelFragment.TAG, 1, sb5.toString());
                        if (miniAppInfo != null) {
                            MiniSharePanelFragment.this.mAppConfig = new MiniAppConfig(miniAppInfo);
                            QLog.i(MiniSharePanelFragment.TAG, 1, "getAppInfo, retCode = " + optLong + ",errMsg = " + optString);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e(MiniSharePanelFragment.TAG, 1, "getAppInfo", e16);
                }
            }
        });
    }

    private Intent getIntent() {
        if (getActivity() != null) {
            return getActivity().getIntent();
        }
        QLog.e(TAG, 1, "Fragment.getActivity() is null when calling getIntent()");
        return new Intent();
    }

    private com.tencent.qqmini.sdk.launcher.model.MiniAppInfo getMiniAppInfo(MiniAppConfig miniAppConfig) {
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
        MiniAppInfo miniAppInfo2 = miniAppConfig.config;
        miniAppInfo.appId = miniAppInfo2.appId;
        miniAppInfo.verType = miniAppInfo2.verType;
        miniAppInfo.name = miniAppInfo2.name;
        miniAppInfo.iconUrl = miniAppInfo2.iconUrl;
        miniAppInfo.desc = miniAppInfo2.desc;
        return miniAppInfo;
    }

    private void handleAddColorNote(final Activity activity) {
        MiniAppConfig miniAppConfig = this.mAppConfig;
        if (miniAppConfig != null && miniAppConfig.config != null) {
            this.colorNote.updateColorNote(getMiniAppInfo(miniAppConfig));
            this.colorNote.addToColorNote(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.3
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Boolean bool) {
                    QLog.i(MiniSharePanelFragment.TAG, 1, "handleAddColorNote isAdd:" + bool);
                    if (bool.booleanValue()) {
                        QQToast.makeText(activity, 2, "\u5f69\u7b7e\u5df2\u6dfb\u52a0", 1).show();
                        activity.finish();
                        return null;
                    }
                    QQToast.makeText(activity, 1, "\u5f69\u7b7e\u6dfb\u52a0\u5931\u8d25", 1).show();
                    return null;
                }
            });
        } else {
            QLog.e(TAG, 1, "handleAddColorNote mAppConfig is null");
            QQToast.makeText(activity, 2, "\u5f69\u7b7e\u6dfb\u52a0\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5~", 1).show();
        }
    }

    private void handleRemoveColorNote() {
        this.colorNote.removeColorNote();
    }

    private void handleShortCut(Activity activity) {
        MiniAppConfig miniAppConfig = this.mAppConfig;
        if (miniAppConfig != null && miniAppConfig.config != null) {
            com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
            MiniAppInfo miniAppInfo2 = this.mAppConfig.config;
            miniAppInfo.appId = miniAppInfo2.appId;
            miniAppInfo.name = miniAppInfo2.name;
            miniAppInfo.iconUrl = miniAppInfo2.iconUrl;
            ShortcutUtils.f(activity, miniAppInfo);
            return;
        }
        QLog.e(TAG, 1, "handleShortCut mAppConfig is null");
        MiniGameVAUtil.showDebugToast("\u627e\u4e0d\u5230\u5bf9\u5e94\u7684AppId");
    }

    private void initColorNote(Activity activity, InitColorNoteCallback initColorNoteCallback) {
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
        miniAppInfo.appId = this.miniArkShareModel.getAppId();
        miniAppInfo.verType = 3;
        miniAppInfo.name = "";
        miniAppInfo.iconUrl = "";
        miniAppInfo.desc = "";
        this.colorNote = new MiniGameVAColorNote(activity, miniAppInfo, initColorNoteCallback);
    }

    private boolean isClickable() {
        if (System.currentTimeMillis() - this.mLastClickTime <= 1000) {
            return false;
        }
        this.mLastClickTime = System.currentTimeMillis();
        return true;
    }

    private void jumpAboutPage(Activity activity) {
        QLog.d(TAG, 1, "jumpAboutPage mAppConfig=" + this.mAppConfig);
        if (this.mAppConfig != null) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMainPageFragment(activity, this.mAppConfig, this.miniArkShareModel.getVersionType());
        } else {
            QQToast.makeText(activity, 0, R.string.iuo, 1).show();
        }
        dismiss();
    }

    private void jumpSettingPage(Activity activity) {
        QPublicFragmentActivity.start(activity, activity.getIntent(), MiniGameVASettingFragment.class);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToWeChat$3(final int i3, final Activity activity, boolean z16, JSONObject jSONObject) {
        long j3;
        String str;
        QLog.d(TAG, 1, "shareToWeChat isSuc:" + z16 + ",ret=" + jSONObject);
        if (z16 && jSONObject != null) {
            this.isWxShare = true;
            final String optString = jSONObject.optString("jump_url");
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mFailedDrawable = MobileQQ.sMobileQQ.getDrawable(R.drawable.n1m);
                URLDrawable drawable = URLDrawable.getDrawable(this.miniArkShareModel.getPicUrl(), obtain);
                drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.5
                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadSuccessed(URLDrawable uRLDrawable) {
                        Bitmap drawableToBitmap = ImageUtil.drawableToBitmap(uRLDrawable.getCurrDrawable());
                        MiniSharePanelFragment miniSharePanelFragment = MiniSharePanelFragment.this;
                        miniSharePanelFragment.shareToWeChat(i3, miniSharePanelFragment.miniArkShareModel.getDescription(), MiniSharePanelFragment.this.miniArkShareModel.getTitle(), drawableToBitmap, optString);
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                        QLog.e(MiniSharePanelFragment.TAG, 1, "startShareToWeChat. onLoadFialed when handling URLbmp");
                        MiniSharePanelFragment miniSharePanelFragment = MiniSharePanelFragment.this;
                        miniSharePanelFragment.shareToWeChat(i3, miniSharePanelFragment.miniArkShareModel.getDescription(), MiniSharePanelFragment.this.miniArkShareModel.getTitle(), null, optString);
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadCanceled(URLDrawable uRLDrawable) {
                    }

                    @Override // com.tencent.image.URLDrawable.URLDrawableListener
                    public void onLoadProgressed(URLDrawable uRLDrawable, int i16) {
                    }
                });
                if (drawable.getStatus() == 1) {
                    shareToWeChat(i3, this.miniArkShareModel.getDescription(), this.miniArkShareModel.getTitle(), ImageUtil.drawableToBitmap(drawable.getCurrDrawable()), optString);
                } else if (drawable.getStatus() != 1) {
                    drawable.startDownload();
                }
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "startShareToWeChat. get an exception when handling URLbmp:" + e16);
                shareToWeChat(i3, this.miniArkShareModel.getDescription(), this.miniArkShareModel.getTitle(), null, optString);
                return;
            }
        }
        if (jSONObject != null) {
            j3 = jSONObject.optLong("retCode");
            str = jSONObject.optString("errMsg");
        } else {
            j3 = -1;
            str = null;
        }
        final String str2 = str;
        final long j16 = j3;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.i
            @Override // java.lang.Runnable
            public final void run() {
                MiniSharePanelFragment.this.lambda$shareToWeChat$2(j16, activity, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareActionSheet(int i3, int i16) {
        MiniGameVAColorNote miniGameVAColorNote;
        QLog.i(TAG, 1, "showShareActionSheet topType=" + i3);
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            ArrayList arrayList = new ArrayList();
            Intent intent = getIntent();
            if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QQ, false)) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
            }
            if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QZONE, false)) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
            }
            if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_FRIENDS, false)) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
            }
            if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_MOMENT, false)) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
            }
            ArrayList arrayList2 = new ArrayList();
            if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_COMPLAINT, false)) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(151));
            }
            if (getIntent().getIntExtra("key_color_note", 0) == 1 && (miniGameVAColorNote = this.colorNote) != null) {
                boolean isExistColorNote = miniGameVAColorNote.isExistColorNote();
                QLog.i(TAG, 1, "colorNote exist:" + isExistColorNote);
                if (isExistColorNote) {
                    arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(82));
                } else {
                    arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(70));
                }
            }
            if (i3 == 0) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(76));
            } else if (i3 != -11) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(77));
            }
            if (getIntent().getBooleanExtra(MiniChatConstants.MINI_APP_ADD_SHORTCUT, false)) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
            }
            if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_DETAIL, false)) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(78));
            }
            if (intent.getBooleanExtra(MiniChatConstants.MINI_APP_SHOW_SETTING, false)) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(83));
            }
            QLog.i(TAG, 1, "shareActionSheet maxWidth=" + i16);
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.fullScreen = true;
            param.context = activity;
            param.dimAmount = 0.0f;
            ShareActionSheet create = ShareActionSheetFactory.create(param);
            this.shareActionSheet = create;
            create.setRowVisibility(8, 0, 0);
            this.shareActionSheet.setEnableNotTriggerVirtualNavigationBar(true);
            this.shareActionSheet.setActionSheetItems(arrayList, arrayList2);
            this.shareActionSheet.setItemClickListenerV2(this);
            this.shareActionSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.mini.activity.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MiniSharePanelFragment.this.lambda$showShareActionSheet$0(dialogInterface);
                }
            });
            this.shareActionSheet.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.mini.activity.h
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    MiniSharePanelFragment.this.lambda$showShareActionSheet$1(dialogInterface);
                }
            });
            this.shareActionSheet.show();
            LinearLayout linearLayout = (LinearLayout) this.shareActionSheet.findViewById(R.id.f163935cx);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(this);
                linearLayout.setGravity(81);
                ((LinearLayout) linearLayout.findViewById(R.id.s_6)).getLayoutParams().width = i16;
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "showShareActionSheet but activity is destroy, return!");
    }

    public void addMyMiniApp() {
        ((IMiniShareApi) QRoute.api(IMiniShareApi.class)).addMyMiniApp(this.miniArkShareModel.getAppId(), this.miniArkShareModel.getVersionType(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.8

            /* renamed from: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment$8$1, reason: invalid class name */
            /* loaded from: classes33.dex */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ boolean val$isSuc;

                AnonymousClass1(boolean z16) {
                    this.val$isSuc = z16;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void lambda$run$0(boolean z16, Bundle bundle) {
                    QLog.d(MiniSharePanelFragment.TAG, 2, "setMiniAppTop updateTopTypeByAppId success=" + z16);
                }

                @Override // java.lang.Runnable
                public void run() {
                    FragmentActivity activity = MiniSharePanelFragment.this.getActivity();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    if (this.val$isSuc) {
                        QLog.d(MiniSharePanelFragment.TAG, 2, "setMiniAppTop success");
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateTopTypeByAppId(MiniSharePanelFragment.this.miniArkShareModel.getAppId(), 1, new IMiniCallback() { // from class: com.tencent.mobileqq.mini.activity.j
                            @Override // com.tencent.mobileqq.mini.api.IMiniCallback
                            public final void onCallbackResult(boolean z16, Bundle bundle) {
                                MiniSharePanelFragment.AnonymousClass8.AnonymousClass1.lambda$run$0(z16, bundle);
                            }
                        });
                    } else {
                        QQToast.makeText(activity, R.string.f226616ot, 0).show();
                        QLog.e(MiniSharePanelFragment.TAG, 1, "setMiniAppTop fail");
                    }
                    MiniSharePanelFragment.this.dismiss();
                }
            }

            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                ThreadManagerV2.getUIHandlerV2().post(new AnonymousClass1(z16));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void doResume() {
        super.doResume();
        QLog.d(TAG, 1, "doResume bLateFinish=" + this.bLateFinish);
        if (this.bLateFinish) {
            dismiss();
            return;
        }
        if (getUserVisibleHint()) {
            handleFullScreen(getActivity());
        }
        MiniGameVAColorNote miniGameVAColorNote = this.colorNote;
        if (miniGameVAColorNote != null) {
            miniGameVAColorNote.onResume();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        handleFullScreen(activity);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.d(TAG, 1, "onActivityResult requestCode=" + i3 + ",resultCode=" + i16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Serializable serializableExtra = getIntent().getSerializableExtra(MiniChatConstants.MINI_APP_ARK_MODEL);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreate miniArkShareModel=" + serializableExtra);
        }
        if (!(serializableExtra instanceof MiniArkShareModel)) {
            finish();
            return;
        }
        this.miniArkShareModel = (MiniArkShareModel) serializableExtra;
        DisplayMetrics displayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
        int i3 = displayMetrics.heightPixels;
        this.mScreenHeight = i3;
        int i16 = displayMetrics.widthPixels;
        this.mScreeWidth = i16;
        final int min = Math.min(i16, i3);
        final int miniAppTopTypeByAppId = ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppTopTypeByAppId(this.miniArkShareModel.getAppId());
        if (getIntent().getIntExtra("key_color_note", 0) == 1) {
            initColorNote(getActivity(), new InitColorNoteCallback() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.1
                @Override // com.tencent.mobileqq.minigame.va.util.InitColorNoteCallback
                public void init() {
                    MiniSharePanelFragment.this.showShareActionSheet(miniAppTopTypeByAppId, min);
                }
            });
        } else {
            showShareActionSheet(miniAppTopTypeByAppId, min);
        }
        getAppInfo();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.f168291sg, viewGroup, false);
        this.rootView = inflate;
        inflate.setOnClickListener(this);
        this.rootView.setBackgroundColor(Color.parseColor("#80000000"));
        ((FrameLayout) this.rootView.findViewById(R.id.zg5)).setVisibility(8);
        setStatusBarImmersive();
        return this.rootView;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (!isClickable()) {
                QLog.w(TAG, 1, "onItemClick isClickable false");
                return;
            }
            int i3 = actionSheetItem.action;
            if (i3 == 2) {
                shareToQQFriend(activity);
                return;
            }
            if (i3 == 3) {
                shareToQzone(activity);
                return;
            }
            if (i3 == 9) {
                shareToWeChat(activity, 3);
                return;
            }
            if (i3 == 10) {
                shareToWeChat(activity, 4);
                return;
            }
            if (i3 == 14) {
                handleShortCut(activity);
                return;
            }
            if (i3 == 70) {
                handleAddColorNote(activity);
                return;
            }
            if (i3 != 151) {
                if (i3 != 82) {
                    if (i3 != 83) {
                        switch (i3) {
                            case 76:
                                addMyMiniApp();
                                return;
                            case 77:
                                removeMyMiniApp();
                                return;
                            case 78:
                                jumpAboutPage(activity);
                                return;
                        }
                    }
                    jumpSettingPage(activity);
                    return;
                }
                handleRemoveColorNote();
                dismiss();
                return;
            }
            ((IMiniShareApi) QRoute.api(IMiniShareApi.class)).jumpReportPage(activity, this.miniArkShareModel.getAppId());
            dismiss();
            return;
        }
        QLog.w(TAG, 1, "onItemClick activity is null");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MiniGameVAColorNote miniGameVAColorNote = this.colorNote;
        if (miniGameVAColorNote != null) {
            miniGameVAColorNote.onPause();
        }
        QLog.d(TAG, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        QLog.d(TAG, 1, "onStop isWxShare=" + this.isWxShare);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean overrideFinish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        return super.overrideFinish();
    }

    public void removeMyMiniApp() {
        ((IMiniShareApi) QRoute.api(IMiniShareApi.class)).removeMyMiniApp(this.miniArkShareModel.getAppId(), this.miniArkShareModel.getVersionType(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.9

            /* renamed from: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment$9$1, reason: invalid class name */
            /* loaded from: classes33.dex */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ boolean val$isSuc;

                AnonymousClass1(boolean z16) {
                    this.val$isSuc = z16;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void lambda$run$0(boolean z16, Bundle bundle) {
                    QLog.d(MiniSharePanelFragment.TAG, 2, "removeMyMiniApp updateTopTypeByAppId success=" + z16);
                }

                @Override // java.lang.Runnable
                public void run() {
                    FragmentActivity activity = MiniSharePanelFragment.this.getActivity();
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    if (this.val$isSuc) {
                        QLog.d(MiniSharePanelFragment.TAG, 2, "removeMyMiniApp success");
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateTopTypeByAppId(MiniSharePanelFragment.this.miniArkShareModel.getAppId(), 0, new IMiniCallback() { // from class: com.tencent.mobileqq.mini.activity.k
                            @Override // com.tencent.mobileqq.mini.api.IMiniCallback
                            public final void onCallbackResult(boolean z16, Bundle bundle) {
                                MiniSharePanelFragment.AnonymousClass9.AnonymousClass1.lambda$run$0(z16, bundle);
                            }
                        });
                    } else {
                        QQToast.makeText(activity, R.string.f226626ou, 0).show();
                        QLog.e(MiniSharePanelFragment.TAG, 1, "removeMyMiniApp fail");
                    }
                    MiniSharePanelFragment.this.dismiss();
                }
            }

            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                ThreadManagerV2.getUIHandlerV2().post(new AnonymousClass1(z16));
            }
        });
    }

    protected void setStatusBarImmersive() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
    }

    public void shareToWeChat(final Activity activity, final int i3) {
        QLog.i(TAG, 1, "shareToWeChat");
        if (!WXShareHelper.b0().e0()) {
            QQToast.makeText(activity, 0, R.string.f173257ih1, 1).show();
            dismiss();
        } else if (!WXShareHelper.b0().f0()) {
            QQToast.makeText(activity, 0, R.string.f173258ih2, 1).show();
            dismiss();
        } else {
            MiniProgramShareUtils.shareAsWeChatMsg(this.miniArkShareModel.getAppId(), this.miniArkShareModel.getTitle(), this.miniArkShareModel.getDescription(), 1, 1, this.miniArkShareModel.getShareBusinessType(), this.miniArkShareModel.getPicUrl(), null, this.miniArkShareModel.getJumpUrl(), this.miniArkShareModel.getIconUrl(), this.miniArkShareModel.getVersionType(), "", null, 1, this.miniArkShareModel.getShareOrigin(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.activity.f
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                    MiniSharePanelFragment.this.lambda$shareToWeChat$3(i3, activity, z16, jSONObject);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss() {
        QLog.i(TAG, 1, "dismiss...");
        ShareActionSheet shareActionSheet = this.shareActionSheet;
        if (shareActionSheet != null) {
            shareActionSheet.dismissImmediately();
        }
        finish();
    }

    private void finish() {
        QLog.i(TAG, 1, "finish...");
        FragmentActivity activity = getActivity();
        if (activity == null || getActivity().isFinishing()) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showShareActionSheet$0(DialogInterface dialogInterface) {
        QLog.i(TAG, 1, "shareActionSheet onDismiss!");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showShareActionSheet$1(DialogInterface dialogInterface) {
        QLog.i(TAG, 1, "shareActionSheet onCancel!");
        finish();
    }

    private void shareToQQFriend(Activity activity) {
        QLog.i(TAG, 1, "shareToQQFriend");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).shareAsArkMessage(activity, this.miniArkShareModel, new IMiniShareCallback() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.4
            @Override // com.tencent.mobileqq.mini.api.IMiniShareCallback
            public void onShared(boolean z16) {
                QLog.i(MiniSharePanelFragment.TAG, 1, "shareAsArkMessage onShared success=" + z16);
                if (z16) {
                    MiniSharePanelFragment.this.bLateFinish = true;
                } else {
                    QQToast.makeText(MiniSharePanelFragment.this.getActivity(), 0, R.string.hiu, 1).show();
                    MiniSharePanelFragment.this.dismiss();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QLog.i(TAG, 1, "onClick rootView");
        dismiss();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        MiniGameVAColorNote miniGameVAColorNote = this.colorNote;
        if (miniGameVAColorNote != null) {
            miniGameVAColorNote.onDestroy();
        }
    }

    private void handleFullScreen(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                Window window = activity.getWindow();
                window.addFlags(1024);
                window.addFlags(67108864);
                window.getDecorView().setSystemUiVisibility(5894);
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (Build.VERSION.SDK_INT >= 28) {
                    attributes.layoutInDisplayCutoutMode = 1;
                }
                window.setAttributes(attributes);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }

    public void shareToQzone(Activity activity) {
        QLog.i(TAG, 1, "shareToQzone");
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareQzoneForMini(activity, this.miniArkShareModel.getAppId(), this.miniArkShareModel.getTitle(), this.miniArkShareModel.getDescription(), 1, 1, this.miniArkShareModel.getShareBusinessType(), this.miniArkShareModel.getPicUrl(), this.miniArkShareModel.getJumpUrl(), this.miniArkShareModel.getIconUrl(), this.miniArkShareModel.getVersionType(), "", false, this.miniArkShareModel.getShareOrigin());
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareToWeChat(final int i3, final String str, final String str2, Bitmap bitmap, final String str3) {
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.n1m);
        }
        final Bitmap bitmap2 = bitmap;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.mForegroundChangeObserver);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.MiniSharePanelFragment.7
            @Override // java.lang.Runnable
            public void run() {
                Bitmap compressBitmapForWXShare = ShareUtils.compressBitmapForWXShare(bitmap2);
                int i16 = i3;
                if (i16 == 3) {
                    WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), str, compressBitmapForWXShare, "QQ\u5c0f\u7a0b\u5e8f \u00b7 " + str2, str3);
                    return;
                }
                if (i16 == 4) {
                    WXShareHelper.b0().N0(String.valueOf(System.currentTimeMillis()), "QQ\u5c0f\u7a0b\u5e8f \u00b7 " + str2 + MsgSummary.STR_COLON + str, compressBitmapForWXShare, "", str3);
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToWeChat$2(long j3, Activity activity, String str) {
        if (j3 == -100070004 || j3 == -1000710003) {
            QQToast.makeText(activity, 0, R.string.f167662dj, 1).show();
        } else if (j3 == -100070016) {
            QQToast.makeText(activity, 0, str, 1).show();
        } else {
            QQToast.makeText(activity, 0, R.string.c_y, 1).show();
        }
        dismiss();
    }
}
