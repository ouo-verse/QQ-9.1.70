package com.tencent.mobileqq.troop.troopcard.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.handler.TroopModifyHandler;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.et;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troop.TroopOperationRepo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import cooperation.qzone.api.QZoneContant;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopInfoActivity extends QIphoneTitleBarActivity implements View.OnClickListener, TroopPhotoController.e, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    public static final DownloadParams.DecodeHandler N0;
    private boolean A0;
    protected long B0;
    com.tencent.mobileqq.data.troop.b C0;
    AppInterface D0;
    private final com.tencent.mobileqq.troop.api.observer.a E0;
    Handler F0;
    com.tencent.mobileqq.troop.observer.c G0;
    com.tencent.mobileqq.troop.api.observer.e H0;
    com.tencent.mobileqq.troop.api.observer.b I0;
    protected QQProgressDialog J0;
    protected View K0;
    protected View L0;
    Observer M0;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f299886a0;

    /* renamed from: b0, reason: collision with root package name */
    protected LinearLayout f299887b0;

    /* renamed from: c0, reason: collision with root package name */
    protected View[] f299888c0;

    /* renamed from: d0, reason: collision with root package name */
    private TroopBindGameItemHelper f299889d0;

    /* renamed from: e0, reason: collision with root package name */
    protected View f299890e0;

    /* renamed from: f0, reason: collision with root package name */
    protected Button f299891f0;

    /* renamed from: g0, reason: collision with root package name */
    protected TroopInfoData f299892g0;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f299893h0;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f299894i0;

    /* renamed from: j0, reason: collision with root package name */
    protected TroopInfo f299895j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f299896k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f299897l0;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f299898m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f299899n0;

    /* renamed from: o0, reason: collision with root package name */
    public Dialog f299900o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f299901p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f299902q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f299903r0;

    /* renamed from: s0, reason: collision with root package name */
    protected XListView f299904s0;

    /* renamed from: t0, reason: collision with root package name */
    protected String f299905t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f299906u0;

    /* renamed from: v0, reason: collision with root package name */
    private TroopPhotoController f299907v0;

    /* renamed from: w0, reason: collision with root package name */
    private TroopAvatarController f299908w0;

    /* renamed from: x0, reason: collision with root package name */
    public com.tencent.mobileqq.troop.avatar.e f299909x0;

    /* renamed from: y0, reason: collision with root package name */
    protected IFaceDecoder f299910y0;

    /* renamed from: z0, reason: collision with root package name */
    protected boolean f299911z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity$8, reason: invalid class name */
    /* loaded from: classes19.dex */
    public class AnonymousClass8 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass8() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit d(Boolean bool, TroopInfo troopInfo) {
            TroopInfoActivity.this.J3(bool.booleanValue(), troopInfo);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit e(Boolean bool, TroopInfo troopInfo) {
            TroopInfoActivity.this.J3(bool.booleanValue(), troopInfo);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit f(Boolean bool, TroopInfo troopInfo) {
            TroopInfoData troopInfoData;
            if (bool.booleanValue() && (troopInfoData = TroopInfoActivity.this.f299892g0) != null && !TextUtils.isEmpty(troopInfoData.troopUin)) {
                TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                TroopInfo troopInfo2 = troopInfoActivity.f299895j0;
                if (troopInfo2 != null) {
                    troopInfo2.mTags = troopInfo.mTags;
                }
                troopInfoActivity.f299892g0.troopTags = TroopInfo.getTags(troopInfo.mTags);
                TroopInfoActivity.this.F0.sendEmptyMessage(6);
                return null;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TroopInfoData troopInfoData = TroopInfoActivity.this.f299892g0;
            if (troopInfoData == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopInfoActivity", 2, "init mTroopInfoData == null");
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(troopInfoData.troopowneruin)) {
                ITroopCardApi iTroopCardApi = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
                TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                String friendDisplayName = iTroopCardApi.getFriendDisplayName(troopInfoActivity.D0, troopInfoActivity.f299892g0.troopowneruin);
                if (!TextUtils.isEmpty(friendDisplayName) && !friendDisplayName.equals(TroopInfoActivity.this.f299892g0.troopowneruin)) {
                    TroopInfoActivity.this.f299892g0.troopOwnerNick = friendDisplayName;
                } else {
                    ITroopDBUtilsApi iTroopDBUtilsApi = (ITroopDBUtilsApi) QRoute.api(ITroopDBUtilsApi.class);
                    TroopInfoActivity troopInfoActivity2 = TroopInfoActivity.this;
                    AppInterface appInterface = troopInfoActivity2.D0;
                    TroopInfoData troopInfoData2 = troopInfoActivity2.f299892g0;
                    TroopMemberCardInfo troopMemberCardInfo = iTroopDBUtilsApi.getTroopMemberCardInfo(appInterface, troopInfoData2.troopUin, troopInfoData2.troopowneruin);
                    if (troopMemberCardInfo == null) {
                        TroopInfoActivity.this.i3();
                    } else {
                        if (!TextUtils.isEmpty(troopMemberCardInfo.nick)) {
                            str = troopMemberCardInfo.nick;
                        } else if (!TextUtils.isEmpty(troopMemberCardInfo.name)) {
                            str = troopMemberCardInfo.name;
                        } else {
                            str = null;
                        }
                        TroopInfoActivity.this.g3(str);
                    }
                }
            }
            com.tencent.mobileqq.troop.api.handler.h hVar = (com.tencent.mobileqq.troop.api.handler.h) TroopInfoActivity.this.D0.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
            if (hVar != null) {
                TroopInfoActivity troopInfoActivity3 = TroopInfoActivity.this;
                TroopInfoData troopInfoData3 = troopInfoActivity3.f299892g0;
                boolean z16 = troopInfoData3.isMember;
                if (!z16 && (i3 = troopInfoData3.f294880pa) != 2 && i3 != 101 && i3 != 102 && i3 != 103 && i3 != 104 && i3 != 105 && i3 != 106 && i3 != 112 && i3 != 113) {
                    hVar.P1(troopInfoData3.troopUin, troopInfoData3.getStatOption());
                } else if (z16) {
                    if (troopInfoData3.f294880pa == 28) {
                        TroopInfoRepo.INSTANCE.fetchLowCreditTroopBasicInfo(troopInfoData3.troopUin, "TroopInfoActivity", troopInfoActivity3, new Function2() { // from class: com.tencent.mobileqq.troop.troopcard.ui.i
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit d16;
                                d16 = TroopInfoActivity.AnonymousClass8.this.d((Boolean) obj, (TroopInfo) obj2);
                                return d16;
                            }
                        });
                    } else {
                        TroopInfoRepo.INSTANCE.fetchTroopBasicInfo(troopInfoData3.troopUin, "TroopInfoActivity", troopInfoActivity3, new Function2() { // from class: com.tencent.mobileqq.troop.troopcard.ui.j
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit e16;
                                e16 = TroopInfoActivity.AnonymousClass8.this.e((Boolean) obj, (TroopInfo) obj2);
                                return e16;
                            }
                        });
                    }
                }
                ITroopCardApi iTroopCardApi2 = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
                TroopInfoActivity troopInfoActivity4 = TroopInfoActivity.this;
                iTroopCardApi2.refreshTroopFace(troopInfoActivity4.D0, troopInfoActivity4.f299892g0.troopUin);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
            }
            com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(Long.toString(TroopInfoActivity.this.f299892g0.dwGroupClassExt));
            if (c16 != null) {
                TroopInfoActivity.this.f299892g0.troopClass = c16.d();
            }
            TroopInfoActivity.this.F0.sendEmptyMessage(5);
            ITroopInfoRepoApi iTroopInfoRepoApi = (ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class);
            TroopInfoActivity troopInfoActivity5 = TroopInfoActivity.this;
            iTroopInfoRepoApi.fetchTroopTags(troopInfoActivity5.f299892g0.troopUin, troopInfoActivity5, new Function2() { // from class: com.tencent.mobileqq.troop.troopcard.ui.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f16;
                    f16 = TroopInfoActivity.AnonymousClass8.this.f((Boolean) obj, (TroopInfo) obj2);
                    return f16;
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String n3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                TroopInfoActivity.this.init();
                return;
            }
            if (i3 == 4) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopInfoActivity", 2, "MSG_UPDATE_INFO");
                }
                TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                TroopInfoData troopInfoData = troopInfoActivity.f299892g0;
                if ((troopInfoData.dwGroupFlagExt & 2048) != 0) {
                    troopInfoActivity.X3(7, troopInfoData.troopAuthenticateInfo, false);
                }
                TroopInfoData troopInfoData2 = TroopInfoActivity.this.f299892g0;
                if (troopInfoData2.troopOwnerNick == null && !TextUtils.isEmpty(troopInfoData2.troopowneruin)) {
                    TroopInfoActivity.this.i4();
                }
                TroopInfoActivity.this.g4();
                TroopInfoActivity.this.h4();
                TroopInfoActivity.this.d4();
                if (TextUtils.isEmpty(TroopInfoActivity.this.f299892g0.mRichFingerMemo)) {
                    n3 = TroopInfoActivity.this.n3();
                } else {
                    n3 = TroopInfoActivity.this.f299892g0.mRichFingerMemo;
                }
                TroopInfoActivity troopInfoActivity2 = TroopInfoActivity.this;
                troopInfoActivity2.X3(6, n3, troopInfoActivity2.f299892g0.isOwnerOrAdim());
                TroopInfoActivity troopInfoActivity3 = TroopInfoActivity.this;
                TroopInfoData troopInfoData3 = troopInfoActivity3.f299892g0;
                if (troopInfoData3.troopClass == null) {
                    long j3 = troopInfoActivity3.B0;
                    if (j3 != -1 && troopInfoData3.dwGroupClassExt != j3) {
                        troopInfoActivity3.f299897l0 = true;
                        troopInfoData3.dwGroupClassExt = j3;
                        troopInfoActivity3.H3(Long.valueOf(j3));
                    }
                    TroopInfoActivity.this.c4();
                    return;
                }
                return;
            }
            if (i3 == 5) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopInfoActivity", 2, "MSG_UPDATE_TROOP_CLASS");
                }
                TroopInfoActivity troopInfoActivity4 = TroopInfoActivity.this;
                TroopInfoData troopInfoData4 = troopInfoActivity4.f299892g0;
                troopInfoActivity4.X3(4, troopInfoData4.troopClass, troopInfoData4.isOwnerOrAdim());
                TroopInfoActivity.this.a4();
                return;
            }
            if (i3 == 6) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopInfoActivity", 2, "MSG_UPDATE_TROOP_TAGS");
                }
                TroopInfoActivity.this.V3(8, TroopInfoActivity.l3(TroopInfoActivity.this.f299892g0), true);
                return;
            }
            if (i3 == 8) {
                TroopInfoActivity.this.Z2();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.troop.observer.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        protected void a(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
                return;
            }
            if (z16 && !TextUtils.isEmpty(str) && Utils.p(str, TroopInfoActivity.this.f299892g0.troopowneruin)) {
                TroopInfoActivity.this.f299894i0 = false;
                ITroopCardApi iTroopCardApi = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
                TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                String friendDisplayName = iTroopCardApi.getFriendDisplayName(troopInfoActivity.D0, troopInfoActivity.f299892g0.troopowneruin);
                if (!TextUtils.isEmpty(friendDisplayName)) {
                    TroopInfoActivity.this.f299892g0.troopOwnerNick = friendDisplayName;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopInfoActivity", 2, "onUpdateFriendInfo|uin = " + str + ", tmpNickName = " + friendDisplayName);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 3) {
                a((String) obj, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGenNewTroopName(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
                return;
            }
            TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
            TroopInfo troopInfo = troopInfoActivity.f299895j0;
            if (troopInfo != null) {
                troopInfoActivity.f299892g0.newTroopName = troopInfo.getTroopDisplayName();
                TroopInfoActivity.this.h4();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetMutilTroopInfoResult(boolean z16, ArrayList<TroopInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), arrayList);
                return;
            }
            if (z16 && arrayList != null && arrayList.size() != 0) {
                TroopInfo troopInfo = null;
                for (int i3 = 0; troopInfo == null && i3 < arrayList.size(); i3++) {
                    troopInfo = arrayList.get(i3);
                    if (troopInfo != null && !Utils.p(troopInfo.troopuin, TroopInfoActivity.this.f299892g0.troopUin)) {
                        troopInfo = null;
                    }
                }
                if (troopInfo != null) {
                    TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                    troopInfoActivity.f299895j0 = troopInfo;
                    troopInfoActivity.f299892g0.updateForTroopInfo(troopInfo, troopInfoActivity.D0.getCurrentAccountUin());
                    TroopInfoActivity.this.F0.sendEmptyMessage(4);
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (z16 && Utils.p(str, TroopInfoActivity.this.f299892g0.troopUin)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopInfoActivity", 2, "onGetTroopInfoResult|uin = " + str);
                }
                TroopInfo findTroopInfo = ((ITroopInfoService) TroopInfoActivity.this.D0.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
                if (findTroopInfo != null) {
                    TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                    troopInfoActivity.f299895j0 = findTroopInfo;
                    troopInfoActivity.f299892g0.updateForTroopInfo(findTroopInfo, troopInfoActivity.D0.getCurrentAccountUin());
                    TroopInfoActivity.this.F0.sendEmptyMessage(4);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void m(boolean z16, byte b16, TroopInfo troopInfo, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Byte.valueOf(b16), troopInfo, Boolean.valueOf(z17));
                return;
            }
            if (z16 && troopInfo != null && Utils.p(troopInfo.troopuin, TroopInfoActivity.this.f299892g0.troopUin)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopInfoActivity", 2, "onTroopSearch|result = " + ((int) b16) + ", p = " + troopInfo);
                }
                if (b16 == 0) {
                    TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                    troopInfoActivity.f299895j0 = troopInfo;
                    troopInfoActivity.f299892g0.updateForTroopInfo(troopInfo, troopInfoActivity.D0.getCurrentAccountUin());
                    TroopInfoActivity.this.F0.sendEmptyMessage(4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ XListView f299921d;

        e(XListView xListView) {
            this.f299921d = xListView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this, (Object) xListView);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f299921d.removeHeaderView(TroopInfoActivity.this.K0);
                TroopInfoActivity.this.K0 = null;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class f implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isColorLevel()) {
                QLog.d("URLDrawableDecodeHandler", 2, "AVATAR_WALL_RECT_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return BaseImageUtil.getClipCenterRectBitmap(bitmap, iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.a
        public void onGetTroopAvatar(boolean z16, String str, int i3, String str2, int i16, List<TroopClipPic> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), list);
                return;
            }
            super.onGetTroopAvatar(z16, str, i3, str2, i16, list);
            if (!TroopInfoActivity.this.isFinishing()) {
                TroopInfoActivity.this.W3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopInfoActivity.this.b3();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopInfoActivity.this.K3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class j implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopInfoActivity.this.W3();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f299927d;

        k(QQCustomDialog qQCustomDialog) {
            this.f299927d = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this, (Object) qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            TroopInfoActivity.this.finish();
            QQCustomDialog qQCustomDialog = this.f299927d;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f299927d.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class l implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
            if (dialogInterface == troopInfoActivity.f299900o0) {
                troopInfoActivity.f299900o0 = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64928);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            N0 = new f();
        }
    }

    public TroopInfoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f299892g0 = new TroopInfoData();
        this.f299893h0 = false;
        this.f299896k0 = false;
        this.f299897l0 = false;
        this.f299898m0 = false;
        this.f299899n0 = -1;
        this.f299905t0 = "";
        this.f299906u0 = false;
        this.f299911z0 = false;
        this.A0 = false;
        this.B0 = -1L;
        this.E0 = new g();
        this.F0 = new a();
        this.G0 = new b();
        this.H0 = new c();
        this.I0 = new d();
        this.M0 = new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.18
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
                }
            }

            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) observable, obj);
                    return;
                }
                if (TroopInfoActivity.this.isFinishing() || !(obj instanceof TroopUploadingThread.b)) {
                    return;
                }
                TroopUploadingThread.b bVar = (TroopUploadingThread.b) obj;
                if (bVar.f294520a == 1) {
                    if (bVar.f294524e == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopInfoActivity", 2, String.format("update isAvatar=%b", Boolean.valueOf(z16)));
                    }
                    if (z16) {
                        TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                        TroopInfoData troopInfoData = troopInfoActivity.f299892g0;
                        troopInfoData.hasSetNewTroopHead = true;
                        if (troopInfoData.hasSetNewTroopName) {
                            troopInfoData.isNewTroop = false;
                        }
                        if (troopInfoData.isUseClassAvatar) {
                            troopInfoData.isUseClassAvatar = false;
                        }
                        TroopInfo troopInfo = troopInfoActivity.f299895j0;
                        if (troopInfo != null) {
                            troopInfo.hasSetNewTroopHead = true;
                            troopInfo.isNewTroop = troopInfoData.isNewTroop;
                            if (troopInfo.isUseClassAvatar()) {
                                TroopOperationRepo.INSTANCE.updateUseClassAvatar(TroopInfoActivity.this.f299895j0.troopuin, false);
                            }
                            TroopInfoActivity.this.e4();
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopInfoActivity", 2, "pullAvatarList");
                        }
                        TroopInfoActivity troopInfoActivity2 = TroopInfoActivity.this;
                        troopInfoActivity2.f299909x0.g(troopInfoActivity2.f299892g0.troopUin);
                    }
                    if (TroopInfoActivity.this.isResume()) {
                        TroopInfoActivity.this.runOnUiThread(new Runnable(bVar) { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.18.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ TroopUploadingThread.b f299914d;

                            {
                                this.f299914d = bVar;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass18.this, (Object) bVar);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else if (this.f299914d.f294524e == 0) {
                                    TroopInfoActivity.this.W3();
                                } else {
                                    TroopInfoActivity.this.U3();
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    private void B3() {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this, RouterConstants.UI_ROUTE_BROWSER);
        Intent intent = new Intent();
        intent.putExtra("url", String.format(IHWTroopUtilsApi.HOMEWORK_TROOP_SCHOOL_MODIFY_URL, this.f299892g0.troopUin, IHWTroopUtilsApi.HOMEWORK_SCHOOL_EDIT_FROM));
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setRequestCode(19);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D3(final String str, final boolean z16, int i3, final String str2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoActivity.this.C3(z16, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E3(TroopMemberInfo troopMemberInfo) {
        String str;
        if (troopMemberInfo != null) {
            if (!TextUtils.isEmpty(troopMemberInfo.friendnick)) {
                str = troopMemberInfo.friendnick;
            } else if (!TextUtils.isEmpty(troopMemberInfo.troopnick)) {
                str = troopMemberInfo.troopnick;
            }
            g3(str);
        }
        str = null;
        g3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit F3(Boolean bool, TroopInfo troopInfo) {
        I3(bool.booleanValue(), troopInfo);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G3(long j3, boolean z16, int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoActivity", 2, "saveTroopInfoAtOnce: modify troop data finished");
        }
        v3(z16, i3, str, j3, this.f299895j0.dwGroupClassExt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H3(Long l3) {
        String str;
        this.C0.q(l3);
        com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(String.valueOf(this.f299892g0.dwGroupClassExt));
        if (c16 == null) {
            str = "";
        } else {
            str = c16.f299960b;
        }
        this.C0.g(str);
    }

    private void I3(boolean z16, TroopInfo troopInfo) {
        hideJuhua();
        TroopInfoData troopInfoData = this.f299892g0;
        if (troopInfoData.f294880pa == 4) {
            return;
        }
        if (z16) {
            short s16 = troopInfo.cGroupOption;
            if (s16 == 4 || s16 == 5) {
                troopInfoData.mStrJoinQuestion = troopInfo.joinTroopQuestion;
                troopInfoData.mStrJoinAnswer = troopInfo.joinTroopAnswer;
            }
            troopInfoData.cGroupOption = (byte) s16;
            r3();
            return;
        }
        notifyUser(R.string.he7, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J3(boolean z16, TroopInfo troopInfo) {
        TroopInfo troopInfo2;
        String str;
        if (z16 && troopInfo != null && (troopInfo2 = this.f299895j0) != null && (str = troopInfo2.troopuin) != null && str.equals(troopInfo.troopuin)) {
            com.tencent.qqnt.inner.compator.troopinfo.b bVar = new com.tencent.qqnt.inner.compator.troopinfo.b();
            bVar.c(this.f299895j0);
            TroopInfo troopInfo3 = this.f299895j0;
            troopInfo3.troopowneruin = troopInfo.troopowneruin;
            troopInfo3.troopname = troopInfo.troopname;
            troopInfo3.troopface = troopInfo.troopface;
            troopInfo3.troopmemo = troopInfo.troopmemo;
            troopInfo3.location = troopInfo.location;
            troopInfo3.grade = troopInfo.grade;
            troopInfo3.school = troopInfo.school;
            troopInfo3.strLocation = troopInfo.strLocation;
            troopInfo3.troopLat = troopInfo.troopLat;
            troopInfo3.troopLon = troopInfo.troopLon;
            troopInfo3.dwGroupFlagExt = troopInfo.dwGroupFlagExt;
            troopInfo3.troopAuthenticateInfo = troopInfo.troopAuthenticateInfo;
            troopInfo3.troopTypeExt = troopInfo.troopTypeExt;
            troopInfo3.dwGroupClassExt = troopInfo.dwGroupClassExt;
            troopInfo3.isNewTroop = troopInfo.isNewTroop;
            troopInfo3.hasSetNewTroopName = troopInfo.hasSetNewTroopName;
            troopInfo3.hasSetNewTroopHead = troopInfo.hasSetNewTroopHead;
            troopInfo3.mTags = troopInfo.mTags;
            troopInfo3.fingertroopmemo = troopInfo.fingertroopmemo;
            if (TextUtils.isEmpty(troopInfo3.mRichFingerMemo)) {
                TroopInfo troopInfo4 = this.f299895j0;
                troopInfo4.mRichFingerMemo = com.tencent.mobileqq.troop.util.a.c(troopInfo4.fingertroopmemo);
            } else {
                TroopInfo troopInfo5 = this.f299895j0;
                troopInfo5.mRichFingerMemo = com.tencent.mobileqq.troop.util.a.c(troopInfo5.mRichFingerMemo);
            }
            TroopInfo troopInfo6 = this.f299895j0;
            this.f299899n0 = troopInfo6.troopTypeExt;
            this.f299892g0.updateForTroopInfo(troopInfo6, this.D0.getCurrentAccountUin());
            if (this.f299899n0 != this.f299892g0.troopTypeExt) {
                this.F0.sendEmptyMessage(8);
            }
            bVar.b(this.f299895j0);
            if (this.f299895j0 != null && this.f299892g0.isMember) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("TroopInfoActivity", 4, "updateTroopInfoToDB");
                }
                ThreadManagerV2.post(new Runnable(bVar) { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.13
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.qqnt.inner.compator.troopinfo.b f299912d;

                    {
                        this.f299912d = bVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this, (Object) bVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f299912d.d();
                        }
                    }
                }, 8, null, true);
            }
            this.F0.sendEmptyMessage(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getApplicationContext(), 1, HardCodeUtil.qqStr(R.string.f235097aq), 0).show();
            return;
        }
        TroopInfoData troopInfoData = this.f299892g0;
        if (troopInfoData == null) {
            return;
        }
        int i3 = troopInfoData.troopTypeExt;
        if (i3 == 0 || i3 == 1) {
            Q3();
        }
    }

    private String M3(int i3) {
        String str = "";
        try {
            JSONArray jSONArray = new JSONObject("{\"datas\":{\"0\":[{\"id\":10,\"text\":\"\u5e7c\u513f\u56ed\",\"subs\":[{\"id\":11,\"text\":\"\u5c0f\u73ed\"},{\"id\":12,\"text\":\"\u4e2d\u73ed\"},{\"id\":13,\"text\":\"\u5927\u73ed\"}]},{\"id\":20,\"text\":\"\u5c0f\u5b66\",\"subs\":[{\"id\":21,\"text\":\"\u4e00\u5e74\u7ea7\"},{\"id\":22,\"text\":\"\u4e8c\u5e74\u7ea7\"},{\"id\":23,\"text\":\"\u4e09\u5e74\u7ea7\"},{\"id\":24,\"text\":\"\u56db\u5e74\u7ea7\"},{\"id\":25,\"text\":\"\u4e94\u5e74\u7ea7\"},{\"id\":26,\"text\":\"\u516d\u5e74\u7ea7\"}]},{\"id\":30,\"text\":\"\u521d\u4e2d\",\"subs\":[{\"id\":31,\"text\":\"\u521d\u4e00\"},{\"id\":32,\"text\":\"\u521d\u4e8c\"},{\"id\":33,\"text\":\"\u521d\u4e09\"}]},{\"id\":40,\"text\":\"\u9ad8\u4e2d\",\"subs\":[{\"id\":41,\"text\":\"\u9ad8\u4e00\"},{\"id\":42,\"text\":\"\u9ad8\u4e8c\"},{\"id\":43,\"text\":\"\u9ad8\u4e09\"}]},{\"id\":50,\"text\":\"\u5176\u4ed6\",\"subs\":[{\"id\":51,\"text\":\"\u666e\u901a\u9ad8\u6821\"},{\"id\":52,\"text\":\"\u4e2d\u804c\u9662\u6821\"},{\"id\":53,\"text\":\"\u57f9\u8bad\u673a\u6784\"}]}]}}").getJSONObject("datas").getJSONArray("0");
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                if (i3 == jSONObject.getInt("id")) {
                    str = jSONObject.getString("text");
                    return str;
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("subs");
                int i17 = 0;
                while (true) {
                    if (i17 < jSONArray2.length()) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i17);
                        if (i3 == jSONObject2.getInt("id")) {
                            str = jSONObject2.getString("text");
                            break;
                        }
                        i17++;
                    }
                }
            }
            return str;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return str;
        }
    }

    private void T3(int i3, boolean z16) {
        View view;
        View findViewById;
        int i16;
        View[] viewArr = this.f299888c0;
        if (i3 < viewArr.length && (view = viewArr[i3]) != null && (findViewById = view.findViewById(R.id.f71983pm)) != null) {
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            findViewById.setVisibility(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U3() {
        View view = this.f299888c0[11];
        if (view != null) {
            if (this.f299892g0.hasSetNewTroopHead) {
                SpannableString spannableString = new SpannableString("[Avatar]");
                Drawable j3 = j3();
                if (j3 != null) {
                    j3.setBounds(0, 0, ScreenUtil.dip2px(32.0f), ScreenUtil.dip2px(32.0f));
                    spannableString.setSpan(new ImageSpan(j3, 0), 0, spannableString.length(), 17);
                    z3(11, 2, view, getString(R.string.fvb), spannableString, this.f299892g0.isOwnerOrAdim());
                }
            } else {
                z3(11, 2, view, getString(R.string.fvb), HardCodeUtil.qqStr(R.string.f172823ui2), this.f299892g0.isOwnerOrAdim());
            }
            if (this.f299911z0) {
                T3(11, true);
            } else {
                T3(11, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W3() {
        URLDrawable uRLDrawable;
        SpannableString spannableString;
        boolean z16;
        View view = this.f299888c0[12];
        ArrayList arrayList = new ArrayList();
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getCoverFromDb(arrayList, this.f299895j0);
        if (arrayList.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, "updateCoverEntry infoList is empty.");
            }
            z3(12, 2, view, getString(R.string.i9k), HardCodeUtil.qqStr(R.string.ui6), this.f299892g0.isOwnerOrAdim());
        } else {
            com.tencent.mobileqq.troop.avatar.a aVar = (com.tencent.mobileqq.troop.avatar.a) arrayList.get(0);
            ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
            String artWork = iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(aVar.f294530b, this.f299895j0.troopuin, 1));
            int dip2px = ScreenUtil.dip2px(30.0f);
            try {
                URL uRL4TroopPhoto = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(artWork);
                if (uRL4TroopPhoto != null) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    obtain.mRequestWidth = dip2px;
                    obtain.mRequestHeight = dip2px;
                    uRLDrawable = URLDrawable.getDrawable(uRL4TroopPhoto, obtain);
                    try {
                        uRLDrawable.setTag(new int[]{dip2px, dip2px, 0});
                        uRLDrawable.setDecodeHandler(N0);
                        if (uRLDrawable.getStatus() != 1) {
                            uRLDrawable.setURLDrawableListener(new j());
                        }
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                        }
                        if (uRLDrawable == null) {
                        }
                        z3(12, 2, view, getString(R.string.i9k), spannableString, this.f299892g0.isOwnerOrAdim());
                        view.setTag(R.string.i9k, Integer.valueOf(arrayList.size()));
                    }
                } else {
                    uRLDrawable = null;
                }
            } catch (Exception e17) {
                e = e17;
                uRLDrawable = null;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                if (uRLDrawable != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objArr[0] = Boolean.valueOf(z16);
                objArr[1] = artWork;
                QLog.i("TroopInfoActivity", 2, String.format("updateCoverEntry ud!=null?%b path=%s", objArr));
            }
            if (uRLDrawable == null) {
                SpannableString spannableString2 = new SpannableString("[Avatar]");
                uRLDrawable.setBounds(0, 0, dip2px, dip2px);
                spannableString2.setSpan(new ImageSpan(uRLDrawable, 0), 0, spannableString2.length(), 17);
                spannableString = spannableString2;
            } else {
                spannableString = null;
            }
            z3(12, 2, view, getString(R.string.i9k), spannableString, this.f299892g0.isOwnerOrAdim());
        }
        view.setTag(R.string.i9k, Integer.valueOf(arrayList.size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2() {
        int i3;
        int i16;
        View view = this.K0;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.jgg);
            TroopInfoData troopInfoData = this.f299892g0;
            int i17 = troopInfoData.troopTypeExt;
            if (2 != i17 && 4 != i17) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if ((this.f299895j0.dwAppPrivilegeFlag & 16384) != 0) {
                i3 |= 2;
            }
            if (4 == i17 || 3 == i17) {
                i3 |= 4;
            }
            int i18 = troopInfoData.tribeStatus;
            if (i18 == 2 || i18 == 3) {
                i3 |= 8;
            }
            if (i18 == 1) {
                i3 |= 16;
            }
            if ((troopInfoData.dwGroupFlagExt & 2048) != 0) {
                i3 |= 32;
            }
            if (A3(i3, 1)) {
                if (A3(i3, 2)) {
                    if (!A3(i3, 4) && !A3(i3, 8) && !A3(i3, 16)) {
                        i16 = R.string.ept;
                    } else {
                        i16 = R.string.epu;
                    }
                } else if (A3(i3, 8)) {
                    i16 = R.string.epn;
                } else if (A3(i3, 4)) {
                    i16 = R.string.epm;
                } else {
                    i16 = R.string.epl;
                }
            } else if (A3(i3, 2)) {
                if (A3(i3, 4)) {
                    i16 = R.string.eps;
                } else if (!A3(i3, 8) && !A3(i3, 16)) {
                    i16 = R.string.epq;
                } else {
                    i16 = R.string.epr;
                }
            } else if (A3(i3, 8) && A3(i3, 4)) {
                i16 = R.string.epi;
            } else if (A3(i3, 8)) {
                i16 = R.string.epk;
            } else if (A3(i3, 4)) {
                i16 = R.string.epj;
            } else {
                i16 = 0;
            }
            if (i16 != 0) {
                this.L0.setVisibility(0);
                textView.setText(i16);
                textView.setContentDescription(getString(i16));
                return;
            }
            this.L0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a4() {
        TroopBindGameItemHelper troopBindGameItemHelper;
        if (this.f299892g0.isGameTroop()) {
            if (this.f299889d0 == null) {
                this.f299889d0 = new TroopBindGameItemHelper(this, this.f299892g0.troopUin);
            }
            if (this.f299889d0.k() == 0) {
                this.f299889d0.j();
            }
            this.f299889d0.s(true);
            return;
        }
        if (!this.f299892g0.isGameTroop() && (troopBindGameItemHelper = this.f299889d0) != null) {
            troopBindGameItemHelper.s(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c4() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.15
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    String l3 = Long.toString(TroopInfoActivity.this.f299892g0.dwGroupClassExt);
                    com.tencent.mobileqq.troop.troopcatalog.a h16 = com.tencent.mobileqq.troop.troopcatalog.b.g().h();
                    if (h16 != null && h16.f299961c.equals(l3)) {
                        TroopInfoActivity.this.f299892g0.troopClass = h16.d();
                        TroopInfoActivity.this.f299892g0.mTroopClassExtText = h16.f299960b;
                    } else {
                        com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(l3);
                        if (c16 != null) {
                            TroopInfoActivity.this.f299892g0.troopClass = c16.d();
                            TroopInfoActivity.this.f299892g0.mTroopClassExtText = c16.f299960b;
                        }
                    }
                    TroopInfoActivity.this.F0.sendEmptyMessage(5);
                    TroopInfoActivity.this.F0.sendEmptyMessage(6);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopInfoActivity", 2, e16.toString());
                    }
                }
            }
        }, 5, null, true);
    }

    private View e3(String str) {
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextColor(getResources().getColor(R.color.skin_gray2));
        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.f159603b10), ViewUtils.dip2px(20.0f), 0, ViewUtils.dip2px(10.0f));
        textView.setFocusable(true);
        return textView;
    }

    private void f4(View view) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
            if (linearLayout != null && (layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams()) != null) {
                layoutParams.leftMargin = Utils.n(40.0f, getResources());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f299892g0.troopOwnerNick = str;
        } else if (!this.f299894i0) {
            this.f299894i0 = true;
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getFriendInfo(this.D0, this.f299892g0.troopowneruin);
        }
    }

    public static Bundle getTroopProfileExtra(String str, int i3) {
        return aq.d(str, "", i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3() {
        ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
        TroopInfoData troopInfoData = this.f299892g0;
        iTroopMemberListRepoApi.fetchTroopMemberInfo(troopInfoData.troopUin, troopInfoData.troopowneruin, false, null, "TroopInfoActivity", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.troop.troopcard.ui.g
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopInfoActivity.this.E3(troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i4() {
        if (QLog.isColorLevel()) {
            QLog.i("TroopInfoActivity", 2, "updateTroopOwnerName");
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ITroopCardApi iTroopCardApi = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
                TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                String friendDisplayName = iTroopCardApi.getFriendDisplayName(troopInfoActivity.D0, troopInfoActivity.f299892g0.troopowneruin);
                if (!TextUtils.isEmpty(friendDisplayName) && !friendDisplayName.equals(TroopInfoActivity.this.f299892g0.troopowneruin)) {
                    TroopInfoActivity.this.f299892g0.troopOwnerNick = friendDisplayName;
                } else {
                    ITroopDBUtilsApi iTroopDBUtilsApi = (ITroopDBUtilsApi) QRoute.api(ITroopDBUtilsApi.class);
                    TroopInfoActivity troopInfoActivity2 = TroopInfoActivity.this;
                    AppInterface appInterface = troopInfoActivity2.D0;
                    TroopInfoData troopInfoData = troopInfoActivity2.f299892g0;
                    TroopMemberCardInfo troopMemberCardInfo = iTroopDBUtilsApi.getTroopMemberCardInfo(appInterface, troopInfoData.troopUin, troopInfoData.troopowneruin);
                    if (troopMemberCardInfo == null) {
                        TroopInfoActivity.this.i3();
                    } else {
                        if (!TextUtils.isEmpty(troopMemberCardInfo.nick)) {
                            str = troopMemberCardInfo.nick;
                        } else if (!TextUtils.isEmpty(troopMemberCardInfo.name)) {
                            str = troopMemberCardInfo.name;
                        } else {
                            str = null;
                        }
                        TroopInfoActivity.this.g3(str);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopInfoActivity", 2, "mTroopInfoData.troopOwnerNick = " + TroopInfoActivity.this.f299892g0.troopOwnerNick);
                }
            }
        }, 5, null, true);
    }

    private Drawable j3() {
        Bitmap bitmap;
        IFaceDecoder iFaceDecoder = this.f299910y0;
        if (iFaceDecoder != null) {
            bitmap = iFaceDecoder.getBitmapFromCache(4, this.f299892g0.troopUin);
            if (bitmap == null && !this.f299910y0.isPausing()) {
                this.f299910y0.requestDecodeFace(this.f299892g0.troopUin, 4, true);
            }
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = BaseImageUtil.getDefaultFaceBitmap();
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        if (ThemeUtil.isInNightMode(this.D0)) {
            bitmapDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        }
        return bitmapDrawable;
    }

    @Deprecated
    public static ArrayList<String> l3(TroopInfoData troopInfoData) {
        if (troopInfoData == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> list = troopInfoData.troopTags;
        if (list != null && list.size() > 0) {
            int size = troopInfoData.troopTags.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(troopInfoData.troopTags.get(i3));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n3() {
        return ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).getTroopShareDescDefaultWording();
    }

    private void r3() {
        TroopInfoData troopInfoData = this.f299892g0;
        if (troopInfoData.cGroupOption != 3) {
            if (!TextUtils.isEmpty(troopInfoData.remark)) {
                ITroopCardApi iTroopCardApi = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
                TroopInfoData troopInfoData2 = this.f299892g0;
                String str = troopInfoData2.troopUin;
                String str2 = troopInfoData2.troopName;
                short s16 = troopInfoData2.cGroupOption;
                int statOption = troopInfoData2.getStatOption();
                TroopInfoData troopInfoData3 = this.f299892g0;
                startActivity(iTroopCardApi.addFriendLogicActivity_startJoinTroop(this, str, str2, s16, statOption, troopInfoData3.mStrJoinQuestion, troopInfoData3.mStrJoinAnswer, troopInfoData3.remark, setLastActivityName(), null));
                return;
            }
            ITroopCardApi iTroopCardApi2 = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
            TroopInfoData troopInfoData4 = this.f299892g0;
            String str3 = troopInfoData4.troopUin;
            String str4 = troopInfoData4.troopName;
            short s17 = troopInfoData4.cGroupOption;
            int statOption2 = troopInfoData4.getStatOption();
            TroopInfoData troopInfoData5 = this.f299892g0;
            startActivityForResult(iTroopCardApi2.addFriendLogicActivity_startJoinTroop(this, str3, str4, s17, statOption2, troopInfoData5.mStrJoinQuestion, troopInfoData5.mStrJoinAnswer, null, setLastActivityName(), null), 8);
            return;
        }
        notifyUser(R.string.i7i, 1);
    }

    private void t3(int i3) {
        boolean z16;
        String str;
        if (i3 == 11) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable) {
            TroopInfoData troopInfoData = this.f299892g0;
            if (troopInfoData.mIsFreezed == 1 && troopInfoData.isOwnerOrAdim()) {
                ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).handleModiftyTroopHeadFreezed(this.f299892g0, this);
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E37", 2, 0, "", "", "", "");
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_COVER", !z16);
        bundle.putBoolean("IS_EDIT", true);
        Z9(bundle);
        ReportController.o(this.D0, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "nonmber_Clk_head", 0, 0, this.f299892g0.troopUin, "", "", "");
        String[] strArr = new String[2];
        TroopInfoData troopInfoData2 = this.f299892g0;
        strArr[0] = troopInfoData2.troopUin;
        if (troopInfoData2.isMember) {
            str = "1";
        } else {
            str = "0";
        }
        strArr[1] = str;
        eu.g("Grp_set_new", "grpData_admin", "clk_head", 0, 0, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u3, reason: merged with bridge method [inline-methods] */
    public void C3(boolean z16, String str, String str2) {
        QLog.i("TroopInfoActivity", 1, "[handleModifyTroopName] isSus:" + z16 + ", newName:" + str + ",errorMsg:" + str2);
        hideJuhua();
        if (z16) {
            TroopInfoData troopInfoData = this.f299892g0;
            troopInfoData.hasSetNewTroopName = true;
            troopInfoData.troopName = str;
            boolean z17 = troopInfoData.isNewTroop;
            troopInfoData.newTroopName = str;
            h4();
            TroopInfoData troopInfoData2 = this.f299892g0;
            troopInfoData2.hasSetNewTroopName = true;
            if (troopInfoData2.hasSetNewTroopHead) {
                troopInfoData2.isNewTroop = false;
            }
            TroopInfo troopInfo = this.f299895j0;
            if (troopInfo != null) {
                troopInfo.troopname = troopInfoData2.troopName;
                troopInfo.hasSetNewTroopName = true;
                troopInfo.isNewTroop = troopInfoData2.isNewTroop;
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = HardCodeUtil.qqStr(R.string.khc);
        }
        QQToast.makeText(this, 1, str2, 0).show(getTitleBarHeight());
        TroopInfo troopInfo2 = this.f299895j0;
        if (troopInfo2 != null) {
            this.f299892g0.troopName = troopInfo2.getTroopDisplayName();
            h4();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoActivity", 2, str2);
        }
    }

    private void v3(boolean z16, long j3, String str, long j16, long j17) {
        int i3;
        String string;
        TroopInfo troopInfo = this.f299895j0;
        if (troopInfo != null && z16) {
            int i16 = this.f299892g0.troopTypeExt;
            if (i16 == 2) {
                troopInfo.troopTypeExt = 3;
            } else {
                troopInfo.troopTypeExt = i16;
            }
            TroopInfo troopInfo2 = ((ITroopInfoService) this.D0.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(this.f299892g0.troopUin);
            if (troopInfo2 != null) {
                TroopInfoData troopInfoData = this.f299892g0;
                troopInfo2.troopname = troopInfoData.troopName;
                troopInfo2.dwGroupClassExt = troopInfoData.dwGroupClassExt;
                troopInfo2.mGroupClassExtText = troopInfoData.mTroopClassExtText;
                troopInfo2.mRichFingerMemo = com.tencent.mobileqq.troop.util.a.c(troopInfoData.mRichFingerMemo);
                TroopInfoData troopInfoData2 = this.f299892g0;
                troopInfo2.hasSetNewTroopName = troopInfoData2.hasSetNewTroopName;
                troopInfo2.strLocation = troopInfoData2.troopLocation;
                troopInfo2.troopLat = troopInfoData2.troopLat;
                troopInfo2.troopLon = troopInfoData2.troopLon;
                troopInfo2.location = troopInfoData2.location;
                troopInfo2.grade = troopInfoData2.grade;
                troopInfo2.school = troopInfoData2.school;
                List<String> list = troopInfoData2.troopTags;
                if (list != null && list.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<String> it = this.f299892g0.troopTags.iterator();
                    while (it.hasNext()) {
                        stringBuffer.append(it.next() + "\n");
                    }
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    troopInfo2.mTags = stringBuffer.toString();
                }
            }
        }
        h3();
        if (!z16) {
            if (TextUtils.isEmpty(str)) {
                int i17 = (int) j3;
                if (i17 == 1299) {
                    string = getString(R.string.f160441v1);
                } else if (i17 != 1793) {
                    switch (i17) {
                        case 1281:
                            string = getString(R.string.bvz);
                            break;
                        case 1282:
                            string = getString(R.string.f171035bw0);
                            break;
                        case 1283:
                            string = getString(R.string.f171036bw1);
                            break;
                        default:
                            string = getString(R.string.bvy);
                            break;
                    }
                } else {
                    string = getString(R.string.iqx);
                }
            } else {
                string = str;
            }
            AppInterface appInterface = this.D0;
            TroopInfoData troopInfoData3 = this.f299892g0;
            ReportController.o(appInterface, "P_CliOper", "Grp_create", "", "edit_data", "fail_modify", 0, 0, troopInfoData3 != null ? troopInfoData3.troopUin : "", this.f299911z0 ? "2" : "1", (troopInfoData3 == null || troopInfoData3.bOwner) ? "0" : troopInfoData3.bAdmin ? "1" : "2", "");
            QQToast.makeText(this, 1, string, 1).show(getTitleBarHeight());
        } else {
            AppInterface appInterface2 = this.D0;
            TroopInfoData troopInfoData4 = this.f299892g0;
            ReportController.o(appInterface2, "P_CliOper", "Grp_create", "", "edit_data", "suc_modify", 0, 0, troopInfoData4 != null ? troopInfoData4.troopUin : "", this.f299911z0 ? "2" : "1", (troopInfoData4 == null || troopInfoData4.bOwner) ? "0" : troopInfoData4.bAdmin ? "1" : "2", "");
            if (!this.f299911z0) {
                QQToast.makeText(this, 2, getString(R.string.f171038bw4), 1).show(getTitleBarHeight());
            }
        }
        if (z16) {
            BusinessHandler businessHandler = this.D0.getBusinessHandler(TroopModifyHandler.class.getName());
            int i18 = com.tencent.mobileqq.troop.api.observer.c.f294316i;
            Object[] objArr = new Object[3];
            TroopInfoData troopInfoData5 = this.f299892g0;
            objArr[0] = troopInfoData5 != null ? troopInfoData5.troopUin : "";
            i3 = 1;
            objArr[1] = Long.valueOf(j16);
            objArr[2] = Long.valueOf(j17);
            businessHandler.notifyUI(i18, true, objArr);
            this.A0 = true;
            finish();
        } else {
            i3 = 1;
        }
        int i19 = this.f299899n0;
        if (i19 == 0 || i3 == i19) {
            ReportController.o(this.D0, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.f299892g0.troopUin, this.f299905t0, "", "");
        }
    }

    private void w3(XListView xListView) {
        if (xListView == null) {
            return;
        }
        View inflate = super.getLayoutInflater().inflate(R.layout.ahp, (ViewGroup) xListView, false);
        this.K0 = inflate;
        this.L0 = inflate.findViewById(R.id.jna);
        ((ImageButton) this.K0.findViewById(R.id.close)).setOnClickListener(new e(xListView));
        xListView.addHeaderView(this.K0);
        this.L0.setVisibility(8);
    }

    private void y3() {
        TroopInfoData troopInfoData;
        W3();
        if (this.D0 != null && (troopInfoData = this.f299892g0) != null && !TextUtils.isEmpty(troopInfoData.troopUin)) {
            this.D0.addObserver(this.E0);
            ((com.tencent.mobileqq.troop.api.handler.b) this.D0.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAvatarHandlerName())).o2(this.f299892g0.troopUin);
        }
    }

    boolean A3(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    public void L3() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.f299892g0.isOwnerOrAdim()) {
            AppInterface appInterface = this.D0;
            String str2 = this.f299892g0.troopUin;
            if (this.f299911z0) {
                str = "2";
            } else {
                str = "1";
            }
            ReportController.o(appInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, str2, str, "", "");
            ITroopCardApi iTroopCardApi = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
            TroopInfoData troopInfoData = this.f299892g0;
            iTroopCardApi.startModifyLocationActivityForResultEx(this, troopInfoData.troopUin, troopInfoData.troopLocation, 16);
        }
    }

    public void P3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        String string = getString(i3);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        createCustomDialog.setTitle(string);
        createCustomDialog.setMessage((CharSequence) null);
        createCustomDialog.setPositiveButton(getString(R.string.bvo), new k(createCustomDialog));
        createCustomDialog.setPositiveButtonContentDescription(getString(R.string.bvo));
        createCustomDialog.setNegativeButton(getString(R.string.f171032bu3), new DialogUtil.DialogOnClickAdapter());
        createCustomDialog.setNegativeButtonContentDescription(getString(R.string.f171032bu3));
        createCustomDialog.show();
    }

    public void Q3() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.f299892g0.f294880pa == 28) {
            setResult(-1);
        }
        if (!this.f299897l0) {
            this.A0 = true;
            finish();
            return;
        }
        AppInterface appInterface = this.D0;
        TroopInfoData troopInfoData = this.f299892g0;
        String str3 = troopInfoData.troopUin;
        if (this.f299911z0) {
            str = "2";
        } else {
            str = "1";
        }
        if (troopInfoData.bOwner) {
            str2 = "0";
        } else if (!troopInfoData.bAdmin) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        ReportController.o(appInterface, "P_CliOper", "Grp_create", "", "edit_data", "modify", 0, 0, str3, str, str2, "");
        if (((com.tencent.mobileqq.troop.api.handler.i) this.D0.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())) == null) {
            this.A0 = true;
            finish();
            return;
        }
        try {
            long parseLong = Long.parseLong(this.f299892g0.troopUin);
            if (this.f299892g0.troopTypeExt == -1) {
                this.A0 = true;
                finish();
                return;
            }
            showWaitingDialog(getString(R.string.f171037bw3));
            TroopInfoData troopInfoData2 = this.f299892g0;
            int i3 = troopInfoData2.troopTypeExt;
            if (i3 == 2) {
                i3 = 3;
            }
            if (i3 == -1) {
                return;
            }
            int i16 = this.f299899n0;
            if ((i16 == 0 || 1 == i16) && i3 == 3) {
                ReportController.o(this.D0, "P_CliOper", "Grp_create", "", "edit_data", "set_local", 0, 0, troopInfoData2.troopUin, this.f299905t0, "", "");
            }
            int i17 = this.f299899n0;
            if ((i17 == 2 || i17 == 3 || i17 == 4) && (i3 == 0 || 1 == i3)) {
                ReportController.o(this.D0, "P_CliOper", "Grp_create", "", "edit_data", "un_local", 0, 0, this.f299892g0.troopUin, this.f299905t0, "", "");
            }
            if ((this.f299892g0.dwGroupFlagExt & 2048) != 0) {
                h3();
                return;
            }
            String valueOf = String.valueOf(parseLong);
            final long j3 = this.f299892g0.dwGroupClassExt;
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopData(valueOf, this.C0, this, "TroopInfoActivity", new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.troopcard.ui.f
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z16, int i18, String str4) {
                    TroopInfoActivity.this.G3(j3, z16, i18, str4);
                }
            });
        } catch (NumberFormatException unused) {
            finish();
        }
    }

    public void R3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (i3 != 14) {
            if (i3 != 15) {
                if (i3 != 18) {
                    this.f299890e0.setVisibility(8);
                    this.f299891f0.setVisibility(8);
                    return;
                }
                this.f299891f0.setText(R.string.f235387bi);
                this.f299891f0.setTag(18);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f299890e0.getLayoutParams();
                layoutParams.addRule(12, 0);
                layoutParams.setMargins(0, 76, 0, 0);
                this.f299890e0.setVisibility(0);
                this.f299891f0.setVisibility(0);
                if (this.f299890e0.getParent() != null) {
                    ((ViewGroup) this.f299890e0.getParent()).removeView(this.f299890e0);
                }
                this.f299887b0.addView(this.f299890e0);
                return;
            }
            this.f299891f0.setText(R.string.f171051c03);
            this.f299891f0.setTag(15);
            this.f299890e0.setVisibility(0);
            this.f299891f0.setVisibility(0);
            return;
        }
        this.f299890e0.setVisibility(8);
        this.f299891f0.setVisibility(8);
        this.rightViewText.setVisibility(0);
        this.rightViewText.setEnabled(true);
        this.rightViewText.setText(R.string.bwh);
    }

    public void S3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        try {
            if (this.J0 == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
                this.J0 = qQProgressDialog;
                qQProgressDialog.setMessage(R.string.cpr);
                this.J0.setBackAndSearchFilter(false);
            }
            this.J0.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, e16.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void V3(int i3, ArrayList<String> arrayList, boolean z16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), arrayList, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("TroopInfoActivity", 4, "updateClrTextItemView(), tag = " + i3 + ", info = " + arrayList + ", bShowArrow = " + z16);
        }
        Resources.Theme theme = null;
        if (i3 >= 0) {
            View[] viewArr = this.f299888c0;
            if (i3 < viewArr.length) {
                view = viewArr[i3];
                if (view == null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f164827b03);
                    linearLayout.removeAllViews();
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.jfi);
                    TextView textView = (TextView) view.findViewById(R.id.info);
                    if (arrayList != null && arrayList.size() != 0) {
                        linearLayout2.setVisibility(8);
                        linearLayout.setVisibility(0);
                        int width = linearLayout.getWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        int i17 = 0;
                        int i18 = 0;
                        while (i17 < arrayList.size() && i17 < 5) {
                            if (!TextUtils.isEmpty(arrayList.get(i17))) {
                                TextView textView2 = new TextView(this);
                                textView2.setId(R.id.gjo);
                                textView2.setTextSize(i16, 15.0f);
                                textView2.setSingleLine();
                                textView2.setTextColor(getResources().getColor(R.color.qui_common_text_secondary, theme));
                                textView2.setPadding(Utils.n(8.0f, getResources()), Utils.n(2.0f, getResources()), Utils.n(8.0f, getResources()), Utils.n(2.0f, getResources()));
                                textView2.setGravity(17);
                                textView2.setText(arrayList.get(i17));
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                                layoutParams.leftMargin = Utils.n(5.0f, getResources());
                                textView2.setLayoutParams(layoutParams);
                                textView2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.kd_, null));
                                textView2.measure(makeMeasureSpec, makeMeasureSpec);
                                i18 += textView2.getMeasuredWidth();
                                if (i18 > width && width != 0) {
                                    break;
                                } else {
                                    linearLayout.addView(textView2);
                                }
                            }
                            i17++;
                            theme = null;
                            i16 = 2;
                        }
                        View findViewById = view.findViewById(R.id.f164472yw);
                        if (z16) {
                            view.setTag(Integer.valueOf(i3));
                            view.setOnClickListener(this);
                            findViewById.setVisibility(0);
                            return;
                        } else {
                            view.setTag(null);
                            view.setOnClickListener(null);
                            findViewById.setVisibility(8);
                            return;
                        }
                    }
                    linearLayout2.setVisibility(0);
                    linearLayout.setVisibility(8);
                    textView.setText(HardCodeUtil.qqStr(R.string.ui9));
                    return;
                }
                return;
            }
        }
        view = null;
        if (view == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void X3(int i3, String str, boolean z16) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("TroopInfoActivity", 4, "updateDefaultItemView(), tag = " + i3 + ", info = " + str + ", bShowArrow = " + z16);
        }
        if (i3 >= 0) {
            View[] viewArr = this.f299888c0;
            if (i3 < viewArr.length) {
                view = viewArr[i3];
                if (view == null) {
                    TextView textView = (TextView) view.findViewById(R.id.info);
                    View findViewById = view.findViewById(R.id.f164472yw);
                    if (i3 == 6) {
                        if (TextUtils.isEmpty(str)) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                            textView.setText(new QQText(str, 11, 20));
                        }
                    } else {
                        if (i3 == 4 && TextUtils.isEmpty(str)) {
                            str = HardCodeUtil.qqStr(R.string.ui8);
                        }
                        textView.setText(str);
                    }
                    if (z16) {
                        view.setTag(Integer.valueOf(i3));
                        view.setOnClickListener(this);
                        findViewById.setVisibility(0);
                        return;
                    } else {
                        view.setTag(null);
                        view.setOnClickListener(null);
                        findViewById.setVisibility(8);
                        return;
                    }
                }
                return;
            }
        }
        view = null;
        if (view == null) {
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.e
    public void Z9(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) bundle);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent();
        intent.setClass(this, ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopAvatarWallEditActivityClass());
        bundle.putInt("index", 0);
        bundle.putString("troop_uin", this.f299892g0.troopUin);
        bundle.putLong("troop_flag_ext", this.f299892g0.dwGroupFlagExt);
        bundle.putInt(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME, this.f299901p0);
        bundle.putBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER, this.f299892g0.isMember);
        bundle.putBoolean("isUseClassAvatar", this.f299892g0.isUseClassAvatar);
        intent.putExtras(bundle);
        intent.addFlags(603979776);
        if (!bundle.getBoolean("IS_COVER")) {
            i3 = 260;
        } else {
            i3 = 258;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopInfoActivity", 2, String.format("gotoBigPic code=%d bundle=%s", Integer.valueOf(i3), bundle));
        }
        startActivityForResult(intent, i3);
    }

    public void b3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (!this.f299897l0) {
            finish();
        } else {
            P3(R.string.bvp);
        }
    }

    public void b4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.f299892g0 == null) {
            return;
        }
        Intent intent = getIntent();
        intent.putExtra("location", this.f299892g0.troopLocation);
        intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, this.f299892g0.troopLat);
        intent.putExtra("lon", this.f299892g0.troopLon);
        intent.putExtra("name", this.f299892g0.troopName);
        intent.putExtra(Constants.Service.CLASS, this.f299892g0.dwGroupClassExt);
        intent.putExtra("intro", this.f299892g0.mRichFingerMemo);
        intent.putExtra("location", this.f299892g0.location);
        intent.putExtra("grade", this.f299892g0.grade);
        intent.putExtra("school", this.f299892g0.school);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x01d8 A[Catch: Exception -> 0x020a, TryCatch #0 {Exception -> 0x020a, blocks: (B:18:0x01d2, B:20:0x01d8, B:21:0x01e7, B:23:0x01f6, B:25:0x01fe, B:31:0x01de, B:33:0x01e2), top: B:17:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f6 A[Catch: Exception -> 0x020a, TryCatch #0 {Exception -> 0x020a, blocks: (B:18:0x01d2, B:20:0x01d8, B:21:0x01e7, B:23:0x01f6, B:25:0x01fe, B:31:0x01de, B:33:0x01e2), top: B:17:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01de A[Catch: Exception -> 0x020a, TryCatch #0 {Exception -> 0x020a, blocks: (B:18:0x01d2, B:20:0x01d8, B:21:0x01e7, B:23:0x01f6, B:25:0x01fe, B:31:0x01de, B:33:0x01e2), top: B:17:0x01d2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean c3() {
        boolean z16;
        boolean z17;
        TroopInfoData troopInfoData;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.f299892g0.troopUin = extras.getString("troop_uin");
            if (Long.parseLong(this.f299892g0.troopUin) > 0) {
                this.C0 = new com.tencent.mobileqq.data.troop.b(this.f299892g0.troopUin);
                this.f299892g0.f294880pa = extras.getInt(AppConstants.Key.TROOP_INFO_FROM);
                this.f299902q0 = extras.getInt(AppConstants.Key.TROOP_INFO_REPORT_FROM, -1);
                this.f299892g0.nStatOption = extras.getInt(AppConstants.Key.TROOP_INFO_FROM_EX);
                this.f299892g0.remark = extras.getString("param_return_addr");
                this.f299892g0.isMember = extras.getBoolean(AppConstants.Key.TROOP_INFO_IS_MEMBER);
                this.f299892g0.troopface = extras.getShort(AppConstants.Key.TROOP_INFO_FACEID);
                this.f299892g0.troopName = extras.getString(AppConstants.Key.TROOP_INFO_NAME);
                TroopInfoData troopInfoData2 = this.f299892g0;
                troopInfoData2.newTroopName = troopInfoData2.troopName;
                troopInfoData2.troopowneruin = extras.getString(AppConstants.Key.TROOP_INFO_OWNER);
                this.f299892g0.dwGroupClassExt = extras.getLong(AppConstants.Key.TROOP_INFO_CLASSEXT);
                this.f299892g0.troopLocation = extras.getString(AppConstants.Key.TROOP_INFO_LOCA);
                this.f299892g0.troopLat = extras.getInt(AppConstants.Key.TROOP_INFO_LAT, 0);
                this.f299892g0.troopLon = extras.getInt(AppConstants.Key.TROOP_INFO_LON, 0);
                this.f299892g0.cityId = extras.getInt(AppConstants.Key.TROOP_INFO_CITYID, 0);
                this.f299892g0.mRichFingerMemo = extras.getString(AppConstants.Key.TROOP_INFO_FINGERMEMO);
                this.f299892g0.location = extras.getString(AppConstants.Key.TROOP_INFO_SCHOOL_LOCATION);
                this.f299892g0.school = extras.getString(AppConstants.Key.TROOP_INFO_SCHOOL_SCHOOLID);
                this.f299892g0.grade = extras.getInt(AppConstants.Key.TROOP_INFO_SCHOOL_GRADE);
                this.f299892g0.cGroupOption = extras.getByte(AppConstants.Key.TROOP_INFO_OPT);
                this.f299892g0.mStrJoinQuestion = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopQuestionFromSP(this, this.f299892g0.troopUin);
                this.f299892g0.mStrJoinAnswer = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopAnswerFromSP(this, this.f299892g0.troopUin);
                this.f299892g0.dwGroupFlagExt = extras.getLong(AppConstants.Key.TROOP_INFO_FLAG_EXT);
                this.f299892g0.troopTags = TroopInfo.getTags(extras.getString(AppConstants.Key.TROOP_INFO_TAGS_EXT));
                this.f299892g0.troopTypeExt = extras.getInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX);
                this.f299899n0 = extras.getInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX);
                this.f299892g0.wMemberNum = extras.getInt(AppConstants.Key.TROOP_INFO_MEMBER_NUM);
                this.f299901p0 = extras.getInt(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME);
                this.f299903r0 = extras.getInt("PARAM_EXIT_ANIMATION", 0);
                this.f299911z0 = extras.getBoolean(et.f307751a, false);
                ITroopInfoService iTroopInfoService = (ITroopInfoService) this.D0.getRuntimeService(ITroopInfoService.class, "");
                try {
                    if (iTroopInfoService != null) {
                        TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(this.f299892g0.troopUin);
                        if (findTroopInfo != null) {
                            this.f299895j0 = findTroopInfo;
                            TroopInfoData troopInfoData3 = this.f299892g0;
                            troopInfoData3.isMember = true;
                            troopInfoData3.updateForTroopInfo(findTroopInfo, this.D0.getCurrentAccountUin());
                            z17 = true;
                            troopInfoData = this.f299892g0;
                            if (!troopInfoData.bOwner) {
                                this.f299905t0 = "0";
                            } else if (troopInfoData.bAdmin) {
                                this.f299905t0 = "1";
                            }
                            j3 = extras.getLong("nid", -1L);
                            this.B0 = j3;
                            if (j3 != -1) {
                                TroopInfoData troopInfoData4 = this.f299892g0;
                                if (troopInfoData4.dwGroupClassExt != j3) {
                                    this.f299897l0 = true;
                                    troopInfoData4.dwGroupClassExt = j3;
                                    H3(Long.valueOf(j3));
                                }
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.e("TroopInfoActivity", 2, "can't find troop info of :" + this.f299892g0.troopUin);
                        }
                    }
                    troopInfoData = this.f299892g0;
                    if (!troopInfoData.bOwner) {
                    }
                    j3 = extras.getLong("nid", -1L);
                    this.B0 = j3;
                    if (j3 != -1) {
                    }
                } catch (Exception e16) {
                    z16 = z17;
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopInfoActivity", 2, e.toString());
                    }
                    z17 = z16;
                    if (QLog.isColorLevel()) {
                    }
                    return z17;
                }
                z17 = false;
            } else {
                z17 = false;
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            TroopInfoData troopInfoData5 = this.f299892g0;
            QLog.d("TroopInfoActivity", 2, String.format("checkParams troopUin: %s, classExt: %s", troopInfoData5.troopUin, Long.valueOf(troopInfoData5.dwGroupClassExt)));
        }
        return z17;
    }

    protected void d4() {
        String M3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        View view = this.f299888c0[13];
        if (view != null) {
            if (TextUtils.isEmpty(this.f299892g0.location)) {
                M3 = HardCodeUtil.qqStr(R.string.oks);
                ReportController.o(this.D0, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.f299892g0.troopUin, "1", "", "");
            } else {
                M3 = M3(this.f299892g0.grade);
                ReportController.o(this.D0, "dc00898", "", "", "0X800B281", "0X800B281", 0, 0, this.f299892g0.troopUin, "2", "", "");
            }
            ((TextView) view.findViewById(R.id.info)).setText(M3);
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, String.format("updateTroopClassInfoEntry %s", M3));
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        TroopInfo findTroopInfo;
        String str;
        String n3;
        long j3;
        String str2;
        TroopInfo troopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopInfoActivity", 2, "onActivityResult, requestCode = " + i3 + ", resultCode = " + i16 + ", data = " + intent);
        }
        if (-1 == i16) {
            if (i3 != 5) {
                if (i3 != 11) {
                    if (i3 != 16) {
                        if (i3 != 257) {
                            if (i3 != 7) {
                                if (i3 != 8) {
                                    if (i3 != 9) {
                                        if (i3 != 18) {
                                            if (i3 == 19 && intent != null && i16 == -1) {
                                                try {
                                                    JSONObject jSONObject = new JSONObject(intent.getStringExtra("SchoolJsonObject"));
                                                    JSONObject jSONObject2 = jSONObject.getJSONObject("location");
                                                    this.f299897l0 = true;
                                                    this.f299892g0.grade = jSONObject.optInt("grade");
                                                    this.f299892g0.location = jSONObject2.toString();
                                                    this.f299892g0.school = jSONObject.getString("school");
                                                    this.C0.j(Integer.valueOf(this.f299892g0.grade));
                                                    this.C0.p(this.f299892g0.location);
                                                    this.C0.o(this.f299892g0.school);
                                                } catch (JSONException e16) {
                                                    e16.printStackTrace();
                                                }
                                                d4();
                                            }
                                        } else if (i16 == -1 && intent != null) {
                                            if (!NetworkUtil.isNetworkAvailable(this)) {
                                                QQToast.makeText(this, 1, R.string.ci5, 0).show(getTitleBarHeight());
                                                return;
                                            }
                                            final String stringExtra = intent.getStringExtra("result");
                                            if (!TextUtils.isEmpty(stringExtra) && (troopInfo = this.f299895j0) != null && !stringExtra.equals(troopInfo.troopname)) {
                                                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyGroupName(this.f299895j0.troopuin, stringExtra, this, "TroopInfoActivity", new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.troop.troopcard.ui.d
                                                    @Override // com.tencent.qqnt.troop.i
                                                    public final void onResult(boolean z16, int i17, String str3) {
                                                        TroopInfoActivity.this.D3(stringExtra, z16, i17, str3);
                                                    }
                                                });
                                                TroopInfoData troopInfoData = this.f299892g0;
                                                troopInfoData.troopName = stringExtra;
                                                troopInfoData.newTroopName = this.f299895j0.getTroopDisplayName();
                                                h4();
                                            }
                                        }
                                    } else {
                                        if (intent != null) {
                                            str2 = intent.getStringExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
                                        } else {
                                            str2 = null;
                                        }
                                        if (str2 != null && str2.length() > 0) {
                                            ArrayList arrayList = new ArrayList();
                                            new JSONArray();
                                            try {
                                                JSONArray jSONArray = new JSONArray(str2);
                                                for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                                                    try {
                                                        arrayList.add(jSONArray.getString(i17));
                                                    } catch (JSONException unused) {
                                                    }
                                                }
                                            } catch (JSONException unused2) {
                                            }
                                            this.f299897l0 = true;
                                            this.f299892g0.troopTags = arrayList;
                                            this.C0.r(arrayList);
                                            this.F0.sendEmptyMessage(6);
                                        }
                                    }
                                } else {
                                    int i18 = this.f299892g0.f294880pa;
                                    if (i18 == 2 || i18 == 6 || i18 == 15 || i18 == 10 || i18 == 11 || i18 == 19 || i18 == 101 || i18 == 102 || i18 == 103 || i18 == 104 || i18 == 105 || i18 == 106 || i18 == 112 || i18 == 113) {
                                        setResult(-1);
                                        finish();
                                    }
                                }
                            } else if (intent != null && intent.getExtras() != null) {
                                Bundle extras = intent.getExtras();
                                this.f299892g0.troopLocation = extras.getString("location");
                                this.f299892g0.troopLat = extras.getInt(QCircleSchemeAttr.Polymerize.LAT, 0);
                                this.f299892g0.troopLon = extras.getInt("lon", 0);
                                this.C0.i(this.f299892g0.troopLocation);
                                this.C0.k(Long.valueOf(this.f299892g0.troopLat));
                                this.C0.l(Long.valueOf(this.f299892g0.troopLon));
                                g4();
                            }
                        } else if (this.f299906u0) {
                            TroopAvatarController troopAvatarController = this.f299908w0;
                            if (troopAvatarController != null) {
                                troopAvatarController.I();
                            }
                        } else {
                            TroopPhotoController troopPhotoController = this.f299907v0;
                            if (troopPhotoController != null) {
                                troopPhotoController.I();
                            }
                        }
                    } else if (intent != null && intent.getExtras() != null) {
                        Bundle extras2 = intent.getExtras();
                        if (!Utils.p(this.f299892g0.troopLocation, extras2.getString("location"))) {
                            this.f299897l0 = true;
                        }
                        String string = extras2.getString("locationOriginal", "");
                        if (QLog.isColorLevel()) {
                            QLog.e("TroopInfoActivity.troop.location_info", 2, "REQUEST_FOR_EDIT_TROOP_LOCATION_WITHOUT_SAVE==>originalLocation:" + string);
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String[] split = string.split("\\|");
                            try {
                                this.f299892g0.cityId = Integer.parseInt(split[0]);
                                this.f299892g0.troopLat = (int) (Double.parseDouble(split[1]) * 1000000.0d);
                                this.f299892g0.troopLon = (int) (Double.parseDouble(split[2]) * 1000000.0d);
                                this.C0.f(Integer.valueOf(this.f299892g0.cityId));
                                this.C0.k(Long.valueOf(this.f299892g0.troopLat));
                                this.C0.l(Long.valueOf(this.f299892g0.troopLon));
                                if (split.length >= 4) {
                                    this.f299892g0.troopLocation = split[3];
                                }
                                if (split.length >= 5) {
                                    this.f299892g0.mPoiId = Long.parseLong(split[4]);
                                    this.C0.m(Long.valueOf(this.f299892g0.mPoiId));
                                }
                            } catch (Exception e17) {
                                QLog.e("TroopInfoActivity", 1, "[doOnActivityResult] REQUEST_FOR_EDIT_TROOP_LOCATION_WITHOUT_SAVE, exception = " + e17);
                            }
                        }
                        this.f299892g0.troopLocation = extras2.getString("location");
                        this.C0.i(this.f299892g0.troopLocation);
                        g4();
                    }
                } else {
                    try {
                        j3 = Long.parseLong(intent.getStringExtra("id"));
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopInfoActivity", 2, e18.toString());
                        }
                        j3 = Long.MAX_VALUE;
                    }
                    TroopInfoData troopInfoData2 = this.f299892g0;
                    if (troopInfoData2.dwGroupClassExt != j3 && j3 != Long.MAX_VALUE) {
                        this.f299897l0 = true;
                        troopInfoData2.dwGroupClassExt = j3;
                        H3(Long.valueOf(j3));
                        c4();
                    }
                }
            } else {
                if (intent != null) {
                    str = intent.getStringExtra("result");
                } else {
                    str = null;
                }
                if (!TextUtils.equals(str, this.f299892g0.mRichFingerMemo)) {
                    this.f299897l0 = true;
                    this.f299892g0.mRichFingerMemo = str;
                    this.C0.s(str);
                    if (!TextUtils.isEmpty(this.f299892g0.mRichFingerMemo)) {
                        n3 = this.f299892g0.mRichFingerMemo;
                    } else {
                        n3 = n3();
                    }
                    X3(6, n3, this.f299892g0.isOwnerOrAdim());
                }
            }
        }
        if (i3 == 258) {
            W3();
            return;
        }
        if (i3 == 260) {
            ITroopInfoService iTroopInfoService = (ITroopInfoService) this.D0.getRuntimeService(ITroopInfoService.class, "");
            if (iTroopInfoService != null && (findTroopInfo = iTroopInfoService.findTroopInfo(this.f299892g0.troopUin)) != null) {
                this.f299895j0 = findTroopInfo;
                this.f299892g0.updateForTroopInfo(findTroopInfo, this.D0.getCurrentAccountUin());
            }
            U3();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (getAppRuntime() instanceof AppInterface) {
            this.D0 = (AppInterface) getAppRuntime();
        }
        if (this.D0 == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
        } else {
            j3 = 0;
        }
        this.f299898m0 = getIntent().getExtras().getBoolean("returnMsgList", false);
        if (!c3()) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, "onCreate, illegal param, troopuin = " + this.f299892g0.troopUin);
            }
            finish();
            return true;
        }
        if (this.f299892g0.isGameTroop()) {
            TroopBindGameItemHelper troopBindGameItemHelper = new TroopBindGameItemHelper(this, this.f299892g0.troopUin);
            this.f299889d0 = troopBindGameItemHelper;
            troopBindGameItemHelper.j();
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.D0.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.D0);
        this.f299910y0 = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        initUI();
        if (QLog.isColorLevel()) {
            QLog.i("TroopInfoActivity", 2, "onCreate(), time = " + (System.currentTimeMillis() - j3));
        }
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).bnrReport(this.D0, 78);
        AppInterface appInterface = this.D0;
        String str2 = this.f299892g0.troopUin;
        String valueOf = String.valueOf(this.f299902q0);
        if (this.f299892g0.bOwner) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(appInterface, "P_CliOper", "Grp_create", "", "edit_data", "edit", 0, 0, str2, valueOf, str, "");
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.f299896k0 = true;
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
        } else {
            j3 = 0;
        }
        com.tencent.mobileqq.troop.troopcatalog.b.g().b();
        removeObserver(this.I0);
        removeObserver(this.H0);
        removeObserver(this.G0);
        removeObserver(this.E0);
        com.tencent.mobileqq.troop.avatar.e eVar = this.f299909x0;
        if (eVar != null) {
            eVar.h(this.M0);
        }
        TroopPhotoController troopPhotoController = this.f299907v0;
        if (troopPhotoController != null) {
            troopPhotoController.C();
        }
        TroopAvatarController troopAvatarController = this.f299908w0;
        if (troopAvatarController != null) {
            troopAvatarController.C();
        }
        IFaceDecoder iFaceDecoder = this.f299910y0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        TroopBindGameItemHelper troopBindGameItemHelper = this.f299889d0;
        if (troopBindGameItemHelper != null) {
            troopBindGameItemHelper.p();
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopInfoActivity", 2, "onDestroy(), time = " + (System.currentTimeMillis() - j3));
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        String stringExtra2 = intent.getStringExtra(ITroopPhotoUtilsApi.KEY_CLIP_INFO);
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, String.format("doOnNewIntent bAvatarEdit=%b clip=%s path=%s", Boolean.valueOf(this.f299906u0), stringExtra2, stringExtra));
            }
            if (this.f299906u0) {
                TroopAvatarController troopAvatarController = this.f299908w0;
                if (troopAvatarController != null) {
                    troopAvatarController.G(stringExtra, stringExtra2);
                    return;
                }
                return;
            }
            TroopPhotoController troopPhotoController = this.f299907v0;
            if (troopPhotoController != null) {
                troopPhotoController.G(stringExtra, stringExtra2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        if (z16 && !this.f299893h0) {
            this.F0.sendEmptyMessage(1);
        }
    }

    protected void e4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (this.f299895j0 != null && this.f299892g0.isMember) {
            if (QLog.isDevelopLevel()) {
                QLog.i("TroopInfoActivity", 4, "updateTroopInfoToDB");
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.troop.api.handler.i iVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppInterface appInterface = TroopInfoActivity.this.D0;
                    if (appInterface != null && (iVar = (com.tencent.mobileqq.troop.api.handler.i) appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())) != null) {
                        iVar.b(com.tencent.mobileqq.troop.api.observer.c.f294313e, true, TroopInfoActivity.this.f299895j0.troopuin);
                    }
                }
            }, 5, null, false);
        }
    }

    protected void f3(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (textView != null && linearLayout != null && !TextUtils.isEmpty(textView.getText())) {
            int measureText = (int) textView.getPaint().measureText(textView.getText().toString());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            if (this.f299911z0) {
                layoutParams.leftMargin = measureText + Utils.n(40.0f, getResources());
            } else {
                layoutParams.leftMargin = measureText + Utils.n(30.0f, getResources());
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        TroopInfoData troopInfoData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        h3();
        b4();
        TroopInfoData troopInfoData2 = this.f299892g0;
        if (troopInfoData2 != null && troopInfoData2.f294880pa != 28) {
            setResult(-1, getIntent());
        }
        if (this.f299898m0) {
            s3();
        }
        if (this.f299911z0 && (troopInfoData = this.f299892g0) != null && troopInfoData.troopUin != null && !troopInfoData.isNewTroop && this.A0) {
            Intent intent = new Intent();
            intent.putExtra("openSearchTroopWay", true);
            setResult(-1, intent);
        }
        super.finish();
        int i3 = this.f299903r0;
        if (i3 != 1) {
            if (i3 == 2) {
                overridePendingTransition(0, R.anim.f154480ae);
                return;
            }
            return;
        }
        overridePendingTransition(0, R.anim.f154423k);
    }

    public void g4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        TroopInfoData troopInfoData = this.f299892g0;
        if (troopInfoData == null) {
            return;
        }
        if (!TextUtils.isEmpty(troopInfoData.troopLocation)) {
            TroopInfoData troopInfoData2 = this.f299892g0;
            if (troopInfoData2.troopLat != 0 && troopInfoData2.troopLon != 0) {
                X3(5, troopInfoData2.troopLocation, true);
                return;
            }
        }
        if (this.f299892g0.isOwnerOrAdim()) {
            if (!TextUtils.isEmpty(this.f299892g0.troopLocation)) {
                X3(5, this.f299892g0.troopLocation, true);
                return;
            } else {
                X3(5, HardCodeUtil.qqStr(R.string.f172822ui1), true);
                return;
            }
        }
        if (!TextUtils.isEmpty(this.f299892g0.troopLocation)) {
            X3(5, this.f299892g0.troopLocation, false);
            return;
        }
        View view = this.f299888c0[5];
        if (view != null) {
            view.setVisibility(8);
        }
    }

    void h3() {
        Dialog dialog = this.f299900o0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.f299900o0.dismiss();
            }
            this.f299900o0 = null;
        }
    }

    protected void h4() {
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        View view = this.f299888c0[10];
        if (view != null) {
            TroopInfoData troopInfoData = this.f299892g0;
            if (troopInfoData.hasSetNewTroopName) {
                qqStr = troopInfoData.newTroopName;
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.khr);
            }
            SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(qqStr, 16);
            TextView textView = (TextView) view.findViewById(R.id.info);
            if (textView != null) {
                textView.setText(spannableStringFromColorNickText);
            }
            if (this.f299911z0) {
                T3(10, true);
            } else {
                T3(10, false);
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, String.format("updateTroopNameEntry %s", qqStr));
            }
        }
    }

    public void hideJuhua() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        try {
            QQProgressDialog qQProgressDialog = this.J0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.J0.dismiss();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, e16.toString());
            }
        }
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopInfoActivity", 2, "init(), isInitialized = " + this.f299893h0);
        }
        if (this.f299893h0) {
            return;
        }
        this.f299893h0 = true;
        addObserver(this.I0);
        addObserver(this.H0);
        addObserver(this.G0);
        ThreadManagerV2.post(new AnonymousClass8(), 5, null, true);
    }

    protected void initUI() {
        int i3;
        String str;
        boolean z16;
        String n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        View inflate = View.inflate(this, R.layout.b3v, null);
        ListView listView = (ListView) inflate.findViewById(R.id.alr);
        ArrayList arrayList = new ArrayList();
        arrayList.add(HardCodeUtil.qqStr(R.string.f172821ui0));
        arrayList.add(HardCodeUtil.qqStr(R.string.uhz));
        listView.setAdapter((ListAdapter) new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrayList));
        listView.setVisibility(4);
        XListView xListView = (XListView) inflate.findViewById(R.id.common_xlistview);
        this.f299904s0 = xListView;
        xListView.setVerticalScrollBarEnabled(false);
        this.f299904s0.setDivider(null);
        this.f299888c0 = new View[14];
        this.f299887b0 = new LinearLayout(this);
        this.f299887b0.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.f299887b0.setOrientation(1);
        this.f299887b0.setFocusable(false);
        this.f299887b0.setClickable(false);
        w3(this.f299904s0);
        this.f299904s0.setAdapter((ListAdapter) new XSimpleListAdapter(this.f299887b0));
        this.f299904s0.setBackgroundResource(R.drawable.bg_texture);
        this.f299904s0.setFocusable(false);
        this.f299904s0.setClickable(false);
        this.f299886a0 = ((ITroopInfoService) this.D0.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(this.f299892g0.troopUin);
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoActivity", 2, "mIsQidianPrivateTroop : " + this.f299886a0 + ", troopUin = " + this.f299892g0.troopUin);
        }
        super.setContentView(inflate);
        String string = getIntent().getExtras().getString(AppConstants.Key.TROOP_INFO_TITLE);
        if (TextUtils.isEmpty(string)) {
            if (this.f299911z0) {
                string = getString(R.string.f236687f1);
            } else {
                string = getString(R.string.f173232i74);
            }
        }
        setTitle(string);
        if ((this.f299892g0.dwGroupFlagExt & 2048) != 0) {
            View inflate2 = View.inflate(this, R.layout.b3y, null);
            this.f299888c0[7] = inflate2;
            this.f299887b0.addView(inflate2);
            String string2 = getString(R.string.bth);
            String str2 = this.f299892g0.troopAuthenticateInfo;
            i3 = R.layout.b3y;
            str = "TroopInfoActivity";
            z16 = true;
            z3(7, 0, inflate2, string2, str2, false);
            this.f299887b0.addView(View.inflate(this, R.layout.b4b, null));
        } else {
            i3 = R.layout.b3y;
            str = "TroopInfoActivity";
            z16 = true;
        }
        if (this.f299911z0) {
            this.f299887b0.addView(e3(HardCodeUtil.qqStr(R.string.f235037ak)));
        }
        View inflate3 = View.inflate(this, i3, null);
        this.f299888c0[10] = inflate3;
        this.f299887b0.addView(inflate3);
        inflate3.setTag(10);
        z3(10, 2, inflate3, getString(R.string.atv), "", true);
        h4();
        f3(inflate3);
        View inflate4 = View.inflate(this, i3, null);
        this.f299888c0[11] = inflate4;
        this.f299887b0.addView(inflate4);
        U3();
        inflate4.setOnClickListener(this);
        if (this.f299911z0) {
            this.f299887b0.addView(e3(HardCodeUtil.qqStr(R.string.f23263753)));
        }
        View inflate5 = View.inflate(this, i3, null);
        this.f299888c0[12] = inflate5;
        this.f299887b0.addView(inflate5);
        y3();
        inflate5.setOnClickListener(this);
        View inflate6 = View.inflate(this, i3, null);
        this.f299888c0[5] = inflate6;
        this.f299887b0.addView(inflate6);
        String string3 = getString(R.string.i9l);
        TroopInfoData troopInfoData = this.f299892g0;
        z3(5, 2, inflate6, string3, troopInfoData.troopLocation, troopInfoData.isOwnerOrAdim());
        f4(inflate6);
        g4();
        View inflate7 = View.inflate(this, i3, null);
        this.f299888c0[4] = inflate7;
        this.f299887b0.addView(inflate7);
        String string4 = getString(R.string.i5u);
        TroopInfoData troopInfoData2 = this.f299892g0;
        z3(4, 2, inflate7, string4, troopInfoData2.troopClass, troopInfoData2.isOwnerOrAdim());
        if (this.f299889d0 == null) {
            this.f299889d0 = new TroopBindGameItemHelper(this, this.f299892g0.troopUin);
        }
        this.f299887b0.addView(this.f299889d0.l());
        this.f299889d0.s(this.f299892g0.isGameTroop());
        if (this.f299892g0.isHomeworkTroop()) {
            View inflate8 = View.inflate(this, i3, null);
            this.f299888c0[13] = inflate8;
            this.f299887b0.addView(inflate8);
            inflate8.setTag(13);
            z3(13, 2, inflate8, getString(R.string.f23264754), "", true);
            d4();
        }
        View inflate9 = View.inflate(this, R.layout.b3x, null);
        this.f299888c0[8] = inflate9;
        this.f299887b0.addView(inflate9);
        x3(8, 3, inflate9, getString(R.string.i5w), null, this.f299892g0.isOwnerOrAdim());
        if (this.f299911z0) {
            inflate9.setBackgroundResource(R.drawable.common_strip_setting_middle);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopInfoActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList<String> l3 = TroopInfoActivity.l3(TroopInfoActivity.this.f299892g0);
                if (l3 != null) {
                    ThreadManager.getUIHandler().post(new Runnable(l3) { // from class: com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ArrayList f299916d;

                        {
                            this.f299916d = l3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) l3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            TroopInfoActivity troopInfoActivity = TroopInfoActivity.this;
                            if (troopInfoActivity.f299896k0) {
                                return;
                            }
                            troopInfoActivity.V3(8, this.f299916d, true);
                        }
                    });
                }
            }
        }, 8, null, z16);
        if (!this.f299911z0) {
            this.f299887b0.addView(View.inflate(this, R.layout.b4b, null));
        }
        View inflate10 = View.inflate(this, R.layout.f168896b44, null);
        this.f299888c0[6] = inflate10;
        this.f299887b0.addView(inflate10);
        if (!TextUtils.isEmpty(this.f299892g0.mRichFingerMemo)) {
            n3 = this.f299892g0.mRichFingerMemo;
        } else {
            n3 = n3();
        }
        z3(6, 3, inflate10, getString(R.string.bxj), n3, this.f299892g0.isOwnerOrAdim());
        if (!this.f299911z0) {
            this.f299887b0.addView(View.inflate(this, R.layout.b4b, null), new LinearLayout.LayoutParams(-1, (int) (this.mDensity * 60.0f)));
        }
        this.f299890e0 = inflate.findViewById(R.id.agk);
        this.f299891f0 = (Button) inflate.findViewById(R.id.aek);
        if (this.f299892g0.isMember) {
            if (this.f299911z0) {
                R3(18);
            } else {
                R3(14);
            }
        } else {
            R3(15);
        }
        this.f299891f0.setOnClickListener(this);
        if (this.f299911z0) {
            this.leftView.setText("\u53d6\u6d88");
            this.leftView.setBackgroundDrawable(null);
            this.leftView.setPadding(0, 5, 52, 5);
        }
        this.leftView.setOnClickListener(new h());
        this.rightViewText.setOnClickListener(new i());
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, "initUI: time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    void notifyUser(int i3, int i16) {
        QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show(getTitleBarHeight());
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            b3();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        String str4;
        boolean z18;
        int i3;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i16;
        String str10;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                String str11 = "2";
                switch (((Integer) tag).intValue()) {
                    case 4:
                        TroopBindGameItemHelper troopBindGameItemHelper = this.f299889d0;
                        if (troopBindGameItemHelper != null && troopBindGameItemHelper.k() == 1) {
                            QQToast.makeText(getApplicationContext(), 1, HardCodeUtil.qqStr(R.string.f172825ui4), 0).show();
                            break;
                        } else {
                            AppInterface appInterface = this.D0;
                            TroopInfoData troopInfoData = this.f299892g0;
                            String str12 = troopInfoData.troopUin;
                            if (this.f299911z0) {
                                str = "2";
                            } else {
                                str = "1";
                            }
                            if (troopInfoData.bOwner) {
                                str11 = "0";
                            } else if (troopInfoData.bAdmin) {
                                str11 = "1";
                            }
                            ReportController.o(appInterface, "dc00899", "Grp_set", "", "Grp_data", "add_category", 0, 0, str12, str, str11, "");
                            if (((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).getExperimentResultAndReport()) {
                                ((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).openCreateTroopByCategoryPageFromSetting(this, Long.toString(this.f299892g0.dwGroupClassExt));
                                break;
                            } else {
                                Intent intent = new Intent(getActivity(), ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopClassChoiceActivtiyClass());
                                intent.putExtra("troopGroupClassExt", Long.toString(this.f299892g0.dwGroupClassExt));
                                startActivityForResult(intent, 11);
                                break;
                            }
                        }
                        break;
                    case 5:
                        L3();
                        break;
                    case 6:
                        Intent intent2 = new Intent();
                        intent2.putExtra(QZoneContant.KEY_EDIT_TYPE, 2);
                        intent2.putExtra("edit_mode", 1);
                        intent2.putExtra("title", getString(R.string.bxj));
                        intent2.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, this.f299892g0.mRichFingerMemo);
                        intent2.putExtra("max_num", 900);
                        intent2.putExtra("canPostNull", true);
                        intent2.putExtra("support_emotion", true);
                        intent2.putExtra("full_screen", true);
                        RouteUtils.startActivityForResult(this, intent2, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 5);
                        if (this.f299911z0) {
                            str2 = "2";
                        } else {
                            str2 = "1";
                        }
                        report("Grp_moredata", "Clk_brief", str2);
                        break;
                    case 8:
                        AppInterface appInterface2 = this.D0;
                        TroopInfoData troopInfoData2 = this.f299892g0;
                        String str13 = troopInfoData2.troopUin;
                        if (this.f299911z0) {
                            str3 = "2";
                        } else {
                            str3 = "1";
                        }
                        if (troopInfoData2.bOwner) {
                            str11 = "0";
                        } else if (troopInfoData2.bAdmin) {
                            str11 = "1";
                        }
                        ReportController.o(appInterface2, "dc00899", "Grp_set", "", "Grp_data", "add_tag", 0, 0, str13, str3, str11, "");
                        p3();
                        break;
                    case 10:
                        TroopInfoData troopInfoData3 = this.f299892g0;
                        if (troopInfoData3 != null) {
                            TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopInfoData3.troopUin);
                            if (troopInfoFromCache != null && troopInfoFromCache.canModifyTroopName()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("[onClick] DATA_TAG_TROOP_NAME_ENTRY canChangeTroopName:");
                            sb5.append(z16);
                            sb5.append(", info:");
                            if (troopInfoFromCache != null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            sb5.append(z17);
                            QLog.i("TroopInfoActivity", 1, sb5.toString());
                            if (z16) {
                                if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable) {
                                    TroopInfoData troopInfoData4 = this.f299892g0;
                                    if (troopInfoData4.mIsFreezed == 1 && troopInfoData4.isOwnerOrAdim()) {
                                        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).handleModifyNameFreezed(this.f299892g0, this);
                                        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009E37", 1, 0, "", "", "", "");
                                        break;
                                    }
                                }
                                TroopInfoData troopInfoData5 = this.f299892g0;
                                String str14 = "";
                                if (!troopInfoData5.hasSetNewTroopName) {
                                    str4 = "";
                                } else {
                                    str4 = troopInfoData5.newTroopName;
                                }
                                if (str4 == null) {
                                    str4 = "";
                                }
                                if (!this.f299886a0 && !troopInfoData5.isNewTroop) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                Intent intent3 = new Intent();
                                intent3.putExtra(QZoneContant.KEY_EDIT_TYPE, 1);
                                intent3.putExtra("edit_mode", 2);
                                intent3.putExtra("max_limit_mode", 1);
                                if (z16) {
                                    i3 = R.string.kh6;
                                } else {
                                    i3 = R.string.kh5;
                                }
                                intent3.putExtra("title", HardCodeUtil.qqStr(i3));
                                intent3.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str4);
                                intent3.putExtra("max_num", 96);
                                intent3.putExtra("canPostNull", false);
                                if (!z16) {
                                    str5 = "";
                                } else {
                                    str5 = HardCodeUtil.qqStr(R.string.kgq);
                                }
                                intent3.putExtra("right_btn", str5);
                                intent3.putExtra("edit_mode", z16);
                                if (z18) {
                                    str14 = this.f299892g0.troopUin;
                                }
                                intent3.putExtra("troopUin", str14);
                                intent3.putExtra("default_hint", HardCodeUtil.qqStr(R.string.f235047al));
                                RouteUtils.startActivityForResult(this, intent3, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 18);
                                AppInterface appInterface3 = this.D0;
                                TroopInfoData troopInfoData6 = this.f299892g0;
                                String str15 = troopInfoData6.troopUin;
                                if (this.f299911z0) {
                                    str6 = "2";
                                } else {
                                    str6 = "1";
                                }
                                if (troopInfoData6.bOwner) {
                                    str7 = "0";
                                } else if (!troopInfoData6.bAdmin) {
                                    str7 = "2";
                                } else {
                                    str7 = "1";
                                }
                                ReportController.o(appInterface3, "dc00899", "Grp_set", "", "Grp_data", "add_name", 0, 0, str15, str6, str7, "");
                                break;
                            }
                        }
                        break;
                    case 11:
                        TroopInfoData troopInfoData7 = this.f299892g0;
                        if (troopInfoData7.hasSetNewTroopHead) {
                            t3(11);
                        } else if (troopInfoData7.isOwnerOrAdim()) {
                            if (this.f299908w0 == null) {
                                Bundle bundle = new Bundle();
                                bundle.putString("troopUin", this.f299892g0.troopUin);
                                bundle.putInt("type", 1);
                                TroopAvatarController troopAvatarController = new TroopAvatarController(this, this, this.D0, bundle);
                                this.f299908w0 = troopAvatarController;
                                troopAvatarController.N(this);
                            }
                            this.f299906u0 = true;
                            this.f299908w0.H();
                            if (this.f299909x0 == null) {
                                com.tencent.mobileqq.troop.avatar.e eVar = new com.tencent.mobileqq.troop.avatar.e(this.f299892g0.troopUin, com.tencent.mobileqq.troop.avatar.f.class, this.D0);
                                this.f299909x0 = eVar;
                                eVar.b(this.M0);
                            }
                        }
                        AppInterface appInterface4 = this.D0;
                        TroopInfoData troopInfoData8 = this.f299892g0;
                        String str16 = troopInfoData8.troopUin;
                        if (this.f299911z0) {
                            str8 = "2";
                        } else {
                            str8 = "1";
                        }
                        if (troopInfoData8.bOwner) {
                            str9 = "0";
                        } else if (!troopInfoData8.bAdmin) {
                            str9 = "2";
                        } else {
                            str9 = "1";
                        }
                        ReportController.o(appInterface4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_image", 0, 0, str16, str8, str9, "");
                        break;
                    case 12:
                        if (this.f299892g0 != null) {
                            Object tag2 = view.getTag(R.string.i9k);
                            if (tag2 != null && (tag2 instanceof Integer)) {
                                i16 = ((Integer) tag2).intValue();
                            } else {
                                i16 = 0;
                            }
                            if (i16 > 0) {
                                t3(12);
                            } else {
                                if (this.f299907v0 == null) {
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("troopUin", this.f299892g0.troopUin);
                                    bundle2.putInt("type", 1);
                                    TroopPhotoController troopPhotoController = new TroopPhotoController(this, this, this.D0, bundle2);
                                    this.f299907v0 = troopPhotoController;
                                    troopPhotoController.N(this);
                                }
                                this.f299906u0 = false;
                                this.f299907v0.H();
                            }
                            if (this.f299909x0 == null) {
                                com.tencent.mobileqq.troop.avatar.e eVar2 = new com.tencent.mobileqq.troop.avatar.e(this.f299892g0.troopUin, com.tencent.mobileqq.troop.avatar.f.class, this.D0);
                                this.f299909x0 = eVar2;
                                eVar2.b(this.M0);
                            }
                            AppInterface appInterface5 = this.D0;
                            String str17 = this.f299892g0.troopUin;
                            if (this.f299911z0) {
                                str10 = "2";
                            } else {
                                str10 = "1";
                            }
                            ReportController.o(appInterface5, "dc00899", "Grp_create_new", "", "edit_data", "cover", 0, 0, str17, str10, "", "");
                            break;
                        }
                        break;
                    case 13:
                        ReportController.o(null, "dc00898", "", "", "0X800B282", "0X800B282", 0, 0, this.f299892g0.troopUin, "", "", "");
                        if (this.f299892g0.isOwnerOrAdim()) {
                            B3();
                            break;
                        }
                        break;
                    case 15:
                        if (!NetworkUtil.isNetSupport(this)) {
                            notifyUser(R.string.f171137ci2, 0);
                            break;
                        } else {
                            S3();
                            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopInfoForJoinTroop(this.f299892g0.troopUin, "TroopInfoActivity", this, false, new Function2() { // from class: com.tencent.mobileqq.troop.troopcard.ui.e
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit F3;
                                    F3 = TroopInfoActivity.this.F3((Boolean) obj, (TroopInfo) obj2);
                                    return F3;
                                }
                            });
                            break;
                        }
                    case 18:
                        if (!NetworkUtil.isNetworkAvailable(this)) {
                            if (this.f299892g0.isNewTroop) {
                                TroopInfo troopInfo = this.f299895j0;
                                if (!troopInfo.hasSetNewTroopHead && !troopInfo.hasSetNewTroopName) {
                                    QQToast.makeText(this, 1, R.string.ci5, 0).show(getTitleBarHeight());
                                    break;
                                }
                            }
                            if (!this.f299897l0) {
                                K3();
                                break;
                            } else {
                                QQToast.makeText(this, 1, R.string.ci5, 0).show(getTitleBarHeight());
                                break;
                            }
                        } else {
                            boolean z19 = this.f299892g0.isNewTroop;
                            if (z19) {
                                TroopInfo troopInfo2 = this.f299895j0;
                                if (!troopInfo2.hasSetNewTroopHead && !troopInfo2.hasSetNewTroopName) {
                                    P3(R.string.f235637c7);
                                    break;
                                }
                            }
                            if (z19 && !this.f299895j0.hasSetNewTroopHead) {
                                P3(R.string.f235617c5);
                                break;
                            } else if (z19 && !this.f299895j0.hasSetNewTroopName) {
                                P3(R.string.f235627c6);
                                break;
                            } else {
                                K3();
                                break;
                            }
                        }
                        break;
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (bitmap != null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopInfoActivity", 2, String.format("onDecodeTaskCompleted uin=%s", str));
            }
            if (str != null && str.equals(this.f299892g0.troopUin)) {
                U3();
            }
        }
    }

    protected void p3() {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        List<String> list = this.f299892g0.troopTags;
        Intent intent = new Intent(this, ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopTagViewActivityClass());
        intent.putExtra("troopuin", this.f299892g0.troopUin);
        intent.putExtra("isAdmin", this.f299892g0.isOwnerOrAdim());
        com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(Long.toString(this.f299892g0.dwGroupClassExt));
        if (c16 != null) {
            if (!TextUtils.isEmpty(c16.f299960b) && !c16.f299960b.equals(HardCodeUtil.qqStr(R.string.ui_))) {
                str = c16.f299960b;
                z16 = true;
            }
            str = "";
            z16 = false;
        } else {
            if (!TextUtils.isEmpty(this.f299892g0.mTroopClassExtText)) {
                str = this.f299892g0.mTroopClassExtText;
                z16 = true;
            }
            str = "";
            z16 = false;
        }
        if (z16) {
            intent.putExtra("subclass", str);
        }
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next() + "\n");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            intent.putExtra(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, stringBuffer.toString());
        }
        intent.putExtra("act_type", 1);
        intent.putExtra("uin", this.D0.getCurrentAccountUin());
        intent.putExtra("modifyToSrv", 0);
        startActivityForResult(intent, 9);
    }

    protected void report(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, str2, str3);
        } else {
            ReportController.o(this.D0, "P_CliOper", "Grp_set", "", str, str2, 0, 0, this.f299892g0.troopUin, str3, "", "");
        }
    }

    public void s3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).goToMsgList(this);
        }
    }

    protected void showWaitingDialog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            return;
        }
        h3();
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        qQProgressDialog.setMessage(str);
        qQProgressDialog.setCancelable(false);
        qQProgressDialog.setOnDismissListener(new l());
        this.f299900o0 = qQProgressDialog;
        qQProgressDialog.show();
    }

    protected void x3(int i3, int i16, View view, String str, String[] strArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), view, str, strArr, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopInfoActivity", 2, "initClrTextItemView(), tag = " + i3 + ", info = " + strArr + ", bShowArrow = " + z16);
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        View findViewById = view.findViewById(R.id.f164472yw);
        if (!z16) {
            i17 = 8;
        }
        findViewById.setVisibility(i17);
        if (z16) {
            view.setTag(Integer.valueOf(i3));
            view.setOnClickListener(this);
        } else {
            view.setTag(null);
            view.setOnClickListener(null);
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        view.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                        return;
                    }
                    return;
                }
                view.setBackgroundResource(R.drawable.common_strip_setting_middle);
                return;
            }
            view.setBackgroundResource(R.drawable.common_strip_setting_top);
            return;
        }
        view.setBackgroundResource(R.drawable.common_strip_setting_bg);
    }

    protected void z3(int i3, int i16, View view, String str, CharSequence charSequence, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), view, str, charSequence, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            view.setTag(Integer.valueOf(i3));
            view.setOnClickListener(this);
        } else {
            view.setTag(null);
            view.setOnClickListener(null);
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        view.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                    }
                } else {
                    view.setBackgroundResource(R.drawable.common_strip_setting_middle);
                }
            } else {
                view.setBackgroundResource(R.drawable.common_strip_setting_top);
            }
        } else {
            view.setBackgroundResource(R.drawable.common_strip_setting_bg);
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.info);
        View findViewById = view.findViewById(R.id.f164472yw);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        if (6 == i3) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            if (TextUtils.isEmpty(charSequence)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(new QQText(charSequence, 11, 20));
            }
        } else {
            textView2.setText(charSequence);
        }
        if (!z16) {
            i17 = 8;
        }
        findViewById.setVisibility(i17);
    }
}
