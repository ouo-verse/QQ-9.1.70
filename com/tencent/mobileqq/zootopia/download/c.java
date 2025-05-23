package com.tencent.mobileqq.zootopia.download;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaExtraData;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.download.data.ZootopiaSummaryData;
import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapFullDownloadInfo;
import com.tencent.mobileqq.zootopia.data.ZootopiaGameParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadData;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadEntity;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapListService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.bs;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0015J&\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00152\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001dJ.\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/c;", "", "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "entity", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;", tl.h.F, "Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;", "l", "Lcom/tencent/mobileqq/z1/download/a;", "downloadParams", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "j", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "d", "fileDownloadEntity", "Lcom/tencent/mobileqq/zootopia/download/normal/f;", "g", "Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadTask;", "f", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "k", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "c", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadData;", "i", "Lqv4/bs;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "e", "", "", "extras", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaGameParams;", DomainData.DOMAIN_NAME, "Lqv4/v;", "rsp", "", "isSilentDownload", "needNotification", "isPlayDownloadTogether", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a */
    public static final c f328029a = new c();

    c() {
    }

    private final ZootopiaSummaryData l(ZootopiaDownloadEntity entity) {
        String str = entity.zootopiaId;
        Intrinsics.checkNotNullExpressionValue(str, "entity.zootopiaId");
        int i3 = entity.type;
        String str2 = entity.title;
        Intrinsics.checkNotNullExpressionValue(str2, "entity.title");
        String str3 = entity.cover;
        Intrinsics.checkNotNullExpressionValue(str3, "entity.cover");
        String str4 = entity.buttonText;
        Intrinsics.checkNotNullExpressionValue(str4, "entity.buttonText");
        String str5 = entity.typeIcon;
        Intrinsics.checkNotNullExpressionValue(str5, "entity.typeIcon");
        String str6 = entity.typeName;
        Intrinsics.checkNotNullExpressionValue(str6, "entity.typeName");
        return new ZootopiaSummaryData(str, i3, str2, str3, str4, str5, str6);
    }

    public final ZootopiaDownloadData c(ZootopiaDownloadEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return new ZootopiaDownloadData(l(entity), k(entity), h(entity));
    }

    public final ZootopiaDownloadEntity d(ZootopiaDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        ZootopiaDownloadEntity zootopiaDownloadEntity = new ZootopiaDownloadEntity();
        downloadParams.getModVersionSimpleData().updateEntityValue(zootopiaDownloadEntity);
        zootopiaDownloadEntity.zootopiaId = downloadParams.getSummaryData().getId();
        zootopiaDownloadEntity.type = downloadParams.getSummaryData().getType();
        zootopiaDownloadEntity.title = downloadParams.getSummaryData().getTitle();
        zootopiaDownloadEntity.cover = downloadParams.getSummaryData().getCover();
        zootopiaDownloadEntity.buttonText = downloadParams.getSummaryData().getButtonText();
        zootopiaDownloadEntity.typeIcon = downloadParams.getSummaryData().getTypeIcon();
        zootopiaDownloadEntity.typeName = downloadParams.getSummaryData().getTypeName();
        zootopiaDownloadEntity.url = downloadParams.getUrl();
        zootopiaDownloadEntity.version = downloadParams.getVersion();
        zootopiaDownloadEntity.filePath = v.h(v.f328299a, downloadParams.getSummaryData().getId(), false, 2, null);
        zootopiaDownloadEntity.downloadStatus = 1;
        zootopiaDownloadEntity.size = downloadParams.getSize();
        zootopiaDownloadEntity.projectName = downloadParams.getExtraData().getProjectName();
        zootopiaDownloadEntity.icon = downloadParams.getExtraData().getIcon();
        zootopiaDownloadEntity.scriptType = downloadParams.getExtraData().getScriptType();
        zootopiaDownloadEntity.runScript = downloadParams.getExtraData().getRunScript();
        zootopiaDownloadEntity.sceneType = downloadParams.getExtraData().getSceneType();
        zootopiaDownloadEntity.startTime = System.currentTimeMillis();
        zootopiaDownloadEntity.showGameHealthyLoading = downloadParams.getExtraData().getShowGameHealthyLoading();
        zootopiaDownloadEntity.isAutoDownload = downloadParams.getExtraData().isAutoDownload();
        zootopiaDownloadEntity.isSilentDownload = downloadParams.getExtraData().isSilentDownload();
        zootopiaDownloadEntity.needNotification = downloadParams.getExtraData().getNeedNotification();
        ZootopiaMapLoadingParams loadingParams = downloadParams.getExtraData().getLoadingParams();
        zootopiaDownloadEntity.loadingBackgroundMaterialBytes = loadingParams != null ? loadingParams.getLoadingBackgroundBytes() : null;
        ZootopiaMapLoadingParams loadingParams2 = downloadParams.getExtraData().getLoadingParams();
        zootopiaDownloadEntity.isUseNewLoading = loadingParams2 != null ? loadingParams2.getIsUseNewLoading() : false;
        ZPlanMapDiffPatchInfo diffPatchInfo = downloadParams.getDiffPatchInfo();
        zootopiaDownloadEntity.diffPatchInfoBytes = diffPatchInfo != null ? diffPatchInfo.getDiffInfoBytes() : null;
        return zootopiaDownloadEntity;
    }

    public final ZootopiaDownloadParams e(ZootopiaDownloadData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ZootopiaDownloadParams(data.getSummaryData(), data.getResData().getUrl(), data.getResData().getVersion(), data.getResData().getSize(), data.getResData().getModVersionSimpleData(), data.getExtraData(), data.getResData().getDiffPatchInfo());
    }

    public final com.tencent.mobileqq.zootopia.download.normal.f g(FileDownloadParams downloadParams, FileDownloadEntity fileDownloadEntity) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        String r16 = FileDownloadManager.f328148a.r(downloadParams);
        int category = downloadParams.getCategory();
        String url = downloadParams.getUrl();
        v vVar = v.f328299a;
        com.tencent.mobileqq.zootopia.download.normal.f fVar = new com.tencent.mobileqq.zootopia.download.normal.f(r16, category, url, vVar.f(downloadParams), vVar.e(downloadParams), downloadParams.d(), downloadParams);
        if (fileDownloadEntity != null) {
            fVar.d0(fileDownloadEntity);
        }
        return fVar;
    }

    public final FileDownloadData i(FileDownloadEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        int i3 = entity.category;
        String str = entity.url;
        Intrinsics.checkNotNullExpressionValue(str, "entity.url");
        int i16 = entity.downloadStatus;
        float f16 = entity.progress;
        long j3 = entity.size;
        String str2 = entity.filePath;
        Intrinsics.checkNotNullExpressionValue(str2, "entity.filePath");
        return new FileDownloadData(i3, str, i16, f16, j3, str2);
    }

    public final FileDownloadEntity j(FileDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        FileDownloadEntity fileDownloadEntity = new FileDownloadEntity();
        fileDownloadEntity.url = downloadParams.getUrl();
        fileDownloadEntity.category = downloadParams.getCategory();
        fileDownloadEntity.downloadStatus = 1;
        v vVar = v.f328299a;
        fileDownloadEntity.filePath = vVar.f(downloadParams) + File.separator + vVar.e(downloadParams);
        return fileDownloadEntity;
    }

    public final bs m(ZootopiaDownloadData entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return ZootopiaMapListService.INSTANCE.a(entity.getResData().getId(), entity.getResData());
    }

    public final ZootopiaGameParams n(ZootopiaDownloadData data, Map<String, ? extends Object> map) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        int id5 = data.getResData().getId();
        String projectName = data.getExtraData().getProjectName();
        String scriptType = data.getExtraData().getScriptType();
        if (Intrinsics.areEqual(scriptType, "1")) {
            str = ZootopiaGameParams.SCRIPT_TYPE_LUA;
        } else if (Intrinsics.areEqual(scriptType, "2")) {
            str = "ts";
        } else {
            str = "";
        }
        return new ZootopiaGameParams(id5, projectName, str, "", "", data.getResData().getFilePath(), data.getResData().getId(), data.getResData().getVersion(), data.getSummaryData().getTitle(), data.getExtraData().getIcon(), data.getExtraData().getSceneType(), data.getExtraData().getShowGameHealthyLoading(), data.getSummaryData().getType(), data.getExtraData().getRunScript(), null, map, data.getExtraData().getLoadingParams(), 16384, null);
    }

    private final ZootopiaExtraData h(ZootopiaDownloadEntity zootopiaDownloadEntity) {
        String str = zootopiaDownloadEntity.projectName;
        Intrinsics.checkNotNullExpressionValue(str, "entity.projectName");
        String str2 = zootopiaDownloadEntity.icon;
        Intrinsics.checkNotNullExpressionValue(str2, "entity.icon");
        String str3 = zootopiaDownloadEntity.scriptType;
        Intrinsics.checkNotNullExpressionValue(str3, "entity.scriptType");
        int i3 = zootopiaDownloadEntity.sceneType;
        boolean z16 = zootopiaDownloadEntity.showGameHealthyLoading;
        String str4 = zootopiaDownloadEntity.runScript;
        if (str4 == null) {
            str4 = "";
        }
        return new ZootopiaExtraData(str, str2, str3, i3, z16, str4, zootopiaDownloadEntity.isAutoDownload, zootopiaDownloadEntity.isSilentDownload, zootopiaDownloadEntity.needNotification, null, new ZootopiaMapLoadingParams(zootopiaDownloadEntity.loadingBackgroundMaterialBytes, zootopiaDownloadEntity.isUseNewLoading), false, ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH, null);
    }

    public final ZootopiaDownloadParams a(qv4.v rsp, boolean isSilentDownload, boolean needNotification, boolean isPlayDownloadTogether) {
        qv4.g[] gVarArr;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        pv4.y[] yVarArr = rsp.f430204a;
        if (yVarArr != null) {
            Intrinsics.checkNotNullExpressionValue(yVarArr, "rsp.verControlInfos");
            if (!(yVarArr.length == 0) && (gVarArr = rsp.f430205b) != null) {
                Intrinsics.checkNotNullExpressionValue(gVarArr, "rsp.downloadExtraInfos");
                if (!(gVarArr.length == 0)) {
                    pv4.y verInfo = rsp.f430204a[0];
                    qv4.g gVar = rsp.f430205b[0];
                    String valueOf = String.valueOf(gVar.f430142a);
                    int i3 = gVar.f430143b;
                    String str = gVar.f430145d;
                    Intrinsics.checkNotNullExpressionValue(str, "downloadInfo.mapName");
                    String str2 = gVar.f430146e;
                    Intrinsics.checkNotNullExpressionValue(str2, "downloadInfo.background");
                    String str3 = gVar.f430148g;
                    Intrinsics.checkNotNullExpressionValue(str3, "downloadInfo.button");
                    String str4 = gVar.f430152k;
                    Intrinsics.checkNotNullExpressionValue(str4, "downloadInfo.typeIcon");
                    String str5 = gVar.f430144c;
                    Intrinsics.checkNotNullExpressionValue(str5, "downloadInfo.typeStr");
                    ZootopiaSummaryData zootopiaSummaryData = new ZootopiaSummaryData(valueOf, i3, str, str2, str3, str4, str5);
                    String str6 = gVar.f430150i;
                    Intrinsics.checkNotNullExpressionValue(str6, "downloadInfo.mapProjName");
                    String str7 = gVar.f430151j;
                    Intrinsics.checkNotNullExpressionValue(str7, "downloadInfo.barPic");
                    String valueOf2 = String.valueOf(verInfo.f427735h);
                    int i16 = gVar.f430149h;
                    boolean z16 = gVar.f430153l;
                    String str8 = verInfo.f427733f;
                    if (str8 == null) {
                        str8 = "";
                    }
                    ZootopiaExtraData zootopiaExtraData = new ZootopiaExtraData(str6, str7, valueOf2, i16, z16, str8, false, isSilentDownload, needNotification, null, ZootopiaMapLoadingParams.INSTANCE.a(gVar.f430155n), isPlayDownloadTogether, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT, null);
                    String str9 = verInfo.f427732e;
                    Intrinsics.checkNotNullExpressionValue(str9, "verInfo.cosURL");
                    String str10 = verInfo.f427731d;
                    Intrinsics.checkNotNullExpressionValue(str10, "verInfo.nowMapVer");
                    long j3 = verInfo.f427734g;
                    ZPlanModVersionSimpleData.Companion companion = ZPlanModVersionSimpleData.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(verInfo, "verInfo");
                    return new ZootopiaDownloadParams(zootopiaSummaryData, str9, str10, j3, companion.b(verInfo), zootopiaExtraData, ZPlanMapDiffPatchInfo.INSTANCE.b(verInfo.f427742o));
                }
            }
        }
        QLog.e("ConvertParams", 1, "rsp is invalid " + rsp.f430204a + " , " + rsp.f430205b);
        return null;
    }

    public final ZootopiaDownloadTask f(ZootopiaDownloadEntity entity) {
        String downloadUrl;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo;
        String str;
        Intrinsics.checkNotNullParameter(entity, "entity");
        String downloadUrl2 = entity.url;
        v vVar = v.f328299a;
        String str2 = entity.zootopiaId;
        Intrinsics.checkNotNullExpressionValue(str2, "entity.zootopiaId");
        String str3 = entity.url;
        Intrinsics.checkNotNullExpressionValue(str3, "entity.url");
        String str4 = entity.projectName;
        Intrinsics.checkNotNullExpressionValue(str4, "entity.projectName");
        String i3 = vVar.i(str2, str3, str4);
        Intrinsics.checkNotNullExpressionValue(downloadUrl2, "downloadUrl");
        long j3 = entity.size;
        String str5 = entity.version;
        Intrinsics.checkNotNullExpressionValue(str5, "entity.version");
        ZPlanMapFullDownloadInfo zPlanMapFullDownloadInfo = new ZPlanMapFullDownloadInfo(downloadUrl2, i3, j3, str5);
        if (entity.isDiffUpdate) {
            ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo2 = new ZPlanMapDiffPatchInfo(entity.diffPatchInfoBytes);
            if (zPlanMapDiffPatchInfo2.isValid()) {
                pv4.e diffPatchInfo = zPlanMapDiffPatchInfo2.diffPatchInfo();
                if (diffPatchInfo == null || (str = diffPatchInfo.f427589a) == null) {
                    str = "";
                }
                String str6 = entity.zootopiaId;
                Intrinsics.checkNotNullExpressionValue(str6, "entity.zootopiaId");
                String str7 = entity.projectName;
                Intrinsics.checkNotNullExpressionValue(str7, "entity.projectName");
                i3 = "diff_" + vVar.i(str6, str, str7);
                downloadUrl = str;
                zPlanMapDiffPatchInfo = zPlanMapDiffPatchInfo2;
                String str8 = entity.zootopiaId;
                Intrinsics.checkNotNullExpressionValue(str8, "entity.zootopiaId");
                Intrinsics.checkNotNullExpressionValue(downloadUrl, "downloadUrl");
                String str9 = entity.zootopiaId;
                Intrinsics.checkNotNullExpressionValue(str9, "entity.zootopiaId");
                String h16 = v.h(vVar, str9, false, 2, null);
                String str10 = entity.title;
                Intrinsics.checkNotNullExpressionValue(str10, "entity.title");
                ZPlanModVersionSimpleData a16 = ZPlanModVersionSimpleData.INSTANCE.a(entity);
                boolean z16 = entity.isAutoDownload;
                boolean z17 = entity.isUpdate;
                boolean z18 = entity.isSilentDownload;
                boolean z19 = entity.needNotification;
                String str11 = entity.zootopiaId;
                Intrinsics.checkNotNullExpressionValue(str11, "entity.zootopiaId");
                String str12 = entity.projectName;
                Intrinsics.checkNotNullExpressionValue(str12, "entity.projectName");
                return new ZootopiaDownloadTask(str8, downloadUrl, h16, i3, str10, a16, z16, z17, z18, z19, zPlanMapFullDownloadInfo, zPlanMapDiffPatchInfo, vVar.j(str11, str12), entity.isPlayTogether);
            }
        }
        downloadUrl = downloadUrl2;
        zPlanMapDiffPatchInfo = null;
        String str82 = entity.zootopiaId;
        Intrinsics.checkNotNullExpressionValue(str82, "entity.zootopiaId");
        Intrinsics.checkNotNullExpressionValue(downloadUrl, "downloadUrl");
        String str92 = entity.zootopiaId;
        Intrinsics.checkNotNullExpressionValue(str92, "entity.zootopiaId");
        String h162 = v.h(vVar, str92, false, 2, null);
        String str102 = entity.title;
        Intrinsics.checkNotNullExpressionValue(str102, "entity.title");
        ZPlanModVersionSimpleData a162 = ZPlanModVersionSimpleData.INSTANCE.a(entity);
        boolean z162 = entity.isAutoDownload;
        boolean z172 = entity.isUpdate;
        boolean z182 = entity.isSilentDownload;
        boolean z192 = entity.needNotification;
        String str112 = entity.zootopiaId;
        Intrinsics.checkNotNullExpressionValue(str112, "entity.zootopiaId");
        String str122 = entity.projectName;
        Intrinsics.checkNotNullExpressionValue(str122, "entity.projectName");
        return new ZootopiaDownloadTask(str82, downloadUrl, h162, i3, str102, a162, z162, z172, z182, z192, zPlanMapFullDownloadInfo, zPlanMapDiffPatchInfo, vVar.j(str112, str122), entity.isPlayTogether);
    }

    public final ZootopiaResData k(ZootopiaDownloadEntity entity) {
        int i3;
        Intrinsics.checkNotNullParameter(entity, "entity");
        try {
            i3 = Integer.parseInt(entity.zootopiaId);
        } catch (Exception unused) {
            i3 = 0;
        }
        String str = entity.url;
        Intrinsics.checkNotNullExpressionValue(str, "entity.url");
        String str2 = entity.version;
        Intrinsics.checkNotNullExpressionValue(str2, "entity.version");
        String str3 = entity.filePath;
        Intrinsics.checkNotNullExpressionValue(str3, "entity.filePath");
        return new ZootopiaResData(i3, str, str2, str3, entity.downloadStatus, entity.size, entity.progress, entity.completeTime, entity.startTime, ZPlanModVersionSimpleData.INSTANCE.a(entity), entity.isSilentDownload, entity.needNotification, new ZPlanMapDiffPatchInfo(entity.diffPatchInfoBytes));
    }

    public static /* synthetic */ ZootopiaDownloadParams b(c cVar, qv4.v vVar, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        if ((i3 & 8) != 0) {
            z18 = false;
        }
        return cVar.a(vVar, z16, z17, z18);
    }
}
