package com.tencent.mobileqq.colornote.data;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f201398a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f201399b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f201400c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class DialogInterfaceOnClickListenerC7452a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f201401d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f201402e;

        DialogInterfaceOnClickListenerC7452a(QQCustomDialog qQCustomDialog, Context context) {
            this.f201401d = qQCustomDialog;
            this.f201402e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f201401d.isShowing()) {
                this.f201401d.dismiss();
            }
            ColorNoteSmallScreenUtil.r(this.f201402e, true);
        }
    }

    static {
        LinkedList linkedList = new LinkedList();
        f201398a = linkedList;
        f201399b = new ArrayList();
        ArrayList arrayList = new ArrayList();
        f201400c = arrayList;
        linkedList.add("buluo.qq.com");
        linkedList.add("null");
        linkedList.add("unregistered service sub type");
        linkedList.add("captcha.qq.com");
        linkedList.add("oauth.youzan.com");
        linkedList.add("https://zb.vip.qq.com/v2/pages/funcallMall");
        linkedList.add("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2&inviteeUin");
        arrayList.add("https://zb.vip.qq.com/v2/pages/funcallMall");
        arrayList.add("https://ti.qq.com/sportslive/index?_wwv=128&_wv=2&inviteeUin");
    }

    public static boolean A(String str) {
        if (f201399b.size() != 0 && !StringUtil.isEmpty(str)) {
            int i3 = 0;
            while (true) {
                List<String> list = f201399b;
                if (i3 >= list.size()) {
                    break;
                }
                String str2 = list.get(i3);
                if (str2.length() <= str.length() && str.contains(str2)) {
                    return true;
                }
                i3++;
            }
        }
        return false;
    }

    public static String B(List<ColorNote> list) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<ColorNote> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toString());
        }
        return sb5.toString();
    }

    public static void C(Context context, ColorNote colorNote) {
        Intent intent = new Intent(context, (Class<?>) ColorNoteSmallScreenService.class);
        intent.putExtra("key_upcoming_notify", 2);
        intent.putExtra("key_upcoming_color_note", colorNote);
        context.startService(intent);
    }

    public static boolean D(String str, String str2) {
        if ((!StringUtil.isEmpty(str)) ^ (!StringUtil.isEmpty(str2))) {
            return false;
        }
        if (str == null) {
            return true;
        }
        return str.equals(str2);
    }

    public static void E(Context context) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.dismissMessage();
        ((RelativeLayout.LayoutParams) qQCustomDialog.getTitleTextView().getLayoutParams()).bottomMargin = ViewUtils.dip2px(26.0f);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setTitle(context.getString(R.string.img));
        qQCustomDialog.setNegativeButton(context.getString(R.string.imf), new DialogInterfaceOnClickListenerC7452a(qQCustomDialog, context));
        if (qQCustomDialog.isShowing()) {
            qQCustomDialog.dismiss();
        }
        qQCustomDialog.show();
        TextView titleTextView = qQCustomDialog.getTitleTextView();
        titleTextView.setClickable(true);
        titleTextView.setFocusable(true);
        titleTextView.setFocusableInTouchMode(true);
        AccessibilityUtil.n(titleTextView, true);
    }

    public static boolean F(ColorNote colorNote) {
        if (colorNote == null) {
            return false;
        }
        if (StringUtil.isEmpty(colorNote.mMainTitle) && StringUtil.isEmpty(colorNote.mSubTitle)) {
            return false;
        }
        return true;
    }

    public static int a(String str) {
        int i3 = 0;
        if (StringUtil.isEmpty(str)) {
            return 0;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("_wwv");
            if (StringUtil.isEmpty(queryParameter)) {
                return 0;
            }
            long parseLong = Long.parseLong(queryParameter);
            if ((131072 & parseLong) != 0) {
                i3 = 1;
            }
            if ((parseLong & 65536) != 0) {
                return i3 + 2;
            }
            return i3;
        } catch (Exception e16) {
            QLog.e("ColorNoteUtils", 1, "parse long error: ", e16);
            return 0;
        }
    }

    public static void b(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    public static ColorNote c(ColorNote colorNote) {
        if (colorNote == null) {
            return null;
        }
        return new ColorNote.a().g(colorNote.getServiceType() | Integer.MIN_VALUE).i(colorNote.getSubType()).b(colorNote.getExtLong()).c(0).d(colorNote.getMainTitle()).h(BaseApplication.getContext().getString(R.string.brm)).e(colorNote.getPicUrl()).f(colorNote.getReserve()).a();
    }

    public static void d(ColorNote colorNote) {
        boolean z16 = !o(colorNote.mMainTitle);
        if ((!o(colorNote.mSubTitle)) ^ z16) {
            if (z16) {
                colorNote.mSubTitle = colorNote.mMainTitle;
            } else {
                colorNote.mMainTitle = colorNote.mSubTitle;
            }
        }
    }

    public static ColorNote e(ColorNote colorNote) {
        if (colorNote == null) {
            return new ColorNote.a().a();
        }
        return new ColorNote.a().g(colorNote.getServiceType()).i(colorNote.getSubType()).d(colorNote.getMainTitle()).h(colorNote.getSubTitle()).e(colorNote.getPicUrl()).f(colorNote.getReserve()).c(colorNote.mExtra).a();
    }

    public static boolean f(ColorNote colorNote, ColorNote colorNote2) {
        if (colorNote != null && colorNote2 != null) {
            if (colorNote.mServiceType == colorNote2.getServiceType() && D(colorNote.mSubType, colorNote2.getSubType()) && D(colorNote.mMainTitle, colorNote2.getMainTitle()) && D(colorNote.mSubTitle, colorNote2.getSubTitle())) {
                return true;
            }
            return false;
        }
        if (colorNote == null && colorNote2 == null) {
            return true;
        }
        return false;
    }

    public static String g(ColorNote colorNote) {
        if (colorNote == null) {
            return "";
        }
        return colorNote.getMainTitle() + ", " + colorNote.getSubTitle() + ". ";
    }

    public static String h(List<ColorNote> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList(list);
            StringBuilder sb5 = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb5.append(g((ColorNote) it.next()));
            }
            return sb5.toString();
        }
        return "";
    }

    public static int i(int i3) {
        if (i3 != 16908289) {
            if (i3 != 16908292) {
                if (i3 != 17039360) {
                    if (i3 != 17104896) {
                        return 0;
                    }
                    return 2;
                }
                return 1;
            }
            return 4;
        }
        return 3;
    }

    public static ColorNote j(ColorNote colorNote) {
        if (colorNote == null) {
            return null;
        }
        return new ColorNote.a().g(k(colorNote.getServiceType())).b(colorNote.mExtLong).i(colorNote.getSubType()).d(colorNote.getMainTitle()).h(colorNote.getSubTitle()).f(colorNote.getReserve()).a();
    }

    public static int k(int i3) {
        return i3 & Integer.MAX_VALUE;
    }

    public static String l() {
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        sb5.append("");
        sb5.append(stackTrace[2].getClassName());
        sb5.append(".");
        sb5.append(stackTrace[2].getMethodName());
        sb5.append(MsgSummary.STR_COLON);
        sb5.append(stackTrace[2].getLineNumber());
        return sb5.toString();
    }

    public static String m(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        try {
            return new Uri.Builder().scheme(ProtocolDownloaderConstants.PROTOCAL_WEB_COVER).authority(str).build().toString();
        } catch (RuntimeException e16) {
            QLog.e("ColorNoteUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    public static boolean n(List<ColorNote> list) {
        if (list != null && list.size() != 0) {
            Iterator<ColorNote> it = list.iterator();
            while (it.hasNext()) {
                if (u(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean o(String str) {
        if (StringUtil.isEmpty(str)) {
            return true;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(int i3) {
        if ((i3 & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean q(int i3) {
        if ((i3 & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean r(List<ColorNote> list, List<ColorNote> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!list2.contains(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("_wv");
            if (StringUtil.isEmpty(queryParameter)) {
                return false;
            }
            if ((Long.parseLong(queryParameter) & 4096) == 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("ColorNoteUtils", 1, "parse long error: ", e16);
            return false;
        }
    }

    public static boolean t(ColorNote colorNote) {
        if (colorNote == null) {
            return false;
        }
        if (colorNote.getServiceType() != 16973824 && colorNote.getServiceType() != 17367040) {
            return false;
        }
        return true;
    }

    public static boolean u(ColorNote colorNote) {
        if (colorNote == null || !x(colorNote) || (colorNote.mExtLong & 1) != 1) {
            return false;
        }
        return true;
    }

    public static boolean v(List<ColorNote> list) {
        if (list == null || list.size() != 1) {
            return false;
        }
        return t(list.get(0));
    }

    public static boolean w(ColorNote colorNote) {
        if (colorNote == null || (colorNote.getServiceType() & Integer.MIN_VALUE) == 0) {
            return false;
        }
        return true;
    }

    public static boolean x(ColorNote colorNote) {
        if (colorNote.getServiceType() == 17235968) {
            return true;
        }
        return false;
    }

    public static boolean y(String str) {
        List<String> list = f201398a;
        if (list != null && list.size() != 0 && !StringUtil.isEmpty(str)) {
            int i3 = 0;
            while (true) {
                List<String> list2 = f201398a;
                if (i3 >= list2.size()) {
                    break;
                }
                String str2 = list2.get(i3);
                if (str2.length() <= str.length() && str.contains(str2)) {
                    return true;
                }
                i3++;
            }
        }
        return false;
    }

    public static boolean z(String str) {
        if (f201400c.size() != 0 && !StringUtil.isEmpty(str)) {
            int i3 = 0;
            while (true) {
                List<String> list = f201400c;
                if (i3 >= list.size()) {
                    break;
                }
                String str2 = list.get(i3);
                if (str2.length() <= str.length() && str.contains(str2)) {
                    return true;
                }
                i3++;
            }
        }
        return false;
    }
}
