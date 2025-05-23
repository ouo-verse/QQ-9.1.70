package com.qzone.publish.business.model.groupalbum;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.n;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadMediaInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadPoiInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qqnt.kernel.nativeinterface.RichMsgType;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellCommon;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellMedia;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellQunInfo;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellSummary;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StRichMsg;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 x2\u00020\u0001:\u0001\u0010B\u00a1\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010-\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0012\u0012\b\b\u0002\u0010/\u001a\u00020\u001a\u0012\b\b\u0002\u00100\u001a\u00020\u0012\u0012\u0018\b\u0002\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u00104\u001a\u00020\r\u0012\b\b\u0002\u00105\u001a\u00020\u000b\u0012\b\b\u0002\u00106\u001a\u00020\u000b\u0012\b\b\u0002\u00107\u001a\u00020)\u0012\b\b\u0002\u00108\u001a\u00020+\u00a2\u0006\u0004\bs\u0010tB\u0011\b\u0016\u0012\u0006\u0010v\u001a\u00020u\u00a2\u0006\u0004\bs\u0010wJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0002J*\u0010\u000f\u001a\u00020\u0003*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\f\u0010\u0010\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0011\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u0016\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\t\u0010\u0017\u001a\u00020\rH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0012H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0012H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u001aH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0012H\u00c6\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010$H\u00c6\u0003J\t\u0010&\u001a\u00020\rH\u00c6\u0003J\t\u0010'\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003J\t\u0010*\u001a\u00020)H\u00c6\u0003J\t\u0010,\u001a\u00020+H\u00c6\u0003J\u00a3\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u001a2\b\b\u0002\u00100\u001a\u00020\u00122\u0018\b\u0002\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\"0!2\n\b\u0002\u00103\u001a\u0004\u0018\u00010$2\b\b\u0002\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020)2\b\b\u0002\u00108\u001a\u00020+H\u00c6\u0001J\t\u0010:\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010=\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010;H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010-\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010.\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010C\u001a\u0004\bH\u0010E\"\u0004\bI\u0010GR\"\u0010/\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u00100\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010C\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR2\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR(\u00102\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u00103\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u00104\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010>\u001a\u0004\b`\u0010@\"\u0004\ba\u0010BR\"\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u00106\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010b\u001a\u0004\bg\u0010d\"\u0004\bh\u0010fR\"\u00107\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u00108\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r\u00a8\u0006y"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "Ljava/io/Serializable;", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "", "e", "g", "b", "f", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "stMediaList", "", "batchNum", "", "batchId", "c", "a", "d", "", "toString", "", "isEmpty", "toStFeed", "component1", "component2", "component3", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;", "component4", "component5", "Ljava/util/ArrayList;", "Lcom/qzone/publish/ui/model/MediaWrapper;", "Lkotlin/collections/ArrayList;", "component6", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadMediaInfo;", "component7", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;", "component8", "component9", "component10", "component11", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "component12", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;", "component13", "clientKey", "groupId", "albumInfo", "content", "mediaWrapperList", "localMediaList", "poiInfo", PhotoCategorySinglePicInfo.UPLOAD_TIME, "curNum", "maxNum", "requestParams", "taskParams", "copy", "hashCode", "", "other", "equals", "J", "getBatchId", "()J", "setBatchId", "(J)V", "Ljava/lang/String;", "getClientKey", "()Ljava/lang/String;", "setClientKey", "(Ljava/lang/String;)V", "getGroupId", "setGroupId", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;)V", "getContent", "setContent", "Ljava/util/ArrayList;", "getMediaWrapperList", "()Ljava/util/ArrayList;", "setMediaWrapperList", "(Ljava/util/ArrayList;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getLocalMediaList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setLocalMediaList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;", "getPoiInfo", "()Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;", "setPoiInfo", "(Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;)V", "getUploadTime", "setUploadTime", "I", "getCurNum", "()I", "setCurNum", "(I)V", "getMaxNum", "setMaxNum", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "getRequestParams", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;", "setRequestParams", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;)V", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;", "getTaskParams", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;", "setTaskParams", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;)V", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumInfo;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/concurrent/CopyOnWriteArrayList;Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;JIILcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadRequestParams;Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskParams;)V", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumDBParams;", "dbParams", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumDBParams;)V", "Companion", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class GroupAlbumUploadAlbumParams implements Serializable {
    private static final long serialVersionUID = 1948538260691651094L;
    private GroupAlbumUploadAlbumInfo albumInfo;
    private long batchId;
    private String clientKey;
    private String content;
    private int curNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private transient ArrayList<MediaWrapper> mediaWrapperList;
    private String groupId;
    private CopyOnWriteArrayList<CommonAlbumUploadMediaInfo> localMediaList;
    private int maxNum;
    private CommonAlbumUploadPoiInfo poiInfo;
    private GroupAlbumUploadRequestParams requestParams;
    private GroupAlbumUploadTaskParams taskParams;
    private long uploadTime;

    public GroupAlbumUploadAlbumParams() {
        this(0L, null, null, null, null, null, null, null, 0L, 0, 0, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    private final void a(StFeed stFeed) {
        StFeedCellCommon stFeedCellCommon = new StFeedCellCommon();
        stFeedCellCommon.appId = 2;
        stFeedCellCommon.bizId = 3;
        stFeedCellCommon.time = this.uploadTime;
        stFeedCellCommon.clientKey = this.clientKey;
        stFeed.cellCommon = stFeedCellCommon;
    }

    private final void b(StFeed stFeed) {
        CommonAlbumUploadPoiInfo commonAlbumUploadPoiInfo = this.poiInfo;
        if (commonAlbumUploadPoiInfo != null) {
            stFeed.cellLbs = commonAlbumUploadPoiInfo.toStFeedCellLBS();
        }
    }

    private final void c(StFeed stFeed, List<StMedia> list, int i3, long j3) {
        StFeedCellMedia stFeedCellMedia = new StFeedCellMedia();
        stFeedCellMedia.albumName = this.albumInfo.getAlbumName();
        stFeedCellMedia.albumId = this.albumInfo.getAlbumId();
        stFeedCellMedia.uploadNum = i3;
        stFeedCellMedia.batchId = j3;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.StMedia>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.kernel.nativeinterface.StMedia> }");
        stFeedCellMedia.mediaItems = (ArrayList) list;
        stFeed.cellMedia = stFeedCellMedia;
    }

    private final void d(StFeed stFeed) {
        stFeed.cellQunInfo = new StFeedCellQunInfo(this.groupId);
    }

    private final void f(StFeed stFeed) {
        ArrayList<StRichMsg> arrayListOf;
        StFeedCellSummary stFeedCellSummary = new StFeedCellSummary();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new StRichMsg(RichMsgType.KRICHMSGTYPEPLAINTEXT.ordinal(), this.content, "", "", 0, "", "", new ArrayList()));
        stFeedCellSummary.summary = arrayListOf;
        stFeed.cellSummary = stFeedCellSummary;
    }

    private final void g(StFeed stFeed) {
        StFeedCellUserInfo stFeedCellUserInfo = new StFeedCellUserInfo();
        StUser stUser = new StUser();
        String selfTroopNickName = LoginData.getInstance().getSelfTroopNickName(this.groupId);
        if (selfTroopNickName == null) {
            RFWLog.e("StFeed", RFWLog.USR, "[fillCellUserInfo] nickName is null");
            selfTroopNickName = "";
        }
        stUser.dittoUin = LoginData.getInstance().getUid();
        stUser.nick = selfTroopNickName;
        stUser.uin = LoginData.getInstance().getUinString();
        stFeedCellUserInfo.user = stUser;
        stFeed.cellUserInfo = stFeedCellUserInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final long getBatchId() {
        return this.batchId;
    }

    /* renamed from: component10, reason: from getter */
    public final int getCurNum() {
        return this.curNum;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMaxNum() {
        return this.maxNum;
    }

    /* renamed from: component12, reason: from getter */
    public final GroupAlbumUploadRequestParams getRequestParams() {
        return this.requestParams;
    }

    /* renamed from: component13, reason: from getter */
    public final GroupAlbumUploadTaskParams getTaskParams() {
        return this.taskParams;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientKey() {
        return this.clientKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component4, reason: from getter */
    public final GroupAlbumUploadAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ArrayList<MediaWrapper> component6() {
        return this.mediaWrapperList;
    }

    public final CopyOnWriteArrayList<CommonAlbumUploadMediaInfo> component7() {
        return this.localMediaList;
    }

    /* renamed from: component8, reason: from getter */
    public final CommonAlbumUploadPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    /* renamed from: component9, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final GroupAlbumUploadAlbumParams copy(long batchId, String clientKey, String groupId, GroupAlbumUploadAlbumInfo albumInfo, String content, ArrayList<MediaWrapper> mediaWrapperList, CopyOnWriteArrayList<CommonAlbumUploadMediaInfo> localMediaList, CommonAlbumUploadPoiInfo poiInfo, long uploadTime, int curNum, int maxNum, GroupAlbumUploadRequestParams requestParams, GroupAlbumUploadTaskParams taskParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mediaWrapperList, "mediaWrapperList");
        Intrinsics.checkNotNullParameter(localMediaList, "localMediaList");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(taskParams, "taskParams");
        return new GroupAlbumUploadAlbumParams(batchId, clientKey, groupId, albumInfo, content, mediaWrapperList, localMediaList, poiInfo, uploadTime, curNum, maxNum, requestParams, taskParams);
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

    public final CopyOnWriteArrayList<CommonAlbumUploadMediaInfo> getLocalMediaList() {
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

    public int hashCode() {
        int a16 = ((((((((((((n.a(this.batchId) * 31) + this.clientKey.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.albumInfo.hashCode()) * 31) + this.content.hashCode()) * 31) + this.mediaWrapperList.hashCode()) * 31) + this.localMediaList.hashCode()) * 31;
        CommonAlbumUploadPoiInfo commonAlbumUploadPoiInfo = this.poiInfo;
        return ((((((((((a16 + (commonAlbumUploadPoiInfo == null ? 0 : commonAlbumUploadPoiInfo.hashCode())) * 31) + n.a(this.uploadTime)) * 31) + this.curNum) * 31) + this.maxNum) * 31) + this.requestParams.hashCode()) * 31) + this.taskParams.hashCode();
    }

    public final boolean isEmpty() {
        return Intrinsics.areEqual(new GroupAlbumUploadAlbumParams(0L, null, null, null, null, null, null, null, 0L, 0, 0, null, null, InitSkin.DRAWABLE_COUNT, null), this);
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

    public final void setLocalMediaList(CopyOnWriteArrayList<CommonAlbumUploadMediaInfo> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        this.localMediaList = copyOnWriteArrayList;
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

    public final StFeed toStFeed(List<StMedia> stMediaList, int batchNum) {
        Intrinsics.checkNotNullParameter(stMediaList, "stMediaList");
        StFeed stFeed = new StFeed();
        a(stFeed);
        c(stFeed, stMediaList, batchNum, this.batchId);
        f(stFeed);
        b(stFeed);
        g(stFeed);
        e(stFeed);
        d(stFeed);
        return stFeed;
    }

    public String toString() {
        return "GroupAlbumUploadAlbumParams(batchId=" + this.batchId + ", clientKey=" + this.clientKey + ", groupId=" + this.groupId + ", albumInfo=" + this.albumInfo + ", localMediaList=" + this.localMediaList + ", uploadTime=" + this.uploadTime + ", curNum=" + this.curNum + ", requestParams=" + this.requestParams + ", taskParams=" + this.taskParams + ")";
    }

    public GroupAlbumUploadAlbumParams(long j3, String clientKey, String groupId, GroupAlbumUploadAlbumInfo albumInfo, String content, ArrayList<MediaWrapper> mediaWrapperList, CopyOnWriteArrayList<CommonAlbumUploadMediaInfo> localMediaList, CommonAlbumUploadPoiInfo commonAlbumUploadPoiInfo, long j16, int i3, int i16, GroupAlbumUploadRequestParams requestParams, GroupAlbumUploadTaskParams taskParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mediaWrapperList, "mediaWrapperList");
        Intrinsics.checkNotNullParameter(localMediaList, "localMediaList");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(taskParams, "taskParams");
        this.batchId = j3;
        this.clientKey = clientKey;
        this.groupId = groupId;
        this.albumInfo = albumInfo;
        this.content = content;
        this.mediaWrapperList = mediaWrapperList;
        this.localMediaList = localMediaList;
        this.poiInfo = commonAlbumUploadPoiInfo;
        this.uploadTime = j16;
        this.curNum = i3;
        this.maxNum = i16;
        this.requestParams = requestParams;
        this.taskParams = taskParams;
    }

    public static /* synthetic */ StFeed toStFeed$default(GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams, List list, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = list.size();
        }
        return groupAlbumUploadAlbumParams.toStFeed(list, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumUploadAlbumParams)) {
            return false;
        }
        GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams = (GroupAlbumUploadAlbumParams) other;
        return this.batchId == groupAlbumUploadAlbumParams.batchId && Intrinsics.areEqual(this.clientKey, groupAlbumUploadAlbumParams.clientKey) && Intrinsics.areEqual(this.groupId, groupAlbumUploadAlbumParams.groupId) && Intrinsics.areEqual(this.albumInfo, groupAlbumUploadAlbumParams.albumInfo) && Intrinsics.areEqual(this.content, groupAlbumUploadAlbumParams.content) && Intrinsics.areEqual(this.mediaWrapperList, groupAlbumUploadAlbumParams.mediaWrapperList) && Intrinsics.areEqual(this.localMediaList, groupAlbumUploadAlbumParams.localMediaList) && Intrinsics.areEqual(this.poiInfo, groupAlbumUploadAlbumParams.poiInfo) && this.uploadTime == groupAlbumUploadAlbumParams.uploadTime && this.curNum == groupAlbumUploadAlbumParams.curNum && this.maxNum == groupAlbumUploadAlbumParams.maxNum && Intrinsics.areEqual(this.requestParams, groupAlbumUploadAlbumParams.requestParams) && Intrinsics.areEqual(this.taskParams, groupAlbumUploadAlbumParams.taskParams);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ GroupAlbumUploadAlbumParams(long j3, String str, String str2, GroupAlbumUploadAlbumInfo groupAlbumUploadAlbumInfo, String str3, ArrayList arrayList, CopyOnWriteArrayList copyOnWriteArrayList, CommonAlbumUploadPoiInfo commonAlbumUploadPoiInfo, long j16, int i3, int i16, GroupAlbumUploadRequestParams groupAlbumUploadRequestParams, GroupAlbumUploadTaskParams groupAlbumUploadTaskParams, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r1, r7, r8, r6, r11, r12, r13, r2, r14, r16, r42, r0);
        GroupAlbumUploadAlbumInfo groupAlbumUploadAlbumInfo2;
        GroupAlbumUploadRequestParams groupAlbumUploadRequestParams2;
        int i18;
        GroupAlbumUploadTaskParams groupAlbumUploadTaskParams2;
        long j17 = (i17 & 1) != 0 ? -1L : j3;
        String str4 = (i17 & 2) != 0 ? "" : str;
        String str5 = (i17 & 4) != 0 ? "" : str2;
        int i19 = 3;
        String str6 = null;
        byte b16 = 0;
        byte b17 = 0;
        if ((i17 & 8) != 0) {
            groupAlbumUploadAlbumInfo2 = new GroupAlbumUploadAlbumInfo(str6, b17 == true ? 1 : 0, i19, b16 == true ? 1 : 0);
        } else {
            groupAlbumUploadAlbumInfo2 = groupAlbumUploadAlbumInfo;
        }
        String str7 = (i17 & 16) == 0 ? str3 : "";
        ArrayList arrayList2 = (i17 & 32) != 0 ? new ArrayList() : arrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = (i17 & 64) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
        CommonAlbumUploadPoiInfo commonAlbumUploadPoiInfo2 = (i17 & 128) != 0 ? null : commonAlbumUploadPoiInfo;
        long j18 = (i17 & 256) == 0 ? j16 : -1L;
        int i26 = (i17 & 512) != 0 ? -1 : i3;
        int i27 = (i17 & 1024) != 0 ? -1 : i16;
        GroupAlbumUploadRequestParams groupAlbumUploadRequestParams3 = (i17 & 2048) != 0 ? new GroupAlbumUploadRequestParams(0, null, 0, null, null, 0, null, 127, null) : groupAlbumUploadRequestParams;
        if ((i17 & 4096) != 0) {
            groupAlbumUploadRequestParams2 = groupAlbumUploadRequestParams3;
            i18 = i27;
            groupAlbumUploadTaskParams2 = new GroupAlbumUploadTaskParams(0, 0, 3, null);
        } else {
            groupAlbumUploadRequestParams2 = groupAlbumUploadRequestParams3;
            i18 = i27;
            groupAlbumUploadTaskParams2 = groupAlbumUploadTaskParams;
        }
    }

    private final void e(StFeed stFeed) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupAlbumUploadAlbumParams(GroupAlbumUploadAlbumDBParams dbParams) {
        this(0L, null, null, null, null, null, null, null, 0L, 0, 0, null, 0 == true ? 1 : 0, InitSkin.DRAWABLE_COUNT, null);
        Intrinsics.checkNotNullParameter(dbParams, "dbParams");
        this.batchId = dbParams.getBatchId();
        this.clientKey = dbParams.getClientKey();
        this.groupId = dbParams.getGroupId();
        this.albumInfo = dbParams.getAlbumInfo();
        this.content = dbParams.getContent();
        this.mediaWrapperList = dbParams.getMediaWrapperList();
        this.localMediaList = new CopyOnWriteArrayList<>(dbParams.getLocalMediaList());
        this.poiInfo = dbParams.getPoiInfo();
        this.uploadTime = dbParams.getUploadTime();
        this.curNum = dbParams.getCurNum();
        this.maxNum = dbParams.getMaxNum();
        this.requestParams = dbParams.getRequestParams();
        this.taskParams = dbParams.getTaskParams();
    }
}
