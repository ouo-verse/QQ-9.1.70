package com.tencent.mobileqq.guild.feed.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0002\u000f\u0017B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R$\u0010,\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R$\u00100\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper$b;", "data", "", "i", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "Landroid/view/View;", "a", "Landroid/view/View;", "k", "()Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/view/View;)V", "mContentLayout", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getMContentIcon", "()Landroid/widget/ImageView;", "r", "(Landroid/widget/ImageView;)V", "mContentIcon", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getMContentBtn", "()Landroid/widget/TextView;", "p", "(Landroid/widget/TextView;)V", "mContentBtn", "d", "getMContentTitle", "t", "mContentTitle", "getMContentDesc", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mContentDesc", "f", "j", "o", "mContentArrow", "", "g", "Ljava/lang/Integer;", "l", "()Ljava/lang/Integer;", "u", "(Ljava/lang/Integer;)V", "mFilterColor", "<init>", "()V", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedShareContentHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mContentLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mContentIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mContentBtn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mContentTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mContentDesc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mContentArrow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mFilterColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "id", "b", "f", "iconUrl", "c", "d", "contentText", "e", "descText", "contentScheme", TuxUIConstants.POP_BTN_TEXT, "btnScheme", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.util.FeedShareContentHelper$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ShareContentData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String iconUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String contentText;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String descText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String contentScheme;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String btnText;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String btnScheme;

        public ShareContentData(@NotNull String id5, @NotNull String iconUrl, @NotNull String contentText, @NotNull String descText, @NotNull String contentScheme, @NotNull String btnText, @NotNull String btnScheme) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(contentText, "contentText");
            Intrinsics.checkNotNullParameter(descText, "descText");
            Intrinsics.checkNotNullParameter(contentScheme, "contentScheme");
            Intrinsics.checkNotNullParameter(btnText, "btnText");
            Intrinsics.checkNotNullParameter(btnScheme, "btnScheme");
            this.id = id5;
            this.iconUrl = iconUrl;
            this.contentText = contentText;
            this.descText = descText;
            this.contentScheme = contentScheme;
            this.btnText = btnText;
            this.btnScheme = btnScheme;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getBtnScheme() {
            return this.btnScheme;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getBtnText() {
            return this.btnText;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getContentScheme() {
            return this.contentScheme;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getContentText() {
            return this.contentText;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getDescText() {
            return this.descText;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShareContentData)) {
                return false;
            }
            ShareContentData shareContentData = (ShareContentData) other;
            if (Intrinsics.areEqual(this.id, shareContentData.id) && Intrinsics.areEqual(this.iconUrl, shareContentData.iconUrl) && Intrinsics.areEqual(this.contentText, shareContentData.contentText) && Intrinsics.areEqual(this.descText, shareContentData.descText) && Intrinsics.areEqual(this.contentScheme, shareContentData.contentScheme) && Intrinsics.areEqual(this.btnText, shareContentData.btnText) && Intrinsics.areEqual(this.btnScheme, shareContentData.btnScheme)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.contentText.hashCode()) * 31) + this.descText.hashCode()) * 31) + this.contentScheme.hashCode()) * 31) + this.btnText.hashCode()) * 31) + this.btnScheme.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShareContentData(id=" + this.id + ", iconUrl=" + this.iconUrl + ", contentText=" + this.contentText + ", descText=" + this.descText + ", contentScheme=" + this.contentScheme + ", btnText=" + this.btnText + ", btnScheme=" + this.btnScheme + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/util/FeedShareContentHelper$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f223757e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedShareContentHelper f223758f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ImageView f223759h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Activity activity, FeedShareContentHelper feedShareContentHelper, ImageView imageView) {
            super(true);
            this.f223757e = activity;
            this.f223758f = feedShareContentHelper;
            this.f223759h = imageView;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            Resources resources;
            if (option == null) {
                return;
            }
            if (state == LoadState.STATE_SUCCESS || state == LoadState.STATE_DOWNLOAD_SUCCESS) {
                Activity activity = this.f223757e;
                if (activity != null) {
                    resources = activity.getResources();
                } else {
                    resources = null;
                }
                Drawable bitmapDrawable = new BitmapDrawable(resources, option.getResultBitMap());
                Integer mFilterColor = this.f223758f.getMFilterColor();
                if (mFilterColor != null) {
                    bitmapDrawable = GuildUIUtils.f235378a.F(bitmapDrawable, mFilterColor.intValue());
                }
                this.f223759h.setImageDrawable(bitmapDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Activity activity, ShareContentData data, FeedShareContentHelper this$0, View view) {
        Map plus;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildJumpUtil.w(activity, data.getContentScheme());
        View view2 = this$0.mContentLayout;
        plus = MapsKt__MapsKt.plus(this$0.m(data), TuplesKt.to("sgrp_click_region", 1));
        VideoReport.reportEvent("clck", view2, plus);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 onClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        onClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 onClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        onClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i(ShareContentData data) {
        com.tencent.mobileqq.guild.feed.report.d.f(this.mContentLayout, "em_sgrp_interactive_region", null, ExposurePolicy.REPORT_ALL, null, m(data), 20, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> m(ShareContentData data) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_content_title", data.getContentText()), TuplesKt.to("sgrp_content_url", data.getContentScheme()), TuplesKt.to("sgrp_btn_url", data.getBtnScheme()));
        return mapOf;
    }

    private final boolean n(ShareContentData shareContentData) {
        if (!TextUtils.isEmpty(shareContentData.getId()) && !TextUtils.isEmpty(shareContentData.getIconUrl()) && !TextUtils.isEmpty(shareContentData.getContentText()) && !TextUtils.isEmpty(shareContentData.getDescText()) && !TextUtils.isEmpty(shareContentData.getContentScheme()) && !TextUtils.isEmpty(shareContentData.getBtnText()) && !TextUtils.isEmpty(shareContentData.getBtnScheme())) {
            return false;
        }
        return true;
    }

    public final void e(@Nullable final Activity activity, @NotNull final ShareContentData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (QLog.isDevelopLevel()) {
            QLog.d("FeedShareContentHelper", 4, "[bindData] data=" + data);
        }
        if (n(data)) {
            QLog.d("FeedShareContentHelper", 1, "[bindData] data=" + data + " is invalid");
            View view = this.mContentLayout;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.mContentLayout;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.mContentLayout;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    FeedShareContentHelper.f(activity, data, this, view4);
                }
            });
        }
        if (!TextUtils.isEmpty(data.getBtnScheme())) {
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.FeedShareContentHelper$bindData$onClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Map m3;
                    Map plus;
                    GuildJumpUtil.w(activity, data.getBtnScheme());
                    View mContentLayout = this.getMContentLayout();
                    m3 = this.m(data);
                    plus = MapsKt__MapsKt.plus(m3, TuplesKt.to("sgrp_click_region", 2));
                    VideoReport.reportEvent("clck", mContentLayout, plus);
                }
            };
            TextView textView = this.mContentBtn;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        FeedShareContentHelper.g(Function0.this, view4);
                    }
                });
            }
            ImageView imageView = this.mContentArrow;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        FeedShareContentHelper.h(Function0.this, view4);
                    }
                });
            }
        }
        ImageView imageView2 = this.mContentIcon;
        if (imageView2 != null) {
            com.tencent.mobileqq.guild.u.o(data.getIconUrl(), imageView2.getWidth(), imageView2.getHeight(), new c(activity, this, imageView2));
        }
        TextView textView2 = this.mContentTitle;
        if (textView2 != null) {
            textView2.setText(data.getContentText());
        }
        TextView textView3 = this.mContentDesc;
        if (textView3 != null) {
            textView3.setText(data.getDescText());
        }
        TextView textView4 = this.mContentBtn;
        if (textView4 != null) {
            textView4.setText(data.getBtnText());
        }
        i(data);
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final ImageView getMContentArrow() {
        return this.mContentArrow;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final View getMContentLayout() {
        return this.mContentLayout;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final Integer getMFilterColor() {
        return this.mFilterColor;
    }

    public final void o(@Nullable ImageView imageView) {
        this.mContentArrow = imageView;
    }

    public final void p(@Nullable TextView textView) {
        this.mContentBtn = textView;
    }

    public final void q(@Nullable TextView textView) {
        this.mContentDesc = textView;
    }

    public final void r(@Nullable ImageView imageView) {
        this.mContentIcon = imageView;
    }

    public final void s(@Nullable View view) {
        this.mContentLayout = view;
    }

    public final void t(@Nullable TextView textView) {
        this.mContentTitle = textView;
    }

    public final void u(@Nullable Integer num) {
        this.mFilterColor = num;
    }
}
