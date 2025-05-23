package com.tenpay.form.queryaccount;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$UIN;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.mobileqq.widget.QWalletAvatarLoader;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.form.queryaccount.IdQueryResultAdapter;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\nJ\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0018\u0010%\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0002J\u0016\u0010(\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010'R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006+"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tenpay/form/queryaccount/IdQueryResultAdapter$BaseViewHolder;", "fragment", "Lcom/tenpay/form/queryaccount/IdQueryResultFragment;", "onCancelAccountListener", "Lcom/tenpay/form/queryaccount/IdQueryResultAdapter$OnCancelAccountListener;", "(Lcom/tenpay/form/queryaccount/IdQueryResultFragment;Lcom/tenpay/form/queryaccount/IdQueryResultAdapter$OnCancelAccountListener;)V", "accountList", "", "Lcom/tencent/mobileqq/pb/qwallet/PayAccountPB$UIN;", "avatarLoader", "Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;", "getFragment", "()Lcom/tenpay/form/queryaccount/IdQueryResultFragment;", "layoutInflater", "Landroid/view/LayoutInflater;", "getOnCancelAccountListener", "()Lcom/tenpay/form/queryaccount/IdQueryResultAdapter$OnCancelAccountListener;", "qq2NickData", "Landroidx/lifecycle/MutableLiveData;", "", "", "getQq2NickData", "()Landroidx/lifecycle/MutableLiveData;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCancelAccountSuccess", "uin", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "requestNick", "dataList", "", "updateData", "BaseViewHolder", "OnCancelAccountListener", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdQueryResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @NotNull
    private final List<PayAccountPB$UIN> accountList;

    @NotNull
    private final QWalletAvatarLoader avatarLoader;

    @NotNull
    private final IdQueryResultFragment fragment;

    @Nullable
    private LayoutInflater layoutInflater;

    @NotNull
    private final OnCancelAccountListener onCancelAccountListener;

    @NotNull
    private final MutableLiveData<Map<String, String>> qq2NickData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryResultAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/lifecycle/Observer;", "", "", "itemView", "Landroid/view/View;", "avatarLoader", "Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;", "adapter", "Lcom/tenpay/form/queryaccount/IdQueryResultAdapter;", "(Landroid/view/View;Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;Lcom/tenpay/form/queryaccount/IdQueryResultAdapter;)V", "accountAvatar", "Lcom/google/android/material/imageview/ShapeableImageView;", "accountBtn", "Landroid/widget/Button;", VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME, "Landroid/widget/TextView;", "accountTag", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "holderData", "Lcom/tencent/mobileqq/pb/qwallet/PayAccountPB$UIN;", "fixEmptyNick", "uin", "nickName", "onChanged", "", "qq2Nick", VasPerfReportUtils.WHILE_UPDATE_ITEM, "data", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static class BaseViewHolder extends RecyclerView.ViewHolder implements Observer<Map<String, String>> {

        @NotNull
        private final ShapeableImageView accountAvatar;

        @NotNull
        private final Button accountBtn;

        @NotNull
        private final TextView accountName;

        @NotNull
        private final TextView accountTag;

        @NotNull
        private final IdQueryResultAdapter adapter;

        @NotNull
        private final QWalletAvatarLoader avatarLoader;

        @Nullable
        private final Drawable defaultIcon;

        @Nullable
        private PayAccountPB$UIN holderData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull View itemView, @NotNull QWalletAvatarLoader avatarLoader, @NotNull IdQueryResultAdapter adapter) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(avatarLoader, "avatarLoader");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.avatarLoader = avatarLoader;
            this.adapter = adapter;
            View findViewById = itemView.findViewById(R.id.s7y);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.account_avatar)");
            this.accountAvatar = (ShapeableImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f163888ba);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.account_name)");
            this.accountName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.s8m);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.account_tag)");
            this.accountTag = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.s8g);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.account_satate_btn)");
            this.accountBtn = (Button) findViewById4;
            this.defaultIcon = ContextCompat.getDrawable(itemView.getContext(), R.drawable.dxx);
        }

        private final String fixEmptyNick(String uin, String nickName) {
            boolean z16;
            if (nickName != null && nickName.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return uin;
            }
            return nickName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void updateView$lambda$0(BaseViewHolder this$0, PayAccountPB$UIN data, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            this$0.adapter.getOnCancelAccountListener().onCancelClick(data);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void updateView(@NotNull final PayAccountPB$UIN data) {
            String str;
            Intrinsics.checkNotNullParameter(data, "data");
            this.holderData = data;
            String uin = data.uin.get();
            ShapeableImageView shapeableImageView = this.accountAvatar;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Drawable drawable = this.defaultIcon;
            shapeableImageView.setImageDrawable(new QWalletAvatarLoader.FaceDrawable(uin, drawable, drawable, this.avatarLoader));
            Map<String, String> value = this.adapter.getQq2NickData().getValue();
            if (value != null) {
                str = value.get(uin);
            } else {
                str = null;
            }
            this.accountName.setText(fixEmptyNick(uin, str));
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026onstant.ALL\n            )");
            if (((IFriendDataService) runtimeService).isFriend(uin)) {
                this.accountTag.setVisibility(0);
            } else {
                this.accountTag.setVisibility(8);
            }
            this.accountBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.queryaccount.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdQueryResultAdapter.BaseViewHolder.updateView$lambda$0(IdQueryResultAdapter.BaseViewHolder.this, data, view);
                }
            });
            this.adapter.getQq2NickData().removeObserver(this);
            this.adapter.getQq2NickData().observe(this.adapter.getFragment(), this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable Map<String, String> qq2Nick) {
            PBStringField pBStringField;
            if (qq2Nick == null) {
                return;
            }
            PayAccountPB$UIN payAccountPB$UIN = this.holderData;
            String str = (payAccountPB$UIN == null || (pBStringField = payAccountPB$UIN.uin) == null) ? null : pBStringField.get();
            if (str == null) {
                return;
            }
            QLog.i(IdQueryResultFragment.TAG, 1, "getNick onChanged. " + str + " " + ((Object) qq2Nick.get(str)));
            this.accountName.setText(fixEmptyNick(str, qq2Nick.get(str)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryResultAdapter$OnCancelAccountListener;", "", "onCancelClick", "", "data", "Lcom/tencent/mobileqq/pb/qwallet/PayAccountPB$UIN;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface OnCancelAccountListener {
        void onCancelClick(@NotNull PayAccountPB$UIN data);
    }

    public IdQueryResultAdapter(@NotNull IdQueryResultFragment fragment, @NotNull OnCancelAccountListener onCancelAccountListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(onCancelAccountListener, "onCancelAccountListener");
        this.fragment = fragment;
        this.onCancelAccountListener = onCancelAccountListener;
        this.accountList = new ArrayList();
        this.avatarLoader = new QWalletAvatarLoader(fragment);
        this.qq2NickData = new MutableLiveData<>();
    }

    private final void requestNick(List<PayAccountPB$UIN> dataList) {
        if (dataList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            String str = ((PayAccountPB$UIN) it.next()).uin.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        ArrayList<String> arrayList2 = new ArrayList<>(arrayList);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("getStrangersNick_in_uinList", arrayList2);
        QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "getStrangersNick", bundle, new EIPCResultCallback() { // from class: com.tenpay.form.queryaccount.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                IdQueryResultAdapter.requestNick$lambda$3(IdQueryResultAdapter.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestNick$lambda$3(IdQueryResultAdapter this$0, EIPCResult eIPCResult) {
        Integer num;
        String str;
        Serializable serializable;
        Map map;
        Map<String, String> mutableMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.isSuccess()) {
            z16 = true;
        }
        if (!z16) {
            QLog.w(IdQueryResultFragment.TAG, 1, "getNick callback ipc fail.");
            return;
        }
        Bundle bundle = eIPCResult.data;
        Map map2 = null;
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt("getStrangersNick_retCode"));
        } else {
            num = null;
        }
        Bundle bundle2 = eIPCResult.data;
        if (bundle2 != null) {
            str = bundle2.getString("getStrangersNick_retMsg");
        } else {
            str = null;
        }
        QLog.i(IdQueryResultFragment.TAG, 1, "getNick callback. " + num + " " + str);
        if (num == null || num.intValue() != 0) {
            return;
        }
        Bundle bundle3 = eIPCResult.data;
        if (bundle3 != null) {
            serializable = bundle3.getSerializable("getStrangersNick_nickMap");
        } else {
            serializable = null;
        }
        SerializableMap serializableMap = (SerializableMap) serializable;
        if (serializableMap != null) {
            map = serializableMap.getMap();
        } else {
            map = null;
        }
        if (TypeIntrinsics.isMutableMap(map)) {
            map2 = map;
        }
        if (map2 == null) {
            return;
        }
        MutableLiveData<Map<String, String>> mutableLiveData = this$0.qq2NickData;
        mutableMap = MapsKt__MapsKt.toMutableMap(map2);
        mutableLiveData.postValue(mutableMap);
    }

    @NotNull
    public final IdQueryResultFragment getFragment() {
        return this.fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.accountList.size();
    }

    @NotNull
    public final OnCancelAccountListener getOnCancelAccountListener() {
        return this.onCancelAccountListener;
    }

    @NotNull
    public final MutableLiveData<Map<String, String>> getQq2NickData() {
        return this.qq2NickData;
    }

    public final void onCancelAccountSuccess(@NotNull PayAccountPB$UIN uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int indexOf = this.accountList.indexOf(uin);
        if (this.accountList.remove(uin)) {
            notifyItemRemoved(indexOf);
        }
    }

    public final void updateData(@Nullable List<PayAccountPB$UIN> dataList) {
        this.accountList.clear();
        if (dataList != null) {
            this.accountList.addAll(dataList);
        }
        requestNick(this.accountList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.updateView(this.accountList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflater = this.layoutInflater;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
            this.layoutInflater = layoutInflater;
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "run {\n            Layout\u2026Inflater = it }\n        }");
        }
        View view = layoutInflater.inflate(R.layout.hjh, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new BaseViewHolder(view, this.avatarLoader, this);
    }
}
