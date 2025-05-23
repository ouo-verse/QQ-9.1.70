package com.tencent.state.square.location;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.SquareAnchorEntrance;
import com.tencent.state.square.databinding.VasSquareFirstDialogBinding;
import com.tencent.state.status.BannerInfo;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/location/MotionUpdateDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "bannerInfo", "Lcom/tencent/state/status/BannerInfo;", "anchor", "Lcom/tencent/state/square/data/SquareAnchorEntrance;", "dismissCallback", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Lcom/tencent/state/status/BannerInfo;Lcom/tencent/state/square/data/SquareAnchorEntrance;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFirstDialogBinding;", "getReportBaseData", "", "", "", "event", "initListener", "initView", "initWindow", "reportClick", "update", "reportData", "show", "updateHeadIcon", "url", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MotionUpdateDialog extends Dialog {
    private static final float BG_TROOP_HEIGHT = 242.0f;
    private static final float DIALOG_TROOP_HEIGHT = 308.0f;
    private static final float DIALOG_WIDTH = 296.0f;
    public static final int DISMISS_CANCEL = 2;
    public static final int DISMISS_UPDATE = 1;
    private final SquareAnchorEntrance anchor;
    private final BannerInfo bannerInfo;
    private final VasSquareFirstDialogBinding binding;
    private final Function1<Integer, Unit> dismissCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MotionUpdateDialog(Context context, BannerInfo bannerInfo, SquareAnchorEntrance anchor, Function1<? super Integer, Unit> function1) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this.bannerInfo = bannerInfo;
        this.anchor = anchor;
        this.dismissCallback = function1;
        VasSquareFirstDialogBinding inflate = VasSquareFirstDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFirstDialogBind\u2026utInflater.from(context))");
        this.binding = inflate;
        setCanceledOnTouchOutside(false);
        setContentView(inflate.getMContainer());
        initView();
        initWindow();
        initListener();
    }

    private final void initListener() {
        this.binding.btnLeft.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.location.MotionUpdateDialog$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1 function1;
                MotionUpdateDialog.this.dismiss();
                function1 = MotionUpdateDialog.this.dismissCallback;
                if (function1 != null) {
                }
                MotionUpdateDialog.this.reportClick(0);
            }
        });
        this.binding.btnRight.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.location.MotionUpdateDialog$initListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1 function1;
                MotionUpdateDialog.this.dismiss();
                function1 = MotionUpdateDialog.this.dismissCallback;
                if (function1 != null) {
                }
                MotionUpdateDialog.this.reportClick(1);
            }
        });
    }

    private final void initView() {
        SquareImageView squareImageView = this.binding.imgBg;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.imgBg");
        ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = ViewExtensionsKt.dip(getContext(), BG_TROOP_HEIGHT);
        }
        SquareImageView squareImageView2 = this.binding.troopIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.troopIcon");
        squareImageView2.setVisibility(0);
        CircleBoarderImageView circleBoarderImageView = this.binding.avatarIcon;
        Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.avatarIcon");
        circleBoarderImageView.setVisibility(8);
        TextView textView = this.binding.avatarName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarName");
        textView.setVisibility(8);
        TextView textView2 = this.binding.txtTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.txtTitle");
        textView2.setText(this.bannerInfo.getSucDesc());
        TextView textView3 = this.binding.txtTips;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.txtTips");
        textView3.setText(getContext().getString(R.string.xgv));
        TextView textView4 = this.binding.btnLeft;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.btnLeft");
        textView4.setText(this.bannerInfo.getSucCancelBntName());
        TextView textView5 = this.binding.btnRight;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.btnRight");
        textView5.setText(this.bannerInfo.getSucConfirmBntName());
        updateHeadIcon(this.bannerInfo.getSucHeadIcon());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportClick(int update) {
        Map<String, Object> reportBaseData = getReportBaseData("click");
        reportBaseData.put("zplan_button_display_type", Integer.valueOf(update));
        Square.INSTANCE.getConfig().getReporter().reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_UPDATE_POPUP_WINDOW, reportBaseData);
    }

    private final void reportData(String event) {
        Square.INSTANCE.getConfig().getReporter().reportEvent(SquareReportConst.CustomEventId.EVENT_ID_STATE_UPDATE_POPUP_WINDOW, getReportBaseData(event));
    }

    private final void updateHeadIcon(String url) {
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, url, false, 2, null)) {
            URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null);
            urlDrawableOptions$default.mPlayGifImage = true;
            urlDrawableOptions$default.mUseApngImage = true;
            URLDrawable drawable = URLDrawable.getDrawable(url, urlDrawableOptions$default);
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            if (drawable.getStatus() != 1) {
                drawable.startDownload();
            }
            this.binding.troopIcon.setImageDrawable(drawable);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        reportData("imp");
    }

    private final Map<String, Object> getReportBaseData(String event) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", event), TuplesKt.to(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(this.anchor.getStatus())), TuplesKt.to(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(this.anchor.getRichStatus())), TuplesKt.to(SquareReportConst.Key.KEY_ACTION_ID, Integer.valueOf(this.anchor.getStatus())));
        return mutableMapOf;
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(ViewExtensionsKt.dip(getContext(), DIALOG_WIDTH), ViewExtensionsKt.dip(getContext(), DIALOG_TROOP_HEIGHT));
        }
    }
}
