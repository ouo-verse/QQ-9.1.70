package com.tencent.mobileqq.mini.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.mini.activity.MiniWxAppDebugSettingFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J \u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "()V", "changedWxAppid", "", "filterItem", "Landroid/widget/Spinner;", "gridAdapter", "Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment$GridAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getContentLayoutId", "", "getFilterListData", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment$DebugItem;", "Lkotlin/collections/ArrayList;", "isFilterUnity", "", "onActivityResult", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "sendFile", "path", "Companion", "DebugItem", "GridAdapter", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniWxAppDebugSettingFragment extends QIphoneTitleBarFragment {
    private static final ArrayList<DebugItem> AD_GAME_LIST;
    private static final ArrayList<DebugItem> GAME_LIST;
    private static final ArrayList<DebugItem> MINI_APP_LIST;
    private String changedWxAppid;
    private Spinner filterItem;
    private GridAdapter gridAdapter;
    private RecyclerView recyclerView;
    private static final String PREF_KEY_WXA_SDK_IS_DEBUG_IP = "pref_key_wx_sdk_is_debug_ip";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment$GridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment$GridAdapter$GridViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment$DebugItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setData", "updateList", "", "GridViewHolder", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class GridAdapter extends RecyclerView.Adapter<GridViewHolder> {
        private ArrayList<DebugItem> dataList;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment$GridAdapter$GridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "appText", "Landroid/widget/TextView;", "getAppText", "()Landroid/widget/TextView;", "qqItem", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "getQqItem", "()Lcom/tencent/mobileqq/widget/FormSimpleItem;", "wxItem", "getWxItem", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes33.dex */
        public static final class GridViewHolder extends RecyclerView.ViewHolder {
            private final TextView appText;
            private final FormSimpleItem qqItem;
            private final FormSimpleItem wxItem;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GridViewHolder(View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                View findViewById = itemView.findViewById(R.id.rgq);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.mini_app_items_text)");
                this.appText = (TextView) findViewById;
                View findViewById2 = itemView.findViewById(R.id.rhx);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.mini_app_wx)");
                this.wxItem = (FormSimpleItem) findViewById2;
                View findViewById3 = itemView.findViewById(R.id.rh_);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.mini_app_qq)");
                this.qqItem = (FormSimpleItem) findViewById3;
            }

            public final TextView getAppText() {
                return this.appText;
            }

            public final FormSimpleItem getQqItem() {
                return this.qqItem;
            }

            public final FormSimpleItem getWxItem() {
                return this.wxItem;
            }
        }

        public GridAdapter(ArrayList<DebugItem> dataList) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.dataList = dataList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$1(DebugItem data, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            if (data.getWxAppId().length() == 0) {
                QQToast.makeText(view.getContext(), 1, "\u5f53\u524d\u5e73\u53f0\u6ca1\u6709\u8be5\u6e38\u620f", 1);
            } else if (data.getAppType() != 0) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(view.getContext(), data.getWxAppId(), "", 0, data.getAppType());
            } else {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(view.getContext(), data.getWxAppId(), "", 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$2(DebugItem data, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            if (data.getWxAppId().length() == 0) {
                QQToast.makeText(view.getContext(), 1, "\u5f53\u524d\u5e73\u53f0\u6ca1\u6709\u8be5\u6e38\u620f", 1);
                return;
            }
            QRouteApi api = QRoute.api(IMiniAppService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
            ((IMiniAppService) api).startAppByAppid(MobileQQ.sMobileQQ, data.getQqAppId(), "", "", LaunchScene.LAUNCH_SCENE_BOTTOM_GUID, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataList.size();
        }

        public final void setData(List<DebugItem> updateList) {
            Intrinsics.checkNotNullParameter(updateList, "updateList");
            this.dataList.clear();
            this.dataList.addAll(updateList);
            notifyDataSetChanged();
            QLog.i("wxa-MiniWxAppDebugSettingFragment", 1, "setData size:" + updateList.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(GridViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            DebugItem debugItem = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(debugItem, "dataList[position]");
            final DebugItem debugItem2 = debugItem;
            holder.getAppText().setText("Top" + debugItem2.getRank() + "-" + debugItem2.getAppName());
            holder.getWxItem().setLeftText(debugItem2.getWxAppId());
            holder.getWxItem().setLeftTextSize(12.0f);
            FormSimpleItem qqItem = holder.getQqItem();
            String qqAppId = debugItem2.getQqAppId();
            qqItem.setLeftText(qqAppId.length() == 0 ? "-" : qqAppId);
            holder.getQqItem().setLeftTextSize(12.0f);
            holder.getWxItem().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniWxAppDebugSettingFragment.GridAdapter.onBindViewHolder$lambda$1(MiniWxAppDebugSettingFragment.DebugItem.this, view);
                }
            });
            holder.getQqItem().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniWxAppDebugSettingFragment.GridAdapter.onBindViewHolder$lambda$2(MiniWxAppDebugSettingFragment.DebugItem.this, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dks, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new GridViewHolder(view);
        }
    }

    static {
        ArrayList<DebugItem> arrayListOf;
        ArrayList<DebugItem> arrayListOf2;
        ArrayList<DebugItem> arrayListOf3;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i46 = 0;
        int i47 = 0;
        int i48 = 32;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        int i49 = 0;
        int i56 = 1;
        int i57 = 0;
        int i58 = 1;
        int i59 = 0;
        int i65 = 1;
        int i66 = 0;
        int i67 = 1;
        int i68 = 0;
        int i69 = 1;
        int i75 = 1;
        int i76 = 0;
        int i77 = 1;
        int i78 = 0;
        int i79 = 1;
        int i85 = 0;
        int i86 = 0;
        int i87 = 0;
        int i88 = 1;
        int i89 = 0;
        int i95 = 0;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new DebugItem(0, "\u6d4b\u8bd5-demo", "wx582603afad501887", "", 0, 0, 32, null), new DebugItem(0, "\u5c0f\u6e38\u620f-\u5e7f\u544a", "wxcff7381e631cf54e", "", 0, 0, 32, defaultConstructorMarker), new DebugItem(1, "\u65e0\u5c3d\u51ac\u65e5", "wxada4175c8b2a9864", "", 1, 0, 32, null), new DebugItem(2, "\u5411\u50f5\u5c38\u5f00\u70ae", "wx31a9c726536cdacc", "1112281077", 1, i3, 32, null), new DebugItem(3, "\u4e09\u56fd\uff1a\u51b0\u6cb3\u65f6\u4ee3", "wx209b8a6bc1c08b85", "", i3, i16, 32, null), new DebugItem(4, "\u5bfb\u9053\u5927\u5343", "wx09a75a3a7bb79b59", "1112235797", i16, 0, 32, null), new DebugItem(5, "\u5e7d\u6e38\u767d\u4e66\uff1a\u5bbf\u547d\u89c9\u9192", "wxb387497c38283722", "", 1, i17, 32, null), new DebugItem(6, "\u8dc3\u52a8\u5c0f\u5b50", "wx6cce8ac2ea74103e", "1112313916", i17, i18, 32, null), new DebugItem(8, "\u8ff7\u96fe\u5927\u9646", "wxfd4afe02d65b4972", "", i18, 0, 32, null), new DebugItem(10, "\u4fdd\u536b\u5411\u65e5\u8475", "wx4557e6fdca0cc576", "", 1, i19, 32, defaultConstructorMarker), new DebugItem(11, "\u54b8\u9c7c\u4e4b\u738b", "wx0840558555a454ed", "", i19, i26, 32, null), new DebugItem(12, "\u9752\u4e91\u8bc0\u4e4b\u4f0f\u9b54", "wxcdcbec6bf40d053a", "1112193463", i26, i27, 32, null), new DebugItem(13, "\u4e3b\u5bb0\u4e16\u754c", "wxdbfd70551f103989", "", i27, i28, 32, null), new DebugItem(15, "\u6625\u79cb\u7384\u5947", "wx3e6513a0301179eb", "", i28, 0, 32, null), new DebugItem(16, "\u6d6a\u6f2b\u9910\u5385", "wx087d98a0884bbe3b", "", 1, i29, 32, null), new DebugItem(17, "\u65f6\u5149\u6742\u8d27\u5e97", "wx5e931d82c78f2eb3", "1112319291", i29, i36, 32, null), new DebugItem(18, "\u8fd9\u57ce\u6709\u826f\u7530", "wx667d10ad873053e5", "1112356452", i36, i37, 32, null), new DebugItem(19, "\u4ed9\u5bab\u6218\u7eaa", "wxa5f29fd2af8aea30", "", i37, 0, 32, null), new DebugItem(20, "\u817e\u8baf\u6b22\u4e50\u6597\u5730\u4e3b", "wxd0e404d795ea6f80", "363", 1, i38, 32, null), new DebugItem(21, "\u539f\u59cb\u5f81\u9014", "wxfd8da8f8efcda4a7", "", i38, i39, 32, null), new DebugItem(22, "\u7075\u753b\u5e08", "wxcbc1fc07fb13d667", "", i39, 0, 32, null), new DebugItem(23, "\u4e0d\u4f11\u7684\u4e4c\u62c9\u62c9", "wx8cda1fae5e5f2ca6", "", 1, i46, 32, null), new DebugItem(24, "\u9b54\u754c\u4ed9\u4fa0\u4f20", "wx46d6f4c1925b5dae", "", i46, i47, i48, defaultConstructorMarker2), new DebugItem(25, "\u96f7\u9706\u6218\u673a", "wxae65611dd1391ed0", "", i46, i47, i48, defaultConstructorMarker2), new DebugItem(26, "\u6b21\u795e\uff1a\u5149\u4e4b\u89c9\u9192", "wx35ab0021daa3a9a0", "", i46, i47, i48, defaultConstructorMarker2), new DebugItem(27, "\u7206\u70b8\u5947\u5175", "wxeac8adab2c22c8c4", "", 1, i47, i48, defaultConstructorMarker2), new DebugItem(28, "\u9f99\u9a91\u4e89\u9738", "wx36854ef414b40b4f", "", i49, i47, i48, defaultConstructorMarker2), new DebugItem(29, "\u6211\u662f\u5927\u4e1c\u5bb6", "wx701a051708dba42d", "", i49, i47, i48, defaultConstructorMarker2), new DebugItem(30, "\u795e\u5668\u4f20\u8bf4", "wxf6f9346dd7545588", "", i49, i47, i48, defaultConstructorMarker2), new DebugItem(31, "\u6b66\u4fa0\u5927\u660e\u661f", "wx9c4c2f5f1909e182", "", i56, i47, i48, defaultConstructorMarker2), new DebugItem(32, "\u4e00\u6b65\u4e24\u6b65", "wx124633d4e9338db6", "", i56, i47, i48, defaultConstructorMarker2), new DebugItem(33, "\u624b\u673a\u53cd\u6050\u7279\u522b\u884c\u52a8", "wx342358fac9c85021", "", i56, i47, i48, defaultConstructorMarker2), new DebugItem(34, "\u5feb\u6765\u5f53\u9886\u4e3b", "wx31e40a4722c262cc", "", i56, i47, i48, defaultConstructorMarker2), new DebugItem(35, "\u96c0\u795e\u5e7f\u4e1c\u9ebb\u5c06", "wxafa45659f8ab8ff1", "", i57, i47, i48, defaultConstructorMarker2), new DebugItem(36, "\u541e\u98df\u4e4b\u5203", "wxea05ed00d1404c81", "", i57, i47, i48, defaultConstructorMarker2), new DebugItem(37, "\u4ed9\u5251\u5947\u4fa0\u4f20\u4e4b\u65b0\u7684\u5f00\u59cb", "wx0cd893c62f356b3e", "", i57, i47, i48, defaultConstructorMarker2), new DebugItem(38, "\u6f6e\u82f1\u96c4", "wxda951c69058fb917", "", i58, i47, i48, defaultConstructorMarker2), new DebugItem(39, "\u9634\u9633\u53cc\u5251", "wx45d8120ff6dfd8a0", "", i58, i47, i48, defaultConstructorMarker2), new DebugItem(40, "\u738b\u8005\u5f81\u9014", "wxbfc89b084ad52a75", "", i59, i47, i48, defaultConstructorMarker2), new DebugItem(41, "\u72c2\u70b9\u5996\u5996\u7075", "wxa4514e79a6deb810", "", i59, i47, i48, defaultConstructorMarker2), new DebugItem(42, "\u5947\u8ff9\u5c60\u9f99", "wx2cfaa67d5697780b", "", i59, i47, i48, defaultConstructorMarker2), new DebugItem(43, "\u5fa1\u9f99\u5929\u4e0b", "wx3f58ebe69a2a156f", "", i59, i47, i48, defaultConstructorMarker2), new DebugItem(44, "\u9c7c\u5403\u9c7c", "wxd705de6e4f88cc89", "", i65, i47, i48, defaultConstructorMarker2), new DebugItem(46, "\u8840\u65cf", "wxe99a19d70c5e546e", "", i65, i47, i48, defaultConstructorMarker2), new DebugItem(47, "\u539f\u59cb\u4f20\u5947", "wxdcce325caeca0386", "", i66, i47, i48, defaultConstructorMarker2), new DebugItem(48, "\u592a\u53e4\u5929\u5730", "wx0cc51860669b46e6", "", i66, i47, i48, defaultConstructorMarker2), new DebugItem(49, "\u6d2a\u8352\u4ed9\u97f5", "wx7ec6a8c729ce8e0c", "", i67, i47, i48, defaultConstructorMarker2), new DebugItem(50, "\u5929\u9f99\u516b\u90e8\u8363\u8000\u7248", "wx7c6587fcbdf80d21", "", i67, i47, i48, defaultConstructorMarker2), new DebugItem(51, "\u5de8\u795e\u519b\u5e08", "wx6957ce7b2e0ff7c3", "", i68, i47, i48, defaultConstructorMarker2), new DebugItem(52, "\u9b54\u6cd5\u72e9\u730e\u8005", "wx79fa7436ed22e4a3", "", i68, i47, i48, defaultConstructorMarker2), new DebugItem(53, "\u51e0\u4f55\u738b\u56fd", "wx15d7f5ab0b4c32d7", "", i68, i47, i48, defaultConstructorMarker2), new DebugItem(54, "\u6b22\u4e50\u6218\u4e09\u56fd", "wxfea7e3014cf95068", "", i69, i47, i48, defaultConstructorMarker2), new DebugItem(55, "\u8d85\u5143\u6c14\u706b\u67f4\u4eba", "wxfc3e0f8d185108de", "", i69, i47, i48, defaultConstructorMarker2), new DebugItem(56, "\u6b22\u4e50\u9ebb\u5c06", "wx375c80123d32f83f", "", i69, i47, i48, defaultConstructorMarker2), new DebugItem(58, "\u5e1d\u56fd\u4e0e\u9b54\u6cd5", "wx9279fda788280930", "", i69, i47, i48, defaultConstructorMarker2), new DebugItem(59, "\u5fae\u4e50\u56db\u5ddd\u9ebb\u5c06", "wxc9af71c1095592fc", "", 0, i47, i48, defaultConstructorMarker2), new DebugItem(60, "\u5f00\u5fc3\u6d88\u6d88\u4e50", "wx0647ea28e8169ef5", "", i75, i47, i48, defaultConstructorMarker2), new DebugItem(61, "\u5c0f\u5c0f\u82f1\u96c4", "wx908f8fbfaf4e9a37", "", i75, i47, i48, defaultConstructorMarker2), new DebugItem(62, "\u51b3\u6218\u9635\u5730", "wxfb264e0a298ff96d", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(63, "\u6d77\u76d7\u6765\u4e86", "wxec8f800476c3964a", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(64, "\u8d2a\u5403\u86c7\u5927\u4f5c\u6218", "wxf4ac0077b6ffb1e7", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(65, "\u75af\u72c2\u5b9d\u8d1d", "wxc722166020bcab1d", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(66, "\u9f99\u57ce\u79d8\u5883\uff08\u79fb\u52a8\u7248\uff09", "wx8ece112a37d2b03f", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(67, "\u68a6\u5e7b\u897f\u6e38\u7f51\u9875\u7248", "wxfc545148641497dd", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(68, "\u5f69\u8272\u6d88\u9664", "wx8adcb36763ca5fa7", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(69, "\u5c11\u5e74\u4e09\u56fd\u5fd7", "wxe2a63046b024056c", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(71, "\u4e0d\u673d\u4f20\u5947", "wxaeb698f073745dea", "", i76, i47, i48, defaultConstructorMarker2), new DebugItem(72, "\u68a6\u5e7b\u65c5\u884c", "wxfb906c8a3a5f3e7b", "", i77, i47, i48, defaultConstructorMarker2), new DebugItem(73, "\u56db\u5b63\u5408\u5408", "wx693b4a44e1d81197", "", i77, i47, i48, defaultConstructorMarker2), new DebugItem(74, "\u5929\u5883\u4f20\u8bf4", "wxe5f2b0852b14a12d", "", i77, i47, i48, defaultConstructorMarker2), new DebugItem(75, "\u8bdb\u4ed9", "wx4ea5f1075fbb7695", "", i77, i47, i48, defaultConstructorMarker2), new DebugItem(76, "\u8bb0\u5fc6\u91cd\u73b0", "wx4d64fbeeeb9378cc", "", i78, i47, i48, defaultConstructorMarker2), new DebugItem(77, "\u6781\u54c1\u829d\u9ebb\u5b98", "wxf66370f827bba97c", "", i78, i47, i48, defaultConstructorMarker2), new DebugItem(78, "\u5f81\u670d\u4e0e\u8363\u8000", "wxbe8a51cc4fdfecc8", "", i79, i47, i48, defaultConstructorMarker2), new DebugItem(79, "\u82f1\u96c4\u5f52\u6765", "wx9a7f68c43d286e44", "", i79, i47, i48, defaultConstructorMarker2), new DebugItem(80, "\u4e09\u56fd\u5175\u4e34\u5929\u4e0b", "wxd05c3c97011f85f6", "", i85, i47, i48, defaultConstructorMarker2), new DebugItem(81, "\u5854\u9632\u7cbe\u7075", "wxa46b2910643e4c31", "", i85, i47, i48, defaultConstructorMarker2), new DebugItem(82, "\u7834\u65e5\u5f00\u5929", "wx0cc50f661ceb5935", "", i85, i47, i48, defaultConstructorMarker2), new DebugItem(83, "\u51b0\u706b\u5e7b\u60f3", "wx23e2069c02a717d0", "", 1, i47, i48, defaultConstructorMarker2), new DebugItem(84, "\u5c01\u795e\u9738\u4e1a", "wxc2b7f32d823ea84d", "", i86, i47, i48, defaultConstructorMarker2), new DebugItem(85, "\u80a5\u9e45\u5065\u8eab\u623f", "wxc8713839351ccb45", "", i86, i47, i48, defaultConstructorMarker2), new DebugItem(86, "\u5f08\u5251\u884c", "wx63b641fe713b493a", "", 1, i47, i48, defaultConstructorMarker2), new DebugItem(87, "\u840c\u55b5\u5c0f\u7b51", "wxf4715823cf73d37b", "", 0, i47, i48, defaultConstructorMarker2), new DebugItem(88, "\u7edd\u4e16\u5929\u5e9c", "wxe144f90edd95b7bf", "", 1, i47, i48, defaultConstructorMarker2), new DebugItem(89, "\u70ed\u8840\u5927\u660e", "wx1b9104d8112248e4", "", i87, i47, i48, defaultConstructorMarker2), new DebugItem(90, "\u75af\u72c2\u9a91\u58eb\u56e2", "wx5b76116b30314a4f", "", i87, i47, i48, defaultConstructorMarker2), new DebugItem(91, "\u5999\u7b14\u6c5f\u5c71", "wx4d51bd098192dfea", "", i87, i47, i48, defaultConstructorMarker2), new DebugItem(92, "\u65e0\u9650\u68a6\u5883", "wxeb2d45eab85f9b8b", "", i88, i47, i48, defaultConstructorMarker2), new DebugItem(93, "\u70ed\u8840\u6c5f\u6e56\u4f20", "wx8b87c21e1b6d7720", "", i88, i47, i48, defaultConstructorMarker2), new DebugItem(94, "\u6307\u5c16\u5e7b\u5f71", "wx53e1046cc6ea9846", "", i89, i47, i48, defaultConstructorMarker2), new DebugItem(95, "\u7eef\u8272\u68a6\u5883", "wxa4616a38fffface2", "", i89, i47, i48, defaultConstructorMarker2), new DebugItem(96, "\u7a7f\u8d8a\u706b\u7ebf-\u67aa\u6218\u738b\u8005", "wx16bbfba8e6117309", "", 1, i47, i48, defaultConstructorMarker2), new DebugItem(97, "\u5927\u738b\u4e0d\u597d\u5566", "wx4a44499d194fdeff", "", i95, i47, i48, defaultConstructorMarker2), new DebugItem(98, "\u95ea\u4eae\u5927\u4f5c\u6218", "wx2b9024a419b4b487", "", i95, i47, i48, defaultConstructorMarker2), new DebugItem(99, "\u5927\u8bdd\u897f\u6e38\u5f52\u6765", "wxb7512e2ed8dc525b", "", i95, i47, i48, defaultConstructorMarker2), new DebugItem(100, "\u82f1\u96c4\u4e0e\u57ce\u5821", "wx92cc37f6b1501a49", "", i95, i47, i48, defaultConstructorMarker2));
        GAME_LIST = arrayListOf;
        int i96 = 0;
        int i97 = 32;
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        int i98 = 0;
        int i99 = 0;
        int i100 = 32;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        int i101 = 0;
        int i102 = 0;
        int i103 = 32;
        DefaultConstructorMarker defaultConstructorMarker5 = null;
        int i104 = 0;
        int i105 = 32;
        DefaultConstructorMarker defaultConstructorMarker6 = null;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new DebugItem(1, "\u7f8a\u4e86\u4e2a\u7f8a\uff1a\u661f\u7403", "wx141bfb9b73c970a9", "", i96, i95, i97, defaultConstructorMarker3), new DebugItem(2, "\u75af\u72c2\u6765\u89e3\u538b", "wx770a673256c31705", "", i98, i99, i100, defaultConstructorMarker4), new DebugItem(3, "\u6302\u673a\u5c0f\u82f1\u96c4", "wx73c563412841a613", "", i96, i95, i97, defaultConstructorMarker3), new DebugItem(4, "\u6293\u5927\u9e45", "wxb98ac240fd74b0e3", "", i98, i99, i100, defaultConstructorMarker4), new DebugItem(5, "\u65e0\u654c\u87ba\u4e1d\u738b", "wxdfa24cfef28c57cf", "", i96, i95, i97, defaultConstructorMarker3), new DebugItem(6, "\u632a\u8f66\u6253\u87ba\u4e1d", "wxa3bf2c77158be359", "", i98, i99, i100, defaultConstructorMarker4), new DebugItem(7, "\u73a9\u4e2a\u513f\u6bdb\u7ebf", "wx4f1d591867e69c01", "", i96, i95, i97, defaultConstructorMarker3), new DebugItem(8, "\u8eba\u5e73\u53d1\u80b2", "wx8f54d0cf1faf013f", "", i98, i99, i100, defaultConstructorMarker4), new DebugItem(9, "\u6839\u672c\u96be\u4e0d\u5012\u6211", "wx10d1dc1ddc0dccc4", "", i96, i95, i97, defaultConstructorMarker3), new DebugItem(10, "\u7816\u4e86\u4e2a\u7816", "wx1650bdeedb17dfea", "", i98, i99, i100, defaultConstructorMarker4), new DebugItem(11, "\u52a8\u8111\u6211\u6700\u5f3a", "wx11d202ae6920d10a", "", i96, i95, i97, defaultConstructorMarker3), new DebugItem(12, "\u770b\u8c01\u80fd\u901a\u5173", "wx5855fc3b82e4e9ed", "", i98, i99, i100, defaultConstructorMarker4), new DebugItem(13, "\u770b\u628a\u4f60\u6025\u7684", "wx4c9ea58680eb69a6", "", 0, i101, 32, null), new DebugItem(14, "\u5f00\u542f\u5bcc\u8c6a\u751f\u6d3b", "wxa3c48719f0989c1b", "", i96, i95, i97, defaultConstructorMarker3), new DebugItem(15, "\u738b\u724c\u6d88\u9664\u5e08", "wx7894d81ca3b8cf33", "", i101, 0, 32, null), new DebugItem(16, "\u5929\u5929\u8c61\u68cb", "wx9e44d62c7ab75740", "", i102, i96, i103, defaultConstructorMarker5), new DebugItem(17, "\u70e7\u70e4\u68a6\u5de5\u5382", "wxc89d042a24695472", "", i104, i101, i105, defaultConstructorMarker6), new DebugItem(18, "\u731b\u9b3c\u5bbf\u820d", "wx0c4a175295d64921", "", i102, i96, i103, defaultConstructorMarker5), new DebugItem(19, "\u8d2a\u5403\u86c7\u5927\u4f5c\u6218", "wxf4ac0077b6ffb1e7", "", i104, i101, i105, defaultConstructorMarker6), new DebugItem(20, "\u661f\u9645\u4f7f\u547d", "wx4042e722319a1f46", "", i102, i96, i103, defaultConstructorMarker5));
        AD_GAME_LIST = arrayListOf2;
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(new DebugItem(1, "\u5c0f\u7a0b\u5e8f\u8fc1\u79fbDemo", "wx41f6784ad4052201", "", 0, 1));
        MINI_APP_LIST = arrayListOf3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<DebugItem> getFilterListData(boolean isFilterUnity) {
        ArrayList<DebugItem> arrayList = GAME_LIST;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            DebugItem debugItem = (DebugItem) obj;
            boolean z16 = true;
            if (isFilterUnity && debugItem.getEngineType() != 0) {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(TextView textView, String str, View view) {
        Object systemService = textView.getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        ClipData newPlainText = ClipData.newPlainText("simple text", str);
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
        }
        QQToast.makeText(textView.getContext(), -1, "\u5df2\u590d\u5236\u5230\u526a\u5207\u7248", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(View view) {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).loadDynamicPackage(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.mini.activity.MiniWxAppDebugSettingFragment$onViewCreated$2$1
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public void onCallback(boolean success, Bundle data) {
                QLog.i("MiniWxAppDebugSettingFragment", 1, "loadDynamicPackage finish,success:" + success);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(MiniWxAppDebugSettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.changedWxAppid;
        if (str == null || str.length() == 0) {
            QQToast.makeText(view.getContext(), 1, "\u8bf7\u8f93\u5165\u5fae\u4fe1appid", 1);
        } else {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(view.getContext(), this$0.changedWxAppid, "", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(SharedPreferences sharedPreferences, CompoundButton compoundButton, boolean z16) {
        sharedPreferences.edit().putBoolean(PREF_KEY_WXA_SDK_IS_DEBUG_IP, z16).apply();
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).setIsDebugIP(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "$view");
        File file = new File(view.getContext().getExternalFilesDir(null), "wxa");
        File file2 = new File(file, "xlog");
        File file3 = new File(file, "wxa_log.zip");
        if (file3.exists()) {
            com.tencent.mobileqq.filemanager.util.q.c(file3);
        }
        if (file2.exists()) {
            com.tencent.mobileqq.filemanager.util.q.c(file2);
            QQToast.makeText(BaseApplication.getContext(), "\u65e5\u5fd7\u6e05\u7406\u5b8c\u6210", 0).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), "\u65e5\u5fd7\u4e0d\u5b58\u5728", 0).show();
            QLog.e("IphoneTitleBarFragment", 1, "delete wxa xlog file, but not exist");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
    
        if ((r1.length == 0) == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onViewCreated$lambda$7(View view, final MiniWxAppDebugSettingFragment this$0, View view2) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File file = new File(view.getContext().getExternalFilesDir(null), "wxa");
        final File file2 = new File(file, "xlog");
        if (file2.exists() && file2.listFiles() != null) {
            File[] listFiles = file2.listFiles();
            if (listFiles != null) {
                z16 = true;
            }
            z16 = false;
            if (!z16) {
                final File file3 = new File(file, "wxa_log.zip");
                if (file3.exists()) {
                    com.tencent.mobileqq.filemanager.util.q.c(file3);
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniWxAppDebugSettingFragment.onViewCreated$lambda$7$lambda$6(file2, file3, this$0);
                    }
                }, 64, null, false);
                return;
            }
        }
        QQToast.makeText(BaseApplication.getContext(), "\u65e5\u5fd7\u4e0d\u5b58\u5728", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7$lambda$6(File xlogFile, File xlogZipFile, MiniWxAppDebugSettingFragment this$0) {
        Intrinsics.checkNotNullParameter(xlogFile, "$xlogFile");
        Intrinsics.checkNotNullParameter(xlogZipFile, "$xlogZipFile");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            com.tencent.open.base.l.a(xlogFile, xlogZipFile);
            String absolutePath = xlogZipFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "xlogZipFile.absolutePath");
            this$0.sendFile(absolutePath);
        } catch (Exception e16) {
            QLog.e("IphoneTitleBarFragment", 1, "expose wxa log failed,", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dkt;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || requestCode != 103 || data == null || data.getExtras() == null) {
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(getActivity()), new int[]{2});
        m3.putExtras(new Bundle(data.getExtras()));
        startActivity(m3);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u5fae\u4fe1\u5c0f\u6e38\u620f\u6d4b\u8bd5");
        ((QIphoneTitleBarFragment) this).mContentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        View findViewById = view.findViewById(R.id.rfm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.mini_app_debug_rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        GridAdapter gridAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.gridAdapter = new GridAdapter(getFilterListData(true));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        GridAdapter gridAdapter2 = this.gridAdapter;
        if (gridAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridAdapter");
        } else {
            gridAdapter = gridAdapter2;
        }
        recyclerView2.setAdapter(gridAdapter);
        final String sDKVersion = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getSDKVersion();
        final TextView textView = (TextView) view.findViewById(R.id.f163714rm1);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniWxAppDebugSettingFragment.onViewCreated$lambda$1$lambda$0(textView, sDKVersion, view2);
            }
        });
        textView.setText("\u5fae\u5c0fSDK: " + sDKVersion);
        ((FormSimpleItem) view.findViewById(R.id.rfk)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniWxAppDebugSettingFragment.onViewCreated$lambda$2(view2);
            }
        });
        this.filterItem = (Spinner) view.findViewById(R.id.rfi);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, new String[]{"Top100\u663e\u793aUnity\u6e38\u620f", "Top100\u8fc7\u6ee4Unity\u6e38\u620f", "\u7545\u73a9\u699cTop20", QzoneConfig.DEFAULT_MINI_APP_FULL_SCREEN_TITLE});
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = this.filterItem;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        Spinner spinner2 = this.filterItem;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.tencent.mobileqq.mini.activity.MiniWxAppDebugSettingFragment$onViewCreated$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view2, int position, long id5) {
                    MiniWxAppDebugSettingFragment.GridAdapter gridAdapter3;
                    ArrayList filterListData;
                    MiniWxAppDebugSettingFragment.GridAdapter gridAdapter4;
                    ArrayList filterListData2;
                    MiniWxAppDebugSettingFragment.GridAdapter gridAdapter5;
                    ArrayList arrayList;
                    MiniWxAppDebugSettingFragment.GridAdapter gridAdapter6;
                    ArrayList arrayList2;
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(view2, "view");
                    MiniWxAppDebugSettingFragment.GridAdapter gridAdapter7 = null;
                    if (position == 0) {
                        gridAdapter3 = MiniWxAppDebugSettingFragment.this.gridAdapter;
                        if (gridAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gridAdapter");
                        } else {
                            gridAdapter7 = gridAdapter3;
                        }
                        filterListData = MiniWxAppDebugSettingFragment.this.getFilterListData(false);
                        gridAdapter7.setData(filterListData);
                        return;
                    }
                    if (position == 1) {
                        gridAdapter4 = MiniWxAppDebugSettingFragment.this.gridAdapter;
                        if (gridAdapter4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gridAdapter");
                        } else {
                            gridAdapter7 = gridAdapter4;
                        }
                        filterListData2 = MiniWxAppDebugSettingFragment.this.getFilterListData(true);
                        gridAdapter7.setData(filterListData2);
                        return;
                    }
                    if (position == 2) {
                        gridAdapter5 = MiniWxAppDebugSettingFragment.this.gridAdapter;
                        if (gridAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gridAdapter");
                        } else {
                            gridAdapter7 = gridAdapter5;
                        }
                        arrayList = MiniWxAppDebugSettingFragment.AD_GAME_LIST;
                        gridAdapter7.setData(arrayList);
                        return;
                    }
                    if (position != 3) {
                        return;
                    }
                    gridAdapter6 = MiniWxAppDebugSettingFragment.this.gridAdapter;
                    if (gridAdapter6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridAdapter");
                    } else {
                        gridAdapter7 = gridAdapter6;
                    }
                    arrayList2 = MiniWxAppDebugSettingFragment.MINI_APP_LIST;
                    gridAdapter7.setData(arrayList2);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                }
            });
        }
        Spinner spinner3 = this.filterItem;
        if (spinner3 != null) {
            spinner3.setSelection(0);
        }
        ((EditText) view.findViewById(R.id.rfh)).addTextChangedListener(new TextWatcher() { // from class: com.tencent.mobileqq.mini.activity.MiniWxAppDebugSettingFragment$onViewCreated$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "editable");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i26) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i26) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
                MiniWxAppDebugSettingFragment.this.changedWxAppid = charSequence.toString();
            }
        });
        ((FormSimpleItem) view.findViewById(R.id.rfl)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniWxAppDebugSettingFragment.onViewCreated$lambda$3(MiniWxAppDebugSettingFragment.this, view2);
            }
        });
        final SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(MiniConst.EnvSwitchActivityConst.KEY_ENV_SWITCH, 4);
        FormSwitchItem formSwitchItem = (FormSwitchItem) view.findViewById(R.id.rfj);
        formSwitchItem.setChecked(sharedPreferences.getBoolean(PREF_KEY_WXA_SDK_IS_DEBUG_IP, false));
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MiniWxAppDebugSettingFragment.onViewCreated$lambda$4(sharedPreferences, compoundButton, z16);
            }
        });
        ((FormSimpleItem) view.findViewById(R.id.rhy)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniWxAppDebugSettingFragment.onViewCreated$lambda$5(view, view2);
            }
        });
        ((FormSimpleItem) view.findViewById(R.id.rhz)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniWxAppDebugSettingFragment.onViewCreated$lambda$7(view, this, view2);
            }
        });
    }

    public final void sendFile(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        FileInfo fileInfo = new FileInfo(path);
        FileManagerEntity newEntityByLocalFileInfo = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).newEntityByLocalFileInfo(fileInfo);
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.E(newEntityByLocalFileInfo.nSessionId);
        forwardFileInfo.w(3);
        forwardFileInfo.N(10000);
        forwardFileInfo.C(fileInfo.k());
        forwardFileInfo.y(fileInfo.j());
        forwardFileInfo.z(fileInfo.l());
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putParcelable("fileinfo", forwardFileInfo);
        bundle.putBoolean("not_forward", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, forwardFileInfo.f());
        intent.putExtra("forward_type", 0);
        intent.putExtra("forward _key_nojump", true);
        ForwardBaseOption.startForwardActivityForResult(getActivity(), intent, 103);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/mini/activity/MiniWxAppDebugSettingFragment$DebugItem;", "", "rank", "", "appName", "", "wxAppId", "qqAppId", TagName.ENGINE_TYPE, "appType", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAppName", "()Ljava/lang/String;", "getAppType", "()I", "getEngineType", "getQqAppId", "getRank", "getWxAppId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class DebugItem {
        private final String appName;
        private final int appType;
        private final int engineType;
        private final String qqAppId;
        private final int rank;
        private final String wxAppId;

        public DebugItem(int i3, String appName, String wxAppId, String qqAppId, int i16, int i17) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            Intrinsics.checkNotNullParameter(wxAppId, "wxAppId");
            Intrinsics.checkNotNullParameter(qqAppId, "qqAppId");
            this.rank = i3;
            this.appName = appName;
            this.wxAppId = wxAppId;
            this.qqAppId = qqAppId;
            this.engineType = i16;
            this.appType = i17;
        }

        /* renamed from: component1, reason: from getter */
        public final int getRank() {
            return this.rank;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getWxAppId() {
            return this.wxAppId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getQqAppId() {
            return this.qqAppId;
        }

        /* renamed from: component5, reason: from getter */
        public final int getEngineType() {
            return this.engineType;
        }

        /* renamed from: component6, reason: from getter */
        public final int getAppType() {
            return this.appType;
        }

        public final DebugItem copy(int rank, String appName, String wxAppId, String qqAppId, int engineType, int appType) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            Intrinsics.checkNotNullParameter(wxAppId, "wxAppId");
            Intrinsics.checkNotNullParameter(qqAppId, "qqAppId");
            return new DebugItem(rank, appName, wxAppId, qqAppId, engineType, appType);
        }

        public final String getAppName() {
            return this.appName;
        }

        public final int getAppType() {
            return this.appType;
        }

        public final int getEngineType() {
            return this.engineType;
        }

        public final String getQqAppId() {
            return this.qqAppId;
        }

        public final int getRank() {
            return this.rank;
        }

        public final String getWxAppId() {
            return this.wxAppId;
        }

        public int hashCode() {
            return (((((((((this.rank * 31) + this.appName.hashCode()) * 31) + this.wxAppId.hashCode()) * 31) + this.qqAppId.hashCode()) * 31) + this.engineType) * 31) + this.appType;
        }

        public String toString() {
            return "DebugItem(rank=" + this.rank + ", appName=" + this.appName + ", wxAppId=" + this.wxAppId + ", qqAppId=" + this.qqAppId + ", engineType=" + this.engineType + ", appType=" + this.appType + ")";
        }

        public static /* synthetic */ DebugItem copy$default(DebugItem debugItem, int i3, String str, String str2, String str3, int i16, int i17, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i3 = debugItem.rank;
            }
            if ((i18 & 2) != 0) {
                str = debugItem.appName;
            }
            String str4 = str;
            if ((i18 & 4) != 0) {
                str2 = debugItem.wxAppId;
            }
            String str5 = str2;
            if ((i18 & 8) != 0) {
                str3 = debugItem.qqAppId;
            }
            String str6 = str3;
            if ((i18 & 16) != 0) {
                i16 = debugItem.engineType;
            }
            int i19 = i16;
            if ((i18 & 32) != 0) {
                i17 = debugItem.appType;
            }
            return debugItem.copy(i3, str4, str5, str6, i19, i17);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DebugItem)) {
                return false;
            }
            DebugItem debugItem = (DebugItem) other;
            return this.rank == debugItem.rank && Intrinsics.areEqual(this.appName, debugItem.appName) && Intrinsics.areEqual(this.wxAppId, debugItem.wxAppId) && Intrinsics.areEqual(this.qqAppId, debugItem.qqAppId) && this.engineType == debugItem.engineType && this.appType == debugItem.appType;
        }

        public /* synthetic */ DebugItem(int i3, String str, String str2, String str3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, str2, str3, i16, (i18 & 32) != 0 ? 0 : i17);
        }
    }
}
