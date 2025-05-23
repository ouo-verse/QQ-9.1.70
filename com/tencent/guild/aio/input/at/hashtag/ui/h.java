package com.tencent.guild.aio.input.at.hashtag.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public b f110931a = new b();

    /* renamed from: b, reason: collision with root package name */
    public a f110932b = new a();

    /* renamed from: c, reason: collision with root package name */
    public c f110933c = new c();

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f110934d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f110935a = -16777216;

        /* renamed from: b, reason: collision with root package name */
        public int f110936b = R.color.qui_common_text_primary;

        /* renamed from: c, reason: collision with root package name */
        public int f110937c = -7829368;

        /* renamed from: d, reason: collision with root package name */
        public int f110938d = -1;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f110939a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f110940b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f110941c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f110942d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f110943e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f110944f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f110945g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f110946h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f110947i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f110948j = 13;

        /* renamed from: k, reason: collision with root package name */
        public int f110949k = 16;

        /* renamed from: l, reason: collision with root package name */
        public int f110950l;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f110951a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f110952b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f110953c = 0;
    }

    public void a(@NonNull Context context, boolean z16) {
        Resources resources = context.getResources();
        this.f110931a.f110940b = resources.getDimensionPixelOffset(R.dimen.cf_);
        this.f110931a.f110941c = resources.getDimensionPixelOffset(R.dimen.cf9);
        b bVar = this.f110931a;
        bVar.f110939a = (int) (bVar.f110940b * 0.55932206f);
        bVar.f110943e = ViewUtils.dpToPx(44.0f) + ImmersiveUtils.getStatusBarHeight(context);
        b bVar2 = this.f110931a;
        bVar2.f110950l = bVar2.f110943e;
        bVar2.f110942d = resources.getDimensionPixelSize(R.dimen.cfa);
        this.f110931a.f110946h = (int) (ViewUtils.getScreenWidth() * 0.028d);
        this.f110931a.f110947i = (int) (ViewUtils.getScreenWidth() * 0.019d);
        this.f110931a.f110944f = ViewUtils.dpToPx(20.0f);
        this.f110931a.f110945g = ViewUtils.dpToPx(31.0f);
        if (z16) {
            c(resources);
        } else {
            b(resources);
        }
    }

    public void b(Resources resources) {
        this.f110932b.f110938d = ResourcesCompat.getColor(resources, R.color.qui_common_bg_middle_light, null);
        this.f110932b.f110935a = ResourcesCompat.getColor(resources, R.color.qui_common_text_primary, null);
        a aVar = this.f110932b;
        aVar.f110936b = R.color.qui_common_text_primary;
        aVar.f110937c = ResourcesCompat.getColor(resources, R.color.qui_common_text_secondary, null);
        c cVar = this.f110933c;
        cVar.f110951a = R.drawable.guild_qui_common_bg_middle_light_bg_cornor_8;
        cVar.f110952b = R.drawable.guild_list_item_overlay_light_bg;
        cVar.f110953c = R.drawable.guild_channel_item_icon_bg;
        this.f110934d = null;
    }

    public void c(Resources resources) {
        this.f110932b.f110938d = resources.getColor(R.color.bq9);
        this.f110932b.f110935a = resources.getColor(R.color.bq_);
        this.f110932b.f110936b = R.color.bq_;
        c cVar = this.f110933c;
        cVar.f110951a = R.drawable.guild_live_at_and_tag_title_bg_drawable;
        cVar.f110952b = R.drawable.guild_live_aio_at_common_list_item_background;
        cVar.f110953c = R.drawable.guild_live_tag_panel_item_icon_bg;
        this.f110934d = null;
    }
}
