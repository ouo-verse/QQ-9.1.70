package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;

/* loaded from: classes32.dex */
public class QzoneEditPictureActivity extends EditPicActivity {

    /* renamed from: a0, reason: collision with root package name */
    private QzoneEditPicturePartManager f66345a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).loadEffectSo();
            m.n().x(QzoneEditPictureActivity.this.getContext(), new m.c() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity.1.1
                @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.m.c
                public void C2(boolean z16) {
                    if (QzoneEditPictureActivity.this.f66345a0.H != null) {
                        QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QzoneEditPictureActivity.this.f66345a0.H.L0(true);
                            }
                        });
                    }
                }
            }, true);
        }
    }

    private void H2() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity, com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        if (getIntent() != null && getIntent().getBooleanExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, false)) {
            QzoneEditPicturePartManager qzoneEditPicturePartManager = new QzoneEditPicturePartManager(this, true);
            this.f66345a0 = qzoneEditPicturePartManager;
            setEditVideoPartManager(qzoneEditPicturePartManager);
        } else {
            QzoneEditPicturePartManager qzoneEditPicturePartManager2 = new QzoneEditPicturePartManager(this, false);
            this.f66345a0 = qzoneEditPicturePartManager2;
            setEditVideoPartManager(qzoneEditPicturePartManager2);
            QZLog.d("QzoneEditPictureActivit", 2, "doOnCreate do nothing, use original manager " + super.getClass().getName());
        }
        boolean doOnCreate = super.doOnCreate(bundle);
        if (EditVideoPartManager.v((int) getIntent().getLongExtra("TEMP_PARAM", 0L), 64)) {
            H2();
        } else {
            View findViewById = findViewById(R.id.f163779rz1);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
        return doOnCreate;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity, com.tencent.aelight.camera.aioeditor.takevideo.aa
    public void finish(int i3, Intent intent, int i16, int i17) {
        J2(i3, intent, i16, i17, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
    }

    private void J2(int i3, Intent intent, int i16, int i17, boolean z16) {
        QzoneEditPicturePartManager qzoneEditPicturePartManager;
        if (intent != null && (qzoneEditPicturePartManager = this.f66345a0) != null && qzoneEditPicturePartManager.I1()) {
            intent.putExtra("key_content", this.f66345a0.C0);
            intent.putExtra("key_priv", this.f66345a0.f66353z0);
            intent.putExtra(AEEditorConstants.KEY_PRIV_UIN_LIST, this.f66345a0.f66352y0);
            intent.putExtra(AEEditorConstants.KEY_FONT_ID, this.f66345a0.I0);
            intent.putExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, this.f66345a0.J0);
            intent.putExtra(AEEditorConstants.KEY_FONT_URL, this.f66345a0.K0);
            intent.putExtra(AEEditorConstants.KEY_SUPER_FONT_ID, this.f66345a0.L0);
            intent.putExtra(AEEditorConstants.KEY_SUPER_FONT_INFO, this.f66345a0.M0);
            intent.putExtra(AEEditorConstants.KEY_TIMER_DELETE, this.f66345a0.J1());
            QLog.i("QzoneEditPictureActivit", 2, "EditPic mSetTimerDelete: " + this.f66345a0.J1());
        }
        if (QLog.isColorLevel()) {
            QLog.i("QzoneEditPictureActivit", 2, "QzoneEditPictureActivity finish --- resultCode : " + i3);
        }
        if (intent != null && i3 != 0) {
            boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, false);
            if (intent.getBooleanExtra(PeakConstants.EXTRA_DIRECTLY_BACK, false)) {
                intent.setClass(this, NewPhotoListActivity.class);
                intent.addFlags(872415232);
                startActivity(intent);
                setResult(-1);
                super.finish(i3, intent, i16, i17, z16);
                return;
            }
            if (!booleanExtra) {
                QZoneHelper.launchQZone(this, "", intent, -1);
                super.finish(-1, null, R.anim.dialog_exit, 0, z16);
                return;
            } else {
                super.finish(-1, intent, R.anim.dialog_exit, 0, z16);
                return;
            }
        }
        super.finish(i3, intent, i16, i17, z16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity, com.tencent.aelight.camera.aioeditor.takevideo.aa
    public void finish(int i3, Intent intent, int i16, int i17, boolean z16) {
        J2(i3, intent, i16, i17, z16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity, com.tencent.aelight.camera.aioeditor.takevideo.aa
    public Intent getPublishIntent(fs.b bVar) {
        Intent intent;
        String str;
        EditVideoParams editVideoParams;
        EditVideoParams.EditSource editSource;
        EditVideoDoodle editVideoDoodle;
        EditVideoPartManager editVideoPartManager = this.mEditVideoPartManager;
        if (editVideoPartManager == null || (intent = editVideoPartManager.f67789i) == null) {
            intent = getIntent();
        }
        String stringExtra = intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME);
        String stringExtra2 = intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME);
        if (stringExtra != null && stringExtra2 != null) {
            intent.setClassName(stringExtra2, stringExtra);
            intent.putExtra("open_chatfragment_fromphoto", true);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        fs.g gVar = bVar.f400395l;
        if (!gVar.f400422h && gVar.f400421g) {
            str = gVar.f400416b;
            if (getIntent().getIntExtra("camera_type", -1) != -1) {
                FileUtils.deleteFile(bVar.f400395l.f400415a);
                new File(bVar.f400395l.f400415a);
                BaseImageUtil.savePhotoToSysAlbum(this, bVar.f400395l.f400415a);
            }
            intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        } else {
            QLog.d("QzoneEditPictureActivit", 1, "send sourcePath");
            EditVideoPartManager editVideoPartManager2 = this.mEditVideoPartManager;
            if (editVideoPartManager2 != null && (editVideoParams = editVideoPartManager2.C) != null && (editSource = editVideoParams.f204059i) != null) {
                str = editSource.getSourcePath();
            } else {
                str = "";
            }
        }
        arrayList.add(str);
        EditVideoPartManager editVideoPartManager3 = this.mEditVideoPartManager;
        ArrayList<g.c> arrayList2 = (editVideoPartManager3 == null || (editVideoDoodle = editVideoPartManager3.I) == null || editVideoDoodle.V() == null || this.mEditVideoPartManager.I.V().C0() == null) ? null : this.mEditVideoPartManager.I.V().C0().X;
        JSONArray jSONArray = new JSONArray();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (g.c cVar : arrayList2) {
                DynamicTextItem dynamicTextItem = cVar.f68001z;
                if (dynamicTextItem != null && dynamicTextItem.q() != null) {
                    jSONArray.mo162put(cVar.f68001z.q().toString());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("DText", 2, "EditPicActivity getPublishIntent, content is: " + jSONArray.toString());
        }
        if (jSONArray.length() > 0) {
            intent.putExtra("dynamic_text", jSONArray.toString());
        }
        intent.putExtra(PublishParam.Z, bVar.f400396m);
        fs.g gVar2 = bVar.f400395l;
        boolean z16 = gVar2.f400422h || !gVar2.f400421g;
        intent.putExtra(PeakConstants.SEND_PICTURE_ORIGIN, z16);
        String stringExtra3 = intent.getStringExtra(AEEditorConstants.PATH);
        int intExtra = intent.getIntExtra(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, -1);
        if (intExtra != 1) {
            if (intExtra != 3) {
                if (intExtra == 9) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
                    if (stringArrayListExtra == null) {
                        stringArrayListExtra = new ArrayList<>();
                    }
                    stringArrayListExtra.addAll(arrayList);
                    intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", stringArrayListExtra);
                    intent.putExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, true);
                } else if (intExtra != 6 && intExtra != 7) {
                    intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
                }
            }
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
            if (stringArrayListExtra2 == null) {
                stringArrayListExtra2 = new ArrayList<>();
            }
            int indexOf = stringArrayListExtra2.indexOf(stringExtra3);
            if (indexOf != -1) {
                stringArrayListExtra2.set(indexOf, arrayList.get(0));
            }
            intent.putExtra(PeakConstants.EXTRA_DIRECTLY_BACK, true);
            intent.putExtra(PeakConstants.DIRECT_BACK_TO_QZONE, true);
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", stringArrayListExtra2);
        } else {
            intent.putExtra(AEEditorConstants.GO_PUBLISH_ACTIVITY, true);
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus,photoEditSourceType = " + intExtra + ",SINGLE_PHOTO_PATH = " + arrayList.get(0) + ",PHOTO_PATHS = " + arrayList);
        }
        intent.putExtra(PeakConstants.USE_URL_PATH, true);
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, false);
        intent.putExtra(PeakConstants.QZONE_SINGLE_PHOTO_PATH_EDITED, arrayList.get(0));
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, z16 ? 2 : 0);
        intent.putExtra(PeakConstants.SEND_FLAG, true);
        intent.addFlags(603979776);
        if (QLog.isColorLevel()) {
            QLog.d("QzoneEditPictureActivit", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + intent.getFlags() + ",data = " + intent.getExtras());
        }
        if (stringExtra != null && stringExtra.contains("ForwardRecentActivity")) {
            intent = EditPicActivity.compactAPI21SystemShare(intent);
        }
        intent.putExtra(PeakConstants.VIDEO_LOCATE_DESCRIPTION, bVar.f400387d.videoLocationDescription);
        intent.putExtra(PeakConstants.VIDEO_LOCAL_LONGITUDE, bVar.f400387d.videoLongitude);
        intent.putExtra(PeakConstants.VIDEO_LOCAL_LATITUDE, bVar.f400387d.videoLatitude);
        return intent;
    }

    public static Intent newPictureEditIntentWithoutPublish(Activity activity, String str) {
        Intent startEditPic = EditPicActivity.startEditPic(activity, str, true, true, true, true, true, false, false, false, 3, 99, 0, false, null);
        startEditPic.putExtra("TEMP_PARAM", startEditPic.getLongExtra("TEMP_PARAM", 0L) | 512);
        return startEditPic;
    }

    public static Intent I2(Activity activity, String str, boolean z16, int i3, int i16, int i17) {
        return EditPicActivity.startEditPic(activity, str, true, true, true, z16, true, false, false, false, i3, i16, i17, false, null);
    }
}
