package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.qzone.util.aj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oo.b;

/* loaded from: classes37.dex */
public class QZoneShareLongPicAction extends z {

    /* loaded from: classes37.dex */
    class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QZoneShareLongPicAction qZoneShareLongPicAction = QZoneShareLongPicAction.this;
            qZoneShareLongPicAction.f58112g = 0;
            qZoneShareLongPicAction.O();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            super.onDeniedWithoutShowDlg(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    public QZoneShareLongPicAction(Activity activity) {
        super(activity);
    }

    private void T(final int i3, final String str, final Handler handler) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneShareLongPicAction.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<PhotoInfo> arrayList = QZoneShareLongPicAction.this.f58111f;
                if (arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                if (QZoneShareLongPicAction.this.f58112g > r0.f58111f.size() - 1) {
                    return;
                }
                if (QZoneShareLongPicAction.this.f58112g == 0) {
                    RFWLog.i("QZoneShareLongPicAction", RFWLog.USR, "save ing");
                    Message obtain = Message.obtain();
                    obtain.what = 4;
                    handler.sendMessage(obtain);
                }
                QZoneShareLongPicAction.this.r().post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneShareLongPicAction.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneShareLongPicAction qZoneShareLongPicAction = QZoneShareLongPicAction.this;
                        if (qZoneShareLongPicAction.f58112g >= qZoneShareLongPicAction.f58111f.size() || QZoneShareLongPicAction.this.f58112g < 0) {
                            return;
                        }
                        RFWLog.i("QZoneShareLongPicAction", RFWLog.USR, "org download, index is " + QZoneShareLongPicAction.this.f58112g);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        QZoneShareLongPicAction qZoneShareLongPicAction2 = QZoneShareLongPicAction.this;
                        qZoneShareLongPicAction2.z(i3, qZoneShareLongPicAction2.f58111f.get(qZoneShareLongPicAction2.f58112g));
                    }
                });
                if (QZoneShareLongPicAction.this.f58112g == r0.f58111f.size() - 1) {
                    RFWLog.i("QZoneShareLongPicAction", RFWLog.USR, "save long pic, index is " + QZoneShareLongPicAction.this.f58112g);
                    QZoneShareLongPicAction qZoneShareLongPicAction = QZoneShareLongPicAction.this;
                    qZoneShareLongPicAction.h(qZoneShareLongPicAction.f58111f, str, handler);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void D() {
        C();
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void f(final int i3, final String str, final Handler handler) {
        if (oo.b.l()) {
            ArrayList<PhotoInfo> arrayList = this.f58111f;
            if (arrayList != null && arrayList.size() > 0 && this.f58112g == this.f58111f.size() - 1) {
                final PhotoInfo photoInfo = this.f58111f.get(r0.size() - 1);
                final String a16 = aj.a(photoInfo);
                oo.b.f(null, 2, Collections.singletonList(a16), new b.InterfaceC10931b() { // from class: com.qzone.reborn.layer.share.n
                    @Override // oo.b.InterfaceC10931b
                    public final void a(ArrayList arrayList2) {
                        QZoneShareLongPicAction.this.U(a16, i3, str, handler, photoInfo, arrayList2);
                    }
                });
                return;
            }
            T(i3, str, handler);
            return;
        }
        T(i3, str, handler);
    }

    @Override // com.qzone.reborn.layer.share.z, com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (!QZonePermission.requestStoragePermission(n(), new a(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            QLog.e("QZoneShareLongPicAction", 1, "[MORE_SAVE] don't has store permission");
        } else {
            O();
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void z(int i3, PhotoInfo photoInfo) {
        k(i3, photoInfo, !oo.b.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(String str, int i3, String str2, Handler handler, PhotoInfo photoInfo, ArrayList arrayList) {
        if (ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            RFWLog.e("QZoneWatermark", RFWLog.USR, "copyLongPic byWatermarkManger return invalid result,originUrl:", str);
            T(i3, str2, handler);
        } else {
            String str3 = (String) arrayList.get(0);
            RFWLog.d("QZoneWatermark", RFWLog.CLR, "copyLongPic byWatermarkManger,originUrl:", str, ",replaceUrl:", str3);
            photoInfo.downloadUrl = str3;
            T(i3, str2, handler);
        }
    }
}
