package com.qzone.reborn.feedx.widget.userhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import yo.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedx/widget/userhome/QZoneFeedMemorySealView;", "Landroid/widget/FrameLayout;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "", "g", "f", "feedData", "c", "Lkotlin/Function0;", "function", "setOnCloseListener", "d", "Lkotlin/jvm/functions/Function0;", "mCloseListener", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mLockIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mMsgText", h.F, "mSettingText", "i", "mCloseIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFeedMemorySealView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> mCloseListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mLockIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mMsgText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mSettingText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mCloseIcon;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFeedMemorySealView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QZoneFeedMemorySealView this$0, BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(businessFeedData, "$businessFeedData");
        this$0.g(businessFeedData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(QZoneFeedMemorySealView this$0, BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(businessFeedData, "$businessFeedData");
        this$0.f(businessFeedData);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void c(final BusinessFeedData feedData) {
        boolean isNeedShowMemorySealBar = FeedUtil.isNeedShowMemorySealBar(feedData);
        boolean isNeedShowPrivateSpaceBar = FeedUtil.isNeedShowPrivateSpaceBar(feedData);
        if (!isNeedShowMemorySealBar && !isNeedShowPrivateSpaceBar) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c.a().j(this.mLockIcon, new c.C8489c().h("qui_lock").e(R.color.qui_common_icon_secondary));
        c.a().j(this.mCloseIcon, new c.C8489c().h("qui_close").e(R.color.qui_common_icon_secondary));
        if (feedData != null) {
            TextView textView = this.mMsgText;
            if (textView != null) {
                textView.setText(feedData.cellFollowGuide.summary);
            }
            TextView textView2 = this.mSettingText;
            if (textView2 != null) {
                textView2.setText(feedData.cellFollowGuide.button_text);
            }
            TextView textView3 = this.mSettingText;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.userhome.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZoneFeedMemorySealView.d(QZoneFeedMemorySealView.this, feedData, view);
                    }
                });
            }
            ImageView imageView = this.mCloseIcon;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.userhome.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZoneFeedMemorySealView.e(QZoneFeedMemorySealView.this, feedData, view);
                    }
                });
            }
        }
    }

    public final void setOnCloseListener(Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.mCloseListener = function;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFeedMemorySealView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneFeedMemorySealView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void f(BusinessFeedData businessFeedData) {
        int i3;
        setVisibility(8);
        this.mCloseListener.invoke();
        if ((businessFeedData != null ? businessFeedData.cellFollowGuide : null) != null) {
            if (businessFeedData.cellFollowGuide.feed_type == 1) {
                QZoneFeedUtil.j0(System.currentTimeMillis());
                i3 = 114;
            } else {
                QZoneFeedUtil.k0(System.currentTimeMillis());
                i3 = 113;
            }
            LpReportInfo_pf00064.allReport(i3, 3, businessFeedData.feedType != 3 ? 2 : 1);
        }
    }

    private final void g(BusinessFeedData businessFeedData) {
        if ((businessFeedData != null ? businessFeedData.cellFollowGuide : null) == null || businessFeedData.getPermissionInfo() == null) {
            return;
        }
        CellFollowGuide cellFollowGuide = businessFeedData.cellFollowGuide;
        int i3 = cellFollowGuide.action_type;
        if (i3 == 2 || i3 == 20) {
            d.c(cellFollowGuide.action_url, getContext());
            LpReportInfo_pf00064.allReport(businessFeedData.cellFollowGuide.feed_type == 1 ? 114 : 113, 2, businessFeedData.feedType != 3 ? 2 : 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedMemorySealView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCloseListener = new Function0<Unit>() { // from class: com.qzone.reborn.feedx.widget.userhome.QZoneFeedMemorySealView$mCloseListener$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.cfx, this);
        setVisibility(8);
        this.mLockIcon = (ImageView) findViewById(R.id.n0r);
        this.mMsgText = (TextView) findViewById(R.id.n0s);
        this.mSettingText = (TextView) findViewById(R.id.n0t);
        this.mCloseIcon = (ImageView) findViewById(R.id.n0q);
    }
}
