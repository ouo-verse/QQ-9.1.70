package com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.PressDarkImageViewWithCallback;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView E;
    private final PressDarkImageViewWithCallback F;
    private final ImageView G;

    @Nullable
    private a.b H;
    private final a.InterfaceC7880a I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements PressDarkImageViewWithCallback.a {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.PressDarkImageViewWithCallback.a
        public boolean a(@Nullable Drawable drawable) {
            a.b bVar = b.this.H;
            if (bVar != null && bVar.f232295a != 2) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.PressDarkImageViewWithCallback.a
        public void onStateChanged(boolean z16) {
            a.b bVar = b.this.H;
            if (z16) {
                if (bVar != null && bVar.f232295a == 2) {
                    b.this.F.setColorFilter(HWColorFormat.COLOR_FormatVendorStartUnused);
                }
                b.this.G.getBackground().setAlpha(127);
            } else {
                b.this.F.clearColorFilter();
                b.this.G.getBackground().setAlpha(255);
            }
            b.this.G.invalidate();
        }
    }

    public b(@NonNull View view, a.InterfaceC7880a interfaceC7880a) {
        super(view);
        this.I = interfaceC7880a;
        this.G = (ImageView) view.findViewById(R.id.xvo);
        PressDarkImageViewWithCallback pressDarkImageViewWithCallback = (PressDarkImageViewWithCallback) view.findViewById(R.id.xvn);
        this.F = pressDarkImageViewWithCallback;
        pressDarkImageViewWithCallback.e(p());
        TextView textView = (TextView) view.findViewById(R.id.f165879xy2);
        this.E = textView;
        pressDarkImageViewWithCallback.setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private PressDarkImageViewWithCallback.a p() {
        return new a();
    }

    public void o(a.b bVar) {
        this.H = bVar;
        this.E.setText(bVar.f232298d);
        this.F.setTag(this.H);
        a.b bVar2 = this.H;
        int i3 = bVar2.f232295a;
        if (i3 == 0) {
            this.F.setImageResource(R.drawable.guild_role_preview_avatar_bg);
            this.G.setBackgroundResource(R.drawable.guild_role_preview_add_tiny);
            this.G.setVisibility(0);
        } else if (i3 == 1) {
            this.F.setImageResource(R.drawable.guild_role_preview_avatar_bg);
            this.G.setBackgroundResource(R.drawable.guild_role_preview_more_tiny);
            this.G.setVisibility(0);
        } else if (i3 == 2) {
            this.F.setAvatarTinyId(bVar2.f232297c, bVar2.f232296b);
            this.G.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && (view == this.F || view == this.E)) {
            this.I.a(view, this.H);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
