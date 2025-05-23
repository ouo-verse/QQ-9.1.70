package com.qzone.reborn.feedpro.layer.part;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerListBean;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0014J,\u0010\u0010\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\"\u0010!\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010 \u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/a;", "Lcom/qzone/reborn/feedpro/layer/part/QzoneFeedProBaseLayerControlPart;", "Lge/g;", "na", "Lq9/a;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerListBean;", "L9", "layerListBean", "", "xa", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "preLayerState", "newLayerState", "", "canFindPrePic", "isRefreshByDeleteEvent", "G9", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "initMediaPositionInAlbum", BdhLogUtil.LogTag.Tag_Req, "initMediaPositionInLayerList", ExifInterface.LATITUDE_SOUTH, "getOffset", "()I", "setOffset", "(I)V", "offset", "T", "extraOffset", "U", "Z", "isRefresh", "()Z", "setRefresh", "(Z)V", "V", "hasDeletePhoto", "W", "hasFetchLeft", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends QzoneFeedProBaseLayerControlPart {

    /* renamed from: Q, reason: from kotlin metadata */
    private int initMediaPositionInAlbum;

    /* renamed from: R, reason: from kotlin metadata */
    private int initMediaPositionInLayerList;

    /* renamed from: S, reason: from kotlin metadata */
    private int offset;

    /* renamed from: T, reason: from kotlin metadata */
    private int extraOffset;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean hasDeletePhoto;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean hasFetchLeft;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<QzoneFeedProLayerListBean> L9() {
        ViewModel viewModel = getViewModel(ke.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026yerViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // com.qzone.reborn.feedpro.layer.part.QzoneFeedProBaseLayerControlPart
    protected ge.g na() {
        String str;
        String albumId;
        ge.g gVar = new ge.g();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        String str2 = "";
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        gVar.j(str);
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        if (x96 != null && (albumId = x96.getAlbumId()) != null) {
            str2 = albumId;
        }
        gVar.g(str2);
        gVar.k(ma().getLeftAttachInfo());
        gVar.m(ma().getRightAttachInfo());
        return gVar;
    }

    @Override // com.qzone.reborn.feedpro.layer.part.QzoneFeedProBaseLayerControlPart
    protected void xa(QzoneFeedProLayerListBean layerListBean) {
        Intrinsics.checkNotNullParameter(layerListBean, "layerListBean");
        boolean isRefresh = layerListBean.getIsRefresh();
        this.isRefresh = isRefresh;
        if (isRefresh) {
            this.initMediaPositionInAlbum = layerListBean.getInitMediaPositionInAlbum();
            return;
        }
        if (layerListBean.getIsFetchLeft()) {
            int size = this.initMediaPositionInLayerList + layerListBean.g().size();
            this.initMediaPositionInLayerList = size;
            QLog.i("QZoneBaseLayerControlPart", 1, "initMediaPositionInLayerList is " + size + ", new media list size is " + layerListBean.g().size());
            this.hasFetchLeft = true;
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void G9(RFWLayerState preLayerState, RFWLayerState newLayerState, boolean canFindPrePic, boolean isRefreshByDeleteEvent) {
        int coerceAtLeast;
        int coerceAtLeast2;
        if (preLayerState == null || newLayerState == null) {
            return;
        }
        int i3 = this.initMediaPositionInLayerList;
        this.extraOffset = (this.extraOffset + getCurrentSelectedPosition()) - getInitialIndex();
        if (this.isRefresh) {
            this.initMediaPositionInLayerList = newLayerState.getSelectedPosition();
        } else {
            this.offset = newLayerState.getSelectedPosition() - this.initMediaPositionInLayerList;
        }
        QLog.i("QZoneBaseLayerControlPart", 1, "current selected pos " + getCurrentSelectedPosition());
        if (isRefreshByDeleteEvent) {
            if (i3 >= newLayerState.getSelectedPosition() + 1) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.initMediaPositionInAlbum - 1, 0);
                this.initMediaPositionInAlbum = coerceAtLeast;
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i3 - 1, 0);
                this.initMediaPositionInLayerList = coerceAtLeast2;
            }
            this.hasDeletePhoto = true;
        } else if (!this.hasDeletePhoto) {
            newLayerState.setPositionOffset(((this.initMediaPositionInAlbum + this.offset) - newLayerState.getSelectedPosition()) + this.extraOffset);
        }
        QLog.i("QZoneBaseLayerControlPart", 1, " initMediaPositionInAlbum is " + this.initMediaPositionInAlbum + ", newLayerState.selectedPosition is " + newLayerState.getSelectedPosition() + ", preLayerState.selectedPosition is " + preLayerState.getSelectedPosition() + ", offset is " + this.offset + ", initialIndex is " + getInitialIndex() + ", extraOffset is " + this.extraOffset + ", newLayerState.positionOffset " + newLayerState.getPositionOffset() + ", initMediaPositionInLayerList" + this.initMediaPositionInLayerList);
    }
}
