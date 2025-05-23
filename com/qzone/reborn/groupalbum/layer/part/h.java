package com.qzone.reborn.groupalbum.layer.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/h;", "Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumBaseLayerControlPart;", "Landroid/os/Bundle;", "data", "", "initIntentData", "Lci/h;", "la", "Lq9/a;", "Lci/e;", "L9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "preLayerState", "newLayerState", "H9", "", "getRefer", "Lii/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lii/b;", "getViewModel", "()Lii/b;", "setViewModel", "(Lii/b;)V", "viewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends GroupAlbumBaseLayerControlPart {

    /* renamed from: Q, reason: from kotlin metadata */
    private ii.b viewModel;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<ci.e> L9() {
        ViewModel viewModel = getViewModel(ii.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumD\u2026ataViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart
    public int getRefer() {
        return 4;
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    protected void initIntentData(Bundle data) {
        ii.b bVar;
        super.initIntentData(data);
        if (data != null) {
            this.viewModel = (ii.b) getViewModel(ii.b.class);
            if (!data.containsKey("key_album_detail_init_bean") || (bVar = this.viewModel) == null) {
                return;
            }
            Object obj = data.get("key_album_detail_init_bean");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean");
            bVar.h2((GroupAlbumAlbumDetailInitBean) obj);
        }
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart
    protected ci.h la() {
        String str;
        String str2;
        String batchId;
        ci.h hVar = new ci.h();
        GroupAlbumLayerExtraInfoBean x95 = x9();
        String str3 = "";
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        hVar.o(str);
        GroupAlbumLayerExtraInfoBean x96 = x9();
        if (x96 == null || (str2 = x96.getAlbumId()) == null) {
            str2 = "";
        }
        hVar.j(str2);
        GroupAlbumLayerExtraInfoBean x97 = x9();
        if (x97 != null && (batchId = x97.getBatchId()) != null) {
            str3 = batchId;
        }
        hVar.k(str3);
        hVar.p(ja().getLeftAttachInfo());
        hVar.r(ja().getRightAttachInfo());
        return hVar;
    }

    @Override // com.qzone.reborn.groupalbum.layer.part.GroupAlbumBaseLayerControlPart, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        ii.b bVar = this.viewModel;
        if (bVar != null) {
            bVar.removeListener();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void H9(RFWLayerState preLayerState, RFWLayerState newLayerState) {
        if (preLayerState == null || newLayerState == null) {
            return;
        }
        if (preLayerState.getSelectedPosition() > 0) {
            newLayerState.setSelectedPosition(preLayerState.getSelectedPosition() - 1);
        } else {
            newLayerState.setSelectedPosition(0);
        }
    }
}
