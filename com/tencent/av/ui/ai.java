package com.tencent.av.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ai extends DialogFromBottom {
    private e C;
    private d D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ai.this.isShowing()) {
                if (ai.this.D != null) {
                    ai.this.D.onClick();
                }
                ai.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ai.this.dismiss();
            if (ai.this.C != null) {
                ai.this.C.onConfirm();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
        void onClick();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface e {
        void onConfirm();
    }

    public ai(Context context, String str, Object obj, e eVar) {
        super(context);
        this.D = null;
        this.C = eVar;
        R(context, str, obj);
    }

    private void R(Context context, String str, Object obj) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.h2e, (ViewGroup) null);
        ((TextView) linearLayout.findViewById(R.id.f80394bc)).setText(str);
        VasAvatar vasAvatar = (VasAvatar) linearLayout.findViewById(R.id.f80384bb);
        if (obj instanceof Drawable) {
            vasAvatar.setImageDrawable((Drawable) obj);
        } else {
            vasAvatar.setLoader(null, (VasAvatarLoader) obj);
        }
        setContentView(linearLayout);
        ((ImageView) linearLayout.findViewById(R.id.f80364b_)).setOnClickListener(new a());
        setOnCancelListener(new b());
        ((Button) linearLayout.findViewById(R.id.f80374ba)).setOnClickListener(new c());
    }

    public void S(d dVar) {
        this.D = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }
}
