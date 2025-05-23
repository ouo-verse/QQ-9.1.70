package com.tencent.mobileqq.troop.filemanager.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.bb;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f295790a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f295791b;

    /* renamed from: c, reason: collision with root package name */
    protected long f295792c;

    /* renamed from: d, reason: collision with root package name */
    protected int f295793d;

    /* renamed from: e, reason: collision with root package name */
    private int f295794e;

    /* renamed from: f, reason: collision with root package name */
    protected View f295795f;

    /* renamed from: g, reason: collision with root package name */
    protected AsyncImageView f295796g;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f295797h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f295798i;

    /* renamed from: j, reason: collision with root package name */
    protected ImageView f295799j;

    /* renamed from: k, reason: collision with root package name */
    protected CircleFileStateView f295800k;

    /* renamed from: l, reason: collision with root package name */
    protected CheckBox f295801l;

    /* renamed from: m, reason: collision with root package name */
    protected View f295802m;

    /* renamed from: n, reason: collision with root package name */
    protected n f295803n;

    /* renamed from: o, reason: collision with root package name */
    protected TroopFileItemOperation f295804o;

    /* renamed from: p, reason: collision with root package name */
    protected View.OnClickListener f295805p;

    /* renamed from: q, reason: collision with root package name */
    protected View.OnLongClickListener f295806q;

    /* renamed from: r, reason: collision with root package name */
    protected View.OnClickListener f295807r;

    /* renamed from: s, reason: collision with root package name */
    protected ah.f f295808s;

    /* renamed from: t, reason: collision with root package name */
    private e f295809t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f295810u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f295811v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f295812w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f295813x;

    /* renamed from: y, reason: collision with root package name */
    private String f295814y;

    /* renamed from: z, reason: collision with root package name */
    private SparseIntArray f295815z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                c.this.d(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean e16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                e16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                e16 = c.this.e(view);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.filemanager.data.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class ViewOnClickListenerC8690c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC8690c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                c.this.c(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements ah.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.f
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                c.this.f(view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface e {
        void B0(boolean z16, n nVar);
    }

    public c(QQAppInterface qQAppInterface, Context context, long j3, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f295810u = false;
        this.f295811v = false;
        this.f295790a = qQAppInterface;
        this.f295791b = context;
        this.f295792c = j3;
        this.f295793d = i16;
        this.f295794e = i17;
        View inflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        this.f295802m = inflate;
        View findViewById = inflate.findViewById(R.id.f167025k20);
        this.f295795f = findViewById;
        findViewById.setTag(this);
        this.f295796g = (AsyncImageView) this.f295802m.findViewById(R.id.f167030k25);
        this.f295797h = (TextView) this.f295802m.findViewById(R.id.k26);
        TextView textView = (TextView) this.f295802m.findViewById(R.id.f167028k23);
        this.f295798i = textView;
        textView.setSingleLine();
        this.f295799j = (ImageView) this.f295802m.findViewById(R.id.f167029k24);
        this.f295800k = (CircleFileStateView) this.f295802m.findViewById(R.id.f167026k21);
        this.f295801l = (CheckBox) this.f295802m.findViewById(R.id.c_i);
        this.f295804o = new TroopFileItemOperation(this.f295792c, this.f295790a, (Activity) this.f295791b);
        h();
        this.f295814y = "";
        g();
    }

    public static String a(Context context, long j3) {
        long j16 = j3 * 1000;
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        if (j16 <= serverTime) {
            return context.getString(R.string.ekr);
        }
        return (((j16 - serverTime) / 86400000) + 1) + context.getString(R.string.f171380ek4);
    }

    private void g() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.f295815z = sparseIntArray;
        sparseIntArray.put(0, 1);
        this.f295815z.put(1, 1);
        this.f295815z.put(2, 3);
        this.f295815z.put(3, 3);
        this.f295815z.put(6, -1);
        this.f295815z.put(8, 1);
        this.f295815z.put(9, 2);
        this.f295815z.put(10, 2);
        this.f295815z.put(11, -1);
        this.f295815z.put(7, -1);
    }

    private final void o(boolean z16, int i3) {
        int i16;
        CircleFileStateView circleFileStateView = this.f295800k;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        circleFileStateView.setVisibility(i16);
        if (i3 == -1) {
            this.f295800k.setVisibility(8);
            return;
        }
        this.f295800k.setVisibility(0);
        this.f295800k.setState(i3);
        if (i3 == 1) {
            this.f295800k.setContentDescription(HardCodeUtil.qqStr(R.string.f172812uf0));
        } else if (i3 == 3) {
            this.f295800k.setContentDescription(HardCodeUtil.qqStr(R.string.ueg));
        } else if (i3 == 2) {
            this.f295800k.setContentDescription(HardCodeUtil.qqStr(R.string.ueh));
        } else {
            this.f295800k.setContentDescription("");
        }
        n nVar = this.f295803n;
        long j3 = nVar.f294932r;
        long j16 = nVar.f294918d;
        if (j3 > j16) {
            j3 = j16;
        }
        while (j16 > TTL.MAX_VALUE) {
            j16 >>= 1;
            j3 >>= 1;
        }
        this.f295800k.setProgress((int) ((j3 * 100.0d) / j16));
    }

    protected n b(View view) {
        Object tag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (n) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        }
        if (view == null || (tag = view.getTag()) == null || !(tag instanceof n)) {
            return null;
        }
        return (n) tag;
    }

    protected void c(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
            return;
        }
        n b16 = b(view);
        if (b16 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("TRANS_PARAM_NT_MSGID", b16.G);
        bundle.putLong("TRANS_PARAM_NT_ELEMENTID", b16.H);
        bundle.putLong("TRANS_PARAM_UPLOAD_TIME", b16.f());
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f295790a, this.f295792c);
        switch (b16.f294930p) {
            case 0:
            case 1:
                O.D0(b16.f294915a);
                j(view, 3);
                return;
            case 2:
                this.f295804o.z(b16.f294915a, null);
                return;
            case 3:
                this.f295804o.y(b16);
                return;
            case 4:
            case 5:
            default:
                return;
            case 6:
            case 11:
                QFileUtils.n(this.f295790a, this.f295791b, null, null, this.f295792c, this.f295804o.r(b16), String.valueOf(b16.f294920f), b16.f294923i, this.f295804o.q(b16), this.f295793d, null, false, false);
                return;
            case 7:
                this.f295804o.C(b16.f294916b, b16.f294917c, b16.f294918d, b16.f294919e, bundle, null);
                j(view, 2);
                return;
            case 8:
                O.C0(b16.f294915a);
                j(view, 2);
                return;
            case 9:
                this.f295804o.w(b16.f294915a, bundle, null);
                return;
            case 10:
                this.f295804o.x(b16, bundle);
                j(view, 2);
                return;
            case 12:
                this.f295804o.B(b16, this.f295791b.getString(R.string.evm), this.f295791b.getString(R.string.evn));
                j(view, 2);
                return;
            case 13:
                this.f295804o.m(b16);
                j(view, 1);
                return;
        }
    }

    protected void d(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        n b16 = b(view.findViewById(R.id.f167026k21));
        if (b16 == null) {
            return;
        }
        if (this.f295810u) {
            if (!b16.B) {
                if (this.f295811v) {
                    e eVar = this.f295809t;
                    if (eVar != null) {
                        eVar.B0(false, b16);
                        return;
                    }
                    return;
                }
                e eVar2 = this.f295809t;
                if (eVar2 != null) {
                    eVar2.B0(true, b16);
                    return;
                }
                return;
            }
            return;
        }
        if (this.A) {
            com.tencent.imcore.message.report.a.j(this.f295790a, 5, 2);
        }
        if (!b16.B) {
            switch (b16.f294930p) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    t r16 = this.f295804o.r(b16);
                    int fileType = FileManagerUtil.getFileType(r16.f294987u);
                    if (fileType != 0 && fileType != 2) {
                        if (bb.o(this.f295790a, r16.f294972f, false, r16.f294971e, r16.f294987u, r16.f294976j, 13)) {
                            bb.r(this.f295790a, this.f295791b, r16, 3, 13, b16.f294923i, String.valueOf(b16.f294920f), false, false, false, 0L, this.f295794e, b16.f294927m);
                            return;
                        } else {
                            QFileUtils.r(this.f295790a, this.f295791b, r16, String.valueOf(b16.f294920f), b16.f294923i, this.f295793d, this.f295794e, this.A);
                            return;
                        }
                    }
                    QFileUtils.s(this.f295790a, this.f295791b, null, null, this.f295792c, r16, String.valueOf(b16.f294920f), b16.f294923i, this.f295804o.q(b16), this.f295793d, QFileUtils.b0(view.findViewById(R.id.f167030k25), b16.f294917c), false, false, false, true, this.f295794e);
                    return;
                case 4:
                case 5:
                default:
                    return;
                case 12:
                    this.f295804o.B(b16, this.f295791b.getString(R.string.evm), this.f295791b.getString(R.string.evn));
                    return;
                case 13:
                    this.f295804o.m(b16);
                    return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, this.f295792c + "");
        intent.putExtra("folderPath", b16.f294916b);
        intent.putExtra("folderName", b16.f294917c);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 2000);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage((Activity) this.f295791b, intent, 0);
    }

    protected boolean e(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view)).booleanValue();
        }
        return false;
    }

    protected void f(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        n b16 = b((TextView) view.findViewById(R.id.f167028k23));
        if (b16 == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, this.f295792c + "");
        intent.putExtra("filter_member_name", b16.g());
        intent.putExtra("filter_uin", b16.f294920f);
        intent.putExtra("folderPath", "/");
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 4000);
        intent.putExtra("key_source", this.f295794e);
        com.tencent.xaction.log.b.a("TroopFileItem<QFile>", 1, "handleOnUploaderNameClick mSource: " + this.f295794e);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage((Activity) this.f295791b, intent, 0);
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f295805p = new a();
        this.f295806q = new b();
        this.f295807r = new ViewOnClickListenerC8690c();
        this.f295808s = new d();
        this.f295795f.setOnClickListener(this.f295805p);
        this.f295795f.setOnLongClickListener(this.f295806q);
        this.f295800k.setOnClickListener(this.f295807r);
    }

    protected void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else if (z16) {
            this.f295799j.setVisibility(0);
            this.f295814y = this.f295791b.getString(R.string.b79);
        } else {
            this.f295799j.setVisibility(4);
            this.f295814y = "";
        }
    }

    protected void j(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null) {
            return;
        }
        if (view.getId() != R.id.f167026k21) {
            view = view.findViewById(R.id.f167026k21);
        }
        if (view != null && (view instanceof CircleFileStateView)) {
            ((CircleFileStateView) view).setState(i3);
        }
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f295811v = z16;
        }
    }

    public void l(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) eVar);
        } else {
            this.f295809t = eVar;
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f295810u = z16;
        }
    }

    public void n(long j3, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), qQAppInterface);
            return;
        }
        n nVar = this.f295803n;
        if (nVar != null && !nVar.B) {
            if (FileUtils.fileExistsAndNotEmpty(nVar.f294937w)) {
                FileManagerUtil.setFileIcon(this.f295796g, this.f295803n.f294937w, FileManagerUtil.getFileType(this.f295803n.f294917c));
            } else {
                this.f295796g.setDefaultImage(FileManagerUtil.getFileIconResId(this.f295803n.f294917c));
            }
        }
    }

    public void p(long j3, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), qQAppInterface);
            return;
        }
        n nVar = this.f295803n;
        if (nVar != null && !nVar.B && nVar != null && nVar.f294937w == null) {
            TroopFileTransferManager.O(qQAppInterface, j3).D(this.f295803n.f294915a, 128);
        }
    }

    public void q(long j3, Context context, QQAppInterface qQAppInterface, boolean z16) {
        String format;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z17;
        boolean z18;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), context, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        n nVar = this.f295803n;
        if (nVar == null) {
            return;
        }
        this.f295814y = "";
        this.f295800k.setTag(nVar);
        this.f295798i.setTag(this.f295803n);
        context.getResources();
        this.f295812w = this.f295803n.B;
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, j3);
        n nVar2 = this.f295803n;
        String str6 = nVar2.f294917c;
        if (!this.f295812w) {
            if (!z16 && nVar2 != null && nVar2.f294937w == null) {
                O.D(nVar2.f294915a, 128);
            }
            if (FileUtils.fileExistsAndNotEmpty(this.f295803n.f294937w)) {
                FileManagerUtil.setFileIcon(this.f295796g, this.f295803n.f294937w, FileManagerUtil.getFileType(this.f295803n.f294917c));
            } else {
                this.f295796g.setDefaultImage(FileManagerUtil.getFileIconResId(this.f295803n.f294917c));
            }
            this.f295796g.setContentDescription(HardCodeUtil.qqStr(R.string.uf7));
        } else {
            this.f295796g.setDefaultImage(R.drawable.e9z);
            this.f295796g.setContentDescription(HardCodeUtil.qqStr(R.string.ufm));
        }
        if (!this.f295812w) {
            String e16 = this.f295803n.e();
            str = this.f295803n.g();
            String str7 = this.f295803n.E;
            this.f295797h.setText(str6);
            this.f295797h.setMaxLines(2);
            this.f295797h.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            str3 = e16;
            str2 = str7;
        } else {
            this.f295797h.setText(str6);
            this.f295797h.setMaxLines(2);
            this.f295797h.setEllipsize(TextUtils.TruncateAt.END);
            if (this.f295803n.D.size() > 0) {
                format = String.format(this.f295791b.getString(R.string.els), Integer.valueOf(this.f295803n.D.size()));
            } else {
                n nVar3 = this.f295803n;
                if (nVar3.C < 0) {
                    nVar3.C = 0;
                }
                format = String.format(this.f295791b.getString(R.string.eks), Integer.valueOf(this.f295803n.C));
            }
            String str8 = this.f295803n.F;
            this.f295798i.setText(str8 + this.f295791b.getString(R.string.b78) + format);
            str = "";
            str2 = str;
            str3 = str2;
        }
        if (this.f295813x) {
            str = "";
        }
        n nVar4 = this.f295803n;
        int i3 = nVar4.f294923i;
        if (i3 != 0 && nVar4.f294919e != 102) {
            str4 = a(context, i3);
        } else {
            str4 = null;
        }
        String str9 = str4;
        if (com.tencent.mobileqq.troop.data.a.b(this.f295803n.f294930p) || this.f295813x) {
            z17 = false;
        } else {
            z17 = true;
        }
        n nVar5 = this.f295803n;
        int i16 = nVar5.f294930p;
        if (i16 != 0 && i16 != 1 && i16 != 2 && i16 != 8 && i16 != 9) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (i16 != 11 && i16 != 6) {
            i(false);
        } else if (q.f(nVar5.f294934t)) {
            i(true);
        } else {
            i(false);
        }
        o(z18, this.f295815z.get(this.f295803n.f294930p, -1));
        if (!z17) {
            str5 = "";
        } else {
            str5 = str;
        }
        if (this.f295810u) {
            this.f295800k.setVisibility(8);
            if (this.f295803n.B) {
                this.f295801l.setVisibility(4);
            } else {
                this.f295801l.setVisibility(0);
                this.f295801l.setChecked(this.f295811v);
            }
        } else {
            this.f295801l.setVisibility(8);
        }
        QFileUtils.n0(this.f295791b, this.f295798i, str2, str5, str3, str9, this.f295814y, true, this.f295808s);
    }
}
