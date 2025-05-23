package com.tencent.qq.minibox.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qq.minibox.proxy.MiniBoxHostEventProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0014J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/qq/minibox/ui/FloatingPanelFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/qq/minibox/proxy/MiniBoxHostEventProcessor$a;", "", "page", "Landroidx/fragment/app/Fragment;", "ph", "", "qh", "", "rh", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "sh", "onDestroyView", "Dd", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", ParseCommon.CONTAINER, "", "D", "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "E", "Ljava/lang/String;", "appId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class FloatingPanelFragment extends QPublicBaseFragment implements MiniBoxHostEventProcessor.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RoundFrameLayout container;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String appId = "";

    private final Fragment ph(int page) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.domain = "qzone.qq.com";
        openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_MINI_GAME_VIRTUAL;
        openHippyInfo.url = qh(page);
        Bundle bundle = openHippyInfo.toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        CommonHippyFragment commonHippyFragment = new CommonHippyFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("params", bundle);
        commonHippyFragment.setArguments(bundle2);
        return commonHippyFragment;
    }

    private final String qh(int page) {
        if (page != 2) {
            if (page != 3) {
                return "";
            }
            return "/quit?appid=" + this.appId;
        }
        return "/?appid=" + this.appId;
    }

    private final void rh(int page) {
        FrameLayout.LayoutParams layoutParams;
        int i3;
        int i16;
        RoundFrameLayout roundFrameLayout = this.container;
        if (roundFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams2 = roundFrameLayout.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            int i17 = -1;
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            if (page != 2) {
                if (page == 3) {
                    layoutParams.width = ViewUtils.dpToPx(296.0f);
                    layoutParams.height = ViewUtils.dpToPx(228.0f);
                    layoutParams.gravity = 17;
                    roundFrameLayout.setCorners(15);
                    roundFrameLayout.setRadius(ViewUtils.dpToPx(10.0f));
                    return;
                }
                return;
            }
            if (this.isLandscape) {
                i3 = ViewUtils.dpToPx(375.0f);
            } else {
                i3 = -1;
            }
            layoutParams.width = i3;
            if (!this.isLandscape) {
                i17 = ViewUtils.dpToPx(510.0f);
            }
            layoutParams.height = i17;
            if (this.isLandscape) {
                i16 = 8388611;
            } else {
                i16 = 80;
            }
            layoutParams.gravity = i16;
            roundFrameLayout.setCorners(3);
            roundFrameLayout.setRadius(ViewUtils.dpToPx(10.0f));
        }
    }

    @Override // com.tencent.qq.minibox.proxy.MiniBoxHostEventProcessor.a
    public void Dd() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fhx;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setFlags(1024, 1024);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MiniBoxHostEventProcessor.f344586a.x(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle == null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        this.container = (RoundFrameLayout) view.findViewById(R.id.b8q);
        this.isLandscape = bundle.getBoolean("minibox_is_landscape", false);
        String string = bundle.getString("minibox_appid", "");
        Intrinsics.checkNotNullExpressionValue(string, "extras.getString(CommonConstant.KEY_APPID, \"\")");
        this.appId = string;
        int i3 = bundle.getInt("key_page_id", 0);
        rh(i3);
        getChildFragmentManager().beginTransaction().replace(R.id.b8q, ph(i3), "float_panel").commitAllowingStateLoss();
        MiniBoxHostEventProcessor.f344586a.f(this);
    }

    public final void sh(int page) {
        rh(page);
        getChildFragmentManager().beginTransaction().replace(R.id.b8q, ph(page), "float_panel").commitAllowingStateLoss();
    }
}
