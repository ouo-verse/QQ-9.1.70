package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum;
import com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import or.a;
import or.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LaunchVideoEditorForAlbumImpl implements ILaunchVideoEditorForAlbum {
    a mEntranceParams;

    @Override // com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum
    public void jumpToEditVideoActivity(Activity activity, BaseVideoCaptureResult baseVideoCaptureResult, LocalMediaInfo localMediaInfo, Bundle bundle, int i3, Bundle bundle2) {
        lr.a.j(activity, baseVideoCaptureResult, localMediaInfo, this.mEntranceParams, bundle, i3, bundle2);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum
    public void setVideoParams(int i3, int i16, int i17, int i18) {
        a aVar = new a(i3, i16, i17);
        this.mEntranceParams = aVar;
        aVar.f(createCaptureVideoParamsByEntrance(i18));
    }

    private c createCaptureVideoParamsByEntrance(int i3) {
        switch (i3) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return new c.a().g(true).i(true).h(true).j(2).f();
            default:
                return new c.a().g(false).i(true).h(false).j(2).f();
        }
    }
}
