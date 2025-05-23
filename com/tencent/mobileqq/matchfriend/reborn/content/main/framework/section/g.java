package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerDeleteFeedEvent;
import com.tencent.mobileqq.matchfriend.reborn.media.gallery.QQStrangerLayerFragment;
import com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.QQStrangerBigPicLayerFragment;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.api.router.NBPArticleFeedDetailPageSource;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$StImage;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$UserInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J(\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/g;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "Landroid/widget/ImageView;", "D", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "", "viewWidth", "viewHeight", "", UserInfo.SEX_FEMALE, "", "feedId", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/content/Context;", "context", "L", BdhLogUtil.LogTag.Tag_Conn, "B", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "G", "<init>", "()V", "d", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class g extends a {
    private final boolean A(String feedId) {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null || topActivity.isFinishing() || topActivity.isDestroyed()) {
            return false;
        }
        return com.tencent.mobileqq.matchfriend.reborn.utils.a.f245466a.a(topActivity, feedId);
    }

    private final void B(FeedPB$Feed feed) {
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerDeleteFeedEvent(feed));
    }

    private final void C(FeedPB$Feed feed) {
        View rootView = getRootView();
        Context context = rootView != null ? rootView.getContext() : null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).reportFeed(activity, String.valueOf(u72.a.i(feed)), u72.a.b(feed));
        a.t(this, "em_kl_report", null, 2, null);
    }

    private final ImageView D() {
        View findViewById = this.mRootView.findViewById(R.id.ol8);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.oks);
        ImageView imageView2 = (ImageView) this.mRootView.findViewById(R.id.okt);
        if (findViewById.getVisibility() == 0 && imageView.getVisibility() == 0) {
            return imageView;
        }
        if (findViewById.getVisibility() == 0 && imageView2.getVisibility() == 0) {
            return imageView2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(g this$0, FeedPB$Feed data, int i3, int i16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.s("em_kl_company_feed", null);
        this$0.F(data, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(g this$0, FeedPB$Feed data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (this$0.A(u72.a.b(data))) {
            return true;
        }
        this$0.L(this$0.p(), data);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(g this$0, FeedPB$Feed data, ImageView imageView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        q82.a aVar = q82.a.f428711a;
        Context p16 = this$0.p();
        String str = data.images.get(0).url.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.images[0].url.get()");
        aVar.d(p16, str, (r16 & 4) != 0 ? null : imageView, (r16 & 8) != 0 ? QQStrangerLayerFragment.class : QQStrangerBigPicLayerFragment.class, (r16 & 16) != 0 ? null : data, (r16 & 32) != 0 ? false : false);
    }

    private final void L(Context context, final FeedPB$Feed feed) {
        final boolean areEqual = Intrinsics.areEqual(u72.a.g(feed), com.tencent.mobileqq.matchfriend.utils.b.d().j());
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (areEqual) {
            actionSheet.addButton(q(R.string.x2p), 3);
        } else {
            actionSheet.addButton(q(R.string.x2r), 3);
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.f
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                g.M(areEqual, this, feed, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(boolean z16, g this$0, FeedPB$Feed feed, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            if (z16) {
                this$0.B(feed);
            } else {
                this$0.C(feed);
            }
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(final FeedPB$Feed data, int position, List<Object> payload) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        Intrinsics.checkNotNullParameter(data, "data");
        u("em_kl_company_feed", null);
        final ImageView D = D();
        final int i3 = (D == null || (layoutParams2 = D.getLayoutParams()) == null) ? 0 : layoutParams2.width;
        final int i16 = (D == null || (layoutParams = D.getLayoutParams()) == null) ? 0 : layoutParams.height;
        View rootView = getRootView();
        if (rootView != null) {
            rootView.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.H(g.this, data, i3, i16, view);
                }
            }, 1, null)));
        }
        View rootView2 = getRootView();
        if (rootView2 != null) {
            rootView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean J;
                    J = g.J(g.this, data, view);
                    return J;
                }
            });
        }
        PBRepeatMessageField<FeedPB$StImage> pBRepeatMessageField = data.images;
        if ((pBRepeatMessageField.isEmpty() ^ true ? pBRepeatMessageField : null) == null || D == null) {
            return;
        }
        D.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.K(g.this, data, D, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    private final void F(FeedPB$Feed feed, int viewWidth, int viewHeight) {
        JSONObject jSONObject;
        PBUInt32Field pBUInt32Field;
        QLog.i("QQStrangerFeedClickSection", 1, "jumpFeedDetail feedId=" + u72.a.b(feed));
        QqstrangerUserInfoPB$UserInfo qqstrangerUserInfoPB$UserInfo = feed.poster;
        int i3 = (qqstrangerUserInfoPB$UserInfo == null || (pBUInt32Field = qqstrangerUserInfoPB$UserInfo.gender) == null) ? 0 : pBUInt32Field.get();
        if (viewWidth <= 0 || viewHeight <= 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", viewWidth);
            jSONObject2.put("height", viewHeight);
            jSONObject = jSONObject2;
        }
        ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchArticleFeedDetailPage(p(), NBPArticleFeedDetailPageSource.SQUARE_FEED, new com.tencent.mobileqq.nearbypro.api.router.a(1, u72.a.g(feed), i3, u72.a.b(feed), feed.toByteArray(), null, null, jSONObject, 96, null));
    }
}
