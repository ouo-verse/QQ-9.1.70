package com.tencent.mobileqq.guild.message.api.impl.onlinepush.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes14.dex */
public class GuildMsgPushDebugLayout extends FrameLayout {
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;

    /* renamed from: d, reason: collision with root package name */
    private TextView f230256d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f230257e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f230258f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f230259h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f230260i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f230261m;

    public GuildMsgPushDebugLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    private void a(@NonNull Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f0i, this);
        this.f230256d = (TextView) inflate.findViewById(R.id.f219002_);
        this.f230257e = (TextView) inflate.findViewById(R.id.f165720xc4);
        this.f230258f = (TextView) inflate.findViewById(R.id.xc5);
        this.f230259h = (TextView) inflate.findViewById(R.id.f166419zs2);
        this.f230260i = (TextView) inflate.findViewById(R.id.f164296sm1);
        this.f230261m = (TextView) inflate.findViewById(R.id.f657739u);
        this.C = (TextView) inflate.findViewById(R.id.u5x);
        this.D = (TextView) inflate.findViewById(R.id.f27790h7);
        this.E = (TextView) inflate.findViewById(R.id.zgy);
        this.F = (TextView) inflate.findViewById(R.id.v5s);
        this.G = (TextView) inflate.findViewById(R.id.sah);
        this.H = (TextView) inflate.findViewById(R.id.sag);
        this.I = (TextView) inflate.findViewById(R.id.zgx);
        this.J = (TextView) inflate.findViewById(R.id.f29330lc);
    }

    public GuildMsgPushDebugLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildMsgPushDebugLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        try {
            a(context);
        } catch (Exception e16) {
            QLog.e("GuildEmptyLayout", 1, "Inflate Error!", e16);
        }
    }
}
