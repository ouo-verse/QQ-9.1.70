package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f235072a;

    /* renamed from: i, reason: collision with root package name */
    private ShareActionSheetBuilder.ActionSheetItem f235080i;

    /* renamed from: k, reason: collision with root package name */
    private a f235082k;

    /* renamed from: m, reason: collision with root package name */
    private GuildMiniAppShareData f235084m;

    /* renamed from: n, reason: collision with root package name */
    private w f235085n;

    /* renamed from: o, reason: collision with root package name */
    private Bundle f235086o;

    /* renamed from: b, reason: collision with root package name */
    private final e f235073b = new e();

    /* renamed from: c, reason: collision with root package name */
    private final b f235074c = new b();

    /* renamed from: d, reason: collision with root package name */
    private final c f235075d = new c();

    /* renamed from: e, reason: collision with root package name */
    private final f f235076e = new f();

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f235077f = new Bundle();

    /* renamed from: g, reason: collision with root package name */
    private final List<Integer> f235078g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final Map<Integer, d> f235079h = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    private ShareActionSheet f235081j = null;

    /* renamed from: l, reason: collision with root package name */
    private GuildSharePageSource f235083l = GuildSharePageSource.MINI_APP_CHANNEL;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            o.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            o.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements ShareActionSheet.c {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3 = actionSheetItem.action;
            o.this.f235080i = actionSheetItem;
            o.this.i(i3);
        }
    }

    public o(@NonNull Activity activity, @NonNull GuildMiniAppShareData guildMiniAppShareData) {
        this.f235072a = new WeakReference<>(activity);
        this.f235084m = guildMiniAppShareData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f235082k;
        if (aVar != null) {
            aVar.b();
        }
        this.f235082k = null;
    }

    private void d() {
        a aVar = this.f235082k;
        if (aVar != null) {
            aVar.a();
        }
        com.tencent.mobileqq.guild.safety.j.c(this.f235081j);
    }

    private static void e(@NonNull IGProSecurityResult iGProSecurityResult, Context context) {
        if (iGProSecurityResult.get$actionCode() == 102) {
            try {
                cx.a(context, new JSONObject(iGProSecurityResult.getStrDetail()).optString("verify_url"));
                return;
            } catch (Exception e16) {
                QLog.e("Guild.share.GuildShareActionSheetForMini", 1, e16, new Object[0]);
                return;
            }
        }
        QQToast.makeText(context, 1, iGProSecurityResult.getStrPrompt(), 1).show();
    }

    private void f(int i3) {
        Activity activity = this.f235072a.get();
        if (activity != null && this.f235084m != null) {
            this.f235081j.dismiss();
            c();
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 72) {
                                    if (i3 != 73) {
                                        if (i3 != 171) {
                                            if (i3 != 197) {
                                                d dVar = this.f235079h.get(Integer.valueOf(i3));
                                                if (dVar != null) {
                                                    dVar.a(i3);
                                                    return;
                                                } else {
                                                    QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "handleShare activity null");
                                                    QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                                                    return;
                                                }
                                            }
                                        } else {
                                            this.f235085n.t();
                                            return;
                                        }
                                    }
                                } else {
                                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f235080i;
                                    this.f235085n.s(actionSheetItem.uin, actionSheetItem.uinType);
                                    return;
                                }
                            } else {
                                this.f235085n.w();
                                return;
                            }
                        } else {
                            this.f235085n.x();
                            return;
                        }
                    } else {
                        this.f235085n.u();
                        return;
                    }
                }
                this.f235085n.q();
                return;
            }
            this.f235085n.p();
            return;
        }
        QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "handleShare activity null");
        QQToast.makeText(activity, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
    }

    private static void g(Activity activity) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
        }
    }

    public void h(a aVar) {
        this.f235082k = aVar;
    }

    public void i(int i3) {
        Activity activity = this.f235072a.get();
        if (activity == null) {
            QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "share(), activity is null");
            QQToast.makeText(ch.i(), "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return;
        }
        GuildMiniAppShareData guildMiniAppShareData = this.f235084m;
        if (guildMiniAppShareData == null) {
            QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "share(), mData == null");
            QQToast.makeText(ch.i(), "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return;
        }
        int i16 = guildMiniAppShareData.fetchShareInfoErrorCode;
        if (i16 == -200 && guildMiniAppShareData.fetchShareInfoErrorWhat != null) {
            QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "share(), security error");
            e(this.f235084m.fetchShareInfoErrorWhat, activity);
        } else {
            if (i16 != 0) {
                QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "share(), errorCode:" + this.f235084m.fetchShareInfoErrorCode);
                GuildMiniAppShareData guildMiniAppShareData2 = this.f235084m;
                ch.q1(activity, guildMiniAppShareData2.fetchShareInfoErrorCode, guildMiniAppShareData2.fetchShareInfoErrorMessage);
                return;
            }
            f(i3);
        }
    }

    public void j() {
        if (!ch.C0(this.f235084m.creatorId)) {
            QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "CreatorId \u4e0d\u5408\u6cd5: " + this.f235084m.creatorId);
            QQToast.makeText(ch.i(), "\u6570\u636e\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return;
        }
        Activity activity = this.f235072a.get();
        if (activity == null) {
            QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "showActionSheet(), context null");
            return;
        }
        if (this.f235084m.shareUrlInfo == null) {
            QLog.e("Guild.share.GuildShareActionSheetForMini", 1, "showActionSheet(), mData.shareUrlInfo is null");
            return;
        }
        GuildMiniAppShareData guildMiniAppShareData = this.f235084m;
        w wVar = new w(activity, new k02.e(guildMiniAppShareData, guildMiniAppShareData.shareUrlInfo, guildMiniAppShareData.creatorName), this.f235083l);
        this.f235085n = wVar;
        this.f235086o = wVar.g().getExtras();
        g(activity);
        ShareActionSheet b16 = new x(activity).g(this.f235079h.keySet()).i(this.f235077f).h(this.f235078g).b();
        this.f235081j = b16;
        b16.setExtras(this.f235086o);
        this.f235081j.setItemClickListenerV3(this.f235073b);
        this.f235081j.setOnDismissListener(this.f235075d);
        this.f235081j.setCancelListener(this.f235074c);
        this.f235081j.setOnShowListener(this.f235076e);
        this.f235081j.show();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements DialogInterface.OnShowListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }
}
