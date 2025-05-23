package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.aio.api.list.IBounceScrollApi;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.api.list.IScreenRenderingApi;
import com.tencent.aio.api.list.g;
import com.tencent.aio.api.list.l;
import com.tencent.aio.api.list.o;
import com.tencent.aio.api.refreshLoad.c;
import com.tencent.aio.exception.AIOException;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.aio.widget.bounce.AIORefreshLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001GB\u0017\u0012\u000e\u0010n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030l\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0011\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0013H\u0097\u0001J\u0011\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H\u0096\u0001J\u0012\u0010%\u001a\u0004\u0018\u00010$H\u0096\u0001\u00a2\u0006\u0004\b%\u0010&J'\u0010+\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0096\u0001J/\u0010-\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00132\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0096\u0001J\u001d\u00100\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010/H\u0096\u0001J\u0011\u00102\u001a\u00020\u00112\u0006\u0010!\u001a\u000201H\u0096\u0001J\t\u00103\u001a\u00020\u0011H\u0096\u0001J\t\u00104\u001a\u00020\u0011H\u0096\u0001J\u0011\u00106\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0013H\u0096\u0001J\u0011\u00109\u001a\u00020\u00112\u0006\u00108\u001a\u000207H\u0096\u0001J\u0011\u0010;\u001a\u00020\u00112\u0006\u0010:\u001a\u00020$H\u0096\u0001J\u0011\u0010<\u001a\u00020\u00112\u0006\u0010:\u001a\u00020$H\u0096\u0001J\u0011\u0010>\u001a\u00020\u00112\u0006\u0010=\u001a\u00020'H\u0096\u0001J\t\u0010?\u001a\u00020\u0011H\u0096\u0001J\t\u0010@\u001a\u00020\u0011H\u0096\u0001J\t\u0010A\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010C\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0013H\u0097\u0001J\u0011\u0010E\u001a\u00020\u00112\u0006\u00108\u001a\u00020DH\u0096\u0001J\u0011\u0010F\u001a\u00020\u00112\u0006\u0010=\u001a\u00020'H\u0096\u0001J\u0011\u0010G\u001a\u00020\u00112\u0006\u0010=\u001a\u00020'H\u0096\u0001J\u0011\u0010I\u001a\u00020\u00112\u0006\u0010!\u001a\u00020HH\u0096\u0001J\u0011\u0010J\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0013H\u0097\u0001J\u0019\u0010N\u001a\u00020\u00112\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u0013H\u0096\u0001J)\u0010S\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010R\u0012\u0006\u0012\u0004\u0018\u00010R0Q2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u0013H\u0096\u0001J\u0013\u0010T\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010U\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\t\u0010V\u001a\u00020\u0011H\u0097\u0001J\u0019\u0010Y\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\u0013H\u0096\u0001J\u0019\u0010\\\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\u0013H\u0096\u0001J#\u0010_\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\u00132\b\u0010^\u001a\u0004\u0018\u00010]H\u0096\u0001J\u0019\u0010`\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\u0013H\u0096\u0001J\u0019\u0010a\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010b\u001a\u00020\u00112\u0006\u0010L\u001a\u00020KH\u0096\u0001J\t\u0010c\u001a\u00020\u0011H\u0096\u0001J\t\u0010d\u001a\u00020\u0011H\u0097\u0001J\u0011\u0010g\u001a\u00020\u00112\u0006\u0010f\u001a\u00020eH\u0096\u0001J\t\u0010h\u001a\u00020\u0011H\u0097\u0001J\t\u0010i\u001a\u00020\u0011H\u0096\u0001J\t\u0010j\u001a\u00020\u0011H\u0096\u0001J\t\u0010k\u001a\u00020\u0011H\u0096\u0001R\u001c\u0010n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010m\u00a8\u0006q"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/ListUIOperationApiImpl;", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "Lcom/tencent/aio/api/list/IScreenRenderingApi;", "Lxs/a;", "Lcom/tencent/aio/api/list/IBounceScrollApi;", "Lcom/tencent/aio/api/refreshLoad/c;", "Lcom/tencent/aio/api/list/e;", "Lcom/tencent/aio/api/list/o;", "Lvs/a;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/recyclerview/widget/AIORecycleView;", "i", "", "Lcom/tencent/aio/data/msglist/a;", "t", "Lcom/tencent/aio/api/list/g$b;", "action", "", DomainData.DOMAIN_NAME, "", "position", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "G", "reset", "mode", "i0", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "M", "Lcom/tencent/aio/api/list/l;", "listener", ReportConstant.COSTREPORT_PREFIX, "J0", "", "f", "()Ljava/lang/Long;", "", "baseBottom", "Lxs/a$b;", "completeListener", "p", "offset", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "msgPosition", "Lxs/a$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/list/IBounceScrollApi$b;", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "N", Element.ELEMENT_NAME_DISTANCE, "setNestedBottomPadding", "Lcom/tencent/aio/api/list/IBounceScrollApi$a;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "setOverScrollStrategy", "time", "c", UserInfo.SEX_FEMALE, "enable", "H", "j", "finishRefresh", "k", "preloadNum", "E", "Lcom/tencent/aio/api/refreshLoad/a;", "y", "setEnableLoadMore", "a", "Lcom/tencent/aio/api/refreshLoad/c$b;", "l", "D", "Landroid/view/View;", "view", "index", "B", "startPosition", "endPosition", "Lkotlin/Pair;", "Lcom/tencent/aio/api/vo/a;", "J", HippyTKDListViewAdapter.X, "w", "notifyDataSetChanged", "fromPosition", "toPosition", "v", "positionStart", "itemCount", "d", "", "payload", "u", h.F, "e", "K", "o", "O", "Lcom/tencent/aio/api/list/o$a;", "holder", "I", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "g", "b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "absListVB", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ListUIOperationApiImpl implements IListUIOperationApi, IScreenRenderingApi, xs.a, IBounceScrollApi, com.tencent.aio.api.refreshLoad.c, com.tencent.aio.api.list.e, o, vs.a, LifecycleEventObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final /* synthetic */ SkeletonImpl C;
    private final /* synthetic */ ListUICacheImpl D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AbsMsgListVB<?, ?> absListVB;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ f f69601e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ d f69602f;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ AIORefreshLayout f69603h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ PreLoadRefreshImpl f69604i;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ a f69605m;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListUIOperationApiImpl$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        static IPatchRedirector $redirector_;

        AnonymousClass1(AbsMsgListVB absMsgListVB) {
            super(0, absMsgListVB, AbsMsgListVB.class, "getFocusIndex", "getFocusIndex$sdk_debug()Ljava/lang/Long;", 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) absMsgListVB);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Long invoke() {
            return ((AbsMsgListVB) this.receiver).m1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/ListUIOperationApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListUIOperationApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48656);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ListUIOperationApiImpl(@NotNull AbsMsgListVB<?, ?> absListVB) {
        Intrinsics.checkNotNullParameter(absListVB, "absListVB");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) absListVB);
            return;
        }
        this.f69601e = new f(absListVB.q1());
        this.f69602f = new d(absListVB.q1(), new AnonymousClass1(absListVB));
        this.f69603h = absListVB.k1();
        this.f69604i = new PreLoadRefreshImpl(absListVB.q1(), absListVB.k1(), new Function0<CoroutineScope>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListUIOperationApiImpl.2
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? AbsMsgListVB.this.h1() : (CoroutineScope) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.f69605m = new a(absListVB.j1(), absListVB.i1());
        this.C = new SkeletonImpl(absListVB.k1());
        this.D = new ListUICacheImpl(absListVB.q1());
        this.absListVB = absListVB;
    }

    @Override // vs.a
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
        } else {
            this.D.A();
        }
    }

    @Override // com.tencent.aio.api.list.c
    public void B(@NotNull View view, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) view, index);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f69605m.B(view, index);
        }
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void C(@NotNull IBounceScrollApi.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f69603h.C(listener);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    @Deprecated(message = "\u5e9f\u5f03")
    public void D(int preloadNum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, preloadNum);
        } else {
            this.f69604i.D(preloadNum);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    @Deprecated(message = "\u5e9f\u5f03")
    public void E(int preloadNum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, preloadNum);
        } else {
            this.f69604i.E(preloadNum);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void F(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, time);
        } else {
            this.f69604i.F(time);
        }
    }

    @Override // com.tencent.aio.api.list.IListUIOperationApi
    @Nullable
    public RecyclerView.ViewHolder G(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, position);
        }
        int n06 = this.absListVB.j1().n0() + position;
        if (n06 < this.absListVB.j1().n0() + this.absListVB.j1().o0()) {
            return this.absListVB.q1().findViewHolderForAdapterPosition(n06);
        }
        if (!com.tencent.aio.base.a.f69150c.a()) {
            return null;
        }
        throw new AIOException("this is inCorrect position " + position + "    ");
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    public void H(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, enable);
        } else {
            this.f69604i.H(enable);
        }
    }

    @Override // com.tencent.aio.api.list.o
    public void I(@NotNull o.a holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            this.C.I(holder);
        }
    }

    @Override // com.tencent.aio.api.list.e
    @NotNull
    public Pair<com.tencent.aio.api.vo.a, com.tencent.aio.api.vo.a> J(int startPosition, int endPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (Pair) iPatchRedirector.redirect((short) 39, this, Integer.valueOf(startPosition), Integer.valueOf(endPosition));
        }
        return this.f69605m.J(startPosition, endPosition);
    }

    @Override // com.tencent.aio.api.list.IScreenRenderingApi
    public void J0(@NotNull l listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f69601e.J0(listener);
        }
    }

    @Override // com.tencent.aio.api.list.c
    public void K(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f69605m.K(view);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void M(int event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, event);
        } else {
            this.f69601e.a(event);
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.f69603h.Y();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
        } else {
            this.C.f();
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void a(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, enable);
        } else {
            this.f69604i.a(enable);
        }
    }

    @Override // vs.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this);
        } else {
            this.D.b();
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void c(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, time);
        } else {
            this.f69604i.c(time);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void d(int positionStart, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            this.f69605m.d(positionStart, itemCount);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void e(int positionStart, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            this.f69605m.e(positionStart, itemCount);
        }
    }

    @Override // xs.a
    @Nullable
    public Long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Long) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f69602f.f();
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void finishRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            this.f69604i.finishRefresh();
        }
    }

    @Override // vs.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
        } else {
            this.D.g();
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void h(int positionStart, int itemCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
        } else {
            this.f69605m.h(positionStart, itemCount);
        }
    }

    @Override // com.tencent.aio.api.list.IListUIOperationApi
    @NotNull
    public AIORecycleView i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIORecycleView) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.absListVB.q1();
    }

    @Override // com.tencent.aio.api.list.IListUIOperationApi
    public void i0(int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, mode);
            return;
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a.f69187b.d("ListUIOperationApiImpl", "arrangeCellMode " + mode);
        }
        if (mode == 1) {
            this.absListVB.q1().getLayoutManager().setNeedTopToBottom$sdk_debug(true);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            this.f69604i.j();
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            this.f69604i.k();
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void l(@NotNull c.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f69604i.l(listener);
        }
    }

    @Override // xs.a
    public void m(int msgPosition, @Nullable a.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, msgPosition, (Object) listener);
        } else {
            this.f69602f.m(msgPosition, listener);
        }
    }

    @Override // com.tencent.aio.api.list.g
    public void n(@NotNull g.b<com.tencent.aio.data.msglist.a> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        if (action.a() == null) {
            action.d(this.absListVB.h1());
        }
        action.e(new ListUIOperationApiImpl$submitList$1(this, action, action.c()));
        this.absListVB.j1().j0().n(action);
    }

    @Override // com.tencent.aio.api.list.d
    @SuppressLint({"NotifyDataSetChanged"})
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            this.f69605m.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.aio.api.list.o
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
        } else {
            this.C.o();
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) source, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            r();
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            source.getLifecycle().removeObserver(this);
        }
    }

    @Override // xs.a
    public boolean p(int position, boolean baseBottom, @Nullable a.b completeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(position), Boolean.valueOf(baseBottom), completeListener)).booleanValue();
        }
        return this.f69602f.p(position, baseBottom, completeListener);
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.f69603h.q();
        }
    }

    @Override // com.tencent.aio.api.list.o
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        } else {
            this.C.r();
        }
    }

    @Override // com.tencent.aio.api.list.IListUIOperationApi
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        N();
        k();
        O();
    }

    @Override // com.tencent.aio.api.list.IScreenRenderingApi
    public void s(@NotNull l listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f69601e.s(listener);
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.c
    public void setEnableLoadMore(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, enable);
        } else {
            this.f69604i.setEnableLoadMore(enable);
        }
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void setNestedBottomPadding(int distance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, distance);
        } else {
            this.f69603h.setNestedBottomPadding(distance);
        }
    }

    @Override // com.tencent.aio.api.list.IBounceScrollApi
    public void setOverScrollStrategy(@NotNull IBounceScrollApi.a strategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) strategy);
        } else {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.f69603h.setOverScrollStrategy(strategy);
        }
    }

    @Override // com.tencent.aio.api.list.g
    @NotNull
    public List<com.tencent.aio.data.msglist.a> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.absListVB.j1().j0().t();
    }

    @Override // com.tencent.aio.api.list.d
    public void u(int positionStart, int itemCount, @Nullable Object payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount), payload);
        } else {
            this.f69605m.u(positionStart, itemCount, payload);
        }
    }

    @Override // com.tencent.aio.api.list.d
    public void v(int fromPosition, int toPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
        } else {
            this.f69605m.v(fromPosition, toPosition);
        }
    }

    @Override // com.tencent.aio.api.list.e
    public int w(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this, position)).intValue();
        }
        return this.f69605m.w(position);
    }

    @Override // com.tencent.aio.api.list.e
    @Nullable
    public com.tencent.aio.data.msglist.a x(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 40, (Object) this, position);
        }
        return this.f69605m.x(position);
    }

    @Override // com.tencent.aio.api.refreshLoad.b
    public void y(@NotNull com.tencent.aio.api.refreshLoad.a strategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) strategy);
        } else {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.f69604i.y(strategy);
        }
    }

    @Override // xs.a
    public boolean z(int position, boolean baseBottom, int offset, @Nullable a.b completeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(position), Boolean.valueOf(baseBottom), Integer.valueOf(offset), completeListener)).booleanValue();
        }
        return this.f69602f.z(position, baseBottom, offset, completeListener);
    }
}
