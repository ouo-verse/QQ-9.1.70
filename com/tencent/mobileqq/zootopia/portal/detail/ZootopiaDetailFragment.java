package com.tencent.mobileqq.zootopia.portal.detail;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.portal.detail.events.ZootopiaDetailFragmentCloseEvent;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailFloatBar;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.view.pull2refresh.RecyclerViewWithHeaderFooterFix;
import com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import zb3.ZootopiaMapCommentResp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002`aB\u0007\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0012\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020&H\u0002J\u0018\u0010)\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020,H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00101\u001a\u000200H\u0002R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u00105\u001a\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u0002000W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020[0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010Y\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment;", "Lcom/tencent/mobileqq/zootopia/portal/detail/IZootopiaDetailFragment;", "Lcom/tencent/widget/pull2refresh/anim/IAnimManager$OnRefreshPullDistanceListener;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView$c;", "Landroid/view/View$OnClickListener;", "", "getSubSource", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView;", "recyclerView", "", "isMachineRefresh", "xe", "", "reqType", "J3", "endOfRefresh", Element.ELEMENT_NAME_DISTANCE, "touchMode", "onPullDistance", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressedEvent", "target", "qi", "ci", "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Uh", "Vh", "ei", "di", "Landroid/support/v7/widget/RecyclerView;", "fi", "Lcom/tencent/mobileqq/zootopia/portal/detail/an;", "Yh", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "Wh", "Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "P", "Lkotlin/Lazy;", "bi", "()Lcom/tencent/mobileqq/zootopia/portal/detail/am;", "vm", "Loa4/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Zh", "()Loa4/a;", "mapResVm", "Lcom/tencent/mobileqq/zootopia/portal/detail/c;", BdhLogUtil.LogTag.Tag_Req, "Xh", "()Lcom/tencent/mobileqq/zootopia/portal/detail/c;", "adapter", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", ExifInterface.LATITUDE_SOUTH, "ai", "()Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailHeaderView;", "T", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailHeaderView;", "headerView", "Lfi3/q;", "U", "Lfi3/q;", "binding", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", "V", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", DownloadInfo.spKey_Config, "W", "Z", "needAutoDownload", "Landroidx/lifecycle/Observer;", "X", "Landroidx/lifecycle/Observer;", "statusObserver", "", "Y", "progressObserver", "<init>", "()V", "a", "Config", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDetailFragment extends IZootopiaDetailFragment implements IAnimManager.OnRefreshPullDistanceListener, XPullToRefreshView.c, View.OnClickListener {

    /* renamed from: Z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy mapResVm;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: S, reason: from kotlin metadata */
    private final Lazy reportHelper;

    /* renamed from: T, reason: from kotlin metadata */
    private ZootopiaDetailHeaderView headerView;

    /* renamed from: U, reason: from kotlin metadata */
    private fi3.q binding;

    /* renamed from: V, reason: from kotlin metadata */
    private Config config;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean needAutoDownload;

    /* renamed from: X, reason: from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Observer<Float> progressObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u00c6\u0003Jn\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\u000fH\u00d6\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", "Ljava/io/Serializable;", "source", "", "needBack", "", "enablePullRefresh", FavEmoConstant.ROAMING_TYPE_PANEL, "buttonStatus", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonProgress", "", "needAnimation", "ueParams", "", "", "", "(IZZZLcom/tencent/sqshow/zootopia/data/ButtonStatus;Ljava/lang/Float;ZLjava/util/Map;)V", "getButtonProgress", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getButtonStatus", "()Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "getEnablePullRefresh", "()Z", "getNeedAnimation", "getNeedBack", "getNeedDownload", "getSource", "()I", "getUeParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IZZZLcom/tencent/sqshow/zootopia/data/ButtonStatus;Ljava/lang/Float;ZLjava/util/Map;)Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", "equals", "other", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final /* data */ class Config implements Serializable {
        private final Float buttonProgress;
        private final ButtonStatus buttonStatus;
        private final boolean enablePullRefresh;
        private final boolean needAnimation;
        private final boolean needBack;
        private final boolean needDownload;
        private final int source;
        private final Map<String, Object> ueParams;

        public Config() {
            this(0, false, false, false, null, null, false, null, 255, null);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSource() {
            return this.source;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getNeedBack() {
            return this.needBack;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getEnablePullRefresh() {
            return this.enablePullRefresh;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getNeedDownload() {
            return this.needDownload;
        }

        /* renamed from: component5, reason: from getter */
        public final ButtonStatus getButtonStatus() {
            return this.buttonStatus;
        }

        /* renamed from: component6, reason: from getter */
        public final Float getButtonProgress() {
            return this.buttonProgress;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getNeedAnimation() {
            return this.needAnimation;
        }

        public final Map<String, Object> component8() {
            return this.ueParams;
        }

        public final Config copy(int source, boolean needBack, boolean enablePullRefresh, boolean needDownload, ButtonStatus buttonStatus, Float buttonProgress, boolean needAnimation, Map<String, ? extends Object> ueParams) {
            Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
            return new Config(source, needBack, enablePullRefresh, needDownload, buttonStatus, buttonProgress, needAnimation, ueParams);
        }

        public final Float getButtonProgress() {
            return this.buttonProgress;
        }

        public final ButtonStatus getButtonStatus() {
            return this.buttonStatus;
        }

        public final boolean getEnablePullRefresh() {
            return this.enablePullRefresh;
        }

        public final boolean getNeedAnimation() {
            return this.needAnimation;
        }

        public final boolean getNeedBack() {
            return this.needBack;
        }

        public final boolean getNeedDownload() {
            return this.needDownload;
        }

        public final int getSource() {
            return this.source;
        }

        public final Map<String, Object> getUeParams() {
            return this.ueParams;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.source * 31;
            boolean z16 = this.needBack;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (i3 + i16) * 31;
            boolean z17 = this.enablePullRefresh;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            boolean z18 = this.needDownload;
            int i26 = z18;
            if (z18 != 0) {
                i26 = 1;
            }
            int hashCode = (((i19 + i26) * 31) + this.buttonStatus.hashCode()) * 31;
            Float f16 = this.buttonProgress;
            int hashCode2 = (hashCode + (f16 == null ? 0 : f16.hashCode())) * 31;
            boolean z19 = this.needAnimation;
            int i27 = (hashCode2 + (z19 ? 1 : z19 ? 1 : 0)) * 31;
            Map<String, Object> map = this.ueParams;
            return i27 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            return "Config(source=" + this.source + ", needBack=" + this.needBack + ", enablePullRefresh=" + this.enablePullRefresh + ", needDownload=" + this.needDownload + ", buttonStatus=" + this.buttonStatus + ", buttonProgress=" + this.buttonProgress + ", needAnimation=" + this.needAnimation + ", ueParams=" + this.ueParams + ")";
        }

        public Config(int i3, boolean z16, boolean z17, boolean z18, ButtonStatus buttonStatus, Float f16, boolean z19, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
            this.source = i3;
            this.needBack = z16;
            this.enablePullRefresh = z17;
            this.needDownload = z18;
            this.buttonStatus = buttonStatus;
            this.buttonProgress = f16;
            this.needAnimation = z19;
            this.ueParams = map;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.source == config.source && this.needBack == config.needBack && this.enablePullRefresh == config.enablePullRefresh && this.needDownload == config.needDownload && this.buttonStatus == config.buttonStatus && Intrinsics.areEqual((Object) this.buttonProgress, (Object) config.buttonProgress) && this.needAnimation == config.needAnimation && Intrinsics.areEqual(this.ueParams, config.ueParams);
        }

        public /* synthetic */ Config(int i3, boolean z16, boolean z17, boolean z18, ButtonStatus buttonStatus, Float f16, boolean z19, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? true : z16, (i16 & 4) == 0 ? z17 : true, (i16 & 8) != 0 ? false : z18, (i16 & 16) != 0 ? ButtonStatus.INIT : buttonStatus, (i16 & 32) != 0 ? null : f16, (i16 & 64) == 0 ? z19 : false, (i16 & 128) == 0 ? map : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$a;", "", "", "mapId", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "source", "Lcom/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment;", "a", "", "TAG", "Ljava/lang/String;", "ZOOTOPIA_DETAIL_CONFIG", "ZOOTOPIA_MAP_INFO", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ZootopiaDetailFragment a(int mapId, Config config, FragmentSource source) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(source, "source");
            ZootopiaDetailFragment zootopiaDetailFragment = new ZootopiaDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("mapId", mapId);
            bundle.putSerializable("detail_config", config);
            bundle.putSerializable(ZootopiaSource.KEY_FRAGMENT_SOURCE, source);
            zootopiaDetailFragment.setArguments(bundle);
            return zootopiaDetailFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328704a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ButtonStatus.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f328704a = iArr;
        }
    }

    public ZootopiaDetailFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<am>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment$vm$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$vm$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements ViewModelProvider.Factory {
                a() {
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(Class<T> modelClass) {
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    return new am(new ai(1));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final am invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(ZootopiaDetailFragment.this, new a()).get(am.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ailViewModel::class.java)");
                return (am) viewModel;
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment$mapResVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(ZootopiaDetailFragment.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResVm = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.portal.detail.c>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                Context requireContext = ZootopiaDetailFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new c(requireContext);
            }
        });
        this.adapter = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ah>() { // from class: com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment$reportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ah invoke() {
                Context requireContext = ZootopiaDetailFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new ah(requireContext);
            }
        });
        this.reportHelper = lazy4;
        this.config = new Config(0, false, false, false, null, null, false, null, 255, null);
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragment.ri(ZootopiaDetailFragment.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragment.pi(ZootopiaDetailFragment.this, (Float) obj);
            }
        };
    }

    private final void Uh(ZootopiaMapDetail detail) {
        ZootopiaDetailFloatBar zootopiaDetailFloatBar;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar2;
        ZootopiaDownloadButton btnDownload;
        ZootopiaDetailHeaderView zootopiaDetailHeaderView = this.headerView;
        if (zootopiaDetailHeaderView == null) {
            return;
        }
        zootopiaDetailHeaderView.getBtnEnter().setButtonStatusListener(Yh(detail));
        Zh().M1(String.valueOf(detail.getId()));
        LiveData<ButtonStatus> P1 = Zh().P1(String.valueOf(detail.getId()));
        if (P1 != null) {
            P1.removeObserver(this.statusObserver);
            P1.observe(getViewLifecycleOwner(), this.statusObserver);
        }
        LiveData<Float> O1 = Zh().O1(String.valueOf(detail.getId()));
        if (O1 != null) {
            O1.removeObserver(this.progressObserver);
            O1.observe(getViewLifecycleOwner(), this.progressObserver);
        }
        if (ZPlanCloudGameInfo.INSTANCE.a(detail.getCloudGameInfo())) {
            zootopiaDetailHeaderView.getBtnEnter().setIsInitCloudModType(true);
            ZootopiaDownloadButton btnEnter = zootopiaDetailHeaderView.getBtnEnter();
            ButtonStatus buttonStatus = ButtonStatus.CLOUD_GAME;
            btnEnter.setStatus(buttonStatus);
            fi3.q qVar = this.binding;
            if (qVar != null && (zootopiaDetailFloatBar2 = qVar.f399329g) != null && (btnDownload = zootopiaDetailFloatBar2.getBtnDownload()) != null) {
                btnDownload.setIsInitCloudModType(true);
            }
            fi3.q qVar2 = this.binding;
            ZootopiaDownloadButton btnDownload2 = (qVar2 == null || (zootopiaDetailFloatBar = qVar2.f399329g) == null) ? null : zootopiaDetailFloatBar.getBtnDownload();
            if (btnDownload2 == null) {
                return;
            }
            btnDownload2.setStatus(buttonStatus);
        }
    }

    private final void Vh(ZootopiaMapDetail detail, View view) {
        fi3.q qVar = this.binding;
        if (qVar == null) {
            return;
        }
        ZootopiaDetailFloatBar zootopiaDetailFloatBar = qVar.f399329g;
        zootopiaDetailFloatBar.setMapDetailData(detail);
        ZootopiaMapDetail value = bi().R1().getValue();
        if (!(value != null && value.getQqVersionTipsCode() == 0)) {
            ZootopiaMapDetail value2 = bi().R1().getValue();
            if (!(value2 != null && value2.getMapVersionTipsCode() == 0)) {
                zootopiaDetailFloatBar.setSizeTextVisible(8);
            }
        }
        qVar.f399329g.getBtnDownload().setButtonStatusListener(Yh(detail));
        qVar.f399329g.getBtnDownload().setStatusText(ButtonStatus.LOADED, detail.getButtonText());
    }

    private final boolean Wh(ButtonStatus buttonStatus) {
        int i3 = b.f328704a[buttonStatus.ordinal()];
        return i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5;
    }

    private final com.tencent.mobileqq.zootopia.portal.detail.c Xh() {
        return (com.tencent.mobileqq.zootopia.portal.detail.c) this.adapter.getValue();
    }

    private final an Yh(ZootopiaMapDetail detail) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new an(requireContext, detail, Zh(), Ch(), this.config.getUeParams());
    }

    private final oa4.a Zh() {
        return (oa4.a) this.mapResVm.getValue();
    }

    private final ah ai() {
        return (ah) this.reportHelper.getValue();
    }

    private final am bi() {
        return (am) this.vm.getValue();
    }

    private final void ci() {
        am bi5 = bi();
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("ZOOTOPIA_MAP_INFO") : null;
        bi5.f2(serializable instanceof ZootopiaMapSimpleInfo ? (ZootopiaMapSimpleInfo) serializable : null);
        am bi6 = bi();
        Bundle arguments2 = getArguments();
        bi6.e2(arguments2 != null ? arguments2.getInt("mapId", 0) : 0);
        bi().b2();
        Bundle arguments3 = getArguments();
        Serializable serializable2 = arguments3 != null ? arguments3.getSerializable("detail_config") : null;
        Config config = serializable2 instanceof Config ? (Config) serializable2 : null;
        if (config == null) {
            config = new Config(0, false, false, false, null, null, false, null, 255, null);
        }
        this.config = config;
    }

    private final void di() {
        ZootopiaDetailFloatBar zootopiaDetailFloatBar;
        ZootopiaDownloadButton btnDownload;
        ZootopiaDownloadButton btnEnter;
        ZootopiaDetailHeaderView zootopiaDetailHeaderView = this.headerView;
        if (zootopiaDetailHeaderView != null && (btnEnter = zootopiaDetailHeaderView.getBtnEnter()) != null) {
            btnEnter.setCloudModButtonStyle(s84.b.f433495a.a(3));
        }
        fi3.q qVar = this.binding;
        if (qVar == null || (zootopiaDetailFloatBar = qVar.f399329g) == null || (btnDownload = zootopiaDetailFloatBar.getBtnDownload()) == null) {
            return;
        }
        btnDownload.setCloudModButtonStyle(s84.b.f433495a.a(2));
    }

    private final void ei() {
        fi3.q qVar = this.binding;
        if (qVar == null) {
            return;
        }
        LoadingMoreHelper D = qVar.f399330h.D();
        if (D != null) {
            D.setPreLoaderCount(12);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        RecyclerViewWithHeaderFooterFix E = qVar.f399330h.E();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ZootopiaDetailHeaderView zootopiaDetailHeaderView = new ZootopiaDetailHeaderView(requireContext, this, bi(), this.config.getButtonStatus(), this.config.getButtonProgress(), Dh());
        this.headerView = zootopiaDetailHeaderView;
        E.addHeaderView(zootopiaDetailHeaderView);
        ZootopiaDetailHeaderView zootopiaDetailHeaderView2 = this.headerView;
        if (zootopiaDetailHeaderView2 != null) {
            Intrinsics.checkNotNull(zootopiaDetailHeaderView2);
            ViewCompat.setTransitionName(zootopiaDetailHeaderView2, "zootopia_share_bg");
        }
        E.setLayoutManager(linearLayoutManager);
        E.setAdapter(Xh());
        E.setItemAnimator(null);
        E.addOnScrollListener(new c());
        ZootopiaPullRefreshLayout zootopiaPullRefreshLayout = qVar.f399330h;
        zootopiaPullRefreshLayout.setOnRefreshPullDistanceListener(this);
        zootopiaPullRefreshLayout.setRefreshCallback(this);
        zootopiaPullRefreshLayout.setHeaderNightStyle(true);
        zootopiaPullRefreshLayout.K();
        Config config = this.config;
        zootopiaPullRefreshLayout.setRefreshEnable(config != null ? config.getEnablePullRefresh() : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(RecyclerView recyclerView) {
        ZootopiaDetailHeaderView zootopiaDetailHeaderView;
        ZootopiaDownloadButton btnEnter;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar2;
        ZootopiaDownloadButton btnDownload;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar3;
        ZootopiaDetailFloatBar zootopiaDetailFloatBar4;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if ((linearLayoutManager != null ? linearLayoutManager.findFirstVisibleItemPosition() : -1) == 0 && (zootopiaDetailHeaderView = this.headerView) != null) {
            if (!zootopiaDetailHeaderView.y()) {
                fi3.q qVar = this.binding;
                if ((qVar == null || (zootopiaDetailFloatBar4 = qVar.f399329g) == null || !zootopiaDetailFloatBar4.k()) ? false : true) {
                    ah ai5 = ai();
                    fi3.q qVar2 = this.binding;
                    ZootopiaDownloadButton btnDownload2 = (qVar2 == null || (zootopiaDetailFloatBar3 = qVar2.f399329g) == null) ? null : zootopiaDetailFloatBar3.getBtnDownload();
                    fi3.q qVar3 = this.binding;
                    ButtonStatus status = (qVar3 == null || (zootopiaDetailFloatBar2 = qVar3.f399329g) == null || (btnDownload = zootopiaDetailFloatBar2.getBtnDownload()) == null) ? null : btnDownload.getStatus();
                    ZootopiaMapDetail value = bi().R1().getValue();
                    ai5.h(btnDownload2, status, value != null ? value.getReserveItem() : null);
                    return;
                }
                return;
            }
            fi3.q qVar4 = this.binding;
            if ((qVar4 == null || (zootopiaDetailFloatBar = qVar4.f399329g) == null || !zootopiaDetailFloatBar.i()) ? false : true) {
                ah ai6 = ai();
                ZootopiaDetailHeaderView zootopiaDetailHeaderView2 = this.headerView;
                ZootopiaDownloadButton btnEnter2 = zootopiaDetailHeaderView2 != null ? zootopiaDetailHeaderView2.getBtnEnter() : null;
                ZootopiaDetailHeaderView zootopiaDetailHeaderView3 = this.headerView;
                ButtonStatus status2 = (zootopiaDetailHeaderView3 == null || (btnEnter = zootopiaDetailHeaderView3.getBtnEnter()) == null) ? null : btnEnter.getStatus();
                ZootopiaMapDetail value2 = bi().R1().getValue();
                ai6.h(btnEnter2, status2, value2 != null ? value2.getReserveItem() : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(ZootopiaDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bi().b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(ZootopiaDetailFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDetailHeaderView zootopiaDetailHeaderView = this$0.headerView;
        Intrinsics.checkNotNull(zootopiaDetailHeaderView, "null cannot be cast to non-null type android.view.View");
        this$0.qi(zootopiaDetailHeaderView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(ZootopiaDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaActivity.Companion companion = ZootopiaActivity.INSTANCE;
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ZootopiaActivity.Companion.c(companion, requireContext, ZootopiaDownloadManagerFragment.class, this$0.Ch(), null, false, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(fi3.q binding, Integer count) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullExpressionValue(count, "count");
        if (count.intValue() > 0) {
            binding.f399326d.setText(String.valueOf(count));
            binding.f399326d.setVisibility(0);
        } else {
            binding.f399326d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(fi3.q binding, Integer downloadingCount) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullExpressionValue(downloadingCount, "downloadingCount");
        if (downloadingCount.intValue() > 0) {
            binding.f399328f.setVisibility(8);
            binding.f399327e.setVisibility(0);
        } else {
            binding.f399327e.setVisibility(8);
            binding.f399328f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(fi3.q binding, ZootopiaDetailFragment this$0, View view, ZootopiaMapDetail zootopiaMapDetail) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (binding.f399331i.getVisibility() == 0) {
            binding.f399331i.setVisibility(8);
        }
        if (zootopiaMapDetail != null) {
            binding.f399332j.setVisibility(8);
            binding.f399330h.G(!zootopiaMapDetail.g().isEmpty());
            this$0.Xh().getDataList().clear();
            this$0.Xh().fillList(zootopiaMapDetail.g());
            this$0.Uh(zootopiaMapDetail);
            this$0.Vh(zootopiaMapDetail, view);
            binding.f399330h.s(true);
            binding.f399330h.F(true, zootopiaMapDetail.g().size() == 3);
            binding.f399330h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(final fi3.q binding, final ZootopiaDetailFragment this$0, final ZootopiaMapCommentResp zootopiaMapCommentResp) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        binding.f399330h.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.detail.f
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDetailFragment.ni(ZootopiaDetailFragment.this, zootopiaMapCommentResp, binding);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(ZootopiaDetailFragment this$0, ZootopiaMapCommentResp zootopiaMapCommentResp, fi3.q binding) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        this$0.Xh().appendList(zootopiaMapCommentResp.a());
        binding.f399330h.F(true, zootopiaMapCommentResp.getHasMore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(fi3.q binding, ZootopiaDetailFragment this$0, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (binding.f399331i.getVisibility() == 0) {
            binding.f399331i.setVisibility(8);
        }
        binding.f399332j.setVisibility(0);
        if (errorMessage != null) {
            QLog.d("ZootopiaDetailFragment", 1, "errorMessage:" + errorMessage);
            binding.f399330h.s(false);
            QQToast.makeText(this$0.getActivity(), 1, "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(ZootopiaDetailFragment this$0, Float it) {
        ZootopiaDetailFloatBar zootopiaDetailFloatBar;
        ZootopiaDownloadButton btnDownload;
        ZootopiaDownloadButton btnEnter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDetailHeaderView zootopiaDetailHeaderView = this$0.headerView;
        if (zootopiaDetailHeaderView != null && (btnEnter = zootopiaDetailHeaderView.getBtnEnter()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            btnEnter.setProcess(it.floatValue());
        }
        fi3.q qVar = this$0.binding;
        if (qVar == null || (zootopiaDetailFloatBar = qVar.f399329g) == null || (btnDownload = zootopiaDetailFloatBar.getBtnDownload()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        btnDownload.setProcess(it.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(ZootopiaDetailFragment this$0, ButtonStatus it) {
        ZootopiaDownloadButton btnEnter;
        ZootopiaDownloadButton btnEnter2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fi3.q qVar = this$0.binding;
        if (qVar == null) {
            return;
        }
        ZootopiaDetailHeaderView zootopiaDetailHeaderView = this$0.headerView;
        if (zootopiaDetailHeaderView != null && (btnEnter2 = zootopiaDetailHeaderView.getBtnEnter()) != null && btnEnter2.getIsInitCloudModType()) {
            ZootopiaDownloadButtonBinder.Companion companion = ZootopiaDownloadButtonBinder.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (companion.a(it)) {
                QLog.i("ZootopiaDetailFragmentV2", 1, "update to cloud mod status, origin: " + it);
                ButtonStatus buttonStatus = ButtonStatus.CLOUD_GAME;
                btnEnter2.setStatus(buttonStatus);
                qVar.f399329g.getBtnDownload().setStatus(buttonStatus);
                return;
            }
        }
        ZootopiaDetailHeaderView zootopiaDetailHeaderView2 = this$0.headerView;
        if (zootopiaDetailHeaderView2 != null && (btnEnter = zootopiaDetailHeaderView2.getBtnEnter()) != null) {
            btnEnter.B();
        }
        qVar.f399329g.getBtnDownload().B();
        ZootopiaDetailHeaderView zootopiaDetailHeaderView3 = this$0.headerView;
        ZootopiaDownloadButton btnEnter3 = zootopiaDetailHeaderView3 != null ? zootopiaDetailHeaderView3.getBtnEnter() : null;
        if (btnEnter3 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            btnEnter3.setStatus(it);
        }
        ZootopiaDownloadButton btnDownload = qVar.f399329g.getBtnDownload();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        btnDownload.setStatus(it);
        if (qVar.f399329g.g()) {
            qVar.f399329g.setSizeTextVisible(0);
        } else {
            qVar.f399329g.setSizeTextVisible(8);
        }
        if (this$0.needAutoDownload && this$0.Wh(it)) {
            this$0.needAutoDownload = false;
            ZootopiaMapSimpleInfo mapItemInfo = this$0.bi().getMapItemInfo();
            if (mapItemInfo != null) {
                oa4.a.X1(this$0.Zh(), mapItemInfo, false, 2, null);
                return;
            }
            ZootopiaMapDetail value = this$0.bi().R1().getValue();
            if (value != null) {
                oa4.a.W1(this$0.Zh(), value, false, 2, null);
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void J3(XPullToRefreshView recyclerView, int reqType) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        bi().a2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_MAP_DETAIL;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            if (supportFragmentManager.getFragments().size() > 1) {
                com.tencent.mobileqq.zootopia.api.b backListener = getBackListener();
                if (backListener != null) {
                    backListener.onBackPressedEvent();
                }
                SimpleEventBus.getInstance().dispatchEvent(new ZootopiaDetailFragmentCloseEvent(bi().T1(), Ch(), true));
            } else {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        onBackPressedEvent();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new Fade());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        fi3.q g16 = fi3.q.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.widget.pull2refresh.anim.IAnimManager.OnRefreshPullDistanceListener
    public void onPullDistance(int distance, int touchMode) {
        ZootopiaDetailHeaderView zootopiaDetailHeaderView = this.headerView;
        if (zootopiaDetailHeaderView != null) {
            zootopiaDetailHeaderView.A(distance);
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        int T1;
        int T12;
        String name;
        String name2;
        Intrinsics.checkNotNullParameter(view, "view");
        final fi3.q qVar = this.binding;
        if (qVar == null) {
            return;
        }
        ci();
        ei();
        di();
        if (this.config.getNeedBack()) {
            qVar.f399324b.setVisibility(0);
            qVar.f399324b.setOnClickListener(this);
        } else {
            qVar.f399324b.setVisibility(8);
        }
        qVar.f399332j.getBtnNetworkError().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZootopiaDetailFragment.gi(ZootopiaDetailFragment.this, view2);
            }
        });
        if (this.config.getNeedAnimation()) {
            ZootopiaDetailHeaderView zootopiaDetailHeaderView = this.headerView;
            if (zootopiaDetailHeaderView != null) {
                zootopiaDetailHeaderView.setTranslationY(100.0f);
            }
            ZootopiaDetailHeaderView zootopiaDetailHeaderView2 = this.headerView;
            if (zootopiaDetailHeaderView2 != null) {
                zootopiaDetailHeaderView2.setAlpha(0.0f);
            }
            ZootopiaDetailHeaderView zootopiaDetailHeaderView3 = this.headerView;
            if (zootopiaDetailHeaderView3 != null) {
                zootopiaDetailHeaderView3.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.portal.detail.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZootopiaDetailFragment.hi(ZootopiaDetailFragment.this);
                    }
                });
            }
        }
        qVar.f399325c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.detail.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZootopiaDetailFragment.ii(ZootopiaDetailFragment.this, view2);
            }
        });
        if (bi().getMapItemInfo() == null) {
            qVar.f399330h.setVisibility(4);
            qVar.f399331i.setVisibility(0);
        }
        vc3.g gVar = vc3.g.f441394a;
        Context context = getContext();
        ImageView imageView = qVar.f399327e;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.btnDownloadDynamicIcon");
        gVar.c(context, "ZootopiaDetailDownload", imageView);
        Zh().N1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragment.ji(fi3.q.this, (Integer) obj);
            }
        });
        Zh().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragment.ki(fi3.q.this, (Integer) obj);
            }
        });
        bi().R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragment.li(fi3.q.this, this, view, (ZootopiaMapDetail) obj);
            }
        });
        bi().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragment.mi(fi3.q.this, this, (ZootopiaMapCommentResp) obj);
            }
        });
        bi().S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.detail.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDetailFragment.oi(fi3.q.this, this, (ErrorMessage) obj);
            }
        });
        this.needAutoDownload = this.config.getNeedDownload();
        ah ai5 = ai();
        ZootopiaMapSimpleInfo mapItemInfo = bi().getMapItemInfo();
        if (mapItemInfo != null) {
            T1 = mapItemInfo.getMapID();
        } else {
            T1 = bi().T1();
        }
        int i3 = T1;
        ZootopiaMapSimpleInfo mapItemInfo2 = bi().getMapItemInfo();
        ah.f(ai5, view, i3, (mapItemInfo2 == null || (name2 = mapItemInfo2.getName()) == null) ? "" : name2, Dh(), null, 16, null);
        ZootopiaDetailHeaderView zootopiaDetailHeaderView4 = this.headerView;
        ZootopiaMapSimpleInfo mapItemInfo3 = bi().getMapItemInfo();
        if (mapItemInfo3 != null) {
            T12 = mapItemInfo3.getMapID();
        } else {
            T12 = bi().T1();
        }
        int i16 = T12;
        ZootopiaMapSimpleInfo mapItemInfo4 = bi().getMapItemInfo();
        ah.f(ai5, zootopiaDetailHeaderView4, i16, (mapItemInfo4 == null || (name = mapItemInfo4.getName()) == null) ? "" : name, Dh(), null, 16, null);
        ZootopiaDetailHeaderView zootopiaDetailHeaderView5 = this.headerView;
        ah.c(ai5, zootopiaDetailHeaderView5 != null ? zootopiaDetailHeaderView5.getBtnEnter() : null, false, true, 2, null);
        ah.c(ai5, qVar.f399329g.getBtnDownload(), false, false, 6, null);
        ai5.b(qVar.f399328f, true, true);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void xe(XPullToRefreshView recyclerView, boolean isMachineRefresh) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        bi().b2();
    }

    private final void qi(View target) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(target, "translationY", 100.0f, 0.0f);
        ofFloat.setDuration(600L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(target, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new PathInterpolator(0.28f, 0.03f, 0.25f, 1.0f));
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
        SimpleEventBus.getInstance().dispatchEvent(new ZootopiaDetailFragmentCloseEvent(bi().T1(), Ch(), false, 4, null));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/ZootopiaDetailFragment$c", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            if (recyclerView == null) {
                return;
            }
            ZootopiaDetailFragment.this.fi(recyclerView);
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView.c
    public void endOfRefresh() {
    }
}
