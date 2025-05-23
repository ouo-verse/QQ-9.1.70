package com.tencent.sqshow.zootopia.mapstatus;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import pv4.y;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 L2\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u00a2\u0006\u0004\bP\u0010DJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002Ja\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0012R\u0017\u0010\u001d\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010+\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R$\u00102\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b\u001e\u0010/\"\u0004\b0\u00101R\"\u00109\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b:\u0010#R\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u001f\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u001f\u001a\u0004\b\u0019\u0010!\"\u0004\bB\u0010#R\"\u0010E\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\bC\u0010DR$\u0010J\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010F\u001a\u0004\b$\u0010G\"\u0004\bH\u0010IR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O\u00a8\u0006Q"}, d2 = {"Lcom/tencent/sqshow/zootopia/mapstatus/c;", "", "Lpv4/y;", "verControlInfo", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "downloadData", "", "k", "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "progress", "", "version", "errorCode", "realTimeSpeed", "averageSpeed", "", "isSilentDownload", "", "r", "(Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "o", "mapStatus", ReportConstant.COSTREPORT_PREFIX, "p", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "mapId", "b", "I", "g", "()I", "setMapStatus", "(I)V", "c", "l", "setQqVerStatus", "qqVerStatus", "d", h.F, "setMapVerStatus", "mapVerStatus", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "e", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "setDiffPatchInfo", "(Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;)V", "diffPatchInfo", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "i", "()Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "setModVersionSimpleData", "(Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;)V", "modVersionSimpleData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, UserInfo.SEX_FEMALE, "j", "()F", HippyQQPagView.FunctionName.SET_PROGRESS, "(F)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setRealTimeSpeed", "setAverageSpeed", "setDownloadVersion", "(Ljava/lang/String;)V", "downloadVersion", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setDownloadErrorCode", "(Ljava/lang/Integer;)V", "downloadErrorCode", "Z", DomainData.DOMAIN_NAME, "()Z", "setSilentDownload", "(Z)V", "<init>", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String mapId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mapStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int qqVerStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mapVerStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZPlanMapDiffPatchInfo diffPatchInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanModVersionSimpleData modVersionSimpleData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int downloadStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int realTimeSpeed;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int averageSpeed;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String downloadVersion;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Integer downloadErrorCode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSilentDownload;

    public c(String mapId) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        this.mapId = mapId;
        this.mapStatus = -1;
        this.qqVerStatus = -1;
        this.mapVerStatus = -1;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(mapId);
        this.modVersionSimpleData = new ZPlanModVersionSimpleData(intOrNull != null ? intOrNull.intValue() : 0);
        this.downloadStatus = -1;
        this.downloadVersion = "";
    }

    private final float k(y verControlInfo, ZootopiaResData downloadData) {
        ZPlanModVersionSimpleData modVersionSimpleData;
        if (verControlInfo.f427736i != 0 || verControlInfo.f427729b != 0) {
            return 0.0f;
        }
        int i3 = verControlInfo.f427730c;
        if (i3 != 0) {
            if (i3 != 1) {
                return 0.0f;
            }
            if (!Intrinsics.areEqual(verControlInfo.f427731d, (downloadData == null || (modVersionSimpleData = downloadData.getModVersionSimpleData()) == null) ? null : modVersionSimpleData.getNowMapVer())) {
                return 0.0f;
            }
        }
        if (downloadData != null) {
            return downloadData.getProgress();
        }
        return 0.0f;
    }

    /* renamed from: a, reason: from getter */
    public final int getAverageSpeed() {
        return this.averageSpeed;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getDownloadErrorCode() {
        return this.downloadErrorCode;
    }

    /* renamed from: d, reason: from getter */
    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    /* renamed from: e, reason: from getter */
    public final String getDownloadVersion() {
        return this.downloadVersion;
    }

    /* renamed from: f, reason: from getter */
    public final String getMapId() {
        return this.mapId;
    }

    /* renamed from: g, reason: from getter */
    public final int getMapStatus() {
        return this.mapStatus;
    }

    /* renamed from: h, reason: from getter */
    public final int getMapVerStatus() {
        return this.mapVerStatus;
    }

    /* renamed from: i, reason: from getter */
    public final ZPlanModVersionSimpleData getModVersionSimpleData() {
        return this.modVersionSimpleData;
    }

    /* renamed from: j, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: l, reason: from getter */
    public final int getQqVerStatus() {
        return this.qqVerStatus;
    }

    /* renamed from: m, reason: from getter */
    public final int getRealTimeSpeed() {
        return this.realTimeSpeed;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsSilentDownload() {
        return this.isSilentDownload;
    }

    public final synchronized void o(y verControlInfo, ZootopiaResData downloadData) {
        String str;
        ZPlanModVersionSimpleData modVersionSimpleData;
        Intrinsics.checkNotNullParameter(verControlInfo, "verControlInfo");
        QLog.i("MapStatusInfo", 1, "onServerVersionUpdate verControlInfo = " + verControlInfo + " downloadData = " + downloadData);
        this.mapStatus = !g.f328305a.a() ? verControlInfo.f427736i : 0;
        this.qqVerStatus = verControlInfo.f427729b;
        this.mapVerStatus = verControlInfo.f427730c;
        this.modVersionSimpleData = ZPlanModVersionSimpleData.INSTANCE.b(verControlInfo);
        this.diffPatchInfo = ZPlanMapDiffPatchInfo.INSTANCE.b(verControlInfo.f427742o);
        this.downloadStatus = downloadData != null ? downloadData.getDownloadStatus() : -1;
        this.progress = k(verControlInfo, downloadData);
        if (downloadData == null || (modVersionSimpleData = downloadData.getModVersionSimpleData()) == null || (str = modVersionSimpleData.getNowMapVer()) == null) {
            str = "";
        }
        this.downloadVersion = str;
        if (downloadData != null) {
            this.isSilentDownload = downloadData.isSilentDownload();
        }
    }

    public final synchronized void p() {
        this.mapVerStatus = 0;
    }

    public final void q(int i3) {
        this.downloadStatus = i3;
    }

    public final synchronized void r(Integer downloadStatus, Float progress, String version, Integer errorCode, Integer realTimeSpeed, Integer averageSpeed, Boolean isSilentDownload) {
        int intValue;
        if (downloadStatus != null) {
            try {
                intValue = downloadStatus.intValue();
            } catch (Throwable th5) {
                throw th5;
            }
        } else {
            intValue = -1;
        }
        this.downloadStatus = intValue;
        if (progress != null) {
            this.progress = progress.floatValue();
        }
        if (realTimeSpeed != null) {
            this.realTimeSpeed = realTimeSpeed.intValue();
        }
        if (averageSpeed != null) {
            this.averageSpeed = averageSpeed.intValue();
        }
        if (version != null) {
            this.downloadVersion = version;
        }
        if (isSilentDownload != null) {
            this.isSilentDownload = isSilentDownload.booleanValue();
        }
        this.downloadErrorCode = errorCode;
    }

    public final synchronized void s(int mapStatus) {
        this.mapStatus = mapStatus;
    }
}
