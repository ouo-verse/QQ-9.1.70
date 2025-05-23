package la;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
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
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001<B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0014J*\u0010\u0011\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0018\u00109\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lla/o;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "Landroid/view/View$OnClickListener;", "data", "", "w", "Landroid/view/View;", "v", HippyTKDListViewAdapter.X, "containerView", "onInitView", "", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.ON_CLICK, "", "getViewStubLayoutId", "", "getLogTag", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mSectionContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mCoverIv", "Landroid/view/ViewGroup;", tl.h.F, "Landroid/view/ViewGroup;", "mDisplayInfoView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mNameTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTimeTv", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mMaskView", "Landroid/graphics/drawable/Drawable;", "D", "Landroid/graphics/drawable/Drawable;", "mLoadingDrawable", "E", "mFailedDrawable", UserInfo.SEX_FEMALE, "I", "mContainerWidth", "G", "mContainerHeight", "H", "Ljava/lang/String;", "mPicUrl", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class o extends com.qzone.reborn.base.l<RFWUploadRecommendInfo> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View mMaskView;

    /* renamed from: D, reason: from kotlin metadata */
    private Drawable mLoadingDrawable;

    /* renamed from: E, reason: from kotlin metadata */
    private Drawable mFailedDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    private int mContainerWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private int mContainerHeight;

    /* renamed from: H, reason: from kotlin metadata */
    private String mPicUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout mSectionContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mCoverIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mDisplayInfoView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mNameTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTimeTv;

    private final void x(final View v3) {
        QLog.d(getTAG(), 1, "[handleVideoItemClick]");
        RFWIocAbilityProvider.g().getIoc(ia.a.class).originView(v3).done(new OnPromiseResolved() { // from class: la.m
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                o.y(v3, this, (ia.a) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: la.n
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                o.z(o.this, str);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(View v3, o this$0, ia.a aVar) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aVar.R8(v3, this$0.mPosition, (RFWUploadRecommendInfo) this$0.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(o this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e(this$0.getTAG(), 1, "[handleVideoItemClick] getIoc error = " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(RFWUploadRecommendInfo data, int position, List<Object> payload) {
        if (data != null) {
            TextView textView = this.mNameTv;
            ImageView imageView = null;
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
            String str = this.mPicUrl;
            RFWMediaInfo firstMediaInfo = data.getFirstMediaInfo();
            if (TextUtils.equals(str, firstMediaInfo != null ? firstMediaInfo.getMPath() : null)) {
                QLog.d(getTAG(), 1, "[onBindData] position = " + position + ", picUrl equals");
                return;
            }
            RFWMediaInfo firstMediaInfo2 = data.getFirstMediaInfo();
            this.mPicUrl = firstMediaInfo2 != null ? firstMediaInfo2.getMPath() : null;
            RFWMediaInfo firstMediaInfo3 = data.getFirstMediaInfo();
            Option e16 = com.tencent.mobileqq.qzone.picload.c.e(firstMediaInfo3 != null ? firstMediaInfo3.getMPath() : null);
            ImageView imageView2 = this.mCoverIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCoverIv");
            } else {
                imageView = imageView2;
            }
            e16.setTargetView(imageView);
            e16.setRequestWidth(this.mContainerWidth);
            e16.setRequestHeight(this.mContainerHeight);
            e16.setLoadingDrawable(this.mLoadingDrawable);
            e16.setFailedDrawable(this.mFailedDrawable);
            com.tencent.mobileqq.qzone.picload.c.a().h(e16);
        }
        if (data == null) {
            QLog.d(getTAG(), 1, "[onBindData] position = " + position + ", data is null");
        }
        w(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendMakeVideoItemContentSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && v3.getId() == R.id.moo) {
            x(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.moo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026tem_content_container_fl)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById;
        this.mSectionContainer = roundCorneredFrameLayout;
        mk.g gVar = mk.g.f416876a;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
            roundCorneredFrameLayout = null;
        }
        int parseColor = Color.parseColor("#AFAFAF");
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.mSectionContainer;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
            roundCorneredFrameLayout2 = null;
        }
        gVar.a(roundCorneredFrameLayout, parseColor, DisplayUtil.dip2px(roundCorneredFrameLayout2.getContext(), 4.0f), false);
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.mSectionContainer;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
            roundCorneredFrameLayout3 = null;
        }
        roundCorneredFrameLayout3.setOnClickListener(this);
        RoundCorneredFrameLayout roundCorneredFrameLayout4 = this.mSectionContainer;
        if (roundCorneredFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
            roundCorneredFrameLayout4 = null;
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout5 = this.mSectionContainer;
        if (roundCorneredFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
            roundCorneredFrameLayout5 = null;
        }
        roundCorneredFrameLayout4.setRadius(DisplayUtil.dip2px(roundCorneredFrameLayout5.getContext(), 8.0f));
        RoundCorneredFrameLayout roundCorneredFrameLayout6 = this.mSectionContainer;
        if (roundCorneredFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
            roundCorneredFrameLayout6 = null;
        }
        ViewGroup.LayoutParams layoutParams = roundCorneredFrameLayout6.getLayoutParams();
        if (layoutParams != null) {
            pl.a aVar = pl.a.f426446a;
            RoundCorneredFrameLayout roundCorneredFrameLayout7 = this.mSectionContainer;
            if (roundCorneredFrameLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
                roundCorneredFrameLayout7 = null;
            }
            double o16 = aVar.o(roundCorneredFrameLayout7.getContext());
            int i3 = (int) ((240.0d * o16) / 375.0d);
            this.mContainerWidth = i3;
            int i16 = (int) ((o16 * 320.0d) / 375.0d);
            this.mContainerHeight = i16;
            layoutParams.width = i3;
            layoutParams.height = i16;
        }
        View findViewById2 = containerView.findViewById(R.id.f162798mp1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026recommend_video_cover_iv)");
        this.mCoverIv = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ecommend_display_info_ll)");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        this.mDisplayInfoView = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDisplayInfoView");
            viewGroup = null;
        }
        ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
        FrameLayout.LayoutParams layoutParams3 = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
        if (layoutParams3 != null) {
            layoutParams3.leftMargin = ar.d(16.0f);
            layoutParams3.bottomMargin = ar.d(16.7f);
        }
        View findViewById4 = containerView.findViewById(R.id.mov);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026_photo_recommend_name_tv)");
        TextView textView = (TextView) findViewById4;
        this.mNameTv = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
            textView = null;
        }
        textView.setTextSize(24.0f);
        View findViewById5 = containerView.findViewById(R.id.moz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026_photo_recommend_time_tv)");
        TextView textView2 = (TextView) findViewById5;
        this.mTimeTv = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeTv");
            textView2 = null;
        }
        textView2.setTextSize(14.0f);
        View findViewById6 = containerView.findViewById(R.id.moq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026hoto_recommend_mask_view)");
        this.mMaskView = findViewById6;
        if (findViewById6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaskView");
            findViewById6 = null;
        }
        findViewById6.getLayoutParams().height = (int) (this.mContainerHeight * 0.36d);
        this.mLoadingDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at8, null);
        this.mFailedDrawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.at_, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mqg};
    }

    private final void w(RFWUploadRecommendInfo data) {
        if (data != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cluster_card_ids", data.getClassifyInfo().getClassifyId());
            fo.b i3 = new fo.b().l(linkedHashMap).i(data.getClassifyInfo().toString());
            RoundCorneredFrameLayout roundCorneredFrameLayout = this.mSectionContainer;
            if (roundCorneredFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSectionContainer");
                roundCorneredFrameLayout = null;
            }
            fo.c.o(roundCorneredFrameLayout, "em_qz_single_video_card", i3);
        }
    }
}
