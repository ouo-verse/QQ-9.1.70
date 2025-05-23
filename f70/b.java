package f70;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.events.QFSAddMainTabGuideUIvvEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSMainTabSelectEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u0012j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0013`\u0014H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0016\u0010%\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0018R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010*R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0,8\u0006\u00a2\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\u00a8\u0006;"}, d2 = {"Lf70/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/qqcircle/viewmodels/a;", "", "P1", "", "isMainFragment", "Q1", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "R1", "S1", "", "N1", "L1", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "getLogTag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isAllPushPage", "", BdhLogUtil.LogTag.Tag_Conn, "I", "userVideoViewCount", "Lcom/tencent/biz/qqcircle/immersive/events/QFSAddMainTabGuideUIvvEvent;", "D", "Lcom/tencent/biz/qqcircle/immersive/events/QFSAddMainTabGuideUIvvEvent;", "curVvFeedEvent", "E", "isShowingBottomGuideTip", UserInfo.SEX_FEMALE, "startShowPosition", "G", "endShowPosition", "H", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_vvToggleBottomGuideTipLiveData", "Landroidx/lifecycle/LiveData;", "J", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "vvToggleBottomGuideTipLiveData", "K", "_changePageLiveData", "L", "M1", "changePageLiveData", "<init>", "()V", "M", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends com.tencent.biz.qqcircle.viewmodels.a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private int userVideoViewCount;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSAddMainTabGuideUIvvEvent curVvFeedEvent;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isShowingBottomGuideTip;

    /* renamed from: F, reason: from kotlin metadata */
    private int startShowPosition;

    /* renamed from: G, reason: from kotlin metadata */
    private int endShowPosition;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isMainFragment;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _vvToggleBottomGuideTipLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> vvToggleBottomGuideTipLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _changePageLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> changePageLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isAllPushPage = true;

    public b() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._vvToggleBottomGuideTipLiveData = mutableLiveData;
        this.vvToggleBottomGuideTipLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._changePageLiveData = mutableLiveData2;
        this.changePageLiveData = mutableLiveData2;
    }

    private final void P1() {
        int i3 = this.userVideoViewCount + 1;
        this.userVideoViewCount = i3;
        QLog.i("QFSFeedVvForGuideUIViewModel", 1, "feed vv count:" + i3 + ", isShowing:" + this.isShowingBottomGuideTip + ", startShowPosition:" + this.startShowPosition + ", endShowPosition:" + this.endShowPosition);
        if (this.isShowingBottomGuideTip) {
            int i16 = this.userVideoViewCount;
            if (i16 - this.startShowPosition >= 2) {
                this.endShowPosition = i16;
                this.isShowingBottomGuideTip = false;
                this._vvToggleBottomGuideTipLiveData.postValue(Boolean.FALSE);
                return;
            }
            return;
        }
        if (this.userVideoViewCount - this.endShowPosition >= 2) {
            this._vvToggleBottomGuideTipLiveData.postValue(Boolean.TRUE);
        }
    }

    public final boolean L1() {
        if (this.isMainFragment && !this.isAllPushPage) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LiveData<Integer> M1() {
        return this.changePageLiveData;
    }

    @NotNull
    public final String N1() {
        String dtPageId;
        QFSAddMainTabGuideUIvvEvent qFSAddMainTabGuideUIvvEvent = this.curVvFeedEvent;
        if (qFSAddMainTabGuideUIvvEvent == null || (dtPageId = qFSAddMainTabGuideUIvvEvent.getDtPageId()) == null) {
            return "";
        }
        return dtPageId;
    }

    @NotNull
    public final LiveData<Boolean> O1() {
        return this.vvToggleBottomGuideTipLiveData;
    }

    public final void Q1(boolean isMainFragment) {
        this.isMainFragment = isMainFragment;
    }

    public final boolean R1() {
        if (this.userVideoViewCount >= 2) {
            return true;
        }
        return false;
    }

    public final void S1() {
        this.isShowingBottomGuideTip = true;
        this.startShowPosition = this.userVideoViewCount;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSAddMainTabGuideUIvvEvent.class);
        arrayList.add(QFSMainTabSelectEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSFeedVvForGuideUIViewModel";
    }

    public final void onCreate() {
        QLog.d(getLogTag(), 1, "onCreate hashCode:" + hashCode());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void onDestroy() {
        QLog.d(getLogTag(), 1, "onDestroy hashCode:" + hashCode());
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.userVideoViewCount = 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean startsWith$default;
        String str;
        boolean z16;
        boolean z17 = true;
        if (event instanceof QFSMainTabSelectEvent) {
            QFSMainTabSelectEvent qFSMainTabSelectEvent = (QFSMainTabSelectEvent) event;
            if (qFSMainTabSelectEvent.isSelected()) {
                if (qFSMainTabSelectEvent.getTabSourceType() == 10) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.isAllPushPage = z16;
                QLog.i(getLogTag(), 1, "QFSMainTabSelectEvent, tabSourceType:" + qFSMainTabSelectEvent.getTabSourceType() + ", isAllPush:" + this.isAllPushPage);
                this._changePageLiveData.postValue(Integer.valueOf(qFSMainTabSelectEvent.getTabSourceType()));
            }
        }
        if ((!this.isMainFragment || this.isAllPushPage) && (event instanceof QFSAddMainTabGuideUIvvEvent)) {
            QFSAddMainTabGuideUIvvEvent qFSAddMainTabGuideUIvvEvent = (QFSAddMainTabGuideUIvvEvent) event;
            String feedId = qFSAddMainTabGuideUIvvEvent.getFeedId();
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(feedId, "share_fake_", false, 2, null);
            if (!startsWith$default) {
                if (feedId.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    QFSAddMainTabGuideUIvvEvent qFSAddMainTabGuideUIvvEvent2 = this.curVvFeedEvent;
                    if (qFSAddMainTabGuideUIvvEvent2 == null || (str = qFSAddMainTabGuideUIvvEvent2.getFeedId()) == null) {
                        str = "";
                    }
                    if (!Intrinsics.areEqual(str, feedId)) {
                        this.curVvFeedEvent = qFSAddMainTabGuideUIvvEvent;
                        P1();
                    }
                }
            }
        }
    }
}
