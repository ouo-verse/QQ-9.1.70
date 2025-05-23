package com.tencent.robot.adelie.homepage.mine.part.section;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotActivity;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.adelie.homepage.utils.n;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/section/c;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "La24/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "attached", "onAttachedChanged", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleTextView", "e", "descTextView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "picImageView", tl.h.F, "La24/a;", "activityItemData", "<init>", "()V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends Section<a24.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView descTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView picImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a24.a activityItemData;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(c this$0, RobotActivity robotActivity, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotActivity, "$robotActivity");
        if (!u64.g.f438512a.g()) {
            n nVar = n.f366680a;
            Context context = this$0.mRootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            String str = robotActivity.jumpUrl;
            Intrinsics.checkNotNullExpressionValue(str, "robotActivity.jumpUrl");
            nVar.f(context, str);
            View rootView = this$0.getRootView();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("activity_id", robotActivity.f359207id));
            VideoReport.reportEvent("clck", rootView, mapOf);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        String str;
        Map mapOf;
        RobotActivity robotActivity;
        if (attached) {
            View rootView = getRootView();
            a24.a aVar = this.activityItemData;
            if (aVar != null && (robotActivity = aVar.getRobotActivity()) != null) {
                str = robotActivity.f359207id;
            } else {
                str = null;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("activity_id", str));
            VideoReport.reportEvent("imp", rootView, mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        TextView textView;
        TextView textView2;
        if (containerView != null) {
            FontSettingManager.resetViewSize2Normal(containerView.getContext(), containerView);
        }
        ImageView imageView = null;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.sar);
        } else {
            textView = null;
        }
        this.titleTextView = textView;
        if (containerView != null) {
            textView2 = (TextView) containerView.findViewById(R.id.saj);
        } else {
            textView2 = null;
        }
        this.descTextView = textView2;
        if (containerView != null) {
            imageView = (ImageView) containerView.findViewById(R.id.san);
        }
        this.picImageView = imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable a24.a data, int position, @Nullable List<Object> payload) {
        final RobotActivity robotActivity;
        this.activityItemData = data;
        if (data != null && (robotActivity = data.getRobotActivity()) != null) {
            TextView textView = this.titleTextView;
            if (textView != null) {
                textView.setText(robotActivity.title);
            }
            TextView textView2 = this.descTextView;
            if (textView2 != null) {
                textView2.setText(robotActivity.slogan);
            }
            ImageView imageView = this.picImageView;
            if (imageView != null) {
                CommonExKt.h(imageView, robotActivity.cover, null, null, null, 14, null);
            }
            View rootView = getRootView();
            if (rootView != null) {
                rootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.mine.part.section.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        c.r(c.this, robotActivity, view);
                    }
                });
            }
            com.tencent.robot.adelie.homepage.utils.h hVar = com.tencent.robot.adelie.homepage.utils.h.f366661a;
            View rootView2 = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView2, "rootView");
            com.tencent.robot.adelie.homepage.utils.h.b(hVar, rootView2, "em_bas_inspiration_gas_station", null, null, null, null, null, 124, null);
        }
        QLog.i("AdelieCreateCenterItemActivitySection", 1, "onBindData data=" + data);
    }
}
