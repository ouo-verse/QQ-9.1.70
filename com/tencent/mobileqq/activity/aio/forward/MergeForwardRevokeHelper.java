package com.tencent.mobileqq.activity.aio.forward;

import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MergeForwardRevokeHelper {

    /* renamed from: g, reason: collision with root package name */
    private static QBaseActivity f178654g;

    /* renamed from: h, reason: collision with root package name */
    private static int f178655h;

    /* renamed from: a, reason: collision with root package name */
    private QQCustomDialog f178656a;

    /* renamed from: c, reason: collision with root package name */
    private long f178658c;

    /* renamed from: d, reason: collision with root package name */
    private long f178659d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<QBaseActivity> f178660e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f178657b = false;

    /* renamed from: f, reason: collision with root package name */
    private final i f178661f = new i() { // from class: com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper.1
        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgInfoListUpdate(@Nullable ArrayList<MsgRecord> arrayList) {
            final QBaseActivity qBaseActivity;
            if (arrayList == null) {
                return;
            }
            Iterator<MsgRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord next = it.next();
                if (next.getMsgId() == MergeForwardRevokeHelper.this.f178658c && MergeForwardRevokeHelper.this.h(next) && (qBaseActivity = (QBaseActivity) MergeForwardRevokeHelper.this.f178660e.get()) != null) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MergeForwardRevokeHelper.this.l(qBaseActivity);
                        }
                    });
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f178665d;

        a(QBaseActivity qBaseActivity) {
            this.f178665d = qBaseActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f178665d.finish();
            MergeForwardRevokeHelper.f178654g = null;
            MergeForwardRevokeHelper.c(MergeForwardRevokeHelper.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
    }

    public MergeForwardRevokeHelper(long j3, long j16) {
        this.f178658c = 0L;
        this.f178659d = 0L;
        this.f178658c = j3;
        this.f178659d = j16;
    }

    static /* bridge */ /* synthetic */ b c(MergeForwardRevokeHelper mergeForwardRevokeHelper) {
        mergeForwardRevokeHelper.getClass();
        return null;
    }

    private void g(QBaseActivity qBaseActivity) {
        ViewGroup viewGroup = (ViewGroup) qBaseActivity.getWindow().getDecorView();
        ImageView imageView = new ImageView(qBaseActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setImageResource(R.drawable.etk);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        viewGroup.addView(imageView, layoutParams);
        QQCustomDialog qQCustomDialog = this.f178656a;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(qBaseActivity, 230).setMessage(qBaseActivity.getString(R.string.f1650827k)).setPositiveButton(qBaseActivity.getString(R.string.f171151ok), new a(qBaseActivity));
        this.f178656a = positiveButton;
        positiveButton.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(MsgRecord msgRecord) {
        if (msgRecord.getMsgType() != 5 && msgRecord.getMsgType() != 9) {
            return false;
        }
        Iterator<MsgElement> it = msgRecord.getElements().iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.getGrayTipElement() != null && next.getGrayTipElement().getRevokeElement() != null) {
                return true;
            }
            if (msgRecord.getMsgType() == 9 && msgRecord.getRecords().size() > 0 && msgRecord.getRecords().get(0).getMsgId() == this.f178659d) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(QBaseActivity qBaseActivity) {
        QLog.i("MergeForwardRevokeHelper", 1, "msg is revoke");
        if (this.f178657b) {
            qBaseActivity.finish();
        } else if (f178654g == qBaseActivity) {
            g(qBaseActivity);
        } else {
            qBaseActivity.finish();
        }
    }

    public void i(QBaseActivity qBaseActivity) {
        f178655h++;
        if (QLog.isColorLevel()) {
            QLog.d("MergeForwardRevokeHelper", 2, "onCreate");
        }
        if (qBaseActivity.getIntent() != null && qBaseActivity.getAppRuntime() != null) {
            this.f178660e = new WeakReference<>(qBaseActivity);
            w msgService = ((IKernelService) qBaseActivity.getAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService != null) {
                msgService.addMsgListener(this.f178661f);
            }
        }
    }

    public void j(QBaseActivity qBaseActivity) {
        w msgService;
        if (QLog.isColorLevel()) {
            QLog.d("MergeForwardRevokeHelper", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        if (qBaseActivity.getAppRuntime() != null && (msgService = ((IKernelService) qBaseActivity.getAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService()) != null) {
            msgService.addMsgListener(this.f178661f);
        }
        QQCustomDialog qQCustomDialog = this.f178656a;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f178656a.dismiss();
        }
        this.f178656a = null;
        int i3 = f178655h - 1;
        f178655h = i3;
        if (i3 <= 0) {
            f178654g = null;
        }
    }

    public void k(QBaseActivity qBaseActivity) {
        f178654g = qBaseActivity;
        if (QLog.isColorLevel()) {
            QLog.d("MergeForwardRevokeHelper", 2, "onResume");
        }
        this.f178657b = false;
    }
}
