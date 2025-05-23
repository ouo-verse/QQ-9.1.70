package com.tencent.mobileqq.guild.media.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bp;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0017\u0012\u0006\u0010!\u001a\u00020\u001a\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aR\u0017\u0010!\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020)`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001c\u00109\u001a\b\u0012\u0004\u0012\u000206058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/a;", "dialog", "", "th", "", "rh", "uh", "vh", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper;", "sh", "initView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onDetach", OcrConfig.CHINESE, "onStart", "", "tinyId", "xh", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getMChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "mPageParam", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "mList", "G", "Landroid/view/View;", "mEmptyView", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "H", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBehavior", "I", "Landroid/view/ViewGroup;", "mRootView", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRaiseHandDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final IGProChannelInfo mChannelInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mPageParam;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView mList;

    /* renamed from: G, reason: from kotlin metadata */
    private View mEmptyView;

    /* renamed from: H, reason: from kotlin metadata */
    private BottomSheetBehavior<FrameLayout> mBehavior;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewGroup mRootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildRaiseHandDialogFragment$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "event", "", "D0", "(Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.bg> {
        public b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        public void D0(com.tencent.mobileqq.guild.media.core.notify.bg event) {
            GuildRaiseHandDialogFragment.this.zh();
        }
    }

    public GuildRaiseHandDialogFragment(@NotNull String guildId, @NotNull IGProChannelInfo mChannelInfo) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(mChannelInfo, "mChannelInfo");
        this.guildId = guildId;
        this.mChannelInfo = mChannelInfo;
        this.mPageParam = new HashMap<>();
    }

    private final void initView() {
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.bww);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<View>(R.id.empty_view)");
        this.mEmptyView = findViewById;
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        View findViewById2 = viewGroup3.findViewById(R.id.eap);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setAdapter(new GuildRaiseHandAdapter(this.guildId, this, this.mPageParam));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById<R\u2026RTICAL, false)\n\n        }");
        this.mList = recyclerView;
        zh();
        ViewGroup viewGroup4 = this.mRootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.ap
            @Override // java.lang.Runnable
            public final void run() {
                GuildRaiseHandDialogFragment.wh(GuildRaiseHandDialogFragment.this);
            }
        });
    }

    private final int rh() {
        return bv.c(getActivity()) + Utils.n(24.0f, getResources());
    }

    private final MediaChannelRaiseHandHelper sh() {
        return com.tencent.mobileqq.guild.media.core.j.a().T();
    }

    private final void th(com.google.android.material.bottomsheet.a dialog) {
        BottomSheetBehavior<FrameLayout> behavior = dialog.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
        this.mBehavior = behavior;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = null;
        if (behavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            behavior = null;
        }
        behavior.setFitToContents(false);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = this.mBehavior;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            bottomSheetBehavior2 = null;
        }
        bottomSheetBehavior2.setExpandedOffset(rh());
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior3 = this.mBehavior;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
            bottomSheetBehavior3 = null;
        }
        bottomSheetBehavior3.setHalfExpandedRatio(0.60475165f);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior4 = this.mBehavior;
        if (bottomSheetBehavior4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
        } else {
            bottomSheetBehavior = bottomSheetBehavior4;
        }
        bottomSheetBehavior.setState(6);
    }

    private final void uh() {
        VideoReport.addToDetectionWhitelist(requireActivity());
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        VideoReport.setPageId(viewGroup, "pg_sgrp_avchannel_handup_manage");
        HashMap<String, Object> hashMap = this.mPageParam;
        String channelUin = this.mChannelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "mChannelInfo.channelUin");
        hashMap.put("sgrp_sub_channel_id", channelUin);
        HashMap<String, Object> hashMap2 = this.mPageParam;
        String channelName = this.mChannelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "mChannelInfo.channelName");
        hashMap2.put("sgrp_sub_channel_name", channelName);
        this.mPageParam.put("sgrp_subchannel_session_id", com.tencent.mobileqq.guild.media.core.j.c().L());
        com.tencent.mobileqq.guild.data.w.a(this.mPageParam);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        iGuildDTReportApi.setGuildPageParams(viewGroup2, com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), this.mPageParam);
    }

    private final void vh() {
        com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, com.tencent.mobileqq.guild.media.core.notify.bg.class, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(GuildRaiseHandDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        viewGroup.setMinimumHeight(bv.a(this$0.getActivity()) - bp.a(this$0.getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GuildRaiseHandDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.a0o;
        th(aVar);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.eyz, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.mRootView = (ViewGroup) inflate;
        initView();
        vh();
        uh();
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ViewGroup viewGroup = this.mRootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        ((ViewGroup) viewGroup.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.getRootView().findViewById(R.id.f100585sw).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRaiseHandDialogFragment.yh(GuildRaiseHandDialogFragment.this, view);
            }
        });
    }

    public final void xh(@NotNull String tinyId) {
        com.tencent.mobileqq.guild.media.core.data.p pVar;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        if (TextUtils.isEmpty(E)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "jumpToGuildProfile: channelId[" + E + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("RaiseHandDialogFragment", 1, (String) it.next(), null);
            }
            return;
        }
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo();
        if (selfUserInfo == null) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str2 = "jumpToGuildProfile: can not find self user info. channelId[" + E + "]";
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("RaiseHandDialogFragment", 1, (String) it5.next(), null);
            }
            return;
        }
        List<com.tencent.mobileqq.guild.media.core.data.p> list = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "getDataHub().userInfoList.anchors");
        ListIterator<com.tencent.mobileqq.guild.media.core.data.p> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                pVar = listIterator.previous();
                if (TextUtils.equals(pVar.f228093a, tinyId)) {
                    break;
                }
            } else {
                pVar = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.media.core.data.p pVar2 = pVar;
        if (pVar2 == null) {
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            String str3 = "jumpToGuildProfile: can not find target user. channelId[" + E + "]";
            if (str3 instanceof String) {
                bVar3.a().add(str3);
            }
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("RaiseHandDialogFragment", 1, (String) it6.next(), null);
            }
            return;
        }
        GuildProfileData guildProfileData = new GuildProfileData(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), tinyId, 1, MediaChannelUtils.f228046a.l());
        guildProfileData.getExtras().putParcelable(GuildProfileData.KEY_CHANNEL_DATA, new GuildAudioChannelData(com.tencent.mobileqq.guild.media.core.j.a().E(), 2, selfUserInfo.f228093a, selfUserInfo.f228097e, pVar2.f228093a, pVar2.f228097e, pVar2.f228112t, pVar2.f228113u, pVar2.f228105m));
        guildProfileData.getGuildBaseProfileData().r(E);
        GuildProfileCard.Lh(getActivity(), guildProfileData);
    }

    public final void zh() {
        List<IGProUserInfo> v16 = sh().v1();
        List<IGProUserInfo> u16 = sh().u1();
        RecyclerView recyclerView = null;
        if (v16.isEmpty() && u16.isEmpty()) {
            View view = this.mEmptyView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                view = null;
            }
            view.setVisibility(0);
            RecyclerView recyclerView2 = this.mList;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mList");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        View view2 = this.mEmptyView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
            view2 = null;
        }
        view2.setVisibility(8);
        RecyclerView recyclerView3 = this.mList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
            recyclerView3 = null;
        }
        recyclerView3.setVisibility(0);
        RecyclerView recyclerView4 = this.mList;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
        } else {
            recyclerView = recyclerView4;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.GuildRaiseHandAdapter");
        ((GuildRaiseHandAdapter) adapter).i0(v16, u16);
    }
}
