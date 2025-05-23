package com.tencent.qqnt.pluspanel.processor;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/e;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "index", "", "b", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "info", "c", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements com.tencent.qqnt.pluspanel.logic.b {
    private final String b(int index) {
        return "https://pub.idqqimg.com/pc/group/anony/portrait/img/" + index + ".png";
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        String j3 = context.g().r().c().j();
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("AnonymousSettingOnClickProcessor", 1, " onClick| getAnonymousInfo error for kernelMsgService is null");
                return;
            }
            return;
        }
        GroupAnonymousInfo anonymousInfo = e16.getAnonymousInfo(j3);
        if (anonymousInfo != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof QQAppInterface)) {
                if (QLog.isColorLevel()) {
                    QLog.e("AnonymousSettingOnClickProcessor", 1, "need QQAppInterface");
                }
            } else {
                c((QQAppInterface) peekAppRuntime, context, anonymousInfo);
                QLog.d("AnonymousSettingOnClickProcessor", 1, " onClick| getAnonymousInfo,  anonymouseStatus = " + anonymousInfo.isAnonymousChat);
            }
        }
    }

    public final void c(QQAppInterface app, com.tencent.aio.api.runtime.a context, GroupAnonymousInfo info) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.isAnonymousChat) {
            int k3 = com.tencent.biz.anonymous.a.k(context.g().r().c().j());
            Intent intent = new Intent(context.c().getActivity(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", "https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=" + su3.b.b(context.g().r()).f179557e + "&avatar=" + b(info.headPicIndex) + "&nick=" + info.anonyNick + "&role=" + k3 + "&self=1");
            FragmentActivity activity = context.c().getActivity();
            if (activity != null) {
                activity.startActivity(intent);
            }
            ReportController.o(app, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, su3.b.b(context.g().r()).f179557e, String.valueOf(k3), "", "");
        }
    }
}
