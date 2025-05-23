package com.tencent.mobileqq.mini.entry;

import NS_MINI_INTERFACE.INTERFACE$StGetSwitchListRsp;
import NS_MINI_INTERFACE.INTERFACE$StSwitchInfo;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListServlet;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.ExecSQLTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppEntrySettingFragment extends IphoneTitleBarFragment {
    private static final String TAG = "MiniAppEntrySettingFragment";
    private BaseActivity activity;
    private BounceScrollView mSettingLayout;
    private ListView mSettingListView;
    private SettingListViewAdapter mSettingListViewAdapter;
    private ArrayList<MiniAppSettingSwitchInfoEntity> switchInfoList = new ArrayList<>();

    private BaseTransaction getUpdateSwitchTransaction(Entity entity) {
        if (entity.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(entity);
        }
        if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            return new UpdateTransaction(entity);
        }
        return null;
    }

    private void initData() {
        List<? extends Entity> query;
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null && (query = baseActivity.getAppInterface().getEntityManagerFactory().createEntityManager().query(MiniAppSettingSwitchInfoEntity.class, MiniAppSettingSwitchInfoEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null)) != null && query.size() > 0) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity) it.next();
                if (miniAppSettingSwitchInfoEntity != null && !TextUtils.isEmpty(miniAppSettingSwitchInfoEntity.key)) {
                    this.switchInfoList.add(miniAppSettingSwitchInfoEntity);
                }
            }
        }
        MiniAppCmdUtil.getInstance().getSwitchList(null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                QLog.d(MiniAppEntrySettingFragment.TAG, 1, "getSwitchList receive isSuc= " + z16 + " ret=" + String.valueOf(jSONObject));
                if (jSONObject == null) {
                    QLog.e(MiniAppEntrySettingFragment.TAG, 1, "getSwitchList receive ret == null");
                    return;
                }
                if (z16) {
                    try {
                        INTERFACE$StGetSwitchListRsp iNTERFACE$StGetSwitchListRsp = (INTERFACE$StGetSwitchListRsp) jSONObject.get(MiniAppGetSwitchListServlet.KEY_GET_SWITCH_LIST);
                        int i3 = jSONObject.getInt("retCode");
                        QLog.d(MiniAppEntrySettingFragment.TAG, 1, "getSwitchList receive retCode= " + i3 + " errMsg=" + jSONObject.getString("errMsg"));
                        if (i3 == 0 && iNTERFACE$StGetSwitchListRsp != null) {
                            List<INTERFACE$StSwitchInfo> list = iNTERFACE$StGetSwitchListRsp.switchs.get();
                            if (list == null || list.size() <= 0) {
                                return;
                            }
                            for (INTERFACE$StSwitchInfo iNTERFACE$StSwitchInfo : list) {
                                if (iNTERFACE$StSwitchInfo != null) {
                                    MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity2 = new MiniAppSettingSwitchInfoEntity();
                                    miniAppSettingSwitchInfoEntity2.key = iNTERFACE$StSwitchInfo.key.get();
                                    miniAppSettingSwitchInfoEntity2.title = iNTERFACE$StSwitchInfo.title.get();
                                    miniAppSettingSwitchInfoEntity2.subTitle = iNTERFACE$StSwitchInfo.desc.get();
                                    miniAppSettingSwitchInfoEntity2.value = iNTERFACE$StSwitchInfo.value.get();
                                    if (MiniAppEntrySettingFragment.this.switchInfoList == null) {
                                        MiniAppEntrySettingFragment.this.switchInfoList = new ArrayList();
                                    }
                                    MiniAppEntrySettingFragment.this.switchInfoList.add(miniAppSettingSwitchInfoEntity2);
                                }
                            }
                            if (MiniAppEntrySettingFragment.this.activity != null) {
                                MiniAppEntrySettingFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (MiniAppEntrySettingFragment.this.mSettingListViewAdapter != null) {
                                            MiniAppEntrySettingFragment.this.mSettingListViewAdapter.setData(MiniAppEntrySettingFragment.this.switchInfoList);
                                        }
                                    }
                                });
                            }
                            MiniAppEntrySettingFragment miniAppEntrySettingFragment = MiniAppEntrySettingFragment.this;
                            miniAppEntrySettingFragment.updateLocalSwitchDataList(miniAppEntrySettingFragment.switchInfoList);
                            return;
                        }
                        QLog.e(MiniAppEntrySettingFragment.TAG, 1, "getSwitchList receive retCode =", Integer.valueOf(i3));
                        ToastUtil.a().e("retCode:" + i3);
                        return;
                    } catch (Exception e16) {
                        QLog.e(MiniAppEntrySettingFragment.TAG, 1, "onCmdListener failed e:", e16);
                        ToastUtil.a().e("exception check log");
                        return;
                    }
                }
                QLog.e(MiniAppEntrySettingFragment.TAG, 1, "getSwitchList receive isSuc =", Boolean.valueOf(z16));
                ToastUtil.a().e("getSwitchList receive isSuc false");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLocalSwitchDataList(List<MiniAppSettingSwitchInfoEntity> list) {
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null) {
            QQAppInterface qQAppInterface = baseActivity.app;
            if (list != null && list.size() != 0 && qQAppInterface != null) {
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<MiniAppSettingSwitchInfoEntity> it = list.iterator();
                    while (it.hasNext()) {
                        BaseTransaction updateSwitchTransaction = getUpdateSwitchTransaction(it.next());
                        if (updateSwitchTransaction != null) {
                            arrayList.add(updateSwitchTransaction);
                        }
                    }
                    createEntityManager.doMultiDBOperateByTransaction(arrayList);
                    return;
                }
                return;
            }
            QLog.e(TAG, 2, "saveLocalSwitchDataList, app = " + qQAppInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocalSwitchDataList(final List<MiniAppSettingSwitchInfoEntity> list) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (MiniAppEntrySettingFragment.this.activity != null) {
                    QQAppInterface qQAppInterface = MiniAppEntrySettingFragment.this.activity.app;
                    if (qQAppInterface == null) {
                        QLog.e(MiniAppEntrySettingFragment.TAG, 2, "updateLocalSwitchDataList, app is null.");
                        return;
                    }
                    QLog.i(MiniAppEntrySettingFragment.TAG, 1, "removeAllLocalSwitchDataList");
                    EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                    if (createEntityManager == null) {
                        return;
                    }
                    ExecSQLTransaction execSQLTransaction = new ExecSQLTransaction(" DELETE FROM MiniAppSettingSwitchInfoEntity ");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(execSQLTransaction);
                    createEntityManager.doMultiDBOperateByTransaction(arrayList);
                    MiniAppEntrySettingFragment.this.saveLocalSwitchDataList(list);
                }
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateSwitchData(EntityManager entityManager, Entity entity) {
        boolean z16 = false;
        if (entityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                entityManager.persistOrReplace(entity);
                if (entity.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                z16 = entityManager.update(entity);
            }
            entityManager.close();
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.cdo;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.activity = getBaseActivity();
        setTitle(HardCodeUtil.qqStr(R.string.o7d));
        initData();
        initUI(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class SettingListViewAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<MiniAppSettingSwitchInfoEntity> mData;
        private final int TYPE_ERROR = -1;
        private final int TYPE_SINGLE_LINE = 0;
        private final int TYPE_MUULTI_LINE = 1;

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class Holder {
            FormMultiLineSwitchItem multiLineSwitchItem;
            FormSwitchItem singleLineSwitchItem;

            Holder() {
            }
        }

        public SettingListViewAdapter(Context context) {
            this.mContext = context;
        }

        private CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener(final MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity) {
            return new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.SettingListViewAdapter.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    String str;
                    MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity2 = miniAppSettingSwitchInfoEntity;
                    final MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity3 = new MiniAppSettingSwitchInfoEntity(miniAppSettingSwitchInfoEntity2.key, miniAppSettingSwitchInfoEntity2.title, miniAppSettingSwitchInfoEntity2.subTitle, miniAppSettingSwitchInfoEntity2.value == 1 ? 0 : 1);
                    MiniAppCmdUtil.getInstance().setUserSwitch(null, miniAppSettingSwitchInfoEntity3.key, miniAppSettingSwitchInfoEntity3.value, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.SettingListViewAdapter.1.1
                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                        public void onCmdListener(boolean z17, JSONObject jSONObject) {
                            QLog.d(MiniAppEntrySettingFragment.TAG, 1, "getRewardedVideoADInfo receive isSuc= " + z17 + " ret=" + String.valueOf(jSONObject));
                            if (jSONObject == null) {
                                QLog.e(MiniAppEntrySettingFragment.TAG, 1, "getRewardedVideoADInfo receive ret == null");
                                return;
                            }
                            if (z17) {
                                try {
                                    int i3 = jSONObject.getInt("retCode");
                                    QLog.d(MiniAppEntrySettingFragment.TAG, 1, "setUserSwitch receive retCode= " + i3 + " errMsg=" + jSONObject.getString("errMsg"));
                                    if (i3 == 0) {
                                        MiniAppEntrySettingFragment.this.updateDataToDB(miniAppSettingSwitchInfoEntity3);
                                        Bundle bundle = new Bundle();
                                        MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity4 = miniAppSettingSwitchInfoEntity3;
                                        bundle.putInt(miniAppSettingSwitchInfoEntity4.key, miniAppSettingSwitchInfoEntity4.value);
                                        bundle.putBoolean("refreshUI", true);
                                        BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppExpDesktopPartHost.class, 102, true, bundle);
                                    } else {
                                        QLog.e(MiniAppEntrySettingFragment.TAG, 1, "setUserSwitch receive retCode = ", Integer.valueOf(i3));
                                        ToastUtil.a().e("setUserSwitch retCode:" + i3);
                                    }
                                    return;
                                } catch (Exception e16) {
                                    QLog.e(MiniAppEntrySettingFragment.TAG, 1, "setUserSwitch onCmdListener failed e:", e16);
                                    ToastUtil.a().e("setUserSwitch fail checklog");
                                    return;
                                }
                            }
                            QLog.e(MiniAppEntrySettingFragment.TAG, 1, "setUserSwitch receive isSuc = ", Boolean.valueOf(z17));
                            ToastUtil.a().e("setUserSwitch receive isSuc false");
                        }
                    });
                    if (z16) {
                        str = "set_on";
                    } else {
                        str = "set_off";
                    }
                    MiniProgramLpReportDC04239.reportAsync("desktop", "set", str, miniAppSettingSwitchInfoEntity3.key);
                }
            };
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<MiniAppSettingSwitchInfoEntity> arrayList = this.mData;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity;
            ArrayList<MiniAppSettingSwitchInfoEntity> arrayList = this.mData;
            if (arrayList == null || i3 >= arrayList.size() || (miniAppSettingSwitchInfoEntity = this.mData.get(i3)) == null) {
                return -1;
            }
            return TextUtils.isEmpty(miniAppSettingSwitchInfoEntity.subTitle) ? 0 : 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            Holder holder;
            MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity = this.mData.get(i3);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.cdn, (ViewGroup) null);
                holder = new Holder();
                holder.singleLineSwitchItem = (FormSwitchItem) view.findViewById(R.id.lvt);
                holder.multiLineSwitchItem = (FormMultiLineSwitchItem) view.findViewById(R.id.lvs);
                view.setTag(holder);
            } else {
                holder = (Holder) view.getTag();
            }
            int itemViewType = getItemViewType(i3);
            if (itemViewType == 0) {
                holder.singleLineSwitchItem.setVisibility(0);
                holder.singleLineSwitchItem.setText(miniAppSettingSwitchInfoEntity.title);
                holder.singleLineSwitchItem.setChecked(miniAppSettingSwitchInfoEntity.value == 1);
                holder.singleLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(miniAppSettingSwitchInfoEntity));
                holder.multiLineSwitchItem.setVisibility(8);
            } else if (itemViewType == 1) {
                holder.singleLineSwitchItem.setVisibility(8);
                holder.multiLineSwitchItem.setText(miniAppSettingSwitchInfoEntity.title);
                holder.multiLineSwitchItem.setSecendLineText(miniAppSettingSwitchInfoEntity.subTitle);
                holder.multiLineSwitchItem.setChecked(miniAppSettingSwitchInfoEntity.value == 1);
                holder.multiLineSwitchItem.setOnCheckedChangeListener(getOnCheckedChangeListener(miniAppSettingSwitchInfoEntity));
                holder.multiLineSwitchItem.setVisibility(0);
            }
            return view;
        }

        public void setData(ArrayList<MiniAppSettingSwitchInfoEntity> arrayList) {
            if (arrayList == null) {
                return;
            }
            this.mData = arrayList;
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDataToDB(final MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity) {
        if (miniAppSettingSwitchInfoEntity == null || TextUtils.isEmpty(miniAppSettingSwitchInfoEntity.key)) {
            return;
        }
        QLog.e(TAG, 2, "updateDataToDB entity.key:" + miniAppSettingSwitchInfoEntity.key);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (MiniAppEntrySettingFragment.this.activity != null) {
                    QQAppInterface qQAppInterface = MiniAppEntrySettingFragment.this.activity.app;
                    if (qQAppInterface == null) {
                        QLog.e(MiniAppEntrySettingFragment.TAG, 2, "updateDataToDB, app is null.");
                        return;
                    }
                    EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                    if (createEntityManager != null) {
                        String simpleName = MiniAppSettingSwitchInfoEntity.class.getSimpleName();
                        String str = miniAppSettingSwitchInfoEntity.key;
                        List<? extends Entity> query = createEntityManager.query(MiniAppSettingSwitchInfoEntity.class, simpleName, false, "key = ?", new String[]{str}, (String) null, (String) null, (String) null, str);
                        if (query != null && query.size() > 0) {
                            Iterator<? extends Entity> it = query.iterator();
                            while (it.hasNext()) {
                                MiniAppEntrySettingFragment.this.updateSwitchData(createEntityManager, (MiniAppSettingSwitchInfoEntity) it.next());
                            }
                        } else {
                            MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity2 = miniAppSettingSwitchInfoEntity;
                            MiniAppEntrySettingFragment.this.updateSwitchData(createEntityManager, new MiniAppSettingSwitchInfoEntity(miniAppSettingSwitchInfoEntity2.key, miniAppSettingSwitchInfoEntity2.title, miniAppSettingSwitchInfoEntity2.subTitle, miniAppSettingSwitchInfoEntity2.value));
                        }
                    }
                }
            }
        }, 32, null, true);
    }

    private void initUI(View view) {
        this.mSettingLayout = (BounceScrollView) view.findViewById(R.id.lsz);
        if (MiniAppUtils.isNightMode()) {
            this.mSettingLayout.setBackgroundColor(-16777216);
        }
        this.mSettingListView = (ListView) view.findViewById(R.id.lvh);
        SettingListViewAdapter settingListViewAdapter = new SettingListViewAdapter(view.getContext());
        this.mSettingListViewAdapter = settingListViewAdapter;
        this.mSettingListView.setAdapter((ListAdapter) settingListViewAdapter);
        BaseActivity baseActivity = this.activity;
        if (baseActivity != null) {
            baseActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniAppEntrySettingFragment.this.switchInfoList == null || MiniAppEntrySettingFragment.this.switchInfoList.size() <= 0 || MiniAppEntrySettingFragment.this.mSettingListViewAdapter == null) {
                        return;
                    }
                    MiniAppEntrySettingFragment.this.mSettingListViewAdapter.setData(MiniAppEntrySettingFragment.this.switchInfoList);
                }
            });
        }
    }
}
