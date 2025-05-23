package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetFeedDetailRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.model.DailyInfo;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.mobileqq.winkpublish.fs.request.QCirclePublishFeedRequest;
import com.tencent.mobileqq.winkpublish.model.params.BusinessShareParams;
import com.tencent.mobileqq.winkpublish.model.params.FeedExtraInfo;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.mobileqq.winkpublish.model.params.GpsParams;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.LiteBanner;
import com.tencent.mobileqq.winkpublish.model.params.MaterialParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.MusicParams;
import com.tencent.mobileqq.winkpublish.model.params.NetVideoParams;
import com.tencent.mobileqq.winkpublish.model.params.PoiParams;
import com.tencent.mobileqq.winkpublish.model.params.PromotionPublishParams;
import com.tencent.mobileqq.winkpublish.model.params.SchoolParams;
import com.tencent.mobileqq.winkpublish.model.params.TagParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.exceptions.PublishFeedException;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkpublish.outbox.task.feature.base.IFeatureKt;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.mobileqq.winkpublish.report.PublishFeedErrorCode;
import com.tencent.mobileqq.winkpublish.util.DateUtil;
import com.tencent.mobileqq.winkpublish.util.FSTransUtils;
import com.tencent.mobileqq.winkpublish.util.WinkHostLbsHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.upload.uinterface.AbstractUploadResult;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleTaskReportInfo;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$DailyInfo;
import feedcloud.FeedCloudMeta$FeedSelfDeclaration;
import feedcloud.FeedCloudMeta$RightInfo;
import feedcloud.FeedCloudMeta$RightTagInfo;
import feedcloud.FeedCloudMeta$ShootLBS;
import feedcloud.FeedCloudMeta$SourceInfo;
import feedcloud.FeedCloudMeta$StActivityInfo;
import feedcloud.FeedCloudMeta$StClientInfo;
import feedcloud.FeedCloudMeta$StCommInfo;
import feedcloud.FeedCloudMeta$StEShopGoods;
import feedcloud.FeedCloudMeta$StEShopGoodsInfo;
import feedcloud.FeedCloudMeta$StEShopPlatformInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedAbstract;
import feedcloud.FeedCloudMeta$StFeedAdv;
import feedcloud.FeedCloudMeta$StFeedAppInnnerJumpInfo;
import feedcloud.FeedCloudMeta$StFeedExtraInfo;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StLiteBanner;
import feedcloud.FeedCloudMeta$StMaterialDataNew;
import feedcloud.FeedCloudMeta$StPoiInfoV2;
import feedcloud.FeedCloudMeta$StPost;
import feedcloud.FeedCloudMeta$StRight;
import feedcloud.FeedCloudMeta$StSingleMaterial;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVideo;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import feedcloud.FeedCloudWrite$StPublishFeedRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 62\u00020\u0001:\u0003\u0005\u0089\u0001B\t\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\u001b\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0013J#\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J8\u0010$\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182&\u0010#\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\"H\u0002J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010)H\u0002J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010/\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u00100\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u00103\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u000101H\u0002J\u001a\u00106\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u000104H\u0002J!\u00109\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u00108\u001a\u0004\u0018\u000107H\u0002\u00a2\u0006\u0004\b9\u0010:J \u0010>\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0002J\u001a\u0010A\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010@\u001a\u0004\u0018\u00010?H\u0002J@\u0010G\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010C\u001a\u00020B2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;2\u0006\u0010F\u001a\u00020BH\u0002J\u001a\u0010J\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010I\u001a\u0004\u0018\u00010HH\u0002J\u001a\u0010M\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010L\u001a\u0004\u0018\u00010KH\u0002J\u001a\u0010O\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010N\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010R\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010Q\u001a\u0004\u0018\u00010PH\u0002J \u0010V\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010;2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010;H\u0002J(\u0010[\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tH\u0002J(\u0010]\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\\2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tH\u0002J\u0018\u0010`\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010_\u001a\u00020^H\u0002J\u001e\u0010c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010b\u001a\b\u0012\u0004\u0012\u00020a0;H\u0002J\u001a\u0010f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010e\u001a\u0004\u0018\u00010dH\u0002J\u0010\u0010h\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\tH\u0002J \u0010i\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010j\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010l\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0018\u0010q\u001a\u00020\u00042\u0006\u0010n\u001a\u00020m2\u0006\u0010p\u001a\u00020oH\u0002J\u0018\u0010r\u001a\u00020\u00042\u0006\u0010n\u001a\u00020m2\u0006\u0010X\u001a\u00020\\H\u0002J\b\u0010s\u001a\u00020\tH\u0002J\u0014\u0010v\u001a\u0004\u0018\u00010\t2\b\u0010u\u001a\u0004\u0018\u00010tH\u0002J\u0018\u0010x\u001a\u00020\u00042\u0006\u0010n\u001a\u00020m2\u0006\u0010w\u001a\u00020\tH\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0080\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010[R\u0018\u0010\u0082\u0001\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010[R\u001f\u0010\u0086\u0001\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0012\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/PublishFeedFeat;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/winkpublish/report/PublishFeedErrorCode;", "winkErrorCode", "", "feedId", "", WadlProxyConsts.CREATE_TIME, "requestTraceId", "U", "Lcom/tencent/mobileqq/winkpublish/fs/request/QCirclePublishFeedRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/PublishFeedFeat$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/winkpublish/fs/request/QCirclePublishFeedRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "W", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "X", "l", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "w", "Lcom/tencent/mobileqq/wink/model/DailyInfo;", "dailyParams", "o", "Lcom/tencent/mobileqq/winkpublish/model/params/LiteBanner;", "liteBanner", "H", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extInfo", "u", "y", "activityItemValue", DomainData.DOMAIN_NAME, "stFeed", "Landroid/os/Bundle;", "transParams", "K", "advJobId", ReportConstant.COSTREPORT_PREFIX, ZPlanPublishSource.FROM_SCHEME, "B", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/winkpublish/model/params/PromotionPublishParams;", "promotionParams", "J", "Lcom/tencent/mobileqq/winkpublish/model/params/SchoolParams;", "schoolParams", BdhLogUtil.LogTag.Tag_Conn, "", "typeParams", "E", "(Lfeedcloud/FeedCloudMeta$StFeed;Ljava/lang/Integer;)V", "", "Lcom/tencent/mobileqq/winkpublish/model/params/TagParams;", "tagParamsList", "D", "Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams;", "poiParams", HippyTKDListViewAdapter.X, "", "isPublic", "groupId", "uinId", "notAllowDownload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/winkpublish/model/params/BusinessShareParams;", "businessShareParams", "t", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedExtraInfo;", "feedExtraInfo", "v", "declarationId", "p", "Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "declarationParams", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/winkpublish/model/params/MaterialParams;", "materialsList", "Lfeedcloud/FeedCloudMeta$StMaterialDataNew;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/winkpublish/model/params/NetVideoParams;", "videoParams", "vid", "md5", "I", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "N", "Lcom/tencent/upload/uinterface/data/ImageUploadResult;", "response", "L", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "images", "G", "Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams;", "musicParams", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "videoPath", "T", "V", "Y", "retCode", "k", "Lcooperation/qqcircle/report/QCircleTaskReportInfo;", CacheTable.TABLE_NAME, "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "imageParams", UserInfo.SEX_FEMALE, "M", "O", "Lcom/tencent/mobileqq/winkpublish/model/params/GpsParams;", "gpsParams", "P", "path", "r", "e", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "f", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "feedParams", tl.h.F, "checkFeedCount", "i", "publishFeedCount", "Lkotlin/Lazy;", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "()V", "b", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PublishFeedFeat extends com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TaskContext taskContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FeedParams feedParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int checkFeedCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int publishFeedCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy taskId;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n\u00a2\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "isSuccess", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class c<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleGetFeedDetailRequest f327347a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<PublishFeedErrorCode> f327348b;

        /* JADX WARN: Multi-variable type inference failed */
        c(QCircleGetFeedDetailRequest qCircleGetFeedDetailRequest, CancellableContinuation<? super PublishFeedErrorCode> cancellableContinuation) {
            this.f327347a = qCircleGetFeedDetailRequest;
            this.f327348b = cancellableContinuation;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            PublishFeedErrorCode publishFeedErrorCode;
            QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[doCheckFeedDetail][onReceive] isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str + ", traceId: " + this.f327347a.getTraceId());
            FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp = obj instanceof FeedCloudRead$StGetFeedDetailRsp ? (FeedCloudRead$StGetFeedDetailRsp) obj : null;
            if (z16 && j3 == 0) {
                if ((feedCloudRead$StGetFeedDetailRsp != null ? feedCloudRead$StGetFeedDetailRsp.feed : null) != null) {
                    publishFeedErrorCode = new PublishFeedErrorCode(0L, null, 2, null);
                    if (this.f327348b.isActive()) {
                        return;
                    }
                    this.f327348b.resumeWith(Result.m476constructorimpl(publishFeedErrorCode));
                    return;
                }
            }
            publishFeedErrorCode = new PublishFeedErrorCode(j3, str);
            if (this.f327348b.isActive()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n\u00a2\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "req", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "isSuccess", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class d<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCirclePublishFeedRequest f327349a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PublishFeedFeat f327350b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<PublishResponse> f327351c;

        /* JADX WARN: Multi-variable type inference failed */
        d(QCirclePublishFeedRequest qCirclePublishFeedRequest, PublishFeedFeat publishFeedFeat, CancellableContinuation<? super PublishResponse> cancellableContinuation) {
            this.f327349a = qCirclePublishFeedRequest;
            this.f327350b = publishFeedFeat;
            this.f327351c = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String errMsg, Object obj) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            PBUInt64Field pBUInt64Field;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
            PBStringField pBStringField;
            QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[doPublishFeed][onReceive] isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + errMsg + ", traceId: " + this.f327349a.getTraceId());
            TaskContext taskContext = null;
            FeedCloudWrite$StPublishFeedRsp feedCloudWrite$StPublishFeedRsp = obj instanceof FeedCloudWrite$StPublishFeedRsp ? (FeedCloudWrite$StPublishFeedRsp) obj : null;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            String traceId = this.f327349a.getTraceId();
            Intrinsics.checkNotNullExpressionValue(traceId, "request.traceId");
            String str = (feedCloudWrite$StPublishFeedRsp == null || (feedCloudMeta$StFeed2 = feedCloudWrite$StPublishFeedRsp.feed) == null || (pBStringField = feedCloudMeta$StFeed2.f398449id) == null) ? null : pBStringField.get();
            if (str == null) {
                str = "";
            }
            PublishResponse publishResponse = new PublishResponse(z16, j3, errMsg, traceId, str, (feedCloudWrite$StPublishFeedRsp == null || (feedCloudMeta$StFeed = feedCloudWrite$StPublishFeedRsp.feed) == null || (pBUInt64Field = feedCloudMeta$StFeed.createTime) == null) ? 0L : pBUInt64Field.get());
            PublishFeedErrorCode publishFeedErrorCode = new PublishFeedErrorCode(j3, errMsg);
            TaskContext taskContext2 = this.f327350b.taskContext;
            if (taskContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            } else {
                taskContext = taskContext2;
            }
            TaskContext taskContext3 = taskContext;
            com.tencent.mobileqq.winkpublish.outbox.d.a(taskContext3, WinkPublishServiceReporter.P_PUBLISH_ALL_COST, taskContext.r(), String.valueOf(publishFeedErrorCode.transformedCode()), (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "key_publishfeed", (r33 & 32) != 0 ? "" : String.valueOf(this.f327350b.publishFeedCount), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : "key_publishfeed", (r33 & 8192) != 0 ? "" : null);
            String r16 = taskContext.r();
            String valueOf = String.valueOf(publishFeedErrorCode.transformedCode());
            String message = publishFeedErrorCode.getMessage();
            String traceId2 = baseRequest.getTraceId();
            String valueOf2 = String.valueOf(baseRequest.getCurrentSeq());
            String feedId = publishResponse.getFeedId();
            Intrinsics.checkNotNullExpressionValue(traceId2, "traceId");
            com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext3, "E_PUBLISH_FEEDS_RESULT", r16, (r33 & 4) != 0 ? "" : valueOf, (r33 & 8) != 0 ? "" : traceId2, (r33 & 16) != 0 ? "" : valueOf2, (r33 & 32) != 0 ? "" : feedId, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : message, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
            if (this.f327351c.isActive()) {
                this.f327351c.resumeWith(Result.m476constructorimpl(publishResponse));
            }
        }
    }

    private final void A(FeedCloudMeta$StFeed feed, boolean isPublic, List<String> groupId, List<String> uinId, boolean notAllowDownload) {
        FeedCloudMeta$StRight feedCloudMeta$StRight = new FeedCloudMeta$StRight();
        FeedCloudMeta$RightInfo feedCloudMeta$RightInfo = new FeedCloudMeta$RightInfo();
        if (!isPublic) {
            feedCloudMeta$RightInfo.rightFlag.set(2);
        } else {
            List<String> list = groupId;
            if (list == null || list.isEmpty()) {
                List<String> list2 = uinId;
                if (list2 == null || list2.isEmpty()) {
                    feedCloudMeta$RightInfo.rightFlag.set(1);
                }
            }
            feedCloudMeta$RightInfo.rightFlag.set(4);
            if (groupId != null) {
                for (String str : groupId) {
                    ArrayList arrayList = new ArrayList();
                    FeedCloudMeta$RightTagInfo feedCloudMeta$RightTagInfo = new FeedCloudMeta$RightTagInfo();
                    feedCloudMeta$RightTagInfo.tagID.set(str);
                    arrayList.add(feedCloudMeta$RightTagInfo);
                    feedCloudMeta$RightInfo.tagList.set(arrayList);
                }
            }
            if (uinId != null) {
                feedCloudMeta$RightInfo.uinList.set(uinId);
            }
        }
        feedCloudMeta$StRight.notAllowDownLoad.set(notAllowDownload);
        feedCloudMeta$StRight.ugcRight.set(feedCloudMeta$RightInfo);
        feed.right.set(feedCloudMeta$StRight);
    }

    private final void B(FeedCloudMeta$StFeed feed, String scheme) {
        String R = R(scheme);
        if (TextUtils.isEmpty(R)) {
            return;
        }
        FeedCloudMeta$StFeedExtraInfo feedCloudMeta$StFeedExtraInfo = new FeedCloudMeta$StFeedExtraInfo();
        feedCloudMeta$StFeedExtraInfo.publisherSchema.set(R);
        feed.feedExtraInfo.set(feedCloudMeta$StFeedExtraInfo);
    }

    private final void F(QCircleTaskReportInfo reportInfo, ImageParams imageParams) {
        List split$default;
        String str;
        reportInfo.origPicWidth = imageParams.getOriginWidth();
        reportInfo.origPicHeight = imageParams.getOriginHeight();
        long j3 = 1024;
        reportInfo.origPicSize = imageParams.getOriginFileSize() / j3;
        reportInfo.editedPicHeight = imageParams.getHeight();
        reportInfo.editedPicWidth = imageParams.getWidth();
        reportInfo.editedPicSize = imageParams.getFileSize() / j3;
        if (!(imageParams.getMimetype().length() == 0)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) imageParams.getMimetype(), new String[]{"/"}, false, 0, 6, (Object) null);
            str = (String) split$default.get(1);
        } else {
            str = MimeHelper.IMAGE_SUBTYPE_JPEG;
        }
        reportInfo.picture_format = str;
        reportInfo.is_video = 0;
        r(reportInfo, imageParams.getLocalPath());
    }

    private final void G(FeedCloudMeta$StFeed feed, List<UploadMediaInfo> images) {
        FeedCloudMeta$StImage feedCloudMeta$StImage = null;
        for (UploadMediaInfo uploadMediaInfo : images) {
            FeedCloudMeta$StImage feedCloudMeta$StImage2 = new FeedCloudMeta$StImage();
            AbstractUploadResult uploadResponse = uploadMediaInfo.getUploadResponse();
            Intrinsics.checkNotNull(uploadResponse, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.ImageUploadResult");
            ImageUploadResult imageUploadResult = (ImageUploadResult) uploadResponse;
            feedCloudMeta$StImage2.picUrl.set(imageUploadResult.sBURL);
            feedCloudMeta$StImage2.width.set(imageUploadResult.iWidth);
            feedCloudMeta$StImage2.height.set(imageUploadResult.iHeight);
            feedCloudMeta$StImage2.imageMD5.set(imageUploadResult.sPhotoMD5);
            MediaParams mediaParams = uploadMediaInfo.getMediaParams();
            Intrinsics.checkNotNull(mediaParams, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.model.params.ImageParams");
            List<FeedCloudMeta$StMaterialDataNew> Q = Q(((ImageParams) mediaParams).getMaterialParamsList());
            if (Q != null) {
                feedCloudMeta$StImage2.materialList.addAll(Q);
            }
            feed.images.add(feedCloudMeta$StImage2);
            if (feedCloudMeta$StImage == null) {
                feedCloudMeta$StImage = new FeedCloudMeta$StImage();
                feedCloudMeta$StImage.picUrl.set(imageUploadResult.sBURL);
                feedCloudMeta$StImage.width.set(imageUploadResult.iWidth);
                feedCloudMeta$StImage.height.set(imageUploadResult.iHeight);
                feed.cover.set(feedCloudMeta$StImage);
            }
        }
    }

    private final void I(FeedCloudMeta$StFeed feed, NetVideoParams videoParams, String vid, String md5) {
        QLog.d("WinkPublish-upload2-PublishFeedFeat", 1, "[fillNetVideoInfo] vid=" + vid + ", md5=" + md5);
        if (!(vid.length() == 0)) {
            FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
            feedCloudMeta$StVideo.fileId.set(vid);
            feedCloudMeta$StVideo.videoMD5.set(md5);
            feedCloudMeta$StVideo.width.set(videoParams.getWidth());
            feedCloudMeta$StVideo.height.set(videoParams.getHeight());
            feedCloudMeta$StVideo.fileSize.set((int) videoParams.getFileSize());
            feedCloudMeta$StVideo.duration.set((int) videoParams.getDuration());
            feedCloudMeta$StVideo.transStatus.set(2);
            PBStringField pBStringField = feedCloudMeta$StVideo.videoComposeSourceInfo;
            FeedParams feedParams = this.feedParams;
            if (feedParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                feedParams = null;
            }
            pBStringField.set(feedParams.getVideoSourceInfo());
            feed.video.set(feedCloudMeta$StVideo);
            return;
        }
        throw new PublishFeedException(new PublishFeedErrorCode(PublishFeedErrorCode.ERROR_CODE_INVALID_VID, null, 2, null));
    }

    private final void L(FeedCloudMeta$StFeed feed, ImageUploadResult response) {
        String str = response.sBURL;
        boolean z16 = true;
        QLog.d("WinkPublish-upload2-PublishFeedFeat", 1, "[fillVideoCoverInfo] picUrl=" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
            feedCloudMeta$StImage.picUrl.set(str);
            feedCloudMeta$StImage.width.set(response.iWidth);
            feedCloudMeta$StImage.height.set(response.iHeight);
            feedCloudMeta$StImage.imageMD5.set(response.sPhotoMD5);
            feed.cover.set(feedCloudMeta$StImage);
            return;
        }
        throw new PublishFeedException(new PublishFeedErrorCode(PublishFeedErrorCode.ERROR_CODE_INVALID_VIDEO_COVER, null, 2, null));
    }

    private final void M(QCircleTaskReportInfo reportInfo, VideoParams videoParams) {
        Object firstOrNull;
        List<VideoParams> originVideoParams = videoParams.getOriginVideoParams();
        if (originVideoParams != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) originVideoParams);
            VideoParams videoParams2 = (VideoParams) firstOrNull;
            if (videoParams2 != null) {
                reportInfo.origPicWidth = videoParams2.getWidth();
                reportInfo.origPicHeight = videoParams2.getHeight();
                reportInfo.origPicSize = videoParams2.getFileSize() / 1024;
                reportInfo.mediaOriginBitrate = videoParams2.getBitrate();
            }
        }
        reportInfo.editedPicHeight = videoParams.getHeight();
        reportInfo.editedPicWidth = videoParams.getWidth();
        reportInfo.editedPicSize = videoParams.getFileSize() / 1024;
        reportInfo.editedVideoMediaBitrate = videoParams.getBitrate();
        reportInfo.picture_format = "mp4";
        reportInfo.is_video = 1;
    }

    private final void N(FeedCloudMeta$StFeed feed, VideoParams videoParams, String vid, String md5) {
        QLog.d("WinkPublish-upload2-PublishFeedFeat", 1, "[fillVideoInfo] vid=" + vid + ", md5=" + md5);
        if (!(vid.length() == 0)) {
            FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
            feedCloudMeta$StVideo.fileId.set(vid);
            feedCloudMeta$StVideo.videoMD5.set(md5);
            if (videoParams.getRotation() != 90 && videoParams.getRotation() != 270) {
                feedCloudMeta$StVideo.width.set(videoParams.getWidth());
                feedCloudMeta$StVideo.height.set(videoParams.getHeight());
            } else {
                feedCloudMeta$StVideo.width.set(videoParams.getHeight());
                feedCloudMeta$StVideo.height.set(videoParams.getWidth());
            }
            feedCloudMeta$StVideo.fileSize.set((int) videoParams.getFileSize());
            long duration = videoParams.getDuration();
            if (duration == 0) {
                QLog.e("WinkPublish-upload2-PublishFeedFeat", 1, "[fillVideoInfo] invalid video duration, videoPath=" + videoParams.getLocalPath());
                duration = T(videoParams.getLocalPath());
            }
            feedCloudMeta$StVideo.duration.set((int) duration);
            feedCloudMeta$StVideo.transStatus.set(2);
            PBStringField pBStringField = feedCloudMeta$StVideo.videoComposeSourceInfo;
            FeedParams feedParams = this.feedParams;
            if (feedParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                feedParams = null;
            }
            pBStringField.set(feedParams.getVideoSourceInfo());
            List<FeedCloudMeta$StMaterialDataNew> Q = Q(videoParams.getMaterialParamsList());
            if (Q != null) {
                feedCloudMeta$StVideo.materialList.addAll(Q);
            }
            feed.video.set(feedCloudMeta$StVideo);
            return;
        }
        throw new PublishFeedException(new PublishFeedErrorCode(PublishFeedErrorCode.ERROR_CODE_INVALID_VID, null, 2, null));
    }

    private final String P(GpsParams gpsParams) {
        if (gpsParams != null) {
            return (gpsParams.getLat() / 1000000.0d) + "|" + (gpsParams.getLon() / 1000000.0d);
        }
        if (WinkHostLbsHelper.getCurrGps(WinkHostConstants.QzoneLbsConstant.businessIdQzoneSay()) == null) {
            return null;
        }
        return (r8.lat / 1000000.0d) + "|" + (r8.lon / 1000000.0d);
    }

    private final String S() {
        return (String) this.taskId.getValue();
    }

    private final long T(String videoPath) {
        boolean startsWith$default;
        MediaExtractor mediaExtractor = new MediaExtractor();
        long j3 = 0;
        try {
            mediaExtractor.setDataSource(videoPath);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i3 = 0; i3 < trackCount; i3++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                if (string != null) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video", false, 2, null);
                    if (startsWith$default) {
                        j3 = trackFormat.getLong("durationUs") / 1000;
                    }
                }
            }
        } finally {
            try {
                QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[getVideoDurationMs] duration=" + j3);
                return j3;
            } finally {
            }
        }
        QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[getVideoDurationMs] duration=" + j3);
        return j3;
    }

    private final void U(PublishFeedErrorCode winkErrorCode, String feedId, long createTime, String requestTraceId) {
        Object firstOrNull;
        QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[onFeedPublished] retCode=" + winkErrorCode + ", feedId=" + feedId + ", requestTraceId=" + requestTraceId);
        TaskContext taskContext = this.taskContext;
        FeedParams feedParams = null;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        taskContext.K(feedId);
        TaskContext taskContext2 = this.taskContext;
        if (taskContext2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext2 = null;
        }
        taskContext2.L(createTime);
        TaskContext taskContext3 = this.taskContext;
        if (taskContext3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext3 = null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) taskContext3.x());
        UploadMediaInfo uploadMediaInfo = (UploadMediaInfo) firstOrNull;
        if (uploadMediaInfo != null && uploadMediaInfo.getIsVideoExported()) {
            ((IWinkAPI) QRoute.api(IWinkAPI.class)).flagUselessFile(uploadMediaInfo.l());
        }
        V(winkErrorCode, feedId, requestTraceId);
        FeedParams feedParams2 = this.feedParams;
        if (feedParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
        } else {
            feedParams = feedParams2;
        }
        if (feedParams.getNeedSaveMedia()) {
            c(new com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.d());
        }
    }

    private final void V(PublishFeedErrorCode winkErrorCode, String feedId, String requestTraceId) {
        try {
            Y(winkErrorCode);
            k(winkErrorCode.transformedCode(), feedId, requestTraceId);
        } catch (Exception e16) {
            QLog.w("WinkPublish-upload2-PublishFeedFeat", 1, "[report] ", e16);
        }
    }

    private final void k(long retCode, String feedId, String requestTraceId) {
        int i3;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        TaskContext taskContext = this.taskContext;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        List<MediaParams> mediaParamsList = taskContext.getPublishParams().getMediaParamsList();
        if (mediaParamsList != null) {
            int size = mediaParamsList.size();
            for (MediaParams mediaParams : mediaParamsList) {
                QCircleTaskReportInfo qCircleTaskReportInfo = new QCircleTaskReportInfo();
                qCircleTaskReportInfo.author_uin = ua3.a.d().f();
                FeedParams feedParams = this.feedParams;
                if (feedParams == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                    feedParams = null;
                }
                qCircleTaskReportInfo.feed_tag = feedParams.getTagsAsString();
                FeedParams feedParams2 = this.feedParams;
                if (feedParams2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                    feedParams2 = null;
                }
                qCircleTaskReportInfo.txtinfo = feedParams2.getContent();
                qCircleTaskReportInfo.total_upload_num = size;
                FeedParams feedParams3 = this.feedParams;
                if (feedParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                    feedParams3 = null;
                }
                HashMap<String, String> requestExtInfo = feedParams3.getRequestExtInfo();
                int i16 = 0;
                if (requestExtInfo == null || (str2 = requestExtInfo.get("up_source")) == null) {
                    i3 = 0;
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "get(\"up_source\")");
                    i3 = Integer.parseInt(str2);
                }
                qCircleTaskReportInfo.up_source = i3;
                FeedParams feedParams4 = this.feedParams;
                if (feedParams4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                    feedParams4 = null;
                }
                HashMap<String, String> requestExtInfo2 = feedParams4.getRequestExtInfo();
                if (requestExtInfo2 != null && (str = requestExtInfo2.get(QCircleLpReportDc05494.KEY_UP_TYPE)) != null) {
                    Intrinsics.checkNotNullExpressionValue(str, "get(\"up_type\")");
                    i16 = Integer.parseInt(str);
                }
                qCircleTaskReportInfo.up_type = i16;
                qCircleTaskReportInfo.feedid = feedId;
                qCircleTaskReportInfo.traceId = requestTraceId;
                qCircleTaskReportInfo.retCode = retCode;
                FeedParams feedParams5 = this.feedParams;
                if (feedParams5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                    feedParams5 = null;
                }
                PoiParams poiParams = feedParams5.getPoiParams();
                String P = P(poiParams != null ? poiParams.getGpsParams() : null);
                if (P != null) {
                    qCircleTaskReportInfo.up_place = P;
                    if (qCircleTaskReportInfo.up_type == 1) {
                        qCircleTaskReportInfo.shoot_place = P;
                    }
                }
                if (mediaParams instanceof VideoParams) {
                    M(qCircleTaskReportInfo, (VideoParams) mediaParams);
                } else if (mediaParams instanceof ImageParams) {
                    F(qCircleTaskReportInfo, (ImageParams) mediaParams);
                }
                arrayList.add(qCircleTaskReportInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(String str, long j3, Continuation<? super PublishFeedErrorCode> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QCircleGetFeedDetailRequest qCircleGetFeedDetailRequest = new QCircleGetFeedDetailRequest(str, FSTransUtils.getAccount(), j3, true);
        VSNetworkHelper.getInstance().sendRequest(qCircleGetFeedDetailRequest, new c(qCircleGetFeedDetailRequest, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(QCirclePublishFeedRequest qCirclePublishFeedRequest, Continuation<? super PublishResponse> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        TaskContext taskContext = this.taskContext;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        com.tencent.mobileqq.winkpublish.outbox.d.c(taskContext, "key_publishfeed");
        VSNetworkHelper.getInstance().sendRequest(qCirclePublishFeedRequest, new d(qCirclePublishFeedRequest, this, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void s(FeedCloudMeta$StFeed feed, String advJobId) {
        if (TextUtils.isEmpty(advJobId)) {
            return;
        }
        FeedCloudMeta$StFeedAdv feedCloudMeta$StFeedAdv = new FeedCloudMeta$StFeedAdv();
        PBInt64Field pBInt64Field = feedCloudMeta$StFeedAdv.jobID;
        Intrinsics.checkNotNull(advJobId);
        pBInt64Field.set(Long.parseLong(advJobId));
        feed.advInfo.set(feedCloudMeta$StFeedAdv);
    }

    private final void t(FeedCloudMeta$StFeed feed, BusinessShareParams businessShareParams) {
        FeedCloudMeta$StFeedAppInnnerJumpInfo feedCloudMeta$StFeedAppInnnerJumpInfo = new FeedCloudMeta$StFeedAppInnnerJumpInfo();
        if (businessShareParams != null) {
            if (businessShareParams.getBusinessGuildId() != 0) {
                feedCloudMeta$StFeedAppInnnerJumpInfo.guild_id.set(businessShareParams.getBusinessGuildId());
            } else if (businessShareParams.getBusinessTroopId() != 0) {
                feedCloudMeta$StFeedAppInnnerJumpInfo.qq_group_message_id.set(businessShareParams.getBusinessMsgSeq());
                feedCloudMeta$StFeedAppInnnerJumpInfo.qq_group_id.set(businessShareParams.getBusinessTroopId());
            }
            feedCloudMeta$StFeedAppInnnerJumpInfo.qq_group_source.set(businessShareParams.getBindSource());
            feed.feedExtraInfo.inner_jump.set(feedCloudMeta$StFeedAppInnnerJumpInfo);
        }
    }

    private final void w(FeedCloudMeta$StFeed feed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(ua3.a.d().g());
        feed.poster.set(feedCloudMeta$StUser);
        TaskContext taskContext = this.taskContext;
        FeedParams feedParams = null;
        if (taskContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        }
        QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[fillFeedInfo] cameraSessionId=" + taskContext.getDtCameraSessionId());
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = feed.extInfo;
        TaskContext taskContext2 = this.taskContext;
        if (taskContext2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext2 = null;
        }
        pBRepeatMessageField.add(QCircleReportHelper.newEntry("client_session", taskContext2.getDtCameraSessionId()));
        PBBoolField pBBoolField = feed.disableNearbyRecomm;
        FeedParams feedParams2 = this.feedParams;
        if (feedParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams2 = null;
        }
        pBBoolField.set(!feedParams2.isNearbyRecommend());
        PBStringField pBStringField = feed.title;
        FeedParams feedParams3 = this.feedParams;
        if (feedParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams3 = null;
        }
        pBStringField.set(feedParams3.getTitle());
        PBStringField pBStringField2 = feed.content;
        FeedParams feedParams4 = this.feedParams;
        if (feedParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams4 = null;
        }
        pBStringField2.set(feedParams4.getContent());
        PBUInt32Field pBUInt32Field = feed.syncStatus;
        FeedParams feedParams5 = this.feedParams;
        if (feedParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams5 = null;
        }
        pBUInt32Field.set(feedParams5.isSyncToQzone() ? 3 : 0);
        FeedCloudMeta$StClientInfo feedCloudMeta$StClientInfo = new FeedCloudMeta$StClientInfo();
        PBStringField pBStringField3 = feedCloudMeta$StClientInfo.feedclientkey;
        TaskContext taskContext3 = this.taskContext;
        if (taskContext3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext3 = null;
        }
        pBStringField3.set(taskContext3.c());
        feed.clientInfo.set(feedCloudMeta$StClientInfo);
        FeedParams feedParams6 = this.feedParams;
        if (feedParams6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams6 = null;
        }
        u(feed, feedParams6.getExtInfo());
        FeedParams feedParams7 = this.feedParams;
        if (feedParams7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams7 = null;
        }
        boolean isPublic = feedParams7.isPublic();
        FeedParams feedParams8 = this.feedParams;
        if (feedParams8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams8 = null;
        }
        List<String> groupId = feedParams8.getGroupId();
        FeedParams feedParams9 = this.feedParams;
        if (feedParams9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams9 = null;
        }
        List<String> uinId = feedParams9.getUinId();
        FeedParams feedParams10 = this.feedParams;
        if (feedParams10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams10 = null;
        }
        A(feed, isPublic, groupId, uinId, feedParams10.getNotAllowDownload());
        FeedParams feedParams11 = this.feedParams;
        if (feedParams11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams11 = null;
        }
        z(feed, feedParams11.getMusicParams());
        FeedParams feedParams12 = this.feedParams;
        if (feedParams12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams12 = null;
        }
        x(feed, feedParams12.getPoiParams());
        FeedParams feedParams13 = this.feedParams;
        if (feedParams13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams13 = null;
        }
        D(feed, feedParams13.getTagParams());
        FeedParams feedParams14 = this.feedParams;
        if (feedParams14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams14 = null;
        }
        J(feed, feedParams14.getPromotionParams());
        FeedParams feedParams15 = this.feedParams;
        if (feedParams15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams15 = null;
        }
        C(feed, feedParams15.getSchoolParams());
        FeedParams feedParams16 = this.feedParams;
        if (feedParams16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams16 = null;
        }
        E(feed, Integer.valueOf(feedParams16.getTypeParams()));
        FeedParams feedParams17 = this.feedParams;
        if (feedParams17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams17 = null;
        }
        B(feed, feedParams17.getScheme());
        FeedParams feedParams18 = this.feedParams;
        if (feedParams18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams18 = null;
        }
        s(feed, feedParams18.getAdvJobId());
        FeedParams feedParams19 = this.feedParams;
        if (feedParams19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams19 = null;
        }
        t(feed, feedParams19.getBusinessShareParams());
        FeedParams feedParams20 = this.feedParams;
        if (feedParams20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams20 = null;
        }
        H(feed, feedParams20.getLiteBanner());
        TaskContext taskContext4 = this.taskContext;
        if (taskContext4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext4 = null;
        }
        y(feed, taskContext4);
        FeedParams feedParams21 = this.feedParams;
        if (feedParams21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams21 = null;
        }
        n(feed, feedParams21.getTianshuActivityItemValue());
        FeedParams feedParams22 = this.feedParams;
        if (feedParams22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams22 = null;
        }
        p(feed, feedParams22.getDeclarationId());
        FeedParams feedParams23 = this.feedParams;
        if (feedParams23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams23 = null;
        }
        q(feed, feedParams23.getDeclarationParams());
        TaskContext taskContext5 = this.taskContext;
        if (taskContext5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext5 = null;
        }
        K(feed, taskContext5.getPublishParams().getTransParams());
        FeedParams feedParams24 = this.feedParams;
        if (feedParams24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
            feedParams24 = null;
        }
        o(feed, feedParams24.getDailyParams());
        FeedParams feedParams25 = this.feedParams;
        if (feedParams25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
        } else {
            feedParams = feedParams25;
        }
        v(feed, feedParams.getFeedExtraInfo());
    }

    private final void y(FeedCloudMeta$StFeed feed, TaskContext taskContext) {
        if (taskContext.C()) {
            UploadMediaInfo uploadMediaInfo = taskContext.x().get(0);
            AbstractUploadResult uploadResponse = uploadMediaInfo.getUploadResponse();
            Intrinsics.checkNotNull(uploadResponse, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.VideoUploadResult");
            VideoUploadResult videoUploadResult = (VideoUploadResult) uploadResponse;
            String md5 = uploadMediaInfo.getMd5();
            if (uploadMediaInfo.getUploadTask() != null) {
                AbstractUploadTask uploadTask = uploadMediaInfo.getUploadTask();
                Intrinsics.checkNotNull(uploadTask);
                md5 = uploadTask.md5;
                Intrinsics.checkNotNullExpressionValue(md5, "mediaInfo.uploadTask!!.md5");
            }
            if (uploadMediaInfo.r() != null) {
                VideoParams r16 = uploadMediaInfo.r();
                Intrinsics.checkNotNull(r16);
                String str = videoUploadResult.sVid;
                Intrinsics.checkNotNullExpressionValue(str, "response.sVid");
                N(feed, r16, str, md5);
            } else if (uploadMediaInfo.m() != null) {
                NetVideoParams m3 = uploadMediaInfo.m();
                Intrinsics.checkNotNull(m3);
                String str2 = videoUploadResult.sVid;
                Intrinsics.checkNotNullExpressionValue(str2, "response.sVid");
                I(feed, m3, str2, md5);
            }
            AbstractUploadResult coverUploadResponse = uploadMediaInfo.getCoverUploadResponse();
            Intrinsics.checkNotNull(coverUploadResponse, "null cannot be cast to non-null type com.tencent.upload.uinterface.data.ImageUploadResult");
            L(feed, (ImageUploadResult) coverUploadResponse);
            feed.type.set(3);
            return;
        }
        G(feed, taskContext.l());
        feed.type.set(2);
        feed.feedSubType.set(1);
    }

    private final void z(FeedCloudMeta$StFeed feed, MusicParams musicParams) {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic = new FeedCloudMeta$StFeedMusic();
        if (musicParams != null) {
            feedCloudMeta$StFeedMusic.ID.set(musicParams.getId());
            feedCloudMeta$StFeedMusic.MID.set(musicParams.getMId());
            feedCloudMeta$StFeedMusic.startPos.set((int) musicParams.getStartTime());
            feedCloudMeta$StFeedMusic.musicName.set(musicParams.getName());
            feedCloudMeta$StFeedMusic.scene.set(musicParams.getScene());
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(musicParams.getAuthorUid());
            feedCloudMeta$StFeedMusic.authorUser.set(feedCloudMeta$StUser);
        }
        feed.musicInfo.set(feedCloudMeta$StFeedMusic);
    }

    private final Object W(String str, long j3, Continuation<? super PublishFeedErrorCode> continuation) {
        QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[tryCheckFeedComplete]");
        this.checkFeedCount = 0;
        return IFeatureKt.b(new PublishFeedFeat$tryCheckFeedComplete$2(this, null), new PublishFeedFeat$tryCheckFeedComplete$3(this, str, j3, null), continuation);
    }

    private final Object X(QCirclePublishFeedRequest qCirclePublishFeedRequest, Continuation<? super PublishResponse> continuation) {
        QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[tryPublishFeedComplete]");
        this.publishFeedCount = 0;
        return IFeatureKt.b(new PublishFeedFeat$tryPublishFeedComplete$2(this, null), new PublishFeedFeat$tryPublishFeedComplete$3(this, qCirclePublishFeedRequest, null), continuation);
    }

    private final void r(QCircleTaskReportInfo reportInfo, String path) {
        try {
            if (JpegExifReader.isCrashJpeg(path)) {
                return;
            }
            android.media.ExifInterface exifInterface = new android.media.ExifInterface(path);
            String attribute = exifInterface.getAttribute("Model");
            String attribute2 = exifInterface.getAttribute("Make");
            String attribute3 = exifInterface.getAttribute("DateTime");
            float[] fArr = new float[2];
            boolean latLong = exifInterface.getLatLong(fArr);
            if (!TextUtils.isEmpty(attribute3)) {
                reportInfo.shooting_time = String.valueOf(DateUtil.getSecondsFromDate(attribute3));
            }
            if (!TextUtils.isEmpty(attribute2)) {
                reportInfo.shoot_product = attribute2;
            }
            if (!TextUtils.isEmpty(attribute)) {
                reportInfo.shoot_model = attribute;
            }
            if (latLong) {
                reportInfo.place = fArr[1] + "|" + fArr[0];
            }
        } catch (Exception e16) {
            QLog.w("WinkPublish-TaskParams", 1, "[fillExif] path: " + path, e16);
        }
    }

    public PublishFeedFeat() {
        super(null, 1, null);
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat$taskId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String O;
                O = PublishFeedFeat.this.O();
                return O;
            }
        });
        this.taskId = lazy;
    }

    private final void C(FeedCloudMeta$StFeed feed, SchoolParams schoolParams) {
        if (schoolParams != null) {
            FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
            feedCloudMeta$StTagInfo.tagName.set(schoolParams.getName());
            feed.authSchoolInfo.set(feedCloudMeta$StTagInfo);
        }
    }

    private final void D(FeedCloudMeta$StFeed feed, List<TagParams> tagParamsList) {
        if (tagParamsList != null) {
            for (TagParams tagParams : tagParamsList) {
                FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
                feedCloudMeta$StTagInfo.tagName.set(tagParams.getName());
                feed.tagInfos.add(feedCloudMeta$StTagInfo);
            }
        }
    }

    private final void E(FeedCloudMeta$StFeed feed, Integer typeParams) {
        if (typeParams != null) {
            int intValue = typeParams.intValue();
            FeedCloudMeta$StCommInfo feedCloudMeta$StCommInfo = new FeedCloudMeta$StCommInfo();
            feedCloudMeta$StCommInfo.pubType.set(intValue);
            feed.commonInfo.set(feedCloudMeta$StCommInfo);
        }
    }

    private final void J(FeedCloudMeta$StFeed feed, PromotionPublishParams promotionParams) {
        if (promotionParams != null) {
            FeedCloudMeta$StEShopGoodsInfo feedCloudMeta$StEShopGoodsInfo = new FeedCloudMeta$StEShopGoodsInfo();
            feedCloudMeta$StEShopGoodsInfo.f398448id.set(promotionParams.getId());
            feedCloudMeta$StEShopGoodsInfo.name.set(promotionParams.getName());
            FeedCloudMeta$StEShopPlatformInfo feedCloudMeta$StEShopPlatformInfo = new FeedCloudMeta$StEShopPlatformInfo();
            feedCloudMeta$StEShopPlatformInfo.isBindedWithPlatform.set(true);
            feedCloudMeta$StEShopPlatformInfo.adID.set(promotionParams.getId());
            feedCloudMeta$StEShopPlatformInfo.contentExt.set(ByteStringMicro.copyFrom(promotionParams.getExt()));
            FeedCloudMeta$StEShopGoods feedCloudMeta$StEShopGoods = new FeedCloudMeta$StEShopGoods();
            feedCloudMeta$StEShopGoods.total.set(1);
            feedCloudMeta$StEShopGoods.goodsInfos.add(feedCloudMeta$StEShopGoodsInfo);
            feedCloudMeta$StEShopGoods.eshopPlatformInfo.set(feedCloudMeta$StEShopPlatformInfo);
            feed.eShopGoods.set(feedCloudMeta$StEShopGoods);
        }
    }

    private final void K(FeedCloudMeta$StFeed stFeed, Bundle transParams) {
        if (transParams != null) {
            String string = transParams.getString(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE);
            if (string == null || string.length() == 0) {
                return;
            }
            FeedCloudMeta$StPost feedCloudMeta$StPost = stFeed.post;
            FeedCloudMeta$StPost feedCloudMeta$StPost2 = new FeedCloudMeta$StPost();
            String string2 = transParams.getString(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE);
            if (string2 != null) {
                Intrinsics.checkNotNullExpressionValue(string2, "getString(QCircleScheme.\u2026ublish.ST_POST_POST_TYPE)");
                feedCloudMeta$StPost2.post_type.set(Integer.parseInt(string2));
            }
            String string3 = transParams.getString(QCircleScheme.AttrQQPublish.ST_POST_COMMENT_ID);
            if (string3 != null) {
                feedCloudMeta$StPost2.comment_id.set(string3);
            }
            String string4 = transParams.getString(QCircleScheme.AttrQQPublish.ST_POST_REPLY_ID);
            if (string4 != null) {
                feedCloudMeta$StPost2.reply_id.set(string4);
            }
            FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract = feedCloudMeta$StPost2.feed;
            FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract2 = new FeedCloudMeta$StFeedAbstract();
            String string5 = transParams.getString(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_ID);
            if (string5 != null) {
                feedCloudMeta$StFeedAbstract2.f398450id.set(string5);
            }
            FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeedAbstract2.poster;
            FeedCloudMeta$StUser feedCloudMeta$StUser2 = new FeedCloudMeta$StUser();
            String string6 = transParams.getString(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_POSTER_ID);
            if (string6 != null) {
                feedCloudMeta$StUser2.f398463id.set(string6);
            }
            feedCloudMeta$StUser.set(feedCloudMeta$StUser2);
            String string7 = transParams.getString(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_CREATETIME);
            if (string7 != null) {
                Intrinsics.checkNotNullExpressionValue(string7, "getString(QCircleScheme.\u2026FEED_ABSTRACT_CREATETIME)");
                feedCloudMeta$StFeedAbstract2.createTime.set(Long.parseLong(string7));
            }
            feedCloudMeta$StFeedAbstract.set(feedCloudMeta$StFeedAbstract2);
            feedCloudMeta$StPost.set(feedCloudMeta$StPost2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String O() {
        boolean z16 = true;
        String str = null;
        try {
            TaskContext taskContext = this.taskContext;
            if (taskContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taskContext");
                taskContext = null;
            }
            Bundle transParams = taskContext.getPublishParams().getTransParams();
            Object obj = transParams != null ? transParams.get(QQWinkConstants.WINK_PUBLISH_TASK_ID) : null;
            if (obj instanceof String) {
                str = (String) obj;
            }
        } catch (Exception unused) {
            QLog.d("WinkPublish-upload2-PublishFeedFeat", 1, "transParams is null");
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        return z16 ? "others" : str;
    }

    private final void Y(PublishFeedErrorCode winkErrorCode) {
        TaskContext taskContext;
        TaskContext taskContext2 = this.taskContext;
        TaskContext taskContext3 = null;
        if (taskContext2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext2 = null;
        }
        String r16 = taskContext2.r();
        TaskContext taskContext4 = this.taskContext;
        if (taskContext4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext = null;
        } else {
            taskContext = taskContext4;
        }
        String valueOf = String.valueOf(winkErrorCode.transformedCode());
        TaskContext taskContext5 = this.taskContext;
        if (taskContext5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
            taskContext5 = null;
        }
        String valueOf2 = String.valueOf(taskContext5.getUploadTaskType());
        TaskContext taskContext6 = this.taskContext;
        if (taskContext6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("taskContext");
        } else {
            taskContext3 = taskContext6;
        }
        TaskContext taskContext7 = taskContext;
        com.tencent.mobileqq.winkpublish.outbox.d.a(taskContext7, WinkPublishServiceReporter.P_PUBLISH_ALL_COST, r16, valueOf, (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "key_user_click_upload_cost", (r33 & 32) != 0 ? "" : valueOf2, (r33 & 64) != 0 ? "" : String.valueOf(taskContext3.getStartTimeMillis()), (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : "key_user_click_upload_cost", (r33 & 8192) != 0 ? "" : null);
        com.tencent.mobileqq.winkpublish.outbox.d.a(taskContext7, WinkPublishServiceReporter.P_PUBLISH_ALL_COST, r16, String.valueOf(winkErrorCode.transformedCode()), (r33 & 8) != 0 ? "" : null, (r33 & 16) != 0 ? "" : "key_getfeed", (r33 & 32) != 0 ? "" : String.valueOf(this.checkFeedCount), (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : null, (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : "key_getfeed", (r33 & 8192) != 0 ? "" : null);
    }

    private final void n(FeedCloudMeta$StFeed feed, String activityItemValue) {
        if (activityItemValue == null || activityItemValue.length() == 0) {
            return;
        }
        FeedCloudMeta$StActivityInfo feedCloudMeta$StActivityInfo = feed.activityInfo;
        FeedCloudMeta$StActivityInfo feedCloudMeta$StActivityInfo2 = new FeedCloudMeta$StActivityInfo();
        feedCloudMeta$StActivityInfo2.activityValue.set(S() + "#" + activityItemValue);
        feedCloudMeta$StActivityInfo.set(feedCloudMeta$StActivityInfo2);
    }

    private final void o(FeedCloudMeta$StFeed feed, DailyInfo dailyParams) {
        if (dailyParams != null) {
            QLog.d("WinkPublish-upload2-PublishFeedFeat", 1, "fillDailyInfo... dailyParams:" + dailyParams);
            FeedCloudMeta$DailyInfo feedCloudMeta$DailyInfo = new FeedCloudMeta$DailyInfo();
            feedCloudMeta$DailyInfo.is_daily.set(dailyParams.getIsDaily());
            feedCloudMeta$DailyInfo.valid_time.set(dailyParams.getValidTime());
            feed.feedExtraInfo.daily.set(feedCloudMeta$DailyInfo);
        }
    }

    private final void p(FeedCloudMeta$StFeed feed, String declarationId) {
        if (declarationId != null) {
            feed.extInfo.add(QCircleReportHelper.newEntry("declaration_id", declarationId));
        }
    }

    private final void q(FeedCloudMeta$StFeed feed, DeclarationParams declarationParams) {
        if (declarationParams != null) {
            QLog.d("WinkPublish-upload2-PublishFeedFeat", 1, "fillDeclarationInfoV2... declarationParams:" + declarationParams);
            FeedCloudMeta$FeedSelfDeclaration feedCloudMeta$FeedSelfDeclaration = new FeedCloudMeta$FeedSelfDeclaration();
            feedCloudMeta$FeedSelfDeclaration.f398442id.set(declarationParams.getId());
            FeedCloudMeta$ShootLBS shootLbs = declarationParams.getShootLbs();
            if (shootLbs != null) {
                feedCloudMeta$FeedSelfDeclaration.lbs.set(shootLbs);
            }
            FeedCloudMeta$SourceInfo sourceInfo = declarationParams.getSourceInfo();
            if (sourceInfo != null) {
                feedCloudMeta$FeedSelfDeclaration.source.set(sourceInfo);
            }
            feed.feedExtraInfo.self_declaration.set(feedCloudMeta$FeedSelfDeclaration);
        }
    }

    private final void u(FeedCloudMeta$StFeed feed, HashMap<String, String> extInfo) {
        Set<Map.Entry<String, String>> entrySet;
        if (extInfo == null || (entrySet = extInfo.entrySet()) == null) {
            return;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            feed.extInfo.add(QCircleReportHelper.newEntry((String) entry.getKey(), (String) entry.getValue()));
        }
    }

    private final void v(FeedCloudMeta$StFeed feed, FeedExtraInfo feedExtraInfo) {
        if (feedExtraInfo != null) {
            feed.feedExtraInfo.channel.set(feedExtraInfo.getChannel());
        }
    }

    private final void x(FeedCloudMeta$StFeed feed, PoiParams poiParams) {
        if (poiParams != null) {
            FeedCloudMeta$StPoiInfoV2 feedCloudMeta$StPoiInfoV2 = new FeedCloudMeta$StPoiInfoV2();
            feedCloudMeta$StPoiInfoV2.districtCode.set(poiParams.getDistrictCode());
            feedCloudMeta$StPoiInfoV2.distance.set(poiParams.getDistance());
            feedCloudMeta$StPoiInfoV2.hotValue.set(poiParams.getHotValue());
            feedCloudMeta$StPoiInfoV2.poiNum.set(poiParams.getPoiNum());
            feedCloudMeta$StPoiInfoV2.poiOrderType.set(poiParams.getPoiOrderType());
            feedCloudMeta$StPoiInfoV2.poiId.set(poiParams.getPoiId());
            feedCloudMeta$StPoiInfoV2.name.set(poiParams.getPoiName());
            feedCloudMeta$StPoiInfoV2.typeName.set(poiParams.getPoiTypeName());
            feedCloudMeta$StPoiInfoV2.address.set(poiParams.getAddress());
            feedCloudMeta$StPoiInfoV2.phone.set(poiParams.getPhoneNumber());
            feedCloudMeta$StPoiInfoV2.country.set(poiParams.getCountry());
            feedCloudMeta$StPoiInfoV2.province.set(poiParams.getProvince());
            feedCloudMeta$StPoiInfoV2.city.set(poiParams.getCity());
            feedCloudMeta$StPoiInfoV2.defaultName.set(poiParams.getPoiDefaultName());
            feedCloudMeta$StPoiInfoV2.district.set(poiParams.getDistrict());
            feedCloudMeta$StPoiInfoV2.dianPingId.set(poiParams.getDianPingId());
            GpsParams gpsParams = poiParams.getGpsParams();
            if (gpsParams != null) {
                FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
                feedCloudMeta$StGPSV2.lat.set(gpsParams.getLat());
                feedCloudMeta$StGPSV2.lon.set(gpsParams.getLon());
                feedCloudMeta$StGPSV2.eType.set(gpsParams.getGpsType());
                feedCloudMeta$StGPSV2.alt.set(gpsParams.getAlt());
                feedCloudMeta$StPoiInfoV2.gps.set(feedCloudMeta$StGPSV2);
            }
            feed.poiInfo.set(feedCloudMeta$StPoiInfoV2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/PublishFeedFeat$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "isSuccess", "", "b", "J", "c", "()J", "retCode", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "retMsg", "getRequestTraceId", "requestTraceId", "feedId", "f", WadlProxyConsts.CREATE_TIME, "<init>", "(ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.PublishFeedFeat$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class PublishResponse {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long retCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String retMsg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String requestTraceId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String feedId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long createTime;

        public PublishResponse(boolean z16, long j3, String retMsg, String requestTraceId, String feedId, long j16) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            Intrinsics.checkNotNullParameter(requestTraceId, "requestTraceId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.isSuccess = z16;
            this.retCode = j3;
            this.retMsg = retMsg;
            this.requestTraceId = requestTraceId;
            this.feedId = feedId;
            this.createTime = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getCreateTime() {
            return this.createTime;
        }

        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        /* renamed from: c, reason: from getter */
        public final long getRetCode() {
            return this.retCode;
        }

        /* renamed from: d, reason: from getter */
        public final String getRetMsg() {
            return this.retMsg;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((((((((r06 * 31) + com.tencent.mobileqq.winkpublish.outbox.slot.d.a(this.retCode)) * 31) + this.retMsg.hashCode()) * 31) + this.requestTraceId.hashCode()) * 31) + this.feedId.hashCode()) * 31) + com.tencent.mobileqq.winkpublish.outbox.slot.d.a(this.createTime);
        }

        public String toString() {
            return "PublishResponse(isSuccess=" + this.isSuccess + ", retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", requestTraceId=" + this.requestTraceId + ", feedId=" + this.feedId + ", createTime=" + this.createTime + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PublishResponse)) {
                return false;
            }
            PublishResponse publishResponse = (PublishResponse) other;
            return this.isSuccess == publishResponse.isSuccess && this.retCode == publishResponse.retCode && Intrinsics.areEqual(this.retMsg, publishResponse.retMsg) && Intrinsics.areEqual(this.requestTraceId, publishResponse.requestTraceId) && Intrinsics.areEqual(this.feedId, publishResponse.feedId) && this.createTime == publishResponse.createTime;
        }
    }

    private final void H(FeedCloudMeta$StFeed feed, LiteBanner liteBanner) {
        if (liteBanner == null) {
            return;
        }
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = new FeedCloudMeta$StLiteBanner();
        feedCloudMeta$StLiteBanner.business_type.set(11);
        Set<Map.Entry<String, String>> entrySet = liteBanner.getExtInfo().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "liteBanner.extInfo.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            feedCloudMeta$StLiteBanner.extInfo.add(QCircleReportHelper.newEntry((String) entry.getKey(), (String) entry.getValue()));
        }
        feed.liteBanner.set(feedCloudMeta$StLiteBanner);
    }

    private final List<FeedCloudMeta$StMaterialDataNew> Q(List<MaterialParams> materialsList) {
        if (materialsList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MaterialParams materialParams : materialsList) {
            FeedCloudMeta$StMaterialDataNew feedCloudMeta$StMaterialDataNew = new FeedCloudMeta$StMaterialDataNew();
            feedCloudMeta$StMaterialDataNew.materialType.set(materialParams.getType());
            for (String str : materialParams.getIds()) {
                FeedCloudMeta$StSingleMaterial feedCloudMeta$StSingleMaterial = new FeedCloudMeta$StSingleMaterial();
                feedCloudMeta$StSingleMaterial.materialId.set(str);
                feedCloudMeta$StMaterialDataNew.materialList.add(feedCloudMeta$StSingleMaterial);
            }
            arrayList.add(feedCloudMeta$StMaterialDataNew);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String R(String scheme) {
        boolean z16;
        int indexOf$default;
        boolean z17 = true;
        if (scheme != null) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) scheme, "taskid", 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                z16 = true;
                if (z16) {
                    QLog.d("WinkPublish-upload2-PublishFeedFeat", 1, "already contains taskid");
                    return scheme;
                }
                if (scheme != null && scheme.length() != 0) {
                    z17 = false;
                }
                if (z17) {
                    return "mqqapi://qcircle/openqqpublish?taskid=" + S();
                }
                return scheme + "&taskid=" + S();
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        PublishFeedFeat$run$1 publishFeedFeat$run$1;
        Object coroutine_suspended;
        int i3;
        String str;
        String str2;
        TaskContext taskContext2;
        PublishFeedFeat$run$1 publishFeedFeat$run$12;
        Object obj;
        PublishFeedFeat publishFeedFeat;
        QCirclePublishFeedRequest qCirclePublishFeedRequest;
        Set<Map.Entry<String, String>> entrySet;
        PublishResponse publishResponse;
        QCirclePublishFeedRequest qCirclePublishFeedRequest2;
        PublishFeedFeat publishFeedFeat2;
        PublishResponse publishResponse2;
        PublishFeedErrorCode publishFeedErrorCode;
        if (continuation instanceof PublishFeedFeat$run$1) {
            publishFeedFeat$run$1 = (PublishFeedFeat$run$1) continuation;
            int i16 = publishFeedFeat$run$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                publishFeedFeat$run$1.label = i16 - Integer.MIN_VALUE;
                PublishFeedFeat$run$1 publishFeedFeat$run$13 = publishFeedFeat$run$1;
                Object obj2 = publishFeedFeat$run$13.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = publishFeedFeat$run$13.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    this.taskContext = taskContext;
                    if (taskContext.getPublishParams().getFeedParams() != null) {
                        FeedParams feedParams = taskContext.getPublishParams().getFeedParams();
                        Intrinsics.checkNotNull(feedParams);
                        this.feedParams = feedParams;
                        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                        w(feedCloudMeta$StFeed);
                        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
                        FeedParams feedParams2 = this.feedParams;
                        FeedParams feedParams3 = null;
                        if (feedParams2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                            feedParams2 = null;
                        }
                        QLog.i("WinkPublish-upload2-PublishFeedFeat", 1, "[run] requestExtInfo=" + feedParams2.getRequestExtInfo());
                        FeedParams feedParams4 = this.feedParams;
                        if (feedParams4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedParams");
                        } else {
                            feedParams3 = feedParams4;
                        }
                        HashMap<String, String> requestExtInfo = feedParams3.getRequestExtInfo();
                        if (requestExtInfo != null && (entrySet = requestExtInfo.entrySet()) != null) {
                            Iterator<T> it = entrySet.iterator();
                            while (it.hasNext()) {
                                feedCloudCommon$StCommonExt.mapInfo.add(QCircleReportHelper.newEntry((Map.Entry) it.next()));
                            }
                        }
                        QCirclePublishFeedRequest qCirclePublishFeedRequest3 = new QCirclePublishFeedRequest(feedCloudCommon$StCommonExt, feedCloudMeta$StFeed);
                        qCirclePublishFeedRequest3.overrideTraceId(taskContext.r());
                        str = "request.traceId";
                        str2 = "";
                        taskContext2 = taskContext;
                        com.tencent.mobileqq.winkpublish.outbox.d.d(taskContext2, "E_PUBLISH_FEEDS_START", taskContext.r(), (r33 & 4) != 0 ? "" : "0", (r33 & 8) != 0 ? "" : taskContext.r(), (r33 & 16) != 0 ? "" : String.valueOf(qCirclePublishFeedRequest3.getSsoSeq()), (r33 & 32) != 0 ? "" : null, (r33 & 64) != 0 ? "" : null, (r33 & 128) != 0 ? "" : null, (r33 & 256) != 0 ? "" : String.valueOf(taskContext.getUploadTaskType()), (r33 & 512) != 0 ? "" : null, (r33 & 1024) != 0 ? "" : null, (r33 & 2048) != 0 ? "" : null, (r33 & 4096) != 0 ? "" : null, (r33 & 8192) != 0 ? "" : null);
                        publishFeedFeat$run$12 = publishFeedFeat$run$13;
                        publishFeedFeat$run$12.L$0 = this;
                        publishFeedFeat$run$12.L$1 = taskContext2;
                        publishFeedFeat$run$12.L$2 = qCirclePublishFeedRequest3;
                        publishFeedFeat$run$12.label = 1;
                        Object X = X(qCirclePublishFeedRequest3, publishFeedFeat$run$12);
                        obj = coroutine_suspended;
                        if (X == obj) {
                            return obj;
                        }
                        publishFeedFeat = this;
                        qCirclePublishFeedRequest = qCirclePublishFeedRequest3;
                        obj2 = X;
                    } else {
                        throw new PublishFeedException(new PublishFeedErrorCode(PublishFeedErrorCode.ERROR_CODE_INVALID_PARAMS, null, 2, null));
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            publishResponse2 = (PublishResponse) publishFeedFeat$run$13.L$2;
                            qCirclePublishFeedRequest2 = (QCirclePublishFeedRequest) publishFeedFeat$run$13.L$1;
                            publishFeedFeat2 = (PublishFeedFeat) publishFeedFeat$run$13.L$0;
                            ResultKt.throwOnFailure(obj2);
                            str = "request.traceId";
                            str2 = "";
                            publishFeedErrorCode = (PublishFeedErrorCode) obj2;
                            if (!publishFeedErrorCode.isOK()) {
                                String feedId = publishResponse2.getFeedId();
                                long createTime = publishResponse2.getCreateTime();
                                String traceId = qCirclePublishFeedRequest2.getTraceId();
                                Intrinsics.checkNotNullExpressionValue(traceId, str);
                                publishFeedFeat2.U(publishFeedErrorCode, feedId, createTime, traceId);
                                return Unit.INSTANCE;
                            }
                            String traceId2 = qCirclePublishFeedRequest2.getTraceId();
                            Intrinsics.checkNotNullExpressionValue(traceId2, str);
                            publishFeedFeat2.V(publishFeedErrorCode, str2, traceId2);
                            throw new PublishFeedException(publishFeedErrorCode);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    QCirclePublishFeedRequest qCirclePublishFeedRequest4 = (QCirclePublishFeedRequest) publishFeedFeat$run$13.L$2;
                    TaskContext taskContext3 = (TaskContext) publishFeedFeat$run$13.L$1;
                    PublishFeedFeat publishFeedFeat3 = (PublishFeedFeat) publishFeedFeat$run$13.L$0;
                    ResultKt.throwOnFailure(obj2);
                    publishFeedFeat = publishFeedFeat3;
                    str = "request.traceId";
                    str2 = "";
                    obj = coroutine_suspended;
                    qCirclePublishFeedRequest = qCirclePublishFeedRequest4;
                    taskContext2 = taskContext3;
                    publishFeedFeat$run$12 = publishFeedFeat$run$13;
                }
                publishResponse = (PublishResponse) obj2;
                if (publishResponse.getIsSuccess() || publishResponse.getRetCode() != 0) {
                    String str3 = str;
                    String str4 = str2;
                    if (publishResponse.getRetCode() != 10027) {
                        PublishFeedErrorCode publishFeedErrorCode2 = new PublishFeedErrorCode(publishResponse.getRetCode(), publishResponse.getRetMsg());
                        String feedId2 = publishResponse.getFeedId();
                        long createTime2 = publishResponse.getCreateTime();
                        String traceId3 = qCirclePublishFeedRequest.getTraceId();
                        Intrinsics.checkNotNullExpressionValue(traceId3, str3);
                        publishFeedFeat.U(publishFeedErrorCode2, feedId2, createTime2, traceId3);
                        return Unit.INSTANCE;
                    }
                    PublishFeedErrorCode publishFeedErrorCode3 = new PublishFeedErrorCode(publishResponse.getRetCode(), publishResponse.getRetMsg());
                    String traceId4 = qCirclePublishFeedRequest.getTraceId();
                    Intrinsics.checkNotNullExpressionValue(traceId4, str3);
                    publishFeedFeat.V(publishFeedErrorCode3, str4, traceId4);
                    throw new PublishFeedException(publishFeedErrorCode3);
                }
                com.tencent.mobileqq.winkpublish.outbox.d.c(taskContext2, "key_getfeed");
                String feedId3 = publishResponse.getFeedId();
                long createTime3 = publishResponse.getCreateTime();
                publishFeedFeat$run$12.L$0 = publishFeedFeat;
                publishFeedFeat$run$12.L$1 = qCirclePublishFeedRequest;
                publishFeedFeat$run$12.L$2 = publishResponse;
                publishFeedFeat$run$12.label = 2;
                Object W = publishFeedFeat.W(feedId3, createTime3, publishFeedFeat$run$12);
                if (W == obj) {
                    return obj;
                }
                qCirclePublishFeedRequest2 = qCirclePublishFeedRequest;
                publishFeedFeat2 = publishFeedFeat;
                obj2 = W;
                publishResponse2 = publishResponse;
                publishFeedErrorCode = (PublishFeedErrorCode) obj2;
                if (!publishFeedErrorCode.isOK()) {
                }
            }
        }
        publishFeedFeat$run$1 = new PublishFeedFeat$run$1(this, continuation);
        PublishFeedFeat$run$1 publishFeedFeat$run$132 = publishFeedFeat$run$1;
        Object obj22 = publishFeedFeat$run$132.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = publishFeedFeat$run$132.label;
        if (i3 != 0) {
        }
        publishResponse = (PublishResponse) obj22;
        if (publishResponse.getIsSuccess()) {
        }
        String str32 = str;
        String str42 = str2;
        if (publishResponse.getRetCode() != 10027) {
        }
    }
}
