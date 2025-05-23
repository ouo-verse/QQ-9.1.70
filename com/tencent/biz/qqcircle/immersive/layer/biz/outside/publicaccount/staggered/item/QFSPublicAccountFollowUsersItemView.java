package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.QFSPublicAccountFollowListContainer;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;
import feedcloud.FeedCloudOfficialaccount$TopUserDetail;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\tH\u0014J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0005R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountFollowUsersItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "Landroid/view/ViewGroup;", "parentView", "", "l0", "", "getLogTag", "", "getLayoutId", "p0", "p1", "k0", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "rsp", "m0", "destroy", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/QFSPublicAccountFollowListContainer;", "d", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/QFSPublicAccountFollowListContainer;", "followUsersContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public final class QFSPublicAccountFollowUsersItemView extends QCircleBaseWidgetView<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPublicAccountFollowListContainer followUsersContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountFollowUsersItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l0(ViewGroup parentView) {
        QLog.d("QFSPublicAccountFollowUsersItemView", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        QFSPublicAccountFollowListContainer qFSPublicAccountFollowListContainer = this.followUsersContainer;
        if (qFSPublicAccountFollowListContainer == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qFSPublicAccountFollowListContainer = new QFSPublicAccountFollowListContainer(context, null, 2, 0 == true ? 1 : 0);
            this.followUsersContainer = qFSPublicAccountFollowListContainer;
        }
        parentView.setPadding(0, 0, 0, 0);
        parentView.addView(qFSPublicAccountFollowListContainer, new FrameLayout.LayoutParams(-1, -2));
    }

    public final void destroy() {
        QLog.i("QFSPublicAccountFollowUsersItemView", 1, "destroy");
        QFSPublicAccountFollowListContainer qFSPublicAccountFollowListContainer = this.followUsersContainer;
        if (qFSPublicAccountFollowListContainer != null) {
            qFSPublicAccountFollowListContainer.e();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.goa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPublicAccountFollowUsersItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable FeedCloudOfficialaccount$OfficialTopFollowUsersRsp p06, int p16) {
        View findViewById = findViewById(R.id.root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root)");
        l0((ViewGroup) findViewById);
    }

    public final void m0(@NotNull FeedCloudOfficialaccount$OfficialTopFollowUsersRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        QLog.i("QFSPublicAccountFollowUsersItemView", 1, "updateContent");
        String title = rsp.title.get();
        List<FeedCloudOfficialaccount$TopUserDetail> list = rsp.users_detail.get();
        QFSPublicAccountFollowListContainer qFSPublicAccountFollowListContainer = this.followUsersContainer;
        if (qFSPublicAccountFollowListContainer != null) {
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(list, "list");
            qFSPublicAccountFollowListContainer.j(title, list);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
