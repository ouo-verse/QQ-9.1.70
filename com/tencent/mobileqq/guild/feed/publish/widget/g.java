package com.tencent.mobileqq.guild.feed.publish.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFontStyleEvent;
import com.tencent.mobileqq.guild.feed.publish.widget.b;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class g extends b implements View.OnClickListener {
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private ImageView K;

    public g(Context context, FrameLayout frameLayout, b.a aVar) {
        super(context, frameLayout, aVar);
    }

    private void B(jn1.c cVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.E);
        arrayList.add(this.F);
        arrayList.add(this.G);
        List<Integer> b16 = cVar.b();
        if (bl.b(b16)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ImageView) it.next()).setSelected(false);
            }
            return;
        }
        for (Integer num : b16) {
            if (num.intValue() == 0) {
                this.E.setSelected(true);
                arrayList.remove(this.E);
            } else if (num.intValue() == 1) {
                this.F.setSelected(true);
                arrayList.remove(this.F);
            } else if (num.intValue() == 2) {
                this.G.setSelected(true);
                arrayList.remove(this.G);
            }
        }
        if (bl.b(arrayList)) {
            return;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((ImageView) it5.next()).setSelected(false);
        }
    }

    private void n(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setSelected(!imageView.isSelected());
    }

    private void o(int i3) {
        jn1.c cVar = new jn1.c();
        cVar.c(Integer.valueOf(i3));
        com.tencent.mobileqq.guild.feed.util.bl.c().a(new GuildFontStyleEvent(cVar));
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        if (this.E.isSelected()) {
            arrayList.add(0);
        }
        if (this.F.isSelected()) {
            arrayList.add(1);
        }
        if (this.G.isSelected()) {
            arrayList.add(2);
        }
        jn1.c cVar = new jn1.c();
        cVar.d(arrayList);
        com.tencent.mobileqq.guild.feed.util.bl.c().a(new GuildFontStyleEvent(cVar));
    }

    private void q() {
        if (y(this.H)) {
            return;
        }
        t(this.H);
        o(0);
    }

    private void r() {
        if (y(this.I)) {
            return;
        }
        t(this.I);
        o(1);
    }

    private void s() {
        if (y(this.J)) {
            return;
        }
        t(this.J);
        o(2);
    }

    private void t(ImageView imageView) {
        n(imageView);
        n(this.K);
        this.K = imageView;
    }

    private void u() {
        n(this.E);
        p();
    }

    private void v() {
        n(this.F);
        p();
    }

    private void w() {
        n(this.G);
        p();
    }

    private void x() {
        ImageView imageView = this.E;
        Context context = this.f223194d;
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_primary);
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_publish_style_bold_normal, valueOf));
        this.F.setImageDrawable(GuildUIUtils.w(this.f223194d, R.drawable.guild_feed_publish_style_italic_normal, valueOf));
        this.G.setImageDrawable(GuildUIUtils.w(this.f223194d, R.drawable.guild_feed_publish_style_underline_normal, valueOf));
        this.H.setImageDrawable(GuildUIUtils.w(this.f223194d, R.drawable.guild_feed_publish_align_left_icon_normal, valueOf));
        this.I.setImageDrawable(GuildUIUtils.w(this.f223194d, R.drawable.guild_feed_publish_align_middle_icon_normal, valueOf));
        this.J.setImageDrawable(GuildUIUtils.w(this.f223194d, R.drawable.guild_feed_publish_align_right_icon_normal, valueOf));
    }

    private boolean y(ImageView imageView) {
        ImageView imageView2 = this.K;
        if (imageView2 != null && imageView2 == imageView) {
            return true;
        }
        return false;
    }

    private void z(jn1.c cVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.H);
        arrayList.add(this.I);
        arrayList.add(this.J);
        Integer a16 = cVar.a();
        if (a16 == null) {
            a16 = 0;
        }
        if (a16.intValue() == 0) {
            this.H.setSelected(true);
            arrayList.remove(this.H);
            this.K = this.H;
        } else if (a16.intValue() == 1) {
            this.I.setSelected(true);
            arrayList.remove(this.I);
            this.K = this.I;
        } else if (a16.intValue() == 2) {
            this.J.setSelected(true);
            arrayList.remove(this.J);
            this.K = this.J;
        } else if (a16.intValue() == -1) {
            this.K = null;
        }
        if (bl.b(arrayList)) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ImageView) it.next()).setSelected(false);
        }
    }

    public void A(jn1.c cVar) {
        B(cVar);
        z(cVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.widget.b
    protected void d() {
        this.H.setSelected(true);
        this.K = this.H;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.widget.b
    @NonNull
    protected View j() {
        View inflate = LayoutInflater.from(this.f223194d).inflate(R.layout.f2y, (ViewGroup) null);
        this.f223196f = inflate;
        this.E = (ImageView) inflate.findViewById(R.id.y9h);
        this.F = (ImageView) this.f223196f.findViewById(R.id.y9i);
        this.G = (ImageView) this.f223196f.findViewById(R.id.y9j);
        this.H = (ImageView) this.f223196f.findViewById(R.id.xzw);
        this.I = (ImageView) this.f223196f.findViewById(R.id.xzx);
        this.J = (ImageView) this.f223196f.findViewById(R.id.xzy);
        this.f223196f.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        x();
        return this.f223196f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.y9h) {
            u();
        } else if (id5 == R.id.y9i) {
            v();
        } else if (id5 == R.id.y9j) {
            w();
        } else if (id5 == R.id.xzw) {
            q();
        } else if (id5 == R.id.xzx) {
            r();
        } else if (id5 == R.id.xzy) {
            s();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
