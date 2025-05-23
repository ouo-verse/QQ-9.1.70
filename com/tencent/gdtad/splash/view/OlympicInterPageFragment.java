package com.tencent.gdtad.splash.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.util.AdStatusBarUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gdtad.event.OlympicInterPageCloseEvent;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b,\u0010-J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d`\u001eH\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/gdtad/splash/view/OlympicInterPageFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lcom/tencent/mobileqq/pad/f;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/gdtad/event/OlympicInterPageCloseEvent;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "qOnBackPressed", "qOnNewIntent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "needImmersive", "needStatusTrans", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "getMRootView", "()Landroid/widget/FrameLayout;", "setMRootView", "(Landroid/widget/FrameLayout;)V", "mRootView", "<init>", "()V", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class OlympicInterPageFragment extends QBaseFragment implements f, SimpleEventReceiver<OlympicInterPageCloseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "OlympicInterPageFragment";

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(OlympicInterPageFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        FrameLayout frameLayout = this$0.mRootView;
        if (frameLayout != null) {
            frameLayout.addView(it, new FrameLayout.LayoutParams(-1, -1));
        }
        GDTLogger.i("OlympicInterPageFragment add");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<OlympicInterPageCloseEvent>> getEventClass() {
        ArrayList<Class<OlympicInterPageCloseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(OlympicInterPageCloseEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            AdStatusBarUtil.setTransparent(window);
        }
        if (activity != null) {
            try {
                activity.overridePendingTransition(R.anim.f154656ps, 0);
            } catch (Throwable th5) {
                GdtLog.e(this.TAG, "[initWindowStyleAndAnimation]", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fqh, container, false);
        this.mRootView = frameLayout;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c.f109468a.c(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        FragmentActivity activity;
        if ((event instanceof OlympicInterPageCloseEvent) && (activity = getActivity()) != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        GDTLogger.i("OlympicInterPageFragment onViewCreated");
        SimpleEventBus.getInstance().registerReceiver(this);
        final View b16 = c.f109468a.b();
        if (b16 != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.gdtad.splash.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    OlympicInterPageFragment.qh(OlympicInterPageFragment.this, b16);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }
}
