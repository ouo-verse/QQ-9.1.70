package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.util.Pair;
import java.util.List;

/* loaded from: classes3.dex */
public final class AdAppBtnUIPresenter extends AppDownloadManagerAdapter {
    public static final String TAG = "AdCanvasAppBtnUIAdapter";
    public boolean addToDownloadCallbacks;
    private String btnTitle;
    private AdAppDownloadManager mAdAppDownloadManager;
    private AdCanvasAppBtnView mAdProgressButton;
    public boolean resumeDownload = false;

    public AdAppBtnUIPresenter(String str, AdCanvasAppBtnView adCanvasAppBtnView, AdAppDownloadManager adAppDownloadManager, boolean z16) {
        this.mAdProgressButton = adCanvasAppBtnView;
        this.mAdAppDownloadManager = adAppDownloadManager;
        this.btnTitle = str;
        this.addToDownloadCallbacks = z16;
    }

    @Override // com.tencent.ad.tangram.downloader.IAdDownloader.Callback
    public void onDownloadProgressUpdate(List<Object> list, List<Pair<String, String>> list2) {
    }

    @Override // com.tencent.ad.tangram.downloader.IAdDownloader.Callback
    public void onDownloadStatusChanged(int i3, int i16, Pair<String, String> pair, String str) {
    }
}
