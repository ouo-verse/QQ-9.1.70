package com.tencent.mobileqq.profilecard.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J?\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataMedalBean;", "Lcom/tencent/mobileqq/profilecard/entity/IProfileBusinessInfo;", "title", "", "number", "", "picUrl", "", WadlProxyConsts.KEY_JUMP_URL, "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "getJumpUrl", "()Ljava/lang/String;", "getNumber", "()I", "getPicUrl", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ProfileMusicDataMedalBean implements IProfileBusinessInfo {
    private final String jumpUrl;
    private final int number;
    private final List<String> picUrl;
    private final String title;

    public ProfileMusicDataMedalBean(String str, int i3, List<String> list, String str2) {
        this.title = str;
        this.number = i3;
        this.picUrl = list;
        this.jumpUrl = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileMusicDataMedalBean copy$default(ProfileMusicDataMedalBean profileMusicDataMedalBean, String str, int i3, List list, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = profileMusicDataMedalBean.title;
        }
        if ((i16 & 2) != 0) {
            i3 = profileMusicDataMedalBean.number;
        }
        if ((i16 & 4) != 0) {
            list = profileMusicDataMedalBean.picUrl;
        }
        if ((i16 & 8) != 0) {
            str2 = profileMusicDataMedalBean.jumpUrl;
        }
        return profileMusicDataMedalBean.copy(str, i3, list, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    public final List<String> component3() {
        return this.picUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final ProfileMusicDataMedalBean copy(String title, int number, List<String> picUrl, String jumpUrl) {
        return new ProfileMusicDataMedalBean(title, number, picUrl, jumpUrl);
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getNumber() {
        return this.number;
    }

    public final List<String> getPicUrl() {
        return this.picUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.number) * 31;
        List<String> list = this.picUrl;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.jumpUrl;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ProfileMusicDataMedalBean(title=" + this.title + ", number=" + this.number + ", picUrl=" + this.picUrl + ", jumpUrl=" + this.jumpUrl + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileMusicDataMedalBean)) {
            return false;
        }
        ProfileMusicDataMedalBean profileMusicDataMedalBean = (ProfileMusicDataMedalBean) other;
        return Intrinsics.areEqual(this.title, profileMusicDataMedalBean.title) && this.number == profileMusicDataMedalBean.number && Intrinsics.areEqual(this.picUrl, profileMusicDataMedalBean.picUrl) && Intrinsics.areEqual(this.jumpUrl, profileMusicDataMedalBean.jumpUrl);
    }
}
