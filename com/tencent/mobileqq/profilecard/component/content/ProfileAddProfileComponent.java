package com.tencent.mobileqq.profilecard.component.content;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.util.TokenResUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/profilecard/component/content/ProfileAddProfileComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "Landroid/view/View$OnClickListener;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "isInitDtReport", "", "getComponentName", "", "getComponentType", "", "getProfileContentKey", "makeOrRefresh", "profileCardInfo", NodeProps.ON_CLICK, "", "view", "Landroid/view/View;", "onDataUpdate", "Companion", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileAddProfileComponent extends AbsProfileContentComponent implements View.OnClickListener {
    private static final String TAG = "ProfileAddProfileComponent";
    private boolean isInitDtReport;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IProfileCardFeatureApi.ProfileCardEmptyStatus.values().length];
            try {
                iArr[IProfileCardFeatureApi.ProfileCardEmptyStatus.PHOTO_EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IProfileCardFeatureApi.ProfileCardEmptyStatus.LABEL_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IProfileCardFeatureApi.ProfileCardEmptyStatus.BOTH_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IProfileCardFeatureApi.ProfileCardEmptyStatus.NOT_EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ProfileAddProfileComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if ((r8 == null || r8.isEmpty()) != false) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Type inference failed for: r8v11, types: [android.view.View, VIEW] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean makeOrRefresh(ProfileCardInfo profileCardInfo) {
        boolean z16;
        boolean z17 = true;
        boolean z18 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 0;
        ProfileCardFeatureSwitch profileCardFeatureSwitch = ProfileCardFeatureSwitch.INSTANCE;
        boolean isOwnerProfileCardEmptyItemFoldEnable = profileCardFeatureSwitch.isOwnerProfileCardEmptyItemFoldEnable();
        boolean isPhotoWallEmpty = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getIsPhotoWallEmpty(profileCardInfo);
        boolean isPersonalityLabelEmpty = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getIsPersonalityLabelEmpty(profileCardInfo);
        List<String> makeAccountInfo = ProfileAccountInfoUtils.makeAccountInfo(profileCardInfo);
        if (z18 && isOwnerProfileCardEmptyItemFoldEnable) {
            if (!isPhotoWallEmpty && !isPersonalityLabelEmpty) {
                List<String> list = makeAccountInfo;
            }
            z16 = true;
            if (z16) {
                if (this.mViewContainer == 0) {
                    return false;
                }
                this.mViewContainer = null;
                return true;
            }
            if (this.mViewContainer == 0) {
                ?? inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.h0a, (ViewGroup) null);
                this.mViewContainer = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
                if (TokenResUtils.useTokenIcon()) {
                    imageView.setBackgroundResource(R.drawable.qui_homework);
                } else {
                    if (QQTheme.isNowSimpleUI()) {
                        imageView.setBackgroundResource(R.drawable.qui_homework);
                    } else {
                        imageView.setBackgroundResource(R.drawable.nfu);
                    }
                    if (QQTheme.isNowThemeIsNight()) {
                        imageView.setColorFilter(Color.parseColor("#999999"));
                    }
                }
                ((View) this.mViewContainer).setOnClickListener(this);
            } else {
                z17 = false;
            }
            TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.jfb);
            TextView textView2 = (TextView) ((View) this.mViewContainer).findViewById(R.id.f94915dk);
            ImageView imageView2 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw);
            textView.setText(profileCardFeatureSwitch.getOwnerProfileCardEmptyItemFoldParam().get(ProfileCardFeatureSwitch.PROFILE_PERFECT_MAIN_TITLE));
            textView2.setText(profileCardFeatureSwitch.getOwnerProfileCardEmptyItemFoldParam().get(ProfileCardFeatureSwitch.PROFILE_PERFECT_SUB_TITLE));
            ((View) this.mViewContainer).setTag(new b(81, null));
            updateItemTheme((View) this.mViewContainer, textView, null, imageView2);
            return z17;
        }
        z16 = false;
        if (z16) {
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1038;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_ADD_PROFILE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ProfileCardDtReportUtil.dtReportClick((View) this.mViewContainer);
        Object tag = view.getTag();
        Bundle bundle = new Bundle();
        bundle.putBoolean(IProfileCardConst.PROFILE_JUMP_WITH_BUBBLE, ((ProfileCardInfo) this.mData).hasShowedEditBubble);
        IProfileCardFeatureApi.ProfileCardEmptyStatus profieEmptyStatus = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getProfieEmptyStatus((ProfileCardInfo) this.mData);
        Intrinsics.checkNotNull(profieEmptyStatus);
        int i3 = WhenMappings.$EnumSwitchMapping$0[profieEmptyStatus.ordinal()];
        if (i3 == 1) {
            bundle.putInt(IProfileCardConst.PROFILE_JUMP_WITH_ITEM_EMPTY, 1);
        } else if (i3 == 2) {
            bundle.putInt(IProfileCardConst.PROFILE_JUMP_WITH_ITEM_EMPTY, 2);
        } else if (i3 == 3) {
            bundle.putInt(IProfileCardConst.PROFILE_JUMP_WITH_ITEM_EMPTY, 3);
        } else if (i3 == 4) {
            bundle.putInt(IProfileCardConst.PROFILE_JUMP_WITH_ITEM_EMPTY, 0);
        }
        int photoWallPicNum = ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).getPhotoWallPicNum((ProfileCardInfo) this.mData);
        if (photoWallPicNum != -1) {
            bundle.putInt(IProfileCardConst.PROFILE_JUMP_WITH_PHOTO_NUM, photoWallPicNum);
        }
        if ((tag instanceof b) && ((b) tag).f260135a == 81) {
            ((IProfileGuideApi) QRoute.api(IProfileGuideApi.class)).jumpProfileEditWithData(this.mApp, this.mActivity, (ProfileCardInfo) this.mData, bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        Intrinsics.checkNotNullParameter(profileCardInfo, "profileCardInfo");
        boolean makeOrRefresh = makeOrRefresh(profileCardInfo) | super.lambda$checkValidComponent$3((ProfileAddProfileComponent) profileCardInfo);
        if (makeOrRefresh && !this.isInitDtReport && this.mViewContainer != 0) {
            this.isInitDtReport = true;
            HashMap hashMap = new HashMap();
            hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COMPLETEFILE_VERSION, "3");
            ProfileCardDtReportUtil.initElementWithExposureClickAndParams((View) this.mViewContainer, ProfileCardDtReportUtil.DT_REPORT_COMPLETEFILE, hashMap);
        }
        return makeOrRefresh;
    }
}
