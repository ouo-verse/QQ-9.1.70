package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerFrameLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.model.CellColorfulTail;
import cooperation.qzone.model.PhotoInfo;
import eo.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0018\u00104\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010%R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010,\u00a8\u0006A"}, d2 = {"Lcom/qzone/reborn/layer/part/u;", "Lcom/qzone/reborn/layer/part/ap;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "Lcooperation/qzone/model/CellColorfulTail;", "bigTail", "", "U9", TextNode.MODE_TAIL, "", "O9", "", "url", "T9", "V9", "S9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "isVisible", "onVisibleChange", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerFrameLayout;", "G", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerFrameLayout;", "shimmerRootView", "H", "Landroid/view/View;", "bigTailBackgroundRootView", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "iconImageView", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "titleTextView", "K", "contentTextView", "L", "userCountTextView", "M", "bottomView", "N", "Z", "isSelectedVideoControlViewVisible", "P", "isChangeOrientation", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "lastChangeOrientationTime", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class u extends ap implements IVideoControlLayoutChangeListener {

    /* renamed from: R, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int S = com.qzone.util.ar.e(16.0f);
    private static final int T = com.qzone.util.ar.e(4.0f);
    private static final int U = com.qzone.util.ar.e(32.0f);
    private static final int V = com.qzone.util.ar.e(60.0f);

    /* renamed from: G, reason: from kotlin metadata */
    private QUIShimmerFrameLayout shimmerRootView;

    /* renamed from: H, reason: from kotlin metadata */
    private View bigTailBackgroundRootView;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView iconImageView;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView contentTextView;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView userCountTextView;

    /* renamed from: M, reason: from kotlin metadata */
    private View bottomView;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isSelectedVideoControlViewVisible;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isChangeOrientation;

    /* renamed from: Q, reason: from kotlin metadata */
    private long lastChangeOrientationTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/layer/part/u$a;", "", "", "a", "", "CHANGE_ORIENTATION_MIN_DIFF_TIME", "J", "", "CONTAINER_DEFAULT_GUEST_PADDING_VERTICAL", "I", "CONTAINER_DEFAULT_PADDING_HORIZONTAL", "CONTAINER_DEFAULT_PADDING_VERTICAL", "CONTAINER_DEFAULT_PADDING_VIDEO_CONTROLLER_VERTICAL", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.layer.part.u$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a() {
            return true;
        }

        Companion() {
        }
    }

    private final void O9(final CellColorfulTail tail) {
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.shimmerRootView;
        if (qUIShimmerFrameLayout != null) {
            qUIShimmerFrameLayout.setVisibility(0);
        }
        S9(tail);
        if (this.isChangeOrientation) {
            this.isChangeOrientation = false;
            this.lastChangeOrientationTime = System.currentTimeMillis();
        }
        this.isSelectedVideoControlViewVisible = L9();
        V9();
        if (com.qzone.reborn.util.k.f59549a.f()) {
            String str = tail.darkStyle.token;
            Intrinsics.checkNotNullExpressionValue(str, "tail.darkStyle.token");
            T9(str);
        } else {
            String str2 = tail.brightStyle.token;
            Intrinsics.checkNotNullExpressionValue(str2, "tail.brightStyle.token");
            T9(str2);
        }
        TextView textView = this.titleTextView;
        if (textView != null) {
            textView.setText(tail.name);
        }
        TextView textView2 = this.contentTextView;
        if (textView2 != null) {
            textView2.setText(tail.desc);
        }
        if (TextUtils.isEmpty(tail.usedCount)) {
            TextView textView3 = this.userCountTextView;
            if (textView3 != null) {
                textView3.setText(com.qzone.util.l.a(R.string.nhi));
            }
        } else {
            TextView textView4 = this.userCountTextView;
            if (textView4 != null) {
                textView4.setText(tail.usedCount);
            }
        }
        View view = this.bigTailBackgroundRootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    u.P9(CellColorfulTail.this, view2);
                }
            });
        }
        QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.shimmerRootView;
        if (qUIShimmerFrameLayout2 != null) {
            qUIShimmerFrameLayout2.stopShimming(null);
        }
        QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this.shimmerRootView;
        if (qUIShimmerFrameLayout3 != null) {
            qUIShimmerFrameLayout3.updateRepeatCount(0);
        }
        QUIShimmerFrameLayout qUIShimmerFrameLayout4 = this.shimmerRootView;
        if (qUIShimmerFrameLayout4 != null) {
            qUIShimmerFrameLayout4.updateXfermode(PorterDuff.Mode.SRC_ATOP);
        }
        QUIShimmerFrameLayout qUIShimmerFrameLayout5 = this.shimmerRootView;
        if (qUIShimmerFrameLayout5 != null) {
            qUIShimmerFrameLayout5.startShimming(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(CellColorfulTail tail, View view) {
        Intrinsics.checkNotNullParameter(tail, "$tail");
        eo.c.f396879a.c();
        yo.d.c(tail.actionUrl, view.getContext());
    }

    @JvmStatic
    public static final boolean Q9() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(u this$0, CellColorfulTail cellColorfulTail) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.U9(cellColorfulTail)) {
            Intrinsics.checkNotNull(cellColorfulTail);
            this$0.O9(cellColorfulTail);
        } else {
            QUIShimmerFrameLayout qUIShimmerFrameLayout = this$0.shimmerRootView;
            if (qUIShimmerFrameLayout == null) {
                return;
            }
            qUIShimmerFrameLayout.setVisibility(8);
        }
    }

    private final void S9(CellColorfulTail tail) {
        String str;
        fo.b l3 = new fo.b().l(tail.reportParam);
        Map<String, Object> f16 = l3.f();
        Intrinsics.checkNotNullExpressionValue(f16, "map.paramMap");
        f16.put("macrotail_type", Integer.valueOf(tail.type));
        Map<String, Object> f17 = l3.f();
        Intrinsics.checkNotNullExpressionValue(f17, "map.paramMap");
        String str2 = tail.name;
        if (TextUtils.isEmpty(tail.desc)) {
            str = "";
        } else {
            str = "|" + tail.desc;
        }
        f17.put("literal_text", str2 + str);
        l3.h(new c.a());
        fo.c.o(this.bigTailBackgroundRootView, "em_qz_big_tail", l3);
    }

    private final void T9(String url) {
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(url).setTargetView(this.iconImageView));
    }

    private final void V9() {
        int i3;
        View view = this.bigTailBackgroundRootView;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (this.isSelectedVideoControlViewVisible) {
            if (F9() && com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qzone_pic_float_v1", null, 2, null)) {
                i3 = U;
            } else {
                i3 = V;
            }
        } else {
            i3 = T;
        }
        RFWLog.d(getTAG(), RFWLog.USR, "updateBigTailPadding isVisible:" + this.isSelectedVideoControlViewVisible + " distanceY: " + i3);
        if (layoutParams2 != null) {
            int i16 = S;
            layoutParams2.setMargins(i16, T, i16, i3);
        }
        View view2 = this.bigTailBackgroundRootView;
        if (view2 == null) {
            return;
        }
        view2.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxLayerBigTailPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        String tag = getTAG();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        objArr[0] = "onConfigurationChanged " + (configuration != null ? Integer.valueOf(configuration.orientation) : null);
        RFWLog.d(tag, i3, objArr);
        this.isChangeOrientation = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.shimmerRootView = (QUIShimmerFrameLayout) rootView.findViewById(R.id.n0_);
        this.bottomView = rootView.findViewById(R.id.n0n);
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.shimmerRootView;
        if (qUIShimmerFrameLayout != null) {
            this.bigTailBackgroundRootView = qUIShimmerFrameLayout.findViewById(R.id.n09);
            this.iconImageView = (ImageView) qUIShimmerFrameLayout.findViewById(R.id.mym);
            this.titleTextView = (TextView) qUIShimmerFrameLayout.findViewById(R.id.myq);
            this.contentTextView = (TextView) qUIShimmerFrameLayout.findViewById(R.id.myl);
            this.userCountTextView = (TextView) qUIShimmerFrameLayout.findViewById(R.id.myr);
        }
        RFWLayerIOCUtil.registerControlVisibleChangeListener(rootView, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        PhotoInfo photoInfo = this.f57984d;
        final CellColorfulTail cellColorfulTail = photoInfo != null ? photoInfo.cellColorfulTail : null;
        RFWLog.d(getTAG(), RFWLog.USR, "onLayerStateUpdate mSelectedPosition:" + this.C + "\uff0cbigTail:" + cellColorfulTail);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.s
            @Override // java.lang.Runnable
            public final void run() {
                u.R9(u.this, cellColorfulTail);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener
    public void onVisibleChange(RFWLayerItemMediaInfo itemInfo, boolean isVisible) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        RFWLog.d(getTAG(), RFWLog.USR, "videoControl onVisibleChange:" + isVisible + ",isChangeOrientation:" + this.isChangeOrientation);
        String mediaId = itemInfo.getMediaId();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (Intrinsics.areEqual(mediaId, rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getMediaId() : null)) {
            if (this.lastChangeOrientationTime > 0 && System.currentTimeMillis() - this.lastChangeOrientationTime < 5400) {
                RFWLog.e(getTAG(), RFWLog.USR, "videoControl changeOrientation too fast");
                return;
            }
            this.isSelectedVideoControlViewVisible = isVisible;
            V9();
            pk.d dVar = (pk.d) RFWIocAbilityProvider.g().getIocInterface(pk.d.class, getPartRootView(), null);
            if (dVar != null) {
                dVar.P5(itemInfo, isVisible);
            }
        }
    }

    private final boolean U9(CellColorfulTail bigTail) {
        if (!TextUtils.isEmpty(bigTail != null ? bigTail.actionUrl : null)) {
            if ((bigTail != null ? bigTail.darkStyle : null) != null && bigTail.brightStyle != null) {
                return true;
            }
        }
        return false;
    }
}
