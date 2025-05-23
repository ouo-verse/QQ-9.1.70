package com.tencent.mobileqq.profilecard.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/profilecard/data/ProfileMusicDataGeneBean;", "Lcom/tencent/mobileqq/profilecard/entity/IProfileBusinessInfo;", "title", "", "leftTile", "leftValue", "rightTile", "rightValue", WadlProxyConsts.KEY_JUMP_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJumpUrl", "()Ljava/lang/String;", "getLeftTile", "getLeftValue", "getRightTile", "getRightValue", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ProfileMusicDataGeneBean implements IProfileBusinessInfo {
    private final String jumpUrl;
    private final String leftTile;
    private final String leftValue;
    private final String rightTile;
    private final String rightValue;
    private final String title;

    public ProfileMusicDataGeneBean(String str, String str2, String str3, String str4, String str5, String str6) {
        this.title = str;
        this.leftTile = str2;
        this.leftValue = str3;
        this.rightTile = str4;
        this.rightValue = str5;
        this.jumpUrl = str6;
    }

    public static /* synthetic */ ProfileMusicDataGeneBean copy$default(ProfileMusicDataGeneBean profileMusicDataGeneBean, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = profileMusicDataGeneBean.title;
        }
        if ((i3 & 2) != 0) {
            str2 = profileMusicDataGeneBean.leftTile;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = profileMusicDataGeneBean.leftValue;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = profileMusicDataGeneBean.rightTile;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            str5 = profileMusicDataGeneBean.rightValue;
        }
        String str10 = str5;
        if ((i3 & 32) != 0) {
            str6 = profileMusicDataGeneBean.jumpUrl;
        }
        return profileMusicDataGeneBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLeftTile() {
        return this.leftTile;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLeftValue() {
        return this.leftValue;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRightTile() {
        return this.rightTile;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRightValue() {
        return this.rightValue;
    }

    /* renamed from: component6, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final ProfileMusicDataGeneBean copy(String title, String leftTile, String leftValue, String rightTile, String rightValue, String jumpUrl) {
        return new ProfileMusicDataGeneBean(title, leftTile, leftValue, rightTile, rightValue, jumpUrl);
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getLeftTile() {
        return this.leftTile;
    }

    public final String getLeftValue() {
        return this.leftValue;
    }

    public final String getRightTile() {
        return this.rightTile;
    }

    public final String getRightValue() {
        return this.rightValue;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.leftTile;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.leftValue;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rightTile;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.rightValue;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.jumpUrl;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "ProfileMusicDataGeneBean(title=" + this.title + ", leftTile=" + this.leftTile + ", leftValue=" + this.leftValue + ", rightTile=" + this.rightTile + ", rightValue=" + this.rightValue + ", jumpUrl=" + this.jumpUrl + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileMusicDataGeneBean)) {
            return false;
        }
        ProfileMusicDataGeneBean profileMusicDataGeneBean = (ProfileMusicDataGeneBean) other;
        return Intrinsics.areEqual(this.title, profileMusicDataGeneBean.title) && Intrinsics.areEqual(this.leftTile, profileMusicDataGeneBean.leftTile) && Intrinsics.areEqual(this.leftValue, profileMusicDataGeneBean.leftValue) && Intrinsics.areEqual(this.rightTile, profileMusicDataGeneBean.rightTile) && Intrinsics.areEqual(this.rightValue, profileMusicDataGeneBean.rightValue) && Intrinsics.areEqual(this.jumpUrl, profileMusicDataGeneBean.jumpUrl);
    }
}
