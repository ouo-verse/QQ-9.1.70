package com.tencent.mobileqq.guild.feed.partpanel.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public b f222654a = new b();

    /* renamed from: b, reason: collision with root package name */
    public a f222655b = new a();

    /* renamed from: c, reason: collision with root package name */
    public C7772c f222656c = new C7772c();

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f222657d;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f222658a = -16777216;

        /* renamed from: b, reason: collision with root package name */
        public int f222659b = -7829368;

        /* renamed from: c, reason: collision with root package name */
        public int f222660c = -16776961;

        /* renamed from: d, reason: collision with root package name */
        public int f222661d = -1;
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f222662a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f222663b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f222664c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f222665d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f222666e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f222667f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f222668g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f222669h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f222670i = 13;

        /* renamed from: j, reason: collision with root package name */
        public int f222671j = 16;

        /* renamed from: k, reason: collision with root package name */
        public int f222672k;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.partpanel.ui.c$c, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C7772c {

        /* renamed from: a, reason: collision with root package name */
        public int f222673a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f222674b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f222675c = 0;
    }

    public void a(@NonNull Context context, boolean z16) {
        Resources resources = context.getResources();
        this.f222654a.f222662a = resources.getDimensionPixelOffset(R.dimen.ci5);
        this.f222654a.f222664c = ViewUtils.dpToPx(44.0f) + ImmersiveUtils.getStatusBarHeight(context);
        b bVar = this.f222654a;
        bVar.f222672k = bVar.f222664c;
        bVar.f222663b = resources.getDimensionPixelSize(R.dimen.cfa);
        this.f222654a.f222665d = resources.getDimensionPixelSize(R.dimen.ci6);
        this.f222654a.f222668g = (int) (ViewUtils.getScreenWidth() * 0.028d);
        this.f222654a.f222669h = (int) (ViewUtils.getScreenWidth() * 0.019d);
        this.f222654a.f222666e = ViewUtils.dpToPx(20.0f);
        this.f222654a.f222667f = ViewUtils.dpToPx(31.0f);
        if (z16) {
            c(resources);
        } else {
            b(resources);
        }
    }

    public void b(Resources resources) {
        this.f222655b.f222661d = ResourcesCompat.getColor(resources, R.color.qui_common_bg_middle_light, null);
        this.f222655b.f222658a = ResourcesCompat.getColor(resources, R.color.qui_common_text_primary, null);
        this.f222655b.f222660c = ResourcesCompat.getColor(resources, R.color.qui_common_brand_standard, null);
        this.f222655b.f222659b = ResourcesCompat.getColor(resources, R.color.qui_common_text_secondary, null);
        C7772c c7772c = this.f222656c;
        c7772c.f222673a = R.drawable.guild_qui_common_bg_middle_light_bg_cornor_8;
        c7772c.f222674b = R.drawable.guild_list_item_overlay_light_bg;
        c7772c.f222675c = R.drawable.guild_channel_item_icon_bg;
        this.f222657d = null;
    }

    public void c(Resources resources) {
        this.f222655b.f222661d = resources.getColor(R.color.bq9);
        this.f222655b.f222658a = resources.getColor(R.color.bq_);
        this.f222655b.f222660c = resources.getColor(R.color.qui_common_brand_standard);
        C7772c c7772c = this.f222656c;
        c7772c.f222673a = R.drawable.guild_live_at_and_tag_title_bg_drawable;
        c7772c.f222674b = R.drawable.guild_live_aio_at_common_list_item_background;
        c7772c.f222675c = R.drawable.guild_live_tag_panel_item_icon_bg;
        this.f222657d = null;
    }
}
