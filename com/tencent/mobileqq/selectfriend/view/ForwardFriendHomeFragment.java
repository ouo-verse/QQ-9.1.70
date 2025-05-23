package com.tencent.mobileqq.selectfriend.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.common.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.selectfriend.eventbus.event.MyEventClickEvent;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectfriend.part.ForwardFriendTitleBarPart;
import com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart;
import com.tencent.mobileqq.selectfriend.part.SearchResultFragmentPart;
import com.tencent.mobileqq.selectfriend.part.SelectedAndSearchBarPart;
import com.tencent.mobileqq.selectfriend.processor.d;
import com.tencent.mobileqq.selectfriend.processor.k;
import com.tencent.mobileqq.selectfriend.processor.n;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dq2.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0018\u00010\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u0004\u0018\u00010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R \u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/view/ForwardFriendHomeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "wh", "uh", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "yh", "initViewModel", "Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "forwardMyItemView", "vh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "th", "onFinish", "initWindowStyleAndAnimation", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/selectfriend/processor/d;", "sh", "Ldq2/a;", BdhLogUtil.LogTag.Tag_Conn, "Ldq2/a;", "mForwardFriendHomeViewModel", "Ldq2/b;", "D", "Ldq2/b;", "mHomeTitleBarViewModel", "Lcom/tencent/mobileqq/selectfriend/part/RecentContentRefreshPart;", "E", "Lcom/tencent/mobileqq/selectfriend/part/RecentContentRefreshPart;", "mRecentContentRefreshPart", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/selectfriend/processor/d;", "mForwardBaseProcessor", "G", "Landroid/os/Bundle;", "mExtraData", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "H", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "mFsForwardData", "Lcom/tencent/mobileqq/app/QQAppInterface;", "I", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ForwardFriendHomeFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private dq2.a mForwardFriendHomeViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private b mHomeTitleBarViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private RecentContentRefreshPart mRecentContentRefreshPart;

    /* renamed from: F, reason: from kotlin metadata */
    private d mForwardBaseProcessor;

    /* renamed from: G, reason: from kotlin metadata */
    private Bundle mExtraData;

    /* renamed from: H, reason: from kotlin metadata */
    private FSForwardData<Bundle> mFsForwardData;

    /* renamed from: I, reason: from kotlin metadata */
    private QQAppInterface mApp;

    private final void initViewModel() {
        dq2.a it = (dq2.a) getViewModel(dq2.a.class);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this.mForwardFriendHomeViewModel = it;
        ViewModel viewModel = getViewModel(b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(HomeTitleBarViewModel::class.java)");
        this.mHomeTitleBarViewModel = (b) viewModel;
    }

    private final void uh() {
        Resources resources;
        dq2.a aVar = this.mForwardFriendHomeViewModel;
        r1 = null;
        CharSequence charSequence = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
            aVar = null;
        }
        FSForwardData<Bundle> S1 = aVar.S1();
        this.mFsForwardData = S1;
        d a16 = k.INSTANCE.a(S1 != null ? Integer.valueOf(S1.a()) : null);
        this.mForwardBaseProcessor = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardBaseProcessor");
        }
        d dVar = this.mForwardBaseProcessor;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardBaseProcessor");
            dVar = null;
        }
        if (dVar instanceof n) {
            Context context = getContext();
            Context context2 = getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                charSequence = resources.getText(R.string.x4a);
            }
            ToastUtil.show(context, charSequence, 0);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        d dVar2 = this.mForwardBaseProcessor;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardBaseProcessor");
            dVar2 = null;
        }
        dVar2.y(getActivity());
        FSForwardData<Bundle> fSForwardData = this.mFsForwardData;
        this.mExtraData = fSForwardData != null ? fSForwardData.b() : null;
        wh();
    }

    private final void vh(ForwardRecentItemView forwardMyItemView) {
        ResultRecord resultRecord = forwardMyItemView.J;
        if (resultRecord == null) {
            return;
        }
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            bundle.putString("uin", resultRecord.uin);
        }
        Bundle bundle2 = this.mExtraData;
        if (bundle2 != null) {
            bundle2.putInt("uintype", resultRecord.uinType);
        }
        Bundle bundle3 = this.mExtraData;
        if (bundle3 != null) {
            bundle3.putBoolean("forward_report_confirm", true);
        }
        Bundle bundle4 = this.mExtraData;
        if (bundle4 != null) {
            bundle4.putString("forward_report_confirm_action_name", "0X8005A13");
        }
        Bundle bundle5 = this.mExtraData;
        if (bundle5 != null) {
            bundle5.putString("forward_report_confirm_reverse2", "0");
        }
        dq2.a aVar = this.mForwardFriendHomeViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
            aVar = null;
        }
        aVar.u2(resultRecord);
        dq2.a aVar2 = this.mForwardFriendHomeViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
            aVar2 = null;
        }
        LinkedHashMap<String, ResultRecord> R1 = aVar2.R1();
        Collection<ResultRecord> values = R1 != null ? R1.values() : null;
        if (values == null || values.isEmpty()) {
            return;
        }
        Bundle bundle6 = this.mExtraData;
        if (bundle6 != null) {
            bundle6.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, new ArrayList<>(values));
        }
        dq2.a aVar3 = this.mForwardFriendHomeViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
            aVar3 = null;
        }
        LinkedHashMap<String, ResultRecord> R12 = aVar3.R1();
        if (R12 != null) {
            R12.clear();
        }
        dq2.a aVar4 = this.mForwardFriendHomeViewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
            aVar4 = null;
        }
        MutableLiveData<Boolean> c26 = aVar4.c2();
        if (c26 != null) {
            c26.postValue(Boolean.TRUE);
        }
        FSForwardData<Bundle> fSForwardData = this.mFsForwardData;
        if (fSForwardData != null && fSForwardData.a() == com.tencent.mobileqq.selectfriend.forward.a.INSTANCE.a()) {
            ReportCenter f16 = ReportCenter.f();
            QQAppInterface qQAppInterface = this.mApp;
            if (qQAppInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface = null;
            }
            String account = qQAppInterface.getAccount();
            Bundle bundle7 = this.mExtraData;
            f16.q(account, "", String.valueOf(bundle7 != null ? Integer.valueOf(bundle7.getInt("req_share_id")) : null), "1000", WadlProxyConsts.OPER_TYPE_MONITOR, "0", false, true);
        }
    }

    private final void wh() {
        dq2.a aVar = this.mForwardFriendHomeViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
            aVar = null;
        }
        MutableLiveData<Boolean> c26 = aVar.c2();
        if (c26 != null) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.view.ForwardFriendHomeFragment$registerObserver$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    d dVar;
                    Bundle bundle;
                    dVar = ForwardFriendHomeFragment.this.mForwardBaseProcessor;
                    if (dVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mForwardBaseProcessor");
                        dVar = null;
                    }
                    bundle = ForwardFriendHomeFragment.this.mExtraData;
                    dVar.G(bundle);
                }
            };
            c26.observe(activity, new Observer() { // from class: com.tencent.mobileqq.selectfriend.view.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ForwardFriendHomeFragment.xh(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ForwardFriendTitleBarPart());
        arrayList.add(new SelectedAndSearchBarPart());
        this.mRecentContentRefreshPart = new RecentContentRefreshPart();
        RecentContentRefreshPart recentContentRefreshPart = this.mRecentContentRefreshPart;
        if (recentContentRefreshPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentContentRefreshPart");
            recentContentRefreshPart = null;
        }
        arrayList.add(recentContentRefreshPart);
        arrayList.add(new SearchResultFragmentPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cyh;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(MyEventClickEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        yh(activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        dq2.a aVar = this.mForwardFriendHomeViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
            aVar = null;
        }
        Bundle arguments = getArguments();
        FragmentActivity activity = getActivity();
        aVar.p2(arguments, activity != null ? activity.getIntent() : null);
        uh();
        SimpleEventBus.getInstance().registerReceiver(this);
        if (getActivity() == null || !(getActivity() instanceof AppActivity)) {
            return;
        }
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type mqq.app.AppActivity");
        AppRuntime appRuntime = ((AppActivity) activity2).getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        this.mApp = (QQAppInterface) appRuntime;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (ImmersiveUtils.isSupporImmersive() == 1 && onCreateView != null) {
            onCreateView.setFitsSystemWindows(true);
            onCreateView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, R.anim.f154423k);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof MyEventClickEvent) {
            MyEventClickEvent myEventClickEvent = (MyEventClickEvent) event;
            if (myEventClickEvent.getView() instanceof ForwardRecentItemView) {
                View view = myEventClickEvent.getView();
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.adapter.ForwardRecentItemView");
                ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) view;
                ResultRecord resultRecord = forwardRecentItemView.J;
                if (this.mHomeTitleBarViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeTitleBarViewModel");
                }
                b bVar = this.mHomeTitleBarViewModel;
                dq2.a aVar = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHomeTitleBarViewModel");
                    bVar = null;
                }
                if (bVar.c2()) {
                    dq2.a aVar2 = this.mForwardFriendHomeViewModel;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
                        aVar2 = null;
                    }
                    String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
                    Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                    if (aVar2.h2(DATALINE_PC_UIN, 6000)) {
                        forwardRecentItemView.e(false);
                        dq2.a aVar3 = this.mForwardFriendHomeViewModel;
                        if (aVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
                            aVar3 = null;
                        }
                        MutableLiveData<Boolean> e26 = aVar3.e2();
                        if (e26 != null) {
                            e26.postValue(Boolean.TRUE);
                        }
                        dq2.a aVar4 = this.mForwardFriendHomeViewModel;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
                        } else {
                            aVar = aVar4;
                        }
                        Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
                        aVar.v2(DATALINE_PC_UIN, 6000);
                        return;
                    }
                    dq2.a aVar5 = this.mForwardFriendHomeViewModel;
                    if (aVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
                        aVar5 = null;
                    }
                    if (aVar5.L1(resultRecord)) {
                        forwardRecentItemView.e(true);
                        dq2.a aVar6 = this.mForwardFriendHomeViewModel;
                        if (aVar6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mForwardFriendHomeViewModel");
                        } else {
                            aVar = aVar6;
                        }
                        MutableLiveData<Boolean> e27 = aVar.e2();
                        if (e27 != null) {
                            e27.postValue(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    return;
                }
                vh((ForwardRecentItemView) myEventClickEvent.getView());
            }
        }
    }

    public final d sh() {
        d dVar = this.mForwardBaseProcessor;
        if (dVar != null) {
            return dVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mForwardBaseProcessor");
        return null;
    }

    public List<RecyclerView.Adapter<?>> th() {
        RecentContentRefreshPart recentContentRefreshPart = this.mRecentContentRefreshPart;
        if (recentContentRefreshPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentContentRefreshPart");
            recentContentRefreshPart = null;
        }
        return recentContentRefreshPart.Ba();
    }

    private final void yh(Activity activity) {
        Intent intent;
        Integer valueOf = (activity == null || (intent = activity.getIntent()) == null) ? null : Integer.valueOf(intent.getIntExtra(AppConstants.Key.FORWARD_ANIMATION_TYPE, -1));
        if (valueOf != null && valueOf.intValue() == -1) {
            QLog.i(QPublicBaseFragment.TAG, 1, "enter DEFAULT_ANIM_PULL_UP");
            if (activity != null) {
                activity.setTheme(R.style.f173428d2);
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            if (activity != null) {
                activity.setTheme(R.style.f173437a05);
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (activity != null) {
                activity.setTheme(R.style.f173436d8);
            }
        } else if (activity != null) {
            activity.setTheme(R.style.f173428d2);
        }
    }
}
