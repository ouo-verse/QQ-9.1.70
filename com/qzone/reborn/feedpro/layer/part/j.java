package com.qzone.reborn.feedpro.layer.part;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedCommentManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\"\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/j;", "Lcom/qzone/reborn/feedpro/layer/part/c;", "", "commentCount", "", "T9", "O9", "P9", "L9", "M9", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelResultBean;", "commentResultBean", "S9", "Lge/a;", "commentInfo", "V9", "W9", "U9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "N9", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "intent", "onActivityResult", "i", "Landroid/view/View;", "commentContainer", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "commentNum", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "commentIcon", "D", "commentInput", "Lke/d;", "E", "Lke/d;", "operateViewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends c {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView commentIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView commentInput;

    /* renamed from: E, reason: from kotlin metadata */
    private ke.d operateViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View commentContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView commentNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/layer/part/j$b", "Lcom/qzone/reborn/base/n$a;", "Lge/a;", "bean", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<ge.a> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ge.a bean, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QQToastUtil.showQQToastInUiThread(5, "\u8bc4\u8bba\u6210\u529f");
            j.this.V9(bean);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QQToastUtil.showQQToastInUiThread(5, "\u8bc4\u8bba\u5931\u8d25, \u8bf7\u7a0d\u540e\u91cd\u8bd5");
            j.this.T9(r1.O9() - 1);
        }
    }

    private final void L9() {
        fo.c.n(this.commentContainer, "em_qz_comment");
    }

    private final void M9() {
        fo.c.n(this.commentInput, "em_qz_comment_box");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int O9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getCommentNum();
        }
        return 0;
    }

    private final void P9() {
        QZoneCommentPanelParams params = new QZoneCommentPanelParams.a().y(256).q(cd.c.j(false, null, 3, null)).g(N9()).getParams();
        ad.a c16 = ho.i.c();
        Fragment hostFragment = getHostFragment();
        ke.d dVar = this.operateViewModel;
        c16.f(params, hostFragment, dVar != null ? dVar.getCommonFeed() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S9(QZoneCommentPanelResultBean commentResultBean) {
        String str;
        int O9 = O9() + 1;
        T9(O9);
        ke.d dVar = this.operateViewModel;
        CommonComment buildFakeComment$default = QzoneFeedCommentManager.Companion.buildFakeComment$default(QzoneFeedCommentManager.INSTANCE, dVar != null ? dVar.T1() : null, CommonFeedDataUtil.INSTANCE.stringToRichMsg(commentResultBean.getInputContent()), null, null, 12, null);
        ge.b bVar = new ge.b();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        bVar.i(str);
        bVar.g(buildFakeComment$default);
        bVar.h(O9);
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        bVar.f(x96 != null ? x96.getBatchId() : 0L);
        ke.d dVar2 = this.operateViewModel;
        if (dVar2 != null) {
            dVar2.M1(bVar, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(int commentCount) {
        TextView textView = this.commentNum;
        if (textView == null) {
            return;
        }
        if (commentCount > 0) {
            String p16 = tk.h.p(commentCount);
            TextView textView2 = this.commentNum;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(p16);
            TextView textView3 = this.commentNum;
            Intrinsics.checkNotNull(textView3);
            textView3.setContentDescription(com.qzone.util.l.a(R.string.s3x) + p16);
            return;
        }
        Intrinsics.checkNotNull(textView);
        textView.setText(com.qzone.util.l.a(R.string.s3x));
        TextView textView4 = this.commentNum;
        Intrinsics.checkNotNull(textView4);
        textView4.setContentDescription(com.qzone.util.l.a(R.string.s3x));
    }

    private final void U9(ge.a commentInfo) {
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data = value.getData()) == null) ? null : data.getRichMediaDataList();
        boolean z16 = false;
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        Intrinsics.checkNotNull(richMediaDataList);
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            String mediaId = rFWLayerItemMediaInfo.getMediaId();
            QzoneFeedProLayerExtraInfoBean x95 = x9();
            if (TextUtils.equals(mediaId, x95 != null ? x95.getLLoc() : null) && (rFWLayerItemMediaInfo.getExtraData() instanceof QzoneFeedProLayerExtraInfoBean)) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean");
                QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = (QzoneFeedProLayerExtraInfoBean) extraData;
                qzoneFeedProLayerExtraInfoBean.t(commentInfo.getCommentNum());
                rFWLayerItemMediaInfo.setExtraData(qzoneFeedProLayerExtraInfoBean);
                z16 = true;
            }
        }
        if (z16) {
            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(ge.a commentInfo) {
        ke.d dVar = this.operateViewModel;
        if (CommonFeedExtKt.isAlbumFeed(dVar != null ? dVar.getCommonFeed() : null)) {
            ke.d dVar2 = this.operateViewModel;
            if ((dVar2 != null ? dVar2.getForwardFeed() : null) == null) {
                U9(commentInfo);
                return;
            }
        }
        W9(commentInfo);
    }

    private final void W9(ge.a commentInfo) {
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data = value.getData()) == null) ? null : data.getRichMediaDataList();
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        Intrinsics.checkNotNull(richMediaDataList);
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            if (rFWLayerItemMediaInfo.getExtraData() instanceof QzoneFeedProLayerExtraInfoBean) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean");
                QzoneFeedProLayerExtraInfoBean qzoneFeedProLayerExtraInfoBean = (QzoneFeedProLayerExtraInfoBean) extraData;
                qzoneFeedProLayerExtraInfoBean.t(commentInfo.getCommentNum());
                rFWLayerItemMediaInfo.setExtraData(qzoneFeedProLayerExtraInfoBean);
            }
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    public final String N9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        long ownerUin = x95 != null ? x95.getOwnerUin() : 0L;
        String str = "";
        if (ownerUin >= 10001) {
            str = "" + ownerUin;
        }
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        if (!TextUtils.isEmpty(x96 != null ? x96.getAlbumId() : null)) {
            QzoneFeedProLayerExtraInfoBean x97 = x9();
            str = str + "_" + (x97 != null ? x97.getAlbumId() : null);
        }
        QzoneFeedProLayerExtraInfoBean x98 = x9();
        if (TextUtils.isEmpty(x98 != null ? x98.getLLoc() : null)) {
            return str;
        }
        QzoneFeedProLayerExtraInfoBean x99 = x9();
        return str + "_" + (x99 != null ? x99.getLLoc() : null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == -1 && intent != null && requestCode == 256) {
            QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) intent.getParcelableExtra("comment_panel_result_bean");
            if (qZoneCommentPanelResultBean == null) {
                RFWLog.fatal("QzoneFeedProCommentPart", RFWLog.USR, new RuntimeException("commentResultBean is null"));
            } else {
                S9(qZoneCommentPanelResultBean);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.operateViewModel = (ke.d) getViewModel(ke.d.class);
        this.commentContainer = rootView != null ? rootView.findViewById(R.id.mwp) : null;
        this.commentIcon = rootView != null ? (ImageView) rootView.findViewById(R.id.mwq) : null;
        this.commentNum = rootView != null ? (TextView) rootView.findViewById(R.id.mws) : null;
        this.commentInput = rootView != null ? (TextView) rootView.findViewById(R.id.mwr) : null;
        View view = this.commentContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.Q9(j.this, view2);
                }
            });
        }
        TextView textView = this.commentInput;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.R9(j.this, view2);
                }
            });
        }
        L9();
        M9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        String tag = getTAG();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        QLog.e(tag, 1, "handleCommentListResponse  lloc=" + (x95 != null ? x95.getLLoc() : null));
        T9(O9());
    }
}
