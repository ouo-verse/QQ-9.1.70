package com.qzone.publish.business.model.intimate;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.n;
import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneBaseMeta$StFeedCellCommon;
import qzone.QZoneBaseMeta$StFeedCellMedia;
import qzone.QZoneBaseMeta$StFeedCellSpaceInfo;
import qzone.QZoneBaseMeta$StFeedCellSummary;
import qzone.QZoneBaseMeta$StFeedCellUserInfo;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StRichMsg;
import qzone.QZoneBaseMeta$StUser;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b;\b\u0086\b\u0018\u0000 t2\u00020\u0001:\u0001\u000eB\u00a1\u0001\u0012\b\b\u0002\u0010+\u001a\u00020\u0014\u0012\b\b\u0002\u0010,\u001a\u00020\u000f\u0012\b\b\u0002\u0010-\u001a\u00020\u000f\u0012\b\b\u0002\u0010.\u001a\u00020\u0018\u0012\b\b\u0002\u0010/\u001a\u00020\u000f\u0012\u0018\b\u0002\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u00103\u001a\u00020\u0014\u0012\b\b\u0002\u00104\u001a\u00020\u000b\u0012\b\b\u0002\u00105\u001a\u00020\u000b\u0012\b\b\u0002\u00106\u001a\u00020'\u0012\b\b\u0002\u00107\u001a\u00020)\u00a2\u0006\u0004\br\u0010sJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\u0003*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\f\u0010\u000e\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011J\u001e\u0010\u0013\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\t\u0010\u0015\u001a\u00020\u0014H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0018H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u000fH\u00c6\u0003J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dH\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\"H\u00c6\u0003J\t\u0010$\u001a\u00020\u0014H\u00c6\u0003J\t\u0010%\u001a\u00020\u000bH\u00c6\u0003J\t\u0010&\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020'H\u00c6\u0003J\t\u0010*\u001a\u00020)H\u00c6\u0003J\u00a3\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010+\u001a\u00020\u00142\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u00020\u000f2\u0018\b\u0002\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"2\b\b\u0002\u00103\u001a\u00020\u00142\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020'2\b\b\u0002\u00107\u001a\u00020)H\u00c6\u0001J\t\u00109\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010<\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010:H\u00d6\u0003R\"\u0010+\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010,\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010-\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010B\u001a\u0004\bG\u0010D\"\u0004\bH\u0010FR\"\u0010.\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010/\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010B\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR2\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u00102\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u00103\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010=\u001a\u0004\b_\u0010?\"\u0004\b`\u0010AR\"\u00104\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010a\u001a\u0004\bf\u0010c\"\u0004\bg\u0010eR\"\u00106\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u00107\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q\u00a8\u0006u"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "Ljava/io/Serializable;", "Lqzone/QZoneBaseMeta$StFeed;", "", "d", "f", "b", "e", "", "Lqzone/QZoneBaseMeta$StMedia;", "stMediaList", "", "batchNum", "c", "a", "", "toString", "", "isEmpty", "toStFeed", "", "component1", "component2", "component3", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo;", "component4", "component5", "Ljava/util/ArrayList;", "Lcom/qzone/publish/ui/model/MediaWrapper;", "Lkotlin/collections/ArrayList;", "component6", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaInfo;", "component7", "Lcom/qzone/publish/business/model/intimate/IntimateUploadPoiInfo;", "component8", "component9", "component10", "component11", "Lcom/qzone/publish/business/model/intimate/IntimateUploadRequestParams;", "component12", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskParams;", "component13", "batchId", "clientKey", "spaceId", "albumInfo", "content", "mediaWrapperList", "localMediaList", "poiInfo", PhotoCategorySinglePicInfo.UPLOAD_TIME, "curNum", "maxNum", "requestParams", "taskParams", "copy", "hashCode", "", "other", "equals", "J", "getBatchId", "()J", "setBatchId", "(J)V", "Ljava/lang/String;", "getClientKey", "()Ljava/lang/String;", "setClientKey", "(Ljava/lang/String;)V", "getSpaceId", "setSpaceId", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo;)V", "getContent", "setContent", "Ljava/util/ArrayList;", "getMediaWrapperList", "()Ljava/util/ArrayList;", "setMediaWrapperList", "(Ljava/util/ArrayList;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getLocalMediaList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setLocalMediaList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "Lcom/qzone/publish/business/model/intimate/IntimateUploadPoiInfo;", "getPoiInfo", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadPoiInfo;", "setPoiInfo", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadPoiInfo;)V", "getUploadTime", "setUploadTime", "I", "getCurNum", "()I", "setCurNum", "(I)V", "getMaxNum", "setMaxNum", "Lcom/qzone/publish/business/model/intimate/IntimateUploadRequestParams;", "getRequestParams", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadRequestParams;", "setRequestParams", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadRequestParams;)V", "Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskParams;", "getTaskParams", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskParams;", "setTaskParams", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskParams;)V", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumInfo;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/concurrent/CopyOnWriteArrayList;Lcom/qzone/publish/business/model/intimate/IntimateUploadPoiInfo;JIILcom/qzone/publish/business/model/intimate/IntimateUploadRequestParams;Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskParams;)V", "Companion", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class IntimateUploadAlbumParams implements Serializable {
    private static final long serialVersionUID = 1948538260691651086L;
    private IntimateUploadAlbumInfo albumInfo;
    private long batchId;
    private String clientKey;
    private String content;
    private int curNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private transient ArrayList<MediaWrapper> mediaWrapperList;
    private CopyOnWriteArrayList<IntimateUploadMediaInfo> localMediaList;
    private int maxNum;
    private IntimateUploadPoiInfo poiInfo;
    private IntimateUploadRequestParams requestParams;
    private String spaceId;
    private IntimateUploadTaskParams taskParams;
    private long uploadTime;

    public IntimateUploadAlbumParams() {
        this(0L, null, null, null, null, null, null, null, 0L, 0, 0, null, null, InitSkin.DRAWABLE_COUNT, null);
    }

    private final void a(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed) {
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon = qZoneBaseMeta$StFeed.cell_common;
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon2 = new QZoneBaseMeta$StFeedCellCommon();
        qZoneBaseMeta$StFeedCellCommon2.app_id.set(2);
        qZoneBaseMeta$StFeedCellCommon2.biz_id.set(2);
        qZoneBaseMeta$StFeedCellCommon2.time.set(this.uploadTime);
        qZoneBaseMeta$StFeedCellCommon2.client_key.set(this.clientKey);
        qZoneBaseMeta$StFeedCellCommon.set(qZoneBaseMeta$StFeedCellCommon2);
    }

    private final void b(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed) {
        IntimateUploadPoiInfo intimateUploadPoiInfo = this.poiInfo;
        if (intimateUploadPoiInfo != null) {
            qZoneBaseMeta$StFeed.cell_lbs.set(intimateUploadPoiInfo.toStFeedCellLBS());
        }
    }

    private final void c(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed, List<QZoneBaseMeta$StMedia> list, int i3) {
        QZoneBaseMeta$StFeedCellMedia qZoneBaseMeta$StFeedCellMedia = qZoneBaseMeta$StFeed.cell_media;
        QZoneBaseMeta$StFeedCellMedia qZoneBaseMeta$StFeedCellMedia2 = new QZoneBaseMeta$StFeedCellMedia();
        qZoneBaseMeta$StFeedCellMedia2.album_name.set(this.albumInfo.getAlbumName());
        qZoneBaseMeta$StFeedCellMedia2.album_id.set(this.albumInfo.getAlbumId());
        qZoneBaseMeta$StFeedCellMedia2.upload_num.set(i3);
        qZoneBaseMeta$StFeedCellMedia2.batch_id.set(this.batchId);
        qZoneBaseMeta$StFeedCellMedia2.media_items.set(list);
        qZoneBaseMeta$StFeedCellMedia.set(qZoneBaseMeta$StFeedCellMedia2);
    }

    private final void d(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed) {
        QZoneBaseMeta$StFeedCellSpaceInfo qZoneBaseMeta$StFeedCellSpaceInfo = qZoneBaseMeta$StFeed.cell_space_info;
        QZoneBaseMeta$StFeedCellSpaceInfo qZoneBaseMeta$StFeedCellSpaceInfo2 = new QZoneBaseMeta$StFeedCellSpaceInfo();
        qZoneBaseMeta$StFeedCellSpaceInfo2.space_id.set(this.spaceId);
        qZoneBaseMeta$StFeedCellSpaceInfo.set(qZoneBaseMeta$StFeedCellSpaceInfo2);
    }

    private final void e(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed) {
        List<QZoneBaseMeta$StRichMsg> listOf;
        QZoneBaseMeta$StFeedCellSummary qZoneBaseMeta$StFeedCellSummary = qZoneBaseMeta$StFeed.cell_summary;
        QZoneBaseMeta$StFeedCellSummary qZoneBaseMeta$StFeedCellSummary2 = new QZoneBaseMeta$StFeedCellSummary();
        QZoneBaseMeta$StRichMsg qZoneBaseMeta$StRichMsg = new QZoneBaseMeta$StRichMsg();
        qZoneBaseMeta$StRichMsg.type.set(0);
        qZoneBaseMeta$StRichMsg.content.set(this.content);
        PBRepeatMessageField<QZoneBaseMeta$StRichMsg> pBRepeatMessageField = qZoneBaseMeta$StFeedCellSummary2.summary;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(qZoneBaseMeta$StRichMsg);
        pBRepeatMessageField.set(listOf);
        qZoneBaseMeta$StFeedCellSummary.set(qZoneBaseMeta$StFeedCellSummary2);
    }

    private final void f(QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed) {
        QZoneBaseMeta$StFeedCellUserInfo qZoneBaseMeta$StFeedCellUserInfo = qZoneBaseMeta$StFeed.cell_user_info;
        QZoneBaseMeta$StFeedCellUserInfo qZoneBaseMeta$StFeedCellUserInfo2 = new QZoneBaseMeta$StFeedCellUserInfo();
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = qZoneBaseMeta$StFeedCellUserInfo2.user;
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser2 = new QZoneBaseMeta$StUser();
        String nickName = LoginData.getInstance().getNickName(null);
        if (nickName == null) {
            RFWLog.e("StFeed", RFWLog.USR, "[fillCellUserInfo] nickName is null");
            nickName = "";
        }
        qZoneBaseMeta$StUser2.uid.set(LoginData.getInstance().getUid());
        qZoneBaseMeta$StUser2.nick.set(nickName);
        qZoneBaseMeta$StUser.set(qZoneBaseMeta$StUser2);
        qZoneBaseMeta$StFeedCellUserInfo.set(qZoneBaseMeta$StFeedCellUserInfo2);
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
    public final IntimateUploadRequestParams getRequestParams() {
        return this.requestParams;
    }

    /* renamed from: component13, reason: from getter */
    public final IntimateUploadTaskParams getTaskParams() {
        return this.taskParams;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientKey() {
        return this.clientKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: component4, reason: from getter */
    public final IntimateUploadAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ArrayList<MediaWrapper> component6() {
        return this.mediaWrapperList;
    }

    public final CopyOnWriteArrayList<IntimateUploadMediaInfo> component7() {
        return this.localMediaList;
    }

    /* renamed from: component8, reason: from getter */
    public final IntimateUploadPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    /* renamed from: component9, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final IntimateUploadAlbumParams copy(long batchId, String clientKey, String spaceId, IntimateUploadAlbumInfo albumInfo, String content, ArrayList<MediaWrapper> mediaWrapperList, CopyOnWriteArrayList<IntimateUploadMediaInfo> localMediaList, IntimateUploadPoiInfo poiInfo, long uploadTime, int curNum, int maxNum, IntimateUploadRequestParams requestParams, IntimateUploadTaskParams taskParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mediaWrapperList, "mediaWrapperList");
        Intrinsics.checkNotNullParameter(localMediaList, "localMediaList");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(taskParams, "taskParams");
        return new IntimateUploadAlbumParams(batchId, clientKey, spaceId, albumInfo, content, mediaWrapperList, localMediaList, poiInfo, uploadTime, curNum, maxNum, requestParams, taskParams);
    }

    public final IntimateUploadAlbumInfo getAlbumInfo() {
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

    public final CopyOnWriteArrayList<IntimateUploadMediaInfo> getLocalMediaList() {
        return this.localMediaList;
    }

    public final int getMaxNum() {
        return this.maxNum;
    }

    public final ArrayList<MediaWrapper> getMediaWrapperList() {
        return this.mediaWrapperList;
    }

    public final IntimateUploadPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    public final IntimateUploadRequestParams getRequestParams() {
        return this.requestParams;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final IntimateUploadTaskParams getTaskParams() {
        return this.taskParams;
    }

    public final long getUploadTime() {
        return this.uploadTime;
    }

    public int hashCode() {
        int a16 = ((((((((((((n.a(this.batchId) * 31) + this.clientKey.hashCode()) * 31) + this.spaceId.hashCode()) * 31) + this.albumInfo.hashCode()) * 31) + this.content.hashCode()) * 31) + this.mediaWrapperList.hashCode()) * 31) + this.localMediaList.hashCode()) * 31;
        IntimateUploadPoiInfo intimateUploadPoiInfo = this.poiInfo;
        return ((((((((((a16 + (intimateUploadPoiInfo == null ? 0 : intimateUploadPoiInfo.hashCode())) * 31) + n.a(this.uploadTime)) * 31) + this.curNum) * 31) + this.maxNum) * 31) + this.requestParams.hashCode()) * 31) + this.taskParams.hashCode();
    }

    public final boolean isEmpty() {
        return Intrinsics.areEqual(new IntimateUploadAlbumParams(0L, null, null, null, null, null, null, null, 0L, 0, 0, null, null, InitSkin.DRAWABLE_COUNT, null), this);
    }

    public final void setAlbumInfo(IntimateUploadAlbumInfo intimateUploadAlbumInfo) {
        Intrinsics.checkNotNullParameter(intimateUploadAlbumInfo, "<set-?>");
        this.albumInfo = intimateUploadAlbumInfo;
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

    public final void setLocalMediaList(CopyOnWriteArrayList<IntimateUploadMediaInfo> copyOnWriteArrayList) {
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

    public final void setPoiInfo(IntimateUploadPoiInfo intimateUploadPoiInfo) {
        this.poiInfo = intimateUploadPoiInfo;
    }

    public final void setRequestParams(IntimateUploadRequestParams intimateUploadRequestParams) {
        Intrinsics.checkNotNullParameter(intimateUploadRequestParams, "<set-?>");
        this.requestParams = intimateUploadRequestParams;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void setTaskParams(IntimateUploadTaskParams intimateUploadTaskParams) {
        Intrinsics.checkNotNullParameter(intimateUploadTaskParams, "<set-?>");
        this.taskParams = intimateUploadTaskParams;
    }

    public final void setUploadTime(long j3) {
        this.uploadTime = j3;
    }

    public final QZoneBaseMeta$StFeed toStFeed(List<QZoneBaseMeta$StMedia> stMediaList, int batchNum) {
        Intrinsics.checkNotNullParameter(stMediaList, "stMediaList");
        QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = new QZoneBaseMeta$StFeed();
        a(qZoneBaseMeta$StFeed);
        c(qZoneBaseMeta$StFeed, stMediaList, batchNum);
        e(qZoneBaseMeta$StFeed);
        b(qZoneBaseMeta$StFeed);
        f(qZoneBaseMeta$StFeed);
        d(qZoneBaseMeta$StFeed);
        return qZoneBaseMeta$StFeed;
    }

    public String toString() {
        return "IntimateUploadAlbumParams(batchId=" + this.batchId + ", clientKey=" + this.clientKey + ", spaceId=" + this.spaceId + ", albumInfo=" + this.albumInfo + ", content=" + this.content + ", localMediaList=" + this.localMediaList + ", poiInfo=" + this.poiInfo + ", uploadTime=" + this.uploadTime + ", curNum=" + this.curNum + ", requestParams=" + this.requestParams + ", taskParams=" + this.taskParams + ")";
    }

    public IntimateUploadAlbumParams(long j3, String clientKey, String spaceId, IntimateUploadAlbumInfo albumInfo, String content, ArrayList<MediaWrapper> mediaWrapperList, CopyOnWriteArrayList<IntimateUploadMediaInfo> localMediaList, IntimateUploadPoiInfo intimateUploadPoiInfo, long j16, int i3, int i16, IntimateUploadRequestParams requestParams, IntimateUploadTaskParams taskParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mediaWrapperList, "mediaWrapperList");
        Intrinsics.checkNotNullParameter(localMediaList, "localMediaList");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(taskParams, "taskParams");
        this.batchId = j3;
        this.clientKey = clientKey;
        this.spaceId = spaceId;
        this.albumInfo = albumInfo;
        this.content = content;
        this.mediaWrapperList = mediaWrapperList;
        this.localMediaList = localMediaList;
        this.poiInfo = intimateUploadPoiInfo;
        this.uploadTime = j16;
        this.curNum = i3;
        this.maxNum = i16;
        this.requestParams = requestParams;
        this.taskParams = taskParams;
    }

    public static /* synthetic */ QZoneBaseMeta$StFeed toStFeed$default(IntimateUploadAlbumParams intimateUploadAlbumParams, List list, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = list.size();
        }
        return intimateUploadAlbumParams.toStFeed(list, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateUploadAlbumParams)) {
            return false;
        }
        IntimateUploadAlbumParams intimateUploadAlbumParams = (IntimateUploadAlbumParams) other;
        return this.batchId == intimateUploadAlbumParams.batchId && Intrinsics.areEqual(this.clientKey, intimateUploadAlbumParams.clientKey) && Intrinsics.areEqual(this.spaceId, intimateUploadAlbumParams.spaceId) && Intrinsics.areEqual(this.albumInfo, intimateUploadAlbumParams.albumInfo) && Intrinsics.areEqual(this.content, intimateUploadAlbumParams.content) && Intrinsics.areEqual(this.mediaWrapperList, intimateUploadAlbumParams.mediaWrapperList) && Intrinsics.areEqual(this.localMediaList, intimateUploadAlbumParams.localMediaList) && Intrinsics.areEqual(this.poiInfo, intimateUploadAlbumParams.poiInfo) && this.uploadTime == intimateUploadAlbumParams.uploadTime && this.curNum == intimateUploadAlbumParams.curNum && this.maxNum == intimateUploadAlbumParams.maxNum && Intrinsics.areEqual(this.requestParams, intimateUploadAlbumParams.requestParams) && Intrinsics.areEqual(this.taskParams, intimateUploadAlbumParams.taskParams);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ IntimateUploadAlbumParams(long j3, String str, String str2, IntimateUploadAlbumInfo intimateUploadAlbumInfo, String str3, ArrayList arrayList, CopyOnWriteArrayList copyOnWriteArrayList, IntimateUploadPoiInfo intimateUploadPoiInfo, long j16, int i3, int i16, IntimateUploadRequestParams intimateUploadRequestParams, IntimateUploadTaskParams intimateUploadTaskParams, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r1, r7, r8, r6, r11, r12, r13, r2, r14, r16, r42, r0);
        IntimateUploadRequestParams intimateUploadRequestParams2;
        int i18;
        IntimateUploadTaskParams intimateUploadTaskParams2;
        long j17 = (i17 & 1) != 0 ? -1L : j3;
        String str4 = (i17 & 2) != 0 ? "" : str;
        String str5 = (i17 & 4) != 0 ? "" : str2;
        IntimateUploadAlbumInfo intimateUploadAlbumInfo2 = (i17 & 8) != 0 ? new IntimateUploadAlbumInfo(null, null, 3, null) : intimateUploadAlbumInfo;
        String str6 = (i17 & 16) == 0 ? str3 : "";
        ArrayList arrayList2 = (i17 & 32) != 0 ? new ArrayList() : arrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = (i17 & 64) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
        IntimateUploadPoiInfo intimateUploadPoiInfo2 = (i17 & 128) != 0 ? null : intimateUploadPoiInfo;
        long j18 = (i17 & 256) == 0 ? j16 : -1L;
        int i19 = (i17 & 512) != 0 ? -1 : i3;
        int i26 = (i17 & 1024) != 0 ? -1 : i16;
        IntimateUploadRequestParams intimateUploadRequestParams3 = (i17 & 2048) != 0 ? new IntimateUploadRequestParams(0, null, 0, null, null, 0, null, 127, null) : intimateUploadRequestParams;
        if ((i17 & 4096) != 0) {
            intimateUploadRequestParams2 = intimateUploadRequestParams3;
            i18 = i26;
            intimateUploadTaskParams2 = new IntimateUploadTaskParams(0, 0, 3, null);
        } else {
            intimateUploadRequestParams2 = intimateUploadRequestParams3;
            i18 = i26;
            intimateUploadTaskParams2 = intimateUploadTaskParams;
        }
    }
}
