package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.api.module.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C7412a extends y {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n.c f199042b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C7412a(String str, n.c cVar) {
            super(str);
            this.f199042b = cVar;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            String str = null;
            if (z16) {
                str = bundle.getString("pskey", null);
            }
            n.c cVar = this.f199042b;
            if (cVar != null) {
                cVar.a(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class aa implements k91.b {
        @Override // k91.b
        public Bundle getArguments() {
            return new Bundle();
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetTinyId";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class ab implements k91.b {
        @Override // k91.b
        public Bundle getArguments() {
            return new Bundle();
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetUin";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class ac implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        private final String f199043a;

        public ac(String str) {
            this.f199043a = str;
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString("uin", this.f199043a);
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetUserInformation";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class ad implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        private final String f199044a;

        public ad(String str) {
            this.f199044a = str;
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString("url", this.f199044a);
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.LaunchMiniappHandler";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class ae implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        private final long f199045a;

        /* renamed from: b, reason: collision with root package name */
        private final long f199046b;

        public ae(long j3, long j16) {
            this.f199045a = j3;
            this.f199046b = j16;
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putLong("srcAppID", this.f199045a);
            bundle.putLong("dstAppID", this.f199046b);
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.Login";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    static class af implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        private String f199047a;

        /* renamed from: b, reason: collision with root package name */
        private String f199048b = "";

        af(String str) {
            this.f199047a = str;
        }

        public String a() {
            return this.f199048b;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.e("PsKeySyncCallback", 1, "fail to get pskey, domain = " + this.f199047a);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            if (map.containsKey(this.f199047a)) {
                this.f199048b = map.get(this.f199047a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends ad {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f199049b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, ArrayList arrayList) {
            super(str);
            this.f199049b = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            this.f199049b.add(Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends ab {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f199050a;

        c(ArrayList arrayList) {
            this.f199050a = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            if (z16 && bundle != null) {
                this.f199050a.add(bundle.getString("Uin", ""));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d extends aa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f199051a;

        d(ArrayList arrayList) {
            this.f199051a = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            if (z16 && bundle != null) {
                this.f199051a.add(bundle.getString("TinyId", ""));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class e extends w {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f199052c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, long j3, ArrayList arrayList) {
            super(str, j3);
            this.f199052c = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            if (z16 && bundle != null) {
                this.f199052c.add(bundle.getString("Nickname", ""));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class f extends z {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f199053a;

        f(ArrayList arrayList) {
            this.f199053a = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            if (z16 && bundle != null) {
                this.f199053a.add(bundle.getString("SKey", ""));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class g extends x {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f199054b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, ArrayList arrayList) {
            super(str);
            this.f199054b = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            if (z16 && bundle != null) {
                this.f199054b.add(bundle.getString("PSKey", ""));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class h extends ae {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ u.c f199055c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f199056d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j3, long j16, u.c cVar, long j17) {
            super(j3, j16);
            this.f199055c = cVar;
            this.f199056d = j17;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            String str;
            String str2;
            String str3;
            if (z16) {
                String string = bundle.getString("userAccount", null);
                str2 = bundle.getString("userAccount", null);
                str3 = bundle.getString("openToken", null);
                str = string;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            this.f199055c.a(str, this.f199056d, str2, str3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class i extends ac {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f199057b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, ArrayList arrayList) {
            super(str);
            this.f199057b = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            if (z16) {
                String string = bundle.getString(ITVKPlayerEventListener.KEY_USER_INFO, null);
                if (!TextUtils.isEmpty(string)) {
                    this.f199057b.add(string);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class j extends v {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f199058a;

        j(ArrayList arrayList) {
            this.f199058a = arrayList;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            if (z16) {
                this.f199058a.add(Integer.valueOf(bundle.getInt("mode", -1)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class k implements k91.e {
        private int c() {
            if (com.tencent.mobileqq.qqaudio.audioplayer.c.f(BaseApplication.getContext())) {
                return 1;
            }
            if (com.tencent.mobileqq.qqaudio.audioplayer.c.c(BaseApplication.getContext())) {
                return 2;
            }
            QQAppInterface a16 = a.a();
            if (a16 != null) {
                if (com.tencent.mobileqq.qqaudio.audioplayer.c.b(a16)) {
                    return 4;
                }
                return 3;
            }
            return -1;
        }

        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            if (a.a() == null) {
                QLog.e("ArkApp.GetAudioOutputModeHandler", 1, "GetAudioOutputModeHandler.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            int c16 = c();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("mode", c16);
            return EIPCResult.createResult(0, bundle2);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetAudioOutputModeHandler";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class l implements k91.e {
        private String c(QQAppInterface qQAppInterface, String str) {
            AIOContact q16 = ArkAppQQModuleBase.q();
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (q16 != null) {
                str2 = com.tencent.mobileqq.utils.ac.S(qQAppInterface, q16.e(), q16.j(), q16.g(), str.equals(qQAppInterface.getCurrentUin()), str);
            }
            if (str2 == null || TextUtils.equals(str2, str)) {
                String j3 = com.tencent.mobileqq.utils.ac.j(qQAppInterface, str);
                if (TextUtils.isEmpty(j3)) {
                    return com.tencent.mobileqq.utils.ac.Q(qQAppInterface, str, 0);
                }
                return j3;
            }
            return str2;
        }

        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                QLog.e("ArkApp.GetNicknameByViewHandler", 1, "Handler_GetNickName.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            String c16 = c(a16, bundle.getString("Uin", a16.getCurrentAccountUin()));
            Bundle bundle2 = new Bundle();
            if (TextUtils.isEmpty(c16)) {
                QLog.e("ArkApp.GetNicknameByViewHandler", 1, "Handler_GetNickName.onCall, nickname is empty");
                bundle2.putString("Nickname", "");
            } else {
                bundle2.putString("Nickname", c16);
            }
            return EIPCResult.createResult(0, bundle2);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetNicknameByView";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class m implements k91.e {
        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            TroopMemberInfo troopMemberInfoSync;
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                QLog.e("ArkApp.GetNicknameHandler", 1, "Handler_GetNickName.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            String string = bundle.getString("Uin", a16.getCurrentAccountUin());
            String str = null;
            if (!TextUtils.isEmpty(ArkAppContainer.f179261i) && (troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(ArkAppContainer.f179261i, string, null, "ArkApp.GetNicknameHandler")) != null) {
                str = troopMemberInfoSync.nickInfo.getShowName();
            }
            if (str == null || TextUtils.equals(str, string)) {
                str = com.tencent.mobileqq.utils.ac.j(a16, string);
                if (TextUtils.isEmpty(str)) {
                    str = com.tencent.mobileqq.utils.ac.Q(a16, string, 0);
                }
            }
            Bundle bundle2 = new Bundle();
            if (TextUtils.isEmpty(str)) {
                QLog.i("ArkApp.GetNicknameHandler", 1, "GetNicknameHandler.onCall, nickname is empty");
                bundle2.putString("Nickname", "");
            } else {
                bundle2.putString("Nickname", str);
            }
            return EIPCResult.createResult(0, bundle2);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetNickname";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class n implements k91.a {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ark.api.module.a$n$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C7413a implements c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k91.c f199059a;

            C7413a(k91.c cVar) {
                this.f199059a = cVar;
            }

            @Override // com.tencent.mobileqq.ark.api.module.a.n.c
            public void a(String str) {
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("pskey", str);
                }
                this.f199059a.a(EIPCResult.createResult(0, bundle));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes11.dex */
        public class b implements sd2.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f199061a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f199062b;

            b(String str, c cVar) {
                this.f199061a = str;
                this.f199062b = cVar;
            }

            @Override // sd2.a
            public void onFail(@NonNull String str) {
                QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "--- pskey async failed---  " + str + ", domain: " + this.f199061a);
                c cVar = this.f199062b;
                if (cVar != null) {
                    cVar.a(null);
                }
            }

            @Override // sd2.a
            public void onSuccess(@NonNull Map<String, String> map) {
                if (QLog.isColorLevel()) {
                    QLog.i("ArkApp.GetPSKeyAsyncHandler", 2, "--- pskey async done---  ");
                }
                if (map.containsKey(this.f199061a)) {
                    String str = map.get(this.f199061a);
                    c cVar = this.f199062b;
                    if (cVar != null) {
                        cVar.a(str);
                        return;
                    }
                    return;
                }
                QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "pskey async can't find in map. domain: " + this.f199061a);
                c cVar2 = this.f199062b;
                if (cVar2 != null) {
                    cVar2.a(null);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes11.dex */
        public interface c {
            void a(String str);
        }

        private void c(AppRuntime appRuntime, String str, c cVar) {
            if (appRuntime == null) {
                return;
            }
            ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{str}, new b(str, cVar));
        }

        @Override // k91.a
        public void a(Bundle bundle, k91.c cVar) {
            if (MobileQQ.sProcessId != 1) {
                QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, app interface is null");
                cVar.a(EIPCResult.createResult(-102, new Bundle()));
                return;
            }
            String string = bundle.getString("domain", "");
            if (TextUtils.isEmpty(string)) {
                QLog.i("ArkApp.GetPSKeyAsyncHandler", 1, "onCall, domain is empty");
                cVar.a(EIPCResult.createResult(0, new Bundle()));
            } else {
                c(MobileQQ.sMobileQQ.waitAppRuntime(null), string, new C7413a(cVar));
            }
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetPSKeyAsync";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class o implements k91.e {
        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                QLog.e("ArkApp.GetPSKeyHandler", 1, "GetPSKeyHandler.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            String string = bundle.getString("Domain", "");
            af afVar = new af(string);
            ((IPskeyManager) a16.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{string}, afVar);
            String a17 = afVar.a();
            Bundle bundle2 = new Bundle();
            if (TextUtils.isEmpty(a17)) {
                QLog.e("ArkApp.GetPSKeyHandler", 1, "GetPSKeyHandler.onCall, pskey is empty, domain=" + string);
                bundle2.putString("PSKey", "");
            } else {
                bundle2.putString("PSKey", a17);
            }
            return EIPCResult.createResult(0, bundle2);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetPSKey";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class p implements k91.e {
        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            if (a.a() == null) {
                QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            Bundle bundle2 = new Bundle();
            if (TextUtils.isEmpty("")) {
                QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, skey is empty");
                bundle2.putString("SKey", "");
            } else {
                bundle2.putString("SKey", "");
            }
            return EIPCResult.createResult(0, bundle2);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetSKey";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class q implements k91.e {
        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                QLog.e("ArkApp.GetTinyIdHandler", 1, "Handler_GetTinyId.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("TinyId", ((IGPSService) a16.getRuntimeService(IGPSService.class)).getSelfTinyId());
            return EIPCResult.createResult(0, bundle2);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetTinyId";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class r implements k91.e {
        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                QLog.e("ArkApp.GetUinHandler", 1, "Handler_GetNickName.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("Uin", a16.getCurrentAccountUin());
            return EIPCResult.createResult(0, bundle2);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetUin";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class s implements k91.e {
        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                QLog.e("ArkApp.GetUserInformationHandler", 1, "Handler_GetNickName.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            String string = bundle.getString("uin", a16.getCurrentAccountUin());
            Bundle bundle2 = new Bundle();
            String c16 = c(string);
            if (!TextUtils.isEmpty(c16)) {
                bundle2.putString(ITVKPlayerEventListener.KEY_USER_INFO, c16);
            }
            return EIPCResult.createResult(0, bundle2);
        }

        public String c(String str) {
            String str2;
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                return null;
            }
            if (str == null) {
                str = a16.getCurrentUin();
            }
            Card r16 = ((FriendsManager) a16.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(str);
            if (r16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation FriendCard is null");
                }
                return null;
            }
            String str3 = r16.strNick;
            short s16 = r16.shGender;
            String str4 = "";
            if (s16 == 0) {
                str2 = BaseActivity.sTopActivity.getString(R.string.c7_);
            } else if (s16 != 1) {
                str2 = "";
            } else {
                str2 = BaseActivity.sTopActivity.getString(R.string.b5e);
            }
            String str5 = r16.strCity;
            String str6 = r16.strProvince;
            String str7 = r16.strCountry;
            Setting qQHeadSettingFromDB = a16.getQQHeadSettingFromDB(str);
            if (qQHeadSettingFromDB != null && !TextUtils.isEmpty(qQHeadSettingFromDB.url)) {
                str4 = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(qQHeadSettingFromDB.url, qQHeadSettingFromDB.bFaceFlags, qQHeadSettingFromDB.bUsrType, 0));
            } else if (QLog.isColorLevel()) {
                QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation QQHeadSetting is empty");
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.GetUserInformationHandler", 2, "GetUserInformation nickname=" + str3 + ", avatarUrl=" + str4 + ", gender=" + str2 + ", city=" + str5 + ", province=" + str6 + ", country=" + str7);
            }
            return String.format(Locale.CHINA, "{\"nickname\":\"%s\",\"avatar\":\"%s\",\"gender\":\"%s\",\"city\":\"%s\",\"province\":\"%s\",\"country\":\"%s\"}", str3, str4, str2, str5, str6, str7);
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.GetUserInformation";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class t implements k91.e {
        private static int c(int i3, int i16) {
            if (i3 == -1) {
                return i16;
            }
            if (i3 <= 2) {
                return 1007;
            }
            return 1008;
        }

        public static boolean d(String str) {
            if (!((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                return false;
            }
            try {
                Integer.parseInt(URLUtil.getArguments(str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1)).get("scene"));
            } catch (Exception e16) {
                QLog.e("ArkApp", 1, "Ark parse miniapp scene failed.", e16);
            }
            com.tencent.mobileqq.ark.api.scheme.b.b();
            Context f16 = com.tencent.mobileqq.ark.module.b.f();
            if (f16 == null) {
                f16 = BaseApplication.getContext();
            }
            QLog.d("ArkApp.LaunchMiniappHandler", 2, " jump to miniApp: " + str);
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("_miniapptype");
            String queryParameter2 = parse.getQueryParameter("qq_aio_chat_type");
            int i3 = -1;
            if (queryParameter2 != null) {
                try {
                    i3 = Integer.parseInt(queryParameter2);
                } catch (NumberFormatException e17) {
                    QLog.e("ArkApp.LaunchMiniappHandler", 1, "parse chatType error: ", e17);
                }
            }
            QLog.d("ArkApp.LaunchMiniappHandler", 1, "jump to miniApp, chatType: ", Integer.valueOf(i3));
            if (TextUtils.equals(queryParameter, "2")) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(f16, parse.getQueryParameter("_mappid"), parse.getQueryParameter("_path"), c(i3, 1043));
                return true;
            }
            return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(f16, str, c(i3, 1043), null);
        }

        @Override // k91.e
        public EIPCResult b(Bundle bundle) {
            if (a.a() == null) {
                QLog.e("ArkApp.LaunchMiniappHandler", 1, "LaunchMiniappHandler.onCall, qq app is null");
                return EIPCResult.createResult(-102, new Bundle());
            }
            if (!d(bundle.getString("url"))) {
                QLog.e("ArkApp.LaunchMiniappHandler", 1, "LaunchMiniappHandler.onCall, launch failed");
                return EIPCResult.createResult(-102, new Bundle());
            }
            return EIPCResult.createResult(0, new Bundle());
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.LaunchMiniappHandler";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class u implements k91.a {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ark.api.module.a$u$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C7414a implements c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k91.c f199064a;

            C7414a(k91.c cVar) {
                this.f199064a = cVar;
            }

            @Override // com.tencent.mobileqq.ark.api.module.a.u.c
            public void a(String str, long j3, String str2, String str3) {
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    bundle.putString("userAccount", str);
                    bundle.putString("openID", str2);
                    bundle.putString("openToken", str3);
                    bundle.putLong("dstAppID", j3);
                }
                this.f199064a.a(EIPCResult.createResult(0, bundle));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes11.dex */
        public class b implements com.tencent.mobileqq.thirdsig.api.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f199066a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f199067b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f199068c;

            b(c cVar, String str, long j3) {
                this.f199066a = cVar;
                this.f199067b = str;
                this.f199068c = j3;
            }

            @Override // com.tencent.mobileqq.thirdsig.api.d
            public void a(@NonNull com.tencent.mobileqq.thirdsig.api.g gVar) {
                String buf_to_string = util.buf_to_string(gVar.b());
                String buf_to_string2 = util.buf_to_string(gVar.a());
                if (!TextUtils.isEmpty(buf_to_string) && !TextUtils.isEmpty(buf_to_string2)) {
                    this.f199066a.a(this.f199067b, this.f199068c, buf_to_string, buf_to_string2);
                } else {
                    this.f199066a.a(null, 0L, null, null);
                }
            }

            @Override // com.tencent.mobileqq.thirdsig.api.d
            public void onFail(int i3, @NonNull String str) {
                this.f199066a.a(null, 0L, null, null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes11.dex */
        public interface c {
            void a(String str, long j3, String str2, String str3);
        }

        private void c(long j3, long j16, c cVar) {
            QQAppInterface a16 = a.a();
            if (a16 == null) {
                cVar.a(null, 0L, null, null);
            } else {
                d(j3, j16, cVar, a16);
            }
        }

        private void d(long j3, long j16, c cVar, QQAppInterface qQAppInterface) {
            IThirdSigService iThirdSigService = (IThirdSigService) qQAppInterface.getRuntimeService(IThirdSigService.class, "all");
            String currentUin = qQAppInterface.getCurrentUin();
            iThirdSigService.getAccessToken(Long.parseLong(currentUin), (int) j16, "", new b(cVar, currentUin, j16));
        }

        @Override // k91.a
        public void a(Bundle bundle, k91.c cVar) {
            if (a.a() == null) {
                QLog.e("ArkApp.LoginHandler", 1, "LoginHandler.onCall, qq app is null");
                cVar.a(EIPCResult.createResult(-102, new Bundle()));
                return;
            }
            long j3 = bundle.getLong("srcAppID", 0L);
            long j16 = bundle.getLong("dstAppID", 0L);
            if (j3 != 0 && j16 != 0) {
                c(j3, j16, new C7414a(cVar));
            } else {
                cVar.a(EIPCResult.createResult(0, new Bundle()));
            }
        }

        @Override // k91.d
        public String getMethod() {
            return "QQ.Login";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class v implements k91.b {
        @Override // k91.b
        public Bundle getArguments() {
            return new Bundle();
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetAudioOutputModeHandler";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class w implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        private final String f199070a;

        /* renamed from: b, reason: collision with root package name */
        private final long f199071b;

        public w(String str, long j3) {
            this.f199070a = str;
            this.f199071b = j3;
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.f199070a)) {
                bundle.putString("Uin", this.f199070a);
            }
            bundle.putLong("ViewHandle", this.f199071b);
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetNickname";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class x implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        private final String f199072a;

        public x(String str) {
            this.f199072a = str;
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.f199072a)) {
                bundle.putString("Domain", this.f199072a);
            }
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetPSKey";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class y implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        private final String f199073a;

        public y(String str) {
            this.f199073a = str;
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString("domain", this.f199073a);
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetPSKeyAsync";
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class z implements k91.b {
        @Override // k91.b
        public Bundle getArguments() {
            return new Bundle();
        }

        @Override // k91.b
        public String getMethod() {
            return "QQ.GetSKey";
        }
    }

    static /* bridge */ /* synthetic */ QQAppInterface a() {
        return b();
    }

    private static QQAppInterface b() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) waitAppRuntime;
    }

    public static int c() {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new j(arrayList));
        return ((Integer) arrayList.get(0)).intValue();
    }

    public static String d(String str, long j3) {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new e(str, j3, arrayList));
        if (arrayList.size() > 0) {
            return (String) arrayList.get(0);
        }
        return "";
    }

    public static String e(String str) {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new g(str, arrayList));
        if (arrayList.size() > 0) {
            return (String) arrayList.get(0);
        }
        return "";
    }

    public static void f(String str, n.c cVar) {
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new C7412a(str, cVar));
    }

    public static String g() {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new f(arrayList));
        if (arrayList.size() > 0) {
            return (String) arrayList.get(0);
        }
        return "";
    }

    public static String h() {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new d(arrayList));
        if (arrayList.size() > 0) {
            return (String) arrayList.get(0);
        }
        return "";
    }

    public static String i() {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new c(arrayList));
        if (arrayList.size() > 0) {
            return (String) arrayList.get(0);
        }
        return "";
    }

    public static String j(String str) {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new i(str, arrayList));
        if (arrayList.size() > 0) {
            return (String) arrayList.get(0);
        }
        return null;
    }

    public static boolean k(String str) {
        ArrayList arrayList = new ArrayList();
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new b(str, arrayList));
        return ((Boolean) arrayList.get(0)).booleanValue();
    }

    public static void l(long j3, long j16, u.c cVar) {
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new h(j3, j16, cVar, j16));
    }
}
