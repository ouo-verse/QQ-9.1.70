package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.base.room.service.liveview.c;
import com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.qqlive.room.prepare.QQLivePrepareFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ComponentEvent(eventList = {com.tencent.mobileqq.qqlive.anchor.live.startlive.a.class, com.tencent.mobileqq.qqlive.anchor.live.startlive.b.class})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0004J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0017\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004\u00a8\u0006\""}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/p;", "Lcom/tencent/mobileqq/qqlive/framework/component/SingleUIComponent;", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/TimiAnchorView;", "Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/c;", "", "k", "i", "u", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "w", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Landroid/view/ViewGroup;", HippyTKDListViewAdapter.X, "v", "Landroid/os/Bundle;", "arguments", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "onResume", "", "handleBackPressed", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lfi2/a;", "cc", "<init>", "(Lfi2/a;)V", tl.h.F, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class p extends SingleUIComponent<TimiAnchorView> implements com.tencent.mobileqq.qqlive.base.room.service.liveview.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@NotNull fi2.a cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
    }

    public final void A(@Nullable Bundle arguments) {
        r().Z0(arguments);
    }

    public final void B(@Nullable Bundle arguments) {
        Activity activity;
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(0L);
        r().setArgument(arguments);
        if (J3 != null && J3.getAnchorRoomInfo() != null && J3.getAnchorRoomInfo().roomData != null) {
            r().R0(J3.getAnchorRoomInfo().roomData.f271212id, J3.getAnchorRoomInfo().uid);
            e().C0(new com.tencent.mobileqq.qqlive.anchor.live.startlive.a());
            return;
        }
        AegisLogger.INSTANCE.e("Open_Live|TimiAnchorComponent", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "\u5f00\u64ad\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u5f00\u64ad");
        QQToast.makeText(e().getContext(), "\u5f00\u64ad\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u5f00\u64ad", 1).show();
        Context context = e().getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.finish();
        }
        Intent intent = new Intent();
        if (arguments != null) {
            intent.putExtras(arguments);
        }
        QQLivePrepareFragment.Pj(e().getContext(), intent, "");
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.liveview.c
    public boolean handleBackPressed() {
        return r().N0();
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.liveview.c
    public void j() {
        c.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void k() {
        AppUtils.zInitGlobal(e().getContext());
        xl3.a.b(e().getContext());
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.i
    public int m() {
        return com.tencent.mobileqq.qqlive.framework.a.d();
    }

    public final void onDestroy() {
        e().C0(new com.tencent.mobileqq.qqlive.anchor.live.startlive.b());
        r().O0();
        r().f1();
    }

    public final void onResume() {
        r().onResume();
    }

    public final void onStop() {
        r().onStop();
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public TimiAnchorView p() {
        TimiAnchorView timiAnchorView = new TimiAnchorView(e().getContext());
        timiAnchorView.setLifecycle(e().getLifecycleOwner(), e().y());
        return timiAnchorView;
    }

    @NotNull
    public final ViewGroup v() {
        View findViewById = r().findViewById(R.id.yja);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.te\u2026.R.id.linkandpk_viewstub)");
        return (ViewGroup) findViewById;
    }

    @Nullable
    public final FrameLayout w() {
        return r().l0();
    }

    @Nullable
    public final ViewGroup x() {
        return r().m0();
    }

    public final void y() {
        r().p0().U0();
    }

    public final void z(@NotNull String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        r().p0().V0(videoUrl);
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void i() {
    }
}
