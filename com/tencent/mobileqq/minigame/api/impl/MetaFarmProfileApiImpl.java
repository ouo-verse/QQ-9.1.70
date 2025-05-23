package com.tencent.mobileqq.minigame.api.impl;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi;
import com.tencent.mobileqq.minigame.metafarm.network.MetaFarmIsFarmUserRequest;
import com.tencent.mobileqq.minigame.metafarm.ui.MetaFarmStatusListFragment;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MetaFarmProfileApiImpl;", "Lcom/tencent/mobileqq/minigame/api/IMetaFarmProfileApi;", "()V", "mIsFarmUser", "", "mIsReqStarted", "clearGuideFlag", "", "clearGuideShownFlag", "isGuideFragmentShown", "isMetaFarmUser", "openStatusListFragment", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "currentStatusId", "setGuideFragmentShown", "setSelfMetaFarmUid", "uid", "", "showGuideFragment", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmProfileApiImpl implements IMetaFarmProfileApi {
    private static final String MMKV_KEY_META_FARM_PROFILE_GUIDE_SHOWN = "mmkv_key_meta_farm_profile_guide_shown";
    private static final String TAG = "MetaFarmProfileApiImpl";
    private boolean mIsFarmUser;
    private volatile boolean mIsReqStarted;

    private final boolean isGuideFragmentShown() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP)");
        return from.decodeBool(MMKV_KEY_META_FARM_PROFILE_GUIDE_SHOWN + ("_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setGuideFragmentShown() {
        QLog.d(TAG, 1, "setGuideFragmentShown");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP)");
        from.encodeBool(MMKV_KEY_META_FARM_PROFILE_GUIDE_SHOWN + ("_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()), true);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi
    public void clearGuideFlag() {
        QLog.d(TAG, 1, "clearGuideFlag");
        clearGuideShownFlag();
        ArrayList<ReqSetSettingItem> arrayList = new ArrayList<>();
        arrayList.add(new ReqSetSettingItem(ProfileContants.FIELD_META_FARM_SWITCH, 1, 0));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IProfileSettingApi iProfileSettingApi = (IProfileSettingApi) QRoute.api(IProfileSettingApi.class);
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        iProfileSettingApi.requestSetCardDisplaySetting((AppInterface) peekAppRuntime, arrayList);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi
    /* renamed from: isMetaFarmUser, reason: from getter */
    public boolean getMIsFarmUser() {
        return this.mIsFarmUser;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi
    public void openStatusListFragment(Activity activity, int requestCode, int currentStatusId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d(TAG, 1, "openStatusListFragment");
        Intent intent = new Intent();
        intent.putExtra(MetaFarmStatusListFragment.KEY_DEFAULT_SELECT_STATUS_ID, currentStatusId);
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) MetaFarmStatusListFragment.class, requestCode);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi
    public void showGuideFragment(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isBizPopGuideShow()) {
            QLog.d(TAG, 1, "showGuideFragment isBizPopGuideShow");
            return;
        }
        if (isGuideFragmentShown()) {
            QLog.d(TAG, 1, "showGuideFragment isGuideFragmentShown");
            return;
        }
        if (!(activity instanceof FragmentActivity)) {
            QLog.d(TAG, 1, "showGuideFragment not FragmentActivity: " + activity);
            return;
        }
        if (this.mIsReqStarted) {
            return;
        }
        this.mIsReqStarted = true;
        MetaFarmIsFarmUserRequest metaFarmIsFarmUserRequest = new MetaFarmIsFarmUserRequest();
        metaFarmIsFarmUserRequest.setListener(new MetaFarmProfileApiImpl$showGuideFragment$1(this, metaFarmIsFarmUserRequest, activity));
        metaFarmIsFarmUserRequest.checkIsFarmUser();
    }

    private final void clearGuideShownFlag() {
        QLog.d(TAG, 1, "clearGuideShownFlag");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP)");
        from.encodeBool(MMKV_KEY_META_FARM_PROFILE_GUIDE_SHOWN + ("_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()), false);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMetaFarmProfileApi
    public void setSelfMetaFarmUid(long uid) {
        boolean z16 = uid > 0;
        this.mIsFarmUser = z16;
        if (z16) {
            return;
        }
        final MetaFarmIsFarmUserRequest metaFarmIsFarmUserRequest = new MetaFarmIsFarmUserRequest();
        metaFarmIsFarmUserRequest.setListener(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.minigame.api.impl.MetaFarmProfileApiImpl$setSelfMetaFarmUid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, Boolean bool) {
                QLog.d("MetaFarmProfileApiImpl", 1, "setSelfMetaFarmUid checkIsFarmUser req isSuccess:" + z17 + ", isFarmUser:" + bool);
                if (z17 && bool != null) {
                    MetaFarmProfileApiImpl.this.mIsFarmUser = bool.booleanValue();
                }
                metaFarmIsFarmUserRequest.setListener(null);
            }
        });
        metaFarmIsFarmUserRequest.checkIsFarmUser();
    }
}
