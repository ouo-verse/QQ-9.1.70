package com.tencent.mobileqq.guild.homev2.parts.title.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cp1.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.bm;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001/B1\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0006\u0012\b\b\u0002\u0010,\u001a\u00020\u0006\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u0002*\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0002R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010!R\u0011\u0010&\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/view/GuildHomeV2TitleLayout;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Landroid/widget/ImageView;", "", "drawableRes", "filterColor", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "g", "i", "j", "l", "p", h.F, "f", "height", "o", "", "isLiving", "k", "isResumed", DomainData.DOMAIN_NAME, "c", "Lvp1/bm;", "d", "Lvp1/bm;", "mBinding", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Z", "mIsLiving", "mIsPageResumed", "mHasBindLivingRes", "()Lvp1/bm;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2TitleLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bm mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo mGuildInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLiving;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPageResumed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mHasBindLivingRes;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2TitleLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        ImageView imageView = this.mBinding.f442506b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.btnBack");
        e(imageView, R.drawable.guild_home_v2_title_back, R.color.qui_common_icon_primary);
        ImageView imageView2 = this.mBinding.f442509e;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.btnSearch");
        e(imageView2, R.drawable.guild_home_v2_title_search, R.color.qui_common_icon_primary);
        ImageView imageView3 = this.mBinding.f442507c;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mBinding.btnManage");
        e(imageView3, R.drawable.guild_home_v2_title_manage, R.color.qui_common_icon_primary);
        ImageView imageView4 = this.mBinding.f442510f;
        Intrinsics.checkNotNullExpressionValue(imageView4, "mBinding.btnShare");
        e(imageView4, R.drawable.guild_home_v2_title_share, R.color.qui_common_icon_primary);
        ImageView imageView5 = this.mBinding.f442508d;
        Intrinsics.checkNotNullExpressionValue(imageView5, "mBinding.btnMore");
        e(imageView5, R.drawable.guild_home_v2_title_more, R.color.qui_common_icon_primary);
        ImageView imageView6 = this.mBinding.f442517m;
        Intrinsics.checkNotNullExpressionValue(imageView6, "mBinding.guildLivingIconArrow");
        e(imageView6, R.drawable.guild_home_v2_title_living_right_arrow, R.color.qui_common_text_primary);
    }

    private final void e(ImageView imageView, @DrawableRes int i3, @ColorRes int i16) {
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(GuildUIUtils.w(context, i3, Integer.valueOf(i16)));
    }

    private final void g(IGProGuildInfo guildInfo) {
        String url = guildInfo.getAvatarUrl(100);
        if (Intrinsics.areEqual(url, this.mBinding.f442512h.getTag())) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        RoundImageView roundImageView = this.mBinding.f442512h;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "mBinding.guildAvatar");
        v.l(url, roundImageView, null, 4, null);
        this.mBinding.f442512h.setTag(url);
    }

    private final void i(IGProGuildInfo guildInfo) {
        if (guildInfo.getUserNum() > 0) {
            this.mBinding.f442519o.setText(c.d(c.f391536a, guildInfo.getUserNum(), null, 2, null));
        }
    }

    private final void j(IGProGuildInfo guildInfo) {
        this.mBinding.f442521q.setText(guildInfo.getGuildName());
        this.mBinding.f442513i.setText(guildInfo.getGuildName());
    }

    private final void l(IGProGuildInfo guildInfo) {
        boolean isBlank;
        float f16;
        String canBeEmptyCoverUrl = guildInfo.getCanBeEmptyCoverUrl(0, 0);
        if (canBeEmptyCoverUrl == null) {
            canBeEmptyCoverUrl = "";
        }
        View view = this.mBinding.f442514j;
        isBlank = StringsKt__StringsJVMKt.isBlank(canBeEmptyCoverUrl);
        if (!isBlank) {
            f16 = 0.15f;
        } else {
            f16 = 0.06f;
        }
        view.setAlpha(f16);
    }

    private final void m() {
        if (this.mIsLiving && this.mIsPageResumed) {
            this.mBinding.f442516l.playAnimation();
        } else {
            this.mBinding.f442516l.pauseAnimation();
        }
    }

    private final void p(IGProGuildInfo guildInfo) {
        int i3 = 0;
        List<? extends IGProMedalInfo> list = null;
        List<? extends IGProMedalInfo> t16 = GuildMedalUtils.t(guildInfo.getMedalInfoList(), 0, 2, null);
        Object tag = this.mBinding.f442518n.getTag();
        if (tag instanceof List) {
            list = (List) tag;
        }
        if (GuildMedalUtils.f235347a.u(t16, list)) {
            return;
        }
        LinearLayout linearLayout = this.mBinding.f442518n;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.guildMedalContainer");
        if (!(!t16.isEmpty())) {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        this.mBinding.f442518n.removeAllViews();
        Iterator<? extends IGProMedalInfo> it = t16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IGProMedalInfo next = it.next();
            if (next.getOfficialMedalInfoExt().getIsOffical()) {
                LinearLayout linearLayout2 = this.mBinding.f442518n;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "mBinding.guildMedalContainer");
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildMedalUtils.j(linearLayout2, next, context);
                break;
            }
        }
        this.mBinding.f442518n.setTag(t16);
    }

    public final void c() {
        String str;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeV2TitleLayout", 1, "forceReloadAvatar tag:" + this.mBinding.f442512h.getTag());
        }
        Object tag = this.mBinding.f442512h.getTag();
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        RoundImageView roundImageView = this.mBinding.f442512h;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "mBinding.guildAvatar");
        v.l(str, roundImageView, null, 4, null);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final bm getMBinding() {
        return this.mBinding;
    }

    public final void f() {
        Logger.f235387a.d().a("GuildHomeV2TitleLayout", 1, "updateColorWhenThemeChange");
        b();
    }

    public final void h(@Nullable IGProGuildInfo guildInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildHomeV2TitleLayout", 1, "updateData guildInfo:" + guildInfo);
        }
        this.mGuildInfo = guildInfo;
        if (guildInfo == null) {
            return;
        }
        g(guildInfo);
        i(guildInfo);
        j(guildInfo);
        p(guildInfo);
        l(guildInfo);
    }

    public final void k(boolean isLiving) {
        int i3;
        Logger.f235387a.d().i("GuildHomeV2TitleLayout", 1, "start updateLivingStatus isLiving:" + isLiving);
        this.mIsLiving = isLiving;
        FrameLayout frameLayout = this.mBinding.f442515k;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.guildLivingContainer");
        if (isLiving) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        if (isLiving && !this.mHasBindLivingRes) {
            this.mBinding.f442516l.setAnimation(HardCodeUtil.qqStr(R.string.f1486910_));
            this.mHasBindLivingRes = true;
        }
        m();
    }

    public final void n(boolean isResumed) {
        this.mIsPageResumed = isResumed;
        m();
    }

    public final void o(int height) {
        FrameLayout root = this.mBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        ViewExtKt.f(root, height + ((int) getResources().getDimension(R.dimen.cfd)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2TitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2TitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeV2TitleLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeV2TitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().i("GuildHomeV2TitleLayout", 1, "start init");
        setClipChildren(false);
        bm g16 = bm.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        g16.f442521q.getPaint().setFakeBoldText(true);
        g16.f442513i.getPaint().setFakeBoldText(true);
        b();
        o(ImmersiveUtils.getStatusBarHeight(context));
    }
}
