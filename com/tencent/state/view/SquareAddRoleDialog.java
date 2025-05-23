package com.tencent.state.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareFirstDialogBinding;
import com.tencent.state.square.message.AddRoleDialogInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J,\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/view/SquareAddRoleDialog;", "Landroid/app/Dialog;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "context", "Landroid/content/Context;", "addRoleInfo", "Lcom/tencent/state/square/message/AddRoleDialogInfo;", "dismissCallback", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Lcom/tencent/state/square/message/AddRoleDialogInfo;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFirstDialogBinding;", "faceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "hasClickedBtn", "", "dismiss", "initAvatarView", "initListener", "initTroopView", "initView", "initWindow", "onDecodeTaskCompleted", "remainingTasks", RemoteProxy.KEY_RESULT_TYPE, "resultUin", "", "avatar", "Landroid/graphics/Bitmap;", "reportDialogEvent", "type", "btnType", "setAvatarHead", "show", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAddRoleDialog extends Dialog implements IDecodeTaskCompletionListener {
    private static final float BG_AVATAR_HEIGHT = 264.0f;
    private static final float BG_TROOP_HEIGHT = 242.0f;
    private static final float DIALOG_AVATAR_HEIGHT = 264.0f;
    private static final float DIALOG_TROOP_HEIGHT = 308.0f;
    private static final float DIALOG_WIDTH = 296.0f;
    public static final int DISMISS_CANCEL = 3;
    public static final int DISMISS_LEFT = 1;
    public static final int DISMISS_RIGHT = 2;
    private final AddRoleDialogInfo addRoleInfo;
    private final VasSquareFirstDialogBinding binding;
    private final Function1<Integer, Unit> dismissCallback;
    private IFaceDecoder faceDecoder;
    private boolean hasClickedBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SquareAddRoleDialog(Context context, AddRoleDialogInfo addRoleInfo, Function1<? super Integer, Unit> function1) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(addRoleInfo, "addRoleInfo");
        this.addRoleInfo = addRoleInfo;
        this.dismissCallback = function1;
        VasSquareFirstDialogBinding inflate = VasSquareFirstDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFirstDialogBind\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getMRv());
        initView();
        initWindow();
        initListener();
    }

    private final void initAvatarView() {
        SquareImageView squareImageView = this.binding.imgBg;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.imgBg");
        ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = ViewExtensionsKt.dip(getContext(), 264.0f);
        }
        SquareImageView squareImageView2 = this.binding.troopIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.troopIcon");
        squareImageView2.setVisibility(8);
        CircleBoarderImageView circleBoarderImageView = this.binding.avatarIcon;
        Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.avatarIcon");
        circleBoarderImageView.setVisibility(0);
        TextView textView = this.binding.avatarName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.avatarName");
        textView.setVisibility(0);
        TextView textView2 = this.binding.txtTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.txtTitle");
        textView2.setText(getContext().getString(R.string.xcm));
        TextView textView3 = this.binding.txtTips;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.txtTips");
        textView3.setText(getContext().getString(R.string.xcl));
        TextView textView4 = this.binding.avatarName;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.avatarName");
        textView4.setText(this.addRoleInfo.getName());
        setAvatarHead();
    }

    private final void initListener() {
        this.binding.btnLeft.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareAddRoleDialog$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1 function1;
                SquareAddRoleDialog.this.reportDialogEvent("click", 0);
                function1 = SquareAddRoleDialog.this.dismissCallback;
                if (function1 != null) {
                }
                SquareAddRoleDialog.this.hasClickedBtn = true;
                SquareAddRoleDialog.this.dismiss();
            }
        });
        this.binding.btnRight.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareAddRoleDialog$initListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function1 function1;
                SquareAddRoleDialog.this.reportDialogEvent("click", 1);
                function1 = SquareAddRoleDialog.this.dismissCallback;
                if (function1 != null) {
                }
                SquareAddRoleDialog.this.hasClickedBtn = true;
                SquareAddRoleDialog.this.dismiss();
            }
        });
    }

    private final void initTroopView() {
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
        textView2.setText(getContext().getString(R.string.xcq));
        TextView textView3 = this.binding.txtTips;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.txtTips");
        textView3.setText(getContext().getString(R.string.xcp));
    }

    private final void initView() {
        if (this.addRoleInfo.isTroop()) {
            initTroopView();
        } else {
            initAvatarView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDialogEvent(String type, int btnType) {
        Map<String, Object> mutableMapOf;
        String reportEvent = this.addRoleInfo.getReportEvent();
        if (reportEvent != null) {
            IReporter reporter = Square.INSTANCE.getConfig().getReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", type), TuplesKt.to("zplan_button_display_type", Integer.valueOf(btnType)));
            reporter.reportEvent(reportEvent, mutableMapOf);
        }
    }

    private final void setAvatarHead() {
        IFaceDecoder faceDecoder = Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.faceDecoder = faceDecoder;
        if (faceDecoder == null) {
            this.binding.avatarIcon.setImageResource(R.drawable.i9d);
            return;
        }
        Bitmap bitmapFromCache$default = faceDecoder != null ? IFaceDecoder.DefaultImpls.getBitmapFromCache$default(faceDecoder, this.addRoleInfo.getUin(), false, 2, null) : null;
        if (bitmapFromCache$default != null) {
            this.binding.avatarIcon.setImageBitmap(bitmapFromCache$default);
            return;
        }
        IFaceDecoder iFaceDecoder = this.faceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(this);
        }
        IFaceDecoder iFaceDecoder2 = this.faceDecoder;
        if (iFaceDecoder2 != null) {
            iFaceDecoder2.requestDecodeFace(this.addRoleInfo.getUin(), this.addRoleInfo.isTroop());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Function1<Integer, Unit> function1;
        super.dismiss();
        if (!this.hasClickedBtn && (function1 = this.dismissCallback) != null) {
            function1.invoke(3);
        }
        IFaceDecoder iFaceDecoder = this.faceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destroy();
        }
    }

    @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int resultType, String resultUin, Bitmap avatar) {
        if (isShowing() && this.addRoleInfo.getType() == 1 && TextUtils.equals(resultUin, this.addRoleInfo.getUin())) {
            if (avatar != null) {
                this.binding.avatarIcon.setImageBitmap(avatar);
            } else {
                this.binding.avatarIcon.setImageResource(R.drawable.i9d);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        reportDialogEvent("imp", 0);
        reportDialogEvent("imp", 1);
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(ViewExtensionsKt.dip(getContext(), DIALOG_WIDTH), ViewExtensionsKt.dip(getContext(), this.addRoleInfo.isTroop() ? DIALOG_TROOP_HEIGHT : 264.0f));
        }
    }
}
