package com.tencent.mobileqq.zplan.proxy;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ipc.ak;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.proxy.w;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.proxy.api.IZPlanShareProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import okio.Utf8;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/w;", "Lcom/tencent/zplan/proxy/api/IZPlanShareProxy;", "", "uin", "Lcom/tencent/zplan/proxy/api/IZPlanShareProxy$ShareData;", "data", "", "a", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class w implements IZPlanShareProxy {

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Object> f335022b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f335023c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static ZootopiaSource f335024d = ZootopiaSource.INSTANCE.i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0006JB\u0010\u0011\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000e2(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0004R3\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R6\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/w$a;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "", tl.h.F, "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "i", "c", "uin", "Lcom/tencent/zplan/proxy/api/IZPlanShareProxy$ShareData;", "data", "customShareExtraParams", "d", "reportExtraInfo", "Ljava/util/HashMap;", "g", "()Ljava/util/HashMap;", "TAG", "Ljava/lang/String;", "shareExtraParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.proxy.w$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b() {
            QLog.i("ZPlanSameStyle", 1, "clearShareExtraParams - " + w.f335022b);
            w.f335022b = null;
        }

        public final void c() {
            w.f335024d = ZootopiaSource.INSTANCE.i();
        }

        public final void d(final String uin, final IZPlanShareProxy.ShareData data, final HashMap<String, Object> customShareExtraParams) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("ZPlanSameStyle", 1, "start share, share data = " + data + ", customShareExtraParams= " + customShareExtraParams);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.proxy.v
                @Override // java.lang.Runnable
                public final void run() {
                    w.Companion.f(uin, data, customShareExtraParams);
                }
            });
            vb4.a.f441348a.a(data.getSameStyleId(), data.getContentType());
        }

        public final HashMap<String, String> g() {
            return w.f335023c;
        }

        public final void h(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            QLog.i("ZPlanSameStyle", 1, "setShareExtraParams - " + map);
            w.f335022b = map;
        }

        public final void i(ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            w.f335024d = source;
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(String str, IZPlanShareProxy.ShareData data, HashMap hashMap) {
            Intrinsics.checkNotNullParameter(data, "$data");
            IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
            Context topActivity = Foreground.getTopActivity();
            if (topActivity == null) {
                topActivity = BaseApplication.context;
            }
            Intrinsics.checkNotNullExpressionValue(topActivity, "Foreground.getTopActivit\u2026seApplicationImpl.context");
            int contentType = data.getContentType();
            String path = data.getPath();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(data.getSameStyleId()));
            hashMap2.put(ZPlanShareLaunchParam.KEY_BIZ_TEMPLATE_TAB, Integer.valueOf(data.getTemplateTab()));
            Unit unit = Unit.INSTANCE;
            HashMap hashMap3 = w.f335022b;
            if (hashMap3 == null) {
                hashMap3 = new HashMap();
            }
            HashMap hashMap4 = hashMap3;
            if (hashMap != null && hashMap.size() > 0) {
                hashMap4.putAll(hashMap);
            }
            iZPlanShareApi.launchForShareMedia(topActivity, new ZPlanShareLaunchParam(0, str, contentType, path, hashMap2, hashMap4, w.f335024d, null, null, null, false, null, Utf8.MASK_2BYTES, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(Companion companion, String str, IZPlanShareProxy.ShareData shareData, HashMap hashMap, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                hashMap = null;
            }
            companion.d(str, shareData, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(IZPlanShareProxy.ShareData data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        ((ak) k74.i.INSTANCE.a(ak.class)).jumpToVideoCutPage(data.getPath(), f335023c);
    }

    @Override // com.tencent.zplan.proxy.api.IZPlanShareProxy
    public void a(String uin, IZPlanShareProxy.ShareData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Companion.e(INSTANCE, uin, data, null, 4, null);
    }

    @Override // com.tencent.zplan.proxy.api.IZPlanShareProxy
    public void b(final IZPlanShareProxy.ShareData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ZPlanSameStyle", 1, "start editVide, share data = " + data);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.proxy.u
            @Override // java.lang.Runnable
            public final void run() {
                w.i(IZPlanShareProxy.ShareData.this);
            }
        });
    }
}
