package l02;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.share.p;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f413577a;

    /* renamed from: e, reason: collision with root package name */
    private final String f413581e;

    /* renamed from: f, reason: collision with root package name */
    private final String f413582f;

    /* renamed from: g, reason: collision with root package name */
    private ShareActionSheetBuilder.ActionSheetItem f413583g;

    /* renamed from: b, reason: collision with root package name */
    private final C10697b f413578b = new C10697b();

    /* renamed from: c, reason: collision with root package name */
    private final c f413579c = new c();

    /* renamed from: d, reason: collision with root package name */
    private final a f413580d = new a();

    /* renamed from: h, reason: collision with root package name */
    private ShareActionSheet f413584h = null;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class a implements DialogInterface.OnDismissListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            p.f((Activity) b.this.f413577a.get(), b.this.f413584h, b.this.f413582f, GuildSharePageSource.LIVE_CHANNEL);
        }
    }

    /* compiled from: P */
    /* renamed from: l02.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private class C10697b implements ShareActionSheet.c {
        C10697b() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            b.this.f413584h.dismiss();
            b.this.f413583g = actionSheetItem;
            b.this.g(actionSheetItem.action);
            p.b(view, actionSheetItem);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class c implements DialogInterface.OnShowListener {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            p.e((Activity) b.this.f413577a.get(), b.this.f413584h, b.this.f413582f, GuildSharePageSource.LIVE_CHANNEL);
        }
    }

    public b(@NonNull Activity activity, @NonNull String str, String str2) {
        this.f413577a = new WeakReference<>(activity);
        this.f413581e = str;
        this.f413582f = str2;
    }

    private void e(int i3) {
        String str;
        Activity activity = this.f413577a.get();
        int i16 = 0;
        if (activity == null) {
            QLog.e("Guild.share.GuildShareAction", 1, "handleShare activity null");
            QQToast.makeText(activity, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return;
        }
        l02.a aVar = new l02.a(activity, this.f413581e);
        if (i3 != 2) {
            if (i3 != 9) {
                if (i3 != 26) {
                    if (i3 != 72) {
                        if (i3 != 73) {
                            QLog.e("Guild.share.GuildShareAction", 1, "handleShare activity null");
                            QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                            return;
                        }
                    } else {
                        ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f413583g;
                        aVar.b(actionSheetItem.uin, actionSheetItem.uinType);
                        return;
                    }
                } else {
                    BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) ch.l();
                    boolean p16 = h.p(baseQQAppInterface);
                    if (p16) {
                        str = h.g(baseQQAppInterface);
                    } else {
                        str = AppConstants.DATALINE_PC_UIN;
                    }
                    if (!p16) {
                        i16 = 6000;
                    }
                    aVar.b(str, i16);
                    return;
                }
            } else {
                aVar.c();
                return;
            }
        }
        aVar.a();
    }

    private static void f(Activity activity) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
        }
    }

    public void g(int i3) {
        if (this.f413577a.get() == null) {
            QLog.e("Guild.share.GuildShareAction", 1, "share(), context is null");
            QQToast.makeText(ch.i(), "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
        } else {
            e(i3);
        }
    }

    public void h() {
        Activity activity = this.f413577a.get();
        if (activity == null) {
            QLog.e("Guild.share.GuildShareAction", 1, "showActionSheet(), context null");
            return;
        }
        f(activity);
        ShareActionSheet a16 = new l02.c(activity).a();
        this.f413584h = a16;
        a16.setItemClickListenerV3(this.f413578b);
        this.f413584h.setOnShowListener(this.f413579c);
        this.f413584h.setOnDismissListener(this.f413580d);
        this.f413584h.show();
    }
}
