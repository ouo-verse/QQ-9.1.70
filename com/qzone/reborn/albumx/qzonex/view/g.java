package com.qzone.reborn.albumx.qzonex.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import ba.d;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxCreateAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditAlbumEvent;
import com.qzone.util.ar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.AlbumAccessPermission;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.FamilyRole;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceCreateAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.PACreateAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PACreateAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import wa.QZAlbumxParentFamilyBean;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends ba.d implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: p0, reason: collision with root package name */
    private static final int f53451p0 = ar.e(728.0f);
    private final Activity L;
    private EditText M;
    private ImageView N;
    private d.C0114d P;
    private EditText Q;
    private d.C0114d R;
    private a S;
    private QZAlbumxCreateAlbumInitBean T;
    private boolean U;
    private LinearLayout V;
    private ImageView W;
    private TextView X;
    private ImageView Y;
    private RadioGroup Z;

    /* renamed from: a0, reason: collision with root package name */
    private i f53452a0;

    /* renamed from: b0, reason: collision with root package name */
    private aa f53453b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f53454c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f53455d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f53456e0;

    /* renamed from: f0, reason: collision with root package name */
    private final ArrayList<String> f53457f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f53458g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f53459h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f53460i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f53461j0;

    /* renamed from: k0, reason: collision with root package name */
    private RadioButton f53462k0;

    /* renamed from: l0, reason: collision with root package name */
    private RadioButton f53463l0;

    /* renamed from: m0, reason: collision with root package name */
    private RadioButton f53464m0;

    /* renamed from: n0, reason: collision with root package name */
    private RadioButton f53465n0;

    /* renamed from: o0, reason: collision with root package name */
    private RadioButton f53466o0;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(boolean z16, AlbumInfo albumInfo);
    }

    public g(Activity activity, QZAlbumxCreateAlbumInitBean qZAlbumxCreateAlbumInitBean) {
        super(activity);
        this.U = false;
        this.f53454c0 = 0;
        this.f53455d0 = 1;
        this.f53456e0 = com.qzone.reborn.albumx.qzonex.utils.c.f53402a.k(1);
        this.f53457f0 = new ArrayList<>();
        this.L = activity;
        this.T = qZAlbumxCreateAlbumInitBean;
    }

    private void B0() {
        VideoReport.setPageId(this.C, "pg_qz_album_create");
        VideoReport.setPageParams(this.C, new fo.a().d(R(), null));
    }

    private void D0() {
        int color = this.D.getResources().getColor(R.color.qui_button_text_secondary_default);
        this.f53462k0.setTextColor(color);
        this.f53463l0.setTextColor(color);
        this.f53464m0.setTextColor(color);
        this.f53465n0.setTextColor(color);
        this.f53466o0.setTextColor(color);
    }

    private void F0() {
        String d16;
        if (com.qzone.feed.utils.h.h(this.f53455d0) && !TextUtils.isEmpty(this.f53460i0)) {
            d16 = this.f53460i0;
        } else {
            d16 = com.qzone.feed.utils.h.d(this.f53455d0);
        }
        TextView textView = this.X;
        if (textView != null) {
            textView.setText(d16);
        }
        int i3 = this.f53456e0;
        if (i3 == 1) {
            this.Y.setImageResource(R.drawable.qui_group);
        } else if (i3 == 3) {
            this.Y.setImageResource(R.drawable.qui_lock);
        } else if (i3 != 4) {
            this.Y.setImageResource(R.drawable.qui_user);
        } else {
            this.Y.setImageResource(R.drawable.qui_qq);
        }
        if (this.f53456e0 == 1) {
            this.Y.getLayoutParams().width = ImmersiveUtils.dpToPx(18.0f);
            this.Y.getLayoutParams().height = ImmersiveUtils.dpToPx(18.0f);
        } else {
            this.Y.getLayoutParams().width = ImmersiveUtils.dpToPx(15.0f);
            this.Y.getLayoutParams().height = ImmersiveUtils.dpToPx(15.0f);
        }
        com.tencent.mobileqq.qzone.picload.c.a().m(this.Y, getContext().getResources().getColor(R.color.qui_common_icon_secondary));
    }

    private boolean m0() {
        if (TextUtils.isEmpty(this.M.getText().toString().trim())) {
            QQToast.makeText(getContext(), 1, com.qzone.util.l.a(R.string.f1345494), 0).show();
            return false;
        }
        if (this.f53454c0 == 11 && (this.f53452a0.getSelectedYear() == null || this.f53452a0.getSelectedMonth() == null || this.f53452a0.getSelectedDay() == null)) {
            QQToast.makeText(getContext(), 1, com.qzone.util.l.a(R.string.f1345393), 0).show();
            return false;
        }
        if (this.f53454c0 == 8) {
            if (this.f53453b0.getSelectedYear() != null && this.f53453b0.getSelectedMonth() != null && this.f53453b0.getSelectedDay() != null) {
                if (this.f53453b0.getSelectedFamilyBean() == null) {
                    QQToast.makeText(getContext(), 1, com.qzone.util.l.a(R.string.f1345292), 0).show();
                    return false;
                }
            } else {
                QQToast.makeText(getContext(), 1, com.qzone.util.l.a(R.string.f1345191), 0).show();
                return false;
            }
        }
        return true;
    }

    private void n0() {
        fo.c.o(this.F, "em_qz_create_album_button", new fo.b().h(new IDynamicParams() { // from class: com.qzone.reborn.albumx.qzonex.view.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map s06;
                s06 = g.this.s0(str);
                return s06;
            }
        }));
        fo.c.n(this.V, "em_qz_permission_set");
    }

    private void o0() {
        int ordinal;
        if (m0()) {
            String trim = this.M.getText().toString().trim();
            String trim2 = this.Q.getText().toString().trim();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            QLog.d("QZAlbumxCreateAlbumDialog", 1, "[handleCreateBtnClick]  albumName = " + trim + ", albumDesc = " + trim2 + ", createTime = " + currentTimeMillis);
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(getContext(), 1, com.qzone.util.l.a(R.string.f1338579), 0).show();
                QLog.d("QZAlbumxCreateAlbumDialog", 1, "[handleCreateBtnClick]  is not NetworkAvailable");
                return;
            }
            d0(getContext().getResources().getString(R.string.ghr));
            final PACreateAlbumReq pACreateAlbumReq = new PACreateAlbumReq();
            com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
            if (b16 == null) {
                return;
            }
            AlbumInfo albumInfo = pACreateAlbumReq.album;
            albumInfo.name = trim;
            albumInfo.desc = trim2;
            albumInfo.creator.uin = this.T.getUin();
            AlbumInfo albumInfo2 = pACreateAlbumReq.album;
            albumInfo2.qzAlbumType = this.f53454c0;
            albumInfo2.createTime = currentTimeMillis;
            AlbumAccessPermission albumAccessPermission = albumInfo2.permission;
            albumAccessPermission.permissionType = this.f53456e0;
            albumAccessPermission.question = this.f53458g0;
            albumAccessPermission.answer = this.f53459h0;
            Iterator<String> it = this.f53457f0.iterator();
            while (it.hasNext()) {
                String next = it.next();
                StUser stUser = new StUser();
                stUser.setUin(next);
                pACreateAlbumReq.album.permission.whiteList.add(stUser);
            }
            int i3 = this.f53454c0;
            if (i3 == 8) {
                QZAlbumxParentFamilyBean selectedFamilyBean = this.f53453b0.getSelectedFamilyBean();
                if (selectedFamilyBean != null) {
                    ordinal = selectedFamilyBean.getRoleId();
                } else {
                    ordinal = FamilyRole.KFAMILYROLENONE.ordinal();
                }
                pACreateAlbumReq.familyRole = ordinal;
                pACreateAlbumReq.album.familyAlbum.birthTime = String.format("%04d%02d%02d", this.f53453b0.getSelectedYear(), this.f53453b0.getSelectedMonth(), this.f53453b0.getSelectedDay());
            } else if (i3 == 11) {
                pACreateAlbumReq.album.loverAlbum.fallInLoveTime = String.format("%04d%02d%02d", this.f53452a0.getSelectedYear(), this.f53452a0.getSelectedMonth(), this.f53452a0.getSelectedDay());
            }
            final long currentTimeMillis2 = System.currentTimeMillis();
            b16.createAlbum(pACreateAlbumReq, new IPersonalAlbumServiceCreateAlbumCallback() { // from class: com.qzone.reborn.albumx.qzonex.view.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceCreateAlbumCallback
                public final void onCreateAlbum(PACreateAlbumRsp pACreateAlbumRsp) {
                    g.this.w0(currentTimeMillis2, pACreateAlbumReq, pACreateAlbumRsp);
                }
            });
        }
    }

    private void p0() {
        EditText editText = this.M;
        if (editText == null) {
            return;
        }
        editText.setText("");
    }

    private void q0() {
        if (com.qzone.reborn.util.e.b("QZAlbumxCreateAlbumDialog_handleOnClickAuthority", 500L)) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.view.a
            @Override // java.lang.Runnable
            public final void run() {
                g.this.y0();
            }
        });
    }

    private void r0() {
        this.M.setOnTouchListener(this);
        this.Q.setOnTouchListener(this);
        this.V.setOnClickListener(this);
        this.Z.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.qzone.reborn.albumx.qzonex.view.f
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i3) {
                g.this.z0(radioGroup, i3);
            }
        });
        this.Z.check(R.id.ndf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map s0(String str) {
        int i3;
        HashMap hashMap = new HashMap();
        int i16 = 2;
        switch (this.f53454c0) {
            case 8:
                i3 = 3;
                break;
            case 9:
                i3 = 5;
                break;
            case 10:
            default:
                i3 = 1;
                break;
            case 11:
                i3 = 4;
                break;
            case 12:
                i3 = 2;
                break;
        }
        hashMap.put("topic_type", Integer.valueOf(i3));
        int i17 = this.f53456e0;
        if (i17 == 1) {
            i16 = 1;
        } else if (i17 == 8) {
            i16 = 6;
        } else if (i17 == 3) {
            i16 = 4;
        } else if (i17 != 4) {
            i16 = i17 != 5 ? i17 != 6 ? 0 : 5 : 3;
        }
        hashMap.put(MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, Integer.valueOf(i16));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(PACreateAlbumRsp pACreateAlbumRsp, long j3, PACreateAlbumReq pACreateAlbumReq) {
        AlbumInfo albumInfo;
        String uin;
        P();
        boolean z16 = pACreateAlbumRsp.result == 0;
        QLog.i("QZAlbumxCreateAlbumDialog", 1, "handleCreateBtnClick  onCreateAlbum | seq=" + pACreateAlbumRsp.seq + " | result=" + pACreateAlbumRsp.result + " | errMs=" + pACreateAlbumRsp.errMs + " | traceId=" + pACreateAlbumRsp.traceId + " | albumId=" + pACreateAlbumRsp.album.albumId);
        mc.c.f416541a.e(QZoneOptAlbumRequest.FIELD_CMD_CREATE, System.currentTimeMillis() - j3, pACreateAlbumRsp.result);
        a aVar = this.S;
        if (aVar != null) {
            if (z16) {
                albumInfo = pACreateAlbumRsp.album;
            } else {
                albumInfo = pACreateAlbumReq.album;
            }
            aVar.a(z16, albumInfo);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            QZAlbumxCreateAlbumInitBean qZAlbumxCreateAlbumInitBean = this.T;
            if (qZAlbumxCreateAlbumInitBean == null) {
                uin = "";
            } else {
                uin = qZAlbumxCreateAlbumInitBean.getUin();
            }
            simpleEventBus.dispatchEvent(new QZAlbumxEditAlbumEvent(uin, null, null, xh.a.a(pACreateAlbumRsp.album)));
        }
        if (!z16 && !TextUtils.isEmpty(pACreateAlbumRsp.errMs)) {
            QQToast.makeText(getContext(), 1, pACreateAlbumRsp.errMs, 0).show();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(final long j3, final PACreateAlbumReq pACreateAlbumReq, final PACreateAlbumRsp pACreateAlbumRsp) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.view.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.u0(pACreateAlbumRsp, j3, pACreateAlbumReq);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Bundle bundle) {
        yo.d.k(this.L, yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, "https://h5.qzone.qq.com/ugc/setting?_wv=3&type={type}&uin={uin}&qua={qua}"), "{type}", "newphoto"), 2001, bundle, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0() {
        final Bundle bundle = new Bundle();
        bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.f53455d0);
        if (!bl.b(this.f53457f0) && TextUtils.isEmpty(this.f53461j0)) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<String> it = this.f53457f0.iterator();
            while (it.hasNext()) {
                String next = it.next();
                arrayList.add(String.valueOf(next));
                arrayList2.add(s8.f.f().g(String.valueOf(next)));
            }
            bundle.putStringArrayList("uin_list", arrayList);
            bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
        }
        if (this.f53455d0 == 9999) {
            bundle.putString(UgcSettingUtil.KEY_QUESTION, this.f53458g0);
            bundle.putString(UgcSettingUtil.KEY_ANSWER, this.f53459h0);
        }
        if (com.qzone.feed.utils.h.h(this.f53455d0) && !TextUtils.isEmpty(this.f53461j0)) {
            bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.f53461j0);
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.view.b
            @Override // java.lang.Runnable
            public final void run() {
                g.this.x0(bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(RadioGroup radioGroup, int i3) {
        EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
        this.f53452a0.m(false);
        this.f53453b0.y(false);
        D0();
        int color = this.D.getResources().getColor(R.color.qui_button_text_primary_default);
        switch (i3) {
            case R.id.ndc /* 1745225466 */:
                this.f53454c0 = 11;
                this.f53452a0.m(true);
                this.f53464m0.setTextColor(color);
                break;
            case R.id.ndd /* 1745225467 */:
                this.f53454c0 = 12;
                this.f53463l0.setTextColor(color);
                break;
            case R.id.nde /* 1745225468 */:
                this.f53454c0 = 8;
                this.f53453b0.y(true);
                this.f53465n0.setTextColor(color);
                break;
            case R.id.ndf /* 1745225469 */:
                this.f53454c0 = 0;
                this.f53462k0.setTextColor(color);
                break;
            case R.id.ndg /* 1745225470 */:
                this.f53454c0 = 9;
                this.f53466o0.setTextColor(color);
                break;
        }
        EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
    }

    public void E0(a aVar) {
        this.S = aVar;
    }

    @Override // ba.d
    protected int Q() {
        return R.layout.f1287043;
    }

    @Override // ba.d
    protected String R() {
        return "QZAlbumxCreateAlbumDialog";
    }

    @Override // ba.d
    protected int S() {
        return f53451p0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d
    public void Z(View view) {
        o0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d
    public void a0() {
        U(this.M);
        U(this.Q);
    }

    @Override // ba.d
    protected void b0() {
        if (this.U) {
            return;
        }
        c0(this.M);
        this.U = true;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.M.removeTextChangedListener(this.P);
        this.Q.removeTextChangedListener(this.R);
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() == R.id.kls) {
                p0();
            } else if (view.getId() == R.id.mdm) {
                q0();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        B0();
        this.E.setContentViewBackgroundResource(R.color.qui_common_bg_middle_light);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || view.getId() != R.id.f20578r) {
            return false;
        }
        c0(this.M);
        return false;
    }

    private void C0() {
        this.f53455d0 = 1;
        this.f53456e0 = com.qzone.reborn.albumx.qzonex.utils.c.f53402a.k(1);
        this.f53457f0.clear();
        this.f53458g0 = "";
        this.f53459h0 = "";
        this.f53461j0 = "";
    }

    @Override // ba.d
    protected void W(View view) {
        this.M = (EditText) view.findViewById(R.id.f20578r);
        ImageView imageView = (ImageView) view.findViewById(R.id.kls);
        this.N = imageView;
        imageView.setOnClickListener(this);
        d.C0114d c0114d = new d.C0114d(this.M, 15, getContext().getResources().getString(R.string.ghv));
        this.P = c0114d;
        this.M.addTextChangedListener(c0114d);
        EditText editText = (EditText) view.findViewById(R.id.f20568q);
        this.Q = editText;
        d.C0114d c0114d2 = new d.C0114d(editText, 50, getContext().getResources().getString(R.string.ghq));
        this.R = c0114d2;
        this.Q.addTextChangedListener(c0114d2);
        this.V = (LinearLayout) view.findViewById(R.id.mdm);
        this.W = (ImageView) view.findViewById(R.id.f162744ku3);
        this.X = (TextView) view.findViewById(R.id.f162950ni0);
        this.Y = (ImageView) view.findViewById(R.id.ku7);
        this.Z = (RadioGroup) view.findViewById(R.id.neh);
        this.f53452a0 = new i(view);
        this.f53453b0 = new aa(view);
        this.f53462k0 = (RadioButton) view.findViewById(R.id.ndf);
        this.f53463l0 = (RadioButton) view.findViewById(R.id.ndd);
        this.f53464m0 = (RadioButton) view.findViewById(R.id.ndc);
        this.f53465n0 = (RadioButton) view.findViewById(R.id.nde);
        this.f53466o0 = (RadioButton) view.findViewById(R.id.ndg);
        r0();
        F0();
        this.F.setText(com.qzone.util.l.a(R.string.f134448u));
        this.F.setEnabled(true);
        n0();
    }

    public void A0(int i3, int i16, Intent intent) {
        ArrayList<String> stringArrayList;
        if (i16 != -1 || i3 != 2001 || intent == null || intent.getExtras() == null) {
            return;
        }
        C0();
        Bundle extras = intent.getExtras();
        if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
            int i17 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
            this.f53455d0 = i17;
            this.f53456e0 = com.qzone.reborn.albumx.qzonex.utils.c.f53402a.k(Integer.valueOf(i17));
        }
        if (extras.containsKey("uin_list") && (stringArrayList = extras.getStringArrayList("uin_list")) != null) {
            this.f53457f0.addAll(stringArrayList);
        }
        if (extras.containsKey(UgcSettingUtil.KEY_QUESTION) && extras.containsKey(UgcSettingUtil.KEY_ANSWER)) {
            this.f53458g0 = extras.getString(UgcSettingUtil.KEY_QUESTION);
            this.f53459h0 = extras.getString(UgcSettingUtil.KEY_ANSWER);
        }
        if (com.qzone.feed.utils.h.h(this.f53455d0)) {
            this.f53460i0 = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
        }
        this.f53461j0 = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
        F0();
    }
}
