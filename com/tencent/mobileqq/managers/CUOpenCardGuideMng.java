package com.tencent.mobileqq.managers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.qqmc.EntryItem;
import com.tencent.mobileqq.vas.qqmc.QQUnicomCardGuideConfig;
import com.tencent.mobileqq.vip.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import java.util.ArrayList;
import java.util.Locale;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CUOpenCardGuideMng implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final a f243616d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class CUOpenCardClickableSpan extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final Context f243617d;

        /* renamed from: e, reason: collision with root package name */
        final String f243618e;

        /* renamed from: f, reason: collision with root package name */
        final String f243619f;

        /* renamed from: h, reason: collision with root package name */
        final int f243620h;

        /* renamed from: i, reason: collision with root package name */
        final int f243621i;

        public CUOpenCardClickableSpan(Context context, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, str2, Integer.valueOf(i3));
                return;
            }
            this.f243617d = context;
            this.f243618e = str;
            this.f243619f = str2;
            this.f243620h = i3;
            this.f243621i = Color.parseColor("#00a5e0");
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CUOpenCardClickableSpan.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = CUOpenCardClickableSpan.this.f243620h;
                    if (i16 == 1) {
                        str3 = "0X8008124";
                    } else if (i16 == 2) {
                        str3 = "0X8008126";
                    } else if (i16 != 3 && i16 != 4) {
                        str3 = null;
                    } else {
                        str3 = "0X800813E";
                    }
                    String str4 = str3;
                    if (!TextUtils.isEmpty(str4)) {
                        ReportController.o(null, "dc00898", "", "", str4, str4, 0, 0, "", "", "", "");
                    }
                }
            }, 5, null, false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            Intent intent = new Intent(this.f243617d, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", this.f243619f);
            intent.putExtra("url", this.f243618e);
            intent.putExtra("hide_more_button", true);
            this.f243617d.startActivity(intent);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CUOpenCardClickableSpan.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i3 = CUOpenCardClickableSpan.this.f243620h;
                    if (i3 == 1) {
                        str = "0X8008127";
                    } else if (i3 == 2) {
                        str = "0X8008125";
                    } else if (i3 != 3 && i3 != 4) {
                        str = null;
                    } else {
                        str = "0X800813F";
                    }
                    String str2 = str;
                    if (!TextUtils.isEmpty(str2)) {
                        ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
                    }
                }
            }, 5, null, false);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) textPaint);
            } else {
                textPaint.setColor(this.f243621i);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f243622a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<Integer> f243623b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f243624c;

        /* renamed from: d, reason: collision with root package name */
        public EntryItem[] f243625d;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f243622a = str;
            this.f243625d = new EntryItem[6];
            this.f243623b = ah.j();
            this.f243624c = QQUnicomCardGuideConfig.INSTANCE.isNeedShowGuide();
            for (int i3 = 0; i3 < this.f243625d.length; i3++) {
                QQUnicomCardGuideConfig qQUnicomCardGuideConfig = QQUnicomCardGuideConfig.INSTANCE;
                if (i3 < qQUnicomCardGuideConfig.getENTRY_KEYS().length) {
                    this.f243625d[i3] = qQUnicomCardGuideConfig.getEntryItem(qQUnicomCardGuideConfig.getENTRY_KEYS()[i3]);
                } else {
                    return;
                }
            }
        }
    }

    public CUOpenCardGuideMng(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f243616d = new a(qQAppInterface.getAccount());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(QQAppInterface qQAppInterface, String str, int i3, boolean z16, String str2) {
        long j3;
        long j16;
        EntryItem entryItem;
        EntryItem entryItem2;
        String str3;
        String str4;
        int indexOf;
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
        if (systemNetwork != 1) {
            j3 = ea.v(qQAppInterface.getApp(), qQAppInterface.getCurrentUin());
            j16 = System.currentTimeMillis();
            d.a e16 = com.tencent.mobileqq.vip.d.e(str2, true, false);
            if (QLog.isColorLevel()) {
                QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip info.mPopUpType = " + e16.f312930a + ", info.mGuideJumpUrl = " + e16.f312931b);
            }
            CUOpenCardGuideMng cUOpenCardGuideMng = (CUOpenCardGuideMng) qQAppInterface.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
            if (cUOpenCardGuideMng == null) {
                entryItem2 = null;
            } else if (z16) {
                entryItem2 = cUOpenCardGuideMng.b(4);
            } else {
                entryItem2 = cUOpenCardGuideMng.b(3);
            }
            if (entryItem2 != null && !TextUtils.isEmpty(entryItem2.getTip()) && !TextUtils.isEmpty(entryItem2.getKeyWord()) && !TextUtils.isEmpty(e16.f312931b)) {
                if (QLog.isColorLevel()) {
                    QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip entry.tip = " + entryItem2.getTip() + ", entry.keyWord = " + entryItem2.getKeyWord());
                }
                String[] split = entryItem2.getTip().split("\\|");
                String[] split2 = entryItem2.getKeyWord().split("\\|");
                if (split.length >= 2 && split2.length >= 2) {
                    int i16 = e16.f312930a;
                    if (i16 == 2) {
                        str3 = split[0];
                        str4 = split2[0];
                    } else if (i16 == 3) {
                        str3 = split[1];
                        str4 = split2[1];
                    }
                    if (str3 != null && str4 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("key_action", 1);
                        bundle.putString("textColor", "#40A0FF");
                        bundle.putString("key_action_DATA", e16.f312931b);
                        indexOf = str3.indexOf(str4);
                        int length = str4.length() + indexOf;
                        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, qQAppInterface.getCurrentUin(), str3, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, ErrorCode.YT_SDK_JSON_PARAM_ERROR, com.tencent.mobileqq.service.message.e.K0());
                        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                        if (indexOf >= 0) {
                            gVar.b(indexOf, length, bundle);
                        }
                        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
                        com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
                        ReportController.o(null, "dc00898", "", "", "0X800812A", "0X800812A", 0, 0, "", "", "", "");
                        ea.D3(qQAppInterface.getApp(), qQAppInterface.getCurrentUin(), System.currentTimeMillis());
                    }
                }
                str3 = null;
                str4 = null;
                if (str3 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("key_action", 1);
                    bundle2.putString("textColor", "#40A0FF");
                    bundle2.putString("key_action_DATA", e16.f312931b);
                    indexOf = str3.indexOf(str4);
                    int length2 = str4.length() + indexOf;
                    com.tencent.mobileqq.graytip.g gVar2 = new com.tencent.mobileqq.graytip.g(str, qQAppInterface.getCurrentUin(), str3, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, ErrorCode.YT_SDK_JSON_PARAM_ERROR, com.tencent.mobileqq.service.message.e.K0());
                    MessageForUniteGrayTip messageForUniteGrayTip2 = new MessageForUniteGrayTip();
                    if (indexOf >= 0) {
                    }
                    messageForUniteGrayTip2.initGrayTipMsg(qQAppInterface, gVar2);
                    com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip2);
                    ReportController.o(null, "dc00898", "", "", "0X800812A", "0X800812A", 0, 0, "", "", "", "");
                    ea.D3(qQAppInterface.getApp(), qQAppInterface.getCurrentUin(), System.currentTimeMillis());
                }
            }
            entryItem = entryItem2;
        } else {
            j3 = 0;
            j16 = 0;
            entryItem = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CUOpenCardGuideMng", 2, "addCallGrayTip, friendUin= " + str + ",isVideoMsg=" + z16 + ",netType=" + systemNetwork + ",uinType=" + i3 + ",lastAlertTime=" + j3 + ",currentTime=" + j16 + ",entry=" + entryItem);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CharSequence c(Context context, QQAppInterface qQAppInterface, int i3, String str) {
        if (qQAppInterface != null) {
            try {
                EntryItem b16 = ((CUOpenCardGuideMng) qQAppInterface.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER)).b(i3);
                if (b16 != null && !TextUtils.isEmpty(b16.getTip()) && !TextUtils.isEmpty(b16.getKeyWord()) && b16.getTip().contains(b16.getKeyWord()) && !TextUtils.isEmpty(b16.getJumpUrl())) {
                    String format = String.format("%s\n%s", str, b16.getTip());
                    SpannableString spannableString = new SpannableString(format);
                    int indexOf = format.indexOf(b16.getKeyWord());
                    spannableString.setSpan(new CUOpenCardClickableSpan(context, b16.getJumpUrl(), qQAppInterface.getCurrentUin(), i3), indexOf, b16.getKeyWord().length() + indexOf, 17);
                    str = spannableString;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("CUOpenCardGuideMng", 2, "getGuideEnty", e16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d retCode: %d context: %s", Integer.valueOf(i3), 0, context));
        }
        return str;
    }

    public EntryItem b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntryItem) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d", Integer.valueOf(i3)));
        }
        a aVar = this.f243616d;
        if (aVar.f243624c && i3 >= 0) {
            EntryItem[] entryItemArr = aVar.f243625d;
            if (i3 < entryItemArr.length) {
                return entryItemArr[i3];
            }
        }
        return null;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.i("CUOpenCardGuideMng", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }
}
