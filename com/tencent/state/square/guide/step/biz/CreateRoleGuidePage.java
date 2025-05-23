package com.tencent.state.square.guide.step.biz;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.databinding.VasSquareCreateRoleGuidePageBinding;
import com.tencent.state.square.guide.CreateRolePageConfig;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.utils.SquarePagFileUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/guide/step/biz/CreateRoleGuidePage;", "Landroid/app/Dialog;", "Landroid/content/DialogInterface$OnShowListener;", "guideContext", "Lcom/tencent/state/square/guide/GuideContext;", "callback", "Landroid/content/DialogInterface$OnDismissListener;", "(Lcom/tencent/state/square/guide/GuideContext;Landroid/content/DialogInterface$OnDismissListener;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareCreateRoleGuidePageBinding;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/guide/CreateRolePageConfig;", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "reporter", "Lcom/tencent/state/square/IReporter;", "initButtonView", "", "initFirstTitleView", "initListener", "initPagView", "initSecondTitleView", "initTitleView", "initView", "initWindow", "onShow", "dialog", "Landroid/content/DialogInterface;", "playAlphaAnim", "playAnim", "playPag", "reportClick", "type", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CreateRoleGuidePage extends Dialog implements DialogInterface.OnShowListener {
    private static final String TAG = "CreateRoleGuidePage";
    private final VasSquareCreateRoleGuidePageBinding binding;
    private final DialogInterface.OnDismissListener callback;
    private final CreateRolePageConfig config;
    private final GuideContext guideContext;
    private ISquarePagView pagView;
    private final IReporter reporter;

    public /* synthetic */ CreateRoleGuidePage(GuideContext guideContext, DialogInterface.OnDismissListener onDismissListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideContext, (i3 & 2) != 0 ? null : onDismissListener);
    }

    private final void initButtonView() {
        TextView textView = this.binding.btnDress;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.btnDress");
        textView.setText(this.config.getButtonText());
    }

    private final void initFirstTitleView() {
        TextView textView = this.binding.firstTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.firstTitle");
        textView.setText(this.config.getFirstText());
    }

    private final void initListener() {
        this.binding.rolePageContentContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$initListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareBaseKt.getSquareLog().d("CreateRoleGuidePage", "content click");
            }
        });
        this.binding.background.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$initListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoleGuidePage.this.reportClick(2);
                CreateRoleGuidePage.this.dismiss();
            }
        });
        this.binding.rolePagContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$initListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SquareBaseKt.getSquareLog().d("CreateRoleGuidePage", "pagContainer click");
            }
        });
        this.binding.btnDress.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$initListener$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuideContext guideContext;
                CreateRolePageConfig createRolePageConfig;
                CreateRoleGuidePage.this.reportClick(0);
                IRouter squareRouter = SquareBaseKt.getSquareRouter();
                guideContext = CreateRoleGuidePage.this.guideContext;
                FragmentActivity activity = guideContext.getActivity();
                createRolePageConfig = CreateRoleGuidePage.this.config;
                squareRouter.routeLink(activity, new EntranceLink(createRolePageConfig.getButtonJumpSchema(), 2));
            }
        });
        this.binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$initListener$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoleGuidePage.this.reportClick(1);
                CreateRoleGuidePage.this.dismiss();
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$initListener$6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogInterface.OnDismissListener onDismissListener;
                onDismissListener = CreateRoleGuidePage.this.callback;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(dialogInterface);
                }
            }
        });
    }

    private final void initPagView() {
        this.binding.rolePagContainer.removeAllViews();
        ISquarePagView pagView = Square.INSTANCE.getConfig().getCommonUtils().getPagView(this.guideContext.getActivity());
        View view = pagView != null ? pagView.getView() : null;
        if (pagView != null && view != null) {
            this.pagView = pagView;
            this.binding.rolePagContainer.addView(view, new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pagView init failed, ");
        sb5.append(pagView == null);
        squareLog.d(TAG, sb5.toString());
    }

    private final void initSecondTitleView() {
        TextView textView = this.binding.secondTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.secondTitle");
        textView.setText(this.config.getSecondText());
    }

    private final void initTitleView() {
        initFirstTitleView();
        initSecondTitleView();
    }

    private final void initView() {
        setContentView(this.binding.getRoot());
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setAlpha(0.0f);
        initPagView();
        initTitleView();
        initButtonView();
        initListener();
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$initView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CreateRoleGuidePage.this.playAnim();
            }
        });
    }

    private final void playAlphaAnim() {
        this.binding.getRoot().animate().alpha(1.0f).setDuration(500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playAnim() {
        playPag();
        playAlphaAnim();
    }

    private final void playPag() {
        SquareBaseKt.getSquareLog().d(TAG, "[NoviceGuide] playPag");
        SquarePagFileUtils.INSTANCE.downloadPagFile(this.config.getRolePagUrl(), new CreateRoleGuidePage$playPag$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportClick(int type) {
        Map<String, Object> mutableMapOf;
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_CREATE_ROLE_GUIDE_PAG_BTN, Integer.valueOf(type)));
            iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_CREATE_ROLE_GUIDE_PAGE, mutableMapOf);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialog) {
        Map<String, Object> mutableMapOf;
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
            iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_CREATE_ROLE_GUIDE_PAGE, mutableMapOf);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateRoleGuidePage(GuideContext guideContext, DialogInterface.OnDismissListener onDismissListener) {
        super(guideContext.getActivity(), R.style.f243270c);
        Intrinsics.checkNotNullParameter(guideContext, "guideContext");
        this.guideContext = guideContext;
        this.callback = onDismissListener;
        VasSquareCreateRoleGuidePageBinding inflate = VasSquareCreateRoleGuidePageBinding.inflate(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareCreateRoleGuide\u2026utInflater.from(context))");
        this.binding = inflate;
        this.config = guideContext.getConfig().getCreateRoleGuideConfig().getCreateRolePageConfig();
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        initView();
        initWindow();
        setOnShowListener(this);
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.f243260b);
        }
    }
}
