package no0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public b f420571a = new b();

    /* renamed from: b, reason: collision with root package name */
    public a f420572b = new a();

    /* renamed from: c, reason: collision with root package name */
    public c f420573c = new c();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ColorStateList f420574a;

        /* renamed from: b, reason: collision with root package name */
        public int f420575b;

        /* renamed from: c, reason: collision with root package name */
        public int f420576c;

        /* renamed from: d, reason: collision with root package name */
        public int f420577d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f420578e;

        /* renamed from: f, reason: collision with root package name */
        public int f420579f;

        /* renamed from: g, reason: collision with root package name */
        public int f420580g;

        /* renamed from: h, reason: collision with root package name */
        public int f420581h;

        /* renamed from: i, reason: collision with root package name */
        public int f420582i;

        /* renamed from: j, reason: collision with root package name */
        public int f420583j;

        /* renamed from: k, reason: collision with root package name */
        public int f420584k;

        /* renamed from: l, reason: collision with root package name */
        public int f420585l;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f420586a;

        /* renamed from: b, reason: collision with root package name */
        public int f420587b;

        /* renamed from: c, reason: collision with root package name */
        public int f420588c;

        /* renamed from: d, reason: collision with root package name */
        public int f420589d;

        /* renamed from: e, reason: collision with root package name */
        public int f420590e;

        /* renamed from: f, reason: collision with root package name */
        public int f420591f;

        /* renamed from: g, reason: collision with root package name */
        public int f420592g;

        /* renamed from: h, reason: collision with root package name */
        public int f420593h;

        /* renamed from: i, reason: collision with root package name */
        public int f420594i;

        /* renamed from: j, reason: collision with root package name */
        public int f420595j;

        /* renamed from: k, reason: collision with root package name */
        public int f420596k;

        /* renamed from: l, reason: collision with root package name */
        public int f420597l;

        /* renamed from: m, reason: collision with root package name */
        public final int f420598m = 4;

        /* renamed from: n, reason: collision with root package name */
        public int f420599n;

        /* renamed from: o, reason: collision with root package name */
        public int f420600o;

        /* renamed from: p, reason: collision with root package name */
        public int f420601p;

        /* renamed from: q, reason: collision with root package name */
        public float f420602q;

        /* renamed from: r, reason: collision with root package name */
        public float f420603r;

        /* renamed from: s, reason: collision with root package name */
        public int f420604s;

        /* renamed from: t, reason: collision with root package name */
        public int f420605t;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public int f420606a;

        /* renamed from: b, reason: collision with root package name */
        public int f420607b = R.drawable.guild_at_panel_searchbar_bg;

        /* renamed from: c, reason: collision with root package name */
        public int f420608c = R.drawable.guild_at_panel_searchbar_capsule_bg;

        /* renamed from: d, reason: collision with root package name */
        public int f420609d = R.drawable.guild_aio_input_cursor;

        /* renamed from: e, reason: collision with root package name */
        public int f420610e = R.drawable.qui_search;

        /* renamed from: f, reason: collision with root package name */
        public int f420611f = R.drawable.qui_close_filled_icon_secondary_01_selector;
    }

    public void a(Context context) {
        Resources resources = context.getResources();
        this.f420573c.f420606a = R.drawable.guild_live_at_and_tag_title_bg_drawable;
        this.f420572b.f420574a = AppCompatResources.getColorStateList(context, R.color.bq_);
        a aVar = this.f420572b;
        aVar.f420580g = R.color.bl8;
        aVar.f420582i = resources.getColor(R.color.bq9);
        this.f420572b.f420584k = resources.getColor(R.color.bq9);
        a aVar2 = this.f420572b;
        aVar2.f420583j = aVar2.f420582i;
        aVar2.f420585l = aVar2.f420584k;
    }

    public void b(@NonNull Context context, boolean z16) {
        c(context);
        if (z16) {
            a(context);
        }
    }

    public void c(Context context) {
        Resources resources = context.getResources();
        this.f420571a.f420590e = ViewUtils.dpToPx(28.0f);
        this.f420571a.f420588c = ViewUtils.dpToPx(87.666664f);
        this.f420571a.f420589d = ViewUtils.dpToPx(65.0f);
        b bVar = this.f420571a;
        bVar.f420596k = bVar.f420590e;
        bVar.f420586a = ViewUtils.dpToPx(44.0f);
        this.f420571a.f420591f = ViewUtils.dpToPx(16.0f);
        this.f420571a.f420592g = ViewUtils.dpToPx(8.0f);
        this.f420571a.f420593h = ViewUtils.dpToPx(0.0f);
        this.f420571a.f420594i = (int) (ViewUtils.getScreenWidth() * 0.016d);
        b bVar2 = this.f420571a;
        int i3 = bVar2.f420594i;
        bVar2.f420595j = i3;
        bVar2.f420597l = 16;
        bVar2.f420587b = (bVar2.f420590e * 3) + (i3 * 4);
        bVar2.f420599n = ViewUtils.spToPx(57.0f);
        this.f420571a.f420600o = ViewUtils.dpToPx(56.0f);
        this.f420571a.f420601p = ViewUtils.dpToPx(52.0f);
        b bVar3 = this.f420571a;
        bVar3.f420603r = 10.5f;
        bVar3.f420602q = 1.0f;
        bVar3.f420605t = ViewUtils.dpToPx(44.0f) + ImmersiveUtils.getStatusBarHeight(context);
        b bVar4 = this.f420571a;
        bVar4.f420604s = bVar4.f420605t;
        this.f420572b.f420575b = ResourcesCompat.getColor(context.getResources(), R.color.qui_common_text_secondary, null);
        this.f420572b.f420578e = ResourcesCompat.getColor(context.getResources(), R.color.qui_common_bg_middle_light, null);
        this.f420572b.f420576c = ResourcesCompat.getColor(resources, R.color.qui_common_text_primary, null);
        this.f420572b.f420574a = context.getColorStateList(R.color.qui_common_text_primary);
        a aVar = this.f420572b;
        int i16 = aVar.f420578e;
        aVar.f420582i = i16;
        aVar.f420579f = R.color.bl6;
        aVar.f420580g = R.color.guild_skin_content_text2;
        aVar.f420581h = R.color.bl6;
        aVar.f420583j = i16;
        aVar.f420584k = i16;
        aVar.f420585l = i16;
        this.f420573c.f420606a = R.drawable.guild_popup_drag_window_titlebar_bg_light;
    }
}
