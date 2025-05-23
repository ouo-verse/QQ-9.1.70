package com.tencent.mobileqq.activity.photo.album;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData>> f184228a;

    /* renamed from: b, reason: collision with root package name */
    ProgressDialog f184229b;

    public e(com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f184228a = new WeakReference<>(fVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "cancleProgressDailog");
        }
        ProgressDialog progressDialog = this.f184229b;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f184229b.cancel();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            if (this.f184229b != null) {
                a();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this.f184228a.get().f184309d, R.style.qZoneInputDialog);
                this.f184229b = reportProgressDialog;
                reportProgressDialog.setCancelable(true);
                this.f184229b.setCanceledOnTouchOutside(false);
                this.f184229b.show();
                this.f184229b.setContentView(R.layout.f168383uh);
                ((TextView) this.f184229b.findViewById(R.id.photo_prievew_progress_dialog_text)).setText("");
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "showProgressDialog");
                }
            }
            if (!this.f184229b.isShowing()) {
                this.f184229b.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            com.tencent.mobileqq.pic.f.d("QQAlbum", "SendPhotoActivity.showProgressDialog", th5.toString());
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        WeakReference<com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData>> weakReference = this.f184228a;
        if (weakReference != null && weakReference.get() != null) {
            com.tencent.mobileqq.activity.photo.album.photolist.f<? extends OtherCommonData> fVar = this.f184228a.get();
            ArrayList<String> arrayList = fVar.f184310e.selectedPhotoList;
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                Bundle data = message.getData();
                                String string = data.getString("SRC_SAVE_PATH");
                                String string2 = data.getString("DES_SAVE_PATH");
                                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList<>();
                                    }
                                    QLog.d("QQAlbum", 2, "MSG_EDITED_PHOTO_SAVE_SUCCEED = ", string2);
                                    int indexOf = arrayList.indexOf(string);
                                    if (indexOf != -1) {
                                        arrayList.set(indexOf, string2);
                                    }
                                    j.m(this.f184228a.get());
                                    j.k(fVar.f184309d, string2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        Object obj = message.obj;
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            QLog.d("QQAlbum", 2, "MSG_PHOTO_ENCODE_SUCCEED = ", str);
                            if (arrayList.size() < fVar.f184310e.maxSelectNum) {
                                arrayList.add(str);
                                j.m(this.f184228a.get());
                            } else {
                                PeakFragmentActivity peakFragmentActivity = fVar.f184309d;
                                QQToast.makeText(peakFragmentActivity, String.format(peakFragmentActivity.getResources().getString(R.string.cu_), Integer.valueOf(fVar.f184310e.maxSelectNum)), 0).show();
                            }
                            j.k(fVar.f184309d, str);
                            return;
                        }
                        return;
                    }
                    if (fVar.f184309d instanceof NewPhotoListActivity) {
                        a();
                    }
                    QLog.e("QQAlbum", 2, "onEncodeError = ", Integer.valueOf(((Integer) message.obj).intValue()));
                    PeakFragmentActivity peakFragmentActivity2 = fVar.f184309d;
                    QQToast.makeText(peakFragmentActivity2, peakFragmentActivity2.getResources().getString(R.string.cua), 0).show();
                    return;
                }
                fVar.D(message);
                return;
            }
            com.tencent.mobileqq.activity.photo.album.photolist.d dVar = fVar.f184313i.Q;
            if (dVar == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(dVar.E);
            Bundle data2 = message.getData();
            int i16 = data2.getInt("ALBUMLIST_POSITION");
            long j3 = data2.getLong("ALBUMLIST_ITEM_DURATION");
            LocalMediaInfo localMediaInfo = arrayList2.get(i16);
            localMediaInfo.mDuration = j3;
            arrayList2.set(i16, localMediaInfo);
            dVar.t0(arrayList2);
            dVar.notifyDataSetChanged();
        }
    }
}
