package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.bean.ShareMessageInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msgselect.api.IMsgSelectApi;
import com.tencent.util.LoadingUtil;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class InviteWithMsgGroup implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private Activity C;
    private View D;
    private CheckBox E;
    private Button F;
    private TextView G;
    private TextView H;
    private ViewGroup I;
    private final Runnable J;
    private String K;
    private final Runnable L;
    private final IMsgOperateCallback M;

    /* renamed from: d, reason: collision with root package name */
    private String f285677d;

    /* renamed from: e, reason: collision with root package name */
    private long f285678e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f285679f;

    /* renamed from: h, reason: collision with root package name */
    private final List<Long> f285680h;

    /* renamed from: i, reason: collision with root package name */
    private final List<Long> f285681i;

    /* renamed from: m, reason: collision with root package name */
    private final List<Long> f285682m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IMsgOperateCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteWithMsgGroup.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                return;
            }
            if (i3 != 0 || bl.b(arrayList)) {
                InviteWithMsgGroup.this.x(null);
                return;
            }
            InviteWithMsgGroup.this.m(arrayList, Boolean.TRUE);
            int size = arrayList.size();
            if (size > 30) {
                InviteWithMsgGroup.this.x(arrayList.subList(size - 30, size));
            } else {
                InviteWithMsgGroup.this.x(arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements IMsgOperateCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteWithMsgGroup.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                return;
            }
            if (i3 != 0) {
                QLog.i("InviteWithMsgGroup", 1, "get Msg error when check Continuity, " + str);
                InviteWithMsgGroup.this.u(false, 0);
                return;
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            InviteWithMsgGroup.this.m(arrayList, Boolean.FALSE);
            int size = InviteWithMsgGroup.this.f285680h.size();
            InviteWithMsgGroup inviteWithMsgGroup = InviteWithMsgGroup.this;
            if (arrayList.size() >= size) {
                z16 = false;
            }
            inviteWithMsgGroup.u(z16, InviteWithMsgGroup.this.f285680h.size());
        }
    }

    public InviteWithMsgGroup(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            return;
        }
        this.f285680h = new ArrayList();
        this.f285681i = new ArrayList();
        this.f285682m = new ArrayList();
        this.L = new Runnable() { // from class: com.tencent.mobileqq.selectmember.InviteWithMsgGroup.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InviteWithMsgGroup.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QLog.d("InviteWithMsgGroup", 1, "mTimeoutCallback");
                    InviteWithMsgGroup.this.s(0);
                }
            }
        };
        this.M = new b();
        this.J = runnable;
    }

    private void h() {
        if (this.f285680h.isEmpty()) {
            u(false, 0);
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(2, this.f285677d, ""), this.f285680h.get(0).longValue(), 500, false, this.M);
        }
    }

    private boolean i(Activity activity) {
        if (!activity.getIntent().getBooleanExtra(ISelectMemberActivityConstants.PARAM_WITH_HISTORY, false)) {
            QLog.d("InviteWithMsgGroup", 1, "checkWithHistoryMsg intent mWithHistoryMsg false");
            return false;
        }
        if (!com.tencent.mobileqq.selectmember.util.b.a(MobileQQ.sMobileQQ.peekAppRuntime())) {
            QLog.d("InviteWithMsgGroup", 1, "doOnCreate feature disable");
            return false;
        }
        this.f285679f = true;
        return true;
    }

    private void l() {
        QLog.d("InviteWithMsgGroup", 1, "fetchHistoryMsg");
        this.I.addView(LoadingUtil.getLoadingView(this.C, ViewUtils.dip2px(24.0f), ViewUtils.dip2px(24.0f), 3));
        this.H.setText(R.string.f214115s1);
        this.H.setClickable(false);
        this.G.setClickable(false);
        this.f285678e = System.currentTimeMillis();
        ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(new Contact(2, this.f285677d, ""), 0L, 100, true, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(List<MsgRecord> list, Boolean bool) {
        QLog.d("InviteWithMsgGroup", 1, "filterMessage now=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", this.C.getResources().getConfiguration().locale).format(new Date(this.f285678e)));
        Iterator<MsgRecord> it = list.iterator();
        while (it.hasNext()) {
            if (v(it.next(), bool)) {
                it.remove();
            }
        }
    }

    private com.tencent.qqnt.msgselect.api.a n() {
        List arrayList;
        if (this.E.isChecked()) {
            arrayList = this.f285680h;
        } else {
            arrayList = new ArrayList();
        }
        return new com.tencent.qqnt.msgselect.api.a(this.C, 10002, 2, this.f285677d, "", 1002, arrayList, e.c(), e.b() * 86400000);
    }

    private boolean p(MsgRecord msgRecord) {
        if (msgRecord.getSendType() != 1) {
            return false;
        }
        if (msgRecord.getSendStatus() != 0 && msgRecord.getSendStatus() != 1) {
            return false;
        }
        return true;
    }

    private void q(long[] jArr, long[] jArr2, long[] jArr3) {
        if (jArr != null && jArr2 != null && jArr3 != null) {
            this.f285680h.clear();
            this.f285681i.clear();
            this.f285682m.clear();
            for (long j3 : jArr) {
                this.f285680h.add(Long.valueOf(j3));
            }
            for (long j16 : jArr2) {
                this.f285681i.add(Long.valueOf(j16));
            }
            for (long j17 : jArr3) {
                this.f285682m.add(Long.valueOf(j17));
            }
            if (QLog.isColorLevel()) {
                QLog.i("InviteWithMsgGroup", 1, "mSelectedNTMsgIdList size " + this.f285680h.size() + ", mSelectedNTMsgTimeList size " + this.f285681i.size() + ", mSelectedNTMsgSeqList size " + this.f285682m.size());
            }
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3) {
        ViewGroup viewGroup = this.I;
        if (viewGroup != null && this.E != null && this.D != null && this.G != null) {
            viewGroup.removeAllViews();
            View findViewById = this.D.findViewById(R.id.d5t);
            this.E.setVisibility(0);
            if (i3 > 0) {
                this.G.setOnClickListener(this);
                this.H.setText(this.C.getString(R.string.f214105s0, Integer.valueOf(i3)));
                this.H.setOnClickListener(this);
                findViewById.setVisibility(0);
                return;
            }
            this.G.setEnabled(false);
            this.H.setText(R.string.f214095rz);
            this.H.setEnabled(false);
            this.E.setEnabled(false);
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r(i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3) { // from class: com.tencent.mobileqq.selectmember.InviteWithMsgGroup.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f285683d;

                {
                    this.f285683d = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteWithMsgGroup.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        InviteWithMsgGroup.this.r(this.f285683d);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z16, int i3) {
        int i16;
        if (z16) {
            i16 = R.string.f214105s0;
        } else {
            i16 = R.string.f214125s2;
        }
        boolean z17 = true;
        this.H.setText(this.C.getString(i16, Integer.valueOf(i3)));
        CheckBox checkBox = this.E;
        if (i3 <= 0) {
            z17 = false;
        }
        checkBox.setChecked(z17);
        if (i3 > 0) {
            this.K = "2";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z16, int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            t(z16, i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.selectmember.InviteWithMsgGroup.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f285684d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f285685e;

                {
                    this.f285684d = z16;
                    this.f285685e = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, InviteWithMsgGroup.this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        InviteWithMsgGroup.this.t(this.f285684d, this.f285685e);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    private boolean v(MsgRecord msgRecord, Boolean bool) {
        if (this.f285678e >= msgRecord.getMsgTime() * 1000 && ((!bool.booleanValue() || (this.f285678e - (msgRecord.getMsgTime() * 1000)) / 86400000 < e.b()) && msgRecord.getMsgType() != 5 && msgRecord.getMsgType() != 6 && msgRecord.getMsgType() != 19 && msgRecord.getMsgType() != 23 && !p(msgRecord))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(List<MsgRecord> list) {
        ViewGroup viewGroup = this.I;
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.L);
            this.f285680h.clear();
            this.f285681i.clear();
            this.f285682m.clear();
            if (list != null && !list.isEmpty()) {
                for (MsgRecord msgRecord : list) {
                    this.f285680h.add(Long.valueOf(msgRecord.getMsgId()));
                    this.f285681i.add(Long.valueOf(msgRecord.getMsgTime()));
                    this.f285682m.add(Long.valueOf(msgRecord.getMsgSeq()));
                }
                s(list.size());
                return;
            }
            s(0);
        }
    }

    public void j(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) intent);
            return;
        }
        QLog.d("InviteWithMsgGroup", 1, "doOnActivityResult resultCode=" + i3);
        if (-1 != i3) {
            return;
        }
        if (intent == null) {
            QLog.d("InviteWithMsgGroup", 1, "doOnActivityResult data is null");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null && !extras.getBoolean("key_is_cancel", false)) {
            q(extras.getLongArray("key_select_msg_ids"), extras.getLongArray("key_select_msg_times"), extras.getLongArray("key_select_msg_seqs"));
        }
    }

    public boolean k(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) str)).booleanValue();
        }
        com.tencent.mobileqq.selectmember.b.a("0X800C129");
        if (!i(activity)) {
            return false;
        }
        this.C = activity;
        this.f285677d = str;
        View inflate = ((ViewStub) activity.findViewById(R.id.f124807kc)).inflate();
        this.D = inflate;
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.f124777k_);
        this.E = checkBox;
        checkBox.setOnClickListener(this);
        Button button = (Button) this.D.findViewById(R.id.ub6);
        this.F = button;
        button.setOnClickListener(this);
        w(false, 0);
        this.G = (TextView) this.D.findViewById(R.id.f124817kd);
        this.H = (TextView) this.D.findViewById(R.id.f124787ka);
        this.I = (ViewGroup) this.D.findViewById(R.id.ef_);
        FontSettingManager.resetViewSize2Normal(this.C, this.D);
        com.tencent.mobileqq.selectmember.b.a("0X800C0E4");
        l();
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.L, 10000L);
        return true;
    }

    public List<ShareMessageInfo> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!this.f285679f) {
            QLog.d("InviteWithMsgGroup", 1, "[getSelectedMsgList] mSupportHistoryMsg == false");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.E.isChecked()) {
            QLog.e("InviteWithMsgGroup", 1, "[getSelectedMsgList] empty");
            return arrayList;
        }
        int min = Math.min(this.f285682m.size(), this.f285681i.size());
        for (int i3 = 0; i3 < min; i3++) {
            arrayList.add(new ShareMessageInfo(this.f285682m.get(i3).longValue(), this.f285681i.get(i3).longValue()));
        }
        QLog.d("InviteWithMsgGroup", 1, "[getSelectedMsgList] selectedSize: " + arrayList.size());
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            int i3 = 2;
            if (id5 != R.id.f124817kd && id5 != R.id.f124787ka && id5 != R.id.d5t) {
                if (id5 == R.id.ub6) {
                    if (!NetworkUtil.isNetworkAvailable()) {
                        QQToast.makeText(this.C, 1, HardCodeUtil.qqStr(R.string.f171139ci4), 0).show();
                    } else {
                        if (!this.E.isChecked()) {
                            this.K = "3";
                        } else if (!this.E.isEnabled()) {
                            this.K = "4";
                        }
                        com.tencent.mobileqq.selectmember.b.b("0X800C12A", this.K);
                        this.J.run();
                    }
                } else if (id5 == R.id.f124777k_) {
                    boolean isChecked = this.E.isChecked();
                    if (isChecked) {
                        i3 = 1;
                    }
                    if (isChecked) {
                        this.K = "1";
                    }
                    com.tencent.mobileqq.selectmember.b.b("0X800C0E6", String.valueOf(i3));
                }
            } else {
                QLog.d("InviteWithMsgGroup", 1, "with_history_title_ll mGroupCode=*" + StringUtil.getSimpleUinForPrint(this.f285677d));
                ((IMsgSelectApi) QRoute.api(IMsgSelectApi.class)).startMsgSelect(n());
                if (this.E.isChecked()) {
                    i3 = 1;
                }
                com.tencent.mobileqq.selectmember.b.b("0X800C0E5", String.valueOf(i3));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void w(boolean z16, int i3) {
        String format;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (!this.f285679f) {
            return;
        }
        this.F.setEnabled(z16);
        int f16 = BaseAIOUtils.f(16.0f, this.C.getResources());
        Button button = this.F;
        button.setPadding(f16, button.getPaddingTop(), f16, this.F.getPaddingBottom());
        if (i3 == 0) {
            format = HardCodeUtil.qqStr(R.string.t_a);
        } else {
            format = MessageFormat.format(HardCodeUtil.qqStr(R.string.t9m), Integer.valueOf(i3));
        }
        this.F.setText(format);
        this.F.setContentDescription(format);
    }
}
