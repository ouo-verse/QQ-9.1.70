package ch;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import ch.j;
import com.google.protobuf.nano.MessageNano;
import com.qzone.publish.ui.model.QzoneVipCommentIconInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QzoneCommentBigVipBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.vas.update.entity.UpdateListenerParams;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import x8.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f30825a = VasLongToggle.VAS_QZONE_COMMENT_FEATURE.isEnable(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f30826a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f30827b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f30828c;

        a(b bVar, String str, int i3) {
            this.f30826a = bVar;
            this.f30827b = str;
            this.f30828c = i3;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(UpdateListenerParams updateListenerParams) {
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final b bVar = this.f30826a;
            uIHandler.post(new Runnable() { // from class: ch.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.this.onResult(null);
                }
            });
            QLog.e("QzoneCommentNameHelper", 1, " download error " + this.f30828c);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final b bVar = this.f30826a;
            final String str = this.f30827b;
            uIHandler.post(new Runnable() { // from class: ch.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.this.onResult(str);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void onResult(String str);
    }

    public static QzoneVipCommentIconInfo d() {
        AppRuntime peekAppRuntime;
        if (f30825a && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            return (QzoneVipCommentIconInfo) VipMMKV.getQzoneVipData(peekAppRuntime.getCurrentUin()).decodeParcelable("qzone_vip_comment_icon_info", QzoneVipCommentIconInfo.class, null);
        }
        return null;
    }

    public static void f(d.a aVar, final b bVar) {
        if (!f30825a) {
            bVar.onResult(null);
            return;
        }
        if (aVar == null) {
            bVar.onResult(null);
            return;
        }
        final int i3 = aVar.f447398a;
        final int i16 = aVar.f447400c;
        final QzoneCommentBigVipBusiness qzoneCommentBigVipBusiness = (QzoneCommentBigVipBusiness) QQVasUpdateBusiness.getBusiness(QzoneCommentBigVipBusiness.class);
        final String savePath = qzoneCommentBigVipBusiness.getSavePath(i3, i16);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: ch.e
            @Override // java.lang.Runnable
            public final void run() {
                j.j(QzoneCommentBigVipBusiness.this, i3, i16, bVar, savePath);
            }
        });
    }

    public static boolean g(QzoneVipCommentIconInfo qzoneVipCommentIconInfo) {
        return f30825a && qzoneVipCommentIconInfo != null && qzoneVipCommentIconInfo.f51898d > 0 && qzoneVipCommentIconInfo.f51899e > 0;
    }

    public static void h(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fromQZone", true);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(QzoneCommentBigVipBusiness qzoneCommentBigVipBusiness, int i3, int i16, final b bVar, final String str) {
        if (qzoneCommentBigVipBusiness.isFileExits(i3, i16)) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ch.g
                @Override // java.lang.Runnable
                public final void run() {
                    j.b.this.onResult(str);
                }
            });
        } else {
            qzoneCommentBigVipBusiness.addDownLoadListener(i3, i16, new a(bVar, str, i3));
            qzoneCommentBigVipBusiness.startDownload(i3, i16);
        }
    }

    public static void l() {
        if (f30825a) {
            ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.qzmall.uni_user_item.UniUserItem.SsoQzmallCommentGet", MessageNano.toByteArray(new dz3.c()), new BusinessObserver() { // from class: ch.f
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    j.k(i3, z16, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(int i3, boolean z16, Object obj) {
        if (z16 && (obj instanceof byte[])) {
            try {
                dz3.d c16 = dz3.d.c((byte[]) obj);
                dz3.a aVar = c16.f395280a;
                if (aVar != null && aVar.f395276a != null) {
                    QzoneVipCommentIconInfo qzoneVipCommentIconInfo = new QzoneVipCommentIconInfo();
                    dz3.b bVar = c16.f395280a.f395276a;
                    qzoneVipCommentIconInfo.f51898d = bVar.f395277a;
                    qzoneVipCommentIconInfo.f51899e = bVar.f395278b;
                    qzoneVipCommentIconInfo.f51900f = bVar.f395279c;
                    VipMMKV.getQzoneVipData(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()).encodeParcelable("qzone_vip_comment_icon_info", qzoneVipCommentIconInfo);
                    return;
                }
                QLog.e("QzoneCommentNameHelper", 1, "data is null ");
                return;
            } catch (Exception e16) {
                QLog.e("QzoneCommentNameHelper", 1, "parse error" + e16);
                return;
            }
        }
        QLog.e("QzoneCommentNameHelper", 1, "request error $isSuccess");
    }

    public static String e(int i3) {
        if (i3 == 1) {
            return "dongtai_feed";
        }
        if (i3 == 2) {
            return "dongtai_detail";
        }
        if (i3 == 3) {
            return "profile_feed";
        }
        if (i3 == 5) {
            return "shuoshuo_feed";
        }
        if (i3 == 8) {
            return "dongtai_detail";
        }
        if (i3 != 12) {
            return "";
        }
        return "profile_feed";
    }
}
