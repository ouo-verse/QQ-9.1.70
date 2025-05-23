package com.tencent.timi.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qqlive.common.widget.RCFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00011B)\b\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0004R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00062"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/LiveWebViewContainer;", "Lcom/tencent/qqlive/common/widget/RCFrameLayout;", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "", "f", "Landroid/graphics/drawable/Drawable;", "drawable", "setWebBackground", "", "title", "setTitle", "url", "e", "i", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "webContainer", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/ui/TouchWebView;", tl.h.F, "()Lcom/tencent/biz/ui/TouchWebView;", "Landroid/view/View;", "D", "Landroid/view/View;", "titleLayout", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleView", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "closeView", "Lcom/tencent/image/URLImageView;", "G", "Lcom/tencent/image/URLImageView;", "loadingView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveWebViewContainer extends RCFrameLayout {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TouchWebView webView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View titleLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView titleView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RoundCornerImageView closeView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private URLImageView loadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FrameLayout webContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/LiveWebViewContainer$a;", "", "Landroid/app/Activity;", "hostActivity", "", WebAccelerateHelper.KEY_PRELOAD_URL, "", "transparentBg", "Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/LiveWebView;", "a", "DARK_LOADING_URL", "Ljava/lang/String;", "LIGHT_LOADING_URL", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.livewebdialog.LiveWebViewContainer$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final LiveWebView a(@Nullable Activity hostActivity, @Nullable String preloadUrl, boolean transparentBg) {
            if (hostActivity == null) {
                return null;
            }
            LiveWebView liveWebView = new LiveWebView(hostActivity);
            liveWebView.t(hostActivity, com.tencent.mobileqq.qqlive.utils.g.a());
            liveWebView.setClickable(true);
            if (transparentBg) {
                liveWebView.setBackgroundColor(0);
            }
            if (!TextUtils.isEmpty(preloadUrl)) {
                liveWebView.loadUrl(preloadUrl);
            }
            return liveWebView;
        }

        Companion() {
        }
    }

    @JvmOverloads
    public LiveWebViewContainer(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmStatic
    @Nullable
    public static final LiveWebView g(@Nullable Activity activity, @Nullable String str, boolean z16) {
        return INSTANCE.a(activity, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void e(@NotNull String url) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        String queryParameter = Uri.parse(url).getQueryParameter(ToastView.ICON_LOADING);
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        if (queryParameter != null && queryParameter.compareTo(MiniAppConst.MENU_STYLE_DARK) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "https://downv6.qq.com/video_story/qcircle/feed/dark_loading.png";
        } else {
            str = "https://downv6.qq.com/video_story/qcircle/feed/light_loading.png";
        }
        FrameLayout frameLayout = this.webContainer;
        Intrinsics.checkNotNull(frameLayout);
        URLImageView uRLImageView = new URLImageView(frameLayout.getContext());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026RANSPARENT)\n            }");
        com.tencent.timi.game.utils.b.g(uRLImageView, str, obtain);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(100.0f), ViewUtils.dpToPx(100.0f));
        layoutParams.gravity = 17;
        uRLImageView.setLayoutParams(layoutParams);
        FrameLayout frameLayout2 = this.webContainer;
        if (frameLayout2 != null) {
            frameLayout2.addView(uRLImageView);
        }
        this.loadingView = uRLImageView;
    }

    public final void f(@Nullable TouchWebView webView) {
        FrameLayout frameLayout = this.webContainer;
        if (frameLayout != null) {
            frameLayout.addView(webView);
        }
        this.webView = webView;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final TouchWebView getWebView() {
        return this.webView;
    }

    public final void i() {
        URLImageView uRLImageView = this.loadingView;
        if (uRLImageView != null) {
            uRLImageView.setVisibility(8);
        }
    }

    public final void setTitle(@Nullable String title) {
        if (!TextUtils.isEmpty(title)) {
            this.titleLayout = View.inflate(getContext(), R.layout.hvf, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, q.a(getContext(), 32.0f));
            if (this.titleLayout == null) {
                return;
            }
            layoutParams.topMargin = q.a(getContext(), 12.0f);
            View view = this.titleLayout;
            Intrinsics.checkNotNull(view);
            this.titleView = (TextView) view.findViewById(R.id.jq_);
            View view2 = this.titleLayout;
            Intrinsics.checkNotNull(view2);
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) view2.findViewById(R.id.u0f);
            this.closeView = roundCornerImageView;
            Intrinsics.checkNotNull(roundCornerImageView);
            roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.livewebdialog.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveWebViewContainer.j(view3);
                }
            });
            View view3 = this.titleLayout;
            Intrinsics.checkNotNull(view3);
            view3.setLayoutParams(layoutParams);
            View view4 = this.titleLayout;
            Intrinsics.checkNotNull(view4);
            view4.setVisibility(0);
            TextView textView = this.titleView;
            Intrinsics.checkNotNull(textView);
            textView.setText(title);
            FrameLayout frameLayout = this.webContainer;
            Intrinsics.checkNotNull(frameLayout);
            frameLayout.addView(this.titleLayout);
        }
    }

    public final void setWebBackground(@Nullable Drawable drawable) {
        FrameLayout frameLayout = this.webContainer;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setBackgroundDrawable(drawable);
        setBackground(drawable);
    }

    @JvmOverloads
    public LiveWebViewContainer(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LiveWebViewContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? -1 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveWebViewContainer(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNull(context);
        View.inflate(context, R.layout.hve, this);
        this.webContainer = (FrameLayout) findViewById(R.id.l1q);
    }
}
