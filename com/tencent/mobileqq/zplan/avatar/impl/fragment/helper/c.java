package com.tencent.mobileqq.zplan.avatar.impl.fragment.helper;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.zplan.avatar.impl.fragment.ZPlanAvatarMallHippyFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/helper/c;", "", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "hippyOpenInfo", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/a;", "avatarHippyApi", "", "c", "Lcom/tencent/mobileqq/zplan/avatar/impl/fragment/ZPlanAvatarMallHippyFragment;", "a", "Landroid/os/Bundle;", "args", "b", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "<init>", "(Landroidx/fragment/app/FragmentManager;Landroid/widget/FrameLayout;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FragmentManager fm;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout container;

    public c(FragmentManager fm5, FrameLayout container) {
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Intrinsics.checkNotNullParameter(container, "container");
        this.fm = fm5;
        this.container = container;
    }

    private final ZPlanAvatarMallHippyFragment a(OpenHippyInfo hippyOpenInfo, com.tencent.mobileqq.zplan.avatar.impl.fragment.a avatarHippyApi) {
        ZPlanAvatarMallHippyFragment zPlanAvatarMallHippyFragment = new ZPlanAvatarMallHippyFragment(avatarHippyApi);
        Bundle bundle = hippyOpenInfo.toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("params", bundle);
        zPlanAvatarMallHippyFragment.setArguments(bundle2);
        return zPlanAvatarMallHippyFragment;
    }

    private final void c(OpenHippyInfo hippyOpenInfo, com.tencent.mobileqq.zplan.avatar.impl.fragment.a avatarHippyApi) {
        this.fm.beginTransaction().replace(this.container.getId(), a(hippyOpenInfo, avatarHippyApi), "hippy").commit();
    }

    public final void b(Bundle args, com.tencent.mobileqq.zplan.avatar.impl.fragment.a avatarHippyApi) {
        Intrinsics.checkNotNullParameter(avatarHippyApi, "avatarHippyApi");
        c(new OpenHippyInfo(args != null ? args.getBundle(IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO) : null), avatarHippyApi);
    }
}
