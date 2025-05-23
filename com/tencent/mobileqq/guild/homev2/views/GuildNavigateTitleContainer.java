package com.tencent.mobileqq.guild.homev2.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.an;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B1\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000b\u001a\u00020\u0002J\u0014\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ\u0014\u0010\u000f\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/views/GuildNavigateTitleContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "J0", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "O0", "K0", "N0", "L0", "M0", "D0", "Lkotlin/Function0;", "cb", "E0", "F0", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Lvp1/o;", "e", "Lvp1/o;", "mBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildNavigateTitleContainer extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo mGuildInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final o mBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f226078d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0 f226079e;

        public b(View view, Function0 function0) {
            this.f226078d = view;
            this.f226079e = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this.f226079e.invoke();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNavigateTitleContainer(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Function0 cb5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Function0 cb5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(Function0 cb5, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J0() {
        ImageView imageView = this.mBinding.f443067b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_home_v2_title_back, Integer.valueOf(R.color.qui_common_icon_primary)));
    }

    private final void K0(IGProGuildInfo guildInfo) {
        List t16 = GuildMedalUtils.t(guildInfo.getMedalInfoList(), 0, 2, null);
        if (t16.isEmpty()) {
            this.mBinding.f443071f.setVisibility(8);
            return;
        }
        Iterator it = t16.iterator();
        while (it.hasNext()) {
            if (((IGProMedalInfo) it.next()).getOfficialMedalInfoExt().getIsOffical()) {
                an.Companion.f(an.INSTANCE, new WeakReference(this.mBinding.f443071f), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.views.GuildNavigateTitleContainer$updateBadge$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                        invoke(uRLDrawable, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull URLDrawable urlDrawable, int i3) {
                        o oVar;
                        o oVar2;
                        Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                        oVar = GuildNavigateTitleContainer.this.mBinding;
                        oVar.f443071f.setImageDrawable(urlDrawable);
                        oVar2 = GuildNavigateTitleContainer.this.mBinding;
                        oVar2.f443071f.setVisibility(0);
                    }
                }, 0, 4, null);
                return;
            }
        }
        this.mBinding.f443071f.setVisibility(8);
    }

    private final void L0(IGProGuildInfo guildInfo) {
        String url = guildInfo.getAvatarUrl(100);
        if (Intrinsics.areEqual(url, this.mBinding.f443068c.getTag())) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        RoundImageView roundImageView = this.mBinding.f443068c;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "mBinding.guildAvatar");
        v.l(url, roundImageView, null, 4, null);
        this.mBinding.f443068c.setTag(url);
    }

    private final void N0(IGProGuildInfo guildInfo) {
        if (guildInfo.getUserNum() > 0) {
            this.mBinding.f443069d.setText(cp1.c.d(cp1.c.f391536a, guildInfo.getUserNum(), null, 2, null));
        }
    }

    private final void O0(IGProGuildInfo guildInfo) {
        this.mBinding.f443070e.setText(guildInfo.getGuildName());
    }

    public final void D0() {
        this.mBinding.f443068c.setVisibility(8);
        this.mBinding.f443070e.setVisibility(8);
        this.mBinding.f443069d.setVisibility(8);
    }

    public final void E0(@NotNull Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ImageView imageView = this.mBinding.f443067b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.btnBack");
        imageView.setOnClickListener(new b(imageView, cb5));
    }

    public final void F0(@NotNull final Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.mBinding.f443068c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.views.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNavigateTitleContainer.G0(Function0.this, view);
            }
        });
        this.mBinding.f443070e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.views.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNavigateTitleContainer.H0(Function0.this, view);
            }
        });
        this.mBinding.f443069d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.views.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNavigateTitleContainer.I0(Function0.this, view);
            }
        });
    }

    public final void M0(@Nullable IGProGuildInfo guildInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildNavigateTitleContainer", 1, "updateData guildInfo:" + guildInfo);
        }
        this.mGuildInfo = guildInfo;
        this.mBinding.f443068c.setVisibility(0);
        this.mBinding.f443070e.setVisibility(0);
        this.mBinding.f443069d.setVisibility(0);
        if (guildInfo == null) {
            return;
        }
        L0(guildInfo);
        N0(guildInfo);
        O0(guildInfo);
        K0(guildInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNavigateTitleContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNavigateTitleContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildNavigateTitleContainer(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNavigateTitleContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.f235387a.d().i("GuildNavigateTitleContainer", 1, "start init");
        setClipChildren(false);
        o f16 = o.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        f16.f443070e.getPaint().setFakeBoldText(true);
        J0();
    }
}
