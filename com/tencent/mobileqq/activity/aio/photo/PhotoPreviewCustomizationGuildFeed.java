package com.tencent.mobileqq.activity.aio.photo;

import android.text.TextUtils;
import android.view.View;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* loaded from: classes33.dex */
public class PhotoPreviewCustomizationGuildFeed extends PhotoPreviewCustomizationGuildAIO {

    /* renamed from: a0, reason: collision with root package name */
    public static final String f179714a0 = "com.tencent.mobileqq.activity.aio.photo.PhotoPreviewCustomizationGuildFeed";

    PhotoPreviewCustomizationGuildFeed(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity) {
        super(abstractPhotoPreviewActivity);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PhotoPreviewCustomizationGuildAIO, com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO, com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault, com.tencent.mobileqq.activity.photo.album.preview.f, com.tencent.mobileqq.activity.photo.album.preview.view.a
    public void p(View view) {
        int i3 = v().i();
        if (i3 == -1) {
            QLog.e("PhotoPreviewCustomizationGuildFeed", 1, "onSelectClick currentPosition == INVALID_POSITION");
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f144380om);
            return;
        }
        String str = this.C.f184324b.get(i3);
        if (TextUtils.isEmpty(str)) {
            QLog.e("PhotoPreviewCustomizationGuildFeed", 1, "onSelectClick path is empty");
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f144380om);
            return;
        }
        int l3 = this.f184337i.l(str);
        LocalMediaInfo k3 = this.f184337i.k(str);
        if (k3 != null && k3.mediaWidth > 0 && k3.mediaHeight > 0) {
            if (l3 == 0) {
                if (str.endsWith("gif")) {
                    if (!j0(str)) {
                        com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f145360r_);
                    }
                } else if (k3.fileSize >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
                    com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f145360r_);
                    return;
                }
            } else if (l3 == 1 && (k3.fileSize >= 1610612736 || k3.mDuration > ShortVideoConstants.VIDEO_MAX_DURATION)) {
                com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f145360r_);
                return;
            }
            super.p(view);
            return;
        }
        QLog.e("PhotoPreviewCustomizationGuildFeed", 1, "onSelectClick pic empty");
        com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f144380om);
    }

    private boolean j0(String str) {
        try {
            com.tencent.mobileqq.activity.aio.stickerbubble.frame.c cVar = new com.tencent.mobileqq.activity.aio.stickerbubble.frame.c(new File(str), false);
            long frameCount = cVar.getFrameCount() * cVar.getHeight() * cVar.getWidth();
            if (cVar.getFrameCount() <= 300) {
                if (frameCount <= PhotoListCustomizationGuildFeed.f179635d0.longValue()) {
                    return true;
                }
            }
            return false;
        } catch (IOException e16) {
            QLog.e("PhotoPreviewCustomizationGuildFeed", 1, "checkGifImageSafe error" + e16);
            return false;
        }
    }
}
