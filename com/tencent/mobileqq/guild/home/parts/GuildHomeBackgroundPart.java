package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.subhome.g;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0012\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeBackgroundPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "", "K9", "P9", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "<set-?>", "e", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "J9", "()Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "coverBelow", "f", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "onStateUpdate", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeBackgroundPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildHomeCoverBelowList coverBelow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.g onStateUpdate = O9();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeBackgroundPart$b", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "Lbp1/a;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.home.subhome.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f224894b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildHomeBackgroundPart f224895c;

        public b(String str, GuildHomeBackgroundPart guildHomeBackgroundPart) {
            this.f224894b = str;
            this.f224895c = guildHomeBackgroundPart;
        }

        @Override // com.tencent.mobileqq.guild.home.subhome.g
        public void a(@NotNull bp1.a state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.f224895c.J9().g(true, (int) state.getOffset());
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.GuildHomeBackgroundPart", "newStateUpdateCallback alpha:" + (1 - state.getFloatTitleAlpha()) + " offset:" + state.getOffset() + " state:" + state);
            }
            this.f224895c.J9().h(1 - state.getFloatTitleAlpha());
        }
    }

    private final void K9() {
        View findViewById = getPartRootView().findViewById(R.id.u_r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.cover_below)");
        this.coverBelow = (GuildHomeCoverBelowList) findViewById;
        J9().setGuildFacadeType(GuildFacadeType.FeedsGuildHome9015);
        J9().g(true, 0);
        J9().setRadiusFrameLayoutTopMargin(0);
        if (B9() == GuildFacadeType.GameCenter) {
            J9().setVisibility(8);
        }
        LiveData<String> U1 = E9().getCoverViewModel().U1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final GuildHomeBackgroundPart$initCoverView$1 guildHomeBackgroundPart$initCoverView$1 = new GuildHomeBackgroundPart$initCoverView$1(this);
        U1.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeBackgroundPart.L9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> S1 = E9().getGuildNetViewModel().S1();
        LifecycleOwner hostLifecycleOwner2 = getPartHost().getHostLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeBackgroundPart$initCoverView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                String value = GuildHomeBackgroundPart.this.E9().getCoverViewModel().U1().getValue();
                if (value != null) {
                    GuildHomeBackgroundPart.this.J9().j(value);
                }
            }
        };
        S1.observe(hostLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeBackgroundPart.M9(Function1.this, obj);
            }
        });
        LiveData<GuildHomeCoverColors> T1 = E9().getHeaderColorsViewModel().T1();
        LifecycleOwner hostLifecycleOwner3 = getPartHost().getHostLifecycleOwner();
        final Function1<GuildHomeCoverColors, Unit> function12 = new Function1<GuildHomeCoverColors, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeBackgroundPart$initCoverView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
                invoke2(guildHomeCoverColors);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeCoverColors guildHomeCoverColors) {
                GuildHomeBackgroundPart.this.J9().i(guildHomeCoverColors.getMainColor());
            }
        };
        T1.observe(hostLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeBackgroundPart.N9(Function1.this, obj);
            }
        });
        J9().setOnBgBitmapUpdated(new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeBackgroundPart$initCoverView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildHomeBackgroundPart.this.E9().getHeaderColorsViewModel().W1(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.guild.home.subhome.g O9() {
        g.Companion companion = com.tencent.mobileqq.guild.home.subhome.g.INSTANCE;
        return new b("Guild.NewHome.GuildHomeBackgroundPart", this);
    }

    private final void P9() {
        E9().getCoverViewModel().a2(J9());
    }

    @NotNull
    public final GuildHomeCoverBelowList J9() {
        GuildHomeCoverBelowList guildHomeCoverBelowList = this.coverBelow;
        if (guildHomeCoverBelowList != null) {
            return guildHomeCoverBelowList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        setRootView(rootView);
        K9();
        P9();
    }

    @Override // com.tencent.mobileqq.guild.home.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        A9().h(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        A9().C(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
    }
}
