package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/layer/part/j;", "Lcom/qzone/reborn/layer/part/o;", "", "R9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "P9", "Q9", "", "S9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "onLayerStateUpdate", "H", "Z", "onlyShowIndicator", "I", "Landroid/view/View;", "headerView", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "nameTv", "K", "indicatorTv", "L", "dateTv", "<init>", "(Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends o {

    /* renamed from: H, reason: from kotlin metadata */
    private final boolean onlyShowIndicator;

    /* renamed from: I, reason: from kotlin metadata */
    private View headerView;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView nameTv;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView indicatorTv;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView dateTv;

    public j(boolean z16) {
        this.onlyShowIndicator = z16;
    }

    private final String P9(RFWLayerState layerState) {
        if (this.onlyShowIndicator) {
            return C9(layerState) + "/" + D9(layerState);
        }
        return "(" + C9(layerState) + "/" + D9(layerState) + ")";
    }

    private final String Q9() {
        int i3;
        if (this.f57984d != null && this.f57988i != null) {
            if (S9()) {
                i3 = this.f57984d.shootingTime;
            } else {
                i3 = this.f57984d.uploadtime;
            }
            String format = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5", Locale.getDefault()).format(new Date(i3 * 1000));
            Intrinsics.checkNotNullExpressionValue(format, "df.format(Date(actualDisplayTime.toLong() * 1000))");
            return format;
        }
        return "";
    }

    private final String R9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.albumName)) {
            String str = this.f57984d.albumName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            mCurrentSe\u2026Photo.albumName\n        }");
            return str;
        }
        return "";
    }

    private final boolean S9() {
        PhotoInfo photoInfo;
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null || (photoInfo = this.f57984d) == null || photoInfo.shootingTime <= 0) {
            return false;
        }
        int i3 = photoParam.sortType;
        return i3 == 5 || i3 == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.layer.part.o, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.clj, (ViewGroup) null);
        this.headerView = inflate;
        this.indicatorTv = inflate != null ? (TextView) inflate.findViewById(R.id.mnq) : null;
        View view = this.headerView;
        this.nameTv = view != null ? (TextView) view.findViewById(R.id.mnr) : null;
        View view2 = this.headerView;
        this.dateTv = view2 != null ? (TextView) view2.findViewById(R.id.mnp) : null;
        if (this.onlyShowIndicator) {
            View view3 = this.headerView;
            View findViewById = view3 != null ? view3.findViewById(R.id.mns) : null;
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            TextView textView = this.dateTv;
            if (textView != null) {
                textView.setVisibility(8);
            }
            View view4 = this.headerView;
            TextView textView2 = view4 != null ? (TextView) view4.findViewById(R.id.mnt) : null;
            this.indicatorTv = textView2;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.headerView, layoutParams);
        View view5 = this.headerView;
        ImageView imageView = view5 != null ? (ImageView) view5.findViewById(R.id.mnn) : null;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    j.T9(j.this, view6);
                }
            });
        }
        com.tencent.mobileqq.qzone.picload.c.a().m(imageView, -1);
        AccessibilityUtil.s(imageView, com.qzone.util.l.a(R.string.f2201668d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (this.f57984d == null) {
            View view = this.headerView;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        View view2 = this.headerView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView = this.nameTv;
        if (textView != null) {
            textView.setText(R9());
        }
        TextView textView2 = this.indicatorTv;
        if (textView2 != null) {
            textView2.setText(P9(layerState));
        }
        TextView textView3 = this.dateTv;
        if (textView3 == null) {
            return;
        }
        textView3.setText(Q9());
    }

    public /* synthetic */ j(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
