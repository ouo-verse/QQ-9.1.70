package com.qzone.reborn.feedx.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.model.CoverCacheData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/f;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Lcom/qzone/common/business/result/QZoneResult;", "result", "", "O1", "Landroidx/lifecycle/MutableLiveData;", "Lcooperation/qzone/model/CoverCacheData;", "i", "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "setMCoverLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "mCoverLiveData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "setMCoverAlphaLiveData", "mCoverAlphaLiveData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<CoverCacheData> mCoverLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Integer> mCoverAlphaLiveData = new MutableLiveData<>();

    public final MutableLiveData<Integer> M1() {
        return this.mCoverAlphaLiveData;
    }

    public final MutableLiveData<CoverCacheData> N1() {
        return this.mCoverLiveData;
    }

    public final void O1(QZoneResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        CoverCacheData coverCacheData = (CoverCacheData) result.getBundle().getParcelable(QzoneCoverConst.PARAM_CACHE_DATA);
        if (coverCacheData != null) {
            this.mCoverLiveData.setValue(coverCacheData);
            this.mCoverAlphaLiveData.setValue(Integer.valueOf(QZoneCoverUtils.getSuperCoverTrans(coverCacheData)));
        }
        com.qzone.reborn.feedx.util.c.f55739a.a(getLogTag(), "onFeedSubsidiaryRefreshFinish: coverCacheData: " + coverCacheData);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneFeedxCoverViewModel";
    }
}
