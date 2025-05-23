package com.tencent.mobileqq.selectfriend.part.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import k0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000256B#\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010$\u00a2\u0006\u0004\b2\u00103J0\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J&\u0010\u001d\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u0004\u0018\u00010(8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/MyBaseAdapter;", "Lcom/tencent/mobileqq/selectfriend/adapter/a;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/MyBaseAdapter$b;", "", "inputStr", IProfileProtocolConst.PARAM_TARGET_UIN, "Lk0/a$c;", "cb", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "sendOldDataLineMessage", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "", "getItemId", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/selectfriend/callback/a;", "callback", "sendToNode", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "mFsForwardData", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "mResultRecords", "Ljava/util/List;", "getResultRecord", "()Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;)V", "Companion", "a", "b", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class MyBaseAdapter extends com.tencent.mobileqq.selectfriend.adapter.a<b> {
    private static final String TAG = "ForwardFriend.MyBaseAdapter";
    private Context mContext;
    private final FSForwardData<Bundle> mFsForwardData;
    private final List<ResultRecord> mResultRecords;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/MyBaseAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "E", "Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "l", "()Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;", "setForwardRecentItemView", "(Lcom/tencent/mobileqq/adapter/ForwardRecentItemView;)V", "forwardRecentItemView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private ForwardRecentItemView forwardRecentItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.osy);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(co\u2026ward_recent_item_view_my)");
            this.forwardRecentItemView = (ForwardRecentItemView) findViewById;
        }

        /* renamed from: l, reason: from getter */
        public final ForwardRecentItemView getForwardRecentItemView() {
            return this.forwardRecentItemView;
        }
    }

    public MyBaseAdapter(Context context, FSForwardData<Bundle> fSForwardData) {
        this.mContext = context;
        this.mFsForwardData = fSForwardData;
        ArrayList arrayList = new ArrayList();
        this.mResultRecords = arrayList;
        arrayList.add(getResultRecord());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MyBaseAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.forwardRecentItemViewOnClick(view);
    }

    protected abstract Drawable getDrawable();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getMContext() {
        return this.mContext;
    }

    protected abstract ResultRecord getResultRecord();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, mqq.app.AppActivity] */
    @Override // com.tencent.mobileqq.selectfriend.adapter.a
    public void sendToNode(Context context, Bundle extraData, com.tencent.mobileqq.selectfriend.callback.a callback) {
        if (!(context instanceof AppActivity)) {
            if (callback != null) {
                callback.a(1, "context !is AppActivity");
                return;
            }
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r102 = (AppActivity) context;
        objectRef.element = r102;
        AppRuntime appRuntime = r102.getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        Intent intent = new Intent();
        c cVar = new c(objectRef);
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.DataLineHandler");
        DataLineHandler dataLineHandler = (DataLineHandler) businessHandler;
        String string = extraData != null ? extraData.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE) : null;
        intent.putExtra("dataline_forward_type", 102);
        intent.putExtra("dataline_forward_text", extraData != null ? extraData.getString(AppConstants.Key.FORWARD_TEXT) : null);
        String DATALINE_PC_UIN = AppConstants.DATALINE_PC_UIN;
        Intrinsics.checkNotNullExpressionValue(DATALINE_PC_UIN, "DATALINE_PC_UIN");
        if (extraData != null) {
            extraData.putAll(intent.getExtras());
        }
        int r16 = dataLineHandler.y3().r(DATALINE_PC_UIN, extraData, cVar);
        sendOldDataLineMessage(string, DATALINE_PC_UIN, null, qQAppInterface);
        if (r16 != 0) {
            if (callback != null) {
                callback.a(1, "DirectForwarder retCode =  " + r16);
                return;
            }
            return;
        }
        intent.putExtra("NOCANCEL4DATALIN", true);
        AppActivity appActivity = (AppActivity) objectRef.element;
        if (appActivity != null) {
            appActivity.setResult(0, intent);
        }
        AppActivity appActivity2 = (AppActivity) objectRef.element;
        if (appActivity2 != null) {
            appActivity2.finish();
        }
        if (callback != null) {
            callback.a(0, "");
        }
    }

    protected final void setMContext(Context context) {
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ResultRecord resultRecord = this.mResultRecords.get(position);
        holder.getForwardRecentItemView().setTag("view_from_recent_chat");
        ForwardRecentItemView forwardRecentItemView = holder.getForwardRecentItemView();
        Intrinsics.checkNotNull(resultRecord);
        forwardRecentItemView.a(resultRecord.name, "", getDrawable(), resultRecord, getMIsMultiSelect(), false);
        holder.getForwardRecentItemView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.part.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBaseAdapter.onBindViewHolder$lambda$0(MyBaseAdapter.this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cyi, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026      false\n            )");
        return new b(inflate);
    }

    private final void sendOldDataLineMessage(String inputStr, String targetUin, a.c cb5, QQAppInterface app) {
        BusinessHandler businessHandler = app != null ? app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER) : null;
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.DataLineHandler");
        DataLineHandler dataLineHandler = (DataLineHandler) businessHandler;
        if (TextUtils.isEmpty(inputStr)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "sendDataLineMessage: invoked.  textAndEmoji: " + inputStr);
        }
        new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("sendMultiple", false);
        bundle.putInt("dataline_forward_type", 102);
        bundle.putString("dataline_forward_text", inputStr);
        int r16 = dataLineHandler.y3().r(targetUin, bundle, cb5);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "sendDataLineMessage: invoked.  noteRet: " + r16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/selectfriend/part/adapter/MyBaseAdapter$c", "Lk0/a$c;", "Landroid/os/AsyncTask;", "", "", "sendTask", TagName.FILE_TYPE, "", "b", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends a.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<AppActivity> f285454b;

        c(Ref.ObjectRef<AppActivity> objectRef) {
            this.f285454b = objectRef;
        }

        @Override // k0.a.c
        public void b(AsyncTask<Integer, Integer, String> sendTask, int fileType) {
            try {
                Ref.ObjectRef<AppActivity> objectRef = this.f285454b;
                k0.a.o(objectRef.element, sendTask, fileType, new a(objectRef));
                super.b(sendTask, fileType);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/selectfriend/part/adapter/MyBaseAdapter$c$a", "Lcom/tencent/mobileqq/filemanager/util/FMDialogUtil$c;", "", "b", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<AppActivity> f285455a;

            a(Ref.ObjectRef<AppActivity> objectRef) {
                this.f285455a = objectRef;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                k0.a.j(this.f285455a.element, 0);
                this.f285455a.element.finish();
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }
}
