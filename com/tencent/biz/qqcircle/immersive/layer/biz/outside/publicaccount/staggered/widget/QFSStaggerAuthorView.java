package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.p;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/widget/QFSStaggerAuthorView;", "Landroid/widget/LinearLayout;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "setData", "", "color", "setTextColor", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "userNameView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "userAuthIconView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSStaggerAuthorView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView userNameView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView userAuthIconView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSStaggerAuthorView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setData(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.userNameView.setText(feed.poster.nick.get());
        this.userNameView.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
        int authType = QCirclePluginUtil.getAuthType(feed.poster);
        if (authType != 0) {
            this.userAuthIconView.setVisibility(0);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(p.c(authType)).setTargetView(this.userAuthIconView));
            return;
        }
        this.userAuthIconView.setVisibility(8);
    }

    public final void setTextColor(int color) {
        this.userNameView.setTextColor(color);
    }

    public /* synthetic */ QFSStaggerAuthorView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSStaggerAuthorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.g5_, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f115616wi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.user_name_text)");
        this.userNameView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.y_h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_user_auth)");
        this.userAuthIconView = (ImageView) findViewById2;
    }
}
