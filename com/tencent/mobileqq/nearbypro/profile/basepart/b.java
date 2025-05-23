package com.tencent.mobileqq.nearbypro.profile.basepart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.NearbyNetError;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.base.l;
import com.tencent.mobileqq.nearbypro.utils.k;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import jb2.UserProfileData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\"\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/basepart/b;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroidx/lifecycle/LiveData;", "Ljb2/a;", "O1", "userProfileData", "", "P1", "", "tinyId", "M1", "", "getLogTag", "Lcom/tencent/mobileqq/nearbypro/profile/basepart/d;", "i", "Lcom/tencent/mobileqq/nearbypro/profile/basepart/d;", "repository", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", ITVKPlayerEventListener.KEY_USER_INFO, BdhLogUtil.LogTag.Tag_Conn, "jumpScheme", "Lcom/tencent/mobileqq/nearbypro/utils/k;", "", "kotlin.jvm.PlatformType", "D", "Lcom/tencent/mobileqq/nearbypro/utils/k;", IProfileProtocolConst.PARAM_IS_FRIEND, "<init>", "()V", "E", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d repository = new d();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UserProfileData> userInfo = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> jumpScheme = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final k<Boolean> isFriend = new k<>(Boolean.FALSE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(b this$0, NearbyNetError error, UserProfileData userProfileData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.getCode() == 0 && userProfileData != null) {
            j.c().e("NBP.PersonalPart.ProfileBaseViewModel", "fetchUserInfo " + userProfileData.getTinyId() + ", " + userProfileData.getAvatarUrl() + ", " + userProfileData.getNickName() + ", " + userProfileData.getAvatarDressBorderUrl());
            this$0.P1(userProfileData);
            return;
        }
        this$0.P1(new UserProfileData(0L, "", "", null, 8, null));
    }

    public final void M1(long tinyId) {
        this.repository.k(tinyId, new l() { // from class: com.tencent.mobileqq.nearbypro.profile.basepart.a
            @Override // com.tencent.mobileqq.nearbypro.base.l
            public final void a(NearbyNetError nearbyNetError, Object obj) {
                b.N1(b.this, nearbyNetError, (UserProfileData) obj);
            }
        });
    }

    @NotNull
    public final LiveData<UserProfileData> O1() {
        return this.userInfo;
    }

    public final void P1(@NotNull UserProfileData userProfileData) {
        Intrinsics.checkNotNullParameter(userProfileData, "userProfileData");
        this.userInfo.setValue(userProfileData);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "NBP.PersonalPart.ProfileBaseViewModel";
    }
}
