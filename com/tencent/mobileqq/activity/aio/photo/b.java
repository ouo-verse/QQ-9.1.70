package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f179716b;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<com.tencent.mobileqq.richmediabrowser.g> f179717a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f179718d;

        a(Activity activity) {
            this.f179718d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f179718d.finish();
        }
    }

    public static void b(Activity activity, RelativeLayout relativeLayout) {
        if (activity != null && relativeLayout != null) {
            ImageView imageView = new ImageView(activity);
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            imageView.setImageResource(R.drawable.etk);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView, layoutParams);
            c(activity);
            ReportController.o(null, "dc00898", "", "", "0X8009EB8", "0X8009EB8", 0, 0, "", "", "", "");
        }
    }

    public static void c(Activity activity) {
        if (activity != null) {
            try {
                QQCustomDialog positiveButton = DialogUtil.createCustomDialog(activity, 230).setMessage(HardCodeUtil.qqStr(R.string.j9_)).setPositiveButton(activity.getString(R.string.c7n), new a(activity));
                if (positiveButton != null && !activity.isFinishing()) {
                    positiveButton.show();
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOGalleryMsgRevokeMgr", 2, "showDialog exception: " + th5.getMessage());
                }
            }
        }
    }

    public static b d() {
        if (f179716b == null) {
            synchronized (b.class) {
                if (f179716b == null) {
                    f179716b = new b();
                }
            }
        }
        return f179716b;
    }

    public static void g(MessageRecord messageRecord) {
        if ((messageRecord instanceof MessageForPic) || (messageRecord instanceof MessageForShortVideo) || (messageRecord instanceof MessageForMarketFace) || (messageRecord instanceof MessageForFile) || (messageRecord instanceof MessageForTroopFile) || (messageRecord instanceof MessageForMixedMsg) || (messageRecord instanceof MessageForStructing)) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOGalleryMsgRevokeMgr", 2, "sendMsgRevokeRequest:" + messageRecord);
            }
            b d16 = d();
            if (d16 != null) {
                synchronized (d16.f179717a) {
                    Iterator<com.tencent.mobileqq.richmediabrowser.g> it = d16.f179717a.iterator();
                    while (it.hasNext()) {
                        it.next().v5(messageRecord.uniseq);
                    }
                }
            }
            RichmediaService v3 = RichmediaService.v();
            if (v3 != null) {
                Bundle bundle = new Bundle();
                bundle.putLong("msg_revoke_uniseq", messageRecord.uniseq);
                boolean z16 = v3.z(300, -1, bundle);
                if (QLog.isColorLevel()) {
                    QLog.i("AIOGalleryMsgRevokeMgr", 2, "sendMsgRevokeRequest result:" + z16);
                }
            }
        }
    }

    public void a(com.tencent.mobileqq.richmediabrowser.g gVar) {
        synchronized (this.f179717a) {
            if (!this.f179717a.contains(gVar)) {
                this.f179717a.add(gVar);
            }
        }
    }

    public void e(Bundle bundle) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("notifyMsgRevoke, mScene:");
            if (bundle != null) {
                str = bundle.toString();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.i("AIOGalleryMsgRevokeMgr", 2, sb5.toString());
        }
        if (bundle == null) {
            return;
        }
        long j3 = bundle.getLong("msg_revoke_uniseq", 0L);
        synchronized (this.f179717a) {
            Iterator<com.tencent.mobileqq.richmediabrowser.g> it = this.f179717a.iterator();
            while (it.hasNext()) {
                it.next().v5(j3);
            }
        }
    }

    public void f(com.tencent.mobileqq.richmediabrowser.g gVar) {
        synchronized (this.f179717a) {
            this.f179717a.remove(gVar);
        }
    }
}
