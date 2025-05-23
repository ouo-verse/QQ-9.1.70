package com.tencent.mobileqq.vas.adapter;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.transfile.SignatureTemplateDownloader;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SignatureAdapter implements VasResAdapter, VasResDrawable.VasResDrawableAdapter {

    /* renamed from: a, reason: collision with root package name */
    private String f307910a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f307911b;

    /* renamed from: c, reason: collision with root package name */
    private VasResController f307912c;

    /* renamed from: d, reason: collision with root package name */
    private RichStatus f307913d;

    /* renamed from: e, reason: collision with root package name */
    private RichStatus f307914e = new RichStatus(null);

    /* renamed from: f, reason: collision with root package name */
    private boolean f307915f = false;

    /* renamed from: g, reason: collision with root package name */
    private Observer f307916g = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Observer {
        a() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            RichStatus richStatus;
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                if (((Integer) arrayList.get(0)).intValue() == 5) {
                    RichStatus richStatus2 = (RichStatus) arrayList.get(1);
                    SignatureAdapter.this.f307913d = richStatus2;
                    if (SignatureAdapter.this.f307913d.plainText != null && (richStatus = SignatureManagerForTool.j().f282250d) != null) {
                        richStatus.plainText = (ArrayList) SignatureAdapter.this.f307913d.plainText.clone();
                        richStatus.topics.clear();
                        richStatus.topics.addAll(SignatureAdapter.this.f307913d.topics);
                    }
                    if (richStatus2 != null) {
                        SignatureAdapter.this.f307914e.copyFrom(richStatus2);
                    }
                    SignatureAdapter.this.f307912c.getUIHanlder().sendEmptyMessage(10003);
                    SignatureManagerForTool.j().deleteObserver(SignatureAdapter.this.f307916g);
                    return;
                }
                return;
            }
            SignatureAdapter.this.f307912c.getUIHanlder().sendEmptyMessage(10003);
        }
    }

    public SignatureAdapter(VasResDrawable vasResDrawable, AppRuntime appRuntime, int i3) {
        this.f307912c = vasResDrawable.getVasResController();
        vasResDrawable.getOptions().loadDrawableId = R.drawable.ft6;
        vasResDrawable.getOptions().defaultDrawableId = i3;
        vasResDrawable.getOptions().urlProtocalType = SignatureTemplateDownloader.PROTOCAL_SIGNATURE_COVER;
        vasResDrawable.getOptions().animatinType = 103;
        if (appRuntime != null) {
            vasResDrawable.addHeader("my_uin", appRuntime.getAccount());
        }
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void destroy() {
        SignatureManagerForTool.j().deleteObserver(this.f307916g);
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void downloadDone(int i3, final Bundle bundle) {
        boolean z16;
        int i16 = 0;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("downloadDone isMainThread:");
            if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("SignatureAdapter", 2, sb5.toString());
        }
        if (bundle != null) {
            i16 = bundle.getInt("resType");
        }
        if (i16 == 2) {
            if (3 == i3 || i3 == 0) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.adapter.SignatureAdapter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        String signatureFilePath;
                        int i17 = bundle.getInt("dynamicType");
                        String string = bundle.getString("tplId");
                        String string2 = bundle.getString(WadlProxyConsts.PARAM_FILENAME);
                        if (i17 != 16) {
                            signatureFilePath = null;
                        } else {
                            signatureFilePath = SignatureTemplateConfig.getSignatureFilePath(string, "dynamic_aio");
                        }
                        if (signatureFilePath != null) {
                            if (DownloaderFactory.X(new File(SignatureTemplateConfig.getSignatureFilePath(string, string2)), new File(signatureFilePath), true)) {
                                SignatureAdapter.this.f307912c.getUIHanlder().sendEmptyMessage(10003);
                            }
                        }
                    }
                }, 128, null, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter
    public String getDrawableUrl() {
        return this.f307910a;
    }

    public void h(boolean z16) {
        this.f307915f = z16;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter
    public boolean isDynamic() {
        return this.f307911b;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResAdapter
    public void load() {
        final int id5 = this.f307912c.getId();
        SignatureManagerForTool.j().addObserver(this.f307916g);
        final SignatureTemplateInfo l3 = SignatureManagerForTool.j().l(id5);
        if (!l3.isParsing.get()) {
            SignatureTemplateInfo.ImageItem imageItem = l3.imageItem;
            if (imageItem != null && !TextUtils.isEmpty(imageItem.coverUrl)) {
                this.f307910a = l3.imageItem.coverUrl;
            } else if (!TextUtils.isEmpty(l3.dot9png)) {
                this.f307910a = l3.dot9png;
            } else {
                this.f307910a = l3.view;
            }
            SignatureManagerForTool.j().deleteObserver(this.f307916g);
        }
        if (SignatureManager.n(l3)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.adapter.SignatureAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    if (SignatureManager.i(String.valueOf(id5))) {
                        SignatureAdapter.this.f307911b = true;
                        String signatureFilePath = SignatureTemplateConfig.getSignatureFilePath(Integer.toString(id5), "dynamic_aio");
                        SignatureTemplateInfo.DynamicItem dynamicItem = l3.dynamicItem[0];
                        VasResController vasResController = SignatureAdapter.this.f307912c;
                        int i16 = dynamicItem.interval;
                        if (i16 == 0) {
                            i16 = 50;
                        }
                        if (SignatureAdapter.this.f307915f) {
                            i3 = -1;
                        } else {
                            i3 = dynamicItem.repeatTimes;
                        }
                        vasResController.loadPngs(signatureFilePath, i16, i3);
                        return;
                    }
                    String str = l3.dynamicItem[0].pngZip;
                    String k3 = SignatureManagerForTool.k(id5, str);
                    String signatureFilePath2 = SignatureTemplateConfig.getSignatureFilePath(String.valueOf(id5), str);
                    Bundle bundle = new Bundle();
                    bundle.putInt("resType", 2);
                    bundle.putInt("dynamicType", 16);
                    bundle.putString("tplId", String.valueOf(id5));
                    bundle.putString(WadlProxyConsts.PARAM_FILENAME, str);
                    SignatureAdapter.this.f307912c.downLoad(k3, signatureFilePath2, bundle);
                }
            }, 128, null, true);
        } else {
            this.f307911b = false;
            this.f307912c.getUIHanlder().sendEmptyMessage(10001);
        }
    }
}
