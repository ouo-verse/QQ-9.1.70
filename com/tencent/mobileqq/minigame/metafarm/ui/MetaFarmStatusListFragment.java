package com.tencent.mobileqq.minigame.metafarm.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmStatus;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmStatusManager;
import com.tencent.mobileqq.minigame.metafarm.network.MetaFarmGetStatusListRequest;
import com.tencent.mobileqq.minigame.metafarm.network.MetaFarmSetStatusRequest;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003./0B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J&\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/ui/MetaFarmStatusListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/widget/AdapterView$OnItemClickListener;", "()V", "columnSize", "", "lastWidth", "listData", "", "Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatus;", "statusGridAdapter", "Lcom/tencent/mobileqq/minigame/metafarm/ui/MetaFarmStatusListFragment$StatusListAdapter;", "statusGridView", "Lcom/tencent/widget/GridView;", "updateStatusProgressDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "dismissUpdateStatusProgressDialog", "", "doOnCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "getContentLayoutId", "getScreenWidth", "getStatusList", "currentId", "initGrid", "isScreenWidthModified", "", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onItemClick", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "setStatus", "selectId", "showUpdateStatusProgressDialog", "Companion", StatusGridViewHolder.TAG, "StatusListAdapter", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MetaFarmStatusListFragment extends QIphoneTitleBarFragment implements AdapterView.OnItemClickListener {
    public static final int GRID_COLUMN = 3;
    public static final String KEY_DEFAULT_SELECT_STATUS_ID = "key_default_select_status_id";
    private static final String TAG = "MetaFarmStatusListFragment";
    private int columnSize;
    private int lastWidth;
    private List<MetaFarmStatus> listData = new ArrayList();
    private StatusListAdapter statusGridAdapter;
    private GridView statusGridView;
    private QQProgressDialog updateStatusProgressDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/ui/MetaFarmStatusListFragment$StatusGridViewHolder;", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "(Landroid/view/View;)V", "mStatusDescView", "Landroid/widget/TextView;", "mStatusIconView", "Lcom/tencent/image/URLImageView;", "mStatusItem", "Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatus;", "bindGameInfo", "", "statusItem", "selectId", "", MiniGamePAHippyBaseFragment.KEY_THEME, "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class StatusGridViewHolder {
        public static final String TAG = "StatusGridViewHolder";
        private final TextView mStatusDescView;
        private final URLImageView mStatusIconView;
        private MetaFarmStatus mStatusItem;
        private final View rootView;

        public StatusGridViewHolder(View rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.rootView = rootView;
            View findViewById = rootView.findViewById(R.id.rl6);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.status_desc)");
            this.mStatusDescView = (TextView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.rl8);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.status_icon)");
            this.mStatusIconView = (URLImageView) findViewById2;
        }

        public final void bindGameInfo(MetaFarmStatus statusItem, int selectId, boolean isNightMode) {
            Intrinsics.checkNotNullParameter(statusItem, "statusItem");
            this.mStatusItem = statusItem;
            Resources resources = this.rootView.getResources();
            if (selectId == statusItem.getId()) {
                if (isNightMode) {
                    this.rootView.setBackground(resources.getDrawable(R.drawable.f159959ip3));
                } else {
                    this.rootView.setBackground(resources.getDrawable(R.drawable.f159958ip2));
                }
                this.mStatusDescView.setTextColor(resources.getColor(R.color.f88785));
            } else if (isNightMode) {
                this.rootView.setBackground(resources.getDrawable(R.drawable.f159957ip1));
                this.mStatusDescView.setTextColor(-1);
            } else {
                this.rootView.setBackground(resources.getDrawable(R.drawable.f159956ip0));
                this.mStatusDescView.setTextColor(-16777216);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            URLImageView uRLImageView = this.mStatusIconView;
            MetaFarmStatus metaFarmStatus = this.mStatusItem;
            uRLImageView.setImageDrawable(URLDrawable.getDrawable(metaFarmStatus != null ? metaFarmStatus.getIconUrl() : null, obtain));
            TextView textView = this.mStatusDescView;
            MetaFarmStatus metaFarmStatus2 = this.mStatusItem;
            textView.setText(metaFarmStatus2 != null ? metaFarmStatus2.getDesc() : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0006\u0010\u0012\u001a\u00020\bJ$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\bJ\u001c\u0010\u001d\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001c\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/minigame/metafarm/ui/MetaFarmStatusListFragment$StatusListAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", MiniGamePAHippyBaseFragment.KEY_THEME, "", "(Landroid/content/Context;Z)V", "mColumnSize", "", "mSelectId", "mStatusList", "", "Lcom/tencent/mobileqq/minigame/metafarm/data/MetaFarmStatus;", "getCount", "getItem", "position", "getItemId", "", "getSelectId", "getView", "Landroid/view/View;", "convertView", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "setColumnSize", "", "columnSize", "setSelectId", "selectId", "setStatusList", "list", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class StatusListAdapter extends BaseAdapter {
        private final boolean isNightMode;
        private int mColumnSize;
        private final Context mContext;
        private int mSelectId;
        private List<MetaFarmStatus> mStatusList;

        public StatusListAdapter(Context mContext, boolean z16) {
            List<MetaFarmStatus> emptyList;
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.mContext = mContext;
            this.isNightMode = z16;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.mStatusList = emptyList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mStatusList.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        /* renamed from: getSelectId, reason: from getter */
        public final int getMSelectId() {
            return this.mSelectId;
        }

        public final void setColumnSize(int columnSize) {
            this.mColumnSize = columnSize;
        }

        public final void setSelectId(int selectId) {
            this.mSelectId = selectId;
            notifyDataSetChanged();
        }

        public final void setStatusList(List<MetaFarmStatus> list, int selectId) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.mStatusList = list;
            this.mSelectId = selectId;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public MetaFarmStatus getItem(int position) {
            return this.mStatusList.get(position);
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            StatusGridViewHolder statusGridViewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.mContext).inflate(R.layout.dk6, parent, false);
                if (convertView.getLayoutParams() == null) {
                    int i3 = this.mColumnSize;
                    convertView.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
                } else {
                    convertView.getLayoutParams().width = this.mColumnSize;
                    convertView.getLayoutParams().height = this.mColumnSize;
                }
                statusGridViewHolder = new StatusGridViewHolder(convertView);
                convertView.setTag(statusGridViewHolder);
            } else {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.minigame.metafarm.ui.MetaFarmStatusListFragment.StatusGridViewHolder");
                statusGridViewHolder = (StatusGridViewHolder) tag;
            }
            statusGridViewHolder.bindGameInfo(this.mStatusList.get(position), this.mSelectId, this.isNightMode);
            Intrinsics.checkNotNull(convertView);
            return convertView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissUpdateStatusProgressDialog() {
        try {
            QQProgressDialog qQProgressDialog = this.updateStatusProgressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "dismissUpdateStatusProgressDialog exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnCreateView$lambda$0(MetaFarmStatusListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StatusListAdapter statusListAdapter = this$0.statusGridAdapter;
        if (statusListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
            statusListAdapter = null;
        }
        this$0.setStatus(statusListAdapter.getMSelectId());
    }

    private final int getScreenWidth() {
        int screenWidth;
        Resources resources;
        Configuration configuration;
        Context context = getContext();
        boolean z16 = false;
        if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 2) {
            z16 = true;
        }
        if (z16) {
            screenWidth = ImmersiveUtils.getScreenHeight();
        } else {
            screenWidth = ImmersiveUtils.getScreenWidth();
        }
        this.lastWidth = screenWidth;
        return screenWidth;
    }

    private final void getStatusList(int currentId) {
        MetaFarmGetStatusListRequest metaFarmGetStatusListRequest = new MetaFarmGetStatusListRequest();
        metaFarmGetStatusListRequest.setListener(new MetaFarmStatusListFragment$getStatusList$1(this, metaFarmGetStatusListRequest, currentId));
        metaFarmGetStatusListRequest.getStatusList();
    }

    private final void initGrid() {
        if (getActivity() == null) {
            return;
        }
        GridView gridView = null;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.rl7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.status_grid_view)");
        this.statusGridView = (GridView) findViewById;
        if (isNowThemeIsNight) {
            ((QIphoneTitleBarFragment) this).mContentView.setBackground(getResources().getDrawable(R.drawable.ioz));
        } else {
            ((QIphoneTitleBarFragment) this).mContentView.setBackground(getResources().getDrawable(R.drawable.ioy));
        }
        GridView gridView2 = this.statusGridView;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridView");
            gridView2 = null;
        }
        gridView2.setNumColumns(3);
        this.columnSize = (getScreenWidth() - x.a(48.0f)) / 3;
        GridView gridView3 = this.statusGridView;
        if (gridView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridView");
            gridView3 = null;
        }
        gridView3.setColumnWidth(this.columnSize);
        GridView gridView4 = this.statusGridView;
        if (gridView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridView");
            gridView4 = null;
        }
        gridView4.setVerticalScrollBarEnabled(false);
        GridView gridView5 = this.statusGridView;
        if (gridView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridView");
            gridView5 = null;
        }
        gridView5.setVerticalSpacing(x.a(8.0f));
        GridView gridView6 = this.statusGridView;
        if (gridView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridView");
            gridView6 = null;
        }
        gridView6.setHorizontalSpacing(x.a(8.0f));
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.content.Context");
        this.statusGridAdapter = new StatusListAdapter(activity, isNowThemeIsNight);
        Bundle arguments = getArguments();
        int i3 = arguments != null ? arguments.getInt(KEY_DEFAULT_SELECT_STATUS_ID) : 0;
        QLog.d(TAG, 1, "initGrid currentId:" + i3);
        StatusListAdapter statusListAdapter = this.statusGridAdapter;
        if (statusListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
            statusListAdapter = null;
        }
        statusListAdapter.setColumnSize(this.columnSize);
        this.listData.addAll(MetaFarmStatusManager.INSTANCE.getStatusList());
        StatusListAdapter statusListAdapter2 = this.statusGridAdapter;
        if (statusListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
            statusListAdapter2 = null;
        }
        statusListAdapter2.setStatusList(this.listData, i3);
        GridView gridView7 = this.statusGridView;
        if (gridView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridView");
            gridView7 = null;
        }
        StatusListAdapter statusListAdapter3 = this.statusGridAdapter;
        if (statusListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
            statusListAdapter3 = null;
        }
        gridView7.setAdapter((ListAdapter) statusListAdapter3);
        GridView gridView8 = this.statusGridView;
        if (gridView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridView");
        } else {
            gridView = gridView8;
        }
        gridView.setOnItemClickListener(this);
        getStatusList(i3);
    }

    private final boolean isScreenWidthModified() {
        int i3 = this.lastWidth;
        ImmersiveUtils.resetDensity();
        return i3 != getScreenWidth();
    }

    private final void setStatus(int selectId) {
        QLog.d(TAG, 1, "setStatus selectId:" + selectId);
        showUpdateStatusProgressDialog();
        MetaFarmSetStatusRequest metaFarmSetStatusRequest = new MetaFarmSetStatusRequest();
        metaFarmSetStatusRequest.setListener(new MetaFarmStatusListFragment$setStatus$1(metaFarmSetStatusRequest, this, selectId));
        metaFarmSetStatusRequest.setStatus(selectId);
    }

    private final void showUpdateStatusProgressDialog() {
        int a16;
        Resources resources;
        try {
            QQProgressDialog qQProgressDialog = this.updateStatusProgressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            FragmentActivity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (resources = activity2.getResources()) != null) {
                a16 = resources.getDimensionPixelSize(R.dimen.title_bar_height);
            } else {
                a16 = x.a(44.0f);
            }
            QQProgressDialog qQProgressDialog2 = new QQProgressDialog(activity, a16);
            this.updateStatusProgressDialog = qQProgressDialog2;
            qQProgressDialog2.setMessage("\u8bbe\u7f6e\u4e2d...");
            QQProgressDialog qQProgressDialog3 = this.updateStatusProgressDialog;
            if (qQProgressDialog3 != null) {
                qQProgressDialog3.show();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showUpdateStatusProgressDialog exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setTitle("\u519c\u573a\u6807\u7b7e\u8bbe\u7f6e");
        setRightButtonText("\u5b8c\u6210", new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.metafarm.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MetaFarmStatusListFragment.doOnCreateView$lambda$0(MetaFarmStatusListFragment.this, view);
            }
        });
        initGrid();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dk7;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        super.onConfigurationChanged(configuration);
        if (isScreenWidthModified()) {
            initGrid();
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id5) {
        StatusListAdapter statusListAdapter = this.statusGridAdapter;
        StatusListAdapter statusListAdapter2 = null;
        if (statusListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
            statusListAdapter = null;
        }
        if (position < statusListAdapter.getCount()) {
            StatusListAdapter statusListAdapter3 = this.statusGridAdapter;
            if (statusListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
                statusListAdapter3 = null;
            }
            MetaFarmStatus item = statusListAdapter3.getItem(position);
            int id6 = item.getId();
            StatusListAdapter statusListAdapter4 = this.statusGridAdapter;
            if (statusListAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
                statusListAdapter4 = null;
            }
            if (id6 != statusListAdapter4.getMSelectId()) {
                StatusListAdapter statusListAdapter5 = this.statusGridAdapter;
                if (statusListAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
                } else {
                    statusListAdapter2 = statusListAdapter5;
                }
                statusListAdapter2.setSelectId(item.getId());
                return;
            }
            StatusListAdapter statusListAdapter6 = this.statusGridAdapter;
            if (statusListAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusGridAdapter");
            } else {
                statusListAdapter2 = statusListAdapter6;
            }
            statusListAdapter2.setSelectId(0);
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

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
