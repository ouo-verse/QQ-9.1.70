package com.tencent.qqnt.aio.helper.multiselect;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.webviewplugin.O3ReportUtil;
import com.tencent.imcore.message.ad;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.multimsg.save.a;
import com.tencent.mobileqq.multimsg.save.m;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.c;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOMenuApi;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.aio.helper.er;
import com.tencent.qqnt.aio.helper.multiselect.NtAIOShareActionSheet;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumPermissionUtil;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes34.dex */
public class NtAIOShareActionSheet implements ShareActionSheet.OnItemClickListener, com.tencent.mobileqq.multimsg.save.g {
    public static String I = "0X8007F0A ";
    public static String J = "0X8007F0D ";
    public static String K = "0X8007F0E ";
    public static String L = "0X8007F0F ";
    public static String M = "0X8007F10 ";
    public static String N = "0X800A77E";
    public static String P = "0X800B761";
    public static String Q = "0X800B762";
    private static String R = "102635";
    private static int S = 1;
    private static int T = 2;
    private static int U = 3;
    private static String V = "cancel";
    private static String W = "reselect";
    WXShareHelper.a E;
    private List<AIOMsgItem> F;
    private List<ChatMessage> G;
    private QQProgressDialog H;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f351022d;

    /* renamed from: e, reason: collision with root package name */
    private final Activity f351023e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f351024f;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.aio.api.runtime.a f351025h;

    /* renamed from: i, reason: collision with root package name */
    protected ShareActionSheet f351026i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f351027m = false;
    private boolean C = false;
    private er D = er.f350819a;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QQAppInterface qQAppInterface = NtAIOShareActionSheet.this.f351022d;
            String str = NtAIOShareActionSheet.I;
            ReportController.o(qQAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NtAIOShareActionSheet.this.N();
            QQAppInterface qQAppInterface = NtAIOShareActionSheet.this.f351022d;
            String str = NtAIOShareActionSheet.I;
            ReportController.o(qQAppInterface, "CliOper", "", "", str, str, 1, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.multimsg.save.a f351037a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.multimsg.save.m f351038b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f351039c;

        c(com.tencent.mobileqq.multimsg.save.a aVar, com.tencent.mobileqq.multimsg.save.m mVar, List list) {
            this.f351037a = aVar;
            this.f351038b = mVar;
            this.f351039c = list;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            NtAIOShareActionSheet.this.S(this.f351037a, this.f351038b, this.f351039c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements ITDocAIOImportFacade.a {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str, boolean z16) {
            NtAIOShareActionSheet.this.x();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            QQToast.makeText(NtAIOShareActionSheet.this.f351024f, !z16 ? 1 : 0, str, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            NtAIOShareActionSheet.this.v();
            NtAIOShareActionSheet ntAIOShareActionSheet = NtAIOShareActionSheet.this;
            ntAIOShareActionSheet.P(ntAIOShareActionSheet.f351024f, NtAIOShareActionSheet.this.f351024f.getString(R.string.f169392i8));
        }

        @Override // com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade.a
        public void a(final boolean z16, int i3, final String str) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.helper.multiselect.e
                @Override // java.lang.Runnable
                public final void run() {
                    NtAIOShareActionSheet.d.this.e(str, z16);
                }
            }, 1000L);
            if (!z16) {
                HashMap hashMap = new HashMap();
                hashMap.put("ver1", Integer.valueOf(i3));
                hashMap.put("ver2", str);
                ((ITDocAIOImportFacade) QRoute.api(ITDocAIOImportFacade.class)).reportSaveToTencentDocs("fail", hashMap);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ver2", str);
            ((ITDocAIOImportFacade) QRoute.api(ITDocAIOImportFacade.class)).reportSaveToTencentDocs("part_fail", hashMap2);
        }

        @Override // com.tencent.mobileqq.teamwork.api.ITDocAIOImportFacade.a
        public void b() {
            NtAIOShareActionSheet.this.f351023e.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.multiselect.f
                @Override // java.lang.Runnable
                public final void run() {
                    NtAIOShareActionSheet.d.this.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            NtAIOShareActionSheet.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f351043d;

        f(List list) {
            this.f351043d = list;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NtAIOShareActionSheet.this.w(this.f351043d);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f351045d;

        g(int i3) {
            this.f351045d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            NtAIOShareActionSheet.this.v();
            NtAIOShareActionSheet.this.D.c(this.f351045d, NtAIOShareActionSheet.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f351047d;

        h(int i3) {
            this.f351047d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            NtAIOShareActionSheet.this.D.c(this.f351047d, NtAIOShareActionSheet.W);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f351049d;

        i(ActionSheet actionSheet) {
            this.f351049d = actionSheet;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f351049d.dismiss();
            NtAIOShareActionSheet.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class j implements IOperateCallback {
        j() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            QLog.d("AIOShareActionSheet", 1, "recallTroopMsg resultCode = ", Integer.valueOf(i3), " errorMsg = ", str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class k implements WXShareHelper.a {
        k() {
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            QLog.d("AIOShareActionSheet", 1, "WXShareResult trans:" + baseResp.transaction + " ,errCode:" + baseResp.errCode + " ,errStr:" + baseResp.errStr);
            WXShareHelper.b0().q0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class l implements Function2<Boolean, com.tencent.nt.adapter.session.f, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f351053d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f351054e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f351055f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f351056h;

        l(String str, List list, String str2, int i3) {
            this.f351053d = str;
            this.f351054e = list;
            this.f351055f = str2;
            this.f351056h = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void d(com.tencent.nt.adapter.session.f fVar, String str) {
            String str2;
            Bundle G;
            int i3;
            Bundle G2;
            Bundle bundle;
            int i16;
            String str3;
            com.tencent.qqnt.contact.friends.b bVar = com.tencent.qqnt.contact.friends.b.f355778a;
            if (bVar.c(this.f351053d, "AIOShareActionSheet")) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            String str4 = str2;
            int b16 = fVar.b();
            String str5 = this.f351053d;
            if (b16 == 0) {
                if (((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(str5)) {
                    G = NewReportPlugin.G(str5, b16);
                    i3 = 100730;
                } else if (!bVar.c(str5, "AIOShareActionSheet")) {
                    G2 = NewReportPlugin.G(str5, b16);
                    bundle = G2;
                    str3 = str5;
                    i16 = 25061;
                } else {
                    G = NewReportPlugin.G(str5, b16);
                    i3 = 25062;
                }
                bundle = G;
                i16 = i3;
                str3 = str5;
            } else if (b16 == 1 || b16 == 3000) {
                if (((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(str5)) {
                    G = NewReportPlugin.G(str5, b16);
                    i3 = 101063;
                } else {
                    G = NewReportPlugin.G(str, b16);
                    i3 = 25060;
                }
                bundle = G;
                i16 = i3;
                str3 = str5;
            } else if (b16 != 10014) {
                G2 = NewReportPlugin.G(str5, b16);
                bundle = G2;
                str3 = str5;
                i16 = 25061;
            } else {
                str = ((ChatMessage) this.f351054e.get(0)).frienduin;
                String str6 = ((ChatMessage) this.f351054e.get(0)).senderuin;
                bundle = NewReportPlugin.G(str, b16);
                str3 = str6;
                i16 = 25080;
            }
            String k3 = NewReportPlugin.k(this.f351054e);
            String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(com.tencent.mobileqq.jubao.a.A(this.f351054e).getBytes(), 2);
            if (NtAIOShareActionSheet.this.f351023e instanceof QBaseActivity) {
                O3ReportUtil.d((QBaseActivity) NtAIOShareActionSheet.this.f351023e, str3, str4, str, this.f351055f, i16, k3, this.f351056h, encodeToString, bundle);
            } else {
                QLog.i("AIOShareActionSheet", 1, "[doReportSelectedMessage]: activity is not QBaseActivity, " + NtAIOShareActionSheet.this.f351023e);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, final com.tencent.nt.adapter.session.f fVar) {
            if (bool.booleanValue() && fVar != null) {
                final String a16 = fVar.a();
                if (NtAIOShareActionSheet.this.f351023e.isFinishing()) {
                    QLog.i("AIOShareActionSheet", 1, "activity finishing return");
                    return null;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    d(fVar, a16);
                } else {
                    NtAIOShareActionSheet.this.f351023e.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.multiselect.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            NtAIOShareActionSheet.l.this.d(fVar, a16);
                        }
                    });
                }
                return null;
            }
            QLog.i("AIOShareActionSheet", 1, "uid2Uin convert error");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class m implements DialogInterface.OnClickListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class n implements DialogInterface.OnClickListener {
        n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class o implements DialogInterface.OnClickListener {
        o() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NtAIOShareActionSheet.this.O();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class p implements Function2<Boolean, com.tencent.nt.adapter.session.f, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f351061d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f351062e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f351063f;

        p(boolean z16, String str, List list) {
            this.f351061d = z16;
            this.f351062e = str;
            this.f351063f = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, com.tencent.nt.adapter.session.f fVar) {
            if (bool.booleanValue() && fVar != null) {
                String a16 = fVar.a();
                int b16 = fVar.b();
                if (this.f351061d && NtAIOShareActionSheet.this.f351024f != null) {
                    QQToast.makeText(NtAIOShareActionSheet.this.f351024f, NtAIOShareActionSheet.this.f351024f.getString(R.string.vxt), 0).show();
                }
                com.tencent.mobileqq.richmediabrowser.utils.c.f(NtAIOShareActionSheet.this.f351023e, new c.QzoneAlbumNTForwardData(this.f351062e, a16, a16, b16, this.f351063f, 102));
                return null;
            }
            QLog.e("AIOShareActionSheet", 1, "uid2Uin convert error");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class q implements Function2<Boolean, com.tencent.nt.adapter.session.f, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f351065d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f351066e;

        q(boolean z16, List list) {
            this.f351065d = z16;
            this.f351066e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, com.tencent.nt.adapter.session.f fVar) {
            if (bool.booleanValue() && fVar != null) {
                String a16 = fVar.a();
                if (this.f351065d && NtAIOShareActionSheet.this.f351024f != null) {
                    QQToast.makeText(NtAIOShareActionSheet.this.f351024f, NtAIOShareActionSheet.this.f351024f.getString(R.string.f223916hi), 0).show();
                }
                ForwardGroupAlbumBean forwardGroupAlbumBean = new ForwardGroupAlbumBean();
                forwardGroupAlbumBean.context = NtAIOShareActionSheet.this.f351024f;
                forwardGroupAlbumBean.groupId = a16;
                forwardGroupAlbumBean.isSingleMedia = false;
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f351066e.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AIOMsgItem) it.next()).getMsgRecord());
                }
                forwardGroupAlbumBean.mediaList = ((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).msgRecordToMediaInfo(arrayList);
                if (((IQZoneForwardGroupAlbumApi) QRoute.api(IQZoneForwardGroupAlbumApi.class)).forwardToGroupAlbum(forwardGroupAlbumBean, 3)) {
                    NtAIOShareActionSheet.this.v();
                }
                return null;
            }
            QLog.e("AIOShareActionSheet", 1, "uid2Uin convert error");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class r implements DialogInterface.OnClickListener {
        r() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class s implements DialogInterface.OnClickListener {
        s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ReportController.o(NtAIOShareActionSheet.this.f351022d, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
            if (ym2.a.e(NtAIOShareActionSheet.this.F)) {
                NtAIOShareActionSheet.this.v();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class t implements DialogInterface.OnClickListener {
        t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class u implements DialogInterface.OnClickListener {
        u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NtAIOShareActionSheet ntAIOShareActionSheet = NtAIOShareActionSheet.this;
            if (ntAIOShareActionSheet.T(ntAIOShareActionSheet.F)) {
                NtAIOShareActionSheet.this.v();
            }
        }
    }

    public NtAIOShareActionSheet(QQAppInterface qQAppInterface, Context context, Activity activity, com.tencent.aio.api.runtime.a aVar) {
        this.f351022d = qQAppInterface;
        this.f351024f = context;
        this.f351023e = activity;
        this.f351025h = aVar;
    }

    private List<AIOMsgItem> A(List<AIOMsgItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (AIOMsgItem aIOMsgItem : list) {
            if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem) && !com.tencent.mobileqq.aio.utils.d.y(aIOMsgItem) && (aIOMsgItem.getMsgRecord().getSendType() != 1 || aIOMsgItem.getMsgRecord().getSendStatus() == 2)) {
                arrayList.add(aIOMsgItem);
            }
        }
        return arrayList;
    }

    private void B(List<AIOMsgItem> list, String str) {
        boolean z16 = false;
        if (!G(str) && !F(str)) {
            Context context = this.f351024f;
            QQToast.makeText(context, 1, context.getString(R.string.f169582iq), 0).show();
            v();
            return;
        }
        boolean z17 = list.size() > 10;
        ArrayList arrayList = new ArrayList();
        Iterator<AIOMsgItem> it = list.iterator();
        boolean z18 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AIOMsgItem next = it.next();
            if (!next.isSelf() && F(next.getMsgRecord().peerUid) && !C(next.getMsgRecord().peerUid, Long.toString(next.getMsgRecord().senderUin))) {
                z16 = true;
                break;
            } else if (next.getMsgRecord().getMsgType() == 19 || next.getMsgRecord().getMsgType() == 10 || !((IAIOMenuApi) com.tencent.qqnt.aio.adapter.a.b(IAIOMenuApi.class)).isSupportRevoke(this.f351025h, next, true, true)) {
                arrayList.add(next);
                z18 = true;
            }
        }
        if (!arrayList.isEmpty()) {
            list.removeAll(arrayList);
        }
        if (z17 && z16) {
            L(this.f351024f.getString(R.string.f169612it), U);
            return;
        }
        if (z17) {
            L(this.f351024f.getString(R.string.f169622iu), S);
            return;
        }
        if (z16) {
            L(this.f351024f.getString(R.string.f169632iv), T);
        } else if (z18) {
            U(list);
        } else {
            w(list);
        }
    }

    private boolean C(String str, String str2) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(str, str2, false, null, "AIOShareActionSheet", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.qqnt.aio.helper.multiselect.b
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                NtAIOShareActionSheet.I(atomicBoolean, troopMemberInfo);
            }
        });
        return atomicBoolean.get();
    }

    public static boolean D(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private boolean E(AIOMsgItem aIOMsgItem) {
        FileElement fileElement;
        return com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem) ? (com.tencent.mobileqq.richmediabrowser.utils.c.w(aIOMsgItem.getFirstTypeElement(2).getPicElement()) || com.tencent.mobileqq.aio.utils.d.y(aIOMsgItem)) ? false : true : aIOMsgItem.getMsgRecord().getMsgType() == 7 ? aIOMsgItem.e2() : com.tencent.mobileqq.aio.utils.d.x(aIOMsgItem) && (fileElement = aIOMsgItem.getFirstTypeElement(3).getFileElement()) != null && fileElement.getInvalidState().intValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(Context context, DialogInterface dialogInterface) {
        ((ITDocAIOImportFacade) QRoute.api(ITDocAIOImportFacade.class)).cancelImport(context);
    }

    private void K(List<AIOMsgItem> list) {
        if (!NetworkUtil.isNetworkAvailable()) {
            Context context = this.f351024f;
            QQToast.makeText(context, 1, context.getString(R.string.b3j), 0).show();
            return;
        }
        for (AIOMsgItem aIOMsgItem : list) {
            ((IMsgService) QRoute.api(IMsgService.class)).recallMsg(new Contact(aIOMsgItem.getMsgRecord().chatType, aIOMsgItem.getMsgRecord().peerUid, aIOMsgItem.getMsgRecord().guildId), aIOMsgItem.getMsgId(), new j());
        }
        v();
    }

    private void L(String str, int i3) {
        this.D.d(i3);
        DialogUtil.createCustomDialog(this.f351024f, 230).setMessage(str).setPositiveButton(this.f351024f.getString(R.string.f169592ir), new h(i3)).setNegativeButton(17039360, new g(i3)).show();
    }

    private void M() {
        String currentAccountUin = this.f351022d.getCurrentAccountUin();
        QQAppInterface qQAppInterface = this.f351022d;
        String str = Q;
        ReportController.o(qQAppInterface, "CliOper", "", currentAccountUin, str, str, 0, 0, "", "", "", "");
        List<ChatMessage> list = this.G;
        int size = list.size();
        if (size == 0) {
            Q(this.f351024f.getString(R.string.yjl));
            return;
        }
        if (size > 50) {
            Q(this.f351024f.getString(R.string.yjn) + 50 + this.f351024f.getString(R.string.yjo));
            return;
        }
        String k3 = ad.k(list.get(0));
        Iterator<ChatMessage> it = list.iterator();
        while (it.hasNext()) {
            if (!ad.k(it.next()).equals(k3)) {
                Q(this.f351024f.getString(R.string.yjm));
                return;
            }
        }
        AIOContact c16 = this.f351025h.g().r().c();
        com.tencent.nt.adapter.session.c.h(c16.j(), c16.e(), new l(k3, list, currentAccountUin, size));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final Context context, String str) {
        if (this.H == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(context);
            this.H = qQProgressDialog;
            qQProgressDialog.setCancelable(true);
            this.H.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.qqnt.aio.helper.multiselect.d
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    NtAIOShareActionSheet.J(context, dialogInterface);
                }
            });
        }
        this.H.setMessage(str);
        this.H.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T(List<AIOMsgItem> list) {
        com.tencent.aio.api.runtime.a aVar;
        if (this.f351022d != null && this.f351023e != null && (aVar = this.f351025h) != null) {
            int i3 = aVar.g().l().getInt("key_msg_head_padding", 0);
            if (list != null && !list.isEmpty()) {
                return WeiyunAIOUtils.i(this.f351022d, this.f351023e, i3, list, -1);
            }
            QQToast.makeText(this.f351022d.getApp(), R.string.f6q, 0).show(i3);
        }
        return false;
    }

    private void U(List<AIOMsgItem> list) {
        DialogUtil.createCustomDialog(this.f351024f, 230).setMessage(this.f351024f.getString(R.string.f169642iw)).setPositiveButton(this.f351024f.getString(R.string.f169562io), new f(list)).setNegativeButton(17039360, new e()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.tencent.aio.api.runtime.a aVar = this.f351025h;
        if (aVar == null) {
            return;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        e16.h(new MultiSelectEvent.SetSelectMode(false));
        e16.h(new AIOMsgListEvent.MultiSelectModeChangeEvent("AIOShareActionSheet", false));
        e16.h(new AIOMsgListEvent.SetCommunicationShareButton(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final List<AIOMsgItem> list) {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f351024f, null);
        actionSheet.addButton(R.string.f169572ip, 3);
        actionSheet.setMainTitle(R.string.f169602is);
        actionSheet.addCancelButton(17039360);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.multiselect.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                NtAIOShareActionSheet.this.H(list, actionSheet, view, i3);
            }
        });
        actionSheet.setOnBottomCancelListener(new i(actionSheet));
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        QQProgressDialog qQProgressDialog = this.H;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.H = null;
        }
    }

    private List<AIOMsgItem> z(List<AIOMsgItem> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (AIOMsgItem aIOMsgItem : list) {
            if (((com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem) && !com.tencent.mobileqq.aio.utils.d.y(aIOMsgItem)) || MsgExtKt.L(aIOMsgItem.getMsgRecord())) && (aIOMsgItem.getMsgRecord().getSendType() != 1 || aIOMsgItem.getMsgRecord().getSendStatus() == 2)) {
                arrayList.add(aIOMsgItem);
            }
            if (com.tencent.mobileqq.aio.utils.d.d0(aIOMsgItem) || MsgExtKt.Y(aIOMsgItem.getMsgRecord()) || MsgExtKt.X(aIOMsgItem.getMsgRecord())) {
                if (aIOMsgItem.getMsgRecord().getSendType() != 1 || aIOMsgItem.getMsgRecord().getSendStatus() == 2) {
                    arrayList.add(aIOMsgItem);
                }
            }
        }
        return arrayList;
    }

    public boolean F(String str) {
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str);
        return troopInfoFromCache != null && troopInfoFromCache.memberRole == MemberRole.ADMIN;
    }

    public boolean G(String str) {
        TroopInfo troopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str);
        return troopInfoFromCache != null && troopInfoFromCache.memberRole == MemberRole.OWNER;
    }

    public boolean N() {
        List<AIOMsgItem> list = this.F;
        ArrayList arrayList = new ArrayList();
        for (AIOMsgItem aIOMsgItem : list) {
            if (com.tencent.mobileqq.richmediabrowser.utils.c.u(aIOMsgItem)) {
                arrayList.add(aIOMsgItem);
            }
        }
        if (arrayList.isEmpty()) {
            QQToast.makeText(this.f351022d.getApp(), R.string.ceb, 0).show();
            return false;
        }
        com.tencent.mobileqq.richmediabrowser.utils.c.z(this.f351025h, arrayList);
        return true;
    }

    public void O() {
        ArrayList arrayList = new ArrayList();
        for (AIOMsgItem aIOMsgItem : this.F) {
            if (com.tencent.mobileqq.richmediabrowser.utils.c.v(aIOMsgItem)) {
                arrayList.add(aIOMsgItem);
            }
        }
        if (arrayList.isEmpty()) {
            QQToast.makeText(this.f351022d.getApp(), R.string.ce7, 0).show();
            v();
        } else {
            com.tencent.mobileqq.richmediabrowser.utils.c.A(this.f351024f, this.f351025h, arrayList);
        }
    }

    public void Q(String str) {
        Context context = this.f351024f;
        DialogUtil.createCustomDialog(context, 230, (String) null, str, "", context.getString(R.string.yjk), new m(), (DialogInterface.OnClickListener) null).show();
    }

    public boolean u() {
        Iterator<AIOMsgItem> it = this.F.iterator();
        while (it.hasNext()) {
            if (!E(it.next())) {
                return false;
            }
        }
        return true;
    }

    public List<ShareActionSheetBuilder.ActionSheetItem>[] y(Context context, boolean z16) {
        ArrayList arrayList = new ArrayList();
        boolean z17 = com.tencent.mobileqq.activity.aio.l.x(2) == 0;
        boolean z18 = com.tencent.mobileqq.activity.aio.l.x(3) == 0 && z16;
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(25));
        if (this.f351027m) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(50));
        }
        if (this.C) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(51));
        }
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        ArrayList arrayList2 = new ArrayList();
        if (z17) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        }
        if (z18) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(27));
        }
        if (((ITDocAIOImportFacade) QRoute.api(ITDocAIOImportFacade.class)).isAIOImportEnable()) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(222));
        }
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(28));
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(39);
        build.label = context.getString(R.string.f227466r4);
        arrayList2.add(build);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(R, false)) {
            String j3 = this.f351025h.g().r().c().j();
            if (G(j3) || F(j3)) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(228));
                this.D.b(G(j3));
            }
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(AtomicBoolean atomicBoolean, TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo != null) {
            MemberRole memberRole = troopMemberInfo.role;
            if (memberRole == MemberRole.OWNER || memberRole == MemberRole.ADMIN) {
                atomicBoolean.set(false);
            }
        }
    }

    public void R(List<AIOMsgItem> list) {
        boolean z16;
        boolean z17;
        boolean z18;
        MsgElement firstTypeElement;
        this.F = new ArrayList(list);
        this.G = new ArrayList();
        Iterator<AIOMsgItem> it = this.F.iterator();
        while (it.hasNext()) {
            ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(this.f351022d, it.next().getMsgRecord());
            if (convertToChatMessage != null) {
                this.G.add(convertToChatMessage);
            }
        }
        List<AIOMsgItem> list2 = this.F;
        for (AIOMsgItem aIOMsgItem : list2) {
            if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem) && !com.tencent.mobileqq.aio.utils.d.y(aIOMsgItem) && (aIOMsgItem.getMsgRecord().getSendType() != 1 || aIOMsgItem.getMsgRecord().getSendStatus() == 2)) {
                z16 = true;
                break;
            }
        }
        z16 = false;
        for (AIOMsgItem aIOMsgItem2 : list2) {
            if (aIOMsgItem2.getMsgRecord().getChatType() == 2) {
                if (!com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem2) || com.tencent.mobileqq.aio.utils.d.y(aIOMsgItem2) || ((aIOMsgItem2.getMsgRecord().getSendType() == 1 && aIOMsgItem2.getMsgRecord().getSendStatus() != 2) || !((IQZoneGroupAlbumPermissionUtil) QRoute.api(IQZoneGroupAlbumPermissionUtil.class)).isSupportForwardToGroupAlbum(aIOMsgItem2.getMsgRecord().getPeerUid()))) {
                    if (com.tencent.mobileqq.aio.utils.d.d0(aIOMsgItem2) || MsgExtKt.Y(aIOMsgItem2.getMsgRecord())) {
                        if (aIOMsgItem2.getMsgRecord().getSendType() != 1 || aIOMsgItem2.getMsgRecord().getSendStatus() == 2) {
                            if (((IQZoneGroupAlbumPermissionUtil) QRoute.api(IQZoneGroupAlbumPermissionUtil.class)).isSupportForwardToGroupAlbum(aIOMsgItem2.getMsgRecord().getPeerUid())) {
                            }
                        }
                    }
                }
                z17 = true;
                break;
            }
            break;
        }
        z17 = false;
        boolean isAIOPanelShareSwitch = z17 & ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).isAIOPanelShareSwitch();
        Intent intent = this.f351023e.getIntent();
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.f351025h.g().r().c().j());
        boolean isRobotUin = ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(uinFromUid);
        if (intent != null) {
            if (isRobotUin) {
                intent.putExtra("big_brother_source_key", "biz_src_qqagent");
            } else {
                intent.putExtra("big_brother_source_key", "biz_src_jc_aio");
            }
        }
        String str = "";
        loop3: while (true) {
            z18 = true;
            for (AIOMsgItem aIOMsgItem3 : list2) {
                if (aIOMsgItem3.getMsgRecord().getMsgType() == 2) {
                    MsgElement firstTypeElement2 = aIOMsgItem3.getFirstTypeElement(2);
                    if (firstTypeElement2 != null) {
                        str = firstTypeElement2.getPicElement().getFileUuid();
                    }
                } else if (aIOMsgItem3.getMsgRecord().getMsgType() == 3) {
                    MsgElement firstTypeElement3 = aIOMsgItem3.getFirstTypeElement(3);
                    if (firstTypeElement3 != null) {
                        str = firstTypeElement3.getFileElement().getFileUuid();
                    }
                } else if (aIOMsgItem3.getMsgRecord().getMsgType() == 5 && (firstTypeElement = aIOMsgItem3.getFirstTypeElement(5)) != null) {
                    str = firstTypeElement.getVideoElement().getFileUuid();
                }
                if (!str.isEmpty() && D(str) && z18) {
                    break;
                } else {
                    z18 = false;
                }
            }
        }
        if (this.f351026i == null || this.f351027m != z16 || this.C != isAIOPanelShareSwitch) {
            this.f351027m = z16;
            this.C = isAIOPanelShareSwitch;
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = this.f351023e;
            param.fullScreen = false;
            HashMap hashMap = new HashMap();
            if (isRobotUin) {
                hashMap.put("agent_uin", uinFromUid);
            }
            param.deReportParams = hashMap;
            ShareActionSheet create = ShareActionSheetFactory.create(param);
            this.f351026i = create;
            create.setActionSheetTitle(this.f351024f.getString(R.string.hja));
            this.f351026i.setActionSheetItems(y(this.f351024f, z18));
            this.f351026i.setItemClickListenerV2(this);
        }
        try {
            this.f351026i.show();
            QQAppInterface qQAppInterface = this.f351022d;
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            String str2 = P;
            ReportController.o(qQAppInterface, "CliOper", "", currentAccountUin, str2, str2, 0, 0, "", "", "", "");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(List list, ActionSheet actionSheet, View view, int i3) {
        if (i3 != 0) {
            return;
        }
        K(list);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final com.tencent.mobileqq.multimsg.save.a aVar, final com.tencent.mobileqq.multimsg.save.m mVar, final List<m.b> list) {
        if (aVar == null || mVar == null || list == null) {
            return;
        }
        mVar.A(new com.tencent.mobileqq.multimsg.save.f() { // from class: com.tencent.qqnt.aio.helper.multiselect.NtAIOShareActionSheet.20

            /* compiled from: P */
            /* renamed from: com.tencent.qqnt.aio.helper.multiselect.NtAIOShareActionSheet$20$a */
            /* loaded from: classes34.dex */
            class a implements a.b {
                a() {
                }

                @Override // com.tencent.mobileqq.multimsg.save.a.b
                public void cancel() {
                    AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                    if (mVar == null) {
                        return;
                    }
                    if (NtAIOShareActionSheet.this.f351025h != null) {
                        AnonymousClass20 anonymousClass202 = AnonymousClass20.this;
                        mVar.t(list, 2, NtAIOShareActionSheet.this.f351025h.g().r().c().e());
                    }
                    mVar.m();
                    NtAIOShareActionSheet.this.v();
                }
            }

            @Override // com.tencent.mobileqq.multimsg.save.f
            public void a() {
                com.tencent.mobileqq.multimsg.save.a aVar2 = aVar;
                if (aVar2 != null && aVar2.isShowing()) {
                    aVar.dismiss();
                }
                NtAIOShareActionSheet.this.v();
                com.tencent.mobileqq.multimsg.save.m mVar2 = mVar;
                if (mVar2 != null) {
                    mVar2.s();
                }
            }

            @Override // com.tencent.mobileqq.multimsg.save.f
            public void b(final int i3) {
                if (aVar == null) {
                    return;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    aVar.Q(i3);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.multiselect.NtAIOShareActionSheet.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.multimsg.save.a aVar2 = aVar;
                            if (aVar2 == null) {
                                return;
                            }
                            aVar2.Q(i3);
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.multimsg.save.f
            public void c() {
                aVar.P(new a());
                aVar.show();
            }

            @Override // com.tencent.mobileqq.multimsg.save.f
            public void d() {
                com.tencent.mobileqq.multimsg.save.m mVar2 = mVar;
                if (mVar2 == null) {
                    return;
                }
                mVar2.C(NtAIOShareActionSheet.this.f351023e, list);
            }

            @Override // com.tencent.mobileqq.multimsg.save.f
            public void e(int i3) {
                if (NtAIOShareActionSheet.this.f351023e != null && !NtAIOShareActionSheet.this.f351023e.isFinishing()) {
                    if (i3 == -1) {
                        com.tencent.mobileqq.multimsg.save.e.a(NtAIOShareActionSheet.this.f351023e);
                    } else if (i3 == 0) {
                        com.tencent.mobileqq.multimsg.save.e.b(NtAIOShareActionSheet.this.f351023e);
                    } else if (i3 == 3) {
                        com.tencent.mobileqq.multimsg.save.e.c(NtAIOShareActionSheet.this.f351023e);
                    }
                }
                if (aVar.isShowing()) {
                    aVar.dismiss();
                }
                NtAIOShareActionSheet.this.v();
                com.tencent.mobileqq.multimsg.save.m mVar2 = mVar;
                if (mVar2 != null) {
                    mVar2.s();
                }
            }
        });
        mVar.x(list, true);
        com.tencent.aio.api.runtime.a aVar2 = this.f351025h;
        if (aVar2 != null) {
            mVar.t(list, 1, aVar2.g().r().c().e());
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        int i3;
        if (actionSheetItem == null) {
            return;
        }
        this.f351026i.dismiss();
        int i16 = actionSheetItem.action;
        if (i16 == 9) {
            QQAppInterface qQAppInterface = this.f351022d;
            String str = J;
            ReportController.o(qQAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
            if (WXShareHelper.b0().e0()) {
                i3 = !WXShareHelper.b0().f0() ? R.string.f173258ih2 : -1;
            } else {
                i3 = R.string.cd8;
            }
            if (i3 != -1) {
                QQToast.makeText(this.f351022d.getApp(), this.f351024f.getString(i3), 0).show();
                return;
            }
            if (this.E != null) {
                this.E = new k();
            }
            WXShareHelper.b0().A(this.E);
            return;
        }
        if (i16 == 11) {
            M();
            return;
        }
        if (i16 == 39) {
            com.tencent.mobileqq.multimsg.save.a aVar = new com.tencent.mobileqq.multimsg.save.a(this.f351023e);
            com.tencent.mobileqq.multimsg.save.m mVar = (com.tencent.mobileqq.multimsg.save.m) this.f351022d.getManager(QQManagerFactory.NT_MULTI_CHOOSE_SAVE_MANAGER);
            if (mVar != null) {
                List<m.b> a16 = com.tencent.mobileqq.multimsg.save.i.a(this.F);
                if (a16 != null && !a16.isEmpty()) {
                    QQPermission qQPermission = QQPermissionFactory.getQQPermission(this.f351023e, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SHARE, QQPermissionConstants.Business.SCENE.SHARE_SAVE_PIC));
                    if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(aVar, mVar, a16));
                        return;
                    } else {
                        S(aVar, mVar, a16);
                        return;
                    }
                }
                Context context = this.f351024f;
                QQToast.makeText(context, context.getString(R.string.h46), 0).show();
                return;
            }
            return;
        }
        if (i16 == 222) {
            ((ITDocAIOImportFacade) QRoute.api(ITDocAIOImportFacade.class)).reportSaveToTencentDocs("button_clk", null);
            if (this.f351022d != null && this.f351023e != null) {
                List<AIOMsgItem> list = this.F;
                if (list != null && !list.isEmpty()) {
                    ((ITDocAIOImportFacade) QRoute.api(ITDocAIOImportFacade.class)).saveToTencentDocs(this.f351023e, this.f351025h.g().l().getInt("key_chat_type"), String.valueOf(this.f351025h.g().l().getLong("key_peerUin")), this.f351025h.g().l().getString("key_chat_name"), this.F, new d());
                    return;
                }
                QQToast.makeText(this.f351024f, R.string.f6q, 0).show();
                return;
            }
            QLog.e("AIOShareActionSheet", 1, "send to tencent docs failed, app or activity is null");
            return;
        }
        if (i16 == 228) {
            String j3 = this.f351025h.g().r().c().j();
            this.D.a(G(j3));
            B(this.F, j3);
            return;
        }
        if (i16 == 50) {
            QQAppInterface qQAppInterface2 = this.f351022d;
            String str2 = N;
            ReportController.o(qQAppInterface2, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
            List<AIOMsgItem> list2 = this.F;
            if (list2 == null) {
                QLog.e("AIOShareActionSheet", 1, "SelectedMsgItems is null");
                return;
            }
            List<AIOMsgItem> A = A(list2);
            if (A != null && !A.isEmpty()) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                String account = peekAppRuntime.getAccount();
                AIOContact c16 = this.f351025h.g().r().c();
                com.tencent.nt.adapter.session.c.h(c16.j(), c16.e(), new p(A.isEmpty(), account, A));
                return;
            }
            Context context2 = this.f351024f;
            QQToast.makeText(context2, context2.getString(R.string.vxt), 0).show();
            return;
        }
        if (i16 != 51) {
            switch (i16) {
                case 25:
                    QQAppInterface qQAppInterface3 = this.f351022d;
                    String str3 = K;
                    ReportController.o(qQAppInterface3, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
                    if (!com.tencent.mobileqq.richmediabrowser.utils.c.c(this.F)) {
                        DialogUtil.createCustomDialog(this.f351024f, 230).setMessage(this.f351024f.getString(R.string.ce5)).setPositiveButton(android.R.string.ok, new o()).setNegativeButton(17039360, new n()).show();
                        return;
                    } else {
                        O();
                        return;
                    }
                case 26:
                    List<AIOMsgItem> list3 = this.F;
                    if (list3 != null && !ym2.a.a(list3)) {
                        DialogUtil.createCustomDialog(this.f351024f, 230).setMessage(this.f351024f.getString(R.string.cef)).setPositiveButton(android.R.string.ok, new s()).setNegativeButton(17039360, new r()).show();
                        return;
                    }
                    if (ym2.a.e(this.F)) {
                        v();
                    }
                    ReportController.o(this.f351022d, "CliOper", "", "", "0X80067F7", "0X80067F7", 0, 0, "", "", "", "");
                    return;
                case 27:
                    QQAppInterface qQAppInterface4 = this.f351022d;
                    String str4 = L;
                    ReportController.o(qQAppInterface4, "CliOper", "", "", str4, str4, 0, 0, "", "", "", "");
                    if (!u()) {
                        DialogUtil.createCustomDialog(this.f351024f, 230).setMessage(this.f351024f.getString(R.string.ced)).setPositiveButton(android.R.string.ok, new u()).setNegativeButton(17039360, new t()).show();
                        return;
                    } else {
                        if (T(this.F)) {
                            v();
                            return;
                        }
                        return;
                    }
                case 28:
                    QQAppInterface qQAppInterface5 = this.f351022d;
                    String str5 = M;
                    ReportController.o(qQAppInterface5, "CliOper", "", "", str5, str5, 0, 0, "", "", "", "");
                    if (!com.tencent.mobileqq.richmediabrowser.utils.c.b(this.F)) {
                        DialogUtil.createCustomDialog(this.f351024f, 230).setMessage(this.f351024f.getString(R.string.cea)).setPositiveButton(android.R.string.ok, new b()).setNegativeButton(17039360, new a()).show();
                        return;
                    } else {
                        if (this.G.isEmpty()) {
                            return;
                        }
                        N();
                        return;
                    }
                default:
                    return;
            }
        }
        List<AIOMsgItem> list4 = this.F;
        if (list4 == null) {
            QLog.e("AIOShareActionSheet", 1, "SelectedMsgItems is null");
            return;
        }
        List<AIOMsgItem> z16 = z(list4);
        if (z16 != null && !z16.isEmpty()) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                return;
            }
            AIOContact c17 = this.f351025h.g().r().c();
            com.tencent.nt.adapter.session.c.h(c17.j(), c17.e(), new q(z16.isEmpty(), z16));
            return;
        }
        Context context3 = this.f351024f;
        QQToast.makeText(context3, context3.getString(R.string.f223916hi), 0).show();
    }

    @Override // com.tencent.mobileqq.multimsg.save.g
    public void a() {
    }

    @Override // com.tencent.mobileqq.multimsg.save.g
    public void c(com.tencent.mobileqq.multimsg.save.d dVar) {
    }

    @Override // com.tencent.mobileqq.multimsg.save.g
    public void d(com.tencent.mobileqq.multimsg.save.d dVar) {
    }

    @Override // com.tencent.mobileqq.multimsg.save.g
    public void b(com.tencent.mobileqq.multimsg.save.d dVar, int i3) {
    }
}
