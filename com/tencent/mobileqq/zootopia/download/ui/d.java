package com.tencent.mobileqq.zootopia.download.ui;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b2\u00103R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001d\u0010 \"\u0004\b'\u0010\"R$\u0010+\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b\u0010\u0010 \"\u0004\b*\u0010\"R$\u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010-\u001a\u0004\b)\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/d;", "", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "a", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "()Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "data", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "b", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "g", "()Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "o", "(Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;)V", "status", "", "c", "I", "()I", "j", "(I)V", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "d", UserInfo.SEX_FEMALE, "()F", "l", "(F)V", "progress", "e", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", DomainData.DOMAIN_NAME, "(Ljava/lang/Integer;)V", "realTimeSpeed", "getAverageSpeed", "i", "averageSpeed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqVerTip", tl.h.F, "k", "mapVerTip", "", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "p", "(Ljava/lang/Boolean;)V", AppConstants.Key.COLUMN_IS_VALID, "<init>", "(Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaDownloadData data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MapStatus status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int downloadStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Integer realTimeSpeed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Integer averageSpeed;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Integer qqVerTip;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer mapVerTip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Boolean isValid;

    public d(ZootopiaDownloadData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.downloadStatus = data.getResData().getDownloadStatus();
        this.progress = data.getResData().getProgress();
    }

    /* renamed from: a, reason: from getter */
    public final ZootopiaDownloadData getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getDownloadStatus() {
        return this.downloadStatus;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getMapVerTip() {
        return this.mapVerTip;
    }

    /* renamed from: d, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getQqVerTip() {
        return this.qqVerTip;
    }

    /* renamed from: f, reason: from getter */
    public final Integer getRealTimeSpeed() {
        return this.realTimeSpeed;
    }

    /* renamed from: g, reason: from getter */
    public final MapStatus getStatus() {
        return this.status;
    }

    /* renamed from: h, reason: from getter */
    public final Boolean getIsValid() {
        return this.isValid;
    }

    public final void i(Integer num) {
        this.averageSpeed = num;
    }

    public final void j(int i3) {
        this.downloadStatus = i3;
    }

    public final void k(Integer num) {
        this.mapVerTip = num;
    }

    public final void l(float f16) {
        this.progress = f16;
    }

    public final void m(Integer num) {
        this.qqVerTip = num;
    }

    public final void n(Integer num) {
        this.realTimeSpeed = num;
    }

    public final void o(MapStatus mapStatus) {
        this.status = mapStatus;
    }

    public final void p(Boolean bool) {
        this.isValid = bool;
    }
}
