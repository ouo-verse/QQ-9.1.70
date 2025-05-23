package com.tencent.mobileqq.selectfriend.part.adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.enter.select.SelectEnterBaseAdapter;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B#\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/SelectFriendEnterAdapter;", "Lcom/tencent/mobileqq/selectfriend/enter/select/SelectEnterBaseAdapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/SelectFriendEnterAdapter$b;", "Lmqq/app/AppActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "initBindFinishReceiver", "reportClickEvent", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "Landroid/view/View;", "v", "forwardRecentItemViewOnClick", "getItemCount", "", "getItemId", "", "isSupportShow", "getNodeType", "Landroid/content/BroadcastReceiver;", "bindFinishReceiver", "Landroid/content/BroadcastReceiver;", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "getReportFromType", "()I", "reportFromType", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "fsForwardData", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;)V", "Companion", "a", "b", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SelectFriendEnterAdapter extends SelectEnterBaseAdapter<b> {
    public static final String TAG = "SelectFriendEnterAdapter";
    private BroadcastReceiver bindFinishReceiver;
    private Bundle bundle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/SelectFriendEnterAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "setTvFriendContact", "(Landroid/widget/TextView;)V", "tvFriendContact", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView tvFriendContact;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.osw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.btn_friend_contact)");
            this.tvFriendContact = (TextView) findViewById;
        }

        /* renamed from: l, reason: from getter */
        public final TextView getTvFriendContact() {
            return this.tvFriendContact;
        }
    }

    public SelectFriendEnterAdapter(Context context, FSForwardData<Bundle> fSForwardData) {
        super(context, fSForwardData);
        if (fSForwardData != null) {
            this.bundle = fSForwardData.b();
        }
    }

    private final int getReportFromType() {
        Bundle b16;
        FSForwardData<Bundle> mFsForwardData = getMFsForwardData();
        if (mFsForwardData == null || (b16 = mFsForwardData.b()) == null) {
            return 1;
        }
        if (b16.getBoolean("isFromShare", false)) {
            return 2;
        }
        return b16.getBoolean("isWebCompShare", false) ? 3 : 1;
    }

    private final void initBindFinishReceiver(final AppActivity activity) {
        if (this.bindFinishReceiver == null) {
            this.bindFinishReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.selectfriend.part.adapter.SelectFriendEnterAdapter$initBindFinishReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    if (AppActivity.this.isFinishing()) {
                        return;
                    }
                    AppActivity.this.finish();
                }
            };
            Context mContext = getMContext();
            if (mContext != null) {
                mContext.registerReceiver(this.bindFinishReceiver, new IntentFilter(ForwardRecentActivity.ACTION_BIND_FINISH));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SelectFriendEnterAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.forwardRecentItemViewOnClick(view);
    }

    private final void reportClickEvent(AppActivity activity) {
        AppRuntime appRuntime = activity.getAppRuntime();
        if (appRuntime == null) {
            return;
        }
        Bundle bundle = this.bundle;
        Intrinsics.checkNotNull(bundle);
        if (bundle.getBoolean("is_to_pay_list")) {
            Bundle bundle2 = this.bundle;
            Intrinsics.checkNotNull(bundle2);
            int i3 = bundle2.getInt("choose_friend_businessType");
            Bundle bundle3 = this.bundle;
            Intrinsics.checkNotNull(bundle3);
            int i16 = bundle3.getInt("choose_friend_businessSubType");
            if (i3 == 1 && i16 == 1) {
                ReportController.o(appRuntime, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.buyerselectpage.select", 0, 0, "", "", "", "");
            } else if (i3 == 1 && i16 == 2) {
                ReportController.o(appRuntime, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.payerselectpage.select", 0, 0, "", "", "", "");
            }
        }
        ReportController.o(appRuntime, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
        ReportController.o(appRuntime, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
        ReportController.o(appRuntime, "CliOper", "", "", "friendchoose", "0X8009D95", getReportFromType(), 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public void forwardRecentItemViewOnClick(View v3) {
        if (getMContext() == null || !(getMContext() instanceof AppActivity)) {
            return;
        }
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type mqq.app.AppActivity");
        AppActivity appActivity = (AppActivity) mContext;
        reportDataForBusiness("0X8007824");
        reportClickEvent(appActivity);
        Intent intent = new Intent();
        Bundle bundle = this.bundle;
        Intrinsics.checkNotNull(bundle);
        intent.putExtras(bundle);
        FSForwardData<Bundle> mFsForwardData = getMFsForwardData();
        Integer valueOf = mFsForwardData != null ? Integer.valueOf(mFsForwardData.a()) : null;
        if (valueOf != null && valueOf.intValue() == 11) {
            initBindFinishReceiver(appActivity);
            intent.putExtra(ForwardRecentActivity.PARAM_BIND_FINISH, true);
        }
        if (getMContext() != null) {
            Context mContext2 = getMContext();
            Intrinsics.checkNotNull(mContext2);
            intent.setClass(mContext2, ForwardFriendListActivity.class);
        }
        appActivity.startActivityForResult(intent, 20000);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return hashCode();
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public int getNodeType() {
        return 1;
    }

    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public boolean isSupportShow() {
        boolean z16 = !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getAllFriend(TAG).isEmpty();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->allowFriendAbility--allow = " + z16);
        }
        return z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getTvFriendContact().setText(holder.getTvFriendContact().getContext().getResources().getString(R.string.x47));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.part.adapter.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectFriendEnterAdapter.onBindViewHolder$lambda$0(SelectFriendEnterAdapter.this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cym, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026      false\n            )");
        return new b(inflate);
    }
}
