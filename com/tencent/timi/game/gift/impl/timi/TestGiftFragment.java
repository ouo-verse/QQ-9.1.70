package com.tencent.timi.game.gift.impl.timi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/TestGiftFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class TestGiftFragment extends QPublicBaseFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(TimiGiftController giftController, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(giftController, "$giftController");
        giftController.I("0", false);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        QBaseActivity qBaseActivity;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        FrameLayout frameLayout = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            frameLayout = new FrameLayout(qBaseActivity);
            frameLayout.setBackgroundColor(yn4.c.a(R.color.aiy));
            Button button = new Button(qBaseActivity);
            frameLayout.addView(button, new ViewGroup.LayoutParams(-1, -2));
            QBaseActivity qBaseActivity2 = getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
            a c16 = new a(qBaseActivity2).b(QQLiveSDKConfigHelper.getSceneId()).e(123456789L).c(1);
            QBaseActivity qBaseActivity3 = getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity3, "qBaseActivity");
            final TimiGiftController a16 = c16.d(qBaseActivity3).a(frameLayout);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.gift.impl.timi.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestGiftFragment.qh(TimiGiftController.this, view);
                }
            });
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }
}
