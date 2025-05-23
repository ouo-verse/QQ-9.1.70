package com.tencent.mobileqq.qqnt.videoplay.api.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 E2\u00020\u0001:\u0002\u0015\u0019B/\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u000eR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010$R\u0016\u0010&\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010$R\u001c\u0010)\u001a\n '*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010,R\u0014\u00100\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00102R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00102R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R$\u0010@\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b/\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel;", "", "", "f", "", "g", "millis", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "dp", "Landroid/content/res/Resources;", "res", "", "e", "", "k", "", "isMute", "i", "l", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/tencent/mobileqq/qqnt/videoplay/player/a;", "b", "Lcom/tencent/mobileqq/qqnt/videoplay/player/a;", "playProxy", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel$b;", "d", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel$b;", "listener", "Z", "mIsMute", "isProgressCancelled", "kotlin.jvm.PlatformType", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/widget/RelativeLayout;", h.F, "Landroid/widget/RelativeLayout;", "videoMuteSwitchRootBar", "videoMuteSwitchDisplayBar", "j", "videoMuteBar", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "videoMuteDisplay", "videoMuteSwitchControl", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "videoTimeLeft", "Lkotlinx/coroutines/Job;", DomainData.DOMAIN_NAME, "Lkotlinx/coroutines/Job;", "updateTimeJob", "value", "getVisible", "()Z", "(Z)V", NodeProps.VISIBLE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/qqnt/videoplay/player/a;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel$b;)V", "o", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TimeAndMutePanel {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope coroutineScope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqnt.videoplay.player.a playProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup parent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMute;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isProgressCancelled;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Resources resources;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout videoMuteSwitchRootBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout videoMuteSwitchDisplayBar;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout videoMuteBar;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView videoMuteDisplay;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView videoMuteSwitchControl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView videoTimeLeft;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job updateTimeJob;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel$a;", "", "", "DEFAULT_TIME", "Ljava/lang/String;", "", "MUTE_BAR_HEIGHT", UserInfo.SEX_FEMALE, "MUTE_BAR_WIDTH", "MUTE_DISPLAY_MARGIN", "ROOT_BAR_HEIGHT", "ROOT_BAR_LEFT_MARGIN", "ROOT_BAR_WIDTH", "ROOT_PADDING", "TEXT_SIZE", "TIME_LEFT_HEIGHT", "TIME_LEFT_MARGIN", "TIME_LEFT_WIDTH", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.api.component.TimeAndMutePanel$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/TimeAndMutePanel$b;", "", "", "mute", "", "a", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(boolean mute);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TimeAndMutePanel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull com.tencent.mobileqq.qqnt.videoplay.player.a playProxy, @NotNull ViewGroup parent, @NotNull b listener) {
        Resources resources;
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(playProxy, "playProxy");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, coroutineScope, playProxy, parent, listener);
            return;
        }
        this.coroutineScope = coroutineScope;
        this.playProxy = playProxy;
        this.parent = parent;
        this.listener = listener;
        this.mIsMute = true;
        Resources resources2 = context.getResources();
        this.resources = resources2;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.videoMuteSwitchRootBar = relativeLayout;
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        int e16 = e(76.0f, resources2);
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e16, e(32.0f, resources2));
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        layoutParams.leftMargin = e(5.5f, resources2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        parent.addView(relativeLayout, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        Resources resources3 = relativeLayout2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources3, "resources");
        int e17 = e(8.0f, resources3);
        relativeLayout2.setPadding(e17, e17, e17, e17);
        this.videoMuteSwitchDisplayBar = relativeLayout2;
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        int e18 = e(76.0f, resources2);
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        relativeLayout.addView(relativeLayout2, new FrameLayout.LayoutParams(e18, e(32.0f, resources2)));
        RelativeLayout relativeLayout3 = new RelativeLayout(context);
        this.videoMuteBar = relativeLayout3;
        relativeLayout3.setBackgroundResource(R.drawable.qq_richmedia_aio_video_play_controller_mute_bg);
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        int e19 = e(60.0f, resources2);
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        relativeLayout2.addView(relativeLayout3, new FrameLayout.LayoutParams(e19, e(16.0f, resources2)));
        TextView textView = new TextView(context);
        textView.setTextSize(1, 12.0f);
        textView.setGravity(16);
        textView.setIncludeFontPadding(false);
        textView.setText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT);
        textView.setTextColor(-1);
        this.videoTimeLeft = textView;
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        int e26 = e(34.0f, resources2);
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(e26, e(16.0f, resources2));
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        layoutParams2.leftMargin = e(5.0f, resources2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        relativeLayout3.addView(textView, layoutParams2);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.kvc);
        imageView.setSelected(this.mIsMute);
        this.videoMuteDisplay = imageView;
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(e(16.0f, resources2), -1);
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        layoutParams3.rightMargin = e(5.0f, resources2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        relativeLayout3.addView(imageView, layoutParams3);
        final ImageView imageView2 = new ImageView(context);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqnt.videoplay.api.component.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeAndMutePanel.h(TimeAndMutePanel.this, imageView2, view);
            }
        });
        imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.kvb));
        Resources resources4 = imageView2.getResources();
        Intrinsics.checkNotNullExpressionValue(resources4, "resources");
        int e27 = e(8.0f, resources4);
        imageView2.setPadding(e27, e27, e27, e27);
        if (this.mIsMute) {
            resources = imageView2.getResources();
            i3 = R.string.zif;
        } else {
            resources = imageView2.getResources();
            i3 = R.string.f169692j1;
        }
        imageView2.setContentDescription(resources.getString(i3));
        this.videoMuteSwitchControl = imageView2;
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        int e28 = e(76.0f, resources2);
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        relativeLayout.addView(imageView2, new FrameLayout.LayoutParams(e28, e(32.0f, resources2)));
    }

    private final int e(float dp5, Resources res) {
        boolean z16;
        if (dp5 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return (int) ((dp5 * res.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        return m(g());
    }

    private final long g() {
        return this.playProxy.getVideoDurationMs() - this.playProxy.getCurrentPositionMs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TimeAndMutePanel this$0, ImageView this_apply, View view) {
        Resources resources;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        boolean z16 = !this$0.mIsMute;
        this$0.mIsMute = z16;
        this$0.listener.a(z16);
        this$0.videoMuteDisplay.setSelected(this$0.mIsMute);
        if (this$0.mIsMute) {
            resources = this_apply.getResources();
            i3 = R.string.zif;
        } else {
            resources = this_apply.getResources();
            i3 = R.string.f169692j1;
        }
        this_apply.setContentDescription(resources.getString(i3));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String m(long millis) {
        int i3 = ((int) millis) / 1000;
        if (i3 <= 0) {
            return QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
        }
        int i16 = i3 % 60;
        int i17 = (i3 / 60) % 60;
        int i18 = i3 / 3600;
        if (i18 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i17), Integer.valueOf(i16)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    public final void i(boolean isMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isMute);
        } else {
            this.mIsMute = isMute;
            this.videoMuteDisplay.setSelected(isMute);
        }
    }

    public final void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else if (!z16) {
            this.videoMuteSwitchRootBar.setVisibility(8);
        } else {
            this.videoMuteSwitchRootBar.setVisibility(0);
        }
    }

    public final void k() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        j(true);
        this.isProgressCancelled = false;
        if (this.updateTimeJob == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getMain(), null, new TimeAndMutePanel$startUpdatingTime$1(this, null), 2, null);
            this.updateTimeJob = launch$default;
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.isProgressCancelled = true;
        Job job = this.updateTimeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.updateTimeJob = null;
    }
}
