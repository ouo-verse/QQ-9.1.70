package com.tencent.mobileqq.troopshare;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.google.zxing.common.BitMatrix;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi;
import com.tencent.mobileqq.troop.api.impl.TroopShareWxMiniProgramApiImpl;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardFragment;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.ab;
import com.tencent.mobileqq.troopshare.e;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneShareManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e implements WXShareHelper.a {
    static IPatchRedirector $redirector_;
    private static long V;
    protected String C;
    protected QBaseActivity D;
    protected TroopInfoData E;
    protected Fragment F;
    protected Bundle G;
    protected InterfaceC8850e H;
    boolean I;
    private boolean J;
    private boolean K;
    List<ShareActionSheetBuilder.ActionSheetItem> L;
    private String M;
    private String N;
    protected QQProgressDialog P;
    protected ShareActionSheet Q;
    protected boolean R;
    protected boolean S;
    protected com.tencent.mobileqq.troop.troopmanager.api.b T;
    com.tencent.qidian.controller.a U;

    /* renamed from: d, reason: collision with root package name */
    protected int f303337d;

    /* renamed from: e, reason: collision with root package name */
    private ShareActionSheetBuilder.ActionSheetItem f303338e;

    /* renamed from: f, reason: collision with root package name */
    protected int f303339f;

    /* renamed from: h, reason: collision with root package name */
    protected String f303340h;

    /* renamed from: i, reason: collision with root package name */
    protected String f303341i;

    /* renamed from: m, reason: collision with root package name */
    protected String f303342m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            e eVar = e.this;
            if (eVar.D == null) {
                return;
            }
            eVar.Q.dismiss();
            int i16 = actionSheetItem.action;
            e eVar2 = e.this;
            eVar2.f303337d = i16;
            eVar2.f303338e = actionSheetItem;
            if (!TextUtils.isEmpty(e.this.E.userFrom)) {
                e.this.Q(i16, "clck");
            }
            if (i16 == 24) {
                Intent intent = new Intent(e.this.D, (Class<?>) Face2FaceAddFriendActivity.class);
                intent.putExtra("activity_from_type", 1);
                intent.putExtra("activity_troop_uin", e.this.E.troopUin);
                e.this.D.startActivity(intent);
                return;
            }
            boolean z17 = false;
            if (i16 == 9 || i16 == 10) {
                if (!WXShareHelper.b0().e0()) {
                    i3 = R.string.f173257ih1;
                } else if (!WXShareHelper.b0().f0()) {
                    i3 = R.string.f173258ih2;
                } else {
                    i3 = -1;
                }
                if (i3 != -1) {
                    e.this.P(false);
                    QBaseActivity qBaseActivity = e.this.D;
                    QQToast.makeText(qBaseActivity, qBaseActivity.getString(i3), 0).show(e.this.D.getTitleBarHeight());
                    e eVar3 = e.this;
                    eVar3.f303337d = 0;
                    eVar3.f303339f = -1;
                    eVar3.f303338e = null;
                    QBaseActivity qBaseActivity2 = e.this.D;
                    if (qBaseActivity2 instanceof TroopCreateLogicActivity) {
                        ((TroopCreateLogicActivity) qBaseActivity2).finish();
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopShareUtility", 2, "onItemClick.chooseChannel: " + i16);
            }
            e eVar4 = e.this;
            if (eVar4.f303337d == 23 && eVar4.E.isMember) {
                eVar4.b0();
                QBaseActivity qBaseActivity3 = e.this.D;
                if (qBaseActivity3 instanceof TroopCreateLogicActivity) {
                    ((TroopCreateLogicActivity) qBaseActivity3).finish();
                    return;
                }
                return;
            }
            TroopManager troopManager = (TroopManager) ((QQAppInterface) eVar4.D.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
            if (e.this.E.isOwnerOrAdim() && !troopManager.V(e.this.E.troopUin)) {
                e eVar5 = e.this;
                if (eVar5.D instanceof TroopCreateLogicActivity) {
                    eVar5.I = true;
                }
                if (TroopInfo.hasPayPrivilege(eVar5.E.mTroopPrivilegeFlag, 128) && TroopInfo.hasPayPrivilege(e.this.E.mTroopPrivilegeFlag, 512)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                e eVar6 = e.this;
                if (eVar6.E.cGroupOption == 1) {
                    z17 = true;
                }
                if (!(z16 | z17)) {
                    eVar6.u();
                    return;
                } else {
                    eVar6.P(true);
                    e.this.t();
                    return;
                }
            }
            e.this.P(true);
            e.this.x();
            e eVar7 = e.this;
            if (eVar7.D instanceof TroopCreateLogicActivity) {
                eVar7.I = false;
            }
            eVar7.f303339f = 0;
            eVar7.c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            e eVar = e.this;
            if (eVar.f303337d == 0) {
                QBaseActivity qBaseActivity = eVar.D;
                if (qBaseActivity instanceof TroopCreateLogicActivity) {
                    ((TroopCreateLogicActivity) qBaseActivity).finish();
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopShareUtility", 2, "mShareActionSheet noItemClick, onDismiss");
                    }
                }
            }
            e.this.x();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c extends com.tencent.mobileqq.troop.troopmanager.api.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x00d2, code lost:
        
            if (r10 != 73) goto L88;
         */
        @Override // com.tencent.mobileqq.troop.troopmanager.api.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTroopShareLink(boolean z16, com.tencent.mobileqq.troop.troopshare.a aVar) {
            String str;
            e eVar;
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
                return;
            }
            e eVar2 = e.this;
            QBaseActivity qBaseActivity = eVar2.D;
            if (qBaseActivity != null) {
                qBaseActivity.removeObserver(eVar2.T);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopShareUtility", 2, "onTroopShareLink TroopShareResp:" + aVar);
            }
            TroopInfoData troopInfoData = e.this.E;
            if (troopInfoData != null && (str = troopInfoData.troopUin) != null && aVar != null && str.equals(aVar.f301553a)) {
                QQProgressDialog qQProgressDialog = e.this.P;
                if (qQProgressDialog != null && qQProgressDialog.isShowing() && (i3 = (eVar = e.this).f303337d) != 0 && (i16 = eVar.f303339f) != -1) {
                    if (z16 && aVar.f301554b == 0) {
                        eVar.f303342m = aVar.f301557e;
                        eVar.M = aVar.f301558f;
                        e.this.N = aVar.f301559g;
                        if (aVar.f301555c) {
                            e eVar3 = e.this;
                            eVar3.f303340h = aVar.f301556d;
                            if (eVar3.f303339f != 0) {
                                QBaseActivity qBaseActivity2 = eVar3.D;
                                if (qBaseActivity2 instanceof TroopCreateLogicActivity) {
                                    ((TroopCreateLogicActivity) qBaseActivity2).finish();
                                    return;
                                }
                                return;
                            }
                        } else {
                            e eVar4 = e.this;
                            eVar4.f303341i = aVar.f301556d;
                            if (eVar4.f303339f != 1) {
                                QBaseActivity qBaseActivity3 = eVar4.D;
                                if (qBaseActivity3 instanceof TroopCreateLogicActivity) {
                                    ((TroopCreateLogicActivity) qBaseActivity3).finish();
                                    return;
                                }
                                return;
                            }
                        }
                        e eVar5 = e.this;
                        int i17 = eVar5.f303337d;
                        if (i17 != 1) {
                            if (i17 != 2) {
                                if (i17 != 3) {
                                    if (i17 != 9) {
                                        if (i17 != 10) {
                                            if (i17 == 72) {
                                                eVar5.I();
                                                if (e.this.f303338e != null) {
                                                    e eVar6 = e.this;
                                                    eVar6.W(Boolean.TRUE, eVar6.f303338e.uin, e.this.f303338e.uinType);
                                                }
                                            }
                                        } else {
                                            eVar5.I();
                                            e.this.V();
                                        }
                                    } else {
                                        eVar5.I();
                                        e.this.Y();
                                    }
                                } else {
                                    eVar5.I();
                                    e.this.X();
                                }
                            }
                            eVar5.I();
                            e.this.W(Boolean.FALSE, "", -1);
                        } else {
                            eVar5.I();
                            e.this.s();
                        }
                    } else {
                        boolean z17 = aVar.f301555c;
                        if (z17 && i16 != 0) {
                            QBaseActivity qBaseActivity4 = eVar.D;
                            if (qBaseActivity4 instanceof TroopCreateLogicActivity) {
                                ((TroopCreateLogicActivity) qBaseActivity4).finish();
                                return;
                            }
                            return;
                        }
                        if (!z17 && i16 != 1) {
                            QBaseActivity qBaseActivity5 = eVar.D;
                            if (qBaseActivity5 instanceof TroopCreateLogicActivity) {
                                ((TroopCreateLogicActivity) qBaseActivity5).finish();
                                return;
                            }
                            return;
                        }
                        InterfaceC8850e interfaceC8850e = eVar.H;
                        if (interfaceC8850e != null) {
                            interfaceC8850e.a(i3, false);
                        }
                        e.this.I();
                        QBaseActivity qBaseActivity6 = e.this.D;
                        if (qBaseActivity6 != null) {
                            QQToast.makeText(qBaseActivity6, 1, qBaseActivity6.getString(R.string.bj6), 0).show(e.this.D.getTitleBarHeight());
                        }
                        e eVar7 = e.this;
                        eVar7.f303337d = 0;
                        eVar7.f303339f = -1;
                        eVar7.f303338e = null;
                    }
                }
                QBaseActivity qBaseActivity7 = e.this.D;
                if (qBaseActivity7 instanceof TroopCreateLogicActivity) {
                    ((TroopCreateLogicActivity) qBaseActivity7).finish();
                    return;
                }
                return;
            }
            QBaseActivity qBaseActivity8 = e.this.D;
            if (qBaseActivity8 instanceof TroopCreateLogicActivity) {
                ((TroopCreateLogicActivity) qBaseActivity8).finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends com.tencent.qidian.controller.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(boolean z16, long j3, String str, String str2) {
            QBaseActivity qBaseActivity;
            e.this.I();
            if (!z16 && (qBaseActivity = e.this.D) != null) {
                QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.bj6), 0).show(e.this.D.getTitleBarHeight());
            } else if (z16 && Objects.equals(e.this.E.troopUin, String.valueOf(j3))) {
                e.this.M = str;
                e.this.N = str2;
                e.this.Y();
            }
        }

        @Override // com.tencent.qidian.controller.a
        protected void l(boolean z16, HashMap<String, Object> hashMap) {
            e eVar;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap);
                return;
            }
            e eVar2 = e.this;
            QBaseActivity qBaseActivity = eVar2.D;
            if (qBaseActivity != null) {
                qBaseActivity.removeObserver(eVar2.U);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopShareUtility", 2, "onQidianGroupInfo start");
            }
            e eVar3 = e.this;
            TroopInfoData troopInfoData = eVar3.E;
            if (troopInfoData != null && troopInfoData.troopUin != null) {
                QQProgressDialog qQProgressDialog = eVar3.P;
                if (qQProgressDialog != null && qQProgressDialog.isShowing() && (i3 = (eVar = e.this).f303337d) != 0 && eVar.f303339f != -1) {
                    if (z16 && hashMap != null) {
                        if (!e.this.E.troopUin.equals((String) hashMap.get("uin"))) {
                            e.this.I();
                            return;
                        }
                        String str = (String) hashMap.get("url");
                        e eVar4 = e.this;
                        eVar4.f303340h = str;
                        int i16 = eVar4.f303337d;
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    if (i16 != 9) {
                                        if (i16 != 10) {
                                            if (i16 == 72) {
                                                eVar4.I();
                                                if (e.this.f303338e != null) {
                                                    e eVar5 = e.this;
                                                    eVar5.W(Boolean.TRUE, eVar5.f303338e.uin, e.this.f303338e.uinType);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        eVar4.I();
                                        e.this.V();
                                        return;
                                    }
                                    if (!((ITroopShareWxMiniProgramApi) QRoute.api(ITroopShareWxMiniProgramApi.class)).enableShareAsMiniProgram()) {
                                        e.this.I();
                                        e.this.Y();
                                        return;
                                    } else {
                                        ((ITroopShareWxMiniProgramApi) QRoute.api(ITroopShareWxMiniProgramApi.class)).getTokenAndJoinGroupAuth(e.this.E.troopUin, new ITroopShareWxMiniProgramApi.a() { // from class: com.tencent.mobileqq.troopshare.f
                                            @Override // com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi.a
                                            public final void a(boolean z17, long j3, String str2, String str3) {
                                                e.d.this.p(z17, j3, str2, str3);
                                            }
                                        });
                                        return;
                                    }
                                }
                                eVar4.I();
                                e.this.X();
                                return;
                            }
                            eVar4.I();
                            e.this.W(Boolean.FALSE, "", -1);
                            return;
                        }
                        eVar4.I();
                        e.this.s();
                        return;
                    }
                    InterfaceC8850e interfaceC8850e = eVar.H;
                    if (interfaceC8850e != null) {
                        interfaceC8850e.a(i3, false);
                    }
                    e.this.I();
                    QBaseActivity qBaseActivity2 = e.this.D;
                    if (qBaseActivity2 != null) {
                        QQToast.makeText(qBaseActivity2, 1, qBaseActivity2.getString(R.string.bj6), 0).show(e.this.D.getTitleBarHeight());
                    }
                    e eVar6 = e.this;
                    eVar6.f303337d = 0;
                    eVar6.f303339f = -1;
                    eVar6.f303338e = null;
                    return;
                }
                return;
            }
            QBaseActivity qBaseActivity3 = eVar3.D;
            if (qBaseActivity3 instanceof TroopCreateLogicActivity) {
                ((TroopCreateLogicActivity) qBaseActivity3).finish();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troopshare.e$e, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC8850e {
        void a(int i3, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            V = 0L;
        }
    }

    public e(QBaseActivity qBaseActivity, TroopInfoData troopInfoData) {
        this(qBaseActivity, troopInfoData, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) troopInfoData);
    }

    public static String A(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return context.getString(R.string.hjq);
        }
        return str;
    }

    public static Bitmap B(String str, Resources resources) {
        return C(str, resources, 540, 70, true);
    }

    public static Bitmap C(String str, Resources resources, int i3, int i16, boolean z16) {
        Bitmap createBitmap;
        int i17;
        long currentTimeMillis = System.currentTimeMillis();
        BitMatrix o16 = h.o(str, -1);
        int width = o16.getWidth();
        int[] iArr = new int[width * width];
        for (int i18 = 0; i18 < width; i18++) {
            int i19 = i18 * width;
            for (int i26 = 0; i26 < width; i26++) {
                int i27 = i19 + i26;
                if (o16.get(i26, i18)) {
                    i17 = -16777216;
                } else {
                    i17 = 16777215;
                }
                iArr[i27] = i17;
            }
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        createBitmap2.setPixels(iArr, 0, width, 0, 0, width, width);
        try {
            createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("TroopShareUtility", 2, e16.getMessage());
                }
                return null;
            }
        }
        if (createBitmap == null) {
            createBitmap2.recycle();
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 600.0f, -657931, -1513240, Shader.TileMode.REPEAT));
        float f16 = i3;
        canvas.drawRect(0.0f, 0.0f, f16, f16, paint);
        int i28 = i3 - i16;
        canvas.drawBitmap(createBitmap2, (Rect) null, new Rect(i16, i16, i28, i28), (Paint) null);
        if (z16) {
            int i29 = (i3 - 106) / 2;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            int i36 = i29 + 106;
            Rect rect = new Rect(i29, i29, i36, i36);
            Bitmap g16 = j.g(resources, R.drawable.bfs);
            if (g16 != null) {
                canvas.drawBitmap(g16, (Rect) null, rect, paint2);
                g16.recycle();
            }
        }
        createBitmap2.recycle();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("TroopShareUtility", 2, "getQrCode cost time:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return createBitmap;
    }

    private String E() {
        int i3 = this.f303339f;
        if (i3 == -1) {
            return null;
        }
        if (i3 == 0) {
            return this.f303340h;
        }
        return this.f303341i;
    }

    public static void F(QQAppInterface qQAppInterface, Activity activity, int i3, Intent intent) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.share", 2, "handleShareQQNow: resultCode=" + i3);
            }
            if (i3 != -1) {
                return;
            }
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), null);
            m3.putExtras(new Bundle(intent.getExtras()));
            ForwardUtils.p(qQAppInterface, activity, ForwardUtils.n0(m3), m3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.share", 2, "handleShareQQNow exception", e16);
            }
        }
    }

    public static void G(QQAppInterface qQAppInterface, Activity activity, int i3, Intent intent) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.share", 2, "handleShareQQStory: resultCode=" + i3);
            }
            if (i3 != -1) {
                return;
            }
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), null);
            m3.putExtras(new Bundle(intent.getExtras()));
            ForwardUtils.p(qQAppInterface, activity, ForwardUtils.n0(m3), m3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.share", 2, "handleShareQQStory exception", e16);
            }
        }
    }

    private boolean J() {
        Bundle bundle = this.G;
        if (bundle == null || !bundle.getBoolean(ITroopShareUtility.START_ACTIVITY_BY_FTAGMENT, false) || this.F == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(Bitmap bitmap, String str, String str2, String str3, String str4) {
        Bitmap troopPreviewBitmap = ((ITroopShareWxMiniProgramApi) QRoute.api(ITroopShareWxMiniProgramApi.class)).getTroopPreviewBitmap(this.D, bitmap, str, str2);
        if (troopPreviewBitmap == null) {
            WXShareHelper.b0().J0(String.valueOf(System.currentTimeMillis()), str, bitmap, str2, str3);
            return;
        }
        String str5 = this.M;
        String str6 = this.N;
        try {
            str5 = URLEncoder.encode(str5, "UTF-8");
            str6 = URLEncoder.encode(this.N, "UTF-8");
        } catch (Exception e16) {
            QLog.e("TroopShareUtility", 1, "[doShareToWXFriend] e = " + e16);
        }
        String str7 = str6;
        WXShareHelper.b0().I0("pagesShare/groupProfile/groupProfile?groupCode=" + str4 + "&token=" + str5 + "&joinGroupAuth=" + str7, TroopShareWxMiniProgramApiImpl.QQ_MINI_PROGRAM_ID, troopPreviewBitmap, HardCodeUtil.qqStr(R.string.f181213d6), "", str3);
        if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "[doShareToWXFriend] troopUin = " + str4 + ", joinGroupToken = " + this.M + ", joinGroupAuthority = " + this.N + ", encodeToken = " + str5 + ", encodeAuth = " + str7 + ", shareLink = " + str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit L() {
        QLog.d("TroopShareUtility", 1, "doOnActivityDestroy act=" + this.D);
        QBaseActivity qBaseActivity = this.D;
        if (qBaseActivity != null) {
            qBaseActivity.removeObserver(this.U);
            this.D.removeObserver(this.T);
            this.D = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit M(String str, Bitmap bitmap, String str2, TroopMemberNickInfo troopMemberNickInfo) {
        String str3;
        if (troopMemberNickInfo != null) {
            str3 = troopMemberNickInfo.getShowName();
        } else {
            str3 = this.E.troopowneruin;
        }
        WXShareHelper.b0().K0(this.C, str, bitmap, HardCodeUtil.qqStr(R.string.f172861ur4) + str3, str2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(DialogInterface dialogInterface) {
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3, String str) {
        TroopInfoData troopInfoData = this.E;
        if (troopInfoData != null && !TextUtils.isEmpty(troopInfoData.userFrom)) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", "pg_group_share");
            hashMap.put("eid", "em_group_share_btn");
            hashMap.put("group_id", this.E.troopUin);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.E.userFrom);
            hashMap.put("cur_pg", hashMap2);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 23) {
                                    hashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "other");
                                } else {
                                    hashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, QCircleDaTongConstant.ElementParamValue.QRCODE);
                                }
                            } else {
                                hashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "moments");
                            }
                        } else {
                            hashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "wechat_friend");
                        }
                    } else {
                        hashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "space");
                    }
                } else {
                    hashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "qq_friend");
                }
            } else {
                hashMap.put(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, "copy");
            }
            VideoReport.reportEvent(str, hashMap);
        }
    }

    public static void S(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.share", 2, "shareQQGroupVideoToQQ failed, ark body is empty");
                return;
            }
            return;
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("view");
            String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            String optString4 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            String optString5 = jSONObject.optString("prompt");
            String optString6 = jSONObject.optString("ver");
            String optString7 = jSONObject.optString("desc");
            JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
            intent.putExtra("forward_type", 27);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", optString);
            intent.putExtra("forward_ark_app_view", optString2);
            intent.putExtra("forward_ark_biz_src", optString3);
            intent.putExtra("forward_ark_app_ver", optString6);
            intent.putExtra("forward_ark_app_prompt", optString5);
            intent.putExtra("forward_ark_app_meta", optString4);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString7);
            if (optJSONObject != null) {
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optJSONObject.toString());
            }
            intent.putExtra("appName", optString);
            intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString2);
            intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString6);
            intent.putExtra(QQCustomArkDialogUtil.META_DATA, optString4);
            activity.startActivity(intent);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.share", 2, "shareQQGroupVideoToQQ failed, error msg = " + e16.getMessage());
            }
        }
    }

    public static void T(Activity activity, Bundle bundle, int i3) {
        try {
            AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(132).d(bundle.getString("summary")).j(bundle.getString("targetUrl")).c(1105290942L).a();
            a16.mMsgBrief = bundle.getString("summary");
            a16.mContentSummary = bundle.getString("summary");
            a16.mContentTitle = bundle.getString("title");
            String string = bundle.getString("sourcename");
            if (TextUtils.isEmpty(string)) {
                a16.mSourceName = "NOW";
            } else if (string.equals("null")) {
                a16.mSourceName = "";
            } else {
                a16.mSourceName = string;
            }
            String string2 = bundle.getString("sourceIcon");
            if (TextUtils.isEmpty(string2)) {
                string2 = "";
            }
            a16.mSourceIcon = string2;
            a16.mSourceAction = "";
            a16.mMsgUrl = bundle.getString("targetUrl");
            a16.mContentCover = bundle.getString("imageUrl");
            if (!TextUtils.isEmpty(bundle.getString("msgActionData"))) {
                a16.mMsgActionData = bundle.getString("msgActionData");
                a16.mMsgAction = "plugin";
            }
            String string3 = bundle.getString("liveActionData");
            if (!TextUtils.isEmpty(string3)) {
                a16.mMsgActionData = string3;
                a16.mMsgAction = "web";
            }
            com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(2);
            c16.o(bundle.getString("imageUrl"), bundle.getString("title"), bundle.getString("summary"));
            a16.addItem(c16);
            Intent intent = new Intent();
            intent.putExtra("forward_type", -3);
            intent.putExtra("emoInputType", 2);
            intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
            ForwardBaseOption.startForwardActivityForResult(activity, intent, i3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.share", 2, "shareStoryToQQ exception", e16);
            }
        }
    }

    public static void U(Activity activity, MessageForQQStory messageForQQStory, int i3) {
        try {
            AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(80).d(messageForQQStory.brief).j("").a();
            if (messageForQQStory.briefBgColor == 0) {
                messageForQQStory.briefBgColor = Color.parseColor("#d8000000");
            }
            messageForQQStory.briefBgColor = (messageForQQStory.briefBgColor & 16777215) | (-671088640);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MessageForQQStory.KEY_COVER_IMG_URL, messageForQQStory.coverImgUrl);
                jSONObject.put(MessageForQQStory.KEY_LOGO_IMG_URL, messageForQQStory.logoImgUrl);
                jSONObject.put("briefBgColor", messageForQQStory.briefBgColor);
                jSONObject.put(MessageForQQStory.KEY_AUTHOR_NAME, messageForQQStory.authorName);
                jSONObject.put("type", messageForQQStory.type);
                jSONObject.put("vid", messageForQQStory.mVid);
                jSONObject.put(MessageForQQStory.KEY_HEAD_TIP, messageForQQStory.mHeadTip);
                jSONObject.put(MessageForQQStory.KEY_STORY_TITLE, messageForQQStory.storyTitle);
                jSONObject.put(MessageForQQStory.KEY_STORY_BRIEF, messageForQQStory.storyBrief);
                a16.mQQStoryExtra = jSONObject.toString();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            a16.mCompatibleText = MessageForQQStory.buildCompatibleText(messageForQQStory.authorName, messageForQQStory.brief, messageForQQStory.srcName);
            a16.mMsgBrief = messageForQQStory.brief;
            a16.mSourceName = messageForQQStory.srcName;
            a16.mSourceAction = messageForQQStory.srcAction;
            a16.mMsgAction = messageForQQStory.msgAction;
            Intent intent = new Intent();
            intent.putExtra("forward_type", 28);
            intent.putExtra("emoInputType", 2);
            intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
            ForwardBaseOption.startForwardActivityForResult(activity, intent, i3);
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.share", 2, "shareStoryToQQ: " + messageForQQStory.toString() + ", compatibleTxt=" + a16.mCompatibleText + ", qqstoryExtra=" + a16.mQQStoryExtra);
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.share", 2, "shareStoryToQQ exception", e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        final String str;
        if (this.D == null) {
            return;
        }
        this.C = String.valueOf(System.currentTimeMillis());
        QQAppInterface qQAppInterface = (QQAppInterface) this.D.getAppRuntime();
        final Bitmap r16 = r(qQAppInterface.getTroopFaceBitmap(this.E.troopUin, (byte) 3, false, false));
        final String E = E();
        String str2 = this.E.troopName;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.E.troopUin;
        }
        TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.E.troopUin);
        if (B != null && !B.hasSetTroopName() && B.wMemberNum > 0) {
            str = str2 + "(" + B.wMemberNum + ")";
        } else {
            str = str2;
        }
        String str3 = this.E.mRichFingerMemo;
        WXShareHelper.b0().A(this);
        if (TextUtils.isEmpty(str3)) {
            ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
            TroopInfoData troopInfoData = this.E;
            iTroopMemberListRepoApi.fetchTroopMemberName(troopInfoData.troopUin, troopInfoData.troopowneruin, "TroopShareUtility", new Function1() { // from class: com.tencent.mobileqq.troopshare.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit M;
                    M = e.this.M(str, r16, E, (TroopMemberNickInfo) obj);
                    return M;
                }
            });
        } else {
            WXShareHelper.b0().K0(this.C, str, r16, str3, E);
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "shareToFriendCircle.transaction: " + this.C + " troopname:" + this.E.troopName + " memo:" + this.E.mRichFingerMemo + " shareLink:" + E);
        }
        this.f303339f = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Boolean bool, String str, int i3) {
        if (this.D == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopShareUtility", 2, "shareToMobileQQ mBaseActivity is null");
                return;
            }
            return;
        }
        Intent parseArkJson = ((ITroopShareApi) QRoute.api(ITroopShareApi.class)).parseArkJson(z());
        parseArkJson.putExtra("isFromAIO", this.K);
        if (!this.J) {
            parseArkJson.putExtra("forward_type", -3);
        }
        if (bool.booleanValue() && !TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            bundle.putInt("key_direct_show_uin_type", i3);
            bundle.putString("key_direct_show_uin", str);
            parseArkJson.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(this.D, parseArkJson, (Class<?>) ForwardRecentTranslucentActivity.class, 3, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "biz_src_jc_aio");
        } else if (!bool.booleanValue() && J()) {
            parseArkJson.setClass(this.F.getContext(), ForwardRecentActivity.class);
            parseArkJson.putExtra("caller_name", this.F.getClass().getSimpleName());
            parseArkJson.putExtra("forward_source_business_type", -1);
            parseArkJson.putExtra("forward_source_sub_business_type", "");
            this.F.startActivityForResult(parseArkJson, 3);
        } else if (!bool.booleanValue()) {
            ForwardBaseOption.startForwardActivityForResult(this.D, parseArkJson, 3);
        }
        QBaseActivity qBaseActivity = this.D;
        if (qBaseActivity instanceof TroopCreateLogicActivity) {
            ((TroopCreateLogicActivity) qBaseActivity).f300128e0 = true;
        }
        this.f303337d = 0;
        this.f303339f = -1;
        this.f303338e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        QBaseActivity qBaseActivity = this.D;
        if (qBaseActivity == null) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) qBaseActivity.getAppRuntime();
        TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.E.troopUin);
        String E = E();
        String avatarAddress = ((ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", this.E.troopUin, 0);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(avatarAddress)) {
            arrayList.add(avatarAddress);
        }
        String str = this.E.troopName;
        if (TextUtils.isEmpty(str)) {
            str = this.E.troopUin;
        }
        if (B != null && !B.hasSetTroopName() && B.getMemberNumClient() > 0) {
            str = str + "(" + B.wMemberNum + ")";
        }
        String str2 = String.format(this.D.getString(R.string.hjj), str) + "(" + this.E.troopUin + ")" + E();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        String str3 = this.E.mRichFingerMemo;
        if (TextUtils.isEmpty(str3)) {
            str3 = D();
        }
        bundle.putString("desc", str3);
        bundle.putLong("req_share_id", 0L);
        bundle.putString("detail_url", E);
        bundle.putString("url", E);
        bundle.putStringArrayList("image_url", arrayList);
        bundle.putString(AppConstants.Key.SHARE_REQ_TROOP_WORDING, str2);
        bundle.putString(AppConstants.Key.SHARE_REQ_BIZNAME, "JoinTroopLink");
        QZoneShareManager.jumpToQzoneShare(qQAppInterface, this.D, bundle, (DialogInterface.OnDismissListener) null, 145);
        if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "shareToQzone.troopname:" + this.E.troopName + " shareLink:" + E + " desc:" + str3);
        }
        this.f303337d = 0;
        this.f303339f = -1;
        this.f303338e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        if (this.D == null) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        TroopInfo k3 = ((TroopManager) ((QQAppInterface) this.D.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).k(this.E.troopUin);
        String str = this.E.troopName;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        if (TextUtils.isEmpty(stringBuffer)) {
            stringBuffer.append(this.E.troopUin);
        }
        if (k3 != null && !k3.hasSetTroopName() && k3.getMemberNumClient() > 0) {
            stringBuffer.append("(");
            stringBuffer.append(k3.getMemberNumClient());
            stringBuffer.append(")");
        }
        String str2 = this.E.mRichFingerMemo;
        if (TextUtils.isEmpty(str2)) {
            str2 = D();
        }
        String A = A(str2, this.D);
        String E = E();
        v(E, A, stringBuffer.toString());
        if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "shareToWXFriend.transaction: " + valueOf + " troopname:" + this.E.troopName + " memo:" + str2 + " shareLink:" + E);
        }
        this.f303339f = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c0() {
        String str;
        String str2;
        String str3;
        boolean isNetSupport;
        ShareActionSheetBuilder.ActionSheetItem actionSheetItem;
        boolean z16;
        if (this.D == null) {
            return;
        }
        boolean z17 = false;
        if ((!TroopInfo.hasPayPrivilege(this.E.mTroopPrivilegeFlag, 128) || !TroopInfo.hasPayPrivilege(this.E.mTroopPrivilegeFlag, 512)) && this.E.cGroupOption == 3) {
            QBaseActivity qBaseActivity = this.D;
            QQToast.makeText(qBaseActivity, 0, qBaseActivity.getString(R.string.i7i), 0).show(this.D.getTitleBarHeight());
            return;
        }
        if (!this.E.isOwnerOrAdim()) {
            TroopInfoData troopInfoData = this.E;
            if (troopInfoData.isMember && (troopInfoData.dwGroupFlagExt & 128) != 0) {
                QBaseActivity qBaseActivity2 = this.D;
                QQToast.makeText(qBaseActivity2, 0, qBaseActivity2.getString(R.string.f181203d5), 0).show(this.D.getTitleBarHeight());
                return;
            }
        }
        if (this.f303339f == 1) {
            str = "0";
        } else {
            str = "1";
        }
        String str4 = str;
        int i3 = this.f303337d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            str3 = "";
                            QQAppInterface qQAppInterface = (QQAppInterface) this.D.getAppRuntime();
                            ReportController.o(qQAppInterface, "CliOper", "", "", "Grp", str3, 0, 0, str4, "", "", "");
                            isNetSupport = NetworkUtil.isNetSupport(BaseApplication.getContext());
                            if (isNetSupport && this.f303337d != 1) {
                                QBaseActivity qBaseActivity3 = this.D;
                                QQToast.makeText(qBaseActivity3, qBaseActivity3.getString(R.string.b3j), 0).show(this.D.getTitleBarHeight());
                                if (QLog.isColorLevel()) {
                                    QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
                                }
                                InterfaceC8850e interfaceC8850e = this.H;
                                if (interfaceC8850e != null) {
                                    interfaceC8850e.a(this.f303337d, false);
                                }
                                this.f303337d = 0;
                                this.f303339f = -1;
                                this.f303338e = null;
                                QBaseActivity qBaseActivity4 = this.D;
                                if (qBaseActivity4 instanceof TroopCreateLogicActivity) {
                                    ((TroopCreateLogicActivity) qBaseActivity4).finish();
                                    return;
                                }
                                return;
                            }
                            if (E() != null) {
                                if (!isNetSupport && this.f303337d == 1) {
                                    QBaseActivity qBaseActivity5 = this.D;
                                    QQToast.makeText(qBaseActivity5, qBaseActivity5.getString(R.string.b3j), 0).show(this.D.getTitleBarHeight());
                                    if (QLog.isColorLevel()) {
                                        QLog.i("TroopShareUtility", 2, "tryToGetShareLink: net is not supported");
                                    }
                                    InterfaceC8850e interfaceC8850e2 = this.H;
                                    if (interfaceC8850e2 != null) {
                                        interfaceC8850e2.a(this.f303337d, false);
                                    }
                                    this.f303337d = 0;
                                    this.f303339f = -1;
                                    this.f303338e = null;
                                    QBaseActivity qBaseActivity6 = this.D;
                                    if (qBaseActivity6 instanceof TroopCreateLogicActivity) {
                                        ((TroopCreateLogicActivity) qBaseActivity6).finish();
                                        return;
                                    }
                                    return;
                                }
                                a0();
                                if (this.E.isQidianPrivateTroop) {
                                    QidianHandler qidianHandler = (QidianHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
                                    TroopInfoData troopInfoData2 = this.E;
                                    qidianHandler.M2(troopInfoData2.troopUin, troopInfoData2.troopowneruin);
                                    return;
                                }
                                com.tencent.mobileqq.troop.troopmanager.api.a aVar = (com.tencent.mobileqq.troop.troopmanager.api.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
                                String str5 = this.E.troopUin;
                                if (this.f303339f == 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                int i16 = this.f303337d;
                                if (i16 == 9) {
                                    z17 = true;
                                }
                                aVar.e(str5, z16, z17, i16);
                                return;
                            }
                            int i17 = this.f303337d;
                            if (i17 != 1) {
                                if (i17 != 2) {
                                    if (i17 != 3) {
                                        if (i17 != 9) {
                                            if (i17 != 10) {
                                                if (i17 == 72 && (actionSheetItem = this.f303338e) != null) {
                                                    W(Boolean.TRUE, actionSheetItem.uin, actionSheetItem.uinType);
                                                    return;
                                                }
                                                return;
                                            }
                                            V();
                                            return;
                                        }
                                        Y();
                                        return;
                                    }
                                    X();
                                    return;
                                }
                                W(Boolean.FALSE, "", -1);
                                return;
                            }
                            s();
                            return;
                        }
                        str2 = "Grplink_moments";
                    } else {
                        str2 = "Grplink_wechat";
                    }
                } else {
                    str2 = "Grplink_qzone";
                }
            } else {
                str2 = "Grplink_qq";
            }
        } else {
            str2 = "Copy_grplink";
        }
        str3 = str2;
        QQAppInterface qQAppInterface2 = (QQAppInterface) this.D.getAppRuntime();
        ReportController.o(qQAppInterface2, "CliOper", "", "", "Grp", str3, 0, 0, str4, "", "", "");
        isNetSupport = NetworkUtil.isNetSupport(BaseApplication.getContext());
        if (isNetSupport) {
        }
        if (E() != null) {
        }
    }

    public static Bitmap r(Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
            return createBitmap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void s() {
        if (this.D == null) {
            return;
        }
        if (System.currentTimeMillis() - V < 2000) {
            QBaseActivity qBaseActivity = this.D;
            QQToast.makeText(qBaseActivity, 0, qBaseActivity.getString(R.string.zox), 0).show(this.D.getTitleBarHeight());
            return;
        }
        V = System.currentTimeMillis();
        String str = this.E.troopName;
        if (TextUtils.isEmpty(str)) {
            str = this.E.troopUin;
        }
        String format = String.format(this.D.getString(R.string.f171050c02), str, E());
        if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "copyTroopLink.text:" + format);
        }
        ClipboardMonitor.setPrimaryClip((ClipboardManager) this.D.getSystemService("clipboard"), ClipData.newPlainText("troop_url", format));
        QBaseActivity qBaseActivity2 = this.D;
        QQToast.makeText(qBaseActivity2, 2, qBaseActivity2.getString(R.string.aew), 0).show(this.D.getTitleBarHeight());
        InterfaceC8850e interfaceC8850e = this.H;
        if (interfaceC8850e != null) {
            interfaceC8850e.a(this.f303337d, true);
        }
        this.f303337d = 0;
        this.f303339f = -1;
        this.f303338e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.S) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopShareUtility", 2, "OnClick.chooseLinkType: " + this.f303339f);
        }
        this.f303339f = 0;
        this.S = true;
        P(true);
        c0();
    }

    private void v(final String str, final String str2, final String str3) {
        final String str4 = this.E.troopUin;
        final Bitmap r16 = r(((QQAppInterface) this.D.getAppRuntime()).getTroopFaceBitmap(this.E.troopUin, (byte) 3, false, false));
        if (!((ITroopShareWxMiniProgramApi) QRoute.api(ITroopShareWxMiniProgramApi.class)).enableShareAsMiniProgram()) {
            WXShareHelper.b0().J0(String.valueOf(System.currentTimeMillis()), str3, r16, str2, str);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troopshare.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.K(r16, str3, str2, str, str4);
                }
            });
        }
    }

    private void w() {
        TroopInfoData troopInfoData = this.E;
        if (troopInfoData != null && !TextUtils.isEmpty(troopInfoData.userFrom)) {
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", "pg_group_share");
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.E.userFrom);
            VideoReport.reportEvent("pgin", hashMap);
            List<ShareActionSheetBuilder.ActionSheetItem> list = this.L;
            if (list != null && list.size() > 0) {
                Iterator<ShareActionSheetBuilder.ActionSheetItem> it = this.L.iterator();
                while (it.hasNext()) {
                    Q(it.next().action, "imp");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        TroopInfoData troopInfoData = this.E;
        if (troopInfoData != null && !TextUtils.isEmpty(troopInfoData.userFrom)) {
            List<ShareActionSheetBuilder.ActionSheetItem> list = this.L;
            if (list != null && list.size() > 0) {
                Iterator<ShareActionSheetBuilder.ActionSheetItem> it = this.L.iterator();
                while (it.hasNext()) {
                    Q(it.next().action, "imp_end");
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("dt_pgid", "pg_group_share");
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.E.userFrom);
            VideoReport.reportEvent("pgout", hashMap);
        }
    }

    public static List<ShareActionSheetBuilder.ActionSheetItem>[] y(Context context, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
        if (z16) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(23));
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    private String z() {
        return this.f303342m;
    }

    public String D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).getTroopShareDescDefaultWording();
    }

    public void H(TroopInfoData troopInfoData, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopInfoData, (Object) bool);
            return;
        }
        QBaseActivity qBaseActivity = this.D;
        if (qBaseActivity == null) {
            return;
        }
        ReportController.o((QQAppInterface) qBaseActivity.getAppRuntime(), "CliOper", "", "", "Grp", "Clk_share_grplink", 0, 0, "", "", "", "");
        this.E = troopInfoData;
        this.K = bool.booleanValue();
        Z();
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            QQProgressDialog qQProgressDialog = this.P;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.P.dismiss();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopShareUtility", 2, e16.toString());
            }
        }
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.H = null;
        QBaseActivity qBaseActivity = this.D;
        if (qBaseActivity != null) {
            qBaseActivity.removeObserver(this.U);
            this.D.removeObserver(this.T);
            this.D = null;
        }
        this.E = null;
        this.F = null;
        this.G = null;
    }

    protected void P(boolean z16) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        int i3 = this.f303337d;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 9) {
                    if (i3 != 10) {
                        str = null;
                    } else {
                        str = "share_circle";
                    }
                } else {
                    str = "share_wechat";
                }
            } else {
                str = "share_qzone";
            }
        } else {
            str = "share_qq";
        }
        if (!TextUtils.isEmpty(str)) {
            TroopInfoData troopInfoData = this.E;
            String str3 = "1";
            if (troopInfoData.bOwner) {
                str2 = "0";
            } else if (troopInfoData.bAdmin) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            q d16 = new q(null).i("P_CliOper").a("Grp_set").f("Grp_data").d(str);
            String[] strArr = new String[3];
            strArr[0] = this.E.troopUin;
            if (z16) {
                str3 = "0";
            }
            strArr[1] = str3;
            strArr[2] = str2;
            d16.b(strArr).g();
        }
    }

    public void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.J = z16;
        }
    }

    protected void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        a aVar = new a();
        if (this.Q == null && this.D != null) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            QBaseActivity qBaseActivity = this.D;
            param.context = qBaseActivity;
            Intent intent = qBaseActivity.getIntent();
            if (intent != null && TextUtils.isEmpty(intent.getStringExtra("big_brother_source_key"))) {
                intent.putExtra("big_brother_source_key", "biz_src_unknown");
            }
            ShareActionSheet create = ShareActionSheetFactory.create(param);
            this.Q = create;
            create.setActionSheetTitle(this.D.getString(R.string.hja));
            this.Q.setRowVisibility(0, 0, 0);
            this.Q.setIntentForStartForwardRecentActivity(new Intent());
            List<ShareActionSheetBuilder.ActionSheetItem>[] y16 = y(this.D, this.E.isMember);
            this.Q.setActionSheetItems(y16);
            for (List<ShareActionSheetBuilder.ActionSheetItem> list : y16) {
                this.L.addAll(list);
            }
            this.Q.setOnDismissListener(new b());
            this.Q.setItemClickListenerV2(aVar);
            this.Q.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.troopshare.a
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    e.this.N(dialogInterface);
                }
            });
        }
        try {
            ShareActionSheet shareActionSheet = this.Q;
            if (shareActionSheet != null) {
                shareActionSheet.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + e16);
            }
        }
    }

    public void a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            if (this.P == null && this.D != null) {
                QBaseActivity qBaseActivity = this.D;
                QQProgressDialog qQProgressDialog = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
                this.P = qQProgressDialog;
                qQProgressDialog.setMessage(R.string.cpr);
                this.P.setBackAndSearchFilter(false);
            }
            QQProgressDialog qQProgressDialog2 = this.P;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopShareUtility", 2, e16.toString());
            }
        }
    }

    public void b0() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.D == null) {
            return;
        }
        TroopInfoData troopInfoData = this.E;
        Intent intent = new Intent(this.D, (Class<?>) QRDisplayActivity.class);
        intent.putExtra("title", HardCodeUtil.qqStr(R.string.uqz));
        if (TextUtils.isEmpty(troopInfoData.troopName)) {
            intent.putExtra("nick", troopInfoData.newTroopName);
        } else {
            intent.putExtra("nick", troopInfoData.troopName);
        }
        intent.putExtra("uin", troopInfoData.troopUin);
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopInfoData.troopUin);
        if (troopInfoFromCache != null && troopInfoFromCache.isNeedInterceptOnBlockTroop()) {
            ab.c(this.D);
            return;
        }
        if (troopInfoData.bOwner) {
            i3 = 0;
        } else if (troopInfoData.bAdmin) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        intent.putExtra("adminLevel", i3);
        intent.putExtra("type", 2);
        intent.putExtra("GroupFlagExt", troopInfoData.dwGroupFlagExt);
        intent.putExtra("AuthGroupType", troopInfoData.dwAuthGroupType);
        intent.putExtra("my_qrcode_pg_source", "1001");
        boolean V2 = ((TroopManager) ((QQAppInterface) this.D.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).V(this.E.troopUin);
        intent.putExtra("market_channel_source_item", this.E.channelSourceItem);
        intent.putExtra("isQidianPrivateTroop", V2);
        if (V2) {
            intent.putExtra("groupOwner", this.E.troopowneruin);
        }
        QLog.i("TroopShareUtility", 1, "startTroop2DCode new page");
        intent.putExtra("troopInfoData", troopInfoData);
        QPublicFragmentActivity.start(this.D, intent, QRDisplayTroopCardFragment.class);
    }

    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
    public void onWXShareResp(BaseResp baseResp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) baseResp);
            return;
        }
        String str = this.C;
        if (str != null && str.equals(baseResp.transaction) && this.D != null) {
            InterfaceC8850e interfaceC8850e = this.H;
            if (interfaceC8850e != null) {
                int i3 = this.f303337d;
                if (baseResp.errCode == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                interfaceC8850e.a(i3, z16);
            }
            this.f303337d = 0;
            int i16 = baseResp.errCode;
            if (i16 != -2) {
                if (i16 != 0) {
                    QBaseActivity qBaseActivity = this.D;
                    QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.hit), 0).show(this.D.getTitleBarHeight());
                } else {
                    QBaseActivity qBaseActivity2 = this.D;
                    QQToast.makeText(qBaseActivity2, 2, qBaseActivity2.getString(R.string.hj9), 0).show(this.D.getTitleBarHeight());
                }
            }
            WXShareHelper.b0().q0(this);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f303339f = 0;
            c0();
        }
    }

    public e(QBaseActivity qBaseActivity, TroopInfoData troopInfoData, InterfaceC8850e interfaceC8850e) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, troopInfoData, interfaceC8850e);
            return;
        }
        this.f303337d = 0;
        this.f303339f = -1;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = new ArrayList();
        this.Q = null;
        this.R = false;
        this.S = false;
        this.T = new c();
        d dVar = new d();
        this.U = dVar;
        this.D = qBaseActivity;
        this.E = troopInfoData;
        if (qBaseActivity != null) {
            qBaseActivity.addObserver(dVar);
            this.D.addObserver(this.T);
            g.a(this.D, new Function0() { // from class: com.tencent.mobileqq.troopshare.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit L;
                    L = e.this.L();
                    return L;
                }
            });
        }
        this.H = interfaceC8850e;
    }

    public e(QBaseActivity qBaseActivity, TroopInfoData troopInfoData, InterfaceC8850e interfaceC8850e, Fragment fragment, Bundle bundle) {
        this(qBaseActivity, troopInfoData, interfaceC8850e);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qBaseActivity, troopInfoData, interfaceC8850e, fragment, bundle);
        } else {
            this.F = fragment;
            this.G = bundle;
        }
    }
}
