package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\"\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/z;", "Loo1/a;", "", "userConfig", "", "from", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "myGuildFragmentRef", "myGuildFragment", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class z extends oo1.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<MyGuildFragment> myGuildFragmentRef;

    public z(@NotNull MyGuildFragment myGuildFragment) {
        Intrinsics.checkNotNullParameter(myGuildFragment, "myGuildFragment");
        this.myGuildFragmentRef = new WeakReference<>(myGuildFragment);
    }

    @Override // oo1.a
    public void h() {
        QLog.w("Guild.discovery.MyGuildFragment", 1, "onGuildConfigUpdate");
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.fi();
        }
    }

    @Override // oo1.a
    public void q(@NotNull Object userConfig, int from) {
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
        QLog.w("Guild.discovery.MyGuildFragment", 1, "onUserTypeUpdate: " + userConfig);
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.fi();
        }
    }
}
