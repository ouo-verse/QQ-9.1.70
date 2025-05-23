package com.tencent.mobileqq.minigame.metafarm.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.metafarm.event.MetaFarmCardOpenEvent;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/ui/MetaFarmProfileGuideFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mRootView", "Landroid/view/View;", "getUrlDrawable", "Lcom/tencent/image/URLDrawable;", "url", "", "initView", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onStart", "reportClick", "reportShow", "setMetaFarmSwitch", "open", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmProfileGuideFragment extends BottomSheetDialogFragment {
    private static final long DELAY_UPDATE_CARD = 2000;
    private static final String GUIDE_CLOSE_BTN_URL = "https://img.gamecenter.qq.com/xgame/gm/1727316501573_81355613f0f6dfb87d9d0ee1c45ac7e5.png";
    private static final String GUIDE_CLOSE_BTN_URL_DARK = "https://img.gamecenter.qq.com/xgame/gm/1727316508419_4cd4743218f4a02a9d8bacd8e45c8ce1.png";
    private static final String GUIDE_IMG_URL = "https://img.gamecenter.qq.com/xgame/gm/1727079896828_a72ed4b3a65483c9dd1d9371356c9a98.png";
    private static final String GUIDE_IMG_URL_DARK = "https://img.gamecenter.qq.com/xgame/gm/1727079904591_308c304900a36402e8e0283aef186924.png";
    public static final String TAG = "MetaFarmProfileGuideFragment";
    private BottomSheetBehavior<?> mBehavior;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(MetaFarmProfileGuideFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setMetaFarmSwitch(false);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(MetaFarmProfileGuideFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setMetaFarmSwitch(true);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                MetaFarmProfileGuideFragment.initView$lambda$2$lambda$1();
            }
        }, 2000L);
        this$0.dismiss();
        this$0.reportClick();
        QLog.d(TAG, 1, "requestSetCardDisplaySetting");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1() {
        SimpleEventBus.getInstance().dispatchEvent(new MetaFarmCardOpenEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(MetaFarmProfileGuideFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setMetaFarmSwitch(false);
        this$0.dismiss();
    }

    private final void reportClick() {
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("5", "9529", "9739", "973902", "989665", "20", "", new HashMap());
    }

    private final void reportShow() {
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("5", "9529", "9739", "973902", "989664", "8", "", new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMetaFarmSwitch(boolean open) {
        QLog.d(TAG, 1, "openMetaFarm open:" + open);
        ArrayList<ReqSetSettingItem> arrayList = new ArrayList<>();
        arrayList.add(new ReqSetSettingItem(ProfileContants.FIELD_META_FARM_SWITCH, 0, open ? 1 : 2));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IProfileSettingApi iProfileSettingApi = (IProfileSettingApi) QRoute.api(IProfileSettingApi.class);
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        iProfileSettingApi.requestSetCardDisplaySetting((AppInterface) peekAppRuntime, arrayList);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dk5, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026_guide_layout, container)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        initView(inflate);
        reportShow();
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(0);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        BottomSheetBehavior<FrameLayout> behavior = aVar != null ? aVar.getBehavior() : null;
        this.mBehavior = behavior;
        if (behavior != null) {
            behavior.setState(3);
        }
        BottomSheetBehavior<?> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(0);
        }
        BottomSheetBehavior<?> bottomSheetBehavior2 = this.mBehavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.addBottomSheetCallback(new BottomSheetBehavior.e() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.MetaFarmProfileGuideFragment$onStart$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
                public void onSlide(View bottomSheet, float slideOffset) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
                public void onStateChanged(View bottomSheet, int newState) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    if (newState == 4) {
                        MetaFarmProfileGuideFragment.this.setMetaFarmSwitch(false);
                        MetaFarmProfileGuideFragment.this.dismiss();
                    }
                }
            });
        }
    }

    private final URLDrawable getUrlDrawable(String url) {
        if (url == null || url.length() == 0) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        return URLDrawable.getDrawable(url, obtain);
    }

    private final void initView(View rootView) {
        String str;
        String str2;
        rootView.findViewById(R.id.rf7).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MetaFarmProfileGuideFragment.initView$lambda$0(MetaFarmProfileGuideFragment.this, view);
            }
        });
        ((QUIButton) rootView.findViewById(R.id.rcj)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MetaFarmProfileGuideFragment.initView$lambda$2(MetaFarmProfileGuideFragment.this, view);
            }
        });
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rf5);
        TextView textView = (TextView) rootView.findViewById(R.id.rly);
        TextView textView2 = (TextView) rootView.findViewById(R.id.rlv);
        URLImageView uRLImageView = (URLImageView) rootView.findViewById(R.id.rcf);
        uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MetaFarmProfileGuideFragment.initView$lambda$3(MetaFarmProfileGuideFragment.this, view);
            }
        });
        if (isNowThemeIsNight) {
            relativeLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.ioa));
            textView.setTextColor(-1);
            textView2.setTextColor(-1);
            str = GUIDE_IMG_URL_DARK;
            str2 = GUIDE_CLOSE_BTN_URL_DARK;
        } else {
            relativeLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.io_));
            textView.setTextColor(-16777216);
            textView2.setTextColor(-16777216);
            str = GUIDE_IMG_URL;
            str2 = GUIDE_CLOSE_BTN_URL;
        }
        uRLImageView.setImageDrawable(getUrlDrawable(str2));
        URLImageView uRLImageView2 = (URLImageView) rootView.findViewById(R.id.f163677re4);
        int screenWidth = ViewUtils.getScreenWidth() - x.a(32.0f);
        int i3 = (int) ((screenWidth * 167.0f) / 343.0f);
        uRLImageView2.setImageDrawable(getUrlDrawable(str));
        ViewGroup.LayoutParams layoutParams = uRLImageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = screenWidth;
        }
        ViewGroup.LayoutParams layoutParams2 = uRLImageView2.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = i3;
        }
        int a16 = x.a(360.0f) + (i3 - x.a(167.0f));
        ViewGroup.LayoutParams layoutParams3 = relativeLayout.getLayoutParams();
        if (layoutParams3 == null) {
            return;
        }
        layoutParams3.height = a16;
    }
}
