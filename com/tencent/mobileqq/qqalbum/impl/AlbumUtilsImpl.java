package com.tencent.mobileqq.qqalbum.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AlbumUtilsImpl implements IAlbumUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QQAlbum";

    public AlbumUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqalbum.IAlbumUtils
    public String formatTimeToString(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
        return QAlbumUtil.formatTimeToString(j3);
    }

    @Override // com.tencent.mobileqq.qqalbum.IAlbumUtils
    public void sendPhoto(Activity activity, Intent intent, ArrayList<String> arrayList, HashMap<String, PhotoSendParams> hashMap, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, intent, arrayList, hashMap, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        intent.setExtrasClassLoader(PhotoSendParams.class.getClassLoader());
        HashMap hashMap2 = new HashMap();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            PhotoSendParams photoSendParams = hashMap.get(arrayList.get(i16));
            if (photoSendParams != null) {
                hashMap2.put(photoSendParams.thumbPath, photoSendParams);
                if (QLog.isColorLevel()) {
                    QLog.d("aioSendPhotos", 2, "[Qzone] thumbPath:", photoSendParams.thumbPath, " photoSendParams:", photoSendParams.toString());
                }
            } else if (!ImageManager.isNetworkUrl(arrayList.get(i16))) {
                arrayList2.add(arrayList.get(i16));
                if (QLog.isColorLevel()) {
                    QLog.d("aioSendPhotos", 2, "[QQ] local path:", arrayList.get(i16));
                }
            } else {
                QLog.w("aioSendPhotos", 2, "[Error] path:" + arrayList.get(i16));
            }
        }
        intent.putExtra(PeakConstants.PHOTO_SEND_PIC_TYPE, hashMap2);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList2);
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, i3);
        String stringExtra = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
        if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, String.format("sendPhoto packageName=%s className=%s", stringExtra, stringExtra2));
        }
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAlbum", 2, String.format("sendPhoto extras=%s", intent.getExtras()));
            }
            intent.setClassName(stringExtra, stringExtra2);
            intent.addFlags(603979776);
            boolean booleanExtra = intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
            if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "sendPhoto isCallFromPlugin=" + booleanExtra + "className=" + stringExtra2);
            }
            boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.IS_TROOP_SEND_MIXED_MSG, false);
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "sendPhoto isTroopSendMixedMsg = " + booleanExtra2);
            }
            if (!booleanExtra) {
                intent.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, true);
                activity.startActivityForResult(intent, 2);
            }
            if (!z16) {
                activity.finish();
                QAlbumUtil.anim(activity, false, false);
                return;
            }
            return;
        }
        String stringExtra3 = intent.getStringExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, String.format("sendPhoto action=%s", stringExtra3));
        }
        if (TextUtils.isEmpty(stringExtra3)) {
            QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.f225306l_), 0).show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, String.format("sendPhoto extras=%s", intent.getExtras()));
        }
        intent.setComponent(null);
        intent.setAction(stringExtra3);
        intent.setFlags(intent.getFlags() & (-536870913) & (-67108865));
        try {
            activity.sendBroadcast(intent);
            activity.finish();
        } catch (Exception e16) {
            QLog.d("QQAlbum", 1, "sendPhoto fail!", e16);
        }
    }
}
