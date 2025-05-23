package com.tencent.mobileqq.guild.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class NetStatusInfoView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final ImageView f236043d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f236044e;

    /* renamed from: f, reason: collision with root package name */
    private final BroadcastReceiver f236045f;

    /* renamed from: h, reason: collision with root package name */
    private final Context f236046h;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetStatusInfoView.this.c();
        }
    }

    public NetStatusInfoView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i3;
        boolean isNetSupportHw = NetworkUtil.isNetSupportHw(this.f236046h);
        QLog.d("NetStatusInfoView", 2, "[updateVisible] isNetSupport = " + isNetSupportHw);
        if (isNetSupportHw) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        setVisibility(i3);
    }

    public void b() {
        QLog.d("NetStatusInfoView", 2, "[registerReceiver]");
        try {
            this.f236046h.registerReceiver(this.f236045f, new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("NetStatusInfoView", 1, "[registerReceiver] catch exception");
        }
    }

    public NetStatusInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatusInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236046h = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f1c, this);
        this.f236043d = (ImageView) inflate.findViewById(R.id.zpd);
        this.f236044e = (TextView) inflate.findViewById(R.id.zpe);
        this.f236045f = new a();
        b();
    }
}
