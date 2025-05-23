package com.tencent.mobileqq.guild.mainframe.create.removemember;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.mainframe.create.InviteFriendsData;
import com.tencent.mobileqq.guild.mainframe.create.removemember.GuildRemoveMemberFragment;
import com.tencent.mobileqq.guild.mainframe.create.removemember.d;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u000e\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00107\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0010\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/removemember/GuildRemoveMemberFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "initView", "initViewModel", "Ah", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "xh", "", "selectCount", "Bh", "com/tencent/mobileqq/guild/mainframe/create/removemember/GuildRemoveMemberFragment$b", "vh", "()Lcom/tencent/mobileqq/guild/mainframe/create/removemember/GuildRemoveMemberFragment$b;", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onFinish", "isWrapContent", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "D", "titleContainer", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "cancelButton", UserInfo.SEX_FEMALE, "removeButton", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "G", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "memberList", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/f;", "H", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/f;", "memberAdapter", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/d;", "I", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/d;", "viewModel", "J", "Lkotlin/Lazy;", "wh", "itemEventCallback", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRemoveMemberFragment extends QPublicBaseFragment implements View.OnClickListener {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private View titleContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView cancelButton;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView removeButton;

    /* renamed from: G, reason: from kotlin metadata */
    private OverScrollRecyclerView memberList;

    /* renamed from: H, reason: from kotlin metadata */
    private f memberAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private d viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemEventCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/removemember/GuildRemoveMemberFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "", "Lcom/tencent/mobileqq/guild/mainframe/create/InviteFriendsData;", "currentMembers", "", "a", "", "PARAM_MEMBER_LIST", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.create.removemember.GuildRemoveMemberFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, int requestCode, @NotNull List<InviteFriendsData> currentMembers) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(currentMembers, "currentMembers");
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("PARAM_MEMBER_LIST", bg.f302144a.n(currentMembers));
            QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, GuildRemoveMemberFragment.class, requestCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/mainframe/create/removemember/GuildRemoveMemberFragment$b", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/e;", "Landroid/view/View;", "view", "", "uin", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements e {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.create.removemember.e
        public void a(@NotNull View view, @NotNull String uin) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(uin, "uin");
            d dVar = GuildRemoveMemberFragment.this.viewModel;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                dVar = null;
            }
            dVar.U1(uin);
        }

        @Override // com.tencent.mobileqq.guild.mainframe.create.removemember.e
        public void b(@NotNull View view, @NotNull String uin) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(uin, "uin");
            d dVar = GuildRemoveMemberFragment.this.viewModel;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                dVar = null;
            }
            dVar.U1(uin);
        }
    }

    public GuildRemoveMemberFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.mainframe.create.removemember.GuildRemoveMemberFragment$itemEventCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildRemoveMemberFragment.b invoke() {
                GuildRemoveMemberFragment.b vh5;
                vh5 = GuildRemoveMemberFragment.this.vh();
                return vh5;
            }
        });
        this.itemEventCallback = lazy;
    }

    private final void Ah() {
        Intent intent = requireActivity().getIntent();
        if (QLog.isDevelopLevel()) {
            QLog.iAsync("GuildRemoveMemberFragment", 1, "content: " + intent.getExtras());
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("PARAM_MEMBER_LIST");
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = new ArrayList();
        }
        d dVar = this.viewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar = null;
        }
        dVar.R1(parcelableArrayListExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(int selectCount) {
        TextView textView = null;
        if (selectCount > 0) {
            TextView textView2 = this.removeButton;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("removeButton");
                textView2 = null;
            }
            textView2.setText("\u79fb\u9664(" + selectCount + ")");
            TextView textView3 = this.removeButton;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("removeButton");
                textView3 = null;
            }
            textView3.setEnabled(true);
            TextView textView4 = this.removeButton;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("removeButton");
            } else {
                textView = textView4;
            }
            textView.setAlpha(1.0f);
            return;
        }
        TextView textView5 = this.removeButton;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeButton");
            textView5 = null;
        }
        textView5.setText("\u79fb\u9664");
        TextView textView6 = this.removeButton;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeButton");
            textView6 = null;
        }
        textView6.setEnabled(false);
        TextView textView7 = this.removeButton;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeButton");
        } else {
            textView = textView7;
        }
        textView.setAlpha(0.3f);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.if5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.root_view)");
        this.rootView = findViewById;
        xh(view);
        View findViewById2 = view.findViewById(R.id.eoq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.member_list)");
        this.memberList = (OverScrollRecyclerView) findViewById2;
        this.memberAdapter = new f(wh());
        OverScrollRecyclerView overScrollRecyclerView = this.memberList;
        f fVar = null;
        if (overScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberList");
            overScrollRecyclerView = null;
        }
        overScrollRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        f fVar2 = this.memberAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberAdapter");
        } else {
            fVar = fVar2;
        }
        overScrollRecyclerView.setAdapter(fVar);
    }

    private final void initViewModel() {
        d.Companion companion = d.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        d a16 = companion.a(requireActivity);
        this.viewModel = a16;
        d dVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            a16 = null;
        }
        LiveData<List<a>> P1 = a16.P1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends a>, Unit> function1 = new Function1<List<? extends a>, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.create.removemember.GuildRemoveMemberFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends a> list) {
                f fVar;
                fVar = GuildRemoveMemberFragment.this.memberAdapter;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memberAdapter");
                    fVar = null;
                }
                fVar.setItems(list);
            }
        };
        P1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.mainframe.create.removemember.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRemoveMemberFragment.yh(Function1.this, obj);
            }
        });
        d dVar2 = this.viewModel;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            dVar = dVar2;
        }
        LiveData<Integer> Q1 = dVar.Q1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.create.removemember.GuildRemoveMemberFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                GuildRemoveMemberFragment guildRemoveMemberFragment = GuildRemoveMemberFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildRemoveMemberFragment.Bh(it.intValue());
            }
        };
        Q1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.mainframe.create.removemember.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRemoveMemberFragment.zh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b vh() {
        return new b();
    }

    private final b wh() {
        return (b) this.itemEventCallback.getValue();
    }

    private final void xh(View rootView) {
        View findViewById = rootView.findViewById(R.id.title_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_container)");
        this.titleContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.tlh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.cancel_button)");
        this.cancelButton = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f72843ry);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.remove_button)");
        this.removeButton = (TextView) findViewById3;
        TextView textView = null;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            View view = this.titleContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                view = null;
            }
            view.setFitsSystemWindows(true);
            View view2 = this.titleContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                view2 = null;
            }
            view2.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
            QQGuildUIUtil.L(getActivity(), getResources().getColor(R.color.qui_common_bg_bottom_light));
            boolean z16 = !GuildThemeManager.f235286a.b();
            Window window = requireActivity().getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
            GuildThemeManager.i(z16, window);
        }
        TextView textView2 = this.cancelButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.removeButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("removeButton");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f4b;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154740cc);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        TextView textView = this.cancelButton;
        d dVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            textView = null;
        }
        if (Intrinsics.areEqual(v3, textView)) {
            onBackEvent();
        } else {
            TextView textView2 = this.removeButton;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("removeButton");
                textView2 = null;
            }
            if (Intrinsics.areEqual(v3, textView2)) {
                Intent intent = new Intent();
                bg bgVar = bg.f302144a;
                d dVar2 = this.viewModel;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    dVar = dVar2;
                }
                intent.putStringArrayListExtra("PARAM_MEMBER_LIST", bgVar.n(dVar.O1()));
                requireActivity().setResult(-1, intent);
                requireActivity().finish();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initViewModel();
        Ah();
    }
}
