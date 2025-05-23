package com.tencent.mobileqq.gamecenter.qa.view;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.gamecenter.qa.data.InviteData;
import com.tencent.mobileqq.gamecenter.qa.event.QASelectExpertsEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u00015B\u0007\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010-R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010 \u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/QQGameStrategyAtDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "", "qh", "", "isNightTheme", "Landroid/widget/RelativeLayout;", "rlRoot", "sh", "Landroidx/recyclerview/widget/RecyclerView;", "rvExpertsList", "rh", "ph", "initData", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onStart", "v", NodeProps.ON_CLICK, "Lqd1/b;", BdhLogUtil.LogTag.Tag_Conn, "Lqd1/b;", "mAtExpertListAdapter", "D", "Landroid/view/View;", "mEmptyView", "", "E", "I", "mAppId", "", UserInfo.SEX_FEMALE, "J", "mQuestionId", "", "Lcom/tencent/mobileqq/gamecenter/qa/data/InviteData;", "G", "Ljava/util/List;", "mExpertList", "", "H", "mSelectedList", "mRootView", "<init>", "()V", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQGameStrategyAtDialog extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private qd1.b mAtExpertListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private View mEmptyView;

    /* renamed from: E, reason: from kotlin metadata */
    private int mAppId;

    /* renamed from: F, reason: from kotlin metadata */
    private long mQuestionId;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private List<InviteData> mExpertList;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private List<String> mSelectedList;

    /* renamed from: I, reason: from kotlin metadata */
    private View mRootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/QQGameStrategyAtDialog$a;", "", "", "appId", "", "questionId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/gamecenter/qa/data/InviteData;", "expertList", "", "selectedList", "Landroid/os/Bundle;", "a", "", "DIALOG_HEIGHT", UserInfo.SEX_FEMALE, "EXPAND_SIZE", "EXTRA_APP_ID", "Ljava/lang/String;", "EXTRA_EXPERTS", "EXTRA_QUESTION_ID", "EXTRA_SELECTED", "RADIUS_BG", "RADIUS_BTN", "TAG", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyAtDialog$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Bundle a(int appId, long questionId, @Nullable ArrayList<InviteData> expertList, @Nullable ArrayList<String> selectedList) {
            boolean z16;
            Bundle bundle = new Bundle();
            boolean z17 = false;
            if (expertList != null && !expertList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                bundle.putSerializable("experts", expertList);
            }
            if (selectedList == null || selectedList.isEmpty()) {
                z17 = true;
            }
            if (!z17) {
                bundle.putSerializable("selectedIds", selectedList);
            }
            bundle.putInt("appId", appId);
            bundle.putLong("questionId", questionId);
            return bundle;
        }

        Companion() {
        }
    }

    private final void initData() {
        this.mAppId = requireArguments().getInt("appId", 0);
        this.mQuestionId = requireArguments().getLong("questionId", 0L);
        Serializable serializable = requireArguments().getSerializable("experts");
        if (serializable != null) {
            this.mExpertList = (List) serializable;
        }
        Serializable serializable2 = requireArguments().getSerializable("selectedIds");
        if (serializable2 != null) {
            this.mSelectedList = (List) serializable2;
        }
    }

    private final void ph() {
        HashMap hashMap = new HashMap();
        hashMap.put(2, "1");
        com.tencent.mobileqq.gamecenter.qa.util.e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "916601", "908042", "7", String.valueOf(this.mAppId), hashMap);
    }

    private final void qh() {
        Dialog dialog = getDialog();
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
            BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
            Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
            behavior.setPeekHeight(ViewUtils.dip2px(608.0f));
            Window window = aVar.getWindow();
            if (window != null) {
                window.setLayout(-1, ViewUtils.dip2px(608.0f));
            }
            Window window2 = aVar.getWindow();
            if (window2 != null) {
                window2.setGravity(80);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void rh(RecyclerView rvExpertsList) {
        byte b16;
        List<InviteData> list = this.mExpertList;
        boolean z16 = false;
        if (list != null && !list.isEmpty()) {
            b16 = false;
        } else {
            b16 = true;
        }
        View view = null;
        qd1.b bVar = null;
        if (b16 == false) {
            rvExpertsList.setVisibility(0);
            View view2 = this.mEmptyView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
                view2 = null;
            }
            view2.setVisibility(8);
            List<InviteData> list2 = this.mExpertList;
            Intrinsics.checkNotNull(list2);
            Iterator<InviteData> it = list2.iterator();
            while (it.hasNext()) {
                it.next().o(false);
            }
            List<String> list3 = this.mSelectedList;
            if (list3 == null || list3.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                List<String> list4 = this.mSelectedList;
                Intrinsics.checkNotNull(list4);
                for (String str : list4) {
                    List<InviteData> list5 = this.mExpertList;
                    Intrinsics.checkNotNull(list5);
                    Iterator<InviteData> it5 = list5.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            InviteData next = it5.next();
                            if (TextUtils.equals(next.getEncodeUin(), str)) {
                                next.o(true);
                                break;
                            }
                        }
                    }
                }
            }
            qd1.b bVar2 = this.mAtExpertListAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAtExpertListAdapter");
            } else {
                bVar = bVar2;
            }
            List<InviteData> list6 = this.mExpertList;
            Intrinsics.checkNotNull(list6, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.gamecenter.qa.data.InviteData>");
            bVar.p0((ArrayList) list6);
            ph();
            return;
        }
        rvExpertsList.setVisibility(4);
        View view3 = this.mEmptyView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    private final void sh(boolean isNightTheme, RelativeLayout rlRoot) {
        if (isNightTheme) {
            View view = this.mRootView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            ((TextView) view.findViewById(R.id.kbs)).setTextColor(requireContext().getResources().getColor(R.color.f157842cg4));
            rlRoot.setBackground(com.tencent.mobileqq.gamecenter.qa.util.k.g(ViewUtils.dpToPx(8.0f), requireContext().getResources().getColor(R.color.cfr)));
            View view3 = this.mRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view2 = view3;
            }
            ((TextView) view2.findViewById(R.id.k6q)).setBackground(com.tencent.mobileqq.gamecenter.qa.util.k.g(ViewUtils.dpToPx(4.0f), requireContext().getResources().getColor(R.color.cfo)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        qd1.b bVar = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.dum) {
            dismiss();
        } else if (num != null && num.intValue() == R.id.k6q) {
            QASelectExpertsEvent qASelectExpertsEvent = new QASelectExpertsEvent();
            List<String> list = qASelectExpertsEvent.selectedUinList;
            qd1.b bVar2 = this.mAtExpertListAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAtExpertListAdapter");
            } else {
                bVar = bVar2;
            }
            list.addAll(bVar.j0());
            SimpleEventBus.getInstance().dispatchEvent(qASelectExpertsEvent);
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.a0i);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        initData();
        View view = null;
        View inflate = View.inflate(getContext(), R.layout.ebp, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026enter_qa_at_dialog, null)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dum);
        BaseAIOUtils.g(imageView, ViewUtils.dip2px(10.0f));
        imageView.setOnClickListener(this);
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        ((TextView) view2.findViewById(R.id.k6q)).setOnClickListener(this);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        RelativeLayout rlRoot = (RelativeLayout) view3.findViewById(R.id.idg);
        rlRoot.setBackground(com.tencent.mobileqq.gamecenter.qa.util.k.g(ViewUtils.dpToPx(8.0f), -1));
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        RecyclerView rvExpertsList = (RecyclerView) view4.findViewById(R.id.f789448f);
        rvExpertsList.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        qd1.b bVar = new qd1.b(getContext());
        this.mAtExpertListAdapter = bVar;
        bVar.o0(this.mAppId);
        qd1.b bVar2 = this.mAtExpertListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtExpertListAdapter");
            bVar2 = null;
        }
        bVar2.q0(isNowThemeIsNight);
        qd1.b bVar3 = this.mAtExpertListAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAtExpertListAdapter");
            bVar3 = null;
        }
        rvExpertsList.setAdapter(bVar3);
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById = view5.findViewById(R.id.f75493z4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<View>(R.id.rl_empty_view)");
        this.mEmptyView = findViewById;
        Intrinsics.checkNotNullExpressionValue(rvExpertsList, "rvExpertsList");
        rh(rvExpertsList);
        Intrinsics.checkNotNullExpressionValue(rlRoot, "rlRoot");
        sh(isNowThemeIsNight, rlRoot);
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view6;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        qh();
    }
}
