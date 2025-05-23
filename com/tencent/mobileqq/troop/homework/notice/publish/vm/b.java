package com.tencent.mobileqq.troop.homework.notice.publish.vm;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.trooplist.event.HWTroopListEvent;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d;
import com.tencent.mobileqq.troop.homework.notice.list.event.HWNoticeListUpdateEvent;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeRsp;
import com.tencent.util.QQToastUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001>B\u000f\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f`\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0014R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\u00020\u00158\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010#R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020+0%8\u0006\u00a2\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/publish/vm/b;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "T1", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "P1", "", "N1", "M1", "U1", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onCleared", "", "", "", "i", "Ljava/util/Map;", "errMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "S1", "()Ljava/lang/String;", "troopUin", BdhLogUtil.LogTag.Tag_Conn, "Q1", "templateNum", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_finishPage", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "finishPage", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", UserInfo.SEX_FEMALE, "_troopRangeInfoLiveData", "G", "R1", "troopRangeInfoLiveData", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "H", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "mediaDataModel", "Lcom/tencent/mobileqq/troop/homework/notice/publish/vm/c;", "I", "Lcom/tencent/mobileqq/troop/homework/notice/publish/vm/c;", "mediaEditManager", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String templateNum;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> _finishPage;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> finishPage;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<com.tencent.mobileqq.troop.homework.common.trooplist.data.b> _troopRangeInfoLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.homework.common.trooplist.data.b> troopRangeInfoLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final d mediaDataModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final c mediaEditManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, String> errMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/publish/vm/b$a;", "", "", "MAX_CONTENT_WORD_COUNT", "I", "MAX_TITLE_WORD_COUNT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.publish.vm.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull Bundle bundle) {
        Map<Integer, String> mapOf;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(10020, "\u5df2\u8fbe\u672c\u65e5\u901a\u77e5\u4e0a\u9650"), TuplesKt.to(10023, "\u540c\u6b65\u7684\u7fa4\u8d85\u8fc7\u53d1\u5e03\u9650\u5236\u6761\u6570"), TuplesKt.to(10018, "\u540c\u6b65\u7684\u7fa4\u4e2a\u6570\u8d85\u8fc7\u4e0a\u9650"));
            this.errMap = mapOf;
            String string = bundle.getString("TROOP_UIN", "");
            Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWNoticeArgKey.TROOP_UIN, \"\")");
            this.troopUin = string;
            this.templateNum = "0";
            MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
            this._finishPage = mutableLiveData;
            this.finishPage = mutableLiveData;
            MutableLiveData<com.tencent.mobileqq.troop.homework.common.trooplist.data.b> mutableLiveData2 = new MutableLiveData<>();
            this._troopRangeInfoLiveData = mutableLiveData2;
            this.troopRangeInfoLiveData = mutableLiveData2;
            d dVar = new d();
            dVar.r().setMaxWordCount(10);
            dVar.k().setMaxWordCount(500);
            this.mediaDataModel = dVar;
            this.mediaEditManager = new c(string, ViewModelKt.getViewModelScope(this), dVar);
            T1();
            SimpleEventBus.getInstance().registerReceiver(this);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
    }

    private final void T1() {
        PublishMediaEditManager.S(this.mediaEditManager, new SimpleDateFormat("MM\u6708dd\u65e5", Locale.getDefault()).format(new Date()) + "\u73ed\u7ea7\u901a\u77e5", "", "\u8f93\u5165\u901a\u77e5\u6807\u9898", "\u8f93\u5165\u901a\u77e5\u5185\u5bb9", Integer.valueOf(ViewUtils.dip2px(240.0f)), null, 32, null);
        this.mediaEditManager.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(PublishGroupSchoolNoticeReq req, b this$0, ArrayList syncGroups, int i3, String str, PublishGroupSchoolNoticeRsp rsp) {
        boolean z16;
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(syncGroups, "$syncGroups");
        QLog.i("HW.Notice..Pub.HWNoticePubViewModel", 1, "publishGroupSchoolNotice, errCode:" + i3 + ", errMsg:" + str + ", syncGroupsSize:" + syncGroups.size());
        if (i3 == 0) {
            QQToastUtil.showQQToastInUiThread(2, "\u53d1\u5e03\u6210\u529f");
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            simpleEventBus.dispatchEvent(new HWNoticeListUpdateEvent.NoticePublished(req, rsp));
            this$0._finishPage.postValue(Boolean.TRUE);
            return;
        }
        if (this$0.errMap.containsKey(Integer.valueOf(i3))) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QQToastUtil.showQQToastInUiThread(1, str);
                return;
            }
        }
        String str2 = this$0.errMap.get(Integer.valueOf(i3));
        if (str2 == null) {
            str2 = "\u53d1\u5e03\u5931\u8d25";
        }
        QQToastUtil.showQQToastInUiThread(1, str2);
    }

    public final boolean M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.mediaEditManager.W()) {
            QQToastUtil.showQQToast(1, "\u8bf7\u586b\u5199\u6807\u9898\u540e\u53d1\u5e03");
            return false;
        }
        if (this.mediaEditManager.C()) {
            QQToastUtil.showQQToast(1, "\u5e03\u7f6e\u7684\u901a\u77e5\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
            return false;
        }
        if (this.mediaEditManager.A()) {
            return true;
        }
        QQToastUtil.showQQToast(1, "\u6587\u4ef6\u672a\u4e0a\u4f20\u5b8c\u6210");
        return false;
    }

    public final boolean N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.mediaEditManager.D() || !this.mediaEditManager.T()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final LiveData<Boolean> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.finishPage;
    }

    @NotNull
    public final f P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mediaEditManager;
    }

    @NotNull
    public final String Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.templateNum;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.homework.common.trooplist.data.b> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.troopRangeInfoLiveData;
    }

    @NotNull
    public final String S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final void U1() {
        final ArrayList<Long> arrayList;
        Long longOrNull;
        long j3;
        String trimIndent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!M1()) {
            return;
        }
        com.tencent.mobileqq.troop.homework.common.trooplist.data.b value = this._troopRangeInfoLiveData.getValue();
        if (value == null || (arrayList = value.c()) == null) {
            arrayList = new ArrayList<>();
        }
        GroupSchoolNoticeContent E = this.mediaEditManager.E();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        final PublishGroupSchoolNoticeReq publishGroupSchoolNoticeReq = new PublishGroupSchoolNoticeReq(E, j3, arrayList, 0L);
        r g16 = bg.f302144a.g();
        if (g16 != null) {
            g16.publishGroupSchoolNotice(publishGroupSchoolNoticeReq, new IPublishGroupSchoolNoticeCallback() { // from class: com.tencent.mobileqq.troop.homework.notice.publish.vm.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolNoticeCallback
                public final void onResult(int i3, String str, PublishGroupSchoolNoticeRsp publishGroupSchoolNoticeRsp) {
                    b.W1(PublishGroupSchoolNoticeReq.this, this, arrayList, i3, str, publishGroupSchoolNoticeRsp);
                }
            });
        }
        if (QLog.isColorLevel()) {
            GroupSchoolNoticeContent groupSchoolNoticeContent = publishGroupSchoolNoticeReq.content;
            trimIndent = StringsKt__IndentKt.trimIndent("\n                    publish, req title:" + groupSchoolNoticeContent.title + ",\n                    picsSize:" + groupSchoolNoticeContent.pics.size() + ",\n                    audioSize:" + publishGroupSchoolNoticeReq.content.audios.size() + ",\n                    videosSize:" + publishGroupSchoolNoticeReq.content.videos.size() + ",\n                    filesSize:" + publishGroupSchoolNoticeReq.content.files.size() + ",\n                    content:" + publishGroupSchoolNoticeReq.content.content + ",\n                ");
            QLog.i("HW.Notice..Pub.HWNoticePubViewModel", 2, trimIndent);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWTroopListEvent.TroopRangeChanged.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onCleared();
        JobKt__JobKt.cancelChildren$default(ViewModelKt.getViewModelScope(this).getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope(this), null, 1, null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.mediaEditManager.G();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) event);
        } else if (event instanceof HWTroopListEvent.TroopRangeChanged) {
            this._troopRangeInfoLiveData.postValue(((HWTroopListEvent.TroopRangeChanged) event).getInfo());
        }
    }
}
