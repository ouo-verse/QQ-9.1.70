package com.tencent.richmediabrowser.core;

import android.content.Context;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.pic.PictureModel;
import com.tencent.richmediabrowser.model.video.VideoModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.video.VideoView;
import f04.a;
import f04.b;
import f04.c;

/* loaded from: classes25.dex */
public class MVPFactory {
    public static final String TAG = "MVPFactory";
    private MainBrowserPresenter mainBrowserPresenter;

    public MVPFactory(MainBrowserPresenter mainBrowserPresenter) {
        this.mainBrowserPresenter = mainBrowserPresenter;
    }

    public a createModel(int i3, b bVar) {
        if (i3 != 1) {
            if (i3 != 2) {
                IMvpFactory iMvpFactory = this.mainBrowserPresenter.getParamsBuilder().f27651a;
                if (iMvpFactory != null) {
                    return iMvpFactory.createModel(i3, bVar);
                }
                throw new IllegalStateException("createModel fail, type is error = " + i3);
            }
            return new VideoModel(bVar);
        }
        return new PictureModel(bVar);
    }

    public b createPresenter(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                IMvpFactory iMvpFactory = this.mainBrowserPresenter.getParamsBuilder().f27651a;
                if (iMvpFactory != null) {
                    return iMvpFactory.createPresenter(i3);
                }
                throw new IllegalStateException("createPresenter fail, type is error = " + i3);
            }
            return new VideoPresenter();
        }
        return new PicturePresenter();
    }

    public c createView(Context context, int i3, b bVar) {
        if (i3 != 1) {
            if (i3 != 2) {
                IMvpFactory iMvpFactory = this.mainBrowserPresenter.getParamsBuilder().f27651a;
                if (iMvpFactory != null) {
                    return iMvpFactory.createView(context, i3, bVar);
                }
                throw new IllegalStateException("createView fail, type is error = " + i3);
            }
            if (bVar instanceof VideoPresenter) {
                return new VideoView(context, (VideoPresenter) bVar);
            }
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "createView type is VIDEO, presenter is error!");
            return null;
        }
        if (bVar instanceof PicturePresenter) {
            return new PictureView(context, (PicturePresenter) bVar);
        }
        BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "createView type is PIC, presenter is error!");
        return null;
    }
}
