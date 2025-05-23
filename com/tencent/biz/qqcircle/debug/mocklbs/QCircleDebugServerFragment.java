package com.tencent.biz.qqcircle.debug.mocklbs;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleDebugServerFragment extends QCircleBaseFragment {
    private String C = "";
    private int D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QCircleCustomDialog f84293d;

        a(QCircleCustomDialog qCircleCustomDialog) {
            this.f84293d = qCircleCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f84293d.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f84295d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f84296e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QCircleCustomDialog f84297f;

        b(EditText editText, EditText editText2, QCircleCustomDialog qCircleCustomDialog) {
            this.f84295d = editText;
            this.f84296e = editText2;
            this.f84297f = qCircleCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditText editText = this.f84295d;
            if (editText != null && this.f84296e != null) {
                QCircleDebugServerFragment.this.sh(editText.getText().toString(), this.f84296e.getText().toString());
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("QCircleDebugServerFragment", 2, "ShareAlbum update upload server");
                    }
                    UploadServiceBuilder.getInstance().setDebugServerRoute(DebugServerRoute.CUSTOM);
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f182693h6), 0);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                this.f84297f.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.C = str;
                this.D = Integer.parseInt(str2);
                LocalMultiProcConfig.putString("QcircleServerUploadCustomIp", str);
                LocalMultiProcConfig.putInt("QcircleServerUploadCustomPort", this.D);
                DebugServerRoute debugServerRoute = DebugServerRoute.CUSTOM;
                debugServerRoute.setServerIp(this.C);
                debugServerRoute.setServerPort(this.D);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g6c;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleDebugServerFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        rh();
    }

    public QCircleCustomDialog qh(Context context, int i3, int i16) {
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.qZoneInputDialog);
        qCircleCustomDialog.setContentView(R.layout.g6d);
        EditText editText = (EditText) qCircleCustomDialog.findViewById(R.id.f166746ht3);
        EditText editText2 = (EditText) qCircleCustomDialog.findViewById(R.id.f166747ht4);
        this.C = LocalMultiProcConfig.getString("QcircleServerUploadCustomIp", "");
        this.D = LocalMultiProcConfig.getInt("QcircleServerUploadCustomPort", this.D);
        if (!TextUtils.isEmpty(this.C)) {
            editText.setText(this.C);
            editText2.setText(this.D + "");
        }
        qCircleCustomDialog.d0(i3, new a(qCircleCustomDialog));
        qCircleCustomDialog.f0(i16, new b(editText, editText2, qCircleCustomDialog));
        qCircleCustomDialog.setCanceledOnTouchOutside(true);
        return qCircleCustomDialog;
    }

    protected void rh() {
        qh(getContext(), R.string.cancel, R.string.a8j).show();
    }
}
