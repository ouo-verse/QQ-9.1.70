package com.tencent.mobileqq.troop.file.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.tendoc.TenDocGroupListEntryConfigProcessor;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.bb;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.t;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.s;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipRightMenuBuilder;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes35.dex */
public class j {
    protected BubblePopupWindow A;
    protected TroopFileItemOperation B;
    protected View.OnClickListener C;
    protected View.OnLongClickListener D;
    protected View.OnClickListener E;
    protected ah.f F;
    private View.OnClickListener G;
    private b H;
    private SparseIntArray I;
    private final com.tencent.mobileqq.troop.file.data.b J;

    /* renamed from: a, reason: collision with root package name */
    private k f295461a;

    /* renamed from: b, reason: collision with root package name */
    private long f295462b;

    /* renamed from: c, reason: collision with root package name */
    public RelativeLayout f295463c;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f295464d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f295465e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f295466f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f295467g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f295468h;

    /* renamed from: i, reason: collision with root package name */
    private CheckBox f295469i;

    /* renamed from: j, reason: collision with root package name */
    private CircleFileStateView f295470j;

    /* renamed from: k, reason: collision with root package name */
    public View f295471k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.mobileqq.troop.data.n f295472l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.mobileqq.troop.widget.j f295473m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f295475o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f295476p;

    /* renamed from: q, reason: collision with root package name */
    public Activity f295477q;

    /* renamed from: s, reason: collision with root package name */
    private String f295479s;

    /* renamed from: t, reason: collision with root package name */
    private String f295480t;

    /* renamed from: u, reason: collision with root package name */
    private String f295481u;

    /* renamed from: v, reason: collision with root package name */
    private String f295482v;

    /* renamed from: z, reason: collision with root package name */
    private int f295486z;

    /* renamed from: r, reason: collision with root package name */
    private boolean f295478r = false;

    /* renamed from: w, reason: collision with root package name */
    private String f295483w = "";

    /* renamed from: x, reason: collision with root package name */
    private boolean f295484x = false;

    /* renamed from: y, reason: collision with root package name */
    private boolean f295485y = false;

    /* renamed from: n, reason: collision with root package name */
    public SwipRightMenuBuilder.SwipItemBaseHolder f295474n = new SwipRightMenuBuilder.SwipItemBaseHolder();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.troop.data.n l3 = j.this.l(view);
            if (l3 == null) {
                return;
            }
            switch (view.getId()) {
                case R.id.k27 /* 2131390591 */:
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileItem", 2, l3.f294917c);
                    }
                    if (l3.B) {
                        j.this.w(l3);
                        return;
                    } else {
                        j.this.v(l3);
                        return;
                    }
                case R.id.k28 /* 2131390592 */:
                    j.this.x(l3);
                    return;
                case R.id.k29 /* 2131390593 */:
                    j.this.s(l3);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface b {
        void B0(boolean z16, com.tencent.mobileqq.troop.data.n nVar);
    }

    public j(k kVar, com.tencent.mobileqq.troop.file.data.b bVar) {
        CheckBox checkBox;
        this.f295461a = kVar;
        this.f295477q = kVar.com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String;
        this.f295462b = kVar.troopUin;
        this.f295486z = kVar.source;
        this.J = bVar;
        com.tencent.mobileqq.troop.widget.j jVar = new com.tencent.mobileqq.troop.widget.j();
        this.f295473m = jVar;
        View b16 = jVar.b(kVar.com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String, kVar.viewId, this.f295474n);
        this.f295471k = b16;
        RelativeLayout relativeLayout = (RelativeLayout) b16.findViewById(R.id.f167025k20);
        this.f295463c = relativeLayout;
        relativeLayout.setTag(this);
        AsyncImageView asyncImageView = (AsyncImageView) this.f295471k.findViewById(R.id.f167030k25);
        this.f295464d = asyncImageView;
        asyncImageView.setSupportMaskView(false);
        this.f295465e = (ImageView) this.f295471k.findViewById(R.id.k2a);
        this.f295466f = (TextView) this.f295471k.findViewById(R.id.k26);
        TextView textView = (TextView) this.f295471k.findViewById(R.id.f167028k23);
        this.f295467g = textView;
        textView.setSingleLine();
        this.f295468h = (ImageView) this.f295471k.findViewById(R.id.f167029k24);
        this.f295470j = (CircleFileStateView) this.f295471k.findViewById(R.id.f167026k21);
        this.f295469i = (CheckBox) this.f295471k.findViewById(R.id.c_i);
        if (TokenResUtils.useTokenRes4() && (checkBox = this.f295469i) != null) {
            checkBox.setBackgroundResource(R.drawable.qui_common_check_box);
        }
        this.B = new TroopFileItemOperation(this.f295462b, kVar.app, kVar.com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String);
        A();
        this.f295476p = kVar.filterUin > 0;
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(com.tencent.mobileqq.troop.data.n nVar, View view) {
        this.B.E(nVar);
    }

    private final void L(boolean z16, int i3) {
        this.f295470j.setVisibility(z16 ? 0 : 8);
        if (i3 == -1) {
            this.f295470j.setVisibility(8);
            return;
        }
        this.f295470j.setVisibility(0);
        this.f295470j.setState(i3);
        if (i3 == 1) {
            this.f295470j.setContentDescription(HardCodeUtil.qqStr(R.string.ufz));
        } else if (i3 == 3) {
            this.f295470j.setContentDescription(HardCodeUtil.qqStr(R.string.uft));
        } else if (i3 == 2) {
            this.f295470j.setContentDescription(HardCodeUtil.qqStr(R.string.ufc));
        } else {
            this.f295470j.setContentDescription("");
        }
        com.tencent.mobileqq.troop.data.n nVar = this.f295472l;
        long j3 = nVar.f294932r;
        long j16 = nVar.f294918d;
        if (j3 > j16) {
            j3 = j16;
        }
        while (j16 > TTL.MAX_VALUE) {
            j16 >>= 1;
            j3 >>= 1;
        }
        this.f295470j.setProgress((int) ((j3 * 100.0d) / j16));
    }

    private void j(View view) {
        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0);
        view.dispatchTouchEvent(obtain);
        obtain.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(View view) {
        final com.tencent.mobileqq.troop.data.n l3 = l(view);
        if (l3 != null && !l3.B) {
            int i3 = l3.f294930p;
            if (l3.f294919e == 102) {
                return true;
            }
            if (((TroopManager) this.f295461a.app.getManager(QQManagerFactory.TROOP_MANAGER)).k(String.format("%d", Long.valueOf(this.f295462b))) == null) {
                TroopFileManager.F(this.f295461a.app, this.f295462b).Q(l3, 101);
            }
            if (!TroopFileUtils.a(this.f295461a.app, this.f295462b) && !this.f295461a.app.getCurrentAccountUin().equals(l3.i())) {
                return true;
            }
            if (i3 == 6 || i3 == 7 || i3 == 11) {
                BubblePopupWindow bubblePopupWindow = this.A;
                if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
                    j(view);
                    return false;
                }
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                aVar.c(new com.tencent.mobileqq.utils.dialogutils.b(R.id.f1039461z, this.f295477q.getResources().getString(R.string.f171425ew4)));
                this.A = s.c(view, aVar, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.data.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        j.this.B(l3, view2);
                    }
                });
                j(view);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(com.tencent.mobileqq.troop.data.n nVar) {
        if (this.J == null || TroopFileUtils.d(this.f295461a.app, this.f295477q, this.f295462b) == 0) {
            return;
        }
        this.J.W6(new ks2.a(this.f295477q.getResources().getString(R.string.epv), nVar.f294916b, nVar.f294917c, null, 1));
        ReportController.o(this.f295461a.app, "P_CliOper", "Grp_files", "", "file", "Clk_rename", 0, 0, this.f295462b + "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(com.tencent.mobileqq.troop.data.n nVar) {
        switch (nVar.f294930p) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.B.j(nVar);
                return;
            case 4:
            case 5:
            case 12:
            default:
                return;
            case 6:
            case 7:
            case 11:
            case 13:
                this.B.n(nVar);
                return;
            case 8:
            case 9:
            case 10:
                this.B.i(nVar);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.tencent.mobileqq.troop.data.n nVar) {
        com.tencent.mobileqq.troop.file.data.b bVar = this.J;
        if (bVar != null) {
            bVar.J1(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(com.tencent.mobileqq.troop.data.n nVar) {
        String str;
        if (TroopFileUtils.d(this.f295461a.app, this.f295477q, this.f295462b) == 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopFileItem", 2, "move");
        }
        Activity activity = this.f295477q;
        String l3 = Long.toString(this.f295462b);
        activity.startActivityForResult(MoveFileActivity.Z2(activity, l3, nVar.f294929o, nVar.f294916b, nVar.f294917c), 3);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
        QQAppInterface qQAppInterface = this.f295461a.app;
        String str2 = l3 + "";
        if ("/".equals(nVar.f294929o)) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_files", "", "file", "Clk_move", 0, 0, str2, str, "", "");
    }

    private void z() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.I = sparseIntArray;
        sparseIntArray.put(0, 1);
        this.I.put(1, 1);
        this.I.put(2, 3);
        this.I.put(3, 3);
        this.I.put(6, -1);
        this.I.put(8, 1);
        this.I.put(9, 2);
        this.I.put(10, 2);
        this.I.put(11, -1);
        this.I.put(7, -1);
    }

    protected void A() {
        this.C = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.data.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.this.p(view);
            }
        };
        this.D = new View.OnLongClickListener() { // from class: com.tencent.mobileqq.troop.file.data.f
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean q16;
                q16 = j.this.q(view);
                return q16;
            }
        };
        this.E = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.data.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.this.o(view);
            }
        };
        this.F = new ah.f() { // from class: com.tencent.mobileqq.troop.file.data.h
            @Override // com.tencent.mobileqq.filemanager.util.ah.f
            public final void onClick(View view) {
                j.this.r(view);
            }
        };
        this.f295463c.setOnClickListener(this.C);
        this.f295463c.setOnLongClickListener(this.D);
        this.f295470j.setOnClickListener(this.E);
        this.G = new a();
    }

    public void E(long j3, QQAppInterface qQAppInterface, boolean z16) {
        String format;
        G(j3, qQAppInterface, z16);
        ImageView imageView = this.f295465e;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        com.tencent.mobileqq.troop.data.n nVar = this.f295472l;
        String str = nVar.f294917c;
        if (!this.f295475o) {
            this.f295481u = nVar.e();
            this.f295480t = this.f295472l.g();
            this.f295479s = n();
            this.f295466f.setText(str);
            return;
        }
        this.f295466f.setText(str);
        if (this.f295472l.f294916b.contains("online_doc_folder_") && this.f295465e != null && this.f295477q.getResources().getString(R.string.bo7).equals(str)) {
            boolean m3 = m(String.valueOf(j3), qQAppInterface);
            this.f295478r = m3;
            if (m3) {
                this.f295465e.setVisibility(0);
            } else {
                this.f295465e.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(this.f295472l.f294916b) && this.f295472l.f294916b.contains("online_doc_folder_")) {
            this.f295467g.setText(this.f295477q.getString(R.string.i6d));
            return;
        }
        if (this.f295472l.D.size() > 0) {
            format = String.format(this.f295477q.getString(R.string.els), Integer.valueOf(this.f295472l.D.size()));
        } else {
            com.tencent.mobileqq.troop.data.n nVar2 = this.f295472l;
            if (nVar2.C < 0) {
                nVar2.C = 0;
            }
            format = String.format(this.f295477q.getString(R.string.eks), Integer.valueOf(this.f295472l.C));
        }
        String str2 = this.f295472l.F;
        this.f295467g.setText(str2 + this.f295477q.getString(R.string.b78) + format);
        if (this.f295476p) {
            this.f295480t = "";
        }
    }

    public void F() {
        com.tencent.mobileqq.troop.data.n nVar = this.f295472l;
        int i3 = nVar.f294930p;
        boolean z16 = true;
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 8 && i3 != 9) {
            z16 = false;
        }
        if (i3 != 11 && i3 != 6) {
            C(false);
        } else {
            C(com.tencent.mobileqq.filemanager.util.q.f(nVar.f294934t));
        }
        L(z16, this.I.get(this.f295472l.f294930p, -1));
    }

    public void G(long j3, QQAppInterface qQAppInterface, boolean z16) {
        com.tencent.mobileqq.troop.data.n nVar;
        TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, j3);
        if (!this.f295475o && (nVar = this.f295472l) != null) {
            if (!z16 && nVar.f294937w == null) {
                O.D(nVar.f294915a, 128);
            }
            if (FileUtils.fileExistsAndNotEmpty(this.f295472l.f294937w)) {
                FileManagerUtil.setFileIcon(this.f295464d, this.f295472l.f294937w, FileManagerUtil.getFileType(this.f295472l.f294917c));
            } else {
                this.f295464d.setDefaultImage(FileManagerUtil.getFileIconResId(this.f295472l.f294917c));
            }
            this.f295464d.setContentDescription(HardCodeUtil.qqStr(R.string.f172817ug3));
            return;
        }
        this.f295464d.setDefaultImage(R.drawable.filelook_floder);
        this.f295464d.setContentDescription(HardCodeUtil.qqStr(R.string.ues));
    }

    public void H(boolean z16) {
        this.f295485y = z16;
    }

    public void I(b bVar) {
        this.H = bVar;
    }

    public void J(boolean z16) {
        this.f295484x = z16;
    }

    public void K() {
        com.tencent.mobileqq.troop.data.n nVar = this.f295472l;
        if (nVar == null || nVar.B) {
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(nVar.f294937w)) {
            FileManagerUtil.setFileIcon(this.f295464d, this.f295472l.f294937w, FileManagerUtil.getFileType(this.f295472l.f294917c));
        } else {
            this.f295464d.setDefaultImage(FileManagerUtil.getFileIconResId(this.f295472l.f294917c));
        }
    }

    public void N(long j3, QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.troop.data.n nVar = this.f295472l;
        if (nVar == null || nVar.B || nVar.f294937w != null) {
            return;
        }
        TroopFileTransferManager.O(qQAppInterface, j3).D(this.f295472l.f294915a, 128);
    }

    public boolean m(String str, QQAppInterface qQAppInterface) {
        return ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).getGroupTIMFileNewsInfo(qQAppInterface.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_FILE_INNER_REDDOT_TIM, str, false);
    }

    protected String n() {
        com.tencent.mobileqq.troop.data.n nVar = this.f295472l;
        if (nVar == null) {
            return "";
        }
        return nVar.E;
    }

    private void t(View view, com.tencent.mobileqq.troop.data.n nVar) {
        String str;
        if (nVar == null) {
            QLog.e("TroopFile.TroopFileItem.", 1, "handleTroopFileFolderClicked. fileInfo == null!");
            return;
        }
        QLog.i("TroopFile.TroopFileItem.", 1, "handleTroopFileFolderClicked. id:" + nVar.f294916b);
        boolean z16 = false;
        if (!TextUtils.isEmpty(nVar.f294916b) && nVar.f294916b.contains("online_doc_folder_")) {
            ta1.b c16 = TenDocGroupListEntryConfigProcessor.c();
            if (c16 != null) {
                str = c16.a();
                z16 = c16.b();
            } else {
                str = null;
            }
            if (z16 && str != null && str.length() > 0) {
                String replace = str.replace("{groupcode}", this.f295462b + "");
                Intent intent = new Intent(this.f295477q.getApplicationContext(), (Class<?>) QQBrowserActivity.class);
                String tencentDocSourceAdtagStrUrl = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(replace, ITeamWorkUtils.TD_SOURCE_QQ_OCR_SAVE);
                intent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_OCR_SAVE);
                intent.putExtra("big_brother_source_key", "biz_src_jc_file");
                intent.putExtra("fragment_class", ((ITeamWorkDocsListFragment) QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
                this.f295477q.startActivity(intent.putExtra("url", tencentDocSourceAdtagStrUrl));
            } else {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).reportClickWithTroopType(this.f295461a.app, "0X8009936", String.valueOf(this.f295462b));
                Intent intent2 = new Intent(this.f295477q, (Class<?>) GroupTeamWorkListActivity.class);
                intent2.putExtra(t.f292400e, this.f295462b);
                this.f295477q.startActivity(intent2);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.k2a);
            if (imageView != null) {
                ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).removeGroupTIMFileNewsInfo(this.f295461a.app.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_FILE_INNER_REDDOT_TIM, String.valueOf(this.f295462b));
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        Intent intent3 = new Intent();
        intent3.putExtra(QZoneHelper.Constants.KEY_QUN_ID, this.f295462b + "");
        intent3.putExtra("folderPath", nVar.f294916b);
        intent3.putExtra("folderName", nVar.f294917c);
        intent3.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 2000);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(this.f295477q, intent3, 0);
    }

    protected void C(boolean z16) {
        if (z16) {
            this.f295468h.setVisibility(0);
        } else {
            this.f295468h.setVisibility(8);
        }
    }

    public void O(long j3, Context context, QQAppInterface qQAppInterface, boolean z16) {
        com.tencent.mobileqq.troop.data.n nVar = this.f295472l;
        if (nVar == null) {
            return;
        }
        this.f295479s = "";
        this.f295480t = "";
        this.f295481u = "";
        this.f295482v = "";
        this.f295483w = "";
        this.f295470j.setTag(nVar);
        this.f295467g.setTag(this.f295472l);
        context.getResources();
        this.f295475o = this.f295472l.B;
        E(j3, qQAppInterface, z16);
        F();
        com.tencent.mobileqq.troop.data.n nVar2 = this.f295472l;
        int i3 = nVar2.f294923i;
        String k3 = (i3 == 0 || nVar2.f294919e == 102) ? null : k(context, i3);
        if (!((com.tencent.mobileqq.troop.data.a.b(this.f295472l.f294930p) || this.f295476p) ? false : true)) {
            this.f295480t = "";
        }
        CheckBox checkBox = this.f295469i;
        if (checkBox != null) {
            if (this.f295484x) {
                this.f295470j.setVisibility(8);
                if (this.f295472l.B) {
                    this.f295469i.setVisibility(4);
                } else {
                    this.f295469i.setVisibility(0);
                    this.f295469i.setChecked(this.f295485y);
                }
            } else {
                checkBox.setVisibility(8);
            }
        }
        QFileUtils.n0(this.f295477q, this.f295467g, this.f295479s, this.f295480t, this.f295481u, k3, this.f295483w, true, this.F);
        M(qQAppInterface, context, j3, this.f295474n);
        this.f295463c.setPadding(0, 0, 0, 0);
    }

    private void D(View view, int i3) {
        if (view == null) {
            return;
        }
        if (view.getId() != R.id.f167026k21) {
            view = view.findViewById(R.id.f167026k21);
        }
        if (view instanceof CircleFileStateView) {
            ((CircleFileStateView) view).setState(i3);
        }
    }

    private String k(Context context, long j3) {
        long j16 = j3 * 1000;
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        if (j16 <= serverTime) {
            return context.getString(R.string.ekr);
        }
        return (((j16 - serverTime) / 86400000) + 1) + context.getString(R.string.f171380ek4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        com.tencent.mobileqq.troop.data.n l3 = l(view);
        if (l3 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("TRANS_PARAM_NT_MSGID", l3.G);
        bundle.putLong("TRANS_PARAM_NT_ELEMENTID", l3.H);
        bundle.putLong("TRANS_PARAM_UPLOAD_TIME", l3.f());
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f295461a.app, this.f295462b);
        switch (l3.f294930p) {
            case 0:
            case 1:
                O.D0(l3.f294915a);
                D(view, 3);
                return;
            case 2:
                this.B.z(l3.f294915a, null);
                return;
            case 3:
                this.B.y(l3);
                return;
            case 4:
            case 5:
            default:
                return;
            case 6:
            case 11:
                com.tencent.mobileqq.troop.data.t r16 = this.B.r(l3);
                int q16 = this.B.q(l3);
                QFileUtils.n(this.f295461a.app, this.f295477q, null, null, this.f295462b, r16, String.valueOf(l3.f294920f), l3.f294923i, q16, QFileUtils.X(q16, 4), null, false, false);
                return;
            case 7:
                this.B.C(l3.f294916b, l3.f294917c, l3.f294918d, l3.f294919e, bundle, null);
                D(view, 2);
                return;
            case 8:
                O.C0(l3.f294915a);
                D(view, 2);
                return;
            case 9:
                this.B.w(l3.f294915a, bundle, null);
                return;
            case 10:
                this.B.x(l3, bundle);
                D(view, 2);
                return;
            case 12:
                this.B.B(l3, this.f295477q.getString(R.string.evm), this.f295477q.getString(R.string.evn));
                D(view, 2);
                return;
            case 13:
                this.B.m(l3);
                D(view, 1);
                return;
        }
    }

    private void y(com.tencent.mobileqq.troop.data.n nVar, Context context) {
        if (nVar == null) {
            QLog.e("TroopFile.TroopFileItem.", 1, "handleTroopOnlineDocsClicked. fileInfo is null!");
            return;
        }
        QLog.i("TroopFile.TroopFileItem.", 1, "handleTroopOnlineDocsClicked. id:" + nVar.f294916b);
        com.tencent.mobileqq.troop.data.t r16 = this.B.r(nVar);
        int q16 = this.B.q(nVar);
        int X = QFileUtils.X(q16, 4);
        long j3 = nVar.f294923i;
        String valueOf = String.valueOf(nVar.f294920f);
        if (this.f295486z == 1) {
            QLog.d("TroopFile.TroopFileItem.", 1, "NTScanSpaceManager handleTroopOnlineDocsClicked mSource: " + this.f295486z);
            bb.r(this.f295461a.app, context, r16, q16, X, j3, valueOf, true, false, false, 0L, this.f295486z, nVar.f294927m);
            return;
        }
        bb.q(this.f295461a.app, context, r16, q16, X, j3, valueOf, true, false, false, 0L, nVar.f294927m);
    }

    protected com.tencent.mobileqq.troop.data.n l(View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.data.n) {
            return (com.tencent.mobileqq.troop.data.n) tag;
        }
        return null;
    }

    private void u(View view, com.tencent.mobileqq.troop.data.n nVar) {
        if (nVar == null) {
            QLog.e("TroopFile.TroopFileItem.", 1, "handleTroopFileItemClicked. fileInfo == null!");
            return;
        }
        QLog.i("TroopFile.TroopFileItem.", 1, "handleTroopFileItemClicked. id:" + nVar.f294916b + ", status:" + nVar.f294930p);
        switch (nVar.f294930p) {
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
                com.tencent.mobileqq.troop.data.t r16 = this.B.r(nVar);
                int q16 = this.B.q(nVar);
                int X = QFileUtils.X(q16, 4);
                Rect b06 = QFileUtils.b0(view.findViewById(R.id.f167030k25), nVar.f294917c);
                QLog.d("TroopFile.TroopFileItem.", 1, "NTScanSpaceManager handleTroopFileItemClicked mSource: " + this.f295486z);
                QFileUtils.s(this.f295461a.app, this.f295477q, null, null, this.f295462b, r16, String.valueOf(nVar.f294920f), (long) nVar.f294923i, q16, X, b06, false, false, false, true, this.f295486z);
                return;
            case 4:
            case 5:
            default:
                return;
            case 12:
                this.B.B(nVar, this.f295477q.getString(R.string.evm), this.f295477q.getString(R.string.evn));
                return;
            case 13:
                this.B.m(nVar);
                return;
        }
    }

    public void M(QQAppInterface qQAppInterface, Context context, long j3, SwipRightMenuBuilder.SwipItemBaseHolder swipItemBaseHolder) {
        com.tencent.mobileqq.troop.data.n nVar;
        if (this.f295473m == null || (nVar = this.f295472l) == null) {
            return;
        }
        boolean z16 = (nVar == null || TextUtils.isEmpty(nVar.f294916b) || !this.f295472l.f294916b.contains("online_doc_folder_")) ? false : true;
        boolean[] zArr = {false, false, false};
        com.tencent.mobileqq.troop.data.n nVar2 = this.f295472l;
        if (nVar2 != null && !this.f295484x && !z16) {
            zArr[0] = nVar2.b(qQAppInterface, j3, this.f295476p);
            zArr[1] = this.f295472l.c(qQAppInterface, j3);
            zArr[2] = this.f295472l.a(qQAppInterface, j3, false);
        }
        this.f295473m.c(context, this.f295471k, new Object[]{zArr, this.f295472l}, swipItemBaseHolder, this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(View view) {
        com.tencent.mobileqq.troop.data.n l3 = l(view.findViewById(R.id.f167026k21));
        if (l3 == null) {
            return;
        }
        d.e(view, l3);
        ReportController.o(this.f295461a.app, "P_CliOper", "Grp_files", "", "files_list", "Clk_blank", 0, 0, this.f295462b + "", "", "", "");
        if (this.f295484x) {
            if (!l3.B) {
                if (this.f295485y) {
                    b bVar = this.H;
                    if (bVar != null) {
                        bVar.B0(false, l3);
                    }
                } else {
                    b bVar2 = this.H;
                    if (bVar2 != null) {
                        bVar2.B0(true, l3);
                    }
                }
            }
        } else {
            Activity activity = this.f295477q;
            if (bb.o(this.f295461a.app, l3.f294930p, l3.B, this.f295462b, l3.f294917c, l3.f294918d, 4)) {
                y(l3, activity);
            } else if (!l3.B) {
                u(view, l3);
            } else {
                t(view, l3);
            }
        }
        ReportController.o(this.f295461a.app, "P_CliOper", "Grp_files", "", "oper", "Clk_item", 0, 0, this.f295462b + "", (1 ^ ("/".equals(l3.f294929o) ? 1 : 0)) + "", (l3.B ? 1 : 0) + "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        com.tencent.mobileqq.troop.data.n l3 = l((TextView) view.findViewById(R.id.f167028k23));
        if (l3 == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, this.f295462b + "");
        intent.putExtra("folderPath", "/");
        intent.putExtra("filter_uin", l3.f294920f);
        intent.putExtra("filter_member_name", l3.g());
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 4000);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(this.f295477q, intent, 0);
        ReportController.o(this.f295461a.app, "P_CliOper", "Grp_files", "", "oper", "Clk_uploader", 0, 0, this.f295462b + "", (!"/".equals(l3.f294929o) ? 1 : 0) + "", "", "");
    }
}
