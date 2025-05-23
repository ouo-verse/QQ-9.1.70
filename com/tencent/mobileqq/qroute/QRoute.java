package com.tencent.mobileqq.qroute;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.QPlugin;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import com.tencent.mobileqq.qroute.exception.QRoutePluginException;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.qroute.route.Router2;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qroute.route.g;
import com.tencent.mobileqq.qroute.route.m;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.qroute.utils.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRoute {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QRoute";
    public static final String TAG_QROUTE_API = "QRouteApi: ";
    public static g logger;
    static QRouteConfig mConfig;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements m<Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f276428a;

        a(o oVar) {
            this.f276428a = oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.m
        public void a(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            o oVar = this.f276428a;
            if (oVar != null) {
                oVar.onSuccess();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements Function2<Navigator, QRouteException, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f276429d;

        b(o oVar) {
            this.f276429d = oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Navigator navigator, QRouteException qRouteException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) navigator, (Object) qRouteException);
            }
            o oVar = this.f276429d;
            if (oVar != null) {
                oVar.onError(1);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements m<Object> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f276430a;

        c(o oVar) {
            this.f276430a = oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            }
        }

        @Override // com.tencent.mobileqq.qroute.route.m
        public void a(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            o oVar = this.f276430a;
            if (oVar != null) {
                oVar.onSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class d implements Function2<Navigator, QRouteException, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f276431d;

        d(o oVar) {
            this.f276431d = oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Navigator navigator, QRouteException qRouteException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) navigator, (Object) qRouteException);
            }
            o oVar = this.f276431d;
            if (oVar != null) {
                oVar.onError(1);
                return null;
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        QRouteConfig create = new QRouteConfigBuilder("").create();
        mConfig = create;
        logger = create.getLogger();
    }

    QRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public static <T extends QRouteApi> T api(Class<T> cls) {
        return (T) apiImpl(cls, false);
    }

    public static <T extends QRouteApi> T apiFromPlugin(Class<T> cls) {
        if (cls.isAnnotationPresent(QPlugin.class)) {
            return (T) apiImpl(cls, true);
        }
        throw new QRoutePluginException(QPlugin.class.getName() + " need add to your api class" + cls.getSimpleName());
    }

    public static <T extends QRouteApi> T apiIPCSync(Class<T> cls) {
        if (TextUtils.isEmpty(mConfig.getProcessName())) {
            return (T) api(cls);
        }
        if (mConfig.isForceCheck()) {
            e.c(cls);
            com.tencent.mobileqq.qroute.remote.e.m(cls);
        }
        String a16 = e.a(cls);
        try {
            Object c16 = com.tencent.mobileqq.qroute.remote.b.c(cls, Class.forName(a16));
            if (c16 instanceof QRouteApi) {
                return (T) c16;
            }
            String str = "getQRemoteProxy null, class=" + cls;
            logger.a(TAG, str);
            throw new IllegalStateException(str);
        } catch (ClassNotFoundException e16) {
            String str2 = "ClassNotFoundException error, class= " + cls.getName() + "target Class= " + a16;
            logger.b(TAG, str2, e16);
            throw new IllegalStateException(str2, e16);
        }
    }

    @NonNull
    private static <T extends QRouteApi> T apiImpl(Class<T> cls, boolean z16) {
        String a16 = e.a(cls);
        if (mConfig.isForceCheck()) {
            e.c(cls);
            processCheck(cls);
            com.tencent.mobileqq.qroute.remote.e.m(cls);
            if (mConfig.isInStartStep()) {
                logger.a(TAG, "visit " + a16);
            }
        }
        if (e.d(cls)) {
            return (T) com.tencent.mobileqq.qroute.a.b(cls, a16, z16);
        }
        try {
            if (com.tencent.mobileqq.qroute.utils.a.b(a16)) {
                Class<?> cls2 = Class.forName(a16);
                T t16 = (T) cls2.newInstance();
                if (t16 != null) {
                    com.tencent.mobileqq.qroute.utils.a.a(a16);
                    return t16;
                }
                throw new IllegalStateException("getInstance null! @" + cls2.getName());
            }
            com.tencent.mobileqq.qroute.utils.a.c();
            String str = "find cycle init from:" + a16;
            logger.a(TAG, str);
            throw new IllegalStateException(str);
        } catch (Exception e16) {
            com.tencent.mobileqq.qroute.utils.a.c();
            String str2 = "build API fatal:" + cls.getSimpleName() + " " + e16.toString();
            logger.b(TAG, str2, e16);
            throw new IllegalStateException(str2, e16);
        }
    }

    public static Navigator createNavigator(Context context, String str) {
        return Router2.f276492c.d(context, str);
    }

    public static QRouteConfig getConfig() {
        return mConfig;
    }

    public static void init(QRouteConfig qRouteConfig) {
        mConfig = qRouteConfig;
        logger = qRouteConfig.getLogger();
        com.tencent.mobileqq.qroute.remote.b.d(mConfig.getRemoteProxy());
        Router2.f276492c.g(logger, mConfig.getModules());
    }

    public static com.tencent.mobileqq.qroute.module.a plugin(String str) {
        return mConfig.getPluginFactory().a(str);
    }

    private static <T extends QRouteApi> void processCheck(Class<T> cls) {
        if (mConfig.getProcessCheck() != null && !mConfig.getProcessCheck().a(cls, mConfig.getProcessName(), mConfig.isForceCheck())) {
            logger.a(TAG, "checkProcessName failed api:" + cls.getSimpleName());
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append(TAG_QROUTE_API);
            sb5.append(cls.getSimpleName());
            sb5.append(" can not run on this process: ");
            sb5.append(mConfig.getProcessName());
            sb5.append("\uff0c\u8bf7\u8054\u7cfbAPI\u5f00\u53d1\u8005\u6c9f\u901a\u5904\u7406\u3002\n");
            throw new IllegalStateException(sb5.toString());
        }
    }

    public static <T> void registerRouter(String str, Class<T> cls) {
        Router2.f276492c.k(str, cls);
    }

    public static void startStepBegin() {
        if (!mConfig.isForceCheck()) {
            return;
        }
        mConfig.startStepBegin();
    }

    public static void startStepEnd() {
        if (!mConfig.isForceCheck()) {
            return;
        }
        mConfig.startStepEnd();
    }

    public static void startUri(Context context, String str) {
        Router2.f276492c.d(context, str).request();
    }

    public static Navigator createNavigator(Context context, Uri uri) {
        return Router2.f276492c.c(context, uri);
    }

    public static void startUri(Context context, String str, o oVar) {
        Router2.f276492c.d(context, str).subscribeFailed(new b(oVar)).subscribeSuccess(new a(oVar)).request();
    }

    public static void startUri(URIRequest uRIRequest, o oVar) {
        Navigator d16 = Router2.f276492c.d(uRIRequest.getContext(), uRIRequest.getURI().getPath());
        if (uRIRequest instanceof ActivityURIRequest) {
            ActivityURIRequest activityURIRequest = (ActivityURIRequest) uRIRequest;
            if (activityURIRequest.requestCode() != null && (uRIRequest.getContext() instanceof Activity)) {
                d16.withRequestCode((Activity) uRIRequest.getContext(), activityURIRequest.requestCode().intValue());
            }
            int[] overridePendingTransition = activityURIRequest.overridePendingTransition();
            if (overridePendingTransition != null && (uRIRequest.getContext() instanceof Activity)) {
                d16.withTransition((Activity) uRIRequest.getContext(), overridePendingTransition[0], overridePendingTransition[1]);
            }
            if (!TextUtils.isEmpty(activityURIRequest.intentAction())) {
                d16.withAction(activityURIRequest.intentAction());
            }
            if (activityURIRequest.data() != null) {
                d16.withData(activityURIRequest.data());
            }
            if (!TextUtils.isEmpty(activityURIRequest.type())) {
                d16.withType(activityURIRequest.type());
            }
            if (activityURIRequest.extra() != null) {
                d16.withAll(activityURIRequest.extra());
            }
            if (activityURIRequest.options() != null && !activityURIRequest.options().isEmpty()) {
                d16.withOptions(activityURIRequest.options());
            }
            d16.withFlags(activityURIRequest.flags());
        }
        d16.subscribeFailed(new d(oVar)).subscribeSuccess(new c(oVar)).request();
    }

    public static void startUri(URIRequest uRIRequest) {
        startUri(uRIRequest, (o) null);
    }
}
