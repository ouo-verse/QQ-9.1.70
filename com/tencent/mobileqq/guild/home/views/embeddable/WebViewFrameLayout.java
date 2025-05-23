package com.tencent.mobileqq.guild.home.views.embeddable;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.FileReaderHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001FB'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u0011\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\b\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010!R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00107R\u0018\u0010@\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/e;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function0;", "", "onLoadFinish", "o", "", "url", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "p", "", "direction", "canScrollVertically", "a", "dX", "dY", "", "consumed", "c", "Landroid/content/Context;", "context", "t", "d", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "onScrollChangeListener", "e", "I", "currentScrollY", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "f", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingFrameLayout", "Landroid/view/TextureView;", h.F, "Landroid/view/TextureView;", "textureView", "i", "[I", RemoteWebViewEvent.SCROLL_VALUES, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cookie", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "Landroid/view/View;", "D", "Landroid/view/View;", "errorLayout", "E", "Z", "hasError", UserInfo.SEX_FEMALE, "Ljava/lang/String;", VasWebviewConstants.KEY_PAGE_URL, "G", "hasRenderServiceFailed", "H", "Landroidx/lifecycle/LifecycleOwner;", "attachedLifecycleOwner", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class WebViewFrameLayout extends FrameLayout implements e {

    /* renamed from: C */
    @Nullable
    private Function0<Unit> onLoadFinish;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View errorLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasError;

    /* renamed from: F */
    @Nullable
    private String pageUrl;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasRenderServiceFailed;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LifecycleOwner attachedLifecycleOwner;

    /* renamed from: d, reason: from kotlin metadata */
    @Nullable
    private GuildHomeMainProcessWebView.a onScrollChangeListener;

    /* renamed from: e, reason: from kotlin metadata */
    private int currentScrollY;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final ScanningLightView loadingFrameLayout;

    /* renamed from: h */
    @NotNull
    private final TextureView textureView;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private int[] com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String;

    /* renamed from: m */
    private int cookie;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayout$a", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$b;", "", "url", "", "canScrolls", "", "b", "", "code", "msg", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildHomeMainProcessWebView.b {

        /* renamed from: b */
        final /* synthetic */ GuildHomeMainProcessWebView f225640b;

        /* renamed from: c */
        final /* synthetic */ Context f225641c;

        a(GuildHomeMainProcessWebView guildHomeMainProcessWebView, Context context) {
            this.f225640b = guildHomeMainProcessWebView;
            this.f225641c = context;
        }

        @Override // com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView.b
        public void a(@Nullable String url, int code, @NotNull String msg2) {
            Lifecycle lifecycle;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Logger logger = Logger.f235387a;
            GuildHomeMainProcessWebView guildHomeMainProcessWebView = this.f225640b;
            logger.d().i("WebViewFrameLayout", 1, "onError[" + guildHomeMainProcessWebView.f() + "](" + code + ", " + msg2 + ") url " + url);
            LifecycleOwner lifecycleOwner = WebViewFrameLayout.this.attachedLifecycleOwner;
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED) && Intrinsics.areEqual(msg2, "onServiceDisconnected")) {
                    WebViewFrameLayout.this.hasRenderServiceFailed = true;
                } else {
                    WebViewFrameLayout.this.t(this.f225641c);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView.b
        public void b(@Nullable String url, @NotNull int[] canScrolls) {
            Intrinsics.checkNotNullParameter(canScrolls, "canScrolls");
            Function0 function0 = WebViewFrameLayout.this.onLoadFinish;
            if (function0 != null) {
                function0.invoke();
            }
            TraceUtils.j("Guild.HomePage.Fragment.OpenUrl." + this.f225640b.f() + "/" + this.f225640b.e(), WebViewFrameLayout.this.cookie);
            Logger logger = Logger.f235387a;
            GuildHomeMainProcessWebView guildHomeMainProcessWebView = this.f225640b;
            Logger.a d16 = logger.d();
            String f16 = guildHomeMainProcessWebView.f();
            String arrays = Arrays.toString(canScrolls);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            d16.i("WebViewFrameLayout", 1, "loadSucceed[" + f16 + "] " + arrays + " url " + url);
            this.f225640b.setOpaque(true);
            this.f225640b.setAlpha(1.0f);
            ArraysKt___ArraysJvmKt.copyInto$default(canScrolls, WebViewFrameLayout.this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String, 4, 0, 0, 12, (Object) null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/views/embeddable/WebViewFrameLayout$c", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "Landroid/view/View;", "v", "", RemoteWebViewEvent.SCROLL_VALUES, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements GuildHomeMainProcessWebView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView.a
        public void a(@Nullable View v3, @NotNull int[] r36) {
            Intrinsics.checkNotNullParameter(r36, "scrollValues");
            if (r36.length < 8) {
                return;
            }
            WebViewFrameLayout.this.currentScrollY = r36[1];
            WebViewFrameLayout.this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String = r36;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WebViewFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void r(WebViewFrameLayout webViewFrameLayout, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        webViewFrameLayout.q(str, z16);
    }

    private final GuildHomeMainProcessWebView.a s() {
        return new c();
    }

    public static final void u(WebViewFrameLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeView(this$0.errorLayout);
        this$0.textureView.setOpaque(false);
        this$0.textureView.setAlpha(0.0f);
        String str = this$0.pageUrl;
        if (str == null) {
            str = "";
        }
        this$0.q(str, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean a(int direction) {
        if (this.hasError) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            String arrays = Arrays.toString(this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            Log.d("WebViewFrameLayout", "isHorizontalDragging(" + direction + ") " + arrays);
        }
        if (direction < 0) {
            if (this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String[7] != 1) {
                return false;
            }
            return true;
        }
        if (direction <= 0 || this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String[6] != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public void c(int dX, int dY, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        TextureView textureView = this.textureView;
        if (textureView instanceof GuildHomeMainProcessWebView) {
            ((GuildHomeMainProcessWebView) textureView).c(dX, dY, consumed);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // android.view.View, com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean canScrollVertically(int direction) {
        if (this.hasError) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            String arrays = Arrays.toString(this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            Log.d("WebViewFrameLayout", "canScrollVertically(" + direction + ") " + arrays);
        }
        if (direction > 0) {
            if (this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String[5] != 1) {
                return false;
            }
            return true;
        }
        if (direction >= 0 || this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String[4] != 1) {
            return false;
        }
        return true;
    }

    public final void o(@NotNull Function0<Unit> onLoadFinish) {
        Intrinsics.checkNotNullParameter(onLoadFinish, "onLoadFinish");
        this.onLoadFinish = onLoadFinish;
    }

    public final void p(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        TextureView textureView = this.textureView;
        if (textureView instanceof GuildHomeMainProcessWebView) {
            ((GuildHomeMainProcessWebView) textureView).d(lifecycleOwner);
            this.attachedLifecycleOwner = lifecycleOwner;
            lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.WebViewFrameLayout$attachLifecycleOwner$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                    boolean z16;
                    String str;
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_RESUME) {
                        z16 = WebViewFrameLayout.this.hasRenderServiceFailed;
                        if (z16) {
                            ((GuildHomeMainProcessWebView) WebViewFrameLayout.this.textureView).setOpaque(false);
                            ((GuildHomeMainProcessWebView) WebViewFrameLayout.this.textureView).setAlpha(0.0f);
                            WebViewFrameLayout webViewFrameLayout = WebViewFrameLayout.this;
                            str = webViewFrameLayout.pageUrl;
                            if (str == null) {
                                str = "";
                            }
                            webViewFrameLayout.q(str, true);
                            WebViewFrameLayout.this.hasRenderServiceFailed = false;
                            return;
                        }
                        return;
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        source.getLifecycle().removeObserver(this);
                        WebViewFrameLayout.this.attachedLifecycleOwner = null;
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void q(@NotNull String url, boolean z16) {
        Intrinsics.checkNotNullParameter(url, "url");
        TextureView textureView = this.textureView;
        if (textureView instanceof GuildHomeMainProcessWebView) {
            this.hasError = false;
            this.pageUrl = url;
            this.cookie = TraceUtils.g("Guild.HomePage.Fragment.OpenUrl." + ((GuildHomeMainProcessWebView) textureView).f() + "/" + url);
            Logger.f235387a.d().i("WebViewFrameLayout", 1, "start navigateUrl[" + ((GuildHomeMainProcessWebView) this.textureView).f() + "] url=" + url);
            ((GuildHomeMainProcessWebView) this.textureView).h(url, Boolean.valueOf(z16));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void t(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.errorLayout == null) {
            this.errorLayout = new QUIEmptyState.Builder(context).setImageType(13).setTitle("\u9875\u9762\u4e0d\u53ef\u7528").setButton("\u91cd\u8bd5\u52a0\u8f7d", new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WebViewFrameLayout.u(WebViewFrameLayout.this, view);
                }
            }).build();
        }
        View view = this.errorLayout;
        if (view == null) {
            return;
        }
        boolean z16 = true;
        this.hasError = true;
        if (indexOfChild(view) == -1) {
            z16 = false;
        }
        if (!z16) {
            addView(view);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WebViewFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ WebViewFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WebViewFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onScrollChangeListener = s();
        this.com.tencent.mobileqq.remoteweb.RemoteWebViewEvent.SCROLL_VALUES java.lang.String = new int[8];
        ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
        this.loadingFrameLayout = scanningLightView;
        scanningLightView.setScaleType(ImageView.ScaleType.FIT_START);
        scanningLightView.setImageResource(R.drawable.guild_home_sub_fragment_loading);
        GuildHomeMainProcessWebView guildHomeMainProcessWebView = new GuildHomeMainProcessWebView(context, attributeSet);
        guildHomeMainProcessWebView.setOpaque(false);
        guildHomeMainProcessWebView.setAlpha(0.0f);
        guildHomeMainProcessWebView.setStatusListener(new a(guildHomeMainProcessWebView, context));
        this.textureView = guildHomeMainProcessWebView;
        guildHomeMainProcessWebView.setScrollListener(this.onScrollChangeListener);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        addView(scanningLightView, new FrameLayout.LayoutParams(-1, -1, 17));
        addView(guildHomeMainProcessWebView, layoutParams);
    }
}
