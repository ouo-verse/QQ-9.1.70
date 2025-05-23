package com.qzone.album.business.editalbum;

import NS_MOBILE_PHOTO.Album;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.qzone.album.business.albumlist.activity.QZonePersonalAlbumActivity;
import com.qzone.album.business.albumlist.viewmodel.QzoneNewAlbumViewModel;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PublicShareCacheData;
import com.qzone.album.data.model.SharingAlbumClientAttr;
import com.qzone.album.data.model.SharingOwnerUinAttr;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.album.ui.widget.AlbumGridView;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.lifecycle.utils.ViewModelProviders;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.qzone.widget.AlbumDesExtendEditText;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.ExtendLinearLayout;
import com.qzone.widget.ExtendScrollView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.c;
import photo_share_struct.client_attr;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneNewAlbumActivity extends QZoneTitleBarFragmentV2 {
    private TextView A0;
    private LinearLayout A1;
    private Button B0;
    private Button B1;
    private AsyncImageView C0;
    private ImageView C1;
    private LinearLayout D0;
    private LinearLayout D1;
    private Switch E0;
    private Switch E1;
    private BusinessAlbumInfo F0;
    private boolean F1;
    private jp.c G1;
    private boolean I1;
    private RelativeLayout J0;
    private int J1;
    private TextView K0;
    private boolean K1;
    private Button L0;
    private ArrayList<String> N0;
    private HashMap<String, LocalMediaInfo> O0;
    private int O1;
    private String S0;
    ActionSheet S1;
    private String T0;
    private RelativeLayout U0;
    private RelativeLayout V0;
    private RelativeLayout W0;
    private RelativeLayout X0;
    private RelativeLayout Y0;
    private ImageView Z0;

    /* renamed from: a1, reason: collision with root package name */
    private ImageView f42421a1;

    /* renamed from: b1, reason: collision with root package name */
    private ImageView f42422b1;

    /* renamed from: c1, reason: collision with root package name */
    private ImageView f42423c1;

    /* renamed from: d1, reason: collision with root package name */
    private ImageView f42424d1;

    /* renamed from: e1, reason: collision with root package name */
    private TextView f42425e1;

    /* renamed from: f1, reason: collision with root package name */
    private CellTextView f42426f1;

    /* renamed from: g1, reason: collision with root package name */
    private AlbumGridView f42427g1;

    /* renamed from: h1, reason: collision with root package name */
    private com.qzone.album.business.editalbum.a f42429h1;

    /* renamed from: i0, reason: collision with root package name */
    private QzoneNewAlbumViewModel f42430i0;

    /* renamed from: i1, reason: collision with root package name */
    private LinearLayout f42431i1;

    /* renamed from: j1, reason: collision with root package name */
    private Switch f42433j1;

    /* renamed from: k1, reason: collision with root package name */
    private Activity f42435k1;

    /* renamed from: l1, reason: collision with root package name */
    private View f42437l1;

    /* renamed from: m0, reason: collision with root package name */
    private int f42438m0;

    /* renamed from: m1, reason: collision with root package name */
    private View f42439m1;

    /* renamed from: n1, reason: collision with root package name */
    private View f42441n1;

    /* renamed from: o1, reason: collision with root package name */
    private View f42443o1;

    /* renamed from: p1, reason: collision with root package name */
    private View f42445p1;

    /* renamed from: q1, reason: collision with root package name */
    private View f42447q1;

    /* renamed from: r0, reason: collision with root package name */
    private ExtendLinearLayout f42448r0;

    /* renamed from: r1, reason: collision with root package name */
    private TextView f42449r1;

    /* renamed from: s0, reason: collision with root package name */
    private EditText f42450s0;

    /* renamed from: s1, reason: collision with root package name */
    private TextView f42451s1;

    /* renamed from: t0, reason: collision with root package name */
    private AlbumDesExtendEditText f42452t0;

    /* renamed from: t1, reason: collision with root package name */
    private TextView f42453t1;

    /* renamed from: u0, reason: collision with root package name */
    private TextView f42454u0;

    /* renamed from: u1, reason: collision with root package name */
    private TextView f42455u1;

    /* renamed from: v0, reason: collision with root package name */
    private TextView f42456v0;

    /* renamed from: v1, reason: collision with root package name */
    private TextView f42457v1;

    /* renamed from: w0, reason: collision with root package name */
    private ImageView f42458w0;

    /* renamed from: w1, reason: collision with root package name */
    private ExtendScrollView f42459w1;

    /* renamed from: x0, reason: collision with root package name */
    private LinearLayout f42460x0;

    /* renamed from: x1, reason: collision with root package name */
    private TextView f42461x1;

    /* renamed from: y0, reason: collision with root package name */
    private RelativeLayout f42462y0;

    /* renamed from: y1, reason: collision with root package name */
    private TextView f42463y1;

    /* renamed from: z0, reason: collision with root package name */
    private View f42464z0;

    /* renamed from: z1, reason: collision with root package name */
    private RelativeLayout f42465z1;

    /* renamed from: h0, reason: collision with root package name */
    private String f42428h0 = "[PhotoAlbum]QZoneNewAlbumActivity";

    /* renamed from: j0, reason: collision with root package name */
    private final int f42432j0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private final int f42434k0 = 1;

    /* renamed from: l0, reason: collision with root package name */
    private final int f42436l0 = 2;

    /* renamed from: n0, reason: collision with root package name */
    private final String f42440n0 = com.qzone.util.l.a(R.string.s0q);

    /* renamed from: o0, reason: collision with root package name */
    private final String f42442o0 = com.qzone.util.l.a(R.string.s0m);

    /* renamed from: p0, reason: collision with root package name */
    private final String f42444p0 = com.qzone.util.l.a(R.string.s0y);

    /* renamed from: q0, reason: collision with root package name */
    private final String f42446q0 = com.qzone.util.l.a(R.string.s0s);
    private Dialog G0 = null;
    private TextView H0 = null;
    private boolean I0 = true;
    private boolean M0 = false;
    private int P0 = 0;
    private String Q0 = QZonePersonalAlbumActivity.Q2();
    PictureItem R0 = null;
    private boolean H1 = false;
    private boolean L1 = false;
    private String M1 = null;
    private boolean N1 = false;
    private View.OnClickListener P1 = new b();
    private View.OnClickListener Q1 = new c();
    private AbsCompatRequest.a R1 = new h();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QZoneNewAlbumActivity.this.M0 || NetworkState.isWifiConn()) {
                QZoneNewAlbumActivity.this.Bj(false);
            } else {
                QZoneNewAlbumActivity.this.Yi();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneNewAlbumActivity.this.K1 = true;
            int id5 = view.getId();
            if (id5 == R.id.fze) {
                QZoneAlbumUtil.J(view);
                if (QZoneNewAlbumActivity.this.P0 == 0) {
                    LpReportInfo_pf00064.allReport(402, 16);
                }
                QZoneNewAlbumActivity.this.Dj();
            } else if (id5 == R.id.hdm) {
                if (QZoneNewAlbumActivity.this.f42458w0 != null) {
                    QZoneNewAlbumActivity.this.f42458w0.setVisibility(8);
                }
                if (QZoneNewAlbumActivity.this.P0 == 0 && QZoneNewAlbumActivity.this.f42458w0 != null) {
                    com.qzone.album.util.q.d("keyShareNewRedDot");
                }
                QZoneNewAlbumActivity.this.Rj(view.getId());
            } else if (id5 == R.id.hdi) {
                QZoneNewAlbumActivity.this.findViewById(R.id.hdv).setVisibility(8);
                QZoneNewAlbumActivity.this.Rj(view.getId());
            } else if (id5 == R.id.hds || id5 == R.id.hdp || id5 == R.id.hdw) {
                QZoneNewAlbumActivity.this.Rj(view.getId());
            } else if (id5 == R.id.hfl) {
                QZoneNewAlbumActivity.this.Mj();
            } else if (id5 == R.id.hfp) {
                QZoneNewAlbumActivity.this.Zi();
                if (QZoneNewAlbumActivity.this.P0 == 0 && QZoneNewAlbumActivity.this.f42456v0 != null) {
                    com.qzone.album.util.q.d("keyTypeNewRedDot");
                    QZoneNewAlbumActivity.this.f42456v0.setVisibility(8);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements c.InterfaceC10604c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f42482a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f42483b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f42484c;

        d(int i3, int i16, int i17) {
            this.f42482a = i3;
            this.f42483b = i16;
            this.f42484c = i17;
        }

        @Override // jp.c.InterfaceC10604c
        public void a(int i3, int i16, int i17) {
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(1, this.f42482a);
            calendar.set(2, this.f42483b);
            calendar.set(5, this.f42484c);
            if (jp.a.f(QZoneNewAlbumActivity.this.G1, i3, i16, i17) > calendar.getTimeInMillis()) {
                ToastUtil.s(String.format(com.qzone.util.l.a(R.string.s0n), Integer.valueOf(this.f42482a), Integer.valueOf(this.f42483b + 1), Integer.valueOf(this.f42484c)), 4);
                return;
            }
            int g16 = jp.a.g(QZoneNewAlbumActivity.this.G1, i3);
            if (g16 >= 1970) {
                QZoneNewAlbumActivity.this.H1 = true;
                QZoneNewAlbumActivity.this.G1.m();
                if (QZoneNewAlbumActivity.this.f42430i0.N1() != null) {
                    long longValue = Long.valueOf(QZoneAlbumUtil.i(g16, jp.a.e(QZoneNewAlbumActivity.this.G1, i16) + 1, jp.a.d(QZoneNewAlbumActivity.this.G1, i17))).longValue();
                    if (QZoneNewAlbumActivity.this.f42430i0.K == 8) {
                        QZoneNewAlbumActivity.this.f42430i0.N1().birthDateTime = longValue;
                        com.qzone.album.env.common.a.m().P(402, 7, "1", true, QZoneNewAlbumActivity.this.ej());
                    } else if (QZoneNewAlbumActivity.this.f42430i0.K == 11) {
                        QZoneNewAlbumActivity.this.f42430i0.N1().loveTime = longValue;
                        com.qzone.album.env.common.a.m().P(402, 10, "1", true, QZoneNewAlbumActivity.this.ej());
                    }
                    QZoneNewAlbumActivity.this.L0.setText(QZoneAlbumUtil.j(longValue));
                    return;
                }
                return;
            }
            ToastUtil.s("\u65f6\u95f4\u4e0d\u80fd\u65e9\u4e8e1970\u5e74", 4);
            QZoneNewAlbumActivity.this.G1.r(0, 1969);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements c.d {
        e() {
        }

        @Override // jp.c.d
        public void onDismiss() {
            if (QZoneNewAlbumActivity.this.H1 || QZoneNewAlbumActivity.this.f42430i0.N1() == null) {
                return;
            }
            if (QZoneNewAlbumActivity.this.f42430i0.K == 8) {
                com.qzone.album.env.common.a.m().P(402, 7, "2", true, QZoneNewAlbumActivity.this.ej());
            } else if (QZoneNewAlbumActivity.this.f42430i0.K == 11) {
                com.qzone.album.env.common.a.m().P(402, 10, "2", true, QZoneNewAlbumActivity.this.ej());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f42487a;

        f(boolean z16) {
            this.f42487a = z16;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            QZoneNewAlbumActivity.this.I0 = true;
            if (sVar.getSucceed()) {
                QZoneNewAlbumActivity.this.f42430i0.b2(QZoneNewAlbumActivity.this.f42430i0.N1());
                QZoneNewAlbumActivity qZoneNewAlbumActivity = QZoneNewAlbumActivity.this;
                qZoneNewAlbumActivity.toast(qZoneNewAlbumActivity.getString(R.string.f173039gn0), 5);
                Intent intent = new Intent();
                intent.putExtra("albumType", QZoneNewAlbumActivity.this.f42430i0.N1().albumtype);
                intent.putExtra("albumId", QZoneNewAlbumActivity.this.ej());
                intent.putExtra(AEEditorConstants.ALBUMNAME, QZoneNewAlbumActivity.this.f42430i0.N1().albumname);
                intent.putExtra("albumRight", QZoneNewAlbumActivity.this.f42430i0.N1().albumrights);
                QZoneNewAlbumActivity.this.setResult(-1, intent);
                if (this.f42487a) {
                    return;
                }
                QZoneNewAlbumActivity.this.finish();
                return;
            }
            if (!TextUtils.isEmpty(sVar.getMessage())) {
                QZoneNewAlbumActivity.this.toast(sVar.getMessage(), 4);
            } else {
                QZoneNewAlbumActivity.this.toast(R.string.gmz, 4);
            }
            QZoneNewAlbumActivity.this.aj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements AbsCompatRequest.a {
        g() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            if (sVar.getSucceed()) {
                QZoneNewAlbumActivity.this.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastInviteSend", "\u9080\u8bf7\u4fe1\u606f\u5df2\u53d1\u9001"), 5);
            } else if (!TextUtils.isEmpty(sVar.getMessage())) {
                QZoneNewAlbumActivity.this.toast(sVar.getMessage(), 4);
            } else {
                QZoneNewAlbumActivity.this.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFailAndRetry", "\u64cd\u4f5c\u5931\u8d25\u8bf7\u91cd\u8bd5"), 4);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements AbsCompatRequest.a {
        h() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
            QZoneNewAlbumActivity.this.aj();
            if (sVar.getSucceed()) {
                Intent intent = new Intent();
                if ((sVar.getData() instanceof QZoneOptAlbumRequest.a) && QZoneNewAlbumActivity.this.f42430i0.N1() != null) {
                    QZoneOptAlbumRequest.a aVar = (QZoneOptAlbumRequest.a) sVar.getData();
                    QZoneNewAlbumActivity.this.f42430i0.L = aVar.f43958a;
                    QZoneNewAlbumActivity qZoneNewAlbumActivity = QZoneNewAlbumActivity.this;
                    qZoneNewAlbumActivity.F0 = BusinessAlbumInfo.create(qZoneNewAlbumActivity.f42430i0.L);
                    QZoneNewAlbumActivity.this.F0.mTotal = 0;
                    QZoneNewAlbumActivity.this.F0.mUin = LoginData.getInstance().getUin();
                    QZoneNewAlbumActivity.this.F0.mPrivacy = QZoneNewAlbumActivity.this.f42430i0.N1().albumrights;
                    QZoneNewAlbumActivity.this.F0.mTitle = QZoneNewAlbumActivity.this.f42430i0.N1().albumname;
                    QZoneNewAlbumActivity.this.F0.mAlbumType = QZoneNewAlbumActivity.this.f42430i0.N1().albumtype;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO, QZoneNewAlbumActivity.this.F0);
                    intent.putExtras(bundle);
                    if (QZoneNewAlbumActivity.this.M0) {
                        QZoneNewAlbumActivity.this.fk();
                    }
                }
                if (QZoneNewAlbumActivity.this.M0) {
                    return;
                }
                QZoneNewAlbumActivity.this.setResult(-1, intent);
                QZoneNewAlbumActivity.this.finish();
                return;
            }
            if (!TextUtils.isEmpty(sVar.getMessage())) {
                QZoneNewAlbumActivity.this.toast(sVar.getMessage(), 4);
            } else {
                QZoneNewAlbumActivity qZoneNewAlbumActivity2 = QZoneNewAlbumActivity.this;
                qZoneNewAlbumActivity2.toast(qZoneNewAlbumActivity2.getString(R.string.ghs), 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneNewAlbumActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneNewAlbumActivity.this.cj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements ActionSheet.OnButtonClickListener {
        l() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QZoneNewAlbumActivity.this.simpleClassname + "   QQCustomDialog  which:0");
            QZoneNewAlbumActivity.this.Bj(false);
            QZoneNewAlbumActivity.this.S1.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class m implements ActionSheet.OnDismissListener {
        m() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity] QZoneUploadPhotoActivity   QQCustomDialog  whichButton:1");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class n implements Observer<PublicShareCacheData> {
        n() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(PublicShareCacheData publicShareCacheData) {
            QZLog.d(QZoneNewAlbumActivity.this.f42428h0, 1, "PublicShareCacheDataLiveData onChanged...");
            QZoneNewAlbumActivity.this.f42430i0.a2(publicShareCacheData);
            QZoneNewAlbumActivity.this.f42429h1.u(publicShareCacheData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class o implements Observer<Integer> {
        o() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            QZLog.d(QZoneNewAlbumActivity.this.f42428h0, 1, "type onChanged... type:", num);
            int intValue = num.intValue();
            if (intValue != 9) {
                if (intValue == 10 && QZoneNewAlbumActivity.this.I1 && QZoneNewAlbumActivity.this.J1 != -1) {
                    QZoneNewAlbumActivity qZoneNewAlbumActivity = QZoneNewAlbumActivity.this;
                    qZoneNewAlbumActivity.Rj(qZoneNewAlbumActivity.jj(qZoneNewAlbumActivity.J1));
                    return;
                }
                return;
            }
            QZoneNewAlbumActivity.this.toast(R.string.gos, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class p implements ExtendLinearLayout.a {
        p() {
        }

        @Override // com.qzone.widget.ExtendLinearLayout.a
        public boolean onDown(MotionEvent motionEvent) {
            if (QZoneNewAlbumActivity.this.xj(motionEvent)) {
                return false;
            }
            QZoneNewAlbumActivity.this.qj();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneNewAlbumActivity.this.bj();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class r implements TextCellLayout.OnCellClickListener {
        r() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            if (TextUtils.isEmpty(textCell.getUrl())) {
                return;
            }
            yo.d.d(textCell.getUrl(), QZoneNewAlbumActivity.this.getActivity(), null);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class s implements CompoundButton.OnCheckedChangeListener {
        s() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            LpReportInfo_pf00064.allReport(402, 19, z16 ? 1 : 2);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneNewAlbumActivity.this.Bj(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Aj() {
        EditText editText = this.f42450s0;
        if (editText != null) {
            ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
            layoutParams.height = ViewUtils.dip2px(74.5f);
            this.f42450s0.setLayoutParams(layoutParams);
            this.f42450s0.setTextSize(0, getResources().getDimension(R.dimen.aon));
            this.f42450s0.setHintTextColor(getResources().getColor(R.color.a8n));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj(boolean z16) {
        if (!checkNetworkConnect()) {
            showNoNetworkTips();
            return;
        }
        if (this.I0) {
            if (this.f42430i0.N1() == null) {
                if (z16) {
                    return;
                }
                finish();
                return;
            }
            if (QZoneAlbumUtil.r(this.f42430i0.N1().albumtype) != 1) {
                this.O1 = 0;
            }
            AlbumCacheData N1 = this.f42430i0.N1();
            QzoneNewAlbumViewModel qzoneNewAlbumViewModel = this.f42430i0;
            N1.albumtype = qzoneNewAlbumViewModel.K;
            if (qzoneNewAlbumViewModel.N1().albumtype == 8 && this.f42430i0.N1().birthDateTime == 0) {
                toast(R.string.ghx);
                return;
            }
            if (this.f42430i0.N1().albumtype == 11 && this.f42430i0.N1().loveTime == 0) {
                toast(R.string.ghu);
                return;
            }
            if (!this.f42450s0.getText().toString().equals(this.f42430i0.N1().albumname) || !this.f42452t0.getText().toString().equals(this.f42430i0.N1().albumdesc) || this.f42430i0.N1().isToppedAlbum != this.E0.isChecked()) {
                this.K1 = true;
            }
            if (this.f42430i0.N1().allowAutoJoinShareAlbum != this.f42433j1.isChecked()) {
                this.f42430i0.N1().allowAutoJoinShareAlbum = this.f42433j1.isChecked();
                this.K1 = true;
            }
            if (this.f42430i0.N1() != null && this.E1 != null && this.f42430i0.N1().needShowFamilySync() && this.E1.isChecked() != this.f42430i0.N1().isFamilySyncOn()) {
                this.K1 = true;
            }
            this.f42430i0.N1().albumname = this.f42450s0.getText().toString();
            this.f42430i0.N1().albumdesc = this.f42452t0.getText().toString();
            if (this.f42430i0.N1().albumrights == 5) {
                if (TextUtils.isEmpty(this.f42430i0.N1().albumquestion) || TextUtils.isEmpty(this.f42430i0.N1().albumanswer)) {
                    toast(R.string.ght);
                    return;
                }
            } else {
                this.f42430i0.N1().albumquestion = "";
                this.f42430i0.N1().albumanswer = "";
            }
            this.f42430i0.N1().individual = this.O1 != 0 ? 1L : 0L;
            yj();
            if (this.P0 == 0 && (TextUtils.isEmpty(this.f42430i0.N1().albumname) || TextUtils.isEmpty(this.f42430i0.N1().albumname.trim()))) {
                String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(System.currentTimeMillis()));
                if (!TextUtils.isEmpty(format)) {
                    this.f42430i0.N1().albumname = format.replaceAll("-", ".");
                }
            }
            if (!TextUtils.isEmpty(this.Q0)) {
                this.Q0 += ".getApplist.createalbum";
            }
            if (this.K1 || this.P0 != 1) {
                Ej(z16);
            } else {
                if (z16) {
                    return;
                }
                Oj(getString(R.string.ge_));
                this.I0 = false;
                runOnUiThread(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.19
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneNewAlbumActivity.this.finish();
                    }
                }, 500L);
            }
        }
    }

    private void Cj(AlbumCacheData albumCacheData) {
        if (albumCacheData.albumtype == 8 && albumCacheData.birthDateTime == 0) {
            long j3 = this.f42430i0.N1().birthDateTime;
            albumCacheData.birthDateTime = j3;
            if (j3 == 0) {
                toast(R.string.ghx);
                return;
            }
        }
        if (albumCacheData.albumtype == 11 && albumCacheData.loveTime == 0) {
            long j16 = this.f42430i0.N1().loveTime;
            albumCacheData.loveTime = j16;
            if (j16 == 0) {
                toast(R.string.ghu);
                return;
            }
        }
        com.qzone.album.base.Service.a.W().F(albumCacheData.createAlbumRequestModel(1, albumCacheData, -1), "", "", "", (byte) 0, new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj() {
        if (this.f42430i0.N1() == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.16
            @Override // java.lang.Runnable
            public void run() {
                final Bundle bundle = new Bundle();
                bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, QZoneNewAlbumActivity.this.f42430i0.J);
                if (QZoneNewAlbumActivity.this.f42430i0.N1().album_white_list != null && QZoneNewAlbumActivity.this.f42430i0.N1().album_white_list.size() > 0 && TextUtils.isEmpty(QZoneNewAlbumActivity.this.T0)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList<String> arrayList2 = new ArrayList<>(arrayList.size());
                    Iterator<Long> it = QZoneNewAlbumActivity.this.f42430i0.N1().album_white_list.iterator();
                    while (it.hasNext()) {
                        Long next = it.next();
                        arrayList.add(String.valueOf(next));
                        arrayList2.add(s8.f.f().g(String.valueOf(next)));
                    }
                    bundle.putStringArrayList("uin_list", arrayList);
                    bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
                }
                if (QZoneNewAlbumActivity.this.P0 == 1 && QZoneNewAlbumActivity.this.f42430i0.J == 9999) {
                    bundle.putString(UgcSettingUtil.KEY_QUESTION, QZoneNewAlbumActivity.this.f42430i0.N1().albumquestion);
                    bundle.putString(UgcSettingUtil.KEY_ANSWER, QZoneNewAlbumActivity.this.f42430i0.N1().albumanswer);
                }
                if (com.qzone.feed.utils.h.h(QZoneNewAlbumActivity.this.f42430i0.J) && !TextUtils.isEmpty(QZoneNewAlbumActivity.this.T0)) {
                    bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, QZoneNewAlbumActivity.this.T0);
                }
                QZoneNewAlbumActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, "https://h5.qzone.qq.com/ugc/setting?_wv=3&type={type}&uin={uin}&qua={qua}");
                        if (QZoneNewAlbumActivity.this.P0 == 0) {
                            str = "newphoto";
                        } else {
                            str = "editphoto";
                        }
                        String j3 = yo.f.j(config, "{type}", str);
                        if (QZoneNewAlbumActivity.this.f42430i0.N1() != null && QZoneNewAlbumActivity.this.f42430i0.N1().isSharingAlbumOnUI()) {
                            j3 = j3 + "&tip=shareAlbum";
                        }
                        yo.d.k(QZoneNewAlbumActivity.this.getActivity(), j3, 5, bundle, null, null);
                    }
                });
            }
        });
    }

    private void Fj(int i3) {
        this.f42425e1.setVisibility(i3);
        this.f42427g1.setVisibility(i3);
    }

    private void Gj(int i3) {
        this.f42449r1.setTextColor(getResources().getColor(R.color.f156678m));
        this.f42451s1.setTextColor(getResources().getColor(R.color.f156678m));
        this.f42453t1.setTextColor(getResources().getColor(R.color.f156678m));
        this.f42455u1.setTextColor(getResources().getColor(R.color.f156678m));
        this.f42457v1.setTextColor(getResources().getColor(R.color.f156678m));
        kj(i3).setTextColor(getResources().getColor(R.color.a6b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hj(AlbumCacheData albumCacheData) {
        if (albumCacheData.sharingAlbumClientAttrArrayList == null) {
            albumCacheData.sharingAlbumClientAttrArrayList = new ArrayList<>();
        }
        switch (this.f42430i0.K) {
            case 8:
                Ti(albumCacheData);
                return;
            case 9:
            case 11:
            case 12:
                if (albumCacheData.sharingAlbumClientAttrArrayList.size() == 0) {
                    Ui(albumCacheData);
                    return;
                } else {
                    Sj(albumCacheData);
                    return;
                }
            case 10:
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ij(AlbumCacheData albumCacheData) {
        QZLog.d(this.f42428h0, 1, "setupSharingOwnersForNewAlbum... mQzoneNewAlbumViewModel.tempAlbumType:", Integer.valueOf(this.f42430i0.K));
        if (albumCacheData.sharingAlbumClientAttrArrayList == null) {
            albumCacheData.sharingAlbumClientAttrArrayList = new ArrayList<>();
        }
        int i3 = this.f42430i0.K;
        albumCacheData.albumtype = i3;
        switch (i3) {
            case 8:
                Ti(albumCacheData);
                return;
            case 9:
            case 11:
            case 12:
                if (albumCacheData.sharingAlbumClientAttrArrayList.size() == 0 && !this.M0) {
                    Ui(albumCacheData);
                    return;
                } else {
                    Sj(albumCacheData);
                    return;
                }
            case 10:
            default:
                Sj(albumCacheData);
                return;
        }
    }

    private void Jj() {
        ImageView imageView;
        this.A1.setVisibility(0);
        this.C1.setImageResource(R.drawable.g_v);
        if (this.P0 == 0 && com.qzone.album.util.q.c("keyShareNewRedDot") && (imageView = this.f42458w0) != null) {
            imageView.setVisibility(0);
        }
    }

    private void Kj(int i3, boolean z16) {
        if (this.f42430i0.N1() == null) {
            return;
        }
        Tj(i3);
        switch (i3) {
            case 8:
                this.f42437l1.setVisibility(4);
                this.f42439m1.setVisibility(4);
                this.f42447q1.setVisibility(0);
                this.f42441n1.setVisibility(0);
                this.f42443o1.setVisibility(4);
                this.f42445p1.setVisibility(4);
                Uj(8);
                this.Z0.setSelected(false);
                this.f42422b1.setSelected(true);
                this.f42423c1.setSelected(false);
                this.f42424d1.setSelected(false);
                this.f42421a1.setSelected(false);
                this.U0.setSelected(false);
                this.W0.setSelected(true);
                this.V0.setSelected(false);
                this.X0.setSelected(false);
                this.Y0.setSelected(false);
                return;
            case 9:
                this.f42437l1.setVisibility(4);
                this.f42439m1.setVisibility(4);
                this.f42441n1.setVisibility(4);
                this.f42443o1.setVisibility(0);
                this.f42445p1.setVisibility(4);
                this.f42447q1.setVisibility(0);
                this.J0.setVisibility(8);
                this.Z0.setSelected(false);
                this.f42422b1.setSelected(false);
                this.f42423c1.setSelected(true);
                this.f42424d1.setSelected(false);
                this.f42421a1.setSelected(false);
                this.U0.setSelected(false);
                this.W0.setSelected(false);
                this.V0.setSelected(true);
                this.X0.setSelected(false);
                this.Y0.setSelected(false);
                return;
            case 10:
            default:
                this.f42437l1.setVisibility(0);
                this.f42439m1.setVisibility(4);
                this.f42441n1.setVisibility(4);
                this.f42443o1.setVisibility(4);
                this.f42445p1.setVisibility(4);
                this.f42447q1.setVisibility(0);
                this.J0.setVisibility(8);
                this.Z0.setSelected(true);
                this.f42422b1.setSelected(false);
                this.f42423c1.setSelected(false);
                this.f42424d1.setSelected(false);
                this.f42421a1.setSelected(false);
                this.U0.setSelected(true);
                this.W0.setSelected(false);
                this.V0.setSelected(false);
                this.X0.setSelected(false);
                this.Y0.setSelected(false);
                return;
            case 11:
                this.f42437l1.setVisibility(4);
                this.f42439m1.setVisibility(4);
                this.f42441n1.setVisibility(4);
                this.f42443o1.setVisibility(4);
                this.f42445p1.setVisibility(0);
                this.f42447q1.setVisibility(0);
                Uj(11);
                this.Z0.setSelected(false);
                this.f42422b1.setSelected(false);
                this.f42423c1.setSelected(false);
                this.f42424d1.setSelected(true);
                this.f42421a1.setSelected(false);
                this.U0.setSelected(false);
                this.W0.setSelected(false);
                this.V0.setSelected(false);
                this.X0.setSelected(true);
                this.Y0.setSelected(false);
                return;
            case 12:
                this.f42437l1.setVisibility(4);
                this.f42439m1.setVisibility(0);
                this.f42441n1.setVisibility(4);
                this.f42443o1.setVisibility(4);
                this.f42445p1.setVisibility(4);
                this.f42447q1.setVisibility(0);
                this.J0.setVisibility(8);
                this.Z0.setSelected(false);
                this.f42422b1.setSelected(false);
                this.f42423c1.setSelected(false);
                this.f42424d1.setSelected(false);
                this.f42421a1.setSelected(true);
                this.U0.setSelected(false);
                this.W0.setSelected(false);
                this.V0.setSelected(false);
                this.X0.setSelected(false);
                this.Y0.setSelected(true);
                return;
        }
    }

    private void Nj(String str) {
        ActionSheet actionSheet = this.S1;
        if (actionSheet == null) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancel", "\u53d6\u6d88");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "\u7acb\u5373\u521b\u5efa\u5e76\u4e0a\u4f20", "\u7acb\u5373\u521b\u5efa\u5e76\u4e0a\u4f20");
            ActionSheet create = ActionSheet.create(getActivity());
            this.S1 = create;
            create.setMainTitle(str);
            this.S1.addButton(config2, 0);
            this.S1.addCancelButton(config);
            this.S1.setOnButtonClickListener(new l());
            this.S1.setOnDismissListener(new m());
            this.S1.show();
            return;
        }
        if (actionSheet.isShowing()) {
            return;
        }
        this.S1.show();
    }

    private void Oj(String str) {
        Dialog dialog = this.G0;
        if (dialog == null || !dialog.isShowing()) {
            if (this.G0 == null) {
                ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
                this.G0 = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.H0 = (TextView) this.G0.findViewById(R.id.dialogText);
                this.G0.findViewById(R.id.kja).setVisibility(8);
                this.G0.findViewById(R.id.cib).setVisibility(0);
            }
            this.H0.setText(str);
            this.G0.show();
        }
    }

    private void Qj() {
        this.f42430i0.O1().observe(this, new Observer<AlbumCacheData>() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(final AlbumCacheData albumCacheData) {
                QZLog.d(QZoneNewAlbumActivity.this.f42428h0, 1, "AlbumCacheDataLiveData onChanged...");
                QZoneNewAlbumActivity.this.f42430i0.Z1(albumCacheData);
                QZoneNewAlbumActivity.this.f42430i0.M1(QZoneNewAlbumActivity.this.getIntent());
                if (albumCacheData != null && albumCacheData.isSharingAlbumPartner()) {
                    QZoneNewAlbumActivity.this.f42461x1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoMyPermision", "\u6211\u7684\u6743\u9650"));
                }
                QZoneNewAlbumActivity.this.Xj();
                QZoneNewAlbumActivity.this.Wi(albumCacheData);
                if (!QZoneNewAlbumActivity.this.N1 && QZoneNewAlbumActivity.this.getIntent().getBooleanExtra("editAlbumNeedSelectLover", false) && albumCacheData != null && albumCacheData.isLoveAlbum()) {
                    QZoneNewAlbumActivity.this.N1 = true;
                    QZoneNewAlbumActivity.this.f42459w1.postDelayed(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumCacheData albumCacheData2 = albumCacheData;
                            if (albumCacheData2 == null || !albumCacheData2.isLoveAlbum()) {
                                return;
                            }
                            com.qzone.album.env.common.a.m().z(QZoneNewAlbumActivity.this.getActivity(), -1, 14);
                        }
                    }, 400L);
                }
                QZoneNewAlbumActivity.this.dk(albumCacheData);
            }
        });
        this.f42430i0.R1().observe(this, new n());
        this.f42430i0.T1().observe(this, new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rj(int i3) {
        QZLog.d(this.f42428h0, 1, "themeSelectProcess... id:", Integer.valueOf(i3));
        if (this.f42430i0.N1() == null) {
            QZLog.w(this.f42428h0, 1, "themeSelectProcess... albumcachedata == null");
            return;
        }
        if (i3 == R.id.hds) {
            if (this.f42430i0.K != 8) {
                if (tj(8)) {
                    return;
                }
                this.f42430i0.K = 8;
                if (QZLog.isDevelopLevel()) {
                    QZLog.d(this.f42428h0, 4, "current birthTime=" + this.f42430i0.N1().birthDateTime);
                }
                com.qzone.album.env.common.a.m().P(402, 3, "2", true, ej());
            }
        } else if (i3 == R.id.hdp) {
            if (this.f42430i0.K != 1) {
                if (tj(1)) {
                    return;
                }
                this.f42430i0.K = 1;
                com.qzone.album.env.common.a.m().P(402, 3, "1", true, ej());
            }
        } else if (i3 == R.id.hdw) {
            if (this.f42430i0.K != 9) {
                if (tj(9)) {
                    return;
                }
                this.f42430i0.K = 9;
                com.qzone.album.env.common.a.m().P(402, 3, "3", true, ej());
            }
        } else if (i3 == R.id.hdi) {
            if (this.f42430i0.K != 11) {
                if (tj(11)) {
                    return;
                }
                if (this.f42430i0.N1().albumtype == 12 && this.f42430i0.N1().sharingAlbumClientAttrArrayList != null && this.f42430i0.N1().sharingAlbumClientAttrArrayList.size() == 2) {
                    this.f42430i0.K = 11;
                } else {
                    this.f42430i0.K = 11;
                    com.qzone.album.env.common.a.m().P(402, 3, "4", true, ej());
                }
            }
        } else if (i3 == R.id.hdm && this.f42430i0.K != 12) {
            if (tj(12)) {
                return;
            }
            this.f42430i0.K = 12;
            com.qzone.album.env.common.a.m().P(402, 3, "5", true, ej());
        }
        Kj(this.f42430i0.K, true);
        Yj(this.f42430i0.K);
        if (this.P0 == 1 && this.f42430i0.N1().getAlbumThemeTypeValue() != 1) {
            Zj(this.f42430i0.N1());
        } else {
            Fj(8);
        }
    }

    private void Sj(AlbumCacheData albumCacheData) {
        QZLog.d(this.f42428h0, 1, "trimFakeSharingOwnerData...");
        int i3 = 0;
        this.L1 = false;
        if (albumCacheData.sharingAlbumClientAttrArrayList != null) {
            while (i3 < albumCacheData.sharingAlbumClientAttrArrayList.size()) {
                SharingAlbumClientAttr sharingAlbumClientAttr = albumCacheData.sharingAlbumClientAttrArrayList.get(i3);
                long j3 = sharingAlbumClientAttr.uin;
                if (j3 == 0) {
                    albumCacheData.sharingAlbumClientAttrArrayList.remove(sharingAlbumClientAttr);
                } else {
                    if (j3 == com.qzone.album.env.common.a.m().s()) {
                        albumCacheData.sharingAlbumClientAttrArrayList.get(i3).qq_nick = com.qzone.album.env.common.a.m().x(com.qzone.album.env.common.a.m().s());
                    } else if (this.P0 == 0) {
                        String str = albumCacheData.sharingAlbumClientAttrArrayList.get(i3).uinAttr.nick;
                        if (this.f42440n0.equals(str) || this.f42442o0.equals(str) || this.f42444p0.equals(str) || this.f42446q0.equals(str)) {
                            albumCacheData.sharingAlbumClientAttrArrayList.get(i3).uinAttr.nick = "";
                        }
                    }
                    i3++;
                }
            }
        }
    }

    private void Ti(AlbumCacheData albumCacheData) {
        SharingOwnerUinAttr sharingOwnerUinAttr;
        if (albumCacheData.sharingAlbumClientAttrArrayList.size() <= 1) {
            if (albumCacheData.sharingAlbumClientAttrArrayList.size() == 0) {
                sharingOwnerUinAttr = new SharingOwnerUinAttr();
                albumCacheData.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(com.qzone.album.env.common.a.m().s(), sharingOwnerUinAttr, null, 4));
            } else {
                sharingOwnerUinAttr = albumCacheData.sharingAlbumClientAttrArrayList.get(0).uinAttr;
            }
            int w3 = com.qzone.album.env.common.a.m().w(com.qzone.album.env.common.a.m().s());
            if (w3 == 1) {
                sharingOwnerUinAttr.nick = com.qzone.util.l.a(R.string.s0l);
            } else {
                sharingOwnerUinAttr.nick = com.qzone.util.l.a(R.string.s0r);
            }
            SharingOwnerUinAttr sharingOwnerUinAttr2 = new SharingOwnerUinAttr();
            if (w3 == 1) {
                sharingOwnerUinAttr2.nick = com.qzone.util.l.a(R.string.s0u);
            } else {
                sharingOwnerUinAttr2.nick = com.qzone.util.l.a(R.string.s0t);
            }
            albumCacheData.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(0L, sharingOwnerUinAttr2, null, 4));
            SharingOwnerUinAttr sharingOwnerUinAttr3 = new SharingOwnerUinAttr();
            sharingOwnerUinAttr3.nick = com.qzone.util.l.a(R.string.s0z);
            albumCacheData.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(0L, sharingOwnerUinAttr3, null, 4));
            SharingOwnerUinAttr sharingOwnerUinAttr4 = new SharingOwnerUinAttr();
            sharingOwnerUinAttr4.nick = com.qzone.util.l.a(R.string.s0k);
            albumCacheData.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(0L, sharingOwnerUinAttr4, null, 4));
            this.L1 = true;
            return;
        }
        if (this.P0 != 0 || this.L1) {
            return;
        }
        SharingOwnerUinAttr sharingOwnerUinAttr5 = new SharingOwnerUinAttr();
        if (com.qzone.album.env.common.a.m().w(com.qzone.album.env.common.a.m().s()) == 1) {
            sharingOwnerUinAttr5.nick = com.qzone.util.l.a(R.string.s0v);
        } else {
            sharingOwnerUinAttr5.nick = com.qzone.util.l.a(R.string.s0i);
        }
        albumCacheData.sharingAlbumClientAttrArrayList.add(1, new SharingAlbumClientAttr(0L, sharingOwnerUinAttr5, null, 4));
        SharingOwnerUinAttr sharingOwnerUinAttr6 = new SharingOwnerUinAttr();
        sharingOwnerUinAttr6.nick = com.qzone.util.l.a(R.string.s0p);
        albumCacheData.sharingAlbumClientAttrArrayList.add(2, new SharingAlbumClientAttr(0L, sharingOwnerUinAttr6, null, 4));
        SharingOwnerUinAttr sharingOwnerUinAttr7 = new SharingOwnerUinAttr();
        sharingOwnerUinAttr7.nick = com.qzone.util.l.a(R.string.s0w);
        albumCacheData.sharingAlbumClientAttrArrayList.add(3, new SharingAlbumClientAttr(0L, sharingOwnerUinAttr7, null, 4));
        this.L1 = true;
    }

    private void Tj(int i3) {
        this.f42463y1.setText(fj(i3));
        Gj(i3);
    }

    private void Ui(AlbumCacheData albumCacheData) {
        SharingOwnerUinAttr sharingOwnerUinAttr = new SharingOwnerUinAttr();
        if (com.qzone.album.env.common.a.m().w(com.qzone.album.env.common.a.m().s()) == 1) {
            sharingOwnerUinAttr.nick = com.qzone.util.l.a(R.string.s0o);
        } else {
            sharingOwnerUinAttr.nick = com.qzone.util.l.a(R.string.s0x);
        }
        albumCacheData.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(com.qzone.album.env.common.a.m().s(), sharingOwnerUinAttr, com.qzone.album.env.common.a.m().x(com.qzone.album.env.common.a.m().s()), 4));
    }

    private void Vj(Intent intent, AlbumCacheData albumCacheData) {
        long parseLong = Long.parseLong(intent.getStringExtra("extra_choose_friend_uin"));
        String stringExtra = intent.getStringExtra("extra_choose_friend_name");
        String stringExtra2 = intent.getStringExtra("extraChooseFriendRemark");
        if (albumCacheData != null) {
            if (albumCacheData.getSharingAlbumClientAttr(parseLong) != null) {
                albumCacheData.getSharingAlbumClientAttr(parseLong).action = 4;
                return;
            }
            SharingAlbumClientAttr sharingAlbumClientAttr = new SharingAlbumClientAttr(parseLong, new SharingOwnerUinAttr(), !TextUtils.isEmpty(stringExtra2) ? stringExtra2 : stringExtra, 4);
            if (albumCacheData.sharingAlbumClientAttrArrayList == null) {
                SharingAlbumClientAttr sharingAlbumClientAttr2 = new SharingAlbumClientAttr(albumCacheData.createSharingUin, new SharingOwnerUinAttr(), LoginData.getInstance().getNickName(""), 4);
                if (albumCacheData.sharingAlbumClientAttrArrayList == null) {
                    albumCacheData.sharingAlbumClientAttrArrayList = new ArrayList<>();
                }
                albumCacheData.sharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr2);
            }
            albumCacheData.sharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr);
        }
    }

    private void Wj(Intent intent, AlbumCacheData albumCacheData) {
        long parseLong = Long.parseLong(intent.getStringExtra("extra_choose_friend_uin"));
        if (albumCacheData == null || albumCacheData.getSharingAlbumClientAttr(parseLong) == null) {
            return;
        }
        albumCacheData.getSharingAlbumClientAttr(parseLong).action = 0;
    }

    private boolean Xi() {
        boolean z16;
        boolean z17;
        Switch r26;
        AlbumDesExtendEditText albumDesExtendEditText;
        if (this.f42430i0.N1() == null) {
            return false;
        }
        QzoneNewAlbumViewModel qzoneNewAlbumViewModel = this.f42430i0;
        if (qzoneNewAlbumViewModel.N == null) {
            qzoneNewAlbumViewModel.N = "";
        }
        if (!(qzoneNewAlbumViewModel.M != qzoneNewAlbumViewModel.N1().albumrights)) {
            QzoneNewAlbumViewModel qzoneNewAlbumViewModel2 = this.f42430i0;
            if (qzoneNewAlbumViewModel2.P == qzoneNewAlbumViewModel2.N1().albumtype) {
                z16 = false;
                z17 = ((!(!z16 || this.E0.isChecked() != this.f42430i0.N1().isToppedAlbum) || !this.f42450s0.getText().toString().equals(this.f42430i0.N)) && ((albumDesExtendEditText = this.f42452t0) == null || TextUtils.equals(albumDesExtendEditText.getText(), this.f42430i0.N1().albumdesc))) ? false : true;
                if (!this.f42430i0.N1().needShowFamilySync() && (r26 = this.E1) != null) {
                    return z17 || r26.isChecked() != this.f42430i0.N1().isFamilySyncOn();
                }
            }
        }
        z16 = true;
        if (!(!z16 || this.E0.isChecked() != this.f42430i0.N1().isToppedAlbum) || !this.f42450s0.getText().toString().equals(this.f42430i0.N)) {
        }
        return !this.f42430i0.N1().needShowFamilySync() ? z17 : z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xj() {
        String d16;
        if (com.qzone.feed.utils.h.h(this.f42430i0.J) && !TextUtils.isEmpty(this.S0)) {
            d16 = this.S0;
        } else {
            d16 = com.qzone.feed.utils.h.d(this.f42430i0.J);
        }
        TextView textView = this.A0;
        if (textView != null) {
            textView.setText(d16);
        }
    }

    private void Yj(int i3) {
        this.f42429h1.t(i3);
        this.f42431i1.setVisibility(8);
        switch (i3) {
            case 8:
                if (this.P0 == 1) {
                    this.f42425e1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoFamily", "\u5bb6\u4eba"));
                    this.f42426f1.setVisibility(8);
                } else {
                    this.f42425e1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoInviteFamily", "\u9080\u8bf7\u5bb6\u4eba"));
                    this.f42426f1.setVisibility(0);
                }
                this.f42426f1.setRichText(getString(R.string.gbn));
                Fj(0);
                this.f42429h1.notifyDataSetChanged();
                return;
            case 9:
                if (this.P0 == 1) {
                    this.f42425e1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoPartner", "\u5c0f\u4f19\u4f34"));
                    this.f42426f1.setVisibility(8);
                } else {
                    this.f42425e1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoInvitePartner", "\u9080\u8bf7\u5c0f\u4f19\u4f34"));
                    this.f42426f1.setVisibility(0);
                }
                this.f42426f1.setRichText(getString(R.string.gbo));
                Fj(0);
                this.f42429h1.notifyDataSetChanged();
                return;
            case 10:
            default:
                Fj(8);
                this.f42426f1.setVisibility(8);
                return;
            case 11:
                if (this.P0 == 1) {
                    this.f42425e1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoLover", "\u604b\u4eba"));
                    this.f42426f1.setVisibility(8);
                } else {
                    this.f42425e1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoChooseLover", "\u9009\u62e9\u604b\u4eba"));
                    this.f42426f1.setVisibility(0);
                }
                this.f42426f1.setRichText(getString(R.string.gbl));
                Fj(0);
                this.f42429h1.notifyDataSetChanged();
                return;
            case 12:
                this.f42425e1.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoInvitePartner", "\u9080\u8bf7\u5c0f\u4f19\u4f34"));
                if (this.P0 == 0) {
                    this.f42426f1.setVisibility(0);
                } else {
                    this.f42426f1.setVisibility(8);
                    if (this.f42430i0.N1() != null && this.f42430i0.N1().isAlbumCreator()) {
                        this.f42431i1.setVisibility(0);
                        this.f42433j1.setChecked(this.f42430i0.N1().allowAutoJoinShareAlbum);
                    }
                }
                this.f42426f1.setRichText(getString(R.string.gbm));
                Fj(0);
                this.f42429h1.notifyDataSetChanged();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.A1.getVisibility() != 0) {
            Jj();
            if (this.P0 == 0) {
                LpReportInfo_pf00064.allReport(402, 18, 1);
                return;
            }
            return;
        }
        pj();
        if (this.P0 == 0) {
            LpReportInfo_pf00064.allReport(402, 18, 2);
        }
    }

    private void Zj(final AlbumCacheData albumCacheData) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.26
            @Override // java.lang.Runnable
            public void run() {
                QZLog.d(QZoneNewAlbumActivity.this.f42428h0, 1, "updateSharingOwners run...");
                if (QZoneNewAlbumActivity.this.P0 == 0) {
                    QZoneNewAlbumActivity.this.Ij(albumCacheData);
                } else if (QZoneNewAlbumActivity.this.P0 == 1) {
                    QZoneNewAlbumActivity.this.Hj(albumCacheData);
                }
                if (QZoneNewAlbumActivity.this.f42429h1 != null) {
                    QZoneNewAlbumActivity.this.f42429h1.s(albumCacheData);
                    if (QZoneNewAlbumActivity.this.f42430i0.Q1() != null) {
                        QZoneNewAlbumActivity.this.f42429h1.u(QZoneNewAlbumActivity.this.f42430i0.Q1());
                    }
                    QZoneNewAlbumActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.26.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneNewAlbumActivity.this.f42429h1.t(QZoneNewAlbumActivity.this.f42430i0.K);
                            QZoneNewAlbumActivity.this.f42429h1.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        try {
            Dialog dialog = this.G0;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.I0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj() {
        String string;
        if (this.f42430i0.N1() != null) {
            if (this.f42430i0.N1().isSharingAlbumCreator()) {
                string = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoWillBeDelete", "\u4f60\u548c\u5171\u4eab\u4eba\u7684\u76f8\u518c\u90fd\u5c06\u88ab\u5220\u9664");
            } else if (this.f42430i0.N1().isSharingAlbumPartner()) {
                string = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoDeleteSelf", "\u4ec5\u5220\u9664\u81ea\u5df1\u7684\u76f8\u518c,\u4f46\u4e0d\u4f1a\u5f71\u54cd\u5176\u4ed6\u4eba\u7684\u76f8\u518c");
            } else {
                string = getString(R.string.gmv);
            }
        } else {
            string = getString(R.string.gmv);
        }
        new com.qzone.component.e().f(this.f42435k1, 230, getString(R.string.gmx), string, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogDelete", "\u5220\u9664"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogCancel", "\u53d6\u6d88"), new j(), new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj() {
        if (this.I0) {
            if (!checkNetworkConnect()) {
                ToastUtil.n(R.string.gdc);
                return;
            }
            if (this.f42430i0.N1() != null) {
                this.I0 = false;
                Oj(getString(R.string.gdm));
                HashMap hashMap = new HashMap();
                this.M1 = this.f42430i0.L;
                hashMap.put(12, this.f42430i0.L);
                hashMap.put(2, this.f42430i0.N1().albumname);
                QZoneWriteOperationService.v0().W(getHandler(), "", "", "", 4, LoginData.getInstance().getUin(), this.f42430i0.L, "1", 0, hashMap, 26);
            }
        }
    }

    private void ck(Intent intent) {
        int intExtra = intent.getIntExtra("key_selected_share_uin", -1);
        String stringExtra = intent.getStringExtra("extra_choose_friend_uin");
        String stringExtra2 = intent.getStringExtra("extra_choose_friend_name");
        if (QZLog.isColorLevel()) {
            QZLog.d(this.f42428h0, 2, "uin:" + stringExtra + " uin:" + intExtra + " name:" + stringExtra2);
        }
        if (intExtra == -1 || this.f42430i0.N1() == null || this.f42430i0.N1().sharingAlbumClientAttrArrayList == null || intExtra >= this.f42430i0.N1().sharingAlbumClientAttrArrayList.size() || rj(Long.parseLong(stringExtra))) {
            return;
        }
        this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(intExtra).uin = Long.parseLong(stringExtra);
        this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(intExtra).qq_nick = stringExtra2;
        this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(intExtra).action = 4;
        this.f42429h1.t(this.f42430i0.K);
        this.f42429h1.notifyDataSetChanged();
    }

    private void dj() {
        this.f42465z1.setVisibility(8);
        this.f42460x0.setVisibility(8);
        this.f42462y0.setVisibility(8);
        this.J0.setVisibility(8);
        this.A1.setVisibility(0);
        this.f42427g1.setVisibility(0);
        this.B1.setText(getResources().getString(R.string.ghm));
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("QZoneNewAlbumActivity.key_share_uin");
        ArrayList<String> stringArrayListExtra2 = getIntent().getStringArrayListExtra("QZoneNewAlbumActivity.key_share_remark_name");
        this.N0 = PhotoActivity.f45075r2;
        this.O0 = PhotoActivity.f45074q2;
        if (this.f42430i0.N1() != null) {
            for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                String str = stringArrayListExtra.get(i3);
                String str2 = stringArrayListExtra2.get(i3);
                SharingAlbumClientAttr sharingAlbumClientAttr = new SharingAlbumClientAttr(Long.parseLong(str), new SharingOwnerUinAttr(), str2, 4);
                if (this.f42430i0.N1().sharingAlbumClientAttrArrayList == null) {
                    this.f42430i0.N1().sharingAlbumClientAttrArrayList = new ArrayList<>();
                }
                this.f42430i0.N1().sharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr);
            }
        }
        this.f42430i0.K = 12;
        Yj(12);
        Zj(this.f42430i0.N1());
        Fj(8);
        this.f42426f1.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(AlbumCacheData albumCacheData) {
        LinearLayout linearLayout;
        String string;
        QZLog.d(this.f42428h0, 1, "updateUI... srcType:", Integer.valueOf(this.P0));
        int i3 = this.P0;
        if (i3 == 1) {
            if (albumCacheData != null) {
                if (albumCacheData.isSharingAlbumPartner()) {
                    this.f42450s0.setVisibility(8);
                    this.f42452t0.setVisibility(8);
                    this.f42454u0.setVisibility(8);
                    this.f42460x0.setVisibility(8);
                    this.f42462y0.setVisibility(8);
                    this.f42465z1.setVisibility(8);
                } else {
                    if (albumCacheData.albumnum != 0) {
                        Lj();
                    }
                    this.f42450s0.setVisibility(0);
                    this.f42452t0.setVisibility(0);
                    this.f42454u0.setVisibility(0);
                    this.f42460x0.setVisibility(0);
                    this.f42462y0.setVisibility(0);
                    this.f42465z1.setVisibility(0);
                }
                if (!TextUtils.isEmpty(albumCacheData.albumname)) {
                    this.f42450s0.setText(albumCacheData.albumname);
                    try {
                        EditText editText = this.f42450s0;
                        editText.setSelection(editText.getText().length());
                    } catch (Exception e16) {
                        QZLog.e(this.f42428h0, "exception:", e16);
                    }
                }
                if (!Vi(albumCacheData.albumdesc)) {
                    this.f42452t0.setText(albumCacheData.albumdesc);
                }
                Button button = this.B0;
                if (button != null) {
                    if (albumCacheData.isSharingAlbumOnServer()) {
                        string = getResources().getString(R.string.gmy);
                    } else {
                        string = getResources().getString(R.string.gmt);
                    }
                    button.setText(string);
                }
                if (albumCacheData.needShowFamilySync() && sj(albumCacheData) && (linearLayout = this.D1) != null && this.E1 != null) {
                    linearLayout.setVisibility(0);
                    this.E1.setChecked(albumCacheData.isFamilySyncOn());
                }
                Jj();
            }
        } else if (i3 == 0) {
            Button button2 = this.B0;
            if (button2 != null) {
                button2.setVisibility(8);
            }
            AlbumDesExtendEditText albumDesExtendEditText = this.f42452t0;
            if (albumDesExtendEditText != null) {
                albumDesExtendEditText.setVisibility(8);
            }
            if (this.F1) {
                Jj();
            } else {
                pj();
            }
            LinearLayout linearLayout2 = this.D0;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        if (albumCacheData != null && !this.I1) {
            if (this.P0 == 0) {
                Rj(jj(this.f42430i0.R));
            } else {
                Kj(albumCacheData.albumtype, false);
            }
            if (this.P0 == 1) {
                Yj(albumCacheData.albumtype);
                Zj(albumCacheData);
                this.f42429h1.t(albumCacheData.albumtype);
                this.f42429h1.notifyDataSetChanged();
            } else {
                Fj(8);
            }
        }
        if (albumCacheData != null) {
            this.E0.setChecked(albumCacheData.isToppedAlbum);
        }
        showKeyboard();
    }

    private void ek(final String str, final List<MediaWrapper> list, final BusinessAlbumInfo businessAlbumInfo, final LbsDataV2.PoiInfo poiInfo, final QZonePreUploadInfo qZonePreUploadInfo, final Map<String, String> map, final Object... objArr) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.27
            /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Map<String, byte[]> map2;
                Map<String, String> map3;
                BusinessAlbumInfo businessAlbumInfo2 = businessAlbumInfo;
                Object[] objArr2 = objArr;
                if (objArr2 != null) {
                    String str2 = objArr2.length > 0 ? (String) objArr2[0] : null;
                    int intValue = objArr2.length > 1 ? ((Integer) objArr2[1]).intValue() : 0;
                    Object[] objArr3 = objArr;
                    String str3 = objArr3.length > 2 ? (String) objArr3[2] : null;
                    if (objArr3.length > 3) {
                        Object obj = objArr3[3];
                        if (obj instanceof Map) {
                            map2 = (Map) obj;
                            if (objArr3.length > 4) {
                                Object obj2 = objArr3[4];
                                if (obj2 instanceof Map) {
                                    map3 = (Map) obj2;
                                    QZoneWriteOperationService.v0().u2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, 190, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null);
                                }
                            }
                            map3 = null;
                            QZoneWriteOperationService.v0().u2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, 190, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null);
                        }
                    }
                    map2 = null;
                    if (objArr3.length > 4) {
                    }
                    map3 = null;
                    QZoneWriteOperationService.v0().u2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, 190, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null);
                }
            }
        });
        setResult(-1);
        HashMap<String, LocalMediaInfo> hashMap = PhotoActivity.f45074q2;
        if (hashMap != null) {
            hashMap.clear();
        }
        ArrayList<String> arrayList = PhotoActivity.f45075r2;
        if (arrayList != null) {
            arrayList.clear();
        }
        aj();
        finish();
    }

    private String fj(int i3) {
        switch (i3) {
            case 8:
                return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoBabyAlbum", "\u4eb2\u5b50\u76f8\u518c");
            case 9:
                return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoTravelAlbum", "\u65c5\u6e38\u76f8\u518c");
            case 10:
            default:
                return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoNormalAlbum", "\u666e\u901a\u76f8\u518c");
            case 11:
                return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoLoveAlbum", "\u60c5\u4fa3\u76f8\u518c");
            case 12:
                return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoMultiAlbum", "\u591a\u4eba\u76f8\u518c");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk() {
        TextView textView = this.H0;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.gox));
        }
        Pj();
        LpReportInfo_pf00064.allReport(602, 1);
    }

    private int gj() {
        int i3 = this.P0;
        return (i3 == 0 || i3 == 1) ? R.string.cancel : R.string.f170549u3;
    }

    private LbsDataV2.PoiInfo hj() {
        LbsDataV2.GpsInfo a16 = com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_UPLOAD_PIC_VIDEO).a();
        if (a16 == null) {
            return null;
        }
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
        gpsInfo.lat = a16.lat;
        gpsInfo.lon = a16.lon;
        poiInfo.show_poi = 0;
        return poiInfo;
    }

    private int ij() {
        int i3 = this.P0;
        return (i3 == 0 || i3 == 1) ? R.string.ghp : R.string.gho;
    }

    private void initData() {
        this.f42435k1 = getActivity();
        this.F1 = wj();
        this.K1 = false;
        com.qzone.album.env.common.a.m().k();
        Intent intent = getIntent();
        if (intent != null) {
            this.P0 = intent.getIntExtra("QZoneNewAlbumActivity.key_type_src", 0);
            this.Q0 = intent.getStringExtra("refer");
            this.M0 = intent.getBooleanExtra("QZoneNewAlbumActivity.key_fast_share", false);
            int i3 = this.P0;
            if (i3 == 1) {
                int intExtra = intent.getIntExtra("QZoneNewAlbumActivity.key_choose_type", 0);
                if (intExtra != 0) {
                    this.I1 = true;
                    this.J1 = intExtra;
                    this.K1 = true;
                } else {
                    this.I1 = false;
                    this.J1 = -1;
                }
                this.f42430i0.L = intent.getStringExtra("QZoneNewAlbumActivity.key_album_id");
                QZLog.d(this.f42428h0, 1, "initData... recommendType:", Integer.valueOf(intExtra), " showAlbumTypeSettingsLayout:", Boolean.valueOf(this.F1), " albumid:", this.f42430i0.L, " isFastShare:", Boolean.valueOf(this.M0));
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).post(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneNewAlbumActivity.this.f42430i0.U1(QZoneNewAlbumActivity.this.f42430i0.L);
                        QZoneNewAlbumActivity.this.f42430i0.X1(QZoneNewAlbumActivity.this.f42430i0.L, "");
                    }
                });
            } else if (i3 == 0) {
                this.f42430i0.W1(getIntent());
            }
            if (this.f42430i0.N1() != null) {
                Zj(this.f42430i0.N1());
            }
            LpReportInfo_pf00064.allReport(402, 11, this.P0 == 1 ? 1 : 0);
        }
    }

    private void initUI() {
        TextView textView;
        setTitle(lj());
        this.C.setText(gj());
        this.C.setBackgroundResource(0);
        TextView textView2 = this.C;
        textView2.setPadding(0, textView2.getPaddingTop(), this.C.getPaddingRight(), this.C.getPaddingBottom());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.hfp);
        this.f42465z1 = relativeLayout;
        relativeLayout.setOnClickListener(this.Q1);
        ExtendScrollView extendScrollView = (ExtendScrollView) findViewById(R.id.f8p);
        this.f42459w1 = extendScrollView;
        extendScrollView.b(R.id.bg_);
        ExtendLinearLayout extendLinearLayout = (ExtendLinearLayout) findViewById(R.id.f164255p0);
        this.f42448r0 = extendLinearLayout;
        extendLinearLayout.setOnDownListener(new p());
        EditText editText = (EditText) findViewById(R.id.f5f);
        this.f42450s0 = editText;
        editText.addTextChangedListener(new u(0));
        com.qzone.album.util.n.a(this.f42450s0);
        this.f42452t0 = (AlbumDesExtendEditText) findViewById(R.id.bg_);
        int b06 = QZoneConfigHelper.b0();
        this.f42438m0 = b06;
        this.f42452t0.setMaxLineToScrollAlways(b06);
        this.f42452t0.setMaxLines(this.f42438m0);
        this.f42452t0.addTextChangedListener(new u(1));
        this.f42461x1 = (TextView) findViewById(R.id.fzf);
        this.C1 = (ImageView) findViewById(R.id.has);
        this.f42454u0 = (TextView) findViewById(R.id.hfd);
        TextView textView3 = (TextView) findViewById(R.id.hfe);
        this.f42456v0 = textView3;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        this.f42463y1 = (TextView) findViewById(R.id.jpe);
        this.f42460x0 = (LinearLayout) findViewById(R.id.hfc);
        this.f42462y0 = (RelativeLayout) findViewById(R.id.hfk);
        this.A1 = (LinearLayout) findViewById(R.id.f164290r4);
        View findViewById = findViewById(R.id.fze);
        this.f42464z0 = findViewById;
        findViewById.setOnClickListener(this.Q1);
        this.A0 = (TextView) findViewById(R.id.fzd);
        this.D0 = (LinearLayout) findViewById(R.id.hsp);
        this.E0 = (Switch) findViewById(R.id.hsq);
        LpReportInfo_pf00064.allReport(402, 20, 1);
        this.D1 = (LinearLayout) findViewById(R.id.hsd);
        this.E1 = (Switch) findViewById(R.id.hse);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.hdp);
        this.U0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this.Q1);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.hds);
        this.W0 = relativeLayout3;
        relativeLayout3.setOnClickListener(this.Q1);
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.hdw);
        this.V0 = relativeLayout4;
        relativeLayout4.setOnClickListener(this.Q1);
        RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.hdi);
        this.X0 = relativeLayout5;
        relativeLayout5.setOnClickListener(this.Q1);
        RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.hdm);
        this.Y0 = relativeLayout6;
        relativeLayout6.setOnClickListener(this.Q1);
        this.Z0 = (ImageView) findViewById(R.id.hdo);
        this.f42421a1 = (ImageView) findViewById(R.id.hdk);
        this.f42422b1 = (ImageView) findViewById(R.id.hdr);
        this.f42423c1 = (ImageView) findViewById(R.id.hdu);
        this.f42424d1 = (ImageView) findViewById(R.id.hdh);
        ImageView imageView = (ImageView) findViewById(R.id.hdl);
        this.f42458w0 = imageView;
        imageView.setVisibility(8);
        this.J0 = (RelativeLayout) findViewById(R.id.hfn);
        this.K0 = (TextView) findViewById(R.id.hfo);
        this.L0 = (Button) findViewById(R.id.hfl);
        Button button = (Button) findViewById(R.id.aee);
        this.B0 = button;
        button.setOnClickListener(new q());
        this.f42437l1 = findViewById(R.id.hfi);
        this.f42439m1 = findViewById(R.id.hfh);
        this.f42441n1 = findViewById(R.id.hff);
        this.f42443o1 = findViewById(R.id.hfj);
        this.f42445p1 = findViewById(R.id.hfg);
        this.f42447q1 = findViewById(R.id.hfb);
        this.f42449r1 = (TextView) findViewById(R.id.hdq);
        this.f42451s1 = (TextView) findViewById(R.id.hdn);
        this.f42453t1 = (TextView) findViewById(R.id.hdt);
        this.f42455u1 = (TextView) findViewById(R.id.hdx);
        this.f42457v1 = (TextView) findViewById(R.id.hdj);
        this.L0.setOnClickListener(this.Q1);
        this.f42425e1 = (TextView) findViewById(R.id.hc6);
        CellTextView cellTextView = (CellTextView) findViewById(R.id.hc5);
        this.f42426f1 = cellTextView;
        cellTextView.setCellClickable(true);
        this.f42426f1.setOnCellClickListener(new r());
        this.f42427g1 = (AlbumGridView) findViewById(R.id.hc7);
        this.f42431i1 = (LinearLayout) findViewById(R.id.hkq);
        Switch r06 = (Switch) findViewById(R.id.hkr);
        this.f42433j1 = r06;
        r06.setOnCheckedChangeListener(new s());
        com.qzone.album.business.editalbum.a aVar = new com.qzone.album.business.editalbum.a(getActivity(), this.f42430i0.N1(), this.P0, this.Q0);
        this.f42429h1 = aVar;
        aVar.v(new t());
        this.f42427g1.setAdapter((ListAdapter) this.f42429h1);
        String stringExtra = getIntent().getStringExtra("suggestedNewAlbumName");
        if (this.P0 == 0 && !TextUtils.isEmpty(stringExtra)) {
            this.f42450s0.setText(stringExtra);
            EditText editText2 = this.f42450s0;
            editText2.setSelection(editText2.getText().length());
        }
        Button button2 = (Button) findViewById(R.id.hat);
        this.B1 = button2;
        SimpleModeHelper.i(button2);
        int i3 = this.P0;
        if (i3 == 1) {
            this.f42452t0.setHint(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoHint", "\u63cf\u8ff0"));
            this.B1.setVisibility(8);
            Xh(ij(), this.P1, false);
            this.f42448r0.setBackgroundColor(Color.parseColor("#f7f7f7"));
        } else if (i3 == 0) {
            Aj();
            this.B1.setOnClickListener(this.P1);
            if (com.qzone.album.util.q.c("keyTypeNewRedDot") && (textView = this.f42456v0) != null) {
                textView.setVisibility(0);
                runOnUiThread(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneNewAlbumActivity.this.f42456v0 == null || QZoneNewAlbumActivity.this.f42456v0.getVisibility() != 0) {
                            return;
                        }
                        com.qzone.album.util.q.d("keyTypeNewRedDot");
                        QZoneNewAlbumActivity.this.f42456v0.setVisibility(8);
                    }
                }, 3000L);
            }
            this.f42448r0.setBackgroundColor(Color.parseColor("#f7f7f7"));
        }
        if (getIntent().getBooleanExtra("editAlbumNeedScrollToEnd", false)) {
            this.f42459w1.postDelayed(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    if (QZoneNewAlbumActivity.this.f42459w1 != null) {
                        QZoneNewAlbumActivity.this.f42459w1.fullScroll(130);
                    }
                }
            }, 400L);
        }
        if (this.P0 == 0) {
            if (getIntent().getBooleanExtra("editAlbumNeedSelectLover", false) && this.f42430i0.N1().isLoveAlbum()) {
                this.f42459w1.postDelayed(new Runnable() { // from class: com.qzone.album.business.editalbum.QZoneNewAlbumActivity.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneNewAlbumActivity.this.f42430i0.N1().isLoveAlbum()) {
                            com.qzone.album.env.common.a.m().z(QZoneNewAlbumActivity.this.getActivity(), -1, 14);
                        }
                    }
                }, 400L);
            }
            dk(this.f42430i0.N1());
        }
        if (this.M0) {
            dj();
        }
        this.f42430i0.M1(getIntent());
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_OPEN_THEME_PANEL_WHEN_CREAT_ALBUM_SETTING, 1) == 1) {
            Zi();
        }
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.f165773dg1);
        this.C0 = asyncImageView;
        asyncImageView.setDefaultImage(R.drawable.g7f);
        this.C0.setFailImage(R.drawable.g7f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int jj(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return R.id.hdp;
                    }
                    return R.id.hdm;
                }
                return R.id.hdi;
            }
            return R.id.hdw;
        }
        return R.id.hds;
    }

    private int lj() {
        return this.P0 != 1 ? R.string.ghl : R.string.ge9;
    }

    private void nj() {
        LinearLayout linearLayout = this.D1;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        Switch r06 = this.E1;
        if (r06 != null) {
            r06.setChecked(false);
        }
    }

    private void oj() {
        LinearLayout linearLayout = this.D1;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        Switch r06 = this.E1;
        if (r06 != null) {
            r06.setChecked(false);
        }
    }

    private void pj() {
        this.A1.setVisibility(8);
        this.C1.setImageResource(R.drawable.g_t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qj() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            if (inputMethodManager.isActive(this.f42450s0) && inputMethodManager.hideSoftInputFromWindow(this.f42450s0.getWindowToken(), 0)) {
                return true;
            }
            if (inputMethodManager.isActive(this.f42452t0) && inputMethodManager.hideSoftInputFromWindow(this.f42452t0.getWindowToken(), 0)) {
                return true;
            }
        }
        return false;
    }

    private void showKeyboard() {
        AlbumDesExtendEditText albumDesExtendEditText;
        EditText editText = this.f42450s0;
        if ((editText == null || editText.getVisibility() != 0) && ((albumDesExtendEditText = this.f42452t0) == null || albumDesExtendEditText.getVisibility() != 0)) {
            return;
        }
        getWindow().setSoftInputMode(4);
        EditText editText2 = this.f42450s0;
        if (editText2 != null) {
            editText2.requestFocus();
        }
    }

    private boolean tj(int i3) {
        int targetTypeMaxCount = this.f42430i0.N1().getTargetTypeMaxCount(i3);
        if (this.f42430i0.N1().getConfirmedSharingOwnersNumber() > targetTypeMaxCount) {
            if (this.f42430i0.N1().albumtype == 11) {
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoFirstDeleteLover", "\u8bf7\u5148\u5220\u9664\u604b\u4eba"));
            } else if (i3 == 1) {
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoFirstDeleteShare", "\u8bf7\u5148\u5220\u9664\u5171\u4eab\u4eba"));
            } else {
                String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoMostMainTain", "\u8be5\u4e3b\u9898\u76f8\u518c\u6700\u591a\u652f\u6301");
                String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoPeopleSharing", "\u4eba\u5171\u4eab");
                com.qzone.album.env.common.a.m().V(config + targetTypeMaxCount + config2);
            }
            return true;
        }
        if (this.f42430i0.N1().getConfirmedSharingOwnersNumber() == targetTypeMaxCount && this.f42430i0.N1().getSharingOwnersNumber() > this.f42430i0.N1().getConfirmedSharingOwnersNumber() && this.f42430i0.N1().sharingAlbumClientAttrArrayList != null && this.f42430i0.N1().sharingAlbumClientAttrArrayList.size() > 0) {
            for (int i16 = 0; i16 < this.f42430i0.N1().sharingAlbumClientAttrArrayList.size(); i16++) {
                if (this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16) != null && this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).uin != 0 && this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).uin != this.f42430i0.N1().createSharingUin && this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).uinAttr != null && this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).uinAttr.status != 2) {
                    this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).action = 8;
                }
            }
        }
        return false;
    }

    private boolean uj() {
        if (this.f42430i0.N1() == null || this.D1 == null || this.E1 == null || !this.f42430i0.N1().needShowFamilySync()) {
            return false;
        }
        QzoneNewAlbumViewModel qzoneNewAlbumViewModel = this.f42430i0;
        return qzoneNewAlbumViewModel.Q == 1 && qzoneNewAlbumViewModel.N1().albumrights != 1;
    }

    private boolean vj() {
        if (this.f42430i0.N1() == null || this.D1 == null || this.E1 == null || !this.f42430i0.N1().needShowFamilySync()) {
            return false;
        }
        QzoneNewAlbumViewModel qzoneNewAlbumViewModel = this.f42430i0;
        return qzoneNewAlbumViewModel.Q != 1 && qzoneNewAlbumViewModel.N1().albumrights == 1;
    }

    private boolean wj() {
        String[] split;
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_NEW_ALBUM_SHOW_SETTINGS, "0-0");
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(config) && (split = config.split("-")) != null && split.length >= 2) {
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
        }
        long uin = LoginData.getInstance().getUin() % 100;
        return uin >= ((long) iArr[0]) && uin < ((long) iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(MotionEvent motionEvent) {
        if (this.f42450s0 == null && this.f42452t0 == null) {
            return false;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) (motionEvent.getY() + getTitleBarHeight() + this.mStatusBarHeight);
        EditText editText = this.f42450s0;
        Rect mj5 = editText != null ? mj(editText) : null;
        if (mj5 != null && mj5.contains(x16, y16)) {
            if (this.P0 == 0) {
                LpReportInfo_pf00064.allReport(402, 12);
            }
            return true;
        }
        AlbumDesExtendEditText albumDesExtendEditText = this.f42452t0;
        if (albumDesExtendEditText != null) {
            mj5 = mj(albumDesExtendEditText);
        }
        if (mj5 == null || !mj5.contains(x16, y16)) {
            return false;
        }
        if (this.P0 == 0) {
            LpReportInfo_pf00064.allReport(402, 13);
        }
        return true;
    }

    private void yj() {
        ArrayList<SharingAlbumClientAttr> o16;
        if (this.P0 == 1 && (o16 = this.f42429h1.o()) != null && o16.size() > 0) {
            this.K1 = true;
            for (int i3 = 0; i3 < o16.size(); i3++) {
                if (!rj(o16.get(i3).uin)) {
                    this.f42430i0.N1().sharingAlbumClientAttrArrayList.add(o16.get(i3));
                }
            }
        }
        if (this.f42430i0.N1().sharingAlbumClientAttrArrayList != null && (this.f42430i0.N1().isTravelAlbum() || this.f42430i0.N1().isLoveAlbum() || this.f42430i0.N1().isMultiAlbum())) {
            for (int i16 = 0; i16 < this.f42430i0.N1().sharingAlbumClientAttrArrayList.size(); i16++) {
                if (!TextUtils.isEmpty(this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).uinAttr.nick)) {
                    this.K1 = true;
                    this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).uinAttr.nick = "";
                    this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i16).action |= 16;
                }
            }
        }
        if (this.f42430i0.N1().sharingAlbumClientAttrArrayList == null || this.f42430i0.N1().albumtype != 8) {
            return;
        }
        this.K1 = true;
    }

    private boolean zj() {
        if (this.f42430i0.N1() == null || !Xi()) {
            return false;
        }
        new com.qzone.component.e().h(getActivity(), getString(R.string.gbx), "", getString(R.string.gmw), getString(R.string.gmu), new i(), null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Mj() {
        long j3;
        int i3;
        int i16;
        Calendar calendar = Calendar.getInstance();
        int i17 = calendar.get(1);
        int i18 = calendar.get(2);
        int i19 = calendar.get(5);
        int i26 = (this.f42430i0.N1() == null || this.f42430i0.K != 8) ? i17 : i17 + 1;
        int i27 = (this.f42430i0.N1() == null || this.f42430i0.K != 8) ? i19 : i19 - 1;
        if (this.f42430i0.N1() != null) {
            QzoneNewAlbumViewModel qzoneNewAlbumViewModel = this.f42430i0;
            int i28 = qzoneNewAlbumViewModel.K;
            if (i28 == 8) {
                j3 = qzoneNewAlbumViewModel.N1().birthDateTime;
            } else if (i28 == 11) {
                j3 = qzoneNewAlbumViewModel.N1().loveTime;
            }
            if (j3 != 0) {
                String[] split = QZoneAlbumUtil.j(j3).split("\\.");
                if (split.length == 3) {
                    i17 = Integer.valueOf(split[0]).intValue();
                    i16 = Integer.valueOf(split[1]).intValue() - 1;
                    i3 = Integer.valueOf(split[2]).intValue();
                    if (this.G1 == null) {
                        jp.c c16 = jp.a.c(this.f42435k1);
                        this.G1 = c16;
                        c16.r(0, i17);
                        this.G1.r(1, i16);
                        this.G1.r(2, i3);
                        this.G1.p(new d(i26, i18, i27));
                        this.G1.q(new e());
                    }
                    jp.a.h(this.G1);
                    this.H1 = false;
                    this.G1.s();
                }
            }
            i3 = i19;
            i16 = i18;
            if (this.G1 == null) {
            }
            jp.a.h(this.G1);
            this.H1 = false;
            this.G1.s();
        }
        j3 = 0;
        if (j3 != 0) {
        }
        i3 = i19;
        i16 = i18;
        if (this.G1 == null) {
        }
        jp.a.h(this.G1);
        this.H1 = false;
        this.G1.s();
    }

    protected void Yi() {
        long C = com.qzone.util.image.c.C(null, this.N0, 0, 0);
        QZLog.i(this.f42428h0, "picSize = " + C);
        if (com.qzone.util.image.c.M(C)) {
            Nj(com.qzone.util.image.c.H(C, false));
        } else {
            Bj(false);
        }
    }

    public String ej() {
        if (this.f42430i0.N1() != null) {
            return this.f42430i0.N1().albumid;
        }
        return "";
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean isEnableNightMask() {
        return !QZoneConfigHelper.O0();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        qj();
        if (this.P0 == 0) {
            LpReportInfo_pf00064.allReport(402, 14);
        }
        if (zj()) {
            return false;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean onBackPress() {
        if (this.P0 == 0) {
            LpReportInfo_pf00064.allReport(402, 14);
        }
        if (zj()) {
            return true;
        }
        return super.onBackPress();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.qzone.album.util.q.e("keyDeleteSharePerson");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        QZoneResult unpack;
        super.onHandleMessage(message);
        aj();
        if (message == null || (unpack = QZoneResult.unpack(message)) == null) {
            return;
        }
        int i3 = message.what;
        if (i3 != 999909) {
            if (i3 == 1000146 && unpack.getSucceed()) {
                toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoReinvite", "\u5df2\u91cd\u65b0\u9080\u8bf7"), 5);
                return;
            }
            return;
        }
        if (unpack.getSucceed()) {
            ToastUtil.o(R.string.gmf, 5);
            Intent intent = new Intent();
            intent.putExtra(QZoneContant.KEY_EDIT_TYPE, "deleteAlbum");
            intent.putExtra(QZoneContant.KEY_DELETED_ALBUM_ID, this.M1);
            setResult(-1, intent);
            finish();
            return;
        }
        if (!TextUtils.isEmpty(unpack.getMessage())) {
            toast(unpack.getMessage(), 4);
        } else {
            toast(R.string.gme, 4);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        qj();
        super.onPause();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f42430i0 = (QzoneNewAlbumViewModel) ViewModelProviders.of(this).get(QzoneNewAlbumViewModel.class);
        initData();
        initUI();
        Qj();
    }

    private void Pj() {
        ArrayList<String> arrayList;
        HashMap<String, LocalMediaInfo> hashMap;
        if (this.F0 == null || (arrayList = this.N0) == null || arrayList.size() <= 0 || (hashMap = this.O0) == null || hashMap.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.N0.size(); i3++) {
            String str = this.N0.get(i3);
            if (this.O0.containsKey(str)) {
                LocalMediaInfo localMediaInfo = this.O0.get(str);
                QZLog.d(this.f42428h0, 4, "processUploadMediaList add:" + str);
                int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                if (mediaType == 0) {
                    ImageInfo imageInfo = new ImageInfo(str);
                    imageInfo.mDescription = "";
                    MediaWrapper mediaWrapper = new MediaWrapper(imageInfo);
                    mediaWrapper.setQuality(0);
                    arrayList2.add(mediaWrapper);
                } else if (mediaType == 1) {
                    FragmentActivity activity = getActivity();
                    long j3 = localMediaInfo._id;
                    String str2 = localMediaInfo.path;
                    long j16 = localMediaInfo.fileSize;
                    int i16 = localMediaInfo.thumbHeight;
                    int i17 = localMediaInfo.thumbWidth;
                    long j17 = localMediaInfo.mDuration;
                    ShuoshuoVideoInfo p16 = ag.p(activity, j3, str2, j16, 1, null, i16, i17, 0L, j17, j17, false, null);
                    if (p16 != null) {
                        p16.mDescription = "";
                        MediaWrapper mediaWrapper2 = new MediaWrapper(p16);
                        mediaWrapper2.setQuality(0);
                        arrayList2.add(mediaWrapper2);
                    }
                }
            }
        }
        BusinessAlbumInfo businessAlbumInfo = this.F0;
        if (businessAlbumInfo == null || this.N0 == null) {
            return;
        }
        ek("", arrayList2, businessAlbumInfo, hj(), null, null, this.Q0, Integer.valueOf(this.N0.size()));
    }

    private void ak(ArrayList<s4.b> arrayList, AlbumCacheData albumCacheData) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            s4.b bVar = arrayList.get(i3);
            if (albumCacheData.getSharingAlbumClientAttr(bVar.f433292a) != null) {
                albumCacheData.getSharingAlbumClientAttr(bVar.f433292a).action = 4;
            } else {
                SharingAlbumClientAttr sharingAlbumClientAttr = new SharingAlbumClientAttr(bVar.f433292a, new SharingOwnerUinAttr(), bVar.f433293b, 4);
                if (albumCacheData.sharingAlbumClientAttrArrayList == null) {
                    SharingAlbumClientAttr sharingAlbumClientAttr2 = new SharingAlbumClientAttr(albumCacheData.createSharingUin, new SharingOwnerUinAttr(), LoginData.getInstance().getNickName(""), 4);
                    if (albumCacheData.sharingAlbumClientAttrArrayList == null) {
                        albumCacheData.sharingAlbumClientAttrArrayList = new ArrayList<>();
                    }
                    albumCacheData.sharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr2);
                }
                albumCacheData.sharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr);
            }
        }
    }

    private void bk(ArrayList<s4.b> arrayList, AlbumCacheData albumCacheData) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            s4.b bVar = arrayList.get(i3);
            if (albumCacheData.getSharingAlbumClientAttr(bVar.f433292a) != null) {
                albumCacheData.getSharingAlbumClientAttr(bVar.f433292a).action = 0;
            }
        }
    }

    private boolean rj(long j3) {
        for (int i3 = 0; i3 < this.f42430i0.N1().sharingAlbumClientAttrArrayList.size(); i3++) {
            if (this.f42430i0.N1().sharingAlbumClientAttrArrayList.get(i3).uin == j3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneNewAlbumActivity.this.f42430i0.N1() != null && QZoneNewAlbumActivity.this.f42430i0.N1().coverUrl != null) {
                QZoneNewAlbumActivity.this.K1 = true;
                Intent I = ak.I(QZoneNewAlbumActivity.this.getActivity(), BusinessAlbumInfo.createFrom(QZoneNewAlbumActivity.this.ej(), QZoneNewAlbumActivity.this.f42430i0.N1().albumtype, QZoneNewAlbumActivity.this.f42430i0.N1().albumname, QZoneNewAlbumActivity.this.f42430i0.N1().getLloc(), QZoneNewAlbumActivity.this.f42430i0.N1().albumrights, QZoneNewAlbumActivity.this.f42430i0.N1().albumnum, QZoneNewAlbumActivity.this.f42430i0.N1().anonymity, QZoneNewAlbumActivity.this.f42430i0.N1().individual, QZoneNewAlbumActivity.this.f42430i0.N1().operatemask, QZoneNewAlbumActivity.this.f42430i0.N1().allow_share, QZoneNewAlbumActivity.this.f42430i0.N1().isSharingAlbumOnServer(), com.qzone.album.util.b.a(QZoneNewAlbumActivity.this.f42430i0.N1()), QZoneNewAlbumActivity.this.f42430i0.N1().isSharingOwner), 2);
                I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_SINGLE_MODEL_NO_NEED_BIG_IMG, true);
                if (QZoneNewAlbumActivity.this.f42430i0.N1().busi_param != null) {
                    I.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_SORTING_MODEL_BUSI_PARAM, (HashMap) QZoneNewAlbumActivity.this.f42430i0.N1().busi_param);
                }
                QZoneNewAlbumActivity.this.startActivityForResult(I, 4);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Ej(boolean z16) {
        String str;
        String str2;
        String str3;
        String str4;
        String string = getString(R.string.ghr);
        Album createAlbumRequestModel = this.f42430i0.N1().createAlbumRequestModel(this.P0, this.f42430i0.N1(), -1);
        if (this.f42430i0.N1().isToppedAlbum != this.E0.isChecked()) {
            if (this.f42430i0.N1().isToppedAlbum) {
                createAlbumRequestModel.top_flag = 2;
                LpReportInfo_pf00064.allReport(402, 20, 3);
            } else {
                createAlbumRequestModel.top_flag = 1;
                LpReportInfo_pf00064.allReport(402, 20, 2);
            }
        }
        if (this.f42430i0.N1() != null && this.E1 != null && this.f42430i0.N1().needShowFamilySync() && this.E1.isChecked() != this.f42430i0.N1().isFamilySyncOn()) {
            if (this.f42430i0.N1().isFamilySyncOn()) {
                this.f42430i0.N1().turnOffFamilySync();
            } else {
                this.f42430i0.N1().turnOnFamilySync();
            }
            createAlbumRequestModel.game_album_flag = this.f42430i0.N1().syncFanmilyStatus;
        }
        int i3 = this.P0;
        if (i3 == 0) {
            if (this.f42430i0.N1().sharingAlbumClientAttrArrayList != null && this.f42430i0.N1().getSharingOwnersNumber() > 1) {
                com.qzone.album.base.Service.a W = com.qzone.album.base.Service.a.W();
                String str5 = this.Q0;
                int i16 = this.O1;
                if (i16 == 0) {
                    str4 = "";
                } else {
                    str4 = String.valueOf(i16);
                }
                W.z(createAlbumRequestModel, str5, str4, 1, null, false, this.R1);
            } else {
                createAlbumRequestModel.shareattrs = null;
                com.qzone.album.base.Service.a W2 = com.qzone.album.base.Service.a.W();
                String str6 = this.Q0;
                int i17 = this.O1;
                if (i17 == 0) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(i17);
                }
                W2.z(createAlbumRequestModel, str6, str3, 0, null, false, this.R1);
            }
            LpReportInfo_pf00064.allReport(402, 15);
        } else if (i3 == 1) {
            if (QZLog.isColorLevel() && this.R0 != null) {
                QZLog.d(this.f42428h0, 2, "sloc:" + this.R0.sloc);
            }
            ArrayList<client_attr> arrayList = createAlbumRequestModel.shareattrs;
            if (arrayList != null && arrayList.size() <= 1 && !this.f42430i0.N1().isSharingAlbumOnServer()) {
                createAlbumRequestModel.shareattrs = null;
            }
            com.qzone.album.base.Service.a W3 = com.qzone.album.base.Service.a.W();
            PictureItem pictureItem = this.R0;
            if (pictureItem == null) {
                str = "";
            } else {
                str = pictureItem.sloc;
            }
            String str7 = this.Q0;
            int i18 = this.O1;
            if (i18 == 0) {
                str2 = "";
            } else {
                str2 = String.valueOf(i18);
            }
            W3.F(createAlbumRequestModel, str, str7, str2, (byte) 0, new f(z16));
            string = getString(R.string.ge_);
        }
        if (!z16) {
            Oj(string);
        }
        this.I0 = false;
    }

    private void Lj() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.dag);
        relativeLayout.setVisibility(0);
        if (this.f42430i0.N1() != null && this.f42430i0.N1().coverUrl != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d(this.f42428h0, 2, "showChangeCoverUI coverUrl:" + this.f42430i0.N1().coverUrl.url);
            }
            this.C0.setAsyncImage(this.f42430i0.N1().coverUrl.url);
        }
        relativeLayout.setOnClickListener(new a());
    }

    private boolean Vi(String str) {
        if (str != null) {
            try {
                return str.replace(" ", "").length() == 0;
            } catch (Throwable th5) {
                com.qzone.album.env.common.a.m().e(this.f42428h0, th5.getMessage());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wi(AlbumCacheData albumCacheData) {
        boolean isEmpty;
        TextView textView;
        boolean z16 = true;
        if (albumCacheData == null || !albumCacheData.isSharingAlbumOnServer()) {
            isEmpty = TextUtils.isEmpty(this.f42450s0.getText().toString().trim());
        } else {
            if (albumCacheData.createSharingUin == com.qzone.album.env.common.a.m().s()) {
                isEmpty = TextUtils.isEmpty(this.f42450s0.getText().toString().trim());
            }
            textView = this.E;
            if (textView == null) {
                textView.setEnabled(z16);
                return;
            }
            return;
        }
        z16 = true ^ isEmpty;
        textView = this.E;
        if (textView == null) {
        }
    }

    private TextView kj(int i3) {
        switch (i3) {
            case 8:
                return this.f42453t1;
            case 9:
                return this.f42455u1;
            case 10:
            default:
                return this.f42449r1;
            case 11:
                return this.f42457v1;
            case 12:
                return this.f42451s1;
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.bie, viewGroup);
    }

    private boolean sj(AlbumCacheData albumCacheData) {
        return albumCacheData == null || albumCacheData.albumrights == 1;
    }

    private Rect mj(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
    }

    private void Uj(int i3) {
        String config;
        String j3;
        if (i3 == 8 || i3 == 11) {
            if (i3 == 8) {
                r1 = (this.f42430i0.N1().isSharingAlbumCreator() || this.f42430i0.N1().isUnsharingAlbumCreator()) ? 0 : 8;
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoBirthday", "\u751f\u65e5");
                if (this.f42430i0.N1().birthDateTime == 0) {
                    Calendar calendar = Calendar.getInstance();
                    this.f42430i0.N1().birthDateTime = Long.parseLong(QZoneAlbumUtil.i(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
                }
                j3 = QZoneAlbumUtil.j(this.f42430i0.N1().birthDateTime);
            } else if (i3 != 11) {
                config = null;
                j3 = null;
            } else {
                config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoLoveDate", "\u76f8\u604b\u65e5\u671f");
                if (this.f42430i0.N1().loveTime != 0) {
                    j3 = QZoneAlbumUtil.j(this.f42430i0.N1().loveTime);
                } else {
                    j3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoTogatherDate", "\u586b\u5199\u5728\u4e00\u8d77\u7684\u65e5\u671f");
                }
                r1 = 0;
            }
            if (r1 == 0) {
                this.K0.setText(config);
                this.L0.setText(j3);
            }
            this.J0.setVisibility(r1);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            if (i3 != 4) {
                if (i3 != 5) {
                    switch (i3) {
                        case 12:
                            if (intent != null) {
                                this.K1 = true;
                                AlbumCacheData albumCacheData = this.f42430i0.E;
                                if (albumCacheData != null) {
                                    ak(com.qzone.album.env.common.a.m().r(intent), albumCacheData);
                                    if (!this.f42430i0.N1().isSharingAlbumOnServer() && this.f42430i0.N1().createSharingUin <= 0) {
                                        this.f42430i0.N1().createSharingUin = com.qzone.album.env.common.a.m().s();
                                    }
                                    Cj(albumCacheData);
                                    bk(com.qzone.album.env.common.a.m().r(intent), albumCacheData);
                                    break;
                                }
                            }
                            break;
                        case 13:
                            if (intent != null) {
                                this.K1 = true;
                                ck(intent);
                                if (!this.f42430i0.N1().isSharingAlbumOnServer() && this.f42430i0.N1().createSharingUin <= 0) {
                                    this.f42430i0.N1().createSharingUin = com.qzone.album.env.common.a.m().s();
                                    break;
                                }
                            }
                            break;
                        case 14:
                            if (intent != null) {
                                this.K1 = true;
                                AlbumCacheData albumCacheData2 = this.f42430i0.E;
                                if (albumCacheData2 != null) {
                                    Vj(intent, albumCacheData2);
                                    com.qzone.album.env.common.a.m().P(402, 4, "5", true, this.f42430i0.L);
                                    Cj(albumCacheData2);
                                    Wj(intent, albumCacheData2);
                                    break;
                                }
                            }
                            break;
                    }
                } else if (intent != null && this.f42430i0.N1() != null) {
                    this.K1 = true;
                    Bundle extras = intent.getExtras();
                    if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
                        this.f42430i0.J = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE);
                        this.f42430i0.N1().albumrights = com.qzone.feed.utils.h.b(this.f42430i0.J);
                    }
                    if (extras.containsKey("uin_list")) {
                        if (this.f42430i0.N1().album_white_list == null) {
                            this.f42430i0.N1().album_white_list = new ArrayList<>();
                        }
                        this.f42430i0.N1().album_white_list.clear();
                        ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
                        if (stringArrayList != null) {
                            Iterator<String> it = stringArrayList.iterator();
                            while (it.hasNext()) {
                                this.f42430i0.N1().album_white_list.add(Long.valueOf(Long.parseLong(it.next())));
                            }
                        }
                    }
                    if (extras.containsKey(UgcSettingUtil.KEY_QUESTION) && extras.containsKey(UgcSettingUtil.KEY_ANSWER)) {
                        this.f42430i0.N1().albumquestion = extras.getString(UgcSettingUtil.KEY_QUESTION);
                        this.f42430i0.N1().albumanswer = extras.getString(UgcSettingUtil.KEY_ANSWER);
                    }
                    if (com.qzone.feed.utils.h.h(this.f42430i0.J)) {
                        this.S0 = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
                    }
                    this.T0 = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                    Xj();
                    if (uj()) {
                        nj();
                    }
                    if (vj()) {
                        oj();
                    }
                    QzoneNewAlbumViewModel qzoneNewAlbumViewModel = this.f42430i0;
                    qzoneNewAlbumViewModel.Q = qzoneNewAlbumViewModel.N1().albumrights;
                    com.qzone.album.env.common.a.m().P(402, 6, "1", true, ej());
                } else {
                    QZLog.w(this.f42428h0, "REQUEST_CODE_UGC_PERMISSION DATA IS NULL");
                }
            } else if (intent != null) {
                this.K1 = true;
                PictureItem pictureItem = (PictureItem) ParcelableWrapper.getDataFromeIntent(intent, "key_photo_new_cover_picitem");
                this.R0 = pictureItem;
                if (pictureItem != null && pictureItem.currentUrl != null && this.C0 != null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d(this.f42428h0, 2, "REQUEST_CODE_CHANGE_ALBUM_COVER url:" + this.R0.currentUrl.url);
                    }
                    this.C0.setAsyncImage(this.R0.currentUrl.url);
                } else {
                    QZLog.w(this.f42428h0, "mCoverPictureItem IS NULL OR mCoverPictureItem.currentUrl IS NULL ");
                }
            } else {
                QZLog.w(this.f42428h0, "REQUEST_BABY_BIRTH_SET DATA IS NULL");
            }
        }
        if (i16 == 0 && i3 == 5) {
            com.qzone.album.env.common.a.m().P(402, 6, "2", true, ej());
        }
        switch (i3) {
            case 12:
            case 13:
            case 14:
                if (intent == null) {
                    com.qzone.album.env.common.a.m().P(402, 4, "4", true, ej());
                    break;
                }
                break;
        }
        super.onActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class u implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private int f42503d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f42504e = false;

        /* renamed from: f, reason: collision with root package name */
        private int f42505f;

        /* renamed from: h, reason: collision with root package name */
        private int f42506h;

        public u(int i3) {
            this.f42503d = i3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.f42503d == 0) {
                QZoneNewAlbumActivity qZoneNewAlbumActivity = QZoneNewAlbumActivity.this;
                qZoneNewAlbumActivity.Wi(qZoneNewAlbumActivity.f42430i0.N1());
            }
            int i3 = this.f42505f;
            if (this.f42503d == 0 && this.f42504e && editable.length() > 30) {
                char[] cArr = new char[30];
                editable.getChars(0, this.f42505f, cArr, 0);
                try {
                    if (this.f42505f + this.f42506h != editable.length()) {
                        editable.getChars(this.f42505f + this.f42506h, editable.length(), cArr, this.f42505f);
                    }
                    editable.replace(0, editable.length(), String.valueOf(cArr).trim());
                    if (editable.toString().trim().length() < i3) {
                        i3 = editable.toString().trim().length();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                QZoneNewAlbumActivity.this.f42450s0.setSelection(i3);
                QZoneNewAlbumActivity.this.toast(String.format(QZoneNewAlbumActivity.this.getString(R.string.ghv), 30));
            }
            int i16 = this.f42503d;
            if (i16 == 1 || i16 == 0 || i16 == 2) {
                String obj = editable.toString();
                String b16 = com.qzone.util.g.b(obj, "");
                if (!obj.equals(b16)) {
                    editable.replace(0, editable.length(), b16);
                    QZoneNewAlbumActivity.this.toast(R.string.ghw);
                }
            }
            if (this.f42503d == 1 && this.f42504e && editable.length() > QZoneConfigHelper.a0()) {
                char[] cArr2 = new char[QZoneConfigHelper.a0()];
                editable.getChars(0, this.f42505f, cArr2, 0);
                try {
                    if (this.f42505f + this.f42506h != editable.length()) {
                        editable.getChars(this.f42505f + this.f42506h, editable.length(), cArr2, this.f42505f);
                    }
                    editable.replace(0, editable.length(), String.valueOf(cArr2).trim());
                    if (editable.toString().trim().length() < i3) {
                        i3 = editable.toString().trim().length();
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                QZoneNewAlbumActivity.this.f42452t0.setSelection(i3);
                QZoneNewAlbumActivity.this.toast(String.format(QZoneNewAlbumActivity.this.getString(R.string.ghq), Integer.valueOf(QZoneConfigHelper.a0())));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            int i18 = this.f42503d;
            if (i18 == 0) {
                if ((charSequence.length() - i16) + i17 > 30) {
                    this.f42504e = true;
                    this.f42505f = i3;
                    this.f42506h = i17;
                    return;
                }
                return;
            }
            if (i18 == 1) {
                if ((charSequence.length() - i16) + i17 > QZoneConfigHelper.a0()) {
                    this.f42504e = true;
                    this.f42505f = i3;
                    this.f42506h = i17;
                }
                if (QZoneNewAlbumActivity.this.f42452t0 != null) {
                    QZoneNewAlbumActivity.this.f42452t0.setBeforeChangeLineCount(QZoneNewAlbumActivity.this.f42452t0.getLineCount());
                    return;
                }
                return;
            }
            if (i18 != 2 || (charSequence.length() - i16) + i17 <= 10) {
                return;
            }
            this.f42504e = true;
            this.f42505f = i3;
            this.f42506h = i17;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
