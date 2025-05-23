package m02;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.share.p;
import com.tencent.mobileqq.guild.util.ap;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f415940a;

    /* renamed from: b, reason: collision with root package name */
    private String f415941b;

    /* renamed from: c, reason: collision with root package name */
    private GuildSharePageSource f415942c;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f415943d;

    /* renamed from: e, reason: collision with root package name */
    private final b f415944e;

    /* renamed from: f, reason: collision with root package name */
    private QQPermission f415945f;

    /* renamed from: g, reason: collision with root package name */
    private String f415946g;

    /* renamed from: h, reason: collision with root package name */
    private String f415947h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            m.this.I();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            m.this.B(-105);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void onFinished(int i3);
    }

    public m(Activity activity, b bVar) {
        this.f415943d = activity;
        this.f415944e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(View view, final ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        StringBuilder sb5;
        boolean isColorLevel;
        try {
            try {
            } catch (OutOfMemoryError unused) {
                ch.d1(1, R.string.f1518518t);
                B(-102);
                E(view, actionSheetItem);
                shareActionSheet.dismiss();
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder();
                } else {
                    return;
                }
            }
            if (actionSheetItem.action != 39 && !NetworkUtil.isNetworkAvailable()) {
                ch.d1(1, R.string.f156721kz);
                B(-106);
                if (isColorLevel) {
                    return;
                } else {
                    return;
                }
            }
            ThreadManagerV2.excute(new Runnable() { // from class: m02.j
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.x(actionSheetItem);
                }
            }, 64, null, true);
            E(view, actionSheetItem);
            shareActionSheet.dismiss();
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("onActionItemClick item = ");
                sb5.append(actionSheetItem.action);
                QLog.d("Guild.share.GuildSharePicActionSheetHelperV2", 2, sb5.toString());
            }
        } finally {
            E(view, actionSheetItem);
            shareActionSheet.dismiss();
            if (QLog.isColorLevel()) {
                QLog.d("Guild.share.GuildSharePicActionSheetHelperV2", 2, "onActionItemClick item = " + actionSheetItem.action);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3) {
        b bVar = this.f415944e;
        if (bVar != null) {
            bVar.onFinished(i3);
        }
    }

    private void C(int i3, ShareActionSheet shareActionSheet) {
        G(shareActionSheet);
        B(i3);
    }

    private void D(ShareActionSheet shareActionSheet) {
        F(shareActionSheet);
    }

    private void E(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        p.b(view, actionSheetItem);
    }

    private void F(ShareActionSheet shareActionSheet) {
        p.e(this.f415943d, shareActionSheet, this.f415941b, this.f415942c);
    }

    private void G(ShareActionSheet shareActionSheet) {
        p.f(this.f415943d, shareActionSheet, this.f415941b, this.f415942c);
    }

    private String H() {
        String str = "temp_guild_share_" + System.currentTimeMillis() + ".png";
        File file = new File(VFSAssistantUtils.getSDKPrivatePath("cache/"));
        file.mkdirs();
        if (file.canWrite()) {
            String str2 = file + "/" + str;
            if (ap.d(str2, this.f415940a)) {
                return str2;
            }
        }
        B(-103);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        ThreadManagerV2.excute(new Runnable() { // from class: m02.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.z();
            }
        }, 64, null, true);
    }

    private void J() {
        if (this.f415945f == null) {
            this.f415945f = QQPermissionFactory.getQQPermission(this.f415943d, new BusinessConfig(this.f415946g, this.f415947h));
        }
        QQPermission qQPermission = this.f415945f;
        if (qQPermission == null) {
            QQToastUtil.showQQToast(1, R.string.f155091gk);
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            this.f415945f.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a());
        } else {
            I();
        }
    }

    private void k(ShareActionSheet shareActionSheet) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1);
        shareActionSheet.setIntentForStartForwardRecentActivity(intent);
    }

    private void l(final ShareActionSheet shareActionSheet) {
        shareActionSheet.setItemClickListenerV3(new ShareActionSheet.c() { // from class: m02.f
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
            public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet2) {
                m.this.A(view, actionSheetItem, shareActionSheet2);
            }
        });
        shareActionSheet.setOnShowListener(new DialogInterface.OnShowListener() { // from class: m02.g
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                m.this.t(shareActionSheet, dialogInterface);
            }
        });
        shareActionSheet.setCancelListener(new DialogInterface.OnCancelListener() { // from class: m02.h
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                m.this.u(shareActionSheet, dialogInterface);
            }
        });
        shareActionSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: m02.i
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                m.this.v(shareActionSheet, dialogInterface);
            }
        });
    }

    private void m(ShareActionSheet shareActionSheet) {
        shareActionSheet.setRowVisibility(0, 0, 0);
        shareActionSheet.setActionSheetItems(q(), r());
    }

    private void n(File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.parse("file://" + file.getAbsolutePath()));
        BaseApplication.getContext().sendBroadcast(intent);
    }

    private File o() {
        String l3 = Long.toString(System.currentTimeMillis());
        File file = new File(AppConstants.SDCARD_IMG_SAVE + "qq_guild_" + l3 + ".jpg");
        int i3 = 2;
        while (file.exists() && i3 < Integer.MAX_VALUE) {
            i3++;
            file = new File(AppConstants.SDCARD_IMG_SAVE + "qq_guild_" + l3 + "(" + i3 + ").jpg");
        }
        return file;
    }

    private ShareActionSheetV2.Param p() {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        this.f415943d.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
        param.canceledOnTouchOutside = true;
        param.context = this.f415943d;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        return param;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        if (d.i()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        }
        return arrayList;
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void w(String str, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        Activity activity = this.f415943d;
        if (activity != null && !activity.isFinishing()) {
            if (TextUtils.isEmpty(str)) {
                ch.d1(1, R.string.f1518518t);
                B(-104);
                return;
            }
            int i3 = actionSheetItem.action;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 39) {
                                if (i3 != 171) {
                                    if (i3 == 72 || i3 == 73) {
                                        d.g(this.f415943d, str, actionSheetItem);
                                    }
                                } else {
                                    d.o(this.f415943d, str);
                                }
                            } else {
                                J();
                            }
                        } else {
                            d.r(str, this.f415940a);
                        }
                    } else {
                        d.q(str, this.f415940a);
                    }
                } else {
                    d.u(this.f415943d, str);
                }
            } else {
                d.m(this.f415943d, str, false);
            }
            int i16 = actionSheetItem.action;
            if (i16 != 39) {
                B(i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ShareActionSheet shareActionSheet, DialogInterface dialogInterface) {
        D(shareActionSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(ShareActionSheet shareActionSheet, DialogInterface dialogInterface) {
        C(-100, shareActionSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(ShareActionSheet shareActionSheet, DialogInterface dialogInterface) {
        C(-101, shareActionSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(final ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        final String H = H();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: m02.k
            @Override // java.lang.Runnable
            public final void run() {
                m.this.w(H, actionSheetItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(boolean z16, File file) {
        if (z16) {
            n(file);
            B(39);
            ch.d1(2, R.string.f1518318r);
        } else {
            B(-105);
            ch.d1(1, R.string.f1518218q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        final File o16 = o();
        final boolean c16 = ap.c(o16, this.f415940a);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: m02.e
            @Override // java.lang.Runnable
            public final void run() {
                m.this.y(c16, o16);
            }
        });
    }

    public void K(Bitmap bitmap, String str, GuildSharePageSource guildSharePageSource, String str2, String str3) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f415946g = str2;
            this.f415947h = str3;
            this.f415940a = bitmap;
            this.f415941b = str;
            this.f415942c = guildSharePageSource;
            ShareActionSheet create = ShareActionSheetFactory.create(p());
            k(create);
            m(create);
            l(create);
            create.show();
            return;
        }
        ch.d1(1, R.string.f1518218q);
    }
}
