package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.util.aj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.Collections;
import oo.b;

/* loaded from: classes37.dex */
public class QZoneShareLongPicToWXFriendAction extends QZoneShareWXFriendAction {
    public QZoneShareLongPicToWXFriendAction(Activity activity) {
        super(activity);
    }

    private void Z(final int i3, final String str, final Handler handler) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneShareLongPicToWXFriendAction.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<PhotoInfo> arrayList = QZoneShareLongPicToWXFriendAction.this.f58111f;
                if (arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                if (QZoneShareLongPicToWXFriendAction.this.f58112g > r0.f58111f.size() - 1) {
                    return;
                }
                if (QZoneShareLongPicToWXFriendAction.this.f58112g == 0) {
                    RFWLog.i("QZoneShareLongPicToWXFriendAction", RFWLog.USR, "save ing");
                    Message obtain = Message.obtain();
                    obtain.what = 4;
                    handler.sendMessage(obtain);
                }
                QZoneShareLongPicToWXFriendAction.this.r().post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneShareLongPicToWXFriendAction.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneShareLongPicToWXFriendAction qZoneShareLongPicToWXFriendAction = QZoneShareLongPicToWXFriendAction.this;
                        if (qZoneShareLongPicToWXFriendAction.f58112g >= qZoneShareLongPicToWXFriendAction.f58111f.size() || QZoneShareLongPicToWXFriendAction.this.f58112g < 0) {
                            return;
                        }
                        RFWLog.i("QZoneShareLongPicToWXFriendAction", RFWLog.USR, "org download, index is " + QZoneShareLongPicToWXFriendAction.this.f58112g);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QZoneShareLongPicToWXFriendAction qZoneShareLongPicToWXFriendAction2 = QZoneShareLongPicToWXFriendAction.this;
                        qZoneShareLongPicToWXFriendAction2.z(i3, qZoneShareLongPicToWXFriendAction2.f58111f.get(qZoneShareLongPicToWXFriendAction2.f58112g));
                    }
                });
                if (QZoneShareLongPicToWXFriendAction.this.f58112g == r0.f58111f.size() - 1) {
                    RFWLog.i("QZoneShareLongPicToWXFriendAction", RFWLog.USR, "save long pic, index is " + QZoneShareLongPicToWXFriendAction.this.f58112g);
                    QZoneShareLongPicToWXFriendAction qZoneShareLongPicToWXFriendAction = QZoneShareLongPicToWXFriendAction.this;
                    qZoneShareLongPicToWXFriendAction.h(qZoneShareLongPicToWXFriendAction.f58111f, str, handler);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void D() {
        C();
    }

    @Override // com.qzone.reborn.layer.share.QZoneShareWXFriendAction
    protected boolean U() {
        return false;
    }

    @Override // com.qzone.reborn.layer.share.QZoneShareWXFriendAction
    protected boolean V() {
        return false;
    }

    @Override // com.qzone.reborn.layer.share.QZoneShareWXFriendAction
    protected boolean W() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void e(final int i3, final String str, final Handler handler) {
        if (oo.b.l()) {
            ArrayList<PhotoInfo> arrayList = this.f58111f;
            if (arrayList != null && arrayList.size() > 0 && this.f58112g == this.f58111f.size() - 1) {
                final PhotoInfo photoInfo = this.f58111f.get(r0.size() - 1);
                final String a16 = aj.a(photoInfo);
                oo.b.f(null, 2, Collections.singletonList(a16), new b.InterfaceC10931b() { // from class: com.qzone.reborn.layer.share.q
                    @Override // oo.b.InterfaceC10931b
                    public final void a(ArrayList arrayList2) {
                        QZoneShareLongPicToWXFriendAction.this.a0(a16, i3, str, handler, photoInfo, arrayList2);
                    }
                });
                return;
            }
            Z(i3, str, handler);
            return;
        }
        Z(i3, str, handler);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void f(int i3, String str, Handler handler) {
        e(i3, str, handler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneShareWXFriendAction, com.qzone.reborn.layer.share.c, com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        super.x(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000069) {
            D();
            P();
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void z(int i3, PhotoInfo photoInfo) {
        k(i3, photoInfo, !oo.b.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(String str, int i3, String str2, Handler handler, PhotoInfo photoInfo, ArrayList arrayList) {
        if (ArrayUtils.isOutOfArrayIndex(0, arrayList)) {
            RFWLog.e("QZoneWatermark", RFWLog.USR, "copyLongPic byWatermarkManger return invalid result,originUrl:", str);
            Z(i3, str2, handler);
        } else {
            String str3 = (String) arrayList.get(0);
            RFWLog.d("QZoneWatermark", RFWLog.CLR, "copyLongPic byWatermarkManger,originUrl:", str, ",replaceUrl:", str3);
            photoInfo.downloadUrl = str3;
            Z(i3, str2, handler);
        }
    }
}
