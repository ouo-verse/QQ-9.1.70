package n33;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelEffectView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ar;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f418121a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f418122b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f418123c;

    static {
        String str;
        String str2;
        boolean isEnable = ar.b("kenaiyu", "2025-03-19", "vas_troop_effect_display_once").isEnable(false);
        f418121a = isEnable;
        if (isEnable) {
            str = "https://static-res.qq.com/static-res/groupInteract/vas/a/4_1_";
        } else {
            str = "https://tianquan.gtimg.cn/shoal/vaclient/vas-groupInteract-new-250423-4-1-";
        }
        f418122b = str;
        if (isEnable) {
            str2 = "https://tianquan.gtimg.cn/shoal/vaclient/groupInteract";
        } else {
            str2 = "https://tianquan.gtimg.cn/shoal/vaclient/groupInteract-new-250423-";
        }
        f418123c = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(k kVar) {
        kVar.w(4);
        kVar.D(10.0f);
        kVar.E(10.0f);
        if (!f418121a) {
            kVar.I(false);
            kVar.y(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(k kVar) {
        kVar.I(false);
        kVar.y(1);
    }

    public void c(Context context, ViewGroup viewGroup, int i3, String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith(f418123c) && f418121a) {
                z16 = false;
            } else {
                z16 = true;
            }
            TroopMemberLevelEffectView troopMemberLevelEffectView = new TroopMemberLevelEffectView(context);
            troopMemberLevelEffectView.setLayoutParams(new RelativeLayout.LayoutParams(i3, ViewUtils.dip2px(16.0f)));
            if (z16) {
                troopMemberLevelEffectView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                troopMemberLevelEffectView.setLeftCropRect(new Rect(0, 0, i3, ViewUtils.dip2px(16.0f)));
                troopMemberLevelEffectView.setCurrentDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(str).l(VasDynamicDrawableCache.INSTANCE).g(new a.c() { // from class: n33.a
                    @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                    public final void a(k kVar) {
                        c.f(kVar);
                    }
                }).a());
                viewGroup.setPadding(viewGroup.getPaddingLeft(), 0, viewGroup.getPaddingRight(), 0);
                viewGroup.addView(troopMemberLevelEffectView, 0);
                return;
            }
            if (f418121a) {
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setLoadingDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                apngOptions.setTagId(new int[]{0});
                URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("VasTroopHonorRichHandler", str, apngOptions);
                if (apngURLDrawable != null) {
                    troopMemberLevelEffectView.setScaleType(ImageView.ScaleType.FIT_START);
                    troopMemberLevelEffectView.setLeftCropRect(new Rect(0, 0, ViewUtils.dip2px(51.0f), ViewUtils.dip2px(16.0f)));
                    troopMemberLevelEffectView.setCurrentDrawable(apngURLDrawable);
                    viewGroup.addView(troopMemberLevelEffectView);
                    return;
                }
                return;
            }
            FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(str).l(VasDynamicDrawableCache.INSTANCE).g(new a.c() { // from class: n33.b
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(k kVar) {
                    c.g(kVar);
                }
            }).a();
            troopMemberLevelEffectView.setScaleType(ImageView.ScaleType.FIT_START);
            troopMemberLevelEffectView.setLeftCropRect(new Rect(0, 0, ViewUtils.dip2px(51.0f), ViewUtils.dip2px(16.0f)));
            troopMemberLevelEffectView.setCurrentDrawable(a16);
            viewGroup.addView(troopMemberLevelEffectView);
        }
    }

    public void d(int i3, byte b16, com.tencent.mobileqq.troop.troopmemberlevel.a aVar) {
        e(i3, com.tencent.mobileqq.troop.honor.util.a.h(4, b16), aVar);
    }

    public void e(int i3, int i16, com.tencent.mobileqq.troop.troopmemberlevel.a aVar) {
        if (i16 == 1) {
            switch (i3) {
                case 300:
                    aVar.f300599j = f418122b + "1.png";
                    return;
                case 301:
                    aVar.f300599j = f418122b + "2.png";
                    return;
                case 302:
                    aVar.f300599j = f418122b + "3.png";
                    return;
                default:
                    aVar.f300599j = f418122b + "4.png";
                    return;
            }
        }
        if (i16 == 2) {
            switch (i3) {
                case 300:
                    aVar.f300599j = f418123c + "1.png";
                    return;
                case 301:
                    aVar.f300599j = f418123c + "2.png";
                    return;
                case 302:
                    aVar.f300599j = f418123c + "3.png";
                    return;
                default:
                    aVar.f300599j = f418123c + "4.png";
                    return;
            }
        }
        aVar.f300599j = null;
    }
}
