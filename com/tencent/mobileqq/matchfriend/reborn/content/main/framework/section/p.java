package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerLikeFeedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerUnlikeFeedEvent;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.api.router.NearbyFeedPosterData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$StImage;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserInfo;
import com.tencent.util.QQToastUtil;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\t0\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J(\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00112\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0014J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016R\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010+\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/p;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "", "H", "M", "D", "B", "", ReportConstant.COSTREPORT_PREFIX, "kotlin.jvm.PlatformType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "K", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "textView", "", "resId", "O", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "G", "", NodeProps.VISIBLE, "onVisibleChanged", "d", "Landroid/widget/TextView;", "likeTv", "e", "commentTv", "f", "shareTv", tl.h.F, "Z", "itemVisible", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class p extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView likeTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView commentTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView shareTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean itemVisible;

    private final String A(String s16) {
        try {
            return URLEncoder.encode(s16, "UTF-8");
        } catch (Exception unused) {
            return s16;
        }
    }

    private final void B(FeedPB$Feed feed) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        String str = null;
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        String str2 = (userinfo_miniinfo == null || (pBStringField3 = userinfo_miniinfo.open_id) == null) ? null : pBStringField3.get();
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (userinfo_miniinfo == null || (pBStringField2 = userinfo_miniinfo.nick) == null) ? null : pBStringField2.get();
        if (str3 == null) {
            str3 = "";
        }
        if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.avatar) != null) {
            str = pBStringField.get();
        }
        String str4 = str != null ? str : "";
        String str5 = "mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_feed_comment&app_id=1&viewer_user_id=" + A(str2) + "&viewer_nickname=" + A(str3) + "&viewer_avatar=" + A(str4) + "&poster_user_id=" + A(u72.a.g(feed)) + "&feed_id=" + A(u72.a.b(feed)) + "&with_keyboard=false&nbp_source=1&modal_mode=1&custom_back_pressed=1";
        Intent intent = new Intent();
        intent.setData(Uri.parse(str5));
        RouteUtils.startActivity(p(), intent, RouterConstants.UI_ROUTER_JUMP);
    }

    private final void D(final FeedPB$Feed feed) {
        String q16;
        TextView textView = this.commentTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            textView = null;
        }
        if (u72.a.a(feed) > 99) {
            q16 = "99+";
        } else if (u72.a.a(feed) > 0) {
            q16 = String.valueOf(u72.a.a(feed));
        } else {
            q16 = q(R.string.x2o);
        }
        textView.setText(q16);
        TextView textView2 = this.commentTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            textView2 = null;
        }
        textView2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.F(p.this, feed, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(p this$0, FeedPB$Feed feed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        a.t(this$0, "em_kl_comment", null, 2, null);
        this$0.B(feed);
    }

    private final void H(final FeedPB$Feed feed) {
        String q16;
        TextView textView = this.likeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeTv");
            textView = null;
        }
        if (u72.a.f(feed) > 99) {
            q16 = "99+";
        } else if (u72.a.f(feed) > 0) {
            q16 = String.valueOf(u72.a.f(feed));
        } else {
            q16 = q(R.string.x2q);
        }
        textView.setText(q16);
        TextView textView2 = this.likeTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeTv");
            textView2 = null;
        }
        O(textView2, u72.a.j(feed) ? R.drawable.qui_like_fill_testing_feedback_error : R.drawable.qui_like_outline_testing);
        TextView textView3 = this.likeTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeTv");
            textView3 = null;
        }
        textView3.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.J(p.this, feed, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(p this$0, FeedPB$Feed feed, View view) {
        String str;
        Map<String, String> mapOf;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        if (u72.a.j(feed)) {
            str = "0";
        } else {
            str = "1";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_action_type", str));
        this$0.s("em_kl_like", mapOf);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(0, BaseApplication.context.getString(R.string.x0e));
            return;
        }
        if (u72.a.j(feed)) {
            u72.a.m(feed, false);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(u72.a.f(feed) - 1, 0);
            u72.a.l(feed, coerceAtLeast);
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerUnlikeFeedEvent(feed));
        } else {
            u72.a.m(feed, true);
            u72.a.l(feed, u72.a.f(feed) + 1);
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLikeFeedEvent(feed));
        }
        this$0.H(feed);
    }

    private final void K(final FeedPB$Feed feed) {
        TextView textView = this.shareTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareTv");
            textView = null;
        }
        O(textView, R.drawable.qui_share_testing);
        TextView textView2 = this.shareTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareTv");
            textView2 = null;
        }
        textView2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.L(p.this, feed, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(p this$0, FeedPB$Feed feed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        a.t(this$0, "em_kl_share", null, 2, null);
        this$0.C(feed);
    }

    private final void M() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.l
            @Override // java.lang.Runnable
            public final void run() {
                p.N(p.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(p this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.itemVisible) {
            a.v(this$0, "em_kl_share", null, 2, null);
        }
    }

    private final void O(TextView textView, int resId) {
        Drawable drawable = ContextCompat.getDrawable(textView.getContext(), resId);
        if (drawable != null) {
            drawable.setBounds(0, 0, com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(20), com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(20));
        } else {
            drawable = null;
        }
        textView.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(FeedPB$Feed data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        H(data);
        D(data);
        K(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f163186os0);
        TextView it = (TextView) findViewById;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        O(it, R.drawable.qui_like_outline_testing);
        com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.b(it, 16.0f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026dTouchZone(16f)\n        }");
        this.likeTv = it;
        View findViewById2 = containerView.findViewById(R.id.orv);
        TextView it5 = (TextView) findViewById2;
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        O(it5, R.drawable.qui_comment_testing);
        com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.b(it5, 16.0f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026dTouchZone(16f)\n        }");
        this.commentTv = it5;
        View findViewById3 = containerView.findViewById(R.id.f163189os3);
        TextView it6 = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(it6, "it");
        com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.b(it6, 16.0f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026dTouchZone(16f)\n        }");
        this.shareTv = it6;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        if (this.itemVisible != visible) {
            this.itemVisible = visible;
            if (visible) {
                M();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.or_};
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void C(FeedPB$Feed feed) {
        String str;
        QqstrangerUserInfoPB$UserInfo qqstrangerUserInfoPB$UserInfo;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        List<FeedPB$StImage> list;
        Object firstOrNull;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        if (feed == null) {
            return;
        }
        INearbyProPageRouter iNearbyProPageRouter = (INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class);
        Context p16 = p();
        QqstrangerUserInfoPB$UserInfo qqstrangerUserInfoPB$UserInfo2 = feed.poster;
        String str2 = null;
        String str3 = (qqstrangerUserInfoPB$UserInfo2 == null || (pBStringField4 = qqstrangerUserInfoPB$UserInfo2.open_id) == null) ? null : pBStringField4.get();
        String str4 = str3 == null ? "" : str3;
        String b16 = u72.a.b(feed);
        PBRepeatMessageField<FeedPB$StImage> pBRepeatMessageField = feed.images;
        if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            FeedPB$StImage feedPB$StImage = (FeedPB$StImage) firstOrNull;
            if (feedPB$StImage != null && (pBStringField3 = feedPB$StImage.url) != null) {
                str = pBStringField3.get();
                String str5 = str != null ? "" : str;
                String d16 = u72.a.d(feed);
                String str6 = d16 != null ? "" : d16;
                QqstrangerUserInfoPB$UserInfo qqstrangerUserInfoPB$UserInfo3 = feed.poster;
                String str7 = (qqstrangerUserInfoPB$UserInfo3 != null || (pBStringField2 = qqstrangerUserInfoPB$UserInfo3.avatar) == null) ? null : pBStringField2.get();
                String str8 = str7 != null ? "" : str7;
                qqstrangerUserInfoPB$UserInfo = feed.poster;
                if (qqstrangerUserInfoPB$UserInfo != null && (pBStringField = qqstrangerUserInfoPB$UserInfo.nick) != null) {
                    str2 = pBStringField.get();
                }
                iNearbyProPageRouter.launchFeedSharePage(p16, 1, 2, new NearbyFeedPosterData(1, str4, b16, str5, null, str6, str8, str2 != null ? "" : str2, null, 272, null));
            }
        }
        str = null;
        if (str != null) {
        }
        String d162 = u72.a.d(feed);
        if (d162 != null) {
        }
        QqstrangerUserInfoPB$UserInfo qqstrangerUserInfoPB$UserInfo32 = feed.poster;
        if (qqstrangerUserInfoPB$UserInfo32 != null) {
        }
        if (str7 != null) {
        }
        qqstrangerUserInfoPB$UserInfo = feed.poster;
        if (qqstrangerUserInfoPB$UserInfo != null) {
            str2 = pBStringField.get();
        }
        iNearbyProPageRouter.launchFeedSharePage(p16, 1, 2, new NearbyFeedPosterData(1, str4, b16, str5, null, str6, str8, str2 != null ? "" : str2, null, 272, null));
    }
}
