package com.tencent.mobileqq.guild.robot.components.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.safety.j;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.p;
import com.tencent.mobileqq.guild.share.x;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f232216a;

    /* renamed from: i, reason: collision with root package name */
    private ShareActionSheetBuilder.ActionSheetItem f232224i;

    /* renamed from: l, reason: collision with root package name */
    private RobotInfo f232227l;

    /* renamed from: b, reason: collision with root package name */
    private final c f232217b = new c();

    /* renamed from: c, reason: collision with root package name */
    private final a f232218c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final DialogInterfaceOnDismissListenerC7877b f232219d = new DialogInterfaceOnDismissListenerC7877b();

    /* renamed from: e, reason: collision with root package name */
    private final d f232220e = new d();

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f232221f = new Bundle();

    /* renamed from: g, reason: collision with root package name */
    private final List<Integer> f232222g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, m.e> f232223h = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    private ShareActionSheet f232225j = null;

    /* renamed from: k, reason: collision with root package name */
    private int f232226k = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.robot.components.share.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class DialogInterfaceOnDismissListenerC7877b implements DialogInterface.OnDismissListener {
        DialogInterfaceOnDismissListenerC7877b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements ShareActionSheet.c {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            b.this.f232225j.dismiss();
            b.this.d();
            int i3 = actionSheetItem.action;
            b.this.f232224i = actionSheetItem;
            b.this.h(i3);
            p.b(view, actionSheetItem);
        }
    }

    public b(@NonNull Activity activity, @NonNull RobotInfo robotInfo) {
        this.f232216a = new WeakReference<>(activity);
        this.f232227l = robotInfo;
    }

    private void e() {
        j.c(this.f232225j);
    }

    private void f(int i3) {
        Activity activity = this.f232216a.get();
        if (activity == null) {
            QLog.e("RobotShareActionSheet", 1, "handleShare activity null");
            QQToast.makeText(activity, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return;
        }
        RobotShareActionExecutor robotShareActionExecutor = new RobotShareActionExecutor(activity, new com.tencent.mobileqq.guild.robot.components.share.d(this.f232227l), this.f232221f);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 23) {
                                if (i3 != 171) {
                                    if (i3 != 197) {
                                        if (i3 != 72) {
                                            if (i3 != 73) {
                                                m.e eVar = this.f232223h.get(Integer.valueOf(i3));
                                                if (eVar != null) {
                                                    eVar.a(i3);
                                                    return;
                                                } else {
                                                    QLog.e("RobotShareActionSheet", 1, "handleShare activity null");
                                                    QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                                                    return;
                                                }
                                            }
                                        } else {
                                            ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f232224i;
                                            robotShareActionExecutor.m(actionSheetItem.uin, actionSheetItem.uinType);
                                            return;
                                        }
                                    }
                                } else {
                                    robotShareActionExecutor.n();
                                    return;
                                }
                            } else {
                                robotShareActionExecutor.f();
                                return;
                            }
                        } else {
                            robotShareActionExecutor.q();
                            return;
                        }
                    } else {
                        robotShareActionExecutor.r();
                        return;
                    }
                } else {
                    robotShareActionExecutor.o();
                    return;
                }
            }
            robotShareActionExecutor.l();
            return;
        }
        robotShareActionExecutor.k();
    }

    public static void g(Activity activity) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
        }
    }

    private void k() {
        Activity activity = this.f232216a.get();
        if (activity == null) {
            QLog.e("RobotShareActionSheet", 1, "showActionSheet(), context null");
            return;
        }
        g(activity);
        this.f232223h.put(1, null);
        this.f232223h.put(23, null);
        ShareActionSheet b16 = new x(activity).g(this.f232223h.keySet()).i(this.f232221f).b();
        this.f232225j = b16;
        b16.setItemClickListenerV3(this.f232217b);
        this.f232225j.setOnDismissListener(this.f232219d);
        this.f232225j.setCancelListener(this.f232218c);
        this.f232225j.setOnShowListener(this.f232220e);
        this.f232225j.show();
        e();
    }

    public void h(int i3) {
        Activity activity = this.f232216a.get();
        this.f232226k = i3;
        if (activity == null) {
            QLog.e("RobotShareActionSheet", 1, "share(), activity is null");
            QQToast.makeText(ch.i(), "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
        } else {
            f(i3);
        }
    }

    public void i() {
        if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("robot_card")) {
            j();
        } else {
            k();
        }
    }

    public void j() {
        Activity activity = this.f232216a.get();
        if (activity != null && !activity.isFinishing()) {
            new com.tencent.mobileqq.guild.robot.components.share.c(activity, this, this.f232227l, this.f232221f).g();
        } else {
            QLog.e("RobotShareActionSheet", 1, "showActionSheet(), context null or activity is finishing");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements DialogInterface.OnShowListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
    }
}
