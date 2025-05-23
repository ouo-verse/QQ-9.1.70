package com.tencent.state.publicchat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.rapier.b;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.publicchat.data.MsgInfoChecked;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.service.IVasChatTipOffService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.databinding.VasSquareFragmentChatReportBinding;
import com.tencent.state.view.SquareImageView;
import com.tencent.state.view.SquareLoadingDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import mqq.app.Constants;
import ys4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0005H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/state/publicchat/fragment/ReportFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", TabPreloadItem.TAB_NAME_MESSAGE, "", "Lcom/tencent/state/publicchat/data/MsgInfoChecked;", "appId", "", "onBackCb", "Lkotlin/Function0;", "", "(Lcom/tencent/state/publicchat/data/PublicChatConfInfo;Ljava/util/List;ILkotlin/jvm/functions/Function0;)V", "adapter", "Lcom/tencent/state/publicchat/fragment/MessageListAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentChatReportBinding;", "getConf", "()Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "setConf", "(Lcom/tencent/state/publicchat/data/PublicChatConfInfo;)V", ToastView.ICON_LOADING, "Lcom/tencent/state/view/SquareLoadingDialog;", "getLoading", "()Lcom/tencent/state/view/SquareLoadingDialog;", "loading$delegate", "Lkotlin/Lazy;", "service", "Lcom/tencent/state/publicchat/service/IVasChatTipOffService;", "generateSrvPara", "", "getComponents", "Lcom/tencent/state/FragmentComponent;", "getUid", "initView", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ReportFragment extends VasBaseSubFragment {
    private static final String TAG = "ReportFragment";
    private final MessageListAdapter adapter;
    private final int appId;
    private VasSquareFragmentChatReportBinding binding;
    private PublicChatConfInfo conf;

    /* renamed from: loading$delegate, reason: from kotlin metadata */
    private final Lazy loading;
    private List<MsgInfoChecked> msgList;
    private final Function0<Unit> onBackCb;
    private final IVasChatTipOffService service;

    public ReportFragment(PublicChatConfInfo conf, List<MsgInfoChecked> msgList, int i3, Function0<Unit> onBackCb) {
        Lazy lazy;
        List emptyList;
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(onBackCb, "onBackCb");
        this.conf = conf;
        this.msgList = msgList;
        this.appId = i3;
        this.onBackCb = onBackCb;
        this.service = (IVasChatTipOffService) Square.INSTANCE.getConfig().getRapier().b(IVasChatTipOffService.class);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareLoadingDialog>() { // from class: com.tencent.state.publicchat.fragment.ReportFragment$loading$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareLoadingDialog invoke() {
                FragmentActivity it = ReportFragment.this.getActivity();
                if (it == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                return new SquareLoadingDialog(it, false);
            }
        });
        this.loading = lazy;
        PublicChatConfInfo publicChatConfInfo = this.conf;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.adapter = new MessageListAdapter(publicChatConfInfo, emptyList, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String generateSrvPara() {
        IntRange until;
        byte[] sliceArray;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("chatmsg:");
        for (MsgInfoChecked msgInfoChecked : this.msgList) {
            if (msgInfoChecked.getChecked()) {
                sb5.append("[uin=");
                sb5.append(msgInfoChecked.getMsg().getUser().getUin());
                sb5.append(";content=");
                if (msgInfoChecked.getMsg().getBody().length > 12) {
                    byte[] body = msgInfoChecked.getMsg().getBody();
                    until = RangesKt___RangesKt.until(12, msgInfoChecked.getMsg().getBody().length);
                    sliceArray = ArraysKt___ArraysKt.sliceArray(body, until);
                    sb5.append(new String(sliceArray, Charsets.UTF_8));
                }
                sb5.append(";time=");
                sb5.append(";type=1]");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "srvParaBuilder.toString()");
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareLoadingDialog getLoading() {
        return (SquareLoadingDialog) this.loading.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getUid() {
        return String.valueOf(this.msgList.get(0).getMsg().getUser().getUin());
    }

    private final void initView() {
        TextView textView;
        RecyclerView view;
        SquareImageView squareImageView;
        VasSquareFragmentChatReportBinding vasSquareFragmentChatReportBinding = this.binding;
        if (vasSquareFragmentChatReportBinding != null && (squareImageView = vasSquareFragmentChatReportBinding.back) != null) {
            squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.fragment.ReportFragment$initView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReportFragment.this.onBackPressed();
                }
            });
        }
        VasSquareFragmentChatReportBinding vasSquareFragmentChatReportBinding2 = this.binding;
        if (vasSquareFragmentChatReportBinding2 != null && (view = vasSquareFragmentChatReportBinding2.msgContainer) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            int i3 = 0;
            view.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            view.setAdapter(this.adapter);
            this.adapter.setItems(this.msgList);
            this.adapter.notifyItemRangeInserted(0, this.msgList.size());
            Iterator<T> it = this.msgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (((MsgInfoChecked) next).getChecked()) {
                    view.scrollToPosition(i3);
                    break;
                }
                i3 = i16;
            }
        }
        VasSquareFragmentChatReportBinding vasSquareFragmentChatReportBinding3 = this.binding;
        if (vasSquareFragmentChatReportBinding3 == null || (textView = vasSquareFragmentChatReportBinding3.submitBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.fragment.ReportFragment$initView$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                List list;
                int collectionSizeOrDefault;
                long[] longArray;
                SquareLoadingDialog loading;
                int i17;
                int i18;
                String uid;
                IVasChatTipOffService iVasChatTipOffService;
                list = ReportFragment.this.msgList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((MsgInfoChecked) obj).getChecked()) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(Long.valueOf(((MsgInfoChecked) it5.next()).getMsg().getHeader().getMsgId()));
                }
                longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList2);
                if (longArray.length == 0) {
                    return;
                }
                loading = ReportFragment.this.getLoading();
                if (loading != null) {
                    loading.showSafely();
                }
                a aVar = new a();
                i17 = ReportFragment.this.appId;
                aVar.f451160d = i17;
                i18 = ReportFragment.this.appId;
                aVar.f451157a = i18;
                aVar.f451159c = longArray;
                uid = ReportFragment.this.getUid();
                aVar.f451158b = Long.parseLong(uid);
                iVasChatTipOffService = ReportFragment.this.service;
                iVasChatTipOffService.getImpeachSeqID(aVar, SquareRuntime.INSTANCE.getQMetaContextSource()).a(new b<ys4.b>() { // from class: com.tencent.state.publicchat.fragment.ReportFragment$initView$3.1
                    @Override // com.tencent.rapier.b
                    public void onFailure(int errorCode, String errorMessage) {
                        SquareLoadingDialog loading2;
                        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                        loading2 = ReportFragment.this.getLoading();
                        if (loading2 != null) {
                            loading2.dismiss();
                        }
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ReportFragment", "GetImpeachSeqID failed: errorCode=" + errorCode + ", errorMsg=" + errorMessage, null, 4, null);
                    }

                    @Override // com.tencent.rapier.b
                    public void onSuccess(ys4.b response) {
                        SquareLoadingDialog loading2;
                        SquareLoadingDialog loading3;
                        String generateSrvPara;
                        String uid2;
                        ISquareBaseMessageService messageService;
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (!(!Intrinsics.areEqual(response.f451161a, ""))) {
                            loading2 = ReportFragment.this.getLoading();
                            if (loading2 != null) {
                                loading2.dismiss();
                            }
                            Context it6 = ReportFragment.this.getContext();
                            if (it6 != null) {
                                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                                Intrinsics.checkNotNullExpressionValue(it6, "it");
                                ICommonUtils.DefaultImpls.showToast$default(squareCommon, it6, "\u6682\u672a\u63d0\u4ea4\u6210\u529f\uff0c\u518d\u8bd5\u4e00\u6b21\u5427", 0, 4, (Object) null);
                                return;
                            }
                            return;
                        }
                        SquareBaseKt.getSquareLog().i("ReportFragment", "ImpeachSeqId: " + response.f451161a);
                        loading3 = ReportFragment.this.getLoading();
                        if (loading3 != null) {
                            loading3.dismiss();
                        }
                        generateSrvPara = ReportFragment.this.generateSrvPara();
                        uid2 = ReportFragment.this.getUid();
                        BasicServiceComponent basicServiceComponent = (BasicServiceComponent) ReportFragment.this.getComponent(BasicServiceComponent.class, null, null);
                        if (basicServiceComponent == null || (messageService = basicServiceComponent.getMessageService()) == null) {
                            return;
                        }
                        ReportFragment reportFragment = ReportFragment.this;
                        String str = response.f451161a;
                        Intrinsics.checkNotNullExpressionValue(str, "response.impeachSeqId");
                        messageService.openReportPage(reportFragment, uid2, generateSrvPara, str);
                    }
                });
            }
        });
    }

    public final PublicChatConfInfo getConf() {
        return this.conf;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.state.VasBaseFragment
    public boolean onBackPressed() {
        super.onBackPressed();
        hideFragment(this);
        this.onBackCb.invoke();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareFragmentChatReportBinding inflate = VasSquareFragmentChatReportBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentChatRep\u2026 binding = this\n        }");
        LinearLayout mContainer = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "VasSquareFragmentChatRep\u2026ing = this\n        }.root");
        return mContainer;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    public final void setConf(PublicChatConfInfo publicChatConfInfo) {
        Intrinsics.checkNotNullParameter(publicChatConfInfo, "<set-?>");
        this.conf = publicChatConfInfo;
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.VasBaseLifecycleFragment
    public List<FragmentComponent> getComponents() {
        List<FragmentComponent> listOf;
        if (getComponent(BasicServiceComponent.class, null, null) == null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new BasicServiceComponent());
            return listOf;
        }
        return super.getComponents();
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
