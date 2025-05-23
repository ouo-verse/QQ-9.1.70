package com.tencent.mobileqq.profilecard.component;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileMusicDataBean;
import com.tencent.mobileqq.profilecard.data.ProfileMusicDataGeneBean;
import com.tencent.mobileqq.profilecard.data.ProfileMusicDataMedalBean;
import com.tencent.mobileqq.profilecard.utils.ProfileEditSelectorHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0017\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010<\u001a\u00020\u0002\u00a2\u0006\u0004\b=\u0010>J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J0\u0010\u0012\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002J&\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u001c\u0010\"\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010#\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010$\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001b018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00105\u001a\b\u0018\u000104R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/profilecard/component/ProfileMusicDataComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "data", "Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataBean;", "bean", "", "initView", "", "needShow", "isAuthorized", "Landroid/view/View;", "view", "", "elementId", "", "", "params", "initDT", "authLayout", "dataLayout", "initAuthLayout", "initDataLayout", "url", WadlProxyConsts.KEY_JUMP_URL, "showGuide", "adjustFontSize", "", "getComponentType", "getComponentName", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onDataUpdate", "reportImpDelay", "getProfileContentKey", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "geneLayout", "medalLayout", "Lcom/tencent/mobileqq/widget/tip/a;", "bubbleTip", "Lcom/tencent/mobileqq/widget/tip/a;", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "musicData", "Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataBean;", "Ljava/util/concurrent/ConcurrentHashMap;", "reportedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/profilecard/component/ProfileMusicDataComponent$ReportImpRunnable;", "mReportImpRunnable", "Lcom/tencent/mobileqq/profilecard/component/ProfileMusicDataComponent$ReportImpRunnable;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mOnGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "componentCenter", "cardInfo", "<init>", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "Companion", "ReportImpRunnable", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ProfileMusicDataComponent extends AbsProfileContentComponent {
    private static final String ELEMENT_EM_DATACARD_AUTHORIZE_CARD = "em_datacard_authorizecard";
    private static final String ELEMENT_EM_DATACARD_MUSIC_DNA_CARD = "em_datacard_music_dna_card";
    private static final String ELEMENT_EM_DATACARD_MUSIC_MEDAL_CARD = "em_datacard_music_medal_card";
    private static final String ELEMENT_PARAM_BADGES_NUMBER = "badges_number";
    public static final String KEY_PROFILE_MUSIC_DATA_GUIDE_SWITCH = "profile_music_data_guide_switch";
    private static final int MAX_RETRY_COUNT = 3;
    private static final int PRIVACY_STATUS_DEFAULT = 4;
    public static final String TAG = "ProfileMusicDataComponent";
    private static final String TITLE_JUMP_URL = "https://i2.y.qq.com/n3/other/pages/mqq/recent.html?_wv=3&uin=";
    private static final String VAS_TRAN_BG_URL_KEY = "https://h5.vip.qq.com/p/pay";
    private View authLayout;
    private com.tencent.mobileqq.widget.tip.a bubbleTip;
    private ProfileCardInfo data;
    private View dataLayout;
    private View geneLayout;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private ReportImpRunnable mReportImpRunnable;
    private View medalLayout;
    private ProfileMusicDataBean musicData;
    private ConcurrentHashMap<String, Integer> reportedMap;
    private View rootView;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/profilecard/component/ProfileMusicDataComponent$ReportImpRunnable;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "elementId", "", "params", "", "", "(Lcom/tencent/mobileqq/profilecard/component/ProfileMusicDataComponent;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;)V", "getElementId", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "getView", "()Landroid/view/View;", TencentLocation.RUN_MODE, "", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public final class ReportImpRunnable implements Runnable {
        private final String elementId;
        private final Map<String, Object> params;
        final /* synthetic */ ProfileMusicDataComponent this$0;
        private final View view;

        public ReportImpRunnable(ProfileMusicDataComponent profileMusicDataComponent, View view, String elementId, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            this.this$0 = profileMusicDataComponent;
            this.view = view;
            this.elementId = elementId;
            this.params = map;
        }

        public final String getElementId() {
            return this.elementId;
        }

        public final Map<String, Object> getParams() {
            return this.params;
        }

        public final View getView() {
            return this.view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.this$0.reportImpDelay(this.view, this.elementId, this.params);
            } catch (Exception e16) {
                QLog.w(ProfileMusicDataComponent.TAG, 1, "[ReportImpRunnable] Exception", e16);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMusicDataComponent(IComponentCenter componentCenter, ProfileCardInfo cardInfo) {
        super(componentCenter, cardInfo);
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.reportedMap = new ConcurrentHashMap<>();
    }

    private final void adjustFontSize() {
        View view = this.rootView;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.otk) : null;
        View view2 = this.rootView;
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.f163216oy0) : null;
        View view3 = this.rootView;
        ImageView imageView = view3 != null ? (ImageView) view3.findViewById(R.id.ovl) : null;
        View view4 = this.rootView;
        TextView textView3 = view4 != null ? (TextView) view4.findViewById(R.id.oxt) : null;
        ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        ViewGroup.LayoutParams layoutParams3 = textView2 != null ? textView2.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        ViewGroup.LayoutParams layoutParams5 = imageView != null ? imageView.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        ViewGroup.LayoutParams layoutParams7 = textView3 != null ? textView3.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        if (FontSettingManager.getFontLevel() >= 21.24f) {
            ViewUtils viewUtils = ViewUtils.f352270a;
            layoutParams4.leftMargin = viewUtils.a(8.0f);
            layoutParams6.rightMargin = viewUtils.a(33.0f);
            layoutParams8.rightMargin = viewUtils.a(8.0f);
            layoutParams2.topMargin = viewUtils.a(9.0f);
            if (textView != null) {
                textView.setMaxWidth(viewUtils.a(115.0f));
            }
        } else if (FontSettingManager.getFontLevel() >= 17.0f) {
            ViewUtils viewUtils2 = ViewUtils.f352270a;
            layoutParams4.leftMargin = viewUtils2.a(28.0f);
            layoutParams6.rightMargin = viewUtils2.a(43.0f);
            layoutParams8.rightMargin = viewUtils2.a(8.0f);
            layoutParams2.topMargin = viewUtils2.a(18.0f);
            if (textView != null) {
                textView.setMaxWidth(viewUtils2.a(115.0f));
            }
        } else {
            ViewUtils viewUtils3 = ViewUtils.f352270a;
            layoutParams4.leftMargin = viewUtils3.a(38.0f);
            layoutParams6.rightMargin = viewUtils3.a(53.0f);
            layoutParams8.rightMargin = viewUtils3.a(28.0f);
            layoutParams2.topMargin = viewUtils3.a(17.0f);
            if (textView != null) {
                textView.setMaxWidth(viewUtils3.b(Integer.MAX_VALUE));
            }
        }
        textView2.setLayoutParams(layoutParams4);
        imageView.setLayoutParams(layoutParams6);
        textView3.setLayoutParams(layoutParams8);
        textView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAuthLayout$lambda$1(ProfileMusicDataComponent this$0, View view, View view2, ProfileMusicDataBean profileMusicDataBean, View view3) {
        Card card;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String lastLoginUin = MobileQQ.getMobileQQ().getLastLoginUin();
        ProfileCardInfo profileCardInfo = this$0.data;
        if (Intrinsics.areEqual(lastLoginUin, (profileCardInfo == null || (card = profileCardInfo.card) == null) ? null : card.uin)) {
            ProfileEditSelectorHelper.getInstance().setPrivacy(ProfileContants.FIELD_MUSIC_DATA_SWITCH, 4, 1);
            if (view != null) {
                view.setVisibility(8);
            }
            if (view2 != null) {
                view2.setVisibility(0);
            }
            this$0.initDataLayout(profileMusicDataBean);
            VideoReport.reportEvent("clck", view, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataLayout$lambda$2(ProfileMusicDataComponent this$0, ProfileMusicDataBean profileMusicDataBean, HashMap medalParams, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(medalParams, "$medalParams");
        ProfileMusicDataMedalBean medalBean = profileMusicDataBean.getMedalBean();
        this$0.jumpUrl(medalBean != null ? medalBean.getJumpUrl() : null);
        VideoReport.reportEvent("clck", this$0.medalLayout, medalParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataLayout$lambda$3(ProfileMusicDataComponent this$0, ProfileMusicDataBean profileMusicDataBean, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.widget.tip.a aVar = this$0.bubbleTip;
        if (aVar != null) {
            aVar.o();
        }
        ProfileMusicDataGeneBean geneBean = profileMusicDataBean.getGeneBean();
        this$0.jumpUrl(geneBean != null ? geneBean.getJumpUrl() : null);
        VideoReport.reportEvent("clck", this$0.geneLayout, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataLayout$lambda$5(ProfileMusicDataComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Rect rect = new Rect();
        View view = this$0.geneLayout;
        Boolean valueOf = view != null ? Boolean.valueOf(view.getGlobalVisibleRect(rect)) : null;
        if (valueOf == null || !valueOf.booleanValue()) {
            return;
        }
        this$0.showGuide(this$0.geneLayout);
    }

    /* JADX WARN: Type inference failed for: r9v5, types: [android.view.View, VIEW] */
    private final void initView(final ProfileCardInfo data, ProfileMusicDataBean bean) {
        QBaseActivity qBaseActivity;
        if (this.rootView == null && (qBaseActivity = this.mActivity) != null) {
            View inflate = LayoutInflater.from(qBaseActivity).inflate(R.layout.czf, (ViewGroup) null);
            this.rootView = inflate;
            this.authLayout = inflate != null ? (RelativeLayout) inflate.findViewById(R.id.otl) : null;
            View view = this.rootView;
            this.dataLayout = view != null ? (LinearLayout) view.findViewById(R.id.f163198ou2) : null;
            View view2 = this.rootView;
            this.geneLayout = view2 != null ? (RelativeLayout) view2.findViewById(R.id.ouo) : null;
            View view3 = this.rootView;
            this.medalLayout = view3 != null ? (RelativeLayout) view3.findViewById(R.id.ovy) : null;
        }
        View view4 = this.rootView;
        ImageView imageView = view4 != null ? (ImageView) view4.findViewById(R.id.oxl) : null;
        View view5 = this.rootView;
        TextView textView = view5 != null ? (TextView) view5.findViewById(R.id.oxn) : null;
        View view6 = this.rootView;
        ImageView imageView2 = view6 != null ? (ImageView) view6.findViewById(R.id.ouy) : null;
        View view7 = this.rootView;
        if (view7 != null) {
            view7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    ProfileMusicDataComponent.initView$lambda$0(ProfileMusicDataComponent.this, data, view8);
                }
            });
        }
        if (isAuthorized(data)) {
            View view8 = this.authLayout;
            if (view8 != null) {
                view8.setVisibility(8);
            }
            View view9 = this.dataLayout;
            if (view9 != null) {
                view9.setVisibility(0);
            }
            initDataLayout(bean);
        } else {
            View view10 = this.authLayout;
            if (view10 != null) {
                view10.setVisibility(0);
            }
            View view11 = this.dataLayout;
            if (view11 != null) {
                view11.setVisibility(8);
            }
            initAuthLayout(bean, this.authLayout, this.dataLayout);
        }
        adjustFontSize();
        this.mViewContainer = this.rootView;
        updateItemTheme(null, textView, imageView, null, imageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ProfileMusicDataComponent this$0, ProfileCardInfo profileCardInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            ProfileMusicDataBean profileMusicDataBean = this$0.musicData;
            if (!TextUtils.isEmpty(profileMusicDataBean != null ? profileMusicDataBean.getRecentListening() : null)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("jumpBy RecentListening ");
                ProfileMusicDataBean profileMusicDataBean2 = this$0.musicData;
                sb5.append(profileMusicDataBean2 != null ? profileMusicDataBean2.getRecentListening() : null);
                QLog.i(TAG, 1, sb5.toString());
                ProfileMusicDataBean profileMusicDataBean3 = this$0.musicData;
                this$0.jumpUrl(profileMusicDataBean3 != null ? profileMusicDataBean3.getRecentListening() : null);
                return;
            }
            if ((profileCardInfo != null ? profileCardInfo.card : null) != null) {
                Card card = profileCardInfo != null ? profileCardInfo.card : null;
                Intrinsics.checkNotNull(card);
                if (TextUtils.isEmpty(card.uin)) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(TITLE_JUMP_URL);
                Card card2 = profileCardInfo != null ? profileCardInfo.card : null;
                Intrinsics.checkNotNull(card2);
                sb6.append(card2.uin);
                this$0.jumpUrl(sb6.toString());
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[rootView OnClick] Exception", e16);
        }
    }

    private final void jumpUrl(String url) {
        boolean startsWith$default;
        QLog.i(TAG, 1, "jumpUrl " + url);
        if (TextUtils.isEmpty(url) || this.mActivity == null) {
            return;
        }
        Intrinsics.checkNotNull(url);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, VAS_TRAN_BG_URL_KEY, false, 2, null);
        if (startsWith$default) {
            Intent intent = new Intent(this.mActivity, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", url);
            intent.setData(Uri.parse(url));
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity != null) {
                qBaseActivity.startActivity(intent);
                return;
            }
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("url", url);
        RouteUtils.startActivity(this.mActivity, intent2, RouterConstants.UI_ROUTE_BROWSER);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1048;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_MUSIC_DATA;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity activity, Bundle savedInstanceState) {
        super.onCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        this.reportedMap.clear();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo data) {
        super.lambda$checkValidComponent$3((ProfileMusicDataComponent) data);
        if ((data != null ? data.card : null) != null && needShow(data)) {
            ProfileMusicDataBean profileMusicDataBean = (ProfileMusicDataBean) data.card.getBusinessInfo(ProfileMusicDataBean.class);
            this.musicData = profileMusicDataBean;
            if (profileMusicDataBean == null) {
                this.isForceHide = true;
                return true;
            }
            this.data = data;
            initView(data, profileMusicDataBean);
        }
        return true;
    }

    private final boolean isAuthorized(ProfileCardInfo data) {
        if ((data != null ? data.card : null) == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[isAuthorized] data.card.musicDataStatus = " + ((int) data.card.musicDataStatus) + ", data.card.recentlyListenSwitch = " + ((int) data.card.recentlyListenSwitch));
        }
        return data.card.musicDataStatus < 4;
    }

    private final boolean needShow(ProfileCardInfo data) {
        if ((data != null ? data.card : null) == null) {
            this.isForceHide = true;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "[needShow] return false data?.card = null");
            }
            return false;
        }
        short s16 = data.card.musicDataStatus;
        String lastLoginUin = MobileQQ.getMobileQQ().getLastLoginUin();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[needShow] curUin = " + lastLoginUin + ", data.card.uin = " + data.card.uin + ", status = " + ((int) s16));
        }
        if (s16 == 2) {
            if (Intrinsics.areEqual(lastLoginUin, data.card.uin)) {
                this.isForceHide = false;
                return true;
            }
            this.isForceHide = true;
            return false;
        }
        if (s16 == 3) {
            this.isForceHide = true;
            return false;
        }
        if (s16 != 4) {
            this.isForceHide = false;
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[needShow] status == 4, recentlyListenSwitch = " + ((int) data.card.recentlyListenSwitch) + ", curUin = " + lastLoginUin + ", data.card.uin = " + data.card.uin);
        }
        if (!Intrinsics.areEqual(lastLoginUin, data.card.uin)) {
            this.isForceHide = true;
            return false;
        }
        if (data.card.recentlyListenSwitch >= 1) {
            this.isForceHide = true;
            return false;
        }
        this.isForceHide = false;
        return true;
    }

    private final void showGuide(View view) {
        QBaseActivity qBaseActivity;
        if (view == null || (qBaseActivity = this.mActivity) == null || QMMKV.from(qBaseActivity, "common_mmkv_configurations").decodeBool(KEY_PROFILE_MUSIC_DATA_GUIDE_SWITCH, false)) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a S = QUIDefaultBubbleTip.r(this.mActivity).S(view);
        QBaseActivity qBaseActivity2 = this.mActivity;
        com.tencent.mobileqq.widget.tip.a m06 = S.o0(qBaseActivity2 != null ? qBaseActivity2.getString(R.string.x4y) : null).k0(0).R(0).m0(1);
        this.bubbleTip = m06;
        if (m06 != null) {
            m06.s0();
        }
        QMMKV.from(this.mActivity, "common_mmkv_configurations").encodeBool(KEY_PROFILE_MUSIC_DATA_GUIDE_SWITCH, true);
    }

    private final void initDT(View view, String elementId, Map<String, ? extends Object> params) {
        if (view == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[initDT] view = " + view + ", elementId = " + elementId + ", params = " + params);
        }
        VideoReport.setElementId(view, elementId);
        if (params != null && !params.isEmpty()) {
            VideoReport.setElementParams(view, params);
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(view, clickPolicy);
        if (Intrinsics.areEqual(elementId, ELEMENT_EM_DATACARD_MUSIC_MEDAL_CARD)) {
            VideoReport.setElementId(this.geneLayout, ELEMENT_EM_DATACARD_MUSIC_DNA_CARD);
            VideoReport.setElementExposePolicy(this.geneLayout, exposurePolicy);
            VideoReport.setElementClickPolicy(this.geneLayout, clickPolicy);
        }
        if (this.reportedMap.containsKey(elementId)) {
            return;
        }
        this.reportedMap.put(elementId, 1);
        reportImpDelay(view, elementId, params);
    }

    private final void initAuthLayout(final ProfileMusicDataBean bean, final View authLayout, final View dataLayout) {
        if (bean == null) {
            return;
        }
        if (authLayout != null) {
            authLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileMusicDataComponent.initAuthLayout$lambda$1(ProfileMusicDataComponent.this, authLayout, dataLayout, bean, view);
                }
            });
        }
        initDT(authLayout, ELEMENT_EM_DATACARD_AUTHORIZE_CARD, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initDataLayout(final ProfileMusicDataBean bean) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        Drawable drawable;
        View view;
        ProfileMusicDataGeneBean geneBean;
        ProfileMusicDataGeneBean geneBean2;
        ProfileMusicDataGeneBean geneBean3;
        ProfileMusicDataGeneBean geneBean4;
        ProfileMusicDataGeneBean geneBean5;
        View view2;
        View view3;
        TextView textView4;
        String str;
        ProfileMusicDataGeneBean geneBean6;
        TextView textView5;
        String str2;
        TextView textView6;
        String str3;
        if (bean == null) {
            return;
        }
        View view4 = this.rootView;
        TextView textView7 = view4 != null ? (TextView) view4.findViewById(R.id.oxw) : null;
        View view5 = this.rootView;
        URLImageView uRLImageView = view5 != null ? (URLImageView) view5.findViewById(R.id.ovp) : null;
        View view6 = this.rootView;
        URLImageView uRLImageView2 = view6 != null ? (URLImageView) view6.findViewById(R.id.ovq) : null;
        View view7 = this.rootView;
        URLImageView uRLImageView3 = view7 != null ? (URLImageView) view7.findViewById(R.id.ovr) : null;
        View view8 = this.rootView;
        ImageView imageView2 = view8 != null ? (ImageView) view8.findViewById(R.id.ovo) : null;
        View view9 = this.rootView;
        View findViewById = view9 != null ? view9.findViewById(R.id.ovx) : null;
        View view10 = this.rootView;
        View findViewById2 = view10 != null ? view10.findViewById(R.id.ovz) : null;
        View view11 = this.rootView;
        TextView textView8 = view11 != null ? (TextView) view11.findViewById(R.id.oxv) : null;
        View view12 = this.rootView;
        TextView textView9 = view12 != null ? (TextView) view12.findViewById(R.id.oxy) : null;
        View view13 = this.rootView;
        TextView textView10 = view13 != null ? (TextView) view13.findViewById(R.id.oxx) : null;
        View view14 = this.rootView;
        TextView textView11 = view14 != null ? (TextView) view14.findViewById(R.id.f163216oy0) : null;
        View view15 = this.rootView;
        TextView textView12 = view15 != null ? (TextView) view15.findViewById(R.id.oxz) : null;
        View view16 = this.rootView;
        ImageView imageView3 = view16 != null ? (ImageView) view16.findViewById(R.id.ovn) : null;
        if (this.mActivity != null) {
            imageView = imageView3;
            textView2 = textView11;
            textView3 = textView12;
            textView = textView10;
            drawable = ie0.a.f().o(this.mActivity, R.drawable.qui_chevron_right_icon_secondary_01, R.color.cyv, 1001);
        } else {
            imageView = imageView3;
            textView = textView10;
            textView2 = textView11;
            textView3 = textView12;
            drawable = null;
        }
        ProfileMusicDataMedalBean medalBean = bean.getMedalBean();
        if (!TextUtils.isEmpty(medalBean != null ? medalBean.getTitle() : null)) {
            ProfileMusicDataMedalBean medalBean2 = bean.getMedalBean();
            String title = medalBean2 != null ? medalBean2.getTitle() : null;
            ProfileMusicDataMedalBean medalBean3 = bean.getMedalBean();
            Integer valueOf = medalBean3 != null ? Integer.valueOf(medalBean3.getNumber()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.intValue() > 9999) {
                title = title + " 9999+\u679a";
            } else {
                ProfileMusicDataMedalBean medalBean4 = bean.getMedalBean();
                Integer valueOf2 = medalBean4 != null ? Integer.valueOf(medalBean4.getNumber()) : null;
                Intrinsics.checkNotNull(valueOf2);
                if (valueOf2.intValue() > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(title);
                    sb5.append(TokenParser.SP);
                    ProfileMusicDataMedalBean medalBean5 = bean.getMedalBean();
                    sb5.append(medalBean5 != null ? Integer.valueOf(medalBean5.getNumber()) : null);
                    sb5.append('\u679a');
                    title = sb5.toString();
                }
            }
            if (textView7 != null) {
                textView7.setText(title);
            }
        }
        ProfileMusicDataMedalBean medalBean6 = bean.getMedalBean();
        List<String> picUrl = medalBean6 != null ? medalBean6.getPicUrl() : null;
        int i3 = 0;
        if (picUrl != null && !picUrl.isEmpty()) {
            ProfileMusicDataMedalBean medalBean7 = bean.getMedalBean();
            Integer valueOf3 = medalBean7 != null ? Integer.valueOf(medalBean7.getNumber()) : null;
            Intrinsics.checkNotNull(valueOf3);
            if (valueOf3.intValue() > 0) {
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                }
                int size = picUrl.size();
                while (i3 < size) {
                    if (!TextUtils.isEmpty(picUrl.get(i3))) {
                        if (i3 != 0) {
                            if (i3 != 1) {
                                if (uRLImageView3 != null) {
                                    uRLImageView3.setBackgroundURL(picUrl.get(i3));
                                }
                            } else if (uRLImageView2 != null) {
                                uRLImageView2.setBackgroundURL(picUrl.get(i3));
                            }
                        } else if (uRLImageView != null) {
                            uRLImageView.setBackgroundURL(picUrl.get(i3));
                        }
                    }
                    i3++;
                }
                i3 = bean.getMedalBean().getNumber();
                final HashMap hashMap = new HashMap();
                hashMap.put(ELEMENT_PARAM_BADGES_NUMBER, Integer.valueOf(i3));
                view = this.medalLayout;
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view17) {
                            ProfileMusicDataComponent.initDataLayout$lambda$2(ProfileMusicDataComponent.this, bean, hashMap, view17);
                        }
                    });
                }
                if (drawable != null && imageView2 != null) {
                    imageView2.setImageDrawable(drawable);
                }
                geneBean = bean.getGeneBean();
                if (!TextUtils.isEmpty(geneBean == null ? geneBean.getTitle() : null) && textView8 != null) {
                    ProfileMusicDataGeneBean geneBean7 = bean.getGeneBean();
                    textView8.setText(geneBean7 == null ? geneBean7.getTitle() : null);
                }
                geneBean2 = bean.getGeneBean();
                if (!TextUtils.isEmpty(geneBean2 == null ? geneBean2.getLeftTile() : null) && textView9 != null) {
                    ProfileMusicDataGeneBean geneBean8 = bean.getGeneBean();
                    textView9.setText(geneBean8 == null ? geneBean8.getLeftTile() : null);
                }
                geneBean3 = bean.getGeneBean();
                if (!TextUtils.isEmpty(geneBean3 == null ? geneBean3.getLeftValue() : null)) {
                    if (textView != null) {
                        ProfileMusicDataGeneBean geneBean9 = bean.getGeneBean();
                        if (geneBean9 != null) {
                            str3 = geneBean9.getLeftValue();
                            textView6 = textView;
                        } else {
                            textView6 = textView;
                            str3 = null;
                        }
                        textView6.setText(str3);
                    }
                    TextPaint paint = textView3 != null ? textView3.getPaint() : null;
                    if (paint != null) {
                        paint.setFakeBoldText(true);
                    }
                }
                geneBean4 = bean.getGeneBean();
                if (!TextUtils.isEmpty(geneBean4 == null ? geneBean4.getRightTile() : null) && textView2 != null) {
                    geneBean6 = bean.getGeneBean();
                    if (geneBean6 == null) {
                        str2 = geneBean6.getRightTile();
                        textView5 = textView2;
                    } else {
                        textView5 = textView2;
                        str2 = null;
                    }
                    textView5.setText(str2);
                }
                geneBean5 = bean.getGeneBean();
                if (!TextUtils.isEmpty(geneBean5 == null ? geneBean5.getRightValue() : null)) {
                    if (textView3 == null) {
                        textView4 = textView3;
                    } else {
                        ProfileMusicDataGeneBean geneBean10 = bean.getGeneBean();
                        if (geneBean10 != null) {
                            str = geneBean10.getRightValue();
                            textView4 = textView3;
                        } else {
                            textView4 = textView3;
                            str = null;
                        }
                        textView4.setText(str);
                    }
                    TextPaint paint2 = textView4 != null ? textView4.getPaint() : null;
                    if (paint2 != null) {
                        paint2.setFakeBoldText(true);
                    }
                }
                if (drawable != null && imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                view2 = this.geneLayout;
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.h
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view17) {
                            ProfileMusicDataComponent.initDataLayout$lambda$3(ProfileMusicDataComponent.this, bean, view17);
                        }
                    });
                }
                if (this.mOnGlobalLayoutListener == null) {
                    this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.profilecard.component.i
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            ProfileMusicDataComponent.initDataLayout$lambda$5(ProfileMusicDataComponent.this);
                        }
                    };
                }
                view3 = this.geneLayout;
                if (view3 != null) {
                    view3.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.mobileqq.profilecard.component.ProfileMusicDataComponent$initDataLayout$4
                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewAttachedToWindow(View v3) {
                            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
                            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener2;
                            ViewTreeObserver viewTreeObserver = v3 != null ? v3.getViewTreeObserver() : null;
                            if (viewTreeObserver == null) {
                                QLog.i(ProfileMusicDataComponent.TAG, 1, "onViewAttachedToWindow viewTreeObserver is null");
                                return;
                            }
                            if (!viewTreeObserver.isAlive()) {
                                QLog.i(ProfileMusicDataComponent.TAG, 1, "onViewAttachedToWindow viewTreeObserver is notAlive");
                            }
                            onGlobalLayoutListener = ProfileMusicDataComponent.this.mOnGlobalLayoutListener;
                            if (onGlobalLayoutListener != null) {
                                onGlobalLayoutListener2 = ProfileMusicDataComponent.this.mOnGlobalLayoutListener;
                                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener2);
                            }
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewDetachedFromWindow(View v3) {
                            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
                            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener2;
                            ViewTreeObserver viewTreeObserver = v3 != null ? v3.getViewTreeObserver() : null;
                            if (viewTreeObserver == null) {
                                QLog.i(ProfileMusicDataComponent.TAG, 1, "onViewDetachedFromWindow viewTreeObserver is null");
                                return;
                            }
                            if (!viewTreeObserver.isAlive()) {
                                QLog.i(ProfileMusicDataComponent.TAG, 1, "onViewDetachedFromWindow viewTreeObserver is notAlive");
                            }
                            onGlobalLayoutListener = ProfileMusicDataComponent.this.mOnGlobalLayoutListener;
                            if (onGlobalLayoutListener != null) {
                                onGlobalLayoutListener2 = ProfileMusicDataComponent.this.mOnGlobalLayoutListener;
                                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener2);
                            }
                        }
                    });
                }
                initDT(this.medalLayout, ELEMENT_EM_DATACARD_MUSIC_MEDAL_CARD, hashMap);
            }
        }
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
        final HashMap hashMap2 = new HashMap();
        hashMap2.put(ELEMENT_PARAM_BADGES_NUMBER, Integer.valueOf(i3));
        view = this.medalLayout;
        if (view != null) {
        }
        if (drawable != null) {
            imageView2.setImageDrawable(drawable);
        }
        geneBean = bean.getGeneBean();
        if (!TextUtils.isEmpty(geneBean == null ? geneBean.getTitle() : null)) {
            ProfileMusicDataGeneBean geneBean72 = bean.getGeneBean();
            textView8.setText(geneBean72 == null ? geneBean72.getTitle() : null);
        }
        geneBean2 = bean.getGeneBean();
        if (!TextUtils.isEmpty(geneBean2 == null ? geneBean2.getLeftTile() : null)) {
            ProfileMusicDataGeneBean geneBean82 = bean.getGeneBean();
            textView9.setText(geneBean82 == null ? geneBean82.getLeftTile() : null);
        }
        geneBean3 = bean.getGeneBean();
        if (!TextUtils.isEmpty(geneBean3 == null ? geneBean3.getLeftValue() : null)) {
        }
        geneBean4 = bean.getGeneBean();
        if (!TextUtils.isEmpty(geneBean4 == null ? geneBean4.getRightTile() : null)) {
            geneBean6 = bean.getGeneBean();
            if (geneBean6 == null) {
            }
            textView5.setText(str2);
        }
        geneBean5 = bean.getGeneBean();
        if (!TextUtils.isEmpty(geneBean5 == null ? geneBean5.getRightValue() : null)) {
        }
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        view2 = this.geneLayout;
        if (view2 != null) {
        }
        if (this.mOnGlobalLayoutListener == null) {
        }
        view3 = this.geneLayout;
        if (view3 != null) {
        }
        initDT(this.medalLayout, ELEMENT_EM_DATACARD_MUSIC_MEDAL_CARD, hashMap2);
    }

    public final void reportImpDelay(View view, String elementId, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (TextUtils.isEmpty(elementId)) {
            return;
        }
        Integer num = this.reportedMap.get(elementId);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() >= 3) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "[reportImpDelay] return, retryCount >= MAX_RETRY_COUNT");
            }
            ReportImpRunnable reportImpRunnable = this.mReportImpRunnable;
            if (reportImpRunnable != null) {
                ThreadManagerV2.removeJobFromThreadPool(reportImpRunnable, 16);
                return;
            }
            return;
        }
        this.reportedMap.put(elementId, Integer.valueOf(num.intValue() + 1));
        PageInfo pageInfo = VideoReport.getPageInfo(view);
        long j3 = pageInfo == null ? 3000L : 0L;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[reportImpDelay] elementId = " + elementId + ", pageInfo = " + pageInfo + ", retryCount = " + num);
        }
        ReportImpRunnable reportImpRunnable2 = new ReportImpRunnable(this, view, elementId, params);
        this.mReportImpRunnable = reportImpRunnable2;
        if (pageInfo == null) {
            ThreadManagerV2.executeDelay(reportImpRunnable2, 16, null, true, j3);
            return;
        }
        if (Intrinsics.areEqual(elementId, ELEMENT_EM_DATACARD_MUSIC_MEDAL_CARD)) {
            VideoReport.reportEvent("imp", this.geneLayout, params);
        }
        VideoReport.reportEvent("imp", view, params);
    }
}
