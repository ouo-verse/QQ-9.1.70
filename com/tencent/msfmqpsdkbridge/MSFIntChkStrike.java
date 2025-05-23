package com.tencent.msfmqpsdkbridge;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mqpsdk.secsrv.a;
import com.tencent.mqpsdk.secsrv.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MSFIntChkStrike implements b.a {
    static IPatchRedirector $redirector_ = null;
    private static final int BTN_ACTION_BROWSER = 5;
    private static final int BTN_ACTION_BROWSER_AND_LOGOUT = 6;
    private static final int BTN_ACTION_CLOSE = 1;
    private static final int BTN_ACTION_DOWNLOADMANAGER = 7;
    private static final int BTN_ACTION_DOWNLOADMANAGER_AND_LOGOUT = 8;
    private static final int BTN_ACTION_LOGOUT = 2;
    private static final int BTN_ACTION_QQDOWNLOADER = 3;
    private static final int BTN_ACTION_QQDOWNLOADER_AND_LOGOUT = 3;
    private QQAppInterface mApp;
    private long mDownloadReference;
    private int mNetworkFlags;
    private String mPackageDownloadURL;
    private String mPackageName;
    private a mResultListener;
    private int mStrikeResult;
    private int mStrikeType;
    private boolean mToastAlreadyShown;

    public MSFIntChkStrike(QQAppInterface qQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, i3);
            return;
        }
        this.mResultListener = null;
        this.mStrikeResult = 0;
        this.mDownloadReference = 0L;
        this.mNetworkFlags = 0;
        this.mToastAlreadyShown = false;
        this.mPackageDownloadURL = "";
        this.mPackageName = "MQPINTCHK";
        this.mApp = qQAppInterface;
        this.mStrikeType = i3;
    }

    @SuppressLint({"NewApi"})
    private void jumpToTMAssistantDownload() {
        BaseApplication context = BaseApplication.getContext();
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        if (downloadManager == null) {
            this.mStrikeResult = 30;
            return;
        }
        this.mStrikeResult = 31;
        context.registerReceiver(new BroadcastReceiver(downloadManager) { // from class: com.tencent.msfmqpsdkbridge.MSFIntChkStrike.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ DownloadManager val$downloader;

            {
                this.val$downloader = downloadManager;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MSFIntChkStrike.this, (Object) downloadManager);
                }
            }

            @Override // android.content.BroadcastReceiver
            @SuppressLint({"NewApi"})
            public void onReceive(Context context2, Intent intent) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context2, (Object) intent);
                    return;
                }
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                if (MSFIntChkStrike.this.mDownloadReference == longExtra) {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(longExtra);
                    Cursor cursor = null;
                    try {
                        cursor = this.val$downloader.query(query);
                        if (cursor != null && cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex("local_filename"));
                        } else {
                            str = "";
                        }
                        if (TextUtils.isEmpty(str)) {
                            FileManagerUtil.installApkFile(context2, str);
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        }, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.mPackageDownloadURL));
            request.setTitle(this.mPackageName);
            int i3 = this.mNetworkFlags;
            if (i3 != 0) {
                request.setAllowedNetworkTypes(i3);
            }
            this.mDownloadReference = downloadManager.enqueue(request);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:52:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBtnAction(android.content.DialogInterface r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msfmqpsdkbridge.MSFIntChkStrike.onBtnAction(android.content.DialogInterface, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0184  */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v7, types: [org.json.JSONObject] */
    @Override // com.tencent.mqpsdk.secsrv.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void exec(String str, a aVar) {
        int i3;
        ?? r26;
        String str2;
        String str3;
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (this.mApp == null) {
            return;
        }
        int i16 = this.mStrikeType;
        String str4 = null;
        if (i16 == 1) {
            if (TextUtils.isEmpty(str) || this.mToastAlreadyShown) {
                return;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (jSONObject.has("toast_config")) {
                str2 = jSONObject.getString("toast_config");
                if (!TextUtils.isEmpty(str2)) {
                    return;
                }
                if (aVar != null) {
                    this.mResultListener = aVar;
                }
                try {
                    Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str2.getBytes())).getDocumentElement();
                    NodeList elementsByTagName = documentElement.getElementsByTagName("title");
                    if (elementsByTagName.getLength() == 0) {
                        return;
                    }
                    String attribute = ((Element) elementsByTagName.item(0)).getAttribute(TPReportParams.JSON_KEY_VAL);
                    NodeList elementsByTagName2 = documentElement.getElementsByTagName("wording");
                    if (elementsByTagName2.getLength() == 0) {
                        return;
                    }
                    String attribute2 = ((Element) elementsByTagName2.item(0)).getAttribute(TPReportParams.JSON_KEY_VAL);
                    NodeList elementsByTagName3 = documentElement.getElementsByTagName("package_url");
                    if (elementsByTagName3.getLength() != 0) {
                        this.mPackageDownloadURL = ((Element) elementsByTagName3.item(0)).getAttribute(TPReportParams.JSON_KEY_VAL);
                    }
                    NodeList elementsByTagName4 = documentElement.getElementsByTagName("package_name");
                    if (elementsByTagName4.getLength() != 0) {
                        this.mPackageName = ((Element) elementsByTagName4.item(0)).getAttribute(TPReportParams.JSON_KEY_VAL);
                    }
                    NodeList elementsByTagName5 = documentElement.getElementsByTagName("network_types");
                    if (elementsByTagName5.getLength() != 0) {
                        int parseInt = Integer.parseInt(((Element) elementsByTagName5.item(0)).getAttribute(TPReportParams.JSON_KEY_VAL));
                        this.mNetworkFlags = parseInt;
                        if (parseInt >= 3) {
                            this.mNetworkFlags = 0;
                        }
                    }
                    NodeList elementsByTagName6 = documentElement.getElementsByTagName("btn_confirm");
                    String str5 = "";
                    if (elementsByTagName6.getLength() <= 0) {
                        str3 = "";
                        onClickListener = null;
                    } else {
                        Element element = (Element) elementsByTagName6.item(0);
                        String attribute3 = element.getAttribute("text");
                        onClickListener = new DialogInterface.OnClickListener(Integer.parseInt(element.getAttribute("action"))) { // from class: com.tencent.msfmqpsdkbridge.MSFIntChkStrike.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ int val$nAction;

                            {
                                this.val$nAction = r5;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MSFIntChkStrike.this, r5);
                                }
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i17) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    MSFIntChkStrike.this.onBtnAction(dialogInterface, i17, this.val$nAction);
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i17);
                                }
                            }
                        };
                        str3 = attribute3;
                    }
                    NodeList elementsByTagName7 = documentElement.getElementsByTagName("btn_cancel");
                    if (elementsByTagName7.getLength() > 0) {
                        Element element2 = (Element) elementsByTagName7.item(0);
                        str5 = element2.getAttribute("text");
                        onClickListener2 = new DialogInterface.OnClickListener(Integer.parseInt(element2.getAttribute("action"))) { // from class: com.tencent.msfmqpsdkbridge.MSFIntChkStrike.2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ int val$nAction;

                            {
                                this.val$nAction = r5;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MSFIntChkStrike.this, r5);
                                }
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i17) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    MSFIntChkStrike.this.onBtnAction(dialogInterface, i17, this.val$nAction);
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i17);
                                }
                            }
                        };
                    } else {
                        onClickListener2 = null;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable(attribute, attribute2, onClickListener, onClickListener2, str5, str3, new DialogInterface.OnDismissListener() { // from class: com.tencent.msfmqpsdkbridge.MSFIntChkStrike.3
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MSFIntChkStrike.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                MSFIntChkStrike.this.mToastAlreadyShown = false;
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface);
                            }
                        }
                    }) { // from class: com.tencent.msfmqpsdkbridge.MSFIntChkStrike.4
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ DialogInterface.OnClickListener val$fonCancel;
                        final /* synthetic */ DialogInterface.OnClickListener val$fonConfirm;
                        final /* synthetic */ DialogInterface.OnDismissListener val$fonDismissListener;
                        final /* synthetic */ String val$fstrCancelText;
                        final /* synthetic */ String val$fstrConfirmText;
                        final /* synthetic */ String val$fstrTitle;
                        final /* synthetic */ String val$fstrWording;

                        {
                            this.val$fstrTitle = attribute;
                            this.val$fstrWording = attribute2;
                            this.val$fonConfirm = onClickListener;
                            this.val$fonCancel = onClickListener2;
                            this.val$fstrCancelText = str5;
                            this.val$fstrConfirmText = str3;
                            this.val$fonDismissListener = r12;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, MSFIntChkStrike.this, attribute, attribute2, onClickListener, onClickListener2, str5, str3, r12);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            QQCustomDialog createCustomDialog;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                createCustomDialog = DialogUtil.createCustomDialog(BaseActivity.sTopActivity, 230, this.val$fstrTitle, this.val$fstrWording, this.val$fonConfirm, this.val$fonCancel);
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                            if (createCustomDialog == null) {
                                return;
                            }
                            createCustomDialog.setNegativeButton(this.val$fstrCancelText, this.val$fonCancel);
                            createCustomDialog.setPositiveButton(this.val$fstrConfirmText, this.val$fonConfirm);
                            createCustomDialog.setOnDismissListener(this.val$fonDismissListener);
                            createCustomDialog.setCancelable(false);
                            createCustomDialog.show();
                            MSFIntChkStrike.this.mToastAlreadyShown = true;
                        }
                    });
                    return;
                } catch (Exception e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
            }
        } else {
            if (i16 == 2) {
                if (aVar != null) {
                    try {
                        ?? jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("strike_result", 5);
                            r26 = jSONObject2;
                        } catch (Exception e18) {
                            e = e18;
                            str4 = jSONObject2;
                            e.printStackTrace();
                            r26 = str4;
                            if (r26 != 0) {
                            }
                            this.mApp.exit(false);
                            return;
                        }
                    } catch (Exception e19) {
                        e = e19;
                    }
                    if (r26 != 0) {
                        aVar.b(r26.toString());
                    }
                }
                this.mApp.exit(false);
                return;
            }
            if (i16 != 3 || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject3 = new JSONObject(str);
                if (jSONObject3.has("launch_package_name")) {
                    str4 = jSONObject3.getString("launch_package_name");
                }
            } catch (Exception e26) {
                e26.printStackTrace();
            }
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            Context applicationContext = this.mApp.getApp().getApplicationContext();
            if (!PackageUtil.isAppInstalled(applicationContext, str4)) {
                i3 = 11;
            } else if (PackageUtil.startAppWithPkgName(applicationContext, str4, this.mApp.getCurrentAccountUin())) {
                i3 = 13;
            } else {
                i3 = 12;
            }
            if (aVar != null) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("strike_result", i3);
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
                aVar.b(jSONObject4.toString());
            }
        }
    }
}
