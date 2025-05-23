package com.tencent.ecommerce.biz.register.officialAccountFollowedChecker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/register/officialAccountFollowedChecker/ECAccountFollowedCheckerViewModel;", "Landroidx/lifecycle/ViewModel;", "", "accountType", "accountFollowScene", "", "N1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_followAccountRespStatus", "", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_isShowGuideView", BdhLogUtil.LogTag.Tag_Conn, "_guideViewNotShowReason", "D", "_shouldShowGuideView", "E", "getShouldShowGuideViewLiveData", "()Landroidx/lifecycle/MutableLiveData;", "shouldShowGuideViewLiveData", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "getFollowAccountStatusLiveData", "()Landroidx/lifecycle/LiveData;", "followAccountStatusLiveData", "Lcom/tencent/ecommerce/biz/register/officialAccountFollowedChecker/ECAccountFollowedRepository;", "G", "Lcom/tencent/ecommerce/biz/register/officialAccountFollowedChecker/ECAccountFollowedRepository;", "O1", "()Lcom/tencent/ecommerce/biz/register/officialAccountFollowedChecker/ECAccountFollowedRepository;", "repo", "<init>", "()V", "H", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAccountFollowedCheckerViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _guideViewNotShowReason;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _shouldShowGuideView;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> shouldShowGuideViewLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Integer> followAccountStatusLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final ECAccountFollowedRepository repo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> _followAccountRespStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _isShowGuideView;

    public ECAccountFollowedCheckerViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._followAccountRespStatus = mutableLiveData;
        Boolean bool = Boolean.FALSE;
        this._isShowGuideView = new MutableLiveData<>(bool);
        this._guideViewNotShowReason = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(bool);
        this._shouldShowGuideView = mutableLiveData2;
        this.shouldShowGuideViewLiveData = mutableLiveData2;
        this.followAccountStatusLiveData = mutableLiveData;
        this.repo = ECAccountFollowedRepository.f103993a;
    }

    public final void N1(int accountType, int accountFollowScene) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECAccountFollowedCheckerViewModel$followAccount$1(this, accountType, accountFollowScene, null), 3, null);
    }

    /* renamed from: O1, reason: from getter */
    public final ECAccountFollowedRepository getRepo() {
        return this.repo;
    }
}
