package com.qzone.reborn.debug.timecost;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedx.itemview.QZoneEmptyOrForbiddenView;
import com.qzone.reborn.feedx.widget.QZoneCommentNickView;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedCommentWidget;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneFeedxSingleVideoWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZonePicWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import ef.d;
import ho.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0014J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/debug/timecost/QZoneDebugTimeCostFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "sh", "Lkotlin/Function1;", "", "action", "", "th", "Landroid/content/Context;", "context", "groupName", "desc", "Landroid/widget/FrameLayout;", "qh", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "containerView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mTitle", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneDebugTimeCostFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout containerView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTitle;

    private final FrameLayout qh(final Context context, final String groupName, String desc) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, d.b(48)));
        frameLayout.setPadding(d.b(20), 0, d.b(20), 0);
        TextView textView = new TextView(context);
        textView.setTextSize(18.0f);
        textView.setText(groupName);
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        textView.setGravity(16);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 8388611;
        frameLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setTextSize(14.0f);
        textView2.setText(desc);
        textView2.setTextColor(context.getColor(R.color.qui_button_text_error));
        textView2.setGravity(16);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 8388613;
        frameLayout.addView(textView2, layoutParams2);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.debug.timecost.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneDebugTimeCostFragment.rh(context, groupName, view);
            }
        });
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(Context context, String groupName, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(groupName, "$groupName");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneDebugTimeCostDetailFragment.class.getName()).withString("KEY_GROUP_NAME", groupName).request();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void sh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LinearLayout linearLayout = this.containerView;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                linearLayout = null;
            }
            linearLayout.addView(qh(activity, "QZoneFeedCommentWidget", th(new Function1<Integer, Unit>() { // from class: com.qzone.reborn.debug.timecost.QZoneDebugTimeCostFragment$buildViewInitTest$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    new QZoneFeedCommentWidget(QZoneDebugTimeCostFragment.this.requireActivity());
                }
            })));
            LinearLayout linearLayout3 = this.containerView;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                linearLayout3 = null;
            }
            linearLayout3.addView(qh(activity, "QZonePicWidgetView", th(new Function1<Integer, Unit>() { // from class: com.qzone.reborn.debug.timecost.QZoneDebugTimeCostFragment$buildViewInitTest$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    new QZonePicWidgetView(QZoneDebugTimeCostFragment.this.requireActivity());
                }
            })));
            LinearLayout linearLayout4 = this.containerView;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                linearLayout4 = null;
            }
            linearLayout4.addView(qh(activity, "QZoneFeedxSingleVideoWidgetView", th(new Function1<Integer, Unit>() { // from class: com.qzone.reborn.debug.timecost.QZoneDebugTimeCostFragment$buildViewInitTest$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    new QZoneFeedxSingleVideoWidgetView(QZoneDebugTimeCostFragment.this.requireActivity());
                }
            })));
            LinearLayout linearLayout5 = this.containerView;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                linearLayout5 = null;
            }
            linearLayout5.addView(qh(activity, "QZoneVideoItemWidgetView", th(new Function1<Integer, Unit>() { // from class: com.qzone.reborn.debug.timecost.QZoneDebugTimeCostFragment$buildViewInitTest$1$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    new QZoneVideoItemWidgetView(QZoneDebugTimeCostFragment.this.requireActivity());
                }
            })));
            LinearLayout linearLayout6 = this.containerView;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                linearLayout6 = null;
            }
            linearLayout6.addView(qh(activity, "QZoneCommentNickView", th(new Function1<Integer, Unit>() { // from class: com.qzone.reborn.debug.timecost.QZoneDebugTimeCostFragment$buildViewInitTest$1$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    FragmentActivity requireActivity = QZoneDebugTimeCostFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    new QZoneCommentNickView(requireActivity);
                }
            })));
            LinearLayout linearLayout7 = this.containerView;
            if (linearLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            } else {
                linearLayout2 = linearLayout7;
            }
            linearLayout2.addView(qh(activity, "QZoneEmptyOrForbiddenView", th(new Function1<Integer, Unit>() { // from class: com.qzone.reborn.debug.timecost.QZoneDebugTimeCostFragment$buildViewInitTest$1$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    new QZoneEmptyOrForbiddenView(QZoneDebugTimeCostFragment.this.requireActivity());
                }
            })));
        }
    }

    private final String th(Function1<? super Integer, Unit> action) {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i3 = 0; i3 < 10; i3++) {
            action.invoke(Integer.valueOf(i3));
        }
        return (System.currentTimeMillis() - currentTimeMillis) + "ms";
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f129596h;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        ImmersiveUtils.setStatusTextColor(true, activity != null ? activity.getWindow() : null);
        initView(view);
    }

    private final void initView(View rootView) {
        View findViewById = rootView.findViewById(R.id.mtn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_debug_root_view)");
        this.containerView = (LinearLayout) findViewById;
        TextView textView = (TextView) rootView.findViewById(R.id.mtu);
        this.mTitle = textView;
        if (textView != null) {
            textView.setText(getString(R.string.jmh));
        }
        for (Map.Entry<String, Map<String, c>> entry : b.f53835a.b().entrySet()) {
            String key = entry.getKey();
            Map<String, c> value = entry.getValue();
            FragmentActivity it = getActivity();
            if (it != null) {
                LinearLayout linearLayout = this.containerView;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    linearLayout = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                linearLayout.addView(qh(it, key, value.size() + "\u6761\u5f02\u5e38\u8017\u65f6"));
            }
        }
        sh();
    }
}
