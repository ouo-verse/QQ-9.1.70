package com.qzone.reborn.groupalbum.task;

import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.business.task.a;
import com.qzone.util.image.c;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.upload.uinterface.AbstractUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\r\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001]BQ\u0012\u0006\u0010Y\u001a\u00020\b\u0012\b\u00105\u001a\u0004\u0018\u00010\f\u0012\u001a\u0010=\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010;j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`<\u0012\u0006\u0010C\u001a\u00020\f\u0012\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00060D\u00a2\u0006\u0004\bZ\u0010[J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u001aH\u0016J$\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0016J<\u0010'\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010$2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020\b2\u0006\u0010&\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0016J \u0010*\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\fH\u0016J\u0012\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J$\u0010/\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\bH\u0016J,\u00100\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0016J\"\u00103\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\b2\u0006\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u00020\fH\u0016R$\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R6\u0010=\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010;j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00106R\"\u0010F\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00060D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010I\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR.\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0Q8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Q8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010S\u00a8\u0006^"}, d2 = {"Lcom/qzone/reborn/groupalbum/task/GroupAlbumPicCommentTask;", "Lcom/qzone/publish/business/task/QZoneQueueTask;", "Lcom/qzone/publish/business/protocol/QzoneMediaUploadRequest$b;", "Lcom/qzone/publish/business/task/a;", "LNS_MOBILE_OPERATION/PicInfo;", "picInfo", "", "appendPicInfo", "", "getCurrentImgIndex", "Lcom/qzone/common/business/result/UploadFileResponse;", "response", "", "path", "imgIndex", "addUploadPhotoResponse", "getCacheKey", "onRun", "Lcom/qzone/common/business/task/QZoneTask;", "task", "onTaskResponse", "Lcom/qzone/publish/business/task/c;", "getInfo", "", "getImageUrls", "getExactType", "", "cancel", QCircleLpReportDc05507.KEY_CLEAR, "", "getFakeSize", "isNullTask", "mediaIndex", "srcPath", "uploadPath", "onMediaUploadStart", "Lcom/qq/taf/jce/JceStruct;", "Lcom/tencent/upload/uinterface/AbstractUploadTask;", "id", "onMediaUploadSuccess", "errCode", "errMsg", "onMediaUploadFailed", "Lcom/qzone/publish/business/model/a$a;", CacheTable.TABLE_NAME, "onMediaUploadReport", "destPath", "onMediaCompressSuccess", "onMediaCompressFailed", "", "progerss", "onMediaCompressProgress", "getCaseId", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "images", "Ljava/util/ArrayList;", "getImages", "()Ljava/util/ArrayList;", "setImages", "(Ljava/util/ArrayList;)V", "commentUniKey", "Lkotlin/Function1;", "LNS_MOBILE_OPERATION/MediaInfo;", "commentAction", "Lkotlin/jvm/functions/Function1;", "step", "I", "mediaInfo", "LNS_MOBILE_OPERATION/MediaInfo;", "curImageIndex", "getCurImageIndex", "()I", "setCurImageIndex", "(I)V", "", "localUrlMap", "Ljava/util/Map;", "getLocalUrlMap", "()Ljava/util/Map;", "setLocalUrlMap", "(Ljava/util/Map;)V", "uploadPicInfoMap", "taskType", "<init>", "(ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumPicCommentTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b, a {
    private static final int STEP_COMMENT = 1;
    private static final int STEP_UPLOAD_PHOTOS = 0;
    private static final String TAG = "[upload2_GroupAlbumPicCommentTask]";
    private Function1<? super MediaInfo, Unit> commentAction;
    private String commentUniKey;

    @NeedParcel
    private int curImageIndex;
    private String groupId;
    private ArrayList<String> images;

    @NeedParcel
    private Map<String, String> localUrlMap;

    @NeedParcel
    private MediaInfo mediaInfo;

    @NeedParcel
    private int step;

    @NeedParcel
    private Map<String, PicInfo> uploadPicInfoMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumPicCommentTask(int i3, String str, ArrayList<String> arrayList, String commentUniKey, Function1<? super MediaInfo, Unit> commentAction) {
        super(i3);
        Intrinsics.checkNotNullParameter(commentUniKey, "commentUniKey");
        Intrinsics.checkNotNullParameter(commentAction, "commentAction");
        this.groupId = str;
        this.images = arrayList;
        this.commentUniKey = commentUniKey;
        this.commentAction = commentAction;
        this.mediaInfo = new MediaInfo();
        this.localUrlMap = new HashMap();
        int i16 = 0;
        if (this.images != null && (!r2.isEmpty())) {
            i16 = 1;
        }
        this.step = i16 ^ 1;
    }

    private final void addUploadPhotoResponse(UploadFileResponse response, String path, int imgIndex) {
        boolean startsWith$default;
        PicInfo picInfo = new PicInfo();
        picInfo.picheight = response.height;
        picInfo.picwidth = response.width;
        picInfo.pictype = response.picType;
        picInfo.albumid = response.albumId;
        picInfo.pictureid = response.photoId;
        picInfo.hdwidth = response.owidth;
        picInfo.hdheight = response.oheight;
        picInfo.sloc = response.slocId;
        picInfo.pic_url = response.url;
        if (this.uploadPicInfoMap == null) {
            this.uploadPicInfoMap = new HashMap();
        }
        if (TextUtils.isEmpty(path)) {
            ArrayList<String> arrayList = this.images;
            if (arrayList != null) {
                Intrinsics.checkNotNull(arrayList);
                if (arrayList.size() > 0) {
                    ArrayList<String> arrayList2 = this.images;
                    Intrinsics.checkNotNull(arrayList2);
                    if (arrayList2.size() > imgIndex) {
                        ArrayList<String> arrayList3 = this.images;
                        Intrinsics.checkNotNull(arrayList3);
                        String str = arrayList3.get(imgIndex);
                        Intrinsics.checkNotNullExpressionValue(str, "images!![imgIndex]");
                        path = str;
                    }
                }
            }
            if (!TextUtils.isEmpty(response.originUploadUrl)) {
                path = response.originUploadUrl;
                Intrinsics.checkNotNullExpressionValue(path, "response.originUploadUrl");
            }
        }
        if (!TextUtils.isEmpty(path)) {
            Map<String, PicInfo> map = this.uploadPicInfoMap;
            Intrinsics.checkNotNull(map);
            map.put(path, picInfo);
        } else {
            QZLog.w(TAG, "addUploadPhotoResponse picPath is null, index:" + imgIndex);
        }
        if (!TextUtils.isEmpty(response.originUploadUrl)) {
            String str2 = response.originUploadUrl;
            Intrinsics.checkNotNullExpressionValue(str2, "response.originUploadUrl");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "file://", false, 2, null);
            if (!startsWith$default) {
                response.originUploadUrl = "file://" + response.originUploadUrl;
            }
            Map<String, String> map2 = this.localUrlMap;
            String str3 = response.clientFakeKey;
            Intrinsics.checkNotNullExpressionValue(str3, "response.clientFakeKey");
            String str4 = response.originUploadUrl;
            Intrinsics.checkNotNullExpressionValue(str4, "response.originUploadUrl");
            map2.put(str3, str4);
        }
        this.curImageIndex = imgIndex;
    }

    /* renamed from: getCurrentImgIndex, reason: from getter */
    private final int getCurImageIndex() {
        return this.curImageIndex;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return false;
        }
        Intrinsics.checkNotNull(qZoneRequest, "null cannot be cast to non-null type com.qzone.publish.business.protocol.QzoneMediaUploadRequest");
        return ((QzoneMediaUploadRequest) qZoneRequest).cancel();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void clear() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return;
        }
        Intrinsics.checkNotNull(qZoneRequest, "null cannot be cast to non-null type com.qzone.publish.business.protocol.QzoneMediaUploadRequest");
        ((QzoneMediaUploadRequest) qZoneRequest).clear();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey, reason: from getter */
    public String getCommentUniKey() {
        return this.commentUniKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getCaseId() {
        String str = this.groupId;
        return str == null ? "" : str;
    }

    public final int getCurImageIndex() {
        return this.curImageIndex;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 13;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    protected long getFakeSize() {
        ArrayList<String> arrayList = this.images;
        if (arrayList == null) {
            return 0L;
        }
        Intrinsics.checkNotNull(arrayList);
        Iterator<String> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += (int) c.y(it.next(), 0);
        }
        return i3;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public List<String> getImageUrls() {
        return this.images;
    }

    public final ArrayList<String> getImages() {
        return this.images;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public com.qzone.publish.business.task.c getInfo() {
        com.qzone.publish.business.task.c info = super.getInfo();
        info.f51185a = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoComment", "\u53d1\u8bc4\u8bba");
        if (getState() == 1) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = (int) ((j3 * 100) / j16);
                    if (this.curImageIndex >= 0) {
                        ArrayList<String> arrayList = this.images;
                        Intrinsics.checkNotNull(arrayList);
                        if (arrayList.size() > 0) {
                            info.f51186b = this.mRecvDataSize + "k/" + this.mTotalSize + "k";
                        }
                    }
                }
            }
        }
        if (getImageUrls() != null) {
            Intrinsics.checkNotNull(getImageUrls());
            if (!r1.isEmpty()) {
                List<String> imageUrls = getImageUrls();
                Intrinsics.checkNotNull(imageUrls);
                int size = imageUrls.size();
                int curImageIndex = getCurImageIndex();
                if (curImageIndex >= 0 && curImageIndex < size) {
                    info.f51194j = size - curImageIndex;
                    List<String> imageUrls2 = getImageUrls();
                    Intrinsics.checkNotNull(imageUrls2);
                    info.f51192h = imageUrls2.get(curImageIndex);
                }
            }
        }
        return info;
    }

    public final Map<String, String> getLocalUrlMap() {
        return this.localUrlMap;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        if (getImageUrls() != null) {
            List<String> imageUrls = getImageUrls();
            Intrinsics.checkNotNull(imageUrls);
            if (!imageUrls.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int mediaIndex, int errCode, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QZLog.i(TAG, "onMediaUploadFailed mediaIndex:" + mediaIndex + ", errCode:" + errCode + ", errMsg:" + errMsg);
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct response, AbstractUploadTask task, int mediaIndex, String id5, String srcPath, String uploadPath) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(uploadPath, "uploadPath");
        if (response == null || mediaIndex < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + mediaIndex + ", id:" + id5 + ", srcPath:" + srcPath + ", uploadPath:" + uploadPath);
        if (response instanceof UploadFileResponse) {
            addUploadPhotoResponse((UploadFileResponse) response, srcPath, mediaIndex);
        }
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        int i3 = this.step;
        if (i3 == 0) {
            RFWLog.d(TAG, RFWLog.USR, "onRun STEP_UPLOAD_PHOTOS");
            com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
            aVar.C(4).d(this.batchId).f(this.clientKey).x(0).c(22).F(33);
            this.mRequest = new QzoneMediaUploadRequest(com.qzone.publish.utils.c.h(this.images), aVar, this, this);
            return;
        }
        if (i3 != 1) {
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "onRun STEP_COMMENT");
        ArrayList<String> arrayList = this.images;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (arrayList.size() > 0) {
                ArrayList<String> arrayList2 = this.images;
                Intrinsics.checkNotNull(arrayList2);
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        Map<String, PicInfo> map = this.uploadPicInfoMap;
                        if (map != null) {
                            Intrinsics.checkNotNull(map);
                            if (map.get(next) != null) {
                                Map<String, PicInfo> map2 = this.uploadPicInfoMap;
                                Intrinsics.checkNotNull(map2);
                                appendPicInfo(map2.get(next));
                            }
                        }
                        RFWLog.w(TAG, RFWLog.USR, "on STEP_COMMENT, image:" + next + " picInfo null");
                    }
                }
            }
        }
        MediaInfo mediaInfo = this.mediaInfo;
        if (mediaInfo != null) {
            this.commentAction.invoke(mediaInfo);
            getPublishQueue().g(this, true);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.step == 0) {
            if (task.succeeded()) {
                RFWLog.d(TAG, RFWLog.USR, "onTaskResponse success STEP_UPLOAD_PHOTOS");
                this.step = 1;
                super.run();
            } else {
                RFWLog.d(TAG, RFWLog.USR, "onTaskResponse fail STEP_UPLOAD_PHOTOS");
                getPublishQueue().g(this, false);
            }
        }
    }

    public final void setCurImageIndex(int i3) {
        this.curImageIndex = i3;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setImages(ArrayList<String> arrayList) {
        this.images = arrayList;
    }

    public final void setLocalUrlMap(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.localUrlMap = map;
    }

    private final void appendPicInfo(PicInfo picInfo) {
        if (picInfo == null) {
            return;
        }
        if (this.mediaInfo == null) {
            this.mediaInfo = new MediaInfo();
        }
        MediaInfo mediaInfo = this.mediaInfo;
        Intrinsics.checkNotNull(mediaInfo);
        if (mediaInfo.picinfolist == null) {
            MediaInfo mediaInfo2 = this.mediaInfo;
            Intrinsics.checkNotNull(mediaInfo2);
            mediaInfo2.picinfolist = new ArrayList<>();
        }
        MediaInfo mediaInfo3 = this.mediaInfo;
        Intrinsics.checkNotNull(mediaInfo3);
        mediaInfo3.picinfolist.add(picInfo);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a reportInfo) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressProgress(String srcPath, int mediaIndex, double progerss) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressSuccess(String srcPath, String destPath, int mediaIndex) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int mediaIndex, String srcPath, String uploadPath) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressFailed(String srcPath, int mediaIndex, int errCode, String errMsg) {
    }
}
