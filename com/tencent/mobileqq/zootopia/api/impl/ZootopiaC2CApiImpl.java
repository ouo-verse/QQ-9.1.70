package com.tencent.mobileqq.zootopia.api.impl;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mobileqq.zootopia.helper.SmallHomeHelper;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.utils.d;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.sqshow.zootopia.c2c.ZootopiaC2CAvatarFragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J>\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0016J=\u0010\u001d\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00172!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\t0\u0018H\u0016J2\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/ZootopiaC2CApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaC2CApi;", "Landroidx/fragment/app/FragmentManager;", "fm", "", "initPanelHeight", "maxPanelHeight", "Landroidx/fragment/app/Fragment;", "fragment", "", "showAvatarPanel", "panelHeight", "", "needMaskBackground", "mapId", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "source", "", "", "", QQBrowserActivity.APP_PARAM, "showZootopiaDetailPanel", "homeownerUin", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "checkResult", "callback", "startCloudMod", FavEmoConstant.ROAMING_TYPE_PANEL, "showSmallHomeDetailPanel", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaC2CApiImpl implements IZootopiaC2CApi {
    private static final String TAG_C2C_AVATAR = "C2C_AVATAR";

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi
    public void showAvatarPanel(FragmentManager fm5, int initPanelHeight, int maxPanelHeight, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        d.a(ZootopiaC2CAvatarFragment.INSTANCE.b(new ZootopiaC2CAvatarFragment.Config(initPanelHeight, maxPanelHeight, false, false, false, 0, 60, null), fragment), fm5, TAG_C2C_AVATAR);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi
    public void startCloudMod(String homeownerUin, ZootopiaSource source, final Function1<? super Boolean, Unit> callback) {
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (homeownerUin == null) {
            str = "1";
        } else {
            str = "3";
        }
        ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).T(AdMetricID.Click.SUCCESS, true, source, SmallHomeHelper.f328312a.a(str, homeownerUin), new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.api.impl.ZootopiaC2CApiImpl$startCloudMod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                invoke2(enterModCheckResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EnterModCheckResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.invoke(Boolean.valueOf(it.isPassed()));
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi
    public void showAvatarPanel(FragmentManager fm5, int panelHeight, Fragment fragment, boolean needMaskBackground) {
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        d.a(ZootopiaC2CAvatarFragment.INSTANCE.b(new ZootopiaC2CAvatarFragment.Config(panelHeight, panelHeight, true, needMaskBackground, false, 0, 48, null), fragment), fm5, TAG_C2C_AVATAR);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi
    public void showZootopiaDetailPanel(FragmentManager fm5, int panelHeight, int mapId, FragmentSource source, Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(source, "source");
        ZootopiaDetailFragment a16 = ZootopiaDetailFragment.INSTANCE.a(mapId, new ZootopiaDetailFragment.Config(ZootopiaSource.INSTANCE.j(source.getFrom()), false, false, false, null, null, false, extraParams, 120, null), source);
        d.a(ZootopiaC2CAvatarFragment.INSTANCE.b(new ZootopiaC2CAvatarFragment.Config(panelHeight, panelHeight, true, true, true, 0, 32, null), a16), fm5, TAG_C2C_AVATAR);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi
    public void showSmallHomeDetailPanel(FragmentManager fm5, String homeownerUin, boolean needDownload, FragmentSource source, int panelHeight) {
        String str;
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(source, "source");
        if (homeownerUin == null) {
            str = "1";
        } else {
            str = "3";
        }
        ZootopiaDetailFragment a16 = ZootopiaDetailFragment.INSTANCE.a(AdMetricID.Click.SUCCESS, new ZootopiaDetailFragment.Config(ZootopiaSource.INSTANCE.j(source.getFrom()), false, false, needDownload, null, null, false, SmallHomeHelper.f328312a.a(str, homeownerUin), 112, null), source);
        d.a(ZootopiaC2CAvatarFragment.INSTANCE.b(new ZootopiaC2CAvatarFragment.Config(panelHeight, panelHeight, true, true, true, 0, 32, null), a16), fm5, TAG_C2C_AVATAR);
    }
}
