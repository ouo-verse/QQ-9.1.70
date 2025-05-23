package com.qzone.misc.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.album.business.downloader.PhotoDownloadQueueTask;
import com.qzone.album.business.downloader.VideoDownloadQueueTask;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.downloader.b;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.util.ToastUtil;
import com.qzone.util.am;
import com.qzone.util.image.c;
import com.qzone.util.l;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import common.qzone.component.util.SecurityUtil;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements Downloader.DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    Handler f48614a;

    /* renamed from: b, reason: collision with root package name */
    private Downloader f48615b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f48616c;

    /* renamed from: d, reason: collision with root package name */
    private int f48617d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f48618e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f48619f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f48620g = 0;

    /* renamed from: h, reason: collision with root package name */
    private final int f48621h = 3;

    /* renamed from: j, reason: collision with root package name */
    private boolean f48623j = false;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<PictureItem> f48622i = new ArrayList<>();

    public a(String str, Handler handler) {
        this.f48614a = handler;
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("photos");
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("videoURL")) && !LoginData.getInstance().isQzoneVip()) {
                    e();
                    return;
                }
            }
            ToastUtil.s(l.a(R.string.lrt), -1);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                if (jSONObject2 != null) {
                    String optString = jSONObject2.optString("originurl");
                    String optString2 = jSONObject2.optString("bigurl");
                    String optString3 = jSONObject2.optString("videoURL");
                    if (!TextUtils.isEmpty(optString3)) {
                        arrayList.add(optString3);
                    }
                    if (!TextUtils.isEmpty(optString) || !TextUtils.isEmpty(optString2)) {
                        arrayList2.add(optString);
                    }
                }
            }
            if (arrayList.size() > 0) {
                DownloadQueue.j().b(new VideoDownloadQueueTask(arrayList));
            }
            if (arrayList2.size() > 0) {
                DownloadQueue.j().b(new PhotoDownloadQueueTask(arrayList2));
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void c() {
        ArrayList<PictureItem> arrayList = this.f48622i;
        if (arrayList != null && arrayList.size() != 0) {
            boolean z16 = this.f48623j;
            if (z16) {
                f(this.f48617d, this.f48620g, this.f48619f, z16);
                return;
            }
            PictureItem pictureItem = this.f48622i.get(0);
            if (pictureItem == null) {
                return;
            }
            String str = pictureItem.originUrl.url;
            if (am.h(str)) {
                str = pictureItem.bigUrl.url;
            }
            this.f48622i.remove(0);
            String str2 = d() + System.currentTimeMillis() + "_" + SecurityUtil.c(str) + ".jpg";
            this.f48616c.put(str, str2);
            try {
                this.f48615b.download(new DownloadRequest(str, new String[]{str2}, false, this), false);
                return;
            } catch (Exception e16) {
                QZLog.e("DownLoadState", "Error:" + e16.toString());
                return;
            }
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("DownLoadState", 2, "no pictures are waiting for download");
        }
    }

    private String d() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
    }

    public void a() {
        if (QZLog.isColorLevel()) {
            QZLog.i("DownLoadState", 2, "cancelDownload");
        }
        this.f48623j = true;
    }

    public void b() {
        if (this.f48615b == null) {
            this.f48615b = b.e().f();
        }
        this.f48623j = false;
        int size = this.f48622i.size();
        this.f48617d = size;
        this.f48618e = size;
        this.f48619f = 0;
        this.f48620g = 0;
        this.f48616c = new HashMap<>();
        for (int i3 = 0; i3 < 3; i3++) {
            c();
        }
        ClickReport.e(422, "getActiveFeeds", 4, 23);
    }

    public void e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOpenVip", true);
        Message obtain = Message.obtain(this.f48614a);
        obtain.arg1 = 100;
        obtain.obj = bundle;
        obtain.sendToTarget();
        if (QZLog.isColorLevel()) {
            QZLog.i("DownLoadState", 2, "open download video vip");
        }
    }

    public void f(int i3, int i16, int i17, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt("totalNum", i3);
        bundle.putInt("successNum", i16);
        bundle.putInt("failNum", i17);
        bundle.putBoolean("isDownloadCanceled", z16);
        bundle.putString("path", d());
        Message obtain = Message.obtain(this.f48614a);
        obtain.arg1 = 100;
        obtain.obj = bundle;
        obtain.sendToTarget();
        if (QZLog.isColorLevel()) {
            QZLog.i("DownLoadState", 2, "result: totalNum:" + i3 + ",successNum:" + i16 + ",failNum:" + i17 + ",isDownloadCanceled:" + z16);
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadFailed(String str, DownloadResult downloadResult) {
        QZLog.e(QZLog.TO_DEVICE_TAG, "troop album download failed,url:" + str);
        int i3 = this.f48618e + (-1);
        this.f48618e = i3;
        int i16 = this.f48619f + 1;
        this.f48619f = i16;
        if (i3 == 0) {
            this.f48618e = 0;
            f(this.f48617d, this.f48620g, i16, this.f48623j);
        } else {
            c();
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadSucceed(String str, DownloadResult downloadResult) {
        if (QZLog.isColorLevel()) {
            QZLog.d("qun photo download", 2, "success");
        }
        this.f48618e--;
        this.f48620g++;
        c.N(BaseApplication.getContext(), this.f48616c.get(str));
        if (this.f48618e == 0) {
            f(this.f48617d, this.f48620g, this.f48619f, this.f48623j);
            this.f48618e = 0;
        } else {
            c();
        }
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadCanceled(String str) {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "troop album download canceled");
    }

    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
    public void onDownloadProgress(String str, long j3, float f16) {
    }
}
