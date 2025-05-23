package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.troop.file.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.troop.utils.f;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class TroopFileZipPreviewActivity extends IphoneTitleBarActivity {

    /* renamed from: a0, reason: collision with root package name */
    ForwardFileInfo f206327a0;

    /* renamed from: b0, reason: collision with root package name */
    int f206328b0;

    /* renamed from: c0, reason: collision with root package name */
    long f206329c0;

    /* renamed from: d0, reason: collision with root package name */
    int f206330d0;

    /* renamed from: e0, reason: collision with root package name */
    String f206331e0;

    /* renamed from: f0, reason: collision with root package name */
    String f206332f0;

    /* renamed from: g0, reason: collision with root package name */
    String f206333g0;

    /* renamed from: h0, reason: collision with root package name */
    String f206334h0;

    /* renamed from: i0, reason: collision with root package name */
    String f206335i0;

    /* renamed from: j0, reason: collision with root package name */
    XListView f206336j0;

    /* renamed from: k0, reason: collision with root package name */
    com.tencent.biz.troop.file.b f206337k0;

    /* renamed from: l0, reason: collision with root package name */
    Context f206338l0;

    /* renamed from: p0, reason: collision with root package name */
    String f206342p0;

    /* renamed from: m0, reason: collision with root package name */
    List<ZipFilePresenter.f> f206339m0 = new ArrayList();

    /* renamed from: n0, reason: collision with root package name */
    long f206340n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    boolean f206341o0 = false;

    /* renamed from: q0, reason: collision with root package name */
    short f206343q0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    private FMObserver f206344r0 = new d();

    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f206345d;

        a(FileManagerEntity fileManagerEntity) {
            this.f206345d = fileManagerEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            TroopFileZipPreviewActivity.this.setResult(-1, intent);
            TroopFileZipPreviewActivity.super.finish();
            ReportController.o(TroopFileZipPreviewActivity.this.app, "dc00899", "Grp_files", null, "oper", "pre_arc_close", 0, 0, "" + this.f206345d.TroopUin, "", "", "1");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f206347a;

        b(FileManagerEntity fileManagerEntity) {
            this.f206347a = fileManagerEntity;
        }

        @Override // com.tencent.biz.troop.file.a.b
        public void a(List<ZipFilePresenter.f> list) {
            TroopFileZipPreviewActivity.this.stopTitleProgress();
            if (list != null) {
                TroopFileZipPreviewActivity troopFileZipPreviewActivity = TroopFileZipPreviewActivity.this;
                troopFileZipPreviewActivity.f206339m0 = list;
                troopFileZipPreviewActivity.f206337k0 = new com.tencent.biz.troop.file.b(list, TroopFileZipPreviewActivity.this);
                TroopFileZipPreviewActivity.this.f206337k0.C = TroopFileZipPreviewActivity.this.f206335i0 + "/";
                TroopFileZipPreviewActivity troopFileZipPreviewActivity2 = TroopFileZipPreviewActivity.this;
                com.tencent.biz.troop.file.b bVar = troopFileZipPreviewActivity2.f206337k0;
                bVar.E = troopFileZipPreviewActivity2.f206340n0;
                bVar.D = this.f206347a.TroopUin;
                bVar.f96849h = troopFileZipPreviewActivity2.f206332f0;
                bVar.f96850i = troopFileZipPreviewActivity2.f206333g0;
                bVar.f96851m = troopFileZipPreviewActivity2.f206334h0;
                bVar.f96848f = troopFileZipPreviewActivity2.f206331e0;
                bVar.e(troopFileZipPreviewActivity2.f206341o0, troopFileZipPreviewActivity2.f206342p0, troopFileZipPreviewActivity2.f206343q0);
                TroopFileZipPreviewActivity troopFileZipPreviewActivity3 = TroopFileZipPreviewActivity.this;
                troopFileZipPreviewActivity3.f206336j0.setAdapter((ListAdapter) troopFileZipPreviewActivity3.f206337k0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c implements e.a {
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ short E;
        final /* synthetic */ String F;
        final /* synthetic */ int G;
        final /* synthetic */ String H;
        final /* synthetic */ a.b I;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f206349d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f206350e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f206351f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f206352h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f206353i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f206354m;

        c(List list, String str, FileManagerEntity fileManagerEntity, boolean z16, String str2, boolean z17, String str3, String str4, short s16, String str5, int i3, String str6, a.b bVar) {
            this.f206349d = list;
            this.f206350e = str;
            this.f206351f = fileManagerEntity;
            this.f206352h = z16;
            this.f206353i = str2;
            this.f206354m = z17;
            this.C = str3;
            this.D = str4;
            this.E = s16;
            this.F = str5;
            this.G = i3;
            this.H = str6;
            this.I = bVar;
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            StringBuilder sb5;
            this.f206349d.clear();
            if (jSONObject != null) {
                try {
                    if (!jSONObject.isNull("dirs")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("dirs");
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            ZipFilePresenter.f fVar = new ZipFilePresenter.f();
                            fVar.f208516a = true;
                            fVar.f208518c = jSONArray.getString(i16);
                            this.f206349d.add(fVar);
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            if (jSONObject != null && !jSONObject.isNull("files")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("files");
                for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                    ZipFilePresenter.f fVar2 = new ZipFilePresenter.f();
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i17);
                    fVar2.f208518c = jSONObject2.getString("filename");
                    fVar2.f208517b = jSONObject2.getLong("size");
                    if (this.f206350e.equals("/")) {
                        sb5 = new StringBuilder();
                        sb5.append("/");
                        sb5.append(fVar2.f208518c);
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append(this.f206350e);
                        sb5.append("/");
                        sb5.append(fVar2.f208518c);
                    }
                    String sb6 = sb5.toString();
                    FileManagerEntity fileManagerEntity = new FileManagerEntity();
                    fileManagerEntity.fileName = fVar2.f208518c;
                    FileManagerEntity fileManagerEntity2 = this.f206351f;
                    fileManagerEntity.nRelatedSessionId = fileManagerEntity2.nSessionId;
                    fileManagerEntity.fileSize = fVar2.f208517b;
                    fileManagerEntity.mContext = fileManagerEntity2.Uuid;
                    fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
                    if (this.f206352h) {
                        fileManagerEntity.WeiYunFileId = this.f206353i;
                        FileManagerEntity fileManagerEntity3 = this.f206351f;
                        fileManagerEntity.mContext = fileManagerEntity3.WeiYunFileId;
                        fileManagerEntity.nRelatedSessionId = FileManagerUtil.getWeiyunZipTargetId(fileManagerEntity3.fileSize);
                    }
                    fileManagerEntity.zipFileId = this.f206351f.WeiYunFileId;
                    if (fileManagerEntity.mContext == null) {
                        QLog.i("IphoneTitleBarActivity", 1, "zip list file content is empty. zipSessionId[" + this.f206351f.nSessionId + "] zipIsWeiyunFile[" + this.f206352h + "] zipCouldType[" + this.f206351f.cloudType + "] fileSessionId[" + fileManagerEntity.nSessionId + "]");
                    }
                    if (!this.f206352h && this.f206354m && !TextUtils.isEmpty(this.C)) {
                        fileManagerEntity.strServerPath = "https://" + this.D + ":" + ((int) this.E) + "/ftn_compress_getfile/rkey=" + this.F + "&filetype=" + this.G + "&path=" + URLUtil.encodeUrl(sb6) + ContainerUtils.FIELD_DELIMITER;
                        fileManagerEntity.httpsDomain = this.C;
                    } else {
                        fileManagerEntity.strServerPath = "http://" + this.D + ":" + this.H + "/ftn_compress_getfile/rkey=" + this.F + "&filetype=" + this.G + "&path=" + URLUtil.encodeUrl(sb6) + ContainerUtils.FIELD_DELIMITER;
                    }
                    FileManagerEntity fileManagerEntity4 = this.f206351f;
                    fileManagerEntity.zipFileId = fileManagerEntity4.WeiYunFileId;
                    fileManagerEntity.zipInnerPath = sb6;
                    fileManagerEntity.selfUin = fileManagerEntity4.selfUin;
                    fileManagerEntity.peerUin = fileManagerEntity4.peerUin;
                    fileManagerEntity.peerType = fileManagerEntity4.peerType;
                    fileManagerEntity.busId = fileManagerEntity4.busId;
                    fileManagerEntity.cloudType = 1;
                    fileManagerEntity.isZipInnerFile = true;
                    fileManagerEntity.zipFilePath = fileManagerEntity4.strTroopFilePath;
                    fileManagerEntity.zipType = this.G;
                    fileManagerEntity.TroopUin = fileManagerEntity4.TroopUin;
                    fVar2.f208519d = fileManagerEntity.nSessionId;
                    TroopFileZipPreviewActivity.this.app.getFileManagerProxy().x(fileManagerEntity);
                    this.f206349d.add(fVar2);
                }
            }
            a.b bVar = this.I;
            if (bVar != null) {
                bVar.a(this.f206349d);
            }
        }
    }

    /* loaded from: classes12.dex */
    class d extends FMObserver {
        d() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void Y0(boolean z16, int i3, long j3, String str, String str2) {
            com.tencent.biz.troop.file.b bVar;
            if (z16 && (bVar = TroopFileZipPreviewActivity.this.f206337k0) != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    private a.b H2(FileManagerEntity fileManagerEntity) {
        return new b(fileManagerEntity);
    }

    private void I2(String str, String str2, String str3, int i3, String str4, String str5, FileManagerEntity fileManagerEntity, boolean z16, String str6, short s16, a.b bVar) {
        String str7;
        boolean z17;
        String str8;
        if (z16) {
            str7 = "https://";
        } else {
            str7 = "http://";
        }
        String str9 = str7 + str + ":" + str2 + "/ftn_compress_list/rkey=" + str3 + "&filetype=" + i3 + "&path=" + URLUtil.encodeUrl(str4) + ContainerUtils.FIELD_DELIMITER;
        ArrayList arrayList = new ArrayList();
        if (fileManagerEntity.getCloudType() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z18 = z17;
        if (z18) {
            str8 = "FTN5K=" + str5;
        } else {
            str8 = str5;
        }
        f fVar = new f(str9, "GET", new c(arrayList, str4, fileManagerEntity, z18, str8, z16, str6, str, s16, str3, i3, str2, bVar), 1000, null);
        Bundle bundle = new Bundle();
        bundle.putString("version", ah.P());
        bundle.putString("Cookie", str8);
        if (z16) {
            bundle.putString("Referer", "https://" + str6);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", this.app.getApp().getApplicationContext());
        fVar.b(hashMap);
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
        if (i16 == -1 && i3 == 10099 && intent != null && intent.getBooleanExtra(AppConstants.Key.IS_NEED_FINISH, false)) {
            Intent intent2 = new Intent();
            intent2.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            setResult(-1, intent2);
            finish();
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        FileManagerEntity fileManagerEntity;
        super.doOnCreate(bundle);
        this.f206338l0 = this;
        this.f206327a0 = (ForwardFileInfo) getIntent().getParcelableExtra("fileinfo");
        this.f206328b0 = getIntent().getIntExtra("busId", 0);
        this.f206329c0 = getIntent().getLongExtra("troop_uin", 0L);
        this.f206331e0 = getIntent().getStringExtra("str_download_dns");
        this.f206332f0 = getIntent().getStringExtra("int32_server_port");
        this.f206333g0 = getIntent().getStringExtra("string_download_url");
        this.f206334h0 = getIntent().getStringExtra("str_cookie_val");
        this.f206335i0 = getIntent().getStringExtra("filepath");
        String stringExtra = getIntent().getStringExtra("filename");
        this.f206340n0 = getIntent().getLongExtra("nSessionId", 0L);
        this.f206341o0 = getIntent().getBooleanExtra("isHttps", false);
        this.f206342p0 = getIntent().getStringExtra("httpsDomain");
        this.f206343q0 = getIntent().getShortExtra("httpsPort", (short) 0);
        this.f206336j0 = new XListView(this);
        this.f206336j0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f206336j0.setBackgroundResource(R.drawable.bg_texture);
        this.f206336j0.setDivider(null);
        setContentView(this.f206336j0);
        setTitle(stringExtra);
        FileManagerEntity C = this.app.getFileManagerProxy().C(this.f206340n0);
        if (C == null) {
            finish();
            return false;
        }
        int chechFileType = FileManagerUtil.chechFileType(C);
        this.f206330d0 = chechFileType;
        if (this.f206329c0 != 0) {
            com.tencent.biz.troop.file.a.k(this.app, this.f206331e0, this.f206332f0, this.f206333g0, chechFileType, this.f206335i0, this.f206334h0, C, H2(C));
            fileManagerEntity = C;
        } else {
            fileManagerEntity = C;
            I2(this.f206331e0, this.f206332f0, this.f206333g0, chechFileType, this.f206335i0, this.f206334h0, C, this.f206341o0, this.f206342p0, this.f206343q0, H2(C));
        }
        startTitleProgress();
        super.setRightButton(R.string.close, new a(fileManagerEntity));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        if (this.f206344r0 != null) {
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.f206344r0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().addObserver(this.f206344r0);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
