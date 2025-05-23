package com.tencent.richmediabrowser.model.pic;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.richmediabrowser.presenter.pic.PicturePresenter;
import f04.a;
import f04.b;
import java.io.File;

/* loaded from: classes25.dex */
public class PictureModel implements a {
    private PicturePresenter picturePresenter;

    public PictureModel(b bVar) {
        if (bVar instanceof PicturePresenter) {
            this.picturePresenter = (PicturePresenter) bVar;
        }
    }

    public boolean isPictureExisit(PictureData pictureData) {
        if (pictureData != null && !TextUtils.isEmpty(pictureData.filePath)) {
            return new File(pictureData.filePath).exists();
        }
        return false;
    }

    @Override // f04.a
    public void buildComplete() {
    }

    @Override // f04.a
    public void buildModel() {
    }

    @Override // f04.a
    public void buildParams(Intent intent) {
    }
}
