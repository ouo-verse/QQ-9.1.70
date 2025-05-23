package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/f;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/d;", "", "success", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "myGuildFragmentRef", "myGuildFragment", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<MyGuildFragment> myGuildFragmentRef;

    public f(@NotNull MyGuildFragment myGuildFragment) {
        Intrinsics.checkNotNullParameter(myGuildFragment, "myGuildFragment");
        this.myGuildFragmentRef = new WeakReference<>(myGuildFragment);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.d
    public void a() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.MyGuildFragment", 2, "LoadMoreDataCallback: failed");
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.d
    public void success() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.MyGuildFragment", 2, "LoadMoreDataCallback: success");
        }
    }
}
