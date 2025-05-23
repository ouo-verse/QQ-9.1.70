package com.tencent.state.square.components.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.map.MapViewConfigKt;
import com.tencent.state.perf.PerfMonitor;
import com.tencent.state.report.PerformanceReportConst;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.DebugPageType;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareGroupFragment;
import com.tencent.state.square.SquareGroupFragmentConfig;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.api.ISquarePttMessageService;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.components.SquareConfigHelper;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.databinding.VasSquareErrorViewBinding;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.square.like.ILikeDataChangeListener;
import com.tencent.state.square.like.LikeDataManager;
import com.tencent.state.square.tasks.SquareTaskSheet;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J&\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001f\u001a\u00020\u001aJ*\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020#H\u0016J,\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u00100\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020\u000fH\u0016J\u0016\u00102\u001a\u00020\r2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u000e\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u000fJ\u0010\u00106\u001a\u00020\r2\u0006\u00107\u001a\u000208H\u0002J\u000e\u00109\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010:\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001f\u001a\u00020\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFragComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "reporter", "Lcom/tencent/state/square/IReporter;", "selectDoubleClickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "changeSpeakerMode", "", "state", "", "fetchTaskRedPoint", "hideSpeakerMode", "initLike", "initReport", "initSquareView", "dataList", "", "Lcom/tencent/state/map/MapItem;", "isInit", "listener", "Lcom/tencent/state/map/IMapViewListener;", "initTitleBar", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "initialize", "mapViewListener", "onCenterScaled", "isScaleToCenter", "view", "Landroid/view/View;", "index", "", "data", NodeProps.ON_CLICK, "v", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentVisibilityChanged", "isVisible", "reportPageData", "list", "setTaskRedDotVisible", NodeProps.VISIBLE, "showServiceEndNotice", "context", "Landroid/content/Context;", "showSpeakerMode", "updateDataList", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFragComponent extends SquareBaseComponent implements View.OnClickListener {
    private static final String RULE_TEXT = "\u6b22\u8fce\u52a0\u5165\u52a8\u6001\u5e7f\u573a\uff08\u6d4b\u8bd5\u7248\uff09\u7528\u6237\u53cd\u9988QQ\u7fa4\uff1a295829816\n\n\u52a8\u6001\u5e7f\u573a\u662f\u57fa\u4e8e\u8d85\u7ea7QQ\u79c0\u5f62\u8c61\u53ca\u597d\u53cb\u52a8\u6001\u7684\u793e\u4ea4\u573a\u666f\u3002\u7528\u6237\u53ef\u4ee5\u5728\u8be5\u573a\u666f\u5185\u8bbe\u7f6e\u72b6\u6001\uff0c\u8ddf\u597d\u53cb\u804a\u5929\u3002\n\n\u52a8\u6001\u5e7f\u573a\u81f4\u529b\u4e8e\u63d0\u4f9b\u7eff\u8272\u5065\u5eb7\u7684\u4e92\u8054\u7f51\u73af\u5883\uff0c\u5021\u5bfc\u5065\u5eb7\u6587\u660e\u6c9f\u901a\uff0c\u5e73\u53f0\u4e25\u7981\u51fa\u73b0\u8fdd\u6cd5\u8fdd\u89c4\uff0c\u8272\u60c5\u4f4e\u4fd7\uff0c\u8fdd\u80cc\u793e\u4f1a\u516c\u4fd7\u826f\u5fb7\uff0c\u6076\u610f\u5f15\u6d41\u7b49\u4fe1\u606f\uff0c\u82e5\u6709\u53d1\u73b0\u8fdd\u89c4\u597d\u53cb\u8bf7\u53ca\u65f6\u4e3e\u62a5\uff0c\u5e73\u53f0\u5c06\u6309\u89c4\u5219\u8fdb\u884c\u8d26\u53f7\u51bb\u7ed3\u5904\u7f6e\uff0c\u53e6\u5916\u5927\u5bb6\u6ce8\u610f\u8d22\u4ea7\u5b89\u5168\uff0c\u8c28\u9632\u7f51\u7edc\u8bc8\u9a97\uff01";
    private static final String SERVICE_END_NOTICE = "\u5c0a\u656c\u7684\u7528\u6237\uff1a\n\u56e0\u4e1a\u52a1\u8c03\u6574\uff0c\u72b6\u6001\u5e7f\u573a\u529f\u80fd\u5c06\u4e8e2025\u5e742\u670818\u65e5\u6b63\u5f0f\u505c\u6b62\u8fd0\u8425\u3002\u5728\u6b64\u4e4b\u524d\uff0c\u60a8\u4ecd\u53ef\u4ee5\u6b63\u5e38\u4f7f\u7528\u8be5\u529f\u80fd\u3002\u7531\u6b64\u7ed9\u60a8\u5e26\u6765\u7684\u4e0d\u4fbf\u6211\u4eec\u6df1\u8868\u6b49\u610f\uff0c\u611f\u8c22\u60a8\u7684\u7406\u89e3\u548c\u652f\u6301\u3002";
    private static final String TAG = "Square_SquareFragComponent";
    private VasSquareFragmentSquareBinding binding;
    private MapViewConfig config = MapViewConfigKt.defaultMapConfig();
    private IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
    private final FastClickUtils selectDoubleClickUtils = new FastClickUtils(800);

    private final void changeSpeakerMode(boolean state) {
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding;
        Application application = Square.INSTANCE.getApplication();
        if (application == null || (vasSquareFragmentSquareBinding = this.binding) == null) {
            return;
        }
        if (state) {
            vasSquareFragmentSquareBinding.speakerPhoneImage.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i8g));
            TextView textView = vasSquareFragmentSquareBinding.speakerPhoneText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.speakerPhoneText");
            textView.setText(application.getString(R.string.f169748xd4));
            return;
        }
        vasSquareFragmentSquareBinding.speakerPhoneImage.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i8f));
        TextView textView2 = vasSquareFragmentSquareBinding.speakerPhoneText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.speakerPhoneText");
        textView2.setText(application.getString(R.string.f169747xd3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchTaskRedPoint() {
        Square.INSTANCE.getConfig().getObtainInstanceHelper().getSquareTaskService().getTaskRedPointFlag(21L, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$fetchTaskRedPoint$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                SquareFragComponent.this.setTaskRedDotVisible(z16);
            }
        });
    }

    private final void initLike() {
        ISquareViewUpdater updater;
        SquareView mapView = getMapView();
        if (mapView != null && (updater = mapView.getUpdater()) != null) {
            updater.updateMeLikeUnReadNum(LikeDataManager.INSTANCE.getLikeListInfo());
        }
        LikeDataManager.INSTANCE.addDataListener(new ILikeDataChangeListener() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$initLike$1
            @Override // com.tencent.state.square.like.ILikeDataChangeListener
            public void onDataChanged() {
                ISquareViewUpdater updater2;
                SquareView mapView2 = SquareFragComponent.this.getMapView();
                if (mapView2 == null || (updater2 = mapView2.getUpdater()) == null) {
                    return;
                }
                updater2.updateMeLikeUnReadNum(LikeDataManager.INSTANCE.getLikeListInfo());
            }
        });
    }

    private final void initReport(VasSquareFragmentSquareBinding binding) {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView = binding.taskButton;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.taskButton");
        squareReporter.setElementInfo(squareImageView, SquareReportConst.ElementId.ELEMENT_ID_SQUARE_TASK_ENTRY, new LinkedHashMap(), false, false);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        SquareImageView squareImageView2 = binding.back;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.back");
        squareReporter2.setElementInfo(squareImageView2, "em_zplan_back", new LinkedHashMap(), false, false);
        IReporter iReporter = this.reporter;
        SquareImageView squareImageView3 = binding.location;
        Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.location");
        iReporter.setElementInfo(squareImageView3, SquareReportConst.ElementId.ELEMENT_ID_LOCATION, new LinkedHashMap(), false, false);
    }

    private final void initSquareView(List<? extends MapItem> dataList, boolean isInit, IMapViewListener listener) {
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding != null) {
            if (dataList.isEmpty()) {
                VasSquareErrorViewBinding vasSquareErrorViewBinding = vasSquareFragmentSquareBinding.requestErrorBackground;
                Intrinsics.checkNotNullExpressionValue(vasSquareErrorViewBinding, "binding.requestErrorBackground");
                RelativeLayout mContainer = vasSquareErrorViewBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "binding.requestErrorBackground.root");
                mContainer.setVisibility(0);
                SquareBaseKt.getSquareLog().w(TAG, "initSquareView: dataList is empty.");
            } else {
                VasSquareErrorViewBinding vasSquareErrorViewBinding2 = vasSquareFragmentSquareBinding.requestErrorBackground;
                Intrinsics.checkNotNullExpressionValue(vasSquareErrorViewBinding2, "binding.requestErrorBackground");
                RelativeLayout mContainer2 = vasSquareErrorViewBinding2.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.requestErrorBackground.root");
                mContainer2.setVisibility(8);
            }
            SquareBaseKt.getSquareLog().i(TAG, "initSquareView: size=" + dataList.size() + ", calMapWidth=" + this.config.getMapWidth() + ", calMapHeight=" + this.config.getMapHeight());
            if (isInit) {
                vasSquareFragmentSquareBinding.squareView.initialize(dataList, this.config, listener);
            } else {
                vasSquareFragmentSquareBinding.squareView.reset(dataList, this.config, listener);
            }
            initLike();
        }
    }

    private final void initTitleBar(VasSquareFragmentSquareBinding binding, final Activity activity) {
        SquareGroupFragmentConfig squareGroupConfig;
        int statusBarHeight;
        RelativeLayout relativeLayout = binding.titleContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.titleContainer");
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            SquareGroupFragmentConfig squareGroupConfig2 = SquareBaseComponentKt.getSquareGroupConfig(this);
            if (squareGroupConfig2.getTitleTopMargin() != Integer.MIN_VALUE) {
                statusBarHeight = squareGroupConfig2.getTitleTopMargin();
            } else {
                statusBarHeight = SquareUtil.INSTANCE.getStatusBarHeight(activity) + ViewExtensionsKt.dip((Context) activity, 9.0f);
            }
            layoutParams2.topMargin = statusBarHeight;
        }
        VasBaseFragment parentFragment = getParentFragment();
        SquareGroupFragment squareGroupFragment = (SquareGroupFragment) (parentFragment instanceof SquareGroupFragment ? parentFragment : null);
        if (squareGroupFragment != null && (squareGroupConfig = squareGroupFragment.getSquareGroupConfig()) != null && squareGroupConfig.getEmbedOnlinePanel()) {
            SquareImageView squareImageView = binding.back;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.back");
            squareImageView.setVisibility(8);
            LinearLayout linearLayout = binding.logoContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.logoContainer");
            linearLayout.setVisibility(8);
        }
        binding.back.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$initTitleBar$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
                activity.onBackPressed();
            }
        });
        binding.squareRuleIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$initTitleBar$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Square.INSTANCE.getConfig().getCommonUtils().showDialog((Context) activity, "\u6b22\u8fce\u52a0\u5165\u52a8\u6001\u5e7f\u573a\uff08\u6d4b\u8bd5\u7248\uff09\u7528\u6237\u53cd\u9988QQ\u7fa4\uff1a295829816\n\n\u52a8\u6001\u5e7f\u573a\u662f\u57fa\u4e8e\u8d85\u7ea7QQ\u79c0\u5f62\u8c61\u53ca\u597d\u53cb\u52a8\u6001\u7684\u793e\u4ea4\u573a\u666f\u3002\u7528\u6237\u53ef\u4ee5\u5728\u8be5\u573a\u666f\u5185\u8bbe\u7f6e\u72b6\u6001\uff0c\u8ddf\u597d\u53cb\u804a\u5929\u3002\n\n\u52a8\u6001\u5e7f\u573a\u81f4\u529b\u4e8e\u63d0\u4f9b\u7eff\u8272\u5065\u5eb7\u7684\u4e92\u8054\u7f51\u73af\u5883\uff0c\u5021\u5bfc\u5065\u5eb7\u6587\u660e\u6c9f\u901a\uff0c\u5e73\u53f0\u4e25\u7981\u51fa\u73b0\u8fdd\u6cd5\u8fdd\u89c4\uff0c\u8272\u60c5\u4f4e\u4fd7\uff0c\u8fdd\u80cc\u793e\u4f1a\u516c\u4fd7\u826f\u5fb7\uff0c\u6076\u610f\u5f15\u6d41\u7b49\u4fe1\u606f\uff0c\u82e5\u6709\u53d1\u73b0\u8fdd\u89c4\u597d\u53cb\u8bf7\u53ca\u65f6\u4e3e\u62a5\uff0c\u5e73\u53f0\u5c06\u6309\u89c4\u5219\u8fdb\u884c\u8d26\u53f7\u51bb\u7ed3\u5904\u7f6e\uff0c\u53e6\u5916\u5927\u5bb6\u6ce8\u610f\u8d22\u4ea7\u5b89\u5168\uff0c\u8c28\u9632\u7f51\u7edc\u8bc8\u9a97\uff01", "\u6211\u77e5\u9053\u4e86", "\u5b89\u5168\u58f0\u660e", true, (Function0<Unit>) new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$initTitleBar$3.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        if (Square.INSTANCE.getConfig().isDebug()) {
            binding.location.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$initTitleBar$4
                /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
                
                    r0 = r1.this$0.getFragment();
                 */
                @Override // android.view.View.OnLongClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final boolean onLongClick(View view) {
                    VasBaseFragment fragment;
                    QPublicBaseFragment debugFragment = SquareBaseKt.getSquareCommon().getDebugFragment(DebugPageType.SQUARE);
                    if (debugFragment == null || fragment == null) {
                        return true;
                    }
                    fragment.pushFragment(debugFragment);
                    return true;
                }
            });
        }
    }

    private final void reportPageData(List<? extends MapItem> list) {
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        for (MapItem mapItem : list) {
            if (mapItem instanceof SquareAvatarItem) {
                i3++;
                int unReadCount = ((SquareAvatarItem) mapItem).getExtra().unReadCount();
                if (unReadCount > 0) {
                    i16++;
                    i17 += unReadCount;
                }
                if (mapItem.getIsFixed()) {
                    i27++;
                }
                if (((SquareAvatarItem) mapItem).isNearToMe()) {
                    i26++;
                }
            } else if (mapItem instanceof SquareTroopItem) {
                i18++;
                int unreadCount = ((SquareTroopItem) mapItem).getLastMsg().getUnreadCount();
                if (unreadCount > 0) {
                    i19++;
                    i17 += unreadCount;
                }
            }
        }
        IReporter iReporter = this.reporter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_FRIEND_NUM, Integer.valueOf(i3));
        linkedHashMap.put(SquareReportConst.Key.KEY_UNREAD_FRIEND_NUM, Integer.valueOf(i16));
        linkedHashMap.put("zplan_unread_message_number", Integer.valueOf(i17));
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(getActivity()));
        linkedHashMap.put(SquareReportConst.Key.KEY_TROOP_NUM, Integer.valueOf(i18));
        linkedHashMap.put(SquareReportConst.Key.KEY_TROOP_UNREAD_NUM, Integer.valueOf(i19));
        linkedHashMap.put(SquareReportConst.Key.KEY_FRIEND_NEAR_ME_NUMBER, Integer.valueOf(i26));
        linkedHashMap.put(SquareReportConst.Key.KEY_FRIEND_FIXED_NUMBER, Integer.valueOf(i27));
        Unit unit = Unit.INSTANCE;
        iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_SQUARE_DATA, linkedHashMap);
    }

    private final void showServiceEndNotice(Context context) {
        Square.INSTANCE.getConfig().getCommonUtils().showDialog(context, SERVICE_END_NOTICE, "\u6211\u77e5\u9053\u4e86", "\u516c\u544a", true, (Function0<Unit>) new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$showServiceEndNotice$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    public final void hideSpeakerMode() {
        RelativeLayout relativeLayout;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding == null || (relativeLayout = vasSquareFragmentSquareBinding.speaker) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    public final void initialize(MapViewConfig config, List<? extends MapItem> dataList, IMapViewListener mapViewListener) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(mapViewListener, "mapViewListener");
        this.config = config;
        SquareConfigHelper.INSTANCE.loadAndUpdateConfig();
        initSquareView(dataList, true, mapViewListener);
        reportPageData(dataList);
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PerfMonitor.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(PerfMonitor.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, PerfMonitor.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, PerfMonitor.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        PerfMonitor perfMonitor = (PerfMonitor) fragmentComponent;
        if (perfMonitor != null) {
            perfMonitor.exposureStep(PerformanceReportConst.Key.KEY_PERFORMANCE_FIRST_EXPOSURE_MAP_BASE_INIT);
        }
        fetchTaskRedPoint();
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(view, "view");
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding != null && (linearLayout2 = vasSquareFragmentSquareBinding.rbContainer) != null) {
            linearLayout2.setVisibility(isScaleToCenter ? 8 : 0);
        }
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding2 = this.binding;
        if (vasSquareFragmentSquareBinding2 == null || (linearLayout = vasSquareFragmentSquareBinding2.leftContainer) == null) {
            return;
        }
        linearLayout.setVisibility(isScaleToCenter ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ISquarePttMessageService pttMessageService;
        IMapViewManipulator manipulator;
        Map<String, Object> mutableMapOf;
        View view;
        VasSquareErrorViewBinding vasSquareErrorViewBinding;
        RelativeLayout mContainer;
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.qh9) {
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
            if (vasSquareFragmentSquareBinding != null && (vasSquareErrorViewBinding = vasSquareFragmentSquareBinding.requestErrorBackground) != null && (mContainer = vasSquareErrorViewBinding.getMContainer()) != null) {
                mContainer.setVisibility(8);
            }
            SquareFragment squareFragment = getSquareFragment();
            if (squareFragment != null) {
                squareFragment.refreshMapDataList();
                return;
            }
            return;
        }
        if (id5 == R.id.qpn) {
            if (new FastClickUtils(800L).isFastDoubleClick()) {
                return;
            }
            QBaseActivity activity = getActivity();
            if (activity != null) {
                final WeakReference weakReference = new WeakReference(this);
                SquareTaskSheet squareTaskSheet = new SquareTaskSheet(activity, 0);
                squareTaskSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.state.square.components.fragment.SquareFragComponent$onClick$1$1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        SquareFragComponent squareFragComponent = (SquareFragComponent) weakReference.get();
                        if (squareFragComponent != null) {
                            squareFragComponent.fetchTaskRedPoint();
                        }
                    }
                });
                squareTaskSheet.show();
            }
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding2 = this.binding;
            if (vasSquareFragmentSquareBinding2 != null) {
                int i3 = (vasSquareFragmentSquareBinding2 == null || (view = vasSquareFragmentSquareBinding2.taskRedDot) == null || !com.tencent.state.ViewExtensionsKt.isVisible(view)) ? 0 : 1;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                SquareImageView squareImageView = vasSquareFragmentSquareBinding2.taskButton;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "it.taskButton");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HAVE_RED_DOT, Integer.valueOf(i3)));
                squareReporter.reportEvent("clck", squareImageView, mutableMapOf);
                return;
            }
            return;
        }
        FragmentComponent fragmentComponent2 = null;
        if (id5 == R.id.f163453q71) {
            SquareView mapView = getMapView();
            if (mapView != null && (manipulator = mapView.getManipulator()) != null) {
                QBaseActivity activity2 = getActivity();
                IMapViewManipulator.DefaultImpls.locateToMe$default(manipulator, activity2 != null ? ViewExtensionsKt.dip((Context) activity2, 95) : 0, null, 2, null);
            }
            VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding3 = this.binding;
            if (vasSquareFragmentSquareBinding3 != null) {
                IReporter iReporter = this.reporter;
                SquareImageView squareImageView2 = vasSquareFragmentSquareBinding3.location;
                Intrinsics.checkNotNullExpressionValue(squareImageView2, "it.location");
                iReporter.reportEvent("clck", squareImageView2, new LinkedHashMap());
                return;
            }
            return;
        }
        if (id5 == R.id.qmr) {
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareServiceProvider.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareServiceProvider.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareServiceProvider.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareServiceProvider.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            SquareServiceProvider squareServiceProvider = (SquareServiceProvider) fragmentComponent;
            if (squareServiceProvider == null || (pttMessageService = squareServiceProvider.getPttMessageService()) == null) {
                return;
            }
            pttMessageService.updateSpeakPhone();
            changeSpeakerMode(pttMessageService.getLoudSpeakerState());
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VasSquareFragmentSquareBinding it = VasSquareFragmentSquareBinding.bind(v3);
        QBaseActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            initTitleBar(it, activity);
        }
        it.location.setOnClickListener(this);
        it.speaker.setOnClickListener(this);
        it.taskButton.setOnClickListener(this);
        VasSquareErrorViewBinding vasSquareErrorViewBinding = it.requestErrorBackground;
        Intrinsics.checkNotNullExpressionValue(vasSquareErrorViewBinding, "it.requestErrorBackground");
        vasSquareErrorViewBinding.getMContainer().setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        initReport(it);
        Context context = f16.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            showServiceEndNotice(context);
        }
        Unit unit = Unit.INSTANCE;
        this.binding = it;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentVisibilityChanged(FragmentManager fm5, Fragment f16, boolean isVisible) {
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(f16, "f");
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding == null || (relativeLayout = vasSquareFragmentSquareBinding.titleContainer) == null) {
            return;
        }
        relativeLayout.setVisibility(isVisible ? 0 : 8);
    }

    public final void setTaskRedDotVisible(boolean visible) {
        Map<String, Object> mutableMapOf;
        View view;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding = this.binding;
        if (vasSquareFragmentSquareBinding != null && (view = vasSquareFragmentSquareBinding.taskRedDot) != null) {
            com.tencent.state.ViewExtensionsKt.setVisibility(view, visible);
        }
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding2 = this.binding;
        if (vasSquareFragmentSquareBinding2 != null) {
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            SquareImageView squareImageView = vasSquareFragmentSquareBinding2.taskButton;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "it.taskButton");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HAVE_RED_DOT, Integer.valueOf(visible ? 1 : 0)));
            squareReporter.reportEvent("imp", squareImageView, mutableMapOf);
        }
    }

    public final void showSpeakerMode(boolean state) {
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding;
        Application application = Square.INSTANCE.getApplication();
        if (application == null || (vasSquareFragmentSquareBinding = this.binding) == null) {
            return;
        }
        if (state) {
            vasSquareFragmentSquareBinding.speakerPhoneImage.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i8g));
            TextView textView = vasSquareFragmentSquareBinding.speakerPhoneText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.speakerPhoneText");
            textView.setText(application.getString(R.string.f169748xd4));
        } else {
            vasSquareFragmentSquareBinding.speakerPhoneImage.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i8f));
            TextView textView2 = vasSquareFragmentSquareBinding.speakerPhoneText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.speakerPhoneText");
            textView2.setText(application.getString(R.string.f169747xd3));
        }
        RelativeLayout relativeLayout = vasSquareFragmentSquareBinding.speaker;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.speaker");
        relativeLayout.setVisibility(0);
    }

    public final void updateDataList(MapViewConfig config, List<? extends MapItem> dataList, IMapViewListener mapViewListener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(mapViewListener, "mapViewListener");
        this.config = config;
        initSquareView(dataList, false, mapViewListener);
        reportPageData(dataList);
    }
}
