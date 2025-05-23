package com.qzone.reborn.groupalbum.layer.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import cooperation.qzone.util.DateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/w;", "Lcom/qzone/reborn/groupalbum/layer/part/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", tl.h.F, "Landroid/view/View;", "footerView", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "nickNameView", BdhLogUtil.LogTag.Tag_Conn, "dayTextView", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class w extends b {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView dayTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View footerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView nickNameView;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        D9(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
    
        if (r5.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String() == true) goto L26;
     */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayerStateUpdate(RFWLayerState layerState) {
        boolean z16;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (x9() == null) {
            View view = this.footerView;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView != null) {
            GroupAlbumLayerExtraInfoBean x95 = x9();
            Intrinsics.checkNotNull(x95);
            qZoneUserAvatarView.setUser(ef.d.l(x95.getUploadUid(), 0L));
        }
        TextView textView = this.nickNameView;
        if (textView != null) {
            fj.s sVar = fj.s.f399470a;
            GroupAlbumLayerExtraInfoBean x96 = x9();
            Intrinsics.checkNotNull(x96);
            String uploadUid = x96.getUploadUid();
            Intrinsics.checkNotNull(uploadUid);
            GroupAlbumLayerExtraInfoBean x97 = x9();
            Intrinsics.checkNotNull(x97);
            String uploadUserName = x97.getUploadUserName();
            Intrinsics.checkNotNull(uploadUserName);
            textView.setText(sVar.a(uploadUid, uploadUserName));
        }
        TextView textView2 = this.dayTextView;
        if (textView2 != null) {
            GroupAlbumLayerExtraInfoBean x98 = x9();
            Intrinsics.checkNotNull(x98);
            textView2.setText(DateUtils.getChineseDayToSecond(x98.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String()));
        }
        GroupAlbumLayerExtraInfoBean x99 = x9();
        if (x99 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            View view2 = this.footerView;
            layoutParams = view2 != null ? view2.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = ar.e(113.0f);
            View view3 = this.footerView;
            if (view3 != null) {
                view3.setLayoutParams(layoutParams2);
            }
        } else {
            View view4 = this.footerView;
            layoutParams = view4 != null ? view4.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams3.bottomMargin = ar.e(70.0f);
            View view5 = this.footerView;
            if (view5 != null) {
                view5.setLayoutParams(layoutParams3);
            }
        }
        GroupAlbumLayerExtraInfoBean x910 = x9();
        Intrinsics.checkNotNull(x910);
        if (!TextUtils.isEmpty(x910.getUploadUserName())) {
            View view6 = this.footerView;
            if (view6 == null) {
                return;
            }
            view6.setVisibility(0);
            return;
        }
        View view7 = this.footerView;
        if (view7 == null) {
            return;
        }
        view7.setVisibility(8);
    }

    private final void D9(View rootView) {
        if (rootView == null) {
            return;
        }
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f1275913, (ViewGroup) null);
        this.footerView = inflate;
        QZoneUserAvatarView qZoneUserAvatarView = inflate != null ? (QZoneUserAvatarView) inflate.findViewById(R.id.f199775) : null;
        this.avatarView = qZoneUserAvatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setIsShieldJumpToMainPage(true);
        }
        View view = this.footerView;
        this.nickNameView = view != null ? (TextView) view.findViewById(R.id.f20067d) : null;
        View view2 = this.footerView;
        this.dayTextView = view2 != null ? (TextView) view2.findViewById(R.id.f200179) : null;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        View view3 = this.footerView;
        if (view3 != null) {
            view3.setClickable(false);
        }
        View view4 = this.footerView;
        if (view4 != null) {
            view4.setEnabled(false);
        }
        ((ViewGroup) rootView).addView(this.footerView, layoutParams);
        View view5 = this.footerView;
        if (view5 == null) {
            return;
        }
        view5.setVisibility(8);
    }
}
