package cz;

import UserGrowth.stPublisherRsp;
import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.pubaccount.weishi.r;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcz/f;", "", "Landroid/content/Context;", "context", "LUserGrowth/stPublisherRsp;", "data", "", "sopName", "", "g", "i", h.F, "l", "miniAppSchema", "d", "h5Url", QZoneDTLoginReporter.SCHEMA, "c", "schemeUrl", "f", "j", AdMetricTag.EVENT_NAME, "position", "", "actionId", "k", "b", "Ljava/lang/String;", "defaultSchema", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f392428a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String defaultSchema = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"cz/f$a", "Lcz/a;", "", NodeProps.ON_CLICK, "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements cz.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f392430a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ stPublisherRsp f392431b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f392432c;

        a(Context context, stPublisherRsp stpublisherrsp, String str) {
            this.f392430a = context;
            this.f392431b = stpublisherrsp;
            this.f392432c = str;
        }

        @Override // cz.a
        public void onClick() {
            f.f392428a.i(this.f392430a, this.f392431b, this.f392432c);
        }
    }

    f() {
    }

    private final void c(Context context, String h5Url, String sopName, String schema) {
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][jumpH5]");
        z.h(context, h5Url);
        k("gzh_click", "publish", 1000004, sopName);
        i00.a.f406985a.a(schema);
    }

    private final void d(Context context, String miniAppSchema, String sopName) {
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][jumpMiniApp] miniAppSchema:" + miniAppSchema);
        z.o(context, miniAppSchema, new MiniAppLaunchListener() { // from class: cz.e
            @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
            public final void onLaunchResult(boolean z16, Bundle bundle) {
                f.e(z16, bundle);
            }
        });
        k("gzh_click", "publish", 1000007, sopName);
    }

    private final void f(Context context, String schemeUrl, String sopName) {
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][jumpWeiShi]");
        ao.f(context, "biz_src_jc_gzh_weishi", schemeUrl, 1, iz.a.g().p(), 0);
        k("gzh_click", "publish_popup", 1000003, sopName);
    }

    private final void g(Context context, stPublisherRsp data, String sopName) {
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][performCheckDialogShow]");
        Integer valueOf = data != null ? Integer.valueOf(data.showGuide) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            l(context, data, sopName);
        } else {
            i(context, data, sopName);
        }
    }

    private final void h(Context context, stPublisherRsp data, String sopName) {
        String str;
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][performCheckWeiShiInstall]");
        if (l.c(context)) {
            str = data != null ? data.weishiSchema : null;
            if (str != null) {
                f(context, str, sopName);
                return;
            }
            return;
        }
        if (com.tencent.biz.pubaccount.weishi.util.a.c(context)) {
            k("gzh_click", "publish", 1000009, sopName);
            com.tencent.biz.pubaccount.weishi.util.a.b(context);
            i00.a.f406985a.a(data != null ? data.weishiSchema : null);
        } else {
            str = data != null ? data.h5Url : null;
            if (str != null) {
                c(context, str, sopName, data.weishiSchema);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Context context, stPublisherRsp data, String sopName) {
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][performJump]");
        if ((data != null ? data.weishiSchema : null) == null) {
            String str = data != null ? data.h5Url : null;
            if (str != null) {
                c(context, str, sopName, data.weishiSchema);
                return;
            }
            return;
        }
        h(context, data, sopName);
    }

    private final void l(Context context, stPublisherRsp data, String sopName) {
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][showPublisherDialog]");
        r rVar = new r(context);
        rVar.S(data);
        rVar.W(sopName);
        rVar.U(new a(context, data, sopName));
        rVar.show();
        k("gzh_click", "publish", 1000006, sopName);
    }

    public final void j(Context context, stPublisherRsp data, String sopName) {
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][performPublisher] data:" + data);
        if (context == null) {
            return;
        }
        if (data == null) {
            d(context, defaultSchema, sopName);
        } else {
            if (data.noInstallAction == 2) {
                String str = data.miniAppSchema;
                Intrinsics.checkNotNullExpressionValue(str, "data.miniAppSchema");
                d(context, str, sopName);
                return;
            }
            g(context, data, sopName);
        }
    }

    public final void k(String eventName, String position, int actionId, String sopName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        WSPublicAccReport.getInstance().reportPublisher(eventName, sopName, position, actionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z16, Bundle bundle) {
        String str;
        if (z16) {
            str = "success";
        } else {
            str = "fail";
        }
        x.f("WSPublisherHelper", "launch mini program " + str + ", bundle: " + bundle);
    }
}
