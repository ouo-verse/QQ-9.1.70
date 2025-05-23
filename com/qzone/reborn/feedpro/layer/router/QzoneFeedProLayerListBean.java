package com.qzone.reborn.feedpro.layer.router;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerListBean;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerRouteBean;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "()Z", "g0", "(Z)V", "isRefresh", BdhLogUtil.LogTag.Tag_Req, "M", "b0", "isFetchLeft", ExifInterface.LATITUDE_SOUTH, "N", "c0", "isFetchRight", "T", "V", "e0", "isLeftFinish", "U", "a0", "h0", "isRightFinish", "G", "setDeleteChange", "isDeleteChange", "", "W", "I", UserInfo.SEX_FEMALE, "()I", "f0", "(I)V", "mediumSum", "X", "E", "d0", "initMediaPositionInAlbum", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProLayerListBean extends QzoneFeedProLayerRouteBean {

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isFetchLeft;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isFetchRight;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isLeftFinish;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isRightFinish;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isDeleteChange;

    /* renamed from: W, reason: from kotlin metadata */
    private int mediumSum;

    /* renamed from: X, reason: from kotlin metadata */
    private int initMediaPositionInAlbum;

    /* renamed from: E, reason: from getter */
    public final int getInitMediaPositionInAlbum() {
        return this.initMediaPositionInAlbum;
    }

    /* renamed from: F, reason: from getter */
    public final int getMediumSum() {
        return this.mediumSum;
    }

    /* renamed from: G, reason: from getter */
    public final boolean getIsDeleteChange() {
        return this.isDeleteChange;
    }

    /* renamed from: M, reason: from getter */
    public final boolean getIsFetchLeft() {
        return this.isFetchLeft;
    }

    /* renamed from: N, reason: from getter */
    public final boolean getIsFetchRight() {
        return this.isFetchRight;
    }

    /* renamed from: V, reason: from getter */
    public final boolean getIsLeftFinish() {
        return this.isLeftFinish;
    }

    /* renamed from: Z, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    /* renamed from: a0, reason: from getter */
    public final boolean getIsRightFinish() {
        return this.isRightFinish;
    }

    public final void b0(boolean z16) {
        this.isFetchLeft = z16;
    }

    public final void c0(boolean z16) {
        this.isFetchRight = z16;
    }

    public final void d0(int i3) {
        this.initMediaPositionInAlbum = i3;
    }

    public final void e0(boolean z16) {
        this.isLeftFinish = z16;
    }

    public final void f0(int i3) {
        this.mediumSum = i3;
    }

    public final void g0(boolean z16) {
        this.isRefresh = z16;
    }

    public final void h0(boolean z16) {
        this.isRightFinish = z16;
    }
}
