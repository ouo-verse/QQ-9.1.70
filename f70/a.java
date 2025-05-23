package f70;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.events.QCircleHostPushClickEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.events.QCircleShareItemClickEvent;
import com.tencent.biz.qqcircle.events.QFSCommentSendEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSLikeStateChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f`\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lf70/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "", "action", "", "N1", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "M1", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "getLogTag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hasInteractAction", BdhLogUtil.LogTag.Tag_Conn, "hasClickLike", "D", "hasSendComment", "E", "hasClickPush", UserInfo.SEX_FEMALE, "hasClickShare", "G", "hasClickFollow", "Landroidx/lifecycle/MutableLiveData;", "H", "Landroidx/lifecycle/MutableLiveData;", "_interactActionLiveData", "Landroidx/lifecycle/LiveData;", "I", "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "interactActionLiveData", "<init>", "()V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends com.tencent.biz.qqcircle.viewmodels.a implements SimpleEventReceiver<SimpleBaseEvent> {

    @NotNull
    private static final Set<Integer> K;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasClickLike;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasSendComment;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasClickPush;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasClickShare;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasClickFollow;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _interactActionLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> interactActionLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasInteractAction;

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{2, 0, 14, 1, 3});
        K = of5;
    }

    public a() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._interactActionLiveData = mutableLiveData;
        this.interactActionLiveData = mutableLiveData;
    }

    private final boolean N1(int action) {
        return K.contains(Integer.valueOf(action));
    }

    @NotNull
    public final LiveData<String> L1() {
        return this.interactActionLiveData;
    }

    public final boolean M1() {
        if (!this.hasClickLike && !this.hasSendComment && !this.hasClickPush && !this.hasClickShare && !this.hasClickFollow) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleShareItemClickEvent.class);
        arrayList.add(QFSCommentSendEvent.class);
        arrayList.add(QCircleFollowUpdateEvent.class);
        arrayList.add(QFSLikeStateChangeEvent.class);
        arrayList.add(QCirclePushAnimationStateEvent.class);
        arrayList.add(QCircleHostPushClickEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSFeedInteractActionViewModel";
    }

    public final void onCreate() {
        QLog.d(getLogTag(), 1, "onCreate, hashCode:" + hashCode());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.hasInteractAction = false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QCircleShareItemClickEvent) {
            QCircleShareItemClickEvent qCircleShareItemClickEvent = (QCircleShareItemClickEvent) event;
            if (N1(qCircleShareItemClickEvent.getAction())) {
                this.hasClickShare = true;
                this._interactActionLiveData.postValue("action_on_click_share");
                QLog.i("QFSFeedInteractActionViewModel", 1, "QCircleShareItemClickEvent, action:" + qCircleShareItemClickEvent.getAction());
                return;
            }
            return;
        }
        if (event instanceof QFSCommentSendEvent) {
            this.hasSendComment = true;
            this._interactActionLiveData.postValue("action_on_click_send_comment");
            QLog.i("QFSFeedInteractActionViewModel", 1, "QFSCommentSendEvent");
            return;
        }
        if (event instanceof QCircleFollowUpdateEvent) {
            QCircleFollowUpdateEvent qCircleFollowUpdateEvent = (QCircleFollowUpdateEvent) event;
            if (qCircleFollowUpdateEvent.mFollowStatus == 1) {
                this.hasClickFollow = true;
                this._interactActionLiveData.postValue("action_on_follow");
            }
            QLog.i("QFSFeedInteractActionViewModel", 1, "QCircleFollowUpdateEvent, status:" + qCircleFollowUpdateEvent.mFollowStatus);
            return;
        }
        if (event instanceof QFSLikeStateChangeEvent) {
            QFSLikeStateChangeEvent qFSLikeStateChangeEvent = (QFSLikeStateChangeEvent) event;
            if (qFSLikeStateChangeEvent.getIsLike()) {
                this.hasClickLike = true;
                this._interactActionLiveData.postValue("action_on_like");
            }
            QLog.i("QFSFeedInteractActionViewModel", 1, "QFSLikeStateChangeEvent, isLike:" + qFSLikeStateChangeEvent.getIsLike());
            return;
        }
        if (event instanceof QCirclePushAnimationStateEvent) {
            QCirclePushAnimationStateEvent qCirclePushAnimationStateEvent = (QCirclePushAnimationStateEvent) event;
            if (qCirclePushAnimationStateEvent.mState == 2) {
                this.hasClickPush = true;
                this._interactActionLiveData.postValue("action_on_push");
            }
            QLog.i("QFSFeedInteractActionViewModel", 1, "QCirclePushAnimationStateEvent, state:" + qCirclePushAnimationStateEvent.mState);
            return;
        }
        if (event instanceof QCircleHostPushClickEvent) {
            QCircleHostPushClickEvent qCircleHostPushClickEvent = (QCircleHostPushClickEvent) event;
            if (qCircleHostPushClickEvent.isPush) {
                this.hasClickPush = true;
                this._interactActionLiveData.postValue("action_on_push");
            }
            QLog.i("QFSFeedInteractActionViewModel", 1, "QCircleHostPushClickEvent, isPush:" + qCircleHostPushClickEvent.isPush);
        }
    }
}
