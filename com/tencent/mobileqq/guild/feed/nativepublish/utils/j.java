package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:B_\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c\u0012\u0018\u0010#\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u000b\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u000e\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002R\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR(\u0010#\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/j;", "Landroid/app/Dialog;", "", "initWindow", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "U", "Z", "view", "", "isClick", "", "", "params", "Y", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "dialogContent", "D", "title", "", "E", "I", "btnType", "Landroid/content/DialogInterface$OnDismissListener;", UserInfo.SEX_FEMALE, "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "Lkotlin/Function0;", "G", "Lkotlin/jvm/functions/Function0;", "onBtnClick", "", "H", "Ljava/util/Map;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "feedViolationDialogTip", "K", "feedViolationDialogContent", "Landroid/widget/Button;", "L", "Landroid/widget/Button;", "feedViolationDialogBtn", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "feedViolationDialogExitBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILandroid/content/DialogInterface$OnDismissListener;Lkotlin/jvm/functions/Function0;Ljava/util/Map;)V", "N", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String dialogContent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: E, reason: from kotlin metadata */
    private final int btnType;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener dismissListener;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Function0<Unit> onBtnClick;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Map<String, ? extends Object> pageParams;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView feedViolationDialogTip;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView feedViolationDialogContent;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Button feedViolationDialogBtn;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ImageView feedViolationDialogExitBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/utils/j$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f222339d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ j f222340e;

        a(Context context, j jVar) {
            this.f222339d = context;
            this.f222340e = jVar;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF52508d() {
            View rootView = LayoutInflater.from(this.f222339d).inflate(R.layout.erv, (ViewGroup) null);
            j jVar = this.f222340e;
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            jVar.U(rootView);
            return rootView;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public /* synthetic */ j(Context context, String str, String str2, int i3, DialogInterface.OnDismissListener onDismissListener, Function0 function0, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? null : onDismissListener, function0, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(View rootView) {
        String string;
        TextView textView = (TextView) rootView.findViewById(R.id.v48);
        if (!TextUtils.isEmpty(this.title)) {
            string = this.title;
        } else {
            string = textView.getResources().getString(R.string.zy7);
        }
        textView.setText(string);
        this.feedViolationDialogTip = textView;
        TextView textView2 = (TextView) rootView.findViewById(R.id.v46);
        textView2.setText(this.dialogContent);
        this.feedViolationDialogContent = textView2;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.v47);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.W(j.this, view);
            }
        });
        this.feedViolationDialogExitBtn = imageView;
        Z(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this$0.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this$0);
        }
    }

    private final void Y(View view, boolean isClick, Map<String, ?> params) {
        String str;
        if (isClick) {
            str = "clck";
        } else {
            str = "imp";
        }
        String str2 = str;
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        if (params == null) {
            params = new HashMap<>();
        }
        iGuildDTReportApi.reportDtEventManual(view, "em_sgrp_violation_tip_float_btn", "pg_sgrp_forum_detail", "", str2, params, this.pageParams);
    }

    private final void Z(View rootView) {
        Map<String, ?> mapOf;
        Button button = (Button) rootView.findViewById(R.id.f165198v45);
        this.feedViolationDialogBtn = button;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_violation_type", Integer.valueOf(this.btnType)));
        Y(button, false, mapOf);
        int i3 = this.btnType;
        if (i3 != 1) {
            if (i3 != 2) {
                Button button2 = this.feedViolationDialogBtn;
                if (button2 != null) {
                    button2.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.guild_feed_violation_button_bg));
                }
                Button button3 = this.feedViolationDialogBtn;
                if (button3 != null) {
                    button3.setText(HardCodeUtil.qqStr(R.string.f170936zy3));
                }
                Button button4 = this.feedViolationDialogBtn;
                if (button4 != null) {
                    button4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            j.a0(j.this, view);
                        }
                    });
                    return;
                }
                return;
            }
            Button button5 = this.feedViolationDialogBtn;
            if (button5 != null) {
                button5.setText(HardCodeUtil.qqStr(R.string.zy4));
            }
            Button button6 = this.feedViolationDialogBtn;
            if (button6 != null) {
                button6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        j.c0(j.this, view);
                    }
                });
                return;
            }
            return;
        }
        Button button7 = this.feedViolationDialogBtn;
        if (button7 != null) {
            button7.setText(HardCodeUtil.qqStr(R.string.zy5));
        }
        Button button8 = this.feedViolationDialogBtn;
        if (button8 != null) {
            button8.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.b0(j.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(j this$0, View view) {
        Map<String, ?> mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
        Button button = this$0.feedViolationDialogBtn;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_violation_type", Integer.valueOf(this$0.btnType)));
        this$0.Y(button, true, mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(j this$0, View view) {
        Map<String, ?> mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBtnClick.invoke();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
        Button button = this$0.feedViolationDialogBtn;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_violation_type", Integer.valueOf(this$0.btnType)));
        this$0.Y(button, true, mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(j this$0, View view) {
        Map<String, ?> mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBtnClick.invoke();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
        Button button = this$0.feedViolationDialogBtn;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_violation_type", Integer.valueOf(this$0.btnType)));
        this$0.Y(button, true, mapOf);
        EventCollector.getInstance().onViewClicked(view);
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
            QLog.e("FeedViolationDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull Context context, @NotNull String dialogContent, @NotNull String title, int i3, @Nullable DialogInterface.OnDismissListener onDismissListener, @NotNull Function0<Unit> onBtnClick, @Nullable Map<String, ? extends Object> map) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogContent, "dialogContent");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onBtnClick, "onBtnClick");
        this.dialogContent = dialogContent;
        this.title = title;
        this.btnType = i3;
        this.dismissListener = onDismissListener;
        this.onBtnClick = onBtnClick;
        this.pageParams = map;
        initWindow();
        setContentView(R.layout.ejv);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.J();
            qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
            qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.utils.e
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    j.X(j.this);
                }
            });
            qUSHalfScreenFloatingView.setQUSDragFloatController(new a(context, this));
            qUSHalfScreenFloatingView.j(new b(qUSHalfScreenFloatingView));
        } else {
            qUSHalfScreenFloatingView = null;
        }
        this.floatingView = qUSHalfScreenFloatingView;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/utils/j$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$p;", "", "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "onShowMinStart", "onShowMin", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.p {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f222342e;

        b(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
            this.f222342e = qUSHalfScreenFloatingView;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            QUIImmersiveHelper.t(j.this.getWindow(), false, null, true, this.f222342e);
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
