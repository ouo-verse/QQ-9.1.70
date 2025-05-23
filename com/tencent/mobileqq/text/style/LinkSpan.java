package com.tencent.mobileqq.text.style;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.ClipboardManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.item.o;
import com.tencent.mobileqq.activity.ep;
import com.tencent.mobileqq.activity.i;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.search.ah;
import com.tencent.mobileqq.search.api.IHashTagSearchLinkApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.m;
import com.tencent.mobileqq.text.n;
import com.tencent.mobileqq.troop.report.api.ITroopMsgDTReportApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.cg;
import com.tencent.mobileqq.utils.s;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.api.IAIOConfigService;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.Thrower;
import com.tencent.widget.ActionSheet;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes18.dex */
public class LinkSpan extends ClickableSpan {
    static IPatchRedirector $redirector_;
    private static String E;
    private static String F;
    private boolean C;

    @NotNull
    private m D;

    /* renamed from: d, reason: collision with root package name */
    public String f292710d;

    /* renamed from: e, reason: collision with root package name */
    private MessageRecord f292711e;

    /* renamed from: f, reason: collision with root package name */
    private int f292712f;

    /* renamed from: h, reason: collision with root package name */
    private String f292713h;

    /* renamed from: i, reason: collision with root package name */
    private ah f292714i;

    /* renamed from: m, reason: collision with root package name */
    private String f292715m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ActionSheet C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f292716d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f292717e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f292718f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f292719h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ MessageRecord f292720i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f292721m;

        a(Context context, String str, QQAppInterface qQAppInterface, int i3, MessageRecord messageRecord, int i16, ActionSheet actionSheet) {
            this.f292716d = context;
            this.f292717e = str;
            this.f292718f = qQAppInterface;
            this.f292719h = i3;
            this.f292720i = messageRecord;
            this.f292721m = i16;
            this.C = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LinkSpan.this, context, str, qQAppInterface, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16), actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                Activity activity = (Activity) this.f292716d;
                                String currentUin = this.f292718f.getCurrentUin();
                                MessageRecord messageRecord = this.f292720i;
                                ProfileCardUtil.o0(activity, currentUin, messageRecord.frienduin, messageRecord.istroop, this.f292717e);
                                ReportController.o(this.f292718f, "dc00898", "", "", "0X800A92C", "0X800A92C", this.f292719h, 0, "", "", "", "");
                            }
                        } else {
                            LinkSpan.r(this.f292716d, this.f292717e);
                            ReportController.o(this.f292718f, "dc00898", "", "", "0X800A92B", "0X800A92B", this.f292719h, 0, "", "", "", "");
                            LinkSpan.h("0X800A00A", "0X800A00A");
                        }
                    } else if (this.f292721m == 2) {
                        Intent createChooser = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.f292717e)), this.f292716d.getString(R.string.f171101c73));
                        createChooser.putExtra("big_brother_source_key", LinkSpan.this.f292715m);
                        this.f292716d.startActivity(createChooser);
                        ReportController.o(this.f292718f, "dc00898", "", "", "0X800A92D", "0X800A92D", 0, 0, "", "", "", "");
                    } else {
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f292717e));
                        intent.putExtra("big_brother_source_key", LinkSpan.this.f292715m);
                        this.f292716d.startActivity(intent);
                        ReportController.o(this.f292718f, "dc00898", "", "", "0X800A92A", "0X800A92A", this.f292719h, 0, "", "", "", "");
                        LinkSpan.j("1", "2");
                    }
                } else {
                    o.a(this.f292718f, (Activity) this.f292716d, (ChatMessage) this.f292720i, this.f292717e);
                    ReportController.o(this.f292718f, "dc00898", "", "", "0X800A927", "0X800A927", this.f292719h, 0, "", "", "", "");
                }
            } else {
                ((ClipboardManager) this.f292716d.getSystemService("clipboard")).setText(this.f292717e);
                ReportController.o(this.f292718f, "dc00898", "", "", "0X800A926", "0X800A926", this.f292719h, 0, "", "", "", "");
                LinkSpan.j("2", "1");
            }
            this.C.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements ActionSheet.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f292722d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f292723e;

        b(QQAppInterface qQAppInterface, int i3) {
            this.f292722d = qQAppInterface;
            this.f292723e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LinkSpan.this, qQAppInterface, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ReportController.o(this.f292722d, "dc00898", "", "", "0X800A92E", "0X800A92E", this.f292723e, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements Thrower.Action<Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f292725a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f292726b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ActionSheet f292727c;

        c(Context context, String str, ActionSheet actionSheet) {
            this.f292725a = context;
            this.f292726b = str;
            this.f292727c = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, actionSheet);
            }
        }

        @Override // com.tencent.util.Thrower.Action
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void execute(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                return;
            }
            int intValue = num.intValue();
            if (intValue == 0) {
                LinkSpan.f(this.f292725a, this.f292726b);
            } else if (intValue == 1) {
                LinkSpan.l(this.f292725a, this.f292726b);
            }
            this.f292727c.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Thrower f292728d;

        d(Thrower thrower) {
            this.f292728d = thrower;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) thrower);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else {
                this.f292728d.action(Integer.valueOf(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f292729d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f292730e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f292731f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f292732h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ActionSheet f292733i;

        e(int i3, String str, Context context, String str2, ActionSheet actionSheet) {
            this.f292729d = i3;
            this.f292730e = str;
            this.f292731f = context;
            this.f292732h = str2;
            this.f292733i = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, context, str2, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                AddFriendActivity.startActivity(this.f292731f, true, this.f292730e, true);
                                LinkSpan.j("4", "1");
                            }
                        } else {
                            AddFriendActivity.startActivity(this.f292731f, false, this.f292730e, true);
                            LinkSpan.j("3", "1");
                        }
                    } else {
                        LinkSpan.r(this.f292731f, this.f292730e);
                        LinkSpan.h("0X800A00A", "0X800A00A");
                    }
                } else {
                    ((ClipboardManager) this.f292731f.getSystemService("clipboard")).setText(this.f292730e);
                    LinkSpan.j("2", "1");
                }
            } else if (this.f292729d == 2) {
                Intent createChooser = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.f292730e)), this.f292731f.getString(R.string.f171101c73));
                createChooser.putExtra("big_brother_source_key", this.f292732h);
                this.f292731f.startActivity(createChooser);
            } else {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f292730e));
                intent.putExtra("big_brother_source_key", this.f292732h);
                this.f292731f.startActivity(intent);
                LinkSpan.j("1", "2");
            }
            this.f292733i.dismiss();
        }
    }

    public LinkSpan(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.C = true;
        this.D = m.f292688e;
        this.f292710d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("phone", str);
        context.startActivity(intent);
        h("0X800A00B", "0X800A00B");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str, String str2) {
        try {
            ReportController.o((QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(E), "dc00898", "", "", str, str2, 0, 0, "", "", "", "");
        } catch (ClassCastException e16) {
            e16.printStackTrace();
        } catch (AccountNotMatchException e17) {
            e17.printStackTrace();
        }
    }

    private void i(View view, MessageRecord messageRecord, int i3) {
        if (messageRecord.istroop != 10014) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_link_type", Integer.valueOf(i3));
        hashMap.put("qq_eid", "em_bas_link_class_content");
        String str = this.f292710d;
        if (str == null) {
            str = "";
        }
        hashMap.put("sgrp_url", str);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, String str2) {
        QQAppInterface qQAppInterface;
        if (F == null) {
            return;
        }
        try {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(E);
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            qQAppInterface = null;
        } catch (AccountNotMatchException unused) {
            return;
        }
        QQAppInterface qQAppInterface2 = qQAppInterface;
        if (str2 != null) {
            ReportController.o(qQAppInterface2, "P_CliOper", "Grp_join", "", "send", "Clk_url", 0, 0, F, "" + str, "" + str2, "");
            return;
        }
        ReportController.o(qQAppInterface2, "P_CliOper", "Grp_join", "", "send", "Clk_item", 0, 0, F, "" + str, "" + str, "");
    }

    private void k(View view, MessageRecord messageRecord, int i3) {
        String str;
        HashMap hashMap = new HashMap();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && this.f292711e != null) {
            String str2 = "";
            if (((IAIOConfigService) peekAppRuntime.getRuntimeService(IAIOConfigService.class, "")).linkUseNewStyle()) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("op_result", str);
            String str3 = this.f292710d;
            if (str3 != null) {
                str2 = str3;
            }
            hashMap.put("sgrp_url", str2);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_link_class_content", hashMap);
            i(view, messageRecord, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/person");
        intent.setType("vnd.android.cursor.item/contact");
        intent.setType("vnd.android.cursor.item/raw_contact");
        intent.putExtra("phone", str);
        context.startActivity(intent);
        h("0X800A00C", "0X800A00C");
    }

    public static int m(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        return n(qQAppInterface, messageRecord.isMultiMsg, messageRecord.istroop, messageRecord.frienduin);
    }

    public static int n(QQAppInterface qQAppInterface, boolean z16, int i3, String str) {
        if (qQAppInterface == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        if (z16) {
            return 7;
        }
        if (ChatActivityUtils.M(qQAppInterface, i3, str)) {
            return 5;
        }
        if (i.a(i3)) {
            return 3;
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                return -1;
            }
            return 4;
        }
        return 2;
    }

    public static void r(Context context, String str) {
        ActionSheet create = ActionSheet.create(context);
        create.setMainTitle(String.format(context.getString(R.string.cln), str));
        create.addButton(R.string.f170801af1, 1);
        create.addButton(R.string.f170074f5, 1);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new d(Thrower.create(new c(context, str, create)).throwttle(1000L)));
        create.show();
    }

    public static void t(Context context, String str, boolean z16) {
        u(context, str, !z16 ? 1 : 0, null);
    }

    public static void u(Context context, String str, int i3, String str2) {
        ActionSheet create = ActionSheet.create(context);
        if (i3 == 0) {
            create.setMainTitle(String.format(context.getString(R.string.clm), str));
            create.addButton(R.string.ano, 1);
            create.addButton(R.string.aet, 1);
            create.addButton(R.string.f170068ey, 1);
            create.addButton(R.string.f170048dx, 1);
            create.addButton(R.string.f171053c05, 1);
        } else if (i3 == 1) {
            create.setMainTitle(String.format(context.getString(R.string.cln), str));
            create.addButton(R.string.ano, 1);
            create.addButton(R.string.aet, 1);
            create.addButton(R.string.f170068ey, 1);
        } else if (i3 == 2) {
            create.setMainTitle(String.format(context.getString(R.string.f171102c74), str));
            create.addButton(R.string.hee, 1);
            create.addButton(R.string.aet, 1);
        } else if (i3 == 3) {
            create.setMainTitle(String.format(context.getString(R.string.cln), str));
            create.addButton(R.string.ano, 1);
            create.addButton(R.string.aet, 1);
            create.addButton(R.string.f170068ey, 1);
        }
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new e(i3, str, context, str2, create));
        create.show();
    }

    private void v(Context context, String str, int i3, String str2) {
        if (!w(context, str, i3, str2)) {
            u(context, str, i3, str2);
        }
    }

    private boolean w(Context context, String str, int i3, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.equals(((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getBizSrcJcFeed())) {
            if (i3 == 0 || i3 == 1) {
                Activity a16 = ep.a(context);
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if ((runtime instanceof QQAppInterface) && a16 != null) {
                    if (this.f292714i == null) {
                        this.f292714i = new ah((QQAppInterface) runtime, a16, str2);
                    }
                    this.f292714i.v(str, false, 10014, "", "");
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    protected void g(View view, String str) {
        String str2;
        int i3;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) str);
            return;
        }
        try {
            AppRuntime appRuntime = BaseApplicationImpl.getApplication().getAppRuntime(E);
            if (appRuntime instanceof QQAppInterface) {
                ECommerceDataReportUtil.i((QQAppInterface) appRuntime, this.f292711e, 5, str);
            }
            MessageRecord messageRecord = this.f292711e;
            if (messageRecord != null && messageRecord.istroop == 1) {
                ITroopMsgDTReportApi iTroopMsgDTReportApi = (ITroopMsgDTReportApi) QRoute.api(ITroopMsgDTReportApi.class);
                MessageRecord messageRecord2 = this.f292711e;
                iTroopMsgDTReportApi.reportTapMsgLinkJump(messageRecord2.frienduin, str, messageRecord2.f203106msg, messageRecord2.senderuin, messageRecord2.time);
            }
        } catch (Throwable th5) {
            QLog.e("LinkSpan", 1, th5, new Object[0]);
        }
        int lastIndexOf = str.lastIndexOf("#");
        if (lastIndexOf > 0) {
            str2 = str.substring(lastIndexOf);
        } else {
            str2 = null;
        }
        String guessUrl = URLUtil.guessUrl(str);
        if (str2 != null) {
            guessUrl = guessUrl + str2;
        }
        String str4 = guessUrl;
        if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(str4)) {
            Context context = view.getContext();
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                Bundle bundle = new Bundle();
                bundle.putString("url", str4);
                bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG);
                TeamWorkDocEditBrowserActivity.openTeamWorkDocEditBrowserActivity(view.getContext(), bundle, false);
            } else {
                QQToast.makeText(context, context.getResources().getString(R.string.b3j), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        } else {
            com.tencent.mobileqq.mtt.a.a(view.getContext(), str4, true, true, true, false, this.f292711e, this.f292715m);
        }
        MessageRecord messageRecord3 = this.f292711e;
        if (messageRecord3 == null) {
            ReportController.o(null, "CliOper", "", "", "0X80061B1", "0X80061B1", 0, 0, "", "", "", "");
            return;
        }
        try {
            String str5 = messageRecord3.frienduin;
            if (messageRecord3.istroop == 1) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            if (str.length() > 150) {
                str3 = str.substring(0, 150);
            } else {
                str3 = str;
            }
            String host = new URL(str).getHost();
            ReportController.o(null, "CliOper", "", str5, "0X80061B1", "0X80061B1", i3, 0, "", "", str3, host);
            if (QLog.isDebugVersion()) {
                QLog.d(QQText.TAG, 4, String.format("the report params:%s,%s,%s,%s", "", "", str3, host));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f292715m = str;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        if (s.f307814a) {
            if (QLog.isColorLevel()) {
                QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
                return;
            }
            return;
        }
        if (!this.C) {
            if (QLog.isColorLevel()) {
                QLog.i("LinkSpan", 2, "onClick no clickable");
                return;
            }
            return;
        }
        if (u.a().b()) {
            if (QLog.isColorLevel()) {
                QLog.i("LinkSpan", 2, "onClick is duplicate click");
                return;
            }
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            F = (String) tag;
        }
        String str = this.f292710d;
        boolean find = cg.f307525d.matcher(str).find();
        if (!find) {
            find = cg.f307524c.matcher(str).find();
        }
        if (find) {
            if (n.f292698g.matcher(str).find()) {
                s(view.getContext(), str, 2, this.f292711e);
                k(view, this.f292711e, 0);
                j("1", null);
                return;
            } else {
                g(view, str);
                k(view, this.f292711e, 0);
                j("0", null);
                return;
            }
        }
        if (n.f292692a.matcher(str).find()) {
            s(view.getContext(), str, 3, this.f292711e);
            k(view, this.f292711e, 0);
            j("2", null);
            return;
        }
        Matcher matcher = n.f292694c.matcher(str);
        if (matcher.find() && matcher.start() == 0 && matcher.end() == str.length()) {
            s(view.getContext(), str, 0, this.f292711e);
            k(view, this.f292711e, 1);
            j("1", null);
            return;
        }
        if (this.D.enable) {
            Matcher matcher2 = n.f292701j.matcher(str);
            if (matcher2.find() && matcher2.start() == 0 && matcher2.end() == str.length()) {
                IHashTagSearchLinkApi iHashTagSearchLinkApi = IHashTagSearchLinkApi.f282735g;
                Context context = view.getContext();
                m mVar = this.D;
                iHashTagSearchLinkApi.routeSearchLinkPage(context, str, mVar.com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE java.lang.String, mVar.userSource);
                return;
            }
        }
        if (n.f292697f.matcher(str).find()) {
            s(view.getContext(), str, 1, this.f292711e);
            k(view, this.f292711e, 0);
            j("2", null);
        }
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LinkSpan", 2, "setClickable=" + z16);
        }
        this.C = z16;
    }

    public LinkSpan q(@NotNull m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LinkSpan) iPatchRedirector.redirect((short) 6, (Object) this, (Object) mVar);
        }
        this.D = mVar;
        return this;
    }

    public void s(Context context, String str, int i3, MessageRecord messageRecord) {
        QQAppInterface qQAppInterface;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, str, Integer.valueOf(i3), messageRecord);
            return;
        }
        if (messageRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LinkSpan", 2, "msg is null, show old action sheet");
            }
            v(context, str, i3, this.f292715m);
            return;
        }
        if (context instanceof BaseActivity) {
            qQAppInterface = ((BaseActivity) context).app;
        } else {
            qQAppInterface = null;
        }
        QQAppInterface qQAppInterface2 = qQAppInterface;
        if (qQAppInterface2 == null) {
            try {
                qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(messageRecord.selfuin);
            } catch (AccountNotMatchException e16) {
                QLog.e("LinkSpan", 1, e16, new Object[0]);
            }
        }
        if (qQAppInterface2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LinkSpan", 2, "app is null, show old action sheet");
            }
            v(context, str, i3, this.f292715m);
            return;
        }
        if (i3 == 2) {
            i16 = 5;
        } else {
            i16 = 4;
        }
        ActionSheet create = ActionSheet.create(context);
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                create.setMainTitle(String.format(context.getString(R.string.f171102c74), str));
                create.addButton(R.string.aet, 1);
                create.addButton(R.string.b3m, 1);
                create.addButton(R.string.hee, 1);
                ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800A924", "0X800A924", m(qQAppInterface2, messageRecord), 0, "", "", "", "");
            } else if (i3 == 3) {
                create.setMainTitle(String.format(context.getString(R.string.cln), str));
                create.addButton(R.string.aet, 1);
                create.addButton(R.string.b3m, 1);
                create.addButton(R.string.ano, 1);
                create.addButton(R.string.f170068ey, 1);
                ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800A923", "0X800A923", m(qQAppInterface2, messageRecord), 0, "", "", "", "");
            }
            create.addCancelButton(R.string.cancel);
            create.setOnButtonClickListener(new a(context, str, qQAppInterface2, i16, messageRecord, i3, create));
            create.setOnDismissListener(new b(qQAppInterface2, i16));
            create.show();
            return;
        }
        if (this.f292714i == null) {
            this.f292714i = new ah(qQAppInterface2, context, this.f292715m);
        }
        String str2 = messageRecord.selfuin;
        if (!messageRecord.isSend() && !messageRecord.senderuin.equals(qQAppInterface2.getCurrentAccountUin())) {
            this.f292713h = messageRecord.senderuin;
        } else {
            this.f292713h = messageRecord.frienduin;
        }
        int i17 = messageRecord.istroop;
        this.f292712f = i17;
        this.f292714i.v(str, messageRecord.isMultiMsg, i17, this.f292713h, str2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) textPaint);
        } else {
            super.updateDrawState(textPaint);
            textPaint.clearShadowLayer();
        }
    }

    public LinkSpan(String str, String str2, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, messageRecord);
            return;
        }
        this.C = true;
        this.D = m.f292688e;
        this.f292710d = str;
        this.f292711e = messageRecord;
        E = str2;
    }
}
