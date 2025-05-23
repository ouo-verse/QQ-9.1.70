package com.tencent.mobileqq.filemanager.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileSendBarManager extends e {

    /* renamed from: g, reason: collision with root package name */
    private TextView f209429g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f209430h;

    /* renamed from: i, reason: collision with root package name */
    private QQProgressDialog f209431i;

    /* renamed from: j, reason: collision with root package name */
    private int f209432j;

    /* renamed from: k, reason: collision with root package name */
    private String f209433k;

    /* renamed from: l, reason: collision with root package name */
    private String f209434l;

    /* renamed from: m, reason: collision with root package name */
    private int f209435m;

    /* renamed from: n, reason: collision with root package name */
    private String f209436n;

    /* renamed from: o, reason: collision with root package name */
    private View.OnClickListener f209437o;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            QFileSendBarManager qFileSendBarManager = QFileSendBarManager.this;
            if (qFileSendBarManager.f209540e) {
                if (qFileSendBarManager.f209435m == 1) {
                    i3 = 2;
                } else if (QFileSendBarManager.this.f209435m == 0) {
                    i3 = 1;
                } else {
                    i3 = 4;
                }
                if (QFileSendBarManager.this.f209433k != null && QFileSendBarManager.this.f209433k.equals(AppConstants.DATALINE_PC_UIN)) {
                    i3 = 3;
                }
                ReportController.o(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i3, 0, "" + ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount(), "0", "", "");
                if (QFileSendBarManager.this.f209435m == 1101) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    arrayList.addAll(((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
                    Intent intent = new Intent();
                    intent.putExtra("file_choose_search_result_code", "file_choose_search_result_code");
                    intent.putParcelableArrayListExtra("reslut_select_file_info_list", arrayList);
                    Activity activity = (Activity) QFileSendBarManager.this.f209536a;
                    activity.setResult(-1, intent);
                    activity.finish();
                } else if (QFileSendBarManager.this.f209435m == 1) {
                    QFileSendBarManager.this.p();
                } else {
                    QFileSendBarManager.this.o();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                QFileSendBarManager.this.r();
            }
            dialogInterface.dismiss();
        }
    }

    public QFileSendBarManager(QQAppInterface qQAppInterface, Context context, QFileSendBottomView qFileSendBottomView) {
        super(qQAppInterface, context, qFileSendBottomView);
        this.f209437o = new a();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            QQProgressDialog qQProgressDialog = this.f209431i;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f209431i.cancel();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!AppNetConnInfo.isNetSupport()) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.cgc);
        } else if (FileManagerUtil.is2GOr3G() && ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedLocalFileSize() > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FileManagerUtil.showFlowDialog(true, this.f209536a, new b(), this.f209435m);
        } else {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (TroopFileUtils.c(this.f209536a) == 0) {
            Context context = this.f209536a;
            TroopFileError.k(context, context.getString(R.string.ers));
            r();
        } else {
            if (FileManagerUtil.is2GOr3G()) {
                c cVar = new c();
                String string = this.f209536a.getString(R.string.emi);
                Context context2 = this.f209536a;
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context2, 230, context2.getString(R.string.erp), string, R.string.cancel, R.string.ewn, cVar, cVar);
                if (KingCardProcessor.get().group.enable && !TMSManager.e().h()) {
                    createCustomDialog.setMessageWithoutAutoLink(KingCardProcessor.get().group.appendKingcardString(this.f209536a, string));
                }
                createCustomDialog.show();
                return;
            }
            r();
        }
    }

    private void q() {
        this.f209429g = (TextView) this.f209538c.b(R.id.imy);
        this.f209430h = (TextView) this.f209538c.b(R.id.fa_);
        this.f209429g.setOnClickListener(this.f209437o);
    }

    private void s(int i3) {
        if (this.f209431i != null) {
            n();
        } else {
            if (BaseActivity.sTopActivity == null) {
                return;
            }
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            QQProgressDialog qQProgressDialog = new QQProgressDialog(baseActivity, baseActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.f209431i = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
            this.f209431i.setMessage(HardCodeUtil.qqStr(R.string.taw));
            this.f209431i.show();
        }
        if (!this.f209431i.isShowing()) {
            this.f209431i.show();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.widget.e
    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.f209540e) {
            this.f209432j = this.f209539d.getInt("qfile_search_param_exparams_busi_type");
            this.f209433k = this.f209539d.getString("qfile_search_param_ex_params_target_uin");
            this.f209434l = this.f209539d.getString("qfile_search_param_ex_params_target_uid");
            this.f209435m = this.f209539d.getInt("qfile_search_param_exparams_peer_type", -1);
            this.f209436n = this.f209539d.getString("qfile_search_param_exparams_send_uin");
        }
        if (bundle != null && bundle.getInt("file_choose_extension_handle_type", -1) == 1) {
            this.f209435m = 1101;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.widget.e
    public void e() {
        super.e();
    }

    @Override // com.tencent.mobileqq.filemanager.widget.e
    public void f() {
        String str;
        boolean z16;
        String str2 = this.f209536a.getString(R.string.f170945b73) + this.f209536a.getString(R.string.b_3) + ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount() + this.f209536a.getString(R.string.b_4);
        long selectedFileSize = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedFileSize();
        if (selectedFileSize > 0) {
            str = this.f209536a.getString(R.string.f170943b71) + q.g(selectedFileSize);
        } else {
            str = "";
        }
        if (((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCloudFileSize() > 0 && !ah.a1(this.f209536a)) {
            str = str + this.f209536a.getString(R.string.f170944b72) + q.g(((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCloudFileSize());
        }
        if (this.f209435m == 1101) {
            str2 = this.f209536a.getResources().getString(R.string.f171151ok);
            str = this.f209536a.getString(R.string.f170943b71) + this.f209536a.getString(R.string.b_3) + ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount() + this.f209536a.getString(R.string.b_4);
        }
        this.f209429g.setText(str2);
        TextView textView = this.f209429g;
        if (((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        textView.setEnabled(z16);
        this.f209430h.setText(str);
    }

    public void r() {
        s(R.string.cva);
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.4

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.filemanager.widget.QFileSendBarManager$4$a */
            /* loaded from: classes12.dex */
            class a extends AsyncTask<Void, Void, Void> {
                a() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    String str = QFileSendBarManager.this.f209433k;
                    String str2 = QFileSendBarManager.this.f209436n;
                    int i3 = QFileSendBarManager.this.f209435m;
                    if (i3 == 5) {
                        return null;
                    }
                    if (i3 == 6002) {
                        ArrayList<FileInfo> arrayList = new ArrayList<>();
                        arrayList.addAll(((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
                        ((RouterHandler) QFileSendBarManager.this.f209537b.getBusinessHandler(BusinessHandlerFactory.ROUTER_HANDLER)).sendFilesWithService(arrayList, null, null, Long.parseLong(str));
                    } else {
                        com.tencent.xaction.log.b.a("QFileSendBarManager", 1, "sendAllSelectedFiles sourceUin: " + str2 + " ,targetUin: " + str + " ,mSendTargetUid: " + QFileSendBarManager.this.f209434l + " ,peerType: " + i3);
                        QFileSendBarManager.this.f209537b.getFileManagerEngine().y0(false, str2, str, QFileSendBarManager.this.f209434l, i3);
                    }
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(Void r26) {
                    super.onPostExecute(r26);
                    QFileSendBarManager.this.n();
                    ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).clearSelected();
                    QFileSendBarManager.this.c(null);
                }
            }

            @Override // java.lang.Runnable
            @SuppressLint({"StaticFieldLeak"})
            public void run() {
                new a().execute(new Void[0]);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements FMDialogUtil.c {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            QFileSendBarManager.this.r();
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
