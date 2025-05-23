package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.NTHttpMqqJumper;
import com.tencent.mobileqq.pushdialog.PushDialogDbUtil;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import com.tencent.mobileqq.pushdialog.SafeBlowHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public class AIOPushDialogHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mobileqq.pushdialog.c {

    /* renamed from: d, reason: collision with root package name */
    private int f350225d = 11;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f350226e;

    /* renamed from: f, reason: collision with root package name */
    public QQCustomDialog f350227f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f350228h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f350229i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f350233d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f350234e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f350235f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f350236h;

        a(Context context, String str, String str2, String str3) {
            this.f350233d = context;
            this.f350234e = str;
            this.f350235f = str2;
            this.f350236h = str3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            new com.tencent.mobileqq.pushdialog.b(this.f350233d).e(this.f350234e).d();
            AIOPushDialogHelper.this.n();
            ReportController.o(AIOPushDialogHelper.this.f350228h, "dc00898", "", "", "0X800A4BB", "0X800A4BB", 0, 0, "", "", "", "");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setTextSize(com.tencent.mobileqq.util.x.c(this.f350233d, 14.0f));
            textPaint.setColor(Color.parseColor("#4D94FF"));
            if (!TextUtils.isEmpty(this.f350235f)) {
                textPaint.setColor(Color.parseColor(this.f350235f));
            }
            if (TextUtils.isEmpty(this.f350236h)) {
                return;
            }
            textPaint.setTextSize(Float.valueOf(this.f350236h).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f350238d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f350239e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PushDialogTemplate f350240f;

        b(Context context, String str, PushDialogTemplate pushDialogTemplate) {
            this.f350238d = context;
            this.f350239e = str;
            this.f350240f = pushDialogTemplate;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NTHttpMqqJumper nTHttpMqqJumper = new NTHttpMqqJumper(this.f350238d, AIOPushDialogHelper.this.f350228h);
            QLog.d("AIOPushDialogHelper", 1, "Negative Button Click");
            nTHttpMqqJumper.h(this.f350239e).i(AIOPushDialogHelper.this.f350229i.g().r()).g();
            if (this.f350240f.isFriendBanned()) {
                ReportController.o(AIOPushDialogHelper.this.f350228h, "dc00898", "", "", "0X800A4BE", "0X800A4BE", 0, 0, "", "", "", "");
            } else {
                ReportController.o(AIOPushDialogHelper.this.f350228h, "dc00898", "", "", "0X800A4BC", "0X800A4BC", 0, 0, "", "", "", "");
                ReportController.o(AIOPushDialogHelper.this.f350228h, "dc00898", "", "", "0X800B9A2", "0X800B9A2", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f350242d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f350243e;

        c(Context context, String str) {
            this.f350242d = context;
            this.f350243e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NTHttpMqqJumper nTHttpMqqJumper = new NTHttpMqqJumper(this.f350242d, AIOPushDialogHelper.this.f350228h);
            QLog.d("AIOPushDialogHelper", 1, "Positive Button Click");
            nTHttpMqqJumper.h(this.f350243e).i(AIOPushDialogHelper.this.f350229i.g().r()).g();
            AIOPushDialogHelper.this.n();
            ReportController.o(AIOPushDialogHelper.this.f350228h, "dc00898", "", "", "0X800B9A3", "0X800B9A3", 0, 0, "", "", "", "");
            ReportController.o(AIOPushDialogHelper.this.f350228h, "dc00898", "", "", "0X800A4BD", "0X800A4BD", 0, 0, "", "", "", "");
        }
    }

    private UniteEntity j(byte[] bArr) {
        try {
            return com.tencent.mobileqq.graytip.i.l(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void k(EntityManager entityManager, long j3) {
        PushDialogDbUtil.c().e(entityManager, j3, new PushDialogDbUtil.a() { // from class: com.tencent.qqnt.aio.helper.AIOPushDialogHelper.1
            @Override // com.tencent.mobileqq.pushdialog.PushDialogDbUtil.a
            public void a(final List<PushDialogTemplate> list) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.AIOPushDialogHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AIOPushDialogHelper.this.p(list, 100, 103);
                    }
                });
            }
        });
    }

    private void m() {
        AIOContact c16 = this.f350229i.g().r().c();
        int e16 = c16.e();
        String j3 = c16.j();
        if (e16 == 1) {
            Long valueOf = Long.valueOf(this.f350229i.g().l().getLong("key_peerUin"));
            if (valueOf != null) {
                com.tencent.mobileqq.pushdialog.a.f261334a.b(String.valueOf(valueOf), this);
                return;
            }
            return;
        }
        com.tencent.mobileqq.pushdialog.a.f261334a.b(j3, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        QQAppInterface qQAppInterface = this.f350228h;
        if (qQAppInterface != null) {
            Long z06 = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getUixConvertService().z0(this.f350229i.g().r().c().j());
            QQAppInterface qQAppInterface2 = this.f350228h;
            if (qQAppInterface2 != null) {
                SafeBlowHandler safeBlowHandler = (SafeBlowHandler) qQAppInterface2.getBusinessHandler(SafeBlowHandler.f261333d);
                if (safeBlowHandler == null || z06.longValue() == 0) {
                    return;
                }
                safeBlowHandler.E2(z06.longValue());
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mApp == null ? = ");
            sb5.append(this.f350228h == null);
            QLog.e("AIOPushDialogHelper", 1, sb5.toString());
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("mApp == null ? = ");
        sb6.append(this.f350228h == null);
        QLog.e("AIOPushDialogHelper", 1, sb6.toString());
    }

    private void q() {
        AIOContact c16 = this.f350229i.g().r().c();
        int e16 = c16.e();
        String j3 = c16.j();
        if (e16 == 1) {
            Long valueOf = Long.valueOf(this.f350229i.g().l().getLong("key_peerUin"));
            if (valueOf != null) {
                com.tencent.mobileqq.pushdialog.a.f261334a.d(String.valueOf(valueOf));
                return;
            }
            return;
        }
        com.tencent.mobileqq.pushdialog.a.f261334a.d(j3);
    }

    public void g() {
        QQAppInterface qQAppInterface = this.f350228h;
        if (qQAppInterface == null) {
            return;
        }
        this.f350226e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        if (this.f350228h != null) {
            m();
        }
        this.f350229i.g().r().c().j();
        Long valueOf = Long.valueOf(this.f350229i.g().l().getLong("key_peerUin"));
        if (valueOf != null) {
            k(this.f350226e, valueOf.longValue());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.E;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "AIOPushDialogHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b bVar) {
        this.f350228h = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.f350229i = bVar.a();
        if (QLog.isColorLevel()) {
            QLog.d("AIOPushDialogHelper", 2, "onCreate");
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOPushDialogHelper", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        if (this.f350228h != null) {
            q();
            this.f350228h = null;
        }
        this.f350225d = 11;
        this.f350226e = null;
        this.f350227f = null;
        this.f350229i = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{9, 1, 6, 12, 4};
    }

    public void p(List<PushDialogTemplate> list, int i3, int i16) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i17 = 0; i17 < list.size(); i17++) {
            a(list.get(i17), i3, i16);
        }
    }

    private void h(PushDialogTemplate pushDialogTemplate, int i3) {
        if (i3 == 102 && this.f350226e != null) {
            PushDialogDbUtil.c().d(this.f350226e, pushDialogTemplate);
        }
        QQCustomDialog qQCustomDialog = this.f350227f;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    private void i(PushDialogTemplate pushDialogTemplate, int i3) {
        if (i3 != 103 || this.f350226e == null) {
            return;
        }
        PushDialogDbUtil.c().b(this.f350226e, pushDialogTemplate);
    }

    private void o(QQCustomDialog qQCustomDialog, UniteEntity uniteEntity, PushDialogTemplate pushDialogTemplate) {
        ArrayList<UniteEntity.Note> subNotes;
        int i3;
        FragmentActivity requireActivity = this.f350229i.c().requireActivity();
        int i16 = 1;
        if (requireActivity == null) {
            QLog.i("AIOPushDialogHelper", 1, "showDialog but context is null");
            return;
        }
        UniteEntity.Note rootNote = uniteEntity.getRootNote();
        if (rootNote.getNoteType() != 6 || (subNotes = rootNote.getSubNotes()) == null || subNotes.size() == 0) {
            return;
        }
        for (UniteEntity.Note note : subNotes) {
            HashMap<Integer, Object> fields = note.getFields();
            ArrayList<UniteEntity.Note> subNotes2 = note.getSubNotes();
            int i17 = 2;
            if (note.getNoteType() == 7) {
                String str = (String) fields.get(2);
                if (!TextUtils.isEmpty(str)) {
                    qQCustomDialog.setTitle(str);
                }
                i3 = i16;
            } else {
                int i18 = 4;
                int i19 = 0;
                if (note.getNoteType() == 8) {
                    if (subNotes2 != null && subNotes2.size() != 0) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (UniteEntity.Note note2 : subNotes2) {
                            HashMap<Integer, Object> fields2 = note2.getFields();
                            if (note2.getNoteType() == i17) {
                                if (fields2 != null) {
                                    String str2 = (String) fields2.get(Integer.valueOf(i17));
                                    if (!TextUtils.isEmpty(str2)) {
                                        SpannableString spannableString = new SpannableString(str2);
                                        spannableString.setSpan(Integer.valueOf(Color.parseColor("#03081A")), 0, spannableString.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableString);
                                    }
                                }
                            } else if (note2.getNoteType() == 3 && fields2 != null) {
                                String str3 = (String) fields2.get(Integer.valueOf(i17));
                                String str4 = (String) fields2.get(Integer.valueOf(i18));
                                String str5 = (String) fields2.get(3);
                                String str6 = (String) fields2.get(5);
                                SpannableString spannableString2 = new SpannableString(str3);
                                spannableString2.setSpan(new a(requireActivity, str4, str6, str5), 0, str3.length(), 33);
                                spannableStringBuilder.append((CharSequence) spannableString2);
                            }
                            i17 = 2;
                            i18 = 4;
                        }
                        qQCustomDialog.setMessageWithoutAutoLink(spannableStringBuilder);
                    }
                } else if (note.getNoteType() == 9 && subNotes2 != null) {
                    for (UniteEntity.Note note3 : subNotes2) {
                        if (note3.getNoteType() == 10) {
                            HashMap<Integer, Object> fields3 = note3.getFields();
                            String str7 = (String) fields3.get(2);
                            String str8 = (String) fields3.get(4);
                            if (i19 == 0) {
                                qQCustomDialog.setNegativeButton(str7, new b(requireActivity, str8, pushDialogTemplate));
                            } else if (i19 == 1) {
                                qQCustomDialog.setPositiveButton(str7, new c(requireActivity, str8));
                            }
                            i19++;
                        }
                    }
                }
                i3 = 1;
            }
            i16 = i3;
        }
    }

    @Override // com.tencent.mobileqq.pushdialog.c
    public void a(PushDialogTemplate pushDialogTemplate, int i3, int i16) {
        byte[] bArr;
        UniteEntity j3;
        Context context = this.f350229i.c().getContext();
        if (context == null) {
            QLog.i("AIOPushDialogHelper", 1, "showDialog but context is null");
            return;
        }
        if (pushDialogTemplate == null || (bArr = pushDialogTemplate.templ_content) == null || (j3 = j(bArr)) == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.f350227f;
        if (qQCustomDialog == null) {
            QQCustomDialog qQCustomDialog2 = new QQCustomDialog(context, R.style.qZoneInputDialog);
            this.f350227f = qQCustomDialog2;
            qQCustomDialog2.setContentView(R.layout.f167856jn);
            this.f350227f.setCanceledOnTouchOutside(false);
            LinearLayout linearLayout = (LinearLayout) this.f350227f.findViewById(R.id.abb);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.leftMargin = com.tencent.mobileqq.util.x.c(context, 30.0f);
            layoutParams.rightMargin = com.tencent.mobileqq.util.x.c(context, 30.0f);
            linearLayout.setLayoutParams(layoutParams);
        } else {
            qQCustomDialog.dismiss();
        }
        o(this.f350227f, j3, pushDialogTemplate);
        this.f350227f.show();
        if (this.f350225d == 1) {
            i(pushDialogTemplate, i16);
            if (pushDialogTemplate.isFriendBanned()) {
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
            } else {
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
            }
            ReportController.o(this.f350228h, "dc00898", "", "", "0X800B9A1", "0X800B9A1", 0, 0, "", "", "", "");
            return;
        }
        h(pushDialogTemplate, i3);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
        if (i3 == 1) {
            this.f350225d = 1;
            return;
        }
        if (i3 == 4) {
            g();
            return;
        }
        if (i3 != 9) {
            if (i3 != 12) {
                return;
            }
            onDestroy();
        } else {
            this.f350225d = 9;
            QQCustomDialog qQCustomDialog = this.f350227f;
            if (qQCustomDialog != null) {
                qQCustomDialog.dismiss();
            }
        }
    }
}
