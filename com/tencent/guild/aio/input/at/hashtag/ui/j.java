package com.tencent.guild.aio.input.at.hashtag.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.guild.aio.input.at.hashtag.ui.i;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j implements i.b {

    /* renamed from: a, reason: collision with root package name */
    private ListView f110964a;

    /* renamed from: b, reason: collision with root package name */
    private View f110965b;

    /* renamed from: c, reason: collision with root package name */
    private View f110966c;

    @Override // com.tencent.guild.aio.input.at.hashtag.ui.i.b
    public View a(Activity activity, h hVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.eei, (ViewGroup) null);
        this.f110965b = inflate;
        this.f110964a = (ListView) inflate.findViewById(R.id.w1z);
        this.f110966c = this.f110965b.findViewById(R.id.whv);
        if (hVar != null) {
            b(hVar);
        }
        return this.f110965b;
    }

    protected void b(h hVar) {
        this.f110964a.setBackgroundColor(hVar.f110932b.f110938d);
        this.f110966c.setBackgroundResource(hVar.f110933c.f110951a);
        View findViewById = this.f110965b.findViewById(R.id.whu);
        findViewById.setBackgroundColor(hVar.f110932b.f110938d);
        findViewById.getLayoutParams().height = hVar.f110931a.f110943e;
    }

    public ListView c() {
        return this.f110964a;
    }

    public View d() {
        return this.f110966c;
    }
}
