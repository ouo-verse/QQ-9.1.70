package com.qzone.reborn.albumx.qzonex.part.layer;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxLayerPraiseEvent;
import com.qzone.reborn.albumx.qzonex.part.layer.ad;
import com.qzone.reborn.base.n;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J&\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\bR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/ad;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "", "K9", "G9", "", "hasPraise", "P9", "", "I9", "J9", "Lbb/e;", "praiseInfo", "O9", "praiseCount", "N9", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/os/Bundle;", "data", "initIntentData", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "batch", "isSuccess", "", QzoneIPCModule.RESULT_CODE, "opType", "H9", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mPraiseNum", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mPraiseIcon", "Loc/u;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Loc/u;", "operateViewModel", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "feedId", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad extends com.qzone.reborn.albumx.qzonex.part.layer.b {

    /* renamed from: C, reason: from kotlin metadata */
    private String feedId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mPraiseNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mPraiseIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private oc.u operateViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/layer/ad$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "t", "", "retCode", "", "msg", "", "isFinish", "", "c", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<CommonStLike> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ bb.f f53136b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f53137c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bb.e f53138d;

        b(bb.f fVar, int i3, bb.e eVar) {
            this.f53136b = fVar;
            this.f53137c = i3;
            this.f53138d = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ad this$0, bb.e praiseInfo, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(praiseInfo, "$praiseInfo");
            this$0.O9(praiseInfo);
            com.qzone.reborn.util.o.f59556a.b(str);
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CommonStLike t16, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ad.this.H9(false, true, retCode, 1);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String linkId = this.f53136b.getLinkId();
            QZAlbumxLayerExtraInfoBean x95 = ad.this.x9();
            if (x95 == null || (str = x95.getLLoc()) == null) {
                str = "";
            }
            simpleEventBus.dispatchEvent(new QZAlbumxLayerPraiseEvent(linkId, str, true, this.f53137c));
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, final String errorMsg) {
            ad.this.H9(false, false, errorCode, 1);
            this.f53138d.d(false);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ad adVar = ad.this;
            final bb.e eVar = this.f53138d;
            uIHandlerV2.post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ad.b.b(ad.this, eVar, errorMsg);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/layer/ad$c", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "t", "", "retCode", "", "msg", "", "isFinish", "", "c", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<CommonStLike> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bb.f f53139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ad f53140b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f53141c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bb.e f53142d;

        c(bb.f fVar, ad adVar, int i3, bb.e eVar) {
            this.f53139a = fVar;
            this.f53140b = adVar;
            this.f53141c = i3;
            this.f53142d = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ad this$0, bb.e praiseInfo, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(praiseInfo, "$praiseInfo");
            this$0.O9(praiseInfo);
            com.qzone.reborn.util.o.f59556a.b(str);
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CommonStLike t16, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String linkId = this.f53139a.getLinkId();
            QZAlbumxLayerExtraInfoBean x95 = this.f53140b.x9();
            if (x95 == null || (str = x95.getLLoc()) == null) {
                str = "";
            }
            simpleEventBus.dispatchEvent(new QZAlbumxLayerPraiseEvent(linkId, str, false, this.f53141c));
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, final String errorMsg) {
            this.f53142d.d(true);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ad adVar = this.f53140b;
            final bb.e eVar = this.f53142d;
            uIHandlerV2.post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.af
                @Override // java.lang.Runnable
                public final void run() {
                    ad.c.b(ad.this, eVar, errorMsg);
                }
            });
        }
    }

    private final void G9() {
        int I9;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String praiseKey;
        if (x9() == null || FastClickUtils.isFastDoubleClick("QZAlbumxLayerPraisePart_doPraise")) {
            return;
        }
        boolean z16 = !J9();
        if (z16) {
            I9 = I9() + 1;
        } else {
            I9 = I9() - 1;
        }
        bb.e eVar = new bb.e();
        eVar.d(z16);
        eVar.e(I9);
        O9(eVar);
        bb.f fVar = new bb.f();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        String str6 = "";
        if (x95 == null || (str = x95.getUin()) == null) {
            str = "";
        }
        fVar.k(str);
        QZAlbumxLayerExtraInfoBean x96 = x9();
        if (x96 == null || (str2 = x96.getAlbumId()) == null) {
            str2 = "";
        }
        fVar.f(str2);
        QZAlbumxLayerExtraInfoBean x97 = x9();
        if (x97 == null || (str3 = x97.getBatchId()) == null) {
            str3 = "";
        }
        fVar.g(str3);
        QZAlbumxLayerExtraInfoBean x98 = x9();
        if (x98 == null || (str4 = x98.getLLoc()) == null) {
            str4 = "";
        }
        fVar.h(str4);
        QZAlbumxLayerExtraInfoBean x99 = x9();
        if (x99 == null || (str5 = x99.getUploadUid()) == null) {
            str5 = "";
        }
        fVar.l(str5);
        QZAlbumxLayerExtraInfoBean x910 = x9();
        if (x910 != null && (praiseKey = x910.getPraiseKey()) != null) {
            str6 = praiseKey;
        }
        fVar.i(str6);
        fVar.e(z16 ? 1 : 0);
        QZAlbumxLayerExtraInfoBean x911 = x9();
        fVar.j(String.valueOf(x911 != null ? Long.valueOf(x911.getLinkId()) : null));
        if (z16) {
            oc.u uVar = this.operateViewModel;
            if (uVar != null) {
                uVar.P1(fVar, new b(fVar, I9, eVar));
                return;
            }
            return;
        }
        oc.u uVar2 = this.operateViewModel;
        if (uVar2 != null) {
            uVar2.S1(fVar, new c(fVar, this, I9, eVar));
        }
    }

    private final int I9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getPraiseNum();
        }
        return 0;
    }

    private final boolean J9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getIsPraise();
        }
        return false;
    }

    private final void K9() {
        this.operateViewModel = (oc.u) getViewModel(oc.u.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(ad this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(ad this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9(int praiseCount) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(bb.e praiseInfo) {
        P9(praiseInfo.getIsPraise());
        N9(praiseInfo.getPraiseNum());
        Q9(praiseInfo);
    }

    private final void Q9(bb.e praiseInfo) {
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
            QZAlbumxLayerExtraInfoBean x95 = x9();
            if (TextUtils.equals(mediaId, x95 != null ? x95.getLLoc() : null) && (rFWLayerItemMediaInfo.getExtraData() instanceof QZAlbumxLayerExtraInfoBean)) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean");
                QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = (QZAlbumxLayerExtraInfoBean) extraData;
                qZAlbumxLayerExtraInfoBean.M(praiseInfo.getIsPraise());
                qZAlbumxLayerExtraInfoBean.V(praiseInfo.getPraiseNum());
                rFWLayerItemMediaInfo.setExtraData(qZAlbumxLayerExtraInfoBean);
                z16 = true;
            }
        }
        if (z16) {
            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    public final void H9(boolean batch, boolean isSuccess, long resultCode, int opType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("interact_op_success", Integer.valueOf(isSuccess ? 1 : 0));
        linkedHashMap.put("business_type", Integer.valueOf(!batch ? 1 : 0));
        linkedHashMap.put("fail_error_code", Long.valueOf(resultCode));
        linkedHashMap.put("op_type", Integer.valueOf(opType));
        fo.c.c("ev_qun_album_on_interact_op", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        if (data == null || !data.containsKey("key_feed_id")) {
            return;
        }
        Object obj = data.get("key_feed_id");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        this.feedId = (String) obj;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        K9();
        Intrinsics.checkNotNull(rootView);
        this.mPraiseNum = (TextView) rootView.findViewById(R.id.f20047b);
        this.mPraiseIcon = (ImageView) rootView.findViewById(R.id.f20037a);
        TextView textView = this.mPraiseNum;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ad.L9(ad.this, view);
                }
            });
        }
        ImageView imageView = this.mPraiseIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.ac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ad.M9(ad.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        N9(I9());
        P9(J9());
    }

    private final void P9(boolean hasPraise) {
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
