package com.qzone.reborn.debug.timecost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import ef.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/debug/timecost/QZoneDebugTimeCostDetailFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "groupName", "", "qh", "Landroid/content/Context;", "context", "itemName", "", QCircleWeakNetReporter.KEY_COST, "Landroid/widget/FrameLayout;", "ph", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mTitle", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneDebugTimeCostDetailFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTitle;

    private final FrameLayout ph(Context context, String itemName, long cost) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        frameLayout.setPadding(d.b(20), d.b(10), d.b(20), d.b(10));
        TextView textView = new TextView(context);
        textView.setTextSize(16.0f);
        textView.setText(itemName);
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        textView.setGravity(16);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.setMarginEnd(d.b(100));
        layoutParams.gravity = 8388611;
        frameLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setTextSize(14.0f);
        textView2.setText("\u6700\u5927\u8017\u65f6" + cost + "ms");
        textView2.setTextColor(context.getColor(R.color.qui_button_text_error));
        textView2.setGravity(16);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 8388613;
        frameLayout.addView(textView2, layoutParams2);
        return frameLayout;
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
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        String str = null;
        ImmersiveUtils.setStatusTextColor(true, activity != null ? activity.getWindow() : null);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            str = intent.getStringExtra("KEY_GROUP_NAME");
        }
        qh(view, str);
    }

    private final void qh(View rootView, String groupName) {
        View findViewById = rootView.findViewById(R.id.mtn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_debug_root_view)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        TextView textView = (TextView) rootView.findViewById(R.id.mtu);
        this.mTitle = textView;
        if (textView != null) {
            textView.setText(getString(R.string.jmh));
        }
        Map<String, c> a16 = b.f53835a.a(groupName);
        if (a16 != null) {
            for (Map.Entry<String, c> entry : a16.entrySet()) {
                c value = entry.getValue();
                FragmentActivity it = getActivity();
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    linearLayout.addView(ph(it, entry.getKey(), value.getCooperation.qqcircle.report.QCircleWeakNetReporter.KEY_COST java.lang.String()));
                }
            }
        }
    }
}
