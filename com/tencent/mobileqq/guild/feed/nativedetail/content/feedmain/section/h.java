package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "FeedTipPart \u5904\u7406\u4e86\u3002\u4e0d\u518d\u5c55\u793a\u4e0a\u4e0b\u7ed3\u6784\u7684\u9519\u8bef\u9875")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0007H\u0014J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00032\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/h;", "Lhl1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/b;", "", "code", "v", "type", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "p", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", "getViewStubLayoutId", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "data", "position", "", "", "payloads", "u", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "containerView", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends hl1.b<com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout containerView;

    private final View p() {
        RelativeLayout relativeLayout = this.containerView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout = null;
        }
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(relativeLayout.getContext());
        builder.setImageType(16);
        RelativeLayout relativeLayout3 = this.containerView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        String string = relativeLayout2.getContext().getString(R.string.zxr);
        Intrinsics.checkNotNullExpressionValue(string, "containerView.context.ge\u2026ng(R.string.feed_deleted)");
        builder.setTitle(string);
        builder.setHalfScreenState(true);
        builder.setAutoCenter(true);
        QUIEmptyState build = builder.build();
        bt.d(build.getButton(), "em_sgrp_already_delete", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
        return build;
    }

    private final View q() {
        RelativeLayout relativeLayout = this.containerView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout = null;
        }
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(relativeLayout.getContext());
        builder.setImageType(13);
        RelativeLayout relativeLayout3 = this.containerView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        String string = relativeLayout2.getContext().getString(R.string.zxw);
        Intrinsics.checkNotNullExpressionValue(string, "containerView.context.ge\u2026ring.feed_not_permission)");
        builder.setTitle(string);
        builder.setHalfScreenState(true);
        builder.setAutoCenter(true);
        return builder.build();
    }

    private final View r() {
        RelativeLayout relativeLayout = this.containerView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout = null;
        }
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(relativeLayout.getContext());
        builder.setImageType(13);
        RelativeLayout relativeLayout3 = this.containerView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        String string = relativeLayout2.getContext().getString(R.string.zxw);
        Intrinsics.checkNotNullExpressionValue(string, "containerView.context.ge\u2026ring.feed_not_permission)");
        builder.setTitle(string);
        builder.setHalfScreenState(true);
        builder.setAutoCenter(true);
        return builder.build();
    }

    private final View s(int type) {
        QLog.i("FeedMainErrorSection", 1, "createTipView type=" + type);
        if (type != 0) {
            if (type != 1) {
                if (type != 4) {
                    if (type != 5) {
                        return r();
                    }
                    return q();
                }
                return t();
            }
            return p();
        }
        return r();
    }

    private final View t() {
        RelativeLayout relativeLayout = this.containerView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout = null;
        }
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(relativeLayout.getContext());
        builder.setImageType(20);
        RelativeLayout relativeLayout3 = this.containerView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        String string = relativeLayout2.getContext().getString(R.string.f170935zy2);
        Intrinsics.checkNotNullExpressionValue(string, "containerView.context.ge\u2026ng.feed_under_review_tip)");
        builder.setTitle(string);
        builder.setHalfScreenState(true);
        builder.setAutoCenter(true);
        return builder.build();
    }

    private final int v(int code) {
        if (code == 10014) {
            return 1;
        }
        if (code != 10015) {
            if (code != 10023) {
                if (code == 10046) {
                    return 1;
                }
                if (code != 20014) {
                    if (code != 20031) {
                        return 3;
                    }
                } else {
                    return 4;
                }
            } else {
                return 0;
            }
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1s};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.w8q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_error_content_container)");
        this.containerView = (RelativeLayout) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.b data, int position, @Nullable List<Object> payloads) {
        Intrinsics.checkNotNullParameter(data, "data");
        RelativeLayout relativeLayout = this.containerView;
        ViewGroup viewGroup = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        View s16 = s(v(data.getCooperation.qzone.QzoneIPCModule.RESULT_CODE java.lang.String()));
        if (s16 != null) {
            RelativeLayout relativeLayout2 = this.containerView;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            } else {
                viewGroup = relativeLayout2;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ViewUtils.dip2px(80.0f);
            Unit unit = Unit.INSTANCE;
            viewGroup.addView(s16, layoutParams);
        }
    }
}
