package com.tencent.mobileqq.guild.discovery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.widget.GuildMineLightView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryLoadingView;", "Landroid/widget/FrameLayout;", "", "layoutResId", "", "a", "", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryLoadingView$GLightLoadingType;", "data", "c", "d", "e", "b", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Z", "openLight", "Lcom/tencent/mobileqq/guild/discover/widget/GuildMineLightView;", "f", "Lcom/tencent/mobileqq/guild/discover/widget/GuildMineLightView;", "lightView", tl.h.F, "I", "itemOffset", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GLightLoadingType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GDiscoveryLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean openLight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMineLightView lightView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int itemOffset;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryLoadingView$GLightLoadingType;", "", "", "layoutResId", "I", "getLayoutResId", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "TYPE_DISCOVERY_MINE", "TYPE_DISCOVERY_MINE_DETAIL", "TYPE_DISCOVERY_RECOMMEND_GUILD_GROUP_DETAIL", "TYPE_DISCOVERY_NEW_RECOMMEND_GUILD_GROUP", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public enum GLightLoadingType {
        TYPE_DISCOVERY_MINE(R.layout.f168061el3),
        TYPE_DISCOVERY_MINE_DETAIL(R.layout.f168059el1),
        TYPE_DISCOVERY_RECOMMEND_GUILD_GROUP_DETAIL(R.layout.f168158f42),
        TYPE_DISCOVERY_NEW_RECOMMEND_GUILD_GROUP(R.layout.f3x);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int layoutResId;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryLoadingView$GLightLoadingType$a;", "", "", "value", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryLoadingView$GLightLoadingType;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.discovery.widget.GDiscoveryLoadingView$GLightLoadingType$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final GLightLoadingType a(int value) {
                boolean z16;
                for (GLightLoadingType gLightLoadingType : GLightLoadingType.values()) {
                    if (gLightLoadingType.getLayoutResId() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return gLightLoadingType;
                    }
                }
                return null;
            }

            Companion() {
            }
        }

        GLightLoadingType(int i3) {
            this.layoutResId = i3;
        }

        public final int getLayoutResId() {
            return this.layoutResId;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GDiscoveryLoadingView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(int layoutResId) {
        this.rootView.addView(LayoutInflater.from(getContext()).inflate(layoutResId, (ViewGroup) this, false));
        LinearLayout linearLayout = this.rootView;
        Space space = new Space(getContext());
        space.setLayoutParams(new FrameLayout.LayoutParams(0, this.itemOffset));
        linearLayout.addView(space);
    }

    public final void b() {
        GuildMineLightView guildMineLightView = this.lightView;
        if (guildMineLightView != null) {
            guildMineLightView.h();
        }
        setVisibility(8);
    }

    public final void c(@NotNull List<? extends GLightLoadingType> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            a(((GLightLoadingType) it.next()).getLayoutResId());
        }
    }

    public final void d() {
        this.openLight = true;
        GuildMineLightView guildMineLightView = new GuildMineLightView(getContext());
        this.lightView = guildMineLightView;
        addView(guildMineLightView, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void e() {
        setVisibility(0);
        GuildMineLightView guildMineLightView = this.lightView;
        if (guildMineLightView != null) {
            guildMineLightView.g();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GDiscoveryLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GDiscoveryLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GDiscoveryLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        setClipChildren(false);
        setClipToPadding(false);
        LayoutInflater.from(context).inflate(R.layout.ekp, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f165467w52);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_\u2026ecommend_loading_content)");
        this.rootView = (LinearLayout) findViewById;
        this.itemOffset = ViewUtils.dpToPx(12.0f);
    }
}
