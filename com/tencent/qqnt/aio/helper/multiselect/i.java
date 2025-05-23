package com.tencent.qqnt.aio.helper.multiselect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.webviewplugin.O3ReportUtil;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.aio.helper.multiselect.i;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotIdentityApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes34.dex */
public class i extends NtAIOShareActionSheet {
    private List<ChatMessage> X;
    private final Activity Y;
    private final Context Z;

    /* renamed from: a0, reason: collision with root package name */
    private final com.tencent.aio.api.runtime.a f351092a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements Function2<Boolean, com.tencent.nt.adapter.session.f, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f351093d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f351094e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f351095f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f351096h;

        a(String str, List list, String str2, int i3) {
            this.f351093d = str;
            this.f351094e = list;
            this.f351095f = str2;
            this.f351096h = i3;
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
            if (bVar.c(this.f351093d, "RobotAioShareActionSheet")) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            String str4 = str2;
            int b16 = fVar.b();
            String str5 = this.f351093d;
            if (b16 == 0) {
                if (((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(str5)) {
                    G = NewReportPlugin.G(str5, b16);
                    i3 = 100730;
                } else if (!bVar.c(str5, "RobotAioShareActionSheet")) {
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
                str = ((ChatMessage) this.f351094e.get(0)).frienduin;
                String str6 = ((ChatMessage) this.f351094e.get(0)).senderuin;
                bundle = NewReportPlugin.G(str, b16);
                str3 = str6;
                i16 = 25080;
            }
            String k3 = NewReportPlugin.k(this.f351094e);
            String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(com.tencent.mobileqq.jubao.a.A(this.f351094e).getBytes(), 2);
            if (i.this.Y instanceof QBaseActivity) {
                O3ReportUtil.d((QBaseActivity) i.this.Y, str3, str4, str, this.f351095f, i16, k3, this.f351096h, encodeToString, bundle);
            } else {
                QLog.i("RobotAioShareActionSheet", 1, "[doReportSelectedMessage]: activity is not QBaseActivity, " + i.this.Y);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, final com.tencent.nt.adapter.session.f fVar) {
            if (bool.booleanValue() && fVar != null) {
                final String a16 = fVar.a();
                if (i.this.Y.isFinishing()) {
                    QLog.i("RobotAioShareActionSheet", 1, "activity finishing return");
                    return null;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    d(fVar, a16);
                } else {
                    i.this.Y.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.multiselect.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.a.this.d(fVar, a16);
                        }
                    });
                }
                return null;
            }
            QLog.i("RobotAioShareActionSheet", 1, "uid2Uin convert error");
            return null;
        }
    }

    public i(QQAppInterface qQAppInterface, Context context, Activity activity, com.tencent.aio.api.runtime.a aVar) {
        super(qQAppInterface, context, activity, aVar);
        this.Y = activity;
        this.Z = context;
        this.f351092a0 = aVar;
    }

    private void M() {
        String currentAccountUin = this.f351022d.getCurrentAccountUin();
        QQAppInterface qQAppInterface = this.f351022d;
        String str = NtAIOShareActionSheet.Q;
        ReportController.o(qQAppInterface, "CliOper", "", currentAccountUin, str, str, 0, 0, "", "", "", "");
        List<ChatMessage> list = this.X;
        int size = list.size();
        if (size == 0) {
            Q(this.Z.getString(R.string.yjl));
            return;
        }
        if (size > 50) {
            Q(this.Z.getString(R.string.yjn) + 50 + this.Z.getString(R.string.yjo));
            return;
        }
        String k3 = ad.k(list.get(0));
        Iterator<ChatMessage> it = list.iterator();
        while (it.hasNext()) {
            if (!ad.k(it.next()).equals(k3)) {
                Q(this.Z.getString(R.string.yjm));
                return;
            }
        }
        AIOContact c16 = this.f351092a0.g().r().c();
        com.tencent.nt.adapter.session.c.h(c16.j(), c16.e(), new a(k3, list, currentAccountUin, size));
    }

    public void W(List<AIOMsgItem> list) {
        ArrayList arrayList = new ArrayList(list);
        this.X = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(this.f351022d, ((AIOMsgItem) it.next()).getMsgRecord());
            if (convertToChatMessage != null) {
                this.X.add(convertToChatMessage);
            }
        }
        Intent intent = this.Y.getIntent();
        boolean isRobotUin = ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.f351092a0.g().r().c().j()));
        if (intent != null) {
            if (isRobotUin) {
                intent.putExtra("big_brother_source_key", "biz_src_qqagent");
            } else {
                intent.putExtra("big_brother_source_key", "biz_src_jc_aio");
            }
        }
        M();
    }
}
