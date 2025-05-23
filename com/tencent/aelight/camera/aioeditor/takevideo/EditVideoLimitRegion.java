package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditVideoLimitRegion extends u {

    /* renamed from: d, reason: collision with root package name */
    private StoryGuideLineView f67767d;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f67771a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f67772b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f67773c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f67774d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f67775e;

        public a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
            this.f67771a = z16;
            this.f67772b = z17;
            this.f67773c = z18;
            this.f67774d = z19;
            this.f67775e = z26;
        }
    }

    public EditVideoLimitRegion(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
    }

    public static void j0(final StoryGuideLineView storyGuideLineView) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion.1
            @Override // java.lang.Runnable
            public void run() {
                final String string;
                Bundle a16 = dr2.a.b().a("CMD_GET_CURRENT_NICK_NAME", null);
                String str = "";
                if (a16 == null) {
                    string = "";
                } else {
                    string = a16.getString("VALUE_GET_CURRENT_NICK_NAME");
                }
                Bundle a17 = dr2.a.b().a("CMD_GET_CURRENT_USER_HEAD", null);
                if (a17 != null) {
                    str = a17.getString("VALUE_GET_CURRENT_USER_HEAD");
                }
                try {
                    Bitmap decodeFile = SafeBitmapFactory.decodeFile(str);
                    final Bitmap roundFaceBitmap = BaseImageUtil.getRoundFaceBitmap(decodeFile, 50, 50);
                    ImageCacheHelper.f98636a.i("story_user_avatar", roundFaceBitmap, Business.Default);
                    decodeFile.recycle();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                StoryGuideLineView.this.setUserName(string);
                                StoryGuideLineView.this.setUserHead(roundFaceBitmap);
                            } catch (Exception unused) {
                            }
                        }
                    });
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "user Head Path can't read");
                    }
                }
            }
        }, 16, null, true);
    }

    private boolean k0() {
        try {
            if (this.f67767d != null) {
                return true;
            }
            this.mParent.U().s0();
            StoryGuideLineView storyGuideLineView = (StoryGuideLineView) findViewSure(R.id.f166488fj1);
            this.f67767d = storyGuideLineView;
            j0(storyGuideLineView);
            return true;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "makeSureInitLayout error : " + e16.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        Object obj;
        if (message.what == 15 && (obj = message.obj) != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLimitView : left : " + aVar.f67774d + " right : " + aVar.f67773c + " top : " + aVar.f67771a + " bottom : " + aVar.f67772b);
            }
            if (aVar.f67775e) {
                l0(aVar.f67774d, aVar.f67773c, aVar.f67771a, aVar.f67772b);
            } else if (k0()) {
                this.f67767d.a();
            }
        }
        return super.handleEditVideoMessage(message);
    }

    public void l0(boolean z16, boolean z17, boolean z18, boolean z19) {
        if (k0()) {
            if (z19) {
                if (this.mParent instanceof QzEditVideoPartManager) {
                    this.f67767d.f(!((QzEditVideoPartManager) r4).T0);
                } else {
                    this.f67767d.f(true);
                }
            } else {
                this.f67767d.b();
            }
            if (z17) {
                this.f67767d.h();
            } else {
                this.f67767d.d();
            }
            if (z16) {
                this.f67767d.g();
            } else {
                this.f67767d.c();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        k0();
    }
}
