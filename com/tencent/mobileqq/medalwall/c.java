package com.tencent.mobileqq.medalwall;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static final String f245767k;

    /* renamed from: a, reason: collision with root package name */
    ShareActionSheet f245768a;

    /* renamed from: b, reason: collision with root package name */
    Context f245769b;

    /* renamed from: c, reason: collision with root package name */
    QQAppInterface f245770c;

    /* renamed from: d, reason: collision with root package name */
    public String f245771d;

    /* renamed from: e, reason: collision with root package name */
    public String f245772e;

    /* renamed from: f, reason: collision with root package name */
    public String f245773f;

    /* renamed from: g, reason: collision with root package name */
    public String f245774g;

    /* renamed from: h, reason: collision with root package name */
    public String f245775h;

    /* renamed from: i, reason: collision with root package name */
    public Bitmap f245776i;

    /* renamed from: j, reason: collision with root package name */
    public String f245777j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            if (c.this.f245768a.isShowing()) {
                c.this.f245768a.dismiss();
            }
            int i16 = actionSheetItem.action;
            if (i16 == 9 || i16 == 10) {
                if (!WXShareHelper.b0().e0()) {
                    i3 = R.string.f173257ih1;
                } else if (!WXShareHelper.b0().f0()) {
                    i3 = R.string.f173258ih2;
                } else {
                    i3 = -1;
                }
                if (i3 != -1) {
                    h.T(1, i3);
                    return;
                }
            }
            if (i16 == 2) {
                c.this.m();
                return;
            }
            if (i16 == 3) {
                c.this.n();
            } else if (i16 == 9) {
                c.this.p();
            } else if (i16 == 10) {
                c.this.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f245779d;

        b(DialogInterface.OnDismissListener onDismissListener) {
            this.f245779d = onDismissListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) onDismissListener);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            DialogInterface.OnDismissListener onDismissListener = this.f245779d;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73036);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f245767k = HardCodeUtil.qqStr(R.string.te9);
        }
    }

    public c(Context context, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) qQAppInterface);
            return;
        }
        this.f245768a = null;
        this.f245777j = "";
        this.f245769b = context;
        this.f245770c = qQAppInterface;
    }

    private boolean e() {
        if (!TextUtils.isEmpty(this.f245771d) && !TextUtils.isEmpty(this.f245772e) && !TextUtils.isEmpty(this.f245773f) && !TextUtils.isEmpty(this.f245775h)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap f(Drawable drawable, int i3, int i16) {
        Bitmap createBitmap;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        try {
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ShareHelper", 2, e16.getMessage(), e16);
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            bitmap = createBitmap;
            if (bitmap != null) {
                Canvas canvas = new Canvas(bitmap);
                Rect copyBounds = drawable.copyBounds();
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                drawable.setBounds(copyBounds);
            }
            return bitmap;
        }
        createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        bitmap = createBitmap;
        if (bitmap != null) {
        }
        return bitmap;
    }

    public static String g(String[] strArr) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr[i3] = i(strArr[i3]);
        }
        return h(strArr);
    }

    private static String h(String[] strArr) {
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (int i16 = 0; i16 < strArr.length; i16++) {
            if (strArr[i16].length() > i3) {
                i3 = strArr[i16].length();
            }
        }
        for (int i17 = 0; i17 < i3; i17++) {
            for (int i18 = 0; i18 < strArr.length; i18++) {
                if (strArr[i18].length() > i17) {
                    sb5.append(strArr[i18].charAt(i17));
                }
            }
        }
        return i(sb5.toString());
    }

    private static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(Base64.encodeToString(str.getBytes(), 3).replace(ContainerUtils.KEY_VALUE_DELIMITER, ""));
        char charAt = sb5.charAt(0);
        sb5.deleteCharAt(0);
        sb5.append(charAt);
        if (QLog.isColorLevel()) {
            QLog.i("ShareHelper", 4, "encodeOne src:" + Base64.encodeToString(str.getBytes(), 0) + " dst:" + sb5.toString());
        }
        return sb5.toString();
    }

    private List<ShareActionSheetBuilder.ActionSheetItem>[] j(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        return new ArrayList[]{arrayList};
    }

    public static String k(Long l3) {
        if (l3 == null) {
            return null;
        }
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(114).d(this.f245772e).j(this.f245771d).a();
        a16.mSourceName = this.f245775h;
        a16.mSourceAction = "web";
        a16.mSourceUrl = this.f245777j;
        com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(2);
        c16.o(this.f245774g, this.f245772e, this.f245773f);
        a16.addItem(c16);
        Intent intent = new Intent();
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        intent.putExtra("forwardDirect", true);
        ForwardBaseOption.startForwardActivityForResult((Activity) this.f245769b, intent, 21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(this.f245774g)) {
            arrayList.add(this.f245774g);
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", this.f245772e);
        bundle.putString("desc", this.f245773f);
        bundle.putLong("req_share_id", 0L);
        bundle.putString("detail_url", this.f245771d);
        bundle.putString("url", this.f245771d);
        bundle.putStringArrayList("image_url", arrayList);
        QZoneShareManager.jumpToQzoneShare(this.f245770c, this.f245769b, bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        WXShareHelper.b0().N0(String.valueOf(System.currentTimeMillis()), this.f245772e, this.f245776i, this.f245773f, this.f245771d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), this.f245772e, this.f245776i, this.f245773f, this.f245771d);
    }

    public void l(String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, bitmap);
            return;
        }
        this.f245771d = str3;
        this.f245772e = str;
        this.f245773f = str2;
        this.f245774g = str4;
        this.f245775h = str5;
        this.f245776i = bitmap;
    }

    public void q(DialogInterface.OnDismissListener onDismissListener) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onDismissListener);
            return;
        }
        if (!e()) {
            QQToast.makeText(this.f245769b, HardCodeUtil.qqStr(R.string.te_), 0).show();
            return;
        }
        if (this.f245768a == null) {
            a aVar = new a();
            b bVar = new b(onDismissListener);
            Context context = this.f245769b;
            if (context != null && (context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null && TextUtils.isEmpty(intent.getStringExtra("big_brother_source_key"))) {
                intent.putExtra("big_brother_source_key", "biz_src_unknown");
            }
            ShareActionSheet create = ShareActionSheetFactory.create((Activity) this.f245769b, false);
            this.f245768a = create;
            create.setActionSheetTitle(HardCodeUtil.qqStr(R.string.hja));
            this.f245768a.setActionSheetItems(j(this.f245769b));
            this.f245768a.setItemClickListenerV2(aVar);
            this.f245768a.setOnDismissListener(bVar);
        }
        try {
            if (!this.f245768a.isShowing()) {
                this.f245768a.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + e16);
            }
        }
    }
}
