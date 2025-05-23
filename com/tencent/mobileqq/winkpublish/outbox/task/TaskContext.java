package com.tencent.mobileqq.winkpublish.outbox.task;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.msf.core.net.u.c.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkpublish.MediaInfo;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.config.l;
import com.tencent.mobileqq.winkpublish.model.params.ExportParams;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.NetVideoParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.outbox.slot.d;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import com.tencent.mobileqq.winkpublish.result.VideoResult;
import com.tencent.mobileqq.winkpublish.util.f;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.upload.uinterface.AbstractUploadResult;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 B2\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\bz\u0010{J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020\u000f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010(\u001a\u00020\u000f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\"\u0010-\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010,R\"\u00100\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b\u0014\u0010\u001f\"\u0004\b/\u0010,R\"\u00105\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\"\u001a\u0004\b2\u0010$\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\"\u001a\u0004\b7\u0010$\"\u0004\b8\u00104R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020;0:8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020;0:8\u0006\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?R\"\u0010H\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010D\u001a\u0004\bA\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u001d\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010,R\"\u0010O\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u001d\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010,R\"\u0010R\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001d\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010,R\"\u0010S\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010D\u001a\u0004\b6\u0010E\"\u0004\b\"\u0010GR\"\u0010T\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010D\u001a\u0004\b<\u0010E\"\u0004\b\u001d\u0010GR\"\u0010V\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010D\u001a\u0004\b)\u0010E\"\u0004\bU\u0010GR\"\u0010Z\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\"\u001a\u0004\bX\u0010$\"\u0004\bY\u00104R\"\u0010_\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010[\u001a\u0004\b.\u0010\\\"\u0004\b]\u0010^R\"\u0010b\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010[\u001a\u0004\b1\u0010\\\"\u0004\ba\u0010^R\"\u0010e\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010\"\u001a\u0004\b`\u0010$\"\u0004\bd\u00104R\u001b\u0010h\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010f\u001a\u0004\bg\u0010\\R\"\u0010j\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\bL\u0010$\"\u0004\bi\u00104R\u0011\u0010m\u001a\u00020k8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010lR\u0011\u0010n\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010$R\u0011\u0010p\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\bo\u0010\\R\u0011\u0010r\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\bq\u0010\\R\u0011\u0010t\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\bs\u0010\\R\u0011\u0010u\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\bc\u0010$R\u0011\u0010w\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\bv\u0010\\R\u0011\u0010x\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010ER\u0011\u0010y\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bW\u0010E\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "", "Lcom/tencent/upload/uinterface/AbstractUploadResult;", "response", "Lcom/tencent/mobileqq/winkpublish/result/MediaUploadResult;", ExifInterface.LATITUDE_SOUTH, "", "D", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "newParams", "T", "", "toString", "", "hashCode", "other", "", "equals", "a", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "setPublishParams", "(Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;)V", "publishParams", "", "b", "J", "k", "()J", "id", "c", "I", "getUploadTarget", "()I", "uploadTarget", "d", ReportConstant.COSTREPORT_PREFIX, "uploadBusinessType", "e", "w", "setUploadTime", "(J)V", PhotoCategorySinglePicInfo.UPLOAD_TIME, "f", "setBatchId", "batchId", "g", "o", "setSeqId", "(I)V", "seqId", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "O", "state", "", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "i", "Ljava/util/List;", "l", "()Ljava/util/List;", "imageMedias", "j", HippyTKDListViewAdapter.X, "videoMedias", "Ljava/lang/String;", "()Ljava/lang/String;", "K", "(Ljava/lang/String;)V", "feedId", "getFeedTime", "L", "feedTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "N", "startTimeMillis", "getActiveTimeMillis", "E", "activeTimeMillis", "errCode", "errMsg", UserInfo.SEX_FEMALE, "dtCameraSessionId", "r", "v", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "uploadTaskType", "Z", "()Z", "G", "(Z)V", "enableSpeedTest", "t", "H", "enableUWETest", "u", "P", "uploadCoverType", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isOnlyPublishFeed", "M", "judgeResult", "Lcom/tencent/mobileqq/winkpublish/config/l;", "()Lcom/tencent/mobileqq/winkpublish/config/l;", DownloadInfo.spKey_Config, "businessType", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isMixMode", BdhLogUtil.LogTag.Tag_Conn, "isVideoTask", "y", "isImageTask", "uploadMediaCount", "B", "isTruePublish", "clientKey", "traceId", "<init>", "(Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;J)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final /* data */ class TaskContext {

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private WinkPublishParams publishParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int uploadTarget;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int uploadBusinessType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long uploadTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long batchId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int seqId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<UploadMediaInfo> imageMedias;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final List<UploadMediaInfo> videoMedias;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String feedId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long feedTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long startTimeMillis;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long activeTimeMillis;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String errCode;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String errMsg;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String dtCameraSessionId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int uploadTaskType;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean enableSpeedTest;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean enableUWETest;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int uploadCoverType;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final Lazy isOnlyPublishFeed;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int judgeResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0014\u0010\u001e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext$a;", "", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "publishParams", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "e", "d", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "b", "(Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;Ljava/lang/Long;)Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "", "ALREADY_UPLOAD", "I", "ASYNC_UPLOAD", "BUSINESS_TYPE_UPLOAD_PIC", "JUDGE_EXPORT", "JUDGE_ORIGIN", "JUDGE_TIMEOUT", "JUDGE_UNCLEAR", "SHUOSHUO_SRC", "SYNC_UPLOAD", "", "TAG", "Ljava/lang/String;", "TASK_ORIGINAL_UPLOAD", "TASK_VIDEO_EXPORTING_UPLOAD", "TASK_VIDEO_UPLOAD", "UPLOAD_TARGET_SHUOSHUO", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.task.TaskContext$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TaskContext c(Companion companion, WinkPublishParams winkPublishParams, Long l3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                l3 = null;
            }
            return companion.b(winkPublishParams, l3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(WinkPublishParams publishParams, TaskContext taskContext) {
            HashMap<String, String> datongParams = publishParams.getDatongParams();
            if (datongParams != null) {
                WinkDatongCurrentParams.params.putAll(datongParams);
                String str = datongParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID);
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "map[\"xsj_camera_session_id\"] ?: \"\"");
                }
                taskContext.F(str);
            }
        }

        private final void e(WinkPublishParams publishParams, TaskContext taskContext) {
            int i3;
            List<MediaParams> mediaParamsList = publishParams.getMediaParamsList();
            if (mediaParamsList != null) {
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                for (Object obj : mediaParamsList) {
                    int i19 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    MediaParams mediaParams = (MediaParams) obj;
                    if (mediaParams instanceof VideoParams) {
                        QLog.i("WinkPublish-TaskParams", 1, "[prepareUploadMedias] video duration=" + ((VideoParams) mediaParams).getDuration());
                        taskContext.x().add(new UploadMediaInfo(mediaParams, i16, i17, null, null, null, null, 0L, 0L, 0L, 0L, 0L, null, false, 0.0f, false, g.f249461c, null));
                        i17++;
                    } else {
                        if (mediaParams instanceof NetVideoParams) {
                            i3 = i18 + 1;
                            taskContext.x().add(new UploadMediaInfo(mediaParams, i16, i18, null, null, null, null, 0L, 0L, 0L, 0L, 0L, null, false, 0.0f, false, g.f249461c, null));
                        } else if (mediaParams instanceof ImageParams) {
                            i3 = i18 + 1;
                            taskContext.l().add(new UploadMediaInfo(mediaParams, i16, i18, null, null, null, null, 0L, 0L, 0L, 0L, 0L, null, false, 0.0f, false, g.f249461c, null));
                        }
                        i18 = i3;
                    }
                    i16 = i19;
                }
            }
            if (QLog.isColorLevel()) {
                int i26 = 0;
                for (Object obj2 : taskContext.l()) {
                    int i27 = i26 + 1;
                    if (i26 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    QLog.d("WinkPublish-TaskParams", 2, "[prepareUploadMedias] imageMedia, index=" + i26 + ", path=" + ((UploadMediaInfo) obj2).l());
                    i26 = i27;
                }
                int i28 = 0;
                for (Object obj3 : taskContext.x()) {
                    int i29 = i28 + 1;
                    if (i28 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    QLog.d("WinkPublish-TaskParams", 2, "[prepareUploadMedias] videoMedia, index=" + i28 + ", path=" + ((UploadMediaInfo) obj3).l());
                    i28 = i29;
                }
            }
        }

        public final TaskContext b(WinkPublishParams publishParams, Long taskId) {
            long nanoTime;
            Intrinsics.checkNotNullParameter(publishParams, "publishParams");
            if (taskId != null) {
                nanoTime = taskId.longValue();
            } else {
                nanoTime = System.nanoTime();
            }
            TaskContext taskContext = new TaskContext(publishParams, nanoTime);
            ExportParams exportParams = publishParams.getExportParams();
            taskContext.G(exportParams != null ? exportParams.getEnableSpeedTest() : false);
            taskContext.H(publishParams.getExportParams() != null);
            d(publishParams, taskContext);
            e(publishParams, taskContext);
            return taskContext;
        }

        Companion() {
        }
    }

    public TaskContext(WinkPublishParams publishParams, long j3) {
        Intrinsics.checkNotNullParameter(publishParams, "publishParams");
        this.publishParams = publishParams;
        this.id = j3;
        this.uploadTarget = 4;
        this.uploadTime = f.a() / 1000;
        this.batchId = com.tencent.mobileqq.winkpublish.util.a.a();
        this.state = -1000;
        this.imageMedias = new ArrayList();
        this.videoMedias = new ArrayList();
        this.feedId = "";
        this.errCode = "";
        this.errMsg = "";
        this.dtCameraSessionId = "";
        this.uploadTaskType = 2;
        this.uploadCoverType = 1;
        this.isOnlyPublishFeed = LazyKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.winkpublish.outbox.task.TaskContext$isOnlyPublishFeed$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Parcelable parcelable;
                Object orNull;
                boolean z16 = false;
                if (TaskContext.this.getPublishParams().getFeedParams() != null && TaskContext.this.getPublishParams().getExportParams() == null) {
                    List<MediaParams> mediaParamsList = TaskContext.this.getPublishParams().getMediaParamsList();
                    if (mediaParamsList != null) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(mediaParamsList, 0);
                        parcelable = (MediaParams) orNull;
                    } else {
                        parcelable = null;
                    }
                    if ((parcelable instanceof NetVideoParams ? (NetVideoParams) parcelable : null) != null) {
                        z16 = true;
                    }
                }
                return Boolean.valueOf(z16);
            }
        });
        this.judgeResult = -1;
    }

    public final boolean A() {
        return ((Boolean) this.isOnlyPublishFeed.getValue()).booleanValue();
    }

    public final boolean B() {
        return this.publishParams.isTruePublish();
    }

    public final boolean C() {
        return !this.videoMedias.isEmpty();
    }

    public final void D() {
        QLog.i("WinkPublish-TaskParams", 1, "[reset]");
        this.batchId = com.tencent.mobileqq.winkpublish.util.a.a();
        this.uploadTime = f.a() / 1000;
        this.seqId++;
        Iterator<T> it = this.imageMedias.iterator();
        while (it.hasNext()) {
            ((UploadMediaInfo) it.next()).t();
        }
        Iterator<T> it5 = this.videoMedias.iterator();
        while (it5.hasNext()) {
            ((UploadMediaInfo) it5.next()).t();
        }
        this.feedId = "";
        this.feedTime = 0L;
        this.uploadTaskType = 2;
        this.judgeResult = 2;
    }

    public final void E(long j3) {
        this.activeTimeMillis = j3;
    }

    public final void F(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dtCameraSessionId = str;
    }

    public final void G(boolean z16) {
        this.enableSpeedTest = z16;
    }

    public final void H(boolean z16) {
        this.enableUWETest = z16;
    }

    public final void I(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errCode = str;
    }

    public final void J(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errMsg = str;
    }

    public final void K(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void L(long j3) {
        this.feedTime = j3;
    }

    public final void M(int i3) {
        this.judgeResult = i3;
    }

    public final void N(long j3) {
        this.startTimeMillis = j3;
    }

    public final void O(int i3) {
        this.state = i3;
    }

    public final void P(int i3) {
        this.uploadCoverType = i3;
    }

    public final void Q(int i3) {
        this.uploadTaskType = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TaskInfo R() {
        int i3;
        int i16;
        int coerceIn;
        String a16;
        String str;
        long j3;
        List listOf;
        List list;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        long j16;
        String missionId;
        long j17 = this.id;
        int i17 = this.state;
        if (C()) {
            i3 = 2;
        } else {
            i3 = y() ? 1 : 0;
        }
        ExportParams exportParams = this.publishParams.getExportParams();
        String str2 = (exportParams == null || (missionId = exportParams.getMissionId()) == null) ? "" : missionId;
        String clientKey = this.publishParams.getClientKey();
        String traceId = this.publishParams.getTraceId();
        long currentTimeMillis = System.currentTimeMillis() - this.activeTimeMillis;
        int coerceIn2 = C() ? RangesKt.coerceIn((int) (100 * this.videoMedias.get(0).getExportProgress()), 0, 100) : 0;
        if (C()) {
            coerceIn = RangesKt.coerceIn((int) (100 * this.videoMedias.get(0).o()), 0, 100);
        } else if (y()) {
            float size = this.imageMedias.size() * 1.0f;
            Iterator<T> it = this.imageMedias.iterator();
            float f16 = 0.0f;
            while (it.hasNext()) {
                f16 += ((UploadMediaInfo) it.next()).o();
            }
            coerceIn = RangesKt.coerceIn((int) ((f16 * 100.0f) / size), 0, 100);
            if (QLog.isColorLevel()) {
                QLog.d("WinkPublish-TaskParams", 2, "[transform2Info] progress=" + coerceIn);
            }
        } else {
            i16 = 0;
            if (C()) {
                a16 = y() ? this.imageMedias.get(0).a() : GlobalUtil.DEF_STRING;
            } else {
                a16 = this.videoMedias.get(0).a();
            }
            String str3 = a16;
            boolean isTruePublish = this.publishParams.isTruePublish();
            int b16 = b();
            String str4 = this.feedId;
            int i18 = i16;
            long j18 = this.feedTime;
            if (!C()) {
                List<UploadMediaInfo> list2 = this.videoMedias;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                Iterator it5 = list2.iterator();
                while (it5.hasNext()) {
                    UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) it5.next();
                    Iterator it6 = it5;
                    MediaUploadResult S = S(uploadMediaInfo.getUploadResponse());
                    String str5 = str4;
                    VideoResult videoResult = S instanceof VideoResult ? (VideoResult) S : null;
                    if (videoResult == null) {
                        j16 = j18;
                    } else {
                        MediaUploadResult S2 = S(uploadMediaInfo.getCoverUploadResponse());
                        j16 = j18;
                        videoResult.setCoverResult(S2 instanceof ImageResult ? (ImageResult) S2 : null);
                    }
                    arrayList.add(new MediaInfo(uploadMediaInfo.l(), videoResult));
                    it5 = it6;
                    str4 = str5;
                    j18 = j16;
                }
                str = str4;
                j3 = j18;
                list = arrayList;
            } else {
                str = str4;
                j3 = j18;
                if (!y()) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(new MediaInfo("", null));
                    list = listOf;
                } else {
                    List<UploadMediaInfo> list3 = this.imageMedias;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    for (UploadMediaInfo uploadMediaInfo2 : list3) {
                        arrayList2.add(new MediaInfo(uploadMediaInfo2.l(), S(uploadMediaInfo2.getUploadResponse())));
                    }
                    list = arrayList2;
                }
            }
            return new TaskInfo(j17, i17, i3, str2, clientKey, traceId, currentTimeMillis, i18, str3, isTruePublish, b16, str, j3, list, this.errCode, this.errMsg, this.publishParams.getTransParams(), coerceIn2);
        }
        i16 = coerceIn;
        if (C()) {
        }
        String str32 = a16;
        boolean isTruePublish2 = this.publishParams.isTruePublish();
        int b162 = b();
        String str42 = this.feedId;
        int i182 = i16;
        long j182 = this.feedTime;
        if (!C()) {
        }
        return new TaskInfo(j17, i17, i3, str2, clientKey, traceId, currentTimeMillis, i182, str32, isTruePublish2, b162, str, j3, list, this.errCode, this.errMsg, this.publishParams.getTransParams(), coerceIn2);
    }

    public final void T(WinkPublishParams newParams) {
        MediaParams mediaParams;
        MediaParams mediaParams2;
        boolean z16;
        Object firstOrNull;
        String str;
        Object firstOrNull2;
        Object firstOrNull3;
        Intrinsics.checkNotNullParameter(newParams, "newParams");
        List<MediaParams> mediaParamsList = this.publishParams.getMediaParamsList();
        if (mediaParamsList != null) {
            firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mediaParamsList);
            mediaParams = (MediaParams) firstOrNull3;
        } else {
            mediaParams = null;
        }
        VideoParams videoParams = mediaParams instanceof VideoParams ? (VideoParams) mediaParams : null;
        List<MediaParams> mediaParamsList2 = newParams.getMediaParamsList();
        if (mediaParamsList2 != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mediaParamsList2);
            mediaParams2 = (MediaParams) firstOrNull2;
        } else {
            mediaParams2 = null;
        }
        VideoParams videoParams2 = mediaParams2 instanceof VideoParams ? (VideoParams) mediaParams2 : null;
        if (Intrinsics.areEqual(videoParams != null ? videoParams.getCoverPath() : null, videoParams2 != null ? videoParams2.getCoverPath() : null)) {
            z16 = false;
        } else {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.videoMedias);
            UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) firstOrNull;
            if (uploadMediaInfo != null) {
                uploadMediaInfo.A(true);
                VideoParams r16 = uploadMediaInfo.r();
                if (r16 != null) {
                    if (videoParams2 == null || (str = videoParams2.getCoverPath()) == null) {
                        str = "";
                    }
                    r16.setCoverPath(str);
                }
            }
            z16 = true;
        }
        ExportParams exportParams = newParams.getExportParams();
        Integer valueOf = exportParams != null ? Integer.valueOf(exportParams.getResolutionLevel()) : null;
        QLog.i("WinkPublish-TaskParams", 1, "[update] resolutionLevel=" + valueOf + ", hasChangeCover=" + z16 + ", isTruePublish=" + newParams.isTruePublish());
        if (!Intrinsics.areEqual(this.publishParams.getExportParams(), newParams.getExportParams())) {
            for (UploadMediaInfo uploadMediaInfo2 : this.videoMedias) {
                if (QLog.isColorLevel()) {
                    QLog.d("WinkPublish-TaskParams", 2, "[update] reExport must cancel upload");
                }
                AbstractUploadTask uploadTask = uploadMediaInfo2.getUploadTask();
                if (uploadTask != null) {
                    uploadTask.cancel();
                }
                AbstractUploadTask coverUploadTask = uploadMediaInfo2.getCoverUploadTask();
                if (coverUploadTask != null) {
                    coverUploadTask.cancel();
                }
                uploadMediaInfo2.F(null);
                uploadMediaInfo2.w(null);
                uploadMediaInfo2.D(0L);
            }
            for (UploadMediaInfo uploadMediaInfo3 : this.imageMedias) {
                AbstractUploadTask uploadTask2 = uploadMediaInfo3.getUploadTask();
                if (uploadTask2 != null) {
                    uploadTask2.cancel();
                }
                uploadMediaInfo3.F(null);
                uploadMediaInfo3.D(0L);
            }
        }
        this.publishParams = newParams;
        INSTANCE.d(newParams, this);
    }

    /* renamed from: a, reason: from getter */
    public final long getBatchId() {
        return this.batchId;
    }

    public final int b() {
        return this.publishParams.getBusinessType();
    }

    public final String c() {
        return this.publishParams.getClientKey();
    }

    public final l d() {
        return l.INSTANCE.a(b());
    }

    /* renamed from: e, reason: from getter */
    public final String getDtCameraSessionId() {
        return this.dtCameraSessionId;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getEnableSpeedTest() {
        return this.enableSpeedTest;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getEnableUWETest() {
        return this.enableUWETest;
    }

    /* renamed from: h, reason: from getter */
    public final String getErrCode() {
        return this.errCode;
    }

    public int hashCode() {
        return (this.publishParams.hashCode() * 31) + d.a(this.id);
    }

    /* renamed from: i, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: j, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: k, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<UploadMediaInfo> l() {
        return this.imageMedias;
    }

    /* renamed from: m, reason: from getter */
    public final int getJudgeResult() {
        return this.judgeResult;
    }

    /* renamed from: n, reason: from getter */
    public final WinkPublishParams getPublishParams() {
        return this.publishParams;
    }

    /* renamed from: o, reason: from getter */
    public final int getSeqId() {
        return this.seqId;
    }

    /* renamed from: p, reason: from getter */
    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    /* renamed from: q, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public final String r() {
        return this.publishParams.getTraceId();
    }

    /* renamed from: s, reason: from getter */
    public final int getUploadBusinessType() {
        return this.uploadBusinessType;
    }

    /* renamed from: t, reason: from getter */
    public final int getUploadCoverType() {
        return this.uploadCoverType;
    }

    public String toString() {
        return "TaskContext(publishParams=" + this.publishParams + ", id=" + this.id + ")";
    }

    public final int u() {
        return this.videoMedias.size() + this.imageMedias.size();
    }

    /* renamed from: v, reason: from getter */
    public final int getUploadTaskType() {
        return this.uploadTaskType;
    }

    /* renamed from: w, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final List<UploadMediaInfo> x() {
        return this.videoMedias;
    }

    public final boolean y() {
        return this.videoMedias.isEmpty() && (this.imageMedias.isEmpty() ^ true);
    }

    public final boolean z() {
        return this.videoMedias.size() > 0 && this.imageMedias.size() > 0;
    }

    private final MediaUploadResult S(AbstractUploadResult response) {
        ImageResult imageResult = null;
        byte b16 = 0;
        if (response == null) {
            return null;
        }
        if (response instanceof VideoUploadResult) {
            String str = ((VideoUploadResult) response).sVid;
            Intrinsics.checkNotNullExpressionValue(str, "response.sVid");
            return new VideoResult(str, imageResult, 2, b16 == true ? 1 : 0);
        }
        if (!(response instanceof ImageUploadResult)) {
            return null;
        }
        ImageUploadResult imageUploadResult = (ImageUploadResult) response;
        String sSURL = imageUploadResult.sSURL;
        String sBURL = imageUploadResult.sBURL;
        int i3 = imageUploadResult.iWidth;
        int i16 = imageUploadResult.iHeight;
        String sOriUrl = imageUploadResult.sOriUrl;
        int i17 = imageUploadResult.iOriWidth;
        int i18 = imageUploadResult.iOriHeight;
        String sPhotoMD5 = imageUploadResult.sPhotoMD5;
        Intrinsics.checkNotNullExpressionValue(sSURL, "sSURL");
        Intrinsics.checkNotNullExpressionValue(sBURL, "sBURL");
        Intrinsics.checkNotNullExpressionValue(sOriUrl, "sOriUrl");
        Intrinsics.checkNotNullExpressionValue(sPhotoMD5, "sPhotoMD5");
        return new ImageResult(sSURL, sBURL, sOriUrl, i3, i16, i17, i18, sPhotoMD5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskContext)) {
            return false;
        }
        TaskContext taskContext = (TaskContext) other;
        return Intrinsics.areEqual(this.publishParams, taskContext.publishParams) && this.id == taskContext.id;
    }
}
