package com.tencent.mobileqq.wink.live;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.live.WinkLiveCameraFragment;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/live/WinkLiveCameraFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "Landroid/view/View;", "view", "", "uh", "", "elementId", "rh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "xc", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mBgView", "<init>", "()V", "D", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLiveCameraFragment extends QPublicBaseFragment implements FragmentPager.d {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView mBgView;

    private final void rh(View view, String elementId) {
        if (view != null && !TextUtils.isEmpty(elementId)) {
            VideoReport.setElementId(view, elementId);
            VideoReport.setElementParams(view, WinkDTParamBuilder.buildElementParams());
        } else {
            QLog.d("WinkLiveCameraFragment", 1, "dtReportBindViewData, null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(WinkLiveCameraFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(WinkLiveCameraFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("source", "3");
            intent.putExtra("source", 3);
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterAnchorPrepareFragment(activity, intent);
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void uh(View view) {
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, WinkDaTongReportConstant.PageId.PG_XSJ_LIVE_STREAM_START);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void X9(@NotNull String str, boolean z16) {
        FragmentPager.d.a.a(this, str, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hf5, container, false);
        this.mBgView = (ImageView) inflate.findViewById(R.id.f635833x);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/8918/qqlive/qvideo_qqlive_offline_bg.jpg").setTargetView(this.mBgView));
        View findViewById = inflate.findViewById(R.id.dum);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: j83.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkLiveCameraFragment.sh(WinkLiveCameraFragment.this, view);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.uvs);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: j83.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkLiveCameraFragment.th(WinkLiveCameraFragment.this, view);
            }
        });
        uh(inflate);
        rh(findViewById, "em_xsj_close_button");
        rh(findViewById2, WinkDaTongReportConstant.ElementId.EM_XSJ_ENTRY_LIVE_BUTTON);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
