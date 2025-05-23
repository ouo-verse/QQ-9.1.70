package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.Context;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.n;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.effect.adapter.MaterialAdapter;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.av.ui.f;
import com.tencent.av.utils.AVUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import iw.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FilterToolbar extends BaseToolbarNewVersion implements EffectConfigBase.b<FilterItem>, b {
    private MaterialAdapter mAdapter;
    Context mContext;
    iw.a mFilterClickCallback;
    private fu.a mFilterManager;
    private hu.a mMaterialManager;
    private MaterialRecyclerView mRecyclerView;
    private BaseToolbar.a mUIInfo;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements iw.a {
        a() {
        }

        @Override // iw.a
        public void b(long j3, QavListItemBase.c cVar) {
            boolean z16;
            int i3;
            BaseToolbar.keepInToolbar(((BaseToolbar) FilterToolbar.this).mApp, j3);
            if (cVar.f75024a.equals("0")) {
                FilterToolbar.this.mFilterManager.L(j3, null);
                return;
            }
            FilterToolbar.this.mFilterManager.L(j3, FilterToolbar.this.mFilterManager.w(cVar.f75024a));
            int i16 = n.e().f().S0;
            if (i16 != 1 && i16 != 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            ReportController.o(null, "dc00898", "", "", "0X800BC06", "0X800BC06", i3, 0, "", "", "", cVar.f75026c);
        }

        @Override // iw.a
        public void c(long j3) {
            BaseToolbar.keepInToolbar(((BaseToolbar) FilterToolbar.this).mApp, j3);
        }

        @Override // iw.a
        public void d(QavListItemBase.c cVar) {
            FilterToolbar.this.mMaterialManager.I(cVar.f75024a);
            ReportController.o(null, "dc00898", "", "", "0X800BC19", "0X800BC19", 0, 0, "", "", "", cVar.f75026c);
        }
    }

    public FilterToolbar(VideoAppInterface videoAppInterface, AVActivity aVActivity) {
        super(videoAppInterface, aVActivity);
        this.mContext = null;
        this.mFilterClickCallback = new a();
    }

    public static boolean checkShowBeauty(VideoAppInterface videoAppInterface) {
        boolean z16 = false;
        if (videoAppInterface == null) {
            return false;
        }
        if (n.e().f().S || !n.e().f().N || !f.c(videoAppInterface.getCurrentAccountUin()) || !n.e().f().T) {
            z16 = true;
        }
        return !z16;
    }

    private void setLastItem() {
        String id5;
        FilterItem u16 = this.mFilterManager.u();
        if (u16 == null) {
            id5 = "0";
        } else {
            id5 = u16.getId();
        }
        this.mMaterialManager.I(id5);
        this.mMaterialManager.A();
    }

    ArrayList<QavListItemBase.c> convertItemInfo(List<FilterItem> list) {
        ArrayList<QavListItemBase.c> arrayList = new ArrayList<>();
        if (list != null) {
            for (FilterItem filterItem : list) {
                QavListItemBase.c cVar = new QavListItemBase.c();
                cVar.f75024a = filterItem.getId();
                cVar.f75025b = filterItem.getNewIcon();
                cVar.f75027d = filterItem.isUsable();
                cVar.f75026c = filterItem.getDisplayName();
                cVar.f75034k = filterItem.getDesc();
                cVar.f75029f = 8;
                if (PatternUtils.NO_MATCH.equals(cVar.f75024a)) {
                    cVar.f75027d = true;
                    cVar.f75036m = false;
                } else {
                    cVar.f75036m = true;
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public BaseToolbar.a getUIInfo() {
        if (this.mUIInfo == null) {
            BaseToolbar.a aVar = new BaseToolbar.a();
            this.mUIInfo = aVar;
            aVar.f75560d = 8;
            aVar.f75564h = R.layout.ftz;
            aVar.f75562f = R.drawable.d_i;
            aVar.f75563g = this.mApp.getApp().getString(R.string.dl5);
        }
        return this.mUIInfo;
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public String getUnableInfo() {
        if (this.mActivity.get() != null) {
            return this.mActivity.get().getResources().getString(R.string.f171220da2);
        }
        return "";
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public boolean isEffectBtnNormal() {
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "isEffectBtnNormal : " + fu.a.V(this.mContext));
        }
        if (is64bitAndSDKVersionUnderM()) {
            return false;
        }
        return fu.a.V(this.mContext);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onCreate(long j3, AVActivity aVActivity) {
        this.mContext = aVActivity;
        this.mRecyclerView = (MaterialRecyclerView) this.toolbarView.findViewById(R.id.zfg);
        this.mFilterManager = (fu.a) this.mApp.B(1);
        this.mMaterialManager = (hu.a) this.mApp.B(15);
        MaterialAdapter materialAdapter = new MaterialAdapter(this.mApp, aVActivity, convertItemInfo(this.mFilterManager.q(null)), this.mRecyclerView, 3, false);
        this.mAdapter = materialAdapter;
        materialAdapter.v0(this.mFilterClickCallback);
        this.mAdapter.w0(this);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mMaterialManager.I(null);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onDestroy(long j3, VideoAppInterface videoAppInterface) {
        this.mFilterManager.J(j3, this);
        this.mMaterialManager.I(null);
        MaterialAdapter materialAdapter = this.mAdapter;
        if (materialAdapter != null) {
            materialAdapter.onDestroy();
        }
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onHide(long j3) {
        this.mFilterManager.J(j3, this);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onShow(long j3, int i3, boolean z16) {
        this.mFilterManager.p(j3, this);
        setLastItem();
        AVUtil.c(104);
    }

    @Override // iw.b
    public void startDownloadTemplate(AppInterface appInterface, long j3, QavListItemBase.c cVar, QavListItemBase.b bVar) {
        FilterItem w3 = this.mFilterManager.w(cVar.f75024a);
        if (w3 != null) {
            this.mFilterManager.N(j3, w3);
            return;
        }
        QLog.w(this.TAG, 1, "startDownloadTemplate, item\u4e3a\u7a7a, seq[" + j3 + "]");
        bVar.s(j3, cVar.f75024a, false);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public void updateRecycler() {
        this.mRecyclerView.C(this.mContext);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onDownloadFinish(long j3, FilterItem filterItem, boolean z16) {
        MaterialAdapter materialAdapter = this.mAdapter;
        if (materialAdapter != null) {
            materialAdapter.s(j3, filterItem.getId(), z16);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onItemSelectedChanged(long j3, FilterItem filterItem) {
        setLastItem();
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    public void onProgressUpdate(FilterItem filterItem, int i3) {
        MaterialAdapter materialAdapter = this.mAdapter;
        if (materialAdapter != null) {
            materialAdapter.u0(filterItem.getId(), i3);
        }
    }
}
