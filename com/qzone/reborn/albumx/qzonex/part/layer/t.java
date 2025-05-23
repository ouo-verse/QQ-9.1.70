package com.qzone.reborn.albumx.qzonex.part.layer;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.DateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/t;", "Lcom/qzone/reborn/albumx/common/layer/part/c;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "", "H9", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "layerPicInfo", "K9", "", "Lcom/qzone/reborn/widget/b;", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "action", "", "args", "handleBroadcastMessage", "i", "Landroid/view/View;", "headerView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "pageTitlePageIndicator", BdhLogUtil.LogTag.Tag_Conn, "timeTextView", "D", "albumNameTextView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "infoImage", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "titleContainer", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends com.qzone.reborn.albumx.common.layer.part.c<QZAlbumxLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView timeTextView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView albumNameTextView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView infoImage;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout titleContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView pageTitlePageIndicator;

    private final List<com.qzone.reborn.widget.b> G9(RFWLayerPicInfo layerPicInfo) {
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        long j3;
        ArrayList arrayList = new ArrayList();
        if (x9() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5 EEEE HH:mm", Locale.CHINESE);
            QZAlbumxLayerExtraInfoBean x95 = x9();
            Intrinsics.checkNotNull(x95);
            if (x95.getShootTime() != 0) {
                QZAlbumxLayerExtraInfoBean x96 = x9();
                Intrinsics.checkNotNull(x96);
                j3 = x96.getShootTime();
            } else {
                QZAlbumxLayerExtraInfoBean x97 = x9();
                Intrinsics.checkNotNull(x97);
                j3 = x97.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String();
            }
            String time = simpleDateFormat.format(new Date(j3 * 1000));
            Intrinsics.checkNotNullExpressionValue(time, "time");
            arrayList.add(new com.qzone.reborn.widget.b(R.drawable.qui_calendar, time, null));
        }
        if (layerPicInfo.getDownloadPicInfo() != null) {
            currentPicInfo = layerPicInfo.getDownloadPicInfo();
        } else {
            currentPicInfo = layerPicInfo.getCurrentPicInfo();
        }
        if (currentPicInfo != null && currentPicInfo.getWidth() > 0 && currentPicInfo.getHeight() > 0) {
            arrayList.add(new com.qzone.reborn.widget.b(R.drawable.qui_image, currentPicInfo.getWidth() + " X " + currentPicInfo.getHeight(), null));
        }
        return arrayList;
    }

    private final void H9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        TextView textView = null;
        String valueOf = String.valueOf(x95 != null ? x95.getAlbumName() : null);
        TextView textView2 = this.albumNameTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumNameTextView");
        } else {
            textView = textView2;
        }
        textView.setText(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(t this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            this$0.getActivity().onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(RFWLayerState layerState, t this$0, View view) {
        RFWLayerPicInfo layerPicInfo;
        Intrinsics.checkNotNullParameter(layerState, "$layerState");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLayerItemMediaInfo selectedItemMedia = layerState.getSelectedItemMedia();
        if (selectedItemMedia == null || (layerPicInfo = selectedItemMedia.getLayerPicInfo()) == null) {
            return;
        }
        this$0.K9(layerPicInfo);
    }

    private final void K9(RFWLayerPicInfo layerPicInfo) {
        com.qzone.reborn.widget.a aVar = new com.qzone.reborn.widget.a();
        aVar.d(1002);
        aVar.c(false);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.qzone.reborn.widget.f fVar = new com.qzone.reborn.widget.f(activity, aVar);
        fVar.Y(G9(layerPicInfo));
        ef.d.f(fVar, getActivity());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        LinearLayout linearLayout = null;
        if (TextUtils.equals(action, "LAYER_TITLE_CONTAINER_SHOW")) {
            LinearLayout linearLayout2 = this.titleContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(0);
            return;
        }
        if (TextUtils.equals(action, "LAYER_TITLE_CONTAINER_HIDE")) {
            LinearLayout linearLayout3 = this.titleContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.c, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View view = null;
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.f128924o, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView?.context)\n\u2026yer_header_operate, null)");
        this.headerView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.n0p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "headerView.findViewById(\u2026dx_layer_title_container)");
        this.titleContainer = (LinearLayout) findViewById;
        View view2 = this.headerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.moj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "headerView.findViewById(\u2026albumx_layer_header_time)");
        this.timeTextView = (TextView) findViewById2;
        View view3 = this.headerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.nm5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "headerView.findViewById(\u2026er_title_pages_indicator)");
        this.pageTitlePageIndicator = (TextView) findViewById3;
        View view4 = this.headerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.mnu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "headerView.findViewById(\u2026um_layer_header_pic_info)");
        this.infoImage = (ImageView) findViewById4;
        View view5 = this.headerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.f162974nm4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "headerView.findViewById(R.id.viewer_title)");
        this.albumNameTextView = (TextView) findViewById5;
        TextView textView = this.pageTitlePageIndicator;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageTitlePageIndicator");
            textView = null;
        }
        textView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.f352270a.a(50.0f));
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        View view6 = this.headerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view6 = null;
        }
        ImageView imageView = (ImageView) view6.findViewById(R.id.n0j);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                t.I9(t.this, view7);
            }
        });
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view7 = this.headerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
        } else {
            view = view7;
        }
        viewGroup.addView(view, layoutParams);
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(final RFWLayerState layerState) {
        long j3;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        View view = null;
        if (x9() == null) {
            TextView textView = this.pageTitlePageIndicator;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitlePageIndicator");
            } else {
                view = textView;
            }
            view.setVisibility(0);
            return;
        }
        View view2 = this.headerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view2 = null;
        }
        view2.setVisibility(0);
        if (C9(layerState) == 1) {
            TextView textView2 = this.pageTitlePageIndicator;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitlePageIndicator");
                textView2 = null;
            }
            textView2.setVisibility(8);
        } else {
            String str = "(" + B9(layerState) + "/" + C9(layerState) + ")";
            TextView textView3 = this.pageTitlePageIndicator;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitlePageIndicator");
                textView3 = null;
            }
            textView3.setText(str);
            TextView textView4 = this.pageTitlePageIndicator;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitlePageIndicator");
                textView4 = null;
            }
            textView4.setVisibility(0);
        }
        QZAlbumxLayerExtraInfoBean x95 = x9();
        Intrinsics.checkNotNull(x95);
        if (x95.getShootTime() != 0) {
            QZAlbumxLayerExtraInfoBean x96 = x9();
            Intrinsics.checkNotNull(x96);
            j3 = x96.getShootTime();
        } else {
            QZAlbumxLayerExtraInfoBean x97 = x9();
            Intrinsics.checkNotNull(x97);
            j3 = x97.getCom.qzone.album.data.model.PhotoCategorySinglePicInfo.UPLOAD_TIME java.lang.String();
        }
        if (j3 != 0) {
            TextView textView5 = this.timeTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeTextView");
                textView5 = null;
            }
            textView5.setText(DateUtils.getChineseDayToSecond(j3));
            TextView textView6 = this.timeTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeTextView");
                textView6 = null;
            }
            textView6.setVisibility(0);
        } else {
            TextView textView7 = this.timeTextView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeTextView");
                textView7 = null;
            }
            textView7.setVisibility(8);
        }
        H9();
        ImageView imageView = this.infoImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoImage");
        } else {
            view = imageView;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                t.J9(RFWLayerState.this, this, view3);
            }
        });
    }
}
