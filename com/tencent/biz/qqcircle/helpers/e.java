package com.tencent.biz.qqcircle.helpers;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSAvatarApertureFeedExposeEvent;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/e;", "", "Landroid/view/View;", "apertureView", "", "d", "", "ringWidth", "", "g", "f", "a", "Lfeedcloud/FeedCloudMeta$StUser;", QCircleAlphaUserReporter.KEY_USER, "b", "view", "", MiniChatConstants.MINI_APP_SCREEN_RECORD_LAUNCH_FROM, "e", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "bean", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "c", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f84616a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J)\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0003\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/helpers/e$a", "Lcom/tencent/biz/qqcircle/utils/QFSAsyncUtils$Callback;", "Ljava/lang/Void;", "", "param", "doBackgroundAction", "([Ljava/lang/Void;)Ljava/lang/Void;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QFSAsyncUtils.Callback<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f84617a;

        a(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f84617a = feedCloudMeta$StUser;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        @Nullable
        public Void doBackgroundAction(@NotNull Void... param) {
            Intrinsics.checkNotNullParameter(param, "param");
            QQCircleBase$StUserBusiData userExtraData = QCircleHostUtil.getUserExtraData(this.f84617a);
            if ((userExtraData != null ? userExtraData.has_unread_feed : null) != null) {
                userExtraData.has_unread_feed.set(false);
                this.f84617a.busiData.set(ByteStringMicro.copyFrom(userExtraData.toByteArray()));
            }
            return null;
        }
    }

    e() {
    }

    public final void a(@NotNull View apertureView) {
        Intrinsics.checkNotNullParameter(apertureView, "apertureView");
        apertureView.setBackground(null);
        apertureView.setVisibility(8);
    }

    public final void b(@Nullable FeedCloudMeta$StUser user) {
        if (user != null) {
            QFSAsyncUtils.executeSub(new a(user), new Void[0]);
        }
    }

    public final void c(@Nullable QCircleInitBean bean, @Nullable FeedCloudMeta$StFeed feed) {
        if (bean != null && Intrinsics.areEqual(bean.getLaunchFrom(), "13")) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String uin = bean.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "it.uin");
            simpleEventBus.dispatchEvent(new QFSAvatarApertureFeedExposeEvent(uin, feed));
        }
    }

    public final boolean d(@NotNull View apertureView) {
        Intrinsics.checkNotNullParameter(apertureView, "apertureView");
        if (apertureView.getBackground() != null && (apertureView.getBackground() instanceof q30.b)) {
            Drawable background = apertureView.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.tencent.biz.qqcircle.friendupdate.GradientRingDrawable");
            if (((q30.b) background).getMIsAnim()) {
                return true;
            }
        }
        return false;
    }

    public final void e(@NotNull View view, @NotNull FeedCloudMeta$StUser user, @NotNull String launchFrom) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(launchFrom, "launchFrom");
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setSchemeAttrs(new HashMap<>());
        qCircleLayerBean.setLaunchFrom(launchFrom);
        qCircleLayerBean.setUin(user.f398463id.get());
        qCircleLayerBean.setGetFeedList(true);
        com.tencent.biz.qqcircle.launcher.c.u(view.getContext(), qCircleLayerBean);
    }

    public final void f(@NotNull View apertureView, float ringWidth) {
        Intrinsics.checkNotNullParameter(apertureView, "apertureView");
        apertureView.setVisibility(0);
        q30.b bVar = new q30.b(true);
        bVar.e(false);
        bVar.f(ringWidth);
        apertureView.setBackground(bVar);
    }

    public final void g(@NotNull View apertureView, float ringWidth) {
        Intrinsics.checkNotNullParameter(apertureView, "apertureView");
        apertureView.setVisibility(0);
        if (apertureView.getBackground() instanceof q30.b) {
            Drawable background = apertureView.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type com.tencent.biz.qqcircle.friendupdate.GradientRingDrawable");
            q30.b bVar = (q30.b) background;
            bVar.e(true);
            bVar.d();
            bVar.f(ringWidth);
            apertureView.setBackground(bVar);
            return;
        }
        q30.b bVar2 = new q30.b(true);
        bVar2.f(ringWidth);
        apertureView.setBackground(bVar2);
    }
}
