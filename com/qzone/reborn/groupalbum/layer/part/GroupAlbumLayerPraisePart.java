package com.qzone.reborn.groupalbum.layer.part;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLike;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerPraiseEvent;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J&\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\bR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerPraisePart;", "Lcom/qzone/reborn/groupalbum/layer/part/b;", "", "O9", "J9", "", "hasPraise", "T9", "", "L9", "M9", "praiseCount", "S9", "Lci/f;", "praiseInfo", "U9", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/os/Bundle;", "data", "initIntentData", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "batch", "isSuccess", "", QzoneIPCModule.RESULT_CODE, "opType", "K9", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mPraiseNum", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mPraiseIcon", "Lii/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lii/f;", "operateViewModel", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "feedId", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumLayerPraisePart extends com.qzone.reborn.groupalbum.layer.part.b {

    /* renamed from: C, reason: from kotlin metadata */
    private String feedId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mPraiseNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mPraiseIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ii.f operateViewModel;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerPraisePart$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLike;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<CommonStLike> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(CommonStLike t16, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            GroupAlbumLayerPraisePart.this.K9(false, true, retCode, 1);
            if (GroupAlbumLayerPraisePart.this.M9()) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str2 = GroupAlbumLayerPraisePart.this.feedId;
                GroupAlbumLayerExtraInfoBean x95 = GroupAlbumLayerPraisePart.this.x9();
                if (x95 == null || (str = x95.getLLoc()) == null) {
                    str = "";
                }
                simpleEventBus.dispatchEvent(new GroupAlbumLayerPraiseEvent(str2, str));
            }
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            GroupAlbumLayerPraisePart.this.K9(false, false, errorCode, 1);
            com.qzone.reborn.util.o.f59556a.b(errorMsg);
        }
    }

    private final void J9() {
        int L9;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String praiseKey;
        if (x9() == null) {
            return;
        }
        boolean z16 = !M9();
        if (z16) {
            L9 = L9() + 1;
        } else {
            L9 = L9() - 1;
        }
        T9(z16);
        S9(L9);
        ci.f fVar = new ci.f();
        fVar.d(z16);
        fVar.e(L9);
        U9(fVar);
        ci.g gVar = new ci.g();
        GroupAlbumLayerExtraInfoBean x95 = x9();
        String str6 = "";
        if (x95 == null || (str = x95.getGroupId()) == null) {
            str = "";
        }
        gVar.l(str);
        GroupAlbumLayerExtraInfoBean x96 = x9();
        if (x96 == null || (str2 = x96.getAlbumId()) == null) {
            str2 = "";
        }
        gVar.j(str2);
        GroupAlbumLayerExtraInfoBean x97 = x9();
        if (x97 == null || (str3 = x97.getBatchId()) == null) {
            str3 = "";
        }
        gVar.k(str3);
        GroupAlbumLayerExtraInfoBean x98 = x9();
        if (x98 == null || (str4 = x98.getLLoc()) == null) {
            str4 = "";
        }
        gVar.m(str4);
        GroupAlbumLayerExtraInfoBean x99 = x9();
        if (x99 == null || (str5 = x99.getUploadUid()) == null) {
            str5 = "";
        }
        gVar.o(str5);
        GroupAlbumLayerExtraInfoBean x910 = x9();
        if (x910 != null && (praiseKey = x910.getPraiseKey()) != null) {
            str6 = praiseKey;
        }
        gVar.n(str6);
        gVar.i(z16 ? 1 : 0);
        ii.f fVar2 = this.operateViewModel;
        if (fVar2 != null) {
            fVar2.L1(gVar, new b());
        }
    }

    private final int L9() {
        GroupAlbumLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getPraiseNum();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M9() {
        GroupAlbumLayerExtraInfoBean x95 = x9();
        if (x95 != null) {
            return x95.getIsPraise();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(ci.f praiseInfo) {
        if (TextUtils.isEmpty(praiseInfo.getPraiseKey())) {
            return;
        }
        String praiseKey = praiseInfo.getPraiseKey();
        GroupAlbumLayerExtraInfoBean x95 = x9();
        if (Intrinsics.areEqual(praiseKey, x95 != null ? x95.getPraiseKey() : null) && !praiseInfo.getIsSuccess()) {
            S9(L9() - 1);
            T9(!M9());
            U9(praiseInfo);
        }
    }

    private final void O9() {
        MutableLiveData<ci.f> M1;
        ii.f fVar = (ii.f) getViewModel(ii.f.class);
        this.operateViewModel = fVar;
        if (fVar == null || (M1 = fVar.M1()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<ci.f, Unit> function1 = new Function1<ci.f, Unit>() { // from class: com.qzone.reborn.groupalbum.layer.part.GroupAlbumLayerPraisePart$initOperateViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ci.f fVar2) {
                invoke2(fVar2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ci.f it) {
                GroupAlbumLayerPraisePart groupAlbumLayerPraisePart = GroupAlbumLayerPraisePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                groupAlbumLayerPraisePart.N9(it);
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.groupalbum.layer.part.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumLayerPraisePart.P9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(GroupAlbumLayerPraisePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(GroupAlbumLayerPraisePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S9(int praiseCount) {
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

    private final void U9(ci.f praiseInfo) {
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
            GroupAlbumLayerExtraInfoBean x95 = x9();
            if (TextUtils.equals(mediaId, x95 != null ? x95.getLLoc() : null) && (rFWLayerItemMediaInfo.getExtraData() instanceof GroupAlbumLayerExtraInfoBean)) {
                Object extraData = rFWLayerItemMediaInfo.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean");
                GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean = (GroupAlbumLayerExtraInfoBean) extraData;
                groupAlbumLayerExtraInfoBean.A(praiseInfo.getIsPraise());
                groupAlbumLayerExtraInfoBean.C(praiseInfo.getPraiseNum());
                rFWLayerItemMediaInfo.setExtraData(groupAlbumLayerExtraInfoBean);
                z16 = true;
            }
        }
        if (z16) {
            getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    public final void K9(boolean batch, boolean isSuccess, long resultCode, int opType) {
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
        O9();
        Intrinsics.checkNotNull(rootView);
        this.mPraiseNum = (TextView) rootView.findViewById(R.id.f20047b);
        this.mPraiseIcon = (ImageView) rootView.findViewById(R.id.f20037a);
        TextView textView = this.mPraiseNum;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.layer.part.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupAlbumLayerPraisePart.Q9(GroupAlbumLayerPraisePart.this, view);
                }
            });
        }
        ImageView imageView = this.mPraiseIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.layer.part.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupAlbumLayerPraisePart.R9(GroupAlbumLayerPraisePart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        S9(L9());
        T9(M9());
    }

    private final void T9(boolean hasPraise) {
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
