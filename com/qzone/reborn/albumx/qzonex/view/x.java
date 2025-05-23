package com.qzone.reborn.albumx.qzonex.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/x;", "", "", "position", "", "e", "c", "d", "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "b", "()Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tabText", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "tabIcon", "Landroid/view/ViewGroup;", "tabView", "<init>", "(Landroid/view/ViewGroup;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final List<String> f53530e;

    /* renamed from: f, reason: collision with root package name */
    private static final List<Integer> f53531f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final TextView tabText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ImageView tabIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR%\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/x$a;", "", "", "", "kotlin.jvm.PlatformType", "tabTitles", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "tabIcons", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.qzonex.view.x$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> a() {
            return x.f53530e;
        }

        Companion() {
        }
    }

    static {
        List<String> mutableListOf;
        List<Integer> mutableListOf2;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(com.qzone.util.l.a(R.string.jfx), com.qzone.util.l.a(R.string.jfz), com.qzone.util.l.a(R.string.f169519jg1), com.qzone.util.l.a(R.string.f169518jg0));
        f53530e = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(Integer.valueOf(R.drawable.qui_feed_picture_collection), Integer.valueOf(R.drawable.qui_image), Integer.valueOf(R.drawable.qui_play_circle), Integer.valueOf(R.drawable.qui_fans));
        f53531f = mutableListOf2;
    }

    public x(ViewGroup tabView) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        View inflate = LayoutInflater.from(tabView.getContext()).inflate(R.layout.f129175c, tabView, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.rootView = frameLayout;
        View findViewById = frameLayout.findViewById(R.id.mpy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_albumx_tab_text)");
        this.tabText = (TextView) findViewById;
        View findViewById2 = frameLayout.findViewById(R.id.mpw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qzone_albumx_tab_icon)");
        this.tabIcon = (ImageView) findViewById2;
    }

    /* renamed from: b, reason: from getter */
    public final FrameLayout getRootView() {
        return this.rootView;
    }

    public final void c(int position) {
        if (ab0.a.a(position, f53530e)) {
            return;
        }
        this.tabIcon.setColorFilter(this.rootView.getContext().getColor(R.color.qui_common_brand_standard));
        this.tabText.setTextColor(this.rootView.getContext().getColor(R.color.qui_common_brand_standard));
    }

    public final void d(int position) {
        if (ab0.a.a(position, f53530e)) {
            return;
        }
        this.tabIcon.setColorFilter(this.rootView.getContext().getColor(R.color.qui_common_icon_primary));
        this.tabText.setTextColor(this.rootView.getContext().getColor(R.color.qui_common_text_primary));
    }

    public final void e(int position) {
        List<String> list = f53530e;
        if (ab0.a.a(position, list)) {
            return;
        }
        this.tabText.setText(list.get(position));
        this.tabText.setTextColor(this.rootView.getContext().getColor(R.color.qui_common_text_primary));
        this.tabIcon.setImageResource(f53531f.get(position).intValue());
        this.tabIcon.setColorFilter(this.rootView.getContext().getColor(R.color.qui_common_icon_primary));
    }
}
