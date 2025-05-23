package com.tencent.robot.adelie.homepage.ugc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.homepage.ugc.ad;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateAdapter;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateMaterial;
import com.tencent.robot.adelie.homepage.ugc.view.UgcTemplateItemData;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J&\u0010\u0017\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarUgcTemplateFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initTitleBar", "initView", "initData", "sh", "th", "", "getContentLayoutId", "", "useQUISecNavBar", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "secNavBarNeedImmersive", "needImmersive", "needStatusTrans", "isWrapContent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "ugcTemplateRecycleView", "Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarUgcTemplateAdapter;", "D", "Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieAvatarUgcTemplateAdapter;", "ugcTemplateAdapter", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "E", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManager", UserInfo.SEX_FEMALE, "Z", "hasEditPrompt", "<init>", "()V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarUgcTemplateFragment extends QIphoneTitleBarFragment {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static AdelieAvatarUgcTemplateMaterial H;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecyclerView ugcTemplateRecycleView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AdelieAvatarUgcTemplateAdapter ugcTemplateAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private StaggeredGridLayoutManager layoutManager;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasEditPrompt;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/AdelieAvatarUgcTemplateFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "code", "", "c", "Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "selectedTemplateMaterial", "Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "a", "()Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "b", "(Lcom/tencent/robot/adelie/homepage/ugc/view/i;)V", "", "HAS_EDIT_PROMPT", "Ljava/lang/String;", "NETWORK_ERROR_MSG", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarUgcTemplateFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AdelieAvatarUgcTemplateMaterial a() {
            return AdelieAvatarUgcTemplateFragment.H;
        }

        public final void b(@Nullable AdelieAvatarUgcTemplateMaterial adelieAvatarUgcTemplateMaterial) {
            AdelieAvatarUgcTemplateFragment.H = adelieAvatarUgcTemplateMaterial;
        }

        public final void c(@NotNull Context context, @NotNull Intent intent, int code) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            AdelieFragmentActivity.INSTANCE.b(context, intent, AdelieAvatarUgcTemplateFragment.class, code);
        }

        Companion() {
        }
    }

    private final void initData() {
        ad.Companion companion = ad.INSTANCE;
        if (!companion.b().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            MetaMaterial metaMaterial = new MetaMaterial();
            metaMaterial.f30533id = "jumpLink";
            arrayList.add(new UgcTemplateItemData(metaMaterial, false, 2, null));
            Iterator<T> it = companion.b().iterator();
            while (it.hasNext()) {
                arrayList.add(new UgcTemplateItemData((MetaMaterial) it.next(), false, 2, null));
            }
            AdelieAvatarUgcTemplateAdapter adelieAvatarUgcTemplateAdapter = this.ugcTemplateAdapter;
            if (adelieAvatarUgcTemplateAdapter != null) {
                adelieAvatarUgcTemplateAdapter.k0(arrayList);
                return;
            }
            return;
        }
        QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u4e0d\u7ed9\u529b\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }

    private final void initTitleBar() {
        QUISecNavBar qUISecNavBar;
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setAutoAdaptTransparent(true);
            this.quiSecNavBar.setCenterText("\u53d1\u73b0\u7075\u611f");
            this.quiSecNavBar.setTitleAlpha(0.0f);
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_allwhite_primary);
            this.quiSecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left_icon_allwhite_primary);
            this.quiSecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.AdelieAvatarUgcTemplateFragment$initTitleBar$1

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes25.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f366515a;

                    static {
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f366515a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view, @NotNull BaseAction action) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (a.f366515a[action.ordinal()] == 1) {
                        AdelieAvatarUgcTemplateFragment.this.requireActivity().finish();
                    }
                }
            });
        }
    }

    @SuppressLint({"CutPasteId"})
    private final void initView() {
        this.ugcTemplateRecycleView = (RecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f113866rs);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        this.layoutManager = staggeredGridLayoutManager;
        RecyclerView recyclerView = this.ugcTemplateRecycleView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }
        AdelieAvatarUgcTemplateAdapter adelieAvatarUgcTemplateAdapter = new AdelieAvatarUgcTemplateAdapter(new ArrayList(), new AdelieAvatarUgcTemplateFragment$initView$1(this));
        this.ugcTemplateAdapter = adelieAvatarUgcTemplateAdapter;
        RecyclerView recyclerView2 = this.ugcTemplateRecycleView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(adelieAvatarUgcTemplateAdapter);
        }
        RecyclerView recyclerView3 = this.ugcTemplateRecycleView;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(null);
        }
        if (getActivity() != null) {
            this.titleRoot.setBackgroundColor(ie0.a.f().g(getContext(), R.color.qui_common_bg_bottom_light, 1000));
        }
    }

    private final void sh() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_discover_inspiration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Bundle arguments = getArguments();
        if (arguments != null) {
            boolean z16 = false;
            linkedHashMap.put("gender", Integer.valueOf(arguments.getInt("character.gender", 0)));
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                z16 = arguments2.getBoolean("hasEditPrompt", false);
            }
            this.hasEditPrompt = z16;
            VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams(linkedHashMap));
            VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
        }
    }

    private final void th() {
        RecyclerView.ViewHolder viewHolder;
        AdelieAvatarUgcTemplateAdapter adelieAvatarUgcTemplateAdapter;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.layoutManager;
        if (staggeredGridLayoutManager != null) {
            int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
            int[] findLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
            int length = findFirstVisibleItemPositions.length;
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = findFirstVisibleItemPositions[i3];
                int i17 = findLastVisibleItemPositions[i3];
                if (i16 <= i17) {
                    while (true) {
                        RecyclerView recyclerView = this.ugcTemplateRecycleView;
                        if (recyclerView != null) {
                            viewHolder = recyclerView.findViewHolderForAdapterPosition(i16);
                        } else {
                            viewHolder = null;
                        }
                        if (viewHolder != null && (adelieAvatarUgcTemplateAdapter = this.ugcTemplateAdapter) != null) {
                            adelieAvatarUgcTemplateAdapter.j0(viewHolder);
                        }
                        if (i16 != i17) {
                            i16++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initTitleBar();
        initView();
        initData();
        sh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dt9;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    protected boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgOut(view);
            AdelieAvatarUgcTemplateAdapter adelieAvatarUgcTemplateAdapter = this.ugcTemplateAdapter;
            if (adelieAvatarUgcTemplateAdapter != null) {
                adelieAvatarUgcTemplateAdapter.i0();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgIn(view, false);
            th();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
