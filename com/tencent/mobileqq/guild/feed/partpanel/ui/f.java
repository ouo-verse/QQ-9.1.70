package com.tencent.mobileqq.guild.feed.partpanel.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.partpanel.ui.d;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f implements d.a {

    /* renamed from: a, reason: collision with root package name */
    private View f222691a;

    /* renamed from: b, reason: collision with root package name */
    private ListView f222692b;

    /* renamed from: c, reason: collision with root package name */
    private View f222693c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f222694d;

    /* renamed from: e, reason: collision with root package name */
    private View f222695e;

    @Override // com.tencent.mobileqq.guild.feed.partpanel.ui.d.a
    public View a(Context context, c cVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.epv, (ViewGroup) null);
        this.f222691a = inflate;
        this.f222692b = (ListView) inflate.findViewById(R.id.f2256042);
        this.f222693c = this.f222691a.findViewById(R.id.wti);
        TextView textView = (TextView) this.f222691a.findViewById(R.id.f2257043);
        this.f222694d = textView;
        textView.setText(context.getString(R.string.f144800pr));
        this.f222695e = this.f222691a.findViewById(R.id.whv);
        if (cVar != null) {
            b(cVar);
        }
        return this.f222691a;
    }

    protected void b(c cVar) {
        this.f222692b.setBackgroundColor(cVar.f222655b.f222661d);
        this.f222693c.setBackgroundColor(cVar.f222655b.f222661d);
        this.f222695e.setBackgroundResource(cVar.f222656c.f222673a);
        View findViewById = this.f222691a.findViewById(R.id.whu);
        findViewById.setBackgroundColor(cVar.f222655b.f222661d);
        findViewById.getLayoutParams().height = cVar.f222654a.f222664c;
    }

    public ListView c() {
        return this.f222692b;
    }

    public View d() {
        return this.f222695e;
    }
}
