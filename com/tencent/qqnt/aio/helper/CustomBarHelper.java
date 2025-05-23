package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.event.AIOTopTipEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001d\b\u0007\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b\u001e\u0010'R$\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000b0)j\b\u0012\u0004\u0012\u00020\u000b`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/helper/CustomBarHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "g", "Lcom/tencent/qqnt/aio/helper/bd;", "bar", "i", tl.h.F, "", "insertId", "c", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "com/tencent/qqnt/aio/helper/CustomBarHelper$b", "e", "Lcom/tencent/qqnt/aio/helper/CustomBarHelper$b;", "action", "", "f", "Z", "isViewAdded", "Landroid/widget/LinearLayout;", "Lkotlin/Lazy;", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "currentShowIds", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes23.dex */
public final class CustomBarHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isViewAdded;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> currentShowIds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/helper/CustomBarHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.CustomBarHelper$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/CustomBarHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomBarHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                CustomBarHelper.this.g(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CustomBarHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.action = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.qqnt.aio.helper.CustomBarHelper$rootView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CustomBarHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                com.tencent.aio.api.runtime.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                aVar = CustomBarHelper.this.aioContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar = null;
                }
                Context context = aVar.c().getContext();
                Intrinsics.checkNotNull(context);
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                return linearLayout;
            }
        });
        this.rootView = lazy;
        this.currentShowIds = new ArrayList<>();
    }

    private final int c(int insertId) {
        Iterator<Integer> it = this.currentShowIds.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Integer showId = it.next();
            Intrinsics.checkNotNullExpressionValue(showId, "showId");
            if (insertId < showId.intValue()) {
                break;
            }
            i3++;
        }
        return i3;
    }

    private final LinearLayout e() {
        return (LinearLayout) this.rootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(MsgIntent intent) {
        if (intent instanceof ShowBarIntent) {
            i(((ShowBarIntent) intent).a());
        } else if (intent instanceof HideBarIntent) {
            h(((HideBarIntent) intent).a());
        }
    }

    private final void h(bd bar) {
        if (this.currentShowIds.contains(Integer.valueOf(bar.b()))) {
            this.currentShowIds.remove(Integer.valueOf(bar.b()));
            e().removeView(bar.getView());
        }
    }

    private final void i(bd bar) {
        if (this.currentShowIds.contains(Integer.valueOf(bar.b()))) {
            return;
        }
        int c16 = c(bar.b());
        this.currentShowIds.add(c16, Integer.valueOf(bar.b()));
        e().addView(bar.getView(), c16);
        if (!this.isViewAdded) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar = null;
            }
            aVar.e().h(new AIOTopTipEvent.ShowCustomBar(e()));
            this.isViewAdded = true;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.f350622c;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.helper.ShowBarIntent");
        hashSet.add("com.tencent.qqnt.aio.helper.HideBarIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "CustomBarHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        a16.e().f(this, this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().i(this, this.action);
        this.isViewAdded = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
        }
    }
}
