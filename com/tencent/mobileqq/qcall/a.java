package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qcall.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8278a implements ActionSheet.OnDismissListener {
        static IPatchRedirector $redirector_;

        C8278a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f261547d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int[] f261548e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f261549f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f261550h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f261551i;

        b(ActionSheet actionSheet, int[] iArr, String str, Context context, QQAppInterface qQAppInterface) {
            this.f261547d = actionSheet;
            this.f261548e = iArr;
            this.f261549f = str;
            this.f261550h = context;
            this.f261551i = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, actionSheet, iArr, str, context, qQAppInterface);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            this.f261547d.dismiss();
            if (this.f261548e[i3] == 1) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f261549f));
                if (!wy2.d.f446751a && wy2.c.d().f()) {
                    wy2.c.d().h(intent);
                }
                this.f261550h.startActivity(intent);
                f callFacade = this.f261551i.getCallFacade();
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                String str = this.f261549f;
                callFacade.F(str, 26, -1, K0, str);
            }
        }
    }

    public static void a(QQAppInterface qQAppInterface, Context context, String str) {
        QLog.d("OpenSDKUtils", 2, "enterActionSheet phoneNumber = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int[] iArr = {1};
        ActionSheet create = ActionSheet.create(context);
        iArr[0] = 1;
        create.addButton(R.string.f170661xq);
        create.addCancelButton(R.string.cancel);
        create.setOnDismissListener(new C8278a());
        create.setOnButtonClickListener(new b(create, iArr, str, context, qQAppInterface));
        create.show();
    }

    public static String b(String str) {
        com.tencent.mobileqq.phone.a b16 = com.tencent.mobileqq.phone.b.b(str);
        if (b16.f258337a.equals("86")) {
            return b16.f258339c;
        }
        return str;
    }

    public static String c(QQAppInterface qQAppInterface, String str) {
        String str2;
        String str3;
        String str4;
        QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName phoneNumber = " + str);
        if (qQAppInterface != null && str != null && str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            PhoneContact g16 = g(qQAppInterface, str);
            String str5 = null;
            if (g16 != null) {
                str3 = g16.name;
                str2 = g16.uin;
            } else {
                str2 = null;
                str3 = null;
            }
            QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName contactName = " + str3 + "uin = " + str2);
            if (!TextUtils.isEmpty(str2) && !str2.equals("0")) {
                Friends v3 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).v(str2);
                if (v3 != null) {
                    String str6 = v3.remark;
                    if (str6 != null && str6.length() > 0) {
                        str4 = v3.remark;
                    } else if (v3.name != null && v3.name.length() > 0) {
                        str4 = v3.name;
                    }
                    str5 = str4;
                }
                QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName FriendDisplayName = " + str5);
            }
            if (!TextUtils.isEmpty(str5)) {
                str3 = str5;
            }
            if (TextUtils.isEmpty(str3)) {
                return b(str);
            }
            return str3;
        }
        return "";
    }

    public static Bitmap d(QQAppInterface qQAppInterface, String str) {
        QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + str);
        Bitmap bitmap = null;
        if (qQAppInterface == null || str == null || !str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            return null;
        }
        if (f(qQAppInterface, str)) {
            bitmap = qQAppInterface.getFaceBitmap(11, str, (byte) 3, true, 0);
        }
        if (bitmap == null) {
            return BaseImageUtil.getDefaultFaceBitmap();
        }
        return bitmap;
    }

    public static Drawable e(QQAppInterface qQAppInterface, String str) {
        QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + str);
        FaceDrawable faceDrawable = null;
        if (qQAppInterface == null || str == null || !str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            return null;
        }
        if (f(qQAppInterface, str)) {
            faceDrawable = FaceDrawable.getMobileFaceDrawable(qQAppInterface, str, (byte) 3);
        }
        if (faceDrawable == null) {
            return BaseImageUtil.getDefaultFaceDrawable();
        }
        return faceDrawable;
    }

    public static boolean f(QQAppInterface qQAppInterface, String str) {
        PhoneContact phoneContact;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null) {
            phoneContact = iPhoneContactService.queryContactByCodeNumber(str);
        } else {
            phoneContact = null;
        }
        if (phoneContact != null && !TextUtils.isEmpty(phoneContact.uin)) {
            return true;
        }
        return false;
    }

    public static PhoneContact g(QQAppInterface qQAppInterface, String str) {
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null) {
            PhoneContact queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(str);
            com.tencent.mobileqq.phone.a b16 = com.tencent.mobileqq.phone.b.b(str);
            if (queryContactByCodeNumber == null) {
                queryContactByCodeNumber = iPhoneContactService.queryPhoneContactByMobile(b16.f258339c);
            }
            if (queryContactByCodeNumber == null) {
                queryContactByCodeNumber = iPhoneContactService.queryPhoneContactByMobile(Marker.ANY_NON_NULL_MARKER + b16.f258337a + b16.f258339c);
            }
            if (queryContactByCodeNumber == null) {
                queryContactByCodeNumber = iPhoneContactService.queryPhoneContactByMobile(b16.f258337a + b16.f258339c);
            }
            if (queryContactByCodeNumber == null) {
                queryContactByCodeNumber = iPhoneContactService.queryPhoneContactByMobile("00" + b16.f258337a + b16.f258339c);
            }
            if (queryContactByCodeNumber == null) {
                return iPhoneContactService.queryPhoneContactByMobile(b16.f258337a + "-" + b16.f258339c);
            }
            return queryContactByCodeNumber;
        }
        return null;
    }
}
