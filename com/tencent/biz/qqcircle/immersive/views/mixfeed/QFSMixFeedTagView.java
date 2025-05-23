package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/QFSMixFeedTagView;", "Landroid/widget/LinearLayout;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "b", "", "", "", "a", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "text", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMixFeedTagView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSMixFeedTagView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View.inflate(getContext(), R.layout.gje, this);
        View findViewById = findViewById(R.id.f47281wv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_mix_feed_tag_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f47291ww);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_mix_feed_tag_text)");
        this.text = (TextView) findViewById2;
        int dip2px = DisplayUtil.dip2px(getContext(), 6.0f);
        int i3 = dip2px / 2;
        setPadding(dip2px, i3, dip2px, i3);
        setGravity(16);
        setOrientation(0);
        setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.kkr, null));
    }

    @NotNull
    public final Map<String, Object> a(@NotNull FeedCloudMeta$StFeed feed) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(feed, "feed");
        HashMap hashMap = new HashMap();
        if (feed.liteBanner.business_type.get() == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "sgrp_channel_id";
        } else {
            str = QCircleDaTongConstant.ElementParamKey.XSJ_GROUP_ID;
        }
        String d16 = bh.d(feed.liteBanner.extInfo.get(), "group_guild_id");
        Intrinsics.checkNotNullExpressionValue(d16, "getValueFromExtInfo(feed\u2026.get(), \"group_guild_id\")");
        hashMap.put(str, d16);
        String d17 = bh.d(feed.liteBanner.extInfo.get(), "group_guild_title");
        Intrinsics.checkNotNullExpressionValue(d17, "getValueFromExtInfo(feed\u2026t(), \"group_guild_title\")");
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CORNER_MASK_NAME, d17);
        return hashMap;
    }

    public final void b(@NotNull FeedCloudMeta$StFeed feed) {
        boolean z16;
        Intrinsics.checkNotNullParameter(feed, "feed");
        String it = bh.d(feed.liteBanner.extInfo.get(), "group_guild_picurl");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        boolean z17 = true;
        if (it.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            it = null;
        }
        if (it != null) {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(this.icon.getLayoutParams().width).setRequestHeight(this.icon.getLayoutParams().height).setUrl(QCircleSkinHelper.getInstance().getUrl(it)).setTargetView(this.icon));
        }
        String d16 = bh.d(feed.liteBanner.extInfo.get(), "group_guild_title");
        Intrinsics.checkNotNullExpressionValue(d16, "getValueFromExtInfo(feed\u2026t(), \"group_guild_title\")");
        if (d16.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            setVisibility(0);
            this.text.setText(d16);
        } else {
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSMixFeedTagView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.gje, this);
        View findViewById = findViewById(R.id.f47281wv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_mix_feed_tag_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f47291ww);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_mix_feed_tag_text)");
        this.text = (TextView) findViewById2;
        int dip2px = DisplayUtil.dip2px(getContext(), 6.0f);
        int i3 = dip2px / 2;
        setPadding(dip2px, i3, dip2px, i3);
        setGravity(16);
        setOrientation(0);
        setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.kkr, null));
    }
}
