package oo;

import android.content.Context;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.configx.n;
import com.qzone.reborn.watermark.request.QZoneLayerGetWatermarkDownloadReq;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import oo.b;
import qzone.Watermark$DownloadUrlInfo;
import qzone.Watermark$GetDownloadUrlRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010#\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002&\u001cB\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J0\u0010\u0011\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J<\u0010\u0014\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010\u0015\u001a\u00020\u0010H\u0007J\u001a\u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0007J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0007R\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Loo/b;", "", "", "j", "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "", "source", "", "", "urlList", "Loo/b$b;", "callback", "", "f", "Loo/b$a;", "errorCallback", "g", "c", "waterMarkSwitchType", "waterMarkSwitchStatus", DomainData.DOMAIN_NAME, "type", h.F, "i", "b", "Ljava/lang/String;", "TAG", "", "Ljava/util/Set;", "e", "()Ljava/util/Set;", "syncWechatPublishIdSet", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f423230a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "QZoneWatermarkDownloadAndShareManager";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> syncWechatPublishIdSet = new LinkedHashSet();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Loo/b$a;", "", "", "retCode", "", "errorMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface a {
        void a(long retCode, String errorMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&\u00a8\u0006\b"}, d2 = {"Loo/b$b;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "urlList", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oo.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10931b {
        void a(ArrayList<String> urlList);
    }

    b() {
    }

    @JvmStatic
    public static final void c() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: oo.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        long uin = LoginData.getInstance().getUin();
        boolean z16 = false;
        if (LocalMultiProcConfig.containKey(LocalMultiProcConfig.PREFS_NAME_MULTI_QZ_SETTING, "WaterMark_" + uin)) {
            z16 = LocalMultiProcConfig.getBool(LocalMultiProcConfig.PREFS_NAME_MULTI_QZ_SETTING, "WaterMark_" + uin, false);
        } else {
            if (LocalMultiProcConfig.containKey(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, "WaterMark_" + uin)) {
                z16 = LocalMultiProcConfig.getBool(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, "WaterMark_" + uin, false);
            }
        }
        if (z16) {
            QLog.d(TAG, 1, "checkWaterMarkSwitchV0 needWaterMark:true,should setSwitchValue to background");
            g.f53821a.l().p("upload_watermark_switch_v0", "1");
            LocalMultiProcConfig.removeKey(LocalMultiProcConfig.PREFS_NAME_MULTI_QZ_SETTING, "WaterMark_" + uin);
            LocalMultiProcConfig.removeKey(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, "WaterMark_" + uin);
        }
    }

    @JvmStatic
    public static final void f(Context context, int source, List<String> urlList, InterfaceC10931b callback) {
        Intrinsics.checkNotNullParameter(urlList, "urlList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        g(context, source, urlList, callback, null);
    }

    @JvmStatic
    public static final void g(Context context, int source, List<String> urlList, InterfaceC10931b callback, a errorCallback) {
        Intrinsics.checkNotNullParameter(urlList, "urlList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        VSNetworkHelper.getInstance().sendRequest(context, new QZoneLayerGetWatermarkDownloadReq(source, urlList), new c(source, errorCallback, callback, context));
    }

    @JvmStatic
    public static final String h(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return "({type:\"" + type + "\",value:\"" + g.f53821a.l().b(type, 0) + "\"})";
    }

    @JvmStatic
    public static final boolean i() {
        boolean z16 = g.f53821a.l().b("upload_watermark_switch_v0", 0) != 0;
        QLog.d(TAG, 4, "isUploadWatermarkSwitchV0Open:" + z16);
        return z16;
    }

    @JvmStatic
    public static final boolean j() {
        g gVar = g.f53821a;
        return gVar.k().p() && gVar.b().N1();
    }

    @JvmStatic
    public static final boolean k() {
        g gVar = g.f53821a;
        return gVar.k().p() && gVar.b().O1();
    }

    @JvmStatic
    public static final boolean l() {
        g gVar = g.f53821a;
        return gVar.k().p() && gVar.b().P1();
    }

    @JvmStatic
    public static final boolean m() {
        g gVar = g.f53821a;
        return gVar.k().p() && gVar.b().Q1();
    }

    public final Set<String> e() {
        return syncWechatPublishIdSet;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"oo/b$c", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/Watermark$GetDownloadUrlRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "baseRequest", "", "isSuccess", "", "retCode", "", "errorMsg", "rsp", "", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements VSDispatchObserver.OnVSRspCallBack<Watermark$GetDownloadUrlRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f423233a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f423234b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC10931b f423235c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f423236d;

        c(int i3, a aVar, InterfaceC10931b interfaceC10931b, Context context) {
            this.f423233a = i3;
            this.f423234b = aVar;
            this.f423235c = interfaceC10931b;
            this.f423236d = context;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean isSuccess, long retCode, String errorMsg, Watermark$GetDownloadUrlRsp rsp) {
            ArrayList<String> arrayList;
            PBRepeatMessageField<Watermark$DownloadUrlInfo> pBRepeatMessageField;
            List<Watermark$DownloadUrlInfo> list;
            int collectionSizeOrDefault;
            PBRepeatMessageField<Watermark$DownloadUrlInfo> pBRepeatMessageField2;
            Intrinsics.checkNotNullParameter(baseRequest, "baseRequest");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
            String str = b.TAG;
            String traceId = baseRequest.getTraceId();
            int size = (rsp == null || (pBRepeatMessageField2 = rsp.download_urls) == null) ? 0 : pBRepeatMessageField2.size();
            QLog.d(str, 1, "getWatermarkDownloadUrl onReceive: dispatch Success:" + isSuccess + " | traceId:" + traceId + " | retCode:" + retCode + " | retMessage:" + errorMsg + " | isCache:" + isProtocolCache + " | size:" + size + " | source:" + this.f423233a);
            if (isSuccess && retCode == 0) {
                if (rsp != null && (pBRepeatMessageField = rsp.download_urls) != null && (list = pBRepeatMessageField.get()) != null) {
                    List<Watermark$DownloadUrlInfo> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    arrayList = new ArrayList<>(collectionSizeOrDefault);
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Watermark$DownloadUrlInfo) it.next()).url.get());
                    }
                } else {
                    arrayList = new ArrayList<>();
                }
                this.f423235c.a(arrayList);
                return;
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final Context context = this.f423236d;
            uIHandler.post(new Runnable() { // from class: oo.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(context);
                }
            });
            a aVar = this.f423234b;
            if (aVar != null) {
                aVar.a(retCode, errorMsg);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Context context) {
            QQToast.makeText(context, 0, R.string.f174762wq, 0).show();
        }
    }

    @JvmStatic
    public static final void n(String waterMarkSwitchType, boolean waterMarkSwitchStatus) {
        String str;
        if (!(waterMarkSwitchType == null || waterMarkSwitchType.length() == 0)) {
            n l3 = g.f53821a.l();
            if (waterMarkSwitchStatus) {
                str = "1";
            } else {
                str = "0";
            }
            l3.p(waterMarkSwitchType, str);
            return;
        }
        QLog.e(TAG, 1, "updateWatermarkSwitchStatus input wrong waterMarkSwitchType:" + waterMarkSwitchType + ",status:" + waterMarkSwitchStatus);
    }
}
