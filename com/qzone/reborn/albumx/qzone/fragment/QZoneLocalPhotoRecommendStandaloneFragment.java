package com.qzone.reborn.albumx.qzone.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.util.SystemUtil;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/fragment/QZoneLocalPhotoRecommendStandaloneFragment;", "Lcom/qzone/common/activities/base/BaseFragment;", "", "yh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Bh", "uh", "initTitleBar", "wh", OcrConfig.CHINESE, "vh", "", "needAdjustImmersive", "needSupportFullScreen", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneLocalPhotoRecommendStandaloneFragment extends BaseFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(QZoneLocalPhotoRecommendStandaloneFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            i.y().c(context);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initTitleBar(View rootView) {
        wh(rootView);
        vh(rootView);
        zh(rootView);
    }

    private final void uh() {
        Window window;
        if (com.tencent.mobileqq.simpleui.b.c()) {
            com.tencent.mobileqq.simpleui.b.b(null, getActivity(), false, SimpleUIUtil.useDarkResource());
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                window.addFlags(67108864);
            }
            FragmentActivity activity2 = getActivity();
            ImmersiveUtils.clearCoverForStatus(activity2 != null ? activity2.getWindow() : null, true);
            SystemBarCompact systemBarCompact = new SystemBarCompact((Activity) getActivity(), true, getResources().getColor(R.color.qzone_skin_common_white2black_color));
            systemBarCompact.init();
            if (ImmersiveUtils.couldSetStatusTextColor()) {
                boolean z16 = !QQTheme.isNowThemeIsNightForQzone();
                FragmentActivity activity3 = getActivity();
                ImmersiveUtils.setStatusTextColor(z16, activity3 != null ? activity3.getWindow() : null);
                return;
            }
            systemBarCompact.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(QZoneLocalPhotoRecommendStandaloneFragment this$0, TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RDMEtraMsgCollector.getInstance().addNoramlClickAction(this$0.simpleClassname, textView);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void yh() {
        getChildFragmentManager().beginTransaction().add(R.id.jqa, new QZoneLocalPhotoRecommendFragment(), "QZoneLocalPhotoRecommendFragment").commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f1290551;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlbumPersonalizeManager.L().N();
        if (AlbumPersonalizeManager.L().Q()) {
            return;
        }
        if (AlbumPersonalizeManager.L().R()) {
            AlbumPersonalizeManager.L().O();
        } else {
            AlbumPersonalizeManager.L().N();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bh(view);
        initTitleBar(view);
        uh();
        yh();
    }

    private final void Bh(View rootView) {
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.jqh);
        ViewGroup viewGroup2 = (ViewGroup) rootView.findViewById(R.id.f166673ha1);
        ViewGroup viewGroup3 = (ViewGroup) rootView.findViewById(R.id.f166672ha0);
        int i3 = 0;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, ar.d(25.0f), 0, 0);
        }
        if (com.tencent.mobileqq.simpleui.b.c()) {
            viewGroup2.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
            viewGroup3.setBackgroundColor(SimpleUIUtil.getSimpleUiBgColor());
        } else {
            viewGroup2.setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_white2black_color));
            viewGroup3.setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_white2black_color));
        }
        viewGroup.setBackgroundColor(getResources().getColor(R.color.f158017al3));
        int notchHeight = SystemUtil.getNotchHeight(BaseApplication.getContext(), getActivity());
        if (notchHeight != 0) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = notchHeight;
                i3 = layoutParams2.height + notchHeight;
                viewGroup2.setLayoutParams(layoutParams2);
            }
            ViewGroup.LayoutParams layoutParams3 = viewGroup3.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                if (i3 == 0) {
                    i3 = getResources().getDimensionPixelSize(R.dimen.f9820e) + notchHeight;
                }
                layoutParams3.height = i3;
                viewGroup3.setLayoutParams(layoutParams3);
            }
        }
    }

    private final void vh(View rootView) {
        ((ViewStub) rootView.findViewById(R.id.ase)).inflate();
        TextView textView = (TextView) rootView.findViewById(R.id.hdf);
        textView.setText(R.string.gaw);
        if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
            textView.setTextColor(getResources().getColor(R.color.qzone_skin_album_main_text_color));
        } else {
            textView.setTextColor(getResources().getColor(R.color.f158017al3));
        }
    }

    private final void wh(View rootView) {
        final TextView textView = (TextView) rootView.findViewById(R.id.ivTitleBtnLeft);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzone.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneLocalPhotoRecommendStandaloneFragment.xh(QZoneLocalPhotoRecommendStandaloneFragment.this, textView, view);
            }
        });
        if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
            textView.setTextColor(getResources().getColor(R.color.black));
            textView.setBackgroundResource(R.drawable.hij);
        } else {
            textView.setTextColor(getResources().getColor(R.color.f158017al3));
            textView.setBackgroundResource(R.drawable.b5b);
        }
        AccessibilityUtil.p(textView, l.a(R.string.f2201668d));
    }

    private final void zh(View rootView) {
        ((ViewStub) rootView.findViewById(R.id.xz6)).inflate();
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f69883jy);
        if (!AlbumPersonalizeManager.L().P() && !AlbumPersonalizeManager.L().X()) {
            imageView.setImageResource(R.drawable.qui_question_mark_circle);
        } else {
            imageView.setImageResource(R.drawable.qui_question_mark_circle_icon_white);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzone.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneLocalPhotoRecommendStandaloneFragment.Ah(QZoneLocalPhotoRecommendStandaloneFragment.this, view);
            }
        });
        View findViewById = rootView.findViewById(R.id.dsj);
        if (findViewById != null) {
            findViewById.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).rightMargin = ar.d(4.0f);
            }
        }
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.dsr);
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(8);
    }
}
