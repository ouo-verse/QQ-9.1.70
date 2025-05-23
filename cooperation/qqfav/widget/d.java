package cooperation.qqfav.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.n;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d extends QQCustomDialog implements VoicePlayer.a, View.OnClickListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    private int C;
    protected VoicePlayer D;
    private String E;
    private int F;
    protected a G;
    protected Context H;
    private ImageView I;
    private Button J;
    private EditText K;
    private AnimationDrawable L;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void a(String str, int i3, String str2);
    }

    public d(Context context, AppRuntime appRuntime, int i3, a aVar) {
        super(context, R.style.qZoneInputDialog);
        this.G = aVar;
        this.H = context;
        this.C = i3;
        super.setContentView(R.layout.f167867jz);
        super.setNegativeButton(R.string.cancel, this);
        super.setPositiveButton(R.string.b3m, this);
        super.setTitle(R.string.f170075f6);
        if (ab.a()) {
            setBrandColor(0);
        }
        ((TextView) super.findViewById(R.id.dialogTitle)).setGravity(3);
        int dip2px = ViewUtils.dip2px(6.0f);
        int dip2px2 = ViewUtils.dip2px(16.0f);
        int dip2px3 = ViewUtils.dip2px(40.0f);
        int dip2px4 = ViewUtils.dip2px(50.0f);
        LinearLayout linearLayout = new LinearLayout(this.H);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px3, dip2px3);
        ImageView imageView = new ImageView(this.H);
        this.I = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.I, layoutParams);
        Button button = new Button(this.H);
        this.J = button;
        button.setId(R.id.g37);
        this.J.setTextColor(-1);
        this.J.setBackgroundResource(R.drawable.a8e);
        this.L = (AnimationDrawable) this.H.getResources().getDrawable(R.drawable.kg9);
        this.J.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qfav_list_bubble_ptt_action_r_3, 0, 0, 0);
        this.J.setHeight(dip2px4);
        linearLayout.addView(this.J);
        super.findViewById(R.id.dialogText).setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) super.findViewById(R.id.bja);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(0, -2);
        layoutParams2.addRule(3, R.id.dialogTitle);
        layoutParams2.addRule(5, R.id.dialogTitle);
        layoutParams2.addRule(7, R.id.dialogTitle);
        layoutParams2.bottomMargin = dip2px2;
        layoutParams2.topMargin = dip2px;
        EditText editText = (EditText) super.findViewById(R.id.input);
        this.K = editText;
        editText.setHint(R.string.b3s);
        this.K.setFilters(new InputFilter[]{new InputFilter.LengthFilter(60)});
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
        linearLayout.setId(R.id.b9t);
        layoutParams3.addRule(3, R.id.b9t);
        relativeLayout.addView(linearLayout, layoutParams2);
        if (ab.a()) {
            this.K.setTextColor(this.H.getResources().getColor(R.color.qui_common_text_primary));
            this.K.setHintTextColor(this.H.getResources().getColor(R.color.qui_common_text_secondary));
            this.K.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
        }
        this.J.setOnClickListener(this);
        super.setOnDismissListener(this);
    }

    public boolean N(String str, int i3, Drawable drawable) {
        if (TextUtils.isEmpty(str) || !q.p(str) || i3 <= 0) {
            return false;
        }
        this.J.setText(n.a(i3));
        this.J.setPadding(ViewUtils.dip2px(20.0f), 0, Math.min(n.b(this.H, i3, null, null, 0), ViewUtils.dip2px(200.0f)), 0);
        if (drawable != null) {
            this.I.setImageDrawable(drawable);
        }
        this.E = str;
        this.F = i3;
        return true;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        a aVar;
        if (i3 == 1 && (aVar = this.G) != null) {
            aVar.a(this.E, this.F, this.K.getText().toString());
        }
        super.cancel();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.L.stop();
        VoicePlayer voicePlayer = this.D;
        if (voicePlayer != null) {
            voicePlayer.v();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (!z16) {
            super.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        this.J.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qfav_list_bubble_ptt_action_r_3, 0, 0, 0);
        this.L.stop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.g37) {
            VoicePlayer voicePlayer = this.D;
            if (voicePlayer != null && voicePlayer.p() == 2) {
                this.D.s();
                this.J.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qfav_list_bubble_ptt_action_r_3, 0, 0, 0);
                this.L.stop();
            } else {
                VoicePlayer voicePlayer2 = this.D;
                if (voicePlayer2 != null) {
                    voicePlayer2.v();
                }
                VoicePlayer voicePlayer3 = new VoicePlayer(this.E, new Handler(), this.C);
                this.D = voicePlayer3;
                voicePlayer3.y(super.getContext());
                this.D.z();
                this.D.l(this);
                this.D.A();
                this.L.stop();
                this.J.setCompoundDrawablesWithIntrinsicBounds(this.L, (Drawable) null, (Drawable) null, (Drawable) null);
                this.L.start();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}
