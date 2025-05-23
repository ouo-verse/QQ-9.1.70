package com.tencent.mobileqq.profilecard.data;

import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataBean;", "Lcom/tencent/mobileqq/profilecard/entity/IProfileBusinessInfo;", "geneBean", "Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataGeneBean;", "medalBean", "Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataMedalBean;", "recentListening", "", "(Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataGeneBean;Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataMedalBean;Ljava/lang/String;)V", "getGeneBean", "()Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataGeneBean;", "getMedalBean", "()Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataMedalBean;", "getRecentListening", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ProfileMusicDataBean implements IProfileBusinessInfo {
    private final ProfileMusicDataGeneBean geneBean;
    private final ProfileMusicDataMedalBean medalBean;
    private final String recentListening;

    public ProfileMusicDataBean(ProfileMusicDataGeneBean profileMusicDataGeneBean, ProfileMusicDataMedalBean profileMusicDataMedalBean, String str) {
        this.geneBean = profileMusicDataGeneBean;
        this.medalBean = profileMusicDataMedalBean;
        this.recentListening = str;
    }

    /* renamed from: component1, reason: from getter */
    public final ProfileMusicDataGeneBean getGeneBean() {
        return this.geneBean;
    }

    /* renamed from: component2, reason: from getter */
    public final ProfileMusicDataMedalBean getMedalBean() {
        return this.medalBean;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRecentListening() {
        return this.recentListening;
    }

    public final ProfileMusicDataBean copy(ProfileMusicDataGeneBean geneBean, ProfileMusicDataMedalBean medalBean, String recentListening) {
        return new ProfileMusicDataBean(geneBean, medalBean, recentListening);
    }

    public final ProfileMusicDataGeneBean getGeneBean() {
        return this.geneBean;
    }

    public final ProfileMusicDataMedalBean getMedalBean() {
        return this.medalBean;
    }

    public final String getRecentListening() {
        return this.recentListening;
    }

    public int hashCode() {
        ProfileMusicDataGeneBean profileMusicDataGeneBean = this.geneBean;
        int hashCode = (profileMusicDataGeneBean == null ? 0 : profileMusicDataGeneBean.hashCode()) * 31;
        ProfileMusicDataMedalBean profileMusicDataMedalBean = this.medalBean;
        int hashCode2 = (hashCode + (profileMusicDataMedalBean == null ? 0 : profileMusicDataMedalBean.hashCode())) * 31;
        String str = this.recentListening;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ProfileMusicDataBean(geneBean=" + this.geneBean + ", medalBean=" + this.medalBean + ", recentListening=" + this.recentListening + ')';
    }

    public static /* synthetic */ ProfileMusicDataBean copy$default(ProfileMusicDataBean profileMusicDataBean, ProfileMusicDataGeneBean profileMusicDataGeneBean, ProfileMusicDataMedalBean profileMusicDataMedalBean, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            profileMusicDataGeneBean = profileMusicDataBean.geneBean;
        }
        if ((i3 & 2) != 0) {
            profileMusicDataMedalBean = profileMusicDataBean.medalBean;
        }
        if ((i3 & 4) != 0) {
            str = profileMusicDataBean.recentListening;
        }
        return profileMusicDataBean.copy(profileMusicDataGeneBean, profileMusicDataMedalBean, str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileMusicDataBean)) {
            return false;
        }
        ProfileMusicDataBean profileMusicDataBean = (ProfileMusicDataBean) other;
        return Intrinsics.areEqual(this.geneBean, profileMusicDataBean.geneBean) && Intrinsics.areEqual(this.medalBean, profileMusicDataBean.medalBean) && Intrinsics.areEqual(this.recentListening, profileMusicDataBean.recentListening);
    }
}
