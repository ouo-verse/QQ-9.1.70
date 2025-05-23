package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.image.URLDrawable;
import com.tencent.luggage.wxa.yf.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarIpcUpdateAvatarUtilsApiImpl;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.RecommendContactInfo;
import com.tencent.mobileqq.phonecontact.data.RecommendedListResp;
import com.tencent.mobileqq.phonecontact.handler.ContactBindHandler;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.bean.c;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$BindContactInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginWelcomeManager implements Manager, BusinessObserver, Runnable, od2.a {
    static IPatchRedirector $redirector_;
    public static int Z;
    private Bundle C;
    private Bundle D;
    public l92.d E;
    private IPhoneContactService F;
    private long G;
    private boolean H;
    private Handler I;
    private boolean J;
    private String K;
    private int L;
    private String M;
    private CardObserver N;
    private final ProfileCardObserver P;
    private com.tencent.mobileqq.phonecontact.observer.a Q;
    private com.tencent.mobileqq.phonecontact.observer.b R;
    n S;
    k T;
    URLDrawable U;
    m V;
    public boolean W;
    public boolean X;
    j Y;

    /* renamed from: d, reason: collision with root package name */
    public String f243074d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f243075e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f243076f;

    /* renamed from: h, reason: collision with root package name */
    private LoginWelcomeHandler f243077h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences f243078i;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<MessengerService> f243079m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this);
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer drawable onLoadSuccessed");
            }
            m mVar = LoginWelcomeManager.this.V;
            if (mVar != null) {
                mVar.b(uRLDrawable);
            }
            LoginWelcomeManager.this.L();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends l92.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this);
            }
        }

        @Override // l92.d
        public void k(boolean z16, Object obj, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj, Boolean.valueOf(z17));
                return;
            }
            NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) obj;
            if (z16 && nearbyPeopleCard != null) {
                byte[] bArr = nearbyPeopleCard.vTempChatSig;
                String str = nearbyPeopleCard.nickname;
                if (QLog.isColorLevel()) {
                    QLog.d("LoginWelcomeManager", 2, "onNearbyCardDownload " + nearbyPeopleCard.uin + " " + str);
                }
                Bundle bundle = LoginWelcomeManager.this.C.getBundle(Const.BUNDLE_KEY_REQUEST);
                bundle.putString("uin", nearbyPeopleCard.uin);
                bundle.putByteArray(PreloadTRTCPlayerParams.KEY_SIG, bArr);
                bundle.putString("nick", str);
                bundle.putString("tinyId", String.valueOf(nearbyPeopleCard.tinyId));
            } else if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "onNearbyCardDownload err" + z16 + " " + nearbyPeopleCard);
            }
            LoginWelcomeManager.this.Q();
            LoginWelcomeManager.this.f243076f.removeObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Function2<Boolean, TroopInfo, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f243082d;

        c(String str) {
            this.f243082d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this, (Object) str);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool, (Object) troopInfo);
            }
            if (bool.booleanValue()) {
                Bundle bundle = LoginWelcomeManager.this.C.getBundle(Const.BUNDLE_KEY_REQUEST);
                bundle.putString("uin", this.f243082d);
                bundle.putShort("option", troopInfo.cGroupOption);
                bundle.putString("name", troopInfo.troopname);
                short s16 = troopInfo.cGroupOption;
                if (s16 != 4 && s16 != 5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("LoginWelcomeManager", 2, "[getJoinTroopData] err");
                    }
                } else {
                    bundle.putString("answer", troopInfo.joinTroopAnswer);
                    bundle.putString("question", troopInfo.joinTroopQuestion);
                }
            }
            LoginWelcomeManager.this.Q();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d extends IPublicAccountObserver.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f243084a;

        d(Bundle bundle) {
            this.f243084a = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this, (Object) bundle);
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "onFollowPublicAccount uin=" + str + ", isSuccess=" + z16);
            }
            this.f243084a.putInt("result", z16 ? 1 : 0);
            this.f243084a.putString("uin", str);
            LoginWelcomeManager.this.Q();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e extends CardObserver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onUpdateAvatar(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            QLog.d("LoginWelcomeManager", 1, String.format("mCardObserver.onUpdateAvatar isSuccess=%s uin=%s", Boolean.valueOf(z16), str));
            if (TextUtils.equals(LoginWelcomeManager.this.f243076f.getCurrentAccountUin(), str)) {
                if (LoginWelcomeManager.this.C != null) {
                    Bundle bundle = LoginWelcomeManager.this.C.getBundle(Const.BUNDLE_KEY_REQUEST);
                    if (bundle != null) {
                        bundle.putInt("result", z16 ? 1 : 0);
                        bundle.putString("path", LoginWelcomeManager.this.M);
                        LoginWelcomeManager.this.M = null;
                    }
                    LoginWelcomeManager.this.Q();
                }
                LoginWelcomeManager.this.f243076f.removeObserver(LoginWelcomeManager.this.N);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, String.format("onCardDownload isSuccess=%s data=%s", Boolean.valueOf(z16), obj));
            }
            if (LoginWelcomeManager.this.C != null) {
                if (z16 && obj != null) {
                    try {
                        Bundle bundle = LoginWelcomeManager.this.C.getBundle(Const.BUNDLE_KEY_REQUEST);
                        String string = bundle.getString("uin");
                        long parseLong = Long.parseLong(LoginWelcomeManager.this.f243076f.getCurrentAccountUin());
                        long parseLong2 = Long.parseLong(string);
                        String string2 = bundle.getString("authSig");
                        String d16 = TroopUtils.d(LoginWelcomeManager.this.f243076f, (Card) obj);
                        LoginWelcomeManager.this.y(string, d16, 1, string2, TroopUtils.b(LoginWelcomeManager.this.f243076f, d16, parseLong, parseLong2));
                    } catch (Exception e16) {
                        QLog.e("LoginWelcomeManager", 1, "onCardDownload fail.", e16);
                    }
                } else {
                    LoginWelcomeManager.this.Q();
                }
                LoginWelcomeManager.this.f243076f.removeObserver(LoginWelcomeManager.this.P);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class g extends com.tencent.mobileqq.phonecontact.observer.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.a
        protected void a(RecommendedListResp recommendedListResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recommendedListResp);
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("LoginWelcomeManager", 2, String.format("onGetRecommendedList resp=%s", recommendedListResp));
                }
                if (LoginWelcomeManager.this.C != null) {
                    Bundle bundle = LoginWelcomeManager.this.C.getBundle(Const.BUNDLE_KEY_REQUEST);
                    if (bundle != null) {
                        bundle.putParcelable("result", recommendedListResp);
                    }
                    LoginWelcomeManager.this.Q();
                }
                LoginWelcomeManager.this.f243076f.removeObserver(LoginWelcomeManager.this.Q);
            } catch (Throwable th5) {
                QLog.e("LoginWelcomeManager", 1, "onGetRecommendedList fail.", th5);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.a
        protected void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, String.format("ShowCommonGuideWebResult result=%s", Boolean.valueOf(z16)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class h extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onGetNewerGuideRecommended(List<RecommendContactInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            } else {
                LoginWelcomeManager.this.E(list);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onGetNewerGuideRecommendedNotBind(List<RecommendContactInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                LoginWelcomeManager.this.E(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class i implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f243090d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecentUser f243091e;

        i(l lVar, RecentUser recentUser) {
            this.f243090d = lVar;
            this.f243091e = recentUser;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LoginWelcomeManager.this, lVar, recentUser);
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable onLoadSuccessed");
            }
            l lVar = this.f243090d;
            lVar.f243100a = true;
            lVar.f243101b = uRLDrawable;
            uRLDrawable.setURLDrawableListener(null);
            LoginWelcomeManager.this.K(this.f243091e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f243093a;

        /* renamed from: b, reason: collision with root package name */
        public String f243094b;

        public j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f243093a = 0;
                this.f243094b = null;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "CommonGuideInfo|webUrl=" + this.f243094b + ",type=" + this.f243093a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class k {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f243095a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f243096b;

        /* renamed from: c, reason: collision with root package name */
        public String f243097c;

        /* renamed from: d, reason: collision with root package name */
        public int f243098d;

        /* renamed from: e, reason: collision with root package name */
        public int f243099e;

        public k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f243095a = false;
            this.f243096b = false;
            this.f243097c = "";
            this.f243098d = -1;
            this.f243099e = -1;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ContactsGuideInfo|showWelcomepage=" + this.f243095a + ",showConvGuideEntrance=" + this.f243096b + ",friends_recomm_flag=" + this.f243098d + ",groups_recomm_flag=" + this.f243099e + JefsClass.INDEX_URL + this.f243097c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f243100a;

        /* renamed from: b, reason: collision with root package name */
        public URLDrawable f243101b;

        public l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f243100a = false;
                this.f243101b = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface m {
        void a(j jVar);

        void b(URLDrawable uRLDrawable);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class n {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f243102a;

        /* renamed from: b, reason: collision with root package name */
        public String f243103b;

        /* renamed from: c, reason: collision with root package name */
        public int f243104c;

        public n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f243102a = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121837_iSfyMAuKAV.png";
            this.f243103b = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121848_eHHesyqska.png";
            this.f243104c = 360;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "popup_url=" + this.f243102a + "\nfixed_entrance_url=" + this.f243103b + "\nrequest_interval=" + this.f243104c;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            Z = 0;
        }
    }

    public LoginWelcomeManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243075e = false;
        this.E = new b();
        this.F = null;
        this.I = new Handler(Looper.getMainLooper());
        this.L = 0;
        this.M = null;
        this.N = new e();
        this.P = new f();
        this.Q = new g();
        this.R = new h();
        this.T = null;
        this.Y = null;
        this.f243076f = qQAppInterface;
        this.f243077h = (LoginWelcomeHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOGIN_WELCOME_HANDLER);
        this.f243076f.addObserver(this, true);
        this.f243076f.registObserver(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str, boolean z16, int i3, String str2, com.tencent.qqnt.bean.c cVar) {
        int i16 = 1;
        if (z16) {
            QQToast.makeText(this.f243076f.getApp(), 5, R.string.f173066h23, 1).show();
            Bundle bundle = this.C.getBundle(Const.BUNDLE_KEY_REQUEST);
            if (bundle != null) {
                bundle.putString("uin", String.valueOf(str));
                if (i3 != 0) {
                    i16 = 0;
                }
                bundle.putInt("result", i16);
            }
        } else {
            QQToast.makeText(this.f243076f.getApp(), 4, R.string.f173065h22, 1).show();
        }
        Q();
    }

    public static void B(QQAppInterface qQAppInterface) {
        int i3 = Z;
        if (i3 > 0) {
            ReportController.n(qQAppInterface, "dc00898", "", "", "0X8009F4B", "0X8009F4B", 0, i3, 0, "", "", "", "");
        }
        Z = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(RecentUser recentUser) {
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "realShowCGRU");
        }
        RecentUserProxy m3 = this.f243076f.getProxyManager().m();
        recentUser.lastmsgtime = -1L;
        recentUser.lastmsgdrafttime = -1L;
        recentUser.opTime = -1L;
        recentUser.showUpTime = -1L;
        m3.saveRecentUser(recentUser);
        MqqHandler handler = this.f243076f.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    public static void N(QQAppInterface qQAppInterface, int i3) {
        if (qQAppInterface == null) {
            return;
        }
        ((ContactBindHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER)).H2(qQAppInterface.getCurrentAccountUin(), i3);
    }

    public static void O(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return;
        }
        ((ContactBindHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER)).I2(qQAppInterface.getCurrentAccountUin());
        R(qQAppInterface, true);
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009F49", "0X8009F49", 0, 0, "", "", "", "");
    }

    public static void R(QQAppInterface qQAppInterface, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "saveContactsGuidePopWindowState\uff0chasAlert=" + z16);
        }
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences.Editor edit = qQAppInterface.getPreferences().edit();
        edit.putBoolean("sp_key_contactsguide_popwindow_state", z16);
        edit.commit();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        if (r4 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String S(String str) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        File file;
        Bitmap createScaledBitmap;
        FileOutputStream fileOutputStream2 = null;
        r1 = null;
        String str2 = null;
        try {
            File file2 = new File(AppConstants.PATH_NEWER_GUIDE_DIR_NAME);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            file = new File(file2, "temp_avatar");
            if (file.exists()) {
                file.delete();
            }
            createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(str), 200, 200, true);
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Exception e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                if (bufferedOutputStream != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream = null;
            if (fileOutputStream2 != null) {
            }
            if (bufferedOutputStream != null) {
            }
        }
        try {
            try {
                createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                str2 = file.getAbsolutePath();
                try {
                    fileOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                        throw th;
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            QLog.e("LoginWelcomeManager", 1, "saveTempAvatarFile fail!", e);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused4) {
                }
            }
        }
        try {
            bufferedOutputStream.close();
        } catch (Exception unused5) {
            return str2;
        }
    }

    private void T(Bundle bundle) {
        String string = bundle.getString("path");
        boolean z16 = bundle.getBoolean(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, false);
        String string2 = bundle.getString("PhotoConst.SOURCE_FROM");
        this.M = S(string);
        Intent intent = new Intent();
        intent.putExtra(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, z16);
        intent.putExtra("PhotoConst.SOURCE_FROM", string2);
        if (ProfileCardUtil.h0(this.f243076f, string, intent)) {
            this.f243076f.addObserver(this.N);
        } else {
            bundle.putInt("result", 0);
            Q();
        }
    }

    public static LoginWelcomeManager o(QQAppInterface qQAppInterface) {
        return (LoginWelcomeManager) qQAppInterface.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER);
    }

    public static boolean x(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return true;
        }
        boolean z16 = qQAppInterface.getPreferences().getBoolean("sp_key_contactsguide_popwindow_state", false);
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "hasContactsGuidePopWindow\uff0chasAlert=" + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final String str, String str2, int i3, String str3, byte[] bArr) {
        JoinTroopParam joinTroopParam = new JoinTroopParam(str, i3, "", str3);
        joinTroopParam.k(str2);
        joinTroopParam.j(bArr);
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).joinGroup(joinTroopParam, null, "LoginWelcomeManager", new com.tencent.qqnt.troop.d() { // from class: com.tencent.mobileqq.loginwelcome.a
            @Override // com.tencent.qqnt.troop.d
            public final void a(boolean z16, int i16, String str4, c cVar) {
                LoginWelcomeManager.this.A(str, z16, i16, str4, cVar);
            }
        });
    }

    @Override // od2.a
    public void B7(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        }
    }

    public void C(boolean z16, Object obj) {
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (z16 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2 && (obj2 = objArr[1]) != null && (obj2 instanceof j)) {
                this.Y = (j) obj2;
                W();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "onGetCommonGuide\uff0cisSuccess=" + z16 + ", mCommonGuideInfo=" + p());
        }
    }

    public void D(boolean z16, Object obj) {
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (z16 && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1 && (obj2 = objArr[0]) != null) {
                this.T = (k) obj2;
                X();
                Y();
                SharedPreferences.Editor edit = this.f243078i.edit();
                edit.putBoolean("sp_key_show_convguide_entrance", this.T.f243096b);
                edit.commit();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "onGetContactsGuide\uff0cisSuccess=" + z16 + ", mContactsGuideInfo=" + q());
        }
    }

    public void E(List<RecommendContactInfo> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            int i3 = 0;
            objArr[0] = list;
            if (list != null) {
                i3 = list.size();
            }
            objArr[1] = Integer.valueOf(i3);
            QLog.d("LoginWelcomeManager", 2, String.format("onGetNewerGuideRecommended list=%s, count=%s", objArr));
        }
        if (this.D == null) {
            return;
        }
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            for (RecommendContactInfo recommendContactInfo : list) {
                recommendContactInfo.E = MsfSdkUtils.insertMtype("QQHeadIcon", recommendContactInfo.f258450i + AvatarDownloadUtil.getQQHeadImageSize((byte) recommendContactInfo.f258451m)) + "&t=" + System.currentTimeMillis();
                jSONArray.mo162put(recommendContactInfo.a());
            }
            str = jSONArray.toString();
        } else {
            str = "";
        }
        Bundle bundle = this.D.getBundle(Const.BUNDLE_KEY_REQUEST);
        if (bundle != null) {
            bundle.putString("op_result", str);
        }
        MessengerService messengerService = this.f243079m.get();
        if (messengerService != null) {
            messengerService.J(this.D);
        }
    }

    public void F(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Boolean.valueOf(z16), obj);
            return;
        }
        if (z16 && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 3 && objArr[2].equals(Boolean.FALSE)) {
                SharedPreferences.Editor edit = this.f243078i.edit();
                edit.putBoolean("request_state", false);
                edit.commit();
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "onSetRequestOpen\uff0creqOpen=" + objArr[2]);
            }
        }
    }

    public void G(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) nVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "onUpdateConfig, \n" + nVar);
        }
        this.S = nVar;
    }

    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, String.format("onUploadContactsCompleted success=%s", Boolean.valueOf(z16)));
        }
        Bundle bundle = this.D;
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
        if (bundle2 != null) {
            bundle2.putInt("result", z16 ? 1 : 0);
        }
        MessengerService messengerService = this.f243079m.get();
        if (messengerService != null) {
            messengerService.J(this.D);
        }
    }

    public void I() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "realGetRecommendedList");
        }
        Bundle bundle = this.D;
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
        if (bundle2 != null) {
            i3 = bundle2.getInt("wantCount");
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            i3 = 21;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedList wantCount=%s", Integer.valueOf(i3)));
        }
        NewIntent newIntent = new NewIntent(this.f243076f.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 36);
        newIntent.putExtra("unique_phone_no", this.F.getUNIQUE_NO());
        newIntent.putExtra("wantCount", i3);
        this.f243076f.startServlet(newIntent);
    }

    public void J() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "realGetRecommendedListNotBind");
        }
        Bundle bundle = this.D;
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
        if (bundle2 != null) {
            i3 = bundle2.getInt("wantCount");
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            i3 = 21;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedListNotBind wantCount=%s", Integer.valueOf(i3)));
        }
        NewIntent newIntent = new NewIntent(this.f243076f.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 40);
        newIntent.putExtra("unique_phone_no", this.F.getUNIQUE_NO());
        newIntent.putExtra("wantCount", i3);
        this.f243076f.startServlet(newIntent);
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        URLDrawable uRLDrawable = this.U;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
            this.U = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "relCGDrawable");
        }
    }

    @Override // od2.a
    public void L1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "removeCGRU");
        }
        RecentUserProxy m3 = this.f243076f.getProxyManager().m();
        if (m3.findRecentUser(AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN, AppConstants.VALUE.UIN_TYPE_CONVERSATION_CONTACTS_GUIDE) != null) {
            m3.deleteRecentUserByType(AppConstants.VALUE.UIN_TYPE_CONVERSATION_CONTACTS_GUIDE);
            MqqHandler handler = this.f243076f.getHandler(Conversation.class);
            if (handler != null) {
                handler.sendEmptyMessage(1009);
            }
        }
    }

    public void P() {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        SharedPreferences sharedPreferences = this.f243076f.getApplication().getSharedPreferences("loginwelcome_" + this.f243076f.getCurrentUin(), 0);
        this.f243078i = sharedPreferences;
        int i16 = sharedPreferences.getInt("first_login", 0);
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "requestIsFirstLogin state=" + i16);
        }
        if (i16 != 1) {
            this.f243077h.F2(true);
            SharedPreferences.Editor edit = this.f243078i.edit();
            edit.putBoolean("first_device", false);
            edit.putInt("bubble_tips_time", 0);
            edit.putInt("first_login", 1);
            edit.commit();
            return;
        }
        v();
        long j3 = this.f243078i.getLong("sp_key_contactsguide_last_req_time", 0L);
        n nVar = this.S;
        if (nVar != null) {
            i3 = nVar.f243104c;
        } else {
            i3 = 360;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - j3) > i3 * 60 * 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = this.f243078i.getBoolean("request_state", true);
        if (z16 && z17) {
            this.f243077h.F2(false);
        } else {
            Y();
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "requestIsFirstLogin, doReq=" + z16 + ",curTime=" + currentTimeMillis + ",lastReqTime=" + j3 + ",reqInternal=" + i3);
        }
    }

    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        MessengerService messengerService = this.f243079m.get();
        if (messengerService != null) {
            messengerService.J(this.C);
            this.C = null;
        } else if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "respToWeb no service");
        }
    }

    @Override // od2.a
    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress percentage=%s", Integer.valueOf(i3)));
        }
        IPhoneContactService iPhoneContactService = this.F;
        if (iPhoneContactService != null && iPhoneContactService.getUploadPackages() >= 2) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress upload packages >= 2, time cost:%sms", Long.valueOf(SystemClock.uptimeMillis() - this.G)));
            }
            int selfBindState = this.F.getSelfBindState();
            if (selfBindState != 8 && selfBindState != 9) {
                if (selfBindState == 4 || selfBindState == 2) {
                    if (this.H) {
                        H(true);
                    } else {
                        J();
                    }
                }
            } else if (this.H) {
                H(true);
            } else {
                I();
            }
            this.F.removeListener(this);
            this.F = null;
        }
    }

    public void U(m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) mVar);
            return;
        }
        this.V = mVar;
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "setConvListener, listener=" + mVar);
        }
        if (this.V != null) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoginWelcomeManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        LoginWelcomeManager.this.X();
                    }
                }
            }, null, true);
        }
    }

    @Override // od2.a
    public void Ug(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, String.format("onBindStateChanged bindState=%s", Integer.valueOf(i3)));
        }
        if (i3 != 8 && i3 != 4) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, String.format("onBindStateChanged upload end, time cost:%sms", Long.valueOf(SystemClock.uptimeMillis() - this.G)));
            }
            if (this.F != null) {
                if (i3 == 9) {
                    if (this.H) {
                        H(true);
                    } else {
                        I();
                    }
                } else if (i3 == 2) {
                    if (this.H) {
                        H(true);
                    } else {
                        J();
                    }
                } else if (this.H) {
                    H(false);
                } else {
                    E(null);
                }
                this.F.removeListener(this);
                this.F = null;
            }
        }
    }

    public void V(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
            return;
        }
        String str = this.K + String.format(Locale.getDefault(), "&appid=%d", Integer.valueOf(AppSetting.f()));
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, String.format("startNewerGuideWebPage url=%s", str));
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("hide_title_left_arrow", true);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "tryToShowCommonGuide");
        }
        if (!l()) {
            return;
        }
        this.X = true;
        m mVar = this.V;
        if (mVar != null) {
            mVar.a(this.Y);
        }
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer");
        }
        if (!k()) {
            return;
        }
        this.W = true;
        URLDrawable uRLDrawable = this.U;
        if (uRLDrawable == null) {
            n v3 = v();
            if (v3 != null && !TextUtils.isEmpty(v3.f243102a)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mUseAutoScaleParams = false;
                URLDrawable drawable = URLDrawable.getDrawable(v3.f243102a, obtain);
                this.U = drawable;
                drawable.setURLDrawableListener(new a());
                int status = this.U.getStatus();
                if (status == 1) {
                    m mVar = this.V;
                    if (mVar != null) {
                        mVar.b(this.U);
                    }
                    L();
                } else {
                    this.U.downloadImediatly(true);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer drawable need init, drawableStatus" + status);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer, url is empty");
                return;
            }
            return;
        }
        int status2 = uRLDrawable.getStatus();
        if (status2 != 2 && status2 != 3) {
            if (status2 == 1) {
                m mVar2 = this.V;
                if (mVar2 != null) {
                    mVar2.b(this.U);
                }
                L();
            }
        } else {
            this.U.restartDownload();
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer restartDownload, drawableStatus" + status2);
        }
    }

    public void Y() {
        l lVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "tryShowCGRU");
        }
        if (!m()) {
            M();
            return;
        }
        v();
        RecentUserProxy m3 = this.f243076f.getProxyManager().m();
        String str = AppConstants.CONVERSATION_CONTACTS_GUIDE_UIN;
        RecentUser findRecentUser = m3.findRecentUser(str, AppConstants.VALUE.UIN_TYPE_CONVERSATION_CONTACTS_GUIDE);
        if (findRecentUser == null) {
            findRecentUser = new RecentUser(str, AppConstants.VALUE.UIN_TYPE_CONVERSATION_CONTACTS_GUIDE);
        }
        Object obj = findRecentUser.extraInfo;
        if (obj != null && (obj instanceof l)) {
            lVar = (l) obj;
        } else {
            lVar = new l();
        }
        findRecentUser.extraInfo = lVar;
        URLDrawable uRLDrawable = lVar.f243101b;
        if (uRLDrawable == null) {
            n nVar = this.S;
            if (nVar != null && !TextUtils.isEmpty(nVar.f243103b)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                int b16 = com.tencent.biz.qqstory.takevideo.a.b(BaseApplicationImpl.getApplication().getResources());
                obtain.mRequestWidth = b16;
                obtain.mRequestHeight = (int) ((b16 * 0.5d) + 0.5d);
                obtain.mUseAutoScaleParams = false;
                URLDrawable drawable = URLDrawable.getDrawable(this.S.f243103b, obtain);
                drawable.setURLDrawableListener(new i(lVar, findRecentUser));
                int status = drawable.getStatus();
                if (status == 1) {
                    lVar.f243100a = true;
                    lVar.f243101b = drawable;
                    drawable.setURLDrawableListener(null);
                    K(findRecentUser);
                } else {
                    drawable.downloadImediatly(true);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable need init, drawableStatus" + status);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "tryShowCGRU, url is empty");
                return;
            }
            return;
        }
        int status2 = uRLDrawable.getStatus();
        if (status2 != 2 && status2 != 3) {
            if (status2 == 1) {
                lVar.f243100a = true;
                lVar.f243101b = uRLDrawable;
                uRLDrawable.setURLDrawableListener(null);
                K(findRecentUser);
            }
        } else {
            uRLDrawable.restartDownload();
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable is not null, drawableStatus" + status2);
        }
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (x(this.f243076f)) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "allowCGPopWin\uff0cresult=false, hasPopWindow");
            }
            return false;
        }
        k q16 = q();
        boolean z16 = q16.f243095a;
        String str = q16.f243097c;
        if (z16 && !TextUtils.isEmpty(str)) {
            v();
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "allowCGPopWin\uff0cresult=true, showWelcomepage");
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "allowCGPopWin\uff0cresult=false");
        }
        return false;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        if (p().f243093a == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "NotCommonGuideWeb, showType is 0");
                return false;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "allowCommonGuideWeb\uff0cresult=true");
            return true;
        }
        return true;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        if (!q().f243096b) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, needShow is false");
            }
            return false;
        }
        if (PermissionChecker.h().g()) {
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, has ReadContactPer");
            }
            return false;
        }
        RecentUserProxy m3 = this.f243076f.getProxyManager().m();
        RecentUser findRecentUser = m3.findRecentUser(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, AppConstants.VALUE.UIN_TYPE_CONVERSATION_MAY_KNOW_FRIEND);
        RecentUser findRecentUser2 = m3.findRecentUser("sp_uin_for_title", AppConstants.VALUE.UIN_TYPE_CONVERSATION_MAY_KNOW_FRIEND_VERTICAL_ITEM);
        if (findRecentUser == null && findRecentUser2 == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "allowShowCGRU\uff0c mayKnowFriend has show");
        }
        return false;
    }

    public void n(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        String string = bundle.getString("uin");
        IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
        iPublicAccountObserver.setOnCallback(new d(bundle));
        IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
        QQAppInterface qQAppInterface = this.f243076f;
        iPublicAccountUtil.followUin(qQAppInterface, qQAppInterface.getApp(), string, iPublicAccountObserver, true, 15);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f243076f;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this);
            this.f243076f.unRegistObserver(this.R);
        }
        Z = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6  */
    @Override // com.tencent.mobileqq.app.BusinessObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUpdate(int i3, boolean z16, Object obj) {
        boolean z17;
        Object obj2;
        int i16;
        Object obj3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 == 558) {
            if (QLog.isColorLevel()) {
                QLog.i("LoginWelcomeManager", 2, String.format("TYPE_GET_REQUEST_GUIDE_FIRST [%s, %s]", Boolean.valueOf(z16), obj));
            }
            if (z16 && obj != null && (obj instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length >= 4) {
                    Object obj4 = objArr[0];
                    if (obj4 instanceof String) {
                        this.f243074d = (String) obj4;
                    }
                    Object obj5 = objArr[1];
                    if (obj5 instanceof oidb_0x59f$BindContactInfo) {
                        oidb_0x59f$BindContactInfo oidb_0x59f_bindcontactinfo = (oidb_0x59f$BindContactInfo) obj5;
                        if (oidb_0x59f_bindcontactinfo.str_mobile.has() && !TextUtils.isEmpty(oidb_0x59f_bindcontactinfo.str_mobile.get())) {
                            ReportController.o(this.f243076f, "dc00898", "", "", "0X8006E3A", "0X8006E3A", 0, 0, "", "", "", "");
                            z17 = true;
                            obj2 = objArr[2];
                            if (!(obj2 instanceof Integer)) {
                                i16 = ((Integer) obj2).intValue();
                            } else {
                                i16 = 0;
                            }
                            obj3 = objArr[3];
                            if (!(obj3 instanceof String)) {
                                str = (String) obj3;
                            } else {
                                str = null;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = "https://ti.qq.com/newguide/index.html?_wv=16777217";
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("LoginWelcomeManager", 2, String.format("onUpdate bind=%s grayFlag=%s guideUrl=%s", Boolean.valueOf(z17), Integer.valueOf(i16), str));
                            }
                            SharedPreferences.Editor edit = this.f243078i.edit();
                            edit.putBoolean("first_device", true);
                            edit.commit();
                            return;
                        }
                    }
                    z17 = false;
                    obj2 = objArr[2];
                    if (!(obj2 instanceof Integer)) {
                    }
                    obj3 = objArr[3];
                    if (!(obj3 instanceof String)) {
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    SharedPreferences.Editor edit2 = this.f243078i.edit();
                    edit2.putBoolean("first_device", true);
                    edit2.commit();
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 559) {
            D(z16, obj);
            C(z16, obj);
            F(z16, obj);
            this.f243078i.edit().putLong("sp_key_contactsguide_last_req_time", System.currentTimeMillis()).commit();
        }
    }

    public j p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (j) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        if (this.Y == null) {
            j jVar = new j();
            this.Y = jVar;
            jVar.f243093a = 0;
        }
        return this.Y;
    }

    public k q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (k) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (this.T == null) {
            this.T = new k();
            if (this.f243078i == null) {
                this.f243078i = this.f243076f.getApplication().getSharedPreferences("loginwelcome_" + this.f243076f.getCurrentUin(), 0);
            }
            this.T.f243096b = this.f243078i.getBoolean("sp_key_show_convguide_entrance", false);
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "getContactsGuideInfo, \n" + this.T);
            }
        }
        return this.T;
    }

    public void r(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
        } else {
            String string = bundle.getString("uin");
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopInfoForJoinTroop(string, "LoginWelcomeManager", null, false, new c(string));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        try {
            int i3 = this.L + 1;
            this.L = i3;
            if (i3 > 10) {
                QLog.d("LoginWelcomeManager", 1, "handleNewerGuide retry max");
                return;
            }
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, String.format("handleNewerGuide real start guide, mBind=%s", Boolean.valueOf(this.J)));
            }
            this.F = (IPhoneContactService) this.f243076f.getRuntimeService(IPhoneContactService.class, "");
            if (PermissionChecker.h().f()) {
                str = "0X8006E38";
            } else {
                str = "0X8006E39";
            }
            String str2 = str;
            ReportController.o(this.f243076f, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            V(baseActivity);
        } catch (Exception e16) {
            QLog.d("LoginWelcomeManager", 2, "handleNewerGuide fail.", e16);
        }
    }

    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.G = SystemClock.uptimeMillis();
        this.H = z16;
        if (this.F == null) {
            this.F = (IPhoneContactService) this.f243076f.getRuntimeService(IPhoneContactService.class);
        }
        boolean f16 = PermissionChecker.h().f();
        QLog.d("LoginWelcomeManager", 1, String.format("getRecommendedList uploadContactsOnly=%s hasPermission=%s", Boolean.valueOf(z16), Boolean.valueOf(f16)));
        if (f16) {
            this.F.addListener(this);
            if (this.F.isBindedIgnoreUpload()) {
                if (this.F.getSelfBindState() == 9) {
                    if (this.H) {
                        H(true);
                        return;
                    } else {
                        I();
                        return;
                    }
                }
                this.F.uploadPhoneContact();
                return;
            }
            this.F.uploadPhoneContactNotBind();
            return;
        }
        if (this.H) {
            H(false);
        } else {
            E(null);
        }
    }

    public void t(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) bundle);
            return;
        }
        try {
            long j3 = bundle.getLong("uin");
            int i3 = bundle.getInt("startIndex");
            int i16 = bundle.getInt(WidgetCacheConstellationData.NUM);
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, String.format("getRecommendedListNew uin=%s startIndex=%s num=%s", Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16)));
            }
            this.f243076f.addObserver(this.Q);
            ContactBindHandler contactBindHandler = (ContactBindHandler) this.f243076f.getBusinessHandler(BusinessHandlerFactory.CONTACT_BIND_HANDLER);
            if (contactBindHandler != null) {
                contactBindHandler.D2(j3, i3, i16);
            }
        } catch (Throwable th5) {
            QLog.e("LoginWelcomeManager", 1, "getRecommendedListNew fail.", th5);
        }
    }

    public void u(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        this.f243076f.addObserver(this.E);
        NearbyProfileUtil.a((l92.a) this.f243076f.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER), this.f243076f, bundle.getLong("tinyId"), "", 100, null, 0L, false, 0L, false, 0L, 0);
    }

    public n v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (n) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        if (this.S == null) {
            this.S = (n) am.s().x(u.CTRL_INDEX);
            if (QLog.isColorLevel()) {
                QLog.d("LoginWelcomeManager", 2, "getWelcomeIntervalConfig, \n" + this.S);
            }
        }
        return this.S;
    }

    public void w(MessengerService messengerService, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messengerService, (Object) bundle);
            return;
        }
        WeakReference<MessengerService> weakReference = this.f243079m;
        if (weakReference == null || weakReference.get() != messengerService) {
            this.f243079m = new WeakReference<>(messengerService);
        }
        Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
        String string = bundle2.getString("key_action");
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "handleWebRequest method=" + string);
        }
        if (!string.equals("uploadContacts") && !string.equals("getRecommendedList")) {
            if (this.C != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("LoginWelcomeManager", 2, "last request has not return.");
                    return;
                }
                return;
            }
            this.C = bundle;
            if (string.equals("followPublicAccount")) {
                n(bundle2);
                return;
            }
            if (string.equals("joinTroop")) {
                r(bundle2);
                return;
            }
            if (string.equals("joinTroopByTap")) {
                z(bundle2);
                return;
            }
            if (string.equals("sayHi")) {
                u(bundle2);
                return;
            } else if (string.equals(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR)) {
                T(bundle2);
                return;
            } else {
                if (string.equals("getRecommendedListNew")) {
                    t(bundle2);
                    return;
                }
                return;
            }
        }
        this.D = bundle;
        s(string.equals("uploadContacts"));
    }

    public void z(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoginWelcomeManager", 2, "joinGroupByTap");
        }
        this.f243076f.addObserver(this.P);
        ((CardHandler) this.f243076f.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).m3(this.f243076f.getCurrentAccountUin(), this.f243076f.getCurrentUin(), 0, 0L, (byte) 1, 0L, 0L, null, "", 0L, 10004, null, (byte) 0);
    }
}
