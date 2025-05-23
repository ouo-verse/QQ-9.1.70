package com.tencent.mobileqq.nearbypro.feedscheck.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.StatusFeedData;
import com.tencent.mobileqq.nearbypro.feedscheck.widgets.FeedBubble;
import com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt;
import com.tencent.mobileqq.nearbypro.utils.b;
import com.tencent.mobileqq.nearbypro.utils.q;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import op4.g;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pa2.a;
import qp4.f;
import sp4.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J'\u0010\n\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010'\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001dR\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u0016\u00100\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/widgets/FeedBubble;", "Landroid/widget/LinearLayout;", "", "contentStr", "", "g", "", "Lop4/g;", "feedPicArray", "feedId", "e", "([Lop4/g;Ljava/lang/String;)V", "iconUrl", "d", "Lqp4/f;", "bubbleSpace", "c", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/h;", "statusFeedData", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "setBubbleData", "Landroid/view/View$OnClickListener;", "clickListener", "setFeedILikeClickListener", "", "iLike", "setILikeIcon", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "feedPic", "feedStatusIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "feedStatusContent", h.F, "feedStatusTv", "i", "feedILike", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "feedDivider", BdhLogUtil.LogTag.Tag_Conn, "feedLocation", "D", "Z", "hasShowPic", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FeedBubble extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TextView feedLocation;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasShowPic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView feedPic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView feedStatusIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView feedStatusContent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView feedStatusTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView feedILike;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View feedDivider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedBubble(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void c(f bubbleSpace) {
        float f16;
        if (bubbleSpace == null) {
            return;
        }
        int i3 = bubbleSpace.f429218b;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        float f17 = i3;
        if (this.hasShowPic) {
            f16 = 0.433f;
        } else {
            f16 = 0.625f;
        }
        marginLayoutParams.bottomMargin = ((int) (f17 * f16)) * 3;
        setLayoutParams(marginLayoutParams);
        j.c().e("NBP.FeedsCheckPart.FeedBubble", "bindBubbleSpace " + marginLayoutParams.bottomMargin);
    }

    private final void d(String iconUrl) {
        boolean z16;
        if (iconUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.feedStatusIv.setVisibility(8);
        } else {
            this.feedStatusIv.setVisibility(0);
            PicLoadUtilsKt.c(iconUrl, this.feedStatusIv);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(g[] feedPicArray, final String feedId) {
        boolean z16;
        Object first;
        boolean z17;
        if (feedPicArray != null) {
            if (feedPicArray.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    this.feedPic.setVisibility(8);
                    this.hasShowPic = false;
                    return;
                }
                this.hasShowPic = true;
                this.feedPic.setVisibility(0);
                first = ArraysKt___ArraysKt.first(feedPicArray);
                q.e((g) first, this.feedPic, null, null, 12, null);
                this.feedPic.setOnClickListener(new View.OnClickListener() { // from class: ta2.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedBubble.f(FeedBubble.this, feedId, view);
                    }
                });
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FeedBubble this$0, String feedId, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        if (!GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
            } else {
                a aVar = a.f425847a;
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.c(context, it, feedId, (String) it.getTag(R.id.zoo), this$0.getWidth(), this$0.getHeight());
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void g(String contentStr) {
        boolean z16;
        if (contentStr.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.feedStatusContent.setVisibility(8);
        } else {
            this.feedStatusContent.setVisibility(0);
            this.feedStatusContent.setText(contentStr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(i iVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
            } else {
                a aVar = a.f425847a;
                String str = iVar.f423351a;
                Long valueOf = Long.valueOf(iVar.f423352b.f434140a);
                c cVar = iVar.f423352b;
                String str2 = cVar.f434143d;
                String str3 = cVar.f434145f;
                Intrinsics.checkNotNullExpressionValue(cVar, "statusFeed.poster");
                a.b(aVar, str, valueOf, str2, str3, b.a(cVar), iVar, 1, null, 128, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setBubbleData(@NotNull StatusFeedData statusFeedData, @NotNull com.tencent.mobileqq.nearbypro.part.a host) {
        Intrinsics.checkNotNullParameter(statusFeedData, "statusFeedData");
        Intrinsics.checkNotNullParameter(host, "host");
        final i statusFeed = statusFeedData.getStatusFeed();
        if (statusFeedData.getStatusFeedType() != 1 && statusFeed != null && statusFeedData.getStatusFeedType() != 3) {
            setVisibility(0);
            setOnClickListener(new View.OnClickListener() { // from class: ta2.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBubble.h(i.this, view);
                }
            });
            this.feedLocation.setText(statusFeed.f423357g.f423349t);
            this.feedStatusTv.setText(statusFeed.f423353c.f431880c);
            byte[] customText = statusFeed.f423355e;
            Intrinsics.checkNotNullExpressionValue(customText, "customText");
            g(new String(customText, Charsets.UTF_8));
            g[] gVarArr = statusFeed.f423356f;
            String str = statusFeed.f423351a;
            Intrinsics.checkNotNullExpressionValue(str, "this.feedId");
            e(gVarArr, str);
            String str2 = statusFeed.f423353c.f431881d;
            Intrinsics.checkNotNullExpressionValue(str2, "statusInfo.icon");
            d(str2);
            c(statusFeed.f423354d.f431875d);
            return;
        }
        setVisibility(8);
    }

    public final void setFeedILikeClickListener(@NotNull View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.feedILike.setOnClickListener(clickListener);
    }

    public final void setILikeIcon(boolean iLike) {
        if (iLike) {
            this.feedILike.setImageResource(R.drawable.k2p);
        } else {
            this.feedILike.setImageResource(R.drawable.f161128n31);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedBubble(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ FeedBubble(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedBubble(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        View.inflate(getContext(), R.layout.f168325fn1, this);
        setVisibility(8);
        View findViewById = findViewById(R.id.v38);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.feed_pic)");
        this.feedPic = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.v3h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_status_icon)");
        this.feedStatusIv = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.v1k);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.feed_content_tv)");
        this.feedStatusContent = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.v3i);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.feed_status_tv)");
        this.feedStatusTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.v2s);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.feed_i_like)");
        this.feedILike = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.v29);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.feed_divider)");
        this.feedDivider = findViewById6;
        View findViewById7 = findViewById(R.id.c75);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.feed_location)");
        this.feedLocation = (TextView) findViewById7;
    }
}
