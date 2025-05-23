package com.tencent.mobileqq.guild.setting.guildmanage.dialog;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.GuildNameTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 82\u00020\u0001:\u00029:B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0018\u00105\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "", OcrConfig.CHINESE, "", "isQuit", "Bh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initData", "onStart", "uh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$b;", "dialogListener", "Ch", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "title", "Lcom/tencent/mobileqq/guild/widget/GuildNameTextView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/GuildNameTextView;", "content", "Landroid/widget/Button;", "G", "Landroid/widget/Button;", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "H", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "cancel", "I", "againConfirm", "J", "Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$b;", "listener", "<init>", "()V", "K", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAgainConfirmDialog extends ReportAndroidXDialogFragment {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView title;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildNameTextView content;

    /* renamed from: G, reason: from kotlin metadata */
    private Button confirm;

    /* renamed from: H, reason: from kotlin metadata */
    private QUIButton cancel;

    /* renamed from: I, reason: from kotlin metadata */
    private Button againConfirm;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private b listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragManager", "Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmData;", "info", "Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$b;", "listener", "", "a", "", "GUILD_COUNTDOWN_INFO", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragManager, @NotNull GuildAgainConfirmData info, @NotNull b listener) {
            Intrinsics.checkNotNullParameter(fragManager, "fragManager");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(listener, "listener");
            GuildAgainConfirmDialog guildAgainConfirmDialog = new GuildAgainConfirmDialog();
            guildAgainConfirmDialog.Ch(listener);
            Bundle bundle = new Bundle();
            bundle.putParcelable("guild_countdown_info", info);
            guildAgainConfirmDialog.setArguments(bundle);
            com.tencent.mobileqq.guild.base.extension.d.a(guildAgainConfirmDialog, fragManager, "GuildCountdownConfirmDialog");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$b;", "", "Landroid/view/View;", "view", "", "a", "b", "cancel", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "c", "againConfirm", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public static final class a {
            public static void a(@NotNull b bVar, @NotNull View againConfirm) {
                Intrinsics.checkNotNullParameter(againConfirm, "againConfirm");
            }

            public static void b(@NotNull b bVar, @NotNull View cancel, @NotNull View confirm) {
                Intrinsics.checkNotNullParameter(cancel, "cancel");
                Intrinsics.checkNotNullParameter(confirm, "confirm");
            }

            public static void c(@NotNull b bVar, @NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }

        void a(@NotNull View view);

        void b(@NotNull View view);

        void c(@NotNull View cancel, @NotNull View confirm);

        void d(@NotNull View againConfirm);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        public View createContentView() {
            View view = LayoutInflater.from(GuildAgainConfirmDialog.this.getContext()).inflate(R.layout.edp, (ViewGroup) null);
            GuildAgainConfirmDialog guildAgainConfirmDialog = GuildAgainConfirmDialog.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            guildAgainConfirmDialog.uh(view);
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J*\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$d", "Lee0/b;", "Landroid/content/Context;", "context", "", "buttonType", "sizeType", "f", "type", "themeId", "Landroid/graphics/drawable/GradientDrawable;", "d", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends ee0.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f233824b;

        d(boolean z16) {
            this.f233824b = z16;
        }

        @Override // ee0.b
        @NotNull
        public GradientDrawable b(@Nullable Context context, int type, int sizeType, int themeId) {
            if (this.f233824b) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#FF3517"));
                gradientDrawable.setCornerRadius(com.tencent.biz.qui.quicommon.e.a(100.0f));
                return gradientDrawable;
            }
            GradientDrawable b16 = super.b(context, type, sizeType, themeId);
            Intrinsics.checkNotNullExpressionValue(b16, "super.buildDefaultDrawab\u2026 type, sizeType, themeId)");
            return b16;
        }

        @Override // ee0.b
        @NotNull
        public GradientDrawable d(@Nullable Context context, int type, int sizeType, int themeId) {
            if (this.f233824b) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#E02E14"));
                gradientDrawable.setCornerRadius(com.tencent.biz.qui.quicommon.e.a(100.0f));
                return gradientDrawable;
            }
            GradientDrawable d16 = super.d(context, type, sizeType, themeId);
            Intrinsics.checkNotNullExpressionValue(d16, "super.buildPressedDrawab\u2026 type, sizeType, themeId)");
            return d16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int f(@NotNull Context context, int buttonType, int sizeType) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (int) cw.d(100);
        }
    }

    public GuildAgainConfirmDialog() {
        setStyle(0, R.style.f173448dl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(GuildAgainConfirmDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void Bh(boolean isQuit) {
        d dVar = new d(isQuit);
        Button button = this.confirm;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            button = null;
        }
        StateListDrawable a16 = dVar.a(button.getContext(), 0, 1, 1000);
        Button button3 = this.confirm;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            button3 = null;
        }
        button3.setBackground(a16);
        Button button4 = this.againConfirm;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
        } else {
            button2 = button4;
        }
        button2.setBackground(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(View view, final GuildAgainConfirmDialog this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int width = ((FrameLayout) view.findViewById(R.id.ai7)).getWidth();
        Button button = this$0.againConfirm;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
            button = null;
        }
        button.setVisibility(0);
        Button button3 = this$0.againConfirm;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
            button3 = null;
        }
        Button button4 = this$0.confirm;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            button4 = null;
        }
        button3.setTranslationX(button4.getWidth());
        float[] fArr = new float[2];
        Button button5 = this$0.confirm;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            button5 = null;
        }
        fArr[0] = button5.getWidth();
        fArr[1] = 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: gz1.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildAgainConfirmDialog.wh(GuildAgainConfirmDialog.this, width, valueAnimator);
            }
        });
        QUIButton qUIButton = this$0.cancel;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancel");
            qUIButton = null;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(qUIButton, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat2.setDuration(75L);
        ofFloat2.start();
        ofFloat.start();
        b bVar = this$0.listener;
        if (bVar != null) {
            Button button6 = this$0.againConfirm;
            if (button6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
            } else {
                button2 = button6;
            }
            bVar.d(button2);
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(GuildAgainConfirmDialog this$0, int i3, ValueAnimator valueAnimator) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Button button = this$0.againConfirm;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
            button = null;
        }
        ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = (int) (i3 - floatValue);
        Button button3 = this$0.againConfirm;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
            button3 = null;
        }
        button3.setLayoutParams(layoutParams2);
        Button button4 = this$0.againConfirm;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
            button4 = null;
        }
        button4.setTranslationX(floatValue);
        boolean z17 = true;
        if (floatValue == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Button button5 = this$0.confirm;
            if (button5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                button5 = null;
            }
            if (button5.getVisibility() != 0) {
                z17 = false;
            }
            if (z17) {
                QUIButton qUIButton = this$0.cancel;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cancel");
                    qUIButton = null;
                }
                qUIButton.setVisibility(8);
                Button button6 = this$0.confirm;
                if (button6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                } else {
                    button2 = button6;
                }
                button2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(GuildAgainConfirmDialog this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.a(it);
        }
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GuildAgainConfirmDialog this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.b(it);
        }
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void zh() {
        View view = this.rootView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = (QUSHalfScreenFloatingView) findViewById;
        this.floatingView = qUSHalfScreenFloatingView2;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView2 = null;
        }
        qUSHalfScreenFloatingView2.setIsHeightWrapContent(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.floatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.floatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.J();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.floatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView5;
        }
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: gz1.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildAgainConfirmDialog.Ah(GuildAgainConfirmDialog.this);
            }
        });
    }

    public final void Ch(@NotNull b dialogListener) {
        Intrinsics.checkNotNullParameter(dialogListener, "dialogListener");
        this.listener = dialogListener;
    }

    public final void initData() {
        GuildAgainConfirmData guildAgainConfirmData;
        Bundle arguments = getArguments();
        Button button = null;
        if (arguments != null) {
            guildAgainConfirmData = (GuildAgainConfirmData) arguments.getParcelable("guild_countdown_info");
        } else {
            guildAgainConfirmData = null;
        }
        if (guildAgainConfirmData != null) {
            TextView textView = this.title;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView = null;
            }
            textView.setText(guildAgainConfirmData.getTitle());
            GuildNameTextView guildNameTextView = this.content;
            if (guildNameTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("content");
                guildNameTextView = null;
            }
            guildNameTextView.setText(guildAgainConfirmData.getContent());
            Button button2 = this.confirm;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
                button2 = null;
            }
            button2.setText(guildAgainConfirmData.getConfirm());
            Button button3 = this.againConfirm;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
                button3 = null;
            }
            button3.setText(guildAgainConfirmData.getAgainConfirm());
            boolean z16 = true;
            if (guildAgainConfirmData.getType() != 1) {
                z16 = false;
            }
            Bh(z16);
        }
        b bVar = this.listener;
        if (bVar != null) {
            QUIButton qUIButton = this.cancel;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cancel");
                qUIButton = null;
            }
            Button button4 = this.confirm;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            } else {
                button = button4;
            }
            bVar.c(qUIButton, button);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Button button = this.againConfirm;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
            button = null;
        }
        if (button.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && QQGuildUIUtil.z()) {
            Button button2 = this.againConfirm;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
                button2 = null;
            }
            ViewGroup.LayoutParams layoutParams = button2.getLayoutParams();
            layoutParams.width = com.tencent.biz.qui.quicommon.e.j() - com.tencent.biz.qui.quicommon.e.a(32.0f);
            Button button3 = this.againConfirm;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
                button3 = null;
            }
            button3.setLayoutParams(layoutParams);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.floatingView;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        }
        qUSHalfScreenFloatingView.L();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.e3i, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026screen, container, false)");
        this.rootView = inflate;
        zh();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(0);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            GuildUIUtils.H(window);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    public final void uh(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.u4i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.confirm_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.u4a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.confirm_content)");
        this.content = (GuildNameTextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.b7m);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.confirm)");
        this.confirm = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.cancel)");
        this.cancel = (QUIButton) findViewById4;
        View findViewById5 = view.findViewById(R.id.sf5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.again_confirm)");
        this.againConfirm = (Button) findViewById5;
        Button button = this.confirm;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: gz1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildAgainConfirmDialog.vh(view, this, view2);
            }
        });
        QUIButton qUIButton = this.cancel;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancel");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: gz1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildAgainConfirmDialog.xh(GuildAgainConfirmDialog.this, view2);
            }
        });
        Button button3 = this.againConfirm;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("againConfirm");
        } else {
            button2 = button3;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: gz1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildAgainConfirmDialog.yh(GuildAgainConfirmDialog.this, view2);
            }
        });
    }
}
