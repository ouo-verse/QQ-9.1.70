package com.tencent.mobileqq.wink.publish;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.downloader.WinkQZoneMediaDownloader;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.util.m;
import com.tencent.mobileqq.wink.model.DailyInfo;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator;
import com.tencent.mobileqq.wink.publish.util.WinkDraftUtil;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.utils.am;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.wink.utils.o;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.model.params.ExportParams;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.LiteBanner;
import com.tencent.mobileqq.winkpublish.model.params.MaterialParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.MusicParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.report.OneClickPublishingFeedErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkNativeSessionManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.SizeF;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import e93.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import k93.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.lightAssetKit.components.Size;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<JZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J)\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0002JD\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0002JD\u0010\"\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J4\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J$\u0010+\u001a\u00020\u00122\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070)2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010)2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070)2\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J \u00104\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002J\u0010\u00105\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010J@\u00106\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\r\u001a\u00020\fJ@\u00107\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\r\u001a\u00020\fJ2\u00108\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J4\u0010:\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00142\b\b\u0002\u00109\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/wink/publish/OneClickPublishingHelper;", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editData", "", "publishSource", "editDataForExport", "", QQWinkConstants.COVER_PATH, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originMediaInfos", "", "needSaveNewDraft", "missionId", "content", "Landroid/os/Bundle;", "extras", "", "I", "", "mediaPaths", HippyTKDListViewAdapter.X, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QAdVrReportParams.ParamKey.MEDIA, "w", "Lk93/c;", "publishDraft", "H", "bundle", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "t", ReportConstant.COSTREPORT_PREFIX, "u", "G", "v", "Lcom/tencent/mobileqq/winkpublish/model/params/LiteBanner;", "o", "clientKey", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "r", "Ljava/util/HashMap;", "extInfo", "l", "cameraSessionId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "methodName", "Lcom/tencent/mobileqq/winkpublish/report/OneClickPublishingFeedErrorCode;", "errorCode", UserInfo.SEX_FEMALE, "B", BdhLogUtil.LogTag.Tag_Conn, "y", "E", "textContent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class OneClickPublishingHelper {

    /* renamed from: a */
    @NotNull
    public static final OneClickPublishingHelper f325628a = new OneClickPublishingHelper();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/publish/OneClickPublishingHelper$a", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements WinkPublishHelper2.Callback {

        /* renamed from: a */
        final /* synthetic */ WinkEditDataWrapper f325629a;

        /* renamed from: b */
        final /* synthetic */ String f325630b;

        /* renamed from: c */
        final /* synthetic */ Bundle f325631c;

        /* renamed from: d */
        final /* synthetic */ String f325632d;

        /* renamed from: e */
        final /* synthetic */ int f325633e;

        /* renamed from: f */
        final /* synthetic */ String f325634f;

        /* renamed from: g */
        final /* synthetic */ c f325635g;

        a(WinkEditDataWrapper winkEditDataWrapper, String str, Bundle bundle, String str2, int i3, String str3, c cVar) {
            this.f325629a = winkEditDataWrapper;
            this.f325630b = str;
            this.f325631c = bundle;
            this.f325632d = str2;
            this.f325633e = i3;
            this.f325634f = str3;
            this.f325635g = cVar;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            String str;
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(service, "service");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
            String m3 = oneClickPublishingHelper.m();
            w53.b.f("OneClickPublishingHelper", "[sendPublishTask] clientKey=" + uuid + ", cameraSessionId=" + m3);
            Wink.Companion companion = Wink.INSTANCE;
            z93.c f16 = companion.f();
            if (f16 == null || (str = f16.getTraceId()) == null) {
                str = "";
            }
            TaskInfo addTask = service.addTask(new WinkPublishParams(1, uuid, str, false, 23, oneClickPublishingHelper.v(this.f325629a, this.f325630b, this.f325631c), new ExportParams(this.f325632d, 0, false, 6, null), oneClickPublishingHelper.r(this.f325633e, this.f325634f, this.f325629a, uuid, this.f325631c), oneClickPublishingHelper.q(m3, this.f325631c), oneClickPublishingHelper.n(m3), 8, null));
            if (addTask != null) {
                int i3 = this.f325633e;
                WinkEditDataWrapper winkEditDataWrapper = this.f325629a;
                c cVar = this.f325635g;
                String str2 = this.f325630b;
                WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData("T_CATCH_IMPORTANT_INFO", addTask.getTraceId(), null, "scene_task_from", String.valueOf(i3), null, null, null, null, null, null, null, null, null, 0L, 32740, null);
                z93.c f17 = companion.f();
                if (f17 != null) {
                    f17.a(winkPublishQualityReportData, 1);
                }
                Integer from = winkEditDataWrapper.getFrom();
                if (from == null || from.intValue() != 7) {
                    Collection<LocalMediaInfo> values = cVar.g().values();
                    Intrinsics.checkNotNullExpressionValue(values, "publishDraft.selectedMediaInfoMap.values");
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(values);
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) firstOrNull;
                    if (localMediaInfo != null) {
                        localMediaInfo.thumbnailPath = str2;
                    }
                    ha3.b publishContent = new c.a(cVar.e(), cVar.d(), cVar.f(), cVar.g()).S(addTask.getTaskId()).F(cVar.b()).E(cVar.a()).G(cVar.c()).A().h();
                    publishContent.f404626k = 1;
                    WinkDraftUtil.Companion companion2 = WinkDraftUtil.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(publishContent, "publishContent");
                    companion2.o(publishContent);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/publish/OneClickPublishingHelper$b", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkPublishHelper2.Callback {

        /* renamed from: a */
        final /* synthetic */ WinkEditDataWrapper f325636a;

        /* renamed from: b */
        final /* synthetic */ String f325637b;

        /* renamed from: c */
        final /* synthetic */ Bundle f325638c;

        /* renamed from: d */
        final /* synthetic */ String f325639d;

        /* renamed from: e */
        final /* synthetic */ int f325640e;

        /* renamed from: f */
        final /* synthetic */ String f325641f;

        /* renamed from: g */
        final /* synthetic */ c f325642g;

        b(WinkEditDataWrapper winkEditDataWrapper, String str, Bundle bundle, String str2, int i3, String str3, c cVar) {
            this.f325636a = winkEditDataWrapper;
            this.f325637b = str;
            this.f325638c = bundle;
            this.f325639d = str2;
            this.f325640e = i3;
            this.f325641f = str3;
            this.f325642g = cVar;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            String str;
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(service, "service");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
            String m3 = oneClickPublishingHelper.m();
            w53.b.f("OneClickPublishingHelper", "[sendPublishTaskV2] clientKey=" + uuid + ", cameraSessionId=" + m3);
            Wink.Companion companion = Wink.INSTANCE;
            z93.c f16 = companion.f();
            if (f16 == null || (str = f16.getTraceId()) == null) {
                str = "";
            }
            TaskInfo addTask = service.addTask(new WinkPublishParams(1, uuid, str, false, 23, oneClickPublishingHelper.t(this.f325636a, this.f325637b, this.f325638c), new ExportParams(this.f325639d, 0, false, 6, null), oneClickPublishingHelper.r(this.f325640e, this.f325641f, this.f325636a, uuid, this.f325638c), oneClickPublishingHelper.q(m3, this.f325638c), oneClickPublishingHelper.n(m3), 8, null));
            if (addTask != null) {
                int i3 = this.f325640e;
                WinkEditDataWrapper winkEditDataWrapper = this.f325636a;
                c cVar = this.f325642g;
                String str2 = this.f325637b;
                WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData("T_CATCH_IMPORTANT_INFO", addTask.getTraceId(), null, "scene_task_from", String.valueOf(i3), null, null, null, null, null, null, null, null, null, 0L, 32740, null);
                z93.c f17 = companion.f();
                if (f17 != null) {
                    f17.a(winkPublishQualityReportData, 1);
                }
                Integer from = winkEditDataWrapper.getFrom();
                if (from == null || from.intValue() != 7) {
                    Collection<LocalMediaInfo> values = cVar.g().values();
                    Intrinsics.checkNotNullExpressionValue(values, "publishDraft.selectedMediaInfoMap.values");
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(values);
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) firstOrNull;
                    if (localMediaInfo != null) {
                        localMediaInfo.thumbnailPath = str2;
                    }
                    ha3.b publishContent = new c.a(cVar.e(), cVar.d(), cVar.f(), cVar.g()).S(addTask.getTaskId()).F(cVar.b()).E(cVar.a()).G(cVar.c()).A().h();
                    publishContent.f404626k = 1;
                    WinkDraftUtil.Companion companion2 = WinkDraftUtil.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(publishContent, "publishContent");
                    companion2.o(publishContent);
                }
            }
        }
    }

    OneClickPublishingHelper() {
    }

    public static /* synthetic */ void D(OneClickPublishingHelper oneClickPublishingHelper, int i3, String str, String str2, String str3, Bundle bundle, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str3 = "";
        }
        String str4 = str3;
        if ((i16 & 16) != 0) {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ((i16 & 32) != 0) {
            z16 = false;
        }
        oneClickPublishingHelper.C(i3, str, str2, str4, bundle2, z16);
    }

    public final void F(String str, int i3, OneClickPublishingFeedErrorCode oneClickPublishingFeedErrorCode) {
        w53.b.c("OneClickPublishingHelper", "[" + str + "] " + oneClickPublishingFeedErrorCode.getMessage());
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
            winkPublishQualityReportData.setRetCode(String.valueOf(oneClickPublishingFeedErrorCode.transformedCode()));
            winkPublishQualityReportData.setEventId("E_ONE_CLICK_PUBLISHING_FEED");
            winkPublishQualityReportData.setExt1(str);
            winkPublishQualityReportData.setExt2(String.valueOf(i3));
            winkPublishQualityReportData.setDesc(oneClickPublishingFeedErrorCode.getMessage());
            f16.a(winkPublishQualityReportData, 1);
        }
    }

    public final void G(int publishSource, String missionId, WinkEditDataWrapper editData, c publishDraft, String r152, String content, Bundle extras) {
        WinkPublishHelper2.INSTANCE.bindService(1, new a(editData, r152, extras, missionId, publishSource, content, publishDraft));
    }

    private final void H(int publishSource, String missionId, WinkEditDataWrapper editData, c publishDraft, String r152, String content, Bundle extras) {
        WinkPublishHelper2.INSTANCE.bindService(1, new b(editData, r152, extras, missionId, publishSource, content, publishDraft));
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I(WinkEditDataWrapper editData, int publishSource, WinkEditDataWrapper editDataForExport, String r119, ArrayList<LocalMediaInfo> originMediaInfos, boolean needSaveNewDraft, String missionId, String content, Bundle extras) {
        LocalMediaInfo localMediaInfo;
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        boolean z19;
        int collectionSizeOrDefault;
        WinkEditDataWrapper winkEditDataWrapper;
        String str2;
        Object firstOrNull;
        String str3 = r119;
        ArrayList<LocalMediaInfo> originMediaInfos2 = editData.getOriginMediaInfos();
        String str4 = null;
        if (originMediaInfos2 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) originMediaInfos2);
            localMediaInfo = (LocalMediaInfo) firstOrNull;
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo == null) {
            F("toPublishImageAndVideo", publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_FIRST_MEDIA_IS_NULL, null, 2, null));
            return;
        }
        LocalMediaInfo outMediaInfo = editDataForExport.getOutMediaInfo();
        if (outMediaInfo != null) {
            str4 = outMediaInfo.thumbnailPath;
        }
        boolean z26 = true;
        if (str4 != null && str4.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            str = str4;
        } else {
            if (str3 != null) {
                if (r119.length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    z17 = true;
                    if (z17 || !new File(str3).exists()) {
                        com.tencent.mobileqq.wink.editor.cover.b bVar = com.tencent.mobileqq.wink.editor.cover.b.f319709a;
                        WinkEditData winkEditData = editData.getEditDatas().get(0);
                        Intrinsics.checkNotNullExpressionValue(winkEditData, "editData.editDatas[0]");
                        str3 = bVar.a(winkEditData, com.tencent.mobileqq.wink.editor.draft.c.r(editData));
                        if (str3 == null && str3.length() != 0) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (z18) {
                            if (i.I(localMediaInfo)) {
                                str3 = PublishVideoUtils.getVideoCover(localMediaInfo.path);
                            } else {
                                str3 = localMediaInfo.path;
                            }
                        }
                    }
                    str = str3;
                }
            }
            z17 = false;
            if (z17) {
            }
            com.tencent.mobileqq.wink.editor.cover.b bVar2 = com.tencent.mobileqq.wink.editor.cover.b.f319709a;
            WinkEditData winkEditData2 = editData.getEditDatas().get(0);
            Intrinsics.checkNotNullExpressionValue(winkEditData2, "editData.editDatas[0]");
            str3 = bVar2.a(winkEditData2, com.tencent.mobileqq.wink.editor.draft.c.r(editData));
            if (str3 == null) {
            }
            z18 = true;
            if (z18) {
            }
            str = str3;
        }
        if (str != null && str.length() != 0) {
            z26 = false;
        }
        if (!z26) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(originMediaInfos, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = originMediaInfos.iterator();
            while (it.hasNext()) {
                arrayList.add(((LocalMediaInfo) it.next()).path);
            }
            List<LocalMediaInfo> i3 = o.f326724a.i(arrayList);
            if (i3.isEmpty()) {
                F("toPublishImageAndVideo", publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_PATH_TO_LOCALMEDIAINFO_FAILED, null, 2, null));
                return;
            }
            if (needSaveNewDraft) {
                String d26 = u.d2();
                Intrinsics.checkNotNullExpressionValue(d26, "formatMissionId()");
                WinkEditDataWrapper copy$default = WinkEditDataWrapper.copy$default(editData, d26, null, null, null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -2, 4095, null);
                com.tencent.mobileqq.wink.editor.draft.a.h(copy$default, d26);
                com.tencent.mobileqq.wink.editor.draft.a.i(WinkEditDataWrapper.copy$default(editDataForExport, d26, null, null, null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -2, 4095, null), d26);
                winkEditDataWrapper = copy$default;
                str2 = d26;
            } else {
                winkEditDataWrapper = editData;
                str2 = missionId;
            }
            H(publishSource, str2, winkEditDataWrapper, WinkDraftGenerator.r(WinkDraftGenerator.f325956a, str2, content, i3, false, true, 8, null), str, content, extras);
            return;
        }
        F("toPublishImageAndVideo", publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_GEN_COVER_FAILED, null, 2, null));
    }

    private final void l(HashMap<String, String> extInfo, WinkEditDataWrapper editData) {
        InteractiveModel challengeData;
        if (!editData.getEditDatas().isEmpty()) {
            Iterator<WinkEditData> it = editData.getEditDatas().iterator();
            while (it.hasNext()) {
                WinkEditData next = it.next();
                if (com.tencent.mobileqq.wink.model.b.f324006a.f() && (challengeData = next.getChallengeData()) != null) {
                    extInfo.put("challenge_tagTitle", challengeData.getTagName());
                    extInfo.put("challenge_rotation", String.valueOf(challengeData.getRotation()));
                    extInfo.put("challenge_scale", String.valueOf(challengeData.getScale()));
                    extInfo.put("challenge_positionX", String.valueOf(challengeData.getXAxisPercentage()));
                    extInfo.put("challenge_positionY", String.valueOf(challengeData.getYAxisPercentage()));
                    w53.b.a("OneClickPublishingHelper", "fillChallengeExtInfo... tag: " + challengeData.getTagName() + " rotation:" + challengeData.getRotation() + " scale:" + challengeData.getScale() + " positionX:" + challengeData.getXAxisPercentage() + " positionY:" + challengeData.getYAxisPercentage());
                }
            }
        }
    }

    public final String m() {
        String str;
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null && !Intrinsics.areEqual(str, "none")) {
            return str;
        }
        String cameraSessionId = WinkNativeSessionManager.g().getCameraSessionId();
        Intrinsics.checkNotNullExpressionValue(cameraSessionId, "g().cameraSessionId");
        return cameraSessionId;
    }

    public final HashMap<String, String> n(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, str);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022 A[Catch: Exception -> 0x0010, TryCatch #0 {Exception -> 0x0010, blocks: (B:25:0x0005, B:5:0x0015, B:12:0x0022, B:13:0x0036, B:15:0x003c), top: B:24:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final LiteBanner o(Bundle bundle) {
        String string;
        boolean z16;
        if (bundle != null) {
            try {
                string = bundle.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_KEY_STATUS_SYNC_INFO, "");
            } catch (Exception e16) {
                QLog.e("OneClickPublishingHelper", 1, 1, "[getLiteBanner] " + e16);
                return null;
            }
        } else {
            string = null;
        }
        if (string != null && string.length() != 0) {
            z16 = false;
            if (!z16) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            LiteBanner liteBanner = new LiteBanner(null, 1, null);
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String it = (String) keys.next();
                HashMap<String, String> extInfo = liteBanner.getExtInfo();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String string2 = jSONObject.getString(it);
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(it)");
                extInfo.put(it, string2);
            }
            return liteBanner;
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final HashMap<String, String> p(Bundle extras) {
        Serializable serializable;
        if (extras != null) {
            serializable = extras.getSerializable("key_attrs");
        } else {
            serializable = null;
        }
        if (!(serializable instanceof HashMap)) {
            return null;
        }
        return (HashMap) serializable;
    }

    public final Bundle q(String str, Bundle bundle) {
        String str2;
        String string;
        String string2;
        String string3;
        String string4;
        Bundle bundle2 = new Bundle();
        bundle2.putString(QQWinkConstants.PUBLISH_TRANS_PARAMS_CAMERA_SESSION_ID, str);
        if (bundle != null && (string4 = bundle.getString(QQWinkConstants.WINK_PUBLISH_TASK_ID, null)) != null) {
            bundle2.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, string4);
        }
        if (bundle != null && (string3 = bundle.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, null)) != null) {
            bundle2.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, string3);
        }
        if (bundle != null && (string2 = bundle.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, null)) != null) {
            bundle2.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, string2);
        }
        if (bundle != null && (string = bundle.getString("publish_trans_tag", null)) != null) {
            bundle2.putString("publish_trans_tag", string);
        }
        HashMap<String, String> p16 = f325628a.p(bundle);
        if (p16 != null && (str2 = p16.get("taskid")) != null) {
            bundle2.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, str2);
        }
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final FeedParams r(int publishSource, String content, WinkEditDataWrapper editData, String clientKey, Bundle extras) {
        boolean z16;
        Long musicId;
        long j3;
        String musicName;
        String str;
        String selectMusicMid;
        String str2;
        Integer selectMusicStart;
        HashMap<String, String> hashMap;
        String str3;
        Object firstOrNull;
        WinkEditData winkEditData;
        HashMap<String, String> p16;
        String str4;
        int length;
        int i3;
        int i16;
        boolean z17;
        String str5;
        Map<String, MetaMaterial> templateMaterialMap;
        Set<String> keySet;
        Object firstOrNull2;
        String str6;
        String string;
        String string2;
        boolean z18;
        ar arVar = ar.f326685a;
        if (arVar.e(arVar.k(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA), 0) != 1) {
            if (extras != null) {
                z18 = extras.getBoolean(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA, false);
            } else {
                z18 = false;
            }
            if (!z18) {
                z16 = false;
                HashMap hashMap2 = new HashMap();
                hashMap2.put(QCircleLpReportDc05494.KEY_UP_TYPE, "2");
                hashMap2.put("up_source", String.valueOf(publishSource));
                hashMap2.put(v4.b.CLIENTKEY, clientKey);
                musicId = editData.getMusicId();
                long j16 = 0;
                if (musicId == null) {
                    j3 = musicId.longValue();
                } else {
                    j3 = 0;
                }
                musicName = editData.getMusicName();
                if (musicName != null) {
                    str = "";
                } else {
                    str = musicName;
                }
                selectMusicMid = editData.getSelectMusicMid();
                if (selectMusicMid != null) {
                    str2 = "";
                } else {
                    str2 = selectMusicMid;
                }
                selectMusicStart = editData.getSelectMusicStart();
                if (selectMusicStart != null) {
                    j16 = selectMusicStart.intValue();
                }
                MusicParams musicParams = new MusicParams(j3, str2, str, j16, 0, "");
                w53.b.f("OneClickPublishingHelper", "musicParams=" + musicParams);
                hashMap = new HashMap<>();
                DailyInfo dailyInfo = null;
                if (extras != null && (string2 = extras.getString(QQWinkConstants.WINK_PUBLISH_PARAM_TASK_ID, null)) != null) {
                    hashMap.put("tianshu_info", "{\"task_id\":\"" + string2 + "\"}");
                }
                if (extras != null && (string = extras.getString(QQWinkConstants.WINK_PUBLISH_PARAM_CLIENT_KEY, null)) != null) {
                    hashMap.put(v4.b.CLIENTKEY, string);
                }
                if (extras == null) {
                    str3 = extras.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, null);
                } else {
                    str3 = null;
                }
                boolean areEqual = Intrinsics.areEqual(str3, "1");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) editData.getEditDatas());
                winkEditData = (WinkEditData) firstOrNull;
                if (winkEditData != null && (templateMaterialMap = winkEditData.getTemplateMaterialMap()) != null && (keySet = templateMaterialMap.keySet()) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull(keySet);
                    str6 = (String) firstOrNull2;
                    if (str6 != null) {
                        hashMap.put("tmpl_id", str6);
                    }
                }
                if (!hashMap.isEmpty()) {
                    w53.b.f("OneClickPublishingHelper", "extInfo=" + hashMap);
                }
                hashMap.put("xsj_picture_num", String.valueOf(com.tencent.mobileqq.wink.editor.draft.c.o(editData).first));
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, String.valueOf(com.tencent.mobileqq.wink.editor.draft.c.o(editData).second));
                l(hashMap, editData);
                p16 = p(extras);
                if (p16 != null || (str5 = p16.get(QCircleScheme.AttrQQPublish.TIANSHU_ACTIVITY_ITEM_VALUE)) == null) {
                    str4 = "";
                } else {
                    str4 = str5;
                }
                if (extras != null) {
                    dailyInfo = (DailyInfo) extras.getParcelable(QQWinkConstants.WINK_PUBLISH_PARAM_DAILY_PARAMS);
                }
                DailyInfo dailyInfo2 = dailyInfo;
                w53.b.f("OneClickPublishingHelper", "dailyParams=" + dailyInfo2);
                length = content.length() - 1;
                i3 = 0;
                boolean z19 = false;
                while (i3 <= length) {
                    if (!z19) {
                        i16 = i3;
                    } else {
                        i16 = length;
                    }
                    if (Intrinsics.compare((int) content.charAt(i16), 32) <= 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z19) {
                        if (!z17) {
                            z19 = true;
                        } else {
                            i3++;
                        }
                    } else {
                        if (!z17) {
                            break;
                        }
                        length--;
                    }
                }
                return new FeedParams(null, content.subSequence(i3, length + 1).toString(), areEqual, false, z16, null, null, null, false, null, null, musicParams, null, null, null, null, 0, null, hashMap, hashMap2, false, str4, o(extras), null, null, null, dailyInfo2, 60028905, null);
            }
        }
        z16 = true;
        HashMap hashMap22 = new HashMap();
        hashMap22.put(QCircleLpReportDc05494.KEY_UP_TYPE, "2");
        hashMap22.put("up_source", String.valueOf(publishSource));
        hashMap22.put(v4.b.CLIENTKEY, clientKey);
        musicId = editData.getMusicId();
        long j162 = 0;
        if (musicId == null) {
        }
        musicName = editData.getMusicName();
        if (musicName != null) {
        }
        selectMusicMid = editData.getSelectMusicMid();
        if (selectMusicMid != null) {
        }
        selectMusicStart = editData.getSelectMusicStart();
        if (selectMusicStart != null) {
        }
        MusicParams musicParams2 = new MusicParams(j3, str2, str, j162, 0, "");
        w53.b.f("OneClickPublishingHelper", "musicParams=" + musicParams2);
        hashMap = new HashMap<>();
        DailyInfo dailyInfo3 = null;
        if (extras != null) {
            hashMap.put("tianshu_info", "{\"task_id\":\"" + string2 + "\"}");
        }
        if (extras != null) {
            hashMap.put(v4.b.CLIENTKEY, string);
        }
        if (extras == null) {
        }
        boolean areEqual2 = Intrinsics.areEqual(str3, "1");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) editData.getEditDatas());
        winkEditData = (WinkEditData) firstOrNull;
        if (winkEditData != null) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull(keySet);
            str6 = (String) firstOrNull2;
            if (str6 != null) {
            }
        }
        if (!hashMap.isEmpty()) {
        }
        hashMap.put("xsj_picture_num", String.valueOf(com.tencent.mobileqq.wink.editor.draft.c.o(editData).first));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, String.valueOf(com.tencent.mobileqq.wink.editor.draft.c.o(editData).second));
        l(hashMap, editData);
        p16 = p(extras);
        if (p16 != null) {
        }
        str4 = "";
        if (extras != null) {
        }
        DailyInfo dailyInfo22 = dailyInfo3;
        w53.b.f("OneClickPublishingHelper", "dailyParams=" + dailyInfo22);
        length = content.length() - 1;
        i3 = 0;
        boolean z192 = false;
        while (i3 <= length) {
        }
        return new FeedParams(null, content.subSequence(i3, length + 1).toString(), areEqual2, false, z16, null, null, null, false, null, null, musicParams2, null, null, null, null, 0, null, hashMap, hashMap22, false, str4, o(extras), null, null, null, dailyInfo22, 60028905, null);
    }

    private final List<MediaParams> s(WinkEditDataWrapper winkEditDataWrapper, Bundle bundle, String str) {
        Serializable serializable;
        Serializable serializable2;
        List<? extends WinkPublishMediaRecord> list;
        if (bundle != null) {
            serializable = bundle.getSerializable(QQWinkConstants.TEMP_PARAMS_LOCAL_MEDIA_INFO_LIST);
        } else {
            serializable = null;
        }
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.activity.photo.LocalMediaInfo>");
        ArrayList arrayList = (ArrayList) serializable;
        if (bundle != null) {
            serializable2 = bundle.getSerializable(QQWinkConstants.PUBLISH_EDIT_WINK_PUBLISH_DATA);
        } else {
            serializable2 = null;
        }
        Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord>>");
        ArrayList arrayList2 = (ArrayList) serializable2;
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = arrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj, "mediaInfos[i]");
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
            if (arrayList2.size() > i3) {
                list = (List) arrayList2.get(i3);
            } else {
                list = null;
            }
            if (AlbumUtil.isImage(localMediaInfo)) {
                arrayList3.add(ImageParams.INSTANCE.from(localMediaInfo, list));
            }
        }
        return arrayList3;
    }

    public final List<MediaParams> t(WinkEditDataWrapper editData, String r56, Bundle bundle) {
        w53.b.f("OneClickPublishingHelper", "[prepareMediaParams] mode:" + editData.getEditMode());
        Integer editMode = editData.getEditMode();
        if (editMode != null && editMode.intValue() == 0) {
            return u(editData, bundle, r56);
        }
        return s(editData, bundle, r56);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
    
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<MediaParams> u(WinkEditDataWrapper editData, Bundle bundle, String r28) {
        Object firstOrNull;
        String str;
        List<MediaParams> listOf;
        List listOf2;
        List listOf3;
        String string;
        List listOf4;
        Collection<WinkStickerModel> values;
        int collectionSizeOrDefault;
        List list;
        boolean z16;
        Collection<WinkStickerModel> values2;
        int collectionSizeOrDefault2;
        List list2;
        boolean z17;
        List list3;
        List list4;
        String str2;
        SizeF sizeF;
        Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(editData);
        Size b16 = m.f322645a.b();
        ArrayList arrayList = new ArrayList();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) editData.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) firstOrNull;
        boolean z18 = true;
        if (winkEditData != null) {
            BackgroundModel backgroundModel = winkEditData.getMediaModel().backgroundModel;
            if (backgroundModel != null && (sizeF = backgroundModel.renderSize) != null) {
                b16 = new Size((int) sizeF.width, (int) sizeF.height);
            }
            Map<String, MetaMaterial> templateMaterialMap = winkEditData.getTemplateMaterialMap();
            if (templateMaterialMap != null && (r6 = templateMaterialMap.keySet()) != null && list4 != null) {
                Integer from = editData.getFrom();
                if (from != null && from.intValue() == 5) {
                    str2 = "libTemplate";
                } else {
                    str2 = "template";
                }
                arrayList.add(new MaterialParams(str2, list4));
            }
            Map<String, MetaMaterial> filterMaterialMap = winkEditData.getFilterMaterialMap();
            if (filterMaterialMap != null && (r6 = filterMaterialMap.keySet()) != null && list3 != null) {
                arrayList.add(new MaterialParams("filter", list3));
            }
            Map<String, WinkStickerModel> stickerModelMap = winkEditData.getStickerModelMap();
            if (stickerModelMap != null && (values2 = stickerModelMap.values()) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : values2) {
                    WinkStickerModel winkStickerModel = (WinkStickerModel) obj;
                    if (winkStickerModel.getMaterial() != null && !winkStickerModel.isTextSticker() && !Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(winkStickerModel.getMaterial()), "CATEGORY_TEXT_DECOR")) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    MetaMaterial material = ((WinkStickerModel) it.next()).getMaterial();
                    Intrinsics.checkNotNull(material);
                    arrayList3.add(material.f30533id);
                }
                list2 = CollectionsKt___CollectionsKt.toList(arrayList3);
                if (list2 != null) {
                    arrayList.add(new MaterialParams("sticker", list2));
                }
            }
            Map<String, WinkStickerModel> stickerModelMap2 = winkEditData.getStickerModelMap();
            if (stickerModelMap2 != null && (values = stickerModelMap2.values()) != null) {
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : values) {
                    WinkStickerModel winkStickerModel2 = (WinkStickerModel) obj2;
                    if (winkStickerModel2.getMaterial() != null && (winkStickerModel2.isTextSticker() || Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(winkStickerModel2.getMaterial()), "CATEGORY_TEXT_DECOR"))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList4.add(obj2);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
                ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = arrayList4.iterator();
                while (it5.hasNext()) {
                    MetaMaterial material2 = ((WinkStickerModel) it5.next()).getMaterial();
                    Intrinsics.checkNotNull(material2);
                    arrayList5.add(material2.f30533id);
                }
                list = CollectionsKt___CollectionsKt.toList(arrayList5);
                if (list != null) {
                    arrayList.add(new MaterialParams("text", list));
                }
            }
        }
        if (bundle != null && (string = bundle.getString("captureMaterialId")) != null) {
            if (string.length() <= 0) {
                z18 = false;
            }
            if (z18) {
                listOf4 = CollectionsKt__CollectionsJVMKt.listOf(string);
                arrayList.add(new MaterialParams("meterial", listOf4));
            }
        }
        String captureMaterialId = editData.getCaptureMaterialId();
        if (captureMaterialId != null) {
            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(captureMaterialId);
            arrayList.add(new MaterialParams("meterial", listOf3));
        }
        if (bundle != null) {
            String string2 = bundle.getString(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_TYPE);
            String string3 = bundle.getString(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_ID);
            if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string2)) {
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(string3);
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(string3);
                arrayList.add(new MaterialParams(string2, listOf2));
            }
        }
        LocalMediaInfo outMediaInfo = editData.getOutMediaInfo();
        if (outMediaInfo != null) {
            str = outMediaInfo.path;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str3 = str;
        int i3 = b16.width;
        int i16 = b16.height;
        Integer first = (Integer) r26.first;
        Integer second = (Integer) r26.second;
        long duration = editData.getDuration() / 1000;
        Intrinsics.checkNotNullExpressionValue(first, "first");
        int intValue = first.intValue();
        Intrinsics.checkNotNullExpressionValue(second, "second");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new VideoParams(str3, i3, i16, 0L, 0L, r28, intValue, second.intValue(), duration, 0, "video/mp4", false, false, null, null, arrayList, 30720, null));
        return listOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
    
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<MediaParams> v(WinkEditDataWrapper editData, String r27, Bundle bundle) {
        Object firstOrNull;
        String str;
        List<MediaParams> listOf;
        List listOf2;
        List listOf3;
        String string;
        List listOf4;
        Collection<WinkStickerModel> values;
        int collectionSizeOrDefault;
        List list;
        boolean z16;
        Collection<WinkStickerModel> values2;
        int collectionSizeOrDefault2;
        List list2;
        boolean z17;
        List list3;
        List list4;
        String str2;
        SizeF sizeF;
        Pair<Integer, Integer> r26 = WinkExtractCoverViewModel.r2(editData);
        Size b16 = m.f322645a.b();
        ArrayList arrayList = new ArrayList();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) editData.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) firstOrNull;
        boolean z18 = true;
        if (winkEditData != null) {
            BackgroundModel backgroundModel = winkEditData.getMediaModel().backgroundModel;
            if (backgroundModel != null && (sizeF = backgroundModel.renderSize) != null) {
                b16 = new Size((int) sizeF.width, (int) sizeF.height);
            }
            Map<String, MetaMaterial> templateMaterialMap = winkEditData.getTemplateMaterialMap();
            if (templateMaterialMap != null && (r6 = templateMaterialMap.keySet()) != null && list4 != null) {
                Integer from = editData.getFrom();
                if (from != null && from.intValue() == 5) {
                    str2 = "libTemplate";
                } else {
                    str2 = "template";
                }
                arrayList.add(new MaterialParams(str2, list4));
            }
            Map<String, MetaMaterial> filterMaterialMap = winkEditData.getFilterMaterialMap();
            if (filterMaterialMap != null && (r6 = filterMaterialMap.keySet()) != null && list3 != null) {
                arrayList.add(new MaterialParams("filter", list3));
            }
            Map<String, WinkStickerModel> stickerModelMap = winkEditData.getStickerModelMap();
            if (stickerModelMap != null && (values2 = stickerModelMap.values()) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : values2) {
                    WinkStickerModel winkStickerModel = (WinkStickerModel) obj;
                    if (winkStickerModel.getMaterial() != null && !winkStickerModel.isTextSticker() && !Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(winkStickerModel.getMaterial()), "CATEGORY_TEXT_DECOR")) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    MetaMaterial material = ((WinkStickerModel) it.next()).getMaterial();
                    Intrinsics.checkNotNull(material);
                    arrayList3.add(material.f30533id);
                }
                list2 = CollectionsKt___CollectionsKt.toList(arrayList3);
                if (list2 != null) {
                    arrayList.add(new MaterialParams("sticker", list2));
                }
            }
            Map<String, WinkStickerModel> stickerModelMap2 = winkEditData.getStickerModelMap();
            if (stickerModelMap2 != null && (values = stickerModelMap2.values()) != null) {
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : values) {
                    WinkStickerModel winkStickerModel2 = (WinkStickerModel) obj2;
                    if (winkStickerModel2.getMaterial() != null && (winkStickerModel2.isTextSticker() || Intrinsics.areEqual(com.tencent.mobileqq.wink.editor.c.o(winkStickerModel2.getMaterial()), "CATEGORY_TEXT_DECOR"))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList4.add(obj2);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
                ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = arrayList4.iterator();
                while (it5.hasNext()) {
                    MetaMaterial material2 = ((WinkStickerModel) it5.next()).getMaterial();
                    Intrinsics.checkNotNull(material2);
                    arrayList5.add(material2.f30533id);
                }
                list = CollectionsKt___CollectionsKt.toList(arrayList5);
                if (list != null) {
                    arrayList.add(new MaterialParams("text", list));
                }
            }
        }
        if (bundle != null && (string = bundle.getString("captureMaterialId")) != null) {
            if (string.length() <= 0) {
                z18 = false;
            }
            if (z18) {
                listOf4 = CollectionsKt__CollectionsJVMKt.listOf(string);
                arrayList.add(new MaterialParams("meterial", listOf4));
            }
        }
        String captureMaterialId = editData.getCaptureMaterialId();
        if (captureMaterialId != null) {
            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(captureMaterialId);
            arrayList.add(new MaterialParams("meterial", listOf3));
        }
        if (bundle != null) {
            String string2 = bundle.getString(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_TYPE);
            String string3 = bundle.getString(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_ID);
            if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string2)) {
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(string3);
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(string3);
                arrayList.add(new MaterialParams(string2, listOf2));
            }
        }
        LocalMediaInfo outMediaInfo = editData.getOutMediaInfo();
        if (outMediaInfo != null) {
            str = outMediaInfo.path;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str3 = str;
        int i3 = b16.width;
        int i16 = b16.height;
        Integer first = (Integer) r26.first;
        Integer second = (Integer) r26.second;
        long duration = editData.getDuration() / 1000;
        Intrinsics.checkNotNullExpressionValue(first, "first");
        int intValue = first.intValue();
        Intrinsics.checkNotNullExpressionValue(second, "second");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new VideoParams(str3, i3, i16, 0L, 0L, r27, intValue, second.intValue(), duration, 0, "video/mp4", false, false, null, null, arrayList, 30720, null));
        return listOf;
    }

    public final void w(List<? extends LocalMediaInfo> r56) {
        ArrayList<LocalMediaInfo> arrayList = new ArrayList();
        for (Object obj : r56) {
            if (i.F((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        for (LocalMediaInfo localMediaInfo : arrayList) {
            am amVar = am.f326679a;
            String str = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str, "it.path");
            String a16 = amVar.a(str);
            if (a16 != null) {
                localMediaInfo.path = a16;
                localMediaInfo.mMimeType = "image/jpeg";
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object x(List<String> list, Continuation<? super List<String>> continuation) {
        OneClickPublishingHelper$processQZoneMedia$1 oneClickPublishingHelper$processQZoneMedia$1;
        Object coroutine_suspended;
        int i3;
        boolean startsWith$default;
        Map map;
        int collectionSizeOrDefault;
        if (continuation instanceof OneClickPublishingHelper$processQZoneMedia$1) {
            oneClickPublishingHelper$processQZoneMedia$1 = (OneClickPublishingHelper$processQZoneMedia$1) continuation;
            int i16 = oneClickPublishingHelper$processQZoneMedia$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                oneClickPublishingHelper$processQZoneMedia$1.label = i16 - Integer.MIN_VALUE;
                Object obj = oneClickPublishingHelper$processQZoneMedia$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = oneClickPublishingHelper$processQZoneMedia$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        list = (List) oneClickPublishingHelper$processQZoneMedia$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) obj2, "http", false, 2, null);
                        if (startsWith$default) {
                            arrayList.add(obj2);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return list;
                    }
                    WinkQZoneMediaDownloader winkQZoneMediaDownloader = WinkQZoneMediaDownloader.f318202a;
                    oneClickPublishingHelper$processQZoneMedia$1.L$0 = list;
                    oneClickPublishingHelper$processQZoneMedia$1.label = 1;
                    obj = winkQZoneMediaDownloader.b(arrayList, oneClickPublishingHelper$processQZoneMedia$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                map = (Map) obj;
                if (map != null) {
                    return null;
                }
                List<String> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (String str : list2) {
                    String str2 = (String) map.get(str);
                    if (str2 != null) {
                        str = str2;
                    }
                    arrayList2.add(str);
                }
                return arrayList2;
            }
        }
        oneClickPublishingHelper$processQZoneMedia$1 = new OneClickPublishingHelper$processQZoneMedia$1(this, continuation);
        Object obj3 = oneClickPublishingHelper$processQZoneMedia$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = oneClickPublishingHelper$processQZoneMedia$1.label;
        if (i3 == 0) {
        }
        map = (Map) obj3;
        if (map != null) {
        }
    }

    public static /* synthetic */ void z(OneClickPublishingHelper oneClickPublishingHelper, int i3, String str, String str2, String str3, Bundle bundle, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str3 = "";
        }
        String str4 = str3;
        if ((i16 & 16) != 0) {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ((i16 & 32) != 0) {
            z16 = false;
        }
        oneClickPublishingHelper.y(i3, str, str2, str4, bundle2, z16);
    }

    public final void A(int i3, @Nullable List<String> list, @NotNull String textContent, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new OneClickPublishingHelper$publishContentText$1(textContent, list, i3, bundle, null), 3, null);
    }

    public final boolean B(@Nullable Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(QQWinkConstants.WINK_PUBLISH_TYPE);
        int i3 = bundle.getInt(QQWinkConstants.WINK_PUBLISH_SOURCE, 0);
        w53.b.f("OneClickPublishingHelper", "[publishFeed] type=" + string);
        if (string == null) {
            return false;
        }
        int hashCode = string.hashCode();
        if (hashCode != 21718227) {
            if (hashCode != 970761897) {
                if (hashCode != 2095754356 || !string.equals(QQWinkConstants.WINK_PUBLISH_BY_EDIT_DRAFT)) {
                    return false;
                }
                String string2 = bundle.getString(QQWinkConstants.MISSION_ID, "");
                Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(QQWinkConstants.MISSION_ID, \"\")");
                String string3 = bundle.getString(QQWinkConstants.WINK_PUBLISH_PARAM_COVER_PATH, "");
                String string4 = bundle.getString(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT, "");
                Intrinsics.checkNotNullExpressionValue(string4, "bundle.getString(QQWinkC\u2026UBLISH_PARAM_CONTENT, \"\")");
                y(i3, string2, string3, string4, bundle, true);
            } else {
                if (!string.equals(QQWinkConstants.WINK_PUBLISH_WITH_RECOMMEND_MUSIC)) {
                    return false;
                }
                List<String> stringArrayList = bundle.getStringArrayList(QQWinkConstants.WINK_PUBLISH_PARAM_MEDIA_PATH_LIST);
                if (stringArrayList == null) {
                    stringArrayList = CollectionsKt__CollectionsKt.emptyList();
                }
                String string5 = bundle.getString(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT, "");
                Intrinsics.checkNotNullExpressionValue(string5, "bundle.getString(QQWinkC\u2026UBLISH_PARAM_CONTENT, \"\")");
                E(i3, stringArrayList, string5, bundle);
            }
        } else {
            if (!string.equals(QQWinkConstants.WINK_PUBLISH_CONTENT_TEXT)) {
                return false;
            }
            String string6 = bundle.getString(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT, "");
            Intrinsics.checkNotNullExpressionValue(string6, "bundle.getString(QQWinkC\u2026UBLISH_PARAM_CONTENT, \"\")");
            A(i3, null, string6, bundle);
        }
        return true;
    }

    public final void C(int i3, @NotNull String missionId, @Nullable String str, @NotNull String content, @Nullable Bundle bundle, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(content, "content");
        if (missionId.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new OneClickPublishingHelper$publishToQCircle$1(missionId, "publishToQCircle", i3, str, z16, content, bundle, null), 3, null);
        } else {
            F("publishToQCircle", i3, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_MISSION_ID_IS_EMPTY, null, 2, null));
        }
    }

    public final void E(int publishSource, @NotNull List<String> mediaPaths, @NotNull String content, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(mediaPaths, "mediaPaths");
        Intrinsics.checkNotNullParameter(content, "content");
        if (!mediaPaths.isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new OneClickPublishingHelper$publishWithRecommendMusic$1(mediaPaths, publishSource, extras, content, null), 3, null);
        } else {
            F("publishWithRecommendMusic", publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_MEDIA_PATHS_IS_NULL, null, 2, null));
        }
    }

    public final void y(int publishSource, @NotNull String missionId, @Nullable String r16, @NotNull String content, @Nullable Bundle extras, boolean needSaveNewDraft) {
        boolean z16;
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        Intrinsics.checkNotNullParameter(content, "content");
        if (missionId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new OneClickPublishingHelper$publishByEditDraft$1(missionId, publishSource, extras, content, r16, needSaveNewDraft, null), 3, null);
        } else {
            F("publishByEditDraft", publishSource, new OneClickPublishingFeedErrorCode(OneClickPublishingFeedErrorCode.ERROR_CODE_MISSION_ID_IS_EMPTY, null, 2, null));
        }
    }
}
