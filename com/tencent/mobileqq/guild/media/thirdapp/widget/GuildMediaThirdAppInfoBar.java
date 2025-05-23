package com.tencent.mobileqq.guild.media.thirdapp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b\u001f\u0010#B#\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b\u001f\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppInfoBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "appInfo", "", "b", "Lcom/tencent/mobileqq/guild/media/thirdapp/e;", "appPreloadInfo", "c", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/g;", "listener", "setThirdAppClickListener", "d", "e", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/g;", "mThirdAppClickListener", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "f", "mIconLayout", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "mIconView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mNameView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaThirdAppInfoBar extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mThirdAppClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mIconLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mNameView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppInfoBar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(getContext(), R.layout.ez6, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026edia_third_app_bar, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f96575i2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026_info_icon_radius_layout)");
        this.mIconLayout = findViewById;
        View findViewById2 = inflate.findViewById(R.id.f96565i1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.third_app_info_icon)");
        this.mIconView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f96595i4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.third_app_info_name)");
        this.mNameView = (TextView) findViewById3;
        kotlin.b.b(this, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppInfoBar.1
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
                g gVar = GuildMediaThirdAppInfoBar.this.mThirdAppClickListener;
                if (gVar != null) {
                    gVar.l5();
                }
            }
        });
    }

    private final void b(IGProLobbyAppInfo appInfo) {
        String str;
        TextView textView = this.mNameView;
        if (!TextUtils.isEmpty(appInfo.getAppName())) {
            str = appInfo.getAppName();
        } else {
            str = "\u7b2c\u4e09\u65b9\u5e94\u7528";
        }
        textView.setText(str);
        if (!TextUtils.isEmpty(appInfo.getIconUrl())) {
            b.Companion companion = com.tencent.mobileqq.guild.discover.b.INSTANCE;
            ImageView imageView = this.mIconView;
            String iconUrl = appInfo.getIconUrl();
            Intrinsics.checkNotNullExpressionValue(iconUrl, "appInfo.iconUrl");
            b.Companion.g(companion, imageView, iconUrl, null, 4, null);
            return;
        }
        this.mIconView.setImageResource(R.drawable.guild_media_third_app_default_icon);
    }

    private final void c(com.tencent.mobileqq.guild.media.thirdapp.e appPreloadInfo) {
        String str;
        TextView textView = this.mNameView;
        if (!TextUtils.isEmpty(appPreloadInfo.getTitle())) {
            str = appPreloadInfo.getTitle();
        } else {
            str = "\u7b2c\u4e09\u65b9\u5e94\u7528";
        }
        textView.setText(str);
        if (!TextUtils.isEmpty(appPreloadInfo.getIconUrl())) {
            b.Companion.g(com.tencent.mobileqq.guild.discover.b.INSTANCE, this.mIconView, appPreloadInfo.getIconUrl(), null, 4, null);
        } else {
            this.mIconView.setImageResource(R.drawable.guild_media_third_app_default_icon);
        }
    }

    public final void d(@NotNull IGProLobbyAppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        b(appInfo);
    }

    public final void e(@NotNull com.tencent.mobileqq.guild.media.thirdapp.e appPreloadInfo) {
        Intrinsics.checkNotNullParameter(appPreloadInfo, "appPreloadInfo");
        c(appPreloadInfo);
    }

    public final void setThirdAppClickListener(@NotNull g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mThirdAppClickListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppInfoBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(getContext(), R.layout.ez6, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026edia_third_app_bar, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f96575i2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026_info_icon_radius_layout)");
        this.mIconLayout = findViewById;
        View findViewById2 = inflate.findViewById(R.id.f96565i1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.third_app_info_icon)");
        this.mIconView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f96595i4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.third_app_info_name)");
        this.mNameView = (TextView) findViewById3;
        kotlin.b.b(this, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppInfoBar.1
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
                g gVar = GuildMediaThirdAppInfoBar.this.mThirdAppClickListener;
                if (gVar != null) {
                    gVar.l5();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppInfoBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(getContext(), R.layout.ez6, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026edia_third_app_bar, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f96575i2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026_info_icon_radius_layout)");
        this.mIconLayout = findViewById;
        View findViewById2 = inflate.findViewById(R.id.f96565i1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.third_app_info_icon)");
        this.mIconView = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f96595i4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.third_app_info_name)");
        this.mNameView = (TextView) findViewById3;
        kotlin.b.b(this, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppInfoBar.1
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
                g gVar = GuildMediaThirdAppInfoBar.this.mThirdAppClickListener;
                if (gVar != null) {
                    gVar.l5();
                }
            }
        });
    }
}
