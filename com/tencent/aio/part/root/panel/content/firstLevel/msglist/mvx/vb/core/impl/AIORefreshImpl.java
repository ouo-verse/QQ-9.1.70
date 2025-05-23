package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001mB%\u0012\u0006\u0010d\u001a\u00020b\u0012\u0006\u0010g\u001a\u00020e\u0012\f\u0010j\u001a\b\u0012\u0004\u0012\u00020h0%\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\b*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u000f\u0010\u0014\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\b\u0010 \u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016J\u0016\u0010'\u001a\u00020\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016J\u0016\u0010)\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*H\u0016R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00104\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\"\u0010:\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010>\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010.\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\u0016\u0010A\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010@R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER*\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR*\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010J\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010NR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010\\\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010U\u001a\u0004\bZ\u0010W\"\u0004\b[\u0010YR\"\u0010_\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010.\u001a\u0004\b]\u00107\"\u0004\b^\u00109R\"\u0010a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010.\u001a\u0004\b@\u00107\"\u0004\b`\u00109R\u0014\u0010d\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010cR\u0014\u0010g\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010fR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020h0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010i\u00a8\u0006n"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl;", "Lcom/tencent/aio/api/refreshLoad/c;", "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "anchor", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", HippyTKDListViewAdapter.X, "Landroidx/recyclerview/widget/AIOLayoutManager;", "O", "N", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;", "refreshType", "v", "loadType", "u", "M", "()V", "Lcom/tencent/aio/api/refreshLoad/c$b;", "listener", "l", "enable", "a", "setEnableLoadMore", "finishRefresh", "j", BdhLogUtil.LogTag.Tag_Conn, "B", "k", "", "time", UserInfo.SEX_FEMALE, "c", "Lkotlin/Function0;", "function", ReportConstant.COSTREPORT_PREFIX, "action", "r", "", "movieDistance", "t", "d", "Z", "isEnableRefresh", "e", "isEnableLoadMore", "f", "Lcom/tencent/aio/api/refreshLoad/c$b;", "refreshLoadMoreListener", h.F, "L", "()Z", "W", "(Z)V", "isRefreshing", "i", "I", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isLoadingMore", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "autoFinishRefreshTime", "autoFinishLoadMoreTime", "Lkotlinx/coroutines/Job;", "D", "Lkotlinx/coroutines/Job;", "refreshJob", "E", "loadMoreJob", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getRefreshHeadAnchorView", "()Ljava/lang/ref/WeakReference;", "U", "(Ljava/lang/ref/WeakReference;)V", "refreshHeadAnchorView", "G", "getRefreshFooterAnchorView", "T", "refreshFooterAnchorView", "H", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;", "getRefreshType", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;", "V", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;)V", "getLoadMoreType", "P", "loadMoreType", "K", ExifInterface.LATITUDE_SOUTH, "isReadyRefreshFinish", BdhLogUtil.LogTag.Tag_Req, "isReadyLoadMoreFinish", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/b;", "refreshHolder", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/jvm/functions/Function0;", "scopeOwner", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/b;Lkotlin/jvm/functions/Function0;)V", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class AIORefreshImpl implements com.tencent.aio.api.refreshLoad.c {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long autoFinishLoadMoreTime;

    /* renamed from: D, reason: from kotlin metadata */
    private Job refreshJob;

    /* renamed from: E, reason: from kotlin metadata */
    private Job loadMoreJob;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private WeakReference<View> refreshHeadAnchorView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private WeakReference<View> refreshFooterAnchorView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private RefreshType refreshType;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private RefreshType loadMoreType;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isReadyRefreshFinish;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isReadyLoadMoreFinish;

    /* renamed from: L, reason: from kotlin metadata */
    private final RecyclerView recyclerView;

    /* renamed from: M, reason: from kotlin metadata */
    private final b refreshHolder;

    /* renamed from: N, reason: from kotlin metadata */
    private final Function0<CoroutineScope> scopeOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableRefresh;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableLoadMore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private c.b refreshLoadMoreListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isRefreshing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long autoFinishRefreshTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl$a", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/c;", "", "a", "e", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a implements c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) AIORefreshImpl.this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
            }
            return AIORefreshImpl.this.refreshHolder.a();
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.c
        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return AIORefreshImpl.this.refreshHolder.e();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/AIORefreshImpl$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$b, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48608);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIORefreshImpl(@NotNull RecyclerView recyclerView, @NotNull b refreshHolder, @NotNull Function0<? extends CoroutineScope> scopeOwner) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(refreshHolder, "refreshHolder");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, recyclerView, refreshHolder, scopeOwner);
            return;
        }
        this.recyclerView = recyclerView;
        this.refreshHolder = refreshHolder;
        this.scopeOwner = scopeOwner;
        this.autoFinishRefreshTime = Long.MAX_VALUE;
        this.autoFinishLoadMoreTime = Long.MAX_VALUE;
        RefreshType refreshType = RefreshType.RefreshInit;
        this.refreshType = refreshType;
        this.loadMoreType = refreshType;
        O().setLadingVisible$sdk_debug(new a());
    }

    private final void A() {
        RefreshType refreshType = this.refreshType;
        if (refreshType == RefreshType.LoadingRefresh) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishRefresh[invokeLoading]");
            C();
            RefreshExtKt.f(this);
            return;
        }
        if (refreshType == RefreshType.PreRefresh) {
            if (!this.refreshHolder.a()) {
                RefreshExtKt.f(this);
                com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishRefresh[preLoading]");
            } else if (this.refreshHolder.a()) {
                if (this.refreshHolder.f()) {
                    com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishRefresh[headLoading]");
                    C();
                    RefreshExtKt.f(this);
                } else {
                    this.isReadyRefreshFinish = true;
                    com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishRefresh[readyFinsh]");
                }
            }
        }
    }

    private final void N() {
        Job job = this.refreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.loadMoreJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    private final AIOLayoutManager O() {
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return (AIOLayoutManager) layoutManager;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.AIOLayoutManager");
    }

    private final boolean q(View view, View view2) {
        int i3;
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkAnchorY newAnchor ");
            sb5.append(view.hashCode());
            sb5.append("  oldAnchor ");
            if (view2 != null) {
                i3 = view2.hashCode();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            aVar.e("AIORefreshImpl", sb5.toString());
        }
        if (view2 == null || !Intrinsics.areEqual(view, view2) || view.getTop() != view2.getTop()) {
            return false;
        }
        return true;
    }

    private final View w() {
        AIOLayoutManager O = O();
        return O.findViewByPosition(O.findLastVisibleItemPosition());
    }

    private final View x() {
        AIOLayoutManager O = O();
        return O.findViewByPosition(O.findFirstVisibleItemPosition());
    }

    private final void z() {
        RefreshType refreshType = this.loadMoreType;
        if (refreshType == RefreshType.LoadingLoadMore) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishLoadMore[loadingInvoke]");
            B();
            RefreshExtKt.e(this);
            return;
        }
        if (refreshType == RefreshType.PreLoadMore) {
            if (!this.refreshHolder.e()) {
                com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishLoadMore[preLoading]");
                RefreshExtKt.e(this);
            } else if (this.refreshHolder.e()) {
                if (this.refreshHolder.g()) {
                    B();
                    RefreshExtKt.e(this);
                    com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishLoadMore[footerLoading]");
                } else {
                    com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "handleFinishLoadMore[readyFinish]");
                    this.isReadyLoadMoreFinish = true;
                }
            }
        }
    }

    public final void B() {
        Integer num;
        View it;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleLoadMoreFinishScroll ");
        WeakReference<View> weakReference = this.refreshFooterAnchorView;
        if (weakReference != null && (view = weakReference.get()) != null) {
            num = Integer.valueOf(view.hashCode());
        } else {
            num = null;
        }
        sb5.append(num);
        aVar.d("AIORefreshImpl", sb5.toString());
        WeakReference<View> weakReference2 = this.refreshFooterAnchorView;
        if (weakReference2 != null && (it = weakReference2.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (q(it, w())) {
                this.refreshHolder.h(new Function1<Integer, Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$handleLoadMoreFinishScroll$$inlined$let$lambda$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIORefreshImpl.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num2) {
                        invoke(num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        RecyclerView recyclerView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                            return;
                        }
                        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "closeFooter " + i3 + "   footerViewHeight " + AIORefreshImpl.this.refreshHolder.d());
                        recyclerView = AIORefreshImpl.this.recyclerView;
                        recyclerView.scrollBy(0, AIORefreshImpl.this.refreshHolder.d());
                    }
                });
            } else {
                this.refreshHolder.h(new Function1<Integer, Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$handleLoadMoreFinishScroll$$inlined$let$lambda$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIORefreshImpl.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num2) {
                        invoke(num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        RecyclerView recyclerView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                            return;
                        }
                        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "closeFooter  " + i3 + '}');
                        recyclerView = AIORefreshImpl.this.recyclerView;
                        recyclerView.scrollBy(0, i3);
                    }
                });
            }
        }
    }

    public final void C() {
        Integer num;
        View it;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleRefreshFinishScroll ");
        WeakReference<View> weakReference = this.refreshHeadAnchorView;
        if (weakReference != null && (view = weakReference.get()) != null) {
            num = Integer.valueOf(view.hashCode());
        } else {
            num = null;
        }
        sb5.append(num);
        aVar.d("AIORefreshImpl", sb5.toString());
        WeakReference<View> weakReference2 = this.refreshHeadAnchorView;
        if (weakReference2 != null && (it = weakReference2.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (q(it, x())) {
                this.refreshHolder.j(new Function1<Integer, Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$handleRefreshFinishScroll$$inlined$let$lambda$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIORefreshImpl.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num2) {
                        invoke(num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        RecyclerView recyclerView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                            return;
                        }
                        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "closeHeadLayout " + i3 + "   headViewHeight " + AIORefreshImpl.this.refreshHolder.b());
                        recyclerView = AIORefreshImpl.this.recyclerView;
                        recyclerView.scrollBy(0, -AIORefreshImpl.this.refreshHolder.b());
                    }
                });
            } else {
                this.refreshHolder.j(new Function1<Integer, Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$handleRefreshFinishScroll$$inlined$let$lambda$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIORefreshImpl.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num2) {
                        invoke(num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        RecyclerView recyclerView;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                            return;
                        }
                        recyclerView = AIORefreshImpl.this.recyclerView;
                        recyclerView.scrollBy(0, -i3);
                        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "closeHeadLayout " + i3);
                    }
                });
            }
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    @Deprecated(message = "\u5e9f\u5f03")
    public void D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
        } else {
            c.a.b(this, i3);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    @Deprecated(message = "\u5e9f\u5f03")
    public void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
        } else {
            c.a.a(this, i3);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void F(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, time);
        } else {
            this.autoFinishRefreshTime = time;
        }
    }

    public final boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isLoadingMore;
    }

    public final boolean J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.isReadyLoadMoreFinish;
    }

    public final boolean K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.isReadyRefreshFinish;
    }

    public final boolean L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.isRefreshing;
    }

    public final void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            RefreshExtKt.b(this);
            RefreshExtKt.a(this);
        }
    }

    public final void P(@NotNull RefreshType refreshType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) refreshType);
        } else {
            Intrinsics.checkNotNullParameter(refreshType, "<set-?>");
            this.loadMoreType = refreshType;
        }
    }

    public final void Q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isLoadingMore = z16;
        }
    }

    public final void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.isReadyLoadMoreFinish = z16;
        }
    }

    public final void S(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.isReadyRefreshFinish = z16;
        }
    }

    public final void T(@Nullable WeakReference<View> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) weakReference);
        } else {
            this.refreshFooterAnchorView = weakReference;
        }
    }

    public final void U(@Nullable WeakReference<View> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) weakReference);
        } else {
            this.refreshHeadAnchorView = weakReference;
        }
    }

    public final void V(@NotNull RefreshType refreshType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) refreshType);
        } else {
            Intrinsics.checkNotNullParameter(refreshType, "<set-?>");
            this.refreshType = refreshType;
        }
    }

    public final void W(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.isRefreshing = z16;
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void a(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, enable);
            return;
        }
        if (this.isEnableRefresh == enable) {
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "setEnableRefresh " + enable);
        if (enable) {
            this.refreshHolder.setRefresher(this);
        }
        this.isEnableRefresh = enable;
        this.refreshHolder.c(enable);
        if (!this.isEnableRefresh) {
            RefreshExtKt.b(this);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void c(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, time);
        } else {
            this.autoFinishLoadMoreTime = time;
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void finishRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "finishRefresh " + this.refreshType);
        A();
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "finishLoadMore " + this.loadMoreType + TokenParser.SP);
        z();
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        if (aVar.isColorLevel()) {
            aVar.d("AIORefreshImpl", "resetRefreshLoadMore");
        }
        this.isEnableRefresh = false;
        this.isEnableLoadMore = false;
        this.isRefreshing = false;
        this.isLoadingMore = false;
        this.refreshHolder.c(false);
        this.refreshHolder.k(false);
        N();
        RefreshExtKt.f(this);
        RefreshExtKt.e(this);
        this.isReadyLoadMoreFinish = false;
        this.isReadyRefreshFinish = false;
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void l(@NotNull c.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.refreshLoadMoreListener = listener;
        }
    }

    public void r(@NotNull Function0<Unit> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.isEnableLoadMore) {
            action.invoke();
        }
    }

    public void s(@NotNull Function0<Unit> function) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) function);
            return;
        }
        Intrinsics.checkNotNullParameter(function, "function");
        if (this.isEnableRefresh) {
            function.invoke();
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void setEnableLoadMore(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, enable);
            return;
        }
        if (this.isEnableLoadMore == enable) {
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "setEnableLoadMore " + enable);
        if (enable) {
            this.refreshHolder.setRefresher(this);
        }
        this.isEnableLoadMore = enable;
        this.refreshHolder.k(enable);
        if (!this.isEnableLoadMore) {
            RefreshExtKt.a(this);
        }
    }

    public void t(float movieDistance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Float.valueOf(movieDistance));
            return;
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "dispatchOnBoundeMove  " + movieDistance);
        }
        if (movieDistance != 0.0f) {
            O().clearAsnyAnchor$sdk_debug();
        }
    }

    public void u(@NotNull final RefreshType loadType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) loadType);
            return;
        }
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "dispatchOnLoadMore " + loadType + TokenParser.SP);
        }
        this.refreshFooterAnchorView = new WeakReference<>(w());
        RefreshExtKt.c(this, loadType, new Function0<Unit>(loadType) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$dispatchOnLoadMore$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ RefreshType $loadType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
            @DebugMetadata(c = "com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$dispatchOnLoadMore$2$1", f = "AIORefreshImpl.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$dispatchOnLoadMore$2$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                int label;

                AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) AIORefreshImpl$dispatchOnLoadMore$2.this, (Object) continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
                    }
                    Intrinsics.checkNotNullParameter(completion, "completion");
                    return new AnonymousClass1(completion);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                    }
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    long j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            j3 = AIORefreshImpl.this.autoFinishLoadMoreTime;
                            this.label = 1;
                            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (AIORefreshImpl.this.I()) {
                            com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "autoFinishLoadMore");
                            AIORefreshImpl.this.j();
                        }
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 1, (Object) this, obj);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$loadType = loadType;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIORefreshImpl.this, (Object) loadType);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                c.b bVar;
                Job job;
                Function0 function0;
                Job launch$default;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "realdispatchOnLoadMore  " + this.$loadType);
                bVar = AIORefreshImpl.this.refreshLoadMoreListener;
                if (bVar != null) {
                    bVar.s();
                }
                job = AIORefreshImpl.this.loadMoreJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                AIORefreshImpl aIORefreshImpl = AIORefreshImpl.this;
                function0 = aIORefreshImpl.scopeOwner;
                launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) function0.invoke(), Dispatchers.getMain(), null, new AnonymousClass1(null), 2, null);
                aIORefreshImpl.loadMoreJob = launch$default;
            }
        });
    }

    public void v(@NotNull final RefreshType refreshType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) refreshType);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "dispatchOnRefresh " + refreshType + TokenParser.SP);
        }
        this.refreshHeadAnchorView = new WeakReference<>(x());
        RefreshExtKt.d(this, refreshType, new Function0<Unit>(refreshType) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$dispatchOnRefresh$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ RefreshType $refreshType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
            @DebugMetadata(c = "com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$dispatchOnRefresh$2$1", f = "AIORefreshImpl.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.AIORefreshImpl$dispatchOnRefresh$2$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                int label;

                AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) AIORefreshImpl$dispatchOnRefresh$2.this, (Object) continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
                    }
                    Intrinsics.checkNotNullParameter(completion, "completion");
                    return new AnonymousClass1(completion);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                    }
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    long j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            j3 = AIORefreshImpl.this.autoFinishRefreshTime;
                            this.label = 1;
                            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (AIORefreshImpl.this.L()) {
                            com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "autoFinishRefresh");
                            AIORefreshImpl.this.finishRefresh();
                        }
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 1, (Object) this, obj);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$refreshType = refreshType;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AIORefreshImpl.this, (Object) refreshType);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                c.b bVar;
                Job job;
                Function0 function0;
                Job launch$default;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                com.tencent.aio.base.log.a.f69187b.d("AIORefreshImpl", "realdispatchOnRefresh " + this.$refreshType);
                bVar = AIORefreshImpl.this.refreshLoadMoreListener;
                if (bVar != null) {
                    bVar.onRefresh();
                }
                job = AIORefreshImpl.this.refreshJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                AIORefreshImpl aIORefreshImpl = AIORefreshImpl.this;
                function0 = aIORefreshImpl.scopeOwner;
                launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) function0.invoke(), Dispatchers.getMain(), null, new AnonymousClass1(null), 2, null);
                aIORefreshImpl.refreshJob = launch$default;
            }
        });
    }
}
