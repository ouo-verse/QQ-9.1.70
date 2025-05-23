package com.qzone.reborn.part.publish.mood.sync;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.media.QZoneQCircleMediaImpl;
import com.qzone.publish.ui.controller.QZoneSyncBubbleController;
import com.qzone.reborn.part.publish.mood.sync.n;
import com.qzone.util.ToastUtil;
import com.qzone.util.ak;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.api.IQQWinkPublishAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.bubble.RFWTipsManager;
import com.tencent.richframework.bubble.bean.RFWTipsBaseConfig;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes37.dex */
public class QZonePublishSyncQCirclePart extends com.qzone.reborn.base.k {
    private Switch C;
    private View D;
    private TextView E;
    private View F;
    private TextView G;
    private ImageView H;
    private gm.c I;
    private hm.b J;
    private fm.b K;
    private o L;
    private bm.a M;
    private n N;
    private Bundle R;
    private int S;
    private int T;
    private String V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0 */
    private int f58690a0;

    /* renamed from: b0 */
    private boolean f58691b0;

    /* renamed from: d */
    private String f58693d;

    /* renamed from: d0 */
    private QQCustomDialog f58694d0;

    /* renamed from: e */
    private boolean f58695e;

    /* renamed from: f */
    private QZoneBubbleInfo f58696f;

    /* renamed from: i */
    private volatile boolean f58698i;

    /* renamed from: m */
    private View f58699m;

    /* renamed from: h */
    private final QZoneQCircleMediaImpl f58697h = new QZoneQCircleMediaImpl();
    private boolean P = false;
    private boolean Q = LocalMultiProcConfig.getBoolean4Uin(LocalMultiProcConfig.QZONE_PERMISSION_PUBLIC, false, LoginData.getInstance().getUin());
    private int U = -1;

    /* renamed from: c0 */
    private final View.OnClickListener f58692c0 = new a();

    /* renamed from: com.qzone.reborn.part.publish.mood.sync.QZonePublishSyncQCirclePart$3 */
    /* loaded from: classes37.dex */
    public class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QZonePublishSyncQCirclePart.this.Fb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePublishSyncQCirclePart.Y9()) {
                ArrayList Aa = QZonePublishSyncQCirclePart.this.Aa();
                QZLog.d("QZonePublishSyncQCirclePart", 1, "go preview originFilePaths size:" + Aa.size());
                String va5 = QZonePublishSyncQCirclePart.this.va();
                if (QZonePublishSyncQCirclePart.this.R != null) {
                    if (va5 != null && va5.length() > 0) {
                        QZonePublishSyncQCirclePart.this.R.putInt(QQWinkConstants.EDITOR_ENTRANCE, 6);
                    } else {
                        QZonePublishSyncQCirclePart.this.R.putInt(QQWinkConstants.EDITOR_ENTRANCE, 0);
                    }
                }
                QZonePublishSyncQCirclePart.this.L.d2(QZonePublishSyncQCirclePart.this.M.O1());
                QZonePublishSyncQCirclePart.this.f58697h.y(QZonePublishSyncQCirclePart.this.getActivity(), va5, QZonePublishSyncQCirclePart.this.ua(Aa), QZonePublishSyncQCirclePart.this.M.O1(), QZonePublishSyncQCirclePart.this.R);
            } else {
                RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "camera res is not ready");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    public class b implements n.a {
        b() {
        }

        @Override // com.qzone.reborn.part.publish.mood.sync.n.a
        public void a(int i3, String str) {
            QZonePublishSyncQCirclePart.this.Ib(i3, str);
        }

        @Override // com.qzone.reborn.part.publish.mood.sync.n.a
        public void b(int i3, String str) {
            QZonePublishSyncQCirclePart.this.Gb(i3, str);
        }
    }

    /* loaded from: classes37.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public ArrayList<String> Aa() {
        List<String> R1 = this.I.R1();
        if (R1 == null) {
            return new ArrayList<>();
        }
        return rb(sb(R1));
    }

    private void Ab() {
        if (this.f58698i) {
            return;
        }
        this.f58698i = true;
        if (!aa()) {
            QZLog.d("QZonePublishSyncQCirclePart", 1, "updateSyncStatus isEnableSync is false");
            oa();
            return;
        }
        if (lb() && this.J.R1().getValue() == null) {
            this.C.setChecked(true);
        }
        if (Na().booleanValue() || this.C.isChecked()) {
            return;
        }
        this.f58691b0 = true;
        this.C.setChecked(Qa());
    }

    private QZoneBubbleInfo Ba() {
        QZoneBubbleInfo j3 = com.qzone.business.tianshu.o.i().j();
        if (j3 == null) {
            return null;
        }
        QZLog.d("QZonePublishSyncQCirclePart", 1, "checkAndShowQCircleConfigTag bubbleInfo\uff1a" + j3);
        if (QZoneSyncBubbleController.f(j3)) {
            return j3;
        }
        QZLog.d("QZonePublishSyncQCirclePart", 1, "bubbleInfo validTime is false");
        return null;
    }

    private void Ca() {
        if (!Z9()) {
            Da();
            return;
        }
        boolean z16 = !this.C.isChecked();
        QZLog.d("QZonePublishSyncQCirclePart", 1, "handleCheckStatusChangeFromUser isOldCheckedStatus \uff1a" + z16);
        if (z16) {
            ToastUtil.s(BaseApplication.getContext().getString(R.string.f2192365v, BaseApplication.getContext().getString(R.string.f2203168s)), 5);
        } else {
            ToastUtil.s(BaseApplication.getContext().getString(R.string.f2200067y, BaseApplication.getContext().getString(R.string.f2203168s)), 6);
        }
    }

    private void Da() {
        if (aa() && this.C.isChecked()) {
            this.C.setChecked(false);
            this.f58699m.setVisibility(8);
        }
    }

    private void Ea() {
        if (getActivity() == null || getActivity().getIntent() == null || !getActivity().getIntent().hasExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE)) {
            return;
        }
        boolean booleanExtra = getActivity().getIntent().getBooleanExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE, false);
        if (this.J == null) {
            this.J = (hm.b) getViewModel(hm.b.class);
        }
        this.J.g2(getActivity().getIntent().getStringExtra(QQWinkConstants.PUBLISH_TEMPLATE_TOPIC));
        if (this.L == null) {
            this.L = (o) getViewModel(o.class);
        }
        this.L.c2(getActivity().getIntent().getStringExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_TYPE));
        this.L.b2(getActivity().getIntent().getStringExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_ID));
        this.J.R1().postValue(Boolean.valueOf(booleanExtra));
    }

    public void Fb() {
        if (this.f58694d0 != null) {
            return;
        }
        QZLog.d("QZonePublishSyncQCirclePart", 1, "showOpenGuide");
        this.f58694d0 = DialogUtil.createCustomDialog(getActivity(), 230, BaseApplication.getContext().getString(R.string.f2199467s), BaseApplication.getContext().getString(R.string.f2199367r), (String) null, BaseApplication.getContext().getString(R.string.f185803pk), new c(), (DialogInterface.OnClickListener) null);
        u5.b.p0("key_publish_has_show_sync_qcircle_dialog_guide", true, LoginData.getInstance().getUin());
        this.f58694d0.show();
    }

    public void Gb(int i3, String str) {
        if (this.D == null || this.F == null || this.E == null) {
            return;
        }
        this.f58690a0 = i3;
        if (i3 == 3 && Ya()) {
            this.D.setVisibility(8);
            Kb();
        } else {
            if (i3 != 0) {
                this.E.setText(str);
                this.D.setVisibility(0);
                this.F.setVisibility(8);
                tb(i3);
                return;
            }
            this.D.setVisibility(8);
            Kb();
        }
    }

    private void Hb(String str, int i3) {
        if (this.W) {
            RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "has show bubble, return");
            return;
        }
        wb(i3);
        this.W = true;
        if (this.Y) {
            this.X = true;
            RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "soft keyboard is open, return");
        } else {
            Jb(str);
        }
    }

    private void Ja() {
        n nVar = new n();
        this.N = nVar;
        nVar.q(new b());
    }

    private void Jb(String str) {
        e5.b a16 = e5.b.a(this.C, str, 0);
        QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
        RFWTipsBaseConfig rFWTipsBaseConfig = new RFWTipsBaseConfig();
        rFWTipsBaseConfig.setDuration(5000L);
        rFWTipsBaseConfig.setMargin(0, 0, 0, ImmersiveUtils.dpToPx(8.0f));
        e5.c cVar = new e5.c(this.C, rFWTipsBaseConfig, a16);
        RFWTipsManager.getInstance().addTips(cVar);
        cVar.startShowTip();
    }

    public static boolean Ka() {
        return La();
    }

    private static boolean La() {
        return ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady();
    }

    private void Lb() {
        if (Z9()) {
            if (this.f58699m.getVisibility() != 0) {
                this.f58699m.setVisibility(0);
                LpReportInfo_pf00064.allReport(586, 62, 0);
            }
            Ab();
            ea();
            ba();
            ca();
            return;
        }
        oa();
        this.f58699m.setVisibility(8);
    }

    private void Mb(boolean z16) {
        o oVar = this.L;
        if (oVar == null) {
            return;
        }
        oVar.W1(z16);
        QLog.i("QZonePublishSyncQCirclePart", 1, "[updateQCircleSyncSwitch] set mQCircleSyncSwitchStatus = " + z16);
    }

    private Boolean Na() {
        return Boolean.valueOf(Pa() || Oa().booleanValue());
    }

    private Boolean Oa() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            return Boolean.valueOf(getActivity().getIntent().hasExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE));
        }
        return Boolean.FALSE;
    }

    private boolean Pa() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return false;
        }
        return getActivity().getIntent().getBooleanExtra(PeakConstants.KEY_IS_FROM_QZONE_AUTO_TEMPLATE, false);
    }

    private boolean Qa() {
        boolean z16 = false;
        if (!uq3.k.a().c("has_read_sync_qfs_wns_status", false)) {
            uq3.k.a().j("has_read_sync_qfs_wns_status", true);
            return Xa();
        }
        o oVar = this.L;
        if (oVar != null && oVar.Z1()) {
            z16 = true;
        }
        RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "memory switch status is " + z16);
        return z16;
    }

    private boolean Ra() {
        boolean c16 = gd.a.f401926a.c("KEY_OPEN_QZONE_BUBBLE_TEST", false);
        if (!u5.c.z(LoginData.getInstance().getUin()) || c16) {
            return Qa() && this.f58691b0;
        }
        RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "has show memory bubble before, not show again");
        return false;
    }

    private boolean Sa() {
        Bundle extras;
        if (getActivity() == null || getActivity().getIntent() == null || (extras = getActivity().getIntent().getExtras()) == null || !extras.containsKey("syncCircleBubbleText")) {
            return false;
        }
        String string = extras.getString("syncCircleBubbleText");
        if (TextUtils.isEmpty(string)) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync circle bubble text is null");
            return false;
        }
        this.V = string;
        return true;
    }

    private boolean Ta() {
        bm.a aVar = this.M;
        return aVar != null && aVar.M1() && !Ya() && this.M.O1().replaceAll(" ", "").length() >= 10;
    }

    private boolean Ua() {
        boolean c16 = uq3.k.a().c("publish_page_sync_qfs_text_to_video_switch_bubble", false);
        if (Ta()) {
            return !c16 || gd.a.f401926a.c("KEY_OPEN_QZONE_BUBBLE_TEST", false);
        }
        return false;
    }

    private boolean Va() {
        QZoneBubbleInfo Ba = Ba();
        if (Ba == null) {
            RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "topic bubble info is null");
            return false;
        }
        if (Ba.wordsIsTag()) {
            return true;
        }
        RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "invalid topic bubble, set preview root text");
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(Ba.getWords());
        }
        return false;
    }

    private boolean Wa() {
        hm.b bVar = this.J;
        return (bVar == null || bVar.R1() == null || this.J.R1().getValue() == null || TextUtils.isEmpty(this.J.b2())) ? false : true;
    }

    private boolean Xa() {
        this.U = uq3.k.a().e("sp_key_qzone_product_synchronization_switch", -1);
        QLog.i("QZonePublishSyncQCirclePart", 1, "[isQCircleSyncSwitchOpen] sp mQZoneSyncSwitch = " + this.U);
        if (this.U == -1) {
            this.U = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_qzone_product_synchronization_switch", 0);
        }
        boolean z16 = this.U == 1;
        this.L.W1(z16);
        QLog.i("QZonePublishSyncQCirclePart", 1, "[isQCircleSyncSwitchOpen] wns mQZoneSyncSwitch = " + this.U);
        return z16;
    }

    static /* bridge */ /* synthetic */ boolean Y9() {
        return La();
    }

    private boolean Ya() {
        gm.c cVar = this.I;
        if (cVar == null || cVar.S1() == null) {
            return false;
        }
        DynamicArrayList<String> value = this.I.S1().getValue();
        if (value != null && value.size() > 0) {
            this.Z = true;
        }
        return (value == null || value.isEmpty()) ? false : true;
    }

    private boolean Z9() {
        if (this.P || pa() || !this.Q) {
            return false;
        }
        if (La()) {
            return (((Ya() ^ true) && (!this.L.X1() || (!this.M.M1() && this.L.X1()))) || this.f58699m == null || !aa() || this.J.c2() || !this.J.e2() || this.J.f2()) ? false : true;
        }
        RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "camera is not ready");
        return false;
    }

    public /* synthetic */ void Za(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QZLog.d("QZonePublishSyncQCirclePart", 1, "user click delete tag");
        qa(2);
        this.D.setVisibility(8);
        if (this.J == null) {
            this.J = (hm.b) getViewModel(hm.b.class);
        }
        this.J.g2("");
        this.f58696f = null;
        Kb();
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean aa() {
        if (!TextUtils.equals(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, "publish_mood_enable_sync_qcircle", "1"), "1")) {
            QZLog.d("QZonePublishSyncQCirclePart", 1, "canUseSyncQCircleFunction wns switch is false");
            return false;
        }
        if (QZoneQCircleMediaImpl.A()) {
            return !this.K.T1() && this.K.O1();
        }
        return false;
    }

    public /* synthetic */ void ab(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ca();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void ba() {
        n nVar = this.N;
        if (nVar == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
            return;
        }
        nVar.c();
        na();
        ma();
        ja();
        this.N.e();
    }

    public /* synthetic */ void bb(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        this.L.R1().postValue(Boolean.valueOf(z16));
        if (z16) {
            da();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void ca() {
        n nVar = this.N;
        if (nVar == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
            return;
        }
        nVar.d();
        ha();
        ia();
        la();
        this.N.f();
    }

    public /* synthetic */ void cb(ArrayList arrayList) {
        pb();
    }

    private void da() {
        if (!Z9()) {
            QZLog.e(getTAG(), 1, "[checkAndShowSyncGuideDialog] can not sync qcircle");
        } else {
            if (u5.b.E("key_publish_has_show_sync_qcircle_dialog_guide", false, LoginData.getInstance().getUin())) {
                return;
            }
            runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.part.publish.mood.sync.QZonePublishSyncQCirclePart.3
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishSyncQCirclePart.this.Fb();
                }
            }, 500L);
        }
    }

    private void ea() {
        View view;
        if (this.Z && (view = this.D) != null && this.f58690a0 == 3) {
            view.setVisibility(8);
            Kb();
        }
    }

    public /* synthetic */ void fb(Integer num) {
        pb();
    }

    private void ga() {
        n nVar;
        if (this.X && (nVar = this.N) != null) {
            this.X = false;
            Jb(nVar.i());
        }
    }

    public /* synthetic */ void gb(Long l3) {
        pb();
    }

    public /* synthetic */ void hb(Long l3) {
        pb();
    }

    private void ia() {
        if (mb()) {
            RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "sync switch is open, not show switch bubble");
        } else if (this.N == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
        } else if (Sa()) {
            this.N.b(2, this.V);
        }
    }

    public /* synthetic */ void ib(Integer num) {
        pb();
    }

    private void ja() {
        if (this.N == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
        } else if (Ta() && !this.Z) {
            n nVar = this.N;
            nVar.a(3, nVar.h());
        }
    }

    public /* synthetic */ void jb(Boolean bool) {
        this.C.setChecked(bool.booleanValue());
    }

    public /* synthetic */ void kb(String str) {
        pb();
    }

    private void la() {
        if (mb()) {
            RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "sync switch is open, not show switch bubble");
            return;
        }
        if (this.N == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
        } else if (Ua()) {
            n nVar = this.N;
            nVar.b(3, nVar.i());
        }
    }

    private void ma() {
        if (this.N == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
            return;
        }
        if (Va() && Ba() != null) {
            this.N.a(2, "#" + Ba().getWords());
        }
    }

    private void na() {
        if (this.N == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
            return;
        }
        if (Wa()) {
            this.N.a(1, "#" + this.J.b2());
        }
    }

    private void nb() {
        if (Pa()) {
            LpReportInfo_pf00064.allReport(586, 1, 7);
        }
    }

    private void oa() {
        this.C.setChecked(false);
    }

    private void ob() {
        QIPCClientHelper.getInstance().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_OPEN_QCIRCLE_FOR_QZONE, null, null);
    }

    private boolean pa() {
        fm.b bVar;
        Intent intent = getActivity() == null ? null : getActivity().getIntent();
        return (intent != null && intent.getBooleanExtra(QQWinkConstants.PUBLISH_DISABLE_SHOW_SYNC_TO_QCIRCLE, false)) || ((bVar = this.K) != null && bVar.S1());
    }

    private void qa(int i3) {
        String str;
        String str2;
        String str3;
        QZoneBubbleInfo qZoneBubbleInfo = this.f58696f;
        if (qZoneBubbleInfo != null) {
            if (qZoneBubbleInfo.wordsIsTag()) {
                str = "1";
            } else {
                str = "0";
            }
            str3 = this.f58696f.getId();
            str2 = this.f58696f.getWords();
        } else {
            str = "none";
            str2 = "";
            str3 = "none";
        }
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = this.S;
        lpReportInfo_pf00064.subactionType = this.T;
        lpReportInfo_pf00064.reserves = i3;
        lpReportInfo_pf00064.reserves3 = str3;
        lpReportInfo_pf00064.reserves4 = str;
        lpReportInfo_pf00064.reserves5 = str2;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private void qb() {
        this.I.S1().observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.eb((DynamicArrayList) obj);
            }
        });
        this.J.T1().observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.fb((Integer) obj);
            }
        });
        this.J.X1().observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.gb((Long) obj);
            }
        });
        this.J.Z1().observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.hb((Long) obj);
            }
        });
        this.J.a2().observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.ib((Integer) obj);
            }
        });
        this.J.R1().observe((LifecycleOwner) getPartHost(), new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.jb((Boolean) obj);
            }
        });
        this.M.P1().observe((LifecycleOwner) getPartHost(), new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.kb((String) obj);
            }
        });
    }

    private void ra(String str) {
        boolean mb5 = mb();
        vb(mb5);
        if (!Na().booleanValue() && this.f58691b0) {
            RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "update view model sync count " + mb5);
            Mb(mb5);
        }
        if (!mb5) {
            QZLog.d("QZonePublishSyncQCirclePart", 1, "doSyncPublish needSyncQCircle is false");
            return;
        }
        String va5 = va();
        String O1 = this.M.O1();
        QZoneBubbleInfo za5 = za();
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.R;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        bundle.putString(QQWinkConstants.WINK_PUBLISH_PARAM_CLIENT_KEY, str);
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(QQWinkConstants.WINK_PUBLISH_TASK_ID);
            if (!TextUtils.isEmpty(stringExtra)) {
                bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, stringExtra);
            }
        }
        if (!TextUtils.isEmpty(this.J.b2())) {
            O1 = O1 + "#" + this.J.b2();
        } else if (za5 != null) {
            if (!TextUtils.isEmpty(za5.getWords())) {
                O1 = O1 + "#" + za5.getWords();
            }
            bundle.putString(QQWinkConstants.WINK_PUBLISH_PARAM_TASK_ID, za5.getId() + "");
            bundle.putString(QQWinkConstants.WINK_PUBLISH_PARAM_AD_POS_ID, za5.posId + "");
            bundle.putString(QQWinkConstants.WINK_PUBLISH_PARAM_TOPIC_NAME, za5.getWords());
        }
        String O12 = this.L.O1();
        String P1 = this.L.P1();
        if (!TextUtils.isEmpty(O12) && !TextUtils.isEmpty(P1)) {
            bundle.putString(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_ID, O12);
            bundle.putString(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_TYPE, P1);
        }
        if (TextUtils.isEmpty(va5)) {
            ArrayList<String> Aa = Aa();
            if (Aa != null && Aa.size() != 0) {
                QZLog.d("QZonePublishSyncQCirclePart", 1, "doSyncPublish publishFeedWithRecommendMusic originList size:" + Aa.size() + ",content:" + O1 + ",syncTag:" + za5);
                ((IQQWinkPublishAPI) QRoute.api(IQQWinkPublishAPI.class)).publishFeedWithRecommendMusic(10, ua(Aa), O1, bundle);
            } else {
                QZLog.d("QZonePublishSyncQCirclePart", 1, "doSyncPublish publishTextContent:,content:" + O1 + ",syncTag:" + za5);
                if (!TextUtils.isEmpty(O1)) {
                    ((IQQWinkPublishAPI) QRoute.api(IQQWinkPublishAPI.class)).publishTextContent(10, O1, bundle);
                }
            }
        } else {
            QZLog.d("QZonePublishSyncQCirclePart", 1, "doSyncPublish publishFeedByEditDraft preExportMissionId:" + va5 + "content:" + O1 + ",syncTag:" + za5);
            ((IQQWinkPublishAPI) QRoute.api(IQQWinkPublishAPI.class)).publishFeedByEditDraft(10, va5, O1, bundle);
        }
        ob();
    }

    public void ta(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f58692c0.onClick(view);
        qa(5);
        QZoneBubbleInfo qZoneBubbleInfo = this.f58696f;
        if (qZoneBubbleInfo != null) {
            ak.g(qZoneBubbleInfo.getOriginAdItem(), 102);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void tb(int i3) {
        RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "preview bubble type show is " + i3);
        if (i3 == 1) {
            yb("1", "1");
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            yb("1", "3");
        } else {
            yb("1", "2");
            QZoneBubbleInfo Ba = Ba();
            if (Ba != null) {
                this.f58696f = Ba;
                ak.g(Ba.getOriginAdItem(), 101);
            }
        }
    }

    public ArrayList<String> ua(List<String> list) {
        return new ArrayList<>(list.subList(0, Math.min(50, list.size())));
    }

    public String va() {
        String xa5 = xa();
        if (!TextUtils.isEmpty(xa5)) {
            QZLog.i("QZonePublishSyncQCirclePart", 1, "[getMissionId] previewMissionId=" + xa5);
            return xa5;
        }
        String wa5 = wa();
        if (TextUtils.isEmpty(wa5)) {
            return null;
        }
        QZLog.i("QZonePublishSyncQCirclePart", 1, "[getMissionId] otherMissionId=" + wa5);
        return wa5;
    }

    private String wa() {
        LocalMediaInfo localMediaInfo;
        DynamicArrayList<String> value = this.I.S1().getValue();
        if (value == null || value.size() != 1 || this.I.T1() == null || (localMediaInfo = this.I.T1().get(value.get(0))) == null || TextUtils.isEmpty(localMediaInfo.missionID)) {
            return null;
        }
        return localMediaInfo.missionID;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (com.tencent.mobileqq.activity.photo.album.QAlbumUtil.getMediaType(r0) == 0) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String xa() {
        DynamicArrayList<String> value = this.I.S1().getValue();
        boolean z16 = true;
        if (value != null && !value.isEmpty()) {
            if (value.size() == 1) {
                String str = value.get(0);
                if (!TextUtils.isEmpty(str)) {
                    if (!str.startsWith("http")) {
                    }
                }
            }
            z16 = false;
        }
        if (z16) {
            if (TextUtils.isEmpty(this.f58693d) || this.I.X1() || !this.M.O1().equals(this.L.Q1())) {
                return null;
            }
            return this.f58693d;
        }
        if (!this.f58695e || TextUtils.isEmpty(this.f58693d) || this.I.X1()) {
            return null;
        }
        return this.f58693d;
    }

    private void xb(String str) {
        yb(str, "0");
    }

    private void yb(String str, String str2) {
        String str3;
        String str4;
        QZoneBubbleInfo qZoneBubbleInfo = this.f58696f;
        if (qZoneBubbleInfo != null) {
            str3 = qZoneBubbleInfo.getId();
            str4 = this.f58696f.getWords();
        } else {
            str3 = "none";
            str4 = "";
        }
        LpReportInfo_pf00064.allReport(586, 62, 1, (String) null, str3, str, str4, str2, (String) null);
    }

    public void Bb(boolean z16) {
        this.P = z16;
    }

    public void Cb(int i3, int i16) {
        this.S = i3;
        this.T = i16;
    }

    public void Db(boolean z16) {
        if (this.Q != z16) {
            this.Q = z16;
            pb();
            LocalMultiProcConfig.putBoolean4Uin(LocalMultiProcConfig.QZONE_PERMISSION_PUBLIC, z16, LoginData.getInstance().getUin());
        }
    }

    public void Kb() {
        if (La()) {
            if (this.f58696f == null) {
                xb("none");
            } else {
                xb("0");
            }
            this.F.setVisibility(0);
            return;
        }
        QZLog.d("QZonePublishSyncQCirclePart", 1, "tryShowPreview but cameraResReady is false");
        this.F.setVisibility(8);
        LpReportInfo_pf00064.allReport(586, 62, 6);
    }

    public boolean Ma() {
        return this.P;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublishSyncQCirclePart";
    }

    public void ha() {
        if (this.N == null) {
            RFWLog.e("QZonePublishSyncQCirclePart", RFWLog.USR, "sync bubble manager is null");
        } else if (mb() && Ra()) {
            n nVar = this.N;
            nVar.b(1, nVar.g());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        String str2;
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "event_on_send_mood")) {
            if (obj instanceof String) {
                str2 = (String) obj;
            } else {
                str2 = "";
            }
            ra(str2);
            return;
        }
        if (TextUtils.equals(str, "input_menu_open")) {
            this.Y = true;
        } else if (TextUtils.equals(str, "keyboard_hide")) {
            this.Y = false;
            ga();
        }
    }

    @Override // com.qzone.reborn.base.k, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return (!super.isPartEnable() || ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || zm.d.f452771a.c()) ? false : true;
    }

    public boolean lb() {
        if (!aa() || getActivity() == null || getActivity().getIntent() == null) {
            return false;
        }
        return getActivity().getIntent().getBooleanExtra(PeakConstants.KEY_QZONE_SYNC_CIRCLE, false);
    }

    public boolean mb() {
        return !this.P && aa() && this.C.isChecked();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        Ia(view);
        Ea();
        qb();
        nb();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        Ja();
        this.I = (gm.c) getViewModel(gm.c.class);
        this.J = (hm.b) getViewModel(hm.b.class);
        this.K = (fm.b) getViewModel(fm.b.class);
        this.L = (o) getViewModel(o.class);
        this.M = (bm.a) getViewModel(bm.a.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
    }

    public void pb() {
        if (getPartHost() == null) {
            return;
        }
        Lb();
    }

    public ArrayList<String> rb(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3);
            if (str != null && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void sa(LocalMediaInfo localMediaInfo, Intent intent) {
        if (localMediaInfo == null) {
            QZLog.d("QZonePublishSyncQCirclePart", 1, "editPreviewSucceed exportMediaInfo is null");
            return;
        }
        this.f58693d = localMediaInfo.missionID;
        this.I.b2();
        this.f58695e = !Aa().isEmpty();
        QZLog.d("QZonePublishSyncQCirclePart", 1, "editPreviewSucceed mPreviewMissionId:" + this.f58693d);
    }

    public ArrayList<String> sb(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (String str : list) {
            if (str != null && !str.contains(AEEditorConstants.AE_EDITOR_ZSHOW_TRANSPARENT_FILE_PREFIX)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public QZoneBubbleInfo za() {
        QZoneBubbleInfo qZoneBubbleInfo;
        if (mb() && (qZoneBubbleInfo = this.f58696f) != null && qZoneBubbleInfo.wordsIsTag() && this.D.getVisibility() == 0) {
            return this.f58696f;
        }
        return null;
    }

    public void Eb(Bundle bundle) {
        if (bundle != null) {
            this.R = bundle;
        }
    }

    private void Fa(View view) {
        View findViewById = view.findViewById(R.id.f69703jg);
        this.F = findViewById;
        findViewById.setOnClickListener(new l(this));
        this.G = (TextView) view.findViewById(R.id.f69713jh);
        ImageView imageView = (ImageView) view.findViewById(R.id.f69673jd);
        this.H = imageView;
        s5.a.a(imageView, fd.a.f398306e);
        this.F.setVisibility(8);
    }

    private void Ga(View view) {
        View findViewById = view.findViewById(R.id.f69743jk);
        this.D = findViewById;
        findViewById.setOnClickListener(new l(this));
        TextView textView = (TextView) view.findViewById(R.id.f69753jl);
        this.E = textView;
        textView.setSelected(true);
        view.findViewById(R.id.f69683je).setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.publish.mood.sync.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZonePublishSyncQCirclePart.this.Za(view2);
            }
        });
    }

    private void Ha(View view) {
        Switch r26 = (Switch) view.findViewById(R.id.f69733jj);
        this.C = r26;
        r26.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.publish.mood.sync.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZonePublishSyncQCirclePart.this.ab(view2);
            }
        });
        this.C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.part.publish.mood.sync.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                QZonePublishSyncQCirclePart.this.bb(compoundButton, z16);
            }
        });
    }

    private void Ia(View view) {
        this.f58699m = view.findViewById(R.id.f69723ji);
        Fa(view);
        Ga(view);
        Ha(view);
    }

    public void Ib(int i3, String str) {
        if (i3 == 0) {
            return;
        }
        RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "switch bubble type show is " + i3);
        Hb(str, i3);
    }

    public /* synthetic */ void eb(DynamicArrayList dynamicArrayList) {
        if (dynamicArrayList == null) {
            return;
        }
        dynamicArrayList.getLiveData().observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.sync.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishSyncQCirclePart.this.cb((ArrayList) obj);
            }
        });
    }

    private void vb(boolean z16) {
        int i3;
        if (z16) {
            if (lb()) {
                LpReportInfo_pf00064.allReport(586, 62, 7);
            }
            i3 = 3;
        } else {
            i3 = 4;
        }
        qa(i3);
        if (getActivity() == null || getActivity().getIntent() == null || !z16) {
            return;
        }
        com.qzone.misc.network.report.b.i(getActivity().getIntent(), 3);
    }

    private void ub(String str) {
        LpReportInfo_pf00064.allReport(586, 63, 1, (String) null, str);
    }

    private void wb(int i3) {
        if (i3 == 1) {
            RFWLog.i("QZonePublishSyncQCirclePart", RFWLog.USR, "show memory sync switch bubble");
            u5.c.x(LoginData.getInstance().getUin());
            ub("3");
        } else if (i3 == 2) {
            ub("1");
        } else {
            if (i3 != 3) {
                return;
            }
            uq3.k.a().j("publish_page_sync_qfs_text_to_video_switch_bubble", true);
            ub("2");
        }
    }
}
