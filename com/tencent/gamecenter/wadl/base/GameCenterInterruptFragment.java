package com.tencent.gamecenter.wadl.base;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.base.GameCenterInterruptFragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.d;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nl0.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqgame.QQGameIntercept$GetDownloadTipsResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J,\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00102\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010'R\u0016\u00104\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010'R\u0018\u00107\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010;\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00106R\u0018\u0010=\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106\u00a8\u0006B"}, d2 = {"Lcom/tencent/gamecenter/wadl/base/GameCenterInterruptFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "", "initData", "setStatusBarImmersive", "", "operId", "operType", "ext6", "appid", "Dh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onPostThemeChanged", "", "needStatusTrans", "needImmersive", "v", NodeProps.ON_CLICK, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "mIvGameLogo", "Landroid/widget/Button;", "E", "Landroid/widget/Button;", "mClickOfficialBtn", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mClickGoOnBtn", "G", "mClickCancelBtn", "H", "mTvGameName", "I", "mTvGameInstallSource", "J", "mTvInstallRemind", "K", "mTvInstallTip", "L", "mTvOfficialDesc", "M", "Ljava/lang/String;", "mOrignUrl", "N", "mAppId", "P", "mGameName", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mOfficialBtnUrl", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GameCenterInterruptFragment extends QPublicBaseFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mIvGameLogo;

    /* renamed from: E, reason: from kotlin metadata */
    private Button mClickOfficialBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mClickGoOnBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mClickCancelBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mTvGameName;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mTvGameInstallSource;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mTvInstallRemind;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mTvInstallTip;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView mTvOfficialDesc;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private String mOrignUrl = "";

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String mAppId = "";

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private String mGameName = "";

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String mOfficialBtnUrl = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/gamecenter/wadl/base/GameCenterInterruptFragment$b", "Lnl0/f;", "Ltencent/im/qqgame/QQGameIntercept$GetDownloadTipsResponse;", "response", "", "b", "a", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements f {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GameCenterInterruptFragment this$0, QQGameIntercept$GetDownloadTipsResponse response) {
            CharSequence charSequence;
            CharSequence charSequence2;
            CharSequence charSequence3;
            CharSequence charSequence4;
            CharSequence charSequence5;
            CharSequence charSequence6;
            String str;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(response, "$response");
            TextView textView = this$0.mTvGameName;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGameName");
                textView = null;
            }
            textView.setText(this$0.mGameName);
            TextView textView2 = this$0.mTvGameInstallSource;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGameInstallSource");
                textView2 = null;
            }
            if (StringUtil.isEmpty(response.download_source.get())) {
                TextView textView3 = this$0.mTvGameInstallSource;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvGameInstallSource");
                    textView3 = null;
                }
                charSequence = textView3.getText();
            } else {
                charSequence = response.download_source.get();
            }
            textView2.setText(charSequence);
            TextView textView4 = this$0.mTvInstallRemind;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvInstallRemind");
                textView4 = null;
            }
            if (StringUtil.isEmpty(response.safety_reminder.get())) {
                TextView textView5 = this$0.mTvInstallRemind;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvInstallRemind");
                    textView5 = null;
                }
                charSequence2 = textView5.getText();
            } else {
                charSequence2 = response.safety_reminder.get();
            }
            textView4.setText(charSequence2);
            TextView textView6 = this$0.mTvOfficialDesc;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvOfficialDesc");
                textView6 = null;
            }
            if (StringUtil.isEmpty(response.download_reminder.get())) {
                TextView textView7 = this$0.mTvOfficialDesc;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvOfficialDesc");
                    textView7 = null;
                }
                charSequence3 = textView7.getText();
            } else {
                charSequence3 = response.download_reminder.get();
            }
            textView6.setText(charSequence3);
            Button button = this$0.mClickOfficialBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mClickOfficialBtn");
                button = null;
            }
            if (StringUtil.isEmpty(response.download_button.get())) {
                Button button2 = this$0.mClickOfficialBtn;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mClickOfficialBtn");
                    button2 = null;
                }
                charSequence4 = button2.getText();
            } else {
                charSequence4 = response.download_button.get();
            }
            button.setText(charSequence4);
            TextView textView8 = this$0.mClickGoOnBtn;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mClickGoOnBtn");
                textView8 = null;
            }
            if (StringUtil.isEmpty(response.continue_button.get())) {
                TextView textView9 = this$0.mClickGoOnBtn;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mClickGoOnBtn");
                    textView9 = null;
                }
                charSequence5 = textView9.getText();
            } else {
                charSequence5 = response.continue_button.get();
            }
            textView8.setText(charSequence5);
            TextView textView10 = this$0.mClickCancelBtn;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mClickCancelBtn");
                textView10 = null;
            }
            if (StringUtil.isEmpty(response.cancel_button.get())) {
                TextView textView11 = this$0.mClickCancelBtn;
                if (textView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mClickCancelBtn");
                    textView11 = null;
                }
                charSequence6 = textView11.getText();
            } else {
                charSequence6 = response.cancel_button.get();
            }
            textView10.setText(charSequence6);
            if (StringUtil.isEmpty(response.download_url.get())) {
                str = this$0.mOrignUrl;
            } else {
                str = response.download_url.get();
            }
            this$0.mOfficialBtnUrl = str;
            URLDrawable drawable = URLDrawable.getDrawable(response.icon.get());
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(response.icon.get())");
            ImageView imageView2 = this$0.mIvGameLogo;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvGameLogo");
            } else {
                imageView = imageView2;
            }
            imageView.setBackground(drawable);
        }

        @Override // nl0.f
        public void a() {
            QLog.e("Wadl_GameCenterInterruptFragment", 1, "requestInterceptPageConfig fail");
        }

        @Override // nl0.f
        public void b(@NotNull final QQGameIntercept$GetDownloadTipsResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GameCenterInterruptFragment gameCenterInterruptFragment = GameCenterInterruptFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: ml0.c
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterInterruptFragment.b.d(GameCenterInterruptFragment.this, response);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(GameCenterInterruptFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).requestInterceptPageConfig(this$0.mAppId, new b());
    }

    private final void Dh(final String operId, final String operType, final String ext6, final String appid) {
        ThreadManagerV2.excute(new Runnable() { // from class: ml0.b
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterInterruptFragment.Eh(operType, operId, ext6, appid);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(String operType, String operId, String str, String str2) {
        Intrinsics.checkNotNullParameter(operType, "$operType");
        Intrinsics.checkNotNullParameter(operId, "$operId");
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_ATTA_05076).setOperType(operType).setOperId(operId).setModuleType("55802").setOperModule(WadlProxyConsts.OPER_MODULE_GAMECENTER).setExt(6, str).setGameAppId(str2);
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).reportDC(wadlReportBuilder);
    }

    private final void initData() {
        String str;
        String str2;
        String str3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("orign_appid");
        } else {
            str = null;
        }
        this.mOrignUrl = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("game_appid");
        } else {
            str2 = null;
        }
        this.mAppId = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str3 = arguments3.getString(CrashRtInfoHolder.BeaconKey.GAME_NAME);
        } else {
            str3 = null;
        }
        this.mGameName = str3;
        QLog.i("Wadl_GameCenterInterruptFragment", 2, "initdata<<<orignUrl: " + this.mOrignUrl + " appid: " + this.mAppId + " mGameName:" + str3);
        ThreadManagerV2.excute(new Runnable() { // from class: ml0.a
            @Override // java.lang.Runnable
            public final void run() {
                GameCenterInterruptFragment.Ch(GameCenterInterruptFragment.this);
            }
        }, 128, null, true);
    }

    private final void setStatusBarImmersive() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ImmersiveUtils.setStatusTextColor(true ^ QQTheme.isNowThemeIsNight(), activity.getWindow());
            }
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        Map mutableMapOf;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.tdi) {
            if (StringUtil.isEmpty(this.mOfficialBtnUrl)) {
                this.mOfficialBtnUrl = this.mOrignUrl;
            }
            QLog.i("Wadl_GameCenterInterruptFragment", 2, "btn_click_official " + this.mOfficialBtnUrl);
            Dh("907320", "20", this.mOrignUrl, this.mAppId);
            GameCenterUtil.gotoGameCenterPage(this.mOfficialBtnUrl);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else if (num != null && num.intValue() == R.id.f1067869n) {
            QLog.i("Wadl_GameCenterInterruptFragment", 2, "tv_click_goon " + this.mOrignUrl);
            Dh("907322", "20", this.mOrignUrl, this.mAppId);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("wadl_intercept", "1"));
            GameCenterUtil.gotoBrowserActivityWithParams(getActivity(), this.mOrignUrl, mutableMapOf);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (num != null && num.intValue() == R.id.f1067769m) {
            Dh("907323", "20", this.mOrignUrl, this.mAppId);
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f167987eb4, container, false);
        View findViewById = inflate.findViewById(R.id.y3m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.iv_game_logo)");
        this.mIvGameLogo = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tdi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.btn_click_official)");
        Button button = (Button) findViewById2;
        this.mClickOfficialBtn = button;
        View view = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClickOfficialBtn");
            button = null;
        }
        button.setOnClickListener(this);
        View findViewById3 = inflate.findViewById(R.id.f1067869n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.tv_click_goon)");
        TextView textView = (TextView) findViewById3;
        this.mClickGoOnBtn = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClickGoOnBtn");
            textView = null;
        }
        textView.setOnClickListener(this);
        View findViewById4 = inflate.findViewById(R.id.f1067769m);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.tv_click_cancel)");
        TextView textView2 = (TextView) findViewById4;
        this.mClickCancelBtn = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClickCancelBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View findViewById5 = inflate.findViewById(R.id.k8b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.tv_game_name)");
        this.mTvGameName = (TextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f108196cg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.tv_game_source)");
        this.mTvGameInstallSource = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f108796e3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.tv_install_remind)");
        this.mTvInstallRemind = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f1067969o);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "it.findViewById(R.id.tv_click_official_desc)");
        this.mTvOfficialDesc = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f108806e4);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "it.findViewById(R.id.tv_install_tip)");
        this.mTvInstallTip = (TextView) findViewById9;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026tv_install_tip)\n        }");
        this.mRootView = inflate;
        onPostThemeChanged();
        initData();
        Dh("907321", "8", this.mOrignUrl, this.mAppId);
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view2;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        setStatusBarImmersive();
        TextView textView = null;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        QLog.i("Wadl_GameCenterInterruptFragment", 2, "---onPostThemeChanged---isNightTheme\uff1a" + isNowThemeIsNight);
        d.b(getActivity(), isNowThemeIsNight ^ true);
        if (isNowThemeIsNight) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                TextView textView2 = this.mTvGameName;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvGameName");
                    textView2 = null;
                }
                if (textView2 != null) {
                    textView2.setTextColor(activity.getResources().getColor(R.color.f158017al3));
                }
                TextView textView3 = this.mTvInstallRemind;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvInstallRemind");
                    textView3 = null;
                }
                if (textView3 != null) {
                    textView3.setTextColor(activity.getResources().getColor(R.color.f158017al3));
                }
                TextView textView4 = this.mTvInstallTip;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvInstallTip");
                } else {
                    textView = textView4;
                }
                if (textView != null) {
                    textView.setTextColor(activity.getResources().getColor(R.color.f158017al3));
                    return;
                }
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            TextView textView5 = this.mTvGameName;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGameName");
                textView5 = null;
            }
            if (textView5 != null) {
                textView5.setTextColor(activity2.getResources().getColor(R.color.black));
            }
            TextView textView6 = this.mTvInstallRemind;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvInstallRemind");
                textView6 = null;
            }
            if (textView6 != null) {
                textView6.setTextColor(activity2.getResources().getColor(R.color.black));
            }
            TextView textView7 = this.mTvInstallTip;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvInstallTip");
            } else {
                textView = textView7;
            }
            if (textView != null) {
                textView.setTextColor(activity2.getResources().getColor(R.color.black));
            }
        }
    }
}
