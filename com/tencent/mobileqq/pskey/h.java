package com.tencent.mobileqq.pskey;

import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.tts.api.impl.TtsPsKeyImpl;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tenpay.sdk.Cgi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/pskey/h;", "", "Lmqq/app/AppRuntime;", "app", "", "", "c", "d", "b", "a", "e", "Ljava/util/List;", "mDomainPskeyWhiteList", "mDomainUskeyWhiteList", "", "J", "mLastCheckPskeyTimeStamp", "mLastCheckUskeyTimeStamp", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<String> f261176f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final List<String> f261177g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> mDomainPskeyWhiteList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> mDomainUskeyWhiteList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mLastCheckPskeyTimeStamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mLastCheckUskeyTimeStamp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/pskey/h$a;", "", "", "CHECK_TOGGLE_DURATION", "J", "", "", "DEFAULT_PSKEY_DOMAIN_WHITE_LIST", "Ljava/util/List;", "DEFAULT_USKEY_DOMAIN_WHITE_LIST", "KEY_DOMAIN_WHITE_LIST", "Ljava/lang/String;", "TAG", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pskey.h$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        List<String> listOf;
        List<String> listOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35640);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{QQLiveCookieConstants.QQ_LIVE_DOMAIN, QQLiveCookieConstants.NOW_DOMAIN, "oa.com", "weiyun.com", "bots.qq.com", "kandian.qq.com", "clt.qq.com", "graph.qq.com", "yundong.qq.com", "books.qq.com", "q.qq.com", "gamecenter.qq.com", "m.tencent.com", "vip.qq.com", "weishi.qq.com", "tim.qq.com", "quan.qq.com", "wa.qq.com", ITeamWorkHandler.DOCS_DOMAIN, "kg.qq.com", "ti.qq.com", "im.qq.com", "mma.qq.com", "mobile.qq.com", "yuanchuang.qq.com", "qqyc.qq.com", "buluo.qq.com", "nbgift.qq.com", "igame.qq.com", "y.qq.com", FlockBaseRequest.QUN_DOMAIN, "qidian.qq.com", "qiye.qq.com", "mail.qq.com", "game.qq.com", "id.qq.com", "kuyoo.com", "qzone.qq.com", "ke.qq.com", "jiankang.qq.com", "huayang.qq.com", "fudao.qq.com", Cgi.TENPAY_DOMAIN, "qcloud.com", "chong.qq.com", "tingting.qq.com", "qianbao.qq.com", "mp.qq.com", "cmshow.qq.com", "accounts.qq.com", "qqweb.qq.com", "yes.qq.com", "tingting.qq.com", "haoma.qq.com", "ivac.qq.com", "openmobile.qq.com", "docx.qq.com", "baike.sogo.com", "hall.qq.com", "qzone.com", "imgcache.qq.com", "wenwen.sogou.com", "baike.sogou.com", "wenwen.sogo.com", "xsj.qq.com", "nearby.qq.com", "show.qq.com", "superqqshow.qq.com", "qqzz.qq.com", "jubao.qq.com", "tu.qq.com", "qvideo.qq.com", "connect.qq.com", TtsPsKeyImpl.TTS_DOMAIN, "pieceup.qq.com", "qqlog.qq.com", "sharechain.qq.com", "inews.qq.com", "jifen.qq.com", "daoju.qq.com", "pd.qq.com", "aq.qq.com"});
        f261176f = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qzone.qq.com", "xsj.qq.com"});
        f261177g = listOf2;
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDomainPskeyWhiteList = f261176f;
            this.mDomainUskeyWhiteList = f261177g;
        }
    }

    private final List<String> c(AppRuntime app) {
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("100934", new byte[0]), Charsets.UTF_8);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int length = jSONObject.names().length();
            for (int i3 = 0; i3 < length; i3++) {
                String obj = jSONObject.names().get(i3).toString();
                if ((jSONObject.getInt(obj) & 1) == 1) {
                    arrayList.add(obj);
                }
            }
            QLog.i("PskeyRequestDomainListManager", 1, "pskeyList is " + arrayList);
        } catch (JSONException unused) {
            QLog.e("PskeyRequestDomainListManager", 1, "parse config error " + str);
        }
        return arrayList;
    }

    private final List<String> d(AppRuntime app) {
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("100934", new byte[0]), Charsets.UTF_8);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int length = jSONObject.names().length();
            for (int i3 = 0; i3 < length; i3++) {
                String obj = jSONObject.names().get(i3).toString();
                if (((jSONObject.getInt(obj) >>> 2) & 1) == 1) {
                    arrayList.add(obj);
                }
            }
            QLog.i("PskeyRequestDomainListManager", 1, "uskeyList is " + arrayList);
        } catch (JSONException unused) {
            QLog.e("PskeyRequestDomainListManager", 1, "parse config error " + str);
        }
        return arrayList;
    }

    @NotNull
    public final List<String> a(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) app);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        if (System.currentTimeMillis() - this.mLastCheckPskeyTimeStamp <= 1800000) {
            return this.mDomainPskeyWhiteList;
        }
        this.mLastCheckPskeyTimeStamp = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(c(app));
        } catch (Exception unused) {
            QLog.e("PskeyRequestDomainListManager", 1, "pskey_component param error!");
        }
        arrayList.addAll(this.mDomainPskeyWhiteList);
        List<String> f16 = i.f261182a.f(arrayList);
        this.mDomainPskeyWhiteList = f16;
        return f16;
    }

    @NotNull
    public final List<String> b(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        i iVar = i.f261182a;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(app));
        arrayList.addAll(e(app));
        List<String> f16 = iVar.f(arrayList);
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = f16.iterator();
        while (it.hasNext()) {
            sb5.append(it.next() + ",");
        }
        QLog.i("PskeyRequestDomainListManager", 2, "getRequestDomainList list = [" + ((Object) sb5) + "]");
        return f16;
    }

    @NotNull
    public final List<String> e(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) app);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        if (System.currentTimeMillis() - this.mLastCheckUskeyTimeStamp <= 1800000) {
            return this.mDomainUskeyWhiteList;
        }
        this.mLastCheckUskeyTimeStamp = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(d(app));
        } catch (Exception unused) {
            QLog.e("PskeyRequestDomainListManager", 1, "uskey_component param error!");
        }
        arrayList.addAll(this.mDomainUskeyWhiteList);
        List<String> f16 = i.f261182a.f(arrayList);
        this.mDomainUskeyWhiteList = f16;
        return f16;
    }
}
