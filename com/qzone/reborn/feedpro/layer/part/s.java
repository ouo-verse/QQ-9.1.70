package com.qzone.reborn.feedpro.layer.part;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.OverlayInfo;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/s;", "Lcom/qzone/reborn/feedpro/layer/part/c;", "", "K9", "", "hasPraise", "S9", "", "latestPraiseNum", "L9", "M9", "N9", "O9", "P9", "praiseCount", "R9", "Lge/d;", "praiseInfo", "V9", "U9", "T9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "i", "Landroid/view/View;", "praiseContainer", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mPraiseNum", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mPraiseIcon", "Lke/d;", "D", "Lke/d;", "operateViewModel", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class s extends com.qzone.reborn.feedpro.layer.part.c {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mPraiseIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private ke.d operateViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View praiseContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mPraiseNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/layer/part/s$b", "Lcom/qzone/reborn/base/n$a;", "Lge/d;", "", "errorCode", "", "errorMsg", "", "onFailure", "bean", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<ge.d> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f53961b;

        b(int i3) {
            this.f53961b = i3;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ge.d bean, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("QzoneFeedProLayerPraisePart", 1, "[doPraiseRequest] | lLoc is " + bean.getLLoc() + ", is praise is " + bean.getIsPraise() + ", praise num is " + bean.getPraiseNum());
            s.this.V9(bean);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e("QzoneFeedProLayerPraisePart", 1, "doPraiseRequest fail, errorCode is " + errorCode + ", errorMsg is " + errorMsg);
            s.this.S9(false);
            s.this.R9(this.f53961b - 1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/layer/part/s$c", "Lcom/qzone/reborn/base/n$a;", "Lge/d;", "", "errorCode", "", "errorMsg", "", "onFailure", "bean", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<ge.d> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f53963b;

        c(int i3) {
            this.f53963b = i3;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ge.d bean, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i("QzoneFeedProLayerPraisePart", 1, "[doUnPraiseRequest] | lLoc is " + bean.getLLoc() + ", is praise is " + bean.getIsPraise() + ", praise num is " + bean.getPraiseNum());
            s.this.V9(bean);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e("QzoneFeedProLayerPraisePart", 1, "doUnPraiseRequest fail, errorCode is " + errorCode + ", errorMsg is " + errorMsg);
            s.this.S9(true);
            s.this.R9(this.f53963b + 1);
        }
    }

    private final void K9() {
        int O9;
        if (x9() == null) {
            return;
        }
        boolean z16 = !P9();
        if (z16) {
            O9 = O9() + 1;
        } else {
            O9 = O9() - 1;
        }
        S9(z16);
        R9(O9);
        if (z16) {
            L9(O9);
        } else {
            N9(O9);
        }
    }

    private final void L9(int latestPraiseNum) {
        String str;
        ge.e eVar = new ge.e();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        eVar.f(new OverlayInfo(str));
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        eVar.e(x96 != null ? x96.getBatchId() : 0L);
        eVar.h(latestPraiseNum);
        eVar.g(true);
        ke.d dVar = this.operateViewModel;
        if (dVar != null) {
            dVar.O1(eVar, new b(latestPraiseNum));
        }
    }

    private final void M9() {
        fo.c.n(this.praiseContainer, "em_qz_like");
    }

    private final void N9(int latestPraiseNum) {
        String str;
        ge.e eVar = new ge.e();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        eVar.f(new OverlayInfo(str));
        QzoneFeedProLayerExtraInfoBean x96 = x9();
        eVar.e(x96 != null ? x96.getBatchId() : 0L);
        eVar.h(latestPraiseNum);
        eVar.g(false);
        ke.d dVar = this.operateViewModel;
        if (dVar != null) {
            dVar.P1(eVar, new c(latestPraiseNum));
        }
    }

    private final int O9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getPraiseNum();
        }
        return 0;
    }

    private final boolean P9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getIsPraise();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(int praiseCount) {
        String a16;
        TextView textView = this.mPraiseNum;
        if (textView == null) {
            return;
        }
        if (praiseCount > 0) {
            a16 = tk.h.p(praiseCount);
        } else {
            a16 = com.qzone.util.l.a(R.string.s3q);
        }
        textView.setText(a16);
    }

    private final void T9(ge.d praiseInfo) {
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
                qzoneFeedProLayerExtraInfoBean.z(praiseInfo.getIsPraise());
                qzoneFeedProLayerExtraInfoBean.A(praiseInfo.getPraiseNum());
                rFWLayerItemMediaInfo.setExtraData(qzoneFeedProLayerExtraInfoBean);
                z16 = true;
            }
        }
        if (z16) {
            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    private final void U9(ge.d praiseInfo) {
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
                qzoneFeedProLayerExtraInfoBean.z(praiseInfo.getIsPraise());
                qzoneFeedProLayerExtraInfoBean.A(praiseInfo.getPraiseNum());
                rFWLayerItemMediaInfo.setExtraData(qzoneFeedProLayerExtraInfoBean);
            }
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(ge.d praiseInfo) {
        ke.d dVar = this.operateViewModel;
        if (CommonFeedExtKt.isAlbumFeed(dVar != null ? dVar.getCommonFeed() : null)) {
            ke.d dVar2 = this.operateViewModel;
            if ((dVar2 != null ? dVar2.getForwardFeed() : null) == null) {
                T9(praiseInfo);
                return;
            }
        }
        U9(praiseInfo);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.operateViewModel = (ke.d) getViewModel(ke.d.class);
        this.praiseContainer = rootView != null ? rootView.findViewById(R.id.mwy) : null;
        this.mPraiseNum = rootView != null ? (TextView) rootView.findViewById(R.id.f162839mx0) : null;
        this.mPraiseIcon = rootView != null ? (ImageView) rootView.findViewById(R.id.mwz) : null;
        View view = this.praiseContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.layer.part.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    s.Q9(s.this, view2);
                }
            });
        }
        M9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        R9(O9());
        S9(P9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(boolean hasPraise) {
        if (hasPraise) {
            ImageView imageView = this.mPraiseIcon;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.qui_like_filled_brand);
            }
            ImageView imageView2 = this.mPraiseIcon;
            if (imageView2 == null) {
                return;
            }
            imageView2.setContentDescription(com.qzone.util.l.a(R.string.s3u));
            return;
        }
        ImageView imageView3 = this.mPraiseIcon;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.qui_like);
        }
        ImageView imageView4 = this.mPraiseIcon;
        if (imageView4 != null) {
            imageView4.setContentDescription(com.qzone.util.l.a(R.string.f172561s45));
        }
        com.tencent.mobileqq.qzone.picload.c.a().m(this.mPraiseIcon, -1);
    }
}
