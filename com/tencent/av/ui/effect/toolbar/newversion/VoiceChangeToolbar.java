package com.tencent.av.ui.effect.toolbar.newversion;

import android.view.View;
import android.widget.Button;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.aj;
import com.tencent.av.ui.ao;
import com.tencent.av.ui.ap;
import com.tencent.av.ui.effect.adapter.MaterialAdapter;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.h;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cw.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceChangeToolbar extends BaseToolbarNewVersion implements View.OnClickListener {
    public static final String TAG = "VoiceChangeToolbar";
    MaterialAdapter mAdapter;
    ArrayList<QavListItemBase.c> mItemInfo;
    private hu.a mMaterialManager;
    MaterialRecyclerView mRecyclerView;
    private BaseToolbar.a mUIInfo;
    Button mVoiceChangeBtn;
    iw.a mVoiceClickCallback;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements iw.a {
        a() {
        }

        @Override // iw.a
        public void b(long j3, QavListItemBase.c cVar) {
            aj ajVar;
            AVCoreLog.printAllUserLog(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + cVar.f75024a);
            SessionInfo f16 = n.e().f();
            int parseInt = Integer.parseInt(cVar.f75024a);
            if (parseInt == 0) {
                f16.X1 = null;
            } else {
                Object obj = cVar.f75035l;
                if (obj instanceof ao.a) {
                    f16.X1 = ((ao.a) obj).f75378b;
                } else {
                    f16.X1 = cVar.f75025b;
                }
                DataReport.r(cVar.f75024a);
            }
            f16.f73078s2 = parseInt;
            f16.f73082t2 = 0;
            AVActivity aVActivity = VoiceChangeToolbar.this.getAVActivity();
            if (aVActivity != null && (ajVar = aVActivity.I0) != null) {
                ajVar.i1(j3, 8);
            }
            r.h0().R1();
            ap.e(f16, parseInt);
            BaseToolbar.keepInToolbar(((BaseToolbar) VoiceChangeToolbar.this).mApp, j3);
            if (f16.f73035i == 4) {
                h.b(String.valueOf(parseInt));
            }
        }

        @Override // iw.a
        public void c(long j3) {
            BaseToolbar.keepInToolbar(((BaseToolbar) VoiceChangeToolbar.this).mApp, j3);
        }

        @Override // iw.a
        public void d(QavListItemBase.c cVar) {
            VoiceChangeToolbar.this.mMaterialManager.K(cVar.f75024a);
            ReportController.o(null, "dc00898", "", "", "0X800BC13", "0X800BC13", AVUtil.h(), 0, "", "", "", "");
        }
    }

    public VoiceChangeToolbar(VideoAppInterface videoAppInterface, AVActivity aVActivity) {
        super(videoAppInterface, aVActivity);
        this.mVoiceChangeBtn = null;
        this.mVoiceClickCallback = new a();
    }

    private ArrayList<QavListItemBase.c> getList() {
        int length;
        ao.a[] b16 = ao.a().b();
        if (b16 == null) {
            length = 0;
        } else {
            length = b16.length;
        }
        ArrayList<QavListItemBase.c> arrayList = new ArrayList<>(length);
        if (b16 != null) {
            for (ao.a aVar : b16) {
                QavListItemBase.c cVar = new QavListItemBase.c();
                cVar.f75029f = 2;
                cVar.f75024a = aVar.f75380d + "";
                String str = aVar.f75377a;
                cVar.f75026c = str;
                cVar.f75025b = aVar.f75378b;
                cVar.f75030g = aVar.f75381e;
                cVar.f75034k = str;
                cVar.f75027d = true;
                cVar.f75035l = aVar;
                cVar.f75036m = !"0".equals(r5);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private void setLastItem() {
        this.mMaterialManager.K(n.e().f().f73078s2 + "");
        this.mMaterialManager.D();
    }

    private void updateVoiceChangeBtn() {
        int i3;
        if (n.e().f().Z1) {
            Button button = this.mVoiceChangeBtn;
            button.setContentDescription(button.getResources().getString(R.string.f17788356));
            i3 = R.drawable.dek;
        } else {
            Button button2 = this.mVoiceChangeBtn;
            button2.setContentDescription(button2.getResources().getString(R.string.f17789357));
            i3 = R.drawable.dej;
        }
        this.mVoiceChangeBtn.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public BaseToolbar.a getUIInfo() {
        if (this.mUIInfo == null) {
            BaseToolbar.a aVar = new BaseToolbar.a();
            this.mUIInfo = aVar;
            aVar.f75560d = 5;
            aVar.f75564h = R.layout.f168483fu1;
            aVar.f75562f = R.drawable.de_;
            aVar.f75563g = this.mApp.getApp().getString(R.string.dlf);
        }
        return this.mUIInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.trr) {
            n.e().f().Z1 = !n.e().f().Z1;
            if (n.e().f().f73078s2 != 0) {
                r.h0().w(n.e().f().Z1);
            }
            updateVoiceChangeBtn();
            if (!n.e().f().Z1) {
                e.n(this.mApp, 1017);
                ap.c("0X8007EF4", "");
            } else {
                ap.c("0X8007EF3", "");
                ReportController.o(null, "dc00898", "", "", "0X800BC15", "0X800BC15", AVUtil.h(), 0, "", "", "", "");
            }
            BaseToolbar.keepInToolbar(this.mApp, -1010L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onCreate(long j3, AVActivity aVActivity) {
        this.mMaterialManager = (hu.a) this.mApp.B(15);
        this.mRecyclerView = (MaterialRecyclerView) this.toolbarView.findViewById(R.id.zfh);
        ArrayList<QavListItemBase.c> list = getList();
        this.mItemInfo = list;
        MaterialAdapter materialAdapter = new MaterialAdapter(this.mApp, aVActivity, list, this.mRecyclerView, 4, false);
        this.mAdapter = materialAdapter;
        this.mRecyclerView.setAdapter(materialAdapter);
        this.mAdapter.v0(this.mVoiceClickCallback);
        Button button = (Button) this.toolbarView.findViewById(R.id.trr);
        this.mVoiceChangeBtn = button;
        button.setTextSize(ViewUtils.pxTosp(BaseAIOUtils.f(12.0f, aVActivity.getResources())));
        this.mVoiceChangeBtn.setOnClickListener(this);
        this.mMaterialManager.K(null);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onDestroy(long j3, VideoAppInterface videoAppInterface) {
        hu.a aVar = this.mMaterialManager;
        if (aVar != null) {
            aVar.K(null);
        }
        MaterialAdapter materialAdapter = this.mAdapter;
        if (materialAdapter != null) {
            materialAdapter.onDestroy();
        }
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected void onShow(long j3, int i3, boolean z16) {
        updateVoiceChangeBtn();
        setLastItem();
        AVUtil.c(102);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public void updateRecycler() {
        this.mRecyclerView.C(this.mActivity.get());
    }
}
