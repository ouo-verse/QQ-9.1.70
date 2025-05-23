package com.tencent.mobileqq.wink.editor.hdr;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.wink.utils.ax;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class m extends ReportDialog {
    private ImageView C;
    private Button D;
    private View.OnClickListener E;
    private boolean F;

    public m(@NonNull Context context, int i3) {
        super(context, i3);
        int i16;
        boolean a16 = ax.a();
        this.F = a16;
        if (a16) {
            i16 = R.layout.i5j;
        } else {
            i16 = R.layout.i5i;
        }
        setContentView(i16);
        setCanceledOnTouchOutside(false);
        RoundImageView roundImageView = (RoundImageView) findViewById(R.id.x7n);
        roundImageView.setmRadius(com.tencent.videocut.utils.e.f384236a.a(6.0f), true);
        roundImageView.setImageDrawable(URLDrawable.getDrawable("https://xmaterial.tu.qq.com/xmaterial/materials/7695f82a-4ecf-11ed-835e-52540079d90e-qvideo_dialog_top_tab_huazhizengqiang.jpg", URLDrawable.URLDrawableOptions.obtain()));
        this.C = (ImageView) findViewById(R.id.f122847f2);
        this.D = (Button) findViewById(R.id.f122837f1);
        ((TextView) findViewById(R.id.x7o)).getPaint().setFakeBoldText(true);
    }

    public void N(View.OnClickListener onClickListener) {
        this.E = onClickListener;
        if (onClickListener != null) {
            this.C.setOnClickListener(onClickListener);
            this.D.setOnClickListener(onClickListener);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        View.OnClickListener onClickListener = this.E;
        if (onClickListener != null) {
            onClickListener.onClick(this.D);
        }
    }
}
