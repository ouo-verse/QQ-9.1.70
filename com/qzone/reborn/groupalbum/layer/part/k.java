package com.qzone.reborn.groupalbum.layer.part;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b#\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0014J,\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u00100\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010$\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/k;", "Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumBaseLayerControlPart;", "Lci/h;", "la", "Lq9/a;", "Lci/e;", "L9", "", "U9", "layerListBean", "", "va", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "preLayerState", "newLayerState", "canFindPrePic", "isRefreshByDeleteEvent", "G9", "", "getRefer", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "getInitMediaPositionInAlbum", "()I", "setInitMediaPositionInAlbum", "(I)V", "initMediaPositionInAlbum", BdhLogUtil.LogTag.Tag_Req, "getInitMediaPositionInLayerList", "setInitMediaPositionInLayerList", "initMediaPositionInLayerList", ExifInterface.LATITUDE_SOUTH, "getOffset", "setOffset", "offset", "T", "Z", "isRefresh", "()Z", "setRefresh", "(Z)V", "U", "getHasDeletePhoto", "setHasDeletePhoto", "hasDeletePhoto", "V", "getHasFetchLeft", "setHasFetchLeft", "hasFetchLeft", "<init>", "()V", "W", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends GroupAlbumBaseLayerControlPart {

    /* renamed from: Q, reason: from kotlin metadata */
    private int initMediaPositionInAlbum;

    /* renamed from: R, reason: from kotlin metadata */
    private int initMediaPositionInLayerList;

    /* renamed from: S, reason: from kotlin metadata */
    private int offset;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isRefresh;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasDeletePhoto;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean hasFetchLeft;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<ci.e> L9() {
        ViewModel viewModel = getViewModel(ii.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumF\u2026ataViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected boolean U9() {
        return true;
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart
    public int getRefer() {
        return 3;
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart
    protected ci.h la() {
        String str;
        String albumId;
        ci.h hVar = new ci.h();
        GroupAlbumLayerExtraInfoBean x95 = x9();
        String str2 = "";
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        hVar.o(str);
        GroupAlbumLayerExtraInfoBean x96 = x9();
        if (x96 != null && (albumId = x96.getAlbumId()) != null) {
            str2 = albumId;
        }
        hVar.j(str2);
        hVar.p(ja().getLeftAttachInfo());
        hVar.r(ja().getRightAttachInfo());
        return hVar;
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart
    protected void va(ci.e layerListBean) {
        Intrinsics.checkNotNullParameter(layerListBean, "layerListBean");
        boolean isRefresh = layerListBean.getIsRefresh();
        this.isRefresh = isRefresh;
        if (isRefresh) {
            this.initMediaPositionInAlbum = layerListBean.getInitMediaPositionInAlbum();
        } else if (layerListBean.getIsFetchLeft()) {
            this.initMediaPositionInLayerList += layerListBean.g().size();
            this.hasFetchLeft = true;
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void G9(RFWLayerState preLayerState, RFWLayerState newLayerState, boolean canFindPrePic, boolean isRefreshByDeleteEvent) {
        if (preLayerState == null || newLayerState == null) {
            return;
        }
        int i3 = this.initMediaPositionInLayerList;
        if (this.isRefresh) {
            this.initMediaPositionInLayerList = newLayerState.getSelectedPosition();
        } else {
            this.offset = newLayerState.getSelectedPosition() - this.initMediaPositionInLayerList;
        }
        if (isRefreshByDeleteEvent) {
            if (i3 >= newLayerState.getSelectedPosition() + 1) {
                this.initMediaPositionInAlbum = Math.max(this.initMediaPositionInAlbum - 1, 0);
                this.initMediaPositionInLayerList = Math.max(i3 - 1, 0);
            }
            this.hasDeletePhoto = true;
        } else if (!this.hasDeletePhoto || this.hasFetchLeft) {
            newLayerState.setPositionOffset((this.initMediaPositionInAlbum + this.offset) - newLayerState.getSelectedPosition());
            this.hasFetchLeft = false;
        }
        RFWLog.e("GroupAlbumFeedLayerControlPart", RFWLog.USR, " initMediaPositionInAlbum is " + this.initMediaPositionInAlbum + ", newLayerState.selectedPosition is " + newLayerState.getSelectedPosition() + ", preLayerState.selectedPosition is " + preLayerState.getSelectedPosition() + ", offset is " + this.offset + ", initialIndex is " + getInitialIndex() + ", newLayerState.positionOffset " + newLayerState.getPositionOffset() + ", lastInitMediaPositionInLayerList" + i3);
    }
}
