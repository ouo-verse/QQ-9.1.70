package ay;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import ff0.a;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f27198a = a.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f27199b;

    /* renamed from: c, reason: collision with root package name */
    private Context f27200c;

    /* renamed from: d, reason: collision with root package name */
    private PublicAccountDetailImpl f27201d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ay.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class ViewOnClickListenerC0075a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f27202d;

        ViewOnClickListenerC0075a(Dialog dialog) {
            this.f27202d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog dialog = this.f27202d;
            if (dialog == null || !dialog.isShowing() || this.f27202d.getWindow() == null) {
                return;
            }
            this.f27202d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f27204d;

        b(String str) {
            this.f27204d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f27200c.startActivity(new Intent("android.intent.action.CALL", Uri.parse(WebView.SCHEME_TEL + this.f27204d)));
        }
    }

    public a(QQAppInterface qQAppInterface, Context context, PublicAccountDetailImpl publicAccountDetailImpl) {
        this.f27199b = qQAppInterface;
        this.f27200c = context;
        this.f27201d = publicAccountDetailImpl;
    }

    private a.b b() {
        if (this.f27201d == null) {
            return null;
        }
        PublicAccountDetailImpl publicAccountDetailImpl = this.f27201d;
        return new a.b(publicAccountDetailImpl.uin, publicAccountDetailImpl.name, publicAccountDetailImpl.summary);
    }

    private String c() {
        int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(this.f27201d.accountFlag);
        if (accountType != -2 && accountType != -5) {
            return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.f27201d.uin;
        }
        return "https://share.mp.qq.com/cgi/share.php?uin=" + this.f27201d.uin + "&account_flag=" + this.f27201d.accountFlag + "&jumptype=1&card_type=public_account";
    }

    private void g() {
        if (this.f27201d == null) {
            return;
        }
        new ff0.a(this.f27199b, (BaseActivity) this.f27200c, b(), 1, c()).i();
    }

    private void h(String str) {
        Dialog dialog = new Dialog(this.f27200c, R.style.qZoneInputDialog);
        dialog.setContentView(R.layout.atf);
        ((TextView) dialog.findViewById(R.id.bkh)).setVisibility(8);
        TextView textView = (TextView) dialog.findViewById(R.id.bk8);
        TextView textView2 = (TextView) dialog.findViewById(R.id.bk5);
        TextView textView3 = (TextView) dialog.findViewById(R.id.bka);
        textView.setText(str);
        textView.setGravity(3);
        textView2.setText(R.string.cancel);
        textView3.setText(R.string.ano);
        dialog.setCanceledOnTouchOutside(false);
        textView2.setOnClickListener(new ViewOnClickListenerC0075a(dialog));
        textView3.setOnClickListener(new b(str));
        try {
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public void d(IPublicAccountConfigAttr.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f27198a, 2, "handleItemClickEvent->type:" + aVar.f79329a + ", event_id:" + aVar.f79333e);
        }
        int i3 = aVar.f79329a;
        if (i3 == 1) {
            e(aVar.f79336h);
            return;
        }
        if (i3 == 3) {
            int i16 = aVar.f79333e;
            if (i16 == 7) {
                if (TextUtils.isEmpty(aVar.f79341m) || TextUtils.isEmpty(aVar.f79340l)) {
                    return;
                }
                Intent intent = new Intent(this.f27200c, (Class<?>) QQMapActivity.class);
                intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, aVar.f79341m);
                intent.putExtra("lon", aVar.f79340l);
                if (!TextUtils.isEmpty(aVar.f79331c)) {
                    intent.putExtra("loc", aVar.f79331c);
                }
                this.f27200c.startActivity(intent);
                return;
            }
            if (i16 == 8) {
                String str = aVar.f79342n;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String trim = str.trim();
                if (Pattern.compile("[\\d-]+?").matcher(trim).matches()) {
                    h(trim);
                    return;
                }
                return;
            }
            if (i16 == 11) {
                Intent intent2 = new Intent();
                intent2.putExtra("from", this.f27200c.getClass().getName());
                RouteUtils.startActivity(this.f27200c, intent2, "/qrscan/scanner");
                return;
            }
            if (i16 == 20) {
                g();
                return;
            }
            if (i16 == 2) {
                BaseActivity baseActivity = (BaseActivity) this.f27200c;
                PublicAccountDetailImpl publicAccountDetailImpl = this.f27201d;
                ff0.a.d(baseActivity, new a.b(publicAccountDetailImpl.uin, publicAccountDetailImpl.name, publicAccountDetailImpl.summary), 1, c());
                return;
            }
            if (i16 == 17) {
                BaseActivity baseActivity2 = (BaseActivity) this.f27200c;
                PublicAccountDetailImpl publicAccountDetailImpl2 = this.f27201d;
                ff0.a.f(baseActivity2, new a.b(publicAccountDetailImpl2.uin, publicAccountDetailImpl2.name, publicAccountDetailImpl2.summary), 1, c());
                return;
            }
            if (i16 == 19) {
                BaseActivity baseActivity3 = (BaseActivity) this.f27200c;
                PublicAccountDetailImpl publicAccountDetailImpl3 = this.f27201d;
                ff0.a.h(baseActivity3, new a.b(publicAccountDetailImpl3.uin, publicAccountDetailImpl3.name, publicAccountDetailImpl3.summary), 1, c(), 9);
                return;
            }
            if (i16 == 18) {
                BaseActivity baseActivity4 = (BaseActivity) this.f27200c;
                PublicAccountDetailImpl publicAccountDetailImpl4 = this.f27201d;
                ff0.a.h(baseActivity4, new a.b(publicAccountDetailImpl4.uin, publicAccountDetailImpl4.name, publicAccountDetailImpl4.summary), 1, c(), 10);
                return;
            }
            if (i16 == 22) {
                e(aVar.f79336h);
                return;
            }
            if (i16 == 23) {
                if (TextUtils.isEmpty(aVar.f79331c)) {
                    return;
                }
                zx.b bVar = new zx.b();
                bVar.b(aVar.f79331c);
                f(bVar);
                return;
            }
            if (i16 != 1 && i16 != 3 && i16 != 9 && i16 != 10 && i16 != 12 && i16 != 13 && i16 != 14 && i16 != 15 && i16 != 16 && i16 != 21) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f27198a, 2, "handleItemClickEvent->event unhandled!");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(this.f27198a, 2, "handleItemClickEvent->event forbidden or not supported!");
            }
        }
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(this.f27200c, (Class<?>) PublicAccountBrowserImpl.class);
        QQAppInterface qQAppInterface = this.f27199b;
        if (qQAppInterface == null || this.f27201d == null || TextUtils.isEmpty(qQAppInterface.getAccount()) || TextUtils.isEmpty(this.f27201d.uin)) {
            return;
        }
        String replace = str.replace("${puin}", this.f27201d.uin).replace("${uin}", this.f27199b.getAccount());
        intent.putExtra("uin", this.f27199b.getCurrentAccountUin());
        intent.putExtra("url", replace);
        if (QLog.isColorLevel()) {
            QLog.d(this.f27198a, 2, "jumpWebView->url:" + replace);
        }
        intent.putExtra(IPublicAccountBrowser.KEY_PUB_UIN, this.f27201d.uin);
        intent.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(this.f27201d.uin));
        String str2 = this.f27201d.name;
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("source_name", str2);
        }
        this.f27200c.startActivity(intent);
    }

    public void f(zx.b bVar) {
        QQAppInterface qQAppInterface = this.f27199b;
        if (qQAppInterface != null && qQAppInterface.isVideoChatting()) {
            QQToast.makeText(this.f27200c, R.string.dkm, 1).show(this.f27200c.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f27198a, 2, "open full play activity, articleID : " + bVar.f453630d.f453634a + ",vid : " + bVar.f453632f.f453651g);
        }
    }
}
