package cooperation.qwallet.plugin;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes28.dex */
public class QWalletPayProgressDialog extends ReportDialog {
    private static final String TAG = "QWalletPayProgressDialog";
    private String mMessage;
    private TextView mTextView;

    public QWalletPayProgressDialog(Context context) {
        this(context, 0);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            super.setContentView(R.layout.midas_view_loading);
            Window window = getWindow();
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
            }
            TextView textView = (TextView) super.findViewById(R.id.midas_loading_message);
            this.mTextView = textView;
            textView.setVisibility(0);
            this.mTextView.setText(this.mMessage);
            super.setCancelable(false);
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            try {
                super.cancel();
                return false;
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
                    return false;
                }
                return false;
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    public void setMessage(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mMessage = "";
        } else {
            this.mMessage = charSequence.toString();
        }
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(this.mMessage);
        }
    }

    public QWalletPayProgressDialog(Context context, int i3) {
        super(context, i3);
        this.mMessage = HardCodeUtil.qqStr(R.string.f172188o64);
        this.mTextView = null;
    }
}
