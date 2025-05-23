package com.tencent.state.square.guide;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseGroupFragment;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.SquareViewModel;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.utils.VMUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\b\u0010 \u001a\u00020\u0017H\u0002J\u0006\u0010!\u001a\u00020\u0017J\b\u0010\"\u001a\u00020\u0017H\u0002J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/guide/GuideContext;", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "groupFragment", "Lcom/tencent/state/VasBaseGroupFragment;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/state/VasBaseFragment;Lcom/tencent/state/VasBaseGroupFragment;Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "getConfig", "()Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "getFragment", "()Lcom/tencent/state/VasBaseFragment;", "getGroupFragment", "()Lcom/tencent/state/VasBaseGroupFragment;", "showCreateRoleGuideCount", "", "showPublishStatusGuideCount", "canShowCreateRolePage", "", "canShowPublishGuide", "canShowRoleBornAnim", "getSquareActivityViewModel", "Lcom/tencent/state/square/SquareViewModel;", "getSquareFragmentViewModel", "Lcom/tencent/state/square/SquareMapViewModel;", "getSquareMapView", "Lcom/tencent/state/square/SquareView;", "isCreateRoleGuideLimited", "isFirstShowPublishStatusGuide", "isPublishStatusGuideLimited", "isValidUrl", "url", "", "recordHasCheckedCreateRoleGuide", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class GuideContext {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "GuideContext";
    private final FragmentActivity activity;
    private final SquareNoviceGuideConfig config;
    private final VasBaseFragment fragment;
    private final VasBaseGroupFragment groupFragment;
    private long showCreateRoleGuideCount;
    private long showPublishStatusGuideCount;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/guide/GuideContext$Companion;", "", "()V", "TAG", "", "hasCheckedCreateRoleGuide", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean hasCheckedCreateRoleGuide() {
            return IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Guide.HAS_CHECKED_CREATE_ROLE_GUIDE, false, null, false, 12, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuideContext(FragmentActivity activity, VasBaseFragment fragment, VasBaseGroupFragment groupFragment, SquareNoviceGuideConfig config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(groupFragment, "groupFragment");
        Intrinsics.checkNotNullParameter(config, "config");
        this.activity = activity;
        this.fragment = fragment;
        this.groupFragment = groupFragment;
        this.config = config;
        this.showCreateRoleGuideCount = -1L;
        this.showPublishStatusGuideCount = -1L;
    }

    private final boolean isCreateRoleGuideLimited() {
        if (this.showCreateRoleGuideCount == -1) {
            long decodeLong$default = IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Guide.SHOW_CREATE_ROLE_GUIDE_COUNT, 0L, null, false, 12, null);
            this.showCreateRoleGuideCount = decodeLong$default;
            if (decodeLong$default < this.config.getCreateRoleGuideConfig().getPagDisplayNum()) {
                IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Guide.SHOW_CREATE_ROLE_GUIDE_COUNT, this.showCreateRoleGuideCount + 1, null, false, 12, null);
                return false;
            }
        }
        return this.showCreateRoleGuideCount >= this.config.getCreateRoleGuideConfig().getPagDisplayNum();
    }

    private final boolean isPublishStatusGuideLimited() {
        if (this.showPublishStatusGuideCount == -1) {
            long decodeLong$default = IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Guide.SHOW_PUBLISH_STATUS_GUIDE_COUNT, 0L, null, false, 12, null);
            this.showPublishStatusGuideCount = decodeLong$default;
            if (decodeLong$default < this.config.getPublishStatusGuideConfig().getPagDisplayNum()) {
                IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Guide.SHOW_PUBLISH_STATUS_GUIDE_COUNT, this.showPublishStatusGuideCount + 1, null, false, 12, null);
                return false;
            }
        }
        return this.showPublishStatusGuideCount >= this.config.getCreateRoleGuideConfig().getPagDisplayNum();
    }

    public final boolean canShowCreateRolePage() {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord2;
        SquareNoviceGuideRecord value2;
        if (this.config.getCreateRoleGuideConfig().getAlreadyCreateRole()) {
            return false;
        }
        SquareViewModel squareActivityViewModel2 = getSquareActivityViewModel();
        if ((squareActivityViewModel2 == null || (noviceGuideRecord2 = squareActivityViewModel2.getNoviceGuideRecord()) == null || (value2 = noviceGuideRecord2.getValue()) == null || !value2.getShowingCreateRolePage()) && ((squareActivityViewModel = getSquareActivityViewModel()) == null || (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) == null || (value = noviceGuideRecord.getValue()) == null || !value.getHasShowedCreateRolePage())) {
            return !isCreateRoleGuideLimited();
        }
        return false;
    }

    public final boolean canShowPublishGuide() {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord2;
        SquareNoviceGuideRecord value2;
        if (this.config.getPublishStatusGuideConfig().getAlreadySetStatus() || !isValidUrl(this.config.getPublishStatusGuideConfig().getStatusPagUrl())) {
            return false;
        }
        SquareViewModel squareActivityViewModel2 = getSquareActivityViewModel();
        if ((squareActivityViewModel2 == null || (noviceGuideRecord2 = squareActivityViewModel2.getNoviceGuideRecord()) == null || (value2 = noviceGuideRecord2.getValue()) == null || !value2.getPlayingPublishStatusAnim()) && ((squareActivityViewModel = getSquareActivityViewModel()) == null || (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) == null || (value = noviceGuideRecord.getValue()) == null || !value.getHasPlayedPublishStatusAnim())) {
            return !isPublishStatusGuideLimited();
        }
        return false;
    }

    public final boolean canShowRoleBornAnim() {
        SquareViewModel squareActivityViewModel;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
        SquareNoviceGuideRecord value;
        LiveData<SquareNoviceGuideRecord> noviceGuideRecord2;
        SquareNoviceGuideRecord value2;
        if (this.config.getCreateRoleGuideConfig().getAlreadyCreateRole() || !isValidUrl(this.config.getCreateRoleGuideConfig().getBornPagUrl())) {
            return false;
        }
        SquareViewModel squareActivityViewModel2 = getSquareActivityViewModel();
        if ((squareActivityViewModel2 == null || (noviceGuideRecord2 = squareActivityViewModel2.getNoviceGuideRecord()) == null || (value2 = noviceGuideRecord2.getValue()) == null || !value2.getPlayingRoleBornAnim()) && ((squareActivityViewModel = getSquareActivityViewModel()) == null || (noviceGuideRecord = squareActivityViewModel.getNoviceGuideRecord()) == null || (value = noviceGuideRecord.getValue()) == null || !value.getHasPlayedRoleBornAnim())) {
            return !isCreateRoleGuideLimited();
        }
        return false;
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final SquareNoviceGuideConfig getConfig() {
        return this.config;
    }

    public final VasBaseFragment getFragment() {
        return this.fragment;
    }

    public final VasBaseGroupFragment getGroupFragment() {
        return this.groupFragment;
    }

    public final SquareViewModel getSquareActivityViewModel() {
        return (SquareViewModel) VMUtils.INSTANCE.safelyGet(this.groupFragment, SquareViewModel.class);
    }

    public final SquareMapViewModel getSquareFragmentViewModel() {
        return (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(this.fragment, SquareMapViewModel.class);
    }

    public final SquareView getSquareMapView() {
        VasBaseFragment vasBaseFragment = this.fragment;
        if (!(vasBaseFragment instanceof SquareFragment)) {
            vasBaseFragment = null;
        }
        SquareFragment squareFragment = (SquareFragment) vasBaseFragment;
        if (squareFragment != null) {
            return squareFragment.getMapView();
        }
        return null;
    }

    public final boolean isFirstShowPublishStatusGuide() {
        return this.showPublishStatusGuideCount == 0;
    }

    public final boolean isValidUrl(String url) {
        boolean startsWith;
        Intrinsics.checkNotNullParameter(url, "url");
        startsWith = StringsKt__StringsJVMKt.startsWith(url, "http", true);
        return startsWith;
    }

    public final void recordHasCheckedCreateRoleGuide() {
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Guide.HAS_CHECKED_CREATE_ROLE_GUIDE, true, null, false, 12, null);
    }
}
