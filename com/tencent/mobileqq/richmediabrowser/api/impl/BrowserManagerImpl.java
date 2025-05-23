package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import b04.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserManager;
import com.tencent.mobileqq.richmediabrowser.b;
import com.tencent.mobileqq.richmediabrowser.c;
import com.tencent.mobileqq.richmediabrowser.f;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.k;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BrowserManagerImpl implements IBrowserManager {
    private static final String TAG = "BrowserManagerImpl";
    private AIOBrowserPresenter mainBrowserPresenter;

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserManager
    public MainBrowserPresenter getPresenter() {
        return this.mainBrowserPresenter;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserManager
    public IBrowserManager launchRichMediaBrowser(Context context, Intent intent, f fVar, String str, List<RichMediaBrowserInfo> list, int i3) {
        h.a().n(intent);
        a aVar = new a();
        aVar.i(new k());
        aVar.g(true);
        aVar.h(true);
        aVar.k(true);
        aVar.f(new c());
        aVar.a(100, 1);
        aVar.a(102, 1);
        aVar.a(101, 2);
        aVar.a(103, 2);
        com.tencent.mobileqq.richmediabrowser.a aVar2 = new com.tencent.mobileqq.richmediabrowser.a();
        if (intent.getExtras() != null) {
            Rect rect = (Rect) intent.getExtras().getParcelable(str);
            h.a().w(rect);
            aVar2.f281786b = rect;
        }
        aVar.d(aVar2);
        aVar.e(fVar);
        b bVar = new b(context);
        bVar.b(aVar);
        new b04.b().a(intent, bVar, list, i3);
        this.mainBrowserPresenter = bVar.getPresenter();
        vm2.k.f441884a.h(false);
        return this;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserManager
    public void notifyImageListChanged(AIOBrowserBaseData[] aIOBrowserBaseDataArr, int i3) {
        tm2.a aVar = this.mainBrowserPresenter.f281850e;
        try {
            if (aIOBrowserBaseDataArr == null) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "imgs is null");
            } else if (aVar.r(aIOBrowserBaseDataArr, i3)) {
                this.mainBrowserPresenter.x(aIOBrowserBaseDataArr, i3);
            }
        } catch (Exception e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "notifyImageListChanged exception = " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserManager
    public void notifyImageProgress(long j3, int i3, int i16, int i17, long j16, boolean z16) {
        AIOBrowserPresenter aIOBrowserPresenter = this.mainBrowserPresenter;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.y(j3, i3, i16, i17, j16, z16);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserManager
    public void notifyImageResult(long j3, int i3, int i16, int i17, String str, boolean z16) {
        if (this.mainBrowserPresenter != null) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "notifyImageResult() : id " + j3 + ", result = " + i17);
            this.mainBrowserPresenter.z(j3, i3, i16, i17, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserManager
    public void notifyVideoUrl(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17, Bundle bundle) {
        if (this.mainBrowserPresenter != null) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "notifyVideoUrl");
            this.mainBrowserPresenter.A(j3, i3, i16, str, strArr, str2, messageRecord, i17, bundle);
        }
    }
}
