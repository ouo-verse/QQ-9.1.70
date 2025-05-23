package com.tencent.mobileqq.wink.editor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.pref.api.IPhoneConfig;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.nextbtn.DailyNextBtnPart;
import com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.videocut.model.TextItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aj\u0010\u0012\u001a\u00020\u00112\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u001a\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u001aH\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\u0001\u001a\u00020\u00002\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0002\u001a \u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u001a\u001e\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001a \u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u001e\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u001a\u0012\u0010&\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0012\u0010'\u001a\u00020\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001az\u00101\u001a\u00020\u00112\u0006\u0010)\u001a\u00020(2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010+\u001a\u00020*2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\"2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u00020\u0006\u001a\u0012\u00102\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0012\u00103\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0012\u00104\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002\u001a\u0016\u00105\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u001aV\u0010A\u001a\u0002082\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00172\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u0002082\u0006\u0010=\u001a\u0002082\u0006\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0017\u001a \u0010E\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u00172\b\b\u0002\u0010D\u001a\u00020\"\u001a\u0014\u0010H\u001a\u00020\u00112\f\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u001f\u001a\u000e\u0010J\u001a\u0002082\u0006\u0010I\u001a\u00020\u0006\u001a.\u0010P\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\"2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\"\u001a6\u0010T\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u00172\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001d2\b\b\u0002\u0010S\u001a\u00020\u0017\u001a0\u0010Y\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020*2\u0006\u0010V\u001a\u00020U2\u0006\u0010X\u001a\u00020W\u001a\u000e\u0010Z\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004\"2\u0010]\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002080\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u000208`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006^"}, d2 = {"Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "", "isFromTemplateColl", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "template", "isFromAutoTemplate", "isFromZShow", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "inputMedia", "isOpeningEndingMode", "", "H", "Landroid/content/Intent;", "intent", "t", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "l", "Lcom/tencent/mobileqq/wink/editor/dr;", "curTavCut", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "i", "Lkotlin/Pair;", "", "p", ReportConstant.COSTREPORT_PREFIX, "r", "j", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;", "btnPart", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "filter", "filterRangeMode", "isSyncHighLight", "content", "isNextBtn", "E", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isUseTemplate", "mediaInfo", "", "totalDurationUs", "templateId", "importTime", "extractCoverTime", "fetchMusicTime", "fetchStuckTime", "preloadPlayer", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, BdhLogUtil.LogTag.Tag_Conn, "count", "sessionID", "status", "w", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "winkEditorData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isDownLoadSuccess", UserInfo.SEX_FEMALE, "isSuccess", "isCancel", "code", "isHotStart", "tabName", "u", "elementId", "elementParam", "pgId", "f", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "hostFragment", "Lcom/tencent/mobileqq/wink/editor/export/u;", "winkExportViewModel", "I", "k", "a", "Ljava/util/HashMap;", "lastReportMap", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class cu {

    /* renamed from: a */
    @NotNull
    private static HashMap<String, Long> f319859a = new HashMap<>();

    public static final void A(@NotNull List<WinkEditData> winkEditorData) {
        Object orNull;
        Intrinsics.checkNotNullParameter(winkEditorData, "winkEditorData");
        final long timeCost = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_VIDEO_EXPORT);
        if (timeCost > 0) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(winkEditorData, 0);
            final WinkEditData winkEditData = (WinkEditData) orNull;
            if (winkEditData == null) {
                return;
            }
            final String i3 = com.tencent.videocut.render.extension.e.i(winkEditData.getMediaModel().videos);
            ms.a.f("WinkEditorFragment", "performance video export  time " + timeCost);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cr
                @Override // java.lang.Runnable
                public final void run() {
                    cu.B(timeCost, i3, winkEditData);
                }
            }, 32, null, true);
        }
    }

    public static final void B(long j3, String mediaInfo, WinkEditData editorData) {
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(editorData, "$editorData");
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_POSITION, Integer.valueOf(((IPhoneConfig) QRoute.api(IPhoneConfig.class)).getPhoneLevel()));
        map.put("xsj_actiontype", WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_PAGE);
        map.put("xsj_eid", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_EFFICIENCY_INFO);
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_NEXT_VIDEO_EXPORT_TIME, Long.valueOf(j3));
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_INPUT_INFO, mediaInfo);
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_LENGTH, Long.valueOf(editorData.getDurationUs() / 1000000));
        VideoReport.reportEvent("ev_xsj_camera_action", map);
    }

    public static final long C(final boolean z16, @NotNull final String mediaInfo, final long j3, @NotNull final String templateId, final long j16, final long j17, final long j18, final long j19, final boolean z17, @NotNull final String businessName) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        final long timeCost = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_VIDEO_LOAD_FIRST_FRAME);
        if (timeCost < 0) {
            return 0L;
        }
        ms.a.f("WinkEditorFragment", "performance media importTime  cost " + j16);
        ms.a.f("WinkEditorFragment", "performance firstFrame " + timeCost);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cq
            @Override // java.lang.Runnable
            public final void run() {
                cu.D(j16, z16, templateId, timeCost, mediaInfo, j3, j17, j18, j19, z17, businessName);
            }
        }, 32, null, true);
        return timeCost;
    }

    public static final void D(long j3, boolean z16, String templateId, long j16, String mediaInfo, long j17, long j18, long j19, long j26, boolean z17, String businessName) {
        String str;
        Intrinsics.checkNotNullParameter(templateId, "$templateId");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(businessName, "$businessName");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEDIA_IMPORT_TIME, String.valueOf(j3));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USE_TEMPLATE, String.valueOf(z16));
        if (z16) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USE_TEMPLATE_ID, templateId);
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_LOAD_FIRST_FRAME_TIME, String.valueOf(j16));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_INPUT_INFO, mediaInfo);
        com.tencent.mobileqq.wink.editor.performance.a aVar = com.tencent.mobileqq.wink.editor.performance.a.f321445a;
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMPORT_COMPRESS_COUNT, String.valueOf(aVar.a()));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMPORT_IMAGE_COUNT, String.valueOf(aVar.b()));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMPORT_VIDEO_COUNT, String.valueOf(aVar.c()));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IMPORT_TOTAL_DURATION, String.valueOf(j17 / 1000));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EXTRACT_COVER_TIME, String.valueOf(j18));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FETCH_MUSIC_TIME, String.valueOf(j19));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FETCH_STUCK_POINT_TIME, String.valueOf(j26));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_NEED_PRELOAD_PALYER, String.valueOf(z17));
        if (WinkEditorFragment.INSTANCE.a()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FIRST_OPEN, str);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUSINESS_NAME, businessName);
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkEditorImport(hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void E(@NotNull NextBtnPart btnPart, @Nullable dr drVar, @NotNull WinkEditorViewModel winkEditorViewModel, @Nullable MetaMaterial metaMaterial, @Nullable MetaMaterial metaMaterial2, int i3, @NotNull Activity activity, boolean z16, boolean z17, boolean z18, boolean z19, @NotNull String content, boolean z26) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Pair<String, Boolean> b16;
        Map<String, String> map;
        String stringExtra;
        Bundle extras;
        Intrinsics.checkNotNullParameter(btnPart, "btnPart");
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "winkEditorViewModel");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(content, "content");
        HashMap hashMap = new HashMap();
        z93.d g16 = Wink.INSTANCE.g();
        if (g16 != null) {
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
            Map<String, Object> b17 = g16.b(intent);
            if (b17 != null) {
                hashMap.putAll(b17);
                Unit unit = Unit.INSTANCE;
            }
        }
        Map<String, Object> a16 = com.tencent.mobileqq.wink.report.f.f326266a.a(activity);
        if (a16 != null) {
            for (Map.Entry<String, Object> entry : a16.entrySet()) {
                WinkDatongCurrentParams.put(entry.getKey(), entry.getValue());
            }
        }
        Intent intent2 = activity.getIntent();
        Object obj = (intent2 == null || (extras = intent2.getExtras()) == null) ? null : extras.get("key_attrs");
        HashMap hashMap2 = obj instanceof HashMap ? (HashMap) obj : null;
        String str12 = hashMap2 != null ? (String) hashMap2.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID) : null;
        if (str12 != null) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str12);
        }
        Map<String, String> b18 = com.tencent.mobileqq.wink.report.f.f326266a.b(activity);
        if (b18 != null) {
            for (Map.Entry<String, String> entry2 : b18.entrySet()) {
                WinkDatongCurrentParams.put(entry2.getKey(), entry2.getValue());
            }
        }
        String stringExtra2 = activity.getIntent().getStringExtra("xsj_is_publish_defeated_works");
        if (stringExtra2 != null) {
            WinkDatongCurrentParams.put("xsj_is_publish_defeated_works", stringExtra2);
        }
        String str13 = "normal";
        if (z17) {
            str13 = "auto_video";
        } else if (z16) {
            str13 = "template";
        } else if (z18) {
            str13 = "emotion";
        }
        try {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_PAGE_TYPE, str13);
            if (z19) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_SYNC_BUTTON_IS_HIGHLIGHT, 1);
            } else {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_SYNC_BUTTON_IS_HIGHLIGHT, 0);
            }
            if (activity.getIntent() != null && activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE) != null && (stringExtra = activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE)) != null) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, stringExtra);
            }
            Object obj2 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE);
            Intrinsics.checkNotNullExpressionValue(obj2, "get(ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE)");
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, obj2);
            Object obj3 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE);
            Intrinsics.checkNotNullExpressionValue(obj3, "get(ElementParamKey.XSJ_\u2026IBTEMPLATE_MATERIAL_TYPE)");
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, obj3);
        } catch (Exception e16) {
            ms.a.f("WinkEditorFragment", "reportPageExpose reportNextBtn " + e16.getMessage());
            e16.printStackTrace();
        }
        String str14 = metaMaterial != null ? metaMaterial.f30533id : null;
        if (str14 == null) {
            str14 = "";
        }
        hashMap.put("xsj_template_name", str14);
        String str15 = metaMaterial != null ? metaMaterial.f30533id : null;
        if (str15 == null) {
            str15 = "";
        }
        hashMap.put("xsj_template_id", str15);
        if (metaMaterial == null || (map = metaMaterial.additionalFields) == null || (str = map.get("name")) == null) {
            str = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, str);
        if (metaMaterial == null || (str2 = c.p(metaMaterial)) == null) {
            str2 = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CATEGORY, str2);
        if (i3 == 100) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_APPLY_SCOPE, 2);
            str3 = metaMaterial2 != null ? metaMaterial2.f30533id : null;
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME, str3);
            Unit unit2 = Unit.INSTANCE;
        } else if (i3 != 101) {
            str3 = metaMaterial2 != null ? metaMaterial2.f30533id : null;
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME, str3);
            Unit unit3 = Unit.INSTANCE;
        } else {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_APPLY_SCOPE, 1);
            String join = TextUtils.join(",", i(drVar));
            Intrinsics.checkNotNullExpressionValue(join, "join(\",\", getFilterStringList(curTavCut))");
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME, join);
            Unit unit4 = Unit.INSTANCE;
        }
        if (metaMaterial2 == null || (str4 = c.p(metaMaterial2)) == null) {
            str4 = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CATEGORY, str4);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, n(drVar));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY, m(drVar));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_TYPE_NAME, o(drVar));
        Map<String, String> q16 = q(drVar);
        Map<String, String> s16 = s(drVar);
        Pair<Integer, Integer> p16 = p(drVar);
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NUM, p16.getFirst());
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QQ_EXPRESSION_NUM, p16.getSecond());
        if (q16 == null || (str5 = q16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_NAME)) == null) {
            str5 = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_NAME, str5);
        if (q16 == null || (str6 = q16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME)) == null) {
            str6 = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, str6);
        if (s16 == null || (str7 = s16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME)) == null) {
            str7 = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME, str7);
        if (s16 == null || (str8 = s16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_PATTERN_NAME)) == null) {
            str8 = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_PATTERN_NAME, str8);
        if (s16 == null || (str9 = s16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_ART_NAME)) == null) {
            str9 = "";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_ART_NAME, str9);
        Map<String, String> r16 = r(drVar);
        if (r16 != null) {
            hashMap.putAll(r16);
        }
        Object obj4 = WinkDatongCurrentParams.get("xsj_music_id");
        Intrinsics.checkNotNullExpressionValue(obj4, "get(ElementParamKey.XSJ_MUSIC_ID)");
        hashMap.put("xsj_music_id", obj4);
        Object obj5 = WinkDatongCurrentParams.get("xsj_music_name");
        Intrinsics.checkNotNullExpressionValue(obj5, "get(ElementParamKey.XSJ_MUSIC_NAME)");
        hashMap.put("xsj_music_name", obj5);
        Object obj6 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT);
        Intrinsics.checkNotNullExpressionValue(obj6, "get(ElementParamKey.XSJ_MUSIC_IS_DEFAULT)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT, obj6);
        Object obj7 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM);
        Intrinsics.checkNotNullExpressionValue(obj7, "get(ElementParamKey.XSJ_MUSIC_FROM)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM, obj7);
        Object obj8 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE);
        Intrinsics.checkNotNullExpressionValue(obj8, "get(ElementParamKey.XSJ_MUSIC_VOLUME_VALUE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE, obj8);
        Object obj9 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE);
        Intrinsics.checkNotNullExpressionValue(obj9, "get(ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE, obj9);
        Object obj10 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_CUT);
        Intrinsics.checkNotNullExpressionValue(obj10, "get(ElementParamKey.XSJ_MUSIC_IS_CUT)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_CUT, obj10);
        Object obj11 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_SOUND_IS_ORIGIN);
        Intrinsics.checkNotNullExpressionValue(obj11, "get(ElementParamKey.XSJ_SOUND_IS_ORIGIN)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SOUND_IS_ORIGIN, obj11);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CANVAS_ISCHANGE, "0");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, winkEditorViewModel.getIsFromTemplateColl() ? "1" : "0");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_NEXT_IS_SMART_CUT, com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip ? "1" : "0");
        Object obj12 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_MODIFIED);
        Intrinsics.checkNotNullExpressionValue(obj12, "get(ElementParamKey.XSJ_IS_PASTE_MODIFIED)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_MODIFIED, obj12);
        Object obj13 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED);
        Intrinsics.checkNotNullExpressionValue(obj13, "get(ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED, obj13);
        Object obj14 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA);
        Intrinsics.checkNotNullExpressionValue(obj14, "get(ElementParamKey.XSJ_FILTER_NAME_CAMERA)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA, obj14);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE, winkEditorViewModel.getEnhanceOnOffState() ? "1" : "0");
        Object obj15 = WinkDatongCurrentParams.get("xsj_operation_activity_id");
        Intrinsics.checkNotNullExpressionValue(obj15, "get(ElementParamKey.XSJ_OPERATION_ACTIVITY_ID)");
        hashMap.put("xsj_operation_activity_id", obj15);
        Object obj16 = WinkDatongCurrentParams.get("xsj_taskdataid");
        Intrinsics.checkNotNullExpressionValue(obj16, "get(ElementParamKey.XSJ_TASKDATAID)");
        hashMap.put("xsj_taskdataid", obj16);
        Object obj17 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM);
        Intrinsics.checkNotNullExpressionValue(obj17, "get(ElementParamKey.XSJ_CONTENT_NUM)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, obj17);
        Object obj18 = WinkDatongCurrentParams.get("xsj_picture_num");
        Intrinsics.checkNotNullExpressionValue(obj18, "get(ElementParamKey.XSJ_PICTURE_NUM)");
        hashMap.put("xsj_picture_num", obj18);
        Object obj19 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM);
        Intrinsics.checkNotNullExpressionValue(obj19, "get(ElementParamKey.XSJ_VIDEO_NUM)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, obj19);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_DIY_STICKER_IF_BG, j(drVar) ? "1" : "0");
        Object obj20 = WinkDatongCurrentParams.get("xsj_topic_id");
        Intrinsics.checkNotNullExpressionValue(obj20, "get(ElementParamKey.XSJ_TOPIC_ID)");
        hashMap.put("xsj_topic_id", obj20);
        Object obj21 = WinkDatongCurrentParams.get("xsj_topic_name");
        Intrinsics.checkNotNullExpressionValue(obj21, "get(ElementParamKey.XSJ_TOPIC_NAME)");
        hashMap.put("xsj_topic_name", obj21);
        Object obj22 = WinkDatongCurrentParams.get("xsj_topic_page_source");
        Intrinsics.checkNotNullExpressionValue(obj22, "get(ElementParamKey.XSJ_TOPIC_PAGE_SOURCE)");
        hashMap.put("xsj_topic_page_source", obj22);
        Object obj23 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_MUSIC_TYPE);
        Intrinsics.checkNotNullExpressionValue(obj23, "get(ElementParamKey.XSJ_PAITONGKUAN_MUSIC_TYPE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_MUSIC_TYPE, obj23);
        Object obj24 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TIMELINE_FPS);
        Intrinsics.checkNotNullExpressionValue(obj24, "get(ElementParamKey.XSJ_TIMELINE_FPS)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TIMELINE_FPS, obj24);
        Object obj25 = WinkDatongCurrentParams.get("xsj_material_type");
        Intrinsics.checkNotNullExpressionValue(obj25, "get(ElementParamKey.XSJ_MATERIAL_TYPE)");
        hashMap.put("xsj_material_type", obj25);
        Object obj26 = WinkDatongCurrentParams.get("xsj_material_id");
        Intrinsics.checkNotNullExpressionValue(obj26, "get(ElementParamKey.XSJ_MATERIAL_ID)");
        hashMap.put("xsj_material_id", obj26);
        Object obj27 = WinkDatongCurrentParams.get("xsj_is_publish_defeated_works");
        Intrinsics.checkNotNullExpressionValue(obj27, "get(ElementParamKey.XSJ_IS_PUBLISH_DEFEATED_WORKS)");
        hashMap.put("xsj_is_publish_defeated_works", obj27);
        Object obj28 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE);
        Intrinsics.checkNotNullExpressionValue(obj28, "get(ElementParamKey.XSJ_PAITONGKUAN_TYPE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, obj28);
        Object obj29 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID);
        Intrinsics.checkNotNullExpressionValue(obj29, "get(ElementParamKey.XSJ_PAITONGKUAN_ID)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, obj29);
        hashMap.put("xsj_background_id", Integer.valueOf(winkEditorViewModel.getBackgroundMaterialIndex()));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHARACTER_NUM, Integer.valueOf(h(drVar)));
        Object obj30 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_ZPLAN_AR_TYPE);
        Intrinsics.checkNotNullExpressionValue(obj30, "get(ElementParamKey.XSJ_ZPLAN_AR_TYPE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ZPLAN_AR_TYPE, obj30);
        Object obj31 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL);
        Intrinsics.checkNotNullExpressionValue(obj31, "get(ElementParamKey.XSJ_IS_BIG_PANEL)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, obj31);
        com.tencent.mobileqq.wink.model.b bVar = com.tencent.mobileqq.wink.model.b.f324006a;
        if (bVar.f() && (b16 = bVar.b()) != null) {
            hashMap.put("xsj_challenge_topic", b16.getFirst());
        }
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (TextUtils.isEmpty(companion.d().p(QCircleScheme.AttrQQPublish.ARK_SHARE_TYPE))) {
            str10 = WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME;
            str11 = WinkDaTongReportConstant.ElementParamKey.XSJ_CHARACTER_NUM;
        } else {
            String p17 = companion.d().p(QCircleScheme.AttrQQPublish.ARK_SHARE_TYPE);
            str10 = WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME;
            StringBuilder sb5 = new StringBuilder();
            str11 = WinkDaTongReportConstant.ElementParamKey.XSJ_CHARACTER_NUM;
            sb5.append("ARK_SHARE_TYPE: ");
            sb5.append(p17);
            QLog.d("Metamaterial", 2, sb5.toString());
            String p18 = companion.d().p(QCircleScheme.AttrQQPublish.ARK_SHARE_TYPE);
            if (p18 == null) {
                p18 = "";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MATERIAL_SHARE_TYPE, p18);
        }
        if (t(activity.getIntent())) {
            hashMap.putAll(l(activity, winkEditorViewModel.R2()));
            g(btnPart.Z9(), WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_COMPLETE_BUTTON, hashMap, null, 8, null);
        } else if ((btnPart instanceof DailyNextBtnPart) && !z26) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_CONTENT, Integer.valueOf(!TextUtils.isEmpty(content) ? 1 : 0));
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_DAILY_TYPE, "1");
            View ua5 = ((DailyNextBtnPart) btnPart).ua();
            if (ua5 != null) {
                f(ua5, "em_xsj_publish_button", hashMap, k(winkEditorViewModel.getEditMode()));
            }
        } else {
            g(btnPart.Z9(), WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON, hashMap, null, 8, null);
        }
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_DIY_STICKER_IF_BG, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_DIY_STICKER_IF_BG));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SMART_CUT, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_NEXT_IS_SMART_CUT));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CATEGORY, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CATEGORY));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CATEGORY, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CATEGORY));
        WinkDatongCurrentParams.put("xsj_template_id", hashMap.get("xsj_template_id"));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME));
        WinkDatongCurrentParams.put("xsj_background_id", hashMap.get("xsj_background_id"));
        String str16 = str11;
        WinkDatongCurrentParams.put(str16, hashMap.get(str16));
        String str17 = str10;
        WinkDatongCurrentParams.put(str17, hashMap.get(str17));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_PATTERN_NAME, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_PATTERN_NAME));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_ART_NAME, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_ART_NAME));
        if (r16 != null && (r16.isEmpty() ^ true)) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE, r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE, r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE));
            WinkDatongCurrentParams.put("xsj_text_content", r16.get("xsj_text_content"));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE, r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE));
            WinkDatongCurrentParams.put(str17, r16.get(str17));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_PARAGRAPH, r16.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_PARAGRAPH));
        }
    }

    public static final long F(final boolean z16) {
        final long timeCost = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_ONE_CLICK_TEMPLATE);
        if (timeCost <= 0) {
            return 0L;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.ct
            @Override // java.lang.Runnable
            public final void run() {
                cu.G(timeCost, z16);
            }
        }, 32, null, true);
        return timeCost;
    }

    public static final void G(long j3, boolean z16) {
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Long valueOf = Long.valueOf(j3);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ONECLICK_TEMPLATE_COST, valueOf);
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ONECLICK_TEMPLATE_APPLY_SUCCESS, Boolean.valueOf(z16));
        VideoReport.reportEvent("ev_xsj_camera_action", map);
    }

    public static final void H(@Nullable Activity activity, @NotNull View view, @NotNull WinkEditorViewModel.EditMode editMode, boolean z16, @Nullable MetaMaterial metaMaterial, boolean z17, boolean z18, @Nullable ArrayList<LocalMediaInfo> arrayList, boolean z19) {
        String str;
        String str2;
        String str3;
        Map<String, String> map;
        String str4;
        Object obj;
        HashMap hashMap;
        String str5;
        Serializable serializable;
        MediaPickerScene mediaPickerScene;
        boolean z26;
        Pair<String, Boolean> b16;
        String stringExtra;
        String str6;
        Bundle extras;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        if (activity == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(activity);
        HashMap hashMap2 = new HashMap();
        z93.d g16 = Wink.INSTANCE.g();
        if (g16 != null) {
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
            Map<String, Object> a16 = g16.a(intent);
            if (a16 != null) {
                hashMap2.putAll(a16);
            }
        }
        hashMap2.putAll(l(activity, arrayList));
        Bundle bundle = null;
        if (z19) {
            str = WinkDaTongReportConstant.PageId.PG_XSJ_OPENING_ENDING_EDIT_PAGE;
        } else if (editMode == WinkEditorViewModel.EditMode.Video) {
            if (!z16) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, str2);
            if (z16) {
                if (metaMaterial != null) {
                    str3 = metaMaterial.f30533id;
                } else {
                    str3 = null;
                }
                String str7 = "";
                if (str3 == null) {
                    str3 = "";
                }
                hashMap2.put("xsj_template_id", str3);
                if (metaMaterial != null && (map = metaMaterial.additionalFields) != null && (str4 = map.get("name")) != null) {
                    str7 = str4;
                }
                hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, str7);
            }
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, WinkDaTongReportConstant.ElementParamValue.XSJ_IS_VIDEO_PAGE);
            str = WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE;
        } else {
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_IS_SMART_CUT, "0");
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, "0");
            HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params2, "params");
            params2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, WinkDaTongReportConstant.ElementParamValue.XSJ_IS_PIC_PAGE);
            str = WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE;
        }
        String str8 = str;
        Map<String, Object> a17 = com.tencent.mobileqq.wink.report.f.f326266a.a(activity);
        if (a17 != null) {
            for (Map.Entry<String, Object> entry : a17.entrySet()) {
                WinkDatongCurrentParams.put(entry.getKey(), entry.getValue());
            }
        }
        Intent intent2 = activity.getIntent();
        if (intent2 != null && (extras = intent2.getExtras()) != null) {
            obj = extras.get("key_attrs");
        } else {
            obj = null;
        }
        if (obj instanceof HashMap) {
            hashMap = (HashMap) obj;
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            str5 = (String) hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
        } else {
            str5 = null;
        }
        if (str5 != null) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str5);
        }
        Intent intent3 = activity.getIntent();
        if (intent3 != null) {
            serializable = intent3.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
        } else {
            serializable = null;
        }
        if (serializable instanceof MediaPickerScene) {
            mediaPickerScene = (MediaPickerScene) serializable;
        } else {
            mediaPickerScene = null;
        }
        boolean z27 = true;
        if (mediaPickerScene == MediaPickerScene.TEMPLATE_LIBRARY_MEMORY_ALBUM) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            if (hashMap != null) {
                str6 = (String) hashMap.get(QCircleScheme.AttrQQPublish.LIB_TEMPLATE_MEMORY_ID);
            } else {
                str6 = null;
            }
            if (str6 != null) {
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID, str6);
            }
        }
        String stringExtra2 = activity.getIntent().getStringExtra("xsj_is_publish_defeated_works");
        if (stringExtra2 != null) {
            WinkDatongCurrentParams.put("xsj_is_publish_defeated_works", stringExtra2);
        }
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (!TextUtils.isEmpty(companion.d().p(QCircleScheme.AttrQQPublish.IS_TEAM_LEADER))) {
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_TEAM_LEADER, companion.d().p(QCircleScheme.AttrQQPublish.IS_TEAM_LEADER));
        }
        HashMap<String, Object> hashMap3 = WinkDatongCurrentParams.params;
        if (hashMap3 != null) {
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, hashMap3.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM));
            if (WinkDatongCurrentParams.params.containsKey("xsj_qzone_entrance_source")) {
                hashMap2.put("xsj_qzone_entrance_source", WinkDatongCurrentParams.params.get("xsj_qzone_entrance_source"));
            }
        }
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM));
        hashMap2.put("xsj_picture_num", WinkDatongCurrentParams.get("xsj_picture_num"));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM));
        Intent intent4 = activity.getIntent();
        if (intent4 != null && (stringExtra = intent4.getStringExtra(QQWinkConstants.SCHEMA_OPERATION_ACTIVITY_ID)) != null) {
            HashMap<String, Object> params3 = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params3, "params");
            params3.put("xsj_operation_activity_id", stringExtra);
        }
        hashMap2.put("xsj_operation_activity_id", WinkDatongCurrentParams.get("xsj_operation_activity_id"));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME));
        hashMap2.put("xsj_material_type", WinkDatongCurrentParams.get("xsj_material_type"));
        hashMap2.put("xsj_material_id", WinkDatongCurrentParams.get("xsj_material_id"));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MATERIAL_SOURCE_LOCATION, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MATERIAL_SOURCE_LOCATION));
        hashMap2.put("xsj_is_publish_defeated_works", WinkDatongCurrentParams.get("xsj_is_publish_defeated_works"));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID));
        if (z17) {
            try {
                if (activity.getIntent() != null) {
                    hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, activity.getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE));
                }
            } catch (Exception e16) {
                ms.a.f("WinkEditorFragment", "reportPageExpose report " + e16.getMessage());
                e16.printStackTrace();
            }
        }
        String str9 = "normal";
        if (z17) {
            str9 = "auto_video";
        } else if (z16) {
            str9 = "template";
        } else if (z18) {
            str9 = "emotion";
        }
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_PAGE_TYPE, str9);
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE));
        hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ZPLAN_AR_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_ZPLAN_AR_TYPE));
        String stringExtra3 = activity.getIntent().getStringExtra(QCircleScheme.AttrQQPublish.FROM_ENTRANCE);
        if (stringExtra3 != null && stringExtra3.length() != 0) {
            z27 = false;
        }
        if (!z27) {
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, stringExtra3);
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, stringExtra3);
        }
        com.tencent.mobileqq.wink.model.b bVar = com.tencent.mobileqq.wink.model.b.f324006a;
        if (bVar.f() && (b16 = bVar.b()) != null) {
            hashMap2.put("xsj_challenge_topic", b16.getFirst());
        }
        com.tencent.mobileqq.wink.report.c cVar = com.tencent.mobileqq.wink.report.c.f326261a;
        Intent intent5 = activity.getIntent();
        if (intent5 != null) {
            bundle = intent5.getExtras();
        }
        cVar.a(bundle, hashMap2);
        VideoReport.setPageId(view, str8);
        VideoReport.setPageContentId(view, str8);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(hashMap2, WinkContext.INSTANCE.d().getDtParams().c()));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_MODIFIED, "0");
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_PASTE_ONEHAND_MODIFIED, "0");
    }

    public static final void I(@NotNull View view, @Nullable Intent intent, @NotNull WinkEditorViewModel winkEditorViewModel, @NotNull BasePartFragment hostFragment, @NotNull com.tencent.mobileqq.wink.editor.export.u winkExportViewModel) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "winkEditorViewModel");
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        Intrinsics.checkNotNullParameter(winkExportViewModel, "winkExportViewModel");
        if (intent == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putAll(intent.getExtras());
        r93.h hVar = r93.h.f430993a;
        WinkEditDataWrapper o26 = winkExportViewModel.o2();
        Intrinsics.checkNotNullExpressionValue(o26, "winkExportViewModel.winkEditDataWrapper");
        hVar.c(hostFragment, bundle, null, o26);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", k(winkEditorViewModel.getEditMode()));
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        Intent intent2 = new Intent();
        intent2.putExtras(bundle);
        intent2.putExtra(QQWinkConstants.PUBLISH_EDIT_WINK_PUBLISH_DATA, winkExportViewModel.m2());
        if (winkEditorViewModel.getEditMode() == WinkEditorViewModel.EditMode.Image) {
            z16 = true;
        } else {
            z16 = false;
        }
        intent2.putExtra(QQWinkConstants.IS_IMAGE_MODEL, z16);
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).parseAddGamePlayRecordData(intent2, arrayList);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_PAGE_GAMEPLAY, ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getPublisherGamePlayReportStr(arrayList));
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON);
        VideoReport.reportEvent(WinkDaTongReportConstant.EventId.EV_QZ_PHOTO_EDIT_ACTION, view, params);
    }

    public static final void f(@NotNull View view, @NotNull String elementId, @Nullable Map<String, ? extends Object> map, @NotNull String pgId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", pgId);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        WinkHomeReportHelper.f326257a.a(elementId, params);
        if (map != null) {
            params.putAll(map);
        }
        VideoReport.setElementId(view, elementId);
        VideoReport.reportEvent("ev_xsj_camera_action", view, params);
    }

    public static /* synthetic */ void g(View view, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE;
        }
        f(view, str, map, str2);
    }

    private static final int h(dr drVar) {
        List<WinkEditData> list;
        boolean z16;
        String str = null;
        if (drVar != null) {
            list = drVar.n();
        } else {
            list = null;
        }
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Map<String, WinkStickerModel> stickerModelMap = ((WinkEditData) it.next()).getStickerModelMap();
                if (stickerModelMap != null) {
                    Iterator<Map.Entry<String, WinkStickerModel>> it5 = stickerModelMap.entrySet().iterator();
                    while (it5.hasNext()) {
                        WinkStickerModel value = it5.next().getValue();
                        MetaMaterial material = value.getMaterial();
                        if (material != null && com.tencent.mobileqq.wink.editor.sticker.m.T(material)) {
                            for (TextItem textItem : value.textItems) {
                                String str2 = textItem.text;
                                if (str2 != null && str2.length() != 0) {
                                    z16 = false;
                                } else {
                                    z16 = true;
                                }
                                if (!z16) {
                                    str = textItem.text;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    @NotNull
    public static final List<String> i(@Nullable dr drVar) {
        WinkVideoTavCut winkVideoTavCut;
        LutFilterModel lutFilterModel;
        String str;
        ArrayList arrayList = new ArrayList();
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            Iterator<T> it = winkVideoTavCut.a0().iterator();
            while (it.hasNext()) {
                FilterModel filterModel = ((MediaClip) it.next()).filter;
                if (filterModel != null && (lutFilterModel = filterModel.lut) != null && (str = lutFilterModel.filterId) != null) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private static final boolean j(dr drVar) {
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        String str;
        boolean equals$default;
        String str2;
        boolean equals$default2;
        String str3;
        boolean equals$default3;
        boolean startsWith$default;
        if (drVar != null && (m3 = drVar.m()) != null && (values = m3.values()) != null) {
            for (WinkStickerModel winkStickerModel : values) {
                MetaMaterial material = winkStickerModel.getMaterial();
                if (material != null) {
                    str = c.o(material);
                } else {
                    str = null;
                }
                equals$default = StringsKt__StringsJVMKt.equals$default(str, "CATEGORY_TEXT_STYLE", false, 2, null);
                if (!equals$default) {
                    MetaMaterial material2 = winkStickerModel.getMaterial();
                    if (material2 != null) {
                        str2 = c.o(material2);
                    } else {
                        str2 = null;
                    }
                    equals$default2 = StringsKt__StringsJVMKt.equals$default(str2, "CATEGORY_TEXT_PATTERN", false, 2, null);
                    if (equals$default2) {
                        continue;
                    } else {
                        MetaMaterial material3 = winkStickerModel.getMaterial();
                        if (material3 != null) {
                            str3 = c.o(material3);
                        } else {
                            str3 = null;
                        }
                        equals$default3 = StringsKt__StringsJVMKt.equals$default(str3, "CATEGORY_TEXT_DECOR", false, 2, null);
                        if (equals$default3) {
                            continue;
                        } else {
                            String str4 = winkStickerModel.bgPath;
                            String PATH = u53.e.f438384a;
                            Intrinsics.checkNotNullExpressionValue(PATH, "PATH");
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str4, PATH, false, 2, null);
                            if (startsWith$default) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @NotNull
    public static final String k(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        if (editMode == WinkEditorViewModel.EditMode.Video) {
            return WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE;
        }
        return WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE;
    }

    private static final HashMap<String, Object> l(Activity activity, ArrayList<LocalMediaInfo> arrayList) {
        int i3;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (t(activity.getIntent())) {
            int i16 = 0;
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (e93.i.I((LocalMediaInfo) it.next())) {
                        i16++;
                    } else {
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            Intent intent = activity.getIntent();
            if (intent != null && intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_PART_NAME) != null) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE));
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, Integer.valueOf(i16));
            hashMap.put("xsj_picture_num", Integer.valueOf(i3));
        }
        return hashMap;
    }

    private static final String m(dr drVar) {
        List<SpecialEffectModel> y16;
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        if (drVar != null && (y16 = drVar.y()) != null) {
            for (SpecialEffectModel specialEffectModel : y16) {
                if (i3 != 0) {
                    sb5.append(",");
                    sb5.append(specialEffectModel.categoryId);
                } else {
                    sb5.append(specialEffectModel.categoryId);
                }
                i3++;
            }
        }
        if (i3 == 0) {
            return "";
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "specialEffectItems.toString()");
        return sb6;
    }

    private static final String n(dr drVar) {
        List<SpecialEffectModel> y16;
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        if (drVar != null && (y16 = drVar.y()) != null) {
            for (SpecialEffectModel specialEffectModel : y16) {
                if (i3 != 0) {
                    sb5.append(",");
                    sb5.append(specialEffectModel.materialId);
                } else {
                    sb5.append(specialEffectModel.materialId);
                }
                i3++;
            }
        }
        if (i3 == 0) {
            return "";
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "{\n        specialEffectItems.toString()\n    }");
        return sb6;
    }

    private static final String o(dr drVar) {
        List<SpecialEffectModel> y16;
        String str;
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        if (drVar != null && (y16 = drVar.y()) != null) {
            Iterator<T> it = y16.iterator();
            while (it.hasNext()) {
                Integer num = ((SpecialEffectModel) it.next()).effectType;
                if (num != null && num.intValue() == 1) {
                    str = "ai";
                } else {
                    str = "normal";
                }
                if (i3 != 0) {
                    sb5.append(",");
                    sb5.append(str);
                } else {
                    sb5.append(str);
                }
                i3++;
            }
        }
        if (i3 == 0) {
            return "";
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "specialEffectItems.toString()");
        return sb6;
    }

    private static final Pair<Integer, Integer> p(dr drVar) {
        int i3;
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        String str;
        String str2;
        int i16 = 0;
        if (drVar != null && (m3 = drVar.m()) != null && (values = m3.values()) != null) {
            i3 = 0;
            for (WinkStickerModel winkStickerModel : values) {
                if (!winkStickerModel.isTextSticker()) {
                    MetaMaterial material = winkStickerModel.getMaterial();
                    String str3 = null;
                    if (material != null) {
                        str = c.o(material);
                    } else {
                        str = null;
                    }
                    if (!Intrinsics.areEqual(str, "CATEGORY_TEXT_DECOR")) {
                        MetaMaterial material2 = winkStickerModel.getMaterial();
                        if (material2 != null) {
                            str2 = com.tencent.mobileqq.wink.editor.sticker.m.J(material2);
                        } else {
                            str2 = null;
                        }
                        if (!Intrinsics.areEqual(str2, "qq_emoticon_sticker")) {
                            MetaMaterial material3 = winkStickerModel.getMaterial();
                            if (material3 != null) {
                                str3 = c.o(material3);
                            }
                            if (!Intrinsics.areEqual(str3, "100029")) {
                                i16++;
                            }
                        }
                        i3++;
                    }
                }
            }
        } else {
            i3 = 0;
        }
        return TuplesKt.to(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Map<String, String> q(dr drVar) {
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        int mapCapacity;
        String joinToString$default;
        String str;
        Object obj;
        MetaMaterial material;
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = null;
        if (drVar != null && (m3 = drVar.m()) != null && (values = m3.values()) != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (WinkStickerModel winkStickerModel : values) {
                if (!winkStickerModel.isTextSticker()) {
                    MetaMaterial material2 = winkStickerModel.getMaterial();
                    if (material2 != null) {
                        str3 = c.o(material2);
                    } else {
                        str3 = null;
                    }
                    if (!Intrinsics.areEqual(str3, "CATEGORY_TEXT_DECOR")) {
                        str = WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME;
                        obj = linkedHashMap2.get(str);
                        if (obj == null) {
                            obj = new ArrayList();
                            linkedHashMap2.put(str, obj);
                        }
                        List list = (List) obj;
                        material = winkStickerModel.getMaterial();
                        if (material == null) {
                            str2 = material.f30533id;
                        } else {
                            str2 = null;
                        }
                        list.add(str2);
                    }
                }
                str = WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_NAME;
                obj = linkedHashMap2.get(str);
                if (obj == null) {
                }
                List list2 = (List) obj;
                material = winkStickerModel.getMaterial();
                if (material == null) {
                }
                list2.add(str2);
            }
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size());
            linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                Object key = entry.getKey();
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default((Iterable) entry.getValue(), ",", null, null, 0, null, null, 62, null);
                linkedHashMap.put(key, joinToString$default);
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x015d, code lost:
    
        r14 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r14);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<String, String> r(@Nullable dr drVar) {
        List<String> listOf;
        LinkedHashMap linkedHashMap;
        Map<String, String> mutableMap;
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        int mapCapacity;
        String joinToString$default;
        Map map;
        Pair pair;
        Object obj;
        Map<String, WinkStickerModel> m16;
        Collection<WinkStickerModel> values2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_UNDERLAY_STYLE, WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_COLOR_STYLE, "xsj_text_content", WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_ALIGNMEN_STYLE, WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME});
        int i3 = 0;
        if (drVar != null && (m16 = drVar.m()) != null && (values2 = m16.values()) != null) {
            Collection<WinkStickerModel> collection = values2;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((WinkStickerModel) it.next()).isTextSticker() && (i3 = i3 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        if (drVar != null && (m3 = drVar.m()) != null && (values = m3.values()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : values) {
                if (((WinkStickerModel) obj2).isTextSticker()) {
                    arrayList.add(obj2);
                }
            }
            ArrayList<Pair> arrayList2 = new ArrayList();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                Object obj3 = WinkDatongCurrentParams.get(((WinkStickerModel) it5.next()).id + "_textreport");
                if (obj3 instanceof Map) {
                    map = (Map) obj3;
                } else {
                    map = null;
                }
                ArrayList arrayList3 = new ArrayList();
                for (String str : listOf) {
                    if (map != null && (obj = map.get(str)) != null) {
                        pair = TuplesKt.to(str, obj);
                    } else {
                        pair = null;
                    }
                    if (pair != null) {
                        arrayList3.add(pair);
                    }
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList3);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Pair pair2 : arrayList2) {
                String str2 = (String) pair2.getFirst();
                Object obj4 = linkedHashMap2.get(str2);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(str2, obj4);
                }
                ((List) obj4).add(pair2.getSecond());
            }
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size());
            linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                Object key = entry.getKey();
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default((List) entry.getValue(), "|", null, null, 0, null, null, 62, null);
                linkedHashMap.put(key, joinToString$default);
            }
        } else {
            linkedHashMap = null;
        }
        if (linkedHashMap == null || mutableMap == null) {
            return null;
        }
        mutableMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_PARAGRAPH, String.valueOf(i3));
        return mutableMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Map<String, String> s(dr drVar) {
        Map<String, WinkStickerModel> m3;
        Collection<WinkStickerModel> values;
        int mapCapacity;
        String joinToString$default;
        String str;
        String str2;
        Object obj;
        MetaMaterial material;
        String str3;
        String str4;
        LinkedHashMap linkedHashMap = null;
        if (drVar != null && (m3 = drVar.m()) != null && (values = m3.values()) != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (WinkStickerModel winkStickerModel : values) {
                MetaMaterial material2 = winkStickerModel.getMaterial();
                if (material2 != null) {
                    str = c.o(material2);
                } else {
                    str = null;
                }
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -921884268) {
                        if (hashCode != -907563552) {
                            if (hashCode == 793913343 && str.equals("CATEGORY_TEXT_PATTERN")) {
                                str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_PATTERN_NAME;
                            }
                        } else if (str.equals("CATEGORY_TEXT_STYLE")) {
                            str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME;
                        }
                    } else if (str.equals("CATEGORY_TEXT_DECOR")) {
                        str2 = WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_ART_NAME;
                    }
                    obj = linkedHashMap2.get(str2);
                    if (obj == null) {
                        obj = new ArrayList();
                        linkedHashMap2.put(str2, obj);
                    }
                    List list = (List) obj;
                    material = winkStickerModel.getMaterial();
                    if (material == null) {
                        str3 = c.o(material);
                    } else {
                        str3 = null;
                    }
                    if (!Intrinsics.areEqual(str3, "CATEGORY_TEXT_STYLE")) {
                        str4 = com.tencent.mobileqq.wink.editor.sticker.m.q(winkStickerModel.getMaterial());
                    } else {
                        MetaMaterial material3 = winkStickerModel.getMaterial();
                        if (material3 != null) {
                            str4 = material3.f30533id;
                        } else {
                            str4 = null;
                        }
                    }
                    list.add(str4);
                }
                str2 = "";
                obj = linkedHashMap2.get(str2);
                if (obj == null) {
                }
                List list2 = (List) obj;
                material = winkStickerModel.getMaterial();
                if (material == null) {
                }
                if (!Intrinsics.areEqual(str3, "CATEGORY_TEXT_STYLE")) {
                }
                list2.add(str4);
            }
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size());
            linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                Object key = entry.getKey();
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default((Iterable) entry.getValue(), ",", null, null, 0, null, null, 62, null);
                linkedHashMap.put(key, joinToString$default);
            }
        }
        return linkedHashMap;
    }

    public static final boolean t(@Nullable Intent intent) {
        String str;
        String str2;
        String str3 = null;
        if (intent != null) {
            str = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "QZONE")) {
            if (intent != null) {
                str2 = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_PART_NAME);
            } else {
                str2 = null;
            }
            if (!Intrinsics.areEqual(str2, QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_ALBUM)) {
                if (intent != null) {
                    str3 = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_PART_NAME);
                }
                if (Intrinsics.areEqual(str3, QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_SHUOSHUO)) {
                }
            }
            return true;
        }
        return false;
    }

    public static final void u(boolean z16, boolean z17, int i3, boolean z18, int i16) {
        Object obj;
        Object obj2;
        String valueOf = String.valueOf(((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG));
        String valueOf2 = String.valueOf(((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_AI_ELIMINATE_DOWNLOAD_IMG));
        String valueOf3 = String.valueOf(((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST));
        String valueOf4 = String.valueOf(((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST));
        final HashMap hashMap = new HashMap();
        hashMap.put(IPrefRecorder.MILESTONE_AI_ELIMINATE_UPLOAD_IMG, valueOf);
        hashMap.put(IPrefRecorder.MILESTONE_AI_ELIMINATE_BACKEND_REQUEST, valueOf3);
        hashMap.put(IPrefRecorder.MILESTONE_AI_ELIMINATE_DOWNLOAD_IMG, valueOf2);
        hashMap.put(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST, valueOf4);
        String str = "1";
        if (z16) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put(IPrefRecorder.AI_ELIMINATE_IS_SUCCESS_APPLY, obj);
        if (z17) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put(IPrefRecorder.AI_ELIMINATE_IS_CANCEL, obj2);
        hashMap.put(IPrefRecorder.AI_ELIMINATE_RESPONSE_CODE, String.valueOf(i3));
        hashMap.put("tab_name", String.valueOf(i16));
        if (!z18) {
            str = "0";
        }
        hashMap.put(IPrefRecorder.AI_ELIMINATE_HOT_START, str);
        ms.a.f("Metamaterial", "reportAIEliminationPerformance uploadTime: " + valueOf + ", backendTime: " + valueOf3 + ", downloadTime: " + valueOf2 + ", totalTome: " + valueOf4 + ", tabName: " + i16 + ", isSuccess: " + z16 + ", isCancel: " + z17 + ", code: " + i3 + ", isHotStart: " + z18);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cs
            @Override // java.lang.Runnable
            public final void run() {
                cu.v(hashMap);
            }
        }, 32, null, true);
    }

    public static final void v(HashMap map) {
        Intrinsics.checkNotNullParameter(map, "$map");
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportAIEliminateTime(map);
    }

    public static final void w(int i3, @NotNull String sessionID, int i16) {
        long j3;
        Object first;
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        final HashMap hashMap = new HashMap();
        long timeCost = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_MAGIC_GALLERY_REQUEST_COUNT);
        ArrayList<Long> aigcTimes = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCostRange(IPrefRecorder.MILESTONE_MAGIC_GALLERY_MIN_GENERATE_IMAGE, 0, -1);
        Intrinsics.checkNotNullExpressionValue(aigcTimes, "aigcTimes");
        if (!aigcTimes.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) aigcTimes);
            Intrinsics.checkNotNullExpressionValue(first, "aigcTimes.first()");
            j3 = ((Number) first).longValue();
        } else {
            j3 = 0;
        }
        long timeCost2 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_MAGIC_GALLERY_DOWNLOAD_FIRST_IMAGE);
        long j16 = j3;
        long timeCost3 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_MAGIC_GALLERY_DOWNLOAD_FIRST_CROP_IMAGE);
        long timeCost4 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_MAGIC_GALLERY_DOWNLOAD_TEMPLATE);
        long timeCost5 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_MAGIC_GALLERY_PARALLEL_MAX_TIME);
        long timeCost6 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_MAGIC_GALLERY_FIRST_FRAME);
        w53.b.f("AIGCPerformanceForTest", "\u521b\u4f5c\u9875\u771f\u6b63\u6267\u884c\u8df3\u8f6c\u5230\u4e0b\u4e00\u4e2a\u9875\u9762\u8017\u65f6 = " + timeCost6);
        ms.a.a("WinkEditorFragment", "performance AIGC count is " + i3);
        ms.a.a("WinkEditorFragment", "performance AIGC countTime cost " + timeCost);
        ms.a.a("WinkEditorFragment", "performance AIGC minAigcTime cost " + j16);
        ms.a.a("WinkEditorFragment", "performance AIGC firstImageTime cost " + timeCost2);
        ms.a.a("WinkEditorFragment", "performance AIGC firstCropImageTime cost " + timeCost3);
        ms.a.a("WinkEditorFragment", "performance AIGC downloadTemplateTime cost " + timeCost4);
        ms.a.a("WinkEditorFragment", "performance AIGC maxPARALLELTime cost " + timeCost5);
        ms.a.a("WinkEditorFragment", "performance AIGC nextFrameTime cost " + timeCost6);
        ms.a.a("WinkEditorFragment", "performance AIGC status is " + i16);
        ms.a.a("WinkEditorFragment", "performance AIGC sessionID is " + sessionID);
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_GENERATE_COUNT, String.valueOf(i3));
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_REQUEST_COUNT, String.valueOf(timeCost));
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_MIN_GENERATE_IMAGE, String.valueOf(j16));
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_DOWNLOAD_FIRST_IMAGE, String.valueOf(timeCost2));
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_DOWNLOAD_FIRST_CROP_IMAGE, String.valueOf(timeCost3));
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_DOWNLOAD_TEMPLATE, String.valueOf(timeCost4));
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_PARALLEL_MAX_TIME, String.valueOf(timeCost5));
        hashMap.put(IPrefRecorder.MILESTONE_MAGIC_GALLERY_FIRST_FRAME, String.valueOf(timeCost6));
        hashMap.put(IPrefRecorder.XSJ_MAGIC_GALLERY_GENERATE_STATUS, String.valueOf(i16));
        hashMap.put(IPrefRecorder.XSJ_MAGIC_GALLERY_SESSION_ID, sessionID);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cp
            @Override // java.lang.Runnable
            public final void run() {
                cu.y(hashMap);
            }
        }, 32, null, true);
    }

    public static /* synthetic */ void x(int i3, String str, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        w(i3, str, i16);
    }

    public static final void y(HashMap map) {
        Intrinsics.checkNotNullParameter(map, "$map");
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportAIGCGenerateTime(map);
    }

    public static final void z(@NotNull View view, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, str);
        g(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_RETURN_BUTTON, linkedHashMap, null, 8, null);
    }
}
