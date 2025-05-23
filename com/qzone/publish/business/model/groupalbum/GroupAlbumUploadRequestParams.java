package com.qzone.publish.business.model.groupalbum;

import SLICE_UPLOAD.cnst.appid_qun;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00014BY\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0002H\u00c6\u0003J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u00c6\u0003J[\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "component6", "Ljava/util/concurrent/ConcurrentHashMap;", "component7", "target", "refer", "iBusinessType", "picAppId", "videoAppId", "picQuality", "extendInfo", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getTarget", "()I", "setTarget", "(I)V", "Ljava/lang/String;", "getRefer", "()Ljava/lang/String;", "setRefer", "(Ljava/lang/String;)V", "getIBusinessType", "setIBusinessType", "getPicAppId", "setPicAppId", "getVideoAppId", "setVideoAppId", "getPicQuality", "setPicQuality", "Ljava/util/concurrent/ConcurrentHashMap;", "getExtendInfo", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExtendInfo", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/concurrent/ConcurrentHashMap;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class GroupAlbumUploadRequestParams implements Serializable {
    private static final long serialVersionUID = 1948538260691651093L;
    private ConcurrentHashMap<String, String> extendInfo;
    private int iBusinessType;
    private String picAppId;
    private int picQuality;
    private String refer;
    private int target;
    private String videoAppId;

    public GroupAlbumUploadRequestParams() {
        this(0, null, 0, null, null, 0, null, 127, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTarget() {
        return this.target;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRefer() {
        return this.refer;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIBusinessType() {
        return this.iBusinessType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPicAppId() {
        return this.picAppId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getVideoAppId() {
        return this.videoAppId;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPicQuality() {
        return this.picQuality;
    }

    public final ConcurrentHashMap<String, String> component7() {
        return this.extendInfo;
    }

    public final GroupAlbumUploadRequestParams copy(int target, String refer, int iBusinessType, String picAppId, String videoAppId, int picQuality, ConcurrentHashMap<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        Intrinsics.checkNotNullParameter(picAppId, "picAppId");
        Intrinsics.checkNotNullParameter(videoAppId, "videoAppId");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        return new GroupAlbumUploadRequestParams(target, refer, iBusinessType, picAppId, videoAppId, picQuality, extendInfo);
    }

    public final ConcurrentHashMap<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public final int getIBusinessType() {
        return this.iBusinessType;
    }

    public final String getPicAppId() {
        return this.picAppId;
    }

    public final int getPicQuality() {
        return this.picQuality;
    }

    public final String getRefer() {
        return this.refer;
    }

    public final int getTarget() {
        return this.target;
    }

    public final String getVideoAppId() {
        return this.videoAppId;
    }

    public int hashCode() {
        return (((((((((((this.target * 31) + this.refer.hashCode()) * 31) + this.iBusinessType) * 31) + this.picAppId.hashCode()) * 31) + this.videoAppId.hashCode()) * 31) + this.picQuality) * 31) + this.extendInfo.hashCode();
    }

    public final void setExtendInfo(ConcurrentHashMap<String, String> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.extendInfo = concurrentHashMap;
    }

    public final void setIBusinessType(int i3) {
        this.iBusinessType = i3;
    }

    public final void setPicAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.picAppId = str;
    }

    public final void setPicQuality(int i3) {
        this.picQuality = i3;
    }

    public final void setRefer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refer = str;
    }

    public final void setTarget(int i3) {
        this.target = i3;
    }

    public final void setVideoAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoAppId = str;
    }

    public String toString() {
        return "GroupAlbumUploadRequestParams(target=" + this.target + ", refer=" + this.refer + ", iBusinessType=" + this.iBusinessType + ", picAppId=" + this.picAppId + ", videoAppId=" + this.videoAppId + ", picQuality=" + this.picQuality + ", extendInfo=" + this.extendInfo + ")";
    }

    public GroupAlbumUploadRequestParams(int i3, String refer, int i16, String picAppId, String videoAppId, int i17, ConcurrentHashMap<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        Intrinsics.checkNotNullParameter(picAppId, "picAppId");
        Intrinsics.checkNotNullParameter(videoAppId, "videoAppId");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        this.target = i3;
        this.refer = refer;
        this.iBusinessType = i16;
        this.picAppId = picAppId;
        this.videoAppId = videoAppId;
        this.picQuality = i17;
        this.extendInfo = extendInfo;
    }

    public static /* synthetic */ GroupAlbumUploadRequestParams copy$default(GroupAlbumUploadRequestParams groupAlbumUploadRequestParams, int i3, String str, int i16, String str2, String str3, int i17, ConcurrentHashMap concurrentHashMap, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = groupAlbumUploadRequestParams.target;
        }
        if ((i18 & 2) != 0) {
            str = groupAlbumUploadRequestParams.refer;
        }
        String str4 = str;
        if ((i18 & 4) != 0) {
            i16 = groupAlbumUploadRequestParams.iBusinessType;
        }
        int i19 = i16;
        if ((i18 & 8) != 0) {
            str2 = groupAlbumUploadRequestParams.picAppId;
        }
        String str5 = str2;
        if ((i18 & 16) != 0) {
            str3 = groupAlbumUploadRequestParams.videoAppId;
        }
        String str6 = str3;
        if ((i18 & 32) != 0) {
            i17 = groupAlbumUploadRequestParams.picQuality;
        }
        int i26 = i17;
        if ((i18 & 64) != 0) {
            concurrentHashMap = groupAlbumUploadRequestParams.extendInfo;
        }
        return groupAlbumUploadRequestParams.copy(i3, str4, i19, str5, str6, i26, concurrentHashMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumUploadRequestParams)) {
            return false;
        }
        GroupAlbumUploadRequestParams groupAlbumUploadRequestParams = (GroupAlbumUploadRequestParams) other;
        return this.target == groupAlbumUploadRequestParams.target && Intrinsics.areEqual(this.refer, groupAlbumUploadRequestParams.refer) && this.iBusinessType == groupAlbumUploadRequestParams.iBusinessType && Intrinsics.areEqual(this.picAppId, groupAlbumUploadRequestParams.picAppId) && Intrinsics.areEqual(this.videoAppId, groupAlbumUploadRequestParams.videoAppId) && this.picQuality == groupAlbumUploadRequestParams.picQuality && Intrinsics.areEqual(this.extendInfo, groupAlbumUploadRequestParams.extendInfo);
    }

    public /* synthetic */ GroupAlbumUploadRequestParams(int i3, String str, int i16, String str2, String str3, int i17, ConcurrentHashMap concurrentHashMap, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 5 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? appid_qun.value : str2, (i18 & 16) != 0 ? "video_qun" : str3, (i18 & 32) == 0 ? i17 : 0, (i18 & 64) != 0 ? new ConcurrentHashMap() : concurrentHashMap);
    }
}
