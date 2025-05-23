package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.feed.event.GuildScrollFollowClickViewEvent;
import com.tencent.mobileqq.guild.feed.event.GuildScrollFollowInputEvent;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 72\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00018B\u0011\u0012\b\b\u0002\u0010,\u001a\u00020\n\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002JJ\u0010\u001b\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010 \u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'`(H\u0016R\u0014\u0010,\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010+\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/at;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/guild/feed/event/GuildScrollFollowInputEvent;", "event", "", "z9", "", "flag", "", "diff", "scrollOffset", "B9", "Lcom/tencent/mobileqq/guild/feed/event/GuildScrollFollowClickViewEvent;", "x9", "Landroid/view/View;", "childView", "statusBarHeight", "screenContentHeight", "screenHeight", "", "rvLocation", "", "clickViewY", "Landroid/graphics/Rect;", "itemRect", "A9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "onPartPause", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "I", "recyclerViewID", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "f", "itemMarginBottom", tl.h.F, "itemMarginTop", "<init>", "(I)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class at extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int recyclerViewID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int itemMarginBottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int itemMarginTop;

    public at(int i3) {
        this.recyclerViewID = i3;
    }

    private final void B9(String flag, int diff, int scrollOffset) {
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildScrollFollowInputPart", 4, "[logFollowInputEvent] flag=" + flag + ", diff=" + diff + ", itemTop=" + this.itemMarginTop + ", scrollOffset=" + scrollOffset);
        }
    }

    private final void x9(GuildScrollFollowClickViewEvent event) {
        int i3;
        int[] iArr = new int[2];
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.getLocationOnScreen(iArr);
        float y16 = event.getY() - iArr[1];
        float x16 = event.getX();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        View findChildViewUnder = recyclerView2.findChildViewUnder(x16, y16);
        Rect rect = new Rect();
        if (findChildViewUnder != null) {
            findChildViewUnder.getGlobalVisibleRect(rect);
        }
        int height = com.tencent.mobileqq.guild.feed.util.e.b(BaseApplication.getContext()).getHeight();
        int c16 = bv.c(BaseApplication.getContext());
        int i16 = height + c16;
        this.itemMarginBottom = i16 - rect.bottom;
        if (findChildViewUnder != null) {
            i3 = findChildViewUnder.getTop();
        } else {
            i3 = 0;
        }
        this.itemMarginTop = i3;
        A9(findChildViewUnder, c16, height, i16, iArr, event, y16, rect);
    }

    private final void z9(GuildScrollFollowInputEvent event) {
        if (QLog.isDevelopLevel()) {
            QLog.i("GuildScrollFollowInputPart", 4, "[handleReceiveEvent]event.height=" + event.getHeight() + ", targetHeightHint=" + event.getTargetHeightHint() + ", inputHeight=" + event.getInputHeight() + ", totalHeigh=" + (event.getTargetHeightHint() + event.getInputHeight()));
        }
        int i3 = this.itemMarginTop;
        RecyclerView recyclerView = null;
        if (i3 < 0) {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.smoothScrollBy(0, i3);
            return;
        }
        int targetHeightHint = (event.getTargetHeightHint() + event.getInputHeight()) - this.itemMarginBottom;
        if (targetHeightHint < 0) {
            B9(TVKUpdateInfo.APP_ID, targetHeightHint, 0);
            return;
        }
        int i16 = this.itemMarginTop;
        if (targetHeightHint > i16) {
            B9(QQHealthReportApiImpl.MSG_EXPOSE_KEY, targetHeightHint, i16);
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.smoothScrollBy(0, i16);
            return;
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        if (!recyclerView4.canScrollVertically(1)) {
            B9(QQHealthReportApiImpl.MSG_CLICK_KEY, targetHeightHint, 0);
            return;
        }
        B9("003", targetHeightHint, targetHeightHint);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView.smoothScrollBy(0, targetHeightHint);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildScrollFollowInputEvent.class, GuildScrollFollowClickViewEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getTAG(), 1, "[onInitView]: rootView should not be null");
            return;
        }
        View findViewById = rootView.findViewById(this.recyclerViewID);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(recyclerViewID)");
        this.recyclerView = (RecyclerView) findViewById;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        QLog.d("GuildScrollFollowInputPart", 4, "[onPartPause] hashcode=" + hashCode());
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        QLog.d("GuildScrollFollowInputPart", 4, "[onPartResume] hashcode=" + hashCode());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildScrollFollowInputEvent) {
            z9((GuildScrollFollowInputEvent) event);
        } else if (event instanceof GuildScrollFollowClickViewEvent) {
            x9((GuildScrollFollowClickViewEvent) event);
        }
    }

    private final void A9(View childView, int statusBarHeight, int screenContentHeight, int screenHeight, int[] rvLocation, GuildScrollFollowClickViewEvent event, float clickViewY, Rect itemRect) {
    }
}
