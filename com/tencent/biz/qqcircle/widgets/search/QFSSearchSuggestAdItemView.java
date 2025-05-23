package com.tencent.biz.qqcircle.widgets.search;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchAdFeedbackEvent;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchSuggestAdItemView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import f80.d;
import g30.b;
import ie0.a;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001HB\u000f\u0012\u0006\u0010E\u001a\u00020D\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0014J\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0014R\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\n \u001e*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\n \u001e*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\n \u001e*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u001c\u0010-\u001a\n \u001e*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u001c\u0010/\u001a\n \u001e*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0014\u00102\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00101R\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/search/QFSSearchSuggestAdItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lg30/b;", "Landroid/view/View$OnClickListener;", "", "url", "", "m0", "p0", "", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$ButtonInfo;", "buttonInfoList", "o0", "Landroid/view/View;", "v", "s0", "", "q0", "", "getLayoutId", "suggestionInfo", c.G, "l0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "r0", "view", NodeProps.ON_CLICK, "getLogTag", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "d", "Landroidx/constraintlayout/widget/ConstraintLayout;", "suggestAdRootView", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "sugAdItemAvatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "sugAdItemName", h.F, "sugAdItemDescription", "i", "sugAdItemLogo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sugAdItemButton", BdhLogUtil.LogTag.Tag_Conn, "I", "sugAdItemLogoIconSize", "Lcom/tencent/gdtad/aditem/GdtAd;", "D", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lf80/d;", "E", "Lf80/d;", "searchItemViewAdExpose", UserInfo.SEX_FEMALE, "currentPos", "G", "Z", "hasAttachedToWindow", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "H", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "feedBackListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSSearchSuggestAdItemView extends QCircleBaseWidgetView<b> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final int sugAdItemLogoIconSize;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GdtAd gdtAd;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private d searchItemViewAdExpose;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentPos;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasAttachedToWindow;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final AdFeedbackDialogFragment.Listener feedBackListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout suggestAdRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final SquareImageView sugAdItemAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView sugAdItemName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView sugAdItemDescription;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView sugAdItemLogo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView sugAdItemButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSearchSuggestAdItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.suggestAdRootView = (ConstraintLayout) getRootView().findViewById(R.id.f54732g0);
        this.sugAdItemAvatar = (SquareImageView) getRootView().findViewById(R.id.f54382f2);
        this.sugAdItemName = (TextView) getRootView().findViewById(R.id.f54402f4);
        this.sugAdItemDescription = (TextView) getRootView().findViewById(R.id.f54372f1);
        this.sugAdItemLogo = (TextView) getRootView().findViewById(R.id.f54392f3);
        this.sugAdItemButton = (TextView) getRootView().findViewById(R.id.f54412f5);
        this.sugAdItemLogoIconSize = ImmersiveUtils.dpToPx(10.0f);
        this.currentPos = -1;
        this.feedBackListener = new AdFeedbackDialogFragment.Listener() { // from class: rc0.c
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                QFSSearchSuggestAdItemView.n0(QFSSearchSuggestAdItemView.this, result);
            }
        };
    }

    private final void m0(String url) {
        String uniKeyFromUrl = QCircleFeedPicLoader.getUniKeyFromUrl(url);
        Object tag = this.sugAdItemAvatar.getTag(R.id.f54382f2);
        if (!TextUtils.isEmpty(uniKeyFromUrl) && !Intrinsics.areEqual(uniKeyFromUrl, tag)) {
            this.sugAdItemAvatar.setTag(R.id.f54382f2, uniKeyFromUrl);
            this.sugAdItemAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(this.sugAdItemAvatar).setUrl(url).setLoadingDrawableColor(a.f().g(getContext(), R.color.qui_common_fill_standard_primary, 1000)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(QFSSearchSuggestAdItemView this$0, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.action == 3) {
            QLog.i("QFSSearchSuggestAdItemView", 1, "feedBackListener.hide_ad");
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchAdFeedbackEvent(this$0.currentPos));
        }
    }

    private final String o0(List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo> buttonInfoList) {
        if (!buttonInfoList.isEmpty()) {
            for (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo : buttonInfoList) {
                if (buttonInfo.pos.get() == 2) {
                    String str = buttonInfo.txt.get();
                    Intrinsics.checkNotNullExpressionValue(str, "buttonInfo.txt.get()");
                    return str;
                }
            }
            return "";
        }
        return "";
    }

    private final void p0() {
        this.suggestAdRootView.setOnClickListener(this);
        this.sugAdItemAvatar.setOnClickListener(this);
        this.sugAdItemName.setOnClickListener(this);
        this.sugAdItemDescription.setOnClickListener(this);
        this.sugAdItemLogo.setOnClickListener(this);
        this.sugAdItemButton.setOnClickListener(this);
    }

    private final boolean q0(View v3) {
        if (v3.getContext().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private final void s0(View v3) {
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        Context context = v3.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        adFeedbackParams.activity = new WeakReference<>((Activity) context);
        adFeedbackParams.listener = new WeakReference<>(this.feedBackListener);
        adFeedbackParams.isDarkMode = QCircleSkinHelper.getInstance().isDarkMode();
        adFeedbackParams.f61346ad = this.gdtAd;
        adFeedbackParams.styleId = q0(v3) ? 1 : 0;
        QLog.i("QFSSearchSuggestAdItemView", 1, "AdFeedbackDialogFragment.start");
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("QFSSearchSuggestAdItemView", 1, "showFeedbackDialog", th5);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSSearchSuggestAdItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull b suggestionInfo, int pos) {
        Intrinsics.checkNotNullParameter(suggestionInfo, "suggestionInfo");
        Object b16 = suggestionInfo.b("EXTRA_SUGGESTION_AD_DATA");
        int i3 = 8;
        this.suggestAdRootView.setVisibility(8);
        if (b16 != null && (b16 instanceof qq_ad_get.QQAdGetRsp.AdInfo)) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) b16;
            String str = adInfo.display_info.advertiser_info.corporate_image_name.get();
            String logo = adInfo.display_info.advertiser_info.corporate_logo.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(logo)) {
                QLog.d("QFSSearchSuggestAdItemView", 1, "[bindData] name: " + str + ", pos: " + pos);
                this.currentPos = pos;
                this.suggestAdRootView.setVisibility(0);
                Intrinsics.checkNotNullExpressionValue(logo, "logo");
                m0(logo);
                this.sugAdItemName.setText(str);
                this.sugAdItemDescription.setText(adInfo.display_info.basic_info.txt.get());
                List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo> list = adInfo.display_info.button_info.get();
                Intrinsics.checkNotNullExpressionValue(list, "adInfo.display_info.button_info.get()");
                String o06 = o0(list);
                this.sugAdItemButton.setText(o06);
                TextView textView = this.sugAdItemButton;
                if (!TextUtils.isEmpty(o06)) {
                    i3 = 0;
                }
                textView.setVisibility(i3);
                Drawable o16 = a.f().o(getContext(), R.drawable.qui_chevron_down, R.color.qui_common_icon_tertiary, 1000);
                int i16 = this.sugAdItemLogoIconSize;
                o16.setBounds(0, 0, i16, i16);
                this.sugAdItemLogo.setCompoundDrawables(null, null, o16, null);
                p0();
                GdtAd gdtAd = new GdtAd(adInfo);
                this.gdtAd = gdtAd;
                ConstraintLayout suggestAdRootView = this.suggestAdRootView;
                Intrinsics.checkNotNullExpressionValue(suggestAdRootView, "suggestAdRootView");
                d dVar = new d(gdtAd, pos, suggestAdRootView, null);
                this.searchItemViewAdExpose = dVar;
                if (this.hasAttachedToWindow) {
                    dVar.l();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.i("QFSSearchSuggestAdItemView", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        d dVar = this.searchItemViewAdExpose;
        if (dVar != null) {
            dVar.l();
        }
        this.hasAttachedToWindow = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.f54392f3) {
            ConstraintLayout suggestAdRootView = this.suggestAdRootView;
            Intrinsics.checkNotNullExpressionValue(suggestAdRootView, "suggestAdRootView");
            s0(suggestAdRootView);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f54382f2) {
                i3 = 2;
            } else if (id5 == R.id.f54402f4) {
                i3 = 3;
            } else if (id5 == R.id.f54372f1) {
                i3 = 4;
            } else if (id5 == R.id.f54412f5) {
                i3 = 46;
            } else {
                i3 = 1000;
            }
            j.f90213a.I(this.gdtAd, this.suggestAdRootView, this.currentPos, null, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("QFSSearchSuggestAdItemView", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        d dVar = this.searchItemViewAdExpose;
        if (dVar != null) {
            dVar.g();
        }
        this.hasAttachedToWindow = false;
    }

    public final void r0() {
        QLog.i("QFSSearchSuggestAdItemView", 1, "onPartPause");
        d dVar = this.searchItemViewAdExpose;
        if (dVar != null) {
            dVar.g();
        }
    }
}
