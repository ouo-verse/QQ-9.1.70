package com.tencent.mobileqq.matchfriend.reborn.content.msg.top;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerGameInfoUpdateEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchChatSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.i;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$GameInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/QQStrangerMsgMatchChatPart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "event", "onReceiveEvent", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/i;", "e", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/i;", "matchChatManager", "", "f", "I", "remainPlayTimes", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgMatchChatPart extends com.tencent.mobileqq.matchfriend.reborn.content.msg.part.a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy matchChatManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int remainPlayTimes;

    public QQStrangerMsgMatchChatPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgMatchChatPart$matchChatManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                return new i();
            }
        });
        this.matchChatManager = lazy;
        this.remainPlayTimes = 20;
    }

    private final i A9() {
        return (i) this.matchChatManager.getValue();
    }

    private final void B9() {
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgMatchChatUpdateEvent(this.remainPlayTimes));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (A9().j() || !A9().k()) {
            return super.onBackEvent();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        i A9 = A9();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        A9.A(activity);
        this.remainPlayTimes = QQStrangerMatchingPart.INSTANCE.e();
        B9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        A9().n();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QQStrangerMsgMatchChatClickEvent) {
            QQStrangerMatchingPart.Companion companion = QQStrangerMatchingPart.INSTANCE;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            if (companion.b(activity)) {
                A9().start();
                return;
            }
            return;
        }
        if (event instanceof QQStrangerMatchChatSuccessEvent) {
            this.remainPlayTimes--;
            B9();
            return;
        }
        if (event instanceof QQStrangerGameInfoUpdateEvent) {
            Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("gameInfos");
            List<GrayCtrl$GameInfo> list = a16 instanceof List ? (List) a16 : null;
            if (list == null) {
                return;
            }
            for (GrayCtrl$GameInfo grayCtrl$GameInfo : list) {
                if (grayCtrl$GameInfo.game_id.get() == 1) {
                    this.remainPlayTimes = grayCtrl$GameInfo.play_time.get();
                }
            }
            B9();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerMsgMatchChatClickEvent.class, QQStrangerMatchChatSuccessEvent.class, QQStrangerGameInfoUpdateEvent.class);
        return arrayListOf;
    }
}
