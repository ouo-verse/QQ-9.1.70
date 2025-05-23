package com.tencent.qqnt.qbasealbum.customization.picker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.SendByFile;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.OnlineRepositoryHolder;
import com.tencent.qqnt.qbasealbum.preview.fragment.PreviewMode;
import com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewChildFragment;
import com.tencent.qqnt.qbasealbum.view.DownLoadingView;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u00103\u001a\u000202\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\rH\u0016J\"\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0016J\u001a\u0010(\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0016J(\u0010,\u001a\u00020+2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%H\u0016J \u0010.\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010-\u001a\u00020+2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "Landroid/content/Intent;", "intent", "", "initData", "Landroid/content/Context;", "context", "onNewIntent", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "isSelected", "isGesture", "checkMediaSelect", "onMediaSelectEvent", "Landroid/view/View;", "view", "", "layoutPosition", "onItemClickEvent", "isQualityRaw", "checkQualityRawChange", "onQualityRawChangeEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "v", "", "business", "onMagicStickClick", "onPreviewBtnClick", "onSendBtnClick", "onPickerExit", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getTitleView", "getBottomView", "spanCount", "holderGap", "Lcom/tencent/qqnt/qbasealbum/base/view/e;", "createPickerHolder", "holder", "bindPickerHolder", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "sendByFile", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class PickerCustomizationBase<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends AbstractPickerLogic<O> {
    static IPatchRedirector $redirector_;

    @NotNull
    private SendByFile sendByFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerCustomizationBase(@NotNull FragmentActivity activity, @NotNull com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) photoCommonData);
        } else {
            this.sendByFile = new SendByFile(0L, 0L, 0L, 0, 0, false, 63, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBottomView$lambda$10(PickerCustomizationBase this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QBaseAlbum.Customization")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.onPreviewBtnClick(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBottomView$lambda$11(PickerCustomizationBase this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QBaseAlbum.Customization")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.onSendBtnClick(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBottomView$lambda$12(PickerCustomizationBase this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QBaseAlbum.Customization")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.onMagicStickClick(it, QAlbumPickerContext.f361201a.d());
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.a
    public void bindPickerHolder(@NotNull Context context, @NotNull com.tencent.qqnt.qbasealbum.base.view.e holder, @NotNull LocalMediaInfo mediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, context, holder, mediaInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public boolean checkMediaSelect(@NotNull LocalMediaInfo mediaInfo, boolean isSelected, boolean isGesture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, mediaInfo, Boolean.valueOf(isSelected), Boolean.valueOf(isGesture))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return true;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public boolean checkQualityRawChange(boolean isQualityRaw) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, isQualityRaw)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.a
    @NotNull
    public com.tencent.qqnt.qbasealbum.base.view.e createPickerHolder(@NotNull Context context, int spanCount, int holderGap, @NotNull ViewGroup parent) {
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.qqnt.qbasealbum.base.view.e) iPatchRedirector.redirect((short) 16, this, context, Integer.valueOf(spanCount), Integer.valueOf(holderGap), parent);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setId(R.id.f24980_l);
        int measuredWidth = (parent.getMeasuredWidth() - ((spanCount - 1) * holderGap)) / spanCount;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(measuredWidth, measuredWidth);
        marginLayoutParams.topMargin = holderGap;
        constraintLayout.setLayoutParams(marginLayoutParams);
        com.tencent.qqnt.qbasealbum.base.view.e eVar = new com.tencent.qqnt.qbasealbum.base.view.e(constraintLayout);
        eVar.z(new ImageView(context));
        ImageView q16 = eVar.q();
        Intrinsics.checkNotNull(q16);
        q16.setId(R.id.f24990_m);
        ImageView q17 = eVar.q();
        Intrinsics.checkNotNull(q17);
        q17.setScaleType(ImageView.ScaleType.CENTER_CROP);
        constraintLayout.addView(eVar.q(), new ConstraintLayout.LayoutParams(-1, -1));
        eVar.D(new View(context));
        View u16 = eVar.u();
        Intrinsics.checkNotNull(u16);
        u16.setBackground(new ColorDrawable(Color.parseColor("#80000000")));
        View u17 = eVar.u();
        Intrinsics.checkNotNull(u17);
        u17.setVisibility(4);
        constraintLayout.addView(eVar.u(), new ConstraintLayout.LayoutParams(-1, -1));
        eVar.E(new TextView(context));
        TextView v3 = eVar.v();
        Intrinsics.checkNotNull(v3);
        v3.setBackground(ContextCompat.getDrawable(context, R.drawable.k8x));
        TextView v16 = eVar.v();
        Intrinsics.checkNotNull(v16);
        v16.setTextSize(12.0f);
        TextView v17 = eVar.v();
        Intrinsics.checkNotNull(v17);
        v17.setTextColor(-1);
        TextView v18 = eVar.v();
        Intrinsics.checkNotNull(v18);
        v18.setGravity(17);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.qui_play_filled_icon_white);
        if (drawable != null) {
            drawable.setBounds(0, 0, com.tencent.qqnt.qbasealbum.ktx.d.b(12), com.tencent.qqnt.qbasealbum.ktx.d.b(12));
        }
        TextView v19 = eVar.v();
        Intrinsics.checkNotNull(v19);
        v19.setCompoundDrawables(drawable, null, null, null);
        TextView v26 = eVar.v();
        Intrinsics.checkNotNull(v26);
        v26.setCompoundDrawablePadding(com.tencent.qqnt.qbasealbum.ktx.d.b(2));
        TextView v27 = eVar.v();
        Intrinsics.checkNotNull(v27);
        v27.setPadding(com.tencent.qqnt.qbasealbum.ktx.d.b(6), com.tencent.qqnt.qbasealbum.ktx.d.b(0), com.tencent.qqnt.qbasealbum.ktx.d.b(6), com.tencent.qqnt.qbasealbum.ktx.d.b(0));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, com.tencent.qqnt.qbasealbum.ktx.d.b(17));
        layoutParams.bottomToBottom = R.id.f24980_l;
        layoutParams.endToEnd = R.id.f24980_l;
        layoutParams.setMarginEnd(com.tencent.qqnt.qbasealbum.ktx.d.b(6));
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.qqnt.qbasealbum.ktx.d.b(6);
        layoutParams.goneBottomMargin = com.tencent.qqnt.qbasealbum.ktx.d.b(6);
        TextView v28 = eVar.v();
        if (v28 != null) {
            g.f361234b.f(context, v28);
        }
        constraintLayout.addView(eVar.v(), layoutParams);
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        if (b16 == null || (photoCommonData = b16.getPhotoCommonData()) == null || !photoCommonData.l()) {
            z16 = false;
        }
        if (!z16) {
            eVar.C(new FrameLayout(context));
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(com.tencent.qqnt.qbasealbum.ktx.d.a(36.0f), com.tencent.qqnt.qbasealbum.ktx.d.a(36.0f));
            layoutParams2.topToTop = R.id.f24980_l;
            layoutParams2.endToEnd = R.id.f24980_l;
            constraintLayout.addView(eVar.t(), layoutParams2);
            eVar.B(new QUICheckBox(context, 0, 4));
            QUICheckBox s16 = eVar.s();
            Intrinsics.checkNotNull(s16);
            s16.setGravity(17);
            QUICheckBox s17 = eVar.s();
            Intrinsics.checkNotNull(s17);
            s17.setBackground(ContextCompat.getDrawable(context, R.drawable.qui_common_check_box_with_text_white_border));
            QUICheckBox s18 = eVar.s();
            Intrinsics.checkNotNull(s18);
            s18.setButtonDrawable((Drawable) null);
            QUICheckBox s19 = eVar.s();
            Intrinsics.checkNotNull(s19);
            s19.setTextAlignment(4);
            QUICheckBox s26 = eVar.s();
            Intrinsics.checkNotNull(s26);
            s26.setTextSize(14.0f);
            QUICheckBox s27 = eVar.s();
            Intrinsics.checkNotNull(s27);
            s27.setTextColor(context.getColor(R.color.qui_common_on_brand_primary));
            QUICheckBox s28 = eVar.s();
            Intrinsics.checkNotNull(s28);
            s28.setClickable(false);
            QUICheckBox s29 = eVar.s();
            Intrinsics.checkNotNull(s29);
            s29.setFocusable(false);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.tencent.qqnt.qbasealbum.ktx.d.b(24), com.tencent.qqnt.qbasealbum.ktx.d.b(24));
            layoutParams3.gravity = 17;
            FrameLayout t16 = eVar.t();
            Intrinsics.checkNotNull(t16);
            QUICheckBox s36 = eVar.s();
            Intrinsics.checkNotNull(s36);
            t16.addView(s36, layoutParams3);
            FrameLayout t17 = eVar.t();
            if (t17 != null) {
                g.f361234b.f(context, t17);
            }
        }
        eVar.y(new TextView(context));
        TextView p16 = eVar.p();
        Intrinsics.checkNotNull(p16);
        p16.setTextSize(12.0f);
        TextView p17 = eVar.p();
        Intrinsics.checkNotNull(p17);
        p17.setTextColor(-1);
        TextView p18 = eVar.p();
        Intrinsics.checkNotNull(p18);
        p18.setGravity(17);
        TextView p19 = eVar.p();
        Intrinsics.checkNotNull(p19);
        p19.setText(context.getString(R.string.f1772033b));
        TextView p26 = eVar.p();
        Intrinsics.checkNotNull(p26);
        p26.setBackground(ContextCompat.getDrawable(context, R.drawable.k8x));
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(com.tencent.qqnt.qbasealbum.ktx.d.b(32), com.tencent.qqnt.qbasealbum.ktx.d.b(16));
        layoutParams4.bottomToBottom = R.id.f24980_l;
        layoutParams4.endToEnd = R.id.f24980_l;
        layoutParams4.setMarginEnd(com.tencent.qqnt.qbasealbum.ktx.d.b(6));
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = com.tencent.qqnt.qbasealbum.ktx.d.a(3.7f);
        constraintLayout.addView(eVar.p(), layoutParams4);
        eVar.w(new ImageView(context));
        ImageView m3 = eVar.m();
        Intrinsics.checkNotNull(m3);
        m3.setVisibility(8);
        ImageView m16 = eVar.m();
        Intrinsics.checkNotNull(m16);
        m16.setImageResource(R.drawable.qui_download_icon_white);
        ImageView m17 = eVar.m();
        Intrinsics.checkNotNull(m17);
        m17.setBackground(ContextCompat.getDrawable(context, R.drawable.k8s));
        ImageView m18 = eVar.m();
        Intrinsics.checkNotNull(m18);
        m18.setPadding(com.tencent.qqnt.qbasealbum.ktx.d.b(3), com.tencent.qqnt.qbasealbum.ktx.d.b(3), com.tencent.qqnt.qbasealbum.ktx.d.b(3), com.tencent.qqnt.qbasealbum.ktx.d.b(3));
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(com.tencent.qqnt.qbasealbum.ktx.d.b(17), com.tencent.qqnt.qbasealbum.ktx.d.b(17));
        layoutParams5.startToStart = R.id.f24980_l;
        layoutParams5.bottomToBottom = R.id.f24980_l;
        layoutParams5.setMarginStart(com.tencent.qqnt.qbasealbum.ktx.d.b(6));
        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = com.tencent.qqnt.qbasealbum.ktx.d.b(6);
        constraintLayout.addView(eVar.m(), layoutParams5);
        eVar.x(new ImageView(context));
        ImageView o16 = eVar.o();
        Intrinsics.checkNotNull(o16);
        o16.setVisibility(8);
        ImageView o17 = eVar.o();
        Intrinsics.checkNotNull(o17);
        o17.setImageResource(R.drawable.qui_edit_icon_white);
        ImageView o18 = eVar.o();
        Intrinsics.checkNotNull(o18);
        o18.setBackground(ContextCompat.getDrawable(context, R.drawable.k8s));
        ImageView o19 = eVar.o();
        Intrinsics.checkNotNull(o19);
        o19.setPadding(com.tencent.qqnt.qbasealbum.ktx.d.b(3), com.tencent.qqnt.qbasealbum.ktx.d.b(3), com.tencent.qqnt.qbasealbum.ktx.d.b(3), com.tencent.qqnt.qbasealbum.ktx.d.b(3));
        ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(com.tencent.qqnt.qbasealbum.ktx.d.b(17), com.tencent.qqnt.qbasealbum.ktx.d.b(17));
        layoutParams6.startToStart = R.id.f24980_l;
        layoutParams6.bottomToBottom = R.id.f24980_l;
        layoutParams6.setMarginStart(com.tencent.qqnt.qbasealbum.ktx.d.b(6));
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = com.tencent.qqnt.qbasealbum.ktx.d.b(6);
        constraintLayout.addView(eVar.o(), layoutParams6);
        eVar.A(new DownLoadingView(context));
        DownLoadingView r16 = eVar.r();
        Intrinsics.checkNotNull(r16);
        r16.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(com.tencent.qqnt.qbasealbum.ktx.d.b(16), com.tencent.qqnt.qbasealbum.ktx.d.b(16));
        layoutParams7.setMarginStart(com.tencent.qqnt.qbasealbum.ktx.d.b(6));
        ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin = com.tencent.qqnt.qbasealbum.ktx.d.b(6);
        layoutParams7.startToStart = R.id.f24980_l;
        layoutParams7.bottomToBottom = R.id.f24990_m;
        constraintLayout.addView(eVar.r(), layoutParams7);
        return eVar;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.a
    @Nullable
    public View getBottomView(@NotNull Context context, @NotNull ViewGroup parent) {
        boolean z16;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        if (b16 != null && (photoCommonData = b16.getPhotoCommonData()) != null && !photoCommonData.l()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        View bottomRoot = LayoutInflater.from(context).inflate(R.layout.f168438ft2, parent, false);
        setPreviewBtn((TextView) bottomRoot.findViewById(R.id.f25120_z));
        TextView previewBtn = getPreviewBtn();
        if (previewBtn != null) {
            previewBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.customization.picker.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickerCustomizationBase.getBottomView$lambda$10(PickerCustomizationBase.this, view);
                }
            });
        }
        setSendBtn((Button) bottomRoot.findViewById(R.id.f25160a3));
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.customization.picker.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickerCustomizationBase.getBottomView$lambda$11(PickerCustomizationBase.this, view);
                }
            });
        }
        setMagicBtn((TextView) bottomRoot.findViewById(R.id.f25080_v));
        TextView magicBtn = getMagicBtn();
        if (magicBtn != null) {
            magicBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.qbasealbum.customization.picker.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickerCustomizationBase.getBottomView$lambda$12(PickerCustomizationBase.this, view);
                }
            });
        }
        setQualityCb((CheckBox) bottomRoot.findViewById(R.id.f25130a0));
        setMediaSizeTv((TextView) bottomRoot.findViewById(R.id.f25140a1));
        setQualityTv((TextView) bottomRoot.findViewById(R.id.f25150a2));
        g gVar = g.f361234b;
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
        Intrinsics.checkNotNullExpressionValue(bottomRoot, "bottomRoot");
        gVar.f(context2, bottomRoot);
        return bottomRoot;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.a
    @Nullable
    public View getTitleView(@NotNull Context context, @NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View titleRoot = LayoutInflater.from(context).inflate(R.layout.ft6, parent, false);
        setTitleCloseBtn((FrameLayout) titleRoot.findViewById(R.id.f25240aa));
        setTitleAlbumName((TextView) titleRoot.findViewById(R.id.f25230a_));
        setTitleAlbumIcon((ImageView) titleRoot.findViewById(R.id.f25210a8));
        setTitleAlbumContainer(titleRoot.findViewById(R.id.f25170a4));
        g gVar = g.f361234b;
        Context context2 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
        Intrinsics.checkNotNullExpressionValue(titleRoot, "titleRoot");
        gVar.f(context2, titleRoot);
        return titleRoot;
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void initData(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onItemClickEvent(@NotNull View view, @NotNull LocalMediaInfo mediaInfo, final int layoutPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, mediaInfo, Integer.valueOf(layoutPosition));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.getPath() == null) {
            ox3.a.c("QBaseAlbum.Customization", new Function0<String>(layoutPosition) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onItemClickEvent$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $layoutPosition;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$layoutPosition = layoutPosition;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, layoutPosition);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "[picker] onItemClickEvent layoutPosition:" + this.$layoutPosition + " path is null";
                }
            });
            return;
        }
        ox3.a.c("QBaseAlbum.Customization", new Function0<String>(layoutPosition) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onItemClickEvent$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $layoutPosition;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$layoutPosition = layoutPosition;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, layoutPosition);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "[picker] onItemClickEvent layoutPosition:" + this.$layoutPosition;
            }
        });
        com.tencent.qqnt.qbasealbum.base.model.a a16 = QAlbumPickerContext.f361201a.g().a();
        CustomizationFacade customizationFacade = CustomizationFacade.f361084a;
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = customizationFacade.b();
        Intrinsics.checkNotNull(b16);
        b16.pickerData.d(layoutPosition);
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b17 = customizationFacade.b();
        Intrinsics.checkNotNull(b17);
        a16.b(view, b17.pickerData.a(), layoutPosition);
        com.tencent.qqnt.qbasealbum.share.a h16 = com.tencent.qqnt.qbasealbum.album.b.h(getActivity());
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        h16.S1(rect);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onMagicStickClick(@NotNull View v3, @Nullable final String business) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) v3, (Object) business);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        ox3.a.c("QBaseAlbum.Customization", new Function0<String>(business) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onMagicStickClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $business;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$business = business;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) business);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "[picker] onMagicStickClick busi:" + this.$business;
            }
        });
        g.f361234b.l(getActivity(), getPhotoCommonData().h().get(0), getPhotoCommonData().j(), business);
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c(WinkDaTongReportConstant.ElementId.EM_BAS_EDIT, 2, PickerCustomizationBase$onMagicStickClick$2.INSTANCE);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onMediaSelectEvent(@NotNull final LocalMediaInfo mediaInfo, final boolean isSelected) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, mediaInfo, Boolean.valueOf(isSelected));
            return;
        }
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.getPath() == null) {
            ox3.a.c("QBaseAlbum.Customization", PickerCustomizationBase$onMediaSelectEvent$1.INSTANCE);
            return;
        }
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(isSelected) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onMediaSelectEvent$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $isSelected;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$isSelected = isSelected;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, LocalMediaInfo.this, Boolean.valueOf(isSelected));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onMediaSelectEvent, mediaInfo:" + LocalMediaInfo.this.getPath() + ", isSelect:" + this.$isSelected;
            }
        });
        if (isSelected) {
            this.sendByFile.f(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), mediaInfo, true, QAlbumPickerContext.f361201a.f());
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onNewIntent(@Nullable Intent intent, @NotNull Context context) {
        boolean z16;
        int collectionSizeOrDefault;
        Set<Map.Entry<String, LocalMediaInfo>> entrySet;
        String it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = 0;
        if (intent != null && intent.getBooleanExtra("goEdit", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || intent.getIntExtra("editFromPage", 1) != 1) {
            return;
        }
        ox3.a.a("QBaseAlbum.MediaEdit", PickerCustomizationBase$onNewIntent$1.INSTANCE);
        HashMap<String, LocalMediaInfo> m3 = g.f361234b.m(intent);
        ArrayList arrayList = new ArrayList();
        if (m3 != null && (entrySet = m3.entrySet()) != null) {
            for (Object obj : entrySet) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                final Map.Entry entry = (Map.Entry) obj;
                ox3.a.a("QBaseAlbum.MediaEdit", new Function0<String>(entry) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onNewIntent$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Map.Entry<String, LocalMediaInfo> $entry;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$entry = entry;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) entry);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        String key = this.$entry.getKey();
                        return "originPath:" + ((Object) key) + " Path=" + this.$entry.getValue().getPath() + " FileSize=" + this.$entry.getValue().getFileSize() + " ThumbWidth=" + this.$entry.getValue().getThumbWidth() + " ThumbHeight=" + this.$entry.getValue().getThumbHeight() + " OriginPath=" + this.$entry.getValue().getMOriginPath();
                    }
                });
                ArrayList<String> mOriginPath = ((LocalMediaInfo) entry.getValue()).getMOriginPath();
                if (mOriginPath != null && (it = mOriginPath.get(i3)) != null) {
                    LocalMediaDataHub a16 = LocalMediaDataHub.INSTANCE.a();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Object value = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "entry.value");
                    LocalMediaInfo D = a16.D(it, (LocalMediaInfo) value);
                    if (D != null) {
                        arrayList.add(D);
                    }
                }
                i3 = i16;
            }
        }
        if (!arrayList.isEmpty()) {
            RFWLayerLaunchUtil rFWLayerLaunchUtil = RFWLayerLaunchUtil.INSTANCE;
            QAlbumBaseMainFragment<?> l3 = QAlbumPickerContext.f361201a.l();
            Intrinsics.checkNotNull(l3);
            FragmentManager childFragmentManager = l3.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "QAlbumPickerContext.getS\u2026()!!.childFragmentManager");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(com.tencent.qqnt.qbasealbum.ktx.b.u((LocalMediaInfo) it5.next()));
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("FROM_PICKER_EDIT", true);
            Unit unit = Unit.INSTANCE;
            com.tencent.qqnt.qbasealbum.base.model.e.b(rFWLayerLaunchUtil, context, childFragmentManager, null, arrayList2, 0, QAlbumPreviewChildFragment.class, bundle, R.id.cks);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onPickerExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        OnlineRepositoryHolder.f361322a.a().onClear();
        getActivity().finish();
        getActivity().overridePendingTransition(0, R.anim.f154816sj);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onPreviewBtnClick(@NotNull View v3) {
        FragmentManager supportFragmentManager;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        ox3.a.c("QBaseAlbum.Customization", PickerCustomizationBase$onPreviewBtnClick$1.INSTANCE);
        RFWLayerLaunchUtil rFWLayerLaunchUtil = RFWLayerLaunchUtil.INSTANCE;
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        QAlbumPickerContext qAlbumPickerContext = QAlbumPickerContext.f361201a;
        if (qAlbumPickerContext.l() != null) {
            QAlbumBaseMainFragment<?> l3 = qAlbumPickerContext.l();
            Intrinsics.checkNotNull(l3);
            supportFragmentManager = l3.getChildFragmentManager();
        } else {
            Context context2 = v3.getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            supportFragmentManager = ((FragmentActivity) context2).getSupportFragmentManager();
        }
        FragmentManager fragmentManager = supportFragmentManager;
        Intrinsics.checkNotNullExpressionValue(fragmentManager, "if (QAlbumPickerContext.\u2026mentManager\n            }");
        List<LocalMediaInfo> h16 = getPhotoCommonData().h();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = h16.iterator();
        while (it.hasNext()) {
            arrayList.add(com.tencent.qqnt.qbasealbum.ktx.b.u((LocalMediaInfo) it.next()));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("PARAM_PREVIEW_MODE", PreviewMode.SELECT_MODE.ordinal());
        bundle.putBoolean("FROM_PICKER_PREVIEW_BTN", true);
        Unit unit = Unit.INSTANCE;
        com.tencent.qqnt.qbasealbum.base.model.e.b(rFWLayerLaunchUtil, context, fragmentManager, null, arrayList, 0, QAlbumPreviewChildFragment.class, bundle, R.id.cks);
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c(WinkDaTongReportConstant.ElementId.EM_BAS_PREVIEW, 2, PickerCustomizationBase$onPreviewBtnClick$4.INSTANCE);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onQualityRawChangeEvent(final boolean isQualityRaw) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isQualityRaw);
            return;
        }
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(isQualityRaw) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onQualityRawChangeEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $isQualityRaw;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$isQualityRaw = isQualityRaw;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, isQualityRaw);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onQualityRawChangeEvent, isQualityRaw:" + this.$isQualityRaw;
            }
        });
        if (isQualityRaw) {
            this.sendByFile.g(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), getPhotoCommonData().h(), QAlbumPickerContext.f361201a.f());
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onSendBtnClick(@NotNull View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Bundle bundle = new Bundle();
        AlbumResult albumResult = new AlbumResult();
        albumResult.o(new ArrayList(getPhotoCommonData().h()));
        albumResult.m(getPhotoCommonData().j());
        albumResult.j(getPhotoCommonData().b());
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable("ALBUM_RESULT", albumResult);
        ox3.a.a("QBaseAlbum.Customization", new Function0<String>(this) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onSendBtnClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ PickerCustomizationBase<O> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                int collectionSizeOrDefault;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                boolean i3 = QAlbumPickerContext.f361201a.i();
                boolean j3 = this.this$0.getPhotoCommonData().j();
                List<LocalMediaInfo> h16 = this.this$0.getPhotoCommonData().h();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = h16.iterator();
                while (it.hasNext()) {
                    arrayList.add(((LocalMediaInfo) it.next()).getPath());
                }
                return "[picker] onSendBtnClick finish needActivityResult: " + i3 + ", isQuality:" + j3 + ", " + arrayList;
            }
        });
        if (QAlbumPickerContext.f361201a.i()) {
            getActivity().setResult(-1, new Intent().putExtras(bundle));
        } else {
            g.f361234b.n(getActivity(), bundle);
        }
        getActivity().finish();
        getActivity().overridePendingTransition(0, R.anim.f154816sj);
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c("em_bas_send", 2, new Function0<Map<String, ? extends Object>>(this) { // from class: com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase$onSendBtnClick$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ PickerCustomizationBase<O> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends Object> invoke() {
                Map<String, ? extends Object> mapOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Map) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("aio_type", Integer.valueOf(QAlbumPickerContext.f361201a.f())), TuplesKt.to("number_sent", Integer.valueOf(this.this$0.getPhotoCommonData().h().size())), TuplesKt.to("is_original", Integer.valueOf(!this.this$0.getPhotoCommonData().j() ? 1 : 0)));
                return mapOf;
            }
        });
    }
}
