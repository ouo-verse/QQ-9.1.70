package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailHeadView;
import com.qzone.reborn.albumx.qzonex.bean.QZAlbumxDescDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0014J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/s;", "Lcom/qzone/reborn/albumx/common/part/f;", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailHeadView;", "headView", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "info", "", "W9", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "albumViewModel", "X9", "Y9", "albumInfo", "S9", "R9", "Q9", "", "E", "Ljava/lang/String;", "curBgUrl", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class s extends com.qzone.reborn.albumx.common.part.f {

    /* renamed from: E, reason: from kotlin metadata */
    private String curBgUrl = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(s this$0, CommonAlbumInfo info, CommonAlbumDetailHeadView headView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(headView, "$headView");
        vb.b x16 = ho.i.x();
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String owner = info.getOwner();
        String a16 = com.qzone.util.l.a(R.string.f133957i);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_albumx_album_desc_text)");
        x16.a(activity, new QZAlbumxDescDetailInitBean(owner, a16, headView.r0()));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void W9(CommonAlbumDetailHeadView headView, CommonAlbumInfo info) {
        int qzAlbumType = info.getQzAlbumType();
        if (qzAlbumType == 8) {
            headView.setNameLabelIcon(true, com.qzone.util.l.a(R.string.f134488y), getContext().getResources().getDrawable(R.drawable.f14031c));
            return;
        }
        if (qzAlbumType == 9) {
            headView.setNameLabelIcon(true, com.qzone.util.l.a(R.string.f1345090), getContext().getResources().getDrawable(R.drawable.f14041d));
        } else if (qzAlbumType != 11) {
            headView.setNameLabelIcon(false, null, null);
        } else {
            headView.setNameLabelIcon(true, com.qzone.util.l.a(R.string.f134468w), getContext().getResources().getDrawable(R.drawable.f14021b));
        }
    }

    private final void X9(CommonAlbumDetailHeadView headView, com.qzone.reborn.albumx.common.viewmodel.b albumViewModel, CommonAlbumInfo info) {
        Boolean value = albumViewModel.Z1().getValue();
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        if (cVar.g(info)) {
            value = Boolean.TRUE;
        }
        headView.setNormalUpload(value, cVar.d(info.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType()), cVar.j(info.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType()));
    }

    private final void Y9(CommonAlbumDetailHeadView headView, final CommonAlbumInfo info) {
        if (info.getVisitorInfo().getViewNum() > 0 && info.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType() != 3) {
            headView.setSeenInfo(true, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s.Z9(CommonAlbumInfo.this, this, view);
                }
            });
        } else {
            headView.setSeenInfo(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        if ((r2 == null || r2.length() == 0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Z9(CommonAlbumInfo info, s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long k3 = ef.d.k(info.getCreator().getUin());
        if (k3 != 0) {
            String albumId = info.getAlbumId();
        }
        QLog.e("QZAlbumxAlbumDetailCoverPart", 1, "albumOwner" + k3 + ", albumId:" + info.getAlbumId());
        u4.a.z().V(this$0.getContext(), Long.valueOf(ef.d.k(info.getCreator().getUin())), info.getAlbumId());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.albumx.common.part.f
    public void Q9(final CommonAlbumDetailHeadView headView, final CommonAlbumInfo info) {
        Intrinsics.checkNotNullParameter(headView, "headView");
        Intrinsics.checkNotNullParameter(info, "info");
        headView.setDescMoreClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.V9(s.this, info, headView, view);
            }
        });
    }

    @Override // com.qzone.reborn.albumx.common.part.f
    public void R9(CommonAlbumDetailHeadView headView, com.qzone.reborn.albumx.common.viewmodel.b albumViewModel, CommonAlbumInfo info) {
        Intrinsics.checkNotNullParameter(headView, "headView");
        Intrinsics.checkNotNullParameter(albumViewModel, "albumViewModel");
        Intrinsics.checkNotNullParameter(info, "info");
        headView.setCommonExt(albumViewModel.getCommonExt());
        X9(headView, albumViewModel, info);
        Y9(headView, info);
        headView.setData(info, 0);
        W9(headView, info);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.f
    public void S9(CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        String L9 = L9(albumInfo.getCover());
        if (Intrinsics.areEqual(L9, this.curBgUrl)) {
            if (!(L9 == null || L9.length() == 0)) {
                QLog.e("QZAlbumxAlbumDetailCoverPart", 1, "curBgUrl == url");
                return;
            }
        }
        super.S9(albumInfo);
        this.curBgUrl = L9;
    }
}
