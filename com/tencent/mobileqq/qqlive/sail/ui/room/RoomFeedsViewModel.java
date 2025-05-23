package com.tencent.mobileqq.qqlive.sail.ui.room;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetFeedsListRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\r\u0010\fJ)\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016J\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00160$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00160$8\u0006\u00a2\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020/0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010&R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020/0$8\u0006\u00a2\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u0010*R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u0004\u0018\u00010C8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomFeedsViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "roomId", "Lcom/tencent/mobileqq/qqlive/sso/request/QQLiveGetFeedsListRequest;", "Lqr4/d;", "X1", "", "T1", "", "Lqr4/e;", "W1", "()[Lqr4/e;", "R1", "circleFlag", "Lqr4/b;", "feeds", "", "b2", "(I[Lqr4/b;)V", "feed", "c2", "", "S1", QCircleLpReportDc05507.KEY_CLEAR, "position", "d2", "Q1", "", "i", "Ljava/util/Set;", "roomIdSet", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "roomFeedsList", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_roomFeedsAppendLiveData", "D", "Z1", "()Landroidx/lifecycle/MutableLiveData;", "roomFeedsAppendLiveData", "E", "I", "lastSelectedPosition", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/r;", UserInfo.SEX_FEMALE, "_selectedRoomId", "G", ICustomDataEditor.STRING_ARRAY_PARAM_2, "selectedRoomId", "H", "[Lqr4/e;", "penetrateInfo", "Lqr4/a;", "[Lqr4/a;", "penetrateExt", "", "J", "Ljava/lang/String;", "firstTraceInfo", "", "K", "Z", "isFetchingFeeds", "Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "U1", "()Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "liveContext", "<init>", "()V", "L", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RoomFeedsViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<qr4.b>> _roomFeedsAppendLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<qr4.b>> roomFeedsAppendLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private int lastSelectedPosition;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<r> _selectedRoomId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<r> selectedRoomId;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private qr4.e[] penetrateInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private qr4.a[] penetrateExt;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String firstTraceInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile boolean isFetchingFeeds;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Long> roomIdSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<qr4.b> roomFeedsList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomFeedsViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.room.RoomFeedsViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RoomFeedsViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.roomIdSet = new LinkedHashSet();
        this.roomFeedsList = new ArrayList();
        MutableLiveData<List<qr4.b>> mutableLiveData = new MutableLiveData<>();
        this._roomFeedsAppendLiveData = mutableLiveData;
        this.roomFeedsAppendLiveData = mutableLiveData;
        this.lastSelectedPosition = -1;
        MutableLiveData<r> mutableLiveData2 = new MutableLiveData<>();
        this._selectedRoomId = mutableLiveData2;
        this.selectedRoomId = mutableLiveData2;
    }

    private final qr4.e[] R1() {
        String str;
        boolean isBlank;
        qr4.e eVar;
        HashMap<String, String> l3;
        String str2;
        HashMap<String, String> l16;
        QQLiveContext U1 = U1();
        String str3 = "";
        if (U1 == null || (l16 = U1.l()) == null || (str = l16.get("trace_info")) == null) {
            str = "";
        }
        QQLiveContext U12 = U1();
        if (U12 != null && (l3 = U12.l()) != null && (str2 = l3.get("rcmd_context")) != null) {
            str3 = str2;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str3);
        if (isBlank) {
            str3 = str;
        }
        AegisLogger.INSTANCE.i("Audience|RoomFeedsViewModel", "generateDefaultPenetrateInfo", "traceInfo=" + str + ", rcmd=" + ((Object) str3));
        qr4.e[] eVarArr = new qr4.e[2];
        for (int i3 = 0; i3 < 2; i3++) {
            if (i3 == 0) {
                eVar = new qr4.e();
                eVar.f429395a = "src_trace_info";
                eVar.f429396b = str3;
                Unit unit = Unit.INSTANCE;
            } else {
                eVar = new qr4.e();
                eVar.f429395a = "rcmd_context";
                eVar.f429396b = str3;
                Unit unit2 = Unit.INSTANCE;
            }
            eVarArr[i3] = eVar;
        }
        return eVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int T1() {
        String str;
        boolean z16;
        boolean isBlank;
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.j();
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return 0;
                }
                try {
                    return Integer.parseInt(str);
                } catch (Exception e16) {
                    AegisLogger.INSTANCE.e("Audience|RoomFeedsViewModel", "getFromId", "error, ", e16);
                    return 0;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final QQLiveContext U1() {
        return QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
    }

    private final qr4.e[] W1() {
        if (this.penetrateInfo == null) {
            this.penetrateInfo = R1();
        }
        return this.penetrateInfo;
    }

    private final QQLiveGetFeedsListRequest<qr4.d> X1(long roomId) {
        String str;
        HashMap<String, String> l3;
        int size = this.roomFeedsList.size();
        int T1 = T1();
        QQLiveContext U1 = U1();
        if (U1 == null || (l3 = U1.l()) == null || (str = l3.get("scene_id")) == null) {
            str = "";
        }
        String str2 = str;
        this.penetrateInfo = W1();
        return new QQLiveGetFeedsListRequest<>(roomId, size, T1, str2, this.penetrateInfo, this.penetrateExt, 0, null, null, TroopInfo.PAY_PRIVILEGE_ALL, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
    
        r10 = kotlin.collections.ArraysKt___ArraysKt.toList(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r10 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b2(int circleFlag, qr4.b[] feeds) {
        Unit unit;
        List list;
        List<qr4.b> filterNotNull;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (feeds != null && list != null && filterNotNull != null) {
            for (qr4.b bVar : filterNotNull) {
                qr4.f fVar = bVar.f429376a;
                if (fVar != null && bVar.f429377b != null) {
                    if (circleFlag == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && this.roomIdSet.contains(Long.valueOf(fVar.f429397a))) {
                        AegisLogger.INSTANCE.i("Audience|RoomFeedsViewModel", "handleFeedsList", "duplicate roomId, " + bVar.f429376a.f429397a);
                    } else {
                        arrayList.add(bVar);
                        this.roomIdSet.add(Long.valueOf(bVar.f429376a.f429397a));
                    }
                } else {
                    AegisLogger.INSTANCE.i("Audience|RoomFeedsViewModel", "handleFeedsList", "invalid room or stream");
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Audience|RoomFeedsViewModel", "handleFeedsList", "invalid feeds list");
        }
        this.roomFeedsList.addAll(arrayList);
        AegisLogger.INSTANCE.i("Audience|RoomFeedsViewModel", "handleFeedsList", "new room list size=" + this.roomFeedsList.size());
        this._roomFeedsAppendLiveData.postValue(arrayList);
    }

    public final void Q1(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, roomId);
            return;
        }
        if (roomId <= 0) {
            AegisLogger.INSTANCE.w("Audience|RoomFeedsViewModel", "fetchRoomFeeds", "invalid roomId");
            return;
        }
        if (this.isFetchingFeeds) {
            AegisLogger.INSTANCE.w("Audience|RoomFeedsViewModel", "fetchRoomFeeds", "fetching feeds");
            return;
        }
        this.isFetchingFeeds = true;
        QQLiveGetFeedsListRequest<qr4.d> X1 = X1(roomId);
        AegisLogger.INSTANCE.i("Audience|RoomFeedsViewModel", "fetchRoomFeeds", "request=" + X1 + ", current room list size=" + this.roomFeedsList.size());
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(X1, new Function1<QQLiveResponse<qr4.d>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.RoomFeedsViewModel$fetchRoomFeeds$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoomFeedsViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<qr4.d> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<qr4.d> response) {
                MutableLiveData mutableLiveData;
                List emptyList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                    return;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                RoomFeedsViewModel.this.isFetchingFeeds = false;
                qr4.d rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("Audience|RoomFeedsViewModel", "fetchRoomFeeds", "success, feeds size=" + rsp.f429389a.length + ", finished=" + rsp.f429390b + ", circleFlag=" + rsp.f429392d);
                    RoomFeedsViewModel.this.penetrateInfo = rsp.f429391c;
                    RoomFeedsViewModel.this.penetrateExt = rsp.f429393e;
                    RoomFeedsViewModel.this.b2(rsp.f429392d, rsp.f429389a);
                    return;
                }
                AegisLogger.INSTANCE.w("Audience|RoomFeedsViewModel", "fetchRoomFeeds", "failed, " + response);
                mutableLiveData = RoomFeedsViewModel.this._roomFeedsAppendLiveData;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                mutableLiveData.postValue(emptyList);
            }
        });
    }

    @NotNull
    public final List<qr4.b> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.roomFeedsList);
        return arrayList;
    }

    @NotNull
    public final MutableLiveData<List<qr4.b>> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.roomFeedsAppendLiveData;
    }

    @NotNull
    public final MutableLiveData<r> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.selectedRoomId;
    }

    public final void c2(@NotNull qr4.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (this.roomFeedsList.isEmpty() && feed.f429376a.f429397a >= 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(feed);
            this.roomFeedsList.addAll(arrayList);
            this._roomFeedsAppendLiveData.postValue(arrayList);
        }
        this.lastSelectedPosition = -1;
    }

    public final void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.roomFeedsList.clear();
        this.roomIdSet.clear();
        this.penetrateInfo = null;
        this.penetrateExt = null;
        this.firstTraceInfo = null;
    }

    public final void d2(int position) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, position);
            return;
        }
        if (position != this.lastSelectedPosition) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.roomFeedsList, position);
            qr4.b bVar = (qr4.b) orNull;
            if (bVar != null) {
                this._selectedRoomId.postValue(new r(this.lastSelectedPosition, position, bVar.f429376a.f429397a));
                this.lastSelectedPosition = position;
            }
        }
    }
}
