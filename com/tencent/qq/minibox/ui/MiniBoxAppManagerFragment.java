package com.tencent.qq.minibox.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.minibox.contract.LaunchAppInfo;
import com.tencent.minibox.contract.LaunchExtInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qq.minibox.event.CloseLoadingPageEvent;
import com.tencent.qq.minibox.manager.MiniBoxDownloadTask;
import com.tencent.qq.minibox.ui.adapter.MiniBoxAppManagerAdapter;
import com.tencent.qq.minibox.ui.adapter.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$GetAllVMAppInfoRsp;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$VMAppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u008a\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008b\u0001B\t\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u0016\u0010 \u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH\u0002J\u0016\u0010\"\u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H\u0002J \u0010(\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010%\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010%\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J \u0010.\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u000200H\u0002J\u0012\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000102H\u0016J$\u00105\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u001a\u00106\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u000200H\u0016J\b\u0010:\u001a\u000200H\u0016J\b\u0010;\u001a\u000200H\u0016J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020#H\u0016J \u0010?\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010>\u001a\u00020&H\u0016J \u0010@\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010>\u001a\u00020&H\u0016J \u0010A\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010>\u001a\u00020&H\u0016J \u0010B\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020&H\u0016J \u0010C\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020&H\u0016R\u0016\u0010F\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010N\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010IR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010[R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010[R\u0018\u0010n\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010[R\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010pR\u0016\u0010v\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010x\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010uR\u0016\u0010z\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010uR\u0016\u0010|\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010uR\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0087\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bu\u0010\u0086\u0001\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/qq/minibox/ui/MiniBoxAppManagerFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter$c;", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "task", "", "Rh", "Vh", "Jh", "Th", "ai", "Wh", "Lcom/tencent/trpcprotocol/minibox/basicinfo/VMBasicInfo$GetAllVMAppInfoRsp;", "rsp", "Lh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Oh", "Xh", "Yh", "Zh", "Mh", "", "Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", "installedApps", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "Dh", "", "managerAppInfoList", "Hh", Constants.Raft.TASKS, "Sh", "Landroid/view/View;", "view", "appInfo", "", com.tencent.luggage.wxa.c8.c.G, "Ih", "Lcom/tencent/trpcprotocol/minibox/basicinfo/VMBasicInfo$VMAppInfo;", "Kh", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", OcrConfig.CHINESE, "Gh", "Qh", "Eh", "", "Ch", "Landroid/os/Bundle;", mqq.app.Constants.FILE_INSTANCE_STATE, "onCreate", "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onDestroyView", "isWrapContent", "needImmersive", "needStatusTrans", "v", NodeProps.ON_CLICK, "position", "Ae", "I8", "k4", "W6", "td", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "mRvRecommend", "E", "mRvAppManagerLoading", UserInfo.SEX_FEMALE, "mRvAppManagerLoaded", "Lcom/tencent/qq/minibox/ui/adapter/b;", "G", "Lcom/tencent/qq/minibox/ui/adapter/b;", "mRecommendAdapter", "Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter;", "H", "Lcom/tencent/qq/minibox/ui/adapter/MiniBoxAppManagerAdapter;", "mAppManagerLoadedAdapter", "I", "mAppManagerLoadingAdapter", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "mLayoutEmpty", "K", "mLayoutAppManager", "Landroid/widget/FrameLayout;", "L", "Landroid/widget/FrameLayout;", "mLayoutLoad", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "mIconReturn", "Landroidx/core/widget/NestedScrollView;", "N", "Landroidx/core/widget/NestedScrollView;", "mSvMainPage", "P", "layoutLabelLoaded", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "layoutLabelLoading", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/List;", "mLoadedAppList", ExifInterface.LATITUDE_SOUTH, "mDownloadingAppList", "T", "Z", "hasReqRecommendData", "U", "isEmptyPage", "V", "isGetMiniBoxAppDone", "W", "isGetWadlAppDone", "", "X", "Ljava/lang/String;", "mLoadingPckName", "Lls3/c;", "Y", "Lls3/c;", "mDownloadAction", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandle", "<init>", "()V", "a0", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxAppManagerFragment extends QPublicBaseFragment implements View.OnClickListener, MiniBoxAppManagerAdapter.c {

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView mRvRecommend;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView mRvAppManagerLoading;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView mRvAppManagerLoaded;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qq.minibox.ui.adapter.b mRecommendAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MiniBoxAppManagerAdapter mAppManagerLoadedAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private MiniBoxAppManagerAdapter mAppManagerLoadingAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLayoutEmpty;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLayoutAppManager;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mLayoutLoad;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ImageView mIconReturn;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private NestedScrollView mSvMainPage;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private LinearLayout layoutLabelLoaded;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private LinearLayout layoutLabelLoading;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean hasReqRecommendData;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isEmptyPage;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isGetMiniBoxAppDone;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isGetWadlAppDone;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final ls3.c mDownloadAction;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandle;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private List<VirtualAppInfo> mLoadedAppList = new CopyOnWriteArrayList();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final List<MiniBoxDownloadTask> mDownloadingAppList = new CopyOnWriteArrayList();

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String mLoadingPckName = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002M\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ#\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/qq/minibox/ui/MiniBoxAppManagerFragment$b", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errCode", "", "errMsg", "", "Lcom/tencent/qq/minibox/constants/MiniBoxCallback;", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements Function3<Boolean, Integer, String, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VirtualAppInfo f344639d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MiniBoxAppManagerFragment f344640e;

        b(VirtualAppInfo virtualAppInfo, MiniBoxAppManagerFragment miniBoxAppManagerFragment) {
            this.f344639d = virtualAppInfo;
            this.f344640e = miniBoxAppManagerFragment;
        }

        public void a(boolean isSuccess, int errCode, @Nullable String errMsg) {
            String str = "1";
            WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9040").setBussinessId("1").setPageId("969").setOperId("209762").setModuleType("904007").setOperType("20").setExt(6, "1");
            if (!isSuccess) {
                str = "0";
            }
            ext.setExt(7, str).report();
            us3.q.f440003a.k(this.f344639d.getAppId(), this.f344639d.getPackageName());
            this.f344640e.Th();
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
            a(bool.booleanValue(), num.intValue(), str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qq/minibox/ui/MiniBoxAppManagerFragment$c", "Lqs3/a;", "Lqs3/d;", "ssoResponse", "", "q7", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements qs3.a {
        c() {
        }

        @Override // qs3.a
        public void q7(@NotNull qs3.d ssoResponse) {
            Intrinsics.checkNotNullParameter(ssoResponse, "ssoResponse");
            QLog.d("MiniBoxAppManagerFragment", 2, "getAllVMAppInfo isSuccess = " + ssoResponse.c());
            if (ssoResponse.c()) {
                try {
                    VMBasicInfo$GetAllVMAppInfoRsp vMBasicInfo$GetAllVMAppInfoRsp = new VMBasicInfo$GetAllVMAppInfoRsp();
                    vMBasicInfo$GetAllVMAppInfoRsp.mergeFrom(ssoResponse.getData());
                    MiniBoxAppManagerFragment.this.Lh(vMBasicInfo$GetAllVMAppInfoRsp);
                } catch (Exception e16) {
                    QLog.e("MiniBoxAppManagerFragment", 1, "getAllVMAppInfo failed", e16);
                }
            }
        }
    }

    public MiniBoxAppManagerFragment() {
        ls3.c cVar = new ls3.c();
        this.mDownloadAction = cVar;
        cVar.a(new MiniBoxAppManagerFragment$1$1(this));
        cVar.h(new MiniBoxAppManagerFragment$1$2(this));
        this.mHandle = new Handler(new Handler.Callback() { // from class: com.tencent.qq.minibox.ui.s
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean Ph;
                Ph = MiniBoxAppManagerFragment.Ph(MiniBoxAppManagerFragment.this, message);
                return Ph;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(MiniBoxAppManagerFragment this$0, VirtualAppInfo appInfo, DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        this$0.Eh(appInfo);
        dialog1.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(MiniBoxAppManagerFragment this$0, DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        this$0.Gh();
        dialog1.dismiss();
    }

    private final boolean Ch() {
        boolean z16;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        if (getActivity() != null && !activity.isFinishing() && isAdded()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        QLog.e("MiniBoxAppManagerFragment", 1, ">>>Activity is not Exit", new Throwable());
        return false;
    }

    private final List<VirtualAppInfo> Dh(List<MiniBoxAppInfo> installedApps) {
        if (installedApps != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<MiniBoxAppInfo> it = installedApps.iterator();
            while (it.hasNext()) {
                VirtualAppInfo a16 = us3.i.f439988a.a(it.next());
                if (a16 != null) {
                    arrayList.add(a16);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private final void Eh(VirtualAppInfo appInfo) {
        if (Intrinsics.areEqual(this.mLoadingPckName, appInfo.getPackageName())) {
            SimpleEventBus.getInstance().dispatchEvent(new CloseLoadingPageEvent());
        }
        if (appInfo.getGameState() == 3) {
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).uninstallVirtualApp(appInfo.getPackageName(), new b(appInfo, this));
            return;
        }
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9040").setBussinessId("1").setPageId("969").setOperId("209762").setModuleType("904007").setOperType("20").setExt(6, "1").setExt(7, "1").report();
        this.mDownloadAction.d(appInfo.getPackageName());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qq.minibox.ui.w
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxAppManagerFragment.Fh(MiniBoxAppManagerFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(MiniBoxAppManagerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Th();
    }

    private final void Gh() {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9040").setBussinessId("1").setPageId("969").setOperId("209762").setModuleType("904007").setOperType("20").setExt(6, "1").setExt(7, "2").report();
    }

    private final void Hh(List<MiniBoxDownloadTask> managerAppInfoList) {
        List<MiniBoxDownloadTask> list = managerAppInfoList;
        ArrayList<VirtualAppInfo> arrayList = new ArrayList(list);
        if (!arrayList.isEmpty()) {
            for (VirtualAppInfo virtualAppInfo : arrayList) {
                Iterator<VirtualAppInfo> it = this.mLoadedAppList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().getPackageName(), virtualAppInfo.getPackageName())) {
                        TypeIntrinsics.asMutableCollection(list).remove(virtualAppInfo);
                        this.mDownloadAction.d(virtualAppInfo.getPackageName());
                    }
                }
            }
        }
    }

    private final void Ih(View view, VirtualAppInfo appInfo, int pos) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9040").setBussinessId("1").setPageId("969").setOperId("209762").setModuleType("904007").setOperType("20").setExt(6, "3").report();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            boolean z16 = true;
            if (appInfo.getGameState() == 3) {
                String b16 = us3.q.f440003a.b(appInfo.getPackageName());
                if (b16.length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(BaseApplication.getContext(), b16, "", "", 0, null);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                LaunchAppInfo launchAppInfo = new LaunchAppInfo();
                launchAppInfo.setAppId(appInfo.getAppId());
                launchAppInfo.setAppVersion(appInfo.getVersionCode());
                launchAppInfo.setLaunchTime(currentTimeMillis);
                launchAppInfo.setPackageName(appInfo.getPackageName());
                launchAppInfo.setLaunch(new LaunchExtInfo(appInfo.getScene(), appInfo.getVia(), appInfo.getReportData()));
                MiniBoxSDK.launchApp(launchAppInfo);
                return;
            }
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).startVirtualApp(activity, appInfo, 1);
        }
    }

    private final void Jh() {
        if (this.isGetWadlAppDone && this.isGetMiniBoxAppDone) {
            FrameLayout frameLayout = this.mLayoutLoad;
            Intrinsics.checkNotNull(frameLayout);
            frameLayout.setVisibility(8);
            if (this.mLoadedAppList.isEmpty() && this.mDownloadingAppList.isEmpty()) {
                Xh();
            } else {
                Yh();
                Zh();
            }
        }
    }

    private final void Kh(VMBasicInfo$VMAppInfo appInfo) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(BaseApplication.getContext(), appInfo.app_id.get(), "", "", 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(VMBasicInfo$GetAllVMAppInfoRsp rsp) {
        List<VMBasicInfo$VMAppInfo> appList = rsp.info_list.get();
        QLog.d("MiniBoxAppManagerFragment", 2, "handleRecommendAppRsp: appSize = " + appList.size());
        Intrinsics.checkNotNullExpressionValue(appList, "appList");
        if (!appList.isEmpty()) {
            com.tencent.qq.minibox.ui.adapter.b bVar = this.mRecommendAdapter;
            if (bVar != null) {
                bVar.m0(appList);
            }
            ai();
        }
    }

    private final void Mh() {
        this.mAppManagerLoadedAdapter = new MiniBoxAppManagerAdapter();
        this.mAppManagerLoadingAdapter = new MiniBoxAppManagerAdapter();
        RecyclerView recyclerView = this.mRvRecommend;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvRecommend");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        RecyclerView recyclerView3 = this.mRvAppManagerLoaded;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoaded");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        RecyclerView recyclerView4 = this.mRvAppManagerLoading;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoading");
            recyclerView4 = null;
        }
        recyclerView4.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        com.tencent.qq.minibox.ui.adapter.b bVar = new com.tencent.qq.minibox.ui.adapter.b();
        bVar.l0(new b.a() { // from class: com.tencent.qq.minibox.ui.r
            @Override // com.tencent.qq.minibox.ui.adapter.b.a
            public final void a(View view, VMBasicInfo$VMAppInfo vMBasicInfo$VMAppInfo, int i3) {
                MiniBoxAppManagerFragment.Nh(MiniBoxAppManagerFragment.this, view, vMBasicInfo$VMAppInfo, i3);
            }
        });
        this.mRecommendAdapter = bVar;
        RecyclerView recyclerView5 = this.mRvRecommend;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvRecommend");
            recyclerView5 = null;
        }
        recyclerView5.setAdapter(this.mRecommendAdapter);
        RecyclerView recyclerView6 = this.mRvAppManagerLoaded;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoaded");
            recyclerView6 = null;
        }
        recyclerView6.setAdapter(this.mAppManagerLoadedAdapter);
        RecyclerView recyclerView7 = this.mRvAppManagerLoading;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoading");
        } else {
            recyclerView2 = recyclerView7;
        }
        recyclerView2.setAdapter(this.mAppManagerLoadingAdapter);
        MiniBoxAppManagerAdapter miniBoxAppManagerAdapter = this.mAppManagerLoadedAdapter;
        if (miniBoxAppManagerAdapter != null) {
            miniBoxAppManagerAdapter.y0(this);
        }
        MiniBoxAppManagerAdapter miniBoxAppManagerAdapter2 = this.mAppManagerLoadingAdapter;
        if (miniBoxAppManagerAdapter2 != null) {
            miniBoxAppManagerAdapter2.z0(this.mDownloadAction);
        }
        MiniBoxAppManagerAdapter miniBoxAppManagerAdapter3 = this.mAppManagerLoadingAdapter;
        if (miniBoxAppManagerAdapter3 != null) {
            miniBoxAppManagerAdapter3.y0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(MiniBoxAppManagerFragment this$0, View view, VMBasicInfo$VMAppInfo appInfo, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(appInfo, "appInfo");
        this$0.Kh(appInfo);
    }

    private final void Oh(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fhm, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026anager, container, false)");
        this.mRootView = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        this.mLayoutEmpty = (LinearLayout) inflate.findViewById(R.id.e3f);
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById = view2.findViewById(R.id.f791448z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.rv_recommend)");
        this.mRvRecommend = (RecyclerView) findViewById;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.f792649a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026v_virtual_manager_loaded)");
        this.mRvAppManagerLoaded = (RecyclerView) findViewById2;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.f792749b);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026_virtual_manager_loading)");
        this.mRvAppManagerLoading = (RecyclerView) findViewById3;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        this.layoutLabelLoaded = (LinearLayout) view5.findViewById(R.id.yem);
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view6 = null;
        }
        this.layoutLabelLoading = (LinearLayout) view6.findViewById(R.id.yen);
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view7 = null;
        }
        this.mLayoutAppManager = (LinearLayout) view7.findViewById(R.id.ydm);
        View view8 = this.mRootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view8 = null;
        }
        this.mIconReturn = (ImageView) view8.findViewById(R.id.xkf);
        View view9 = this.mRootView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view9 = null;
        }
        this.mSvMainPage = (NestedScrollView) view9.findViewById(R.id.f9100540);
        ImageView imageView = this.mIconReturn;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        View view10 = this.mRootView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view10;
        }
        this.mLayoutLoad = (FrameLayout) view.findViewById(R.id.e46);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ph(MiniBoxAppManagerFragment this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this$0.Ch();
        int i3 = msg2.what;
        if (i3 != 100) {
            if (i3 == 101) {
                this$0.isGetWadlAppDone = true;
                this$0.Jh();
                return false;
            }
            return false;
        }
        this$0.isGetMiniBoxAppDone = true;
        this$0.Jh();
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxAppManagerFragment", 1, "start queryDownloadTask");
        }
        this$0.mDownloadAction.g();
        return false;
    }

    private final void Qh(View view, VirtualAppInfo appInfo, int pos) {
        zh(appInfo).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(MiniBoxDownloadTask task) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxAppManagerFragment", 1, "-->onDownloadStatusChanged " + task.getPackageName() + TokenParser.SP + task.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(List<MiniBoxDownloadTask> tasks) {
        List<MiniBoxDownloadTask> mutableList;
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxAppManagerFragment", 1, "--->onQueryDownloadTask");
        }
        this.mDownloadingAppList.clear();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) tasks);
        Hh(mutableList);
        this.mDownloadingAppList.addAll(mutableList);
        Zh();
        Message obtain = Message.obtain();
        obtain.what = 101;
        this.mHandle.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        if (QLog.isColorLevel()) {
            QLog.d("MiniBoxAppManagerFragment", 1, "start queryMiniBoxData");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.ui.t
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxAppManagerFragment.Uh(MiniBoxAppManagerFragment.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(MiniBoxAppManagerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<MiniBoxAppInfo> installedApps = MiniBoxSDK.getInstalledApps();
        if (installedApps != null) {
            this$0.mLoadedAppList.clear();
            this$0.mLoadedAppList.addAll(this$0.Dh(installedApps));
        }
        Message obtain = Message.obtain();
        obtain.what = 100;
        obtain.obj = installedApps;
        this$0.mHandle.sendMessage(obtain);
    }

    private final void Vh() {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9040").setBussinessId("1").setPageId("969").setOperId("209761").setModuleType("904007").setOperType("8").report();
    }

    private final void Wh() {
        rs3.d dVar = new rs3.d(5, 0, 2, null);
        QLog.d("MiniBoxAppManagerFragment", 2, "requestRecommendAppList");
        qs3.c.f429464a.d(dVar, new c());
    }

    private final void Xh() {
        this.isEmptyPage = true;
        LinearLayout linearLayout = this.mLayoutEmpty;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this.mLayoutAppManager;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(8);
        NestedScrollView nestedScrollView = this.mSvMainPage;
        Intrinsics.checkNotNull(nestedScrollView);
        nestedScrollView.scrollTo(0, 0);
        ai();
    }

    private final void Yh() {
        LinearLayout linearLayout = this.mLayoutEmpty;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.mLayoutAppManager;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        RecyclerView recyclerView = null;
        if (this.mLoadedAppList.isEmpty()) {
            LinearLayout linearLayout3 = this.layoutLabelLoaded;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            RecyclerView recyclerView2 = this.mRvAppManagerLoaded;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoaded");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
        } else {
            LinearLayout linearLayout4 = this.layoutLabelLoaded;
            Intrinsics.checkNotNull(linearLayout4);
            linearLayout4.setVisibility(0);
            RecyclerView recyclerView3 = this.mRvAppManagerLoaded;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoaded");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(0);
            MiniBoxAppManagerAdapter miniBoxAppManagerAdapter = this.mAppManagerLoadedAdapter;
            Intrinsics.checkNotNull(miniBoxAppManagerAdapter);
            miniBoxAppManagerAdapter.A0(this.mLoadedAppList);
        }
        if (this.isEmptyPage) {
            NestedScrollView nestedScrollView = this.mSvMainPage;
            if (nestedScrollView != null) {
                nestedScrollView.scrollTo(0, 0);
            }
            this.isEmptyPage = false;
        }
    }

    private final void Zh() {
        List<MiniBoxDownloadTask> mutableList;
        LinearLayout linearLayout = this.mLayoutEmpty;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.mLayoutAppManager;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setVisibility(0);
        RecyclerView recyclerView = null;
        if (this.mDownloadingAppList.size() == 0) {
            LinearLayout linearLayout3 = this.layoutLabelLoading;
            Intrinsics.checkNotNull(linearLayout3);
            linearLayout3.setVisibility(8);
            RecyclerView recyclerView2 = this.mRvAppManagerLoading;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoading");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
        } else {
            LinearLayout linearLayout4 = this.layoutLabelLoading;
            Intrinsics.checkNotNull(linearLayout4);
            linearLayout4.setVisibility(0);
            RecyclerView recyclerView3 = this.mRvAppManagerLoading;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRvAppManagerLoading");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(0);
            MiniBoxAppManagerAdapter miniBoxAppManagerAdapter = this.mAppManagerLoadingAdapter;
            Intrinsics.checkNotNull(miniBoxAppManagerAdapter);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mDownloadingAppList);
            miniBoxAppManagerAdapter.B0(mutableList);
        }
        if (this.isEmptyPage) {
            NestedScrollView nestedScrollView = this.mSvMainPage;
            Intrinsics.checkNotNull(nestedScrollView);
            nestedScrollView.scrollTo(0, 0);
            this.isEmptyPage = false;
        }
    }

    private final void ai() {
        int i3;
        if (!this.isEmptyPage) {
            return;
        }
        RecyclerView recyclerView = null;
        if (!this.hasReqRecommendData) {
            this.hasReqRecommendData = true;
            RecyclerView recyclerView2 = this.mRvRecommend;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRvRecommend");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            Wh();
            return;
        }
        com.tencent.qq.minibox.ui.adapter.b bVar = this.mRecommendAdapter;
        if (bVar != null) {
            i3 = bVar.getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            RecyclerView recyclerView3 = this.mRvRecommend;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRvRecommend");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(0);
        }
    }

    private final QQCustomDialog zh(final VirtualAppInfo appInfo) {
        String str;
        String str2;
        String str3;
        String string;
        String string2;
        String string3;
        if (!TextUtils.isEmpty(appInfo.getPackageName())) {
            if (appInfo.getGameState() == 3) {
                string = BaseApplication.getContext().getString(R.string.f1654028f);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026_dialog_desc_delete_game)");
                string2 = BaseApplication.getContext().getString(R.string.f1654228h);
                Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026i_game_dialog_left_btn_2)");
                string3 = BaseApplication.getContext().getString(R.string.f1654428j);
                Intrinsics.checkNotNullExpressionValue(string3, "getContext().getString(R\u2026_game_dialog_right_btn_2)");
            } else {
                string = BaseApplication.getContext().getString(R.string.f1653928e);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026log_desc_cancel_download)");
                string2 = BaseApplication.getContext().getString(R.string.f1654128g);
                Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026i_game_dialog_left_btn_1)");
                string3 = BaseApplication.getContext().getString(R.string.f1654328i);
                Intrinsics.checkNotNullExpressionValue(string3, "getContext().getString(R\u2026_game_dialog_right_btn_1)");
            }
            str = string;
            str2 = string2;
            str3 = string3;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        QQCustomDialog createCenterTextDialog = DialogUtil.createCenterTextDialog(getActivity(), 0, BaseApplication.getContext().getString(R.string.f1654528k), str, str2, str3, new DialogInterface.OnClickListener() { // from class: com.tencent.qq.minibox.ui.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniBoxAppManagerFragment.Bh(MiniBoxAppManagerFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qq.minibox.ui.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                MiniBoxAppManagerFragment.Ah(MiniBoxAppManagerFragment.this, appInfo, dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCenterTextDialog, "createCenterTextDialog(\n\u2026.dismiss()\n            })");
        return createCenterTextDialog;
    }

    @Override // com.tencent.qq.minibox.ui.adapter.MiniBoxAppManagerAdapter.c
    public void Ae(@NotNull View view, @NotNull MiniBoxDownloadTask task, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(task, "task");
        Qh(view, task, position);
    }

    @Override // com.tencent.qq.minibox.ui.adapter.MiniBoxAppManagerAdapter.c
    public void I8(@NotNull View view, @NotNull MiniBoxDownloadTask task, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(task, "task");
        Ih(view, task, position);
    }

    @Override // com.tencent.qq.minibox.ui.adapter.MiniBoxAppManagerAdapter.c
    public void W6(@NotNull View view, @NotNull VirtualAppInfo appInfo, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Ih(view, appInfo, position);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.qq.minibox.ui.adapter.MiniBoxAppManagerAdapter.c
    public void k4(@NotNull View view, @NotNull MiniBoxDownloadTask task, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(task, "task");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(BaseApplication.getContext(), task.getAppId(), "", "", 0, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.xkf) {
            getQBaseActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && intent.hasExtra("loadingPackageName")) {
            String stringExtra = intent.getStringExtra("loadingPackageName");
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(\"loadingPackageName\")?:\"\"");
            }
            this.mLoadingPckName = stringExtra;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Oh(inflater, container);
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MiniBoxAppManagerAdapter miniBoxAppManagerAdapter = this.mAppManagerLoadedAdapter;
        if (miniBoxAppManagerAdapter != null) {
            miniBoxAppManagerAdapter.destroy();
        }
        MiniBoxAppManagerAdapter miniBoxAppManagerAdapter2 = this.mAppManagerLoadingAdapter;
        if (miniBoxAppManagerAdapter2 != null) {
            miniBoxAppManagerAdapter2.destroy();
        }
        com.tencent.qq.minibox.ui.adapter.b bVar = this.mRecommendAdapter;
        if (bVar != null) {
            bVar.destroy();
        }
        this.mDownloadAction.destroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Th();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Mh();
        Vh();
    }

    @Override // com.tencent.qq.minibox.ui.adapter.MiniBoxAppManagerAdapter.c
    public void td(@NotNull View view, @NotNull VirtualAppInfo appInfo, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Qh(view, appInfo, position);
    }
}
