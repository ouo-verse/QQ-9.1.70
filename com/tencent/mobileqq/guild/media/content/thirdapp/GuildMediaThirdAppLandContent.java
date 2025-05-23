package com.tencent.mobileqq.guild.media.content.thirdapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.ThirdAppBarClickEvent;
import com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppFullScreenActionBar;
import com.tencent.mobileqq.guild.media.thirdapp.widget.f;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppLandContent;", "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/g;", "", "Xh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "pi", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "C0", "onBackEvent", "onDestroyView", SensorJsPlugin.SENSOR_INTERVAL_UI, "<init>", "()V", "b0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaThirdAppLandContent extends GuildMediaThirdAppContent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b<T> implements Observer<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Boolean it = (Boolean) t16;
            QLog.d(GuildMediaThirdAppLandContent.this.Xh(), 1, "toLandView " + it);
            GuildMediaThirdAppContent.oi(GuildMediaThirdAppLandContent.this, false, 1, null);
            GuildMediaThirdAppLandContent.this.wi();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                GuildMediaThirdAppLandContent.this.Vh().q();
                GuildMediaThirdAppLandContent.this.Vh().setVisibility(0);
            } else {
                GuildMediaThirdAppLandContent.this.Vh().r();
                GuildMediaThirdAppLandContent.this.Vh().setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent, com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean C0() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent
    @NotNull
    public String Xh() {
        return "QGMC.MediaThirdApp.GuildMediaThirdAppLandContent";
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent, com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean onBackEvent() {
        j.d().i(ThirdAppBarClickEvent.MINIMIZE_LAND);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        Logger.b bVar = new Logger.b();
        bVar.a().add("[onCreateView]");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
        }
        View inflate = inflater.inflate(R.layout.eza, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026d_view, container, false)");
        ri(inflate);
        View findViewById = Uh().findViewById(R.id.f96715if);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026d_app_sub_view_container)");
        qi((FrameLayout) findViewById);
        View findViewById2 = Uh().findViewById(R.id.f96495hu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026rd_app_action_bar_layout)");
        si((GuildMediaThirdAppFullScreenActionBar) findViewById2);
        Vh().setMediaMicStateViewModel(qh(), new WeakReference(this));
        Vh().setOrientationIsPortrait(false);
        if (getMContentView() != null) {
            Logger logger2 = Logger.f235387a;
            String Xh2 = Xh();
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("[onCreateView] destroyContentView");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e(Xh2, 1, (String) it5.next(), null);
            }
            Ph();
        }
        ph().j2(true);
        View Uh = Uh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, Uh);
        return Uh;
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        Logger.b bVar = new Logger.b();
        bVar.a().add("[onDestroyView]");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
        }
        ph().a2().postValue(Boolean.FALSE);
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        Logger.b bVar = new Logger.b();
        bVar.a().add("[onViewCreated]");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
        }
        super.onViewCreated(view, savedInstanceState);
        f mContentView = getMContentView();
        if (mContentView != null) {
            mContentView.setLandFullUI();
        }
        f mContentView2 = getMContentView();
        if (mContentView2 != null) {
            mContentView2.setHorizontalMarginGone();
        }
        Vh().q();
        Vh().setVisibility(0);
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent
    public void pi() {
        MutableLiveData<Boolean> a26 = ph().a2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        a26.observe(viewLifecycleOwner, new b());
    }

    @Override // com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent
    public void ui() {
        j.d().i(ThirdAppBarClickEvent.MINIMIZE_LAND);
    }
}
