package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qui.quitagview.QUITagIcon;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendFileData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendPicMixData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendThirdVideoData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendVideoMixData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "", ReportConstant.COSTREPORT_PREFIX, "data", "w", "", "u", "", "t", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "v", "e", "Landroid/view/View;", "approvalStatusContainer", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "f", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "approvalStatusTag", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends ar<RecommendAbsFeedData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View approvalStatusContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUITagView approvalStatusTag;

    private final void s() {
        if (this.approvalStatusContainer == null) {
            View inflate = ((ViewStub) getRootView().findViewById(R.id.w5g)).inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "viewStub.inflate()");
            this.approvalStatusContainer = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("approvalStatusContainer");
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.vyp);
            Intrinsics.checkNotNullExpressionValue(findViewById, "approvalStatusContainer.\u2026uild_approval_status_tag)");
            this.approvalStatusTag = (QUITagView) findViewById;
        }
    }

    private final boolean u(RecommendAbsFeedData data) {
        if (!(data instanceof RecommendPicMixData) && !(data instanceof RecommendFileData) && !(data instanceof RecommendThirdVideoData) && !(data instanceof RecommendVideoMixData)) {
            return false;
        }
        return true;
    }

    private final void w(RecommendAbsFeedData data) {
        View view = this.approvalStatusContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("approvalStatusContainer");
            view = null;
        }
        if (u(data)) {
            view.setBackgroundDrawable(view.getResources().getDrawable(R.drawable.guild_approval_status_container_bg));
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ int[] getViewStubLayoutId() {
        return (int[]) t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
    }

    @Nullable
    protected Void t() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendAbsFeedData data, int position, @Nullable List<Object> payload) {
        View view;
        View view2;
        View view3;
        Intrinsics.checkNotNullParameter(data, "data");
        int auditStatus = data.getAuditStatus();
        if (auditStatus != 1) {
            if (auditStatus != 2) {
                View view4 = this.approvalStatusContainer;
                if (view4 != null) {
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("approvalStatusContainer");
                        view3 = null;
                    } else {
                        view3 = view4;
                    }
                    view3.setVisibility(8);
                    return;
                }
                return;
            }
            s();
            QUITagView qUITagView = this.approvalStatusTag;
            if (qUITagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("approvalStatusTag");
                qUITagView = null;
            }
            QUITagType qUITagType = QUITagType.COLOR_RED;
            QUITagSize qUITagSize = QUITagSize.SMALL;
            QUITagIcon qUITagIcon = new QUITagIcon(R.drawable.qui_caution_circle, null, false, 6, null);
            String string = qUITagView.getResources().getString(R.string.zxv);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.\u2026string.feed_not_approved)");
            qUITagView.setConfig(new QUITagViewConfig(qUITagType, qUITagSize, qUITagIcon, string));
            w(data);
            View view5 = this.approvalStatusContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("approvalStatusContainer");
                view2 = null;
            } else {
                view2 = view5;
            }
            view2.setVisibility(0);
            return;
        }
        s();
        QUITagView qUITagView2 = this.approvalStatusTag;
        if (qUITagView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("approvalStatusTag");
            qUITagView2 = null;
        }
        QUITagType qUITagType2 = QUITagType.COLOR_ORANGE;
        QUITagSize qUITagSize2 = QUITagSize.SMALL;
        QUITagIcon qUITagIcon2 = new QUITagIcon(R.drawable.qui_time, null, false, 6, null);
        QUITagView qUITagView3 = this.approvalStatusTag;
        if (qUITagView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("approvalStatusTag");
            qUITagView3 = null;
        }
        String string2 = qUITagView3.getResources().getString(R.string.zxs);
        Intrinsics.checkNotNullExpressionValue(string2, "approvalStatusTag.resour\u2026i.R.string.feed_in_audit)");
        qUITagView2.setConfig(new QUITagViewConfig(qUITagType2, qUITagSize2, qUITagIcon2, string2));
        w(data);
        View view6 = this.approvalStatusContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("approvalStatusContainer");
            view = null;
        } else {
            view = view6;
        }
        view.setVisibility(0);
    }
}
