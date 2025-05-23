package com.qzone.reborn.albumx.qzone.local;

import android.app.ActivityManager;
import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.localupload.recommend.RFWRecommendThread;
import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendLogDelegate;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendPoiDelegate;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendReportDelegate;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0003!%5\u0018\u0000 ;2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u0006\u0010\u0010\u001a\u00020\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "G", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadHistoryDbEntity;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "u", "B", "", "classifyId", "v", "", "paths", "E", HippyTKDListViewAdapter.X, "a", "Ljava/lang/String;", "mCurrentAcount", "Ljava/util/concurrent/ConcurrentHashMap;", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "mUploadHistoryMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mHaveInitUploadHistory", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendDbDelegate;", "d", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendDbDelegate;", "mDbDelegate", "com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$e", "e", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$e;", "mLogDelegate", "com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$b", "f", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$b;", "mConfigDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate;", "g", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate;", "y", "()Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate;", "mPoiDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendReportDelegate;", tl.h.F, "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendReportDelegate;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendReportDelegate;", "mReportDelegate", "com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$d", "i", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$d;", "mDelegate", "<init>", "()V", "j", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneUploadRecommendDirector extends RFWUploadRecommendDirectorV2 {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    private static final Lazy<QZoneUploadRecommendDirector> f52643k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mCurrentAcount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Integer> mUploadHistoryMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mHaveInitUploadHistory = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final IRFWRecommendDbDelegate mDbDelegate = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final e mLogDelegate = new e();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b mConfigDelegate = new b();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final IRFWRecommendPoiDelegate mPoiDelegate = new f();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final IRFWRecommendReportDelegate mReportDelegate = new g();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final d mDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$a;", "", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector;", "INSTANCE", "", "CLASSIFY_ID", "Ljava/lang/String;", "QZ_TAG", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QZoneUploadRecommendDirector a() {
            return (QZoneUploadRecommendDirector) QZoneUploadRecommendDirector.f52643k.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016\u00a8\u0006\u0017"}, d2 = {"com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$b", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendConfigDelegate;", "", "key", "value", "", "saveConfig", "getConfig", "", "disableRecommend", "disableResearch", "disableGetPoi", "enableSdCardSpaceAdjudge", "getDisableClassifier", "", "getPoiBatchSize", "getFirstScanCountLimit", "getIncreaseScanCountLimit", "getResearchThreadNum", "", "getClassifyTitleConfig", "getClassifyCountConfig", "enableAccessMediaLocationCheck", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IRFWRecommendConfigDelegate {
        b() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public boolean disableGetPoi() {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_GET_POI, 0) == 1;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public boolean disableRecommend() {
            return !com.qzone.reborn.albumx.qzone.local.g.f52662a.a();
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public boolean disableResearch() {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_DO_RESEARCH, 0) == 1;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public boolean enableAccessMediaLocationCheck() {
            return com.qzone.reborn.configx.g.f53821a.b().u();
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public boolean enableSdCardSpaceAdjudge() {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_ENABLE_SDCARD_SPACE_ADJUDE, 1) == 1;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public Map<String, String> getClassifyCountConfig() {
            return l.f52668a.b();
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public Map<String, String> getClassifyTitleConfig() {
            return l.f52668a.c();
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public String getConfig(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return l.f52668a.d(key);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public String getDisableClassifier() {
            String config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_DISABLE_ALBUM_LOCAL_PHOTO_RECOMMEND_CLASSIFIER_LIST, "");
            Intrinsics.checkNotNullExpressionValue(config, "getInstance().getConfig(\u2026         \"\"\n            )");
            return config;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public int getFirstScanCountLimit() {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_FIRST_SCAN_PHOTO_SIZE, 5000);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public int getIncreaseScanCountLimit() {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_INCREASE_SCAN_PHOTO_SIZE, 200);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public int getPoiBatchSize() {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_ALBUM_LOCAL_PHOTO_RECOMMEND_GET_POI_BATCH_SIZE, 100);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public int getResearchThreadNum() {
            return 3;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendConfigDelegate
        public void saveConfig(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            l.f52668a.h(key, value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016JC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\bH\u0016J%\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$c", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendDbDelegate;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfos", "", "updateMediaInfo", "insertMediaInfo", "", "selection", "", "selectionArgs", "orderBy", "limit", "query", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "needDeleteList", "delete", "deleteAll", "classifyId", "", "getUploadHistorySize", "whereClause", "whereArgs", "count", "(Ljava/lang/String;[Ljava/lang/String;)I", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements IRFWRecommendDbDelegate {
        c() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate
        public int count(String whereClause, String[] whereArgs) {
            Intrinsics.checkNotNullParameter(whereClause, "whereClause");
            Intrinsics.checkNotNullParameter(whereArgs, "whereArgs");
            return com.qzone.reborn.albumx.qzone.local.e.f52658a.c(whereClause, whereArgs);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate
        public void delete(List<RFWMediaInfo> needDeleteList) {
            Intrinsics.checkNotNullParameter(needDeleteList, "needDeleteList");
            com.qzone.reborn.albumx.qzone.local.e.f52658a.d(needDeleteList);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate
        public void deleteAll() {
            com.qzone.reborn.albumx.qzone.local.e.f52658a.e();
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate
        public int getUploadHistorySize(String classifyId) {
            Intrinsics.checkNotNullParameter(classifyId, "classifyId");
            if (QZoneUploadRecommendDirector.this.mHaveInitUploadHistory.compareAndSet(false, true)) {
                QZoneUploadRecommendDirector.this.G();
            }
            Integer num = (Integer) QZoneUploadRecommendDirector.this.mUploadHistoryMap.get(classifyId);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate
        public void insertMediaInfo(List<RFWMediaInfo> mediaInfos) {
            Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
            com.qzone.reborn.albumx.qzone.local.e.f52658a.g(mediaInfos);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate
        public List<RFWMediaInfo> query(String selection, String[] selectionArgs, String orderBy, String limit) {
            return com.qzone.reborn.albumx.qzone.local.e.f52658a.i(selection, selectionArgs, orderBy, limit);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendDbDelegate
        public void updateMediaInfo(List<RFWMediaInfo> mediaInfos) {
            Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
            com.qzone.reborn.albumx.qzone.local.e.f52658a.k(mediaInfos);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$d", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWUploadRecommendDelegate;", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendDbDelegate;", "getDbDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendLogDelegate;", "getLogDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendConfigDelegate;", "getConfigDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate;", "getPoiDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendReportDelegate;", "getReportDelegate", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements IRFWUploadRecommendDelegate {
        d() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate
        public IRFWRecommendConfigDelegate getConfigDelegate() {
            return QZoneUploadRecommendDirector.this.mConfigDelegate;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate
        public IRFWRecommendDbDelegate getDbDelegate() {
            return QZoneUploadRecommendDirector.this.mDbDelegate;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate
        public IRFWRecommendLogDelegate getLogDelegate() {
            return QZoneUploadRecommendDirector.this.mLogDelegate;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate
        public IRFWRecommendPoiDelegate getPoiDelegate() {
            return QZoneUploadRecommendDirector.this.getMPoiDelegate();
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate
        public IRFWRecommendReportDelegate getReportDelegate() {
            return QZoneUploadRecommendDirector.this.getMReportDelegate();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$e", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendLogDelegate;", "", "tag", "msg", "", "debug", "error", APMidasPayAPI.ENV_DEV, "", "t", "fatal", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements IRFWRecommendLogDelegate {
        e() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendLogDelegate
        public void debug(String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            RFWLog.d("qz_photo_recommend_" + tag, RFWLog.USR, msg2);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendLogDelegate
        public void dev(String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            RFWLog.d("qz_photo_recommend_" + tag, RFWLog.DEV, msg2);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendLogDelegate
        public void error(String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            RFWLog.e("qz_photo_recommend_" + tag, RFWLog.USR, msg2);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendLogDelegate
        public void fatal(String tag, Throwable t16) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(t16, "t");
            xe.b.f447841a.d(t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$f", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfos", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate$PoiCallBack;", "callBack", "", "getPoiByMediaInfo", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements IRFWRecommendPoiDelegate {
        f() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendPoiDelegate
        public void getPoiByMediaInfo(List<RFWMediaInfo> mediaInfos, IRFWRecommendPoiDelegate.PoiCallBack callBack) {
            Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            q.f52675a.d(mediaInfos, callBack);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/albumx/qzone/local/QZoneUploadRecommendDirector$g", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendReportDelegate;", "", "eventId", "", "", "params", "", "customReport", "getReportUin", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class g implements IRFWRecommendReportDelegate {
        g() {
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendReportDelegate
        public void customReport(String eventId, Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(params, "params");
            fo.c.c(eventId, params);
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendReportDelegate
        public String getReportUin() {
            String uinString = LoginData.getInstance().getUinString();
            Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
            return uinString;
        }
    }

    static {
        Lazy<QZoneUploadRecommendDirector> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneUploadRecommendDirector>() { // from class: com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QZoneUploadRecommendDirector invoke() {
                return new QZoneUploadRecommendDirector();
            }
        });
        f52643k = lazy;
    }

    public QZoneUploadRecommendDirector() {
        d dVar = new d();
        this.mDelegate = dVar;
        Application sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        super.init(sMobileQQ, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean A() {
        if (com.qzone.reborn.configx.g.f53821a.b().A1()) {
            return false;
        }
        Object systemService = BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService instanceof ActivityManager) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = null;
                if (runningAppProcesses != null) {
                    Iterator<T> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) next).processName, "com.tencent.mobileqq:peak")) {
                            runningAppProcessInfo = next;
                            break;
                        }
                    }
                    runningAppProcessInfo = runningAppProcessInfo;
                }
                return runningAppProcessInfo != null && runningAppProcessInfo.importance == 100;
            } catch (Throwable th5) {
                this.mLogDelegate.error("MediaRecommend_QZoneUploadRecommendDirector", "iSPeakProcessForeground: " + th5);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final QZoneUploadRecommendDirector this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<Boolean> k3 = QZoneForegroundForSubProcess.f52639a.k();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector$initTrigger$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                String str;
                String str2;
                boolean A;
                if (bool == null) {
                    return;
                }
                if (!bool.booleanValue()) {
                    A = QZoneUploadRecommendDirector.this.A();
                    if (!A) {
                        QZoneUploadRecommendDirector.this.stopRecommend();
                        return;
                    }
                }
                String uinString = LoginData.getInstance().getUinString();
                str = QZoneUploadRecommendDirector.this.mCurrentAcount;
                if (str != null) {
                    str2 = QZoneUploadRecommendDirector.this.mCurrentAcount;
                    if (!Intrinsics.areEqual(str2, uinString)) {
                        super/*com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2*/.reInit();
                    }
                }
                QZoneUploadRecommendDirector.this.mCurrentAcount = uinString;
                QZoneUploadRecommendDirector.this.startRecommend();
            }
        };
        k3.observeForever(new Observer() { // from class: com.qzone.reborn.albumx.qzone.local.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneUploadRecommendDirector.D(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(List paths, QZoneUploadRecommendDirector this$0) {
        Intrinsics.checkNotNullParameter(paths, "$paths");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        Iterator it = paths.iterator();
        while (it.hasNext()) {
            List<RFWMediaInfo> query = this$0.mDbDelegate.query("mPath=?", new String[]{(String) it.next()}, null, null);
            if (!query.isEmpty()) {
                query.get(0).setMUploadTime(currentTimeMillis);
                arrayList.add(query.get(0));
            }
        }
        this$0.mDbDelegate.insertMediaInfo(arrayList);
        this$0.mLogDelegate.debug("MediaRecommend_QZoneUploadRecommendDirector", "setUploadFlag updateList size: " + arrayList.size() + "\uff1bUploadTime:" + currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        long currentTimeMillis = System.currentTimeMillis();
        com.qzone.reborn.albumx.qzone.local.e eVar = com.qzone.reborn.albumx.qzone.local.e.f52658a;
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        List<QZoneUploadHistoryDbEntity> j3 = eVar.j("mUploadTime>? and mUploadTime<? and mUId=?", new String[]{String.valueOf(currentTimeMillis - RFWRecommendDateUtils.convertDayToTimeMillis(30)), String.valueOf(currentTimeMillis), uinString}, null, null);
        if (j3 != null) {
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                u((QZoneUploadHistoryDbEntity) it.next());
            }
        }
        this.mLogDelegate.debug("MediaRecommend_QZoneUploadRecommendDirector", "[tryInitUploadHistory] mUploadHistoryMap size:" + this.mUploadHistoryMap.size() + ",queryUploadHistory size:" + (j3 != null ? Integer.valueOf(j3.size()) : null));
    }

    private final void u(QZoneUploadHistoryDbEntity db5) {
        Integer num = this.mUploadHistoryMap.get(db5.mClassifyId);
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.mUploadHistoryMap;
        String str = db5.mClassifyId;
        Intrinsics.checkNotNullExpressionValue(str, "db.mClassifyId");
        concurrentHashMap.put(str, Integer.valueOf(intValue + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QZoneUploadRecommendDirector this$0, String classifyId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(classifyId, "$classifyId");
        this$0.mLogDelegate.debug("MediaRecommend_QZoneUploadRecommendDirector", "[appendUploadHistory] classifyId:" + classifyId);
        QZoneUploadHistoryDbEntity qZoneUploadHistoryDbEntity = new QZoneUploadHistoryDbEntity();
        qZoneUploadHistoryDbEntity.mClassifyId = classifyId;
        qZoneUploadHistoryDbEntity.mUploadTime = System.currentTimeMillis();
        qZoneUploadHistoryDbEntity.mUId = LoginData.getInstance().getUinString();
        this$0.u(qZoneUploadHistoryDbEntity);
        com.qzone.reborn.albumx.qzone.local.e.f52658a.h(qZoneUploadHistoryDbEntity);
    }

    public final void B() {
        QZoneForegroundForSubProcess qZoneForegroundForSubProcess = QZoneForegroundForSubProcess.f52639a;
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        qZoneForegroundForSubProcess.h(sMobileQQ);
        RFWRecommendThread.INSTANCE.getS_MAIN_HANDLER().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.m
            @Override // java.lang.Runnable
            public final void run() {
                QZoneUploadRecommendDirector.C(QZoneUploadRecommendDirector.this);
            }
        });
    }

    public final void E(final List<String> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        if (!com.qzone.reborn.albumx.qzone.local.g.f52662a.a()) {
            this.mLogDelegate.debug("MediaRecommend_QZoneUploadRecommendDirector", "setUploadFlag but switch is close");
        } else {
            RFWRecommendThread.INSTANCE.runOnRealTimeThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.p
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneUploadRecommendDirector.F(paths, this);
                }
            });
        }
    }

    public final void v(final String classifyId) {
        Intrinsics.checkNotNullParameter(classifyId, "classifyId");
        com.qzone.reborn.albumx.qzone.local.g gVar = com.qzone.reborn.albumx.qzone.local.g.f52662a;
        if (!gVar.a()) {
            this.mLogDelegate.debug("MediaRecommend_QZoneUploadRecommendDirector", "[appendUploadHistory] but function switch is close");
        } else if (!gVar.m()) {
            this.mLogDelegate.debug("MediaRecommend_QZoneUploadRecommendDirector", "[appendUploadHistory] but history switch is close");
        } else {
            RFWRecommendThread.INSTANCE.runOnRealTimeThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.local.n
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneUploadRecommendDirector.w(QZoneUploadRecommendDirector.this, classifyId);
                }
            });
        }
    }

    public final void x() {
        boolean b16 = o7.c.b();
        boolean j3 = com.qzone.reborn.albumx.qzone.local.g.f52662a.j();
        if (b16 && j3) {
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtainDownloadOption().setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/weinituijian-first-frame.png"));
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtainDownloadOption().setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/weinituijian-shouquan-animation.png"));
    }

    /* renamed from: y, reason: from getter */
    public final IRFWRecommendPoiDelegate getMPoiDelegate() {
        return this.mPoiDelegate;
    }

    /* renamed from: z, reason: from getter */
    public final IRFWRecommendReportDelegate getMReportDelegate() {
        return this.mReportDelegate;
    }
}
