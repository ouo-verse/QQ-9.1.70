package com.tencent.mobileqq.guild.mission.beginmission.missionlist;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.mission.beginmission.mainframe.view.MissionProgressView;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uu1.Mission;
import uu1.MissionModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/MissionListDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;", "", "uh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "initView", "initData", "initDtReport", "onItemClick", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "root", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "titleImage", "Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionProgressView;", "E", "Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionProgressView;", "progressView", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "missionList", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "skipMission", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/a;", "H", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/a;", "missionAdapter", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/d;", "I", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/d;", "viewModel", "", "J", "Lkotlin/Lazy;", "getGuildId", "()Ljava/lang/String;", "guildId", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MissionListDialogFragment extends BottomSheetDialogFragment implements e {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View root;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView titleImage;

    /* renamed from: E, reason: from kotlin metadata */
    private MissionProgressView progressView;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView missionList;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView skipMission;

    /* renamed from: H, reason: from kotlin metadata */
    private a missionAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.mission.beginmission.missionlist.d viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/MissionListDialogFragment$a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "", "a", "EXTRA_KEY_GUILD_ID", "Ljava/lang/String;", "TAG", "TITLE_IMAGE_URL", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mission.beginmission.missionlist.MissionListDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull FragmentActivity activity, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Logger.f235387a.d().d("Guild.mission.MissionListDialogFragment", 1, "showClientConnectSelectDialogFragment guildId:" + guildId);
            Bundle bundle = new Bundle();
            bundle.putSerializable("guild_id", guildId);
            MissionListDialogFragment missionListDialogFragment = new MissionListDialogFragment();
            missionListDialogFragment.setArguments(bundle);
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            supportFragmentManager.beginTransaction().add(missionListDialogFragment, "Guild.mission.MissionListDialogFragment").commitAllowingStateLoss();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b<T> implements Observer {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            MissionModel missionModel = (MissionModel) t16;
            MissionProgressView missionProgressView = MissionListDialogFragment.this.progressView;
            MissionProgressView missionProgressView2 = null;
            if (missionProgressView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
                missionProgressView = null;
            }
            missionProgressView.setTotal(missionModel.getTotalNum());
            MissionProgressView missionProgressView3 = MissionListDialogFragment.this.progressView;
            if (missionProgressView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
            } else {
                missionProgressView2 = missionProgressView3;
            }
            missionProgressView2.setProgress(missionModel.getFinishNum());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<Mission> it = (List) t16;
            a aVar = MissionListDialogFragment.this.missionAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("missionAdapter");
                aVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            aVar.k0(it);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            com.tencent.mobileqq.guild.mission.beginmission.missionlist.d dVar = MissionListDialogFragment.this.viewModel;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                dVar = null;
            }
            dVar.W1();
            MissionListDialogFragment.this.dismiss();
        }
    }

    public MissionListDialogFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.mission.beginmission.missionlist.MissionListDialogFragment$guildId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Bundle arguments = MissionListDialogFragment.this.getArguments();
                String string = arguments != null ? arguments.getString("guild_id") : null;
                if (!(string == null || string.length() == 0)) {
                    return string;
                }
                FragmentActivity activity = MissionListDialogFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                return "";
            }
        });
        this.guildId = lazy;
    }

    private final String getGuildId() {
        return (String) this.guildId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(MissionListDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.skipMission;
        com.tencent.mobileqq.guild.mission.beginmission.missionlist.d dVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipMission");
            textView = null;
        }
        VideoReport.reportEvent("clck", textView, null);
        com.tencent.mobileqq.guild.mission.beginmission.missionlist.d dVar2 = this$0.viewModel;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            dVar = dVar2;
        }
        dVar.X1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void uh() {
        ImageView imageView = this.titleImage;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleImage");
            imageView = null;
        }
        v.k("https://downv6.qq.com/innovate/guild/tips/guild_begin_mission_list_image.png", imageView, new ColorDrawable(getResources().getColor(R.color.ajr)));
        if (GuildThemeManager.f235286a.b()) {
            ImageView imageView3 = this.titleImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleImage");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setAlpha(0.5f);
        }
    }

    public final void initData() {
        com.tencent.mobileqq.guild.mission.beginmission.missionlist.d a16 = com.tencent.mobileqq.guild.mission.beginmission.missionlist.d.INSTANCE.a(this);
        this.viewModel = a16;
        TextView textView = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            a16 = null;
        }
        a16.T1(getGuildId());
        com.tencent.mobileqq.guild.mission.beginmission.missionlist.d dVar = this.viewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar = null;
        }
        MutableLiveData<MissionModel> S1 = dVar.S1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        S1.observe(viewLifecycleOwner, new b());
        com.tencent.mobileqq.guild.mission.beginmission.missionlist.d dVar2 = this.viewModel;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar2 = null;
        }
        MutableLiveData<List<Mission>> R1 = dVar2.R1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        R1.observe(viewLifecycleOwner2, new c());
        com.tencent.mobileqq.guild.mission.beginmission.missionlist.d dVar3 = this.viewModel;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar3 = null;
        }
        MutableLiveData<Boolean> Q1 = dVar3.Q1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        Q1.observe(viewLifecycleOwner3, new d());
        TextView textView2 = this.skipMission;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipMission");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.mission.beginmission.missionlist.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissionListDialogFragment.th(MissionListDialogFragment.this, view);
            }
        });
    }

    public final void initDtReport() {
        View view;
        View view2 = this.root;
        TextView textView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view2 = null;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
        String guildId = getGuildId();
        Object parent = view2.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            view2 = view;
        }
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view2, "pg_sgrp_master_guide");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(view2, guildId, null);
        TextView textView2 = this.skipMission;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipMission");
        } else {
            textView = textView2;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementId(textView, "em_sgrp_master_guide_close");
        VideoReport.setElementExposePolicy(textView, exposurePolicy);
        VideoReport.setElementClickPolicy(textView, clickPolicy);
    }

    public final void initView() {
        View view = this.root;
        a aVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f98525nb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.title_image)");
        this.titleImage = (ImageView) findViewById;
        uh();
        View view2 = this.root;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.g2d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.progress_view)");
        this.progressView = (MissionProgressView) findViewById2;
        View view3 = this.root;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.zbv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.mission_list)");
        this.missionList = (RecyclerView) findViewById3;
        View view4 = this.root;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f86114qs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.skip_mission)");
        this.skipMission = (TextView) findViewById4;
        RecyclerView recyclerView = this.missionList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("missionList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.missionAdapter = new a(this);
        RecyclerView recyclerView2 = this.missionList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("missionList");
            recyclerView2 = null;
        }
        a aVar2 = this.missionAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("missionAdapter");
        } else {
            aVar = aVar2;
        }
        recyclerView2.setAdapter(aVar);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f07, container, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026ragment, container, true)");
        this.root = inflate;
        initView();
        initData();
        initDtReport();
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.guild.mission.beginmission.missionlist.e
    public void onItemClick() {
        dismiss();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }
}
