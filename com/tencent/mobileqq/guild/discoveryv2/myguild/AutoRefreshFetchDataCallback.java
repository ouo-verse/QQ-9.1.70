package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016R%\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/AutoRefreshFetchDataCallback;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/d;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "", "c", "success", "a", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "b", "()Lmqq/util/WeakReference;", "myGuildFragmentRef", "myGuildFragment", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class AutoRefreshFetchDataCallback implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<MyGuildFragment> myGuildFragmentRef;

    public AutoRefreshFetchDataCallback(@NotNull MyGuildFragment myGuildFragment) {
        Intrinsics.checkNotNullParameter(myGuildFragment, "myGuildFragment");
        this.myGuildFragmentRef = new WeakReference<>(myGuildFragment);
    }

    private final void c(final MyGuildFragment myGuildFragment) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f152851ai);
            if (myGuildFragment.getMyGuildAdapter().getUiState() == 0) {
                myGuildFragment.getMyGuildAdapter().p0(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.AutoRefreshFetchDataCallback$handleNetworkAndEmpty$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MyGuildFragment.this.getMyGuildAdapter().n0();
                        MyGuildFragment.this.showLoading();
                        MyGuildFragment.this.Sh(this);
                    }
                });
            }
        }
        if (myGuildFragment.getMyGuildAdapter().getUiState() == 0) {
            myGuildFragment.getMyGuildAdapter().showEmptyView();
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.d
    public void a() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.MyGuildFragment", 2, "RefreshFetchDataCallback: failed");
        }
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.hideLoading();
            c(myGuildFragment);
        }
    }

    @NotNull
    public final WeakReference<MyGuildFragment> b() {
        return this.myGuildFragmentRef;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.d
    public void success() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.MyGuildFragment", 2, "RefreshFetchDataCallback: success");
        }
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.hideLoading();
            c(myGuildFragment);
        }
    }
}
