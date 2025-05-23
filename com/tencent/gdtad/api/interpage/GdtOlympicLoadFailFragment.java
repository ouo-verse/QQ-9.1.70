package com.tencent.gdtad.api.interpage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ad.tangram.util.AdStatusBarUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.api.interpage.GdtOlympicLoadFailFragment;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r71.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/gdtad/api/interpage/GdtOlympicLoadFailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtOlympicLoadFailFragment extends QPublicBaseFragment {
    private final void qh() {
        GdtLog.i("GdtOlympicLoadFailFragment", "[close]");
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th5) {
            GdtLog.e("GdtOlympicLoadFailFragment", "[close]", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(GdtOlympicLoadFailFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qh();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            AdStatusBarUtil.setTransparent(window);
        }
        if (activity != null) {
            try {
                activity.overridePendingTransition(R.anim.f154656ps, 0);
            } catch (Throwable th5) {
                GdtLog.e("GdtOlympicLoadFailFragment", "[initWindowStyleAndAnimation]", th5);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        a g16 = a.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        g16.f430911b.setOnClickListener(new View.OnClickListener() { // from class: fm0.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GdtOlympicLoadFailFragment.rh(GdtOlympicLoadFailFragment.this, view);
            }
        });
        FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }
}
