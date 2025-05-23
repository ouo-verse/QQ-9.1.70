package com.qzone.reborn.feedx.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneUserAvatarView extends RFWRoundImageView {

    /* renamed from: h, reason: collision with root package name */
    private static int f55955h = 1;

    /* renamed from: d, reason: collision with root package name */
    private long f55956d;

    /* renamed from: e, reason: collision with root package name */
    private a f55957e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55958f;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(View view);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f55959a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f55960b = true;
    }

    public QZoneUserAvatarView(Context context) {
        this(context, null);
    }

    private Activity d() {
        return i.c(this);
    }

    static int e() {
        int i3 = f55955h + 1;
        f55955h = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.f55958f) {
            ho.i.z().m(d(), this.f55956d);
        }
        a aVar = this.f55957e;
        if (aVar != null) {
            aVar.a(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setIsShieldJumpToMainPage(boolean z16) {
        this.f55958f = z16;
    }

    public void setOnClickHookListener(a aVar) {
        this.f55957e = aVar;
    }

    public void setUser(User user) {
        setUser(user, new b());
    }

    public QZoneUserAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUser(long j3) {
        setUser(j3, new b());
    }

    public QZoneUserAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserAvatarView.this.f(view);
            }
        });
    }

    public void setUser(long j3, b bVar) {
        this.f55956d = j3;
        setImageDrawable(com.qzone.reborn.feedx.util.e.e(this, j3, bVar));
    }

    public void setCommonUser(CommonUser commonUser) {
        Drawable e16;
        if (commonUser == null) {
            return;
        }
        this.f55956d = ef.d.k(commonUser.getUin());
        b bVar = new b();
        if (commonUser.getIsAnonymous()) {
            String r16 = com.qzone.reborn.configx.g.f53821a.c().r();
            ImageUrl imageUrl = new ImageUrl();
            long j3 = this.f55956d;
            if (j3 == 0) {
                j3 = e();
            }
            e16 = com.qzone.reborn.feedx.util.e.h(this, imageUrl, r16, j3);
        } else {
            e16 = com.qzone.reborn.feedx.util.e.e(this, this.f55956d, bVar);
        }
        if (e16 == null) {
            e16 = com.qzone.reborn.feedx.util.e.a();
        }
        setImageDrawable(e16);
    }

    public void setUser(User user, b bVar) {
        Drawable e16;
        if (user == null) {
            return;
        }
        this.f55956d = user.uin;
        bVar.f55960b = bVar.f55960b && !(TextUtils.isEmpty(user.feedAvatarDecorationUrl) ^ true);
        int i3 = user.from;
        if (i3 == 0 || i3 == 1) {
            e16 = com.qzone.reborn.feedx.util.e.e(this, this.f55956d, bVar);
        } else if (i3 == 2 || i3 == 4) {
            ImageUrl imageUrl = user.logoImageUrl;
            String str = user.logo;
            long j3 = this.f55956d;
            if (j3 == 0) {
                j3 = e();
            }
            e16 = com.qzone.reborn.feedx.util.e.h(this, imageUrl, str, j3);
        } else if (i3 != 5) {
            if (i3 == 8) {
                if (user.logoImageUrl == null && TextUtils.isEmpty(user.logo)) {
                    e16 = com.qzone.reborn.feedx.util.e.e(this, this.f55956d, bVar);
                } else {
                    ImageUrl imageUrl2 = user.logoImageUrl;
                    String str2 = user.logo;
                    long j16 = this.f55956d;
                    if (j16 == 0) {
                        j16 = e();
                    }
                    e16 = com.qzone.reborn.feedx.util.e.h(this, imageUrl2, str2, j16);
                }
            }
            e16 = null;
        } else {
            String str3 = user.descicon;
            if (str3 != null) {
                e16 = com.qzone.reborn.feedx.util.e.h(this, user.desciconImageUrl, str3, str3.hashCode());
            }
            e16 = null;
        }
        if (e16 == null) {
            e16 = com.qzone.reborn.feedx.util.e.a();
        }
        setImageDrawable(e16);
    }
}
