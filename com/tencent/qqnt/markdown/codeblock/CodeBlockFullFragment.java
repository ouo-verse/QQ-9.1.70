package com.tencent.qqnt.markdown.codeblock;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.android.androidbypass.Document;
import com.tencent.android.androidbypass.codeblock.config.highlight.DefaultHighlightConfig;
import com.tencent.android.androidbypass.codeblock.config.highlight.NightHighlightConfig;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J$\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010\"\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0006R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/markdown/codeblock/CodeBlockFullFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initUI", "Ih", "Lh", "", "yh", "isNight", "Mh", "Landroid/view/View;", "view", "Kh", "Jh", "Hh", "initData", "xh", "needImmersive", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/content/Context;", "context", "withBg", "Ah", "Lvx3/a;", BdhLogUtil.LogTag.Tag_Conn, "Lvx3/a;", "_binding", "D", "Landroid/view/View;", "loadingView", OcrConfig.CHINESE, "()Lvx3/a;", "binding", "<init>", "()V", "E", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class CodeBlockFullFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private vx3.a _binding;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View loadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/markdown/codeblock/CodeBlockFullFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "text", "", "a", "ENABLE_DRAW_VISIBLE_RECT_SWITCH_FOR_PAGE", "Ljava/lang/String;", "KEY_DISABLE_CUSTOM_ANIM", "KEY_ORIGIN_TEXT", "TAG", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.codeblock.CodeBlockFullFragment$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull Activity activity, @NotNull String text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) text);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(text, "text");
            Bundle bundle = new Bundle();
            bundle.putString("key_origin_text", text);
            bundle.putBoolean(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, false);
            bundle.putBoolean("disable_custom_anim", true);
            if (AppSetting.t(activity)) {
                i.e(activity, bundle, CodeBlockFullFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
                return;
            }
            Intent intent = new Intent();
            intent.putExtras(bundle);
            QPublicFragmentActivity.start(activity, intent, CodeBlockFullFragment.class);
            activity.overridePendingTransition(0, 0);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/markdown/codeblock/CodeBlockFullFragment$b", "Lst/a;", "", "c", "Landroid/content/Context;", "context", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "Lcom/tencent/android/androidbypass/codeblock/config/c;", "d", "", "a", "Landroidx/lifecycle/LifecycleOwner;", "b", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements st.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CodeBlockFullFragment.this);
            }
        }

        @Override // st.a
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // st.a
        @NotNull
        /* renamed from: b */
        public LifecycleOwner getLifeCycleOwner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (LifecycleOwner) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return CodeBlockFullFragment.this;
        }

        @Override // st.a
        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).isEnableCodeBlockHighlight();
        }

        @Override // st.a
        @NotNull
        public com.tencent.android.androidbypass.codeblock.config.c d(@NotNull Context context, @NotNull String language) {
            com.tencent.android.androidbypass.codeblock.config.highlight.a defaultHighlightConfig;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.android.androidbypass.codeblock.config.c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) language);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(language, "language");
            if (CodeBlockFullFragment.this.Hh()) {
                defaultHighlightConfig = new NightHighlightConfig(context, Integer.MAX_VALUE);
            } else {
                defaultHighlightConfig = new DefaultHighlightConfig(context, Integer.MAX_VALUE);
            }
            return new com.tencent.android.androidbypass.codeblock.config.a().e(defaultHighlightConfig).d(new com.tencent.android.androidbypass.codeblock.config.global.a(context, CodeBlockFullFragment.this.xh(), false, null)).c();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CodeBlockFullFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(final CodeBlockFullFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle arguments = this$0.getArguments();
        if (arguments != null) {
            final com.tencent.android.androidbypass.parser.a b16 = com.tencent.qqnt.markdown.g.f359430a.g().c(new b()).b();
            final String valueOf = String.valueOf(arguments.getString("key_origin_text"));
            final Document b17 = b16.b(valueOf);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.markdown.codeblock.e
                @Override // java.lang.Runnable
                public final void run() {
                    CodeBlockFullFragment.Ch(CodeBlockFullFragment.this, b16, b17, valueOf);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(final CodeBlockFullFragment this$0, com.tencent.android.androidbypass.parser.a markdownParser, Document document, String originText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(markdownParser, "$markdownParser");
        Intrinsics.checkNotNullParameter(originText, "$originText");
        this$0.zh().f443639b.removeView(this$0.loadingView);
        if (TextUtils.isEmpty(a.C0724a.b(markdownParser, document, this$0.zh().f443641d, null, 4, null))) {
            this$0.zh().f443641d.setText(originText);
        }
        if (this$0.xh()) {
            this$0.zh().f443648k.setScrollViewListener(new h() { // from class: com.tencent.qqnt.markdown.codeblock.f
                @Override // com.tencent.qqnt.markdown.codeblock.h
                public final void a(ObservableScrollView observableScrollView, int i3, int i16, int i17, int i18) {
                    CodeBlockFullFragment.Dh(CodeBlockFullFragment.this, observableScrollView, i3, i16, i17, i18);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(CodeBlockFullFragment this$0, ObservableScrollView observableScrollView, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh().f443641d.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(CodeBlockFullFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context).onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(CodeBlockFullFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ih();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(CodeBlockFullFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ih();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Hh() {
        if (!QQTheme.isNowThemeIsNight() && !QQTheme.isVasTheme()) {
            return false;
        }
        return true;
    }

    private final void Ih() {
        Object obj;
        ClipboardManager clipboardManager;
        Bundle arguments;
        String string;
        String removeSuffix;
        String substringAfter$default;
        Context context = getContext();
        if (context != null) {
            obj = context.getSystemService("clipboard");
        } else {
            obj = null;
        }
        if (obj instanceof ClipboardManager) {
            clipboardManager = (ClipboardManager) obj;
        } else {
            clipboardManager = null;
        }
        if (clipboardManager != null && (arguments = getArguments()) != null && (string = arguments.getString("key_origin_text")) != null) {
            removeSuffix = StringsKt__StringsKt.removeSuffix(string, (CharSequence) "```");
            substringAfter$default = StringsKt__StringsKt.substringAfter$default(removeSuffix, "\n", (String) null, 2, (Object) null);
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText(null, substringAfter$default));
            QQToast.makeText(getContext(), 2, "\u5df2\u590d\u5236", 0).show();
        }
    }

    private final void Jh(boolean isNight) {
        int i3;
        int i16;
        int i17;
        RelativeLayout relativeLayout = zh().f443645h;
        Resources resources = getResources();
        if (isNight) {
            i3 = R.color.bc5;
        } else {
            i3 = R.color.bc6;
        }
        relativeLayout.setBackgroundColor(resources.getColor(i3));
        TextView textView = zh().f443646i;
        Resources resources2 = getResources();
        if (isNight) {
            i16 = R.color.f158017al3;
        } else {
            i16 = R.color.black;
        }
        textView.setTextColor(resources2.getColor(i16));
        if (isNight) {
            i17 = 1002;
        } else {
            i17 = 1001;
        }
        zh().f443644g.setBackground(ie0.a.f().o(getContext(), R.drawable.qui_copy_plus, R.color.qui_common_icon_primary, i17));
        zh().f443646i.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, i17));
    }

    private final void Kh(View view, boolean isNight) {
        int i3;
        Resources resources = getResources();
        if (isNight) {
            i3 = R.color.bc7;
        } else {
            i3 = R.color.bc8;
        }
        view.setBackgroundColor(resources.getColor(i3));
    }

    private final void Lh() {
        int i3;
        DisplayMetrics displayMetrics = BaseApplication.context.getResources().getDisplayMetrics();
        if (yh()) {
            i3 = (int) (displayMetrics.widthPixels * com.tencent.mobileqq.pad.e.g());
        } else {
            i3 = displayMetrics.widthPixels;
        }
        int dpToPx = i3 - ViewUtils.dpToPx(16.0f);
        if (zh().f443641d.getLayoutParams() != null) {
            zh().f443641d.getLayoutParams().width = dpToPx;
        } else {
            zh().f443641d.setLayoutParams(new ViewGroup.LayoutParams(dpToPx, -1));
        }
        zh().f443641d.setMaxWidth(dpToPx);
    }

    private final void Mh(boolean isNight) {
        int i3;
        int i16;
        LinearLayout root = zh().getRoot();
        Resources resources = getResources();
        if (isNight) {
            i3 = R.color.bc5;
        } else {
            i3 = R.color.bc6;
        }
        root.setBackgroundColor(resources.getColor(i3));
        View view = zh().f443647j;
        Intrinsics.checkNotNullExpressionValue(view, "binding.fakeStatusBar");
        Kh(view, isNight);
        FrameLayout frameLayout = zh().f443642e;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.codeblockTitleContainer");
        Kh(frameLayout, isNight);
        Jh(isNight);
        ImageView imageView = zh().f443640c;
        Resources resources2 = getResources();
        int i17 = R.color.bc9;
        if (isNight) {
            i16 = R.color.bc9;
        } else {
            i16 = R.color.bc_;
        }
        imageView.setColorFilter(resources2.getColor(i16));
        TextView textView = zh().f443643f;
        Resources resources3 = getResources();
        if (!isNight) {
            i17 = R.color.bc_;
        }
        textView.setTextColor(resources3.getColor(i17));
    }

    private final void initData() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.markdown.codeblock.a
            @Override // java.lang.Runnable
            public final void run() {
                CodeBlockFullFragment.Bh(CodeBlockFullFragment.this);
            }
        }, 16, null, true);
    }

    private final void initUI() {
        Mh(Hh());
        View view = zh().f443647j;
        Intrinsics.checkNotNullExpressionValue(view, "binding.fakeStatusBar");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = ImmersiveUtils.getStatusBarHeight(getContext());
        } else {
            layoutParams = new ViewGroup.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(getContext()));
        }
        view.setLayoutParams(layoutParams);
        Lh();
        this.loadingView = Ah(getContext(), false);
        zh().f443639b.addView(this.loadingView);
        zh().f443640c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.markdown.codeblock.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CodeBlockFullFragment.Eh(CodeBlockFullFragment.this, view2);
            }
        });
        zh().f443646i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.markdown.codeblock.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CodeBlockFullFragment.Fh(CodeBlockFullFragment.this, view2);
            }
        });
        zh().f443644g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.markdown.codeblock.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CodeBlockFullFragment.Gh(CodeBlockFullFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean xh() {
        return false;
    }

    private final boolean yh() {
        try {
            if (com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final vx3.a zh() {
        vx3.a aVar = this._binding;
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    @NotNull
    public final View Ah(@Nullable Context context, boolean withBg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(withBg));
        }
        View view = LayoutInflater.from(context).inflate(R.layout.f167842e52, (ViewGroup) null);
        ImageView imageView = (ImageView) view.findViewById(R.id.ysu);
        if (!withBg) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ef_);
            linearLayout.setBackground(null);
            linearLayout.setGravity(17);
            TextView textView = (TextView) view.findViewById(R.id.yt9);
            if (context != null) {
                i16 = context.getColor(R.color.guild_aio_title_text);
            }
            textView.setTextColor(i16);
        }
        if (withBg) {
            i3 = 1;
        }
        imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(context, i3));
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        Window window = activity.getWindow();
        if (window != null) {
            RFWImmersiveUtils.setImmersiveLayout(window, false);
            RFWImmersiveUtils.setTransparentStatusBar(window);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Lh();
        zh().getRoot().invalidate();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            root = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            this._binding = vx3.a.g(inflater, container, false);
            initUI();
            initData();
            root = zh().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }
}
