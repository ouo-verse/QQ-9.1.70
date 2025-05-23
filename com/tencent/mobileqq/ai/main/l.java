package com.tencent.mobileqq.ai.main;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.ai.VasLifecycleCallback;
import com.tencent.mobileqq.ai.main.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarActionStatus;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarCategoryInfo;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarSubCategoryInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAiAvatarCategoryInfosReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAiAvatarCategoryInfosRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetAiAvatarCategoryInfosCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 22\u00020\u0001:\u0002!$B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0096\u0001\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062]\u0010\u0014\u001aY\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\bj\u0002`\u00132'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u0015j\u0002`\u0016JX\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\n2@\u0010\u0014\u001a<\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019j\u0002`\u001dJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010Rq\u0010#\u001a_\u0012[\u0012Y\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\bj\u0002`\u00130 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"RT\u0010%\u001aB\u0012>\u0012<\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00120\u0019j\u0002`\u001d0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R;\u0010'\u001a)\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u0015j\u0002`\u00160 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/ai/main/l;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarSubCategoryInfo;", "info", "Lcom/tencent/mobileqq/ai/main/feeds/a;", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function3;", "", "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", "Lkotlin/ParameterName;", "name", "tabInfo", "", "mainTabFeedsInfo", "Lcom/tencent/mobileqq/ai/main/a;", "actionInfo", "", "Lcom/tencent/mobileqq/ai/main/AIAvatarFirstPageCallback;", "callback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/ai/main/AIAvatarActionStatusCallback;", "actionStatusCallback", "j", "Lkotlin/Function2;", "", "hasMore", "feedsInfo", "Lcom/tencent/mobileqq/ai/main/AIAvatarNextPageCallback;", "o", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/ai/VasLifecycleCallback;", "a", "Lcom/tencent/mobileqq/ai/VasLifecycleCallback;", "firstPageLifecycleCallback", "b", "nextPageLifecycleCallback", "c", "actionStatusLifecycleCallback", "d", "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", "fakeFirstTabInfo", "", "Lcom/tencent/mobileqq/ai/main/l$b;", "e", "Ljava/util/Map;", "requestState", "<init>", "()V", "f", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasLifecycleCallback<Function3<List<AIAvatarFeedsTabInfo>, List<com.tencent.mobileqq.ai.main.feeds.a>, a, Unit>> firstPageLifecycleCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasLifecycleCallback<Function2<Boolean, List<com.tencent.mobileqq.ai.main.feeds.a>, Unit>> nextPageLifecycleCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasLifecycleCallback<Function1<a, Unit>> actionStatusLifecycleCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AIAvatarFeedsTabInfo fakeFirstTabInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<AIAvatarFeedsTabInfo, b> requestState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ai/main/l$a;", "", "Lcom/tencent/qqnt/kernel/api/y;", "b", "", "PAGE_SIZE_LIMIT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.main.l$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final y b() {
            IKernelService iKernelService = (IKernelService) bg.l(IKernelService.class);
            if (iKernelService != null) {
                return iKernelService.getProfileService();
            }
            return null;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/ai/main/l$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "e", "(I)V", "pageNo", "Z", "()Z", "d", "(Z)V", "hasMore", "c", "f", "isRequesting", "<init>", "(IZZ)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int pageNo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean hasMore;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isRequesting;

        public b() {
            this(0, false, false, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return;
            }
            iPatchRedirector.redirect((short) 16, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.hasMore;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.pageNo;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isRequesting;
        }

        public final void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.hasMore = z16;
            }
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.pageNo = i3;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.pageNo == bVar.pageNo && this.hasMore == bVar.hasMore && this.isRequesting == bVar.isRequesting) {
                return true;
            }
            return false;
        }

        public final void f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, z16);
            } else {
                this.isRequesting = z16;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int i3 = this.pageNo * 31;
            boolean z16 = this.hasMore;
            int i16 = 1;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i3 + i17) * 31;
            boolean z17 = this.isRequesting;
            if (!z17) {
                i16 = z17 ? 1 : 0;
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "RequestState(pageNo=" + this.pageNo + ", hasMore=" + this.hasMore + ", isRequesting=" + this.isRequesting + ")";
        }

        public b(int i3, boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            this.pageNo = i3;
            this.hasMore = z16;
            this.isRequesting = z17;
        }

        public /* synthetic */ b(int i3, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? true : z16, (i16 & 4) != 0 ? false : z17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22373);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.firstPageLifecycleCallback = new VasLifecycleCallback<>();
        this.nextPageLifecycleCallback = new VasLifecycleCallback<>();
        this.actionStatusLifecycleCallback = new VasLifecycleCallback<>();
        this.fakeFirstTabInfo = new AIAvatarFeedsTabInfo("-1", "-1", 0L, 4, null);
        this.requestState = new LinkedHashMap();
    }

    private final com.tencent.mobileqq.ai.main.feeds.a i(AiAvatarSubCategoryInfo info) {
        Object obj;
        com.tencent.mobileqq.ai.i<?, ?> a16 = com.tencent.mobileqq.ai.a.f187656a.a(info.subCategoryInfoType);
        int i3 = info.subCategoryInfoType;
        String str = info.subCategoryInfoId;
        Intrinsics.checkNotNullExpressionValue(str, "info.subCategoryInfoId");
        if (a16 != null) {
            obj = a16.a(info);
        } else {
            obj = null;
        }
        return new com.tencent.mobileqq.ai.main.feeds.a(i3, str, info, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final y service, final GetAiAvatarCategoryInfosReq req, final l this$0, final int i3, final int i16, int i17, String str, final GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp) {
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AIAvatarMainRepo", 2, "requestFirstPage: rsp.total=" + getAiAvatarCategoryInfosRsp.totalCount + ", rsp.tabCount=" + getAiAvatarCategoryInfosRsp.categoryInfos.size());
            }
        } else {
            QLog.e("AIAvatarMainRepo", 1, "requestFirstPage: errCode=" + i17 + ", errMsg=" + str);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.ai.main.f
            @Override // java.lang.Runnable
            public final void run() {
                l.l(GetAiAvatarCategoryInfosRsp.this, service, req, objectRef, this$0, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, com.tencent.mobileqq.ai.main.AIAvatarFeedsTabInfo, java.lang.Object] */
    public static final void l(GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp, y service, GetAiAvatarCategoryInfosReq req, final Ref.ObjectRef mainTabInfo, final l this$0, final int i3, final int i16) {
        Integer num;
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(mainTabInfo, "$mainTabInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        ArrayList<AiAvatarCategoryInfo> arrayList3 = getAiAvatarCategoryInfosRsp.categoryInfos;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "rsp.categoryInfos");
        for (AiAvatarCategoryInfo aiAvatarCategoryInfo : arrayList3) {
            String str = aiAvatarCategoryInfo.categoryInfoId;
            Intrinsics.checkNotNullExpressionValue(str, "it.categoryInfoId");
            String str2 = aiAvatarCategoryInfo.categoryInfoName;
            Intrinsics.checkNotNullExpressionValue(str2, "it.categoryInfoName");
            ?? aIAvatarFeedsTabInfo = new AIAvatarFeedsTabInfo(str, str2, 0L);
            arrayList.add(aIAvatarFeedsTabInfo);
            Intrinsics.checkNotNullExpressionValue(aiAvatarCategoryInfo.subCategoryInfos, "it.subCategoryInfos");
            if (!r1.isEmpty()) {
                if (mainTabInfo.element == 0) {
                    mainTabInfo.element = aIAvatarFeedsTabInfo;
                    ArrayList<AiAvatarSubCategoryInfo> arrayList4 = aiAvatarCategoryInfo.subCategoryInfos;
                    Intrinsics.checkNotNullExpressionValue(arrayList4, "it.subCategoryInfos");
                    for (AiAvatarSubCategoryInfo it : arrayList4) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        arrayList2.add(this$0.i(it));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AIAvatarMainRepo", 2, "requestFirstPage: mainTab=" + mainTabInfo.element + ", mainTabFeedsCount=" + arrayList2.size());
                    }
                } else {
                    QLog.e("AIAvatarMainRepo", 1, "requestFirstPage: main tab info repeat");
                }
            }
        }
        a.Companion companion = a.INSTANCE;
        AiAvatarStatusInfo aiAvatarStatusInfo = getAiAvatarCategoryInfosRsp.statusInfo;
        Intrinsics.checkNotNullExpressionValue(aiAvatarStatusInfo, "rsp.statusInfo");
        final a a16 = companion.a(aiAvatarStatusInfo);
        if (QLog.isColorLevel()) {
            if (a16 != null) {
                num = Integer.valueOf(a16.a());
            } else {
                num = null;
            }
            QLog.d("AIAvatarMainRepo", 2, "requestFirstPage from db: rsp.actionInfo=" + num);
        }
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.ai.main.g
            @Override // java.lang.Runnable
            public final void run() {
                l.m(Ref.ObjectRef.this, this$0, i3, arrayList, arrayList2, a16);
            }
        });
        service.getAiAvatarCategoryInfos(req, true, new IGetAiAvatarCategoryInfosCallback() { // from class: com.tencent.mobileqq.ai.main.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAiAvatarCategoryInfosCallback
            public final void onResult(int i17, String str3, GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp2) {
                l.n(l.this, i16, i17, str3, getAiAvatarCategoryInfosRsp2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(Ref.ObjectRef mainTabInfo, l this$0, int i3, List tabInfo, List mainTabFeedsInfo, a aVar) {
        Intrinsics.checkNotNullParameter(mainTabInfo, "$mainTabInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tabInfo, "$tabInfo");
        Intrinsics.checkNotNullParameter(mainTabFeedsInfo, "$mainTabFeedsInfo");
        AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo = (AIAvatarFeedsTabInfo) mainTabInfo.element;
        if (aIAvatarFeedsTabInfo != null) {
            this$0.requestState.put(aIAvatarFeedsTabInfo, new b(1, false, false, 6, null));
        }
        Function3<List<AIAvatarFeedsTabInfo>, List<com.tencent.mobileqq.ai.main.feeds.a>, a, Unit> e16 = this$0.firstPageLifecycleCallback.e(i3);
        if (e16 != null) {
            e16.invoke(tabInfo, mainTabFeedsInfo, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(l this$0, int i3, int i16, String str, GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarMainRepo", 2, "requestFirstPage: request from net, errCode=" + i16 + ", errMsg=" + str);
        }
        a.Companion companion = a.INSTANCE;
        AiAvatarStatusInfo aiAvatarStatusInfo = getAiAvatarCategoryInfosRsp.statusInfo;
        Intrinsics.checkNotNullExpressionValue(aiAvatarStatusInfo, "rsp.statusInfo");
        a a16 = companion.a(aiAvatarStatusInfo);
        if (QLog.isColorLevel()) {
            if (a16 != null) {
                num = Integer.valueOf(a16.a());
            } else {
                num = null;
            }
            QLog.d("AIAvatarMainRepo", 2, "requestFirstPage from net: rsp.actionInfo=" + num);
        }
        Function1<a, Unit> e16 = this$0.actionStatusLifecycleCallback.e(i3);
        if (e16 != null) {
            e16.invoke(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final AIAvatarFeedsTabInfo tabInfo, final l this$0, final b state, final int i3, int i16, String str, final GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp) {
        Intrinsics.checkNotNullParameter(tabInfo, "$tabInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        if (i16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("AIAvatarMainRepo", 2, "requestNextPage: tabInfo=" + tabInfo + ", rsp.total=" + getAiAvatarCategoryInfosRsp.totalCount + ", rsp.tabCount=" + getAiAvatarCategoryInfosRsp.categoryInfos.size());
            }
        } else {
            QLog.e("AIAvatarMainRepo", 1, "requestNextPage: tabInfo=" + tabInfo + ",  errCode=" + i16 + ", errMsg=" + str);
        }
        bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.ai.main.j
            @Override // java.lang.Runnable
            public final void run() {
                l.q(GetAiAvatarCategoryInfosRsp.this, tabInfo, this$0, state, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp, AIAvatarFeedsTabInfo tabInfo, final l this$0, final b state, final int i3) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(tabInfo, "$tabInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        ArrayList<AiAvatarCategoryInfo> arrayList = getAiAvatarCategoryInfosRsp.categoryInfos;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.categoryInfos");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        AiAvatarCategoryInfo aiAvatarCategoryInfo = (AiAvatarCategoryInfo) firstOrNull;
        if (aiAvatarCategoryInfo != null && Intrinsics.areEqual(aiAvatarCategoryInfo.categoryInfoId, tabInfo.getId())) {
            final ArrayList arrayList2 = new ArrayList();
            ArrayList<AiAvatarSubCategoryInfo> arrayList3 = aiAvatarCategoryInfo.subCategoryInfos;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "rspTabInfo.subCategoryInfos");
            if (true ^ arrayList3.isEmpty()) {
                ArrayList<AiAvatarSubCategoryInfo> arrayList4 = aiAvatarCategoryInfo.subCategoryInfos;
                Intrinsics.checkNotNullExpressionValue(arrayList4, "rspTabInfo.subCategoryInfos");
                for (AiAvatarSubCategoryInfo it : arrayList4) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList2.add(this$0.i(it));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIAvatarMainRepo", 2, "requestNextPage: tabInfo=" + tabInfo + ", tabFeedsInfoCount=" + arrayList2.size());
            }
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.ai.main.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.r(arrayList2, state, this$0, i3);
                }
            });
            return;
        }
        QLog.e("AIAvatarMainRepo", 1, "requestNextPage: tabInfo=" + tabInfo + ", rsp error rsp=" + aiAvatarCategoryInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(List tabFeedsInfo, b state, l this$0, int i3) {
        Intrinsics.checkNotNullParameter(tabFeedsInfo, "$tabFeedsInfo");
        Intrinsics.checkNotNullParameter(state, "$state");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (tabFeedsInfo.isEmpty()) {
            state.d(false);
        }
        state.f(false);
        Function2<Boolean, List<com.tencent.mobileqq.ai.main.feeds.a>, Unit> e16 = this$0.nextPageLifecycleCallback.e(i3);
        if (e16 != null) {
            e16.invoke(Boolean.valueOf(state.a()), tabFeedsInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(a actionInfo, int i3, String str) {
        Intrinsics.checkNotNullParameter(actionInfo, "$actionInfo");
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarMainRepo", 2, "updateActionInfo: result=" + i3 + ", errMsg=" + str + ", actionInfo=" + actionInfo.a());
        }
    }

    public final void j(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function3<? super List<AIAvatarFeedsTabInfo>, ? super List<com.tencent.mobileqq.ai.main.feeds.a>, ? super a, Unit> callback, @NotNull Function1<? super a, Unit> actionStatusCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, lifecycleOwner, callback, actionStatusCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(actionStatusCallback, "actionStatusCallback");
        b bVar = this.requestState.get(this.fakeFirstTabInfo);
        if (bVar == null) {
            bVar = new b(0, false, false, 7, null);
            this.requestState.put(this.fakeFirstTabInfo, bVar);
        }
        if (bVar.c()) {
            if (QLog.isColorLevel()) {
                QLog.d("AIAvatarMainRepo", 2, "requestFirstPage: requesting");
                return;
            }
            return;
        }
        bVar.f(true);
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarMainRepo", 2, "requestFirstPage: request start");
        }
        final y b16 = INSTANCE.b();
        if (b16 != null) {
            final GetAiAvatarCategoryInfosReq getAiAvatarCategoryInfosReq = new GetAiAvatarCategoryInfosReq();
            getAiAvatarCategoryInfosReq.source = 0;
            getAiAvatarCategoryInfosReq.pageSize = 10;
            getAiAvatarCategoryInfosReq.isFirstFetch = true;
            final int f16 = this.firstPageLifecycleCallback.f(lifecycleOwner, callback);
            final int f17 = this.actionStatusLifecycleCallback.f(lifecycleOwner, actionStatusCallback);
            b16.getAiAvatarCategoryInfos(getAiAvatarCategoryInfosReq, false, new IGetAiAvatarCategoryInfosCallback() { // from class: com.tencent.mobileqq.ai.main.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAiAvatarCategoryInfosCallback
                public final void onResult(int i3, String str, GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp) {
                    l.k(y.this, getAiAvatarCategoryInfosReq, this, f16, f17, i3, str, getAiAvatarCategoryInfosRsp);
                }
            });
        }
    }

    public final void o(@NotNull LifecycleOwner lifecycleOwner, @NotNull final AIAvatarFeedsTabInfo tabInfo, @NotNull Function2<? super Boolean, ? super List<com.tencent.mobileqq.ai.main.feeds.a>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, lifecycleOwner, tabInfo, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final b bVar = this.requestState.get(tabInfo);
        if (bVar == null) {
            bVar = new b(0, false, false, 7, null);
            this.requestState.put(tabInfo, bVar);
        }
        if (!bVar.c() && bVar.a()) {
            bVar.f(true);
            bVar.e(bVar.b() + 1);
            if (QLog.isColorLevel()) {
                QLog.d("AIAvatarMainRepo", 2, "requestNextPage: tabInfo=" + tabInfo + ", nextPage=" + bVar.b());
            }
            y b16 = INSTANCE.b();
            if (b16 != null) {
                GetAiAvatarCategoryInfosReq getAiAvatarCategoryInfosReq = new GetAiAvatarCategoryInfosReq();
                getAiAvatarCategoryInfosReq.source = 0;
                getAiAvatarCategoryInfosReq.categoryId = tabInfo.getId();
                getAiAvatarCategoryInfosReq.page = bVar.b();
                getAiAvatarCategoryInfosReq.pageSize = 10;
                final int f16 = this.nextPageLifecycleCallback.f(lifecycleOwner, callback);
                b16.getAiAvatarCategoryInfos(getAiAvatarCategoryInfosReq, true, new IGetAiAvatarCategoryInfosCallback() { // from class: com.tencent.mobileqq.ai.main.i
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAiAvatarCategoryInfosCallback
                    public final void onResult(int i3, String str, GetAiAvatarCategoryInfosRsp getAiAvatarCategoryInfosRsp) {
                        l.p(AIAvatarFeedsTabInfo.this, this, bVar, f16, i3, str, getAiAvatarCategoryInfosRsp);
                    }
                });
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarMainRepo", 2, "requestNextPage: interrupt, tabInfo=" + tabInfo + ", state=" + bVar);
        }
    }

    public final void s(@NotNull final a actionInfo) {
        ArrayList<AiAvatarActionStatus> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) actionInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        y b16 = INSTANCE.b();
        if (b16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(actionInfo.d());
            b16.setAiAvatarActionStatus(arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.ai.main.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    l.t(a.this, i3, str);
                }
            });
        }
    }
}
