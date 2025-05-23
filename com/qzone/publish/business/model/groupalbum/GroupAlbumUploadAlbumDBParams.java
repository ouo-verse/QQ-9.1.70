package com.qzone.publish.business.model.groupalbum;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadMediaInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadPoiInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R.\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R.\u0010/\u001a\u0012\u0012\u0004\u0012\u0002000%j\b\u0012\u0004\u0012\u000200`'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010)\"\u0004\b2\u0010+R \u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000f\"\u0004\bG\u0010\u0011\u00a8\u0006H"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumDBParams;", "Lcom/tencent/component/app/common/SmartParcelable;", "albumParams", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;)V", "()V", "albumInfo", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;)V", "batchId", "", "getBatchId", "()J", "setBatchId", "(J)V", "clientKey", "", "getClientKey", "()Ljava/lang/String;", "setClientKey", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "curNum", "", "getCurNum", "()I", "setCurNum", "(I)V", "groupId", "getGroupId", "setGroupId", "localMediaList", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadMediaInfo;", "Lkotlin/collections/ArrayList;", "getLocalMediaList", "()Ljava/util/ArrayList;", "setLocalMediaList", "(Ljava/util/ArrayList;)V", "maxNum", "getMaxNum", "setMaxNum", "mediaWrapperList", "Lcom/qzone/publish/ui/model/MediaWrapper;", "getMediaWrapperList", "setMediaWrapperList", "poiInfo", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;", "getPoiInfo", "()Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;", "setPoiInfo", "(Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;)V", "requestParams", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "getRequestParams", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "setRequestParams", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;)V", "taskParams", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;", "getTaskParams", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;", "setTaskParams", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;)V", PhotoCategorySinglePicInfo.UPLOAD_TIME, "getUploadTime", "setUploadTime", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class GroupAlbumUploadAlbumDBParams implements SmartParcelable {

    @NeedParcel
    private GroupAlbumUploadAlbumInfo albumInfo;

    @NeedParcel
    private long batchId;

    @NeedParcel
    private String clientKey;

    @NeedParcel
    private String content;

    @NeedParcel
    private int curNum;

    @NeedParcel
    private String groupId;

    @NeedParcel
    private ArrayList<CommonAlbumUploadMediaInfo> localMediaList;

    @NeedParcel
    private int maxNum;

    @NeedParcel
    private ArrayList<MediaWrapper> mediaWrapperList;

    @NeedParcel
    private CommonAlbumUploadPoiInfo poiInfo;

    @NeedParcel
    private GroupAlbumUploadRequestParams requestParams;

    @NeedParcel
    private GroupAlbumUploadTaskParams taskParams;

    @NeedParcel
    private long uploadTime;

    public GroupAlbumUploadAlbumDBParams() {
        this.batchId = -1L;
        this.clientKey = "";
        this.groupId = "";
        this.albumInfo = new GroupAlbumUploadAlbumInfo(null, null, 3, null);
        this.content = "";
        this.mediaWrapperList = new ArrayList<>();
        this.localMediaList = new ArrayList<>();
        this.uploadTime = -1L;
        this.curNum = -1;
        this.maxNum = -1;
        this.requestParams = new GroupAlbumUploadRequestParams(0, null, 0, null, null, 0, null, 127, null);
        this.taskParams = new GroupAlbumUploadTaskParams(0, 0, 3, null);
    }

    public final GroupAlbumUploadAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final String getClientKey() {
        return this.clientKey;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getCurNum() {
        return this.curNum;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final ArrayList<CommonAlbumUploadMediaInfo> getLocalMediaList() {
        return this.localMediaList;
    }

    public final int getMaxNum() {
        return this.maxNum;
    }

    public final ArrayList<MediaWrapper> getMediaWrapperList() {
        return this.mediaWrapperList;
    }

    public final CommonAlbumUploadPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    public final GroupAlbumUploadRequestParams getRequestParams() {
        return this.requestParams;
    }

    public final GroupAlbumUploadTaskParams getTaskParams() {
        return this.taskParams;
    }

    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final void setAlbumInfo(GroupAlbumUploadAlbumInfo groupAlbumUploadAlbumInfo) {
        Intrinsics.checkNotNullParameter(groupAlbumUploadAlbumInfo, "<set-?>");
        this.albumInfo = groupAlbumUploadAlbumInfo;
    }

    public final void setBatchId(long j3) {
        this.batchId = j3;
    }

    public final void setClientKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientKey = str;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setCurNum(int i3) {
        this.curNum = i3;
    }

    public final void setGroupId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setLocalMediaList(ArrayList<CommonAlbumUploadMediaInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.localMediaList = arrayList;
    }

    public final void setMaxNum(int i3) {
        this.maxNum = i3;
    }

    public final void setMediaWrapperList(ArrayList<MediaWrapper> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mediaWrapperList = arrayList;
    }

    public final void setPoiInfo(CommonAlbumUploadPoiInfo commonAlbumUploadPoiInfo) {
        this.poiInfo = commonAlbumUploadPoiInfo;
    }

    public final void setRequestParams(GroupAlbumUploadRequestParams groupAlbumUploadRequestParams) {
        Intrinsics.checkNotNullParameter(groupAlbumUploadRequestParams, "<set-?>");
        this.requestParams = groupAlbumUploadRequestParams;
    }

    public final void setTaskParams(GroupAlbumUploadTaskParams groupAlbumUploadTaskParams) {
        Intrinsics.checkNotNullParameter(groupAlbumUploadTaskParams, "<set-?>");
        this.taskParams = groupAlbumUploadTaskParams;
    }

    public final void setUploadTime(long j3) {
        this.uploadTime = j3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupAlbumUploadAlbumDBParams(GroupAlbumUploadAlbumParams albumParams) {
        this();
        Intrinsics.checkNotNullParameter(albumParams, "albumParams");
        this.batchId = albumParams.getBatchId();
        this.clientKey = albumParams.getClientKey();
        this.groupId = albumParams.getGroupId();
        this.albumInfo = albumParams.getAlbumInfo();
        this.content = albumParams.getContent();
        this.mediaWrapperList = albumParams.getMediaWrapperList();
        this.localMediaList = new ArrayList<>(albumParams.getLocalMediaList());
        this.poiInfo = albumParams.getPoiInfo();
        this.uploadTime = albumParams.getUploadTime();
        this.curNum = albumParams.getCurNum();
        this.maxNum = albumParams.getMaxNum();
        this.requestParams = albumParams.getRequestParams();
        this.taskParams = albumParams.getTaskParams();
    }
}
