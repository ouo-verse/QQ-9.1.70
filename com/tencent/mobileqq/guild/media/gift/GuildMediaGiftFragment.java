package com.tencent.mobileqq.guild.media.gift;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.guild.media.core.EnterChannelState;
import com.tencent.mobileqq.guild.media.gift.GuildMediaGiftFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/gift/GuildMediaGiftFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/guild/gift/module/m;", "Lcom/tencent/mobileqq/guild/gift/view/banner/f;", "", "uh", "th", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "contentView", "of", "t", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "giftAnimData", "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "R7", "Lcom/tencent/mobileqq/guild/gift/view/banner/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/gift/view/banner/e;", "giftBanner", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaGiftFragment extends QPublicBaseFragment implements m, com.tencent.mobileqq.guild.gift.view.banner.f {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.gift.view.banner.e giftBanner = com.tencent.mobileqq.guild.gift.view.banner.a.f224618a.a(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildMediaGiftFragment$b", "Lcom/tencent/mobileqq/guild/gift/module/d;", "", "success", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "pngFilePath", "apngFilePath", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.gift.module.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.gift.module.d f228921a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f228922b;

        b(com.tencent.mobileqq.guild.gift.module.d dVar, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
            this.f228921a = dVar;
            this.f228922b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftAnimData, String str) {
            Intrinsics.checkNotNullParameter(giftAnimData, "$giftAnimData");
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.m(giftAnimData, str));
        }

        @Override // com.tencent.mobileqq.guild.gift.module.d
        public void a(boolean success, int materialId, @Nullable final String pngFilePath, @Nullable String apngFilePath) {
            this.f228921a.a(success, materialId, pngFilePath, apngFilePath);
            final com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f228922b;
            Function0.b(1000, new Runnable() { // from class: com.tencent.mobileqq.guild.media.gift.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaGiftFragment.b.c(com.tencent.mobileqq.qqgift.mvvm.business.anim.a.this, pngFilePath);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(GuildMediaGiftFragment this$0, EnterChannelState enterChannelState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (enterChannelState == EnterChannelState.ENTER_SUC) {
            this$0.uh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(GuildMediaGiftFragment this$0, com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar != null) {
            this$0.giftBanner.c(aVar);
        }
    }

    private final void th() {
        com.tencent.mobileqq.guild.media.core.j.a().b0().e(this);
    }

    private final void uh() {
        com.tencent.mobileqq.guild.media.core.logic.gift.a b06 = com.tencent.mobileqq.guild.media.core.j.a().b0();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        View requireView = requireView();
        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
        b06.b(lifecycle, null, (ViewGroup) requireView);
    }

    @Override // com.tencent.mobileqq.guild.gift.view.banner.f
    public void R7(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftAnimData, @NotNull com.tencent.mobileqq.guild.gift.module.d callback) {
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.guild.media.core.j.a().b0().a(giftAnimData.f264914e, new b(callback, giftAnimData));
    }

    @Override // com.tencent.mobileqq.guild.gift.module.m
    public void of(@NotNull View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.giftBanner.b(contentView.getY() + ViewUtils.dip2px(70.0f));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View a16 = this.giftBanner.a(inflater);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, a16);
        return a16;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.giftBanner.onDestroy();
        com.tencent.mobileqq.guild.media.core.j.a().b0().f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        th();
        com.tencent.mobileqq.guild.media.core.j.c().l().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.media.gift.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaGiftFragment.rh(GuildMediaGiftFragment.this, (EnterChannelState) obj);
            }
        });
        com.tencent.mobileqq.guild.media.core.j.c().q().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.media.gift.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaGiftFragment.sh(GuildMediaGiftFragment.this, (com.tencent.mobileqq.qqgift.mvvm.business.anim.a) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.gift.module.m
    public void t() {
        this.giftBanner.t();
    }
}
