package com.tencent.mobileqq.flock.share;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.flock.share.request.FlockGetShareInfoRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001\rBe\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014\u0012\b\b\u0002\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020#\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J)\u0010\n\u001a\u00020\u00042!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u0006J\u0006\u0010\u000b\u001a\u00020\u0004R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010-\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R(\u00103\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b%\u00100\u001a\u0004\b1\u00102R(\u00108\u001a\u0004\u0018\u0001042\b\u0010/\u001a\u0004\u0018\u0001048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b)\u00107R$\u0010=\u001a\u0002092\u0006\u0010/\u001a\u0002098\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010:\u001a\u0004\b;\u0010<R3\u0010?\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010>R\u0011\u0010B\u001a\u00020@8F\u00a2\u0006\u0006\u001a\u0004\b5\u0010AR\u0011\u0010D\u001a\u00020@8F\u00a2\u0006\u0006\u001a\u0004\bC\u0010AR\u0011\u0010F\u001a\u00020@8F\u00a2\u0006\u0006\u001a\u0004\bE\u0010A\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/flock/share/e;", "", "", "isSuccess", "", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/flock/share/d;", "a", "Lcom/tencent/mobileqq/flock/share/d;", "o", "()Lcom/tencent/mobileqq/flock/share/d;", "shareListener", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "j", "()Ljava/util/ArrayList;", "pathLineList", "c", "i", "operationLineList", "", "d", "[I", "getLinesVisibility", "()[I", "linesVisibility", "Ly45/b;", "Ly45/b;", "g", "()Ly45/b;", "feed", "Lcom/tencent/mobileqq/flock/share/f;", "f", "Lcom/tencent/mobileqq/flock/share/f;", "k", "()Lcom/tencent/mobileqq/flock/share/f;", "reportBean", "Ly45/n;", "<set-?>", "Ly45/n;", DomainData.DOMAIN_NAME, "()Ly45/n;", "shareInfo", "Lcom/tencent/mobileqq/flock/share/a;", tl.h.F, "Lcom/tencent/mobileqq/flock/share/a;", "()Lcom/tencent/mobileqq/flock/share/a;", "errorInfo", "Lcom/tencent/mobileqq/flock/share/RequestState;", "Lcom/tencent/mobileqq/flock/share/RequestState;", "l", "()Lcom/tencent/mobileqq/flock/share/RequestState;", "requestState", "Lkotlin/jvm/functions/Function1;", "requestCallback", "", "()I", "firstLineVisibility", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "secondLineVisibility", "p", "thirdLineVisibility", "<init>", "(Lcom/tencent/mobileqq/flock/share/d;Ljava/util/ArrayList;Ljava/util/ArrayList;[ILy45/b;Lcom/tencent/mobileqq/flock/share/f;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d shareListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ShareActionSheetBuilder.ActionSheetItem> pathLineList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ShareActionSheetBuilder.ActionSheetItem> operationLineList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] linesVisibility;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y45.b feed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final f reportBean;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n shareInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a errorInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RequestState requestState;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> requestCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/share/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.share.e$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/flock/share/e$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lz45/n;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<z45.n> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable z45.n rsp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, request, Boolean.valueOf(isSuccess), Long.valueOf(retCode), errMsg, rsp);
                return;
            }
            int i3 = RFWLog.USR;
            if (request != null) {
                str = request.getTraceId();
            } else {
                str = null;
            }
            RFWLog.i("FlockShareParam", i3, "requestShareInfo, onReceive, traceId:" + str + ", isSuccess:" + isSuccess + ", retCode:" + retCode + ", errMsg:" + errMsg);
            if (isSuccess && retCode == 0 && rsp != null) {
                e.this.shareInfo = rsp.f451928a;
                e.this.requestState = RequestState.SUCCEED;
                e.this.e(true);
            } else {
                e eVar = e.this;
                if (errMsg == null) {
                    errMsg = "";
                }
                eVar.errorInfo = new a(retCode, errMsg);
                e.this.requestState = RequestState.FAILED;
                e.this.e(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49008);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@Nullable d dVar, @NotNull ArrayList<ShareActionSheetBuilder.ActionSheetItem> pathLineList, @NotNull ArrayList<ShareActionSheetBuilder.ActionSheetItem> operationLineList, @NotNull int[] linesVisibility, @NotNull y45.b feed, @Nullable f fVar) {
        Intrinsics.checkNotNullParameter(pathLineList, "pathLineList");
        Intrinsics.checkNotNullParameter(operationLineList, "operationLineList");
        Intrinsics.checkNotNullParameter(linesVisibility, "linesVisibility");
        Intrinsics.checkNotNullParameter(feed, "feed");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dVar, pathLineList, operationLineList, linesVisibility, feed, fVar);
            return;
        }
        this.shareListener = dVar;
        this.pathLineList = pathLineList;
        this.operationLineList = operationLineList;
        this.linesVisibility = linesVisibility;
        this.feed = feed;
        this.reportBean = fVar;
        pathLineList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        pathLineList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        pathLineList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        pathLineList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        this.requestState = RequestState.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(boolean isSuccess) {
        Function1<? super Boolean, Unit> function1 = this.requestCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(isSuccess));
        }
    }

    @Nullable
    public final a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.errorInfo;
    }

    @NotNull
    public final y45.b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (y45.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.feed;
    }

    public final int h() {
        int lastIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        int[] iArr = this.linesVisibility;
        lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        if (lastIndex >= 0) {
            return iArr[0];
        }
        return 8;
    }

    @NotNull
    public final ArrayList<ShareActionSheetBuilder.ActionSheetItem> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.operationLineList;
    }

    @NotNull
    public final ArrayList<ShareActionSheetBuilder.ActionSheetItem> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.pathLineList;
    }

    @Nullable
    public final f k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.reportBean;
    }

    @NotNull
    public final RequestState l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (RequestState) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.requestState;
    }

    public final int m() {
        int lastIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int[] iArr = this.linesVisibility;
        lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        if (1 <= lastIndex) {
            return iArr[1];
        }
        return 8;
    }

    @Nullable
    public final n n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (n) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.shareInfo;
    }

    @Nullable
    public final d o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.shareListener;
    }

    public final int p() {
        int lastIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int[] iArr = this.linesVisibility;
        lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        if (2 <= lastIndex) {
            return iArr[2];
        }
        return 8;
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        RFWLog.i("FlockShareParam", RFWLog.USR, "requestShareInfo, requestState:" + this.requestState + " ");
        this.requestState = RequestState.REQUESTING;
        y45.c cVar = new y45.c();
        y45.b bVar = this.feed;
        cVar.f449385a = bVar.f449369d.f449449a;
        cVar.f449386b = bVar.f449366a;
        cVar.f449387c = bVar.f449373h;
        VSNetworkHelper.getInstance().sendRequest(new FlockGetShareInfoRequest(cVar), new b());
    }

    public final void r(@NotNull Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.requestCallback = callback;
        }
    }

    public /* synthetic */ e(d dVar, ArrayList arrayList, ArrayList arrayList2, int[] iArr, y45.b bVar, f fVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : dVar, (i3 & 2) != 0 ? new ArrayList() : arrayList, (i3 & 4) != 0 ? new ArrayList() : arrayList2, (i3 & 8) != 0 ? new int[]{0, 0, 8} : iArr, bVar, (i3 & 32) != 0 ? null : fVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, dVar, arrayList, arrayList2, iArr, bVar, fVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
