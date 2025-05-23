package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B-\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/d;", "Landroid/app/Dialog;", "", "initWindow", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "dialogContent", "D", "title", "Landroid/content/DialogInterface$OnDismissListener;", "E", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "feedStandardDialogTip", "H", "feedStandardDialogContent", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "feedStandardDialogBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V", "J", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String dialogContent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener dismissListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView feedStandardDialogTip;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView feedStandardDialogContent;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QUIButton feedStandardDialogBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/utils/d$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f222330d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f222331e;

        a(Context context, d dVar) {
            this.f222330d = context;
            this.f222331e = dVar;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        public View createContentView() {
            View rootView = LayoutInflater.from(this.f222330d).inflate(R.layout.erd, (ViewGroup) null);
            d dVar = this.f222331e;
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            dVar.Q(rootView);
            return rootView;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, @NotNull String dialogContent, @NotNull String title, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogContent, "dialogContent");
        Intrinsics.checkNotNullParameter(title, "title");
        this.dialogContent = dialogContent;
        this.title = title;
        this.dismissListener = onDismissListener;
        initWindow();
        setContentView(R.layout.ejv);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.J();
            qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
            qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.b
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    d.S(d.this);
                }
            });
            qUSHalfScreenFloatingView.setQUSDragFloatController(new a(context, this));
            qUSHalfScreenFloatingView.j(new b(qUSHalfScreenFloatingView));
        } else {
            qUSHalfScreenFloatingView = null;
        }
        this.floatingView = qUSHalfScreenFloatingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(View rootView) {
        String string;
        TextView textView = (TextView) rootView.findViewById(R.id.v3g);
        if (!TextUtils.isEmpty(this.title)) {
            string = this.title;
        } else {
            string = textView.getResources().getString(R.string.f170934zy1);
        }
        textView.setText(string);
        this.feedStandardDialogTip = textView;
        TextView textView2 = (TextView) rootView.findViewById(R.id.v3e);
        textView2.setText(this.dialogContent);
        this.feedStandardDialogContent = textView2;
        QUIButton qUIButton = (QUIButton) rootView.findViewById(R.id.v3d);
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.R(d.this, view);
            }
        });
        this.feedStandardDialogBtn = qUIButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this$0.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this$0);
        }
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("FeedStandardDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/utils/d$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$p;", "", "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "onShowMinStart", "onShowMin", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.p {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f222333e;

        b(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
            this.f222333e = qUSHalfScreenFloatingView;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            QUIImmersiveHelper.t(d.this.getWindow(), false, null, true, this.f222333e);
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
        }
    }
}
