package com.tencent.mobileqq.richmediabrowser;

import android.content.Context;
import com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;
import com.tencent.mobileqq.richmediabrowser.view.AIOPictureView;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements f04.d {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // f04.d
    public c04.c a(Context context, int i3, c04.b bVar) {
        switch (i3) {
            case 100:
                if (bVar instanceof com.tencent.mobileqq.richmediabrowser.presenter.d) {
                    return new AIOPictureView(context, (com.tencent.mobileqq.richmediabrowser.presenter.d) bVar);
                }
                return null;
            case 101:
                if (bVar instanceof com.tencent.mobileqq.richmediabrowser.presenter.e) {
                    return new AIOVideoView(context, (com.tencent.mobileqq.richmediabrowser.presenter.e) bVar);
                }
                return null;
            case 102:
                if (bVar instanceof com.tencent.mobileqq.richmediabrowser.presenter.b) {
                    return new AIOFilePictureView(context, (com.tencent.mobileqq.richmediabrowser.presenter.b) bVar);
                }
                return null;
            case 103:
                if (bVar instanceof com.tencent.mobileqq.richmediabrowser.presenter.c) {
                    return new AIOFileVideoView(context, (com.tencent.mobileqq.richmediabrowser.presenter.c) bVar);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // f04.d
    public c04.a b(int i3, c04.b bVar) {
        switch (i3) {
            case 100:
                return new tm2.d();
            case 101:
                return new tm2.e();
            case 102:
                return new tm2.b();
            case 103:
                return new tm2.c();
            default:
                return null;
        }
    }

    @Override // f04.d
    public c04.b createPresenter(int i3) {
        switch (i3) {
            case 100:
                return new com.tencent.mobileqq.richmediabrowser.presenter.d();
            case 101:
                return new com.tencent.mobileqq.richmediabrowser.presenter.e();
            case 102:
                return new com.tencent.mobileqq.richmediabrowser.presenter.b();
            case 103:
                return new com.tencent.mobileqq.richmediabrowser.presenter.c();
            default:
                return null;
        }
    }
}
