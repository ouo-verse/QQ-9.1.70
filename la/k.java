package la;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014J*\u0010\u0013\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010(R\u0016\u0010-\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100\u00a8\u00068"}, d2 = {"Lla/k;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "Landroid/view/View$OnClickListener;", "data", "", "y", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "", "getLogTag", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mSinglePhotoContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mCoverIv", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mNameTv", "i", "mTimeTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mNumTv", "Landroid/view/View;", "mUpdateFlagView", "mMaskView", "E", "I", "mContainerSize", "Landroid/graphics/drawable/Drawable;", UserInfo.SEX_FEMALE, "Landroid/graphics/drawable/Drawable;", "mLoadingDrawable", "G", "mFailedDrawable", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends com.qzone.reborn.base.l<RFWUploadRecommendInfo> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View mUpdateFlagView;

    /* renamed from: D, reason: from kotlin metadata */
    private View mMaskView;

    /* renamed from: E, reason: from kotlin metadata */
    private int mContainerSize;

    /* renamed from: F, reason: from kotlin metadata */
    private Drawable mLoadingDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    private Drawable mFailedDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout mSinglePhotoContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mCoverIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mNameTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTimeTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mNumTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A(k this$0, ia.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RoundCorneredFrameLayout roundCorneredFrameLayout = this$0.mSinglePhotoContainer;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout = null;
        }
        aVar.m9(roundCorneredFrameLayout, this$0.mPosition, (RFWUploadRecommendInfo) this$0.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(k this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handleSinglePhotoClick] getIoc error = " + str);
    }

    private final void D(final RFWUploadRecommendInfo data) {
        IocPromise ioc = RFWIocAbilityProvider.g().getIoc(ia.d.class);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mSinglePhotoContainer;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout = null;
        }
        ioc.originView(roundCorneredFrameLayout).done(new OnPromiseResolved() { // from class: la.i
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                k.F(RFWUploadRecommendInfo.this, this, (ia.d) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.j
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                k.G(k.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(RFWUploadRecommendInfo data, k this$0, ia.d dVar) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean a16 = dVar.a(data);
        View view = null;
        if (a16) {
            View view2 = this$0.mUpdateFlagView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUpdateFlagView");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this$0.mUpdateFlagView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUpdateFlagView");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(k this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[updateUpdateFlag] getIoc error = " + str);
    }

    private final void z() {
        QLog.d(getTAG(), 1, "[handleSinglePhotoClick]");
        IocPromise ioc = RFWIocAbilityProvider.g().getIoc(ia.a.class);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mSinglePhotoContainer;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout = null;
        }
        ioc.originView(roundCorneredFrameLayout).done(new OnPromiseResolved() { // from class: la.g
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                k.A(k.this, (ia.a) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.h
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                k.B(k.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(RFWUploadRecommendInfo data, int position, List<Object> payload) {
        RFWClassifyInfo classifyInfo;
        ImageView imageView = null;
        QLog.d(getTAG(), 1, "[onBindData] position = " + position + ", classifyId = " + ((data == null || (classifyInfo = data.getClassifyInfo()) == null) ? null : classifyInfo.getClassifyId()));
        if (data != null) {
            TextView textView = this.mNameTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                textView = null;
            }
            textView.setText(data.getDisplayName());
            if (data.getLastTakePicTime() != 0) {
                TextView textView2 = this.mTimeTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeTv");
                    textView2 = null;
                }
                textView2.setVisibility(0);
                TextView textView3 = this.mTimeTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeTv");
                    textView3 = null;
                }
                textView3.setText(e.INSTANCE.a().format(Long.valueOf(data.getLastTakePicTime())));
            } else {
                TextView textView4 = this.mTimeTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimeTv");
                    textView4 = null;
                }
                textView4.setVisibility(8);
            }
            if (data.getRecommendCount() > 0) {
                TextView textView5 = this.mNumTv;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumTv");
                    textView5 = null;
                }
                textView5.setVisibility(0);
                TextView textView6 = this.mNumTv;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumTv");
                    textView6 = null;
                }
                textView6.setText(String.valueOf(data.getRecommendCount()));
            } else {
                TextView textView7 = this.mNumTv;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumTv");
                    textView7 = null;
                }
                textView7.setVisibility(8);
            }
            RFWMediaInfo firstMediaInfo = data.getFirstMediaInfo();
            Option e16 = com.tencent.mobileqq.qzone.picload.c.e(firstMediaInfo != null ? firstMediaInfo.getMPath() : null);
            ImageView imageView2 = this.mCoverIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
            } else {
                imageView = imageView2;
            }
            e16.setTargetView(imageView);
            e16.setRequestWidth(this.mContainerSize);
            e16.setRequestHeight(this.mContainerSize);
            e16.setLoadingDrawable(this.mLoadingDrawable);
            e16.setFailedDrawable(this.mFailedDrawable);
            com.tencent.mobileqq.qzone.picload.c.a().h(e16);
            D(data);
        }
        y(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendSinglePhotoContentSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && v3.getId() == R.id.moy) {
            z();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.moy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ecommend_single_photo_fl)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById;
        this.mSinglePhotoContainer = roundCorneredFrameLayout;
        pl.a aVar = pl.a.f426446a;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout = null;
        }
        int o16 = aVar.o(roundCorneredFrameLayout.getContext());
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.mSinglePhotoContainer;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout2 = null;
        }
        this.mContainerSize = (o16 - (3 * DisplayUtil.dip2px(roundCorneredFrameLayout2.getContext(), 16.0f))) / 2;
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.mSinglePhotoContainer;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout3 = null;
        }
        ViewGroup.LayoutParams layoutParams = roundCorneredFrameLayout3.getLayoutParams();
        if (layoutParams != null) {
            int i3 = this.mContainerSize;
            layoutParams.width = i3;
            layoutParams.height = i3;
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout4 = this.mSinglePhotoContainer;
        if (roundCorneredFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout4 = null;
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout5 = this.mSinglePhotoContainer;
        if (roundCorneredFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout5 = null;
        }
        roundCorneredFrameLayout4.setRadius(DisplayUtil.dip2px(roundCorneredFrameLayout5.getContext(), 8.0f));
        RoundCorneredFrameLayout roundCorneredFrameLayout6 = this.mSinglePhotoContainer;
        if (roundCorneredFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
            roundCorneredFrameLayout6 = null;
        }
        roundCorneredFrameLayout6.setOnClickListener(this);
        View findViewById2 = containerView.findViewById(R.id.mox);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026nd_single_photo_cover_iv)");
        this.mCoverIv = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mov);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026_photo_recommend_name_tv)");
        this.mNameTv = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.moz);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026_photo_recommend_time_tv)");
        this.mTimeTv = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.mol);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026photo_recommend_count_tv)");
        this.mNumTv = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.moq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026hoto_recommend_mask_view)");
        this.mMaskView = findViewById6;
        if (findViewById6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskView");
            findViewById6 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = findViewById6.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = (int) (this.mContainerSize * 0.36d);
        }
        View findViewById7 = containerView.findViewById(R.id.f162797mp0);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026to_recommend_update_flag)");
        this.mUpdateFlagView = findViewById7;
        this.mLoadingDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at8, null);
        this.mFailedDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at_, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mqe};
    }

    private final void y(RFWUploadRecommendInfo data) {
        if (data != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cluster_card_ids", data.getClassifyInfo().getClassifyId());
            linkedHashMap.put(IPublicAccountConfigAttr.CARD_STYLE, 2);
            fo.b i3 = new fo.b().l(linkedHashMap).i(data.getClassifyInfo().toString());
            RoundCorneredFrameLayout roundCorneredFrameLayout = this.mSinglePhotoContainer;
            if (roundCorneredFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSinglePhotoContainer");
                roundCorneredFrameLayout = null;
            }
            fo.c.o(roundCorneredFrameLayout, "em_qz_single_cluster_card", i3);
        }
    }
}
