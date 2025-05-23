package com.tencent.mobileqq.guild.discoveryv2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import com.tencent.xweb.FileReaderHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001HB'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u00020\r\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u001a\u0010\u000b\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bJ&\u0010\u000e\u001a\u00020\u00052\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\fJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\rH\u0016J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\"R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R0\u00105\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00107R\u0018\u0010@\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryWebViewFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/e;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "u", "", "v", "r", "Lkotlin/Function1;", "", "onLoadFinish", "p", "Lkotlin/Function3;", "", "o", "url", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, ReportConstant.COSTREPORT_PREFIX, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "direction", "canScrollVertically", "a", "dX", "dY", "", "consumed", "c", "d", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "onScrollChangeListener", "e", "I", "currentScrollY", "Landroid/view/View;", "f", "Landroid/view/View;", "loadingFrameLayout", "Landroid/view/TextureView;", h.F, "Landroid/view/TextureView;", "textureView", "i", "[I", RemoteWebViewEvent.SCROLL_VALUES, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cookie", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "D", "Lkotlin/jvm/functions/Function3;", "onLoadFailed", "E", "Z", "hasError", UserInfo.SEX_FEMALE, "Ljava/lang/String;", VasWebviewConstants.KEY_PAGE_URL, "G", "hasRenderServiceFailed", "H", "Landroidx/lifecycle/LifecycleOwner;", "attachedLifecycleOwner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DiscoveryWebViewFrameLayout extends FrameLayout implements com.tencent.mobileqq.guild.home.views.embeddable.e {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> onLoadFinish;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function3<? super String, ? super Integer, ? super String, Unit> onLoadFailed;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasError;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String pageUrl;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasRenderServiceFailed;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LifecycleOwner attachedLifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHomeMainProcessWebView.a onScrollChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentScrollY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View loadingFrameLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextureView textureView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] scrollValues;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int cookie;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryWebViewFrameLayout$a", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$b;", "", "url", "", "canScrolls", "", "b", "", "code", "msg", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildHomeMainProcessWebView.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeMainProcessWebView f217822b;

        a(GuildHomeMainProcessWebView guildHomeMainProcessWebView) {
            this.f217822b = guildHomeMainProcessWebView;
        }

        @Override // com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView.b
        public void a(@Nullable String url, int code, @NotNull String msg2) {
            Lifecycle lifecycle;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Logger logger = Logger.f235387a;
            GuildHomeMainProcessWebView guildHomeMainProcessWebView = this.f217822b;
            logger.d().i("DiscoveryWebViewFrameLayout", 1, "onError[" + guildHomeMainProcessWebView.f() + "](" + code + ", " + msg2 + ") url " + url);
            LifecycleOwner lifecycleOwner = DiscoveryWebViewFrameLayout.this.attachedLifecycleOwner;
            if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED) || !Intrinsics.areEqual(msg2, "onServiceDisconnected")) {
                    Function3 function3 = DiscoveryWebViewFrameLayout.this.onLoadFailed;
                    if (function3 != null) {
                        if (url == null) {
                            url = "";
                        }
                        function3.invoke(url, Integer.valueOf(code), msg2);
                        return;
                    }
                    return;
                }
                DiscoveryWebViewFrameLayout.this.hasRenderServiceFailed = true;
            }
        }

        @Override // com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView.b
        public void b(@Nullable String url, @NotNull int[] canScrolls) {
            String str;
            Intrinsics.checkNotNullParameter(canScrolls, "canScrolls");
            Function1 function1 = DiscoveryWebViewFrameLayout.this.onLoadFinish;
            if (function1 != null) {
                if (url == null) {
                    str = "";
                } else {
                    str = url;
                }
                function1.invoke(str);
            }
            TraceUtils.j("Guild.HomePage.Fragment.OpenUrl." + this.f217822b.f() + "/" + this.f217822b.e(), DiscoveryWebViewFrameLayout.this.cookie);
            Logger logger = Logger.f235387a;
            GuildHomeMainProcessWebView guildHomeMainProcessWebView = this.f217822b;
            Logger.a d16 = logger.d();
            String f16 = guildHomeMainProcessWebView.f();
            String arrays = Arrays.toString(canScrolls);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            d16.i("DiscoveryWebViewFrameLayout", 1, "loadSucceed[" + f16 + "] url " + url + ", " + arrays);
            DiscoveryWebViewFrameLayout.this.r();
            ArraysKt___ArraysJvmKt.copyInto$default(canScrolls, DiscoveryWebViewFrameLayout.this.scrollValues, 4, 0, 0, 12, (Object) null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/widget/DiscoveryWebViewFrameLayout$c", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "Landroid/view/View;", "v", "", RemoteWebViewEvent.SCROLL_VALUES, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements GuildHomeMainProcessWebView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView.a
        public void a(@Nullable View v3, @NotNull int[] scrollValues) {
            Intrinsics.checkNotNullParameter(scrollValues, "scrollValues");
            if (scrollValues.length < 8) {
                return;
            }
            DiscoveryWebViewFrameLayout.this.currentScrollY = scrollValues[1];
            DiscoveryWebViewFrameLayout.this.scrollValues = scrollValues;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryWebViewFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void t(DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        discoveryWebViewFrameLayout.s(str, z16);
    }

    private final GuildHomeMainProcessWebView.a u() {
        return new c();
    }

    @Override // com.tencent.mobileqq.guild.home.views.embeddable.e
    public boolean a(int direction) {
        if (this.hasError) {
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            String arrays = Arrays.toString(this.scrollValues);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            Log.d("DiscoveryWebViewFrameLayout", "isHorizontalDragging(" + direction + ") " + arrays);
        }
        if (direction < 0) {
            if (this.scrollValues[7] != 1) {
                return false;
            }
            return true;
        }
        if (direction <= 0 || this.scrollValues[6] != 1) {
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
            String arrays = Arrays.toString(this.scrollValues);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            Log.d("DiscoveryWebViewFrameLayout", "canScrollVertically(" + direction + ") " + arrays);
        }
        if (direction > 0) {
            if (this.scrollValues[5] != 1) {
                return false;
            }
            return true;
        }
        if (direction >= 0 || this.scrollValues[4] != 1) {
            return false;
        }
        return true;
    }

    public final void o(@NotNull Function3<? super String, ? super Integer, ? super String, Unit> onLoadFinish) {
        Intrinsics.checkNotNullParameter(onLoadFinish, "onLoadFinish");
        this.onLoadFailed = onLoadFinish;
    }

    public final void p(@NotNull Function1<? super String, Unit> onLoadFinish) {
        Intrinsics.checkNotNullParameter(onLoadFinish, "onLoadFinish");
        this.onLoadFinish = onLoadFinish;
    }

    public final void q(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        TextureView textureView = this.textureView;
        if (textureView instanceof GuildHomeMainProcessWebView) {
            ((GuildHomeMainProcessWebView) textureView).d(lifecycleOwner);
            this.attachedLifecycleOwner = lifecycleOwner;
            lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.discoveryv2.widget.DiscoveryWebViewFrameLayout$attachLifecycleOwner$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                    boolean z16;
                    String str;
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == Lifecycle.Event.ON_RESUME) {
                        z16 = DiscoveryWebViewFrameLayout.this.hasRenderServiceFailed;
                        if (z16) {
                            ((GuildHomeMainProcessWebView) DiscoveryWebViewFrameLayout.this.textureView).setOpaque(false);
                            ((GuildHomeMainProcessWebView) DiscoveryWebViewFrameLayout.this.textureView).setAlpha(0.0f);
                            DiscoveryWebViewFrameLayout discoveryWebViewFrameLayout = DiscoveryWebViewFrameLayout.this;
                            str = discoveryWebViewFrameLayout.pageUrl;
                            if (str == null) {
                                str = "";
                            }
                            discoveryWebViewFrameLayout.s(str, true);
                            DiscoveryWebViewFrameLayout.this.hasRenderServiceFailed = false;
                            return;
                        }
                        return;
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        source.getLifecycle().removeObserver(this);
                        DiscoveryWebViewFrameLayout.this.attachedLifecycleOwner = null;
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void r() {
        this.textureView.setOpaque(true);
        this.textureView.setAlpha(1.0f);
    }

    public final void s(@NotNull String url, boolean force) {
        Intrinsics.checkNotNullParameter(url, "url");
        TextureView textureView = this.textureView;
        if (textureView instanceof GuildHomeMainProcessWebView) {
            this.hasError = false;
            this.pageUrl = url;
            this.cookie = TraceUtils.g("Guild.HomePage.Fragment.OpenUrl." + ((GuildHomeMainProcessWebView) textureView).f() + "/" + url);
            Logger.f235387a.d().i("DiscoveryWebViewFrameLayout", 1, "start navigateUrl[" + ((GuildHomeMainProcessWebView) this.textureView).f() + "] url=" + url);
            ((GuildHomeMainProcessWebView) this.textureView).h(url, Boolean.valueOf(force));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void v() {
        this.textureView.setOpaque(false);
        this.textureView.setAlpha(0.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryWebViewFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DiscoveryWebViewFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryWebViewFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onScrollChangeListener = u();
        this.scrollValues = new int[8];
        View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(context, false);
        Intrinsics.checkNotNullExpressionValue(loadingDialogTipsRight, "getLoadingDialogTipsRight(context, false)");
        this.loadingFrameLayout = loadingDialogTipsRight;
        GuildHomeMainProcessWebView guildHomeMainProcessWebView = new GuildHomeMainProcessWebView(context, attributeSet);
        guildHomeMainProcessWebView.setStatusListener(new a(guildHomeMainProcessWebView));
        this.textureView = guildHomeMainProcessWebView;
        v();
        guildHomeMainProcessWebView.setScrollListener(this.onScrollChangeListener);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        layoutParams.setMargins(0, 0, 0, QQGuildUIUtil.f(54.0f));
        addView(loadingDialogTipsRight, layoutParams);
        addView(guildHomeMainProcessWebView, new FrameLayout.LayoutParams(-1, -1, 17));
    }
}
