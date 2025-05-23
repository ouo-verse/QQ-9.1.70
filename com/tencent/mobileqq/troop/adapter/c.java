package com.tencent.mobileqq.troop.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopHeaderLayout;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf57.cmd0xf57$MedalInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0007J$\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/adapter/c;", "", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "troopItem", "Lcom/tencent/mobileqq/troop/utils/TroopHeaderLayout;", "headerLayout", "Landroid/widget/ImageView;", "stateIconView", "borderView", "", "d", "", "dp", "Landroid/content/Context;", "context", "", "e", "c", "officialIconView", "a", "optIconView1", "optIconView2", "b", "state", "f", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f293796a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23167);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f293796a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull RecommendTroopItem troopItem, @Nullable ImageView officialIconView) {
        int i3;
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        if (officialIconView == null) {
            return;
        }
        Iterator<cmd0xf57$MedalInfo> it = troopItem.medalInfoList.iterator();
        while (true) {
            if (it.hasNext()) {
                cmd0xf57$MedalInfo next = it.next();
                if (next.official_medalInfo_ext.is_offical.get() && !TextUtils.isEmpty(next.official_medalInfo_ext.icon_url.get())) {
                    ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(next.official_medalInfo_ext.icon_url.get(), officialIconView, com.tencent.mobileqq.urldrawable.b.f306350a);
                    i3 = 0;
                    break;
                }
            } else {
                i3 = 8;
                break;
            }
        }
        officialIconView.setVisibility(i3);
    }

    @JvmStatic
    public static final void b(@NotNull RecommendTroopItem troopItem, @Nullable ImageView optIconView1, @Nullable ImageView optIconView2) {
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        if (optIconView1 != null && optIconView2 != null) {
            Iterator<cmd0xf57$MedalInfo> it = troopItem.medalInfoList.iterator();
            int i3 = 8;
            int i16 = 8;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                cmd0xf57$MedalInfo next = it.next();
                if (!next.official_medalInfo_ext.is_offical.get() && !TextUtils.isEmpty(next.icon_url.get())) {
                    if (i16 == 8) {
                        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(next.icon_url.get(), optIconView1, com.tencent.mobileqq.urldrawable.b.f306350a);
                        i16 = 0;
                    } else {
                        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(next.icon_url.get(), optIconView2, com.tencent.mobileqq.urldrawable.b.f306350a);
                        i3 = 0;
                        break;
                    }
                }
            }
            optIconView1.setVisibility(i16);
            optIconView2.setVisibility(i3);
        }
    }

    @JvmStatic
    public static final void c(@NotNull RecommendTroopItem troopItem, @Nullable ImageView stateIconView, @Nullable ImageView borderView) {
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        int a16 = d.a(troopItem);
        int i3 = 0;
        if (stateIconView != null) {
            stateIconView.setVisibility(0);
            stateIconView.setImageResource(f(a16));
        }
        if (borderView != null) {
            if (a16 == 0) {
                i3 = 8;
            }
            borderView.setVisibility(i3);
        }
    }

    @JvmStatic
    public static final void d(@NotNull RecommendTroopItem troopItem, @Nullable TroopHeaderLayout headerLayout, @Nullable ImageView stateIconView, @Nullable ImageView borderView) {
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        if (!d.b(troopItem)) {
            if (stateIconView != null) {
                stateIconView.setVisibility(8);
            }
            if (borderView != null) {
                borderView.setVisibility(8);
            }
            if (headerLayout != null) {
                headerLayout.setClear();
                return;
            }
            return;
        }
        if (headerLayout != null) {
            c cVar = f293796a;
            Context context = headerLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "headerLayout.context");
            headerLayout.setClipCenterX(cVar.e(50, context));
        }
        if (headerLayout != null) {
            c cVar2 = f293796a;
            Context context2 = headerLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "headerLayout.context");
            headerLayout.setClipCenterY(cVar2.e(50, context2));
        }
        if (headerLayout != null) {
            c cVar3 = f293796a;
            Context context3 = headerLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "headerLayout.context");
            headerLayout.setClipRadius(cVar3.e(13, context3));
        }
        if (headerLayout != null) {
            headerLayout.invalidate();
        }
        if (stateIconView != null) {
            stateIconView.setVisibility(0);
        }
        if (stateIconView != null) {
            stateIconView.setImageResource(R.drawable.n8k);
        }
        if (borderView != null) {
            borderView.setVisibility(0);
        }
    }

    private final float e(int dp5, Context context) {
        return (dp5 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @JvmStatic
    public static final int f(int state) {
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (state != 1) {
            if (state != 4) {
                if (state != 5) {
                    if (isNowThemeIsNight) {
                        return R.drawable.guild_recent_channel_icon_night;
                    }
                    return R.drawable.guild_recent_channel_icon;
                }
                if (isNowThemeIsNight) {
                    return R.drawable.n8g;
                }
                return R.drawable.n8h;
            }
            if (isNowThemeIsNight) {
                return R.drawable.n8b;
            }
            return R.drawable.n8c;
        }
        if (isNowThemeIsNight) {
            return R.drawable.n8j;
        }
        return R.drawable.n8k;
    }
}
