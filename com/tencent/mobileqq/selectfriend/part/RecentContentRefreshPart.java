package com.tencent.mobileqq.selectfriend.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentRoundItemView;
import com.tencent.mobileqq.adapter.ForwardSelectionRecentFriendGridAdapter;
import com.tencent.mobileqq.adapter.n;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.enter.select.b;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectfriend.model.FSLayoutData;
import com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart;
import com.tencent.mobileqq.selectfriend.part.adapter.RecentChatListAdapter;
import com.tencent.mobileqq.selectfriend.part.adapter.e;
import com.tencent.mobileqq.selectfriend.view.ForwardFriendHomeFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.richframework.widget.scroll.OverScrollDecorator;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\fH\u0016J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J \u0010\u001b\u001a\u00020\u00062\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\tH\u0002J\u0016\u0010,\u001a\u00020\u00062\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\fH\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/RecentContentRefreshPart;", "Lcom/tencent/mobileqq/selectfriend/part/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ba", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Da", "wa", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/RecentUser;", "Lkotlin/collections/ArrayList;", "recentForwardList", "za", "intent", "xa", "Ca", "Ga", "Ea", "Za", "Ha", "Aa", "Xa", "", "needCheckBoxAnimation", "Va", "view", "Fa", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "Ta", "va", "Ua", "showConfirmDialog", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "I", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lcom/tencent/mobileqq/selectfriend/part/adapter/h;", "J", "Lcom/tencent/mobileqq/selectfriend/part/adapter/h;", "mRecentForwardAdapter", "Landroid/app/Dialog;", "K", "Landroid/app/Dialog;", "mForwardCountLimitDialog", "Lcom/tencent/mobileqq/selectfriend/part/adapter/RecentChatListAdapter;", "L", "Lcom/tencent/mobileqq/selectfriend/part/adapter/RecentChatListAdapter;", "mRecentChatListAdapter", "Lcom/tencent/mobileqq/selectfriend/part/adapter/e;", "M", "Lcom/tencent/mobileqq/selectfriend/part/adapter/e;", "mRecentChatHeadAdapter", "Lcom/tencent/mobileqq/selectfriend/part/adapter/b;", "N", "Lcom/tencent/mobileqq/selectfriend/part/adapter/b;", "mBlankIntervalAdapter", "Landroid/content/BroadcastReceiver;", "P", "Landroid/content/BroadcastReceiver;", "mBindFinishReceiver", "Lcom/tencent/mobileqq/selectfriend/processor/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/selectfriend/processor/d;", "mForwardBaseProcessor", "Lcom/tencent/mobileqq/adapter/n$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/adapter/n$c;", "mForwardRecentListAdapterCallback", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RecentContentRefreshPart extends a {

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: I, reason: from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.mobileqq.selectfriend.part.adapter.h mRecentForwardAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private Dialog mForwardCountLimitDialog;

    /* renamed from: L, reason: from kotlin metadata */
    private RecentChatListAdapter mRecentChatListAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    private com.tencent.mobileqq.selectfriend.part.adapter.e mRecentChatHeadAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.mobileqq.selectfriend.part.adapter.b mBlankIntervalAdapter;

    /* renamed from: P, reason: from kotlin metadata */
    private BroadcastReceiver mBindFinishReceiver;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.selectfriend.processor.d mForwardBaseProcessor;

    /* renamed from: R, reason: from kotlin metadata */
    private final n.c mForwardRecentListAdapterCallback = new c();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/selectfriend/part/RecentContentRefreshPart$b", "Lcom/tencent/mobileqq/selectfriend/part/adapter/e$b;", "", "report", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e.b {
        b() {
        }

        @Override // com.tencent.mobileqq.selectfriend.part.adapter.e.b
        public void a() {
            dq2.b E9 = RecentContentRefreshPart.this.E9();
            boolean z16 = false;
            if (E9 != null && E9.c2()) {
                z16 = true;
            }
            if (z16) {
                RecentContentRefreshPart.this.L9("0X800C019");
                Intent intent = new Intent();
                dq2.a B9 = RecentContentRefreshPart.this.B9();
                Integer valueOf = B9 != null ? Integer.valueOf(B9.b2()) : null;
                dq2.a B92 = RecentContentRefreshPart.this.B9();
                LinkedHashMap<String, ResultRecord> R1 = B92 != null ? B92.R1() : null;
                dq2.a B93 = RecentContentRefreshPart.this.B9();
                Boolean valueOf2 = B93 != null ? Boolean.valueOf(B93.getMIsShowGuildEntrance()) : null;
                dq2.a B94 = RecentContentRefreshPart.this.B9();
                Integer valueOf3 = B94 != null ? Integer.valueOf(B94.getMUinType()) : null;
                RecentContentRefreshPart.this.xa(intent);
                Bundle mExtraData = RecentContentRefreshPart.this.getMExtraData();
                if (mExtraData != null) {
                    mExtraData.putInt("via", 3);
                }
                dq2.c F9 = RecentContentRefreshPart.this.F9();
                if (F9 != null) {
                    Activity activity = RecentContentRefreshPart.this.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    F9.O1(activity, intent, valueOf3, valueOf2, R1, valueOf, RecentContentRefreshPart.this.getMExtraData(), RecentContentRefreshPart.this.getMFsLayoutData());
                }
                RecentContentRefreshPart.this.L9("0X800C01A");
                return;
            }
            RecentContentRefreshPart.this.L9("0X800C017");
            RecentContentRefreshPart.this.Ea();
        }

        @Override // com.tencent.mobileqq.selectfriend.part.adapter.e.b
        public void report() {
            RecentContentRefreshPart.this.L9("0X800C016");
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/selectfriend/part/RecentContentRefreshPart$c", "Lcom/tencent/mobileqq/adapter/n$c;", "", "uin", "", "type", "", "a", "Landroid/view/View;", "v", "", "b", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements n.c {
        c() {
        }

        @Override // com.tencent.mobileqq.adapter.n.c
        public boolean a(String uin, int type) {
            dq2.a B9;
            Intrinsics.checkNotNullParameter(uin, "uin");
            return (RecentContentRefreshPart.this.B9() == null || (B9 = RecentContentRefreshPart.this.B9()) == null || !B9.h2(uin, type)) ? false : true;
        }

        @Override // com.tencent.mobileqq.adapter.n.c
        public void b(View v3) {
            dq2.a B9;
            Intrinsics.checkNotNullParameter(v3, "v");
            if (RecentContentRefreshPart.this.B9() == null || (B9 = RecentContentRefreshPart.this.B9()) == null) {
                return;
            }
            dq2.b E9 = RecentContentRefreshPart.this.E9();
            B9.k2(v3, E9 != null ? Boolean.valueOf(E9.c2()) : null);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/selectfriend/part/RecentContentRefreshPart$d", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "onResult", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements RecentContactListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(RecentContentRefreshPart this$0, List recentUserList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(recentUserList, "$recentUserList");
            if (this$0.mRecentChatListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentChatListAdapter");
            }
            RecentChatListAdapter recentChatListAdapter = this$0.mRecentChatListAdapter;
            if (recentChatListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentChatListAdapter");
                recentChatListAdapter = null;
            }
            recentChatListAdapter.refreshList(recentUserList);
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(final List<RecentUser> recentUserList) {
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final RecentContentRefreshPart recentContentRefreshPart = RecentContentRefreshPart.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.part.z
                @Override // java.lang.Runnable
                public final void run() {
                    RecentContentRefreshPart.d.b(RecentContentRefreshPart.this, recentUserList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa() {
        MutableLiveData<Boolean> c26;
        dq2.a B9 = B9();
        LinkedHashMap<String, ResultRecord> R1 = B9 != null ? B9.R1() : null;
        if (R1 == null || R1.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(R1.values());
        Collections.sort(arrayList, new ResultRecord.DefaultComparator());
        Bundle mExtraData = getMExtraData();
        if (mExtraData != null) {
            mExtraData.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, new ArrayList<>(arrayList));
        }
        dq2.a B92 = B9();
        if (B92 == null || (c26 = B92.c2()) == null) {
            return;
        }
        c26.postValue(Boolean.TRUE);
    }

    private final void Ca() {
        if (this.mBindFinishReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindFinishReceiver");
        }
    }

    private final void Da() {
        if (getActivity() == null || !(getActivity() instanceof QPublicFragmentActivity)) {
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.activity.QPublicFragmentActivity");
        QPublicBaseFragment fragment = ((QPublicFragmentActivity) activity).getFragment();
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.tencent.mobileqq.selectfriend.view.ForwardFriendHomeFragment");
        this.mForwardBaseProcessor = ((ForwardFriendHomeFragment) fragment).sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea() {
        M9("0X8007826");
        dq2.c F9 = F9();
        if (F9 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Intent P1 = F9.P1(context);
            if (P1 == null) {
                return;
            }
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(getActivity(), P1, 20003);
            ReportController.o(getMApp(), "CliOper", "", "", "friendchoose", "0X8009D92", I9(), 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa(View view) {
        String str;
        ResultRecord resultRecord;
        String str2;
        String str3;
        if (view instanceof ForwardRecentItemView) {
            ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) view;
            str = forwardRecentItemView.G;
            resultRecord = forwardRecentItemView.J;
        } else if (view instanceof ForwardRecentRoundItemView) {
            ForwardRecentRoundItemView forwardRecentRoundItemView = (ForwardRecentRoundItemView) view;
            str = forwardRecentRoundItemView.C;
            resultRecord = forwardRecentRoundItemView.F;
        } else {
            str = "";
            resultRecord = null;
        }
        if (resultRecord != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("uintype", resultRecord.getUinType());
            bundle.putString("uin", resultRecord.uin);
            if (resultRecord.getUinType() != 1 && resultRecord.getUinType() != 3000) {
                str2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(resultRecord.uin);
            } else {
                str2 = resultRecord.uin;
            }
            bundle.putString(AppConstants.Key.UID, str2);
            bundle.putString("troop_uin", resultRecord.groupUin);
            bundle.putString("guild_id", resultRecord.guildId);
            if (resultRecord.getUinType() == 3000) {
                bundle.putString("uinname", ForwardUtils.r(getMApp(), str, resultRecord.uin));
            } else if (resultRecord.getUinType() == 1) {
                Bundle mExtraData = getMExtraData();
                if (mExtraData == null) {
                    return;
                } else {
                    bundle.putString("uinname", ForwardUtils.s(getMApp(), resultRecord.uin, mExtraData.getInt("forward_type", -1), str));
                }
            } else if (resultRecord.getUinType() == 10014) {
                if (TextUtils.isEmpty(resultRecord.guildId)) {
                    str3 = resultRecord.uin;
                } else {
                    str3 = resultRecord.guildId;
                }
                bundle.putString("guild_id", str3);
                if (TextUtils.isEmpty(str)) {
                    str = resultRecord.name;
                }
                bundle.putString("uinname", str);
            } else if (resultRecord.getUinType() == 1046) {
                bundle.putString("uin", resultRecord.uin);
                bundle.putString("uinname", resultRecord.name);
            } else {
                bundle.putString("uinname", str);
            }
            bundle.putBoolean("forward_report_confirm", true);
            bundle.putString("forward_report_confirm_action_name", "0X8005A13");
            bundle.putString("forward_report_confirm_reverse2", "5");
            Integer QQCUSTOM_DIALOG_FROM_RECOMMEND = QQCustomDialogWtihInputAndChoose.f307202c0;
            Intrinsics.checkNotNullExpressionValue(QQCUSTOM_DIALOG_FROM_RECOMMEND, "QQCUSTOM_DIALOG_FROM_RECOMMEND");
            bundle.putInt("chooseFriendFrom", QQCUSTOM_DIALOG_FROM_RECOMMEND.intValue());
            Bundle mExtraData2 = getMExtraData();
            bundle.putString("caller_name", mExtraData2 != null ? mExtraData2.getString("caller_name") : null);
            if (getMExtraData() != null) {
                Bundle mExtraData3 = getMExtraData();
                boolean z16 = false;
                if (mExtraData3 != null && mExtraData3.getBoolean("needShareCallBack")) {
                    z16 = true;
                }
                bundle.putBoolean("needShareCallBack", z16);
                Bundle mExtraData4 = getMExtraData();
                if (mExtraData4 != null) {
                    bundle.putInt("miniAppShareFrom", mExtraData4.getInt("miniAppShareFrom", -1));
                }
            }
            com.tencent.mobileqq.filemanager.fileassistant.util.h.v(getMApp(), getActivity().getIntent(), bundle);
            if (QLog.isColorLevel()) {
                QLog.i("ForwardFriend..RecentContentRefreshPart", 2, "[FORWARD_SHOW_DIALOG]invoke mForwardOption.buildForwardDialog uin=" + com.tencent.mobileqq.qcall.g.b(resultRecord.uin));
            }
            dq2.a B9 = B9();
            if (B9 != null) {
                B9.u2(resultRecord);
            }
            showConfirmDialog();
            if (resultRecord.getUinType() == 3000 || resultRecord.getUinType() == 1) {
                new com.tencent.mobileqq.statistics.q(getMApp()).i("dc00899").a("Grp_listNew").f("send_to").d("clk_grp").b("0").g();
            }
            ReportController.o(getMApp(), "CliOper", "", "", "friendchoose", "0X8009D90", I9(), 0, "", "", "", x9());
        }
    }

    private final void Ga() {
        if (getMApp() == null) {
            return;
        }
        ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(getMApp(), new d(), false);
    }

    private final void Ha() {
        MutableLiveData<Boolean> M1;
        MutableLiveData<Boolean> d26;
        MutableLiveData<Boolean> g26;
        MutableLiveData<Boolean> U1;
        MutableLiveData<Boolean> W1;
        MutableLiveData<Boolean> c26;
        MutableLiveData<String> Z1;
        MutableLiveData<View> W12;
        MutableLiveData<ResultRecord> N1;
        MutableLiveData<List<ResultRecord>> X1;
        MutableLiveData<Boolean> e26;
        dq2.a B9 = B9();
        if (B9 != null && (e26 = B9.e2()) != null) {
            ComponentCallbacks2 activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$1
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
                    RecentContentRefreshPart.this.Za();
                }
            };
            e26.observe((LifecycleOwner) activity, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Ia(Function1.this, obj);
                }
            });
        }
        dq2.a B92 = B9();
        if (B92 != null && (X1 = B92.X1()) != null) {
            ComponentCallbacks2 activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<List<? extends ResultRecord>, Unit> function12 = new Function1<List<? extends ResultRecord>, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ResultRecord> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends ResultRecord> it) {
                    RecentContentRefreshPart recentContentRefreshPart = RecentContentRefreshPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    recentContentRefreshPart.Ta(it);
                }
            };
            X1.observe((LifecycleOwner) activity2, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.r
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Ja(Function1.this, obj);
                }
            });
        }
        dq2.a B93 = B9();
        if (B93 != null && (N1 = B93.N1()) != null) {
            ComponentCallbacks2 activity3 = getActivity();
            Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<ResultRecord, Unit> function13 = new Function1<ResultRecord, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResultRecord resultRecord) {
                    invoke2(resultRecord);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ResultRecord it) {
                    RecentContentRefreshPart recentContentRefreshPart = RecentContentRefreshPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    recentContentRefreshPart.va(it);
                }
            };
            N1.observe((LifecycleOwner) activity3, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.La(Function1.this, obj);
                }
            });
        }
        dq2.a B94 = B9();
        if (B94 != null && (W12 = B94.W1()) != null) {
            ComponentCallbacks2 activity4 = getActivity();
            Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<View, Unit> function14 = new Function1<View, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    RecentContentRefreshPart recentContentRefreshPart = RecentContentRefreshPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    recentContentRefreshPart.Fa(it);
                }
            };
            W12.observe((LifecycleOwner) activity4, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Ma(Function1.this, obj);
                }
            });
        }
        dq2.a B95 = B9();
        if (B95 != null && (Z1 = B95.Z1()) != null) {
            ComponentCallbacks2 activity5 = getActivity();
            Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<String, Unit> function15 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    RecentContentRefreshPart.this.M9(str);
                }
            };
            Z1.observe((LifecycleOwner) activity5, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Na(Function1.this, obj);
                }
            });
        }
        dq2.a B96 = B9();
        if (B96 != null && (c26 = B96.c2()) != null) {
            ComponentCallbacks2 activity6 = getActivity();
            Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$6
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
                    RecentContentRefreshPart.this.showConfirmDialog();
                }
            };
            c26.observe((LifecycleOwner) activity6, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Oa(Function1.this, obj);
                }
            });
        }
        dq2.b E9 = E9();
        if (E9 != null && (W1 = E9.W1()) != null) {
            ComponentCallbacks2 activity7 = getActivity();
            Intrinsics.checkNotNull(activity7, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function17 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$7
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
                    RecentContentRefreshPart.this.Xa();
                }
            };
            W1.observe((LifecycleOwner) activity7, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Pa(Function1.this, obj);
                }
            });
        }
        dq2.b E92 = E9();
        if (E92 != null && (U1 = E92.U1()) != null) {
            ComponentCallbacks2 activity8 = getActivity();
            Intrinsics.checkNotNull(activity8, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function18 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$8
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
                    RecentContentRefreshPart.this.Va(true);
                }
            };
            U1.observe((LifecycleOwner) activity8, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.x
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Qa(Function1.this, obj);
                }
            });
        }
        dq2.a B97 = B9();
        if (B97 != null && (g26 = B97.g2()) != null) {
            ComponentCallbacks2 activity9 = getActivity();
            Intrinsics.checkNotNull(activity9, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function19 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$9
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
                    MutableLiveData<Boolean> L1;
                    dq2.g H9 = RecentContentRefreshPart.this.H9();
                    if (H9 == null || (L1 = H9.L1()) == null) {
                        return;
                    }
                    L1.postValue(bool);
                }
            };
            g26.observe((LifecycleOwner) activity9, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.y
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Ra(Function1.this, obj);
                }
            });
        }
        dq2.a B98 = B9();
        if (B98 != null && (d26 = B98.d2()) != null) {
            ComponentCallbacks2 activity10 = getActivity();
            Intrinsics.checkNotNull(activity10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            final Function1<Boolean, Unit> function110 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$10
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
                    RecentContentRefreshPart.this.Ua();
                }
            };
            d26.observe((LifecycleOwner) activity10, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecentContentRefreshPart.Sa(Function1.this, obj);
                }
            });
        }
        dq2.b E93 = E9();
        if (E93 == null || (M1 = E93.M1()) == null) {
            return;
        }
        ComponentCallbacks2 activity11 = getActivity();
        Intrinsics.checkNotNull(activity11, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        final Function1<Boolean, Unit> function111 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.selectfriend.part.RecentContentRefreshPart$registerObserver$11
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
                RecentContentRefreshPart.this.Aa();
            }
        };
        M1.observe((LifecycleOwner) activity11, new Observer() { // from class: com.tencent.mobileqq.selectfriend.part.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecentContentRefreshPart.Ka(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ta(List<? extends ResultRecord> resultRecord) {
        MutableLiveData<List<String>> M1;
        MutableLiveData<Boolean> L1;
        MutableLiveData<Boolean> Q1;
        dq2.b E9 = E9();
        if (E9 != null && (Q1 = E9.Q1()) != null) {
            Q1.postValue(Boolean.TRUE);
        }
        dq2.g H9 = H9();
        if (H9 != null && (L1 = H9.L1()) != null) {
            L1.postValue(Boolean.TRUE);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = resultRecord.iterator();
        while (it.hasNext()) {
            String str = ((ResultRecord) it.next()).uin;
            Intrinsics.checkNotNullExpressionValue(str, "target.uin");
            arrayList.add(str);
        }
        dq2.f G9 = G9();
        if (G9 == null || (M1 = G9.M1()) == null) {
            return;
        }
        M1.postValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua() {
        if (this.mForwardCountLimitDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCountLimitDialog");
        }
        if (getActivity().isFinishing()) {
            return;
        }
        Dialog dialog = this.mForwardCountLimitDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mForwardCountLimitDialog");
            dialog = null;
        }
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Va(final boolean needCheckBoxAnimation) {
        MutableLiveData<Boolean> L1;
        LinkedHashMap<String, ResultRecord> U1;
        com.tencent.mobileqq.selectfriend.part.adapter.e eVar = this.mRecentChatHeadAdapter;
        RecyclerView recyclerView = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatHeadAdapter");
            eVar = null;
        }
        zp2.b mRecentHeadData = eVar.getMRecentHeadData();
        Bundle mExtraData = getMExtraData();
        Integer valueOf = mExtraData != null ? Integer.valueOf(mExtraData.getInt("key_chat_list_head_style", 0)) : null;
        dq2.a B9 = B9();
        if (B9 != null && (U1 = B9.U1()) != null) {
            U1.clear();
        }
        Bundle mExtraData2 = getMExtraData();
        if (mExtraData2 != null) {
            mExtraData2.remove(AppConstants.Key.FORWARD_MULTI_TARGET);
        }
        com.tencent.mobileqq.selectfriend.enter.select.a.INSTANCE.a().e(true);
        com.tencent.mobileqq.selectfriend.part.adapter.h hVar = this.mRecentForwardAdapter;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentForwardAdapter");
            hVar = null;
        }
        hVar.l0(true);
        dq2.c F9 = F9();
        if (F9 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            F9.M1(context, valueOf, mRecentHeadData);
        }
        com.tencent.mobileqq.selectfriend.part.adapter.e eVar2 = this.mRecentChatHeadAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatHeadAdapter");
            eVar2 = null;
        }
        eVar2.notifyDataSetChanged();
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.part.p
            @Override // java.lang.Runnable
            public final void run() {
                RecentContentRefreshPart.Wa(RecentContentRefreshPart.this, needCheckBoxAnimation);
            }
        }, 1L);
        dq2.g H9 = H9();
        if (H9 == null || (L1 = H9.L1()) == null) {
            return;
        }
        L1.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wa(RecentContentRefreshPart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        RecentChatListAdapter recentChatListAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        int childCount = recyclerView.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            RecyclerView recyclerView2 = this$0.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView2 = null;
            }
            View childAt = recyclerView2.getChildAt(i3);
            if (childAt != null) {
                if (childAt instanceof ForwardRecentItemView) {
                    ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) childAt;
                    if (Intrinsics.areEqual("view_from_recent_chat", forwardRecentItemView.getTag())) {
                        if (z16) {
                            forwardRecentItemView.g(150L);
                        } else {
                            forwardRecentItemView.g(0L);
                        }
                        i3++;
                    }
                }
                if (childAt instanceof ForwardRecentRoundItemView) {
                    ((ForwardRecentRoundItemView) childAt).e();
                }
                i3++;
            }
        }
        com.tencent.mobileqq.selectfriend.part.adapter.h hVar = this$0.mRecentForwardAdapter;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentForwardAdapter");
            hVar = null;
        }
        hVar.l0(false);
        RecentChatListAdapter recentChatListAdapter2 = this$0.mRecentChatListAdapter;
        if (recentChatListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatListAdapter");
        } else {
            recentChatListAdapter = recentChatListAdapter2;
        }
        recentChatListAdapter.setIsMultiSelectStatus(false);
        com.tencent.mobileqq.selectfriend.enter.select.a.INSTANCE.a().e(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xa() {
        com.tencent.mobileqq.selectfriend.part.adapter.e eVar = this.mRecentChatHeadAdapter;
        RecyclerView recyclerView = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatHeadAdapter");
            eVar = null;
        }
        zp2.b mRecentHeadData = eVar.getMRecentHeadData();
        Bundle mExtraData = getMExtraData();
        Integer valueOf = mExtraData != null ? Integer.valueOf(mExtraData.getInt("key_chat_list_head_style", 0)) : null;
        dq2.a B9 = B9();
        Boolean valueOf2 = B9 != null ? Boolean.valueOf(B9.getMIsShowGuildEntrance()) : null;
        com.tencent.mobileqq.selectfriend.enter.select.a.INSTANCE.a().e(false);
        com.tencent.mobileqq.selectfriend.part.adapter.h hVar = this.mRecentForwardAdapter;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentForwardAdapter");
            hVar = null;
        }
        hVar.l0(false);
        dq2.c F9 = F9();
        if (F9 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            F9.N1(context, valueOf, valueOf2, mRecentHeadData);
        }
        com.tencent.mobileqq.selectfriend.part.adapter.e eVar2 = this.mRecentChatHeadAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatHeadAdapter");
            eVar2 = null;
        }
        eVar2.notifyDataSetChanged();
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectfriend.part.o
            @Override // java.lang.Runnable
            public final void run() {
                RecentContentRefreshPart.Ya(RecentContentRefreshPart.this);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(RecentContentRefreshPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        RecentChatListAdapter recentChatListAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        int childCount = recyclerView.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            RecyclerView recyclerView2 = this$0.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView2 = null;
            }
            View childAt = recyclerView2.getChildAt(i3);
            if (childAt != null) {
                if (childAt instanceof ForwardRecentItemView) {
                    ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) childAt;
                    if (Intrinsics.areEqual("view_from_recent_chat", forwardRecentItemView.getTag())) {
                        forwardRecentItemView.h(150L);
                        i3++;
                    }
                }
                if (childAt instanceof ForwardRecentRoundItemView) {
                    ((ForwardRecentRoundItemView) childAt).f();
                }
                i3++;
            }
        }
        com.tencent.mobileqq.selectfriend.part.adapter.h hVar = this$0.mRecentForwardAdapter;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentForwardAdapter");
            hVar = null;
        }
        hVar.l0(true);
        RecentChatListAdapter recentChatListAdapter2 = this$0.mRecentChatListAdapter;
        if (recentChatListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatListAdapter");
        } else {
            recentChatListAdapter = recentChatListAdapter2;
        }
        recentChatListAdapter.setIsMultiSelectStatus(true);
        com.tencent.mobileqq.selectfriend.enter.select.a.INSTANCE.a().e(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Za() {
        if (this.mRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        }
        RecentChatListAdapter recentChatListAdapter = this.mRecentChatListAdapter;
        if (recentChatListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatListAdapter");
            recentChatListAdapter = null;
        }
        recentChatListAdapter.notifyDataSetChanged();
        com.tencent.mobileqq.selectfriend.part.adapter.h hVar = this.mRecentForwardAdapter;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentForwardAdapter");
            hVar = null;
        }
        HorizontalListView i06 = hVar.i0();
        ListAdapter adapter = i06 != null ? i06.getAdapter() : null;
        if (adapter == null || !(adapter instanceof ForwardSelectionRecentFriendGridAdapter)) {
            return;
        }
        ((ForwardSelectionRecentFriendGridAdapter) adapter).notifyDataSetChanged();
        com.tencent.mobileqq.selectfriend.enter.select.a.INSTANCE.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConfirmDialog() {
        MutableLiveData<Boolean> c26;
        LinkedHashMap<String, ResultRecord> R1;
        LinkedHashMap<String, ResultRecord> R12;
        dq2.a B9 = B9();
        Collection<ResultRecord> values = (B9 == null || (R12 = B9.R1()) == null) ? null : R12.values();
        if (values == null || values.isEmpty()) {
            return;
        }
        Bundle mExtraData = getMExtraData();
        if (mExtraData != null) {
            mExtraData.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, new ArrayList<>(values));
        }
        dq2.a B92 = B9();
        if (B92 != null && (R1 = B92.R1()) != null) {
            R1.clear();
        }
        dq2.a B93 = B9();
        if (B93 == null || (c26 = B93.c2()) == null) {
            return;
        }
        c26.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va(ResultRecord resultRecord) {
        LinkedHashMap<String, ResultRecord> R1;
        MutableLiveData<List<String>> M1;
        MutableLiveData<Boolean> L1;
        MutableLiveData<Boolean> Q1;
        ResultRecord resultRecord2 = ResultRecord.copyResultRecord(resultRecord);
        resultRecord2.lastChooseTime = SystemClock.elapsedRealtime();
        dq2.a B9 = B9();
        if (B9 != null) {
            Intrinsics.checkNotNullExpressionValue(resultRecord2, "resultRecord");
            B9.u2(resultRecord2);
        }
        dq2.b E9 = E9();
        if (E9 != null && (Q1 = E9.Q1()) != null) {
            Q1.postValue(Boolean.TRUE);
        }
        dq2.g H9 = H9();
        if (H9 != null && (L1 = H9.L1()) != null) {
            L1.postValue(Boolean.TRUE);
        }
        dq2.a B92 = B9();
        if (B92 == null || (R1 = B92.R1()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = R1.values().iterator();
        while (it.hasNext()) {
            String str = it.next().uin;
            Intrinsics.checkNotNullExpressionValue(str, "target.uin");
            arrayList.add(str);
        }
        dq2.f G9 = G9();
        if (G9 == null || (M1 = G9.M1()) == null) {
            return;
        }
        M1.postValue(arrayList);
    }

    private final void wa() {
        IRecentUserProxyService iRecentUserProxyService;
        ArrayList<RecentUser> arrayList;
        zp2.b bVar;
        RFWConcatAdapter rFWConcatAdapter;
        View findViewById = getPartRootView().findViewById(R.id.ot7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mRecyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        new OverScrollDecorator(recyclerView);
        com.tencent.mobileqq.selectfriend.part.adapter.b bVar2 = new com.tencent.mobileqq.selectfriend.part.adapter.b(getContext(), C9());
        this.mBlankIntervalAdapter = bVar2;
        bVar2.setHasStableIds(true);
        if (this.mBlankIntervalAdapter != null) {
            RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
            RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
            com.tencent.mobileqq.selectfriend.part.adapter.b bVar3 = this.mBlankIntervalAdapter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlankIntervalAdapter");
                bVar3 = null;
            }
            adapterArr[0] = bVar3;
            this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        }
        FSLayoutData mFsLayoutData = getMFsLayoutData();
        if (mFsLayoutData != null && mFsLayoutData.c() == 1) {
            b.Companion companion = com.tencent.mobileqq.selectfriend.enter.select.b.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> a16 = companion.a(context, C9());
            List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list = a16;
            if (!(list == null || list.isEmpty())) {
                int size = a16.size();
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter = a16.get(i3);
                    if (adapter != null && (adapter instanceof com.tencent.mobileqq.selectfriend.adapter.a)) {
                        com.tencent.mobileqq.selectfriend.adapter.a aVar = (com.tencent.mobileqq.selectfriend.adapter.a) adapter;
                        if (aVar.isSupportShow()) {
                            com.tencent.mobileqq.selectfriend.processor.d dVar = this.mForwardBaseProcessor;
                            if (dVar != null && dVar.A(aVar.getNodeType())) {
                                FSForwardData<Bundle> C9 = C9();
                                if (aVar.isSupportCurrentForwardContentType(C9 != null ? Integer.valueOf(C9.a()) : null)) {
                                    RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
                                    if (rFWConcatAdapter2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                                        rFWConcatAdapter2 = null;
                                    }
                                    rFWConcatAdapter2.addAdapter(aVar);
                                }
                            }
                        }
                    }
                }
            }
        }
        QQAppInterface mApp = getMApp();
        if (mApp == null || (iRecentUserProxyService = (IRecentUserProxyService) mApp.getRuntimeService(IRecentUserProxyService.class, "")) == null) {
            return;
        }
        IRecentForwardUserProxy recentForwardCache = iRecentUserProxyService.getRecentForwardCache();
        Bundle mExtraData = getMExtraData();
        if ((mExtraData == null || mExtraData.getBoolean(ForwardRecentActivity.KEY_FORWARD_SHARE_MATCH_FRIEND_LIST, false)) ? false : true) {
            arrayList = (ArrayList) (recentForwardCache != null ? recentForwardCache.getRecentList(true) : null);
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            za(arrayList);
        }
        if (arrayList != null && arrayList.size() > 0) {
            com.tencent.mobileqq.selectfriend.part.adapter.h hVar = new com.tencent.mobileqq.selectfriend.part.adapter.h(getContext(), C9(), this.mForwardRecentListAdapterCallback);
            this.mRecentForwardAdapter = hVar;
            hVar.m0(arrayList);
            com.tencent.mobileqq.selectfriend.part.adapter.h hVar2 = this.mRecentForwardAdapter;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentForwardAdapter");
                hVar2 = null;
            }
            hVar2.setHasStableIds(true);
            if (this.mRecentForwardAdapter != null && (rFWConcatAdapter = this.mConcatAdapter) != null) {
                if (rFWConcatAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                    rFWConcatAdapter = null;
                }
                com.tencent.mobileqq.selectfriend.part.adapter.h hVar3 = this.mRecentForwardAdapter;
                if (hVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecentForwardAdapter");
                    hVar3 = null;
                }
                rFWConcatAdapter.addAdapter(hVar3);
            }
        }
        RFWConcatAdapter rFWConcatAdapter3 = this.mConcatAdapter;
        if (rFWConcatAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
            rFWConcatAdapter3 = null;
        }
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = rFWConcatAdapter3.getAdapters();
        Integer valueOf = adapters != null ? Integer.valueOf(adapters.size()) : null;
        if (valueOf != null && valueOf.intValue() > 1) {
            com.tencent.mobileqq.selectfriend.part.adapter.b bVar4 = new com.tencent.mobileqq.selectfriend.part.adapter.b(getContext(), C9());
            bVar4.setHasStableIds(true);
            RFWConcatAdapter rFWConcatAdapter4 = this.mConcatAdapter;
            if (rFWConcatAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter4 = null;
            }
            rFWConcatAdapter4.addAdapter(bVar4);
        }
        b bVar5 = new b();
        dq2.c F9 = F9();
        if (F9 != null) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            bVar = F9.L1(context2, getMExtraData());
        } else {
            bVar = null;
        }
        if (bVar != null) {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            this.mRecentChatHeadAdapter = new com.tencent.mobileqq.selectfriend.part.adapter.e(context3, bVar, bVar5);
        }
        com.tencent.mobileqq.selectfriend.part.adapter.e eVar = this.mRecentChatHeadAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentChatHeadAdapter");
            eVar = null;
        }
        eVar.setHasStableIds(true);
        if (this.mRecentChatHeadAdapter != null) {
            RFWConcatAdapter rFWConcatAdapter5 = this.mConcatAdapter;
            if (rFWConcatAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter5 = null;
            }
            com.tencent.mobileqq.selectfriend.part.adapter.e eVar2 = this.mRecentChatHeadAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentChatHeadAdapter");
                eVar2 = null;
            }
            rFWConcatAdapter5.addAdapter(eVar2);
        }
        com.tencent.mobileqq.selectfriend.enter.select.a a17 = com.tencent.mobileqq.selectfriend.enter.select.a.INSTANCE.a();
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> c16 = a17.c(context4, C9());
        List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list2 = c16;
        if (!(list2 == null || list2.isEmpty())) {
            int size2 = c16.size();
            for (int i16 = 0; i16 < size2; i16++) {
                RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter2 = c16.get(i16);
                if (adapter2 != null && (adapter2 instanceof com.tencent.mobileqq.selectfriend.adapter.a)) {
                    com.tencent.mobileqq.selectfriend.adapter.a aVar2 = (com.tencent.mobileqq.selectfriend.adapter.a) adapter2;
                    if (aVar2.isSupportShow()) {
                        com.tencent.mobileqq.selectfriend.processor.d dVar2 = this.mForwardBaseProcessor;
                        if (dVar2 != null && dVar2.A(aVar2.getNodeType())) {
                            RFWConcatAdapter rFWConcatAdapter6 = this.mConcatAdapter;
                            if (rFWConcatAdapter6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                                rFWConcatAdapter6 = null;
                            }
                            rFWConcatAdapter6.addAdapter(aVar2);
                        }
                    }
                }
            }
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.setItemAnimator(null);
            RecyclerView recyclerView4 = this.mRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView4 = null;
            }
            RFWConcatAdapter rFWConcatAdapter7 = this.mConcatAdapter;
            if (rFWConcatAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter7 = null;
            }
            recyclerView4.setAdapter(rFWConcatAdapter7);
            RecyclerView recyclerView5 = this.mRecyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            } else {
                recyclerView2 = recyclerView5;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
            if (linearLayoutManager != null) {
                linearLayoutManager.setOrientation(1);
            }
        }
        Ga();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa(Intent intent) {
        dq2.a B9 = B9();
        boolean z16 = false;
        if (B9 != null && B9.getMIsSdkShare()) {
            z16 = true;
        }
        if (z16) {
            Ca();
            intent.putExtra(ForwardRecentActivity.PARAM_BIND_FINISH, true);
        }
    }

    private final void za(ArrayList<RecentUser> recentForwardList) {
        dq2.a B9;
        if (getActivity() == null || !(getActivity() instanceof QPublicFragmentActivity) || (B9 = B9()) == null) {
            return;
        }
        B9.M1(getMApp(), recentForwardList, getMFsLayoutData(), C9(), this.mForwardBaseProcessor);
    }

    public List<RecyclerView.Adapter<?>> Ba() {
        RFWConcatAdapter rFWConcatAdapter = this.mConcatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
            rFWConcatAdapter = null;
        }
        return rFWConcatAdapter.getAdapters();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        Da();
        wa();
        Ha();
    }

    @Override // com.tencent.mobileqq.selectfriend.part.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RecentChatListAdapter recentChatListAdapter = this.mRecentChatListAdapter;
        BroadcastReceiver broadcastReceiver = null;
        if (recentChatListAdapter != null) {
            if (recentChatListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecentChatListAdapter");
                recentChatListAdapter = null;
            }
            recentChatListAdapter.destroy();
        }
        BroadcastReceiver broadcastReceiver2 = this.mBindFinishReceiver;
        if (broadcastReceiver2 != null && activity != null) {
            if (broadcastReceiver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindFinishReceiver");
            } else {
                broadcastReceiver = broadcastReceiver2;
            }
            activity.unregisterReceiver(broadcastReceiver);
        }
        com.tencent.mobileqq.selectfriend.enter.select.a.INSTANCE.a().b();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        MutableLiveData<Boolean> c26;
        if (resultCode == -1 && requestCode == 20003) {
            Boolean valueOf = data != null ? Boolean.valueOf(data.getBooleanExtra("select_memeber_single_friend", false)) : null;
            dq2.a B9 = B9();
            String mAppid = B9 != null ? B9.getMAppid() : null;
            dq2.a B92 = B9();
            Boolean valueOf2 = B92 != null ? Boolean.valueOf(B92.getMIsSdkShare()) : null;
            if (valueOf != null && valueOf.booleanValue()) {
                if (data != null) {
                    data.getExtras();
                }
                Integer valueOf3 = data != null ? Integer.valueOf(data.getIntExtra("select_memeber_single_friend_type", 2)) : null;
                if (valueOf3 != null && valueOf3.intValue() == 4) {
                    valueOf3 = 1;
                }
                if (valueOf3 != null && valueOf3.intValue() == 0) {
                    valueOf3 = 2;
                }
                Bundle mExtraData = getMExtraData();
                if (mExtraData != null) {
                    mExtraData.putBoolean("forward_report_confirm", true);
                }
                Bundle mExtraData2 = getMExtraData();
                if (mExtraData2 != null) {
                    mExtraData2.putString("forward_report_confirm_action_name", "0X8005A14");
                }
                Bundle mExtraData3 = getMExtraData();
                if (mExtraData3 != null) {
                    mExtraData3.putString("forward_report_confirm_reverse2", String.valueOf(valueOf3));
                }
                dq2.a B93 = B9();
                if (B93 != null && (c26 = B93.c2()) != null) {
                    c26.postValue(Boolean.TRUE);
                }
                ReportCenter f16 = ReportCenter.f();
                QQAppInterface mApp = getMApp();
                f16.q(mApp != null ? mApp.getAccount() : null, "", mAppid, "1000", "30", "0", false, Intrinsics.areEqual(valueOf2, Boolean.TRUE));
                return;
            }
            if (!StringUtil.isEmpty(data != null ? data.getStringExtra("roomId") : null)) {
                Ga();
                ReportController.o(getMApp(), "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
                Integer valueOf4 = data != null ? Integer.valueOf(data.getIntExtra("select_memeber_discussion_memeber_count", 0)) : null;
                Bundle bundle = new Bundle();
                bundle.putBoolean("forward_report_confirm", true);
                bundle.putString("forward_report_confirm_action_name", "0X8005A15");
                bundle.putString("forward_report_confirm_reverse2", valueOf4 != null ? Integer.toString(valueOf4.intValue()) : null);
            }
            ReportCenter f17 = ReportCenter.f();
            QQAppInterface mApp2 = getMApp();
            f17.p(mApp2 != null ? mApp2.getAccount() : null, "", mAppid, "1000", "32", "0", Intrinsics.areEqual(valueOf2, Boolean.TRUE));
        }
    }
}
