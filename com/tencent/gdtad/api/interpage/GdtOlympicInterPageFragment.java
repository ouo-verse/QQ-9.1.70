package com.tencent.gdtad.api.interpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdStatusBarUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.interpage.GdtOlympicInterPageFragment;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.video.GdtVideoView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import fm0.i;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r71.b;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/gdtad/api/interpage/GdtOlympicInterPageFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Bh", "initViews", "vh", "xh", "", "reportCode", OcrConfig.CHINESE, "Ah", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "", "needImmersive", "needStatusTrans", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "Lr71/b;", BdhLogUtil.LogTag.Tag_Conn, "Lr71/b;", "mBinding", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "D", "Lcom/tencent/gdtad/views/video/GdtVideoView;", "mVideoView", "E", "I", "mScreenWidth", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "mVideoUrl", "G", "mImageUrl", "Lcom/tencent/ad/tangram/util/AdClickUtil$Params;", "H", "Lcom/tencent/ad/tangram/util/AdClickUtil$Params;", "mClickParams", "<init>", "()V", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtOlympicInterPageFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private b mBinding;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GdtVideoView mVideoView;

    /* renamed from: E, reason: from kotlin metadata */
    private int mScreenWidth;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String mVideoUrl;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mImageUrl;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AdClickUtil.Params mClickParams;

    private final void Ah() {
        GdtLog.i("GdtOlympicInterPageFragment", "[doClick]");
        AdClickUtil.Params params = this.mClickParams;
        if (params == null) {
            GdtLog.i("GdtOlympicInterPageFragment", "[doClick] params error");
            zh(3);
        } else {
            AdClickUtil.handleOlympicInterPageJump(params);
            zh(5);
        }
    }

    private final void Bh() {
        String str;
        String str2;
        Intent intent;
        Intent intent2;
        Intent intent3;
        GdtLog.i("GdtOlympicInterPageFragment", "[initViewData]");
        FragmentActivity activity = getActivity();
        GdtHandler.Options options = null;
        if (activity != null && (intent3 = activity.getIntent()) != null) {
            str = intent3.getStringExtra("keyOlympicVideoUrl");
        } else {
            str = null;
        }
        this.mVideoUrl = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
            str2 = intent2.getStringExtra("keyOlympicImageUrl");
        } else {
            str2 = null;
        }
        this.mImageUrl = str2;
        AdClickUtil.Params params = new AdClickUtil.Params();
        try {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null && (intent = activity3.getIntent()) != null) {
                options = (GdtHandler.Options) intent.getParcelableExtra("key_options");
            }
        } catch (Throwable th5) {
            GdtLog.e("GdtOlympicInterPageFragment", "[doClick] ", th5);
        }
        GdtHandler.fillClickUtilParamsFromOptions(options, params);
        params.activity = new WeakReference<>(getActivity());
        params.reportForClick = false;
        this.mClickParams = params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(GdtOlympicInterPageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.zh(4);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(GdtOlympicInterPageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(GdtOlympicInterPageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(GdtOlympicInterPageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Gh(int reportCode) {
        Ad ad5;
        Context context = getContext();
        AdClickUtil.Params params = this.mClickParams;
        if (params != null) {
            ad5 = params.f61334ad;
        } else {
            ad5 = null;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, gdt_analysis_event.EVENT_OLYMPIC_INTER_PAGE_CLOSE, ad5);
        Intrinsics.checkNotNullExpressionValue(createEventForAd, "createEventForAd(\n      \u2026ClickParams?.ad\n        )");
        createEventForAd.actionId = reportCode;
        i.INSTANCE.b(new WeakReference<>(getContext()), createEventForAd);
    }

    private final void initViews() {
        String str;
        if (this.mBinding == null) {
            GdtLog.e("GdtOlympicInterPageFragment", "[initViews] binding not initialized");
            zh(1);
            return;
        }
        GdtLog.i("GdtOlympicInterPageFragment", "[initViews]");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(-1);
        obtain.mFailedDrawable = new ColorDrawable(-1);
        try {
            str = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("gdtad_olympic_interpage_background", "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/QQmobile/%E8%83%8C%E6%99%AF%E5%9B%BE%E7%89%87.png");
        } catch (Throwable th5) {
            GdtLog.e("GdtOlympicInterPageFragment", "[initViews] ", th5);
            str = "";
        }
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        b bVar = this.mBinding;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bVar = null;
        }
        bVar.f430916b.setImageDrawable(drawable);
        b bVar3 = this.mBinding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bVar3 = null;
        }
        bVar3.f430919e.setOnClickListener(new View.OnClickListener() { // from class: fm0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GdtOlympicInterPageFragment.Ch(GdtOlympicInterPageFragment.this, view);
            }
        });
        b bVar4 = this.mBinding;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bVar4 = null;
        }
        bVar4.f430918d.setOnClickListener(new View.OnClickListener() { // from class: fm0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GdtOlympicInterPageFragment.Dh(GdtOlympicInterPageFragment.this, view);
            }
        });
        b bVar5 = this.mBinding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bVar5 = null;
        }
        bVar5.f430917c.setOnClickListener(new View.OnClickListener() { // from class: fm0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GdtOlympicInterPageFragment.Eh(GdtOlympicInterPageFragment.this, view);
            }
        });
        b bVar6 = this.mBinding;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bVar2 = bVar6;
        }
        bVar2.f430916b.setOnClickListener(new View.OnClickListener() { // from class: fm0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GdtOlympicInterPageFragment.Fh(GdtOlympicInterPageFragment.this, view);
            }
        });
        if (!TextUtils.isEmpty(this.mVideoUrl)) {
            xh();
        } else {
            vh();
        }
    }

    private final void vh() {
        if (this.mBinding == null) {
            GdtLog.e("GdtOlympicInterPageFragment", "[addImageView] binding not initialized");
            zh(1);
            return;
        }
        if (this.mScreenWidth <= 0) {
            GdtLog.e("GdtOlympicInterPageFragment", "[addImageView] with error");
            zh(2);
            return;
        }
        GdtLog.i("GdtOlympicInterPageFragment", "[addImageView]");
        if (TextUtils.isEmpty(this.mImageUrl)) {
            GdtLog.i("GdtOlympicInterPageFragment", "[addImageView] mImageUrl is empty");
        }
        b bVar = this.mBinding;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bVar = null;
        }
        ImageView imageView = new ImageView(bVar.getRoot().getContext());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: fm0.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GdtOlympicInterPageFragment.wh(GdtOlympicInterPageFragment.this, view);
            }
        });
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        imageView.setImageDrawable(URLDrawable.getDrawable(this.mImageUrl, obtain));
        b bVar3 = this.mBinding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bVar2 = bVar3;
        }
        LinearLayout linearLayout = bVar2.f430920f;
        int i3 = this.mScreenWidth;
        linearLayout.addView(imageView, 1, new ViewGroup.LayoutParams(i3, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(GdtOlympicInterPageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void xh() {
        Ad ad5;
        GdtAd gdtAd;
        if (this.mBinding == null) {
            GdtLog.e("GdtOlympicInterPageFragment", "[addVideoView] binding not initialized");
            zh(1);
            return;
        }
        if (this.mScreenWidth <= 0) {
            GdtLog.e("GdtOlympicInterPageFragment", "[addImageView] with error");
            zh(2);
            return;
        }
        GdtLog.i("GdtOlympicInterPageFragment", "[addVideoView]");
        GdtVideoData gdtVideoData = new GdtVideoData();
        gdtVideoData.setCoverUrl(this.mImageUrl);
        gdtVideoData.setUrl(this.mVideoUrl);
        gdtVideoData.setLoop(true);
        gdtVideoData.setVolumOpen(false);
        gdtVideoData.setVisibleDirectPlay(true);
        AdClickUtil.Params params = this.mClickParams;
        b bVar = null;
        if (params != null) {
            ad5 = params.f61334ad;
        } else {
            ad5 = null;
        }
        if (ad5 instanceof GdtAd) {
            gdtAd = (GdtAd) ad5;
        } else {
            gdtAd = null;
        }
        gdtVideoData.setAd(gdtAd);
        gdtVideoData.setVideoDefaultBackgroundColor(0);
        b bVar2 = this.mBinding;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bVar2 = null;
        }
        GdtVideoView gdtVideoView = new GdtVideoView(bVar2.getRoot().getContext(), gdtVideoData);
        this.mVideoView = gdtVideoView;
        gdtVideoView.setOnClickListener(new View.OnClickListener() { // from class: fm0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GdtOlympicInterPageFragment.yh(GdtOlympicInterPageFragment.this, view);
            }
        });
        b bVar3 = this.mBinding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bVar = bVar3;
        }
        LinearLayout linearLayout = bVar.f430920f;
        GdtVideoView gdtVideoView2 = this.mVideoView;
        int i3 = this.mScreenWidth;
        linearLayout.addView(gdtVideoView2, 1, new ViewGroup.LayoutParams(i3, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GdtOlympicInterPageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void zh(int reportCode) {
        GdtLog.i("GdtOlympicInterPageFragment", "[close]");
        Gh(reportCode);
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th5) {
            GdtLog.e("GdtOlympicInterPageFragment", "[close]", th5);
        }
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
                GdtLog.e("GdtOlympicInterPageFragment", "[initWindowStyleAndAnimation]", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        b g16 = b.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.mBinding = g16;
        this.mScreenWidth = GdtUIUtils.getScreenWidth(g16.getRoot().getContext());
        FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GdtLog.i("GdtOlympicInterPageFragment", "[onDestroy]");
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.stop(false, true);
        }
        GdtVideoView gdtVideoView2 = this.mVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.destroy();
        }
        this.mVideoView = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        GdtLog.i("GdtOlympicInterPageFragment", "[onPause]");
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.setVideoViewVisible(false);
        }
        GdtVideoView gdtVideoView2 = this.mVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.pause(false);
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        GdtLog.i("GdtOlympicInterPageFragment", "[onResume]");
        super.onResume();
        GdtVideoView gdtVideoView = this.mVideoView;
        if (gdtVideoView != null) {
            gdtVideoView.setVideoViewVisible(true);
        }
        GdtVideoView gdtVideoView2 = this.mVideoView;
        if (gdtVideoView2 != null) {
            gdtVideoView2.play(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bh();
        initViews();
    }
}
