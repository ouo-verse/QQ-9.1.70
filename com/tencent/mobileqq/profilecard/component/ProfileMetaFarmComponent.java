package com.tencent.mobileqq.profilecard.component;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmConstants;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmStatus;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileMetaFarmBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 :2\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\bH\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bH\u0002J\"\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0018\u0010/\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002JE\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u00010\u00112\b\u00104\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u00105\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\bH\u0002\u00a2\u0006\u0002\u00108J\b\u00109\u001a\u00020\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/profilecard/component/ProfileMetaFarmComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "cardUin", "", "data", "hasRipeCrop", "", "lastShowTs", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "statusIcon", "Lcom/tencent/image/URLImageView;", "statusLayout", "Landroid/widget/RelativeLayout;", "statusText", "Landroid/widget/TextView;", "updateStatus", "canUpdateStatus", "getAnimalText", "cropStatus", "", "getComponentName", "getComponentType", "getCropText", "getFishText", "getMachineText", "getProfileContentKey", "getUrlDrawable", "Lcom/tencent/image/URLDrawable;", "url", "initView", "", "bean", "Lcom/tencent/mobileqq/profilecard/data/ProfileMetaFarmBean;", "isSelfCard", "onActivityResult", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onDataUpdate", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "reportClick", "isStatus", "reportShow", "setCropView", "cropIcon", "cropText", "cropIconUrl", MiniGamePAHippyBaseFragment.KEY_THEME, "text", "(Lcom/tencent/image/URLImageView;Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;)V", "shouldShow", "Companion", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileMetaFarmComponent extends AbsProfileContentComponent {
    private static final String FARM_DEEP_LINK = "={\"jumpId\":1,\"jumpParams\":{},\"jumpType\":5}";
    private static final String FARM_DEEP_LINK_VISIT = "={\"jumpId\":1,\"jumpParams\":{\"uid\":\"%s\"},\"jumpType\":5}";
    private static final String META_LINK = "https://m.q.qq.com/a/p/1112288843?s=cd_extendInfo";
    private static final long MIN_SHOW_REPORT_INTERVAL = 2000;
    private static final int REQUEST_SELECT_STATUS = 4097;
    private static final String TAG = "ProfileMetaFarmComponent";
    private String cardUin;
    private ProfileCardInfo data;
    private boolean hasRipeCrop;
    private long lastShowTs;
    private View rootView;
    private URLImageView statusIcon;
    private RelativeLayout statusLayout;
    private TextView statusText;
    private boolean updateStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMetaFarmComponent(IComponentCenter componentCenter, ProfileCardInfo cardInfo) {
        super(componentCenter, cardInfo);
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.cardUin = "";
    }

    private final boolean canUpdateStatus() {
        ProfileCardInfo profileCardInfo = this.data;
        if ((profileCardInfo == null || profileCardInfo.isNetRet) ? false : true) {
            return ((profileCardInfo != null && !profileCardInfo.isFromGetProfileCardRequest) && this.updateStatus) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v49, types: [android.view.View, VIEW] */
    private final void initView(final ProfileMetaFarmBean bean, final boolean isSelfCard) {
        QBaseActivity qBaseActivity;
        if (System.currentTimeMillis() - this.lastShowTs < 2000) {
            QLog.d(TAG, 1, "initView refresh too frequently");
            return;
        }
        QLog.d(TAG, 1, "initView");
        this.lastShowTs = System.currentTimeMillis();
        if (this.rootView == null && (qBaseActivity = this.mActivity) != null) {
            this.rootView = LayoutInflater.from(qBaseActivity).inflate(R.layout.cz_, (ViewGroup) null);
        }
        View view = this.rootView;
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.oxl) : null;
        View view2 = this.rootView;
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.oxn) : null;
        View view3 = this.rootView;
        TextView textView2 = view3 != null ? (TextView) view3.findViewById(R.id.oxk) : null;
        if (isSelfCard) {
            if (textView != null) {
                textView.setText("\u6211\u7684\u519c\u573a");
            }
            if (textView2 != null) {
                textView2.setText("\u7acb\u5373\u8fdb\u5165");
            }
        } else {
            if (textView != null) {
                textView.setText("Ta\u7684\u519c\u573a");
            }
            if (textView2 != null) {
                textView2.setText("\u53bb\u62dc\u8bbf");
            }
        }
        View view4 = this.rootView;
        URLImageView uRLImageView = view4 != null ? (URLImageView) view4.findViewById(R.id.ou7) : null;
        String farmLevelIconUrl = bean.getFarmLevelIconUrl();
        if (!(farmLevelIconUrl == null || farmLevelIconUrl.length() == 0) && bean.getFarmLevel() > 0) {
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
            if (uRLImageView != null) {
                uRLImageView.setImageDrawable(getUrlDrawable(bean.getFarmLevelIconUrl()));
            }
        } else if (uRLImageView != null) {
            uRLImageView.setVisibility(8);
        }
        View view5 = this.rootView;
        RelativeLayout relativeLayout = view5 != null ? (RelativeLayout) view5.findViewById(R.id.owy) : null;
        this.statusLayout = relativeLayout;
        if (isSelfCard && relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    ProfileMetaFarmComponent.initView$lambda$0(ProfileMetaFarmComponent.this, bean, view6);
                }
            });
        }
        View view6 = this.rootView;
        this.statusIcon = view6 != null ? (URLImageView) view6.findViewById(R.id.owz) : null;
        View view7 = this.rootView;
        this.statusText = view7 != null ? (TextView) view7.findViewById(R.id.f163211ox0) : null;
        if (canUpdateStatus()) {
            String statusIcon = bean.getStatusIcon();
            if (!(statusIcon == null || statusIcon.length() == 0)) {
                String statusDesc = bean.getStatusDesc();
                if (!(statusDesc == null || statusDesc.length() == 0)) {
                    URLImageView uRLImageView2 = this.statusIcon;
                    if (uRLImageView2 != null) {
                        uRLImageView2.setVisibility(0);
                    }
                    TextView textView3 = this.statusText;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    URLImageView uRLImageView3 = this.statusIcon;
                    if (uRLImageView3 != null) {
                        uRLImageView3.setImageDrawable(getUrlDrawable(bean.getStatusIcon()));
                    }
                    TextView textView4 = this.statusText;
                    if (textView4 != null) {
                        textView4.setText(bean.getStatusDesc());
                    }
                }
            }
            if (isSelfCard) {
                URLImageView uRLImageView4 = this.statusIcon;
                if (uRLImageView4 != null) {
                    uRLImageView4.setImageResource(R.drawable.g_s);
                }
                TextView textView5 = this.statusText;
                if (textView5 != null) {
                    textView5.setText("\u6dfb\u52a0\u72b6\u6001");
                }
            } else {
                URLImageView uRLImageView5 = this.statusIcon;
                if (uRLImageView5 != null) {
                    uRLImageView5.setVisibility(8);
                }
                TextView textView6 = this.statusText;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
            }
        }
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        QLog.d(TAG, 1, "initView isNightMode:" + isNowThemeIsNight);
        View view8 = this.rootView;
        View findViewById = view8 != null ? view8.findViewById(R.id.oty) : null;
        View view9 = this.rootView;
        URLImageView uRLImageView6 = view9 != null ? (URLImageView) view9.findViewById(R.id.f163196ou0) : null;
        View view10 = this.rootView;
        TextView textView7 = view10 != null ? (TextView) view10.findViewById(R.id.f163197ou1) : null;
        View view11 = this.rootView;
        URLImageView uRLImageView7 = view11 != null ? (URLImageView) view11.findViewById(R.id.ote) : null;
        View view12 = this.rootView;
        TextView textView8 = view12 != null ? (TextView) view12.findViewById(R.id.otf) : null;
        View view13 = this.rootView;
        URLImageView uRLImageView8 = view13 != null ? (URLImageView) view13.findViewById(R.id.oua) : null;
        View view14 = this.rootView;
        TextView textView9 = view14 != null ? (TextView) view14.findViewById(R.id.oub) : null;
        View view15 = this.rootView;
        URLImageView uRLImageView9 = view15 != null ? (URLImageView) view15.findViewById(R.id.ovv) : null;
        View view16 = this.rootView;
        TextView textView10 = view16 != null ? (TextView) view16.findViewById(R.id.ovw) : null;
        setCropView(uRLImageView6, textView7, Integer.valueOf(bean.getCropStatus()), bean.getCropIconUrl(), isNowThemeIsNight, getCropText(bean.getCropStatus()));
        setCropView(uRLImageView7, textView8, Integer.valueOf(bean.getAnimalStatus()), bean.getAnimalIconUrl(), isNowThemeIsNight, getAnimalText(bean.getAnimalStatus()));
        setCropView(uRLImageView8, textView9, Integer.valueOf(bean.getFishStatus()), bean.getFishIconUrl(), isNowThemeIsNight, getFishText(bean.getFishStatus()));
        setCropView(uRLImageView9, textView10, Integer.valueOf(bean.getMachineStatus()), bean.getMachineIconUrl(), isNowThemeIsNight, getMachineText(bean.getMachineStatus()));
        if (isNowThemeIsNight) {
            RelativeLayout relativeLayout2 = this.statusLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackgroundResource(R.drawable.g9i);
            }
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.g9f);
            }
        } else {
            RelativeLayout relativeLayout3 = this.statusLayout;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackgroundResource(R.drawable.g9h);
            }
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.g9e);
            }
        }
        View view17 = this.rootView;
        if (view17 != null) {
            view17.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view18) {
                    ProfileMetaFarmComponent.initView$lambda$1(isSelfCard, bean, this, view18);
                }
            });
        }
        ?? r06 = this.rootView;
        this.mViewContainer = r06;
        updateItemTheme(null, textView, imageView, null, r06 != 0 ? (ImageView) r06.findViewById(R.id.oxe) : null);
        reportShow(bean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ProfileMetaFarmComponent this$0, ProfileMetaFarmBean bean, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        IMetaFarmProfileApi iMetaFarmProfileApi = (IMetaFarmProfileApi) QRoute.api(IMetaFarmProfileApi.class);
        QBaseActivity mActivity = this$0.mActivity;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        iMetaFarmProfileApi.openStatusListFragment(mActivity, 4097, bean.getStatus());
        this$0.reportClick(bean, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(boolean z16, ProfileMetaFarmBean bean, ProfileMetaFarmComponent this$0, View view) {
        String format;
        String str;
        Intrinsics.checkNotNullParameter(bean, "$bean");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            format = FARM_DEEP_LINK;
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format(FARM_DEEP_LINK_VISIT, Arrays.copyOf(new Object[]{Long.valueOf(bean.getUid())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        if (z16) {
            str = "&via=3404";
        } else {
            str = "&via=3405";
        }
        String str2 = META_LINK + URLEncoder.encode(format, "utf-8") + str;
        QLog.d(TAG, 1, "open farm:" + str2);
        Intent intent = new Intent();
        intent.putExtra("url", str2);
        RouteUtils.startActivity(this$0.mActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
        this$0.reportClick(bean, false);
    }

    private final void reportClick(ProfileMetaFarmBean bean, boolean isStatus) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("ext2", String.valueOf(bean.getStatus()));
        String str2 = "1";
        if (!isStatus) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("ext3", str);
        hashMap.put("ext9", this.cardUin);
        if (!this.hasRipeCrop) {
            str2 = "0";
        }
        hashMap.put("ext29", str2);
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("5", "9529", "9739", "973901", "989663", "20", "", hashMap);
    }

    private final void reportShow(ProfileMetaFarmBean bean) {
        String str;
        boolean z16 = true;
        QLog.d(TAG, 1, "reportShow");
        if (bean.getCropStatus() != 3 && bean.getAnimalStatus() != 3 && bean.getFishStatus() != 3 && bean.getMachineStatus() != 3) {
            z16 = false;
        }
        this.hasRipeCrop = z16;
        HashMap hashMap = new HashMap();
        hashMap.put("ext2", String.valueOf(bean.getStatus()));
        hashMap.put("ext9", this.cardUin);
        if (this.hasRipeCrop) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("ext29", str);
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("5", "9528", "9738", "973801", "989662", "8", "", hashMap);
    }

    private final boolean shouldShow() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(MetaFarmConstants.SWITCH_CONFIG_ID, false);
        boolean t16 = StudyModeManager.t();
        QLog.d(TAG, 1, "shouldShow isSwitchOn:" + isSwitchOn + ", isStudyMode:" + t16);
        return isSwitchOn && !t16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1050;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_META_FARM;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4097 && resultCode == -1) {
            MetaFarmStatus metaFarmStatus = (MetaFarmStatus) (data != null ? data.getSerializableExtra("selectStatus") : null);
            QLog.d(TAG, 4, "selectStatus:" + metaFarmStatus);
            if (metaFarmStatus != null) {
                this.updateStatus = true;
                if (metaFarmStatus.getId() == 0) {
                    URLImageView uRLImageView = this.statusIcon;
                    if (uRLImageView != null) {
                        uRLImageView.setImageResource(R.drawable.g_s);
                    }
                    TextView textView = this.statusText;
                    if (textView == null) {
                        return;
                    }
                    textView.setText("\u6dfb\u52a0\u72b6\u6001");
                    return;
                }
                URLImageView uRLImageView2 = this.statusIcon;
                if (uRLImageView2 != null) {
                    uRLImageView2.setImageDrawable(getUrlDrawable(metaFarmStatus.getIconUrl()));
                }
                TextView textView2 = this.statusText;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(metaFarmStatus.getDesc());
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        super.onPause();
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).setBizPopGuideShow(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo data) {
        boolean z16;
        super.lambda$checkValidComponent$3((ProfileMetaFarmComponent) data);
        if ((data != null ? data.card : null) == null) {
            return true;
        }
        if (!shouldShow()) {
            QLog.d(TAG, 1, "onDataUpdate should not show");
            this.isForceHide = true;
            return true;
        }
        ProfileMetaFarmBean profileMetaFarmBean = (ProfileMetaFarmBean) data.card.getBusinessInfo(ProfileMetaFarmBean.class);
        if (profileMetaFarmBean == null) {
            QLog.d(TAG, 1, "onDataUpdate bean null");
            return true;
        }
        if (data.isNetRet || data.isFromGetProfileCardRequest) {
            this.updateStatus = false;
        }
        short s16 = data.card.switchMetaFarm;
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (!(currentUin == null || currentUin.length() == 0)) {
            Card card = data.card;
            if (currentUin.equals(card != null ? card.uin : null)) {
                z16 = true;
                if (!z16) {
                    ((IMetaFarmProfileApi) QRoute.api(IMetaFarmProfileApi.class)).setSelfMetaFarmUid(profileMetaFarmBean.getUid());
                } else {
                    Card card2 = data.card;
                    String str = card2 != null ? card2.uin : null;
                    if (str == null) {
                        str = "";
                    }
                    this.cardUin = str;
                }
                QLog.d(TAG, 1, "onDataUpdate farmSwitch:" + ((int) s16) + ", isSelfCard:" + z16);
                if (s16 != 0 && z16) {
                    IMetaFarmProfileApi iMetaFarmProfileApi = (IMetaFarmProfileApi) QRoute.api(IMetaFarmProfileApi.class);
                    QBaseActivity mActivity = this.mActivity;
                    Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                    iMetaFarmProfileApi.showGuideFragment(mActivity);
                    return true;
                }
                if (profileMetaFarmBean.getUid() != 0) {
                    QLog.d(TAG, 1, "onDataUpdate no role");
                    this.isForceHide = true;
                    return true;
                }
                if (s16 == 1) {
                    QLog.d(TAG, 1, "onDataUpdate show farm card:" + profileMetaFarmBean);
                    this.isForceHide = false;
                    this.data = data;
                    initView(profileMetaFarmBean, z16);
                }
                return true;
            }
        }
        z16 = false;
        if (!z16) {
        }
        QLog.d(TAG, 1, "onDataUpdate farmSwitch:" + ((int) s16) + ", isSelfCard:" + z16);
        if (s16 != 0) {
        }
        if (profileMetaFarmBean.getUid() != 0) {
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

    private final void setCropView(URLImageView cropIcon, TextView cropText, Integer cropStatus, String cropIconUrl, boolean isNightMode, String text) {
        if (cropIcon != null) {
            cropIcon.setImageDrawable(getUrlDrawable(cropIconUrl));
        }
        if (cropText != null) {
            cropText.setText(text);
        }
        if (isNightMode) {
            if (cropText != null) {
                cropText.setTextColor(Color.parseColor("#B2FFFFFF"));
            }
        } else if (cropText != null) {
            cropText.setTextColor(Color.parseColor("#647E5B"));
        }
        if (cropStatus == null || cropStatus.intValue() != 3 || cropText == null) {
            return;
        }
        cropText.setTextColor(Color.parseColor("#F97801"));
    }

    private final String getFishText(int cropStatus) {
        if (cropStatus == 1) {
            return "\u5f85\u6210\u719f";
        }
        if (cropStatus == 3) {
            return "\u5df2\u6210\u719f";
        }
        if (cropStatus == 5) {
            return "\u9c7c\u5858";
        }
        if (cropStatus != 6) {
            return "";
        }
        return "\u5f85\u6492\u9975";
    }

    private final String getMachineText(int cropStatus) {
        if (cropStatus == 1) {
            return "\u52a0\u5de5\u4e2d";
        }
        if (cropStatus == 3) {
            return "\u53ef\u6536\u83b7";
        }
        if (cropStatus == 5) {
            return "\u52a0\u5de5\u54c1";
        }
        if (cropStatus != 6) {
            return "";
        }
        return "\u7a7a\u7f6e\u4e2d";
    }

    private final String getCropText(int cropStatus) {
        if (cropStatus == 1) {
            return "\u6210\u957f\u4e2d";
        }
        if (cropStatus == 2) {
            return "\u5f85\u6d47\u6c34";
        }
        if (cropStatus == 3) {
            return "\u53ef\u6536\u83b7";
        }
        if (cropStatus == 5) {
            return "\u4f5c\u7269";
        }
        if (cropStatus != 6) {
            return "";
        }
        return "\u5f85\u64ad\u79cd";
    }

    private final String getAnimalText(int cropStatus) {
        if (cropStatus == 1) {
            return "\u751f\u4ea7\u4e2d";
        }
        if (cropStatus == 3) {
            return "\u53ef\u6536\u83b7";
        }
        if (cropStatus == 4) {
            return "\u5f85\u52a9\u4ea7";
        }
        if (cropStatus == 5) {
            return "\u52a8\u7269";
        }
        if (cropStatus == 6) {
            return "\u5f85\u517b\u6b96";
        }
        if (cropStatus != 7) {
            return "";
        }
        return "\u5f85\u5582\u98df";
    }
}
