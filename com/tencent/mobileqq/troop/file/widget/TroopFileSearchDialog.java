package com.tencent.mobileqq.troop.file.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.ae;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.l;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.file.data.TroopFileSearchExpandableListAdapter;
import com.tencent.mobileqq.troop.file.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.file.data.o;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.mobileqq.troop.widget.PinnedHeaderIphoneTreeView;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mqq.app.MobileQQ;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchReqBody;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchRspBody;
import tencent.im.cs.cmd0x383.cmd0x383$ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383$RspBody;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TroopFileSearchDialog extends Dialog implements Handler.Callback, ae.e, View.OnClickListener {
    protected ImageButton C;
    protected EditText D;
    protected RelativeLayout E;
    protected TroopFileSearchExpandableListAdapter F;
    protected Activity G;
    protected Handler H;
    protected CountdownTimeTask I;
    protected ae J;
    protected LinearLayout K;
    protected boolean L;
    protected Object M;
    protected boolean N;
    protected boolean P;
    protected boolean Q;
    protected boolean R;
    protected String S;
    protected int T;
    protected String U;
    protected boolean V;
    protected int W;
    protected List<j> X;
    protected List<Long> Y;
    protected long Z;

    /* renamed from: a0, reason: collision with root package name */
    protected List<o> f295693a0;

    /* renamed from: b0, reason: collision with root package name */
    protected long f295694b0;

    /* renamed from: c0, reason: collision with root package name */
    protected com.tencent.mobileqq.app.c f295695c0;

    /* renamed from: d, reason: collision with root package name */
    protected PinnedHeaderIphoneTreeView f295696d;

    /* renamed from: d0, reason: collision with root package name */
    private Bitmap f295697d0;

    /* renamed from: e, reason: collision with root package name */
    public TroopFileViewMoreRelativeLayout f295698e;

    /* renamed from: f, reason: collision with root package name */
    protected ViewGroup f295699f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f295700h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f295701i;

    /* renamed from: m, reason: collision with root package name */
    protected View f295702m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements TroopFileSearchManager.a {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.file.data.TroopFileSearchManager.a
        public void a(List<j> list) {
            TroopFileSearchDialog troopFileSearchDialog = TroopFileSearchDialog.this;
            troopFileSearchDialog.X = list;
            if (troopFileSearchDialog.N) {
                troopFileSearchDialog.N = false;
                troopFileSearchDialog.i(troopFileSearchDialog.S);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        int f295707d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f295708e = 0;

        b() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            this.f295708e = i17;
            this.f295707d = ((i3 + i16) - 1) - 1;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public synchronized void onScrollStateChanged(AbsListView absListView, int i3) {
            TroopFileSearchDialog troopFileSearchDialog = TroopFileSearchDialog.this;
            if (troopFileSearchDialog.T > 0) {
                return;
            }
            if (i3 == 0 && troopFileSearchDialog.f295693a0 != null && this.f295707d == this.f295708e - 2) {
                if (troopFileSearchDialog.V) {
                    troopFileSearchDialog.A(true);
                } else {
                    troopFileSearchDialog.A(false);
                    TroopFileSearchDialog troopFileSearchDialog2 = TroopFileSearchDialog.this;
                    QQAppInterface k3 = troopFileSearchDialog2.k();
                    TroopFileSearchDialog troopFileSearchDialog3 = TroopFileSearchDialog.this;
                    troopFileSearchDialog2.h(k3, troopFileSearchDialog3.Z, troopFileSearchDialog3.Y, troopFileSearchDialog3.S, troopFileSearchDialog3.U);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c extends com.tencent.mobileqq.app.c {
        c() {
        }

        @Override // com.tencent.mobileqq.app.c
        protected void f(boolean z16, Object obj) {
            Message obtainMessage;
            boolean z17 = true;
            TroopFileSearchDialog.this.T--;
            try {
                if (obj != null && z16) {
                    try {
                        cmd0x383$RspBody mergeFrom = new cmd0x383$RspBody().mergeFrom((byte[]) obj);
                        if (mergeFrom == null) {
                            QLog.d("TroopFileSearchDialog", 1, "onRspTroopFileSearch: error, bigRsp is null.");
                        } else {
                            int i3 = mergeFrom.int32_ret_code.get();
                            if (i3 < 0) {
                                QLog.d("TroopFileSearchDialog", 1, "onRspTroopFileSearch: error, retCode[" + i3 + "]");
                            } else {
                                cmd0x383$ApplyFileSearchRspBody cmd0x383_applyfilesearchrspbody = mergeFrom.msg_file_search_rsp_body.get();
                                if (cmd0x383_applyfilesearchrspbody == null) {
                                    QLog.d("TroopFileSearchDialog", 1, "onRspTroopFileSearch: error, rsp body is null.");
                                } else {
                                    TroopFileSearchDialog.this.U = cmd0x383_applyfilesearchrspbody.bytes_sync_cookie.get().toStringUtf8();
                                    TroopFileSearchDialog.this.W = cmd0x383_applyfilesearchrspbody.uint32_total_match_count.get();
                                    TroopFileSearchDialog troopFileSearchDialog = TroopFileSearchDialog.this;
                                    if (cmd0x383_applyfilesearchrspbody.uint32_is_end.get() != 1) {
                                        z17 = false;
                                    }
                                    troopFileSearchDialog.V = z17;
                                    if (QLog.isDevelopLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("onRspTroopFileSearch cookie = " + TroopFileSearchDialog.this.U);
                                        sb5.append(", isEnd = " + TroopFileSearchDialog.this.V);
                                        sb5.append(", keyWord = " + cmd0x383_applyfilesearchrspbody.bytes_key_word.get().toStringUtf8());
                                        sb5.append(", totalCount = " + cmd0x383_applyfilesearchrspbody.uint32_total_match_count.get());
                                        QLog.d("TroopFileSearchDialog", 4, sb5.toString());
                                    }
                                    synchronized (TroopFileSearchDialog.this.M) {
                                        TroopFileSearchDialog troopFileSearchDialog2 = TroopFileSearchDialog.this;
                                        List<o> list = troopFileSearchDialog2.f295693a0;
                                        if (list != null) {
                                            list.clear();
                                        } else {
                                            troopFileSearchDialog2.f295693a0 = new ArrayList();
                                        }
                                    }
                                    List<cmd0x383$ApplyFileSearchRspBody.Item> list2 = cmd0x383_applyfilesearchrspbody.item_list.get();
                                    if (list2 != null) {
                                        if (list2.size() == 0) {
                                        }
                                        for (int i16 = 0; i16 < list2.size(); i16++) {
                                            o oVar = new o(TroopFileSearchDialog.this.k(), list2.get(i16));
                                            if (oVar.f295512i != null) {
                                                TroopFileManager F = TroopFileManager.F(TroopFileSearchDialog.this.k(), oVar.f295504a);
                                                n A = F.A(oVar.f295512i.f294916b);
                                                if (A != null) {
                                                    oVar.f295512i.f294915a = A.f294915a;
                                                } else {
                                                    oVar.f295512i.f294915a = UUID.randomUUID();
                                                }
                                                n nVar = oVar.f295512i;
                                                F.R(nVar.f294916b, nVar);
                                            }
                                            if (QLog.isColorLevel()) {
                                                QLog.d("TroopFileSearchDialog", 4, "fileList[" + i16 + "]: " + oVar.toString());
                                            }
                                            synchronized (TroopFileSearchDialog.this.M) {
                                                TroopFileSearchDialog.this.f295693a0.add(oVar);
                                            }
                                        }
                                        TroopFileSearchDialog.this.H.sendMessage(TroopFileSearchDialog.this.H.obtainMessage(5));
                                        return;
                                    }
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("TroopFileSearchDialog", 4, "filelist is empty--------");
                                    }
                                }
                            }
                        }
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("TroopFileSearchDialog", 4, QLog.getStackTraceString(e16));
                        }
                    }
                } else if (QLog.isDevelopLevel()) {
                    QLog.d("TroopFileSearchDialog", 4, "data = " + obj + ", isSuccess = " + z16);
                }
            } catch (Exception e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TroopFileSearchDialog", 4, QLog.getStackTraceString(e17));
                }
            }
            TroopFileSearchDialog troopFileSearchDialog3 = TroopFileSearchDialog.this;
            if (troopFileSearchDialog3.P) {
                obtainMessage = troopFileSearchDialog3.H.obtainMessage(3);
            } else {
                obtainMessage = troopFileSearchDialog3.H.obtainMessage(5);
            }
            TroopFileSearchDialog.this.H.sendMessage(obtainMessage);
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object obj) {
            o g16;
            String str;
            t tVar = (t) obj;
            TroopFileSearchExpandableListAdapter troopFileSearchExpandableListAdapter = TroopFileSearchDialog.this.F;
            if (troopFileSearchExpandableListAdapter == null || (g16 = troopFileSearchExpandableListAdapter.g(tVar.f294985s)) == null || (str = tVar.f294979m) == null) {
                return;
            }
            g16.f295512i.f294937w = str;
            TroopFileSearchDialog.this.F.notifyDataSetChanged();
        }
    }

    private void E(int i3) {
        QLog.i("TroopFileSearchDialog", 1, "startTypeResult=" + i3);
        Intent intent = new Intent();
        intent.putExtra("title_type", i3);
        intent.putExtra("troop_uin", this.Z);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileSearchByTypePage(this.G, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface k() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private void o() {
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileSearchDialog.this.s(view);
            }
        });
        Button button = (Button) findViewById(R.id.btn_cancel_search);
        button.setVisibility(0);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileSearchDialog.this.t(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        this.D.setText("");
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean u(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        InputMethodUtil.hide(view);
        j();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        dismiss();
    }

    private void y() {
        QLog.i("TroopFileSearchDialog", 1, "openTroopMemberSelector");
        Intent intent = new Intent();
        intent.putExtra("troop_uin", String.valueOf(this.Z));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 18);
        intent.putExtra("uin", this.Z);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 23);
        intent.putExtra("uintype", 1);
        RouteUtils.startActivity(this.G, intent, "/troop/memberlist/TroopMemberList");
    }

    protected void A(boolean z16) {
        if (this.f295696d.getFirstVisiblePosition() == 0) {
            this.f295698e.setVisibility(8);
            return;
        }
        this.f295698e.setVisibility(0);
        if (z16) {
            this.f295698e.setText(R.string.hql);
            this.f295698e.a();
        } else {
            this.f295698e.setText(R.string.cuy);
            this.f295698e.setTextLeftDrawable(R.drawable.f160545jt);
        }
    }

    public void C() {
        if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
        this.K.setVisibility(8);
        this.f295699f.setVisibility(0);
        this.f295700h.setVisibility(0);
        this.f295696d.setVisibility(8);
        this.f295700h.setText(this.G.getString(R.string.f171139ci4));
        this.f295700h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public final synchronized void h(QQAppInterface qQAppInterface, long j3, List<Long> list, String str, String str2) {
        if (this.T > 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopFileSearchDialog", 4, "doReqTroopFileSearch err marchWord is null--------------");
            }
        } else {
            this.f295694b0 = System.currentTimeMillis();
            this.T++;
            cmd0x383$ApplyFileSearchReqBody cmd0x383_applyfilesearchreqbody = new cmd0x383$ApplyFileSearchReqBody();
            cmd0x383_applyfilesearchreqbody.bytes_key_word.set(ByteStringMicro.copyFromUtf8(str));
            if (list != null) {
                cmd0x383_applyfilesearchreqbody.uint64_uin_list.set(list);
            }
            if (!TextUtils.isEmpty(str2)) {
                cmd0x383_applyfilesearchreqbody.bytes_sync_cookie.set(ByteStringMicro.copyFromUtf8(str2));
            }
            cmd0x383_applyfilesearchreqbody.uint32_count.set(20);
            cmd0x383$ReqBody cmd0x383_reqbody = new cmd0x383$ReqBody();
            cmd0x383_reqbody.uint64_groupcode.set(j3);
            cmd0x383_reqbody.uint32_app_id.set(3);
            cmd0x383_reqbody.msg_file_search_req_body.set(cmd0x383_applyfilesearchreqbody);
            cmd0x383_reqbody.setHasFlag(true);
            Bundle bundle = new Bundle();
            bundle.putLong("troopUin", j3);
            bundle.putString("reqKeyword", str);
            ((TroopFileHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).J2("GroupFileAppSvr.GetFileSearch", cmd0x383_reqbody.toByteArray(), bundle);
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "doReqTroopFileSearch troopUin = " + j3 + ", marchWord = " + str + ", cookie = " + str2);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.Q) {
            return true;
        }
        int i3 = message.what;
        if (i3 == 1) {
            D(true);
        } else if (i3 == 2) {
            D(false);
        } else if (i3 == 3) {
            B(true);
        } else if (i3 == 4) {
            B(false);
        } else if (i3 == 5) {
            D(false);
            z(this.D.getText().toString(), true);
            if (this.E.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
            this.K.setVisibility(8);
            if (this.P) {
                this.F.e();
            }
            if (this.L) {
                this.L = false;
                InputMethodUtil.hide(this.D);
            }
            A(this.V);
            this.F.d(this.f295693a0, this.S);
            this.F.notifyDataSetChanged();
            if (this.P) {
                this.f295696d.setSelectedGroup(0);
                this.P = false;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f295694b0;
            String lowerCase = this.D.getText().toString().trim().toLowerCase();
            if (QLog.isColorLevel()) {
                QLog.e("zivonchen", 2, "REFRESH_LIST text = " + lowerCase + ", lastHotword = " + this.S + ", time = " + currentTimeMillis);
            }
            if (!lowerCase.equals(this.S) && currentTimeMillis >= 800) {
                this.U = null;
                this.P = true;
                this.S = lowerCase;
                i(lowerCase);
                this.I = null;
            }
        }
        return false;
    }

    protected synchronized void i(String str) {
        if (this.Q) {
            return;
        }
        if (this.X == null) {
            this.N = true;
            this.H.sendEmptyMessage(1);
            QLog.d("TroopFileSearchDialog", 1, "mFriendInputSet.size() == 0");
            return;
        }
        QLog.d("TroopFileSearchDialog", 1, "searchTask = " + this.J);
        ae aeVar = this.J;
        if (aeVar != null) {
            aeVar.cancel(true);
            this.J = null;
            this.H.sendEmptyMessage(2);
        }
        this.H.sendEmptyMessage(1);
        ae aeVar2 = new ae(str, str, this.X, this);
        this.J = aeVar2;
        aeVar2.h();
    }

    protected void j() {
        if (this.f295701i.getVisibility() != 0) {
            this.f295701i.setText(n(this.W));
            this.f295701i.setVisibility(0);
            this.R = true;
            String m3 = m(this.D.getText().toString());
            if (TextUtils.isEmpty(m3)) {
                return;
            }
            this.D.setText(m3);
            this.D.setSelection(m3.length());
        }
    }

    protected float l() {
        float width = this.D.getWidth() - al.a(this.G, 20.0f);
        if (this.W > 0) {
            width -= this.D.getPaint().measureText(n(this.W)) + al.a(this.G, 16.0f);
        }
        return this.C.getVisibility() == 0 ? width - (this.C.getWidth() + al.a(this.G, 8.0f)) : width;
    }

    protected String m(String str) {
        float l3 = l();
        TextPaint paint = this.D.getPaint();
        if (TextUtils.isEmpty(str) || paint.measureText(str) <= l3) {
            return str;
        }
        return str.substring(0, paint.breakText(str, true, l3 - paint.measureText("\u2026"), null)) + "\u2026";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bnq /* 2131367247 */:
                E(1);
                ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "Clk_typebtn", 0, 0, this.Z + "", "0", "", "");
                return;
            case R.id.eol /* 2131376137 */:
                y();
                return;
            case R.id.f39 /* 2131377183 */:
                E(3);
                ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "Clk_typebtn", 0, 0, this.Z + "", "3", "", "");
                return;
            case R.id.ffu /* 2131378189 */:
                E(10000);
                ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "Clk_typebtn", 0, 0, this.Z + "", "4", "", "");
                return;
            case R.id.fs_ /* 2131378823 */:
                E(4);
                ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "Clk_typebtn", 0, 0, this.Z + "", "2", "", "");
                return;
            case R.id.kpx /* 2131392417 */:
                E(2);
                ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "Clk_typebtn", 0, 0, this.Z + "", "1", "", "");
                return;
            default:
                return;
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        Handler handler = this.H;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Bitmap bitmap = this.f295697d0;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.K.setBackgroundDrawable(null);
            this.f295697d0.recycle();
            this.f295697d0 = null;
        }
        k().removeObserver(this.f295695c0);
    }

    protected void p(Activity activity, Activity activity2, QQAppInterface qQAppInterface) {
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout = new TroopFileViewMoreRelativeLayout(activity);
        this.f295698e = troopFileViewMoreRelativeLayout;
        troopFileViewMoreRelativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        this.f295698e.setTextColor(activity.getResources().getColor(R.color.qui_common_text_secondary));
        this.f295696d.addFooterView(this.f295698e);
        this.f295698e.setVisibility(8);
        TroopFileSearchExpandableListAdapter troopFileSearchExpandableListAdapter = new TroopFileSearchExpandableListAdapter(this.G, activity2, k(), this.Z, this.f295696d, this.H);
        this.F = troopFileSearchExpandableListAdapter;
        this.f295696d.setAdapter(troopFileSearchExpandableListAdapter);
        this.f295696d.setGroupIndicator(null);
        this.f295696d.setOnScrollListener(new b());
        this.f295696d.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.file.widget.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean u16;
                u16 = TroopFileSearchDialog.this.u(view, motionEvent);
                return u16;
            }
        });
    }

    protected void x() {
        this.f295701i.setVisibility(8);
        this.Q = true;
        this.H.removeCallbacksAndMessages(null);
        CountdownTimeTask countdownTimeTask = this.I;
        if (countdownTimeTask != null) {
            countdownTimeTask.h();
            this.I = null;
        }
        this.f295699f.setVisibility(8);
        this.f295700h.setVisibility(8);
        this.f295696d.setVisibility(8);
        this.K.setVisibility(0);
        ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "exp_typebtn", 0, 0, this.Z + "", "", "", "");
        this.E.setVisibility(8);
        InputMethodUtil.show(this.D);
    }

    protected void z(String str, boolean z16) {
        if (this.W <= 0) {
            this.f295701i.setVisibility(8);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        float l3 = l() - this.D.getPaint().measureText(str);
        if (l3 < 0.0f) {
            this.f295701i.setVisibility(8);
        } else if (z16) {
            this.f295701i.setText(n(this.W));
            this.f295701i.setVisibility(0);
        }
        if (QLog.isColorLevel()) {
            QLog.e("zivonchen", 2, "resetResultNumTextVisible compareWidth = " + l3 + ", time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void B(boolean z16) {
        D(false);
        if (z16) {
            if (this.E.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
            this.K.setVisibility(8);
            this.f295699f.setVisibility(0);
            this.f295700h.setVisibility(0);
            this.f295696d.setVisibility(8);
            this.f295700h.setText(this.G.getString(R.string.el_, this.S));
            this.f295700h.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.e3n, 0, 0);
            return;
        }
        this.f295696d.setVisibility(0);
        Object obj = this.f295700h.getCompoundDrawables()[0];
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
        }
        this.f295700h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f295699f.setVisibility(8);
        this.f295700h.setVisibility(8);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.Q = true;
        InputMethodUtil.hide(this.D);
        SingleLineHotwordTextView.g();
        List<j> list = this.X;
        if (list != null) {
            list.clear();
        }
        List<o> list2 = this.f295693a0;
        if (list2 != null) {
            list2.clear();
            this.f295693a0 = null;
        }
        CountdownTimeTask countdownTimeTask = this.I;
        if (countdownTimeTask != null) {
            countdownTimeTask.h();
            this.I = null;
        }
        ae aeVar = this.J;
        if (aeVar != null) {
            aeVar.cancel(true);
        }
        Handler handler = this.H;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        TroopFileSearchExpandableListAdapter troopFileSearchExpandableListAdapter = this.F;
        if (troopFileSearchExpandableListAdapter != null) {
            troopFileSearchExpandableListAdapter.j();
            this.F = null;
        }
        k().removeObserver(this.f295695c0);
        try {
            super.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    protected void r(Activity activity) {
        requestWindowFeature(1);
        getWindow().setSoftInputMode(36);
        getWindow().setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard));
        setContentView(R.layout.a1r);
        findViewById(R.id.local_search).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFileSearchDialog.this.w(view);
            }
        });
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = ImmersiveUtils.getStatusBarHeight(activity);
        attributes.width = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 51;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            SystemBarCompact systemBarCompact = new SystemBarCompact((Dialog) this, true, activity.getResources().getColor(R.color.skin_color_title_immersive_bar));
            if (QQTheme.isDefaultOrDIYTheme() || QQTheme.isNowThemeIsNight()) {
                systemBarCompact.setStatusBarDrawable(activity.getResources().getDrawable(R.drawable.qui_status_bar_bg));
            }
            systemBarCompact.init();
            ImmersiveUtils.clearCoverForStatus(getWindow(), true);
            ImmersiveUtils.setStatusTextColor(true, getWindow());
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.local_search);
            linearLayout.setFitsSystemWindows(true);
            linearLayout.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.search.ae.e
    public void b(int i3, List<? extends l> list) {
        if (i3 == 1) {
            this.Y = TroopFileSearchManager.c(list);
            h(k(), this.Z, this.Y, this.S, this.U);
            list.clear();
        }
    }

    protected void q() {
        EditText editText = (EditText) findViewById(R.id.et_search_keyword);
        this.D = editText;
        editText.setImeOptions(3);
        this.D.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.mobileqq.troop.file.widget.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean v3;
                v3 = TroopFileSearchDialog.this.v(textView, i3, keyEvent);
                return v3;
            }
        });
        this.D.addTextChangedListener(new TextWatcher() { // from class: com.tencent.mobileqq.troop.file.widget.TroopFileSearchDialog.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj;
                TroopFileSearchDialog troopFileSearchDialog = TroopFileSearchDialog.this;
                if (troopFileSearchDialog.R) {
                    troopFileSearchDialog.R = false;
                    return;
                }
                if (editable == null) {
                    obj = "";
                } else {
                    obj = editable.toString();
                }
                if (obj.trim().equals("")) {
                    TroopFileSearchDialog.this.C.setVisibility(8);
                    TroopFileSearchDialog.this.x();
                    return;
                }
                TroopFileSearchDialog.this.C.setVisibility(0);
                if (!NetworkUtil.isNetworkAvailable(TroopFileSearchDialog.this.G)) {
                    CountdownTimeTask countdownTimeTask = TroopFileSearchDialog.this.I;
                    if (countdownTimeTask != null) {
                        countdownTimeTask.h();
                        TroopFileSearchDialog.this.I = null;
                    }
                    TroopFileSearchDialog.this.C();
                    return;
                }
                TroopFileSearchDialog troopFileSearchDialog2 = TroopFileSearchDialog.this;
                troopFileSearchDialog2.Q = false;
                CountdownTimeTask countdownTimeTask2 = troopFileSearchDialog2.I;
                if (countdownTimeTask2 == null) {
                    final String lowerCase = troopFileSearchDialog2.D.getText().toString().trim().toLowerCase();
                    TroopFileSearchDialog.this.I = new CountdownTimeTask(new Runnable() { // from class: com.tencent.mobileqq.troop.file.widget.TroopFileSearchDialog.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TroopFileSearchDialog troopFileSearchDialog3 = TroopFileSearchDialog.this;
                            if (troopFileSearchDialog3.Q) {
                                troopFileSearchDialog3.I = null;
                                return;
                            }
                            try {
                                troopFileSearchDialog3.S = troopFileSearchDialog3.D.getText().toString().trim().toLowerCase();
                            } catch (IndexOutOfBoundsException unused) {
                                TroopFileSearchDialog.this.S = lowerCase;
                            }
                            TroopFileSearchDialog troopFileSearchDialog4 = TroopFileSearchDialog.this;
                            troopFileSearchDialog4.U = null;
                            troopFileSearchDialog4.W = 0;
                            troopFileSearchDialog4.P = true;
                            troopFileSearchDialog4.i(troopFileSearchDialog4.S);
                            TroopFileSearchDialog.this.I = null;
                        }
                    }, 800);
                    ThreadManagerV2.post(TroopFileSearchDialog.this.I, 5, null, true);
                    return;
                }
                if (countdownTimeTask2.e() > 0) {
                    TroopFileSearchDialog.this.I.f();
                } else if (QLog.isColorLevel()) {
                    QLog.e("TroopFileSearchDialog", 2, "!!!!!! \u8fd9\u662f\u4e2a\u4ec0\u4e48\u60c5\u51b5,\u903b\u8f91\u51fa\u9519\u4e86 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                TroopFileSearchDialog.this.f295701i.setVisibility(8);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.D.setSelection(0);
        this.D.requestFocus();
    }

    protected String n(int i3) {
        if (i3 > 1000) {
            return this.G.getString(R.string.ele);
        }
        return this.G.getString(R.string.eld, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean v(TextView textView, int i3, KeyEvent keyEvent) {
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        InputMethodUtil.hide(this.D);
        if (!TextUtils.isEmpty(textView.getText().toString())) {
            j();
        }
        ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "Clk_button", 0, 0, String.valueOf(this.Z), AppSetting.d(), "", "");
        return true;
    }

    public void D(boolean z16) {
        if (z16) {
            if (this.E.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
            this.K.setVisibility(8);
            this.f295699f.setVisibility(0);
            this.f295700h.setVisibility(0);
            this.f295696d.setVisibility(8);
            this.f295700h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.f160545jt, 0, 0, 0);
            this.f295700h.setText(R.string.cuy);
            Object obj = this.f295700h.getCompoundDrawables()[0];
            if (obj instanceof Animatable) {
                ((Animatable) obj).start();
                return;
            }
            return;
        }
        this.f295696d.setVisibility(0);
        Object obj2 = this.f295700h.getCompoundDrawables()[0];
        if (obj2 instanceof Animatable) {
            ((Animatable) obj2).stop();
        }
        this.f295700h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f295699f.setVisibility(8);
        this.f295700h.setVisibility(8);
    }

    public TroopFileSearchDialog(Activity activity, Activity activity2, View view, long j3) {
        super(activity, R.style.f173640hx);
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = true;
        this.M = new Object();
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = "";
        this.T = 0;
        this.U = null;
        this.V = false;
        this.W = 0;
        this.X = null;
        this.Y = null;
        this.Z = 0L;
        this.f295693a0 = null;
        this.f295694b0 = 0L;
        this.f295695c0 = new c();
        this.G = activity;
        this.Z = j3;
        r(activity);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.result_layout);
        this.E = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f295696d = (PinnedHeaderIphoneTreeView) findViewById(R.id.search_result_list);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ikl);
        this.K = linearLayout;
        linearLayout.setVisibility(0);
        this.f295699f = (ViewGroup) findViewById(R.id.f166132ef4);
        this.f295700h = (TextView) findViewById(R.id.ef6);
        this.f295701i = (TextView) findViewById(R.id.kaf);
        this.f295702m = findViewById(R.id.ayb);
        this.C = (ImageButton) findViewById(R.id.ib_clear_text);
        this.H = new Handler(this);
        findViewById(R.id.bnq).setOnClickListener(this);
        findViewById(R.id.kpx).setOnClickListener(this);
        findViewById(R.id.fs_).setOnClickListener(this);
        findViewById(R.id.f39).setOnClickListener(this);
        findViewById(R.id.ffu).setOnClickListener(this);
        findViewById(R.id.eol).setOnClickListener(this);
        q();
        o();
        p(activity, activity2, k());
        k().addObserver(this.f295695c0);
        TroopFileSearchManager.g().i(this.G, k(), 0, new a());
        ReportController.o(k(), "P_CliOper", "Grp_files", "", "search", "exp_typebtn", 0, 0, this.Z + "", "", "", "");
    }
}
