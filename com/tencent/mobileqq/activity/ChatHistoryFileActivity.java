package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakConstants;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatHistoryFileActivity extends IphoneTitleBarActivity implements View.OnClickListener, Handler.Callback, com.tencent.mobileqq.richmediabrowser.g {
    static IPatchRedirector $redirector_;
    private Dialog A0;
    private QQCustomDialog B0;
    private FMObserver C0;

    /* renamed from: a0, reason: collision with root package name */
    LinearLayout f175257a0;

    /* renamed from: b0, reason: collision with root package name */
    FrameLayout f175258b0;

    /* renamed from: c0, reason: collision with root package name */
    boolean f175259c0;

    /* renamed from: d0, reason: collision with root package name */
    ChatHistoryViewBase f175260d0;

    /* renamed from: e0, reason: collision with root package name */
    RelativeLayout f175261e0;

    /* renamed from: f0, reason: collision with root package name */
    ImageView f175262f0;

    /* renamed from: g0, reason: collision with root package name */
    ImageView f175263g0;

    /* renamed from: h0, reason: collision with root package name */
    ImageView f175264h0;

    /* renamed from: i0, reason: collision with root package name */
    ImageView f175265i0;

    /* renamed from: j0, reason: collision with root package name */
    List<ChatMessage> f175266j0;

    /* renamed from: k0, reason: collision with root package name */
    List<FileManagerEntity> f175267k0;

    /* renamed from: l0, reason: collision with root package name */
    List<com.tencent.mobileqq.activity.aio.photo.f> f175268l0;

    /* renamed from: m0, reason: collision with root package name */
    List<TencentDocData> f175269m0;

    /* renamed from: n0, reason: collision with root package name */
    List<com.tencent.mobileqq.emotionintegrate.s> f175270n0;

    /* renamed from: o0, reason: collision with root package name */
    List<ChatMessage> f175271o0;

    /* renamed from: p0, reason: collision with root package name */
    String f175272p0;

    /* renamed from: q0, reason: collision with root package name */
    int f175273q0;

    /* renamed from: r0, reason: collision with root package name */
    String f175274r0;

    /* renamed from: s0, reason: collision with root package name */
    ChatHistoryStructMsgView f175275s0;

    /* renamed from: t0, reason: collision with root package name */
    ChatHistoryFileView f175276t0;

    /* renamed from: u0, reason: collision with root package name */
    ChatHistoryEmotionView f175277u0;

    /* renamed from: v0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.chathistory.b f175278v0;

    /* renamed from: w0, reason: collision with root package name */
    protected final MqqHandler f175279w0;

    /* renamed from: x0, reason: collision with root package name */
    QQCustomDialog f175280x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f175281y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f175282z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatHistoryFileActivity$7, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass7 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f175283d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f175284e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f175285f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f175286h;

        AnonymousClass7(List list, List list2, boolean z16, List list3) {
            this.f175283d = list;
            this.f175284e = list2;
            this.f175285f = z16;
            this.f175286h = list3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatHistoryFileActivity.this, list, list2, Boolean.valueOf(z16), list3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(JSONObject jSONObject, Object obj) {
            if (!(obj instanceof JSONObject)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryFIleActivity", 1, jSONObject.toString());
            }
            try {
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2.getInt("retcode") == 0) {
                    FileManagerReporter.addData("0X8009AA0");
                } else {
                    com.tencent.mobileqq.filemanager.util.d.f(jSONObject2.getString("msg"));
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("ChatHistoryFIleActivity", 1, th5.getMessage());
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f175283d.size() == 1) {
                ChatHistoryFileActivity.this.app.getMessageFacade().z0((MessageRecord) this.f175283d.get(0), false);
            } else if (this.f175283d.size() > 1) {
                ChatHistoryFileActivity.this.app.getMessageFacade().B0(this.f175283d, false);
            }
            List list = this.f175284e;
            if (list != null && list.size() > 0) {
                for (FileManagerEntity fileManagerEntity : this.f175284e) {
                    fileManagerEntity.bDelInAio = true;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("ChatHistoryFIleActivity", 1, "ChatHistory entity[" + fileManagerEntity.getId() + "] del File:" + fileManagerEntity.nSessionId);
                    }
                    ChatHistoryFileActivity.this.app.getFileManagerEngine().i(fileManagerEntity.nSessionId);
                }
            }
            try {
                if (this.f175285f) {
                    final JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put("recent_file_list", jSONArray);
                    Iterator it = this.f175286h.iterator();
                    while (it.hasNext()) {
                        jSONArray.mo162put(((TencentDocData) it.next()).translate2JsonObject());
                    }
                    ((ITeamWorkHandler) ChatHistoryFileActivity.this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).delRecentFilesByHttp(jSONObject, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.activity.m
                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                        public final void a(Object obj) {
                            ChatHistoryFileActivity.AnonymousClass7.b(JSONObject.this, obj);
                        }
                    });
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ChatHistoryFIleActivity", 1, e16.getMessage());
                }
            }
            ChatHistoryFileActivity.this.f175279w0.sendEmptyMessage(2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements l {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatHistoryFileActivity.l
        public boolean onDialogClick(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
            }
            if (z16) {
                WeiyunAIOUtils.u(ChatHistoryFileActivity.this);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements TabBarView.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabBarView.d
        public void a(int i3, int i16) {
            ChatHistoryViewBase P2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == i16) {
                return;
            }
            if (i16 == 0) {
                P2 = ChatHistoryFileActivity.this.P2(0);
            } else if (i16 == 1) {
                P2 = ChatHistoryFileActivity.this.P2(4);
            } else if (i16 == 2) {
                P2 = ChatHistoryFileActivity.this.P2(1);
                ReportController.o(ChatHistoryFileActivity.this.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
            } else if (i16 == 3) {
                P2 = ChatHistoryFileActivity.this.P2(2);
                ReportController.o(ChatHistoryFileActivity.this.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
            } else if (i16 == 4) {
                P2 = ChatHistoryFileActivity.this.P2(3);
                ReportController.o(ChatHistoryFileActivity.this.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
            } else {
                P2 = null;
            }
            ChatHistoryViewBase chatHistoryViewBase = ChatHistoryFileActivity.this.f175260d0;
            if (chatHistoryViewBase != null) {
                chatHistoryViewBase.c();
                ChatHistoryFileActivity chatHistoryFileActivity = ChatHistoryFileActivity.this;
                chatHistoryFileActivity.f175261e0.removeView(chatHistoryFileActivity.f175260d0.e());
            }
            if (P2 != null) {
                P2.i(ChatHistoryFileActivity.this.f175281y0);
                P2.d();
                ChatHistoryFileActivity chatHistoryFileActivity2 = ChatHistoryFileActivity.this;
                chatHistoryFileActivity2.f175260d0 = P2;
                P2.f175325e = chatHistoryFileActivity2;
                chatHistoryFileActivity2.f175261e0.addView(P2.e(), 0, new ViewGroup.LayoutParams(-1, -1));
                ChatHistoryFileActivity chatHistoryFileActivity3 = ChatHistoryFileActivity.this;
                if (chatHistoryFileActivity3.f175259c0) {
                    chatHistoryFileActivity3.f175260d0.b();
                } else {
                    chatHistoryFileActivity3.f175260d0.a();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f175290d;

        d(ActionSheet actionSheet) {
            this.f175290d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            ChatHistoryFileActivity chatHistoryFileActivity = ChatHistoryFileActivity.this;
            chatHistoryFileActivity.I2(3, chatHistoryFileActivity.f175266j0, chatHistoryFileActivity.f175267k0, chatHistoryFileActivity.f175268l0, chatHistoryFileActivity.f175269m0);
            if (this.f175290d.isShowing()) {
                this.f175290d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements FMDialogUtil.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f175292a;

        e(List list) {
            this.f175292a = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this, (Object) list);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                FileManagerUtil.forwardRencentFiles(this.f175292a, ChatHistoryFileActivity.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements FMDialogUtil.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f175295a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileManagerEngine f175296b;

        g(List list, FileManagerEngine fileManagerEngine) {
            this.f175295a = list;
            this.f175296b = fileManagerEngine;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatHistoryFileActivity.this, list, fileManagerEngine);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            for (FileManagerEntity fileManagerEntity : this.f175295a) {
                if (!fileManagerEntity.sendCloudUnsuccessful()) {
                    this.f175296b.t0(fileManagerEntity);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements FMDialogUtil.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f175298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileManagerEngine f175299b;

        h(List list, FileManagerEngine fileManagerEngine) {
            this.f175298a = list;
            this.f175299b = fileManagerEngine;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatHistoryFileActivity.this, list, fileManagerEngine);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.filemanager.util.d.d(ChatHistoryFileActivity.this.getString(R.string.f170978be3));
            for (FileManagerEntity fileManagerEntity : this.f175298a) {
                if (!fileManagerEntity.sendCloudUnsuccessful()) {
                    if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                        this.f175299b.F0(fileManagerEntity.getFilePath(), "", ChatHistoryFileActivity.this.app.getCurrentAccountUin(), "", 0, false);
                    } else {
                        this.f175299b.v0(fileManagerEntity, String.valueOf(fileManagerEntity.peerUin));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f175301d;

        i(l lVar) {
            this.f175301d = lVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this, (Object) lVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                this.f175301d.onDialogClick(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f175303d;

        j(l lVar) {
            this.f175303d = lVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this, (Object) lVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                this.f175303d.onDialogClick(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class k extends FMObserver {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            MqqHandler mqqHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryFIleActivity", 2, "OnFileTransferEnd : isSuccess[" + z16 + "], uniseq[" + j3 + "], nSessionId[" + j16 + str + "], peerType[" + i3 + "]");
            }
            FileManagerEntity D = ChatHistoryFileActivity.this.app.getFileManagerDataCenter().D(j16);
            if (D != null && D.nOpType == 6 && ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i16) && (mqqHandler = ChatHistoryFileActivity.this.f175279w0) != null) {
                mqqHandler.sendEmptyMessage(105);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void j0(int i3, long j3, String str) {
            MqqHandler mqqHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), str);
            } else if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3) && (mqqHandler = ChatHistoryFileActivity.this.f175279w0) != null) {
                mqqHandler.sendEmptyMessage(105);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void k0(long j3, String str, int i3, String str2) {
            MqqHandler mqqHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str, Integer.valueOf(i3), str2);
            } else if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3) && (mqqHandler = ChatHistoryFileActivity.this.f175279w0) != null) {
                mqqHandler.sendEmptyMessage(105);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface l {
        boolean onDialogClick(boolean z16);
    }

    public ChatHistoryFileActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175259c0 = false;
        this.f175260d0 = null;
        this.f175279w0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.f175282z0 = false;
        this.C0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatHistoryViewBase P2(int i3) {
        this.f175281y0 = i3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    if (this.f175277u0 == null) {
                        ChatHistoryEmotionView chatHistoryEmotionView = new ChatHistoryEmotionView();
                        this.f175277u0 = chatHistoryEmotionView;
                        chatHistoryEmotionView.p(getIntent(), this.app, this);
                    }
                    return this.f175277u0;
                }
            } else {
                if (this.f175275s0 == null) {
                    ChatHistoryStructMsgView chatHistoryStructMsgView = new ChatHistoryStructMsgView();
                    this.f175275s0 = chatHistoryStructMsgView;
                    chatHistoryStructMsgView.l(getIntent(), this.app, this);
                }
                return this.f175275s0;
            }
        }
        if (this.f175276t0 == null) {
            ChatHistoryFileView chatHistoryFileView = new ChatHistoryFileView();
            this.f175276t0 = chatHistoryFileView;
            chatHistoryFileView.n(getIntent(), this.app, this);
        }
        this.f175276t0.i(i3);
        return this.f175276t0;
    }

    private void Q2() {
        this.f175262f0 = (ImageView) findViewById(R.id.cjs);
        this.f175263g0 = (ImageView) findViewById(R.id.bow);
        this.f175264h0 = (ImageView) findViewById(R.id.f166822ig4);
        this.f175265i0 = (ImageView) findViewById(R.id.bew);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.common_weiyun_gray_disable));
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, getResources().getDrawable(R.drawable.common_weiyun_gray_normal));
        stateListDrawable.addState(new int[0], getResources().getDrawable(R.drawable.common_weiyun_gray_disable));
        com.tencent.mobileqq.filemanager.util.av.a(this.f175257a0, this.f175262f0, this.f175263g0, this.f175264h0, this.f175265i0);
        this.f175264h0.setImageDrawable(stateListDrawable);
        this.f175262f0.setOnClickListener(this);
        this.f175263g0.setOnClickListener(this);
        this.f175264h0.setOnClickListener(this);
        this.f175265i0.setOnClickListener(this);
        this.f175262f0.setEnabled(true);
        this.f175263g0.setEnabled(true);
        this.f175264h0.setEnabled(true);
        this.f175265i0.setEnabled(true);
    }

    private void Y2(List<ChatMessage> list) {
        if (list.size() == 1) {
            WeiyunAIOUtils.s(this.app, this, getTitleBarHeight(), list, this.f175279w0);
        } else {
            WeiyunAIOUtils.g(this.app, this, getTitleBarHeight(), list, this.f175279w0);
        }
        ReportController.o(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
    }

    private void Z2(String str, String str2, String str3, String str4, l lVar) {
        QQCustomDialog qQCustomDialog = this.B0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.B0.dismiss();
        }
        QQCustomDialog qQCustomDialog2 = new QQCustomDialog(this, R.style.qZoneInputDialog);
        qQCustomDialog2.setContentView(R.layout.f167856jn);
        this.B0 = qQCustomDialog2;
        qQCustomDialog2.setTitle(str);
        this.B0.setMessage(str2);
        if (TextUtils.isEmpty(str4)) {
            str4 = getString(R.string.cancel);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = getString(R.string.a8j);
        }
        this.B0.setNegativeButton(str4, new i(lVar));
        this.B0.setPositiveButton(str3, new j(lVar));
        this.B0.setCancelable(true);
        this.B0.setCanceledOnTouchOutside(false);
        this.B0.show();
    }

    boolean I2(int i3, List<ChatMessage> list, List<FileManagerEntity> list2, List<com.tencent.mobileqq.activity.aio.photo.f> list3, List<TencentDocData> list4) {
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        List<com.tencent.mobileqq.emotionintegrate.s> list5;
        boolean z28;
        List<ChatMessage> list6;
        boolean isCollectionNotEmpty = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(list4);
        if (list2 == null || list2.size() <= 0) {
            i16 = 0;
            i17 = 0;
        } else {
            i16 = list2.size() + 0;
            i17 = 1;
        }
        int i18 = i17;
        if (isCollectionNotEmpty) {
            i17++;
            i16 += list4.size();
        }
        if (list == null || list.size() <= 0) {
            z16 = false;
        } else {
            i17++;
            i16 += list.size();
            z16 = true;
        }
        List<com.tencent.mobileqq.emotionintegrate.s> list7 = this.f175270n0;
        if (list7 == null || list7.isEmpty()) {
            z17 = false;
        } else {
            if (i3 == 1) {
                Iterator<com.tencent.mobileqq.emotionintegrate.s> it = this.f175270n0.iterator();
                while (it.hasNext()) {
                    if (it.next().f205289a instanceof MessageForMarketFace) {
                    }
                }
                z17 = false;
                i17++;
                i16 += this.f175270n0.size();
            }
            z17 = true;
            i17++;
            i16 += this.f175270n0.size();
        }
        int i19 = 2;
        if (list3 != null) {
            Iterator<com.tencent.mobileqq.activity.aio.photo.f> it5 = list3.iterator();
            z18 = false;
            z19 = false;
            z26 = false;
            while (it5.hasNext()) {
                int g16 = com.tencent.mobileqq.activity.aio.photo.c.g(it5.next().f179735d);
                if (!z18 && g16 == 1) {
                    i17++;
                    z18 = true;
                }
                if (!z19 && g16 == i19) {
                    i17++;
                    z19 = true;
                }
                if (!z26 && g16 == 3) {
                    i17++;
                    z26 = true;
                }
                if (i3 != 1 && i17 >= 2) {
                    break;
                }
                i19 = 2;
            }
            i16 += list3.size();
        } else {
            z18 = false;
            z19 = false;
            z26 = false;
        }
        if (i16 == 0) {
            com.tencent.mobileqq.filemanager.util.d.c(R.string.b8i);
            return false;
        }
        if (i3 == 0) {
            boolean z29 = false;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QQToast.makeText(this, R.string.cjm, 1).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return false;
            }
            if (i17 > 1) {
                b3(getString(R.string.b8c));
                return false;
            }
            if (z26) {
                b3(getString(R.string.f170955b83));
                return false;
            }
            if (z19 && list3 != null && list3.size() > 1) {
                b3(getString(R.string.b8e));
                return false;
            }
            if (list2 != null) {
                if (list2.size() == 1 && list2.get(0).sendCloudUnsuccessful()) {
                    com.tencent.mobileqq.filemanager.util.d.e(R.string.b8q);
                    return false;
                }
                Iterator<FileManagerEntity> it6 = list2.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        z27 = false;
                        break;
                    }
                    if (kc1.a.c(it6.next()).c(z29)) {
                        z27 = true;
                        break;
                    }
                    z29 = false;
                }
                if (z27) {
                    FMDialogUtil.a(this, R.string.b_v, R.string.f170958ba0, new e(list2));
                } else {
                    FileManagerUtil.forwardRencentFiles(list2, this);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
            }
            if (isCollectionNotEmpty) {
                arrayList.addAll(((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).createChatMsgListFromTencentDocs(list4, this.f175272p0, null));
                FileManagerReporter.addData("0X8009AA1");
            }
            if (arrayList.size() == 1) {
                MessageForStructing messageForStructing = (MessageForStructing) arrayList.get(0);
                if (messageForStructing.structingMsg != null) {
                    Bundle bundle = new Bundle();
                    String str = messageForStructing.structingMsg.source_puin;
                    if (str != null && !"".equals(str)) {
                        bundle.putString("source_puin", messageForStructing.structingMsg.source_puin);
                    }
                    bundle.putInt("forward_type", -3);
                    AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                    absStructMsg.mCommentText = null;
                    bundle.putInt(AppConstants.Key.STRUCT_MSG_SERVICE_ID, absStructMsg.mMsgServiceID);
                    bundle.putByteArray(AppConstants.Key.STRUCT_MSG_BYTES, messageForStructing.structingMsg.getBytes());
                    bundle.putLong(AppConstants.Key.STRUCT_MSG_UNISEQ, messageForStructing.uniseq);
                    bundle.putInt("accostType", messageForStructing.structingMsg.sourceAccoutType);
                    bundle.putBoolean("forwardDirect", true);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.putExtra("forwardDirect", true);
                    ForwardBaseOption.startForwardActivityForResult(this, intent, 3);
                }
            }
            if (arrayList.size() > 1 || z17) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(arrayList);
                if (z17) {
                    Iterator<com.tencent.mobileqq.emotionintegrate.s> it7 = this.f175270n0.iterator();
                    while (it7.hasNext()) {
                        arrayList2.add((ChatMessage) it7.next().f205289a);
                    }
                }
                this.f175282z0 = z17;
                this.f175278v0.c(arrayList2);
            }
        } else if (i3 == 1) {
            if ((z18 || z19) && i18 != 0) {
                b3(getString(R.string.b8a));
                return false;
            }
            if (!z16 && !isCollectionNotEmpty && !z17) {
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FILE, QQPermissionConstants.Business.SCENE.QQ_FILE_AIO_FILE_DOWNLOAD));
                if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                    qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new f());
                    return false;
                }
                if (list2 != null) {
                    if (list2.size() == 1 && list2.get(0).sendCloudUnsuccessful()) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b8p);
                        return false;
                    }
                    long j3 = 0;
                    for (FileManagerEntity fileManagerEntity : list2) {
                        if (kc1.a.c(fileManagerEntity).c(true)) {
                            j3 += fileManagerEntity.fileSize;
                        }
                    }
                    FileManagerEngine fileManagerEngine = this.app.getFileManagerEngine();
                    if (FileManagerUtil.is2GOr3G() && j3 > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
                        FileManagerUtil.showFlowDialog(false, this, new g(list2, fileManagerEngine));
                    } else {
                        for (FileManagerEntity fileManagerEntity2 : list2) {
                            if (!fileManagerEntity2.sendCloudUnsuccessful()) {
                                fileManagerEngine.t0(fileManagerEntity2);
                            }
                        }
                    }
                }
                if ((list3 != null && list3.size() > 0) || (!z17 && (list5 = this.f175270n0) != null && !list5.isEmpty())) {
                    N2(list3, this.f175270n0);
                    return false;
                }
            } else {
                b3(getString(R.string.b8b));
                return false;
            }
        } else if (i3 == 2) {
            if ((list3 != null && this.f175271o0 != null) || ((list != null && list.size() > 0) || (list2 != null && list2.size() > 0))) {
                showProgressDialog();
            }
            if (list3 != null && (list6 = this.f175271o0) != null) {
                Y2(list6);
            }
            if (list != null) {
                Y2(list);
            } else if (list2 != null && list2.size() > 0) {
                boolean z36 = false;
                list2.get(0);
                FileManagerEngine fileManagerEngine2 = this.app.getFileManagerEngine();
                if (list2.size() == 1 && list2.get(0).sendCloudUnsuccessful()) {
                    com.tencent.mobileqq.filemanager.util.d.e(R.string.b8r);
                    return false;
                }
                Iterator<FileManagerEntity> it8 = list2.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        z28 = false;
                        break;
                    }
                    if (kc1.a.c(it8.next()).c(z36)) {
                        z28 = true;
                        break;
                    }
                    z36 = false;
                }
                if (z28) {
                    FMDialogUtil.a(this, R.string.b_v, R.string.b_y, new h(list2, fileManagerEngine2));
                } else {
                    boolean z37 = false;
                    for (FileManagerEntity fileManagerEntity3 : list2) {
                        if (!fileManagerEntity3.sendCloudUnsuccessful()) {
                            if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity3.getFilePath())) {
                                fileManagerEngine2.F0(fileManagerEntity3.getFilePath(), "", this.app.getCurrentAccountUin(), "", 0, false);
                            } else {
                                fileManagerEngine2.v0(fileManagerEntity3, String.valueOf(fileManagerEntity3.peerUin));
                            }
                            z37 = true;
                        }
                    }
                    if (z37) {
                        com.tencent.mobileqq.filemanager.util.d.d(getString(R.string.f170978be3));
                    } else {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.b8r);
                        MqqHandler mqqHandler = this.f175279w0;
                        if (mqqHandler != null) {
                            mqqHandler.sendEmptyMessage(105);
                        }
                    }
                }
            }
        } else if (i3 == 3) {
            ArrayList arrayList3 = new ArrayList();
            if (list2 != null && list2.size() > 0) {
                for (FileManagerEntity fileManagerEntity4 : list2) {
                    MessageRecord w06 = this.app.getMessageFacade().w0(fileManagerEntity4.peerUin, fileManagerEntity4.peerType, fileManagerEntity4.uniseq);
                    if (w06 != null) {
                        arrayList3.add((ChatMessage) w06);
                    }
                }
            }
            if (list != null && list.size() > 0) {
                arrayList3.addAll(list);
            }
            List<com.tencent.mobileqq.emotionintegrate.s> list8 = this.f175270n0;
            if (list8 != null && !list8.isEmpty()) {
                Iterator<com.tencent.mobileqq.emotionintegrate.s> it9 = this.f175270n0.iterator();
                while (it9.hasNext()) {
                    arrayList3.add((ChatMessage) it9.next().f205289a);
                }
            }
            if ((arrayList3.size() != 0 || list2 != null || isCollectionNotEmpty) && (arrayList3.size() > 0 || ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(list2) || isCollectionNotEmpty)) {
                ThreadManagerV2.post(new AnonymousClass7(arrayList3, list2, isCollectionNotEmpty, list4), 8, null, true);
            }
        }
        return true;
    }

    public void J2(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) chatMessage);
            return;
        }
        if (this.f175266j0 == null) {
            this.f175266j0 = new ArrayList();
        }
        this.f175266j0.add(chatMessage);
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryStruct", 2, "addselect, size: " + this.f175266j0.size());
        }
    }

    public void K2(TencentDocData tencentDocData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) tencentDocData);
            return;
        }
        if (this.f175269m0 == null) {
            this.f175269m0 = new ArrayList();
        }
        this.f175269m0.add(tencentDocData);
    }

    public void L2(com.tencent.mobileqq.emotionintegrate.s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) sVar);
            return;
        }
        if (this.f175270n0 == null) {
            this.f175270n0 = new ArrayList();
        }
        this.f175270n0.add(sVar);
    }

    public void M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        boolean z16 = !this.f175259c0;
        this.f175259c0 = z16;
        if (z16) {
            this.f175257a0.setVisibility(0);
            this.f175258b0.setVisibility(0);
            this.f175260d0.b();
            setRightButton(R.string.cancel, this);
            return;
        }
        this.f175257a0.setVisibility(8);
        this.f175258b0.setVisibility(8);
        this.f175260d0.a();
        setRightButton(R.string.f170286ld, this);
        this.f175269m0 = null;
        this.f175268l0 = null;
        this.f175266j0 = null;
        this.f175267k0 = null;
        this.f175271o0 = null;
        List<com.tencent.mobileqq.emotionintegrate.s> list = this.f175270n0;
        if (list != null && !list.isEmpty()) {
            Iterator<com.tencent.mobileqq.emotionintegrate.s> it = this.f175270n0.iterator();
            while (it.hasNext()) {
                it.next().f205290b = false;
            }
            this.f175270n0.clear();
        }
    }

    public boolean R2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        List<ChatMessage> list = this.f175266j0;
        boolean z16 = false;
        if (list != null) {
            i3 = list.size() + 0;
        } else {
            i3 = 0;
        }
        List<FileManagerEntity> list2 = this.f175267k0;
        if (list2 != null) {
            i3 += list2.size();
        }
        List<com.tencent.mobileqq.activity.aio.photo.f> list3 = this.f175268l0;
        if (list3 != null) {
            i3 += list3.size();
        }
        List<TencentDocData> list4 = this.f175269m0;
        if (list4 != null) {
            i3 += list4.size();
        }
        List<com.tencent.mobileqq.emotionintegrate.s> list5 = this.f175270n0;
        if (list5 != null) {
            i3 += list5.size();
        }
        if (i3 >= 20) {
            z16 = true;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatHistoryFIleActivity", 2, "isOverLimit");
            }
            com.tencent.mobileqq.filemanager.util.d.e(R.string.b8l);
        }
        return z16;
    }

    public boolean S2(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) chatMessage)).booleanValue();
        }
        List<ChatMessage> list = this.f175266j0;
        if (list == null) {
            return false;
        }
        return list.contains(chatMessage);
    }

    public boolean T2(TencentDocData tencentDocData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) tencentDocData)).booleanValue();
        }
        List<TencentDocData> list = this.f175269m0;
        if (list != null && list.contains(tencentDocData)) {
            return true;
        }
        return false;
    }

    public void U2(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) chatMessage);
            return;
        }
        List<ChatMessage> list = this.f175266j0;
        if (list == null) {
            return;
        }
        list.remove(chatMessage);
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryStruct", 2, "removeselect, size: " + this.f175266j0.size());
        }
    }

    public void V2(TencentDocData tencentDocData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) tencentDocData);
            return;
        }
        List<TencentDocData> list = this.f175269m0;
        if (list == null) {
            return;
        }
        list.remove(tencentDocData);
    }

    public void W2(com.tencent.mobileqq.emotionintegrate.s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) sVar);
            return;
        }
        List<com.tencent.mobileqq.emotionintegrate.s> list = this.f175270n0;
        if (list == null) {
            return;
        }
        list.remove(sVar);
    }

    public void addSelected(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fileManagerEntity);
            return;
        }
        if (this.f175267k0 == null) {
            this.f175267k0 = new ArrayList();
        }
        this.f175267k0.add(fileManagerEntity);
    }

    public void b3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            return;
        }
        if (this.f175280x0 == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            this.f175280x0 = createCustomDialog;
            createCustomDialog.setNegativeButton(R.string.hkf, new b());
        }
        if (!this.f175280x0.isShowing()) {
            this.f175280x0.setMessage(str);
        } else {
            this.f175280x0.dismiss();
        }
        try {
            this.f175280x0.show();
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 == 98) {
                        M2();
                    }
                } else if (!this.f175282z0) {
                    this.f175278v0.h(intent);
                }
            } else {
                Intent intent2 = new Intent(this, (Class<?>) SendPhotoActivity.class);
                Bundle bundle = new Bundle(intent.getExtras());
                if (QLog.isColorLevel()) {
                    QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
                }
                bundle.putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
                bundle.putInt(PeakConstants.SEND_BUSINESS_TYPE, 1031);
                intent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
                Intent m3 = BaseAIOUtils.m(intent2, null);
                m3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                bundle.putBoolean("PicContants.NEED_COMPRESS", false);
                bundle.putBoolean(PeakConstants.SEND_IN_BACKGROUND, false);
                m3.putExtras(bundle);
                startActivity(m3);
            }
        }
        if (i3 == 1) {
            M2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        this.f175272p0 = intent.getStringExtra("uin");
        int i3 = 0;
        this.f175273q0 = intent.getIntExtra("uintype", 0);
        this.f175274r0 = intent.getStringExtra("uinname");
        setContentView(R.layout.f167721f2);
        setTitle(R.string.a0v);
        if (intent.getStringExtra(AppConstants.LeftViewText.LEFTVIEWTEXT) == null) {
            setLeftViewName(R.string.close);
        } else {
            setLeftViewName(intent);
        }
        TabBarView tabBarView = (TabBarView) findViewById(R.id.j_x);
        tabBarView.c(0, HardCodeUtil.qqStr(R.string.kek));
        tabBarView.c(1, HardCodeUtil.qqStr(R.string.f171724kf4));
        tabBarView.c(2, HardCodeUtil.qqStr(R.string.keu));
        tabBarView.c(3, HardCodeUtil.qqStr(R.string.kd6));
        tabBarView.c(4, HardCodeUtil.qqStr(R.string.f171723kf3));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.imd);
        this.f175257a0 = linearLayout;
        linearLayout.setVisibility(8);
        this.f175258b0 = (FrameLayout) findViewById(R.id.jso);
        this.f175257a0.setVisibility(8);
        this.f175258b0.setVisibility(8);
        setRightButton(R.string.f170286ld, this);
        Q2();
        this.f175261e0 = (RelativeLayout) findViewById(R.id.elg);
        tabBarView.setOnTabChangeListener(new c());
        String stringExtra = intent.getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
        try {
            i3 = Integer.parseInt(stringExtra);
        } catch (NumberFormatException unused) {
            QLog.e("ChatHistoryFIleActivity", 1, "extra KEY_INITIAL_TAB " + stringExtra + " is not number");
        }
        tabBarView.setSelectedTab(i3, true);
        com.tencent.mobileqq.activity.chathistory.b bVar = new com.tencent.mobileqq.activity.chathistory.b(this, 3);
        this.f175278v0 = bVar;
        bVar.f();
        com.tencent.mobileqq.activity.aio.photo.b.d().a(this);
        if (this.C0 == null) {
            this.C0 = new k();
        }
        this.app.getFileManagerNotifyCenter().addObserver(this.C0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.f175278v0.g();
        ChatHistoryEmotionView chatHistoryEmotionView = this.f175277u0;
        if (chatHistoryEmotionView != null) {
            chatHistoryEmotionView.q();
        }
        if (this.C0 != null) {
            this.app.getFileManagerNotifyCenter().deleteObserver(this.C0);
        }
        com.tencent.mobileqq.activity.aio.photo.b.d().f(this);
    }

    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4 && this.f175259c0) {
            M2();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.doOnPause();
        ChatHistoryViewBase chatHistoryViewBase = this.f175260d0;
        if (chatHistoryViewBase != null) {
            chatHistoryViewBase.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.doOnResume();
        ChatHistoryViewBase chatHistoryViewBase = this.f175260d0;
        if (chatHistoryViewBase != null) {
            chatHistoryViewBase.i(this.f175281y0);
            this.f175260d0.d();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 2) {
            switch (i3) {
                case 103:
                    Dialog dialog = this.A0;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    ((IWeiyunSaveTipsHelper) QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.app, this, getTitleBarHeight());
                    break;
                case 104:
                    Dialog dialog2 = this.A0;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                    int i16 = message.arg1;
                    if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i16)) {
                        if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips(i16)) {
                            getString(R.string.cpi);
                            if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(i16)) {
                                getString(R.string.cpi);
                                str = getString(R.string.b0p);
                            } else if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).isFlowOverErrorCode(i16)) {
                                getString(R.string.cpi);
                                str = getString(R.string.b0n);
                            } else {
                                str = "";
                            }
                            a aVar = new a();
                            Z2(getString(R.string.f171492fd3), str, null, null, aVar);
                            break;
                        } else {
                            QQToast.makeText(this.app.getApp(), (String) message.obj, 1).show(getTitleBarHeight());
                            break;
                        }
                    }
                    break;
                case 105:
                    Dialog dialog3 = this.A0;
                    if (dialog3 != null) {
                        dialog3.dismiss();
                        break;
                    }
                    break;
            }
        } else {
            ChatHistoryStructMsgView chatHistoryStructMsgView = this.f175275s0;
            if (chatHistoryStructMsgView != null) {
                chatHistoryStructMsgView.m(this.f175266j0);
            }
            ChatHistoryEmotionView chatHistoryEmotionView = this.f175277u0;
            if (chatHistoryEmotionView != null) {
                chatHistoryEmotionView.s();
            }
            M2();
            P2(this.f175281y0);
        }
        return true;
    }

    public boolean isSelected(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) fileManagerEntity)).booleanValue();
        }
        List<FileManagerEntity> list = this.f175267k0;
        if (list == null) {
            return false;
        }
        return list.contains(fileManagerEntity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        finish();
        if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
            overridePendingTransition(0, R.anim.f155066i1);
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnRightText) {
                M2();
                if (this.f175259c0) {
                    ReportController.o(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.cjs) {
                if (I2(0, this.f175266j0, this.f175267k0, this.f175268l0, this.f175269m0)) {
                    M2();
                }
                ReportController.o(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
            } else if (id5 == R.id.bow) {
                if (I2(1, this.f175266j0, this.f175267k0, this.f175268l0, this.f175269m0)) {
                    M2();
                }
                ReportController.o(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
            } else if (id5 == R.id.f166822ig4) {
                if (I2(2, this.f175266j0, this.f175267k0, this.f175268l0, this.f175269m0)) {
                    M2();
                }
                ReportController.o(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
            } else if (id5 == R.id.bew) {
                ReportController.o(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
                List<ChatMessage> list = this.f175266j0;
                int i3 = 0;
                if (list != null) {
                    i3 = 0 + list.size();
                }
                List<FileManagerEntity> list2 = this.f175267k0;
                if (list2 != null) {
                    i3 += list2.size();
                }
                List<com.tencent.mobileqq.activity.aio.photo.f> list3 = this.f175268l0;
                if (list3 != null) {
                    i3 += list3.size();
                }
                List<TencentDocData> list4 = this.f175269m0;
                if (list4 != null) {
                    i3 += list4.size();
                }
                List<com.tencent.mobileqq.emotionintegrate.s> list5 = this.f175270n0;
                if (list5 != null) {
                    i3 += list5.size();
                }
                if (i3 == 0) {
                    com.tencent.mobileqq.filemanager.util.d.c(R.string.b8i);
                } else {
                    ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
                    actionSheet.setMainTitle(R.string.dq9);
                    actionSheet.addButton(getString(R.string.b5u), 3);
                    actionSheet.addCancelButton(R.string.cancel);
                    actionSheet.setOnButtonClickListener(new d(actionSheet));
                    actionSheet.show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void removeSelected(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) fileManagerEntity);
            return;
        }
        List<FileManagerEntity> list = this.f175267k0;
        if (list == null) {
            return;
        }
        list.remove(fileManagerEntity);
    }

    void showProgressDialog() {
        if (this.A0 == null) {
            ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.qZoneInputDialog);
            this.A0 = reportDialog;
            reportDialog.setCanceledOnTouchOutside(false);
            this.A0.setContentView(R.layout.f168383uh);
        }
        TextView textView = (TextView) this.A0.findViewById(R.id.photo_prievew_progress_dialog_text);
        textView.setText(textView.getResources().getString(R.string.f170237js));
        if (!this.A0.isShowing()) {
            try {
                this.A0.show();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.g
    public void v5(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, j3);
            return;
        }
        ChatHistoryViewBase chatHistoryViewBase = this.f175260d0;
        if (chatHistoryViewBase != null) {
            chatHistoryViewBase.h(j3);
        }
    }

    private void N2(List<com.tencent.mobileqq.activity.aio.photo.f> list, List<com.tencent.mobileqq.emotionintegrate.s> list2) {
    }
}
