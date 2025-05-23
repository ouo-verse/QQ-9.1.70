package com.tencent.biz.qqcircle.bizparts;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.Switch;
import java.util.ArrayList;
import qqcircle.QQCirclePrivateMsgShow$StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow$StGetPMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow$StPMSettingData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dc extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.qqcircle.viewmodels.f f83051d;

    /* renamed from: e, reason: collision with root package name */
    private QQCirclePrivateMsgShow$StPMSettingData f83052e;

    /* renamed from: f, reason: collision with root package name */
    private QQCirclePrivateMsgShow$StGetPMSettingRsp f83053f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f83054h;

    /* renamed from: i, reason: collision with root package name */
    private QUISettingsRecyclerView f83055i;

    /* renamed from: m, reason: collision with root package name */
    private QUIListItemAdapter f83056m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<UIStateData<QQCirclePrivateMsgShow$StGetPMSettingRsp>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable UIStateData<QQCirclePrivateMsgShow$StGetPMSettingRsp> uIStateData) {
            if (uIStateData != null && uIStateData.getState() == 3) {
                dc.this.L9(uIStateData.getData());
            } else if (uIStateData != null && uIStateData.getState() == 4) {
                dc.this.G9(uIStateData.getRetCode(), uIStateData.getMsg());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements Observer<UIStateData<QQCirclePrivateMsgShow$StChangePMSettingRsp>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable UIStateData<QQCirclePrivateMsgShow$StChangePMSettingRsp> uIStateData) {
            if (uIStateData != null && uIStateData.getState() == 3) {
                QLog.e("QCirclePrivateMessageSettingContentPart", 1, "onChanged() return success\uff01 retCode : " + uIStateData.getData().errCode.get() + " , errMsg : " + uIStateData.getData().errMsg.get());
                try {
                    dc.this.f83052e = new QQCirclePrivateMsgShow$StPMSettingData().mergeFrom(uIStateData.getData().setting.get().toByteArray());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            if (uIStateData != null && uIStateData.getState() == 4) {
                dc.this.G9(uIStateData.getRetCode(), uIStateData.getMsg());
            }
        }
    }

    private void C9() {
        QQCirclePrivateMsgShow$StPMSettingData qQCirclePrivateMsgShow$StPMSettingData = this.f83052e;
        if (qQCirclePrivateMsgShow$StPMSettingData != null && this.f83053f != null && qQCirclePrivateMsgShow$StPMSettingData.privilgetype.get() == this.f83053f.setting.privilgetype.get() && this.f83052e.fuelCost.get() == this.f83053f.setting.fuelCost.get()) {
            return;
        }
        this.f83051d.L1(this.f83052e);
    }

    private com.tencent.mobileqq.widget.listitem.a D9(String str, String str2, int i3, String str3) {
        boolean z16;
        x.b.d dVar = new x.b.d(str2);
        if (str2 != null && str2.equals(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.i(z16, F9(str2, i3, str3)));
    }

    private Group E9(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(D9(str, com.tencent.biz.qqcircle.utils.h.a(R.string.f184403ls), 4, "1"));
        arrayList.add(D9(str, com.tencent.biz.qqcircle.utils.h.a(R.string.f184443lw), 3, "2"));
        arrayList.add(D9(str, com.tencent.biz.qqcircle.utils.h.a(R.string.f184433lv), 1, "3"));
        arrayList.add(D9(str, com.tencent.biz.qqcircle.utils.h.a(R.string.f184423lu), 2, "4"));
        arrayList.add(D9(str, com.tencent.biz.qqcircle.utils.h.a(R.string.f184453lx), 5, "5"));
        return new Group("", com.tencent.biz.qqcircle.utils.h.a(R.string.f184413lt), (com.tencent.mobileqq.widget.listitem.a[]) arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]));
    }

    private com.tencent.mobileqq.widget.listitem.h F9(final String str, final int i3, final String str2) {
        return new com.tencent.mobileqq.widget.listitem.h() { // from class: com.tencent.biz.qqcircle.bizparts.db
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                dc.this.I9(str, i3, str2, view, z16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(long j3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8);
        }
        String str2 = str;
        QLog.e("QCirclePrivateMessageSettingContentPart", 1, "handleError() return error\uff01 retCode : " + j3 + " , errMsg : " + str2);
        com.tencent.biz.qqcircle.utils.cj.c(false, j3, str2, 1, QCircleToast.f91645e);
    }

    private void H9(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        this.f83054h = imageView;
        imageView.setOnClickListener(this);
        if (getHostFragment() instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(this.f83054h);
        }
        this.f83055i = (QUISettingsRecyclerView) view.findViewById(R.id.f494922u);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        this.f83056m = qUIListItemAdapter;
        this.f83055i.setAdapter(qUIListItemAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(String str, int i3, String str2, View view, boolean z16) {
        if (!TextUtils.isEmpty(this.C) && com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.e(Switch.PROTECTION.name())) {
            RFWLog.d("QOK-QCirclePrivateMessageSettingContentPart", RFWLog.USR, "[onSelectedChanged] current enabled one key defend, not selected change, text: " + str + " | isSelected:" + z16);
            K9(this.C);
            QCircleToast.l(QCircleToast.f91644d, getContext().getString(R.string.f183133ic), 0, true, false);
            return;
        }
        K9(str);
        QQCirclePrivateMsgShow$StPMSettingData qQCirclePrivateMsgShow$StPMSettingData = this.f83052e;
        if (qQCirclePrivateMsgShow$StPMSettingData != null) {
            qQCirclePrivateMsgShow$StPMSettingData.privilgetype.set(i3);
        }
        J9(str2);
    }

    private void J9(String str) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(String.valueOf(QCircleCommonUtil.getCurrentAccountLongUin())).setActionType(11).setSubActionType(39).setThrActionType(1).setExt1(str).setPageId(getPageId()));
    }

    private void K9(String str) {
        this.f83056m.t0(E9(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9(QQCirclePrivateMsgShow$StGetPMSettingRsp qQCirclePrivateMsgShow$StGetPMSettingRsp) {
        if (qQCirclePrivateMsgShow$StGetPMSettingRsp == null) {
            RFWLog.d("QOK-QCirclePrivateMessageSettingContentPart", RFWLog.USR, "[updatePMSettingData] setting rsp should not be null.");
            return;
        }
        this.f83053f = qQCirclePrivateMsgShow$StGetPMSettingRsp;
        try {
            this.f83052e = new QQCirclePrivateMsgShow$StPMSettingData().mergeFrom(qQCirclePrivateMsgShow$StGetPMSettingRsp.setting.get().toByteArray());
            RFWLog.d("QOK-QCirclePrivateMessageSettingContentPart", RFWLog.USR, "[updatePMSettingData] isProtection: " + qQCirclePrivateMsgShow$StGetPMSettingRsp.isProtection.get());
            com.tencent.biz.qqcircle.immersive.personal.utils.m.f89099a.k(Switch.PROTECTION.name(), qQCirclePrivateMsgShow$StGetPMSettingRsp.isProtection.get(), "type_private_read");
        } catch (InvalidProtocolBufferMicroException e16) {
            RFWLog.e("QOK-QCirclePrivateMessageSettingContentPart", RFWLog.USR, "[updatePMSettingData] error: ", e16);
        }
        QQCirclePrivateMsgShow$StPMSettingData qQCirclePrivateMsgShow$StPMSettingData = this.f83052e;
        if (qQCirclePrivateMsgShow$StPMSettingData == null) {
            RFWLog.d("QOK-QCirclePrivateMessageSettingContentPart", RFWLog.USR, "[updatePMSettingData] setting should not be null.");
            return;
        }
        int i3 = qQCirclePrivateMsgShow$StPMSettingData.privilgetype.get();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            this.C = com.tencent.biz.qqcircle.utils.h.a(R.string.f184403ls);
                        } else {
                            this.C = com.tencent.biz.qqcircle.utils.h.a(R.string.f184453lx);
                        }
                    } else {
                        this.C = com.tencent.biz.qqcircle.utils.h.a(R.string.f184403ls);
                    }
                } else {
                    this.C = com.tencent.biz.qqcircle.utils.h.a(R.string.f184443lw);
                }
            } else {
                this.C = com.tencent.biz.qqcircle.utils.h.a(R.string.f184423lu);
            }
        } else {
            this.C = com.tencent.biz.qqcircle.utils.h.a(R.string.f184433lv);
        }
        K9(this.C);
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.viewmodels.f fVar = (com.tencent.biz.qqcircle.viewmodels.f) getViewModel(com.tencent.biz.qqcircle.viewmodels.f.class);
        this.f83051d = fVar;
        fVar.f92847m.observe(getHostFragment(), new a());
        this.f83051d.C.observe(getHostFragment(), new b());
        this.f83051d.M1(HostDataTransUtils.getAccount());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePrivateMessageSettingContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        C9();
        if (getActivity() != null) {
            getActivity().finish();
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        H9(view);
        initViewModel();
    }
}
