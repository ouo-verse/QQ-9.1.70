package com.tencent.mobileqq.friend.device;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.dataline.activities.PrinterActivity;
import com.dataline.nt.DataLineRecentContactUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.adapter.j;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends j implements View.OnClickListener {
    protected QQAppInterface F;
    protected Context G;
    private boolean H;
    private boolean I;
    protected int J;
    protected boolean K;
    protected boolean L;
    private ArrayList<c> M;

    public b(Context context, QQAppInterface qQAppInterface, ListView listView, int i3, boolean z16) {
        super(context, qQAppInterface, listView, i3, z16);
        this.H = false;
        this.I = false;
        this.K = true;
        this.L = true;
        this.M = new ArrayList<>();
        this.F = qQAppInterface;
        this.G = context;
    }

    private void h(List<c> list) {
        String string;
        String str = AppConstants.DATALINE_PC_UIN;
        d l3 = l(str, HardCodeUtil.qqStr(R.string.cf5), HardCodeUtil.qqStr(R.string.cf5), (byte) (m(str) ? 10 : 0), 1001);
        list.add(new a(this.F, this.G, l3));
        if (l3.w() != 0) {
            this.J++;
        }
        if (AppSetting.p(BaseApplication.getContext())) {
            if (((RegisterProxySvcPackHandler) this.F.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).O2() == 1) {
                String str2 = AppConstants.DATALINE_PHONE_UIN;
                d l16 = l(str2, HardCodeUtil.qqStr(R.string.f169742j6), HardCodeUtil.qqStr(R.string.f169742j6), (byte) (m(str2) ? 10 : 0), 1001);
                list.add(new a(this.F, this.G, l16));
                if (l16.w() != 0) {
                    this.J++;
                    return;
                }
                return;
            }
            return;
        }
        String str3 = AppConstants.DATALINE_IPAD_UIN;
        if (m(str3) || this.H) {
            if (((RegisterProxySvcPackHandler) this.F.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                string = this.G.getString(R.string.c5g);
            } else {
                string = this.G.getString(R.string.f16272217);
            }
            String str4 = string;
            d l17 = l(str3, str4, str4, (byte) (m(str3) ? 10 : 0), 1001);
            list.add(new a(this.F, this.G, l17));
            if (l17.w() != 0) {
                this.J++;
            }
            if (this.I) {
                return;
            }
            ReportController.o(this.F, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
            this.I = true;
            if (QLog.isColorLevel()) {
                QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
            }
        }
    }

    private void i(List<c> list) {
        String g16 = h.g(this.F);
        String g17 = ac.g(this.F, g16, true);
        if (TextUtils.isEmpty(g17) || g17.equals(g16)) {
            g17 = this.G.getString(R.string.f187533u9);
        }
        d dVar = new d();
        dVar.v0(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(g16));
        dVar.w0(g16);
        dVar.w0(g16);
        dVar.m0(g17);
        dVar.k0(g17);
        dVar.u0(10);
        list.add(new a(this.F, this.G, dVar));
    }

    private void j() {
        ArrayList arrayList = new ArrayList();
        if (h.p(this.F)) {
            i(arrayList);
        } else {
            h(arrayList);
        }
        if (((PrinterStatusHandler) this.F.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).H2()) {
            d l3 = l(AppConstants.DATALINE_PRINTER_UIN, this.G.getString(R.string.ago), this.G.getString(R.string.ago), (byte) (m(AppConstants.DATALINE_IPAD_UIN) ? 10 : 0), 1001);
            arrayList.add(new a(this.F, this.G, l3));
            if (l3.w() != 0) {
                this.J++;
            }
        }
        this.M.addAll(arrayList);
    }

    private d l(String str, String str2, String str3, int i3, int i16) {
        d dVar = new d();
        dVar.w0(str);
        dVar.v0(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str));
        dVar.m0(str2);
        dVar.k0(str3);
        dVar.u0(i3);
        dVar.v0(DataLineRecentContactUtil.f32313a.h(str));
        return dVar;
    }

    private boolean m(String str) {
        int O2;
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.F.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (str.equals(AppConstants.DATALINE_PC_UIN)) {
            O2 = registerProxySvcPackHandler.P2();
        } else if (str.equals(AppConstants.DATALINE_IPAD_UIN)) {
            O2 = registerProxySvcPackHandler.N2();
        } else {
            O2 = AppSetting.p(BaseApplication.getContext()) ? registerProxySvcPackHandler.O2() : 0;
        }
        return O2 == 1 || O2 == 2;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        ArrayList<c> arrayList = this.M;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<c> arrayList = this.M;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i3);
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View a16 = this.M.get(i3).a(0, i3, view, viewGroup, null);
        if (a16 != null) {
            c.C7154c c7154c = (c.C7154c) a16.getTag();
            e(c7154c, null);
            a16.setOnClickListener(this);
            VideoReport.setElementId(a16, "em_bas_device_entry");
            VideoReport.setElementParam(a16, "devname", c7154c.f181511h.getText());
            VideoReport.setElementExposePolicy(a16, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(a16, ClickPolicy.REPORT_ALL);
        }
        return a16;
    }

    public void k() {
        ArrayList<c> arrayList = this.M;
        if (arrayList != null) {
            arrayList.clear();
        }
        super.notifyDataSetChanged();
    }

    public void n(boolean z16, String str) {
        ArrayList<c> arrayList = this.M;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                d x16 = aVar.x();
                String x17 = x16.x();
                String str2 = AppConstants.DATALINE_PC_UIN;
                if ((x17.equals(str2) || x16.x().equals(AppConstants.DATALINE_PRINTER_UIN)) && (str.equals(str2) || str.equals(AppConstants.DATALINE_PRINTER_UIN))) {
                    x16.u0((byte) (z16 ? 10 : 0));
                }
                if (x16.x().equals(str)) {
                    x16.u0((byte) (z16 ? 10 : 0));
                }
                if (x16.w() != 0) {
                    i3++;
                }
            }
        }
        this.J = i3;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.M.clear();
        j();
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.adapter.j, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        super.onScrollStateChanged(absListView, i3);
        if (i3 != 0) {
            ApngImage.pauseByTag(3);
        }
        if (i3 == 0) {
            ApngImage.playByTag(3);
        }
    }

    public void p() {
        ArrayList<c> arrayList = this.M;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                i3 = -1;
                break;
            }
            a aVar = (a) arrayList.get(i3);
            if (aVar != null && aVar.x().x().equals(AppConstants.DATALINE_PRINTER_UIN)) {
                break;
            } else {
                i3++;
            }
        }
        if (((PrinterStatusHandler) this.F.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).H2()) {
            if (i3 == -1) {
                arrayList.add(new a(this.F, this.G, l(AppConstants.DATALINE_PRINTER_UIN, this.G.getString(R.string.ago), this.G.getString(R.string.ago), (byte) (m(AppConstants.DATALINE_PC_UIN) ? 10 : 0), 1001)));
            }
        } else if (i3 != -1) {
            arrayList.remove(i3);
        }
        String str = AppConstants.DATALINE_PC_UIN;
        n(m(str), str);
    }

    public void q(QQAppInterface qQAppInterface) {
        if (qQAppInterface != this.F) {
            this.F = qQAppInterface;
        }
    }

    public void r(boolean z16) {
        this.L = z16;
    }

    public void o() {
        String string;
        ArrayList<c> arrayList = this.M;
        this.H = true;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                i3 = -1;
                break;
            }
            a aVar = (a) arrayList.get(i3);
            if (aVar != null && aVar.x().x().equals(AppConstants.DATALINE_IPAD_UIN)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1) {
            RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.F.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
            if (registerProxySvcPackHandler.U2()) {
                string = this.G.getString(R.string.c5g);
            } else {
                string = this.G.getString(R.string.f16272217);
            }
            String str = string;
            String str2 = AppConstants.DATALINE_IPAD_UIN;
            d l3 = l(str2, str, str, (byte) (m(str2) ? 10 : 0), 1001);
            arrayList.add(new a(this.F, this.G, l3));
            this.J = l3.w() != 0 ? 1 : 0;
            ReportController.o(this.F, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
            this.I = true;
            if (QLog.isColorLevel()) {
                QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
            }
            registerProxySvcPackHandler.e3(1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        BuddyListFriends.a aVar = (BuddyListFriends.a) view.getTag();
        if (aVar == null || !(aVar instanceof BuddyListFriends.a) || (dVar = (d) aVar.f181513m) == null) {
            return;
        }
        String x16 = dVar.x();
        if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(x16)) {
            if (QLog.isColorLevel()) {
                QLog.d("SDKQQAgentPerf", 2, "devicesearchEntry:" + System.currentTimeMillis());
            }
            try {
                ((IRedTouchManager) this.F.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100701.100702");
            } catch (Exception unused) {
            }
        }
        if (AppConstants.DATALINE_PC_UIN.equals(dVar.x())) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick PeerUid.DATALINE_PC_UID is u_rK7NMsbv2ZjEGPdCuOiCfw ,f.uin is " + dVar.x());
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
            Context context = this.G;
            iAIOStarterApi.navigateToAIOActivity(context, 8, PeerUid.DATALINE_PC_UID, context.getResources().getString(R.string.c5f), 0L, new Bundle());
            ReportController.o(this.F, "CliOper", "", "", "0X800603C", "0X800603C", 0, 0, "", "", "", "");
            return;
        }
        if (AppConstants.DATALINE_PHONE_UIN.equals(dVar.x())) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick PeerUid.DATALINE_PHONE_UIN is u_Wcc5rknRRqRO8y5gxMD6sA ,f.uin is " + dVar.x());
            IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
            Context context2 = this.G;
            iAIOStarterApi2.navigateToAIOActivity(context2, 8, PeerUid.DATALINE_PHONE_UID, context2.getResources().getString(R.string.f16273218), 0L, new Bundle());
            ReportController.o(this.F, "CliOper", "", "", "0X800C3C4", "0X800C3C4", 0, 0, "", "", "", "");
            return;
        }
        if (AppConstants.DATALINE_IPAD_UIN.equals(dVar.x())) {
            if (((RegisterProxySvcPackHandler) this.F.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick ipad PeerUid.DATALINE_PAD_UID is u_l7jpPIZxQo0mzJwoEt-SKw ,f.uin is " + dVar.x());
                IAIOStarterApi iAIOStarterApi3 = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
                Context context3 = this.G;
                iAIOStarterApi3.navigateToAIOActivity(context3, 8, PeerUid.DATALINE_PAD_UID, context3.getResources().getString(R.string.c5g), 0L, new Bundle());
            } else {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick pad PeerUid.DATALINE_PAD_UID is u_l7jpPIZxQo0mzJwoEt-SKw ,f.uin is " + dVar.x());
                IAIOStarterApi iAIOStarterApi4 = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
                Context context4 = this.G;
                iAIOStarterApi4.navigateToAIOActivity(context4, 8, PeerUid.DATALINE_PAD_UID, context4.getResources().getString(R.string.f16272217), 0L, new Bundle());
            }
            ReportController.o(this.F, "CliOper", "", "", "0X800C3A7", "0X800C3A7", 0, 0, "", "", "", "");
            return;
        }
        if (x16.equals(h.g(this.F))) {
            h.t(this.G, null);
        } else if (AppConstants.DATALINE_PRINTER_UIN.equals(x16)) {
            this.G.startActivity(new Intent(this.G, (Class<?>) PrinterActivity.class));
        }
    }
}
