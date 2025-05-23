package com.tencent.mobileqq.wink.magicstudio.qzone.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.IFSQQBaseService;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010\"\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/qzone/part/WinkQZoneMagicStudioTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "J9", "initViewModel", "view", "P9", "O9", "S9", "", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "magicStudioViewModel", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "e", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "pic2picMetaCategory", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "winkMagicStudioLeftChanceTextView", tl.h.F, "winkMagicStudioTitleTextView", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "winkMagicStudioPromoLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "winkMagicStudioPromoTextView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "winkMagicStudioPromoImageView", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "D", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "blurView", "E", "titleContainer", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneMagicStudioTitlePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private RoundCornerImageView winkMagicStudioPromoImageView;

    /* renamed from: D, reason: from kotlin metadata */
    private QQBlurViewWrapper blurView;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup titleContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkQZoneMagicStudioViewModel magicStudioViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaCategory pic2picMetaCategory;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView winkMagicStudioLeftChanceTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView winkMagicStudioTitleTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup winkMagicStudioPromoLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView winkMagicStudioPromoTextView;

    private final void J9(View rootView) {
        int i3;
        String str;
        View findViewById = rootView.findViewById(R.id.f123277g8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026magic_studio_left_chance)");
        this.winkMagicStudioLeftChanceTextView = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f123397gj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.wink_magic_studio_title)");
        this.winkMagicStudioTitleTextView = (TextView) findViewById2;
        rootView.findViewById(R.id.f123337gd).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkQZoneMagicStudioTitlePart.K9(WinkQZoneMagicStudioTitlePart.this, view);
            }
        });
        final boolean f16 = m83.a.f416440a.f();
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f123287g9);
        Context context = getContext();
        if (f16) {
            i3 = R.drawable.qui_more;
        } else {
            i3 = R.drawable.qui_caution_circle;
        }
        imageView.setImageDrawable(context.getDrawable(i3));
        if (f16) {
            str = "\u66f4\u591a";
        } else {
            str = "\u7528\u6237\u89c4\u5219\u4e2d\u5fc3";
        }
        imageView.setContentDescription(str);
        final View findViewById3 = rootView.findViewById(R.id.f123287g9);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkQZoneMagicStudioTitlePart.L9(f16, this, findViewById3, view);
            }
        });
        int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight(getContext());
        View findViewById4 = rootView.findViewById(R.id.f123407gk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026agic_studio_title_layout)");
        this.titleContainer = (ViewGroup) findViewById4;
        int dpToPx = ViewUtils.dpToPx(44.0f) + statusBarHeight;
        ViewGroup viewGroup = this.titleContainer;
        QQBlurViewWrapper qQBlurViewWrapper = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            viewGroup = null;
        }
        viewGroup.getLayoutParams().height = dpToPx;
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f123297g_);
        View findViewById5 = rootView.findViewById(R.id.f99755qn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<QQ\u2026pper>(R.id.top_blur_view)");
        QQBlurViewWrapper qQBlurViewWrapper2 = (QQBlurViewWrapper) findViewById5;
        this.blurView = qQBlurViewWrapper2;
        if (qQBlurViewWrapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurViewWrapper2 = null;
        }
        qQBlurViewWrapper2.getLayoutParams().height = dpToPx;
        QQBlurViewWrapper qQBlurViewWrapper3 = this.blurView;
        if (qQBlurViewWrapper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
        } else {
            qQBlurViewWrapper = qQBlurViewWrapper3;
        }
        boolean b16 = com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.b();
        ColorDrawable colorDrawable = new ColorDrawable(getContext().getColor(R.color.qui_common_bg_bottom_light));
        colorDrawable.setAlpha(204);
        Unit unit = Unit.INSTANCE;
        f.a aVar = new f.a(b16, 80.0f, recyclerView, 0, colorDrawable, Integer.valueOf(R.drawable.qui_common_bg_bottom_light_bg));
        aVar.l(true);
        qQBlurViewWrapper.a(aVar);
        View findViewById6 = rootView.findViewById(R.id.f123317gb);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026agic_studio_promo_layout)");
        this.winkMagicStudioPromoLayout = (ViewGroup) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f123307ga);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026_magic_studio_promo_icon)");
        this.winkMagicStudioPromoImageView = (RoundCornerImageView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f123327gc);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026magic_studio_promo_title)");
        this.winkMagicStudioPromoTextView = (TextView) findViewById8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(WinkQZoneMagicStudioTitlePart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.report.e.m(eVar, it, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null, null, 12, null);
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(boolean z16, WinkQZoneMagicStudioTitlePart this$0, View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(view, "this");
            this$0.P9(view);
        } else {
            this$0.O9();
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O9() {
        String str;
        IFSQQBaseService iFSQQBaseService = (IFSQQBaseService) QRoute.api(IFSQQBaseService.class);
        Context context = getContext();
        MetaCategory metaCategory = this.pic2picMetaCategory;
        if (metaCategory == null || (str = com.tencent.mobileqq.wink.editor.b.f(metaCategory, "protocolUrl")) == null) {
            str = "https://rule.tencent.com/rule/202312070001";
        }
        Intent handleFSPublishHybirdActivityIntent = iFSQQBaseService.handleFSPublishHybirdActivityIntent(context, str, new Intent(), -1);
        handleFSPublishHybirdActivityIntent.putExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE, 3);
        Activity activity = getActivity();
        if (activity != null) {
            activity.startActivity(handleFSPublishHybirdActivityIntent);
        }
    }

    private final void P9(View view) {
        String str;
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u6743\u9650\u8bbe\u7f6e");
        actionSheet.addButton("\u7528\u6237\u89c4\u5219\u4e2d\u5fc3");
        com.tencent.mobileqq.wink.editor.hdr.e eVar = com.tencent.mobileqq.wink.editor.hdr.e.f320476a;
        if (eVar.b()) {
            actionSheet.addButton("\uff08debug\uff09\u91cd\u7f6e\u6b21\u6570");
            actionSheet.addButton("\uff08debug\uff09\u6d88\u8017\u6b21\u6570");
            actionSheet.addButton("\uff08debug\uff09\u5206\u4eab");
            if (eVar.d()) {
                str = "\u5173\u95ed";
            } else {
                str = "\u5f00\u542f";
            }
            actionSheet.addButton("\uff08debug\uff09" + str + "\u6d4b\u8bd5\u7d20\u6750");
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.e
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                WinkQZoneMagicStudioTitlePart.Q9(WinkQZoneMagicStudioTitlePart.this, actionSheet, view2, i3);
            }
        });
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkQZoneMagicStudioTitlePart.R9(ActionSheet.this, view2);
            }
        });
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.show();
        m83.b.f416442a.n(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(WinkQZoneMagicStudioTitlePart this$0, ActionSheet actionSheet, View view, int i3) {
        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel2;
        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                com.tencent.mobileqq.wink.editor.hdr.e eVar = com.tencent.mobileqq.wink.editor.hdr.e.f320476a;
                                if (eVar.b()) {
                                    eVar.a(!eVar.d());
                                    actionSheet.dismiss();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (com.tencent.mobileqq.wink.editor.hdr.e.f320476a.b() && (winkQZoneMagicStudioViewModel3 = this$0.magicStudioViewModel) != null) {
                            winkQZoneMagicStudioViewModel3.L1(2);
                            return;
                        }
                        return;
                    }
                    if (com.tencent.mobileqq.wink.editor.hdr.e.f320476a.b() && (winkQZoneMagicStudioViewModel2 = this$0.magicStudioViewModel) != null) {
                        winkQZoneMagicStudioViewModel2.L1(1);
                        return;
                    }
                    return;
                }
                if (com.tencent.mobileqq.wink.editor.hdr.e.f320476a.b() && (winkQZoneMagicStudioViewModel = this$0.magicStudioViewModel) != null) {
                    winkQZoneMagicStudioViewModel.T1();
                }
                actionSheet.dismiss();
                return;
            }
            m83.b.f416442a.m(view, "2");
            this$0.O9();
            actionSheet.dismiss();
            return;
        }
        m83.b.f416442a.m(view, "1");
        Activity activity = this$0.getActivity();
        if (activity instanceof FragmentActivity) {
            IAECameraLauncher iAECameraLauncher = (IAECameraLauncher) QRoute.api(IAECameraLauncher.class);
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            TextView textView = this$0.winkMagicStudioTitleTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioTitleTextView");
                textView = null;
            }
            iAECameraLauncher.winkLaunchAIGCSettingFragment(fragmentActivity, textView.getText().toString());
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        m83.b.f416442a.m(view, "0");
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00eb  */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S9() {
        final String str;
        String str2;
        String str3;
        boolean z16;
        ?? r06;
        boolean z17;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        MetaCategory metaCategory = this.pic2picMetaCategory;
        RoundCornerImageView roundCornerImageView = null;
        if (metaCategory != null) {
            str = com.tencent.mobileqq.wink.editor.b.f(metaCategory, "promoSchema");
        } else {
            str = null;
        }
        MetaCategory metaCategory2 = this.pic2picMetaCategory;
        if (metaCategory2 != null) {
            str2 = com.tencent.mobileqq.wink.editor.b.f(metaCategory2, "promoTitle");
        } else {
            str2 = null;
        }
        MetaCategory metaCategory3 = this.pic2picMetaCategory;
        if (metaCategory3 != null) {
            str3 = com.tencent.mobileqq.wink.editor.b.f(metaCategory3, "promoIcon");
        } else {
            str3 = null;
        }
        boolean z18 = true;
        if (str != null) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank3) {
                z16 = false;
                if (!z16) {
                    if (str2 != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                        if (!isBlank2) {
                            z17 = false;
                            if (!z17) {
                                m83.b bVar = m83.b.f416442a;
                                ViewGroup viewGroup = this.winkMagicStudioPromoLayout;
                                if (viewGroup == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoLayout");
                                    viewGroup = null;
                                }
                                bVar.p(viewGroup);
                                ViewGroup viewGroup2 = this.winkMagicStudioPromoLayout;
                                if (viewGroup2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoLayout");
                                    viewGroup2 = null;
                                }
                                viewGroup2.setVisibility(0);
                                TextView textView = this.winkMagicStudioPromoTextView;
                                if (textView == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoTextView");
                                    textView = null;
                                }
                                String substring = str2.substring(0, Math.min(str2.length(), 5));
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                textView.setText(substring);
                                ViewGroup viewGroup3 = this.winkMagicStudioPromoLayout;
                                if (viewGroup3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoLayout");
                                    viewGroup3 = null;
                                }
                                viewGroup3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.g
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        WinkQZoneMagicStudioTitlePart.T9(str, this, view);
                                    }
                                });
                                if (str3 != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                                    if (!isBlank) {
                                        z18 = false;
                                    }
                                }
                                if (z18) {
                                    RoundCornerImageView roundCornerImageView2 = this.winkMagicStudioPromoImageView;
                                    if (roundCornerImageView2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoImageView");
                                    } else {
                                        roundCornerImageView = roundCornerImageView2;
                                    }
                                    roundCornerImageView.setVisibility(8);
                                    return;
                                }
                                RoundCornerImageView roundCornerImageView3 = this.winkMagicStudioPromoImageView;
                                if (roundCornerImageView3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoImageView");
                                    roundCornerImageView3 = null;
                                }
                                roundCornerImageView3.setVisibility(0);
                                RoundCornerImageView roundCornerImageView4 = this.winkMagicStudioPromoImageView;
                                if (roundCornerImageView4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoImageView");
                                    roundCornerImageView4 = null;
                                }
                                roundCornerImageView4.setCorner(ViewUtils.dpToPx(8.0f));
                                RoundCornerImageView roundCornerImageView5 = this.winkMagicStudioPromoImageView;
                                if (roundCornerImageView5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoImageView");
                                } else {
                                    roundCornerImageView = roundCornerImageView5;
                                }
                                roundCornerImageView.setImageDrawable(URLDrawable.getDrawable(str3, ViewUtilsKt.d()));
                                return;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                r06 = this.winkMagicStudioPromoLayout;
                if (r06 != 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoLayout");
                } else {
                    roundCornerImageView = r06;
                }
                roundCornerImageView.setVisibility(8);
            }
        }
        z16 = true;
        if (!z16) {
        }
        r06 = this.winkMagicStudioPromoLayout;
        if (r06 != 0) {
        }
        roundCornerImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(String str, WinkQZoneMagicStudioTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = null;
        WinkMagicStudioLogicUtils.s(WinkMagicStudioLogicUtils.f323883a, str, null, 2, null);
        m83.b bVar = m83.b.f416442a;
        ViewGroup viewGroup2 = this$0.winkMagicStudioPromoLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioPromoLayout");
        } else {
            viewGroup = viewGroup2;
        }
        bVar.o(viewGroup);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initViewModel() {
        MutableLiveData<MetaCategory> P1;
        MutableLiveData<MagicStudioButtonInfo> N1;
        WinkQZoneMagicStudioViewModel a16 = WinkQZoneMagicStudioViewModel.INSTANCE.a(getActivity());
        this.magicStudioViewModel = a16;
        if (a16 != null && (N1 = a16.N1()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<MagicStudioButtonInfo, Unit> function1 = new Function1<MagicStudioButtonInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZoneMagicStudioTitlePart$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MagicStudioButtonInfo magicStudioButtonInfo) {
                    invoke2(magicStudioButtonInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable MagicStudioButtonInfo magicStudioButtonInfo) {
                    TextView textView;
                    w53.b.a("WinkQZoneMagicStudioTitlePart", "pic2picButtonInfoLiveData receive " + magicStudioButtonInfo + "  " + WinkQZoneMagicStudioTitlePart.this.getHostFragment());
                    textView = WinkQZoneMagicStudioTitlePart.this.winkMagicStudioLeftChanceTextView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioLeftChanceTextView");
                        textView = null;
                    }
                    textView.setText(magicStudioButtonInfo != null ? magicStudioButtonInfo.getSubtitleString() : null);
                    boolean z16 = false;
                    if (magicStudioButtonInfo != null && magicStudioButtonInfo.getIsFromMultiSelectPage()) {
                        z16 = true;
                    }
                    if (z16) {
                        return;
                    }
                    m83.b.f416442a.g(WinkDaTongReportConstant.PageId.PG_QZ_MAGIC_STUDIO_DETAIL, magicStudioButtonInfo != null ? Integer.valueOf(magicStudioButtonInfo.getActionType()) : null);
                }
            };
            N1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkQZoneMagicStudioTitlePart.M9(Function1.this, obj);
                }
            });
        }
        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel = this.magicStudioViewModel;
        if (winkQZoneMagicStudioViewModel != null && (P1 = winkQZoneMagicStudioViewModel.P1()) != null) {
            Fragment hostFragment2 = getHostFragment();
            final Function1<MetaCategory, Unit> function12 = new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZoneMagicStudioTitlePart$initViewModel$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MetaCategory metaCategory) {
                    invoke2(metaCategory);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MetaCategory metaCategory) {
                    TextView textView;
                    WinkQZoneMagicStudioTitlePart.this.pic2picMetaCategory = metaCategory;
                    textView = WinkQZoneMagicStudioTitlePart.this.winkMagicStudioTitleTextView;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkMagicStudioTitleTextView");
                        textView = null;
                    }
                    String str = metaCategory.name;
                    if (str == null) {
                        str = HardCodeUtil.qqStr(R.string.f240847q_);
                    }
                    textView.setText(str);
                    WinkQZoneMagicStudioTitlePart.this.S9();
                }
            };
            P1.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.part.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkQZoneMagicStudioTitlePart.N9(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkQZoneMagicStudioTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        J9(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QQBlurViewWrapper qQBlurViewWrapper = this.blurView;
        if (qQBlurViewWrapper != null) {
            if (qQBlurViewWrapper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                qQBlurViewWrapper = null;
            }
            qQBlurViewWrapper.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel = this.magicStudioViewModel;
        if (winkQZoneMagicStudioViewModel != null) {
            winkQZoneMagicStudioViewModel.S1(1);
        }
        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel2 = this.magicStudioViewModel;
        if (winkQZoneMagicStudioViewModel2 != null) {
            winkQZoneMagicStudioViewModel2.R1();
        }
    }
}
