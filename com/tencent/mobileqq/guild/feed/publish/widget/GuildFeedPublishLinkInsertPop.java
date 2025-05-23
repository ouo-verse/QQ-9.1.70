package com.tencent.mobileqq.guild.feed.publish.widget;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.util.GuildFeedKeyboardUtils;
import com.tencent.mobileqq.guild.feed.video.GuidePopBuilder;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Z[B\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010V\u001a\u00020O\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J>\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0004\u0018\u00010 2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 J\u0006\u0010$\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0014H\u0016R\u0016\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010=\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010?R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR$\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010MR\"\u0010V\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/widget/GuildFeedPublishLinkInsertPop;", "Lcom/tencent/mobileqq/guild/feed/widget/a;", "Lcom/tencent/mobileqq/guild/window/s$c;", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$b;", "", "c0", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$c;", "Z", "", "X", "", "showTipIfNeed", "i0", "Landroid/content/Context;", "context", "initView", "Landroid/view/View;", "parentView", "view", "b0", "", "url", "a0", "f0", "d0", "g0", "W", "enable", "m0", "Y", "Lcom/tencent/mobileqq/guild/feed/publish/widget/GuildFeedPublishLinkInsertPop$b;", "defaultInfo", "Lkotlin/Function1;", "submitCallback", "cancelCallback", "l0", "onResume", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "dismiss", "contentStr", "G0", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/EditText;", "D", "Landroid/widget/EditText;", "primaryInput", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "E", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "secondInput", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "primaryInputDsc", "G", "commitBtn", "H", "titleTv", "Landroid/content/SharedPreferences$Editor;", "I", "Landroid/content/SharedPreferences$Editor;", "mEditor", "J", "mKeyBoardHeight", "Ljava/lang/Runnable;", "K", "Ljava/lang/Runnable;", "mShowSoftInputRunnable", "Lcom/tencent/mobileqq/guild/feed/video/h;", "L", "Lcom/tencent/mobileqq/guild/feed/video/h;", "guideProcessor", "M", "Lkotlin/jvm/functions/Function1;", "N", "Lcom/tencent/mobileqq/guild/feed/publish/widget/l;", "P", "Lcom/tencent/mobileqq/guild/feed/publish/widget/l;", "getConfig", "()Lcom/tencent/mobileqq/guild/feed/publish/widget/l;", "setConfig", "(Lcom/tencent/mobileqq/guild/feed/publish/widget/l;)V", DownloadInfo.spKey_Config, "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/feed/publish/widget/l;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishLinkInsertPop extends com.tencent.mobileqq.guild.feed.widget.a implements s.c, GuidePopBuilder.b {
    private static int R = com.tencent.guild.aio.util.c.b(300);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private EditText primaryInput;

    /* renamed from: E, reason: from kotlin metadata */
    private CharacterCountEditText secondInput;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView primaryInputDsc;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView commitBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: I, reason: from kotlin metadata */
    private SharedPreferences.Editor mEditor;

    /* renamed from: J, reason: from kotlin metadata */
    private int mKeyBoardHeight;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Runnable mShowSoftInputRunnable;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.video.h guideProcessor;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Function1<? super b, Unit> submitCallback;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Unit, Unit> cancelCallback;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private l config;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/widget/GuildFeedPublishLinkInsertPop$b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "b", "dsc", "", "c", "Z", "()Z", "showTipIfNeed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String dsc;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean showTipIfNeed;

        public b() {
            this(null, null, false, 7, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getDsc() {
            return this.dsc;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getShowTipIfNeed() {
            return this.showTipIfNeed;
        }

        public b(@NotNull String content, @NotNull String dsc, boolean z16) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(dsc, "dsc");
            this.content = content;
            this.dsc = dsc;
            this.showTipIfNeed = z16;
        }

        public /* synthetic */ b(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? false : z16);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/publish/widget/GuildFeedPublishLinkInsertPop$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            boolean z16;
            Intrinsics.checkNotNullParameter(s16, "s");
            GuildFeedPublishLinkInsertPop guildFeedPublishLinkInsertPop = GuildFeedPublishLinkInsertPop.this;
            EditText editText = guildFeedPublishLinkInsertPop.primaryInput;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
                editText = null;
            }
            Editable text = editText.getText();
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            guildFeedPublishLinkInsertPop.m0(!z16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPublishLinkInsertPop(@NotNull Context context, @NotNull l config) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        initView(context);
        d0(context);
        g0();
    }

    private final int W() {
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        if (DisplayUtil.checkDeviceHasNavigationBar(view.getContext())) {
            View view3 = this.rootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view3 = null;
            }
            if (DisplayUtil.hasNavBar(view3.getContext())) {
                View view4 = this.rootView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view4 = null;
                }
                Context context = view4.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (ScreenUtil.isNavigationBarExist((Activity) context)) {
                    View view5 = this.rootView;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    } else {
                        view2 = view5;
                    }
                    return DisplayUtil.getNavigationBarHeight(view2.getContext());
                }
            }
        }
        return 0;
    }

    private final int X() {
        int[] iArr = new int[2];
        EditText editText = this.primaryInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        editText.getLocationInWindow(iArr);
        int measuredWidth = iArr[0] + (editText.getMeasuredWidth() / 8);
        QLog.i("GuildFeedPublishLinkInsertPop", 1, "calPosY x=" + iArr[0] + " y=" + iArr[1] + " posX=" + measuredWidth);
        return measuredWidth;
    }

    private final void Y() {
        Object systemService = getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setText((ClipboardManager) systemService, null);
    }

    private final GuidePopBuilder.c Z() {
        EditText editText = this.primaryInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        return new GuidePopBuilder.c(editText, 0, X(), 0);
    }

    private final void a0(View parentView, View view, String url) {
        Map mutableMapOf;
        VideoReport.setPageId(parentView, this.config.getSourcePageId());
        VideoReport.setElementId(view, "em_sgrp_otherapp_video_pop_add");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_video_url", url));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, mutableMapOf);
    }

    private final void b0(View parentView, View view) {
        VideoReport.setPageId(parentView, this.config.getSourcePageId());
        VideoReport.setElementId(view, "em_sgrp_otherapp_video_pop_add");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    private final void c0() {
        com.tencent.mobileqq.guild.feed.video.g gVar;
        GuidePopBuilder config;
        for (com.tencent.mobileqq.guild.feed.video.f fVar : this.config.c()) {
            if (fVar instanceof com.tencent.mobileqq.guild.feed.video.g) {
                gVar = (com.tencent.mobileqq.guild.feed.video.g) fVar;
            } else {
                gVar = null;
            }
            if (gVar != null && (config = gVar.getConfig()) != null) {
                config.q(Z());
                config.l(this);
                config.k(ScreenUtil.SCREEN_WIDTH / 2);
                config.o(com.tencent.guild.aio.util.c.b(8));
            }
        }
        this.guideProcessor = new com.tencent.mobileqq.guild.feed.video.h(this.config.c());
    }

    private final void d0(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("weishi_comment_prefs_version", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "sp.edit()");
        this.mEditor = edit;
        int i3 = sharedPreferences.getInt("GroupSoftKeyboardHeight", R);
        this.mKeyBoardHeight = i3;
        QLog.d("GuildFeedPublishLinkInsertPop", 1, "initKeyBoardHeight mKeyBoardHeight=" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(GuildFeedPublishLinkInsertPop this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c0();
        com.tencent.mobileqq.guild.feed.video.h hVar = this$0.guideProcessor;
        if (hVar != null) {
            hVar.a(this$0.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        CharSequence trim;
        EditText editText = this.primaryInput;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) editText.getText().toString());
        String obj = trim.toString();
        CharacterCountEditText characterCountEditText = this.secondInput;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondInput");
            characterCountEditText = null;
        }
        String obj2 = characterCountEditText.getText().toString();
        QLog.i("GuildFeedPublishLinkInsertPop", 1, "onSubmitClick content=" + obj + " dsc=" + obj2);
        Iterator<T> it = this.config.c().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (((com.tencent.mobileqq.guild.feed.video.f) it.next()).match(obj)) {
                z16 = true;
            }
        }
        if (z16) {
            Function1<? super b, Unit> function1 = this.submitCallback;
            if (function1 != null) {
                function1.invoke(new b(obj, obj2, false, 4, null));
            }
            View view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
            TextView textView2 = this.commitBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commitBtn");
            } else {
                textView = textView2;
            }
            a0(view, textView, obj);
            return;
        }
        QQToast.makeText(getContext(), getContext().getString(R.string.f138680_8), 0).show();
    }

    private final void g0() {
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int i3 = this.mKeyBoardHeight;
        IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        layoutParams2.height = i3 + iQQGuildUIUtilApi.dp2px(207.0f, view3.getResources());
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view4;
        }
        view2.setLayoutParams(layoutParams2);
        getBehavior().setPeekHeight(layoutParams2.height);
    }

    private final void i0(boolean showTipIfNeed) {
        show();
        QLog.i("GuildFeedPublishLinkInsertPop", 1, "showDialogAndKeyboard showTipIfNeed=" + showTipIfNeed);
        View view = null;
        if (showTipIfNeed) {
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedPublishLinkInsertPop.j0(GuildFeedPublishLinkInsertPop.this);
                }
            }, 500L);
        }
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view3;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishLinkInsertPop.k0(GuildFeedPublishLinkInsertPop.this);
            }
        });
    }

    private final void initView(Context context) {
        boolean z16;
        View inflate = LayoutInflater.from(context).inflate(R.layout.eqd, (ViewGroup) new FrameLayout(context), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026meLayout(context), false)");
        this.rootView = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.f26380dd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.pop_title_tv)");
        TextView textView = (TextView) findViewById;
        this.titleTv = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        textView.setText(this.config.getPopTitleResId());
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.uxb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.et_link)");
        EditText editText = (EditText) findViewById2;
        this.primaryInput = editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        editText.setHint(this.config.getPrimaryInputHintRes());
        EditText editText2 = this.primaryInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText2 = null;
        }
        editText2.addTextChangedListener(new c());
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.uoo);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.dsc_tip)");
        TextView textView2 = (TextView) findViewById3;
        this.primaryInputDsc = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInputDsc");
            textView2 = null;
        }
        if (this.config.getPrimaryInputDesRes() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        textView2.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, textView2)) == null) {
            textView2.setVisibility(8);
        }
        if (this.config.getPrimaryInputDesRes() > 0) {
            TextView textView3 = this.primaryInputDsc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryInputDsc");
                textView3 = null;
            }
            textView3.setText(this.config.getPrimaryInputDesRes());
        }
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.uxc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.et_link_desc)");
        CharacterCountEditText characterCountEditText = (CharacterCountEditText) findViewById4;
        this.secondInput = characterCountEditText;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondInput");
            characterCountEditText = null;
        }
        Boolean valueOf2 = Boolean.valueOf(this.config.getShowSecondInput());
        characterCountEditText.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, characterCountEditText)) == null) {
            characterCountEditText.setVisibility(8);
        }
        CharacterCountEditText characterCountEditText2 = this.secondInput;
        if (characterCountEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondInput");
            characterCountEditText2 = null;
        }
        characterCountEditText2.setHint(this.config.getSecondInputHintRes());
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.f107736b8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.tv_ensure)");
        final TextView textView4 = (TextView) findViewById5;
        this.commitBtn = textView4;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commitBtn");
            textView4 = null;
        }
        final long j3 = 200;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.GuildFeedPublishLinkInsertPop$initView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                textView4.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.f0();
                final View view6 = textView4;
                view6.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.GuildFeedPublishLinkInsertPop$initView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view6.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view6 = null;
        }
        final View findViewById6 = view6.findViewById(R.id.f167033k60);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<View>(R.id.tv_cancel)");
        findViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.GuildFeedPublishLinkInsertPop$initView$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                Function1 function1;
                EventCollector.getInstance().onViewClickedBefore(it);
                findViewById6.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                function1 = this.cancelCallback;
                if (function1 != null) {
                    function1.invoke(Unit.INSTANCE);
                }
                this.dismiss();
                final View view7 = findViewById6;
                view7.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.GuildFeedPublishLinkInsertPop$initView$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view7.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        View view7 = this.rootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view7;
        }
        setContentView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(GuildFeedPublishLinkInsertPop this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c0();
        com.tencent.mobileqq.guild.feed.video.h hVar = this$0.guideProcessor;
        if (hVar != null) {
            hVar.a(this$0.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(GuildFeedPublishLinkInsertPop this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.primaryInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        this$0.mShowSoftInputRunnable = GuildFeedKeyboardUtils.b(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(boolean enable) {
        TextView textView = null;
        if (enable) {
            TextView textView2 = this.commitBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commitBtn");
                textView2 = null;
            }
            textView2.setAlpha(1.0f);
        } else {
            TextView textView3 = this.commitBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commitBtn");
                textView3 = null;
            }
            textView3.setAlpha(0.3f);
        }
        TextView textView4 = this.commitBtn;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commitBtn");
        } else {
            textView = textView4;
        }
        textView.setEnabled(enable);
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuidePopBuilder.b
    public void G0(@NotNull String contentStr) {
        Intrinsics.checkNotNullParameter(contentStr, "contentStr");
        com.tencent.mobileqq.guild.feed.video.h hVar = this.guideProcessor;
        if (hVar != null) {
            hVar.c();
        }
        EditText editText = this.primaryInput;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        editText.getText().clear();
        EditText editText3 = this.primaryInput;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
        } else {
            editText2 = editText3;
        }
        editText2.getText().append((CharSequence) contentStr);
        Y();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.tencent.mobileqq.guild.feed.video.h hVar = this.guideProcessor;
        if (hVar != null) {
            hVar.d();
        }
        EditText editText = this.primaryInput;
        View view = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        editText.setText((CharSequence) null);
        EditText editText2 = this.primaryInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText2 = null;
        }
        editText2.removeCallbacks(this.mShowSoftInputRunnable);
        m0(false);
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view2;
        }
        GuildFeedKeyboardUtils.a(view);
    }

    public final void l0(@NotNull b defaultInfo, @Nullable Function1<? super b, Unit> submitCallback, @Nullable Function1<? super Unit, Unit> cancelCallback) {
        Intrinsics.checkNotNullParameter(defaultInfo, "defaultInfo");
        EditText editText = this.primaryInput;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText = null;
        }
        editText.setText(defaultInfo.getContent());
        EditText editText2 = this.primaryInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("primaryInput");
            editText2 = null;
        }
        editText2.setSelection(defaultInfo.getContent().length());
        CharacterCountEditText characterCountEditText = this.secondInput;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondInput");
            characterCountEditText = null;
        }
        characterCountEditText.setText(defaultInfo.getDsc());
        i0(defaultInfo.getShowTipIfNeed());
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        TextView textView2 = this.commitBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commitBtn");
        } else {
            textView = textView2;
        }
        b0(view, textView);
        this.submitCallback = submitCallback;
        this.cancelCallback = cancelCallback;
    }

    public final void onResume() {
        QLog.i("GuildFeedPublishLinkInsertPop", 1, "onResume");
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishLinkInsertPop.e0(GuildFeedPublishLinkInsertPop.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.window.s.c
    public void onSoftKeyboardClosed() {
        QLog.i("GuildFeedPublishLinkInsertPop", 1, "onSoftKeyboardClosed");
    }

    @Override // com.tencent.mobileqq.guild.window.s.c
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        int W = W();
        int i3 = keyboardHeightInPx - W;
        QLog.d("GuildFeedPublishLinkInsertPop", 1, "onSoftKeyboardOpened keyboardHeightInPx=" + keyboardHeightInPx + " navigationBarHeight=" + W + " preKeyboardHeightInPx=" + this.mKeyBoardHeight + " finalKeyboardHeightInPx=" + i3);
        if (this.mKeyBoardHeight != i3) {
            this.mKeyBoardHeight = i3;
            g0();
            SharedPreferences.Editor editor = this.mEditor;
            SharedPreferences.Editor editor2 = null;
            if (editor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditor");
                editor = null;
            }
            editor.putInt("GroupSoftKeyboardHeight", i3);
            SharedPreferences.Editor editor3 = this.mEditor;
            if (editor3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditor");
            } else {
                editor2 = editor3;
            }
            editor2.commit();
        }
    }
}
