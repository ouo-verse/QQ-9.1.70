package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010\u001eR\u0016\u00103\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010.\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "", "url", "Lcom/tencent/biz/qqcircle/beans/QFSTransitionAnimBean;", "u", "", "position", DomainData.DOMAIN_NAME, "o", "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "coverView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "H", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "titleView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "I", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "Lcom/tencent/biz/qqcircle/widgets/QFSVipNickNameAndIconView;", "J", "Lcom/tencent/biz/qqcircle/widgets/QFSVipNickNameAndIconView;", "nameView", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "playNumView", "L", "playIconView", "M", "tagView", "<init>", "(Landroid/view/View;)V", "N", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final RoundCorneredFrameLayout container;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final ImageView coverView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private final QCircleAsyncTextView titleView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private final QCircleAvatarView avatarView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final QFSVipNickNameAndIconView nameView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final TextView playNumView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private final ImageView playIconView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final TextView tagView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.itemView = itemView;
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) this.itemView.findViewById(R.id.f53602cy);
        this.container = roundCorneredFrameLayout;
        this.coverView = (ImageView) this.itemView.findViewById(R.id.f53542cs);
        this.titleView = (QCircleAsyncTextView) this.itemView.findViewById(R.id.f53582cw);
        this.avatarView = (QCircleAvatarView) this.itemView.findViewById(R.id.f53532cr);
        this.nameView = (QFSVipNickNameAndIconView) this.itemView.findViewById(R.id.f53592cx);
        this.playNumView = (TextView) this.itemView.findViewById(R.id.f53562cu);
        this.playIconView = (ImageView) this.itemView.findViewById(R.id.f53552ct);
        this.tagView = (TextView) this.itemView.findViewById(R.id.f53572cv);
        float b16 = com.tencent.qqnt.base.utils.c.f353052a.b(8);
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setRadius(b16, b16, b16, b16);
        }
    }

    private final void m(FeedCloudMeta$StFeed feed) {
        int color = QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected);
        Option targetView = Option.obtain().setUrl(feed.cover.picUrl.get()).setTargetView(this.coverView);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        Option failedDrawableId = targetView.setRequestWidth(cVar.b(176)).setRequestHeight(cVar.b(234)).setLoadingDrawableColor(color).setFailedDrawableId(R.drawable.ojc);
        failedDrawableId.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(failedDrawableId);
    }

    private final void n(FeedCloudMeta$StFeed feed, int position) {
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_feed_id", feed.f398449id.get());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feed.poster.f398463id.get());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(position));
        ua0.i.k(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT, params, feed.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(FeedCloudMeta$StFeed feed, g this$0, View view) {
        HashMap<String, String> hashMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFromReportBean(new QCircleReportBean(130));
        qCircleLayerBean.setFeed(feed);
        qCircleLayerBean.setUseLoadingPic(true);
        qCircleLayerBean.setGetFeedList(true);
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.sourceType = 15;
        qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("key_scheme", "mqqapi://qcircle/opendetail?sourcetype=15&feedid=" + feed.f398449id.get() + "&createtime=" + feed.createTime.get() + "&uin=" + feed.poster.f398463id.get() + "&getfeedlist=1"));
        qCircleLayerBean.setSchemeAttrs(hashMapOf);
        String str = feed.cover.picUrl.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.cover.picUrl.get()");
        qCircleLayerBean.setTransitionAnimBean(this$0.u(str));
        com.tencent.biz.qqcircle.launcher.c.u(view.getContext(), qCircleLayerBean);
        ua0.i.h(view, "dt_clck", new QCircleDTParamBuilder().buildElementParams());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(FeedCloudMeta$StFeed feed) {
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView = this.nameView;
        if (qFSVipNickNameAndIconView != null) {
            qFSVipNickNameAndIconView.setUser(feed.poster);
        }
        QFSVipNickNameAndIconView qFSVipNickNameAndIconView2 = this.nameView;
        if (qFSVipNickNameAndIconView2 != null) {
            qFSVipNickNameAndIconView2.w0(feed.poster.nick.get());
        }
    }

    private final void r(FeedCloudMeta$StFeed feed) {
        if (feed.opMask2.get().contains(43)) {
            String f16 = r.f(feed.visitorInfo.viewCount.get());
            TextView textView = this.playNumView;
            if (textView != null) {
                textView.setText(f16);
            }
            TextView textView2 = this.playNumView;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            ImageView imageView = this.playIconView;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView3 = this.playNumView;
        if (textView3 != null) {
            textView3.setText("");
        }
        TextView textView4 = this.playNumView;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        ImageView imageView2 = this.playIconView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private final void s(FeedCloudMeta$StFeed feed) {
        boolean isBlank;
        List<FeedCloudCommon$Entry> list = feed.liteBanner.extInfo.get();
        Intrinsics.checkNotNullExpressionValue(list, "feed.liteBanner.extInfo.get()");
        String str = "";
        String str2 = "";
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (Intrinsics.areEqual(feedCloudCommon$Entry.key.get(), "search_guess_video_tag_text")) {
                str = feedCloudCommon$Entry.value.get();
                Intrinsics.checkNotNullExpressionValue(str, "entry.value.get()");
            } else if (Intrinsics.areEqual(feedCloudCommon$Entry.key.get(), "search_guess_video_tag_type")) {
                str2 = feedCloudCommon$Entry.value.get();
                Intrinsics.checkNotNullExpressionValue(str2, "entry.value.get()");
            }
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            if (Intrinsics.areEqual(str2, "1")) {
                TextView textView = this.tagView;
                if (textView != null) {
                    textView.setText(str);
                }
                TextView textView2 = this.tagView;
                if (textView2 != null) {
                    textView2.setTextColor(Color.parseColor("#F74C30"));
                }
                TextView textView3 = this.tagView;
                if (textView3 != null) {
                    textView3.setBackgroundResource(R.drawable.f161645km2);
                }
                TextView textView4 = this.tagView;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(str2, "2")) {
                TextView textView5 = this.tagView;
                if (textView5 != null) {
                    textView5.setText(str);
                }
                TextView textView6 = this.tagView;
                if (textView6 != null) {
                    textView6.setTextColor(Color.parseColor("#0099FF"));
                }
                TextView textView7 = this.tagView;
                if (textView7 != null) {
                    textView7.setBackgroundResource(R.drawable.f161646km3);
                }
                TextView textView8 = this.tagView;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                    return;
                }
                return;
            }
            TextView textView9 = this.tagView;
            if (textView9 != null) {
                textView9.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView10 = this.tagView;
        if (textView10 != null) {
            textView10.setVisibility(8);
        }
    }

    private final void t(FeedCloudMeta$StFeed feed) {
        boolean isBlank;
        String str = feed.content.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.content.get()");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            QCircleAsyncTextView qCircleAsyncTextView = this.titleView;
            if (qCircleAsyncTextView != null) {
                qCircleAsyncTextView.setVisibility(8);
                return;
            }
            return;
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this.titleView;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.setVisibility(0);
        }
        QCircleAsyncTextView qCircleAsyncTextView3 = this.titleView;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.setNeedSpecialAreaBold(true);
        }
        int d16 = QFSQUIUtilsKt.d(BaseApplication.context, R.color.qui_common_text_primary);
        QCircleAsyncTextView qCircleAsyncTextView4 = this.titleView;
        if (qCircleAsyncTextView4 != null) {
            qCircleAsyncTextView4.setSpecialClickAreaColor(d16);
        }
        QCircleAsyncTextView qCircleAsyncTextView5 = this.titleView;
        if (qCircleAsyncTextView5 != null) {
            qCircleAsyncTextView5.setText(feed.content.get());
        }
    }

    private final QFSTransitionAnimBean u(String url) {
        int i3;
        int i16;
        Drawable drawable;
        int[] iArr = new int[2];
        ImageView imageView = this.coverView;
        if (imageView != null) {
            imageView.getLocationInWindow(iArr);
        }
        int i17 = iArr[0];
        int i18 = iArr[1];
        ImageView imageView2 = this.coverView;
        if (imageView2 != null) {
            i3 = imageView2.getWidth();
        } else {
            i3 = 0;
        }
        int i19 = i3 + i17;
        int i26 = iArr[1];
        ImageView imageView3 = this.coverView;
        if (imageView3 != null) {
            i16 = imageView3.getHeight();
        } else {
            i16 = 0;
        }
        QFSTransitionAnimBean bean = new QFSTransitionAnimBean().setLayoutRect(new QFSTransitionAnimBean.SourceRect(i17, i18, i19, i26 + i16)).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(url).setTransitionDelayTimeMs(0);
        ImageView imageView4 = this.coverView;
        if (imageView4 != null) {
            drawable = imageView4.getDrawable();
        } else {
            drawable = null;
        }
        bean.setCoverDrawable(drawable);
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        return bean;
    }

    public final void o(@NotNull final FeedCloudMeta$StFeed feed, int position) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        m(feed);
        t(feed);
        q(feed);
        r(feed);
        s(feed);
        n(feed, position);
        Size a16 = n.a(BaseApplication.context, R.dimen.f158711n0);
        QCircleAvatarView qCircleAvatarView = this.avatarView;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.setAvatar(feed.poster, a16);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.p(FeedCloudMeta$StFeed.this, this, view);
            }
        });
    }
}
